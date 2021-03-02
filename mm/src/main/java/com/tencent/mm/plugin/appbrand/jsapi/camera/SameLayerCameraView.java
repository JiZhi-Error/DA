package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ag.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView;
import com.tencent.mm.plugin.appbrand.jsapi.scanner.JsApiScanCode;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class SameLayerCameraView extends AppBrandCameraView implements g {
    private SurfaceTexture mSurfaceTexture;

    public static void bFJ() {
        AppMethodBeat.i(46224);
        com.tencent.mm.plugin.appbrand.jsapi.ag.a.a.mIW = new a.AbstractC0603a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.camera.SameLayerCameraView.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.ag.a.a.AbstractC0603a
            public final f dN(Context context) {
                AppMethodBeat.i(46222);
                SameLayerCameraView sameLayerCameraView = new SameLayerCameraView(context);
                AppMethodBeat.o(46222);
                return sameLayerCameraView;
            }
        };
        AppMethodBeat.o(46224);
    }

    public SameLayerCameraView(Context context) {
        super(context);
    }

    public SameLayerCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SameLayerCameraView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.g
    public void setCustomSurfaceTexture(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(46225);
        Log.i("MicroMsg.SameLayerCameraView", "setCustomSurfaceTexture:%s", surfaceTexture);
        this.mSurfaceTexture = surfaceTexture;
        AppMethodBeat.o(46225);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView
    public final MMSightRecordView d(Context context, int i2, int i3) {
        AppMethodBeat.i(46226);
        MMSightRecordView mMSightRecordView = new MMSightRecordView(context, this.mSurfaceTexture, i2, i3);
        AppMethodBeat.o(46226);
        return mMSightRecordView;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.g
    public final void o(MotionEvent motionEvent) {
        AppMethodBeat.i(46227);
        if (getRecordView() == null) {
            AppMethodBeat.o(46227);
            return;
        }
        getRecordView().zsX.o(motionEvent);
        AppMethodBeat.o(46227);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView
    public final AppBrandCameraView.a ZI(String str) {
        AppMethodBeat.i(46228);
        if (Util.isNullOrNil(str) || !str.equals(JsApiScanCode.NAME)) {
            AppBrandCameraView.a ZI = super.ZI(str);
            AppMethodBeat.o(46228);
            return ZI;
        }
        a aVar = new a();
        AppMethodBeat.o(46228);
        return aVar;
    }

    protected class a extends AppBrandCameraView.c {
        protected a() {
            super(SameLayerCameraView.this);
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.a, com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView.c
        public final void init() {
            AppMethodBeat.i(46223);
            this.lPV = 1;
            super.init();
            AppMethodBeat.o(46223);
        }
    }
}
