package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.protocal.protobuf.if  reason: invalid class name and case insensitive filesystem */
public final class C2396if extends a {
    public SKBuiltinBuffer_t KMo;
    public ccb KMp;
    public int KMq;
    public SKBuiltinBuffer_t KMr;
    public String KMs;
    public int xMB;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(133152);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KMo == null) {
                b bVar = new b("Not all required fields were included: AxTicket");
                AppMethodBeat.o(133152);
                throw bVar;
            } else if (this.KMr == null) {
                b bVar2 = new b("Not all required fields were included: RandomKey");
                AppMethodBeat.o(133152);
                throw bVar2;
            } else {
                aVar.aM(1, this.xMB);
                if (this.KMo != null) {
                    aVar.ni(2, this.KMo.computeSize());
                    this.KMo.writeFields(aVar);
                }
                if (this.KMp != null) {
                    aVar.ni(3, this.KMp.computeSize());
                    this.KMp.writeFields(aVar);
                }
                aVar.aM(4, this.KMq);
                if (this.KMr != null) {
                    aVar.ni(5, this.KMr.computeSize());
                    this.KMr.writeFields(aVar);
                }
                if (this.KMs != null) {
                    aVar.e(6, this.KMs);
                }
                AppMethodBeat.o(133152);
                return 0;
            }
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.xMB) + 0;
            if (this.KMo != null) {
                bu += g.a.a.a.nh(2, this.KMo.computeSize());
            }
            if (this.KMp != null) {
                bu += g.a.a.a.nh(3, this.KMp.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(4, this.KMq);
            if (this.KMr != null) {
                bu2 += g.a.a.a.nh(5, this.KMr.computeSize());
            }
            if (this.KMs != null) {
                bu2 += g.a.a.b.b.a.f(6, this.KMs);
            }
            AppMethodBeat.o(133152);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KMo == null) {
                b bVar3 = new b("Not all required fields were included: AxTicket");
                AppMethodBeat.o(133152);
                throw bVar3;
            } else if (this.KMr == null) {
                b bVar4 = new b("Not all required fields were included: RandomKey");
                AppMethodBeat.o(133152);
                throw bVar4;
            } else {
                AppMethodBeat.o(133152);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            C2396if ifVar = (C2396if) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ifVar.xMB = aVar3.UbS.zi();
                    AppMethodBeat.o(133152);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        ifVar.KMo = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(133152);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ccb ccb = new ccb();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ccb.populateBuilderWithField(aVar5, ccb, a.getNextFieldNumber(aVar5))) {
                        }
                        ifVar.KMp = ccb;
                    }
                    AppMethodBeat.o(133152);
                    return 0;
                case 4:
                    ifVar.KMq = aVar3.UbS.zi();
                    AppMethodBeat.o(133152);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar6, sKBuiltinBuffer_t2, a.getNextFieldNumber(aVar6))) {
                        }
                        ifVar.KMr = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(133152);
                    return 0;
                case 6:
                    ifVar.KMs = aVar3.UbS.readString();
                    AppMethodBeat.o(133152);
                    return 0;
                default:
                    AppMethodBeat.o(133152);
                    return -1;
            }
        } else {
            AppMethodBeat.o(133152);
            return -1;
        }
    }
}
