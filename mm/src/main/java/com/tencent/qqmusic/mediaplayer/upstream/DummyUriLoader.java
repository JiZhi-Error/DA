package com.tencent.qqmusic.mediaplayer.upstream;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.upstream.UriLoader;
import java.util.concurrent.TimeUnit;

public class DummyUriLoader implements UriLoader {
    private final Uri uri;

    public DummyUriLoader() {
        this(null);
    }

    public DummyUriLoader(Uri uri2) {
        this.uri = uri2;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.UriLoader
    public void startLoading(int i2, TimeUnit timeUnit, UriLoader.Callback callback) {
        AppMethodBeat.i(76496);
        if (this.uri == null) {
            callback.onSucceed(null);
            AppMethodBeat.o(76496);
            return;
        }
        callback.onSucceed(new StreamingRequest(this.uri, null));
        AppMethodBeat.o(76496);
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.UriLoader
    public boolean isLoading() {
        return false;
    }

    @Override // com.tencent.qqmusic.mediaplayer.upstream.UriLoader
    public void cancelLoading() {
    }
}
