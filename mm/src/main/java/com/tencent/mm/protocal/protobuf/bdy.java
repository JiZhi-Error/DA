package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bdy extends a {
    public String LNC;
    public int LND;
    public String LNE;
    public FinderAuthInfo LNF;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209709);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LNC != null) {
                aVar.e(1, this.LNC);
            }
            aVar.aM(2, this.LND);
            if (this.LNE != null) {
                aVar.e(3, this.LNE);
            }
            if (this.LNF != null) {
                aVar.ni(4, this.LNF.computeSize());
                this.LNF.writeFields(aVar);
            }
            AppMethodBeat.o(209709);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.LNC != null ? g.a.a.b.b.a.f(1, this.LNC) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LND);
            if (this.LNE != null) {
                f2 += g.a.a.b.b.a.f(3, this.LNE);
            }
            if (this.LNF != null) {
                f2 += g.a.a.a.nh(4, this.LNF.computeSize());
            }
            AppMethodBeat.o(209709);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209709);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bdy bdy = (bdy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bdy.LNC = aVar3.UbS.readString();
                    AppMethodBeat.o(209709);
                    return 0;
                case 2:
                    bdy.LND = aVar3.UbS.zi();
                    AppMethodBeat.o(209709);
                    return 0;
                case 3:
                    bdy.LNE = aVar3.UbS.readString();
                    AppMethodBeat.o(209709);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        FinderAuthInfo finderAuthInfo = new FinderAuthInfo();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = finderAuthInfo.populateBuilderWithField(aVar4, finderAuthInfo, a.getNextFieldNumber(aVar4))) {
                        }
                        bdy.LNF = finderAuthInfo;
                    }
                    AppMethodBeat.o(209709);
                    return 0;
                default:
                    AppMethodBeat.o(209709);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209709);
            return -1;
        }
    }
}
