package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class yd extends dpc {
    public LinkedList<ye> Ljd = new LinkedList<>();
    public String dHx;
    public String hJl;
    public int kqW;

    public yd() {
        AppMethodBeat.i(186342);
        AppMethodBeat.o(186342);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(186343);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.Ljd);
            if (this.dHx != null) {
                aVar.e(3, this.dHx);
            }
            aVar.aM(4, this.kqW);
            if (this.hJl != null) {
                aVar.e(5, this.hJl);
            }
            AppMethodBeat.o(186343);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.Ljd);
            if (this.dHx != null) {
                nh += g.a.a.b.b.a.f(3, this.dHx);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.kqW);
            if (this.hJl != null) {
                bu += g.a.a.b.b.a.f(5, this.hJl);
            }
            AppMethodBeat.o(186343);
            return bu;
        } else if (i2 == 2) {
            this.Ljd.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(186343);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            yd ydVar = (yd) objArr[1];
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
                        ydVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(186343);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ye yeVar = new ye();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = yeVar.populateBuilderWithField(aVar5, yeVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        ydVar.Ljd.add(yeVar);
                    }
                    AppMethodBeat.o(186343);
                    return 0;
                case 3:
                    ydVar.dHx = aVar3.UbS.readString();
                    AppMethodBeat.o(186343);
                    return 0;
                case 4:
                    ydVar.kqW = aVar3.UbS.zi();
                    AppMethodBeat.o(186343);
                    return 0;
                case 5:
                    ydVar.hJl = aVar3.UbS.readString();
                    AppMethodBeat.o(186343);
                    return 0;
                default:
                    AppMethodBeat.o(186343);
                    return -1;
            }
        } else {
            AppMethodBeat.o(186343);
            return -1;
        }
    }
}
