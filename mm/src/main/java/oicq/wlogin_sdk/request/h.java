package oicq.wlogin_sdk.request;

import com.tencent.matrix.trace.core.AppMethodBeat;
import oicq.wlogin_sdk.a.f;
import oicq.wlogin_sdk.a.g;

public final class h extends d {
    public h(i iVar) {
        this.Ucx = 2064;
        this.Ucy = 3;
        this.UcA = iVar;
    }

    @Override // oicq.wlogin_sdk.request.d
    public final int ac(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(88076);
        f fVar = new f();
        g gVar = new g();
        int aj = super.aj(bArr, i2 + 2);
        super.hPy();
        int i4 = i2 + 5;
        switch (aj) {
            case 2:
                int af = fVar.af(bArr, i4, this.Ucm - i4);
                if (af >= 0) {
                    this.UcA.UcF = fVar;
                    af = gVar.af(bArr, i4, this.Ucm - i4);
                    if (af >= 0) {
                        this.UcA.UcG = gVar;
                        break;
                    }
                }
                aj = af;
                break;
            case 3:
            case 4:
            default:
                ab(bArr, i4, (this.Ucm - i4) - 1);
                break;
            case 5:
                super.ab(bArr, i4, (this.Ucm - i4) - 1);
                break;
        }
        AppMethodBeat.o(88076);
        return aj;
    }
}
