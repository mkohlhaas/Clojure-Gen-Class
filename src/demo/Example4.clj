(ns demo.Example4
  (:gen-class
   :implements [clojure.lang.IDeref]))

(defn -deref
  [_this]
  "Hello, World!")

#_{:clj-kondo/ignore [:unused-import]}
(comment
  "https://kotka.de/blog/2010/02/gen-class_how_it_works_and_how_to_use_it.html"

  (import 'demo.Example4)

  @(demo.Example4.)) ; "Hello, World!"

;; $ javap target/classes/demo/Example4.class 
;; public class demo.Example4 implements clojure.lang.IDeref {
;;   public static {};
;;   public demo.Example4();
;;   public boolean equals(java.lang.Object);
;;   public java.lang.String toString();
;;   public int hashCode();
;;   public java.lang.Object clone();
;;   public java.lang.Object deref();
;;   public static void main(java.lang.String[]);
;; }
