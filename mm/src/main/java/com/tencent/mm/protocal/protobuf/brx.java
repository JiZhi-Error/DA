package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class brx extends dpc {
    public String KCL;
    public String KTg;
    public int KWa;
    public String KZj;
    public SKBuiltinBuffer_t LXm;
    public String LXv;
    public int LXw;
    public int LZb;
    public LinkedList<cxt> LZc = new LinkedList<>();
    public int OpCode;
    public String Url;

    public brx() {
        AppMethodBeat.i(56250);
        AppMethodBeat.o(56250);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(56251);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56251);
                throw bVar;
            } else if (this.LXm == null) {
                b bVar2 = new b("Not all required fields were included: Buff");
                AppMethodBeat.o(56251);
                throw bVar2;
            } else {
                if (this.BaseResponse != null) {
                    aVar.ni(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                aVar.aM(2, this.LZb);
                aVar.e(3, 8, this.LZc);
                aVar.aM(4, this.OpCode);
                aVar.aM(5, this.KWa);
                if (this.LXm != null) {
                    aVar.ni(6, this.LXm.computeSize());
                    this.LXm.writeFields(aVar);
                }
                if (this.Url != null) {
                    aVar.e(7, this.Url);
                }
                if (this.LXv != null) {
                    aVar.e(8, this.LXv);
                }
                if (this.KTg != null) {
                    aVar.e(9, this.KTg);
                }
                if (this.KCL != null) {
                    aVar.e(10, this.KCL);
                }
                aVar.aM(11, this.LXw);
                if (this.KZj != null) {
                    aVar.e(12, this.KZj);
                }
                AppMethodBeat.o(56251);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LZb) + g.a.a.a.c(3, 8, this.LZc) + g.a.a.b.b.a.bu(4, this.OpCode) + g.a.a.b.b.a.bu(5, this.KWa);
            if (this.LXm != null) {
                nh += g.a.a.a.nh(6, this.LXm.computeSize());
            }
            if (this.Url != null) {
                nh += g.a.a.b.b.a.f(7, this.Url);
            }
            if (this.LXv != null) {
                nh += g.a.a.b.b.a.f(8, this.LXv);
            }
            if (this.KTg != null) {
                nh += g.a.a.b.b.a.f(9, this.KTg);
            }
            if (this.KCL != null) {
                nh += g.a.a.b.b.a.f(10, this.KCL);
            }
            int bu = nh + g.a.a.b.b.a.bu(11, this.LXw);
            if (this.KZj != null) {
                bu += g.a.a.b.b.a.f(12, this.KZj);
            }
            AppMethodBeat.o(56251);
            return bu;
        } else if (i2 == 2) {
            this.LZc.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar3 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(56251);
                throw bVar3;
            } else if (this.LXm == null) {
                b bVar4 = new b("Not all required fields were included: Buff");
                AppMethodBeat.o(56251);
                throw bVar4;
            } else {
                AppMethodBeat.o(56251);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            brx brx = (brx) objArr[1];
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
                        brx.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(56251);
                    return 0;
                case 2:
                    brx.LZb = aVar3.UbS.zi();
                    AppMethodBeat.o(56251);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cxt cxt = new cxt();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cxt.populateBuilderWithField(aVar5, cxt, dpc.getNextFieldNumber(aVar5))) {
                        }
                        brx.LZc.add(cxt);
                    }
                    AppMethodBeat.o(56251);
                    return 0;
                case 4:
                    brx.OpCode = aVar3.UbS.zi();
                    AppMethodBeat.o(56251);
                    return 0;
                case 5:
                    brx.KWa = aVar3.UbS.zi();
                    AppMethodBeat.o(56251);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = sKBuiltinBuffer_t.populateBuilderWithField(aVar6, sKBuiltinBuffer_t, dpc.getNextFieldNumber(aVar6))) {
                        }
                        brx.LXm = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(56251);
                    return 0;
                case 7:
                    brx.Url = aVar3.UbS.readString();
                    AppMethodBeat.o(56251);
                    return 0;
                case 8:
                    brx.LXv = aVar3.UbS.readString();
                    AppMethodBeat.o(56251);
                    return 0;
                case 9:
                    brx.KTg = aVar3.UbS.readString();
                    AppMethodBeat.o(56251);
                    return 0;
                case 10:
                    brx.KCL = aVar3.UbS.readString();
                    AppMethodBeat.o(56251);
                    return 0;
                case 11:
                    brx.LXw = aVar3.UbS.zi();
                    AppMethodBeat.o(56251);
                    return 0;
                case 12:
                    brx.KZj = aVar3.UbS.readString();
                    AppMethodBeat.o(56251);
                    return 0;
                default:
                    AppMethodBeat.o(56251);
                    return -1;
            }
        } else {
            AppMethodBeat.o(56251);
            return -1;
        }
    }
}
