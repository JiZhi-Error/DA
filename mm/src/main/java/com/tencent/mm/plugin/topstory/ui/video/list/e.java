package com.tencent.mm.plugin.topstory.ui.video.list;

import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.ui.video.f;
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

public final class e extends com.tencent.mm.plugin.topstory.ui.video.e {
    boolean GpB;
    private h GpC;
    boolean Gpq;
    private boolean Gpr;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ void a(h hVar, int i2) {
        AppMethodBeat.i(126427);
        h hVar2 = hVar;
        if (!abZ(i2) && !aca(i2)) {
            int headersCount = i2 - getHeadersCount();
            h hVar3 = (h) hVar2;
            eiw acd = ((b) this.GlS).fyO().acd(headersCount);
            hVar3.d(acd);
            this.GlR.put(acd.psI, new WeakReference(hVar3));
            if (headersCount == 0) {
                this.GpC = hVar3;
            }
            if (!this.Gpq || headersCount != 0) {
                ((b) this.GlS).fyB().j(acd);
            } else if (!Util.isNullOrNil(acd.videoUrl)) {
                hVar3.wu(!((b) this.GlS).fyA().Gnu);
                this.Gpq = false;
                ((b) this.GlS).fyB().j(acd);
                this.Gpr = false;
            } else {
                this.Gpr = true;
            }
            if (this.GpB && headersCount == ((b) this.GlS).fyD().Nig) {
                boolean dFG = ((b) this.GlS).fyF().dFG();
                Log.i("MicroMsg.TopStory.TopStoryListVideoAdapter", "full screen play %d %b", Integer.valueOf(((b) this.GlS).fyD().Nig), Boolean.valueOf(dFG));
                this.GpB = false;
                f fVar = ((b) this.GlS).fyF().GnY;
                f fVar2 = hVar3.GpP;
                if (fVar.fzh()) {
                    fVar2.fzf();
                }
                ((b) this.GlS).fyF().a(hVar3.GpP, hVar3.GpP.c(acd));
                if (!(fVar == null || fVar == fVar2)) {
                    f.a pauseReason = fVar.getPauseReason();
                    if (pauseReason == f.a.MOBILE_NET) {
                        fVar2.fzc();
                    } else if (pauseReason == f.a.NO_NET) {
                        fVar2.fza();
                        fVar2.lg(fVar2.getNoNetTip(), MMApplicationContext.getContext().getString(R.string.hxp));
                    }
                }
                fVar2.getControlBar().setIsPlay(dFG);
                fVar2.getControlBar().setCurrentPlaySecond(((b) this.GlS).fyD().Nih);
                ((b) this.GlS).a(hVar3.GjH);
                fVar2.fyX();
                fVar2.fze();
                hVar3.fzR();
                hVar3.fyy();
                hVar3.fyx();
            }
        }
        AppMethodBeat.o(126427);
    }

    public e(b bVar) {
        super(bVar);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.e
    public final void t(final List<eiw> list, final boolean z) {
        AppMethodBeat.i(126425);
        super.t(list, z);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.topstory.ui.video.list.e.AnonymousClass1 */

            public final void run() {
                boolean z;
                AppMethodBeat.i(126424);
                n fyO = e.a(e.this).fyO();
                synchronized (fyO) {
                    try {
                        List<eiw> GW = fyO.GW();
                        Log.i("MicroMsg.TopStory.TopStoryListVideoAdapter", "callbackToSuccess originSize: %d insertSize %d", Integer.valueOf(GW.size()), Integer.valueOf(list.size()));
                        if (z) {
                            int size = GW.size();
                            if (GW.size() > 0) {
                                if (!GW.get(0).psI.equals(((eiw) list.get(0)).psI)) {
                                    list.remove(0);
                                    z = false;
                                } else {
                                    GW.clear();
                                    z = true;
                                }
                                GW.addAll(list);
                                if (z) {
                                    eiw eiw = (eiw) list.get(0);
                                    GW.set(0, eiw);
                                    h b2 = e.this.b(eiw);
                                    if (b2 != null) {
                                        b2.d(eiw);
                                    }
                                }
                                if (e.this.Gpr) {
                                    e.this.atj.notifyChanged();
                                } else {
                                    if (!(e.this.GpC == null || GW == null || GW.get(0) == null)) {
                                        eiw eiw2 = GW.get(0);
                                        e.this.GpC.d(eiw2);
                                        e.this.GlR.put(eiw2.psI, new WeakReference(e.this.GpC));
                                        e.this.GpC = null;
                                        if ((eiw2.Nix & 128) > 0 && g.aAh().azQ().getInt(ar.a.USERINFO_TOP_STORY_VIDEO_EDUCATION_INT, 0) <= 0) {
                                            e.this.GlS.getRecyclerView().postDelayed(new Runnable() {
                                                /* class com.tencent.mm.plugin.topstory.ui.video.list.e.AnonymousClass1.AnonymousClass1 */

                                                public final void run() {
                                                    AppMethodBeat.i(126423);
                                                    Log.i("MicroMsg.TopStory.TopStoryListVideoAdapter", "show education pop window");
                                                    f.a aVar = new f.a(MMApplicationContext.getContext());
                                                    aVar.bow(e.this.GlS.eeF().getString(R.string.hr1)).Dq(true);
                                                    aVar.apa(R.string.w1).b(new f.c() {
                                                        /* class com.tencent.mm.plugin.topstory.ui.video.list.e.AnonymousClass1.AnonymousClass1.AnonymousClass2 */

                                                        @Override // com.tencent.mm.ui.widget.a.f.c
                                                        public final void e(boolean z, String str) {
                                                        }
                                                    }).b(new DialogInterface.OnDismissListener() {
                                                        /* class com.tencent.mm.plugin.topstory.ui.video.list.e.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                                        public final void onDismiss(DialogInterface dialogInterface) {
                                                            AppMethodBeat.i(126422);
                                                            g.aAh().azQ().set(ar.a.USERINFO_TOP_STORY_VIDEO_EDUCATION_INT, (Object) 1);
                                                            AppMethodBeat.o(126422);
                                                        }
                                                    }).show();
                                                    AppMethodBeat.o(126423);
                                                }
                                            }, 1000);
                                        }
                                    }
                                    e eVar = e.this;
                                    eVar.as(eVar.getHeadersCount() + size, list.size() - size);
                                }
                                e.a(e.this).fyB().j(GW.get(0));
                            } else {
                                GW.addAll(list);
                                e.this.as(e.this.getHeadersCount(), list.size());
                            }
                        } else {
                            int size2 = GW.size();
                            GW.addAll(list);
                            e eVar2 = e.this;
                            eVar2.as(size2 + eVar2.getHeadersCount(), list.size());
                        }
                    } finally {
                        AppMethodBeat.o(126424);
                    }
                }
            }
        });
        AppMethodBeat.o(126425);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.e
    public final int abY(int i2) {
        AppMethodBeat.i(126426);
        if (Util.isNullOrNil(((b) this.GlS).fyO().acd(i2 - getHeadersCount()).xuO)) {
            AppMethodBeat.o(126426);
            return 0;
        }
        AppMethodBeat.o(126426);
        return 1;
    }

    /* Return type fixed from 'android.support.v7.widget.RecyclerView$v' to match base method */
    @Override // android.support.v7.widget.RecyclerView.a
    public final /* synthetic */ h a(ViewGroup viewGroup, int i2) {
        RecyclerView.v hVar;
        AppMethodBeat.i(126428);
        if (this.GlP.get(i2, null) != null) {
            hVar = new j((View) this.GlP.get(i2, null), this.GlS);
        } else if (this.GlQ.get(i2, null) != null) {
            hVar = new j((View) this.GlQ.get(i2, null), this.GlS);
        } else {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.c4_, (ViewGroup) null);
            inflate.setTag("video");
            if (i2 == 0) {
                hVar = new h(inflate, (b) this.GlS, false);
            } else {
                hVar = new h(inflate, (b) this.GlS, true);
            }
        }
        AppMethodBeat.o(126428);
        return hVar;
    }

    static /* synthetic */ b a(e eVar) {
        return (b) eVar.GlS;
    }
}
