package android.support.v4.graphics;

import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import java.io.File;

class e extends i {
    e() {
    }

    private static File a(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String readlink = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
            return null;
        } catch (ErrnoException e2) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0045, code lost:
        r2 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0046, code lost:
        r3 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0056, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0057, code lost:
        r2 = r1;
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0072, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0073, code lost:
        r2 = null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0056 A[ExcHandler: all (r1v4 'th' java.lang.Throwable A[CUSTOM_DECLARE])] */
    @Override // android.support.v4.graphics.i
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Typeface a(android.content.Context r6, android.support.v4.c.b.C0019b[] r7, int r8) {
        /*
        // Method dump skipped, instructions count: 117
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.graphics.e.a(android.content.Context, android.support.v4.c.b$b[], int):android.graphics.Typeface");
    }
}
