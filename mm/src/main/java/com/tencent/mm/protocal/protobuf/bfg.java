package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bfg extends dpc {
    public boolean LOQ = false;
    public int dDN = 0;
    public int egY;
    public int egZ;
    public int eha;
    public String qwn = "ok";
    public String yPK;
    public String yQE;
    public String yVb;
    public int yVm;
    public String yVy;
    public String yXR;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(214300);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(214300);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.dDN);
            if (this.qwn != null) {
                aVar.e(3, this.qwn);
            }
            if (this.yQE != null) {
                aVar.e(4, this.yQE);
            }
            if (this.yPK != null) {
                aVar.e(5, this.yPK);
            }
            aVar.aM(6, this.yVm);
            aVar.aM(7, this.eha);
            aVar.aM(8, this.egZ);
            if (this.yVb != null) {
                aVar.e(9, this.yVb);
            }
            aVar.aM(10, this.egY);
            if (this.yVy != null) {
                aVar.e(11, this.yVy);
            }
            if (this.yXR != null) {
                aVar.e(12, this.yXR);
            }
            aVar.cc(13, this.LOQ);
            AppMethodBeat.o(214300);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.dDN);
            if (this.qwn != null) {
                nh += g.a.a.b.b.a.f(3, this.qwn);
            }
            if (this.yQE != null) {
                nh += g.a.a.b.b.a.f(4, this.yQE);
            }
            if (this.yPK != null) {
                nh += g.a.a.b.b.a.f(5, this.yPK);
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.yVm) + g.a.a.b.b.a.bu(7, this.eha) + g.a.a.b.b.a.bu(8, this.egZ);
            if (this.yVb != null) {
                bu += g.a.a.b.b.a.f(9, this.yVb);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(10, this.egY);
            if (this.yVy != null) {
                bu2 += g.a.a.b.b.a.f(11, this.yVy);
            }
            if (this.yXR != null) {
                bu2 += g.a.a.b.b.a.f(12, this.yXR);
            }
            int fS = bu2 + g.a.a.b.b.a.fS(13) + 1;
            AppMethodBeat.o(214300);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(214300);
                throw bVar2;
            }
            AppMethodBeat.o(214300);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bfg bfg = (bfg) objArr[1];
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
                        bfg.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(214300);
                    return 0;
                case 2:
                    bfg.dDN = aVar3.UbS.zi();
                    AppMethodBeat.o(214300);
                    return 0;
                case 3:
                    bfg.qwn = aVar3.UbS.readString();
                    AppMethodBeat.o(214300);
                    return 0;
                case 4:
                    bfg.yQE = aVar3.UbS.readString();
                    AppMethodBeat.o(214300);
                    return 0;
                case 5:
                    bfg.yPK = aVar3.UbS.readString();
                    AppMethodBeat.o(214300);
                    return 0;
                case 6:
                    bfg.yVm = aVar3.UbS.zi();
                    AppMethodBeat.o(214300);
                    return 0;
                case 7:
                    bfg.eha = aVar3.UbS.zi();
                    AppMethodBeat.o(214300);
                    return 0;
                case 8:
                    bfg.egZ = aVar3.UbS.zi();
                    AppMethodBeat.o(214300);
                    return 0;
                case 9:
                    bfg.yVb = aVar3.UbS.readString();
                    AppMethodBeat.o(214300);
                    return 0;
                case 10:
                    bfg.egY = aVar3.UbS.zi();
                    AppMethodBeat.o(214300);
                    return 0;
                case 11:
                    bfg.yVy = aVar3.UbS.readString();
                    AppMethodBeat.o(214300);
                    return 0;
                case 12:
                    bfg.yXR = aVar3.UbS.readString();
                    AppMethodBeat.o(214300);
                    return 0;
                case 13:
                    bfg.LOQ = aVar3.UbS.yZ();
                    AppMethodBeat.o(214300);
                    return 0;
                default:
                    AppMethodBeat.o(214300);
                    return -1;
            }
        } else {
            AppMethodBeat.o(214300);
            return -1;
        }
    }
}
