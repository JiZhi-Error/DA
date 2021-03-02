package com.tencent.mm.plugin.finder.feed.model.internal;

import android.support.v7.h.c;
import android.support.v7.h.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.storage.c;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.x;

public abstract class b<T extends i> {
    private final boolean DEBUG = ((Boolean) c.dtl().value()).booleanValue();

    public abstract d getListUpdateCallback();

    public abstract k mergeDataAndNotify(int i2, List<? extends T> list, boolean z, Object obj);

    public abstract void mergeInit(IResponse<T> iResponse, kotlin.g.a.b<? super IResponse<T>, x> bVar);

    public abstract void mergeInsert(IResponse<T> iResponse, kotlin.g.a.b<? super IResponse<T>, x> bVar);

    public abstract void mergeLoadMore(IResponse<T> iResponse, kotlin.g.a.b<? super IResponse<T>, x> bVar);

    public abstract void mergeRefresh(IResponse<T> iResponse, kotlin.g.a.b<? super IResponse<T>, x> bVar);

    public b() {
        c cVar = c.vCb;
    }

    public final boolean getDEBUG() {
        return this.DEBUG;
    }

    public static /* synthetic */ int findMergeIndex$default(b bVar, ArrayList arrayList, List list, int i2, Object obj, int i3, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findMergeIndex");
        }
        if ((i3 & 8) != 0) {
            obj = null;
        }
        return bVar.findMergeIndex(arrayList, list, i2, obj);
    }

    public int findMergeIndex(ArrayList<T> arrayList, List<? extends T> list, int i2, Object obj) {
        p.h(arrayList, "srcList");
        p.h(list, "newList");
        return 0;
    }

    public boolean finallyHandleMergeList(ArrayList<T> arrayList, LinkedList<T> linkedList, int i2, int i3, Object obj) {
        p.h(arrayList, "srcList");
        p.h(linkedList, "newList");
        return false;
    }

    public boolean needCleanWhenRefresh(List<? extends T> list) {
        p.h(list, "newList");
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.tencent.mm.plugin.finder.feed.model.internal.b */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void mergeInit$default(b bVar, IResponse iResponse, kotlin.g.a.b bVar2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: mergeInit");
        }
        if ((i2 & 2) != 0) {
            bVar2 = null;
        }
        bVar.mergeInit(iResponse, bVar2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.tencent.mm.plugin.finder.feed.model.internal.b */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void mergeRefresh$default(b bVar, IResponse iResponse, kotlin.g.a.b bVar2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: mergeRefresh");
        }
        if ((i2 & 2) != 0) {
            bVar2 = null;
        }
        bVar.mergeRefresh(iResponse, bVar2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.tencent.mm.plugin.finder.feed.model.internal.b */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void mergeLoadMore$default(b bVar, IResponse iResponse, kotlin.g.a.b bVar2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: mergeLoadMore");
        }
        if ((i2 & 2) != 0) {
            bVar2 = null;
        }
        bVar.mergeLoadMore(iResponse, bVar2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.tencent.mm.plugin.finder.feed.model.internal.b */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void mergeInsert$default(b bVar, IResponse iResponse, kotlin.g.a.b bVar2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: mergeInsert");
        }
        if ((i2 & 2) != 0) {
            bVar2 = null;
        }
        bVar.mergeInsert(iResponse, bVar2);
    }

    public static /* synthetic */ k mergeDataAndNotify$default(b bVar, int i2, List list, boolean z, Object obj, int i3, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: mergeDataAndNotify");
        }
        if ((i3 & 8) != 0) {
            obj = null;
        }
        return bVar.mergeDataAndNotify(i2, list, z, obj);
    }

    public final void diff(List<? extends T> list, List<? extends T> list2) {
        p.h(list, "oldList");
        p.h(list2, "newList");
        c.b a2 = android.support.v7.h.c.a(getDiffCallback(list, list2));
        p.g(a2, "DiffUtil.calculateDiff(g…llback(oldList, newList))");
        a2.a(getListUpdateCallback());
    }

    public boolean diffDetectMoves() {
        return false;
    }

    public boolean areItemsTheSame(T t, T t2) {
        p.h(t, "item1");
        p.h(t2, "item2");
        return t.a(t2) == 0;
    }

    public boolean areContentsTheSame(T t, T t2) {
        p.h(t, "item1");
        p.h(t2, "item2");
        return true;
    }

    public Object getChangePayload(T t, T t2) {
        p.h(t, "item1");
        p.h(t2, "item2");
        return null;
    }

    public c.a getDiffCallback(List<? extends T> list, List<? extends T> list2) {
        p.h(list, "oldList");
        p.h(list2, "newList");
        return new a(this, list, list2);
    }

    public final class a extends c.a {
        private final List<T> oew;
        private final List<T> oex;
        final /* synthetic */ b tYe;

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends T extends com.tencent.mm.plugin.finder.feed.model.internal.i> */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.List<? extends T extends com.tencent.mm.plugin.finder.feed.model.internal.i> */
        /* JADX WARN: Multi-variable type inference failed */
        public a(b bVar, List<? extends T> list, List<? extends T> list2) {
            p.h(list, "oldList");
            p.h(list2, "newList");
            this.tYe = bVar;
            AppMethodBeat.i(244999);
            this.oew = list;
            this.oex = list2;
            AppMethodBeat.o(244999);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.tencent.mm.plugin.finder.feed.model.internal.b */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v7.h.c.a
        public final boolean i(int i2, int i3) {
            AppMethodBeat.i(244994);
            boolean areItemsTheSame = this.tYe.areItemsTheSame(this.oew.get(i2), this.oex.get(i3));
            AppMethodBeat.o(244994);
            return areItemsTheSame;
        }

        @Override // android.support.v7.h.c.a
        public final int aB() {
            AppMethodBeat.i(244995);
            int size = this.oew.size();
            AppMethodBeat.o(244995);
            return size;
        }

        @Override // android.support.v7.h.c.a
        public final int aC() {
            AppMethodBeat.i(244996);
            int size = this.oex.size();
            AppMethodBeat.o(244996);
            return size;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.tencent.mm.plugin.finder.feed.model.internal.b */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v7.h.c.a
        public final boolean j(int i2, int i3) {
            AppMethodBeat.i(244997);
            boolean areContentsTheSame = this.tYe.areContentsTheSame(this.oew.get(i2), this.oex.get(i3));
            AppMethodBeat.o(244997);
            return areContentsTheSame;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.tencent.mm.plugin.finder.feed.model.internal.b */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.v7.h.c.a
        public final Object h(int i2, int i3) {
            AppMethodBeat.i(244998);
            Object changePayload = this.tYe.getChangePayload(this.oew.get(i2), this.oex.get(i3));
            AppMethodBeat.o(244998);
            return changePayload;
        }
    }
}
