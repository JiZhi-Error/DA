package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class alp extends dop {
    public int Bbl;
    public int Luu;
    public int egY;
    public double latitude;
    public double longitude;
    public int qwe;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91456);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.qwe);
            aVar.aM(3, this.Bbl);
            aVar.aM(4, this.egY);
            aVar.aM(5, this.Luu);
            aVar.e(6, this.latitude);
            aVar.e(7, this.longitude);
            AppMethodBeat.o(91456);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.qwe) + g.a.a.b.b.a.bu(3, this.Bbl) + g.a.a.b.b.a.bu(4, this.egY) + g.a.a.b.b.a.bu(5, this.Luu) + g.a.a.b.b.a.fS(6) + 8 + g.a.a.b.b.a.fS(7) + 8;
            AppMethodBeat.o(91456);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91456);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            alp alp = (alp) objArr[1];
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
                        alp.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(91456);
                    return 0;
                case 2:
                    alp.qwe = aVar3.UbS.zi();
                    AppMethodBeat.o(91456);
                    return 0;
                case 3:
                    alp.Bbl = aVar3.UbS.zi();
                    AppMethodBeat.o(91456);
                    return 0;
                case 4:
                    alp.egY = aVar3.UbS.zi();
                    AppMethodBeat.o(91456);
                    return 0;
                case 5:
                    alp.Luu = aVar3.UbS.zi();
                    AppMethodBeat.o(91456);
                    return 0;
                case 6:
                    alp.latitude = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(91456);
                    return 0;
                case 7:
                    alp.longitude = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(91456);
                    return 0;
                default:
                    AppMethodBeat.o(91456);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91456);
            return -1;
        }
    }
}
