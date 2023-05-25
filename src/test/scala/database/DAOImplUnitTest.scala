package database

import com.Nastech.database.DAOImpl
import com.Nastech.structure.Designation.{SoftwareDeveloper, TechnicalArchitect}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import com.Nastech.structure.EmployeeFields

import scala.util.{Failure, Success}

class DAOImplUnitTest extends AnyFlatSpec with Matchers {

  val DAOImpl = new DAOImpl

  "addEmployee" should "Insert the Employee into the database" in {
    val employee = EmployeeFields("Akhil Trivedi", 22, "Akhiltrivedi83@gmail.com", "08/04/2002", TechnicalArchitect, "Technical")
    val expectedResult = DAOImpl.addEmployee(employee)
    expectedResult.isSuccess shouldBe true
    expectedResult.get shouldBe "Data Inserted Successfully"
  }

  it should "add the Employee into the database" in {
    val employee = EmployeeFields("John", 24, "Johnmishra3gmail.com", "08/09/2012", SoftwareDeveloper, "Technical")
    val expectedResult = DAOImpl.addEmployee(employee)
    expectedResult.isSuccess shouldBe true
    expectedResult.get shouldBe "Data Inserted Successfully"
  }

  it should "add the Employee as new Employee into the ListBuffer" in {
    val employee = EmployeeFields("David", 22, "DavidKalal83@gmail.com", "09/04/1992", TechnicalArchitect, "Technical")
    val expectedResult = DAOImpl.addEmployee(employee)
    expectedResult.isSuccess shouldBe true
    expectedResult.get shouldBe "Data Inserted Successfully"
  }

    it should "return the List[Employee]" in {
      val employee = List(EmployeeFields("Akhil Trivedi", 22, "Akhiltrivedi83@gmail.com", "2000-04-08", SoftwareDeveloper, "Technical"),
        EmployeeFields("John", 24, "Johnmishra3gmail.com", "2012-09-08", SoftwareDeveloper, "Technical"),
        EmployeeFields("David", 22, "DavidKalal83@gmail.com", "1992-04-09", TechnicalArchitect, "Technical"))

      val expectedResult = DAOImpl.getOrganizationDetails
      expectedResult match {
        case Success(value) => assert(value == employee)
        case Failure(_) => false
      }
    }

  it should "Update employee name by using ID return a updated List[Employees]" in {
    val expectedResult = DAOImpl.updateNameById(36,"Ayush Mishra")
      expectedResult.isSuccess shouldBe true
      expectedResult.get shouldBe ""
    }

    it should "return the details of the employee with the given ID" in {
      val employee = List(EmployeeFields("Akhil Trivedi", 22, "Akhiltrivedi83@gmail.com", "2000-04-08", SoftwareDeveloper, "Technical"))
      DAOImpl.getDetailsById(33) match {
        case Success(value) => assert(value == employee)
        case Failure(_) => false
      }
    }

    it should "delete the details of the Employee for the given ID" in {
      DAOImpl.deleteDetailsById(35) match {
        case Success(value) => assert(value == "")
        case Failure(_) => false
      }
    }

    it should "return the details of the Employee in the Specific Department" in {
      val expectedOutput = List.empty
      DAOImpl.filterDepartment("Helper") match {
        case Success(value) => assert(value == expectedOutput)
        case Failure(_) => false
      }
    }

    it should "return the details of the Employee of the given designation" in {
      val expectedResult = List(EmployeeFields("Ayush Mishra", 22, "DavidKalal83@gmail.com", "1992-04-09", TechnicalArchitect, "Technical"))
      val actualResult = DAOImpl.filterByDesignation(TechnicalArchitect)
      actualResult match {
        case Success(value) => assert(value == expectedResult)
        case Failure(_) => false
      }
    }
//
//    it should "return the Empty ListBuffer after deleting all the data from it" in {
//      val expectedResult = ""
//      val actualResult = DAOImpl.deleteAll()
//      actualResult match {
//        case Success(value) => assert(value == expectedResult)
//        case Failure(_) => false
//      }
//    }


}
