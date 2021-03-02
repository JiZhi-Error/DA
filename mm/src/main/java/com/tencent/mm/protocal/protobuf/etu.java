package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class etu extends dop {
    public int LsZ;
    public long Lta;
    public long NpN;
    public int NqU;
    public int Timestamp;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(115881);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.LsZ);
            aVar.bb(3, this.Lta);
            aVar.aM(4, this.Timestamp);
            aVar.bb(5, this.NpN);
            aVar.aM(6, this.NqU);
            AppMethodBeat.o(115881);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LsZ) + g.a.a.b.b.a.r(3, this.Lta) + g.a.a.b.b.a.bu(4, this.Timestamp) + g.a.a.b.b.a.r(5, this.NpN) + g.a.a.b.b.a.bu(6, this.NqU);
            AppMethodBeat.o(115881);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(115881);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            etu etu = (etu) objArr[1];
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
                        etu.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(115881);
                    return 0;
                case 2:
                    etu.LsZ = aVar3.UbS.zi();
                    AppMethodBeat.o(115881);
                    return 0;
                case 3:
                    etu.Lta = aVar3.UbS.zl();
                    AppMethodBeat.o(115881);
                    return 0;
                case 4:
                    etu.Timestamp = aVar3.UbS.zi();
                    AppMethodBeat.o(115881);
                    return 0;
                case 5:
                    etu.NpN = aVar3.UbS.zl();
                    AppMethodBeat.o(115881);
                    return 0;
                case 6:
                    etu.NqU = aVar3.UbS.zi();
                    AppMethodBeat.o(115881);
                    return 0;
                default:
                    AppMethodBeat.o(115881);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115881);
            return -1;
        }
    }
}
