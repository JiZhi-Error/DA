package com.tencent.magicbrush.utils;

import com.tencent.magicbrush.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class e implements Runnable {
    public final FutureTask<?> cPv;

    public e(Runnable runnable) {
        AppMethodBeat.i(140070);
        this.cPv = new FutureTask<>(runnable, 0);
        AppMethodBeat.o(140070);
    }

    public <T> e(Callable<T> callable) {
        AppMethodBeat.i(140071);
        this.cPv = new FutureTask<>(callable);
        AppMethodBeat.o(140071);
    }

    public final boolean aZ(long j2) {
        AppMethodBeat.i(140072);
        try {
            this.cPv.get(j2, TimeUnit.MILLISECONDS);
            AppMethodBeat.o(140072);
            return true;
        } catch (InterruptedException e2) {
            c.C0193c.printStackTrace("MagicBrush.SyncTask", e2, "await failed", new Object[0]);
            AppMethodBeat.o(140072);
            return false;
        } catch (ExecutionException e3) {
            c.C0193c.printStackTrace("MagicBrush.SyncTask", e3, "execute failed", new Object[0]);
            AppMethodBeat.o(140072);
            return false;
        } catch (TimeoutException e4) {
            c.C0193c.printStackTrace("MagicBrush.SyncTask", e4, "execute timeout", new Object[0]);
            AppMethodBeat.o(140072);
            return false;
        }
    }

    public final <T> T get() {
        AppMethodBeat.i(140073);
        try {
            T t = (T) this.cPv.get();
            AppMethodBeat.o(140073);
            return t;
        } catch (InterruptedException e2) {
            c.C0193c.printStackTrace("MagicBrush.SyncTask", e2, "await failed", new Object[0]);
            AppMethodBeat.o(140073);
            return null;
        } catch (ExecutionException e3) {
            c.C0193c.printStackTrace("MagicBrush.SyncTask", e3, "execute failed", new Object[0]);
            AppMethodBeat.o(140073);
            return null;
        }
    }

    public void run() {
        AppMethodBeat.i(140074);
        this.cPv.run();
        AppMethodBeat.o(140074);
    }
}
