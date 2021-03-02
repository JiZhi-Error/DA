package com.tencent.mm.plugin.mv;

import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.g.a.lx;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.mv.a.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0006J\u0012\u0010\u0017\u001a\u00020\u00122\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0012H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/mv/PluginMv;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/mv/IPluginMv;", "Lcom/tencent/mm/kernel/api/bucket/ICoreAccountCallbackBucket;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "localResUpdateListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/LocalCheckResUpdateCacheFileEvent;", "getLocalResUpdateListener", "()Lcom/tencent/mm/sdk/event/IListener;", "resUpdateListener", "Lcom/tencent/mm/autogen/events/CheckResUpdateCacheFileEvent;", "getResUpdateListener", "execute", "", Scopes.PROFILE, "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "handleDefaultVideoZip", "filePath", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "plugin-mv_release"})
public final class PluginMv extends f implements com.tencent.mm.kernel.api.bucket.c, a {
    private final IListener<bp> Ape = new c(this);
    private final String TAG = "MicroMsg.Mv.PluginMv";
    private final IListener<lx> plI = new b(this);

    public PluginMv() {
        AppMethodBeat.i(256741);
        AppMethodBeat.o(256741);
    }

    public final String getTAG() {
        return this.TAG;
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public final void execute(g gVar) {
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountRelease() {
        AppMethodBeat.i(256738);
        this.Ape.dead();
        this.plI.dead();
        h hVar = h.Aqi;
        h.destroy();
        AppMethodBeat.o(256738);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0054  */
    @Override // com.tencent.mm.kernel.api.c
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onAccountInitialized(com.tencent.mm.kernel.e.c r6) {
        /*
        // Method dump skipped, instructions count: 132
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mv.PluginMv.onAccountInitialized(com.tencent.mm.kernel.e$c):void");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/mv/PluginMv$resUpdateListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/CheckResUpdateCacheFileEvent;", "callback", "", "event", "plugin-mv_release"})
    public static final class c extends IListener<bp> {
        final /* synthetic */ PluginMv Apf;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(PluginMv pluginMv) {
            this.Apf = pluginMv;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(bp bpVar) {
            AppMethodBeat.i(256737);
            bp bpVar2 = bpVar;
            if (bpVar2 != null) {
                switch (bpVar2.dEN.dEO) {
                    case 87:
                        if (bpVar2.dEN.subType == 1) {
                            PluginMv pluginMv = this.Apf;
                            String str = bpVar2.dEN.filePath;
                            p.g(str, "event.data.filePath");
                            pluginMv.handleDefaultVideoZip(str);
                            break;
                        }
                        break;
                }
            }
            AppMethodBeat.o(256737);
            return false;
        }
    }

    public final IListener<bp> getResUpdateListener() {
        return this.Ape;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/mv/PluginMv$localResUpdateListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/LocalCheckResUpdateCacheFileEvent;", "callback", "", "event", "plugin-mv_release"})
    public static final class b extends IListener<lx> {
        final /* synthetic */ PluginMv Apf;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(PluginMv pluginMv) {
            this.Apf = pluginMv;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(lx lxVar) {
            AppMethodBeat.i(256736);
            lx lxVar2 = lxVar;
            if (lxVar2 != null) {
                switch (lxVar2.dRu.dEO) {
                    case 87:
                        if (lxVar2.dRu.subType == 1) {
                            PluginMv pluginMv = this.Apf;
                            String str = lxVar2.dRu.filePath;
                            p.g(str, "event.data.filePath");
                            pluginMv.handleDefaultVideoZip(str);
                            break;
                        }
                        break;
                }
            }
            AppMethodBeat.o(256736);
            return false;
        }
    }

    public final IListener<lx> getLocalResUpdateListener() {
        return this.plI;
    }

    public final void handleDefaultVideoZip(String str) {
        AppMethodBeat.i(256740);
        p.h(str, "filePath");
        Log.i(this.TAG, "start to handle " + str + ' ' + s.boW(str));
        d.c("Thread.Music", new a(this, str));
        AppMethodBeat.o(256740);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ PluginMv Apf;
        final /* synthetic */ String msC;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(PluginMv pluginMv, String str) {
            super(0);
            this.Apf = pluginMv;
            this.msC = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            ArrayList arrayList;
            StringBuilder sb;
            AppMethodBeat.i(256735);
            com.tencent.mm.plugin.music.model.g gVar = com.tencent.mm.plugin.music.model.g.Aku;
            String eux = com.tencent.mm.plugin.music.model.g.eux();
            com.tencent.mm.plugin.music.model.g gVar2 = com.tencent.mm.plugin.music.model.g.Aku;
            String str = com.tencent.mm.plugin.music.model.g.eux() + "mv_default_video/";
            s.deleteDir(str);
            int fW = s.fW(this.msC, eux);
            String tag = this.Apf.getTAG();
            StringBuilder append = new StringBuilder("handleDefaultVideoZip ").append(fW).append(' ').append(s.YS(str)).append(' ');
            Iterable<e> dC = s.dC(str, false);
            if (dC != null) {
                ArrayList arrayList2 = new ArrayList(j.a(dC, 10));
                for (e eVar : dC) {
                    arrayList2.add(eVar.NGP);
                }
                arrayList = arrayList2;
                sb = append;
            } else {
                arrayList = null;
                sb = append;
            }
            Log.i(tag, sb.append(arrayList).toString());
            x xVar = x.SXb;
            AppMethodBeat.o(256735);
            return xVar;
        }
    }
}
