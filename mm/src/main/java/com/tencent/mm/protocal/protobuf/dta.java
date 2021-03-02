package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class dta extends a {
    public aif KKX;
    public SKBuiltinBuffer_t KKY;
    public SKBuiltinBuffer_t KKZ;
    public int KLn;
    public SKBuiltinBuffer_t KLq;
    public SKBuiltinBuffer_t KLr;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(133194);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KKZ == null) {
                b bVar = new b("Not all required fields were included: AutoAuthKey");
                AppMethodBeat.o(133194);
                throw bVar;
            } else if (this.KKX == null) {
                b bVar2 = new b("Not all required fields were included: SvrPubECDHKey");
                AppMethodBeat.o(133194);
                throw bVar2;
            } else if (this.KKY == null) {
                b bVar3 = new b("Not all required fields were included: SessionKey");
                AppMethodBeat.o(133194);
                throw bVar3;
            } else {
                if (this.KKZ != null) {
                    aVar.ni(1, this.KKZ.computeSize());
                    this.KKZ.writeFields(aVar);
                }
                if (this.KKX != null) {
                    aVar.ni(2, this.KKX.computeSize());
                    this.KKX.writeFields(aVar);
                }
                if (this.KKY != null) {
                    aVar.ni(3, this.KKY.computeSize());
                    this.KKY.writeFields(aVar);
                }
                aVar.aM(4, this.KLn);
                if (this.KLq != null) {
                    aVar.ni(5, this.KLq.computeSize());
                    this.KLq.writeFields(aVar);
                }
                if (this.KLr != null) {
                    aVar.ni(6, this.KLr.computeSize());
                    this.KLr.writeFields(aVar);
                }
                AppMethodBeat.o(133194);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.KKZ != null ? g.a.a.a.nh(1, this.KKZ.computeSize()) + 0 : 0;
            if (this.KKX != null) {
                nh += g.a.a.a.nh(2, this.KKX.computeSize());
            }
            if (this.KKY != null) {
                nh += g.a.a.a.nh(3, this.KKY.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.KLn);
            if (this.KLq != null) {
                bu += g.a.a.a.nh(5, this.KLq.computeSize());
            }
            if (this.KLr != null) {
                bu += g.a.a.a.nh(6, this.KLr.computeSize());
            }
            AppMethodBeat.o(133194);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KKZ == null) {
                b bVar4 = new b("Not all required fields were included: AutoAuthKey");
                AppMethodBeat.o(133194);
                throw bVar4;
            } else if (this.KKX == null) {
                b bVar5 = new b("Not all required fields were included: SvrPubECDHKey");
                AppMethodBeat.o(133194);
                throw bVar5;
            } else if (this.KKY == null) {
                b bVar6 = new b("Not all required fields were included: SessionKey");
                AppMethodBeat.o(133194);
                throw bVar6;
            } else {
                AppMethodBeat.o(133194);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dta dta = (dta) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        dta.KKZ = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(133194);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aif aif = new aif();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aif.populateBuilderWithField(aVar5, aif, a.getNextFieldNumber(aVar5))) {
                        }
                        dta.KKX = aif;
                    }
                    AppMethodBeat.o(133194);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar6, sKBuiltinBuffer_t2, a.getNextFieldNumber(aVar6))) {
                        }
                        dta.KKY = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(133194);
                    return 0;
                case 4:
                    dta.KLn = aVar3.UbS.zi();
                    AppMethodBeat.o(133194);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t3 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = sKBuiltinBuffer_t3.populateBuilderWithField(aVar7, sKBuiltinBuffer_t3, a.getNextFieldNumber(aVar7))) {
                        }
                        dta.KLq = sKBuiltinBuffer_t3;
                    }
                    AppMethodBeat.o(133194);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t4 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = sKBuiltinBuffer_t4.populateBuilderWithField(aVar8, sKBuiltinBuffer_t4, a.getNextFieldNumber(aVar8))) {
                        }
                        dta.KLr = sKBuiltinBuffer_t4;
                    }
                    AppMethodBeat.o(133194);
                    return 0;
                default:
                    AppMethodBeat.o(133194);
                    return -1;
            }
        } else {
            AppMethodBeat.o(133194);
            return -1;
        }
    }
}
