package com.tencent.mm.plugin.mmsight.segment.a;

import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.segment.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.storage.ar;

public final class c implements a {
    private MTimerHandler jer;
    boolean released;
    int zAo;
    int zAp;
    private a zAv;
    a.c zAw = null;
    private a.c zAx = new a.c() {
        /* class com.tencent.mm.plugin.mmsight.segment.a.c.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.mmsight.segment.a.a.c
        public final void dE(Object obj) {
            AppMethodBeat.i(107726);
            if (c.this.zAw != null) {
                c.this.zAw.dE(obj);
            }
            AppMethodBeat.o(107726);
        }
    };
    private MTimerHandler.CallBack zAy = new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.mmsight.segment.a.c.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(107727);
            if (c.this.released) {
                AppMethodBeat.o(107727);
                return false;
            }
            try {
                if (!c.this.isPlaying()) {
                    AppMethodBeat.o(107727);
                    return true;
                }
                int currentPosition = c.this.getCurrentPosition();
                if (c.this.zzX != null) {
                    c.this.zzX.QR(currentPosition);
                }
                Log.d("MicroMsg.SectionRepeatMediaPlayer", "position[%d] repeat[%d, %d] duration[%d]", Integer.valueOf(currentPosition), Integer.valueOf(c.this.zAo), Integer.valueOf(c.this.zAp), Integer.valueOf(c.this.getDuration()));
                if (currentPosition < c.this.zAp) {
                    AppMethodBeat.o(107727);
                    return true;
                }
                Log.i("MicroMsg.SectionRepeatMediaPlayer", "reach repeat end time, seek to %s", Integer.valueOf(c.this.zAp));
                c.this.seekTo(c.this.zAo);
                AppMethodBeat.o(107727);
                return false;
            } catch (IllegalStateException e2) {
                Log.e("MicroMsg.SectionRepeatMediaPlayer", "MediaPlayer may be released. %s", e2.getMessage());
                if (!c.this.released) {
                    AppMethodBeat.o(107727);
                    return true;
                }
                AppMethodBeat.o(107727);
                return false;
            }
        }
    };
    public a zzX;

    public interface a {
        void QR(int i2);
    }

    public c() {
        AppMethodBeat.i(107728);
        int i2 = CaptureMMProxy.getInstance().getInt(ar.a.USERINFO_LOCAL_SIGHT_CLIP_PREVIEW_MEDIA_PLAYER_INT_SYNC, -1);
        if (i2 == 1) {
            Log.i("MicroMsg.SectionRepeatMediaPlayer", "used system media player");
            this.zAv = new d();
        } else if (i2 == 2) {
            Log.i("MicroMsg.SectionRepeatMediaPlayer", "used mm video player");
            this.zAv = new b();
        } else if (CaptureMMProxy.getInstance().checkUseMMVideoPlayer()) {
            Log.i("MicroMsg.SectionRepeatMediaPlayer", "default used mm video player");
            this.zAv = new b();
        } else {
            Log.i("MicroMsg.SectionRepeatMediaPlayer", "default used system media player");
            this.zAv = new d();
        }
        this.jer = new MTimerHandler("check auto job", this.zAy, true);
        AppMethodBeat.o(107728);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void setLoop(int i2, int i3) {
        AppMethodBeat.i(107729);
        this.zAo = i2;
        this.zAp = i3;
        if (this.zAv != null) {
            this.zAv.setLoop(this.zAo, this.zAp);
        }
        AppMethodBeat.o(107729);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void setDataSource(String str) {
        AppMethodBeat.i(107730);
        this.zAv.setDataSource(str);
        AppMethodBeat.o(107730);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void release() {
        AppMethodBeat.i(107731);
        this.released = true;
        this.zAv.release();
        if (this.jer != null) {
            this.jer.stopTimer();
            this.jer.quit();
        }
        AppMethodBeat.o(107731);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void start() {
        AppMethodBeat.i(107732);
        this.zAv.start();
        this.jer.startTimer(30);
        AppMethodBeat.o(107732);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void pause() {
        AppMethodBeat.i(107733);
        this.zAv.pause();
        this.jer.stopTimer();
        AppMethodBeat.o(107733);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void stop() {
        AppMethodBeat.i(107734);
        this.zAv.stop();
        this.jer.stopTimer();
        AppMethodBeat.o(107734);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void a(a.c cVar) {
        AppMethodBeat.i(107735);
        this.zAv.a(cVar);
        AppMethodBeat.o(107735);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void setAudioStreamType(int i2) {
        AppMethodBeat.i(107736);
        this.zAv.setAudioStreamType(i2);
        AppMethodBeat.o(107736);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final int getCurrentPosition() {
        AppMethodBeat.i(107737);
        int currentPosition = this.zAv.getCurrentPosition();
        AppMethodBeat.o(107737);
        return currentPosition;
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final int getDuration() {
        AppMethodBeat.i(107738);
        if (this.zAv != null) {
            int duration = this.zAv.getDuration();
            AppMethodBeat.o(107738);
            return duration;
        }
        AppMethodBeat.o(107738);
        return 0;
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void setSurface(Surface surface) {
        AppMethodBeat.i(107739);
        this.zAv.setSurface(surface);
        AppMethodBeat.o(107739);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final boolean isPlaying() {
        AppMethodBeat.i(107740);
        boolean isPlaying = this.zAv.isPlaying();
        AppMethodBeat.o(107740);
        return isPlaying;
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void seekTo(int i2) {
        AppMethodBeat.i(107741);
        this.zAv.seekTo(i2);
        AppMethodBeat.o(107741);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void prepareAsync() {
        AppMethodBeat.i(107742);
        this.zAv.prepareAsync();
        AppMethodBeat.o(107742);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void setLooping(boolean z) {
        AppMethodBeat.i(107743);
        this.zAv.setLooping(z);
        AppMethodBeat.o(107743);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void a(a.AbstractC1482a aVar) {
        AppMethodBeat.i(107744);
        this.zAv.a(aVar);
        AppMethodBeat.o(107744);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void a(a.d dVar) {
        AppMethodBeat.i(107745);
        this.zAv.a(dVar);
        AppMethodBeat.o(107745);
    }

    @Override // com.tencent.mm.plugin.mmsight.segment.a.a
    public final void a(a.b bVar) {
        AppMethodBeat.i(107746);
        this.zAv.a(bVar);
        AppMethodBeat.o(107746);
    }
}
