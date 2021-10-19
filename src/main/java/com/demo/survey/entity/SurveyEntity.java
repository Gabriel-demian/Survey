package com.demo.survey.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class SurveyEntity {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String surveyId;

    @OneToMany(cascade = CascadeType.ALL)
    private List<AnswerEntity> answers;

    private String createdBy;
    private String survey;
    private Timestamp expirationDate;
    private String label;


}
