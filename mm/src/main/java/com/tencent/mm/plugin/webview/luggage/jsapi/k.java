package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import org.json.JSONObject;

public class k extends bs<g> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "chooseVideo";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<g>.a aVar) {
        AppMethodBeat.i(78542);
        Log.i("MicroMsg.JsApiChooseVideo", "invokeInOwn");
        a(aVar, 0);
        AppMethodBeat.o(78542);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }

    public static void a(final b<g>.a aVar, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        AppMethodBeat.i(78543);
        final MMActivity mMActivity = (MMActivity) aVar.cta.mContext;
        if (mMActivity == null) {
            Log.e("MicroMsg.JsApiChooseVideo", "activity is null");
            AppMethodBeat.o(78543);
            return;
        }
        JSONObject jSONObject = aVar.ctb.csi;
        String optString = jSONObject.optString("sourceType", "");
        String optString2 = jSONObject.optString("camera", "");
        Log.i("MicroMsg.JsApiChooseVideo", "doChooseVideo sourceType = %s, camera = %s, isVideoType:%d", optString, optString2, Integer.valueOf(i2));
        int optInt = jSONObject.optInt("maxDuration", 60);
        if (optString.contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM)) {
            i3 = 4096;
        } else {
            i3 = 0;
        }
        if (optString.contains("camera")) {
            if (optInt <= 0) {
                aVar.c("fail", null);
                AppMethodBeat.o(78543);
                return;
            } else if (optString2.equals("front")) {
                i3 |= 16;
            } else {
                i3 |= 256;
            }
        }
        if (i3 == 0) {
            i4 = 4352;
        } else {
            i4 = i3;
        }
        if (i4 == 16 || i4 == 256 || i4 == 4352) {
            if (i2 == 1) {
                boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(mMActivity, "android.permission.CAMERA", 117, "", "");
                Log.d("MicroMsg.JsApiChooseVideo", " checkPermission checkcamera[%b]", Boolean.valueOf(a2));
                if (!a2) {
                    AppMethodBeat.o(78543);
                    return;
                }
                boolean a3 = com.tencent.mm.pluginsdk.permission.b.a(mMActivity, "android.permission.RECORD_AUDIO", 118, "", "");
                Log.d("MicroMsg.JsApiChooseVideo", " checkPermission checkMicroPhone[%b]", Boolean.valueOf(a3));
                if (!a3) {
                    AppMethodBeat.o(78543);
                    return;
                }
            } else {
                boolean a4 = com.tencent.mm.pluginsdk.permission.b.a(mMActivity, "android.permission.CAMERA", 115, "", "");
                Log.d("MicroMsg.JsApiChooseVideo", " checkPermission checkcamera[%b]", Boolean.valueOf(a4));
                if (!a4) {
                    AppMethodBeat.o(78543);
                    return;
                }
            }
        }
        int optInt2 = jSONObject.optInt("quality", 1);
        if (optInt2 == 0 || optInt2 == 1) {
            i5 = optInt2;
        } else {
            i5 = 1;
        }
        if (optInt > 60) {
            i6 = 60;
        } else {
            i6 = optInt;
        }
        Log.i("MicroMsg.JsApiChooseVideo", "doChooseVideo real scene = %d, select count = %d, video quality = %d, duration = %d", Integer.valueOf(i4), 1, Integer.valueOf(i5), Integer.valueOf(i6));
        Intent intent = new Intent();
        intent.putExtra("key_pick_local_pic_capture", i4);
        intent.putExtra("key_pick_local_pic_count", 1);
        intent.putExtra("key_pick_local_pic_query_source_type", 7);
        intent.putExtra("key_pick_local_media_quality", i5);
        intent.putExtra("key_pick_local_media_duration", i6);
        intent.putExtra("query_media_type", 2);
        intent.putExtra("key_pick_local_media_video_type", i2);
        Log.i("MicroMsg.JsApiChooseVideo", "doChooseVideo: realScene: %d, count: %d, querySourceType: %d", Integer.valueOf(i4), 1, 7);
        mMActivity.mmSetOnActivityResultCallback(new MMActivity.a() {
            /* class com.tencent.mm.plugin.webview.luggage.jsapi.k.AnonymousClass1 */

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.tencent.mm.ui.MMActivity.a
            public final void d(int i2, int i3, Intent intent) {
                AppMethodBeat.i(78541);
                if (i2 == 45) {
                    switch (i3) {
                        case -1:
                            String stringExtra = intent.getStringExtra("key_pick_local_media_local_id");
                            String stringExtra2 = intent.getStringExtra("key_pick_local_media_thumb_local_id");
                            Log.i("MicroMsg.JsApiChooseVideo", "localId:%s", stringExtra);
                            Log.i("MicroMsg.JsApiChooseVideo", "thumbLocalId:%s", stringExtra2);
                            if (!Util.isNullOrNil(stringExtra)) {
                                WebViewJSSDKFileItem aYC = com.tencent.mm.plugin.webview.luggage.c.b.aYC(stringExtra);
                                if (aYC != null && (aYC instanceof WebViewJSSDKVideoItem)) {
                                    WebViewJSSDKVideoItem webViewJSSDKVideoItem = (WebViewJSSDKVideoItem) aYC;
                                    HashMap hashMap = new HashMap();
                                    hashMap.put(ch.COL_LOCALID, stringExtra);
                                    hashMap.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(webViewJSSDKVideoItem.duration));
                                    hashMap.put("height", Integer.valueOf(webViewJSSDKVideoItem.height));
                                    hashMap.put("size", Integer.valueOf(webViewJSSDKVideoItem.size));
                                    hashMap.put("width", Integer.valueOf(webViewJSSDKVideoItem.width));
                                    hashMap.put("thumbLocalId", stringExtra2);
                                    aVar.e("", hashMap);
                                    break;
                                } else {
                                    aVar.c("fail", null);
                                    break;
                                }
                            }
                            aVar.c("fail", null);
                            break;
                        case 0:
                            aVar.c("cancel", null);
                            break;
                        default:
                            aVar.c("fail", null);
                            break;
                    }
                    mMActivity.mmSetOnActivityResultCallback(null);
                    AppMethodBeat.o(78541);
                    return;
                }
                if (i2 == 32) {
                    switch (i3) {
                        case -1:
                            String stringExtra3 = intent.getStringExtra("key_pick_local_media_local_id");
                            if (!Util.isNullOrNil(stringExtra3)) {
                                WebViewJSSDKFileItem aYC2 = com.tencent.mm.plugin.webview.luggage.c.b.aYC(stringExtra3);
                                if (aYC2 != null && (aYC2 instanceof WebViewJSSDKVideoItem)) {
                                    WebViewJSSDKVideoItem webViewJSSDKVideoItem2 = (WebViewJSSDKVideoItem) aYC2;
                                    HashMap hashMap2 = new HashMap();
                                    hashMap2.put(ch.COL_LOCALID, stringExtra3);
                                    hashMap2.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(webViewJSSDKVideoItem2.duration));
                                    hashMap2.put("height", Integer.valueOf(webViewJSSDKVideoItem2.height));
                                    hashMap2.put("size", Integer.valueOf(webViewJSSDKVideoItem2.size));
                                    hashMap2.put("width", Integer.valueOf(webViewJSSDKVideoItem2.width));
                                    aVar.e("", hashMap2);
                                    break;
                                } else {
                                    aVar.c("fail", null);
                                    break;
                                }
                            }
                            aVar.c("fail", null);
                            break;
                        case 0:
                            aVar.c("cancel", null);
                            break;
                        default:
                            aVar.c("fail", null);
                            break;
                    }
                    mMActivity.mmSetOnActivityResultCallback(null);
                }
                AppMethodBeat.o(78541);
            }
        });
        if (i2 == 1) {
            c.a((Context) mMActivity, "webview", ".ui.tools.OpenFileChooserUI", intent, 45, false);
            AppMethodBeat.o(78543);
            return;
        }
        c.a((Context) mMActivity, "webview", ".ui.tools.OpenFileChooserUI", intent, 32, false);
        AppMethodBeat.o(78543);
    }
}
