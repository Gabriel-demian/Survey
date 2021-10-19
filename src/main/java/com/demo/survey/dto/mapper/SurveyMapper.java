package com.demo.survey.dto.mapper;

import com.demo.survey.dto.SurveyDto;
import com.demo.survey.entity.SurveyEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SurveyMapper implements Mapper<SurveyEntity, SurveyDto>{

    @Override
    public SurveyDto getDto(SurveyEntity entity) {
        return getDto(entity, CANTIDAD_ESCALONES);
    }

    @Override
    public SurveyEntity fillEntity(SurveyEntity entity, SurveyDto dto) {

        entity.setSurveyId(dto.getSurveyId());
        entity.setCreatedBy(dto.getCreatedBy());
        entity.setSurvey(dto.getSurvey());
        entity.setExpirationDate(dto.getExpirationDate());
        entity.setLabel(dto.getLabel());

        return entity;
    }

    @Override
    public List<SurveyDto> getDto(Collection<SurveyEntity> entities) {
        return getDto(entities, CANTIDAD_ESCALONES);
    }

    @Override
    public SurveyDto getDto(SurveyEntity entity, Integer escalones) {

        SurveyDto dto = new SurveyDto();

        dto.setSurveyId(entity.getSurveyId());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setSurvey(entity.getSurvey());
        dto.setExpirationDate(entity.getExpirationDate());
        dto.setLabel(entity.getLabel());

        if(escalones > 0){
            AnswerMapper answerMapper = new AnswerMapper();
            dto.setAnswers(answerMapper.getDto(entity.getAnswers(), escalones-1));
        }

        return dto;
    }

    @Override
    public List<SurveyDto> getDto(Collection<SurveyEntity> entities, Integer escalones) {
        List<SurveyDto> res = new ArrayList<>();

        for(SurveyEntity survey : entities){
            res.add(getDto(survey, escalones));
        }

        return res;
    }
}
