package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.graphics.Bitmap;

public interface j {

    public interface a {
        void eo(int i2, int i3);

        int fh(int i2, int i3);

        void onCompletion();

        void onError(int i2, int i3);

        void tf();
    }

    public interface b {
        void ep(int i2, int i3);
    }

    public interface c {
        void fN(boolean z);
    }

    public interface d {
        void bgX();
    }

    public interface e {
        void bLh();
    }

    boolean E(Context context, boolean z);

    void d(double d2, boolean z);

    int getCurrentPosition();

    int getDuration();

    double getLastProgresstime();

    long getLastSurfaceUpdateTime();

    String getVideoPath();

    boolean isPlaying();

    void onDetach();

    void pause();

    void q(double d2);

    void setLoop(boolean z);

    void setMute(boolean z);

    void setOnInfoCallback(b bVar);

    void setOnSeekCompleteCallback(c cVar);

    void setOnSurfaceCallback(d dVar);

    void setOneTimeVideoTextureUpdateCallback(e eVar);

    void setPlayProgressCallback(boolean z);

    void setThumb(Bitmap bitmap);

    void setVideoCallback(a aVar);

    void setVideoPath(String str);

    boolean start();

    void stop();
}
