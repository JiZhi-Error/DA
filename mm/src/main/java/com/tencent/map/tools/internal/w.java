package com.tencent.map.tools.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileOutputStream;

public class w {

    /* renamed from: a  reason: collision with root package name */
    private String f1422a = w.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private File f1423b = null;

    public w(String str) {
        AppMethodBeat.i(193550);
        this.f1423b = new File(str);
        AppMethodBeat.o(193550);
    }

    public final boolean a(byte[] bArr) {
        Throwable th;
        AppMethodBeat.i(193551);
        FileOutputStream fileOutputStream = null;
        try {
            if (!this.f1423b.exists()) {
                File file = new File(this.f1423b.getParent());
                if (!file.exists()) {
                    file.mkdirs();
                    this.f1423b.createNewFile();
                }
            }
            FileOutputStream fileOutputStream2 = new FileOutputStream(this.f1423b, false);
            try {
                fileOutputStream2.write(bArr);
                fileOutputStream2.close();
                try {
                    fileOutputStream2.close();
                } catch (Exception e2) {
                }
                AppMethodBeat.o(193551);
                return true;
            } catch (Exception e3) {
                fileOutputStream = fileOutputStream2;
                try {
                    fileOutputStream.close();
                } catch (Exception e4) {
                }
                AppMethodBeat.o(193551);
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                try {
                    fileOutputStream.close();
                } catch (Exception e5) {
                }
                AppMethodBeat.o(193551);
                throw th;
            }
        } catch (Exception e6) {
            fileOutputStream.close();
            AppMethodBeat.o(193551);
            return false;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream.close();
            AppMethodBeat.o(193551);
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x008b, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x008c, code lost:
        r2 = r1;
        r3 = r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x008b A[ExcHandler: all (r1v2 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:18:0x003c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(java.lang.String r7) {
        /*
        // Method dump skipped, instructions count: 145
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.map.tools.internal.w.a(java.lang.String):java.lang.String");
    }
}
