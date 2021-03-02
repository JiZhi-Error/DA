package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.plugin.report.a;

public final class kb extends a {
    public String eTA = "";
    private long eTB;
    public String eTC = "";
    public int eTe = -1;
    public int eTf = -1;
    public int eTg = -1;
    public int eTh = -1;
    public String eTi = "";
    public int eTj = -1;
    public String eTk = "";
    public int eTl = -1;
    public String eTm = "";
    public int eTn = -1;
    public int eTo = -1;
    public String eTp = "";
    private int eTq = -1;
    public int eTr = -1;
    public String eTs = "";
    public int eTt = -1;
    public int eTu = -1;
    public String eTv = "";
    public int eTw = -1;
    public int eTx = -1;
    public String eTy = "";
    public String eTz = "";
    private String eoC = "";

    @Override // com.tencent.mm.plugin.report.a
    public final int getId() {
        return 17367;
    }

    public final kb xk(String str) {
        AppMethodBeat.i(176225);
        this.eoC = x("SessionID", str, true);
        AppMethodBeat.o(176225);
        return this;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abV() {
        AppMethodBeat.i(94856);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.eoC);
        stringBuffer.append(",");
        stringBuffer.append(this.eTe);
        stringBuffer.append(",");
        stringBuffer.append(this.eTf);
        stringBuffer.append(",");
        stringBuffer.append(this.eTg);
        stringBuffer.append(",");
        stringBuffer.append(this.eTh);
        stringBuffer.append(",");
        stringBuffer.append(this.eTi);
        stringBuffer.append(",");
        stringBuffer.append(this.eTj);
        stringBuffer.append(",");
        stringBuffer.append(this.eTk);
        stringBuffer.append(",");
        stringBuffer.append(this.eTl);
        stringBuffer.append(",");
        stringBuffer.append(this.eTm);
        stringBuffer.append(",");
        stringBuffer.append(this.eTn);
        stringBuffer.append(",");
        stringBuffer.append(this.eTo);
        stringBuffer.append(",");
        stringBuffer.append(this.eTp);
        stringBuffer.append(",");
        stringBuffer.append(this.eTq);
        stringBuffer.append(",");
        stringBuffer.append(this.eTr);
        stringBuffer.append(",");
        stringBuffer.append(this.eTs);
        stringBuffer.append(",");
        stringBuffer.append(this.eTt);
        stringBuffer.append(",");
        stringBuffer.append(this.eTu);
        stringBuffer.append(",");
        stringBuffer.append(this.eTv);
        stringBuffer.append(",");
        stringBuffer.append(this.eTw);
        stringBuffer.append(",");
        stringBuffer.append(this.eTx);
        stringBuffer.append(",");
        stringBuffer.append(this.eTy);
        stringBuffer.append(",");
        stringBuffer.append(this.eTz);
        stringBuffer.append(",");
        stringBuffer.append(this.eTA);
        stringBuffer.append(",");
        stringBuffer.append(this.eTB);
        stringBuffer.append(",");
        stringBuffer.append(this.eTC);
        String stringBuffer2 = stringBuffer.toString();
        aMq(stringBuffer2);
        AppMethodBeat.o(94856);
        return stringBuffer2;
    }

    @Override // com.tencent.mm.plugin.report.a
    public final String abW() {
        AppMethodBeat.i(94857);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SessionID:").append(this.eoC);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("VisibleButtonClickNum:").append(this.eTe);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LatestTimelinePsotSettingisShow:").append(this.eTf);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LatestTimelinePsotSettingisClick:").append(this.eTg);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LatestTimelinePsotSettingGroupCount:").append(this.eTh);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LatestTimelinePsotSettingGroupList:").append(this.eTi);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LatestTimelinePsotSettingUinCount:").append(this.eTj);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LatestTimelinePsotSettingUinList:").append(this.eTk);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LatestTimelinePsotSettingLabelCount:").append(this.eTl);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("LatestTimelinePsotSettingLabelList:").append(this.eTm);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("TimelinePsotPrivaceSetting:").append(this.eTn);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SelectFromChatroomClickNum:").append(this.eTo);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ChatroomMemClickList:").append(this.eTp);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ChatroomMemClickNum:").append(this.eTq);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SelectedChatroomNum:").append(this.eTr);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SelectedChatroomList:").append(this.eTs);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SelectFromContactClickNum:").append(this.eTt);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SelectedUINNum:").append(this.eTu);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SelectedUINList:").append(this.eTv);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("PostStatus:").append(this.eTw);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SelectedLabelNum:").append(this.eTx);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("SelectedLabelList:").append(this.eTy);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("Published:").append(this.eTz);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ChatroomMemClickNumList:").append(this.eTA);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("ImageOrVideoPublishId:").append(this.eTB);
        stringBuffer.append(APLogFileUtil.SEPARATOR_LINE);
        stringBuffer.append("MediaEditedPublishIds:").append(this.eTC);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(94857);
        return stringBuffer2;
    }
}
