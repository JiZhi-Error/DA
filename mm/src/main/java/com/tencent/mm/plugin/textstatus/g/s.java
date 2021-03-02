package com.tencent.mm.plugin.textstatus.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.jr;
import g.a.a.c.a;
import java.util.LinkedList;

public final class s extends dop {
    public String GaI;
    public int GaR;
    public String Gas;
    public int type;
    public String username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(222841);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.GaI != null) {
                aVar.e(2, this.GaI);
            }
            if (this.Gas != null) {
                aVar.e(3, this.Gas);
            }
            if (this.username != null) {
                aVar.e(4, this.username);
            }
            aVar.aM(5, this.GaR);
            aVar.aM(6, this.type);
            AppMethodBeat.o(222841);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.GaI != null) {
                nh += g.a.a.b.b.a.f(2, this.GaI);
            }
            if (this.Gas != null) {
                nh += g.a.a.b.b.a.f(3, this.Gas);
            }
            if (this.username != null) {
                nh += g.a.a.b.b.a.f(4, this.username);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.GaR) + g.a.a.b.b.a.bu(6, this.type);
            AppMethodBeat.o(222841);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(222841);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            s sVar = (s) objArr[1];
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
                        sVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(222841);
                    return 0;
                case 2:
                    sVar.GaI = aVar3.UbS.readString();
                    AppMethodBeat.o(222841);
                    return 0;
                case 3:
                    sVar.Gas = aVar3.UbS.readString();
                    AppMethodBeat.o(222841);
                    return 0;
                case 4:
                    sVar.username = aVar3.UbS.readString();
                    AppMethodBeat.o(222841);
                    return 0;
                case 5:
                    sVar.GaR = aVar3.UbS.zi();
                    AppMethodBeat.o(222841);
                    return 0;
                case 6:
                    sVar.type = aVar3.UbS.zi();
                    AppMethodBeat.o(222841);
                    return 0;
                default:
                    AppMethodBeat.o(222841);
                    return -1;
            }
        } else {
            AppMethodBeat.o(222841);
            return -1;
        }
    }
}
