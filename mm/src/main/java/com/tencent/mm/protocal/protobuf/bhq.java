package com.tencent.mm.protocal.protobuf;

import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bhq extends dpc {
    public int LSe;
    public LinkedList<al> oTA = new LinkedList<>();
    public int oTz;

    public bhq() {
        AppMethodBeat.i(NativeBitmapStruct.GLFormat.GL_RGBA);
        AppMethodBeat.o(NativeBitmapStruct.GLFormat.GL_RGBA);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(6409);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(6409);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.oTz);
            aVar.e(3, 8, this.oTA);
            aVar.aM(4, this.LSe);
            AppMethodBeat.o(6409);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.oTz) + g.a.a.a.c(3, 8, this.oTA) + g.a.a.b.b.a.bu(4, this.LSe);
            AppMethodBeat.o(6409);
            return nh;
        } else if (i2 == 2) {
            this.oTA.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(6409);
                throw bVar2;
            }
            AppMethodBeat.o(6409);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bhq bhq = (bhq) objArr[1];
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
                        bhq.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(6409);
                    return 0;
                case 2:
                    bhq.oTz = aVar3.UbS.zi();
                    AppMethodBeat.o(6409);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        al alVar = new al();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = alVar.populateBuilderWithField(aVar5, alVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bhq.oTA.add(alVar);
                    }
                    AppMethodBeat.o(6409);
                    return 0;
                case 4:
                    bhq.LSe = aVar3.UbS.zi();
                    AppMethodBeat.o(6409);
                    return 0;
                default:
                    AppMethodBeat.o(6409);
                    return -1;
            }
        } else {
            AppMethodBeat.o(6409);
            return -1;
        }
    }
}
