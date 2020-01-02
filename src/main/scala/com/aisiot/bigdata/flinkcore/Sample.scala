package com.aisiot.bigdata.flinkcore

case class Sample(label: Boolean, featureVector: List[Map[Int, String]]) {


//  def getVector: Array[Double] = {
//    val v = Array.emptyDoubleArray
//    featureVector.keys.foreach(ind => v(ind) = 1)
//    v
//  }

  def render(): String = {
    if (label) "0 " else "1 "
  }
}
