package com.example;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        JustPayApp app = new JustPayApp();
        System.out.println(app.getPaneName());
        app.doAction("READ_BUTTON");
        System.out.println(app.getPaneName());
        app.doAction("CANCEL_BUTTON");
        System.out.println(app.getPaneName());
        app.doAction("OK_BUTTON");
        System.out.println(app.getPaneName());
    }
}
