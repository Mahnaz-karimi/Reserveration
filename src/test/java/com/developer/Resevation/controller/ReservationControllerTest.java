package com.developer.Resevation.controller;

import com.developer.Resevation.Service.ReservationService;
import com.developer.Resevation.entity.Reservation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@WebMvcTest(value=ReservationController.class)
class ReservationControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ReservationService reservationService;

    @Test
    void findAllReservation() throws Exception {
        Reservation mockReservation1 = new Reservation();
        mockReservation1.setReservationAmount(5);
        mockReservation1.setCostumerId(1);
        mockReservation1.setPerformanceId(10);

        Reservation mockReservation2 = new Reservation();
        mockReservation2.setReservationAmount(10);
        mockReservation2.setCostumerId(11);
        mockReservation2.setPerformanceId(1);

        List<Reservation> reservationList = new ArrayList<>();
        reservationList.add(mockReservation1);
        reservationList.add(mockReservation2);


        Mockito.when(reservationService.findAllReservation()).thenReturn(reservationList);

        String URI = "/reservation";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                URI).accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expectedJson = this.mapToJson(reservationList);
        String outputInJson = result.getResponse().getContentAsString();
        assertThat(outputInJson).isEqualTo(expectedJson);
    }

    @Test
    void findById() throws Exception {
       /* Reservation mockReservation1 = new Reservation();
        mockReservation1.setReservationAmount(5);
        mockReservation1.setCostumerId(1);
        mockReservation1.setPerformanceId(10);

        Mockito.when(reservationService.findById((long) Mockito.anyInt())).thenReturn(Optional.of(mockReservation1));

        String URI = "/reservation/1";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                URI).accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expectedJson = this.mapToJson(mockReservation1);
        String outputInJson = result.getResponse().getContentAsString();
        assertThat(outputInJson).isEqualTo(expectedJson);*/
    }

    @Test
    void saveReservation() {
    }

    @Test
    void updateReservation() {
    }

    @Test
    void deleteReservation() {
    }
    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);}
}