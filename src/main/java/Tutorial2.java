/**
 * Created by pc on 1/9/2017.
 */
public class Tutorial2 {



        int variable = 5;

        public static void main(String args[]) {
            Tutorial2 obj = new Tutorial2();

            obj.method(20);
            obj.method();
            obj.method3();
        }



        void method(int variable) {
            variable = 10;
            System.out.println("Value of Instance variable :" + this.variable);
            System.out.println("Value of Local variable :" + variable);
        }

        void method() {
            int variable = 40;
            System.out.println("Value of Instance variable :" + this.variable);
            System.out.println("Value of Local variable :" + variable);
        }

        void method3(){
            this.method();
        }

}
