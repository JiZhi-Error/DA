package com.tencent.mm.plugin.sns.ad.b;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;

public final class b {
    private String Dsq;
    private FileLock fileLock;
    private String filename;
    private RandomAccessFile randomAccessFile;

    public b(String str, String str2) {
        this.Dsq = str;
        this.filename = str2;
    }

    private boolean isValid() {
        AppMethodBeat.i(192743);
        if (TextUtils.isEmpty(this.Dsq) || TextUtils.isEmpty(this.filename)) {
            AppMethodBeat.o(192743);
            return false;
        }
        AppMethodBeat.o(192743);
        return true;
    }

    public final boolean open() {
        AppMethodBeat.i(192744);
        if (!isValid()) {
            AppMethodBeat.o(192744);
            return false;
        } else if (this.randomAccessFile == null && this.fileLock == null) {
            try {
                File file = new File(Environment.getExternalStorageDirectory(), this.Dsq);
                File file2 = new File(file, this.filename);
                if (file.exists() || file.mkdirs()) {
                    this.randomAccessFile = new RandomAccessFile(file2, "rwd");
                    this.fileLock = this.randomAccessFile.getChannel().lock();
                    if (!file2.isFile()) {
                        close();
                        AppMethodBeat.o(192744);
                        return false;
                    }
                    AppMethodBeat.o(192744);
                    return true;
                }
                AppMethodBeat.o(192744);
                return false;
            } catch (Throwable th) {
                close();
                AppMethodBeat.o(192744);
                return false;
            }
        } else {
            AppMethodBeat.o(192744);
            return false;
        }
    }

    public final void close() {
        AppMethodBeat.i(192745);
        try {
            if (this.fileLock != null) {
                this.fileLock.release();
                this.fileLock = null;
            }
        } catch (Throwable th) {
        }
        try {
            if (this.randomAccessFile != null) {
                this.randomAccessFile.close();
                this.randomAccessFile = null;
            }
            AppMethodBeat.o(192745);
        } catch (Throwable th2) {
            AppMethodBeat.o(192745);
        }
    }

    public final String eWG() {
        int i2;
        AppMethodBeat.i(192746);
        if (!isValid()) {
            AppMethodBeat.o(192746);
            return null;
        } else if (this.randomAccessFile == null || this.fileLock == null) {
            AppMethodBeat.o(192746);
            return null;
        } else {
            try {
                if (this.randomAccessFile.length() <= 10240) {
                    i2 = Long.valueOf(this.randomAccessFile.length()).intValue();
                } else {
                    i2 = 10240;
                }
                if (i2 <= 0) {
                    AppMethodBeat.o(192746);
                    return null;
                }
                byte[] bArr = new byte[i2];
                if (this.randomAccessFile.read(bArr, 0, i2) == i2) {
                    String str = new String(bArr, 0, i2, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                    AppMethodBeat.o(192746);
                    return str;
                }
                AppMethodBeat.o(192746);
                return null;
            } catch (Throwable th) {
                AppMethodBeat.o(192746);
                return null;
            }
        }
    }
}
