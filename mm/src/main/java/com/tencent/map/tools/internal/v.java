package com.tencent.map.tools.internal;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;

public class v {

    /* renamed from: c  reason: collision with root package name */
    static v f1418c = null;

    /* renamed from: d  reason: collision with root package name */
    private static final String f1419d = v.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    Context f1420a = null;

    /* renamed from: b  reason: collision with root package name */
    Map<String, FileChannel> f1421b = null;

    static {
        AppMethodBeat.i(180862);
        AppMethodBeat.o(180862);
    }

    private v(Context context) {
        AppMethodBeat.i(193545);
        this.f1420a = context;
        this.f1421b = new HashMap(5);
        AppMethodBeat.o(193545);
    }

    public static synchronized v a(Context context) {
        v vVar;
        synchronized (v.class) {
            AppMethodBeat.i(193546);
            if (f1418c == null) {
                f1418c = new v(context);
            }
            vVar = f1418c;
            AppMethodBeat.o(193546);
        }
        return vVar;
    }

    public final synchronized boolean a(String str) {
        boolean z;
        AppMethodBeat.i(193547);
        if (str.trim().length() <= 0) {
            AppMethodBeat.o(193547);
            z = false;
        } else {
            File c2 = c(str);
            if (c2 == null) {
                AppMethodBeat.o(193547);
                z = true;
            } else {
                try {
                    FileChannel fileChannel = this.f1421b.get(str);
                    if (fileChannel == null || !fileChannel.isOpen()) {
                        fileChannel = new FileOutputStream(c2).getChannel();
                        this.f1421b.put(str, fileChannel);
                    }
                    FileLock lock = fileChannel.lock();
                    if (lock != null && lock.isValid()) {
                        AppMethodBeat.o(193547);
                        z = true;
                    }
                } catch (Throwable th) {
                }
                AppMethodBeat.o(193547);
                z = false;
            }
        }
        return z;
    }

    public final synchronized void b(String str) {
        AppMethodBeat.i(193548);
        if (str.trim().length() <= 0) {
            AppMethodBeat.o(193548);
        } else {
            try {
                FileChannel fileChannel = this.f1421b.get(str);
                if (fileChannel != null) {
                    fileChannel.close();
                }
                AppMethodBeat.o(193548);
            } catch (Throwable th) {
                AppMethodBeat.o(193548);
            }
        }
    }

    private synchronized File c(String str) {
        File file;
        AppMethodBeat.i(193549);
        try {
            file = new File(x.b(this.f1420a, t.n + File.separator + str + ".lock"));
            if (!file.exists()) {
                File file2 = new File(file.getParent());
                if (!file2.exists()) {
                    file2.mkdirs();
                    file.createNewFile();
                }
            }
        } catch (IOException e2) {
            file = null;
        }
        AppMethodBeat.o(193549);
        return file;
    }
}
