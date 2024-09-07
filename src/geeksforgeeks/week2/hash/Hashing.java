package geeksforgeeks.week2.hash;

public class Hashing {
}

// ["Geeks"]["For"]["Test"]
//     0       1      2
// 0 -> Geeks
// 1 -> For
// 2 -> Test

// <String, String>
// One   -> Geeks -> 1_00_000
// Two -> For -> 200
// Three (3) -> Test -> 300
// Four -> Amazing -> 300
// [][Geeks][For][[Test][Amazing]]
// Bucket -> ListNodes

// Object -> String
//    hashCode()

// "One".hashCode() -> it converts your object into an int (by using its memory location)
// [default]