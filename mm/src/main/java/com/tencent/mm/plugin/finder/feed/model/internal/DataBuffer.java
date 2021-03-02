package com.tencent.mm.plugin.finder.feed.model.internal;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u001e\n\u0002\b\u0002\u0018\u0000 \u001b*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u001bB\u0017\b\u0016\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0004B\u001f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0013J\u0016\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\tH\u0002¢\u0006\u0002\u0010\u0016J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007J\u0016\u0010\u0018\u001a\u00020\u00112\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001aR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "T", "Ljava/util/ArrayList;", "buffer", "(Ljava/util/ArrayList;)V", "t", "(Ljava/lang/Object;Ljava/util/ArrayList;)V", "", "offset", "", "getOffset", "()I", "totalSize", "getTotalSize", "clearBuffer", "", "contains", "", "element", "(Ljava/lang/Object;)Z", "get", FirebaseAnalytics.b.INDEX, "(I)Ljava/lang/Object;", "getBuffer", "setBuffer", MessengerShareContentUtility.ELEMENTS, "", "Companion", "plugin-finder_release"})
public final class DataBuffer<T> extends ArrayList<T> {
    public static final a Companion = new a((byte) 0);
    public static final String TAG = "DataBuffer";
    private final List<T> buffer;

    static {
        AppMethodBeat.i(244989);
        AppMethodBeat.o(244989);
    }

    public final int getSize() {
        AppMethodBeat.i(244992);
        int size = super.size();
        AppMethodBeat.o(244992);
        return size;
    }

    @Override // java.util.List, java.util.AbstractList, java.util.ArrayList
    public final T remove(int i2) {
        AppMethodBeat.i(244991);
        T t = (T) removeAt(i2);
        AppMethodBeat.o(244991);
        return t;
    }

    public final Object removeAt(int i2) {
        AppMethodBeat.i(244990);
        Object remove = super.remove(i2);
        AppMethodBeat.o(244990);
        return remove;
    }

    public final int size() {
        AppMethodBeat.i(244993);
        int size = getSize();
        AppMethodBeat.o(244993);
        return size;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public DataBuffer(ArrayList<T> arrayList) {
        p.h(arrayList, "buffer");
        AppMethodBeat.i(244985);
        this.buffer = arrayList;
        AppMethodBeat.o(244985);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DataBuffer(ArrayList arrayList, int i2, j jVar) {
        this((i2 & 1) != 0 ? new ArrayList() : arrayList);
        AppMethodBeat.i(244986);
        AppMethodBeat.o(244986);
    }

    public DataBuffer(T t, ArrayList<T> arrayList) {
        p.h(arrayList, "buffer");
        AppMethodBeat.i(244987);
        this.buffer = arrayList;
        add(t);
        AppMethodBeat.o(244987);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DataBuffer(Object obj, ArrayList arrayList, int i2, j jVar) {
        this(obj, (i2 & 2) != 0 ? new ArrayList() : arrayList);
        AppMethodBeat.i(244988);
        AppMethodBeat.o(244988);
    }

    public final int getTotalSize() {
        AppMethodBeat.i(244979);
        int size = size() + (this.buffer.size() - getOffset());
        AppMethodBeat.o(244979);
        return size;
    }

    public final int getOffset() {
        AppMethodBeat.i(244980);
        Object kv = kotlin.a.j.kv(this);
        if (kv != null) {
            int indexOf = this.buffer.indexOf(kv) + 1;
            AppMethodBeat.o(244980);
            return indexOf;
        }
        AppMethodBeat.o(244980);
        return 0;
    }

    @Override // java.util.List, java.util.AbstractList, java.util.ArrayList
    public final T get(int i2) {
        AppMethodBeat.i(244981);
        if (i2 < size()) {
            T t = (T) super.get(i2);
            AppMethodBeat.o(244981);
            return t;
        }
        T t2 = this.buffer.get((i2 - size()) + getOffset());
        AppMethodBeat.o(244981);
        return t2;
    }

    public final void clearBuffer() {
        AppMethodBeat.i(244982);
        this.buffer.clear();
        AppMethodBeat.o(244982);
    }

    public final List<T> getBuffer() {
        return this.buffer;
    }

    public final boolean setBuffer(Collection<? extends T> collection) {
        AppMethodBeat.i(244983);
        clearBuffer();
        if (collection == null) {
            AppMethodBeat.o(244983);
            return false;
        }
        Log.i(TAG, "[addAllBuffer] " + collection.size());
        boolean addAll = this.buffer.addAll(collection);
        AppMethodBeat.o(244983);
        return addAll;
    }

    public final boolean contains(Object obj) {
        AppMethodBeat.i(244984);
        if (super.contains(obj) || this.buffer.contains(obj)) {
            AppMethodBeat.o(244984);
            return true;
        }
        AppMethodBeat.o(244984);
        return false;
    }
}
