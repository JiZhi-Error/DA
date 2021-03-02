package com.tencent.mm.plugin.appbrand.jsapi.video.e.b;

import android.content.Context;
import android.os.Handler;
import com.google.android.exoplayer2.a.i;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.e.c;
import com.google.android.exoplayer2.f.j;
import com.google.android.exoplayer2.metadata.e;
import com.google.android.exoplayer2.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class d implements j {
    protected b<com.google.android.exoplayer2.drm.d> bbV;
    protected Context context;
    protected Handler handler;
    protected j.a mBW;
    protected e.a mBX;
    protected com.google.android.exoplayer2.a.e mBY;
    protected com.google.android.exoplayer2.video.e mBZ;
    protected int mCa = 50;
    protected int mCb = 5000;

    public d(Context context2, Handler handler2, j.a aVar, e.a aVar2, com.google.android.exoplayer2.a.e eVar, com.google.android.exoplayer2.video.e eVar2) {
        this.context = context2;
        this.handler = handler2;
        this.mBW = aVar;
        this.mBX = aVar2;
        this.mBY = eVar;
        this.mBZ = eVar2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e.b.j
    public final List<r> bKB() {
        AppMethodBeat.i(234968);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new i(c.btN, this.bbV, this.handler, this.mBY, com.google.android.exoplayer2.a.c.aj(this.context), new com.google.android.exoplayer2.a.d[0]));
        arrayList.addAll(arrayList2);
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(new com.google.android.exoplayer2.video.c(this.context, c.btN, (long) this.mCb, this.bbV, this.handler, this.mBZ, this.mCa));
        arrayList.addAll(arrayList3);
        AppMethodBeat.o(234968);
        return arrayList;
    }
}
