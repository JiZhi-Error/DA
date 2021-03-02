package com.tencent.tinker.a.a.a;

import com.tencent.smtt.export.external.interfaces.ISelectionInterface;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tinker.a.a.b.b;
import com.tencent.tinker.a.a.c;
import com.tencent.tinker.a.a.d;
import com.tencent.tinker.a.a.e;
import com.tencent.tinker.a.a.f;
import com.tencent.tinker.a.a.g;
import com.tencent.tinker.a.a.h;
import com.tencent.tinker.a.a.j;
import com.tencent.tinker.a.a.k;
import com.tencent.tinker.a.a.m;
import com.tencent.tinker.a.a.n;
import com.tencent.tinker.a.a.o;
import com.tencent.tinker.a.a.p;
import com.tencent.tinker.a.a.q;
import com.tencent.tinker.a.a.r;
import com.tencent.tinker.a.a.t;
import java.io.UTFDataFormatException;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class a implements com.tencent.tinker.a.a.b.a, b {
    private static final short[] Sgj = new short[0];
    private static final g.b[] She = new g.b[0];
    private static final g.a[] Shf = new g.a[0];
    private int Shg;
    private boolean Shh;
    public ByteBuffer aKP;

    public a() {
        this.aKP = ByteBuffer.allocate(512);
        this.aKP.order(ByteOrder.LITTLE_ENDIAN);
        this.Shg = this.aKP.position();
        this.aKP.limit(this.aKP.capacity());
        this.Shh = true;
    }

    public a(ByteBuffer byteBuffer) {
        this.aKP = byteBuffer;
        this.aKP.order(ByteOrder.LITTLE_ENDIAN);
        this.Shg = byteBuffer.limit();
        this.Shh = false;
    }

    private void arL(int i2) {
        if (this.aKP.position() + i2 > this.aKP.limit() && this.Shh) {
            byte[] array = this.aKP.array();
            byte[] bArr = new byte[(array.length + i2 + (array.length >> 1))];
            System.arraycopy(array, 0, bArr, 0, this.aKP.position());
            int position = this.aKP.position();
            this.aKP = ByteBuffer.wrap(bArr);
            this.aKP.order(ByteOrder.LITTLE_ENDIAN);
            this.aKP.position(position);
            this.aKP.limit(this.aKP.capacity());
        }
    }

    @Override // com.tencent.tinker.a.a.b.a
    public final byte readByte() {
        return this.aKP.get();
    }

    public final byte[] arM(int i2) {
        byte[] bArr = new byte[i2];
        this.aKP.get(bArr);
        return bArr;
    }

    private short[] arN(int i2) {
        if (i2 == 0) {
            return Sgj;
        }
        short[] sArr = new short[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            sArr[i3] = this.aKP.getShort();
        }
        return sArr;
    }

    private int hoS() {
        return o.b(this);
    }

    private int hoT() {
        return o.b(this) - 1;
    }

    private int hoU() {
        return o.a(this);
    }

    public r hou() {
        int i2 = 0;
        int position = this.aKP.position();
        try {
            int b2 = o.b(this);
            char[] cArr = new char[b2];
            while (true) {
                char readByte = (char) (readByte() & 255);
                if (readByte == 0) {
                    String str = new String(cArr, 0, i2);
                    if (str.length() == b2) {
                        return new r(position, str);
                    }
                    throw new j("Declared length " + b2 + " doesn't match decoded length of " + str.length());
                }
                cArr[i2] = readByte;
                if (readByte < 128) {
                    i2++;
                } else if ((readByte & 224) == 192) {
                    int readByte2 = readByte() & 255;
                    if ((readByte2 & 192) != 128) {
                        throw new UTFDataFormatException("bad second byte");
                    }
                    cArr[i2] = (char) (((readByte & 31) << 6) | (readByte2 & 63));
                    i2++;
                } else if ((readByte & 240) == 224) {
                    int readByte3 = readByte() & 255;
                    int readByte4 = readByte() & 255;
                    if ((readByte3 & 192) == 128 && (readByte4 & 192) == 128) {
                        cArr[i2] = (char) (((readByte & 15) << 12) | ((readByte3 & 63) << 6) | (readByte4 & 63));
                        i2++;
                    }
                } else {
                    throw new UTFDataFormatException("bad byte");
                }
            }
            throw new UTFDataFormatException("bad second or third byte");
        } catch (UTFDataFormatException e2) {
            throw new j(e2);
        }
    }

    public t hov() {
        return new t(this.aKP.position(), arN(this.aKP.getInt()));
    }

    public n how() {
        return new n(this.aKP.position(), readUnsignedShort(), readUnsignedShort(), this.aKP.getInt());
    }

    public p hox() {
        return new p(this.aKP.position(), readUnsignedShort(), readUnsignedShort(), this.aKP.getInt());
    }

    public q hoy() {
        return new q(this.aKP.position(), this.aKP.getInt(), this.aKP.getInt(), this.aKP.getInt());
    }

    public g hoA() {
        g.b[] bVarArr;
        g.a[] aVarArr;
        int i2;
        int position = this.aKP.position();
        int readUnsignedShort = readUnsignedShort();
        int readUnsignedShort2 = readUnsignedShort();
        int readUnsignedShort3 = readUnsignedShort();
        int readUnsignedShort4 = readUnsignedShort();
        int i3 = this.aKP.getInt();
        short[] arN = arN(this.aKP.getInt());
        if (readUnsignedShort4 > 0) {
            if ((arN.length & 1) == 1) {
                skip(2);
            }
            int position2 = this.aKP.position();
            skip(readUnsignedShort4 * 8);
            int position3 = this.aKP.position();
            int b2 = o.b(this);
            aVarArr = new g.a[b2];
            for (int i4 = 0; i4 < b2; i4++) {
                int position4 = this.aKP.position() - position3;
                int a2 = o.a(this);
                int abs = Math.abs(a2);
                int[] iArr = new int[abs];
                int[] iArr2 = new int[abs];
                for (int i5 = 0; i5 < abs; i5++) {
                    iArr[i5] = o.b(this);
                    iArr2[i5] = o.b(this);
                }
                if (a2 <= 0) {
                    i2 = o.b(this);
                } else {
                    i2 = -1;
                }
                aVarArr[i4] = new g.a(iArr, iArr2, i2, position4);
            }
            int position5 = this.aKP.position();
            this.aKP.position(position2);
            bVarArr = new g.b[readUnsignedShort4];
            for (int i6 = 0; i6 < readUnsignedShort4; i6++) {
                int i7 = this.aKP.getInt();
                int readUnsignedShort5 = readUnsignedShort();
                int readUnsignedShort6 = readUnsignedShort();
                for (int i8 = 0; i8 < aVarArr.length; i8++) {
                    if (aVarArr[i8].offset == readUnsignedShort6) {
                        bVarArr[i6] = new g.b(i7, readUnsignedShort5, i8);
                    }
                }
                throw new IllegalArgumentException();
            }
            this.aKP.position(position5);
        } else {
            bVarArr = She;
            aVarArr = Shf;
        }
        return new g(position, readUnsignedShort, readUnsignedShort2, readUnsignedShort3, i3, arN, bVarArr, aVarArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0050 A[SYNTHETIC, Splitter:B:18:0x0050] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.tencent.tinker.a.a.h hoB() {
        /*
        // Method dump skipped, instructions count: 172
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.a.a.a.a.hoB():com.tencent.tinker.a.a.h");
    }

    public e hoC() {
        return new e(this.aKP.position(), arO(o.b(this)), arO(o.b(this)), arP(o.b(this)), arP(o.b(this)));
    }

    private e.a[] arO(int i2) {
        e.a[] aVarArr = new e.a[i2];
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int b2 = o.b(this) + i4;
            aVarArr[i3] = new e.a(b2, o.b(this));
            i3++;
            i4 = b2;
        }
        return aVarArr;
    }

    private e.b[] arP(int i2) {
        e.b[] bVarArr = new e.b[i2];
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int b2 = o.b(this) + i4;
            bVarArr[i3] = new e.b(b2, o.b(this), o.b(this));
            i3++;
            i4 = b2;
        }
        return bVarArr;
    }

    private byte[] arQ(int i2) {
        byte[] bArr = new byte[(this.aKP.position() - i2)];
        this.aKP.position(i2);
        this.aKP.get(bArr);
        return bArr;
    }

    public com.tencent.tinker.a.a.a hoD() {
        int position = this.aKP.position();
        byte b2 = this.aKP.get();
        int position2 = this.aKP.position();
        new m(this, 29).skipValue();
        return new com.tencent.tinker.a.a.a(position, b2, new k(position2, arQ(position2)));
    }

    public com.tencent.tinker.a.a.b hoE() {
        int position = this.aKP.position();
        int i2 = this.aKP.getInt();
        int[] iArr = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i3] = this.aKP.getInt();
        }
        return new com.tencent.tinker.a.a.b(position, iArr);
    }

    public c hoF() {
        int position = this.aKP.position();
        int i2 = this.aKP.getInt();
        int[] iArr = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i3] = this.aKP.getInt();
        }
        return new c(position, iArr);
    }

    public d hoG() {
        int position = this.aKP.position();
        int i2 = this.aKP.getInt();
        int i3 = this.aKP.getInt();
        int i4 = this.aKP.getInt();
        int i5 = this.aKP.getInt();
        int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, i3, 2);
        for (int i6 = 0; i6 < i3; i6++) {
            iArr[i6][0] = this.aKP.getInt();
            iArr[i6][1] = this.aKP.getInt();
        }
        int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, i4, 2);
        for (int i7 = 0; i7 < i4; i7++) {
            iArr2[i7][0] = this.aKP.getInt();
            iArr2[i7][1] = this.aKP.getInt();
        }
        int[][] iArr3 = (int[][]) Array.newInstance(Integer.TYPE, i5, 2);
        for (int i8 = 0; i8 < i5; i8++) {
            iArr3[i8][0] = this.aKP.getInt();
            iArr3[i8][1] = this.aKP.getInt();
        }
        return new d(position, i2, iArr, iArr2, iArr3);
    }

    public k hoH() {
        int position = this.aKP.position();
        new m(this, 28).skipValue();
        return new k(position, arQ(position));
    }

    private void skip(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        this.aKP.position(this.aKP.position() + i2);
    }

    public final void hoV() {
        this.aKP.position((this.aKP.position() + 3) & -4);
    }

    public final void hoW() {
        arL((((this.aKP.position() + 3) & -4) - this.aKP.position()) * 1);
        while ((this.aKP.position() & 3) != 0) {
            this.aKP.put((byte) 0);
        }
        if (this.aKP.position() > this.Shg) {
            this.Shg = this.aKP.position();
        }
    }

    @Override // com.tencent.tinker.a.a.b.b
    public final void writeByte(int i2) {
        arL(1);
        this.aKP.put((byte) i2);
        if (this.aKP.position() > this.Shg) {
            this.Shg = this.aKP.position();
        }
    }

    public final void writeShort(short s) {
        arL(2);
        this.aKP.putShort(s);
        if (this.aKP.position() > this.Shg) {
            this.Shg = this.aKP.position();
        }
    }

    private void arR(int i2) {
        short s = (short) i2;
        if (i2 != (65535 & s)) {
            throw new IllegalArgumentException("Expected an unsigned short: ".concat(String.valueOf(i2)));
        }
        writeShort(s);
    }

    public final void writeInt(int i2) {
        arL(4);
        this.aKP.putInt(i2);
        if (this.aKP.position() > this.Shg) {
            this.Shg = this.aKP.position();
        }
    }

    public final void write(byte[] bArr) {
        arL(bArr.length * 1);
        this.aKP.put(bArr);
        if (this.aKP.position() > this.Shg) {
            this.Shg = this.aKP.position();
        }
    }

    public int a(r rVar) {
        int i2;
        int position = this.aKP.position();
        try {
            o.a(this, rVar.value.length());
            String str = rVar.value;
            long j2 = 0;
            int length = str.length();
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = str.charAt(i3);
                if (charAt != 0 && charAt <= 127) {
                    j2++;
                } else if (charAt <= 2047) {
                    j2 += 2;
                } else {
                    j2 += 3;
                }
            }
            byte[] bArr = new byte[((int) j2)];
            int length2 = str.length();
            int i4 = 0;
            int i5 = 0;
            while (i4 < length2) {
                char charAt2 = str.charAt(i4);
                if (charAt2 != 0 && charAt2 <= 127) {
                    i2 = i5 + 1;
                    bArr[i5] = (byte) charAt2;
                } else if (charAt2 <= 2047) {
                    int i6 = i5 + 1;
                    bArr[i5] = (byte) (((charAt2 >> 6) & 31) | 192);
                    i2 = i6 + 1;
                    bArr[i6] = (byte) ((charAt2 & '?') | 128);
                } else {
                    int i7 = i5 + 1;
                    bArr[i5] = (byte) (((charAt2 >> '\f') & 15) | TbsListener.ErrorCode.EXCEED_INCR_UPDATE);
                    int i8 = i7 + 1;
                    bArr[i7] = (byte) (((charAt2 >> 6) & 63) | 128);
                    i2 = i8 + 1;
                    bArr[i8] = (byte) ((charAt2 & '?') | 128);
                }
                i4++;
                i5 = i2;
            }
            write(bArr);
            writeByte(0);
            return position;
        } catch (UTFDataFormatException e2) {
            throw new AssertionError(e2);
        }
    }

    public int a(t tVar) {
        int position = this.aKP.position();
        short[] sArr = tVar.Shd;
        writeInt(sArr.length);
        for (short s : sArr) {
            writeShort(s);
        }
        return position;
    }

    public int a(n nVar) {
        int position = this.aKP.position();
        arR(nVar.Sgy);
        arR(nVar.SfM);
        writeInt(nVar.Sgz);
        return position;
    }

    public int a(p pVar) {
        int position = this.aKP.position();
        arR(pVar.Sgy);
        arR(pVar.SgA);
        writeInt(pVar.Sgz);
        return position;
    }

    public int a(q qVar) {
        int position = this.aKP.position();
        writeInt(qVar.SgB);
        writeInt(qVar.SgC);
        writeInt(qVar.SgD);
        return position;
    }

    public int b(f fVar) {
        int position = this.aKP.position();
        writeInt(fVar.SfM);
        writeInt(fVar.SfJ);
        writeInt(fVar.SfN);
        writeInt(fVar.SfO);
        writeInt(fVar.SfP);
        writeInt(fVar.SfQ);
        writeInt(fVar.SfR);
        writeInt(fVar.SfS);
        return position;
    }

    public int b(g gVar) {
        int position = this.aKP.position();
        arR(gVar.SfT);
        arR(gVar.SfU);
        arR(gVar.SfV);
        arR(gVar.SfY.length);
        writeInt(gVar.SfW);
        writeInt(gVar.SfX.length);
        short[] sArr = gVar.SfX;
        arL(sArr.length * 2);
        for (short s : sArr) {
            writeShort(s);
        }
        if (this.aKP.position() > this.Shg) {
            this.Shg = this.aKP.position();
        }
        if (gVar.SfY.length > 0) {
            if ((gVar.SfX.length & 1) == 1) {
                writeShort(0);
            }
            int position2 = this.aKP.position();
            int length = gVar.SfY.length * 8;
            arL(length * 1);
            skip(length);
            g.a[] aVarArr = gVar.SfZ;
            int position3 = this.aKP.position();
            o.a(this, aVarArr.length);
            int[] iArr = new int[aVarArr.length];
            for (int i2 = 0; i2 < aVarArr.length; i2++) {
                iArr[i2] = this.aKP.position() - position3;
                g.a aVar = aVarArr[i2];
                int i3 = aVar.Sgc;
                int[] iArr2 = aVar.Sga;
                int[] iArr3 = aVar.Sgb;
                if (i3 != -1) {
                    o.c(this, -iArr2.length);
                } else {
                    o.c(this, iArr2.length);
                }
                for (int i4 = 0; i4 < iArr2.length; i4++) {
                    o.a(this, iArr2[i4]);
                    o.a(this, iArr3[i4]);
                }
                if (i3 != -1) {
                    o.a(this, i3);
                }
            }
            int position4 = this.aKP.position();
            this.aKP.position(position2);
            g.b[] bVarArr = gVar.SfY;
            for (g.b bVar : bVarArr) {
                writeInt(bVar.Sgd);
                arR(bVar.Sge);
                arR(iArr[bVar.Sgf]);
            }
            this.aKP.position(position4);
        }
        return position;
    }

    public int b(h hVar) {
        int position = this.aKP.position();
        o.a(this, hVar.Sgg);
        int length = hVar.Sgh.length;
        o.a(this, length);
        for (int i2 = 0; i2 < length; i2++) {
            o.a(this, hVar.Sgh[i2] + 1);
        }
        write(hVar.Sgi);
        return position;
    }

    public int b(e eVar) {
        int position = this.aKP.position();
        o.a(this, eVar.SfE.length);
        o.a(this, eVar.SfF.length);
        o.a(this, eVar.SfG.length);
        o.a(this, eVar.SfH.length);
        a(eVar.SfE);
        a(eVar.SfF);
        a(eVar.SfG);
        a(eVar.SfH);
        return position;
    }

    private void a(e.a[] aVarArr) {
        int length = aVarArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            e.a aVar = aVarArr[i2];
            o.a(this, aVar.SfI - i3);
            int i4 = aVar.SfI;
            o.a(this, aVar.SfJ);
            i2++;
            i3 = i4;
        }
    }

    private void a(e.b[] bVarArr) {
        int length = bVarArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            e.b bVar = bVarArr[i2];
            o.a(this, bVar.SfK - i3);
            int i4 = bVar.SfK;
            o.a(this, bVar.SfJ);
            o.a(this, bVar.SfL);
            i2++;
            i3 = i4;
        }
    }

    public int b(com.tencent.tinker.a.a.a aVar) {
        int position = this.aKP.position();
        writeByte(aVar.Sfw);
        a(aVar.Sfx);
        return position;
    }

    public int b(com.tencent.tinker.a.a.b bVar) {
        int position = this.aKP.position();
        writeInt(bVar.Sfy.length);
        for (int i2 : bVar.Sfy) {
            writeInt(i2);
        }
        return position;
    }

    public int b(c cVar) {
        int position = this.aKP.position();
        writeInt(cVar.Sfz.length);
        for (int i2 : cVar.Sfz) {
            writeInt(i2);
        }
        return position;
    }

    public int b(d dVar) {
        int position = this.aKP.position();
        writeInt(dVar.SfA);
        writeInt(dVar.SfB.length);
        writeInt(dVar.SfC.length);
        writeInt(dVar.SfD.length);
        int[][] iArr = dVar.SfB;
        for (int[] iArr2 : iArr) {
            writeInt(iArr2[0]);
            writeInt(iArr2[1]);
        }
        int[][] iArr3 = dVar.SfC;
        for (int[] iArr4 : iArr3) {
            writeInt(iArr4[0]);
            writeInt(iArr4[1]);
        }
        int[][] iArr5 = dVar.SfD;
        for (int[] iArr6 : iArr5) {
            writeInt(iArr6[0]);
            writeInt(iArr6[1]);
        }
        return position;
    }

    public int a(k kVar) {
        int position = this.aKP.position();
        write(kVar.data);
        return position;
    }

    private int readUnsignedShort() {
        return this.aKP.getShort() & ISelectionInterface.HELD_NOTHING;
    }

    public f hoz() {
        return new f(this.aKP.position(), this.aKP.getInt(), this.aKP.getInt(), this.aKP.getInt(), this.aKP.getInt(), this.aKP.getInt(), this.aKP.getInt(), this.aKP.getInt(), this.aKP.getInt());
    }
}
