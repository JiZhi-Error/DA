package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class fes extends a {
    public int KSa;
    public String Md5;
    public String NAf;
    public fem NzO;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153344);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.NzO != null) {
                aVar.ni(1, this.NzO.computeSize());
                this.NzO.writeFields(aVar);
            }
            if (this.NAf != null) {
                aVar.e(2, this.NAf);
            }
            aVar.aM(3, this.KSa);
            if (this.Md5 != null) {
                aVar.e(4, this.Md5);
            }
            AppMethodBeat.o(153344);
            return 0;
        } else if (i2 == 1) {
            int nh = this.NzO != null ? g.a.a.a.nh(1, this.NzO.computeSize()) + 0 : 0;
            if (this.NAf != null) {
                nh += g.a.a.b.b.a.f(2, this.NAf);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.KSa);
            if (this.Md5 != null) {
                bu += g.a.a.b.b.a.f(4, this.Md5);
            }
            AppMethodBeat.o(153344);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153344);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fes fes = (fes) objArr[1];
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
                        fes.NzO = fem;
                    }
                    AppMethodBeat.o(153344);
                    return 0;
                case 2:
                    fes.NAf = aVar3.UbS.readString();
                    AppMethodBeat.o(153344);
                    return 0;
                case 3:
                    fes.KSa = aVar3.UbS.zi();
                    AppMethodBeat.o(153344);
                    return 0;
                case 4:
                    fes.Md5 = aVar3.UbS.readString();
                    AppMethodBeat.o(153344);
                    return 0;
                default:
                    AppMethodBeat.o(153344);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153344);
            return -1;
        }
    }
}
