package com.tencent.mm.plugin.finder.cgi.interceptor;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.f;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.cgi.aa;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ai;
import com.tencent.mm.plugin.finder.model.bg;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.protocal.protobuf.bcw;
import com.tencent.mm.protocal.protobuf.bcx;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0004H\u0016J\u0018\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0004H\u0016¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/interceptor/HandleLayoutInfoInterceptor;", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "()V", "checkValid", "", "layoutInfo", "Lcom/tencent/mm/protocal/protobuf/FinderStreamLayoutInfo;", "rvFeedList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "tabType", "fakeData", "", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "handle", "loadedInfo", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "onIntercept", "", "onInterceptAfterStore", "onInterceptBeforeStore", "Companion", "plugin-finder_release"})
public final class d implements f {
    public static final a txC = new a((byte) 0);

    static {
        AppMethodBeat.i(242631);
        AppMethodBeat.o(242631);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/FinderStreamDivider;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b extends q implements kotlin.g.a.b<bcw, Boolean> {
        public static final b txD = new b();

        static {
            AppMethodBeat.i(242623);
            AppMethodBeat.o(242623);
        }

        b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(bcw bcw) {
            boolean z = true;
            AppMethodBeat.i(242622);
            bcw bcw2 = bcw;
            if (!(bcw2.LLE == 2 || bcw2.LLE == 1)) {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(242622);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke"})
    static final class c extends q implements kotlin.g.a.b<bo, Boolean> {
        public static final c txE = new c();

        static {
            AppMethodBeat.i(242625);
            AppMethodBeat.o(242625);
        }

        c() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(bo boVar) {
            AppMethodBeat.i(242624);
            bo boVar2 = boVar;
            p.h(boVar2, LocaleUtil.ITALIAN);
            Boolean valueOf = Boolean.valueOf(boVar2 instanceof bg);
            AppMethodBeat.o(242624);
            return valueOf;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/interceptor/HandleLayoutInfoInterceptor$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.finder.cgi.interceptor.f
    public final boolean a(aa.f fVar) {
        AppMethodBeat.i(242628);
        p.h(fVar, "resp");
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dtJ().value().intValue() > 0 && fVar.cXX().dLS == 1 && fVar.ttV > 0) {
            bcx bcx = new bcx();
            bcu bcu = new bcu();
            bcu.uOx = 111;
            bcu.uOm = false;
            bcu.LLO = "热门有更多推荐";
            bcu.IFO = "热门推荐";
            bcu.tQR = 0;
            bcu.object.addAll(fVar.object.subList(0, Math.min(fVar.object.size(), fVar.ttV)));
            bcx.LEy.add(bcu);
            LinkedList<Long> linkedList = bcx.LMe;
            List subList = fVar.object.subList(0, fVar.ttV);
            p.g(subList, "resp.`object`.subList(0, resp.streamSize)");
            List<FinderObject> list = subList;
            ArrayList arrayList = new ArrayList(j.a(list, 10));
            for (FinderObject finderObject : list) {
                arrayList.add(Long.valueOf(finderObject.id));
            }
            linkedList.addAll(arrayList);
            bcx.LMe.add(1, 111L);
            fVar.tUH = bcx;
        }
        AppMethodBeat.o(242628);
        return false;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.interceptor.f
    public final boolean b(com.tencent.mm.plugin.finder.feed.model.b bVar, int i2) {
        AppMethodBeat.i(242630);
        p.h(bVar, "loadedInfo");
        AppMethodBeat.o(242630);
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.finder.cgi.interceptor.d$d  reason: collision with other inner class name */
    static final class C1095d extends q implements kotlin.g.a.a<String> {
        final /* synthetic */ String txF;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1095d(String str) {
            super(0);
            this.txF = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ String invoke() {
            return this.txF;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends q implements kotlin.g.a.a<x> {
        public static final e txG = new e();

        static {
            AppMethodBeat.i(242627);
            AppMethodBeat.o(242627);
        }

        e() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(242626);
            Toast.makeText(MMApplicationContext.getContext(), "checkCount != streamList.size", 1).show();
            x xVar = x.SXb;
            AppMethodBeat.o(242626);
            return xVar;
        }
    }

    @Override // com.tencent.mm.plugin.finder.cgi.interceptor.f
    public final boolean a(com.tencent.mm.plugin.finder.feed.model.b bVar) {
        int i2;
        int i3;
        LinkedList linkedList;
        LinkedList linkedList2;
        boolean z;
        boolean z2;
        boolean z3;
        Object obj;
        int i4;
        T t;
        boolean z4;
        Object obj2;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        LinkedList<bcw> linkedList3;
        bcw bcw;
        AppMethodBeat.i(242629);
        p.h(bVar, "loadedInfo");
        bcx bcx = bVar.tUH;
        int i5 = bVar.dLS;
        if (y.a(y.vXH, i5, 0, 2)) {
            Integer valueOf = (bcx == null || (linkedList3 = bcx.LLI) == null || (bcw = (bcw) j.kt(linkedList3)) == null) ? null : Integer.valueOf(bcw.LLE);
            if (valueOf == null || valueOf.intValue() != 9) {
                i2 = -6;
            }
            i2 = 0;
        } else if (i5 != 1 && i5 != 3 && i5 != 2) {
            i2 = -5;
        } else if (bcx == null) {
            i2 = -1;
        } else if (bcx.LMe.isEmpty()) {
            i2 = -3;
        } else {
            if (bcx.LEy.isEmpty() && bcx.LLI.isEmpty()) {
                i2 = -4;
            }
            i2 = 0;
        }
        if (i2 < 0) {
            Log.w("Finder.HandleLayoutInfoInterceptor", "[handle] ret=".concat(String.valueOf(i2)));
        } else {
            bcx bcx2 = bVar.tUH;
            if (bcx2 == null) {
                p.hyc();
            }
            int i6 = 0;
            Iterator<bo> it = bVar.tUz.iterator();
            while (true) {
                if (!it.hasNext()) {
                    i3 = -1;
                    break;
                }
                if (it.next().lT() == bVar.ttW) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                if (z9) {
                    i3 = i6;
                    break;
                }
                i6++;
            }
            if (bVar.ttV > 0) {
                linkedList = new LinkedList(bVar.tUz.subList(0, bVar.ttV));
            } else {
                linkedList = new LinkedList();
            }
            if (bVar.ttV <= 0) {
                linkedList2 = new LinkedList(bVar.tUz);
            } else if (i3 >= 0) {
                linkedList2 = new LinkedList(bVar.tUz.subList(i3 + 1, bVar.tUz.size()));
            } else {
                linkedList2 = new LinkedList();
            }
            LinkedList linkedList4 = new LinkedList(bVar.tUz);
            LinkedList<bcu> linkedList5 = bcx2.LEy;
            p.g(linkedList5, "layoutInfo.card");
            ArrayList arrayList = new ArrayList();
            for (T t2 : linkedList5) {
                T t3 = t2;
                if (t3.tQR == 2 || t3.tQR == 0 || t3.tQR == 1) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (z8) {
                    arrayList.add(t2);
                }
            }
            ArrayList arrayList2 = arrayList;
            LinkedList<bcw> linkedList6 = bcx2.LLI;
            StringBuilder sb = new StringBuilder("[handle] dividerObjects=");
            p.g(linkedList6, "dividerObjects");
            LinkedList<bcw> linkedList7 = linkedList6;
            ArrayList arrayList3 = new ArrayList(j.a(linkedList7, 10));
            for (T t4 : linkedList7) {
                p.g(t4, LocaleUtil.ITALIAN);
                p.h(t4, "$this$print");
                arrayList3.add(t4.uOx + '_' + t4.LLE + '_' + t4.dQx);
            }
            StringBuilder append = sb.append(arrayList3).append(" cardObjects=");
            ArrayList<bcu> arrayList4 = arrayList2;
            ArrayList arrayList5 = new ArrayList(j.a(arrayList4, 10));
            for (bcu bcu : arrayList4) {
                p.g(bcu, LocaleUtil.ITALIAN);
                arrayList5.add(e.a(bcu));
            }
            Log.i("Finder.HandleLayoutInfoInterceptor", append.append(arrayList5).toString());
            int i7 = 0;
            Iterator<bcw> it2 = linkedList6.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    i7 = -1;
                    break;
                }
                bcw next = it2.next();
                if (next.LLE == 2 || next.LLE == 1) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z7) {
                    break;
                }
                i7++;
            }
            if (i7 >= 0) {
                z = true;
            } else {
                z = false;
            }
            if (z && linkedList2.isEmpty()) {
                j.c((List) linkedList6, (kotlin.g.a.b) b.txD);
                Log.e("Finder.HandleLayoutInfoInterceptor", "[handle] fallback remove history divider");
            }
            bVar.tUz.clear();
            LinkedList<Long> linkedList8 = bcx2.LMe;
            p.g(linkedList8, "layoutInfo.layoutIds");
            int i8 = 0;
            for (T t5 : linkedList8) {
                Iterator it3 = linkedList.iterator();
                while (true) {
                    if (it3.hasNext()) {
                        Object next2 = it3.next();
                        long lT = ((bo) next2).lT();
                        if (t5 != null && lT == t5.longValue()) {
                            z6 = true;
                            continue;
                        } else {
                            z6 = false;
                            continue;
                        }
                        if (z6) {
                            obj = next2;
                        }
                    } else {
                        obj = null;
                    }
                }
                bg bgVar = (bo) obj;
                if (bgVar == null) {
                    Iterator it4 = arrayList2.iterator();
                    while (true) {
                        if (it4.hasNext()) {
                            Object next3 = it4.next();
                            long j2 = ((bcu) next3).uOx;
                            if (t5 != null && j2 == t5.longValue()) {
                                z5 = true;
                                continue;
                            } else {
                                z5 = false;
                                continue;
                            }
                            if (z5) {
                                obj2 = next3;
                            }
                        } else {
                            obj2 = null;
                        }
                    }
                    bcu bcu2 = (bcu) obj2;
                    bgVar = bcu2 != null ? e.a(bcu2, bVar.dLS) : null;
                    i4 = i8;
                } else {
                    i4 = i8 + 1;
                }
                if (bgVar == null) {
                    Iterator<T> it5 = linkedList6.iterator();
                    while (true) {
                        if (it5.hasNext()) {
                            T next4 = it5.next();
                            long j3 = next4.uOx;
                            if (t5 != null && j3 == t5.longValue()) {
                                z4 = true;
                                continue;
                            } else {
                                z4 = false;
                                continue;
                            }
                            if (z4) {
                                t = next4;
                            }
                        } else {
                            t = null;
                        }
                    }
                    T t6 = t;
                    if (t6 != null) {
                        p.h(t6, "$this$toRVFeed");
                        switch (t6.LLE) {
                            case 1:
                            case 2:
                                bgVar = new ai(t6);
                                break;
                            case 9:
                                bgVar = new bg(t6);
                                break;
                            default:
                                bgVar = new com.tencent.mm.plugin.finder.feed.x(t6);
                                break;
                        }
                    } else {
                        bgVar = null;
                    }
                }
                if (bgVar == null) {
                    Log.e("Finder.HandleLayoutInfoInterceptor", "[handle] this id[" + ((Object) t5) + "] not match any.");
                    i8 = i4;
                } else {
                    bVar.tUz.add(bgVar);
                    i8 = i4;
                }
            }
            int i9 = 0;
            for (T t7 : bVar.tUz) {
                int i10 = i9 + 1;
                if (i9 < 0) {
                    j.hxH();
                }
                T t8 = t7;
                if ((t8 instanceof bg) && i9 + 1 < bVar.tUz.size()) {
                    bo boVar = bVar.tUz.get(i9 + 1);
                    p.g(boVar, "loadedInfo.incrementList[index + 1]");
                    bo boVar2 = boVar;
                    if (boVar2 instanceof BaseFinderFeed) {
                        ((BaseFinderFeed) boVar2).streamDivider = t8.tOP;
                        StringBuilder append2 = new StringBuilder("[handle] has divider ").append(t8.tOP.LLE).append(" wording=").append(t8.tOP.dQx).append(" nickname=");
                        g gVar = ((BaseFinderFeed) boVar2).contact;
                        Log.i("Finder.HandleLayoutInfoInterceptor", append2.append(gVar != null ? gVar.getNickname() : null).toString());
                    }
                }
                i9 = i10;
            }
            j.c((List) bVar.tUz, (kotlin.g.a.b) c.txE);
            if (i8 != linkedList.size()) {
                StringBuilder append3 = new StringBuilder("[handle] checkCount[").append(i8).append("] != streamList.size[").append(linkedList.size()).append("] rawObjects.size[").append(linkedList4.size()).append("] historyList.size[").append(linkedList2.size()).append(']');
                LinkedList<Long> linkedList9 = bcx2.LMe;
                p.g(linkedList9, "layoutInfo.layoutIds");
                LinkedList<Long> linkedList10 = linkedList9;
                ArrayList arrayList6 = new ArrayList(j.a(linkedList10, 10));
                for (T t9 : linkedList10) {
                    p.g(t9, LocaleUtil.ITALIAN);
                    arrayList6.add(com.tencent.mm.ac.d.zs(t9.longValue()));
                }
                StringBuilder append4 = append3.append(arrayList6).append(' ');
                LinkedList<bo> linkedList11 = linkedList;
                ArrayList arrayList7 = new ArrayList(j.a(linkedList11, 10));
                for (bo boVar3 : linkedList11) {
                    arrayList7.add(com.tencent.mm.ac.d.zs(boVar3.lT()));
                }
                StringBuilder append5 = append4.append(arrayList7).append('}');
                ArrayList arrayList8 = new ArrayList();
                for (Object obj3 : linkedList) {
                    bo boVar4 = (bo) obj3;
                    int i11 = 0;
                    Iterator<bo> it6 = bVar.tUz.iterator();
                    while (true) {
                        if (it6.hasNext()) {
                            if (it6.next().lT() == boVar4.lT()) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (!z3) {
                                i11++;
                            }
                        } else {
                            i11 = -1;
                        }
                    }
                    if (i11 < 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        arrayList8.add(obj3);
                    }
                }
                ArrayList<bo> arrayList9 = arrayList8;
                ArrayList arrayList10 = new ArrayList(j.a(arrayList9, 10));
                for (bo boVar5 : arrayList9) {
                    arrayList10.add(com.tencent.mm.ac.d.zs(boVar5.lT()));
                }
                String sb2 = append5.append(arrayList10).toString();
                Log.e("Finder.HandleLayoutInfoInterceptor", sb2);
                f.a.a(com.tencent.mm.plugin.finder.utils.c.vVc, "layoutIdError", new C1095d(sb2));
                if (BuildInfo.IS_FLAVOR_PURPLE) {
                    com.tencent.mm.ac.d.h(e.txG);
                }
                bVar.tUz.clear();
                bVar.tUz.addAll(linkedList4);
            } else {
                bVar.tUz.addAll(linkedList2);
            }
            Log.i("Finder.HandleLayoutInfoInterceptor", "[handle] checkCount[" + i8 + "] dividerCount[" + linkedList6.size() + "] cardCount[" + arrayList2.size() + "] streamCount=" + linkedList.size() + " historyCount=" + linkedList2.size() + " result=" + bVar.tUz.size() + " historyIndex=" + i3);
        }
        AppMethodBeat.o(242629);
        return false;
    }
}
