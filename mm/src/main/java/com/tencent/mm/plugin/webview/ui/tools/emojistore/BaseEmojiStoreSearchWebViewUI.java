package com.tencent.mm.plugin.webview.ui.tools.emojistore;

import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.core.f;
import com.tencent.mm.plugin.webview.core.i;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.s;
import com.tencent.xweb.WebView;
import java.util.HashMap;

public class BaseEmojiStoreSearchWebViewUI extends WebViewUI implements s.b {
    private boolean Jmy;
    private boolean Jmz = true;
    private s mSearchViewHelper;
    private int qoX;
    String query;
    private int type;

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final i cpO() {
        AppMethodBeat.i(211204);
        i cpO = super.cpO();
        if (cpO != null) {
            cpO.a(new a(this, (byte) 0));
        }
        AppMethodBeat.o(211204);
        return cpO;
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public final void bXg() {
        AppMethodBeat.i(80469);
        super.bXg();
        this.query = getIntent().getStringExtra("keyword");
        this.type = getIntent().getIntExtra("type", 0);
        this.Jmy = getIntent().getBooleanExtra("showkeyboard", false);
        this.qoX = getIntent().getIntExtra("sence", 0);
        this.pGj.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.emojistore.BaseEmojiStoreSearchWebViewUI.AnonymousClass1 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(80464);
                BaseEmojiStoreSearchWebViewUI.this.hideVKB();
                AppMethodBeat.o(80464);
                return false;
            }
        });
        this.mSearchViewHelper = new s();
        addSearchMenu(true, this.mSearchViewHelper);
        this.mSearchViewHelper.CK(false);
        this.mSearchViewHelper.Qwi = this;
        showOptionMenu(false);
        if (this.JjI != null) {
            this.JjI.zh(true);
        }
        this.pGj.setOnLongClickListener(new View.OnLongClickListener() {
            /* class com.tencent.mm.plugin.webview.ui.tools.emojistore.BaseEmojiStoreSearchWebViewUI.AnonymousClass2 */

            public final boolean onLongClick(View view) {
                AppMethodBeat.i(211201);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/ui/tools/emojistore/BaseEmojiStoreSearchWebViewUI$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/webview/ui/tools/emojistore/BaseEmojiStoreSearchWebViewUI$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(211201);
                return true;
            }
        });
        AppMethodBeat.o(80469);
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void bnz() {
    }

    @Override // com.tencent.mm.ui.MMActivity
    public boolean onCreateOptionsMenu(Menu menu) {
        AppMethodBeat.i(80470);
        if (this.mSearchViewHelper != null) {
            this.mSearchViewHelper.a((FragmentActivity) this, menu);
            this.mSearchViewHelper.setHint(getString(R.string.btg));
        }
        AppMethodBeat.o(80470);
        return true;
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void bny() {
        AppMethodBeat.i(80471);
        finish();
        AppMethodBeat.o(80471);
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void SO(String str) {
        AppMethodBeat.i(80472);
        if (this.Jmz && Util.isNullOrNil(str)) {
            this.Jmz = false;
            if (!this.Jmy) {
                MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.webview.ui.tools.emojistore.BaseEmojiStoreSearchWebViewUI.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(80465);
                        BaseEmojiStoreSearchWebViewUI.this.mSearchViewHelper.clearFocus();
                        BaseEmojiStoreSearchWebViewUI.this.hideVKB();
                        AppMethodBeat.o(80465);
                    }
                }, 500);
                AppMethodBeat.o(80472);
                return;
            }
            this.mSearchViewHelper.gXq();
            showVKB();
        }
        AppMethodBeat.o(80472);
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final boolean SN(String str) {
        AppMethodBeat.i(80473);
        if (str != null) {
            str = str.trim();
        }
        this.query = str;
        if (!Util.isNullOrNil(str)) {
            this.query = str;
            this.handler.post(new Runnable() {
                /* class com.tencent.mm.plugin.webview.ui.tools.emojistore.BaseEmojiStoreSearchWebViewUI.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(80466);
                    if (BaseEmojiStoreSearchWebViewUI.this.IBw != null) {
                        BaseEmojiStoreSearchWebViewUI.this.IBw.gbf();
                    }
                    AppMethodBeat.o(80466);
                }
            });
            Bundle bundle = new Bundle();
            bundle.putInt("type", this.type);
            bundle.putString("nextPageBuffer", "");
            bundle.putString("keyword", this.query);
            bundle.putInt("webview_instance_id", hashCode());
            bundle.putLong("searchID", this.IBw.gbh());
            try {
                if (this.mHh != null) {
                    this.mHh.v(1, bundle);
                } else {
                    Log.e("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "invoker should not be null");
                }
            } catch (RemoteException e2) {
                Log.printErrStackTrace("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", e2, "doSearch", new Object[0]);
            }
        }
        hideVKB();
        String str2 = "";
        if (!Util.isNullOrNil(str)) {
            str2 = str.replace(",", " ");
        }
        h.INSTANCE.a(13054, Integer.valueOf(this.qoX), 1, str2);
        AppMethodBeat.o(80473);
        return false;
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void bnA() {
        AppMethodBeat.i(80474);
        this.mSearchViewHelper.gXq();
        showVKB();
        AppMethodBeat.o(80474);
    }

    @Override // com.tencent.mm.ui.tools.s.b
    public final void bnB() {
    }

    @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
    public void z(int i2, Bundle bundle) {
        AppMethodBeat.i(80475);
        Log.i("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "handleEmojiStoreAction action:%d", Integer.valueOf(i2));
        switch (i2) {
            case 80001:
                String string = bundle.getString("emoji_store_json_data");
                boolean z = bundle.getBoolean("emoji_store_new_query", true);
                String string2 = bundle.getString("emoji_store_page_buf");
                long j2 = bundle.getLong("emoji_store_search_id");
                com.tencent.mm.plugin.webview.d.h hVar = this.IBw;
                if (!hVar.GBl) {
                    Log.e("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData fail, not ready");
                    AppMethodBeat.o(80475);
                    return;
                }
                Log.i("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData success, ready");
                HashMap hashMap = new HashMap();
                hashMap.put("json", string);
                hashMap.put("newQuery", Boolean.valueOf(z));
                hashMap.put("nextPageBuffer", string2);
                Log.d("MicroMsg.JsApiHandler", "cpan emoji set SearchID:%d", Long.valueOf(j2));
                hVar.IRD = j2;
                String b2 = n.a.b("getSearchEmotionDataCallBack", hashMap, hVar.IRj, hVar.zpY);
                Log.i("MicroMsg.JsApiHandler", "event:%s", b2);
                MMHandlerThread.postToMainThread(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00a6: INVOKE  
                      (wrap: com.tencent.mm.plugin.webview.d.h$70 : 0x00a3: CONSTRUCTOR  (r1v7 com.tencent.mm.plugin.webview.d.h$70) = (r3v2 'hVar' com.tencent.mm.plugin.webview.d.h), (r0v8 'b2' java.lang.String) call: com.tencent.mm.plugin.webview.d.h.70.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR)
                     type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(java.lang.Runnable):void in method: com.tencent.mm.plugin.webview.ui.tools.emojistore.BaseEmojiStoreSearchWebViewUI.z(int, android.os.Bundle):void, file: classes.dex
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
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00a3: CONSTRUCTOR  (r1v7 com.tencent.mm.plugin.webview.d.h$70) = (r3v2 'hVar' com.tencent.mm.plugin.webview.d.h), (r0v8 'b2' java.lang.String) call: com.tencent.mm.plugin.webview.d.h.70.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.ui.tools.emojistore.BaseEmojiStoreSearchWebViewUI.z(int, android.os.Bundle):void, file: classes.dex
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
                // Method dump skipped, instructions count: 192
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.ui.tools.emojistore.BaseEmojiStoreSearchWebViewUI.z(int, android.os.Bundle):void");
            }

            @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
            public final void gfy() {
                AppMethodBeat.i(80476);
                finish();
                AppMethodBeat.o(80476);
            }

            class a extends f {
                private a() {
                }

                /* synthetic */ a(BaseEmojiStoreSearchWebViewUI baseEmojiStoreSearchWebViewUI, byte b2) {
                    this();
                }

                @Override // com.tencent.mm.plugin.webview.core.f
                public final void b(WebView webView, String str) {
                    AppMethodBeat.i(211202);
                    Log.i("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "onPageFinished url:%s", str);
                    BaseEmojiStoreSearchWebViewUI.this.showOptionMenu(false);
                    BaseEmojiStoreSearchWebViewUI.this.mSearchViewHelper.setSearchContent(BaseEmojiStoreSearchWebViewUI.this.query);
                    AppMethodBeat.o(211202);
                }

                @Override // com.tencent.mm.plugin.webview.core.f
                public final void i(WebView webView, String str) {
                    AppMethodBeat.i(211203);
                    BaseEmojiStoreSearchWebViewUI.this.showOptionMenu(false);
                    AppMethodBeat.o(211203);
                }
            }

            @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.MMActivity
            public int getLayoutId() {
                return R.layout.a3n;
            }

            @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
            public final boolean cpC() {
                return false;
            }

            @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
            public void onDestroy() {
                AppMethodBeat.i(80477);
                super.onDestroy();
                AppMethodBeat.o(80477);
            }

            @Override // com.tencent.mm.plugin.webview.ui.tools.WebViewUI
            public final boolean gfP() {
                return true;
            }
        }
