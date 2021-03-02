package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ejs extends dpc {
    public dju LgT;
    public int NiZ;
    public dmp Nja;
    public String dQx;
    public int pTZ;
    public String pUa;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72589);
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
            if (this.LgT != null) {
                aVar.ni(4, this.LgT.computeSize());
                this.LgT.writeFields(aVar);
            }
            if (this.Nja != null) {
                aVar.ni(5, this.Nja.computeSize());
                this.Nja.writeFields(aVar);
            }
            aVar.aM(6, this.NiZ);
            if (this.dQx != null) {
                aVar.e(7, this.dQx);
            }
            AppMethodBeat.o(72589);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.pTZ);
            if (this.pUa != null) {
                nh += g.a.a.b.b.a.f(3, this.pUa);
            }
            if (this.LgT != null) {
                nh += g.a.a.a.nh(4, this.LgT.computeSize());
            }
            if (this.Nja != null) {
                nh += g.a.a.a.nh(5, this.Nja.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.NiZ);
            if (this.dQx != null) {
                bu += g.a.a.b.b.a.f(7, this.dQx);
            }
            AppMethodBeat.o(72589);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72589);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ejs ejs = (ejs) objArr[1];
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
                        ejs.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(72589);
                    return 0;
                case 2:
                    ejs.pTZ = aVar3.UbS.zi();
                    AppMethodBeat.o(72589);
                    return 0;
                case 3:
                    ejs.pUa = aVar3.UbS.readString();
                    AppMethodBeat.o(72589);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dju dju = new dju();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dju.populateBuilderWithField(aVar5, dju, dpc.getNextFieldNumber(aVar5))) {
                        }
                        ejs.LgT = dju;
                    }
                    AppMethodBeat.o(72589);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dmp dmp = new dmp();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dmp.populateBuilderWithField(aVar6, dmp, dpc.getNextFieldNumber(aVar6))) {
                        }
                        ejs.Nja = dmp;
                    }
                    AppMethodBeat.o(72589);
                    return 0;
                case 6:
                    ejs.NiZ = aVar3.UbS.zi();
                    AppMethodBeat.o(72589);
                    return 0;
                case 7:
                    ejs.dQx = aVar3.UbS.readString();
                    AppMethodBeat.o(72589);
                    return 0;
                default:
                    AppMethodBeat.o(72589);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72589);
            return -1;
        }
    }
}
