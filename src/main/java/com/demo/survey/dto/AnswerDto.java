package com.demo.survey.dto;

import com.demo.survey.entity.Survey;
import lombok.Data;

@Data
public class AnswerDto {

    private String answerId;

    private Survey surveyId;

    private String answer;

    private Double percentage;

}
