package com.tencent.mm.plugin.appbrand.jsapi.video.videoview;

public interface a {

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.videoview.a$a  reason: collision with other inner class name */
    public interface AbstractC0719a {
        void eo(int i2, int i3);

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

    void d(double d2, boolean z);

    int getCurrentPosition();

    int getDuration();

    String getVideoPath();

    boolean isPlaying();

    void pause();

    void q(double d2);

    void setMute(boolean z);

    void setOnInfoCallback(b bVar);

    void setOnSeekCompleteCallback(c cVar);

    void setOnSurfaceCallback(d dVar);

    void setOneTimeVideoTextureUpdateCallback(e eVar);

    void setVideoCallback(AbstractC0719a aVar);

    void setVideoPath(String str);

    boolean start();

    void stop();
}
