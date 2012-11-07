public abstract class Optional<T> {
    public abstract T get ();

    public static <T> Optional<T> absent () {
        return new None<T>();
    }

    public static <T> Optional<T> of (final T payload) {
        return new Some<T>(payload);
    }

    private static class None<T> extends Optional<T> {
        @Override
        public T get () {
            throw new IllegalStateException("The value is absent");
        }
    }

    private static class Some<T> extends Optional<T> {
        private T payload;

        public Some (final T payload) {
            this.payload = payload;
        }

        @Override
        public T get () {
            return payload;
        }
    }
}
