package com.tencent.mm.plugin.appbrand.launching;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.bf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import org.json.JSONArray;
import org.json.JSONObject;

public final class t extends MAutoStorage<r> {
    public static final String[] iBh = {MAutoStorage.getCreateSQLs(r.kLR, "DevPkgLaunchExtInfo")};

    public t(ISQLiteDatabase iSQLiteDatabase) {
        super(iSQLiteDatabase, r.kLR, "DevPkgLaunchExtInfo", r.INDEX_CREATE);
    }

    static {
        AppMethodBeat.i(146069);
        AppMethodBeat.o(146069);
    }

    public final boolean A(String str, int i2, String str2) {
        AppMethodBeat.i(146067);
        boolean a2 = a(str, i2, str2, true);
        AppMethodBeat.o(146067);
        return a2;
    }

    public final String bU(String str, int i2) {
        AppMethodBeat.i(146068);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(146068);
            return "";
        }
        r rVar = new r();
        rVar.field_appId = str;
        rVar.field_versionType = i2;
        if (super.get(rVar, r.kJX)) {
            String str2 = rVar.field_extJson;
            AppMethodBeat.o(146068);
            return str2;
        }
        AppMethodBeat.o(146068);
        return "";
    }

    public final boolean a(String str, int i2, String str2, boolean z) {
        boolean insert;
        JSONObject jSONObject;
        String str3;
        AppMethodBeat.i(182793);
        if (Util.isNullOrNil(str)) {
            insert = false;
        } else {
            r rVar = new r();
            rVar.field_appId = str;
            rVar.field_versionType = i2;
            if (super.get(rVar, r.kJX)) {
                rVar.field_extJson = Util.nullAs(str2, "{}");
                insert = super.update(rVar, new String[0]);
            } else {
                rVar.field_extJson = Util.nullAs(str2, "{}");
                insert = super.insert(rVar);
            }
        }
        Log.i("MicroMsg.AppBrand.DevPkgLaunchExtInfoStorage", "setExtInfo() appId:%s,versionType:%s,ret:%b,updatePkgManifests:%b,extInfo:%s", str, Integer.valueOf(i2), Boolean.valueOf(insert), Boolean.valueOf(z), str2);
        if (insert && z) {
            if (!TextUtils.isEmpty(str2)) {
                try {
                    jSONObject = new JSONObject(str2);
                } catch (Exception e2) {
                    Log.e("MicroMsg.AppBrand.DevPkgLaunchExtInfoStorage", "setExtInfo parse failed, appId[%s], type[%d], e[%s]", str, Integer.valueOf(i2), e2);
                    jSONObject = null;
                }
            } else {
                jSONObject = null;
            }
            if (jSONObject != null) {
                try {
                    JSONArray optJSONArray = jSONObject.optJSONArray("module_list");
                    if (optJSONArray == null || optJSONArray.length() <= 0) {
                        bf.bwx();
                        bf.aV(str, i2);
                    } else {
                        bf.bwx();
                        bf.q(str, i2, optJSONArray.toString());
                    }
                } catch (Exception e3) {
                    Log.printErrStackTrace("MicroMsg.AppBrand.DevPkgLaunchExtInfoStorage", e3, "extract module_list with appId[%s], type[%d]", str, Integer.valueOf(i2));
                }
                try {
                    String optString = jSONObject.optString("separated_plugin_list");
                    if (!TextUtils.isEmpty(optString)) {
                        bf.bwx();
                        bf.Vp(optString);
                    }
                } catch (Exception e4) {
                    Log.printErrStackTrace("MicroMsg.AppBrand.DevPkgLaunchExtInfoStorage", e4, "extract separated_plugin_list with appId[%s], type[%d]", str, Integer.valueOf(i2));
                }
                try {
                    str3 = jSONObject.optString("without_lib_md5");
                } catch (Exception e5) {
                    str3 = null;
                }
                try {
                    if (!Util.isNullOrNil(str3)) {
                        bf.bwx();
                        bf.b(str, ModulePkgInfo.MODULE_WITHOUT_PLUGIN_CODE, i2, str3);
                    }
                } catch (Exception e6) {
                    Log.printErrStackTrace("MicroMsg.AppBrand.DevPkgLaunchExtInfoStorage", e6, "extract withoutLibMd5 with appId[%s], type[%d]", str, Integer.valueOf(i2));
                }
                try {
                    String optString2 = jSONObject.optString("widget_list");
                    if (!TextUtils.isEmpty(optString2)) {
                        bf.bwx();
                        bf.c(str, "", i2, optString2);
                    }
                } catch (Exception e7) {
                    Log.printErrStackTrace("MicroMsg.AppBrand.DevPkgLaunchExtInfoStorage", e7, "extract widget_list with appId[%s], type[%d]", str, Integer.valueOf(i2));
                }
            }
        }
        AppMethodBeat.o(182793);
        return insert;
    }
}
