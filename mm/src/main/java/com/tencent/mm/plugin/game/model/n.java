package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.dsd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class n implements i {
    private static MMHandler handler;
    private static boolean isRunning = false;
    private static int xER = 20;
    private static LinkedList<i> xES = new LinkedList<>();
    private int offset = 0;

    static /* synthetic */ void b(n nVar) {
        AppMethodBeat.i(41448);
        nVar.dVk();
        AppMethodBeat.o(41448);
    }

    static {
        AppMethodBeat.i(41449);
        AppMethodBeat.o(41449);
    }

    public static void update() {
        AppMethodBeat.i(41445);
        if (!e.dUY()) {
            Log.i("MicroMsg.GameListUpdater", "No need to update");
            AppMethodBeat.o(41445);
        } else if (isRunning) {
            Log.e("MicroMsg.GameListUpdater", "Already running");
            AppMethodBeat.o(41445);
        } else {
            handler = new MMHandler("GameListUpdate");
            xES.clear();
            n nVar = new n();
            g.azz().a(1215, nVar);
            g.azz().a(new at(nVar.offset, xER), 0);
            isRunning = true;
            AppMethodBeat.o(41445);
        }
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, final q qVar) {
        AppMethodBeat.i(41446);
        if (i2 == 0 && i3 == 0) {
            handler.post(new Runnable() {
                /* class com.tencent.mm.plugin.game.model.n.AnonymousClass1 */

                public final void run() {
                    String str;
                    AppMethodBeat.i(41444);
                    n.this.offset += n.xER;
                    dsd dsd = (dsd) ((at) qVar).hhm.iLL.iLR;
                    if (dsd == null) {
                        Log.e("MicroMsg.NetSceneSearchGameList", "resp == null");
                        str = null;
                    } else {
                        str = dsd.xuE;
                    }
                    i iVar = new i(str);
                    iVar.dVh();
                    n.xES.add(iVar);
                    int optInt = iVar.xEH.optInt("remainingCount");
                    Log.i("MicroMsg.GameListUpdater", "remainingCount: %d", Integer.valueOf(optInt));
                    if (optInt > 0) {
                        g.azz().a(new at(n.this.offset, n.xER), 0);
                        AppMethodBeat.o(41444);
                        return;
                    }
                    n.b(n.this);
                    e.dUZ();
                    LinkedList linkedList = n.xES;
                    if (!Util.isNullOrNil(linkedList)) {
                        g.aAk().postToWorker(
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0093: INVOKE  
                              (wrap: com.tencent.mm.sdk.platformtools.MMHandlerThread : 0x008a: INVOKE  (r1v7 com.tencent.mm.sdk.platformtools.MMHandlerThread) =  type: STATIC call: com.tencent.mm.kernel.g.aAk():com.tencent.mm.sdk.platformtools.MMHandlerThread)
                              (wrap: com.tencent.mm.plugin.game.model.i$1 : 0x0090: CONSTRUCTOR  (r2v2 com.tencent.mm.plugin.game.model.i$1) = (r0v13 'linkedList' java.util.LinkedList) call: com.tencent.mm.plugin.game.model.i.1.<init>(java.util.LinkedList):void type: CONSTRUCTOR)
                             type: VIRTUAL call: com.tencent.mm.sdk.platformtools.MMHandlerThread.postToWorker(java.lang.Runnable):int in method: com.tencent.mm.plugin.game.model.n.1.run():void, file: classes6.dex
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
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.util.ArrayList.forEach(ArrayList.java:1259)
                            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0090: CONSTRUCTOR  (r2v2 com.tencent.mm.plugin.game.model.i$1) = (r0v13 'linkedList' java.util.LinkedList) call: com.tencent.mm.plugin.game.model.i.1.<init>(java.util.LinkedList):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.game.model.n.1.run():void, file: classes6.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 23 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.game.model.i, state: GENERATED_AND_UNLOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 29 more
                            */
                        /*
                        // Method dump skipped, instructions count: 154
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.model.n.AnonymousClass1.run():void");
                    }
                });
                AppMethodBeat.o(41446);
                return;
            }
            dVk();
            AppMethodBeat.o(41446);
        }

        private void dVk() {
            AppMethodBeat.i(41447);
            isRunning = false;
            handler.quit();
            g.azz().b(1215, this);
            AppMethodBeat.o(41447);
        }
    }
