package com.tencent.mm.plugin.record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qg;
import com.tencent.mm.kernel.a.b.b;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.record.a.a;
import com.tencent.mm.plugin.record.a.e;
import com.tencent.mm.plugin.record.a.h;
import com.tencent.mm.plugin.record.b.j;
import com.tencent.mm.plugin.record.b.k;
import com.tencent.mm.plugin.record.b.l;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.plugin.record.b.s;
import com.tencent.mm.plugin.record.b.t;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.y;
import java.util.Iterator;

public class PluginRecord extends f implements b, c, a {
    private h BGi;
    private e BGj;
    private s BGk = null;
    private j BGl = null;
    private l BGm = null;
    private t BGn = new t();
    private IListener BGo = new IListener<qg>() {
        /* class com.tencent.mm.plugin.record.PluginRecord.AnonymousClass1 */

        {
            AppMethodBeat.i(160911);
            this.__eventId = qg.class.getName().hashCode();
            AppMethodBeat.o(160911);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(qg qgVar) {
            AppMethodBeat.i(9428);
            qg qgVar2 = qgVar;
            String str = qgVar2.dWB.xml;
            long j2 = qgVar2.dWB.dFm;
            com.tencent.mm.protocal.b.a.c aKY = p.aKY(str);
            String str2 = "";
            Iterator<aml> it = aKY.iAd.iterator();
            while (it.hasNext()) {
                str2 = str2 + p.c(it.next(), j2) + ":";
            }
            qgVar2.dWC.dWD = str2;
            AppMethodBeat.o(9428);
            return true;
        }
    };

    public PluginRecord() {
        AppMethodBeat.i(9429);
        AppMethodBeat.o(9429);
    }

    private static void checkDir() {
        AppMethodBeat.i(9430);
        StringBuilder sb = new StringBuilder();
        g.aAi();
        o oVar = new o(sb.append(g.aAh().hqG).append("record/").toString());
        if (!oVar.exists() || !oVar.isDirectory()) {
            Log.d("MicroMsg.PluginRecord", "record stg dir[%s] not exsit, create it");
            oVar.mkdirs();
        }
        AppMethodBeat.o(9430);
    }

    @Override // com.tencent.mm.kernel.a.b.b
    public void parallelsDependency() {
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(9431);
        this.BGi = new com.tencent.mm.plugin.record.b.o(g.aAh().hqK);
        this.BGj = new k(g.aAh().hqK);
        Log.i("MicroMsg.PluginRecord", "on account post reset");
        EventCenter.instance.addListener(this.BGn);
        EventCenter.instance.addListener(this.BGo);
        checkDir();
        getRecordMsgService().a((com.tencent.mm.plugin.record.a.k) null, false);
        Log.i("MicroMsg.PluginRecord", "onAccountInitialized start recordMsgSendService");
        AppMethodBeat.o(9431);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(9432);
        Log.d("MicroMsg.PluginRecord", "on account post release");
        EventCenter.instance.removeListener(this.BGn);
        EventCenter.instance.removeListener(this.BGo);
        if (this.BGk != null) {
            s sVar = this.BGk;
            sVar.finish();
            g.aAg().hqi.b(632, sVar);
            ((a) g.ah(a.class)).getRecordMsgCDNStorage().b(sVar);
        }
        if (this.BGl != null) {
            this.BGl.finish();
        }
        AppMethodBeat.o(9432);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(215178);
        y.at("record", "record", 19);
        AppMethodBeat.o(215178);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(215179);
        if (!gVar.aBb()) {
            AppMethodBeat.o(215179);
            return;
        }
        g.b(com.tencent.mm.plugin.record.a.f.class, new l());
        AppMethodBeat.o(215179);
    }

    @Override // com.tencent.mm.plugin.record.a.a
    public com.tencent.mm.plugin.record.a.e getRecordMsgCDNStorage() {
        return this.BGj;
    }

    public h getRecordMsgInfoStorage() {
        return this.BGi;
    }

    @Override // com.tencent.mm.plugin.record.a.a
    public h getRecordMsgStorage() {
        AppMethodBeat.i(9433);
        h recordMsgInfoStorage = getRecordMsgInfoStorage();
        AppMethodBeat.o(9433);
        return recordMsgInfoStorage;
    }

    @Override // com.tencent.mm.plugin.record.a.a
    public s getRecordMsgService() {
        AppMethodBeat.i(9434);
        g.aAf().azk();
        if (this.BGk == null) {
            this.BGk = new s();
        }
        s sVar = this.BGk;
        AppMethodBeat.o(9434);
        return sVar;
    }

    @Override // com.tencent.mm.plugin.record.a.a
    public j getRecordMsgCDNService() {
        AppMethodBeat.i(9435);
        g.aAf().azk();
        if (this.BGl == null) {
            this.BGl = new j();
        }
        j jVar = this.BGl;
        AppMethodBeat.o(9435);
        return jVar;
    }
}
