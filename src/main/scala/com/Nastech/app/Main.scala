package com.Nastech.app

import com.Nastech.database.DAOImpl
import com.Nastech.service.Services
import com.Nastech.structure.{Designation, EmployeeFields}
import com.Nastech.structure.Designation.{AdminAssistant, Marketing, Receptionist, Sales, SoftwareDeveloper, SoftwareTester, TechnicalArchitect}

import scala.io.StdIn
import scala.language.implicitConversions
import scala.util.{Failure, Success}

object Main extends App {

  private val daoImpl = new DAOImpl
  val service = new Services(daoImpl)

  println("Enter your Choice: ")
  println("1-Add new Employee \n2-Get the Details of the Employee \n3-Get complete organization details" +
    " \n4-Update name of Employee \n5-Delete the Employee \n6-Delete All \n7-Employee from the same Department \n8-Employees at same designation")

  private val choice = StdIn.readInt()
  choice match {
    case 1 => addEmployee()
    case 2 => getDetailsById()
    case 3 => getOrganizationDetails()
    case 4 => updateNameById()
    case 5 => deleteDetailsById()
    case 6 => deleteAll()
    case 7 => filterDepartment()
    case 8 => filterDesignation()
    case _ => println("Invalid Input.")
  }

  private def addEmployee(): Unit = {
    println("Enter name:")
    val name = StdIn.readLine()
    println("Enter age:")
    val age = StdIn.readInt()
    println("Enter email")
    val email = StdIn.readLine()
    println("Enter DOB(YYYY-MM-DD)")
    val dob = StdIn.readLine()
    println("Enter department {Technical,NonTechnical,Helper}")
    val department = StdIn.readLine()
    println("Enter Designation{TechnicalArchitect,SoftwareDeveloper,SoftwareTester,Sales,Marketing,AdminAssistant,Receptionist}")
    val initialDesignation = StdIn.readLine()

    val employee = EmployeeFields(name, age, email, dob, initialDesignation, department)
    val result = service.addEmployee(employee)
    result match {
      case Success(_) => println("Data Inserted Successfully")
      case Failure(exception) => println("Please Enter Correct Information" + exception.getMessage)
    }
  }

  private def getDetailsById(): Unit = {
    println("Enter the Employee_ID")
    val employeeId = StdIn.readInt()
    val result = service.getDetailsById(employeeId)
    println(result)

  }

  private def getOrganizationDetails(): Unit = {
    val result = service.getOrganizationDetails
    println(result)
  }

  private def updateNameById(): Unit = {
    println("Enter EmployeeId : ")
    val employeeId = StdIn.readInt()
    println("Enter the new name")
    val newName = StdIn.readLine()
    val result = service.updateNameById(employeeId, newName)
    result match {
      case Success(_) => println("Field Updated Successfully")
      case Failure(exception) => println(s"Error:- ${exception.getMessage}")
    }
  }

  private def deleteDetailsById(): Unit = {
    println("Enter EmployeeId: ")
    val employeeId = StdIn.readInt()
    val result = service.deleteDetailsById(employeeId)
    result match {
      case Success(_) => println("Deleted Successfully")
      case Failure(exception) => println(s"Error:-${exception.getMessage}")
    }
  }

  private def deleteAll(): Unit = {
    val result = service.deleteAll()
    result match {
      case Success(_) => println("All Clear !!!")
      case Failure(exception) => println(s"Error:- ${exception.getMessage}")
    }

  }

  private def filterDepartment(): Unit = {
    println("Enter the Department")
    val department = StdIn.readLine()
    val result = service.filterDepartment(department)
    println(result)
  }

  private def filterDesignation(): Unit = {
    println("Enter the Designation")
    val designation = StdIn.readLine()
    val result = service.filterByDesignation(designation)
    println(result)
  }

  implicit def stringToDesignation(string: String): Designation = {
    string match {
      case ("TechnicalArchitect") => TechnicalArchitect
      case ("SoftwareDeveloper") => SoftwareDeveloper
      case ("SoftwareTester") => SoftwareTester
      case ("Sales") => Sales
      case ("Marketing") => Marketing
      case ("AdminAssistant") => AdminAssistant
      case ("Receptionist") => Receptionist
    }
  }
}
