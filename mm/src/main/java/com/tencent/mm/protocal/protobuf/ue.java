package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ue extends a {
    public String LdB;
    public int LdC;
    public String LdD;
    public un LdE;
    public String LdF;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(113956);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LdB != null) {
                aVar.e(1, this.LdB);
            }
            aVar.aM(2, this.LdC);
            if (this.LdD != null) {
                aVar.e(3, this.LdD);
            }
            if (this.LdE != null) {
                aVar.ni(4, this.LdE.computeSize());
                this.LdE.writeFields(aVar);
            }
            if (this.LdF != null) {
                aVar.e(5, this.LdF);
            }
            AppMethodBeat.o(113956);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.LdB != null ? g.a.a.b.b.a.f(1, this.LdB) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LdC);
            if (this.LdD != null) {
                f2 += g.a.a.b.b.a.f(3, this.LdD);
            }
            if (this.LdE != null) {
                f2 += g.a.a.a.nh(4, this.LdE.computeSize());
            }
            if (this.LdF != null) {
                f2 += g.a.a.b.b.a.f(5, this.LdF);
            }
            AppMethodBeat.o(113956);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(113956);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ue ueVar = (ue) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ueVar.LdB = aVar3.UbS.readString();
                    AppMethodBeat.o(113956);
                    return 0;
                case 2:
                    ueVar.LdC = aVar3.UbS.zi();
                    AppMethodBeat.o(113956);
                    return 0;
                case 3:
                    ueVar.LdD = aVar3.UbS.readString();
                    AppMethodBeat.o(113956);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        un unVar = new un();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = unVar.populateBuilderWithField(aVar4, unVar, a.getNextFieldNumber(aVar4))) {
                        }
                        ueVar.LdE = unVar;
                    }
                    AppMethodBeat.o(113956);
                    return 0;
                case 5:
                    ueVar.LdF = aVar3.UbS.readString();
                    AppMethodBeat.o(113956);
                    return 0;
                default:
                    AppMethodBeat.o(113956);
                    return -1;
            }
        } else {
            AppMethodBeat.o(113956);
            return -1;
        }
    }
}
