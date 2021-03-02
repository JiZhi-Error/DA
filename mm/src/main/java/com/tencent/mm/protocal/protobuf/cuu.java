package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cuu extends dop {
    public String ANo;
    public int HuF;
    public String HuS;
    public String MAa;
    public int yba;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91558);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.yba);
            aVar.aM(3, this.HuF);
            if (this.ANo != null) {
                aVar.e(4, this.ANo);
            }
            if (this.MAa != null) {
                aVar.e(5, this.MAa);
            }
            if (this.HuS != null) {
                aVar.e(100, this.HuS);
            }
            AppMethodBeat.o(91558);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.yba) + g.a.a.b.b.a.bu(3, this.HuF);
            if (this.ANo != null) {
                nh += g.a.a.b.b.a.f(4, this.ANo);
            }
            if (this.MAa != null) {
                nh += g.a.a.b.b.a.f(5, this.MAa);
            }
            if (this.HuS != null) {
                nh += g.a.a.b.b.a.f(100, this.HuS);
            }
            AppMethodBeat.o(91558);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91558);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cuu cuu = (cuu) objArr[1];
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
                        cuu.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(91558);
                    return 0;
                case 2:
                    cuu.yba = aVar3.UbS.zi();
                    AppMethodBeat.o(91558);
                    return 0;
                case 3:
                    cuu.HuF = aVar3.UbS.zi();
                    AppMethodBeat.o(91558);
                    return 0;
                case 4:
                    cuu.ANo = aVar3.UbS.readString();
                    AppMethodBeat.o(91558);
                    return 0;
                case 5:
                    cuu.MAa = aVar3.UbS.readString();
                    AppMethodBeat.o(91558);
                    return 0;
                case 100:
                    cuu.HuS = aVar3.UbS.readString();
                    AppMethodBeat.o(91558);
                    return 0;
                default:
                    AppMethodBeat.o(91558);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91558);
            return -1;
        }
    }
}
