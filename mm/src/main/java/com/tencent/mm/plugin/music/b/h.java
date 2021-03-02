package com.tencent.mm.plugin.music.b;

import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.d;
import com.tencent.mm.audio.mix.b.e;
import com.tencent.mm.audio.mix.e.f;
import com.tencent.mm.audio.mix.g.c;
import com.tencent.mm.audio.mix.g.g;
import com.tencent.mm.g.a.y;
import com.tencent.mm.plugin.music.cache.i;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher;
import com.tencent.tav.coremedia.TimeUtil;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class h {
    private static h Ahv;
    private LinkedList<String> AgR = new LinkedList<>();
    HashMap<String, k> AgS = new HashMap<>();
    LinkedList<String> AgT = new LinkedList<>();
    HashMap<String, k> AgU = new HashMap<>();
    LinkedList<String> AgV = new LinkedList<>();
    public LinkedList<String> AgW = new LinkedList<>();
    private HashMap<String, String> AgX = new HashMap<>();
    HashMap<String, LinkedList<String>> AgY = new HashMap<>();
    HashMap<String, b> AgZ = new HashMap<>();
    private g AhA = new g() {
        /* class com.tencent.mm.plugin.music.b.h.AnonymousClass7 */

        @Override // com.tencent.mm.audio.mix.g.g
        public final void jj(int i2) {
            AppMethodBeat.i(198159);
            if (h.this.Ahi != null) {
                h.this.Ahi.Sy(i2);
            }
            AppMethodBeat.o(198159);
        }
    };
    private f.a AhB = new f.a() {
        /* class com.tencent.mm.plugin.music.b.h.AnonymousClass8 */

        @Override // com.tencent.mm.audio.mix.e.f.a
        public final void e(final b bVar) {
            boolean z;
            AppMethodBeat.i(198161);
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "loadCache audio:%s", bVar.dtX);
            if (bVar != null) {
                b LU = h.this.LU(bVar.dtX);
                if (LU == null || TextUtils.isEmpty(LU.filePath) || !h.this.Ahp.hn(LU.filePath)) {
                    z = false;
                } else {
                    z = true;
                }
                Log.i("MicroMsg.Audio.AudioPlayerMgr", "cached:%b", Boolean.valueOf(z));
                if (!z && h.this.mHandler != null) {
                    h.this.mHandler.post(new Runnable() {
                        /* class com.tencent.mm.plugin.music.b.h.AnonymousClass8.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(198160);
                            h.this.aHm(bVar.dtX);
                            h.this.q(bVar);
                            h.this.aHn(bVar.dtX);
                            AppMethodBeat.o(198160);
                        }
                    });
                }
            }
            AppMethodBeat.o(198161);
        }
    };
    volatile int AhC = 0;
    private HashMap<String, d> Aha = new HashMap<>();
    private LinkedList<String> Ahb = new LinkedList<>();
    HashMap<String, Integer> Ahc = new HashMap<>();
    private LinkedList<String> Ahd = new LinkedList<>();
    boolean Ahe = false;
    private boolean Ahf = false;
    long Ahg = 0;
    private long Ahh = 0;
    com.tencent.mm.plugin.music.b.a.d Ahi;
    private com.tencent.mm.plugin.music.b.b.a Ahj = new com.tencent.mm.plugin.music.b.b.a();
    private PhoneStatusWatcher Ahk;
    private volatile boolean Ahl = false;
    ArrayList<j> Ahm = new ArrayList<>();
    private HashMap<String, String> Ahn = new HashMap<>();
    HashMap<String, Integer> Aho = new HashMap<>();
    c Ahp;
    private volatile boolean Ahq = true;
    long Ahr = 0;
    private LinkedList<String> Ahs = new LinkedList<>();
    LinkedList<String> Aht = new LinkedList<>();
    com.tencent.mm.audio.mix.e.a Ahu;
    private e Ahw = new e() {
        /* class com.tencent.mm.plugin.music.b.h.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.music.b.e
        public final void onStart(String str) {
            AppMethodBeat.i(198141);
            k aHb = h.this.aHb(str);
            if (aHb == null) {
                Log.e("MicroMsg.Audio.AudioPlayerMgr", "onStart player is null");
                AppMethodBeat.o(198141);
                return;
            }
            h.this.e(str, aHb);
            synchronized (h.this.ryf) {
                try {
                    h.this.Ahe = false;
                } catch (Throwable th) {
                    AppMethodBeat.o(198141);
                    throw th;
                }
            }
            MMHandlerThread.removeRunnable(h.this.Ahy);
            AppMethodBeat.o(198141);
        }

        @Override // com.tencent.mm.plugin.music.b.e
        public final void aGS(String str) {
            AppMethodBeat.i(198142);
            k aHb = h.this.aHb(str);
            if (aHb == null) {
                Log.e("MicroMsg.Audio.AudioPlayerMgr", "onPause player is null");
                AppMethodBeat.o(198142);
                return;
            }
            h.this.b(str, aHb);
            h.this.f(str, aHb);
            h.a(h.this);
            h.this.esK();
            AppMethodBeat.o(198142);
        }

        @Override // com.tencent.mm.plugin.music.b.e
        public final void arD(String str) {
            AppMethodBeat.i(198143);
            k aHb = h.this.aHb(str);
            if (aHb == null) {
                Log.e("MicroMsg.Audio.AudioPlayerMgr", "onStop player is null");
                AppMethodBeat.o(198143);
                return;
            }
            h.this.b(str, aHb);
            h.this.f(str, aHb);
            h.a(h.this);
            h.this.esK();
            h.this.aHm(str);
            h.this.aHn(str);
            AppMethodBeat.o(198143);
        }

        @Override // com.tencent.mm.plugin.music.b.e
        public final void gY(String str) {
            AppMethodBeat.i(198144);
            k aHb = h.this.aHb(str);
            if (aHb == null) {
                Log.e("MicroMsg.Audio.AudioPlayerMgr", "onComplete player is null");
                AppMethodBeat.o(198144);
                return;
            }
            h.this.b(str, aHb);
            h.this.f(str, aHb);
            h.a(h.this);
            h.this.esK();
            h.this.aHm(str);
            h.this.aHn(str);
            AppMethodBeat.o(198144);
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x004c  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0081  */
        @Override // com.tencent.mm.plugin.music.b.e
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onError(java.lang.String r8) {
            /*
            // Method dump skipped, instructions count: 160
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.music.b.h.AnonymousClass2.onError(java.lang.String):void");
        }
    };
    private Runnable Ahx = new Runnable() {
        /* class com.tencent.mm.plugin.music.b.h.AnonymousClass3 */

        public final void run() {
            AppMethodBeat.i(137022);
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "stopAudioDelayRunnable, run");
            Iterator<String> it = h.this.AgW.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (h.this.aHa(next) == 0) {
                    h.this.aHc(next);
                }
            }
            AppMethodBeat.o(137022);
        }
    };
    Runnable Ahy = new Runnable() {
        /* class com.tencent.mm.plugin.music.b.h.AnonymousClass4 */

        public final void run() {
            boolean z;
            AppMethodBeat.i(198146);
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "releaseAudioDelayRunnable, run");
            Iterator<String> it = h.this.AgW.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                String next = it.next();
                if (h.this.aHa(next) == 0) {
                    h hVar = h.this;
                    Log.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllAudioPlayersAndSaveState, appId:%s", next);
                    LinkedList<String> linkedList = hVar.AgY.get(next);
                    if (linkedList == null || linkedList.size() == 0) {
                        Log.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to stop");
                    } else {
                        synchronized (hVar.ryf) {
                            try {
                                Iterator<String> it2 = linkedList.iterator();
                                while (it2.hasNext()) {
                                    String next2 = it2.next();
                                    if (hVar.Ahp.gD(next2)) {
                                        hVar.Ahp.he(next2);
                                    }
                                    k remove = hVar.AgS.remove(next2);
                                    hVar.AgT.remove(next2);
                                    if (remove != null) {
                                        hVar.b(next2, remove);
                                        Log.i("MicroMsg.Audio.AudioPlayerMgr", "destroy player");
                                        if (remove.iJV) {
                                            h.d(next2, remove);
                                        } else {
                                            h.c(next2, remove);
                                        }
                                    }
                                }
                                Iterator<String> it3 = linkedList.iterator();
                                while (it3.hasNext()) {
                                    String next3 = it3.next();
                                    if (hVar.Ahp.gD(next3)) {
                                        hVar.Ahp.he(next3);
                                    }
                                    k remove2 = hVar.AgU.remove(next3);
                                    hVar.AgV.remove(next3);
                                    if (remove2 != null) {
                                        hVar.b(next3, remove2);
                                        Log.i("MicroMsg.Audio.AudioPlayerMgr", "destroy recycled player");
                                        if (remove2.iJV) {
                                            h.d(next3, remove2);
                                        } else {
                                            h.c(next3, remove2);
                                        }
                                    }
                                }
                            } catch (Throwable th) {
                                AppMethodBeat.o(198146);
                                throw th;
                            }
                        }
                    }
                    z = true;
                } else {
                    z = z2;
                }
                z2 = z;
            }
            if (!z2) {
                synchronized (h.this.ryf) {
                    try {
                        h.this.Ahe = true;
                    } finally {
                        AppMethodBeat.o(198146);
                    }
                }
                h.this.Ahg = System.currentTimeMillis();
                MMHandlerThread.postToMainThreadDelayed(h.this.Ahy, 1800000);
            }
        }
    };
    private com.tencent.mm.audio.mix.g.b Ahz = new com.tencent.mm.audio.mix.g.b() {
        /* class com.tencent.mm.plugin.music.b.h.AnonymousClass6 */

        @Override // com.tencent.mm.audio.mix.g.b
        public final void b(y yVar) {
            AppMethodBeat.i(198148);
            EventCenter.instance.asyncPublish(yVar, Looper.getMainLooper());
            AppMethodBeat.o(198148);
        }

        @Override // com.tencent.mm.audio.mix.g.b
        public final void c(y yVar) {
            AppMethodBeat.i(198149);
            EventCenter.instance.asyncPublish(yVar, Looper.getMainLooper());
            AppMethodBeat.o(198149);
        }

        @Override // com.tencent.mm.audio.mix.g.b
        public final void d(y yVar) {
            AppMethodBeat.i(198150);
            EventCenter.instance.asyncPublish(yVar, Looper.getMainLooper());
            AppMethodBeat.o(198150);
        }

        @Override // com.tencent.mm.audio.mix.g.b
        public final void e(y yVar) {
            AppMethodBeat.i(198151);
            EventCenter.instance.asyncPublish(yVar, Looper.getMainLooper());
            AppMethodBeat.o(198151);
        }

        @Override // com.tencent.mm.audio.mix.g.b
        public final void f(y yVar) {
            AppMethodBeat.i(198152);
            EventCenter.instance.asyncPublish(yVar, Looper.getMainLooper());
            h.a(h.this, yVar.dCW.dtX);
            AppMethodBeat.o(198152);
        }

        @Override // com.tencent.mm.audio.mix.g.b
        public final void g(y yVar) {
            AppMethodBeat.i(198153);
            EventCenter.instance.asyncPublish(yVar, Looper.getMainLooper());
            AppMethodBeat.o(198153);
        }

        @Override // com.tencent.mm.audio.mix.g.b
        public final void h(y yVar) {
            AppMethodBeat.i(198154);
            EventCenter.instance.asyncPublish(yVar, Looper.getMainLooper());
            AppMethodBeat.o(198154);
        }

        @Override // com.tencent.mm.audio.mix.g.b
        public final void i(y yVar) {
            AppMethodBeat.i(198155);
            EventCenter.instance.asyncPublish(yVar, Looper.getMainLooper());
            AppMethodBeat.o(198155);
        }

        @Override // com.tencent.mm.audio.mix.g.b
        public final void j(y yVar) {
            AppMethodBeat.i(198156);
            int i2 = yVar.dCW.errCode;
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "onError errCode:%d", Integer.valueOf(i2));
            if (i2 == 709 || i2 == 702 || i2 == 703 || i2 == 705 || i2 == 706) {
                Log.e("MicroMsg.Audio.AudioPlayerMgr", "decode mix cache errors, don't callback to JS");
            } else {
                EventCenter.instance.asyncPublish(yVar, Looper.getMainLooper());
            }
            if (h.this.Ahi != null) {
                b bVar = h.this.AgZ.get(yVar.dCW.dtX);
                if (bVar == null) {
                    AppMethodBeat.o(198156);
                    return;
                }
                h.this.Ahi.Sz(yVar.dCW.errCode);
                if (!h.this.Ahp.hn(bVar.filePath)) {
                    if (h.this.Aho.containsKey(bVar.filePath)) {
                        h.this.Aho.put(bVar.filePath, Integer.valueOf(h.this.Aho.get(bVar.filePath).intValue() + 1));
                    } else {
                        h.this.Aho.put(bVar.filePath, 1);
                    }
                }
            }
            h.a(h.this, yVar.dCW.dtX);
            AppMethodBeat.o(198156);
        }

        @Override // com.tencent.mm.audio.mix.g.b
        public final void k(y yVar) {
            AppMethodBeat.i(198157);
            if (h.this.Ahi != null) {
                b bVar = h.this.AgZ.get(yVar.dCW.dtX);
                if (bVar == null) {
                    AppMethodBeat.o(198157);
                    return;
                }
                if (bVar.iJK > TimeUtil.SECOND_TO_US) {
                    Log.e("MicroMsg.Audio.AudioPlayerMgr", "onRealPlay: %s, invokeCallTime:%d", bVar.dtX, Long.valueOf(bVar.iJK));
                }
                String str = yVar.dCW.dvn;
                if (TextUtils.isEmpty(str)) {
                    str = bVar.dvn;
                }
                h.this.Ahi.a(bVar.dtX, str, System.currentTimeMillis() - bVar.iJI, bVar.iJJ, bVar.iJK, false, bVar.filePath, (long) h.this.Ahp.hj(bVar.dtX), bVar.fileSize, com.tencent.mm.audio.mix.b.f.YL().gH(bVar.filePath));
                if (h.this.Aho.containsKey(bVar.filePath)) {
                    h.this.Aho.remove(bVar.filePath);
                }
            }
            AppMethodBeat.o(198157);
        }

        @Override // com.tencent.mm.audio.mix.g.b
        public final void l(y yVar) {
            AppMethodBeat.i(198158);
            h.a(h.this, yVar.dCW.dtX);
            AppMethodBeat.o(198158);
        }
    };
    private Looper Jap;
    com.tencent.mm.ai.a dCU = new com.tencent.mm.ai.a();
    private AudioManager mAudioManager = ((AudioManager) MMApplicationContext.getContext().getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE));
    Handler mHandler;
    volatile boolean qUm = true;
    Object ryf = new Object();

    public static synchronized void esH() {
        synchronized (h.class) {
            AppMethodBeat.i(137035);
            if (Ahv != null) {
                AppMethodBeat.o(137035);
            } else {
                Ahv = new h();
                AppMethodBeat.o(137035);
            }
        }
    }

    public static h esI() {
        AppMethodBeat.i(137036);
        if (Ahv == null) {
            Ahv = new h();
        }
        h hVar = Ahv;
        AppMethodBeat.o(137036);
        return hVar;
    }

    private h() {
        AppMethodBeat.i(137037);
        _release();
        this.Ahp = new c();
        this.Ahp.a(this.Ahz);
        this.Ahp.a(this.AhA);
        this.Ahu = new b();
        this.Ahu.dvT = this.AhB;
        AppMethodBeat.o(137037);
    }

    public final void _release() {
        AppMethodBeat.i(137038);
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "_release");
        this.AgR.clear();
        synchronized (this.ryf) {
            try {
                Iterator<String> it = this.AgT.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    c(next, this.AgS.remove(next));
                }
                this.AgT.clear();
                this.AgS.clear();
                Iterator<String> it2 = this.AgV.iterator();
                while (it2.hasNext()) {
                    String next2 = it2.next();
                    c(next2, this.AgU.remove(next2));
                }
                this.AgV.clear();
                this.AgU.clear();
            } catch (Throwable th) {
                AppMethodBeat.o(137038);
                throw th;
            }
        }
        Iterator<String> it3 = this.AgW.iterator();
        while (it3.hasNext()) {
            LinkedList<String> remove = this.AgY.remove(it3.next());
            if (remove != null) {
                remove.clear();
            }
        }
        this.AgW.clear();
        this.AgX.clear();
        this.AgY.clear();
        this.AgZ.clear();
        this.Aha.clear();
        this.Ahc.clear();
        this.Ahd.clear();
        MMHandlerThread.removeRunnable(this.Ahx);
        MMHandlerThread.removeRunnable(this.Ahy);
        this.Ahe = false;
        this.Ahf = false;
        esT();
        AppMethodBeat.o(137038);
    }

    private void a(String str, b bVar) {
        AppMethodBeat.i(137039);
        if (bVar == null) {
            Log.e("MicroMsg.Audio.AudioPlayerMgr", "restorePlayerParam param == null, audioId:%s", str);
            AppMethodBeat.o(137039);
            return;
        }
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "restorePlayerParam audioId:%s", str);
        this.AgX.put(bVar.appId, bVar.processName);
        this.AgZ.put(bVar.dtX, bVar);
        iR(bVar.appId, str);
        this.Ahc.remove(str);
        AppMethodBeat.o(137039);
    }

    private void iR(String str, String str2) {
        AppMethodBeat.i(137040);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AppMethodBeat.o(137040);
            return;
        }
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "saveCreateId, appId:%s, audioId:%s", str, str2);
        if (!this.AgW.contains(str)) {
            this.AgW.add(str);
        }
        if (!this.AgR.contains(str2)) {
            this.AgR.add(str2);
        }
        LinkedList<String> linkedList = this.AgY.get(str);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
        }
        if (!linkedList.contains(str2)) {
            linkedList.add(str2);
        }
        this.AgY.put(str, linkedList);
        AppMethodBeat.o(137040);
    }

    public final String iS(String str, String str2) {
        boolean z;
        AppMethodBeat.i(137041);
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "createAudioPlayer");
        LinkedList<String> linkedList = this.AgY.get(str);
        synchronized (this.ryf) {
            if (linkedList != null) {
                try {
                    if (linkedList.contains(str2) && (this.AgT.contains(str2) || this.AgV.contains(str2))) {
                        z = true;
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(137041);
                    throw th;
                }
            }
            z = false;
        }
        int aHa = aHa(str);
        if (TextUtils.isEmpty(str2)) {
            Log.e("MicroMsg.Audio.AudioPlayerMgr", "createAudioPlayer fail, the audioId is empty!");
            bL(604, str2);
            AppMethodBeat.o(137041);
            return null;
        } else if (aHa >= 10) {
            Log.e("MicroMsg.Audio.AudioPlayerMgr", "now created QQAudioPlayer count %d arrive MAX_AUDIO_PLAYER_COUNT, save id and not send error event, not create player!", Integer.valueOf(aHa));
            iR(str, str2);
            AppMethodBeat.o(137041);
            return null;
        } else if (z) {
            Log.e("MicroMsg.Audio.AudioPlayerMgr", "now created QQAudioPlayer fail, the audioId exist in mAudioIds");
            bL(603, str2);
            AppMethodBeat.o(137041);
            return null;
        } else {
            iR(str, str2);
            aHh(str2);
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "create player success, appId:%s, audioId:%s", str, str2);
            AppMethodBeat.o(137041);
            return str2;
        }
    }

    public final boolean l(b bVar) {
        AppMethodBeat.i(137042);
        if (bVar == null) {
            Log.e("MicroMsg.Audio.AudioPlayerMgr", "setAudioParam param == null");
            AppMethodBeat.o(137042);
            return false;
        }
        b bVar2 = this.AgZ.get(bVar.dtX);
        if (bVar2 != null) {
            bVar2.k(bVar);
        } else {
            this.AgZ.put(bVar.dtX, bVar);
            bVar2 = bVar;
        }
        k aHb = aHb(bVar.dtX);
        if (aHb != null) {
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "setAudioParam player ok");
            aHb.g(bVar2);
        } else {
            Log.e("MicroMsg.Audio.AudioPlayerMgr", "setAudioParam player is null");
        }
        if (esF()) {
            if (this.Ahp.gD(bVar.dtX)) {
                this.Ahp.h(bVar);
            } else {
                this.Ahp.g(bVar);
            }
        }
        AppMethodBeat.o(137042);
        return true;
    }

    public final boolean a(com.tencent.mm.ai.a aVar) {
        this.dCU = aVar;
        this.qUm = aVar.dtE;
        return true;
    }

    public final boolean m(b bVar) {
        boolean z = false;
        AppMethodBeat.i(137043);
        if (bVar == null) {
            Log.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio, play param is null");
            bL(605, "");
            AppMethodBeat.o(137043);
            return false;
        } else if (TextUtils.isEmpty(bVar.dtX)) {
            Log.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio fail, the audioId is empty!");
            bL(604, bVar.dtX);
            AppMethodBeat.o(137043);
            return false;
        } else if (!this.AgR.contains(bVar.dtX)) {
            Log.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio fail, the audioId is not found!");
            bL(601, bVar.dtX);
            AppMethodBeat.o(137043);
            return false;
        } else {
            if (bVar.iJE) {
                n(bVar);
            }
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "startAudio");
            if (!this.Ahl) {
                if (android.support.v4.content.b.checkSelfPermission(MMApplicationContext.getContext(), "android.permission.READ_PHONE_STATE") != 0) {
                    Log.e("MicroMsg.Audio.AudioPlayerMgr", "addPhoneStatusWatcher() not have read_phone_state perm");
                } else {
                    this.Ahk = new PhoneStatusWatcher();
                    this.Ahk.begin(MMApplicationContext.getContext());
                    this.Ahk.addPhoneCallListener(new PhoneStatusWatcher.PhoneCallListener() {
                        /* class com.tencent.mm.plugin.music.b.h.AnonymousClass9 */

                        @Override // com.tencent.mm.sdk.platformtools.PhoneStatusWatcher.PhoneCallListener
                        public final void onPhoneCall(int i2) {
                            AppMethodBeat.i(198162);
                            Log.i("MicroMsg.Audio.AudioPlayerMgr", "onPhoneCall state:%d", Integer.valueOf(i2));
                            synchronized (h.this.Ahm) {
                                try {
                                    Iterator<j> it = h.this.Ahm.iterator();
                                    while (it.hasNext()) {
                                        it.next().onPhoneCall(i2);
                                    }
                                } finally {
                                    AppMethodBeat.o(198162);
                                }
                            }
                        }
                    });
                    this.Ahl = true;
                    Log.i("MicroMsg.Audio.AudioPlayerMgr", "addPhoneStatusWatcher");
                }
            }
            String aHf = aHf(bVar.dtX);
            b LU = LU(bVar.dtX);
            int aHa = aHa(aHf);
            if (aHa >= 10) {
                Log.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio now created QQAudioPlayer count %d arrive MAX_PLAY_AUDIO_PLAYER_COUNT, but save param!", Integer.valueOf(aHa));
                this.AgZ.put(bVar.dtX, bVar);
                Log.i("MicroMsg.Audio.AudioPlayerMgr", "autoPlay:%b", Boolean.valueOf(bVar.iJE));
                p(bVar);
                if (bVar.iJE && aHj(bVar.dtX)) {
                    esO();
                } else if (bVar.iJE) {
                    bL(600, bVar.dtX);
                    esQ();
                    AppMethodBeat.o(137043);
                    return false;
                } else {
                    Log.e("MicroMsg.Audio.AudioPlayerMgr", "save param, do nothing ");
                    k aHb = aHb(bVar.dtX);
                    if (aHb != null) {
                        aHb.g(bVar);
                        aHb.esY();
                    }
                    AppMethodBeat.o(137043);
                    return true;
                }
            }
            aHh(bVar.dtX);
            esP();
            aHo(aHf);
            esS();
            this.AgX.put(aHf, bVar.processName);
            this.AgZ.put(bVar.dtX, bVar);
            q(bVar);
            k aHb2 = aHb(bVar.dtX);
            boolean esF = esF();
            if (esF) {
                boolean a2 = a(aHb2);
                boolean z2 = (!TextUtils.isEmpty(bVar.filePath) && this.Ahp.hn(bVar.filePath)) || (LU != null && bVar.j(LU) && !TextUtils.isEmpty(LU.filePath) && this.Ahp.hn(LU.filePath));
                Log.i("MicroMsg.Audio.AudioPlayerMgr", "canUseMixPlayer:%b, localCacheExit:%b, audioId:%s", Boolean.valueOf(a2), Boolean.valueOf(z2), bVar.dtX);
                if (a2 && z2) {
                    Log.i("MicroMsg.Audio.AudioPlayerMgr", "startAudioByMixPlayer");
                    aHg(bVar.dtX);
                    o(bVar);
                    if (TextUtils.isEmpty(bVar.filePath) && LU != null && LU.j(bVar)) {
                        bVar.filePath = LU.filePath;
                    }
                    if (!bVar.iJE) {
                        if (this.Ahp.gD(bVar.dtX)) {
                            this.Ahp.h(bVar);
                        } else {
                            this.Ahp.g(bVar);
                        }
                        if (LU != null && !LU.j(bVar)) {
                            Log.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer param src change, do stop now");
                            if (this.Ahp.gO(bVar.dtX) || this.Ahp.hf(bVar.dtX) || this.Ahp.hg(bVar.dtX) || this.Ahp.hh(bVar.dtX) || this.Ahp.isPaused(bVar.dtX)) {
                                this.Ahp.he(bVar.dtX);
                            }
                        }
                        this.Ahp.q(7, bVar.dtX);
                    } else if (LU != null && !LU.j(bVar)) {
                        a(bVar, true, false);
                        Log.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer param src change, do stop now and play new");
                        if (this.Ahp.gO(bVar.dtX) || this.Ahp.hf(bVar.dtX) || this.Ahp.hg(bVar.dtX) || this.Ahp.hh(bVar.dtX) || this.Ahp.isPaused(bVar.dtX)) {
                            this.Ahp.he(bVar.dtX);
                        }
                        this.Ahp.f(bVar);
                    } else if (this.Ahp.gO(bVar.dtX)) {
                        Log.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is playing, do nothing");
                    } else if (this.Ahp.hf(bVar.dtX) && this.Ahp.isPaused(bVar.dtX)) {
                        Log.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is paused, do resume");
                        a(bVar, true, false);
                        this.Ahp.hc(bVar.dtX);
                    } else if (this.Ahp.hh(bVar.dtX)) {
                        Log.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is isPrepared, do resume");
                        a(bVar, true, false);
                        this.Ahp.hc(bVar.dtX);
                    } else if (this.Ahp.hg(bVar.dtX)) {
                        Log.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is isPreparing, do nothing");
                    } else {
                        Log.i("MicroMsg.Audio.AudioPlayerMgr", "mixPlayer is end or stop, do startPlay");
                        a(bVar, true, false);
                        this.Ahp.f(bVar);
                    }
                    AppMethodBeat.o(137043);
                    return true;
                }
            } else {
                Log.i("MicroMsg.Audio.AudioPlayerMgr", "not support mix audio");
            }
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "startAudioByQQAudioPlayer");
            k aHb3 = aHb(bVar.dtX);
            if (aHb3 == null) {
                Log.e("MicroMsg.Audio.AudioPlayerMgr", "startAudio, player is null, create new QQAudioPlayer with audioId:%s", bVar.dtX);
                k esJ = esJ();
                esJ.a(this.Ahw);
                esJ.aHp(bVar.dtX);
                esJ.g(bVar);
                if (bVar.iJE) {
                    a(bVar, true, true);
                    e(bVar.dtX, esJ);
                    bVar.iJF = System.currentTimeMillis();
                    esJ.s(bVar);
                } else {
                    f(bVar.dtX, esJ);
                    esJ.esY();
                    Log.e("MicroMsg.Audio.AudioPlayerMgr", "new player autoplay false, not to play ");
                }
            } else {
                Log.i("MicroMsg.Audio.AudioPlayerMgr", "startAudio, audioId:%s", bVar.dtX);
                if (bVar.iJE) {
                    e(bVar.dtX, aHb3);
                    bVar.iJF = System.currentTimeMillis();
                    aHb3.g(bVar);
                    if (LU != null && !LU.j(bVar)) {
                        Log.i("MicroMsg.Audio.AudioPlayerMgr", "param src change, do stop now and play new");
                        if (aHb3.bec() || aHb3.bee() || aHb3.dFr() || aHb3.asa() || aHb3.isPaused()) {
                            aHb3.stopPlay();
                        }
                        a(bVar, true, true);
                        aHb3.s(bVar);
                    } else if (aHb3.bec()) {
                        Log.i("MicroMsg.Audio.AudioPlayerMgr", "is playing, do nothing");
                    } else if (aHb3.bee() && aHb3.isPaused()) {
                        a(bVar, true, true);
                        Log.i("MicroMsg.Audio.AudioPlayerMgr", "is paused, do resume");
                        aHb3.resume();
                    } else if (aHb3.asa()) {
                        a(bVar, true, true);
                        Log.i("MicroMsg.Audio.AudioPlayerMgr", "is isPrepared, do resume");
                        aHb3.resume();
                    } else if (aHb3.dFr()) {
                        Log.i("MicroMsg.Audio.AudioPlayerMgr", "is isPreparing, do nothing");
                    } else {
                        a(bVar, true, true);
                        Log.i("MicroMsg.Audio.AudioPlayerMgr", "is end or stop, do startPlay");
                        aHb3.s(bVar);
                    }
                } else {
                    synchronized (this.ryf) {
                        try {
                            if (this.AgT.contains(bVar.dtX)) {
                                z = true;
                            }
                        } catch (Throwable th) {
                            AppMethodBeat.o(137043);
                            throw th;
                        }
                    }
                    if (!z) {
                        Log.i("MicroMsg.Audio.AudioPlayerMgr", "mark player recycle");
                        f(bVar.dtX, aHb3);
                    } else {
                        Log.i("MicroMsg.Audio.AudioPlayerMgr", "don't mark player, is playing");
                    }
                    aHb3.g(bVar);
                    if (LU != null && !LU.j(bVar)) {
                        Log.i("MicroMsg.Audio.AudioPlayerMgr", "param src change, do stop now");
                        if (aHb3.bec() || aHb3.bee() || aHb3.dFr() || aHb3.asa() || aHb3.isPaused()) {
                            aHb3.stopPlay();
                        }
                    }
                    aHb3.esY();
                    Log.e("MicroMsg.Audio.AudioPlayerMgr", "autoplay false, not to play ");
                }
            }
            if (esF) {
                this.Jap = Looper.myLooper();
                if (this.Ahp.gD(bVar.dtX)) {
                    this.Ahp.h(bVar);
                } else {
                    this.Ahp.g(bVar);
                }
                if (r(bVar) || !TextUtils.isEmpty(bVar.filePath)) {
                    aHn(bVar.dtX);
                }
            }
            p(bVar);
            AppMethodBeat.o(137043);
            return true;
        }
    }

    public final boolean b(String str, b bVar) {
        AppMethodBeat.i(137047);
        b bVar2 = this.AgZ.get(str);
        if ((!this.AgR.contains(str) || bVar2 == null) && bVar != null) {
            Log.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio, the audioId %s is not found or param is null, backupParam is exit", str);
            a(str, bVar);
            if (bVar2 == null) {
                bVar2 = bVar;
            }
        } else if (!this.AgR.contains(str)) {
            Log.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio fail, the audioId is not found!");
            bL(601, str);
            AppMethodBeat.o(137047);
            return false;
        } else if (bVar2 == null) {
            Log.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio fail, the param is not found!");
            bL(602, str);
            AppMethodBeat.o(137047);
            return false;
        }
        n(bVar2);
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio, audioId:%s", str);
        String aHf = aHf(str);
        int aHa = aHa(aHf);
        if (aHa >= 10) {
            Log.e("MicroMsg.Audio.AudioPlayerMgr", "now created QQAudioPlayer count %d arrive MAX_PLAY_AUDIO_PLAYER_COUNT", Integer.valueOf(aHa));
            if (aHj(str)) {
                esO();
            } else {
                esQ();
                bL(600, str);
                AppMethodBeat.o(137047);
                return false;
            }
        }
        esP();
        this.AgZ.put(str, bVar2);
        aHo(aHf);
        esS();
        k aHb = aHb(str);
        if (esF()) {
            boolean a2 = a(aHb);
            boolean z = this.Ahp.gD(str) && this.Ahp.hm(str);
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "resume canUseMixPlayer:%b, localCacheExit:%b, audioId:%s", Boolean.valueOf(a2), Boolean.valueOf(z), bVar2.dtX);
            if (a2 && z) {
                Log.i("MicroMsg.Audio.AudioPlayerMgr", "use AudioMixPlayer");
                aHg(bVar2.dtX);
                o(bVar2);
                if (this.Ahp.gO(bVar2.dtX)) {
                    Log.i("MicroMsg.Audio.AudioPlayerMgr", "mix player is playing, do nothing");
                } else if (this.Ahp.hg(bVar2.dtX)) {
                    Log.i("MicroMsg.Audio.AudioPlayerMgr", "mix player is preparing, do nothing");
                    bVar2.iJE = true;
                    aHb.g(bVar2);
                } else {
                    a(bVar2, false, false);
                    this.Ahp.hb(str);
                }
                AppMethodBeat.o(137047);
                return true;
            }
        } else {
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "Not support mix audio");
        }
        if (aHb == null) {
            Log.e("MicroMsg.Audio.AudioPlayerMgr", "resumeAudio, player is null");
            aHh(str);
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "create new QQAudioPlayer with audioId %s to play", str);
            k esJ = esJ();
            esJ.a(this.Ahw);
            esJ.aHp(str);
            e(str, esJ);
            bVar2.iJE = true;
            bVar2.dvv = 0;
            bVar2.iJF = System.currentTimeMillis();
            a(bVar2, false, true);
            esJ.s(bVar2);
            AppMethodBeat.o(137047);
            return true;
        }
        e(str, aHb);
        if (aHb.bee() && !aHb.bec()) {
            a(bVar2, false, true);
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "is pause, do resume");
            aHb.resume();
        } else if (aHb.asa()) {
            a(bVar2, false, true);
            bVar2.iJE = true;
            bVar2.iJF = System.currentTimeMillis();
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "is prepared, do resume");
            aHb.resume();
            bVar2.dvv = 0;
            aHb.g(bVar2);
        } else if (aHb.dFr()) {
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "is preparing, do update param");
            bVar2.iJE = true;
            bVar2.iJF = System.currentTimeMillis();
            aHb.g(bVar2);
        } else if (aHb.iJV) {
            a(bVar2, false, true);
            bVar2.iJE = true;
            bVar2.iJF = System.currentTimeMillis();
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "is paused on background, do resume");
            aHb.s(bVar2);
        } else if (!aHb.bee()) {
            a(bVar2, false, true);
            bVar2.iJE = true;
            bVar2.iJF = System.currentTimeMillis();
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "is stop, do startPlay");
            aHb.s(bVar2);
            bVar2.dvv = 0;
        } else {
            Log.e("MicroMsg.Audio.AudioPlayerMgr", "do nothing");
            AppMethodBeat.o(137047);
            return false;
        }
        AppMethodBeat.o(137047);
        return true;
    }

    public final boolean aGT(String str) {
        AppMethodBeat.i(137048);
        k aHb = aHb(str);
        if (aHb == null) {
            Log.e("MicroMsg.Audio.AudioPlayerMgr", "pauseAudio, player is null");
            if (this.Ahp.gD(str)) {
                this.Ahp.hd(str);
                AppMethodBeat.o(137048);
                return true;
            }
            AppMethodBeat.o(137048);
            return false;
        }
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "pauseAudio, audioId:%s", str);
        aHb.pause();
        b(str, aHb);
        f(str, aHb);
        AppMethodBeat.o(137048);
        return true;
    }

    public final boolean aGU(String str) {
        AppMethodBeat.i(137049);
        k aHb = aHb(str);
        if (aHb == null) {
            Log.e("MicroMsg.Audio.AudioPlayerMgr", "stopAudio, player is null");
            if (this.Ahp.gD(str)) {
                this.Ahp.he(str);
                AppMethodBeat.o(137049);
                return true;
            }
            AppMethodBeat.o(137049);
            return false;
        }
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "stopAudio, audioId:%s", str);
        aHb.stopPlay();
        b bVar = this.AgZ.get(str);
        if (bVar != null) {
            bVar.dvv = 0;
            bVar.iJE = true;
        }
        b(str, aHb);
        f(str, aHb);
        AppMethodBeat.o(137049);
        return true;
    }

    public final boolean aGV(String str) {
        AppMethodBeat.i(137050);
        if (this.Ahp.gD(str)) {
            this.Ahp.he(str);
        }
        k aHb = aHb(str);
        if (aHb == null) {
            Log.e("MicroMsg.Audio.AudioPlayerMgr", "stopPlayOnBackGround, player is null");
            AppMethodBeat.o(137050);
            return false;
        }
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "stopPlayOnBackGround, audioId:%s", str);
        aHb.etl();
        b bVar = this.AgZ.get(str);
        if (bVar != null) {
            bVar.dvv = 0;
            bVar.iJE = true;
        }
        b(str, aHb);
        f(str, aHb);
        AppMethodBeat.o(137050);
        return true;
    }

    public final boolean aGW(String str) {
        boolean contains;
        boolean z;
        boolean z2;
        AppMethodBeat.i(137051);
        synchronized (this.Aht) {
            try {
                contains = this.Aht.contains(str);
            } finally {
                AppMethodBeat.o(137051);
            }
        }
        if (!contains) {
            b bVar = this.AgZ.get(str);
            if (bVar == null || !this.Ahp.ho(bVar.filePath)) {
                z2 = false;
            } else {
                z2 = true;
            }
            z = z2;
        } else {
            z = contains;
        }
        if (!z) {
            if (this.Ahp.gD(str) && (this.Ahp.isPaused(str) || this.Ahp.gO(str) || this.Ahp.hh(str) || this.Ahp.hg(str) || this.Ahp.hf(str))) {
                this.Ahp.he(str);
            }
            this.Ahp.remove(str);
        }
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAudio, audioId:%s", str);
        k aHb = aHb(str);
        if (aHb != null) {
            c(str, aHb);
            synchronized (this.ryf) {
                try {
                    this.AgS.remove(str);
                    this.AgT.remove(str);
                    this.AgU.remove(str);
                    this.AgV.remove(str);
                } catch (Throwable th) {
                    AppMethodBeat.o(137051);
                    throw th;
                }
            }
        } else {
            Log.e("MicroMsg.Audio.AudioPlayerMgr", "destroyAudio, player is null");
        }
        this.AgR.remove(str);
        Iterator<String> it = this.AgW.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            LinkedList<String> linkedList = this.AgY.get(next);
            if (linkedList != null && linkedList.contains(str)) {
                linkedList.remove(str);
                if (linkedList.size() == 0) {
                    this.AgY.remove(next);
                    this.AgW.remove(next);
                    this.AgX.remove(next);
                }
            }
        }
        this.Aha.remove(str);
        if (!z) {
            this.AgZ.remove(str);
        } else if (!this.Ahs.contains(str)) {
            this.Ahs.add(str);
        }
        return true;
    }

    public final boolean eQ(String str, int i2) {
        AppMethodBeat.i(137052);
        k aHb = aHb(str);
        if (aHb == null) {
            Log.e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, player is null");
            if (this.Ahp.gD(str)) {
                this.Ahp.A(str, i2);
            }
            boolean eR = eR(str, i2);
            AppMethodBeat.o(137052);
            return eR;
        } else if (i2 < 0) {
            Log.e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, time pos is invalid time:%d, duration:%d", Integer.valueOf(i2), Integer.valueOf(aHb.getDuration()));
            AppMethodBeat.o(137052);
            return false;
        } else if (aHb.getDuration() <= 0) {
            Log.e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, duration is invalid, time:%d, duration:%d", Integer.valueOf(i2), Integer.valueOf(aHb.getDuration()));
            aHb.etd();
            boolean eR2 = eR(str, i2);
            AppMethodBeat.o(137052);
            return eR2;
        } else if (i2 <= 0 || i2 <= aHb.getDuration()) {
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, audioId:%s, time:%s", str, Integer.valueOf(i2));
            if (aHb.bec() || aHb.bee() || aHb.isPaused()) {
                boolean tG = aHb.tG(i2);
                AppMethodBeat.o(137052);
                return tG;
            }
            aHb.etd();
            boolean eR3 = eR(str, i2);
            AppMethodBeat.o(137052);
            return eR3;
        } else {
            Log.e("MicroMsg.Audio.AudioPlayerMgr", "seekToAudio, time pos is invalid, exceed duration time:%d, duration:%d", Integer.valueOf(i2), Integer.valueOf(aHb.getDuration()));
            AppMethodBeat.o(137052);
            return false;
        }
    }

    private boolean eR(String str, int i2) {
        AppMethodBeat.i(137053);
        b bVar = this.AgZ.get(str);
        if (bVar != null) {
            bVar.dvv = i2;
            AppMethodBeat.o(137053);
            return true;
        }
        AppMethodBeat.o(137053);
        return false;
    }

    public final boolean aGX(String str) {
        AppMethodBeat.i(137054);
        k aHb = aHb(str);
        if (aHb != null) {
            boolean bee = aHb.bee();
            AppMethodBeat.o(137054);
            return bee;
        } else if (this.Ahp.gD(str)) {
            boolean hf = this.Ahp.hf(str);
            AppMethodBeat.o(137054);
            return hf;
        } else {
            Log.e("MicroMsg.Audio.AudioPlayerMgr", "isStartPlayAudio, player is null");
            AppMethodBeat.o(137054);
            return false;
        }
    }

    public final boolean LT(String str) {
        AppMethodBeat.i(137055);
        k aHb = aHb(str);
        if (aHb != null) {
            boolean bec = aHb.bec();
            AppMethodBeat.o(137055);
            return bec;
        } else if (this.Ahp.gD(str)) {
            boolean gO = this.Ahp.gO(str);
            AppMethodBeat.o(137055);
            return gO;
        } else {
            Log.e("MicroMsg.Audio.AudioPlayerMgr", "isPlayingAudio, player is null");
            AppMethodBeat.o(137055);
            return false;
        }
    }

    public final boolean hi(String str) {
        AppMethodBeat.i(137056);
        k aHb = aHb(str);
        if (aHb != null) {
            boolean isStopped = aHb.isStopped();
            AppMethodBeat.o(137056);
            return isStopped;
        } else if (this.Ahp.gD(str)) {
            boolean hi = this.Ahp.hi(str);
            AppMethodBeat.o(137056);
            return hi;
        } else {
            Log.e("MicroMsg.Audio.AudioPlayerMgr", "isStoppedAudio, player is null");
            AppMethodBeat.o(137056);
            return true;
        }
    }

    public final boolean aGY(String str) {
        AppMethodBeat.i(137057);
        k aHb = aHb(str);
        if (aHb != null) {
            boolean z = aHb.iJV;
            AppMethodBeat.o(137057);
            return z;
        } else if (this.Ahp.gD(str)) {
            boolean ZI = this.Ahp.ZI();
            AppMethodBeat.o(137057);
            return ZI;
        } else {
            Log.e("MicroMsg.Audio.AudioPlayerMgr", "isPauseOnBackground, player is null");
            d aGZ = aGZ(str);
            if (aGZ != null) {
                boolean z2 = aGZ.iJV;
                AppMethodBeat.o(137057);
                return z2;
            }
            AppMethodBeat.o(137057);
            return false;
        }
    }

    public final d aGZ(String str) {
        d hk;
        AppMethodBeat.i(137058);
        k aHb = aHb(str);
        if (aHb != null) {
            d eto = aHb.eto();
            AppMethodBeat.o(137058);
            return eto;
        } else if (!this.Ahp.gD(str) || (hk = this.Ahp.hk(str)) == null) {
            d dVar = this.Aha.get(str);
            AppMethodBeat.o(137058);
            return dVar;
        } else {
            AppMethodBeat.o(137058);
            return hk;
        }
    }

    public final int aHa(String str) {
        int size;
        AppMethodBeat.i(137059);
        int esL = esL();
        synchronized (this.ryf) {
            try {
                int size2 = this.AgR.size();
                size = this.AgS.size();
                int size3 = this.AgU.size();
                LinkedList<String> linkedList = this.AgY.get(str);
                Log.i("MicroMsg.Audio.AudioPlayerMgr", "getAudioPlayerCount, count:%d, player_count:%d, recycled_player_count:%d, audioIdsCount:%d, pause_count:%d", Integer.valueOf(size2), Integer.valueOf(size), Integer.valueOf(size3), Integer.valueOf(linkedList == null ? 0 : linkedList.size()), Integer.valueOf(esL));
            } finally {
                AppMethodBeat.o(137059);
            }
        }
        return size;
    }

    public final b LU(String str) {
        AppMethodBeat.i(137060);
        if (this.AgZ.containsKey(str)) {
            b bVar = this.AgZ.get(str);
            AppMethodBeat.o(137060);
            return bVar;
        }
        AppMethodBeat.o(137060);
        return null;
    }

    /* access modifiers changed from: package-private */
    public final k aHb(String str) {
        AppMethodBeat.i(137061);
        if (this.AgS.containsKey(str)) {
            k kVar = this.AgS.get(str);
            AppMethodBeat.o(137061);
            return kVar;
        } else if (this.AgU.containsKey(str)) {
            k kVar2 = this.AgU.get(str);
            AppMethodBeat.o(137061);
            return kVar2;
        } else {
            AppMethodBeat.o(137061);
            return null;
        }
    }

    public final void aHc(String str) {
        AppMethodBeat.i(137062);
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "pauseAllAudioPlayers, appId:%s", str);
        this.Ahp.ZH();
        com.tencent.f.h.RTc.aX(new Runnable() {
            /* class com.tencent.mm.plugin.music.b.h.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(198140);
                h.this.cdV();
                AppMethodBeat.o(198140);
            }
        });
        bLZ();
        LinkedList<String> linkedList = this.AgY.get(str);
        long ZK = this.Ahp.ZK();
        long YM = com.tencent.mm.audio.mix.b.f.YL().YM();
        long YK = e.YJ().YK();
        long j2 = YM + YK;
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "mixAverageTime:%d, loadedCacheBufferSize:%d, remainingBufferSize:%d", Long.valueOf(ZK), Long.valueOf(YM), Long.valueOf(YK));
        this.Ahi = (com.tencent.mm.plugin.music.b.a.d) com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.b.a.d.class);
        if (linkedList == null || linkedList.size() == 0) {
            Log.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to pause");
            AppMethodBeat.o(137062);
        } else if (!this.AgS.isEmpty() || !this.AgU.isEmpty()) {
            LinkedList linkedList2 = new LinkedList();
            synchronized (this.ryf) {
                try {
                    linkedList2.addAll(linkedList);
                } finally {
                    AppMethodBeat.o(137062);
                }
            }
            Iterator it = linkedList2.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                k kVar = this.AgU.get(str2);
                if (kVar != null) {
                    a(str2, kVar);
                }
            }
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "playing player count:%d", Integer.valueOf(this.AgS.size()));
            Iterator it2 = linkedList2.iterator();
            while (it2.hasNext()) {
                String str3 = (String) it2.next();
                k kVar2 = this.AgS.get(str3);
                if (kVar2 != null) {
                    a(str3, kVar2);
                    f(str3, kVar2);
                }
            }
            if (this.Ahi != null) {
                this.Ahi.c(str, ZK, j2, YM);
            }
        } else {
            Log.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to pause");
            if (this.Ahi != null) {
                this.Ahi.c(str, ZK, j2, YM);
            }
            AppMethodBeat.o(137062);
        }
    }

    public final void aHd(String str) {
        AppMethodBeat.i(137063);
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllAudioPlayers, appId:%s", str);
        bLZ();
        aHo(str);
        cdV();
        LinkedList<String> remove = this.AgY.remove(str);
        if (remove == null || remove.size() == 0) {
            Log.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to stop");
            AppMethodBeat.o(137063);
            return;
        }
        synchronized (this.ryf) {
            try {
                Iterator<String> it = remove.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    this.AgT.remove(next);
                    Log.i("MicroMsg.Audio.AudioPlayerMgr", "destroy playing player");
                    c(next, this.AgS.remove(next));
                    this.AgZ.remove(next);
                    this.Aha.remove(next);
                    if (this.Ahp.gD(next)) {
                        this.Ahp.he(next);
                        this.Ahp.remove(next);
                    }
                }
                Iterator<String> it2 = remove.iterator();
                while (it2.hasNext()) {
                    String next2 = it2.next();
                    this.AgV.remove(next2);
                    Log.i("MicroMsg.Audio.AudioPlayerMgr", "destroy recycled player");
                    c(next2, this.AgU.remove(next2));
                    this.AgZ.remove(next2);
                    this.Aha.remove(next2);
                    if (this.Ahp.gD(next2)) {
                        this.Ahp.he(next2);
                        this.Ahp.remove(next2);
                    }
                }
            } catch (Throwable th) {
                AppMethodBeat.o(137063);
                throw th;
            }
        }
        this.AgR.removeAll(remove);
        this.AgW.remove(str);
        this.AgX.remove(str);
        this.Ahp.clearCache();
        this.Ahp.ZJ();
        this.Ahn.clear();
        this.Aho.clear();
        AppMethodBeat.o(137063);
    }

    private void aHe(String str) {
        AppMethodBeat.i(137064);
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllStoppedAudioPlayersAndSaveStateByAppId, appId:%s", str);
        aHo(str);
        cdV();
        LinkedList<String> linkedList = this.AgY.get(str);
        if (linkedList == null || linkedList.size() == 0) {
            Log.e("MicroMsg.Audio.AudioPlayerMgr", "there is no audioIds and players for this appId to stop");
            AppMethodBeat.o(137064);
            return;
        }
        synchronized (this.ryf) {
            try {
                Iterator<String> it = linkedList.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (this.Ahp.gD(next)) {
                        this.Ahp.he(next);
                    }
                    k remove = this.AgU.remove(next);
                    this.AgV.remove(next);
                    if (remove != null) {
                        b(next, remove);
                        Log.i("MicroMsg.Audio.AudioPlayerMgr", "destroy recycled player");
                        if (remove.iJV) {
                            d(next, remove);
                        } else {
                            c(next, remove);
                        }
                    }
                }
            } finally {
                AppMethodBeat.o(137064);
            }
        }
    }

    private void bL(int i2, String str) {
        AppMethodBeat.i(137065);
        Log.e("MicroMsg.Audio.AudioPlayerMgr", "onErrorEvent with errCode:%d, audioId:%s", Integer.valueOf(i2), str);
        if (TextUtils.isEmpty(str)) {
            Log.e("MicroMsg.Audio.AudioPlayerMgr", "audioId is empty");
            str = g.esG();
        }
        y yVar = new y();
        yVar.dCW.action = 4;
        yVar.dCW.state = "error";
        yVar.dCW.errCode = com.tencent.mm.plugin.music.f.a.e.Tc(i2);
        yVar.dCW.errMsg = com.tencent.mm.plugin.music.f.a.e.yw(i2);
        yVar.dCW.dtX = str;
        yVar.dCW.appId = aHf(str);
        EventCenter.instance.asyncPublish(yVar, Looper.getMainLooper());
        AppMethodBeat.o(137065);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006c, code lost:
        if (r6 != false) goto L_0x006e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.tencent.mm.plugin.music.b.k esJ() {
        /*
        // Method dump skipped, instructions count: 249
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.music.b.h.esJ():com.tencent.mm.plugin.music.b.k");
    }

    private String aHf(String str) {
        AppMethodBeat.i(137067);
        Iterator<String> it = this.AgW.iterator();
        while (it.hasNext()) {
            String next = it.next();
            LinkedList<String> linkedList = this.AgY.get(next);
            if (linkedList != null && linkedList.contains(str)) {
                AppMethodBeat.o(137067);
                return next;
            }
        }
        AppMethodBeat.o(137067);
        return "";
    }

    private void a(String str, k kVar) {
        AppMethodBeat.i(137068);
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "pausePlayerOnBackground, pause player on background by audioId:%s", str);
        b bVar = this.AgZ.get(str);
        if (bVar != null && kVar.bec() && kVar.bee()) {
            bVar.iJE = true;
            bVar.dvv = kVar.etn();
        } else if (bVar != null && kVar.bee()) {
            bVar.iJE = true;
            bVar.dvv = kVar.etn();
        } else if (bVar != null) {
            bVar.iJE = true;
            bVar.dvv = 0;
        }
        b(str, kVar);
        d aGZ = aGZ(str);
        if (aGZ != null && kVar.bec()) {
            aGZ.tN = true;
        }
        if (kVar.bec() || kVar.bee() || kVar.dFr() || kVar.asa() || kVar.isPaused()) {
            kVar.etk();
            AppMethodBeat.o(137068);
            return;
        }
        kVar.etj();
        AppMethodBeat.o(137068);
    }

    /* access modifiers changed from: package-private */
    public final void b(String str, k kVar) {
        AppMethodBeat.i(137069);
        this.Aha.put(str, kVar.eto());
        AppMethodBeat.o(137069);
    }

    static void c(String str, k kVar) {
        AppMethodBeat.i(137070);
        if (kVar == null) {
            Log.e("MicroMsg.Audio.AudioPlayerMgr", "destroyPlayer player is null for audioId:%s", str);
            AppMethodBeat.o(137070);
            return;
        }
        if (kVar.bec() || kVar.bee() || kVar.dFr() || kVar.asa() || kVar.isPaused()) {
            kVar.stopPlay();
        }
        kVar.release();
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "destroyPlayer stop and release player by audioId:%s", str);
        AppMethodBeat.o(137070);
    }

    static void d(String str, k kVar) {
        AppMethodBeat.i(137071);
        Log.d("MicroMsg.Audio.AudioPlayerMgr", "releasePlayer");
        c(str, kVar);
        AppMethodBeat.o(137071);
    }

    /* access modifiers changed from: package-private */
    public final void e(String str, k kVar) {
        AppMethodBeat.i(137072);
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "markPlayer, mark player by audioId:%s", str);
        synchronized (this.ryf) {
            try {
                if (this.AgV.contains(str)) {
                    this.AgU.remove(str);
                    this.AgV.remove(str);
                }
                if (!this.AgT.contains(str)) {
                    this.AgT.add(str);
                    this.AgS.put(str, kVar);
                }
            } finally {
                AppMethodBeat.o(137072);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void f(String str, k kVar) {
        AppMethodBeat.i(137073);
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "markPlayerRecycled, mark player recycled by audioId:%s", str);
        synchronized (this.ryf) {
            try {
                if (this.AgT.contains(str)) {
                    this.AgS.remove(str);
                    this.AgT.remove(str);
                }
                if (!this.AgV.contains(str)) {
                    this.AgV.add(str);
                    this.AgU.put(str, kVar);
                }
            } finally {
                AppMethodBeat.o(137073);
            }
        }
    }

    private boolean aHg(String str) {
        AppMethodBeat.i(137074);
        k aHb = aHb(str);
        if (aHb == null) {
            AppMethodBeat.o(137074);
            return false;
        }
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAndRemovePlayer, audioId:%s", str);
        c(str, aHb);
        synchronized (this.ryf) {
            try {
                this.AgS.remove(str);
                this.AgT.remove(str);
                this.AgU.remove(str);
                this.AgV.remove(str);
            } finally {
                AppMethodBeat.o(137074);
            }
        }
        return true;
    }

    private static boolean a(k kVar) {
        boolean z;
        AppMethodBeat.i(137075);
        if (kVar == null) {
            AppMethodBeat.o(137075);
            return true;
        }
        if (kVar.bec() || kVar.isPaused() || kVar.dFr() || kVar.asa() || kVar.bee()) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            AppMethodBeat.o(137075);
            return true;
        }
        AppMethodBeat.o(137075);
        return false;
    }

    public final void esK() {
        AppMethodBeat.i(137076);
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.Ahe || currentTimeMillis - this.Ahg >= 10000) {
            this.Ahg = currentTimeMillis;
            synchronized (this.ryf) {
                try {
                    this.Ahe = true;
                } catch (Throwable th) {
                    AppMethodBeat.o(137076);
                    throw th;
                }
            }
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "releaseAudioDelayIfPaused, delay_ms:%d", 1800000);
            MMHandlerThread.removeRunnable(this.Ahy);
            MMHandlerThread.postToMainThreadDelayed(this.Ahy, 1800000);
            AppMethodBeat.o(137076);
            return;
        }
        AppMethodBeat.o(137076);
    }

    private int esL() {
        int i2;
        boolean isPaused;
        int i3;
        AppMethodBeat.i(137077);
        synchronized (this.ryf) {
            try {
                Iterator<String> it = this.AgV.iterator();
                i2 = 0;
                while (it.hasNext()) {
                    String next = it.next();
                    k aHb = aHb(next);
                    if (aHb == null) {
                        Log.e("MicroMsg.Audio.AudioPlayerMgr", "isPausedPlayer, player is null");
                        d aGZ = aGZ(next);
                        if (aGZ != null) {
                            isPaused = aGZ.tN;
                        } else {
                            isPaused = false;
                        }
                    } else {
                        isPaused = aHb.isPaused();
                    }
                    if (isPaused) {
                        i3 = i2 + 1;
                    } else {
                        i3 = i2;
                    }
                    i2 = i3;
                }
            } finally {
                AppMethodBeat.o(137077);
            }
        }
        return i2;
    }

    private void aHh(String str) {
        AppMethodBeat.i(137078);
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "recyclePlayer");
        int size = this.AgS.size();
        int size2 = this.AgU.size();
        int esL = esL();
        if (size > 0 || size2 > 0 || esL > 0) {
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "start_player_count:%d, recycled_player_count:%d, paused_player_count:%d", Integer.valueOf(size), Integer.valueOf(size2), Integer.valueOf(esL));
        }
        if (size >= 10) {
            esM();
        } else if (esL >= 6) {
            esM();
        } else if (size + esL >= 8) {
            esM();
        }
        String aHf = aHf(str);
        int size3 = this.AgS.size();
        int size4 = this.AgU.size();
        if (size3 > 0 || size4 > 0) {
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "start_player_count:%d, recycled_player_count:%d", Integer.valueOf(size3), Integer.valueOf(size4));
        }
        if (size4 >= 50) {
            Iterator<String> it = this.AgW.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next != null && !next.equalsIgnoreCase(aHf)) {
                    aHi(next);
                }
            }
        } else if (size4 + size3 >= 50) {
            Iterator<String> it2 = this.AgW.iterator();
            while (it2.hasNext()) {
                String next2 = it2.next();
                if (next2 != null && !next2.equalsIgnoreCase(aHf)) {
                    aHi(next2);
                }
            }
        } else {
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "condition is not satisfy to do recycleStopPlayerByAppId");
        }
        int size5 = this.AgU.size();
        if (size3 > 0 || size5 > 0) {
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "start_player_count:%d, recycled_player_count:%d", Integer.valueOf(size3), Integer.valueOf(size5));
        }
        if (size5 >= 50) {
            esN();
            AppMethodBeat.o(137078);
        } else if (size5 + size3 >= 50) {
            esN();
            AppMethodBeat.o(137078);
        } else {
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "condition is not satisfy to do recycleAllStopPlayer");
            AppMethodBeat.o(137078);
        }
    }

    private void esM() {
        AppMethodBeat.i(137079);
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "recyclePausedPlayer");
        synchronized (this.ryf) {
            try {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(this.AgV);
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    k kVar = this.AgU.get(str);
                    if (kVar != null && kVar.isPaused()) {
                        a(str, kVar);
                    }
                }
            } finally {
                AppMethodBeat.o(137079);
            }
        }
    }

    private void esN() {
        AppMethodBeat.i(137080);
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "recycleStopPlayer");
        synchronized (this.ryf) {
            try {
                LinkedList linkedList = new LinkedList();
                linkedList.addAll(this.AgV);
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    k remove = this.AgU.remove(str);
                    this.AgV.remove(str);
                    if (remove != null) {
                        if (remove.iJV) {
                            b(str, remove);
                            d(str, remove);
                        } else if (!remove.isPaused()) {
                            b(str, remove);
                            c(str, remove);
                        }
                    }
                }
            } finally {
                AppMethodBeat.o(137080);
            }
        }
    }

    private void aHi(String str) {
        AppMethodBeat.i(137081);
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "recycleStoppedPlayerByAppId");
        aHe(str);
        AppMethodBeat.o(137081);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v19, resolved type: java.util.LinkedList<java.lang.String> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:100:?, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00d9, code lost:
        r4 = "";
        r6 = com.tencent.mm.plugin.music.cache.g.etE();
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.Audio.AudioPlayerMgr", "removePlayerGroupMinCount:%d", java.lang.Integer.valueOf(r6));
        r10 = r3.iterator();
        r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00fc, code lost:
        if (r10.hasNext() == false) goto L_0x0133;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00fe, code lost:
        r1 = (java.lang.String) r10.next();
        r2 = ((java.lang.Integer) r7.get(r1)).intValue();
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.Audio.AudioPlayerMgr", "count:%d, url:%s", java.lang.Integer.valueOf(r2), r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0124, code lost:
        if (r2 < r6) goto L_0x0258;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0126, code lost:
        r5 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0127, code lost:
        if (r3 >= r2) goto L_0x0255;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0129, code lost:
        r4 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x012e, code lost:
        if (android.text.TextUtils.isEmpty(r4) == false) goto L_0x0131;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0130, code lost:
        r4 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0131, code lost:
        r3 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0133, code lost:
        if (r5 == false) goto L_0x0252;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0135, code lost:
        r1 = r16.AgZ.get(r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0141, code lost:
        if (r1 == null) goto L_0x0252;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0143, code lost:
        if (r4 == null) goto L_0x0252;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x014b, code lost:
        if (r4.equalsIgnoreCase(r1.dvn) == false) goto L_0x0252;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x014d, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.Audio.AudioPlayerMgr", "srcUrl is same, not remove and don't play again");
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0158, code lost:
        if (r2 == false) goto L_0x0241;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x015a, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.Audio.AudioPlayerMgr", "need to remove player");
        r1 = (java.util.ArrayList) r8.get(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0169, code lost:
        if (r1 == null) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x016f, code lost:
        if (r1.size() <= 0) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0171, code lost:
        r3 = new java.util.LinkedList();
        r4 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x017e, code lost:
        if (r4.hasNext() == false) goto L_0x0196;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0180, code lost:
        r1 = r16.AgZ.get((java.lang.String) r4.next());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0190, code lost:
        if (r1 == null) goto L_0x017a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0192, code lost:
        r3.add(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0196, code lost:
        java.util.Collections.sort(r3, new com.tencent.mm.plugin.music.b.h.a(r16));
        r4 = new java.util.LinkedList();
        r3 = r3.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01ad, code lost:
        if (r3.hasNext() == false) goto L_0x01bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01af, code lost:
        r4.add(((com.tencent.mm.ai.b) r3.next()).dtX);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01bb, code lost:
        r1 = r9 - 10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01bd, code lost:
        if (r1 <= 0) goto L_0x0216;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01c3, code lost:
        if (r4.size() <= r1) goto L_0x0216;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01c5, code lost:
        r1 = r1 + 1;
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.Audio.AudioPlayerMgr", "removeCount should be %d", java.lang.Integer.valueOf(r1));
        r1 = r4.size() - r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01e0, code lost:
        if (r1 >= 0) goto L_0x01e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01e2, code lost:
        r1 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01e3, code lost:
        r16.Ahb.addAll(r4.subList(r1, r4.size()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01f2, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player count : %d", java.lang.Integer.valueOf(r16.Ahb.size()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x020d, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(137082);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0216, code lost:
        if (r1 <= 0) goto L_0x022f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x021c, code lost:
        if (r4.size() >= r1) goto L_0x022f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x021e, code lost:
        r16.Ahb.addAll(r4.subList(1, r4.size()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x022f, code lost:
        r16.Ahb.add(r4.get(r4.size() - 1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0241, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.Audio.AudioPlayerMgr", "not need to remove player");
        r16.Ahb.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0252, code lost:
        r2 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0255, code lost:
        r2 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0258, code lost:
        r2 = r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean aHj(java.lang.String r17) {
        /*
        // Method dump skipped, instructions count: 603
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.music.b.h.aHj(java.lang.String):boolean");
    }

    /* access modifiers changed from: package-private */
    public final void esO() {
        AppMethodBeat.i(137083);
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "removeAndStopPlayingAudioPlayer");
        Iterator<String> it = this.Ahb.iterator();
        while (it.hasNext()) {
            String next = it.next();
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player audioId : %s", next);
            aGU(next);
            esQ();
        }
        Iterator<String> it2 = this.Ahd.iterator();
        while (it2.hasNext()) {
            String next2 = it2.next();
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player for try audioId : %s", next2);
            aGU(next2);
            esQ();
        }
        this.Ahb.clear();
        this.Ahd.clear();
        AppMethodBeat.o(137083);
    }

    public final void aHk(String str) {
        AppMethodBeat.i(137084);
        if (this.AgW.size() == 0) {
            AppMethodBeat.o(137084);
            return;
        }
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "destroyAllAudioPlayersByProcessName with name :%s", str);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.AgW);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            String str3 = this.AgX.get(str2);
            if (str != null && str.equalsIgnoreCase(str3)) {
                Log.i("MicroMsg.Audio.AudioPlayerMgr", "The app brand process name is same as the process which is killed by system");
                aHd(str2);
            }
        }
        AppMethodBeat.o(137084);
    }

    public class a implements Comparator<b> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(b bVar, b bVar2) {
            b bVar3 = bVar;
            b bVar4 = bVar2;
            if (bVar3.iJF > bVar4.iJF) {
                return 1;
            }
            if (bVar3.iJF < bVar4.iJF) {
                return -1;
            }
            return 0;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v20, resolved type: java.util.LinkedList<java.lang.String> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00d2, code lost:
        r0 = r13.AgZ.get(r14);
        r2 = r5.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00e2, code lost:
        if (r2.hasNext() == false) goto L_0x0108;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00e4, code lost:
        r1 = (java.lang.String) r2.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00ea, code lost:
        if (r0 == null) goto L_0x00de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ec, code lost:
        if (r1 == null) goto L_0x00de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00f4, code lost:
        if (r1.equalsIgnoreCase(r0.dvn) == false) goto L_0x00de;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00f6, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.Audio.AudioPlayerMgr", "srcUrl is same, not remove and don't play again for try");
        com.tencent.matrix.trace.core.AppMethodBeat.o(137085);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0108, code lost:
        r3 = "";
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.Audio.AudioPlayerMgr", "removePlayerGroupMinCountForTry:%d", 2);
        r2 = 2;
        r5 = r5.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0128, code lost:
        if (r5.hasNext() == false) goto L_0x0160;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x012a, code lost:
        r0 = (java.lang.String) r5.next();
        r1 = ((java.lang.Integer) r6.get(r0)).intValue();
        com.tencent.mm.sdk.platformtools.Log.d("MicroMsg.Audio.AudioPlayerMgr", "count:%d, url:%s", java.lang.Integer.valueOf(r1), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0151, code lost:
        if (r1 < 2) goto L_0x01f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0153, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0154, code lost:
        if (r2 >= r1) goto L_0x01f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0156, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x015b, code lost:
        if (android.text.TextUtils.isEmpty(r3) == false) goto L_0x015e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x015d, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x015e, code lost:
        r2 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0160, code lost:
        if (r4 == false) goto L_0x01e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0162, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.Audio.AudioPlayerMgr", "need to remove player");
        r0 = (java.util.ArrayList) r7.get(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0171, code lost:
        if (r0 == null) goto L_0x01e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0177, code lost:
        if (r0.size() <= 0) goto L_0x01e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0179, code lost:
        r1 = new java.util.LinkedList();
        r2 = r0.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0186, code lost:
        if (r2.hasNext() == false) goto L_0x019c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0188, code lost:
        r0 = r13.AgZ.get((java.lang.String) r2.next());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0196, code lost:
        if (r0 == null) goto L_0x0182;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0198, code lost:
        r1.add(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x019c, code lost:
        java.util.Collections.sort(r1, new com.tencent.mm.plugin.music.b.h.a(r13));
        r2 = new java.util.LinkedList();
        r1 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01b1, code lost:
        if (r1.hasNext() == false) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01b3, code lost:
        r2.add(((com.tencent.mm.ai.b) r1.next()).dtX);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01bf, code lost:
        r13.Ahd.add(r2.getLast());
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.Audio.AudioPlayerMgr", "need remove and stop player count for try: %d", java.lang.Integer.valueOf(r13.Ahd.size()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01e1, code lost:
        com.tencent.matrix.trace.core.AppMethodBeat.o(137085);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01e9, code lost:
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.Audio.AudioPlayerMgr", "not need to remove player for try");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01f3, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01f6, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:?, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:?, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean aHl(java.lang.String r14) {
        /*
        // Method dump skipped, instructions count: 505
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.music.b.h.aHl(java.lang.String):boolean");
    }

    private void esP() {
        AppMethodBeat.i(137086);
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "mixWithOther:%b, focus:%b", Boolean.valueOf(this.dCU.iJC), Boolean.valueOf(this.Ahj.Aiz));
        if (this.dCU.iJC || this.Ahj.Aiz) {
            if (this.dCU.iJC && this.Ahj.Aiz) {
                Log.i("MicroMsg.Audio.AudioPlayerMgr", "abandonFocus()");
                bLZ();
            }
            AppMethodBeat.o(137086);
            return;
        }
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "requestFocus()");
        requestFocus();
        AppMethodBeat.o(137086);
    }

    private void esQ() {
        AppMethodBeat.i(137089);
        this.Ahi = (com.tencent.mm.plugin.music.b.a.d) com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.b.a.d.class);
        if (this.Ahi != null) {
            this.Ahi.etr();
        }
        AppMethodBeat.o(137089);
    }

    private void n(b bVar) {
        AppMethodBeat.i(137090);
        this.Ahi = (com.tencent.mm.plugin.music.b.a.d) com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.b.a.d.class);
        if (this.Ahi != null) {
            this.Ahi.iT(bVar.dtX, bVar.dvn);
        }
        AppMethodBeat.o(137090);
    }

    private void a(b bVar, boolean z, boolean z2) {
        long j2;
        AppMethodBeat.i(137091);
        this.Ahi = (com.tencent.mm.plugin.music.b.a.d) com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.b.a.d.class);
        if (this.Ahi != null) {
            this.Ahi.t(bVar.dtX, bVar.dvn, z2);
        }
        long currentTimeMillis = System.currentTimeMillis();
        bVar.iJI = currentTimeMillis;
        if (z) {
            j2 = bVar.iJM;
            bVar.iJJ = bVar.iJL;
        } else {
            j2 = bVar.iJO;
            bVar.iJJ = bVar.iJN;
        }
        if (j2 <= 0 || currentTimeMillis <= j2) {
            bVar.iJK = 0;
            AppMethodBeat.o(137091);
            return;
        }
        bVar.iJK = currentTimeMillis - j2;
        AppMethodBeat.o(137091);
    }

    /* access modifiers changed from: package-private */
    public final void aHm(String str) {
        AppMethodBeat.i(198163);
        b bVar = this.AgZ.get(str);
        if (bVar == null || TextUtils.isEmpty(bVar.dvn)) {
            AppMethodBeat.o(198163);
        } else if (!bVar.dvn.startsWith(HttpWrapperBase.PROTOCAL_HTTP) && !bVar.dvn.startsWith(HttpWrapperBase.PROTOCAL_HTTPS)) {
            AppMethodBeat.o(198163);
        } else if (!i.aHI(bVar.dvn)) {
            AppMethodBeat.o(198163);
        } else {
            bVar.filePath = com.tencent.mm.plugin.music.h.b.aIe(bVar.dvn);
            if (!this.Ahn.containsKey(bVar.dvn)) {
                this.Ahn.put(bVar.dvn, bVar.filePath);
            }
            AppMethodBeat.o(198163);
        }
    }

    public final void aHn(final String str) {
        AppMethodBeat.i(137092);
        if (!esF()) {
            AppMethodBeat.o(137092);
            return;
        }
        b bVar = this.AgZ.get(str);
        if (bVar == null || TextUtils.isEmpty(bVar.filePath) || !this.Ahp.hn(bVar.filePath)) {
            synchronized (this.Aht) {
                try {
                    if (!this.Aht.contains(str)) {
                        this.Aht.add(str);
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(137092);
                    throw th;
                }
            }
            if (this.Jap == null || Looper.myQueue() == null) {
                Log.i("MicroMsg.Audio.AudioPlayerMgr", "Looper.myQueue() is null!");
                AppMethodBeat.o(137092);
                return;
            }
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
                /* class com.tencent.mm.plugin.music.b.h.AnonymousClass5 */

                public final boolean queueIdle() {
                    boolean z;
                    boolean z2;
                    AppMethodBeat.i(198147);
                    b bVar = h.this.AgZ.get(str);
                    if (bVar == null) {
                        Log.i("MicroMsg.Audio.AudioPlayerMgr", "preloadMixCache param is null, audioId:%s", str);
                        synchronized (h.this.Aht) {
                            try {
                                h.this.Aht.remove(str);
                            } catch (Throwable th) {
                                AppMethodBeat.o(198147);
                                throw th;
                            }
                        }
                        h.a(h.this, str);
                        AppMethodBeat.o(198147);
                        return false;
                    }
                    if (!TextUtils.isEmpty(bVar.filePath) && !h.this.Ahp.hn(bVar.filePath)) {
                        long hv = com.tencent.mm.audio.mix.i.a.hv(bVar.filePath);
                        if (h.r(bVar)) {
                            hv = (long) bVar.iJU.limit();
                        }
                        Log.i("MicroMsg.Audio.AudioPlayerMgr", "preloadMixCache preload filePath:%s, fileSize:%d, preloadMixCacheCount:%d", bVar.filePath, Long.valueOf(hv), Long.valueOf(h.this.Ahr));
                        long YM = com.tencent.mm.audio.mix.b.f.YL().YM();
                        c cVar = h.this.Ahp;
                        long YM2 = com.tencent.mm.audio.mix.b.f.YL().YM();
                        com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixPlayer", "cacheInMemoryTotalSize:%d, appId:%s", Long.valueOf(YM2), cVar.appId);
                        if (YM2 >= 50000000) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioMixPlayer", "isLoadedCacheExceedMaxMemory, exceed max cache 50M!, appId:%s", cVar.appId);
                        }
                        int i2 = 0;
                        if (h.this.Aho.containsKey(bVar.filePath)) {
                            i2 = h.this.Aho.get(bVar.filePath).intValue();
                        }
                        if (z2) {
                            Log.e("MicroMsg.Audio.AudioPlayerMgr", "loaded cache is exceed Max Memory 50M, don't load more audio into memory!");
                            if (h.this.Ahi != null) {
                                h.this.Ahi.SA(713);
                            }
                            h.this.Ahp.hl("");
                            z = false;
                        } else if (YM + hv > 50000000) {
                            Log.e("MicroMsg.Audio.AudioPlayerMgr", "loaded cache and loading fileSize is exceed Max Memory 50M, don't load more audio into memory!  loadCacheBufferSize:%d, fileSize:%d", Long.valueOf(YM), Long.valueOf(hv));
                            if (h.this.Ahi != null) {
                                h.this.Ahi.SA(com.tencent.mm.plugin.appbrand.jsapi.pay.g.CTRL_INDEX);
                            }
                            h.this.Ahp.hl("");
                            z = false;
                        } else if (i2 >= 30) {
                            Log.e("MicroMsg.Audio.AudioPlayerMgr", "load audio fail number exceed MAX_LOAD_FAIL_COUNT, don't load again!");
                            z = false;
                        } else if (!com.tencent.mm.audio.mix.i.a.hu(bVar.filePath) && !h.r(bVar)) {
                            Log.e("MicroMsg.Audio.AudioPlayerMgr", "don't support load large file and invalid file");
                            z = false;
                        } else if (h.r(bVar) && com.tencent.mm.audio.mix.i.a.bu((long) bVar.iJU.limit())) {
                            Log.e("MicroMsg.Audio.AudioPlayerMgr", "don't support load pByteBuff large file");
                            z = false;
                        } else if (!h.this.Ahp.ho(bVar.filePath)) {
                            bVar.iJT = true;
                            bVar.fileSize = hv;
                            h.this.Ahp.f(bVar);
                            h.this.Ahr++;
                            z = true;
                        } else {
                            Log.i("MicroMsg.Audio.AudioPlayerMgr", "mix audio cache is loading");
                            z = false;
                        }
                    } else if (!TextUtils.isEmpty(bVar.filePath)) {
                        bVar.iJT = false;
                        if (!h.this.Ahp.gD(str)) {
                            h.this.Ahp.g(bVar);
                        }
                        if (h.r(bVar)) {
                            bVar.fileSize = (long) bVar.iJU.limit();
                            z = false;
                        } else {
                            bVar.fileSize = com.tencent.mm.audio.mix.i.a.hv(bVar.filePath);
                            z = false;
                        }
                    } else {
                        bVar.iJT = false;
                        z = false;
                    }
                    synchronized (h.this.Aht) {
                        try {
                            h.this.Aht.remove(str);
                        } catch (Throwable th2) {
                            AppMethodBeat.o(198147);
                            throw th2;
                        }
                    }
                    if (!z) {
                        h.a(h.this, str);
                    }
                    AppMethodBeat.o(198147);
                    return false;
                }
            });
            AppMethodBeat.o(137092);
            return;
        }
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "preloadMixCache cache done!");
        AppMethodBeat.o(137092);
    }

    private static void o(b bVar) {
        AppMethodBeat.i(137093);
        if (bVar.iJR != null) {
            try {
                bVar.iJR.close();
                bVar.iJR = null;
                AppMethodBeat.o(137093);
                return;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Audio.AudioPlayerMgr", e2, "closeAudioDataSource", new Object[0]);
            }
        }
        AppMethodBeat.o(137093);
    }

    private boolean esF() {
        AppMethodBeat.i(198164);
        if (!d.esF() || !esR()) {
            AppMethodBeat.o(198164);
            return false;
        }
        AppMethodBeat.o(198164);
        return true;
    }

    private boolean esR() {
        return this.dCU.dtE || this.dCU.iJC;
    }

    private void aHo(String str) {
        AppMethodBeat.i(198165);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.dCU.appId) && !str.equalsIgnoreCase(this.dCU.appId)) {
            this.dCU.reset();
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "reset AudioContextParam, appId:%s", str);
        }
        this.dCU.appId = str;
        this.qUm = this.dCU.dtE;
        AppMethodBeat.o(198165);
    }

    private void esS() {
        AppMethodBeat.i(198166);
        if (this.dCU.iJC && !this.Ahq) {
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "mixWithOther is true, useSpeakerOn is false, return");
            cdV();
            AppMethodBeat.o(198166);
        } else if (this.dCU.iJC) {
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "mixWithOther is true, return");
            AppMethodBeat.o(198166);
        } else if (this.qUm && this.mAudioManager.getMode() != 0) {
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "speaker is on and reset speaker");
            cdV();
            AppMethodBeat.o(198166);
        } else if (this.qUm) {
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "speaker is on, do nothing");
            AppMethodBeat.o(198166);
        } else if (PhoneStatusWatcher.isCalling()) {
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "shiftSpeaker return when phone calling");
            AppMethodBeat.o(198166);
        } else if (this.mAudioManager.isBluetoothScoOn() || this.mAudioManager.isBluetoothA2dpOn()) {
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "shiftSpeaker return when isBluetoothScoOn:%b , isBluetoothA2dpOn:%b", Boolean.valueOf(this.mAudioManager.isBluetoothScoOn()), Boolean.valueOf(this.mAudioManager.isBluetoothA2dpOn()));
            AppMethodBeat.o(198166);
        } else if (this.mAudioManager.isWiredHeadsetOn()) {
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "shiftSpeaker return when wired headset on");
            AppMethodBeat.o(198166);
        } else if (this.Ahq || this.mAudioManager.getMode() != 3 || this.mAudioManager.isSpeakerphoneOn()) {
            this.Ahq = false;
            this.mAudioManager.setSpeakerphoneOn(false);
            this.mAudioManager.setMode(3);
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "set speaker off and change mode to MODE_IN_COMMUNICATION");
            AppMethodBeat.o(198166);
        } else {
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "shiftSpeaker return when wired headset on");
            AppMethodBeat.o(198166);
        }
    }

    public final void cdV() {
        AppMethodBeat.i(198167);
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "resetSpeaker");
        if (!this.Ahq && this.mAudioManager.getMode() == 3) {
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "set speaker on and reset mode to MODE_NORMAL");
            this.mAudioManager.setSpeakerphoneOn(true);
            this.mAudioManager.setMode(0);
        } else if (!this.Ahq) {
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "set speaker on");
            this.mAudioManager.setSpeakerphoneOn(true);
        }
        this.Ahq = true;
        AppMethodBeat.o(198167);
    }

    public final int getStreamType() {
        if (this.qUm || this.dCU.iJC || this.Ahq) {
            return 3;
        }
        return 0;
    }

    private void p(b bVar) {
        boolean z;
        AppMethodBeat.i(198168);
        if (bVar == null) {
            AppMethodBeat.o(198168);
        } else if (TextUtils.isEmpty(bVar.dvn)) {
            AppMethodBeat.o(198168);
        } else if (!bVar.dvn.startsWith("http")) {
            AppMethodBeat.o(198168);
        } else {
            if (TextUtils.isEmpty(bVar.filePath) || !this.Ahp.hn(bVar.filePath)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                AppMethodBeat.o(198168);
                return;
            }
            if (this.mHandler == null) {
                this.mHandler = new Handler(Looper.myLooper());
            }
            com.tencent.mm.plugin.music.cache.g.aHx(bVar.dvn);
            boolean aHI = i.aHI(bVar.dvn);
            Log.i("MicroMsg.Audio.AudioPlayerMgr", "checkNeedDownloadSrc audioId:%s, cacheValid:%b, checkCount:%d", bVar.dtX, Boolean.valueOf(aHI), Integer.valueOf(this.AhC));
            this.AhC++;
            if (!aHI) {
                this.Ahu.a(bVar);
                AppMethodBeat.o(198168);
                return;
            }
            aHm(bVar.dtX);
            q(bVar);
            aHn(bVar.dtX);
            AppMethodBeat.o(198168);
        }
    }

    /* access modifiers changed from: package-private */
    public final void q(b bVar) {
        AppMethodBeat.i(198169);
        if (TextUtils.isEmpty(bVar.filePath) && this.Ahn.containsKey(bVar.dvn)) {
            bVar.filePath = this.Ahn.get(bVar.dvn);
        }
        AppMethodBeat.o(198169);
    }

    static boolean r(b bVar) {
        AppMethodBeat.i(198170);
        if (bVar == null || !bVar.dvn.startsWith("wxblob://") || bVar.iJU == null) {
            AppMethodBeat.o(198170);
            return false;
        }
        AppMethodBeat.o(198170);
        return true;
    }

    private synchronized void esT() {
        AppMethodBeat.i(198171);
        if (this.Ahk != null) {
            this.Ahk.end();
            this.Ahk.clearPhoneCallListener();
            this.Ahk = null;
        }
        this.Ahl = false;
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "removePhoneStatusWatcher");
        AppMethodBeat.o(198171);
    }

    private void requestFocus() {
        AppMethodBeat.i(137087);
        if (this.Ahj.Aiz) {
            AppMethodBeat.o(137087);
            return;
        }
        Log.i("MicroMsg.Audio.AudioPlayerMgr", "requestFocus focus:%b", Boolean.valueOf(this.Ahj.requestFocus()));
        AppMethodBeat.o(137087);
    }

    /* access modifiers changed from: package-private */
    public final void bLZ() {
        AppMethodBeat.i(137088);
        if (this.Ahj.Aiz) {
            this.Ahj.bLZ();
        }
        AppMethodBeat.o(137088);
    }

    static /* synthetic */ void a(h hVar) {
        AppMethodBeat.i(137094);
        if (hVar.esL() > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!hVar.Ahf || currentTimeMillis - hVar.Ahh >= 10000) {
                synchronized (hVar.ryf) {
                    try {
                        hVar.Ahf = true;
                    } catch (Throwable th) {
                        AppMethodBeat.o(137094);
                        throw th;
                    }
                }
                hVar.Ahh = currentTimeMillis;
                Log.i("MicroMsg.Audio.AudioPlayerMgr", "stopAudioDelayIfPaused, delay_ms:%d", 600000);
                MMHandlerThread.removeRunnable(hVar.Ahx);
                MMHandlerThread.postToMainThreadDelayed(hVar.Ahx, 600000);
                AppMethodBeat.o(137094);
            }
        } else {
            synchronized (hVar.ryf) {
                try {
                    hVar.Ahf = false;
                } finally {
                    AppMethodBeat.o(137094);
                }
            }
            MMHandlerThread.removeRunnable(hVar.Ahx);
        }
    }

    static /* synthetic */ void a(h hVar, String str) {
        AppMethodBeat.i(198172);
        if (hVar.Ahs.remove(str)) {
            hVar.AgZ.remove(str);
        }
        AppMethodBeat.o(198172);
    }
}
