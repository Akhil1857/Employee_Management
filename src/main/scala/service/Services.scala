package service

import database.DAO
import structure.{Designation, EmployeeFields}

import scala.collection.mutable.ListBuffer
import scala.util.Try

class Services(employeeDB: DAO) {

  def addEmployee(employee: EmployeeFields): Try[String] = {
    employeeDB.addEmployee(employee)
  }

  def getDetailsById(employeeId: Int): Option[EmployeeFields] = {
    employeeDB.getDetailsById(employeeId)
  }

  def getOrganizationDetails: Try[ListBuffer[EmployeeFields]] = {
    employeeDB.getOrganizationDetails
  }

  def updateDetailsById(employeeID: Int, entryToUpdate: String): Try[ListBuffer[EmployeeFields]] = {
    employeeDB.updateDetailsById(employeeID, entryToUpdate)
  }

  def deleteDetailsById(employeeId: Int): Try[ListBuffer[EmployeeFields]] = {
    employeeDB.deleteDetailsById(employeeId)
  }

  def deleteAll(): Try[String] = {
    employeeDB.deleteAll()
  }

  def filterDepartment(departments: String): Try[ListBuffer[EmployeeFields]] = {

    employeeDB.filterDepartment(departments)
  }

  def filterByDesignation(designation: Designation): Try[ListBuffer[EmployeeFields]] = {
    employeeDB.filterByDesignation(designation)
  }


}
