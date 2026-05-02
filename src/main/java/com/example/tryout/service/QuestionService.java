package com.example.tryout.service;

import com.example.tryout.DTO.QuestionBankRequest;
import com.example.tryout.DTO.QuestionRequest;
import com.example.tryout.DTO.SubjectMenuResponse;
import com.example.tryout.entity.Option;
import com.example.tryout.entity.Question;
import com.example.tryout.entity.QuestionBank;
import com.example.tryout.entity.Subject;
import com.example.tryout.repository.OptionRepository;
import com.example.tryout.repository.QuestionBankRepository;
import com.example.tryout.repository.QuestionRepository;
import com.example.tryout.repository.SubjectRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final QuestionBankRepository questionBankRepository;
    private final OptionRepository optionRepository;
    private final SubjectRepository subjectRepository;

    @Transactional
    public Question createQuestion(QuestionRequest request) {
        QuestionBank bank = questionBankRepository.findById(request.getBankId())
                .orElseThrow(() -> new RuntimeException("Question Bank tidak ditemukan"));

        Question question = new Question();
        question.setQuestionBank(bank);
        question.setContent(request.getContent());
        question.setMediaUrl(request.getMediaUrl());

        Question savedQuestion = questionRepository.save(question);

        List<Option> options = request.getOptions().stream().map(optReq -> {
            Option option = new Option();
            option.setQuestion(savedQuestion);
            option.setLabel(optReq.getLabel());
            option.setContent(optReq.getContent());
            option.setCorrect(optReq.isCorrect());
            return option;
        }).collect(Collectors.toList());

        optionRepository.saveAll(options);
        return savedQuestion;
    }

    @Transactional
    public QuestionBank createQuestionBank(QuestionBankRequest request) {
        // 1. Cari Subject-nya dulu di DB
        Subject subject = subjectRepository.findById(request.getSubjectId())
                .orElseThrow(() -> new RuntimeException("Subject tidak ditemukan"));

        // 2. Buat objek QuestionBank baru
        QuestionBank bank = new QuestionBank();
        bank.setSubject(subject);
        bank.setTitle(request.getTitle());
        bank.setPublished(true); // Default-kan aktif agar bisa langsung dipakai

        // 3. Simpan ke PostgreSQL
        return questionBankRepository.save(bank);
    }

    @Transactional(readOnly = true)
    public List<SubjectMenuResponse> getAllSubjectsForMenu() {
        List<Subject> subjects = subjectRepository.findAll();

        return subjects.stream().map(subject -> {
            // Ambil semua bank soal untuk setiap subject
            List<SubjectMenuResponse.QuestionBankSummary> banks = questionBankRepository.findBySubjectId(subject.getId())
                    .stream()
                    .map(bank -> new SubjectMenuResponse.QuestionBankSummary(bank.getId(), bank.getTitle()))
                    .collect(Collectors.toList());

            return new SubjectMenuResponse(
                    subject.getId(),
                    subject.getName(),
                    banks
            );
        }).collect(Collectors.toList());
    }
}
