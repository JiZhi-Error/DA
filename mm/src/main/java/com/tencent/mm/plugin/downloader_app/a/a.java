package com.tencent.mm.plugin.downloader_app.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public String appId;
    public String appName;
    public int dNv;
    public String downloadUrl;
    public int eik;
    public String extInfo;
    public int fileType;
    public String mYc;
    public String packageName;
    public int qJH;
    public int qJI;
    public int qJJ;
    public boolean qJg;
    public boolean qKA = false;
    public String qKt;
    public String qKu;
    public long qKv;
    public boolean qKw = true;
    public boolean qKx;
    public boolean qKy = true;
    public LinkedList<com.tencent.mm.plugin.downloader.c.b.a> qKz;
    public int scene;

    public static a aK(JSONObject jSONObject) {
        boolean z = false;
        AppMethodBeat.i(153083);
        a aVar = new a();
        if (jSONObject == null) {
            AppMethodBeat.o(153083);
            return aVar;
        }
        aVar.appName = jSONObject.optString("task_name");
        aVar.downloadUrl = jSONObject.optString("task_url");
        aVar.qKt = jSONObject.optString("alternative_url");
        aVar.qKv = jSONObject.optLong("task_size");
        aVar.mYc = jSONObject.optString("file_md5");
        aVar.extInfo = jSONObject.optString(IssueStorage.COLUMN_EXT_INFO);
        aVar.fileType = Util.getInt(jSONObject.optString("fileType"), 0);
        aVar.appId = jSONObject.optString("appid");
        aVar.qKu = jSONObject.optString("raw_appid");
        aVar.packageName = jSONObject.optString(AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME);
        aVar.scene = jSONObject.optInt("scene", 1000);
        aVar.dNv = jSONObject.optInt("downloader_type", 1);
        aVar.qJg = jSONObject.optBoolean("download_in_wifi", false);
        aVar.eik = jSONObject.optInt("download_type", 1);
        aVar.qJH = jSONObject.optInt("uiarea");
        aVar.qJI = jSONObject.optInt("notice_id");
        aVar.qJJ = jSONObject.optInt(TPDownloadProxyEnum.USER_SSID);
        JSONArray optJSONArray = jSONObject.optJSONArray("fileSectionMd5");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            aVar.qKz = new LinkedList<>();
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    com.tencent.mm.plugin.downloader.c.b.a aVar2 = new com.tencent.mm.plugin.downloader.c.b.a();
                    aVar2.qGj = optJSONObject.optLong("android_md5_section_begin");
                    aVar2.qGk = optJSONObject.optLong("android_md5_section_end");
                    aVar2.qGl = optJSONObject.optString("android_md5_section_md5");
                    aVar.qKz.add(aVar2);
                }
            }
        }
        if (jSONObject.optInt("ignoreNetwork", 0) == 1) {
            z = true;
        }
        aVar.qKA = z;
        AppMethodBeat.o(153083);
        return aVar;
    }

    public static a ad(Map<String, Object> map) {
        AppMethodBeat.i(153084);
        a aVar = new a();
        if (map == null) {
            AppMethodBeat.o(153084);
            return aVar;
        }
        aVar.appName = (String) map.get("task_name");
        aVar.downloadUrl = (String) map.get("task_url");
        aVar.qKt = (String) map.get("alternative_url");
        aVar.qKv = Util.getLong((String) map.get("task_size"), 0);
        aVar.mYc = (String) map.get("file_md5");
        aVar.extInfo = (String) map.get(IssueStorage.COLUMN_EXT_INFO);
        aVar.fileType = Util.getInt((String) map.get("fileType"), 0);
        aVar.appId = (String) map.get("appid");
        aVar.qKu = (String) map.get("raw_appid");
        aVar.packageName = (String) map.get("package_name");
        aVar.scene = Util.getInt((String) map.get("scene"), 1000);
        aVar.dNv = Util.getInt((String) map.get("downloader_type"), 1);
        aVar.eik = Util.getInt((String) map.get("download_type"), 1);
        aVar.qJH = Util.getInt((String) map.get("uiarea"), 0);
        aVar.qJI = Util.getInt((String) map.get("notice_id"), 0);
        aVar.qJJ = Util.getInt((String) map.get(TPDownloadProxyEnum.USER_SSID), 0);
        String str = (String) map.get("fileSectionMd5");
        if (!Util.isNullOrNil(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() > 0) {
                    aVar.qKz = new LinkedList<>();
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                        if (optJSONObject != null) {
                            com.tencent.mm.plugin.downloader.c.b.a aVar2 = new com.tencent.mm.plugin.downloader.c.b.a();
                            aVar2.qGj = optJSONObject.optLong("android_md5_section_begin");
                            aVar2.qGk = optJSONObject.optLong("android_md5_section_end");
                            aVar2.qGl = optJSONObject.optString("android_md5_section_md5");
                            aVar.qKz.add(aVar2);
                        }
                    }
                }
            } catch (JSONException e2) {
            }
        }
        aVar.qKA = Util.getInt((String) map.get("ignoreNetwork"), 0) == 1;
        AppMethodBeat.o(153084);
        return aVar;
    }

    public final boolean isValid() {
        AppMethodBeat.i(153085);
        if (!Util.isNullOrNil(this.downloadUrl)) {
            AppMethodBeat.o(153085);
            return true;
        }
        AppMethodBeat.o(153085);
        return false;
    }
}
