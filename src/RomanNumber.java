
class RomanNumber extends Number {
    private String value;
    private int numericValue;

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
    public int calc(Number o, Operations operation) {
        return switch (operation) {
            case ADDITION -> this.numericValue + o.getNumericValue();
            case SUBTRACTION -> this.numericValue - o.getNumericValue();
            case MULTIPLICATION -> this.numericValue * o.getNumericValue();
            case DIVISION -> this.numericValue / o.getNumericValue();
        };
    }
}

