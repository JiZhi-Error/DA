package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class yi extends dpc {
    public fcd Ljo;
    public boolean Ljp;
    public String Ljq;
    public String Ljr;
    public boolean Ljs;
    public String Ljt;
    public String Lju;
    public String Ljv;
    public String Ljw;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123562);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(123562);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.Ljo != null) {
                aVar.ni(2, this.Ljo.computeSize());
                this.Ljo.writeFields(aVar);
            }
            aVar.cc(3, this.Ljp);
            if (this.Ljq != null) {
                aVar.e(4, this.Ljq);
            }
            if (this.Ljr != null) {
                aVar.e(5, this.Ljr);
            }
            aVar.cc(6, this.Ljs);
            if (this.Ljt != null) {
                aVar.e(7, this.Ljt);
            }
            if (this.Lju != null) {
                aVar.e(8, this.Lju);
            }
            if (this.Ljv != null) {
                aVar.e(9, this.Ljv);
            }
            if (this.Ljw != null) {
                aVar.e(10, this.Ljw);
            }
            AppMethodBeat.o(123562);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.Ljo != null) {
                nh += g.a.a.a.nh(2, this.Ljo.computeSize());
            }
            int fS = nh + g.a.a.b.b.a.fS(3) + 1;
            if (this.Ljq != null) {
                fS += g.a.a.b.b.a.f(4, this.Ljq);
            }
            if (this.Ljr != null) {
                fS += g.a.a.b.b.a.f(5, this.Ljr);
            }
            int fS2 = fS + g.a.a.b.b.a.fS(6) + 1;
            if (this.Ljt != null) {
                fS2 += g.a.a.b.b.a.f(7, this.Ljt);
            }
            if (this.Lju != null) {
                fS2 += g.a.a.b.b.a.f(8, this.Lju);
            }
            if (this.Ljv != null) {
                fS2 += g.a.a.b.b.a.f(9, this.Ljv);
            }
            if (this.Ljw != null) {
                fS2 += g.a.a.b.b.a.f(10, this.Ljw);
            }
            AppMethodBeat.o(123562);
            return fS2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(123562);
                throw bVar2;
            }
            AppMethodBeat.o(123562);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            yi yiVar = (yi) objArr[1];
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
                        yiVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(123562);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        fcd fcd = new fcd();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = fcd.populateBuilderWithField(aVar5, fcd, dpc.getNextFieldNumber(aVar5))) {
                        }
                        yiVar.Ljo = fcd;
                    }
                    AppMethodBeat.o(123562);
                    return 0;
                case 3:
                    yiVar.Ljp = aVar3.UbS.yZ();
                    AppMethodBeat.o(123562);
                    return 0;
                case 4:
                    yiVar.Ljq = aVar3.UbS.readString();
                    AppMethodBeat.o(123562);
                    return 0;
                case 5:
                    yiVar.Ljr = aVar3.UbS.readString();
                    AppMethodBeat.o(123562);
                    return 0;
                case 6:
                    yiVar.Ljs = aVar3.UbS.yZ();
                    AppMethodBeat.o(123562);
                    return 0;
                case 7:
                    yiVar.Ljt = aVar3.UbS.readString();
                    AppMethodBeat.o(123562);
                    return 0;
                case 8:
                    yiVar.Lju = aVar3.UbS.readString();
                    AppMethodBeat.o(123562);
                    return 0;
                case 9:
                    yiVar.Ljv = aVar3.UbS.readString();
                    AppMethodBeat.o(123562);
                    return 0;
                case 10:
                    yiVar.Ljw = aVar3.UbS.readString();
                    AppMethodBeat.o(123562);
                    return 0;
                default:
                    AppMethodBeat.o(123562);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123562);
            return -1;
        }
    }
}
