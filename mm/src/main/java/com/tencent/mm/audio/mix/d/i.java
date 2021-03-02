package com.tencent.mm.audio.mix.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.i.b;
import java.util.LinkedList;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class i {
    private static i dvL;
    private ThreadPoolExecutor dvM;
    private PriorityBlockingQueue<Runnable> dvN = new PriorityBlockingQueue<>(33);
    private LinkedList<j> dvO = new LinkedList<>();
    private int dvP;
    private Object lock = new Object();

    public static i Zp() {
        AppMethodBeat.i(136824);
        if (dvL == null) {
            synchronized (i.class) {
                try {
                    if (dvL == null) {
                        dvL = new i();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(136824);
                    throw th;
                }
            }
        }
        i iVar = dvL;
        AppMethodBeat.o(136824);
        return iVar;
    }

    private i() {
        int i2 = 8;
        AppMethodBeat.i(136825);
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        b.i("MicroMsg.Mix.AudioThreadPool", "getNormalCorePoolSize cpuCount:%d", Integer.valueOf(availableProcessors));
        int i3 = (availableProcessors * 2) + 2;
        if (i3 > 32) {
            i2 = 32;
        } else if (i3 >= 8) {
            i2 = i3;
        }
        this.dvP = i2;
        this.dvM = new ThreadPoolExecutor(i2, 32, 120, TimeUnit.SECONDS, this.dvN, new h());
        this.dvM.setMaximumPoolSize(32);
        b.i("MicroMsg.Mix.AudioThreadPool", "new AudioThreadPool poolSize:%d", Integer.valueOf(i2));
        AppMethodBeat.o(136825);
    }

    private void setCorePoolSize(int i2) {
        AppMethodBeat.i(136826);
        if (i2 > 32) {
            this.dvP = 32;
        } else if (i2 < 4) {
            this.dvP = 4;
        } else {
            this.dvP = i2;
        }
        b.i("MicroMsg.Mix.AudioThreadPool", "setCorePoolSize poolSize:%d", Integer.valueOf(i2));
        this.dvM.setCorePoolSize(i2);
        AppMethodBeat.o(136826);
    }

    public static void a(j jVar) {
        AppMethodBeat.i(136827);
        i Zp = Zp();
        synchronized (Zp.lock) {
            try {
                jVar.reset();
                Zp.dvO.add(jVar);
                int i2 = Zp.dvP;
                if (Zp.dvO.size() > i2) {
                    Zp.setCorePoolSize(i2 + 2);
                }
            } catch (Throwable th) {
                AppMethodBeat.o(136827);
                throw th;
            }
        }
        Zp.dvM.execute(jVar);
        AppMethodBeat.o(136827);
    }

    public static void b(j jVar) {
        AppMethodBeat.i(136828);
        i Zp = Zp();
        synchronized (Zp.lock) {
            try {
                Zp.dvO.remove(jVar);
                if (Zp.dvO.size() <= 4) {
                    Zp.dvP = 4;
                    Zp.setCorePoolSize(Zp.dvP);
                }
            } catch (Throwable th) {
                AppMethodBeat.o(136828);
                throw th;
            }
        }
        Zp.dvM.remove(jVar);
        AppMethodBeat.o(136828);
    }
}
