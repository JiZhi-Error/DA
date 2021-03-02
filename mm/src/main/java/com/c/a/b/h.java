package com.c.a.b;

import com.c.a.b.a.a;
import com.c.a.c.k;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.jsapi.p.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.export.external.interfaces.ISelectionInterface;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.EOFException;

public final class h {
    l coS;
    private final a coV;
    int coW;
    k<String> coX = new k<>();
    k<String> coY = new k<>();

    public h(a aVar) {
        this.coV = aVar;
    }

    public final l Kh() {
        l lVar = new l(this.coV);
        this.coS = lVar;
        try {
            StringBuilder sb = new StringBuilder();
            byte readByte = this.coV.readByte();
            while (readByte != 0) {
                sb.append((char) readByte);
                readByte = this.coV.readByte();
            }
            this.coW = this.coV.readInt();
            this.coS.ht(this.coW);
            this.coV.readLong();
            while (this.coV.hasRemaining()) {
                int readUnsignedByte = readUnsignedByte();
                this.coV.readInt();
                long readInt = ((long) this.coV.readInt()) & Util.MAX_32BIT_VALUE;
                switch (readUnsignedByte) {
                    case 1:
                        long Ki = Ki();
                        byte[] bArr = new byte[(((int) readInt) - this.coW)];
                        this.coV.M(bArr);
                        this.coX.a(Ki, new String(bArr, ProtocolPackage.ServerEncoding));
                        break;
                    case 2:
                        this.coV.readInt();
                        long Ki2 = Ki();
                        this.coV.readInt();
                        this.coY.a(Ki2, this.coX.get(Ki()));
                        break;
                    case 4:
                        m mVar = new m(Ki(), this.coX.get(Ki()), this.coX.get(Ki()), this.coX.get(Ki()), this.coV.readInt(), this.coV.readInt());
                        this.coS.cpF.coL.a(mVar.MS, mVar);
                        break;
                    case 5:
                        Kj();
                        break;
                    case 12:
                        aP(readInt);
                        this.coS.g(0, BuildConfig.KINDA_DEFAULT);
                        break;
                    case 28:
                        aP(readInt);
                        this.coS.g(0, BuildConfig.KINDA_DEFAULT);
                        break;
                    default:
                        aQ(readInt);
                        break;
                }
            }
        } catch (EOFException e2) {
        }
        try {
            this.coS.Ko();
            this.coS.Kp();
        } catch (Exception e3) {
        }
        this.coY.clear();
        this.coX.clear();
        return lVar;
    }

    private long Ki() {
        switch (this.coW) {
            case 1:
                return (long) this.coV.readByte();
            case 2:
                return (long) this.coV.readShort();
            case 3:
            case 5:
            case 6:
            case 7:
            default:
                throw new IllegalArgumentException("ID Length must be 1, 2, 4, or 8");
            case 4:
                return (long) this.coV.readInt();
            case 8:
                return this.coV.readLong();
        }
    }

    private int readUnsignedByte() {
        return this.coV.readByte() & 255;
    }

    private int readUnsignedShort() {
        return this.coV.readShort() & ISelectionInterface.HELD_NOTHING;
    }

    private void Kj() {
        int readInt = this.coV.readInt();
        int readInt2 = this.coV.readInt();
        int readInt3 = this.coV.readInt();
        m[] mVarArr = new m[readInt3];
        for (int i2 = 0; i2 < readInt3; i2++) {
            mVarArr[i2] = this.coS.cpF.coL.get(Ki());
        }
        n nVar = new n(readInt, readInt2, mVarArr);
        this.coS.cpF.coM.e(nVar.cpJ, nVar);
    }

    private void aP(long j2) {
        while (j2 > 0) {
            int readUnsignedByte = readUnsignedByte();
            long j3 = j2 - 1;
            switch (readUnsignedByte) {
                case 1:
                    Ki();
                    j2 = (j3 - ((long) a(k.NATIVE_STATIC))) - ((long) this.coW);
                    break;
                case 2:
                    long Ki = Ki();
                    int readInt = this.coV.readInt();
                    this.coS.a(new j(k.NATIVE_LOCAL, Ki, readInt, this.coS.bS(this.coS.hr(readInt).cpO, this.coV.readInt())));
                    j2 = j3 - ((long) ((this.coW + 4) + 4));
                    break;
                case 3:
                    long Ki2 = Ki();
                    int readInt2 = this.coV.readInt();
                    this.coS.a(new j(k.JAVA_LOCAL, Ki2, readInt2, this.coS.bS(this.coS.hr(readInt2).cpO, this.coV.readInt())));
                    j2 = j3 - ((long) ((this.coW + 4) + 4));
                    break;
                case 4:
                    long Ki3 = Ki();
                    int readInt3 = this.coV.readInt();
                    this.coS.a(new j(k.NATIVE_STACK, Ki3, readInt3, this.coS.hq(this.coS.hr(readInt3).cpO)));
                    j2 = j3 - ((long) (this.coW + 4));
                    break;
                case 5:
                    j2 = j3 - ((long) a(k.SYSTEM_CLASS));
                    break;
                case 6:
                    long Ki4 = Ki();
                    int readInt4 = this.coV.readInt();
                    this.coS.a(new j(k.THREAD_BLOCK, Ki4, readInt4, this.coS.hq(this.coS.hr(readInt4).cpO)));
                    j2 = j3 - ((long) (this.coW + 4));
                    break;
                case 7:
                    j2 = j3 - ((long) a(k.BUSY_MONITOR));
                    break;
                case 8:
                    this.coS.cpF.coO.e(this.coV.readInt(), new o(Ki(), this.coV.readInt()));
                    j2 = j3 - ((long) ((this.coW + 4) + 4));
                    break;
                case 32:
                    long Ki5 = Ki();
                    n hq = this.coS.hq(this.coV.readInt());
                    long Ki6 = Ki();
                    long Ki7 = Ki();
                    Ki();
                    Ki();
                    Ki();
                    Ki();
                    int readInt5 = this.coV.readInt();
                    int readUnsignedShort = readUnsignedShort();
                    int i2 = 0;
                    int i3 = (this.coW * 7) + 4 + 4 + 2;
                    while (i2 < readUnsignedShort) {
                        readUnsignedShort();
                        int b2 = this.coS.b(p.hu(readUnsignedByte()));
                        aQ((long) b2);
                        i2++;
                        i3 = b2 + 1 + 2 + i3;
                    }
                    c cVar = new c(Ki5, hq, this.coY.get(Ki5), this.coV.position());
                    cVar.coA = Ki6;
                    cVar.coB = Ki7;
                    int readUnsignedShort2 = readUnsignedShort();
                    int i4 = i3 + 2;
                    d[] dVarArr = new d[readUnsignedShort2];
                    for (int i5 = 0; i5 < readUnsignedShort2; i5++) {
                        p hu = p.hu(this.coV.readByte());
                        dVarArr[i5] = new d(hu, this.coX.get(Ki()));
                        aQ((long) this.coS.b(hu));
                        i4 += this.coW + 1 + this.coS.b(hu);
                    }
                    cVar.coD = dVarArr;
                    int readUnsignedShort3 = readUnsignedShort();
                    int i6 = i4 + 2;
                    d[] dVarArr2 = new d[readUnsignedShort3];
                    for (int i7 = 0; i7 < readUnsignedShort3; i7++) {
                        dVarArr2[i7] = new d(p.hu(readUnsignedByte()), this.coX.get(Ki()));
                        i6 += this.coW + 1;
                    }
                    cVar.coC = dVarArr2;
                    cVar.coE = readInt5;
                    l lVar = this.coS;
                    g gVar = lVar.cpF;
                    gVar.coP.a(Ki5, cVar);
                    gVar.coQ.r(cVar.mClassName, cVar);
                    cVar.cpb = lVar.cpF;
                    j2 = j3 - ((long) i6);
                    break;
                case 33:
                    long Ki8 = Ki();
                    n hq2 = this.coS.hq(this.coV.readInt());
                    long Ki9 = Ki();
                    int readInt6 = this.coV.readInt();
                    b bVar = new b(Ki8, hq2, this.coV.position());
                    bVar.cpa = Ki9;
                    this.coS.a(Ki8, bVar);
                    aQ((long) readInt6);
                    j2 = j3 - ((long) ((((this.coW + 4) + this.coW) + 4) + readInt6));
                    break;
                case 34:
                    long Ki10 = Ki();
                    n hq3 = this.coS.hq(this.coV.readInt());
                    int readInt7 = this.coV.readInt();
                    long Ki11 = Ki();
                    a aVar = new a(Ki10, hq3, p.OBJECT, readInt7, this.coV.position());
                    aVar.cpa = Ki11;
                    this.coS.a(Ki10, aVar);
                    int i8 = this.coW * readInt7;
                    aQ((long) i8);
                    j2 = j3 - ((long) (i8 + (((this.coW + 4) + 4) + this.coW)));
                    break;
                case 35:
                    j2 = j3 - ((long) Kk());
                    break;
                case 137:
                    j2 = j3 - ((long) a(k.INTERNED_STRING));
                    break;
                case 138:
                    j2 = j3 - ((long) a(k.FINALIZING));
                    break;
                case b.CTRL_INDEX /*{ENCODED_INT: 139}*/:
                    j2 = j3 - ((long) a(k.DEBUGGER));
                    break;
                case 140:
                    j2 = j3 - ((long) a(k.REFERENCE_CLEANUP));
                    break;
                case 141:
                    j2 = j3 - ((long) a(k.VM_INTERNAL));
                    break;
                case TbsListener.ErrorCode.NEEDDOWNLOAD_3 /*{ENCODED_INT: 142}*/:
                    long Ki12 = Ki();
                    int readInt8 = this.coV.readInt();
                    this.coS.a(new j(k.NATIVE_MONITOR, Ki12, readInt8, this.coS.bS(this.coS.hr(readInt8).cpO, this.coV.readInt())));
                    j2 = j3 - ((long) ((this.coW + 4) + 4));
                    break;
                case 144:
                    j2 = j3 - ((long) a(k.UNREACHABLE));
                    break;
                case 195:
                    System.err.println("+--- PRIMITIVE ARRAY NODATA DUMP");
                    Kk();
                    throw new IllegalArgumentException("Don't know how to load a nodata array");
                case 254:
                    this.coS.g(this.coV.readInt(), this.coX.get(Ki()));
                    j2 = j3 - ((long) (this.coW + 4));
                    break;
                case 255:
                    j2 = j3 - ((long) a(k.UNKNOWN));
                    break;
                default:
                    throw new IllegalArgumentException("loadHeapDump loop with unknown tag " + readUnsignedByte + " with " + this.coV.Kq() + " bytes possibly remaining");
            }
        }
    }

    private int a(k kVar) {
        this.coS.a(new j(kVar, Ki()));
        return this.coW;
    }

    private int Kk() {
        long Ki = Ki();
        n hq = this.coS.hq(this.coV.readInt());
        int readInt = this.coV.readInt();
        p hu = p.hu(readUnsignedByte());
        int b2 = this.coS.b(hu);
        this.coS.a(Ki, new a(Ki, hq, hu, readInt, this.coV.position()));
        int i2 = readInt * b2;
        aQ((long) i2);
        return i2 + this.coW + 4 + 4 + 1;
    }

    private void aQ(long j2) {
        this.coV.aT(this.coV.position() + j2);
    }
}
