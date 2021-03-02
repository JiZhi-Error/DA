package com.tencent.mm.plugin.finder.feed.model.internal;

import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.j;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ \u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003J\u0016\u0010\u000f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u001e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u0016\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\"\u0010\u0014\u001a\u00020\t2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018J\u001e\u0010\u0019\u001a\u00020\t2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u0014\u0010\u001c\u001a\u00020\t2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/internal/DispatcherMachine;", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "", "viewCallbacks", "Ljava/util/LinkedList;", "Lcom/tencent/mm/view/IViewActionCallback;", "(Ljava/util/LinkedList;)V", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", MessengerShareContentUtility.ATTACHMENT_PAYLOAD, "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishInserted", "op", "Lcom/tencent/mm/plugin/finder/feed/model/internal/UpdateOp;", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMore", "isSmooth", "", "onPreFinishRefresh", "plugin-finder_release"})
public final class d<R extends i> {
    final LinkedList<j> viewCallbacks;

    public d(LinkedList<j> linkedList) {
        p.h(linkedList, "viewCallbacks");
        AppMethodBeat.i(245021);
        this.viewCallbacks = linkedList;
        AppMethodBeat.o(245021);
    }

    public final void onChanged() {
        AppMethodBeat.i(245014);
        com.tencent.mm.ac.d.h(new a(this));
        AppMethodBeat.o(245014);
    }

    public final void IN(int i2) {
        AppMethodBeat.i(245015);
        com.tencent.mm.ac.d.h(new b(this, i2));
        AppMethodBeat.o(245015);
    }

    public final void onItemRangeChanged(int i2, int i3, Object obj) {
        AppMethodBeat.i(245016);
        com.tencent.mm.ac.d.h(new c(this, i2, i3, obj));
        AppMethodBeat.o(245016);
    }

    public final void onItemRangeInserted(int i2, int i3) {
        AppMethodBeat.i(245017);
        com.tencent.mm.ac.d.h(new C1160d(this, i2, i3));
        AppMethodBeat.o(245017);
    }

    public final void onItemRangeRemoved(int i2, int i3) {
        AppMethodBeat.i(245018);
        com.tencent.mm.ac.d.h(new e(this, i2, i3));
        AppMethodBeat.o(245018);
    }

    public final void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> cVar) {
        AppMethodBeat.i(245019);
        p.h(cVar, "reason");
        com.tencent.mm.ac.d.h(new g(this, cVar));
        AppMethodBeat.o(245019);
    }

    public final void f(RefreshLoadMoreLayout.c<Object> cVar) {
        AppMethodBeat.i(245020);
        p.h(cVar, "reason");
        com.tencent.mm.ac.d.h(new f(this, true, cVar));
        AppMethodBeat.o(245020);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
    public static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d tYf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(d dVar) {
            super(0);
            this.tYf = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(245007);
            LinkedList<j> linkedList = this.tYf.viewCallbacks;
            synchronized (linkedList) {
                try {
                    Iterator<T> it = linkedList.iterator();
                    while (it.hasNext()) {
                        it.next().onChanged();
                    }
                    x xVar = x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(245007);
                    throw th;
                }
            }
            x xVar2 = x.SXb;
            AppMethodBeat.o(245007);
            return xVar2;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d tYf;
        final /* synthetic */ int tYg;
        final /* synthetic */ int tYh = 1;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(d dVar, int i2) {
            super(0);
            this.tYf = dVar;
            this.tYg = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(245008);
            LinkedList<j> linkedList = this.tYf.viewCallbacks;
            synchronized (linkedList) {
                try {
                    Iterator<T> it = linkedList.iterator();
                    while (it.hasNext()) {
                        it.next().onItemRangeChanged(this.tYg, this.tYh);
                    }
                    x xVar = x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(245008);
                    throw th;
                }
            }
            x xVar2 = x.SXb;
            AppMethodBeat.o(245008);
            return xVar2;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d tYf;
        final /* synthetic */ int tYg;
        final /* synthetic */ int tYh;
        final /* synthetic */ Object tYi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(d dVar, int i2, int i3, Object obj) {
            super(0);
            this.tYf = dVar;
            this.tYg = i2;
            this.tYh = i3;
            this.tYi = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(245009);
            LinkedList<j> linkedList = this.tYf.viewCallbacks;
            synchronized (linkedList) {
                try {
                    Iterator<T> it = linkedList.iterator();
                    while (it.hasNext()) {
                        it.next().onItemRangeChanged(this.tYg, this.tYh, this.tYi);
                    }
                    x xVar = x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(245009);
                    throw th;
                }
            }
            x xVar2 = x.SXb;
            AppMethodBeat.o(245009);
            return xVar2;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.finder.feed.model.internal.d$d  reason: collision with other inner class name */
    public static final class C1160d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d tYf;
        final /* synthetic */ int tYg;
        final /* synthetic */ int tYh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1160d(d dVar, int i2, int i3) {
            super(0);
            this.tYf = dVar;
            this.tYg = i2;
            this.tYh = i3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(245010);
            LinkedList<j> linkedList = this.tYf.viewCallbacks;
            synchronized (linkedList) {
                try {
                    Iterator<T> it = linkedList.iterator();
                    while (it.hasNext()) {
                        it.next().onItemRangeInserted(this.tYg, this.tYh);
                    }
                    x xVar = x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(245010);
                    throw th;
                }
            }
            x xVar2 = x.SXb;
            AppMethodBeat.o(245010);
            return xVar2;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
    public static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d tYf;
        final /* synthetic */ int tYg;
        final /* synthetic */ int tYh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(d dVar, int i2, int i3) {
            super(0);
            this.tYf = dVar;
            this.tYg = i2;
            this.tYh = i3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(245011);
            LinkedList<j> linkedList = this.tYf.viewCallbacks;
            synchronized (linkedList) {
                try {
                    Iterator<T> it = linkedList.iterator();
                    while (it.hasNext()) {
                        it.next().onItemRangeRemoved(this.tYg, this.tYh);
                    }
                    x xVar = x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(245011);
                    throw th;
                }
            }
            x xVar2 = x.SXb;
            AppMethodBeat.o(245011);
            return xVar2;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
    public static final class g extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ RefreshLoadMoreLayout.c $reason;
        final /* synthetic */ d tYf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(d dVar, RefreshLoadMoreLayout.c cVar) {
            super(0);
            this.tYf = dVar;
            this.$reason = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(245013);
            LinkedList<j> linkedList = this.tYf.viewCallbacks;
            synchronized (linkedList) {
                try {
                    Iterator<T> it = linkedList.iterator();
                    while (it.hasNext()) {
                        it.next().onPreFinishRefresh(this.$reason);
                    }
                    x xVar = x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(245013);
                    throw th;
                }
            }
            x xVar2 = x.SXb;
            AppMethodBeat.o(245013);
            return xVar2;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "R", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "invoke"})
    public static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ RefreshLoadMoreLayout.c $reason;
        final /* synthetic */ boolean tSM = true;
        final /* synthetic */ d tYf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(d dVar, boolean z, RefreshLoadMoreLayout.c cVar) {
            super(0);
            this.tYf = dVar;
            this.$reason = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(245012);
            LinkedList<j> linkedList = this.tYf.viewCallbacks;
            synchronized (linkedList) {
                try {
                    for (T t : linkedList) {
                        if (this.tSM) {
                            t.onPreFinishLoadMoreSmooth(this.$reason);
                        } else {
                            t.onPreFinishLoadMore(this.$reason);
                        }
                    }
                    x xVar = x.SXb;
                } catch (Throwable th) {
                    AppMethodBeat.o(245012);
                    throw th;
                }
            }
            x xVar2 = x.SXb;
            AppMethodBeat.o(245012);
            return xVar2;
        }
    }
}
