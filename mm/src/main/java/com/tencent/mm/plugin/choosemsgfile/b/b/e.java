package com.tencent.mm.plugin.choosemsgfile.b.b;

import android.view.View;

public final class e extends f {
    public String fileName;
    public int fileSize;
    public String gCr;
    public boolean qnL;
    public boolean qnM;
    public boolean qnN;
    public boolean qnO;
    public long qnP;

    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.a, com.tencent.mm.plugin.choosemsgfile.b.b.f
    public final String getFileName() {
        return this.fileName;
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.a, com.tencent.mm.plugin.choosemsgfile.b.b.f
    public final String getFileExt() {
        return this.gCr;
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.a, com.tencent.mm.plugin.choosemsgfile.b.b.f
    public final int cyt() {
        return this.fileSize;
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.a
    public final boolean equals(Object obj) {
        return obj == this;
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.a, com.tencent.mm.plugin.choosemsgfile.b.b.f
    public final int getType() {
        return 4;
    }

    @Override // com.tencent.mm.plugin.choosemsgfile.b.b.a, com.tencent.mm.plugin.choosemsgfile.b.b.f
    public final void a(View view, a aVar) {
    }
}
