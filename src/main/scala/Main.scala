import database.DAOImpl
import service.Services
import structure.Designation.{SoftwareDevelopment, SoftwareTester, TechnicalArchitect}
import structure.EmployeeFields
import org.slf4j.LoggerFactory


object Main extends App {

  private val logger = LoggerFactory.getLogger(getClass)

  private val employeeDB = new DAOImpl
  private val service = new Services(employeeDB)

  private val employee1 = EmployeeFields(1857, "Akhil", 22, "Akhiltrivedi83@gmail.com", "08/04/2002", TechnicalArchitect,"Technical")
  service.addEmployee(employee1)
  private val employee2 = EmployeeFields(1858, "Akhil", 22, "Akhiltrivedi83@gmail.com", "08/04/2002", SoftwareDevelopment, "NonTechnical")
  service.addEmployee(employee2)
  private val employee3 = EmployeeFields(1859, "Prakhar", 26, "Prakhar@gmail.com", "10/04/2000", SoftwareTester, "Technical")
  service.addEmployee(employee3)

  private val listOfEmployee = service.getOrganizationDetails
  logger.info(s"$listOfEmployee")

  private val listOfSameDepartment = service.filterDepartment("Technical")
  logger.info(s"$listOfSameDepartment")

  private val updatedList = service.updateDetailsById(1857, "Akhil")
  logger.info(s"$updatedList")

  private val deleteById = service.deleteDetailsById(1858)
  logger.info(s"$deleteById")

  private val detailsUsingId = service.getDetailsById(1857)
  logger.info(s"$detailsUsingId")

  private val filterByDesignation = service.filterByDesignation(SoftwareTester)
  logger.info(s"$filterByDesignation")

  private val deleteAll = service.deleteAll()
  logger.info(s"$deleteAll")

}
