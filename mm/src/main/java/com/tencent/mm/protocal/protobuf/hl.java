package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class hl extends dop {
    public int KFC;
    public LinkedList<String> KLt = new LinkedList<>();
    public boolean KLu;
    public int KLv;
    public String dNI;
    public int source;

    public hl() {
        AppMethodBeat.i(147758);
        AppMethodBeat.o(147758);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(147759);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.dNI != null) {
                aVar.e(2, this.dNI);
            }
            aVar.e(3, 1, this.KLt);
            aVar.cc(4, this.KLu);
            aVar.aM(5, this.KLv);
            aVar.aM(6, this.source);
            aVar.aM(7, this.KFC);
            AppMethodBeat.o(147759);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.dNI != null) {
                nh += g.a.a.b.b.a.f(2, this.dNI);
            }
            int c2 = nh + g.a.a.a.c(3, 1, this.KLt) + g.a.a.b.b.a.fS(4) + 1 + g.a.a.b.b.a.bu(5, this.KLv) + g.a.a.b.b.a.bu(6, this.source) + g.a.a.b.b.a.bu(7, this.KFC);
            AppMethodBeat.o(147759);
            return c2;
        } else if (i2 == 2) {
            this.KLt.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(147759);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            hl hlVar = (hl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.populateBuilderWithField(aVar4, jrVar, dop.getNextFieldNumber(aVar4))) {
                        }
                        hlVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(147759);
                    return 0;
                case 2:
                    hlVar.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(147759);
                    return 0;
                case 3:
                    hlVar.KLt.add(aVar3.UbS.readString());
                    AppMethodBeat.o(147759);
                    return 0;
                case 4:
                    hlVar.KLu = aVar3.UbS.yZ();
                    AppMethodBeat.o(147759);
                    return 0;
                case 5:
                    hlVar.KLv = aVar3.UbS.zi();
                    AppMethodBeat.o(147759);
                    return 0;
                case 6:
                    hlVar.source = aVar3.UbS.zi();
                    AppMethodBeat.o(147759);
                    return 0;
                case 7:
                    hlVar.KFC = aVar3.UbS.zi();
                    AppMethodBeat.o(147759);
                    return 0;
                default:
                    AppMethodBeat.o(147759);
                    return -1;
            }
        } else {
            AppMethodBeat.o(147759);
            return -1;
        }
    }
}
