package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.ui.video.b;
import com.tencent.mm.plugin.topstory.ui.video.e;
import com.tencent.mm.plugin.topstory.ui.video.h;
import com.tencent.mm.plugin.topstory.ui.video.j;
import com.tencent.mm.plugin.topstory.ui.video.n;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.widget.a.f;
import java.lang.ref.WeakReference;
import java.util.List;

public final class i extends e {
    protected b Gmr;
    boolean Gpq;
    private boolean Gpr;
    private g Gps;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(h hVar, int i2) {
        boolean z = true;
        AppMethodBeat.i(126396);
        h hVar2 = hVar;
        Log.i("MicroMsg.TopStory.TopStoryOnlyFSVideoAdapter", "onBindViewHolder %d", Integer.valueOf(i2));
        if (!abZ(i2) && !aca(i2)) {
            int headersCount = i2 - getHeadersCount();
            g gVar = (g) hVar2;
            eiw acd = this.Gmr.fyO().acd(headersCount);
            gVar.d(acd);
            this.GlR.put(acd.psI, new WeakReference(gVar));
            if (headersCount == 0) {
                this.Gps = gVar;
            }
            if (this.Gpq && headersCount == 0) {
                if (!Util.isNullOrNil(acd.videoUrl)) {
                    if (this.Gmr.fyA().Gnu) {
                        z = false;
                    }
                    gVar.wu(z);
                    this.Gpq = false;
                    this.Gpr = false;
                } else {
                    this.Gpr = true;
                }
            }
            if (this.Gmr.fyB().GnT != null) {
                this.Gmr.fyB().GnT.Gjs = 1;
            }
        }
        AppMethodBeat.o(126396);
    }

    public i(b bVar) {
        super(bVar);
        this.Gmr = bVar;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.e
    public final void t(final List<eiw> list, final boolean z) {
        AppMethodBeat.i(126395);
        super.t(list, z);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.topstory.ui.video.fs.i.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(126394);
                n fyO = i.this.Gmr.fyO();
                synchronized (fyO) {
                    try {
                        List<eiw> GW = fyO.GW();
                        Log.i("MicroMsg.TopStory.TopStoryOnlyFSVideoAdapter", "callbackToSuccess originSize: %d insertSize %d", Integer.valueOf(GW.size()), Integer.valueOf(list.size()));
                        if (z) {
                            int size = GW.size();
                            if (GW.size() > 0) {
                                GW.clear();
                                GW.addAll(list);
                                if (i.this.Gpr) {
                                    i.this.atj.notifyChanged();
                                } else {
                                    if (!(i.this.Gps == null || GW == null || GW.get(0) == null)) {
                                        eiw eiw = GW.get(0);
                                        i.this.Gps.d(eiw);
                                        i.this.GlR.put(eiw.psI, new WeakReference(i.this.Gps));
                                        i.this.Gps = null;
                                        if ((eiw.Nix & 128) > 0 && g.aAh().azQ().getInt(ar.a.USERINFO_TOP_STORY_VIDEO_EDUCATION_INT, 0) <= 0) {
                                            i.this.GlS.getRecyclerView().postDelayed(new Runnable() {
                                                /* class com.tencent.mm.plugin.topstory.ui.video.fs.i.AnonymousClass1.AnonymousClass1 */

                                                public final void run() {
                                                    AppMethodBeat.i(126393);
                                                    f.a aVar = new f.a(MMApplicationContext.getContext());
                                                    aVar.bow(i.this.GlS.eeF().getString(R.string.hr1)).Dq(true);
                                                    aVar.apa(R.string.j34).b(new f.c() {
                                                        /* class com.tencent.mm.plugin.topstory.ui.video.fs.i.AnonymousClass1.AnonymousClass1.AnonymousClass2 */

                                                        @Override // com.tencent.mm.ui.widget.a.f.c
                                                        public final void e(boolean z, String str) {
                                                        }
                                                    }).b(new DialogInterface.OnDismissListener() {
                                                        /* class com.tencent.mm.plugin.topstory.ui.video.fs.i.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                                        public final void onDismiss(DialogInterface dialogInterface) {
                                                            AppMethodBeat.i(126392);
                                                            g.aAh().azQ().set(ar.a.USERINFO_TOP_STORY_VIDEO_EDUCATION_INT, (Object) 1);
                                                            g.aAh().azQ().gBI();
                                                            AppMethodBeat.o(126392);
                                                        }
                                                    }).show();
                                                    AppMethodBeat.o(126393);
                                                }
                                            }, 1000);
                                        }
                                    }
                                    i iVar = i.this;
                                    iVar.as(iVar.getHeadersCount() + size, list.size() - size);
                                }
                                i.this.Gmr.fyB().j((eiw) list.get(0));
                            } else {
                                GW.addAll(list);
                                i.this.as(i.this.getHeadersCount(), list.size());
                            }
                        } else {
                            int size2 = GW.size();
                            GW.addAll(list);
                            i iVar2 = i.this;
                            iVar2.ci(iVar2.getHeadersCount() + size2);
                            i iVar3 = i.this;
                            iVar3.as(size2 + iVar3.getHeadersCount(), list.size());
                        }
                    } finally {
                        AppMethodBeat.o(126394);
                    }
                }
            }
        });
        AppMethodBeat.o(126395);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.e
    public final int abY(int i2) {
        return 0;
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ h a(ViewGroup viewGroup, int i2) {
        RecyclerView.v jVar;
        AppMethodBeat.i(126397);
        if (this.GlP.get(i2, null) != null) {
            jVar = new j((View) this.GlP.get(i2, null), this.GlS);
        } else if (this.GlQ.get(i2, null) != null) {
            jVar = new j((View) this.GlQ.get(i2, null), this.GlS);
        } else {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.c3w, (ViewGroup) null);
            inflate.setTag("video");
            jVar = new j(inflate, this.Gmr);
        }
        AppMethodBeat.o(126397);
        return jVar;
    }
}
