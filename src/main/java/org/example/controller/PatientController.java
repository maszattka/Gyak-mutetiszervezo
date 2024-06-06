

package org.example.controller;

import org.example.model.Patient;
import org.example.service.PatientService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PatientController {

    @Autowired
    private PatientService patientService;

    @FXML
    private TextField tajNumberField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField birthYearField;
    @FXML
    private TextField surgeryTypeField;
    @FXML
    private TextField operatingDoctorField;

    @FXML
    public void addPatient() {
        Patient patient = new Patient();
        patient.setTaj(tajNumberField.getText());
        patient.setName(nameField.getText());
        patient.setBirthYear(Integer.parseInt(birthYearField.getText()));
        patient.setSurgeryType(surgeryTypeField.getText());
        patient.setSurgeon(operatingDoctorField.getText());

        patientService.saveOrUpdatePatient(patient);
    }

    @FXML
    public void searchPatient() {
        String tajNumber = tajNumberField.getText();
        Patient patient = patientService.getPatientByTajNumber(tajNumber);

        if (patient != null) {
            nameField.setText(patient.getName());
            birthYearField.setText(String.valueOf(patient.getBirthYear()));
            surgeryTypeField.setText(patient.getSurgeryType());
            operatingDoctorField.setText(patient.getSurgeon());
        }
    }

    @FXML
    public void deletePatient() {
        String tajNumber = tajNumberField.getText();
        Patient patient = patientService.getPatientByTajNumber(tajNumber);

        if (patient != null) {
            patientService.deletePatient(patient.getId());
        }
    }
}
