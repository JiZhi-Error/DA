package com.tencent.mm.plugin.appbrand.jsapi.ag.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k.a.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Map;

public final class b extends a {
    private int mHeight;
    private SurfaceTexture mSurfaceTexture;
    private int mWidth;

    public b(Context context, String str, Map<String, Object> map) {
        super(context, str, map);
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0021  */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.tencentmap.mapsdk.map.TencentMapOptions P(java.util.Map<java.lang.String, java.lang.Object> r9) {
        /*
        // Method dump skipped, instructions count: 125
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.ag.d.b.P(java.util.Map):com.tencent.tencentmap.mapsdk.map.TencentMapOptions");
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.a, com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(139540);
        if (this.mSurfaceTexture == null) {
            AppMethodBeat.o(139540);
            return;
        }
        if (this.lYw != null) {
            this.lYw.onTouchEvent(motionEvent);
        }
        AppMethodBeat.o(139540);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.a, com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void onSizeChanged(int i2, int i3) {
        AppMethodBeat.i(139541);
        if (this.mSurfaceTexture != null) {
            this.mWidth = i2;
            this.mHeight = i3;
            this.mSurfaceTexture.setDefaultBufferSize(i2, i3);
        }
        try {
            this.lYw.onSizeChanged(i2, i3, i2, i3);
            AppMethodBeat.o(139541);
        } catch (Exception e2) {
            Log.e("MicroMsg.SameLayerMapView", "onSizeChanged :%s", e2);
            if (BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG) {
                AppMethodBeat.o(139541);
                throw e2;
            } else {
                AppMethodBeat.o(139541);
            }
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.a, com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final void g(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(139542);
        if (!(surfaceTexture == null || this.mSurfaceTexture == surfaceTexture)) {
            SurfaceTexture surfaceTexture2 = this.mSurfaceTexture;
            this.mSurfaceTexture = surfaceTexture;
            this.lYw.onSurfaceChanged(this.mSurfaceTexture, this.mWidth, this.mHeight);
            this.mSurfaceTexture.setDefaultBufferSize(this.mWidth, this.mHeight);
            if (surfaceTexture2 != null) {
                surfaceTexture2.release();
            }
        }
        AppMethodBeat.o(139542);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.k.a.a, com.tencent.mm.plugin.appbrand.jsapi.k.a.b
    public final boolean bGX() {
        return true;
    }
}
