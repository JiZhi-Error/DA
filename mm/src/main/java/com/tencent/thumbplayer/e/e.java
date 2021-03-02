package com.tencent.thumbplayer.e;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.proxy.ITPPreloadProxy;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.thumbplayer.e.g;
import java.util.ArrayList;

public final class e implements ITPPreloadProxy {
    private a RZK = new a(this, (byte) 0);
    private ITPPreloadProxy.IPreloadListener RZL = new d("TPPreloadProxyImpl");
    private ITPDownloadProxy RZp;
    private boolean RZq = false;
    private Context mContext;
    private int mServiceType;

    public e(Context context, int i2) {
        AppMethodBeat.i(189222);
        this.mContext = context;
        this.mServiceType = i2;
        hny();
        AppMethodBeat.o(189222);
    }

    private void hny() {
        AppMethodBeat.i(189223);
        int i2 = 3;
        while (i2 > 0 && !this.RZq) {
            try {
                b aru = g.a.hnA().aru(this.mServiceType);
                if (aru == null || aru.hnx() == null) {
                    i2--;
                    com.tencent.thumbplayer.utils.g.e("TPPreloadProxyImpl", "p2p so load failed");
                } else {
                    this.RZp = aru.hnx();
                    this.RZp.setLogListener(this.RZK);
                    this.RZp.setUserData(TPDownloadProxyEnum.USER_IS_VIP, Boolean.valueOf(com.tencent.thumbplayer.d.a.hnr()));
                    if (!TextUtils.isEmpty(com.tencent.thumbplayer.d.a.hnn())) {
                        this.RZp.setUserData(TPDownloadProxyEnum.USER_UIN, com.tencent.thumbplayer.d.a.hnn());
                    }
                    if (!TextUtils.isEmpty(com.tencent.thumbplayer.d.a.getAppVersionName(this.mContext))) {
                        this.RZp.setUserData(TPDownloadProxyEnum.USER_APP_VERSION, com.tencent.thumbplayer.d.a.getAppVersionName(this.mContext));
                    }
                    if (com.tencent.thumbplayer.d.a.li(this.mContext) != -1) {
                        this.RZp.setUserData(TPDownloadProxyEnum.USER_APP_VERSION_CODE, String.valueOf(com.tencent.thumbplayer.d.a.li(this.mContext)));
                    }
                    this.RZp.setUserData(TPDownloadProxyEnum.USER_UPC, com.tencent.thumbplayer.d.a.hno());
                    this.RZp.setUserData(TPDownloadProxyEnum.USER_UPC_STATE, Integer.valueOf(com.tencent.thumbplayer.d.a.hnp()));
                    this.RZp.setUserData(TPDownloadProxyEnum.USER_EXTERNAL_NETWORK_IP, com.tencent.thumbplayer.d.a.hnq());
                    this.RZq = true;
                    AppMethodBeat.o(189223);
                    return;
                }
            } catch (Exception e2) {
                i2--;
                com.tencent.thumbplayer.utils.g.e("TPPreloadProxyImpl", e2);
            }
        }
        AppMethodBeat.o(189223);
    }

    @Override // com.tencent.thumbplayer.api.proxy.ITPPreloadProxy
    public final void setPreloadListener(ITPPreloadProxy.IPreloadListener iPreloadListener) {
        AppMethodBeat.i(189224);
        if (iPreloadListener == null) {
            this.RZL = new d("TPPreloadProxyImpl");
            AppMethodBeat.o(189224);
            return;
        }
        this.RZL = iPreloadListener;
        AppMethodBeat.o(189224);
    }

    @Override // com.tencent.thumbplayer.api.proxy.ITPPreloadProxy
    public final int startPreload(String str, TPDownloadParamData tPDownloadParamData) {
        int i2 = -1;
        AppMethodBeat.i(189225);
        if (!isAvailable()) {
            hny();
            if (!isAvailable()) {
                AppMethodBeat.o(189225);
                return i2;
            }
        }
        if (tPDownloadParamData != null) {
            try {
                i2 = this.RZp.startPreload(str, i.b(null, tPDownloadParamData), this.RZK);
                AppMethodBeat.o(189225);
            } catch (Throwable th) {
                com.tencent.thumbplayer.utils.g.e("TPPreloadProxyImpl", th);
            }
            return i2;
        }
        AppMethodBeat.o(189225);
        return i2;
    }

    @Override // com.tencent.thumbplayer.api.proxy.ITPPreloadProxy
    public final int startClipPreload(String str, ArrayList<TPDownloadParamData> arrayList) {
        return 0;
    }

    @Override // com.tencent.thumbplayer.api.proxy.ITPPreloadProxy
    public final void stopPreload(int i2) {
        AppMethodBeat.i(189226);
        if (this.RZp == null) {
            AppMethodBeat.o(189226);
            return;
        }
        try {
            this.RZp.stopPreload(i2);
            AppMethodBeat.o(189226);
        } catch (Throwable th) {
            com.tencent.thumbplayer.utils.g.e("TPPreloadProxyImpl", th);
            AppMethodBeat.o(189226);
        }
    }

    @Override // com.tencent.thumbplayer.api.proxy.ITPPreloadProxy
    public final void pushEvent(int i2) {
        AppMethodBeat.i(189227);
        if (!isAvailable()) {
            AppMethodBeat.o(189227);
            return;
        }
        try {
            this.RZp.pushEvent(i2);
            AppMethodBeat.o(189227);
        } catch (Throwable th) {
            com.tencent.thumbplayer.utils.g.e("TPPreloadProxyImpl", th);
            AppMethodBeat.o(189227);
        }
    }

    @Override // com.tencent.thumbplayer.api.proxy.ITPPreloadProxy
    public final boolean isAvailable() {
        return this.RZp != null && this.RZq;
    }

    @Override // com.tencent.thumbplayer.api.proxy.ITPPreloadProxy
    public final String getPlayErrorCodeStr(int i2) {
        return null;
    }

    /* access modifiers changed from: package-private */
    public class a implements ITPDLProxyLogListener, ITPPreLoadListener {
        private a() {
        }

        /* synthetic */ a(e eVar, byte b2) {
            this();
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener
        public final int d(String str, int i2, String str2, String str3) {
            AppMethodBeat.i(189215);
            com.tencent.thumbplayer.utils.g.d(str2, "[" + str + ":" + i2 + "] " + str3);
            AppMethodBeat.o(189215);
            return 0;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener
        public final int i(String str, int i2, String str2, String str3) {
            AppMethodBeat.i(189216);
            com.tencent.thumbplayer.utils.g.i(str2, "[" + str + ":" + i2 + "] " + str3);
            AppMethodBeat.o(189216);
            return 0;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener
        public final int w(String str, int i2, String str2, String str3) {
            AppMethodBeat.i(189217);
            com.tencent.thumbplayer.utils.g.w(str2, "[" + str + ":" + i2 + "] " + str3);
            AppMethodBeat.o(189217);
            return 0;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener
        public final int e(String str, int i2, String str2, String str3) {
            AppMethodBeat.i(189218);
            com.tencent.thumbplayer.utils.g.e(str2, "[" + str + ":" + i2 + "] " + str3);
            AppMethodBeat.o(189218);
            return 0;
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener
        public final void onPrepareOK() {
            AppMethodBeat.i(189219);
            e.this.RZL.onPrepareSuccess();
            AppMethodBeat.o(189219);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener
        public final void onPrepareError(int i2, int i3, String str) {
            AppMethodBeat.i(189220);
            e.this.RZL.onPrepareError();
            AppMethodBeat.o(189220);
        }

        @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPPreLoadListener
        public final void onPrepareDownloadProgressUpdate(int i2, int i3, long j2, long j3, String str) {
            AppMethodBeat.i(189221);
            e.this.RZL.onPrepareDownloadProgressUpdate(i2, i3, j2, j3);
            AppMethodBeat.o(189221);
        }
    }
}
