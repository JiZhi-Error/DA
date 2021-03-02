package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class aom extends dpc {
    public azn LAA;
    public LinkedList<String> LAC = new LinkedList<>();
    public int LAD;
    public cxs LAE;
    public baw LAF;
    public LinkedList<FinderObject> LAG = new LinkedList<>();
    public String LAH;
    public String LAx;
    public bdy LAy;
    public int LAz;
    public FinderContact contact;
    public int continueFlag;
    public int fans_count;
    public int friend_follow_count;
    public b lastBuffer;
    public LinkedList<FinderObject> object = new LinkedList<>();
    public int privateLock;

    public aom() {
        AppMethodBeat.i(209326);
        AppMethodBeat.o(209326);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209327);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(209327);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.object);
            if (this.LAx != null) {
                aVar.e(3, this.LAx);
            }
            if (this.LAy != null) {
                aVar.ni(4, this.LAy.computeSize());
                this.LAy.writeFields(aVar);
            }
            if (this.contact != null) {
                aVar.ni(5, this.contact.computeSize());
                this.contact.writeFields(aVar);
            }
            aVar.aM(6, this.LAz);
            aVar.aM(7, this.continueFlag);
            if (this.LAA != null) {
                aVar.ni(8, this.LAA.computeSize());
                this.LAA.writeFields(aVar);
            }
            aVar.aM(9, this.fans_count);
            if (this.lastBuffer != null) {
                aVar.c(10, this.lastBuffer);
            }
            aVar.aM(11, this.friend_follow_count);
            aVar.e(12, 1, this.LAC);
            aVar.aM(13, this.LAD);
            if (this.LAE != null) {
                aVar.ni(14, this.LAE.computeSize());
                this.LAE.writeFields(aVar);
            }
            if (this.LAF != null) {
                aVar.ni(15, this.LAF.computeSize());
                this.LAF.writeFields(aVar);
            }
            aVar.e(16, 8, this.LAG);
            aVar.aM(17, this.privateLock);
            if (this.LAH != null) {
                aVar.e(18, this.LAH);
            }
            AppMethodBeat.o(209327);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.object);
            if (this.LAx != null) {
                nh += g.a.a.b.b.a.f(3, this.LAx);
            }
            if (this.LAy != null) {
                nh += g.a.a.a.nh(4, this.LAy.computeSize());
            }
            if (this.contact != null) {
                nh += g.a.a.a.nh(5, this.contact.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.LAz) + g.a.a.b.b.a.bu(7, this.continueFlag);
            if (this.LAA != null) {
                bu += g.a.a.a.nh(8, this.LAA.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(9, this.fans_count);
            if (this.lastBuffer != null) {
                bu2 += g.a.a.b.b.a.b(10, this.lastBuffer);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(11, this.friend_follow_count) + g.a.a.a.c(12, 1, this.LAC) + g.a.a.b.b.a.bu(13, this.LAD);
            if (this.LAE != null) {
                bu3 += g.a.a.a.nh(14, this.LAE.computeSize());
            }
            if (this.LAF != null) {
                bu3 += g.a.a.a.nh(15, this.LAF.computeSize());
            }
            int c2 = bu3 + g.a.a.a.c(16, 8, this.LAG) + g.a.a.b.b.a.bu(17, this.privateLock);
            if (this.LAH != null) {
                c2 += g.a.a.b.b.a.f(18, this.LAH);
            }
            AppMethodBeat.o(209327);
            return c2;
        } else if (i2 == 2) {
            this.object.clear();
            this.LAC.clear();
            this.LAG.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(209327);
                throw bVar2;
            }
            AppMethodBeat.o(209327);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aom aom = (aom) objArr[1];
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
                        aom.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(209327);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        FinderObject finderObject = new FinderObject();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = finderObject.populateBuilderWithField(aVar5, finderObject, dpc.getNextFieldNumber(aVar5))) {
                        }
                        aom.object.add(finderObject);
                    }
                    AppMethodBeat.o(209327);
                    return 0;
                case 3:
                    aom.LAx = aVar3.UbS.readString();
                    AppMethodBeat.o(209327);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        bdy bdy = new bdy();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = bdy.populateBuilderWithField(aVar6, bdy, dpc.getNextFieldNumber(aVar6))) {
                        }
                        aom.LAy = bdy;
                    }
                    AppMethodBeat.o(209327);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        FinderContact finderContact = new FinderContact();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = finderContact.populateBuilderWithField(aVar7, finderContact, dpc.getNextFieldNumber(aVar7))) {
                        }
                        aom.contact = finderContact;
                    }
                    AppMethodBeat.o(209327);
                    return 0;
                case 6:
                    aom.LAz = aVar3.UbS.zi();
                    AppMethodBeat.o(209327);
                    return 0;
                case 7:
                    aom.continueFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(209327);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        azn azn = new azn();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = azn.populateBuilderWithField(aVar8, azn, dpc.getNextFieldNumber(aVar8))) {
                        }
                        aom.LAA = azn;
                    }
                    AppMethodBeat.o(209327);
                    return 0;
                case 9:
                    aom.fans_count = aVar3.UbS.zi();
                    AppMethodBeat.o(209327);
                    return 0;
                case 10:
                    aom.lastBuffer = aVar3.UbS.hPo();
                    AppMethodBeat.o(209327);
                    return 0;
                case 11:
                    aom.friend_follow_count = aVar3.UbS.zi();
                    AppMethodBeat.o(209327);
                    return 0;
                case 12:
                    aom.LAC.add(aVar3.UbS.readString());
                    AppMethodBeat.o(209327);
                    return 0;
                case 13:
                    aom.LAD = aVar3.UbS.zi();
                    AppMethodBeat.o(209327);
                    return 0;
                case 14:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        cxs cxs = new cxs();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = cxs.populateBuilderWithField(aVar9, cxs, dpc.getNextFieldNumber(aVar9))) {
                        }
                        aom.LAE = cxs;
                    }
                    AppMethodBeat.o(209327);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        baw baw = new baw();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = baw.populateBuilderWithField(aVar10, baw, dpc.getNextFieldNumber(aVar10))) {
                        }
                        aom.LAF = baw;
                    }
                    AppMethodBeat.o(209327);
                    return 0;
                case 16:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        FinderObject finderObject2 = new FinderObject();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = finderObject2.populateBuilderWithField(aVar11, finderObject2, dpc.getNextFieldNumber(aVar11))) {
                        }
                        aom.LAG.add(finderObject2);
                    }
                    AppMethodBeat.o(209327);
                    return 0;
                case 17:
                    aom.privateLock = aVar3.UbS.zi();
                    AppMethodBeat.o(209327);
                    return 0;
                case 18:
                    aom.LAH = aVar3.UbS.readString();
                    AppMethodBeat.o(209327);
                    return 0;
                default:
                    AppMethodBeat.o(209327);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209327);
            return -1;
        }
    }
}
