package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.network.ag;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.s;
import java.util.HashMap;

public class bq extends bs<g> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "uploadMediaFile";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(final b<g>.a aVar) {
        AppMethodBeat.i(78640);
        Log.i("MicroMsg.JsApiUploadMediaFile", "invokeInOwn");
        String optString = aVar.ctb.csi.optString("appId");
        String optString2 = aVar.ctb.csi.optString(ch.COL_LOCALID);
        boolean z = aVar.ctb.csi.optInt("isShowProgressTips", 0) == 1;
        Log.i("MicroMsg.JsApiUploadMediaFile", "uploadMediaFile, appid = %s, localid = %s, isShowProgressTips = %b", optString, optString2, Boolean.valueOf(z));
        if (Util.isNullOrNil(optString) || Util.isNullOrNil(optString2)) {
            Log.e("MicroMsg.JsApiUploadMediaFile", "appId or localid is null or nil.");
            aVar.c("missing arguments", null);
            AppMethodBeat.o(78640);
            return;
        }
        final LuggageUploadMediaFileManager luggageUploadMediaFileManager = new LuggageUploadMediaFileManager();
        AnonymousClass1 r8 = new LuggageUploadMediaFileManager.b() {
            /* class com.tencent.mm.plugin.webview.luggage.jsapi.bq.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager.b
            public final void b(boolean z, HashMap<String, Object> hashMap) {
                AppMethodBeat.i(78639);
                Log.i("MicroMsg.JsApiUploadMediaFile", "sucess = %b", Boolean.valueOf(z));
                if (z) {
                    aVar.e("", hashMap);
                } else {
                    aVar.c("fail", null);
                }
                LuggageUploadMediaFileManager luggageUploadMediaFileManager = luggageUploadMediaFileManager;
                luggageUploadMediaFileManager.qdG = null;
                luggageUploadMediaFileManager.ISU = null;
                luggageUploadMediaFileManager.mAppId = null;
                luggageUploadMediaFileManager.IWD = null;
                luggageUploadMediaFileManager.IWF = null;
                AppMethodBeat.o(78639);
            }
        };
        luggageUploadMediaFileManager.qdG = (MMActivity) aVar.cta.mContext;
        luggageUploadMediaFileManager.ISU = aVar.cta;
        luggageUploadMediaFileManager.mAppId = optString;
        luggageUploadMediaFileManager.IWD = optString2;
        luggageUploadMediaFileManager.IWE = z;
        luggageUploadMediaFileManager.IWF = r8;
        WebViewJSSDKFileItem aYC = com.tencent.mm.plugin.webview.luggage.c.b.aYC(luggageUploadMediaFileManager.IWD);
        if (aYC == null) {
            Log.e("MicroMsg.UploadMediaFileHelp", "item is null");
            luggageUploadMediaFileManager.IWF.b(false, null);
            AppMethodBeat.o(78640);
        } else if (aYC.mediaType == 1) {
            luggageUploadMediaFileManager.gcp();
            AppMethodBeat.o(78640);
        } else if (Util.isNullOrNil(aYC.laR) || !s.YS(aYC.laR)) {
            Log.e("MicroMsg.UploadMediaFileHelp", "origFilePath is not exist");
            luggageUploadMediaFileManager.IWF.b(false, null);
            AppMethodBeat.o(78640);
        } else if (!ag.dm(luggageUploadMediaFileManager.qdG)) {
            h.a((Context) luggageUploadMediaFileManager.qdG, luggageUploadMediaFileManager.qdG.getString(R.string.izm, new Object[]{Util.getSizeMB((long) ((int) s.boW(aYC.laR)))}), luggageUploadMediaFileManager.qdG.getString(R.string.zb), false, (DialogInterface.OnClickListener) 
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0106: INVOKE  
                  (wrap: android.content.Context : ?: CAST (android.content.Context) (wrap: com.tencent.mm.ui.MMActivity : 0x00e4: IGET  (r0v25 com.tencent.mm.ui.MMActivity) = (r7v2 'luggageUploadMediaFileManager' com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager) com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager.qdG com.tencent.mm.ui.MMActivity))
                  (wrap: java.lang.String : 0x00ef: INVOKE  (r1v17 java.lang.String) = 
                  (wrap: com.tencent.mm.ui.MMActivity : 0x00e6: IGET  (r2v2 com.tencent.mm.ui.MMActivity) = (r7v2 'luggageUploadMediaFileManager' com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager) com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager.qdG com.tencent.mm.ui.MMActivity)
                  (wrap: int : ?: SGET   com.tencent.mm.R.string.izm int)
                  (wrap: java.lang.Object[] : ?: FILLED_NEW_ARRAY  (r4v1 java.lang.Object[]) = 
                  (wrap: java.lang.String : 0x00e0: INVOKE  (r1v16 java.lang.String) = 
                  (wrap: long : 0x00df: CAST (r0v24 long) = (long) (wrap: int : 0x00de: CAST (r0v23 int) = (int) (wrap: long : 0x00da: INVOKE  (r0v22 long) = 
                  (wrap: java.lang.String : 0x00d8: IGET  (r0v21 java.lang.String) = (r0v18 'aYC' com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem) com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem.laR java.lang.String)
                 type: STATIC call: com.tencent.mm.vfs.s.boW(java.lang.String):long)))
                 type: STATIC call: com.tencent.mm.sdk.platformtools.Util.getSizeMB(long):java.lang.String)
                 elemType: java.lang.Object)
                 type: VIRTUAL call: com.tencent.mm.ui.MMActivity.getString(int, java.lang.Object[]):java.lang.String)
                  (wrap: java.lang.String : 0x00f8: INVOKE  (r2v4 java.lang.String) = 
                  (wrap: com.tencent.mm.ui.MMActivity : 0x00f3: IGET  (r2v3 com.tencent.mm.ui.MMActivity) = (r7v2 'luggageUploadMediaFileManager' com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager) com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager.qdG com.tencent.mm.ui.MMActivity)
                  (wrap: int : ?: SGET   com.tencent.mm.R.string.zb int)
                 type: VIRTUAL call: com.tencent.mm.ui.MMActivity.getString(int):java.lang.String)
                  false
                  (wrap: android.content.DialogInterface$OnClickListener : ?: CAST (android.content.DialogInterface$OnClickListener) (wrap: com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager$1 : 0x00fe: CONSTRUCTOR  (r4v3 com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager$1) = (r7v2 'luggageUploadMediaFileManager' com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager) call: com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager.1.<init>(com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager):void type: CONSTRUCTOR))
                  (wrap: android.content.DialogInterface$OnClickListener : ?: CAST (android.content.DialogInterface$OnClickListener) (wrap: com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager$2 : 0x0103: CONSTRUCTOR  (r5v2 com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager$2) = (r7v2 'luggageUploadMediaFileManager' com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager) call: com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager.2.<init>(com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager):void type: CONSTRUCTOR))
                 type: STATIC call: com.tencent.mm.ui.base.h.a(android.content.Context, java.lang.String, java.lang.String, boolean, android.content.DialogInterface$OnClickListener, android.content.DialogInterface$OnClickListener):com.tencent.mm.ui.widget.a.d in method: com.tencent.mm.plugin.webview.luggage.jsapi.bq.b(com.tencent.luggage.d.b<com.tencent.mm.plugin.webview.luggage.g>$a):void, file: classes7.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:176)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:153)
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
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: CAST (android.content.DialogInterface$OnClickListener) (wrap: com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager$1 : 0x00fe: CONSTRUCTOR  (r4v3 com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager$1) = (r7v2 'luggageUploadMediaFileManager' com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager) call: com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager.1.<init>(com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager):void type: CONSTRUCTOR) in method: com.tencent.mm.plugin.webview.luggage.jsapi.bq.b(com.tencent.luggage.d.b<com.tencent.mm.plugin.webview.luggage.g>$a):void, file: classes7.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 29 more
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00fe: CONSTRUCTOR  (r4v3 com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager$1) = (r7v2 'luggageUploadMediaFileManager' com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager) call: com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager.1.<init>(com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.luggage.jsapi.bq.b(com.tencent.luggage.d.b<com.tencent.mm.plugin.webview.luggage.g>$a):void, file: classes7.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:290)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 35 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.webview.luggage.jsapi.LuggageUploadMediaFileManager, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 39 more
                */
            /*
            // Method dump skipped, instructions count: 286
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.luggage.jsapi.bq.b(com.tencent.luggage.d.b$a):void");
        }

        @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
        public final void a(Context context, String str, br.a aVar) {
        }
    }
