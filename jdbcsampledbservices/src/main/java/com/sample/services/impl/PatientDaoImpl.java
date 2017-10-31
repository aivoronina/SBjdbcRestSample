package com.sample.services.impl;

import com.sample.services.model.Patients;
import com.sample.services.dao.PatientsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class PatientDaoImpl implements PatientsDao {

  private final String INSERT_SQL = "INSERT INTO ktk.PATIENTS(firstname, lastname, idcard, facilityid) values(?,?,?,?)";
  private final String FETCH_SQL = "select id, firstname, lastname, idcard, facilityid from ktk.PATIENTS";
  private final String FETCH_SQL_BY_ID = "select * from ktk.PATIENTS where id = ?";

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public Patients create(final Patients patient) {
    KeyHolder holder = new GeneratedKeyHolder();
    jdbcTemplate.update(new PreparedStatementCreator() {
      @Override
      public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, patient.getFirstName());
        ps.setString(2, patient.getLastName());
        ps.setString(3, patient.getIdCard());
        ps.setString(4, patient.getFacilitiesId());
        return ps;
      }
    }, holder);

    int newUserId = (Integer)holder.getKeys().get("id");
    patient.setId(newUserId);
    return patient;
  }

  @Override
  //@SuppressWarnings("unchecked")
  public List  findAll() {
    return jdbcTemplate.query(FETCH_SQL, new PatientMapper());
  }

  @Override
 // @SuppressWarnings("unchecked")
  public Patients findPatientById(int id) {
    return (Patients)jdbcTemplate.queryForObject(FETCH_SQL_BY_ID, new Object[] { id }, new PatientMapper());
  }
}

class PatientMapper implements RowMapper<Patients> {

  @Override
  public Patients mapRow(ResultSet rs, int rowNum) throws SQLException {
    Patients patient = new Patients();
    patient.setId(rs.getInt("id"));
    patient.setFirstName(rs.getString("firstname"));
    patient.setLastName(rs.getString("lastname"));
    patient.setFacilitiesId(rs.getString("facilityid"));
    patient.setIdCard(rs.getString("idcard"));
    return patient;
  }

}