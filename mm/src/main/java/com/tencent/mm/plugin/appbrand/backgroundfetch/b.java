package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.protocal.protobuf.ddx;
import com.tencent.mm.protocal.protobuf.fcy;
import com.tencent.mm.protocal.protobuf.fcz;
import com.tencent.mm.protocal.protobuf.ii;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b {
    private static long kXM = 0;

    public static void byO() {
        AppMethodBeat.i(44693);
        if (!NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            Log.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "periodFetchDataWhenAppEnterForeground, not wifi network");
            AppMethodBeat.o(44693);
            return;
        }
        long aWy = cl.aWy();
        if (aWy - kXM < 900000) {
            Log.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "periodFetchDataWhenAppEnterForeground, too frequent");
            AppMethodBeat.o(44693);
            return;
        }
        kXM = aWy;
        m.bZn().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.backgroundfetch.b.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(44690);
                ArrayList<AppBrandRecentTaskInfo> vZ = n.buJ().vZ(200);
                if (vZ.isEmpty()) {
                    Log.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "worker:periodFetchDataWhenAppEnterForeground, no recent apps");
                    AppMethodBeat.o(44690);
                    return;
                }
                Log.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "worker:periodFetchDataWhenAppEnterForeground, recent list size:%d", Integer.valueOf(vZ.size()));
                HashMap hashMap = new HashMap();
                Iterator<AppBrandRecentTaskInfo> it = vZ.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    AppBrandRecentTaskInfo next = it.next();
                    if (!hashMap.containsKey(next.username) && b.bs(next.username, next.iOo)) {
                        hashMap.put(next.username, next.appId);
                        if (hashMap.size() >= 20) {
                            Log.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "worker:periodFetchDataWhenAppEnterForeground, batch list full");
                            break;
                        }
                    }
                }
                if (!hashMap.isEmpty()) {
                    b.a(hashMap, new j());
                    AppMethodBeat.o(44690);
                    return;
                }
                Log.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "worker:periodFetchDataWhenAppEnterForeground, currently no app needs to update period data");
                AppMethodBeat.o(44690);
            }
        });
        AppMethodBeat.o(44693);
    }

    public static String cM(final String str, final String str2) {
        AppBrandBackgroundFetchDataTokenParcel Wy;
        AppMethodBeat.i(44694);
        Log.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "forcePeriodFetchData, userName:%s, appId:%s", str, str2);
        if (!NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
            Log.w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "forcePeriodFetchData, not wifi network");
            AppMethodBeat.o(44694);
            return "fail:not wifi network";
        } else if (g.af(l.class) == null || ((Wy = ((l) g.af(l.class)).Wy(str)) != null && !Util.isNullOrNil(Wy.token))) {
            m.bZn().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.backgroundfetch.b.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(44691);
                    HashMap hashMap = new HashMap();
                    hashMap.put(str, str2);
                    b.a(hashMap, new j());
                    AppMethodBeat.o(44691);
                }
            });
            AppMethodBeat.o(44694);
            return "ok";
        } else {
            Log.w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "forcePeriodFetchData, app(%s) token is empty", str);
            AppMethodBeat.o(44694);
            return "fail:token not set";
        }
    }

    public static void a(String str, String str2, int i2, String str3, int i3, m mVar) {
        AppMethodBeat.i(44695);
        if (Util.isNullOrNil(str2)) {
            Log.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "preFetchData, username is null");
            AppMethodBeat.o(44695);
            return;
        }
        a Xs = y.Xs(str2);
        if (Xs == null || Xs.kXI) {
            String str4 = null;
            if (!Util.isNullOrNil(str3)) {
                int lastIndexOf = str3.lastIndexOf(63);
                if (lastIndexOf > 0) {
                    String substring = str3.substring(0, lastIndexOf);
                    if (lastIndexOf < str3.length() - 1) {
                        str4 = str3.substring(lastIndexOf + 1);
                        str3 = substring;
                    } else {
                        str3 = substring;
                    }
                }
            } else {
                str3 = null;
            }
            c Q = a.Q(str3, str4);
            String str5 = (String) Q.get(0);
            String str6 = (String) Q.get(1);
            Log.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "preFetchDataInternal, app(%s) pre fetch data start, path:%s, query:%s, scene:%d", str2, str5, str6, Integer.valueOf(i3));
            ii iiVar = new ii();
            iiVar.dNI = str;
            iiVar.username = str2;
            iiVar.KMw = 0;
            iiVar.KMx = new ddx();
            iiVar.KMx.scene = i3;
            if (g.af(l.class) != null) {
                AppBrandBackgroundFetchDataTokenParcel Wy = ((l) g.af(l.class)).Wy(str2);
                if (Wy == null || Util.isNullOrNil(Wy.token)) {
                    Log.w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "preFetchDataInternal, token is empty, appid:%s", str);
                } else {
                    Log.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "preFetchDataInternal, app(%s) token:%s", iiVar.username, Wy.token);
                    iiVar.token = Wy.token;
                }
            }
            if (!Util.isNullOrNil(str5)) {
                iiVar.KMx.path = str5;
            }
            if (!Util.isNullOrNil(str6)) {
                iiVar.KMx.query = str6;
            }
            LinkedList linkedList = new LinkedList();
            linkedList.add(iiVar);
            a(0, linkedList, mVar);
            AppMethodBeat.o(44695);
            return;
        }
        Log.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "preFetchData, app(%s_v%d) can not pre fetch data", str2, Integer.valueOf(i2));
        AppMethodBeat.o(44695);
    }

    private static void a(final int i2, List<ii> list, final m mVar) {
        AppMethodBeat.i(44696);
        if (list.isEmpty() || mVar == null) {
            Log.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "batchFetchDataInternal, requestList or callback is null");
            AppMethodBeat.o(44696);
            return;
        }
        Log.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "batchFetchDataInternal, size:%d", Integer.valueOf(list.size()));
        final fcy fcy = new fcy();
        fcy.NyK.addAll(list);
        d.a aVar = new d.a();
        aVar.funcId = 1733;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxabusiness/fetchdata";
        aVar.iLN = fcy;
        aVar.iLO = new fcz();
        IPCRunCgi.a(aVar.aXF(), new IPCRunCgi.a() {
            /* class com.tencent.mm.plugin.appbrand.backgroundfetch.b.AnonymousClass3 */

            @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
            public final void a(int i2, int i3, String str, d dVar) {
                AppMethodBeat.i(44692);
                if (i2 != 0 || i3 != 0 || dVar == null || dVar.iLL.iLR == null || !(dVar.iLL.iLR instanceof fcz)) {
                    Log.e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "batchFetchDataInternal, batch fetch data fail:request fail");
                    mVar.onFail(i2);
                    AppMethodBeat.o(44692);
                    return;
                }
                fcz fcz = (fcz) dVar.iLL.iLR;
                if (fcz.NyL == null || fcz.NyL.isEmpty()) {
                    Log.e("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "batchFetchDataInternal, batch fetch data fail:data is null");
                    mVar.onFail(i2);
                    AppMethodBeat.o(44692);
                    return;
                }
                Log.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "batchFetchDataInternal, batch fetch data success");
                mVar.g(fcz.NyL, fcy.NyK);
                AppMethodBeat.o(44692);
            }
        });
        AppMethodBeat.o(44696);
    }

    public static boolean d(AppBrandInitConfigWC appBrandInitConfigWC) {
        AppMethodBeat.i(44697);
        if (appBrandInitConfigWC == null || Util.isNullOrNil(appBrandInitConfigWC.appId) || h.bWb().afi(appBrandInitConfigWC.appId)) {
            AppMethodBeat.o(44697);
            return false;
        }
        AppMethodBeat.o(44697);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x019f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ boolean bs(java.lang.String r15, int r16) {
        /*
        // Method dump skipped, instructions count: 448
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.backgroundfetch.b.bs(java.lang.String, int):boolean");
    }

    static /* synthetic */ void a(Map map, m mVar) {
        AppMethodBeat.i(44699);
        if (map.isEmpty()) {
            Log.i("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "periodFetchDataInternal, no starAppMap or no callback");
            AppMethodBeat.o(44699);
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (Map.Entry entry : map.entrySet()) {
            ii iiVar = new ii();
            iiVar.username = (String) entry.getKey();
            iiVar.dNI = (String) entry.getValue();
            iiVar.KMw = 1;
            if (g.af(l.class) != null) {
                AppBrandBackgroundFetchDataTokenParcel Wy = ((l) g.af(l.class)).Wy(iiVar.username);
                if (Wy == null || Util.isNullOrNil(Wy.token)) {
                    Log.w("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "periodFetchDataInternal, app(%s) token is empty", iiVar.username);
                } else {
                    Log.d("MicroMsg.AppBrand.AppBrandBackgroundFetchDataHandler", "periodFetchDataInternal, app(%s) token:%s", iiVar.username, Wy.token);
                    iiVar.token = Wy.token;
                }
            }
            linkedList.add(iiVar);
        }
        a(1, linkedList, mVar);
        AppMethodBeat.o(44699);
    }
}
