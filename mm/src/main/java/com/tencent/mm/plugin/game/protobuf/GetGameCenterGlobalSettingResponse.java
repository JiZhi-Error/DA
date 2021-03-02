package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dpc;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public class GetGameCenterGlobalSettingResponse extends dpc {
    public a A8Key;
    public String AppStoreGoodsId;
    public i AppStorePreload;
    public l AutoRunTaskSetting;
    public r CommJsLib;
    public x DownloadIntercept;
    public ai GameCenterTabSetting;
    public aj GameCommunityInfo;
    public an GameDetailSetting;
    public av GameIndexSetting;
    public bb GameLifeSetting;
    public bh GeneralJumpInfo;
    public boolean ShowEntrance;
    public dv StatusBarStyle;
    public em WebViewControl;
    public en WepkgControl;
    public y downloaderApp;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(149416);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(149416);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.cc(2, this.ShowEntrance);
            if (this.GameIndexSetting != null) {
                aVar.ni(3, this.GameIndexSetting.computeSize());
                this.GameIndexSetting.writeFields(aVar);
            }
            if (this.AppStoreGoodsId != null) {
                aVar.e(4, this.AppStoreGoodsId);
            }
            if (this.GameDetailSetting != null) {
                aVar.ni(6, this.GameDetailSetting.computeSize());
                this.GameDetailSetting.writeFields(aVar);
            }
            if (this.AppStorePreload != null) {
                aVar.ni(7, this.AppStorePreload.computeSize());
                this.AppStorePreload.writeFields(aVar);
            }
            if (this.StatusBarStyle != null) {
                aVar.ni(8, this.StatusBarStyle.computeSize());
                this.StatusBarStyle.writeFields(aVar);
            }
            if (this.CommJsLib != null) {
                aVar.ni(11, this.CommJsLib.computeSize());
                this.CommJsLib.writeFields(aVar);
            }
            if (this.WepkgControl != null) {
                aVar.ni(12, this.WepkgControl.computeSize());
                this.WepkgControl.writeFields(aVar);
            }
            if (this.downloaderApp != null) {
                aVar.ni(13, this.downloaderApp.computeSize());
                this.downloaderApp.writeFields(aVar);
            }
            if (this.WebViewControl != null) {
                aVar.ni(14, this.WebViewControl.computeSize());
                this.WebViewControl.writeFields(aVar);
            }
            if (this.DownloadIntercept != null) {
                aVar.ni(15, this.DownloadIntercept.computeSize());
                this.DownloadIntercept.writeFields(aVar);
            }
            if (this.A8Key != null) {
                aVar.ni(16, this.A8Key.computeSize());
                this.A8Key.writeFields(aVar);
            }
            if (this.AutoRunTaskSetting != null) {
                aVar.ni(17, this.AutoRunTaskSetting.computeSize());
                this.AutoRunTaskSetting.writeFields(aVar);
            }
            if (this.GameCenterTabSetting != null) {
                aVar.ni(18, this.GameCenterTabSetting.computeSize());
                this.GameCenterTabSetting.writeFields(aVar);
            }
            if (this.GameLifeSetting != null) {
                aVar.ni(19, this.GameLifeSetting.computeSize());
                this.GameLifeSetting.writeFields(aVar);
            }
            if (this.GeneralJumpInfo != null) {
                aVar.ni(20, this.GeneralJumpInfo.computeSize());
                this.GeneralJumpInfo.writeFields(aVar);
            }
            if (this.GameCommunityInfo != null) {
                aVar.ni(21, this.GameCommunityInfo.computeSize());
                this.GameCommunityInfo.writeFields(aVar);
            }
            AppMethodBeat.o(149416);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.fS(2) + 1;
            if (this.GameIndexSetting != null) {
                nh += g.a.a.a.nh(3, this.GameIndexSetting.computeSize());
            }
            if (this.AppStoreGoodsId != null) {
                nh += g.a.a.b.b.a.f(4, this.AppStoreGoodsId);
            }
            if (this.GameDetailSetting != null) {
                nh += g.a.a.a.nh(6, this.GameDetailSetting.computeSize());
            }
            if (this.AppStorePreload != null) {
                nh += g.a.a.a.nh(7, this.AppStorePreload.computeSize());
            }
            if (this.StatusBarStyle != null) {
                nh += g.a.a.a.nh(8, this.StatusBarStyle.computeSize());
            }
            if (this.CommJsLib != null) {
                nh += g.a.a.a.nh(11, this.CommJsLib.computeSize());
            }
            if (this.WepkgControl != null) {
                nh += g.a.a.a.nh(12, this.WepkgControl.computeSize());
            }
            if (this.downloaderApp != null) {
                nh += g.a.a.a.nh(13, this.downloaderApp.computeSize());
            }
            if (this.WebViewControl != null) {
                nh += g.a.a.a.nh(14, this.WebViewControl.computeSize());
            }
            if (this.DownloadIntercept != null) {
                nh += g.a.a.a.nh(15, this.DownloadIntercept.computeSize());
            }
            if (this.A8Key != null) {
                nh += g.a.a.a.nh(16, this.A8Key.computeSize());
            }
            if (this.AutoRunTaskSetting != null) {
                nh += g.a.a.a.nh(17, this.AutoRunTaskSetting.computeSize());
            }
            if (this.GameCenterTabSetting != null) {
                nh += g.a.a.a.nh(18, this.GameCenterTabSetting.computeSize());
            }
            if (this.GameLifeSetting != null) {
                nh += g.a.a.a.nh(19, this.GameLifeSetting.computeSize());
            }
            if (this.GeneralJumpInfo != null) {
                nh += g.a.a.a.nh(20, this.GeneralJumpInfo.computeSize());
            }
            if (this.GameCommunityInfo != null) {
                nh += g.a.a.a.nh(21, this.GameCommunityInfo.computeSize());
            }
            AppMethodBeat.o(149416);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(149416);
                throw bVar2;
            }
            AppMethodBeat.o(149416);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            GetGameCenterGlobalSettingResponse getGameCenterGlobalSettingResponse = (GetGameCenterGlobalSettingResponse) objArr[1];
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
                        getGameCenterGlobalSettingResponse.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(149416);
                    return 0;
                case 2:
                    getGameCenterGlobalSettingResponse.ShowEntrance = aVar3.UbS.yZ();
                    AppMethodBeat.o(149416);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        av avVar = new av();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = avVar.populateBuilderWithField(aVar5, avVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        getGameCenterGlobalSettingResponse.GameIndexSetting = avVar;
                    }
                    AppMethodBeat.o(149416);
                    return 0;
                case 4:
                    getGameCenterGlobalSettingResponse.AppStoreGoodsId = aVar3.UbS.readString();
                    AppMethodBeat.o(149416);
                    return 0;
                case 5:
                case 9:
                case 10:
                default:
                    AppMethodBeat.o(149416);
                    return -1;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        an anVar = new an();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = anVar.populateBuilderWithField(aVar6, anVar, dpc.getNextFieldNumber(aVar6))) {
                        }
                        getGameCenterGlobalSettingResponse.GameDetailSetting = anVar;
                    }
                    AppMethodBeat.o(149416);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        i iVar = new i();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = iVar.populateBuilderWithField(aVar7, iVar, dpc.getNextFieldNumber(aVar7))) {
                        }
                        getGameCenterGlobalSettingResponse.AppStorePreload = iVar;
                    }
                    AppMethodBeat.o(149416);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        dv dvVar = new dv();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = dvVar.populateBuilderWithField(aVar8, dvVar, dpc.getNextFieldNumber(aVar8))) {
                        }
                        getGameCenterGlobalSettingResponse.StatusBarStyle = dvVar;
                    }
                    AppMethodBeat.o(149416);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        r rVar = new r();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = rVar.populateBuilderWithField(aVar9, rVar, dpc.getNextFieldNumber(aVar9))) {
                        }
                        getGameCenterGlobalSettingResponse.CommJsLib = rVar;
                    }
                    AppMethodBeat.o(149416);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        en enVar = new en();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = enVar.populateBuilderWithField(aVar10, enVar, dpc.getNextFieldNumber(aVar10))) {
                        }
                        getGameCenterGlobalSettingResponse.WepkgControl = enVar;
                    }
                    AppMethodBeat.o(149416);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        y yVar = new y();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = yVar.populateBuilderWithField(aVar11, yVar, dpc.getNextFieldNumber(aVar11))) {
                        }
                        getGameCenterGlobalSettingResponse.downloaderApp = yVar;
                    }
                    AppMethodBeat.o(149416);
                    return 0;
                case 14:
                    LinkedList<byte[]> awh9 = aVar3.awh(intValue);
                    int size9 = awh9.size();
                    for (int i11 = 0; i11 < size9; i11++) {
                        em emVar = new em();
                        g.a.a.a.a aVar12 = new g.a.a.a.a(awh9.get(i11), unknownTagHandler);
                        for (boolean z9 = true; z9; z9 = emVar.populateBuilderWithField(aVar12, emVar, dpc.getNextFieldNumber(aVar12))) {
                        }
                        getGameCenterGlobalSettingResponse.WebViewControl = emVar;
                    }
                    AppMethodBeat.o(149416);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh10 = aVar3.awh(intValue);
                    int size10 = awh10.size();
                    for (int i12 = 0; i12 < size10; i12++) {
                        x xVar = new x();
                        g.a.a.a.a aVar13 = new g.a.a.a.a(awh10.get(i12), unknownTagHandler);
                        for (boolean z10 = true; z10; z10 = xVar.populateBuilderWithField(aVar13, xVar, dpc.getNextFieldNumber(aVar13))) {
                        }
                        getGameCenterGlobalSettingResponse.DownloadIntercept = xVar;
                    }
                    AppMethodBeat.o(149416);
                    return 0;
                case 16:
                    LinkedList<byte[]> awh11 = aVar3.awh(intValue);
                    int size11 = awh11.size();
                    for (int i13 = 0; i13 < size11; i13++) {
                        a aVar14 = new a();
                        g.a.a.a.a aVar15 = new g.a.a.a.a(awh11.get(i13), unknownTagHandler);
                        for (boolean z11 = true; z11; z11 = aVar14.populateBuilderWithField(aVar15, aVar14, dpc.getNextFieldNumber(aVar15))) {
                        }
                        getGameCenterGlobalSettingResponse.A8Key = aVar14;
                    }
                    AppMethodBeat.o(149416);
                    return 0;
                case 17:
                    LinkedList<byte[]> awh12 = aVar3.awh(intValue);
                    int size12 = awh12.size();
                    for (int i14 = 0; i14 < size12; i14++) {
                        l lVar = new l();
                        g.a.a.a.a aVar16 = new g.a.a.a.a(awh12.get(i14), unknownTagHandler);
                        for (boolean z12 = true; z12; z12 = lVar.populateBuilderWithField(aVar16, lVar, dpc.getNextFieldNumber(aVar16))) {
                        }
                        getGameCenterGlobalSettingResponse.AutoRunTaskSetting = lVar;
                    }
                    AppMethodBeat.o(149416);
                    return 0;
                case 18:
                    LinkedList<byte[]> awh13 = aVar3.awh(intValue);
                    int size13 = awh13.size();
                    for (int i15 = 0; i15 < size13; i15++) {
                        ai aiVar = new ai();
                        g.a.a.a.a aVar17 = new g.a.a.a.a(awh13.get(i15), unknownTagHandler);
                        for (boolean z13 = true; z13; z13 = aiVar.populateBuilderWithField(aVar17, aiVar, dpc.getNextFieldNumber(aVar17))) {
                        }
                        getGameCenterGlobalSettingResponse.GameCenterTabSetting = aiVar;
                    }
                    AppMethodBeat.o(149416);
                    return 0;
                case 19:
                    LinkedList<byte[]> awh14 = aVar3.awh(intValue);
                    int size14 = awh14.size();
                    for (int i16 = 0; i16 < size14; i16++) {
                        bb bbVar = new bb();
                        g.a.a.a.a aVar18 = new g.a.a.a.a(awh14.get(i16), unknownTagHandler);
                        for (boolean z14 = true; z14; z14 = bbVar.populateBuilderWithField(aVar18, bbVar, dpc.getNextFieldNumber(aVar18))) {
                        }
                        getGameCenterGlobalSettingResponse.GameLifeSetting = bbVar;
                    }
                    AppMethodBeat.o(149416);
                    return 0;
                case 20:
                    LinkedList<byte[]> awh15 = aVar3.awh(intValue);
                    int size15 = awh15.size();
                    for (int i17 = 0; i17 < size15; i17++) {
                        bh bhVar = new bh();
                        g.a.a.a.a aVar19 = new g.a.a.a.a(awh15.get(i17), unknownTagHandler);
                        for (boolean z15 = true; z15; z15 = bhVar.populateBuilderWithField(aVar19, bhVar, dpc.getNextFieldNumber(aVar19))) {
                        }
                        getGameCenterGlobalSettingResponse.GeneralJumpInfo = bhVar;
                    }
                    AppMethodBeat.o(149416);
                    return 0;
                case 21:
                    LinkedList<byte[]> awh16 = aVar3.awh(intValue);
                    int size16 = awh16.size();
                    for (int i18 = 0; i18 < size16; i18++) {
                        aj ajVar = new aj();
                        g.a.a.a.a aVar20 = new g.a.a.a.a(awh16.get(i18), unknownTagHandler);
                        for (boolean z16 = true; z16; z16 = ajVar.populateBuilderWithField(aVar20, ajVar, dpc.getNextFieldNumber(aVar20))) {
                        }
                        getGameCenterGlobalSettingResponse.GameCommunityInfo = ajVar;
                    }
                    AppMethodBeat.o(149416);
                    return 0;
            }
        } else {
            AppMethodBeat.o(149416);
            return -1;
        }
    }
}
