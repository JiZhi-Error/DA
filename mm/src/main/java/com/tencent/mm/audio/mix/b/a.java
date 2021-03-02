package com.tencent.mm.audio.mix.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.b.a.e;
import com.tencent.mm.audio.mix.b.a.f;
import com.tencent.mm.audio.mix.d.i;
import com.tencent.mm.audio.mix.i.b;
import com.tencent.mm.audio.mix.i.c;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class a {
    private static a duc;
    public String currentAppId = "";
    private ArrayList<String> dud = new ArrayList<>();
    private final String due = "audio_cache_path_file.txt";
    private String fileName;
    private Object sLock = new Object();

    static /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(198102);
        aVar.YA();
        AppMethodBeat.o(198102);
    }

    static /* synthetic */ void b(a aVar) {
        AppMethodBeat.i(198103);
        aVar.YB();
        AppMethodBeat.o(198103);
    }

    private a() {
        AppMethodBeat.i(198091);
        AppMethodBeat.o(198091);
    }

    public static a Yw() {
        AppMethodBeat.i(198092);
        if (duc == null) {
            synchronized (a.class) {
                try {
                    if (duc == null) {
                        duc = new a();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(198092);
                    throw th;
                }
            }
        }
        a aVar = duc;
        AppMethodBeat.o(198092);
        return aVar;
    }

    private File Yx() {
        AppMethodBeat.i(198093);
        File file = new File(this.fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e2) {
                b.printErrStackTrace("MicroMsg.Mix.AudioCachePathMgr", e2, "getCacheFile", new Object[0]);
            }
        }
        AppMethodBeat.o(198093);
        return file;
    }

    public final void Yy() {
        AppMethodBeat.i(198094);
        b.i("MicroMsg.Mix.AudioCachePathMgr", "saveData");
        a(new f() {
            /* class com.tencent.mm.audio.mix.b.a.AnonymousClass3 */

            @Override // com.tencent.mm.audio.mix.b.a.f
            public final void YC() {
                AppMethodBeat.i(198089);
                a.a(a.this);
                AppMethodBeat.o(198089);
            }

            @Override // com.tencent.mm.audio.mix.b.a.f
            public final void end() {
            }
        }, "saveData");
        AppMethodBeat.o(198094);
    }

    public final void Yz() {
        AppMethodBeat.i(198095);
        b.i("MicroMsg.Mix.AudioCachePathMgr", "readData");
        a(new f() {
            /* class com.tencent.mm.audio.mix.b.a.AnonymousClass4 */

            @Override // com.tencent.mm.audio.mix.b.a.f
            public final void YC() {
                AppMethodBeat.i(198090);
                a.b(a.this);
                AppMethodBeat.o(198090);
            }

            @Override // com.tencent.mm.audio.mix.b.a.f
            public final void end() {
            }
        }, "readData");
        AppMethodBeat.o(198095);
    }

    private synchronized void YA() {
        AppMethodBeat.i(198096);
        if (this.dud.isEmpty()) {
            b.i("MicroMsg.Mix.AudioCachePathMgr", "data is empty");
            AppMethodBeat.o(198096);
        } else {
            try {
                new File(this.fileName).delete();
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Yx()));
                Iterator<String> it = this.dud.iterator();
                while (it.hasNext()) {
                    bufferedWriter.newLine();
                    bufferedWriter.write(it.next());
                }
                b.i("MicroMsg.Mix.AudioCachePathMgr", "line count:%s", Integer.valueOf(this.dud.size()));
                bufferedWriter.flush();
                bufferedWriter.close();
            } catch (IOException e2) {
                b.printErrStackTrace("MicroMsg.Mix.AudioCachePathMgr", e2, "asyncRead", new Object[0]);
            }
            b.i("MicroMsg.Mix.AudioCachePathMgr", "save end");
            AppMethodBeat.o(198096);
        }
    }

    private synchronized void YB() {
        AppMethodBeat.i(198097);
        try {
            this.dud.clear();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(Yx()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                } else if (!TextUtils.isEmpty(readLine)) {
                    this.dud.add(readLine);
                }
            }
            b.i("MicroMsg.Mix.AudioCachePathMgr", "line count:%s", Integer.valueOf(this.dud.size()));
            bufferedReader.close();
            AppMethodBeat.o(198097);
        } catch (IOException e2) {
            b.printErrStackTrace("MicroMsg.Mix.AudioCachePathMgr", e2, "asyncRead", new Object[0]);
            AppMethodBeat.o(198097);
        }
    }

    public final synchronized boolean gB(String str) {
        AppMethodBeat.i(198098);
        b.i("MicroMsg.Mix.AudioCachePathMgr", "append path:%s", str);
        String mD5String = c.getMD5String(new StringBuilder().append(str.hashCode()).toString());
        if (!this.dud.contains(mD5String)) {
            this.dud.add(mD5String);
        }
        AppMethodBeat.o(198098);
        return true;
    }

    public final synchronized boolean gC(String str) {
        AppMethodBeat.i(198099);
        b.i("MicroMsg.Mix.AudioCachePathMgr", "delete path:%s", str);
        String mD5String = c.getMD5String(new StringBuilder().append(str.hashCode()).toString());
        if (!this.dud.contains(mD5String)) {
            this.dud.remove(mD5String);
        }
        AppMethodBeat.o(198099);
        return true;
    }

    public final synchronized boolean gD(String str) {
        boolean contains;
        AppMethodBeat.i(198100);
        contains = this.dud.contains(c.getMD5String(new StringBuilder().append(str.hashCode()).toString()));
        AppMethodBeat.o(198100);
        return contains;
    }

    public static void a(f fVar, String str) {
        AppMethodBeat.i(198101);
        e eVar = new e(fVar, str);
        i.Zp();
        i.a(eVar);
        AppMethodBeat.o(198101);
    }
}
