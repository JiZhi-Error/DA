package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dep extends dpc {
    public String KBs;
    public cov LYf;
    public String MJH;
    public String MJI;
    public cdg MJy;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(214321);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(214321);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.LYf != null) {
                aVar.ni(2, this.LYf.computeSize());
                this.LYf.writeFields(aVar);
            }
            if (this.KBs != null) {
                aVar.e(3, this.KBs);
            }
            if (this.MJH != null) {
                aVar.e(4, this.MJH);
            }
            if (this.MJI != null) {
                aVar.e(5, this.MJI);
            }
            if (this.MJy != null) {
                aVar.ni(100, this.MJy.computeSize());
                this.MJy.writeFields(aVar);
            }
            AppMethodBeat.o(214321);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.LYf != null) {
                nh += g.a.a.a.nh(2, this.LYf.computeSize());
            }
            if (this.KBs != null) {
                nh += g.a.a.b.b.a.f(3, this.KBs);
            }
            if (this.MJH != null) {
                nh += g.a.a.b.b.a.f(4, this.MJH);
            }
            if (this.MJI != null) {
                nh += g.a.a.b.b.a.f(5, this.MJI);
            }
            if (this.MJy != null) {
                nh += g.a.a.a.nh(100, this.MJy.computeSize());
            }
            AppMethodBeat.o(214321);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(214321);
                throw bVar2;
            }
            AppMethodBeat.o(214321);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dep dep = (dep) objArr[1];
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
                        dep.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(214321);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cov cov = new cov();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cov.populateBuilderWithField(aVar5, cov, dpc.getNextFieldNumber(aVar5))) {
                        }
                        dep.LYf = cov;
                    }
                    AppMethodBeat.o(214321);
                    return 0;
                case 3:
                    dep.KBs = aVar3.UbS.readString();
                    AppMethodBeat.o(214321);
                    return 0;
                case 4:
                    dep.MJH = aVar3.UbS.readString();
                    AppMethodBeat.o(214321);
                    return 0;
                case 5:
                    dep.MJI = aVar3.UbS.readString();
                    AppMethodBeat.o(214321);
                    return 0;
                case 100:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cdg cdg = new cdg();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cdg.populateBuilderWithField(aVar6, cdg, dpc.getNextFieldNumber(aVar6))) {
                        }
                        dep.MJy = cdg;
                    }
                    AppMethodBeat.o(214321);
                    return 0;
                default:
                    AppMethodBeat.o(214321);
                    return -1;
            }
        } else {
            AppMethodBeat.o(214321);
            return -1;
        }
    }
}
