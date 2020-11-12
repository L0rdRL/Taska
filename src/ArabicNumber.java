class ArabicNumber extends Number {
    private String value;
    private int numericValue;

    @Override
    public int setValue(String _value) {
        try {
            this.numericValue = Integer.parseInt(_value);
        } catch (NumberFormatException e) {
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