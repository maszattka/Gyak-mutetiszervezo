

package org.example.repository;

import org.example.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByTajNumber(String tajNumber);
}
