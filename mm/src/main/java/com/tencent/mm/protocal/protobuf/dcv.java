package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dcv extends a {
    public int CreateTime;
    public String KTg;
    public int MHY;
    public LinkedList<dco> MHo = new LinkedList<>();
    public String MIb;
    public String MIc;
    public int MId;

    public dcv() {
        AppMethodBeat.i(209800);
        AppMethodBeat.o(209800);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209801);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MIb != null) {
                aVar.e(1, this.MIb);
            }
            if (this.KTg != null) {
                aVar.e(2, this.KTg);
            }
            aVar.aM(3, this.CreateTime);
            aVar.e(4, 8, this.MHo);
            if (this.MIc != null) {
                aVar.e(5, this.MIc);
            }
            aVar.aM(6, this.MHY);
            aVar.aM(7, this.MId);
            AppMethodBeat.o(209801);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.MIb != null ? g.a.a.b.b.a.f(1, this.MIb) + 0 : 0;
            if (this.KTg != null) {
                f2 += g.a.a.b.b.a.f(2, this.KTg);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.CreateTime) + g.a.a.a.c(4, 8, this.MHo);
            if (this.MIc != null) {
                bu += g.a.a.b.b.a.f(5, this.MIc);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.MHY) + g.a.a.b.b.a.bu(7, this.MId);
            AppMethodBeat.o(209801);
            return bu2;
        } else if (i2 == 2) {
            this.MHo.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209801);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dcv dcv = (dcv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dcv.MIb = aVar3.UbS.readString();
                    AppMethodBeat.o(209801);
                    return 0;
                case 2:
                    dcv.KTg = aVar3.UbS.readString();
                    AppMethodBeat.o(209801);
                    return 0;
                case 3:
                    dcv.CreateTime = aVar3.UbS.zi();
                    AppMethodBeat.o(209801);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dco dco = new dco();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dco.populateBuilderWithField(aVar4, dco, a.getNextFieldNumber(aVar4))) {
                        }
                        dcv.MHo.add(dco);
                    }
                    AppMethodBeat.o(209801);
                    return 0;
                case 5:
                    dcv.MIc = aVar3.UbS.readString();
                    AppMethodBeat.o(209801);
                    return 0;
                case 6:
                    dcv.MHY = aVar3.UbS.zi();
                    AppMethodBeat.o(209801);
                    return 0;
                case 7:
                    dcv.MId = aVar3.UbS.zi();
                    AppMethodBeat.o(209801);
                    return 0;
                default:
                    AppMethodBeat.o(209801);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209801);
            return -1;
        }
    }
}
