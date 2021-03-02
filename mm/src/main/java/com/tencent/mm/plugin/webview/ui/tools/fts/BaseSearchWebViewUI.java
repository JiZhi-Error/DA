package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.SmileyPanel;
import com.tencent.mm.cb.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.appbrand.jsapi.k.c;
import com.tencent.mm.plugin.appbrand.jsapi.k.g;
import com.tencent.mm.plugin.websearch.api.ae;
import com.tencent.mm.plugin.websearch.api.af;
import com.tencent.mm.plugin.websearch.api.ah;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.f;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.fts.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.widget.a.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseSearchWebViewUI extends PreLoadWebViewUI implements b.AbstractC1953b {
    private b JnA;
    private Set<b.a> JnB = new HashSet();
    RelativeLayout JnC;
    protected int JnD;
    protected int JnE;
    protected String JnF;
    private Runnable JnG;
    protected boolean Jnz;
    protected View gAy;
    private SmileyPanel hQS;
    protected String hes;
    private View nEb;
    protected String query;
    protected int scene;
    protected int type;

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(BaseSearchWebViewUI baseSearchWebViewUI, String str, String str2, int i2, final boolean z) {
        if (baseSearchWebViewUI.gAy != null) {
            baseSearchWebViewUI.dTO();
            ImageView imageView = (ImageView) baseSearchWebViewUI.gAy.findViewById(R.id.e4p);
            View findViewById = baseSearchWebViewUI.gAy.findViewById(R.id.gl7);
            if (!str2.equals("loading")) {
                imageView.setVisibility(0);
                findViewById.setVisibility(8);
                if (str2.equals("success")) {
                    imageView.setImageResource(R.drawable.by4);
                } else if (str2.equals("fail")) {
                    imageView.setImageResource(R.drawable.cmu);
                } else {
                    imageView.setVisibility(8);
                }
            } else {
                imageView.setVisibility(8);
                findViewById.setVisibility(0);
            }
            TextView textView = (TextView) baseSearchWebViewUI.gAy.findViewById(R.id.ipm);
            LinearLayout linearLayout = (LinearLayout) baseSearchWebViewUI.gAy.findViewById(R.id.hr_);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
            if (imageView.getVisibility() == 8 && findViewById.getVisibility() == 8) {
                layoutParams.bottomMargin = baseSearchWebViewUI.getResources().getDimensionPixelSize(R.dimen.r);
                linearLayout.setMinimumHeight(0);
            } else {
                layoutParams.bottomMargin = 0;
                linearLayout.setMinimumHeight(a.fromDPToPix((Context) baseSearchWebViewUI, 120));
            }
            textView.setLayoutParams(layoutParams);
            textView.setText(str);
            baseSearchWebViewUI.gAy.setOnTouchListener(new View.OnTouchListener() {
                /* class com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI.AnonymousClass8 */

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    return z;
                }
            });
            baseSearchWebViewUI.gAy.setVisibility(0);
            if (i2 > 0) {
                baseSearchWebViewUI.JnG = new Runnable() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI.AnonymousClass9 */

                    public final void run() {
                        AppMethodBeat.i(80580);
                        BaseSearchWebViewUI.this.dTO();
                        AppMethodBeat.o(80580);
                    }
                };
                baseSearchWebViewUI.handler.postDelayed(baseSearchWebViewUI.JnG, (long) i2);
            }
        }
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        boolean z = false;
        super.onCreate(bundle);
        if (getIntent() != null) {
            this.Jnz = getIntent().getBooleanExtra("jumpto_sns_contact_page", false);
        }
        if (this.JnA == null) {
            this.JnA = new b(getContext(), this.pGj, this);
        }
        this.scene = getIntent().getIntExtra("ftsbizscene", 0);
        this.JnD = this.scene;
        this.type = getIntent().getIntExtra("ftsType", 0);
        this.query = getIntent().getStringExtra("ftsQuery");
        this.JnF = getIntent().getStringExtra("tabId");
        this.hes = getIntent().getStringExtra("searchId");
        this.JnE = this.type;
        int i2 = this.scene;
        String str = this.sessionId;
        String str2 = this.dVO;
        if (this.type == 0) {
            z = true;
        }
        ah.a(i2, str, str2, z, this.query, this.type, this.JnF, this.IRT, this.hes);
        if (!ai.n(this, this.scene)) {
            Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "request for grant location permission");
        } else {
            Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "has location permission");
        }
        View inflate = View.inflate(this, R.layout.bp1, null);
        inflate.setBackgroundResource(R.color.ac_);
        inflate.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.gAy = inflate;
        if (this.gAy != null && (getContentView() instanceof ViewGroup)) {
            ((ViewGroup) getContentView()).addView(this.gAy);
        }
        dTO();
        this.JnC = (RelativeLayout) findViewById(R.id.c0s);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI
    public final void ggQ() {
        boolean z;
        super.ggQ();
        int i2 = this.scene;
        String str = this.sessionId;
        String str2 = this.dVO;
        if (this.type == 0) {
            z = true;
        } else {
            z = false;
        }
        ah.a(i2, str, str2, z, this.query, this.type, this.JnF, this.IRT);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public void bXg() {
        super.bXg();
        if (this.JnA == null) {
            this.JnA = new b(getContext(), this.pGj, this);
        }
        this.JnA.IBw = getJsapi();
        if (this.mHh != null) {
            try {
                this.mHh.j(51, new Bundle());
            } catch (RemoteException e2) {
                Log.printErrStackTrace("MicroMsg.WebSearch.BaseSearchWebViewUI", e2, "", new Object[0]);
            }
        } else {
            Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "invoker is null, fail to invoke get geo");
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI
    public final void cpR() {
        super.cpR();
        Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "jsapi ready");
        ah.fXT();
    }

    @Override // com.tencent.mm.plugin.webview.fts.c.b.AbstractC1953b
    public final void a(b.a aVar) {
        this.JnB.add(aVar);
    }

    /* access modifiers changed from: protected */
    public void c(int i2, String str, Map<String, Object> map) {
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public void m(int i2, Bundle bundle) {
        final boolean z = true;
        switch (i2) {
            case 128:
                final String string = bundle.getString("fts_key_json_data", "");
                this.handler.post(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI.AnonymousClass6 */

                    public final void run() {
                        AppMethodBeat.i(80578);
                        h jsapi = BaseSearchWebViewUI.this.getJsapi();
                        String str = string;
                        if (!jsapi.GBl) {
                            Log.e("MicroMsg.JsApiHandler", "onCurrentLocationReady fail, not ready");
                        } else {
                            Log.i("MicroMsg.JsApiHandler", "onCurrentLocationReady success, ready");
                            HashMap hashMap = new HashMap();
                            hashMap.put("json", str);
                            MMHandlerThread.postToMainThread(
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0054: INVOKE  
                                  (wrap: com.tencent.mm.plugin.webview.d.h$41 : 0x0051: CONSTRUCTOR  (r2v3 com.tencent.mm.plugin.webview.d.h$41) = 
                                  (r0v1 'jsapi' com.tencent.mm.plugin.webview.d.h)
                                  (wrap: java.lang.String : 0x004b: INVOKE  (r1v2 java.lang.String) = 
                                  ("onCurrentLocationReady")
                                  (r2v2 'hashMap' java.util.HashMap)
                                  (wrap: boolean : 0x0047: IGET  (r3v2 boolean) = (r0v1 'jsapi' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                                  (wrap: java.lang.String : 0x0049: IGET  (r4v0 java.lang.String) = (r0v1 'jsapi' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                                 type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
                                 call: com.tencent.mm.plugin.webview.d.h.41.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR)
                                 type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(java.lang.Runnable):void in method: com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI.6.run():void, file: classes.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
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
                                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0051: CONSTRUCTOR  (r2v3 com.tencent.mm.plugin.webview.d.h$41) = 
                                  (r0v1 'jsapi' com.tencent.mm.plugin.webview.d.h)
                                  (wrap: java.lang.String : 0x004b: INVOKE  (r1v2 java.lang.String) = 
                                  ("onCurrentLocationReady")
                                  (r2v2 'hashMap' java.util.HashMap)
                                  (wrap: boolean : 0x0047: IGET  (r3v2 boolean) = (r0v1 'jsapi' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                                  (wrap: java.lang.String : 0x0049: IGET  (r4v0 java.lang.String) = (r0v1 'jsapi' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                                 type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
                                 call: com.tencent.mm.plugin.webview.d.h.41.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI.6.run():void, file: classes.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                	... 19 more
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.webview.d.h, state: GENERATED_AND_UNLOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                	... 25 more
                                */
                            /*
                                this = this;
                                r5 = 80578(0x13ac2, float:1.12914E-40)
                                com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
                                com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI r0 = com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI.this
                                com.tencent.mm.plugin.webview.d.h r0 = r0.getJsapi()
                                java.lang.String r1 = r0
                                boolean r2 = r0.GBl
                                if (r2 != 0) goto L_0x0030
                                java.lang.String r0 = "MicroMsg.JsApiHandler"
                                java.lang.String r1 = "onCurrentLocationReady fail, not ready"
                                com.tencent.mm.sdk.platformtools.Log.e(r0, r1)
                            L_0x001b:
                                java.lang.String r0 = "MicroMsg.WebSearch.BaseSearchWebViewUI"
                                java.lang.String r1 = "onCurrentLocationReady, json = %s"
                                r2 = 1
                                java.lang.Object[] r2 = new java.lang.Object[r2]
                                r3 = 0
                                java.lang.String r4 = r0
                                r2[r3] = r4
                                com.tencent.mm.sdk.platformtools.Log.i(r0, r1, r2)
                                com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
                                return
                            L_0x0030:
                                java.lang.String r2 = "MicroMsg.JsApiHandler"
                                java.lang.String r3 = "onCurrentLocationReady success, ready"
                                com.tencent.mm.sdk.platformtools.Log.i(r2, r3)
                                java.util.HashMap r2 = new java.util.HashMap
                                r2.<init>()
                                java.lang.String r3 = "json"
                                r2.put(r3, r1)
                                java.lang.String r1 = "onCurrentLocationReady"
                                boolean r3 = r0.IRj
                                java.lang.String r4 = r0.zpY
                                java.lang.String r1 = com.tencent.mm.plugin.webview.d.n.a.b(r1, r2, r3, r4)
                                com.tencent.mm.plugin.webview.d.h$41 r2 = new com.tencent.mm.plugin.webview.d.h$41
                                r2.<init>(r1)
                                com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(r2)
                                goto L_0x001b
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI.AnonymousClass6.run():void");
                        }
                    });
                    return;
                case 133:
                    bg(bundle);
                    return;
                case g.CTRL_INDEX:
                    e remove = com.tencent.mm.plugin.websearch.widget.view.a.fYZ().IIt.remove(Integer.valueOf(bundle.getInt("actionSheetId")));
                    if (remove != null) {
                        remove.bMo();
                        return;
                    }
                    return;
                case c.CTRL_INDEX:
                    c(bundle.getInt("FTS_KEY_onStartWebSearch_type", 0), bundle.getString("FTS_KEY_onStartWebSearch_query"), (Map) bundle.getSerializable("FTS_KEY_onStartWebSearch_params"));
                    return;
                case 137:
                    String string2 = bundle.getString("fts_key_json_data");
                    if (getJsapi() != null) {
                        try {
                            h jsapi = getJsapi();
                            JSONObject jSONObject = new JSONObject(string2);
                            if (!jsapi.GBl) {
                                Log.e("MicroMsg.JsApiHandler", "not ready");
                                return;
                            } else {
                                MMHandlerThread.postToMainThread(
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x006b: INVOKE  
                                      (wrap: com.tencent.mm.plugin.webview.d.h$38 : 0x0068: CONSTRUCTOR  (r3v35 com.tencent.mm.plugin.webview.d.h$38) = 
                                      (r2v39 'jsapi' com.tencent.mm.plugin.webview.d.h)
                                      (wrap: java.lang.String : 0x0062: INVOKE  (r1v41 java.lang.String) = 
                                      ("onGetMatchContactList")
                                      (r3v34 'jSONObject' org.json.JSONObject)
                                      (wrap: boolean : 0x005e: IGET  (r4v14 boolean) = (r2v39 'jsapi' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                                      (wrap: java.lang.String : 0x0060: IGET  (r5v6 java.lang.String) = (r2v39 'jsapi' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                                     type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.a(java.lang.String, org.json.JSONObject, boolean, java.lang.String):java.lang.String)
                                     call: com.tencent.mm.plugin.webview.d.h.38.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR)
                                     type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(java.lang.Runnable):void in method: com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI.m(int, android.os.Bundle):void, file: classes7.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:306)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:69)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                    	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:274)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
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
                                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0068: CONSTRUCTOR  (r3v35 com.tencent.mm.plugin.webview.d.h$38) = 
                                      (r2v39 'jsapi' com.tencent.mm.plugin.webview.d.h)
                                      (wrap: java.lang.String : 0x0062: INVOKE  (r1v41 java.lang.String) = 
                                      ("onGetMatchContactList")
                                      (r3v34 'jSONObject' org.json.JSONObject)
                                      (wrap: boolean : 0x005e: IGET  (r4v14 boolean) = (r2v39 'jsapi' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                                      (wrap: java.lang.String : 0x0060: IGET  (r5v6 java.lang.String) = (r2v39 'jsapi' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                                     type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.a(java.lang.String, org.json.JSONObject, boolean, java.lang.String):java.lang.String)
                                     call: com.tencent.mm.plugin.webview.d.h.38.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI.m(int, android.os.Bundle):void, file: classes7.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                    	... 34 more
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.webview.d.h, state: GENERATED_AND_UNLOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                    	... 40 more
                                    */
                                /*
                                // Method dump skipped, instructions count: 836
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI.m(int, android.os.Bundle):void");
                            }

                            /* access modifiers changed from: private */
                            /* access modifiers changed from: public */
                            private String C(EmojiInfo emojiInfo) {
                                Bundle bundle = new Bundle();
                                bundle.putString("md5", emojiInfo.field_md5);
                                bundle.putString("designerId", emojiInfo.field_designerID);
                                bundle.putString("aeskey", emojiInfo.field_aeskey);
                                bundle.putString("encryptUrl", emojiInfo.field_encrypturl);
                                bundle.putString("productId", emojiInfo.field_groupId);
                                bundle.putString("name", emojiInfo.field_name);
                                bundle.putString("thumbUrl", emojiInfo.field_thumbUrl);
                                try {
                                    bundle = this.mHh.w(7, bundle);
                                } catch (Exception e2) {
                                }
                                String string = bundle.getString("emojiPath");
                                if (emojiInfo.NA() || emojiInfo.field_catalog == EmojiGroupInfo.VkO) {
                                    return string + "_fts";
                                }
                                return string;
                            }

                            /* access modifiers changed from: protected */
                            public e ggM() {
                                return null;
                            }

                            private static int bf(Bundle bundle) {
                                return Util.safeParseInt(bundle.getString("playerId"));
                            }

                            private void bg(Bundle bundle) {
                                ArrayList arrayList = new ArrayList();
                                String string = bundle.getString("title");
                                String string2 = bundle.getString("desc");
                                String string3 = bundle.getString("items");
                                try {
                                    JSONArray jSONArray = new JSONArray(string3);
                                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                        JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                                        if (optJSONObject != null) {
                                            af afVar = new af();
                                            afVar.iconUrl = optJSONObject.optString("icon");
                                            afVar.title = optJSONObject.optString("title");
                                            afVar.isSelected = optJSONObject.optInt("selected") == 1;
                                            afVar.desc = optJSONObject.optString("desc");
                                            arrayList.add(afVar);
                                        }
                                    }
                                } catch (JSONException e2) {
                                    Log.e("MicroMsg.WebSearch.BaseSearchWebViewUI", Util.stackTraceToString(e2));
                                }
                                Log.v("MicroMsg.WebSearch.BaseSearchWebViewUI", "doShowSearchActionSheet args: title %s,subTitle %s,items %s", string, string2, string3);
                                if (!arrayList.isEmpty()) {
                                    bundle.putInt("actionSheetId", ((f) com.tencent.mm.kernel.g.af(f.class)).a(this, string, string2, arrayList, new ae() {
                                        /* class com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI.AnonymousClass7 */

                                        @Override // com.tencent.mm.plugin.websearch.api.ae
                                        public final void ka(int i2, int i3) {
                                            AppMethodBeat.i(80579);
                                            if (BaseSearchWebViewUI.this.getJsapi() != null) {
                                                h jsapi = BaseSearchWebViewUI.this.getJsapi();
                                                if (!jsapi.GBl) {
                                                    Log.e("MicroMsg.JsApiHandler", "onSearchActionSheetClick fail, not ready");
                                                    AppMethodBeat.o(80579);
                                                    return;
                                                }
                                                Log.i("MicroMsg.JsApiHandler", "onSearchActionSheetClick success, ready");
                                                HashMap hashMap = new HashMap();
                                                hashMap.put(FirebaseAnalytics.b.INDEX, Integer.valueOf(i2));
                                                hashMap.put("actionSheetId", Integer.valueOf(i3));
                                                MMHandlerThread.postToMainThread(
                                                /*  JADX ERROR: Method code generation error
                                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0057: INVOKE  
                                                      (wrap: com.tencent.mm.plugin.webview.d.h$36 : 0x0054: CONSTRUCTOR  (r2v4 com.tencent.mm.plugin.webview.d.h$36) = 
                                                      (r0v3 'jsapi' com.tencent.mm.plugin.webview.d.h)
                                                      (wrap: java.lang.String : 0x004e: INVOKE  (r1v3 java.lang.String) = 
                                                      ("onSearchActionSheetClick")
                                                      (r1v2 'hashMap' java.util.HashMap)
                                                      (wrap: boolean : 0x004a: IGET  (r3v2 boolean) = (r0v3 'jsapi' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                                                      (wrap: java.lang.String : 0x004c: IGET  (r4v0 java.lang.String) = (r0v3 'jsapi' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                                                     type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
                                                     call: com.tencent.mm.plugin.webview.d.h.36.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR)
                                                     type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(java.lang.Runnable):void in method: com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI.7.ka(int, int):void, file: classes.dex
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
                                                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0054: CONSTRUCTOR  (r2v4 com.tencent.mm.plugin.webview.d.h$36) = 
                                                      (r0v3 'jsapi' com.tencent.mm.plugin.webview.d.h)
                                                      (wrap: java.lang.String : 0x004e: INVOKE  (r1v3 java.lang.String) = 
                                                      ("onSearchActionSheetClick")
                                                      (r1v2 'hashMap' java.util.HashMap)
                                                      (wrap: boolean : 0x004a: IGET  (r3v2 boolean) = (r0v3 'jsapi' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                                                      (wrap: java.lang.String : 0x004c: IGET  (r4v0 java.lang.String) = (r0v3 'jsapi' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                                                     type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
                                                     call: com.tencent.mm.plugin.webview.d.h.36.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI.7.ka(int, int):void, file: classes.dex
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
                                                    r5 = 80579(0x13ac3, float:1.12915E-40)
                                                    com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
                                                    com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI r0 = com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI.this
                                                    com.tencent.mm.plugin.webview.d.h r0 = r0.getJsapi()
                                                    if (r0 == 0) goto L_0x005a
                                                    com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI r0 = com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI.this
                                                    com.tencent.mm.plugin.webview.d.h r0 = r0.getJsapi()
                                                    boolean r1 = r0.GBl
                                                    if (r1 != 0) goto L_0x0025
                                                    java.lang.String r0 = "MicroMsg.JsApiHandler"
                                                    java.lang.String r1 = "onSearchActionSheetClick fail, not ready"
                                                    com.tencent.mm.sdk.platformtools.Log.e(r0, r1)
                                                    com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
                                                L_0x0024:
                                                    return
                                                L_0x0025:
                                                    java.lang.String r1 = "MicroMsg.JsApiHandler"
                                                    java.lang.String r2 = "onSearchActionSheetClick success, ready"
                                                    com.tencent.mm.sdk.platformtools.Log.i(r1, r2)
                                                    java.util.HashMap r1 = new java.util.HashMap
                                                    r1.<init>()
                                                    java.lang.String r2 = "index"
                                                    java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
                                                    r1.put(r2, r3)
                                                    java.lang.String r2 = "actionSheetId"
                                                    java.lang.Integer r3 = java.lang.Integer.valueOf(r8)
                                                    r1.put(r2, r3)
                                                    java.lang.String r2 = "onSearchActionSheetClick"
                                                    boolean r3 = r0.IRj
                                                    java.lang.String r4 = r0.zpY
                                                    java.lang.String r1 = com.tencent.mm.plugin.webview.d.n.a.b(r2, r1, r3, r4)
                                                    com.tencent.mm.plugin.webview.d.h$36 r2 = new com.tencent.mm.plugin.webview.d.h$36
                                                    r2.<init>(r1)
                                                    com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(r2)
                                                L_0x005a:
                                                    com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
                                                    goto L_0x0024
                                                */
                                                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.fts.BaseSearchWebViewUI.AnonymousClass7.ka(int, int):void");
                                            }
                                        }));
                                    }
                                }

                                /* access modifiers changed from: private */
                                /* access modifiers changed from: public */
                                private void dTO() {
                                    if (this.gAy != null) {
                                        this.gAy.setVisibility(8);
                                        if (this.JnG != null) {
                                            this.handler.removeCallbacks(this.JnG);
                                            this.JnG = null;
                                        }
                                    }
                                }

                                @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
                                public void onResume() {
                                    super.onResume();
                                    for (b.a aVar : this.JnB) {
                                        aVar.onForeground();
                                    }
                                }

                                @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
                                public void onPause() {
                                    super.onPause();
                                    for (b.a aVar : this.JnB) {
                                        aVar.onBackground();
                                    }
                                }

                                @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.webview.ui.tools.fts.PreLoadWebViewUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
                                public void onDestroy() {
                                    boolean z;
                                    super.onDestroy();
                                    for (b.a aVar : this.JnB) {
                                        aVar.onDestroy();
                                    }
                                    this.JnB.clear();
                                    int i2 = this.scene;
                                    String str = this.sessionId;
                                    String str2 = this.dVO;
                                    if (this.type == 0) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    ah.a(i2, str, str2, z, this.query, this.type, this.IRT);
                                    Log.d("MicroMsg.WebSearch.BaseSearchWebViewUI", "onDestroy");
                                }

                                @Override // com.tencent.mm.plugin.webview.fts.c.b.AbstractC1953b
                                public final void w(View view, boolean z) {
                                    gaO();
                                    this.nEb = view;
                                    ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                                    ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
                                    viewGroup.addView(view, layoutParams);
                                    view.setX(0.0f);
                                    view.setY(0.0f);
                                    if (d.oE(19)) {
                                        viewGroup.setSystemUiVisibility(2);
                                    } else {
                                        viewGroup.setSystemUiVisibility(4098);
                                    }
                                    getWindow().addFlags(1024);
                                    if (z) {
                                        setRequestedOrientation(0);
                                    }
                                }

                                @Override // com.tencent.mm.plugin.webview.fts.c.b.AbstractC1953b
                                public final void gaO() {
                                    if (this.nEb != null) {
                                        ViewGroup viewGroup = (ViewGroup) getWindow().getDecorView();
                                        viewGroup.setSystemUiVisibility(0);
                                        viewGroup.removeView(this.nEb);
                                        getWindow().clearFlags(1024);
                                        if (getRequestedOrientation() == 0) {
                                            setRequestedOrientation(1);
                                        }
                                        this.nEb = null;
                                        for (b.a aVar : this.JnB) {
                                            aVar.Na();
                                        }
                                    }
                                }

                                @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
                                public void onBackPressed() {
                                    ggR();
                                    boolean z = false;
                                    for (b.a aVar : this.JnB) {
                                        z = aVar.onBackPressed() | z;
                                    }
                                    if (!z) {
                                        super.onBackPressed();
                                    }
                                }

                                @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
                                public boolean onKeyDown(int i2, KeyEvent keyEvent) {
                                    if (i2 == 25) {
                                        for (b.a aVar : this.JnB) {
                                            aVar.gaM();
                                        }
                                    } else if (i2 == 24) {
                                        for (b.a aVar2 : this.JnB) {
                                            aVar2.gaN();
                                        }
                                    }
                                    return super.onKeyDown(i2, keyEvent);
                                }

                                @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.a.AbstractC0015a
                                public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
                                    Object[] objArr = new Object[1];
                                    objArr[0] = iArr.length > 0 ? new StringBuilder().append(iArr[0]).toString() : "";
                                    Log.i("MicroMsg.WebSearch.BaseSearchWebViewUI", "onRequestPermissionsResult, granted ? %s", objArr);
                                }

                                @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
                                public final boolean bXi() {
                                    return true;
                                }

                                public final void ggR() {
                                    if (this.JnC != null) {
                                        this.JnC.setVisibility(8);
                                    }
                                    if (this.hQS != null) {
                                        this.hQS.goF();
                                    }
                                }

                                /* access modifiers changed from: protected */
                                public final Drawable agS(int i2) {
                                    int i3 = R.raw.icons_outlined_wechat_search_one_search;
                                    switch (i2) {
                                        case 1:
                                            i3 = R.raw.websearch_icon_acount;
                                            break;
                                        case 2:
                                            i3 = R.raw.websearch_icon_article;
                                            break;
                                        case 8:
                                            i3 = R.raw.websearch_icon_moment;
                                            break;
                                        case 64:
                                        case 262208:
                                            i3 = R.raw.websearch_icon_weapp;
                                            break;
                                        case 256:
                                        case 384:
                                            i3 = R.raw.websearch_icon_emoji;
                                            break;
                                        case 512:
                                            i3 = R.raw.websearch_icon_music;
                                            break;
                                        case 1024:
                                            i3 = R.raw.websearch_icon_novel;
                                            break;
                                        case 12582912:
                                            i3 = R.raw.websearch_icon_movie;
                                            break;
                                        case 16777220:
                                            i3 = R.raw.websearch_icon_webpage;
                                            break;
                                        case 16777248:
                                            i3 = R.raw.websearch_icon_question;
                                            break;
                                        case 16777728:
                                            i3 = R.raw.websearch_icon_baike;
                                            break;
                                        case 16793600:
                                            i3 = R.raw.websearch_icon_product;
                                            break;
                                    }
                                    return getResources().getDrawable(i3);
                                }
                            }
