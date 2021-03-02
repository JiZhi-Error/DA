package com.tencent.mm.audio.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.m;
import com.tencent.mm.audio.b;
import com.tencent.mm.audio.b.g;
import com.tencent.mm.b.g;
import com.tencent.mm.compatible.b.c;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.modelvoice.v;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.g;
import kotlin.x;

public class h implements m {
    private static boolean cxw = false;
    private a dAg = null;
    private a dAh = null;
    private String dAi;
    private boolean dAj = false;
    private boolean dAk = false;
    private long dAl;
    private long dAm = 0;
    public int dAn = 0;
    private boolean dAo = false;
    private boolean dAp = false;
    private int dAq = 0;
    private c.a dAr = c.a.UNKNOWN;
    protected m.b dAs;
    protected m.a dAt = null;
    private b dAu;
    private MTimerHandler dAv = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.audio.b.h.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(187325);
            s.a(h.this.mFileName, h.this);
            o.bid().run();
            Log.d("MicroMsg.SceneVoice.Recorder", "Start Send fileName :" + h.this.mFileName);
            AppMethodBeat.o(187325);
            return false;
        }
    }, true);
    private Runnable dAw;
    private com.tencent.mm.compatible.util.b dtz;
    private String mFileName = "";

    public h(Context context, boolean z) {
        AppMethodBeat.i(148336);
        this.dtz = new com.tencent.mm.compatible.util.b(context);
        this.dAp = z;
        this.dAu = new b(new kotlin.g.a.b<Boolean, x>() {
            /* class com.tencent.mm.audio.b.h.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Boolean bool) {
                AppMethodBeat.i(187324);
                if (bool.booleanValue()) {
                    h.a(h.this);
                } else if (!h.this.dAo) {
                    Log.i("MicroMsg.SceneVoice.Recorder", "after start bluetooth, timeout to directly start record");
                    h.a(h.this);
                } else {
                    Log.e("MicroMsg.SceneVoice.Recorder", "mHasBeginRec is true");
                }
                AppMethodBeat.o(187324);
                return null;
            }
        });
        Log.i("MicroMsg.SceneVoice.Recorder", "new SceneVoiceRecorder, useSpeex: %s", Boolean.valueOf(z));
        AppMethodBeat.o(148336);
    }

    @Override // com.tencent.mm.ak.m
    public final void reset() {
        AppMethodBeat.i(148337);
        if (this.dAg != null) {
            this.dAg.ZZ();
            this.dtz.apm();
            Log.e("MicroMsg.SceneVoice.Recorder", "Reset recorder.stopReocrd");
        }
        this.mFileName = "";
        this.dAl = 0;
        this.dAh = null;
        this.dAr = c.a.UNKNOWN;
        this.dAq = 0;
        this.dAm = 0;
        AppMethodBeat.o(148337);
    }

    @Override // com.tencent.mm.ak.m
    public final int aaq() {
        return this.dAn;
    }

    @Override // com.tencent.mm.ak.m
    public String getFileName() {
        return this.mFileName;
    }

    @Override // com.tencent.mm.ak.m
    public final boolean isRecording() {
        AppMethodBeat.i(148338);
        if (this.dAg == null) {
            AppMethodBeat.o(148338);
            return false;
        } else if (this.dAg.getStatus() == 1) {
            AppMethodBeat.o(148338);
            return true;
        } else {
            AppMethodBeat.o(148338);
            return false;
        }
    }

    @Override // com.tencent.mm.ak.m
    public final int getMaxAmplitude() {
        AppMethodBeat.i(148339);
        if (this.dAg == null) {
            AppMethodBeat.o(148339);
            return 0;
        }
        int maxAmplitude = this.dAg.getMaxAmplitude();
        AppMethodBeat.o(148339);
        return maxAmplitude;
    }

    /* access modifiers changed from: package-private */
    public final class a implements com.tencent.f.i.h {
        MMHandler handler;

        public a() {
            AppMethodBeat.i(148334);
            this.handler = new MMHandler(h.this) {
                /* class com.tencent.mm.audio.b.h.a.AnonymousClass1 */

                @Override // com.tencent.mm.sdk.platformtools.MMHandler
                public final void handleMessage(Message message) {
                    AppMethodBeat.i(148333);
                    if (h.this.dAq <= 0) {
                        AppMethodBeat.o(148333);
                        return;
                    }
                    Log.d("MicroMsg.SceneVoice.Recorder", "On Part :" + (h.this.dAs == null));
                    h.this.dAq = 2;
                    if (h.this.dAs != null) {
                        h.this.dAs.aYN();
                    }
                    AppMethodBeat.o(148333);
                }
            };
            AppMethodBeat.o(148334);
        }

        public final void run() {
            AppMethodBeat.i(148335);
            MMHandlerThread.removeRunnable(h.this.dAw);
            Log.i("MicroMsg.SceneVoice.Recorder", "RecordStartRunnable begin run %s", Long.valueOf(Thread.currentThread().getId()));
            synchronized (h.this) {
                try {
                    Log.i("MicroMsg.SceneVoice.Recorder", "lock[%s] of runnable[%s]!", Long.valueOf(Thread.currentThread().getId()), h.this);
                    if (h.this.dAg == null) {
                        Log.e("MicroMsg.SceneVoice.Recorder", "Stop Record Failed recorder == null");
                        return;
                    }
                    try {
                        String aTa = s.aTa();
                        String messageDigest = g.getMessageDigest(h.this.mFileName.getBytes());
                        String str = aTa + messageDigest.substring(0, 2) + '/' + messageDigest.substring(2, 4) + '/';
                        com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(str);
                        com.tencent.mm.vfs.o oVar2 = new com.tencent.mm.vfs.o(str);
                        if (oVar.exists() && !oVar2.exists()) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.n(357, 59, 1);
                            Log.e("DEBUG.VFS", "Resolution: " + com.tencent.mm.vfs.g.hYQ().a(oVar.mUri, (g.e) null).toString());
                            Log.e("DEBUG.VFS", "VFS Path: " + aa.z(oVar.mUri));
                            Log.e("DEBUG.VFS", "VFS Real path: " + com.tencent.mm.vfs.s.k(aa.z(oVar.mUri), false));
                            Log.e("DEBUG.VFS", "File absolute path: " + aa.z(oVar2.her()));
                        }
                    } catch (Throwable th) {
                        Log.printErrStackTrace("MicroMsg.SceneVoice.Recorder", th, "Failed to detect error", new Object[0]);
                    }
                    String Y = s.Y(h.this.mFileName, !h.this.dAp);
                    Log.i("MicroMsg.SceneVoice.Recorder", "Thread Started Record, fullPath: %s, useSpeex: %s", Y, Boolean.valueOf(h.this.dAp));
                    if (!h.this.dAg.hw(Y)) {
                        s.Rk(h.this.mFileName);
                        h.this.mFileName = null;
                        h.this.dAg = null;
                        Log.e("MicroMsg.SceneVoice.Recorder", "Thread Start Record  Error fileName[" + h.this.mFileName + "]");
                    } else {
                        h.this.dtz.requestFocus();
                    }
                    h.this.dAm = Util.currentTicks();
                    Log.i("MicroMsg.SceneVoice.Recorder", "Thread Started Record fileName[" + h.this.mFileName + "] time:" + Util.ticksToNow(h.this.dAl));
                    this.handler.sendEmptyMessageDelayed(0, 1);
                    AppMethodBeat.o(148335);
                } finally {
                    AppMethodBeat.o(148335);
                }
            }
        }

        @Override // com.tencent.f.i.h, com.tencent.f.i.g
        public final String getKey() {
            return "SceneVoiceRecorder_record";
        }
    }

    @Override // com.tencent.mm.ak.m
    public final boolean hx(String str) {
        AppMethodBeat.i(148340);
        Log.i("MicroMsg.SceneVoice.Recorder", "Start Record to  ".concat(String.valueOf(str)));
        reset();
        this.dAi = str;
        this.dAl = Util.currentTicks();
        if (str == null) {
            Log.e("MicroMsg.SceneVoice.Recorder", "Start Record toUser null");
            AppMethodBeat.o(148340);
            return false;
        }
        this.dAj = str.equals("_USER_FOR_THROWBOTTLE_");
        if (str.equals("medianote")) {
            this.dAk = (z.aUc() & 16384) == 0;
        }
        if (!this.dAp) {
            if (this.dAj) {
                this.mFileName = w.Rq(z.aTY());
            } else if (this.dAk) {
                this.mFileName = w.Rq("medianote");
            }
            if (this.mFileName != null || this.mFileName.length() <= 0) {
                Log.e("MicroMsg.SceneVoice.Recorder", "Start Record DBError fileName:%s", this.mFileName);
                AppMethodBeat.o(148340);
                return false;
            }
            this.dAo = false;
            this.dAu.Yo();
            AppMethodBeat.o(148340);
            return true;
        }
        this.mFileName = s.Rh(str);
        if (this.mFileName != null) {
        }
        Log.e("MicroMsg.SceneVoice.Recorder", "Start Record DBError fileName:%s", this.mFileName);
        AppMethodBeat.o(148340);
        return false;
    }

    @Override // com.tencent.mm.ak.m
    public final boolean cancel() {
        AppMethodBeat.i(148341);
        Log.d("MicroMsg.SceneVoice.Recorder", "cancel Record :" + this.mFileName);
        synchronized (this) {
            try {
                Log.i("MicroMsg.SceneVoice.Recorder", "lock[%s] of cancel[%s]! stop synchronized Record:" + this.mFileName, Long.valueOf(Thread.currentThread().getId()), this);
                if (this.dAg != null) {
                    this.dAg.ZZ();
                    this.dtz.apm();
                }
            } catch (Throwable th) {
                AppMethodBeat.o(148341);
                throw th;
            }
        }
        this.dAu.Yp();
        s.Ri(this.mFileName);
        o.bid().run();
        if (this.dAg != null && !Util.isNullOrNil(this.mFileName) && !this.dAp) {
            com.tencent.mm.compatible.g.a aVar = new com.tencent.mm.compatible.g.a();
            aVar.gLc = this.mFileName;
            aVar.gLd = aas();
            aVar.gLe = 1;
            aVar.dGe = this.dAg.aaa();
            com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10513, aVar.apk());
        }
        this.mFileName = "";
        AppMethodBeat.o(148341);
        return true;
    }

    @Override // com.tencent.mm.ak.m
    public boolean Qt() {
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.i(148342);
        if (this.dAv != null) {
            this.dAv.stopTimer();
            this.dAv.removeCallbacksAndMessages(null);
        }
        this.dAu.Yp();
        this.dAn = (int) aas();
        Log.i("MicroMsg.SceneVoice.Recorder", "stop Record : %s, len: %s", this.mFileName, Integer.valueOf(this.dAn));
        if (this.dAg != null && !Util.isNullOrNil(this.mFileName) && !this.dAp) {
            com.tencent.mm.compatible.g.a aVar = new com.tencent.mm.compatible.g.a();
            aVar.gLc = this.mFileName;
            aVar.gLd = (long) this.dAn;
            aVar.gLe = 2;
            aVar.dGe = this.dAg.aaa();
            com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(10513, aVar.apk());
        }
        synchronized (this) {
            try {
                Log.i("MicroMsg.SceneVoice.Recorder", "stop synchronized Record:%s, recorder:%s, lock[%s] of stop[%s]!", this.mFileName, this.dAg, Long.valueOf(Thread.currentThread().getId()), this);
                if (this.dAg != null) {
                    this.dAg.ZZ();
                    this.dtz.apm();
                }
            } catch (Throwable th) {
                AppMethodBeat.o(148342);
                throw th;
            }
        }
        if (this.dAq != 2) {
            s.Rk(this.mFileName);
            this.mFileName = null;
            Log.i("MicroMsg.SceneVoice.Recorder", "Stop " + this.mFileName + " by not onPart: " + Util.ticksToNow(this.dAl));
        } else {
            if (((long) this.dAn) < 800 || (this.dAj && ((long) this.dAn) < 1000)) {
                Log.i("MicroMsg.SceneVoice.Recorder", "Stop " + this.mFileName + " by voiceLen: " + this.dAn);
                s.Rk(this.mFileName);
                this.mFileName = "";
                z = false;
            } else {
                s.aB(this.mFileName, this.dAn);
                o.bid().run();
                Log.i("MicroMsg.SceneVoice.Recorder", "Stop file success: " + this.mFileName);
            }
            this.mFileName = "";
            z2 = z;
        }
        this.dAq = -1;
        AppMethodBeat.o(148342);
        return z2;
    }

    @Override // com.tencent.mm.ak.m
    public final void aar() {
        AppMethodBeat.i(148343);
        Log.d("MicroMsg.SceneVoice.Recorder", "stop2 Record: %s.", this.mFileName);
        if (this.dAv != null) {
            this.dAv.stopTimer();
            this.dAv.removeCallbacksAndMessages(null);
        }
        this.dAu.Yp();
        synchronized (this) {
            try {
                Log.i("MicroMsg.SceneVoice.Recorder", "lock[%s] of stop2[%s]! stop synchronized Record:" + this.mFileName, Long.valueOf(Thread.currentThread().getId()), this);
                if (this.dAg != null) {
                    this.dAg.ZZ();
                    this.dtz.apm();
                }
            } catch (Throwable th) {
                AppMethodBeat.o(148343);
                throw th;
            }
        }
        this.dAq = -1;
        AppMethodBeat.o(148343);
    }

    @Override // com.tencent.mm.ak.m
    public final long aas() {
        AppMethodBeat.i(148345);
        if (this.dAm == 0) {
            AppMethodBeat.o(148345);
            return 0;
        }
        long ticksToNow = Util.ticksToNow(this.dAm);
        AppMethodBeat.o(148345);
        return ticksToNow;
    }

    @Override // com.tencent.mm.ak.m
    public final void a(m.a aVar) {
        this.dAt = aVar;
    }

    @Override // com.tencent.mm.ak.m
    public final void a(m.b bVar) {
        this.dAs = bVar;
    }

    @Override // com.tencent.mm.ak.m
    public final int aat() {
        if (this.dAp) {
            return 1;
        }
        if (this.dAr == c.a.PCM || this.dAr == c.a.AMR) {
            return 0;
        }
        if (this.dAr == c.a.SILK) {
            return 2;
        }
        return -1;
    }

    static /* synthetic */ void a(h hVar) {
        c.a aVar;
        AppMethodBeat.i(187326);
        if (hVar.dAo) {
            Log.i("MicroMsg.SceneVoice.Recorder", "[startRecordInternal] return mHasBeginRec is true!");
            AppMethodBeat.o(187326);
            return;
        }
        hVar.dAo = true;
        if (hVar.dAp) {
            hVar.dAr = c.a.SPEEX;
            hVar.dAg = new com.tencent.mm.modelvoice.m();
        } else {
            SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
            boolean z = ae.gKu.gDI != 1;
            if (!sharedPreferences.contains("settings_voicerecorder_mode")) {
                sharedPreferences.edit().putBoolean("settings_voicerecorder_mode", z).commit();
            }
            Log.i("AudioConfig", "getModeByConfig mVoiceRecordMode:%d defValue:%b settings_voicerecorder_mode:%b", Integer.valueOf(ae.gKu.gDI), Boolean.valueOf(z), Boolean.valueOf(sharedPreferences.getBoolean("settings_voicerecorder_mode", z)));
            if (sharedPreferences.getBoolean("settings_voicerecorder_mode", z)) {
                aVar = c.a.PCM;
            } else {
                aVar = c.a.AMR;
            }
            hVar.dAr = aVar;
            String value = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("VoiceFormat");
            String value2 = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue("VoiceFormatToQQ");
            if (hVar.dAr == c.a.PCM) {
                if (4 == Util.getInt(value, 4) && g.b.aap()) {
                    hVar.dAr = c.a.SILK;
                }
                if (hVar.dAi != null && hVar.dAi.endsWith("@qqim")) {
                    hVar.dAr = c.a.AMR;
                }
            }
            if (hVar.dAr == c.a.PCM) {
                Log.i("MicroMsg.SceneVoice.Recorder", "refreshRecordMode, still in pcm mode, force to amr mode");
                hVar.dAr = c.a.AMR;
            }
            Log.i("MicroMsg.SceneVoice.Recorder", "refreshRecordMode dynamicFormat:%s dynamicFormatQQ:%s recdMode:%s isSilkSoLoadSuccess:%b", value, value2, hVar.dAr, Boolean.valueOf(g.b.aap()));
            hVar.dAg = new v(hVar.dAr);
        }
        AnonymousClass3 r0 = new m.a() {
            /* class com.tencent.mm.audio.b.h.AnonymousClass3 */

            @Override // com.tencent.mm.ak.m.a
            public final void onError() {
                AppMethodBeat.i(148331);
                h.this.dtz.apm();
                Log.e("MicroMsg.SceneVoice.Recorder", "Record Failed file:" + h.this.mFileName);
                s.Rk(h.this.mFileName);
                if (h.this.dAt != null) {
                    h.this.dAt.onError();
                }
                AppMethodBeat.o(148331);
            }
        };
        if (hVar.dAg != null) {
            hVar.dAg.a(r0);
        }
        AnonymousClass4 r02 = new Runnable() {
            /* class com.tencent.mm.audio.b.h.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(148332);
                Log.e("MicroMsg.SceneVoice.Recorder", "start record timeout");
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(357, 51, 1, true);
                if (!h.cxw) {
                    if (d.KyR) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.e("Record", "start record timeout", null);
                    }
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(357, 52, 1, true);
                }
                boolean unused = h.cxw = true;
                AppMethodBeat.o(148332);
            }
        };
        hVar.dAw = r02;
        MMHandlerThread.postToMainThreadDelayed(r02, 600);
        hVar.dAh = new a();
        Log.i("MicroMsg.SceneVoice.Recorder", "[startRecordInternal] mRecordStartRunnable has post! threadPool:%s", com.tencent.f.h.RTd.hmd());
        com.tencent.f.h.RTc.aX(hVar.dAh);
        hVar.dAq = 1;
        hVar.dAv.startTimer(3000);
        Log.d("MicroMsg.SceneVoice.Recorder", "start end time:" + Util.ticksToNow(hVar.dAl));
        AppMethodBeat.o(187326);
    }
}
