package c.t.m.sapp.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class k {

    /* renamed from: a  reason: collision with root package name */
    public File f79a;

    /* renamed from: b  reason: collision with root package name */
    public File f80b;

    /* renamed from: c  reason: collision with root package name */
    public Context f81c;

    public k(Context context) {
        AppMethodBeat.i(222987);
        if (context == null) {
            AppMethodBeat.o(222987);
            return;
        }
        this.f81c = context.getApplicationContext();
        try {
            this.f79a = new File(context.getExternalFilesDir("data").getAbsolutePath() + "/d_l");
            AppMethodBeat.o(222987);
        } catch (Throwable th) {
            this.f79a = null;
            AppMethodBeat.o(222987);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0048 A[SYNTHETIC, Splitter:B:23:0x0048] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0059 A[SYNTHETIC, Splitter:B:33:0x0059] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(byte[] r7) {
        /*
        // Method dump skipped, instructions count: 118
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.sapp.c.k.a(byte[]):void");
    }

    public final File a() {
        AppMethodBeat.i(222989);
        try {
            File file = this.f79a;
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, "d_" + q.c(System.currentTimeMillis() + ""));
            AppMethodBeat.o(222989);
            return file2;
        } catch (Throwable th) {
            AppMethodBeat.o(222989);
            return null;
        }
    }
}
