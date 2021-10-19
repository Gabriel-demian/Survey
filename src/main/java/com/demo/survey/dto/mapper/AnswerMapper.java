package com.demo.survey.dto.mapper;

import com.demo.survey.dto.AnswerDto;
import com.demo.survey.entity.AnswerEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AnswerMapper implements Mapper<AnswerEntity, AnswerDto>{

    @Override
    public AnswerDto getDto(AnswerEntity entity) {
        return getDto(entity, CANTIDAD_ESCALONES);
    }

    @Override
    public AnswerEntity fillEntity(AnswerEntity entity, AnswerDto dto) {

        entity.setAnswerId(dto.getAnswerId());
        entity.setAnswer(dto.getAnswer());
        entity.setCounter(dto.getCounter());

        return entity;
    }

    @Override
    public List<AnswerDto> getDto(Collection<AnswerEntity> entities) {
        return getDto(entities, CANTIDAD_ESCALONES);
    }

    @Override
    public AnswerDto getDto(AnswerEntity entity, Integer escalones) {

        AnswerDto dto = new AnswerDto();

        dto.setAnswerId(entity.getAnswerId());
        dto.setAnswer(entity.getAnswer());
        dto.setCounter(entity.getCounter());

        return dto;
    }

    @Override
    public List<AnswerDto> getDto(Collection<AnswerEntity> entities, Integer escalones) {

        List<AnswerDto> res = new ArrayList<>();

        for(AnswerEntity answer : entities){
            res.add(getDto(answer, escalones));
        }

        return res;
    }
}
