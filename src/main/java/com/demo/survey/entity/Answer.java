package com.demo.survey.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Answer {

    @Id
    private String answerId;
    @ManyToOne
    @JoinColumn(name= "surveyId")
    private Survey surveyId;

    @NotNull
    private String answer;

}
