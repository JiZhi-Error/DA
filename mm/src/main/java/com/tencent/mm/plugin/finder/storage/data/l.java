package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aqq;
import com.tencent.mm.protocal.protobuf.arb;
import com.tencent.mm.protocal.protobuf.arl;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.e;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;

public final class l {
    private static boolean DEBUG;
    private static final int MAX_CACHE_SIZE = 20;
    private static final Integer[] vGr = {3, 0, 1, 2, 4, 5, 6, 9, 7, 8, 10, 11, 12, 13, 14};
    private static final Integer[] vGs = {0, 1, 2, 4, 5, 6, 9, 7, 8, 10};
    private static final Integer[] vGt = {11, 12, 13};
    private static final q vGu;
    private static q vGv;
    public static final a vGw = new a((byte) 0);

    public static final class a {

        /* renamed from: com.tencent.mm.plugin.finder.storage.data.l$a$a */
        public static final class C1286a extends q implements b<arl, Boolean> {
            final /* synthetic */ String uhS;
            final /* synthetic */ arl vGx;
            final /* synthetic */ LinkedList vGy;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1286a(String str, arl arl, LinkedList linkedList) {
                super(1);
                this.uhS = str;
                this.vGx = arl;
                this.vGy = linkedList;
            }

            @Override // kotlin.g.a.b
            public final /* synthetic */ Boolean invoke(arl arl) {
                boolean z;
                boolean z2;
                AppMethodBeat.i(167070);
                arl arl2 = arl;
                if (!p.j(this.uhS, arl2.username)) {
                    if (this.uhS.length() == 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (!z2 && !Util.isNullOrNil(arl2.username)) {
                        z = false;
                        Boolean valueOf = Boolean.valueOf(z);
                        AppMethodBeat.o(167070);
                        return valueOf;
                    }
                }
                z = true;
                Boolean valueOf2 = Boolean.valueOf(z);
                AppMethodBeat.o(167070);
                return valueOf2;
            }
        }

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(int i2, String str, LinkedList<s> linkedList) {
            AppMethodBeat.i(167073);
            p.h(str, ch.COL_USERNAME);
            p.h(linkedList, "list");
            if (e.contains(l.vGr, Integer.valueOf(i2))) {
                try {
                    arl arl = new arl();
                    LinkedList<aqq> linkedList2 = new LinkedList<>();
                    LinkedList<s> linkedList3 = linkedList;
                    ArrayList arrayList = new ArrayList(j.a(linkedList3, 10));
                    Iterator<T> it = linkedList3.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().vGD);
                    }
                    linkedList2.addAll(arrayList);
                    arl.gCs = linkedList2;
                    arl.username = str;
                    arl.iVn = System.currentTimeMillis();
                    a Lg = l.vGv.Lg(i2);
                    arb arb = Lg.vFP;
                    LinkedList<arl> linkedList4 = arb.zns;
                    p.g(linkedList4, "it.infoList");
                    d.a((LinkedList) linkedList4, (b) new C1286a(str, arl, linkedList));
                    while (true) {
                        int size = arb.zns.size();
                        a aVar = l.vGw;
                        if (size > l.MAX_CACHE_SIZE) {
                            LinkedList<arl> linkedList5 = arb.zns;
                            LinkedList<arl> linkedList6 = arb.zns;
                            p.g(linkedList6, "it.infoList");
                            linkedList5.remove(j.L(linkedList6, 0));
                        } else {
                            arb.zns.add(arl);
                            Log.i("Finder.FinderPage", "total cache username " + str + " list " + linkedList.size() + " totalCount: " + arb.zns.size());
                            a(Lg);
                            AppMethodBeat.o(167073);
                            return;
                        }
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("Finder.FinderPage", e2, "", new Object[0]);
                }
            }
            AppMethodBeat.o(167073);
        }

        private static a Le(int i2) {
            Integer num = null;
            AppMethodBeat.i(252011);
            try {
                StringBuilder sb = new StringBuilder();
                y yVar = y.vXH;
                String sb2 = sb.append(y.LA(2)).append('/').append(l.vGv.Lg(i2).name).append(".ext").toString();
                c cVar = new c("file2Cache");
                byte[] aW = s.aW(sb2, 0, -1);
                arb arb = new arb();
                try {
                    arb.parseFrom(aW);
                } catch (Exception e2) {
                    Log.printDebugStack("safeParser", "", e2);
                    arb = null;
                }
                arb arb2 = arb;
                StringBuilder append = new StringBuilder("file2Cache ").append(i2).append("  ");
                if (aW != null) {
                    num = Integer.valueOf(aW.length);
                }
                Log.i("Finder.FinderPage", append.append(num).append(' ').append(sb2).append(' ').append(cVar).toString());
                a Lg = l.vGv.Lg(i2);
                if (arb2 == null) {
                    arb2 = new arb();
                }
                Lg.a(arb2);
            } catch (Exception e3) {
                Log.printErrStackTrace("Finder.FinderPage", e3, "", new Object[0]);
            }
            l.vGv.Lg(i2).lNl = true;
            a Lg2 = l.vGv.Lg(i2);
            AppMethodBeat.o(252011);
            return Lg2;
        }

        private static LinkedList<bo> dE(String str, int i2) {
            Object obj;
            LinkedList<aqq> linkedList;
            LinkedList<aqq> linkedList2;
            u uVar;
            bo dyH;
            Integer num = null;
            AppMethodBeat.i(252012);
            arb arb = l.vGv.Lg(i2).vFP;
            LinkedList<bo> linkedList3 = new LinkedList<>();
            if (l.DEBUG) {
                Log.v("Finder.FinderPage", "-----file2Cache START------");
            }
            if (!(str.length() == 0)) {
                LinkedList<arl> linkedList4 = arb.zns;
                p.g(linkedList4, "cache.infoList");
                Iterator<T> it = linkedList4.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    T next = it.next();
                    if (p.j(next.username, str)) {
                        obj = next;
                        break;
                    }
                }
            } else {
                LinkedList<arl> linkedList5 = arb.zns;
                p.g(linkedList5, "cache.infoList");
                obj = j.L(linkedList5, 0);
            }
            arl arl = (arl) obj;
            a("cacheToRVFeedList", arl);
            if (!(arl == null || (linkedList2 = arl.gCs) == null)) {
                for (T t : linkedList2) {
                    int i3 = t.dataType;
                    i iVar = i.vGl;
                    if (i3 == 0) {
                        p.g(t, LocaleUtil.ITALIAN);
                        uVar = new r(t);
                    } else {
                        n nVar = n.vGA;
                        if (i3 == 1) {
                            p.g(t, LocaleUtil.ITALIAN);
                            uVar = new t(t);
                        } else {
                            p pVar = p.vGB;
                            if (i3 == 2) {
                                p.g(t, LocaleUtil.ITALIAN);
                                uVar = new u(t);
                            } else {
                                uVar = null;
                            }
                        }
                    }
                    if (!(uVar == null || (dyH = uVar.dyH()) == null)) {
                        linkedList3.add(dyH);
                    }
                }
            }
            StringBuilder append = new StringBuilder("read cache username:").append(str).append(" size:");
            if (!(arl == null || (linkedList = arl.gCs) == null)) {
                num = Integer.valueOf(linkedList.size());
            }
            Log.i("Finder.FinderPage", append.append(num).toString());
            if (l.DEBUG) {
                Log.v("Finder.FinderPage", "-----file2Cache END------");
            }
            AppMethodBeat.o(252012);
            return linkedList3;
        }

        private static LinkedList<FinderItem> dF(String str, int i2) {
            Object obj;
            LinkedList<aqq> linkedList;
            LinkedList<aqq> linkedList2;
            Integer num = null;
            AppMethodBeat.i(252013);
            arb arb = l.vGv.Lg(i2).vFP;
            LinkedList<FinderItem> linkedList3 = new LinkedList<>();
            if (l.DEBUG) {
                Log.v("Finder.FinderPage", "-----file2Cache START------");
            }
            if (!(str.length() == 0) && !p.j(str, z.aUg())) {
                LinkedList<arl> linkedList4 = arb.zns;
                p.g(linkedList4, "cache.infoList");
                Iterator<T> it = linkedList4.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    T next = it.next();
                    if (p.j(next.username, str)) {
                        obj = next;
                        break;
                    }
                }
            } else {
                LinkedList<arl> linkedList5 = arb.zns;
                p.g(linkedList5, "cache.infoList");
                obj = j.L(linkedList5, 0);
            }
            arl arl = (arl) obj;
            a("cacheToFinderItemList", arl);
            if (!(arl == null || (linkedList2 = arl.gCs) == null)) {
                for (T t : linkedList2) {
                    p.g(t, LocaleUtil.ITALIAN);
                    r rVar = new r(t);
                    i iVar = i.vGl;
                    FinderItem a2 = i.a(rVar.vGD);
                    if (a2 != null) {
                        linkedList3.add(a2);
                    }
                }
            }
            StringBuilder append = new StringBuilder("read cache username:").append(str).append(" size:");
            if (!(arl == null || (linkedList = arl.gCs) == null)) {
                num = Integer.valueOf(linkedList.size());
            }
            Log.i("Finder.FinderPage", append.append(num).toString());
            if (l.DEBUG) {
                Log.v("Finder.FinderPage", "-----file2Cache END------");
            }
            AppMethodBeat.o(252013);
            return linkedList3;
        }

        public static LinkedList<com.tencent.mm.plugin.finder.model.c> avF(String str) {
            Object obj;
            LinkedList<aqq> linkedList;
            LinkedList<aqq> linkedList2;
            Integer num = null;
            AppMethodBeat.i(252014);
            arb arb = l.vGv.Lg(9).vFP;
            LinkedList<com.tencent.mm.plugin.finder.model.c> linkedList3 = new LinkedList<>();
            if (l.DEBUG) {
                Log.v("Finder.FinderPage", "-----file2Cache START------");
            }
            if (!(str.length() == 0) && !p.j(str, z.aUg())) {
                LinkedList<arl> linkedList4 = arb.zns;
                p.g(linkedList4, "cache.infoList");
                Iterator<T> it = linkedList4.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    T next = it.next();
                    if (p.j(next.username, str)) {
                        obj = next;
                        break;
                    }
                }
            } else {
                LinkedList<arl> linkedList5 = arb.zns;
                p.g(linkedList5, "cache.infoList");
                obj = j.L(linkedList5, 0);
            }
            arl arl = (arl) obj;
            if (!(arl == null || (linkedList2 = arl.gCs) == null)) {
                for (T t : linkedList2) {
                    p.g(t, LocaleUtil.ITALIAN);
                    t tVar = new t(t);
                    n nVar = n.vGA;
                    com.tencent.mm.plugin.finder.model.c b2 = n.b(tVar.vGD);
                    if (b2 != null) {
                        linkedList3.add(b2);
                    }
                }
            }
            StringBuilder append = new StringBuilder("read cache username:").append(str).append(" size:");
            if (!(arl == null || (linkedList = arl.gCs) == null)) {
                num = Integer.valueOf(linkedList.size());
            }
            Log.i("Finder.FinderPage", append.append(num).toString());
            if (l.DEBUG) {
                Log.v("Finder.FinderPage", "-----file2Cache END------");
            }
            AppMethodBeat.o(252014);
            return linkedList3;
        }

        public static void p(FinderItem finderItem) {
            AppMethodBeat.i(167077);
            p.h(finderItem, "item");
            if (l.vGv.Lg(7).lNl) {
                LinkedList<arl> linkedList = l.vGv.Lg(7).vFP.zns;
                p.g(linkedList, "cache[ConstantsFinder.Lo…INE_FOLLOW].page.infoList");
                arl arl = (arl) j.L(linkedList, 0);
                if (arl != null) {
                    arl.gCs.addFirst(new r(2, finderItem.getLocalId(), finderItem.getFeedObject(), 7).vGD);
                    AppMethodBeat.o(167077);
                    return;
                }
            }
            AppMethodBeat.o(167077);
        }

        public static void c(long j2, FinderItem finderItem) {
            arl arl;
            LinkedList<aqq> linkedList;
            AppMethodBeat.i(167078);
            for (Integer num : l.vGs) {
                int intValue = num.intValue();
                a aVar = l.vGw;
                Lf(intValue);
                LinkedList<arl> linkedList2 = l.vGv.Lg(intValue).vFP.zns;
                if (!(linkedList2 == null || (arl = (arl) j.L(linkedList2, 0)) == null || (linkedList = arl.gCs) == null)) {
                    i iVar = i.vGl;
                    if (i.a(j2, finderItem, linkedList)) {
                        a aVar2 = l.vGw;
                        a(l.vGv.Lg(intValue));
                    }
                }
            }
            AppMethodBeat.o(167078);
        }

        public static void L(long j2, int i2) {
            arl arl;
            LinkedList<aqq> linkedList;
            AppMethodBeat.i(252015);
            Lf(i2);
            LinkedList<arl> linkedList2 = l.vGv.Lg(i2).vFP.zns;
            if (linkedList2 == null || (arl = (arl) j.L(linkedList2, 0)) == null || (linkedList = arl.gCs) == null) {
                AppMethodBeat.o(252015);
                return;
            }
            i iVar = i.vGl;
            if (i.a(j2, linkedList)) {
                a aVar = l.vGw;
                a(l.vGv.Lg(i2));
            }
            AppMethodBeat.o(252015);
        }

        public static void M(long j2, int i2) {
            arl arl;
            LinkedList<aqq> linkedList;
            AppMethodBeat.i(252016);
            Lf(i2);
            LinkedList<arl> linkedList2 = l.vGv.Lg(i2).vFP.zns;
            if (linkedList2 == null || (arl = (arl) j.L(linkedList2, 0)) == null || (linkedList = arl.gCs) == null) {
                AppMethodBeat.o(252016);
                return;
            }
            p pVar = p.vGB;
            if (p.a(j2, linkedList)) {
                a aVar = l.vGw;
                a(l.vGv.Lg(i2));
            }
            AppMethodBeat.o(252016);
        }

        public static void FP(long j2) {
            AppMethodBeat.i(252017);
            for (Integer num : l.vGt) {
                int intValue = num.intValue();
                a aVar = l.vGw;
                M(j2, intValue);
            }
            AppMethodBeat.o(252017);
        }

        public static void FQ(long j2) {
            arl arl;
            LinkedList<aqq> linkedList;
            AppMethodBeat.i(167079);
            for (Integer num : l.vGs) {
                int intValue = num.intValue();
                a aVar = l.vGw;
                Lf(intValue);
                LinkedList<arl> linkedList2 = l.vGv.Lg(intValue).vFP.zns;
                if (!(linkedList2 == null || (arl = (arl) j.L(linkedList2, 0)) == null || (linkedList = arl.gCs) == null)) {
                    i iVar = i.vGl;
                    if (i.b(j2, linkedList)) {
                        a aVar2 = l.vGw;
                        a(l.vGv.Lg(intValue));
                    }
                }
            }
            AppMethodBeat.o(167079);
        }

        public static a Lf(int i2) {
            AppMethodBeat.i(252018);
            if (l.vGv.Lg(i2).lNl) {
                a Lg = l.vGv.Lg(i2);
                AppMethodBeat.o(252018);
                return Lg;
            }
            l.vGv.a(i2, Le(i2));
            a Lg2 = l.vGv.Lg(i2);
            AppMethodBeat.o(252018);
            return Lg2;
        }

        public static /* synthetic */ List a(a aVar, int i2) {
            AppMethodBeat.i(252020);
            List<bo> bc = aVar.bc(i2, "");
            AppMethodBeat.o(252020);
            return bc;
        }

        public final List<bo> bc(int i2, String str) {
            AppMethodBeat.i(252019);
            p.h(str, ch.COL_USERNAME);
            Lf(i2);
            LinkedList<bo> dE = dE(str, i2);
            AppMethodBeat.o(252019);
            return dE;
        }

        public final List<FinderItem> dG(String str, int i2) {
            AppMethodBeat.i(252021);
            p.h(str, ch.COL_USERNAME);
            Lf(i2);
            LinkedList<FinderItem> dF = dF(str, i2);
            AppMethodBeat.o(252021);
            return dF;
        }

        public static void clearAll() {
            AppMethodBeat.i(167082);
            y yVar = y.vXH;
            String dCD = y.dCD();
            if (s.YS(dCD)) {
                s.deleteDir(dCD);
                s.boN(dCD);
                Log.i("Finder.FinderPage", "del " + dCD + " and ret " + s.YS(dCD));
            }
            l.vGv = l.vGu;
            l.vGv.reset();
            Log.i("Finder.FinderPage", "clearAll " + l.vGv + ' ' + l.vGv.vGC.length);
            AppMethodBeat.o(167082);
        }

        public static void a(a aVar) {
            AppMethodBeat.i(252010);
            try {
                byte[] byteArray = aVar.vFP.toByteArray();
                c cVar = new c("cache2File");
                y yVar = y.vXH;
                o oVar = new o(y.LA(2));
                if (!oVar.isDirectory()) {
                    oVar.delete();
                }
                if (!oVar.exists()) {
                    oVar.mkdirs();
                }
                String str = oVar.getAbsolutePath() + '/' + aVar.name + ".ext";
                s.C(str, byteArray);
                Log.i("Finder.FinderPage", "cache2File " + aVar.name + ' ' + byteArray.length + ' ' + str + ' ' + cVar);
                AppMethodBeat.o(252010);
            } catch (Exception e2) {
                Log.printErrStackTrace("Finder.FinderPage", e2, "", new Object[0]);
                AppMethodBeat.o(252010);
            }
        }

        private static void a(String str, arl arl) {
            boolean z;
            ArrayList arrayList;
            LinkedList<aqq> linkedList;
            String str2;
            String str3;
            FinderContact finderContact;
            FinderObjectDesc finderObjectDesc;
            awe awe;
            awe awe2;
            AppMethodBeat.i(252022);
            long currentTimeMillis = System.currentTimeMillis() - (arl != null ? arl.iVn : 0);
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (currentTimeMillis > ((long) (com.tencent.mm.plugin.finder.storage.c.dvs().value().intValue() * 60000))) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                if (arl == null || (linkedList = arl.gCs) == null) {
                    arrayList = null;
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    for (T t : linkedList) {
                        T t2 = t;
                        FinderObject finderObject = t2.LCD;
                        boolean z2 = ((finderObject == null || (awe2 = finderObject.liveInfo) == null) ? null : Long.valueOf(awe2.liveId)) != null;
                        if (z2) {
                            StringBuilder append = new StringBuilder().append(str).append(" filter live:");
                            FinderObject finderObject2 = t2.LCD;
                            StringBuilder append2 = append.append((finderObject2 == null || (awe = finderObject2.liveInfo) == null) ? null : Long.valueOf(awe.liveId)).append(',');
                            FinderObject finderObject3 = t2.LCD;
                            if (finderObject3 == null || (finderObjectDesc = finderObject3.objectDesc) == null) {
                                str2 = null;
                            } else {
                                str2 = finderObjectDesc.description;
                            }
                            StringBuilder append3 = append2.append(str2).append(',');
                            FinderObject finderObject4 = t2.LCD;
                            if (finderObject4 == null || (finderContact = finderObject4.contact) == null) {
                                str3 = null;
                            } else {
                                str3 = finderContact.nickname;
                            }
                            Log.i("Finder.FinderPage", append3.append(str3).toString());
                        }
                        if (!z2) {
                            arrayList2.add(t);
                        }
                    }
                    arrayList = arrayList2;
                }
                if (arl != null) {
                    arl.gCs = new LinkedList<>(arrayList);
                    AppMethodBeat.o(252022);
                    return;
                }
            }
            AppMethodBeat.o(252022);
        }
    }

    static {
        AppMethodBeat.i(167083);
        q qVar = new q(new a[]{new a(0, "main_v3", new arb(), (byte) 0), new a(1, "profile_v3", new arb(), (byte) 0), new a(2, "like_v3", new arb(), (byte) 0), new a(3, "others_v3", new arb(), (byte) 0), new a(4, "prefetch_v3", new arb(), (byte) 0), new a(5, "friend_tab_v3", new arb(), (byte) 0), new a(6, "lbs_tab_v3", new arb(), (byte) 0), new a(7, "follow_v3", new arb(), (byte) 0), new a(8, "machine_v3", new arb(), (byte) 0), new a(9, "lbs_tab_section_v3", new arb(), (byte) 0), new a(10, "fav_v3", new arb(), (byte) 0), new a(11, "mega_video_like_v3", new arb(), (byte) 0), new a(12, "mega_video_fav_v3", new arb(), (byte) 0), new a(13, "mega_video_profile_v3", new arb(), (byte) 0), new a(14, "profile_at_feed_v3", new arb(), (byte) 0), new a(15, "nearby_live_v3", new arb(), (byte) 0), new a(16, "nearby_live_more_v3", new arb(), (byte) 0)});
        vGu = qVar;
        vGv = qVar;
        AppMethodBeat.o(167083);
    }
}
