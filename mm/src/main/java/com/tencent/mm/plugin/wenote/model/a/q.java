package com.tencent.mm.plugin.wenote.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

public final class q implements Serializable {
    public boolean JHR = false;
    public long JHS = -1;
    public long JHT = -1;
    public String JHU = "";
    public String JHV = "";
    public int JHW = 0;
    public int JHX = 0;
    public boolean tcb = false;

    public final String gjG() {
        AppMethodBeat.i(30377);
        StringBuilder sb = new StringBuilder();
        sb.append("topIsOpenFromSession=").append(this.JHR).append(" topLocalId=").append(this.JHS).append(" topMsgId=").append(this.JHT).append(" topTitle=").append(this.JHU).append(" topNoteXml=").append(this.JHV).append(" topLastPosition=").append(this.JHW).append(" topLastOffset=").append(this.JHX);
        String sb2 = sb.toString();
        AppMethodBeat.o(30377);
        return sb2;
    }
}
