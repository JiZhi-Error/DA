package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.vendor.MIUI;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.e;
import java.util.ArrayList;

public class FTSSearchTabWebViewUI extends FTSBaseWebViewUI {
    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI, com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(80699);
        super.onCreate(bundle);
        if (d.oD(23) && !MIUI.isMIUIV8()) {
            bt(getResources().getColor(R.color.afz), !ao.isDarkMode());
        }
        AppMethodBeat.o(80699);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI
    public String getHint() {
        AppMethodBeat.i(80700);
        String stringExtra = getIntent().getStringExtra("key_search_input_hint");
        if (!TextUtils.isEmpty(stringExtra)) {
            AppMethodBeat.o(80700);
            return stringExtra;
        }
        int i2 = -1;
        switch (((FTSBaseWebViewUI) this).type) {
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
            case 262208:
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
        if (((FTSBaseWebViewUI) this).scene == 56) {
            i2 = R.string.gh1;
        }
        if (i2 < 0) {
            String string = MMApplicationContext.getContext().getResources().getString(R.string.yn);
            AppMethodBeat.o(80700);
            return string;
        }
        String string2 = MMApplicationContext.getContext().getResources().getString(R.string.gga, MMApplicationContext.getContext().getResources().getString(i2));
        AppMethodBeat.o(80700);
        return string2;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI, android.support.v4.app.FragmentActivity, com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onResume() {
        AppMethodBeat.i(80702);
        super.onResume();
        ar.fYm();
        AppMethodBeat.o(80702);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI, android.support.v4.app.FragmentActivity, com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onPause() {
        AppMethodBeat.i(80703);
        super.onPause();
        ar.fYn();
        AppMethodBeat.o(80703);
    }

    @Override // com.tencent.mm.ui.search.b, com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI
    public void onClickCancelBtn(View view) {
        AppMethodBeat.i(80704);
        super.onClickCancelBtn(view);
        finish();
        AppMethodBeat.o(80704);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final void agP(int i2) {
        AppMethodBeat.i(80705);
        if (this.pGj == null || this.pGj.getSettings() == null) {
            AppMethodBeat.o(80705);
            return;
        }
        float f2 = getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getFloat("current_text_size_scale_key", a.iX(getContext()));
        if (f2 >= a.jd(getContext())) {
            this.pGj.getSettings().setTextZoom(160);
            AppMethodBeat.o(80705);
        } else if (f2 >= a.jc(getContext())) {
            this.pGj.getSettings().setTextZoom(150);
            AppMethodBeat.o(80705);
        } else if (f2 >= a.jb(getContext())) {
            this.pGj.getSettings().setTextZoom(140);
            AppMethodBeat.o(80705);
        } else if (f2 >= a.ja(getContext())) {
            this.pGj.getSettings().setTextZoom(130);
            AppMethodBeat.o(80705);
        } else if (f2 >= a.iZ(getContext())) {
            this.pGj.getSettings().setTextZoom(120);
            AppMethodBeat.o(80705);
        } else if (f2 >= a.iY(getContext())) {
            this.pGj.getSettings().setTextZoom(110);
            AppMethodBeat.o(80705);
        } else if (f2 >= a.iX(getContext())) {
            this.pGj.getSettings().setTextZoom(100);
            AppMethodBeat.o(80705);
        } else if (f2 >= a.iW(getContext())) {
            this.pGj.getSettings().setTextZoom(90);
            AppMethodBeat.o(80705);
        } else {
            this.pGj.getSettings().setTextZoom(80);
            AppMethodBeat.o(80705);
        }
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI, com.tencent.mm.ui.search.FTSEditTextView.a
    public boolean awE() {
        ArrayList<String> stringArrayListExtra;
        AppMethodBeat.i(80701);
        if (this.JnL != null) {
            this.JnL.getFtsEditText().vy.clearFocus();
        }
        int intExtra = getIntent().getIntExtra(e.p.OzF, 0);
        if (!(intExtra == 0 || (stringArrayListExtra = getIntent().getStringArrayListExtra(e.p.OzG)) == null)) {
            h.INSTANCE.a(intExtra, stringArrayListExtra);
        }
        boolean awE = super.awE();
        AppMethodBeat.o(80701);
        return awE;
    }
}
