package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ebf extends a {
    public long NaS = 0;
    public long NaT = 0;
    public long NaU = 0;
    public LinkedList<dzv> NaV = new LinkedList<>();
    public String NaW;
    public String dPM;
    public String dRM;
    public String iGB;

    public ebf() {
        AppMethodBeat.i(122548);
        AppMethodBeat.o(122548);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(122549);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dRM != null) {
                aVar.e(1, this.dRM);
            }
            aVar.bb(2, this.NaS);
            aVar.bb(3, this.NaT);
            aVar.bb(4, this.NaU);
            aVar.e(5, 8, this.NaV);
            if (this.dPM != null) {
                aVar.e(6, this.dPM);
            }
            if (this.iGB != null) {
                aVar.e(7, this.iGB);
            }
            if (this.NaW != null) {
                aVar.e(8, this.NaW);
            }
            AppMethodBeat.o(122549);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.dRM != null ? g.a.a.b.b.a.f(1, this.dRM) + 0 : 0) + g.a.a.b.b.a.r(2, this.NaS) + g.a.a.b.b.a.r(3, this.NaT) + g.a.a.b.b.a.r(4, this.NaU) + g.a.a.a.c(5, 8, this.NaV);
            if (this.dPM != null) {
                f2 += g.a.a.b.b.a.f(6, this.dPM);
            }
            if (this.iGB != null) {
                f2 += g.a.a.b.b.a.f(7, this.iGB);
            }
            if (this.NaW != null) {
                f2 += g.a.a.b.b.a.f(8, this.NaW);
            }
            AppMethodBeat.o(122549);
            return f2;
        } else if (i2 == 2) {
            this.NaV.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(122549);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ebf ebf = (ebf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ebf.dRM = aVar3.UbS.readString();
                    AppMethodBeat.o(122549);
                    return 0;
                case 2:
                    ebf.NaS = aVar3.UbS.zl();
                    AppMethodBeat.o(122549);
                    return 0;
                case 3:
                    ebf.NaT = aVar3.UbS.zl();
                    AppMethodBeat.o(122549);
                    return 0;
                case 4:
                    ebf.NaU = aVar3.UbS.zl();
                    AppMethodBeat.o(122549);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dzv dzv = new dzv();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dzv.populateBuilderWithField(aVar4, dzv, a.getNextFieldNumber(aVar4))) {
                        }
                        ebf.NaV.add(dzv);
                    }
                    AppMethodBeat.o(122549);
                    return 0;
                case 6:
                    ebf.dPM = aVar3.UbS.readString();
                    AppMethodBeat.o(122549);
                    return 0;
                case 7:
                    ebf.iGB = aVar3.UbS.readString();
                    AppMethodBeat.o(122549);
                    return 0;
                case 8:
                    ebf.NaW = aVar3.UbS.readString();
                    AppMethodBeat.o(122549);
                    return 0;
                default:
                    AppMethodBeat.o(122549);
                    return -1;
            }
        } else {
            AppMethodBeat.o(122549);
            return -1;
        }
    }
}
