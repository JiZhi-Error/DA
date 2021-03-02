package com.tencent.mm.plugin.mmsight.segment.a;

import android.media.MediaPlayer;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.plugin.mmsight.segment.a.a;

public final class d implements a {
    private MediaPlayer jvF = new k();

    public d() {
        AppMethodBeat.i(107751);
        AppMethodBeat.o(107751);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void setSurface(Surface surface) {
        AppMethodBeat.i(107752);
        this.jvF.setSurface(surface);
        AppMethodBeat.o(107752);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void setDataSource(String str) {
        AppMethodBeat.i(107753);
        this.jvF.setDataSource(str);
        AppMethodBeat.o(107753);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void prepareAsync() {
        AppMethodBeat.i(107754);
        this.jvF.prepareAsync();
        AppMethodBeat.o(107754);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void start() {
        AppMethodBeat.i(107755);
        this.jvF.start();
        AppMethodBeat.o(107755);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void stop() {
        AppMethodBeat.i(107756);
        this.jvF.stop();
        AppMethodBeat.o(107756);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void pause() {
        AppMethodBeat.i(107757);
        this.jvF.pause();
        AppMethodBeat.o(107757);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final boolean isPlaying() {
        AppMethodBeat.i(107758);
        boolean isPlaying = this.jvF.isPlaying();
        AppMethodBeat.o(107758);
        return isPlaying;
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void seekTo(int i2) {
        AppMethodBeat.i(107759);
        this.jvF.seekTo(i2);
        AppMethodBeat.o(107759);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final int getCurrentPosition() {
        AppMethodBeat.i(107760);
        int currentPosition = this.jvF.getCurrentPosition();
        AppMethodBeat.o(107760);
        return currentPosition;
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final int getDuration() {
        AppMethodBeat.i(107761);
        int duration = this.jvF.getDuration();
        AppMethodBeat.o(107761);
        return duration;
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void release() {
        AppMethodBeat.i(107762);
        this.jvF.release();
        AppMethodBeat.o(107762);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void setAudioStreamType(int i2) {
        AppMethodBeat.i(107763);
        this.jvF.setAudioStreamType(i2);
        AppMethodBeat.o(107763);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void setLooping(boolean z) {
        AppMethodBeat.i(107764);
        this.jvF.setLooping(z);
        AppMethodBeat.o(107764);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void setLoop(int i2, int i3) {
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void a(final a.b bVar) {
        AppMethodBeat.i(107765);
        if (bVar == null) {
            this.jvF.setOnPreparedListener(null);
            AppMethodBeat.o(107765);
            return;
        }
        this.jvF.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            /* class com.tencent.mm.plugin.mmsight.segment.a.d.AnonymousClass1 */

            public final void onPrepared(MediaPlayer mediaPlayer) {
                AppMethodBeat.i(107747);
                bVar.dD(mediaPlayer);
                AppMethodBeat.o(107747);
            }
        });
        AppMethodBeat.o(107765);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void a(final a.c cVar) {
        AppMethodBeat.i(107766);
        if (cVar == null) {
            this.jvF.setOnSeekCompleteListener(null);
            AppMethodBeat.o(107766);
            return;
        }
        this.jvF.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() {
            /* class com.tencent.mm.plugin.mmsight.segment.a.d.AnonymousClass2 */

            public final void onSeekComplete(MediaPlayer mediaPlayer) {
                AppMethodBeat.i(107748);
                cVar.dE(mediaPlayer);
                AppMethodBeat.o(107748);
            }
        });
        AppMethodBeat.o(107766);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void a(final a.d dVar) {
        AppMethodBeat.i(107767);
        if (dVar == null) {
            this.jvF.setOnVideoSizeChangedListener(null);
            AppMethodBeat.o(107767);
            return;
        }
        this.jvF.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
            /* class com.tencent.mm.plugin.mmsight.segment.a.d.AnonymousClass3 */

            public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
                AppMethodBeat.i(107749);
                dVar.ap(i2, i3, 0);
                AppMethodBeat.o(107749);
            }
        });
        AppMethodBeat.o(107767);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void a(final a.AbstractC1482a aVar) {
        AppMethodBeat.i(107768);
        if (aVar == null) {
            this.jvF.setOnErrorListener(null);
            AppMethodBeat.o(107768);
            return;
        }
        this.jvF.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            /* class com.tencent.mm.plugin.mmsight.segment.a.d.AnonymousClass4 */

            public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                AppMethodBeat.i(107750);
                boolean hc = aVar.hc(i2, i3);
                AppMethodBeat.o(107750);
                return hc;
            }
        });
        AppMethodBeat.o(107768);
    }
}
