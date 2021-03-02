package com.tencent.smtt.sdk;

import android.graphics.SurfaceTexture;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TbsMediaPlayer {

    /* renamed from: a  reason: collision with root package name */
    private r f1836a = null;

    public interface TbsMediaPlayerListener {
        public static final int MEDIA_EXTRA_AUDIOTRACK_INDEX = 104;
        public static final int MEDIA_EXTRA_AUDIOTRACK_TITLES = 103;
        public static final int MEDIA_EXTRA_SUBTITLE_COUNT = 101;
        public static final int MEDIA_EXTRA_SUBTITLE_INDEX = 102;
        public static final int MEDIA_INFO_BAD_INTERLEAVING = 800;
        public static final int MEDIA_INFO_BUFFERING_END = 702;
        public static final int MEDIA_INFO_BUFFERING_PERCENTAGE = 790;
        public static final int MEDIA_INFO_BUFFERING_START = 701;
        public static final int MEDIA_INFO_EXTERNAL_METADATA_UPDATE = 803;
        public static final int MEDIA_INFO_HAVE_VIDEO_DATA = 752;
        public static final int MEDIA_INFO_METADATA_UPDATE = 802;
        public static final int MEDIA_INFO_NETWORK_BANDWIDTH = 703;
        public static final int MEDIA_INFO_NOT_SEEKABLE = 801;
        public static final int MEDIA_INFO_NO_VIDEO_DATA = 751;
        public static final int MEDIA_INFO_SUBTITLE_TIMED_OUT = 902;
        public static final int MEDIA_INFO_TIMED_TEXT_ERROR = 900;
        public static final int MEDIA_INFO_UNSUPPORTED_SUBTITLE = 901;
        public static final int MEDIA_INFO_VIDEO_TRACK_LAGGING = 700;
        public static final int ROTATE_ACTION_HASROTATE = 3;
        public static final int ROTATE_ACTION_NOTHING = 1;
        public static final int ROTATE_ACTION_SETDEGREE = 2;
        public static final int ROTATE_ACTION_UNKNOWN = 0;

        void onBufferingUpdate(float f2);

        void onPlayerCompleted();

        void onPlayerError(String str, int i2, int i3, Throwable th);

        void onPlayerExtra(int i2, Object obj);

        void onPlayerInfo(int i2, int i3);

        void onPlayerPaused();

        void onPlayerPlaying();

        void onPlayerPrepared(long j2, int i2, int i3, int i4, int i5);

        void onPlayerProgress(long j2);

        void onPlayerSeeked(long j2);

        void onPlayerSubtitle(String str);
    }

    public TbsMediaPlayer(r rVar) {
        this.f1836a = rVar;
    }

    public boolean isAvailable() {
        AppMethodBeat.i(55151);
        boolean a2 = this.f1836a.a();
        AppMethodBeat.o(55151);
        return a2;
    }

    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(55152);
        this.f1836a.a(surfaceTexture);
        AppMethodBeat.o(55152);
    }

    public void setPlayerListener(TbsMediaPlayerListener tbsMediaPlayerListener) {
        AppMethodBeat.i(55153);
        this.f1836a.a(tbsMediaPlayerListener);
        AppMethodBeat.o(55153);
    }

    public float getVolume() {
        AppMethodBeat.i(55154);
        float b2 = this.f1836a.b();
        AppMethodBeat.o(55154);
        return b2;
    }

    public void setVolume(float f2) {
        AppMethodBeat.i(55155);
        this.f1836a.a(f2);
        AppMethodBeat.o(55155);
    }

    public void startPlay(String str, Bundle bundle) {
        AppMethodBeat.i(55156);
        this.f1836a.a(str, bundle);
        AppMethodBeat.o(55156);
    }

    public void subtitle(int i2) {
        AppMethodBeat.i(55157);
        this.f1836a.a(i2);
        AppMethodBeat.o(55157);
    }

    public void audio(int i2) {
        AppMethodBeat.i(55158);
        this.f1836a.b(i2);
        AppMethodBeat.o(55158);
    }

    public void pause() {
        AppMethodBeat.i(55159);
        this.f1836a.c();
        AppMethodBeat.o(55159);
    }

    public void play() {
        AppMethodBeat.i(55160);
        this.f1836a.d();
        AppMethodBeat.o(55160);
    }

    public void seek(long j2) {
        AppMethodBeat.i(55161);
        this.f1836a.a(j2);
        AppMethodBeat.o(55161);
    }

    public void close() {
        AppMethodBeat.i(55162);
        this.f1836a.e();
        AppMethodBeat.o(55162);
    }
}
