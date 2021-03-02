package com.tencent.mm.plugin.finder.video.sticker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.chz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sticker.c.h;
import com.tencent.mm.sticker.c.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001dJ\u0006\u0010\u001f\u001a\u00020\u001dJ\u0016\u0010 \u001a\u00020\u001d2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00150\"H\u0002J\u0016\u0010#\u001a\u00020\u001d2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00150\"H\u0002R\u000e\u0010\b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/sticker/StickerData;", "", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "callback", "Lcom/tencent/mm/plugin/finder/video/sticker/StickerDataCallback;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;Lcom/tencent/mm/plugin/finder/video/sticker/StickerDataCallback;)V", "TAG", "", "getCallback", "()Lcom/tencent/mm/plugin/finder/video/sticker/StickerDataCallback;", "codeMore", "", "ctxBuff", "", "dataHasMore", "", "firstPage", "historyList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "isLoading", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "moreList", "pageBuff", "requestType", "destroy", "", "loadHistory", "loadMore", "processHistory", "lensList", "", "processMore", "plugin-finder_release"})
public final class b {
    final String TAG = "MicroMsg.StickerData";
    private final com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> gZm;
    boolean isLoading;
    private int requestType;
    final int rpa = 2;
    byte[] rpb;
    boolean rpc = true;
    boolean rpd = true;
    private byte[] rpg;
    final LinkedList<chz> rpi = new LinkedList<>();
    final LinkedList<chz> rpj = new LinkedList<>();
    final c wiP;

    public b(com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> bVar, c cVar) {
        p.h(bVar, "lifeCycleKeeper");
        p.h(cVar, "callback");
        AppMethodBeat.i(254561);
        this.gZm = bVar;
        this.wiP = cVar;
        dGf();
        com.tencent.mm.sticker.a.b bVar2 = com.tencent.mm.sticker.a.b.NOi;
        com.tencent.mm.sticker.a.b.ae(new kotlin.g.a.a<x>(this) {
            /* class com.tencent.mm.plugin.finder.video.sticker.b.AnonymousClass1 */
            final /* synthetic */ b wiQ;

            {
                this.wiQ = r2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(254554);
                this.wiQ.dGf();
                x xVar = x.SXb;
                AppMethodBeat.o(254554);
                return xVar;
            }
        });
        AppMethodBeat.o(254561);
    }

    public final void dGf() {
        AppMethodBeat.i(254559);
        com.tencent.mm.ac.d.b("StickerData_loadHistory", new a(this));
        AppMethodBeat.o(254559);
    }

    public final void cJk() {
        AppMethodBeat.i(254560);
        Log.i(this.TAG, "loadMore: " + this.isLoading + ", " + this.rpc);
        if (!this.rpc || this.isLoading) {
            AppMethodBeat.o(254560);
            return;
        }
        this.isLoading = true;
        i.a aVar = i.NOv;
        i.a.a(this.requestType, this.rpb, this.rpg, this.gZm, new C1323b(this));
        AppMethodBeat.o(254560);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/video/sticker/StickerData$loadMore$1", "Lcom/tencent/mm/sticker/task/GetLensListCallback;", "onResult", "", "errType", "", "errCode", "response", "Lcom/tencent/mm/protocal/protobuf/GetLensListResponse;", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.video.sticker.b$b  reason: collision with other inner class name */
    public static final class C1323b implements h {
        final /* synthetic */ b wiQ;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C1323b(b bVar) {
            this.wiQ = bVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0031, code lost:
            if (r3 == true) goto L_0x0033;
         */
        @Override // com.tencent.mm.sticker.c.h
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(int r7, int r8, com.tencent.mm.protocal.protobuf.bpi r9) {
            /*
            // Method dump skipped, instructions count: 166
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.video.sticker.b.C1323b.a(int, int, com.tencent.mm.protocal.protobuf.bpi):void");
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ b wiQ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(b bVar) {
            super(0);
            this.wiQ = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(254555);
            b bVar = this.wiQ;
            com.tencent.mm.sticker.a.b bVar2 = com.tencent.mm.sticker.a.b.NOi;
            com.tencent.mm.ac.d.h(new c(bVar, com.tencent.mm.sticker.a.b.gzf()));
            x xVar = x.SXb;
            AppMethodBeat.o(254555);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ List roU;
        final /* synthetic */ b wiQ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(b bVar, List list) {
            super(0);
            this.wiQ = bVar;
            this.roU = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(254557);
            this.wiQ.rpi.clear();
            this.wiQ.rpi.addAll(this.roU);
            c cVar = this.wiQ.wiP;
            LinkedList<chz> linkedList = this.wiQ.rpi;
            ArrayList arrayList = new ArrayList(j.a(linkedList, 10));
            Iterator<T> it = linkedList.iterator();
            while (it.hasNext()) {
                arrayList.add(new com.tencent.mm.sticker.c(it.next(), 3, 2, (byte) 0));
            }
            cVar.eE(arrayList);
            x xVar = x.SXb;
            AppMethodBeat.o(254557);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ List roU;
        final /* synthetic */ b wiQ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(b bVar, List list) {
            super(0);
            this.wiQ = bVar;
            this.roU = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(254558);
            if (this.wiQ.rpd) {
                this.wiQ.rpd = false;
                this.wiQ.rpj.clear();
            }
            this.wiQ.rpj.addAll(this.roU);
            c cVar = this.wiQ.wiP;
            LinkedList<chz> linkedList = this.wiQ.rpj;
            ArrayList arrayList = new ArrayList(j.a(linkedList, 10));
            Iterator<T> it = linkedList.iterator();
            while (it.hasNext()) {
                arrayList.add(new com.tencent.mm.sticker.c(it.next(), 3, 2, (byte) 0));
            }
            cVar.dl(arrayList);
            x xVar = x.SXb;
            AppMethodBeat.o(254558);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(b bVar, List list) {
        AppMethodBeat.i(254562);
        com.tencent.mm.ac.d.h(new d(bVar, list));
        AppMethodBeat.o(254562);
    }
}
