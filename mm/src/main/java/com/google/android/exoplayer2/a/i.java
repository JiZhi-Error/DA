package com.google.android.exoplayer2.a;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.a.d;
import com.google.android.exoplayer2.a.e;
import com.google.android.exoplayer2.a.f;
import com.google.android.exoplayer2.drm.d;
import com.google.android.exoplayer2.e.b;
import com.google.android.exoplayer2.e.c;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsListener;

@TargetApi(16)
public final class i extends b implements com.google.android.exoplayer2.i.i {
    private MediaFormat bgA;
    private long bgB;
    private boolean bgC;
    private final e.a bgw;
    private final f bgx;
    private boolean bgy;
    private boolean bgz;
    private int channelCount;
    private int pcmEncoding;

    public i(c cVar, com.google.android.exoplayer2.drm.b<d> bVar, Handler handler, e eVar, c cVar2, d... dVarArr) {
        super(1, cVar, bVar, true);
        AppMethodBeat.i(91810);
        this.bgx = new f(cVar2, dVarArr, new a(this, (byte) 0));
        this.bgw = new e.a(handler, eVar);
        AppMethodBeat.o(91810);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0053, code lost:
        if (r2 != false) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0066, code lost:
        if (r2 != false) goto L_0x0068;
     */
    @Override // com.google.android.exoplayer2.e.b
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(com.google.android.exoplayer2.e.c r12, com.google.android.exoplayer2.Format r13) {
        /*
        // Method dump skipped, instructions count: 382
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.a.i.a(com.google.android.exoplayer2.e.c, com.google.android.exoplayer2.Format):int");
    }

    @Override // com.google.android.exoplayer2.e.b
    public final com.google.android.exoplayer2.e.a a(c cVar, Format format, boolean z) {
        com.google.android.exoplayer2.e.a vf;
        AppMethodBeat.i(91812);
        if (!bf(format.bdq) || (vf = cVar.vf()) == null) {
            this.bgy = false;
            com.google.android.exoplayer2.e.a a2 = super.a(cVar, format, z);
            AppMethodBeat.o(91812);
            return a2;
        }
        this.bgy = true;
        AppMethodBeat.o(91812);
        return vf;
    }

    private boolean bf(String str) {
        AppMethodBeat.i(91813);
        boolean bd = this.bgx.bd(str);
        AppMethodBeat.o(91813);
        return bd;
    }

    @Override // com.google.android.exoplayer2.e.b
    public final void a(com.google.android.exoplayer2.e.a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        boolean z;
        AppMethodBeat.i(91814);
        String str = aVar.name;
        if (x.SDK_INT >= 24 || !"OMX.SEC.aac.dec".equals(str) || !"samsung".equals(x.MANUFACTURER) || (!x.DEVICE.startsWith("zeroflte") && !x.DEVICE.startsWith("herolte") && !x.DEVICE.startsWith("heroqlte"))) {
            z = false;
        } else {
            z = true;
        }
        this.bgz = z;
        if (this.bgy) {
            this.bgA = format.tw();
            this.bgA.setString("mime", "audio/raw");
            mediaCodec.configure(this.bgA, (Surface) null, mediaCrypto, 0);
            this.bgA.setString("mime", format.bdq);
            AppMethodBeat.o(91814);
            return;
        }
        mediaCodec.configure(format.tw(), (Surface) null, mediaCrypto, 0);
        this.bgA = null;
        AppMethodBeat.o(91814);
    }

    @Override // com.google.android.exoplayer2.a, com.google.android.exoplayer2.r
    public final com.google.android.exoplayer2.i.i sX() {
        return this;
    }

    @Override // com.google.android.exoplayer2.e.b
    public final void d(String str, long j2, long j3) {
        AppMethodBeat.i(91815);
        e.a aVar = this.bgw;
        if (aVar.beP != null) {
            aVar.handler.post(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0016: INVOKE  
                  (wrap: android.os.Handler : 0x000c: IGET  (r0v1 android.os.Handler) = (r2v0 'aVar' com.google.android.exoplayer2.a.e$a) com.google.android.exoplayer2.a.e.a.handler android.os.Handler)
                  (wrap: com.google.android.exoplayer2.a.e$a$2 : 0x0013: CONSTRUCTOR  (r1v0 com.google.android.exoplayer2.a.e$a$2) = (r2v0 'aVar' com.google.android.exoplayer2.a.e$a), (r11v0 'str' java.lang.String), (r12v0 'j2' long), (r14v0 'j3' long) call: com.google.android.exoplayer2.a.e.a.2.<init>(com.google.android.exoplayer2.a.e$a, java.lang.String, long, long):void type: CONSTRUCTOR)
                 type: VIRTUAL call: android.os.Handler.post(java.lang.Runnable):boolean in method: com.google.android.exoplayer2.a.i.d(java.lang.String, long, long):void, file: classes8.dex
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
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0013: CONSTRUCTOR  (r1v0 com.google.android.exoplayer2.a.e$a$2) = (r2v0 'aVar' com.google.android.exoplayer2.a.e$a), (r11v0 'str' java.lang.String), (r12v0 'j2' long), (r14v0 'j3' long) call: com.google.android.exoplayer2.a.e.a.2.<init>(com.google.android.exoplayer2.a.e$a, java.lang.String, long, long):void type: CONSTRUCTOR in method: com.google.android.exoplayer2.a.i.d(java.lang.String, long, long):void, file: classes8.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 19 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.google.android.exoplayer2.a.e, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 25 more
                */
            /*
                this = this;
                r8 = 91815(0x166a7, float:1.2866E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r8)
                com.google.android.exoplayer2.a.e$a r2 = r10.bgw
                com.google.android.exoplayer2.a.e r0 = r2.beP
                if (r0 == 0) goto L_0x0019
                android.os.Handler r0 = r2.handler
                com.google.android.exoplayer2.a.e$a$2 r1 = new com.google.android.exoplayer2.a.e$a$2
                r3 = r11
                r4 = r12
                r6 = r14
                r1.<init>(r3, r4, r6)
                r0.post(r1)
            L_0x0019:
                com.tencent.matrix.trace.core.AppMethodBeat.o(r8)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.a.i.d(java.lang.String, long, long):void");
        }

        @Override // com.google.android.exoplayer2.e.b
        public final void e(Format format) {
            AppMethodBeat.i(91816);
            super.e(format);
            e.a aVar = this.bgw;
            if (aVar.beP != null) {
                aVar.handler.post(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0016: INVOKE  
                      (wrap: android.os.Handler : 0x000f: IGET  (r1v2 android.os.Handler) = (r0v0 'aVar' com.google.android.exoplayer2.a.e$a) com.google.android.exoplayer2.a.e.a.handler android.os.Handler)
                      (wrap: com.google.android.exoplayer2.a.e$a$3 : 0x0013: CONSTRUCTOR  (r2v0 com.google.android.exoplayer2.a.e$a$3) = (r0v0 'aVar' com.google.android.exoplayer2.a.e$a), (r5v0 'format' com.google.android.exoplayer2.Format) call: com.google.android.exoplayer2.a.e.a.3.<init>(com.google.android.exoplayer2.a.e$a, com.google.android.exoplayer2.Format):void type: CONSTRUCTOR)
                     type: VIRTUAL call: android.os.Handler.post(java.lang.Runnable):boolean in method: com.google.android.exoplayer2.a.i.e(com.google.android.exoplayer2.Format):void, file: classes8.dex
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
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0013: CONSTRUCTOR  (r2v0 com.google.android.exoplayer2.a.e$a$3) = (r0v0 'aVar' com.google.android.exoplayer2.a.e$a), (r5v0 'format' com.google.android.exoplayer2.Format) call: com.google.android.exoplayer2.a.e.a.3.<init>(com.google.android.exoplayer2.a.e$a, com.google.android.exoplayer2.Format):void type: CONSTRUCTOR in method: com.google.android.exoplayer2.a.i.e(com.google.android.exoplayer2.Format):void, file: classes8.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 19 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.google.android.exoplayer2.a.e, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 25 more
                    */
                /*
                    this = this;
                    r3 = 91816(0x166a8, float:1.28662E-40)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                    super.e(r5)
                    com.google.android.exoplayer2.a.e$a r0 = r4.bgw
                    com.google.android.exoplayer2.a.e r1 = r0.beP
                    if (r1 == 0) goto L_0x0019
                    android.os.Handler r1 = r0.handler
                    com.google.android.exoplayer2.a.e$a$3 r2 = new com.google.android.exoplayer2.a.e$a$3
                    r2.<init>(r5)
                    r1.post(r2)
                L_0x0019:
                    java.lang.String r0 = "audio/raw"
                    java.lang.String r1 = r5.bdq
                    boolean r0 = r0.equals(r1)
                    if (r0 == 0) goto L_0x0030
                    int r0 = r5.pcmEncoding
                L_0x0026:
                    r4.pcmEncoding = r0
                    int r0 = r5.channelCount
                    r4.channelCount = r0
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                    return
                L_0x0030:
                    r0 = 2
                    goto L_0x0026
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.a.i.e(com.google.android.exoplayer2.Format):void");
            }

            @Override // com.google.android.exoplayer2.e.b
            public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
                int[] iArr;
                int i2;
                boolean z;
                int i3;
                int J;
                f fVar;
                long I;
                AppMethodBeat.i(91817);
                boolean z2 = this.bgA != null;
                String string = z2 ? this.bgA.getString("mime") : "audio/raw";
                if (z2) {
                    mediaFormat = this.bgA;
                }
                int integer = mediaFormat.getInteger("channel-count");
                int integer2 = mediaFormat.getInteger("sample-rate");
                if (!this.bgz || integer != 6 || this.channelCount >= 6) {
                    iArr = null;
                } else {
                    int[] iArr2 = new int[this.channelCount];
                    for (int i4 = 0; i4 < this.channelCount; i4++) {
                        iArr2[i4] = i4;
                    }
                    iArr = iArr2;
                }
                try {
                    f fVar2 = this.bgx;
                    int i5 = this.pcmEncoding;
                    boolean z3 = !"audio/raw".equals(string);
                    if (z3) {
                        i2 = f.be(string);
                    } else {
                        i2 = i5;
                    }
                    boolean z4 = false;
                    if (!z3) {
                        fVar2.bfE = x.bj(i5, integer);
                        fVar2.bfe.bgq = iArr;
                        d[] dVarArr = fVar2.bfg;
                        int i6 = integer;
                        for (d dVar : dVarArr) {
                            try {
                                z4 |= dVar.p(integer2, i6, i2);
                                if (dVar.isActive()) {
                                    i6 = dVar.tH();
                                    i2 = 2;
                                }
                            } catch (d.a e2) {
                                f.c cVar = new f.c(e2);
                                AppMethodBeat.o(91817);
                                throw cVar;
                            }
                        }
                        if (z4) {
                            fVar2.tK();
                        }
                        z = z4;
                        integer = i6;
                    } else {
                        z = false;
                    }
                    switch (integer) {
                        case 1:
                            i3 = 4;
                            break;
                        case 2:
                            i3 = 12;
                            break;
                        case 3:
                            i3 = 28;
                            break;
                        case 4:
                            i3 = 204;
                            break;
                        case 5:
                            i3 = TbsListener.ErrorCode.COPY_INSTALL_SUCCESS;
                            break;
                        case 6:
                            i3 = 252;
                            break;
                        case 7:
                            i3 = 1276;
                            break;
                        case 8:
                            i3 = com.google.android.exoplayer2.b.CHANNEL_OUT_7POINT1_SURROUND;
                            break;
                        default:
                            f.c cVar2 = new f.c("Unsupported channel count: ".concat(String.valueOf(integer)));
                            AppMethodBeat.o(91817);
                            throw cVar2;
                    }
                    if (x.SDK_INT <= 23 && "foster".equals(x.DEVICE) && "NVIDIA".equals(x.MANUFACTURER)) {
                        switch (integer) {
                            case 3:
                            case 5:
                                i3 = 252;
                                break;
                            case 7:
                                i3 = com.google.android.exoplayer2.b.CHANNEL_OUT_7POINT1_SURROUND;
                                break;
                        }
                    }
                    int i7 = (x.SDK_INT > 25 || !"fugu".equals(x.DEVICE) || !z3 || integer != 1) ? i3 : 12;
                    if (!(!z && fVar2.isInitialized() && fVar2.encoding == i2 && fVar2.sampleRate == integer2 && fVar2.channelConfig == i7)) {
                        fVar2.reset();
                        fVar2.encoding = i2;
                        fVar2.bfp = z3;
                        fVar2.sampleRate = integer2;
                        fVar2.channelConfig = i7;
                        fVar2.bfo = z3 ? i2 : 2;
                        fVar2.bfH = x.bj(2, integer);
                        if (!z3) {
                            int minBufferSize = AudioTrack.getMinBufferSize(integer2, i7, fVar2.bfo);
                            com.google.android.exoplayer2.i.a.checkState(minBufferSize != -2);
                            int i8 = minBufferSize * 4;
                            J = ((int) fVar2.J(250000)) * fVar2.bfH;
                            int max = (int) Math.max((long) minBufferSize, fVar2.J(750000) * ((long) fVar2.bfH));
                            if (i8 < J) {
                                fVar = fVar2;
                            } else if (i8 > max) {
                                J = max;
                                fVar = fVar2;
                            } else {
                                J = i8;
                                fVar = fVar2;
                            }
                        } else if (fVar2.bfo == 5 || fVar2.bfo == 6) {
                            J = 20480;
                            fVar = fVar2;
                        } else {
                            J = 49152;
                            fVar = fVar2;
                        }
                        fVar.bufferSize = J;
                        if (z3) {
                            I = -9223372036854775807L;
                        } else {
                            I = fVar2.I((long) (fVar2.bufferSize / fVar2.bfH));
                        }
                        fVar2.bfq = I;
                        fVar2.c(fVar2.bcs);
                    }
                    AppMethodBeat.o(91817);
                } catch (f.c e3) {
                    com.google.android.exoplayer2.e b2 = com.google.android.exoplayer2.e.b(e3, this.index);
                    AppMethodBeat.o(91817);
                    throw b2;
                }
            }

            @Override // com.google.android.exoplayer2.a, com.google.android.exoplayer2.e.b
            public final void aN(boolean z) {
                boolean z2 = false;
                AppMethodBeat.i(91818);
                super.aN(z);
                e.a aVar = this.bgw;
                com.google.android.exoplayer2.b.d dVar = this.btJ;
                if (aVar.beP != null) {
                    aVar.handler.post(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001a: INVOKE  
                          (wrap: android.os.Handler : 0x0013: IGET  (r4v2 android.os.Handler) = (r2v0 'aVar' com.google.android.exoplayer2.a.e$a) com.google.android.exoplayer2.a.e.a.handler android.os.Handler)
                          (wrap: com.google.android.exoplayer2.a.e$a$1 : 0x0017: CONSTRUCTOR  (r5v1 com.google.android.exoplayer2.a.e$a$1) = (r2v0 'aVar' com.google.android.exoplayer2.a.e$a), (r3v0 'dVar' com.google.android.exoplayer2.b.d) call: com.google.android.exoplayer2.a.e.a.1.<init>(com.google.android.exoplayer2.a.e$a, com.google.android.exoplayer2.b.d):void type: CONSTRUCTOR)
                         type: VIRTUAL call: android.os.Handler.post(java.lang.Runnable):boolean in method: com.google.android.exoplayer2.a.i.aN(boolean):void, file: classes8.dex
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
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                        	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.util.ArrayList.forEach(ArrayList.java:1259)
                        	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0017: CONSTRUCTOR  (r5v1 com.google.android.exoplayer2.a.e$a$1) = (r2v0 'aVar' com.google.android.exoplayer2.a.e$a), (r3v0 'dVar' com.google.android.exoplayer2.b.d) call: com.google.android.exoplayer2.a.e.a.1.<init>(com.google.android.exoplayer2.a.e$a, com.google.android.exoplayer2.b.d):void type: CONSTRUCTOR in method: com.google.android.exoplayer2.a.i.aN(boolean):void, file: classes8.dex
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                        	... 19 more
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.google.android.exoplayer2.a.e, state: GENERATED_AND_UNLOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                        	... 25 more
                        */
                    /*
                        this = this;
                        r1 = 1
                        r6 = 91818(0x166aa, float:1.28664E-40)
                        r0 = 0
                        com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
                        super.aN(r8)
                        com.google.android.exoplayer2.a.e$a r2 = r7.bgw
                        com.google.android.exoplayer2.b.d r3 = r7.btJ
                        com.google.android.exoplayer2.a.e r4 = r2.beP
                        if (r4 == 0) goto L_0x001d
                        android.os.Handler r4 = r2.handler
                        com.google.android.exoplayer2.a.e$a$1 r5 = new com.google.android.exoplayer2.a.e$a$1
                        r5.<init>(r3)
                        r4.post(r5)
                    L_0x001d:
                        com.google.android.exoplayer2.t r2 = r7.bbE
                        int r2 = r2.bdQ
                        if (r2 == 0) goto L_0x0042
                        com.google.android.exoplayer2.a.f r3 = r7.bgx
                        int r4 = com.google.android.exoplayer2.i.x.SDK_INT
                        r5 = 21
                        if (r4 < r5) goto L_0x002c
                        r0 = r1
                    L_0x002c:
                        com.google.android.exoplayer2.i.a.checkState(r0)
                        boolean r0 = r3.bfX
                        if (r0 == 0) goto L_0x0037
                        int r0 = r3.beh
                        if (r0 == r2) goto L_0x003e
                    L_0x0037:
                        r3.bfX = r1
                        r3.beh = r2
                        r3.reset()
                    L_0x003e:
                        com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                    L_0x0041:
                        return
                    L_0x0042:
                        com.google.android.exoplayer2.a.f r1 = r7.bgx
                        boolean r2 = r1.bfX
                        if (r2 == 0) goto L_0x004f
                        r1.bfX = r0
                        r1.beh = r0
                        r1.reset()
                    L_0x004f:
                        com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                        goto L_0x0041
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.a.i.aN(boolean):void");
                }

                @Override // com.google.android.exoplayer2.a, com.google.android.exoplayer2.e.b
                public final void a(long j2, boolean z) {
                    AppMethodBeat.i(91819);
                    super.a(j2, z);
                    this.bgx.reset();
                    this.bgB = j2;
                    this.bgC = true;
                    AppMethodBeat.o(91819);
                }

                @Override // com.google.android.exoplayer2.a, com.google.android.exoplayer2.e.b
                public final void onStarted() {
                    AppMethodBeat.i(91820);
                    super.onStarted();
                    this.bgx.play();
                    AppMethodBeat.o(91820);
                }

                @Override // com.google.android.exoplayer2.a, com.google.android.exoplayer2.e.b
                public final void onStopped() {
                    AppMethodBeat.i(91821);
                    f fVar = this.bgx;
                    fVar.bfW = false;
                    if (fVar.isInitialized()) {
                        fVar.tR();
                        fVar.bfk.pause();
                    }
                    super.onStopped();
                    AppMethodBeat.o(91821);
                }

                @Override // com.google.android.exoplayer2.a, com.google.android.exoplayer2.e.b
                public final void te() {
                    AppMethodBeat.i(91822);
                    try {
                        f fVar = this.bgx;
                        fVar.reset();
                        fVar.tO();
                        for (d dVar : fVar.bfg) {
                            dVar.reset();
                        }
                        fVar.beh = 0;
                        fVar.bfW = false;
                        try {
                            super.te();
                        } finally {
                            this.bgw.e(this.btJ);
                            AppMethodBeat.o(91822);
                        }
                    } catch (Throwable th) {
                        super.te();
                        throw th;
                    } finally {
                        this.bgw.e(this.btJ);
                        AppMethodBeat.o(91822);
                    }
                }

                @Override // com.google.android.exoplayer2.e.b, com.google.android.exoplayer2.r
                public final boolean tB() {
                    boolean z;
                    AppMethodBeat.i(91823);
                    if (super.tB()) {
                        f fVar = this.bgx;
                        if (!fVar.isInitialized() || (fVar.bfV && !fVar.tM())) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            AppMethodBeat.o(91823);
                            return true;
                        }
                    }
                    AppMethodBeat.o(91823);
                    return false;
                }

                @Override // com.google.android.exoplayer2.e.b, com.google.android.exoplayer2.r
                public final boolean isReady() {
                    AppMethodBeat.i(91824);
                    if (this.bgx.tM() || super.isReady()) {
                        AppMethodBeat.o(91824);
                        return true;
                    }
                    AppMethodBeat.o(91824);
                    return false;
                }

                @Override // com.google.android.exoplayer2.i.i
                public final long tV() {
                    AppMethodBeat.i(91825);
                    long aS = this.bgx.aS(tB());
                    if (aS != Long.MIN_VALUE) {
                        if (!this.bgC) {
                            aS = Math.max(this.bgB, aS);
                        }
                        this.bgB = aS;
                        this.bgC = false;
                    }
                    long j2 = this.bgB;
                    AppMethodBeat.o(91825);
                    return j2;
                }

                @Override // com.google.android.exoplayer2.i.i
                public final p c(p pVar) {
                    AppMethodBeat.i(91826);
                    p c2 = this.bgx.c(pVar);
                    AppMethodBeat.o(91826);
                    return c2;
                }

                @Override // com.google.android.exoplayer2.i.i
                public final p tZ() {
                    return this.bgx.bcs;
                }

                /* JADX WARNING: Code restructure failed: missing block: B:49:0x00fb, code lost:
                    if (r10.bfk.tU() != 0) goto L_0x00c9;
                 */
                /* JADX WARNING: Removed duplicated region for block: B:111:0x0252  */
                /* JADX WARNING: Removed duplicated region for block: B:43:0x00cc A[Catch:{ d | h -> 0x01da }] */
                @Override // com.google.android.exoplayer2.e.b
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final boolean a(long r12, long r14, android.media.MediaCodec r16, java.nio.ByteBuffer r17, int r18, int r19, long r20, boolean r22) {
                    /*
                    // Method dump skipped, instructions count: 603
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.a.i.a(long, long, android.media.MediaCodec, java.nio.ByteBuffer, int, int, long, boolean):boolean");
                }

                @Override // com.google.android.exoplayer2.e.b
                public final void ua() {
                    AppMethodBeat.i(91828);
                    try {
                        f fVar = this.bgx;
                        if (fVar.bfV || !fVar.isInitialized()) {
                            AppMethodBeat.o(91828);
                            return;
                        }
                        if (fVar.tL()) {
                            fVar.bfk.K(fVar.tQ());
                            fVar.bfw = 0;
                            fVar.bfV = true;
                        }
                        AppMethodBeat.o(91828);
                    } catch (f.h e2) {
                        com.google.android.exoplayer2.e b2 = com.google.android.exoplayer2.e.b(e2, this.index);
                        AppMethodBeat.o(91828);
                        throw b2;
                    }
                }

                @Override // com.google.android.exoplayer2.a, com.google.android.exoplayer2.f.b
                public final void c(int i2, Object obj) {
                    AppMethodBeat.i(91829);
                    switch (i2) {
                        case 2:
                            f fVar = this.bgx;
                            float floatValue = ((Float) obj).floatValue();
                            if (fVar.volume != floatValue) {
                                fVar.volume = floatValue;
                                fVar.tN();
                            }
                            AppMethodBeat.o(91829);
                            return;
                        case 3:
                            b bVar = (b) obj;
                            f fVar2 = this.bgx;
                            if (!fVar2.bei.equals(bVar)) {
                                fVar2.bei = bVar;
                                if (!fVar2.bfX) {
                                    fVar2.reset();
                                    fVar2.beh = 0;
                                }
                            }
                            AppMethodBeat.o(91829);
                            return;
                        default:
                            super.c(i2, obj);
                            AppMethodBeat.o(91829);
                            return;
                    }
                }

                final class a implements f.AbstractC0099f {
                    private a() {
                    }

                    /* synthetic */ a(i iVar, byte b2) {
                        this();
                    }

                    @Override // com.google.android.exoplayer2.a.f.AbstractC0099f
                    public final void dG(int i2) {
                        AppMethodBeat.i(91807);
                        e.a aVar = i.this.bgw;
                        if (aVar.beP != null) {
                            aVar.handler.post(
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0017: INVOKE  
                                  (wrap: android.os.Handler : 0x0010: IGET  (r1v1 android.os.Handler) = (r0v1 'aVar' com.google.android.exoplayer2.a.e$a) com.google.android.exoplayer2.a.e.a.handler android.os.Handler)
                                  (wrap: com.google.android.exoplayer2.a.e$a$6 : 0x0014: CONSTRUCTOR  (r2v0 com.google.android.exoplayer2.a.e$a$6) = (r0v1 'aVar' com.google.android.exoplayer2.a.e$a), (r5v0 'i2' int) call: com.google.android.exoplayer2.a.e.a.6.<init>(com.google.android.exoplayer2.a.e$a, int):void type: CONSTRUCTOR)
                                 type: VIRTUAL call: android.os.Handler.post(java.lang.Runnable):boolean in method: com.google.android.exoplayer2.a.i.a.dG(int):void, file: classes8.dex
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
                                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0014: CONSTRUCTOR  (r2v0 com.google.android.exoplayer2.a.e$a$6) = (r0v1 'aVar' com.google.android.exoplayer2.a.e$a), (r5v0 'i2' int) call: com.google.android.exoplayer2.a.e.a.6.<init>(com.google.android.exoplayer2.a.e$a, int):void type: CONSTRUCTOR in method: com.google.android.exoplayer2.a.i.a.dG(int):void, file: classes8.dex
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                	... 19 more
                                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.google.android.exoplayer2.a.e, state: GENERATED_AND_UNLOADED
                                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                	... 25 more
                                */
                            /*
                                this = this;
                                r3 = 91807(0x1669f, float:1.28649E-40)
                                com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                                com.google.android.exoplayer2.a.i r0 = com.google.android.exoplayer2.a.i.this
                                com.google.android.exoplayer2.a.e$a r0 = com.google.android.exoplayer2.a.i.a(r0)
                                com.google.android.exoplayer2.a.e r1 = r0.beP
                                if (r1 == 0) goto L_0x001a
                                android.os.Handler r1 = r0.handler
                                com.google.android.exoplayer2.a.e$a$6 r2 = new com.google.android.exoplayer2.a.e$a$6
                                r2.<init>(r5)
                                r1.post(r2)
                            L_0x001a:
                                com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.a.i.a.dG(int):void");
                        }

                        @Override // com.google.android.exoplayer2.a.f.AbstractC0099f
                        public final void tA() {
                            AppMethodBeat.i(91808);
                            i.this.bgC = true;
                            AppMethodBeat.o(91808);
                        }

                        @Override // com.google.android.exoplayer2.a.f.AbstractC0099f
                        public final void e(int i2, long j2, long j3) {
                            AppMethodBeat.i(91809);
                            e.a aVar = i.this.bgw;
                            if (aVar.beP != null) {
                                aVar.handler.post(
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001a: INVOKE  
                                      (wrap: android.os.Handler : 0x0010: IGET  (r0v2 android.os.Handler) = (r2v0 'aVar' com.google.android.exoplayer2.a.e$a) com.google.android.exoplayer2.a.e.a.handler android.os.Handler)
                                      (wrap: com.google.android.exoplayer2.a.e$a$4 : 0x0017: CONSTRUCTOR  (r1v0 com.google.android.exoplayer2.a.e$a$4) = (r2v0 'aVar' com.google.android.exoplayer2.a.e$a), (r11v0 'i2' int), (r12v0 'j2' long), (r14v0 'j3' long) call: com.google.android.exoplayer2.a.e.a.4.<init>(com.google.android.exoplayer2.a.e$a, int, long, long):void type: CONSTRUCTOR)
                                     type: VIRTUAL call: android.os.Handler.post(java.lang.Runnable):boolean in method: com.google.android.exoplayer2.a.i.a.e(int, long, long):void, file: classes8.dex
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
                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0017: CONSTRUCTOR  (r1v0 com.google.android.exoplayer2.a.e$a$4) = (r2v0 'aVar' com.google.android.exoplayer2.a.e$a), (r11v0 'i2' int), (r12v0 'j2' long), (r14v0 'j3' long) call: com.google.android.exoplayer2.a.e.a.4.<init>(com.google.android.exoplayer2.a.e$a, int, long, long):void type: CONSTRUCTOR in method: com.google.android.exoplayer2.a.i.a.e(int, long, long):void, file: classes8.dex
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                                    	... 19 more
                                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.google.android.exoplayer2.a.e, state: GENERATED_AND_UNLOADED
                                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                                    	... 25 more
                                    */
                                /*
                                    this = this;
                                    r8 = 91809(0x166a1, float:1.28652E-40)
                                    com.tencent.matrix.trace.core.AppMethodBeat.i(r8)
                                    com.google.android.exoplayer2.a.i r0 = com.google.android.exoplayer2.a.i.this
                                    com.google.android.exoplayer2.a.e$a r2 = com.google.android.exoplayer2.a.i.a(r0)
                                    com.google.android.exoplayer2.a.e r0 = r2.beP
                                    if (r0 == 0) goto L_0x001d
                                    android.os.Handler r0 = r2.handler
                                    com.google.android.exoplayer2.a.e$a$4 r1 = new com.google.android.exoplayer2.a.e$a$4
                                    r3 = r11
                                    r4 = r12
                                    r6 = r14
                                    r1.<init>(r3, r4, r6)
                                    r0.post(r1)
                                L_0x001d:
                                    com.tencent.matrix.trace.core.AppMethodBeat.o(r8)
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.a.i.a.e(int, long, long):void");
                            }
                        }
                    }
