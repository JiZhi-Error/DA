package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.view.View;

public final class j extends k {
    public String fileName;
    public int fileSize;
    public String gCr;
    public int iconRes;
    public boolean qnL;
    public boolean qnM;
    public boolean qnN;
    public boolean qnO;
    public long qnP;
    public String username;

    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.k, com.tencent.mm.plugin.choosemsgfile.b.b.a
    public final String getFileName() {
        return this.fileName;
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.k
    public final String getUsername() {
        return this.username;
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.k, com.tencent.mm.plugin.choosemsgfile.b.b.a
    public final String getFileExt() {
        return this.gCr;
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.k
    public final int cyA() {
        return this.iconRes;
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.k, com.tencent.mm.plugin.choosemsgfile.b.b.a
    public final int cyt() {
        return this.fileSize;
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.a
    public final boolean equals(Object obj) {
        return obj == this;
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.k, com.tencent.mm.plugin.choosemsgfile.b.b.a
    public final int getType() {
        return 4;
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.k, com.tencent.mm.plugin.choosemsgfile.b.b.a
    public final void a(View view, a aVar) {
    }
}
