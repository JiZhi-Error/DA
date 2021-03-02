package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public class EmotionBannerSet extends a {
    public EmotionBannerImg BannerImg;
    public String Desc;
    public int ID;
    public String IconUrl;
    public String LocateUrl;
    public String ProductID;
    public String SecondUrl;
    public int SetType;
    public String TagUrl;
    public String Title;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104770);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.BannerImg == null) {
                b bVar = new b("Not all required fields were included: BannerImg");
                AppMethodBeat.o(104770);
                throw bVar;
            }
            if (this.BannerImg != null) {
                aVar.ni(1, this.BannerImg.computeSize());
                this.BannerImg.writeFields(aVar);
            }
            if (this.Title != null) {
                aVar.e(2, this.Title);
            }
            if (this.LocateUrl != null) {
                aVar.e(3, this.LocateUrl);
            }
            aVar.aM(4, this.ID);
            if (this.SecondUrl != null) {
                aVar.e(5, this.SecondUrl);
            }
            aVar.aM(6, this.SetType);
            if (this.IconUrl != null) {
                aVar.e(7, this.IconUrl);
            }
            if (this.Desc != null) {
                aVar.e(8, this.Desc);
            }
            if (this.ProductID != null) {
                aVar.e(9, this.ProductID);
            }
            if (this.TagUrl != null) {
                aVar.e(10, this.TagUrl);
            }
            AppMethodBeat.o(104770);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BannerImg != null ? g.a.a.a.nh(1, this.BannerImg.computeSize()) + 0 : 0;
            if (this.Title != null) {
                nh += g.a.a.b.b.a.f(2, this.Title);
            }
            if (this.LocateUrl != null) {
                nh += g.a.a.b.b.a.f(3, this.LocateUrl);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.ID);
            if (this.SecondUrl != null) {
                bu += g.a.a.b.b.a.f(5, this.SecondUrl);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.SetType);
            if (this.IconUrl != null) {
                bu2 += g.a.a.b.b.a.f(7, this.IconUrl);
            }
            if (this.Desc != null) {
                bu2 += g.a.a.b.b.a.f(8, this.Desc);
            }
            if (this.ProductID != null) {
                bu2 += g.a.a.b.b.a.f(9, this.ProductID);
            }
            if (this.TagUrl != null) {
                bu2 += g.a.a.b.b.a.f(10, this.TagUrl);
            }
            AppMethodBeat.o(104770);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BannerImg == null) {
                b bVar2 = new b("Not all required fields were included: BannerImg");
                AppMethodBeat.o(104770);
                throw bVar2;
            }
            AppMethodBeat.o(104770);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            EmotionBannerSet emotionBannerSet = (EmotionBannerSet) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        EmotionBannerImg emotionBannerImg = new EmotionBannerImg();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = emotionBannerImg.populateBuilderWithField(aVar4, emotionBannerImg, a.getNextFieldNumber(aVar4))) {
                        }
                        emotionBannerSet.BannerImg = emotionBannerImg;
                    }
                    AppMethodBeat.o(104770);
                    return 0;
                case 2:
                    emotionBannerSet.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(104770);
                    return 0;
                case 3:
                    emotionBannerSet.LocateUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(104770);
                    return 0;
                case 4:
                    emotionBannerSet.ID = aVar3.UbS.zi();
                    AppMethodBeat.o(104770);
                    return 0;
                case 5:
                    emotionBannerSet.SecondUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(104770);
                    return 0;
                case 6:
                    emotionBannerSet.SetType = aVar3.UbS.zi();
                    AppMethodBeat.o(104770);
                    return 0;
                case 7:
                    emotionBannerSet.IconUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(104770);
                    return 0;
                case 8:
                    emotionBannerSet.Desc = aVar3.UbS.readString();
                    AppMethodBeat.o(104770);
                    return 0;
                case 9:
                    emotionBannerSet.ProductID = aVar3.UbS.readString();
                    AppMethodBeat.o(104770);
                    return 0;
                case 10:
                    emotionBannerSet.TagUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(104770);
                    return 0;
                default:
                    AppMethodBeat.o(104770);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104770);
            return -1;
        }
    }
}
