package com.sample.services.model;

public class Patients {
  private Integer id;
  private String firstName;
  private String lastName;
  private String idCard;
  private String facilitiesId;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getIdCard() {
    return idCard;
  }

  public void setIdCard(String idCard) {
    this.idCard = idCard;
  }

  public String getFacilitiesId() {
    return facilitiesId;
  }

  public void setFacilitiesId(String facilitiesId) {
    this.facilitiesId = facilitiesId;
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + firstName.hashCode();
    result = 31 * result + id.hashCode();
    result = 31 * result + lastName.hashCode();
    result = 31 * result + idCard.hashCode();
    result = 31 * result + facilitiesId.hashCode();
    return result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object)
      return true;
    if (object == null)
      return false;
    if (getClass() != object.getClass())
      return false;
    Patients other = (Patients) object;
    if ((id != null) && (other.id != null) &&(id.equals(other.id))) {
      return true;
    }
    if ((idCard != null) && (other.idCard != null) &&(idCard.equals(other.idCard))) {
      return true;
    }
    if ((facilitiesId != null) && (other.facilitiesId != null) &&(facilitiesId.equals(other.facilitiesId))) {
      return true;
    }
    return true;
  }
}
