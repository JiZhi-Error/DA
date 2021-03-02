package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.compatible.util.n;
import com.tencent.mm.modelappbrand.b;
import com.tencent.mm.plugin.appbrand.ac;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSSearchTabWebViewUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.a;
import com.tencent.smtt.sdk.TbsListener;
import java.util.HashMap;
import java.util.List;

public class AppBrandSearchUI extends FTSSearchTabWebViewUI {
    private String nWA;
    private View nWy;
    private String nWz;
    private int scene;

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.webview.ui.tools.fts.FTSSearchTabWebViewUI, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI, com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.webview.ui.tools.fts.FTSSearchTabWebViewUI, android.support.v7.app.AppCompatActivity, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(21134);
        super.onCreate(bundle);
        ai.afu(ai.aft(3));
        this.nWA = getIntent().getStringExtra("key_session_id");
        this.scene = getIntent().getIntExtra("ftsbizscene", 0);
        Log.i("MicroMsg.AppBrandSearchUI", "onCreate oreh report weAppSearchClickStream(13929) statSessionId:%s", this.nWA);
        h.INSTANCE.a(13929, this.nWA, "", 1, Integer.valueOf(this.scene));
        Intent intent = new Intent();
        intent.putExtra("key_session_id", this.nWA);
        intent.putExtra("ftsbizscene", this.scene);
        setResult(-1, intent);
        AppMethodBeat.o(21134);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI
    public final void bXg() {
        AppMethodBeat.i(21138);
        super.bXg();
        if (this.JnL != null && !Util.isNullOrNil(this.query)) {
            this.JnL.getFtsEditText().O(this.query, null);
            this.JnL.getFtsEditText().vy.clearFocus();
            hideVKB();
        }
        AppMethodBeat.o(21138);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final int bXh() {
        AppMethodBeat.i(21140);
        if (Build.VERSION.SDK_INT >= 23 && (!g.isMIUI() || !AppBrandNearbyWebViewUI.isMIUIV8())) {
            ao.d(getWindow(), true);
            AppMethodBeat.o(21140);
            return -855310;
        } else if (Build.VERSION.SDK_INT >= 21) {
            int i2 = ac.kEM;
            AppMethodBeat.o(21140);
            return i2;
        } else {
            int bXh = super.bXh();
            AppMethodBeat.o(21140);
            return bXh;
        }
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI, android.support.v4.app.FragmentActivity, com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(21141);
        if (this.scene == 3 || this.scene == 16) {
            h.INSTANCE.a(13929, this.nWA, b.iIn, 2, Integer.valueOf(this.scene));
        }
        super.onDestroy();
        AppMethodBeat.o(21141);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.fts.FTSSearchTabWebViewUI, com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI, com.tencent.mm.ui.search.FTSEditTextView.a
    public final boolean awE() {
        AppMethodBeat.i(21142);
        this.nWy.setVisibility(8);
        boolean awE = super.awE();
        AppMethodBeat.o(21142);
        return awE;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI, com.tencent.mm.ui.search.FTSEditTextView.a
    public final void a(String str, String str2, List<a.c> list, FTSEditTextView.b bVar) {
        AppMethodBeat.i(163181);
        if (!TextUtils.isEmpty(str2) && this.nWy != null) {
            this.nWy.setVisibility(8);
        }
        if (this.mHh == null) {
            Log.i("MicroMsg.AppBrandSearchUI", "invoker is null");
        } else {
            try {
                this.mHh.j(10001, null);
            } catch (RemoteException e2) {
                Log.e("MicroMsg.AppBrandSearchUI", "refresh keyword id error : %s", e2);
            }
        }
        super.a(str, str2, list, bVar);
        AppMethodBeat.o(163181);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void dealContentView(View view) {
        int i2;
        AppMethodBeat.i(21144);
        super.dealContentView(view);
        this.nWz = getIntent().getStringExtra("key_nearby_url");
        getIntent().getStringExtra("key_nearby_list_id");
        this.nWy = getLayoutInflater().inflate(R.layout.fg, (ViewGroup) view, false);
        View findViewById = this.nWy.findViewById(R.id.fty);
        findViewById.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandSearchUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(21132);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandSearchUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (TextUtils.isEmpty(AppBrandSearchUI.this.nWz)) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandSearchUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(21132);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("showShare", false);
                intent.putExtra("rawUrl", AppBrandSearchUI.this.nWz);
                intent.putExtra("geta8key_scene", 41);
                intent.putExtra("show_long_click_popup_menu", false);
                c.b(view.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandSearchUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(21132);
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
            AppMethodBeat.o(21144);
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
        AppMethodBeat.o(21144);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI, com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI
    public final void m(int i2, Bundle bundle) {
        AppMethodBeat.i(21146);
        super.m(i2, bundle);
        switch (i2) {
            case TbsListener.ErrorCode.NEEDDOWNLOAD_3 /*{ENCODED_INT: 142}*/:
                final String string = bundle.getString("fts_key_json_data");
                final int i3 = bundle.getInt("fts_key_is_cache_data", 0);
                final int i4 = bundle.getInt("fts_key_is_expired", 1);
                final int i5 = bundle.getInt("fts_key_is_preload", 0);
                this.handler.post(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.ui.AppBrandSearchUI.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(21133);
                        if (AppBrandSearchUI.this.IBw != null) {
                            com.tencent.mm.plugin.webview.d.h hVar = AppBrandSearchUI.this.IBw;
                            String str = string;
                            int i2 = i3;
                            int i3 = i4;
                            int i4 = i5;
                            if (!hVar.GBl) {
                                Log.e("MicroMsg.JsApiHandler", "onSearchGuideDataReady fail, not ready");
                                AppMethodBeat.o(21133);
                                return;
                            }
                            Log.i("MicroMsg.JsApiHandler", "onSearchGuideDataReady success, ready");
                            HashMap hashMap = new HashMap();
                            hashMap.put("json", str);
                            hashMap.put("isCacheData", Integer.valueOf(i2));
                            hashMap.put("isExpired", Integer.valueOf(i3));
                            hashMap.put("isPreload", Integer.valueOf(i4));
                            MMHandlerThread.postToMainThread(new Runnable(n.a.b("onSearchGuideDataReady", hashMap, hVar.IRj, hVar.zpY)) {
                                /* class com.tencent.mm.plugin.webview.d.h.AnonymousClass63 */
                                final /* synthetic */ String mNN;

                                {
                                    this.mNN = r2;
                                }

                                public final void run() {
                                    AppMethodBeat.i(224275);
                                    try {
                                        h.this.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + this.mNN + ")", null);
                                        AppMethodBeat.o(224275);
                                    } catch (Exception e2) {
                                        Log.e("MicroMsg.JsApiHandler", "onSearchGuideDataReady fail, ex = %s", e2.getMessage());
                                        AppMethodBeat.o(224275);
                                    }
                                }
                            });
                        }
                        AppMethodBeat.o(21133);
                    }
                });
                break;
        }
        AppMethodBeat.o(21146);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.fts.FTSSearchTabWebViewUI, com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI
    public final String getHint() {
        AppMethodBeat.i(21147);
        String stringExtra = getIntent().getStringExtra("key_search_place_holder");
        if (stringExtra == null || stringExtra.length() <= 0) {
            String hint = super.getHint();
            AppMethodBeat.o(21147);
            return hint;
        }
        AppMethodBeat.o(21147);
        return stringExtra;
    }
}
