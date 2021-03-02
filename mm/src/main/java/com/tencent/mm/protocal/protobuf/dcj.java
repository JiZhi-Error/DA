package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dcj extends a {
    public String KHk;
    public String MHf;
    public float MHj;
    public float MHk;
    public String Title;
    public String URL;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209784);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Title != null) {
                aVar.e(1, this.Title);
            }
            if (this.KHk != null) {
                aVar.e(2, this.KHk);
            }
            aVar.E(3, this.MHj);
            aVar.E(4, this.MHk);
            if (this.URL != null) {
                aVar.e(5, this.URL);
            }
            if (this.MHf != null) {
                aVar.e(6, this.MHf);
            }
            AppMethodBeat.o(209784);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Title != null ? g.a.a.b.b.a.f(1, this.Title) + 0 : 0;
            if (this.KHk != null) {
                f2 += g.a.a.b.b.a.f(2, this.KHk);
            }
            int fS = f2 + g.a.a.b.b.a.fS(3) + 4 + g.a.a.b.b.a.fS(4) + 4;
            if (this.URL != null) {
                fS += g.a.a.b.b.a.f(5, this.URL);
            }
            if (this.MHf != null) {
                fS += g.a.a.b.b.a.f(6, this.MHf);
            }
            AppMethodBeat.o(209784);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209784);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dcj dcj = (dcj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    dcj.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(209784);
                    return 0;
                case 2:
                    dcj.KHk = aVar3.UbS.readString();
                    AppMethodBeat.o(209784);
                    return 0;
                case 3:
                    dcj.MHj = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(209784);
                    return 0;
                case 4:
                    dcj.MHk = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(209784);
                    return 0;
                case 5:
                    dcj.URL = aVar3.UbS.readString();
                    AppMethodBeat.o(209784);
                    return 0;
                case 6:
                    dcj.MHf = aVar3.UbS.readString();
                    AppMethodBeat.o(209784);
                    return 0;
                default:
                    AppMethodBeat.o(209784);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209784);
            return -1;
        }
    }
}
