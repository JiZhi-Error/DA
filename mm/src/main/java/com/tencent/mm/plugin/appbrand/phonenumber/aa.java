package com.tencent.mm.plugin.appbrand.phonenumber;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.phonenumber.c;
import com.tencent.mm.plugin.appbrand.widget.sms.EditVerifyCodeView;
import com.tencent.mm.protocal.protobuf.dul;
import com.tencent.mm.protocal.protobuf.zy;
import com.tencent.mm.protocal.protobuf.zz;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\u0018\u0000 >2\u00020\u0001:\u0003>?@B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0005H\u0002J\u0012\u0010*\u001a\u00020(2\b\b\u0002\u0010+\u001a\u00020,H\u0002J&\u0010-\u001a\u00020(2\b\u0010.\u001a\u0004\u0018\u00010\u00052\b\u0010/\u001a\u0004\u0018\u00010\u00052\b\u00100\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u00101\u001a\u00020(2\u0006\u00102\u001a\u00020\u0005H\u0002J.\u00103\u001a\u00020(2\u0006\u00104\u001a\u00020\u000f2\b\u0010.\u001a\u0004\u0018\u00010\u00052\b\u0010/\u001a\u0004\u0018\u00010\u00052\b\u00100\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u00105\u001a\u00020(2\u0006\u00104\u001a\u00020\u000fH\u0002J\b\u00106\u001a\u00020(H\u0002J\u0010\u00107\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0005H\u0002J\b\u00108\u001a\u00020(H\u0002J\b\u00109\u001a\u00020(H\u0002J\b\u0010:\u001a\u00020(H\u0002J\b\u0010;\u001a\u00020(H\u0002J\u0006\u0010<\u001a\u00020(J\b\u0010=\u001a\u00020(H\u0002R\u000e\u0010\u000e\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0010\u0010 \u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0018\u00010&R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog;", "", "context", "Landroid/content/Context;", "appId", "", "report", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "ext_desc", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "onVerifyCallback", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;Ljava/lang/String;Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;)V", "INTERVAL_UPDATE_TIME", "", "MAX_WAIT_TIME", "getAppId", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "getExt_desc", "mobileTV", "Landroid/widget/TextView;", "getOnVerifyCallback", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;", "getPhoneItem", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getReport", "()Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "setReport", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;)V", "sendCodeTV", "smsEditView", "Lcom/tencent/mm/plugin/appbrand/widget/sms/EditVerifyCodeView;", "verifyCodeView", "Landroid/view/View;", "verifyTime", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$VertifyTimer;", "doFailCallback", "", "errMsg", "doSendVerifyCode", "isFirst", "", "doSuccessCallback", "encryptedData", "iv", "cloudId", "doVerifyCode", TMQQDownloaderOpenSDKConst.UINTYPE_CODE, "handleCheckVerifyCodeStatus", "status", "handleSendVerifyCodeStatus", "hideVKB", "showErrorTips", "showVKB", "showVerifyMobileDialog", "startSmsListener", "stopSmsListener", "tryShow", "updateSendText", "Companion", "OnVerifyCallback", "VertifyTimer", "luggage-wechat-full-sdk_release"})
public final class aa {
    public static final a nBr = new a((byte) 0);
    private final int MAX_WAIT_TIME = 60000;
    private final String appId;
    final Context context;
    private TextView kbG;
    private View nBi;
    private EditVerifyCodeView nBj;
    private TextView nBk;
    private c nBl;
    private final int nBm = 1000;
    y nBn;
    private final String nBo;
    final PhoneItem nBp;
    private final b nBq;

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H&¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;", "", "onVerifyCallback", "", "isSuccess", "", "result", "", "", "luggage-wechat-full-sdk_release"})
    public interface b {
        void a(boolean z, Map<String, String> map);
    }

    static {
        AppMethodBeat.i(148199);
        AppMethodBeat.o(148199);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "invoke"})
    public static final class d extends q implements kotlin.g.a.b<dul, x> {
        final /* synthetic */ aa nBs;
        final /* synthetic */ ProgressDialog nBt;
        final /* synthetic */ boolean nBu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(aa aaVar, ProgressDialog progressDialog, boolean z) {
            super(1);
            this.nBs = aaVar;
            this.nBt = progressDialog;
            this.nBu = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(dul dul) {
            AppMethodBeat.i(148170);
            final dul dul2 = dul;
            this.nBt.dismiss();
            if (dul2 == null) {
                Log.e("MicroMsg.PhoneNumberVerifyCodeDialog", "getPhoneNumber SendVerifyCode cgi failed");
                MMHandlerThread.postToMainThread(new Runnable(this) {
                    /* class com.tencent.mm.plugin.appbrand.phonenumber.aa.d.AnonymousClass1 */
                    final /* synthetic */ d nBv;

                    {
                        this.nBv = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(148168);
                        aa aaVar = this.nBv.nBs;
                        h hVar = h.nzb;
                        aa.a(aaVar, h.bTl());
                        AppMethodBeat.o(148168);
                    }
                });
                aa.b(this.nBs, "SendVerifyCode cgi fail");
            } else {
                Log.i("MicroMsg.PhoneNumberVerifyCodeDialog", "SendVerifyCode cgi success");
                MMHandlerThread.postToMainThread(new Runnable(this) {
                    /* class com.tencent.mm.plugin.appbrand.phonenumber.aa.d.AnonymousClass2 */
                    final /* synthetic */ d nBv;

                    {
                        this.nBv = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(148169);
                        if (this.nBv.nBu) {
                            aa.g(this.nBv.nBs);
                        }
                        aa.a(this.nBv.nBs, dul2.status);
                        AppMethodBeat.o(148169);
                    }
                });
            }
            x xVar = x.SXb;
            AppMethodBeat.o(148170);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/SendVerifyCodeResp;", "invoke"})
    public static final class e extends q implements kotlin.g.a.b<dul, x> {
        final /* synthetic */ aa nBs;
        final /* synthetic */ ProgressDialog nBt;
        final /* synthetic */ boolean nBu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(aa aaVar, ProgressDialog progressDialog, boolean z) {
            super(1);
            this.nBs = aaVar;
            this.nBt = progressDialog;
            this.nBu = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(dul dul) {
            AppMethodBeat.i(148174);
            final dul dul2 = dul;
            com.tencent.mm.plugin.appbrand.ac.m.runOnUiThread(new Runnable(this) {
                /* class com.tencent.mm.plugin.appbrand.phonenumber.aa.e.AnonymousClass1 */
                final /* synthetic */ e nBx;

                {
                    this.nBx = r1;
                }

                public final void run() {
                    AppMethodBeat.i(148171);
                    this.nBx.nBt.dismiss();
                    AppMethodBeat.o(148171);
                }
            });
            if (dul2 == null) {
                Log.e("MicroMsg.PhoneNumberVerifyCodeDialog", "getPhoneNumber SendVerifyCode cgi failed");
                aa.b(this.nBs, "SendVerifyCode cgi fail");
                MMHandlerThread.postToMainThread(new Runnable(this) {
                    /* class com.tencent.mm.plugin.appbrand.phonenumber.aa.e.AnonymousClass2 */
                    final /* synthetic */ e nBx;

                    {
                        this.nBx = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(148172);
                        aa aaVar = this.nBx.nBs;
                        h hVar = h.nzb;
                        aa.a(aaVar, h.bTl());
                        AppMethodBeat.o(148172);
                    }
                });
            } else {
                Log.i("MicroMsg.PhoneNumberVerifyCodeDialog", "SendVerifyCode cgi success");
                MMHandlerThread.postToMainThread(new Runnable(this) {
                    /* class com.tencent.mm.plugin.appbrand.phonenumber.aa.e.AnonymousClass3 */
                    final /* synthetic */ e nBx;

                    {
                        this.nBx = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(148173);
                        if (this.nBx.nBu) {
                            aa.g(this.nBx.nBs);
                        }
                        aa.a(this.nBx.nBs, dul2.status);
                        AppMethodBeat.o(148173);
                    }
                });
            }
            x xVar = x.SXb;
            AppMethodBeat.o(148174);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;", "invoke"})
    public static final class f extends q implements kotlin.g.a.b<zz, x> {
        final /* synthetic */ aa nBs;
        final /* synthetic */ ProgressDialog nzJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(aa aaVar, ProgressDialog progressDialog) {
            super(1);
            this.nBs = aaVar;
            this.nzJ = progressDialog;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(zz zzVar) {
            AppMethodBeat.i(148177);
            final zz zzVar2 = zzVar;
            this.nzJ.dismiss();
            if (zzVar2 == null) {
                Log.e("MicroMsg.PhoneNumberVerifyCodeDialog", "getPhoneNumber checkVerifyCode cgi failed");
                aa.b(this.nBs, "checkVerifyCode cgi fail");
                y yVar = this.nBs.nBn;
                if (yVar != null) {
                    y yVar2 = this.nBs.nBn;
                    Long valueOf = yVar2 != null ? Long.valueOf(yVar2.nBd) : null;
                    if (valueOf == null) {
                        p.hyc();
                    }
                    yVar.nBd = valueOf.longValue() + 1;
                }
                MMHandlerThread.postToMainThread(new Runnable(this) {
                    /* class com.tencent.mm.plugin.appbrand.phonenumber.aa.f.AnonymousClass1 */
                    final /* synthetic */ f nBy;

                    {
                        this.nBy = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(148175);
                        aa aaVar = this.nBy.nBs;
                        h hVar = h.nzb;
                        aa.a(aaVar, h.bTl(), "", "", "");
                        AppMethodBeat.o(148175);
                    }
                });
            } else {
                Log.i("MicroMsg.PhoneNumberVerifyCodeDialog", "checkVerifyCode success");
                MMHandlerThread.postToMainThread(new Runnable(this) {
                    /* class com.tencent.mm.plugin.appbrand.phonenumber.aa.f.AnonymousClass2 */
                    final /* synthetic */ f nBy;

                    {
                        this.nBy = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(148176);
                        aa.a(this.nBy.nBs, zzVar2.status, zzVar2.nzu, zzVar2.bxK, zzVar2.nzv);
                        AppMethodBeat.o(148176);
                    }
                });
            }
            x xVar = x.SXb;
            AppMethodBeat.o(148177);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "resp", "Lcom/tencent/mm/protocal/protobuf/CheckVerifyCodeResp;", "invoke"})
    public static final class g extends q implements kotlin.g.a.b<zz, x> {
        final /* synthetic */ aa nBs;
        final /* synthetic */ ProgressDialog nzJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(aa aaVar, ProgressDialog progressDialog) {
            super(1);
            this.nBs = aaVar;
            this.nzJ = progressDialog;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(zz zzVar) {
            AppMethodBeat.i(148180);
            final zz zzVar2 = zzVar;
            this.nzJ.dismiss();
            if (zzVar2 == null) {
                Log.e("MicroMsg.PhoneNumberVerifyCodeDialog", "getPhoneNumber checkVerifyCode cgi fail");
                aa.b(this.nBs, "checkVerifyCode cgi fail");
                y yVar = this.nBs.nBn;
                if (yVar != null) {
                    y yVar2 = this.nBs.nBn;
                    Long valueOf = yVar2 != null ? Long.valueOf(yVar2.nBd) : null;
                    if (valueOf == null) {
                        p.hyc();
                    }
                    yVar.nBd = valueOf.longValue() + 1;
                }
                MMHandlerThread.postToMainThread(new Runnable(this) {
                    /* class com.tencent.mm.plugin.appbrand.phonenumber.aa.g.AnonymousClass1 */
                    final /* synthetic */ g nBA;

                    {
                        this.nBA = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(148178);
                        aa aaVar = this.nBA.nBs;
                        h hVar = h.nzb;
                        aa.a(aaVar, h.bTl(), "", "", "");
                        AppMethodBeat.o(148178);
                    }
                });
            } else {
                Log.i("MicroMsg.PhoneNumberVerifyCodeDialog", "checkVerifyCode success");
                MMHandlerThread.postToMainThread(new Runnable(this) {
                    /* class com.tencent.mm.plugin.appbrand.phonenumber.aa.g.AnonymousClass2 */
                    final /* synthetic */ g nBA;

                    {
                        this.nBA = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(148179);
                        aa.a(this.nBA.nBs, zzVar2.status, zzVar2.nzu, zzVar2.bxK, zzVar2.nzv);
                        AppMethodBeat.o(148179);
                    }
                });
            }
            x xVar = x.SXb;
            AppMethodBeat.o(148180);
            return xVar;
        }
    }

    public aa(Context context2, String str, y yVar, String str2, PhoneItem phoneItem, b bVar) {
        EditVerifyCodeView editVerifyCodeView;
        TextView textView;
        TextView textView2;
        p.h(context2, "context");
        p.h(str, "appId");
        p.h(str2, "ext_desc");
        p.h(phoneItem, "phoneItem");
        AppMethodBeat.i(169657);
        this.context = context2;
        this.appId = str;
        this.nBn = yVar;
        this.nBo = str2;
        this.nBp = phoneItem;
        this.nBq = bVar;
        Object systemService = this.context.getSystemService("layout_inflater");
        if (systemService == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.LayoutInflater");
            AppMethodBeat.o(169657);
            throw tVar;
        }
        this.nBi = ((LayoutInflater) systemService).inflate(R.layout.fz, (ViewGroup) null);
        View view = this.nBi;
        if (view != null) {
            editVerifyCodeView = (EditVerifyCodeView) view.findViewById(R.id.rj);
        } else {
            editVerifyCodeView = null;
        }
        this.nBj = editVerifyCodeView;
        View view2 = this.nBi;
        if (view2 != null) {
            textView = (TextView) view2.findViewById(R.id.rk);
        } else {
            textView = null;
        }
        this.kbG = textView;
        View view3 = this.nBi;
        if (view3 != null) {
            textView2 = (TextView) view3.findViewById(R.id.r5);
        } else {
            textView2 = null;
        }
        this.nBk = textView2;
        AppMethodBeat.o(169657);
    }

    public static final /* synthetic */ void c(aa aaVar) {
        AppMethodBeat.i(148200);
        aaVar.bTB();
        AppMethodBeat.o(148200);
    }

    public static final /* synthetic */ void c(aa aaVar, String str) {
        AppMethodBeat.i(148205);
        aaVar.aeu(str);
        AppMethodBeat.o(148205);
    }

    public static final /* synthetic */ void d(aa aaVar) {
        AppMethodBeat.i(148201);
        aaVar.bTC();
        AppMethodBeat.o(148201);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$Companion;", "", "()V", "TAG", "", "luggage-wechat-full-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    public static final class l implements DialogInterface.OnDismissListener {
        final /* synthetic */ aa nBs;

        l(aa aaVar) {
            this.nBs = aaVar;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.i(148185);
            Log.i("MicroMsg.PhoneNumberVerifyCodeDialog", "cancel to verify sms");
            aa.d(this.nBs);
            aa.e(this.nBs);
            AppMethodBeat.o(148185);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    public static final class m implements DialogInterface.OnClickListener {
        final /* synthetic */ aa nBs;

        m(aa aaVar) {
            this.nBs = aaVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            Integer num;
            String text;
            String text2;
            String text3;
            Integer num2 = null;
            String str = null;
            num2 = null;
            AppMethodBeat.i(148190);
            Object[] objArr = new Object[1];
            EditVerifyCodeView editVerifyCodeView = this.nBs.nBj;
            objArr[0] = editVerifyCodeView != null ? editVerifyCodeView.getText() : null;
            Log.i("MicroMsg.PhoneNumberVerifyCodeDialog", "to verify sms %s", objArr);
            EditVerifyCodeView editVerifyCodeView2 = this.nBs.nBj;
            if (editVerifyCodeView2 == null || (text3 = editVerifyCodeView2.getText()) == null || text3.length() != 6) {
                EditVerifyCodeView editVerifyCodeView3 = this.nBs.nBj;
                if (editVerifyCodeView3 == null || (text2 = editVerifyCodeView3.getText()) == null) {
                    num = null;
                } else {
                    num = Integer.valueOf(text2.length());
                }
                if (num == null) {
                    p.hyc();
                }
                if (num.intValue() < 6) {
                    Log.e("MicroMsg.PhoneNumberVerifyCodeDialog", "code is length is < 6");
                    com.tencent.mm.plugin.appbrand.utils.l.b(this.nBs.context, this.nBs.context.getString(R.string.lw), this.nBs.context.getString(R.string.lo), AnonymousClass1.nBB);
                    AppMethodBeat.o(148190);
                    return;
                }
                EditVerifyCodeView editVerifyCodeView4 = this.nBs.nBj;
                if (!(editVerifyCodeView4 == null || (text = editVerifyCodeView4.getText()) == null)) {
                    num2 = Integer.valueOf(text.length());
                }
                if (num2 == null) {
                    p.hyc();
                }
                if (num2.intValue() == 0) {
                    Log.e("MicroMsg.PhoneNumberVerifyCodeDialog", "code is empty");
                    com.tencent.mm.plugin.appbrand.utils.l.b(this.nBs.context, this.nBs.context.getString(R.string.lv), this.nBs.context.getString(R.string.lo), AnonymousClass2.nBC);
                }
                AppMethodBeat.o(148190);
                return;
            }
            dialogInterface.dismiss();
            aa.d(this.nBs);
            aa.e(this.nBs);
            aa aaVar = this.nBs;
            EditVerifyCodeView editVerifyCodeView5 = this.nBs.nBj;
            if (editVerifyCodeView5 != null) {
                str = editVerifyCodeView5.getText();
            }
            aa.a(aaVar, String.valueOf(str));
            AppMethodBeat.o(148190);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    public static final class n implements DialogInterface.OnClickListener {
        final /* synthetic */ aa nBs;

        n(aa aaVar) {
            this.nBs = aaVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(148191);
            Log.i("MicroMsg.PhoneNumberVerifyCodeDialog", "cancel to verify sms");
            dialogInterface.dismiss();
            aa.d(this.nBs);
            aa.b(this.nBs, "user cancel");
            aa.e(this.nBs);
            AppMethodBeat.o(148191);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class k implements Runnable {
        final /* synthetic */ aa nBs;

        k(aa aaVar) {
            this.nBs = aaVar;
        }

        public final void run() {
            AppMethodBeat.i(148184);
            u uVar = u.nAe;
            u.bTz().dM(this.nBs.context);
            AppMethodBeat.o(148184);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class i implements Runnable {
        final /* synthetic */ aa nBs;

        i(aa aaVar) {
            this.nBs = aaVar;
        }

        public final void run() {
            AppMethodBeat.i(148182);
            u uVar = u.nAe;
            u.bTz().dL(this.nBs.context);
            AppMethodBeat.o(148182);
        }
    }

    private final void bTB() {
        AppMethodBeat.i(148193);
        String string = this.context.getString(R.string.ln);
        p.g(string, "context.getString(R.stri…_not_receive_verify_code)");
        String string2 = this.context.getString(R.string.lq);
        p.g(string2, "context.getString(R.stri…umber_resend_verify_code)");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) string);
        spannableStringBuilder.append((CharSequence) string2);
        int length = string.length();
        int length2 = string2.length();
        spannableStringBuilder.setSpan(new o(this), length, length + length2, 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(this.context.getResources().getColor(R.color.Link)), length, length2 + length, 17);
        TextView textView = this.nBk;
        if (textView != null) {
            textView.setText(spannableStringBuilder);
        }
        TextView textView2 = this.nBk;
        if (textView2 != null) {
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
            AppMethodBeat.o(148193);
            return;
        }
        AppMethodBeat.o(148193);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$updateSendText$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "arg0", "Landroid/view/View;", "luggage-wechat-full-sdk_release"})
    public static final class o extends ClickableSpan {
        final /* synthetic */ aa nBs;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        o(aa aaVar) {
            this.nBs = aaVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(148192);
            p.h(view, "arg0");
            Log.i("MicroMsg.PhoneNumberVerifyCodeDialog", "click the resend spanBuilder, do resend sms");
            if (this.nBs.nBp.nzx) {
                aa.a(this.nBs);
                AppMethodBeat.o(148192);
                return;
            }
            Log.e("MicroMsg.PhoneNumberVerifyCodeDialog", "allow_send_sms is false, show send_verify_code_frequent error");
            aa aaVar = this.nBs;
            String string = this.nBs.context.getString(R.string.ls);
            p.g(string, "context.getString(R.stri…end_verify_code_frequent)");
            aa.c(aaVar, string);
            AppMethodBeat.o(148192);
        }
    }

    private final void bTC() {
        AppMethodBeat.i(148194);
        Log.i("MicroMsg.PhoneNumberVerifyCodeDialog", "stopSmsListener");
        c cVar = this.nBl;
        if (cVar != null) {
            cVar.cancel();
            AppMethodBeat.o(148194);
            return;
        }
        AppMethodBeat.o(148194);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$VertifyTimer;", "Landroid/os/CountDownTimer;", "millisInFuture", "", "countDownInterval", "(Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog;JJ)V", "onFinish", "", "onTick", "millisUntilFinished", "luggage-wechat-full-sdk_release"})
    public final class c extends CountDownTimer {
        public c(long j2, long j3) {
            super(j2, j3);
        }

        public final void onTick(long j2) {
            AppMethodBeat.i(148166);
            TextView textView = aa.this.nBk;
            if (textView != null) {
                textView.setText(aa.this.context.getString(R.string.lp, new StringBuilder().append(j2 / 1000).toString()));
                AppMethodBeat.o(148166);
                return;
            }
            AppMethodBeat.o(148166);
        }

        public final void onFinish() {
            AppMethodBeat.i(148167);
            aa.c(aa.this);
            AppMethodBeat.o(148167);
        }
    }

    static /* synthetic */ void a(aa aaVar) {
        AppMethodBeat.i(148196);
        aaVar.iv(false);
        AppMethodBeat.o(148196);
    }

    /* access modifiers changed from: package-private */
    public final void iv(boolean z) {
        AppMethodBeat.i(148195);
        Log.i("MicroMsg.PhoneNumberVerifyCodeDialog", "doSendVerifyCode");
        ProgressDialog b2 = com.tencent.mm.plugin.appbrand.utils.l.b(this.context, this.context.getString(R.string.a31));
        if (this.nBp.nzy) {
            new f(this.appId, this.nBp.dSf).y(new d(this, b2, z));
            AppMethodBeat.o(148195);
            return;
        }
        new e(this.appId, this.nBp.dSf).y(new e(this, b2, z));
        AppMethodBeat.o(148195);
    }

    private final void aeu(String str) {
        AppMethodBeat.i(148197);
        bTC();
        com.tencent.mm.plugin.appbrand.utils.l.c(this.context, str, "", new j(this));
        AppMethodBeat.o(148197);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    public static final class j implements DialogInterface.OnClickListener {
        final /* synthetic */ aa nBs;

        j(aa aaVar) {
            this.nBs = aaVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(148183);
            dialogInterface.dismiss();
            aa.b(this.nBs, "fail");
            AppMethodBeat.o(148183);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
    public static final class h implements DialogInterface.OnClickListener {
        final /* synthetic */ aa nBs;

        h(aa aaVar) {
            this.nBs = aaVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            AppMethodBeat.i(148181);
            dialogInterface.dismiss();
            Log.e("MicroMsg.PhoneNumberVerifyCodeDialog", "verify code is error, do send the right code");
            aa.g(this.nBs);
            AppMethodBeat.o(148181);
        }
    }

    public static final /* synthetic */ void e(aa aaVar) {
        AppMethodBeat.i(148202);
        View view = aaVar.nBi;
        if (view != null) {
            view.post(new i(aaVar));
            AppMethodBeat.o(148202);
            return;
        }
        AppMethodBeat.o(148202);
    }

    public static final /* synthetic */ void a(aa aaVar, String str) {
        AppMethodBeat.i(148203);
        Log.i("MicroMsg.PhoneNumberVerifyCodeDialog", "doVerifyCode");
        y yVar = aaVar.nBn;
        if (yVar != null) {
            y yVar2 = aaVar.nBn;
            Long valueOf = yVar2 != null ? Long.valueOf(yVar2.nBb) : null;
            if (valueOf == null) {
                p.hyc();
            }
            yVar.nBb = valueOf.longValue() + 1;
        }
        ProgressDialog b2 = com.tencent.mm.plugin.appbrand.utils.l.b(aaVar.context, aaVar.context.getString(R.string.a33));
        if (aaVar.nBp.nzy) {
            c cVar = new c(aaVar.appId, aaVar.nBp.dSf, str);
            f fVar = new f(aaVar, b2);
            zy zyVar = new zy();
            zyVar.dNI = cVar.appId;
            zyVar.dSf = cVar.dSf;
            zyVar.IaW = cVar.code;
            ((com.tencent.mm.plugin.appbrand.networking.c) com.tencent.luggage.a.e.M(com.tencent.mm.plugin.appbrand.networking.c.class)).a("/cgi-bin/mmbiz-bin/wxaapp/checkverifycode", zyVar, zz.class).c(new c.a(fVar)).a(new c.b(fVar));
            AppMethodBeat.o(148203);
            return;
        }
        new b(aaVar.appId, aaVar.nBp.dSf, str).y(new g(aaVar, b2));
        AppMethodBeat.o(148203);
    }

    public static final /* synthetic */ void b(aa aaVar, String str) {
        AppMethodBeat.i(148204);
        HashMap hashMap = new HashMap();
        hashMap.put("errMsg", str);
        b bVar = aaVar.nBq;
        if (bVar != null) {
            bVar.a(false, hashMap);
            AppMethodBeat.o(148204);
            return;
        }
        AppMethodBeat.o(148204);
    }

    public static final /* synthetic */ void a(aa aaVar, int i2) {
        AppMethodBeat.i(148206);
        Log.i("MicroMsg.PhoneNumberVerifyCodeDialog", "handleSendVerifyCodeStatus:%d", Integer.valueOf(i2));
        h hVar = h.nzb;
        if (i2 == h.bTm()) {
            Log.i("MicroMsg.PhoneNumberVerifyCodeDialog", "startSmsListener");
            if (aaVar.nBl != null) {
                c cVar = aaVar.nBl;
                if (cVar != null) {
                    cVar.cancel();
                }
            } else {
                aaVar.nBl = new c((long) aaVar.MAX_WAIT_TIME, (long) aaVar.nBm);
            }
            c cVar2 = aaVar.nBl;
            if (cVar2 != null) {
                cVar2.start();
                AppMethodBeat.o(148206);
                return;
            }
            AppMethodBeat.o(148206);
            return;
        }
        h hVar2 = h.nzb;
        if (i2 != h.bTn()) {
            h hVar3 = h.nzb;
            if (i2 == h.bTo()) {
                String string = aaVar.context.getString(R.string.ls);
                p.g(string, "context.getString(R.stri…end_verify_code_frequent)");
                aaVar.aeu(string);
                AppMethodBeat.o(148206);
                return;
            }
        }
        String string2 = aaVar.context.getString(R.string.lr);
        p.g(string2, "context.getString(R.stri…er_send_verify_code_fail)");
        aaVar.aeu(string2);
        AppMethodBeat.o(148206);
    }

    public static final /* synthetic */ void g(aa aaVar) {
        ViewParent viewParent;
        ViewParent viewParent2;
        AppMethodBeat.i(148207);
        EditVerifyCodeView editVerifyCodeView = aaVar.nBj;
        if (editVerifyCodeView != null) {
            editVerifyCodeView.setText("");
        }
        TextView textView = aaVar.kbG;
        if (textView != null) {
            textView.setText(aaVar.context.getString(R.string.ly, aaVar.nBp.nzt));
        }
        aaVar.bTB();
        if (aaVar.nBi != null) {
            View view = aaVar.nBi;
            if (view != null) {
                viewParent = view.getParent();
            } else {
                viewParent = null;
            }
            if (viewParent instanceof ViewGroup) {
                View view2 = aaVar.nBi;
                if (view2 != null) {
                    viewParent2 = view2.getParent();
                } else {
                    viewParent2 = null;
                }
                if (viewParent2 == null) {
                    t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                    AppMethodBeat.o(148207);
                    throw tVar;
                }
                ((ViewGroup) viewParent2).removeView(aaVar.nBi);
            }
        }
        com.tencent.mm.ui.widget.a.d hbn = new d.a(aaVar.context).bon(aaVar.context.getString(R.string.m1)).ht(aaVar.nBi).hbn();
        hbn.setOnDismissListener(new l(aaVar));
        hbn.a(aaVar.context.getString(R.string.a36), false, new m(aaVar));
        hbn.b(aaVar.context.getString(R.string.a37), true, new n(aaVar));
        hbn.show();
        View view3 = aaVar.nBi;
        if (view3 != null) {
            view3.post(new k(aaVar));
            AppMethodBeat.o(148207);
            return;
        }
        AppMethodBeat.o(148207);
    }

    public static final /* synthetic */ void a(aa aaVar, int i2, String str, String str2, String str3) {
        Long l2;
        Long l3 = null;
        AppMethodBeat.i(148208);
        Log.i("MicroMsg.PhoneNumberVerifyCodeDialog", "handleCheckVerifyCodeStatus:%d", Integer.valueOf(i2));
        h hVar = h.nzb;
        if (i2 == h.bTp()) {
            y yVar = aaVar.nBn;
            if (yVar != null) {
                y yVar2 = aaVar.nBn;
                if (yVar2 != null) {
                    l3 = Long.valueOf(yVar2.nBc);
                }
                if (l3 == null) {
                    p.hyc();
                }
                yVar.nBc = l3.longValue() + 1;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("errMsg", "ok");
            HashMap hashMap2 = hashMap;
            if (str == null) {
                str = "";
            }
            hashMap2.put("encryptedData", str);
            HashMap hashMap3 = hashMap;
            if (str2 == null) {
                str2 = "";
            }
            hashMap3.put("iv", str2);
            HashMap hashMap4 = hashMap;
            if (str3 == null) {
                str3 = "";
            }
            hashMap4.put("cloud_id", str3);
            b bVar = aaVar.nBq;
            if (bVar != null) {
                bVar.a(true, hashMap);
                AppMethodBeat.o(148208);
                return;
            }
            AppMethodBeat.o(148208);
            return;
        }
        h hVar2 = h.nzb;
        if (i2 == h.bTq()) {
            String string = aaVar.context.getString(R.string.ls);
            p.g(string, "context.getString(R.stri…end_verify_code_frequent)");
            aaVar.aeu(string);
            y yVar3 = aaVar.nBn;
            if (yVar3 != null) {
                y yVar4 = aaVar.nBn;
                if (yVar4 != null) {
                    l3 = Long.valueOf(yVar4.nBd);
                }
                if (l3 == null) {
                    p.hyc();
                }
                yVar3.nBd = l3.longValue() + 1;
                AppMethodBeat.o(148208);
                return;
            }
            AppMethodBeat.o(148208);
            return;
        }
        h hVar3 = h.nzb;
        if (i2 != h.bTr()) {
            h hVar4 = h.nzb;
            if (i2 != h.bTs()) {
                String string2 = aaVar.context.getString(R.string.lx);
                p.g(string2, "context.getString(R.stri…_number_verify_code_fail)");
                aaVar.aeu(string2);
                y yVar5 = aaVar.nBn;
                if (yVar5 != null) {
                    y yVar6 = aaVar.nBn;
                    if (yVar6 != null) {
                        l2 = Long.valueOf(yVar6.nBd);
                    } else {
                        l2 = null;
                    }
                    if (l2 == null) {
                        p.hyc();
                    }
                    yVar5.nBd = l2.longValue() + 1;
                    AppMethodBeat.o(148208);
                    return;
                }
                AppMethodBeat.o(148208);
                return;
            }
        }
        com.tencent.mm.plugin.appbrand.utils.l.c(aaVar.context, aaVar.context.getString(R.string.lu), "", new h(aaVar));
        y yVar7 = aaVar.nBn;
        if (yVar7 != null) {
            y yVar8 = aaVar.nBn;
            if (yVar8 != null) {
                l3 = Long.valueOf(yVar8.nBd);
            }
            if (l3 == null) {
                p.hyc();
            }
            yVar7.nBd = l3.longValue() + 1;
            AppMethodBeat.o(148208);
            return;
        }
        AppMethodBeat.o(148208);
    }
}
