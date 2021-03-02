package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class cp extends a {
    public de KGK;
    public String KGL;
    public b KGM;
    public boolean KGN;
    public long seq;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(226003);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KGK != null) {
                aVar.ni(1, this.KGK.computeSize());
                this.KGK.writeFields(aVar);
            }
            if (this.KGL != null) {
                aVar.e(2, this.KGL);
            }
            aVar.bb(3, this.seq);
            if (this.KGM != null) {
                aVar.c(4, this.KGM);
            }
            aVar.cc(5, this.KGN);
            AppMethodBeat.o(226003);
            return 0;
        } else if (i2 == 1) {
            int nh = this.KGK != null ? g.a.a.a.nh(1, this.KGK.computeSize()) + 0 : 0;
            if (this.KGL != null) {
                nh += g.a.a.b.b.a.f(2, this.KGL);
            }
            int r = nh + g.a.a.b.b.a.r(3, this.seq);
            if (this.KGM != null) {
                r += g.a.a.b.b.a.b(4, this.KGM);
            }
            int fS = r + g.a.a.b.b.a.fS(5) + 1;
            AppMethodBeat.o(226003);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(226003);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cp cpVar = (cp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        de deVar = new de();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = deVar.populateBuilderWithField(aVar4, deVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cpVar.KGK = deVar;
                    }
                    AppMethodBeat.o(226003);
                    return 0;
                case 2:
                    cpVar.KGL = aVar3.UbS.readString();
                    AppMethodBeat.o(226003);
                    return 0;
                case 3:
                    cpVar.seq = aVar3.UbS.zl();
                    AppMethodBeat.o(226003);
                    return 0;
                case 4:
                    cpVar.KGM = aVar3.UbS.hPo();
                    AppMethodBeat.o(226003);
                    return 0;
                case 5:
                    cpVar.KGN = aVar3.UbS.yZ();
                    AppMethodBeat.o(226003);
                    return 0;
                default:
                    AppMethodBeat.o(226003);
                    return -1;
            }
        } else {
            AppMethodBeat.o(226003);
            return -1;
        }
    }
}
