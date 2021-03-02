package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.protocal.protobuf.cxp;
import com.tencent.mm.protocal.protobuf.ffc;
import com.tencent.mm.sdk.platformtools.MMHandler;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u001aB%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\rR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandGameEvaluateOptionView;", "Landroid/widget/FrameLayout;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "optionChooseCallback", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandGameEvaluateOptionView$OptionChooseCallback;", "optionConfig", "Lcom/tencent/mm/protocal/protobuf/OptionItem;", "view", "onClick", "", "v", "Landroid/view/View;", "setData", FirebaseAnalytics.b.INDEX, "config", "Lcom/tencent/mm/protocal/protobuf/WxagGameOriginalReviewConfig;", "callback", "OptionChooseCallback", "plugin-appbrand-integration_release"})
public final class AppBrandGameEvaluateOptionView extends FrameLayout implements View.OnClickListener {
    private final MMHandler handler;
    private cxp oqK;
    private a oqL;
    private final FrameLayout oqM;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandGameEvaluateOptionView$OptionChooseCallback;", "", "onOptionChoose", "", "optionInfo", "Lcom/tencent/mm/protocal/protobuf/OptionItem;", "plugin-appbrand-integration_release"})
    public interface a {
        void a(cxp cxp);
    }

    public AppBrandGameEvaluateOptionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (byte) 0);
    }

    public static final /* synthetic */ a a(AppBrandGameEvaluateOptionView appBrandGameEvaluateOptionView) {
        AppMethodBeat.i(51445);
        a aVar = appBrandGameEvaluateOptionView.oqL;
        if (aVar == null) {
            p.btv("optionChooseCallback");
        }
        AppMethodBeat.o(51445);
        return aVar;
    }

    public static final /* synthetic */ cxp b(AppBrandGameEvaluateOptionView appBrandGameEvaluateOptionView) {
        AppMethodBeat.i(51446);
        cxp cxp = appBrandGameEvaluateOptionView.oqK;
        if (cxp == null) {
            p.btv("optionConfig");
        }
        AppMethodBeat.o(51446);
        return cxp;
    }

    private /* synthetic */ AppBrandGameEvaluateOptionView(Context context, AttributeSet attributeSet, byte b2) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AppBrandGameEvaluateOptionView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(51444);
        this.handler = new MMHandler(Looper.getMainLooper());
        View inflate = LayoutInflater.from(context).inflate(R.layout.dx, (ViewGroup) this, false);
        if (inflate == null) {
            t tVar = new t("null cannot be cast to non-null type android.widget.FrameLayout");
            AppMethodBeat.o(51444);
            throw tVar;
        }
        this.oqM = (FrameLayout) inflate;
        addView(this.oqM);
        this.oqM.setOnClickListener(this);
        AppMethodBeat.o(51444);
    }

    public final void a(int i2, ffc ffc, a aVar) {
        AppMethodBeat.i(51442);
        p.h(ffc, "config");
        p.h(aVar, "callback");
        this.oqL = aVar;
        cxp cxp = ffc.NAv.get(i2);
        p.g(cxp, "config.OptionList[index]");
        this.oqK = cxp;
        View findViewById = this.oqM.findViewById(R.id.ijq);
        p.g(findViewById, "view.findViewById<TextView>(R.id.text)");
        TextView textView = (TextView) findViewById;
        cxp cxp2 = this.oqK;
        if (cxp2 == null) {
            p.btv("optionConfig");
        }
        textView.setText(cxp2.MCb);
        com.tencent.mm.av.a.a bdb = com.tencent.mm.av.a.a.bdb();
        cxp cxp3 = this.oqK;
        if (cxp3 == null) {
            p.btv("optionConfig");
        }
        bdb.loadImage(cxp3.IconUrl, (ImageView) this.oqM.findViewById(R.id.dup));
        AppMethodBeat.o(51442);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(51443);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandGameEvaluateOptionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        this.oqM.setBackgroundResource(R.color.Brand_Alpha_0_1);
        ((TextView) this.oqM.findViewById(R.id.ijq)).setTextColor(com.tencent.mm.cb.a.n(getContext(), R.color.Brand));
        this.handler.postDelayed(new b(this), 100);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/dialog/AppBrandGameEvaluateOptionView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(51443);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ AppBrandGameEvaluateOptionView oqN;

        b(AppBrandGameEvaluateOptionView appBrandGameEvaluateOptionView) {
            this.oqN = appBrandGameEvaluateOptionView;
        }

        public final void run() {
            AppMethodBeat.i(51441);
            AppBrandGameEvaluateOptionView.a(this.oqN).a(AppBrandGameEvaluateOptionView.b(this.oqN));
            AppMethodBeat.o(51441);
        }
    }
}
