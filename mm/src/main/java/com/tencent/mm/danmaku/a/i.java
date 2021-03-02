package com.tencent.mm.danmaku.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.d.a;
import com.tencent.mm.danmaku.d.c;
import com.tencent.mm.danmaku.d.g;
import com.tencent.mm.danmaku.d.h;
import com.tencent.mm.danmaku.e.e;
import com.tencent.mm.danmaku.f.b;
import java.lang.ref.WeakReference;
import java.util.Iterator;

public final class i {
    HandlerThread gOA;
    private a gOB;
    int gOC = 0;
    Boolean gOu = Boolean.FALSE;
    Handler gOz;

    public i(d dVar) {
        AppMethodBeat.i(241663);
        this.gOB = new a(dVar, (byte) 0);
        AppMethodBeat.o(241663);
    }

    /* access modifiers changed from: protected */
    public final void asp() {
        AppMethodBeat.i(241664);
        if (this.gOz != null) {
            this.gOz.removeMessages(4);
        }
        AppMethodBeat.o(241664);
    }

    /* access modifiers changed from: protected */
    public final void sendMessage(int i2) {
        AppMethodBeat.i(241665);
        Message obtain = Message.obtain();
        obtain.what = i2;
        sendMessage(obtain);
        AppMethodBeat.o(241665);
    }

    /* access modifiers changed from: package-private */
    public final void sendMessage(Message message) {
        AppMethodBeat.i(241666);
        if (asr()) {
            this.gOz.sendMessage(message);
        }
        AppMethodBeat.o(241666);
    }

    /* access modifiers changed from: protected */
    public final void asq() {
        AppMethodBeat.i(241667);
        if (asr()) {
            this.gOz.removeMessages(4);
            this.gOz.sendEmptyMessage(4);
        }
        AppMethodBeat.o(241667);
    }

    /* access modifiers changed from: package-private */
    public final boolean asr() {
        AppMethodBeat.i(241668);
        if (ass()) {
            if (this.gOz != null) {
                AppMethodBeat.o(241668);
                return true;
            }
            AppMethodBeat.o(241668);
            return false;
        } else if (this.gOA == null || !this.gOA.isAlive() || this.gOz == null) {
            AppMethodBeat.o(241668);
            return false;
        } else {
            AppMethodBeat.o(241668);
            return true;
        }
    }

    private boolean ass() {
        return this.gOC == 1;
    }

    static class a implements Handler.Callback {
        private WeakReference<d> gOD;

        /* synthetic */ a(d dVar, byte b2) {
            this(dVar);
        }

        private a(d dVar) {
            AppMethodBeat.i(241661);
            this.gOD = new WeakReference<>(dVar);
            AppMethodBeat.o(241661);
        }

        public final boolean handleMessage(Message message) {
            T t;
            AppMethodBeat.i(241662);
            d dVar = this.gOD.get();
            if (dVar == null) {
                AppMethodBeat.o(241662);
            } else {
                switch (message.what) {
                    case 1:
                        dVar.gNB = false;
                        dVar.gNK = true;
                        if (message.obj != null) {
                            dVar.gNJ = ((Long) message.obj).longValue();
                        } else {
                            dVar.gNJ = 0;
                        }
                        dVar.gNP = 0;
                        dVar.gNQ = 0;
                        dVar.gNR = 0;
                        dVar.gNw.gNI = SystemClock.uptimeMillis();
                        c cVar = dVar.gNw;
                        cVar.gQv = 0;
                        cVar.gQw = 0;
                        if (e.gQV >= 3) {
                            e.i("DanmakuManager", "message start:startTime:", Long.valueOf(dVar.gNJ));
                        }
                        dVar.asb();
                        break;
                    case 2:
                        dVar.asb();
                        break;
                    case 3:
                        dVar.asf();
                        break;
                    case 4:
                        dVar.ase();
                        break;
                    case 5:
                        dVar.i(message);
                        break;
                    case 6:
                        e.i("DanmakuManager", "handleQuit()");
                        dVar.gNB = true;
                        dVar.gNt.gPo.atl();
                        dVar.gNF.clear();
                        com.tencent.mm.danmaku.d.a aVar = dVar.gNu.gNx;
                        Iterator<a.C0312a> it = aVar.gQm.iterator();
                        while (it.hasNext()) {
                            a.C0312a next = it.next();
                            if (next != null) {
                                next.destroy();
                            }
                        }
                        aVar.gQm.clear();
                        aVar.gQp = 0;
                        aVar.gQq = 0;
                        aVar.gQr = 0;
                        e.i("DanmakuManager", "message quit");
                        break;
                    case 7:
                        e.i("DanmakuManager", "handleConfigChanged()");
                        dVar.gNZ.arP();
                        e eVar = dVar.gNF;
                        eVar.asm();
                        g<com.tencent.mm.danmaku.b.a> gVar = eVar.gOl;
                        g.a<T> aVar2 = gVar.gQB.gQE;
                        if (aVar2 != gVar.gQB) {
                            t = aVar2.mData;
                        } else {
                            t = null;
                        }
                        T t2 = t;
                        if (t2 == null) {
                            eVar.gOn = -1;
                        } else {
                            eVar.gOn = t2.getTime();
                        }
                        eVar.asn();
                        e.i("DanmakuManager", "message config changed");
                        break;
                    case 8:
                        e.i("DanmakuManager", "handleRelease()");
                        i iVar = dVar.gOc;
                        if (iVar.gOA != null && !iVar.gOu.booleanValue()) {
                            if (com.tencent.mm.danmaku.e.c.atm()) {
                                iVar.gOA.quitSafely();
                            } else {
                                iVar.gOA.quit();
                            }
                        }
                        iVar.gOA = null;
                        h hVar = dVar.gNH;
                        if (hVar.gOs != null && hVar.gOs.isAlive()) {
                            if (!hVar.gOu.booleanValue()) {
                                if (com.tencent.mm.danmaku.e.c.atm()) {
                                    hVar.gOs.quitSafely();
                                } else {
                                    hVar.gOs.quit();
                                }
                            }
                            hVar.gOs = null;
                        }
                        b bVar = dVar.gNu;
                        if (bVar.gNy != null && bVar.gNy.isAlive()) {
                            if (!com.tencent.mm.danmaku.e.c.atm()) {
                                bVar.gNy.quit();
                                break;
                            } else {
                                bVar.gNy.quitSafely();
                                break;
                            }
                        }
                    case 9:
                        e.i("DanmakuManager", "handleClear()");
                        dVar.gNZ.arQ();
                        dVar.gNt.gPo.atl();
                        dVar.gNF.clear();
                        break;
                    case 10:
                        if (dVar.gOa != null) {
                            while (!dVar.gNX.isEmpty()) {
                                h poll = dVar.gNX.poll();
                                com.tencent.mm.danmaku.b.a a2 = dVar.gNZ.a(poll);
                                if (e.gQV >= 4) {
                                    e.v("DanmakuManager", "handleClick:", poll, ",currentTime:", Long.valueOf(SystemClock.uptimeMillis()));
                                }
                                b.post(
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x01d8: INVOKE  
                                      (wrap: com.tencent.mm.danmaku.a.d$2 : 0x01d5: CONSTRUCTOR  (r3v1 com.tencent.mm.danmaku.a.d$2) = 
                                      (r0v2 'dVar' com.tencent.mm.danmaku.a.d)
                                      (r2v2 'a2' com.tencent.mm.danmaku.b.a)
                                      (r1v7 'poll' com.tencent.mm.danmaku.d.h)
                                     call: com.tencent.mm.danmaku.a.d.2.<init>(com.tencent.mm.danmaku.a.d, com.tencent.mm.danmaku.b.a, com.tencent.mm.danmaku.d.h):void type: CONSTRUCTOR)
                                     type: STATIC call: com.tencent.mm.danmaku.f.b.post(java.lang.Runnable):void in method: com.tencent.mm.danmaku.a.i.a.handleMessage(android.os.Message):boolean, file: classes9.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                    	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:239)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:67)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                    	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:274)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
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
                                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x01d5: CONSTRUCTOR  (r3v1 com.tencent.mm.danmaku.a.d$2) = 
                                      (r0v2 'dVar' com.tencent.mm.danmaku.a.d)
                                      (r2v2 'a2' com.tencent.mm.danmaku.b.a)
                                      (r1v7 'poll' com.tencent.mm.danmaku.d.h)
                                     call: com.tencent.mm.danmaku.a.d.2.<init>(com.tencent.mm.danmaku.a.d, com.tencent.mm.danmaku.b.a, com.tencent.mm.danmaku.d.h):void type: CONSTRUCTOR in method: com.tencent.mm.danmaku.a.i.a.handleMessage(android.os.Message):boolean, file: classes9.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                    	... 34 more
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.danmaku.a.d, state: GENERATED_AND_UNLOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                    	... 40 more
                                    */
                                /*
                                // Method dump skipped, instructions count: 526
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.danmaku.a.i.a.handleMessage(android.os.Message):boolean");
                            }
                        }
                    }
