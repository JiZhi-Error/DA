package com.tencent.mm.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;

public final class d {
    private static a OyG;
    private static HashMap<Integer, Long> OyH = new HashMap<>();
    private static int OyI = 1100;
    private static int OyJ = 2000;
    private static long OyK = 0;

    public interface a {
        void c(long j2, String str, String str2);
    }

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface b {
    }

    static {
        AppMethodBeat.i(141281);
        AppMethodBeat.o(141281);
    }

    public static synchronized boolean a(Context context, boolean z, Intent[] intentArr, Object... objArr) {
        boolean z2;
        synchronized (d.class) {
            AppMethodBeat.i(141278);
            int length = intentArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    long currentTimeMillis = System.currentTimeMillis();
                    StringBuilder sb = new StringBuilder();
                    sb.append(context.toString()).append(",");
                    for (Intent intent : intentArr) {
                        sb.append(intent);
                        sb.append(",");
                    }
                    for (Object obj : objArr) {
                        sb.append(obj);
                        sb.append(",");
                    }
                    String sb2 = sb.toString();
                    Integer valueOf = Integer.valueOf(sb2.hashCode());
                    Long l = OyH.get(valueOf);
                    Long valueOf2 = Long.valueOf(System.currentTimeMillis());
                    if (z && l != null) {
                        if (valueOf2.longValue() - l.longValue() <= ((long) OyJ)) {
                            OyG.c(valueOf2.longValue() - l.longValue(), blL(context.getClass().toString()), intentArr[0].getComponent() != null ? blL(intentArr[0].getComponent().getClassName()) : "None");
                        }
                        if (valueOf2.longValue() - l.longValue() <= ((long) OyI)) {
                            OyH.put(valueOf, valueOf2);
                            Log.e("MicroMsg.CheckReduplicatedAcitiv", "starting the same activity in %sms, [k:%s, v:%s], curr: %s", Integer.valueOf(OyI), sb2, l, valueOf2);
                            z2 = true;
                            AppMethodBeat.o(141278);
                        }
                    }
                    if (OyH.size() > 100 && OyK != 0 && System.currentTimeMillis() - OyK > ((long) OyI)) {
                        OyH.clear();
                    }
                    OyH.put(valueOf, valueOf2);
                    OyK = System.currentTimeMillis();
                    Log.i("MicroMsg.CheckReduplicatedAcitiv", "check reduplicated cost %sms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    z2 = false;
                    AppMethodBeat.o(141278);
                } else if (bx(intentArr[i2])) {
                    z2 = false;
                    AppMethodBeat.o(141278);
                    break;
                } else {
                    i2++;
                }
            }
        }
        return z2;
    }

    public static void a(a aVar) {
        OyG = aVar;
    }

    private static String blL(String str) {
        AppMethodBeat.i(141279);
        String[] split = str.split("\\.");
        if (split.length > 0) {
            String str2 = split[split.length - 1];
            AppMethodBeat.o(141279);
            return str2;
        }
        AppMethodBeat.o(141279);
        return "";
    }

    public static int gGT() {
        return OyI;
    }

    private static boolean bx(Intent intent) {
        AppMethodBeat.i(141280);
        if (intent != null) {
            try {
                if (intent.getComponent() != null && !Util.isNullOrNil(intent.getComponent().getClassName())) {
                    if (Class.forName(intent.getComponent().getClassName()).getAnnotation(b.class) != null) {
                        AppMethodBeat.o(141280);
                        return true;
                    }
                    AppMethodBeat.o(141280);
                    return false;
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.CheckReduplicatedAcitiv", "skipReduplicateCheck exception %s", e2);
                AppMethodBeat.o(141280);
                return false;
            }
        }
        AppMethodBeat.o(141280);
        return false;
    }
}
