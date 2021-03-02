package com.tencent.mm.plugin.expt.d.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class b {
    public String script;
    public String syg;
    public int syj;
    public int syk;
    public int syl;
    public List<a> sym;
    public int syn;
    public int syo;
    public int syp;
    public int syq;
    public String syr;
    public String sys;

    public final String toString() {
        String str;
        AppMethodBeat.i(220345);
        StringBuilder append = new StringBuilder("EdgeComputingScriptConfigModel{configID='").append(this.syg).append('\'').append(", dataSourceType=").append(this.syj).append(", dataSourceID=").append(this.syk).append(", reportID=").append(this.syl).append(", fieldConfigModels=").append(this.sym).append(", isInstantReport=").append(this.syn).append(", isRepeat=").append(this.syo).append(", runPeriod=").append(this.syp).append(", dbExpireTime=").append(this.syq).append(", script='").append(com.tencent.mm.plugin.expt.d.b.KB() ? this.script : "script").append('\'').append(", scriptMD5='").append(com.tencent.mm.plugin.expt.d.b.KB() ? this.sys : "scriptMD5").append('\'').append(", originalJson='");
        if (com.tencent.mm.plugin.expt.d.b.KB()) {
            str = this.syr;
        } else {
            str = "originalJson";
        }
        String sb = append.append(str).append('\'').append('}').toString();
        AppMethodBeat.o(220345);
        return sb;
    }
}
