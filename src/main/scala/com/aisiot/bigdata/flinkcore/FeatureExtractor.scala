package com.aisiot.bigdata.flinkcore

import org.apache.flink.api.common.functions.MapFunction

import scala.collection.mutable.ListBuffer

import java.lang.Integer

case class FeatureExtractor() extends MapFunction[String, Sample] {

  override def map(value: String): Sample = {
    val atributeList = value.split("\\t").toBuffer
    val label = false // dorobić odpowiednie LABELe
    val features = ListBuffer[Map[Int, String]]()

    // wyrzucamy niepotrzebne rzeczy
    atributeList.remove(23,1)
    atributeList.remove(21,1)
    atributeList.remove(18,1)
    atributeList.remove(8,1)
    atributeList.remove(3,1)
    atributeList.remove(0,1)

    // wyciągamy przeglądarke i os
    val browser = extractBrowser(atributeList(2))
    val os = extractOS(atributeList(2))

    // robimy atyrbuty
    val feature0 = Integer.toBinaryString(atributeList(0).toInt)
    features += Map(0 -> feature0)

    val feature1 = Integer.toBinaryString(atributeList(1).toInt)
    features += Map(1 -> feature1)

    val feature2 = Integer.toBinaryString(browser)
    features += Map(2 -> feature2)

    val feature3 = Integer.toBinaryString(os) // trzeba połączyć features
    features += Map(3 -> feature3)

    val f4 = atributeList(4).hashCode
    val feature4 = Integer.toBinaryString(f4.toInt) // trzeba połączyć features
    features += Map(4 -> feature4)

    val feature5 = Integer.toBinaryString(atributeList(5).toInt) // trzeba połączyć features
    features += Map(5 -> feature5)

    val feature6 = Integer.toBinaryString(atributeList(6).toInt) // trzeba połączyć features
    features += Map(6 -> feature6)

    val f7 = atributeList(7).hashCode
    val feature7 = Integer.toBinaryString(f7.toInt) // trzeba połączyć features
    features += Map(7 -> feature7)

    val f8 = atributeList(8).hashCode
    val feature8 = Integer.toBinaryString(f8.toInt) // trzeba połączyć features
    features += Map(8 -> feature8)

    val f9 = atributeList(9).hashCode
    val feature9 = Integer.toBinaryString(f9.toInt) // trzeba połączyć features
    features += Map(9 -> feature9)

    val f10 = atributeList(10).hashCode
    val feature10 = Integer.toBinaryString(f10.toInt) // trzeba połączyć features
    features += Map(10 -> feature10)

    val feature11 = Integer.toBinaryString(atributeList(11).toInt) // trzeba połączyć features
    features += Map(11 -> feature11)

    val feature12 = Integer.toBinaryString(atributeList(12).toInt) // trzeba połączyć features
    features += Map(12 -> feature12)

    val feature13 = Integer.toBinaryString(atributeList(13).toInt) // trzeba połączyć features
    features += Map(13 -> feature13)

    val feature14 = Integer.toBinaryString(atributeList(14).toInt) // trzeba połączyć features
    features += Map(14 -> feature14)

    val feature15 = Integer.toBinaryString(atributeList(15).toInt) // trzeba połączyć features
    features += Map(15 -> feature15)

    val feature16 = Integer.toBinaryString(atributeList(16).toInt) // trzeba połączyć features
    features += Map(16 -> feature16)

    val feature17 = Integer.toBinaryString(atributeList(17).toInt) // trzeba połączyć features
    features += Map(17 -> feature17)

    val feature18 = Integer.toBinaryString(atributeList(18).toInt) // trzeba połączyć features
    features += Map(18 -> feature18)

    val featuresList = features.toList
    Sample(label, featuresList)
  }

  def extractBrowser(str: String): Int = {
    if (str.contains("Mozilla")) 0
    else if (str.contains("MQQ")) 1
    else if (str.contains("Safari")) 2
    else if (str.contains("Chrome")) 3
    else 4
  }

  def extractOS(str: String): Int = {
    if (str.contains("Windows")) 0
    else if (str.contains("Mac")) 1
    else if (str.contains("Linux")) 2
    else 3
  }

}
