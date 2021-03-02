package android.support.v4.e;

public final class l {

    public interface a<T> {
        T acquire();

        boolean release(T t);
    }

    public static class b<T> implements a<T> {
        private final Object[] mPool;
        private int mPoolSize;

        public b(int i2) {
            if (i2 <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.mPool = new Object[i2];
        }

        @Override // android.support.v4.e.l.a
        public T acquire() {
            if (this.mPoolSize <= 0) {
                return null;
            }
            int i2 = this.mPoolSize - 1;
            T t = (T) this.mPool[i2];
            this.mPool[i2] = null;
            this.mPoolSize--;
            return t;
        }

        @Override // android.support.v4.e.l.a
        public boolean release(T t) {
            boolean z;
            int i2 = 0;
            while (true) {
                if (i2 >= this.mPoolSize) {
                    z = false;
                    break;
                } else if (this.mPool[i2] == t) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                throw new IllegalStateException("Already in the pool!");
            } else if (this.mPoolSize >= this.mPool.length) {
                return false;
            } else {
                this.mPool[this.mPoolSize] = t;
                this.mPoolSize++;
                return true;
            }
        }
    }

    public static class c<T> extends b<T> {
        private final Object mLock = new Object();

        public c(int i2) {
            super(i2);
        }

        @Override // android.support.v4.e.l.b, android.support.v4.e.l.a
        public final T acquire() {
            T t;
            synchronized (this.mLock) {
                t = (T) super.acquire();
            }
            return t;
        }

        @Override // android.support.v4.e.l.b, android.support.v4.e.l.a
        public final boolean release(T t) {
            boolean release;
            synchronized (this.mLock) {
                release = super.release(t);
            }
            return release;
        }
    }
}
