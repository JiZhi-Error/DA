package com.tencent.mm.plugin.appbrand.debugger;

import android.content.SharedPreferences;
import android.os.Debug;
import android.util.Base64;
import com.tencent.luggage.sdk.d.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.h;
import com.tencent.mm.b.s;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.appbrand.appcache.bg;
import com.tencent.mm.protocal.protobuf.euz;
import com.tencent.mm.protocal.protobuf.evf;
import com.tencent.mm.protocal.protobuf.evg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Random;
import org.json.JSONObject;

public final class v {
    private static String deviceID = null;
    public static m liX = null;
    private static int liY = 0;
    private static Boolean liZ = null;

    public static n XZ(String str) {
        AppMethodBeat.i(147095);
        Log.i("MicroMsg.RemoteDebugUtil", "parseRemoteDebugInfo extInfo=%s", str);
        n nVar = new n();
        if (!Util.isNullOrNil(str)) {
            try {
                JSONObject FE = h.FE(str);
                nVar.lin = FE.optBoolean("open_remote", false);
                nVar.roomId = FE.optString("room_id");
                nVar.lio = FE.optString("wxpkg_info");
                nVar.lip = FE.optString("qrcode_id");
                nVar.liq = FE.optInt("remote_network_type", 1);
                nVar.cyF = FE.optBoolean("disable_url_check", true);
                nVar.lir = FE.optInt("remote_proxy_port", 9976);
                nVar.lis = FE.optInt("remote_support_compress_algo");
            } catch (Exception e2) {
                Log.e("MicroMsg.RemoteDebugUtil", "parseRemoteDebugInfo %s", e2);
            }
        }
        AppMethodBeat.o(147095);
        return nVar;
    }

    public static void setUin(int i2) {
        liY = i2;
    }

    public static ByteBuffer g(a aVar) {
        AppMethodBeat.i(147096);
        try {
            ByteBuffer wrap = ByteBuffer.wrap(aVar.toByteArray());
            AppMethodBeat.o(147096);
            return wrap;
        } catch (IOException e2) {
            Log.w("MicroMsg.RemoteDebugUtil", e2.getMessage());
            ByteBuffer allocate = ByteBuffer.allocate(0);
            AppMethodBeat.o(147096);
            return allocate;
        }
    }

    private static b h(a aVar) {
        AppMethodBeat.i(147097);
        try {
            b cD = b.cD(aVar.toByteArray());
            AppMethodBeat.o(147097);
            return cD;
        } catch (IOException e2) {
            Log.w("MicroMsg.RemoteDebugUtil", e2.getMessage());
            b cD2 = b.cD(new byte[0]);
            AppMethodBeat.o(147097);
            return cD2;
        }
    }

    public static p a(a aVar, m mVar, String str) {
        AppMethodBeat.i(147098);
        evg evg = new evg();
        try {
            byte[] byteArray = aVar.toByteArray();
            if (byteArray.length <= 256 || mVar == null || !wl(mVar.lhV.lis)) {
                evg.LrK = b.cD(byteArray);
            } else {
                byte[] compress = s.compress(byteArray);
                evg.LrK = b.cD(compress);
                evg.MVo = 1;
                Log.v("MicroMsg.RemoteDebugUtil", "use zlib %d/%d", Integer.valueOf(byteArray.length), Integer.valueOf(compress.length));
            }
        } catch (IOException e2) {
            Log.e("MicroMsg.RemoteDebugUtil", "parseDebugMessageToSend %s", e2);
        }
        if (mVar == null) {
            Debug.waitForDebugger();
            Log.e("MicroMsg.RemoteDebugUtil", "env = null ");
        }
        evg.jlm = mVar.lhW.incrementAndGet();
        if (mVar.lhY == 0) {
            evg.apr = 0;
        } else {
            evg.apr = (int) (System.currentTimeMillis() - mVar.lhY);
        }
        mVar.lhY = System.currentTimeMillis();
        evg.category = str;
        Log.d("MicroMsg.RemoteDebugUtil", "parseDebugMessageToSend seq %d", Integer.valueOf(evg.jlm));
        p pVar = new p();
        pVar.lhG = System.currentTimeMillis();
        pVar.liC = evg.LrK.zy.length;
        pVar.liB = evg;
        AppMethodBeat.o(147098);
        return pVar;
    }

    public static evf a(int i2, a aVar) {
        AppMethodBeat.i(147099);
        evf evf = new evf();
        evf.EX = i2;
        if (Util.isNullOrNil(deviceID)) {
            deviceID = new Random(System.currentTimeMillis()).nextInt() + "-" + liY;
        }
        evf.uuid = deviceID + "-" + System.currentTimeMillis();
        evf.LrK = h(aVar);
        AppMethodBeat.o(147099);
        return evf;
    }

    public static boolean a(m mVar, evf evf, euz euz, w wVar, q qVar) {
        AppMethodBeat.i(147100);
        if (evf == null) {
            Log.w("MicroMsg.RemoteDebugUtil", "handleError dataFormat is null");
            AppMethodBeat.o(147100);
            return false;
        }
        int i2 = evf.EX;
        if (euz == null) {
            Log.w("MicroMsg.RemoteDebugUtil", "handleError cmd id: %d resp is null", Integer.valueOf(i2));
            AppMethodBeat.o(147100);
            return false;
        }
        if (i2 == 1006) {
            if (-50011 == euz.dIZ) {
                mVar.gW(true);
            } else {
                boolean isBusy = mVar.isBusy();
                mVar.gW(false);
                if (isBusy) {
                    qVar.bAR();
                }
            }
        }
        if (euz.dIZ == 0) {
            AppMethodBeat.o(147100);
            return true;
        }
        Log.i("MicroMsg.RemoteDebugUtil", "handleError cmd id: %d, uuid: %s, errorCode: %d, errMsg: %s", Integer.valueOf(i2), evf.uuid, Integer.valueOf(euz.dIZ), euz.dJa);
        MMHandlerThread.postToMainThread(new Runnable(i2, euz) {
            /* class com.tencent.mm.plugin.appbrand.debugger.w.AnonymousClass8 */
            final /* synthetic */ int ljr;
            final /* synthetic */ euz ljs;

            {
                this.ljr = r2;
                this.ljs = r3;
            }

            public final void run() {
                AppMethodBeat.i(147111);
                w.a(w.this, "cmdId " + this.ljr + ", errCode " + this.ljs.dIZ);
                AppMethodBeat.o(147111);
            }
        });
        AppMethodBeat.o(147100);
        return false;
    }

    public static boolean wl(int i2) {
        return (i2 & 1) != 0;
    }

    public static String a(String str, d dVar) {
        AppMethodBeat.i(147101);
        if (!dVar.OQ()) {
            AppMethodBeat.o(147101);
            return "";
        }
        String d2 = bg.d(dVar, str + ".map");
        if (Util.isNullOrNil(d2)) {
            AppMethodBeat.o(147101);
            return "";
        }
        try {
            String format = String.format("\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,%s", new String(Base64.encode(d2.getBytes(), 2), ProtocolPackage.ServerEncoding));
            AppMethodBeat.o(147101);
            return format;
        } catch (UnsupportedEncodingException e2) {
            Log.e("MicroMsg.RemoteDebugUtil", "execGameExternalScript Base64.encode %s", e2.getMessage());
            AppMethodBeat.o(147101);
            return "";
        }
    }

    public static boolean bAY() {
        AppMethodBeat.i(147102);
        if (liZ != null) {
            boolean booleanValue = liZ.booleanValue();
            AppMethodBeat.o(147102);
            return booleanValue;
        }
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("app_brand_global_sp", 0);
        if (sharedPreferences == null) {
            Log.w("MicroMsg.RemoteDebugUtil", "isHardCodeOpenGamePreload, sp is null.");
            AppMethodBeat.o(147102);
            return true;
        }
        boolean z = sharedPreferences.getBoolean("hard_code_open_game_preload", true);
        liZ = Boolean.valueOf(z);
        AppMethodBeat.o(147102);
        return z;
    }

    public static void gY(boolean z) {
        AppMethodBeat.i(147103);
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("app_brand_global_sp", 0);
        if (sharedPreferences == null) {
            Log.w("MicroMsg.RemoteDebugUtil", "setHardCodeOpenGamePreload, sp is null.");
            AppMethodBeat.o(147103);
            return;
        }
        sharedPreferences.edit().putBoolean("hard_code_open_game_preload", z).commit();
        AppMethodBeat.o(147103);
    }
}
