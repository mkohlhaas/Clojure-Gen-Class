(ns demo.Example5
  (:gen-class
   :extends demo.Example4))

#_{:clj-kondo/ignore [:unused-import]}
(comment
  "https://kotka.de/blog/2010/02/gen-class_how_it_works_and_how_to_use_it.html"

  (import 'demo.Example5)

  @(demo.Example5.)) ; "Hello, World!"

;; $ javap target/classes/demo/Example5.class 
;; public class demo.Example5 extends demo.Example4 {
;;   public static {};
;;   public demo.Example5();
;;   public boolean equals(java.lang.Object);
;;   public java.lang.String toString();
;;   public int hashCode();
;;   public java.lang.Object clone();
;;   public java.lang.Object deref();
;;   public static void main(java.lang.String[]);
;; }
