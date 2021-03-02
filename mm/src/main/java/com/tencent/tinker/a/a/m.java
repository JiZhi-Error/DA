package com.tencent.tinker.a.a;

import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tinker.a.a.b.a;

public final class m {
    protected final a Sgv;
    public int Sgw;
    private int Sgx;
    private int type;

    public m(a aVar, int i2) {
        this.type = -1;
        this.Sgv = aVar;
        this.type = i2;
    }

    public final int hoI() {
        if (this.type == -1) {
            int readByte = this.Sgv.readByte() & 255;
            this.type = readByte & 31;
            this.Sgx = (readByte & TbsListener.ErrorCode.EXCEED_INCR_UPDATE) >> 5;
        }
        return this.type;
    }

    public final int hoJ() {
        arJ(28);
        this.type = -1;
        return o.b(this.Sgv);
    }

    public final int hoK() {
        arJ(29);
        this.type = -1;
        this.Sgw = o.b(this.Sgv);
        return o.b(this.Sgv);
    }

    public final int hoL() {
        return o.b(this.Sgv);
    }

    public final byte readByte() {
        arJ(0);
        this.type = -1;
        return (byte) l.a(this.Sgv, this.Sgx);
    }

    public final short readShort() {
        arJ(2);
        this.type = -1;
        return (short) l.a(this.Sgv, this.Sgx);
    }

    public final char readChar() {
        arJ(3);
        this.type = -1;
        return (char) l.a(this.Sgv, this.Sgx, false);
    }

    public final int readInt() {
        arJ(4);
        this.type = -1;
        return l.a(this.Sgv, this.Sgx);
    }

    public final long readLong() {
        arJ(6);
        this.type = -1;
        a aVar = this.Sgv;
        int i2 = this.Sgx;
        long j2 = 0;
        for (int i3 = i2; i3 >= 0; i3--) {
            j2 = (j2 >>> 8) | ((((long) aVar.readByte()) & 255) << 56);
        }
        return j2 >> ((7 - i2) * 8);
    }

    public final float readFloat() {
        arJ(16);
        this.type = -1;
        return Float.intBitsToFloat(l.a(this.Sgv, this.Sgx, true));
    }

    public final double readDouble() {
        arJ(17);
        this.type = -1;
        a aVar = this.Sgv;
        long j2 = 0;
        for (int i2 = this.Sgx; i2 >= 0; i2--) {
            j2 = (j2 >>> 8) | ((((long) aVar.readByte()) & 255) << 56);
        }
        return Double.longBitsToDouble(j2);
    }

    public final int hoM() {
        arJ(23);
        this.type = -1;
        return l.a(this.Sgv, this.Sgx, false);
    }

    public final int hoN() {
        arJ(24);
        this.type = -1;
        return l.a(this.Sgv, this.Sgx, false);
    }

    public final int hoO() {
        arJ(25);
        this.type = -1;
        return l.a(this.Sgv, this.Sgx, false);
    }

    public final int zd() {
        arJ(27);
        this.type = -1;
        return l.a(this.Sgv, this.Sgx, false);
    }

    public final int hoP() {
        arJ(26);
        this.type = -1;
        return l.a(this.Sgv, this.Sgx, false);
    }

    public final void hoQ() {
        arJ(30);
        this.type = -1;
    }

    public final boolean readBoolean() {
        arJ(31);
        this.type = -1;
        return this.Sgx != 0;
    }

    public final void skipValue() {
        int i2 = 0;
        switch (hoI()) {
            case 0:
                readByte();
                return;
            case 1:
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            default:
                throw new j("Unexpected type: " + Integer.toHexString(this.type));
            case 2:
                readShort();
                return;
            case 3:
                readChar();
                return;
            case 4:
                readInt();
                return;
            case 6:
                readLong();
                return;
            case 16:
                readFloat();
                return;
            case 17:
                readDouble();
                return;
            case 23:
                hoM();
                return;
            case 24:
                hoN();
                return;
            case 25:
                hoO();
                return;
            case 26:
                hoP();
                return;
            case 27:
                zd();
                return;
            case 28:
                int hoJ = hoJ();
                while (i2 < hoJ) {
                    skipValue();
                    i2++;
                }
                return;
            case 29:
                int hoK = hoK();
                while (i2 < hoK) {
                    o.b(this.Sgv);
                    skipValue();
                    i2++;
                }
                return;
            case 30:
                hoQ();
                return;
            case 31:
                readBoolean();
                return;
        }
    }

    private void arJ(int i2) {
        if (hoI() != i2) {
            throw new IllegalStateException(String.format("Expected %x but was %x", Integer.valueOf(i2), Integer.valueOf(hoI())));
        }
    }

    public m(k kVar, int i2) {
        this(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0005: CONSTRUCTOR  
              (wrap: com.tencent.tinker.a.a.k$1 : 0x0002: CONSTRUCTOR  (r0v0 com.tencent.tinker.a.a.k$1) = (r2v0 'kVar' com.tencent.tinker.a.a.k) call: com.tencent.tinker.a.a.k.1.<init>(com.tencent.tinker.a.a.k):void type: CONSTRUCTOR)
              (r3v0 'i2' int)
             call: com.tencent.tinker.a.a.m.<init>(com.tencent.tinker.a.a.b.a, int):void type: THIS in method: com.tencent.tinker.a.a.m.<init>(com.tencent.tinker.a.a.k, int):void, file: classes9.dex
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
            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0002: CONSTRUCTOR  (r0v0 com.tencent.tinker.a.a.k$1) = (r2v0 'kVar' com.tencent.tinker.a.a.k) call: com.tencent.tinker.a.a.k.1.<init>(com.tencent.tinker.a.a.k):void type: CONSTRUCTOR in method: com.tencent.tinker.a.a.m.<init>(com.tencent.tinker.a.a.k, int):void, file: classes9.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:663)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.tinker.a.a.k, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
            	... 20 more
            */
        /*
            this = this;
            com.tencent.tinker.a.a.k$1 r0 = new com.tencent.tinker.a.a.k$1
            r0.<init>()
            r1.<init>(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.a.a.m.<init>(com.tencent.tinker.a.a.k, int):void");
    }
}
