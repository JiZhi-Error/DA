package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class epu extends dop {
    public int APa;
    public String MJA;
    public int MJB;
    public String MJC;
    public String MJz;
    public SKBuiltinBuffer_t Nno;
    public int Nnp;
    public int Nnq;
    public String Nnr;
    public String ProductID;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91722);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.Nno == null) {
                b bVar = new b("Not all required fields were included: Receipt");
                AppMethodBeat.o(91722);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.Nno != null) {
                aVar.ni(2, this.Nno.computeSize());
                this.Nno.writeFields(aVar);
            }
            if (this.ProductID != null) {
                aVar.e(3, this.ProductID);
            }
            aVar.aM(4, this.Nnp);
            aVar.aM(5, this.APa);
            if (this.MJz != null) {
                aVar.e(6, this.MJz);
            }
            if (this.MJA != null) {
                aVar.e(7, this.MJA);
            }
            if (this.MJC != null) {
                aVar.e(8, this.MJC);
            }
            aVar.aM(9, this.Nnq);
            if (this.Nnr != null) {
                aVar.e(10, this.Nnr);
            }
            aVar.aM(11, this.MJB);
            AppMethodBeat.o(91722);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.Nno != null) {
                nh += g.a.a.a.nh(2, this.Nno.computeSize());
            }
            if (this.ProductID != null) {
                nh += g.a.a.b.b.a.f(3, this.ProductID);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.Nnp) + g.a.a.b.b.a.bu(5, this.APa);
            if (this.MJz != null) {
                bu += g.a.a.b.b.a.f(6, this.MJz);
            }
            if (this.MJA != null) {
                bu += g.a.a.b.b.a.f(7, this.MJA);
            }
            if (this.MJC != null) {
                bu += g.a.a.b.b.a.f(8, this.MJC);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(9, this.Nnq);
            if (this.Nnr != null) {
                bu2 += g.a.a.b.b.a.f(10, this.Nnr);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(11, this.MJB);
            AppMethodBeat.o(91722);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Nno == null) {
                b bVar2 = new b("Not all required fields were included: Receipt");
                AppMethodBeat.o(91722);
                throw bVar2;
            }
            AppMethodBeat.o(91722);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            epu epu = (epu) objArr[1];
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
                        epu.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(91722);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar5))) {
                        }
                        epu.Nno = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(91722);
                    return 0;
                case 3:
                    epu.ProductID = aVar3.UbS.readString();
                    AppMethodBeat.o(91722);
                    return 0;
                case 4:
                    epu.Nnp = aVar3.UbS.zi();
                    AppMethodBeat.o(91722);
                    return 0;
                case 5:
                    epu.APa = aVar3.UbS.zi();
                    AppMethodBeat.o(91722);
                    return 0;
                case 6:
                    epu.MJz = aVar3.UbS.readString();
                    AppMethodBeat.o(91722);
                    return 0;
                case 7:
                    epu.MJA = aVar3.UbS.readString();
                    AppMethodBeat.o(91722);
                    return 0;
                case 8:
                    epu.MJC = aVar3.UbS.readString();
                    AppMethodBeat.o(91722);
                    return 0;
                case 9:
                    epu.Nnq = aVar3.UbS.zi();
                    AppMethodBeat.o(91722);
                    return 0;
                case 10:
                    epu.Nnr = aVar3.UbS.readString();
                    AppMethodBeat.o(91722);
                    return 0;
                case 11:
                    epu.MJB = aVar3.UbS.zi();
                    AppMethodBeat.o(91722);
                    return 0;
                default:
                    AppMethodBeat.o(91722);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91722);
            return -1;
        }
    }
}
