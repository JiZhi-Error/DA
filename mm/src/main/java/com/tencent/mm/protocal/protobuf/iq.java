package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class iq extends a {
    public String ID;
    public SKBuiltinBuffer_t KMI;
    public String KMJ;
    public int KMK;
    public int Ret;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32135);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KMI == null) {
                b bVar = new b("Not all required fields were included: QRCodeBuffer");
                AppMethodBeat.o(32135);
                throw bVar;
            }
            aVar.aM(1, this.Ret);
            if (this.KMI != null) {
                aVar.ni(2, this.KMI.computeSize());
                this.KMI.writeFields(aVar);
            }
            if (this.KMJ != null) {
                aVar.e(3, this.KMJ);
            }
            aVar.aM(4, this.KMK);
            if (this.ID != null) {
                aVar.e(5, this.ID);
            }
            AppMethodBeat.o(32135);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Ret) + 0;
            if (this.KMI != null) {
                bu += g.a.a.a.nh(2, this.KMI.computeSize());
            }
            if (this.KMJ != null) {
                bu += g.a.a.b.b.a.f(3, this.KMJ);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(4, this.KMK);
            if (this.ID != null) {
                bu2 += g.a.a.b.b.a.f(5, this.ID);
            }
            AppMethodBeat.o(32135);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KMI == null) {
                b bVar2 = new b("Not all required fields were included: QRCodeBuffer");
                AppMethodBeat.o(32135);
                throw bVar2;
            }
            AppMethodBeat.o(32135);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            iq iqVar = (iq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    iqVar.Ret = aVar3.UbS.zi();
                    AppMethodBeat.o(32135);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        iqVar.KMI = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(32135);
                    return 0;
                case 3:
                    iqVar.KMJ = aVar3.UbS.readString();
                    AppMethodBeat.o(32135);
                    return 0;
                case 4:
                    iqVar.KMK = aVar3.UbS.zi();
                    AppMethodBeat.o(32135);
                    return 0;
                case 5:
                    iqVar.ID = aVar3.UbS.readString();
                    AppMethodBeat.o(32135);
                    return 0;
                default:
                    AppMethodBeat.o(32135);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32135);
            return -1;
        }
    }
}
