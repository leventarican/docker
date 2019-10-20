public class Main {
    public static void main(String[] args) {
        System.out.println("hello docker.");

        String result = java13Features();
        System.out.println("java13Features: " + result);
        javaLegacy();
    }

    public static String java13Features() {
        int input = 200;
        return switch(input) {
            case 100: yield "java13Features 100";
            case 200: yield "java13Features 200";
            default: yield "not defined";
        };
    }

    public static void javaLegacy() {
        int input = 100;
        switch (input) {
            case 100:
                System.out.println("javaLegacy: 100");
                break;
            case 200:
                System.out.println("javaLegacy: 200");
                break;
            case 300:
                System.out.println("javaLegacy: 300");
                break;
        }
    }
}