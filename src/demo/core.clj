(ns demo.core
  (:gen-class                   ; no superclass given -> derived from Object
   :constructors {[String] []}  ; our constructor with a single parameter of type String calls empty constructor of super class
   :init init                   ; constructor
   :state state                 ; internal state of object
   :methods [[print [] void]])) ; instance methods of our class (Java declarations)

(defn -main
  "I don't do a whole lot ... yet."
  [& _args]
  (println "Hello, World!"))

;; single constructor that only has one parameter
(defn -init
  [txt]
  [[] txt])

(defn -print
  [this]
  (println (.state this)))

#_{:clj-kondo/ignore [:unused-import]}
(comment
  (import 'demo.core)

  (.hashCode (demo.core. "hello"))   ; 87184658
  (.toString (demo.core. "hello"))   ; "demo.core@585cd871"
  (.print    (demo.core. "hello")))  ; (out) hello
