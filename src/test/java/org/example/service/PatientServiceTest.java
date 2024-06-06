package org.example.service;

import org.example.model.Patient;
import org.example.repository.PatientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class PatientServiceTest {

    @Mock
    private PatientRepository patientRepository;

    @InjectMocks
    private PatientService patientService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetPatientByTajNumber() {
        Patient patient = new Patient();
        patient.setTaj("123456789");
        when(patientRepository.findByTajNumber("123456789")).thenReturn(patient);

        Patient found = patientService.getPatientByTajNumber("123456789");

        assertEquals("123456789", found.getTaj());
    }

    @Test
    public void testSaveOrUpdatePatient() {
        Patient patient = new Patient();
        patient.setTaj("123456789");

        patientService.saveOrUpdatePatient(patient);

        verify(patientRepository, times(1)).save(any(Patient.class));
    }

    @Test
    public void testDeletePatient() {
        Patient patient = new Patient();
        patient.setId(1L);

        when(patientRepository.findById(1L)).thenReturn(Optional.of(patient));

        patientService.deletePatient(1L);

        verify(patientRepository, times(1)).deleteById(1L);
    }
}
