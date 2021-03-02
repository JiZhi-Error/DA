package com.tencent.mm.plugin.appbrand.jsapi.s;

import android.content.Context;
import android.view.View;

public interface h<PipVideoContainer extends View> {

    public interface a<OriginVideoContainer extends g, PipVideoContainer extends View> {
        h<PipVideoContainer> a(OriginVideoContainer originvideocontainer);
    }

    d Pz();

    PipVideoContainer aS(Context context);

    void cf(PipVideoContainer pipvideocontainer);

    void cg(PipVideoContainer pipvideocontainer);

    void d(PipVideoContainer pipvideocontainer, Runnable runnable);

    void e(PipVideoContainer pipvideocontainer, Runnable runnable);
}
