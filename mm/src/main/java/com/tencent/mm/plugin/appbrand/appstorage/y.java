package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.plugin.appbrand.appstorage.q;

public class y implements q.a {
    public String dJX;
    public String gCr;
    public String iGf;
    public long jPY;
    public boolean kSa;
    public long kSb;
    public String mimeType;

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q.a
    public final String getFileName() {
        return this.dJX;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q.a
    public final long bxm() {
        return this.jPY;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q.a
    public final long lastModified() {
        return this.kSb;
    }
}
