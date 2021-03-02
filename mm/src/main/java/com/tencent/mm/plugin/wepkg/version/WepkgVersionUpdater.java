package com.tencent.mm.plugin.wepkg.version;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wepkg.event.ForceUpdateNotify;
import com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.c;
import com.tencent.mm.plugin.wepkg.model.j;
import com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.protocal.protobuf.aac;
import com.tencent.mm.protocal.protobuf.aad;
import com.tencent.mm.protocal.protobuf.aav;
import com.tencent.mm.protocal.protobuf.dbq;
import com.tencent.mm.protocal.protobuf.fbe;
import com.tencent.mm.protocal.protobuf.fbi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class WepkgVersionUpdater {
    public static void F(List<String> list, int i2) {
        AppMethodBeat.i(110839);
        if (Util.isNullOrNil(list)) {
            AppMethodBeat.o(110839);
            return;
        }
        HashSet hashSet = new HashSet();
        hashSet.addAll(list);
        a(hashSet, i2, false);
        AppMethodBeat.o(110839);
    }

    public static void a(Set<String> set, int i2, boolean z) {
        AppMethodBeat.i(110840);
        a(set, i2, -1, z);
        AppMethodBeat.o(110840);
    }

    public static void a(Set<String> set, int i2, int i3, boolean z) {
        AppMethodBeat.i(110841);
        if (set == null) {
            AppMethodBeat.o(110841);
            return;
        }
        LinkedList linkedList = new LinkedList();
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        for (String str : set) {
            if (!Util.isNullOrNil(str)) {
                stringBuffer.append(str);
                stringBuffer.append(";");
                aav aav = new aav();
                aav.xJD = str;
                aav.Scene = i2;
                WepkgVersion bcH = j.bcH(str);
                if (bcH == null) {
                    aav.Version = "";
                    linkedList.add(aav);
                } else {
                    aav.Version = bcH.version;
                    if (d.currentTime() >= bcH.JNU) {
                        linkedList.add(aav);
                        j.bcK(str);
                    } else {
                        stringBuffer2.append(str);
                        stringBuffer2.append(";");
                    }
                }
            }
        }
        Log.i("MicroMsg.Wepkg.WepkgVersionUpdater", "All wepkg list[%s] to update, excluded wepkg list[%s], scene:%d, downloadTriggerType:%d, isReportSize:%b", stringBuffer.toString(), stringBuffer2.toString(), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z));
        if (!Util.isNullOrNil(linkedList)) {
            b(linkedList, i3, z);
        }
        AppMethodBeat.o(110841);
    }

    private static void b(LinkedList<aav> linkedList, int i2, boolean z) {
        AppMethodBeat.i(110842);
        if (linkedList.size() == 0) {
            AppMethodBeat.o(110842);
            return;
        }
        final WepkgNetSceneProcessTask wepkgNetSceneProcessTask = new WepkgNetSceneProcessTask();
        wepkgNetSceneProcessTask.eij = i2;
        wepkgNetSceneProcessTask.JOt = z;
        Iterator<aav> it = linkedList.iterator();
        while (it.hasNext()) {
            aav next = it.next();
            WepkgNetSceneProcessTask.WepkgCheckReq wepkgCheckReq = new WepkgNetSceneProcessTask.WepkgCheckReq((byte) 0);
            wepkgCheckReq.hhD = next.xJD;
            wepkgCheckReq.version = next.Version;
            wepkgCheckReq.scene = next.Scene;
            wepkgNetSceneProcessTask.JOs.add(wepkgCheckReq);
        }
        if (MMApplicationContext.isMMProcess()) {
            d.cyh().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(110825);
                    wepkgNetSceneProcessTask.bjj();
                    AppMethodBeat.o(110825);
                }
            });
            AppMethodBeat.o(110842);
            return;
        }
        AppBrandMainProcessService.a(wepkgNetSceneProcessTask);
        AppMethodBeat.o(110842);
    }

    /* access modifiers changed from: package-private */
    public static final class WepkgNetSceneProcessTask extends BaseWepkgProcessTask {
        public static final Parcelable.Creator<WepkgNetSceneProcessTask> CREATOR = new Parcelable.Creator<WepkgNetSceneProcessTask>() {
            /* class com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater.WepkgNetSceneProcessTask.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ WepkgNetSceneProcessTask[] newArray(int i2) {
                return new WepkgNetSceneProcessTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ WepkgNetSceneProcessTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(110828);
                WepkgNetSceneProcessTask wepkgNetSceneProcessTask = new WepkgNetSceneProcessTask(parcel, (byte) 0);
                AppMethodBeat.o(110828);
                return wepkgNetSceneProcessTask;
            }
        };
        private List<WepkgCheckReq> JOs;
        private boolean JOt;
        private int eij;

        /* synthetic */ WepkgNetSceneProcessTask(Parcel parcel, byte b2) {
            this(parcel);
        }

        public WepkgNetSceneProcessTask() {
            AppMethodBeat.i(110833);
            this.JOs = new ArrayList();
            AppMethodBeat.o(110833);
        }

        private WepkgNetSceneProcessTask(Parcel parcel) {
            AppMethodBeat.i(110834);
            f(parcel);
            AppMethodBeat.o(110834);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(110835);
            if (Util.isNullOrNil(this.JOs)) {
                AppMethodBeat.o(110835);
                return;
            }
            d.a aVar = new d.a();
            aVar.funcId = 1313;
            aVar.iLP = 0;
            aVar.respCmdId = 0;
            aVar.uri = "/cgi-bin/mmgame-bin/checkwepkgversion";
            aac aac = new aac();
            for (WepkgCheckReq wepkgCheckReq : this.JOs) {
                aav aav = new aav();
                aav.xJD = wepkgCheckReq.hhD;
                aav.Version = wepkgCheckReq.version;
                aav.Scene = wepkgCheckReq.scene;
                aac.Llo.add(aav);
            }
            aVar.iLN = aac;
            aVar.iLO = new aad();
            h.INSTANCE.idkeyStat(859, 15, 1, false);
            com.tencent.mm.ak.d aXF = aVar.aXF();
            AnonymousClass1 r1 = new WepkgRunCgi.a() {
                /* class com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater.WepkgNetSceneProcessTask.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi.a
                public final void a(int i2, int i3, String str, com.tencent.mm.ak.d dVar) {
                    AppMethodBeat.i(110827);
                    if (i2 == 0 && i3 == 0 && dVar.iLL.iLR != null) {
                        try {
                            final aad aad = (aad) dVar.iLL.iLR;
                            com.tencent.mm.plugin.wepkg.utils.d.cyh().postToWorker(new Runnable() {
                                /* class com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater.WepkgNetSceneProcessTask.AnonymousClass1.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(110826);
                                    aad aad = aad;
                                    int i2 = WepkgNetSceneProcessTask.this.eij;
                                    boolean z = WepkgNetSceneProcessTask.this.JOt;
                                    if (aad != null) {
                                        if (Util.isNullOrNil(aad.Llp)) {
                                            Log.e("MicroMsg.Wepkg.WepkgManager", "response.PkgList.size() is empty");
                                            AppMethodBeat.o(110826);
                                            return;
                                        }
                                        HashSet hashSet = new HashSet();
                                        ArrayList<dbq> arrayList = new ArrayList();
                                        Iterator<dbq> it = aad.Llp.iterator();
                                        while (it.hasNext()) {
                                            dbq next = it.next();
                                            if (next != null) {
                                                String str = next.xJD;
                                                fbi fbi = next.MGz;
                                                fbe fbe = next.MGB;
                                                if (!Util.isNullOrNil(str)) {
                                                    if (fbe != null) {
                                                        if (fbe.Nxv) {
                                                            Log.i("MicroMsg.Wepkg.WepkgManager", "wepkg reload now");
                                                            h.INSTANCE.idkeyStat(859, 17, 1, false);
                                                            if (next.MGA != null) {
                                                                ForceUpdateNotify.add(next.xJD);
                                                            }
                                                        }
                                                        if (fbe.Nxu) {
                                                            c.gkN().aH(str, 2, 3);
                                                        }
                                                    }
                                                    if (!(fbi == null || fbi.NxD == null)) {
                                                        if (Util.isNullOrNil(fbi.NxD.Nxw)) {
                                                            WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
                                                            wepkgCrossProcessTask.EX = 2004;
                                                            wepkgCrossProcessTask.JNh.hhD = str;
                                                            if (MMApplicationContext.isMMProcess()) {
                                                                com.tencent.mm.plugin.wepkg.utils.d.cyh().postToWorker(
                                                                /*  JADX ERROR: Method code generation error
                                                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00d2: INVOKE  
                                                                      (wrap: com.tencent.mm.sdk.platformtools.MMHandler : 0x00c9: INVOKE  (r3v25 com.tencent.mm.sdk.platformtools.MMHandler) =  type: STATIC call: com.tencent.mm.plugin.wepkg.utils.d.cyh():com.tencent.mm.sdk.platformtools.MMHandler)
                                                                      (wrap: com.tencent.mm.plugin.wepkg.model.j$6 : 0x00cf: CONSTRUCTOR  (r4v14 com.tencent.mm.plugin.wepkg.model.j$6) = (r2v17 'wepkgCrossProcessTask' com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask) call: com.tencent.mm.plugin.wepkg.model.j.6.<init>(com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask):void type: CONSTRUCTOR)
                                                                     type: VIRTUAL call: com.tencent.mm.sdk.platformtools.MMHandler.postToWorker(java.lang.Runnable):boolean in method: com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater.WepkgNetSceneProcessTask.1.1.run():void, file: classes6.dex
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
                                                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                                                    	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:239)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:67)
                                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
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
                                                                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00cf: CONSTRUCTOR  (r4v14 com.tencent.mm.plugin.wepkg.model.j$6) = (r2v17 'wepkgCrossProcessTask' com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask) call: com.tencent.mm.plugin.wepkg.model.j.6.<init>(com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater.WepkgNetSceneProcessTask.1.1.run():void, file: classes6.dex
                                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                                    	... 53 more
                                                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.wepkg.model.j, state: GENERATED_AND_UNLOADED
                                                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                                    	... 59 more
                                                                    */
                                                                /*
                                                                // Method dump skipped, instructions count: 564
                                                                */
                                                                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater.WepkgNetSceneProcessTask.AnonymousClass1.AnonymousClass1.run():void");
                                                            }
                                                        });
                                                        AppMethodBeat.o(110827);
                                                    } catch (Exception e2) {
                                                        Log.e("MicroMsg.Wepkg.WepkgVersionUpdater", "get checkwepkgversion error");
                                                        AppMethodBeat.o(110827);
                                                    }
                                                } else {
                                                    Log.e("MicroMsg.Wepkg.WepkgVersionUpdater", "check wepkg version, cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(i2), Integer.valueOf(i3), str, dVar.iLL.iLR);
                                                    h.INSTANCE.idkeyStat(859, 16, 1, false);
                                                    AppMethodBeat.o(110827);
                                                }
                                            }
                                        };
                                        if (MMApplicationContext.isMMProcess()) {
                                            aa.a(aXF, 
                                            /*  JADX ERROR: Method code generation error
                                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0081: INVOKE  
                                                  (r0v7 'aXF' com.tencent.mm.ak.d)
                                                  (wrap: com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi$1 : 0x007e: CONSTRUCTOR  (r2v4 com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi$1) = (r1v2 'r1' com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater$WepkgNetSceneProcessTask$1) call: com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi.1.<init>(com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi$a):void type: CONSTRUCTOR)
                                                 type: STATIC call: com.tencent.mm.ak.aa.a(com.tencent.mm.ak.d, com.tencent.mm.ak.aa$a):com.tencent.mm.ak.d in method: com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater.WepkgNetSceneProcessTask.bjj():void, file: classes6.dex
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
                                                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x007e: CONSTRUCTOR  (r2v4 com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi$1) = (r1v2 'r1' com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater$WepkgNetSceneProcessTask$1) call: com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi.1.<init>(com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi$a):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater.WepkgNetSceneProcessTask.bjj():void, file: classes6.dex
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                                	... 25 more
                                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi, state: GENERATED_AND_UNLOADED
                                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                                	... 31 more
                                                */
                                            /*
                                            // Method dump skipped, instructions count: 159
                                            */
                                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater.WepkgNetSceneProcessTask.bjj():void");
                                        }

                                        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
                                        public final void bjk() {
                                        }

                                        @Override // com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask
                                        public final void p(Parcel parcel) {
                                            AppMethodBeat.i(110836);
                                            if (this.JOs == null) {
                                                this.JOs = new ArrayList();
                                            }
                                            parcel.readList(this.JOs, WepkgCheckReq.class.getClassLoader());
                                            this.eij = parcel.readInt();
                                            this.JOt = parcel.readByte() != 0;
                                            AppMethodBeat.o(110836);
                                        }

                                        @Override // com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask
                                        public final void a(Parcel parcel, int i2) {
                                            AppMethodBeat.i(110837);
                                            parcel.writeList(this.JOs);
                                            parcel.writeInt(this.eij);
                                            parcel.writeByte((byte) (this.JOt ? 1 : 0));
                                            AppMethodBeat.o(110837);
                                        }

                                        static {
                                            AppMethodBeat.i(110838);
                                            AppMethodBeat.o(110838);
                                        }

                                        /* access modifiers changed from: package-private */
                                        public static class WepkgCheckReq implements Parcelable {
                                            public static final Parcelable.Creator<WepkgCheckReq> CREATOR = new Parcelable.Creator<WepkgCheckReq>() {
                                                /* class com.tencent.mm.plugin.wepkg.version.WepkgVersionUpdater.WepkgNetSceneProcessTask.WepkgCheckReq.AnonymousClass1 */

                                                /* Return type fixed from 'java.lang.Object[]' to match base method */
                                                @Override // android.os.Parcelable.Creator
                                                public final /* bridge */ /* synthetic */ WepkgCheckReq[] newArray(int i2) {
                                                    return new WepkgCheckReq[i2];
                                                }

                                                /* Return type fixed from 'java.lang.Object' to match base method */
                                                @Override // android.os.Parcelable.Creator
                                                public final /* synthetic */ WepkgCheckReq createFromParcel(Parcel parcel) {
                                                    AppMethodBeat.i(110829);
                                                    WepkgCheckReq wepkgCheckReq = new WepkgCheckReq(parcel, (byte) 0);
                                                    AppMethodBeat.o(110829);
                                                    return wepkgCheckReq;
                                                }
                                            };
                                            private String hhD;
                                            private int scene;
                                            private String version;

                                            /* synthetic */ WepkgCheckReq(byte b2) {
                                                this();
                                            }

                                            /* synthetic */ WepkgCheckReq(Parcel parcel, byte b2) {
                                                this(parcel);
                                            }

                                            private WepkgCheckReq() {
                                            }

                                            private WepkgCheckReq(Parcel parcel) {
                                                AppMethodBeat.i(110830);
                                                this.hhD = parcel.readString();
                                                this.version = parcel.readString();
                                                this.scene = parcel.readInt();
                                                AppMethodBeat.o(110830);
                                            }

                                            public int describeContents() {
                                                return 0;
                                            }

                                            public void writeToParcel(Parcel parcel, int i2) {
                                                AppMethodBeat.i(110831);
                                                parcel.writeString(this.hhD);
                                                parcel.writeString(this.version);
                                                parcel.writeInt(this.scene);
                                                AppMethodBeat.o(110831);
                                            }

                                            static {
                                                AppMethodBeat.i(110832);
                                                AppMethodBeat.o(110832);
                                            }
                                        }
                                    }
                                }
