package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class era extends a {
    public ado Nor;
    public boolean Nos = true;
    public eqn Not;
    public String Nou;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117943);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Nor != null) {
                aVar.ni(1, this.Nor.computeSize());
                this.Nor.writeFields(aVar);
            }
            aVar.cc(2, this.Nos);
            if (this.Not != null) {
                aVar.ni(3, this.Not.computeSize());
                this.Not.writeFields(aVar);
            }
            if (this.Nou != null) {
                aVar.e(4, this.Nou);
            }
            AppMethodBeat.o(117943);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.Nor != null ? g.a.a.a.nh(1, this.Nor.computeSize()) + 0 : 0) + g.a.a.b.b.a.fS(2) + 1;
            if (this.Not != null) {
                nh += g.a.a.a.nh(3, this.Not.computeSize());
            }
            if (this.Nou != null) {
                nh += g.a.a.b.b.a.f(4, this.Nou);
            }
            AppMethodBeat.o(117943);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117943);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            era era = (era) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ado ado = new ado();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ado.populateBuilderWithField(aVar4, ado, a.getNextFieldNumber(aVar4))) {
                        }
                        era.Nor = ado;
                    }
                    AppMethodBeat.o(117943);
                    return 0;
                case 2:
                    era.Nos = aVar3.UbS.yZ();
                    AppMethodBeat.o(117943);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        eqn eqn = new eqn();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = eqn.populateBuilderWithField(aVar5, eqn, a.getNextFieldNumber(aVar5))) {
                        }
                        era.Not = eqn;
                    }
                    AppMethodBeat.o(117943);
                    return 0;
                case 4:
                    era.Nou = aVar3.UbS.readString();
                    AppMethodBeat.o(117943);
                    return 0;
                default:
                    AppMethodBeat.o(117943);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117943);
            return -1;
        }
    }
}
