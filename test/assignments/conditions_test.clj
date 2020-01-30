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