package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dfm extends dpc {
    public LinkedList<dfe> KMD = new LinkedList<>();
    public int LsZ;
    public long Lta;
    public long MKi;
    public int MKr;
    public int MKs;
    public LinkedList<dfe> MKt = new LinkedList<>();
    public String MKu;
    public b MKv;
    public int MKw;
    public int ypM;
    public String ypN;
    public int ypR;
    public int ypX;
    public int ypY;
    public int ypZ;
    public b yqa;
    public int yqc;
    public int yqf;

    public dfm() {
        AppMethodBeat.i(32379);
        AppMethodBeat.o(32379);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32380);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32380);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.LsZ);
            aVar.bb(3, this.Lta);
            aVar.aM(4, this.MKr);
            aVar.e(5, 8, this.KMD);
            aVar.aM(6, this.MKs);
            aVar.aM(7, this.ypX);
            aVar.aM(8, this.ypY);
            aVar.bb(9, this.MKi);
            aVar.aM(10, this.ypZ);
            if (this.yqa != null) {
                aVar.c(11, this.yqa);
            }
            aVar.aM(12, this.ypR);
            aVar.aM(13, this.ypM);
            if (this.ypN != null) {
                aVar.e(14, this.ypN);
            }
            aVar.aM(15, this.yqc);
            aVar.e(16, 8, this.MKt);
            aVar.aM(17, this.yqf);
            if (this.MKu != null) {
                aVar.e(18, this.MKu);
            }
            if (this.MKv != null) {
                aVar.c(19, this.MKv);
            }
            aVar.aM(20, this.MKw);
            AppMethodBeat.o(32380);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LsZ) + g.a.a.b.b.a.r(3, this.Lta) + g.a.a.b.b.a.bu(4, this.MKr) + g.a.a.a.c(5, 8, this.KMD) + g.a.a.b.b.a.bu(6, this.MKs) + g.a.a.b.b.a.bu(7, this.ypX) + g.a.a.b.b.a.bu(8, this.ypY) + g.a.a.b.b.a.r(9, this.MKi) + g.a.a.b.b.a.bu(10, this.ypZ);
            if (this.yqa != null) {
                nh += g.a.a.b.b.a.b(11, this.yqa);
            }
            int bu = nh + g.a.a.b.b.a.bu(12, this.ypR) + g.a.a.b.b.a.bu(13, this.ypM);
            if (this.ypN != null) {
                bu += g.a.a.b.b.a.f(14, this.ypN);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(15, this.yqc) + g.a.a.a.c(16, 8, this.MKt) + g.a.a.b.b.a.bu(17, this.yqf);
            if (this.MKu != null) {
                bu2 += g.a.a.b.b.a.f(18, this.MKu);
            }
            if (this.MKv != null) {
                bu2 += g.a.a.b.b.a.b(19, this.MKv);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(20, this.MKw);
            AppMethodBeat.o(32380);
            return bu3;
        } else if (i2 == 2) {
            this.KMD.clear();
            this.MKt.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32380);
                throw bVar2;
            }
            AppMethodBeat.o(32380);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dfm dfm = (dfm) objArr[1];
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
                        dfm.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(32380);
                    return 0;
                case 2:
                    dfm.LsZ = aVar3.UbS.zi();
                    AppMethodBeat.o(32380);
                    return 0;
                case 3:
                    dfm.Lta = aVar3.UbS.zl();
                    AppMethodBeat.o(32380);
                    return 0;
                case 4:
                    dfm.MKr = aVar3.UbS.zi();
                    AppMethodBeat.o(32380);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dfe dfe = new dfe();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dfe.populateBuilderWithField(aVar5, dfe, dpc.getNextFieldNumber(aVar5))) {
                        }
                        dfm.KMD.add(dfe);
                    }
                    AppMethodBeat.o(32380);
                    return 0;
                case 6:
                    dfm.MKs = aVar3.UbS.zi();
                    AppMethodBeat.o(32380);
                    return 0;
                case 7:
                    dfm.ypX = aVar3.UbS.zi();
                    AppMethodBeat.o(32380);
                    return 0;
                case 8:
                    dfm.ypY = aVar3.UbS.zi();
                    AppMethodBeat.o(32380);
                    return 0;
                case 9:
                    dfm.MKi = aVar3.UbS.zl();
                    AppMethodBeat.o(32380);
                    return 0;
                case 10:
                    dfm.ypZ = aVar3.UbS.zi();
                    AppMethodBeat.o(32380);
                    return 0;
                case 11:
                    dfm.yqa = aVar3.UbS.hPo();
                    AppMethodBeat.o(32380);
                    return 0;
                case 12:
                    dfm.ypR = aVar3.UbS.zi();
                    AppMethodBeat.o(32380);
                    return 0;
                case 13:
                    dfm.ypM = aVar3.UbS.zi();
                    AppMethodBeat.o(32380);
                    return 0;
                case 14:
                    dfm.ypN = aVar3.UbS.readString();
                    AppMethodBeat.o(32380);
                    return 0;
                case 15:
                    dfm.yqc = aVar3.UbS.zi();
                    AppMethodBeat.o(32380);
                    return 0;
                case 16:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dfe dfe2 = new dfe();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dfe2.populateBuilderWithField(aVar6, dfe2, dpc.getNextFieldNumber(aVar6))) {
                        }
                        dfm.MKt.add(dfe2);
                    }
                    AppMethodBeat.o(32380);
                    return 0;
                case 17:
                    dfm.yqf = aVar3.UbS.zi();
                    AppMethodBeat.o(32380);
                    return 0;
                case 18:
                    dfm.MKu = aVar3.UbS.readString();
                    AppMethodBeat.o(32380);
                    return 0;
                case 19:
                    dfm.MKv = aVar3.UbS.hPo();
                    AppMethodBeat.o(32380);
                    return 0;
                case 20:
                    dfm.MKw = aVar3.UbS.zi();
                    AppMethodBeat.o(32380);
                    return 0;
                default:
                    AppMethodBeat.o(32380);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32380);
            return -1;
        }
    }
}
