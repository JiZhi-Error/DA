package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class eav extends dpc {
    public int KZh;
    public SKBuiltinBuffer_t Lev;
    public abo Ley;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125815);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(125815);
                throw bVar;
            } else if (this.Ley == null) {
                b bVar2 = new b("Not all required fields were included: CmdList");
                AppMethodBeat.o(125815);
                throw bVar2;
            } else if (this.Lev == null) {
                b bVar3 = new b("Not all required fields were included: KeyBuf");
                AppMethodBeat.o(125815);
                throw bVar3;
            } else {
                if (this.BaseResponse != null) {
                    aVar.ni(1, this.BaseResponse.computeSize());
                    this.BaseResponse.writeFields(aVar);
                }
                if (this.Ley != null) {
                    aVar.ni(2, this.Ley.computeSize());
                    this.Ley.writeFields(aVar);
                }
                aVar.aM(3, this.KZh);
                if (this.Lev != null) {
                    aVar.ni(4, this.Lev.computeSize());
                    this.Lev.writeFields(aVar);
                }
                AppMethodBeat.o(125815);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.Ley != null) {
                nh += g.a.a.a.nh(2, this.Ley.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.KZh);
            if (this.Lev != null) {
                bu += g.a.a.a.nh(4, this.Lev.computeSize());
            }
            AppMethodBeat.o(125815);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar4 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(125815);
                throw bVar4;
            } else if (this.Ley == null) {
                b bVar5 = new b("Not all required fields were included: CmdList");
                AppMethodBeat.o(125815);
                throw bVar5;
            } else if (this.Lev == null) {
                b bVar6 = new b("Not all required fields were included: KeyBuf");
                AppMethodBeat.o(125815);
                throw bVar6;
            } else {
                AppMethodBeat.o(125815);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eav eav = (eav) objArr[1];
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
                        eav.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(125815);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        abo abo = new abo();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = abo.populateBuilderWithField(aVar5, abo, dpc.getNextFieldNumber(aVar5))) {
                        }
                        eav.Ley = abo;
                    }
                    AppMethodBeat.o(125815);
                    return 0;
                case 3:
                    eav.KZh = aVar3.UbS.zi();
                    AppMethodBeat.o(125815);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = sKBuiltinBuffer_t.populateBuilderWithField(aVar6, sKBuiltinBuffer_t, dpc.getNextFieldNumber(aVar6))) {
                        }
                        eav.Lev = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(125815);
                    return 0;
                default:
                    AppMethodBeat.o(125815);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125815);
            return -1;
        }
    }
}
