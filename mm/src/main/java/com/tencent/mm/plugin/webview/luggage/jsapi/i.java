package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class i extends bs<g> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return JsApiChooseImage.NAME;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(final b<g>.a aVar) {
        int i2;
        int i3;
        Boolean bool;
        AppMethodBeat.i(78527);
        Log.i("MicroMsg.JsApiChooseImage", "invoke");
        JSONObject jSONObject = aVar.ctb.csi;
        JSONArray optJSONArray = jSONObject.optJSONArray("sourceType");
        if (optJSONArray != null) {
            Log.i("MicroMsg.JsApiChooseImage", "sourceType = " + optJSONArray.toString());
            int i4 = 0;
            for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                if (optJSONArray.optString(i5).equals(FFmpegMetadataRetriever.METADATA_KEY_ALBUM)) {
                    i4 |= 1;
                } else if (optJSONArray.optString(i5).equals("camera")) {
                    i4 |= 2;
                }
            }
            i2 = i4;
        } else {
            i2 = 0;
        }
        int i6 = i2 == 0 ? 3 : i2;
        Log.i("MicroMsg.JsApiChooseImage", "real scene = %d", Integer.valueOf(i6));
        if (i6 == 2 || i6 == 3) {
            boolean a2 = com.tencent.mm.pluginsdk.permission.b.a((Activity) aVar.cta.mContext, "android.permission.CAMERA", 113, "", "");
            Log.d("MicroMsg.JsApiChooseImage", " checkPermission checkcamera[%b]", Boolean.valueOf(a2));
            if (!a2) {
                aVar.c("android_permission_denied", null);
                AppMethodBeat.o(78527);
                return;
            }
        }
        int optInt = jSONObject.optInt("count", 0);
        Boolean bool2 = Boolean.FALSE;
        Boolean bool3 = Boolean.FALSE;
        JSONArray optJSONArray2 = jSONObject.optJSONArray("sizeType");
        if (optJSONArray2 != null) {
            for (int i7 = 0; i7 < optJSONArray2.length(); i7++) {
                if (optJSONArray2.optString(i7).equals("original")) {
                    bool2 = Boolean.TRUE;
                } else if (optJSONArray2.optString(i7).equals("compressed")) {
                    bool3 = Boolean.TRUE;
                }
            }
        }
        if (bool2.booleanValue() && !bool3.booleanValue()) {
            i3 = 7;
            bool = Boolean.TRUE;
        } else if (bool2.booleanValue() || !bool3.booleanValue()) {
            i3 = 8;
            bool = Boolean.FALSE;
        } else {
            i3 = 7;
            bool = Boolean.FALSE;
        }
        Intent intent = new Intent();
        intent.putExtra("key_pick_local_pic_capture", i6);
        intent.putExtra("key_pick_local_pic_count", optInt);
        intent.putExtra("key_pick_local_pic_query_source_type", i3);
        intent.putExtra("key_pick_local_pic_send_raw", bool);
        intent.putExtra("query_media_type", 1);
        Log.i("MicroMsg.JsApiChooseImage", "doChooseImage: realScene: %d, count: %d, querySourceType: %d, sendRaw: %b", Integer.valueOf(i6), Integer.valueOf(optInt), Integer.valueOf(i3), bool);
        ((MMActivity) aVar.cta.mContext).mmSetOnActivityResultCallback(new MMActivity.a() {
            /* class com.tencent.mm.plugin.webview.luggage.jsapi.i.AnonymousClass1 */

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.tencent.mm.ui.MMActivity.a
            public final void d(int i2, int i3, Intent intent) {
                boolean booleanExtra;
                AppMethodBeat.i(78526);
                if (i2 == (i.this.hashCode() & 65535)) {
                    if (intent == null) {
                        booleanExtra = false;
                    } else {
                        booleanExtra = intent.getBooleanExtra("key_pick_local_media_show_memory_warning", false);
                    }
                    Log.i("MicroMsg.JsApiChooseImage", "request to open file chooser, result code = %d, hasShowMemoryWarning = %b", Integer.valueOf(i3), Boolean.valueOf(booleanExtra));
                    HashMap hashMap = new HashMap();
                    if (booleanExtra) {
                        hashMap.put("memoryWarning", Boolean.TRUE);
                    }
                    switch (i3) {
                        case -1:
                            String stringExtra = intent != null ? intent.getStringExtra("key_pick_local_pic_callback_local_ids") : null;
                            if (!Util.isNullOrNil(stringExtra)) {
                                Log.i("MicroMsg.JsApiChooseImage", "localIds = %s", stringExtra);
                                hashMap.put("localIds", stringExtra);
                                String stringExtra2 = intent.getStringExtra("key_pick_local_pic_source_type");
                                if (stringExtra2 != null) {
                                    hashMap.put("sourceType", stringExtra2);
                                }
                                aVar.e("", hashMap);
                                break;
                            }
                            aVar.e("fail", hashMap);
                            break;
                        case 0:
                            aVar.e("cancel", hashMap);
                            break;
                        default:
                            aVar.e("fail", hashMap);
                            break;
                    }
                    ((MMActivity) aVar.cta.mContext).mmSetOnActivityResultCallback(null);
                }
                AppMethodBeat.o(78526);
            }
        });
        c.a(aVar.cta.mContext, "webview", ".ui.tools.OpenFileChooserUI", intent, hashCode() & 65535, false);
        AppMethodBeat.o(78527);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }
}
