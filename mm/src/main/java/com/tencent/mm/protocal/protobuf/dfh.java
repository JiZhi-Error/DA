package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dfh extends dop {
    public String MKj;
    public String MKk;
    public String MKl;
    public String MKm;
    public String MKn;
    public int MKo;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32374);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.MKj != null) {
                aVar.e(2, this.MKj);
            }
            if (this.MKk != null) {
                aVar.e(3, this.MKk);
            }
            if (this.MKl != null) {
                aVar.e(4, this.MKl);
            }
            if (this.MKm != null) {
                aVar.e(5, this.MKm);
            }
            if (this.MKn != null) {
                aVar.e(6, this.MKn);
            }
            aVar.aM(7, this.MKo);
            AppMethodBeat.o(32374);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.MKj != null) {
                nh += g.a.a.b.b.a.f(2, this.MKj);
            }
            if (this.MKk != null) {
                nh += g.a.a.b.b.a.f(3, this.MKk);
            }
            if (this.MKl != null) {
                nh += g.a.a.b.b.a.f(4, this.MKl);
            }
            if (this.MKm != null) {
                nh += g.a.a.b.b.a.f(5, this.MKm);
            }
            if (this.MKn != null) {
                nh += g.a.a.b.b.a.f(6, this.MKn);
            }
            int bu = nh + g.a.a.b.b.a.bu(7, this.MKo);
            AppMethodBeat.o(32374);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32374);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dfh dfh = (dfh) objArr[1];
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
                        dfh.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(32374);
                    return 0;
                case 2:
                    dfh.MKj = aVar3.UbS.readString();
                    AppMethodBeat.o(32374);
                    return 0;
                case 3:
                    dfh.MKk = aVar3.UbS.readString();
                    AppMethodBeat.o(32374);
                    return 0;
                case 4:
                    dfh.MKl = aVar3.UbS.readString();
                    AppMethodBeat.o(32374);
                    return 0;
                case 5:
                    dfh.MKm = aVar3.UbS.readString();
                    AppMethodBeat.o(32374);
                    return 0;
                case 6:
                    dfh.MKn = aVar3.UbS.readString();
                    AppMethodBeat.o(32374);
                    return 0;
                case 7:
                    dfh.MKo = aVar3.UbS.zi();
                    AppMethodBeat.o(32374);
                    return 0;
                default:
                    AppMethodBeat.o(32374);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32374);
            return -1;
        }
    }
}
