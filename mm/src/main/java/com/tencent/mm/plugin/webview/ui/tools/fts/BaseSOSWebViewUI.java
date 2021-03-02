package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.ah;
import com.tencent.mm.plugin.websearch.api.f;
import com.tencent.mm.plugin.websearch.ui.widget.SOSEditTextView;
import com.tencent.mm.plugin.webview.core.i;
import com.tencent.mm.plugin.webview.core.j;
import com.tencent.mm.plugin.webview.core.k;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.a;
import com.tencent.mm.vfs.s;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.thumbplayer.api.TPOptionalID;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseSOSWebViewUI extends BaseSearchWebViewUI implements FTSEditTextView.a {
    private boolean Jmy;
    View Jnb;
    protected SOSEditTextView Jnc;
    protected boolean Jnd;
    private List<c> Jne;
    protected int Jnf = 0;
    private e Jng;
    private com.tencent.mm.plugin.webview.fts.d.a Jnh;
    boolean Jni;
    protected boolean Jnj = false;
    boolean Jnk;
    private b Jnl = new b(this, (byte) 0);
    protected ImageView hNZ;

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public BaseSOSWebViewUI() {
        AppMethodBeat.i(211219);
        AppMethodBeat.o(211219);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(80552);
        super.onCreate(bundle);
        this.Jnd = getIntent().getBooleanExtra("ftsInitToSearch", false);
        getSupportActionBar().hide();
        this.Jmy = getIntent().getBooleanExtra("ftsneedkeyboard", false);
        this.Jnb = findViewById(R.id.hed);
        this.Jnc = (SOSEditTextView) findViewById(R.id.i2j);
        this.Jnc.setFtsEditTextListener(this);
        this.Jnc.setHint(getHint());
        this.Jnc.setCancelTextViewClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(80524);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/fts/BaseSOSWebViewUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                BaseSOSWebViewUI.this.ggF();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/fts/BaseSOSWebViewUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(80524);
            }
        });
        this.hNZ = (ImageView) findViewById(R.id.xt);
        this.hNZ.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.AnonymousClass12 */

            public final void onClick(View view) {
                AppMethodBeat.i(80535);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/fts/BaseSOSWebViewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                BaseSOSWebViewUI.this.fzm();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/ui/tools/fts/BaseSOSWebViewUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(80535);
            }
        });
        this.pGj.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.AnonymousClass14 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(80536);
                BaseSOSWebViewUI.this.ggL().getEditText().clearFocus();
                BaseSOSWebViewUI.this.hideVKB();
                AppMethodBeat.o(80536);
                return false;
            }
        });
        if (this.Jmy) {
            getContentView().postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.AnonymousClass15 */

                public final void run() {
                    AppMethodBeat.i(80537);
                    BaseSOSWebViewUI.this.ggL().awD();
                    BaseSOSWebViewUI.this.ggL().awC();
                    AppMethodBeat.o(80537);
                }
            }, 128);
        }
        if (this.JjI != null) {
            this.JjI.zh(true);
        }
        this.pGj.setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.AnonymousClass16 */

            public final boolean onLongClick(View view) {
                AppMethodBeat.i(211209);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/fts/BaseSOSWebViewUI$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/webview/ui/tools/fts/BaseSOSWebViewUI$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(211209);
                return true;
            }
        });
        this.Jnh = new com.tencent.mm.plugin.webview.fts.d.a(this.pGj);
        this.Jnh.IBw = this.IBw;
        this.Jng = new e(((f) g.af(f.class)).a(getContext(), this.Jnh));
        AppMethodBeat.o(80552);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI
    public final i cpO() {
        AppMethodBeat.i(211220);
        i cpO = super.cpO();
        if (cpO != null) {
            cpO.a(this.Jnl);
        }
        AppMethodBeat.o(211220);
        return cpO;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(80554);
        super.onResume();
        if (this.Jng != null) {
            this.Jng.onResume();
        }
        AppMethodBeat.o(80554);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(80555);
        super.onPause();
        if (this.Jng != null) {
            this.Jng.onPause();
        }
        AppMethodBeat.o(80555);
    }

    /* access modifiers changed from: protected */
    public final boolean ggC() {
        AppMethodBeat.i(211221);
        if (this.Jne == null || this.Jne.size() <= 1) {
            AppMethodBeat.o(211221);
            return false;
        }
        AppMethodBeat.o(211221);
        return true;
    }

    /* access modifiers changed from: protected */
    public void fzm() {
        AppMethodBeat.i(80556);
        hideVKB();
        ggR();
        if (ggC()) {
            this.Jne.remove(0);
            final c cVar = this.Jne.get(0);
            this.Jnc.O(cVar.Jnx, cVar.qLQ);
            this.handler.post(new Runnable() {
                /* class com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.AnonymousClass17 */

                public final void run() {
                    AppMethodBeat.i(80538);
                    if (BaseSOSWebViewUI.this.getJsapi() != null) {
                        BaseSOSWebViewUI.this.ggD();
                        BaseSOSWebViewUI.this.JnE = cVar.type;
                        BaseSOSWebViewUI.this.ggE();
                        HashMap hashMap = new HashMap();
                        hashMap.put("isBackButtonClick", "1");
                        hashMap.put("custom", BaseSOSWebViewUI.this.getInEditTextQuery());
                        BaseSOSWebViewUI.this.getJsapi().a(BaseSOSWebViewUI.this.getTotalQuery(), BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.ggN(), 1, cVar.Jny);
                        if (!TextUtils.isEmpty(BaseSOSWebViewUI.this.getInEditTextQuery())) {
                            ah.a(BaseSOSWebViewUI.this.scene, BaseSOSWebViewUI.this.sessionId, BaseSOSWebViewUI.this.dVO, true, BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.type);
                        }
                    }
                    AppMethodBeat.o(80538);
                }
            });
            AppMethodBeat.o(80556);
        } else if (this.Jni) {
            ggF();
            AppMethodBeat.o(80556);
        } else {
            finish();
            AppMethodBeat.o(80556);
        }
    }

    /* access modifiers changed from: protected */
    public void ggD() {
    }

    /* access modifiers changed from: protected */
    public void ggE() {
    }

    /* access modifiers changed from: protected */
    public void ggF() {
        AppMethodBeat.i(80557);
        if (!this.Jnd) {
            this.Jnc.O("", null);
        }
        hideVKB();
        this.Jnj = true;
        this.handler.post(new Runnable() {
            /* class com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.AnonymousClass18 */

            public final void run() {
                AppMethodBeat.i(80540);
                if (BaseSOSWebViewUI.this.getJsapi() != null) {
                    BaseSOSWebViewUI.this.aD(new Runnable() {
                        /* class com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.AnonymousClass18.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(80539);
                            Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "onClickCancelBtn js api run onSOSCancelButtonClick");
                            h jsapi = BaseSOSWebViewUI.this.getJsapi();
                            int i2 = BaseSOSWebViewUI.this.scene;
                            HashMap hashMap = new HashMap();
                            hashMap.put("isCancelButtonClick", 1);
                            hashMap.put("isInputChange", 1);
                            hashMap.put("scene", Integer.valueOf(i2));
                            jsapi.b("onSearchInputChange", hashMap, null);
                            BaseSOSWebViewUI.this.Jnj = false;
                            BaseSOSWebViewUI.this.ggG();
                            AppMethodBeat.o(80539);
                        }
                    });
                }
                AppMethodBeat.o(80540);
            }
        });
        this.Jne = null;
        this.Jni = false;
        if (this.Jng != null) {
            this.Jng.onDestroy();
        }
        AppMethodBeat.o(80557);
    }

    /* access modifiers changed from: protected */
    public void ggG() {
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final boolean gfO() {
        return true;
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public final void dpw() {
        AppMethodBeat.i(164029);
        if (!this.Jnc.vy.hasFocus()) {
            this.Jnc.awD();
            showVKB();
        }
        AppMethodBeat.o(164029);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final boolean gfE() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final int getType() {
        return this.type;
    }

    /* access modifiers changed from: protected */
    public final int getScene() {
        return this.scene;
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public void a(String str, String str2, List<a.c> list, FTSEditTextView.b bVar) {
        AppMethodBeat.i(164030);
        Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "onEditTextChange %s %s %s", str, str2, bVar);
        if (bVar == FTSEditTextView.b.UserInput || bVar == FTSEditTextView.b.ClearText) {
            this.handler.post(new Runnable() {
                /* class com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.AnonymousClass19 */

                public final void run() {
                    AppMethodBeat.i(80541);
                    if (BaseSOSWebViewUI.this.getJsapi() != null) {
                        BaseSOSWebViewUI.this.getJsapi().a(BaseSOSWebViewUI.this.getTotalQuery(), BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.ggN());
                    }
                    AppMethodBeat.o(80541);
                }
            });
            AppMethodBeat.o(164030);
            return;
        }
        if (bVar == FTSEditTextView.b.SetText) {
            if (this.Jnc.vy.hasFocus()) {
                this.Jnc.gXg();
                AppMethodBeat.o(164030);
                return;
            }
            this.Jnc.gXf();
        }
        AppMethodBeat.o(164030);
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public void eh(boolean z) {
        AppMethodBeat.i(80560);
        if (z && !Util.isNullOrNil(getTotalQuery())) {
            this.handler.post(new Runnable() {
                /* class com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.AnonymousClass20 */

                public final void run() {
                    AppMethodBeat.i(80542);
                    if (BaseSOSWebViewUI.this.getJsapi() != null) {
                        BaseSOSWebViewUI.this.getJsapi().a(BaseSOSWebViewUI.this.getTotalQuery(), BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.ggN());
                    }
                    AppMethodBeat.o(80542);
                }
            });
        }
        AppMethodBeat.o(80560);
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public void onClickClearTextBtn(View view) {
        AppMethodBeat.i(80561);
        if (this.Jnc != null) {
            if (!this.Jnc.vy.hasFocus()) {
                this.Jnc.awD();
                showVKB();
            }
            this.Jnc.setHint(getHint());
        }
        AppMethodBeat.o(80561);
    }

    /* access modifiers changed from: protected */
    public String getHint() {
        return null;
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public boolean awE() {
        AppMethodBeat.i(80562);
        this.Jnc.vy.clearFocus();
        hideVKB();
        if (getTotalQuery().length() > 0) {
            this.handler.post(new Runnable() {
                /* class com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(80525);
                    if (BaseSOSWebViewUI.this.getJsapi() != null) {
                        HashMap hashMap = new HashMap();
                        if (BaseSOSWebViewUI.this.ggK() != 0) {
                            hashMap.put("sugClickType", Integer.valueOf(BaseSOSWebViewUI.this.ggK()));
                            hashMap.put("sugId", BaseSOSWebViewUI.this.ggJ());
                        }
                        h jsapi = BaseSOSWebViewUI.this.getJsapi();
                        String totalQuery = BaseSOSWebViewUI.this.getTotalQuery();
                        String inEditTextQuery = BaseSOSWebViewUI.this.getInEditTextQuery();
                        JSONArray ggN = BaseSOSWebViewUI.this.ggN();
                        HashMap hashMap2 = new HashMap();
                        hashMap2.putAll(hashMap);
                        hashMap2.put(SearchIntents.EXTRA_QUERY, totalQuery);
                        hashMap2.put("custom", inEditTextQuery);
                        hashMap2.put("tagList", ggN);
                        jsapi.b("onSearchInputConfirm", hashMap2, null);
                        if (!TextUtils.isEmpty(BaseSOSWebViewUI.this.getInEditTextQuery())) {
                            ah.a(BaseSOSWebViewUI.this.JnD, BaseSOSWebViewUI.this.sessionId, BaseSOSWebViewUI.this.dVO, true, BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.JnE);
                        }
                    }
                    AppMethodBeat.o(80525);
                }
            });
            hideVKB();
            this.Jni = true;
            AppMethodBeat.o(80562);
        } else {
            AppMethodBeat.o(80562);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void ggH() {
        AppMethodBeat.i(211222);
        Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "onWebViewPageLoaded %b", Boolean.valueOf(this.IRT));
        AppMethodBeat.o(211222);
    }

    /* access modifiers changed from: protected */
    public void ggI() {
        AppMethodBeat.i(211223);
        Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "onWebViewPageStartLoad");
        AppMethodBeat.o(211223);
    }

    /* access modifiers changed from: protected */
    public String ggJ() {
        return "";
    }

    /* access modifiers changed from: protected */
    public int ggK() {
        return 0;
    }

    public final SOSEditTextView ggL() {
        return this.Jnc;
    }

    /* access modifiers changed from: package-private */
    public class b extends k {
        a Jnu;

        private b() {
            AppMethodBeat.i(211213);
            this.Jnu = new a(this, (byte) 0);
            AppMethodBeat.o(211213);
        }

        /* synthetic */ b(BaseSOSWebViewUI baseSOSWebViewUI, byte b2) {
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
                AppMethodBeat.i(211210);
                Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "scene %d, onPageFinished %s", Integer.valueOf(BaseSOSWebViewUI.this.scene), str);
                BaseSOSWebViewUI.this.showOptionMenu(false);
                if (BaseSOSWebViewUI.this.Jnc != null && !BaseSOSWebViewUI.this.Jmy) {
                    BaseSOSWebViewUI.this.Jnc.vy.clearFocus();
                    BaseSOSWebViewUI.this.hideVKB();
                }
                if (!BaseSOSWebViewUI.this.IRT) {
                    ah.b(BaseSOSWebViewUI.this.scene, BaseSOSWebViewUI.this.sessionId, BaseSOSWebViewUI.this.dVO, BaseSOSWebViewUI.this.query, BaseSOSWebViewUI.this.type, "", BaseSOSWebViewUI.this.IRT, BaseSOSWebViewUI.this.hes);
                }
                AppMethodBeat.o(211210);
            }

            @Override // com.tencent.mm.plugin.webview.core.f
            public final void i(WebView webView, String str) {
                AppMethodBeat.i(211211);
                Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "scene %d,onPageStarted %s", Integer.valueOf(BaseSOSWebViewUI.this.scene), str);
                BaseSOSWebViewUI.this.showOptionMenu(false);
                if (BaseSOSWebViewUI.this.Jnc != null && !BaseSOSWebViewUI.this.Jmy) {
                    BaseSOSWebViewUI.this.Jnc.vy.clearFocus();
                    BaseSOSWebViewUI.this.hideVKB();
                }
                if (!BaseSOSWebViewUI.this.IRT) {
                    ah.a(BaseSOSWebViewUI.this.scene, BaseSOSWebViewUI.this.sessionId, BaseSOSWebViewUI.this.dVO, BaseSOSWebViewUI.this.query, BaseSOSWebViewUI.this.type, "", BaseSOSWebViewUI.this.IRT, BaseSOSWebViewUI.this.hes);
                }
                AppMethodBeat.o(211211);
            }
        }

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI$b$b  reason: collision with other inner class name */
        class C1987b extends j {
            private C1987b() {
            }

            /* synthetic */ C1987b(b bVar, byte b2) {
                this();
            }

            @Override // com.tencent.mm.plugin.webview.core.j
            public final void cpR() {
                AppMethodBeat.i(211212);
                BaseSOSWebViewUI.this.Jnk = true;
                BaseSOSWebViewUI.this.ggH();
                AppMethodBeat.o(211212);
            }
        }

        @Override // com.tencent.mm.plugin.webview.core.k
        public final boolean aXQ(String str) {
            AppMethodBeat.i(211214);
            if (BaseSOSWebViewUI.this.IRT) {
                AppMethodBeat.o(211214);
                return true;
            }
            boolean aXQ = super.aXQ(str);
            AppMethodBeat.o(211214);
            return aXQ;
        }

        @Override // com.tencent.mm.plugin.webview.core.k
        public final boolean e(String str, Intent intent) {
            AppMethodBeat.i(211215);
            BaseSOSWebViewUI.this.ggI();
            boolean e2 = super.e(str, intent);
            AppMethodBeat.o(211215);
            return e2;
        }

        @Override // com.tencent.mm.plugin.webview.core.k
        public final com.tencent.mm.plugin.webview.core.f gai() {
            return this.Jnu;
        }

        @Override // com.tencent.mm.plugin.webview.core.k
        public final j gaj() {
            AppMethodBeat.i(211216);
            C1987b bVar = new C1987b(this, (byte) 0);
            AppMethodBeat.o(211216);
            return bVar;
        }

        @Override // com.tencent.mm.plugin.webview.core.k
        public final WebResourceResponse b(WebView webView, WebResourceRequest webResourceRequest) {
            AppMethodBeat.i(211217);
            if (webResourceRequest == null || webResourceRequest.getUrl() == null || !webResourceRequest.getUrl().toString().startsWith("weixin://fts")) {
                AppMethodBeat.o(211217);
                return null;
            }
            WebResourceResponse aXq = aXq(webResourceRequest.getUrl().toString());
            AppMethodBeat.o(211217);
            return aXq;
        }

        private static WebResourceResponse aXq(String str) {
            InputStream inputStream;
            AppMethodBeat.i(211218);
            Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "url=%s | thread=%d", str, Long.valueOf(Thread.currentThread().getId()));
            try {
                inputStream = s.openRead(Uri.parse(str).getQueryParameter("path"));
            } catch (Exception e2) {
                inputStream = null;
            }
            if (inputStream != null) {
                WebResourceResponse webResourceResponse = new WebResourceResponse("image/*", "utf8", inputStream);
                AppMethodBeat.o(211218);
                return webResourceResponse;
            }
            AppMethodBeat.o(211218);
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final boolean gfT() {
        return false;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final void gfy() {
        AppMethodBeat.i(80563);
        fzm();
        AppMethodBeat.o(80563);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(80564);
        try {
            if (this.mHh != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("webview_id", hashCode());
                this.mHh.w(1, bundle);
            }
            if (this.Jng != null) {
                this.Jng.onDestroy();
            }
        } catch (RemoteException e2) {
        }
        hideVKB();
        this.IMH.b(this.Jnl);
        this.IMH.b(this.Jnl.Jnu);
        super.onDestroy();
        AppMethodBeat.o(80564);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI
    public void m(int i2, Bundle bundle) {
        AppMethodBeat.i(80565);
        switch (i2) {
            case 60:
                if (!ggP()) {
                    Log.w("MicroMsg.WebSearch.BaseSOSWebViewUI", "current state is not search");
                    AppMethodBeat.o(80565);
                    return;
                } else if (this.Jng != null) {
                    this.Jng.c(bundle, this.scene);
                    AppMethodBeat.o(80565);
                    return;
                }
                break;
            case PlayerException.EXCEPTION_TYPE_INITLIB /*{ENCODED_INT: 61}*/:
                if (this.Jng != null) {
                    this.Jng.bi(bundle);
                    AppMethodBeat.o(80565);
                    return;
                }
                break;
            case 62:
                if (this.Jng != null) {
                    this.Jng.bj(bundle);
                    AppMethodBeat.o(80565);
                    return;
                }
                break;
            case 119:
                final String string = bundle.getString("fts_key_json_data");
                final String string2 = bundle.getString("fts_key_req_id");
                final boolean z = bundle.getBoolean("fts_key_new_query", true);
                final Bundle bundle2 = bundle.getBundle("fts_key_data");
                this.handler.post(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.AnonymousClass4 */

                    public final void run() {
                        AppMethodBeat.i(80527);
                        Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "[handleFTSAction] onSearchDataReady");
                        BaseSOSWebViewUI.this.aD(new Runnable() {
                            /* class com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.AnonymousClass4.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(211207);
                                if (BaseSOSWebViewUI.this.getJsapi() != null) {
                                    if (bundle2 == null || bundle2.getInt("isRefresh") != 1 || bundle2.getString("widgetId") == null) {
                                        BaseSOSWebViewUI.this.getJsapi().j(string, z, string2);
                                    } else {
                                        BaseSOSWebViewUI.this.getJsapi().lU(bundle2.getString("widgetId"), string);
                                        AppMethodBeat.o(211207);
                                        return;
                                    }
                                }
                                AppMethodBeat.o(211207);
                            }
                        });
                        AppMethodBeat.o(80527);
                    }
                });
                AppMethodBeat.o(80565);
                return;
            case 120:
                final int i3 = bundle.getInt("fts_key_ret", 0);
                final String string3 = bundle.getString("fts_key_data");
                this.handler.post(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.AnonymousClass7 */

                    public final void run() {
                        AppMethodBeat.i(80530);
                        if (BaseSOSWebViewUI.this.getJsapi() != null) {
                            BaseSOSWebViewUI.this.getJsapi().cQ(i3, string3);
                        }
                        AppMethodBeat.o(80530);
                    }
                });
                AppMethodBeat.o(80565);
                return;
            case 121:
                final String string4 = bundle.getString("fts_key_json_data");
                final int i4 = bundle.getInt("fts_key_teach_request_type", 0);
                final int i5 = bundle.getInt("fts_key_is_cache_data", 0);
                aD(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.AnonymousClass8 */

                    public final void run() {
                        AppMethodBeat.i(80531);
                        if (BaseSOSWebViewUI.this.getJsapi() != null) {
                            BaseSOSWebViewUI.this.getJsapi().x(i4, string4, i5);
                        }
                        AppMethodBeat.o(80531);
                    }
                });
                AppMethodBeat.o(80565);
                return;
            case 122:
                String string5 = bundle.getString("fts_key_new_query");
                String string6 = bundle.getString("fts_key_custom_query");
                boolean z2 = bundle.getBoolean("fts_key_need_keyboard", false);
                String string7 = bundle.getString("fts_key_tag_list");
                Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "onFTSSearchQueryChange: totalQuery: %s isInputChange %b", string5, Boolean.valueOf(z2));
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
                if (this.Jnc != null) {
                    if (arrayList.size() > 0) {
                        this.Jnc.O(string6, arrayList);
                    } else {
                        this.Jnc.O(string5, arrayList);
                    }
                }
                if (z2) {
                    this.handler.post(new Runnable() {
                        /* class com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.AnonymousClass9 */

                        public final void run() {
                            AppMethodBeat.i(80532);
                            if (BaseSOSWebViewUI.this.getJsapi() != null) {
                                BaseSOSWebViewUI.this.getJsapi().a(BaseSOSWebViewUI.this.getTotalQuery(), BaseSOSWebViewUI.this.getInEditTextQuery(), BaseSOSWebViewUI.this.ggN());
                            }
                            AppMethodBeat.o(80532);
                        }
                    });
                    if (this.Jnc != null) {
                        this.Jnc.awD();
                    }
                    gfU();
                } else if (this.Jnc != null) {
                    this.Jnc.vy.clearFocus();
                }
                com.tencent.mm.plugin.webview.fts.b.a.a.gaG();
                com.tencent.mm.plugin.webview.fts.b.a.a.aXY(getTotalQuery());
                AppMethodBeat.o(80565);
                return;
            case 124:
                final String string8 = bundle.getString("fts_key_json_data");
                this.handler.post(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.AnonymousClass10 */

                    public final void run() {
                        AppMethodBeat.i(80533);
                        if (BaseSOSWebViewUI.this.getJsapi() != null) {
                            BaseSOSWebViewUI.this.getJsapi().aXm(string8);
                        }
                        AppMethodBeat.o(80533);
                    }
                });
                AppMethodBeat.o(80565);
                return;
            case 125:
                final String string9 = bundle.getString("fts_key_sns_id");
                final int i7 = bundle.getInt("fts_key_status", 0);
                this.handler.post(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.AnonymousClass11 */

                    public final void run() {
                        AppMethodBeat.i(80534);
                        if (BaseSOSWebViewUI.this.getJsapi() != null) {
                            BaseSOSWebViewUI.this.getJsapi().gq(string9, i7);
                        }
                        AppMethodBeat.o(80534);
                    }
                });
                AppMethodBeat.o(80565);
                return;
            case 126:
                bundle.getString("fts_key_json_data");
                bundle.getBoolean("fts_key_new_query", true);
                final HashMap hashMap = new HashMap();
                for (String str : bundle.keySet()) {
                    hashMap.put(str, bundle.get(str));
                }
                this.handler.post(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(80526);
                        if (BaseSOSWebViewUI.this.getJsapi() != null) {
                            BaseSOSWebViewUI.this.getJsapi().bK(hashMap);
                        }
                        AppMethodBeat.o(80526);
                    }
                });
                AppMethodBeat.o(80565);
                return;
            case TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH /*{ENCODED_INT: 127}*/:
                final String string10 = bundle.getString("fts_key_json_data");
                final String string11 = bundle.getString("fts_key_req_id");
                aD(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.AnonymousClass5 */

                    public final void run() {
                        AppMethodBeat.i(80528);
                        if (BaseSOSWebViewUI.this.getJsapi() != null) {
                            h jsapi = BaseSOSWebViewUI.this.getJsapi();
                            String str = string10;
                            String str2 = string11;
                            if (!jsapi.GBl) {
                                Log.e("MicroMsg.JsApiHandler", "onChatSearchDataReady fail, not ready");
                                AppMethodBeat.o(80528);
                                return;
                            }
                            Log.i("MicroMsg.JsApiHandler", "onChatSearchDataReady success, ready");
                            HashMap hashMap = new HashMap();
                            hashMap.put("json", str);
                            hashMap.put("requestId", str2);
                            MMHandlerThread.postToMainThread(
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0053: INVOKE  
                                  (wrap: com.tencent.mm.plugin.webview.d.h$46 : 0x0050: CONSTRUCTOR  (r2v2 com.tencent.mm.plugin.webview.d.h$46) = 
                                  (r0v3 'jsapi' com.tencent.mm.plugin.webview.d.h)
                                  (wrap: java.lang.String : 0x004a: INVOKE  (r1v3 java.lang.String) = 
                                  ("onChatSearchDataReady")
                                  (r3v2 'hashMap' java.util.HashMap)
                                  (wrap: boolean : 0x0046: IGET  (r2v1 boolean) = (r0v3 'jsapi' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                                  (wrap: java.lang.String : 0x0048: IGET  (r4v2 java.lang.String) = (r0v3 'jsapi' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                                 type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
                                 call: com.tencent.mm.plugin.webview.d.h.46.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR)
                                 type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(java.lang.Runnable):void in method: com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.5.run():void, file: classes.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0050: CONSTRUCTOR  (r2v2 com.tencent.mm.plugin.webview.d.h$46) = 
                                  (r0v3 'jsapi' com.tencent.mm.plugin.webview.d.h)
                                  (wrap: java.lang.String : 0x004a: INVOKE  (r1v3 java.lang.String) = 
                                  ("onChatSearchDataReady")
                                  (r3v2 'hashMap' java.util.HashMap)
                                  (wrap: boolean : 0x0046: IGET  (r2v1 boolean) = (r0v3 'jsapi' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                                  (wrap: java.lang.String : 0x0048: IGET  (r4v2 java.lang.String) = (r0v3 'jsapi' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                                 type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
                                 call: com.tencent.mm.plugin.webview.d.h.46.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.5.run():void, file: classes.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                	... 23 more
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.webview.d.h, state: GENERATED_AND_UNLOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                	... 29 more
                                */
                            /*
                                this = this;
                                r5 = 80528(0x13a90, float:1.12844E-40)
                                com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
                                com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI r0 = com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.this
                                com.tencent.mm.plugin.webview.d.h r0 = r0.getJsapi()
                                if (r0 == 0) goto L_0x0056
                                com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI r0 = com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.this
                                com.tencent.mm.plugin.webview.d.h r0 = r0.getJsapi()
                                java.lang.String r1 = r0
                                java.lang.String r2 = r1
                                boolean r3 = r0.GBl
                                if (r3 != 0) goto L_0x0029
                                java.lang.String r0 = "MicroMsg.JsApiHandler"
                                java.lang.String r1 = "onChatSearchDataReady fail, not ready"
                                com.tencent.mm.sdk.platformtools.Log.e(r0, r1)
                                com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
                            L_0x0028:
                                return
                            L_0x0029:
                                java.lang.String r3 = "MicroMsg.JsApiHandler"
                                java.lang.String r4 = "onChatSearchDataReady success, ready"
                                com.tencent.mm.sdk.platformtools.Log.i(r3, r4)
                                java.util.HashMap r3 = new java.util.HashMap
                                r3.<init>()
                                java.lang.String r4 = "json"
                                r3.put(r4, r1)
                                java.lang.String r1 = "requestId"
                                r3.put(r1, r2)
                                java.lang.String r1 = "onChatSearchDataReady"
                                boolean r2 = r0.IRj
                                java.lang.String r4 = r0.zpY
                                java.lang.String r1 = com.tencent.mm.plugin.webview.d.n.a.b(r1, r3, r2, r4)
                                com.tencent.mm.plugin.webview.d.h$46 r2 = new com.tencent.mm.plugin.webview.d.h$46
                                r2.<init>(r1)
                                com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(r2)
                            L_0x0056:
                                com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
                                goto L_0x0028
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.AnonymousClass5.run():void");
                        }
                    });
                    AppMethodBeat.o(80565);
                    return;
                case 138:
                    String string12 = bundle.getString("fts_key_data");
                    if (Util.isNullOrNil(string12)) {
                        this.Jnf = 0;
                        AppMethodBeat.o(80565);
                        return;
                    } else if (FirebaseAnalytics.b.INDEX.equals(string12)) {
                        this.Jnf = 1;
                        AppMethodBeat.o(80565);
                        return;
                    } else if ("result".equals(string12)) {
                        this.Jnf = 2;
                        AppMethodBeat.o(80565);
                        return;
                    } else if ("suggestion".equals(string12)) {
                        this.Jnf = 3;
                        AppMethodBeat.o(80565);
                        return;
                    } else if ("teach".equals(string12)) {
                        this.Jnf = 4;
                        AppMethodBeat.o(80565);
                        return;
                    } else if (ImagesContract.LOCAL.equals(string12)) {
                        this.Jnf = 5;
                        AppMethodBeat.o(80565);
                        return;
                    } else {
                        this.Jnf = 0;
                        AppMethodBeat.o(80565);
                        return;
                    }
                case TbsListener.ErrorCode.NEEDDOWNLOAD_4 /*{ENCODED_INT: 143}*/:
                    final String string13 = bundle.getString("data");
                    this.handler.post(new Runnable() {
                        /* class com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.AnonymousClass6 */

                        public final void run() {
                            AppMethodBeat.i(80529);
                            if (BaseSOSWebViewUI.this.getJsapi() != null) {
                                h jsapi = BaseSOSWebViewUI.this.getJsapi();
                                String str = string13;
                                if (!jsapi.GBl) {
                                    Log.e("MicroMsg.JsApiHandler", "onSearchHistoryReady fail, not ready");
                                    AppMethodBeat.o(80529);
                                    return;
                                }
                                Log.i("MicroMsg.JsApiHandler", "onSearchHistoryReady success, ready");
                                try {
                                    MMHandlerThread.postToMainThread(
                                    /*  JADX ERROR: Method code generation error
                                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0045: INVOKE  
                                          (wrap: com.tencent.mm.plugin.webview.d.h$39 : 0x0042: CONSTRUCTOR  (r2v4 com.tencent.mm.plugin.webview.d.h$39) = 
                                          (r0v3 'jsapi' com.tencent.mm.plugin.webview.d.h)
                                          (wrap: java.lang.String : 0x003c: INVOKE  (r1v3 java.lang.String) = 
                                          ("onSearchHistoryReady")
                                          (wrap: org.json.JSONObject : 0x0035: CONSTRUCTOR  (r3v3 org.json.JSONObject) = (r1v0 'str' java.lang.String) call: org.json.JSONObject.<init>(java.lang.String):void type: CONSTRUCTOR)
                                          (wrap: boolean : 0x0038: IGET  (r1v2 boolean) = (r0v3 'jsapi' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                                          (wrap: java.lang.String : 0x003a: IGET  (r4v0 java.lang.String) = (r0v3 'jsapi' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                                         type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.a(java.lang.String, org.json.JSONObject, boolean, java.lang.String):java.lang.String)
                                         call: com.tencent.mm.plugin.webview.d.h.39.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR)
                                         type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(java.lang.Runnable):void in method: com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.6.run():void, file: classes.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:306)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:69)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0042: CONSTRUCTOR  (r2v4 com.tencent.mm.plugin.webview.d.h$39) = 
                                          (r0v3 'jsapi' com.tencent.mm.plugin.webview.d.h)
                                          (wrap: java.lang.String : 0x003c: INVOKE  (r1v3 java.lang.String) = 
                                          ("onSearchHistoryReady")
                                          (wrap: org.json.JSONObject : 0x0035: CONSTRUCTOR  (r3v3 org.json.JSONObject) = (r1v0 'str' java.lang.String) call: org.json.JSONObject.<init>(java.lang.String):void type: CONSTRUCTOR)
                                          (wrap: boolean : 0x0038: IGET  (r1v2 boolean) = (r0v3 'jsapi' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                                          (wrap: java.lang.String : 0x003a: IGET  (r4v0 java.lang.String) = (r0v3 'jsapi' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                                         type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.a(java.lang.String, org.json.JSONObject, boolean, java.lang.String):java.lang.String)
                                         call: com.tencent.mm.plugin.webview.d.h.39.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.6.run():void, file: classes.dex
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                        	... 28 more
                                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.webview.d.h, state: GENERATED_AND_UNLOADED
                                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                        	... 34 more
                                        */
                                    /*
                                        this = this;
                                        r5 = 80529(0x13a91, float:1.12845E-40)
                                        com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
                                        com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI r0 = com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.this
                                        com.tencent.mm.plugin.webview.d.h r0 = r0.getJsapi()
                                        if (r0 == 0) goto L_0x0059
                                        com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI r0 = com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.this
                                        com.tencent.mm.plugin.webview.d.h r0 = r0.getJsapi()
                                        java.lang.String r1 = r0
                                        boolean r2 = r0.GBl
                                        if (r2 != 0) goto L_0x0027
                                        java.lang.String r0 = "MicroMsg.JsApiHandler"
                                        java.lang.String r1 = "onSearchHistoryReady fail, not ready"
                                        com.tencent.mm.sdk.platformtools.Log.e(r0, r1)
                                        com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
                                    L_0x0026:
                                        return
                                    L_0x0027:
                                        java.lang.String r2 = "MicroMsg.JsApiHandler"
                                        java.lang.String r3 = "onSearchHistoryReady success, ready"
                                        com.tencent.mm.sdk.platformtools.Log.i(r2, r3)
                                        java.lang.String r2 = "onSearchHistoryReady"
                                        org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x004c }
                                        r3.<init>(r1)     // Catch:{ JSONException -> 0x004c }
                                        boolean r1 = r0.IRj     // Catch:{ JSONException -> 0x004c }
                                        java.lang.String r4 = r0.zpY     // Catch:{ JSONException -> 0x004c }
                                        java.lang.String r1 = com.tencent.mm.plugin.webview.d.n.a.a(r2, r3, r1, r4)     // Catch:{ JSONException -> 0x004c }
                                        com.tencent.mm.plugin.webview.d.h$39 r2 = new com.tencent.mm.plugin.webview.d.h$39     // Catch:{ JSONException -> 0x004c }
                                        r2.<init>(r1)     // Catch:{ JSONException -> 0x004c }
                                        com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(r2)     // Catch:{ JSONException -> 0x004c }
                                        com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
                                        goto L_0x0026
                                    L_0x004c:
                                        r0 = move-exception
                                        java.lang.String r1 = "MicroMsg.JsApiHandler"
                                        java.lang.String r2 = ""
                                        r3 = 0
                                        java.lang.Object[] r3 = new java.lang.Object[r3]
                                        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace(r1, r0, r2, r3)
                                    L_0x0059:
                                        com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
                                        goto L_0x0026
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.AnonymousClass6.run():void");
                                }
                            });
                            AppMethodBeat.o(80565);
                            return;
                        case 144:
                            AppMethodBeat.o(80565);
                            return;
                        case TbsListener.ErrorCode.NEEDDOWNLOAD_8 /*{ENCODED_INT: 147}*/:
                            final int i8 = bundle.getInt("ret");
                            final long j2 = bundle.getLong("reqId");
                            final String string14 = bundle.getString("json", "");
                            this.handler.post(new Runnable() {
                                /* class com.tencent.mm.plugin.webview.ui.tools.fts.BaseSOSWebViewUI.AnonymousClass13 */

                                public final void run() {
                                    AppMethodBeat.i(211208);
                                    if (BaseSOSWebViewUI.this.IBw != null) {
                                        BaseSOSWebViewUI.this.IBw.a(i8, j2, string14);
                                        Log.i("MicroMsg.WebSearch.BaseSOSWebViewUI", "wxaapp_opsearch resp, ret = %d, reqId = %d, json = %s", Integer.valueOf(i8), Long.valueOf(j2), string14);
                                    }
                                    AppMethodBeat.o(211208);
                                }
                            });
                            AppMethodBeat.o(80565);
                            return;
                        case TPPlayerMgr.EVENT_ID_APP_ENTER_BACKGROUND /*{ENCODED_INT: 100001}*/:
                            if (this.Jng != null) {
                                this.Jng.bh(bundle);
                                AppMethodBeat.o(80565);
                                return;
                            }
                            break;
                        default:
                            super.m(i2, bundle);
                            break;
                    }
                    AppMethodBeat.o(80565);
                }

                /* access modifiers changed from: protected */
                @Override // com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI
                public final e ggM() {
                    return this.Jng;
                }

                /* access modifiers changed from: protected */
                public final String getTotalQuery() {
                    AppMethodBeat.i(80566);
                    if (this.Jnc != null) {
                        String totalQuery = this.Jnc.getTotalQuery();
                        AppMethodBeat.o(80566);
                        return totalQuery;
                    }
                    AppMethodBeat.o(80566);
                    return "";
                }

                /* access modifiers changed from: protected */
                public final int getTabType() {
                    return this.JnE;
                }

                /* access modifiers changed from: protected */
                public final String getInEditTextQuery() {
                    AppMethodBeat.i(80567);
                    String inEditTextQuery = this.Jnc.getInEditTextQuery();
                    AppMethodBeat.o(80567);
                    return inEditTextQuery;
                }

                public final JSONArray ggN() {
                    AppMethodBeat.i(80568);
                    List<a.c> tagList = this.Jnc.getTagList();
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
                    AppMethodBeat.o(80568);
                    return jSONArray;
                }

                @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI, android.support.v4.app.FragmentActivity
                public void onBackPressed() {
                    AppMethodBeat.i(80569);
                    fzm();
                    AppMethodBeat.o(80569);
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
                        AppMethodBeat.i(80543);
                        if (obj == null || !(obj instanceof FTSBaseWebViewUI.a)) {
                            AppMethodBeat.o(80543);
                            return -1;
                        }
                        int compareTo = this.FeZ.compareTo(((FTSBaseWebViewUI.a) obj).FeZ);
                        AppMethodBeat.o(80543);
                        return compareTo;
                    }
                }

                /* access modifiers changed from: protected */
                @Override // com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI
                public final void c(int i2, String str, Map<String, Object> map) {
                    boolean z;
                    AppMethodBeat.i(80570);
                    Log.v("MicroMsg.WebSearch.BaseSOSWebViewUI", "adding history cgi params type %d, inEditQuery %s, params %s", Integer.valueOf(i2), str, map);
                    int i3 = this.JnE;
                    this.JnE = i2;
                    if (i3 != i2) {
                        ggE();
                    }
                    if (this.Jne == null) {
                        this.Jne = new ArrayList();
                    }
                    if (getTotalQuery().length() > 0) {
                        c cVar = new c();
                        cVar.type = this.JnE;
                        cVar.qLQ = new ArrayList(this.Jnc.getTagList());
                        cVar.Jnx = this.Jnc.getInEditTextQuery();
                        cVar.Jnw = this.Jnc.getTotalQuery();
                        if (this.Jne.size() == 0) {
                            this.Jne.add(cVar);
                        } else if (!cVar.equals(this.Jne.get(0))) {
                            this.Jne.add(0, cVar);
                        }
                    }
                    if (this.Jne != null && !this.Jne.isEmpty()) {
                        c cVar2 = this.Jne.get(0);
                        c cVar3 = new c();
                        cVar3.type = i2;
                        cVar3.Jnw = str;
                        cVar3.Jny = map;
                        if (cVar2 != null) {
                            if (cVar2 == cVar3) {
                                z = true;
                            } else {
                                c cVar4 = cVar3;
                                z = cVar4.type == cVar2.type && cVar4.Jnw.trim().equals(cVar2.Jnw.trim());
                            }
                            if (z) {
                                cVar2.Jny = map;
                            }
                        }
                    }
                    AppMethodBeat.o(80570);
                }

                /* access modifiers changed from: protected */
                public class c {
                    String Jnw = "";
                    String Jnx = "";
                    Map<String, Object> Jny = new HashMap();
                    List<a.c> qLQ;
                    int type;

                    protected c() {
                        AppMethodBeat.i(80550);
                        AppMethodBeat.o(80550);
                    }

                    public final boolean equals(Object obj) {
                        AppMethodBeat.i(80551);
                        if (this == obj) {
                            AppMethodBeat.o(80551);
                            return true;
                        } else if (obj instanceof c) {
                            c cVar = (c) obj;
                            if (cVar.type != this.type || !cVar.Jnx.equals(this.Jnx)) {
                                AppMethodBeat.o(80551);
                                return false;
                            }
                            AppMethodBeat.o(80551);
                            return true;
                        } else {
                            AppMethodBeat.o(80551);
                            return false;
                        }
                    }
                }

                public boolean ggO() {
                    return false;
                }

                /* access modifiers changed from: protected */
                public boolean ggP() {
                    return true;
                }

                public final String agR(int i2) {
                    AppMethodBeat.i(80571);
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putString("key", "educationTab");
                        Bundle u = this.mHh.u(2, bundle);
                        String string = u.getString("result");
                        String string2 = u.getString("result_1");
                        if (string2 != null) {
                            string = string2;
                        }
                        JSONArray optJSONArray = new JSONObject(string).optJSONArray("items");
                        if (optJSONArray == null) {
                            AppMethodBeat.o(80571);
                            return "";
                        }
                        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                            if (optJSONObject.optInt("businessType") == i2) {
                                String optString = optJSONObject.optString("hotword");
                                AppMethodBeat.o(80571);
                                return optString;
                            }
                        }
                        AppMethodBeat.o(80571);
                        return "";
                    } catch (Exception e2) {
                    }
                }
            }
