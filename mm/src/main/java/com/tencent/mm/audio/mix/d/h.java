package com.tencent.mm.audio.mix.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class h implements ThreadFactory {
    private final ThreadGroup dvH;
    private final AtomicInteger dvI;
    private final String dvJ;
    private String dvK;

    public h() {
        AppMethodBeat.i(136822);
        this.dvI = new AtomicInteger(1);
        this.dvJ = "audio_mix_thread#";
        this.dvK = "";
        this.dvH = new ThreadGroup("AUDIO_MIX_THREAD_POOL_GROUP");
        AppMethodBeat.o(136822);
    }

    public h(String str, String str2) {
        AppMethodBeat.i(198110);
        this.dvI = new AtomicInteger(1);
        this.dvJ = "audio_mix_thread#";
        this.dvK = "";
        this.dvH = new ThreadGroup(str);
        this.dvK = str2;
        AppMethodBeat.o(198110);
    }

    public final Thread newThread(Runnable runnable) {
        AppMethodBeat.i(136823);
        if (TextUtils.isEmpty(this.dvK)) {
            this.dvK = "audio_mix_thread#";
        }
        Thread thread = new Thread(this.dvH, runnable, this.dvK + this.dvI.getAndIncrement(), 0);
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (thread.getPriority() != 5) {
            thread.setPriority(5);
        }
        AppMethodBeat.o(136823);
        return thread;
    }
}
