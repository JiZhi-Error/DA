package com.tencent.mm.plugin.i.a;

import android.support.e.a;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.g.b.a.ol;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.util.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0014\u0015B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002JH\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0007J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/findersdk/api/MusicActionReportLogic;", "", "()V", "TAG", "", "buildCommonReportStruct", "", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/MvCardActionReportStruct;", "report22243", "context", "Landroid/content/Context;", "songName", "singer", "musicWebUrl", "musicDataUrl", "musicAppId", NativeProtocol.WEB_DIALOG_ACTION, "", "scene", "ActionType", a.TAG_SCENE_TYPE, "finder-sdk_release"})
public final class aq {
    public static final aq UVR = new aq();

    static {
        AppMethodBeat.i(259298);
        AppMethodBeat.o(259298);
    }

    private aq() {
    }

    public static final void a(ol olVar) {
        String str;
        String str2 = null;
        AppMethodBeat.i(259297);
        p.h(olVar, "struct");
        Log.i("MicroMsg.MusicActionReportLogic", "reportMvMusicCardAction, action:" + olVar.acL() + ", scene:" + olVar.agC());
        k euj = k.euj();
        p.g(euj, "MusicPlayerManager.Instance()");
        f etU = euj.etU();
        if (etU != null) {
            String str3 = etU.jeX;
            if (str3 != null) {
                str = n.j(str3, ",", " ", false);
            } else {
                str = null;
            }
            olVar.aDr(str);
            String str4 = etU.jeY;
            if (str4 != null) {
                str2 = n.j(str4, ",", " ", false);
            }
            olVar.aWM(str2);
            olVar.aTq(etU.jfd);
            olVar.aWL(etU.jfb);
            olVar.aYJ(etU.jfi);
            Log.i("MicroMsg.MusicActionReportLogic", "song:" + olVar.aFd() + ", singer:" + olVar.aFO() + ", appId:" + olVar.getAppId());
        } else {
            Log.e("MicroMsg.MusicActionReportLogic", "buildCommonReportStruct, musicWrapper must not be null");
        }
        olVar.bfK();
        b bVar = b.QYu;
        b.a(olVar);
        AppMethodBeat.o(259297);
    }
}
