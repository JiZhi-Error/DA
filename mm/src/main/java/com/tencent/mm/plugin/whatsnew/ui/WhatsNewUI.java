package com.tencent.mm.plugin.whatsnew.ui;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.whatsnew.ui.WhatsNewView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@com.tencent.mm.ui.base.a(7)
@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0014J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0014J\b\u0010\u000f\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0014J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/whatsnew/ui/WhatsNewUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "hasGoThroughOnCreated", "", "whatsNewView", "Lcom/tencent/mm/plugin/whatsnew/ui/WhatsNewView;", "enterFullScreen", "", "getLayoutId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onStart", "onStop", "onWindowFocusChanged", "hasFocus", "Companion", "app_release"})
public final class WhatsNewUI extends MMActivity {
    public static final a JPh = new a((byte) 0);
    private WhatsNewView JPf;
    private boolean JPg;

    static {
        AppMethodBeat.i(230986);
        AppMethodBeat.o(230986);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.ccf;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(230980);
        super.onCreate(bundle);
        View findViewById = findViewById(R.id.jnf);
        p.g(findViewById, "findViewById(R.id.whats_new)");
        this.JPf = (WhatsNewView) findViewById;
        KD();
        this.JPg = true;
        WhatsNewView whatsNewView = this.JPf;
        if (whatsNewView == null) {
            p.btv("whatsNewView");
        }
        whatsNewView.setOnFinish(new b(this));
        if (getIntent().getBooleanExtra("from_about", false)) {
            WhatsNewView whatsNewView2 = this.JPf;
            if (whatsNewView2 == null) {
                p.btv("whatsNewView");
            }
            whatsNewView2.oeO.setAlpha(0.0f);
            whatsNewView2.JPl.setAlpha(0.0f);
            whatsNewView2.oeO.animate().alpha(1.0f).setDuration(300).setListener(new WhatsNewView.i(whatsNewView2)).start();
        }
        AppMethodBeat.o(230980);
    }

    private final void KD() {
        AppMethodBeat.i(230981);
        Window window = getWindow();
        p.g(window, "window");
        View decorView = window.getDecorView();
        p.g(decorView, "window.decorView");
        decorView.setSystemUiVisibility(5894);
        AppMethodBeat.o(230981);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void onWindowFocusChanged(boolean z) {
        AppMethodBeat.i(230982);
        AppMethodBeat.at(this, z);
        Log.d("MicroMsg.WhatsNewUI", "hasFocus: %s.", Boolean.valueOf(z));
        if (z && this.JPg) {
            KD();
        }
        AppMethodBeat.o(230982);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onStart() {
        AppMethodBeat.i(230983);
        super.onStart();
        WhatsNewView whatsNewView = this.JPf;
        if (whatsNewView == null) {
            p.btv("whatsNewView");
        }
        whatsNewView.onStart();
        AppMethodBeat.o(230983);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onStop() {
        AppMethodBeat.i(230984);
        super.onStop();
        WhatsNewView whatsNewView = this.JPf;
        if (whatsNewView == null) {
            p.btv("whatsNewView");
        }
        whatsNewView.onStop();
        AppMethodBeat.o(230984);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(230985);
        super.onDestroy();
        WhatsNewView whatsNewView = this.JPf;
        if (whatsNewView == null) {
            p.btv("whatsNewView");
        }
        whatsNewView.onDestroy();
        AppMethodBeat.o(230985);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/whatsnew/ui/WhatsNewUI$Companion;", "", "()V", "TAG", "", "app_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ WhatsNewUI JPi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(WhatsNewUI whatsNewUI) {
            super(0);
            this.JPi = whatsNewUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(230979);
            this.JPi.finish();
            this.JPi.overridePendingTransition(0, 0);
            x xVar = x.SXb;
            AppMethodBeat.o(230979);
            return xVar;
        }
    }
}
