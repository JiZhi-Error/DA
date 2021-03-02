package com.tencent.mm.loader.e.b;

import com.tencent.mm.ac.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ1\u0010\u000b\u001a\u00020\n\"\u0004\b\u0000\u0010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\u0006\u0010\u000e\u001a\u0002H\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¢\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J&\u0010\u0016\u001a\u00020\n\"\u0004\b\u0000\u0010\f2\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00072\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\f0\u0019J \u0010\u001a\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0007J*\u0010\u001b\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u0015R0\u0010\u0003\u001a$\u0012\u0004\u0012\u00020\u0005\u0012\u001a\u0012\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\b0\u00060\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/loader/impr/target/TargetCenter;", "", "()V", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlin/Pair;", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;", "clean", "", "dispatch", "R", "target", "resource", "waitUI", "Lcom/tencent/mm/loader/impr/target/IWaitUI;", "(Lcom/tencent/mm/loader/impr/target/ResourceShowTarget;Ljava/lang/Object;Lcom/tencent/mm/loader/impr/target/IWaitUI;)V", "isNeed", "", "url", "", "onDataItemLoadEnd", "data", "result", "Lcom/tencent/mm/loader/model/LoadResult;", "register", "unregister", "reason", "Companion", "libimageloader_release"})
public final class e {
    private static final String TAG = TAG;
    private static final f iax = g.ah(b.iaz);
    public static final a iay = new a((byte) 0);
    private ConcurrentHashMap<Integer, o<com.tencent.mm.loader.h.a.a<?>, d<Object>>> cCB;

    private e() {
        this.cCB = new ConcurrentHashMap<>();
    }

    public /* synthetic */ e(byte b2) {
        this();
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8FX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\r"}, hxF = {"Lcom/tencent/mm/loader/impr/target/TargetCenter$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "instance", "Lcom/tencent/mm/loader/impr/target/TargetCenter;", "getInstance", "()Lcom/tencent/mm/loader/impr/target/TargetCenter;", "instance$delegate", "Lkotlin/Lazy;", "libimageloader_release"})
    public static final class a {
        public static e aJX() {
            f fVar = e.iax;
            a aVar = e.iay;
            return (e) fVar.getValue();
        }

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void a(d<Object> dVar, com.tencent.mm.loader.h.a.a<?> aVar) {
        p.h(dVar, "target");
        p.h(aVar, "data");
        int aJV = dVar.aJV();
        Log.i(TAG, "register code " + aJV + " data " + aVar);
        this.cCB.put(Integer.valueOf(aJV), new o<>(aVar, dVar));
    }

    public final void a(d<Object> dVar, com.tencent.mm.loader.h.a.a<?> aVar, String str) {
        p.h(dVar, "target");
        p.h(aVar, "data");
        p.h(str, "reason");
        o<com.tencent.mm.loader.h.a.a<?>, d<Object>> oVar = this.cCB.get(Integer.valueOf(dVar.aJV()));
        if (oVar != null && p.j(oVar.first, aVar)) {
            this.cCB.remove(Integer.valueOf(dVar.aJV()));
        }
    }

    public final <R> void a(com.tencent.mm.loader.h.a.a<?> aVar, com.tencent.mm.loader.h.c<R> cVar) {
        p.h(aVar, "data");
        p.h(cVar, "result");
        d.h(new c(this, aVar, cVar));
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "R", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ e iaA;
        final /* synthetic */ com.tencent.mm.loader.h.a.a iaB;
        final /* synthetic */ com.tencent.mm.loader.h.c iaC;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(e eVar, com.tencent.mm.loader.h.a.a aVar, com.tencent.mm.loader.h.c cVar) {
            super(0);
            this.iaA = eVar;
            this.iaB = aVar;
            this.iaC = cVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0007"}, hxF = {"com/tencent/mm/loader/impr/target/TargetCenter$onDataItemLoadEnd$1$1$1$1", "Lcom/tencent/mm/loader/impr/target/IWaitUI;", "uiDone", "", "isRemove", "", "libimageloader_release", "com/tencent/mm/loader/impr/target/TargetCenter$onDataItemLoadEnd$1$$special$$inlined$let$lambda$1"})
        public static final class a implements b {
            final /* synthetic */ Map.Entry iaD;
            final /* synthetic */ c iaE;

            a(Map.Entry entry, c cVar) {
                this.iaD = entry;
                this.iaE = cVar;
            }

            @Override // com.tencent.mm.loader.e.b.b
            public final void eR(boolean z) {
                if (z) {
                    this.iaE.iaA.a(((o) this.iaD.getValue()).second, this.iaE.iaB, "onDataItemLoadEnd");
                }
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : this.iaA.cCB.entrySet()) {
                if (p.j(((o) entry.getValue()).first, this.iaB)) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            LinkedHashMap linkedHashMap2 = linkedHashMap;
            if (linkedHashMap2.isEmpty()) {
                a aVar = e.iay;
                Log.i(e.TAG, "onDataItemLoadEnd can not found " + this.iaB);
            }
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                R r = this.iaC.value;
                if (r != null) {
                    a aVar2 = e.iay;
                    Log.i(e.TAG, "dispatch " + ((Object) ((o) entry2.getValue()).second) + " resource " + ((Object) r) + " url " + this.iaB + "  try get:" + ((o) entry2.getValue()).second.ias.get());
                    e.a(((o) entry2.getValue()).second, r, new a(entry2, this));
                }
            }
            return x.SXb;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/loader/impr/target/TargetCenter;", "invoke"})
    static final class b extends q implements kotlin.g.a.a<e> {
        public static final b iaz = new b();

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ e invoke() {
            return new e((byte) 0);
        }
    }

    public static final /* synthetic */ void a(d dVar, Object obj, b bVar) {
        if (obj == null) {
            try {
                throw new t("null cannot be cast to non-null type kotlin.Any");
            } catch (Exception e2) {
                Log.i(TAG, "exception " + e2.getMessage());
                bVar.eR(true);
            }
        } else {
            dVar.a(obj, bVar);
        }
    }
}
