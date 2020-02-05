(ns assignments.conditions-test
 (:require [clojure.test :refer :all]
					 [assignments.conditions :refer :all]))

(deftest safe-division
 (testing "non zero denominator"
	(is (= 2 (safe-divide 4 2))))
 (testing "zero denominator"
	(is (nil? (safe-divide 3 0)))))

(deftest informative-division
 (testing "non zero denominator"
	(is (= 2 (informative-divide 4 2))))
 (testing "zero denominator"
	(is (= :infinite (informative-divide 4 0)))))

(deftest test-harishchandra
 (testing "truthy value"
	(is (= true (harishchandra true))))
 (testing "falsy value"
	(is (= nil (harishchandra false)))))

(deftest test-yudishtira
 (testing "truthy value"
	(is (= true (yudishtira true))))
 (testing "falsy value"
	(is (= :ashwathama (yudishtira false)))))

(deftest test-duplicate-first
 (testing "non-empty list"
	(is (= [1 1 2] (duplicate-first [1 2]))))
 (testing "empty list"
	(is (= nil (duplicate-first [])))))

(deftest test-five-point-someone
 (testing "x equals 5"
	(is (= :satan-bhagat (five-point-someone 5 3))))
 (testing "y equals 5"
	(is (= :chetan-bhagat (five-point-someone 3 5))))
 (testing "x greater than y"
	(is (= :greece (five-point-someone 10 9))))
 (testing "else condition"
	(is (= :universe (five-point-someone 10 20)))))

(deftest test-zero-aliases
 (testing "0"
	(is (= :zero (zero-aliases 0))))
 (testing "empty"
	(is (= :empty (zero-aliases []))))
 (testing "empty set"
	(is (= :empty-set (zero-aliases #{}))))
 (testing "empty map"
	(is (= :empty-map (zero-aliases {}))))
 (testing "empty string"
	(is (= :empty-string (zero-aliases ""))))
 (testing "non zero"
	(is (= :non-zero (zero-aliases "some non zero value")))))

(deftest zero-separated-palindrome-test
 (testing "non-empty collection"
	(is (= `(4 3 2 0 2 3 4) (zero-separated-palindrome [1 2 3]))))
 (testing "empty collection"
	(is (= `(0) (zero-separated-palindrome [])))))

(deftest order-in-words-test
 (testing "x>y>z"
	(is (= [:x-greater-than-y :y-greater-than-z] (order-in-words 4 3 2))))
 (testing "z>x>y"
	(is (= [:x-greater-than-y :z-greater-than-x] (order-in-words 4 3 5))))
 (testing "z>x"
	(is (= [:z-greater-than-x] (order-in-words 2 3 4)))))

(deftest repeat-and-truncate-test
 (testing "truncate true"
	(is (= [0 1 2] (doall (repeat-and-truncate (range 4) false true 3)))))
 (testing "repeat and truncate true"
	(is (= [0 1 2 3 0 1] (doall (repeat-and-truncate (range 4) true true 6))))))

(deftest conditions-apply-test
 (testing "1 3 are in order"
	(is (= :wonder-woman (conditions-apply [1 2 3]))))
 (testing "1 3 are not in order"
	(is (= :tuntun (conditions-apply [3 1 2]))))
 (testing "1 3 occurs more than one time"
	(is (= :tuntun (conditions-apply [1 1 3]))))
 (testing ":a :b :c are in order"
	(is (= :durga (conditions-apply [:a :b :c :d]))))
 (testing ":a :b :c are not in order"
	(is (= :tuntun (conditions-apply [:a :c :b]))))
 (testing ":a :b :c occurs more than one time"
	(is (= :tuntun (conditions-apply [:a :a ::c]))))
 (testing "[2 3] [4 5] are in order"
	(is (= :cleopatra (conditions-apply [[2 3] [4 5]]))))
 (testing "[2 3] [4 5] are not in order"
	(is (= :tuntun (conditions-apply [[4 5] [2 3]]))))
 (testing "[2 3] [4 5] occurs more than one time"
	(is (= :tuntun (conditions-apply [[2 3] [2 3] [4 5]])))))
