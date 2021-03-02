package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dpc;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ba extends dpc {
    public LinkedList<al> Btp = new LinkedList<>();
    public LinkedList<al> Btq = new LinkedList<>();
    public LinkedList<al> Btr = new LinkedList<>();
    public long Bts;
    public boolean Btt;

    public ba() {
        AppMethodBeat.i(198645);
        AppMethodBeat.o(198645);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(198646);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.Btp);
            aVar.e(3, 8, this.Btq);
            aVar.e(4, 8, this.Btr);
            aVar.bb(5, this.Bts);
            aVar.cc(6, this.Btt);
            AppMethodBeat.o(198646);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.Btp) + g.a.a.a.c(3, 8, this.Btq) + g.a.a.a.c(4, 8, this.Btr) + g.a.a.b.b.a.r(5, this.Bts) + g.a.a.b.b.a.fS(6) + 1;
            AppMethodBeat.o(198646);
            return nh;
        } else if (i2 == 2) {
            this.Btp.clear();
            this.Btq.clear();
            this.Btr.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(198646);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ba baVar = (ba) objArr[1];
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
                        baVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(198646);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        al alVar = new al();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = alVar.populateBuilderWithField(aVar5, alVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        baVar.Btp.add(alVar);
                    }
                    AppMethodBeat.o(198646);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        al alVar2 = new al();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = alVar2.populateBuilderWithField(aVar6, alVar2, dpc.getNextFieldNumber(aVar6))) {
                        }
                        baVar.Btq.add(alVar2);
                    }
                    AppMethodBeat.o(198646);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        al alVar3 = new al();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = alVar3.populateBuilderWithField(aVar7, alVar3, dpc.getNextFieldNumber(aVar7))) {
                        }
                        baVar.Btr.add(alVar3);
                    }
                    AppMethodBeat.o(198646);
                    return 0;
                case 5:
                    baVar.Bts = aVar3.UbS.zl();
                    AppMethodBeat.o(198646);
                    return 0;
                case 6:
                    baVar.Btt = aVar3.UbS.yZ();
                    AppMethodBeat.o(198646);
                    return 0;
                default:
                    AppMethodBeat.o(198646);
                    return -1;
            }
        } else {
            AppMethodBeat.o(198646);
            return -1;
        }
    }
}
