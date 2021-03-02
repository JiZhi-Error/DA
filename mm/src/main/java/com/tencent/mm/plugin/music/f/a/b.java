package com.tencent.mm.plugin.music.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public abstract class b {
    protected f AiZ;
    protected f Amh;
    public g Ami = new g();

    public abstract String ZV();

    public abstract void aHY(String str);

    public abstract boolean euR();

    public abstract int euS();

    public abstract int getDuration();

    public abstract boolean isPlaying();

    public abstract void pause();

    public abstract void play();

    public abstract void seek(long j2);

    public abstract void stop();

    public final void a(f fVar) {
        this.Amh = fVar;
    }

    public final void R(f fVar) {
        this.AiZ = fVar;
    }

    public void sn(final boolean z) {
        if (this.Amh != null) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.music.f.a.b.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(137401);
                    Log.i("MicroMsg.Music.BasePlayer", "onError, needRetry:%b", Boolean.valueOf(z));
                    b.this.Amh.d(b.this.AiZ, z);
                    AppMethodBeat.o(137401);
                }
            });
        }
    }

    public final void onStart() {
        if (this.Amh != null) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.music.f.a.b.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(137402);
                    Log.i("MicroMsg.Music.BasePlayer", "onStart %b", Boolean.valueOf(b.this.isPlaying()));
                    b.this.Amh.n(b.this.AiZ);
                    AppMethodBeat.o(137402);
                }
            });
        }
    }

    public final void Tb(final int i2) {
        if (this.Amh != null) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.music.f.a.b.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(137403);
                    if (b.this.euR()) {
                        b.this.Amh.Q(b.this.AiZ);
                    }
                    AppMethodBeat.o(137403);
                }
            });
        }
    }

    public void so(final boolean z) {
        if (this.Amh != null) {
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.music.f.a.b.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(137404);
                    Log.i("MicroMsg.Music.BasePlayer", "onStop, isComplete:%b", Boolean.valueOf(z));
                    b.this.Amh.c(b.this.AiZ, z);
                    AppMethodBeat.o(137404);
                }
            });
        }
    }
}
