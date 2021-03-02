package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class atv extends dpc {
    public bds LEG;
    public int LEH;
    public dcz LEI;
    public bdr bgmInfo;
    public int continueFlag;
    public b lastBuffer;
    public LinkedList<FinderObject> object = new LinkedList<>();
    public baw preloadInfo;
    public dmk tTT;
    public long tTn;

    public atv() {
        AppMethodBeat.i(168991);
        AppMethodBeat.o(168991);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(168992);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(168992);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.object);
            if (this.lastBuffer != null) {
                aVar.c(3, this.lastBuffer);
            }
            aVar.aM(4, this.continueFlag);
            aVar.bb(5, this.tTn);
            if (this.LEG != null) {
                aVar.ni(6, this.LEG.computeSize());
                this.LEG.writeFields(aVar);
            }
            aVar.aM(7, this.LEH);
            if (this.tTT != null) {
                aVar.ni(8, this.tTT.computeSize());
                this.tTT.writeFields(aVar);
            }
            if (this.LEI != null) {
                aVar.ni(9, this.LEI.computeSize());
                this.LEI.writeFields(aVar);
            }
            if (this.preloadInfo != null) {
                aVar.ni(10, this.preloadInfo.computeSize());
                this.preloadInfo.writeFields(aVar);
            }
            if (this.bgmInfo != null) {
                aVar.ni(11, this.bgmInfo.computeSize());
                this.bgmInfo.writeFields(aVar);
            }
            AppMethodBeat.o(168992);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.object);
            if (this.lastBuffer != null) {
                nh += g.a.a.b.b.a.b(3, this.lastBuffer);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.continueFlag) + g.a.a.b.b.a.r(5, this.tTn);
            if (this.LEG != null) {
                bu += g.a.a.a.nh(6, this.LEG.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.LEH);
            if (this.tTT != null) {
                bu2 += g.a.a.a.nh(8, this.tTT.computeSize());
            }
            if (this.LEI != null) {
                bu2 += g.a.a.a.nh(9, this.LEI.computeSize());
            }
            if (this.preloadInfo != null) {
                bu2 += g.a.a.a.nh(10, this.preloadInfo.computeSize());
            }
            if (this.bgmInfo != null) {
                bu2 += g.a.a.a.nh(11, this.bgmInfo.computeSize());
            }
            AppMethodBeat.o(168992);
            return bu2;
        } else if (i2 == 2) {
            this.object.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(168992);
                throw bVar2;
            }
            AppMethodBeat.o(168992);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            atv atv = (atv) objArr[1];
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
                        atv.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(168992);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        FinderObject finderObject = new FinderObject();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = finderObject.populateBuilderWithField(aVar5, finderObject, dpc.getNextFieldNumber(aVar5))) {
                        }
                        atv.object.add(finderObject);
                    }
                    AppMethodBeat.o(168992);
                    return 0;
                case 3:
                    atv.lastBuffer = aVar3.UbS.hPo();
                    AppMethodBeat.o(168992);
                    return 0;
                case 4:
                    atv.continueFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(168992);
                    return 0;
                case 5:
                    atv.tTn = aVar3.UbS.zl();
                    AppMethodBeat.o(168992);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        bds bds = new bds();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = bds.populateBuilderWithField(aVar6, bds, dpc.getNextFieldNumber(aVar6))) {
                        }
                        atv.LEG = bds;
                    }
                    AppMethodBeat.o(168992);
                    return 0;
                case 7:
                    atv.LEH = aVar3.UbS.zi();
                    AppMethodBeat.o(168992);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dmk dmk = new dmk();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dmk.populateBuilderWithField(aVar7, dmk, dpc.getNextFieldNumber(aVar7))) {
                        }
                        atv.tTT = dmk;
                    }
                    AppMethodBeat.o(168992);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        dcz dcz = new dcz();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = dcz.populateBuilderWithField(aVar8, dcz, dpc.getNextFieldNumber(aVar8))) {
                        }
                        atv.LEI = dcz;
                    }
                    AppMethodBeat.o(168992);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        baw baw = new baw();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = baw.populateBuilderWithField(aVar9, baw, dpc.getNextFieldNumber(aVar9))) {
                        }
                        atv.preloadInfo = baw;
                    }
                    AppMethodBeat.o(168992);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        bdr bdr = new bdr();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = bdr.populateBuilderWithField(aVar10, bdr, dpc.getNextFieldNumber(aVar10))) {
                        }
                        atv.bgmInfo = bdr;
                    }
                    AppMethodBeat.o(168992);
                    return 0;
                default:
                    AppMethodBeat.o(168992);
                    return -1;
            }
        } else {
            AppMethodBeat.o(168992);
            return -1;
        }
    }
}
