package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public class FinderMediaReportInfo extends a {
    public int audioBitrate;
    public int fileSize;
    public int fps;
    public int height;
    public int videoBitrate;
    public int videoDuration;
    public int width;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169007);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.videoDuration);
            aVar.aM(2, this.videoBitrate);
            aVar.aM(3, this.width);
            aVar.aM(4, this.height);
            aVar.aM(5, this.fileSize);
            aVar.aM(6, this.audioBitrate);
            aVar.aM(7, this.fps);
            AppMethodBeat.o(169007);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.videoDuration) + 0 + g.a.a.b.b.a.bu(2, this.videoBitrate) + g.a.a.b.b.a.bu(3, this.width) + g.a.a.b.b.a.bu(4, this.height) + g.a.a.b.b.a.bu(5, this.fileSize) + g.a.a.b.b.a.bu(6, this.audioBitrate) + g.a.a.b.b.a.bu(7, this.fps);
            AppMethodBeat.o(169007);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(169007);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            FinderMediaReportInfo finderMediaReportInfo = (FinderMediaReportInfo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    finderMediaReportInfo.videoDuration = aVar3.UbS.zi();
                    AppMethodBeat.o(169007);
                    return 0;
                case 2:
                    finderMediaReportInfo.videoBitrate = aVar3.UbS.zi();
                    AppMethodBeat.o(169007);
                    return 0;
                case 3:
                    finderMediaReportInfo.width = aVar3.UbS.zi();
                    AppMethodBeat.o(169007);
                    return 0;
                case 4:
                    finderMediaReportInfo.height = aVar3.UbS.zi();
                    AppMethodBeat.o(169007);
                    return 0;
                case 5:
                    finderMediaReportInfo.fileSize = aVar3.UbS.zi();
                    AppMethodBeat.o(169007);
                    return 0;
                case 6:
                    finderMediaReportInfo.audioBitrate = aVar3.UbS.zi();
                    AppMethodBeat.o(169007);
                    return 0;
                case 7:
                    finderMediaReportInfo.fps = aVar3.UbS.zi();
                    AppMethodBeat.o(169007);
                    return 0;
                default:
                    AppMethodBeat.o(169007);
                    return -1;
            }
        } else {
            AppMethodBeat.o(169007);
            return -1;
        }
    }
}
