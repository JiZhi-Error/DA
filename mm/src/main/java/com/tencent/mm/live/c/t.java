package com.tencent.mm.live.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ab.i;
import com.tencent.mm.live.b.x;
import com.tencent.mm.live.c.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 *2\u00020\u0001:\u0001*B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\"\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020\b2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020$H\u0016J\u001a\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006+"}, hxF = {"Lcom/tencent/mm/live/plugin/LiveFaceVerifyPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/widget/RelativeLayout;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/widget/RelativeLayout;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "MODE_BIND_BANKCARD", "", "MODE_BIND_MOBILE", "MODE_DEFAULT", "MODE_FACE_VERIFY", "backIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "mode", "okBtn", "Landroid/widget/Button;", "rootLayout", "verifyContentTip", "Landroid/widget/TextView;", "verifyIIcon", "Landroid/widget/ImageView;", "verifyTitle", "verifyUrl", "", "getVerifyUrl", "()Ljava/lang/String;", "setVerifyUrl", "(Ljava/lang/String;)V", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPress", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-logic_release"})
public final class t extends a {
    public static final a hQf = new a((byte) 0);
    private final int MODE_DEFAULT = -1;
    String hJl;
    private final RelativeLayout hOX;
    private final b hOp;
    private final Button hPX;
    private final int hPY;
    private final int hPZ = 1;
    private final int hQa = 2;
    private final WeImageView hQb;
    private final ImageView hQc;
    private final TextView hQd;
    private final TextView hQe;
    private int mode;

    static {
        AppMethodBeat.i(208006);
        AppMethodBeat.o(208006);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/live/plugin/LiveFaceVerifyPlugin$Companion;", "", "()V", "TAG", "", "plugin-logic_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t(RelativeLayout relativeLayout, b bVar) {
        super(relativeLayout, bVar);
        p.h(relativeLayout, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(208005);
        this.hOp = bVar;
        View findViewById = relativeLayout.findViewById(R.id.eh8);
        p.g(findViewById, "root.findViewById(R.id.live_face_verify_ui_root)");
        this.hOX = (RelativeLayout) findViewById;
        View findViewById2 = relativeLayout.findViewById(R.id.emy);
        p.g(findViewById2, "root.findViewById(R.id.live_verify_ok_btn)");
        this.hPX = (Button) findViewById2;
        View findViewById3 = relativeLayout.findViewById(R.id.eh6);
        p.g(findViewById3, "root.findViewById(R.id.live_face_verify_top_back)");
        this.hQb = (WeImageView) findViewById3;
        View findViewById4 = relativeLayout.findViewById(R.id.emw);
        p.g(findViewById4, "root.findViewById(R.id.live_verify_icon)");
        this.hQc = (ImageView) findViewById4;
        View findViewById5 = relativeLayout.findViewById(R.id.emz);
        p.g(findViewById5, "root.findViewById(R.id.live_verify_title)");
        this.hQd = (TextView) findViewById5;
        View findViewById6 = relativeLayout.findViewById(R.id.emv);
        p.g(findViewById6, "root.findViewById(R.id.live_verify_content_tip)");
        this.hQe = (TextView) findViewById6;
        this.mode = this.MODE_DEFAULT;
        this.hJl = "";
        this.hOX.setOnClickListener(AnonymousClass1.hQg);
        AppMethodBeat.o(208005);
    }

    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(208002);
        p.h(cVar, "status");
        switch (u.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                this.mode = this.hQa;
                x xVar = x.hJf;
                x.aGD().hJq = true;
                Context context = this.hwr.getContext();
                if (context != null) {
                    ((Activity) context).setRequestedOrientation(7);
                    if (isLandscape()) {
                        x xVar2 = x.hJf;
                        if (!x.aGE().hJk) {
                            x xVar3 = x.hJf;
                            x.aGE().hJk = true;
                            AppMethodBeat.o(208002);
                            return;
                        }
                    }
                    this.hQb.setVisibility(0);
                    this.hQb.setOnClickListener(new b(this));
                    x xVar4 = x.hJf;
                    this.hJl = x.aGE().hJl;
                    this.hQd.setText(R.string.eg5);
                    x xVar5 = x.hJf;
                    if (x.aGE().hJm) {
                        this.hQe.setText(R.string.eg7);
                    } else {
                        this.hQe.setText(R.string.eg6);
                    }
                    this.hPX.setText(R.string.eg8);
                    Button button = this.hPX;
                    Context context2 = this.hwr.getContext();
                    p.g(context2, "root.context");
                    button.setTextColor(context2.getResources().getColor(R.color.ag0));
                    this.hPX.setBackgroundResource(R.drawable.kd);
                    this.hPX.setOnClickListener(new c(this));
                    rg(0);
                    break;
                } else {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(208002);
                    throw tVar;
                }
            case 2:
                this.mode = this.hPY;
                x xVar6 = x.hJf;
                x.aGD().hJq = true;
                this.hQb.setVisibility(4);
                this.hQd.setText(R.string.ehg);
                this.hQe.setText(R.string.ehf);
                this.hPX.setText(R.string.ejz);
                Button button2 = this.hPX;
                Context context3 = this.hwr.getContext();
                p.g(context3, "root.context");
                button2.setTextColor(context3.getResources().getColor(R.color.ag0));
                this.hPX.setBackgroundResource(R.drawable.kd);
                this.hPX.setOnClickListener(new d(this));
                rg(0);
                break;
            case 3:
                this.mode = this.hPZ;
                x xVar7 = x.hJf;
                x.aGD().hJq = true;
                this.hQb.setVisibility(4);
                this.hQd.setText(R.string.eg3);
                this.hQe.setText(R.string.eg4);
                this.hPX.setText(R.string.ejz);
                Button button3 = this.hPX;
                Context context4 = this.hwr.getContext();
                p.g(context4, "root.context");
                button3.setTextColor(context4.getResources().getColor(R.color.jq));
                this.hPX.setBackgroundResource(R.drawable.k7);
                this.hPX.setOnClickListener(new e(this));
                rg(0);
                break;
        }
        super.statusChange(cVar, bundle);
        AppMethodBeat.o(208002);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class b implements View.OnClickListener {
        final /* synthetic */ t hQh;

        b(t tVar) {
            this.hQh = tVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(207998);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$statusChange$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.hQh.hQb.setVisibility(4);
            this.hQh.rg(8);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$statusChange$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(207998);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class c implements View.OnClickListener {
        final /* synthetic */ t hQh;

        c(t tVar) {
            this.hQh = tVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(207999);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$statusChange$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent();
            intent.putExtra("open_custom_style_url", true);
            intent.putExtra("forceHideShare", true);
            intent.putExtra("show_native_web_view", true);
            intent.putExtra("rawUrl", this.hQh.hJl);
            intent.putExtra("screen_orientation", 1);
            com.tencent.mm.br.c.b(this.hQh.hwr.getContext(), "webview", ".ui.tools.WebViewUI", intent, 9);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$statusChange$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(207999);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class d implements View.OnClickListener {
        final /* synthetic */ t hQh;

        d(t tVar) {
            this.hQh = tVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(208000);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$statusChange$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            x xVar = x.hJf;
            x.aGD().hJq = false;
            b.C0376b.a(this.hQh.hOp, b.c.hLD);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$statusChange$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(208000);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class e implements View.OnClickListener {
        final /* synthetic */ t hQh;

        e(t tVar) {
            this.hQh = tVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(208001);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$statusChange$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            x xVar = x.hJf;
            x.aGD().hJq = false;
            Button button = this.hQh.hPX;
            Context context = this.hQh.hwr.getContext();
            p.g(context, "root.context");
            button.setTextColor(context.getResources().getColor(R.color.ag0));
            this.hQh.hPX.setBackgroundResource(R.drawable.kd);
            this.hQh.rg(8);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveFaceVerifyPlugin$statusChange$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(208001);
        }
    }

    @Override // com.tencent.mm.live.c.a
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(208003);
        super.onActivityResult(i2, i3, intent);
        Log.i("MicroMsg.LiveVerifyPlugin", "onActivityResult, requestCode" + i2 + ", resultCode" + i3);
        if (i2 == 9) {
            x xVar = x.hJf;
            x.aGD().hJq = false;
            Bundle bundle = null;
            if (intent != null) {
                bundle = intent.getBundleExtra("result_data");
            }
            if (i3 == -1 && bundle != null) {
                String string = bundle.getString("go_next", "");
                String string2 = bundle.getString("result_json");
                if (!Util.isNullOrNil(string2)) {
                    int i4 = new i(string2).getInt(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
                    Log.i("MicroMsg.LiveVerifyPlugin", "onActivityResult, nextStep" + string + ", code" + i4);
                    if (string.equals("roomlive_verify") && i4 == 0) {
                        rg(8);
                        AppMethodBeat.o(208003);
                        return;
                    } else if (i4 == 1000) {
                        statusChange(b.c.hLx, new Bundle());
                        AppMethodBeat.o(208003);
                        return;
                    } else {
                        rg(8);
                        Bundle bundle2 = new Bundle();
                        bundle2.putInt("PARAM_FACE_VERIFY_ERROR", R.string.eg1);
                        this.hOp.statusChange(b.c.hLy, bundle2);
                        AppMethodBeat.o(208003);
                        return;
                    }
                }
            }
            rg(8);
        }
        AppMethodBeat.o(208003);
    }

    @Override // com.tencent.mm.live.c.a
    public final boolean onBackPress() {
        AppMethodBeat.i(208004);
        if (this.hwr.getVisibility() == 0) {
            x xVar = x.hJf;
            x.aGD().hJq = false;
            int i2 = this.mode;
            if (i2 == this.hQa || i2 == this.hPZ) {
                rg(8);
            } else if (i2 == this.hPY) {
                b.C0376b.a(this.hOp, b.c.hLD);
            }
            AppMethodBeat.o(208004);
            return true;
        }
        AppMethodBeat.o(208004);
        return false;
    }
}
