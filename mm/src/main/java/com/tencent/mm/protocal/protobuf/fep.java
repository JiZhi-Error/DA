package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class fep extends a {
    public int KSa;
    public int MSo;
    public int MSq;
    public String Md5;
    public int NAa;
    public boolean NAb;
    public String NAc;
    public int NAd;
    public fem NzO;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153341);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.NzO != null) {
                aVar.ni(1, this.NzO.computeSize());
                this.NzO.writeFields(aVar);
            }
            aVar.aM(2, this.NAa);
            aVar.aM(3, this.MSo);
            aVar.aM(4, this.MSq);
            aVar.cc(5, this.NAb);
            aVar.aM(6, this.KSa);
            if (this.Md5 != null) {
                aVar.e(7, this.Md5);
            }
            if (this.NAc != null) {
                aVar.e(8, this.NAc);
            }
            aVar.aM(9, this.NAd);
            AppMethodBeat.o(153341);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.NzO != null ? g.a.a.a.nh(1, this.NzO.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.NAa) + g.a.a.b.b.a.bu(3, this.MSo) + g.a.a.b.b.a.bu(4, this.MSq) + g.a.a.b.b.a.fS(5) + 1 + g.a.a.b.b.a.bu(6, this.KSa);
            if (this.Md5 != null) {
                nh += g.a.a.b.b.a.f(7, this.Md5);
            }
            if (this.NAc != null) {
                nh += g.a.a.b.b.a.f(8, this.NAc);
            }
            int bu = nh + g.a.a.b.b.a.bu(9, this.NAd);
            AppMethodBeat.o(153341);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153341);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fep fep = (fep) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        fem fem = new fem();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = fem.populateBuilderWithField(aVar4, fem, a.getNextFieldNumber(aVar4))) {
                        }
                        fep.NzO = fem;
                    }
                    AppMethodBeat.o(153341);
                    return 0;
                case 2:
                    fep.NAa = aVar3.UbS.zi();
                    AppMethodBeat.o(153341);
                    return 0;
                case 3:
                    fep.MSo = aVar3.UbS.zi();
                    AppMethodBeat.o(153341);
                    return 0;
                case 4:
                    fep.MSq = aVar3.UbS.zi();
                    AppMethodBeat.o(153341);
                    return 0;
                case 5:
                    fep.NAb = aVar3.UbS.yZ();
                    AppMethodBeat.o(153341);
                    return 0;
                case 6:
                    fep.KSa = aVar3.UbS.zi();
                    AppMethodBeat.o(153341);
                    return 0;
                case 7:
                    fep.Md5 = aVar3.UbS.readString();
                    AppMethodBeat.o(153341);
                    return 0;
                case 8:
                    fep.NAc = aVar3.UbS.readString();
                    AppMethodBeat.o(153341);
                    return 0;
                case 9:
                    fep.NAd = aVar3.UbS.zi();
                    AppMethodBeat.o(153341);
                    return 0;
                default:
                    AppMethodBeat.o(153341);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153341);
            return -1;
        }
    }
}
