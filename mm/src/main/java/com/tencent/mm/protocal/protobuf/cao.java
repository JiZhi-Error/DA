package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class cao extends a {
    public b MfG;
    public int MfH;
    public LinkedList<caq> MfI = new LinkedList<>();
    public LinkedList<Integer> MfJ = new LinkedList<>();

    public cao() {
        AppMethodBeat.i(115842);
        AppMethodBeat.o(115842);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(115843);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MfG == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: RawBuf");
                AppMethodBeat.o(115843);
                throw bVar;
            }
            if (this.MfG != null) {
                aVar.c(1, this.MfG);
            }
            aVar.aM(2, this.MfH);
            aVar.e(3, 8, this.MfI);
            aVar.e(4, 2, this.MfJ);
            AppMethodBeat.o(115843);
            return 0;
        } else if (i2 == 1) {
            int b2 = (this.MfG != null ? g.a.a.b.b.a.b(1, this.MfG) + 0 : 0) + g.a.a.b.b.a.bu(2, this.MfH) + g.a.a.a.c(3, 8, this.MfI) + g.a.a.a.c(4, 2, this.MfJ);
            AppMethodBeat.o(115843);
            return b2;
        } else if (i2 == 2) {
            this.MfI.clear();
            this.MfJ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MfG == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: RawBuf");
                AppMethodBeat.o(115843);
                throw bVar2;
            }
            AppMethodBeat.o(115843);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cao cao = (cao) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cao.MfG = aVar3.UbS.hPo();
                    AppMethodBeat.o(115843);
                    return 0;
                case 2:
                    cao.MfH = aVar3.UbS.zi();
                    AppMethodBeat.o(115843);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        caq caq = new caq();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = caq.populateBuilderWithField(aVar4, caq, a.getNextFieldNumber(aVar4))) {
                        }
                        cao.MfI.add(caq);
                    }
                    AppMethodBeat.o(115843);
                    return 0;
                case 4:
                    cao.MfJ.add(Integer.valueOf(aVar3.UbS.zi()));
                    AppMethodBeat.o(115843);
                    return 0;
                default:
                    AppMethodBeat.o(115843);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115843);
            return -1;
        }
    }
}
