package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.ay;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.a.e;
import java.util.HashMap;
import org.json.JSONObject;

public class j extends bs<g> {
    private b<g>.a IVL;
    private MMActivity activity;
    private MMActivity.a lwx = new MMActivity.a() {
        /* class com.tencent.mm.plugin.webview.luggage.jsapi.j.AnonymousClass4 */

        @Override // com.tencent.mm.ui.MMActivity.a
        public final void d(int i2, int i3, Intent intent) {
            AppMethodBeat.i(78531);
            if (i2 == (j.this.hashCode() & 65535)) {
                switch (i3) {
                    case 0:
                        j.a(j.this, "cancel");
                        AppMethodBeat.o(78531);
                        return;
                    case -1:
                        if (intent == null) {
                            Log.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult REQUEST_CHOOSE_MEDIA bundle is null,");
                            j.a(j.this, "fail");
                            AppMethodBeat.o(78531);
                            return;
                        }
                        int intExtra = intent.getIntExtra("key_pick_local_media_callback_type", 0);
                        if (intExtra == 1) {
                            String stringExtra = intent.getStringExtra("key_pick_local_media_local_id");
                            String stringExtra2 = intent.getStringExtra("key_pick_local_media_thumb_local_id");
                            Log.i("MicroMsg.JsApiChooseMedia", "video localId:%s", stringExtra);
                            Log.i("MicroMsg.JsApiChooseMedia", "video thumbLocalId:%s", stringExtra2);
                            if (Util.isNullOrNil(stringExtra)) {
                                Log.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult REQUEST_CHOOSE_MEDIA video localId is null");
                                j.a(j.this, "fail");
                                AppMethodBeat.o(78531);
                                return;
                            }
                            WebViewJSSDKFileItem aYC = com.tencent.mm.plugin.webview.luggage.c.b.aYC(stringExtra);
                            if (aYC == null || !(aYC instanceof WebViewJSSDKVideoItem)) {
                                Log.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult REQUEST_CHOOSE_MEDIA nor the videoitem");
                                break;
                            } else {
                                WebViewJSSDKVideoItem webViewJSSDKVideoItem = (WebViewJSSDKVideoItem) aYC;
                                String c2 = ay.c(stringExtra, stringExtra2, webViewJSSDKVideoItem.duration, webViewJSSDKVideoItem.height, webViewJSSDKVideoItem.width, webViewJSSDKVideoItem.size);
                                Log.i("MicroMsg.JsApiChooseMedia", "after parse to json data : %s", c2);
                                HashMap hashMap = new HashMap();
                                hashMap.put("type", 1);
                                hashMap.put("localIds", c2);
                                j.a(j.this, hashMap);
                                AppMethodBeat.o(78531);
                                return;
                            }
                        } else if (intExtra == 2) {
                            String stringExtra3 = intent.getStringExtra("key_pick_local_media_local_ids");
                            Log.i("MicroMsg.JsApiChooseMedia", "chooseMedia localIds:%s", stringExtra3);
                            if (Util.isNullOrNil(stringExtra3)) {
                                Log.e("MicroMsg.JsApiChooseMedia", "mmOnActivityResult REQUEST_CHOOSE_MEDIA image localIds is null");
                                j.a(j.this, "fail");
                                AppMethodBeat.o(78531);
                                return;
                            }
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("type", 2);
                            hashMap2.put("localIds", stringExtra3);
                            j.a(j.this, hashMap2);
                            AppMethodBeat.o(78531);
                            return;
                        } else {
                            Log.e("MicroMsg.JsApiChooseMedia", "type:%d is error", Integer.valueOf(intExtra));
                            j.a(j.this, "fail");
                            AppMethodBeat.o(78531);
                            return;
                        }
                        break;
                }
                j.a(j.this, "fail");
            }
            AppMethodBeat.o(78531);
        }
    };

    public j() {
        AppMethodBeat.i(78532);
        AppMethodBeat.o(78532);
    }

    static /* synthetic */ void a(j jVar, Intent intent) {
        AppMethodBeat.i(78538);
        jVar.bk(intent);
        AppMethodBeat.o(78538);
    }

    static /* synthetic */ void a(j jVar, String str, Intent intent) {
        AppMethodBeat.i(78537);
        jVar.f(str, intent);
        AppMethodBeat.o(78537);
    }

    @Override // com.tencent.luggage.d.b
    public final String name() {
        return JsApiChooseMedia.NAME;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<g>.a aVar) {
        String str;
        AppMethodBeat.i(78533);
        Log.i("MicroMsg.JsApiChooseMedia", "invoke");
        this.activity = (MMActivity) aVar.cta.mContext;
        this.IVL = aVar;
        if (this.activity == null) {
            d("fail", null);
            AppMethodBeat.o(78533);
            return;
        }
        JSONObject jSONObject = aVar.ctb.csi;
        boolean a2 = com.tencent.mm.pluginsdk.permission.b.a(this.activity, "android.permission.CAMERA", 119, "", "");
        Log.i("MicroMsg.JsApiChooseMedia", " checkPermission checkcamera[%b]", Boolean.valueOf(a2));
        boolean a3 = com.tencent.mm.pluginsdk.permission.b.a(this.activity, "android.permission.RECORD_AUDIO", 120, "", "");
        Log.i("MicroMsg.JsApiChooseMedia", " checkPermission checkMicroPhone[%b]", Boolean.valueOf(a3));
        if (!a3 || !a2) {
            d("no_user_permission", null);
            AppMethodBeat.o(78533);
            return;
        }
        String nullAsNil = Util.nullAsNil(jSONObject.optString("sourceType"));
        String optString = jSONObject.optString("mediaType", "");
        int min = Math.min(jSONObject.optInt("maxDuration", 10), 10);
        final String optString2 = jSONObject.optString("camera", "");
        int optInt = jSONObject.optInt("count", 1);
        String optString3 = jSONObject.optString("sizeType", "");
        Log.i("MicroMsg.JsApiChooseMedia", "doChooseMedia sourceType:%s, mediaType:%s, maxDuration:%d, camera:%s, count:%d, sizeType:%s", nullAsNil, optString, Integer.valueOf(min), optString2, Integer.valueOf(optInt), optString3);
        final Intent intent = new Intent();
        intent.putExtra("key_pick_local_pic_count", optInt);
        if (min <= 0) {
            min = 10;
        }
        intent.putExtra("key_pick_local_media_duration", min);
        intent.putExtra("query_media_type", 3);
        intent.putExtra("key_pick_local_media_video_type", 2);
        intent.putExtra("key_pick_local_media_sight_type", optString);
        intent.putExtra("key_pick_local_pic_query_source_type", optString3.contains("original") ^ optString3.contains("compressed") ? 7 : 8);
        Boolean valueOf = Boolean.valueOf(!optString3.contains("compressed"));
        if (!optString3.contains("original") && !optString3.contains("compressed")) {
            valueOf = Boolean.FALSE;
        }
        intent.putExtra("key_pick_local_pic_send_raw", valueOf);
        if (Util.isNullOrNil(nullAsNil)) {
            str = "album|camera";
        } else {
            str = nullAsNil;
        }
        if (str.contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM) && str.contains("camera")) {
            new l(this.activity).a(null, new View.OnCreateContextMenuListener() {
                /* class com.tencent.mm.plugin.webview.luggage.jsapi.j.AnonymousClass1 */

                public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                    AppMethodBeat.i(78528);
                    contextMenu.add(0, 1, 0, j.this.activity.getString(R.string.um));
                    contextMenu.add(0, 2, 1, j.this.activity.getString(R.string.uv));
                    AppMethodBeat.o(78528);
                }
            }, new o.g() {
                /* class com.tencent.mm.plugin.webview.luggage.jsapi.j.AnonymousClass2 */

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(78529);
                    switch (menuItem.getItemId()) {
                        case 1:
                            j.a(j.this, optString2, intent);
                            AppMethodBeat.o(78529);
                            return;
                        case 2:
                            j.a(j.this, intent);
                            break;
                    }
                    AppMethodBeat.o(78529);
                }
            }, new e.b() {
                /* class com.tencent.mm.plugin.webview.luggage.jsapi.j.AnonymousClass3 */

                @Override // com.tencent.mm.ui.widget.a.e.b
                public final void onDismiss() {
                    AppMethodBeat.i(78530);
                    j.a(j.this, "cancel");
                    AppMethodBeat.o(78530);
                }
            });
            AppMethodBeat.o(78533);
        } else if (str.contains(FFmpegMetadataRetriever.METADATA_KEY_ALBUM)) {
            bk(intent);
            AppMethodBeat.o(78533);
        } else if (str.contains("camera")) {
            f(optString2, intent);
            AppMethodBeat.o(78533);
        } else {
            d("sourceType_error", null);
            AppMethodBeat.o(78533);
        }
    }

    private void f(String str, Intent intent) {
        int i2;
        AppMethodBeat.i(78534);
        Log.i("MicroMsg.JsApiChooseMedia", "chooseMediaFromCamera");
        if (str.equals("front")) {
            i2 = 16;
        } else {
            i2 = 256;
        }
        intent.putExtra("key_pick_local_pic_capture", i2);
        this.activity.mmSetOnActivityResultCallback(this.lwx);
        c.a((Context) this.activity, "webview", ".ui.tools.OpenFileChooserUI", intent, 65535 & hashCode(), false);
        AppMethodBeat.o(78534);
    }

    private void bk(Intent intent) {
        AppMethodBeat.i(78535);
        Log.i("MicroMsg.JsApiChooseMedia", "chooseMediaFromAlbum");
        intent.putExtra("key_pick_local_pic_capture", 4096);
        this.activity.mmSetOnActivityResultCallback(this.lwx);
        c.a((Context) this.activity, "webview", ".ui.tools.OpenFileChooserUI", intent, 65535 & hashCode(), false);
        AppMethodBeat.o(78535);
    }

    private void d(String str, HashMap<String, Object> hashMap) {
        AppMethodBeat.i(78536);
        if (this.IVL != null) {
            this.IVL.e(str, hashMap);
        }
        this.IVL = null;
        this.activity = null;
        AppMethodBeat.o(78536);
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }

    static /* synthetic */ void a(j jVar, String str) {
        AppMethodBeat.i(78539);
        jVar.d(str, null);
        AppMethodBeat.o(78539);
    }

    static /* synthetic */ void a(j jVar, HashMap hashMap) {
        AppMethodBeat.i(78540);
        jVar.d("", hashMap);
        AppMethodBeat.o(78540);
    }
}
