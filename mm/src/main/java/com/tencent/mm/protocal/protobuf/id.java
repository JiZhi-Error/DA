package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class id extends dop {
    public int KCx;
    public String KLL;
    public String KLO;
    public SKBuiltinBuffer_t KLQ;
    public SKBuiltinBuffer_t KMo;
    public String keb;
    public String oTI;
    public String rBH;
    public String rBI;
    public int xMB;
    public String yiZ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(133150);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.KMo == null) {
                b bVar = new b("Not all required fields were included: AxTicket");
                AppMethodBeat.o(133150);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.xMB);
            if (this.KMo != null) {
                aVar.ni(3, this.KMo.computeSize());
                this.KMo.writeFields(aVar);
            }
            if (this.yiZ != null) {
                aVar.e(4, this.yiZ);
            }
            if (this.KLL != null) {
                aVar.e(5, this.KLL);
            }
            if (this.keb != null) {
                aVar.e(6, this.keb);
            }
            if (this.oTI != null) {
                aVar.e(7, this.oTI);
            }
            if (this.KLO != null) {
                aVar.e(8, this.KLO);
            }
            if (this.rBI != null) {
                aVar.e(9, this.rBI);
            }
            if (this.rBH != null) {
                aVar.e(10, this.rBH);
            }
            aVar.aM(11, this.KCx);
            if (this.KLQ != null) {
                aVar.ni(12, this.KLQ.computeSize());
                this.KLQ.writeFields(aVar);
            }
            AppMethodBeat.o(133150);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.xMB);
            if (this.KMo != null) {
                nh += g.a.a.a.nh(3, this.KMo.computeSize());
            }
            if (this.yiZ != null) {
                nh += g.a.a.b.b.a.f(4, this.yiZ);
            }
            if (this.KLL != null) {
                nh += g.a.a.b.b.a.f(5, this.KLL);
            }
            if (this.keb != null) {
                nh += g.a.a.b.b.a.f(6, this.keb);
            }
            if (this.oTI != null) {
                nh += g.a.a.b.b.a.f(7, this.oTI);
            }
            if (this.KLO != null) {
                nh += g.a.a.b.b.a.f(8, this.KLO);
            }
            if (this.rBI != null) {
                nh += g.a.a.b.b.a.f(9, this.rBI);
            }
            if (this.rBH != null) {
                nh += g.a.a.b.b.a.f(10, this.rBH);
            }
            int bu = nh + g.a.a.b.b.a.bu(11, this.KCx);
            if (this.KLQ != null) {
                bu += g.a.a.a.nh(12, this.KLQ.computeSize());
            }
            AppMethodBeat.o(133150);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KMo == null) {
                b bVar2 = new b("Not all required fields were included: AxTicket");
                AppMethodBeat.o(133150);
                throw bVar2;
            }
            AppMethodBeat.o(133150);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            id idVar = (id) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.populateBuilderWithField(aVar4, jrVar, dop.getNextFieldNumber(aVar4))) {
                        }
                        idVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(133150);
                    return 0;
                case 2:
                    idVar.xMB = aVar3.UbS.zi();
                    AppMethodBeat.o(133150);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar5))) {
                        }
                        idVar.KMo = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(133150);
                    return 0;
                case 4:
                    idVar.yiZ = aVar3.UbS.readString();
                    AppMethodBeat.o(133150);
                    return 0;
                case 5:
                    idVar.KLL = aVar3.UbS.readString();
                    AppMethodBeat.o(133150);
                    return 0;
                case 6:
                    idVar.keb = aVar3.UbS.readString();
                    AppMethodBeat.o(133150);
                    return 0;
                case 7:
                    idVar.oTI = aVar3.UbS.readString();
                    AppMethodBeat.o(133150);
                    return 0;
                case 8:
                    idVar.KLO = aVar3.UbS.readString();
                    AppMethodBeat.o(133150);
                    return 0;
                case 9:
                    idVar.rBI = aVar3.UbS.readString();
                    AppMethodBeat.o(133150);
                    return 0;
                case 10:
                    idVar.rBH = aVar3.UbS.readString();
                    AppMethodBeat.o(133150);
                    return 0;
                case 11:
                    idVar.KCx = aVar3.UbS.zi();
                    AppMethodBeat.o(133150);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar6, sKBuiltinBuffer_t2, dop.getNextFieldNumber(aVar6))) {
                        }
                        idVar.KLQ = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(133150);
                    return 0;
                default:
                    AppMethodBeat.o(133150);
                    return -1;
            }
        } else {
            AppMethodBeat.o(133150);
            return -1;
        }
    }
}
