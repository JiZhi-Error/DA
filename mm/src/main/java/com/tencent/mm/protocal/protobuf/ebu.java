package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ebu extends dop {
    public int Nbr;
    public int Nbs;
    public String Nbu;
    public String Nbv;
    public String Nbw;
    public String dPr;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(130919);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.Nbv != null) {
                aVar.e(2, this.Nbv);
            }
            if (this.Nbu != null) {
                aVar.e(3, this.Nbu);
            }
            if (this.Nbw != null) {
                aVar.e(4, this.Nbw);
            }
            if (this.dPr != null) {
                aVar.e(5, this.dPr);
            }
            aVar.aM(6, this.Nbr);
            aVar.aM(7, this.Nbs);
            AppMethodBeat.o(130919);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.Nbv != null) {
                nh += g.a.a.b.b.a.f(2, this.Nbv);
            }
            if (this.Nbu != null) {
                nh += g.a.a.b.b.a.f(3, this.Nbu);
            }
            if (this.Nbw != null) {
                nh += g.a.a.b.b.a.f(4, this.Nbw);
            }
            if (this.dPr != null) {
                nh += g.a.a.b.b.a.f(5, this.dPr);
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.Nbr) + g.a.a.b.b.a.bu(7, this.Nbs);
            AppMethodBeat.o(130919);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(130919);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ebu ebu = (ebu) objArr[1];
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
                        ebu.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(130919);
                    return 0;
                case 2:
                    ebu.Nbv = aVar3.UbS.readString();
                    AppMethodBeat.o(130919);
                    return 0;
                case 3:
                    ebu.Nbu = aVar3.UbS.readString();
                    AppMethodBeat.o(130919);
                    return 0;
                case 4:
                    ebu.Nbw = aVar3.UbS.readString();
                    AppMethodBeat.o(130919);
                    return 0;
                case 5:
                    ebu.dPr = aVar3.UbS.readString();
                    AppMethodBeat.o(130919);
                    return 0;
                case 6:
                    ebu.Nbr = aVar3.UbS.zi();
                    AppMethodBeat.o(130919);
                    return 0;
                case 7:
                    ebu.Nbs = aVar3.UbS.zi();
                    AppMethodBeat.o(130919);
                    return 0;
                default:
                    AppMethodBeat.o(130919);
                    return -1;
            }
        } else {
            AppMethodBeat.o(130919);
            return -1;
        }
    }
}
