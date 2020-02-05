(ns assignments.lists-test
 (:require [clojure.test :refer :all]
					 [assignments.lists :refer :all]))

(deftest lists
 (testing "map"
	(testing "identity with single coll"
	 (is (= [1 2 3] (map' identity [1 2 3]))))))

(deftest filter-test
 (testing "filter"
	(testing "filter with pred"
	 (is (= [1 3] (filter' odd? [1 2 3]))))))

(deftest reverse-test
 (testing "valid sequence"
	(is (= [3 2 1] (reverse' [1 2 3])))))

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

(deftest every-test
 (testing "with empty list"
	(is (= true (every?' even? []))))
 (testing "with all true values"
	(is (= true (every?' even? [2 4 6]))))
 (testing "with all falsy values"
	(is (= false (every?' even? [1 3 5]))))
 (testing "with some true values"
	(is (= false (every?' even? [1 2])))))

(deftest some-test
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

(deftest difference-test
 (testing "different list"
	(is (= '(4 5) (difference [1 2 3] [1 2 3 4 5]))))
 (testing "same list"
	(is (= '() (difference [1 2 3] [1 2 3])))))

(deftest muted-thirds-test
 (testing "different list"
	(is (= '(1 2 0 4 5 0) (muted-thirds [1 2 3 4 5 6])))))

(deftest palindrome-test
 (testing "valid palindrome"
	(is (= true (palindrome? [1 2 3 2 1]))))
 (testing "invalid palindrome"
	(is (= false (palindrome? [1 2 3])))))

(deftest index-of-test
 (testing "element present in collection"
	(is (= 1 (index-of [1 2 3] 2))))
 (testing "element not present in collection"
	(is (= -1 (index-of [1 2 3] 4)))))

(deftest russian-dolls-test
 (testing "[1 2 3] 3 => [[[1]] [[2]] [[3]]]"
	(is (= [[[1]] [[2]] [[3]]] (russian-dolls [1 2 3] 3)))))

(deftest split-comb-test
 (testing "[1 2 3 4 5] => [1 3 2 4 5]"
	(is (= [1 3 2 4 5] (split-comb [1 2 3 4 5])))))

(deftest double-up-test
 (testing "with empty sequence"
	(is (= [] (double-up []))))
 (testing "with integer sequence"
	(is (= [1 1 2 2 3 3] (double-up [1 2 3]))))
 (testing "with string sequence"
	(is (= ["I" "I" "love" "love" "clojure" "clojure"]
				 (double-up ["I" "love" "clojure"])))))

(deftest third-or-fifth-test
 (testing "with single item"
	(is (= ["I"] (third-or-fifth ["I"]))))
 (testing "with collection containing 4 items - last index is 3"
	(is (= [1 4] (third-or-fifth [1 2 3 4]))))
 (testing "with collection containing 6 items - last index is 5"
	(is (= [1 4 6] (third-or-fifth [1 2 3 4 5 6])))))

(deftest cross-product-test
 (testing ""
	(is (= [[1 4] [1 3] [1 5] [2 4] [2 3] [2 5] [3 4]] (cross-product [1 2 3] [4 3 5])))))

(deftest distinct-test
 (testing "with no duplicates"
	(is (= [1 2 3] (distinct' [1 2 3]))))
 (testing "with duplicates"
	(is (= [1 2 3] (distinct' [1 1 2 3 2])))))

(deftest validate-sudoku-grid-test
 (testing "correct grid"
	(is (true? (validate-sudoku-grid
							[[4 3 5 2 6 9 7 8 1]
							 [6 8 2 5 7 1 4 9 3]
							 [1 9 7 8 3 4 5 6 2]
							 [8 2 6 1 9 5 3 4 7]
							 [3 7 4 6 8 2 9 1 5]
							 [9 5 1 7 4 3 6 2 8]
							 [5 1 9 3 2 6 8 7 4]
							 [2 4 8 9 5 7 1 3 6]
							 [7 6 3 4 1 8 2 5 9]]))))
 (testing "incorrect grid"
	(is (false? (validate-sudoku-grid
							 [[4 4 5 2 6 9 7 8 1]
								[6 8 2 5 7 1 4 9 3]
								[1 9 7 8 3 4 5 6 2]
								[8 2 6 1 9 5 3 4 7]
								[3 7 4 6 8 2 9 1 5]
								[9 5 1 7 4 3 6 2 8]
								[5 1 9 3 2 6 8 7 4]
								[2 4 8 9 5 7 1 3 6]
								[7 6 3 4 1 8 2 5 9]])))))