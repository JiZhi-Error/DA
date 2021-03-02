package com.tencent.thumbplayer.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDLProxyInitParam;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyFactory;
import com.tencent.thumbplayer.utils.TPNetworkChangeMonitor;
import com.tencent.thumbplayer.utils.e;
import java.util.HashMap;

public final class g implements TPNetworkChangeMonitor.b, e.a {
    private int RZN;
    private String RZO;
    private int RZP;
    private HashMap<Integer, b> RZQ;

    /* synthetic */ g(byte b2) {
        this();
    }

    private g() {
        AppMethodBeat.i(189234);
        this.RZN = 0;
        this.RZO = "";
        this.RZP = 0;
        if (this.RZQ == null) {
            this.RZQ = new HashMap<>();
        }
        e.a(this);
        TPNetworkChangeMonitor.hop().a(this);
        AppMethodBeat.o(189234);
    }

    public static class a {
        private static g RZS = new g((byte) 0);

        static {
            AppMethodBeat.i(189233);
            AppMethodBeat.o(189233);
        }
    }

    public final b aru(int i2) {
        AppMethodBeat.i(189235);
        if (i2 < 0) {
            AppMethodBeat.o(189235);
            return null;
        } else if (this.RZQ.containsKey(Integer.valueOf(i2))) {
            b bVar = this.RZQ.get(Integer.valueOf(i2));
            AppMethodBeat.o(189235);
            return bVar;
        } else {
            ITPDownloadProxy tPDownloadProxy = TPDownloadProxyFactory.getTPDownloadProxy(i2);
            if (tPDownloadProxy != null) {
                try {
                    if (tPDownloadProxy.init(TPPlayerMgr.getAppContext(), new TPDLProxyInitParam(com.tencent.thumbplayer.d.a.getPlatform(), com.tencent.thumbplayer.d.a.getAppVersionName(TPPlayerMgr.getAppContext()), com.tencent.thumbplayer.d.a.getGuid(), com.tencent.thumbplayer.d.a.hnk(), com.tencent.thumbplayer.d.a.hnl(), com.tencent.thumbplayer.d.a.hnm())) < 0) {
                        com.tencent.thumbplayer.utils.g.i("TPProxyGlobalManager", "downloadProxy init failed with status:".concat(String.valueOf(tPDownloadProxy)));
                        AppMethodBeat.o(189235);
                        return null;
                    }
                    tPDownloadProxy.setLogListener(new ITPDLProxyLogListener() {
                        /* class com.tencent.thumbplayer.e.g.AnonymousClass1 */

                        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener
                        public final int d(String str, int i2, String str2, String str3) {
                            AppMethodBeat.i(189229);
                            com.tencent.thumbplayer.utils.g.d(str2, "[" + str + ":" + i2 + "] " + str3);
                            AppMethodBeat.o(189229);
                            return 0;
                        }

                        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener
                        public final int i(String str, int i2, String str2, String str3) {
                            AppMethodBeat.i(189230);
                            com.tencent.thumbplayer.utils.g.i(str2, "[" + str + ":" + i2 + "] " + str3);
                            AppMethodBeat.o(189230);
                            return 0;
                        }

                        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener
                        public final int w(String str, int i2, String str2, String str3) {
                            AppMethodBeat.i(189231);
                            com.tencent.thumbplayer.utils.g.w(str2, "[" + str + ":" + i2 + "] " + str3);
                            AppMethodBeat.o(189231);
                            return 0;
                        }

                        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener
                        public final int e(String str, int i2, String str2, String str3) {
                            AppMethodBeat.i(189232);
                            com.tencent.thumbplayer.utils.g.e(str2, "[" + str + ":" + i2 + "] " + str3);
                            AppMethodBeat.o(189232);
                            return 0;
                        }
                    });
                    int aYS = TPNetworkChangeMonitor.aYS();
                    if (aYS == 1) {
                        tPDownloadProxy.pushEvent(1);
                        tPDownloadProxy.pushEvent(10);
                    } else if (aYS == 2) {
                        tPDownloadProxy.pushEvent(2);
                        tPDownloadProxy.pushEvent(9);
                    } else if (aYS == 3) {
                        tPDownloadProxy.pushEvent(2);
                        tPDownloadProxy.pushEvent(10);
                    }
                    tPDownloadProxy.pushEvent(this.RZN);
                    tPDownloadProxy.setUserData(TPDownloadProxyEnum.USER_UPC, this.RZO);
                    tPDownloadProxy.setUserData(TPDownloadProxyEnum.USER_UPC_STATE, Integer.valueOf(this.RZP));
                    h hVar = new h(tPDownloadProxy);
                    this.RZQ.put(Integer.valueOf(i2), hVar);
                    AppMethodBeat.o(189235);
                    return hVar;
                } catch (Throwable th) {
                    com.tencent.thumbplayer.utils.g.i("TPProxyGlobalManager", "init proxy failed:".concat(String.valueOf(th)));
                }
            }
            AppMethodBeat.o(189235);
            return null;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.thumbplayer.utils.e.a
    public final void d(int i2, int i3, int i4, Object obj) {
        AppMethodBeat.i(189236);
        com.tencent.thumbplayer.utils.g.i("TPProxyGlobalManager", "onEvent eventId: " + i2 + ", arg1: " + i3 + ", arg2: " + i4 + ", object" + obj);
        switch (i2) {
            case TPPlayerMgr.EVENT_ID_APP_ENTER_BACKGROUND:
                this.RZN = 13;
                arv(13);
                AppMethodBeat.o(189236);
                return;
            case TPPlayerMgr.EVENT_ID_APP_ENTER_FOREGROUND:
                this.RZN = 14;
                arv(14);
                AppMethodBeat.o(189236);
                return;
            case 100003:
                hG((String) obj, i3);
                break;
        }
        AppMethodBeat.o(189236);
    }

    @Override // com.tencent.thumbplayer.utils.TPNetworkChangeMonitor.b
    public final void my(int i2, int i3) {
        AppMethodBeat.i(189237);
        if (i3 == 1) {
            arv(1);
            arv(10);
            AppMethodBeat.o(189237);
        } else if (i3 == 2) {
            arv(2);
            arv(9);
            AppMethodBeat.o(189237);
        } else {
            if (i3 == 3) {
                arv(2);
                arv(10);
            }
            AppMethodBeat.o(189237);
        }
    }

    private void arv(int i2) {
        AppMethodBeat.i(189238);
        for (b bVar : this.RZQ.values()) {
            bVar.pushEvent(i2);
        }
        AppMethodBeat.o(189238);
    }

    private void hG(String str, int i2) {
        AppMethodBeat.i(189239);
        this.RZO = str;
        this.RZP = i2;
        for (b bVar : this.RZQ.values()) {
            bVar.hnx().setUserData(TPDownloadProxyEnum.USER_UPC, str);
            bVar.hnx().setUserData(TPDownloadProxyEnum.USER_UPC_STATE, Integer.valueOf(i2));
        }
        AppMethodBeat.o(189239);
    }
}
