package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public class EmotionBanner extends a {
    public EmotionBannerImg BannerImg;
    public EmotionSummary BannerSummary;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104768);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.BannerSummary == null) {
                b bVar = new b("Not all required fields were included: BannerSummary");
                AppMethodBeat.o(104768);
                throw bVar;
            } else if (this.BannerImg == null) {
                b bVar2 = new b("Not all required fields were included: BannerImg");
                AppMethodBeat.o(104768);
                throw bVar2;
            } else {
                if (this.BannerSummary != null) {
                    aVar.ni(1, this.BannerSummary.computeSize());
                    this.BannerSummary.writeFields(aVar);
                }
                if (this.BannerImg != null) {
                    aVar.ni(2, this.BannerImg.computeSize());
                    this.BannerImg.writeFields(aVar);
                }
                AppMethodBeat.o(104768);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BannerSummary != null ? g.a.a.a.nh(1, this.BannerSummary.computeSize()) + 0 : 0;
            if (this.BannerImg != null) {
                nh += g.a.a.a.nh(2, this.BannerImg.computeSize());
            }
            AppMethodBeat.o(104768);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BannerSummary == null) {
                b bVar3 = new b("Not all required fields were included: BannerSummary");
                AppMethodBeat.o(104768);
                throw bVar3;
            } else if (this.BannerImg == null) {
                b bVar4 = new b("Not all required fields were included: BannerImg");
                AppMethodBeat.o(104768);
                throw bVar4;
            } else {
                AppMethodBeat.o(104768);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            EmotionBanner emotionBanner = (EmotionBanner) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        EmotionSummary emotionSummary = new EmotionSummary();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = emotionSummary.populateBuilderWithField(aVar4, emotionSummary, a.getNextFieldNumber(aVar4))) {
                        }
                        emotionBanner.BannerSummary = emotionSummary;
                    }
                    AppMethodBeat.o(104768);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        EmotionBannerImg emotionBannerImg = new EmotionBannerImg();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = emotionBannerImg.populateBuilderWithField(aVar5, emotionBannerImg, a.getNextFieldNumber(aVar5))) {
                        }
                        emotionBanner.BannerImg = emotionBannerImg;
                    }
                    AppMethodBeat.o(104768);
                    return 0;
                default:
                    AppMethodBeat.o(104768);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104768);
            return -1;
        }
    }
}
