package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bwx extends dop {
    public int KFC;
    public boolean McF;
    public LinkedList<String> McG = new LinkedList<>();
    public String dNI;
    public int source;

    public bwx() {
        AppMethodBeat.i(147765);
        AppMethodBeat.o(147765);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(147766);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.dNI != null) {
                aVar.e(2, this.dNI);
            }
            aVar.cc(3, this.McF);
            aVar.e(4, 1, this.McG);
            aVar.aM(5, this.source);
            aVar.aM(6, this.KFC);
            AppMethodBeat.o(147766);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.dNI != null) {
                nh += g.a.a.b.b.a.f(2, this.dNI);
            }
            int fS = nh + g.a.a.b.b.a.fS(3) + 1 + g.a.a.a.c(4, 1, this.McG) + g.a.a.b.b.a.bu(5, this.source) + g.a.a.b.b.a.bu(6, this.KFC);
            AppMethodBeat.o(147766);
            return fS;
        } else if (i2 == 2) {
            this.McG.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(147766);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bwx bwx = (bwx) objArr[1];
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
                        bwx.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(147766);
                    return 0;
                case 2:
                    bwx.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(147766);
                    return 0;
                case 3:
                    bwx.McF = aVar3.UbS.yZ();
                    AppMethodBeat.o(147766);
                    return 0;
                case 4:
                    bwx.McG.add(aVar3.UbS.readString());
                    AppMethodBeat.o(147766);
                    return 0;
                case 5:
                    bwx.source = aVar3.UbS.zi();
                    AppMethodBeat.o(147766);
                    return 0;
                case 6:
                    bwx.KFC = aVar3.UbS.zi();
                    AppMethodBeat.o(147766);
                    return 0;
                default:
                    AppMethodBeat.o(147766);
                    return -1;
            }
        } else {
            AppMethodBeat.o(147766);
            return -1;
        }
    }
}