package com.tencent.mm.appbrand.v8;

import androidx.annotation.RecentlyNullable;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import kotlin.a.j;
import kotlin.g.b.i;
import kotlin.g.b.p;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010)\n\u0002\b\u000e\b\u0000\u0018\u0000 +*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001+B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0004J\u001e\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n \r*\u0004\u0018\u00018\u00008\u0000H\u0001¢\u0006\u0002\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\u000b2\u0014\u0010\u0010\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00018\u00008\u00000\u0011H\u0001J\t\u0010\u0012\u001a\u00020\u0013H\u0001J\u001e\u0010\u0014\u001a\u00020\u000b2\u000e\u0010\f\u001a\n \r*\u0004\u0018\u00018\u00008\u0000H\u0003¢\u0006\u0002\u0010\u000eJ\u001f\u0010\u0015\u001a\u00020\u000b2\u0014\u0010\u0010\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00018\u00008\u00000\u0011H\u0001J\u001c\u0010\u0016\u001a\u00020\u00132\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0018\u001a\u00020\u000bJ\u0016\u0010\f\u001a\n \r*\u0004\u0018\u00018\u00008\u0000H\u0001¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u000bH\u0002J\u0006\u0010\u001b\u001a\u00020\u000bJ\t\u0010\u001c\u001a\u00020\u000bH\u0001J\u0017\u0010\u001d\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00018\u00008\u00000\u001eH\u0003J\u0006\u0010\u001f\u001a\u00020\u0013J\u001e\u0010 \u001a\u00020\u000b2\u000e\u0010!\u001a\n \r*\u0004\u0018\u00018\u00008\u0000H\u0001¢\u0006\u0002\u0010\u000eJ\u001b\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00028\u00002\u0006\u0010$\u001a\u00020\u000b¢\u0006\u0002\u0010%J\u0016\u0010&\u001a\n \r*\u0004\u0018\u00018\u00008\u0000H\u0001¢\u0006\u0002\u0010\u0019J\u0016\u0010'\u001a\n \r*\u0004\u0018\u00018\u00008\u0000H\u0001¢\u0006\u0002\u0010\u0019J\u0016\u0010(\u001a\n \r*\u0004\u0018\u00018\u00008\u0000H\u0001¢\u0006\u0002\u0010\u0019J\u001e\u0010(\u001a\u00020\u000b2\u000e\u0010\f\u001a\n \r*\u0004\u0018\u00018\u00008\u0000H\u0001¢\u0006\u0002\u0010\u000eJ\u001f\u0010)\u001a\u00020\u000b2\u0014\u0010\u0010\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00018\u00008\u00000\u0011H\u0001J\u001f\u0010*\u001a\u00020\u000b2\u0014\u0010\u0010\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00018\u00008\u00000\u0011H\u0001R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u0006X\u0005¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006,"}, hxF = {"Lcom/tencent/mm/appbrand/v8/TaskQueueWithImportantIndexUnsafe;", "T", "Ljava/util/Queue;", "q", "(Ljava/util/Queue;)V", "lastImportantTaskIndex", "", "size", "getSize", "()I", "add", "", "element", "kotlin.jvm.PlatformType", "(Ljava/lang/Object;)Z", "addAll", MessengerShareContentUtility.ELEMENTS, "", "clear", "", "contains", "containsAll", "copyToWriteUnsafe", "anotherQueue", "isPaused", "()Ljava/lang/Object;", "getLastTaskIndexToExecute", "hasImportantTask", "isEmpty", "iterator", "", "markImportantTask", "offer", "p0", "offerTask", "t", "important", "(Ljava/lang/Object;Z)V", "peek", "poll", "remove", "removeAll", "retainAll", "Companion", "luggage-v8-ext_release"})
public final class l<T> implements Queue<T> {
    public static final a dpP = new a((byte) 0);
    private int dpN = -1;
    private final Queue<T> dpO;

    static {
        AppMethodBeat.i(216939);
        AppMethodBeat.o(216939);
    }

    @Override // java.util.Collection, java.util.Queue
    public final boolean add(T t) {
        AppMethodBeat.i(216941);
        boolean add = this.dpO.add(t);
        AppMethodBeat.o(216941);
        return add;
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection<? extends T> collection) {
        AppMethodBeat.i(216942);
        p.h(collection, MessengerShareContentUtility.ELEMENTS);
        boolean addAll = this.dpO.addAll(collection);
        AppMethodBeat.o(216942);
        return addAll;
    }

    public final void clear() {
        AppMethodBeat.i(216943);
        this.dpO.clear();
        AppMethodBeat.o(216943);
    }

    public final boolean contains(Object obj) {
        AppMethodBeat.i(216944);
        boolean contains = this.dpO.contains(obj);
        AppMethodBeat.o(216944);
        return contains;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection<? extends Object> collection) {
        AppMethodBeat.i(216945);
        p.h(collection, MessengerShareContentUtility.ELEMENTS);
        boolean containsAll = this.dpO.containsAll(collection);
        AppMethodBeat.o(216945);
        return containsAll;
    }

    @Override // java.util.Queue
    public final T element() {
        AppMethodBeat.i(216946);
        T element = this.dpO.element();
        AppMethodBeat.o(216946);
        return element;
    }

    public final boolean isEmpty() {
        AppMethodBeat.i(216947);
        boolean isEmpty = this.dpO.isEmpty();
        AppMethodBeat.o(216947);
        return isEmpty;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator<T> iterator() {
        AppMethodBeat.i(216948);
        Iterator<T> it = this.dpO.iterator();
        AppMethodBeat.o(216948);
        return it;
    }

    @Override // java.util.Queue
    public final boolean offer(T t) {
        AppMethodBeat.i(216949);
        boolean offer = this.dpO.offer(t);
        AppMethodBeat.o(216949);
        return offer;
    }

    @Override // java.util.Queue
    @RecentlyNullable
    public final T peek() {
        AppMethodBeat.i(216950);
        T peek = this.dpO.peek();
        AppMethodBeat.o(216950);
        return peek;
    }

    @Override // java.util.Queue
    @RecentlyNullable
    public final T poll() {
        AppMethodBeat.i(216951);
        T poll = this.dpO.poll();
        AppMethodBeat.o(216951);
        return poll;
    }

    @Override // java.util.Queue
    public final T remove() {
        AppMethodBeat.i(216952);
        T remove = this.dpO.remove();
        AppMethodBeat.o(216952);
        return remove;
    }

    public final boolean remove(Object obj) {
        AppMethodBeat.i(216953);
        boolean remove = this.dpO.remove(obj);
        AppMethodBeat.o(216953);
        return remove;
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection<? extends Object> collection) {
        AppMethodBeat.i(216954);
        p.h(collection, MessengerShareContentUtility.ELEMENTS);
        boolean removeAll = this.dpO.removeAll(collection);
        AppMethodBeat.o(216954);
        return removeAll;
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection<? extends Object> collection) {
        AppMethodBeat.i(216955);
        p.h(collection, MessengerShareContentUtility.ELEMENTS);
        boolean retainAll = this.dpO.retainAll(collection);
        AppMethodBeat.o(216955);
        return retainAll;
    }

    public final Object[] toArray() {
        AppMethodBeat.i(216956);
        Object[] w = i.w(this);
        AppMethodBeat.o(216956);
        return w;
    }

    @Override // java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        AppMethodBeat.i(216957);
        T[] tArr2 = (T[]) i.a(this, tArr);
        AppMethodBeat.o(216957);
        return tArr2;
    }

    public l(Queue<T> queue) {
        p.h(queue, "q");
        AppMethodBeat.i(216938);
        this.dpO = queue;
        AppMethodBeat.o(216938);
    }

    public final boolean XI() {
        return this.dpN >= 0;
    }

    public final void b(T t, boolean z) {
        AppMethodBeat.i(216937);
        offer(t);
        if (z) {
            this.dpN = this.dpO.size() - 1;
        }
        AppMethodBeat.o(216937);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u0005¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/appbrand/v8/TaskQueueWithImportantIndexUnsafe$Companion;", "", "()V", "create", "Lcom/tencent/mm/appbrand/v8/TaskQueueWithImportantIndexUnsafe;", "T", "luggage-v8-ext_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void a(Queue<T> queue, boolean z) {
        int size;
        int i2 = 0;
        AppMethodBeat.i(216936);
        p.h(queue, "anotherQueue");
        if (z) {
            size = this.dpN;
        } else {
            size = this.dpO.size();
        }
        this.dpN = -1;
        int i3 = 0;
        for (T t : this.dpO) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                j.hxH();
            }
            if (i3 <= size) {
                queue.offer(t);
            }
            i3 = i4;
        }
        if (size >= 0) {
            while (true) {
                this.dpO.poll();
                if (i2 == size) {
                    break;
                }
                i2++;
            }
        }
        AppMethodBeat.o(216936);
    }

    public final /* bridge */ int size() {
        AppMethodBeat.i(216940);
        int size = this.dpO.size();
        AppMethodBeat.o(216940);
        return size;
    }
}
