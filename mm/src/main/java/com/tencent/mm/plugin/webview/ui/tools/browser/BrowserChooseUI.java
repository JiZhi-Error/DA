package com.tencent.mm.plugin.webview.ui.tools.browser;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@com.tencent.mm.ui.base.a(7)
@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0002J\u001a\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0007H\u0016J\u001a\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0014J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0012H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\tH\u0014J\u001a\u0010\u001b\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/model/BrowserChooseUIModel;", "()V", "dialogController", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseController;", "hasShownDialog", "", "configStatusBar", "", "dismissDialog", "dialog", "Landroid/app/Dialog;", "withAnimation", "finishUI", "resultCode", "", "data", "Landroid/content/Intent;", "getLayoutId", "getTargetIntent", "getUIContext", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "showDialog", "Companion", "plugin-webview_release"})
public final class BrowserChooseUI extends MMActivity implements com.tencent.mm.plugin.webview.ui.tools.browser.model.a {
    public static final a JlF = new a((byte) 0);
    private final a JlD = new a(this);
    private boolean JlE;

    static {
        AppMethodBeat.i(210429);
        AppMethodBeat.o(210429);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserChooseUI$Companion;", "", "()V", "EXTRA_BROWSER_SETTING_RESULT", "", "EXTRA_KEY_SCENE", "EXTRA_KEY_SHOW_BROWSER_RESOLVE_INFO", "EXTRA_KEY_SHOW_BROWSER_WITH_ANIMATION", "EXTRA_KEY_SHOW_WEBVIEW_MENU", "EXTRA_KEY_TARGET_INTENT", "EXTRA_KEY_TRANSERFER_BACK", "EXTRA_KEY_URL", "TAG", "plugin-webview_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public BrowserChooseUI() {
        AppMethodBeat.i(210428);
        AppMethodBeat.o(210428);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return -1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        Resources resources;
        ActivityInfo activityInfo;
        AppMethodBeat.i(210422);
        super.onCreate(bundle);
        a aVar = this.JlD;
        aVar.mSessionId = System.currentTimeMillis();
        Log.i("MicroMsg.BrowserChooseController", "alvinluo onCreate uiModel: %s, sessionId: %s", aVar.Jlp, Long.valueOf(aVar.mSessionId));
        aVar.Jli.clear();
        String ggv = com.tencent.mm.plugin.webview.ui.tools.browser.storage.a.ggv();
        Context uIContext = aVar.Jlp.getUIContext();
        if (uIContext == null) {
            p.hyc();
        }
        List<ResolveInfo> as = b.as(uIContext, aVar.Jlp.getTargetIntent());
        int i2 = 0;
        for (T t : as) {
            if (t != null) {
                f fVar = new f(1);
                fVar.resolveInfo = t;
                Context uIContext2 = aVar.Jlp.getUIContext();
                if (uIContext2 == null) {
                    p.hyc();
                }
                String b2 = b.b(uIContext2, fVar.resolveInfo);
                p.h(b2, "<set-?>");
                fVar.title = b2;
                ResolveInfo resolveInfo = fVar.resolveInfo;
                if (n.I(ggv, (resolveInfo == null || (activityInfo = resolveInfo.activityInfo) == null) ? null : activityInfo.packageName, false)) {
                    aVar.Jlk = i2;
                }
                aVar.Jli.add(fVar);
                i2++;
            }
        }
        aVar.Jlj = aVar.Jli.size();
        Log.d("MicroMsg.BrowserChooseController", "alvinluo initBrowserList defaultBrowser: %s, defaultBrowserIndex: %s, %s %s", ggv, Integer.valueOf(aVar.Jlk), Integer.valueOf(as.size()), Integer.valueOf(aVar.Jli.size()));
        if (aVar.Jli.isEmpty()) {
            Context uIContext3 = aVar.Jlp.getUIContext();
            Context uIContext4 = aVar.Jlp.getUIContext();
            Toast.makeText(uIContext3, (uIContext4 == null || (resources = uIContext4.getResources()) == null) ? null : resources.getString(R.string.iyb), 0).show();
            aVar.r(1, null);
        }
        getController().setStatusBarColor(ar.fj(getResources().getColor(R.color.afz), 0));
        AppMethodBeat.o(210422);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(210423);
        super.onResume();
        if (!this.JlE) {
            this.JlE = true;
            h.RTc.n(new b(this), 50);
        }
        AppMethodBeat.o(210423);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ BrowserChooseUI JlG;

        b(BrowserChooseUI browserChooseUI) {
            this.JlG = browserChooseUI;
        }

        public final void run() {
            AppMethodBeat.i(210421);
            a aVar = this.JlG.JlD;
            aVar.ggt();
            c.q(aVar.mSessionId, 1, aVar.Jlj);
            AppMethodBeat.o(210421);
        }
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.browser.model.a
    public final void d(Dialog dialog) {
        AppMethodBeat.i(210424);
        Log.d("MicroMsg.BrowserChooseUI", "alvinluo showDialog dialog: %s, withAnimation: %b", dialog, Boolean.TRUE);
        if (dialog != null) {
            dialog.show();
            AppMethodBeat.o(210424);
            return;
        }
        AppMethodBeat.o(210424);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.browser.model.a
    public final Context getUIContext() {
        AppMethodBeat.i(210425);
        AppCompatActivity context = getContext();
        AppMethodBeat.o(210425);
        return context;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.browser.model.a
    public final Intent getTargetIntent() {
        AppMethodBeat.i(210426);
        Intent intent = (Intent) getIntent().getParcelableExtra("targetintent");
        AppMethodBeat.o(210426);
        return intent;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.browser.model.a
    public final void r(int i2, Intent intent) {
        boolean z = false;
        AppMethodBeat.i(210427);
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i2);
        if (intent == null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        Log.v("MicroMsg.BrowserChooseUI", "alvinluo BrowserDialog finishUI resultCode: %d, data == null: %b", objArr);
        setResult(i2, intent);
        finish();
        AppMethodBeat.o(210427);
    }
}
