package com.developer.reservation.controller;

import com.developer.reservation.entity.TotalBooking;
import com.developer.reservation.service.ReservationService;
import com.developer.reservation.service.TotalBookingService;
import com.developer.reservation.entity.Reservation;
import com.developer.reservation.repository.ReservationRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@WebMvcTest(value=ReservationController.class)
class ReservationControllerTest {
    private Reservation mockReservation1 = new Reservation();
    private TotalBooking mockTotalBooking = new TotalBooking();
    private Reservation mockReservation2 = new Reservation();
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ReservationService reservationService;
    @MockBean
    private TotalBookingService totalBookingService;
    @MockBean
    private ReservationRepository reservationRepository;
    @BeforeEach
    void setUp() {

        mockReservation1.setReservationAmount(5);
        mockReservation1.setCostumerId(1);
        mockReservation1.setPerformanceId(10);
        mockReservation1.setId(1);

        mockReservation2.setReservationAmount(10);
        mockReservation2.setCostumerId(11);
        mockReservation2.setPerformanceId(1);
        mockReservation2.setId(2);

        mockTotalBooking.setId(1);
        mockTotalBooking.setTotalBooking(20);
        mockTotalBooking.setPerformanceId(10);

    }

    @Test
    @DisplayName("Test find all reservation")
    void findAllReservation() throws Exception {

        List<Reservation> reservationList = new ArrayList<>();
        reservationList.add(mockReservation1);
        reservationList.add(mockReservation2);

        Mockito.when(reservationService.findAllReservation()).thenReturn(reservationList);

        String URI = "/api/reservation";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                URI).accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expectedJson = this.mapToJson(reservationList);
        String outputInJson = result.getResponse().getContentAsString();
        assertThat(outputInJson).isEqualTo(expectedJson);
    }


    @Test
    @DisplayName("Test find reservation by id")
    void findById() throws Exception {
        Mockito.when(reservationService.findById(Mockito.anyLong())).thenReturn(Optional.of( mockReservation1));

        String expectedJson = this.mapToJson((mockReservation1));

        String URI = "/api/reservation/1";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                URI).accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = this.mockMvc.perform(requestBuilder).andReturn();
        String outputInJson = result.getResponse().getContentAsString();
        assertThat(outputInJson).isEqualTo(expectedJson);
    }
    @Test
    void saveReservation() throws Exception {
        String inputInJson = this.mapToJson(mockReservation1);

        String URI = "/api/reservation";
        Mockito.when(totalBookingService.findTotalBookingByPerformanceId(Mockito.anyLong())).thenReturn((mockTotalBooking));
        Mockito.when(reservationService.saveReservation(Mockito.any(Reservation.class))).thenReturn(mockReservation1);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(URI)
                .accept(MediaType.APPLICATION_JSON).content(inputInJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputInJson = response.getContentAsString();

        assertThat(outputInJson).isEqualTo(inputInJson);
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    void updateReservation() {
    }

    @Test
    void deleteReservation() {
    }
    /**
     * Maps an Object into a JSON String. Uses a Jackson ObjectMapper.
     */
    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(object);}
}