package rx.internal.util.unsafe;

public abstract class ConcurrentSequencedCircularArrayQueue<E> extends ConcurrentCircularArrayQueue<E> {
    private static final long ARRAY_BASE = ((long) (UnsafeAccess.UNSAFE.arrayBaseOffset(long[].class) + (32 << (ELEMENT_SHIFT - SPARSE_SHIFT))));
    private static final int ELEMENT_SHIFT = (SPARSE_SHIFT + 3);
    protected final long[] sequenceBuffer;

    static {
        if (8 == UnsafeAccess.UNSAFE.arrayIndexScale(long[].class)) {
            return;
        }
        throw new IllegalStateException("Unexpected long[] element size");
    }

    public ConcurrentSequencedCircularArrayQueue(int i2) {
        super(i2);
        int i3 = (int) (this.mask + 1);
        this.sequenceBuffer = new long[((i3 << SPARSE_SHIFT) + 64)];
        for (long j2 = 0; j2 < ((long) i3); j2++) {
            soSequence(this.sequenceBuffer, calcSequenceOffset(j2), j2);
        }
    }

    /* access modifiers changed from: protected */
    public final long calcSequenceOffset(long j2) {
        return ARRAY_BASE + ((this.mask & j2) << ELEMENT_SHIFT);
    }

    /* access modifiers changed from: protected */
    public final void soSequence(long[] jArr, long j2, long j3) {
        UnsafeAccess.UNSAFE.putOrderedLong(jArr, j2, j3);
    }

    /* access modifiers changed from: protected */
    public final long lvSequence(long[] jArr, long j2) {
        return UnsafeAccess.UNSAFE.getLongVolatile(jArr, j2);
    }
}
