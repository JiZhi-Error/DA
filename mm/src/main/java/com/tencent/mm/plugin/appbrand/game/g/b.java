package com.tencent.mm.plugin.appbrand.game.g;

import android.content.Context;
import com.hilive.mediasdk.LoadDelegate;
import com.hilive.mediasdk.LogDelegate;
import com.hilive.mediasdk.MediaSdk;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.appbrand.game.g.a;
import com.tencent.mm.plugin.appbrand.game.g.c;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
    private static volatile Map<String, b> luM = new HashMap(1);
    private static c luN = c.Hardware;
    public MMHandler luO = new MMHandler("wegame_screen_recorder_worker");
    public a.AbstractC0587a luP;
    private MediaSdk luQ = new MediaSdk();
    private e luR = e.NotInit;
    private c.a luS = null;
    private c.a luT = null;
    private final Runnable luU = new Runnable() {
        /* class com.tencent.mm.plugin.appbrand.game.g.b.AnonymousClass10 */

        public final void run() {
            AppMethodBeat.i(45337);
            if (b.this.luR == e.Inited) {
                Log.i("MicroMsg.GameRecorderMgr", "hy: trigger uninit");
                b.this.luQ.uint();
                b.i(b.this);
                b.this.luR = e.NotInit;
                AppMethodBeat.o(45337);
                return;
            }
            Log.w("MicroMsg.GameRecorderMgr", "hy: current not idle. abort uninit");
            AppMethodBeat.o(45337);
        }
    };

    /* renamed from: com.tencent.mm.plugin.appbrand.game.g.b$b  reason: collision with other inner class name */
    public interface AbstractC0588b {
        void Bc(long j2);
    }

    static {
        AppMethodBeat.i(45375);
        AppMethodBeat.o(45375);
    }

    /* access modifiers changed from: package-private */
    public enum e {
        NotInit,
        Inited,
        Running,
        Paused;

        public static e valueOf(String str) {
            AppMethodBeat.i(45364);
            e eVar = (e) Enum.valueOf(e.class, str);
            AppMethodBeat.o(45364);
            return eVar;
        }

        static {
            AppMethodBeat.i(45365);
            AppMethodBeat.o(45365);
        }
    }

    public enum c {
        lvp,
        Hardware;

        public static c valueOf(String str) {
            AppMethodBeat.i(45360);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(45360);
            return cVar;
        }

        static {
            AppMethodBeat.i(45361);
            AppMethodBeat.o(45361);
        }
    }

    public class f {
        public c.a lvx;
        public c.a lvy;

        public f() {
        }
    }

    public class a {
        public long duration;
        public long fileSize;

        public a() {
        }
    }

    public class d {
        public int audioBitrate = 64000;
        public int audioChannelCount = 2;
        public int audioSampleRate = 44100;

        public d() {
        }

        public final String toString() {
            AppMethodBeat.i(45362);
            String str = "RemuxResult{audioBitrate=" + this.audioBitrate + ", audioSampleRate=" + this.audioSampleRate + ", audioChannelCount=" + this.audioChannelCount + '}';
            AppMethodBeat.o(45362);
            return str;
        }
    }

    private b(MagicBrushView magicBrushView, final Context context) {
        AppMethodBeat.i(226639);
        if (luN != c.lvp) {
            this.luP = new a.b(magicBrushView);
        }
        this.luO.postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.game.g.b.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(45320);
                b.a(b.this);
                AppMethodBeat.o(45320);
            }
        });
        AppMethodBeat.o(226639);
    }

    public static b a(String str, MagicBrushView magicBrushView, Context context) {
        AppMethodBeat.i(226640);
        if (Util.isNullOrNil(str)) {
            RuntimeException runtimeException = new RuntimeException("Null or nil appid");
            AppMethodBeat.o(226640);
            throw runtimeException;
        }
        b bVar = null;
        if (!luM.containsKey(str)) {
            synchronized (b.class) {
                try {
                    if (!luM.containsKey(str)) {
                        bVar = new b(magicBrushView, context);
                        luM.put(str, bVar);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(226640);
                    throw th;
                }
            }
        }
        if (bVar == null) {
            bVar = luM.get(str);
        }
        AppMethodBeat.o(226640);
        return bVar;
    }

    public final void e(final d<String> dVar) {
        AppMethodBeat.i(45368);
        Log.i("MicroMsg.GameRecorderMgr", "hy: trigger pause");
        this.luO.postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.game.g.b.AnonymousClass14 */

            public final void run() {
                AppMethodBeat.i(45350);
                if (!b.f(b.this)) {
                    Log.w("MicroMsg.GameRecorderMgr", "hy: pause failed: not started");
                    dVar.a(2, 201, "not start yet!", null);
                    AppMethodBeat.o(45350);
                } else if (b.this.luR == e.Paused) {
                    Log.w("MicroMsg.GameRecorderMgr", "hy: pause failed: already paused!");
                    dVar.a(2, 202, "already paused!", null);
                    AppMethodBeat.o(45350);
                } else {
                    b.this.luR = e.Paused;
                    b.this.luP.b(new d<String>() {
                        /* class com.tencent.mm.plugin.appbrand.game.g.b.AnonymousClass14.AnonymousClass1 */

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                        @Override // com.tencent.mm.plugin.appbrand.game.g.d
                        public final /* bridge */ /* synthetic */ void a(int i2, int i3, String str, String str2) {
                            AppMethodBeat.i(45349);
                            dVar.a(0, 0, "ok", null);
                            AppMethodBeat.o(45349);
                        }
                    });
                    AppMethodBeat.o(45350);
                }
            }
        });
        AppMethodBeat.o(45368);
    }

    public final void f(final d<String> dVar) {
        AppMethodBeat.i(45369);
        Log.i("MicroMsg.GameRecorderMgr", "hy: trigger resume");
        this.luO.postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.game.g.b.AnonymousClass15 */

            public final void run() {
                AppMethodBeat.i(45352);
                if (!b.f(b.this)) {
                    Log.w("MicroMsg.GameRecorderMgr", "hy: resume failed: not started");
                    dVar.a(2, 301, "not start yet!", null);
                    AppMethodBeat.o(45352);
                } else if (b.this.luR == e.Running) {
                    Log.w("MicroMsg.GameRecorderMgr", "hy: resume failed: already running!");
                    dVar.a(2, 302, "already running!", null);
                    AppMethodBeat.o(45352);
                } else {
                    b.this.luR = e.Running;
                    b.this.luP.c(new d<String>() {
                        /* class com.tencent.mm.plugin.appbrand.game.g.b.AnonymousClass15.AnonymousClass1 */

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, java.lang.Object] */
                        @Override // com.tencent.mm.plugin.appbrand.game.g.d
                        public final /* bridge */ /* synthetic */ void a(int i2, int i3, String str, String str2) {
                            AppMethodBeat.i(45351);
                            dVar.a(0, 0, "ok", null);
                            AppMethodBeat.o(45351);
                        }
                    });
                    AppMethodBeat.o(45352);
                }
            }
        });
        AppMethodBeat.o(45369);
    }

    public final void a(final String str, final d<a> dVar) {
        AppMethodBeat.i(226641);
        this.luO.postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.game.g.b.AnonymousClass18 */

            public final void run() {
                AppMethodBeat.i(45358);
                try {
                    Log.i("MicroMsg.GameRecorderMgr", "hy: requestAnalyze %s", str);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("filePath", str);
                    b.this.luQ.analysis(jSONObject.toString().getBytes(), new MediaSdk.MediaCallbacker() {
                        /* class com.tencent.mm.plugin.appbrand.game.g.b.AnonymousClass18.AnonymousClass1 */

                        @Override // com.hilive.mediasdk.MediaSdk.MediaCallbacker
                        public final void onResult(byte[] bArr) {
                            AppMethodBeat.i(226638);
                            try {
                                JSONObject jSONObject = new JSONObject(new String(bArr));
                                a aVar = new a();
                                aVar.duration = jSONObject.optLong(FFmpegMetadataRetriever.METADATA_KEY_DURATION, 0);
                                aVar.fileSize = jSONObject.optLong("size", 0);
                                Log.i("MicroMsg.GameRecorderMgr", "hy: duration is %d, size is %d", Long.valueOf(aVar.duration), Long.valueOf(aVar.fileSize));
                                dVar.a(0, 0, "ok", aVar);
                                AppMethodBeat.o(226638);
                            } catch (JSONException e2) {
                                dVar.a(1, -1, "analysis error: " + e2.getMessage(), null);
                                AppMethodBeat.o(226638);
                            } catch (Exception e3) {
                                dVar.a(1, -1, "analysis error: " + e3.getMessage(), null);
                                AppMethodBeat.o(226638);
                            }
                        }
                    });
                    AppMethodBeat.o(45358);
                } catch (JSONException e2) {
                    dVar.a(1, -1, "analysis error: " + e2.getMessage(), null);
                    AppMethodBeat.o(45358);
                } catch (Exception e3) {
                    dVar.a(1, -1, "analysis error: " + e3.getMessage(), null);
                    AppMethodBeat.o(45358);
                }
            }
        });
        AppMethodBeat.o(226641);
    }

    public final void a(final JSONObject jSONObject, final d<JSONObject> dVar) {
        AppMethodBeat.i(226642);
        this.luO.postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.game.g.b.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(45322);
                try {
                    Log.i("MicroMsg.GameRecorderMgr", "hy: trigger remux " + jSONObject.toString());
                    b.this.luQ.remux(jSONObject.toString().getBytes(), new MediaSdk.MediaCallbacker() {
                        /* class com.tencent.mm.plugin.appbrand.game.g.b.AnonymousClass2.AnonymousClass1 */

                        @Override // com.hilive.mediasdk.MediaSdk.MediaCallbacker
                        public final void onResult(byte[] bArr) {
                            AppMethodBeat.i(174731);
                            try {
                                JSONObject jSONObject = new JSONObject(new String(bArr));
                                int optInt = jSONObject.optInt("errCode", 601);
                                if (optInt == 0) {
                                    dVar.a(0, 0, "ok", jSONObject);
                                    AppMethodBeat.o(174731);
                                    return;
                                }
                                dVar.a(1, optInt, String.format("remux failed!: errCode: %d", Integer.valueOf(optInt)), jSONObject);
                                AppMethodBeat.o(174731);
                            } catch (JSONException e2) {
                                dVar.a(1, -1, "remux error: " + e2.getMessage(), new JSONObject());
                                AppMethodBeat.o(174731);
                            } catch (Exception e3) {
                                dVar.a(1, -1, "remux error: " + e3.getMessage(), new JSONObject());
                                AppMethodBeat.o(174731);
                            }
                        }
                    });
                    AppMethodBeat.o(45322);
                } catch (Exception e2) {
                    dVar.a(1, -1, "remux error: " + e2.getMessage(), new JSONObject());
                    AppMethodBeat.o(45322);
                }
            }
        });
        AppMethodBeat.o(226642);
    }

    static /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(226643);
        LoadDelegate.setInstance(new LoadDelegate.ILoadLibrary() {
            /* class com.tencent.mm.plugin.appbrand.game.g.b.AnonymousClass12 */

            @Override // com.hilive.mediasdk.LoadDelegate.ILoadLibrary
            public final void loadLibrary(String str) {
                AppMethodBeat.i(45341);
                b.class.getClassLoader();
                j.Ed(str);
                AppMethodBeat.o(45341);
            }

            @Override // com.hilive.mediasdk.LoadDelegate.ILoadLibrary
            public final void loadLibrary(String str, ClassLoader classLoader) {
                AppMethodBeat.i(45342);
                j.Ed(str);
                AppMethodBeat.o(45342);
            }
        });
        LogDelegate.setImp(new LogDelegate.ILog() {
            /* class com.tencent.mm.plugin.appbrand.game.g.b.AnonymousClass13 */

            @Override // com.hilive.mediasdk.LogDelegate.ILog
            public final void v(String str, String str2, Object... objArr) {
                AppMethodBeat.i(45343);
                Log.v(str, str2, objArr);
                AppMethodBeat.o(45343);
            }

            @Override // com.hilive.mediasdk.LogDelegate.ILog
            public final void d(String str, String str2, Object... objArr) {
                AppMethodBeat.i(45344);
                Log.d(str, str2, objArr);
                AppMethodBeat.o(45344);
            }

            @Override // com.hilive.mediasdk.LogDelegate.ILog
            public final void i(String str, String str2, Object... objArr) {
                AppMethodBeat.i(45345);
                Log.i(str, str2, objArr);
                AppMethodBeat.o(45345);
            }

            @Override // com.hilive.mediasdk.LogDelegate.ILog
            public final void w(String str, String str2, Object... objArr) {
                AppMethodBeat.i(45346);
                Log.w(str, str2, objArr);
                AppMethodBeat.o(45346);
            }

            @Override // com.hilive.mediasdk.LogDelegate.ILog
            public final void e(String str, String str2, Object... objArr) {
                AppMethodBeat.i(45347);
                Log.e(str, str2, objArr);
                AppMethodBeat.o(45347);
            }

            @Override // com.hilive.mediasdk.LogDelegate.ILog
            public final void printStackTrace(String str, Throwable th, String str2, Object... objArr) {
                AppMethodBeat.i(45348);
                Log.printErrStackTrace(str, th, str2, objArr);
                AppMethodBeat.o(45348);
            }
        });
        Log.i("MicroMsg.GameRecorderMgr", "init mediasdk");
        boolean init = bVar.luQ.init();
        AppMethodBeat.o(226643);
        return init;
    }

    static /* synthetic */ boolean b(c.b bVar, d dVar) {
        AppMethodBeat.i(45371);
        if (bVar.lvz == null || Util.isNullOrNil(bVar.lvz.getAbsolutePath())) {
            dVar.a(2, 105, "not provide file path", null);
            AppMethodBeat.o(45371);
            return false;
        } else if (bVar.bitrate <= 0 || bVar.bitrate >= 100000000) {
            dVar.a(2, 106, String.format("invalid bitrate: %d", Integer.valueOf(bVar.bitrate)), null);
            AppMethodBeat.o(45371);
            return false;
        } else if (bVar.fps <= 0 || bVar.fps > 60) {
            dVar.a(2, 107, String.format("invalid fps: %d", Integer.valueOf(bVar.fps)), null);
            AppMethodBeat.o(45371);
            return false;
        } else if (bVar.gop <= 0) {
            dVar.a(2, 108, String.format("invalid gop: %d", Integer.valueOf(bVar.gop)), null);
            AppMethodBeat.o(45371);
            return false;
        } else if (bVar.height <= 0 || bVar.width <= 0) {
            dVar.a(2, 109, String.format("invalid size : %d * %d", Integer.valueOf(bVar.width), Integer.valueOf(bVar.height)), null);
            AppMethodBeat.o(45371);
            return false;
        } else if (bVar.duration <= 0 || bVar.duration > 7200) {
            dVar.a(2, 101, String.format("invalid duration: %d", Integer.valueOf(bVar.duration)), null);
            AppMethodBeat.o(45371);
            return false;
        } else {
            AppMethodBeat.o(45371);
            return true;
        }
    }

    static /* synthetic */ void c(b bVar) {
        AppMethodBeat.i(45372);
        bVar.luP.bDz();
        AppMethodBeat.o(45372);
    }

    static /* synthetic */ boolean f(b bVar) {
        AppMethodBeat.i(45373);
        if (bVar.luR == e.NotInit || bVar.luR == e.Inited || bVar.luS == null || Util.isNullOrNil(bVar.luS.getAbsolutePath())) {
            AppMethodBeat.o(45373);
            return false;
        }
        AppMethodBeat.o(45373);
        return true;
    }

    static /* synthetic */ void i(b bVar) {
        AppMethodBeat.i(45374);
        bVar.luR = e.Inited;
        bVar.luS = null;
        bVar.luP.bDz();
        AppMethodBeat.o(45374);
    }
}
