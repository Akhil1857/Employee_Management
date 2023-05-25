package com.Nastech.service

import com.Nastech.database.DAO
import com.Nastech.structure.{Designation, EmployeeFields}

import scala.util.Try

class Services(employeeDB: DAO) {

  def addEmployee(employee: EmployeeFields): Try[String] = {
    employeeDB.addEmployee(employee)
  }

  def getDetailsById(employeeId: Int): Try[List[EmployeeFields]] = {
    employeeDB.getDetailsById(employeeId)
  }

  def getOrganizationDetails: Try[List[EmployeeFields]] = {
    employeeDB.getOrganizationDetails
  }

  def updateNameById(employeeID: Int, entryToUpdate: String): Try[String] = {
    employeeDB.updateNameById(employeeID, entryToUpdate)
  }

    def deleteDetailsById(employeeId: Int): Try[String] = {
      employeeDB.deleteDetailsById(employeeId)
    }

    def deleteAll(): Try[String] = {
      employeeDB.deleteAll()
    }

    def filterDepartment(departments: String): Try[List[EmployeeFields]] = {

      employeeDB.filterDepartment(departments)
    }

    def filterByDesignation(designation: Designation): Try[List[EmployeeFields]] = {
      employeeDB.filterByDesignation(designation)
    }


}
