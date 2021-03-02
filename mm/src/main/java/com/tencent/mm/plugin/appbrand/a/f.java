package com.tencent.mm.plugin.appbrand.a;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.a.d;
import com.tencent.mm.plugin.appbrand.backgroundrunning.i;
import com.tencent.mm.plugin.appbrand.backgroundrunning.j;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.jsapi.i.s;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService;
import com.tencent.mm.sdk.platformtools.Log;

/* access modifiers changed from: package-private */
public abstract class f extends g {
    private final AppBrandRuntime kEc;
    int kRB = 0;
    private final AppBrandMusicClientService.a kRC = new AppBrandMusicClientService.a() {
        /* class com.tencent.mm.plugin.appbrand.a.f.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService.a
        public final void bxf() {
            AppMethodBeat.i(134742);
            f.this.vT(1);
            AppMethodBeat.o(134742);
        }

        @Override // com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService.a
        public final void onStop() {
            AppMethodBeat.i(134743);
            f.this.vT(1);
            AppMethodBeat.o(134743);
        }
    };

    /* access modifiers changed from: package-private */
    public abstract void bxb();

    f(h hVar, AppBrandRuntime appBrandRuntime) {
        super(hVar);
        this.kEc = appBrandRuntime;
    }

    @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.plugin.appbrand.a.g, com.tencent.mm.sdk.statemachine.IState
    public void enter() {
        this.kRB = bxe();
        super.enter();
        vT(0);
    }

    @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
    public void exit() {
        super.exit();
        this.kRB = 0;
        AppBrandMusicClientService appBrandMusicClientService = AppBrandMusicClientService.ncV;
        String str = this.kEc.mAppId;
        if (!TextUtils.isEmpty(str) && appBrandMusicClientService.ncU.containsKey(str)) {
            appBrandMusicClientService.ncU.remove(str);
        }
    }

    @Override // com.tencent.mm.sdk.statemachine.State, com.tencent.mm.sdk.statemachine.IState
    public boolean processMessage(Message message) {
        if (d.a.vS(message.what) == d.a.ON_STOP_BACKGROUND_LOCATION_LISTENING) {
            Log.i("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_STOP_BACKGROUND_LOCATION_LISTENING");
            vT(32);
            return true;
        } else if (d.a.vS(message.what) == d.a.ON_STOP_BACKGROUND_LIVE_VOIP) {
            Log.i("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_STOP_BACKGROUND_LIVE_VOIP");
            vT(64);
            return true;
        } else if (d.a.vS(message.what) == d.a.ON_STOP_AUDIO_BACKGROUND_PLAY) {
            Log.i("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_STOP_AUDIO_BACKGROUND_PLAY");
            vT(128);
            return true;
        } else if (d.a.vS(message.what) == d.a.ON_STOP_BACKGROUND_VOIP_1v1) {
            Log.i("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_STOP_BACKGROUND_LIVE_VOIP");
            vT(256);
            return true;
        } else if (d.a.vS(message.what) != d.a.ON_CONTAINER_FORCED_MOVE_TO_BACK) {
            return super.processMessage(message);
        } else {
            Log.i("MicroMsg.MultipleConditionBackgroundState", "processMessage, ON_CONTAINER_FORCED_MOVE_TO_BACK, appId:%s", this.kEc.mAppId);
            vT(4);
            return true;
        }
    }

    private void dK(int i2) {
        this.kRB |= i2;
    }

    /* access modifiers changed from: package-private */
    public final void vT(int i2) {
        this.kRB &= i2 ^ -1;
        if (this.kRB == 0) {
            Log.i("MicroMsg.MultipleConditionBackgroundState", "onKeepFlagsCleared, appId:%s", this.kEc.mAppId);
            bxb();
        }
    }

    private int bxe() {
        s sVar;
        this.kRB = 0;
        String str = this.kEc.mAppId;
        a aVar = (a) this.kEc.av(a.class);
        if (!(aVar != null && aVar.kQF)) {
            AppBrandMusicClientService appBrandMusicClientService = AppBrandMusicClientService.ncV;
            if (!TextUtils.isEmpty(str)) {
                if (!str.equalsIgnoreCase(appBrandMusicClientService.ncW)) {
                    Log.e("MicroMsg.AppBrandMusicClientService", "appId is diff, can't stop music");
                } else {
                    AppBrandMusicClientService.StopBackgroundMusicTask stopBackgroundMusicTask = new AppBrandMusicClientService.StopBackgroundMusicTask();
                    stopBackgroundMusicTask.appId = str;
                    AppBrandMainProcessService.a(stopBackgroundMusicTask);
                }
            }
        } else if (AppBrandMusicClientService.acC(str)) {
            dK(1);
            AppBrandMusicClientService appBrandMusicClientService2 = AppBrandMusicClientService.ncV;
            AppBrandMusicClientService.a aVar2 = this.kRC;
            if (!TextUtils.isEmpty(str) && aVar2 != null) {
                if (!appBrandMusicClientService2.ncU.containsKey(str)) {
                    appBrandMusicClientService2.ncU.put(str, aVar2);
                } else {
                    appBrandMusicClientService2.ncU.remove(str);
                    appBrandMusicClientService2.ncU.put(str, aVar2);
                }
            }
        }
        boolean z = ((a) this.kEc.av(a.class)).kQG;
        Log.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagLocationIfNeed, canKeepAliveLocation:%s", Boolean.valueOf(z));
        if (z && (sVar = (s) this.kEc.aw(s.class)) != null) {
            boolean z2 = sVar.lXu && sVar.kYn;
            Log.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagLocationIfNeed, isBackgroundMode:%s, isListening:%s", Boolean.valueOf(sVar.lXu), Boolean.valueOf(sVar.kYn));
            if (z2) {
                dK(32);
            }
        }
        j jVar = (j) this.kEc.aw(j.class);
        if (jVar != null) {
            boolean bzd = jVar.bzd();
            Log.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagAppBrandLiveVOIPIfNeed, isVOIPing:%s", Boolean.valueOf(bzd));
            if (bzd) {
                dK(64);
            }
        }
        i iVar = (i) this.kEc.aw(i.class);
        if (iVar != null) {
            boolean bzc = iVar.bzc();
            Log.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagAppBrandAudioBackgroundPlayIfNeed, isNeedKeepAlive:%b", Boolean.valueOf(bzc));
            if (bzc) {
                dK(128);
            }
        }
        j jVar2 = (j) this.kEc.aw(j.class);
        if (jVar2 != null) {
            boolean bzd2 = jVar2.bzd();
            Log.i("MicroMsg.MultipleConditionBackgroundState", "addKeepFlagAppBrandLiveVOIPIfNeed, isVOIPing:%s", Boolean.valueOf(bzd2));
            if (bzd2) {
                dK(256);
            }
        }
        switch (h.Uc(str)) {
            case LAUNCH_MINI_PROGRAM:
                dK(16);
                break;
            case LAUNCH_NATIVE_PAGE:
                dK(4);
                break;
            case HOME_PRESSED:
                try {
                    if (this.kEc.kAl != null && (!this.kEc.kAl.getWindowAndroid().bsc() || this.kEc.brg() != null)) {
                        dK(8);
                        break;
                    }
                } catch (IllegalAccessError e2) {
                    break;
                }
        }
        return this.kRB;
    }
}
