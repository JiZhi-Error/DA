package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dpo extends a {
    public dbn MSM;
    public equ MSN;
    public int type;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(50111);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.type);
            if (this.MSM != null) {
                aVar.ni(2, this.MSM.computeSize());
                this.MSM.writeFields(aVar);
            }
            if (this.MSN != null) {
                aVar.ni(3, this.MSN.computeSize());
                this.MSN.writeFields(aVar);
            }
            AppMethodBeat.o(50111);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.type) + 0;
            if (this.MSM != null) {
                bu += g.a.a.a.nh(2, this.MSM.computeSize());
            }
            if (this.MSN != null) {
                bu += g.a.a.a.nh(3, this.MSN.computeSize());
            }
            AppMethodBeat.o(50111);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(50111);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dpo dpo = (dpo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dpo.type = aVar3.UbS.zi();
                    AppMethodBeat.o(50111);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dbn dbn = new dbn();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dbn.populateBuilderWithField(aVar4, dbn, a.getNextFieldNumber(aVar4))) {
                        }
                        dpo.MSM = dbn;
                    }
                    AppMethodBeat.o(50111);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        equ equ = new equ();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = equ.populateBuilderWithField(aVar5, equ, a.getNextFieldNumber(aVar5))) {
                        }
                        dpo.MSN = equ;
                    }
                    AppMethodBeat.o(50111);
                    return 0;
                default:
                    AppMethodBeat.o(50111);
                    return -1;
            }
        } else {
            AppMethodBeat.o(50111);
            return -1;
        }
    }
}
