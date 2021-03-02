package com.tencent.thumbplayer.a.a.a;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.utils.g;
import java.io.FileDescriptor;
import java.util.Map;

public final class b extends MediaPlayer {
    /* access modifiers changed from: protected */
    @Override // java.lang.Object
    public final void finalize() {
        AppMethodBeat.i(188748);
        try {
            super.finalize();
            AppMethodBeat.o(188748);
        } catch (Exception e2) {
            g.e("TPThumbPlayer[TPMediaPlayer.java]", e2);
            AppMethodBeat.o(188748);
        }
    }

    public final void release() {
        AppMethodBeat.i(188749);
        try {
            if ("N1W".equalsIgnoreCase(Build.MODEL) || "X909T".equalsIgnoreCase(Build.MODEL) || "X909".equalsIgnoreCase(Build.MODEL) || "N1T".equalsIgnoreCase(Build.MODEL)) {
                super.setOnPreparedListener(null);
                super.setOnCompletionListener(null);
                super.setOnErrorListener(null);
                super.setOnInfoListener(null);
                super.setOnBufferingUpdateListener(null);
                super.setOnSeekCompleteListener(null);
                super.setOnVideoSizeChangedListener(null);
                ((Handler) super.getClass().getDeclaredField("mA2dpHandler").get(this)).removeCallbacksAndMessages(null);
            }
        } catch (NoSuchFieldException e2) {
            g.e("TPThumbPlayer[TPMediaPlayer.java]", e2);
        } catch (IllegalAccessException e3) {
            g.e("TPThumbPlayer[TPMediaPlayer.java]", e3);
        }
        try {
            super.release();
            AppMethodBeat.o(188749);
        } catch (Exception e4) {
            g.e("TPThumbPlayer[TPMediaPlayer.java]", e4);
            AppMethodBeat.o(188749);
        }
    }

    public final void setDisplay(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(188750);
        try {
            super.setDisplay(surfaceHolder);
            AppMethodBeat.o(188750);
        } catch (Exception e2) {
            g.e("TPThumbPlayer[TPMediaPlayer.java]", e2);
            AppMethodBeat.o(188750);
        }
    }

    public final int getVideoWidth() {
        AppMethodBeat.i(188751);
        int i2 = 0;
        try {
            i2 = super.getVideoWidth();
        } catch (Exception e2) {
            g.e("TPThumbPlayer[TPMediaPlayer.java]", e2);
        }
        AppMethodBeat.o(188751);
        return i2;
    }

    public final int getVideoHeight() {
        AppMethodBeat.i(188752);
        int i2 = 0;
        try {
            i2 = super.getVideoHeight();
        } catch (Exception e2) {
            g.e("TPThumbPlayer[TPMediaPlayer.java]", e2);
        }
        AppMethodBeat.o(188752);
        return i2;
    }

    public final void setSurface(Surface surface) {
        AppMethodBeat.i(188753);
        try {
            super.setSurface(surface);
            AppMethodBeat.o(188753);
        } catch (Exception e2) {
            g.e("TPThumbPlayer[TPMediaPlayer.java]", e2);
            AppMethodBeat.o(188753);
        }
    }

    public final void reset() {
        AppMethodBeat.i(188754);
        try {
            super.reset();
            AppMethodBeat.o(188754);
        } catch (Exception e2) {
            g.e("TPThumbPlayer[TPMediaPlayer.java]", e2);
            AppMethodBeat.o(188754);
        }
    }

    @Override // android.media.MediaPlayer
    public final void stop() {
        AppMethodBeat.i(188755);
        try {
            super.stop();
            AppMethodBeat.o(188755);
        } catch (Exception e2) {
            g.e("TPThumbPlayer[TPMediaPlayer.java]", e2);
            AppMethodBeat.o(188755);
        }
    }

    @Override // android.media.MediaPlayer
    public final void prepare() {
        AppMethodBeat.i(188756);
        try {
            super.prepare();
            AppMethodBeat.o(188756);
        } catch (Exception e2) {
            g.e("TPThumbPlayer[TPMediaPlayer.java]", e2);
            AppMethodBeat.o(188756);
        }
    }

    @Override // android.media.MediaPlayer
    public final void setDataSource(Context context, Uri uri) {
        AppMethodBeat.i(188757);
        try {
            super.setDataSource(context, uri);
            AppMethodBeat.o(188757);
        } catch (Exception e2) {
            g.e("TPThumbPlayer[TPMediaPlayer.java]", e2);
            AppMethodBeat.o(188757);
        }
    }

    @Override // android.media.MediaPlayer
    public final void setDataSource(FileDescriptor fileDescriptor) {
        AppMethodBeat.i(188758);
        try {
            super.setDataSource(fileDescriptor);
            AppMethodBeat.o(188758);
        } catch (Exception e2) {
            g.e("TPThumbPlayer[TPMediaPlayer.java]", e2);
            AppMethodBeat.o(188758);
        }
    }

    public final int getCurrentPosition() {
        AppMethodBeat.i(188759);
        try {
            int currentPosition = super.getCurrentPosition();
            AppMethodBeat.o(188759);
            return currentPosition;
        } catch (Exception e2) {
            g.e("TPThumbPlayer[TPMediaPlayer.java]", e2);
            AppMethodBeat.o(188759);
            return 0;
        }
    }

    public final int getDuration() {
        AppMethodBeat.i(188760);
        try {
            int duration = super.getDuration();
            AppMethodBeat.o(188760);
            return duration;
        } catch (Exception e2) {
            g.e("TPThumbPlayer[TPMediaPlayer.java]", e2);
            AppMethodBeat.o(188760);
            return 0;
        }
    }

    @Override // android.media.MediaPlayer
    public final int getSelectedTrack(int i2) {
        AppMethodBeat.i(188761);
        try {
            int selectedTrack = super.getSelectedTrack(i2);
            AppMethodBeat.o(188761);
            return selectedTrack;
        } catch (Exception e2) {
            g.e("TPThumbPlayer[TPMediaPlayer.java]", e2);
            AppMethodBeat.o(188761);
            return 0;
        }
    }

    @Override // android.media.MediaPlayer
    public final MediaPlayer.TrackInfo[] getTrackInfo() {
        AppMethodBeat.i(188762);
        try {
            MediaPlayer.TrackInfo[] trackInfo = super.getTrackInfo();
            AppMethodBeat.o(188762);
            return trackInfo;
        } catch (Exception e2) {
            g.e("TPThumbPlayer[TPMediaPlayer.java]", e2);
            MediaPlayer.TrackInfo[] trackInfoArr = new MediaPlayer.TrackInfo[0];
            AppMethodBeat.o(188762);
            return trackInfoArr;
        }
    }

    @Override // android.media.MediaPlayer
    public final void setDataSource(Context context, Uri uri, Map<String, String> map) {
        AppMethodBeat.i(188763);
        try {
            super.setDataSource(context, uri, map);
            AppMethodBeat.o(188763);
        } catch (Exception e2) {
            g.e("TPThumbPlayer[TPMediaPlayer.java]", e2);
            AppMethodBeat.o(188763);
        }
    }

    public final void setLooping(boolean z) {
        AppMethodBeat.i(188764);
        try {
            super.setLooping(z);
            AppMethodBeat.o(188764);
        } catch (Exception e2) {
            g.e("TPThumbPlayer[TPMediaPlayer.java]", e2);
            AppMethodBeat.o(188764);
        }
    }

    public final void setPlaybackParams(PlaybackParams playbackParams) {
        AppMethodBeat.i(188765);
        try {
            super.setPlaybackParams(playbackParams);
            AppMethodBeat.o(188765);
        } catch (Exception e2) {
            g.e("TPThumbPlayer[TPMediaPlayer.java]", e2);
            AppMethodBeat.o(188765);
        }
    }

    public final void setVolume(float f2, float f3) {
        AppMethodBeat.i(188766);
        try {
            super.setVolume(f2, f3);
            AppMethodBeat.o(188766);
        } catch (Exception e2) {
            g.e("TPThumbPlayer[TPMediaPlayer.java]", e2);
            AppMethodBeat.o(188766);
        }
    }
}
