package com.tencent.mm.plugin.appbrand.config;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.m;
import com.tencent.mm.ak.ab;
import com.tencent.mm.ak.c;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.predownload.e.g;
import com.tencent.mm.plugin.appbrand.config.o;
import com.tencent.mm.plugin.appbrand.utils.ag;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.fcu;
import com.tencent.mm.protocal.protobuf.fcv;
import com.tencent.mm.protocal.protobuf.lm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.as;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.d;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class aa {

    /* access modifiers changed from: package-private */
    public interface a<T> {
        p XF(String str);

        T XG(String str);

        boolean cy(T t);

        String getUsername();
    }

    public interface c {
        String aiv();

        acc bAl();
    }

    public interface d {
        void done();
    }

    public interface e extends d {
        void bj(List<String> list);
    }

    public interface f {
        void bAm();
    }

    public static int bAk() {
        AppMethodBeat.i(226493);
        int i2 = h.aqJ().getInt("MMBizAttrSyncFreq", LocalCache.TIME_HOUR);
        AppMethodBeat.o(226493);
        return i2;
    }

    private static boolean a(String str, o.a aVar) {
        WxaAttributes d2;
        AppMethodBeat.i(226494);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(226494);
            return false;
        } else if (!XB(str)) {
            AppMethodBeat.o(226494);
            return false;
        } else {
            g VG = ((com.tencent.mm.plugin.appbrand.appcache.predownload.e.h) n.W(com.tencent.mm.plugin.appbrand.appcache.predownload.e.h.class)).VG(str);
            if (VG == null || (d2 = n.buC().d(str, "versionInfo")) == null || d2.bAp() == null || d2.bAp().cyu != 0 || VG.field_appVersion > d2.bAp().appVersion) {
                AppMethodBeat.o(226494);
                return true;
            }
            Log.w("MicroMsg.WxaAttrSyncHelper", "needUpdateAttrWithUsernameForBatchPreload, username(%s) scene(%s) notifyVersion(%d) appVersion(%d) return false", str, aVar.name(), Integer.valueOf(VG.field_appVersion), Integer.valueOf(d2.bAp().appVersion));
            AppMethodBeat.o(226494);
            return false;
        }
    }

    public static boolean XB(String str) {
        AppMethodBeat.i(44926);
        if (n.buC() == null) {
            Log.w("MicroMsg.WxaAttrSyncHelper", "needUpdateAttr(%s), storage NULL", str);
            AppMethodBeat.o(44926);
            return false;
        }
        long nowSecond = Util.nowSecond();
        long Xo = n.buC().Xo(str);
        int bAk = bAk();
        if (Log.getLogLevel() <= 0) {
            Log.v("MicroMsg.WxaAttrSyncHelper", "needUpdateAttr, username(%s), currentMS(%d), lastUpdateTime(%d), freq(%d).", str, Long.valueOf(nowSecond), Long.valueOf(Xo), Integer.valueOf(bAk));
        }
        if (nowSecond - Xo >= ((long) bAk) || Xo > nowSecond + ((long) bAk)) {
            AppMethodBeat.o(44926);
            return true;
        }
        AppMethodBeat.o(44926);
        return false;
    }

    private static boolean XC(String str) {
        AppMethodBeat.i(44927);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(44927);
            return false;
        } else if (!m.HF(str)) {
            Log.e("MicroMsg.WxaAttrSyncHelper", "checkLogIfInvalidUsername %s, %s", str, MMStack.stackTraceToString(new Throwable()));
            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(com.tencent.mm.plugin.appbrand.jsapi.ui.launcher.a.CTRL_INDEX, 1);
            AppMethodBeat.o(44927);
            return true;
        } else {
            AppMethodBeat.o(44927);
            return false;
        }
    }

    public static void XD(final String str) {
        AppMethodBeat.i(44928);
        if (XC(str)) {
            AppMethodBeat.o(44928);
            return;
        }
        com.tencent.f.h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.config.aa.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(44910);
                aa.XE(str);
                AppMethodBeat.o(44910);
            }
        });
        AppMethodBeat.o(44928);
    }

    public static Pair<WxaAttributes, c.a<fcv>> a(final String str, boolean z, f fVar, final c cVar) {
        AppMethodBeat.i(226495);
        Pair<WxaAttributes, c.a<fcv>> a2 = a(str, z, fVar, new a<WxaAttributes>() {
            /* class com.tencent.mm.plugin.appbrand.config.aa.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.plugin.appbrand.config.aa.a
            public final /* synthetic */ boolean cy(WxaAttributes wxaAttributes) {
                AppMethodBeat.i(226478);
                boolean isNullOrNil = Util.isNullOrNil(wxaAttributes.field_versionInfo);
                AppMethodBeat.o(226478);
                return isNullOrNil;
            }

            @Override // com.tencent.mm.plugin.appbrand.config.aa.a
            public final String getUsername() {
                AppMethodBeat.i(226476);
                String Xy = y.Xy(str);
                AppMethodBeat.o(226476);
                return Xy;
            }

            @Override // com.tencent.mm.plugin.appbrand.config.aa.a
            public final p XF(String str) {
                AppMethodBeat.i(226477);
                if (cVar != null) {
                    p pVar = new p(null, str, cVar.aiv(), cVar.bAl());
                    AppMethodBeat.o(226477);
                    return pVar;
                }
                p pVar2 = new p(null, str);
                AppMethodBeat.o(226477);
                return pVar2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.plugin.appbrand.config.aa.a
            public final /* synthetic */ WxaAttributes XG(String str) {
                AppMethodBeat.i(226479);
                WxaAttributes e2 = n.buC().e(str, new String[0]);
                AppMethodBeat.o(226479);
                return e2;
            }
        }, null);
        AppMethodBeat.o(226495);
        return a2;
    }

    static <T> Pair<T, c.a<fcv>> a(String str, boolean z, f fVar, a<T> aVar, PBool pBool) {
        T t;
        T t2;
        T t3;
        String str2;
        c.a aVar2 = null;
        AppMethodBeat.i(226496);
        if (Util.isNullOrNil(str) || !com.tencent.mm.kernel.g.aAf().hpY) {
            Pair<T, c.a<fcv>> create = Pair.create(null, null);
            AppMethodBeat.o(226496);
            return create;
        }
        if (!z) {
            t2 = aVar.XG(str);
            if (t2 == null || aVar.cy(t2)) {
                t = t2;
            } else {
                Log.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, no need cgi sync, key:%s", Boolean.valueOf(z), str);
                cx(t2);
                Pair<T, c.a<fcv>> create2 = Pair.create(t2, aVar2);
                AppMethodBeat.o(226496);
                return create2;
            }
        } else {
            t = null;
        }
        if (fVar != null) {
            fVar.bAm();
        }
        c.a bNV = aVar.XF(str).bNV();
        if (bNV == null || (bNV instanceof ab.a) || bNV.errType != 0 || bNV.errCode != 0) {
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = Integer.valueOf(bNV == null ? -1 : bNV.errType);
            objArr[2] = Integer.valueOf(bNV == null ? -1 : bNV.errCode);
            objArr[3] = bNV == null ? "null resp" : bNV.errMsg;
            Log.e("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, errType = %d, errCode = %d, errMsg = %s", objArr);
            if (t == null) {
                t3 = aVar.XG(str);
                if (t3 == null) {
                    Pair<T, c.a<fcv>> create3 = Pair.create(null, bNV);
                    AppMethodBeat.o(226496);
                    return create3;
                }
            } else {
                t3 = t;
            }
            Pair<T, c.a<fcv>> create4 = Pair.create(t3, bNV);
            AppMethodBeat.o(226496);
            return create4;
        }
        Iterator<fcu> it = ((fcv) bNV.iLC).KSX.iterator();
        while (true) {
            if (!it.hasNext()) {
                str2 = null;
                break;
            }
            fcu next = it.next();
            if ("UserName".equalsIgnoreCase(next.xMX)) {
                str2 = next.Cyk;
                if (!str2.endsWith("@app")) {
                    str2 = str2 + "@app";
                }
            }
        }
        if (Util.isNullOrNil(str2)) {
            str2 = aVar.getUsername();
            if (Util.isNullOrNil(str2)) {
                Log.e("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, key %s, cgi sync fail username invalid", Boolean.valueOf(z), str);
                Pair<T, c.a<fcv>> create5 = Pair.create(null, null);
                AppMethodBeat.o(226496);
                return create5;
            }
        }
        Log.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync key(%s), username(%s), flushAttrs", str, str2);
        if (n.buC().a(str2, ((fcv) bNV.iLC).KSW, ((fcv) bNV.iLC).KSX)) {
            y.bAj().doNotify(MStorageEventData.EventType.SINGLE, 3, str2);
            if (pBool != null) {
                pBool.value = true;
            }
        }
        t2 = aVar.XG(str);
        Log.i("MicroMsg.WxaAttrSyncHelper", "loadOrSync, ignoreLocal %b, cgi sync result, key:%s", Boolean.valueOf(z), str);
        cx(t2);
        aVar2 = bNV;
        Pair<T, c.a<fcv>> create22 = Pair.create(t2, aVar2);
        AppMethodBeat.o(226496);
        return create22;
    }

    private static <T> void cx(T t) {
        AppMethodBeat.i(226497);
        if (t instanceof WxaAttributes) {
            t.bAs();
            AppMethodBeat.o(226497);
            return;
        }
        Log.i("MicroMsg.WxaAttrSyncHelper", "printContact %s", t);
        AppMethodBeat.o(226497);
    }

    public static Pair<WxaAttributes, c.a<fcv>> b(final String str, boolean z, f fVar, final c cVar) {
        AppMethodBeat.i(226498);
        if (XC(str)) {
            Pair<WxaAttributes, c.a<fcv>> pair = new Pair<>(null, null);
            AppMethodBeat.o(226498);
            return pair;
        }
        Pair<WxaAttributes, c.a<fcv>> a2 = a(str, z, fVar, new a<WxaAttributes>() {
            /* class com.tencent.mm.plugin.appbrand.config.aa.AnonymousClass3 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.plugin.appbrand.config.aa.a
            public final /* synthetic */ boolean cy(WxaAttributes wxaAttributes) {
                AppMethodBeat.i(44914);
                boolean isNullOrNil = Util.isNullOrNil(wxaAttributes.field_versionInfo);
                AppMethodBeat.o(44914);
                return isNullOrNil;
            }

            @Override // com.tencent.mm.plugin.appbrand.config.aa.a
            public final String getUsername() {
                AppMethodBeat.i(44912);
                String str = str;
                AppMethodBeat.o(44912);
                return str;
            }

            @Override // com.tencent.mm.plugin.appbrand.config.aa.a
            public final p XF(String str) {
                AppMethodBeat.i(44913);
                if (cVar != null) {
                    p pVar = new p(str, null, cVar.aiv(), cVar.bAl());
                    AppMethodBeat.o(44913);
                    return pVar;
                }
                p pVar2 = new p(str, null);
                AppMethodBeat.o(44913);
                return pVar2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.plugin.appbrand.config.aa.a
            public final /* synthetic */ WxaAttributes XG(String str) {
                AppMethodBeat.i(44915);
                WxaAttributes d2 = n.buC().d(str, new String[0]);
                AppMethodBeat.o(44915);
                return d2;
            }
        }, null);
        AppMethodBeat.o(226498);
        return a2;
    }

    public static void a(String str, b<WxaAttributes> bVar) {
        AppMethodBeat.i(226499);
        a(str, true, bVar);
        AppMethodBeat.o(226499);
    }

    public static void a(final String str, final boolean z, final b<WxaAttributes> bVar) {
        AppMethodBeat.i(226500);
        if (XC(str)) {
            AppMethodBeat.o(226500);
            return;
        }
        com.tencent.f.h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.config.aa.AnonymousClass4 */

            public final void run() {
                boolean z;
                b.a aVar;
                AppMethodBeat.i(226483);
                PBool pBool = new PBool();
                String str = str;
                if (!z || !aa.XB(str)) {
                    z = false;
                } else {
                    z = true;
                }
                Pair a2 = aa.a(str, z, null, new a<WxaAttributes>() {
                    /* class com.tencent.mm.plugin.appbrand.config.aa.AnonymousClass4.AnonymousClass1 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.tencent.mm.plugin.appbrand.config.aa.a
                    public final /* synthetic */ boolean cy(WxaAttributes wxaAttributes) {
                        AppMethodBeat.i(226481);
                        boolean isNullOrNil = Util.isNullOrNil(wxaAttributes.field_versionInfo);
                        AppMethodBeat.o(226481);
                        return isNullOrNil;
                    }

                    @Override // com.tencent.mm.plugin.appbrand.config.aa.a
                    public final String getUsername() {
                        return str;
                    }

                    @Override // com.tencent.mm.plugin.appbrand.config.aa.a
                    public final p XF(String str) {
                        AppMethodBeat.i(226480);
                        p pVar = new p(str, null);
                        AppMethodBeat.o(226480);
                        return pVar;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // com.tencent.mm.plugin.appbrand.config.aa.a
                    public final /* synthetic */ WxaAttributes XG(String str) {
                        AppMethodBeat.i(226482);
                        WxaAttributes d2 = n.buC().d(str, new String[0]);
                        AppMethodBeat.o(226482);
                        return d2;
                    }
                }, pBool);
                if (bVar != null) {
                    if (a2.second == null) {
                        aVar = b.a.RET_HIT_FREQUENCY_LIMIT;
                    } else if (((c.a) a2.second).errType != 0 || ((c.a) a2.second).errCode != 0) {
                        aVar = b.a.RET_CGI_FAIL;
                    } else if (pBool.value) {
                        aVar = b.a.RET_UPDATED;
                    } else {
                        aVar = b.a.RET_NO_UPDATE;
                    }
                    bVar.a(aVar, a2.first);
                }
                AppMethodBeat.o(226483);
            }
        });
        AppMethodBeat.o(226500);
    }

    public static void XE(String str) {
        AppMethodBeat.i(44933);
        if (XC(str)) {
            AppMethodBeat.o(44933);
            return;
        }
        if (XB(str)) {
            b(str, true, null, null);
        }
        AppMethodBeat.o(44933);
    }

    public static com.tencent.mm.vending.g.e<List<String>> b(List<String> list, o.a aVar) {
        AppMethodBeat.i(261629);
        com.tencent.mm.vending.g.e<List<String>> a2 = a(list, aVar, (d) null);
        AppMethodBeat.o(261629);
        return a2;
    }

    public static com.tencent.mm.vending.g.e<List<String>> a(final List<String> list, final o.a aVar, final d dVar) {
        int i2 = 0;
        AppMethodBeat.i(226502);
        Log.i("MicroMsg.WxaAttrSyncHelper", "batchSync before real logic, list_size:%d, scene:%d", Integer.valueOf(list.size()), Integer.valueOf(aVar.intValue));
        if (Util.isNullOrNil(list)) {
            com.tencent.mm.co.f ey = com.tencent.mm.co.g.ey(Collections.emptyList());
            AppMethodBeat.o(226502);
            return ey;
        } else if (ag.LB()) {
            com.tencent.mm.co.f<_Ret> j2 = com.tencent.mm.co.g.hio().j(new com.tencent.mm.vending.c.a<List<String>, Void>() {
                /* class com.tencent.mm.plugin.appbrand.config.aa.AnonymousClass5 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.vending.c.a
                public final /* synthetic */ List<String> call(Void r5) {
                    AppMethodBeat.i(226484);
                    com.tencent.mm.vending.g.g.a(aa.a(list, aVar, dVar));
                    AppMethodBeat.o(226484);
                    return null;
                }
            });
            AppMethodBeat.o(226502);
            return j2;
        } else {
            if (!(list instanceof ArrayList) && !(list instanceof LinkedList)) {
                list = new LinkedList(list);
            }
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (TextUtils.isEmpty(next) || !as.HF(next)) {
                    it.remove();
                } else if (org.apache.commons.b.a.contains(com.tencent.mm.plugin.appbrand.appcache.predownload.h.kPj, aVar)) {
                    if (!a(next, aVar)) {
                        it.remove();
                    }
                } else if (!XB(next)) {
                    it.remove();
                }
            }
            if (Util.isNullOrNil(list)) {
                if (dVar != null) {
                    dVar.done();
                }
                com.tencent.mm.co.f ey2 = com.tencent.mm.co.g.ey(Collections.emptyList());
                AppMethodBeat.o(226502);
                return ey2;
            }
            Log.i("MicroMsg.WxaAttrSyncHelper", "batchSync, list_size %d, scene %s(%d)", Integer.valueOf(list.size()), aVar.name(), Integer.valueOf(aVar.intValue));
            final LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < list.size() / 20; i3++) {
                int i4 = i3 * 20;
                i2 = i4 + 20;
                linkedList.add(c(list.subList(i4, i2), aVar));
            }
            if (i2 < list.size()) {
                linkedList.add(c(list.subList(i2, list.size()), aVar));
            }
            if (dVar instanceof e) {
                ((e) dVar).bj(list);
            }
            com.tencent.mm.co.f c2 = com.tencent.mm.co.g.c(new c.a<List<String>>() {
                /* class com.tencent.mm.plugin.appbrand.config.aa.AnonymousClass6 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // com.tencent.mm.vending.g.c.a
                public final /* synthetic */ List<String> call() {
                    AppMethodBeat.i(226488);
                    final com.tencent.mm.vending.g.b hdH = com.tencent.mm.vending.g.g.hdH();
                    final ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
                    final AtomicInteger atomicInteger = new AtomicInteger(linkedList.size());
                    final AnonymousClass1 r3 = new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.config.aa.AnonymousClass6.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(226485);
                            if (atomicInteger.getAndDecrement() == 1) {
                                Log.i("MicroMsg.WxaAttrSyncHelper", "batchSync callback list_size:%d, updated_size:%d, scene:%d", Integer.valueOf(list.size()), Integer.valueOf(concurrentLinkedQueue.size()), Integer.valueOf(aVar.intValue));
                                hdH.G(new LinkedList(concurrentLinkedQueue));
                                if (dVar != null) {
                                    dVar.done();
                                }
                            }
                            AppMethodBeat.o(226485);
                        }
                    };
                    for (com.tencent.mm.vending.g.e eVar : linkedList) {
                        eVar.a(new d.b<List<String>>() {
                            /* class com.tencent.mm.plugin.appbrand.config.aa.AnonymousClass6.AnonymousClass3 */

                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                            @Override // com.tencent.mm.vending.g.d.b
                            public final /* synthetic */ void bz(List<String> list) {
                                AppMethodBeat.i(226487);
                                concurrentLinkedQueue.addAll(list);
                                r3.run();
                                AppMethodBeat.o(226487);
                            }
                        }).a(new d.a() {
                            /* class com.tencent.mm.plugin.appbrand.config.aa.AnonymousClass6.AnonymousClass2 */

                            @Override // com.tencent.mm.vending.g.d.a
                            public final void cn(Object obj) {
                                AppMethodBeat.i(226486);
                                r3.run();
                                AppMethodBeat.o(226486);
                            }
                        });
                    }
                    AppMethodBeat.o(226488);
                    return null;
                }
            });
            AppMethodBeat.o(226502);
            return c2;
        }
    }

    private static com.tencent.mm.vending.g.e<List<String>> c(final List<String> list, o.a aVar) {
        AppMethodBeat.i(226503);
        if (Util.isNullOrNil(list)) {
            com.tencent.mm.co.f ey = com.tencent.mm.co.g.ey(Collections.emptyList());
            AppMethodBeat.o(226503);
            return ey;
        }
        com.tencent.mm.co.f i2 = new o(list, aVar).aYI().i(new com.tencent.mm.vending.c.a<List<String>, c.a<lm>>() {
            /* class com.tencent.mm.plugin.appbrand.config.aa.AnonymousClass7 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ List<String> call(c.a<lm> aVar) {
                AppMethodBeat.i(44925);
                List<String> c2 = c(aVar);
                AppMethodBeat.o(44925);
                return c2;
            }

            private List<String> c(c.a<lm> aVar) {
                AppMethodBeat.i(226489);
                if (aVar.errType == 0 && aVar.errCode == 0) {
                    if (aVar.iLC != null) {
                        try {
                            z buC = n.buC();
                            if (!buC.bAh()) {
                                Log.e("MicroMsg.WxaAttrSyncHelper", "BatchBizAttrSync storage can not work");
                                List<String> emptyList = Collections.emptyList();
                                AppMethodBeat.o(226489);
                                return emptyList;
                            }
                            buC.a((lm) aVar.iLC, (List<String>) null);
                        } catch (com.tencent.mm.model.b | NullPointerException e2) {
                            if (n.buy() != null) {
                                AppMethodBeat.o(226489);
                                throw e2;
                            }
                        }
                    }
                    List<String> list = list;
                    AppMethodBeat.o(226489);
                    return list;
                }
                Log.e("MicroMsg.WxaAttrSyncHelper", "BatchWxaAttrSync, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode), aVar.errMsg);
                List<String> emptyList2 = Collections.emptyList();
                AppMethodBeat.o(226489);
                return emptyList2;
            }
        });
        AppMethodBeat.o(226503);
        return i2;
    }

    public interface b<T> {
        void a(a aVar, T t);

        public enum a {
            RET_HIT_FREQUENCY_LIMIT,
            RET_UPDATED,
            RET_NO_UPDATE,
            RET_CGI_FAIL;

            public static a valueOf(String str) {
                AppMethodBeat.i(226491);
                a aVar = (a) Enum.valueOf(a.class, str);
                AppMethodBeat.o(226491);
                return aVar;
            }

            static {
                AppMethodBeat.i(226492);
                AppMethodBeat.o(226492);
            }
        }
    }
}
