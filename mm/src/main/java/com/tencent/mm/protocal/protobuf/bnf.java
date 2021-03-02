package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bnf extends dpc {
    public float LVN;
    public String LVO;
    public String LjH;
    public String action_data;
    public int pTZ;
    public String pUa;
    public String person_id;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104370);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(104370);
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
            if (this.person_id != null) {
                aVar.e(4, this.person_id);
            }
            if (this.action_data != null) {
                aVar.e(5, this.action_data);
            }
            aVar.E(6, this.LVN);
            if (this.LjH != null) {
                aVar.e(7, this.LjH);
            }
            if (this.LVO != null) {
                aVar.e(8, this.LVO);
            }
            AppMethodBeat.o(104370);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.pTZ);
            if (this.pUa != null) {
                nh += g.a.a.b.b.a.f(3, this.pUa);
            }
            if (this.person_id != null) {
                nh += g.a.a.b.b.a.f(4, this.person_id);
            }
            if (this.action_data != null) {
                nh += g.a.a.b.b.a.f(5, this.action_data);
            }
            int fS = nh + g.a.a.b.b.a.fS(6) + 4;
            if (this.LjH != null) {
                fS += g.a.a.b.b.a.f(7, this.LjH);
            }
            if (this.LVO != null) {
                fS += g.a.a.b.b.a.f(8, this.LVO);
            }
            AppMethodBeat.o(104370);
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
                AppMethodBeat.o(104370);
                throw bVar2;
            }
            AppMethodBeat.o(104370);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bnf bnf = (bnf) objArr[1];
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
                        bnf.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(104370);
                    return 0;
                case 2:
                    bnf.pTZ = aVar3.UbS.zi();
                    AppMethodBeat.o(104370);
                    return 0;
                case 3:
                    bnf.pUa = aVar3.UbS.readString();
                    AppMethodBeat.o(104370);
                    return 0;
                case 4:
                    bnf.person_id = aVar3.UbS.readString();
                    AppMethodBeat.o(104370);
                    return 0;
                case 5:
                    bnf.action_data = aVar3.UbS.readString();
                    AppMethodBeat.o(104370);
                    return 0;
                case 6:
                    bnf.LVN = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(104370);
                    return 0;
                case 7:
                    bnf.LjH = aVar3.UbS.readString();
                    AppMethodBeat.o(104370);
                    return 0;
                case 8:
                    bnf.LVO = aVar3.UbS.readString();
                    AppMethodBeat.o(104370);
                    return 0;
                default:
                    AppMethodBeat.o(104370);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104370);
            return -1;
        }
    }
}
