package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class etb extends dpc {
    public LinkedList<esv> KMD = new LinkedList<>();
    public long Lta;
    public b MKv;
    public int Ndy;
    public long NeG;
    public int NqA;
    public LinkedList<esv> NqB = new LinkedList<>();
    public int Nqy;
    public int Nqz;
    public int ypR;
    public int ypX;
    public int ypY;
    public int yqc;

    public etb() {
        AppMethodBeat.i(125499);
        AppMethodBeat.o(125499);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125500);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(125500);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.bb(2, this.NeG);
            aVar.bb(3, this.Lta);
            aVar.e(4, 8, this.KMD);
            aVar.aM(5, this.Ndy);
            aVar.aM(6, this.ypX);
            aVar.aM(7, this.ypY);
            aVar.aM(8, this.ypR);
            aVar.aM(9, this.yqc);
            aVar.aM(10, this.Nqy);
            aVar.aM(11, this.Nqz);
            if (this.MKv != null) {
                aVar.c(12, this.MKv);
            }
            aVar.aM(13, this.NqA);
            aVar.e(14, 8, this.NqB);
            AppMethodBeat.o(125500);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.r(2, this.NeG) + g.a.a.b.b.a.r(3, this.Lta) + g.a.a.a.c(4, 8, this.KMD) + g.a.a.b.b.a.bu(5, this.Ndy) + g.a.a.b.b.a.bu(6, this.ypX) + g.a.a.b.b.a.bu(7, this.ypY) + g.a.a.b.b.a.bu(8, this.ypR) + g.a.a.b.b.a.bu(9, this.yqc) + g.a.a.b.b.a.bu(10, this.Nqy) + g.a.a.b.b.a.bu(11, this.Nqz);
            if (this.MKv != null) {
                nh += g.a.a.b.b.a.b(12, this.MKv);
            }
            int bu = nh + g.a.a.b.b.a.bu(13, this.NqA) + g.a.a.a.c(14, 8, this.NqB);
            AppMethodBeat.o(125500);
            return bu;
        } else if (i2 == 2) {
            this.KMD.clear();
            this.NqB.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(125500);
                throw bVar2;
            }
            AppMethodBeat.o(125500);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            etb etb = (etb) objArr[1];
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
                        etb.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(125500);
                    return 0;
                case 2:
                    etb.NeG = aVar3.UbS.zl();
                    AppMethodBeat.o(125500);
                    return 0;
                case 3:
                    etb.Lta = aVar3.UbS.zl();
                    AppMethodBeat.o(125500);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        esv esv = new esv();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = esv.populateBuilderWithField(aVar5, esv, dpc.getNextFieldNumber(aVar5))) {
                        }
                        etb.KMD.add(esv);
                    }
                    AppMethodBeat.o(125500);
                    return 0;
                case 5:
                    etb.Ndy = aVar3.UbS.zi();
                    AppMethodBeat.o(125500);
                    return 0;
                case 6:
                    etb.ypX = aVar3.UbS.zi();
                    AppMethodBeat.o(125500);
                    return 0;
                case 7:
                    etb.ypY = aVar3.UbS.zi();
                    AppMethodBeat.o(125500);
                    return 0;
                case 8:
                    etb.ypR = aVar3.UbS.zi();
                    AppMethodBeat.o(125500);
                    return 0;
                case 9:
                    etb.yqc = aVar3.UbS.zi();
                    AppMethodBeat.o(125500);
                    return 0;
                case 10:
                    etb.Nqy = aVar3.UbS.zi();
                    AppMethodBeat.o(125500);
                    return 0;
                case 11:
                    etb.Nqz = aVar3.UbS.zi();
                    AppMethodBeat.o(125500);
                    return 0;
                case 12:
                    etb.MKv = aVar3.UbS.hPo();
                    AppMethodBeat.o(125500);
                    return 0;
                case 13:
                    etb.NqA = aVar3.UbS.zi();
                    AppMethodBeat.o(125500);
                    return 0;
                case 14:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        esv esv2 = new esv();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = esv2.populateBuilderWithField(aVar6, esv2, dpc.getNextFieldNumber(aVar6))) {
                        }
                        etb.NqB.add(esv2);
                    }
                    AppMethodBeat.o(125500);
                    return 0;
                default:
                    AppMethodBeat.o(125500);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125500);
            return -1;
        }
    }
}
