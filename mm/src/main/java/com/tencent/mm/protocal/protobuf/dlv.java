package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dlv extends dpc {
    public String AOk;
    public String HuS;
    public int MJd;
    public boolean MPt;
    public boolean MPu;
    public String MPv;
    public String MPw;
    public String MPx;
    public String MPy;
    public ckj efB;
    public int pTZ;
    public String pUa;
    public int status;
    public String ynT;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91666);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91666);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.pTZ);
            if (this.pUa != null) {
                aVar.e(3, this.pUa);
            }
            aVar.cc(4, this.MPt);
            aVar.cc(5, this.MPu);
            aVar.aM(6, this.status);
            if (this.MPv != null) {
                aVar.e(7, this.MPv);
            }
            if (this.MPw != null) {
                aVar.e(8, this.MPw);
            }
            aVar.aM(9, this.MJd);
            if (this.ynT != null) {
                aVar.e(10, this.ynT);
            }
            if (this.AOk != null) {
                aVar.e(11, this.AOk);
            }
            if (this.MPx != null) {
                aVar.e(12, this.MPx);
            }
            if (this.MPy != null) {
                aVar.e(13, this.MPy);
            }
            if (this.efB != null) {
                aVar.ni(99, this.efB.computeSize());
                this.efB.writeFields(aVar);
            }
            if (this.HuS != null) {
                aVar.e(100, this.HuS);
            }
            AppMethodBeat.o(91666);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.pTZ);
            if (this.pUa != null) {
                nh += g.a.a.b.b.a.f(3, this.pUa);
            }
            int fS = nh + g.a.a.b.b.a.fS(4) + 1 + g.a.a.b.b.a.fS(5) + 1 + g.a.a.b.b.a.bu(6, this.status);
            if (this.MPv != null) {
                fS += g.a.a.b.b.a.f(7, this.MPv);
            }
            if (this.MPw != null) {
                fS += g.a.a.b.b.a.f(8, this.MPw);
            }
            int bu = fS + g.a.a.b.b.a.bu(9, this.MJd);
            if (this.ynT != null) {
                bu += g.a.a.b.b.a.f(10, this.ynT);
            }
            if (this.AOk != null) {
                bu += g.a.a.b.b.a.f(11, this.AOk);
            }
            if (this.MPx != null) {
                bu += g.a.a.b.b.a.f(12, this.MPx);
            }
            if (this.MPy != null) {
                bu += g.a.a.b.b.a.f(13, this.MPy);
            }
            if (this.efB != null) {
                bu += g.a.a.a.nh(99, this.efB.computeSize());
            }
            if (this.HuS != null) {
                bu += g.a.a.b.b.a.f(100, this.HuS);
            }
            AppMethodBeat.o(91666);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91666);
                throw bVar2;
            }
            AppMethodBeat.o(91666);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dlv dlv = (dlv) objArr[1];
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
                        dlv.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(91666);
                    return 0;
                case 2:
                    dlv.pTZ = aVar3.UbS.zi();
                    AppMethodBeat.o(91666);
                    return 0;
                case 3:
                    dlv.pUa = aVar3.UbS.readString();
                    AppMethodBeat.o(91666);
                    return 0;
                case 4:
                    dlv.MPt = aVar3.UbS.yZ();
                    AppMethodBeat.o(91666);
                    return 0;
                case 5:
                    dlv.MPu = aVar3.UbS.yZ();
                    AppMethodBeat.o(91666);
                    return 0;
                case 6:
                    dlv.status = aVar3.UbS.zi();
                    AppMethodBeat.o(91666);
                    return 0;
                case 7:
                    dlv.MPv = aVar3.UbS.readString();
                    AppMethodBeat.o(91666);
                    return 0;
                case 8:
                    dlv.MPw = aVar3.UbS.readString();
                    AppMethodBeat.o(91666);
                    return 0;
                case 9:
                    dlv.MJd = aVar3.UbS.zi();
                    AppMethodBeat.o(91666);
                    return 0;
                case 10:
                    dlv.ynT = aVar3.UbS.readString();
                    AppMethodBeat.o(91666);
                    return 0;
                case 11:
                    dlv.AOk = aVar3.UbS.readString();
                    AppMethodBeat.o(91666);
                    return 0;
                case 12:
                    dlv.MPx = aVar3.UbS.readString();
                    AppMethodBeat.o(91666);
                    return 0;
                case 13:
                    dlv.MPy = aVar3.UbS.readString();
                    AppMethodBeat.o(91666);
                    return 0;
                case 99:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ckj ckj = new ckj();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ckj.populateBuilderWithField(aVar5, ckj, dpc.getNextFieldNumber(aVar5))) {
                        }
                        dlv.efB = ckj;
                    }
                    AppMethodBeat.o(91666);
                    return 0;
                case 100:
                    dlv.HuS = aVar3.UbS.readString();
                    AppMethodBeat.o(91666);
                    return 0;
                default:
                    AppMethodBeat.o(91666);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91666);
            return -1;
        }
    }
}
