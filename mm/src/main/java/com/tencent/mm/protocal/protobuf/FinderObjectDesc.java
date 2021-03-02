package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public class FinderObjectDesc extends a {
    public String description;
    public long draftObjectId;
    public azs event;
    public aqp extReading;
    public azr feedBgmInfo;
    public axt feed_location;
    public arm fromApp;
    public azk imgFeedBgmInfo;
    public avq liveDesc;
    public axt location;
    public axu longVideoDesc;
    public LinkedList<FinderMedia> media = new LinkedList<>();
    public FinderMediaExtra mediaExtra;
    public int mediaType;
    public LinkedList<ayp> mentionedMusics = new LinkedList<>();
    public LinkedList<ayq> mentionedUser = new LinkedList<>();
    public axw mvInfo;
    public bdl tmpl_info;
    public bdq topic;

    public FinderObjectDesc() {
        AppMethodBeat.i(169023);
        AppMethodBeat.o(169023);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169024);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.description != null) {
                aVar.e(1, this.description);
            }
            aVar.e(2, 8, this.media);
            aVar.aM(3, this.mediaType);
            if (this.mediaExtra != null) {
                aVar.ni(4, this.mediaExtra.computeSize());
                this.mediaExtra.writeFields(aVar);
            }
            if (this.location != null) {
                aVar.ni(5, this.location.computeSize());
                this.location.writeFields(aVar);
            }
            if (this.extReading != null) {
                aVar.ni(6, this.extReading.computeSize());
                this.extReading.writeFields(aVar);
            }
            if (this.topic != null) {
                aVar.ni(7, this.topic.computeSize());
                this.topic.writeFields(aVar);
            }
            aVar.e(8, 8, this.mentionedUser);
            if (this.liveDesc != null) {
                aVar.ni(9, this.liveDesc.computeSize());
                this.liveDesc.writeFields(aVar);
            }
            if (this.feed_location != null) {
                aVar.ni(10, this.feed_location.computeSize());
                this.feed_location.writeFields(aVar);
            }
            aVar.e(11, 8, this.mentionedMusics);
            if (this.longVideoDesc != null) {
                aVar.ni(12, this.longVideoDesc.computeSize());
                this.longVideoDesc.writeFields(aVar);
            }
            if (this.imgFeedBgmInfo != null) {
                aVar.ni(13, this.imgFeedBgmInfo.computeSize());
                this.imgFeedBgmInfo.writeFields(aVar);
            }
            if (this.feedBgmInfo != null) {
                aVar.ni(14, this.feedBgmInfo.computeSize());
                this.feedBgmInfo.writeFields(aVar);
            }
            if (this.fromApp != null) {
                aVar.ni(15, this.fromApp.computeSize());
                this.fromApp.writeFields(aVar);
            }
            if (this.tmpl_info != null) {
                aVar.ni(16, this.tmpl_info.computeSize());
                this.tmpl_info.writeFields(aVar);
            }
            if (this.event != null) {
                aVar.ni(17, this.event.computeSize());
                this.event.writeFields(aVar);
            }
            if (this.mvInfo != null) {
                aVar.ni(18, this.mvInfo.computeSize());
                this.mvInfo.writeFields(aVar);
            }
            aVar.bb(19, this.draftObjectId);
            AppMethodBeat.o(169024);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.description != null ? g.a.a.b.b.a.f(1, this.description) + 0 : 0) + g.a.a.a.c(2, 8, this.media) + g.a.a.b.b.a.bu(3, this.mediaType);
            if (this.mediaExtra != null) {
                f2 += g.a.a.a.nh(4, this.mediaExtra.computeSize());
            }
            if (this.location != null) {
                f2 += g.a.a.a.nh(5, this.location.computeSize());
            }
            if (this.extReading != null) {
                f2 += g.a.a.a.nh(6, this.extReading.computeSize());
            }
            if (this.topic != null) {
                f2 += g.a.a.a.nh(7, this.topic.computeSize());
            }
            int c2 = f2 + g.a.a.a.c(8, 8, this.mentionedUser);
            if (this.liveDesc != null) {
                c2 += g.a.a.a.nh(9, this.liveDesc.computeSize());
            }
            if (this.feed_location != null) {
                c2 += g.a.a.a.nh(10, this.feed_location.computeSize());
            }
            int c3 = c2 + g.a.a.a.c(11, 8, this.mentionedMusics);
            if (this.longVideoDesc != null) {
                c3 += g.a.a.a.nh(12, this.longVideoDesc.computeSize());
            }
            if (this.imgFeedBgmInfo != null) {
                c3 += g.a.a.a.nh(13, this.imgFeedBgmInfo.computeSize());
            }
            if (this.feedBgmInfo != null) {
                c3 += g.a.a.a.nh(14, this.feedBgmInfo.computeSize());
            }
            if (this.fromApp != null) {
                c3 += g.a.a.a.nh(15, this.fromApp.computeSize());
            }
            if (this.tmpl_info != null) {
                c3 += g.a.a.a.nh(16, this.tmpl_info.computeSize());
            }
            if (this.event != null) {
                c3 += g.a.a.a.nh(17, this.event.computeSize());
            }
            if (this.mvInfo != null) {
                c3 += g.a.a.a.nh(18, this.mvInfo.computeSize());
            }
            int r = c3 + g.a.a.b.b.a.r(19, this.draftObjectId);
            AppMethodBeat.o(169024);
            return r;
        } else if (i2 == 2) {
            this.media.clear();
            this.mentionedUser.clear();
            this.mentionedMusics.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(169024);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            FinderObjectDesc finderObjectDesc = (FinderObjectDesc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    finderObjectDesc.description = aVar3.UbS.readString();
                    AppMethodBeat.o(169024);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        FinderMedia finderMedia = new FinderMedia();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = finderMedia.populateBuilderWithField(aVar4, finderMedia, a.getNextFieldNumber(aVar4))) {
                        }
                        finderObjectDesc.media.add(finderMedia);
                    }
                    AppMethodBeat.o(169024);
                    return 0;
                case 3:
                    finderObjectDesc.mediaType = aVar3.UbS.zi();
                    AppMethodBeat.o(169024);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        FinderMediaExtra finderMediaExtra = new FinderMediaExtra();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = finderMediaExtra.populateBuilderWithField(aVar5, finderMediaExtra, a.getNextFieldNumber(aVar5))) {
                        }
                        finderObjectDesc.mediaExtra = finderMediaExtra;
                    }
                    AppMethodBeat.o(169024);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        axt axt = new axt();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = axt.populateBuilderWithField(aVar6, axt, a.getNextFieldNumber(aVar6))) {
                        }
                        finderObjectDesc.location = axt;
                    }
                    AppMethodBeat.o(169024);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        aqp aqp = new aqp();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = aqp.populateBuilderWithField(aVar7, aqp, a.getNextFieldNumber(aVar7))) {
                        }
                        finderObjectDesc.extReading = aqp;
                    }
                    AppMethodBeat.o(169024);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        bdq bdq = new bdq();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = bdq.populateBuilderWithField(aVar8, bdq, a.getNextFieldNumber(aVar8))) {
                        }
                        finderObjectDesc.topic = bdq;
                    }
                    AppMethodBeat.o(169024);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        ayq ayq = new ayq();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = ayq.populateBuilderWithField(aVar9, ayq, a.getNextFieldNumber(aVar9))) {
                        }
                        finderObjectDesc.mentionedUser.add(ayq);
                    }
                    AppMethodBeat.o(169024);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        avq avq = new avq();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = avq.populateBuilderWithField(aVar10, avq, a.getNextFieldNumber(aVar10))) {
                        }
                        finderObjectDesc.liveDesc = avq;
                    }
                    AppMethodBeat.o(169024);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        axt axt2 = new axt();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = axt2.populateBuilderWithField(aVar11, axt2, a.getNextFieldNumber(aVar11))) {
                        }
                        finderObjectDesc.feed_location = axt2;
                    }
                    AppMethodBeat.o(169024);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh9 = aVar3.awh(intValue);
                    int size9 = awh9.size();
                    for (int i11 = 0; i11 < size9; i11++) {
                        ayp ayp = new ayp();
                        g.a.a.a.a aVar12 = new g.a.a.a.a(awh9.get(i11), unknownTagHandler);
                        for (boolean z9 = true; z9; z9 = ayp.populateBuilderWithField(aVar12, ayp, a.getNextFieldNumber(aVar12))) {
                        }
                        finderObjectDesc.mentionedMusics.add(ayp);
                    }
                    AppMethodBeat.o(169024);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh10 = aVar3.awh(intValue);
                    int size10 = awh10.size();
                    for (int i12 = 0; i12 < size10; i12++) {
                        axu axu = new axu();
                        g.a.a.a.a aVar13 = new g.a.a.a.a(awh10.get(i12), unknownTagHandler);
                        for (boolean z10 = true; z10; z10 = axu.populateBuilderWithField(aVar13, axu, a.getNextFieldNumber(aVar13))) {
                        }
                        finderObjectDesc.longVideoDesc = axu;
                    }
                    AppMethodBeat.o(169024);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh11 = aVar3.awh(intValue);
                    int size11 = awh11.size();
                    for (int i13 = 0; i13 < size11; i13++) {
                        azk azk = new azk();
                        g.a.a.a.a aVar14 = new g.a.a.a.a(awh11.get(i13), unknownTagHandler);
                        for (boolean z11 = true; z11; z11 = azk.populateBuilderWithField(aVar14, azk, a.getNextFieldNumber(aVar14))) {
                        }
                        finderObjectDesc.imgFeedBgmInfo = azk;
                    }
                    AppMethodBeat.o(169024);
                    return 0;
                case 14:
                    LinkedList<byte[]> awh12 = aVar3.awh(intValue);
                    int size12 = awh12.size();
                    for (int i14 = 0; i14 < size12; i14++) {
                        azr azr = new azr();
                        g.a.a.a.a aVar15 = new g.a.a.a.a(awh12.get(i14), unknownTagHandler);
                        for (boolean z12 = true; z12; z12 = azr.populateBuilderWithField(aVar15, azr, a.getNextFieldNumber(aVar15))) {
                        }
                        finderObjectDesc.feedBgmInfo = azr;
                    }
                    AppMethodBeat.o(169024);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh13 = aVar3.awh(intValue);
                    int size13 = awh13.size();
                    for (int i15 = 0; i15 < size13; i15++) {
                        arm arm = new arm();
                        g.a.a.a.a aVar16 = new g.a.a.a.a(awh13.get(i15), unknownTagHandler);
                        for (boolean z13 = true; z13; z13 = arm.populateBuilderWithField(aVar16, arm, a.getNextFieldNumber(aVar16))) {
                        }
                        finderObjectDesc.fromApp = arm;
                    }
                    AppMethodBeat.o(169024);
                    return 0;
                case 16:
                    LinkedList<byte[]> awh14 = aVar3.awh(intValue);
                    int size14 = awh14.size();
                    for (int i16 = 0; i16 < size14; i16++) {
                        bdl bdl = new bdl();
                        g.a.a.a.a aVar17 = new g.a.a.a.a(awh14.get(i16), unknownTagHandler);
                        for (boolean z14 = true; z14; z14 = bdl.populateBuilderWithField(aVar17, bdl, a.getNextFieldNumber(aVar17))) {
                        }
                        finderObjectDesc.tmpl_info = bdl;
                    }
                    AppMethodBeat.o(169024);
                    return 0;
                case 17:
                    LinkedList<byte[]> awh15 = aVar3.awh(intValue);
                    int size15 = awh15.size();
                    for (int i17 = 0; i17 < size15; i17++) {
                        azs azs = new azs();
                        g.a.a.a.a aVar18 = new g.a.a.a.a(awh15.get(i17), unknownTagHandler);
                        for (boolean z15 = true; z15; z15 = azs.populateBuilderWithField(aVar18, azs, a.getNextFieldNumber(aVar18))) {
                        }
                        finderObjectDesc.event = azs;
                    }
                    AppMethodBeat.o(169024);
                    return 0;
                case 18:
                    LinkedList<byte[]> awh16 = aVar3.awh(intValue);
                    int size16 = awh16.size();
                    for (int i18 = 0; i18 < size16; i18++) {
                        axw axw = new axw();
                        g.a.a.a.a aVar19 = new g.a.a.a.a(awh16.get(i18), unknownTagHandler);
                        for (boolean z16 = true; z16; z16 = axw.populateBuilderWithField(aVar19, axw, a.getNextFieldNumber(aVar19))) {
                        }
                        finderObjectDesc.mvInfo = axw;
                    }
                    AppMethodBeat.o(169024);
                    return 0;
                case 19:
                    finderObjectDesc.draftObjectId = aVar3.UbS.zl();
                    AppMethodBeat.o(169024);
                    return 0;
                default:
                    AppMethodBeat.o(169024);
                    return -1;
            }
        } else {
            AppMethodBeat.o(169024);
            return -1;
        }
    }
}
