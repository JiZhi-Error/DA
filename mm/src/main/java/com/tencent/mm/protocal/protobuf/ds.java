package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class ds extends a {
    public dzd KHG;
    public dqi KHH;
    public int KHI;
    public dmo KHJ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125705);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KHG == null) {
                b bVar = new b("Not all required fields were included: SnsADObject");
                AppMethodBeat.o(125705);
                throw bVar;
            }
            if (this.KHG != null) {
                aVar.ni(1, this.KHG.computeSize());
                this.KHG.writeFields(aVar);
            }
            if (this.KHH != null) {
                aVar.ni(2, this.KHH.computeSize());
                this.KHH.writeFields(aVar);
            }
            aVar.aM(3, this.KHI);
            if (this.KHJ != null) {
                aVar.ni(4, this.KHJ.computeSize());
                this.KHJ.writeFields(aVar);
            }
            AppMethodBeat.o(125705);
            return 0;
        } else if (i2 == 1) {
            int nh = this.KHG != null ? g.a.a.a.nh(1, this.KHG.computeSize()) + 0 : 0;
            if (this.KHH != null) {
                nh += g.a.a.a.nh(2, this.KHH.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.KHI);
            if (this.KHJ != null) {
                bu += g.a.a.a.nh(4, this.KHJ.computeSize());
            }
            AppMethodBeat.o(125705);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KHG == null) {
                b bVar2 = new b("Not all required fields were included: SnsADObject");
                AppMethodBeat.o(125705);
                throw bVar2;
            }
            AppMethodBeat.o(125705);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ds dsVar = (ds) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dzd dzd = new dzd();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dzd.populateBuilderWithField(aVar4, dzd, a.getNextFieldNumber(aVar4))) {
                        }
                        dsVar.KHG = dzd;
                    }
                    AppMethodBeat.o(125705);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dqi.populateBuilderWithField(aVar5, dqi, a.getNextFieldNumber(aVar5))) {
                        }
                        dsVar.KHH = dqi;
                    }
                    AppMethodBeat.o(125705);
                    return 0;
                case 3:
                    dsVar.KHI = aVar3.UbS.zi();
                    AppMethodBeat.o(125705);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dmo dmo = new dmo();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dmo.populateBuilderWithField(aVar6, dmo, a.getNextFieldNumber(aVar6))) {
                        }
                        dsVar.KHJ = dmo;
                    }
                    AppMethodBeat.o(125705);
                    return 0;
                default:
                    AppMethodBeat.o(125705);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125705);
            return -1;
        }
    }
}
