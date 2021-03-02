package com.tencent.qqmusic.mediaplayer.upstream;

import java.io.IOException;

public interface Loader {

    public interface Factory {
        Loader createLoader(Listener listener);
    }

    public interface Listener {
        void onLoadCancelled(boolean z);

        void onLoadCompleted();

        void onLoadError(IOException iOException);

        void onLoadProgress(long j2, long j3);
    }

    void cancelLoading();

    long getUpstreamSize();

    boolean isLoading();

    void prepare();

    void shutdown();

    void startLoading(Chunk chunk);
}
