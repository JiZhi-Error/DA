package com.tencent.tav.decoder.decodecache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import java.util.ArrayList;
import java.util.List;

/* access modifiers changed from: package-private */
public class CacheSegment {
    public volatile List<CacheFrame> cacheFrameList = new ArrayList();
    public volatile CMTimeRange segmentTimeRange = null;

    CacheSegment(CMTimeRange cMTimeRange) {
        AppMethodBeat.i(218394);
        this.segmentTimeRange = cMTimeRange;
        AppMethodBeat.o(218394);
    }

    /* access modifiers changed from: package-private */
    public CacheFrame popFrame(CMTime cMTime) {
        AppMethodBeat.i(218395);
        while (this.cacheFrameList.size() > 0) {
            CacheFrame cacheFrame = this.cacheFrameList.get(0);
            if (!cacheFrame.frameTime.smallThan(cMTime)) {
                CacheFrame cacheFrame2 = this.cacheFrameList.get(0);
                AppMethodBeat.o(218395);
                return cacheFrame2;
            }
            if (isCacheFrameUsable(cacheFrame)) {
                if (cacheFrame.texturePool == null) {
                    cacheFrame.sampleBuffer.getTextureInfo().release();
                } else {
                    cacheFrame.texturePool.pushTexture(cacheFrame.sampleBuffer.getTextureInfo());
                }
                cacheFrame.sampleBuffer = null;
            }
            this.cacheFrameList.remove(0);
        }
        AppMethodBeat.o(218395);
        return null;
    }

    private boolean isCacheFrameUsable(CacheFrame cacheFrame) {
        AppMethodBeat.i(218396);
        if (cacheFrame.sampleBuffer == null || cacheFrame.sampleBuffer.getTextureInfo() == null) {
            AppMethodBeat.o(218396);
            return false;
        }
        AppMethodBeat.o(218396);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void pushFrame(CacheFrame cacheFrame) {
        AppMethodBeat.i(218397);
        for (int i2 = 0; i2 < this.cacheFrameList.size(); i2++) {
            if (this.cacheFrameList.get(i2).frameTime.bigThan(cacheFrame.frameTime)) {
                this.cacheFrameList.add(i2, cacheFrame);
                AppMethodBeat.o(218397);
                return;
            }
        }
        this.cacheFrameList.add(cacheFrame);
        AppMethodBeat.o(218397);
    }

    public void clear() {
        AppMethodBeat.i(218398);
        for (CacheFrame cacheFrame : this.cacheFrameList) {
            if (isCacheFrameUsable(cacheFrame)) {
                cacheFrame.texturePool.pushTexture(cacheFrame.sampleBuffer.getTextureInfo());
                cacheFrame.sampleBuffer = null;
            }
        }
        this.cacheFrameList.clear();
        AppMethodBeat.o(218398);
    }

    /* access modifiers changed from: package-private */
    public CMTime getLastFrameTime() {
        AppMethodBeat.i(218399);
        if (this.cacheFrameList.size() > 0) {
            CMTime cMTime = this.cacheFrameList.get(this.cacheFrameList.size() - 1).frameTime;
            AppMethodBeat.o(218399);
            return cMTime;
        }
        CMTime end = this.segmentTimeRange.getEnd();
        AppMethodBeat.o(218399);
        return end;
    }
}
