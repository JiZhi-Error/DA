package com.tencent.mm.plugin.ext.d;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.sg;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.ext.d.d;
import com.tencent.mm.plugin.facedetect.model.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.SyncTask;

public class e {
    public static e sOc = null;
    public Context mContext = null;

    public static e cSE() {
        e eVar;
        AppMethodBeat.i(24501);
        if (sOc == null) {
            synchronized (e.class) {
                try {
                    if (sOc == null) {
                        sOc = new e();
                    }
                    eVar = sOc;
                } finally {
                    AppMethodBeat.o(24501);
                }
            }
            return eVar;
        }
        e eVar2 = sOc;
        AppMethodBeat.o(24501);
        return eVar2;
    }

    private e() {
    }

    public static void Z(String str, int i2, int i3) {
        AppMethodBeat.i(24502);
        h.INSTANCE.a(14869, str, Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(24502);
    }

    public static void aa(String str, int i2, int i3) {
        AppMethodBeat.i(24503);
        h.INSTANCE.a(14868, str, Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(24503);
    }

    public static Cursor cSF() {
        AppMethodBeat.i(24504);
        Log.i("MicroMsg.ExtQrCodeHandler", "hy: release temp mapping");
        c.clearCache();
        MatrixCursor ahx = com.tencent.mm.pluginsdk.d.a.a.ahx(1);
        AppMethodBeat.o(24504);
        return ahx;
    }

    public static d.b bc(String str, boolean z) {
        AppMethodBeat.i(24505);
        d.b bb = d.cSD().bb(str, z);
        AppMethodBeat.o(24505);
        return bb;
    }

    public final a a(final d.b bVar) {
        AppMethodBeat.i(24506);
        long currentTimeMillis = System.currentTimeMillis();
        a aVar = (a) new SyncTask<a>(new a()) {
            /* class com.tencent.mm.plugin.ext.d.e.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.tencent.mm.sdk.platformtools.SyncTask
            public final /* synthetic */ a run() {
                AppMethodBeat.i(24496);
                a cSH = cSH();
                AppMethodBeat.o(24496);
                return cSH;
            }

            private a cSH() {
                AppMethodBeat.i(24495);
                try {
                    Log.d("MicroMsg.ExtQrCodeHandler", "hy: start scan qrcode");
                    if (bVar != null) {
                        sg sgVar = new sg();
                        sgVar.dYR.width = bVar.previewWidth;
                        sgVar.dYR.height = bVar.previewHeight;
                        sgVar.dYR.dYS = bVar.sOb;
                        sgVar.dYR.dYT = bVar.dYT;
                        sgVar.dYR.yuvData = bVar.yuvData;
                        sgVar.dYR.dYU = new r() {
                            /* class com.tencent.mm.plugin.ext.d.e.AnonymousClass1.AnonymousClass1 */
                        };
                        EventCenter.instance.publish(sgVar);
                    } else {
                        Log.w("MicroMsg.ExtQrCodeHandler", "hy: qrcode data not retrieved");
                        setResultFinish(null);
                    }
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.ExtQrCodeHandler", e2, "hy: error when syncTaskScanQrCode", new Object[0]);
                    setResultFinish(null);
                }
                AppMethodBeat.o(24495);
                return null;
            }
        }.exec(cSG());
        Object[] objArr = new Object[2];
        objArr[0] = aVar != null ? aVar.toString() : BuildConfig.COMMAND;
        objArr[1] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
        Log.i("MicroMsg.ExtQrCodeHandler", "hy: resolved qrcode: %s, using: %d ms", objArr);
        AppMethodBeat.o(24506);
        return aVar;
    }

    public static MMHandler cSG() {
        AppMethodBeat.i(24507);
        MMHandler mMHandler = new MMHandler(Looper.getMainLooper());
        AppMethodBeat.o(24507);
        return mMHandler;
    }

    public static class a {
        public int sOh;
        private boolean sOi;
        public int type;
        public String url;

        public a() {
            this.sOi = false;
            this.sOi = true;
        }

        public final String toString() {
            AppMethodBeat.i(24500);
            String str = "QrCodeModel{type=" + this.type + ", url='" + this.url + '\'' + ", flagTimeout=" + this.sOi + '}';
            AppMethodBeat.o(24500);
            return str;
        }
    }
}
