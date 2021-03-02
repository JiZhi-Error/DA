package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ub extends a {
    public String Ldh;
    public String Ldi;
    public String Ldj;
    public int Ldk;
    public un Ldl;
    public int Ldm;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(113953);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Ldh != null) {
                aVar.e(1, this.Ldh);
            }
            if (this.Ldi != null) {
                aVar.e(2, this.Ldi);
            }
            if (this.Ldj != null) {
                aVar.e(3, this.Ldj);
            }
            aVar.aM(4, this.Ldk);
            if (this.Ldl != null) {
                aVar.ni(5, this.Ldl.computeSize());
                this.Ldl.writeFields(aVar);
            }
            aVar.aM(6, this.Ldm);
            AppMethodBeat.o(113953);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Ldh != null ? g.a.a.b.b.a.f(1, this.Ldh) + 0 : 0;
            if (this.Ldi != null) {
                f2 += g.a.a.b.b.a.f(2, this.Ldi);
            }
            if (this.Ldj != null) {
                f2 += g.a.a.b.b.a.f(3, this.Ldj);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.Ldk);
            if (this.Ldl != null) {
                bu += g.a.a.a.nh(5, this.Ldl.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.Ldm);
            AppMethodBeat.o(113953);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(113953);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ub ubVar = (ub) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ubVar.Ldh = aVar3.UbS.readString();
                    AppMethodBeat.o(113953);
                    return 0;
                case 2:
                    ubVar.Ldi = aVar3.UbS.readString();
                    AppMethodBeat.o(113953);
                    return 0;
                case 3:
                    ubVar.Ldj = aVar3.UbS.readString();
                    AppMethodBeat.o(113953);
                    return 0;
                case 4:
                    ubVar.Ldk = aVar3.UbS.zi();
                    AppMethodBeat.o(113953);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        un unVar = new un();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = unVar.populateBuilderWithField(aVar4, unVar, a.getNextFieldNumber(aVar4))) {
                        }
                        ubVar.Ldl = unVar;
                    }
                    AppMethodBeat.o(113953);
                    return 0;
                case 6:
                    ubVar.Ldm = aVar3.UbS.zi();
                    AppMethodBeat.o(113953);
                    return 0;
                default:
                    AppMethodBeat.o(113953);
                    return -1;
            }
        } else {
            AppMethodBeat.o(113953);
            return -1;
        }
    }
}
