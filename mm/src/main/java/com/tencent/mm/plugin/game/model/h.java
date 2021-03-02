package com.tencent.mm.plugin.game.model;

import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class h {
    JSONObject xEH = new JSONObject();

    protected h(String str) {
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.GameServerData", "Null or nil json string");
            return;
        }
        try {
            this.xEH = new JSONObject(str);
        } catch (JSONException e2) {
            Log.e("MicroMsg.GameServerData", "Json parsing error");
        }
    }

    /* access modifiers changed from: protected */
    public final JSONArray optJSONArray(String str) {
        return this.xEH.optJSONArray(str);
    }

    private static String l(JSONObject jSONObject, String str) {
        if (jSONObject != null && !jSONObject.isNull(str)) {
            return jSONObject.optString(str);
        }
        return null;
    }

    protected static LinkedList<c> z(JSONArray jSONArray) {
        c cVar;
        LinkedList<c> linkedList = new LinkedList<>();
        if (jSONArray == null || jSONArray.length() == 0) {
            Log.i("MicroMsg.GameServerData", "Null or empty json array");
            return linkedList;
        }
        Log.i("MicroMsg.GameServerData", "Parsing json AppInfo, size: %d", Integer.valueOf(jSONArray.length()));
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject == null) {
                Log.e("MicroMsg.GameServerData", "Invalid json object");
                cVar = null;
            } else {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("YYB");
                String l = l(optJSONObject, "appID");
                if (Util.isNullOrNil(l)) {
                    Log.e("MicroMsg.GameServerData", "No AppID field, abort");
                    cVar = null;
                } else {
                    Log.i("MicroMsg.GameServerData", "Parsing AppID: %s", l);
                    cVar = new c();
                    cVar.field_appId = l;
                    cVar.field_appName = l(optJSONObject, "name");
                    cVar.field_appIconUrl = l(optJSONObject, "iconURL");
                    cVar.field_appType = ",1,";
                    cVar.field_packageName = l(optJSONObject, "AndroidPackageName");
                    cVar.Bl(l(optJSONObject, "downloadURL"));
                    cVar.Bo(l(optJSONObject, "AndroidApkMd5"));
                    String l2 = l(optJSONObject, "GooglePlayDownloadUrl");
                    int optInt = optJSONObject.optInt("GooglePlayDownloadFlag");
                    cVar.Bp(l2);
                    if (!Util.isNullOrNil(l2)) {
                        Log.i("MicroMsg.GameServerData", "GooglePlay URL: %s, Download Flag: %d", l2, Integer.valueOf(optInt));
                        cVar.mZ(optInt);
                    }
                    if (optJSONObject2 != null) {
                        cVar.mZ(optJSONObject2.optInt("AndroidDownloadFlag"));
                    }
                    if (optJSONObject2 != null) {
                        cVar.Bu(l(optJSONObject2, "DownloadUrl"));
                        cVar.Bv(l(optJSONObject2, "ApkMd5"));
                        cVar.Bs(l(optJSONObject2, "PreemptiveUrl"));
                        cVar.Bt(l(optJSONObject2, "ExtInfo"));
                        cVar.na(optJSONObject2.optInt("SupportedVersionCode"));
                    }
                    cVar.xDV = l(optJSONObject, "desc");
                    cVar.xDU = l(optJSONObject, "brief");
                    cVar.type = optJSONObject.optInt("type", 0);
                    cVar.status = optJSONObject.optInt("status");
                    cVar.xDX = l(optJSONObject, "webURL");
                    cVar.xDY = l(optJSONObject, "adUrl");
                    cVar.dDJ = l(optJSONObject, "noticeid");
                    cVar.jyX = optJSONObject.optBoolean("isSubscribed");
                    cVar.versionCode = optJSONObject.optInt(AssistantStore.DownloadInfos.DownloadInfoColumns.VERSIONCODE);
                    if (optJSONObject2 != null) {
                        cVar.xDZ = l(optJSONObject2, "DownloadTipsWording");
                        cVar.xEa = l(optJSONObject2, "BackBtnWording");
                        cVar.xEb = l(optJSONObject2, "DownloadBtnWording");
                    }
                }
            }
            if (cVar != null) {
                linkedList.add(cVar);
            }
        }
        return linkedList;
    }
}
