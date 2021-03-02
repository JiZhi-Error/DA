package com.tencent.mm.plugin.music.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.d.a;
import com.tencent.mm.audio.mix.f.g;
import com.tencent.mm.audio.mix.g.c;
import com.tencent.mm.audio.mix.g.d;
import com.tencent.mm.audio.mix.i.b;
import com.tencent.mm.audio.mix.jni.SilkResampleJni;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;

public final class f {
    private static f AgQ = null;

    private f() {
        AppMethodBeat.i(137012);
        h.esH();
        AppMethodBeat.o(137012);
    }

    public static synchronized void init() {
        synchronized (f.class) {
            AppMethodBeat.i(137013);
            if (AgQ != null) {
                AppMethodBeat.o(137013);
            } else {
                Log.i("MicroMsg.Audio.AudioPlayerCoreService", "create");
                AgQ = new f();
                AppMethodBeat.o(137013);
            }
        }
    }

    public static synchronized void release() {
        synchronized (f.class) {
            AppMethodBeat.i(137014);
            Log.i("MicroMsg.Audio.AudioPlayerCoreService", "release");
            h esI = h.esI();
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "release, clear all cache");
            esI._release();
            esI.bLZ();
            c cVar = esI.Ahp;
            cVar.dxb.stopAll();
            d dVar = cVar.dxa;
            b.i("MicroMsg.Mix.AudioMixPlayerImpl", "stopAll");
            dVar.dxo.Zt();
            dVar.ZP();
            dVar.ZL();
            c cVar2 = esI.Ahp;
            a aVar = cVar2.dxb;
            aVar.stopAll();
            aVar.clearCache();
            aVar.dva = null;
            d dVar2 = cVar2.dxa;
            b.i("MicroMsg.Mix.AudioMixPlayerImpl", "release");
            dVar2.dxh.set(false);
            dVar2.ZP();
            dVar2.ZL();
            com.tencent.mm.audio.mix.f.c cVar3 = dVar2.dxo;
            b.i("MicroMsg.Mix.AudioMixController", "onRelease");
            cVar3.ZB();
            cVar3.clearCache();
            dVar2.dxb = null;
            dVar2.clearCache();
            SilkResampleJni.clearResampleAll();
            g.ZG();
            cVar2.clearCache();
            com.tencent.mm.audio.mix.b.c YF = com.tencent.mm.audio.mix.b.c.YF();
            for (int i2 = 0; i2 < YF.duk.size(); i2++) {
                YF.duk.get(i2).dtQ = null;
            }
            YF.duk.clear();
            com.tencent.mm.audio.mix.b.a Yw = com.tencent.mm.audio.mix.b.a.Yw();
            b.i("MicroMsg.Mix.AudioCachePathMgr", "close");
            Yw.Yy();
            c cVar4 = esI.Ahp;
            String str = cVar4.appId;
            b.i("MicroMsg.Mix.AudioPcmDataTrackTaskController", "cleanAllCache appId:%s", str);
            com.tencent.mm.audio.mix.b.a.d.a(new com.tencent.mm.audio.mix.b.a.b(str), "AudioPcmDataTrackCleanTask");
            cVar4.dxc.clear();
            esI.Ahp.a((com.tencent.mm.audio.mix.g.b) null);
            esI.Ahp.a((com.tencent.mm.audio.mix.g.g) null);
            esI.Ahu.dvT = null;
            com.tencent.mm.audio.mix.e.a aVar2 = esI.Ahu;
            b.i("MicroMsg.Audio.AudioDownloadMgr", "stopAll");
            Iterator<String> it = aVar2.dvR.iterator();
            while (it.hasNext()) {
                com.tencent.mm.audio.mix.e.c cVar5 = aVar2.dvb.get(it.next());
                if (cVar5 != null && !cVar5.dvh) {
                    if (!(cVar5.dvY == null)) {
                        com.tencent.mm.audio.mix.e.g gVar = cVar5.dvX;
                        if (gVar != null) {
                            gVar.stop();
                        }
                        cVar5.dvY = null;
                        aVar2.dvb.remove(cVar5);
                    }
                }
                b.e("MicroMsg.Audio.AudioDownloadMgr", "task is not exist");
                cVar5.dvY = null;
                aVar2.dvb.remove(cVar5);
            }
            esI.Ahu.dvb.clear();
            esI.cdV();
            AgQ = null;
            AppMethodBeat.o(137014);
        }
    }
}
