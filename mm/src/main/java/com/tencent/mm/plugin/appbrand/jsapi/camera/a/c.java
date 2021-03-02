package com.tencent.mm.plugin.appbrand.jsapi.camera.a;

import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.qbar.QbarNative;

public abstract class c {
    private boolean dLD = false;
    public a lQL;

    public interface a {
        void a(int i2, int i3, String str, byte[] bArr, QbarNative.QBarPoint qBarPoint);
    }

    /* access modifiers changed from: protected */
    public abstract b bGb();

    public final void init() {
        bGb().init();
    }

    public final void release() {
        bGb().release();
    }

    public final void b(byte[] bArr, int i2, int i3, int i4, int i5, Point point, Rect rect, int i6, int i7) {
        if (!this.dLD) {
            b bGb = bGb();
            if (bArr != null) {
                bGb.lQu.postToWorker(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0021: INVOKE  
                      (wrap: com.tencent.mm.sdk.platformtools.MMHandler : 0x000b: IGET  (r11v0 com.tencent.mm.sdk.platformtools.MMHandler) = (r1v0 'bGb' com.tencent.mm.plugin.appbrand.jsapi.camera.a.b) com.tencent.mm.plugin.appbrand.jsapi.camera.a.b.lQu com.tencent.mm.sdk.platformtools.MMHandler)
                      (wrap: com.tencent.mm.plugin.appbrand.jsapi.camera.a.b$1 : 0x001e: CONSTRUCTOR  (r0v1 com.tencent.mm.plugin.appbrand.jsapi.camera.a.b$1) = 
                      (r1v0 'bGb' com.tencent.mm.plugin.appbrand.jsapi.camera.a.b)
                      (r13v0 'bArr' byte[])
                      (r20v0 'i6' int)
                      (r14v0 'i2' int)
                      (r15v0 'i3' int)
                      (r16v0 'i4' int)
                      (r17v0 'i5' int)
                      (r18v0 'point' android.graphics.Point)
                      (r19v0 'rect' android.graphics.Rect)
                      (r21v0 'i7' int)
                     call: com.tencent.mm.plugin.appbrand.jsapi.camera.a.b.1.<init>(com.tencent.mm.plugin.appbrand.jsapi.camera.a.b, byte[], int, int, int, int, int, android.graphics.Point, android.graphics.Rect, int):void type: CONSTRUCTOR)
                     type: VIRTUAL call: com.tencent.mm.sdk.platformtools.MMHandler.postToWorker(java.lang.Runnable):boolean in method: com.tencent.mm.plugin.appbrand.jsapi.camera.a.c.b(byte[], int, int, int, int, android.graphics.Point, android.graphics.Rect, int, int):void, file: classes7.dex
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
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001e: CONSTRUCTOR  (r0v1 com.tencent.mm.plugin.appbrand.jsapi.camera.a.b$1) = 
                      (r1v0 'bGb' com.tencent.mm.plugin.appbrand.jsapi.camera.a.b)
                      (r13v0 'bArr' byte[])
                      (r20v0 'i6' int)
                      (r14v0 'i2' int)
                      (r15v0 'i3' int)
                      (r16v0 'i4' int)
                      (r17v0 'i5' int)
                      (r18v0 'point' android.graphics.Point)
                      (r19v0 'rect' android.graphics.Rect)
                      (r21v0 'i7' int)
                     call: com.tencent.mm.plugin.appbrand.jsapi.camera.a.b.1.<init>(com.tencent.mm.plugin.appbrand.jsapi.camera.a.b, byte[], int, int, int, int, int, android.graphics.Point, android.graphics.Rect, int):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.appbrand.jsapi.camera.a.c.b(byte[], int, int, int, int, android.graphics.Point, android.graphics.Rect, int, int):void, file: classes7.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 28 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.appbrand.jsapi.camera.a.b, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 34 more
                    */
                /*
                    this = this;
                    boolean r0 = r12.dLD
                    if (r0 == 0) goto L_0x0005
                L_0x0004:
                    return
                L_0x0005:
                    com.tencent.mm.plugin.appbrand.jsapi.camera.a.b r1 = r12.bGb()
                    if (r13 == 0) goto L_0x0004
                    com.tencent.mm.sdk.platformtools.MMHandler r11 = r1.lQu
                    com.tencent.mm.plugin.appbrand.jsapi.camera.a.b$1 r0 = new com.tencent.mm.plugin.appbrand.jsapi.camera.a.b$1
                    r2 = r13
                    r3 = r20
                    r4 = r14
                    r5 = r15
                    r6 = r16
                    r7 = r17
                    r8 = r18
                    r9 = r19
                    r10 = r21
                    r0.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
                    r11.postToWorker(r0)
                    goto L_0x0004
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.camera.a.c.b(byte[], int, int, int, int, android.graphics.Point, android.graphics.Rect, int, int):void");
            }
        }
