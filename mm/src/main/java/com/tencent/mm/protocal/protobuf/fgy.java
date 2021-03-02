package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class fgy extends a {
    public String ViT;
    public String ViX;
    public String Vjk;
    public int Vjo;
    public long begin_time;
    public long pWi;
    public int status;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(259358);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.ViT != null) {
                aVar.e(1, this.ViT);
            }
            aVar.bb(2, this.begin_time);
            aVar.bb(3, this.pWi);
            aVar.aM(4, this.Vjo);
            if (this.ViX != null) {
                aVar.e(5, this.ViX);
            }
            if (this.Vjk != null) {
                aVar.e(6, this.Vjk);
            }
            aVar.aM(7, this.status);
            AppMethodBeat.o(259358);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.ViT != null ? g.a.a.b.b.a.f(1, this.ViT) + 0 : 0) + g.a.a.b.b.a.r(2, this.begin_time) + g.a.a.b.b.a.r(3, this.pWi) + g.a.a.b.b.a.bu(4, this.Vjo);
            if (this.ViX != null) {
                f2 += g.a.a.b.b.a.f(5, this.ViX);
            }
            if (this.Vjk != null) {
                f2 += g.a.a.b.b.a.f(6, this.Vjk);
            }
            int bu = f2 + g.a.a.b.b.a.bu(7, this.status);
            AppMethodBeat.o(259358);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(259358);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fgy fgy = (fgy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fgy.ViT = aVar3.UbS.readString();
                    AppMethodBeat.o(259358);
                    return 0;
                case 2:
                    fgy.begin_time = aVar3.UbS.zl();
                    AppMethodBeat.o(259358);
                    return 0;
                case 3:
                    fgy.pWi = aVar3.UbS.zl();
                    AppMethodBeat.o(259358);
                    return 0;
                case 4:
                    fgy.Vjo = aVar3.UbS.zi();
                    AppMethodBeat.o(259358);
                    return 0;
                case 5:
                    fgy.ViX = aVar3.UbS.readString();
                    AppMethodBeat.o(259358);
                    return 0;
                case 6:
                    fgy.Vjk = aVar3.UbS.readString();
                    AppMethodBeat.o(259358);
                    return 0;
                case 7:
                    fgy.status = aVar3.UbS.zi();
                    AppMethodBeat.o(259358);
                    return 0;
                default:
                    AppMethodBeat.o(259358);
                    return -1;
            }
        } else {
            AppMethodBeat.o(259358);
            return -1;
        }
    }
}
