package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bdw extends dop {
    public String LNB;
    public b LrK;
    public int bNu;
    public int iKP;
    public int scene;
    public aov uli;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169068);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.iKP);
            aVar.aM(3, this.bNu);
            if (this.LrK != null) {
                aVar.c(4, this.LrK);
            }
            if (this.LNB != null) {
                aVar.e(5, this.LNB);
            }
            aVar.aM(6, this.scene);
            if (this.uli != null) {
                aVar.ni(7, this.uli.computeSize());
                this.uli.writeFields(aVar);
            }
            AppMethodBeat.o(169068);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.iKP) + g.a.a.b.b.a.bu(3, this.bNu);
            if (this.LrK != null) {
                nh += g.a.a.b.b.a.b(4, this.LrK);
            }
            if (this.LNB != null) {
                nh += g.a.a.b.b.a.f(5, this.LNB);
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.scene);
            if (this.uli != null) {
                bu += g.a.a.a.nh(7, this.uli.computeSize());
            }
            AppMethodBeat.o(169068);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(169068);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bdw bdw = (bdw) objArr[1];
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
                        bdw.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(169068);
                    return 0;
                case 2:
                    bdw.iKP = aVar3.UbS.zi();
                    AppMethodBeat.o(169068);
                    return 0;
                case 3:
                    bdw.bNu = aVar3.UbS.zi();
                    AppMethodBeat.o(169068);
                    return 0;
                case 4:
                    bdw.LrK = aVar3.UbS.hPo();
                    AppMethodBeat.o(169068);
                    return 0;
                case 5:
                    bdw.LNB = aVar3.UbS.readString();
                    AppMethodBeat.o(169068);
                    return 0;
                case 6:
                    bdw.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(169068);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aov.populateBuilderWithField(aVar5, aov, dop.getNextFieldNumber(aVar5))) {
                        }
                        bdw.uli = aov;
                    }
                    AppMethodBeat.o(169068);
                    return 0;
                default:
                    AppMethodBeat.o(169068);
                    return -1;
            }
        } else {
            AppMethodBeat.o(169068);
            return -1;
        }
    }
}
