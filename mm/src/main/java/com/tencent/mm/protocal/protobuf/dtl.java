package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dtl extends dop {
    public int KUh;
    public String MVB;
    public int MyL;
    public String UserName;
    public String iAc;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152688);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.UserName != null) {
                aVar.e(2, this.UserName);
            }
            if (this.iAc != null) {
                aVar.e(3, this.iAc);
            }
            aVar.aM(4, this.MyL);
            aVar.aM(5, this.KUh);
            if (this.MVB != null) {
                aVar.e(6, this.MVB);
            }
            AppMethodBeat.o(152688);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.UserName != null) {
                nh += g.a.a.b.b.a.f(2, this.UserName);
            }
            if (this.iAc != null) {
                nh += g.a.a.b.b.a.f(3, this.iAc);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.MyL) + g.a.a.b.b.a.bu(5, this.KUh);
            if (this.MVB != null) {
                bu += g.a.a.b.b.a.f(6, this.MVB);
            }
            AppMethodBeat.o(152688);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152688);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dtl dtl = (dtl) objArr[1];
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
                        dtl.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(152688);
                    return 0;
                case 2:
                    dtl.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(152688);
                    return 0;
                case 3:
                    dtl.iAc = aVar3.UbS.readString();
                    AppMethodBeat.o(152688);
                    return 0;
                case 4:
                    dtl.MyL = aVar3.UbS.zi();
                    AppMethodBeat.o(152688);
                    return 0;
                case 5:
                    dtl.KUh = aVar3.UbS.zi();
                    AppMethodBeat.o(152688);
                    return 0;
                case 6:
                    dtl.MVB = aVar3.UbS.readString();
                    AppMethodBeat.o(152688);
                    return 0;
                default:
                    AppMethodBeat.o(152688);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152688);
            return -1;
        }
    }
}
