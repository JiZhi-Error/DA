package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class egl extends a {
    public long KMc;
    public long KMf;
    public int Ngu;
    public String Ngv;
    public int Ngw;
    public int Ngx;
    public int Ngy;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(223892);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.KMf);
            aVar.aM(2, this.Ngu);
            if (this.Ngv != null) {
                aVar.e(3, this.Ngv);
            }
            aVar.bb(4, this.KMc);
            aVar.aM(5, this.Ngw);
            aVar.aM(6, this.Ngx);
            aVar.aM(7, this.Ngy);
            AppMethodBeat.o(223892);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.KMf) + 0 + g.a.a.b.b.a.bu(2, this.Ngu);
            if (this.Ngv != null) {
                r += g.a.a.b.b.a.f(3, this.Ngv);
            }
            int r2 = r + g.a.a.b.b.a.r(4, this.KMc) + g.a.a.b.b.a.bu(5, this.Ngw) + g.a.a.b.b.a.bu(6, this.Ngx) + g.a.a.b.b.a.bu(7, this.Ngy);
            AppMethodBeat.o(223892);
            return r2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(223892);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            egl egl = (egl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    egl.KMf = aVar3.UbS.zl();
                    AppMethodBeat.o(223892);
                    return 0;
                case 2:
                    egl.Ngu = aVar3.UbS.zi();
                    AppMethodBeat.o(223892);
                    return 0;
                case 3:
                    egl.Ngv = aVar3.UbS.readString();
                    AppMethodBeat.o(223892);
                    return 0;
                case 4:
                    egl.KMc = aVar3.UbS.zl();
                    AppMethodBeat.o(223892);
                    return 0;
                case 5:
                    egl.Ngw = aVar3.UbS.zi();
                    AppMethodBeat.o(223892);
                    return 0;
                case 6:
                    egl.Ngx = aVar3.UbS.zi();
                    AppMethodBeat.o(223892);
                    return 0;
                case 7:
                    egl.Ngy = aVar3.UbS.zi();
                    AppMethodBeat.o(223892);
                    return 0;
                default:
                    AppMethodBeat.o(223892);
                    return -1;
            }
        } else {
            AppMethodBeat.o(223892);
            return -1;
        }
    }
}
