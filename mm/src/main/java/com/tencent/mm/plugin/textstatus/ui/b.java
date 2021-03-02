package com.tencent.mm.plugin.textstatus.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u0004\u0018\u00010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0014J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u000bH\u0014J\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/MMCardDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "layoutCustom", "Landroid/widget/LinearLayout;", "viewBack", "Landroid/view/View;", "getLayoutCustom", "initUI", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "setCustomView", "customView", "plugin-textstatus_release"})
public class b extends Dialog {
    LinearLayout GcD;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context, R.style.m1);
        p.h(context, "context");
        AppMethodBeat.i(216365);
        AppMethodBeat.o(216365);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(216362);
        super.onCreate(bundle);
        initUI();
        AppMethodBeat.o(216362);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        AppMethodBeat.i(216363);
        super.onStart();
        Window window = getWindow();
        if (window != null) {
            window.addFlags(67108864);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setDimAmount(0.5f);
        }
        Window window3 = getWindow();
        if (window3 != null) {
            window3.setLayout(-1, -1);
            AppMethodBeat.o(216363);
            return;
        }
        AppMethodBeat.o(216363);
    }

    /* access modifiers changed from: protected */
    public void initUI() {
        AppMethodBeat.i(216364);
        Window window = getWindow();
        if (window != null) {
            window.setWindowAnimations(R.style.zl);
        }
        setContentView(LayoutInflater.from(getContext()).inflate(R.layout.mq, (ViewGroup) null, false));
        this.GcD = (LinearLayout) findViewById(R.id.e9v);
        findViewById(R.id.bqs).setOnClickListener(new a(this));
        AppMethodBeat.o(216364);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class a implements View.OnClickListener {
        final /* synthetic */ b GcE;

        a(b bVar) {
            this.GcE = bVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(216361);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/MMCardDialog$initUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.GcE.dismiss();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/MMCardDialog$initUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(216361);
        }
    }
}
