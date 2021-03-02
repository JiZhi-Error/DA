package com.tencent.mm.pluginsdk.model.app;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.r.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class f {
    public List<s> JVN;
    public ConcurrentHashMap<String, Integer> JVO;
    private MTimerHandler JVP;
    private MMHandler handler;
    public List<s> hiK;

    public f() {
        AppMethodBeat.i(151668);
        this.JVN = null;
        this.hiK = null;
        this.JVO = null;
        this.JVP = new MTimerHandler("AppIconServiceTimer", (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
            /* class com.tencent.mm.pluginsdk.model.app.f.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(151666);
                f.this.JVO.clear();
                AppMethodBeat.o(151666);
                return false;
            }
        }, false);
        this.handler = new MMHandler(g.aAk().getLooper()) {
            /* class com.tencent.mm.pluginsdk.model.app.f.AnonymousClass2 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                AppMethodBeat.i(151667);
                x xVar = (x) message.obj;
                s sVar = new s(xVar.appId, xVar.jjN);
                if (f.this.JVN.contains(sVar)) {
                    f.this.JVN.remove(sVar);
                    if (!a.eAS().d(xVar.appId, xVar.data, xVar.jjN)) {
                        Log.e("MicroMsg.AppIconService", "handleMessage, saveIcon fail");
                    }
                }
                while (f.this.hiK.size() > 0) {
                    s remove = f.this.hiK.remove(0);
                    if (f.this.a(remove)) {
                        f.this.JVN.add(remove);
                        AppMethodBeat.o(151667);
                        return;
                    }
                }
                AppMethodBeat.o(151667);
            }
        };
        this.JVN = new ArrayList();
        this.hiK = new ArrayList();
        this.JVO = new ConcurrentHashMap<>();
        this.JVP.startTimer(600000);
        AppMethodBeat.o(151668);
    }

    public final void gD(String str, int i2) {
        AppMethodBeat.i(151669);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.AppIconService", "push fail, appId is null");
            AppMethodBeat.o(151669);
            return;
        }
        s sVar = new s(str, i2);
        if (this.JVN.contains(sVar)) {
            Log.i("MicroMsg.AppIconService", "push, appId = " + str + ", iconType = " + i2 + " already in running list");
            AppMethodBeat.o(151669);
        } else if (this.JVN.size() >= 5) {
            Log.i("MicroMsg.AppIconService", "running list has reached the max count");
            if (!this.hiK.contains(sVar)) {
                this.hiK.add(sVar);
            }
            AppMethodBeat.o(151669);
        } else {
            if (a(sVar)) {
                this.JVN.add(sVar);
            }
            AppMethodBeat.o(151669);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean a(s sVar) {
        String str;
        AppMethodBeat.i(151670);
        if (sVar == null) {
            Log.e("MicroMsg.AppIconService", "startDownload fail, geticoninfo is null");
            AppMethodBeat.o(151670);
            return false;
        } else if (!b(sVar)) {
            Log.e("MicroMsg.AppIconService", "increaseCounter fail");
            AppMethodBeat.o(151670);
            return false;
        } else {
            g bdG = a.eAS().bdG(sVar.appId);
            if (bdG == null) {
                Log.e("MicroMsg.AppIconService", "push, appinfo does not exist, appId = " + sVar.appId);
                AppMethodBeat.o(151670);
                return false;
            }
            switch (sVar.jjN) {
                case 1:
                    if (bdG.field_appIconUrl != null && bdG.field_appIconUrl.length() != 0) {
                        str = bdG.field_appIconUrl;
                        break;
                    } else {
                        Log.e("MicroMsg.AppIconService", "push, appIconUrl is null, appId = " + sVar.appId);
                        AppMethodBeat.o(151670);
                        return false;
                    }
                    break;
                case 2:
                    if (bdG.field_appWatermarkUrl != null && bdG.field_appWatermarkUrl.length() != 0) {
                        str = bdG.field_appWatermarkUrl;
                        break;
                    } else {
                        Log.e("MicroMsg.AppIconService", "push, appWatermarkUrl is null, appId = " + sVar.appId);
                        AppMethodBeat.o(151670);
                        return false;
                    }
                    break;
                case 3:
                    if (bdG.fmL != null && bdG.fmL.length() != 0) {
                        str = bdG.fmL;
                        break;
                    } else {
                        Log.e("MicroMsg.AppIconService", "push, appSuggestionIconUrl is null, appId = " + sVar.appId);
                        AppMethodBeat.o(151670);
                        return false;
                    }
                    break;
                case 4:
                    if (bdG.fmW != null && bdG.fmW.length() != 0) {
                        str = bdG.fmW;
                        break;
                    } else {
                        Log.e("MicroMsg.AppIconService", "push, servicePanelIconUrl is null, appId = " + sVar.appId);
                        AppMethodBeat.o(151670);
                        return false;
                    }
                case 5:
                    if (bdG.fmX != null && bdG.fmX.length() != 0) {
                        str = bdG.fmX;
                        break;
                    } else {
                        Log.e("MicroMsg.AppIconService", "push, serviceListIconUrl is null, appId = " + sVar.appId);
                        AppMethodBeat.o(151670);
                        return false;
                    }
                default:
                    Log.e("MicroMsg.AppIconService", "push, unknown iconType = " + sVar.jjN);
                    AppMethodBeat.o(151670);
                    return false;
            }
            Log.i("MicroMsg.AppIconService", "appIconUrl = ".concat(String.valueOf(str)));
            ThreadPool.post(new t(this.handler, sVar.appId, sVar.jjN, str), "AppIconService_getIcon");
            AppMethodBeat.o(151670);
            return true;
        }
    }

    private boolean b(s sVar) {
        AppMethodBeat.i(151671);
        if (sVar == null) {
            Log.e("MicroMsg.AppIconService", "increaseCounter fail, info is null");
            AppMethodBeat.o(151671);
            return false;
        }
        Integer valueOf = Integer.valueOf(Util.nullAs(this.JVO.get(sVar.toString()), 0));
        if (valueOf.intValue() >= 5) {
            Log.e("MicroMsg.AppIconService", "increaseCounter fail, has reached the max try count");
            AppMethodBeat.o(151671);
            return false;
        }
        this.JVO.put(sVar.toString(), Integer.valueOf(valueOf.intValue() + 1));
        AppMethodBeat.o(151671);
        return true;
    }
}
