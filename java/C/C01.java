import java.util.Arrays;
import java.util.ArrayList;

class C01 {

    // print result like question asked
    private static final boolean UGLY_STYLE = false;

    private enum Operator { PLUS, MINUS, MULTIPLE, DIVIDE, OTHERS; }
    private static final int MIN = 1;
    private static final int MAX = 10;
    private static final int COMPARE_TO = 100;

    public static void main(String[] args) {
        int flag;
        for (flag = 0; flag < ( 1 << 2 * (MAX - MIN) ); ++flag) {

            StringBuilder builder = new StringBuilder();
            for (int i = MIN; i <= MAX; ++i) {
                builder.append(String.valueOf(i) + ' ');

                if (i == MAX) break;

                char sign;
                switch (( flag >> (2 * (MAX - 1 - i)) ) & 0b11) {
                    case 0: sign = '+'; break;
                    case 1: sign = '-'; break;
                    case 2: sign = '*'; break;
                    case 3: sign = '/'; break;
                    default: sign = ' '; break;
                }
                builder.append(String.valueOf(sign) + ' ');
            }

            String result = builder.toString().trim();
            if (equalsInt(result, COMPARE_TO)) {
                if (UGLY_STYLE) {
                    result = result.replace(" ", "");
                    result = result.replace("*", "x");
                    System.out.println(result + "=" + COMPARE_TO);
                } else {
                    System.out.println(result + " = " + COMPARE_TO);
                }
            }

        }
    }

    // tring low coulping
    private static boolean equalsInt(String input, int compare) {
        ArrayList<Pair> list = new ArrayList<Pair>();
        String[] explode = input.split(" ");

        for (int i = 0; i < explode.length; ++i) {
            String split = explode[i];
            switch (split) {
                case "+":
                    list.add(new Pair(Operator.PLUS)); break;
                case "-":
                    list.add(new Pair(Operator.MINUS)); break;
                case "*":
                    list.add(new Pair(Operator.MULTIPLE)); break;
                case "/":
                    list.add(new Pair(Operator.DIVIDE)); break;
                default:
                    list.add(new Pair(Operator.OTHERS, Integer.parseInt(split)));
            }
        }

        Operator[] signOrder = {Operator.DIVIDE, Operator.MULTIPLE, Operator.MINUS, Operator.PLUS};
        for (Operator op : signOrder) {
            int i = 0;
            while (i < list.size()) {
                if (list.get(i).getOp() != op) {
                    ++i;
                    continue;
                }

                double result = 0;
                double value[] = {list.get(i - 1).getValue(), list.get(i + 1).getValue()};
                switch (op) {
                    case PLUS:     result = value[0] + value[1]; break;
                    case MINUS:    result = value[0] - value[1]; break;
                    case MULTIPLE: result = value[0] * value[1]; break;
                    case DIVIDE:   result = value[0] / value[1]; break;
                }

                list.set(i - 1, new Pair(Operator.OTHERS, result));
                list.remove(i + 1);
                list.remove(i);
            }
        }

        if (list.get(0).getValue() - compare == 0) {
            return true;
        } else {
            return false;
        }
    }

    private static class Pair {

        private Operator operator;
        private double value;

        public Pair (Operator op, double value) {
            this.operator = op;
            this.value = value;
        }

        public Pair (Operator op, int value) {
            this(op, (double) value);
        }

        public Pair (Operator op) {
            this(op, 0);
        }

        public Operator getOp() {
            return this.operator;
        }

        public double getValue() {
            return this.value;
        }
    }
}