package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ahy extends dpc {
    public int Brl;
    public long Brn;
    public SKBuiltinBuffer_t BsI;
    public String KIz;
    public int KUy;
    public int KXq;
    public int KZk;
    public int LrF;
    public int jeU;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(148653);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BsI == null) {
                b bVar = new b("Not all required fields were included: Data");
                AppMethodBeat.o(148653);
                throw bVar;
            } else if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(148653);
                throw bVar2;
            } else {
                aVar.aM(1, this.Brl);
                aVar.aM(2, this.KZk);
                aVar.aM(3, this.KUy);
                aVar.aM(5, this.KXq);
                if (this.KIz != null) {
                    aVar.e(6, this.KIz);
                }
                if (this.BsI != null) {
                    aVar.ni(7, this.BsI.computeSize());
                    this.BsI.writeFields(aVar);
                }
                aVar.aM(8, this.jeU);
                if (this.BaseResponse != null) {
                    aVar.ni(9, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                aVar.aM(10, this.LrF);
                aVar.bb(11, this.Brn);
                AppMethodBeat.o(148653);
                return 0;
            }
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.Brl) + 0 + g.a.a.b.b.a.bu(2, this.KZk) + g.a.a.b.b.a.bu(3, this.KUy) + g.a.a.b.b.a.bu(5, this.KXq);
            if (this.KIz != null) {
                bu += g.a.a.b.b.a.f(6, this.KIz);
            }
            if (this.BsI != null) {
                bu += g.a.a.a.nh(7, this.BsI.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.jeU);
            if (this.BaseResponse != null) {
                bu2 += g.a.a.a.nh(9, this.BaseResponse.computeSize());
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(10, this.LrF) + g.a.a.b.b.a.r(11, this.Brn);
            AppMethodBeat.o(148653);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BsI == null) {
                b bVar3 = new b("Not all required fields were included: Data");
                AppMethodBeat.o(148653);
                throw bVar3;
            } else if (this.BaseResponse == null) {
                b bVar4 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(148653);
                throw bVar4;
            } else {
                AppMethodBeat.o(148653);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ahy ahy = (ahy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ahy.Brl = aVar3.UbS.zi();
                    AppMethodBeat.o(148653);
                    return 0;
                case 2:
                    ahy.KZk = aVar3.UbS.zi();
                    AppMethodBeat.o(148653);
                    return 0;
                case 3:
                    ahy.KUy = aVar3.UbS.zi();
                    AppMethodBeat.o(148653);
                    return 0;
                case 4:
                default:
                    AppMethodBeat.o(148653);
                    return -1;
                case 5:
                    ahy.KXq = aVar3.UbS.zi();
                    AppMethodBeat.o(148653);
                    return 0;
                case 6:
                    ahy.KIz = aVar3.UbS.readString();
                    AppMethodBeat.o(148653);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, dpc.getNextFieldNumber(aVar4))) {
                        }
                        ahy.BsI = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(148653);
                    return 0;
                case 8:
                    ahy.jeU = aVar3.UbS.zi();
                    AppMethodBeat.o(148653);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        BaseResponse baseResponse = new BaseResponse();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = baseResponse.populateBuilderWithField(aVar5, baseResponse, dpc.getNextFieldNumber(aVar5))) {
                        }
                        ahy.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(148653);
                    return 0;
                case 10:
                    ahy.LrF = aVar3.UbS.zi();
                    AppMethodBeat.o(148653);
                    return 0;
                case 11:
                    ahy.Brn = aVar3.UbS.zl();
                    AppMethodBeat.o(148653);
                    return 0;
            }
        } else {
            AppMethodBeat.o(148653);
            return -1;
        }
    }
}
