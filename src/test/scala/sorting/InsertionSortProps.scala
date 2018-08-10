package sorting

import org.scalacheck.{Gen, Properties}
import org.scalacheck.Prop.{forAll, BooleanOperators}
import org.scalacheck.Arbitrary.arbitrary

object InsertionSortProps extends Properties("InsertionSort")
{
  val genArrays: Gen[(List[Int], Array[Int])] = arbitrary[List[Int]] map
  {
    l => val a = l.toArray[Int]
    InsertionSort.sort(a)
    (l, a)
  }

  property("sort: array's length should be preserved") = forAll(genArrays)
  {
    case (l, a) => a.length == l.length
  }

  property("sort: single-item array should be untouched") = forAll(genArrays)
  {
    case (l, a) => l.nonEmpty ==> { (l.length != 1) || (a(0) == l.head) }
  }

  property("sort: array sorted") = forAll(genArrays)
  {
    case (l, a) => (l.length > 1) ==> a.sliding(2).forall { e => e.length == 2 && e(0) <= e(1) }
  }
}
