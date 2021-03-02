package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class epe extends a {
    public String Desc;
    public int ID;
    public SKBuiltinBuffer_t Nna;
    public SKBuiltinBuffer_t Nnb;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32492);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Nna == null) {
                b bVar = new b("Not all required fields were included: Icon");
                AppMethodBeat.o(32492);
                throw bVar;
            } else if (this.Nnb == null) {
                b bVar2 = new b("Not all required fields were included: HDIcon");
                AppMethodBeat.o(32492);
                throw bVar2;
            } else {
                aVar.aM(1, this.ID);
                if (this.Desc != null) {
                    aVar.e(2, this.Desc);
                }
                if (this.Nna != null) {
                    aVar.ni(3, this.Nna.computeSize());
                    this.Nna.writeFields(aVar);
                }
                if (this.Nnb != null) {
                    aVar.ni(4, this.Nnb.computeSize());
                    this.Nnb.writeFields(aVar);
                }
                AppMethodBeat.o(32492);
                return 0;
            }
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.ID) + 0;
            if (this.Desc != null) {
                bu += g.a.a.b.b.a.f(2, this.Desc);
            }
            if (this.Nna != null) {
                bu += g.a.a.a.nh(3, this.Nna.computeSize());
            }
            if (this.Nnb != null) {
                bu += g.a.a.a.nh(4, this.Nnb.computeSize());
            }
            AppMethodBeat.o(32492);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Nna == null) {
                b bVar3 = new b("Not all required fields were included: Icon");
                AppMethodBeat.o(32492);
                throw bVar3;
            } else if (this.Nnb == null) {
                b bVar4 = new b("Not all required fields were included: HDIcon");
                AppMethodBeat.o(32492);
                throw bVar4;
            } else {
                AppMethodBeat.o(32492);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            epe epe = (epe) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    epe.ID = aVar3.UbS.zi();
                    AppMethodBeat.o(32492);
                    return 0;
                case 2:
                    epe.Desc = aVar3.UbS.readString();
                    AppMethodBeat.o(32492);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        epe.Nna = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(32492);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar5, sKBuiltinBuffer_t2, a.getNextFieldNumber(aVar5))) {
                        }
                        epe.Nnb = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(32492);
                    return 0;
                default:
                    AppMethodBeat.o(32492);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32492);
            return -1;
        }
    }
}
