package com.tencent.tav.decoder;

import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.coremedia.CMSampleState;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.TextureInfo;
import java.nio.ByteBuffer;

public class CacheSampleBuffer extends CMSampleBuffer {
    private VideoTexture texture;

    public CacheSampleBuffer(CMSampleState cMSampleState) {
        super(cMSampleState);
    }

    public CacheSampleBuffer(CMSampleState cMSampleState, TextureInfo textureInfo) {
        super(cMSampleState, textureInfo);
    }

    public CacheSampleBuffer(CMSampleState cMSampleState, TextureInfo textureInfo, boolean z) {
        super(cMSampleState, textureInfo, z);
    }

    public CacheSampleBuffer(CMSampleState cMSampleState, ByteBuffer byteBuffer) {
        super(cMSampleState, byteBuffer);
    }

    public CacheSampleBuffer(CMSampleState cMSampleState, ByteBuffer byteBuffer, boolean z) {
        super(cMSampleState, byteBuffer, z);
    }

    public CacheSampleBuffer(CMTime cMTime) {
        super(cMTime);
    }

    public CacheSampleBuffer(CMTime cMTime, TextureInfo textureInfo) {
        super(cMTime, textureInfo);
    }

    public CacheSampleBuffer(CMTime cMTime, TextureInfo textureInfo, boolean z) {
        super(cMTime, textureInfo, z);
    }

    public CacheSampleBuffer(CMTime cMTime, ByteBuffer byteBuffer) {
        super(cMTime, byteBuffer);
    }

    public CacheSampleBuffer(CMTime cMTime, ByteBuffer byteBuffer, boolean z) {
        super(cMTime, byteBuffer, z);
    }

    public VideoTexture getTexture() {
        return this.texture;
    }

    public void setTexture(VideoTexture videoTexture) {
        this.texture = videoTexture;
    }
}
