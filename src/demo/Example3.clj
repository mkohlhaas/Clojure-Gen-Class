(ns demo.Example3)

(gen-class
 :name   demo.Example3.ClassA
 :prefix classA-)

(gen-class
 :name   demo.Example3.ClassB
 :prefix classB-)

(defn classA-toString
  [_this]
  "I'm an A.")

(defn classB-toString
  [_this]
  "I'm a B.")

#_{:clj-kondo/ignore [:unused-import]}
(comment
  "https://kotka.de/blog/2010/02/gen-class_how_it_works_and_how_to_use_it.html"

  (import 'demo.Example3.ClassA)
  (import 'demo.Example3.ClassB)

  ;; calling clojure methods
  (classA-toString (demo.Example3.ClassA.)) ; "I'm an A."
  (classB-toString (demo.Example3.ClassB.)) ; "I'm a B."

  ;; calling instance methods
  (.toString (demo.Example3.ClassA.))       ; "I'm an A."
  (.toString (demo.Example3.ClassB.)))      ; "I'm a B."

;; $ javap target/classes/demo/Example3/ClassA.class 
;; public class demo.Example3.ClassA {
;;   public static {};
;;   public demo.Example3.ClassA();
;;   public boolean equals(java.lang.Object);
;;   public java.lang.String toString();
;;   public int hashCode();
;;   public java.lang.Object clone();
;; }

;; $ javap target/classes/demo/Example3/ClassB.class 
;; public class demo.Example3.ClassB {
;;   public static {};
;;   public demo.Example3.ClassB();
;;   public boolean equals(java.lang.Object);
;;   public java.lang.String toString();
;;   public int hashCode();
;;   public java.lang.Object clone();
;; }
