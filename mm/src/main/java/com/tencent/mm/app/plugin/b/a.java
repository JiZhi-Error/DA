package com.tencent.mm.app.plugin.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fq;
import com.tencent.mm.g.a.fu;
import com.tencent.mm.g.a.fx;
import com.tencent.mm.g.a.fz;
import com.tencent.mm.g.a.ga;
import com.tencent.mm.g.a.gb;
import com.tencent.mm.g.a.gc;
import com.tencent.mm.g.a.gg;
import com.tencent.mm.g.a.gh;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.r;
import com.tencent.mm.modelvoice.w;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;

public final class a {

    public static class i extends IListener<gb> {
        public i() {
            AppMethodBeat.i(161268);
            this.__eventId = gb.class.getName().hashCode();
            AppMethodBeat.o(161268);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(gb gbVar) {
            AppMethodBeat.i(19785);
            Log.i("MicroMsg.SubCoreExtAgent", "requestAccountSync()");
            if (MMApplicationContext.getContext() == null) {
                Log.w("MicroMsg.SubCoreExtAgent", "MMApplicationContext.getContext() == null");
                AppMethodBeat.o(19785);
                return false;
            }
            t.dv(MMApplicationContext.getContext());
            AppMethodBeat.o(19785);
            return true;
        }
    }

    public static class e extends IListener<ga> {
        com.tencent.mm.audio.b.h doE;
        String fileName = "";

        public e() {
            AppMethodBeat.i(161264);
            this.__eventId = ga.class.getName().hashCode();
            AppMethodBeat.o(161264);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ga gaVar) {
            AppMethodBeat.i(19779);
            ga gaVar2 = gaVar;
            if (gaVar2.dJF.op == 1) {
                if (this.doE == null) {
                    this.doE = new com.tencent.mm.audio.b.h(MMApplicationContext.getContext(), false);
                }
                gaVar2.dJG.dFE = this.doE.hx(gaVar2.dJF.username);
                this.fileName = this.doE.getFileName();
                Log.d("MicroMsg.SubCoreExtAgent", "data.op = [%s], ret = [%s]", Integer.valueOf(gaVar2.dJF.op), Boolean.valueOf(gaVar2.dJG.dFE));
            } else if (gaVar2.dJF.op == 2 && this.doE != null) {
                gaVar2.dJG.fileName = this.fileName;
                gaVar2.dJG.dFE = this.doE.Qt();
                Log.d("MicroMsg.SubCoreExtAgent", "data.op = [%s], fileName = [%s], ret = [%s]", Integer.valueOf(gaVar2.dJF.op), this.fileName, Boolean.valueOf(gaVar2.dJG.dFE));
                this.fileName = "";
            }
            AppMethodBeat.o(19779);
            return true;
        }
    }

    public static class d extends IListener<fz> {
        com.tencent.mm.audio.a.a doD;
        String fileName;

        public d() {
            AppMethodBeat.i(161263);
            this.__eventId = fz.class.getName().hashCode();
            AppMethodBeat.o(161263);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(fz fzVar) {
            AppMethodBeat.i(19778);
            fz fzVar2 = fzVar;
            if (Util.isNullOrNil(fzVar2.dJA.fileName) && fzVar2.dJA.op == 1) {
                Log.e("MicroMsg.SubCoreExtAgent", "fileName(%s) is null or nil.", fzVar2.dJA.fileName);
            } else if (fzVar2.dJA.op == 1) {
                if (this.doD == null) {
                    this.doD = new com.tencent.mm.audio.a.a(MMApplicationContext.getContext());
                } else if (!fzVar2.dJA.fileName.equals(this.fileName)) {
                    if (this.doD.isPlaying()) {
                        this.doD.stop(false);
                    }
                    this.fileName = fzVar2.dJA.fileName;
                } else if (this.doD.YY()) {
                    fzVar2.dJB.dFE = this.doD.resume();
                } else if (this.doD.isPlaying()) {
                    fzVar2.dJB.dFE = false;
                }
                this.doD.dyn = fzVar2.dJA.dJD;
                this.doD.dym = fzVar2.dJA.dJE;
                fzVar2.dJB.dFE = this.doD.a(fzVar2.dJA.fileName, fzVar2.dJA.dtE, fzVar2.dJA.dJC, -1);
            } else if (fzVar2.dJA.op == 2) {
                if (this.doD != null) {
                    this.doD.stop(false);
                }
            } else if (fzVar2.dJA.op == 4 && this.doD != null && this.doD.isPlaying()) {
                fzVar2.dJB.dFE = this.doD.da(true);
            }
            AppMethodBeat.o(19778);
            return true;
        }
    }

    public static class h extends IListener<gh> {
        public h() {
            AppMethodBeat.i(161267);
            this.__eventId = gh.class.getName().hashCode();
            AppMethodBeat.o(161267);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(gh ghVar) {
            AppMethodBeat.i(19784);
            gh ghVar2 = ghVar;
            if (o.bib() == null) {
                Log.e("MicroMsg.SubCoreExtAgent", "SubCoreVoice.getVoiceStg()" + Util.getStack());
                ghVar2.dKd.fileName = "";
            }
            r uk = o.bib().uk((int) ghVar2.dKc.msgId);
            if (uk == null) {
                ghVar2.dKd.fileName = "";
            } else {
                ghVar2.dKd.fileName = uk.fileName;
            }
            AppMethodBeat.o(19784);
            return true;
        }
    }

    public static class g extends IListener<gg> {
        public g() {
            AppMethodBeat.i(161266);
            this.__eventId = gg.class.getName().hashCode();
            AppMethodBeat.o(161266);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(gg ggVar) {
            r rVar = null;
            AppMethodBeat.i(19783);
            gg ggVar2 = ggVar;
            if (o.bib() == null) {
                Log.e("MicroMsg.SubCoreExtAgent", "SubCoreVoice.getVoiceStg() == null" + Util.getStack());
            }
            w bib = o.bib();
            String str = ggVar2.dKa.fileName;
            if (str != null) {
                Cursor rawQuery = bib.iFy.rawQuery("SELECT FileName, User, MsgId, NetOffset, FileNowSize, TotalLen, Status, CreateTime, LastModifyTime, ClientId, VoiceLength, MsgLocalId, Human, reserved1, reserved2, MsgSource, MsgFlag, MsgSeq, MasterBufId, checksum, VoiceFlag" + " FROM voiceinfo WHERE FileName= ?", new String[]{str}, 2);
                Log.d("MicroMsg.VoiceStorage", "getInfoByFilename fileName[" + str + "] ResCount:" + rawQuery.getCount());
                if (rawQuery.moveToFirst()) {
                    rVar = new r();
                    rVar.convertFrom(rawQuery);
                }
                rawQuery.close();
            }
            if (rVar != null) {
                ggVar2.dKb.msgId = (long) rVar.jso;
            }
            AppMethodBeat.o(19783);
            return true;
        }
    }

    public static class c extends IListener<fx> {
        public c() {
            AppMethodBeat.i(161262);
            this.__eventId = fx.class.getName().hashCode();
            AppMethodBeat.o(161262);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(fx fxVar) {
            AppMethodBeat.i(19777);
            fx fxVar2 = fxVar;
            o.e Pl = com.tencent.mm.modelmulti.o.Pl(fxVar2.dJu.dJw);
            Pl.toUser = fxVar2.dJu.dJw;
            Pl.content = fxVar2.dJu.content;
            o.e tD = Pl.tD(fxVar2.dJu.type);
            tD.cSx = fxVar2.dJu.flags;
            tD.jdR = 4;
            o.b bdQ = tD.bdQ();
            fxVar2.dJv.dJx = bdQ.jdJ;
            fxVar2.dJv.msgId = bdQ.jdI;
            AppMethodBeat.o(19777);
            return true;
        }
    }

    public static class b extends IListener<fu> {
        public b() {
            AppMethodBeat.i(161261);
            this.__eventId = fu.class.getName().hashCode();
            AppMethodBeat.o(161261);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(fu fuVar) {
            AppMethodBeat.i(19776);
            fu fuVar2 = fuVar;
            if (com.tencent.mm.plugin.sns.b.o.DCS != null) {
                fuVar2.dJc.dIU = com.tencent.mm.plugin.sns.b.o.DCS.aNW(fuVar2.dJb.dJd);
            }
            AppMethodBeat.o(19776);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.app.plugin.b.a$a  reason: collision with other inner class name */
    public static class C0265a extends IListener<fq> {
        g doA;
        c doB;
        b doC;
        i dov;
        e dow;
        f dox;
        d doy;
        h doz;

        public C0265a() {
            AppMethodBeat.i(161260);
            this.__eventId = fq.class.getName().hashCode();
            AppMethodBeat.o(161260);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(fq fqVar) {
            AppMethodBeat.i(19775);
            fq fqVar2 = fqVar;
            if (fqVar2.dIO.op == 1) {
                Log.i("MicroMsg.SubCoreExtAgent", "ExtAgentLifeEventListener init");
                this.dov = new i();
                this.dow = new e();
                this.dox = new f();
                this.doy = new d();
                this.doz = new h();
                this.doA = new g();
                this.doB = new c();
                this.doC = new b();
                EventCenter.instance.addListener(this.dov);
                EventCenter.instance.addListener(this.dow);
                EventCenter.instance.addListener(this.dox);
                EventCenter.instance.addListener(this.doy);
                EventCenter.instance.addListener(this.doz);
                EventCenter.instance.addListener(this.doA);
                EventCenter.instance.addListener(this.doB);
                EventCenter.instance.addListener(this.doC);
            } else if (fqVar2.dIO.op == 2) {
                if (this.dov != null) {
                    EventCenter.instance.removeListener(this.dov);
                }
                if (this.dow != null) {
                    EventCenter.instance.removeListener(this.dow);
                }
                if (this.dox != null) {
                    EventCenter.instance.removeListener(this.dox);
                }
                if (this.doy != null) {
                    EventCenter.instance.removeListener(this.doy);
                }
                if (this.doz != null) {
                    EventCenter.instance.removeListener(this.doz);
                }
                if (this.doA != null) {
                    EventCenter.instance.removeListener(this.doA);
                }
                if (this.doB != null) {
                    EventCenter.instance.removeListener(this.doB);
                }
                if (this.doC != null) {
                    EventCenter.instance.removeListener(this.doC);
                }
            }
            AppMethodBeat.o(19775);
            return true;
        }
    }

    public static class f extends IListener<gc> {
        m doF;
        boolean doG;
        boolean doH;
        gc doI;
        Runnable doJ;
        String fileName = "";
        boolean isTimeout;
        MTimerHandler timer;

        public f() {
            AppMethodBeat.i(161265);
            this.__eventId = gc.class.getName().hashCode();
            AppMethodBeat.o(161265);
        }

        static /* synthetic */ void a(f fVar) {
            AppMethodBeat.i(231465);
            fVar.stopRecord();
            AppMethodBeat.o(231465);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(gc gcVar) {
            int i2 = 600;
            AppMethodBeat.i(19782);
            gc gcVar2 = gcVar;
            if (!(gcVar2 instanceof gc)) {
                Log.f("MicroMsg.SubCoreExtAgent", "mismatched event");
                AppMethodBeat.o(19782);
                return false;
            }
            if (gcVar2.dJH.op == 1) {
                if (this.doF == null) {
                    this.doF = new m();
                }
                this.doJ = gcVar2.dJH.doJ;
                if (this.doF.mStatus == 1) {
                    this.doF.ZZ();
                }
                gcVar2.dJI.dFE = this.doF.hw(gcVar2.dJH.filePath);
                int i3 = gcVar2.dJH.duration;
                if (i3 <= 0) {
                    Log.e("MicroMsg.SubCoreExtAgent", "duration is invalid, less than 0");
                    i3 = 60;
                }
                if (i3 > 600) {
                    Log.e("MicroMsg.SubCoreExtAgent", "duration is invalid, more than %d", 600);
                } else {
                    i2 = i3;
                }
                Log.i("MicroMsg.SubCoreExtAgent", "MaxVoiceRecordTime (%d)s", Integer.valueOf(i2));
                long j2 = (long) (i2 * 1000);
                if (this.timer == null) {
                    this.timer = new MTimerHandler(new MTimerHandler.CallBack() {
                        /* class com.tencent.mm.app.plugin.b.a.f.AnonymousClass1 */

                        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                        public final boolean onTimerExpired() {
                            AppMethodBeat.i(19780);
                            Log.i("MicroMsg.SubCoreExtAgent", "Voice record timeout.");
                            f.this.isTimeout = true;
                            f.a(f.this);
                            AppMethodBeat.o(19780);
                            return false;
                        }
                    }, false);
                }
                if (this.timer.stopped()) {
                    this.timer.stopTimer();
                }
                this.isTimeout = false;
                this.timer.startTimer(j2);
                this.doG = false;
                Log.d("MicroMsg.SubCoreExtAgent", "data.op = [%s], ret = [%s]", Integer.valueOf(gcVar2.dJH.op), Boolean.valueOf(gcVar2.dJI.dFE));
            } else if (gcVar2.dJH.op == 2 && this.doF != null) {
                if (!this.doG) {
                    this.timer.stopTimer();
                    Log.i("MicroMsg.SubCoreExtAgent", "Voice record stop.");
                    stopRecord();
                }
                gcVar2.dJI.dFE = this.doH;
                Log.d("MicroMsg.SubCoreExtAgent", "data.op = [%s], fileName = [%s], ret = [%s]", Integer.valueOf(gcVar2.dJH.op), this.fileName, Boolean.valueOf(gcVar2.dJI.dFE));
                this.fileName = "";
                this.doH = false;
            }
            AppMethodBeat.o(19782);
            return true;
        }

        private void stopRecord() {
            AppMethodBeat.i(19781);
            if (this.doF != null) {
                this.doH = this.doF.ZZ();
                if (this.doJ != null) {
                    if (this.doI != null) {
                        this.doI.dJI.dJJ = this.doF.dyI.dzA;
                        this.doI = null;
                    }
                    if (this.isTimeout) {
                        this.doJ.run();
                    }
                    this.doJ = null;
                }
                this.doG = true;
            }
            AppMethodBeat.o(19781);
        }
    }
}
