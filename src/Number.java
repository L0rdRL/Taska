class Number {
    private String value;
    private int numericValue;

    public int setValue(String _value) {
        this.value = _value;
        return 0;
    }

    public int getNumericValue() {
        return this.numericValue;
    }

    public int calc(Number o, Operations operation) { return 0;}
}