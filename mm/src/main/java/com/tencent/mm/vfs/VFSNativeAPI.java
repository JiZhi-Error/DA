package com.tencent.mm.vfs;

import android.os.ParcelFileDescriptor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.stubs.logger.Log;
import java.io.IOException;

final class VFSNativeAPI {
    private VFSNativeAPI() {
    }

    static int openFd(String str, int i2) {
        String str2;
        AppMethodBeat.i(13321);
        if ((i2 & -1604) != 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Flags unsupported: ".concat(String.valueOf(i2)));
            AppMethodBeat.o(13321);
            throw illegalArgumentException;
        }
        switch (i2 & 3) {
            case 0:
                str2 = "r";
                break;
            case 1:
                str2 = "w";
                break;
            case 2:
                str2 = "rw";
                break;
            default:
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Invalid access mode: ".concat(String.valueOf(i2)));
                AppMethodBeat.o(13321);
                throw illegalArgumentException2;
        }
        if ((i2 & 512) != 0) {
            str2 = str2 + "t";
        }
        if ((i2 & 1024) != 0) {
            str2 = str2 + "a";
        }
        try {
            ParcelFileDescriptor nv = s.nv(str, str2);
            if (nv != null) {
                int detachFd = nv.detachFd();
                aa.closeQuietly(nv);
                AppMethodBeat.o(13321);
                return detachFd;
            }
            aa.closeQuietly(nv);
            AppMethodBeat.o(13321);
            return -1;
        } catch (IOException e2) {
            Log.e("VFS.VFSNativeAPI", e2, "Failed to open file descriptor for file: ".concat(String.valueOf(str)));
            aa.closeQuietly(null);
        } catch (Throwable th) {
            aa.closeQuietly(null);
            AppMethodBeat.o(13321);
            throw th;
        }
    }
}
