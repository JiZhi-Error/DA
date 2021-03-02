package com.tencent.mm.plugin.appbrand.backgroundfetch;

import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.a.b;
import com.tencent.mm.plugin.appbrand.a.c;
import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent;
import com.tencent.mm.plugin.appbrand.jsapi.s;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public final class i extends s {
    private static final int CTRL_INDEX = 523;
    private static final String NAME = "onBackgroundFetchData";

    public static void s(q qVar) {
        AppMethodBeat.i(44759);
        final String str = qVar.mAppId;
        final AnonymousClass1 r1 = new MMToClientEvent.c() {
            /* class com.tencent.mm.plugin.appbrand.backgroundfetch.i.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.c
            public final void cq(Object obj) {
                AppMethodBeat.i(44757);
                if (obj instanceof AppBrandBackgroundFetchDataParcel) {
                    Log.i("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent", "app received data, appId:%s", str);
                    String str = str;
                    AppBrandBackgroundFetchDataParcel appBrandBackgroundFetchDataParcel = (AppBrandBackgroundFetchDataParcel) obj;
                    if (appBrandBackgroundFetchDataParcel == null || Util.isNullOrNil(str)) {
                        Log.w("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent", "dispatch, parcel is null or appid is null");
                        AppMethodBeat.o(44757);
                        return;
                    }
                    String str2 = appBrandBackgroundFetchDataParcel.username;
                    int i2 = appBrandBackgroundFetchDataParcel.kXP;
                    String str3 = appBrandBackgroundFetchDataParcel.data;
                    String str4 = appBrandBackgroundFetchDataParcel.path;
                    String str5 = appBrandBackgroundFetchDataParcel.query;
                    int i3 = appBrandBackgroundFetchDataParcel.scene;
                    long j2 = appBrandBackgroundFetchDataParcel.crj;
                    if (Util.isNullOrNil(str2) || Util.isNullOrNil(str3)) {
                        Log.w("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent", "username or data is null");
                        AppMethodBeat.o(44757);
                        return;
                    }
                    q TQ = a.TQ(str);
                    if (TQ == null || !TQ.mInitialized) {
                        Log.w("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent", "app(%s) runtime is null or not initialized, appId:%s", str2, str);
                        AppMethodBeat.o(44757);
                        return;
                    }
                    com.tencent.mm.plugin.appbrand.s NY = TQ.NY();
                    if (NY == null || NY.getAppState() == b.DESTROYED) {
                        Log.w("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent", "app(%s) service is null or has destroyed, appId:%s", str2, str);
                        AppMethodBeat.o(44757);
                        return;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("timeStamp", Long.valueOf(j2));
                    hashMap.put("path", str4);
                    hashMap.put(SearchIntents.EXTRA_QUERY, str5);
                    hashMap.put("scene", Integer.valueOf(i3));
                    hashMap.put("fetchedData", str3);
                    hashMap.put("fetchType", i2 == 0 ? "pre" : "peroid");
                    Log.i("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent", "AppBrandOnBackgroundFetchDataEvent dispatch to app(%s), appId:%s, fetch type:%d", str2, str, Integer.valueOf(i2));
                    new i().L(hashMap).g(NY).bEo();
                }
                AppMethodBeat.o(44757);
            }
        };
        MMToClientEvent.a(str, r1);
        Log.i("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent", "app start listening background fetched data event, appId:%s", str);
        qVar.kAH.a(new c.a() {
            /* class com.tencent.mm.plugin.appbrand.backgroundfetch.i.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.a.c.a
            public final void a(String str, b bVar) {
                AppMethodBeat.i(44758);
                if (bVar == b.DESTROYED) {
                    MMToClientEvent.b(str, r1);
                    Log.i("MicroMsg.AppBrand.AppBrandOnBackgroundFetchDataEvent", "app stop listening background fetched data event, appId:%s", str);
                }
                AppMethodBeat.o(44758);
            }
        });
        AppMethodBeat.o(44759);
    }
}
