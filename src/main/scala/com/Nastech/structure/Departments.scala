package com.Nastech.structure

sealed trait Designation

object Designation extends Designation {
  case object TechnicalArchitect extends Designation

  case object SoftwareDeveloper extends Designation

  case object SoftwareTester extends Designation

  case object Sales extends Designation

  case object Marketing extends Designation

  case object AdminAssistant extends Designation

  case object Receptionist extends Designation
}


sealed trait Departments

trait Technical extends Departments

trait NonTechnical extends Departments

trait Helper extends Departments

object Departments {
  case object TechnicalArchitect extends Technical {
    override def toString: String = "Technical"
  }

  case object SoftwareDeveloper extends Technical {
    override def toString: String = "Technical"
  }

  case object SoftwareTester extends Technical {
    override def toString: String = "Technical"
  }

  case object Sales extends NonTechnical {
    override def toString: String = "NonTechnical"
  }

  case object Marketing extends NonTechnical {
    override def toString: String = "NonTechnical"
  }

  case object AdminAssistant extends Helper {
    override def toString: String = "Helper"
  }

  case object Receptionist extends Helper {
    override def toString: String = "Helper"
  }

}