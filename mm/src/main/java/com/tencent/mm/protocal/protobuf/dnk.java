package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dnk extends dop {
    public String MBV;
    public String MQD;
    public int dYn;
    public String yQE;
    public String yVy;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(116341);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.yQE != null) {
                aVar.e(2, this.yQE);
            }
            if (this.MBV != null) {
                aVar.e(3, this.MBV);
            }
            aVar.aM(4, this.dYn);
            if (this.yVy != null) {
                aVar.e(5, this.yVy);
            }
            if (this.MQD != null) {
                aVar.e(6, this.MQD);
            }
            AppMethodBeat.o(116341);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.yQE != null) {
                nh += g.a.a.b.b.a.f(2, this.yQE);
            }
            if (this.MBV != null) {
                nh += g.a.a.b.b.a.f(3, this.MBV);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.dYn);
            if (this.yVy != null) {
                bu += g.a.a.b.b.a.f(5, this.yVy);
            }
            if (this.MQD != null) {
                bu += g.a.a.b.b.a.f(6, this.MQD);
            }
            AppMethodBeat.o(116341);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(116341);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dnk dnk = (dnk) objArr[1];
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
                        dnk.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(116341);
                    return 0;
                case 2:
                    dnk.yQE = aVar3.UbS.readString();
                    AppMethodBeat.o(116341);
                    return 0;
                case 3:
                    dnk.MBV = aVar3.UbS.readString();
                    AppMethodBeat.o(116341);
                    return 0;
                case 4:
                    dnk.dYn = aVar3.UbS.zi();
                    AppMethodBeat.o(116341);
                    return 0;
                case 5:
                    dnk.yVy = aVar3.UbS.readString();
                    AppMethodBeat.o(116341);
                    return 0;
                case 6:
                    dnk.MQD = aVar3.UbS.readString();
                    AppMethodBeat.o(116341);
                    return 0;
                default:
                    AppMethodBeat.o(116341);
                    return -1;
            }
        } else {
            AppMethodBeat.o(116341);
            return -1;
        }
    }
}
