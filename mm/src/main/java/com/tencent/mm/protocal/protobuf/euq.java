package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class euq extends dop {
    public int Llx;
    public int LsZ;
    public int NbR;
    public int NbS;
    public int NbT;
    public int NbU;
    public int NbV;
    public LinkedList<Integer> NbW = new LinkedList<>();
    public int NbX;
    public int NbY;
    public LinkedList<Integer> NbZ = new LinkedList<>();
    public int Nca;
    public int Ncb;

    public euq() {
        AppMethodBeat.i(115916);
        AppMethodBeat.o(115916);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(115917);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.LsZ);
            aVar.aM(3, this.NbR);
            aVar.aM(4, this.Llx);
            aVar.aM(5, this.NbS);
            aVar.aM(6, this.NbT);
            aVar.aM(7, this.NbU);
            aVar.aM(8, this.NbV);
            aVar.f(9, 2, this.NbW);
            aVar.aM(10, this.NbX);
            aVar.aM(11, this.NbY);
            aVar.f(12, 2, this.NbZ);
            aVar.aM(13, this.Nca);
            aVar.aM(14, this.Ncb);
            AppMethodBeat.o(115917);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LsZ) + g.a.a.b.b.a.bu(3, this.NbR) + g.a.a.b.b.a.bu(4, this.Llx) + g.a.a.b.b.a.bu(5, this.NbS) + g.a.a.b.b.a.bu(6, this.NbT) + g.a.a.b.b.a.bu(7, this.NbU) + g.a.a.b.b.a.bu(8, this.NbV) + g.a.a.a.d(9, 2, this.NbW) + g.a.a.b.b.a.bu(10, this.NbX) + g.a.a.b.b.a.bu(11, this.NbY) + g.a.a.a.d(12, 2, this.NbZ) + g.a.a.b.b.a.bu(13, this.Nca) + g.a.a.b.b.a.bu(14, this.Ncb);
            AppMethodBeat.o(115917);
            return nh;
        } else if (i2 == 2) {
            this.NbW.clear();
            this.NbZ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(115917);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            euq euq = (euq) objArr[1];
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
                        euq.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(115917);
                    return 0;
                case 2:
                    euq.LsZ = aVar3.UbS.zi();
                    AppMethodBeat.o(115917);
                    return 0;
                case 3:
                    euq.NbR = aVar3.UbS.zi();
                    AppMethodBeat.o(115917);
                    return 0;
                case 4:
                    euq.Llx = aVar3.UbS.zi();
                    AppMethodBeat.o(115917);
                    return 0;
                case 5:
                    euq.NbS = aVar3.UbS.zi();
                    AppMethodBeat.o(115917);
                    return 0;
                case 6:
                    euq.NbT = aVar3.UbS.zi();
                    AppMethodBeat.o(115917);
                    return 0;
                case 7:
                    euq.NbU = aVar3.UbS.zi();
                    AppMethodBeat.o(115917);
                    return 0;
                case 8:
                    euq.NbV = aVar3.UbS.zi();
                    AppMethodBeat.o(115917);
                    return 0;
                case 9:
                    euq.NbW = new g.a.a.a.a(aVar3.UbS.hPo().zy, unknownTagHandler).UbS.hPm();
                    AppMethodBeat.o(115917);
                    return 0;
                case 10:
                    euq.NbX = aVar3.UbS.zi();
                    AppMethodBeat.o(115917);
                    return 0;
                case 11:
                    euq.NbY = aVar3.UbS.zi();
                    AppMethodBeat.o(115917);
                    return 0;
                case 12:
                    euq.NbZ = new g.a.a.a.a(aVar3.UbS.hPo().zy, unknownTagHandler).UbS.hPm();
                    AppMethodBeat.o(115917);
                    return 0;
                case 13:
                    euq.Nca = aVar3.UbS.zi();
                    AppMethodBeat.o(115917);
                    return 0;
                case 14:
                    euq.Ncb = aVar3.UbS.zi();
                    AppMethodBeat.o(115917);
                    return 0;
                default:
                    AppMethodBeat.o(115917);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115917);
            return -1;
        }
    }
}
