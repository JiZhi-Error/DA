package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ph extends dpc {
    public int KTf;
    public mq KWe;
    public np KWf;
    public ov KWg;
    public nr KWh;
    public ov KWi;
    public py KWj;
    public LinkedList<bfu> KWk = new LinkedList<>();
    public int KWl;
    public dey KWm;
    public String KWn;
    public qg KWo;
    public qj KWp;

    public ph() {
        AppMethodBeat.i(124444);
        AppMethodBeat.o(124444);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124445);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(124445);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.KWe != null) {
                aVar.ni(2, this.KWe.computeSize());
                this.KWe.writeFields(aVar);
            }
            if (this.KWf != null) {
                aVar.ni(3, this.KWf.computeSize());
                this.KWf.writeFields(aVar);
            }
            if (this.KWg != null) {
                aVar.ni(4, this.KWg.computeSize());
                this.KWg.writeFields(aVar);
            }
            if (this.KWh != null) {
                aVar.ni(5, this.KWh.computeSize());
                this.KWh.writeFields(aVar);
            }
            if (this.KWi != null) {
                aVar.ni(6, this.KWi.computeSize());
                this.KWi.writeFields(aVar);
            }
            if (this.KWj != null) {
                aVar.ni(7, this.KWj.computeSize());
                this.KWj.writeFields(aVar);
            }
            aVar.aM(8, this.KTf);
            aVar.e(9, 8, this.KWk);
            aVar.aM(10, this.KWl);
            if (this.KWm != null) {
                aVar.ni(11, this.KWm.computeSize());
                this.KWm.writeFields(aVar);
            }
            if (this.KWn != null) {
                aVar.e(12, this.KWn);
            }
            if (this.KWo != null) {
                aVar.ni(13, this.KWo.computeSize());
                this.KWo.writeFields(aVar);
            }
            if (this.KWp != null) {
                aVar.ni(14, this.KWp.computeSize());
                this.KWp.writeFields(aVar);
            }
            AppMethodBeat.o(124445);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.KWe != null) {
                nh += g.a.a.a.nh(2, this.KWe.computeSize());
            }
            if (this.KWf != null) {
                nh += g.a.a.a.nh(3, this.KWf.computeSize());
            }
            if (this.KWg != null) {
                nh += g.a.a.a.nh(4, this.KWg.computeSize());
            }
            if (this.KWh != null) {
                nh += g.a.a.a.nh(5, this.KWh.computeSize());
            }
            if (this.KWi != null) {
                nh += g.a.a.a.nh(6, this.KWi.computeSize());
            }
            if (this.KWj != null) {
                nh += g.a.a.a.nh(7, this.KWj.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(8, this.KTf) + g.a.a.a.c(9, 8, this.KWk) + g.a.a.b.b.a.bu(10, this.KWl);
            if (this.KWm != null) {
                bu += g.a.a.a.nh(11, this.KWm.computeSize());
            }
            if (this.KWn != null) {
                bu += g.a.a.b.b.a.f(12, this.KWn);
            }
            if (this.KWo != null) {
                bu += g.a.a.a.nh(13, this.KWo.computeSize());
            }
            if (this.KWp != null) {
                bu += g.a.a.a.nh(14, this.KWp.computeSize());
            }
            AppMethodBeat.o(124445);
            return bu;
        } else if (i2 == 2) {
            this.KWk.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(124445);
                throw bVar2;
            }
            AppMethodBeat.o(124445);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ph phVar = (ph) objArr[1];
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
                        phVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(124445);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        mq mqVar = new mq();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = mqVar.populateBuilderWithField(aVar5, mqVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        phVar.KWe = mqVar;
                    }
                    AppMethodBeat.o(124445);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        np npVar = new np();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = npVar.populateBuilderWithField(aVar6, npVar, dpc.getNextFieldNumber(aVar6))) {
                        }
                        phVar.KWf = npVar;
                    }
                    AppMethodBeat.o(124445);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        ov ovVar = new ov();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = ovVar.populateBuilderWithField(aVar7, ovVar, dpc.getNextFieldNumber(aVar7))) {
                        }
                        phVar.KWg = ovVar;
                    }
                    AppMethodBeat.o(124445);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        nr nrVar = new nr();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = nrVar.populateBuilderWithField(aVar8, nrVar, dpc.getNextFieldNumber(aVar8))) {
                        }
                        phVar.KWh = nrVar;
                    }
                    AppMethodBeat.o(124445);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        ov ovVar2 = new ov();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = ovVar2.populateBuilderWithField(aVar9, ovVar2, dpc.getNextFieldNumber(aVar9))) {
                        }
                        phVar.KWi = ovVar2;
                    }
                    AppMethodBeat.o(124445);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        py pyVar = new py();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = pyVar.populateBuilderWithField(aVar10, pyVar, dpc.getNextFieldNumber(aVar10))) {
                        }
                        phVar.KWj = pyVar;
                    }
                    AppMethodBeat.o(124445);
                    return 0;
                case 8:
                    phVar.KTf = aVar3.UbS.zi();
                    AppMethodBeat.o(124445);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        bfu bfu = new bfu();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = bfu.populateBuilderWithField(aVar11, bfu, dpc.getNextFieldNumber(aVar11))) {
                        }
                        phVar.KWk.add(bfu);
                    }
                    AppMethodBeat.o(124445);
                    return 0;
                case 10:
                    phVar.KWl = aVar3.UbS.zi();
                    AppMethodBeat.o(124445);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh9 = aVar3.awh(intValue);
                    int size9 = awh9.size();
                    for (int i11 = 0; i11 < size9; i11++) {
                        dey dey = new dey();
                        g.a.a.a.a aVar12 = new g.a.a.a.a(awh9.get(i11), unknownTagHandler);
                        for (boolean z9 = true; z9; z9 = dey.populateBuilderWithField(aVar12, dey, dpc.getNextFieldNumber(aVar12))) {
                        }
                        phVar.KWm = dey;
                    }
                    AppMethodBeat.o(124445);
                    return 0;
                case 12:
                    phVar.KWn = aVar3.UbS.readString();
                    AppMethodBeat.o(124445);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh10 = aVar3.awh(intValue);
                    int size10 = awh10.size();
                    for (int i12 = 0; i12 < size10; i12++) {
                        qg qgVar = new qg();
                        g.a.a.a.a aVar13 = new g.a.a.a.a(awh10.get(i12), unknownTagHandler);
                        for (boolean z10 = true; z10; z10 = qgVar.populateBuilderWithField(aVar13, qgVar, dpc.getNextFieldNumber(aVar13))) {
                        }
                        phVar.KWo = qgVar;
                    }
                    AppMethodBeat.o(124445);
                    return 0;
                case 14:
                    LinkedList<byte[]> awh11 = aVar3.awh(intValue);
                    int size11 = awh11.size();
                    for (int i13 = 0; i13 < size11; i13++) {
                        qj qjVar = new qj();
                        g.a.a.a.a aVar14 = new g.a.a.a.a(awh11.get(i13), unknownTagHandler);
                        for (boolean z11 = true; z11; z11 = qjVar.populateBuilderWithField(aVar14, qjVar, dpc.getNextFieldNumber(aVar14))) {
                        }
                        phVar.KWp = qjVar;
                    }
                    AppMethodBeat.o(124445);
                    return 0;
                default:
                    AppMethodBeat.o(124445);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124445);
            return -1;
        }
    }
}
