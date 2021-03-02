package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dm extends dop {
    public String AOk;
    public String Htm;
    public int Htr;
    public String KHB;
    public String dDj;
    public long eht;
    public int grV;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91346);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.bb(2, this.eht);
            if (this.dDj != null) {
                aVar.e(3, this.dDj);
            }
            if (this.AOk != null) {
                aVar.e(4, this.AOk);
            }
            if (this.Htm != null) {
                aVar.e(5, this.Htm);
            }
            aVar.aM(6, this.grV);
            if (this.KHB != null) {
                aVar.e(7, this.KHB);
            }
            aVar.aM(8, this.Htr);
            AppMethodBeat.o(91346);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.r(2, this.eht);
            if (this.dDj != null) {
                nh += g.a.a.b.b.a.f(3, this.dDj);
            }
            if (this.AOk != null) {
                nh += g.a.a.b.b.a.f(4, this.AOk);
            }
            if (this.Htm != null) {
                nh += g.a.a.b.b.a.f(5, this.Htm);
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.grV);
            if (this.KHB != null) {
                bu += g.a.a.b.b.a.f(7, this.KHB);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.Htr);
            AppMethodBeat.o(91346);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91346);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dm dmVar = (dm) objArr[1];
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
                        dmVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(91346);
                    return 0;
                case 2:
                    dmVar.eht = aVar3.UbS.zl();
                    AppMethodBeat.o(91346);
                    return 0;
                case 3:
                    dmVar.dDj = aVar3.UbS.readString();
                    AppMethodBeat.o(91346);
                    return 0;
                case 4:
                    dmVar.AOk = aVar3.UbS.readString();
                    AppMethodBeat.o(91346);
                    return 0;
                case 5:
                    dmVar.Htm = aVar3.UbS.readString();
                    AppMethodBeat.o(91346);
                    return 0;
                case 6:
                    dmVar.grV = aVar3.UbS.zi();
                    AppMethodBeat.o(91346);
                    return 0;
                case 7:
                    dmVar.KHB = aVar3.UbS.readString();
                    AppMethodBeat.o(91346);
                    return 0;
                case 8:
                    dmVar.Htr = aVar3.UbS.zi();
                    AppMethodBeat.o(91346);
                    return 0;
                default:
                    AppMethodBeat.o(91346);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91346);
            return -1;
        }
    }
}
