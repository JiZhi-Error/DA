package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public class bhc extends a {
    public String LQP;
    public LinkedList<String> LQT = new LinkedList<>();
    public LinkedList<bhd> LQU = new LinkedList<>();

    public bhc() {
        AppMethodBeat.i(223884);
        AppMethodBeat.o(223884);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(223885);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LQP != null) {
                aVar.e(1, this.LQP);
            }
            aVar.e(2, 1, this.LQT);
            aVar.e(3, 8, this.LQU);
            AppMethodBeat.o(223885);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.LQP != null ? g.a.a.b.b.a.f(1, this.LQP) + 0 : 0) + g.a.a.a.c(2, 1, this.LQT) + g.a.a.a.c(3, 8, this.LQU);
            AppMethodBeat.o(223885);
            return f2;
        } else if (i2 == 2) {
            this.LQT.clear();
            this.LQU.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(223885);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bhc bhc = (bhc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bhc.LQP = aVar3.UbS.readString();
                    AppMethodBeat.o(223885);
                    return 0;
                case 2:
                    bhc.LQT.add(aVar3.UbS.readString());
                    AppMethodBeat.o(223885);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        bhd bhd = new bhd();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = bhd.populateBuilderWithField(aVar4, bhd, a.getNextFieldNumber(aVar4))) {
                        }
                        bhc.LQU.add(bhd);
                    }
                    AppMethodBeat.o(223885);
                    return 0;
                default:
                    AppMethodBeat.o(223885);
                    return -1;
            }
        } else {
            AppMethodBeat.o(223885);
            return -1;
        }
    }
}
