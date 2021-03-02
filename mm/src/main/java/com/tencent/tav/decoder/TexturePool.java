package com.tencent.tav.decoder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.logger.Logger;
import java.util.ArrayList;
import java.util.List;

public class TexturePool implements ITexturePool {
    private static final String TAG = "TexturePool";
    private int MaxCacheLength = 60;
    private long MaxCacheSize = 207360000;
    private List<TextureInfo> textureInfoList = new ArrayList();

    public TexturePool() {
        AppMethodBeat.i(218283);
        Logger.d(TAG, "TexturePool: create " + Thread.currentThread().getId());
        AppMethodBeat.o(218283);
    }

    @Override // com.tencent.tav.decoder.ITexturePool
    public void setMaxCacheSize(long j2) {
        AppMethodBeat.i(218284);
        this.MaxCacheSize = j2;
        adaptCacheSize();
        AppMethodBeat.o(218284);
    }

    @Override // com.tencent.tav.decoder.ITexturePool
    public void setMaxCacheLength(int i2) {
        AppMethodBeat.i(218285);
        this.MaxCacheLength = i2;
        adapterCacheMemorySize();
        AppMethodBeat.o(218285);
    }

    @Override // com.tencent.tav.decoder.ITexturePool
    public synchronized TextureInfo popTexture(int i2, int i3, int i4) {
        TextureInfo textureInfo;
        int i5 = 0;
        synchronized (this) {
            AppMethodBeat.i(218286);
            while (true) {
                if (i5 >= this.textureInfoList.size()) {
                    int createTexture = RenderContext.createTexture(i2);
                    adaptCacheSize();
                    adapterCacheMemorySize();
                    textureInfo = new TextureInfo(createTexture, 3553, i3, i4, null, 0);
                    AppMethodBeat.o(218286);
                    break;
                }
                TextureInfo textureInfo2 = this.textureInfoList.get(i5);
                if (textureInfo2.textureType == i2 && textureInfo2.width == i3 && textureInfo2.height == i4) {
                    Logger.v(TAG, "popTexture: hint pool " + textureInfo2.textureID);
                    textureInfo = this.textureInfoList.remove(i5);
                    AppMethodBeat.o(218286);
                    break;
                }
                i5++;
            }
        }
        return textureInfo;
    }

    @Override // com.tencent.tav.decoder.ITexturePool
    public synchronized void pushTexture(TextureInfo textureInfo) {
        AppMethodBeat.i(218287);
        int i2 = 0;
        while (true) {
            if (i2 >= this.textureInfoList.size()) {
                Logger.v(TAG, "pushTexture: push in " + textureInfo.textureID + " - " + Thread.currentThread());
                this.textureInfoList.add(textureInfo);
                AppMethodBeat.o(218287);
                break;
            }
            TextureInfo textureInfo2 = this.textureInfoList.get(i2);
            if (textureInfo2.textureType == textureInfo.textureType && textureInfo2.textureID == textureInfo.textureID) {
                Logger.v(TAG, "pushTexture: hint pool  " + textureInfo2.textureID);
                textureInfo.release();
                AppMethodBeat.o(218287);
                break;
            }
            i2++;
        }
    }

    private synchronized void adaptCacheSize() {
        AppMethodBeat.i(218288);
        while (this.textureInfoList.size() > 0 && this.textureInfoList.size() - this.MaxCacheLength > 0) {
            this.textureInfoList.get(0).release();
            this.textureInfoList.remove(0);
        }
        AppMethodBeat.o(218288);
    }

    private synchronized void adapterCacheMemorySize() {
        int i2;
        AppMethodBeat.i(218289);
        long j2 = 0;
        int i3 = 0;
        while (i3 < this.textureInfoList.size()) {
            TextureInfo textureInfo = this.textureInfoList.get(i3);
            j2 += (long) (textureInfo.width * textureInfo.height);
            if (j2 > this.MaxCacheSize) {
                Logger.v(TAG, "texture: release " + textureInfo + " - " + Thread.currentThread());
                textureInfo.release();
                this.textureInfoList.remove(i3);
                i2 = i3 - 1;
            } else {
                i2 = i3;
            }
            i3 = i2 + 1;
        }
        AppMethodBeat.o(218289);
    }

    @Override // com.tencent.tav.decoder.ITexturePool
    public synchronized void release() {
        AppMethodBeat.i(218290);
        Logger.d(TAG, " release all " + Thread.currentThread().getId());
        for (int i2 = 0; i2 < this.textureInfoList.size(); i2++) {
            this.textureInfoList.get(i2).release();
        }
        AppMethodBeat.o(218290);
    }
}
