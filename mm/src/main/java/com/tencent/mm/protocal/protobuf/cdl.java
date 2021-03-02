package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class cdl extends a {
    public String KPz;
    public String LoI;
    public dqi Mjj;
    public int Mjk;
    public String UserName;
    public int rBx;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(155423);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Mjj == null) {
                b bVar = new b("Not all required fields were included: NickName");
                AppMethodBeat.o(155423);
                throw bVar;
            }
            aVar.aM(1, this.rBx);
            if (this.Mjj != null) {
                aVar.ni(2, this.Mjj.computeSize());
                this.Mjj.writeFields(aVar);
            }
            if (this.KPz != null) {
                aVar.e(3, this.KPz);
            }
            if (this.LoI != null) {
                aVar.e(4, this.LoI);
            }
            if (this.UserName != null) {
                aVar.e(5, this.UserName);
            }
            aVar.aM(6, this.Mjk);
            AppMethodBeat.o(155423);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.rBx) + 0;
            if (this.Mjj != null) {
                bu += g.a.a.a.nh(2, this.Mjj.computeSize());
            }
            if (this.KPz != null) {
                bu += g.a.a.b.b.a.f(3, this.KPz);
            }
            if (this.LoI != null) {
                bu += g.a.a.b.b.a.f(4, this.LoI);
            }
            if (this.UserName != null) {
                bu += g.a.a.b.b.a.f(5, this.UserName);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.Mjk);
            AppMethodBeat.o(155423);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Mjj == null) {
                b bVar2 = new b("Not all required fields were included: NickName");
                AppMethodBeat.o(155423);
                throw bVar2;
            }
            AppMethodBeat.o(155423);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cdl cdl = (cdl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cdl.rBx = aVar3.UbS.zi();
                    AppMethodBeat.o(155423);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dqi.populateBuilderWithField(aVar4, dqi, a.getNextFieldNumber(aVar4))) {
                        }
                        cdl.Mjj = dqi;
                    }
                    AppMethodBeat.o(155423);
                    return 0;
                case 3:
                    cdl.KPz = aVar3.UbS.readString();
                    AppMethodBeat.o(155423);
                    return 0;
                case 4:
                    cdl.LoI = aVar3.UbS.readString();
                    AppMethodBeat.o(155423);
                    return 0;
                case 5:
                    cdl.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(155423);
                    return 0;
                case 6:
                    cdl.Mjk = aVar3.UbS.zi();
                    AppMethodBeat.o(155423);
                    return 0;
                default:
                    AppMethodBeat.o(155423);
                    return -1;
            }
        } else {
            AppMethodBeat.o(155423);
            return -1;
        }
    }
}
