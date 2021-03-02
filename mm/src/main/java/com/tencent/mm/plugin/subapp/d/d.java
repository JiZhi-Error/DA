package com.tencent.mm.plugin.subapp.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o;
import com.tencent.mm.blink.b;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.g.a.sp;
import com.tencent.mm.g.a.ze;
import com.tencent.mm.g.a.zf;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cg;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.subapp.ui.voicereminder.RemindDialog;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.ui.e;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuppressLint({"UseSparseArrays"})
public class d implements ay.f, bd {
    private static d FJP;
    private static HashMap<Integer, h.b> kvw;
    private k FJO;
    private j FJQ;
    private List<Long> FJR = new ArrayList();
    private IListener FJS = new IListener<zf>() {
        /* class com.tencent.mm.plugin.subapp.d.d.AnonymousClass3 */

        {
            AppMethodBeat.i(161441);
            this.__eventId = zf.class.getName().hashCode();
            AppMethodBeat.o(161441);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(zf zfVar) {
            AppMethodBeat.i(28940);
            zf zfVar2 = zfVar;
            e aSK = e.aSK(zfVar2.efq.xml);
            ca caVar = zfVar2.efq.dCM;
            if (aSK != null) {
                d ftg = d.ftg();
                String str = caVar.field_talker;
                String str2 = zfVar2.efq.description;
                String az = f.az(MMApplicationContext.getContext(), aSK.FJX);
                String str3 = "";
                if (az != null && az.length() > 0) {
                    String[] split = az.split(";");
                    str3 = str3 + split[0];
                    if (split.length > 1) {
                        str3 = str3 + split[1];
                    }
                }
                if (str2 != null) {
                    str3 = str3 + str2;
                }
                ftg.o(str, str3, caVar.field_createTime);
            }
            AppMethodBeat.o(28940);
            return false;
        }
    };
    private IListener FJT = new IListener<ze>() {
        /* class com.tencent.mm.plugin.subapp.d.d.AnonymousClass5 */

        {
            AppMethodBeat.i(161442);
            this.__eventId = ze.class.getName().hashCode();
            AppMethodBeat.o(161442);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ze zeVar) {
            AppMethodBeat.i(28944);
            String str = zeVar.efp.path;
            if (str != null) {
                String cz = h.cz(str, false);
                if (!Util.isNullOrNil(cz)) {
                    d.fth().gC(cz);
                }
                d.fth().Rg(str);
                new o(str).delete();
            }
            AppMethodBeat.o(28944);
            return false;
        }
    };
    private IListener FJU = new IListener<sp>() {
        /* class com.tencent.mm.plugin.subapp.d.d.AnonymousClass6 */

        {
            AppMethodBeat.i(161443);
            this.__eventId = sp.class.getName().hashCode();
            AppMethodBeat.o(161443);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(sp spVar) {
            g aSP;
            AppMethodBeat.i(28945);
            bg.aVF();
            ca Hb = c.aSQ().Hb((long) ((int) spVar.dZg.dCM.field_msgId));
            if (!(Hb.field_msgId == 0 || Hb.field_imgPath == null || Util.isNullOrNil(Hb.field_imgPath) || (aSP = d.fth().aSP(Hb.field_imgPath)) == null || Util.isNullOrNil(aSP.field_filename))) {
                aSP.field_status = 3;
                aSP.field_offset = 0;
                aSP.field_createtime = System.currentTimeMillis() / 1000;
                aSP.field_lastmodifytime = System.currentTimeMillis() / 1000;
                aSP.cSx = 16840;
                h.a(aSP);
                Log.d("MicroMsg.VoiceRemindLogic", " file:" + aSP.field_filename + " msgid:" + aSP.field_msglocalid + "  stat:" + aSP.field_status);
                if (aSP.field_msglocalid == 0 || Util.isNullOrNil(aSP.field_user)) {
                    Log.e("MicroMsg.VoiceRemindLogic", " failed msg id:" + aSP.field_msglocalid + " user:" + aSP.field_user);
                } else {
                    Hb.setStatus(1);
                    bg.aVF();
                    c.aSQ().a(Hb.field_msgId, Hb);
                    d.fti().run();
                }
            }
            AppMethodBeat.o(28945);
            return false;
        }
    };
    private o.a appForegroundListener = new o.a() {
        /* class com.tencent.mm.plugin.subapp.d.d.AnonymousClass4 */

        @Override // com.tencent.mm.app.o
        public final void onAppForeground(String str) {
            AppMethodBeat.i(28942);
            if (g.aAc() && g.aAf().hpY) {
                g.aAf();
                if (!a.azj()) {
                    b.ake().arrange(new Runnable() {
                        /* class com.tencent.mm.plugin.subapp.d.d.AnonymousClass4.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(28941);
                            if (ay.a.iDt != null) {
                                ay.a.iDt.aVr();
                            }
                            AppMethodBeat.o(28941);
                        }
                    });
                }
            }
            AppMethodBeat.o(28942);
        }

        @Override // com.tencent.mm.app.o
        public final void onAppBackground(String str) {
            AppMethodBeat.i(28943);
            if (g.aAc() && g.aAf().hpY) {
                g.aAf();
                a.azj();
            }
            AppMethodBeat.o(28943);
        }
    };
    private String hqG;
    private r.a kvx;
    private final Set<ay.d> listeners = new HashSet();

    public d() {
        AppMethodBeat.i(28946);
        AppMethodBeat.o(28946);
    }

    static {
        AppMethodBeat.i(28959);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        kvw = hashMap;
        hashMap.put(Integer.valueOf("VOICEREMIND_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.subapp.d.d.AnonymousClass2 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return k.SQL_CREATE;
            }
        });
        AppMethodBeat.o(28959);
    }

    @Override // com.tencent.mm.model.ay.f
    public final void a(ay.d dVar) {
        AppMethodBeat.i(28947);
        Log.d("MicroMsg.SubCoreVoiceRemind", "addVoiceRemind ");
        if (dVar != null) {
            this.listeners.add(dVar);
        }
        AppMethodBeat.o(28947);
    }

    @Override // com.tencent.mm.model.ay.f
    public final void b(ay.d dVar) {
        AppMethodBeat.i(28948);
        Log.d("MicroMsg.SubCoreVoiceRemind", "removeVoiceRemind ");
        if (dVar != null) {
            this.listeners.remove(dVar);
        }
        AppMethodBeat.o(28948);
    }

    public final void o(String str, String str2, long j2) {
        Uri parse;
        AppMethodBeat.i(28949);
        Context context = MMApplicationContext.getContext();
        if (context == null) {
            Log.d("MicroMsg.SubCoreVoiceRemind", "notifyVoiceRemind context null");
            AppMethodBeat.o(28949);
            return;
        }
        try {
            boolean apV = com.tencent.mm.n.g.apV();
            boolean apR = com.tencent.mm.n.g.apR();
            Log.d("MicroMsg.SubCoreVoiceRemind", "shake " + apV + "sound " + apR);
            if (!ab.Jq(bg.getNotification().ala())) {
                if (apV) {
                    Util.shake(context, true);
                }
                if (apR) {
                    String apX = com.tencent.mm.n.g.apX();
                    if (apX == e.l.gLX) {
                        parse = RingtoneManager.getDefaultUri(2);
                    } else {
                        parse = Uri.parse(apX);
                    }
                    k kVar = new k();
                    try {
                        kVar.setDataSource(context, parse);
                        kVar.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            /* class com.tencent.mm.plugin.subapp.d.d.AnonymousClass1 */

                            public final void onCompletion(MediaPlayer mediaPlayer) {
                                AppMethodBeat.i(28939);
                                try {
                                    mediaPlayer.release();
                                    AppMethodBeat.o(28939);
                                } catch (Exception e2) {
                                    Log.printErrStackTrace("MicroMsg.SubCoreVoiceRemind", e2, "", new Object[0]);
                                    AppMethodBeat.o(28939);
                                }
                            }
                        });
                        if (com.tencent.mm.plugin.audio.c.a.getStreamVolume(5) != 0) {
                            if (com.tencent.mm.plugin.audio.c.a.cdW()) {
                                int streamVolume = com.tencent.mm.plugin.audio.c.a.getStreamVolume(8);
                                int streamMaxVolume = com.tencent.mm.plugin.audio.c.a.getStreamMaxVolume(8);
                                int streamVolume2 = com.tencent.mm.plugin.audio.c.a.getStreamVolume(5);
                                if (streamVolume2 <= streamMaxVolume) {
                                    streamMaxVolume = streamVolume2;
                                }
                                com.tencent.mm.plugin.audio.c.a.eQ(8, streamMaxVolume);
                                kVar.setAudioStreamType(8);
                                kVar.setLooping(true);
                                kVar.prepare();
                                kVar.setLooping(false);
                                kVar.start();
                                com.tencent.mm.plugin.audio.c.a.eQ(8, streamVolume);
                                Log.d("MicroMsg.SubCoreVoiceRemind", "oldVolume is %d, toneVolume is %d", Integer.valueOf(streamVolume), Integer.valueOf(streamMaxVolume));
                            } else {
                                kVar.setAudioStreamType(5);
                                kVar.setLooping(true);
                                kVar.prepare();
                                kVar.setLooping(false);
                                kVar.start();
                            }
                        }
                    } catch (Exception e2) {
                        Log.printErrStackTrace("MicroMsg.SubCoreVoiceRemind", e2, "", new Object[0]);
                        kVar.release();
                    } catch (Throwable th) {
                        Log.printErrStackTrace("MicroMsg.SubCoreVoiceRemind", th, "relese error", new Object[0]);
                    }
                }
            } else if (apV) {
                Util.shake(context, true);
            }
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.SubCoreVoiceRemind", e3, "", new Object[0]);
        }
        if (this.listeners == null || this.listeners.size() == 0) {
            RemindDialog.L(context, str, str2);
            AppMethodBeat.o(28949);
            return;
        }
        for (ay.d dVar : this.listeners) {
            dVar.B(str2, j2);
        }
        AppMethodBeat.o(28949);
    }

    @Override // com.tencent.mm.model.ay.f
    public final void Kl(String str) {
        AppMethodBeat.i(28950);
        bg.aVF();
        c.aST().bka(str);
        this.FJR.clear();
        bg.aVF();
        Cursor aEH = c.aSQ().aEH(str);
        aEH.moveToFirst();
        Log.d("MicroMsg.SubCoreVoiceRemind", "resetSilentQuene");
        while (!aEH.isAfterLast()) {
            ca caVar = new ca();
            caVar.convertFrom(aEH);
            long j2 = caVar.field_msgId;
            Log.d("MicroMsg.SubCoreVoiceRemind", "resetSilentQuene: msgId = " + j2 + " status = " + caVar.field_status);
            aEH.moveToNext();
            this.FJR.add(Long.valueOf(j2));
        }
        aEH.close();
        bg.aVF();
        c.aSQ().aEF(str);
        AppMethodBeat.o(28950);
    }

    @Override // com.tencent.mm.model.ay.f
    public final void aVr() {
        AppMethodBeat.i(28951);
        fti().run();
        AppMethodBeat.o(28951);
    }

    @Override // com.tencent.mm.model.ay.f
    public final boolean Ac(long j2) {
        AppMethodBeat.i(28952);
        boolean contains = this.FJR.contains(Long.valueOf(j2));
        Log.d("MicroMsg.SubCoreVoiceRemind", "silent " + contains + "  mid " + j2);
        AppMethodBeat.o(28952);
        return contains;
    }

    public static d ftg() {
        AppMethodBeat.i(28953);
        bg.aVz();
        com.tencent.mm.plugin.subapp.a aVar = (com.tencent.mm.plugin.subapp.a) cg.KG("plugin.subapp");
        FJP = aVar == null ? null : (d) aVar.aSI(d.class.getName());
        Log.i("MicroMsg.SubCoreVoiceRemind", "summervoice SubCoreVoiceRemind getCore subCoreSubapp[%s], theCore[%s], stack[%s]", aVar, FJP, Util.getStack());
        if (FJP == null) {
            d dVar = new d();
            FJP = dVar;
            ay.a.iDt = dVar;
            aVar.b(d.class.getName(), FJP);
        }
        d dVar2 = FJP;
        AppMethodBeat.o(28953);
        return dVar2;
    }

    public static k fth() {
        AppMethodBeat.i(28954);
        g.aAf().azk();
        if (ftg().FJO == null) {
            d ftg = ftg();
            ftg();
            if (ftg().kvx == null) {
                StringBuilder sb = new StringBuilder();
                bg.aVF();
                String sb2 = sb.append(c.azM()).append("CommonOneMicroMsg.db").toString();
                ftg().kvx = r.a(d.class.hashCode(), sb2, kvw, false);
            }
            ftg.FJO = new k(ftg().kvx);
        }
        k kVar = ftg().FJO;
        AppMethodBeat.o(28954);
        return kVar;
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(28955);
        StringBuilder sb = new StringBuilder();
        bg.aVF();
        sb.append(c.azM()).append("CommonOneMicroMsg.db");
        fth();
        EventCenter.instance.addListener(this.FJS);
        EventCenter.instance.addListener(this.FJT);
        EventCenter.instance.addListener(this.FJU);
        this.appForegroundListener.alive();
        Log.d("MicroMsg.SubCoreVoiceRemind", "summervoiceremind onAccountPostReset hash[%d]", Integer.valueOf(hashCode()));
        AppMethodBeat.o(28955);
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
        AppMethodBeat.i(28956);
        bg.aVF();
        String accPath = c.getAccPath();
        if (Util.isNullOrNil(accPath) || Util.isNullOrNil(this.hqG) || !accPath.equals(this.hqG)) {
            Log.d("MicroMsg.SubCoreVoiceRemind", "setVoiceRemindPath core on accPath : ".concat(String.valueOf(accPath)));
            this.hqG = accPath;
            com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(accPath);
            if (!oVar.exists()) {
                oVar.mkdirs();
            }
            bg.aVF();
            com.tencent.mm.vfs.o oVar2 = new com.tencent.mm.vfs.o(c.aTj());
            if (!oVar2.exists()) {
                oVar2.mkdirs();
            }
        }
        AppMethodBeat.o(28956);
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(28957);
        if (this.FJQ != null) {
            this.FJQ.dAF = 0;
        }
        this.appForegroundListener.dead();
        if (FJP != null) {
            Log.d("MicroMsg.SubCoreVoiceRemind", "SubCoreVoiceRemind close db");
            d dVar = FJP;
            if (dVar.kvx != null) {
                dVar.kvx.uS(dVar.hashCode());
                dVar.kvx = null;
            }
            dVar.hqG = "";
        }
        EventCenter.instance.removeListener(this.FJS);
        EventCenter.instance.removeListener(this.FJT);
        EventCenter.instance.removeListener(this.FJU);
        AppMethodBeat.o(28957);
    }

    public static j fti() {
        AppMethodBeat.i(28958);
        g.aAf().azk();
        if (ftg().FJQ == null) {
            ftg().FJQ = new j();
        }
        j jVar = ftg().FJQ;
        AppMethodBeat.o(28958);
        return jVar;
    }
}
