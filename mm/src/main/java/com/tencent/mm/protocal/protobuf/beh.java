package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class beh extends dpc {
    public bee LOb;
    public bef LOc;
    public azk musicInfo;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209716);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.LOb != null) {
                aVar.ni(2, this.LOb.computeSize());
                this.LOb.writeFields(aVar);
            }
            if (this.LOc != null) {
                aVar.ni(3, this.LOc.computeSize());
                this.LOc.writeFields(aVar);
            }
            if (this.musicInfo != null) {
                aVar.ni(4, this.musicInfo.computeSize());
                this.musicInfo.writeFields(aVar);
            }
            AppMethodBeat.o(209716);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.LOb != null) {
                nh += g.a.a.a.nh(2, this.LOb.computeSize());
            }
            if (this.LOc != null) {
                nh += g.a.a.a.nh(3, this.LOc.computeSize());
            }
            if (this.musicInfo != null) {
                nh += g.a.a.a.nh(4, this.musicInfo.computeSize());
            }
            AppMethodBeat.o(209716);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209716);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            beh beh = (beh) objArr[1];
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
                        beh.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(209716);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        bee bee = new bee();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = bee.populateBuilderWithField(aVar5, bee, dpc.getNextFieldNumber(aVar5))) {
                        }
                        beh.LOb = bee;
                    }
                    AppMethodBeat.o(209716);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        bef bef = new bef();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = bef.populateBuilderWithField(aVar6, bef, dpc.getNextFieldNumber(aVar6))) {
                        }
                        beh.LOc = bef;
                    }
                    AppMethodBeat.o(209716);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        azk azk = new azk();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = azk.populateBuilderWithField(aVar7, azk, dpc.getNextFieldNumber(aVar7))) {
                        }
                        beh.musicInfo = azk;
                    }
                    AppMethodBeat.o(209716);
                    return 0;
                default:
                    AppMethodBeat.o(209716);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209716);
            return -1;
        }
    }
}
