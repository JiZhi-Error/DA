package com.tencent.mm.plugin.festival.ui.view;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.g;
import kotlin.g.a.q;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0005\u0018\u0000 *2\u00020\u0001:\u0001*B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010 \u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J \u0010!\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\t2\b\u0010#\u001a\u0004\u0018\u00010\u001dJ\u000e\u0010$\u001a\u00020\u00182\u0006\u0010%\u001a\u00020&JU\u0010'\u001a\u00020\u00182M\u0010(\u001aI\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001e\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00180\u001cJ1\u0010)\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2!\u0010(\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00180\u0014R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R+\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000RW\u0010\u001b\u001aK\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u001d¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001e\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/view/FestivalRealNamePanel;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bottomDialog", "Lcom/tencent/mm/ui/widget/dialog/MMHalfBottomDialog;", "check", "", "checkBox", "Landroid/widget/CheckBox;", "licenseContent", "Landroid/widget/TextView;", "realNameCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "", "verifyUrl", "", "webviewForwardCallback", "Lkotlin/Function3;", "Landroid/content/Intent;", "intent", "requestCode", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "onActivityResult", "resultCode", "data", "setDialogHeight", "height", "", "setWebviewForwardCallback", "callback", "showDialog", "Companion", "plugin-festival_release"})
public final class FestivalRealNamePanel extends LinearLayout {
    public static final a UFN = new a((byte) 0);
    private CheckBox checkBox;
    public String hJl = "";
    private boolean jCx;
    private q<? super Context, ? super Intent, ? super Integer, x> uyl;
    public kotlin.g.a.b<? super Boolean, x> uym;
    private TextView uyn;
    public g uyo;

    static {
        AppMethodBeat.i(263453);
        AppMethodBeat.o(263453);
    }

    public static final /* synthetic */ g b(FestivalRealNamePanel festivalRealNamePanel) {
        AppMethodBeat.i(263454);
        g gVar = festivalRealNamePanel.uyo;
        if (gVar == null) {
            p.btv("bottomDialog");
        }
        AppMethodBeat.o(263454);
        return gVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/festival/ui/view/FestivalRealNamePanel$Companion;", "", "()V", "REQUEST_CODE_FACE_VERIFY", "", "TAG", "", "url", "plugin-festival_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FestivalRealNamePanel(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(263450);
        init(context);
        AppMethodBeat.o(263450);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FestivalRealNamePanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(263451);
        init(context);
        AppMethodBeat.o(263451);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FestivalRealNamePanel(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(263452);
        init(context);
        AppMethodBeat.o(263452);
    }

    private final void init(Context context) {
        AppMethodBeat.i(263447);
        View inflate = View.inflate(context, R.layout.ade, this);
        View findViewById = inflate.findViewById(R.id.eav);
        p.g(findViewById, "root.findViewById(R.id.license_checkbox)");
        this.checkBox = (CheckBox) findViewById;
        CheckBox checkBox2 = this.checkBox;
        if (checkBox2 == null) {
            p.btv("checkBox");
        }
        checkBox2.setOnCheckedChangeListener(new b(this));
        View findViewById2 = inflate.findViewById(R.id.eaw);
        p.g(findViewById2, "root.findViewById(R.id.license_content)");
        this.uyn = (TextView) findViewById2;
        TextView textView = this.uyn;
        if (textView == null) {
            p.btv("licenseContent");
        }
        textView.setOnClickListener(new c(this, context));
        this.uyo = new g(context, 2, 1);
        g gVar = this.uyo;
        if (gVar == null) {
            p.btv("bottomDialog");
        }
        gVar.T(context.getResources().getString(R.string.eg8));
        g gVar2 = this.uyo;
        if (gVar2 == null) {
            p.btv("bottomDialog");
        }
        gVar2.a(new d(this, context));
        g gVar3 = this.uyo;
        if (gVar3 == null) {
            p.btv("bottomDialog");
        }
        gVar3.ape(1);
        g gVar4 = this.uyo;
        if (gVar4 == null) {
            p.btv("bottomDialog");
        }
        gVar4.setCustomView(this);
        AppMethodBeat.o(263447);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "buttonView", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"})
    public static final class b implements CompoundButton.OnCheckedChangeListener {
        final /* synthetic */ FestivalRealNamePanel UFO;

        b(FestivalRealNamePanel festivalRealNamePanel) {
            this.UFO = festivalRealNamePanel;
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            AppMethodBeat.i(263444);
            this.UFO.jCx = z;
            if (z) {
                FestivalRealNamePanel.b(this.UFO).ape(0);
                AppMethodBeat.o(263444);
                return;
            }
            FestivalRealNamePanel.b(this.UFO).ape(1);
            AppMethodBeat.o(263444);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class c implements View.OnClickListener {
        final /* synthetic */ Context $context;
        final /* synthetic */ FestivalRealNamePanel UFO;

        c(FestivalRealNamePanel festivalRealNamePanel, Context context) {
            this.UFO = festivalRealNamePanel;
            this.$context = context;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(263445);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/ui/view/FestivalRealNamePanel$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent();
            intent.putExtra("rawUrl", "https://weixin.qq.com/cgi-bin/readtemplate?t=finder_live_privacy");
            q qVar = this.UFO.uyl;
            if (qVar != null) {
                qVar.d(this.$context, intent, null);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/ui/view/FestivalRealNamePanel$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(263445);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onClick"})
    public static final class d implements g.a {
        final /* synthetic */ Context $context;
        final /* synthetic */ FestivalRealNamePanel UFO;

        d(FestivalRealNamePanel festivalRealNamePanel, Context context) {
            this.UFO = festivalRealNamePanel;
            this.$context = context;
        }

        @Override // com.tencent.mm.ui.widget.a.g.a
        public final void onClick() {
            AppMethodBeat.i(263446);
            if (this.UFO.jCx && !Util.isNullOrNil(this.UFO.hJl)) {
                Intent intent = new Intent();
                intent.putExtra("open_custom_style_url", true);
                intent.putExtra("forceHideShare", true);
                intent.putExtra("show_native_web_view", true);
                intent.putExtra("rawUrl", this.UFO.hJl);
                intent.putExtra("screen_orientation", 1);
                q qVar = this.UFO.uyl;
                if (qVar != null) {
                    qVar.d(this.$context, intent, 10000);
                }
                m.vli.a(s.as.AuthEnter);
            }
            AppMethodBeat.o(263446);
        }
    }

    public final void setWebviewForwardCallback(q<? super Context, ? super Intent, ? super Integer, x> qVar) {
        AppMethodBeat.i(263448);
        p.h(qVar, "callback");
        this.uyl = qVar;
        AppMethodBeat.o(263448);
    }

    public final void setDialogHeight(double d2) {
        AppMethodBeat.i(263449);
        g gVar = this.uyo;
        if (gVar == null) {
            p.btv("bottomDialog");
        }
        gVar.setHeight((int) d2);
        AppMethodBeat.o(263449);
    }
}
