package jaein.spring;

import jaein.spring.question.Question;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbQuestion();
        initService.dbAnswer();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;

        public void dbQuestion() {
            Question q1 = new Question();
            q1.setSubject("테스트 질문입니다.");
            q1.setContent("테스트 내용입니다.");
            q1.setCreateDate(LocalDateTime.now());
            em.persist(q1);
        }

        public void dbAnswer() {

        }
    }

}
