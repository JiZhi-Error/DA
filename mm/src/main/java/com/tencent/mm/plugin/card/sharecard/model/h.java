package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.a;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.protocal.protobuf.dxh;
import com.tencent.mm.protocal.protobuf.dxi;
import com.tencent.mm.protocal.protobuf.dxj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.soter.core.biometric.FaceManager;
import java.util.LinkedList;

public final class h extends q implements m {
    private i callback;
    private final d rr;

    public h() {
        AppMethodBeat.i(112975);
        d.a aVar = new d.a();
        aVar.iLN = new dxi();
        aVar.iLO = new dxj();
        aVar.uri = "/cgi-bin/micromsg-bin/sharecardsync";
        aVar.funcId = FaceManager.FACE_ACQUIRED_MULTI_FACE;
        aVar.iLP = 0;
        aVar.respCmdId = 0;
        this.rr = aVar.aXF();
        ((dxi) this.rr.iLK.iLR).MXl = ((Long) g.aAh().azQ().get(ar.a.USERINFO_CARD_REQUENCE_LONG_SYNC, (Object) 0L)).longValue();
        AppMethodBeat.o(112975);
    }

    @Override // com.tencent.mm.ak.q
    public final int getType() {
        return FaceManager.FACE_ACQUIRED_MULTI_FACE;
    }

    @Override // com.tencent.mm.ak.q
    public final int doScene(com.tencent.mm.network.g gVar, i iVar) {
        AppMethodBeat.i(112976);
        this.callback = iVar;
        int dispatch = dispatch(gVar, this.rr, this);
        AppMethodBeat.o(112976);
        return dispatch;
    }

    @Override // com.tencent.mm.network.m
    public final void onGYNetEnd(int i2, int i3, int i4, String str, s sVar, byte[] bArr) {
        int i5;
        AppMethodBeat.i(112977);
        Log.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", Integer.valueOf(getType()), Integer.valueOf(i3), Integer.valueOf(i4));
        if (i3 == 0 && i4 == 0) {
            dxj dxj = (dxj) this.rr.iLL.iLR;
            LinkedList<dxh> linkedList = dxj.iAd == null ? null : dxj.iAd;
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(linkedList == null ? 0 : linkedList.size());
            objArr[1] = Integer.valueOf(dxj.MXm);
            objArr[2] = Long.valueOf(dxj.seq);
            Log.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, share card cmd list size = %d, continueFlag = %d, req = %d", objArr);
            if (linkedList == null || linkedList.size() <= 0) {
                Log.i("MicroMsg.NetSceneShareCardSync", "share cmdList == null or size is 0");
                a ctX = am.ctX();
                Log.i("MicroMsg.ShareCardBatchGetCardMgr", "scsmgr sharecardsync retryAll, getNow = %b", Boolean.TRUE);
                synchronized (ctX.lock) {
                    try {
                        ctX.pendingList.addAll(ctX.pQE);
                        ctX.pQE.clear();
                    } catch (Throwable th) {
                        AppMethodBeat.o(112977);
                        throw th;
                    }
                }
                ctX.ctd();
            } else {
                int i6 = 0;
                for (dxh dxh : linkedList) {
                    if (!b(dxh)) {
                        i5 = i6 + 1;
                    } else {
                        i5 = i6;
                    }
                    i6 = i5;
                }
                Log.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, %d fail share cmds", Integer.valueOf(i6));
                am.ctX().ctd();
            }
            g.aAh().azQ().set(ar.a.USERINFO_CARD_REQUENCE_LONG_SYNC, Long.valueOf(dxj.seq));
            am.ctX().pVJ = dxj.pVJ;
            if (dxj.MXm > 0) {
                Log.i("MicroMsg.NetSceneShareCardSync", "onGYNetEnd, should continue, continueFlag = %d", Integer.valueOf(dxj.MXm));
                a ctX2 = am.ctX();
                ctX2.mHandler.post(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x010e: INVOKE  
                      (wrap: com.tencent.mm.sdk.platformtools.MMHandler : 0x0107: IGET  (r1v13 com.tencent.mm.sdk.platformtools.MMHandler) = (r0v14 'ctX2' com.tencent.mm.plugin.card.sharecard.a.a) com.tencent.mm.plugin.card.sharecard.a.a.mHandler com.tencent.mm.sdk.platformtools.MMHandler)
                      (wrap: com.tencent.mm.plugin.card.sharecard.a.a$2 : 0x010b: CONSTRUCTOR  (r2v16 com.tencent.mm.plugin.card.sharecard.a.a$2) = (r0v14 'ctX2' com.tencent.mm.plugin.card.sharecard.a.a) call: com.tencent.mm.plugin.card.sharecard.a.a.2.<init>(com.tencent.mm.plugin.card.sharecard.a.a):void type: CONSTRUCTOR)
                     type: VIRTUAL call: com.tencent.mm.sdk.platformtools.MMHandler.post(java.lang.Runnable):boolean in method: com.tencent.mm.plugin.card.sharecard.model.h.onGYNetEnd(int, int, int, java.lang.String, com.tencent.mm.network.s, byte[]):void, file: classes8.dex
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
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x010b: CONSTRUCTOR  (r2v16 com.tencent.mm.plugin.card.sharecard.a.a$2) = (r0v14 'ctX2' com.tencent.mm.plugin.card.sharecard.a.a) call: com.tencent.mm.plugin.card.sharecard.a.a.2.<init>(com.tencent.mm.plugin.card.sharecard.a.a):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.card.sharecard.model.h.onGYNetEnd(int, int, int, java.lang.String, com.tencent.mm.network.s, byte[]):void, file: classes8.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 26 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.card.sharecard.a.a, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 32 more
                    */
                /*
                // Method dump skipped, instructions count: 348
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.card.sharecard.model.h.onGYNetEnd(int, int, int, java.lang.String, com.tencent.mm.network.s, byte[]):void");
            }

            private static boolean b(dxh dxh) {
                AppMethodBeat.i(112978);
                if (dxh == null) {
                    Log.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem fail, null cmd");
                    AppMethodBeat.o(112978);
                    return false;
                }
                Log.i("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, item card_id = %s, seq = %d", dxh.eaO, Long.valueOf(dxh.seq));
                try {
                    Log.i("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, card user item, Status = %d", Integer.valueOf(dxh.pVR));
                    switch (dxh.pVR) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 7:
                            am.ctX().a(dxh);
                            break;
                        case 6:
                            a ctX = am.ctX();
                            if (dxh != null) {
                                ShareCardInfo ajA = am.ctY().ajA(dxh.eaO);
                                am.ctY().ajz(dxh.eaO);
                                Log.i("MicroMsg.ShareCardBatchGetCardMgr", "delete share card for id " + dxh.eaO);
                                if (ajA != null) {
                                    b.a(MMApplicationContext.getContext(), ajA);
                                } else {
                                    Log.e("MicroMsg.ShareCardBatchGetCardMgr", "info is null");
                                }
                                ctX.onChange();
                                break;
                            } else {
                                Log.e("MicroMsg.ShareCardBatchGetCardMgr", "delete item is  null");
                                break;
                            }
                        default:
                            Log.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem, card user item, unknown StateFlag = %d", Integer.valueOf(dxh.pVR));
                            AppMethodBeat.o(112978);
                            return false;
                    }
                    if (!(dxh.pVR == 0 || dxh.pVR == 5)) {
                        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_CARD_MSG_CARD_ID_STRING_SYNC, "");
                        boolean booleanValue = ((Boolean) g.aAh().azQ().get(ar.a.USERINFO_CARD_MSG_NEED_CHECK_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
                        if (booleanValue && !Util.isNullOrNil(str) && str.equals(dxh.eaO)) {
                            Log.i("MicroMsg.NetSceneShareCardSync", "need check is true, do clearRedDotAndWording()");
                            k.ctF();
                        } else if (booleanValue) {
                            Log.i("MicroMsg.NetSceneShareCardSync", "need check is true, but card id is diff!");
                        } else {
                            Log.i("MicroMsg.NetSceneShareCardSync", "need check is false");
                        }
                    }
                    AppMethodBeat.o(112978);
                    return true;
                } catch (Exception e2) {
                    Log.e("MicroMsg.NetSceneShareCardSync", "processShareCardCmdItem fail, ex = %s", e2.getMessage());
                    AppMethodBeat.o(112978);
                    return false;
                }
            }
        }
