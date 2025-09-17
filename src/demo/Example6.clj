(ns demo.Example6
  (:gen-class
   :implements   [clojure.lang.IDeref]
   :state        state                   ; Defines the name of an instance method which will return the object's state.
   :init         init                    ; Defines the name of the initialiser. This is a function which returns a vector.
                                         ; The first element is a vector of arguments to the super class constructor.
                                         ; In our case this is just the empty vector (superclass is Object).
                                         ; The second element is the object's state.
   :constructors {[String] []}))         ; maps the arguments of the class' constructor to the arguments of the super class' constructor.
                                         ;This is used to determine which constructor is supposed to be called.]}))

(defn -init
  [message]
  [[] message])

(defn -deref
  [this]
  (.state this))

#_{:clj-kondo/ignore [:unused-import]}
(comment
  "https://kotka.de/blog/2010/02/gen-class_how_it_works_and_how_to_use_it.html"

  (import 'demo.Example6)

  @(demo.Example6. "Hello World!")) ; "Hello World!"

;; $ javap target/classes/demo/Example6.class 
;; public class demo.Example6 implements clojure.lang.IDeref {
;;   public final java.lang.Object state;
;;   public static {};
;;   public demo.Example6(java.lang.String);
;;   public boolean equals(java.lang.Object);
;;   public java.lang.String toString();
;;   public int hashCode();
;;   public java.lang.Object clone();
;;   public java.lang.Object deref();
;;   public static void main(java.lang.String[]);
;; }
