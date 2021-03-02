package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class go extends a {
    public int KKn;
    public int KKo;
    public gt KKp;
    public gn KKq;
    public int OpCode;
    public String jfi;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32118);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.jfi == null) {
                b bVar = new b("Not all required fields were included: AppId");
                AppMethodBeat.o(32118);
                throw bVar;
            }
            aVar.aM(1, this.OpCode);
            if (this.jfi != null) {
                aVar.e(2, this.jfi);
            }
            aVar.aM(3, this.KKn);
            aVar.aM(4, this.KKo);
            if (this.KKp != null) {
                aVar.ni(5, this.KKp.computeSize());
                this.KKp.writeFields(aVar);
            }
            if (this.KKq != null) {
                aVar.ni(6, this.KKq.computeSize());
                this.KKq.writeFields(aVar);
            }
            AppMethodBeat.o(32118);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.OpCode) + 0;
            if (this.jfi != null) {
                bu += g.a.a.b.b.a.f(2, this.jfi);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(3, this.KKn) + g.a.a.b.b.a.bu(4, this.KKo);
            if (this.KKp != null) {
                bu2 += g.a.a.a.nh(5, this.KKp.computeSize());
            }
            if (this.KKq != null) {
                bu2 += g.a.a.a.nh(6, this.KKq.computeSize());
            }
            AppMethodBeat.o(32118);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.jfi == null) {
                b bVar2 = new b("Not all required fields were included: AppId");
                AppMethodBeat.o(32118);
                throw bVar2;
            }
            AppMethodBeat.o(32118);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            go goVar = (go) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    goVar.OpCode = aVar3.UbS.zi();
                    AppMethodBeat.o(32118);
                    return 0;
                case 2:
                    goVar.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(32118);
                    return 0;
                case 3:
                    goVar.KKn = aVar3.UbS.zi();
                    AppMethodBeat.o(32118);
                    return 0;
                case 4:
                    goVar.KKo = aVar3.UbS.zi();
                    AppMethodBeat.o(32118);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        gt gtVar = new gt();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = gtVar.populateBuilderWithField(aVar4, gtVar, a.getNextFieldNumber(aVar4))) {
                        }
                        goVar.KKp = gtVar;
                    }
                    AppMethodBeat.o(32118);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        gn gnVar = new gn();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = gnVar.populateBuilderWithField(aVar5, gnVar, a.getNextFieldNumber(aVar5))) {
                        }
                        goVar.KKq = gnVar;
                    }
                    AppMethodBeat.o(32118);
                    return 0;
                default:
                    AppMethodBeat.o(32118);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32118);
            return -1;
        }
    }
}
