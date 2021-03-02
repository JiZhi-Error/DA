package com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a;

import android.content.Context;
import android.view.TextureView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.videoview.BaseVideoView;
import com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a;

public class e extends BaseVideoView {
    public e(Context context) {
        super(context);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.videoview.BaseVideoView
    public a ea(Context context) {
        AppMethodBeat.i(235191);
        this.mEJ = 1;
        d dVar = new d(context);
        AppMethodBeat.o(235191);
        return dVar;
    }

    public TextureView getVideoTexture() {
        return (TextureView) this.mEE;
    }
}
