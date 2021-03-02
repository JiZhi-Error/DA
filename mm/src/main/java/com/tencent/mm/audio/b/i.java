package com.tencent.mm.audio.b;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.cj.a;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoice.e;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.thumbplayer.api.TPOptionalID;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class i implements com.tencent.mm.ak.i {
    public static boolean dAH = true;
    Queue<String> dAA = new LinkedList();
    Queue<r> dAB = new LinkedList();
    Map<String, f.a> dAC = new HashMap();
    private boolean dAD = false;
    private boolean dAE = false;
    public int dAF = 0;
    private long dAG = 0;
    f.a dAI = new f.a();
    private MTimerHandler dAJ = new MTimerHandler(g.aAk().getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.audio.b.i.AnonymousClass3 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(148356);
            Log.i("MicroMsg.SceneVoiceService", "onTimerExpired[%s]", i.this.toString());
            i.h(i.this);
            AppMethodBeat.o(148356);
            return false;
        }

        public final String toString() {
            AppMethodBeat.i(148357);
            String str = super.toString() + "|scenePusher";
            AppMethodBeat.o(148357);
            return str;
        }
    }, false);
    private boolean running = false;

    static /* synthetic */ int c(i iVar) {
        int i2 = iVar.dAF;
        iVar.dAF = i2 - 1;
        return i2;
    }

    static /* synthetic */ void i(i iVar) {
        AppMethodBeat.i(148363);
        iVar.aax();
        AppMethodBeat.o(148363);
    }

    public i() {
        AppMethodBeat.i(148358);
        Log.i("MicroMsg.SceneVoiceService", "SceneVoiceService %s", Util.getStack().toString());
        g.azz().a(TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH, this);
        g.azz().a(128, this);
        AppMethodBeat.o(148358);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        private static final i dAN = new i();

        static {
            AppMethodBeat.i(187327);
            AppMethodBeat.o(187327);
        }
    }

    public static final i aaw() {
        AppMethodBeat.i(187328);
        i iVar = a.dAN;
        AppMethodBeat.o(187328);
        return iVar;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(final int i2, final int i3, String str, final q qVar) {
        AppMethodBeat.i(148359);
        Object[] objArr = new Object[5];
        objArr[0] = toString();
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(i3);
        objArr[3] = Util.nullAs(str, "");
        objArr[4] = qVar != null ? qVar.toString() : 0;
        Log.i("MicroMsg.SceneVoiceService", "[%s]errType:%s errCode:%s errMsg:%s scene:%s", objArr);
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.audio.b.i.AnonymousClass1 */

            public final void run() {
                String str;
                int i2;
                AppMethodBeat.i(148352);
                if (qVar.getType() == 128) {
                    i.this.dAD = false;
                    str = ((e) qVar).fileName;
                    i2 = ((e) qVar).retCode;
                } else if (qVar.getType() == 127) {
                    i.this.dAE = false;
                    str = ((com.tencent.mm.modelvoice.f) qVar).fileName;
                    i2 = ((com.tencent.mm.modelvoice.f) qVar).retCode;
                } else {
                    Log.e("MicroMsg.SceneVoiceService", "onSceneEnd Error SceneType:" + qVar.getType());
                    AppMethodBeat.o(148352);
                    return;
                }
                r Ro = s.Ro(str);
                if (qVar.getType() == 128 && Ro != null && Ro.bih() && Ro.status != 98) {
                    s.QE(str);
                    Log.w("MicroMsg.SceneVoiceService", "re-download set error");
                }
                long j2 = 0;
                if (!(str == null || i.this.dAC.get(str) == null)) {
                    j2 = i.this.dAC.get(str).apr();
                    i.this.dAC.remove(str);
                }
                Log.i("MicroMsg.SceneVoiceService", "onSceneEnd SceneType:" + qVar.getType() + " errtype:" + i2 + " errCode:" + i3 + " retCode:" + i2 + " file:" + str + " time:" + j2);
                if (i2 == 3 && i2 != 0) {
                    i.c(i.this);
                } else if (i2 != 0) {
                    i.this.dAF = 0;
                }
                Log.i("MicroMsg.SceneVoiceService", "onSceneEnd stop:" + i.this.dAF + " running:" + i.this.running + " recving:" + i.this.dAD + " sending:" + i.this.dAE);
                if (i.this.dAF > 0) {
                    i.h(i.this);
                    AppMethodBeat.o(148352);
                    return;
                }
                if (!i.this.dAE && !i.this.dAD) {
                    i.i(i.this);
                    Log.i("MicroMsg.SceneVoiceService", "onSceneEnd fin and try next delay 3s [%d, %d] [%b]", Integer.valueOf(i2), Integer.valueOf(i2), Boolean.valueOf(i.dAH));
                    if (i.dAH && i2 == 4) {
                        g.aAk().postToWorkerDelayed(new Runnable() {
                            /* class com.tencent.mm.audio.b.i.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(148351);
                                Log.i("MicroMsg.SceneVoiceService", "onSceneEnd fin and try run");
                                i.this.run();
                                AppMethodBeat.o(148351);
                            }
                        }, 10000);
                    }
                }
                AppMethodBeat.o(148352);
            }

            public final String toString() {
                AppMethodBeat.i(148353);
                String str = super.toString() + "|onSceneEnd";
                AppMethodBeat.o(148353);
                return str;
            }
        });
        AppMethodBeat.o(148359);
    }

    private void aax() {
        AppMethodBeat.i(148360);
        this.dAC.clear();
        this.dAA.clear();
        this.dAB.clear();
        this.dAE = false;
        this.dAD = false;
        this.running = false;
        Log.i("MicroMsg.SceneVoiceService", "Finish service use time(ms):" + this.dAI.apr() + "[" + toString() + "]");
        AppMethodBeat.o(148360);
    }

    public final void run() {
        AppMethodBeat.i(148361);
        Log.i("MicroMsg.SceneVoiceService", "run() %s", toString());
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.audio.b.i.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(148354);
                long currentTimeMillis = System.currentTimeMillis() - i.this.dAG;
                Log.i("MicroMsg.SceneVoiceService", "Try Run service runningFlag:" + i.this.running + " timeWait:" + currentTimeMillis + " sending:" + i.this.dAE + " recving:" + i.this.dAD + "[" + i.this.toString() + "]");
                if (i.this.running) {
                    if (currentTimeMillis < Util.MILLSECONDS_OF_MINUTE) {
                        AppMethodBeat.o(148354);
                        return;
                    }
                    Log.e("MicroMsg.SceneVoiceService", "ERR: Try Run service runningFlag:" + i.this.running + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + i.this.dAE + " recving:" + i.this.dAD);
                }
                i.this.running = true;
                i.this.dAE = false;
                i.this.dAF = 3;
                i.this.dAD = false;
                i.this.dAI.gLm = SystemClock.elapsedRealtime();
                i.this.dAJ.startTimer(10);
                AppMethodBeat.o(148354);
            }

            public final String toString() {
                AppMethodBeat.i(148355);
                String str = super.toString() + "|run";
                AppMethodBeat.o(148355);
                return str;
            }
        });
        AppMethodBeat.o(148361);
    }

    static /* synthetic */ void h(i iVar) {
        boolean z;
        List<r> bii;
        AppMethodBeat.i(148362);
        iVar.dAG = System.currentTimeMillis();
        if (!(((iVar.dAD || iVar.dAB.size() != 0) && (iVar.dAE || iVar.dAA.size() != 0)) || (bii = s.bii()) == null || bii.size() == 0)) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            String formatUnixTime = Util.formatUnixTime(currentTimeMillis);
            for (r rVar : bii) {
                if (iVar.dAC.containsKey(rVar.fileName)) {
                    Log.d("MicroMsg.SceneVoiceService", "File is Already running:" + rVar.fileName);
                } else {
                    long j2 = currentTimeMillis - rVar.jsm;
                    Log.i("MicroMsg.SceneVoiceService", "Get file:" + rVar.fileName + " status:" + rVar.status + " user" + rVar.dWq + " human:" + rVar.jsh + " create:" + Util.formatUnixTime(rVar.createTime) + " last:" + Util.formatUnixTime(rVar.jsm) + " now:" + Util.formatUnixTime(currentTimeMillis) + " " + (currentTimeMillis - rVar.jsm) + " intervalTime:" + j2);
                    if (rVar.bif()) {
                        if (j2 > 43200) {
                            s.QE(rVar.fileName);
                        } else if (rVar.jsj >= rVar.jqP) {
                            Log.i("MicroMsg.SceneVoiceService", "file: " + rVar.fileName + " stat:" + rVar.status + " now:" + rVar.jsj + " net:" + rVar.jqP);
                        } else {
                            iVar.dAB.offer(rVar);
                            iVar.dAC.put(rVar.fileName, null);
                        }
                    }
                    if (rVar.big()) {
                        Log.i("MicroMsg.SceneVoiceService", "now " + currentTimeMillis + "info.getLastModifyTime()  " + rVar.jsm + "  info.getStatus() " + rVar.status + "  info.getCreateTime() " + rVar.createTime);
                        a.C0295a aVar = com.tencent.mm.cj.a.Owq;
                        boolean blI = a.C0295a.blI(rVar.fileName);
                        a.C0295a aVar2 = com.tencent.mm.cj.a.Owq;
                        boolean blK = a.C0295a.blK(rVar.fileName);
                        Log.i("MicroMsg.SceneVoiceService", "from trans voice scene: %s, isNewTransVoiceScene: %s.", Boolean.valueOf(blI), Boolean.valueOf(blK));
                        if (!blI && !blK) {
                            if (currentTimeMillis - rVar.jsm > 10 && (rVar.status == 2 || rVar.status == 1)) {
                                Log.e("MicroMsg.SceneVoiceService", "time out file: " + rVar.fileName + " last:" + Util.formatUnixTime(rVar.jsm) + " now:" + formatUnixTime);
                                s.QE(rVar.fileName);
                            } else if (currentTimeMillis - rVar.createTime > 600 && rVar.status == 3) {
                                Log.e("MicroMsg.SceneVoiceService", "time out file: " + rVar.fileName + " last:" + Util.formatUnixTime(rVar.jsm) + " now:" + formatUnixTime);
                                s.QE(rVar.fileName);
                            }
                        }
                        if (rVar.dWq.length() <= 0) {
                            Log.e("MicroMsg.SceneVoiceService", "Create a new ChatRoom? , set username first :" + rVar.fileName);
                        } else {
                            iVar.dAA.offer(rVar.fileName);
                            iVar.dAC.put(rVar.fileName, null);
                        }
                    }
                }
            }
            Log.i("MicroMsg.SceneVoiceService", "GetNeedRun procing:" + iVar.dAC.size() + " [recv:" + iVar.dAB.size() + ",send:" + iVar.dAA.size() + "]");
            iVar.dAB.size();
            iVar.dAA.size();
        }
        if (iVar.dAD || iVar.dAB.size() != 0 || iVar.dAE || iVar.dAA.size() != 0) {
            if (!iVar.dAD && iVar.dAB.size() > 0) {
                r poll = iVar.dAB.poll();
                String str = poll.fileName;
                if (((l) g.af(l.class)).eiy().Hd(poll.dTS)) {
                    Log.i("MicroMsg.SceneVoiceService", "[oneliang] msg svrid:%s,it is in delete msg list,may be revoke msg come first,msg info insert last,so no need to add msg info and delete voice info", Long.valueOf(poll.dTS));
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    Log.i("MicroMsg.SceneVoiceService", "Start Recv[%s] :%s", iVar.toString(), str);
                    if (str != null) {
                        iVar.dAC.put(str, new f.a());
                        iVar.dAD = true;
                        g.azz().a(new e(poll), 0);
                    }
                } else if (Util.nullAsNil(poll.fileName).length() > 0) {
                    o.bib().gC(poll.fileName);
                    AppMethodBeat.o(148362);
                    return;
                } else {
                    Log.i("MicroMsg.SceneVoiceService", "[oneliang] the length of voice info file name is zero");
                    AppMethodBeat.o(148362);
                    return;
                }
            }
            if (!iVar.dAE && iVar.dAA.size() > 0) {
                String poll2 = iVar.dAA.poll();
                Log.i("MicroMsg.SceneVoiceService", "Start Send :".concat(String.valueOf(poll2)));
                if (poll2 != null) {
                    iVar.dAC.put(poll2, new f.a());
                    iVar.dAE = true;
                    g.azz().a(new com.tencent.mm.modelvoice.f(poll2), 0);
                }
            }
            AppMethodBeat.o(148362);
            return;
        }
        iVar.aax();
        Log.i("MicroMsg.SceneVoiceService", "No Data Any More , Stop Service");
        AppMethodBeat.o(148362);
    }
}
