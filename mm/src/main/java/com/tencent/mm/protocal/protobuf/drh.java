package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class drh extends dop {
    public int Lqj;
    public String MTQ;
    public String MTR;
    public b MTS;
    public int Mzq;
    public LinkedList<String> Mzr = new LinkedList<>();
    public String dNI;
    public String state;

    public drh() {
        AppMethodBeat.i(82470);
        AppMethodBeat.o(82470);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(82471);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(3, this.Mzq);
            aVar.e(4, 1, this.Mzr);
            if (this.dNI != null) {
                aVar.e(5, this.dNI);
            }
            if (this.state != null) {
                aVar.e(6, this.state);
            }
            if (this.MTQ != null) {
                aVar.e(7, this.MTQ);
            }
            aVar.aM(8, this.Lqj);
            if (this.MTR != null) {
                aVar.e(14, this.MTR);
            }
            if (this.MTS != null) {
                aVar.c(15, this.MTS);
            }
            AppMethodBeat.o(82471);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(3, this.Mzq) + g.a.a.a.c(4, 1, this.Mzr);
            if (this.dNI != null) {
                nh += g.a.a.b.b.a.f(5, this.dNI);
            }
            if (this.state != null) {
                nh += g.a.a.b.b.a.f(6, this.state);
            }
            if (this.MTQ != null) {
                nh += g.a.a.b.b.a.f(7, this.MTQ);
            }
            int bu = nh + g.a.a.b.b.a.bu(8, this.Lqj);
            if (this.MTR != null) {
                bu += g.a.a.b.b.a.f(14, this.MTR);
            }
            if (this.MTS != null) {
                bu += g.a.a.b.b.a.b(15, this.MTS);
            }
            AppMethodBeat.o(82471);
            return bu;
        } else if (i2 == 2) {
            this.Mzr.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(82471);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            drh drh = (drh) objArr[1];
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
                        drh.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(82471);
                    return 0;
                case 2:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                default:
                    AppMethodBeat.o(82471);
                    return -1;
                case 3:
                    drh.Mzq = aVar3.UbS.zi();
                    AppMethodBeat.o(82471);
                    return 0;
                case 4:
                    drh.Mzr.add(aVar3.UbS.readString());
                    AppMethodBeat.o(82471);
                    return 0;
                case 5:
                    drh.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(82471);
                    return 0;
                case 6:
                    drh.state = aVar3.UbS.readString();
                    AppMethodBeat.o(82471);
                    return 0;
                case 7:
                    drh.MTQ = aVar3.UbS.readString();
                    AppMethodBeat.o(82471);
                    return 0;
                case 8:
                    drh.Lqj = aVar3.UbS.zi();
                    AppMethodBeat.o(82471);
                    return 0;
                case 14:
                    drh.MTR = aVar3.UbS.readString();
                    AppMethodBeat.o(82471);
                    return 0;
                case 15:
                    drh.MTS = aVar3.UbS.hPo();
                    AppMethodBeat.o(82471);
                    return 0;
            }
        } else {
            AppMethodBeat.o(82471);
            return -1;
        }
    }
}
