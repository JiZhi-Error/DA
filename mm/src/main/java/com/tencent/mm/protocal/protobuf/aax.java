package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class aax extends a {
    public int Lmf;
    public SKBuiltinBuffer_t Lmg;
    public int Lmh;
    public SKBuiltinBuffer_t Lmi;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(145668);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Lmg == null) {
                b bVar = new b("Not all required fields were included: OperationInfo");
                AppMethodBeat.o(145668);
                throw bVar;
            }
            aVar.aM(1, this.Lmf);
            if (this.Lmg != null) {
                aVar.ni(2, this.Lmg.computeSize());
                this.Lmg.writeFields(aVar);
            }
            aVar.aM(3, this.Lmh);
            if (this.Lmi != null) {
                aVar.ni(4, this.Lmi.computeSize());
                this.Lmi.writeFields(aVar);
            }
            AppMethodBeat.o(145668);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Lmf) + 0;
            if (this.Lmg != null) {
                bu += g.a.a.a.nh(2, this.Lmg.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(3, this.Lmh);
            if (this.Lmi != null) {
                bu2 += g.a.a.a.nh(4, this.Lmi.computeSize());
            }
            AppMethodBeat.o(145668);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Lmg == null) {
                b bVar2 = new b("Not all required fields were included: OperationInfo");
                AppMethodBeat.o(145668);
                throw bVar2;
            }
            AppMethodBeat.o(145668);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aax aax = (aax) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aax.Lmf = aVar3.UbS.zi();
                    AppMethodBeat.o(145668);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        aax.Lmg = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(145668);
                    return 0;
                case 3:
                    aax.Lmh = aVar3.UbS.zi();
                    AppMethodBeat.o(145668);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar5, sKBuiltinBuffer_t2, a.getNextFieldNumber(aVar5))) {
                        }
                        aax.Lmi = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(145668);
                    return 0;
                default:
                    AppMethodBeat.o(145668);
                    return -1;
            }
        } else {
            AppMethodBeat.o(145668);
            return -1;
        }
    }
}
