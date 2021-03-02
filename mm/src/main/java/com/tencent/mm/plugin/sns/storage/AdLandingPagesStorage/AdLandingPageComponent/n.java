package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n extends q {
    public String DYj;
    public int DYk;
    public String businessId;
    public String lRW;
    public String lSf;
    public String lSg;
    public String lSh;
    public String weappUserName;

    public final String toString() {
        AppMethodBeat.i(96316);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("userName:").append(this.weappUserName).append(", appId:").append(this.DYj).append(", busId:").append(this.businessId).append(", sessionFrom:").append(this.lRW).append(", showMessageCard:").append(this.DYk).append(", sendMessageTitle:").append(this.lSf).append(", sendMessageImg:").append(this.lSh).append(", sendMessagePath:").append(this.lSg);
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(96316);
        return stringBuffer2;
    }
}
