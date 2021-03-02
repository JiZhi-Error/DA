package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class cpw extends a {
    public cat KPD;
    public cau KPE;
    public int MvP;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32350);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KPD == null) {
                b bVar = new b("Not all required fields were included: HardDevice");
                AppMethodBeat.o(32350);
                throw bVar;
            } else if (this.KPE == null) {
                b bVar2 = new b("Not all required fields were included: HardDeviceAttr");
                AppMethodBeat.o(32350);
                throw bVar2;
            } else {
                if (this.KPD != null) {
                    aVar.ni(1, this.KPD.computeSize());
                    this.KPD.writeFields(aVar);
                }
                if (this.KPE != null) {
                    aVar.ni(2, this.KPE.computeSize());
                    this.KPE.writeFields(aVar);
                }
                aVar.aM(3, this.MvP);
                AppMethodBeat.o(32350);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.KPD != null ? g.a.a.a.nh(1, this.KPD.computeSize()) + 0 : 0;
            if (this.KPE != null) {
                nh += g.a.a.a.nh(2, this.KPE.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.MvP);
            AppMethodBeat.o(32350);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KPD == null) {
                b bVar3 = new b("Not all required fields were included: HardDevice");
                AppMethodBeat.o(32350);
                throw bVar3;
            } else if (this.KPE == null) {
                b bVar4 = new b("Not all required fields were included: HardDeviceAttr");
                AppMethodBeat.o(32350);
                throw bVar4;
            } else {
                AppMethodBeat.o(32350);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cpw cpw = (cpw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cat cat = new cat();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cat.populateBuilderWithField(aVar4, cat, a.getNextFieldNumber(aVar4))) {
                        }
                        cpw.KPD = cat;
                    }
                    AppMethodBeat.o(32350);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cau cau = new cau();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cau.populateBuilderWithField(aVar5, cau, a.getNextFieldNumber(aVar5))) {
                        }
                        cpw.KPE = cau;
                    }
                    AppMethodBeat.o(32350);
                    return 0;
                case 3:
                    cpw.MvP = aVar3.UbS.zi();
                    AppMethodBeat.o(32350);
                    return 0;
                default:
                    AppMethodBeat.o(32350);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32350);
            return -1;
        }
    }
}
