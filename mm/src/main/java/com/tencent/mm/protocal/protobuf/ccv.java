package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class ccv extends a {
    public String MiH;
    public String MiL;
    public String MiM;
    public String MiN;
    public cyc MiO;
    public int dVv;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72508);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MiH == null) {
                b bVar = new b("Not all required fields were included: session_data");
                AppMethodBeat.o(72508);
                throw bVar;
            }
            aVar.aM(1, this.dVv);
            if (this.MiH != null) {
                aVar.e(2, this.MiH);
            }
            if (this.MiL != null) {
                aVar.e(3, this.MiL);
            }
            if (this.MiM != null) {
                aVar.e(4, this.MiM);
            }
            if (this.MiN != null) {
                aVar.e(5, this.MiN);
            }
            if (this.MiO != null) {
                aVar.ni(6, this.MiO.computeSize());
                this.MiO.writeFields(aVar);
            }
            AppMethodBeat.o(72508);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.dVv) + 0;
            if (this.MiH != null) {
                bu += g.a.a.b.b.a.f(2, this.MiH);
            }
            if (this.MiL != null) {
                bu += g.a.a.b.b.a.f(3, this.MiL);
            }
            if (this.MiM != null) {
                bu += g.a.a.b.b.a.f(4, this.MiM);
            }
            if (this.MiN != null) {
                bu += g.a.a.b.b.a.f(5, this.MiN);
            }
            if (this.MiO != null) {
                bu += g.a.a.a.nh(6, this.MiO.computeSize());
            }
            AppMethodBeat.o(72508);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MiH == null) {
                b bVar2 = new b("Not all required fields were included: session_data");
                AppMethodBeat.o(72508);
                throw bVar2;
            }
            AppMethodBeat.o(72508);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ccv ccv = (ccv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ccv.dVv = aVar3.UbS.zi();
                    AppMethodBeat.o(72508);
                    return 0;
                case 2:
                    ccv.MiH = aVar3.UbS.readString();
                    AppMethodBeat.o(72508);
                    return 0;
                case 3:
                    ccv.MiL = aVar3.UbS.readString();
                    AppMethodBeat.o(72508);
                    return 0;
                case 4:
                    ccv.MiM = aVar3.UbS.readString();
                    AppMethodBeat.o(72508);
                    return 0;
                case 5:
                    ccv.MiN = aVar3.UbS.readString();
                    AppMethodBeat.o(72508);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cyc cyc = new cyc();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cyc.populateBuilderWithField(aVar4, cyc, a.getNextFieldNumber(aVar4))) {
                        }
                        ccv.MiO = cyc;
                    }
                    AppMethodBeat.o(72508);
                    return 0;
                default:
                    AppMethodBeat.o(72508);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72508);
            return -1;
        }
    }
}
