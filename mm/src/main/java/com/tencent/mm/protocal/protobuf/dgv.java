package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dgv extends a {
    public int MLl;
    public boolean MLm;
    public String MLn;
    public int MLo;
    public int MLp;
    public LinkedList<dgu> MLq = new LinkedList<>();
    public String eaO;

    public dgv() {
        AppMethodBeat.i(114057);
        AppMethodBeat.o(114057);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(114058);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.eaO != null) {
                aVar.e(1, this.eaO);
            }
            aVar.aM(2, this.MLl);
            aVar.cc(3, this.MLm);
            if (this.MLn != null) {
                aVar.e(4, this.MLn);
            }
            aVar.aM(5, this.MLo);
            aVar.aM(6, this.MLp);
            aVar.e(7, 8, this.MLq);
            AppMethodBeat.o(114058);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.eaO != null ? g.a.a.b.b.a.f(1, this.eaO) + 0 : 0) + g.a.a.b.b.a.bu(2, this.MLl) + g.a.a.b.b.a.fS(3) + 1;
            if (this.MLn != null) {
                f2 += g.a.a.b.b.a.f(4, this.MLn);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.MLo) + g.a.a.b.b.a.bu(6, this.MLp) + g.a.a.a.c(7, 8, this.MLq);
            AppMethodBeat.o(114058);
            return bu;
        } else if (i2 == 2) {
            this.MLq.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(114058);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dgv dgv = (dgv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dgv.eaO = aVar3.UbS.readString();
                    AppMethodBeat.o(114058);
                    return 0;
                case 2:
                    dgv.MLl = aVar3.UbS.zi();
                    AppMethodBeat.o(114058);
                    return 0;
                case 3:
                    dgv.MLm = aVar3.UbS.yZ();
                    AppMethodBeat.o(114058);
                    return 0;
                case 4:
                    dgv.MLn = aVar3.UbS.readString();
                    AppMethodBeat.o(114058);
                    return 0;
                case 5:
                    dgv.MLo = aVar3.UbS.zi();
                    AppMethodBeat.o(114058);
                    return 0;
                case 6:
                    dgv.MLp = aVar3.UbS.zi();
                    AppMethodBeat.o(114058);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dgu dgu = new dgu();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dgu.populateBuilderWithField(aVar4, dgu, a.getNextFieldNumber(aVar4))) {
                        }
                        dgv.MLq.add(dgu);
                    }
                    AppMethodBeat.o(114058);
                    return 0;
                default:
                    AppMethodBeat.o(114058);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114058);
            return -1;
        }
    }
}
