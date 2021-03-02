package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class eka extends dpc {
    public String ClU;
    public String ClV;
    public int ClW;
    public int CpN;
    public String KRv;
    public dmp Nja;
    public String Njb;
    public String Njc;
    public String Njd;
    public dmp Njl;
    public LinkedList<agg> Njm = new LinkedList<>();
    public String Njn;
    public String Njo;
    public String Njp;
    public String pSm;
    public int pTZ;
    public String pUa;

    public eka() {
        AppMethodBeat.i(72598);
        AppMethodBeat.o(72598);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72599);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.pTZ);
            if (this.pUa != null) {
                aVar.e(3, this.pUa);
            }
            aVar.aM(4, this.ClW);
            if (this.Njl != null) {
                aVar.ni(5, this.Njl.computeSize());
                this.Njl.writeFields(aVar);
            }
            if (this.Njb != null) {
                aVar.e(6, this.Njb);
            }
            if (this.Njc != null) {
                aVar.e(7, this.Njc);
            }
            if (this.ClU != null) {
                aVar.e(8, this.ClU);
            }
            if (this.ClV != null) {
                aVar.e(9, this.ClV);
            }
            if (this.pSm != null) {
                aVar.e(10, this.pSm);
            }
            if (this.KRv != null) {
                aVar.e(11, this.KRv);
            }
            aVar.aM(12, this.CpN);
            aVar.e(13, 8, this.Njm);
            if (this.Njn != null) {
                aVar.e(14, this.Njn);
            }
            if (this.Njo != null) {
                aVar.e(15, this.Njo);
            }
            if (this.Njd != null) {
                aVar.e(16, this.Njd);
            }
            if (this.Njp != null) {
                aVar.e(17, this.Njp);
            }
            if (this.Nja != null) {
                aVar.ni(18, this.Nja.computeSize());
                this.Nja.writeFields(aVar);
            }
            AppMethodBeat.o(72599);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.pTZ);
            if (this.pUa != null) {
                nh += g.a.a.b.b.a.f(3, this.pUa);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.ClW);
            if (this.Njl != null) {
                bu += g.a.a.a.nh(5, this.Njl.computeSize());
            }
            if (this.Njb != null) {
                bu += g.a.a.b.b.a.f(6, this.Njb);
            }
            if (this.Njc != null) {
                bu += g.a.a.b.b.a.f(7, this.Njc);
            }
            if (this.ClU != null) {
                bu += g.a.a.b.b.a.f(8, this.ClU);
            }
            if (this.ClV != null) {
                bu += g.a.a.b.b.a.f(9, this.ClV);
            }
            if (this.pSm != null) {
                bu += g.a.a.b.b.a.f(10, this.pSm);
            }
            if (this.KRv != null) {
                bu += g.a.a.b.b.a.f(11, this.KRv);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(12, this.CpN) + g.a.a.a.c(13, 8, this.Njm);
            if (this.Njn != null) {
                bu2 += g.a.a.b.b.a.f(14, this.Njn);
            }
            if (this.Njo != null) {
                bu2 += g.a.a.b.b.a.f(15, this.Njo);
            }
            if (this.Njd != null) {
                bu2 += g.a.a.b.b.a.f(16, this.Njd);
            }
            if (this.Njp != null) {
                bu2 += g.a.a.b.b.a.f(17, this.Njp);
            }
            if (this.Nja != null) {
                bu2 += g.a.a.a.nh(18, this.Nja.computeSize());
            }
            AppMethodBeat.o(72599);
            return bu2;
        } else if (i2 == 2) {
            this.Njm.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72599);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eka eka = (eka) objArr[1];
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
                        eka.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(72599);
                    return 0;
                case 2:
                    eka.pTZ = aVar3.UbS.zi();
                    AppMethodBeat.o(72599);
                    return 0;
                case 3:
                    eka.pUa = aVar3.UbS.readString();
                    AppMethodBeat.o(72599);
                    return 0;
                case 4:
                    eka.ClW = aVar3.UbS.zi();
                    AppMethodBeat.o(72599);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dmp dmp = new dmp();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dmp.populateBuilderWithField(aVar5, dmp, dpc.getNextFieldNumber(aVar5))) {
                        }
                        eka.Njl = dmp;
                    }
                    AppMethodBeat.o(72599);
                    return 0;
                case 6:
                    eka.Njb = aVar3.UbS.readString();
                    AppMethodBeat.o(72599);
                    return 0;
                case 7:
                    eka.Njc = aVar3.UbS.readString();
                    AppMethodBeat.o(72599);
                    return 0;
                case 8:
                    eka.ClU = aVar3.UbS.readString();
                    AppMethodBeat.o(72599);
                    return 0;
                case 9:
                    eka.ClV = aVar3.UbS.readString();
                    AppMethodBeat.o(72599);
                    return 0;
                case 10:
                    eka.pSm = aVar3.UbS.readString();
                    AppMethodBeat.o(72599);
                    return 0;
                case 11:
                    eka.KRv = aVar3.UbS.readString();
                    AppMethodBeat.o(72599);
                    return 0;
                case 12:
                    eka.CpN = aVar3.UbS.zi();
                    AppMethodBeat.o(72599);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        agg agg = new agg();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = agg.populateBuilderWithField(aVar6, agg, dpc.getNextFieldNumber(aVar6))) {
                        }
                        eka.Njm.add(agg);
                    }
                    AppMethodBeat.o(72599);
                    return 0;
                case 14:
                    eka.Njn = aVar3.UbS.readString();
                    AppMethodBeat.o(72599);
                    return 0;
                case 15:
                    eka.Njo = aVar3.UbS.readString();
                    AppMethodBeat.o(72599);
                    return 0;
                case 16:
                    eka.Njd = aVar3.UbS.readString();
                    AppMethodBeat.o(72599);
                    return 0;
                case 17:
                    eka.Njp = aVar3.UbS.readString();
                    AppMethodBeat.o(72599);
                    return 0;
                case 18:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dmp dmp2 = new dmp();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dmp2.populateBuilderWithField(aVar7, dmp2, dpc.getNextFieldNumber(aVar7))) {
                        }
                        eka.Nja = dmp2;
                    }
                    AppMethodBeat.o(72599);
                    return 0;
                default:
                    AppMethodBeat.o(72599);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72599);
            return -1;
        }
    }
}
