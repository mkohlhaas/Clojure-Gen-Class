## Clojure gen-class example

- Links
  - [gen-class – how it works and how to use it](https://kotka.de/blog/2010/02/gen-class_how_it_works_and_how_to_use_it.html)
  - [Building ImageJ/Fiji Plugins with Clojure](https://nickgeorge.net/programming/building-imagej-plugins-with-clojure/)
  - [gen-class and How to Implement Java Classes in Clojure](https://clojure-doc.org/articles/language/interop/#gen-class-and-how-to-implement-java-classes-in-clojure)
  - [clojuredocs: gen-class](https://clojuredocs.org/clojure.core/gen-class)
  - [gen-class Examples](https://clojure.org/reference/compilation#_gen_class_examples)
  - [Generating classes in Clojure](https://www.tianxiangxiong.com/2025/03/01/generating-classes-in-clojure.html)

- Specify `:aot` in `project.clj`.
- See `lein help compile`.
- `lein repl` will also compile and generated Java classes:
  ```shell
  $ lein repl
  Compiling demo.core
  nREPL server started on port 33159 on host 127.0.0.1 - nrepl://127.0.0.1:33159
  REPL-y 0.5.1, nREPL 1.0.0
  Clojure 1.11.1
  OpenJDK 64-Bit Server VM 24.0.2
      Docs: (doc function-name-here)
            (find-doc "part-of-name-here")
    Source: (source function-name-here)
   Javadoc: (javadoc java-object-or-class-here)
      Exit: Control+D or (exit) or (quit)
   Results: Stored in vars *1, *2, *3, an exception in *e
   ```
- To see generated methods use `javap`
  ```shell
  $ javap target/classes/demo/core.class 
  public class demo.core {
    public final java.lang.Object state;
    public static {};
    public demo.core(java.lang.String);
    public boolean equals(java.lang.Object);
    public java.lang.String toString();
    public int hashCode();
    public java.lang.Object clone();
    public void print();
    public static void main(java.lang.String[]);
  }
  ```
