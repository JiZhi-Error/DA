package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class edo extends a {
    public String NdR;
    public String NdS;
    public String NdT;
    public String NdU;
    public String NdV;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(101531);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.NdR == null) {
                b bVar = new b("Not all required fields were included: videoFileMD5");
                AppMethodBeat.o(101531);
                throw bVar;
            }
            if (this.NdR != null) {
                aVar.e(1, this.NdR);
            }
            if (this.NdS != null) {
                aVar.e(2, this.NdS);
            }
            if (this.NdT != null) {
                aVar.e(3, this.NdT);
            }
            if (this.NdU != null) {
                aVar.e(4, this.NdU);
            }
            if (this.NdV != null) {
                aVar.e(5, this.NdV);
            }
            AppMethodBeat.o(101531);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.NdR != null ? g.a.a.b.b.a.f(1, this.NdR) + 0 : 0;
            if (this.NdS != null) {
                f2 += g.a.a.b.b.a.f(2, this.NdS);
            }
            if (this.NdT != null) {
                f2 += g.a.a.b.b.a.f(3, this.NdT);
            }
            if (this.NdU != null) {
                f2 += g.a.a.b.b.a.f(4, this.NdU);
            }
            if (this.NdV != null) {
                f2 += g.a.a.b.b.a.f(5, this.NdV);
            }
            AppMethodBeat.o(101531);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.NdR == null) {
                b bVar2 = new b("Not all required fields were included: videoFileMD5");
                AppMethodBeat.o(101531);
                throw bVar2;
            }
            AppMethodBeat.o(101531);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            edo edo = (edo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    edo.NdR = aVar3.UbS.readString();
                    AppMethodBeat.o(101531);
                    return 0;
                case 2:
                    edo.NdS = aVar3.UbS.readString();
                    AppMethodBeat.o(101531);
                    return 0;
                case 3:
                    edo.NdT = aVar3.UbS.readString();
                    AppMethodBeat.o(101531);
                    return 0;
                case 4:
                    edo.NdU = aVar3.UbS.readString();
                    AppMethodBeat.o(101531);
                    return 0;
                case 5:
                    edo.NdV = aVar3.UbS.readString();
                    AppMethodBeat.o(101531);
                    return 0;
                default:
                    AppMethodBeat.o(101531);
                    return -1;
            }
        } else {
            AppMethodBeat.o(101531);
            return -1;
        }
    }
}
