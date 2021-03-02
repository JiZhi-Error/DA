package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cyw extends dop {
    public String MDU;
    public cyy MDV;
    public int MDW;
    public b MDX;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(223889);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.MDU != null) {
                aVar.e(2, this.MDU);
            }
            if (this.MDV != null) {
                aVar.ni(3, this.MDV.computeSize());
                this.MDV.writeFields(aVar);
            }
            aVar.aM(4, this.MDW);
            if (this.MDX != null) {
                aVar.c(5, this.MDX);
            }
            AppMethodBeat.o(223889);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.MDU != null) {
                nh += g.a.a.b.b.a.f(2, this.MDU);
            }
            if (this.MDV != null) {
                nh += g.a.a.a.nh(3, this.MDV.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.MDW);
            if (this.MDX != null) {
                bu += g.a.a.b.b.a.b(5, this.MDX);
            }
            AppMethodBeat.o(223889);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(223889);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cyw cyw = (cyw) objArr[1];
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
                        cyw.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(223889);
                    return 0;
                case 2:
                    cyw.MDU = aVar3.UbS.readString();
                    AppMethodBeat.o(223889);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cyy cyy = new cyy();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cyy.populateBuilderWithField(aVar5, cyy, dop.getNextFieldNumber(aVar5))) {
                        }
                        cyw.MDV = cyy;
                    }
                    AppMethodBeat.o(223889);
                    return 0;
                case 4:
                    cyw.MDW = aVar3.UbS.zi();
                    AppMethodBeat.o(223889);
                    return 0;
                case 5:
                    cyw.MDX = aVar3.UbS.hPo();
                    AppMethodBeat.o(223889);
                    return 0;
                default:
                    AppMethodBeat.o(223889);
                    return -1;
            }
        } else {
            AppMethodBeat.o(223889);
            return -1;
        }
    }
}
