package com.tencent.mm.plugin.report.b;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.tencent.b.a.a.f;
import com.tencent.b.a.a.i;
import com.tencent.b.a.a.n;
import com.tencent.b.a.a.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.protocal.protobuf.dhx;
import com.tencent.mm.protocal.protobuf.dhy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;

public final class d {
    private static i CxM = i.bq(MMApplicationContext.getContext());
    private static int CxN = 2;

    static /* synthetic */ int chC() {
        int i2 = CxN;
        CxN = i2 - 1;
        return i2;
    }

    static {
        AppMethodBeat.i(134233);
        AppMethodBeat.o(134233);
    }

    public static String eOz() {
        AppMethodBeat.i(134230);
        try {
            i.a(new f() {
                /* class com.tencent.mm.plugin.report.b.d.AnonymousClass1 */

                @Override // com.tencent.b.a.a.f
                public final void eW(String str) {
                    AppMethodBeat.i(134229);
                    Log.i("MicroMsg.MidHelper", "QueryMid onDispatch2WXServer req:%s limit:%d", str, Integer.valueOf(d.CxN));
                    if (d.chC() <= 0) {
                        Log.e("MicroMsg.MidHelper", "THE FUCKING querymid do too much! :%d", Integer.valueOf(d.CxN));
                        AppMethodBeat.o(134229);
                        return;
                    }
                    d.a aVar = new d.a();
                    aVar.iLN = new dhx();
                    aVar.iLO = new dhy();
                    aVar.uri = "/cgi-bin/micromsg-bin/querymid";
                    aVar.funcId = com.tencent.mm.plugin.appbrand.jsapi.p.d.CTRL_INDEX;
                    com.tencent.mm.ak.d aXF = aVar.aXF();
                    ((dhx) aXF.iLK.iLR).sTh = str;
                    ((dhx) aXF.iLK.iLR).him = 1;
                    aa.a(aXF, new aa.a() {
                        /* class com.tencent.mm.plugin.report.b.d.AnonymousClass1.AnonymousClass1 */

                        @Override // com.tencent.mm.ak.aa.a
                        public final int a(int i2, int i3, String str, com.tencent.mm.ak.d dVar, q qVar) {
                            AppMethodBeat.i(134228);
                            Log.i("MicroMsg.MidHelper", "onGYNetEnd errType:%d errCode:%d msg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                            AppMethodBeat.o(134228);
                            return 0;
                        }
                    }, true);
                    AppMethodBeat.o(134229);
                }
            });
            String TZ = CxM.TZ();
            Log.i("MicroMsg.MidHelper", "QueryMid try Get Now getMid:%s getLocalMid:%s", TZ, CxM.Ua());
            AppMethodBeat.o(134230);
            return TZ;
        } catch (Exception e2) {
            Log.e("MicroMsg.MidHelper", "QueryMid Error e:%s", Util.stackTraceToString(e2));
            AppMethodBeat.o(134230);
            return "";
        }
    }

    public static void aMs(String str) {
        AppMethodBeat.i(134231);
        try {
            i iVar = CxM;
            if (i.mContext != null) {
                i.dfO = System.currentTimeMillis();
                n.dfZ = -1;
                try {
                    SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(i.mContext).edit();
                    edit.putLong("__MID_LAST_CHECK_TIME__", i.dfO);
                    edit.commit();
                } catch (Exception e2) {
                    s.Uh();
                }
                if (i.mHandler != null) {
                    i.mHandler.post(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0038: INVOKE  
                          (wrap: android.os.Handler : 0x0031: SGET  (r1v5 android.os.Handler) =  com.tencent.b.a.a.i.mHandler android.os.Handler)
                          (wrap: com.tencent.b.a.a.i$1 : 0x0035: CONSTRUCTOR  (r2v5 com.tencent.b.a.a.i$1) = (r0v2 'iVar' com.tencent.b.a.a.i), (r9v0 'str' java.lang.String) call: com.tencent.b.a.a.i.1.<init>(com.tencent.b.a.a.i, java.lang.String):void type: CONSTRUCTOR)
                         type: VIRTUAL call: android.os.Handler.post(java.lang.Runnable):boolean in method: com.tencent.mm.plugin.report.b.d.aMs(java.lang.String):void, file: classes4.dex
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
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
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
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0035: CONSTRUCTOR  (r2v5 com.tencent.b.a.a.i$1) = (r0v2 'iVar' com.tencent.b.a.a.i), (r9v0 'str' java.lang.String) call: com.tencent.b.a.a.i.1.<init>(com.tencent.b.a.a.i, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.report.b.d.aMs(java.lang.String):void, file: classes4.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 29 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.b.a.a.i, state: GENERATED_AND_UNLOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 35 more
                        */
                    /*
                    // Method dump skipped, instructions count: 111
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.report.b.d.aMs(java.lang.String):void");
                }

                public static int E(int i2, int i3, String str) {
                    int i4;
                    AppMethodBeat.i(134232);
                    if (!g.aAc()) {
                        Log.i("MicroMsg.MidHelper", "checkReportMid acc not ready");
                        AppMethodBeat.o(134232);
                        return -1;
                    }
                    long nowSecond = Util.nowSecond();
                    if (i2 != 3 || Util.nullAs((Long) g.aAh().azQ().get(331778, (Object) null), 0) < nowSecond) {
                        if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
                            i4 = 1;
                        } else if (NetStatusUtil.isWifi(MMApplicationContext.getContext())) {
                            i4 = 3;
                        } else if (NetStatusUtil.is3G(MMApplicationContext.getContext())) {
                            i4 = 2;
                        } else {
                            i4 = 0;
                        }
                        String eOz = eOz();
                        Log.i("MicroMsg.MidHelper", "querymid checkReportMid moment:%d mid[%s]", Integer.valueOf(i2), eOz);
                        e.INSTANCE.a(11402, eOz, Integer.valueOf(i2), Integer.valueOf(i4), com.tencent.mm.compatible.deviceinfo.q.aoG(), Integer.valueOf(i3), str, NetStatusUtil.getISPName(MMApplicationContext.getContext()), 0, com.tencent.mm.compatible.deviceinfo.q.dr(false));
                        g.aAh().azQ().set(331778, Long.valueOf(259200 + nowSecond));
                        AppMethodBeat.o(134232);
                        return 0;
                    }
                    AppMethodBeat.o(134232);
                    return 0;
                }
            }
