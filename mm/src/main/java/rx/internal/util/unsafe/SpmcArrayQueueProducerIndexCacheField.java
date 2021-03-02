package rx.internal.util.unsafe;

/* access modifiers changed from: package-private */
public abstract class SpmcArrayQueueProducerIndexCacheField<E> extends SpmcArrayQueueMidPad<E> {
    private volatile long producerIndexCache;

    public SpmcArrayQueueProducerIndexCacheField(int i2) {
        super(i2);
    }

    /* access modifiers changed from: protected */
    public final long lvProducerIndexCache() {
        return this.producerIndexCache;
    }

    /* access modifiers changed from: protected */
    public final void svProducerIndexCache(long j2) {
        this.producerIndexCache = j2;
    }
}
