package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.o;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import org.json.JSONObject;

public class aq extends br<s> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return JsApiPauseDownloadTask.NAME;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 2;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<s>.a aVar) {
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, final br.a aVar) {
        boolean z;
        AppMethodBeat.i(78593);
        try {
            JSONObject jSONObject = new JSONObject(str);
            long optLong = jSONObject.optLong("download_id");
            if (optLong <= 0) {
                Log.e("MicroMsg.JsApiPauseDownloadTask", "fail, invalid downloadId = ".concat(String.valueOf(optLong)));
                aVar.i("invalid_downloadid", null);
                AppMethodBeat.o(78593);
                return;
            }
            a Cw = d.Cw(optLong);
            if (Cw == null) {
                aVar.i(null, null);
                AppMethodBeat.o(78593);
                return;
            }
            int optInt = jSONObject.optInt("scene", 1000);
            int optInt2 = jSONObject.optInt("uiarea");
            int optInt3 = jSONObject.optInt("notice_id");
            int optInt4 = jSONObject.optInt(TPDownloadProxyEnum.USER_SSID);
            boolean z2 = jSONObject.optInt("ignoreNetwork", 0) == 1;
            Cw.field_scene = optInt;
            Cw.field_uiarea = optInt2;
            Cw.field_noticeId = optInt3;
            Cw.field_ssid = optInt4;
            Cw.field_downloadInWifi = false;
            d.e(Cw);
            AnonymousClass1 r4 = new o.a() {
                /* class com.tencent.mm.plugin.webview.luggage.jsapi.aq.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.downloader.model.o.a
                public final void i(String str, JSONObject jSONObject) {
                    AppMethodBeat.i(210949);
                    aVar.i(str, jSONObject);
                    AppMethodBeat.o(210949);
                }
            };
            if (!f.cBv().Cp(optLong)) {
                r4.i("fail", null);
                AppMethodBeat.o(78593);
            } else if (NetStatusUtil.isWifi(context)) {
                r4.i(null, null);
                AppMethodBeat.o(78593);
            } else if (d.Cw(optLong) == null) {
                r4.i(null, null);
                AppMethodBeat.o(78593);
            } else {
                if (!z2 || !((com.tencent.mm.game.report.a.b) g.af(com.tencent.mm.game.report.a.b.class)).a(b.a.clicfg_download_game_ignore_network, false)) {
                    z = false;
                } else {
                    z = true;
                }
                if (z) {
                    ((com.tencent.mm.plugin.downloader_app.api.b) g.af(com.tencent.mm.plugin.downloader_app.api.b.class)).a(context, 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x010f: INVOKE  
                          (wrap: com.tencent.mm.plugin.downloader_app.api.b : 0x0103: CHECK_CAST (r0v19 com.tencent.mm.plugin.downloader_app.api.b) = (com.tencent.mm.plugin.downloader_app.api.b) (wrap: com.tencent.mm.kernel.c.a : 0x00ff: INVOKE  (r0v18 com.tencent.mm.kernel.c.a) = (wrap: java.lang.Class : 0x00fd: CONST_CLASS   com.tencent.mm.plugin.downloader_app.api.b.class) type: STATIC call: com.tencent.mm.kernel.g.af(java.lang.Class):com.tencent.mm.kernel.c.a))
                          (r11v0 'context' android.content.Context)
                          (wrap: com.tencent.mm.plugin.downloader.model.o$7 : 0x0107: CONSTRUCTOR  (r5v3 com.tencent.mm.plugin.downloader.model.o$7) = (r2v1 'optLong' long), (r4v4 'r4' com.tencent.mm.plugin.webview.luggage.jsapi.aq$1) call: com.tencent.mm.plugin.downloader.model.o.7.<init>(long, com.tencent.mm.plugin.downloader.model.o$a):void type: CONSTRUCTOR)
                          (wrap: com.tencent.mm.plugin.downloader.model.o$8 : 0x010c: CONSTRUCTOR  (r6v2 com.tencent.mm.plugin.downloader.model.o$8) = 
                          (r2v1 'optLong' long)
                          (r4v4 'r4' com.tencent.mm.plugin.webview.luggage.jsapi.aq$1)
                          (wrap: org.json.JSONObject : 0x00fa: CONSTRUCTOR  (r1v12 org.json.JSONObject) =  call: org.json.JSONObject.<init>():void type: CONSTRUCTOR)
                         call: com.tencent.mm.plugin.downloader.model.o.8.<init>(long, com.tencent.mm.plugin.downloader.model.o$a, org.json.JSONObject):void type: CONSTRUCTOR)
                         type: INTERFACE call: com.tencent.mm.plugin.downloader_app.api.b.a(android.content.Context, com.tencent.mm.plugin.downloader_app.api.b$a, com.tencent.mm.plugin.downloader_app.api.b$a):void in method: com.tencent.mm.plugin.webview.luggage.jsapi.aq.a(android.content.Context, java.lang.String, com.tencent.mm.plugin.webview.luggage.jsapi.br$a):void, file: classes.dex
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
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                        	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                        	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:306)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:69)
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0107: CONSTRUCTOR  (r5v3 com.tencent.mm.plugin.downloader.model.o$7) = (r2v1 'optLong' long), (r4v4 'r4' com.tencent.mm.plugin.webview.luggage.jsapi.aq$1) call: com.tencent.mm.plugin.downloader.model.o.7.<init>(long, com.tencent.mm.plugin.downloader.model.o$a):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.luggage.jsapi.aq.a(android.content.Context, java.lang.String, com.tencent.mm.plugin.webview.luggage.jsapi.br$a):void, file: classes.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 43 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.downloader.model.o, state: GENERATED_AND_UNLOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 49 more
                        */
                    /*
                    // Method dump skipped, instructions count: 312
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.luggage.jsapi.aq.a(android.content.Context, java.lang.String, com.tencent.mm.plugin.webview.luggage.jsapi.br$a):void");
                }
            }
