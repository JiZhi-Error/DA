package com.tencent.mm.plugin.subapp.d;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelvoice.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.TbsListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public final class j implements i {
    private static int jrr = 0;
    Queue<String> dAA = new LinkedList();
    Queue<String> dAB = new LinkedList();
    Map<String, f.a> dAC = new HashMap();
    private boolean dAD = false;
    private boolean dAE = false;
    int dAF = 0;
    private long dAG = 0;
    f.a dAI = new f.a();
    private MTimerHandler dAJ = new MTimerHandler(bg.aAk().getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.subapp.d.j.AnonymousClass3 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(28988);
            Log.d("MicroMsg.VoiceRemindService", "onTimerExpired");
            try {
                j.h(j.this);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.VoiceRemindService", e2, "", new Object[0]);
            }
            AppMethodBeat.o(28988);
            return false;
        }
    }, false);
    private boolean running = false;

    static /* synthetic */ int access$008() {
        int i2 = jrr;
        jrr = i2 + 1;
        return i2;
    }

    static /* synthetic */ int c(j jVar) {
        int i2 = jVar.dAF;
        jVar.dAF = i2 - 1;
        return i2;
    }

    static /* synthetic */ int chC() {
        int i2 = jrr;
        jrr = i2 - 1;
        return i2;
    }

    static /* synthetic */ void i(j jVar) {
        AppMethodBeat.i(28994);
        jVar.aax();
        AppMethodBeat.o(28994);
    }

    public j() {
        AppMethodBeat.i(28989);
        bg.azz().a(TbsListener.ErrorCode.ERROR_GETSTRINGARRAY_JARFILE, this);
        AppMethodBeat.o(28989);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(final int i2, final int i3, String str, final q qVar) {
        AppMethodBeat.i(28990);
        bg.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.subapp.d.j.AnonymousClass1 */

            public final void run() {
                int i2;
                String str;
                AppMethodBeat.i(28986);
                j.access$008();
                if (qVar.getType() == 128) {
                    j.this.dAD = false;
                    String str2 = ((e) qVar).fileName;
                    i2 = ((e) qVar).retCode;
                    str = str2;
                } else if (qVar.getType() == 329) {
                    j.this.dAE = false;
                    String str3 = ((b) qVar).fileName;
                    i2 = ((b) qVar).retCode;
                    str = str3;
                } else {
                    Log.e("MicroMsg.VoiceRemindService", "onSceneEnd Error SceneType:" + qVar.getType());
                    j.chC();
                    AppMethodBeat.o(28986);
                    return;
                }
                long j2 = 0;
                if (!(str == null || j.this.dAC.get(str) == null)) {
                    j2 = j.this.dAC.get(str).apr();
                    j.this.dAC.remove(str);
                }
                Log.d("MicroMsg.VoiceRemindService", "onSceneEnd SceneType:" + qVar.getType() + " errtype:" + i2 + " errCode:" + i3 + " retCode:" + i2 + " file:" + str + " time:" + j2);
                if (i2 == 3 && i2 != 0) {
                    j.c(j.this);
                } else if (i2 != 0) {
                    j.this.dAF = 0;
                }
                Log.d("MicroMsg.VoiceRemindService", "onSceneEnd  inCnt:" + j.jrr + " stop:" + j.this.dAF + " running:" + j.this.running + " recving:" + j.this.dAD + " sending:" + j.this.dAE);
                if (j.this.dAF > 0) {
                    j.h(j.this);
                } else if (!j.this.dAE && !j.this.dAD) {
                    j.i(j.this);
                }
                j.chC();
                AppMethodBeat.o(28986);
            }
        });
        AppMethodBeat.o(28990);
    }

    private void aax() {
        AppMethodBeat.i(28991);
        this.dAC.clear();
        this.dAA.clear();
        this.dAB.clear();
        this.dAE = false;
        this.dAD = false;
        this.running = false;
        Log.d("MicroMsg.VoiceRemindService", "Finish service use time(ms):" + this.dAI.apr());
        AppMethodBeat.o(28991);
    }

    public final void run() {
        AppMethodBeat.i(28992);
        bg.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.subapp.d.j.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(28987);
                long currentTimeMillis = System.currentTimeMillis() - j.this.dAG;
                Log.d("MicroMsg.VoiceRemindService", "Try Run service runningFlag:" + j.this.running + " timeWait:" + currentTimeMillis + " sending:" + j.this.dAE + " recving:" + j.this.dAD);
                if (j.this.running) {
                    if (currentTimeMillis < Util.MILLSECONDS_OF_MINUTE) {
                        AppMethodBeat.o(28987);
                        return;
                    }
                    Log.e("MicroMsg.VoiceRemindService", "ERR: Try Run service runningFlag:" + j.this.running + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + j.this.dAE + " recving:" + j.this.dAD);
                }
                j.this.running = true;
                j.this.dAE = false;
                j.this.dAF = 3;
                j.this.dAD = false;
                j.this.dAI.gLm = SystemClock.elapsedRealtime();
                j.this.dAJ.startTimer(10);
                AppMethodBeat.o(28987);
            }
        });
        AppMethodBeat.o(28992);
    }

    static /* synthetic */ void h(j jVar) {
        boolean z;
        AppMethodBeat.i(28993);
        jVar.dAG = System.currentTimeMillis();
        if ((!jVar.dAD && jVar.dAB.size() == 0) || (!jVar.dAE && jVar.dAA.size() == 0)) {
            k fth = d.fth();
            Cursor rawQuery = fth.db.rawQuery(("SELECT filename, user, msgid, offset, filenowsize, totallen, status, createtime, lastmodifytime, clientid, voicelenght, msglocalid, human, voiceformat, nettimes, reserved1, reserved2" + " FROM VoiceRemindInfo") + " WHERE status<97  order by createtime", null, 2);
            ArrayList<g> arrayList = null;
            int i2 = 0;
            if (rawQuery.moveToFirst()) {
                arrayList = new ArrayList();
                do {
                    g gVar = new g();
                    gVar.convertFrom(rawQuery);
                    arrayList.add(gVar);
                    i2++;
                } while (rawQuery.moveToNext());
            }
            rawQuery.close();
            Log.d("MicroMsg.VoiceRemindStorage", "getUnfinishInfo resCount:".concat(String.valueOf(i2)));
            if (arrayList == null) {
                Log.d("MicroMsg.VoiceRemindService", "getNeedRunInfo null ");
            } else {
                Log.d("MicroMsg.VoiceRemindService", "getNeedRunInfo " + arrayList.size());
            }
            if (!(arrayList == null || arrayList.size() == 0)) {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                String formatUnixTime = Util.formatUnixTime(currentTimeMillis);
                for (g gVar2 : arrayList) {
                    if (jVar.dAC.containsKey(gVar2.field_filename)) {
                        Log.d("MicroMsg.VoiceRemindService", "File is Already running:" + gVar2.field_filename);
                    } else {
                        Log.d("MicroMsg.VoiceRemindService", "Get file:" + gVar2.field_filename + " status:" + gVar2.field_status + " user" + gVar2.field_user + " human:" + gVar2.field_human + " create:" + Util.formatUnixTime(gVar2.field_createtime) + " last:" + Util.formatUnixTime(gVar2.field_lastmodifytime) + " now:" + Util.formatUnixTime(currentTimeMillis) + " " + (currentTimeMillis - gVar2.field_lastmodifytime));
                        if (gVar2.field_status == 5 || gVar2.field_status == 6) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            if (currentTimeMillis - gVar2.field_lastmodifytime > 80 && gVar2.field_status == 5) {
                                Log.e("MicroMsg.VoiceRemindService", "time out file: " + gVar2.field_filename + " last:" + Util.formatUnixTime(gVar2.field_lastmodifytime) + " now:" + formatUnixTime);
                                h.QE(gVar2.field_filename);
                            } else if (currentTimeMillis - gVar2.field_lastmodifytime > 300 && gVar2.field_status == 6) {
                                Log.e("MicroMsg.VoiceRemindService", "time out file: " + gVar2.field_filename + " last:" + Util.formatUnixTime(gVar2.field_lastmodifytime) + " now:" + formatUnixTime);
                                h.QE(gVar2.field_filename);
                            } else if (gVar2.field_filenowsize >= gVar2.field_offset) {
                                Log.d("MicroMsg.VoiceRemindService", "file: " + gVar2.field_filename + " stat:" + gVar2.field_status + " now:" + gVar2.field_filenowsize + " net:" + gVar2.field_offset);
                            } else {
                                jVar.dAB.offer(gVar2.field_filename);
                                jVar.dAC.put(gVar2.field_filename, null);
                            }
                        }
                        if (gVar2.big()) {
                            Log.d("MicroMsg.VoiceRemindService", "now " + currentTimeMillis + "info.getLastModifyTime()  " + gVar2.field_lastmodifytime + "  info.getStatus() " + gVar2.field_status + "  info.getCreateTime() " + gVar2.field_createtime);
                            if (currentTimeMillis - gVar2.field_lastmodifytime > 10 && (gVar2.field_status == 2 || gVar2.field_status == 1)) {
                                Log.e("MicroMsg.VoiceRemindService", "time out file: " + gVar2.field_filename + " last:" + Util.formatUnixTime(gVar2.field_lastmodifytime) + " now:" + formatUnixTime);
                                h.QE(gVar2.field_filename);
                            } else if (currentTimeMillis - gVar2.field_createtime > 600 && gVar2.field_status == 3) {
                                Log.e("MicroMsg.VoiceRemindService", "time out file: " + gVar2.field_filename + " last:" + Util.formatUnixTime(gVar2.field_lastmodifytime) + " now:" + formatUnixTime);
                                h.QE(gVar2.field_filename);
                            } else if (gVar2.field_user.length() <= 0) {
                                Log.e("MicroMsg.VoiceRemindService", "Create a new ChatRoom? , set username first :" + gVar2.field_filename);
                            } else {
                                jVar.dAA.offer(gVar2.field_filename);
                                jVar.dAC.put(gVar2.field_filename, null);
                            }
                        }
                    }
                }
                Log.d("MicroMsg.VoiceRemindService", "GetNeedRun procing:" + jVar.dAC.size() + " [recv:" + jVar.dAB.size() + ",send:" + jVar.dAA.size() + "]");
                jVar.dAB.size();
                jVar.dAA.size();
            }
        }
        if (jVar.dAD || jVar.dAB.size() != 0 || jVar.dAE || jVar.dAA.size() != 0) {
            if (!jVar.dAD && jVar.dAB.size() > 0) {
                String poll = jVar.dAB.poll();
                Log.d("MicroMsg.VoiceRemindService", "Start Recv :".concat(String.valueOf(poll)));
                if (poll != null) {
                    jVar.dAC.put(poll, new f.a());
                    jVar.dAD = true;
                    Log.d("MicroMsg.VoiceRemindService", "tiger download voice");
                }
            }
            if (!jVar.dAE && jVar.dAA.size() > 0) {
                String poll2 = jVar.dAA.poll();
                Log.d("MicroMsg.VoiceRemindService", "Start Send :".concat(String.valueOf(poll2)));
                if (poll2 != null) {
                    jVar.dAC.put(poll2, new f.a());
                    jVar.dAE = true;
                    bg.azz().a(new b(poll2), 0);
                }
            }
            AppMethodBeat.o(28993);
            return;
        }
        jVar.aax();
        Log.d("MicroMsg.VoiceRemindService", "No Data Any More , Stop Service");
        AppMethodBeat.o(28993);
    }
}
