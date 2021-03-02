package com.tencent.mm.plugin.appbrand.game.preload;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.lt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class e {
    private static volatile e lue;
    public String luf;
    public int lug;
    public int luh;
    public int lui;
    public String luj;
    public int luk;
    boolean lul = false;
    public int lum;
    public int mScene = -1;

    private e() {
    }

    public static e bDw() {
        AppMethodBeat.i(45294);
        if (lue == null) {
            synchronized (e.class) {
                try {
                    if (lue == null) {
                        lue = new e();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(45294);
                    throw th;
                }
            }
        }
        e eVar = lue;
        AppMethodBeat.o(45294);
        return eVar;
    }

    public final void dX(int i2, int i3) {
        long j2;
        int i4 = 1;
        AppMethodBeat.i(45295);
        if (!Util.isNullOrNil(this.luj) && !Util.isNullOrNil(this.luf)) {
            Object[] objArr = new Object[9];
            objArr[0] = this.luj;
            objArr[1] = this.luf;
            objArr[2] = Integer.valueOf(this.lug);
            objArr[3] = Integer.valueOf(this.luh);
            objArr[4] = Integer.valueOf(this.lui);
            objArr[5] = Integer.valueOf(i2);
            objArr[6] = Integer.valueOf(i3);
            objArr[7] = Integer.valueOf(this.mScene);
            if (!this.lul) {
                i4 = 0;
            }
            objArr[8] = Integer.valueOf(i4);
            Log.v("MicroMsg.WAGamePreloadStatisManager", "instanceId:%s,appId:%s,appVersion:%d,appState:%d,appType:%d,key:%d,value:%d,scene:%d,misDownloadedCode:%d", objArr);
            lt ltVar = new lt();
            ltVar.ze(this.luj);
            ltVar.zf(this.luf);
            ltVar.eXc = (long) this.lug;
            ltVar.eZI = lt.a.me(this.luh);
            ltVar.eZJ = lt.b.mf(this.lui);
            ltVar.eZK = (long) this.luk;
            ltVar.eZL = (long) i2;
            ltVar.eZM = (long) i3;
            if (this.lul) {
                j2 = 1;
            } else {
                j2 = 0;
            }
            ltVar.eZN = j2;
            ltVar.erW = (long) this.mScene;
            ltVar.eZO = (long) this.lum;
            ltVar.bfK();
        }
        AppMethodBeat.o(45295);
    }
}
