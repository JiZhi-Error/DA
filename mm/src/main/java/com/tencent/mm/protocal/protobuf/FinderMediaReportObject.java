package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public class FinderMediaReportObject extends a {
    public int cdnControl;
    public int cdnUploadRetCode;
    public int cdnUploadTime;
    public ayg codecInfo;
    public int isBigFile;
    public String mediaId;
    public int mediaType;
    public LinkedList<FinderMediaReportInfo> multiMediaInfo = new LinkedList<>();
    public FinderMediaReportInfo origin;
    public int playDecoderType;
    public int remuxRetCode;
    public int remuxTime;
    public FinderMediaReportInfo target;
    public int videoFinalSize;
    public int zipRetCode;
    public int zipTime;

    public FinderMediaReportObject() {
        AppMethodBeat.i(209587);
        AppMethodBeat.o(209587);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169008);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.remuxTime);
            aVar.aM(2, this.remuxRetCode);
            aVar.aM(3, this.cdnUploadTime);
            aVar.aM(4, this.cdnUploadRetCode);
            aVar.aM(5, this.zipTime);
            aVar.aM(6, this.zipRetCode);
            aVar.aM(7, this.mediaType);
            if (this.mediaId != null) {
                aVar.e(8, this.mediaId);
            }
            if (this.origin != null) {
                aVar.ni(9, this.origin.computeSize());
                this.origin.writeFields(aVar);
            }
            if (this.target != null) {
                aVar.ni(10, this.target.computeSize());
                this.target.writeFields(aVar);
            }
            aVar.aM(11, this.isBigFile);
            aVar.aM(12, this.cdnControl);
            aVar.aM(13, this.videoFinalSize);
            aVar.e(14, 8, this.multiMediaInfo);
            if (this.codecInfo != null) {
                aVar.ni(15, this.codecInfo.computeSize());
                this.codecInfo.writeFields(aVar);
            }
            aVar.aM(16, this.playDecoderType);
            AppMethodBeat.o(169008);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.remuxTime) + 0 + g.a.a.b.b.a.bu(2, this.remuxRetCode) + g.a.a.b.b.a.bu(3, this.cdnUploadTime) + g.a.a.b.b.a.bu(4, this.cdnUploadRetCode) + g.a.a.b.b.a.bu(5, this.zipTime) + g.a.a.b.b.a.bu(6, this.zipRetCode) + g.a.a.b.b.a.bu(7, this.mediaType);
            if (this.mediaId != null) {
                bu += g.a.a.b.b.a.f(8, this.mediaId);
            }
            if (this.origin != null) {
                bu += g.a.a.a.nh(9, this.origin.computeSize());
            }
            if (this.target != null) {
                bu += g.a.a.a.nh(10, this.target.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(11, this.isBigFile) + g.a.a.b.b.a.bu(12, this.cdnControl) + g.a.a.b.b.a.bu(13, this.videoFinalSize) + g.a.a.a.c(14, 8, this.multiMediaInfo);
            if (this.codecInfo != null) {
                bu2 += g.a.a.a.nh(15, this.codecInfo.computeSize());
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(16, this.playDecoderType);
            AppMethodBeat.o(169008);
            return bu3;
        } else if (i2 == 2) {
            this.multiMediaInfo.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(169008);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            FinderMediaReportObject finderMediaReportObject = (FinderMediaReportObject) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    finderMediaReportObject.remuxTime = aVar3.UbS.zi();
                    AppMethodBeat.o(169008);
                    return 0;
                case 2:
                    finderMediaReportObject.remuxRetCode = aVar3.UbS.zi();
                    AppMethodBeat.o(169008);
                    return 0;
                case 3:
                    finderMediaReportObject.cdnUploadTime = aVar3.UbS.zi();
                    AppMethodBeat.o(169008);
                    return 0;
                case 4:
                    finderMediaReportObject.cdnUploadRetCode = aVar3.UbS.zi();
                    AppMethodBeat.o(169008);
                    return 0;
                case 5:
                    finderMediaReportObject.zipTime = aVar3.UbS.zi();
                    AppMethodBeat.o(169008);
                    return 0;
                case 6:
                    finderMediaReportObject.zipRetCode = aVar3.UbS.zi();
                    AppMethodBeat.o(169008);
                    return 0;
                case 7:
                    finderMediaReportObject.mediaType = aVar3.UbS.zi();
                    AppMethodBeat.o(169008);
                    return 0;
                case 8:
                    finderMediaReportObject.mediaId = aVar3.UbS.readString();
                    AppMethodBeat.o(169008);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        FinderMediaReportInfo finderMediaReportInfo = new FinderMediaReportInfo();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = finderMediaReportInfo.populateBuilderWithField(aVar4, finderMediaReportInfo, a.getNextFieldNumber(aVar4))) {
                        }
                        finderMediaReportObject.origin = finderMediaReportInfo;
                    }
                    AppMethodBeat.o(169008);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        FinderMediaReportInfo finderMediaReportInfo2 = new FinderMediaReportInfo();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = finderMediaReportInfo2.populateBuilderWithField(aVar5, finderMediaReportInfo2, a.getNextFieldNumber(aVar5))) {
                        }
                        finderMediaReportObject.target = finderMediaReportInfo2;
                    }
                    AppMethodBeat.o(169008);
                    return 0;
                case 11:
                    finderMediaReportObject.isBigFile = aVar3.UbS.zi();
                    AppMethodBeat.o(169008);
                    return 0;
                case 12:
                    finderMediaReportObject.cdnControl = aVar3.UbS.zi();
                    AppMethodBeat.o(169008);
                    return 0;
                case 13:
                    finderMediaReportObject.videoFinalSize = aVar3.UbS.zi();
                    AppMethodBeat.o(169008);
                    return 0;
                case 14:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        FinderMediaReportInfo finderMediaReportInfo3 = new FinderMediaReportInfo();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = finderMediaReportInfo3.populateBuilderWithField(aVar6, finderMediaReportInfo3, a.getNextFieldNumber(aVar6))) {
                        }
                        finderMediaReportObject.multiMediaInfo.add(finderMediaReportInfo3);
                    }
                    AppMethodBeat.o(169008);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        ayg ayg = new ayg();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = ayg.populateBuilderWithField(aVar7, ayg, a.getNextFieldNumber(aVar7))) {
                        }
                        finderMediaReportObject.codecInfo = ayg;
                    }
                    AppMethodBeat.o(169008);
                    return 0;
                case 16:
                    finderMediaReportObject.playDecoderType = aVar3.UbS.zi();
                    AppMethodBeat.o(169008);
                    return 0;
                default:
                    AppMethodBeat.o(169008);
                    return -1;
            }
        } else {
            AppMethodBeat.o(169008);
            return -1;
        }
    }
}
