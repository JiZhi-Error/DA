package com.tencent.mm.plugin.music.f;

import android.media.MediaPlayer;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.tav.core.AssetExtension;

public final class b extends com.tencent.mm.plugin.music.f.a.b {
    a AlO;
    MediaPlayer jvF;
    boolean stop = true;

    public b() {
        AppMethodBeat.i(137303);
        com.tencent.mm.plugin.music.e.b bVar = (com.tencent.mm.plugin.music.e.b) com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.e.b.class);
        if (bVar != null) {
            this.jvF = bVar.etV();
        } else {
            Log.e("MicroMsg.Music.MMMediaPlayer", "mediaResService is null");
        }
        if (this.jvF == null) {
            this.jvF = new MediaPlayer();
        }
        this.jvF.setAudioStreamType(3);
        this.jvF.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            /* class com.tencent.mm.plugin.music.f.b.AnonymousClass1 */

            public final void onCompletion(MediaPlayer mediaPlayer) {
                AppMethodBeat.i(137298);
                Log.e("MicroMsg.Music.MMMediaPlayer", "onCompletion, stop music");
                b.this.so(true);
                AppMethodBeat.o(137298);
            }
        });
        this.jvF.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() {
            /* class com.tencent.mm.plugin.music.f.b.AnonymousClass2 */

            public final void onSeekComplete(MediaPlayer mediaPlayer) {
                AppMethodBeat.i(137299);
                if (b.this.jvF != null && b.this.jvF.isPlaying()) {
                    Log.i("MicroMsg.Music.MMMediaPlayer", "onSeekComplete");
                    try {
                        b.this.jvF.start();
                        AppMethodBeat.o(137299);
                        return;
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e2, "start", new Object[0]);
                    }
                }
                AppMethodBeat.o(137299);
            }
        });
        this.jvF.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            /* class com.tencent.mm.plugin.music.f.b.AnonymousClass3 */

            public final void onPrepared(MediaPlayer mediaPlayer) {
                AppMethodBeat.i(137300);
                if (b.this.jvF != null) {
                    Log.i("MicroMsg.Music.MMMediaPlayer", "onPrepared");
                    try {
                        b.this.jvF.start();
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e2, "start", new Object[0]);
                    }
                    b.this.stop = false;
                    b.this.onStart();
                    if (b.this.AlO != null) {
                        b.this.AlO.isStop = true;
                    }
                    b.this.AlO = new a(b.this, (byte) 0);
                    a aVar = b.this.AlO;
                    aVar.isStop = false;
                    ThreadPool.post(aVar, "music_play_progress_runnable");
                }
                AppMethodBeat.o(137300);
            }
        });
        this.jvF.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            /* class com.tencent.mm.plugin.music.f.b.AnonymousClass4 */

            public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
                AppMethodBeat.i(137301);
                Log.e("MicroMsg.Music.MMMediaPlayer", "onError, what:%d, extra:%d", Integer.valueOf(i2), Integer.valueOf(i3));
                b.this.sn(false);
                AppMethodBeat.o(137301);
                return false;
            }
        });
        AppMethodBeat.o(137303);
    }

    @Override // com.tencent.mm.plugin.music.f.a.b
    public final boolean isPlaying() {
        boolean z = false;
        AppMethodBeat.i(137304);
        try {
            z = this.jvF.isPlaying();
            AppMethodBeat.o(137304);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e2, "setSourcePath", new Object[0]);
            AppMethodBeat.o(137304);
        }
        return z;
    }

    @Override // com.tencent.mm.plugin.music.f.a.b
    public final boolean euR() {
        return !this.stop;
    }

    @Override // com.tencent.mm.plugin.music.f.a.b
    public final void aHY(String str) {
        AppMethodBeat.i(137305);
        Log.i("MicroMsg.Music.MMMediaPlayer", "setSourcePath, sourcePath:%s", str);
        try {
            this.jvF.setDataSource(str);
            AppMethodBeat.o(137305);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e2, "setSourcePath", new Object[0]);
            AppMethodBeat.o(137305);
        }
    }

    @Override // com.tencent.mm.plugin.music.f.a.b
    public final int euS() {
        int i2 = 0;
        AppMethodBeat.i(137306);
        try {
            i2 = this.jvF.getCurrentPosition();
            AppMethodBeat.o(137306);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e2, "getCurrentPos", new Object[0]);
            AppMethodBeat.o(137306);
        }
        return i2;
    }

    @Override // com.tencent.mm.plugin.music.f.a.b
    public final int getDuration() {
        int i2 = 0;
        AppMethodBeat.i(137307);
        try {
            i2 = this.jvF.getDuration();
            AppMethodBeat.o(137307);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e2, "getDuration", new Object[0]);
            AppMethodBeat.o(137307);
        }
        return i2;
    }

    @Override // com.tencent.mm.plugin.music.f.a.b
    public final void play() {
        AppMethodBeat.i(137308);
        Log.i("MicroMsg.Music.MMMediaPlayer", AssetExtension.SCENE_PLAY);
        if (euR()) {
            try {
                if (!this.jvF.isPlaying()) {
                    this.jvF.start();
                    AppMethodBeat.o(137308);
                    return;
                }
                AppMethodBeat.o(137308);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e2, "start", new Object[0]);
                AppMethodBeat.o(137308);
            }
        } else {
            try {
                this.jvF.prepareAsync();
                AppMethodBeat.o(137308);
            } catch (Exception e3) {
                Log.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e3, "prepareAsync", new Object[0]);
                AppMethodBeat.o(137308);
            }
        }
    }

    @Override // com.tencent.mm.plugin.music.f.a.b
    public final void stop() {
        AppMethodBeat.i(137309);
        Log.i("MicroMsg.Music.MMMediaPlayer", "stop");
        this.stop = true;
        try {
            if (this.jvF != null) {
                this.jvF.stop();
                this.jvF.release();
            }
            if (this.AlO != null) {
                this.AlO.isStop = true;
                this.AlO = null;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e2, "stop", new Object[0]);
        }
        so(false);
        AppMethodBeat.o(137309);
    }

    @Override // com.tencent.mm.plugin.music.f.a.b
    public final void pause() {
        AppMethodBeat.i(137310);
        Log.i("MicroMsg.Music.MMMediaPlayer", "pause");
        if (!euR()) {
            AppMethodBeat.o(137310);
            return;
        }
        this.jvF.pause();
        AppMethodBeat.o(137310);
    }

    @Override // com.tencent.mm.plugin.music.f.a.b
    public final void seek(long j2) {
        AppMethodBeat.i(137311);
        Log.i("MicroMsg.Music.MMMediaPlayer", "seek %d", Long.valueOf(j2));
        this.jvF.seekTo((int) j2);
        AppMethodBeat.o(137311);
    }

    class a implements Runnable {
        boolean isStop;

        private a() {
            this.isStop = true;
        }

        /* synthetic */ a(b bVar, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(137302);
            Log.i("MicroMsg.Music.MMMediaPlayer", "start run play progress task");
            while (!this.isStop) {
                try {
                    if (b.this.jvF != null && b.this.jvF.isPlaying()) {
                        int currentPosition = b.this.jvF.getCurrentPosition();
                        int duration = b.this.jvF.getDuration();
                        if (currentPosition > 0 && duration > 0) {
                            b.this.Tb((currentPosition * 100) / duration);
                        }
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e2, "onPlayUpdate", new Object[0]);
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e3) {
                    Log.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e3, "sleep", new Object[0]);
                }
            }
            AppMethodBeat.o(137302);
        }
    }

    @Override // com.tencent.mm.plugin.music.f.a.b
    public final String ZV() {
        return null;
    }
}
