package com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.e;

public final class g implements e {
    private e mFc;

    public g(Context context) {
        AppMethodBeat.i(235192);
        this.mFc = new e(context);
        AppMethodBeat.o(235192);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final View getView() {
        return this.mFc;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void bIW() {
        AppMethodBeat.i(235193);
        this.mFc.bIW();
        AppMethodBeat.o(235193);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final int getPlayerType() {
        AppMethodBeat.i(235194);
        int playerType = this.mFc.getPlayerType();
        AppMethodBeat.o(235194);
        return playerType;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final boolean p(double d2) {
        AppMethodBeat.i(235195);
        boolean p = this.mFc.p(d2);
        AppMethodBeat.o(235195);
        return p;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final boolean c(double d2, boolean z) {
        AppMethodBeat.i(235196);
        boolean c2 = this.mFc.c(d2, z);
        AppMethodBeat.o(235196);
        return c2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void setIsShowBasicControls(boolean z) {
        AppMethodBeat.i(235197);
        this.mFc.setIsShowBasicControls(z);
        AppMethodBeat.o(235197);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void setFullDirection(int i2) {
        AppMethodBeat.i(235198);
        this.mFc.setFullDirection(i2);
        AppMethodBeat.o(235198);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final int getVideoDurationSec() {
        AppMethodBeat.i(235199);
        int videoDurationSec = this.mFc.getVideoDurationSec();
        AppMethodBeat.o(235199);
        return videoDurationSec;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final int getCurrPosMs() {
        AppMethodBeat.i(235200);
        int currPosMs = this.mFc.getCurrPosMs();
        AppMethodBeat.o(235200);
        return currPosMs;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final int getCurrPosSec() {
        AppMethodBeat.i(235201);
        int currPosSec = this.mFc.getCurrPosSec();
        AppMethodBeat.o(235201);
        return currPosSec;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final int getCacheTimeSec() {
        AppMethodBeat.i(235202);
        int cacheTimeSec = this.mFc.getCacheTimeSec();
        AppMethodBeat.o(235202);
        return cacheTimeSec;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final boolean isPlaying() {
        AppMethodBeat.i(235203);
        boolean isPlaying = this.mFc.isPlaying();
        AppMethodBeat.o(235203);
        return isPlaying;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final boolean isLive() {
        AppMethodBeat.i(235204);
        boolean isLive = this.mFc.isLive();
        AppMethodBeat.o(235204);
        return isLive;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void setCover(Bitmap bitmap) {
        AppMethodBeat.i(235205);
        this.mFc.setCover(bitmap);
        AppMethodBeat.o(235205);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void c(boolean z, String str, int i2) {
        AppMethodBeat.i(235206);
        this.mFc.c(z, str, i2);
        AppMethodBeat.o(235206);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void setVideoSource(int i2) {
        AppMethodBeat.i(235207);
        this.mFc.setVideoSource(i2);
        AppMethodBeat.o(235207);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void setVideoFooterView(e.b bVar) {
        AppMethodBeat.i(235208);
        this.mFc.setVideoFooterView(bVar);
        AppMethodBeat.o(235208);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void start() {
        AppMethodBeat.i(235209);
        this.mFc.start();
        AppMethodBeat.o(235209);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void stop() {
        AppMethodBeat.i(235210);
        this.mFc.stop();
        AppMethodBeat.o(235210);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final boolean pause() {
        AppMethodBeat.i(235211);
        boolean pause = this.mFc.pause();
        AppMethodBeat.o(235211);
        return pause;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void setMute(boolean z) {
        AppMethodBeat.i(235212);
        this.mFc.setMute(z);
        AppMethodBeat.o(235212);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void onUIResume() {
        AppMethodBeat.i(235213);
        this.mFc.onUIResume();
        AppMethodBeat.o(235213);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void onUIPause() {
        AppMethodBeat.i(235214);
        this.mFc.onUIPause();
        AppMethodBeat.o(235214);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void onUIDestroy() {
        AppMethodBeat.i(235215);
        this.mFc.onUIDestroy();
        AppMethodBeat.o(235215);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void setScaleType(e.h hVar) {
        AppMethodBeat.i(235216);
        this.mFc.setScaleType(hVar);
        AppMethodBeat.o(235216);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final void setIMMVideoViewCallback(e.c cVar) {
        AppMethodBeat.i(235217);
        this.mFc.setIMMVideoViewCallback(cVar);
        AppMethodBeat.o(235217);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.e
    public final boolean aO(float f2) {
        AppMethodBeat.i(235218);
        boolean aO = this.mFc.aO(f2);
        AppMethodBeat.o(235218);
        return aO;
    }
}
