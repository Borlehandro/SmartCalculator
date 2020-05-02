package calculator.operations;

public enum Priority {

        MINIMUM(0), LOW(1), MIDDLE(2), HIGH(3);

        private int value;

        Priority(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
}
