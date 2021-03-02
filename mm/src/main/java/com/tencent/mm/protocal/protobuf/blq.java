package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class blq extends dpc {
    public String ID;
    public SKBuiltinBuffer_t KLU;
    public int KMC;
    public LinkedList<adi> KMD = new LinkedList<>();
    public String KME;
    public String KMF;
    public String KMG;
    public int KMK;
    public String KML;
    public String KMM;
    public String LUt;
    public int Scene;
    public long oTS;
    public int oUv;

    public blq() {
        AppMethodBeat.i(32227);
        AppMethodBeat.o(32227);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32228);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32228);
                throw bVar;
            } else if (this.KLU == null) {
                b bVar2 = new b("Not all required fields were included: Key");
                AppMethodBeat.o(32228);
                throw bVar2;
            } else {
                if (this.BaseResponse != null) {
                    aVar.ni(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.ID != null) {
                    aVar.e(2, this.ID);
                }
                if (this.KLU != null) {
                    aVar.ni(3, this.KLU.computeSize());
                    this.KLU.writeFields(aVar);
                }
                if (this.KML != null) {
                    aVar.e(4, this.KML);
                }
                if (this.KMM != null) {
                    aVar.e(5, this.KMM);
                }
                aVar.aM(6, this.oUv);
                aVar.aM(7, this.KMC);
                aVar.e(8, 8, this.KMD);
                if (this.LUt != null) {
                    aVar.e(9, this.LUt);
                }
                if (this.KME != null) {
                    aVar.e(10, this.KME);
                }
                if (this.KMF != null) {
                    aVar.e(11, this.KMF);
                }
                aVar.aM(12, this.KMK);
                aVar.aM(13, this.Scene);
                aVar.bb(14, this.oTS);
                if (this.KMG != null) {
                    aVar.e(15, this.KMG);
                }
                AppMethodBeat.o(32228);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.ID != null) {
                nh += g.a.a.b.b.a.f(2, this.ID);
            }
            if (this.KLU != null) {
                nh += g.a.a.a.nh(3, this.KLU.computeSize());
            }
            if (this.KML != null) {
                nh += g.a.a.b.b.a.f(4, this.KML);
            }
            if (this.KMM != null) {
                nh += g.a.a.b.b.a.f(5, this.KMM);
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.oUv) + g.a.a.b.b.a.bu(7, this.KMC) + g.a.a.a.c(8, 8, this.KMD);
            if (this.LUt != null) {
                bu += g.a.a.b.b.a.f(9, this.LUt);
            }
            if (this.KME != null) {
                bu += g.a.a.b.b.a.f(10, this.KME);
            }
            if (this.KMF != null) {
                bu += g.a.a.b.b.a.f(11, this.KMF);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(12, this.KMK) + g.a.a.b.b.a.bu(13, this.Scene) + g.a.a.b.b.a.r(14, this.oTS);
            if (this.KMG != null) {
                bu2 += g.a.a.b.b.a.f(15, this.KMG);
            }
            AppMethodBeat.o(32228);
            return bu2;
        } else if (i2 == 2) {
            this.KMD.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar3 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32228);
                throw bVar3;
            } else if (this.KLU == null) {
                b bVar4 = new b("Not all required fields were included: Key");
                AppMethodBeat.o(32228);
                throw bVar4;
            } else {
                AppMethodBeat.o(32228);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            blq blq = (blq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        BaseResponse baseResponse = new BaseResponse();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, dpc.getNextFieldNumber(aVar4))) {
                        }
                        blq.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(32228);
                    return 0;
                case 2:
                    blq.ID = aVar3.UbS.readString();
                    AppMethodBeat.o(32228);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dpc.getNextFieldNumber(aVar5))) {
                        }
                        blq.KLU = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(32228);
                    return 0;
                case 4:
                    blq.KML = aVar3.UbS.readString();
                    AppMethodBeat.o(32228);
                    return 0;
                case 5:
                    blq.KMM = aVar3.UbS.readString();
                    AppMethodBeat.o(32228);
                    return 0;
                case 6:
                    blq.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(32228);
                    return 0;
                case 7:
                    blq.KMC = aVar3.UbS.zi();
                    AppMethodBeat.o(32228);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        adi adi = new adi();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = adi.populateBuilderWithField(aVar6, adi, dpc.getNextFieldNumber(aVar6))) {
                        }
                        blq.KMD.add(adi);
                    }
                    AppMethodBeat.o(32228);
                    return 0;
                case 9:
                    blq.LUt = aVar3.UbS.readString();
                    AppMethodBeat.o(32228);
                    return 0;
                case 10:
                    blq.KME = aVar3.UbS.readString();
                    AppMethodBeat.o(32228);
                    return 0;
                case 11:
                    blq.KMF = aVar3.UbS.readString();
                    AppMethodBeat.o(32228);
                    return 0;
                case 12:
                    blq.KMK = aVar3.UbS.zi();
                    AppMethodBeat.o(32228);
                    return 0;
                case 13:
                    blq.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(32228);
                    return 0;
                case 14:
                    blq.oTS = aVar3.UbS.zl();
                    AppMethodBeat.o(32228);
                    return 0;
                case 15:
                    blq.KMG = aVar3.UbS.readString();
                    AppMethodBeat.o(32228);
                    return 0;
                default:
                    AppMethodBeat.o(32228);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32228);
            return -1;
        }
    }
}
