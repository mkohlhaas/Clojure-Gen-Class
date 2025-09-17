(ns demo.Example1
  (:gen-class))

(defn -toString
  [_this]
  "Hello, World!")

#_{:clj-kondo/ignore [:unused-import]}
(comment
  "https://kotka.de/blog/2010/02/gen-class_how_it_works_and_how_to_use_it.html"

  (import 'demo.Example1)

  ;; calling clojure method
  (-toString (demo.Example1.))  ; "Hello, World!"

  ;; calling instance method
  (.toString (demo.Example1.))) ; "Hello, World!"

;; $ javap target/classes/demo/Example1.class 
;; public class demo.Example1 {
;;   public static {};
;;   public demo.Example1();
;;   public boolean equals(java.lang.Object);
;;   public java.lang.String toString();
;;   public int hashCode();
;;   public java.lang.Object clone();
;;   public static void main(java.lang.String[]);
;; }
