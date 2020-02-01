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


(deftest count-test
	(testing "sequence length"
		(is (= 5 (count' [1 2 3 4 5]))))
	(testing "nil"
		(is (= 0 (count' nil))))
	(testing "[]"
		(is (= 0 (count' []))))
	(testing "map"
		(is (= 2 (count {:one 1 :two 2}))))
	(testing "string"
		(is (= 6 (count "abcdef")))))

(deftest reduce-test
	(testing "arity 2"
		(is (= 15 (reduce' + [1 2 3 4 5]))))
	(testing "arity 3"
		(is (= 15 (reduce' + 1 [2 3 4 5])))))

(deftest everys
	(testing "with empty list"
		(is (= true (every?' even? []))))
	(testing "with all true values"
		(is (= true (every?' even? [2 4 6]))))
	(testing "with all falsy values"
		(is (= false (every?' even? [1 3 5]))))
	(testing "with some true values"
		(is (= false (every?' even? [1 2])))))

(deftest somes
	(testing "with empty list"
		(is (= false (some?' even? []))))
	(testing "with all true values"
		(is (= true (some?' even? [2 4 6]))))
	(testing "with all falsy values"
		(is (= false (some?' even? [1 3 5]))))
	(testing "with some true values"
		(is (= true (some?' even? [1 2])))))

(deftest ascendings
	(testing "with ascending list"
		(is (= true (ascending? [1 2 3]))))
	(testing "with not ascending list"
		(is (= false (ascending? [2 14 6])))))

(deftest sum-of-adjacent-digits-test
	(testing "with ascending list"
		(is (= [3 5] (sum-of-adjacent-digits [1 2 3])))))
