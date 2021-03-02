package c.t.m.sapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileOutputStream;

public class r {

    /* renamed from: a  reason: collision with root package name */
    public String f100a = "WriterAndReader";

    /* renamed from: b  reason: collision with root package name */
    public File f101b = null;

    public r(String str) {
        AppMethodBeat.i(223062);
        this.f101b = new File(str);
        AppMethodBeat.o(223062);
    }

    public boolean a(byte[] bArr, boolean z) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        Throwable th;
        AppMethodBeat.i(223063);
        try {
            if (!this.f101b.exists()) {
                File file = new File(this.f101b.getParent());
                if (!file.exists()) {
                    file.mkdirs();
                    this.f101b.createNewFile();
                }
            }
            fileOutputStream = new FileOutputStream(this.f101b, z);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.close();
                try {
                    fileOutputStream.close();
                } catch (Exception e2) {
                }
                AppMethodBeat.o(223063);
                return true;
            } catch (Exception e3) {
                try {
                    fileOutputStream.close();
                } catch (Exception e4) {
                }
                AppMethodBeat.o(223063);
                return false;
            } catch (Throwable th2) {
                fileOutputStream2 = fileOutputStream;
                th = th2;
                try {
                    fileOutputStream2.close();
                } catch (Exception e5) {
                }
                AppMethodBeat.o(223063);
                throw th;
            }
        } catch (Exception e6) {
            fileOutputStream = null;
            fileOutputStream.close();
            AppMethodBeat.o(223063);
            return false;
        } catch (Throwable th3) {
            fileOutputStream2 = null;
            th = th3;
            fileOutputStream2.close();
            AppMethodBeat.o(223063);
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0088, code lost:
        r0 = th;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0088 A[ExcHandler: all (th java.lang.Throwable), PHI: r1 
      PHI: (r1v0 java.io.FileInputStream) = (r1v6 java.io.FileInputStream), (r1v6 java.io.FileInputStream), (r1v6 java.io.FileInputStream), (r1v6 java.io.FileInputStream), (r1v7 java.io.FileInputStream) binds: [B:17:0x003b, B:19:0x003e, B:20:?, B:18:?, B:11:0x002c] A[DONT_GENERATE, DONT_INLINE], Splitter:B:17:0x003b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(java.lang.String r7) {
        /*
        // Method dump skipped, instructions count: 138
        */
        throw new UnsupportedOperationException("Method not decompiled: c.t.m.sapp.c.r.a(java.lang.String):java.lang.String");
    }
}
