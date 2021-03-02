package com.tencent.luggage.game.b.a;

import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.tencent.luggage.game.b.a.c.a;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class c<T extends a> implements com.github.henryye.nativeiv.b.b {

    public interface a {
        String LR();
    }

    public interface b extends a {
        q getFileSystem();
    }

    /* renamed from: com.tencent.luggage.game.b.a.c$c  reason: collision with other inner class name */
    public interface AbstractC0167c extends a {
        int LS();

        int LU();

        String a(ImageDecodeConfig.ReferrerPolicy referrerPolicy);

        String getUserAgentString();
    }

    c(T t) {
        Log.i("MicroMsg.BaseImageStreamFetcherWxa", "hy: construct fetcher with config %s env %s", t.getClass().getSimpleName(), t.LR());
    }
}
