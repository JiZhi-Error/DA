package com.tencent.mm.plugin.emojicapture.api;

import android.content.Context;

public interface a extends com.tencent.mm.kernel.b.a {

    /* renamed from: com.tencent.mm.plugin.emojicapture.api.a$a  reason: collision with other inner class name */
    public interface AbstractC0965a {
        void ha(boolean z);
    }

    public interface b {
        void dQ(boolean z);
    }

    boolean isStickerEnable();

    void preCheck(Context context, int i2, AbstractC0965a aVar);

    void prepareEmojiCapture(Context context, String str, b bVar);

    void prepareStickerPreview(Context context, String str, b bVar);

    int stickerRecommendCount();
}
