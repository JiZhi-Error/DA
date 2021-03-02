package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class boh extends dpc {
    public String HHX;
    public boolean HHY;
    public String HHZ;
    public String HIa;
    public String HIb;
    public String HIc;
    public String HId;
    public String HIe;
    public boolean HIg;
    public LinkedList<cbg> LWw = new LinkedList<>();
    public int dDN = 0;
    public String qwn = "ok";

    public boh() {
        AppMethodBeat.i(72486);
        AppMethodBeat.o(72486);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72487);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(72487);
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
            if (this.HHX != null) {
                aVar.e(4, this.HHX);
            }
            aVar.cc(6, this.HHY);
            if (this.HHZ != null) {
                aVar.e(7, this.HHZ);
            }
            if (this.HIa != null) {
                aVar.e(8, this.HIa);
            }
            if (this.HIb != null) {
                aVar.e(9, this.HIb);
            }
            if (this.HIc != null) {
                aVar.e(10, this.HIc);
            }
            if (this.HId != null) {
                aVar.e(11, this.HId);
            }
            if (this.HIe != null) {
                aVar.e(12, this.HIe);
            }
            aVar.e(13, 8, this.LWw);
            aVar.cc(14, this.HIg);
            AppMethodBeat.o(72487);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.dDN);
            if (this.qwn != null) {
                nh += g.a.a.b.b.a.f(3, this.qwn);
            }
            if (this.HHX != null) {
                nh += g.a.a.b.b.a.f(4, this.HHX);
            }
            int fS = nh + g.a.a.b.b.a.fS(6) + 1;
            if (this.HHZ != null) {
                fS += g.a.a.b.b.a.f(7, this.HHZ);
            }
            if (this.HIa != null) {
                fS += g.a.a.b.b.a.f(8, this.HIa);
            }
            if (this.HIb != null) {
                fS += g.a.a.b.b.a.f(9, this.HIb);
            }
            if (this.HIc != null) {
                fS += g.a.a.b.b.a.f(10, this.HIc);
            }
            if (this.HId != null) {
                fS += g.a.a.b.b.a.f(11, this.HId);
            }
            if (this.HIe != null) {
                fS += g.a.a.b.b.a.f(12, this.HIe);
            }
            int c2 = fS + g.a.a.a.c(13, 8, this.LWw) + g.a.a.b.b.a.fS(14) + 1;
            AppMethodBeat.o(72487);
            return c2;
        } else if (i2 == 2) {
            this.LWw.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(72487);
                throw bVar2;
            }
            AppMethodBeat.o(72487);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            boh boh = (boh) objArr[1];
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
                        boh.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(72487);
                    return 0;
                case 2:
                    boh.dDN = aVar3.UbS.zi();
                    AppMethodBeat.o(72487);
                    return 0;
                case 3:
                    boh.qwn = aVar3.UbS.readString();
                    AppMethodBeat.o(72487);
                    return 0;
                case 4:
                    boh.HHX = aVar3.UbS.readString();
                    AppMethodBeat.o(72487);
                    return 0;
                case 5:
                default:
                    AppMethodBeat.o(72487);
                    return -1;
                case 6:
                    boh.HHY = aVar3.UbS.yZ();
                    AppMethodBeat.o(72487);
                    return 0;
                case 7:
                    boh.HHZ = aVar3.UbS.readString();
                    AppMethodBeat.o(72487);
                    return 0;
                case 8:
                    boh.HIa = aVar3.UbS.readString();
                    AppMethodBeat.o(72487);
                    return 0;
                case 9:
                    boh.HIb = aVar3.UbS.readString();
                    AppMethodBeat.o(72487);
                    return 0;
                case 10:
                    boh.HIc = aVar3.UbS.readString();
                    AppMethodBeat.o(72487);
                    return 0;
                case 11:
                    boh.HId = aVar3.UbS.readString();
                    AppMethodBeat.o(72487);
                    return 0;
                case 12:
                    boh.HIe = aVar3.UbS.readString();
                    AppMethodBeat.o(72487);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cbg cbg = new cbg();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cbg.populateBuilderWithField(aVar5, cbg, dpc.getNextFieldNumber(aVar5))) {
                        }
                        boh.LWw.add(cbg);
                    }
                    AppMethodBeat.o(72487);
                    return 0;
                case 14:
                    boh.HIg = aVar3.UbS.yZ();
                    AppMethodBeat.o(72487);
                    return 0;
            }
        } else {
            AppMethodBeat.o(72487);
            return -1;
        }
    }
}
