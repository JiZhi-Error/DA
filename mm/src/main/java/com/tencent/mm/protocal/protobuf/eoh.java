package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class eoh extends dop {
    public int Brl;
    public long Brn;
    public SKBuiltinBuffer_t BsI;
    public String KHq;
    public String KIz;
    public int KUy;
    public int KXq;
    public int KZk;
    public String LbN;
    public int LrF;
    public int LsF;
    public int Msa;
    public int Nmf;
    public int Nmg;
    public int jeU;
    public String xNG;
    public String xNH;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(148661);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BsI == null) {
                b bVar = new b("Not all required fields were included: Data");
                AppMethodBeat.o(148661);
                throw bVar;
            }
            if (this.xNH != null) {
                aVar.e(1, this.xNH);
            }
            if (this.xNG != null) {
                aVar.e(2, this.xNG);
            }
            aVar.aM(3, this.KZk);
            aVar.aM(4, this.KUy);
            if (this.KIz != null) {
                aVar.e(5, this.KIz);
            }
            aVar.aM(6, this.Brl);
            aVar.aM(7, this.KXq);
            if (this.BsI != null) {
                aVar.ni(8, this.BsI.computeSize());
                this.BsI.writeFields(aVar);
            }
            aVar.aM(9, this.jeU);
            if (this.BaseRequest != null) {
                aVar.ni(10, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(11, this.LrF);
            if (this.KHq != null) {
                aVar.e(12, this.KHq);
            }
            aVar.aM(13, this.Msa);
            aVar.aM(14, this.Nmf);
            aVar.aM(15, this.Nmg);
            aVar.bb(16, this.Brn);
            aVar.aM(17, this.LsF);
            if (this.LbN != null) {
                aVar.e(19, this.LbN);
            }
            AppMethodBeat.o(148661);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.xNH != null ? g.a.a.b.b.a.f(1, this.xNH) + 0 : 0;
            if (this.xNG != null) {
                f2 += g.a.a.b.b.a.f(2, this.xNG);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.KZk) + g.a.a.b.b.a.bu(4, this.KUy);
            if (this.KIz != null) {
                bu += g.a.a.b.b.a.f(5, this.KIz);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.Brl) + g.a.a.b.b.a.bu(7, this.KXq);
            if (this.BsI != null) {
                bu2 += g.a.a.a.nh(8, this.BsI.computeSize());
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(9, this.jeU);
            if (this.BaseRequest != null) {
                bu3 += g.a.a.a.nh(10, this.BaseRequest.computeSize());
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(11, this.LrF);
            if (this.KHq != null) {
                bu4 += g.a.a.b.b.a.f(12, this.KHq);
            }
            int bu5 = bu4 + g.a.a.b.b.a.bu(13, this.Msa) + g.a.a.b.b.a.bu(14, this.Nmf) + g.a.a.b.b.a.bu(15, this.Nmg) + g.a.a.b.b.a.r(16, this.Brn) + g.a.a.b.b.a.bu(17, this.LsF);
            if (this.LbN != null) {
                bu5 += g.a.a.b.b.a.f(19, this.LbN);
            }
            AppMethodBeat.o(148661);
            return bu5;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BsI == null) {
                b bVar2 = new b("Not all required fields were included: Data");
                AppMethodBeat.o(148661);
                throw bVar2;
            }
            AppMethodBeat.o(148661);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eoh eoh = (eoh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eoh.xNH = aVar3.UbS.readString();
                    AppMethodBeat.o(148661);
                    return 0;
                case 2:
                    eoh.xNG = aVar3.UbS.readString();
                    AppMethodBeat.o(148661);
                    return 0;
                case 3:
                    eoh.KZk = aVar3.UbS.zi();
                    AppMethodBeat.o(148661);
                    return 0;
                case 4:
                    eoh.KUy = aVar3.UbS.zi();
                    AppMethodBeat.o(148661);
                    return 0;
                case 5:
                    eoh.KIz = aVar3.UbS.readString();
                    AppMethodBeat.o(148661);
                    return 0;
                case 6:
                    eoh.Brl = aVar3.UbS.zi();
                    AppMethodBeat.o(148661);
                    return 0;
                case 7:
                    eoh.KXq = aVar3.UbS.zi();
                    AppMethodBeat.o(148661);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar4))) {
                        }
                        eoh.BsI = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(148661);
                    return 0;
                case 9:
                    eoh.jeU = aVar3.UbS.zi();
                    AppMethodBeat.o(148661);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = jrVar.populateBuilderWithField(aVar5, jrVar, dop.getNextFieldNumber(aVar5))) {
                        }
                        eoh.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(148661);
                    return 0;
                case 11:
                    eoh.LrF = aVar3.UbS.zi();
                    AppMethodBeat.o(148661);
                    return 0;
                case 12:
                    eoh.KHq = aVar3.UbS.readString();
                    AppMethodBeat.o(148661);
                    return 0;
                case 13:
                    eoh.Msa = aVar3.UbS.zi();
                    AppMethodBeat.o(148661);
                    return 0;
                case 14:
                    eoh.Nmf = aVar3.UbS.zi();
                    AppMethodBeat.o(148661);
                    return 0;
                case 15:
                    eoh.Nmg = aVar3.UbS.zi();
                    AppMethodBeat.o(148661);
                    return 0;
                case 16:
                    eoh.Brn = aVar3.UbS.zl();
                    AppMethodBeat.o(148661);
                    return 0;
                case 17:
                    eoh.LsF = aVar3.UbS.zi();
                    AppMethodBeat.o(148661);
                    return 0;
                case 18:
                default:
                    AppMethodBeat.o(148661);
                    return -1;
                case 19:
                    eoh.LbN = aVar3.UbS.readString();
                    AppMethodBeat.o(148661);
                    return 0;
            }
        } else {
            AppMethodBeat.o(148661);
            return -1;
        }
    }
}
