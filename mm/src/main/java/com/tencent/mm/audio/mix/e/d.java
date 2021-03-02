package com.tencent.mm.audio.mix.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.d.h;
import com.tencent.mm.audio.mix.d.j;
import com.tencent.mm.audio.mix.i.b;
import java.util.LinkedList;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class d {
    private static d dvZ;
    private ThreadPoolExecutor dvM;
    private PriorityBlockingQueue<Runnable> dvN = new PriorityBlockingQueue<>(9);
    private LinkedList<j> dvO = new LinkedList<>();
    private int dvP;
    private Object lock = new Object();

    private static d Zq() {
        AppMethodBeat.i(198120);
        if (dvZ == null) {
            synchronized (d.class) {
                try {
                    if (dvZ == null) {
                        dvZ = new d();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(198120);
                    throw th;
                }
            }
        }
        d dVar = dvZ;
        AppMethodBeat.o(198120);
        return dVar;
    }

    private d() {
        int i2 = 4;
        AppMethodBeat.i(198121);
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        b.i("MicroMsg.Mix.AudioDownloadThreadPool", "getNormalCorePoolSize cpuCount:%d", Integer.valueOf(availableProcessors));
        int i3 = (availableProcessors * 2) + 2;
        if (i3 > 8) {
            i2 = 8;
        } else if (i3 >= 4) {
            i2 = i3;
        }
        this.dvP = i2;
        this.dvM = new ThreadPoolExecutor(i2, 8, 120, TimeUnit.SECONDS, this.dvN, new h("AUDIO_DOWNLOAD_THREAD_POOL_GROUP", "audio_download_thread#"));
        this.dvM.setMaximumPoolSize(8);
        b.i("MicroMsg.Mix.AudioDownloadThreadPool", "new AudioThreadPool poolSize:%d", Integer.valueOf(i2));
        AppMethodBeat.o(198121);
    }

    private void setCorePoolSize(int i2) {
        AppMethodBeat.i(198122);
        if (i2 > 8) {
            this.dvP = 8;
        } else if (i2 < 4) {
            this.dvP = 4;
        } else {
            this.dvP = i2;
        }
        b.i("MicroMsg.Mix.AudioDownloadThreadPool", "setCorePoolSize poolSize:%d", Integer.valueOf(i2));
        this.dvM.setCorePoolSize(i2);
        AppMethodBeat.o(198122);
    }

    public static void a(j jVar) {
        AppMethodBeat.i(198123);
        d Zq = Zq();
        synchronized (Zq.lock) {
            try {
                jVar.reset();
                Zq.dvO.add(jVar);
                int i2 = Zq.dvP;
                if (Zq.dvO.size() > i2) {
                    Zq.setCorePoolSize(i2 + 2);
                }
            } catch (Throwable th) {
                AppMethodBeat.o(198123);
                throw th;
            }
        }
        Zq.dvM.execute(jVar);
        AppMethodBeat.o(198123);
    }

    public static void b(j jVar) {
        AppMethodBeat.i(198124);
        d Zq = Zq();
        synchronized (Zq.lock) {
            try {
                Zq.dvO.remove(jVar);
                if (Zq.dvO.size() <= 4) {
                    Zq.dvP = 4;
                    Zq.setCorePoolSize(Zq.dvP);
                }
            } catch (Throwable th) {
                AppMethodBeat.o(198124);
                throw th;
            }
        }
        Zq.dvM.remove(jVar);
        AppMethodBeat.o(198124);
    }
}
