(ns sicp.ex1_41
  (:use [clojure.contrib test-is]
	[sicp utils]
	[sicp ch1_3]))

(defn doub [f]
  (fn [x] (f (f x))))

(deftest test-doub-doub-doub-inc-5
  (is (= (((doub (doub doub)) inc) 5)
	 21)))

(deftest test-doub-inc-1
  (is (= ((doub inc) 1)
	 3)))

(deftest test-doub-doub-inc-1
  (is (= (((doub (doub doub)) inc) 1)
	 17)))

(comment
(((doub (doub doub)) inc) 5)
;;=> 21
user> ((doub inc) 1)
;;=> 3
user> (((doub doub) inc) 1)
;;=> 5
user> (((doub (doub doub)) inc) 1)
;;=> 17
user> (((doub (doub (doub doub))) inc) 1)
;;=> 257
user> (((doub (doub (doub (doub doub)))) inc) 1)
;;=> 65537
)