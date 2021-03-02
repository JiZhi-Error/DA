package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class amc extends dop {
    public long LuJ;
    public String LuK;
    public String LuR;
    public String dNI;
    public int source;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104365);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.bb(2, this.LuJ);
            if (this.LuR != null) {
                aVar.e(3, this.LuR);
            }
            if (this.dNI != null) {
                aVar.e(4, this.dNI);
            }
            if (this.LuK != null) {
                aVar.e(5, this.LuK);
            }
            aVar.aM(6, this.source);
            AppMethodBeat.o(104365);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.r(2, this.LuJ);
            if (this.LuR != null) {
                nh += g.a.a.b.b.a.f(3, this.LuR);
            }
            if (this.dNI != null) {
                nh += g.a.a.b.b.a.f(4, this.dNI);
            }
            if (this.LuK != null) {
                nh += g.a.a.b.b.a.f(5, this.LuK);
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.source);
            AppMethodBeat.o(104365);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(104365);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            amc amc = (amc) objArr[1];
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
                        amc.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(104365);
                    return 0;
                case 2:
                    amc.LuJ = aVar3.UbS.zl();
                    AppMethodBeat.o(104365);
                    return 0;
                case 3:
                    amc.LuR = aVar3.UbS.readString();
                    AppMethodBeat.o(104365);
                    return 0;
                case 4:
                    amc.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(104365);
                    return 0;
                case 5:
                    amc.LuK = aVar3.UbS.readString();
                    AppMethodBeat.o(104365);
                    return 0;
                case 6:
                    amc.source = aVar3.UbS.zi();
                    AppMethodBeat.o(104365);
                    return 0;
                default:
                    AppMethodBeat.o(104365);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104365);
            return -1;
        }
    }
}
