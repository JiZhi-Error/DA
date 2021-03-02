package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class eb extends a {
    public int KHY;
    public int KHZ;
    public int bDU;
    public float bDY;
    public int bHw;
    public int mCp;
    public int mCq;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(103178);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.bHw);
            aVar.aM(2, this.bDU);
            aVar.E(3, this.bDY);
            aVar.aM(4, this.KHY);
            aVar.aM(5, this.KHZ);
            aVar.aM(6, this.mCp);
            aVar.aM(7, this.mCq);
            AppMethodBeat.o(103178);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.bHw) + 0 + g.a.a.b.b.a.bu(2, this.bDU) + g.a.a.b.b.a.fS(3) + 4 + g.a.a.b.b.a.bu(4, this.KHY) + g.a.a.b.b.a.bu(5, this.KHZ) + g.a.a.b.b.a.bu(6, this.mCp) + g.a.a.b.b.a.bu(7, this.mCq);
            AppMethodBeat.o(103178);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(103178);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eb ebVar = (eb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ebVar.bHw = aVar3.UbS.zi();
                    AppMethodBeat.o(103178);
                    return 0;
                case 2:
                    ebVar.bDU = aVar3.UbS.zi();
                    AppMethodBeat.o(103178);
                    return 0;
                case 3:
                    ebVar.bDY = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(103178);
                    return 0;
                case 4:
                    ebVar.KHY = aVar3.UbS.zi();
                    AppMethodBeat.o(103178);
                    return 0;
                case 5:
                    ebVar.KHZ = aVar3.UbS.zi();
                    AppMethodBeat.o(103178);
                    return 0;
                case 6:
                    ebVar.mCp = aVar3.UbS.zi();
                    AppMethodBeat.o(103178);
                    return 0;
                case 7:
                    ebVar.mCq = aVar3.UbS.zi();
                    AppMethodBeat.o(103178);
                    return 0;
                default:
                    AppMethodBeat.o(103178);
                    return -1;
            }
        } else {
            AppMethodBeat.o(103178);
            return -1;
        }
    }
}
