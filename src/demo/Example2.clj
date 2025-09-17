(ns demo.Example2
  (:gen-class
   :prefix "method-"))

(defn method-toString
  [_this]
  "Hello, World!")

#_{:clj-kondo/ignore [:unused-import]}
(comment
  "https://kotka.de/blog/2010/02/gen-class_how_it_works_and_how_to_use_it.html"

  (import 'demo.Example2)

  ;; calling clojure method
  (method-toString (demo.Example2.))  ; "Hello, World!"

  ;; calling instance method
  (.toString (demo.Example2.)))       ; "Hello, World!"

;; $ javap target/classes/demo/Example2.class 
;; public class demo.Example2 {
;;   public static {};
;;   public demo.Example2();
;;   public boolean equals(java.lang.Object);
;;   public java.lang.String toString();
;;   public int hashCode();
;;   public java.lang.Object clone();
;;   public static void main(java.lang.String[]);
;; }
