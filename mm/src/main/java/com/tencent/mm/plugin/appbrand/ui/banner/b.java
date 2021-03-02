package com.tencent.mm.plugin.appbrand.ui.banner;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import org.json.JSONArray;
import org.json.JSONException;

/* access modifiers changed from: package-private */
public final class b {
    b() {
    }

    static boolean Q(Intent intent) {
        AppMethodBeat.i(48988);
        if (intent == null) {
            AppMethodBeat.o(48988);
            return false;
        }
        String stringExtra = intent.getStringExtra(a.appId.Lb());
        int intExtra = intent.getIntExtra(a.versionType.Lb(), 0);
        String stringExtra2 = intent.getStringExtra(a.appName.Lb());
        String stringExtra3 = intent.getStringExtra(a.iconURL.Lb());
        String stringExtra4 = intent.getStringExtra(a.customText.Lb());
        for (a aVar : a.values()) {
            intent.removeExtra(aVar.Lb());
        }
        if (Util.isNullOrNil(stringExtra) || Util.isNullOrNil(stringExtra2)) {
            AppMethodBeat.o(48988);
            return false;
        }
        a(stringExtra, intExtra, stringExtra2, stringExtra3, stringExtra4);
        AppMethodBeat.o(48988);
        return true;
    }

    static boolean a(AppBrandStickyBannerLogic.OperateTask operateTask) {
        AppMethodBeat.i(48989);
        if (operateTask == null || !g.aAc()) {
            AppMethodBeat.o(48989);
            return false;
        }
        BannerModel bYf = BannerModel.bYf();
        if (bYf == null) {
            AppMethodBeat.o(48989);
            return false;
        } else if (!bYf.appId.equals(operateTask.oap) || bYf.iOo != operateTask.oaq) {
            AppMethodBeat.o(48989);
            return false;
        } else {
            a(bYf.appId, bYf.iOo, bYf.appName, bYf.kVZ, operateTask.oar);
            AppMethodBeat.o(48989);
            return true;
        }
    }

    static void a(Intent intent, String str, int i2, String str2, String str3, String str4) {
        AppMethodBeat.i(48990);
        if (intent == null) {
            AppMethodBeat.o(48990);
            return;
        }
        intent.putExtra(a.appId.Lb(), str);
        intent.putExtra(a.versionType.Lb(), i2);
        intent.putExtra(a.appName.Lb(), str2);
        intent.putExtra(a.iconURL.Lb(), str3);
        intent.putExtra(a.customText.Lb(), str4);
        AppMethodBeat.o(48990);
    }

    private static void a(String str, int i2, String str2, String str3, String str4) {
        AppMethodBeat.i(48991);
        if (!g.aAc()) {
            AppMethodBeat.o(48991);
            return;
        }
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(str);
        jSONArray.put(String.valueOf(i2));
        jSONArray.put(str2);
        jSONArray.put(str3);
        jSONArray.put(Util.nullAsNil(str4));
        String jSONArray2 = jSONArray.toString();
        synchronized (b.class) {
            try {
                g.aAh().azQ().set(ar.a.USERINFO_APP_BRAND_CHATTING_BANNER_INFO_STRING_SYNC, jSONArray2);
            } finally {
                AppMethodBeat.o(48991);
            }
        }
    }

    private static Object[] bXY() {
        String str;
        AppMethodBeat.i(48992);
        if (!g.aAc()) {
            AppMethodBeat.o(48992);
            return null;
        }
        synchronized (b.class) {
            try {
                str = (String) g.aAh().azQ().get(ar.a.USERINFO_APP_BRAND_CHATTING_BANNER_INFO_STRING_SYNC, "");
            } finally {
                AppMethodBeat.o(48992);
            }
        }
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(48992);
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() != a.nZY) {
                AppMethodBeat.o(48992);
                return null;
            }
            Object[] objArr = new Object[a.nZY];
            for (int i2 = 0; i2 < a.nZY; i2++) {
                objArr[i2] = jSONArray.optString(i2, "");
            }
            objArr[a.versionType.ordinal()] = Integer.valueOf(Util.getInt((String) objArr[a.versionType.ordinal()], 0));
            AppMethodBeat.o(48992);
            return objArr;
        } catch (JSONException e2) {
            return null;
        }
    }

    static BannerModel bXZ() {
        AppMethodBeat.i(48993);
        Object[] bXY = bXY();
        if (bXY == null) {
            AppMethodBeat.o(48993);
            return null;
        }
        BannerModel bannerModel = new BannerModel();
        bannerModel.appId = (String) bXY[a.appId.ordinal()];
        bannerModel.iOo = ((Integer) bXY[a.versionType.ordinal()]).intValue();
        bannerModel.appName = (String) bXY[a.appName.ordinal()];
        bannerModel.kVZ = (String) bXY[a.iconURL.ordinal()];
        bannerModel.oax = (String) bXY[a.customText.ordinal()];
        AppMethodBeat.o(48993);
        return bannerModel;
    }

    /* access modifiers changed from: package-private */
    public enum a {
        appId,
        versionType,
        appName,
        iconURL,
        customText;
        
        static final int nZY = values().length;

        public static a valueOf(String str) {
            AppMethodBeat.i(48985);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(48985);
            return aVar;
        }

        static {
            AppMethodBeat.i(48987);
            AppMethodBeat.o(48987);
        }

        public final String Lb() {
            AppMethodBeat.i(48986);
            String str = "appbrand_top_banner_in_chatting_extra_key_" + name();
            AppMethodBeat.o(48986);
            return str;
        }
    }
}
