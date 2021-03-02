package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bil extends dop {
    public int LSC;
    public String app_id;
    public String pRX;
    public b pUz;
    public int qcJ;
    public String qcK;
    public String qcL;
    public String qcM;
    public String qcN;
    public int time_stamp;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(114000);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.app_id != null) {
                aVar.e(2, this.app_id);
            }
            aVar.aM(3, this.qcJ);
            if (this.qcK != null) {
                aVar.e(4, this.qcK);
            }
            if (this.qcL != null) {
                aVar.e(5, this.qcL);
            }
            aVar.aM(6, this.time_stamp);
            if (this.qcM != null) {
                aVar.e(7, this.qcM);
            }
            if (this.pRX != null) {
                aVar.e(8, this.pRX);
            }
            if (this.qcN != null) {
                aVar.e(9, this.qcN);
            }
            if (this.pUz != null) {
                aVar.c(10, this.pUz);
            }
            aVar.aM(11, this.LSC);
            AppMethodBeat.o(114000);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.app_id != null) {
                nh += g.a.a.b.b.a.f(2, this.app_id);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.qcJ);
            if (this.qcK != null) {
                bu += g.a.a.b.b.a.f(4, this.qcK);
            }
            if (this.qcL != null) {
                bu += g.a.a.b.b.a.f(5, this.qcL);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.time_stamp);
            if (this.qcM != null) {
                bu2 += g.a.a.b.b.a.f(7, this.qcM);
            }
            if (this.pRX != null) {
                bu2 += g.a.a.b.b.a.f(8, this.pRX);
            }
            if (this.qcN != null) {
                bu2 += g.a.a.b.b.a.f(9, this.qcN);
            }
            if (this.pUz != null) {
                bu2 += g.a.a.b.b.a.b(10, this.pUz);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(11, this.LSC);
            AppMethodBeat.o(114000);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(114000);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bil bil = (bil) objArr[1];
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
                        bil.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(114000);
                    return 0;
                case 2:
                    bil.app_id = aVar3.UbS.readString();
                    AppMethodBeat.o(114000);
                    return 0;
                case 3:
                    bil.qcJ = aVar3.UbS.zi();
                    AppMethodBeat.o(114000);
                    return 0;
                case 4:
                    bil.qcK = aVar3.UbS.readString();
                    AppMethodBeat.o(114000);
                    return 0;
                case 5:
                    bil.qcL = aVar3.UbS.readString();
                    AppMethodBeat.o(114000);
                    return 0;
                case 6:
                    bil.time_stamp = aVar3.UbS.zi();
                    AppMethodBeat.o(114000);
                    return 0;
                case 7:
                    bil.qcM = aVar3.UbS.readString();
                    AppMethodBeat.o(114000);
                    return 0;
                case 8:
                    bil.pRX = aVar3.UbS.readString();
                    AppMethodBeat.o(114000);
                    return 0;
                case 9:
                    bil.qcN = aVar3.UbS.readString();
                    AppMethodBeat.o(114000);
                    return 0;
                case 10:
                    bil.pUz = aVar3.UbS.hPo();
                    AppMethodBeat.o(114000);
                    return 0;
                case 11:
                    bil.LSC = aVar3.UbS.zi();
                    AppMethodBeat.o(114000);
                    return 0;
                default:
                    AppMethodBeat.o(114000);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114000);
            return -1;
        }
    }
}
