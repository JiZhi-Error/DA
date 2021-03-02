package com.tencent.mm.plugin.appbrand.ipc.a;

import android.os.SystemClock;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\u0012J\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\t0\u00142\u0006\u0010\u0015\u001a\u00020\u000fJ\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ipc/util/IpcBigDataTransfer;", "", "()V", "BUFF_MAX_LIMIT", "", "CLEAN_CHECK_INTERVAL", "", "MMKV_FILE_DANGER_SIZE", "MMKV_NANE", "", "TAG", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "get", "", "key", "clear", "", "save", "Lkotlin/Pair;", "data", "tryCleanInvalidData", "", "plugin-appbrand-integration_release"})
public final class a {
    private static final MultiProcessMMKV cQe = MultiProcessMMKV.getMMKV("jsapi_ipc_big_data_transfer");
    private static final long lxd = TimeUnit.DAYS.toMillis(1);
    public static final a lxe = new a();

    static {
        AppMethodBeat.i(228227);
        AppMethodBeat.o(228227);
    }

    private a() {
    }

    public static o<Boolean, String> aH(byte[] bArr) {
        AppMethodBeat.i(228224);
        p.h(bArr, "data");
        if (bArr.length >= 102400) {
            String str = String.valueOf(SystemClock.elapsedRealtimeNanos());
            cQe.encode(str, bArr);
            o<Boolean, String> oVar = new o<>(Boolean.TRUE, str);
            AppMethodBeat.o(228224);
            return oVar;
        }
        o<Boolean, String> oVar2 = new o<>(Boolean.FALSE, "");
        AppMethodBeat.o(228224);
        return oVar2;
    }

    public static byte[] Za(String str) {
        AppMethodBeat.i(228225);
        p.h(str, "key");
        byte[] decodeBytes = cQe.decodeBytes(str);
        cQe.remove(str);
        p.g(decodeBytes, "mmkv.decodeBytes(key).al…mkv.remove(key)\n        }");
        AppMethodBeat.o(228225);
        return decodeBytes;
    }

    public static void bDV() {
        AppMethodBeat.i(228226);
        h.RTc.aX(RunnableC0590a.lxf);
        AppMethodBeat.o(228226);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.appbrand.ipc.a.a$a  reason: collision with other inner class name */
    static final class RunnableC0590a implements Runnable {
        public static final RunnableC0590a lxf = new RunnableC0590a();

        static {
            AppMethodBeat.i(228223);
            AppMethodBeat.o(228223);
        }

        RunnableC0590a() {
        }

        public final void run() {
            boolean z = true;
            AppMethodBeat.i(228222);
            try {
                e aAh = g.aAh();
                p.g(aAh, "MMKernel.storage()");
                long a2 = aAh.azQ().a(ar.a.USERINFO_APPBRAND_JSAPI_BIG_DATA_TRANSFER_MMKV_CHECK_CLEAN_TIMESTAMP_LONG, 0);
                a aVar = a.lxe;
                if (a2 + a.lxd <= Util.nowMilliSecond()) {
                    try {
                        a aVar2 = a.lxe;
                        if (a.cQe.totalSize() < 20971520) {
                            z = false;
                        }
                        Log.i("JsApiIpcBigDataTransfer", "do check  mmkv file too large, needClear[%b]", Boolean.valueOf(z));
                        if (z) {
                            a aVar3 = a.lxe;
                            a.cQe.clearAll();
                        }
                        return;
                    } catch (Throwable th) {
                        Log.e("JsApiIpcBigDataTransfer", "do check  mmkv file too large, exception = %s", th);
                        return;
                    } finally {
                        e aAh2 = g.aAh();
                        p.g(aAh2, "MMKernel.storage()");
                        aAh2.azQ().set(ar.a.USERINFO_APPBRAND_JSAPI_BIG_DATA_TRANSFER_MMKV_CHECK_CLEAN_TIMESTAMP_LONG, Long.valueOf(Util.nowMilliSecond()));
                        AppMethodBeat.o(228222);
                    }
                }
            } catch (Throwable th2) {
            }
            AppMethodBeat.o(228222);
        }
    }
}
