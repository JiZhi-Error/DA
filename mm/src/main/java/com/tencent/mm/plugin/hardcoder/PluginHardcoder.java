package com.tencent.mm.plugin.hardcoder;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.i;
import com.tencent.mm.g.a.ko;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.hardcoder.c;
import com.tencent.mm.kernel.a.a;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.zero.a.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ar;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class PluginHardcoder extends f implements c, b {
    private MStorage.IOnStorageChange iHr = new MStorage.IOnStorageChange() {
        /* class com.tencent.mm.plugin.hardcoder.PluginHardcoder.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(130766);
            Log.i("MicroMsg.PluginHardcoder", "abTestListener onNotifyChange stack[%s]", Util.getStack());
            if (str != null && str.length() > 0 && "event_updated".equals(str)) {
                g.aAk().postToWorkerDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.hardcoder.PluginHardcoder.AnonymousClass2.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(130765);
                        PluginHardcoder.access$000(PluginHardcoder.this);
                        AppMethodBeat.o(130765);
                    }
                }, 100);
            }
            AppMethodBeat.o(130766);
        }
    };
    private IListener yjg = new IListener<ps>() {
        /* class com.tencent.mm.plugin.hardcoder.PluginHardcoder.AnonymousClass3 */

        {
            AppMethodBeat.i(161750);
            this.__eventId = ps.class.getName().hashCode();
            AppMethodBeat.o(161750);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ps psVar) {
            AppMethodBeat.i(130767);
            g.aAk();
            MMHandlerThread.removeRunnable(PluginHardcoder.this.yjh);
            g.aAk().postToWorkerDelayed(PluginHardcoder.this.yjh, 3000);
            AppMethodBeat.o(130767);
            return false;
        }
    };
    private Runnable yjh = new Runnable() {
        /* class com.tencent.mm.plugin.hardcoder.PluginHardcoder.AnonymousClass4 */

        public final void run() {
            AppMethodBeat.i(130769);
            Log.i("MicroMsg.PluginHardcoder", "reportHardcoderRunnable start to run");
            g.aAi();
            long longValue = ((Long) g.aAh().azQ().get(ar.a.USERINFO_REPORT_HARDCODER_TIME_LONG, (Object) 0L)).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > Util.MILLSECONDS_OF_DAY || longValue > currentTimeMillis) {
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_REPORT_HARDCODER_TIME_LONG, Long.valueOf(currentTimeMillis));
                ThreadPool.post(new Runnable() {
                    /* class com.tencent.mm.plugin.hardcoder.PluginHardcoder.AnonymousClass4.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(130768);
                        Object[] objArr = new Object[3];
                        objArr[0] = Long.valueOf(Thread.currentThread().getId());
                        objArr[1] = Thread.currentThread().getName();
                        objArr[2] = Boolean.valueOf(WXHardCoderJNI.isCheckEnv() && WXHardCoderJNI.isRunning() > 0);
                        Log.i("MicroMsg.PluginHardcoder", "reportHardCoder tid[%d, %s], running[%b]", objArr);
                        WXHardCoderJNI.reportIDKey(true, 0, 1, false);
                        WXHardCoderJNI.readServerAddr(true);
                        WXHardCoderJNI.reportIDKey(true, (!WXHardCoderJNI.isCheckEnv() || WXHardCoderJNI.isRunning() <= 0) ? 5 : 4, 1, false);
                        WXHardCoderJNI.reportIDKey(true, WXHardCoderJNI.isHCEnable() ? 6 : 7, 1, false);
                        AppMethodBeat.o(130768);
                    }
                }, "reportHardCoder");
            }
            AppMethodBeat.o(130769);
        }
    };

    public PluginHardcoder() {
        AppMethodBeat.i(130770);
        AppMethodBeat.o(130770);
    }

    static /* synthetic */ void access$000(PluginHardcoder pluginHardcoder) {
        AppMethodBeat.i(130777);
        pluginHardcoder.reloadHardcoderConfig();
        AppMethodBeat.o(130777);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(130771);
        alias(b.class);
        AppMethodBeat.o(130771);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void dependency() {
        AppMethodBeat.i(130772);
        dependsOn(d.class);
        dependsOn(com.tencent.mm.plugin.report.c.class);
        AppMethodBeat.o(130772);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(130773);
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.plugin.hardcoder.PluginHardcoder.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(130764);
                Thread currentThread = Thread.currentThread();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                WXHardCoderJNI.initHardCoder(a.dYI(), a.dYI(), new c.a() {
                    /* class com.tencent.mm.plugin.hardcoder.PluginHardcoder.AnonymousClass1.AnonymousClass1 */

                    @Override // com.tencent.mm.hardcoder.c.a
                    public final void em(boolean z) {
                        AppMethodBeat.i(130763);
                        Log.i("MicroMsg.PluginHardcoder", "configure initHardCoder callback, connect:%b", Boolean.valueOf(z));
                        if (z && MMApplicationContext.isMMProcess()) {
                            WXHardCoderJNI.registerSystemEventCallback(new WXHardCoderJNI.SystemEventCallback() {
                                /* class com.tencent.mm.plugin.hardcoder.PluginHardcoder.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                @Override // com.tencent.mm.hardcoder.WXHardCoderJNI.SystemEventCallback
                                public final void onEvent(int i2) {
                                    AppMethodBeat.i(130761);
                                    Log.i("MicroMsg.PluginHardcoder", "configure SystemEventCallback onEvent eventCode[%d]", Integer.valueOf(i2));
                                    ko koVar = new ko();
                                    koVar.dPG.keycode = i2;
                                    EventCenter.instance.publish(koVar);
                                    AppMethodBeat.o(130761);
                                }
                            });
                            Log.i("MicroMsg.PluginHardcoder", "configure registerGetParametersCallback ret:%d", Integer.valueOf(WXHardCoderJNI.registerGetParametersCallback(1, new WXHardCoderJNI.GetParametersCallback() {
                                /* class com.tencent.mm.plugin.hardcoder.PluginHardcoder.AnonymousClass1.AnonymousClass1.AnonymousClass2 */

                                @Override // com.tencent.mm.hardcoder.WXHardCoderJNI.GetParametersCallback
                                public final void onGetParameters(int i2, JSONObject jSONObject) {
                                    AppMethodBeat.i(130762);
                                    Log.i("MicroMsg.PluginHardcoder", "configure GetParametersCallback onGetParameters type[%d]", Integer.valueOf(i2));
                                    if (i2 == 1) {
                                        try {
                                            String string = jSONObject.getString("HCMinQPKey");
                                            String string2 = jSONObject.getString("HCMaxQPKey");
                                            String string3 = jSONObject.getString("HCQPSceneKey");
                                            Log.i("MicroMsg.PluginHardcoder", "onGetParameters, minkey:%s, maxKey:%s, sceneKey:%s", string, string2, string3);
                                            MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("HardcoderQP");
                                            mmkv.encode("HCMinQPKey", string);
                                            mmkv.encode("HCMaxQPKey", string2);
                                            mmkv.encode("HCQPSceneKey", string3);
                                            AppMethodBeat.o(130762);
                                            return;
                                        } catch (JSONException e2) {
                                        }
                                    }
                                    AppMethodBeat.o(130762);
                                }
                            }, "HCMinQPKey", "HCMaxQPKey", "HCQPSceneKey")));
                        }
                        AppMethodBeat.o(130763);
                    }
                });
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                Log.i("MicroMsg.PluginHardcoder", "configure initHardCoder[%d %d %d %d] take[%d]ms tid[%s, %s]", Long.valueOf(a.hrO), Long.valueOf(a.hrP), Long.valueOf(elapsedRealtime), Long.valueOf(elapsedRealtime2), Long.valueOf(elapsedRealtime2 - a.hrO), currentThread.getName(), Long.valueOf(currentThread.getId()));
                AppMethodBeat.o(130764);
            }
        }, "initHardCoder");
        AppMethodBeat.o(130773);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(130774);
        if (MMApplicationContext.isMMProcess()) {
            EventCenter.instance.add(this.yjg);
            com.tencent.mm.model.c.d.aXu().add(this.iHr);
            Log.i("MicroMsg.PluginHardcoder", "onAccountInitialized abTestListener[%s]", this.iHr);
            SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences(WXHardCoderJNI.SETTING_SP_FILE, 0);
            g.aAi();
            g.aAf();
            if (com.tencent.mm.kernel.a.getUin() != 0) {
                g.aAi();
                g.aAf();
                int ch = i.ch(com.tencent.mm.kernel.a.getUin(), 100);
                if (ch != sharedPreferences.getInt(WXHardCoderJNI.KEY_HC_UIN_HASH, 0)) {
                    Log.i("MicroMsg.PluginHardcoder", "onAccountInitialized hardcoder uinHash[%d] reloadSPConfig", Integer.valueOf(ch));
                    sharedPreferences.edit().putInt(WXHardCoderJNI.KEY_HC_UIN_HASH, ch).apply();
                    WXHardCoderJNI.reloadSPConfig(WXHardCoderJNI.RELOAD_SCENE_POST_RESET);
                }
            }
        }
        AppMethodBeat.o(130774);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(130775);
        if (MMApplicationContext.isMMProcess()) {
            com.tencent.mm.model.c.d.aXu().remove(this.iHr);
            EventCenter.instance.removeListener(this.yjg);
        }
        AppMethodBeat.o(130775);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(com.tencent.mm.kernel.b.g gVar) {
    }

    private void reloadHardcoderConfig() {
        boolean z;
        boolean z2;
        boolean z3;
        AppMethodBeat.i(130776);
        com.tencent.mm.storage.c Fu = com.tencent.mm.model.c.d.aXu().Fu("100282");
        Log.i("MicroMsg.PluginHardcoder", "reloadHardcoderConfig abTest[%s][%b][%s]", Fu, Boolean.valueOf(Fu.isValid()), Fu.gzz());
        if (Fu.isValid()) {
            Log.i("MicroMsg.PluginHardcoder", "reloadHardcoderConfig abTest valid!");
            SharedPreferences.Editor edit = MMApplicationContext.getContext().getSharedPreferences(WXHardCoderJNI.SETTING_SP_FILE, 0).edit();
            Map<String, String> gzz = Fu.gzz();
            boolean z4 = Util.getInt(gzz.get("enable"), WXHardCoderJNI.getEnable() ? 1 : 0) > 0;
            boolean z5 = z4 && !WXHardCoderJNI.getEnable();
            edit.putBoolean(WXHardCoderJNI.KEY_HC_ENABLE, z4);
            edit.putBoolean(WXHardCoderJNI.KEY_HC_BG_ENABLE, Util.getInt(gzz.get("bgenable"), WXHardCoderJNI.hcBgEnable ? 1 : 0) > 0);
            if (Util.getInt(gzz.get("debug"), WXHardCoderJNI.getDebug() ? 1 : 0) > 0) {
                z = true;
            } else {
                z = false;
            }
            edit.putBoolean(WXHardCoderJNI.KEY_HC_DEBUG, z);
            edit.putInt(WXHardCoderJNI.KEY_HC_KV_PER, Util.getInt(gzz.get("kvper"), WXHardCoderJNI.hcUinHash));
            edit.putInt(WXHardCoderJNI.KEY_HC_KV_FT, Util.getInt(gzz.get("kvft"), WXHardCoderJNI.hcUinHash));
            g.aAi();
            g.aAf();
            int ch = i.ch(com.tencent.mm.kernel.a.getUin(), 100);
            edit.putInt(WXHardCoderJNI.KEY_HC_UIN_HASH, ch);
            long j2 = Util.getLong(gzz.get("scene"), -1);
            for (Map.Entry<Long, String> entry : WXHardCoderJNI.flagKeyMap.entrySet()) {
                String value = entry.getValue();
                if ((entry.getKey().longValue() & j2) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                edit.putBoolean(value, z3);
            }
            int i2 = Util.getInt(gzz.get("margin"), WXHardCoderJNI.hcTimeoutMargin);
            edit.putInt(WXHardCoderJNI.KEY_HC_TIMEOUT_MARGIN, i2);
            int i3 = Util.getInt(gzz.get("retryitv"), WXHardCoderJNI.hcRetryInterval);
            edit.putInt(WXHardCoderJNI.KEY_HC_RETRY_INTERVAL, i3);
            String nullAs = Util.nullAs(gzz.get("model"), "");
            String str = Build.MODEL;
            String nullAs2 = Util.nullAs(gzz.get("manufacturer"), "");
            String str2 = Build.MANUFACTURER;
            if (nullAs2.length() > 0 || nullAs.length() > 0) {
                boolean contains = nullAs2.contains(str2);
                if (!contains) {
                    z2 = nullAs.contains(str);
                } else {
                    z2 = contains;
                }
                WXHardCoderJNI.reportIDKey(true, z2 ? 10 : 11, 1, true);
                edit.putBoolean(WXHardCoderJNI.KEY_HC_ENABLE, z2);
                boolean z6 = z2 && !WXHardCoderJNI.getEnable();
                Log.i("MicroMsg.PluginHardcoder", "reloadHardcoderConfig check manufacturer[%s] manufacturerlist[%s] model[%s] modellist[%s] enable[%b] init[%b]", str2, nullAs2, str, nullAs, Boolean.valueOf(z2), Boolean.valueOf(z6));
                z5 = z6;
            } else {
                WXHardCoderJNI.reportIDKey(true, 12, 1, true);
            }
            edit.apply();
            WXHardCoderJNI.reloadSPConfig(WXHardCoderJNI.RELOAD_SCENE_ABTEST);
            Log.i("MicroMsg.PluginHardcoder", "reloadHardcoderConfig enable[%b] init[%b] bgEnable[%b] debug[%b] uinHash[%d] kv[%b, %b] sceneFlag[%d] margin[%d] retryInterval[%d] model[%s]", Boolean.valueOf(WXHardCoderJNI.getEnable()), Boolean.valueOf(z5), Boolean.valueOf(WXHardCoderJNI.hcBgEnable), Boolean.valueOf(WXHardCoderJNI.getDebug()), Integer.valueOf(ch), Boolean.valueOf(WXHardCoderJNI.hcKVPerReport), Boolean.valueOf(WXHardCoderJNI.hcKVFtReport), Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), nullAs);
            if (z5) {
                WXHardCoderJNI.initHardCoder(a.dYI(), a.dYI(), null);
            }
        }
        AppMethodBeat.o(130776);
    }
}
