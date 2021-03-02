package com.tencent.thumbplayer.a.a;

import com.tencent.thumbplayer.api.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.TPCommonEnum;
import com.tencent.thumbplayer.api.TPPostProcessFrameBuffer;
import com.tencent.thumbplayer.api.TPSubtitleData;
import com.tencent.thumbplayer.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.api.TPVideoFrameBuffer;

public final class c {

    public interface a {
        void a(TPAudioFrameBuffer tPAudioFrameBuffer);
    }

    public interface b {
        TPPostProcessFrameBuffer b(TPPostProcessFrameBuffer tPPostProcessFrameBuffer);
    }

    /* renamed from: com.tencent.thumbplayer.a.a.c$c  reason: collision with other inner class name */
    public interface AbstractC2201c {
        void onCompletion();
    }

    public interface d {
        void a(@TPCommonEnum.TPErrorType int i2, int i3, long j2, long j3);
    }

    public interface e {
        void a(int i2, long j2, long j3, Object obj);
    }

    public interface f {
        void tf();
    }

    public interface g {
        void cJH();
    }

    public interface h {
        void onStateChange(int i2, int i3);
    }

    public interface i {
        void a(TPSubtitleData tPSubtitleData);
    }

    public interface j {
        void a(TPSubtitleFrameBuffer tPSubtitleFrameBuffer);
    }

    public interface k {
        void a(TPVideoFrameBuffer tPVideoFrameBuffer);
    }

    public interface l {
        TPPostProcessFrameBuffer a(TPPostProcessFrameBuffer tPPostProcessFrameBuffer);
    }

    public interface m {
        void aI(long j2, long j3);
    }
}
