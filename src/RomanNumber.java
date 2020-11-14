import java.util.TreeMap;

class RomanNumber extends Number {
    private String value;
    private int numericValue;

    private final static TreeMap<Integer, String> map = new TreeMap<>();

    static {

        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

    }

    private String toRoman(int number) {
        int l =  map.floorKey(number);
        if ( number == l ) {
            return map.get(number);
        }
        return map.get(l) + toRoman(number-l);
    }

    @Override
    public int setValue(String _value) {
        if (_value == null) {
            return Consts.VALUE_FORMAT_ERROR;
        }

        switch (_value) {
            case "I":
                this.numericValue = 1;
                break;
            case "II":
                this.numericValue = 2;
                break;
            case "III":
                this.numericValue = 3;
                break;
            case "IV":
                this.numericValue = 4;
                break;
            case "V":
                this.numericValue = 5;
                break;
            case "VI":
                this.numericValue = 6;
                break;
            case "VII":
                this.numericValue = 7;
                break;
            case "VIII":
                this.numericValue = 8;
                break;
            case "IX":
                this.numericValue = 9;
                break;
            case "X":
                this.numericValue = 10;
                break;
            default:
                return Consts.VALUE_FORMAT_ERROR;
        }
        this.value = _value;
        return 0;
    }

    @Override
    public int getNumericValue() {
        return this.numericValue;
    }

    @Override
    public String calc(Number o, Operations operation) {
        int res = switch (operation) {
            case ADDITION -> this.numericValue + o.getNumericValue();
            case SUBTRACTION -> this.numericValue - o.getNumericValue();
            case MULTIPLICATION -> this.numericValue * o.getNumericValue();
            case DIVISION -> this.numericValue / o.getNumericValue();
        };
        return toRoman(res);
    }
}

