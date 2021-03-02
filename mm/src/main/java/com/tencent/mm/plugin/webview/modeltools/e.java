package com.tencent.mm.plugin.webview.modeltools;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.tf;
import com.tencent.mm.g.a.th;
import com.tencent.mm.g.a.tl;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public final class e {
    private a JaA;
    private IListener JaB = new IListener<tl>() {
        /* class com.tencent.mm.plugin.webview.modeltools.e.AnonymousClass1 */

        {
            AppMethodBeat.i(160423);
            this.__eventId = tl.class.getName().hashCode();
            AppMethodBeat.o(160423);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(tl tlVar) {
            AppMethodBeat.i(79126);
            tl tlVar2 = tlVar;
            if ((tlVar2 instanceof tl) && tlVar2.dZU.cSx == 1) {
                e.a(e.this, e.this.Jaz);
                e.a(e.this);
            }
            AppMethodBeat.o(79126);
            return false;
        }
    };
    private IListener JaC = new IListener<th>() {
        /* class com.tencent.mm.plugin.webview.modeltools.e.AnonymousClass3 */

        {
            AppMethodBeat.i(160425);
            this.__eventId = th.class.getName().hashCode();
            AppMethodBeat.o(160425);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(th thVar) {
            AppMethodBeat.i(79130);
            boolean a2 = a(thVar);
            AppMethodBeat.o(79130);
            return a2;
        }

        private boolean a(th thVar) {
            AppMethodBeat.i(79129);
            if ((thVar instanceof th) && e.this.Jaz.equalsIgnoreCase(thVar.dZJ.cardType)) {
                if (thVar.dZJ.dZK == 0) {
                    e.b(e.this, e.this.Jaz);
                } else if (thVar.dZJ.dZK == 2) {
                    e.a(e.this, e.this.Jaz);
                } else {
                    try {
                        if (!Util.isNullOrNil(thVar.dZJ.dZL)) {
                            e.a(e.this, e.this.Jaz, new JSONObject(thVar.dZJ.dZL), thVar.dZJ.dZM);
                        } else {
                            e.a(e.this, e.this.Jaz, null, thVar.dZJ.dZM);
                        }
                    } catch (Exception e2) {
                        Log.e("MicroMsg.LicenceScanner", "Failed to parse json string: %s", e2.getMessage());
                        e.b(e.this, e.this.Jaz);
                    }
                }
                e.a(e.this);
            }
            AppMethodBeat.o(79129);
            return false;
        }
    };
    String Jaz = null;
    private IListener scanBankCardConfirmResultListener = new IListener<tf>() {
        /* class com.tencent.mm.plugin.webview.modeltools.e.AnonymousClass2 */

        {
            AppMethodBeat.i(160424);
            this.__eventId = tf.class.getName().hashCode();
            AppMethodBeat.o(160424);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* bridge */ /* synthetic */ boolean callback(tf tfVar) {
            AppMethodBeat.i(79128);
            boolean callback = callback(tfVar);
            AppMethodBeat.o(79128);
            return callback;
        }

        private boolean callback(tf tfVar) {
            AppMethodBeat.i(79127);
            if ((tfVar instanceof tf) && "bank".equals(e.this.Jaz)) {
                if (tfVar.dZF.action == 0) {
                    e.a(e.this, e.this.Jaz);
                } else if (tfVar.dZF.action == 1) {
                    if (Util.isNullOrNil(tfVar.dZF.cardNum)) {
                        e.b(e.this, e.this.Jaz);
                    } else {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("bankcard_number", tfVar.dZF.cardNum);
                            e.a(e.this, e.this.Jaz, jSONObject, null);
                        } catch (JSONException e2) {
                            Log.e("MicroMsg.LicenceScanner", "type = bankcard, add cardNum into json, exp = %s ", e2);
                            e.b(e.this, e.this.Jaz);
                        }
                    }
                }
                e.a(e.this);
            }
            AppMethodBeat.o(79127);
            return false;
        }
    };

    public interface a {
        void a(String str, JSONObject jSONObject, Bitmap bitmap);

        void aZq(String str);

        void aas(String str);
    }

    public e() {
        AppMethodBeat.i(79131);
        AppMethodBeat.o(79131);
    }

    public final boolean a(String str, Context context, a aVar) {
        AppMethodBeat.i(79132);
        if ("bank".equalsIgnoreCase(str)) {
            Intent intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", 7);
            intent.putExtra("scan_bankcard_with_confirm_ui", true);
            intent.addFlags(268435456);
            c.b(context, "scanner", ".ui.ScanCardUI", intent);
            this.JaA = aVar;
            this.Jaz = "bank";
            EventCenter.instance.addListener(this.JaB);
            EventCenter.instance.addListener(this.scanBankCardConfirmResultListener);
            AppMethodBeat.o(79132);
            return true;
        } else if ("identity_pay_auth".equalsIgnoreCase(str)) {
            Intent intent2 = new Intent();
            intent2.putExtra("BaseScanUI_select_scan_mode", 11);
            c.b(context, "scanner", ".ui.ScanCardUI", intent2);
            this.JaA = aVar;
            this.Jaz = "identity_pay_auth";
            EventCenter.instance.addListener(this.JaB);
            EventCenter.instance.addListener(this.JaC);
            AppMethodBeat.o(79132);
            return true;
        } else {
            AppMethodBeat.o(79132);
            return false;
        }
    }

    static /* synthetic */ void a(e eVar, String str) {
        AppMethodBeat.i(79133);
        if (eVar.JaA != null) {
            eVar.JaA.aZq(str);
        }
        AppMethodBeat.o(79133);
    }

    static /* synthetic */ void a(e eVar) {
        AppMethodBeat.i(79134);
        eVar.JaA = null;
        EventCenter.instance.removeListener(eVar.JaB);
        EventCenter.instance.removeListener(eVar.scanBankCardConfirmResultListener);
        EventCenter.instance.removeListener(eVar.JaC);
        AppMethodBeat.o(79134);
    }

    static /* synthetic */ void b(e eVar, String str) {
        AppMethodBeat.i(79135);
        if (eVar.JaA != null) {
            eVar.JaA.aas(str);
        }
        AppMethodBeat.o(79135);
    }

    static /* synthetic */ void a(e eVar, String str, JSONObject jSONObject, Bitmap bitmap) {
        AppMethodBeat.i(79136);
        if (eVar.JaA != null) {
            eVar.JaA.a(str, jSONObject, bitmap);
        }
        AppMethodBeat.o(79136);
    }
}
