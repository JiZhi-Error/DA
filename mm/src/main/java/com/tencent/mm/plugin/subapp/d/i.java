package com.tencent.mm.plugin.subapp.d;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.m;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ca;
import kotlin.g.a.b;
import kotlin.x;

public final class i implements m {
    private static int dAR = 100;
    protected m.b FKe;
    protected m.a FKf = null;
    private a FKg;
    private long FKh = 0;
    private int FKi = 0;
    private com.tencent.mm.plugin.subapp.a.a FKj = new com.tencent.mm.plugin.subapp.a.a(new b<Boolean, x>() {
        /* class com.tencent.mm.plugin.subapp.d.i.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(232067);
            i.a(i.this);
            AppMethodBeat.o(232067);
            return null;
        }
    });
    private MTimerHandler FKk = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.subapp.d.i.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(232068);
            String str = i.this.fileName;
            if (str != null) {
                g aSP = d.fth().aSP(str);
                if (aSP == null) {
                    Log.d("MicroMsg.VoiceRemindLogic", "startSend null record : ".concat(String.valueOf(str)));
                } else if (aSP.field_status == 1) {
                    aSP.field_status = 2;
                    aSP.cSx = 64;
                    h.a(aSP);
                }
            }
            d.fti().run();
            Log.d("MicroMsg.VoiceRemindRecorder", "Start Send fileName :" + i.this.fileName);
            AppMethodBeat.o(232068);
            return false;
        }
    }, true);
    private com.tencent.mm.modelvoice.m doF = null;
    private String fileName = "";
    private int pkT = 0;
    private long qPl = 0;

    public i() {
        AppMethodBeat.i(28977);
        AppMethodBeat.o(28977);
    }

    @Override // com.tencent.mm.ak.m
    public final int getMaxAmplitude() {
        AppMethodBeat.i(28979);
        if (this.doF != null) {
            int maxAmplitude = this.doF.getMaxAmplitude();
            if (maxAmplitude > dAR) {
                dAR = maxAmplitude;
            }
            Log.d("getMaxAmplitude", " map: " + maxAmplitude + " max:" + dAR + " per:" + ((maxAmplitude * 100) / dAR));
            int i2 = (maxAmplitude * 100) / dAR;
            AppMethodBeat.o(28979);
            return i2;
        }
        AppMethodBeat.o(28979);
        return 0;
    }

    @Override // com.tencent.mm.ak.m
    public final String getFileName() {
        return this.fileName;
    }

    @Override // com.tencent.mm.ak.m
    public final boolean isRecording() {
        return this.doF != null && this.doF.mStatus == 1;
    }

    @Override // com.tencent.mm.ak.m
    public final boolean cancel() {
        AppMethodBeat.i(28981);
        Log.d("MicroMsg.VoiceRemindRecorder", "cancel Record :" + this.fileName);
        synchronized (this) {
            try {
                Log.d("MicroMsg.VoiceRemindRecorder", "stop synchronized Record :" + this.fileName);
                if (this.doF != null) {
                    this.doF.ZZ();
                }
            } catch (Throwable th) {
                AppMethodBeat.o(28981);
                throw th;
            }
        }
        String str = this.fileName;
        if (str != null) {
            Log.d("MicroMsg.VoiceRemindLogic", "Mark Canceled fileName[" + str + "]");
            g aSP = d.fth().aSP(str);
            if (aSP != null) {
                aSP.field_status = 8;
                aSP.field_totallen = c.Qy(h.cz(str, false));
                aSP.cSx = 64;
                h.a(aSP);
            }
        }
        d.fti().run();
        this.fileName = "";
        AppMethodBeat.o(28981);
        return true;
    }

    @Override // com.tencent.mm.ak.m
    public final boolean Qt() {
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.i(28982);
        com.tencent.mm.plugin.audio.c.a.agr("record").agq("record");
        Log.d("MicroMsg.VoiceRemindRecorder", "stop Record :" + this.fileName);
        synchronized (this) {
            try {
                Log.d("MicroMsg.VoiceRemindRecorder", "stop synchronized Record :" + this.fileName);
                if (this.doF != null) {
                    this.doF.ZZ();
                }
            } catch (Throwable th) {
                AppMethodBeat.o(28982);
                throw th;
            }
        }
        if (this.FKi != 2) {
            h.Rk(this.fileName);
            this.fileName = null;
            Log.d("MicroMsg.VoiceRemindRecorder", "Stop " + this.fileName + " by not onPart: " + Util.ticksToNow(this.FKh));
        } else {
            this.pkT = (int) aas();
            if (((long) this.pkT) < 800 || ((long) this.pkT) < 1000) {
                Log.d("MicroMsg.VoiceRemindRecorder", "Stop " + this.fileName + " by voiceLen: " + this.pkT);
                h.Rk(this.fileName);
                this.fileName = "";
                z = false;
            } else {
                String str = this.fileName;
                int i2 = this.pkT;
                if (str != null) {
                    Log.d("MicroMsg.VoiceRemindLogic", "StopRecord fileName[" + str + "]");
                    g aSP = d.fth().aSP(str);
                    if (aSP != null) {
                        if (!(aSP.field_status == 97 || aSP.field_status == 98)) {
                            aSP.field_status = 3;
                        }
                        aSP.field_totallen = c.Qy(h.cz(str, false));
                        if (aSP.field_totallen <= 0) {
                            h.QE(str);
                        } else {
                            aSP.field_lastmodifytime = System.currentTimeMillis() / 1000;
                            aSP.field_voicelenght = i2;
                            aSP.cSx = 3424;
                            ca caVar = new ca();
                            caVar.Cy(aSP.field_user);
                            caVar.setType(34);
                            caVar.nv(1);
                            caVar.Cz(str);
                            if (aSP.field_status == 97) {
                                caVar.setStatus(2);
                                caVar.setContent(f.b(aSP.field_human, (long) aSP.field_voicelenght, false));
                            } else if (aSP.field_status == 98) {
                                caVar.setStatus(5);
                                caVar.setContent(f.b(aSP.field_human, -1, true));
                            } else {
                                caVar.setStatus(1);
                            }
                            caVar.setCreateTime(bp.Kw(aSP.field_user));
                            aSP.field_msglocalid = (int) bp.x(caVar);
                            h.a(aSP);
                        }
                    }
                }
                d.fti().run();
                Log.d("MicroMsg.VoiceRemindRecorder", "Stop file success: " + this.fileName);
            }
            this.fileName = "";
            z2 = z;
        }
        this.FKi = -1;
        AppMethodBeat.o(28982);
        return z2;
    }

    @Override // com.tencent.mm.ak.m
    public final long aas() {
        AppMethodBeat.i(28983);
        if (this.qPl <= 0) {
            AppMethodBeat.o(28983);
            return 0;
        }
        long ticksToNow = Util.ticksToNow(this.qPl);
        AppMethodBeat.o(28983);
        return ticksToNow;
    }

    @Override // com.tencent.mm.ak.m
    public final void reset() {
        AppMethodBeat.i(28984);
        if (this.doF != null) {
            this.doF.ZZ();
            Log.e("MicroMsg.VoiceRemindRecorder", "Reset recorder.stopReocrd");
        }
        this.fileName = "";
        this.FKh = 0;
        this.FKg = null;
        this.FKi = 0;
        this.qPl = 0;
        AppMethodBeat.o(28984);
    }

    @Override // com.tencent.mm.ak.m
    public final int aaq() {
        return this.pkT;
    }

    @Override // com.tencent.mm.ak.m
    public final void a(m.a aVar) {
        this.FKf = aVar;
    }

    @Override // com.tencent.mm.ak.m
    public final void a(m.b bVar) {
        this.FKe = bVar;
    }

    /* access modifiers changed from: package-private */
    public final class a implements Runnable {
        MMHandler handler;

        public a() {
            AppMethodBeat.i(28975);
            this.handler = new MMHandler(i.this) {
                /* class com.tencent.mm.plugin.subapp.d.i.a.AnonymousClass1 */

                @Override // com.tencent.mm.sdk.platformtools.MMHandler
                public final void handleMessage(Message message) {
                    AppMethodBeat.i(28974);
                    if (i.this.FKi <= 0) {
                        AppMethodBeat.o(28974);
                        return;
                    }
                    Log.d("MicroMsg.VoiceRemindRecorder", "On Part :" + (i.this.FKe == null));
                    i.this.FKi = 2;
                    if (i.this.FKe != null) {
                        i.this.FKe.aYN();
                    }
                    AppMethodBeat.o(28974);
                }
            };
            AppMethodBeat.o(28975);
        }

        public final void run() {
            AppMethodBeat.i(28976);
            if (i.this.doF == null) {
                Log.e("MicroMsg.VoiceRemindRecorder", "Stop Record Failed recorder == null");
                AppMethodBeat.o(28976);
                return;
            }
            synchronized (i.this) {
                try {
                    if (!i.this.doF.hw(h.cz(i.this.fileName, true))) {
                        i.aSN(i.this.fileName);
                        i.this.fileName = null;
                        Log.d("MicroMsg.VoiceRemindRecorder", "Thread Start Record  Error fileName[" + i.this.fileName + "]");
                        i.this.doF = null;
                    }
                    i.this.qPl = Util.currentTicks();
                    Log.d("MicroMsg.VoiceRemindRecorder", "Thread Started Record fileName[" + i.this.fileName + "] time:" + Util.ticksToNow(i.this.FKh));
                } catch (Throwable th) {
                    AppMethodBeat.o(28976);
                    throw th;
                }
            }
            this.handler.sendEmptyMessageDelayed(0, 1);
            AppMethodBeat.o(28976);
        }
    }

    @Override // com.tencent.mm.ak.m
    public final int aat() {
        return 0;
    }

    @Override // com.tencent.mm.ak.m
    public final void aar() {
    }

    @Override // com.tencent.mm.ak.m
    public final boolean hx(String str) {
        AppMethodBeat.i(28980);
        String Qv = k.Qv(z.aTY());
        g gVar = new g();
        gVar.field_filename = Qv;
        gVar.field_user = str;
        gVar.field_createtime = System.currentTimeMillis() / 1000;
        gVar.field_clientid = Qv;
        gVar.field_lastmodifytime = System.currentTimeMillis() / 1000;
        gVar.field_status = 1;
        gVar.field_human = z.aTY();
        gVar.cSx = -1;
        k fth = d.fth();
        Log.d("MicroMsg.VoiceRemindStorage", "VoiceRemindStorage Insert");
        int insert = (int) fth.db.insert("VoiceRemindInfo", "", gVar.convertTo());
        Log.d("MicroMsg.VoiceRemindStorage", "VoiceRemindStorage Insert result".concat(String.valueOf(insert)));
        if (insert == -1) {
            Qv = null;
        }
        this.fileName = Qv;
        this.FKj.agq("record");
        this.FKj.Yo();
        AppMethodBeat.o(28980);
        return false;
    }

    static /* synthetic */ void a(i iVar) {
        AppMethodBeat.i(232070);
        iVar.FKj.agq("record");
        iVar.doF = new com.tencent.mm.modelvoice.m();
        new m.a() {
            /* class com.tencent.mm.plugin.subapp.d.i.AnonymousClass3 */

            @Override // com.tencent.mm.ak.m.a
            public final void onError() {
                AppMethodBeat.i(232069);
                Log.e("MicroMsg.VoiceRemindRecorder", "Record Failed file:" + i.this.fileName);
                i.aSN(i.this.fileName);
                if (i.this.FKf != null) {
                    i.this.FKf.onError();
                }
                AppMethodBeat.o(232069);
            }
        };
        iVar.FKg = new a();
        ThreadPool.post(iVar.FKg, "VoiceRemindRecorder_record");
        iVar.FKi = 1;
        iVar.FKk.startTimer(3000);
        Log.d("MicroMsg.VoiceRemindRecorder", "start end time:" + Util.ticksToNow(iVar.FKh));
        AppMethodBeat.o(232070);
    }

    static /* synthetic */ boolean aSN(String str) {
        AppMethodBeat.i(232071);
        boolean Rk = h.Rk(str);
        AppMethodBeat.o(232071);
        return Rk;
    }
}
