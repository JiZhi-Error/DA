package com.tencent.mm.plugin.sns.ad.widget.living;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.ArrayMap;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.i.c;
import com.tencent.mm.protocal.protobuf.bz;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class b {
    static volatile b DAI;
    private final Map<String, Integer> DAJ = new ArrayMap();
    private final Map<String, WeakReference<a>> DAK = new ArrayMap();

    public interface a {
        void fw(String str, int i2);
    }

    public b() {
        AppMethodBeat.i(202425);
        AppMethodBeat.o(202425);
    }

    private static b eYv() {
        AppMethodBeat.i(202426);
        if (DAI == null) {
            synchronized (b.class) {
                try {
                    if (DAI == null) {
                        DAI = new b();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(202426);
                    throw th;
                }
            }
        }
        b bVar = DAI;
        AppMethodBeat.o(202426);
        return bVar;
    }

    private void ft(String str, int i2) {
        WeakReference<a> weakReference;
        a aVar;
        AppMethodBeat.i(202427);
        Integer put = this.DAJ.put(str, Integer.valueOf(i2));
        if (!((put != null && put.equals(Integer.valueOf(i2))) || (weakReference = this.DAK.get(str)) == null || (aVar = weakReference.get()) == null)) {
            if (put != null) {
                put.intValue();
            }
            aVar.fw(str, i2);
        }
        AppMethodBeat.o(202427);
    }

    private static int aNU(String str) {
        int i2 = 0;
        AppMethodBeat.i(202428);
        try {
            i2 = new JSONObject(str).optInt("liveStatus", 0);
            AppMethodBeat.o(202428);
        } catch (Throwable th) {
            AppMethodBeat.o(202428);
        }
        return i2;
    }

    public static int fu(String str, int i2) {
        int i3;
        AppMethodBeat.i(202429);
        try {
            Integer num = eYv().DAJ.get(str);
            if (num != null) {
                i3 = num.intValue();
            } else {
                i3 = 0;
            }
            if (i3 == 0) {
                if (i2 == 1) {
                    i3 = CdnLogic.kAppTypeFestivalImage;
                } else if (i2 == 2) {
                    i3 = 770;
                }
            }
            AppMethodBeat.o(202429);
            return i3;
        } catch (Throwable th) {
            AppMethodBeat.o(202429);
            return 0;
        }
    }

    public static void fv(String str, int i2) {
        AppMethodBeat.i(202430);
        try {
            if (!TextUtils.isEmpty(str)) {
                eYv().ft(str, i2);
            }
            AppMethodBeat.o(202430);
        } catch (Throwable th) {
            AppMethodBeat.o(202430);
        }
    }

    public static int C(String str, List<bz> list) {
        bz bzVar;
        AppMethodBeat.i(202431);
        try {
            Iterator<bz> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    bzVar = null;
                    break;
                }
                bzVar = it.next();
                if (bzVar.pTI == 2) {
                    break;
                }
            }
            if (bzVar != null) {
                int aNU = aNU(bzVar.data);
                Log.d("SnsAd.LivingStatusManager", "parseAndPutLivingStatus:: the sns id is " + str + ", the living status is " + aNU);
                eYv().ft(str, aNU);
                AppMethodBeat.o(202431);
                return aNU;
            }
            Log.d("SnsAd.LivingStatusManager", "parseAndPutLivingStatus:: the sns id is " + str + " and the living item is null!!");
            AppMethodBeat.o(202431);
            return 0;
        } catch (Throwable th) {
        }
    }

    public static void a(String str, a aVar) {
        boolean z;
        String str2;
        AppMethodBeat.i(202432);
        try {
            b eYv = eYv();
            long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            if (aVar != null && !TextUtils.isEmpty(str)) {
                WeakReference<a> weakReference = eYv.DAK.get(str);
                if (weakReference == null || aVar != weakReference.get()) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    if (c.aI(eYv.DAK)) {
                        try {
                            Iterator<Map.Entry<String, WeakReference<a>>> it = eYv.DAK.entrySet().iterator();
                            while (it.hasNext()) {
                                Map.Entry<String, WeakReference<a>> next = it.next();
                                if (next == null || next.getValue() == null || next.getValue().get() == null) {
                                    it.remove();
                                }
                            }
                        } catch (Throwable th) {
                        }
                    }
                    if (!c.isEmpty(eYv.DAK)) {
                        Iterator<Map.Entry<String, WeakReference<a>>> it2 = eYv.DAK.entrySet().iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                str2 = null;
                                break;
                            }
                            Map.Entry<String, WeakReference<a>> next2 = it2.next();
                            WeakReference<a> value = next2.getValue();
                            if (value != null && value.get() == aVar) {
                                str2 = next2.getKey();
                                break;
                            }
                        }
                        if (str2 != null) {
                            eYv.DAK.remove(str2);
                        }
                    }
                    eYv.DAK.put(str, new WeakReference<>(aVar));
                    Log.d("SnsAd.LivingStatusManager", "addStatusChangedListener new take times is " + (SystemClock.elapsedRealtimeNanos() - elapsedRealtimeNanos) + "ns");
                    AppMethodBeat.o(202432);
                    return;
                }
            }
            Log.i("SnsAd.LivingStatusManager", "the input sns id or listener is invalid, or there is same key-value of them.");
            AppMethodBeat.o(202432);
        } catch (Throwable th2) {
            AppMethodBeat.o(202432);
        }
    }
}
