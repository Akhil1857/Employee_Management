//package service
//
//import database.DAOImpl
//import structure.Designation.{SoftwareDeveloper, TechnicalArchitect}
//import structure.EmployeeFields
//import org.mockito.Mockito.when
//import org.scalatest.flatspec.AnyFlatSpec
//import org.scalatestplus.mockito.MockitoSugar
//
//import scala.collection.mutable.ListBuffer
//import scala.util.{Failure, Success, Try}
//
//class ServicesTest extends AnyFlatSpec with MockitoSugar {
//
//  val daoImpl: DAOImpl = mock[DAOImpl]
//  val service = new Services(daoImpl)
//
//  "addEmployee" should "add the employee into the list buffer" in {
//    val employee = EmployeeFields("Akhil Trivedi", 22, "Akhiltrivedi83@gmail.com", "08/04/2002", TechnicalArchitect, "Technical")
//    when(daoImpl.addEmployee(employee)).thenReturn(Try("User having 1857 as employee Id added Successfully"))
//    val actualOutput = service.addEmployee(employee)
//    actualOutput match {
//      case Success(value) => assert(value == "User having 1857 as employee Id added Successfully")
//      case Failure(_) => false
//    }
//  }
//
//  it should "add the employee having id 1858 into the list buffer" in {
//    val employee = EmployeeFields(1858, "John", 24, "Johnmishra@3gmail.com", "08/09/2012", SoftwareDeveloper, "Technical")
//    when(daoImpl.addEmployee(employee)).thenReturn(Try("User having 1857 as employee Id added Successfully"))
//    val actualOutput = service.addEmployee(employee)
//    actualOutput match {
//      case Success(value) => assert(value == "User having 1857 as employee Id added Successfully")
//      case Failure(_) => false
//    }
//  }
//
//  "getOrganizationDetails" should "return the all the employee details" in {
//    val employee = ListBuffer(EmployeeFields(1857, "Akhil Trivedi", 22, "Akhiltrivedi83@gmail.com", "08/04/2002", TechnicalArchitect, "Technical"),
//      EmployeeFields(1858, "John", 24, "Johnmishra@3gmail.com", "08/09/2012", SoftwareDevelopment, "Technical"))
//    when(daoImpl.getOrganizationDetails).thenReturn(Try(ListBuffer(EmployeeFields(1857, "Akhil Trivedi", 22, "Akhiltrivedi83@gmail.com", "08/04/2002", TechnicalArchitect, "Technical"),
//      EmployeeFields(1858, "John", 24, "Johnmishra@3gmail.com", "08/09/2012", SoftwareDevelopment, "Technical"))))
//    val expectedResult = service.getOrganizationDetails
//    expectedResult match {
//      case Success(value) => assert(value == employee)
//      case Failure(_) => false
//    }
//  }
//
//  "getDetailsByID" should "return the details of the employee of the given ID" in {
//    val employee = EmployeeFields(1857, "Akhil Trivedi", 22, "Akhiltrivedi83@gmail.com", "08/04/2002", TechnicalArchitect, "Technical")
//    when(daoImpl.getDetailsById(1857)).thenReturn(Option(EmployeeFields(1857, "Akhil Trivedi", 22, "Akhiltrivedi83@gmail.com", "08/04/2002", TechnicalArchitect, "Technical")))
//    val actualOutput = service.getDetailsById(1857)
//    actualOutput match {
//      case Success(value) => assert(value == employee)
//      case Failure(ex) => ex.getMessage
//    }
//  }
//
//  "deleteDetailsById" should "delete the employee having the given ID" in {
//    val employees = ListBuffer(EmployeeFields(1858, "John", 24, "Johnmishra@3gmail.com", "08/09/2012", SoftwareDevelopment, "Technical"))
//    when(daoImpl.deleteDetailsById(1857)).thenReturn(Try(ListBuffer(EmployeeFields(1858, "John", 24, "Johnmishra@3gmail.com", "08/09/2012", SoftwareDevelopment, "Technical"))))
//    val expectedResult = service.deleteDetailsById(1857)
//    expectedResult match {
//      case Success(value) => assert(value == employees)
//      case Failure(_) => false
//    }
//  }
//
//  "filterDepartment" should "return the details of the Employee in the Specific Department" in {
//    val expectedOutput = ListBuffer.empty
//    when(daoImpl.filterDepartment("Helper")).thenReturn(Try(ListBuffer.empty))
//    service.filterDepartment("Helper") match {
//      case Success(value) => assert(value == expectedOutput)
//      case Failure(_) => false
//    }
//  }
//
//  "filterByDesignation" should "return the details of the Employee of the given designation" in {
//    val expectedResult = ListBuffer(EmployeeFields(1859, "David", 22, "DavidKalal83@gmail.com", "09/04/1992", TechnicalArchitect, "Technical"))
//    when(daoImpl.filterByDesignation(TechnicalArchitect)).thenReturn(Try(ListBuffer(EmployeeFields(1859, "David", 22, "DavidKalal83@gmail.com", "09/04/1992", TechnicalArchitect, "Technical"))))
//    val actualResult = service.filterByDesignation(TechnicalArchitect)
//    actualResult match {
//      case Success(value) => assert(value == expectedResult)
//      case Failure(_) => false
//    }
//  }
//
//  "updateDetailsById" should "update the name of the employee of the given ID" in {
//    val employee = ListBuffer(EmployeeFields(1857, "David Gupta", 22, "Akhiltrivedi83@gmail.com", "08/04/2002", TechnicalArchitect, "Technical"),
//      EmployeeFields(1858, "John", 24, "Johnmishra@3gmail.com", "08/09/2012", SoftwareDevelopment, "Technical"))
//    val newName = "David Gupta"
//    when(daoImpl.updateDetailsById(1857, newName)).thenReturn(Try(ListBuffer(EmployeeFields(1857, "David Gupta", 22, "Akhiltrivedi83@gmail.com", "08/04/2002", TechnicalArchitect, "Technical"),
//      EmployeeFields(1858, "John", 24, "Johnmishra@3gmail.com", "08/09/2012", SoftwareDevelopment, "Technical"))))
//    service.updateDetailsById(1857, newName) match {
//      case Success(value) => assert(value == employee)
//      case Failure(_) => false
//    }
//  }
//
//  "deleteAll" should "delete all the entries in the database" in {
//    val expectedResult = "No details Present in the database -- All Clear"
//    when(daoImpl.deleteAll()).thenReturn(Try("No details Present in the database -- All Clear"))
//    val actualResult = service.deleteAll()
//    actualResult match {
//      case Success(value) => assert(value == expectedResult)
//      case Failure(_) => false
//    }
//  }
//}
