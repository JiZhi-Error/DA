package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.widget.a.g;
import java.util.Map;
import kotlin.a.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.s;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\"\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequestBindPhoneNumber;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "showRequestPhoneNumDialog", "", "phoneNumber", "GetUserBindPhoneNumber", "plugin-webview_release"})
public final class r extends com.tencent.mm.plugin.webview.d.c.a {
    public static final r JxE = new r();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "onCallback"})
    static final class b<T> implements com.tencent.mm.ipcinvoker.d<IPCString> {
        final /* synthetic */ f CDE;
        final /* synthetic */ n pGr;

        b(f fVar, n nVar) {
            this.CDE = fVar;
            this.pGr = nVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.d
        public final /* synthetic */ void bn(IPCString iPCString) {
            AppMethodBeat.i(210655);
            final IPCString iPCString2 = iPCString;
            new StringBuilder("bindPhone :").append(iPCString2 != null ? iPCString2.value : null);
            h.hkS();
            com.tencent.f.h.RTc.aV(new Runnable(this) {
                /* class com.tencent.mm.plugin.webview.ui.tools.newjsapi.r.b.AnonymousClass1 */
                final /* synthetic */ b JxF;

                {
                    this.JxF = r1;
                }

                public final void run() {
                    AppMethodBeat.i(210654);
                    r rVar = r.JxE;
                    f fVar = this.JxF.CDE;
                    n nVar = this.JxF.pGr;
                    IPCString iPCString = iPCString2;
                    r.a(fVar, nVar, iPCString != null ? iPCString.value : null);
                    AppMethodBeat.o(210654);
                }
            });
            AppMethodBeat.o(210655);
        }
    }

    static {
        AppMethodBeat.i(210660);
        AppMethodBeat.o(210660);
    }

    private r() {
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final int ePA() {
        return 387;
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final String ePz() {
        return "requestBindPhoneNumber";
    }

    @Override // com.tencent.mm.plugin.webview.d.j
    public final boolean a(f fVar, n nVar) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(210659);
        p.h(fVar, "env");
        p.h(nVar, "msg");
        Object obj = nVar.params.get("requestName");
        if (!(obj instanceof String)) {
            obj = null;
        }
        String str = (String) obj;
        Object obj2 = nVar.params.get("requestIconUrl");
        if (!(obj2 instanceof String)) {
            obj2 = null;
        }
        String str2 = (String) obj2;
        String str3 = str;
        if (str3 == null || str3.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            String str4 = str2;
            if (str4 == null || str4.length() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                com.tencent.mm.ipcinvoker.wx_extension.b.a.a(null, new a(), new b(fVar, nVar));
                AppMethodBeat.o(210659);
                return true;
            }
        }
        fVar.IQZ.h(nVar.ISe, "requestBindPhoneNumber:fail requestName or requestIcon is null", null);
        AppMethodBeat.o(210659);
        return true;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class c implements View.OnClickListener {
        final /* synthetic */ f CDE;
        final /* synthetic */ g hIa;
        final /* synthetic */ n pGr;

        c(g gVar, f fVar, n nVar) {
            this.hIa = gVar;
            this.CDE = fVar;
            this.pGr = nVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(210656);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequestBindPhoneNumber$showRequestPhoneNumDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.hIa.bMo();
            com.tencent.mm.plugin.webview.d.h hVar = this.CDE.IQZ;
            String str = this.pGr.ISe;
            StringBuilder sb = new StringBuilder();
            r rVar = r.JxE;
            hVar.h(str, sb.append("requestBindPhoneNumber:cancel").toString(), null);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequestBindPhoneNumber$showRequestPhoneNumDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(210656);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class d implements View.OnClickListener {
        final /* synthetic */ f CDE;
        final /* synthetic */ String JxH;
        final /* synthetic */ g hIa;
        final /* synthetic */ n pGr;

        d(g gVar, String str, f fVar, n nVar) {
            this.hIa = gVar;
            this.JxH = str;
            this.CDE = fVar;
            this.pGr = nVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(210657);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequestBindPhoneNumber$showRequestPhoneNumDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.hIa.bMo();
            String str = this.JxH;
            if (str == null || str.length() == 0) {
                com.tencent.mm.plugin.webview.d.h hVar = this.CDE.IQZ;
                String str2 = this.pGr.ISe;
                StringBuilder sb = new StringBuilder();
                r rVar = r.JxE;
                hVar.h(str2, sb.append("requestBindPhoneNumber:fail not bind phone").toString(), null);
            } else {
                Map<String, Object> b2 = ae.b(s.U("phoneNumber", this.JxH));
                com.tencent.mm.plugin.webview.d.h hVar2 = this.CDE.IQZ;
                String str3 = this.pGr.ISe;
                StringBuilder sb2 = new StringBuilder();
                r rVar2 = r.JxE;
                hVar2.h(str3, sb2.append("requestBindPhoneNumber:ok").toString(), b2);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequestBindPhoneNumber$showRequestPhoneNumDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(210657);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class e implements View.OnClickListener {
        final /* synthetic */ f CDE;
        final /* synthetic */ g hIa;
        final /* synthetic */ n pGr;

        e(g gVar, f fVar, n nVar) {
            this.hIa = gVar;
            this.CDE = fVar;
            this.pGr = nVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(210658);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequestBindPhoneNumber$showRequestPhoneNumDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.hIa.bMo();
            com.tencent.mm.plugin.webview.d.h hVar = this.CDE.IQZ;
            String str = this.pGr.ISe;
            StringBuilder sb = new StringBuilder();
            r rVar = r.JxE;
            hVar.h(str, sb.append("requestBindPhoneNumber:fail not bind phone").toString(), null);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequestBindPhoneNumber$showRequestPhoneNumDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(210658);
        }
    }

    public static final /* synthetic */ void a(f fVar, n nVar, String str) {
        AppMethodBeat.i(210661);
        Object obj = nVar.params.get("requestName");
        if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(210661);
            throw tVar;
        }
        String str2 = (String) obj;
        Object obj2 = nVar.params.get("requestIconUrl");
        if (obj2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(210661);
            throw tVar2;
        }
        g gVar = new g(fVar.context, 0, 0, false);
        gVar.lJI.setBackgroundColor(fVar.context.getResources().getColor(R.color.afz));
        View inflate = View.inflate(fVar.context, R.layout.cbr, null);
        View findViewById = inflate.findViewById(R.id.h3q);
        p.g(findViewById, "contentView.findViewById(R.id.request_icon)");
        View findViewById2 = inflate.findViewById(R.id.h3s);
        p.g(findViewById2, "contentView.findViewById(R.id.request_name)");
        View findViewById3 = inflate.findViewById(R.id.gas);
        p.g(findViewById3, "contentView.findViewById…anager_dialog_item_phone)");
        TextView textView = (TextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.gat);
        p.g(findViewById4, "contentView.findViewById…nager_dialog_item_remark)");
        View findViewById5 = inflate.findViewById(R.id.ah3);
        p.g(findViewById5, "contentView.findViewById(R.id.button_group)");
        View findViewById6 = inflate.findViewById(R.id.ah4);
        p.g(findViewById6, "contentView.findViewById(R.id.button_i_known)");
        View findViewById7 = inflate.findViewById(R.id.h3l);
        p.g(findViewById7, "contentView.findViewById(R.id.request_cancel)");
        View findViewById8 = inflate.findViewById(R.id.h3t);
        p.g(findViewById8, "contentView.findViewById(R.id.request_ok)");
        findViewById7.setOnClickListener(new c(gVar, fVar, nVar));
        findViewById8.setOnClickListener(new d(gVar, str, fVar, nVar));
        findViewById6.setOnClickListener(new e(gVar, fVar, nVar));
        ((TextView) findViewById2).setText(str2);
        com.tencent.mm.av.a.a.bdb().a((String) obj2, (ImageView) findViewById, new c.a().bdq().ty(R.raw.default_avatar_round).bdt().bdv());
        String str3 = str;
        if (str3 == null || str3.length() == 0) {
            textView.setVisibility(0);
            findViewById4.setVisibility(8);
            findViewById5.setVisibility(8);
            findViewById6.setVisibility(0);
            textView.setTextColor(fVar.context.getResources().getColor(R.color.uj));
            textView.setText(fVar.context.getText(R.string.iz_));
        } else {
            textView.setVisibility(0);
            findViewById4.setVisibility(0);
            findViewById5.setVisibility(0);
            findViewById6.setVisibility(8);
            textView.setText(str);
        }
        gVar.setCustomView(inflate);
        gVar.dGm();
        AppMethodBeat.o(210661);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J%\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\tH\u0002¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiRequestBindPhoneNumber$GetUserBindPhoneNumber;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "Lcom/tencent/mm/ipcinvoker/type/IPCString;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-webview_release"})
    public static final class a implements com.tencent.mm.ipcinvoker.b<IPCVoid, IPCString> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(IPCVoid iPCVoid, com.tencent.mm.ipcinvoker.d<IPCString> dVar) {
            AppMethodBeat.i(210653);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            Object obj = aAh.azQ().get(6);
            if (!(obj instanceof String)) {
                obj = null;
            }
            String str = (String) obj;
            String str2 = str;
            if (str2 == null || kotlin.n.n.aL(str2)) {
                str = "";
            }
            if (dVar != null) {
                dVar.bn(new IPCString(str));
                AppMethodBeat.o(210653);
                return;
            }
            AppMethodBeat.o(210653);
        }
    }
}
