package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class csb extends dpc {
    public baw LAF;
    public b LBu;
    public awu LDS;
    public b LDs;
    public bcx LEA;
    public LinkedList<bcu> LEy = new LinkedList<>();
    public LinkedList<bdb> LEz = new LinkedList<>();
    public String Mxi;
    public LinkedList<FinderObject> object = new LinkedList<>();
    public String request_id;
    public int tUC;

    public csb() {
        AppMethodBeat.i(256714);
        AppMethodBeat.o(256714);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(256715);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.object);
            if (this.LDs != null) {
                aVar.c(3, this.LDs);
            }
            aVar.aM(4, this.tUC);
            if (this.LBu != null) {
                aVar.c(5, this.LBu);
            }
            if (this.LAF != null) {
                aVar.ni(6, this.LAF.computeSize());
                this.LAF.writeFields(aVar);
            }
            if (this.Mxi != null) {
                aVar.e(7, this.Mxi);
            }
            aVar.e(8, 8, this.LEy);
            aVar.e(9, 8, this.LEz);
            if (this.LDS != null) {
                aVar.ni(10, this.LDS.computeSize());
                this.LDS.writeFields(aVar);
            }
            if (this.LEA != null) {
                aVar.ni(11, this.LEA.computeSize());
                this.LEA.writeFields(aVar);
            }
            if (this.request_id != null) {
                aVar.e(100, this.request_id);
            }
            AppMethodBeat.o(256715);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.object);
            if (this.LDs != null) {
                nh += g.a.a.b.b.a.b(3, this.LDs);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.tUC);
            if (this.LBu != null) {
                bu += g.a.a.b.b.a.b(5, this.LBu);
            }
            if (this.LAF != null) {
                bu += g.a.a.a.nh(6, this.LAF.computeSize());
            }
            if (this.Mxi != null) {
                bu += g.a.a.b.b.a.f(7, this.Mxi);
            }
            int c2 = bu + g.a.a.a.c(8, 8, this.LEy) + g.a.a.a.c(9, 8, this.LEz);
            if (this.LDS != null) {
                c2 += g.a.a.a.nh(10, this.LDS.computeSize());
            }
            if (this.LEA != null) {
                c2 += g.a.a.a.nh(11, this.LEA.computeSize());
            }
            if (this.request_id != null) {
                c2 += g.a.a.b.b.a.f(100, this.request_id);
            }
            AppMethodBeat.o(256715);
            return c2;
        } else if (i2 == 2) {
            this.object.clear();
            this.LEy.clear();
            this.LEz.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(256715);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            csb csb = (csb) objArr[1];
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
                        csb.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(256715);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        FinderObject finderObject = new FinderObject();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = finderObject.populateBuilderWithField(aVar5, finderObject, dpc.getNextFieldNumber(aVar5))) {
                        }
                        csb.object.add(finderObject);
                    }
                    AppMethodBeat.o(256715);
                    return 0;
                case 3:
                    csb.LDs = aVar3.UbS.hPo();
                    AppMethodBeat.o(256715);
                    return 0;
                case 4:
                    csb.tUC = aVar3.UbS.zi();
                    AppMethodBeat.o(256715);
                    return 0;
                case 5:
                    csb.LBu = aVar3.UbS.hPo();
                    AppMethodBeat.o(256715);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        baw baw = new baw();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = baw.populateBuilderWithField(aVar6, baw, dpc.getNextFieldNumber(aVar6))) {
                        }
                        csb.LAF = baw;
                    }
                    AppMethodBeat.o(256715);
                    return 0;
                case 7:
                    csb.Mxi = aVar3.UbS.readString();
                    AppMethodBeat.o(256715);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        bcu bcu = new bcu();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = bcu.populateBuilderWithField(aVar7, bcu, dpc.getNextFieldNumber(aVar7))) {
                        }
                        csb.LEy.add(bcu);
                    }
                    AppMethodBeat.o(256715);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        bdb bdb = new bdb();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = bdb.populateBuilderWithField(aVar8, bdb, dpc.getNextFieldNumber(aVar8))) {
                        }
                        csb.LEz.add(bdb);
                    }
                    AppMethodBeat.o(256715);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        awu awu = new awu();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = awu.populateBuilderWithField(aVar9, awu, dpc.getNextFieldNumber(aVar9))) {
                        }
                        csb.LDS = awu;
                    }
                    AppMethodBeat.o(256715);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        bcx bcx = new bcx();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = bcx.populateBuilderWithField(aVar10, bcx, dpc.getNextFieldNumber(aVar10))) {
                        }
                        csb.LEA = bcx;
                    }
                    AppMethodBeat.o(256715);
                    return 0;
                case 100:
                    csb.request_id = aVar3.UbS.readString();
                    AppMethodBeat.o(256715);
                    return 0;
                default:
                    AppMethodBeat.o(256715);
                    return -1;
            }
        } else {
            AppMethodBeat.o(256715);
            return -1;
        }
    }
}
