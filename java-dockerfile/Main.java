public class Main {
    public static void main(String[] args) {
        System.out.println("hello docker.");

        String result = java13Features();
        System.out.println("java13Features: " + result);
        javaLegacy();

        java15();
    }

    public static void java15() {
        System.out.println("# java 15 #");
        String html = """
        <html>
            <body>
                <b>JEP 378</b>
            </body>
        </html>
        """;
        record Point(int x, int y) {
            int sum() {
                return x + y;
            }
        }
        Point p = new Point(1, 2);
        System.out.println(html);
        System.out.println("record: " + p.sum());
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