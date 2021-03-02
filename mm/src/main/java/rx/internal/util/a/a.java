package rx.internal.util.a;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.unsafe.Pow2;

/* access modifiers changed from: package-private */
public abstract class a<E> extends AbstractQueue<E> {
    protected final AtomicReferenceArray<E> TXf;
    protected final int mask;

    public a(int i2) {
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(i2);
        this.mask = roundToPowerOfTwo - 1;
        this.TXf = new AtomicReferenceArray<>(roundToPowerOfTwo);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final int Px(long j2) {
        return ((int) j2) & this.mask;
    }

    /* access modifiers changed from: protected */
    public final E awp(int i2) {
        return this.TXf.get(i2);
    }
}
