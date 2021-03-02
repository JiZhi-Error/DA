package oicq.wlogin_sdk.request;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.a.ao;
import oicq.wlogin_sdk.a.f;

public final class g extends d {
    public g(i iVar) {
        this.Ucx = 2064;
        this.Ucy = 2;
        this.UcA = iVar;
    }

    public final byte[] dn(byte[] bArr) {
        int i2;
        int i3;
        AppMethodBeat.i(88065);
        int i4 = this.UcA.UcK;
        byte[] hPA = this.UcA.UcF.hPA();
        oicq.wlogin_sdk.a.g gVar = this.UcA.UcG;
        byte[] bArr2 = new byte[gVar.Uds];
        if (gVar.Uds > 0) {
            System.arraycopy(gVar.Ucr, gVar.Udu, bArr2, 0, gVar.Uds);
        }
        f fVar = new f();
        ao aoVar = new ao();
        byte[] bArr3 = fVar.m56do(hPA);
        byte[] r = aoVar.r(bArr, bArr2);
        byte[] bArr4 = new byte[(bArr3.length + r.length)];
        if (hPA.length > 0) {
            System.arraycopy(bArr3, 0, bArr4, 0, bArr3.length);
            i2 = bArr3.length + 0;
            i3 = 1;
        } else {
            i2 = 0;
            i3 = 0;
        }
        System.arraycopy(r, 0, bArr4, i2, r.length);
        a(this.Ucs, this.Ucx, this.UcA._uin, this.Ucu, this.Ucv, i4, this.Ucw, super.aa(bArr4, this.Ucy, i3 + 1));
        byte[] hPx = super.hPx();
        AppMethodBeat.o(88065);
        return hPx;
    }
}
