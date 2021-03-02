package com.tencent.mm.plugin.webview.modeltools;

import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.protocal.protobuf.ajw;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.widget.MMWebView;
import java.net.URL;
import java.util.HashMap;
import org.apache.commons.b.f;
import org.json.JSONObject;

public final class k {
    public static boolean a(h hVar, final MMWebView mMWebView) {
        AppMethodBeat.i(211030);
        if (hVar == null) {
            Log.w("MicroMsg.WebViewReportOnLeaveHelper", "handler is null");
            AppMethodBeat.o(211030);
            return false;
        }
        String url = mMWebView.getUrl();
        if (!Util.isNullOrNil(url)) {
            try {
                if (!new URL(url).getHost().equals(WeChatHosts.domainString(R.string.e20))) {
                    AppMethodBeat.o(211030);
                    return false;
                }
                AnonymousClass1 r0 = new ValueCallback<String>() {
                    /* class com.tencent.mm.plugin.webview.modeltools.k.AnonymousClass1 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // android.webkit.ValueCallback
                    public final /* synthetic */ void onReceiveValue(String str) {
                        AppMethodBeat.i(79214);
                        final String str2 = str;
                        com.tencent.f.h.RTc.aV(new Runnable() {
                            /* class com.tencent.mm.plugin.webview.modeltools.k.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(79212);
                                try {
                                    mMWebView.destroy();
                                    AppMethodBeat.o(79212);
                                } catch (Exception e2) {
                                    Log.w("MicroMsg.WebViewReportOnLeaveHelper", "reportOnLeave, ex = %s", e2.getMessage());
                                    AppMethodBeat.o(79212);
                                }
                            }
                        });
                        if (!Util.isNullOrNil(str2)) {
                            com.tencent.f.h.RTc.b(new Runnable() {
                                /* class com.tencent.mm.plugin.webview.modeltools.k.AnonymousClass1.AnonymousClass2 */

                                public final void run() {
                                    AppMethodBeat.i(79213);
                                    String str = "";
                                    String str2 = "";
                                    try {
                                        JSONObject jSONObject = new JSONObject(f.bvh(str2.substring(1, str2.length() - 1)));
                                        str = jSONObject.optString("data", "");
                                        str2 = jSONObject.optString("music_data", "");
                                        com.tencent.mm.plugin.webview.ui.tools.video.a aVar = com.tencent.mm.plugin.webview.ui.tools.video.a.JxN;
                                        if (com.tencent.mm.plugin.webview.ui.tools.video.a.gic()) {
                                            try {
                                                String optString = jSONObject.optString("native_data", "");
                                                if (Util.isNullOrNil(optString)) {
                                                    Log.i("MicroMsg.MPVideoPreviewDataMgr", "reportOnLeaveForMP native_data null");
                                                } else {
                                                    aVar.bbh(optString);
                                                }
                                            } catch (Exception e2) {
                                                Log.i("MicroMsg.MPVideoPreviewDataMgr", "reportOnLeave, ex = %s", e2.getMessage());
                                            }
                                        }
                                    } catch (Exception e3) {
                                        Log.w("MicroMsg.WebViewReportOnLeaveHelper", "reportOnLeave, ex = %s", e3.getMessage());
                                    }
                                    k.aZv(str);
                                    k.aZw(str2);
                                    Log.i("MicroMsg.WebViewReportOnLeaveHelper", "reportOnLeave reportData size=%d", Integer.valueOf(str2.length()));
                                    AppMethodBeat.o(79213);
                                }
                            }, "WebViewReportOnLeaveThread");
                        }
                        AppMethodBeat.o(79214);
                    }
                };
                if (!hVar.GBl) {
                    r0.onReceiveValue(null);
                } else {
                    hVar.IRa.evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + n.a.b("reportOnLeaveForMP", new HashMap(), hVar.IRj, hVar.zpY) + ")", r0);
                }
                AppMethodBeat.o(211030);
                return true;
            } catch (Exception e2) {
                Log.e("MicroMsg.WebViewReportOnLeaveHelper", "create url fail : " + e2.getLocalizedMessage());
                AppMethodBeat.o(211030);
                return false;
            }
        } else {
            AppMethodBeat.o(211030);
            return false;
        }
    }

    public static int aZv(String str) {
        AppMethodBeat.i(211031);
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.WebViewReportOnLeaveHelper", "doReport invalid reportData %s", str);
            AppMethodBeat.o(211031);
            return -1;
        }
        d.a aVar = new d.a();
        aVar.iLN = new ajw();
        aVar.iLO = new ajx();
        aVar.uri = "/cgi-bin/mmbiz-bin/exitreport";
        aVar.funcId = 1642;
        d aXF = aVar.aXF();
        ((ajw) aXF.iLK.iLR).Ltj = str;
        IPCRunCgi.a(aXF, new IPCRunCgi.a() {
            /* class com.tencent.mm.plugin.webview.modeltools.k.AnonymousClass2 */

            @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
            public final void a(int i2, int i3, String str, d dVar) {
                AppMethodBeat.i(79215);
                Log.i("MicroMsg.WebViewReportOnLeaveHelper", "doReport callback errType:%d errCode:%d msg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                AppMethodBeat.o(79215);
            }
        });
        AppMethodBeat.o(211031);
        return 0;
    }

    public static void aZw(String str) {
        AppMethodBeat.i(211032);
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.WebViewReportOnLeaveHelper", "doReportMusic invalid reportData %s", str);
            AppMethodBeat.o(211032);
            return;
        }
        XIPCInvoker.a(MainProcessIPCService.dkO, new IPCString(str), a.class, null);
        AppMethodBeat.o(211032);
    }

    /* access modifiers changed from: package-private */
    public static class a implements b<IPCString, IPCString> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(IPCString iPCString, com.tencent.mm.ipcinvoker.d<IPCString> dVar) {
            AppMethodBeat.i(79216);
            IPCString iPCString2 = iPCString;
            if (iPCString2 != null && !Util.isNullOrNil(iPCString2.value)) {
                com.tencent.mm.ay.d dVar2 = new com.tencent.mm.ay.d();
                try {
                    JSONObject jSONObject = new JSONObject(iPCString2.value);
                    dVar2.jeR = jSONObject.optString("current_musicid", "");
                    dVar2.jeS = jSONObject.optString("report_list", "");
                } catch (Exception e2) {
                    Log.w("MicroMsg.WebViewReportOnLeaveHelper", "reportOnLeave, ex = %s", e2.getMessage());
                }
                MMHandlerThread.postToMainThread(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x003b: INVOKE  
                      (wrap: com.tencent.mm.ay.a$4 : 0x0038: CONSTRUCTOR  (r0v4 com.tencent.mm.ay.a$4) = (r1v0 'dVar2' com.tencent.mm.ay.d) call: com.tencent.mm.ay.a.4.<init>(com.tencent.mm.ay.d):void type: CONSTRUCTOR)
                     type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(java.lang.Runnable):void in method: com.tencent.mm.plugin.webview.modeltools.k.a.invoke(com.tencent.mm.ipcinvoker.type.IPCString, com.tencent.mm.ipcinvoker.d<com.tencent.mm.ipcinvoker.type.IPCString>):void, file: classes.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
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
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0038: CONSTRUCTOR  (r0v4 com.tencent.mm.ay.a$4) = (r1v0 'dVar2' com.tencent.mm.ay.d) call: com.tencent.mm.ay.a.4.<init>(com.tencent.mm.ay.d):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.modeltools.k.a.invoke(com.tencent.mm.ipcinvoker.type.IPCString, com.tencent.mm.ipcinvoker.d<com.tencent.mm.ipcinvoker.type.IPCString>):void, file: classes.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 19 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.ay.a, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 25 more
                    */
                /*
                    this = this;
                    r6 = 79216(0x13570, float:1.11005E-40)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
                    com.tencent.mm.ipcinvoker.type.IPCString r8 = (com.tencent.mm.ipcinvoker.type.IPCString) r8
                    if (r8 == 0) goto L_0x003e
                    java.lang.String r0 = r8.value
                    boolean r0 = com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r0)
                    if (r0 != 0) goto L_0x003e
                    com.tencent.mm.ay.d r1 = new com.tencent.mm.ay.d
                    r1.<init>()
                    org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x0042 }
                    java.lang.String r2 = r8.value     // Catch:{ Exception -> 0x0042 }
                    r0.<init>(r2)     // Catch:{ Exception -> 0x0042 }
                    java.lang.String r2 = "current_musicid"
                    java.lang.String r3 = ""
                    java.lang.String r2 = r0.optString(r2, r3)     // Catch:{ Exception -> 0x0042 }
                    r1.jeR = r2     // Catch:{ Exception -> 0x0042 }
                    java.lang.String r2 = "report_list"
                    java.lang.String r3 = ""
                    java.lang.String r0 = r0.optString(r2, r3)     // Catch:{ Exception -> 0x0042 }
                    r1.jeS = r0     // Catch:{ Exception -> 0x0042 }
                L_0x0036:
                    com.tencent.mm.ay.a$4 r0 = new com.tencent.mm.ay.a$4
                    r0.<init>(r1)
                    com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(r0)
                L_0x003e:
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                    return
                L_0x0042:
                    r0 = move-exception
                    java.lang.String r2 = "MicroMsg.WebViewReportOnLeaveHelper"
                    java.lang.String r3 = "reportOnLeave, ex = %s"
                    r4 = 1
                    java.lang.Object[] r4 = new java.lang.Object[r4]
                    r5 = 0
                    java.lang.String r0 = r0.getMessage()
                    r4[r5] = r0
                    com.tencent.mm.sdk.platformtools.Log.w(r2, r3, r4)
                    goto L_0x0036
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.modeltools.k.a.invoke(java.lang.Object, com.tencent.mm.ipcinvoker.d):void");
            }
        }
    }
