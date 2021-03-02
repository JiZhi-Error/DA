package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cch extends a {
    public String Lkl;
    public String Mim;
    public String Min;
    public String Mio;
    public String Mip;
    public int Miq;
    public String Mir;
    public String Title;
    public String Url;
    public int oUv;
    public String xMq;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32327);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Title != null) {
                aVar.e(1, this.Title);
            }
            if (this.Mim != null) {
                aVar.e(2, this.Mim);
            }
            aVar.aM(3, this.oUv);
            if (this.Url != null) {
                aVar.e(4, this.Url);
            }
            if (this.Min != null) {
                aVar.e(5, this.Min);
            }
            if (this.Lkl != null) {
                aVar.e(6, this.Lkl);
            }
            if (this.Mio != null) {
                aVar.e(7, this.Mio);
            }
            if (this.xMq != null) {
                aVar.e(8, this.xMq);
            }
            if (this.Mip != null) {
                aVar.e(9, this.Mip);
            }
            aVar.aM(10, this.Miq);
            if (this.Mir != null) {
                aVar.e(11, this.Mir);
            }
            AppMethodBeat.o(32327);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Title != null ? g.a.a.b.b.a.f(1, this.Title) + 0 : 0;
            if (this.Mim != null) {
                f2 += g.a.a.b.b.a.f(2, this.Mim);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.oUv);
            if (this.Url != null) {
                bu += g.a.a.b.b.a.f(4, this.Url);
            }
            if (this.Min != null) {
                bu += g.a.a.b.b.a.f(5, this.Min);
            }
            if (this.Lkl != null) {
                bu += g.a.a.b.b.a.f(6, this.Lkl);
            }
            if (this.Mio != null) {
                bu += g.a.a.b.b.a.f(7, this.Mio);
            }
            if (this.xMq != null) {
                bu += g.a.a.b.b.a.f(8, this.xMq);
            }
            if (this.Mip != null) {
                bu += g.a.a.b.b.a.f(9, this.Mip);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(10, this.Miq);
            if (this.Mir != null) {
                bu2 += g.a.a.b.b.a.f(11, this.Mir);
            }
            AppMethodBeat.o(32327);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32327);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cch cch = (cch) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cch.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(32327);
                    return 0;
                case 2:
                    cch.Mim = aVar3.UbS.readString();
                    AppMethodBeat.o(32327);
                    return 0;
                case 3:
                    cch.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(32327);
                    return 0;
                case 4:
                    cch.Url = aVar3.UbS.readString();
                    AppMethodBeat.o(32327);
                    return 0;
                case 5:
                    cch.Min = aVar3.UbS.readString();
                    AppMethodBeat.o(32327);
                    return 0;
                case 6:
                    cch.Lkl = aVar3.UbS.readString();
                    AppMethodBeat.o(32327);
                    return 0;
                case 7:
                    cch.Mio = aVar3.UbS.readString();
                    AppMethodBeat.o(32327);
                    return 0;
                case 8:
                    cch.xMq = aVar3.UbS.readString();
                    AppMethodBeat.o(32327);
                    return 0;
                case 9:
                    cch.Mip = aVar3.UbS.readString();
                    AppMethodBeat.o(32327);
                    return 0;
                case 10:
                    cch.Miq = aVar3.UbS.zi();
                    AppMethodBeat.o(32327);
                    return 0;
                case 11:
                    cch.Mir = aVar3.UbS.readString();
                    AppMethodBeat.o(32327);
                    return 0;
                default:
                    AppMethodBeat.o(32327);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32327);
            return -1;
        }
    }
}
