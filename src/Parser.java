class Parser {
    private Operations operation;

    public Operations getOperation() {
        return this.operation;
    }

    public int parseValue(String v) {
        if (v == null) {
            return Consts.VALUE_FORMAT_ERROR;
        }

        String value = v.replaceAll("\\s+","");
        if (value.isEmpty()) {
            return Consts.VALUE_FORMAT_ERROR;
        }

        try {
            int numericValue = Integer.parseInt(value);
            if (numericValue < 0 || numericValue > 10) {
                return Consts.VALUE_FORMAT_ERROR;
            }
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return Consts.VALUE_FORMAT_ERROR;
        }
    }

    public String[] split(String src) {
        int delimiterIndex = -1;
        if (src.contains("+")) {
            this.operation = Operations.ADDITION;
            delimiterIndex = src.indexOf("+");
        } else if (src.contains("-")) {
            this.operation = Operations.SUBTRACTION;
            delimiterIndex = src.indexOf("-");
        } else if (src.contains("*")) {
            this.operation = Operations.MULTIPLICATION;
            delimiterIndex = src.indexOf("*");
        } else if (src.contains("/")) {
            this.operation = Operations.DIVISION;
            delimiterIndex = src.indexOf("/");
        } else {
            return null;
        }

        String firstValue = src.substring(0, delimiterIndex).replaceAll("\\s+","");
        String secondValue = src.substring(delimiterIndex + 1).replaceAll("\\s+","");

        return new String[] {firstValue, secondValue};
    }
}
