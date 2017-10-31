package com.sample.restApi;


import com.sample.services.dao.PatientsDao;
import com.sample.services.model.Patients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/sbsample")
public class fillPatientDataService {

  @Autowired
  private PatientsDao patientsDao;

  @PostMapping("/fillPatient")
  public ResponseEntity<Void> fillPatientData(@RequestBody Patients patient) {
    if(patient == null || patient.getFirstName() == null || patient.getLastName() == null) {
      return ResponseEntity.badRequest().build();
    }
    Patients addedPatient = patientsDao.create(patient);
    if (addedPatient.getId() != null) {
      return ResponseEntity.status(201).build();
    } else {
      return ResponseEntity.status(500).build();
    }
  }

  public PatientsDao getPatientsDao() {
    return patientsDao;
  }

  public void setPatientsDao(PatientsDao patientsDao) {
    this.patientsDao = patientsDao;
  }
}
