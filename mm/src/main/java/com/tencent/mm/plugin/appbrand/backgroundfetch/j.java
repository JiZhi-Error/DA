package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.appbrand.ipc.e;
import com.tencent.mm.protocal.protobuf.ii;
import com.tencent.mm.protocal.protobuf.ij;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.List;

public final class j implements m {
    @Override // com.tencent.mm.plugin.appbrand.backgroundfetch.m
    public final void g(List<ij> list, List<ii> list2) {
        ii iiVar;
        AppMethodBeat.i(44760);
        if (list != null && !list.isEmpty()) {
            for (ij ijVar : list) {
                if (ijVar != null && !Util.isNullOrNil(ijVar.username) && list2 != null && !list2.isEmpty()) {
                    Iterator<ii> it = list2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ii next = it.next();
                        if (ijVar.username.equalsIgnoreCase(next.username)) {
                            iiVar = next;
                            break;
                        }
                    }
                }
                iiVar = null;
                if (ijVar.dIZ != 0 || iiVar == null) {
                    Log.w("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "cgi success, but app(%s) failed to fetch data", ijVar.username);
                } else if (iiVar == null || ijVar == null) {
                    Log.w("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "handleBackgroundFetchData fail, request item or response item is null");
                } else if (Util.isNullOrNil(ijVar.username) || Util.isNullOrNil(ijVar.data)) {
                    Log.w("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "handleBackgroundFetchData fail, no username or data in response");
                } else {
                    long aWz = cl.aWz();
                    String str = ijVar.username;
                    String str2 = ijVar.data;
                    int i2 = iiVar.KMw;
                    String str3 = iiVar.KMx != null ? iiVar.KMx.path : null;
                    String str4 = iiVar.KMx != null ? iiVar.KMx.query : null;
                    int i3 = iiVar.KMx != null ? iiVar.KMx.scene : 1000;
                    if (!((k) g.af(k.class)).a(str, i2, str2, str3, str4, i3, aWz)) {
                        Log.e("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "handleBackgroundFetchData fail, save data fail");
                    } else if (!Util.isNullOrNil(iiVar.dNI)) {
                        AppBrandBackgroundFetchDataParcel appBrandBackgroundFetchDataParcel = new AppBrandBackgroundFetchDataParcel();
                        appBrandBackgroundFetchDataParcel.username = str;
                        appBrandBackgroundFetchDataParcel.kXP = i2;
                        appBrandBackgroundFetchDataParcel.data = str2;
                        appBrandBackgroundFetchDataParcel.path = str3;
                        appBrandBackgroundFetchDataParcel.query = str4;
                        appBrandBackgroundFetchDataParcel.scene = i3;
                        appBrandBackgroundFetchDataParcel.crj = aWz;
                        Log.i("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "handleBackgroundFetchData success, send data event to app(%s), appId:%s", iiVar.username, iiVar.dNI);
                        e.b(iiVar.dNI, appBrandBackgroundFetchDataParcel);
                    }
                }
            }
        }
        AppMethodBeat.o(44760);
    }

    @Override // com.tencent.mm.plugin.appbrand.backgroundfetch.m
    public final void onFail(int i2) {
        AppMethodBeat.i(44761);
        Log.e("MicroMsg.AppBrand.DefaultBackgroundFetchDataCallback", "cgi fail, type(%d)", Integer.valueOf(i2));
        AppMethodBeat.o(44761);
    }
}
