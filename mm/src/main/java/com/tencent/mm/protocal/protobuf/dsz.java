package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dsz extends dpc {
    public LinkedList<fei> KKx = new LinkedList<>();
    public boolean LYI;
    public int MJT;
    public int MRg;
    public fdz MVd;
    public int MVe;
    public b MVf;
    public String MVg;
    public String Title;
    public int oTY;
    public int oTz;
    public int oUv;
    public int rBL;

    public dsz() {
        AppMethodBeat.i(117922);
        AppMethodBeat.o(117922);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117923);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(117923);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.oTY);
            aVar.aM(3, this.oUv);
            aVar.aM(4, this.MJT);
            aVar.aM(5, this.oTz);
            if (this.Title != null) {
                aVar.e(6, this.Title);
            }
            if (this.MVd != null) {
                aVar.ni(7, this.MVd.computeSize());
                this.MVd.writeFields(aVar);
            }
            aVar.e(8, 8, this.KKx);
            aVar.aM(9, this.MRg);
            aVar.aM(10, this.MVe);
            aVar.cc(11, this.LYI);
            if (this.MVf != null) {
                aVar.c(12, this.MVf);
            }
            aVar.aM(13, this.rBL);
            if (this.MVg != null) {
                aVar.e(14, this.MVg);
            }
            AppMethodBeat.o(117923);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.oTY) + g.a.a.b.b.a.bu(3, this.oUv) + g.a.a.b.b.a.bu(4, this.MJT) + g.a.a.b.b.a.bu(5, this.oTz);
            if (this.Title != null) {
                nh += g.a.a.b.b.a.f(6, this.Title);
            }
            if (this.MVd != null) {
                nh += g.a.a.a.nh(7, this.MVd.computeSize());
            }
            int c2 = nh + g.a.a.a.c(8, 8, this.KKx) + g.a.a.b.b.a.bu(9, this.MRg) + g.a.a.b.b.a.bu(10, this.MVe) + g.a.a.b.b.a.fS(11) + 1;
            if (this.MVf != null) {
                c2 += g.a.a.b.b.a.b(12, this.MVf);
            }
            int bu = c2 + g.a.a.b.b.a.bu(13, this.rBL);
            if (this.MVg != null) {
                bu += g.a.a.b.b.a.f(14, this.MVg);
            }
            AppMethodBeat.o(117923);
            return bu;
        } else if (i2 == 2) {
            this.KKx.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(117923);
                throw bVar2;
            }
            AppMethodBeat.o(117923);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dsz dsz = (dsz) objArr[1];
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
                        dsz.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(117923);
                    return 0;
                case 2:
                    dsz.oTY = aVar3.UbS.zi();
                    AppMethodBeat.o(117923);
                    return 0;
                case 3:
                    dsz.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(117923);
                    return 0;
                case 4:
                    dsz.MJT = aVar3.UbS.zi();
                    AppMethodBeat.o(117923);
                    return 0;
                case 5:
                    dsz.oTz = aVar3.UbS.zi();
                    AppMethodBeat.o(117923);
                    return 0;
                case 6:
                    dsz.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(117923);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        fdz fdz = new fdz();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = fdz.populateBuilderWithField(aVar5, fdz, dpc.getNextFieldNumber(aVar5))) {
                        }
                        dsz.MVd = fdz;
                    }
                    AppMethodBeat.o(117923);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        fei fei = new fei();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = fei.populateBuilderWithField(aVar6, fei, dpc.getNextFieldNumber(aVar6))) {
                        }
                        dsz.KKx.add(fei);
                    }
                    AppMethodBeat.o(117923);
                    return 0;
                case 9:
                    dsz.MRg = aVar3.UbS.zi();
                    AppMethodBeat.o(117923);
                    return 0;
                case 10:
                    dsz.MVe = aVar3.UbS.zi();
                    AppMethodBeat.o(117923);
                    return 0;
                case 11:
                    dsz.LYI = aVar3.UbS.yZ();
                    AppMethodBeat.o(117923);
                    return 0;
                case 12:
                    dsz.MVf = aVar3.UbS.hPo();
                    AppMethodBeat.o(117923);
                    return 0;
                case 13:
                    dsz.rBL = aVar3.UbS.zi();
                    AppMethodBeat.o(117923);
                    return 0;
                case 14:
                    dsz.MVg = aVar3.UbS.readString();
                    AppMethodBeat.o(117923);
                    return 0;
                default:
                    AppMethodBeat.o(117923);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117923);
            return -1;
        }
    }
}
