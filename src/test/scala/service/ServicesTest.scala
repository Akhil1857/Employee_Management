package service

import com.Nastech.database.DAOImpl
import com.Nastech.service.Services
import com.Nastech.structure.Designation.{SoftwareDeveloper, TechnicalArchitect}
import com.Nastech.structure.EmployeeFields
import org.mockito.Mockito.when
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatestplus.mockito.MockitoSugar

import scala.util.{Failure, Success, Try}

class ServicesTest extends AnyFlatSpec with MockitoSugar {

  val daoImpl: DAOImpl = mock[DAOImpl]
  val service = new Services(daoImpl)

  "addEmployee" should "add the employee into the list buffer" in {
    val employee = EmployeeFields("Akhil Trivedi", 22, "Akhiltrivedi83@gmail.com", "08/04/2002", TechnicalArchitect, "Technical")
    when(daoImpl.addEmployee(employee)).thenReturn(Try("Data Inserted Successfully"))
    val actualOutput = service.addEmployee(employee)
    actualOutput match {
      case Success(value) => assert(value == "Data Inserted Successfully")
      case Failure(_) => false
    }
  }

  it should "add the new employee into the list buffer" in {
    val employee = EmployeeFields("John", 24, "Johnmishra@3gmail.com", "08/09/2012", SoftwareDeveloper, "Technical")
    when(daoImpl.addEmployee(employee)).thenReturn(Try("Data Inserted Successfully"))
    val actualOutput = service.addEmployee(employee)
    actualOutput match {
      case Success(value) => assert(value == "Data Inserted Successfully")
      case Failure(_) => false
    }
  }

  "getOrganizationDetails" should "return the all the employee details" in {
    val employee = List(EmployeeFields("Akhil Trivedi", 22, "Akhiltrivedi83@gmail.com", "08/04/2002", TechnicalArchitect, "Technical"),
      EmployeeFields("John", 24, "Johnmishra@3gmail.com", "08/09/2012", SoftwareDeveloper, "Technical"))
    when(daoImpl.getOrganizationDetails).thenReturn(Try(List(EmployeeFields("Akhil Trivedi", 22, "Akhiltrivedi83@gmail.com", "08/04/2002", TechnicalArchitect, "Technical"),
      EmployeeFields("John", 24, "Johnmishra@3gmail.com", "08/09/2012", SoftwareDeveloper, "Technical"))))
    val expectedResult = service.getOrganizationDetails
    expectedResult match {
      case Success(value) => assert(value == employee)
      case Failure(_) => false
    }
  }

  "getDetailsByID" should "return the details of the employee of the given ID" in {
    val employee = List(EmployeeFields("Akhil Trivedi", 22, "Akhiltrivedi83@gmail.com", "2002-04-08", TechnicalArchitect, "Technical"))
    when(daoImpl.getDetailsById(43)).thenReturn(Success(List(EmployeeFields("Akhil Trivedi", 22, "Akhiltrivedi83@gmail.com", "2002-04-08", TechnicalArchitect, "Technical"))))
    val actualOutput = service.getDetailsById(43)
    actualOutput match {
      case Success(value) => assert(value == employee)
      case Failure(ex) => ex.getMessage
    }
  }

  "deleteDetailsById" should "delete the employee having the given ID" in {
    when(daoImpl.deleteDetailsById(44)).thenReturn(Try("Deleted Successfully."))
    val expectedResult = service.deleteDetailsById(44)
    expectedResult match {
      case Success(value) => assert(value == "Deleted Successfully.")
      case Failure(_) => false
    }
  }

  "filterDepartment" should "return the details of the Employee in the Specific Department" in {
    val expectedOutput = List.empty
    when(daoImpl.filterDepartment("Helper")).thenReturn(Try(List.empty))
    service.filterDepartment("Helper") match {
      case Success(value) => assert(value == expectedOutput)
      case Failure(_) => false
    }
  }

  "filterByDesignation" should "return the details of the Employee of the given designation" in {
    val expectedResult = List(EmployeeFields("David", 22, "DavidKalal83@gmail.com", "09/04/1992", TechnicalArchitect, "Technical"))
    when(daoImpl.filterByDesignation(TechnicalArchitect)).thenReturn(Try(List(EmployeeFields("David", 22, "DavidKalal83@gmail.com", "09/04/1992", TechnicalArchitect, "Technical"))))
    val actualResult = service.filterByDesignation(TechnicalArchitect)
    actualResult match {
      case Success(value) => assert(value == expectedResult)
      case Failure(_) => false
    }
  }

  "updateNameById" should "update the name of the employee of the given ID" in {
    val newName = "David Gupta"
    when(daoImpl.updateNameById(45, newName)).thenReturn(Try(""))
    service.updateNameById(45, newName) match {
      case Success(value) => assert(value == "")
      case Failure(_) => false
    }
  }

  "deleteAll" should "delete all the entries in the database" in {
    val expectedResult = "No details Present in the database -- All Clear"
    when(daoImpl.deleteAll()).thenReturn(Try("No details Present in the database -- All Clear"))
    val actualResult = service.deleteAll()
    actualResult match {
      case Success(value) => assert(value == expectedResult)
      case Failure(_) => false
    }
  }
}
