package com.tencent.matrix.resource.e;

import android.content.Context;
import android.os.Environment;
import com.tencent.matrix.g.c;
import java.io.File;
import java.io.FilenameFilter;
import java.util.UUID;

public final class d {
    protected final int cZV;
    protected final Context mContext;

    public d(Context context) {
        this(context, (byte) 0);
    }

    private d(Context context, byte b2) {
        this.mContext = context;
        this.cZV = 5;
    }

    public final File Tj() {
        File Tk = Tk();
        if (Tk == null) {
            return null;
        }
        UUID randomUUID = UUID.randomUUID();
        return new File(Tk, "dump_" + Long.toHexString(randomUUID.getMostSignificantBits()) + Long.toHexString(randomUUID.getLeastSignificantBits()) + ".hprof");
    }

    private File Tk() {
        File Tl = Tl();
        if (Tl.exists() || (Tl.mkdirs() && Tl.canWrite())) {
            File[] listFiles = Tl.listFiles(new FilenameFilter() {
                /* class com.tencent.matrix.resource.e.d.AnonymousClass1 */

                public final boolean accept(File file, String str) {
                    return str.endsWith(".hprof");
                }
            });
            if (listFiles == null || listFiles.length <= this.cZV) {
                return Tl;
            }
            for (File file : listFiles) {
                if (file.exists() && !file.delete()) {
                    c.w("Matrix.DumpStorageManager", "faile to delete hprof file: " + file.getAbsolutePath(), new Object[0]);
                }
            }
            return Tl;
        }
        c.w("Matrix.DumpStorageManager", "failed to allocate new hprof file since path: %s is not writable.", Tl.getAbsolutePath());
        return null;
    }

    private File Tl() {
        File cacheDir;
        if ("mounted".equals(Environment.getExternalStorageState())) {
            cacheDir = this.mContext.getExternalCacheDir();
        } else {
            cacheDir = this.mContext.getCacheDir();
        }
        File file = new File(cacheDir, "matrix_resource");
        c.i("Matrix.DumpStorageManager", "path to store hprof and result: %s", file.getAbsolutePath());
        return file;
    }
}
