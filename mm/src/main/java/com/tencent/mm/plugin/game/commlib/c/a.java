package com.tencent.mm.plugin.game.commlib.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    private static a xvv;
    Map<String, MTimerHandler> xvu = new ConcurrentHashMap();

    /* renamed from: com.tencent.mm.plugin.game.commlib.c.a$a  reason: collision with other inner class name */
    public interface AbstractC1395a {
        void cBm();
    }

    public a() {
        AppMethodBeat.i(256614);
        AppMethodBeat.o(256614);
    }

    public static a dTf() {
        AppMethodBeat.i(256615);
        if (xvv == null) {
            xvv = new a();
        }
        a aVar = xvv;
        AppMethodBeat.o(256615);
        return aVar;
    }

    public final synchronized void a(final String str, final AbstractC1395a aVar) {
        AppMethodBeat.i(256616);
        if (Util.isNullOrNil(str) || Util.MILLSECONDS_OF_MINUTE < 0) {
            AppMethodBeat.o(256616);
        } else if (this.xvu.containsKey(str)) {
            Log.i("MicroMsg.GameAutoRunController", "taskId:%s exists in the queue", str);
            AppMethodBeat.o(256616);
        } else {
            Log.i("MicroMsg.GameAutoRunController", "add taskId:%s to the queue", str);
            MTimerHandler mTimerHandler = new MTimerHandler(str, (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
                /* class com.tencent.mm.plugin.game.commlib.c.a.AnonymousClass1 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(256613);
                    a.this.xvu.remove(str);
                    boolean azq = a.azq(str);
                    Log.i("MicroMsg.GameAutoRunController", "taskId:%s, allowInvoke:%b", str, Boolean.valueOf(azq));
                    if (aVar != null && azq) {
                        aVar.cBm();
                    }
                    AppMethodBeat.o(256613);
                    return true;
                }
            }, false);
            mTimerHandler.startTimer(Util.MILLSECONDS_OF_MINUTE);
            this.xvu.put(str, mTimerHandler);
            AppMethodBeat.o(256616);
        }
    }

    static boolean azq(String str) {
        AppMethodBeat.i(256617);
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("game_mmkv");
        String str2 = "";
        if (mmkv != null) {
            str2 = mmkv.decodeString("auto_run_switch", "");
        }
        Log.i("MicroMsg.GameAutoRunController", "autoRunSwitch:%s", str2);
        try {
            JSONObject jSONObject = new JSONObject(str2);
            if (jSONObject.has(str)) {
                if (jSONObject.getInt(str) != 0) {
                    AppMethodBeat.o(256617);
                    return true;
                }
                AppMethodBeat.o(256617);
                return false;
            }
        } catch (JSONException e2) {
        }
        HashMap hashMap = new HashMap();
        if (com.tencent.mm.plugin.game.commlib.a.xvl == null) {
            com.tencent.mm.plugin.game.commlib.a.dSS();
        }
        if (!(com.tencent.mm.plugin.game.commlib.a.xvl == null || com.tencent.mm.plugin.game.commlib.a.xvl.AutoRunTaskSetting == null)) {
            hashMap.put("md5_check", Boolean.valueOf(com.tencent.mm.plugin.game.commlib.a.xvl.AutoRunTaskSetting.xJk));
            hashMap.put("download_resume", Boolean.valueOf(com.tencent.mm.plugin.game.commlib.a.xvl.AutoRunTaskSetting.xJl));
            hashMap.put("preload_commlib", Boolean.valueOf(com.tencent.mm.plugin.game.commlib.a.xvl.AutoRunTaskSetting.xJm));
            hashMap.put("game_silent_download", Boolean.valueOf(com.tencent.mm.plugin.game.commlib.a.xvl.AutoRunTaskSetting.xJn));
            hashMap.put("wepkg_download_retry", Boolean.valueOf(com.tencent.mm.plugin.game.commlib.a.xvl.AutoRunTaskSetting.xJo));
            hashMap.put("wepkg_expired_clean", Boolean.valueOf(com.tencent.mm.plugin.game.commlib.a.xvl.AutoRunTaskSetting.xJp));
            hashMap.put("game_cache_clean", Boolean.valueOf(com.tencent.mm.plugin.game.commlib.a.xvl.AutoRunTaskSetting.xJq));
            hashMap.put("game_resource_check", Boolean.valueOf(com.tencent.mm.plugin.game.commlib.a.xvl.AutoRunTaskSetting.xJr));
        }
        if (!hashMap.containsKey(str)) {
            AppMethodBeat.o(256617);
            return true;
        } else if (!((Boolean) hashMap.get(str)).booleanValue()) {
            AppMethodBeat.o(256617);
            return true;
        } else {
            AppMethodBeat.o(256617);
            return false;
        }
    }
}
