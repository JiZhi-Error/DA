package com.tencent.mm.plugin.appbrand.launching;

import android.util.Pair;
import com.tencent.luggage.sdk.launching.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.ab;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.launching.a.c;
import com.tencent.mm.plugin.appbrand.launching.a.e;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.ys;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.h.d;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ay extends aw<Pair<HashMap<String, AppRuntimeApiPermissionBundle>, Boolean>> implements aa {
    final String appId;
    final boolean cuy;
    final WxaAttributes.WxaVersionInfo cyv;
    final b cyz;
    final int enterScene;
    final int iOo;
    final QualitySession ldW;
    final String mRZ;
    List<e> mWM = new LinkedList();

    @Override // com.tencent.mm.plugin.appbrand.launching.aa, com.tencent.mm.plugin.appbrand.launching.aw
    public final /* bridge */ /* synthetic */ boolean bNh() {
        AppMethodBeat.i(227102);
        boolean bNh = super.bNh();
        AppMethodBeat.o(227102);
        return bNh;
    }

    @Override // com.tencent.mm.plugin.appbrand.launching.aw
    public final /* bridge */ /* synthetic */ void hX(boolean z) {
        AppMethodBeat.i(227101);
        super.hX(z);
        AppMethodBeat.o(227101);
    }

    ay(String str, int i2, boolean z, WxaAttributes.WxaVersionInfo wxaVersionInfo, int i3, String str2, QualitySession qualitySession, b bVar) {
        AppMethodBeat.i(227098);
        this.appId = str;
        this.iOo = i2;
        this.cuy = z;
        this.enterScene = i3;
        this.cyv = wxaVersionInfo;
        this.mRZ = str2;
        this.ldW = qualitySession;
        this.cyz = bVar;
        Log.i("MicroMsg.AppBrand.PrepareStepCheckAppWxaJsApiPermissionInfo", "<init> hash:%d, appId:%s,versionType:%d,isGame:%b,enterScene:%d, wxaColdStartMode:%s", Integer.valueOf(hashCode()), str, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), bVar);
        AppMethodBeat.o(227098);
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.plugin.appbrand.launching.aw
    public final String getTag() {
        return "MicroMsg.AppBrand.PrepareStepCheckAppWxaJsApiPermissionInfo";
    }

    /* access modifiers changed from: package-private */
    public void bsR() {
    }

    private static LinkedList<e> a(WxaAttributes.WxaVersionInfo wxaVersionInfo, boolean z) {
        List<WxaAttributes.WxaPluginCodeInfo> list;
        AppMethodBeat.i(227099);
        LinkedList<e> linkedList = new LinkedList<>();
        if (z) {
            List<WxaAttributes.WxaWidgetInfo> list2 = wxaVersionInfo.jmL;
            if (list2 == null || list2.size() <= 0) {
                AppMethodBeat.o(227099);
                return null;
            }
            for (WxaAttributes.WxaWidgetInfo wxaWidgetInfo : list2) {
                if (wxaWidgetInfo.packageType == 22 && (list = wxaWidgetInfo.lhk) != null && list.size() > 0) {
                    for (WxaAttributes.WxaPluginCodeInfo wxaPluginCodeInfo : list) {
                        for (Integer num : wxaPluginCodeInfo.contexts) {
                            if (num.intValue() == 3) {
                                e eVar = new e();
                                eVar.appId = wxaPluginCodeInfo.provider;
                                eVar.appType = 2;
                                linkedList.add(eVar);
                            }
                        }
                    }
                }
            }
            AppMethodBeat.o(227099);
            return linkedList;
        }
        AppMethodBeat.o(227099);
        return linkedList;
    }

    private boolean f(HashMap<String, AppRuntimeApiPermissionBundle> hashMap) {
        AppMethodBeat.i(227100);
        ao buD = n.buD();
        at buF = n.buF();
        if (buD == null || buF == null) {
            Log.i("MicroMsg.AppBrand.PrepareStepCheckAppWxaJsApiPermissionInfo", "needSyncCheckAppJsApiPermission storage null!");
            AppMethodBeat.o(227100);
            return false;
        }
        if (this.mWM != null && this.mWM.size() > 0) {
            for (e eVar : this.mWM) {
                String str = eVar.appId;
                int i2 = eVar.appType;
                if (i2 == 2) {
                    ys ach = buF.ach(str);
                    if (ach == null) {
                        Log.i("MicroMsg.AppBrand.PrepareStepCheckAppWxaJsApiPermissionInfo", "needSyncCheckAppJsApiPermission pluginInfoStorage not include appId:%s!", str);
                        AppMethodBeat.o(227100);
                        return true;
                    } else if (ach.LjS == null) {
                        Log.i("MicroMsg.AppBrand.PrepareStepCheckAppWxaJsApiPermissionInfo", "needSyncCheckAppJsApiPermission pluginInfoStorage appId:%s jsapi_control_bytes null!", str);
                        AppMethodBeat.o(227100);
                        return true;
                    } else {
                        hashMap.put(str, new AppRuntimeApiPermissionBundle(ach));
                    }
                } else if (i2 == 1) {
                    ap apVar = new ap();
                    apVar.field_appId = str;
                    if (!buD.a(apVar, "appId")) {
                        AppMethodBeat.o(227100);
                        return true;
                    } else if (apVar.field_jsapiInfo == null) {
                        AppMethodBeat.o(227100);
                        return true;
                    }
                } else {
                    continue;
                }
            }
        }
        AppMethodBeat.o(227100);
        return false;
    }

    @Override // java.util.concurrent.Callable
    public /* synthetic */ Object call() {
        AppMethodBeat.i(227103);
        HashMap<String, AppRuntimeApiPermissionBundle> hashMap = new HashMap<>();
        this.mWM = a(this.cyv, this.cuy);
        if (this.mWM == null || this.mWM.size() <= 0) {
            Log.i("MicroMsg.AppBrand.PrepareStepCheckAppWxaJsApiPermissionInfo", "call() todoChecJsApiAppInfoList null, return, hash:%d", Integer.valueOf(hashCode()));
            AppMethodBeat.o(227103);
            return null;
        }
        acc acc = new acc();
        acc.dUS = this.enterScene;
        acc.LmF = b.PRE_RENDER == this.cyz;
        if (f(hashMap)) {
            Log.i("MicroMsg.AppBrand.PrepareStepCheckAppWxaJsApiPermissionInfo", "CgiWxaJsApiInfo sync");
            bsR();
            acc.LmG = 101;
            c cVar = new c(this.appId, this.cyv.cyu, this.mWM, true, this.mRZ, this.ldW, this, acc);
            cVar.mWd = true;
            ab.a(cVar);
            Pair create = Pair.create(cVar.mXT, Boolean.TRUE);
            AppMethodBeat.o(227103);
            return create;
        }
        Log.i("MicroMsg.AppBrand.PrepareStepCheckAppWxaJsApiPermissionInfo", "CgiWxaJsApiInfo async");
        acc.LmG = 102;
        d.LOGIC.arrange(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00af: INVOKE  
              (wrap: com.tencent.mm.vending.h.h : 0x00a8: SGET  (r1v5 com.tencent.mm.vending.h.h) =  com.tencent.mm.vending.h.d.LOGIC com.tencent.mm.vending.h.h)
              (wrap: com.tencent.mm.plugin.appbrand.launching.a.c$1 : 0x00ac: CONSTRUCTOR  (r2v2 com.tencent.mm.plugin.appbrand.launching.a.c$1) = 
              (wrap: com.tencent.mm.plugin.appbrand.launching.a.c : 0x00a5: CONSTRUCTOR  (r0v14 com.tencent.mm.plugin.appbrand.launching.a.c) = 
              (wrap: java.lang.String : 0x0099: IGET  (r1v4 java.lang.String) = (r11v0 'this' com.tencent.mm.plugin.appbrand.launching.ay A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.appbrand.launching.ay.appId java.lang.String)
              (wrap: int : 0x009b: IGET  (r2v1 int) = (r11v0 'this' com.tencent.mm.plugin.appbrand.launching.ay A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.appbrand.launching.ay.iOo int)
              (wrap: java.util.List<com.tencent.mm.plugin.appbrand.launching.a.e> : 0x009d: IGET  (r3v2 java.util.List<com.tencent.mm.plugin.appbrand.launching.a.e>) = (r11v0 'this' com.tencent.mm.plugin.appbrand.launching.ay A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.appbrand.launching.ay.mWM java.util.List)
              false
              (wrap: java.lang.String : 0x009f: IGET  (r5v0 java.lang.String) = (r11v0 'this' com.tencent.mm.plugin.appbrand.launching.ay A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.appbrand.launching.ay.mRZ java.lang.String)
              (wrap: com.tencent.mm.plugin.appbrand.report.quality.QualitySession : 0x00a1: IGET  (r6v0 com.tencent.mm.plugin.appbrand.report.quality.QualitySession) = (r11v0 'this' com.tencent.mm.plugin.appbrand.launching.ay A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.appbrand.launching.ay.ldW com.tencent.mm.plugin.appbrand.report.quality.QualitySession)
              (r11v0 'this' com.tencent.mm.plugin.appbrand.launching.ay A[IMMUTABLE_TYPE, THIS])
              (r8v0 'acc' com.tencent.mm.protocal.protobuf.acc)
             call: com.tencent.mm.plugin.appbrand.launching.a.c.<init>(java.lang.String, int, java.util.List, boolean, java.lang.String, com.tencent.mm.plugin.appbrand.report.quality.QualitySession, com.tencent.mm.plugin.appbrand.launching.ay, com.tencent.mm.protocal.protobuf.acc):void type: CONSTRUCTOR)
             call: com.tencent.mm.plugin.appbrand.launching.a.c.1.<init>(com.tencent.mm.plugin.appbrand.launching.a.c):void type: CONSTRUCTOR)
             type: VIRTUAL call: com.tencent.mm.vending.h.h.arrange(java.lang.Runnable):void in method: com.tencent.mm.plugin.appbrand.launching.ay.call():java.lang.Object, file: classes3.dex
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
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00ac: CONSTRUCTOR  (r2v2 com.tencent.mm.plugin.appbrand.launching.a.c$1) = 
              (wrap: com.tencent.mm.plugin.appbrand.launching.a.c : 0x00a5: CONSTRUCTOR  (r0v14 com.tencent.mm.plugin.appbrand.launching.a.c) = 
              (wrap: java.lang.String : 0x0099: IGET  (r1v4 java.lang.String) = (r11v0 'this' com.tencent.mm.plugin.appbrand.launching.ay A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.appbrand.launching.ay.appId java.lang.String)
              (wrap: int : 0x009b: IGET  (r2v1 int) = (r11v0 'this' com.tencent.mm.plugin.appbrand.launching.ay A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.appbrand.launching.ay.iOo int)
              (wrap: java.util.List<com.tencent.mm.plugin.appbrand.launching.a.e> : 0x009d: IGET  (r3v2 java.util.List<com.tencent.mm.plugin.appbrand.launching.a.e>) = (r11v0 'this' com.tencent.mm.plugin.appbrand.launching.ay A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.appbrand.launching.ay.mWM java.util.List)
              false
              (wrap: java.lang.String : 0x009f: IGET  (r5v0 java.lang.String) = (r11v0 'this' com.tencent.mm.plugin.appbrand.launching.ay A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.appbrand.launching.ay.mRZ java.lang.String)
              (wrap: com.tencent.mm.plugin.appbrand.report.quality.QualitySession : 0x00a1: IGET  (r6v0 com.tencent.mm.plugin.appbrand.report.quality.QualitySession) = (r11v0 'this' com.tencent.mm.plugin.appbrand.launching.ay A[IMMUTABLE_TYPE, THIS]) com.tencent.mm.plugin.appbrand.launching.ay.ldW com.tencent.mm.plugin.appbrand.report.quality.QualitySession)
              (r11v0 'this' com.tencent.mm.plugin.appbrand.launching.ay A[IMMUTABLE_TYPE, THIS])
              (r8v0 'acc' com.tencent.mm.protocal.protobuf.acc)
             call: com.tencent.mm.plugin.appbrand.launching.a.c.<init>(java.lang.String, int, java.util.List, boolean, java.lang.String, com.tencent.mm.plugin.appbrand.report.quality.QualitySession, com.tencent.mm.plugin.appbrand.launching.ay, com.tencent.mm.protocal.protobuf.acc):void type: CONSTRUCTOR)
             call: com.tencent.mm.plugin.appbrand.launching.a.c.1.<init>(com.tencent.mm.plugin.appbrand.launching.a.c):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.launching.ay.call():java.lang.Object, file: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 22 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.appbrand.launching.a.c, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 28 more
            */
        /*
        // Method dump skipped, instructions count: 188
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.launching.ay.call():java.lang.Object");
    }
}
