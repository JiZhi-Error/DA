package com.tencent.mm.plugin.whatsnew.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\f\u001a\u00020\bH\u0014J\b\u0010\r\u001a\u00020\bH\u0014J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/whatsnew/ui/WhatsNewDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "view", "Lcom/tencent/mm/plugin/whatsnew/ui/WhatsNewView;", "enterFullScreen", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "onStop", "onWindowFocusChanged", "hasFocus", "", "app_release"})
public final class d extends Dialog {
    private final WhatsNewView JPc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(Context context) {
        super(context, 16973841);
        p.h(context, "context");
        AppMethodBeat.i(230975);
        this.JPc = new WhatsNewView(context, null, 6, (byte) 0);
        AppMethodBeat.o(230975);
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(230970);
        super.onCreate(bundle);
        this.JPc.setOnFinish(new a(this));
        setContentView(this.JPc);
        KD();
        setOnDismissListener(new b(this));
        setCancelable(false);
        AppMethodBeat.o(230970);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    static final class b implements DialogInterface.OnDismissListener {
        final /* synthetic */ d JPd;

        b(d dVar) {
            this.JPd = dVar;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.i(230969);
            this.JPd.JPc.onDestroy();
            AppMethodBeat.o(230969);
        }
    }

    public final void onWindowFocusChanged(boolean z) {
        AppMethodBeat.i(230971);
        if (z) {
            KD();
        }
        AppMethodBeat.o(230971);
    }

    private final void KD() {
        AppMethodBeat.i(230972);
        Window window = getWindow();
        if (window == null) {
            AppMethodBeat.o(230972);
            return;
        }
        p.g(window, "window ?: return");
        View decorView = window.getDecorView();
        p.g(decorView, "window.decorView");
        decorView.setSystemUiVisibility(3846);
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            window.setAttributes(attributes);
        }
        AppMethodBeat.o(230972);
    }

    /* access modifiers changed from: protected */
    public final void onStart() {
        AppMethodBeat.i(230973);
        super.onStart();
        this.JPc.onStart();
        AppMethodBeat.o(230973);
    }

    /* access modifiers changed from: protected */
    public final void onStop() {
        AppMethodBeat.i(230974);
        super.onStop();
        this.JPc.onStop();
        AppMethodBeat.o(230974);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d JPd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(d dVar) {
            super(0);
            this.JPd = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(230968);
            this.JPd.dismiss();
            x xVar = x.SXb;
            AppMethodBeat.o(230968);
            return xVar;
        }
    }
}
