package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.e;
import com.tencent.mm.plugin.topstory.ui.video.f;
import com.tencent.mm.plugin.topstory.ui.video.h;
import com.tencent.mm.plugin.topstory.ui.video.j;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import java.util.List;

public final class d extends e {
    protected b Gmr;
    public boolean Gol = false;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(h hVar, int i2) {
        AppMethodBeat.i(126249);
        h hVar2 = hVar;
        if (!abZ(i2) && !aca(i2)) {
            g gVar = (g) hVar2;
            eiw acd = this.GlS.fyO().acd(i2 - getHeadersCount());
            gVar.d(acd);
            this.GlR.put(acd.psI, new WeakReference(gVar));
            if (this.Gol && this.Gmr.fyD().Nig == i2) {
                boolean dFG = this.Gmr.fyF().dFG();
                Log.i("MicroMsg.TopStory.TopStoryFSVideoAdapter", "fs play %d %b", Integer.valueOf(this.Gmr.fyD().Nig), Boolean.valueOf(dFG));
                this.Gol = false;
                f fVar = this.Gmr.fyF().GnY;
                e eVar = gVar.GoY;
                this.Gmr.fyF().a(gVar.GoY, gVar.GoY.c(acd));
                if (!(fVar == null || fVar == eVar)) {
                    if (fVar.fzh()) {
                        eVar.fzf();
                    }
                    f.a pauseReason = fVar.getPauseReason();
                    if (pauseReason == f.a.MOBILE_NET) {
                        eVar.fzc();
                    } else if (pauseReason == f.a.NO_NET) {
                        eVar.fza();
                        eVar.lg(eVar.getNoNetTip(), MMApplicationContext.getContext().getString(R.string.hxp));
                    }
                }
                eVar.getControlBar().setIsPlay(dFG);
                eVar.getControlBar().hide();
                eVar.getControlBar().setCurrentPlaySecond(this.Gmr.fyD().Nih);
                eVar.fyX();
                this.Gmr.a(gVar.GjH);
                gVar.fyy();
                gVar.fyx();
                eVar.fze();
                if (this.Gmr.fyB().GnT != null) {
                    this.Gmr.fyB().GnT.Gjs = 1;
                }
            }
        }
        AppMethodBeat.o(126249);
    }

    public d(b bVar) {
        super(bVar);
        this.Gmr = bVar;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.e
    public final void t(final List<eiw> list, boolean z) {
        AppMethodBeat.i(126248);
        super.t(list, z);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.topstory.ui.video.fs.d.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(126247);
                n fyO = d.this.GlS.fyO();
                int fzy = fyO.fzy();
                Log.i("MicroMsg.TopStory.TopStoryFSVideoAdapter", "callbackToSuccess originSize: %d insertSize %d", Integer.valueOf(fzy), Integer.valueOf(list.size()));
                List list = list;
                synchronized (fyO) {
                    try {
                        if (!Util.isNullOrNil(list)) {
                            fyO.GW().addAll(list);
                        }
                    } catch (Throwable th) {
                        AppMethodBeat.o(126247);
                        throw th;
                    }
                }
                d dVar = d.this;
                dVar.ci(fzy + dVar.getHeadersCount());
                AppMethodBeat.o(126247);
            }
        });
        AppMethodBeat.o(126248);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.e
    public final int abY(int i2) {
        return 0;
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ h a(ViewGroup viewGroup, int i2) {
        RecyclerView.v gVar;
        AppMethodBeat.i(126250);
        if (this.GlP.get(i2, null) != null) {
            gVar = new j((View) this.GlP.get(i2, null), this.GlS);
        } else if (this.GlQ.get(i2, null) != null) {
            gVar = new j((View) this.GlQ.get(i2, null), this.GlS);
        } else {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.c3w, (ViewGroup) null);
            inflate.setTag("video");
            gVar = new g(inflate, this.Gmr);
        }
        AppMethodBeat.o(126250);
        return gVar;
    }
}
