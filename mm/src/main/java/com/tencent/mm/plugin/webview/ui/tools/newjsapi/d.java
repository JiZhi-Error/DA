package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.smtt.sdk.WebView;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiConfirmDialog;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "parseColor", "color", "plugin-webview_release"})
public final class d extends com.tencent.mm.plugin.webview.d.c.a {
    private static final int CDJ = 343;
    public static final d JwZ = new d();
    private static final String TAG = TAG;
    private static final String edq = edq;

    static {
        AppMethodBeat.i(175678);
        AppMethodBeat.o(175678);
    }

    private d() {
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final int ePA() {
        return CDJ;
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final String ePz() {
        return edq;
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final boolean a(f fVar, n nVar) {
        AppMethodBeat.i(210584);
        p.h(fVar, "env");
        p.h(nVar, "msg");
        HashMap hashMap = new HashMap();
        try {
            d.a aVar = new d.a(fVar.context);
            JSONObject jSONObject = nVar.ISf;
            if (jSONObject.has("title")) {
                aVar.bon(jSONObject.getString("title"));
            }
            if (jSONObject.has("titleDesc")) {
                aVar.aA(jSONObject.getString("titleDesc"));
            }
            if (jSONObject.has("titleColor")) {
                String string = jSONObject.getString("titleColor");
                p.g(string, "rawParams.getString(KEY_TITLE_COLOR)");
                aVar.aoP(Color.parseColor(string) | WebView.NIGHT_MODE_COLOR);
            }
            if (jSONObject.has("titleMaxLine")) {
                aVar.aoQ(jSONObject.getInt("titleMaxLine"));
            }
            if (jSONObject.has("titleGravity")) {
                aVar.aoR(jSONObject.getInt("titleGravity"));
            }
            if (jSONObject.has("msg")) {
                aVar.boo(jSONObject.getString("msg"));
            }
            if (jSONObject.has("msgSubTitle")) {
                aVar.aB(jSONObject.getString("msgSubTitle"));
            }
            if (jSONObject.has("msgSubDesc")) {
                aVar.bop(jSONObject.getString("msgSubDesc"));
            }
            if (jSONObject.has("msgMaxLine")) {
                aVar.aoT(jSONObject.getInt("msgMaxLine"));
            }
            if (jSONObject.has("msgIconBase64")) {
                byte[] decode = Base64.decode(jSONObject.getString("msgIconBase64"), 0);
                aVar.aN(BitmapFactory.decodeByteArray(decode, 0, decode.length));
            } else if (jSONObject.has("msgIconUrl")) {
                aVar.aN(Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888));
            }
            if (jSONObject.has("contentDesc")) {
                aVar.bor(jSONObject.getString("contentDesc"));
            }
            if (jSONObject.has("contentDescGravity")) {
                aVar.aoU(jSONObject.getInt("contentDescGravity"));
            }
            if (jSONObject.has("confirmText")) {
                aVar.bou(jSONObject.getString("confirmText"));
            }
            if (jSONObject.has("confirmTextColor")) {
                String string2 = jSONObject.getString("confirmTextColor");
                p.g(string2, "rawParams.getString(KEY_CONFIRM_COLOR)");
                aVar.aoX(Color.parseColor(string2) | WebView.NIGHT_MODE_COLOR);
            }
            if (jSONObject.has("cancelText")) {
                aVar.bov(jSONObject.getString("cancelText"));
            }
            if (jSONObject.has("cancelTextColor")) {
                String string3 = jSONObject.getString("cancelTextColor");
                p.g(string3, "rawParams.getString(KEY_CANCEL_COLOR)");
                aVar.aoY(Color.parseColor(string3) | WebView.NIGHT_MODE_COLOR);
            }
            aVar.f(new a(fVar, nVar, hashMap));
            aVar.a(new b(fVar, nVar, hashMap));
            aVar.c(new c(fVar, nVar, hashMap));
            aVar.d(new DialogInterface$OnClickListenerC2000d(fVar, nVar, hashMap));
            com.tencent.mm.ac.d.h(new e(aVar, jSONObject, "msgIconUrl"));
            AppMethodBeat.o(210584);
            return true;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "doConfirmDialog", new Object[0]);
            fVar.IQZ.h(nVar.ISe, nVar.mhO + ":err", hashMap);
            AppMethodBeat.o(210584);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class a implements DialogInterface.OnCancelListener {
        final /* synthetic */ f CDE;
        final /* synthetic */ HashMap Jxa;
        final /* synthetic */ n pGr;

        a(f fVar, n nVar, HashMap hashMap) {
            this.CDE = fVar;
            this.pGr = nVar;
            this.Jxa = hashMap;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(175673);
            this.CDE.IQZ.h(this.pGr.ISe, this.pGr.mhO + ":cancelled", this.Jxa);
            AppMethodBeat.o(175673);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    static final class b implements DialogInterface.OnDismissListener {
        final /* synthetic */ f CDE;
        final /* synthetic */ HashMap Jxa;
        final /* synthetic */ n pGr;

        b(f fVar, n nVar, HashMap hashMap) {
            this.CDE = fVar;
            this.pGr = nVar;
            this.Jxa = hashMap;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.i(175674);
            this.CDE.IQZ.h(this.pGr.ISe, this.pGr.mhO + ":dismiss", this.Jxa);
            AppMethodBeat.o(175674);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    static final class c implements DialogInterface.OnClickListener {
        final /* synthetic */ f CDE;
        final /* synthetic */ HashMap Jxa;
        final /* synthetic */ n pGr;

        c(f fVar, n nVar, HashMap hashMap) {
            this.CDE = fVar;
            this.pGr = nVar;
            this.Jxa = hashMap;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(175675);
            this.CDE.IQZ.h(this.pGr.ISe, this.pGr.mhO + ":ok", this.Jxa);
            AppMethodBeat.o(175675);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.newjsapi.d$d  reason: collision with other inner class name */
    static final class DialogInterface$OnClickListenerC2000d implements DialogInterface.OnClickListener {
        final /* synthetic */ f CDE;
        final /* synthetic */ HashMap Jxa;
        final /* synthetic */ n pGr;

        DialogInterface$OnClickListenerC2000d(f fVar, n nVar, HashMap hashMap) {
            this.CDE = fVar;
            this.pGr = nVar;
            this.Jxa = hashMap;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(175676);
            this.CDE.IQZ.h(this.pGr.ISe, this.pGr.mhO + ":no", this.Jxa);
            AppMethodBeat.o(175676);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d.a Jxb;
        final /* synthetic */ JSONObject Jxc;
        final /* synthetic */ String Jxd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(d.a aVar, JSONObject jSONObject, String str) {
            super(0);
            this.Jxb = aVar;
            this.Jxc = jSONObject;
            this.Jxd = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(210583);
            com.tencent.mm.ui.widget.a.d hbn = this.Jxb.hbn();
            if (this.Jxc.has(this.Jxd)) {
                p.g(hbn, "alert");
                com.tencent.mm.av.a.a.bdb().a(this.Jxc.getString(this.Jxd), hbn.hbm(), new c.a().bdp().bdv());
            }
            hbn.show();
            x xVar = x.SXb;
            AppMethodBeat.o(210583);
            return xVar;
        }
    }
}
