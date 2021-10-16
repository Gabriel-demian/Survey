package com.demo.survey.dto.mapper;

import com.demo.survey.dto.AnswerDto;
import com.demo.survey.entity.Answer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AnswerMapper implements Mapper<Answer, AnswerDto>{

    @Override
    public AnswerDto getDto(Answer entity) {
        return getDto(entity, CANTIDAD_ESCALONES);
    }

    @Override
    public Answer fillEntity(Answer entity, AnswerDto dto) {

        entity.setAnswerId(dto.getAnswerId());
        entity.setSurveyId(dto.getSurveyId());
        entity.setAnswer(dto.getAnswer());
        entity.setCounter(dto.getCounter());

        return entity;
    }

    @Override
    public List<AnswerDto> getDto(Collection<Answer> entities) {
        return getDto(entities, CANTIDAD_ESCALONES);
    }

    @Override
    public AnswerDto getDto(Answer entity, Integer escalones) {

        AnswerDto dto = new AnswerDto();

        dto.setAnswerId(entity.getAnswerId());
        dto.setSurveyId(entity.getSurveyId());
        dto.setAnswer(entity.getAnswer());
        dto.setCounter(entity.getCounter());

        return dto;
    }

    @Override
    public List<AnswerDto> getDto(Collection<Answer> entities, Integer escalones) {

        List<AnswerDto> res = new ArrayList<>();

        for(Answer answer : entities){
            res.add(getDto(answer, escalones));
        }

        return res;
    }
}
