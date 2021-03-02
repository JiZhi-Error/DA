package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class cpx extends a {
    public int DeleteFlag;
    public dqi Lqk;
    public int MvQ;
    public int MvR;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32351);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Lqk == null) {
                b bVar = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(32351);
                throw bVar;
            }
            if (this.Lqk != null) {
                aVar.ni(1, this.Lqk.computeSize());
                this.Lqk.writeFields(aVar);
            }
            aVar.aM(2, this.MvQ);
            aVar.aM(3, this.MvR);
            aVar.aM(4, this.DeleteFlag);
            AppMethodBeat.o(32351);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.Lqk != null ? g.a.a.a.nh(1, this.Lqk.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.MvQ) + g.a.a.b.b.a.bu(3, this.MvR) + g.a.a.b.b.a.bu(4, this.DeleteFlag);
            AppMethodBeat.o(32351);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Lqk == null) {
                b bVar2 = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(32351);
                throw bVar2;
            }
            AppMethodBeat.o(32351);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cpx cpx = (cpx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dqi.populateBuilderWithField(aVar4, dqi, a.getNextFieldNumber(aVar4))) {
                        }
                        cpx.Lqk = dqi;
                    }
                    AppMethodBeat.o(32351);
                    return 0;
                case 2:
                    cpx.MvQ = aVar3.UbS.zi();
                    AppMethodBeat.o(32351);
                    return 0;
                case 3:
                    cpx.MvR = aVar3.UbS.zi();
                    AppMethodBeat.o(32351);
                    return 0;
                case 4:
                    cpx.DeleteFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(32351);
                    return 0;
                default:
                    AppMethodBeat.o(32351);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32351);
            return -1;
        }
    }
}
