(use 'clojure.test)

(is (= 3 (+ 1 2)))
(is (= '[1 2 3 4] (concat [1 2] [3 4])))
(is (= 6 (+ 1 2 3)))
(is (= 0 (+)))
(is (= 1 (*)))
(is (= 5 (- 10 5)))
(is (= 300 (* 3 10 10)))
(is (> 5 2))
(is (>= 5 5))
(is (not (< 5 2)))
(is (not (= 5 2)))
(is (= clojure.lang.Ratio (class (/ 22 7))))
(is (< 3.142 (/ 22.0 7)))
(is (> 3.143 (/ 22.0 7)))
(is (= 3 (quot 22 7)))
(is (= 1 (rem 22 7)))

(is (= "HELLO" (.toUpperCase "hello")))
(is (= "123" (str 1 2 nil 3)))
(is (= "hey you" (str \h \e \y \space \y \o \u)))
(is (= \S (Character/toUpperCase \s)))
(is (= "ATthtea cpku raptl em iedlneipghhatn"
       (apply str (interleave
                   "Attack at midnight"
                   "The purple elephant chortled"))))
(is (= "Attack at midnight"
       (apply str (take-nth 2 "ATthtea cpku raptl em iedlneipghhatn"))))

(is (= "Clojure" (if () "Clojure" "CL")))
(is (= "zero true" (if 0 "zero true" "zero false")))
(is (true? true))
(is (not (true? "foo")))
(is (false? false))
(is (not (false? nil)))
(is (nil? nil))
(is (not (nil? false)))
(is (zero? 0))
(is (zero? 0.0))
(is (zero? (/ 0 17)))
(is (not (zero? 1)))

(def inventors {
     "Lisp"    "McCarthy",
     "Clojure" "Hickey"})
(is (= "McCarthy" (inventors "Lisp")))
(is (nil?         (inventors "Foo")))
(is (= "McCarthy" (get inventors "Lisp" "Dunno")))
(is (= "Dunno"    (get inventors "Foo"  "Dunno")))
(def inventors {
     :Lisp    "McCarthy",
     :Clojure "Hickey"})
(is (= "Hickey" (inventors :Clojure)))
(is (= "Hickey" (:Clojure inventors)))

(defstruct book :title :author)
(def b (struct book "Anathem" "Stephenson"))
(is (= "Anathem" (:title b)))
(def b2 (struct-map book :copyright 2008 :title "Anathem"))
(is (nil? (:author b2)))
(is (= 2008 (:copyright b2)))

(is (= "hello world" (str "hello" " " "world")))
(is (string? "hello"))
(is (keyword? :hello))
(is (symbol? 'hello))

(defn greeting
  "Personalized or generic greeting, depending in whether name provided."
  ([]     (greeting "world"))
  ([name] (str "Hello, " name)))
(is (= "Hello, Michael" (greeting "Michael")))
(is (= "Hello, world" (greeting)))

(defn date [p1 p2 & chaperones]
  (str p1 " and " p2 " went out with " (count chaperones) " chaperone(s)."))
(is (= "A and B went out with 0 chaperone(s)." (date "A" "B")))
(is (= "A and B went out with 1 chaperone(s)." (date "A" "B" "C")))
(is (= "A and B went out with 2 chaperone(s)." (date "A" "B" "C" "D")))
