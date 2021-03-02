package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.util.Size;
import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.i;

public interface f extends i.b, i.c, i.d {
    public static final f lQc = new f() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.camera.f.AnonymousClass1 */

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
        public final void o(com.tencent.mm.plugin.appbrand.jsapi.f fVar) {
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

    float aJ(float f2);

    void ar(String str, boolean z);

    void bFK();

    void bFM();

    void bFN();

    void bFT();

    void bFU();

    boolean dZ(int i2, int i3);

    int getCameraId();

    View getView();

    void initView();

    void o(com.tencent.mm.plugin.appbrand.jsapi.f fVar);

    void release();

    void setAppId(String str);

    void setCameraId(int i2);

    void setCompressRecord(boolean z);

    void setDisplayScreenSize(Size size);

    void setFlash(String str);

    void setFrameLimitSize(int i2);

    void setMode(String str);

    void setNeedOutput(boolean z);

    void setOperateCallBack(c cVar);

    void setOutPutCallBack(b bVar);

    void setPage(h hVar);

    void setPageOrientation(boolean z);

    void setPreviewCenterCrop(boolean z);

    void setQuality(String str);

    void setResolution(String str);

    void setScanFreq(int i2);

    void x(int i2, int i3, int i4, int i5);
}
