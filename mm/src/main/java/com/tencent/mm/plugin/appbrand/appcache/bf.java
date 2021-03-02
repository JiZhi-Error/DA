package com.tencent.mm.plugin.appbrand.appcache;

import android.content.ContentValues;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.luggage.wxa.storage.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class bf {
    private static final Uri CONTENT_URI = Uri.parse("content://" + a.AUTHORITY + "/AppBrandWxaPkgManifestRecord");
    private static final bf kND = new bf();

    static {
        AppMethodBeat.i(146008);
        AppMethodBeat.o(146008);
    }

    public static bf bwx() {
        return kND;
    }

    public static boolean q(String str, int i2, String str2) {
        AppMethodBeat.i(146005);
        Log.i("Luggage.DevPkgLaunchExtInfoContentResolver", "updateModuleList appId:%s, pkgType:%d, pkgVersion:%d", str, Integer.valueOf(i2), -1);
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("CONTENT_KEY_ACTION", "ACTION_UPDATE_MODULE_LIST");
            contentValues.put("CONTENT_KEY_APPID", str);
            contentValues.put("CONTENT_KEY_PKG_TYPE", Integer.valueOf(i2));
            contentValues.put("CONTENT_KEY_PKG_VERSION", (Integer) -1);
            contentValues.put("CONTENT_KEY_MODULE_LIST_JSON", str2);
            MMApplicationContext.getContext().getContentResolver().insert(CONTENT_URI, contentValues);
            AppMethodBeat.o(146005);
            return true;
        } catch (Exception e2) {
            Log.e("Luggage.DevPkgLaunchExtInfoContentResolver", "updateModuleList failed appId:%s, pkgType:%d, pkgVersion:%d, exception:%s", str, Integer.valueOf(i2), -1, e2);
            AppMethodBeat.o(146005);
            return false;
        }
    }

    public static boolean aV(String str, int i2) {
        AppMethodBeat.i(229807);
        Log.i("Luggage.DevPkgLaunchExtInfoContentResolver", "deleteModuleList appId:%s, pkgType:%d, pkgVersion:%d", str, Integer.valueOf(i2), -1);
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("CONTENT_KEY_ACTION", "ACTION_DELETE_MODULE_LIST");
            contentValues.put("CONTENT_KEY_APPID", str);
            contentValues.put("CONTENT_KEY_PKG_TYPE", Integer.valueOf(i2));
            contentValues.put("CONTENT_KEY_PKG_VERSION", (Integer) -1);
            MMApplicationContext.getContext().getContentResolver().update(CONTENT_URI, contentValues, null, null);
        } catch (Exception e2) {
            Log.e("Luggage.DevPkgLaunchExtInfoContentResolver", "deleteModuleList failed, appId:%s, pkgType:%d, pkgVersion:%d, exception:%s", str, Integer.valueOf(i2), -1, e2);
        }
        AppMethodBeat.o(229807);
        return true;
    }

    public static void Vp(String str) {
        AppMethodBeat.i(146006);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(146006);
            return;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("CONTENT_KEY_ACTION", "ACTION_UPDATE_PLUGINCODE_LIST");
            contentValues.put("CONTENT_KEY_PLUGINCODE_LIST", str);
            MMApplicationContext.getContext().getContentResolver().insert(CONTENT_URI, contentValues);
            AppMethodBeat.o(146006);
        } catch (Exception e2) {
            Log.printErrStackTrace("Luggage.DevPkgLaunchExtInfoContentResolver", e2, "updatePluginCodeList", new Object[0]);
            AppMethodBeat.o(146006);
        }
    }

    public static void b(String str, String str2, int i2, String str3) {
        AppMethodBeat.i(146007);
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("CONTENT_KEY_ACTION", "ACIION_UPDATE_WITHOUT_PLUGINCODE_INFO");
            contentValues.put("CONTENT_KEY_APPID", str);
            contentValues.put("CONTENT_KEY_MODULE_NAME", str2);
            contentValues.put("CONTENT_KEY_PKG_VERSION", (Integer) 0);
            contentValues.put("CONTENT_KEY_CODE_TYPE", Integer.valueOf(i2));
            contentValues.put("CONTENT_KEY_PKG_VERSION_MD5", str3);
            contentValues.put("CONTENT_KEY_PKG_TYPE", (Integer) 12);
            MMApplicationContext.getContext().getContentResolver().insert(CONTENT_URI, contentValues);
            AppMethodBeat.o(146007);
        } catch (Exception e2) {
            Log.printErrStackTrace("Luggage.DevPkgLaunchExtInfoContentResolver", e2, "updateWithoutPluginCodeInfo, appId[%s] module[%s], version[%d], codeType[%d], md5[%s], pkgType[%d]", str, str2, 0, Integer.valueOf(i2), str3, 12);
            AppMethodBeat.o(146007);
        }
    }

    public static void c(String str, String str2, int i2, String str3) {
        AppMethodBeat.i(177310);
        if (TextUtils.isEmpty(str3)) {
            AppMethodBeat.o(177310);
            return;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("CONTENT_KEY_ACTION", "ACTION_UPDATE_PKG_INFO");
            contentValues.put("CONTENT_KEY_APPID", str);
            contentValues.put("CONTENT_KEY_MODULE_NAME", str2);
            contentValues.put("CONTENT_KEY_PKG_VERSION", (Integer) 0);
            contentValues.put("CONTENT_KEY_CODE_TYPE", Integer.valueOf(i2));
            contentValues.put("CONTENT_KEY_PKGINFO_LIST", str3);
            MMApplicationContext.getContext().getContentResolver().insert(CONTENT_URI, contentValues);
            AppMethodBeat.o(177310);
        } catch (Exception e2) {
            Log.printErrStackTrace("Luggage.DevPkgLaunchExtInfoContentResolver", e2, "updatePkgInfoList", new Object[0]);
            AppMethodBeat.o(177310);
        }
    }
}
