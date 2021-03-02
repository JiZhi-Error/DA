package com.tencent.mm.plugin.finder.cgi.fetcher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.ae;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.storage.ab;
import com.tencent.mm.plugin.i.a.ah;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aps;
import com.tencent.mm.protocal.protobuf.art;
import com.tencent.mm.protocal.protobuf.aru;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.a.j;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J1\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\r0\u0010J1\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00162!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\r0\u0010J1\u0010\u0017\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00182!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\r0\u0010J=\u0010\u0019\u001a\u00020\r2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u001b2'\u0010\u000f\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00110\u001b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\r0\u0010J=\u0010\u001d\u001a\u00020\r2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u001b2'\u0010\u000f\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00110\u001b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\r0\u0010J=\u0010\u001e\u001a\u00020\r2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\u001b2'\u0010\u000f\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00110\u001b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\r0\u0010R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderContactFetcher;", "", "()V", "fetchingSet", "Ljava/util/concurrent/ConcurrentHashMap;", "", "strangerContactStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "getStrangerContactStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "strangerContactStorage$delegate", "Lkotlin/Lazy;", "fetchContact", "", "req", "call", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "Lkotlin/ParameterName;", "name", "result", "fetchContact2", "Lcom/tencent/mm/protocal/protobuf/FinderContactMsgInfo;", "fetchContact3", "Lcom/tencent/mm/protocal/protobuf/FinderContactCommentInfo;", "fetchContactList", "reqList", "", "resultList", "fetchContactList2", "fetchContactList3", "Companion", "plugin-finder_release"})
public final class a {
    public static final C1091a twS = new C1091a((byte) 0);
    public final ConcurrentHashMap<String, Object> twQ = new ConcurrentHashMap<>();
    private final kotlin.f twR = kotlin.g.ah(h.twX);

    static {
        AppMethodBeat.i(242584);
        AppMethodBeat.o(242584);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "resultList", "", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
    public static final class b extends q implements kotlin.g.a.b<List<? extends ah>, x> {
        final /* synthetic */ a twT;
        final /* synthetic */ String twU;
        final /* synthetic */ kotlin.g.a.b twV;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(a aVar, String str, kotlin.g.a.b bVar) {
            super(1);
            this.twT = aVar;
            this.twU = str;
            this.twV = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(List<? extends ah> list) {
            AppMethodBeat.i(242572);
            List<? extends ah> list2 = list;
            p.h(list2, "resultList");
            this.twT.twQ.remove(this.twU);
            this.twV.invoke(j.ks(list2));
            x xVar = x.SXb;
            AppMethodBeat.o(242572);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "resultList", "", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
    public static final class c extends q implements kotlin.g.a.b<List<? extends ah>, x> {
        final /* synthetic */ String hLl;
        final /* synthetic */ a twT;
        final /* synthetic */ kotlin.g.a.b twV;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a aVar, String str, kotlin.g.a.b bVar) {
            super(1);
            this.twT = aVar;
            this.hLl = str;
            this.twV = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(List<? extends ah> list) {
            AppMethodBeat.i(242573);
            List<? extends ah> list2 = list;
            p.h(list2, "resultList");
            ConcurrentHashMap concurrentHashMap = this.twT.twQ;
            String str = this.hLl;
            if (concurrentHashMap == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
                AppMethodBeat.o(242573);
                throw tVar;
            }
            af.fd(concurrentHashMap).remove(str);
            kotlin.g.a.b bVar = this.twV;
            com.tencent.mm.plugin.finder.api.g gVar = (ah) j.kt(list2);
            if (gVar == null) {
                gVar = new com.tencent.mm.plugin.finder.api.g();
            }
            bVar.invoke(gVar);
            x xVar = x.SXb;
            AppMethodBeat.o(242573);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "resultList", "", "Lcom/tencent/mm/plugin/findersdk/api/ILocalFinderContact;", "invoke"})
    public static final class d extends q implements kotlin.g.a.b<List<? extends ah>, x> {
        final /* synthetic */ String hLl;
        final /* synthetic */ a twT;
        final /* synthetic */ kotlin.g.a.b twV;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(a aVar, String str, kotlin.g.a.b bVar) {
            super(1);
            this.twT = aVar;
            this.hLl = str;
            this.twV = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(List<? extends ah> list) {
            AppMethodBeat.i(242574);
            List<? extends ah> list2 = list;
            p.h(list2, "resultList");
            ConcurrentHashMap concurrentHashMap = this.twT.twQ;
            String str = this.hLl;
            if (concurrentHashMap == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
                AppMethodBeat.o(242574);
                throw tVar;
            }
            af.fd(concurrentHashMap).remove(str);
            kotlin.g.a.b bVar = this.twV;
            com.tencent.mm.plugin.finder.api.g gVar = (ah) j.kt(list2);
            if (gVar == null) {
                gVar = new com.tencent.mm.plugin.finder.api.g();
            }
            bVar.invoke(gVar);
            x xVar = x.SXb;
            AppMethodBeat.o(242574);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "back", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetContactListResp;", "kotlin.jvm.PlatformType", "call"})
    public static final class e<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ List pCW;
        final /* synthetic */ a twT;
        final /* synthetic */ kotlin.g.a.b twV;
        final /* synthetic */ LinkedList twW;

        e(a aVar, LinkedList linkedList, List list, kotlin.g.a.b bVar) {
            this.twT = aVar;
            this.twW = linkedList;
            this.pCW = list;
            this.twV = bVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:55:0x0198  */
        @Override // com.tencent.mm.vending.c.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ java.lang.Object call(java.lang.Object r12) {
            /*
            // Method dump skipped, instructions count: 479
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.cgi.fetcher.a.e.call(java.lang.Object):java.lang.Object");
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "back", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetContactListResp;", "kotlin.jvm.PlatformType", "call"})
    public static final class f<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ List pCW;
        final /* synthetic */ a twT;
        final /* synthetic */ kotlin.g.a.b twV;
        final /* synthetic */ LinkedList twW;

        f(a aVar, LinkedList linkedList, List list, kotlin.g.a.b bVar) {
            this.twT = aVar;
            this.twW = linkedList;
            this.pCW = list;
            this.twV = bVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:62:0x017f  */
        @Override // com.tencent.mm.vending.c.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ java.lang.Object call(java.lang.Object r9) {
            /*
            // Method dump skipped, instructions count: 455
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.cgi.fetcher.a.f.call(java.lang.Object):java.lang.Object");
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "back", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderGetContactListResp;", "kotlin.jvm.PlatformType", "call"})
    public static final class g<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ List pCW;
        final /* synthetic */ a twT;
        final /* synthetic */ kotlin.g.a.b twV;
        final /* synthetic */ LinkedList twW;

        public g(a aVar, LinkedList linkedList, List list, kotlin.g.a.b bVar) {
            this.twT = aVar;
            this.twW = linkedList;
            this.pCW = list;
            this.twV = bVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:62:0x017f  */
        @Override // com.tencent.mm.vending.c.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ java.lang.Object call(java.lang.Object r9) {
            /*
            // Method dump skipped, instructions count: 455
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.cgi.fetcher.a.g.call(java.lang.Object):java.lang.Object");
        }
    }

    public a() {
        AppMethodBeat.i(242583);
        AppMethodBeat.o(242583);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/fetcher/FinderContactFetcher$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.cgi.fetcher.a$a  reason: collision with other inner class name */
    public static final class C1091a {
        private C1091a() {
        }

        public /* synthetic */ C1091a(byte b2) {
            this();
        }
    }

    public final void b(List<String> list, kotlin.g.a.b<? super List<? extends ah>, x> bVar) {
        AppMethodBeat.i(242580);
        p.h(list, "reqList");
        p.h(bVar, "call");
        LinkedList linkedList = new LinkedList();
        ae.a aVar = ae.tue;
        p.h(list, "usernameList");
        ae aeVar = new ae();
        d.a aVar2 = new d.a();
        art art = new art();
        am amVar = am.tuw;
        art.LAI = am.cXY();
        art.LDj.addAll(list);
        art.LDk = 0;
        aVar2.c(art);
        aru aru = new aru();
        aru.setBaseResponse(new BaseResponse());
        aru.getBaseResponse().ErrMsg = new dqi();
        aVar2.d(aru);
        aVar2.MB("/cgi-bin/micromsg-bin/findergetcontactlist");
        aVar2.sG(3953);
        aeVar.c(aVar2.aXF());
        Log.i("Finder.CgiGetFinderContact", "[CgiGetFinderContact] username=".concat(String.valueOf(list)));
        aeVar.aYI().j(new e(this, linkedList, list, bVar));
        AppMethodBeat.o(242580);
    }

    public final void h(String str, kotlin.g.a.b<? super ah, x> bVar) {
        AppMethodBeat.i(242581);
        p.h(str, "req");
        p.h(bVar, "call");
        if (!this.twQ.containsKey(str)) {
            this.twQ.put(str, this);
            b(j.listOf(str), new b(this, str, bVar));
            AppMethodBeat.o(242581);
            return;
        }
        Log.w("Finder.ContactFetcher", "fetchContact[req] is loading. just return");
        AppMethodBeat.o(242581);
    }

    public final void a(aps aps, kotlin.g.a.b<? super ah, x> bVar) {
        String str;
        AppMethodBeat.i(242582);
        p.h(aps, "req");
        p.h(bVar, "call");
        String str2 = aps.LBC;
        ConcurrentHashMap<String, Object> concurrentHashMap = this.twQ;
        if (concurrentHashMap == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
            AppMethodBeat.o(242582);
            throw tVar;
        } else if (!concurrentHashMap.containsKey(str2)) {
            ConcurrentHashMap<String, Object> concurrentHashMap2 = this.twQ;
            if (str2 == null) {
                str = "";
            } else {
                str = str2;
            }
            concurrentHashMap2.put(str, this);
            List listOf = j.listOf(aps);
            c cVar = new c(this, str2, bVar);
            p.h(listOf, "reqList");
            p.h(cVar, "call");
            LinkedList linkedList = new LinkedList();
            ae.a aVar = ae.tue;
            ae.a.kZ(listOf).aYI().j(new f(this, linkedList, listOf, cVar));
            AppMethodBeat.o(242582);
        } else {
            Log.w("Finder.ContactFetcher", "fetchContact2[req] is loading. just return");
            AppMethodBeat.o(242582);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderMsgStrangerContactStorage;", "invoke"})
    static final class h extends q implements kotlin.g.a.a<ab> {
        public static final h twX = new h();

        static {
            AppMethodBeat.i(242579);
            AppMethodBeat.o(242579);
        }

        h() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ab invoke() {
            AppMethodBeat.i(242578);
            ab msgStrangerContactStorage = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getMsgStrangerContactStorage();
            AppMethodBeat.o(242578);
            return msgStrangerContactStorage;
        }
    }

    public static final /* synthetic */ ab a(a aVar) {
        AppMethodBeat.i(242585);
        ab abVar = (ab) aVar.twR.getValue();
        AppMethodBeat.o(242585);
        return abVar;
    }
}
