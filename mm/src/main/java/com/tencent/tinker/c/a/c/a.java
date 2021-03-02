package com.tencent.tinker.c.a.c;

import com.tencent.tinker.a.a.b.b;
import com.tencent.tinker.a.a.e;
import com.tencent.tinker.a.a.j;
import com.tencent.tinker.a.a.l;
import com.tencent.tinker.a.a.m;
import com.tencent.tinker.a.a.o;

public abstract class a {
    public abstract int asg(int i2);

    public abstract int ash(int i2);

    public abstract int asi(int i2);

    public abstract int asj(int i2);

    public abstract int ask(int i2);

    public abstract int asl(int i2);

    public abstract int asm(int i2);

    public abstract int asn(int i2);

    public abstract int aso(int i2);

    public abstract int asp(int i2);

    public abstract int asq(int i2);

    public abstract int asr(int i2);

    public abstract int ass(int i2);

    public abstract int ast(int i2);

    public final e.a[] b(e.a[] aVarArr) {
        e.a[] aVarArr2 = new e.a[aVarArr.length];
        for (int i2 = 0; i2 < aVarArr.length; i2++) {
            e.a aVar = aVarArr[i2];
            aVarArr2[i2] = new e.a(asj(aVar.SfI), aVar.SfJ);
        }
        return aVarArr2;
    }

    public final e.b[] b(e.b[] bVarArr) {
        e.b[] bVarArr2 = new e.b[bVarArr.length];
        for (int i2 = 0; i2 < bVarArr.length; i2++) {
            e.b bVar = bVarArr[i2];
            bVarArr2[i2] = new e.b(ask(bVar.SfK), bVar.SfJ, ast(bVar.SfL));
        }
        return bVarArr2;
    }

    /* renamed from: com.tencent.tinker.c.a.c.a$a  reason: collision with other inner class name */
    public final class C2213a {
        private final b SiU;

        public C2213a(b bVar) {
            this.SiU = bVar;
        }

        private void a(m mVar) {
            int i2 = 0;
            switch (mVar.hoI()) {
                case 0:
                    l.a(this.SiU, 0, (long) mVar.readByte());
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
                    throw new j("Unexpected type: " + Integer.toHexString(mVar.hoI()));
                case 2:
                    l.a(this.SiU, 2, (long) mVar.readShort());
                    return;
                case 3:
                    l.b(this.SiU, 3, (long) mVar.readChar());
                    return;
                case 4:
                    l.a(this.SiU, 4, (long) mVar.readInt());
                    return;
                case 6:
                    l.a(this.SiU, 6, mVar.readLong());
                    return;
                case 16:
                    l.c(this.SiU, 16, ((long) Float.floatToIntBits(mVar.readFloat())) << 32);
                    return;
                case 17:
                    l.c(this.SiU, 17, Double.doubleToLongBits(mVar.readDouble()));
                    return;
                case 23:
                    l.b(this.SiU, 23, (long) a.this.asg(mVar.hoM()));
                    return;
                case 24:
                    l.b(this.SiU, 24, (long) a.this.ash(mVar.hoN()));
                    return;
                case 25:
                    l.b(this.SiU, 25, (long) a.this.asj(mVar.hoO()));
                    return;
                case 26:
                    l.b(this.SiU, 26, (long) a.this.ask(mVar.hoP()));
                    return;
                case 27:
                    l.b(this.SiU, 27, (long) a.this.asj(mVar.zd()));
                    return;
                case 28:
                    mJ(28, 0);
                    c(mVar);
                    return;
                case 29:
                    mJ(29, 0);
                    b(mVar);
                    return;
                case 30:
                    mVar.hoQ();
                    mJ(30, 0);
                    return;
                case 31:
                    if (mVar.readBoolean()) {
                        i2 = 1;
                    }
                    mJ(31, i2);
                    return;
            }
        }

        public final void b(m mVar) {
            int hoK = mVar.hoK();
            o.a(this.SiU, a.this.ash(mVar.Sgw));
            o.a(this.SiU, hoK);
            for (int i2 = 0; i2 < hoK; i2++) {
                o.a(this.SiU, a.this.asg(mVar.hoL()));
                a(mVar);
            }
        }

        public final void c(m mVar) {
            int hoJ = mVar.hoJ();
            o.a(this.SiU, hoJ);
            for (int i2 = 0; i2 < hoJ; i2++) {
                a(mVar);
            }
        }

        private void mJ(int i2, int i3) {
            this.SiU.writeByte((i3 << 5) | i2);
        }
    }
}
