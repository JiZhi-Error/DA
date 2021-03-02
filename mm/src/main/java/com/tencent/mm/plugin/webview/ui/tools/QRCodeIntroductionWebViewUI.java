package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.ui.base.h;

public class QRCodeIntroductionWebViewUI extends WebViewUI {
    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(79672);
        super.onCreate(bundle);
        addIconOptionMenu(0, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.QRCodeIntroductionWebViewUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(79669);
                QRCodeIntroductionWebViewUI.a(QRCodeIntroductionWebViewUI.this);
                AppMethodBeat.o(79669);
                return true;
            }
        });
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.QRCodeIntroductionWebViewUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(79670);
                QRCodeIntroductionWebViewUI.this.finish();
                AppMethodBeat.o(79670);
                return true;
            }
        });
        AppMethodBeat.o(79672);
    }

    static /* synthetic */ void a(QRCodeIntroductionWebViewUI qRCodeIntroductionWebViewUI) {
        AppMethodBeat.i(79673);
        h.b(qRCodeIntroductionWebViewUI, "", new String[]{qRCodeIntroductionWebViewUI.getString(R.string.h9u), qRCodeIntroductionWebViewUI.getString(R.string.fsi)}, "", new h.d() {
            /* class com.tencent.mm.plugin.webview.ui.tools.QRCodeIntroductionWebViewUI.AnonymousClass3 */

            @Override // com.tencent.mm.ui.base.h.d
            public final void oj(int i2) {
                AppMethodBeat.i(79671);
                switch (i2) {
                    case 0:
                        QRCodeIntroductionWebViewUI.this.IBw.c(null, 0);
                        AppMethodBeat.o(79671);
                        return;
                    case 1:
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(QRCodeIntroductionWebViewUI.this.coX()));
                        QRCodeIntroductionWebViewUI qRCodeIntroductionWebViewUI = QRCodeIntroductionWebViewUI.this;
                        a bl = new a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(qRCodeIntroductionWebViewUI, bl.axQ(), "com/tencent/mm/plugin/webview/ui/tools/QRCodeIntroductionWebViewUI$3", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        qRCodeIntroductionWebViewUI.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(qRCodeIntroductionWebViewUI, "com/tencent/mm/plugin/webview/ui/tools/QRCodeIntroductionWebViewUI$3", "onClick", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        break;
                }
                AppMethodBeat.o(79671);
            }
        });
        AppMethodBeat.o(79673);
    }
}
