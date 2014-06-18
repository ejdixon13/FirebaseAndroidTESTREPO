public class Broken {
   public void run(String[] args) throws Exception {
      for (String arg : args) {
         System.out.println(arg);
      }

      if (args[0].equals("ex")) {
         throw new Exception("ex was passed!");
      }
   }

   public static void main(String[] args) throws Exception {
      System.out.println("This is a great class.");
      new Broken().run(args);
   }
}