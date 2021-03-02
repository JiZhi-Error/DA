package com.tencent.mm.danmaku.a;

import android.graphics.Point;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.a.d;
import com.tencent.mm.danmaku.e.c;
import com.tencent.mm.danmaku.e.e;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class g implements View.OnTouchListener {
    private d gOr;

    public interface b {
    }

    public g(View view, com.tencent.mm.danmaku.c.a aVar) {
        AppMethodBeat.i(241645);
        this.gOr = new d(view, aVar);
        AppMethodBeat.o(241645);
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.i(241646);
        boolean onTouch = this.gOr.onTouch(view, motionEvent);
        AppMethodBeat.o(241646);
        return onTouch;
    }

    public final void c(Point point) {
        AppMethodBeat.i(241647);
        this.gOr.c(point);
        AppMethodBeat.o(241647);
    }

    public final void resume() {
        AppMethodBeat.i(241648);
        this.gOr.resume();
        AppMethodBeat.o(241648);
    }

    public final void pause() {
        AppMethodBeat.i(241649);
        this.gOr.pause();
        AppMethodBeat.o(241649);
    }

    public final void seek(long j2) {
        AppMethodBeat.i(241650);
        d dVar = this.gOr;
        e.v("DanmakuManager", "seek(): postime = ".concat(String.valueOf(j2)));
        i iVar = dVar.gOc;
        Long valueOf = Long.valueOf(j2);
        Message obtain = Message.obtain();
        obtain.what = 5;
        obtain.obj = valueOf;
        iVar.sendMessage(obtain);
        AppMethodBeat.o(241650);
    }

    public final void clear() {
        AppMethodBeat.i(241651);
        this.gOr.clear();
        AppMethodBeat.o(241651);
    }

    public final void release() {
        AppMethodBeat.i(241652);
        this.gOr.release();
        AppMethodBeat.o(241652);
    }

    public final boolean isPlaying() {
        AppMethodBeat.i(241653);
        boolean isPlaying = this.gOr.isPlaying();
        AppMethodBeat.o(241653);
        return isPlaying;
    }

    public static final class a implements Serializable, Comparator<com.tencent.mm.danmaku.b.a> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(com.tencent.mm.danmaku.b.a aVar, com.tencent.mm.danmaku.b.a aVar2) {
            AppMethodBeat.i(241644);
            int a2 = c.a(aVar, aVar2);
            AppMethodBeat.o(241644);
            return a2;
        }
    }

    public final void d(com.tencent.mm.danmaku.b.a aVar) {
        AppMethodBeat.i(241654);
        d dVar = this.gOr;
        aVar.setTime(dVar.gNv.gQA);
        h hVar = dVar.gNH;
        d.AnonymousClass3 r2 = 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0013: CONSTRUCTOR  (r2v1 'r2' com.tencent.mm.danmaku.a.d$3) = (r0v0 'dVar' com.tencent.mm.danmaku.a.d) call: com.tencent.mm.danmaku.a.d.3.<init>(com.tencent.mm.danmaku.a.d):void type: CONSTRUCTOR in method: com.tencent.mm.danmaku.a.g.d(com.tencent.mm.danmaku.b.a):void, file: classes9.dex
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
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.danmaku.a.d, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            */
        /*
            this = this;
            r4 = 241654(0x3aff6, float:3.3863E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            com.tencent.mm.danmaku.a.d r0 = r5.gOr
            com.tencent.mm.danmaku.d.f r1 = r0.gNv
            long r2 = r1.gQA
            r6.setTime(r2)
            com.tencent.mm.danmaku.a.h r1 = r0.gNH
            com.tencent.mm.danmaku.a.d$3 r2 = new com.tencent.mm.danmaku.a.d$3
            r2.<init>()
            android.os.Handler r0 = r1.aso()
            if (r0 == 0) goto L_0x0024
            com.tencent.mm.danmaku.a.h$1 r3 = new com.tencent.mm.danmaku.a.h$1
            r3.<init>(r6, r2)
            r0.post(r3)
        L_0x0024:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.danmaku.a.g.d(com.tencent.mm.danmaku.b.a):void");
    }

    public final void ab(List<com.tencent.mm.danmaku.b.a> list) {
        Handler aso;
        AppMethodBeat.i(241655);
        d dVar = this.gOr;
        h hVar = dVar.gNH;
        d.AnonymousClass4 r2 = 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000c: CONSTRUCTOR  (r2v0 'r2' com.tencent.mm.danmaku.a.d$4) = (r0v0 'dVar' com.tencent.mm.danmaku.a.d) call: com.tencent.mm.danmaku.a.d.4.<init>(com.tencent.mm.danmaku.a.d):void type: CONSTRUCTOR in method: com.tencent.mm.danmaku.a.g.ab(java.util.List<com.tencent.mm.danmaku.b.a>):void, file: classes9.dex
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
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.danmaku.a.d, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            */
        /*
            this = this;
            r4 = 241655(0x3aff7, float:3.38631E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            com.tencent.mm.danmaku.a.d r0 = r5.gOr
            com.tencent.mm.danmaku.a.h r1 = r0.gNH
            com.tencent.mm.danmaku.a.d$4 r2 = new com.tencent.mm.danmaku.a.d$4
            r2.<init>()
            boolean r0 = com.tencent.mm.danmaku.f.d.isEmpty(r6)
            if (r0 != 0) goto L_0x0023
            android.os.Handler r0 = r1.aso()
            if (r0 == 0) goto L_0x0023
            com.tencent.mm.danmaku.a.h$2 r3 = new com.tencent.mm.danmaku.a.h$2
            r3.<init>(r6, r2)
            r0.post(r3)
        L_0x0023:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.danmaku.a.g.ab(java.util.List):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public final com.tencent.mm.danmaku.b.a aW(Object obj) {
        AppMethodBeat.i(241656);
        f fVar = this.gOr.gNG;
        BlockingQueue<com.tencent.mm.danmaku.b.a> blockingQueue = fVar.gOp.get(0);
        if (blockingQueue == null) {
            blockingQueue = new LinkedBlockingQueue<>();
        }
        com.tencent.mm.danmaku.b.a poll = blockingQueue.poll();
        if (poll == null) {
            com.tencent.mm.danmaku.c.a aVar = fVar.gNt;
            poll = null;
            if (aVar.gPz != null) {
                poll = aVar.gPz.a(aVar);
            }
            if (poll == null) {
                poll = new com.tencent.mm.danmaku.b.b(aVar);
            }
            e.v("DanmakuFactory", poll, " is created ");
        } else {
            e.v("DanmakuFactory", poll, " is reused ");
        }
        poll.reset();
        if (!c.gNA || obj != 0) {
            poll.mData = obj;
            poll.gPe = true;
            AppMethodBeat.o(241656);
            return poll;
        }
        RuntimeException runtimeException = new RuntimeException("Danmaku data should been null");
        AppMethodBeat.o(241656);
        throw runtimeException;
    }
}
