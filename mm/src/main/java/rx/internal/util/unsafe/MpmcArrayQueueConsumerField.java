package rx.internal.util.unsafe;

/* access modifiers changed from: package-private */
public abstract class MpmcArrayQueueConsumerField<E> extends MpmcArrayQueueL2Pad<E> {
    private static final long C_INDEX_OFFSET = UnsafeAccess.addressOf(MpmcArrayQueueConsumerField.class, "consumerIndex");
    private volatile long consumerIndex;

    public MpmcArrayQueueConsumerField(int i2) {
        super(i2);
    }

    /* access modifiers changed from: protected */
    public final long lvConsumerIndex() {
        return this.consumerIndex;
    }

    /* access modifiers changed from: protected */
    public final boolean casConsumerIndex(long j2, long j3) {
        return UnsafeAccess.UNSAFE.compareAndSwapLong(this, C_INDEX_OFFSET, j2, j3);
    }
}
