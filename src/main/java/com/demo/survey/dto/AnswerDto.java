package com.demo.survey.dto;

import com.demo.survey.entity.Survey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDto {

    private String answerId;

    private Survey surveyId;

    private String answer;

    private Integer counter;

    private Double percentage;

}
