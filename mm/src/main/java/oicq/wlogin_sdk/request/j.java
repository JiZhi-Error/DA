package oicq.wlogin_sdk.request;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.a.aa;
import oicq.wlogin_sdk.a.ae;
import oicq.wlogin_sdk.a.ag;
import oicq.wlogin_sdk.a.ah;
import oicq.wlogin_sdk.a.aj;
import oicq.wlogin_sdk.a.an;
import oicq.wlogin_sdk.a.b;
import oicq.wlogin_sdk.a.c;
import oicq.wlogin_sdk.a.f;
import oicq.wlogin_sdk.a.h;
import oicq.wlogin_sdk.a.i;
import oicq.wlogin_sdk.a.k;
import oicq.wlogin_sdk.a.r;
import oicq.wlogin_sdk.a.y;
import oicq.wlogin_sdk.tools.util;

public final class j extends d {
    public j(i iVar) {
        this.Ucx = 2064;
        this.Ucy = 9;
        this.UcA = iVar;
    }

    public final byte[] a(long j2, byte[] bArr, byte[] bArr2, byte[] bArr3, int i2, int i3, byte[] bArr4) {
        byte[] bArr5;
        AppMethodBeat.i(88080);
        int i4 = this.UcA.UcK;
        this.UcA._uin = j2;
        util.oF("IMEI", util.dw(this.UcA.UcL));
        byte[] bArr6 = this.UcA.UcC;
        byte[] bArr7 = this.UcA.UcL;
        byte[] hPA = this.UcA.UcF.hPA();
        byte[] bArr8 = this.UcA.UcP;
        an anVar = new an();
        b bVar = new b();
        h hVar = new h();
        r rVar = new r();
        c cVar = new c();
        i iVar = new i();
        oicq.wlogin_sdk.a.j jVar = new oicq.wlogin_sdk.a.j();
        k kVar = new k();
        f fVar = new f();
        y yVar = new y();
        aa aaVar = new aa();
        ae aeVar = new ae();
        ag agVar = new ag();
        ah ahVar = new ah();
        aj ajVar = new aj();
        byte[] a2 = anVar.a(522017402, i4, j2);
        byte[] g2 = bVar.g(j2, bArr);
        byte[] a3 = hVar.a(522017402, i4, j2, bArr2, bArr, bArr3, bArr6, this.UcA.UcX, this.UcA.UcL);
        this.UcA.Udb = super.dl(hVar.hPA());
        byte[] t = cVar.t(522017402, i4, 8256);
        byte[] hPD = iVar.hPD();
        byte[] nj = rVar.nj(i2, i3);
        byte[] ds = ahVar.ds(this.UcA.UcL);
        int i5 = 7;
        byte[] bArr9 = new byte[0];
        byte[] bArr10 = new byte[0];
        byte[] bArr11 = new byte[0];
        byte[] bArr12 = new byte[0];
        if (bArr4.length > 0) {
            bArr9 = jVar.dp(bArr4);
            i5 = 8;
        }
        if (bArr7.length > 0) {
            bArr10 = kVar.dq(bArr7);
        }
        byte[] a4 = agVar.a(bArr10, yVar.a(util.hPG(), util.hPH(), this.UcA.UcO, this.UcA.UcN, new byte[0], this.UcA.UcQ), aaVar.a(this.UcA.UcW, this.UcA.UcX, this.UcA.UcY, this.UcA.UcU, this.UcA.UcL), ajVar.a(522017402, this.UcA.UcS, this.UcA.UcT), this.UcA.UcC);
        byte[] dr = aeVar.dr(bArr8);
        int i6 = i5 + 1 + 1;
        if (hPA.length > 0) {
            bArr5 = fVar.m56do(hPA);
            i6++;
        } else {
            bArr5 = bArr11;
        }
        byte[] bArr13 = new byte[(a2.length + g2.length + a3.length + nj.length + t.length + hPD.length + bArr9.length + a4.length + bArr5.length + dr.length + 0 + ds.length)];
        System.arraycopy(a2, 0, bArr13, 0, a2.length);
        int length = a2.length + 0;
        System.arraycopy(g2, 0, bArr13, length, g2.length);
        int length2 = length + g2.length;
        System.arraycopy(a3, 0, bArr13, length2, a3.length);
        int length3 = length2 + a3.length;
        System.arraycopy(nj, 0, bArr13, length3, nj.length);
        int length4 = length3 + nj.length;
        System.arraycopy(t, 0, bArr13, length4, t.length);
        int length5 = length4 + t.length;
        System.arraycopy(hPD, 0, bArr13, length5, hPD.length);
        int length6 = length5 + hPD.length;
        System.arraycopy(bArr9, 0, bArr13, length6, bArr9.length);
        int length7 = bArr9.length + length6;
        System.arraycopy(a4, 0, bArr13, length7, a4.length);
        int length8 = length7 + a4.length;
        System.arraycopy(dr, 0, bArr13, length8, dr.length);
        int length9 = length8 + dr.length;
        System.arraycopy(bArr12, 0, bArr13, length9, 0);
        int i7 = length9 + 0;
        System.arraycopy(bArr5, 0, bArr13, i7, bArr5.length);
        System.arraycopy(ds, 0, bArr13, bArr5.length + i7, ds.length);
        a(this.Ucs, this.Ucx, j2, this.Ucu, this.Ucv, i4, this.Ucw, super.aa(bArr13, this.Ucy, i6));
        byte[] hPx = super.hPx();
        AppMethodBeat.o(88080);
        return hPx;
    }

    public final byte[] a(long j2, byte[] bArr, byte[] bArr2, int i2, int i3, byte[] bArr3) {
        byte[] bArr4;
        AppMethodBeat.i(88081);
        int i4 = this.UcA.UcK;
        this.UcA._uin = j2;
        byte[] dm = super.dm(bArr2);
        if (dm == null) {
            AppMethodBeat.o(88081);
            return null;
        }
        byte[] bArr5 = this.UcA.UcL;
        byte[] hPA = this.UcA.UcF.hPA();
        byte[] bArr6 = this.UcA.UcP;
        an anVar = new an();
        b bVar = new b();
        h hVar = new h();
        r rVar = new r();
        c cVar = new c();
        i iVar = new i();
        oicq.wlogin_sdk.a.j jVar = new oicq.wlogin_sdk.a.j();
        k kVar = new k();
        f fVar = new f();
        y yVar = new y();
        aa aaVar = new aa();
        ae aeVar = new ae();
        ag agVar = new ag();
        ah ahVar = new ah();
        aj ajVar = new aj();
        byte[] a2 = anVar.a(522017402, i4, j2);
        byte[] g2 = bVar.g(j2, bArr);
        this.UcA.Udb = super.dl(dm);
        int length = dm.length;
        if (hVar.Udg + length > hVar.Ucl) {
            hVar.Ucl = hVar.Udg + length + 128;
            byte[] bArr7 = new byte[hVar.Ucl];
            System.arraycopy(hVar.Ucr, 0, bArr7, 0, hVar.Udg);
            hVar.Ucr = bArr7;
        }
        hVar.Ucm = hVar.Udg + length;
        System.arraycopy(dm, 0, hVar.Ucr, hVar.Udg, length);
        hVar.Udh = length;
        util.ah(hVar.Ucr, 0, hVar.Ucx);
        util.ah(hVar.Ucr, 2, hVar.Udh);
        byte[] hPx = hVar.hPx();
        util.oF("req2 a1:", util.dw(hPx));
        byte[] t = cVar.t(522017402, i4, 8256);
        byte[] hPD = iVar.hPD();
        byte[] nj = rVar.nj(i2, i3);
        byte[] ds = ahVar.ds(this.UcA.UcL);
        int i5 = 7;
        byte[] bArr8 = new byte[0];
        byte[] bArr9 = new byte[0];
        byte[] bArr10 = new byte[0];
        byte[] bArr11 = new byte[0];
        if (bArr3.length > 0) {
            bArr8 = jVar.dp(bArr3);
            i5 = 8;
        }
        if (bArr5.length > 0) {
            bArr9 = kVar.dq(bArr5);
        }
        byte[] a3 = agVar.a(bArr9, yVar.a(util.hPG(), util.hPH(), this.UcA.UcO, this.UcA.UcN, new byte[0], this.UcA.UcQ), aaVar.a(this.UcA.UcW, this.UcA.UcX, this.UcA.UcY, this.UcA.UcU, this.UcA.UcL), ajVar.a(522017402, this.UcA.UcS, this.UcA.UcT), this.UcA.UcC);
        byte[] dr = aeVar.dr(bArr6);
        int i6 = i5 + 1 + 1;
        if (hPA.length > 0) {
            bArr4 = fVar.m56do(hPA);
            i6++;
        } else {
            bArr4 = bArr10;
        }
        byte[] bArr12 = new byte[(a2.length + g2.length + hPx.length + nj.length + t.length + hPD.length + bArr8.length + a3.length + bArr4.length + dr.length + 0 + ds.length)];
        System.arraycopy(a2, 0, bArr12, 0, a2.length);
        int length2 = a2.length + 0;
        System.arraycopy(g2, 0, bArr12, length2, g2.length);
        int length3 = length2 + g2.length;
        System.arraycopy(hPx, 0, bArr12, length3, hPx.length);
        int length4 = length3 + hPx.length;
        System.arraycopy(nj, 0, bArr12, length4, nj.length);
        int length5 = length4 + nj.length;
        System.arraycopy(t, 0, bArr12, length5, t.length);
        int length6 = length5 + t.length;
        System.arraycopy(hPD, 0, bArr12, length6, hPD.length);
        int length7 = length6 + hPD.length;
        System.arraycopy(bArr8, 0, bArr12, length7, bArr8.length);
        int length8 = bArr8.length + length7;
        System.arraycopy(a3, 0, bArr12, length8, a3.length);
        int length9 = length8 + a3.length;
        System.arraycopy(dr, 0, bArr12, length9, dr.length);
        int length10 = length9 + dr.length;
        System.arraycopy(bArr11, 0, bArr12, length10, 0);
        int i7 = length10 + 0;
        System.arraycopy(bArr4, 0, bArr12, i7, bArr4.length);
        System.arraycopy(ds, 0, bArr12, i7 + bArr4.length, ds.length);
        a(this.Ucs, this.Ucx, j2, this.Ucu, this.Ucv, i4, this.Ucw, super.aa(bArr12, this.Ucy, i6));
        byte[] hPx2 = super.hPx();
        AppMethodBeat.o(88081);
        return hPx2;
    }
}
