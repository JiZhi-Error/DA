package rx.internal.util.unsafe;

/* access modifiers changed from: package-private */
public abstract class SpmcArrayQueueProducerField<E> extends SpmcArrayQueueL1Pad<E> {
    protected static final long P_INDEX_OFFSET = UnsafeAccess.addressOf(SpmcArrayQueueProducerField.class, "producerIndex");
    private volatile long producerIndex;

    /* access modifiers changed from: protected */
    public final long lvProducerIndex() {
        return this.producerIndex;
    }

    /* access modifiers changed from: protected */
    public final void soTail(long j2) {
        UnsafeAccess.UNSAFE.putOrderedLong(this, P_INDEX_OFFSET, j2);
    }

    public SpmcArrayQueueProducerField(int i2) {
        super(i2);
    }
}
