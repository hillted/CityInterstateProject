package com.hillt;

/**
 * Created by thill on 5/20/16.
 */
public class RunApp {

    /**
     * To run from command-line.
     * @param args      The String with the filename.
     */
    public static void main(String ... args){
        if (args.length == 1) {
            try {
                new FileWorker(args[0]);
            }
            catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
        else {
            printUsage();
            System.exit(1);
        }
    }

    public static void printUsage() {
        System.out.println("USAGE: RunApp              \n"
                + "\t                                      \n"
                + "\t <filename>     Give filename as arg. \n"
                + "\t                                      \n");
    }
}
