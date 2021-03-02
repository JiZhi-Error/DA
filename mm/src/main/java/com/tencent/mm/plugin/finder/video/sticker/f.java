package com.tencent.mm.plugin.finder.video.sticker;

import android.support.v7.h.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.chz;
import com.tencent.mm.sticker.c;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

public final class f implements c {
    private static final com.tencent.mm.sticker.c wiZ = new com.tencent.mm.sticker.c(new chz(), 0, 6, (byte) 0);
    public static final a wja = new a((byte) 0);
    private final LinkedList<com.tencent.mm.sticker.c> rpi = new LinkedList<>();
    private final LinkedList<com.tencent.mm.sticker.c> rpj = new LinkedList<>();
    final d wiX;
    final d wiY;

    public f(d dVar, d dVar2) {
        p.h(dVar, "historyCallback");
        p.h(dVar2, "moreCallback");
        AppMethodBeat.i(254592);
        this.wiX = dVar;
        this.wiY = dVar2;
        AppMethodBeat.o(254592);
    }

    @Override // com.tencent.mm.plugin.finder.video.sticker.c
    public final void eE(List<com.tencent.mm.sticker.c> list) {
        AppMethodBeat.i(254590);
        p.h(list, "lensList");
        com.tencent.mm.ac.d.b("StickerEffectCallbackWrapper_onHistory", new c(this, list));
        AppMethodBeat.o(254590);
    }

    @Override // com.tencent.mm.plugin.finder.video.sticker.c
    public final void dl(List<com.tencent.mm.sticker.c> list) {
        AppMethodBeat.i(254591);
        p.h(list, "lensList");
        com.tencent.mm.ac.d.b("StickerEffectCallbackWrapper_onMore", new d(this, list));
        AppMethodBeat.o(254591);
    }

    public static final class b implements android.support.v7.h.d {
        private final d wiO;

        public b(d dVar) {
            p.h(dVar, "callback");
            AppMethodBeat.i(254585);
            this.wiO = dVar;
            AppMethodBeat.o(254585);
        }

        @Override // android.support.v7.h.d
        public final void f(int i2, int i3) {
            AppMethodBeat.i(254581);
            this.wiO.fH(i2, i3);
            AppMethodBeat.o(254581);
        }

        @Override // android.support.v7.h.d
        public final void k(int i2, int i3) {
            AppMethodBeat.i(254582);
            this.wiO.fI(i2, i3);
            AppMethodBeat.o(254582);
        }

        @Override // android.support.v7.h.d
        public final void l(int i2, int i3) {
            AppMethodBeat.i(254583);
            this.wiO.fJ(i2, i3);
            AppMethodBeat.o(254583);
        }

        @Override // android.support.v7.h.d
        public final void c(int i2, int i3, Object obj) {
            AppMethodBeat.i(254584);
            this.wiO.fK(i2, i3);
            AppMethodBeat.o(254584);
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(254593);
        AppMethodBeat.o(254593);
    }

    /* access modifiers changed from: package-private */
    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ List roU;
        final /* synthetic */ f wjb;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(f fVar, List list) {
            super(0);
            this.wjb = fVar;
            this.roU = list;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(254587);
            final LinkedList linkedList = new LinkedList();
            if (!this.roU.isEmpty()) {
                a aVar = f.wja;
                linkedList.add(f.wiZ);
            }
            linkedList.addAll(this.roU);
            c.a aVar2 = com.tencent.mm.sticker.c.NML;
            final c.b A = c.a.A(this.wjb.rpi, linkedList);
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.finder.video.sticker.f.c.AnonymousClass1 */
                final /* synthetic */ c wjc;

                {
                    this.wjc = r2;
                }

                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(254586);
                    this.wjc.wjb.rpi.clear();
                    this.wjc.wjb.rpi.addAll(linkedList);
                    this.wjc.wjb.wiX.ad(this.wjc.wjb.rpi);
                    A.a(new b(this.wjc.wjb.wiX));
                    x xVar = x.SXb;
                    AppMethodBeat.o(254586);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(254587);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ List roU;
        final /* synthetic */ f wjb;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(f fVar, List list) {
            super(0);
            this.wjb = fVar;
            this.roU = list;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(254589);
            final LinkedList linkedList = new LinkedList();
            if (!this.roU.isEmpty()) {
                a aVar = f.wja;
                linkedList.add(f.wiZ);
            }
            linkedList.addAll(this.roU);
            c.a aVar2 = com.tencent.mm.sticker.c.NML;
            final c.b A = c.a.A(this.wjb.rpj, linkedList);
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.finder.video.sticker.f.d.AnonymousClass1 */
                final /* synthetic */ d wje;

                {
                    this.wje = r2;
                }

                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(254588);
                    this.wje.wjb.rpj.clear();
                    this.wje.wjb.rpj.addAll(linkedList);
                    this.wje.wjb.wiY.ad(this.wje.wjb.rpj);
                    A.a(new b(this.wje.wjb.wiY));
                    x xVar = x.SXb;
                    AppMethodBeat.o(254588);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(254589);
            return xVar;
        }
    }
}
