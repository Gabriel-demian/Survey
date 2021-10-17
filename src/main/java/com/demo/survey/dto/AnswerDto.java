package com.demo.survey.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerDto {

    private String answerId;

    private String answer;

    private Integer counter;

    private Double percentage;

}
