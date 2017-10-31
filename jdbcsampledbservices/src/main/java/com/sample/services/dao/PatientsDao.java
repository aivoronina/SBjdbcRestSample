package com.sample.services.dao;

import com.sample.services.model.Patients;

import java.util.List;

public interface PatientsDao {
  Patients create(Patients patient);

  List findAll();

  Patients findPatientById(int id);
}
