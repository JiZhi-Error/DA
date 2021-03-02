package rx.internal.util.unsafe;

import rx.internal.util.a.b;

/* access modifiers changed from: package-private */
public abstract class BaseLinkedQueueProducerNodeRef<E> extends BaseLinkedQueuePad0<E> {
    protected static final long P_NODE_OFFSET = UnsafeAccess.addressOf(BaseLinkedQueueProducerNodeRef.class, "producerNode");
    protected b<E> producerNode;

    BaseLinkedQueueProducerNodeRef() {
    }

    /* access modifiers changed from: protected */
    public final void spProducerNode(b<E> bVar) {
        this.producerNode = bVar;
    }

    /* access modifiers changed from: protected */
    public final b<E> lvProducerNode() {
        return (b) UnsafeAccess.UNSAFE.getObjectVolatile(this, P_NODE_OFFSET);
    }

    /* access modifiers changed from: protected */
    public final b<E> lpProducerNode() {
        return this.producerNode;
    }
}
