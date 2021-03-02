package com.tencent.map.tools.internal;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class u {

    /* renamed from: a  reason: collision with root package name */
    private static final String f1410a = u.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private File f1411b;

    /* renamed from: c  reason: collision with root package name */
    private File f1412c;

    /* renamed from: d  reason: collision with root package name */
    private Context f1413d;

    /* renamed from: e  reason: collision with root package name */
    private String f1414e = "d";

    /* renamed from: f  reason: collision with root package name */
    private String f1415f = (this.f1414e + "_");

    /* renamed from: g  reason: collision with root package name */
    private long f1416g = 20480;

    /* renamed from: h  reason: collision with root package name */
    private File f1417h;

    static {
        AppMethodBeat.i(180858);
        AppMethodBeat.o(180858);
    }

    public u(Context context, File file, String str) {
        File file2;
        AppMethodBeat.i(193543);
        if (context == null) {
            AppMethodBeat.o(193543);
            return;
        }
        this.f1413d = context.getApplicationContext();
        this.f1411b = file;
        this.f1412c = file;
        this.f1414e = str;
        this.f1415f = this.f1414e + "_";
        this.f1416g = 20480;
        if (this.f1417h == null) {
            File file3 = this.f1411b;
            if (file3 == null) {
                file2 = null;
            } else {
                if (!file3.exists()) {
                    file3.mkdirs();
                }
                file2 = new File(file3, this.f1414e);
            }
            this.f1417h = file2;
        }
        if (this.f1417h != null && this.f1417h.exists()) {
            this.f1417h.delete();
        }
        AppMethodBeat.o(193543);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x004b A[SYNTHETIC, Splitter:B:26:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0064 A[SYNTHETIC, Splitter:B:36:0x0064] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(byte[] r10) {
        /*
        // Method dump skipped, instructions count: 166
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.map.tools.internal.u.a(byte[]):void");
    }
}
