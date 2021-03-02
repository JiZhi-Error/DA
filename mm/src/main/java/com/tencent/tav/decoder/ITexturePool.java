package com.tencent.tav.decoder;

import com.tencent.tav.coremedia.TextureInfo;

public interface ITexturePool {
    TextureInfo popTexture(int i2, int i3, int i4);

    void pushTexture(TextureInfo textureInfo);

    void release();

    void setMaxCacheLength(int i2);

    void setMaxCacheSize(long j2);
}
