package database

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import structure.Designation.{SoftwareDeveloper, TechnicalArchitect}
import structure._

import scala.util.Try
class DAOImplUnitTest extends AnyFlatSpec with Matchers{

  val DAOImpl = new DAOImpl

  "addEmployee" should "Insert the Employee into the database" in {
    val employee = EmployeeFields("Akhil Trivedi", 22, "Akhiltrivedi83@gmail.com", "08/04/2002", TechnicalArchitect, "Technical")
    val expectedResult = DAOImpl.addEmployee(employee)
    expectedResult.isSuccess shouldBe true
    expectedResult.get shouldBe Try("")
  }

  it should "add the Employee into the database" in {
    val employee = EmployeeFields("John", 24, "Johnmishra@3gmail.com", "08/09/2012", SoftwareDeveloper, "Technical")
    val expectedResult = DAOImpl.addEmployee(employee)
    expectedResult.isSuccess shouldBe true
    expectedResult.get shouldBe ""
  }

  it should "add the Employee as new Employee into the ListBuffer" in {
    val employee = EmployeeFields("David", 22, "DavidKalal83@gmail.com", "09/04/1992", TechnicalArchitect, "Technical")
    val expectedResult = DAOImpl.addEmployee(employee)
    expectedResult.isSuccess shouldBe true
    expectedResult.get shouldBe ""
  }
//
//  it should "return the List[Employee]" in {
//    val employee = Success(EmployeeFields("Akhil Trivedi", 22, "Akhiltrivedi83@gmail.com", "08/04/2002", TechnicalArchitect, "Technical"),
//      EmployeeFields("John", 24, "Johnmishra@3gmail.com", "08/09/2012",SoftwareDeveloper, "Technical"),
//      EmployeeFields("David", 22, "DavidKalal83@gmail.com", "09/04/1992", TechnicalArchitect, "Technical"))
//
//    val expectedResult = DAOImpl.getOrganizationDetails
//    expectedResult match {
//      case Success(value) => assert(value == employee)
//      case Failure(_) => false
//    }
//  }

//  it should "Update employee name by using ID return a updated ListBuffer[Employees]" in {
//    val employee = ListBuffer(EmployeeFields(1857, "David Gupta", 22, "Akhiltrivedi83@gmail.com", "08/04/2002", TechnicalArchitect, "Technical"),
//      EmployeeFields(1858, "John", 24, "Johnmishra@3gmail.com", "08/09/2012", SoftwareDevelopment, "Technical"),
//      EmployeeFields(1859, "David", 22, "DavidKalal83@gmail.com", "09/04/1992", TechnicalArchitect, "Technical"))
//    val newName = "David Gupta"
//    DAOImpl.updateDetailsById(1857, newName) match {
//      case Success(value) => assert(value == employee)
//      case Failure(_) => false
//    }
//  }
//
//  it should "return the details of the employee with the given ID" in {
//    val employee = EmployeeFields(1857, "Akhil Trivedi", 22, "Akhiltrivedi83@gmail.com", "08/04/2002", TechnicalArchitect, "Technical")
//    DAOImpl.getDetailsById(1857) match {
//      case Some(value) => assert(value == employee)
//      case None => None
//    }
//  }
//
//  it should "delete the details of the Employee for the given ID" in {
//    val expectedOutput = ListBuffer(EmployeeFields(1858, "John", 24, "Johnmishra@3gmail.com", "08/09/2012", SoftwareDevelopment, "Technical"),
//      EmployeeFields(1859, "David", 22, "DavidKalal83@gmail.com", "09/04/1992", TechnicalArchitect, "Technical"))
//    DAOImpl.deleteDetailsById(1857) match {
//      case Success(value) => assert(value == expectedOutput)
//      case Failure(_) => false
//    }
//  }
//
//  it should "return the details of the Employee in the Specific Department" in {
//    val expectedOutput = ListBuffer.empty
//    DAOImpl.filterDepartment("Helper") match {
//      case Success(value) => assert(value == expectedOutput)
//      case Failure(_) => false
//    }
//  }
//
//  it should "return the details of the Employee of the given designation" in {
//    val expectedResult = ListBuffer(EmployeeFields(1859, "David", 22, "DavidKalal83@gmail.com", "09/04/1992", TechnicalArchitect, "Technical"))
//    val actualResult = DAOImpl.filterByDesignation(TechnicalArchitect)
//    actualResult match {
//      case Success(value) => assert(value == expectedResult)
//      case Failure(_) => false
//    }
//  }
//
//  it should "return the Empty ListBuffer after deleting all the data from it" in {
//    val expectedResult = "No details Present in the database -- All Clear"
//    val actualResult = DAOImpl.deleteAll()
//    actualResult match {
//      case Success(value) => assert(value == expectedResult)
//      case Failure(_) => false
//    }
//  }


}
