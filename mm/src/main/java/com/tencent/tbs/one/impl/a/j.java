package com.tencent.tbs.one.impl.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import java.util.concurrent.Callable;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    private final File f2364a;

    /* renamed from: b  reason: collision with root package name */
    private final FileOutputStream f2365b;

    /* renamed from: c  reason: collision with root package name */
    private final FileLock f2366c;

    private j(File file, FileOutputStream fileOutputStream, FileLock fileLock) {
        this.f2364a = file;
        this.f2365b = fileOutputStream;
        this.f2366c = fileLock;
    }

    public static j a(File file) {
        FileOutputStream fileOutputStream;
        Throwable th;
        AppMethodBeat.i(173902);
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                FileLock tryLock = fileOutputStream.getChannel().tryLock();
                if (tryLock != null) {
                    f.a("Created lock file: %s", file.getAbsolutePath());
                    j jVar = new j(file, fileOutputStream, tryLock);
                    AppMethodBeat.o(173902);
                    return jVar;
                }
            } catch (Throwable th2) {
                th = th2;
                f.c("Failed to try to acquire lock %s", file.getAbsolutePath(), th);
                c.a(fileOutputStream);
                AppMethodBeat.o(173902);
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            f.c("Failed to try to acquire lock %s", file.getAbsolutePath(), th);
            c.a(fileOutputStream);
            AppMethodBeat.o(173902);
            return null;
        }
        c.a(fileOutputStream);
        AppMethodBeat.o(173902);
        return null;
    }

    static <T> T a(Callable<T> callable, File file, long j2) {
        AppMethodBeat.i(173901);
        for (int i2 = 0; ((long) i2) < j2 / 200; i2++) {
            try {
                T call = callable.call();
                if (call != null) {
                    if (i2 > 0) {
                        f.a("Finished waiting on lock file: %s", file.getAbsolutePath());
                    }
                    AppMethodBeat.o(173901);
                    return call;
                }
                if (i2 == 0) {
                    f.a("Waiting on lock file: %s", file.getAbsolutePath());
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e2) {
                }
            } catch (Exception e3) {
                RuntimeException runtimeException = new RuntimeException(e3);
                AppMethodBeat.o(173901);
                throw runtimeException;
            }
        }
        RuntimeException runtimeException2 = new RuntimeException("Timed out waiting for lock file: " + file.getAbsolutePath());
        AppMethodBeat.o(173901);
        throw runtimeException2;
    }

    public final void a() {
        AppMethodBeat.i(173903);
        try {
            f.a("Deleting lock file: %s", this.f2364a.getAbsolutePath());
            this.f2366c.release();
            this.f2365b.close();
            if (!this.f2364a.delete()) {
                IOException iOException = new IOException("Failed to delete lock file: " + this.f2364a.getAbsolutePath());
                AppMethodBeat.o(173903);
                throw iOException;
            }
            AppMethodBeat.o(173903);
        } catch (IOException e2) {
            f.c("Failed to release process lock file %s", this.f2364a.getAbsolutePath(), e2);
            AppMethodBeat.o(173903);
        }
    }
}
