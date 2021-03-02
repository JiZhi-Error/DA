package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class fgm extends a {
    public String ViT;
    public String ViU;
    public String ViV;
    public String ViW;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(259345);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.ViT != null) {
                aVar.e(1, this.ViT);
            }
            if (this.ViU != null) {
                aVar.e(2, this.ViU);
            }
            if (this.ViV != null) {
                aVar.e(101, this.ViV);
            }
            if (this.ViW != null) {
                aVar.e(102, this.ViW);
            }
            AppMethodBeat.o(259345);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.ViT != null ? g.a.a.b.b.a.f(1, this.ViT) + 0 : 0;
            if (this.ViU != null) {
                f2 += g.a.a.b.b.a.f(2, this.ViU);
            }
            if (this.ViV != null) {
                f2 += g.a.a.b.b.a.f(101, this.ViV);
            }
            if (this.ViW != null) {
                f2 += g.a.a.b.b.a.f(102, this.ViW);
            }
            AppMethodBeat.o(259345);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(259345);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fgm fgm = (fgm) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fgm.ViT = aVar3.UbS.readString();
                    AppMethodBeat.o(259345);
                    return 0;
                case 2:
                    fgm.ViU = aVar3.UbS.readString();
                    AppMethodBeat.o(259345);
                    return 0;
                case 101:
                    fgm.ViV = aVar3.UbS.readString();
                    AppMethodBeat.o(259345);
                    return 0;
                case 102:
                    fgm.ViW = aVar3.UbS.readString();
                    AppMethodBeat.o(259345);
                    return 0;
                default:
                    AppMethodBeat.o(259345);
                    return -1;
            }
        } else {
            AppMethodBeat.o(259345);
            return -1;
        }
    }
}
