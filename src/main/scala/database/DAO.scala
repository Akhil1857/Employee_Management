package database

import structure.{Designation, EmployeeFields}

import scala.collection.mutable.ListBuffer
import scala.util.Try

trait DAO {

  def addEmployee(employee: EmployeeFields): Try[String]

  def getDetailsById(employeeId: Int): Option[EmployeeFields]

  def getOrganizationDetails: Try[ListBuffer[EmployeeFields]]

  def updateDetailsById(employeeID: Int, entryToUpdate: String): Try[ListBuffer[EmployeeFields]]

  def deleteDetailsById(employeeId: Int): Try[ListBuffer[EmployeeFields]]

  def deleteAll(): Try[String]

  def filterDepartment(departments: String): Try[ListBuffer[EmployeeFields]]

  def filterByDesignation(designation: Designation): Try[ListBuffer[EmployeeFields]]

}