package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bvv extends dop {
    public int MbN;
    public int xIV;
    public LinkedList<dqi> xLF = new LinkedList<>();
    public int xLV;
    public int xLW;
    public String xLl;

    public bvv() {
        AppMethodBeat.i(152596);
        AppMethodBeat.o(152596);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152597);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.xIV);
            aVar.aM(3, this.xLV);
            aVar.aM(4, this.xLW);
            if (this.xLl != null) {
                aVar.e(5, this.xLl);
            }
            aVar.aM(6, this.MbN);
            aVar.e(7, 8, this.xLF);
            AppMethodBeat.o(152597);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.xIV) + g.a.a.b.b.a.bu(3, this.xLV) + g.a.a.b.b.a.bu(4, this.xLW);
            if (this.xLl != null) {
                nh += g.a.a.b.b.a.f(5, this.xLl);
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.MbN) + g.a.a.a.c(7, 8, this.xLF);
            AppMethodBeat.o(152597);
            return bu;
        } else if (i2 == 2) {
            this.xLF.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152597);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bvv bvv = (bvv) objArr[1];
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
                        bvv.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(152597);
                    return 0;
                case 2:
                    bvv.xIV = aVar3.UbS.zi();
                    AppMethodBeat.o(152597);
                    return 0;
                case 3:
                    bvv.xLV = aVar3.UbS.zi();
                    AppMethodBeat.o(152597);
                    return 0;
                case 4:
                    bvv.xLW = aVar3.UbS.zi();
                    AppMethodBeat.o(152597);
                    return 0;
                case 5:
                    bvv.xLl = aVar3.UbS.readString();
                    AppMethodBeat.o(152597);
                    return 0;
                case 6:
                    bvv.MbN = aVar3.UbS.zi();
                    AppMethodBeat.o(152597);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dqi.populateBuilderWithField(aVar5, dqi, dop.getNextFieldNumber(aVar5))) {
                        }
                        bvv.xLF.add(dqi);
                    }
                    AppMethodBeat.o(152597);
                    return 0;
                default:
                    AppMethodBeat.o(152597);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152597);
            return -1;
        }
    }
}
