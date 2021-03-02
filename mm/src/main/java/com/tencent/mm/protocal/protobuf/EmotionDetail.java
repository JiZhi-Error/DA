package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public class EmotionDetail extends a {
    public String ConsumeProductID;
    public String CoverUrl;
    public EmotionDesigner EmotionDesigner;
    public String IconUrl;
    public String OldRedirectUrl;
    public String PackAuthInfo;
    public String PackCopyright;
    public String PackDesc;
    public int PackExpire;
    public int PackFlag;
    public String PackName;
    public String PackPrice;
    public int PackThumbCnt;
    public LinkedList<dqi> PackThumbList = new LinkedList<>();
    public int PackType;
    public String PanelUrl;
    public PersonalDesigner PersonalDesigner;
    public String PriceNum;
    public String PriceType;
    public String ProductID;
    public String ShareDesc;
    public int ThumbExtCount;
    public LinkedList<PackThumbExt> ThumbExtList = new LinkedList<>();
    public String TimeLimitStr;
    public int Version;

    public EmotionDetail() {
        AppMethodBeat.i(104776);
        AppMethodBeat.o(104776);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104777);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.ProductID != null) {
                aVar.e(1, this.ProductID);
            }
            if (this.IconUrl != null) {
                aVar.e(2, this.IconUrl);
            }
            if (this.PackName != null) {
                aVar.e(3, this.PackName);
            }
            if (this.PackDesc != null) {
                aVar.e(4, this.PackDesc);
            }
            if (this.PackAuthInfo != null) {
                aVar.e(5, this.PackAuthInfo);
            }
            if (this.PackPrice != null) {
                aVar.e(6, this.PackPrice);
            }
            aVar.aM(7, this.PackType);
            aVar.aM(8, this.PackFlag);
            aVar.aM(9, this.PackThumbCnt);
            aVar.e(10, 8, this.PackThumbList);
            if (this.CoverUrl != null) {
                aVar.e(11, this.CoverUrl);
            }
            aVar.aM(12, this.PackExpire);
            if (this.PackCopyright != null) {
                aVar.e(13, this.PackCopyright);
            }
            if (this.PriceNum != null) {
                aVar.e(14, this.PriceNum);
            }
            if (this.PriceType != null) {
                aVar.e(15, this.PriceType);
            }
            if (this.PanelUrl != null) {
                aVar.e(16, this.PanelUrl);
            }
            if (this.ConsumeProductID != null) {
                aVar.e(17, this.ConsumeProductID);
            }
            aVar.aM(18, this.ThumbExtCount);
            aVar.e(19, 8, this.ThumbExtList);
            aVar.aM(20, this.Version);
            if (this.TimeLimitStr != null) {
                aVar.e(21, this.TimeLimitStr);
            }
            if (this.ShareDesc != null) {
                aVar.e(22, this.ShareDesc);
            }
            if (this.OldRedirectUrl != null) {
                aVar.e(23, this.OldRedirectUrl);
            }
            if (this.EmotionDesigner != null) {
                aVar.ni(24, this.EmotionDesigner.computeSize());
                this.EmotionDesigner.writeFields(aVar);
            }
            if (this.PersonalDesigner != null) {
                aVar.ni(25, this.PersonalDesigner.computeSize());
                this.PersonalDesigner.writeFields(aVar);
            }
            AppMethodBeat.o(104777);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.ProductID != null ? g.a.a.b.b.a.f(1, this.ProductID) + 0 : 0;
            if (this.IconUrl != null) {
                f2 += g.a.a.b.b.a.f(2, this.IconUrl);
            }
            if (this.PackName != null) {
                f2 += g.a.a.b.b.a.f(3, this.PackName);
            }
            if (this.PackDesc != null) {
                f2 += g.a.a.b.b.a.f(4, this.PackDesc);
            }
            if (this.PackAuthInfo != null) {
                f2 += g.a.a.b.b.a.f(5, this.PackAuthInfo);
            }
            if (this.PackPrice != null) {
                f2 += g.a.a.b.b.a.f(6, this.PackPrice);
            }
            int bu = f2 + g.a.a.b.b.a.bu(7, this.PackType) + g.a.a.b.b.a.bu(8, this.PackFlag) + g.a.a.b.b.a.bu(9, this.PackThumbCnt) + g.a.a.a.c(10, 8, this.PackThumbList);
            if (this.CoverUrl != null) {
                bu += g.a.a.b.b.a.f(11, this.CoverUrl);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(12, this.PackExpire);
            if (this.PackCopyright != null) {
                bu2 += g.a.a.b.b.a.f(13, this.PackCopyright);
            }
            if (this.PriceNum != null) {
                bu2 += g.a.a.b.b.a.f(14, this.PriceNum);
            }
            if (this.PriceType != null) {
                bu2 += g.a.a.b.b.a.f(15, this.PriceType);
            }
            if (this.PanelUrl != null) {
                bu2 += g.a.a.b.b.a.f(16, this.PanelUrl);
            }
            if (this.ConsumeProductID != null) {
                bu2 += g.a.a.b.b.a.f(17, this.ConsumeProductID);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(18, this.ThumbExtCount) + g.a.a.a.c(19, 8, this.ThumbExtList) + g.a.a.b.b.a.bu(20, this.Version);
            if (this.TimeLimitStr != null) {
                bu3 += g.a.a.b.b.a.f(21, this.TimeLimitStr);
            }
            if (this.ShareDesc != null) {
                bu3 += g.a.a.b.b.a.f(22, this.ShareDesc);
            }
            if (this.OldRedirectUrl != null) {
                bu3 += g.a.a.b.b.a.f(23, this.OldRedirectUrl);
            }
            if (this.EmotionDesigner != null) {
                bu3 += g.a.a.a.nh(24, this.EmotionDesigner.computeSize());
            }
            if (this.PersonalDesigner != null) {
                bu3 += g.a.a.a.nh(25, this.PersonalDesigner.computeSize());
            }
            AppMethodBeat.o(104777);
            return bu3;
        } else if (i2 == 2) {
            this.PackThumbList.clear();
            this.ThumbExtList.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(104777);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            EmotionDetail emotionDetail = (EmotionDetail) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    emotionDetail.ProductID = aVar3.UbS.readString();
                    AppMethodBeat.o(104777);
                    return 0;
                case 2:
                    emotionDetail.IconUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(104777);
                    return 0;
                case 3:
                    emotionDetail.PackName = aVar3.UbS.readString();
                    AppMethodBeat.o(104777);
                    return 0;
                case 4:
                    emotionDetail.PackDesc = aVar3.UbS.readString();
                    AppMethodBeat.o(104777);
                    return 0;
                case 5:
                    emotionDetail.PackAuthInfo = aVar3.UbS.readString();
                    AppMethodBeat.o(104777);
                    return 0;
                case 6:
                    emotionDetail.PackPrice = aVar3.UbS.readString();
                    AppMethodBeat.o(104777);
                    return 0;
                case 7:
                    emotionDetail.PackType = aVar3.UbS.zi();
                    AppMethodBeat.o(104777);
                    return 0;
                case 8:
                    emotionDetail.PackFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(104777);
                    return 0;
                case 9:
                    emotionDetail.PackThumbCnt = aVar3.UbS.zi();
                    AppMethodBeat.o(104777);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dqi.populateBuilderWithField(aVar4, dqi, a.getNextFieldNumber(aVar4))) {
                        }
                        emotionDetail.PackThumbList.add(dqi);
                    }
                    AppMethodBeat.o(104777);
                    return 0;
                case 11:
                    emotionDetail.CoverUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(104777);
                    return 0;
                case 12:
                    emotionDetail.PackExpire = aVar3.UbS.zi();
                    AppMethodBeat.o(104777);
                    return 0;
                case 13:
                    emotionDetail.PackCopyright = aVar3.UbS.readString();
                    AppMethodBeat.o(104777);
                    return 0;
                case 14:
                    emotionDetail.PriceNum = aVar3.UbS.readString();
                    AppMethodBeat.o(104777);
                    return 0;
                case 15:
                    emotionDetail.PriceType = aVar3.UbS.readString();
                    AppMethodBeat.o(104777);
                    return 0;
                case 16:
                    emotionDetail.PanelUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(104777);
                    return 0;
                case 17:
                    emotionDetail.ConsumeProductID = aVar3.UbS.readString();
                    AppMethodBeat.o(104777);
                    return 0;
                case 18:
                    emotionDetail.ThumbExtCount = aVar3.UbS.zi();
                    AppMethodBeat.o(104777);
                    return 0;
                case 19:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        PackThumbExt packThumbExt = new PackThumbExt();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = packThumbExt.populateBuilderWithField(aVar5, packThumbExt, a.getNextFieldNumber(aVar5))) {
                        }
                        emotionDetail.ThumbExtList.add(packThumbExt);
                    }
                    AppMethodBeat.o(104777);
                    return 0;
                case 20:
                    emotionDetail.Version = aVar3.UbS.zi();
                    AppMethodBeat.o(104777);
                    return 0;
                case 21:
                    emotionDetail.TimeLimitStr = aVar3.UbS.readString();
                    AppMethodBeat.o(104777);
                    return 0;
                case 22:
                    emotionDetail.ShareDesc = aVar3.UbS.readString();
                    AppMethodBeat.o(104777);
                    return 0;
                case 23:
                    emotionDetail.OldRedirectUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(104777);
                    return 0;
                case 24:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        EmotionDesigner emotionDesigner = new EmotionDesigner();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = emotionDesigner.populateBuilderWithField(aVar6, emotionDesigner, a.getNextFieldNumber(aVar6))) {
                        }
                        emotionDetail.EmotionDesigner = emotionDesigner;
                    }
                    AppMethodBeat.o(104777);
                    return 0;
                case 25:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        PersonalDesigner personalDesigner = new PersonalDesigner();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = personalDesigner.populateBuilderWithField(aVar7, personalDesigner, a.getNextFieldNumber(aVar7))) {
                        }
                        emotionDetail.PersonalDesigner = personalDesigner;
                    }
                    AppMethodBeat.o(104777);
                    return 0;
                default:
                    AppMethodBeat.o(104777);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104777);
            return -1;
        }
    }
}
