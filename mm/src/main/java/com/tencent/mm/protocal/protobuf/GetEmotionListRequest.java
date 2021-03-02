package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public class GetEmotionListRequest extends dop {
    public int Category;
    public SKBuiltinBuffer_t ReqBuf;
    public int ReqType;
    public int Scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104799);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.ReqBuf == null) {
                b bVar = new b("Not all required fields were included: ReqBuf");
                AppMethodBeat.o(104799);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.ReqBuf != null) {
                aVar.ni(2, this.ReqBuf.computeSize());
                this.ReqBuf.writeFields(aVar);
            }
            aVar.aM(3, this.ReqType);
            aVar.aM(4, this.Scene);
            aVar.aM(5, this.Category);
            AppMethodBeat.o(104799);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.ReqBuf != null) {
                nh += g.a.a.a.nh(2, this.ReqBuf.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.ReqType) + g.a.a.b.b.a.bu(4, this.Scene) + g.a.a.b.b.a.bu(5, this.Category);
            AppMethodBeat.o(104799);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.ReqBuf == null) {
                b bVar2 = new b("Not all required fields were included: ReqBuf");
                AppMethodBeat.o(104799);
                throw bVar2;
            }
            AppMethodBeat.o(104799);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            GetEmotionListRequest getEmotionListRequest = (GetEmotionListRequest) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.populateBuilderWithField(aVar4, jrVar, dop.getNextFieldNumber(aVar4))) {
                        }
                        getEmotionListRequest.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(104799);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar5))) {
                        }
                        getEmotionListRequest.ReqBuf = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(104799);
                    return 0;
                case 3:
                    getEmotionListRequest.ReqType = aVar3.UbS.zi();
                    AppMethodBeat.o(104799);
                    return 0;
                case 4:
                    getEmotionListRequest.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(104799);
                    return 0;
                case 5:
                    getEmotionListRequest.Category = aVar3.UbS.zi();
                    AppMethodBeat.o(104799);
                    return 0;
                default:
                    AppMethodBeat.o(104799);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104799);
            return -1;
        }
    }
}
