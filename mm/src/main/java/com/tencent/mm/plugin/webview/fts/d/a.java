package com.tencent.mm.plugin.webview.fts.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.websearch.api.n;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.xweb.WebView;
import java.util.HashMap;

public final class a implements n {
    public h IBw;
    private WebView IQP;

    public a(WebView webView) {
        this.IQP = webView;
    }

    @Override // com.tencent.mm.plugin.websearch.api.n
    public final void addView(View view) {
        AppMethodBeat.i(78177);
        ViewGroup topView = this.IQP.getTopView();
        if (topView == null || !(topView instanceof AbsoluteLayout)) {
            Log.e("MicroMsg.WebSearch.WebViewWidgetWrap", "webview invalid viewgroup ".concat(String.valueOf(topView)));
            AppMethodBeat.o(78177);
            return;
        }
        topView.addView(view);
        AppMethodBeat.o(78177);
    }

    @Override // com.tencent.mm.plugin.websearch.api.n
    public final void removeView(View view) {
        AppMethodBeat.i(78178);
        ViewGroup topView = this.IQP.getTopView();
        if (topView != null && (topView instanceof AbsoluteLayout)) {
            topView.removeView(view);
        }
        AppMethodBeat.o(78178);
    }

    @Override // com.tencent.mm.plugin.websearch.api.n
    public final void gd(String str, int i2) {
        AppMethodBeat.i(78179);
        h hVar = this.IBw;
        if (!hVar.GBl) {
            Log.e("MicroMsg.JsApiHandler", "onSearchWAWidgetStateChange fail, not ready");
            AppMethodBeat.o(78179);
            return;
        }
        Log.i("MicroMsg.JsApiHandler", "onSearchWAWidgetStateChange success, ready");
        HashMap hashMap = new HashMap();
        hashMap.put("widgetId", str);
        hashMap.put("state", Integer.valueOf(i2));
        MMHandlerThread.postToMainThread(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0047: INVOKE  
              (wrap: com.tencent.mm.plugin.webview.d.h$53 : 0x0044: CONSTRUCTOR  (r2v4 com.tencent.mm.plugin.webview.d.h$53) = 
              (r0v0 'hVar' com.tencent.mm.plugin.webview.d.h)
              (wrap: java.lang.String : 0x003e: INVOKE  (r1v3 java.lang.String) = 
              ("onSearchWAWidgetStateChange")
              (r1v2 'hashMap' java.util.HashMap)
              (wrap: boolean : 0x003a: IGET  (r3v1 boolean) = (r0v0 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
              (wrap: java.lang.String : 0x003c: IGET  (r4v0 java.lang.String) = (r0v0 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
             type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
             call: com.tencent.mm.plugin.webview.d.h.53.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR)
             type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(java.lang.Runnable):void in method: com.tencent.mm.plugin.webview.fts.d.a.gd(java.lang.String, int):void, file: classes.dex
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
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0044: CONSTRUCTOR  (r2v4 com.tencent.mm.plugin.webview.d.h$53) = 
              (r0v0 'hVar' com.tencent.mm.plugin.webview.d.h)
              (wrap: java.lang.String : 0x003e: INVOKE  (r1v3 java.lang.String) = 
              ("onSearchWAWidgetStateChange")
              (r1v2 'hashMap' java.util.HashMap)
              (wrap: boolean : 0x003a: IGET  (r3v1 boolean) = (r0v0 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
              (wrap: java.lang.String : 0x003c: IGET  (r4v0 java.lang.String) = (r0v0 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
             type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
             call: com.tencent.mm.plugin.webview.d.h.53.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.fts.d.a.gd(java.lang.String, int):void, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 18 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.webview.d.h, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 24 more
            */
        /*
            this = this;
            r5 = 78179(0x13163, float:1.09552E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
            com.tencent.mm.plugin.webview.d.h r0 = r6.IBw
            boolean r1 = r0.GBl
            if (r1 != 0) goto L_0x0019
            java.lang.String r0 = "MicroMsg.JsApiHandler"
            java.lang.String r1 = "onSearchWAWidgetStateChange fail, not ready"
            com.tencent.mm.sdk.platformtools.Log.e(r0, r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
        L_0x0018:
            return
        L_0x0019:
            java.lang.String r1 = "MicroMsg.JsApiHandler"
            java.lang.String r2 = "onSearchWAWidgetStateChange success, ready"
            com.tencent.mm.sdk.platformtools.Log.i(r1, r2)
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.lang.String r2 = "widgetId"
            r1.put(r2, r7)
            java.lang.String r2 = "state"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r8)
            r1.put(r2, r3)
            java.lang.String r2 = "onSearchWAWidgetStateChange"
            boolean r3 = r0.IRj
            java.lang.String r4 = r0.zpY
            java.lang.String r1 = com.tencent.mm.plugin.webview.d.n.a.b(r2, r1, r3, r4)
            com.tencent.mm.plugin.webview.d.h$53 r2 = new com.tencent.mm.plugin.webview.d.h$53
            r2.<init>(r1)
            com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(r2)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            goto L_0x0018
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.fts.d.a.gd(java.lang.String, int):void");
    }

    @Override // com.tencent.mm.plugin.websearch.api.n
    public final void i(String str, boolean z, String str2) {
        AppMethodBeat.i(78180);
        this.IBw.b(str, z, "", str2);
        AppMethodBeat.o(78180);
    }

    @Override // com.tencent.mm.plugin.websearch.api.n
    public final void aXa(String str) {
        AppMethodBeat.i(78181);
        h hVar = this.IBw;
        if (!hVar.GBl) {
            Log.e("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadData fail, not ready");
            AppMethodBeat.o(78181);
            return;
        }
        Log.i("MicroMsg.JsApiHandler", "onSearchWAWidgetReloadData success, ready");
        HashMap hashMap = new HashMap();
        hashMap.put("widgetId", str);
        MMHandlerThread.postToMainThread(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x003d: INVOKE  
              (wrap: com.tencent.mm.plugin.webview.d.h$51 : 0x003a: CONSTRUCTOR  (r2v3 com.tencent.mm.plugin.webview.d.h$51) = 
              (r0v0 'hVar' com.tencent.mm.plugin.webview.d.h)
              (wrap: java.lang.String : 0x0034: INVOKE  (r1v3 java.lang.String) = 
              ("onSearchWAWidgetReloadData")
              (r1v2 'hashMap' java.util.HashMap)
              (wrap: boolean : 0x0030: IGET  (r3v0 boolean) = (r0v0 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
              (wrap: java.lang.String : 0x0032: IGET  (r4v0 java.lang.String) = (r0v0 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
             type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
             call: com.tencent.mm.plugin.webview.d.h.51.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR)
             type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(java.lang.Runnable):void in method: com.tencent.mm.plugin.webview.fts.d.a.aXa(java.lang.String):void, file: classes.dex
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
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x003a: CONSTRUCTOR  (r2v3 com.tencent.mm.plugin.webview.d.h$51) = 
              (r0v0 'hVar' com.tencent.mm.plugin.webview.d.h)
              (wrap: java.lang.String : 0x0034: INVOKE  (r1v3 java.lang.String) = 
              ("onSearchWAWidgetReloadData")
              (r1v2 'hashMap' java.util.HashMap)
              (wrap: boolean : 0x0030: IGET  (r3v0 boolean) = (r0v0 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
              (wrap: java.lang.String : 0x0032: IGET  (r4v0 java.lang.String) = (r0v0 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
             type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
             call: com.tencent.mm.plugin.webview.d.h.51.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.fts.d.a.aXa(java.lang.String):void, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 18 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.webview.d.h, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 24 more
            */
        /*
            this = this;
            r5 = 78181(0x13165, float:1.09555E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
            com.tencent.mm.plugin.webview.d.h r0 = r6.IBw
            boolean r1 = r0.GBl
            if (r1 != 0) goto L_0x0019
            java.lang.String r0 = "MicroMsg.JsApiHandler"
            java.lang.String r1 = "onSearchWAWidgetReloadData fail, not ready"
            com.tencent.mm.sdk.platformtools.Log.e(r0, r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
        L_0x0018:
            return
        L_0x0019:
            java.lang.String r1 = "MicroMsg.JsApiHandler"
            java.lang.String r2 = "onSearchWAWidgetReloadData success, ready"
            com.tencent.mm.sdk.platformtools.Log.i(r1, r2)
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.lang.String r2 = "widgetId"
            r1.put(r2, r7)
            java.lang.String r2 = "onSearchWAWidgetReloadData"
            boolean r3 = r0.IRj
            java.lang.String r4 = r0.zpY
            java.lang.String r1 = com.tencent.mm.plugin.webview.d.n.a.b(r2, r1, r3, r4)
            com.tencent.mm.plugin.webview.d.h$51 r2 = new com.tencent.mm.plugin.webview.d.h$51
            r2.<init>(r1)
            com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(r2)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            goto L_0x0018
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.fts.d.a.aXa(java.lang.String):void");
    }

    @Override // com.tencent.mm.plugin.websearch.api.n
    public final void lH(String str, String str2) {
        AppMethodBeat.i(78182);
        h hVar = this.IBw;
        if (!hVar.GBl) {
            Log.e("MicroMsg.JsApiHandler", "onSearchWAWidgetDataPush fail, not ready");
            AppMethodBeat.o(78182);
            return;
        }
        Log.i("MicroMsg.JsApiHandler", "onSearchWAWidgetDataPush success, ready");
        HashMap hashMap = new HashMap();
        hashMap.put("widgetId", str);
        hashMap.put("data", str2);
        MMHandlerThread.postToMainThread(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0043: INVOKE  
              (wrap: com.tencent.mm.plugin.webview.d.h$54 : 0x0040: CONSTRUCTOR  (r2v4 com.tencent.mm.plugin.webview.d.h$54) = 
              (r0v0 'hVar' com.tencent.mm.plugin.webview.d.h)
              (wrap: java.lang.String : 0x003a: INVOKE  (r1v3 java.lang.String) = 
              ("onSearchWAWidgetDataPush")
              (r1v2 'hashMap' java.util.HashMap)
              (wrap: boolean : 0x0036: IGET  (r3v0 boolean) = (r0v0 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
              (wrap: java.lang.String : 0x0038: IGET  (r4v0 java.lang.String) = (r0v0 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
             type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
             call: com.tencent.mm.plugin.webview.d.h.54.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR)
             type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(java.lang.Runnable):void in method: com.tencent.mm.plugin.webview.fts.d.a.lH(java.lang.String, java.lang.String):void, file: classes.dex
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
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0040: CONSTRUCTOR  (r2v4 com.tencent.mm.plugin.webview.d.h$54) = 
              (r0v0 'hVar' com.tencent.mm.plugin.webview.d.h)
              (wrap: java.lang.String : 0x003a: INVOKE  (r1v3 java.lang.String) = 
              ("onSearchWAWidgetDataPush")
              (r1v2 'hashMap' java.util.HashMap)
              (wrap: boolean : 0x0036: IGET  (r3v0 boolean) = (r0v0 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
              (wrap: java.lang.String : 0x0038: IGET  (r4v0 java.lang.String) = (r0v0 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
             type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
             call: com.tencent.mm.plugin.webview.d.h.54.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.fts.d.a.lH(java.lang.String, java.lang.String):void, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 18 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.webview.d.h, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 24 more
            */
        /*
            this = this;
            r5 = 78182(0x13166, float:1.09556E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
            com.tencent.mm.plugin.webview.d.h r0 = r6.IBw
            boolean r1 = r0.GBl
            if (r1 != 0) goto L_0x0019
            java.lang.String r0 = "MicroMsg.JsApiHandler"
            java.lang.String r1 = "onSearchWAWidgetDataPush fail, not ready"
            com.tencent.mm.sdk.platformtools.Log.e(r0, r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
        L_0x0018:
            return
        L_0x0019:
            java.lang.String r1 = "MicroMsg.JsApiHandler"
            java.lang.String r2 = "onSearchWAWidgetDataPush success, ready"
            com.tencent.mm.sdk.platformtools.Log.i(r1, r2)
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.lang.String r2 = "widgetId"
            r1.put(r2, r7)
            java.lang.String r2 = "data"
            r1.put(r2, r8)
            java.lang.String r2 = "onSearchWAWidgetDataPush"
            boolean r3 = r0.IRj
            java.lang.String r4 = r0.zpY
            java.lang.String r1 = com.tencent.mm.plugin.webview.d.n.a.b(r2, r1, r3, r4)
            com.tencent.mm.plugin.webview.d.h$54 r2 = new com.tencent.mm.plugin.webview.d.h$54
            r2.<init>(r1)
            com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(r2)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            goto L_0x0018
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.fts.d.a.lH(java.lang.String, java.lang.String):void");
    }

    @Override // com.tencent.mm.plugin.websearch.api.n
    public final void j(String str, String str2, String str3, int i2) {
        AppMethodBeat.i(78183);
        h hVar = this.IBw;
        if (!hVar.GBl) {
            Log.e("MicroMsg.JsApiHandler", "onSearchWAWidgetOpenApp fail, not ready");
            AppMethodBeat.o(78183);
            return;
        }
        Log.i("MicroMsg.JsApiHandler", "onSearchWAWidgetOpenApp success, ready");
        HashMap hashMap = new HashMap();
        hashMap.put("widgetId", str);
        hashMap.put("path", str2);
        hashMap.put(ch.COL_USERNAME, str3);
        hashMap.put("debugMode", Integer.valueOf(i2));
        MMHandlerThread.postToMainThread(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0053: INVOKE  
              (wrap: com.tencent.mm.plugin.webview.d.h$50 : 0x0050: CONSTRUCTOR  (r2v6 com.tencent.mm.plugin.webview.d.h$50) = 
              (r0v0 'hVar' com.tencent.mm.plugin.webview.d.h)
              (wrap: java.lang.String : 0x004a: INVOKE  (r1v3 java.lang.String) = 
              ("onSearchWAWidgetOpenApp")
              (r1v2 'hashMap' java.util.HashMap)
              (wrap: boolean : 0x0046: IGET  (r3v1 boolean) = (r0v0 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
              (wrap: java.lang.String : 0x0048: IGET  (r4v0 java.lang.String) = (r0v0 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
             type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
             call: com.tencent.mm.plugin.webview.d.h.50.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR)
             type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(java.lang.Runnable):void in method: com.tencent.mm.plugin.webview.fts.d.a.j(java.lang.String, java.lang.String, java.lang.String, int):void, file: classes.dex
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
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0050: CONSTRUCTOR  (r2v6 com.tencent.mm.plugin.webview.d.h$50) = 
              (r0v0 'hVar' com.tencent.mm.plugin.webview.d.h)
              (wrap: java.lang.String : 0x004a: INVOKE  (r1v3 java.lang.String) = 
              ("onSearchWAWidgetOpenApp")
              (r1v2 'hashMap' java.util.HashMap)
              (wrap: boolean : 0x0046: IGET  (r3v1 boolean) = (r0v0 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
              (wrap: java.lang.String : 0x0048: IGET  (r4v0 java.lang.String) = (r0v0 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
             type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
             call: com.tencent.mm.plugin.webview.d.h.50.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.fts.d.a.j(java.lang.String, java.lang.String, java.lang.String, int):void, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 18 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.webview.d.h, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 24 more
            */
        /*
            this = this;
            r5 = 78183(0x13167, float:1.09558E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
            com.tencent.mm.plugin.webview.d.h r0 = r6.IBw
            boolean r1 = r0.GBl
            if (r1 != 0) goto L_0x0019
            java.lang.String r0 = "MicroMsg.JsApiHandler"
            java.lang.String r1 = "onSearchWAWidgetOpenApp fail, not ready"
            com.tencent.mm.sdk.platformtools.Log.e(r0, r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
        L_0x0018:
            return
        L_0x0019:
            java.lang.String r1 = "MicroMsg.JsApiHandler"
            java.lang.String r2 = "onSearchWAWidgetOpenApp success, ready"
            com.tencent.mm.sdk.platformtools.Log.i(r1, r2)
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.lang.String r2 = "widgetId"
            r1.put(r2, r7)
            java.lang.String r2 = "path"
            r1.put(r2, r8)
            java.lang.String r2 = "username"
            r1.put(r2, r9)
            java.lang.String r2 = "debugMode"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r10)
            r1.put(r2, r3)
            java.lang.String r2 = "onSearchWAWidgetOpenApp"
            boolean r3 = r0.IRj
            java.lang.String r4 = r0.zpY
            java.lang.String r1 = com.tencent.mm.plugin.webview.d.n.a.b(r2, r1, r3, r4)
            com.tencent.mm.plugin.webview.d.h$50 r2 = new com.tencent.mm.plugin.webview.d.h$50
            r2.<init>(r1)
            com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(r2)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            goto L_0x0018
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.fts.d.a.j(java.lang.String, java.lang.String, java.lang.String, int):void");
    }

    @Override // com.tencent.mm.plugin.websearch.api.n
    public final void b(String str, boolean z, String str2, String str3) {
        AppMethodBeat.i(78184);
        this.IBw.b(str, z, str2, str3);
        AppMethodBeat.o(78184);
    }

    @Override // com.tencent.mm.plugin.websearch.api.n
    public final void ge(String str, int i2) {
        AppMethodBeat.i(78185);
        h hVar = this.IBw;
        if (!hVar.GBl) {
            Log.e("MicroMsg.JsApiHandler", "onSearchWAWidgetAttrChanged fail, not ready");
            AppMethodBeat.o(78185);
            return;
        }
        Log.i("MicroMsg.JsApiHandler", "onSearchWAWidgetAttrChanged success, ready");
        HashMap hashMap = new HashMap();
        hashMap.put("widgetId", str);
        hashMap.put("height", Integer.valueOf(i2));
        MMHandlerThread.postToMainThread(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0047: INVOKE  
              (wrap: com.tencent.mm.plugin.webview.d.h$37 : 0x0044: CONSTRUCTOR  (r2v4 com.tencent.mm.plugin.webview.d.h$37) = 
              (r0v0 'hVar' com.tencent.mm.plugin.webview.d.h)
              (wrap: java.lang.String : 0x003e: INVOKE  (r1v3 java.lang.String) = 
              ("onSearchWAWidgetAttrChanged")
              (r1v2 'hashMap' java.util.HashMap)
              (wrap: boolean : 0x003a: IGET  (r3v1 boolean) = (r0v0 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
              (wrap: java.lang.String : 0x003c: IGET  (r4v0 java.lang.String) = (r0v0 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
             type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
             call: com.tencent.mm.plugin.webview.d.h.37.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR)
             type: STATIC call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(java.lang.Runnable):void in method: com.tencent.mm.plugin.webview.fts.d.a.ge(java.lang.String, int):void, file: classes.dex
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
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0044: CONSTRUCTOR  (r2v4 com.tencent.mm.plugin.webview.d.h$37) = 
              (r0v0 'hVar' com.tencent.mm.plugin.webview.d.h)
              (wrap: java.lang.String : 0x003e: INVOKE  (r1v3 java.lang.String) = 
              ("onSearchWAWidgetAttrChanged")
              (r1v2 'hashMap' java.util.HashMap)
              (wrap: boolean : 0x003a: IGET  (r3v1 boolean) = (r0v0 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.IRj boolean)
              (wrap: java.lang.String : 0x003c: IGET  (r4v0 java.lang.String) = (r0v0 'hVar' com.tencent.mm.plugin.webview.d.h) com.tencent.mm.plugin.webview.d.h.zpY java.lang.String)
             type: STATIC call: com.tencent.mm.plugin.webview.d.n.a.b(java.lang.String, java.util.Map, boolean, java.lang.String):java.lang.String)
             call: com.tencent.mm.plugin.webview.d.h.37.<init>(com.tencent.mm.plugin.webview.d.h, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.fts.d.a.ge(java.lang.String, int):void, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 18 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.webview.d.h, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 24 more
            */
        /*
            this = this;
            r5 = 78185(0x13169, float:1.0956E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
            com.tencent.mm.plugin.webview.d.h r0 = r6.IBw
            boolean r1 = r0.GBl
            if (r1 != 0) goto L_0x0019
            java.lang.String r0 = "MicroMsg.JsApiHandler"
            java.lang.String r1 = "onSearchWAWidgetAttrChanged fail, not ready"
            com.tencent.mm.sdk.platformtools.Log.e(r0, r1)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
        L_0x0018:
            return
        L_0x0019:
            java.lang.String r1 = "MicroMsg.JsApiHandler"
            java.lang.String r2 = "onSearchWAWidgetAttrChanged success, ready"
            com.tencent.mm.sdk.platformtools.Log.i(r1, r2)
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.lang.String r2 = "widgetId"
            r1.put(r2, r7)
            java.lang.String r2 = "height"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r8)
            r1.put(r2, r3)
            java.lang.String r2 = "onSearchWAWidgetAttrChanged"
            boolean r3 = r0.IRj
            java.lang.String r4 = r0.zpY
            java.lang.String r1 = com.tencent.mm.plugin.webview.d.n.a.b(r2, r1, r3, r4)
            com.tencent.mm.plugin.webview.d.h$37 r2 = new com.tencent.mm.plugin.webview.d.h$37
            r2.<init>(r1)
            com.tencent.mm.sdk.platformtools.MMHandlerThread.postToMainThread(r2)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            goto L_0x0018
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.fts.d.a.ge(java.lang.String, int):void");
    }

    @Override // com.tencent.mm.plugin.websearch.api.n
    public final void fXJ() {
    }
}
