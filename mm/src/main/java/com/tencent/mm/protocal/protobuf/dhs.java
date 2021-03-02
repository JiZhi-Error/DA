package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dhs extends dpc {
    public String Cjv;
    public String Cjw;
    public String MMB;
    public int MMC;
    public String MMD;
    public String MME;
    public String MMF;
    public String MMG;
    public int dDN;
    public String jCp;
    public String qwn;
    public int state;
    public int yRL;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72567);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(72567);
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
            aVar.aM(4, this.state);
            if (this.MMB != null) {
                aVar.e(5, this.MMB);
            }
            aVar.aM(6, this.yRL);
            aVar.aM(7, this.MMC);
            if (this.Cjv != null) {
                aVar.e(8, this.Cjv);
            }
            if (this.MMD != null) {
                aVar.e(9, this.MMD);
            }
            if (this.Cjw != null) {
                aVar.e(10, this.Cjw);
            }
            if (this.MME != null) {
                aVar.e(11, this.MME);
            }
            if (this.MMF != null) {
                aVar.e(12, this.MMF);
            }
            if (this.MMG != null) {
                aVar.e(14, this.MMG);
            }
            if (this.jCp != null) {
                aVar.e(15, this.jCp);
            }
            AppMethodBeat.o(72567);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.dDN);
            if (this.qwn != null) {
                nh += g.a.a.b.b.a.f(3, this.qwn);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.state);
            if (this.MMB != null) {
                bu += g.a.a.b.b.a.f(5, this.MMB);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.yRL) + g.a.a.b.b.a.bu(7, this.MMC);
            if (this.Cjv != null) {
                bu2 += g.a.a.b.b.a.f(8, this.Cjv);
            }
            if (this.MMD != null) {
                bu2 += g.a.a.b.b.a.f(9, this.MMD);
            }
            if (this.Cjw != null) {
                bu2 += g.a.a.b.b.a.f(10, this.Cjw);
            }
            if (this.MME != null) {
                bu2 += g.a.a.b.b.a.f(11, this.MME);
            }
            if (this.MMF != null) {
                bu2 += g.a.a.b.b.a.f(12, this.MMF);
            }
            if (this.MMG != null) {
                bu2 += g.a.a.b.b.a.f(14, this.MMG);
            }
            if (this.jCp != null) {
                bu2 += g.a.a.b.b.a.f(15, this.jCp);
            }
            AppMethodBeat.o(72567);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(72567);
                throw bVar2;
            }
            AppMethodBeat.o(72567);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dhs dhs = (dhs) objArr[1];
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
                        dhs.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(72567);
                    return 0;
                case 2:
                    dhs.dDN = aVar3.UbS.zi();
                    AppMethodBeat.o(72567);
                    return 0;
                case 3:
                    dhs.qwn = aVar3.UbS.readString();
                    AppMethodBeat.o(72567);
                    return 0;
                case 4:
                    dhs.state = aVar3.UbS.zi();
                    AppMethodBeat.o(72567);
                    return 0;
                case 5:
                    dhs.MMB = aVar3.UbS.readString();
                    AppMethodBeat.o(72567);
                    return 0;
                case 6:
                    dhs.yRL = aVar3.UbS.zi();
                    AppMethodBeat.o(72567);
                    return 0;
                case 7:
                    dhs.MMC = aVar3.UbS.zi();
                    AppMethodBeat.o(72567);
                    return 0;
                case 8:
                    dhs.Cjv = aVar3.UbS.readString();
                    AppMethodBeat.o(72567);
                    return 0;
                case 9:
                    dhs.MMD = aVar3.UbS.readString();
                    AppMethodBeat.o(72567);
                    return 0;
                case 10:
                    dhs.Cjw = aVar3.UbS.readString();
                    AppMethodBeat.o(72567);
                    return 0;
                case 11:
                    dhs.MME = aVar3.UbS.readString();
                    AppMethodBeat.o(72567);
                    return 0;
                case 12:
                    dhs.MMF = aVar3.UbS.readString();
                    AppMethodBeat.o(72567);
                    return 0;
                case 13:
                default:
                    AppMethodBeat.o(72567);
                    return -1;
                case 14:
                    dhs.MMG = aVar3.UbS.readString();
                    AppMethodBeat.o(72567);
                    return 0;
                case 15:
                    dhs.jCp = aVar3.UbS.readString();
                    AppMethodBeat.o(72567);
                    return 0;
            }
        } else {
            AppMethodBeat.o(72567);
            return -1;
        }
    }
}
