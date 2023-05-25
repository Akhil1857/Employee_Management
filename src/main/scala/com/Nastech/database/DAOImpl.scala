package com.Nastech.database

import com.Nastech.app.Main.stringToDesignation
import com.Nastech.structure.{Designation, EmployeeFields}

import java.sql.{ResultSet, SQLException}
import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer
import scala.language.implicitConversions
import scala.util.{Failure, Success, Try}

class DAOImpl extends DAO {

  private val statement = Connection.connection.createStatement()

  override def addEmployee(employee: EmployeeFields): Try[String] = Try {
    val query = s"insert into employees(employee_name ,employee_age,employee_email,employee_dob,designation,department)values ('${employee.employeeName}',${employee.employeeAge},'${employee.employeeEmail}','${employee.employeeDOB}','${employee.designation}','${employee.department}')"

    Try(statement.executeQuery(query))
    "Data Inserted Successfully"
  }

  override def getDetailsById(employeeId: Int): Try[List[EmployeeFields]] = Try {
    val query = s"select * from employees where employee_id = $employeeId"
    Try(statement.executeQuery(query)) match {
      case Success(resultSet) => resultSet    // Implicitly Called resultSet => List[EmployeeFields]
      case Failure(_) => throw new SQLException
    }
  }

  override def getOrganizationDetails: Try[List[EmployeeFields]] = Try {
    val query = "select * from employees"
    Try(statement.executeQuery(query)) match {
      case Success(resultSet: ResultSet) => resultSet
      case Failure(_) => throw new SQLException
    }
  }

  override def updateNameById(employeeID: Int, entryToUpdate: String): Try[String] = Try {
    val query = s"update employees set employee_name = '$entryToUpdate' where employee_id = $employeeID"
    Try(statement.executeQuery(query))
    ""
  }

  override def deleteDetailsById(employeeId: Int): Try[String] = Try {
    val query = s"delete from employees where employee_id = $employeeId"
    Try(statement.executeQuery(query))
    "Deleted Successfully."
  }

    override def deleteAll(): Try[String] = Try {
     val query = s"delete from employees"
      Try(statement.executeQuery(query))
      "No details Present in the database -- All Clear"
    }

    override def filterDepartment(departments: String): Try[List[EmployeeFields]] = Try {
      val query = s"select * from employees where department = '$departments'"
      Try(statement.executeQuery(query)) match {
        case Success(resultSet: ResultSet) => resultSet
        case Failure(_) => throw new SQLException()
      }

    }

    override def filterByDesignation(designation: Designation): Try[List[EmployeeFields]] = Try {
      val query = s"select * from employees where designation = '$designation'"
      Try(statement.executeQuery(query)) match {
        case Success(resultSet: ResultSet) => resultSet
        case Failure(_) => throw new SQLException()
      }
    }

  private val listBuffer = ListBuffer[EmployeeFields]()

  @tailrec
  implicit private def resultSetToList(resultSet: ResultSet): List[EmployeeFields] = {
    if (resultSet.next()) {
      val name = resultSet.getString("employee_name")
      val age = resultSet.getInt("employee_age")
      val email = resultSet.getString("employee_email")
      val dob = resultSet.getString("employee_dob")
      val department = resultSet.getString("department")
      val designation = resultSet.getString("designation")

      listBuffer += EmployeeFields(name, age, email, dob, designation, department)
      resultSetToList(resultSet)
    }
    else
      listBuffer.toList
  }
}

