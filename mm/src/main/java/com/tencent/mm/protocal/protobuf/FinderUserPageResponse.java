package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public class FinderUserPageResponse extends dpc {
    public aoy biz_info;
    public FinderContact contact;
    public int continueFlag;
    public cxs entranceInfo;
    public LinkedList<aqk> eventInfoList = new LinkedList<>();
    public int fansCount;
    public int feedsCount;
    public String firstPageMD5;
    public int friendFollowCount;
    public b lastBuffer;
    public awt liveNoticeInfo;
    public LinkedList<FinderObject> liveObjects = new LinkedList<>();
    public LinkedList<FinderObject> object = new LinkedList<>();
    public int originalEntranceFlag;
    public baw preloadInfo;
    public int privateLock;
    public LinkedList<String> userTags = new LinkedList<>();
    public LinkedList<bds> usualTopics = new LinkedList<>();
    public azn verifyInfo;
    public bel wxaShopInfo;

    public FinderUserPageResponse() {
        AppMethodBeat.i(169071);
        AppMethodBeat.o(169071);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169072);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(169072);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.object);
            if (this.firstPageMD5 != null) {
                aVar.e(3, this.firstPageMD5);
            }
            if (this.contact != null) {
                aVar.ni(5, this.contact.computeSize());
                this.contact.writeFields(aVar);
            }
            aVar.aM(6, this.feedsCount);
            aVar.aM(7, this.continueFlag);
            if (this.verifyInfo != null) {
                aVar.ni(8, this.verifyInfo.computeSize());
                this.verifyInfo.writeFields(aVar);
            }
            aVar.aM(9, this.fansCount);
            if (this.lastBuffer != null) {
                aVar.c(10, this.lastBuffer);
            }
            aVar.aM(11, this.friendFollowCount);
            aVar.e(12, 1, this.userTags);
            aVar.aM(13, this.originalEntranceFlag);
            if (this.entranceInfo != null) {
                aVar.ni(14, this.entranceInfo.computeSize());
                this.entranceInfo.writeFields(aVar);
            }
            if (this.preloadInfo != null) {
                aVar.ni(15, this.preloadInfo.computeSize());
                this.preloadInfo.writeFields(aVar);
            }
            aVar.e(16, 8, this.liveObjects);
            aVar.aM(17, this.privateLock);
            if (this.wxaShopInfo != null) {
                aVar.ni(18, this.wxaShopInfo.computeSize());
                this.wxaShopInfo.writeFields(aVar);
            }
            if (this.liveNoticeInfo != null) {
                aVar.ni(19, this.liveNoticeInfo.computeSize());
                this.liveNoticeInfo.writeFields(aVar);
            }
            aVar.e(20, 8, this.usualTopics);
            if (this.biz_info != null) {
                aVar.ni(27, this.biz_info.computeSize());
                this.biz_info.writeFields(aVar);
            }
            aVar.e(28, 8, this.eventInfoList);
            AppMethodBeat.o(169072);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.object);
            if (this.firstPageMD5 != null) {
                nh += g.a.a.b.b.a.f(3, this.firstPageMD5);
            }
            if (this.contact != null) {
                nh += g.a.a.a.nh(5, this.contact.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.feedsCount) + g.a.a.b.b.a.bu(7, this.continueFlag);
            if (this.verifyInfo != null) {
                bu += g.a.a.a.nh(8, this.verifyInfo.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(9, this.fansCount);
            if (this.lastBuffer != null) {
                bu2 += g.a.a.b.b.a.b(10, this.lastBuffer);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(11, this.friendFollowCount) + g.a.a.a.c(12, 1, this.userTags) + g.a.a.b.b.a.bu(13, this.originalEntranceFlag);
            if (this.entranceInfo != null) {
                bu3 += g.a.a.a.nh(14, this.entranceInfo.computeSize());
            }
            if (this.preloadInfo != null) {
                bu3 += g.a.a.a.nh(15, this.preloadInfo.computeSize());
            }
            int c2 = bu3 + g.a.a.a.c(16, 8, this.liveObjects) + g.a.a.b.b.a.bu(17, this.privateLock);
            if (this.wxaShopInfo != null) {
                c2 += g.a.a.a.nh(18, this.wxaShopInfo.computeSize());
            }
            if (this.liveNoticeInfo != null) {
                c2 += g.a.a.a.nh(19, this.liveNoticeInfo.computeSize());
            }
            int c3 = c2 + g.a.a.a.c(20, 8, this.usualTopics);
            if (this.biz_info != null) {
                c3 += g.a.a.a.nh(27, this.biz_info.computeSize());
            }
            int c4 = c3 + g.a.a.a.c(28, 8, this.eventInfoList);
            AppMethodBeat.o(169072);
            return c4;
        } else if (i2 == 2) {
            this.object.clear();
            this.userTags.clear();
            this.liveObjects.clear();
            this.usualTopics.clear();
            this.eventInfoList.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(169072);
                throw bVar2;
            }
            AppMethodBeat.o(169072);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            FinderUserPageResponse finderUserPageResponse = (FinderUserPageResponse) objArr[1];
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
                        finderUserPageResponse.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(169072);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        FinderObject finderObject = new FinderObject();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = finderObject.populateBuilderWithField(aVar5, finderObject, dpc.getNextFieldNumber(aVar5))) {
                        }
                        finderUserPageResponse.object.add(finderObject);
                    }
                    AppMethodBeat.o(169072);
                    return 0;
                case 3:
                    finderUserPageResponse.firstPageMD5 = aVar3.UbS.readString();
                    AppMethodBeat.o(169072);
                    return 0;
                case 4:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                default:
                    AppMethodBeat.o(169072);
                    return -1;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        FinderContact finderContact = new FinderContact();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = finderContact.populateBuilderWithField(aVar6, finderContact, dpc.getNextFieldNumber(aVar6))) {
                        }
                        finderUserPageResponse.contact = finderContact;
                    }
                    AppMethodBeat.o(169072);
                    return 0;
                case 6:
                    finderUserPageResponse.feedsCount = aVar3.UbS.zi();
                    AppMethodBeat.o(169072);
                    return 0;
                case 7:
                    finderUserPageResponse.continueFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(169072);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        azn azn = new azn();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = azn.populateBuilderWithField(aVar7, azn, dpc.getNextFieldNumber(aVar7))) {
                        }
                        finderUserPageResponse.verifyInfo = azn;
                    }
                    AppMethodBeat.o(169072);
                    return 0;
                case 9:
                    finderUserPageResponse.fansCount = aVar3.UbS.zi();
                    AppMethodBeat.o(169072);
                    return 0;
                case 10:
                    finderUserPageResponse.lastBuffer = aVar3.UbS.hPo();
                    AppMethodBeat.o(169072);
                    return 0;
                case 11:
                    finderUserPageResponse.friendFollowCount = aVar3.UbS.zi();
                    AppMethodBeat.o(169072);
                    return 0;
                case 12:
                    finderUserPageResponse.userTags.add(aVar3.UbS.readString());
                    AppMethodBeat.o(169072);
                    return 0;
                case 13:
                    finderUserPageResponse.originalEntranceFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(169072);
                    return 0;
                case 14:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        cxs cxs = new cxs();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = cxs.populateBuilderWithField(aVar8, cxs, dpc.getNextFieldNumber(aVar8))) {
                        }
                        finderUserPageResponse.entranceInfo = cxs;
                    }
                    AppMethodBeat.o(169072);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        baw baw = new baw();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = baw.populateBuilderWithField(aVar9, baw, dpc.getNextFieldNumber(aVar9))) {
                        }
                        finderUserPageResponse.preloadInfo = baw;
                    }
                    AppMethodBeat.o(169072);
                    return 0;
                case 16:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        FinderObject finderObject2 = new FinderObject();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = finderObject2.populateBuilderWithField(aVar10, finderObject2, dpc.getNextFieldNumber(aVar10))) {
                        }
                        finderUserPageResponse.liveObjects.add(finderObject2);
                    }
                    AppMethodBeat.o(169072);
                    return 0;
                case 17:
                    finderUserPageResponse.privateLock = aVar3.UbS.zi();
                    AppMethodBeat.o(169072);
                    return 0;
                case 18:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        bel bel = new bel();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = bel.populateBuilderWithField(aVar11, bel, dpc.getNextFieldNumber(aVar11))) {
                        }
                        finderUserPageResponse.wxaShopInfo = bel;
                    }
                    AppMethodBeat.o(169072);
                    return 0;
                case 19:
                    LinkedList<byte[]> awh9 = aVar3.awh(intValue);
                    int size9 = awh9.size();
                    for (int i11 = 0; i11 < size9; i11++) {
                        awt awt = new awt();
                        g.a.a.a.a aVar12 = new g.a.a.a.a(awh9.get(i11), unknownTagHandler);
                        for (boolean z9 = true; z9; z9 = awt.populateBuilderWithField(aVar12, awt, dpc.getNextFieldNumber(aVar12))) {
                        }
                        finderUserPageResponse.liveNoticeInfo = awt;
                    }
                    AppMethodBeat.o(169072);
                    return 0;
                case 20:
                    LinkedList<byte[]> awh10 = aVar3.awh(intValue);
                    int size10 = awh10.size();
                    for (int i12 = 0; i12 < size10; i12++) {
                        bds bds = new bds();
                        g.a.a.a.a aVar13 = new g.a.a.a.a(awh10.get(i12), unknownTagHandler);
                        for (boolean z10 = true; z10; z10 = bds.populateBuilderWithField(aVar13, bds, dpc.getNextFieldNumber(aVar13))) {
                        }
                        finderUserPageResponse.usualTopics.add(bds);
                    }
                    AppMethodBeat.o(169072);
                    return 0;
                case 27:
                    LinkedList<byte[]> awh11 = aVar3.awh(intValue);
                    int size11 = awh11.size();
                    for (int i13 = 0; i13 < size11; i13++) {
                        aoy aoy = new aoy();
                        g.a.a.a.a aVar14 = new g.a.a.a.a(awh11.get(i13), unknownTagHandler);
                        for (boolean z11 = true; z11; z11 = aoy.populateBuilderWithField(aVar14, aoy, dpc.getNextFieldNumber(aVar14))) {
                        }
                        finderUserPageResponse.biz_info = aoy;
                    }
                    AppMethodBeat.o(169072);
                    return 0;
                case 28:
                    LinkedList<byte[]> awh12 = aVar3.awh(intValue);
                    int size12 = awh12.size();
                    for (int i14 = 0; i14 < size12; i14++) {
                        aqk aqk = new aqk();
                        g.a.a.a.a aVar15 = new g.a.a.a.a(awh12.get(i14), unknownTagHandler);
                        for (boolean z12 = true; z12; z12 = aqk.populateBuilderWithField(aVar15, aqk, dpc.getNextFieldNumber(aVar15))) {
                        }
                        finderUserPageResponse.eventInfoList.add(aqk);
                    }
                    AppMethodBeat.o(169072);
                    return 0;
            }
        } else {
            AppMethodBeat.o(169072);
            return -1;
        }
    }
}
