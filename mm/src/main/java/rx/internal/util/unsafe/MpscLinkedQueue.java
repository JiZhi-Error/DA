package rx.internal.util.unsafe;

import com.tencent.matrix.trace.core.AppMethodBeat;
import rx.internal.util.a.b;

public final class MpscLinkedQueue<E> extends BaseLinkedQueue<E> {
    public MpscLinkedQueue() {
        AppMethodBeat.i(90146);
        this.consumerNode = new b();
        xchgProducerNode(this.consumerNode);
        AppMethodBeat.o(90146);
    }

    /* access modifiers changed from: protected */
    public final b<E> xchgProducerNode(b<E> bVar) {
        b<E> bVar2;
        AppMethodBeat.i(90147);
        do {
            bVar2 = this.producerNode;
        } while (!UnsafeAccess.UNSAFE.compareAndSwapObject(this, P_NODE_OFFSET, bVar2, bVar));
        b<E> bVar3 = bVar2;
        AppMethodBeat.o(90147);
        return bVar3;
    }

    @Override // java.util.Queue
    public final boolean offer(E e2) {
        AppMethodBeat.i(90148);
        if (e2 == null) {
            NullPointerException nullPointerException = new NullPointerException("null elements not allowed");
            AppMethodBeat.o(90148);
            throw nullPointerException;
        }
        b<E> bVar = new b<>(e2);
        xchgProducerNode(bVar).lazySet(bVar);
        AppMethodBeat.o(90148);
        return true;
    }

    @Override // java.util.Queue
    public final E poll() {
        b bVar;
        AppMethodBeat.i(90149);
        b<E> lpConsumerNode = lpConsumerNode();
        b<E> bVar2 = (b) lpConsumerNode.get();
        if (bVar2 != null) {
            E hQT = bVar2.hQT();
            spConsumerNode(bVar2);
            AppMethodBeat.o(90149);
            return hQT;
        } else if (lpConsumerNode != lvProducerNode()) {
            do {
                bVar = (b) lpConsumerNode.get();
            } while (bVar == null);
            E e2 = (E) bVar.hQT();
            this.consumerNode = bVar;
            AppMethodBeat.o(90149);
            return e2;
        } else {
            AppMethodBeat.o(90149);
            return null;
        }
    }

    @Override // java.util.Queue
    public final E peek() {
        b bVar;
        AppMethodBeat.i(90150);
        b<E> bVar2 = this.consumerNode;
        b bVar3 = (b) bVar2.get();
        if (bVar3 != null) {
            E e2 = bVar3.value;
            AppMethodBeat.o(90150);
            return e2;
        } else if (bVar2 != lvProducerNode()) {
            do {
                bVar = (b) bVar2.get();
            } while (bVar == null);
            E e3 = bVar.value;
            AppMethodBeat.o(90150);
            return e3;
        } else {
            AppMethodBeat.o(90150);
            return null;
        }
    }
}
