package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dpc;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ap extends dpc {
    public boolean Btc;
    public String Btd;
    public String Bte;
    public int Btf;
    public int channel;
    public String fileid;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(198634);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.fileid != null) {
                aVar.e(2, this.fileid);
            }
            aVar.cc(3, this.Btc);
            if (this.Btd != null) {
                aVar.e(4, this.Btd);
            }
            if (this.Bte != null) {
                aVar.e(5, this.Bte);
            }
            aVar.aM(6, this.Btf);
            aVar.aM(7, this.channel);
            AppMethodBeat.o(198634);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.fileid != null) {
                nh += g.a.a.b.b.a.f(2, this.fileid);
            }
            int fS = nh + g.a.a.b.b.a.fS(3) + 1;
            if (this.Btd != null) {
                fS += g.a.a.b.b.a.f(4, this.Btd);
            }
            if (this.Bte != null) {
                fS += g.a.a.b.b.a.f(5, this.Bte);
            }
            int bu = fS + g.a.a.b.b.a.bu(6, this.Btf) + g.a.a.b.b.a.bu(7, this.channel);
            AppMethodBeat.o(198634);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(198634);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ap apVar = (ap) objArr[1];
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
                        apVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(198634);
                    return 0;
                case 2:
                    apVar.fileid = aVar3.UbS.readString();
                    AppMethodBeat.o(198634);
                    return 0;
                case 3:
                    apVar.Btc = aVar3.UbS.yZ();
                    AppMethodBeat.o(198634);
                    return 0;
                case 4:
                    apVar.Btd = aVar3.UbS.readString();
                    AppMethodBeat.o(198634);
                    return 0;
                case 5:
                    apVar.Bte = aVar3.UbS.readString();
                    AppMethodBeat.o(198634);
                    return 0;
                case 6:
                    apVar.Btf = aVar3.UbS.zi();
                    AppMethodBeat.o(198634);
                    return 0;
                case 7:
                    apVar.channel = aVar3.UbS.zi();
                    AppMethodBeat.o(198634);
                    return 0;
                default:
                    AppMethodBeat.o(198634);
                    return -1;
            }
        } else {
            AppMethodBeat.o(198634);
            return -1;
        }
    }
}
