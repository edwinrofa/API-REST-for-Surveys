package com.consumersurvey;

import com.consumersurvey.dto.QuestionDTO;
import com.consumersurvey.model.Options;
import com.consumersurvey.model.Question;
import com.consumersurvey.model.Survey;
import com.consumersurvey.service.SurveyService;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConsumerSurveyApplication implements CommandLineRunner {

    @Autowired
    private SurveyService surveyService;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerSurveyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Survey survey = new Survey();
        survey.setSurveyName("Survey to measure customer satisfaction");
        Question question1 = new Question(QuestionDTO.OPEN, "¿Cuál es la comida que más prefieres del restaurante?", survey);
        Question question2 = new Question(QuestionDTO.OPEN, "¿Le hablarías a tus amigos de nuestros servicios?", survey);
        Question question3 = new Question(QuestionDTO.OPEN, "¿Compartirías por redes sociales nuestro negocio?", survey);
        Question question4 = new Question(QuestionDTO.MULTIPLE_CHOICE, "¿Qué días de la semana prefieres solicitar domicilios?", survey);
        Options option1 = new Options("Lunes", question4);
        Options option2 = new Options("Martes", question4);
        Options option3 = new Options("Miércoles", question4);
        Options option4 = new Options("Jueves", question4);
        Options option5 = new Options("Viernes", question4);
        Options option6 = new Options("Sábado", question4);
        Options option7 = new Options("Domingo", question4);
        List<Options> loptions = new ArrayList<>();
        loptions.add(option1);
        loptions.add(option2);
        loptions.add(option3);
        loptions.add(option4);
        loptions.add(option5);
        loptions.add(option6);
        loptions.add(option7);
        question4.setOptionList(loptions);
        Question question5 = new Question(QuestionDTO.MULTIPLE_CHOICE, "¿En qué horarios sueles solicitar más domicilios?", survey);
        Options opt1 = new Options("Mañana", question5);
        Options opt2 = new Options("Medio día", question5);
        Options opt3 = new Options("Tarde", question5);
        Options opt4 = new Options("Noche", question5);
        List<Options> lopt = new ArrayList<>();
        lopt.add(opt1);
        lopt.add(opt2);
        lopt.add(opt3);
        lopt.add(opt4);
        question5.setOptionList(lopt);
        Question question6 = new Question(QuestionDTO.OPEN, "¿Qué te parece la presentación de las comidas?", survey);
        Question question7 = new Question(QuestionDTO.OPEN, "¿Qué te parecen los tiempos de entrega al domicilio?", survey);

        List<Question> lquestion = new ArrayList<>();
        lquestion.add(question1);
        lquestion.add(question2);
        lquestion.add(question3);
        lquestion.add(question4);
        lquestion.add(question5);
        lquestion.add(question6);
        lquestion.add(question7);
        survey.setQuestionList(lquestion);
        surveyService.saveSurvey(survey);

    }

}
