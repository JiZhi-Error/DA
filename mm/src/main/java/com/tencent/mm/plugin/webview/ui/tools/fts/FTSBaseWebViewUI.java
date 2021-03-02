package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.ah;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.websearch.api.f;
import com.tencent.mm.plugin.webview.core.i;
import com.tencent.mm.plugin.webview.core.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.WebSearchView;
import com.tencent.mm.ui.search.a;
import com.tencent.mm.vfs.s;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FTSBaseWebViewUI extends BaseSearchWebViewUI implements FTSEditTextView.a, com.tencent.mm.ui.search.b {
    private boolean Jmy;
    protected WebSearchView JnL;
    private boolean JnM;
    private boolean JnN;
    private LinkedList<String> JnO = new LinkedList<>();
    private b JnP = new b(this, (byte) 0);
    private e Jng;
    private com.tencent.mm.plugin.webview.fts.d.a Jnh;
    int scene;
    private View tql;
    int type;

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FTSBaseWebViewUI() {
        AppMethodBeat.i(211237);
        AppMethodBeat.o(211237);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(80602);
        super.onCreate(bundle);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        this.Jnh = new com.tencent.mm.plugin.webview.fts.d.a(this.pGj);
        this.Jng = new e(((f) g.af(f.class)).a(getContext(), this.Jnh));
        String trim = Util.nullAs(getIntent().getStringExtra("ftsQuery"), "").trim();
        this.type = getIntent().getIntExtra("ftsType", 0);
        this.scene = getIntent().getIntExtra("ftsbizscene", 0);
        this.Jmy = getIntent().getBooleanExtra("ftsneedkeyboard", false);
        this.JnM = getIntent().getBooleanExtra("ftscaneditable", true);
        this.JnN = getIntent().getBooleanExtra("key_hide_cancel_btn", false);
        if (this.pGj != null) {
            this.pGj.setOnTouchListener(new View.OnTouchListener() {
                /* class com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.AnonymousClass1 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(80581);
                    FTSBaseWebViewUI.this.hideVKB();
                    FTSBaseWebViewUI.this.ggR();
                    AppMethodBeat.o(80581);
                    return false;
                }
            });
        }
        this.JnL = (WebSearchView) findViewById(R.id.jkj);
        this.tql = findViewById(R.id.iq5);
        if (this.JnM) {
            this.tql.setVisibility(8);
            this.JnL.setSearchViewListener(this);
            this.JnL.getFtsEditText().setHint(getHint());
            this.JnL.getFtsEditText().setFtsEditTextListener(this);
            if (this.JnN) {
                this.JnL.getCancelBtn().setVisibility(8);
            }
            if (!Util.isNullOrNil(trim)) {
                this.JnL.getFtsEditText().O(trim, null);
                alC(trim);
            }
            if (this.Jmy) {
                this.JnL.getFtsEditText().awD();
                this.JnL.getFtsEditText().awC();
            }
            if (getIntent().getBooleanExtra("key_change_search_icon", false)) {
                this.JnL.getSearchIcon().setVisibility(8);
                this.JnL.getFtsEditText().gXe();
                this.JnL.getFtsEditText().getIconView().setImageDrawable(agS(this.type));
            }
        } else {
            this.JnL.setVisibility(8);
            String stringExtra = getIntent().getStringExtra("title");
            if (!Util.isNullOrNil(stringExtra)) {
                ((TextView) findViewById(R.id.xz)).setText(stringExtra);
            }
            findViewById(R.id.xt).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.AnonymousClass8 */

                public final void onClick(View view) {
                    AppMethodBeat.i(211229);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/fts/FTSBaseWebViewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    FTSBaseWebViewUI.this.finish();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/fts/FTSBaseWebViewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(211229);
                }
            });
        }
        showOptionMenu(false);
        if (this.JjI != null) {
            this.JjI.zh(true);
        }
        if (this.pGj != null) {
            this.pGj.setOnLongClickListener(new View.OnLongClickListener() {
                /* class com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.AnonymousClass9 */

                public final boolean onLongClick(View view) {
                    AppMethodBeat.i(211230);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/fts/FTSBaseWebViewUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/webview/ui/tools/fts/FTSBaseWebViewUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(211230);
                    return true;
                }
            });
        }
        this.Jnh.IBw = this.IBw;
        AppMethodBeat.o(80602);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI
    public final i cpO() {
        AppMethodBeat.i(211238);
        i cpO = super.cpO();
        if (cpO != null) {
            cpO.a(this.JnP);
        }
        AppMethodBeat.o(211238);
        return cpO;
    }

    private boolean ggS() {
        AppMethodBeat.i(211239);
        if (this.JnO.size() <= 1) {
            hideVKB();
            finish();
            AppMethodBeat.o(211239);
            return true;
        }
        this.JnO.removeLast();
        this.JnL.getFtsEditText().O(this.JnO.getLast(), null);
        this.JnL.getFtsEditText().vy.clearFocus();
        hideVKB();
        ggT();
        AppMethodBeat.o(211239);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(211240);
        if (ggS()) {
            super.onBackPressed();
        }
        AppMethodBeat.o(211240);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final int gfD() {
        return R.raw.actionbar_icon_dark_back;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final boolean gfO() {
        return true;
    }

    /* access modifiers changed from: protected */
    public final String getTotalQuery() {
        AppMethodBeat.i(80605);
        String totalQuery = this.JnL.getFtsEditText().getTotalQuery();
        AppMethodBeat.o(80605);
        return totalQuery;
    }

    /* access modifiers changed from: protected */
    public final String getInEditTextQuery() {
        AppMethodBeat.i(80606);
        String inEditTextQuery = this.JnL.getFtsEditText().getInEditTextQuery();
        AppMethodBeat.o(80606);
        return inEditTextQuery;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final boolean gfE() {
        return false;
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public final void dpw() {
        AppMethodBeat.i(164031);
        if (!this.JnL.getFtsEditText().vy.hasFocus()) {
            this.JnL.getFtsEditText().awD();
            showVKB();
        }
        AppMethodBeat.o(164031);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(80609);
        super.onResume();
        this.Jng.onResume();
        AppMethodBeat.o(80609);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(80610);
        super.onPause();
        this.Jng.onPause();
        AppMethodBeat.o(80610);
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public void a(String str, String str2, List<a.c> list, FTSEditTextView.b bVar) {
        AppMethodBeat.i(164032);
        Log.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onEditTextChange %s %s %s", str, str2, bVar);
        if (bVar == FTSEditTextView.b.UserInput || bVar == FTSEditTextView.b.ClearText) {
            this.handler.post(new Runnable() {
                /* class com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.AnonymousClass10 */

                public final void run() {
                    AppMethodBeat.i(80588);
                    if (FTSBaseWebViewUI.this.IBw != null) {
                        FTSBaseWebViewUI.this.IBw.a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.ggN(), 0);
                    }
                    AppMethodBeat.o(80588);
                }
            });
        }
        AppMethodBeat.o(164032);
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public final void eh(boolean z) {
        AppMethodBeat.i(80612);
        if (z) {
            this.handler.post(new Runnable() {
                /* class com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.AnonymousClass11 */

                public final void run() {
                    AppMethodBeat.i(80589);
                    if (FTSBaseWebViewUI.this.IBw != null) {
                        FTSBaseWebViewUI.this.IBw.a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.ggN(), 0);
                    }
                    AppMethodBeat.o(80589);
                }
            });
        }
        AppMethodBeat.o(80612);
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public void onClickClearTextBtn(View view) {
        AppMethodBeat.i(80613);
        if (this.JnL != null) {
            if (!this.JnL.getFtsEditText().vy.hasFocus()) {
                this.JnL.getFtsEditText().awD();
                showVKB();
            }
            this.JnL.getFtsEditText().setHint(getHint());
        }
        AppMethodBeat.o(80613);
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public boolean awE() {
        AppMethodBeat.i(80614);
        Log.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onSearchKeyDown");
        if (getTotalQuery().length() > 0) {
            alC(getTotalQuery());
            ggT();
            hideVKB();
        }
        AppMethodBeat.o(80614);
        return false;
    }

    public final JSONArray ggN() {
        AppMethodBeat.i(80615);
        List<a.c> tagList = this.JnL.getFtsEditText().getTagList();
        JSONArray jSONArray = new JSONArray();
        Iterator<a.c> it = tagList.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("tagName", aVar.FeZ);
                jSONObject.put("tagType", aVar.biu);
                jSONObject.put("userName", aVar.userName);
                jSONArray.put(jSONObject);
            } catch (JSONException e2) {
            }
        }
        AppMethodBeat.o(80615);
        return jSONArray;
    }

    /* access modifiers changed from: package-private */
    public class b extends k {
        a JnR;

        private b() {
            AppMethodBeat.i(211234);
            this.JnR = new a(this, (byte) 0);
            AppMethodBeat.o(211234);
        }

        /* synthetic */ b(FTSBaseWebViewUI fTSBaseWebViewUI, byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public class a extends com.tencent.mm.plugin.webview.core.f {
            private a() {
            }

            /* synthetic */ a(b bVar, byte b2) {
                this();
            }

            @Override // com.tencent.mm.plugin.webview.core.f
            public final void b(WebView webView, String str) {
                AppMethodBeat.i(211231);
                Log.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onPageFinished %s", str);
                FTSBaseWebViewUI.this.showOptionMenu(false);
                if (FTSBaseWebViewUI.this.JnL != null && !FTSBaseWebViewUI.this.Jmy) {
                    FTSBaseWebViewUI.this.JnL.getFtsEditText().vy.clearFocus();
                    FTSBaseWebViewUI.this.hideVKB();
                }
                AppMethodBeat.o(211231);
            }

            @Override // com.tencent.mm.plugin.webview.core.f
            public final void i(WebView webView, String str) {
                AppMethodBeat.i(211232);
                Log.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onPageStarted %s", str);
                FTSBaseWebViewUI.this.showOptionMenu(false);
                if (FTSBaseWebViewUI.this.JnL != null && !FTSBaseWebViewUI.this.Jmy) {
                    FTSBaseWebViewUI.this.JnL.getFtsEditText().vy.clearFocus();
                    FTSBaseWebViewUI.this.hideVKB();
                }
                ar.kb(FTSBaseWebViewUI.this.scene, 1);
                ar.kc(FTSBaseWebViewUI.this.scene, 1);
                AppMethodBeat.o(211232);
            }

            @Override // com.tencent.mm.plugin.webview.core.f
            public final void a(WebView webView, int i2, String str, String str2) {
                AppMethodBeat.i(211233);
                if (str2 != null && str2.equals(FTSBaseWebViewUI.this.coX())) {
                    ar.kb(FTSBaseWebViewUI.this.scene, 16);
                }
                AppMethodBeat.o(211233);
            }
        }

        @Override // com.tencent.mm.plugin.webview.core.k
        public final com.tencent.mm.plugin.webview.core.f gai() {
            return this.JnR;
        }

        @Override // com.tencent.mm.plugin.webview.core.k
        public final WebResourceResponse b(WebView webView, WebResourceRequest webResourceRequest) {
            AppMethodBeat.i(211235);
            if (webResourceRequest == null || webResourceRequest.getUrl() == null || !webResourceRequest.getUrl().toString().startsWith("weixin://fts")) {
                AppMethodBeat.o(211235);
                return null;
            }
            WebResourceResponse aXq = aXq(webResourceRequest.getUrl().toString());
            AppMethodBeat.o(211235);
            return aXq;
        }

        private static WebResourceResponse aXq(String str) {
            InputStream inputStream;
            AppMethodBeat.i(211236);
            Log.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "url=%s | thread=%d", str, Long.valueOf(Thread.currentThread().getId()));
            try {
                inputStream = s.openRead(Uri.parse(str).getQueryParameter("path"));
            } catch (Exception e2) {
                inputStream = null;
            }
            if (inputStream != null) {
                WebResourceResponse webResourceResponse = new WebResourceResponse("image/*", "utf8", inputStream);
                AppMethodBeat.o(211236);
                return webResourceResponse;
            }
            AppMethodBeat.o(211236);
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI
    public void m(int i2, Bundle bundle) {
        AppMethodBeat.i(80616);
        switch (i2) {
            case 60:
                this.Jng.c(bundle, this.scene);
                AppMethodBeat.o(80616);
                return;
            case PlayerException.EXCEPTION_TYPE_INITLIB /*{ENCODED_INT: 61}*/:
                this.Jng.bi(bundle);
                AppMethodBeat.o(80616);
                return;
            case 62:
                this.Jng.bj(bundle);
                AppMethodBeat.o(80616);
                return;
            case 119:
                final String string = bundle.getString("fts_key_json_data");
                final String string2 = bundle.getString("fts_key_req_id");
                final boolean z = bundle.getBoolean("fts_key_new_query", true);
                final Bundle bundle2 = bundle.getBundle("fts_key_data");
                aD(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.AnonymousClass14 */

                    public final void run() {
                        AppMethodBeat.i(80592);
                        if (FTSBaseWebViewUI.this.IBw != null) {
                            if (bundle2 == null || bundle2.getInt("isRefresh") != 1 || bundle2.getString("widgetId") == null) {
                                FTSBaseWebViewUI.this.IBw.j(string, z, string2);
                            } else {
                                FTSBaseWebViewUI.this.IBw.lU(bundle2.getString("widgetId"), string);
                                AppMethodBeat.o(80592);
                                return;
                            }
                        }
                        AppMethodBeat.o(80592);
                    }
                });
                AppMethodBeat.o(80616);
                return;
            case 120:
                final int i3 = bundle.getInt("fts_key_ret", 0);
                final String string3 = bundle.getString("fts_key_data");
                this.handler.post(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.AnonymousClass15 */

                    public final void run() {
                        AppMethodBeat.i(80593);
                        if (FTSBaseWebViewUI.this.IBw != null) {
                            FTSBaseWebViewUI.this.IBw.cQ(i3, string3);
                        }
                        AppMethodBeat.o(80593);
                    }
                });
                AppMethodBeat.o(80616);
                return;
            case 121:
                final String string4 = bundle.getString("fts_key_json_data");
                final int i4 = bundle.getInt("fts_key_teach_request_type", 0);
                final int i5 = bundle.getInt("fts_key_is_cache_data", 0);
                aD(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(80582);
                        if (FTSBaseWebViewUI.this.IBw != null) {
                            FTSBaseWebViewUI.this.IBw.x(i4, string4, i5);
                        }
                        AppMethodBeat.o(80582);
                    }
                });
                AppMethodBeat.o(80616);
                return;
            case 122:
                String string5 = bundle.getString("fts_key_new_query");
                String string6 = bundle.getString("fts_key_custom_query");
                boolean z2 = bundle.getBoolean("fts_key_need_keyboard", false);
                String string7 = bundle.getString("fts_key_tag_list");
                boolean z3 = bundle.getBoolean("fts_key_cache", false);
                Log.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "onFTSSearchQueryChange: totalQuery: %s isInputChange %b", string5, Boolean.valueOf(z2));
                ArrayList arrayList = new ArrayList();
                try {
                    if (!Util.isNullOrNil(string7)) {
                        JSONArray jSONArray = new JSONArray(string7);
                        for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i6);
                            a aVar = new a();
                            aVar.FeZ = jSONObject.getString("tagName");
                            aVar.biu = jSONObject.getInt("tagType");
                            aVar.userName = jSONObject.getString("userName");
                            arrayList.add(aVar);
                        }
                    }
                } catch (Exception e2) {
                }
                if (this.JnL != null) {
                    if (arrayList.size() > 0) {
                        this.JnL.getFtsEditText().O(string6, arrayList);
                        if (z3) {
                            alC(string6);
                        }
                    } else {
                        this.JnL.getFtsEditText().O(string5, arrayList);
                        if (z3) {
                            alC(string5);
                        }
                    }
                }
                if (z2) {
                    this.handler.post(new Runnable() {
                        /* class com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.AnonymousClass3 */

                        public final void run() {
                            AppMethodBeat.i(80583);
                            if (FTSBaseWebViewUI.this.IBw != null) {
                                FTSBaseWebViewUI.this.IBw.a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.ggN(), 0);
                            }
                            AppMethodBeat.o(80583);
                        }
                    });
                    if (this.JnL != null) {
                        this.JnL.getFtsEditText().awD();
                    }
                    gfU();
                    AppMethodBeat.o(80616);
                    return;
                } else if (this.JnL != null) {
                    this.JnL.getFtsEditText().vy.clearFocus();
                    hideVKB();
                    AppMethodBeat.o(80616);
                    return;
                }
                break;
            case 124:
                final String string8 = bundle.getString("fts_key_json_data");
                this.handler.post(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.AnonymousClass4 */

                    public final void run() {
                        AppMethodBeat.i(80584);
                        if (FTSBaseWebViewUI.this.IBw != null) {
                            FTSBaseWebViewUI.this.IBw.aXm(string8);
                        }
                        AppMethodBeat.o(80584);
                    }
                });
                AppMethodBeat.o(80616);
                return;
            case 125:
                final String string9 = bundle.getString("fts_key_sns_id");
                final int i7 = bundle.getInt("fts_key_status", 0);
                this.handler.post(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.AnonymousClass5 */

                    public final void run() {
                        AppMethodBeat.i(80585);
                        if (FTSBaseWebViewUI.this.IBw != null) {
                            FTSBaseWebViewUI.this.IBw.gq(string9, i7);
                        }
                        AppMethodBeat.o(80585);
                    }
                });
                AppMethodBeat.o(80616);
                return;
            case 126:
                bundle.getString("fts_key_json_data");
                bundle.getBoolean("fts_key_new_query", true);
                final HashMap hashMap = new HashMap();
                for (String str : bundle.keySet()) {
                    hashMap.put(str, bundle.get(str));
                }
                this.handler.post(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.AnonymousClass13 */

                    public final void run() {
                        AppMethodBeat.i(80591);
                        if (FTSBaseWebViewUI.this.IBw != null) {
                            FTSBaseWebViewUI.this.IBw.bK(hashMap);
                        }
                        AppMethodBeat.o(80591);
                    }
                });
                AppMethodBeat.o(80616);
                return;
            case 144:
                AppMethodBeat.o(80616);
                return;
            case TbsListener.ErrorCode.NEEDDOWNLOAD_8 /*{ENCODED_INT: 147}*/:
                final int i8 = bundle.getInt("ret");
                final long j2 = bundle.getLong("reqId");
                final String string10 = bundle.getString("json", "");
                this.handler.post(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.AnonymousClass6 */

                    public final void run() {
                        AppMethodBeat.i(80586);
                        if (FTSBaseWebViewUI.this.IBw != null) {
                            FTSBaseWebViewUI.this.IBw.a(i8, j2, string10);
                            Log.i("MicroMsg.WebSearch.FTSBaseWebViewUI", "wxaapp_opsearch resp, ret = %d, reqId = %d, json = %s", Integer.valueOf(i8), Long.valueOf(j2), string10);
                        }
                        AppMethodBeat.o(80586);
                    }
                });
                AppMethodBeat.o(80616);
                return;
            case TPPlayerMgr.EVENT_ID_APP_ENTER_BACKGROUND /*{ENCODED_INT: 100001}*/:
                this.Jng.bh(bundle);
                AppMethodBeat.o(80616);
                return;
            default:
                super.m(i2, bundle);
                break;
        }
        AppMethodBeat.o(80616);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI
    public final e ggM() {
        return this.Jng;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(80617);
        try {
            if (this.mHh != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("webview_id", hashCode());
                this.mHh.w(1, bundle);
            }
            this.Jng.onDestroy();
        } catch (RemoteException e2) {
        }
        hideVKB();
        this.IMH.b(this.JnP);
        this.IMH.b(this.JnP.JnR);
        super.onDestroy();
        AppMethodBeat.o(80617);
    }

    /* access modifiers changed from: protected */
    public String getHint() {
        return null;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ao6;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final boolean gfT() {
        return false;
    }

    public class a implements a.c {
        String FeZ;
        int biu;
        String userName;

        public a() {
        }

        @Override // com.tencent.mm.ui.search.a.c
        public final String getTagName() {
            return this.FeZ;
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            AppMethodBeat.i(80594);
            if (obj == null || !(obj instanceof a)) {
                AppMethodBeat.o(80594);
                return -1;
            }
            int compareTo = this.FeZ.compareTo(((a) obj).FeZ);
            AppMethodBeat.o(80594);
            return compareTo;
        }
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI
    public final void c(int i2, String str, Map<String, Object> map) {
        AppMethodBeat.i(259671);
        alC(str);
        AppMethodBeat.o(259671);
    }

    private void alC(String str) {
        AppMethodBeat.i(211243);
        this.JnO.remove(str);
        this.JnO.add(str);
        AppMethodBeat.o(211243);
    }

    @Override // com.tencent.mm.ui.search.b
    public void onClickBackBtn(View view) {
        AppMethodBeat.i(80607);
        ggS();
        AppMethodBeat.o(80607);
    }

    private void ggT() {
        AppMethodBeat.i(211241);
        this.handler.post(new Runnable() {
            /* class com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.AnonymousClass12 */

            public final void run() {
                boolean z;
                AppMethodBeat.i(80590);
                if (FTSBaseWebViewUI.this.IBw != null) {
                    FTSBaseWebViewUI.this.IBw.a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.ggN(), 0, (Map<String, Object>) null);
                    if (!TextUtils.isEmpty(FTSBaseWebViewUI.this.getInEditTextQuery())) {
                        int i2 = FTSBaseWebViewUI.this.scene;
                        String str = FTSBaseWebViewUI.this.sessionId;
                        String str2 = FTSBaseWebViewUI.this.dVO;
                        if (FTSBaseWebViewUI.this.JnE == 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        ah.a(i2, str, str2, z, FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.type);
                    }
                }
                AppMethodBeat.o(80590);
            }
        });
        AppMethodBeat.o(211241);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final void gfy() {
        AppMethodBeat.i(80618);
        ggS();
        AppMethodBeat.o(80618);
    }

    @Override // com.tencent.mm.ui.search.b
    public void onClickCancelBtn(View view) {
        AppMethodBeat.i(80619);
        this.JnL.getFtsEditText().O("", null);
        this.handler.post(new Runnable() {
            /* class com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(211228);
                if (FTSBaseWebViewUI.this.IBw != null) {
                    FTSBaseWebViewUI.this.IBw.a(FTSBaseWebViewUI.this.getTotalQuery(), FTSBaseWebViewUI.this.getInEditTextQuery(), FTSBaseWebViewUI.this.ggN(), 1);
                }
                AppMethodBeat.o(211228);
            }
        });
        this.JnL.getFtsEditText().vy.clearFocus();
        hideVKB();
        AppMethodBeat.o(80619);
    }
}
