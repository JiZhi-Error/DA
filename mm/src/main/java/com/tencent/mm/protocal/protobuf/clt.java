package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class clt extends a {
    public String KZj;
    public String MaZ;
    public long Mre;
    public long Mrf;
    public int oUv;
    public int scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117876);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.scene);
            if (this.MaZ != null) {
                aVar.e(2, this.MaZ);
            }
            aVar.bb(3, this.Mre);
            aVar.bb(4, this.Mrf);
            if (this.KZj != null) {
                aVar.e(5, this.KZj);
            }
            aVar.aM(6, this.oUv);
            AppMethodBeat.o(117876);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.scene) + 0;
            if (this.MaZ != null) {
                bu += g.a.a.b.b.a.f(2, this.MaZ);
            }
            int r = bu + g.a.a.b.b.a.r(3, this.Mre) + g.a.a.b.b.a.r(4, this.Mrf);
            if (this.KZj != null) {
                r += g.a.a.b.b.a.f(5, this.KZj);
            }
            int bu2 = r + g.a.a.b.b.a.bu(6, this.oUv);
            AppMethodBeat.o(117876);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117876);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            clt clt = (clt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    clt.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(117876);
                    return 0;
                case 2:
                    clt.MaZ = aVar3.UbS.readString();
                    AppMethodBeat.o(117876);
                    return 0;
                case 3:
                    clt.Mre = aVar3.UbS.zl();
                    AppMethodBeat.o(117876);
                    return 0;
                case 4:
                    clt.Mrf = aVar3.UbS.zl();
                    AppMethodBeat.o(117876);
                    return 0;
                case 5:
                    clt.KZj = aVar3.UbS.readString();
                    AppMethodBeat.o(117876);
                    return 0;
                case 6:
                    clt.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(117876);
                    return 0;
                default:
                    AppMethodBeat.o(117876);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117876);
            return -1;
        }
    }
}
