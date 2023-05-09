import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.io.FileWriter;
import java.io.IOException;


public class Main {




    public static void printStatus(String[] contractNum, String[] names, int[] fixedAmount){



        int sum = 0;

        DecimalFormat df = new DecimalFormat("#,###,###");

        for(int i=0; i<names.length; i++){
           /* System.out.printf("%s %25s %26s",
                              contractNum[i], names[i],
                              df.format(fixedAmount[i]));
            */
            System.out.println(contractNum[i]+"\t"+names[i]+"\t"+df.format(fixedAmount[i]));
            System.out.printf("\n");
            sum+=fixedAmount[i];
        }




        System.out.println("Total Sales : "+df.format(sum));
    }


    public static void main(String[] args) {





        String[] contractNum = {"A1-001-22", "A1-002-22", "A1-004-22", "A1-005-22", "A1-006-22", "A1-008-22"};
        String[] names = {"West Casey   ", "Dragon Valley", "East Casey   ", "Hovey       ", "Gate 2       ", "Warrior Base "};
        int[] fixedAmount = {1430000, 1430000, 1430000, 1430000, 1458000, 220000};


        String[] contractNumYSN = {"S-2667   ", "T253-15  "};
        String[] namesYSN = {"8th Army     ", "K-16         "};
        int[] fixedAmountYSN = {500000, 1000000};

        //check for whether money is recieved or fixedAmountChaged for this month
        boolean moneyReceived = true;
        boolean fixedAmountChanged = false;


        int[] amount = new int[fixedAmount.length];



        if (!moneyReceived) {
            for (int i = 0; i < fixedAmount.length; i++) {
                fixedAmount[i] = 0;
            }
        }else{
            if (!fixedAmountChanged) {
                amount = fixedAmount.clone();
            } else {
                fixedAmount[2] = 1471000; //East Casey
                fixedAmount[3] = 1512000; //Hovey
            }

        }




        System.out.println("--------------------------");
        Calendar cal = Calendar.getInstance();
        Calendar cal0 = Calendar.getInstance();

        cal0.add(Calendar.MONTH, -1);
        SimpleDateFormat month = new SimpleDateFormat("MMM-21");

        System.out.println("KWF CASEY FY22 \nDEPOSIT DATE : "+month.format(cal.getTime())+"\nBUSINESS DATE : "+month.format(cal0.getTime())+"\n");
        printStatus(contractNum, names, fixedAmount);
        System.out.println("--------------------------");
        System.out.println("KWF YONGSAN FY22 \nDEPOSIT DATE : "+month.format(cal.getTime())+"\nBUSINESS DATE : "+month.format(cal0.getTime())+"\n");
        printStatus(contractNumYSN, namesYSN, fixedAmountYSN);
        System.out.println("--------------------------");





    }
}