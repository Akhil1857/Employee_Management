package database

import structure.{Designation, EmployeeFields}
/*
* create table (
* id serial NOT NULL PRIMARY KEY,
* name varchar(200) NOT NULL,
*
*
*
* */
import scala.collection.mutable.ListBuffer
import scala.util.Try

class DAOImpl extends DAO {

//  val statement = Connection.connection.createStatement()
//  val query = "SELECT * FROM usertbl ;"
//  statement.executeQuery(query)

  private var employeeDatabase: ListBuffer[EmployeeFields] = ListBuffer.empty

  override def addEmployee(employee: EmployeeFields): Try[String] = Try {
//    val query = s"INSERT INTO usertbL(fiels..........) values ( '${employee.employeeName}',) "
//
//    statement.executeQuery(query)
    assert(employee.employeeName.nonEmpty && employee.employeeName.length < 20)

    assert(employee.employeeID > 0)
    assert {
      if ("""(?=[^\s]+)(?=(\w+)@([\w\.]+))""".r.findFirstIn(employee.employeeEmail).isEmpty) false else true
    }
    employeeDatabase += employee
    s"User having ${employee.employeeID} as employee Id added Successfully"
  }

  override def getDetailsById(employeeId: Int): Option[EmployeeFields] = {
    employeeDatabase.find(_.employeeID == employeeId)
  }

  override def getOrganizationDetails: Try[ListBuffer[EmployeeFields]] = Try {
    employeeDatabase
  }

  override def updateDetailsById(employeeID: Int, entryToUpdate: String): Try[ListBuffer[EmployeeFields]] = Try {
    employeeDatabase.map {
      case person if person.employeeID == employeeID => person.copy(employeeName = entryToUpdate)
      case person => person
    }
  }

  override def deleteDetailsById(employeeId: Int): Try[ListBuffer[EmployeeFields]] = Try {
    employeeDatabase = employeeDatabase.filterNot(_.employeeID == employeeId)
    employeeDatabase
  }

  override def deleteAll(): Try[String] = Try {
    employeeDatabase.clear()
    "No details Present in the database -- All Clear"
  }

  override def filterDepartment(departments: String): Try[ListBuffer[EmployeeFields]] = Try {
    employeeDatabase.filter(employee => employee.department == departments)
  }

  override def filterByDesignation(designation: Designation): Try[ListBuffer[EmployeeFields]] = Try {
    employeeDatabase.filter(employee => employee.designation == designation)
  }


}

