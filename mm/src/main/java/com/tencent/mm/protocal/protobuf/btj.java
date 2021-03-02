package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class btj extends dpc {
    public int KUh;
    public SKBuiltinBuffer_t LXP;
    public String LZY;
    public String LZZ;
    public String Maa;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152593);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(152593);
                throw bVar;
            } else if (this.LXP == null) {
                b bVar2 = new b("Not all required fields were included: QRCode");
                AppMethodBeat.o(152593);
                throw bVar2;
            } else {
                if (this.BaseResponse != null) {
                    aVar.ni(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.LXP != null) {
                    aVar.ni(2, this.LXP.computeSize());
                    this.LXP.writeFields(aVar);
                }
                aVar.aM(5, this.KUh);
                if (this.LZY != null) {
                    aVar.e(6, this.LZY);
                }
                if (this.LZZ != null) {
                    aVar.e(7, this.LZZ);
                }
                if (this.Maa != null) {
                    aVar.e(8, this.Maa);
                }
                AppMethodBeat.o(152593);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.LXP != null) {
                nh += g.a.a.a.nh(2, this.LXP.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.KUh);
            if (this.LZY != null) {
                bu += g.a.a.b.b.a.f(6, this.LZY);
            }
            if (this.LZZ != null) {
                bu += g.a.a.b.b.a.f(7, this.LZZ);
            }
            if (this.Maa != null) {
                bu += g.a.a.b.b.a.f(8, this.Maa);
            }
            AppMethodBeat.o(152593);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar3 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(152593);
                throw bVar3;
            } else if (this.LXP == null) {
                b bVar4 = new b("Not all required fields were included: QRCode");
                AppMethodBeat.o(152593);
                throw bVar4;
            } else {
                AppMethodBeat.o(152593);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            btj btj = (btj) objArr[1];
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
                        btj.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(152593);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dpc.getNextFieldNumber(aVar5))) {
                        }
                        btj.LXP = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(152593);
                    return 0;
                case 3:
                case 4:
                default:
                    AppMethodBeat.o(152593);
                    return -1;
                case 5:
                    btj.KUh = aVar3.UbS.zi();
                    AppMethodBeat.o(152593);
                    return 0;
                case 6:
                    btj.LZY = aVar3.UbS.readString();
                    AppMethodBeat.o(152593);
                    return 0;
                case 7:
                    btj.LZZ = aVar3.UbS.readString();
                    AppMethodBeat.o(152593);
                    return 0;
                case 8:
                    btj.Maa = aVar3.UbS.readString();
                    AppMethodBeat.o(152593);
                    return 0;
            }
        } else {
            AppMethodBeat.o(152593);
            return -1;
        }
    }
}
