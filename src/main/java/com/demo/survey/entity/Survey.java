package com.demo.survey.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Survey {

    @Id
    private String surveyId;
    @OneToMany
    private List<Answer> answerId;
    private String survey;
    private String idCorrectAnswer;
    private Timestamp expirationDate;

}
