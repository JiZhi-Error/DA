package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.s;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;
import java.util.zip.Adler32;

public final class i {
    static final short[] Sgj = new short[0];
    public final s Sgk = new s();
    private final f Sgl = new f(this, (byte) 0);
    private final g Sgm = new g(this, (byte) 0);
    private final h Sgn = new h(this, (byte) 0);
    private final d Sgo = new d(this, (byte) 0);
    private final b Sgp = new b(this, (byte) 0);
    private final c Sgq = new c(this, (byte) 0);
    private final a Sgr = new a(this, (byte) 0);
    private int Sgs = 0;
    public ByteBuffer aKP;
    private byte[] yRs = null;

    public i(int i2) {
        this.aKP = ByteBuffer.wrap(new byte[i2]);
        this.aKP.order(ByteOrder.LITTLE_ENDIAN);
        this.Sgk.fileSize = i2;
    }

    public i(InputStream inputStream) {
        char c2 = 65535;
        this.aKP = ByteBuffer.wrap(com.tencent.tinker.a.a.b.d.c(inputStream, 0));
        this.aKP.order(ByteOrder.LITTLE_ENDIAN);
        s sVar = this.Sgk;
        e a2 = a(sVar.SgE);
        byte[] arM = a2.arM(8);
        if (arM.length == 8 && arM[0] == 100 && arM[1] == 101 && arM[2] == 120 && arM[3] == 10 && arM[7] == 0) {
            String sb = new StringBuilder().append((char) arM[4]).append((char) arM[5]).append((char) arM[6]).toString();
            if (sb.equals("036")) {
                c2 = 14;
            } else if (sb.equals("035")) {
                c2 = '\r';
            }
        }
        if (c2 != '\r') {
            throw new j("Unexpected magic: " + Arrays.toString(arM));
        }
        sVar.jvw = a2.aKP.getInt();
        sVar.yRs = a2.arM(20);
        sVar.fileSize = a2.aKP.getInt();
        int i2 = a2.aKP.getInt();
        if (i2 != 112) {
            throw new j("Unexpected header: 0x" + Integer.toHexString(i2));
        }
        int i3 = a2.aKP.getInt();
        if (i3 != 305419896) {
            throw new j("Unexpected endian tag: 0x" + Integer.toHexString(i3));
        }
        sVar.SgX = a2.aKP.getInt();
        sVar.SgY = a2.aKP.getInt();
        sVar.SgL.off = a2.aKP.getInt();
        if (sVar.SgL.off == 0) {
            throw new j("Cannot merge dex files that do not contain a map");
        }
        sVar.SgF.size = a2.aKP.getInt();
        sVar.SgF.off = a2.aKP.getInt();
        sVar.SgG.size = a2.aKP.getInt();
        sVar.SgG.off = a2.aKP.getInt();
        sVar.SgH.size = a2.aKP.getInt();
        sVar.SgH.off = a2.aKP.getInt();
        sVar.SgI.size = a2.aKP.getInt();
        sVar.SgI.off = a2.aKP.getInt();
        sVar.SgJ.size = a2.aKP.getInt();
        sVar.SgJ.off = a2.aKP.getInt();
        sVar.SgK.size = a2.aKP.getInt();
        sVar.SgK.off = a2.aKP.getInt();
        sVar.dataSize = a2.aKP.getInt();
        sVar.SgZ = a2.aKP.getInt();
        sVar.a(arH(sVar.SgL.off));
        sVar.hoR();
    }

    /* access modifiers changed from: private */
    public static void mB(int i2, int i3) {
        if (i2 < 0 || i2 >= i3) {
            throw new IndexOutOfBoundsException("index:" + i2 + ", length=" + i3);
        }
    }

    public final e arH(int i2) {
        if (i2 < 0 || i2 >= this.aKP.capacity()) {
            throw new IllegalArgumentException("position=" + i2 + " length=" + this.aKP.capacity());
        }
        ByteBuffer duplicate = this.aKP.duplicate();
        duplicate.order(ByteOrder.LITTLE_ENDIAN);
        duplicate.position(i2);
        duplicate.limit(this.aKP.capacity());
        return new e(this, "temp-section", duplicate, (byte) 0);
    }

    public final e a(s.a aVar) {
        int i2 = aVar.off;
        if (i2 < 0 || i2 >= this.aKP.capacity()) {
            throw new IllegalArgumentException("position=" + i2 + " length=" + this.aKP.capacity());
        }
        ByteBuffer duplicate = this.aKP.duplicate();
        duplicate.order(ByteOrder.LITTLE_ENDIAN);
        duplicate.position(i2);
        duplicate.limit(i2 + aVar.byteCount);
        return new e(this, "section", duplicate, (byte) 0);
    }

    public final byte[] Ea(boolean z) {
        if (this.yRs != null && !z) {
            return this.yRs;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            byte[] bArr = new byte[8192];
            ByteBuffer duplicate = this.aKP.duplicate();
            duplicate.limit(duplicate.capacity());
            duplicate.position(32);
            while (duplicate.hasRemaining()) {
                int min = Math.min(8192, duplicate.remaining());
                duplicate.get(bArr, 0, min);
                instance.update(bArr, 0, min);
            }
            byte[] digest = instance.digest();
            this.yRs = digest;
            return digest;
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError();
        }
    }

    public final void hot() {
        arH(12).write(Ea(true));
        e arH = arH(8);
        Adler32 adler32 = new Adler32();
        byte[] bArr = new byte[8192];
        ByteBuffer duplicate = this.aKP.duplicate();
        duplicate.limit(duplicate.capacity());
        duplicate.position(12);
        while (duplicate.hasRemaining()) {
            int min = Math.min(8192, duplicate.remaining());
            duplicate.get(bArr, 0, min);
            adler32.update(bArr, 0, min);
        }
        arH.writeInt((int) adler32.getValue());
    }

    public final int arI(int i2) {
        mB(i2, this.Sgk.SgG.size);
        return this.aKP.getInt(this.Sgk.SgG.off + (i2 * 4));
    }

    public final class e extends com.tencent.tinker.a.a.a.a {
        private final String name;

        /* synthetic */ e(i iVar, String str, ByteBuffer byteBuffer, byte b2) {
            this(str, byteBuffer);
        }

        private e(String str, ByteBuffer byteBuffer) {
            super(byteBuffer);
            this.name = str;
        }

        @Override // com.tencent.tinker.a.a.a.a
        public final r hou() {
            a(i.this.Sgk.SgR, false);
            return super.hou();
        }

        @Override // com.tencent.tinker.a.a.a.a
        public final t hov() {
            a(i.this.Sgk.SgM, false);
            return super.hov();
        }

        @Override // com.tencent.tinker.a.a.a.a
        public final n how() {
            a(i.this.Sgk.SgI, false);
            return super.how();
        }

        @Override // com.tencent.tinker.a.a.a.a
        public final p hox() {
            a(i.this.Sgk.SgJ, false);
            return super.hox();
        }

        @Override // com.tencent.tinker.a.a.a.a
        public final q hoy() {
            a(i.this.Sgk.SgH, false);
            return super.hoy();
        }

        @Override // com.tencent.tinker.a.a.a.a
        public final f hoz() {
            a(i.this.Sgk.SgK, false);
            return super.hoz();
        }

        @Override // com.tencent.tinker.a.a.a.a
        public final g hoA() {
            a(i.this.Sgk.SgQ, false);
            return super.hoA();
        }

        @Override // com.tencent.tinker.a.a.a.a
        public final h hoB() {
            a(i.this.Sgk.SgS, false);
            return super.hoB();
        }

        @Override // com.tencent.tinker.a.a.a.a
        public final e hoC() {
            a(i.this.Sgk.SgP, false);
            return super.hoC();
        }

        @Override // com.tencent.tinker.a.a.a.a
        public final a hoD() {
            a(i.this.Sgk.SgT, false);
            return super.hoD();
        }

        @Override // com.tencent.tinker.a.a.a.a
        public final b hoE() {
            a(i.this.Sgk.SgO, false);
            return super.hoE();
        }

        @Override // com.tencent.tinker.a.a.a.a
        public final c hoF() {
            a(i.this.Sgk.SgN, false);
            return super.hoF();
        }

        @Override // com.tencent.tinker.a.a.a.a
        public final d hoG() {
            a(i.this.Sgk.SgV, false);
            return super.hoG();
        }

        @Override // com.tencent.tinker.a.a.a.a
        public final k hoH() {
            a(i.this.Sgk.SgU, false);
            return super.hoH();
        }

        private void a(s.a aVar, boolean z) {
            if (!aVar.Shb) {
                return;
            }
            if (z) {
                hoW();
            } else {
                hoV();
            }
        }

        @Override // com.tencent.tinker.a.a.a.a
        public final int a(r rVar) {
            a(i.this.Sgk.SgR, true);
            return super.a(rVar);
        }

        @Override // com.tencent.tinker.a.a.a.a
        public final int a(t tVar) {
            a(i.this.Sgk.SgM, true);
            return super.a(tVar);
        }

        @Override // com.tencent.tinker.a.a.a.a
        public final int a(n nVar) {
            a(i.this.Sgk.SgI, true);
            return super.a(nVar);
        }

        @Override // com.tencent.tinker.a.a.a.a
        public final int a(p pVar) {
            a(i.this.Sgk.SgJ, true);
            return super.a(pVar);
        }

        @Override // com.tencent.tinker.a.a.a.a
        public final int a(q qVar) {
            a(i.this.Sgk.SgH, true);
            return super.a(qVar);
        }

        @Override // com.tencent.tinker.a.a.a.a
        public final int b(f fVar) {
            a(i.this.Sgk.SgK, true);
            return super.b(fVar);
        }

        @Override // com.tencent.tinker.a.a.a.a
        public final int b(g gVar) {
            a(i.this.Sgk.SgQ, true);
            return super.b(gVar);
        }

        @Override // com.tencent.tinker.a.a.a.a
        public final int b(h hVar) {
            a(i.this.Sgk.SgS, true);
            return super.b(hVar);
        }

        @Override // com.tencent.tinker.a.a.a.a
        public final int b(e eVar) {
            a(i.this.Sgk.SgP, true);
            return super.b(eVar);
        }

        @Override // com.tencent.tinker.a.a.a.a
        public final int b(a aVar) {
            a(i.this.Sgk.SgT, true);
            return super.b(aVar);
        }

        @Override // com.tencent.tinker.a.a.a.a
        public final int b(b bVar) {
            a(i.this.Sgk.SgO, true);
            return super.b(bVar);
        }

        @Override // com.tencent.tinker.a.a.a.a
        public final int b(c cVar) {
            a(i.this.Sgk.SgN, true);
            return super.b(cVar);
        }

        @Override // com.tencent.tinker.a.a.a.a
        public final int b(d dVar) {
            a(i.this.Sgk.SgV, true);
            return super.b(dVar);
        }

        @Override // com.tencent.tinker.a.a.a.a
        public final int a(k kVar) {
            a(i.this.Sgk.SgU, true);
            return super.a(kVar);
        }
    }

    /* access modifiers changed from: package-private */
    public final class f extends AbstractList<String> implements RandomAccess {
        private f() {
        }

        /* synthetic */ f(i iVar, byte b2) {
            this();
        }

        /* renamed from: QW */
        public final String get(int i2) {
            i.mB(i2, i.this.Sgk.SgF.size);
            return i.this.arH(i.this.arH(i.this.Sgk.SgF.off + (i2 * 4)).aKP.getInt()).hou().value;
        }

        public final int size() {
            return i.this.Sgk.SgF.size;
        }
    }

    final class g extends AbstractList<Integer> implements RandomAccess {
        private g() {
        }

        /* synthetic */ g(i iVar, byte b2) {
            this();
        }

        public final int size() {
            return i.this.Sgk.SgG.size;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.List, java.util.AbstractList
        public final /* synthetic */ Integer get(int i2) {
            return Integer.valueOf(i.this.arI(i2));
        }
    }

    final class h extends AbstractList<String> implements RandomAccess {
        private h() {
        }

        /* synthetic */ h(i iVar, byte b2) {
            this();
        }

        public final int size() {
            return i.this.Sgk.SgG.size;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.List, java.util.AbstractList
        public final /* synthetic */ String get(int i2) {
            return i.this.Sgl.get(i.this.arI(i2));
        }
    }

    final class d extends AbstractList<q> implements RandomAccess {
        private d() {
        }

        /* synthetic */ d(i iVar, byte b2) {
            this();
        }

        public final int size() {
            return i.this.Sgk.SgH.size;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.List, java.util.AbstractList
        public final /* synthetic */ q get(int i2) {
            i.mB(i2, i.this.Sgk.SgH.size);
            return i.this.arH(i.this.Sgk.SgH.off + (i2 * 12)).hoy();
        }
    }

    final class b extends AbstractList<n> implements RandomAccess {
        private b() {
        }

        /* synthetic */ b(i iVar, byte b2) {
            this();
        }

        public final int size() {
            return i.this.Sgk.SgI.size;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.List, java.util.AbstractList
        public final /* synthetic */ n get(int i2) {
            i.mB(i2, i.this.Sgk.SgI.size);
            return i.this.arH(i.this.Sgk.SgI.off + (i2 * 8)).how();
        }
    }

    final class c extends AbstractList<p> implements RandomAccess {
        private c() {
        }

        /* synthetic */ c(i iVar, byte b2) {
            this();
        }

        public final int size() {
            return i.this.Sgk.SgJ.size;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.List, java.util.AbstractList
        public final /* synthetic */ p get(int i2) {
            i.mB(i2, i.this.Sgk.SgJ.size);
            return i.this.arH(i.this.Sgk.SgJ.off + (i2 * 8)).hox();
        }
    }

    final class a extends AbstractList<f> implements RandomAccess {
        private a() {
        }

        /* synthetic */ a(i iVar, byte b2) {
            this();
        }

        public final int size() {
            return i.this.Sgk.SgK.size;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.List, java.util.AbstractList
        public final /* synthetic */ f get(int i2) {
            i.mB(i2, i.this.Sgk.SgK.size);
            return i.this.arH(i.this.Sgk.SgK.off + (i2 * 32)).hoz();
        }
    }
}
