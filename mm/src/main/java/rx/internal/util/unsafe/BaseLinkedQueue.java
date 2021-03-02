package rx.internal.util.unsafe;

import java.util.Iterator;
import rx.internal.util.a.b;

abstract class BaseLinkedQueue<E> extends BaseLinkedQueueConsumerNodeRef<E> {
    long p00;
    long p01;
    long p02;
    long p03;
    long p04;
    long p05;
    long p06;
    long p07;
    long p30;
    long p31;
    long p32;
    long p33;
    long p34;
    long p35;
    long p36;
    long p37;

    BaseLinkedQueue() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    public final int size() {
        b<E> bVar;
        b<E> lvConsumerNode = lvConsumerNode();
        b<E> lvProducerNode = lvProducerNode();
        int i2 = 0;
        while (lvConsumerNode != lvProducerNode && i2 < Integer.MAX_VALUE) {
            do {
                bVar = (b) lvConsumerNode.get();
            } while (bVar == null);
            i2++;
            lvConsumerNode = bVar;
        }
        return i2;
    }

    public final boolean isEmpty() {
        return lvConsumerNode() == lvProducerNode();
    }
}
