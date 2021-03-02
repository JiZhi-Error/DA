package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.data.j;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.vfs.s;

public final class d extends b {
    private final String EkT;
    private final a EkU;
    private final String fileName;
    private final String filePath;
    private final int fileType;

    public interface a {
        void aNH(String str);

        void eWO();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public final /* synthetic */ String doInBackground(Void[] voidArr) {
        AppMethodBeat.i(97290);
        String fev = fev();
        AppMethodBeat.o(97290);
        return fev;
    }

    public d(String str, String str2, String str3, int i2, a aVar) {
        AppMethodBeat.i(203151);
        s.boN(str2);
        this.url = str;
        this.EkT = str2;
        this.fileName = str3;
        this.filePath = str2 + str3;
        this.fileType = i2;
        this.EkU = aVar;
        AppMethodBeat.o(203151);
    }

    private String fev() {
        AppMethodBeat.i(97289);
        try {
            AdLandingPagesProxy.getInstance().downloadLandingPagesCDNFile(this.EkT, this.fileName, this.url, this.fileType, new AdLandingPagesProxy.g() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.g
                public final void eWO() {
                    AppMethodBeat.i(97285);
                    Log.e("MicroMsg.AdLandingPageDownloadCDNFileTask", "onDownloadError, netType=" + NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext()) + ", url=" + d.this.url);
                    d.this.aPY(d.this.filePath);
                    if (d.this.EkU != null) {
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(97283);
                                d.this.EkU.eWO();
                                AppMethodBeat.o(97283);
                            }
                        });
                    }
                    AppMethodBeat.o(97285);
                }

                @Override // com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.g
                public final void eZU() {
                    AppMethodBeat.i(97286);
                    if (d.this.EkU != null) {
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.AnonymousClass1.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(97284);
                                d.this.EkU.aNH(d.this.filePath);
                                AppMethodBeat.o(97284);
                            }
                        });
                    }
                    AppMethodBeat.o(97286);
                }
            });
        } catch (Exception e2) {
            Log.e("MicroMsg.AdLandingPageDownloadCDNFileTask", "doInBackground exp, netType=" + NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext()) + ", exp=" + e2.toString() + ", url=" + this.url);
            aPY(this.filePath);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(97287);
                    d.this.EkU.eWO();
                    AppMethodBeat.o(97287);
                }
            });
        }
        AppMethodBeat.o(97289);
        return null;
    }

    /* access modifiers changed from: protected */
    public final void aPY(String str) {
        AppMethodBeat.i(203152);
        int i2 = 0;
        String str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        try {
            if (s.YS(str)) {
                str2 = "1";
                if (s.deleteFile(str)) {
                    i2 = 1;
                    Log.e("MicroMsg.AdLandingPageDownloadCDNFileTask", "delErrFile, succ");
                } else {
                    Log.e("MicroMsg.AdLandingPageDownloadCDNFileTask", "delErrFile, failed");
                }
            } else {
                Log.e("MicroMsg.AdLandingPageDownloadCDNFileTask", "delErrFile, file not exists");
            }
            j.b(j.DEa, str2, this.fileType, i2, "cdn|".concat(String.valueOf(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext()))));
            AppMethodBeat.o(203152);
        } catch (Throwable th) {
            Log.e("MicroMsg.AdLandingPageDownloadCDNFileTask", "delErrFile, exp=" + th.toString());
            AppMethodBeat.o(203152);
        }
    }
}
