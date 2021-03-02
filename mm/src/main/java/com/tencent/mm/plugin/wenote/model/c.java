package com.tencent.mm.plugin.wenote.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ak;
import com.tencent.mm.g.a.al;
import com.tencent.mm.g.a.ct;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cg;
import com.tencent.mm.plugin.ball.c.i;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.plugin.wenote.a.a;
import com.tencent.mm.plugin.wenote.a.b;
import com.tencent.mm.plugin.wenote.multitask.NoteMultiTaskUIC;
import com.tencent.mm.plugin.wenote.multitask.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

public final class c implements bd {
    private static HashMap<Integer, h.b> baseDBFactories = new HashMap<>();
    private b JGH = new b();
    private com.tencent.mm.plugin.wenote.a.c JGI = new com.tencent.mm.plugin.wenote.a.c();
    private a JGJ = new a();
    private IListener<ct> JGK = new IListener<ct>() {
        /* class com.tencent.mm.plugin.wenote.model.c.AnonymousClass1 */

        {
            AppMethodBeat.i(161478);
            this.__eventId = ct.class.getName().hashCode();
            AppMethodBeat.o(161478);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ct ctVar) {
            AppMethodBeat.i(30291);
            final long j2 = ctVar.dFT.localId;
            ((com.tencent.mm.plugin.ball.c.b) g.af(com.tencent.mm.plugin.ball.c.b.class)).a(new i() {
                /* class com.tencent.mm.plugin.wenote.model.c.AnonymousClass1.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.ball.c.i
                public final void bH(List<BallInfo> list) {
                    AppMethodBeat.i(30290);
                    if (list != null && list.size() > 0) {
                        for (BallInfo ballInfo : list) {
                            if (ballInfo.type == 3 && ballInfo.jkf.getInt("eventType") == 1 && ballInfo.key != null && ballInfo.key.startsWith(new StringBuilder().append(j2).toString())) {
                                ((com.tencent.mm.plugin.ball.c.b) g.af(com.tencent.mm.plugin.ball.c.b.class)).l(ballInfo);
                                AppMethodBeat.o(30290);
                                return;
                            }
                        }
                    }
                    AppMethodBeat.o(30290);
                }
            });
            AppMethodBeat.o(30291);
            return true;
        }
    };
    public d JGL = null;
    private IListener oVk = new IListener<ak>() {
        /* class com.tencent.mm.plugin.wenote.model.c.AnonymousClass2 */

        {
            AppMethodBeat.i(161479);
            this.__eventId = ak.class.getName().hashCode();
            AppMethodBeat.o(161479);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ak akVar) {
            AppMethodBeat.i(30292);
            al alVar = new al();
            alVar.dDm.dDn = new com.tencent.mm.plugin.wenote.ui.nativenote.b(akVar.dDl.activity);
            EventCenter.instance.publish(alVar);
            AppMethodBeat.o(30292);
            return false;
        }
    };

    public c() {
        AppMethodBeat.i(30293);
        AppMethodBeat.o(30293);
    }

    public static c gjz() {
        AppMethodBeat.i(30294);
        bg.aVz();
        c cVar = (c) cg.KG("plugin.wenote");
        if (cVar == null) {
            cVar = new c();
            bg.aVz().a("plugin.wenote", cVar);
        }
        AppMethodBeat.o(30294);
        return cVar;
    }

    static {
        AppMethodBeat.i(30297);
        AppMethodBeat.o(30297);
    }

    @Override // com.tencent.mm.model.bd
    public final HashMap<Integer, h.b> getBaseDBFactories() {
        return baseDBFactories;
    }

    @Override // com.tencent.mm.model.bd
    public final void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountPostReset(boolean z) {
        InputStream inputStream;
        OutputStream outputStream = null;
        AppMethodBeat.i(30295);
        Log.d("MicroMsg.SubCoreWNNoteMsg", "on account post reset");
        EventCenter.instance.addListener(this.JGH);
        ((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().a(this.JGI);
        ((af) g.ah(af.class)).getFavCdnStorage().a(this.JGI);
        EventCenter.instance.addListener(this.JGJ);
        EventCenter.instance.addListener(this.JGK);
        EventCenter.instance.addListener(this.oVk);
        o oVar = new o(i.aTk());
        if (!oVar.exists() || !oVar.isDirectory()) {
            Log.d("MicroMsg.SubCoreWNNoteMsg", "record stg dir[%s] not exsit, create it");
            oVar.mkdirs();
        }
        o oVar2 = new o(ao.cVg());
        Log.i("MicroMsg.SubCoreWNNoteMsg", "copy to path %s", aa.z(oVar2.her()));
        if (d.KyR) {
            Log.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile develop version delete template");
            s.dy(aa.z(oVar2.mUri), true);
        } else {
            ao.tbK = ao.bbw();
            if (z) {
                int bbx = ao.bbx();
                Log.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile need update assetVersion=%d currentVersion=%d", Integer.valueOf(bbx), Integer.valueOf(ao.tbK));
                if (ao.tbK < bbx) {
                    s.dy(aa.z(oVar2.mUri), true);
                }
            } else if (ao.tbK == 1) {
                Log.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile need init template");
                s.dy(aa.z(oVar2.mUri), true);
            } else {
                Log.i("MicroMsg.SubCoreWNNoteMsg", "copyAssertTemplateFile currentVersion=%d", Integer.valueOf(ao.tbK));
            }
        }
        if (!oVar2.exists()) {
            oVar2.mkdirs();
        }
        try {
            inputStream = MMApplicationContext.getContext().getAssets().open("WNNote.zip");
        } catch (IOException e2) {
            Log.printErrStackTrace("MicroMsg.SubCoreWNNoteMsg", e2, "", new Object[0]);
            inputStream = null;
        }
        if (inputStream == null) {
            Log.e("MicroMsg.SubCoreWNNoteMsg", "file inputStream not found");
        } else {
            o oVar3 = new o(oVar2, "WNNote.zip");
            if (oVar3.exists()) {
                Log.i("MicroMsg.SubCoreWNNoteMsg", "wenote template already exists");
                Util.qualityClose(inputStream);
            } else {
                try {
                    outputStream = s.ap(oVar3);
                } catch (FileNotFoundException e3) {
                    Log.printErrStackTrace("MicroMsg.SubCoreWNNoteMsg", e3, "", new Object[0]);
                }
                if (outputStream != null) {
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            outputStream.write(bArr, 0, read);
                        }
                    } catch (IOException e4) {
                        Log.printErrStackTrace("MicroMsg.SubCoreWNNoteMsg", e4, "", new Object[0]);
                    }
                }
                Util.qualityClose(inputStream);
                Util.qualityClose(outputStream);
                int fW = s.fW(aa.z(oVar3.her()), oVar3.getParent());
                if (fW < 0) {
                    Log.e("MicroMsg.SubCoreWNNoteMsg", "unzip fail, ret = " + fW + ", zipFilePath = " + aa.z(oVar3.her()) + ", unzipPath = " + oVar3.getParent());
                }
            }
        }
        com.tencent.mm.plugin.wenote.b.a.bCE();
        a.C2007a aVar = com.tencent.mm.plugin.wenote.multitask.a.JJo;
        ((com.tencent.mm.plugin.multitask.d) g.ah(com.tencent.mm.plugin.multitask.d.class)).registerMultiTaskUIC(3, NoteMultiTaskUIC.class);
        a.C2007a aVar2 = com.tencent.mm.plugin.wenote.multitask.a.JJo;
        com.tencent.mm.plugin.taskbar.api.c cVar = (com.tencent.mm.plugin.taskbar.api.c) g.af(com.tencent.mm.plugin.taskbar.api.c.class);
        if (cVar != null) {
            cVar.a(3, com.tencent.mm.plugin.wenote.multitask.a.gkc());
            AppMethodBeat.o(30295);
            return;
        }
        AppMethodBeat.o(30295);
    }

    @Override // com.tencent.mm.model.bd
    public final void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountRelease() {
        AppMethodBeat.i(30296);
        Log.d("MicroMsg.SubCoreWNNoteMsg", "on account post release");
        EventCenter.instance.removeListener(this.JGH);
        if (((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage() != null) {
            ((com.tencent.mm.plugin.record.a.a) g.ah(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().b(this.JGI);
        }
        if (((af) g.ah(af.class)).getFavCdnStorage() != null) {
            ((af) g.ah(af.class)).getFavCdnStorage().b(this.JGI);
        }
        EventCenter.instance.removeListener(this.JGJ);
        EventCenter.instance.removeListener(this.JGK);
        EventCenter.instance.removeListener(this.oVk);
        com.tencent.mm.plugin.wenote.b.a.bCF();
        a.C2007a aVar = com.tencent.mm.plugin.wenote.multitask.a.JJo;
        com.tencent.mm.plugin.taskbar.api.c cVar = (com.tencent.mm.plugin.taskbar.api.c) g.af(com.tencent.mm.plugin.taskbar.api.c.class);
        if (cVar != null) {
            cVar.b(3, com.tencent.mm.plugin.wenote.multitask.a.gkc());
            AppMethodBeat.o(30296);
            return;
        }
        AppMethodBeat.o(30296);
    }

    public final void a(d dVar) {
        this.JGL = dVar;
    }
}
