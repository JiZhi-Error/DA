package com.tencent.mm.plugin.sns.device.appstore;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.device.appstore.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class a {
    private final List<c> DES;
    private final WeakReference<? extends Context> mContextRef;

    public static a b(Context context, Map<String, String> map) {
        AppMethodBeat.i(202628);
        try {
            a aVar = new a(context, map);
            AppMethodBeat.o(202628);
            return aVar;
        } catch (Throwable th) {
            Log.e("MICROMSG.AdAppMarketHelper", "create aAdAppMarketHelper failed!");
            AppMethodBeat.o(202628);
            return null;
        }
    }

    private a(Context context, Map<String, String> map) {
        AppMethodBeat.i(202630);
        this.mContextRef = new WeakReference<>(context);
        this.DES = aK(map);
        AppMethodBeat.o(202630);
    }

    private static List<c> aK(Map<String, String> map) {
        String str;
        int i2;
        AppMethodBeat.i(202631);
        ArrayList arrayList = new ArrayList();
        if (map.containsKey(".adxml.adCanvasInfo.adMarketJump.marketTag.marketSchema") || !map.containsKey(".RecXml.adxml.adCanvasInfo.adMarketJump.marketTag.marketSchema")) {
            str = ".adxml.adCanvasInfo.adMarketJump.";
        } else {
            str = ".RecXml.adxml.adCanvasInfo.adMarketJump.";
        }
        String fx = fx(str + "marketTag", 0);
        int i3 = 0;
        while (map.containsKey(fx + ".marketSchema") && i3 < 20) {
            c cVar = new c();
            cVar.DFa = map.get(fx + ".brand");
            cVar.DEW = map.get(fx + ".appPackage");
            cVar.DEX = map.get(fx + ".marketName");
            cVar.DEZ = d(map, fx, "marketPackage");
            cVar.DEY = d(map, fx, "marketSchema");
            String str2 = Build.BRAND;
            String str3 = Build.MANUFACTURER;
            String str4 = cVar.DFa;
            cVar.mPriority = 2;
            if (!TextUtils.isEmpty(str4) && str2 != null) {
                String lowerCase = str4.toLowerCase();
                String lowerCase2 = str2.toLowerCase();
                if (lowerCase.equals(lowerCase2)) {
                    cVar.mPriority = 0;
                } else {
                    if (!(lowerCase == null || str3 == null)) {
                        String lowerCase3 = lowerCase.toLowerCase();
                        String lowerCase4 = str3.toLowerCase();
                        if (lowerCase3.equals(lowerCase4)) {
                            i2 = 0;
                        } else if (lowerCase3.contains(lowerCase4)) {
                            i2 = 1;
                        } else if (lowerCase4.contains(lowerCase3)) {
                            i2 = 2;
                        }
                        cVar.mPriority = i2;
                        if (cVar.mPriority >= 2 && lowerCase.contains(lowerCase2)) {
                            cVar.mPriority = 1;
                        }
                    }
                    i2 = 3;
                    cVar.mPriority = i2;
                    cVar.mPriority = 1;
                }
            }
            arrayList.add(cVar);
            i3++;
            fx = fx(str + "marketTag", i3);
        }
        Collections.sort(arrayList, new c.a());
        AppMethodBeat.o(202631);
        return arrayList;
    }

    private static String fx(String str, int i2) {
        AppMethodBeat.i(202632);
        if (i2 == 0) {
            AppMethodBeat.o(202632);
            return str;
        }
        String str2 = str + i2;
        AppMethodBeat.o(202632);
        return str2;
    }

    private static List<String> d(Map<String, String> map, String str, String str2) {
        int i2 = 0;
        AppMethodBeat.i(202633);
        ArrayList arrayList = new ArrayList();
        String fx = fx(str + "." + str2, 0);
        while (map.containsKey(fx) && i2 < 10) {
            String str3 = map.get(fx);
            if (!TextUtils.isEmpty(str3)) {
                arrayList.add(str3);
            }
            i2++;
            fx = fx(str + "." + str2, i2);
        }
        AppMethodBeat.o(202633);
        return arrayList;
    }

    private static boolean Yp(int i2) {
        return i2 <= 1;
    }

    private static void d(Intent intent, boolean z) {
        AppMethodBeat.i(202634);
        if (intent != null) {
            try {
                intent.putExtra("brand_state", z);
            } catch (Throwable th) {
                Log.w("MICROMSG.AdAppMarketHelper", "setBrandState has something error");
                AppMethodBeat.o(202634);
                return;
            }
        }
        AppMethodBeat.o(202634);
    }

    public static boolean aU(Intent intent) {
        boolean z = false;
        AppMethodBeat.i(202635);
        if (intent != null) {
            try {
                z = intent.getBooleanExtra("brand_state", false);
                AppMethodBeat.o(202635);
            } catch (Throwable th) {
                Log.w("MICROMSG.AdAppMarketHelper", "setBrandState has something error");
            }
            return z;
        }
        AppMethodBeat.o(202635);
        return z;
    }

    public static boolean aV(Intent intent) {
        AppMethodBeat.i(202636);
        if (intent != null) {
            try {
                if (!TextUtils.isEmpty(intent.getAction()) && intent.getData() != null) {
                    AppMethodBeat.o(202636);
                    return true;
                }
            } catch (Throwable th) {
                Log.w("MICROMSG.AdAppMarketHelper", "isAppMarketIntentValid has something error");
            }
        }
        AppMethodBeat.o(202636);
        return false;
    }

    private static void b(String str, String str2, String str3, int i2, String str4, String str5) {
        AppMethodBeat.i(202637);
        try {
            h.INSTANCE.a(19790, str, str2, str3, Integer.valueOf(i2), str4, str5);
            Log.i("MICROMSG.AdAppMarketHelper", "report19790 snsId=" + str + ", uxInfo=" + str2 + ", adExtInfo =" + str3 + ", actType =" + i2 + ", actValue = " + str4 + ", extInfo = " + str5);
            AppMethodBeat.o(202637);
        } catch (Throwable th) {
            Log.e("MICROMSG.AdAppMarketHelper", "report19790 exp:" + th.toString());
            AppMethodBeat.o(202637);
        }
    }

    public static void a(String str, String str2, String str3, int i2, String str4, Map<String, Object> map) {
        AppMethodBeat.i(202638);
        b(str, str2, str3, i2, str4, aL(map));
        AppMethodBeat.o(202638);
    }

    private static String aL(Map<String, Object> map) {
        AppMethodBeat.i(202639);
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    JSONObject jSONObject = new JSONObject();
                    for (String str : map.keySet()) {
                        jSONObject.put(str, map.get(str));
                    }
                    String jSONObject2 = jSONObject.toString();
                    AppMethodBeat.o(202639);
                    return jSONObject2;
                }
            } catch (Throwable th) {
            }
        }
        AppMethodBeat.o(202639);
        return "";
    }

    public final Intent eZA() {
        c cVar;
        Intent intent;
        AppMethodBeat.i(202629);
        try {
            Context context = (Context) this.mContextRef.get();
            if (context == null) {
                Log.w("MICROMSG.AdAppMarketHelper", "the context is null, activity is finished?");
                AppMethodBeat.o(202629);
                return null;
            }
            List<c> list = this.DES;
            if (list != null) {
                for (c cVar2 : list) {
                    if (cVar2 != null) {
                        if (context != null) {
                            PackageManager packageManager = context.getPackageManager();
                            ArrayList arrayList = new ArrayList();
                            for (b bVar : cVar2.eZC()) {
                                Intent eZB = bVar.eZB();
                                if (eZB != null) {
                                    arrayList.add(eZB);
                                }
                            }
                            Iterator it = arrayList.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                intent = (Intent) it.next();
                                if (intent.resolveActivity(packageManager) != null) {
                                    intent.putExtra("market_priority", cVar2.mPriority);
                                    break;
                                }
                            }
                        }
                        intent = null;
                        if (intent != null) {
                            d(intent, Yp(cVar2.mPriority));
                            AppMethodBeat.o(202629);
                            return intent;
                        }
                    }
                }
                if (!list.isEmpty() && (cVar = list.get(0)) != null) {
                    Intent intent2 = new Intent();
                    String str = cVar.DEW;
                    try {
                        if (!TextUtils.isEmpty(str)) {
                            intent2.putExtra("target_app_id", str);
                        }
                    } catch (Throwable th) {
                        Log.w("MICROMSG.AdAppMarketHelper", "setBrandState has something error");
                    }
                    d(intent2, Yp(cVar.mPriority));
                    AppMethodBeat.o(202629);
                    return intent2;
                }
            }
            AppMethodBeat.o(202629);
            return null;
        } catch (Throwable th2) {
            Log.d("MICROMSG.AdAppMarketHelper", "screen intent failed");
            AppMethodBeat.o(202629);
            return null;
        }
    }
}
