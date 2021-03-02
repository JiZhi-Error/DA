package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.content.Context;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.vendor.MIUI;
import com.tencent.mm.ui.ao;
import com.tencent.smtt.sdk.WebView;

public class FTSSOSMoreWebViewUI extends BaseSOSWebViewUI {
    private View JoE;
    private int Joe;

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI, com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI, com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        boolean z = false;
        AppMethodBeat.i(211289);
        super.onCreate(bundle);
        this.JoE = findViewById(R.id.jkw);
        ggL().fYP();
        ggL().gXf();
        ggL().gWY();
        this.Joe = a.fromDPToPix((Context) this, 48);
        if (getScene() == 24) {
            this.JoE.setVisibility(4);
        }
        findViewById(R.id.h8v).setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSMoreWebViewUI.AnonymousClass1 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(80690);
                FTSSOSMoreWebViewUI.this.ggL().vy.clearFocus();
                FTSSOSMoreWebViewUI.this.hideVKB();
                AppMethodBeat.o(80690);
                return false;
            }
        });
        if (getIntent() != null && getIntent().getBooleanExtra("ftsneedkeyboard", false)) {
            getContentView().postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSMoreWebViewUI.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(80691);
                    FTSSOSMoreWebViewUI.this.ggL().awD();
                    FTSSOSMoreWebViewUI.this.ggL().awC();
                    AppMethodBeat.o(80691);
                }
            }, 128);
        }
        int color = getResources().getColor(R.color.afz);
        if (!ao.isDarkMode()) {
            z = true;
        }
        bt(color, z);
        ImageButton clearBtn = ggL().getClearBtn();
        if (clearBtn != null) {
            clearBtn.getDrawable().setColorFilter(WebView.NIGHT_MODE_COLOR, PorterDuff.Mode.SRC_ATOP);
        }
        AppMethodBeat.o(211289);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final int bXh() {
        AppMethodBeat.i(80693);
        if (!d.oD(23) || MIUI.isMIUIV8()) {
            int bXh = super.bXh();
            AppMethodBeat.o(80693);
            return bXh;
        }
        int color = getResources().getColor(R.color.afz);
        AppMethodBeat.o(80693);
        return color;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI, com.tencent.mm.ui.search.FTSEditTextView.a
    public final void eh(boolean z) {
        AppMethodBeat.i(80694);
        super.eh(z);
        if (!z) {
            this.Jnb.setPadding(this.Joe, 0, this.Jnb.getPaddingRight(), 0);
            ggL().gWY();
        }
        ggL().gXf();
        AppMethodBeat.o(80694);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI, com.tencent.mm.ui.search.FTSEditTextView.a
    public boolean awE() {
        AppMethodBeat.i(80695);
        ggL().gXf();
        this.JoE.setVisibility(0);
        boolean awE = super.awE();
        AppMethodBeat.o(80695);
        return awE;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.byf;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI
    public final void ggF() {
        AppMethodBeat.i(80696);
        finish();
        AppMethodBeat.o(80696);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI
    public String getHint() {
        AppMethodBeat.i(80697);
        int i2 = -1;
        if (getType() != 8 || !this.Jnz) {
            switch (getType()) {
                case 1:
                    i2 = R.string.ggc;
                    break;
                case 2:
                    i2 = R.string.ggb;
                    break;
                case 8:
                    i2 = R.string.djv;
                    break;
                case 16:
                    i2 = R.string.djt;
                    break;
                case 64:
                    i2 = R.string.ko;
                    break;
                case 128:
                    i2 = R.string.djj;
                    break;
                case 256:
                case 384:
                    i2 = R.string.dji;
                    break;
                case 512:
                    i2 = R.string.djr;
                    break;
                case 1024:
                    i2 = R.string.djs;
                    break;
            }
        } else {
            i2 = R.string.djw;
        }
        if (i2 < 0) {
            String str = MMApplicationContext.getContext().getResources().getString(R.string.yn) + agR(getType());
            AppMethodBeat.o(80697);
            return str;
        }
        String string = MMApplicationContext.getContext().getResources().getString(R.string.gga, MMApplicationContext.getContext().getResources().getString(i2));
        AppMethodBeat.o(80697);
        return string;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI
    public final void ggH() {
        AppMethodBeat.i(80698);
        super.ggH();
        this.JoE.setVisibility(0);
        AppMethodBeat.o(80698);
    }
}
