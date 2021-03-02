package com.tencent.mm.plugin.webview.ui.tools.browser.view;

import android.content.Context;
import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.browser.f;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0014\u0010\u0012\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\rJ\u0010\u0010\u0016\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\tR\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialog;", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BaseBrowseDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mBrowserList", "", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "mDialogClickListener", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/listener/BrowserSettingDialogClickListener;", "mDialogView", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialogView;", "selectedIndex", "", "onCreateDialogView", "Landroid/view/View;", "release", "", "setBrowserList", "list", "setBrowserSelectedIndex", FirebaseAnalytics.b.INDEX, "setBrowserSettingDialogClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Companion", "plugin-webview_release"})
public final class c extends a {
    public static final a Jmm = new a((byte) 0);
    public List<f> Jli;
    public BrowserSettingDialogView Jmk;
    public com.tencent.mm.plugin.webview.ui.tools.browser.listener.c Jml;
    public int bxP = -1;

    static {
        AppMethodBeat.i(210470);
        AppMethodBeat.o(210470);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserSettingDialog$Companion;", "", "()V", "TAG", "", "plugin-webview_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public c(Context context) {
        super(context);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.browser.view.a
    public final View onCreateDialogView() {
        AppMethodBeat.i(210469);
        Context context = getContext();
        p.g(context, "context");
        this.Jmk = new BrowserSettingDialogView(context);
        BrowserSettingDialogView browserSettingDialogView = this.Jmk;
        if (browserSettingDialogView != null) {
            c cVar = this;
            p.h(cVar, "dialog");
            browserSettingDialogView.JlX = cVar;
        }
        BrowserSettingDialogView browserSettingDialogView2 = this.Jmk;
        if (browserSettingDialogView2 != null) {
            browserSettingDialogView2.setBrowserList(this.Jli);
        }
        BrowserSettingDialogView browserSettingDialogView3 = this.Jmk;
        if (browserSettingDialogView3 != null) {
            browserSettingDialogView3.setSelectedBrowser(this.bxP);
        }
        BrowserSettingDialogView browserSettingDialogView4 = this.Jmk;
        if (browserSettingDialogView4 != null) {
            browserSettingDialogView4.setBrowserSettingDialogClickListener(this.Jml);
        }
        BrowserSettingDialogView browserSettingDialogView5 = this.Jmk;
        if (browserSettingDialogView5 == null) {
            p.hyc();
        }
        BrowserSettingDialogView browserSettingDialogView6 = browserSettingDialogView5;
        AppMethodBeat.o(210469);
        return browserSettingDialogView6;
    }
}
