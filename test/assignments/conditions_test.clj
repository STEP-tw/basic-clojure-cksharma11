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