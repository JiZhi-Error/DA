package rx.internal.util.a;

import java.util.concurrent.atomic.AtomicReference;

public final class b<E> extends AtomicReference<b<E>> {
    public E value;

    public b() {
    }

    public b(E e2) {
        this.value = e2;
    }

    public final E hQT() {
        E e2 = this.value;
        this.value = null;
        return e2;
    }
}
