package com.tencent.mm.plugin.webview.ui.tools.browser.view;

import android.content.Context;
import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.browser.f;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\tJ\u0014\u0010\u0012\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialog;", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BaseBrowseDialog;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mBrowserList", "", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/BrowserItemInfo;", "mDialogClickListener", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/listener/BrowserChooseDialogClickListener;", "mDialogView", "Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialogView;", "onCreateDialogView", "Landroid/view/View;", "release", "", "setBrowserClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setBrowserList", "list", "Companion", "plugin-webview_release"})
public final class b extends a {
    public static final a JlT = new a((byte) 0);
    private BrowserChooseDialogView JlR;
    public com.tencent.mm.plugin.webview.ui.tools.browser.listener.a JlS;
    public List<f> Jli;

    static {
        AppMethodBeat.i(210447);
        AppMethodBeat.o(210447);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/browser/view/BrowserChooseDialog$Companion;", "", "()V", "TAG", "", "plugin-webview_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public b(Context context) {
        super(context);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.browser.view.a
    public final View onCreateDialogView() {
        AppMethodBeat.i(210446);
        Context context = getContext();
        p.g(context, "context");
        this.JlR = new BrowserChooseDialogView(context);
        BrowserChooseDialogView browserChooseDialogView = this.JlR;
        if (browserChooseDialogView != null) {
            b bVar = this;
            p.h(bVar, "dialog");
            browserChooseDialogView.JlX = bVar;
        }
        BrowserChooseDialogView browserChooseDialogView2 = this.JlR;
        if (browserChooseDialogView2 != null) {
            browserChooseDialogView2.setBrowserClickListener(this.JlS);
        }
        BrowserChooseDialogView browserChooseDialogView3 = this.JlR;
        if (browserChooseDialogView3 != null) {
            browserChooseDialogView3.setBrowserList(this.Jli);
        }
        BrowserChooseDialogView browserChooseDialogView4 = this.JlR;
        if (browserChooseDialogView4 == null) {
            p.hyc();
        }
        BrowserChooseDialogView browserChooseDialogView5 = browserChooseDialogView4;
        AppMethodBeat.o(210446);
        return browserChooseDialogView5;
    }
}
