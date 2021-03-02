package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.plugin.appbrand.appstorage.q;

public final class x extends FileStructStat implements q.a {
    public final String kTh;

    public x(String str) {
        this.kTh = str;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q.a
    public final String getFileName() {
        return this.kTh;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q.a
    public final long bxm() {
        return this.st_size;
    }

    @Override // com.tencent.mm.plugin.appbrand.appstorage.q.a
    public final long lastModified() {
        return this.st_mtime;
    }
}
