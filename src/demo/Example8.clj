(ns demo.Example8
  (:gen-class
   :methods [[show [] void]
             #^:static [showStatic [] void] ; `#^:static` same as `#^{:static true}`
             [showMessage [String] void]]))

(defn -show
  [_this]
  (println "Hello, World!"))

;; NOTE: no prefix (`-`)
(defn showStatic
  []
  (println "Hello, World!"))

(defn -showMessage
  [_this msg]
  (println msg))

#_{:clj-kondo/ignore [:unused-import]}
(comment
  "https://kotka.de/blog/2010/02/gen-class_how_it_works_and_how_to_use_it.html"

  (import 'demo.Example8)

  ;; calling Clojure function
  (showStatic)                                   ; (out) Hello, World!

  ;; call static method of Java class
  (demo.Example8/showStatic)                     ; (out) Hello, World!
  (.show (demo.Example8.))                       ; (out) Hello, World!
  (.showMessage (demo.Example8.) "Hallo Welt!")) ; (out) Hallo Welt!

;; $ javap target/classes/demo/Example8.class 
;; public class demo.Example8 {
;;   public static {};
;;   public demo.Example8();
;;   public boolean equals(java.lang.Object);
;;   public java.lang.String toString();
;;   public int hashCode();
;;   public java.lang.Object clone();
;;   public void show();
;;   public static void showStatic();
;;   public void showMessage(java.lang.String);
;;   public static void main(java.lang.String[]);
;; }
