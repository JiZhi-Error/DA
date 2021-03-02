package com.tencent.mm.plugin.music.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a;
import com.tencent.mm.ay.c;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.plugin.music.f.c.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tav.core.AssetExtension;
import java.util.List;

public final class f extends IListener<mw> {
    public f() {
        AppMethodBeat.i(161224);
        this.__eventId = mw.class.getName().hashCode();
        AppMethodBeat.o(161224);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* synthetic */ boolean callback(mw mwVar) {
        c beg;
        AppMethodBeat.i(137280);
        mw mwVar2 = mwVar;
        if (k.isInit()) {
            switch (mwVar2.dSw.action) {
                case -3:
                    mwVar2.dSx.result = k.euj().etW().bec();
                    break;
                case -2:
                    mwVar2.dSx.dSy = k.euj().etU();
                    break;
                case -1:
                    k.euj().bea();
                    break;
                case 0:
                    k.euj().s(mwVar2.dSw.dSy);
                    break;
                case 1:
                    k.euj().etW().eth();
                    break;
                case 2:
                    k.euj().etW().resume();
                    break;
                case 3:
                    k.euj().AjC.l(mwVar2.dSw.dSy);
                    break;
                case 4:
                    k euj = k.euj();
                    List<com.tencent.mm.ay.f> list = mwVar2.dSw.dLA;
                    int i2 = mwVar2.dSw.dSz;
                    Log.i("MicroMsg.Music.MusicPlayerManager", "startPlayNewMusicList");
                    com.tencent.mm.ay.f etU = euj.etU();
                    com.tencent.mm.ay.f y = euj.AjC.y(list, i2);
                    if (etU != null && y != null && Util.isEqual(etU.jeV, y.jeV) && (beg = a.beg()) != null && AssetExtension.SCENE_PLAY.equals(beg.jeQ)) {
                        euj.m(y);
                        break;
                    } else {
                        euj.w(y);
                        break;
                    }
                case 5:
                    k.euj().AjC.i(mwVar2.dSw.dLA, mwVar2.dSw.dSA);
                    break;
                case 6:
                    k euj2 = k.euj();
                    com.tencent.mm.ay.f fVar = mwVar2.dSw.dSy;
                    if (fVar != null) {
                        Log.i("MicroMsg.Music.MusicPlayerManager", "startMusicInList");
                        euj2.w(euj2.AjC.j(fVar));
                        break;
                    } else {
                        Log.i("MicroMsg.Music.MusicPlayerManager", "musicWrapper is null");
                        break;
                    }
                case 7:
                    mwVar2.dSx.result = k.euj().etW().tG(mwVar2.dSw.position);
                    break;
                case 8:
                    mwVar2.dSx.dSC = k.euj().etW().esW();
                    break;
                case 9:
                    mwVar2.dSx.result = k.euj().etW().bee();
                    break;
                case 10:
                    mwVar2.dSx.result = k.euj().etW().bed();
                    break;
                case 11:
                    k.euj().SP(600000);
                    break;
                case 13:
                    d dVar = (d) b.aS(d.class);
                    if (dVar != null) {
                        dVar.a(mwVar2.dSw.dSB);
                        break;
                    }
                    break;
                case 16:
                    k.euj().m(mwVar2.dSw.dSy);
                    break;
            }
        } else {
            Log.e("MicroMsg.Music.MusicActionListener", "don't anything, must init MusicPlayerManager first with MusicLogic before!");
        }
        AppMethodBeat.o(137280);
        return false;
    }
}
