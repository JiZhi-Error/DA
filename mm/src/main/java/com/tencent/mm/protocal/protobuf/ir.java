package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class ir extends a implements dyp {
    public String ID;
    public SKBuiltinBuffer_t KLU;
    public String KMH;
    public SKBuiltinBuffer_t KMI;
    public String KMJ;
    public int KMK;
    public String KML;
    public String KMM;
    public int Ret;

    @Override // com.tencent.mm.protocal.protobuf.dyp
    public final int getRet() {
        return this.Ret;
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32136);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KMI == null) {
                b bVar = new b("Not all required fields were included: QRCodeBuffer");
                AppMethodBeat.o(32136);
                throw bVar;
            } else if (this.KLU == null) {
                b bVar2 = new b("Not all required fields were included: Key");
                AppMethodBeat.o(32136);
                throw bVar2;
            } else {
                aVar.aM(1, this.Ret);
                if (this.KMI != null) {
                    aVar.ni(2, this.KMI.computeSize());
                    this.KMI.writeFields(aVar);
                }
                if (this.KMJ != null) {
                    aVar.e(3, this.KMJ);
                }
                if (this.KLU != null) {
                    aVar.ni(4, this.KLU.computeSize());
                    this.KLU.writeFields(aVar);
                }
                if (this.KML != null) {
                    aVar.e(5, this.KML);
                }
                if (this.KMM != null) {
                    aVar.e(6, this.KMM);
                }
                aVar.aM(7, this.KMK);
                if (this.ID != null) {
                    aVar.e(8, this.ID);
                }
                if (this.KMH != null) {
                    aVar.e(9, this.KMH);
                }
                AppMethodBeat.o(32136);
                return 0;
            }
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Ret) + 0;
            if (this.KMI != null) {
                bu += g.a.a.a.nh(2, this.KMI.computeSize());
            }
            if (this.KMJ != null) {
                bu += g.a.a.b.b.a.f(3, this.KMJ);
            }
            if (this.KLU != null) {
                bu += g.a.a.a.nh(4, this.KLU.computeSize());
            }
            if (this.KML != null) {
                bu += g.a.a.b.b.a.f(5, this.KML);
            }
            if (this.KMM != null) {
                bu += g.a.a.b.b.a.f(6, this.KMM);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.KMK);
            if (this.ID != null) {
                bu2 += g.a.a.b.b.a.f(8, this.ID);
            }
            if (this.KMH != null) {
                bu2 += g.a.a.b.b.a.f(9, this.KMH);
            }
            AppMethodBeat.o(32136);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KMI == null) {
                b bVar3 = new b("Not all required fields were included: QRCodeBuffer");
                AppMethodBeat.o(32136);
                throw bVar3;
            } else if (this.KLU == null) {
                b bVar4 = new b("Not all required fields were included: Key");
                AppMethodBeat.o(32136);
                throw bVar4;
            } else {
                AppMethodBeat.o(32136);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ir irVar = (ir) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    irVar.Ret = aVar3.UbS.zi();
                    AppMethodBeat.o(32136);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        irVar.KMI = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(32136);
                    return 0;
                case 3:
                    irVar.KMJ = aVar3.UbS.readString();
                    AppMethodBeat.o(32136);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar5, sKBuiltinBuffer_t2, a.getNextFieldNumber(aVar5))) {
                        }
                        irVar.KLU = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(32136);
                    return 0;
                case 5:
                    irVar.KML = aVar3.UbS.readString();
                    AppMethodBeat.o(32136);
                    return 0;
                case 6:
                    irVar.KMM = aVar3.UbS.readString();
                    AppMethodBeat.o(32136);
                    return 0;
                case 7:
                    irVar.KMK = aVar3.UbS.zi();
                    AppMethodBeat.o(32136);
                    return 0;
                case 8:
                    irVar.ID = aVar3.UbS.readString();
                    AppMethodBeat.o(32136);
                    return 0;
                case 9:
                    irVar.KMH = aVar3.UbS.readString();
                    AppMethodBeat.o(32136);
                    return 0;
                default:
                    AppMethodBeat.o(32136);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32136);
            return -1;
        }
    }
}
