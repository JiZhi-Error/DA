package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public class TimeLineObject extends a {
    public fa AppInfo;
    public String ContentDesc;
    public adp ContentObj;
    public int CreateTime;
    public String Id;
    public cjy Location;
    public int Privated;
    public String UserName;
    public be actionInfo;
    public String canvasInfo;
    public int contentDescScene;
    public int contentDescShowType;
    public int contentattr;
    public cio liteappInfo;
    public String publicUserName;
    public int showFlag;
    public int sightFolded;
    public String sourceNickName;
    public String sourceUserName;
    public String statExtStr;
    public String statisticsData;
    public eep streamvideo;
    public eyd weappInfo;
    public fat webSearchInfo;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125847);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Id != null) {
                aVar.e(1, this.Id);
            }
            if (this.UserName != null) {
                aVar.e(2, this.UserName);
            }
            aVar.aM(3, this.Privated);
            aVar.aM(4, this.CreateTime);
            if (this.ContentDesc != null) {
                aVar.e(5, this.ContentDesc);
            }
            if (this.Location != null) {
                aVar.ni(6, this.Location.computeSize());
                this.Location.writeFields(aVar);
            }
            if (this.AppInfo != null) {
                aVar.ni(7, this.AppInfo.computeSize());
                this.AppInfo.writeFields(aVar);
            }
            if (this.ContentObj != null) {
                aVar.ni(8, this.ContentObj.computeSize());
                this.ContentObj.writeFields(aVar);
            }
            if (this.sourceUserName != null) {
                aVar.e(9, this.sourceUserName);
            }
            if (this.sourceNickName != null) {
                aVar.e(10, this.sourceNickName);
            }
            if (this.publicUserName != null) {
                aVar.e(11, this.publicUserName);
            }
            aVar.aM(12, this.contentDescShowType);
            aVar.aM(13, this.contentDescScene);
            if (this.statisticsData != null) {
                aVar.e(14, this.statisticsData);
            }
            if (this.actionInfo != null) {
                aVar.ni(15, this.actionInfo.computeSize());
                this.actionInfo.writeFields(aVar);
            }
            aVar.aM(16, this.contentattr);
            if (this.streamvideo != null) {
                aVar.ni(17, this.streamvideo.computeSize());
                this.streamvideo.writeFields(aVar);
            }
            if (this.statExtStr != null) {
                aVar.e(18, this.statExtStr);
            }
            if (this.canvasInfo != null) {
                aVar.e(19, this.canvasInfo);
            }
            if (this.weappInfo != null) {
                aVar.ni(20, this.weappInfo.computeSize());
                this.weappInfo.writeFields(aVar);
            }
            aVar.aM(21, this.sightFolded);
            if (this.webSearchInfo != null) {
                aVar.ni(22, this.webSearchInfo.computeSize());
                this.webSearchInfo.writeFields(aVar);
            }
            aVar.aM(23, this.showFlag);
            if (this.liteappInfo != null) {
                aVar.ni(24, this.liteappInfo.computeSize());
                this.liteappInfo.writeFields(aVar);
            }
            AppMethodBeat.o(125847);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Id != null ? g.a.a.b.b.a.f(1, this.Id) + 0 : 0;
            if (this.UserName != null) {
                f2 += g.a.a.b.b.a.f(2, this.UserName);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.Privated) + g.a.a.b.b.a.bu(4, this.CreateTime);
            if (this.ContentDesc != null) {
                bu += g.a.a.b.b.a.f(5, this.ContentDesc);
            }
            if (this.Location != null) {
                bu += g.a.a.a.nh(6, this.Location.computeSize());
            }
            if (this.AppInfo != null) {
                bu += g.a.a.a.nh(7, this.AppInfo.computeSize());
            }
            if (this.ContentObj != null) {
                bu += g.a.a.a.nh(8, this.ContentObj.computeSize());
            }
            if (this.sourceUserName != null) {
                bu += g.a.a.b.b.a.f(9, this.sourceUserName);
            }
            if (this.sourceNickName != null) {
                bu += g.a.a.b.b.a.f(10, this.sourceNickName);
            }
            if (this.publicUserName != null) {
                bu += g.a.a.b.b.a.f(11, this.publicUserName);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(12, this.contentDescShowType) + g.a.a.b.b.a.bu(13, this.contentDescScene);
            if (this.statisticsData != null) {
                bu2 += g.a.a.b.b.a.f(14, this.statisticsData);
            }
            if (this.actionInfo != null) {
                bu2 += g.a.a.a.nh(15, this.actionInfo.computeSize());
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(16, this.contentattr);
            if (this.streamvideo != null) {
                bu3 += g.a.a.a.nh(17, this.streamvideo.computeSize());
            }
            if (this.statExtStr != null) {
                bu3 += g.a.a.b.b.a.f(18, this.statExtStr);
            }
            if (this.canvasInfo != null) {
                bu3 += g.a.a.b.b.a.f(19, this.canvasInfo);
            }
            if (this.weappInfo != null) {
                bu3 += g.a.a.a.nh(20, this.weappInfo.computeSize());
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(21, this.sightFolded);
            if (this.webSearchInfo != null) {
                bu4 += g.a.a.a.nh(22, this.webSearchInfo.computeSize());
            }
            int bu5 = bu4 + g.a.a.b.b.a.bu(23, this.showFlag);
            if (this.liteappInfo != null) {
                bu5 += g.a.a.a.nh(24, this.liteappInfo.computeSize());
            }
            AppMethodBeat.o(125847);
            return bu5;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125847);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            TimeLineObject timeLineObject = (TimeLineObject) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    timeLineObject.Id = aVar3.UbS.readString();
                    AppMethodBeat.o(125847);
                    return 0;
                case 2:
                    timeLineObject.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(125847);
                    return 0;
                case 3:
                    timeLineObject.Privated = aVar3.UbS.zi();
                    AppMethodBeat.o(125847);
                    return 0;
                case 4:
                    timeLineObject.CreateTime = aVar3.UbS.zi();
                    AppMethodBeat.o(125847);
                    return 0;
                case 5:
                    timeLineObject.ContentDesc = aVar3.UbS.readString();
                    AppMethodBeat.o(125847);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cjy cjy = new cjy();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cjy.populateBuilderWithField(aVar4, cjy, a.getNextFieldNumber(aVar4))) {
                        }
                        timeLineObject.Location = cjy;
                    }
                    AppMethodBeat.o(125847);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        fa faVar = new fa();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = faVar.populateBuilderWithField(aVar5, faVar, a.getNextFieldNumber(aVar5))) {
                        }
                        timeLineObject.AppInfo = faVar;
                    }
                    AppMethodBeat.o(125847);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        adp adp = new adp();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = adp.populateBuilderWithField(aVar6, adp, a.getNextFieldNumber(aVar6))) {
                        }
                        timeLineObject.ContentObj = adp;
                    }
                    AppMethodBeat.o(125847);
                    return 0;
                case 9:
                    timeLineObject.sourceUserName = aVar3.UbS.readString();
                    AppMethodBeat.o(125847);
                    return 0;
                case 10:
                    timeLineObject.sourceNickName = aVar3.UbS.readString();
                    AppMethodBeat.o(125847);
                    return 0;
                case 11:
                    timeLineObject.publicUserName = aVar3.UbS.readString();
                    AppMethodBeat.o(125847);
                    return 0;
                case 12:
                    timeLineObject.contentDescShowType = aVar3.UbS.zi();
                    AppMethodBeat.o(125847);
                    return 0;
                case 13:
                    timeLineObject.contentDescScene = aVar3.UbS.zi();
                    AppMethodBeat.o(125847);
                    return 0;
                case 14:
                    timeLineObject.statisticsData = aVar3.UbS.readString();
                    AppMethodBeat.o(125847);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        be beVar = new be();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = beVar.populateBuilderWithField(aVar7, beVar, a.getNextFieldNumber(aVar7))) {
                        }
                        timeLineObject.actionInfo = beVar;
                    }
                    AppMethodBeat.o(125847);
                    return 0;
                case 16:
                    timeLineObject.contentattr = aVar3.UbS.zi();
                    AppMethodBeat.o(125847);
                    return 0;
                case 17:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        eep eep = new eep();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = eep.populateBuilderWithField(aVar8, eep, a.getNextFieldNumber(aVar8))) {
                        }
                        timeLineObject.streamvideo = eep;
                    }
                    AppMethodBeat.o(125847);
                    return 0;
                case 18:
                    timeLineObject.statExtStr = aVar3.UbS.readString();
                    AppMethodBeat.o(125847);
                    return 0;
                case 19:
                    timeLineObject.canvasInfo = aVar3.UbS.readString();
                    AppMethodBeat.o(125847);
                    return 0;
                case 20:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        eyd eyd = new eyd();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = eyd.populateBuilderWithField(aVar9, eyd, a.getNextFieldNumber(aVar9))) {
                        }
                        timeLineObject.weappInfo = eyd;
                    }
                    AppMethodBeat.o(125847);
                    return 0;
                case 21:
                    timeLineObject.sightFolded = aVar3.UbS.zi();
                    AppMethodBeat.o(125847);
                    return 0;
                case 22:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        fat fat = new fat();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = fat.populateBuilderWithField(aVar10, fat, a.getNextFieldNumber(aVar10))) {
                        }
                        timeLineObject.webSearchInfo = fat;
                    }
                    AppMethodBeat.o(125847);
                    return 0;
                case 23:
                    timeLineObject.showFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(125847);
                    return 0;
                case 24:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        cio cio = new cio();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = cio.populateBuilderWithField(aVar11, cio, a.getNextFieldNumber(aVar11))) {
                        }
                        timeLineObject.liteappInfo = cio;
                    }
                    AppMethodBeat.o(125847);
                    return 0;
                default:
                    AppMethodBeat.o(125847);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125847);
            return -1;
        }
    }
}
