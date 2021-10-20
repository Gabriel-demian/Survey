package com.demo.survey.controllerTest;

import com.demo.survey.controller.SurveyController;
import com.demo.survey.repository.SurveyRepository;
import com.demo.survey.service.SurveyService;
import com.demo.survey.sur.SurveyObj;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.server.ResponseStatusException;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
class SurveyControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private SurveyController surveyController;

    @MockBean
    private SurveyService surveyService;

    @MockBean
    private SurveyRepository surveyRepository;


    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(this.surveyController).build();

    }

    @Test
    void getOneSurvey() throws Exception {

        SurveyObj obj = new SurveyObj();

        when(surveyService.getSurveyById("")).thenReturn(obj.surveyTest());

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/survey/test1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }

    @Test
    void getOneSurvey2() throws Exception {

        when(surveyService.getSurveyById("test1")).thenThrow(new ResponseStatusException(HttpStatus.NOT_FOUND));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/survey/test1"))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError())
                .andReturn();
    }

}
