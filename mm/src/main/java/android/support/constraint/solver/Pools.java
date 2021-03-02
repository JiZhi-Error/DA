package android.support.constraint.solver;

final class Pools {
    private static final boolean DEBUG = false;

    /* access modifiers changed from: package-private */
    public interface Pool<T> {
        T acquire();

        boolean release(T t);

        void releaseAll(T[] tArr, int i2);
    }

    private Pools() {
    }

    /* access modifiers changed from: package-private */
    public static class SimplePool<T> implements Pool<T> {
        private final Object[] mPool;
        private int mPoolSize;

        SimplePool(int i2) {
            if (i2 <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.mPool = new Object[i2];
        }

        @Override // android.support.constraint.solver.Pools.Pool
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

        @Override // android.support.constraint.solver.Pools.Pool
        public boolean release(T t) {
            if (this.mPoolSize >= this.mPool.length) {
                return false;
            }
            this.mPool[this.mPoolSize] = t;
            this.mPoolSize++;
            return true;
        }

        @Override // android.support.constraint.solver.Pools.Pool
        public void releaseAll(T[] tArr, int i2) {
            if (i2 > tArr.length) {
                i2 = tArr.length;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                T t = tArr[i3];
                if (this.mPoolSize < this.mPool.length) {
                    this.mPool[this.mPoolSize] = t;
                    this.mPoolSize++;
                }
            }
        }

        private boolean isInPool(T t) {
            for (int i2 = 0; i2 < this.mPoolSize; i2++) {
                if (this.mPool[i2] == t) {
                    return true;
                }
            }
            return false;
        }
    }
}
