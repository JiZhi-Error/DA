package com.tencent.mm.plugin.webview.modeltools;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.ak.h;
import com.tencent.mm.app.o;
import com.tencent.mm.g.a.aau;
import com.tencent.mm.g.a.aax;
import com.tencent.mm.g.a.aay;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.g.a.cn;
import com.tencent.mm.g.a.df;
import com.tencent.mm.g.a.l;
import com.tencent.mm.g.a.le;
import com.tencent.mm.g.a.om;
import com.tencent.mm.g.a.pv;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.y;
import com.tencent.mm.model.z;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.webview.b.e;
import com.tencent.mm.plugin.webview.emojistore.a;
import com.tencent.mm.plugin.webview.fts.b;
import com.tencent.mm.plugin.webview.fts.c;
import com.tencent.mm.plugin.webview.fts.i;
import com.tencent.mm.plugin.webview.fts.j;
import com.tencent.mm.plugin.webview.model.am;
import com.tencent.mm.plugin.webview.model.an;
import com.tencent.mm.plugin.webview.model.ao;
import com.tencent.mm.plugin.webview.model.aq;
import com.tencent.mm.plugin.webview.model.as;
import com.tencent.mm.plugin.webview.model.aw;
import com.tencent.mm.plugin.webview.model.d;
import com.tencent.mm.pluginsdk.model.x;
import com.tencent.mm.pluginsdk.ui.tools.r;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.fap;
import com.tencent.mm.protocal.protobuf.qu;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.storagebase.h;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.XWalkEnvironment;

public class g implements bd {
    private static final HashMap<Integer, h.b> baseDBFactories;
    private an JaH;
    private ao JaI;
    private am JaJ;
    private m JaK;
    private com.tencent.mm.plugin.webview.model.g JaL;
    private aq JaM;
    private e JaN;
    private j JaO;
    private b JaP;
    private c JaQ;
    private a JaR;
    private com.tencent.mm.plugin.webview.luggage.a JaS;
    private com.tencent.mm.plugin.game.api.h JaT = new com.tencent.mm.plugin.game.api.h() {
        /* class com.tencent.mm.plugin.webview.modeltools.g.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.game.api.h
        public final void eb(String str, int i2) {
            AppMethodBeat.i(79150);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(ShareConstants.RESULT_POST_ID, str);
                jSONObject.put("result", i2);
                Bundle bundle = new Bundle();
                bundle.putString("name", "onPublishHaowanEnd");
                bundle.putString("data", jSONObject.toString());
                ToolsProcessIPCService.a(bundle, com.tencent.mm.plugin.webview.luggage.a.a.class, null);
                AppMethodBeat.o(79150);
            } catch (JSONException e2) {
                AppMethodBeat.o(79150);
            }
        }

        @Override // com.tencent.mm.plugin.game.api.h
        public final void f(String str, float f2) {
            AppMethodBeat.i(79151);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(ShareConstants.RESULT_POST_ID, str);
                jSONObject.put("percent", (double) f2);
                Bundle bundle = new Bundle();
                bundle.putString("name", "onPublishHaowanProgress");
                bundle.putString("data", jSONObject.toString());
                ToolsProcessIPCService.a(bundle, com.tencent.mm.plugin.webview.luggage.a.a.class, null);
                AppMethodBeat.o(79151);
            } catch (JSONException e2) {
                AppMethodBeat.o(79151);
            }
        }
    };
    private IListener JaU = new IListener<l>() {
        /* class com.tencent.mm.plugin.webview.modeltools.g.AnonymousClass12 */

        {
            AppMethodBeat.i(160434);
            this.__eventId = l.class.getName().hashCode();
            AppMethodBeat.o(160434);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x00cb  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x01a4  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x01e6  */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x0033  */
        @Override // com.tencent.mm.sdk.event.IListener
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ boolean callback(com.tencent.mm.g.a.l r13) {
            /*
            // Method dump skipped, instructions count: 497
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.modeltools.g.AnonymousClass12.callback(com.tencent.mm.sdk.event.IEvent):boolean");
        }
    };
    private IListener JaV = new IListener<pv>() {
        /* class com.tencent.mm.plugin.webview.modeltools.g.AnonymousClass16 */

        {
            AppMethodBeat.i(160437);
            this.__eventId = pv.class.getName().hashCode();
            AppMethodBeat.o(160437);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(pv pvVar) {
            AppMethodBeat.i(79170);
            pv pvVar2 = pvVar;
            com.tencent.f.h.RTc.aX(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001b: INVOKE  
                  (wrap: com.tencent.f.i : 0x0014: SGET  (r3v0 com.tencent.f.i) =  com.tencent.f.h.RTc com.tencent.f.i)
                  (wrap: com.tencent.mm.plugin.webview.fts.j$5 : 0x0018: CONSTRUCTOR  (r4v0 com.tencent.mm.plugin.webview.fts.j$5) = 
                  (wrap: com.tencent.mm.plugin.webview.fts.j : 0x0008: INVOKE  (r0v0 com.tencent.mm.plugin.webview.fts.j) =  type: STATIC call: com.tencent.mm.plugin.webview.modeltools.g.gdt():com.tencent.mm.plugin.webview.fts.j)
                  (wrap: int : 0x000e: IGET  (r1v1 int) = 
                  (wrap: com.tencent.mm.g.a.pv$a : 0x000c: IGET  (r1v0 com.tencent.mm.g.a.pv$a) = (r7v1 'pvVar2' com.tencent.mm.g.a.pv) com.tencent.mm.g.a.pv.dVV com.tencent.mm.g.a.pv$a)
                 com.tencent.mm.g.a.pv.a.scene int)
                  (wrap: java.lang.String : 0x0012: IGET  (r2v1 java.lang.String) = 
                  (wrap: com.tencent.mm.g.a.pv$a : 0x0010: IGET  (r2v0 com.tencent.mm.g.a.pv$a) = (r7v1 'pvVar2' com.tencent.mm.g.a.pv) com.tencent.mm.g.a.pv.dVV com.tencent.mm.g.a.pv$a)
                 com.tencent.mm.g.a.pv.a.sessionId java.lang.String)
                 call: com.tencent.mm.plugin.webview.fts.j.5.<init>(com.tencent.mm.plugin.webview.fts.j, int, java.lang.String):void type: CONSTRUCTOR)
                 type: INTERFACE call: com.tencent.f.i.aX(java.lang.Runnable):com.tencent.f.i.d in method: com.tencent.mm.plugin.webview.modeltools.g.16.callback(com.tencent.mm.g.a.pv):boolean, file: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0018: CONSTRUCTOR  (r4v0 com.tencent.mm.plugin.webview.fts.j$5) = 
                  (wrap: com.tencent.mm.plugin.webview.fts.j : 0x0008: INVOKE  (r0v0 com.tencent.mm.plugin.webview.fts.j) =  type: STATIC call: com.tencent.mm.plugin.webview.modeltools.g.gdt():com.tencent.mm.plugin.webview.fts.j)
                  (wrap: int : 0x000e: IGET  (r1v1 int) = 
                  (wrap: com.tencent.mm.g.a.pv$a : 0x000c: IGET  (r1v0 com.tencent.mm.g.a.pv$a) = (r7v1 'pvVar2' com.tencent.mm.g.a.pv) com.tencent.mm.g.a.pv.dVV com.tencent.mm.g.a.pv$a)
                 com.tencent.mm.g.a.pv.a.scene int)
                  (wrap: java.lang.String : 0x0012: IGET  (r2v1 java.lang.String) = 
                  (wrap: com.tencent.mm.g.a.pv$a : 0x0010: IGET  (r2v0 com.tencent.mm.g.a.pv$a) = (r7v1 'pvVar2' com.tencent.mm.g.a.pv) com.tencent.mm.g.a.pv.dVV com.tencent.mm.g.a.pv$a)
                 com.tencent.mm.g.a.pv.a.sessionId java.lang.String)
                 call: com.tencent.mm.plugin.webview.fts.j.5.<init>(com.tencent.mm.plugin.webview.fts.j, int, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.modeltools.g.16.callback(com.tencent.mm.g.a.pv):boolean, file: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 14 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.webview.fts.j, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 20 more
                */
            /*
                this = this;
                r5 = 79170(0x13542, float:1.10941E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
                com.tencent.mm.g.a.pv r7 = (com.tencent.mm.g.a.pv) r7
                com.tencent.mm.plugin.webview.fts.j r0 = com.tencent.mm.plugin.webview.modeltools.g.gdt()
                com.tencent.mm.g.a.pv$a r1 = r7.dVV
                int r1 = r1.scene
                com.tencent.mm.g.a.pv$a r2 = r7.dVV
                java.lang.String r2 = r2.sessionId
                com.tencent.f.i r3 = com.tencent.f.h.RTc
                com.tencent.mm.plugin.webview.fts.j$5 r4 = new com.tencent.mm.plugin.webview.fts.j$5
                r4.<init>(r1, r2)
                r3.aX(r4)
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.modeltools.g.AnonymousClass16.callback(com.tencent.mm.sdk.event.IEvent):boolean");
        }
    };
    IListener JaW = new IListener<aax>() {
        /* class com.tencent.mm.plugin.webview.modeltools.g.AnonymousClass3 */

        {
            AppMethodBeat.i(160426);
            this.__eventId = aax.class.getName().hashCode();
            AppMethodBeat.o(160426);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aax aax) {
            AppMethodBeat.i(79155);
            boolean a2 = a(aax);
            AppMethodBeat.o(79155);
            return a2;
        }

        private static boolean a(aax aax) {
            String replace;
            AppMethodBeat.i(79154);
            if (aax instanceof aax) {
                String aTY = z.aTY();
                ArrayList arrayList = new ArrayList();
                arrayList.add(aax.ehN.ehO);
                arrayList.add(aax.ehN.ehP);
                arrayList.add(aax.ehN.ehQ);
                arrayList.add(aax.ehN.ehR);
                arrayList.add(aax.ehN.url);
                arrayList.add(new StringBuilder().append(aax.ehN.ehS).toString());
                arrayList.add(aax.ehN.ehT);
                arrayList.add(aax.ehN.ehU);
                arrayList.add(new StringBuilder().append(aax.ehN.ehV).toString());
                arrayList.add(new StringBuilder().append(aax.ehN.ehW).toString());
                arrayList.add(aTY);
                arrayList.add(new StringBuilder().append(aax.ehN.ehX).toString());
                arrayList.add(aax.ehN.ehY);
                PString pString = new PString();
                String a2 = ((com.tencent.mm.plugin.sns.b.j) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.sns.b.j.class)).a(aax.ehN.ehZ, pString);
                arrayList.add(a2);
                arrayList.add("");
                arrayList.add("");
                arrayList.add("");
                int aJ = ac.aJ(aax.ehN.ehQ, aax.ehN.ehR);
                int aJ2 = ac.aJ(aTY, aax.ehN.ehT);
                arrayList.add(String.valueOf(aJ));
                arrayList.add(String.valueOf(aJ2));
                String str = aax.ehN.eia;
                String str2 = aax.ehN.eic;
                try {
                    str = URLEncoder.encode(str, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                    if (!Util.isNullOrNil(str2)) {
                        str2 = URLEncoder.encode(str2, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                    } else {
                        str2 = "";
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.SubCoreTools", e2, "", new Object[0]);
                }
                arrayList.add(str);
                arrayList.add(pString.value);
                arrayList.add(str2);
                Object[] objArr = new Object[20];
                objArr[0] = aax.ehN.ehO;
                objArr[1] = aax.ehN.ehP;
                objArr[2] = aax.ehN.ehQ;
                objArr[3] = aax.ehN.ehR;
                if (aax.ehN.url == null) {
                    replace = aax.ehN.url;
                } else {
                    replace = aax.ehN.url.replace(",", "!");
                }
                objArr[4] = replace;
                objArr[5] = Integer.valueOf(aax.ehN.ehS);
                objArr[6] = aax.ehN.ehT;
                objArr[7] = aax.ehN.ehU;
                objArr[8] = Integer.valueOf(aax.ehN.ehV);
                objArr[9] = Integer.valueOf(aax.ehN.ehW);
                objArr[10] = aTY;
                objArr[11] = Integer.valueOf(aax.ehN.ehX);
                objArr[12] = aax.ehN.ehY == null ? aax.ehN.ehY : aax.ehN.ehY.replace(",", "!");
                objArr[13] = aax.ehN.ehZ;
                objArr[14] = a2;
                objArr[15] = Integer.valueOf(aJ);
                objArr[16] = Integer.valueOf(aJ2);
                objArr[17] = aax.ehN.eia;
                objArr[18] = pString.value;
                objArr[19] = aax.ehN.eic;
                Log.d("MicroMsg.SubCoreTools", "report(11954) : prePublishId : %s, curPublishId : %s, preUsername : %s, preChatName : %s, url : %s, preMsgIndex : %s, curChatName : %s, curChatTitle : %s, curChatMemberCount : %s, sendAppMsgScene : %s, curUserName : %s, getA8KeyScene : %s, referUrl : %s. : statExtStr:%s(%s), preChatType:%d, curChatType:%d, webViewTitle:%s, sourceAppId:%s  webViewDesc: %s", objArr);
                if (aax.ehN.eib != 2) {
                    com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                    com.tencent.mm.plugin.report.service.h.r(11954, arrayList);
                }
                AppMethodBeat.o(79154);
                return true;
            }
            AppMethodBeat.o(79154);
            return false;
        }
    };
    IListener JaX = new IListener<aay>() {
        /* class com.tencent.mm.plugin.webview.modeltools.g.AnonymousClass4 */

        {
            AppMethodBeat.i(160427);
            this.__eventId = aay.class.getName().hashCode();
            AppMethodBeat.o(160427);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aay aay) {
            AppMethodBeat.i(79156);
            aay aay2 = aay;
            if (aay2 instanceof aay) {
                com.tencent.mm.plugin.webview.h.a.agh(aay2.eid.eie);
                AppMethodBeat.o(79156);
                return true;
            }
            AppMethodBeat.o(79156);
            return false;
        }
    };
    final IListener<aau> JaY = new IListener<aau>() {
        /* class com.tencent.mm.plugin.webview.modeltools.g.AnonymousClass5 */

        {
            AppMethodBeat.i(160428);
            this.__eventId = aau.class.getName().hashCode();
            AppMethodBeat.o(160428);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aau aau) {
            AppMethodBeat.i(79157);
            d.IXv = aau.ehJ.ehK.substring(11);
            AppMethodBeat.o(79157);
            return true;
        }
    };
    IListener JaZ = new IListener<le>() {
        /* class com.tencent.mm.plugin.webview.modeltools.g.AnonymousClass6 */

        {
            AppMethodBeat.i(160429);
            this.__eventId = le.class.getName().hashCode();
            AppMethodBeat.o(160429);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(le leVar) {
            AppMethodBeat.i(79158);
            le leVar2 = leVar;
            if (leVar2 instanceof le) {
                com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ghF().d(leVar2.dQr.requestCode, leVar2.dQr.resultCode, leVar2.dQr.dQs);
                AppMethodBeat.o(79158);
                return true;
            }
            AppMethodBeat.o(79158);
            return false;
        }
    };
    final IListener<l> Jba = new IListener<l>() {
        /* class com.tencent.mm.plugin.webview.modeltools.g.AnonymousClass8 */
        private Boolean Jbi = null;

        {
            AppMethodBeat.i(160430);
            this.__eventId = l.class.getName().hashCode();
            AppMethodBeat.o(160430);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* bridge */ /* synthetic */ boolean callback(l lVar) {
            return false;
        }
    };
    IListener Jbb = new IListener<df>() {
        /* class com.tencent.mm.plugin.webview.modeltools.g.AnonymousClass9 */

        {
            AppMethodBeat.i(160431);
            this.__eventId = df.class.getName().hashCode();
            AppMethodBeat.o(160431);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(df dfVar) {
            AppMethodBeat.i(79162);
            boolean a2 = a(dfVar);
            AppMethodBeat.o(79162);
            return a2;
        }

        private static boolean a(df dfVar) {
            AppMethodBeat.i(79161);
            if (dfVar instanceof df) {
                SharedPreferences.Editor edit = MMApplicationContext.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                XWalkEnvironment.setIpType(com.tencent.mm.n.h.aqJ().getInt("WebKernelMode", -1));
                String value = com.tencent.mm.n.h.aqJ().getValue("WebviewDownloadTbs");
                String value2 = com.tencent.mm.n.h.aqJ().getValue("WebviewEnableTbs");
                Log.i("MicroMsg.SubCoreTools", "updateWebViewDynamicConfig, tbsDownload = %s, tbsEnable = %s, tbsSupportedVerSec = %s", value, value2, com.tencent.mm.n.h.aqJ().getValue("WebviewSupportedTbsVersionSection"));
                if (value != null) {
                    edit.putString("tbs_download", value);
                }
                edit.apply();
                if ("1".equals(value) && "1".equals(value2)) {
                    r.pl(1);
                }
                if (value != null) {
                    try {
                        if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(value)) {
                            Log.i("MicroMsg.SubCoreTools", "tbs download disable, reset tbssdk in sandbox");
                            Intent intent = new Intent();
                            intent.setComponent(new ComponentName(MMApplicationContext.getPackageName(), "com.tencent.mm.booter.MMReceivers$SandBoxProcessReceiver"));
                            MMApplicationContext.getContext().sendBroadcast(intent);
                        }
                    } catch (Exception e2) {
                        Log.w("MicroMsg.SubCoreTools", "sendbroadcast ,ex = %s", e2.getMessage());
                    }
                }
            }
            AppMethodBeat.o(79161);
            return false;
        }
    };
    IListener Jbc = new IListener<com.tencent.mm.g.a.b>() {
        /* class com.tencent.mm.plugin.webview.modeltools.g.AnonymousClass10 */

        {
            AppMethodBeat.i(160432);
            this.__eventId = com.tencent.mm.g.a.b.class.getName().hashCode();
            AppMethodBeat.o(160432);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(com.tencent.mm.g.a.b bVar) {
            AppMethodBeat.i(79163);
            com.tencent.mm.g.a.b bVar2 = bVar;
            if (bVar2 instanceof com.tencent.mm.g.a.b) {
                Intent intent = new Intent();
                if (bVar2.dBM != null) {
                    intent.putExtra("card_list", bVar2.dBM.dBN);
                    intent.putExtra("result_code", bVar2.dBM.resultCode);
                }
                if (bVar2.dBM == null || bVar2.dBM.resultCode != -1) {
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ghF().d(16, 0, intent);
                } else {
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ghF().d(16, -1, intent);
                }
            }
            AppMethodBeat.o(79163);
            return false;
        }
    };
    IListener Jbd = new IListener<cn>() {
        /* class com.tencent.mm.plugin.webview.modeltools.g.AnonymousClass11 */

        {
            AppMethodBeat.i(160433);
            this.__eventId = cn.class.getName().hashCode();
            AppMethodBeat.o(160433);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(cn cnVar) {
            AppMethodBeat.i(79164);
            cn cnVar2 = cnVar;
            if (cnVar2 instanceof cn) {
                Intent intent = new Intent();
                if (cnVar2.dFI == null || cnVar2.dFI.resultCode != -1) {
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ghF().d(29, 0, intent);
                } else {
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.g.ghF().d(29, -1, intent);
                }
            }
            AppMethodBeat.o(79164);
            return false;
        }
    };
    private IListener Jbe = new IListener<om>() {
        /* class com.tencent.mm.plugin.webview.modeltools.g.AnonymousClass14 */

        {
            AppMethodBeat.i(160436);
            this.__eventId = om.class.getName().hashCode();
            AppMethodBeat.o(160436);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(om omVar) {
            AppMethodBeat.i(79167);
            om omVar2 = omVar;
            if (omVar2.dUz.scene == 0) {
                g.gdt().IPh = 0;
                g.gdt().IDS = null;
            } else {
                g.gdt().IPh = 1;
                g.gdt().IDS = new fap();
                g.gdt().IDS.NwQ = 1;
                g.gdt().IDS.NwR = new qu();
                g.gdt().IDS.NwR.dNI = omVar2.dUz.appId;
                g.gdt().IDS.NwR.KXC = omVar2.dUz.type;
                g.gdt().IDS.NwR.KXD = omVar2.dUz.version;
                g.gdt().IDS.NwR.qHp = omVar2.dUz.dUB;
            }
            AppMethodBeat.o(79167);
            return false;
        }
    };
    private o.a appForegroundListener = new o.a() {
        /* class com.tencent.mm.plugin.webview.modeltools.g.AnonymousClass7 */

        @Override // com.tencent.mm.app.o
        public final void onAppForeground(String str) {
            AppMethodBeat.i(79159);
            g.this.isAppActive = true;
            AppMethodBeat.o(79159);
        }

        @Override // com.tencent.mm.app.o
        public final void onAppBackground(String str) {
            AppMethodBeat.i(79160);
            g.this.isAppActive = false;
            AppMethodBeat.o(79160);
        }
    };
    private IListener<bp> iUx = new IListener<bp>() {
        /* class com.tencent.mm.plugin.webview.modeltools.g.AnonymousClass13 */

        {
            AppMethodBeat.i(160435);
            this.__eventId = bp.class.getName().hashCode();
            AppMethodBeat.o(160435);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(bp bpVar) {
            AppMethodBeat.i(79166);
            bp bpVar2 = bpVar;
            if (49 != bpVar2.dEN.dEO) {
                AppMethodBeat.o(79166);
                return false;
            } else if (1 != bpVar2.dEN.subType) {
                AppMethodBeat.o(79166);
                return false;
            } else if (!bpVar2.dEN.dEQ) {
                Log.i("MicroMsg.SubCoreTools", "receive xweb get config  notify!! fileUpdated == false ignore");
                AppMethodBeat.o(79166);
                return false;
            } else {
                Log.i("MicroMsg.SubCoreTools", "receive xweb get config  notify!!");
                MMApplicationContext.getContext();
                x.a.ahJ(5);
                AppMethodBeat.o(79166);
                return true;
            }
        }
    };
    public boolean isAppActive = true;
    private p netChanged = new p.a() {
        /* class com.tencent.mm.plugin.webview.modeltools.g.AnonymousClass15 */
        private final byte[] glH = new byte[0];

        {
            AppMethodBeat.i(79168);
            AppMethodBeat.o(79168);
        }

        @Override // com.tencent.mm.network.p
        public final void onNetworkChange(int i2) {
            AppMethodBeat.i(79169);
            synchronized (this.glH) {
                try {
                    String gcX = com.tencent.mm.pluginsdk.ui.tools.z.gcX();
                    if (gcX.equalsIgnoreCase("WIFI")) {
                        aw.gcU().setNetWorkState(1);
                    } else {
                        aw.gcU().setNetWorkState(2);
                    }
                    g.aZs(gcX);
                } finally {
                    AppMethodBeat.o(79169);
                }
            }
        }
    };
    private cj.a oUZ = new cj.a() {
        /* class com.tencent.mm.plugin.webview.modeltools.g.AnonymousClass2 */

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.a aVar) {
            AppMethodBeat.i(79153);
            final String a2 = com.tencent.mm.platformtools.z.a(aVar.heO.KHn);
            final m gdw = g.gdw();
            com.tencent.f.h.RTc.ba(new Runnable() {
                /* class com.tencent.mm.plugin.webview.modeltools.g.AnonymousClass2.AnonymousClass1 */

                public final void run() {
                    String str;
                    AppMethodBeat.i(79152);
                    Log.d("MicroMsg.SubCoreTools", "webview hijack sysMsgListener");
                    Map<String, String> parseXml = XmlParser.parseXml(a2, "sysmsg", null);
                    long j2 = Util.getLong(parseXml.get(".sysmsg.hijackconfig.expiretime"), MAlarmHandler.NEXT_FIRE_INTERVAL);
                    String str2 = ".sysmsg.hijackconfig.domainlist.domain";
                    int i2 = 0;
                    while (true) {
                        if (i2 > 0) {
                            str = ".sysmsg.hijackconfig.domainlist.domain" + i2;
                        } else {
                            str = str2;
                        }
                        i2++;
                        String str3 = parseXml.get(str);
                        if (!Util.isNullOrNil(str3)) {
                            i iVar = new i();
                            iVar.field_expireTime = j2;
                            iVar.field_host = str3;
                            gdw.insert(iVar);
                            str2 = str;
                        } else {
                            AppMethodBeat.o(79152);
                            return;
                        }
                    }
                }
            });
            AppMethodBeat.o(79153);
        }

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.c cVar) {
        }
    };

    public g() {
        AppMethodBeat.i(79172);
        AppMethodBeat.o(79172);
    }

    public static g gdp() {
        AppMethodBeat.i(79173);
        g gVar = (g) y.at(g.class);
        AppMethodBeat.o(79173);
        return gVar;
    }

    public static a gdq() {
        AppMethodBeat.i(79174);
        if (gdp().JaR == null) {
            gdp().JaR = new a();
        }
        a aVar = gdp().JaR;
        AppMethodBeat.o(79174);
        return aVar;
    }

    public static b gdr() {
        AppMethodBeat.i(79175);
        if (gdp().JaP == null) {
            gdp().JaP = new b();
        }
        b bVar = gdp().JaP;
        AppMethodBeat.o(79175);
        return bVar;
    }

    public static c gds() {
        AppMethodBeat.i(79176);
        if (gdp().JaQ == null) {
            gdp().JaQ = new c();
        }
        c cVar = gdp().JaQ;
        AppMethodBeat.o(79176);
        return cVar;
    }

    public static j gdt() {
        AppMethodBeat.i(79177);
        if (gdp().JaO == null) {
            gdp().JaO = new j();
        }
        j jVar = gdp().JaO;
        AppMethodBeat.o(79177);
        return jVar;
    }

    public static an gdu() {
        AppMethodBeat.i(79178);
        if (gdp().JaH == null) {
            gdp().JaH = new an();
        }
        an anVar = gdp().JaH;
        AppMethodBeat.o(79178);
        return anVar;
    }

    public static ao gdv() {
        AppMethodBeat.i(79179);
        if (gdp().JaI == null) {
            gdp().JaI = ao.gcQ();
        }
        ao aoVar = gdp().JaI;
        AppMethodBeat.o(79179);
        return aoVar;
    }

    public static m gdw() {
        AppMethodBeat.i(79180);
        if (gdp().JaK == null) {
            g gdp = gdp();
            com.tencent.mm.kernel.g.aAi();
            gdp.JaK = new m(com.tencent.mm.kernel.g.aAh().hqK);
        }
        m mVar = gdp().JaK;
        AppMethodBeat.o(79180);
        return mVar;
    }

    public static com.tencent.mm.plugin.webview.model.g gdx() {
        AppMethodBeat.i(79181);
        if (gdp().JaL == null) {
            g gdp = gdp();
            com.tencent.mm.kernel.g.aAi();
            gdp.JaL = new com.tencent.mm.plugin.webview.model.g(com.tencent.mm.kernel.g.aAh().hqK);
        }
        com.tencent.mm.plugin.webview.model.g gVar = gdp().JaL;
        AppMethodBeat.o(79181);
        return gVar;
    }

    public static aq gdy() {
        AppMethodBeat.i(79182);
        if (gdp().JaM == null) {
            g gdp = gdp();
            com.tencent.mm.kernel.g.aAi();
            gdp.JaM = new aq(com.tencent.mm.kernel.g.aAh().hqK);
        }
        aq aqVar = gdp().JaM;
        AppMethodBeat.o(79182);
        return aqVar;
    }

    public static e gdz() {
        AppMethodBeat.i(79183);
        if (gdp().JaN == null) {
            g gdp = gdp();
            com.tencent.mm.kernel.g.aAi();
            gdp.JaN = new e(com.tencent.mm.kernel.g.aAh().hqK);
        }
        e eVar = gdp().JaN;
        AppMethodBeat.o(79183);
        return eVar;
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(79184);
        Log.i("MicroMsg.SubCoreTools", "onAccountRelease hc:%d", Integer.valueOf(hashCode()));
        this.JaU.dead();
        EventCenter.instance.removeListener(this.JaZ);
        EventCenter.instance.removeListener(this.Jbb);
        EventCenter.instance.removeListener(this.Jbc);
        EventCenter.instance.removeListener(this.Jbd);
        EventCenter.instance.removeListener(this.JaW);
        EventCenter.instance.removeListener(this.JaX);
        EventCenter.instance.removeListener(this.Jbe);
        EventCenter.instance.removeListener(this.iUx);
        this.appForegroundListener.dead();
        this.Jba.dead();
        this.JaV.dead();
        com.tencent.mm.kernel.g.aAg().b(this.netChanged);
        if (this.JaJ != null) {
            am amVar = this.JaJ;
            if (amVar.DXm != null) {
                f.cBv();
                com.tencent.mm.plugin.downloader.model.c.b(amVar.DXm);
            }
            if (amVar.IZf != null && amVar.IZf.size() > 0) {
                for (Long l : amVar.IZf) {
                    Log.i("MicroMsg.WebViewAutoDownloader", "remove download task : %d", l);
                    f.cBv().Cn(l.longValue());
                }
            }
        }
        if (this.JaQ != null) {
            c cVar = this.JaQ;
            com.tencent.mm.kernel.g.azz().b(2975, cVar);
            EventCenter.instance.removeListener(cVar.lEl);
            if (cVar.IOb != null) {
                com.tencent.mm.kernel.g.azz().b(1048, cVar);
                com.tencent.mm.kernel.g.azz().a(cVar.IOb);
                cVar.IOb = null;
            }
            this.JaQ = null;
        }
        if (this.JaO != null) {
            j jVar = this.JaO;
            jVar.IOZ.dead();
            jVar.IPl.dead();
            j.b bVar = jVar.IPo;
            if (bVar.IPe != null) {
                com.tencent.mm.kernel.g.azz().a(bVar.IPe);
            }
            if (bVar.IPv != null) {
                bVar.IPv.stopped = true;
            }
            j.c cVar2 = jVar.IPp;
            if (cVar2.IPx != null) {
                com.tencent.mm.kernel.g.azz().b(cVar2.IPx.getType(), j.this);
            }
            if (jVar.wXa != null) {
                ((n) com.tencent.mm.kernel.g.ah(n.class)).cancelSearchTask(jVar.wXa);
                jVar.wXa = null;
            }
            jVar.IPn.IOC.clear();
            jVar.IOP.removeCallbacksAndMessages(null);
            jVar.IOP.quit();
            this.JaO = null;
        }
        if (this.JaP != null) {
            b bVar2 = this.JaP;
            bVar2.DFm.dead();
            bVar2.INW.dead();
            com.tencent.mm.aj.p.aYB().remove(bVar2);
            this.JaP = null;
        }
        com.tencent.mm.kernel.g.azz().b(1532, com.tencent.mm.plugin.webview.fts.a.INO);
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().b("hijackconfig", this.oUZ, true);
        if (this.JaL != null) {
            this.JaL.gct();
        }
        this.JaY.dead();
        i gaz = i.gaz();
        i.a aVar = gaz.IOR;
        if (aVar.IPe != null) {
            com.tencent.mm.kernel.g.azz().a(aVar.IPe);
        }
        if (aVar.IPf != null) {
            aVar.IPf.stopped = true;
        }
        gaz.IOZ.dead();
        com.tencent.mm.kernel.g.ag(com.tencent.mm.plugin.webview.j.a.class);
        com.tencent.mm.plugin.webview.ui.tools.floatball.b.bCN();
        com.tencent.mm.plugin.webview.ui.tools.multitask.a.euB();
        com.tencent.mm.plugin.webview.luggage.r.gcc();
        gdu().b(this.JaS);
        com.tencent.mm.plugin.game.api.a.b(this.JaT);
        AppMethodBeat.o(79184);
    }

    static {
        AppMethodBeat.i(79187);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("WebViewHostsFilterTable".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.webview.modeltools.g.AnonymousClass17 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return m.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("WEBVIEW_JSLOG_BLOCK_LIST_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.webview.modeltools.g.AnonymousClass18 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.plugin.webview.model.g.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("WEBVIEW_LOCAL_DATA".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.webview.modeltools.g.AnonymousClass19 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return aq.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("WEBVIEW_DATA".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.webview.modeltools.g.AnonymousClass20 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.plugin.webview.b.c.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("WEBVIEW_HISTORY_DATA".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.webview.modeltools.g.AnonymousClass21 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return e.SQL_CREATE;
            }
        });
        AppMethodBeat.o(79187);
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return baseDBFactories;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(79185);
        Log.i("MicroMsg.SubCoreTools", "onAccountPostReset hc:%d", Integer.valueOf(hashCode()));
        this.JaU.alive();
        EventCenter.instance.addListener(this.JaZ);
        EventCenter.instance.addListener(this.Jbb);
        EventCenter.instance.addListener(this.Jbc);
        EventCenter.instance.addListener(this.Jbd);
        EventCenter.instance.addListener(this.JaW);
        EventCenter.instance.addListener(this.JaX);
        EventCenter.instance.addListener(this.Jbe);
        EventCenter.instance.addListener(this.iUx);
        this.appForegroundListener.alive();
        this.Jba.alive();
        this.JaV.alive();
        ((s) com.tencent.mm.kernel.g.ah(s.class)).getSysCmdMsgExtension().a("hijackconfig", this.oUZ, true);
        com.tencent.mm.kernel.g.aAg().a(this.netChanged);
        com.tencent.mm.plugin.x.c.INSTANCE.a(new d());
        com.tencent.mm.plugin.x.c.INSTANCE.a(new as());
        this.JaY.alive();
        k.c.a(new com.tencent.mm.co.c<com.tencent.mm.ag.f>() {
            /* class com.tencent.mm.plugin.webview.modeltools.g.AnonymousClass22 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.co.c
            public final /* synthetic */ com.tencent.mm.ag.f get() {
                AppMethodBeat.i(79171);
                aj ajVar = new aj();
                AppMethodBeat.o(79171);
                return ajVar;
            }
        });
        com.tencent.mm.cr.d.kT(MMApplicationContext.getContext());
        com.tencent.mm.kernel.g.aAf();
        XWalkEnvironment.setGrayValueByUserId(com.tencent.mm.kernel.a.getUin());
        if (com.tencent.mm.n.h.aqJ() != null) {
            XWalkEnvironment.setIpType(com.tencent.mm.n.h.aqJ().getInt("WebKernelMode", -1));
        }
        i.gaz();
        i.start();
        Log.d("MicroMsg.CityServiceHelper", "addCheckResUpdateListener");
        if (Log.getLogLevel() <= 0) {
            com.tencent.mm.pluginsdk.j.a.a.b.gnC();
            com.tencent.mm.pluginsdk.j.a.a.b.ahP(54);
        }
        EventCenter.instance.add(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00f1: INVOKE  
              (wrap: com.tencent.mm.sdk.event.EventCenter : 0x00ef: SGET  (r1v14 com.tencent.mm.sdk.event.EventCenter) =  com.tencent.mm.sdk.event.EventCenter.instance com.tencent.mm.sdk.event.EventCenter)
              (wrap: com.tencent.mm.plugin.webview.modeltools.b$1 : 0x00ec: CONSTRUCTOR  (r0v27 com.tencent.mm.plugin.webview.modeltools.b$1) =  call: com.tencent.mm.plugin.webview.modeltools.b.1.<init>():void type: CONSTRUCTOR)
             type: VIRTUAL call: com.tencent.mm.sdk.event.EventCenter.add(com.tencent.mm.sdk.event.IListener):com.tencent.mm.vending.b.b in method: com.tencent.mm.plugin.webview.modeltools.g.onAccountPostReset(boolean):void, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
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
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00ec: CONSTRUCTOR  (r0v27 com.tencent.mm.plugin.webview.modeltools.b$1) =  call: com.tencent.mm.plugin.webview.modeltools.b.1.<init>():void type: CONSTRUCTOR in method: com.tencent.mm.plugin.webview.modeltools.g.onAccountPostReset(boolean):void, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.webview.modeltools.b, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 20 more
            */
        /*
        // Method dump skipped, instructions count: 304
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.modeltools.g.onAccountPostReset(boolean):void");
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    static /* synthetic */ void aZs(String str) {
        int i2;
        AppMethodBeat.i(79186);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DownloadInfo.NETTYPE, str);
            Context context = MMApplicationContext.getContext();
            if (NetStatusUtil.is2G(context)) {
                Log.i("MicroMsg.SubCoreTools", "onNetWorkChange 2g");
                jSONObject.put("networkType", "2g");
            }
            if (NetStatusUtil.is3G(context)) {
                Log.i("MicroMsg.SubCoreTools", "onNetWorkChange 3g");
                jSONObject.put("networkType", "3g");
            }
            if (NetStatusUtil.is4G(context)) {
                Log.i("MicroMsg.SubCoreTools", "onNetWorkChange 4g");
                jSONObject.put("networkType", "4g");
            }
            if (NetStatusUtil.is5G(context)) {
                Log.i("MicroMsg.SubCoreTools", "onNetWorkChange 5g");
                jSONObject.put("networkType", "5g");
            }
            if (NetStatusUtil.isWifi(context)) {
                Log.i("MicroMsg.SubCoreTools", "onNetWorkChange wifi");
                jSONObject.put("networkType", "wifi");
            }
            int Qr = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.misc.a.a.class) != null ? ((com.tencent.mm.plugin.misc.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.misc.a.a.class)).Qr(16) : 0;
            if (Qr == 0) {
                i2 = 0;
            } else {
                i2 = Qr == 1 ? 1 : 2;
            }
            jSONObject.put("simType", i2);
            Bundle bundle = new Bundle();
            bundle.putString("name", "onNetWorkChange");
            bundle.putString("data", jSONObject.toString());
            ToolsProcessIPCService.a(bundle, com.tencent.mm.plugin.webview.luggage.a.a.class, null);
            AppMethodBeat.o(79186);
        } catch (JSONException e2) {
            AppMethodBeat.o(79186);
        }
    }
}
