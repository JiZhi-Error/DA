package com.tencent.mm.plugin.music.f.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.qqmusic.mediaplayer.AudioPlayerConfigure;
import com.tencent.qqmusic.mediaplayer.ILog;
import com.tencent.qqmusic.mediaplayer.ISoLibraryLoader;
import com.tencent.qqmusic.mediaplayer.NativeLibs;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.util.HashMap;

public class a {
    private static c Ame = new C1534a((byte) 0);
    private static boolean Amf = false;
    private static boolean aWP = false;

    static {
        AppMethodBeat.i(137400);
        AppMethodBeat.o(137400);
    }

    public static void euV() {
        AppMethodBeat.i(137398);
        Log.i("MicroMsg.Audio.AudioPlayerUtils", "configQQMusicSdkConfig");
        AudioPlayerConfigure.setLog(new ILog() {
            /* class com.tencent.mm.plugin.music.f.a.a.AnonymousClass1 */

            @Override // com.tencent.qqmusic.mediaplayer.ILog
            public final void d(String str, String str2) {
                AppMethodBeat.i(137383);
                Log.d(str, str2);
                AppMethodBeat.o(137383);
            }

            @Override // com.tencent.qqmusic.mediaplayer.ILog
            public final void w(String str, String str2) {
                AppMethodBeat.i(137384);
                Log.w(str, str2);
                AppMethodBeat.o(137384);
            }

            @Override // com.tencent.qqmusic.mediaplayer.ILog
            public final void e(String str, String str2) {
                AppMethodBeat.i(137385);
                Log.e(str, str2);
                AppMethodBeat.o(137385);
            }

            @Override // com.tencent.qqmusic.mediaplayer.ILog
            public final void i(String str, String str2) {
                AppMethodBeat.i(137386);
                Log.i(str, str2);
                AppMethodBeat.o(137386);
            }

            @Override // com.tencent.qqmusic.mediaplayer.ILog
            public final void i(String str, String str2, Throwable th) {
                AppMethodBeat.i(137387);
                Log.printErrStackTrace(str, th, str2, new Object[0]);
                AppMethodBeat.o(137387);
            }

            @Override // com.tencent.qqmusic.mediaplayer.ILog
            public final void e(String str, Throwable th) {
                AppMethodBeat.i(137388);
                Log.printErrStackTrace(str, th, " throwable", new Object[0]);
                AppMethodBeat.o(137388);
            }

            @Override // com.tencent.qqmusic.mediaplayer.ILog
            public final void e(String str, String str2, Throwable th) {
                AppMethodBeat.i(137389);
                Log.printErrStackTrace(str, th, str2, new Object[0]);
                AppMethodBeat.o(137389);
            }

            @Override // com.tencent.qqmusic.mediaplayer.ILog
            public final void e(String str, String str2, Object... objArr) {
                AppMethodBeat.i(137390);
                Log.e(str, String.format(str2, objArr));
                AppMethodBeat.o(137390);
            }
        });
        AudioPlayerConfigure.setSoLibraryLoader(new ISoLibraryLoader() {
            /* class com.tencent.mm.plugin.music.f.a.a.AnonymousClass2 */

            @Override // com.tencent.qqmusic.mediaplayer.ISoLibraryLoader
            public final boolean load(String str) {
                AppMethodBeat.i(137391);
                if (a.Ame != null) {
                    boolean load = a.Ame.load(str);
                    AppMethodBeat.o(137391);
                    return load;
                }
                AppMethodBeat.o(137391);
                return false;
            }

            @Override // com.tencent.qqmusic.mediaplayer.ISoLibraryLoader
            public final String findLibPath(String str) {
                AppMethodBeat.i(137392);
                if (a.Ame != null) {
                    String findLibPath = a.Ame.findLibPath(str);
                    AppMethodBeat.o(137392);
                    return findLibPath;
                }
                AppMethodBeat.o(137392);
                return null;
            }
        });
        if (!Amf && !aWP) {
            aWP = true;
            ThreadPool.post(new Runnable() {
                /* class com.tencent.mm.plugin.music.f.a.a.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(137393);
                    a.euW();
                    boolean unused = a.aWP = false;
                    AppMethodBeat.o(137393);
                }
            }, "audio load NLog");
        }
        AppMethodBeat.o(137398);
    }

    public static synchronized boolean euW() {
        boolean z = false;
        synchronized (a.class) {
            AppMethodBeat.i(137399);
            if (Amf) {
                z = true;
                AppMethodBeat.o(137399);
            } else if (Ame == null) {
                AppMethodBeat.o(137399);
            } else {
                Ame.load(NativeLibs.nlog.getName());
                Ame.load(NativeLibs.audioCommon.getName());
                if (Ame.aHU(NativeLibs.nlog.getName())) {
                    try {
                        Amf = AudioPlayerConfigure.enableNativeLog(null);
                    } catch (Throwable th) {
                        Log.printErrStackTrace("MicroMsg.Audio.AudioPlayerUtils", th, "checkNLogLoad", new Object[0]);
                        if (d.oE(20)) {
                            Amf = AudioPlayerConfigure.enableNativeLog(null);
                        } else {
                            AppMethodBeat.o(137399);
                            throw th;
                        }
                    }
                    if (Amf) {
                        Log.i("MicroMsg.Audio.AudioPlayerUtils", "enableNativeLog success");
                    }
                    z = Amf;
                    AppMethodBeat.o(137399);
                } else {
                    Log.i("MicroMsg.Audio.AudioPlayerUtils", "enableNativeLog fail");
                    AppMethodBeat.o(137399);
                }
            }
        }
        return z;
    }

    public static void a(c cVar) {
        Ame = cVar;
    }

    /* renamed from: com.tencent.mm.plugin.music.f.a.a$a  reason: collision with other inner class name */
    static class C1534a implements c {
        private HashMap<String, Boolean> Amg;

        private C1534a() {
            AppMethodBeat.i(137394);
            this.Amg = new HashMap<>();
            AppMethodBeat.o(137394);
        }

        /* synthetic */ C1534a(byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.music.f.a.c
        public final boolean load(String str) {
            AppMethodBeat.i(137395);
            if (TextUtils.isEmpty(str)) {
                Log.e("MicroMsg.Audio.AudioPlayerUtils", "LoadLibrary lib_name is null");
                AppMethodBeat.o(137395);
                return false;
            } else if (!this.Amg.containsKey(str) || !this.Amg.get(str).booleanValue()) {
                this.Amg.put(str, Boolean.TRUE);
                System.loadLibrary(str);
                AppMethodBeat.o(137395);
                return true;
            } else {
                Log.e("MicroMsg.Audio.AudioPlayerUtils", "LoadLibrary lib_name %s is loaded", str);
                AppMethodBeat.o(137395);
                return true;
            }
        }

        @Override // com.tencent.mm.plugin.music.f.a.c
        public final String findLibPath(String str) {
            AppMethodBeat.i(137396);
            Log.i("MicroMsg.Audio.AudioPlayerUtils", "findLibPath %s", str);
            if (!str.startsWith(ShareConstants.SO_PATH)) {
                str = ShareConstants.SO_PATH.concat(String.valueOf(str));
            }
            if (!str.endsWith(".so")) {
                str = str + ".so";
            }
            AppMethodBeat.o(137396);
            return str;
        }

        @Override // com.tencent.mm.plugin.music.f.a.c
        public final boolean aHU(String str) {
            AppMethodBeat.i(137397);
            if (this.Amg.containsKey(str)) {
                AppMethodBeat.o(137397);
                return true;
            }
            AppMethodBeat.o(137397);
            return false;
        }
    }
}
