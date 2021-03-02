package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.util.n;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSMoreWebViewUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.a;
import java.util.List;

public class AppBrandSOSUI extends FTSSOSMoreWebViewUI {
    private String nWA;
    private View nWy;
    private String nWz;
    private int scene;

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSMoreWebViewUI, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSMoreWebViewUI, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI, android.support.v7.app.AppCompatActivity, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(21125);
        super.onCreate(bundle);
        overridePendingTransition(R.anim.dd, 0);
        this.nWA = getIntent().getStringExtra("key_session_id");
        this.scene = getIntent().getIntExtra("ftsbizscene", 0);
        Log.i("MicroMsg.AppBrandSOSUI", "onCreate oreh report weAppSearchClickStream(13929) statSessionId:%s", this.nWA);
        h.INSTANCE.a(13929, this.nWA, "", 1, Integer.valueOf(this.scene));
        Intent intent = new Intent();
        intent.putExtra("key_session_id", this.nWA);
        intent.putExtra("ftsbizscene", this.scene);
        setResult(-1, intent);
        AppMethodBeat.o(21125);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI, android.support.v7.app.AppCompatActivity, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(21126);
        if (this.scene == 3 || this.scene == 16) {
            h.INSTANCE.a(13929, this.nWA, b.iIn, 2, Integer.valueOf(this.scene));
        }
        super.onDestroy();
        AppMethodBeat.o(21126);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSMoreWebViewUI, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI, com.tencent.mm.ui.search.FTSEditTextView.a
    public final boolean awE() {
        AppMethodBeat.i(21127);
        this.nWy.setVisibility(8);
        boolean awE = super.awE();
        AppMethodBeat.o(21127);
        return awE;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI, com.tencent.mm.ui.search.FTSEditTextView.a
    public final void a(String str, String str2, List<a.c> list, FTSEditTextView.b bVar) {
        AppMethodBeat.i(163179);
        if (!TextUtils.isEmpty(str2)) {
            this.nWy.setVisibility(8);
        }
        try {
            this.mHh.j(10001, null);
        } catch (RemoteException e2) {
            Log.e("MicroMsg.AppBrandSOSUI", "refresh keyword id error : %s", e2);
        }
        super.a(str, str2, list, bVar);
        AppMethodBeat.o(163179);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void dealContentView(View view) {
        int i2;
        AppMethodBeat.i(21129);
        super.dealContentView(view);
        this.nWz = getIntent().getStringExtra("key_nearby_url");
        getIntent().getStringExtra("key_nearby_list_id");
        this.nWy = getLayoutInflater().inflate(R.layout.fg, (ViewGroup) view, false);
        View findViewById = this.nWy.findViewById(R.id.fty);
        findViewById.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandSOSUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(21124);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandSOSUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (TextUtils.isEmpty(AppBrandSOSUI.this.nWz)) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandSOSUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(21124);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("showShare", false);
                intent.putExtra("rawUrl", AppBrandSOSUI.this.nWz);
                intent.putExtra("geta8key_scene", 41);
                intent.putExtra("show_long_click_popup_menu", false);
                c.b(view.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandSOSUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(21124);
            }
        });
        if (TextUtils.isEmpty(this.nWz)) {
            findViewById.setVisibility(8);
            this.nWy.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
            this.nWy.setVisibility(0);
        }
        if (view instanceof FrameLayout) {
            ((FrameLayout) view).addView(this.nWy);
            AppMethodBeat.o(21129);
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (getWindow().hasFeature(9)) {
            View view2 = this.nWy;
            int paddingLeft = this.nWy.getPaddingLeft();
            Rect rect = new Rect();
            int actionBarHeight = getActionBarHeight();
            View decorView = getWindow().getDecorView();
            decorView.getWindowVisibleDisplayFrame(rect);
            int height = decorView.getHeight();
            int[] iArr = new int[2];
            decorView.getLocationOnScreen(iArr);
            if (height == 0) {
                actionBarHeight += n.D(getContext(), 0);
            }
            if (height - rect.height() < 0 || iArr[1] <= 200) {
                i2 = actionBarHeight + rect.top;
            } else {
                i2 = actionBarHeight + (height - rect.height());
            }
            view2.setPadding(paddingLeft, i2 + this.nWy.getPaddingTop(), this.nWy.getPaddingRight(), this.nWy.getPaddingBottom());
        }
        addContentView(this.nWy, layoutParams);
        AppMethodBeat.o(21129);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.fts.FTSSOSMoreWebViewUI, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI
    public final String getHint() {
        AppMethodBeat.i(21131);
        String stringExtra = getIntent().getStringExtra("key_search_place_holder");
        if (stringExtra == null || stringExtra.length() <= 0) {
            String hint = super.getHint();
            AppMethodBeat.o(21131);
            return hint;
        }
        AppMethodBeat.o(21131);
        return stringExtra;
    }
}
