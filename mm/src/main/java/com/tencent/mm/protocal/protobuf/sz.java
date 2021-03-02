package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class sz extends dop {
    public b LaW;
    public b LaX;
    public int LaY;
    public int LaZ;
    public int Lba;
    public int jlm;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(218975);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.LaW != null) {
                aVar.c(2, this.LaW);
            }
            aVar.aM(3, this.jlm);
            if (this.LaX != null) {
                aVar.c(4, this.LaX);
            }
            aVar.aM(5, this.LaY);
            aVar.aM(6, this.LaZ);
            aVar.aM(7, this.Lba);
            AppMethodBeat.o(218975);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.LaW != null) {
                nh += g.a.a.b.b.a.b(2, this.LaW);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.jlm);
            if (this.LaX != null) {
                bu += g.a.a.b.b.a.b(4, this.LaX);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.LaY) + g.a.a.b.b.a.bu(6, this.LaZ) + g.a.a.b.b.a.bu(7, this.Lba);
            AppMethodBeat.o(218975);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(218975);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            sz szVar = (sz) objArr[1];
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
                        szVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(218975);
                    return 0;
                case 2:
                    szVar.LaW = aVar3.UbS.hPo();
                    AppMethodBeat.o(218975);
                    return 0;
                case 3:
                    szVar.jlm = aVar3.UbS.zi();
                    AppMethodBeat.o(218975);
                    return 0;
                case 4:
                    szVar.LaX = aVar3.UbS.hPo();
                    AppMethodBeat.o(218975);
                    return 0;
                case 5:
                    szVar.LaY = aVar3.UbS.zi();
                    AppMethodBeat.o(218975);
                    return 0;
                case 6:
                    szVar.LaZ = aVar3.UbS.zi();
                    AppMethodBeat.o(218975);
                    return 0;
                case 7:
                    szVar.Lba = aVar3.UbS.zi();
                    AppMethodBeat.o(218975);
                    return 0;
                default:
                    AppMethodBeat.o(218975);
                    return -1;
            }
        } else {
            AppMethodBeat.o(218975);
            return -1;
        }
    }
}
