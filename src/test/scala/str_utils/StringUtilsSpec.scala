package str_utils

import org.scalacheck.Prop.forAll
import org.scalacheck.{Prop, Properties}
import org.scalacheck.Gen.{listOf, alphaStr, numChar}
import Prop.AnyOperators

object StringUtilsSpec extends Properties("StringUtils")
{
  property("truncate") = forAll { (s: String, n: Int) =>
    lazy val t = StringUtils.truncate(s, n)
    if (n < 0)
      Prop.throws(classOf[StringIndexOutOfBoundsException]) { t }
    else
      (s.length <= n && t == s) || (s.length > n && t == s.take(n) + "...")
  }

  property("tokenize") = forAll(listOf(alphaStr), numChar) {
      (ts, d) =>
        val str = ts.mkString(d.toString)
        val result = StringUtils.tokenize(str, d).toList
        result ?= ts.filter(_ != "")
    }

  property("contains") = forAll { (s1: String, s2: String, s3: String) =>
    StringUtils.contains(s1+s2+s3, s2)
  }
}
