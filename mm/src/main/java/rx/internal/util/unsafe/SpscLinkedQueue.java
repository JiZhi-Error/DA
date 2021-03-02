package rx.internal.util.unsafe;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.internal.util.a.b;

public final class SpscLinkedQueue<E> extends BaseLinkedQueue<E> {
    public SpscLinkedQueue() {
        AppMethodBeat.i(90158);
        spProducerNode(new b<>());
        spConsumerNode(this.producerNode);
        this.consumerNode.lazySet(null);
        AppMethodBeat.o(90158);
    }

    @Override // java.util.Queue
    public final boolean offer(E e2) {
        AppMethodBeat.i(90159);
        if (e2 == null) {
            NullPointerException nullPointerException = new NullPointerException("null elements not allowed");
            AppMethodBeat.o(90159);
            throw nullPointerException;
        }
        b bVar = new b(e2);
        this.producerNode.lazySet(bVar);
        this.producerNode = bVar;
        AppMethodBeat.o(90159);
        return true;
    }

    @Override // java.util.Queue
    public final E poll() {
        AppMethodBeat.i(90160);
        b bVar = (b) this.consumerNode.get();
        if (bVar != null) {
            E e2 = (E) bVar.hQT();
            this.consumerNode = bVar;
            AppMethodBeat.o(90160);
            return e2;
        }
        AppMethodBeat.o(90160);
        return null;
    }

    @Override // java.util.Queue
    public final E peek() {
        AppMethodBeat.i(90161);
        b bVar = (b) this.consumerNode.get();
        if (bVar != null) {
            E e2 = bVar.value;
            AppMethodBeat.o(90161);
            return e2;
        }
        AppMethodBeat.o(90161);
        return null;
    }
}
