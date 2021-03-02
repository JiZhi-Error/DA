package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class fcr extends a {
    public String MXx;
    public String NyA;
    public dxs NyB;
    public eie NyC;
    public boolean Nyi;
    public boolean Nyk;
    public boolean Nyl;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153317);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.NyA != null) {
                aVar.e(1, this.NyA);
            }
            if (this.MXx != null) {
                aVar.e(2, this.MXx);
            }
            if (this.NyB != null) {
                aVar.ni(3, this.NyB.computeSize());
                this.NyB.writeFields(aVar);
            }
            aVar.cc(4, this.Nyi);
            aVar.cc(5, this.Nyk);
            if (this.NyC != null) {
                aVar.ni(6, this.NyC.computeSize());
                this.NyC.writeFields(aVar);
            }
            aVar.cc(7, this.Nyl);
            AppMethodBeat.o(153317);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.NyA != null ? g.a.a.b.b.a.f(1, this.NyA) + 0 : 0;
            if (this.MXx != null) {
                f2 += g.a.a.b.b.a.f(2, this.MXx);
            }
            if (this.NyB != null) {
                f2 += g.a.a.a.nh(3, this.NyB.computeSize());
            }
            int fS = f2 + g.a.a.b.b.a.fS(4) + 1 + g.a.a.b.b.a.fS(5) + 1;
            if (this.NyC != null) {
                fS += g.a.a.a.nh(6, this.NyC.computeSize());
            }
            int fS2 = fS + g.a.a.b.b.a.fS(7) + 1;
            AppMethodBeat.o(153317);
            return fS2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153317);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fcr fcr = (fcr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    fcr.NyA = aVar3.UbS.readString();
                    AppMethodBeat.o(153317);
                    return 0;
                case 2:
                    fcr.MXx = aVar3.UbS.readString();
                    AppMethodBeat.o(153317);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dxs dxs = new dxs();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dxs.populateBuilderWithField(aVar4, dxs, a.getNextFieldNumber(aVar4))) {
                        }
                        fcr.NyB = dxs;
                    }
                    AppMethodBeat.o(153317);
                    return 0;
                case 4:
                    fcr.Nyi = aVar3.UbS.yZ();
                    AppMethodBeat.o(153317);
                    return 0;
                case 5:
                    fcr.Nyk = aVar3.UbS.yZ();
                    AppMethodBeat.o(153317);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        eie eie = new eie();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = eie.populateBuilderWithField(aVar5, eie, a.getNextFieldNumber(aVar5))) {
                        }
                        fcr.NyC = eie;
                    }
                    AppMethodBeat.o(153317);
                    return 0;
                case 7:
                    fcr.Nyl = aVar3.UbS.yZ();
                    AppMethodBeat.o(153317);
                    return 0;
                default:
                    AppMethodBeat.o(153317);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153317);
            return -1;
        }
    }
}
