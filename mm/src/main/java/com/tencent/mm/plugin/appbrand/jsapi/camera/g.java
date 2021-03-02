package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.graphics.SurfaceTexture;
import android.util.Size;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.h;

public interface g extends f {
    public static final g lQd = new g() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.camera.g.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
        public final void setMode(String str) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
        public final void setFrameLimitSize(int i2) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.i.d
        public final void onForeground() {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.i.b
        public final void onBackground() {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.i.c
        public final void onDestroy() {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
        public final void setCameraId(int i2) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
        public final int getCameraId() {
            return 0;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
        public final void ar(String str, boolean z) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
        public final void setFlash(String str) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
        public final void setNeedOutput(boolean z) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
        public final boolean dZ(int i2, int i3) {
            return false;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
        public final void setQuality(String str) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
        public final void setResolution(String str) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
        public final void setCompressRecord(boolean z) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
        public final void setPreviewCenterCrop(boolean z) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
        public final void setDisplayScreenSize(Size size) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
        public final void setPageOrientation(boolean z) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.g
        public final void setCustomSurfaceTexture(SurfaceTexture surfaceTexture) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.g
        public final void o(MotionEvent motionEvent) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
        public final void setOperateCallBack(c cVar) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
        public final void setOutPutCallBack(b bVar) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
        public final void setScanFreq(int i2) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
        public final void x(int i2, int i3, int i4, int i5) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
        public final void bFK() {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
        public final float aJ(float f2) {
            return 0.0f;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
        public final void bFT() {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
        public final void bFU() {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
        public final void bFM() {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
        public final void o(f fVar) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
        public final void bFN() {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
        public final void initView() {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
        public final View getView() {
            return null;
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
        public final void release() {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
        public final void setAppId(String str) {
        }

        @Override // com.tencent.mm.plugin.appbrand.jsapi.camera.f
        public final void setPage(h hVar) {
        }
    };

    void o(MotionEvent motionEvent);

    void setCustomSurfaceTexture(SurfaceTexture surfaceTexture);
}
