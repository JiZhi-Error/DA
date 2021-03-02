package com.tencent.mm.plugin.expt.d.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.d.b;
import com.tencent.sqlitelint.config.SharePluginInfo;

public final class c {
    public String dbPath;
    public String sql;
    public String syg;
    public int syl;
    public String syr;
    public String syt;

    public final String toString() {
        String str;
        AppMethodBeat.i(220346);
        StringBuilder append = new StringBuilder("EdgeComputingSqlConfigModel{configID='").append(this.syg).append('\'').append(", reportID=").append(this.syl).append(", dbPath='").append(b.KB() ? this.dbPath : "dbPath").append('\'').append(", sql='").append(b.KB() ? this.sql : SharePluginInfo.ISSUE_KEY_SQL).append('\'').append(", sqlMD5='").append(b.KB() ? this.syt : "sqlMD5").append('\'').append(", originalJson='");
        if (b.KB()) {
            str = this.syr;
        } else {
            str = "originalJson";
        }
        String sb = append.append(str).append('\'').append('}').toString();
        AppMethodBeat.o(220346);
        return sb;
    }
}
