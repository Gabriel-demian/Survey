package com.demo.survey.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SurveyDto {

    private String surveyId;
    private List<AnswerDto> answerId;
    private String createdBy;
    private String survey;
    private Timestamp expirationDate;
    private String label;

}
