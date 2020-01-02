package com.aisiot.bigdata.flinkcore

import org.apache.flink.streaming.api.scala._
import org.apache.flink.core.fs.FileSystem


object flinkwc {
  def main(args: Array[String]) {
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    env.setParallelism(1)

    val stream: DataStream[String] = env.readTextFile("C:/Users/marce/Desktop/clk.20130611.txt")
    val sampleStream = stream.map(FeatureExtractor())

    sampleStream.writeAsText("output.txt", FileSystem.WriteMode.OVERWRITE)

    env.execute("Window Stream")
  }
}
//
////def converttobinary(n:Int, bin:List[Int]):String = {
////  if(n/2 == 1) (1:: (n % 2) :: bin).mkString(" ")
////  else {
////  val r = n % 2;
////  val q = n / 2;
////  converttobinary(q, r::bin)
////}
////   def makeWordsVector(x: String): Unit = {
////    val lista = args.split("\\s")
////    var tempwektor : List[Int] = List()
////    var wektor : Vector[Int] = Vector()
////    for(x <- lista){
////      val temp = x.toCharArray
////      var cyfra = true
////      var binary = ""
////      for(y <- temp){
////        if(!y.isDigit){
////          cyfra = false
////        }
////      }
////      if(cyfra==false){
////        var hash = x.hashCode
////        binary = converttobinary(hash, tempwektor)
////      } else{
////        binary = converttobinary(x.toInt, tempwektor)
////      }
////      for(x <- binary){
////        if(x == '0'){
////          wektor.apply(0)
////        }else if(x == '1'){
////          wektor.apply(1)
////        }
////      }
////    }
////    val pw = new PrintWriter(new File("hello.txt" ))
////    pw.write(wektor.toString())
////    pw.close
//
////    print(x)
////  }
//
//
////var licznik = 0
//
////val reg1 = """\(?([a-z]*)+\/+(\.*[0-9]+\.[0-9]+)+""".r
////val reg2 = """\(([a-z]*)+.+\)""".r

////////////////////////////////////////// MC Kasia ///////////////////////////////////////////////////////////////////////
//
//package com.aisiot.bigdata.flinkcore
//
//import org.apache.flink.core.fs.FileSystem
//import org.apache.flink.streaming.api.scala._
//import scala.reflect.macros.whitebox
//
//object flinkwc {
//
//  def fit(state: Option[Array[Double]], sample: Sample): Array[Double] = {
//    val model = state.getOrElse(Array.emptyDoubleArray)
//    val vector = sample.getVector
//    // logistic regression
//
//    model
//  }
//
//  def predict(model: Array[Double], sample: Sample) = ???
//
//  def main(args: Array[String]) {
//    // set up the execution environment
//    val env = StreamExecutionEnvironment.getExecutionEnvironment
//    env.setParallelism(1)
//
//    val source: DataStream[String] =
//      env.readTextFile("C:/Users/marce/Desktop/Inżynier/FlinkProjects/data.txt")
//
//    implicit val sampleStream: DataStream[Sample] = source.map(FeatureExtractor())
//
//    sampleStream
//      .keyBy(x => 0)
//      .mapWithState((sample: Sample, state: Option[Array[Double]]) => {
//        val model = fit(state, sample)
//        val p = predict(model, sample)
//        (p, Some(model))
//      })
//
//    sampleStream.writeAsText("output.txt", FileSystem.WriteMode.OVERWRITE)
//
//    // execute program
//    env.execute("Flink Scala API Skeleton")
//  }
//}


//    val without_chars = data.map {
//      x =>
//        val writer = new PrintWriter("C:/Users/marce/Desktop/test.txt")
//        //x;
//        val temp = ListBuffer[String]()
//        x.split("\\t").map(temp += _) // rozdzielam atrybuty i dodaje do pliku
//
//        val short = ListBuffer[Int]()
//        short += temp(2).toInt // zabieram tylko rodzaj akcji
//        short += temp(6).toInt // i Ad exchange
//
//        val bin = ListBuffer[String]()
//        short.foreach { x =>
//          bin += Integer.toBinaryString(x) // zamieniam na wartosci binarne
//        }
//
//        bin.foreach { x =>
//          writer.write(x + "\n") // zapisuje do pliku
//          writer.close()
//        }
//
//        print(short)
//        println(bin)
//    }
//