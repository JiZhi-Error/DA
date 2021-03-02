package rx.internal.util.unsafe;

abstract class SpmcArrayQueueConsumerField<E> extends SpmcArrayQueueL2Pad<E> {
    protected static final long C_INDEX_OFFSET = UnsafeAccess.addressOf(SpmcArrayQueueConsumerField.class, "consumerIndex");
    private volatile long consumerIndex;

    public SpmcArrayQueueConsumerField(int i2) {
        super(i2);
    }

    /* access modifiers changed from: protected */
    public final long lvConsumerIndex() {
        return this.consumerIndex;
    }

    /* access modifiers changed from: protected */
    public final boolean casHead(long j2, long j3) {
        return UnsafeAccess.UNSAFE.compareAndSwapLong(this, C_INDEX_OFFSET, j2, j3);
    }
}
