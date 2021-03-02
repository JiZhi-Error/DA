package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.MenuItem;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.d;
import com.tencent.mm.av.q;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.tt;
import com.tencent.mm.g.a.tw;
import com.tencent.mm.game.report.f;
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.model.ab;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class bk extends bs<g> {
    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 2;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<g>.a aVar) {
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(final Context context, final String str, final br.a aVar) {
        AppMethodBeat.i(210964);
        p.y(new Runnable() {
            /* class com.tencent.mm.plugin.webview.luggage.jsapi.bk.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(210961);
                try {
                    final JSONObject jSONObject = new JSONObject(str);
                    JSONObject optJSONObject = jSONObject.optJSONObject(IssueStorage.COLUMN_EXT_INFO);
                    final String str = "";
                    if (optJSONObject != null) {
                        try {
                            str = URLEncoder.encode(optJSONObject.toString(), ProtocolPackage.ServerEncoding);
                        } catch (UnsupportedEncodingException e2) {
                        }
                    }
                    final e eVar = new e(context, 0, false);
                    eVar.HLX = new o.f() {
                        /* class com.tencent.mm.plugin.webview.luggage.jsapi.bk.AnonymousClass1.AnonymousClass1 */

                        @Override // com.tencent.mm.ui.base.o.f
                        public final void onCreateMMMenu(m mVar) {
                            AppMethodBeat.i(210958);
                            mVar.b(1, context.getString(R.string.ftk), R.raw.bottomsheet_icon_transmit);
                            mVar.b(2, context.getString(R.string.ftl), R.raw.bottomsheet_icon_moment);
                            AppMethodBeat.o(210958);
                        }
                    };
                    eVar.HLY = new o.g() {
                        /* class com.tencent.mm.plugin.webview.luggage.jsapi.bk.AnonymousClass1.AnonymousClass2 */

                        @Override // com.tencent.mm.ui.base.o.g
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                            AppMethodBeat.i(210959);
                            if (menuItem.getItemId() == 1) {
                                JSONObject optJSONObject = jSONObject.optJSONObject("friend");
                                if (optJSONObject != null) {
                                    bk.a(bk.this, context, optJSONObject, str, aVar);
                                }
                                f.a(MMApplicationContext.getContext(), 20, 2001, 2, 2, 0, str);
                            } else {
                                JSONObject optJSONObject2 = jSONObject.optJSONObject("timeline");
                                if (optJSONObject2 != null) {
                                    bk.b(bk.this, context, optJSONObject2, str, aVar);
                                }
                                f.a(MMApplicationContext.getContext(), 20, 2001, 3, 2, 0, str);
                            }
                            eVar.bMo();
                            AppMethodBeat.o(210959);
                        }
                    };
                    eVar.PGl = new e.b() {
                        /* class com.tencent.mm.plugin.webview.luggage.jsapi.bk.AnonymousClass1.AnonymousClass3 */

                        @Override // com.tencent.mm.ui.widget.a.e.b
                        public final void onDismiss() {
                            AppMethodBeat.i(210960);
                            f.a(MMApplicationContext.getContext(), 20, 2001, 1, 28, 0, str);
                            aVar.i(null, null);
                            AppMethodBeat.o(210960);
                        }
                    };
                    eVar.dGm();
                    AppMethodBeat.o(210961);
                } catch (JSONException e3) {
                    Log.printErrStackTrace("MicroMsg.JsApiShareCustomContent", e3, "", new Object[0]);
                    aVar.i(null, null);
                    AppMethodBeat.o(210961);
                }
            }
        });
        AppMethodBeat.o(210964);
    }

    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "shareCustomContent";
    }

    static /* synthetic */ void a(bk bkVar, final Context context, final JSONObject jSONObject, final String str, final br.a aVar) {
        AppMethodBeat.i(210965);
        String optString = jSONObject.optString("title");
        String optString2 = jSONObject.optString("desc");
        String optString3 = jSONObject.optString("img_url");
        String optString4 = jSONObject.optString("link");
        i.baY(optString3);
        HashMap hashMap = new HashMap();
        hashMap.put("img_url", optString3);
        hashMap.put("desc", optString2);
        hashMap.put("title", optString);
        hashMap.put("url", optString4);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("scene_from", 2);
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("webview_params", hashMap);
        intent.putExtra("Retr_Msg_Type", 2);
        c.a((MMActivity) context, ".ui.transmit.SelectConversationUI", intent, 1, new MMActivity.a() {
            /* class com.tencent.mm.plugin.webview.luggage.jsapi.bk.AnonymousClass2 */

            @Override // com.tencent.mm.ui.MMActivity.a
            public final void d(int i2, int i3, Intent intent) {
                String stringExtra;
                boolean z;
                AppMethodBeat.i(210962);
                if (i2 == 1) {
                    String optString = jSONObject.optString("appid");
                    switch (i3) {
                        case -1:
                            if (intent == null) {
                                stringExtra = null;
                            } else {
                                stringExtra = intent.getStringExtra("Select_Conv_User");
                            }
                            if (stringExtra != null && stringExtra.length() != 0) {
                                if (!Util.isNullOrNil(stringExtra)) {
                                    q.bcQ();
                                    Bitmap EP = d.EP(jSONObject.optString("img_url"));
                                    WXMediaMessage ca = bk.ca(jSONObject);
                                    if (EP != null && !EP.isRecycled()) {
                                        Log.i("MicroMsg.JsApiShareCustomContent", "thumb image is not null");
                                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                        EP.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                                        ca.thumbData = byteArrayOutputStream.toByteArray();
                                    }
                                    com.tencent.mm.pluginsdk.model.app.g o = h.o(optString, true, false);
                                    tt ttVar = new tt();
                                    ttVar.eaf.dCE = ca;
                                    ttVar.eaf.appId = optString;
                                    ttVar.eaf.appName = o == null ? "" : o.field_appName;
                                    ttVar.eaf.toUser = stringExtra;
                                    ttVar.eaf.dMG = 2;
                                    ttVar.eaf.eaj = jSONObject.optString("shareUrl");
                                    ttVar.eaf.eak = jSONObject.optString("currentUrl");
                                    ttVar.eaf.eal = jSONObject.optString("preVerifyAppId");
                                    EventCenter.instance.publish(ttVar);
                                    String stringExtra2 = intent.getStringExtra("custom_send_text");
                                    if (!Util.isNullOrNil(stringExtra2)) {
                                        tw twVar = new tw();
                                        twVar.eaq.dkV = stringExtra;
                                        twVar.eaq.content = stringExtra2;
                                        twVar.eaq.type = ab.JG(stringExtra);
                                        twVar.eaq.flags = 0;
                                        EventCenter.instance.publish(twVar);
                                    }
                                    com.tencent.mm.ui.base.h.cD(context, context.getResources().getString(R.string.z0));
                                    z = true;
                                    break;
                                } else {
                                    Log.e("MicroMsg.JsApiShareCustomContent", "toUser is null");
                                    AppMethodBeat.o(210962);
                                    return;
                                }
                            } else {
                                Log.e("MicroMsg.JsApiShareCustomContent", "mmOnActivityResult fail, toUser is null");
                                AppMethodBeat.o(210962);
                                return;
                            }
                            break;
                        default:
                            z = false;
                            break;
                    }
                    f.a(MMApplicationContext.getContext(), 20, 2001, 2, z ? 48 : 56, 0, str);
                    aVar.i(null, null);
                }
                AppMethodBeat.o(210962);
            }
        });
        AppMethodBeat.o(210965);
    }

    static /* synthetic */ void b(bk bkVar, Context context, JSONObject jSONObject, final String str, final br.a aVar) {
        AppMethodBeat.i(210966);
        final MMActivity mMActivity = (MMActivity) context;
        if (mMActivity == null || mMActivity.isFinishing()) {
            Log.w("MicroMsg.JsApiShareCustomContent", "activity is null or finish");
            AppMethodBeat.o(210966);
            return;
        }
        String optString = jSONObject.optString("link");
        if (Util.isNullOrNil(optString)) {
            Log.e("MicroMsg.JsApiShareCustomContent", "link is null");
            AppMethodBeat.o(210966);
            return;
        }
        String optString2 = jSONObject.optString("title");
        String optString3 = jSONObject.optString("img_url");
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_link", optString);
        intent.putExtra("Ksnsupload_title", optString2);
        intent.putExtra("Ksnsupload_imgurl", optString3);
        intent.putExtra("ShareUrlOriginal", optString);
        intent.putExtra("ShareUrlOpen", jSONObject.optString("currentUrl"));
        intent.putExtra("JsAppId", jSONObject.optString("preVerifyAppId"));
        intent.putExtra("need_result", true);
        intent.putExtra("Ksnsupload_type", 1);
        Log.i("MicroMsg.JsApiShareCustomContent", "doTimeline, start activity");
        mMActivity.mmSetOnActivityResultCallback(new MMActivity.a() {
            /* class com.tencent.mm.plugin.webview.luggage.jsapi.bk.AnonymousClass3 */

            @Override // com.tencent.mm.ui.MMActivity.a
            public final void d(int i2, int i3, Intent intent) {
                boolean z;
                AppMethodBeat.i(210963);
                if (i2 == 2) {
                    if (i3 == -1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    f.a(MMApplicationContext.getContext(), 20, 2001, 3, z ? 48 : 56, 0, str);
                    mMActivity.mmSetOnActivityResultCallback(null);
                    aVar.i(null, null);
                }
                AppMethodBeat.o(210963);
            }
        });
        c.a((Context) mMActivity, "sns", ".ui.SnsUploadUI", intent, 2, false);
        AppMethodBeat.o(210966);
    }

    static /* synthetic */ WXMediaMessage ca(JSONObject jSONObject) {
        AppMethodBeat.i(210967);
        WXWebpageObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = jSONObject.optString("link");
        wXWebpageObject.extInfo = jSONObject.optString("review_data");
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXWebpageObject;
        wXMediaMessage.title = jSONObject.optString("title");
        wXMediaMessage.description = jSONObject.optString("desc");
        AppMethodBeat.o(210967);
        return wXMediaMessage;
    }
}
