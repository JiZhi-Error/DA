package com.tencent.tav.decoder.decodecache;

import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.ITexturePool;

/* access modifiers changed from: package-private */
public class CacheFrame {
    public CMTime frameTime = CMTime.CMTimeInvalid;
    public CMTime realFrameTime = CMTime.CMTimeInvalid;
    public CMSampleBuffer sampleBuffer = null;
    public ITexturePool texturePool;

    CacheFrame() {
    }
}
