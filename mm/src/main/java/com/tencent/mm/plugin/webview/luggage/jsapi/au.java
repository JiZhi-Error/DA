package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Toast;
import com.google.android.gms.common.Scopes;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.c;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import org.json.JSONException;
import org.json.JSONObject;

public class au extends bs {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return Scopes.PROFILE;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 2;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b.a aVar) {
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(final Context context, String str, final br.a aVar) {
        AppMethodBeat.i(78604);
        try {
            JSONObject jSONObject = new JSONObject(str);
            final String optString = jSONObject.optString(ch.COL_USERNAME);
            if (optString == null || optString.length() == 0) {
                Log.e("MicroMsg.JsApiProfile", "doProfile fail, username is null");
                aVar.i("fail", null);
                AppMethodBeat.o(78604);
            } else if (Util.isNullOrNil(optString)) {
                p.y(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.luggage.jsapi.au.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(78600);
                        Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.dg5, 3, -1), 0).show();
                        AppMethodBeat.o(78600);
                    }
                });
                aVar.i("fail", null);
                AppMethodBeat.o(78604);
            } else {
                g.aAf();
                if (!a.azo()) {
                    Log.e("MicroMsg.JsApiProfile", "doProfile, MMCore.hasCfgDefaultUin() is false");
                    aVar.i("fail", null);
                    AppMethodBeat.o(78604);
                    return;
                }
                as Kn = ((l) g.af(l.class)).aSN().Kn(optString);
                if (Kn == null || ((int) Kn.gMZ) <= 0) {
                    Kn = ((l) g.af(l.class)).aSN().bjH(optString);
                }
                final Intent intent = new Intent();
                String optString2 = jSONObject.optString("profileReportInfo");
                if (!Util.isNullOrNil(optString2)) {
                    intent.putExtra("key_add_contact_report_info", optString2);
                }
                if (Kn == null || ((int) Kn.gMZ) <= 0) {
                    context.getString(R.string.zb);
                    final q a2 = h.a(context, context.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.webview.luggage.jsapi.au.AnonymousClass2 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(78601);
                            ay.a.iDq.JZ(optString);
                            aVar.i("cancel", null);
                            AppMethodBeat.o(78601);
                        }
                    });
                    ay.a.iDq.a(optString, "", new ay.b.a() {
                        /* class com.tencent.mm.plugin.webview.luggage.jsapi.au.AnonymousClass3 */

                        @Override // com.tencent.mm.model.ay.b.a
                        public final void p(String str, boolean z) {
                            AppMethodBeat.i(78603);
                            if (context == null) {
                                Log.w("MicroMsg.JsApiProfile", "getNow callback, msghandler has already been detached!");
                                aVar.i("fail", null);
                                AppMethodBeat.o(78603);
                                return;
                            }
                            if (a2 != null) {
                                a2.dismiss();
                            }
                            as Kn = ((l) g.af(l.class)).aSN().Kn(str);
                            if (Kn == null || ((int) Kn.gMZ) <= 0) {
                                Kn = ((l) g.af(l.class)).aSN().bjH(str);
                            }
                            if (Kn == null || ((int) Kn.gMZ) <= 0) {
                                z = false;
                            } else {
                                str = Kn.field_username;
                            }
                            if (!z) {
                                p.y(new Runnable() {
                                    /* class com.tencent.mm.plugin.webview.luggage.jsapi.au.AnonymousClass3.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(78602);
                                        Toast.makeText(MMApplicationContext.getContext(), context.getString(R.string.dg5, 3, -1), 0).show();
                                        AppMethodBeat.o(78602);
                                    }
                                });
                                aVar.i("fail", null);
                                AppMethodBeat.o(78603);
                                return;
                            }
                            c.ap(str, 3);
                            com.tencent.mm.aj.p.aYD().Mg(str);
                            intent.addFlags(268435456);
                            intent.putExtra("Contact_User", str);
                            if (Kn.gBM()) {
                                com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10298, Kn.field_username + ",42");
                                intent.putExtra("Contact_Scene", 42);
                            }
                            com.tencent.mm.plugin.webview.a.a.jRt.c(intent, context);
                            aVar.i(null, null);
                            AppMethodBeat.o(78603);
                        }
                    });
                    AppMethodBeat.o(78604);
                    return;
                }
                intent.addFlags(268435456);
                intent.putExtra("Contact_User", Kn.field_username);
                if (Kn.gBM()) {
                    intent.putExtra("Contact_Scene", 42);
                }
                if (com.tencent.mm.contact.c.oR(Kn.field_type)) {
                    uj ujVar = new uj();
                    ujVar.eaI.intent = intent;
                    ujVar.eaI.username = Kn.field_username;
                    EventCenter.instance.publish(ujVar);
                }
                com.tencent.mm.plugin.webview.a.a.jRt.c(intent, context);
                aVar.i(null, null);
                AppMethodBeat.o(78604);
            }
        } catch (JSONException e2) {
            Log.e("MicroMsg.JsApiProfile", "parase json fail");
            aVar.i("fail", null);
            AppMethodBeat.o(78604);
        }
    }
}
