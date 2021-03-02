package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cyk extends a {
    public String MDj;
    public cft MDk;
    public boolean MDl = false;
    public String action;
    public String className;
    public String dataPath;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(122524);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.className != null) {
                aVar.e(1, this.className);
            }
            if (this.dataPath != null) {
                aVar.e(2, this.dataPath);
            }
            if (this.action != null) {
                aVar.e(3, this.action);
            }
            if (this.MDj != null) {
                aVar.e(4, this.MDj);
            }
            if (this.MDk != null) {
                aVar.ni(5, this.MDk.computeSize());
                this.MDk.writeFields(aVar);
            }
            aVar.cc(6, this.MDl);
            AppMethodBeat.o(122524);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.className != null ? g.a.a.b.b.a.f(1, this.className) + 0 : 0;
            if (this.dataPath != null) {
                f2 += g.a.a.b.b.a.f(2, this.dataPath);
            }
            if (this.action != null) {
                f2 += g.a.a.b.b.a.f(3, this.action);
            }
            if (this.MDj != null) {
                f2 += g.a.a.b.b.a.f(4, this.MDj);
            }
            if (this.MDk != null) {
                f2 += g.a.a.a.nh(5, this.MDk.computeSize());
            }
            int fS = f2 + g.a.a.b.b.a.fS(6) + 1;
            AppMethodBeat.o(122524);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(122524);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cyk cyk = (cyk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cyk.className = aVar3.UbS.readString();
                    AppMethodBeat.o(122524);
                    return 0;
                case 2:
                    cyk.dataPath = aVar3.UbS.readString();
                    AppMethodBeat.o(122524);
                    return 0;
                case 3:
                    cyk.action = aVar3.UbS.readString();
                    AppMethodBeat.o(122524);
                    return 0;
                case 4:
                    cyk.MDj = aVar3.UbS.readString();
                    AppMethodBeat.o(122524);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cft cft = new cft();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cft.populateBuilderWithField(aVar4, cft, a.getNextFieldNumber(aVar4))) {
                        }
                        cyk.MDk = cft;
                    }
                    AppMethodBeat.o(122524);
                    return 0;
                case 6:
                    cyk.MDl = aVar3.UbS.yZ();
                    AppMethodBeat.o(122524);
                    return 0;
                default:
                    AppMethodBeat.o(122524);
                    return -1;
            }
        } else {
            AppMethodBeat.o(122524);
            return -1;
        }
    }
}
