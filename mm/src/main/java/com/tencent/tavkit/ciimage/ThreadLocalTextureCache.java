package com.tencent.tavkit.ciimage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.logger.Logger;
import java.util.HashMap;

public class ThreadLocalTextureCache {
    private static final ThreadLocal<ThreadLocalTextureCache> TEXTURE_CACHE = new ThreadLocal<ThreadLocalTextureCache>() {
        /* class com.tencent.tavkit.ciimage.ThreadLocalTextureCache.AnonymousClass1 */

        /* access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public final ThreadLocalTextureCache initialValue() {
            AppMethodBeat.i(197349);
            ThreadLocalTextureCache threadLocalTextureCache = new ThreadLocalTextureCache();
            AppMethodBeat.o(197349);
            return threadLocalTextureCache;
        }
    };
    private final String TAG;
    private final HashMap<String, TextureInfo> textureCache;

    static {
        AppMethodBeat.i(197357);
        AppMethodBeat.o(197357);
    }

    public static ThreadLocalTextureCache getInstance() {
        AppMethodBeat.i(197351);
        ThreadLocalTextureCache threadLocalTextureCache = TEXTURE_CACHE.get();
        AppMethodBeat.o(197351);
        return threadLocalTextureCache;
    }

    private ThreadLocalTextureCache() {
        AppMethodBeat.i(197352);
        this.TAG = "ThreadLocalTextureCache@" + Integer.toHexString(hashCode());
        Logger.d(this.TAG, "ThreadLocalTextureCache() called, thread = " + Thread.currentThread().getName());
        this.textureCache = new HashMap<>();
        AppMethodBeat.o(197352);
    }

    public synchronized void putTextureInfo(String str, TextureInfo textureInfo) {
        AppMethodBeat.i(197353);
        Logger.d(this.TAG, "putTextureInfo() called with: key = [" + str + "], textureInfo = [" + textureInfo + "]");
        this.textureCache.put(str, textureInfo);
        AppMethodBeat.o(197353);
    }

    public synchronized TextureInfo getTextureInfo(String str) {
        TextureInfo textureInfo;
        AppMethodBeat.i(197354);
        textureInfo = this.textureCache.get(str);
        AppMethodBeat.o(197354);
        return textureInfo;
    }

    public synchronized void remove(String str) {
        AppMethodBeat.i(197355);
        this.textureCache.remove(str);
        AppMethodBeat.o(197355);
    }

    public synchronized void release() {
        AppMethodBeat.i(197356);
        Logger.d(this.TAG, "release() called, textureCache = " + this.textureCache);
        for (TextureInfo textureInfo : this.textureCache.values()) {
            textureInfo.release();
        }
        this.textureCache.clear();
        AppMethodBeat.o(197356);
    }
}
