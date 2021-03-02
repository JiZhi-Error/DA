package com.tencent.mm.plugin.music.f;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import com.tencent.mm.plugin.music.f.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.tav.core.AssetExtension;

@TargetApi(16)
public final class c extends b {
    AudioTrack bfn;
    int channels = 0;
    long duration = 0;
    int dvm = 0;
    z dvz;
    com.tencent.mm.compatible.i.c jto;
    String mime = null;
    long presentationTimeUs = 0;
    int sampleRate = 0;
    String sourcePath;
    private boolean stop = true;
    private Runnable wgK = new Runnable() {
        /* class com.tencent.mm.plugin.music.f.c.AnonymousClass1 */

        /* JADX WARNING: Removed duplicated region for block: B:49:0x0240 A[Catch:{ Exception -> 0x04bd, all -> 0x051d }] */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x039d  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            // Method dump skipped, instructions count: 1385
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.music.f.c.AnonymousClass1.run():void");
        }
    };

    public c() {
        AppMethodBeat.i(137313);
        AppMethodBeat.o(137313);
    }

    @Override // com.tencent.mm.plugin.music.f.a.b
    public final void aHY(String str) {
        this.sourcePath = str;
    }

    /* access modifiers changed from: package-private */
    public final boolean createAudioTrack() {
        AppMethodBeat.i(137314);
        Log.i("MicroMsg.Music.MMPlayer", "createAudioTrack");
        int i2 = this.channels == 1 ? 4 : 12;
        int minBufferSize = AudioTrack.getMinBufferSize(this.sampleRate, i2, 2);
        com.tencent.mm.plugin.music.e.b bVar = (com.tencent.mm.plugin.music.e.b) com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.e.b.class);
        if (bVar != null) {
            this.bfn = bVar.as(this.sampleRate, i2, minBufferSize);
        } else {
            Log.e("MicroMsg.Music.MMPlayer", "mediaResService null");
        }
        if (this.bfn == null) {
            Log.e("MicroMsg.Music.MMPlayer", "audioTrack is null, new AudioTrack");
            this.bfn = new AudioTrack(3, this.sampleRate, i2, 2, minBufferSize, 1);
        }
        if (this.bfn == null || this.bfn.getState() != 1) {
            Log.e("MicroMsg.Music.MMPlayer", "audio track not initialized");
            if (this.bfn != null) {
                try {
                    this.bfn.release();
                } catch (Exception e2) {
                }
            }
            AppMethodBeat.o(137314);
            return false;
        }
        AppMethodBeat.o(137314);
        return true;
    }

    @Override // com.tencent.mm.plugin.music.f.a.b
    public final int euS() {
        return (int) (this.presentationTimeUs / 1000);
    }

    @Override // com.tencent.mm.plugin.music.f.a.b
    public final int getDuration() {
        return (int) (this.duration / 1000);
    }

    @Override // com.tencent.mm.plugin.music.f.a.b
    public final void play() {
        AppMethodBeat.i(137315);
        Log.i("MicroMsg.Music.MMPlayer", AssetExtension.SCENE_PLAY);
        if (!euR()) {
            this.stop = false;
            ThreadPool.post(this.wgK, "music_player");
            AppMethodBeat.o(137315);
            return;
        }
        if (euR() && this.Ami.euY()) {
            this.Ami.wLf = 3;
            ZQ();
        }
        AppMethodBeat.o(137315);
    }

    private synchronized void ZQ() {
        AppMethodBeat.i(137316);
        Log.i("MicroMsg.Music.MMPlayer", "sync notify");
        try {
            notify();
            AppMethodBeat.o(137316);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Music.MMPlayer", e2, "syncNotify", new Object[0]);
            AppMethodBeat.o(137316);
        }
    }

    @Override // com.tencent.mm.plugin.music.f.a.b
    public final void stop() {
        AppMethodBeat.i(137317);
        Log.i("MicroMsg.Music.MMPlayer", "stop");
        this.stop = true;
        if (this.Ami.euY()) {
            ZQ();
        }
        AppMethodBeat.o(137317);
    }

    @Override // com.tencent.mm.plugin.music.f.a.b
    public final void pause() {
        AppMethodBeat.i(137318);
        Log.i("MicroMsg.Music.MMPlayer", "pause");
        if (!euR()) {
            AppMethodBeat.o(137318);
            return;
        }
        this.Ami.wLf = 2;
        AppMethodBeat.o(137318);
    }

    @Override // com.tencent.mm.plugin.music.f.a.b
    public final void seek(long j2) {
        AppMethodBeat.i(137319);
        this.jto.seekTo(1000 * j2, 2);
        AppMethodBeat.o(137319);
    }

    public final synchronized void euT() {
        AppMethodBeat.i(137320);
        while (euR() && this.Ami.euY()) {
            try {
                Log.i("MicroMsg.Music.MMPlayer", "wait play");
                wait();
            } catch (InterruptedException e2) {
                Log.printErrStackTrace("MicroMsg.Music.MMPlayer", e2, "waitPlay", new Object[0]);
            }
        }
        AppMethodBeat.o(137320);
    }

    @Override // com.tencent.mm.plugin.music.f.a.b
    public final boolean isPlaying() {
        AppMethodBeat.i(137321);
        boolean isPlaying = this.Ami.isPlaying();
        AppMethodBeat.o(137321);
        return isPlaying;
    }

    @Override // com.tencent.mm.plugin.music.f.a.b
    public final boolean euR() {
        return !this.stop;
    }

    @Override // com.tencent.mm.plugin.music.f.a.b
    public final void sn(boolean z) {
        AppMethodBeat.i(137322);
        this.Ami.wLf = 4;
        this.stop = true;
        super.sn(z);
        AppMethodBeat.o(137322);
    }

    @Override // com.tencent.mm.plugin.music.f.a.b
    public final void so(boolean z) {
        AppMethodBeat.i(137323);
        this.Ami.wLf = 4;
        this.stop = true;
        super.so(z);
        AppMethodBeat.o(137323);
    }

    @Override // com.tencent.mm.plugin.music.f.a.b
    public final String ZV() {
        return this.mime;
    }

    static /* synthetic */ void a(c cVar) {
        AppMethodBeat.i(137324);
        try {
            if (cVar.jto != null) {
                cVar.jto.gLF.release();
                cVar.jto = null;
            }
            AppMethodBeat.o(137324);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Music.MMPlayer", e2, "releaseMediaExtractor", new Object[0]);
            AppMethodBeat.o(137324);
        }
    }

    static /* synthetic */ void b(c cVar) {
        AppMethodBeat.i(137325);
        try {
            if (cVar.dvz != null) {
                cVar.dvz.stop();
                cVar.dvz.release();
                cVar.dvz = null;
            }
            AppMethodBeat.o(137325);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Music.MMPlayer", e2, "releaseMediaCodec", new Object[0]);
            AppMethodBeat.o(137325);
        }
    }

    static /* synthetic */ void c(c cVar) {
        AppMethodBeat.i(137326);
        try {
            if (cVar.bfn != null) {
                cVar.bfn.flush();
                cVar.bfn.release();
                cVar.bfn = null;
            }
            AppMethodBeat.o(137326);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.Music.MMPlayer", e2, "releaseAudioTrack", new Object[0]);
            AppMethodBeat.o(137326);
        }
    }
}
