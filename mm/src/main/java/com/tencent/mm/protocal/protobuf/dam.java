package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dam extends a {
    public String HLy;
    public String Hwr;
    public String Hws;
    public dlq MFQ;
    public String desc;
    public String iwv;
    public String name;
    public String title;
    public int uSc;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72542);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.name != null) {
                aVar.e(1, this.name);
            }
            if (this.title != null) {
                aVar.e(2, this.title);
            }
            if (this.desc != null) {
                aVar.e(3, this.desc);
            }
            if (this.iwv != null) {
                aVar.e(4, this.iwv);
            }
            aVar.aM(5, this.uSc);
            if (this.HLy != null) {
                aVar.e(6, this.HLy);
            }
            if (this.Hwr != null) {
                aVar.e(7, this.Hwr);
            }
            if (this.Hws != null) {
                aVar.e(8, this.Hws);
            }
            if (this.MFQ != null) {
                aVar.ni(9, this.MFQ.computeSize());
                this.MFQ.writeFields(aVar);
            }
            AppMethodBeat.o(72542);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.name != null ? g.a.a.b.b.a.f(1, this.name) + 0 : 0;
            if (this.title != null) {
                f2 += g.a.a.b.b.a.f(2, this.title);
            }
            if (this.desc != null) {
                f2 += g.a.a.b.b.a.f(3, this.desc);
            }
            if (this.iwv != null) {
                f2 += g.a.a.b.b.a.f(4, this.iwv);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.uSc);
            if (this.HLy != null) {
                bu += g.a.a.b.b.a.f(6, this.HLy);
            }
            if (this.Hwr != null) {
                bu += g.a.a.b.b.a.f(7, this.Hwr);
            }
            if (this.Hws != null) {
                bu += g.a.a.b.b.a.f(8, this.Hws);
            }
            if (this.MFQ != null) {
                bu += g.a.a.a.nh(9, this.MFQ.computeSize());
            }
            AppMethodBeat.o(72542);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72542);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dam dam = (dam) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dam.name = aVar3.UbS.readString();
                    AppMethodBeat.o(72542);
                    return 0;
                case 2:
                    dam.title = aVar3.UbS.readString();
                    AppMethodBeat.o(72542);
                    return 0;
                case 3:
                    dam.desc = aVar3.UbS.readString();
                    AppMethodBeat.o(72542);
                    return 0;
                case 4:
                    dam.iwv = aVar3.UbS.readString();
                    AppMethodBeat.o(72542);
                    return 0;
                case 5:
                    dam.uSc = aVar3.UbS.zi();
                    AppMethodBeat.o(72542);
                    return 0;
                case 6:
                    dam.HLy = aVar3.UbS.readString();
                    AppMethodBeat.o(72542);
                    return 0;
                case 7:
                    dam.Hwr = aVar3.UbS.readString();
                    AppMethodBeat.o(72542);
                    return 0;
                case 8:
                    dam.Hws = aVar3.UbS.readString();
                    AppMethodBeat.o(72542);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dlq dlq = new dlq();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dlq.populateBuilderWithField(aVar4, dlq, a.getNextFieldNumber(aVar4))) {
                        }
                        dam.MFQ = dlq;
                    }
                    AppMethodBeat.o(72542);
                    return 0;
                default:
                    AppMethodBeat.o(72542);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72542);
            return -1;
        }
    }
}
