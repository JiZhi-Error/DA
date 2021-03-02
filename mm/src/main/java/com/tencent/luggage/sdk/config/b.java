package com.tencent.luggage.sdk.config;

import android.support.v4.e.a;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.ab;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import java.util.Map;

public class b implements MStorage.IOnStorageChange {
    public static b cyi;
    private static String[] cyl = {ch.COL_USERNAME, "appId", "versionInfo", "appInfo", "smallHeadURL", "nickname"};
    protected final Map<String, AppBrandInitConfigLU> cyj = new a();
    private final Map<String, String> cyk = new a();

    protected b() {
        AppMethodBeat.i(146685);
        AppMethodBeat.o(146685);
    }

    public static void release() {
        synchronized (b.class) {
            cyi = null;
        }
    }

    public static b Nw() {
        b bVar;
        synchronized (b.class) {
            bVar = cyi;
        }
        return bVar;
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
    public void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        AppMethodBeat.i(146686);
        if (MStorageEventData.EventType.SINGLE.equals(str)) {
            if (String.class.isInstance(mStorageEventData.obj)) {
                String valueOf = String.valueOf(mStorageEventData.obj);
                if (!Util.isNullOrNil(valueOf)) {
                    try {
                        dz(valueOf);
                        AppMethodBeat.o(146686);
                        return;
                    } catch (RuntimeException e2) {
                        Log.printErrStackTrace("Luggage.WXA.AppBrandInitConfigHelper", e2, "onNotifyChange event[%s] username[%s]", str, valueOf);
                        synchronized (this.cyk) {
                            String remove = this.cyk.remove(valueOf);
                            if (!TextUtils.isEmpty(remove)) {
                                synchronized (this.cyj) {
                                    this.cyj.remove(remove);
                                    AppMethodBeat.o(146686);
                                    return;
                                }
                            }
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(146686);
                        throw th;
                    }
                }
            }
            AppMethodBeat.o(146686);
        } else if (MStorageEventData.EventType.BATCH.equals(str)) {
            synchronized (this.cyj) {
                try {
                    this.cyj.clear();
                } finally {
                    AppMethodBeat.o(146686);
                }
            }
        } else {
            AppMethodBeat.o(146686);
        }
    }

    private AppBrandInitConfigLU dz(String str) {
        String str2;
        AppBrandInitConfigLU dA;
        AppMethodBeat.i(146688);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(146688);
            return null;
        }
        synchronized (this.cyk) {
            try {
                str2 = this.cyk.get(str);
            } finally {
                AppMethodBeat.o(146688);
            }
        }
        if (Util.isNullOrNil(str2)) {
            ab.bAu();
            dA = a(ab.f(String.format("%s=?", ch.COL_USERNAME), new String[]{str}));
            if (dA != null) {
                synchronized (this.cyk) {
                    try {
                        this.cyk.put(str, dA.appId);
                    } finally {
                        AppMethodBeat.o(146688);
                    }
                }
            }
        } else {
            dA = dA(str2);
        }
        return dA;
    }

    public AppBrandInitConfigLU a(WxaAttributes wxaAttributes) {
        AppMethodBeat.i(146689);
        AppBrandInitConfigLU appBrandInitConfigLU = null;
        if (wxaAttributes != null) {
            appBrandInitConfigLU = new AppBrandInitConfigLU();
            appBrandInitConfigLU.username = wxaAttributes.field_username;
            appBrandInitConfigLU.appId = wxaAttributes.field_appId;
            appBrandInitConfigLU.brandName = wxaAttributes.field_nickname;
            appBrandInitConfigLU.iconUrl = wxaAttributes.field_smallHeadURL;
            if (wxaAttributes.bAn() != null) {
                appBrandInitConfigLU.cyo = wxaAttributes.bAn().serviceType;
                appBrandInitConfigLU.originalFlag = wxaAttributes.bAn().originalFlag;
                appBrandInitConfigLU.ldJ = wxaAttributes.bAn().ldJ;
            } else {
                Log.e("Luggage.WXA.AppBrandInitConfigHelper", "assembleConfig username[%s] appId[%s], NULL appInfo", wxaAttributes.field_username, wxaAttributes.field_appId);
            }
            if (wxaAttributes.bAp() != null) {
                appBrandInitConfigLU.cyu = wxaAttributes.bAp().cyu;
                appBrandInitConfigLU.appVersion = wxaAttributes.bAp().appVersion;
                appBrandInitConfigLU.cyv = wxaAttributes.bAp();
            } else {
                Log.e("Luggage.WXA.AppBrandInitConfigHelper", "assembleConfig username[%s] appId[%s], NULL versionInfo", wxaAttributes.field_username, wxaAttributes.field_appId);
            }
            appBrandInitConfigLU.cyw = wxaAttributes.field_passThroughInfo;
        }
        AppMethodBeat.o(146689);
        return appBrandInitConfigLU;
    }

    public AppBrandInitConfigLU dA(String str) {
        AppBrandInitConfigLU remove;
        AppMethodBeat.i(146690);
        if (Util.isNullOrNil(str)) {
            Log.w("Luggage.WXA.AppBrandInitConfigHelper", "obtainByAppId with EMPTY appId");
            AppMethodBeat.o(146690);
            return null;
        }
        synchronized (this.cyj) {
            try {
                remove = this.cyj.remove(str);
            } finally {
                AppMethodBeat.o(146690);
            }
        }
        if (remove == null) {
            ab.bAu();
            AppBrandInitConfigLU a2 = a(ab.e(str, cyl));
            Object[] objArr = new Object[2];
            objArr[0] = str;
            objArr[1] = Integer.valueOf(a2 == null ? -1 : a2.appVersion);
            Log.i("Luggage.WXA.AppBrandInitConfigHelper", "obtainByAppId appId:%s, get from db, appVersion:%d", objArr);
            remove = a2;
        } else {
            Log.i("Luggage.WXA.AppBrandInitConfigHelper", "obtainByAppId appId:%s, get from memory, appVersion:%d", str, Integer.valueOf(remove.appVersion));
        }
        return remove;
    }

    public final void a(String str, AppBrandInitConfigLU appBrandInitConfigLU) {
        AppMethodBeat.i(229824);
        if (appBrandInitConfigLU == null || Util.isNullOrNil(appBrandInitConfigLU.appId)) {
            AppMethodBeat.o(229824);
            return;
        }
        Log.i("Luggage.WXA.AppBrandInitConfigHelper", "stash username:%s, appId:%s, appVersion:%d, stack:%s", str, appBrandInitConfigLU.appId, Integer.valueOf(appBrandInitConfigLU.appVersion), android.util.Log.getStackTraceString(new Throwable()));
        synchronized (this.cyj) {
            try {
                this.cyj.put(appBrandInitConfigLU.appId, appBrandInitConfigLU);
            } finally {
                AppMethodBeat.o(229824);
            }
        }
        if (!Util.isNullOrNil(str)) {
            synchronized (this.cyk) {
                try {
                    this.cyk.put(str, appBrandInitConfigLU.appId);
                } finally {
                    AppMethodBeat.o(229824);
                }
            }
            return;
        }
        AppMethodBeat.o(229824);
    }
}
