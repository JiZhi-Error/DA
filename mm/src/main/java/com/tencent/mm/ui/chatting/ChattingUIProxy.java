package com.tencent.mm.ui.chatting;

import android.os.SystemClock;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.i;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.IChattingUIProxy;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import java.util.Iterator;
import java.util.List;

public class ChattingUIProxy implements IChattingUIProxy {
    private MMFragmentActivity Dpx;
    private BaseChattingUIFragment OJN;
    private int PjA = -1;
    public boolean isInit = false;

    public ChattingUIProxy(MMFragmentActivity mMFragmentActivity, BaseChattingUIFragment baseChattingUIFragment) {
        this.OJN = baseChattingUIFragment;
        this.Dpx = mMFragmentActivity;
    }

    @Override // com.tencent.mm.ui.IChattingUIProxy
    public void onInit(int i2, boolean z) {
        boolean z2;
        AppMethodBeat.i(34785);
        if (z) {
            ai.gOk().PjZ = 4;
        }
        this.isInit = true;
        this.OJN.PeC = true;
        List<Fragment> fragments = this.Dpx.getSupportFragmentManager().getFragments();
        if (fragments == null) {
            Log.i("MicroMsg.ChattingUIProxy", "fragments is null");
        } else if (fragments.size() >= 5) {
            Log.e("MicroMsg.ChattingUIProxy", "fragments more than 5! %s", Integer.valueOf(fragments.size()));
            Iterator<Fragment> it = fragments.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next() instanceof ChattingUIFragment) {
                        Log.e("MicroMsg.ChattingUIProxy", "fragments more than 5 and find a ChattingUIFragment!!");
                        z2 = false;
                        break;
                    }
                } else {
                    break;
                }
            }
        } else {
            Log.i("MicroMsg.ChattingUIProxy", "fragments size %s", Integer.valueOf(fragments.size()));
        }
        z2 = true;
        Log.i("MicroMsg.ChattingUIProxy", "[onInit] isPreload：%s ok:%s", Boolean.valueOf(z), Boolean.valueOf(z2));
        if (z2) {
            this.Dpx.getSupportFragmentManager().beginTransaction().a(i2, this.OJN).commitAllowingStateLoss();
            this.Dpx.getSupportFragmentManager().executePendingTransactions();
        } else {
            this.Dpx.getSupportFragmentManager().beginTransaction().b(i2, this.OJN).commitAllowingStateLoss();
        }
        if (z) {
            onExitBegin();
            onExitEnd();
        }
        this.OJN.PeC = false;
        AppMethodBeat.o(34785);
    }

    @Override // com.tencent.mm.ui.IChattingUIProxy
    public void onEnterBegin() {
        AppMethodBeat.i(34786);
        Log.i("MicroMsg.ChattingUIProxy", "[onEnterBegin]");
        i iVar = i.CyW;
        iVar.Czc = SystemClock.uptimeMillis();
        iVar.tN(false);
        if (iVar.daF != null) {
            iVar.daF.a(iVar.Czf);
        }
        this.OJN.gMW();
        this.OJN.onEnterBegin();
        this.OJN.gMX();
        if (this.PjA != -1 && (this.Dpx instanceof MMActivity)) {
            this.OJN.getController().setStatusBarColor(this.PjA);
        }
        AppMethodBeat.o(34786);
    }

    @Override // com.tencent.mm.ui.IChattingUIProxy
    public void onEnterEnd() {
        AppMethodBeat.i(34787);
        Log.i("MicroMsg.ChattingUIProxy", "[onEnterEnd]");
        if (this.OJN.amb(256)) {
            this.OJN.gMY();
            this.OJN.onEnterEnd();
        }
        i iVar = i.CyW;
        iVar.Czc = SystemClock.uptimeMillis() - iVar.Czc;
        Log.i("MicroMsg.SceneFpsReportService", "[onChattingEnterEnd] enterChattingDuration=" + iVar.Czc + LocaleUtil.MALAY);
        iVar.Cze[iVar.Czb % 20] = iVar.Czc;
        long[] jArr = iVar.Cze;
        jArr[20] = jArr[20] + iVar.Czc;
        iVar.Czb++;
        if (iVar.daF == null) {
            AppMethodBeat.o(34787);
            return;
        }
        iVar.mainHandler.post(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0077: INVOKE  
              (wrap: com.tencent.mm.sdk.platformtools.MMHandler : 0x0070: IGET  (r1v8 com.tencent.mm.sdk.platformtools.MMHandler) = (r0v3 'iVar' com.tencent.mm.plugin.report.service.i) com.tencent.mm.plugin.report.service.i.mainHandler com.tencent.mm.sdk.platformtools.MMHandler)
              (wrap: com.tencent.mm.plugin.report.service.i$2 : 0x0074: CONSTRUCTOR  (r2v9 com.tencent.mm.plugin.report.service.i$2) = (r0v3 'iVar' com.tencent.mm.plugin.report.service.i) call: com.tencent.mm.plugin.report.service.i.2.<init>(com.tencent.mm.plugin.report.service.i):void type: CONSTRUCTOR)
             type: VIRTUAL call: com.tencent.mm.sdk.platformtools.MMHandler.post(java.lang.Runnable):boolean in method: com.tencent.mm.ui.chatting.ChattingUIProxy.onEnterEnd():void, file: classes5.dex
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
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0074: CONSTRUCTOR  (r2v9 com.tencent.mm.plugin.report.service.i$2) = (r0v3 'iVar' com.tencent.mm.plugin.report.service.i) call: com.tencent.mm.plugin.report.service.i.2.<init>(com.tencent.mm.plugin.report.service.i):void type: CONSTRUCTOR in method: com.tencent.mm.ui.chatting.ChattingUIProxy.onEnterEnd():void, file: classes5.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 18 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.report.service.i, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 24 more
            */
        /*
        // Method dump skipped, instructions count: 126
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.ChattingUIProxy.onEnterEnd():void");
    }

    @Override // com.tencent.mm.ui.IChattingUIProxy
    public void onExitBegin() {
        AppMethodBeat.i(34788);
        Log.i("MicroMsg.ChattingUIProxy", "[onExitBegin]");
        if (!this.OJN.gNe()) {
            this.OJN.onExitBegin();
        }
        if (this.Dpx instanceof MMActivity) {
            this.PjA = this.OJN.getController().statusBarColor;
        }
        AppMethodBeat.o(34788);
    }

    @Override // com.tencent.mm.ui.IChattingUIProxy
    public void onExitEnd() {
        AppMethodBeat.i(34789);
        Log.i("MicroMsg.ChattingUIProxy", "[onExitEnd]");
        this.OJN.gMZ();
        this.OJN.gNa();
        this.OJN.gNb();
        this.OJN.onExitEnd();
        AppMethodBeat.o(34789);
    }
}
