package c.t.m.sapp.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.Map;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public static d f49a;

    /* renamed from: b  reason: collision with root package name */
    public Context f50b = null;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, FileChannel> f51c = null;

    public d(Context context) {
        AppMethodBeat.i(222946);
        this.f50b = context;
        this.f51c = new HashMap(5);
        AppMethodBeat.o(222946);
    }

    public static synchronized d a(Context context) {
        d dVar;
        synchronized (d.class) {
            AppMethodBeat.i(222947);
            if (f49a == null) {
                f49a = new d(context);
            }
            dVar = f49a;
            AppMethodBeat.o(222947);
        }
        return dVar;
    }

    public synchronized boolean b(String str) {
        boolean z;
        AppMethodBeat.i(222948);
        if (str == null || str.trim().length() <= 0) {
            AppMethodBeat.o(222948);
            z = false;
        } else {
            File a2 = a(str);
            if (a2 == null) {
                AppMethodBeat.o(222948);
                z = true;
            } else {
                try {
                    FileChannel fileChannel = this.f51c.get(str);
                    if (fileChannel == null || !fileChannel.isOpen()) {
                        fileChannel = new FileOutputStream(a2).getChannel();
                        this.f51c.put(str, fileChannel);
                    }
                    FileLock lock = fileChannel.lock();
                    if (lock != null && lock.isValid()) {
                        AppMethodBeat.o(222948);
                        z = true;
                    }
                } catch (Throwable th) {
                }
                AppMethodBeat.o(222948);
                z = false;
            }
        }
        return z;
    }

    public synchronized void c(String str) {
        AppMethodBeat.i(222949);
        if (str == null || str.trim().length() <= 0) {
            AppMethodBeat.o(222949);
        } else {
            try {
                FileChannel fileChannel = this.f51c.get(str);
                if (fileChannel != null) {
                    fileChannel.close();
                    AppMethodBeat.o(222949);
                }
            } catch (Throwable th) {
            }
            AppMethodBeat.o(222949);
        }
    }

    public synchronized File a(String str) {
        File file;
        AppMethodBeat.i(222950);
        try {
            file = new File(this.f50b.getFilesDir(), "TencentLocationCoverSDK_sapp_" + str + ".lock");
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e2) {
            file = null;
        }
        AppMethodBeat.o(222950);
        return file;
    }
}
