package com.demo.survey.dto.mapper;

import com.demo.survey.dto.SurveyDto;
import com.demo.survey.entity.Survey;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SurveyMapper implements Mapper<Survey, SurveyDto>{

    @Autowired
    private AnswerMapper answerMapper;

    @Override
    public SurveyDto getDto(Survey entity) {
        return getDto(entity, CANTIDAD_ESCALONES);
    }

    @Override
    public Survey fillEntity(Survey entity, SurveyDto dto) {

        entity.setSurveyId(dto.getSurveyId());
        entity.setCreatedBy(dto.getCreatedBy());
        entity.setSurvey(dto.getSurvey());
        entity.setExpirationDate(dto.getExpirationDate());
        entity.setLabel(dto.getLabel());

        return entity;
    }

    @Override
    public List<SurveyDto> getDto(Collection<Survey> entities) {
        return getDto(entities, CANTIDAD_ESCALONES);
    }

    @Override
    public SurveyDto getDto(Survey entity, Integer escalones) {

        SurveyDto dto = new SurveyDto();

        dto.setSurveyId(entity.getSurveyId());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setSurvey(entity.getSurvey());
        dto.setExpirationDate(entity.getExpirationDate());
        dto.setLabel(entity.getLabel());

        if(escalones > 0){
            dto.setAnswerId(answerMapper.getDto(entity.getAnswerId(), escalones-1));
        }

        return dto;
    }

    @Override
    public List<SurveyDto> getDto(Collection<Survey> entities, Integer escalones) {
        List<SurveyDto> res = new ArrayList<>();

        for(Survey survey : entities){
            res.add(getDto(survey, escalones));
        }

        return res;
    }
}
