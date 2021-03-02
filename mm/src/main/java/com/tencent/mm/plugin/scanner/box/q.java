package com.tencent.mm.plugin.scanner.box;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.appbrand.jsapi.share.o;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.h;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0007J\b\u0010\f\u001a\u00020\nH\u0002J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0007J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0007J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0007J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0007J\u0006\u0010\u0014\u001a\u00020\nJ\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0017J\u0012\u0010\u0018\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0012\u0010\u001b\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0007J\u0012\u0010\u001c\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0007J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/scanner/box/ScanBoxWebViewJSApi;", "Lcom/tencent/mm/plugin/scanner/box/BaseBoxWebViewJSApi;", "uiComponent", "Lcom/tencent/mm/plugin/box/ui/IBoxHomeUIComponent;", "(Lcom/tencent/mm/plugin/box/ui/IBoxHomeUIComponent;)V", "getContactUserName", "", "progressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "closePage", "", NativeProtocol.WEB_DIALOG_PARAMS, "dismissProgressDialog", "doOpenProfilePage", "", ch.COL_USERNAME, "openAdPage", "openProfilePage", "openVideoPage", "openWebView", "release", "setReportData", "data", "Landroid/os/Bundle;", "showProgressDialog", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", o.NAME, "updateShareData", "viewContactProfile", "intent", "Landroid/content/Intent;", "Companion", "plugin-scan_release"})
public final class q extends a {
    public static final a CDp = new a((byte) 0);
    private String CDo;
    private com.tencent.mm.ui.base.q gut;
    private final com.tencent.mm.plugin.box.c.b plU;

    static {
        AppMethodBeat.i(52144);
        AppMethodBeat.o(52144);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/scanner/box/ScanBoxWebViewJSApi$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void a(q qVar, Intent intent) {
        AppMethodBeat.i(240315);
        qVar.aR(intent);
        AppMethodBeat.o(240315);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q(com.tencent.mm.plugin.box.c.b bVar) {
        super(bVar);
        p.h(bVar, "uiComponent");
        AppMethodBeat.i(52143);
        this.plU = bVar;
        AppMethodBeat.o(52143);
    }

    public static void av(Bundle bundle) {
        AppMethodBeat.i(240305);
        p.h(bundle, "data");
        n.av(bundle);
        AppMethodBeat.o(240305);
    }

    public static void release() {
        AppMethodBeat.i(240306);
        n.ePw();
        AppMethodBeat.o(240306);
    }

    @JavascriptInterface
    public final void openWebView(String str) {
        AppMethodBeat.i(52140);
        p.h(str, NativeProtocol.WEB_DIALOG_PARAMS);
        Log.i("MicroMsg.ScanBoxWebViewJSApi", "alvinluo openWebView %s", str);
        try {
            String optString = new JSONObject(str).optString("url", "");
            Intent intent = new Intent();
            intent.putExtra("rawUrl", optString);
            intent.putExtra("geta8key_scene", 67);
            Context activityContext = this.plU.getActivityContext();
            if (activityContext != null) {
                com.tencent.mm.br.c.b(activityContext, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.o(52140);
                return;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ScanBoxWebViewJSApi", e2, "alvinluo openWebView exception", new Object[0]);
        }
        AppMethodBeat.o(52140);
    }

    @JavascriptInterface
    public final void openAdPage(String str) {
        AppMethodBeat.i(240307);
        p.h(str, NativeProtocol.WEB_DIALOG_PARAMS);
        Log.d("MicroMsg.ScanBoxWebViewJSApi", "alvinluo openAdPage %s", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("adXml", "");
            String optString2 = jSONObject.optString("uxinfo", "");
            Log.i("MicroMsg.ScanBoxWebViewJSApi", "openAdPage, adXml=".concat(String.valueOf(optString)));
            Intent intent = new Intent();
            intent.putExtra("sns_landing_pages_xml", optString);
            intent.putExtra("sns_landig_pages_from_source", 14);
            intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
            intent.putExtra("sns_landing_pages_ux_info", optString2);
            if (this.plU.getActivityContext() != null) {
                com.tencent.mm.br.c.b(this.plU.getActivityContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent);
                AppMethodBeat.o(240307);
                return;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ScanBoxWebViewJSApi", e2, "alvinluo openAdPage exception", new Object[0]);
        }
        AppMethodBeat.o(240307);
    }

    @JavascriptInterface
    public final void openProfilePage(String str) {
        boolean z;
        bv aSN;
        AppMethodBeat.i(240308);
        p.h(str, NativeProtocol.WEB_DIALOG_PARAMS);
        Log.d("MicroMsg.ScanBoxWebViewJSApi", "alvinluo openProfilePage %s", str);
        try {
            String optString = new JSONObject(str).optString(ch.COL_USERNAME, "");
            String str2 = optString;
            if (str2 == null || str2.length() == 0) {
                Log.e("MicroMsg.ScanBoxWebViewJSApi", "doOpenProfilePage fail, username is null");
                Toast.makeText(this.plU.getActivityContext(), this.plU.getActivityContext().getString(R.string.dg5, 3, -1), 0).show();
                z = false;
            } else {
                z.f fVar = new z.f();
                com.tencent.mm.plugin.messenger.foundation.a.l lVar = (com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
                fVar.SYG = (lVar == null || (aSN = lVar.aSN()) == null) ? null : (T) aSN.Kn(optString);
                if (fVar.SYG == null || fVar.SYG.arH() <= 0) {
                    com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
                    p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
                    fVar.SYG = (T) ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().bjH(optString);
                }
                Intent intent = new Intent();
                if (fVar.SYG == null || fVar.SYG.arH() <= 0) {
                    String str3 = this.CDo;
                    if (!(str3 == null || str3.length() == 0)) {
                        ay.a.aVo().JZ(this.CDo);
                    }
                    this.CDo = optString;
                    ay.a.aVo().a(optString, "", new c(this, fVar, intent));
                    this.gut = h.a(this.plU.getActivityContext(), this.plU.getActivityContext().getString(R.string.a06), true, (DialogInterface.OnCancelListener) new d(optString));
                    z = true;
                } else {
                    intent.addFlags(268435456);
                    intent.putExtra("Contact_User", fVar.SYG.getUsername());
                    if (fVar.SYG.gBM()) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10298, fVar.SYG.getUsername() + ",300");
                        intent.putExtra("Contact_Scene", 300);
                    }
                    if (fVar.SYG.arv()) {
                        uj ujVar = new uj();
                        ujVar.eaI.intent = intent;
                        ujVar.eaI.username = fVar.SYG.getUsername();
                        EventCenter.instance.publish(ujVar);
                    }
                    aR(intent);
                    z = true;
                }
            }
            Log.i("MicroMsg.ScanBoxWebViewJSApi", "alvinluo openProfilePage result: %b", Boolean.valueOf(z));
            AppMethodBeat.o(240308);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ScanBoxWebViewJSApi", e2, "alvinluo openProfilePage exception", new Object[0]);
            AppMethodBeat.o(240308);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "userName", "", "kotlin.jvm.PlatformType", "succ", "", "getContactCallBack"})
    static final class c implements ay.b.a {
        final /* synthetic */ Intent $intent;
        final /* synthetic */ q CDq;
        final /* synthetic */ z.f CDr;

        c(q qVar, z.f fVar, Intent intent) {
            this.CDq = qVar;
            this.CDr = fVar;
            this.$intent = intent;
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x0074  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x00b4  */
        @Override // com.tencent.mm.model.ay.b.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void p(java.lang.String r9, boolean r10) {
            /*
            // Method dump skipped, instructions count: 281
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.scanner.box.q.c.p(java.lang.String, boolean):void");
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class d implements DialogInterface.OnCancelListener {
        final /* synthetic */ String hLl;

        d(String str) {
            this.hLl = str;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(240304);
            Log.i("MicroMsg.ScanBoxWebViewJSApi", "alvinluo doOpenProfilePage user cancel");
            ay.a.aVo().JZ(this.hLl);
            AppMethodBeat.o(240304);
        }
    }

    private final void aR(Intent intent) {
        AppMethodBeat.i(240309);
        com.tencent.mm.br.c.b(this.plU.getActivityContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
        AppMethodBeat.o(240309);
    }

    @JavascriptInterface
    public final void openVideoPage(String str) {
        AppMethodBeat.i(240310);
        p.h(str, NativeProtocol.WEB_DIALOG_PARAMS);
        Log.i("MicroMsg.ScanBoxWebViewJSApi", "openVideoPage param = ".concat(String.valueOf(str)));
        try {
            String optString = new JSONObject(str).optString("videoUrl", "");
            if (Util.isNullOrNil(optString)) {
                Log.i("MicroMsg.ScanBoxWebViewJSApi", "openVideoPage videoUrl null");
                AppMethodBeat.o(240310);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("rawUrl", optString);
            Context activityContext = this.plU.getActivityContext();
            if (activityContext != null) {
                com.tencent.mm.br.c.b(activityContext, "brandservice", ".ui.timeline.video.lite.VideoLiteUI", intent);
                AppMethodBeat.o(240310);
                return;
            }
            AppMethodBeat.o(240310);
        } catch (Exception e2) {
        }
    }

    @JavascriptInterface
    public final void closePage(String str) {
        AppMethodBeat.i(240311);
        Log.i("MicroMsg.ScanBoxWebViewJSApi", "scanBoxJsApi closePage: %s", str);
        com.tencent.f.h.RTc.aV(new b(this));
        AppMethodBeat.o(240311);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ q CDq;

        b(q qVar) {
            this.CDq = qVar;
        }

        public final void run() {
            AppMethodBeat.i(240302);
            this.CDq.plU.dismiss();
            AppMethodBeat.o(240302);
        }
    }

    @JavascriptInterface
    public final void updateShareData(String str) {
        AppMethodBeat.i(240312);
        Log.i("MicroMsg.ScanBoxWebViewJSApi", "scanBoxJsApi updateShareData: %s", str);
        n.updateShareData(str);
        AppMethodBeat.o(240312);
    }

    @JavascriptInterface
    public final void showShareMenu(String str) {
        AppMethodBeat.i(240313);
        Log.i("MicroMsg.ScanBoxWebViewJSApi", "scanBoxJsApi showShareMenu: %s", str);
        Context activityContext = this.plU.getActivityContext();
        p.g(activityContext, "uiComponent.activityContext");
        n.bu(activityContext, str);
        AppMethodBeat.o(240313);
    }

    public static final /* synthetic */ void c(q qVar) {
        AppMethodBeat.i(240314);
        com.tencent.mm.ui.base.q qVar2 = qVar.gut;
        if (qVar2 != null) {
            qVar2.dismiss();
            AppMethodBeat.o(240314);
            return;
        }
        AppMethodBeat.o(240314);
    }
}
