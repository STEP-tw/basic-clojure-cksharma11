(ns assignments.lists-test
  (:require [clojure.test :refer :all]
            [assignments.lists :refer :all]))

(deftest lists
  (testing "map"
    (testing "identity with single coll"
      (is (= [1 2 3] (map' identity [1 2 3]))))))

(deftest filters
  (testing "filter"
    (testing "filter with pred"
      (is (= [1 3] (filter' odd? [1 2 3]))))))

(deftest reverses
	(testing "valid sequence"
		(is (= [3 2 1] (reverse' [1 2 3]))))
	(testing "invalid sequence"
		(is (= nil (reverse' 1)))))

(deftest counting
	(testing "valid sequence"
		(is (= 3 (count' [1 2 3])))))