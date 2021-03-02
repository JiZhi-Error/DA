package com.tencent.mm.plugin.game.luggage.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ch.a;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.lite.jsapi.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class j extends b {
    @Override // com.tencent.mm.plugin.lite.jsapi.b
    public final int dTw() {
        return 1;
    }

    @Override // com.tencent.liteapp.jsapi.a
    public final void a(String str, final JSONObject jSONObject) {
        AppMethodBeat.i(186917);
        a.post(new Runnable() {
            /* class com.tencent.mm.plugin.game.luggage.d.a.j.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(186916);
                JSONArray optJSONArray = jSONObject.optJSONArray("appIdArray");
                if (optJSONArray == null || optJSONArray.length() <= 0) {
                    long optLong = jSONObject.optLong("download_id", -1);
                    String optString = jSONObject.optString("appid");
                    if (optLong > 0) {
                        FileDownloadTaskInfo Co = f.cBv().Co(optLong);
                        if (Co == null) {
                            Co = new FileDownloadTaskInfo();
                        }
                        Co.appId = optString;
                        j.a(j.this, Co);
                        AppMethodBeat.o(186916);
                    } else if (!Util.isNullOrNil(optString)) {
                        FileDownloadTaskInfo alg = f.cBv().alg(optString);
                        if (alg == null) {
                            alg = new FileDownloadTaskInfo();
                        }
                        alg.appId = optString;
                        j.a(j.this, alg);
                        AppMethodBeat.o(186916);
                    } else {
                        j.this.yEn.aCS("fail");
                        AppMethodBeat.o(186916);
                    }
                } else {
                    j.a(j.this, optJSONArray);
                    AppMethodBeat.o(186916);
                }
            }
        });
        AppMethodBeat.o(186917);
    }

    private static void a(JSONObject jSONObject, LinkedList<String> linkedList) {
        AppMethodBeat.i(186918);
        if (Util.isNullOrNil(linkedList)) {
            AppMethodBeat.o(186918);
            return;
        }
        Iterator<String> it = linkedList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("download_id", -1);
                jSONObject2.put("state", BuildConfig.KINDA_DEFAULT);
                jSONObject.put(next, jSONObject2);
            } catch (Exception e2) {
                Log.e("LiteAppJsApiQueryDownloadTask", e2.getMessage());
            }
        }
        AppMethodBeat.o(186918);
    }

    static /* synthetic */ void a(j jVar, JSONArray jSONArray) {
        String str;
        AppMethodBeat.i(186919);
        JSONObject jSONObject = new JSONObject();
        LinkedList linkedList = new LinkedList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            linkedList.add(jSONArray.optString(i2));
        }
        f.cBv();
        LinkedList<FileDownloadTaskInfo> U = f.U(linkedList);
        if (U.size() > 0) {
            Iterator<FileDownloadTaskInfo> it = U.iterator();
            while (it.hasNext()) {
                FileDownloadTaskInfo next = it.next();
                JSONObject jSONObject2 = new JSONObject();
                switch (next.status) {
                    case -1:
                        str = "api_not_support";
                        break;
                    case 0:
                    default:
                        str = BuildConfig.KINDA_DEFAULT;
                        break;
                    case 1:
                        str = "downloading";
                        break;
                    case 2:
                        str = "download_pause";
                        break;
                    case 3:
                        if (s.YS(next.path)) {
                            str = "download_succ";
                            break;
                        } else {
                            str = BuildConfig.KINDA_DEFAULT;
                            break;
                        }
                    case 4:
                        str = "download_fail";
                        break;
                }
                try {
                    jSONObject2.put("download_id", next.id);
                    jSONObject2.put("state", str);
                    if (next.qJh) {
                        jSONObject2.put("reserve_for_wifi", 1);
                    }
                    if (next.oJj != 0) {
                        jSONObject2.put("progress", (next.qJe * 100) / next.oJj);
                        jSONObject2.put("progress_float", (double) ((((float) next.qJe) * 100.0f) / ((float) next.oJj)));
                    }
                    jSONObject.put(next.appId, jSONObject2);
                    linkedList.remove(next.appId);
                } catch (Exception e2) {
                    Log.e("LiteAppJsApiQueryDownloadTask", e2.getMessage());
                }
            }
            a(jSONObject, linkedList);
            new JSONObject();
            jVar.yEn.aW(jSONObject);
            AppMethodBeat.o(186919);
            return;
        }
        Log.e("LiteAppJsApiQueryDownloadTask", "taskInfos is null");
        a(jSONObject, linkedList);
        jVar.yEn.aW(jSONObject);
        AppMethodBeat.o(186919);
    }

    static /* synthetic */ void a(j jVar, FileDownloadTaskInfo fileDownloadTaskInfo) {
        String str;
        AppMethodBeat.i(186920);
        JSONObject jSONObject = new JSONObject();
        switch (fileDownloadTaskInfo.status) {
            case -1:
                str = "api_not_support";
                break;
            case 0:
            default:
                str = BuildConfig.KINDA_DEFAULT;
                break;
            case 1:
                str = "downloading";
                break;
            case 2:
                str = "download_pause";
                break;
            case 3:
                if (!s.YS(fileDownloadTaskInfo.path)) {
                    str = BuildConfig.KINDA_DEFAULT;
                    break;
                } else {
                    str = "download_succ";
                    break;
                }
            case 4:
                str = "download_fail";
                break;
        }
        try {
            jSONObject.put("download_id", fileDownloadTaskInfo.id);
            jSONObject.put("state", str);
            if (fileDownloadTaskInfo.qJh) {
                jSONObject.put("reserve_for_wifi", 1);
            }
            if (fileDownloadTaskInfo.oJj != 0) {
                jSONObject.put("progress", (fileDownloadTaskInfo.qJe * 100) / fileDownloadTaskInfo.oJj);
                jSONObject.put("progress_float", (double) ((((float) fileDownloadTaskInfo.qJe) * 100.0f) / ((float) fileDownloadTaskInfo.oJj)));
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(fileDownloadTaskInfo.appId, jSONObject);
            jVar.yEn.aW(jSONObject2);
            AppMethodBeat.o(186920);
        } catch (Exception e2) {
            Log.e("LiteAppJsApiQueryDownloadTask", e2.getMessage());
            AppMethodBeat.o(186920);
        }
    }
}
