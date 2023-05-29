package com.Nastech.database

import com.Nastech.structure.{Designation, EmployeeFields}

import scala.util.Try

trait DAO {

  def addEmployee(employee: EmployeeFields): Try[String]

  def getDetailsById(employeeId: Int): Try[List[EmployeeFields]]

  def getOrganizationDetails: Try[List[EmployeeFields]]

  def updateNameById(employeeID: Int, entryToUpdate: String): Try[String]

  def deleteDetailsById(employeeId: Int): Try[String]

  def deleteAll(): Try[String]

  def filterDepartment(departments: String): Try[List[EmployeeFields]]

  def filterByDesignation(designation: Designation): Try[List[EmployeeFields]]

}