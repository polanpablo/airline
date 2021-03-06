package com.patson.model.airplane

import com.patson.model.IdObject
import com.patson.model.Airline

case class Model(name : String, capacity : Int, fuelBurn : Int, speed : Int, range : Int, price : Int, lifespan : Int, constructionTime : Int, countryCode : String, imageUrl : String = "", var id : Int = 0) extends IdObject {
  import Model.Type._
  val airplaneType : Type = {
    capacity match {
      case x if (x <= 15) => LIGHT
      case x if (x <= 60) => REGIONAL
      case x if (x <= 150) => SMALL 
      case x if (x <= 250) => MEDIUM
      case x if (x <= 350) => LARGE
      case _ => JUMBO
    }
  }
  val turnoverTime : Int = {
    airplaneType match {
      case LIGHT => 45
      case REGIONAL => 70
      case SMALL => 100 
      case MEDIUM => 140
      case LARGE => 180
      case JUMBO => 220 
    }
  }
  
  //weekly fixed cost
  val maintenanceCost : Int = { 
    (capacity * 100).toInt //for now
  }
}

object Model {
  def fromId(id : Int) = {
    val modelWithJustId = Model("", 0, 0, 0, 0, 0, 0, 0, countryCode = "")
    modelWithJustId.id = id
    modelWithJustId
  }
  object Type extends Enumeration {
    type Type = Value
    val LIGHT, REGIONAL, SMALL, MEDIUM, LARGE, JUMBO = Value
  }
  //https://en.wikipedia.org/wiki/List_of_jet_airliners
  val models = List(Model("Cessna 421", capacity = 7, fuelBurn = (7 * 1).toInt, speed = 300, range = 1555, price = 550000, lifespan = 35 * 52, constructionTime = 0, countryCode = "US"),
                      Model("Cessna Caravan", capacity = 14, fuelBurn = (14 * 1).toInt, speed = 344, range = 2400, price = 2500000, lifespan = 35 * 52, constructionTime = 0, countryCode = "US", imageUrl = "https://www.norebbo.com/2017/06/cessna-208-grand-caravan-blank-illustration-templates/"),
                      Model("Embraer EMB120 Brasilia", capacity = 30, fuelBurn = (30 * 1.9).toInt, speed = 552, range = 1750, price = 8000000, lifespan = 35 * 52, constructionTime = 0, countryCode = "BR", imageUrl = "https://www.norebbo.com/2015/02/embraer-120-brasilia-blank-illustration-templates/"),
                      Model("Embraer ERJ140", capacity = 44, fuelBurn = (44 * 2.5).toInt, speed = 828, range = 2315, price = 15000000, lifespan = 35 * 52, constructionTime = 0, countryCode = "BR", imageUrl = "https://www.norebbo.com/2018/05/embraer-erj-140-blank-illustration-templates/"),
                      Model("Bombardier CRJ200", capacity = 50, fuelBurn = (50 * 1.6).toInt, speed = 830, range = 3150, price = 30000000, lifespan = 35 * 52, constructionTime = 0, countryCode = "CA", imageUrl = "https://www.norebbo.com/2015/04/bombardier-canadair-regional-jet-200-blank-illustration-templates/"),
                      Model("Bombardier CRJ700", capacity = 78, fuelBurn = (78 * 3).toInt, speed = 828, range = 3045, price = 42000000, lifespan = 35 * 52, constructionTime = 4, countryCode = "CA", imageUrl = "https://www.norebbo.com/2015/05/bombardier-canadair-regional-jet-700-blank-illustration-templates/"),
                      Model("Antonov An148", capacity = 85, fuelBurn = (85 * 3.8).toInt, speed = 835, range = 3500, price = 30000000, lifespan = 20 * 52, constructionTime = 4, countryCode = "UA"),
                      Model("Embraer EMB170-200", capacity = 88, fuelBurn = (88 * 3).toInt, speed = 871, range = 2200, price = 50000000, lifespan = 30 * 52, constructionTime = 4, countryCode = "BR", imageUrl = "https://www.norebbo.com/2015/10/embraer-erj-175-templates-with-the-new-style-winglets/"),
                      Model("Comac ARJ21", capacity = 90, fuelBurn = (90 * 3.5).toInt, speed = 828, range = 2200, price = 45000000, lifespan = 25 * 52, constructionTime = 8, countryCode = "CN"),
                      Model("Sukhoi Superjet 100", capacity = 108, fuelBurn = (108 * 4.1).toInt, speed = 828, range = 4578, price = 40000000, lifespan = 30 * 52, constructionTime = 8, countryCode = "RU", imageUrl = "https://www.norebbo.com/2016/02/sukhoi-ssj-100-blank-illustration-templates/"),
                      Model("Airbus A318", capacity = 132, fuelBurn = (132 * 3).toInt, speed = 829, range = 7800, price = 90000000, lifespan = 35 * 52, constructionTime = 8, countryCode = "NL", imageUrl = "https://www.norebbo.com/2018/01/airbus-a318-blank-illustration-templates-with-pratt-whitney-and-cfm56-engines/"),
                      Model("Bombardier CS100", capacity = 133, fuelBurn = (133 * 3.5).toInt, speed = 828, range = 5741, price = 80000000, lifespan = 35 * 52, constructionTime = 8, countryCode = "CA", imageUrl = "https://www.norebbo.com/2016/02/bombardier-cs100-blank-illustration-templates/"),
                      Model("Boeing 737-700C", capacity = 140, fuelBurn = (140 * 3.5).toInt, speed = 825, range = 6083, price = 85000000, lifespan = 35 * 52, constructionTime = 12, countryCode = "US", imageUrl = "https://www.norebbo.com/2014/04/boeing-737-700-blank-illustration-templates/"),
                      Model("Boeing 737-800", capacity = 184, fuelBurn = (184 * 3.8).toInt, speed = 825, range = 5436, price = 100000000, lifespan = 35 * 52, constructionTime = 24, countryCode = "US", imageUrl = "https://www.norebbo.com/2012/11/boeing-737-800-blank-illustration-templates/"),
                      Model("Tupolev Tu-204", capacity = 210, fuelBurn = (210 * 4.5).toInt, speed = 810, range = 4300, price = 50000000, lifespan = 25 * 52, constructionTime = 24, countryCode = "RU"),
                      Model("Boeing 787-8 Dreamliner", capacity = 250, fuelBurn = (250 * 4.5).toInt, speed = 907, range = 13621, price = 125000000, lifespan = 35 * 52, constructionTime = 36, countryCode = "US", imageUrl = "https://www.norebbo.com/2013/02/boeing-787-8-blank-illustration-templates/"),
                      Model("Ilyushin Il-96-300", capacity = 300, fuelBurn = (300 * 5).toInt, speed = 850, range = 11500, price = 60000000, lifespan = 25 * 52, constructionTime = 36, countryCode = "RU"),
                      Model("Boeing 767-300ER", capacity = 350, fuelBurn = (350 * 4.5).toInt, speed = 913, range = 11093, price = 181000000, lifespan = 35 * 52, constructionTime = 36, countryCode = "US", imageUrl = "https://www.norebbo.com/2014/07/boeing-767-300-blank-illustration-templates/"),
                      Model("Airbus A330-300", capacity = 380, fuelBurn = (380 * 4.7).toInt, speed = 871, range = 11300, price = 220000000, lifespan = 35 * 52, constructionTime = 48, countryCode = "NL", imageUrl = "https://www.norebbo.com/2016/02/airbus-a330-300-blank-illustration-templates-with-all-three-engine-options/"),
                      Model("Ilyushin 96-400", capacity = 436, fuelBurn = (436 * 6.4).toInt, speed = 870, range = 10000, price = 50000000, lifespan = 30 * 52, constructionTime = 48, countryCode = "RU"),
                      Model("Airbus A350-900", capacity = 440, fuelBurn = (440 * 5).toInt, speed = 903, range = 15000, price = 280000000, lifespan = 35 * 52, constructionTime = 48, countryCode = "NL", imageUrl = "https://www.norebbo.com/2013/07/airbus-a350-900-blank-illustration-templates/"),
                      Model("Boeing 777-300", capacity = 550, fuelBurn = (550 * 5.5).toInt, speed = 945, range = 11121, price = 300000000, lifespan = 35 * 52, constructionTime = 48, countryCode = "US", imageUrl = "https://www.norebbo.com/2014/03/boeing-777-300-blank-illustration-templates/"),
                      Model("Boeing 747-400", capacity = 660, fuelBurn = (660 * 5.7).toInt, speed = 945, range = 13446, price = 350000000, lifespan = 35 * 52, constructionTime = 48, countryCode = "US", imageUrl = "https://www.norebbo.com/2013/09/boeing-747-400-blank-illustration-templates/"),
                      Model("Airbus A380-800", capacity = 853, fuelBurn = (853 * 6).toInt, speed = 945, range = 15700, price = 450000000, lifespan = 35 * 52, constructionTime = 54, countryCode = "NL", imageUrl = "https://www.norebbo.com/2013/06/airbus-a380-800-blank-illustration-templates/"))
                      
  val modelByName = models.map { model => (model.name, model) }.toMap 
}



