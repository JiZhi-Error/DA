package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class oz extends dop {
    public int KND;
    public String KRH;
    public String KRI;
    public int KRJ;
    public int KRK;
    public b KRc;
    public long KRi;
    public int KVT;
    public int source;
    public String xve;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(212247);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.KRc != null) {
                aVar.c(2, this.KRc);
            }
            aVar.aM(3, this.source);
            if (this.xve != null) {
                aVar.e(5, this.xve);
            }
            if (this.KRH != null) {
                aVar.e(6, this.KRH);
            }
            if (this.KRI != null) {
                aVar.e(7, this.KRI);
            }
            aVar.aM(8, this.KVT);
            aVar.aM(9, this.KRJ);
            aVar.aM(10, this.KRK);
            aVar.bb(18, this.KRi);
            aVar.aM(22, this.KND);
            AppMethodBeat.o(212247);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.KRc != null) {
                nh += g.a.a.b.b.a.b(2, this.KRc);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.source);
            if (this.xve != null) {
                bu += g.a.a.b.b.a.f(5, this.xve);
            }
            if (this.KRH != null) {
                bu += g.a.a.b.b.a.f(6, this.KRH);
            }
            if (this.KRI != null) {
                bu += g.a.a.b.b.a.f(7, this.KRI);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.KVT) + g.a.a.b.b.a.bu(9, this.KRJ) + g.a.a.b.b.a.bu(10, this.KRK) + g.a.a.b.b.a.r(18, this.KRi) + g.a.a.b.b.a.bu(22, this.KND);
            AppMethodBeat.o(212247);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(212247);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            oz ozVar = (oz) objArr[1];
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
                        ozVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(212247);
                    return 0;
                case 2:
                    ozVar.KRc = aVar3.UbS.hPo();
                    AppMethodBeat.o(212247);
                    return 0;
                case 3:
                    ozVar.source = aVar3.UbS.zi();
                    AppMethodBeat.o(212247);
                    return 0;
                case 4:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 19:
                case 20:
                case 21:
                default:
                    AppMethodBeat.o(212247);
                    return -1;
                case 5:
                    ozVar.xve = aVar3.UbS.readString();
                    AppMethodBeat.o(212247);
                    return 0;
                case 6:
                    ozVar.KRH = aVar3.UbS.readString();
                    AppMethodBeat.o(212247);
                    return 0;
                case 7:
                    ozVar.KRI = aVar3.UbS.readString();
                    AppMethodBeat.o(212247);
                    return 0;
                case 8:
                    ozVar.KVT = aVar3.UbS.zi();
                    AppMethodBeat.o(212247);
                    return 0;
                case 9:
                    ozVar.KRJ = aVar3.UbS.zi();
                    AppMethodBeat.o(212247);
                    return 0;
                case 10:
                    ozVar.KRK = aVar3.UbS.zi();
                    AppMethodBeat.o(212247);
                    return 0;
                case 18:
                    ozVar.KRi = aVar3.UbS.zl();
                    AppMethodBeat.o(212247);
                    return 0;
                case 22:
                    ozVar.KND = aVar3.UbS.zi();
                    AppMethodBeat.o(212247);
                    return 0;
            }
        } else {
            AppMethodBeat.o(212247);
            return -1;
        }
    }
}
