package com.tencent.mm.modelgeo;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Pair;
import com.tencent.f.c.d;
import com.tencent.map.geolocation.sapp.TencentLocationListener;
import com.tencent.map.geolocation.sapp.TencentLocationManager;
import com.tencent.map.geolocation.sapp.TencentLocationManagerOptions;
import com.tencent.map.geolocation.sapp.TencentLocationRequest;
import com.tencent.map.geolocation.sapp.internal.LocationLogCallback;
import com.tencent.map.geolocation.sapp.internal.TencentExtraKeys;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class h {
    private static h iVO = null;
    private static Context mContext;
    private MMHandler iVP;

    public static class a extends Exception {
    }

    private h() {
        AppMethodBeat.i(150507);
        HandlerThread bqq = d.bqq("SLocationManager");
        bqq.start();
        this.iVP = new MMHandler(bqq.getLooper());
        TencentExtraKeys.setContext(MMApplicationContext.getContext());
        try {
            TencentExtraKeys.setTencentLogCallback(new LocationLogCallback() {
                /* class com.tencent.mm.modelgeo.h.AnonymousClass1 */

                /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                @Override // com.tencent.map.geolocation.sapp.internal.LocationLogCallback
                public final void onLog(int i2, String str, String str2, Throwable th) {
                    AppMethodBeat.i(150504);
                    switch (i2) {
                        case 2:
                            Log.v("MicroMsg.SLocationManager", "tag:%s msg:%s", str, str2);
                            AppMethodBeat.o(150504);
                            return;
                        case 3:
                            Log.d("MicroMsg.SLocationManager", "tag:%s msg:%s", str, str2);
                            AppMethodBeat.o(150504);
                            return;
                        case 4:
                            Log.i("MicroMsg.SLocationManager", "tag:%s msg:%s", str, str2);
                            AppMethodBeat.o(150504);
                            return;
                        case 5:
                            Log.w("MicroMsg.SLocationManager", "tag:%s msg:%s", str, str2);
                            AppMethodBeat.o(150504);
                            return;
                        case 6:
                            Object[] objArr = new Object[3];
                            objArr[0] = str;
                            objArr[1] = str2;
                            objArr[2] = th != null ? th.getMessage() : "";
                            Log.e("MicroMsg.SLocationManager", "tag:%s msg:%s th:%s", objArr);
                            break;
                    }
                    AppMethodBeat.o(150504);
                }
            });
            AppMethodBeat.o(150507);
        } catch (Exception e2) {
            Log.printInfoStack("MicroMsg.SLocationManager", "", e2);
            AppMethodBeat.o(150507);
        }
    }

    public static h da(Context context) {
        AppMethodBeat.i(150508);
        if (iVO == null) {
            iVO = new h();
        }
        mContext = context;
        h hVar = iVO;
        AppMethodBeat.o(150508);
        return hVar;
    }

    private void execute(Runnable runnable) {
        AppMethodBeat.i(150509);
        this.iVP.post(runnable);
        AppMethodBeat.o(150509);
    }

    public final void bcf() {
        AppMethodBeat.i(150510);
        execute(new Runnable() {
            /* class com.tencent.mm.modelgeo.h.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(150505);
                Log.d("MicroMsg.SLocationManager", "removeUpdate");
                TencentLocationManager.getInstance(h.mContext, new Pair(TencentLocationManager.TYPE_OAID, q.aoK())).removeUpdates(null);
                AppMethodBeat.o(150505);
            }
        });
        AppMethodBeat.o(150510);
    }

    public final void a(final TencentLocationListener tencentLocationListener, final int i2, final Looper looper) {
        AppMethodBeat.i(223570);
        execute(new Runnable() {
            /* class com.tencent.mm.modelgeo.h.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(150506);
                Log.d("MicroMsg.SLocationManager", "requestLocationUpdate %s, isLoaded %b", Integer.valueOf(i2), Boolean.valueOf(TencentLocationManagerOptions.isLoadLibraryEnabled()));
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(584, 0, 1, true);
                TencentLocationManager.getInstance(h.mContext, new Pair(TencentLocationManager.TYPE_OAID, q.aoK())).setCoordinateType(i2);
                TencentLocationRequest create = TencentLocationRequest.create();
                create.setInterval(2000);
                Log.i("MicroMsg.SLocationManager", "requestCode %d", Integer.valueOf(TencentLocationManager.getInstance(h.mContext, new Pair(TencentLocationManager.TYPE_OAID, q.aoK())).requestLocationUpdates(create, tencentLocationListener, looper)));
                AppMethodBeat.o(150506);
            }
        });
        AppMethodBeat.o(223570);
    }
}
