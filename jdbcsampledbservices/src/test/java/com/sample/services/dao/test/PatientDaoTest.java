package com.sample.services.dao.test;

import com.sample.services.config.Application;
import com.sample.services.dao.PatientsDao;
import com.sample.services.model.Patients;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@ContextConfiguration(classes = {TestBeanConfig.class})
public class PatientDaoTest {
  @Autowired
  PatientsDao patientsDao;

  @Test
  public void createPatient(){
    Patients patient = patientsDao.create(fillPatient());
    Patients dbPatient = patientsDao.findPatientById(patient.getId());
    assertEquals(dbPatient.getLastName(), patient.getLastName());
    assertEquals(dbPatient.getFacilitiesId(), patient.getFacilitiesId());
  }

  @Test
  public void findAllPatients(){
    List<Patients>patients = patientsDao.findAll();
    assertNotNull(patients);
    assertTrue(patients.size() > 0);
  }

  private Patients fillPatient(){
    Patients patient = new Patients();
    patient.setLastName("Petrov" + new Random().nextDouble());
    patient.setFirstName("Petr");
    patient.setIdCard("35443jjsf" + new Random().nextInt());
    patient.setFacilitiesId("3845784357" + new Random().nextInt());
    return patient;
  }
}
