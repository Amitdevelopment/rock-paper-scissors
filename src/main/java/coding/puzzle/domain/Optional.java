package coding.puzzle.domain;

public abstract class Optional<T> {
    public abstract T get();

    public static <T> Optional<T> absent() {
        return new None<T>();
    }

    public static <T> Optional<T> of(final T payload) {
        return new Some<T>(payload);
    }

    abstract public boolean isPresent();

    private static class None<T> extends Optional<T> {
        @Override
        public T get() {
            throw new IllegalStateException("The value is absent");
        }

        @Override
        public boolean isPresent() {
            return false;
        }
    }

    private static class Some<T> extends Optional<T> {
        private T payload;

        public Some(final T payload) {
            this.payload = payload;
        }

        @Override
        public T get() {
            return payload;
        }

        @Override
        public boolean isPresent() {
            return true;
        }
    }
}
