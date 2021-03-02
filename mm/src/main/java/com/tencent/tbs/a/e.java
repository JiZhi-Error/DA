package com.tencent.tbs.a;

import android.content.Context;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.a.a.b;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class e {
    private static c RSk = c.RSl;
    private static a RSo;

    /* renamed from: a  reason: collision with root package name */
    private static volatile Boolean f2311a = Boolean.FALSE;

    /* renamed from: c  reason: collision with root package name */
    private static List<d> f2312c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f2313d;

    /* renamed from: f  reason: collision with root package name */
    private static String f2314f = "";

    private static boolean f() {
        AppMethodBeat.i(174270);
        if (!f2311a.booleanValue()) {
            new Throwable("TBSLog has not been initialized! Please call TBSLog.initialize() first.");
        }
        boolean booleanValue = f2311a.booleanValue();
        AppMethodBeat.o(174270);
        return booleanValue;
    }

    public static String a() {
        return f2314f;
    }

    public static void a(int i2, String str, String str2) {
        AppMethodBeat.i(174272);
        if (!f()) {
            AppMethodBeat.o(174272);
            return;
        }
        RSo.f2315a = str;
        a aVar = RSo;
        c aqN = c.aqN(i2);
        String str3 = aVar.f2315a;
        try {
            if (!f()) {
                AppMethodBeat.o(174272);
            } else if (aqN.f2309h < RSk.f2309h) {
                AppMethodBeat.o(174272);
            } else {
                b bVar = new b(System.currentTimeMillis(), aqN, str3, str2);
                if (f2313d) {
                    for (d dVar : f2312c) {
                        dVar.a(bVar);
                    }
                }
                AppMethodBeat.o(174272);
            }
        } catch (Exception e2) {
            AppMethodBeat.o(174272);
        }
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        String f2315a;

        /* synthetic */ a(byte b2) {
            this();
        }

        private a() {
            AppMethodBeat.i(174267);
            this.f2315a = getClass().getName();
            AppMethodBeat.o(174267);
        }
    }

    public static void cV(Context context, String str) {
        AppMethodBeat.i(174269);
        try {
            if (!f2311a.booleanValue()) {
                RSo = new a((byte) 0);
                ArrayList arrayList = new ArrayList();
                f2312c = arrayList;
                arrayList.add(new b(context, new com.tencent.tbs.a.a.c.a(), new com.tencent.tbs.a.a.b.b(), new com.tencent.tbs.a.a.a.b()));
                File file = null;
                if ("mounted".equals(Environment.getExternalStorageState())) {
                    file = context.getExternalFilesDir(str);
                }
                if (file != null) {
                    f2314f = file.getAbsolutePath();
                } else {
                    f2314f = context.getFilesDir() + File.separator + str;
                }
                RSk = c.RSl;
                f2313d = true;
                f2311a = Boolean.TRUE;
            }
            AppMethodBeat.o(174269);
        } catch (Exception e2) {
            AppMethodBeat.o(174269);
        }
    }
}
