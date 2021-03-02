package com.tencent.soter.a.c;

import android.content.SharedPreferences;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class b {
    private static volatile b RQw = null;
    public int RQx = 0;
    public SparseArray<String> RQy = new SparseArray<>(10);
    public SharedPreferences RQz = null;
    public boolean dEI = false;
    public boolean isInit = false;

    public b() {
        AppMethodBeat.i(16);
        AppMethodBeat.o(16);
    }

    public static b hlG() {
        b bVar;
        AppMethodBeat.i(17);
        if (RQw == null) {
            synchronized (b.class) {
                try {
                    if (RQw == null) {
                        RQw = new b();
                    }
                    bVar = RQw;
                } finally {
                    AppMethodBeat.o(17);
                }
            }
            return bVar;
        }
        b bVar2 = RQw;
        AppMethodBeat.o(17);
        return bVar2;
    }

    public final boolean isInit() {
        boolean z;
        synchronized (b.class) {
            z = this.isInit;
        }
        return z;
    }

    public final void hlH() {
        synchronized (b.class) {
            this.isInit = true;
        }
    }

    public final boolean hlC() {
        boolean z;
        synchronized (b.class) {
            z = this.dEI;
        }
        return z;
    }

    public final void DQ(boolean z) {
        synchronized (b.class) {
            this.dEI = z;
        }
    }

    public final SparseArray<String> hlI() {
        SparseArray<String> sparseArray;
        synchronized (b.class) {
            sparseArray = this.RQy;
        }
        return sparseArray;
    }

    public final SharedPreferences hlJ() {
        SharedPreferences sharedPreferences;
        synchronized (b.class) {
            sharedPreferences = this.RQz;
        }
        return sharedPreferences;
    }
}
