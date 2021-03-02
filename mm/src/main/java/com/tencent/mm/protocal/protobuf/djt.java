package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class djt extends a {
    public LinkedList<Integer> MNJ = new LinkedList<>();
    public int MNK;
    public String MNL;
    public String dNI;
    public String egn;
    public int status;

    public djt() {
        AppMethodBeat.i(214322);
        AppMethodBeat.o(214322);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(214323);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dNI != null) {
                aVar.e(1, this.dNI);
            }
            aVar.e(2, 2, this.MNJ);
            aVar.aM(3, this.MNK);
            if (this.MNL != null) {
                aVar.e(4, this.MNL);
            }
            if (this.egn != null) {
                aVar.e(5, this.egn);
            }
            aVar.aM(100, this.status);
            AppMethodBeat.o(214323);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.dNI != null ? g.a.a.b.b.a.f(1, this.dNI) + 0 : 0) + g.a.a.a.c(2, 2, this.MNJ) + g.a.a.b.b.a.bu(3, this.MNK);
            if (this.MNL != null) {
                f2 += g.a.a.b.b.a.f(4, this.MNL);
            }
            if (this.egn != null) {
                f2 += g.a.a.b.b.a.f(5, this.egn);
            }
            int bu = f2 + g.a.a.b.b.a.bu(100, this.status);
            AppMethodBeat.o(214323);
            return bu;
        } else if (i2 == 2) {
            this.MNJ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(214323);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            djt djt = (djt) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    djt.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(214323);
                    return 0;
                case 2:
                    djt.MNJ.add(Integer.valueOf(aVar3.UbS.zi()));
                    AppMethodBeat.o(214323);
                    return 0;
                case 3:
                    djt.MNK = aVar3.UbS.zi();
                    AppMethodBeat.o(214323);
                    return 0;
                case 4:
                    djt.MNL = aVar3.UbS.readString();
                    AppMethodBeat.o(214323);
                    return 0;
                case 5:
                    djt.egn = aVar3.UbS.readString();
                    AppMethodBeat.o(214323);
                    return 0;
                case 100:
                    djt.status = aVar3.UbS.zi();
                    AppMethodBeat.o(214323);
                    return 0;
                default:
                    AppMethodBeat.o(214323);
                    return -1;
            }
        } else {
            AppMethodBeat.o(214323);
            return -1;
        }
    }
}
