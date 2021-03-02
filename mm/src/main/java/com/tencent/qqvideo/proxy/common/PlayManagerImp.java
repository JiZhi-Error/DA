package com.tencent.qqvideo.proxy.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqvideo.proxy.api.IPlayManager;
import com.tencent.qqvideo.proxy.api.IUtils;
import com.tencent.qqvideo.proxy.httpproxy.HttpproxyFacade;
import com.tencent.qqvideo.proxy.httpproxy.TVHttpProxyLoadLibrary;

public class PlayManagerImp implements IPlayManager {
    private static String TAG = "TV_Httpproxy";
    private static boolean mbSoLoadSuccess = false;
    private ConfigStorage mConfigStorageInstance;
    private HttpproxyFacade proxy;

    public PlayManagerImp() {
        AppMethodBeat.i(89682);
        this.proxy = null;
        this.mConfigStorageInstance = new ConfigStorage();
        this.proxy = HttpproxyFacade.instance();
        AppMethodBeat.o(89682);
    }

    private static boolean isWifiOn(Context context) {
        AppMethodBeat.i(89683);
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            AppMethodBeat.o(89683);
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            AppMethodBeat.o(89683);
            return false;
        } else if (activeNetworkInfo.getType() == 1) {
            AppMethodBeat.o(89683);
            return true;
        } else {
            AppMethodBeat.o(89683);
            return false;
        }
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized int init(Context context, String str) {
        int i2 = -1;
        synchronized (this) {
            AppMethodBeat.i(89684);
            if (context == null) {
                AppMethodBeat.o(89684);
            } else {
                if (this.proxy != null) {
                    HttpproxyFacade.setContext(context);
                }
                if (!mbSoLoadSuccess) {
                    try {
                        TVHttpProxyLoadLibrary.load("wxhttpproxy", PlayManagerImp.class.getClassLoader(), context);
                        TVHttpProxyLoadLibrary.setupBrokenLibraryHandler();
                        mbSoLoadSuccess = true;
                    } catch (Throwable th) {
                        mbSoLoadSuccess = false;
                        AppMethodBeat.o(89684);
                    }
                }
                try {
                    String downProxyConfig = ConfigStorage.getDownProxyConfig(context);
                    this.mConfigStorageInstance.synGetServerConfig(context);
                    if (str == null) {
                        str = "";
                    }
                    int init = this.proxy.init(str, downProxyConfig);
                    if (!isWifiOn(context)) {
                        this.proxy.setNetWorkState(2);
                    }
                    AppMethodBeat.o(89684);
                    i2 = init;
                } catch (Throwable th2) {
                    AppMethodBeat.o(89684);
                }
            }
        }
        return i2;
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized void deinit() {
        AppMethodBeat.i(89685);
        try {
            this.mConfigStorageInstance.stopGetServerConfig();
            this.proxy.deinit();
            AppMethodBeat.o(89685);
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "error ,deinit native not found");
            AppMethodBeat.o(89685);
        }
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized String buildPlayURLMp4(int i2) {
        String str;
        AppMethodBeat.i(89686);
        try {
            str = this.proxy.buildPlayURL(i2);
            AppMethodBeat.o(89686);
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "error ,buildPlayURL native not found");
            str = "";
            AppMethodBeat.o(89686);
        }
        return str;
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized void stopPlay(int i2) {
        AppMethodBeat.i(89687);
        try {
            this.proxy.stopPlay(i2);
            AppMethodBeat.o(89687);
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "error ,stopPlay native not found");
            AppMethodBeat.o(89687);
        }
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized void setUtilsObject(IUtils iUtils) {
        AppMethodBeat.i(89688);
        try {
            this.proxy.setUtils(iUtils);
            AppMethodBeat.o(89688);
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "error ,setUtilsObject native not found");
            AppMethodBeat.o(89688);
        }
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized void setCookie(String str) {
        AppMethodBeat.i(89689);
        try {
            this.proxy.setCookie(str);
            AppMethodBeat.o(89689);
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "error ,setCookie native not found");
            AppMethodBeat.o(89689);
        }
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized void appToFront() {
        AppMethodBeat.i(89690);
        try {
            this.proxy.pushEvent(3);
            AppMethodBeat.o(89690);
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "error ,appToFront native not found");
            AppMethodBeat.o(89690);
        }
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized void appToBack() {
        AppMethodBeat.i(89691);
        try {
            this.proxy.pushEvent(4);
            AppMethodBeat.o(89691);
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "error ,appToBack native not found");
            AppMethodBeat.o(89691);
        }
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized String getProxyVersion() {
        String str;
        AppMethodBeat.i(89692);
        try {
            str = this.proxy.getVersion();
            AppMethodBeat.o(89692);
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "error ,getProxyVersion native not found");
            str = "TVHttpproxy.1.0.0.0000";
            AppMethodBeat.o(89692);
        }
        return str;
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized void setNetWorkState(int i2) {
        AppMethodBeat.i(89693);
        "setNetWorkState".concat(String.valueOf(i2));
        try {
            this.proxy.setNetWorkState(i2);
            AppMethodBeat.o(89693);
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "error ,setNetWorkStatus native not found");
            AppMethodBeat.o(89693);
        }
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized void setPlayerState(int i2) {
        AppMethodBeat.i(89694);
        "setPlayerState".concat(String.valueOf(i2));
        try {
            this.proxy.setPlayerState(i2);
            AppMethodBeat.o(89694);
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "error ,setPlayState native not found");
            AppMethodBeat.o(89694);
        }
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized int startPlay(String str, int i2, String str2, long j2, int i3) {
        int i4;
        AppMethodBeat.i(89695);
        try {
            i4 = this.proxy.startPlay(str, i2, str2, j2, i3);
            AppMethodBeat.o(89695);
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "error ,startPlay native not found");
            i4 = -1;
            AppMethodBeat.o(89695);
        }
        return i4;
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized int preLoad(int i2, int i3) {
        int i4;
        AppMethodBeat.i(89696);
        try {
            i4 = this.proxy.preLoad(i2, i3);
            AppMethodBeat.o(89696);
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "error ,preLoad native not found");
            i4 = -1;
            AppMethodBeat.o(89696);
        }
        return i4;
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized int getCurrentOffset(int i2) {
        int i3;
        AppMethodBeat.i(89697);
        try {
            i3 = this.proxy.getCurrentOffset(i2);
            AppMethodBeat.o(89697);
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "error ,getCurrentOffset native not found");
            i3 = 0;
            AppMethodBeat.o(89697);
        }
        return i3;
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized int getTotalOffset(int i2) {
        int i3;
        AppMethodBeat.i(89698);
        try {
            i3 = this.proxy.getTotalOffset(i2);
            AppMethodBeat.o(89698);
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "error ,getTotalOffset native not found");
            i3 = 0;
            AppMethodBeat.o(89698);
        }
        return i3;
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized void setRemainTime(int i2, int i3) {
        AppMethodBeat.i(89699);
        try {
            this.proxy.setRemainTime(i2, i3);
            AppMethodBeat.o(89699);
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "error ,getTotalOffset native not found");
            AppMethodBeat.o(89699);
        }
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized int getLocalServerPort() {
        int i2;
        AppMethodBeat.i(89700);
        try {
            i2 = this.proxy.getLocalServerPort();
            AppMethodBeat.o(89700);
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "error ,getLocalServerPort native not found");
            i2 = -1;
            AppMethodBeat.o(89700);
        }
        return i2;
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized int setMaxStorageSize(long j2) {
        int i2;
        AppMethodBeat.i(89701);
        try {
            i2 = this.proxy.setMaxStorageSize(j2);
            AppMethodBeat.o(89701);
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "error ,setMaxStorageSize native not found");
            i2 = -1;
            AppMethodBeat.o(89701);
        }
        return i2;
    }

    @Override // com.tencent.qqvideo.proxy.api.IPlayManager
    public synchronized int cleanStorage() {
        int i2;
        AppMethodBeat.i(89702);
        try {
            i2 = this.proxy.cleanStorage();
            AppMethodBeat.o(89702);
        } catch (Throwable th) {
            HttpproxyFacade.print(6, TAG, "error ,cleanStorage native not found");
            i2 = -1;
            AppMethodBeat.o(89702);
        }
        return i2;
    }
}
