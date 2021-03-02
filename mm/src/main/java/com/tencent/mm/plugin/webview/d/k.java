package com.tencent.mm.plugin.webview.d;

import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.mm.vfs.w;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ag;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import org.apache.commons.a.e;

public final class k {
    private static int IRV = -1;
    private static String IRW = null;
    private static final String IRX = (b.aKB() + "/jscache/");
    private static String IRY = "window.addEventListener('load', requestInjectJS, false); function requestInjectJS() { console.log('weixin://preInjectJSBridge/start');}";
    public h IBw;
    private WebView IRR;
    private a IRS;
    private boolean IRT;
    private boolean IRU;

    public interface a {
        void gbn();
    }

    public k(WebView webView, h hVar, a aVar) {
        this(webView, hVar, aVar, false);
    }

    public k(WebView webView, h hVar, a aVar, boolean z) {
        AppMethodBeat.i(224409);
        this.IRU = false;
        this.IRR = webView;
        this.IBw = hVar;
        this.IRS = aVar;
        this.IRT = z;
        Log.d("MicroMsg.JsLoader", "JsLoader <init>, isWebViewPreload %b", Boolean.valueOf(z));
        Log.i("MicroMsg.JsLoader", "JsLoader <init>, jsapi: %d, this: %d", Integer.valueOf(hVar.hashCode()), Integer.valueOf(hashCode()));
        AppMethodBeat.o(224409);
    }

    public final void detach() {
        AppMethodBeat.i(224410);
        Log.v("MicroMsg.JsLoader", "detach");
        this.IRR = null;
        this.IBw = null;
        this.IRS = null;
        AppMethodBeat.o(224410);
    }

    public final void KY() {
        AppMethodBeat.i(224411);
        if (this.IRR == null || this.IBw == null) {
            Log.e("MicroMsg.JsLoader", "ready, viewWV or jsapi is null");
            AppMethodBeat.o(224411);
            return;
        }
        h hVar = this.IBw;
        Log.v("MicroMsg.JsApiHandler", "jsapi init");
        if (hVar.IRa == null) {
            Log.w("MicroMsg.JsApiHandler", "jsapi init wv is null");
        } else {
            hVar.gaX();
            hVar.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + n.a.b("sys:init", null, hVar.IRj, hVar.zpY) + ")", 
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00da: INVOKE  
                  (wrap: com.tencent.mm.ui.widget.MMWebView : 0x00b0: IGET  (r1v3 com.tencent.mm.ui.widget.MMWebView) = (r0v5 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRa com.tencent.mm.ui.widget.MMWebView)
                  (wrap: java.lang.String : ?: STR_CONCAT  
                  ("javascript:WeixinJSBridge._handleMessageFromWeixin(")
                  (wrap: java.lang.String : 0x00c2: INVOKE  
                  ("sys:init")
                  (null java.util.Map)
                  (wrap: boolean : 0x00be: IGET  (r0v5 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
                  (wrap: java.lang.String : 0x00c0: IGET  (r0v5 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
                 type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
                  (")")
                )
                  (wrap: com.tencent.mm.plugin.webview.d.h$23 : 0x00d7: CONSTRUCTOR  (r3v4 com.tencent.mm.plugin.webview.d.h$23) = (r0v5 'hVar' com.tencent.mm.plugin.webview.d.h) call: com.tencent.mm.plugin.webview.d.h.23.<init>(com.tencent.mm.plugin.webview.d.h):void type: CONSTRUCTOR)
                 type: VIRTUAL call: com.tencent.mm.ui.widget.MMWebView.evaluateJavascript(java.lang.String, android.webkit.ValueCallback):void in method: com.tencent.mm.plugin.webview.d.k.KY():void, file: classes.dex
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
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00d7: CONSTRUCTOR  (r3v4 com.tencent.mm.plugin.webview.d.h$23) = (r0v5 'hVar' com.tencent.mm.plugin.webview.d.h) call: com.tencent.mm.plugin.webview.d.h.23.<init>(com.tencent.mm.plugin.webview.d.h):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.d.k.KY():void, file: classes.dex
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
            // Method dump skipped, instructions count: 322
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.d.k.KY():void");
        }

        public final void aYl(String str) {
            AppMethodBeat.i(224412);
            if (this.IRR == null || this.IBw == null) {
                Log.e("MicroMsg.JsLoader", "auth, viewWV or jsapi is null");
                AppMethodBeat.o(224412);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("state", "authorized");
            if (str != null) {
                hashMap.put("fullUrl", str);
            }
            this.IBw.yV(true);
            this.IBw.b("sys:auth", hashMap, null);
            AppMethodBeat.o(224412);
        }

        public final void gbk() {
            AppMethodBeat.i(224413);
            if (this.IRR == null || this.IBw == null) {
                Log.e("MicroMsg.JsLoader", "auth, viewWV or jsapi is null");
                AppMethodBeat.o(224413);
                return;
            }
            Log.i("MicroMsg.JsLoader", "SPA-Trace, spaHistoryChanged");
            this.IBw.b("sys:spa:historyChanged", new HashMap(), null);
            AppMethodBeat.o(224413);
        }

        public final void gbl() {
            boolean z;
            String aYm;
            AppMethodBeat.i(224414);
            Log.i("MicroMsg.JsLoader", "inject");
            if (this.IRT) {
                Log.i("MicroMsg.JsLoader", "loadJavaScript jsapi init done by preload");
                if (this.IBw != null) {
                    this.IBw.yV(true);
                }
                z = true;
            } else if (this.IRR == null || this.IBw == null) {
                Log.e("MicroMsg.JsLoader", "loadJavaScript build, viewWV is null");
                z = false;
            } else {
                this.IBw.IRk = true;
                final long currentTimeMillis = System.currentTimeMillis();
                final boolean isX5 = WebView.isX5();
                final boolean isXWalkKernel = this.IRR.isXWalkKernel();
                if (b(this.IRR) && (aYm = aYm("jsapi/wxjs.js")) != null) {
                    final long currentTimeMillis2 = System.currentTimeMillis();
                    if (currentTimeMillis2 >= 0) {
                        com.tencent.mm.plugin.webview.h.a.agi(84);
                        ag agVar = new ag(3, 256, this.IRR);
                        agVar.oc(aYm, "path");
                        this.IRR.evaluateJavascript(agVar.toString(), new ValueCallback<String>() {
                            /* class com.tencent.mm.plugin.webview.d.k.AnonymousClass1 */

                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                            @Override // android.webkit.ValueCallback
                            public final /* synthetic */ void onReceiveValue(String str) {
                                AppMethodBeat.i(224406);
                                String str2 = str;
                                long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                                long j2 = currentTimeMillis2 - currentTimeMillis;
                                com.tencent.mm.plugin.webview.h.a.aP(81, currentTimeMillis);
                                com.tencent.mm.plugin.webview.h.a.aP(79, currentTimeMillis2 - j2);
                                if (str2 != null && str2.contains("succ")) {
                                    com.tencent.mm.plugin.webview.h.a.agi(85);
                                }
                                if (currentTimeMillis > 5000) {
                                    Log.w("MicroMsg.JsLoader", "loadJavaScript is too slow, cost %d, isX5 %b, isXWeb %b", Long.valueOf(currentTimeMillis), Boolean.valueOf(isX5), Boolean.valueOf(isXWalkKernel));
                                    com.tencent.mm.plugin.webview.h.a.agi(isX5 ? 94 : isXWalkKernel ? 95 : 96);
                                }
                                if (k.this.IBw != null) {
                                    k.this.IBw.IRk = false;
                                }
                                Log.i("MicroMsg.JsLoader", "loadJavaScript with WebCodeCache, evaluateJavascript cb, ret: %s, ccCost: %dms, cpCost: %dms", str2, Long.valueOf(currentTimeMillis), Long.valueOf(j2));
                                AppMethodBeat.o(224406);
                            }
                        });
                        this.IBw.gaX();
                        z = true;
                    }
                }
                com.tencent.mm.plugin.webview.h.a.agi(82);
                this.IRR.evaluateJavascript(gbm(), new ValueCallback<String>() {
                    /* class com.tencent.mm.plugin.webview.d.k.AnonymousClass2 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // android.webkit.ValueCallback
                    public final /* synthetic */ void onReceiveValue(String str) {
                        AppMethodBeat.i(224407);
                        String str2 = str;
                        long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                        com.tencent.mm.plugin.webview.h.a.aP(80, currentTimeMillis);
                        if (str2 != null && str2.contains("succ")) {
                            com.tencent.mm.plugin.webview.h.a.agi(83);
                        }
                        if (currentTimeMillis > 5000) {
                            Log.w("MicroMsg.JsLoader", "loadJavaScript is too slow, cost %d, isX5 %b, isXWeb %b", Long.valueOf(currentTimeMillis), Boolean.valueOf(isX5), Boolean.valueOf(isXWalkKernel));
                            com.tencent.mm.plugin.webview.h.a.agi(isX5 ? 94 : isXWalkKernel ? 95 : 96);
                        }
                        if (k.this.IBw != null) {
                            k.this.IBw.IRk = false;
                        }
                        Log.i("MicroMsg.JsLoader", "loadJavaScript, evaluateJavascript cb, ret: %s, cost: %dms", str2, Long.valueOf(currentTimeMillis));
                        AppMethodBeat.o(224407);
                    }
                });
                this.IBw.gaX();
                z = true;
            }
            this.IRU = z;
            AppMethodBeat.o(224414);
        }

        static {
            AppMethodBeat.i(224419);
            AppMethodBeat.o(224419);
        }

        public static boolean b(WebView webView) {
            AppMethodBeat.i(224415);
            if (IRV == -1) {
                IRV = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_xweb_code_cache, 0);
            }
            if (((IRV & 1) != 0 || BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG) && webView.supportFeature(2002)) {
                AppMethodBeat.o(224415);
                return true;
            }
            AppMethodBeat.o(224415);
            return false;
        }

        private String gbm() {
            AppMethodBeat.i(224416);
            Log.i("MicroMsg.JsLoader", "WXJS: %s", "jsapi/wxjs.js");
            try {
                String str = new String(e.toByteArray(MMApplicationContext.getContext().getAssets().open("jsapi/wxjs.js")));
                if (!TextUtils.isEmpty(this.IBw.zpY)) {
                    Log.i("MicroMsg.JsLoader", "getWXJS, ranDomStr = %s, jsapi: %d, jsLoader: %d", this.IBw.zpY, Integer.valueOf(this.IBw.hashCode()), Integer.valueOf(hashCode()));
                    str = str.replaceFirst("\\$\\{dgtVerifyRandomStr\\}", this.IBw.zpY).replaceFirst("\\$\\{dgtVerifyEnabled\\}", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
                }
                AppMethodBeat.o(224416);
                return str;
            } catch (Exception e2) {
                Log.e("MicroMsg.JsLoader", "tryInterceptBridgeScriptRequest, failed, ", e2);
                AppMethodBeat.o(224416);
                return "";
            }
        }

        private String aYm(String str) {
            final String substring;
            AppMethodBeat.i(224417);
            Log.i("MicroMsg.JsLoader", "tryCopyAsset: %s", str);
            if (IRW != null) {
                substring = IRW;
            } else {
                substring = BuildInfo.REV.substring(0, Math.min(BuildInfo.REV.length(), 8));
                IRW = substring;
            }
            String str2 = IRX + substring + FilePathGenerator.ANDROID_DIR_SEP + str;
            if (s.YS(str2)) {
                AppMethodBeat.o(224417);
                return str2;
            }
            com.tencent.mm.plugin.webview.h.a.agi(86);
            o[] b2 = new o(IRX).b(new w() {
                /* class com.tencent.mm.plugin.webview.d.k.AnonymousClass3 */

                @Override // com.tencent.mm.vfs.w
                public final boolean accept(o oVar, String str) {
                    AppMethodBeat.i(224408);
                    if (!str.equals(substring)) {
                        AppMethodBeat.o(224408);
                        return true;
                    }
                    AppMethodBeat.o(224408);
                    return false;
                }
            });
            if (b2 != null && b2.length > 0) {
                for (o oVar : b2) {
                    s.dy(aa.z(oVar.mUri), true);
                }
            }
            s.boN(s.boZ(str2));
            try {
                lX(str, str2);
                com.tencent.mm.plugin.webview.h.a.agi(87);
                AppMethodBeat.o(224417);
                return str2;
            } catch (Exception e2) {
                Log.e("MicroMsg.JsLoader", "tryCopyAsset, failed, ", e2);
                AppMethodBeat.o(224417);
                return null;
            }
        }

        private static void lX(String str, String str2) {
            AppMethodBeat.i(224418);
            InputStream open = MMApplicationContext.getContext().getAssets().open(str);
            OutputStream dw = s.dw(str2, false);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = open.read(bArr);
                if (read > 0) {
                    dw.write(bArr, 0, read);
                } else {
                    open.close();
                    dw.close();
                    Log.i("MicroMsg.JsLoader", "copy asset to:".concat(String.valueOf(str2)));
                    AppMethodBeat.o(224418);
                    return;
                }
            }
        }
    }
