import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class ML1 {

    public static void main(String[] args) {
        double w11 = 0.1;
        double w12 = 0.25;
        double w21 = 0.1;
        double w22 = 0.7;
        double w13 = 0.4;
        double w23 = 0.6;
        double w14 = 0.5;
        double w24 = 0.3;
        double x1 = 1.0;
        double x2 = 1.0;
        double theta = 0.1;
        double netN1 = w11 * x1 + w21 * x2;
        System.out.println(netN1);
        double netN2 = w12 * x1 + w22 * x2;
        double outN1 = calculateeminusx(netN1);
        System.out.println(outN1);
        double outN2 = calculateeminusx(netN2);
        System.out.println(outN2);
        double netN3 = w13 * outN1 + w23 * outN2;
        System.out.println(netN3);
        double netN4 = w14 * outN1 + w24 * outN2;
        double outO1 = calculateeminusx(netN3);
        System.out.println(outO1);
        double outO2 = calculateeminusx(netN4);
        System.out.println(outO2);
        double EO1 = 1/2 * Math.pow((1 - outO1), 2);
        System.out.println("E01 " + EO1);
        double EO2 = 1/2 * Math.pow((0 - outO2), 2);
        double E = EO1 + EO2;
        double deBydout1 = - (0 - outO1);
        System.out.println("detotalout1: " + deBydout1);
        double deBydout2 = - (1 - outO2);
        double dout1Bydnet1 = outO1 * (1 - outO1);
        System.out.println(dout1Bydnet1);
        double dtoaldw13 = deBydout1 * dout1Bydnet1 * outN1;
        System.out.println(dtoaldw13);
        double neww13 = w13 - (theta * dtoaldw13);
        System.out.println(neww13);
        double dout2Bydnet2 = outO2 * (1 - outO2);
        double dtotaldw14 = deBydout2 * dout2Bydnet2 * outO2;
        double neww14 = w14 - (theta * dtotaldw14);
        System.out.println(neww14);
        double neww23 = w23 - (theta * dtoaldw13);
        System.out.println(neww23);
        double neww24 = w24 - (theta * dtotaldw14);
        System.out.println(neww24);
        double dEO1Bydout1 = - (0 - outO1);
        double dE02Bydout2 = - (1 - outO2);
        double dE01Bydnet01 = dEO1Bydout1 * dout1Bydnet1;
        System.out.println("dE01Bydnet01: " + dE01Bydnet01);
        double dE02Bydnet02 = dE02Bydout2 * dout2Bydnet2;
        System.out.println("dE02Bydnet02: " + dE02Bydnet02);
        double dtotaldouth1 = dE01Bydnet01 + dE02Bydnet02;
        double douth1dnet1 = outN1 * (1 - outN1);
        double douth2dnet2 = outN2 * (1 - outN2);
        double dtotaldw11 = dtotaldouth1 * douth1dnet1 * 1;
        double dtotaldw12 = dtotaldouth1 * douth2dnet2 * 1;
        double neww11 = w11 - (theta * dtotaldw11);
        double neww12 = w12 - (theta * dtotaldw12);
        double neww21 = w21 - (theta * dtotaldw11);
        double neww22 = w24 - (theta * dtotaldw12);
        System.out.println(neww11);
        System.out.println(neww12);
        System.out.println(neww21);
        System.out.println(neww22);
    }


    public static double calculateeminusx(double x) {
        double ans = 1 / 1 + (Math.exp(-(x)));
        return ans;
    }
}
