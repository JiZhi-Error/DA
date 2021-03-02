package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ch.a;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiQueryDownloadTask;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class av extends br<s> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return JsApiQueryDownloadTask.NAME;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 1;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<s>.a aVar) {
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, final br.a aVar) {
        AppMethodBeat.i(78606);
        Log.i("MicroMsg.JsApiQueryDownloadTask", "invokeInMM");
        try {
            final JSONObject jSONObject = new JSONObject(str);
            a.post(new Runnable() {
                /* class com.tencent.mm.plugin.webview.luggage.jsapi.av.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(78605);
                    JSONArray optJSONArray = jSONObject.optJSONArray("appIdArray");
                    if (optJSONArray == null || optJSONArray.length() <= 0) {
                        long optLong = jSONObject.optLong("download_id", -1);
                        String optString = jSONObject.optString("appid");
                        if (optLong > 0) {
                            FileDownloadTaskInfo Co = f.cBv().Co(optLong);
                            if (Co == null) {
                                Co = new FileDownloadTaskInfo();
                            }
                            av.a(Co, aVar);
                            AppMethodBeat.o(78605);
                        } else if (!Util.isNullOrNil(optString)) {
                            FileDownloadTaskInfo alg = f.cBv().alg(optString);
                            if (alg == null) {
                                alg = new FileDownloadTaskInfo();
                            }
                            av.a(alg, aVar);
                            AppMethodBeat.o(78605);
                        } else {
                            aVar.i("fail", null);
                            AppMethodBeat.o(78605);
                        }
                    } else {
                        av.a(optJSONArray, aVar);
                        AppMethodBeat.o(78605);
                    }
                }
            });
            AppMethodBeat.o(78606);
        } catch (JSONException e2) {
            Log.e("MicroMsg.JsApiQueryDownloadTask", "paras data error: " + e2.getMessage());
            aVar.i("fail", null);
            AppMethodBeat.o(78606);
        }
    }

    private static void a(JSONObject jSONObject, LinkedList<String> linkedList) {
        AppMethodBeat.i(78607);
        if (Util.isNullOrNil(linkedList)) {
            AppMethodBeat.o(78607);
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
                Log.e("MicroMsg.JsApiQueryDownloadTask", e2.getMessage());
            }
        }
        AppMethodBeat.o(78607);
    }

    static /* synthetic */ void a(JSONArray jSONArray, br.a aVar) {
        String str;
        AppMethodBeat.i(78608);
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
                        if (com.tencent.mm.vfs.s.YS(next.path)) {
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
                    Log.e("MicroMsg.JsApiQueryDownloadTask", e2.getMessage());
                }
            }
            a(jSONObject, linkedList);
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("result", jSONObject.toString());
            } catch (JSONException e3) {
            }
            aVar.i("", jSONObject3);
            AppMethodBeat.o(78608);
            return;
        }
        Log.e("MicroMsg.JsApiQueryDownloadTask", "taskInfos is null");
        a(jSONObject, linkedList);
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject4.put("result", jSONObject.toString());
        } catch (JSONException e4) {
        }
        aVar.i(null, jSONObject4);
        AppMethodBeat.o(78608);
    }

    static /* synthetic */ void a(FileDownloadTaskInfo fileDownloadTaskInfo, br.a aVar) {
        String str;
        AppMethodBeat.i(78609);
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
                if (!com.tencent.mm.vfs.s.YS(fileDownloadTaskInfo.path)) {
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
            aVar.i(null, jSONObject);
            AppMethodBeat.o(78609);
        } catch (Exception e2) {
            Log.e("MicroMsg.JsApiQueryDownloadTask", e2.getMessage());
            AppMethodBeat.o(78609);
        }
    }
}
