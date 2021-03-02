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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0014J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\nH\u0014J\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/MMImmerseDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "layoutCustom", "Landroid/widget/LinearLayout;", "viewBack", "Landroid/view/View;", "initUI", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "setCustomView", "customView", "plugin-textstatus_release"})
public class c extends Dialog {
    LinearLayout GcD;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Context context) {
        super(context, R.style.hu);
        p.h(context, "context");
        AppMethodBeat.i(216370);
        AppMethodBeat.o(216370);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(216367);
        super.onCreate(bundle);
        initUI();
        AppMethodBeat.o(216367);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        AppMethodBeat.i(216368);
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
            AppMethodBeat.o(216368);
            return;
        }
        AppMethodBeat.o(216368);
    }

    /* access modifiers changed from: protected */
    public void initUI() {
        AppMethodBeat.i(216369);
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.avx, (ViewGroup) null, false);
        setContentView(inflate);
        Window window = getWindow();
        if (window != null) {
            window.setNavigationBarColor(0);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setType(1000);
        }
        inflate.findViewById(R.id.bqs).setOnClickListener(new a(this));
        this.GcD = (LinearLayout) findViewById(R.id.e9v);
        AppMethodBeat.o(216369);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class a implements View.OnClickListener {
        final /* synthetic */ c GcF;

        a(c cVar) {
            this.GcF = cVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(216366);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/MMImmerseDialog$initUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.GcF.dismiss();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/MMImmerseDialog$initUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(216366);
        }
    }
}
