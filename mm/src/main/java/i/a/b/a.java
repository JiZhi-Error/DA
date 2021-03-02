package i.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    i.a.a.a UoR = new i.a.a.a();
    i.a.c.b UoS = new i.a.c.b();
    short[] UoT = new short[192];
    short[] UoU = new short[12];
    short[] UoV = new short[12];
    short[] UoW = new short[12];
    short[] UoX = new short[12];
    short[] UoY = new short[192];
    i.a.c.a[] UoZ = new i.a.c.a[4];
    short[] Upa = new short[114];
    i.a.c.a Upb = new i.a.c.a(4);
    C2240a Upc = new C2240a();
    C2240a Upd = new C2240a();
    b Upe = new b();
    int Upf = -1;
    int Upg = -1;
    int Uph;

    /* access modifiers changed from: package-private */
    /* renamed from: i.a.b.a$a  reason: collision with other inner class name */
    public class C2240a {
        short[] Upi = new short[2];
        i.a.c.a[] Upj = new i.a.c.a[16];
        i.a.c.a[] Upk = new i.a.c.a[16];
        i.a.c.a Upl = new i.a.c.a(8);
        int Upm = 0;

        C2240a() {
            AppMethodBeat.i(155352);
            AppMethodBeat.o(155352);
        }

        public final void awr(int i2) {
            AppMethodBeat.i(155353);
            while (this.Upm < i2) {
                this.Upj[this.Upm] = new i.a.c.a(3);
                this.Upk[this.Upm] = new i.a.c.a(3);
                this.Upm++;
            }
            AppMethodBeat.o(155353);
        }

        public final void hRq() {
            AppMethodBeat.i(155354);
            i.a.c.b.c(this.Upi);
            for (int i2 = 0; i2 < this.Upm; i2++) {
                i.a.c.b.c(this.Upj[i2].Upu);
                i.a.c.b.c(this.Upk[i2].Upu);
            }
            i.a.c.b.c(this.Upl.Upu);
            AppMethodBeat.o(155354);
        }

        public final int a(i.a.c.b bVar, int i2) {
            int a2;
            AppMethodBeat.i(155355);
            if (bVar.g(this.Upi, 0) == 0) {
                int a3 = this.Upj[i2].a(bVar);
                AppMethodBeat.o(155355);
                return a3;
            }
            if (bVar.g(this.Upi, 1) == 0) {
                a2 = this.Upk[i2].a(bVar) + 8;
            } else {
                a2 = this.Upl.a(bVar) + 8 + 8;
            }
            AppMethodBeat.o(155355);
            return a2;
        }
    }

    /* access modifiers changed from: package-private */
    public class b {
        C2241a[] Upo;
        int Upp;
        int Upq;
        int Upr;

        b() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: i.a.b.a$b$a  reason: collision with other inner class name */
        public class C2241a {
            short[] Ups = new short[768];

            C2241a() {
                AppMethodBeat.i(155356);
                AppMethodBeat.o(155356);
            }
        }
    }

    public a() {
        AppMethodBeat.i(155357);
        for (int i2 = 0; i2 < 4; i2++) {
            this.UoZ[i2] = new i.a.c.a(6);
        }
        AppMethodBeat.o(155357);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:149:?, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(java.io.InputStream r20, java.io.OutputStream r21, long r22) {
        /*
        // Method dump skipped, instructions count: 869
        */
        throw new UnsupportedOperationException("Method not decompiled: i.a.b.a.a(java.io.InputStream, java.io.OutputStream, long):boolean");
    }

    public final boolean dz(byte[] bArr) {
        boolean z;
        AppMethodBeat.i(155359);
        int i2 = bArr[0] & 255;
        int i3 = i2 % 9;
        int i4 = i2 / 9;
        int i5 = i4 % 5;
        int i6 = i4 / 5;
        int i7 = 0;
        for (int i8 = 0; i8 < 4; i8++) {
            i7 += (bArr[i8 + 1] & 255) << (i8 * 8);
        }
        if (i3 > 8 || i5 > 4 || i6 > 4) {
            z = false;
        } else {
            b bVar = this.Upe;
            if (!(bVar.Upo != null && bVar.Upp == i3 && bVar.Upq == i5)) {
                bVar.Upq = i5;
                bVar.Upr = (1 << i5) - 1;
                bVar.Upp = i3;
                int i9 = 1 << (bVar.Upp + bVar.Upq);
                bVar.Upo = new b.C2241a[i9];
                for (int i10 = 0; i10 < i9; i10++) {
                    bVar.Upo[i10] = new b.C2241a();
                }
            }
            int i11 = 1 << i6;
            this.Upc.awr(i11);
            this.Upd.awr(i11);
            this.Uph = i11 - 1;
            z = true;
        }
        if (!z) {
            AppMethodBeat.o(155359);
            return false;
        } else if (i7 < 0) {
            AppMethodBeat.o(155359);
            return false;
        } else {
            if (this.Upf != i7) {
                this.Upf = i7;
                this.Upg = Math.max(this.Upf, 1);
                i.a.a.a aVar = this.UoR;
                int max = Math.max(this.Upg, 4096);
                if (aVar.UoN == null || aVar.UoO != max) {
                    aVar.UoN = new byte[max];
                }
                aVar.UoO = max;
                aVar.Ucm = 0;
                aVar.UoP = 0;
            }
            AppMethodBeat.o(155359);
            return true;
        }
    }
}
