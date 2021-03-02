package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class wj extends dop {
    public String KHN;
    public String LhB;
    public String Lhy;
    public String Lhz;
    public String dNQ;
    public int yRL;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72435);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.dNQ != null) {
                aVar.e(2, this.dNQ);
            }
            if (this.LhB != null) {
                aVar.e(3, this.LhB);
            }
            if (this.KHN != null) {
                aVar.e(4, this.KHN);
            }
            aVar.aM(5, this.yRL);
            if (this.Lhz != null) {
                aVar.e(6, this.Lhz);
            }
            if (this.Lhy != null) {
                aVar.e(7, this.Lhy);
            }
            AppMethodBeat.o(72435);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.dNQ != null) {
                nh += g.a.a.b.b.a.f(2, this.dNQ);
            }
            if (this.LhB != null) {
                nh += g.a.a.b.b.a.f(3, this.LhB);
            }
            if (this.KHN != null) {
                nh += g.a.a.b.b.a.f(4, this.KHN);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.yRL);
            if (this.Lhz != null) {
                bu += g.a.a.b.b.a.f(6, this.Lhz);
            }
            if (this.Lhy != null) {
                bu += g.a.a.b.b.a.f(7, this.Lhy);
            }
            AppMethodBeat.o(72435);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72435);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            wj wjVar = (wj) objArr[1];
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
                        wjVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(72435);
                    return 0;
                case 2:
                    wjVar.dNQ = aVar3.UbS.readString();
                    AppMethodBeat.o(72435);
                    return 0;
                case 3:
                    wjVar.LhB = aVar3.UbS.readString();
                    AppMethodBeat.o(72435);
                    return 0;
                case 4:
                    wjVar.KHN = aVar3.UbS.readString();
                    AppMethodBeat.o(72435);
                    return 0;
                case 5:
                    wjVar.yRL = aVar3.UbS.zi();
                    AppMethodBeat.o(72435);
                    return 0;
                case 6:
                    wjVar.Lhz = aVar3.UbS.readString();
                    AppMethodBeat.o(72435);
                    return 0;
                case 7:
                    wjVar.Lhy = aVar3.UbS.readString();
                    AppMethodBeat.o(72435);
                    return 0;
                default:
                    AppMethodBeat.o(72435);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72435);
            return -1;
        }
    }
}
