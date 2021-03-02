package com.tencent.mm.plugin.mv.ui.uic;

import android.arch.lifecycle.ViewModel;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.emoji.panel.layout.a;
import com.tencent.mm.g.a.abj;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.cgi.av;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.ac;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.upload.g;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.plugin.mv.a.e;
import com.tencent.mm.plugin.mv.ui.view.MusicMvLyricView;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.thumbplayer.view.MMMvVideoLayout;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ars;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.axz;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.crx;
import com.tencent.mm.protocal.protobuf.crz;
import com.tencent.mm.protocal.protobuf.csb;
import com.tencent.mm.protocal.protobuf.csd;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.protocal.protobuf.cxr;
import com.tencent.mm.protocal.protobuf.ecq;
import com.tencent.mm.protocal.protobuf.epf;
import com.tencent.mm.protocal.protobuf.mp;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.layoutmanager.Flip3DLayoutManager;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.xeffect.effect.EffectManager;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bn;

public final class MusicMvMainUIC extends UIComponent {
    private static final Object Auk = new Object();
    public static final a Aul = new a((byte) 0);
    private final d.a AhI;
    private ArrayList<com.tencent.mm.plugin.mv.ui.a.b> AtU = new ArrayList<>();
    private final kotlin.f AtV;
    final com.tencent.mm.emoji.panel.layout.a AtW;
    MMMvVideoLayout AtX;
    private boolean AtY;
    private boolean AtZ;
    private boolean Aua;
    private Flip3DLayoutManager Aub;
    boolean Auc;
    boolean Aud;
    private int Aue;
    private final k Auf;
    private final l Aug;
    private final IListener<mx> Auh;
    private final com.tencent.mm.ak.i Aui;
    private final com.tencent.mm.plugin.finder.upload.q Auj;
    public final String TAG = "MicroMsg.Mv.MusicMvMainUIC";
    volatile com.tencent.mm.plugin.mv.a.o Vab;
    private boolean Vac;
    private final q Vad;
    private float dep;
    public ArrayList<com.tencent.mm.plugin.mv.ui.a.b> kgc = new ArrayList<>();
    int tex;
    private int uGY;
    WxRecyclerView ufR;
    private long xHU;

    public final WxRecyclerAdapter<com.tencent.mm.plugin.mv.ui.a.b> getAdapter() {
        AppMethodBeat.i(257182);
        WxRecyclerAdapter<com.tencent.mm.plugin.mv.ui.a.b> wxRecyclerAdapter = (WxRecyclerAdapter) this.AtV.getValue();
        AppMethodBeat.o(257182);
        return wxRecyclerAdapter;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MusicMvMainUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        kotlin.g.b.p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(257195);
        this.AtV = kotlin.g.ah(new b(this, appCompatActivity));
        this.AhI = new s(this);
        this.AtW = new com.tencent.mm.emoji.panel.layout.a();
        this.tex = -1;
        this.Aub = new Flip3DLayoutManager(appCompatActivity);
        this.xHU = -1;
        this.dep = -1.0f;
        this.Aue = -1;
        this.Auf = new k(this);
        this.Aug = new l(this);
        this.Auh = new e(this, appCompatActivity);
        this.Aui = new o(this, appCompatActivity);
        this.Auj = new d(this, appCompatActivity);
        this.Vad = new q(this, appCompatActivity);
        AppMethodBeat.o(257195);
    }

    public static final /* synthetic */ void a(MusicMvMainUIC musicMvMainUIC, csb csb) {
        AppMethodBeat.i(259265);
        musicMvMainUIC.a(csb);
        AppMethodBeat.o(259265);
    }

    public static final /* synthetic */ void d(MusicMvMainUIC musicMvMainUIC) {
        AppMethodBeat.i(259264);
        musicMvMainUIC.hWF();
        AppMethodBeat.o(259264);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(257196);
        AppMethodBeat.o(257196);
    }

    /* access modifiers changed from: package-private */
    public static final class s implements d.a {
        final /* synthetic */ MusicMvMainUIC Aum;

        s(MusicMvMainUIC musicMvMainUIC) {
            this.Aum = musicMvMainUIC;
        }

        @Override // com.tencent.mm.plugin.music.f.a.d.a
        public final void fn(final int i2, final int i3) {
            AppMethodBeat.i(259251);
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.mv.ui.uic.MusicMvMainUIC.s.AnonymousClass1 */
                final /* synthetic */ s Vag;

                {
                    this.Vag = r2;
                }

                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    com.tencent.mm.plugin.mv.a.o oVar;
                    AppMethodBeat.i(259250);
                    if (i2 >= 0 && i3 >= 0 && (oVar = this.Vag.Aum.Vab) != null) {
                        Log.i(this.Vag.Aum.TAG, "onVideoProgressUpdate : currentPos :" + i2 + "  totalDuration:" + i3 + " maxPlayPercent :" + oVar.vfY + " maxPlayLength:" + oVar.vfX + " retryPlayTimes:" + oVar.UZx);
                        if (i2 < oVar.vfX) {
                            oVar.UZx++;
                        }
                        oVar.vfX = i2;
                        oVar.vfY = (int) ((100.0f * ((float) i2)) / ((float) i3));
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(259250);
                    return xVar;
                }
            });
            AppMethodBeat.o(259251);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(257183);
        com.tencent.mm.kernel.g.azz().a(6860, this.Aui);
        com.tencent.mm.kernel.g.azz().a(3763, this.Aui);
        com.tencent.mm.kernel.g.azz().a(5292, this.Aui);
        com.tencent.mm.kernel.g.azz().a(5904, this.Aui);
        com.tencent.mm.kernel.g.azz().a(5286, this.Aui);
        com.tencent.mm.kernel.g.azz().a(3627, this.Aui);
        g.a aVar = com.tencent.mm.plugin.finder.upload.g.vSJ;
        com.tencent.mm.plugin.finder.upload.g.vSH.a(this.Auj);
        this.Vad.alive();
        AppMethodBeat.o(257183);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x028d, code lost:
        if (r2 == null) goto L_0x028f;
     */
    @Override // com.tencent.mm.ui.component.UIComponent
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreateAfter(android.os.Bundle r15) {
        /*
        // Method dump skipped, instructions count: 711
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mv.ui.uic.MusicMvMainUIC.onCreateAfter(android.os.Bundle):void");
    }

    public static final class f extends RecyclerView.q {
        final /* synthetic */ MusicMvMainUIC Aum;

        f(MusicMvMainUIC musicMvMainUIC) {
            this.Aum = musicMvMainUIC;
        }

        @Override // android.support.v7.widget.RecyclerView.k, android.support.v7.widget.RecyclerView.q
        public final boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
            AppMethodBeat.i(257161);
            kotlin.g.b.p.h(recyclerView, "rv");
            kotlin.g.b.p.h(motionEvent, "e");
            boolean a2 = MusicMvMainUIC.a(this.Aum, motionEvent);
            AppMethodBeat.o(257161);
            return a2;
        }
    }

    public static final class g implements a.c {
        final /* synthetic */ MusicMvMainUIC Aum;

        g(MusicMvMainUIC musicMvMainUIC) {
            this.Aum = musicMvMainUIC;
        }

        @Override // com.tencent.mm.emoji.panel.layout.a.c
        public final void pq(int i2) {
            RecyclerView.v ch;
            RecyclerView recyclerView = null;
            AppMethodBeat.i(257162);
            Log.i(this.Aum.TAG, "onPageSettle:" + i2 + ", lastPos:" + this.Aum.tex);
            if (this.Aum.tex == i2) {
                AppMethodBeat.o(257162);
                return;
            }
            if (this.Aum.Vac) {
                SecDataUIC.a aVar = SecDataUIC.CWq;
                cst cst = (cst) SecDataUIC.a.a(this.Aum.getContext(), 7, cst.class);
                if (cst != null) {
                    cst.scene = 13;
                }
            }
            this.Aum.Vac = false;
            WxRecyclerView wxRecyclerView = this.Aum.ufR;
            View view = (wxRecyclerView == null || (ch = wxRecyclerView.ch(i2)) == null) ? null : ch.aus;
            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
            MusicMvLyricUIC musicMvLyricUIC = (MusicMvLyricUIC) com.tencent.mm.ui.component.a.b(this.Aum.getActivity()).get(MusicMvLyricUIC.class);
            musicMvLyricUIC.aus = view;
            MusicMvLyricView evQ = musicMvLyricUIC.evQ();
            if (evQ != null) {
                evQ.setEventListener(null);
            }
            if (view != null) {
                recyclerView = (RecyclerView) view.findViewById(R.id.f5j);
            }
            musicMvLyricUIC.AtK = recyclerView;
            MusicMvLyricView evQ2 = musicMvLyricUIC.evQ();
            if (evQ2 != null) {
                evQ2.setEventListener(musicMvLyricUIC.AtQ);
            }
            com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
            com.tencent.mm.plugin.mv.ui.a.b bVar = this.Aum.kgc.get(i2);
            kotlin.g.b.p.g(bVar, "dataList[position]");
            ((MusicMvCommentUIC) com.tencent.mm.ui.component.a.b(this.Aum.getActivity()).get(MusicMvCommentUIC.class)).a(view, bVar);
            MusicMvMainUIC.a(this.Aum, i2);
            this.Aum.tex = i2;
            this.Aum.axd(i2);
            AppMethodBeat.o(257162);
        }
    }

    static final class h implements Runnable {
        final /* synthetic */ MusicMvMainUIC Aum;

        h(MusicMvMainUIC musicMvMainUIC) {
            this.Aum = musicMvMainUIC;
        }

        public final void run() {
            AppMethodBeat.i(257163);
            this.Aum.AtW.f(this.Aum.ufR);
            AppMethodBeat.o(257163);
        }
    }

    public static final class i extends RecyclerView.c {
        final /* synthetic */ MusicMvMainUIC Aum;

        i(MusicMvMainUIC musicMvMainUIC) {
            this.Aum = musicMvMainUIC;
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onChanged() {
            WxRecyclerView wxRecyclerView;
            AppMethodBeat.i(257166);
            super.onChanged();
            Log.d(this.Aum.TAG, "onChanged, lastPos:" + this.Aum.tex + ", dataList.size:" + this.Aum.kgc.size());
            if (this.Aum.kgc.size() <= 0 || this.Aum.tex < 0 || (wxRecyclerView = this.Aum.ufR) == null) {
                AppMethodBeat.o(257166);
                return;
            }
            wxRecyclerView.post(new a(this));
            AppMethodBeat.o(257166);
        }

        static final class a implements Runnable {
            final /* synthetic */ i Aur;

            a(i iVar) {
                this.Aur = iVar;
            }

            public final void run() {
                RecyclerView.v ch;
                AppMethodBeat.i(257164);
                MusicMvMainUIC.a(this.Aur.Aum, this.Aur.Aum.tex);
                WxRecyclerView wxRecyclerView = this.Aur.Aum.ufR;
                View view = (wxRecyclerView == null || (ch = wxRecyclerView.ch(this.Aur.Aum.tex)) == null) ? null : ch.aus;
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                com.tencent.mm.plugin.mv.ui.a.b bVar = this.Aur.Aum.kgc.get(this.Aur.Aum.tex);
                kotlin.g.b.p.g(bVar, "dataList[lastPos]");
                ((MusicMvCommentUIC) com.tencent.mm.ui.component.a.b(this.Aur.Aum.getActivity()).get(MusicMvCommentUIC.class)).a(view, bVar);
                AppMethodBeat.o(257164);
            }
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeChanged(int i2, int i3, Object obj) {
            AppMethodBeat.i(257167);
            Log.i(this.Aum.TAG, "onItemRangeChanged, lastPos:" + this.Aum.tex + ", positionStart:" + i2 + ", itemCount:" + i3 + ", dataList.size:" + this.Aum.kgc.size() + ", payLoad:" + obj);
            a aVar = MusicMvMainUIC.Aul;
            if (!kotlin.g.b.p.j(obj, MusicMvMainUIC.Auk)) {
                super.onItemRangeChanged(i2, i3, obj);
            }
            AppMethodBeat.o(257167);
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeChanged(int i2, int i3) {
            WxRecyclerView wxRecyclerView;
            AppMethodBeat.i(257168);
            super.onItemRangeChanged(i2, i3);
            Log.i(this.Aum.TAG, "onItemRangeChanged, lastPos:" + this.Aum.tex + ", positionStart:" + i2 + ", itemCount:" + i3 + ", dataList.size:" + this.Aum.kgc.size());
            if (this.Aum.kgc.size() > 0 && this.Aum.tex >= 0) {
                int i4 = i2 + i3;
                int i5 = this.Aum.tex;
                if (i2 > i5) {
                    AppMethodBeat.o(257168);
                    return;
                } else if (i4 > i5 && !this.Aum.AtW.hbN && (wxRecyclerView = this.Aum.ufR) != null) {
                    wxRecyclerView.post(new b(this));
                    AppMethodBeat.o(257168);
                    return;
                }
            }
            AppMethodBeat.o(257168);
        }

        static final class b implements Runnable {
            final /* synthetic */ i Aur;

            b(i iVar) {
                this.Aur = iVar;
            }

            public final void run() {
                RecyclerView.v ch;
                AppMethodBeat.i(257165);
                MusicMvMainUIC.a(this.Aur.Aum, this.Aur.Aum.tex);
                WxRecyclerView wxRecyclerView = this.Aur.Aum.ufR;
                View view = (wxRecyclerView == null || (ch = wxRecyclerView.ch(this.Aur.Aum.tex)) == null) ? null : ch.aus;
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                com.tencent.mm.plugin.mv.ui.a.b bVar = this.Aur.Aum.kgc.get(this.Aur.Aum.tex);
                kotlin.g.b.p.g(bVar, "dataList[lastPos]");
                ((MusicMvCommentUIC) com.tencent.mm.ui.component.a.b(this.Aur.Aum.getActivity()).get(MusicMvCommentUIC.class)).a(view, bVar);
                AppMethodBeat.o(257165);
            }
        }
    }

    public static final class j implements com.tencent.mm.plugin.mv.ui.uic.a.a {
        final /* synthetic */ MusicMvMainUIC Aum;

        j(MusicMvMainUIC musicMvMainUIC) {
            this.Aum = musicMvMainUIC;
        }

        @Override // com.tencent.mm.plugin.mv.ui.uic.a.a
        public final void B(long j2, String str) {
            AppMethodBeat.i(257169);
            kotlin.g.b.p.h(str, "nonceId");
            MusicMvMainUIC musicMvMainUIC = this.Aum;
            kotlin.g.b.p.h(str, "nonceId");
            Log.i(musicMvMainUIC.TAG, "start to switchToMv from id dataList.size:" + musicMvMainUIC.kgc.size());
            int i2 = 0;
            boolean z = false;
            for (T t : musicMvMainUIC.kgc) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    kotlin.a.j.hxH();
                }
                e.a aVar = com.tencent.mm.plugin.mv.a.e.ApR;
                FinderObject a2 = e.a.a(t.ArY);
                if (a2 != null) {
                    if (a2.id == j2 && kotlin.g.b.p.j(a2.objectNonceId, str)) {
                        z = true;
                        Log.i(musicMvMainUIC.TAG, "switchToMv exist index:".concat(String.valueOf(i2)));
                        musicMvMainUIC.hWF();
                        SecDataUIC.a aVar2 = SecDataUIC.CWq;
                        cst cst = (cst) SecDataUIC.a.a(musicMvMainUIC.getContext(), 7, cst.class);
                        if (cst != null) {
                            cst.scene = 11;
                        }
                        musicMvMainUIC.To(i2);
                    }
                    i2 = i3;
                    z = z;
                } else {
                    i2 = i3;
                }
            }
            if (!z) {
                Log.i(musicMvMainUIC.TAG, "switchToMv not exist");
                ArrayList<com.tencent.mm.plugin.mv.ui.a.b> arrayList = musicMvMainUIC.kgc;
                com.tencent.mm.plugin.mv.a.e eVar = new com.tencent.mm.plugin.mv.a.e();
                eVar.ApE = Long.valueOf(j2);
                eVar.ApF = str;
                musicMvMainUIC.a(j2, str, eVar);
                arrayList.add(new com.tencent.mm.plugin.mv.ui.a.b(eVar));
                int size = musicMvMainUIC.kgc.size() - 1;
                musicMvMainUIC.hWF();
                Log.i(musicMvMainUIC.TAG, "switchToMv final index:" + size + ", dataList.size:" + musicMvMainUIC.kgc.size());
                musicMvMainUIC.getAdapter().cj(size);
                SecDataUIC.a aVar3 = SecDataUIC.CWq;
                cst cst2 = (cst) SecDataUIC.a.a(musicMvMainUIC.getContext(), 7, cst.class);
                if (cst2 != null) {
                    cst2.scene = 11;
                }
                musicMvMainUIC.To(size);
            }
            AppMethodBeat.o(257169);
        }
    }

    public final void hWF() {
        AppMethodBeat.i(259254);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ViewModel viewModel = com.tencent.mm.ui.component.a.b(getActivity()).get(MusicMvDataUIC.class);
        kotlin.g.b.p.g(viewModel, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
        MusicMvDataUIC musicMvDataUIC = (MusicMvDataUIC) viewModel;
        com.tencent.mm.plugin.mv.ui.a.b bVar = (com.tencent.mm.plugin.mv.ui.a.b) kotlin.a.j.L(this.kgc, this.tex);
        if (bVar != null) {
            com.tencent.mm.plugin.mv.a.k kVar = com.tencent.mm.plugin.mv.a.k.Aql;
            com.tencent.mm.plugin.mv.a.k.b(getContext(), musicMvDataUIC.Aqo, bVar.ArY);
        }
        a(musicMvDataUIC);
        AppMethodBeat.o(259254);
    }

    private final void a(MusicMvDataUIC musicMvDataUIC) {
        AppMethodBeat.i(259255);
        com.tencent.mm.plugin.mv.a.o oVar = this.Vab;
        if (oVar != null) {
            com.tencent.mm.plugin.mv.ui.a.b bVar = (com.tencent.mm.plugin.mv.ui.a.b) kotlin.a.j.L(this.kgc, this.tex);
            if (bVar != null) {
                com.tencent.mm.plugin.mv.a.k kVar = com.tencent.mm.plugin.mv.a.k.Aql;
                com.tencent.mm.plugin.mv.a.k.a(getContext(), musicMvDataUIC.Aqo, bVar.ArY, oVar);
                AppMethodBeat.o(259255);
                return;
            }
            AppMethodBeat.o(259255);
            return;
        }
        AppMethodBeat.o(259255);
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01ab  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0261  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(com.tencent.mm.protocal.protobuf.axy r13, com.tencent.mm.pluginsdk.model.app.al r14) {
        /*
        // Method dump skipped, instructions count: 774
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mv.ui.uic.MusicMvMainUIC.a(com.tencent.mm.protocal.protobuf.axy, com.tencent.mm.pluginsdk.model.app.al):int");
    }

    public final void To(int i2) {
        AppMethodBeat.i(257186);
        if (i2 == this.AtW.hbQ) {
            AppMethodBeat.o(257186);
            return;
        }
        Log.i(this.TAG, "scrollMvToPosition:" + i2 + ", snapPosition:" + this.AtW.hbQ + ", dataList.size:" + this.kgc.size());
        this.Aub.Rpy = true;
        if (i2 > this.AtW.hbQ) {
            WxRecyclerView wxRecyclerView = this.ufR;
            if (wxRecyclerView != null) {
                com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(i2 - 1, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(wxRecyclerView, a2.axQ(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC", "scrollMvToPosition", "(I)V", "Undefined", "scrollToPosition", "(I)V");
                wxRecyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(wxRecyclerView, "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC", "scrollMvToPosition", "(I)V", "Undefined", "scrollToPosition", "(I)V");
            }
        } else {
            WxRecyclerView wxRecyclerView2 = this.ufR;
            if (wxRecyclerView2 != null) {
                com.tencent.mm.hellhoundlib.b.a a3 = com.tencent.mm.hellhoundlib.b.c.a(i2 + 1, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(wxRecyclerView2, a3.axQ(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC", "scrollMvToPosition", "(I)V", "Undefined", "scrollToPosition", "(I)V");
                wxRecyclerView2.scrollToPosition(((Integer) a3.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(wxRecyclerView2, "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC", "scrollMvToPosition", "(I)V", "Undefined", "scrollToPosition", "(I)V");
            }
        }
        WxRecyclerView wxRecyclerView3 = this.ufR;
        if (wxRecyclerView3 != null) {
            wxRecyclerView3.post(new p(this, i2));
            AppMethodBeat.o(257186);
            return;
        }
        AppMethodBeat.o(257186);
    }

    public static final class p implements Runnable {
        final /* synthetic */ MusicMvMainUIC Aum;
        final /* synthetic */ int gUj;

        p(MusicMvMainUIC musicMvMainUIC, int i2) {
            this.Aum = musicMvMainUIC;
            this.gUj = i2;
        }

        public final void run() {
            AppMethodBeat.i(257181);
            Log.i(this.Aum.TAG, "post stopScroll");
            WxRecyclerView wxRecyclerView = this.Aum.ufR;
            if (wxRecyclerView != null) {
                wxRecyclerView.kQ();
            }
            WxRecyclerView wxRecyclerView2 = this.Aum.ufR;
            if (wxRecyclerView2 != null) {
                wxRecyclerView2.post(new Runnable(this) {
                    /* class com.tencent.mm.plugin.mv.ui.uic.MusicMvMainUIC.p.AnonymousClass1 */
                    final /* synthetic */ p Aux;

                    {
                        this.Aux = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(257180);
                        Log.i(this.Aux.Aum.TAG, "post smooth scroll");
                        WxRecyclerView wxRecyclerView = this.Aux.Aum.ufR;
                        if (wxRecyclerView != null) {
                            com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(this.Aux.gUj, new com.tencent.mm.hellhoundlib.b.a());
                            com.tencent.mm.hellhoundlib.a.a.a(wxRecyclerView, a2.axQ(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$scrollMvToPosition$1$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                            wxRecyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
                            com.tencent.mm.hellhoundlib.a.a.a(wxRecyclerView, "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC$scrollMvToPosition$1$1", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
                            AppMethodBeat.o(257180);
                            return;
                        }
                        AppMethodBeat.o(257180);
                    }
                });
                AppMethodBeat.o(257181);
                return;
            }
            AppMethodBeat.o(257181);
        }
    }

    public final void evT() {
        this.Aub.Rpy = true;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        int i2;
        AppMethodBeat.i(257187);
        super.onResume();
        Log.i(this.TAG, "onResume, needResumePosition:" + this.AtY + ", isJumpToApp:" + this.Aua);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ViewModel viewModel = com.tencent.mm.ui.component.a.b(getActivity()).get(MusicMvDataUIC.class);
        kotlin.g.b.p.g(viewModel, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
        MusicMvDataUIC musicMvDataUIC = (MusicMvDataUIC) viewModel;
        com.tencent.mm.plugin.music.e.k euj = com.tencent.mm.plugin.music.e.k.euj();
        kotlin.g.b.p.g(euj, "MusicPlayerManager.Instance()");
        com.tencent.mm.ay.f etU = euj.etU();
        if (!musicMvDataUIC.f(etU)) {
            Log.i(this.TAG, "onResume different music firstTimeEnterMusicId:" + musicMvDataUIC.Ato + ' ');
            ac acVar = ac.vER;
            axy axy = musicMvDataUIC.Aqo;
            String str = musicMvDataUIC.Ato;
            if (str == null) {
                str = musicMvDataUIC.Aqo.AqO;
            }
            if (str == null) {
                str = "";
            }
            Integer num = musicMvDataUIC.UZU;
            if (num != null) {
                i2 = num.intValue();
            } else {
                i2 = 0;
            }
            String str2 = musicMvDataUIC.Atp.coverUrl;
            if (str2 == null) {
                str2 = "";
            }
            ac.a(axy, str, i2, str2);
            this.AtZ = true;
            WxRecyclerView wxRecyclerView = this.ufR;
            if (wxRecyclerView != null) {
                wxRecyclerView.post(new m(this));
            }
        } else if (this.AtY || this.Aua) {
            String str3 = this.TAG;
            StringBuilder append = new StringBuilder("onResume same music ").append(etU.jeV).append(' ').append(etU.jeT).append(", musicPlayer.isPlaying:");
            com.tencent.mm.plugin.music.e.k euj2 = com.tencent.mm.plugin.music.e.k.euj();
            kotlin.g.b.p.g(euj2, "MusicPlayerManager.Instance()");
            com.tencent.mm.plugin.music.f.a.d etW = euj2.etW();
            kotlin.g.b.p.g(etW, "MusicPlayerManager.Instance().musicPlayer");
            Log.i(str3, append.append(etW.bec()).toString());
            WxRecyclerView wxRecyclerView2 = this.ufR;
            if (wxRecyclerView2 != null) {
                wxRecyclerView2.post(new n(this));
            }
        }
        this.AtY = false;
        com.tencent.mm.plugin.music.e.k euj3 = com.tencent.mm.plugin.music.e.k.euj();
        kotlin.g.b.p.g(euj3, "MusicPlayerManager.Instance()");
        euj3.etW().b(this.AhI);
        AppMethodBeat.o(257187);
    }

    static final class m implements Runnable {
        final /* synthetic */ MusicMvMainUIC Aum;

        m(MusicMvMainUIC musicMvMainUIC) {
            this.Aum = musicMvMainUIC;
        }

        public final void run() {
            AppMethodBeat.i(257176);
            MusicMvMainUIC.a(this.Aum, this.Aum.tex);
            WxRecyclerAdapter<com.tencent.mm.plugin.mv.ui.a.b> adapter = this.Aum.getAdapter();
            int i2 = this.Aum.tex;
            a aVar = MusicMvMainUIC.Aul;
            adapter.e(i2, 1, MusicMvMainUIC.Auk);
            AppMethodBeat.o(257176);
        }
    }

    static final class n implements Runnable {
        final /* synthetic */ MusicMvMainUIC Aum;

        n(MusicMvMainUIC musicMvMainUIC) {
            this.Aum = musicMvMainUIC;
        }

        public final void run() {
            AppMethodBeat.i(257177);
            MMMvVideoLayout mMMvVideoLayout = this.Aum.AtX;
            if (mMMvVideoLayout != null) {
                mMMvVideoLayout.resume();
            }
            WxRecyclerAdapter<com.tencent.mm.plugin.mv.ui.a.b> adapter = this.Aum.getAdapter();
            int i2 = this.Aum.tex;
            a aVar = MusicMvMainUIC.Aul;
            adapter.e(i2, 1, MusicMvMainUIC.Auk);
            com.tencent.mm.plugin.music.e.k euj = com.tencent.mm.plugin.music.e.k.euj();
            kotlin.g.b.p.g(euj, "MusicPlayerManager.Instance()");
            com.tencent.mm.plugin.music.f.a.d etW = euj.etW();
            kotlin.g.b.p.g(etW, "MusicPlayerManager.Instance().musicPlayer");
            if (!etW.bec()) {
                if (this.Aum.Aua) {
                    this.Aum.axd(this.Aum.tex);
                    com.tencent.mm.plugin.music.e.k euj2 = com.tencent.mm.plugin.music.e.k.euj();
                    kotlin.g.b.p.g(euj2, "MusicPlayerManager.Instance()");
                    euj2.etW().resume();
                } else {
                    MMMvVideoLayout mMMvVideoLayout2 = this.Aum.AtX;
                    if (mMMvVideoLayout2 != null) {
                        mMMvVideoLayout2.setPauseVideoOnPlay(true);
                    }
                }
            }
            this.Aum.Aua = false;
            AppMethodBeat.o(257177);
        }
    }

    public final void axd(int i2) {
        com.tencent.mm.plugin.mv.a.e eVar;
        long j2;
        AppMethodBeat.i(259257);
        Log.v(this.TAG, "alvinluo updateFloatBallMvInfo position: %s", Integer.valueOf(i2));
        Intent intent = getActivity().getIntent();
        com.tencent.mm.plugin.music.model.b.as(intent != null ? intent.getExtras() : null);
        com.tencent.mm.plugin.mv.ui.a.b bVar = (com.tencent.mm.plugin.mv.ui.a.b) kotlin.a.j.L(this.kgc, i2);
        if (bVar == null || (eVar = bVar.ArY) == null) {
            AppMethodBeat.o(259257);
            return;
        }
        eVar.UZl = 0;
        eVar.UZm = 0;
        css css = new css();
        Long l2 = eVar.ApE;
        if (l2 != null) {
            j2 = l2.longValue();
        } else {
            j2 = 0;
        }
        css.Ktn = com.tencent.mm.ac.d.zs(j2);
        css.Kto = eVar.ApF;
        css.Ktp = eVar.coverUrl;
        css.Ktq = eVar.ApG;
        com.tencent.mm.plugin.music.model.b.c(css);
        AppMethodBeat.o(259257);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(257188);
        Log.i(this.TAG, "onDestroy");
        g.a aVar = com.tencent.mm.plugin.finder.upload.g.vSJ;
        com.tencent.mm.plugin.finder.upload.g.vSH.b(this.Auj);
        com.tencent.mm.kernel.g.azz().b(6860, this.Aui);
        com.tencent.mm.kernel.g.azz().b(3763, this.Aui);
        com.tencent.mm.kernel.g.azz().b(5292, this.Aui);
        com.tencent.mm.kernel.g.azz().b(5904, this.Aui);
        com.tencent.mm.kernel.g.azz().b(5286, this.Aui);
        com.tencent.mm.kernel.g.azz().b(3627, this.Aui);
        MMMvVideoLayout mMMvVideoLayout = this.AtX;
        if (mMMvVideoLayout != null) {
            mMMvVideoLayout.recycle();
        }
        this.Auh.dead();
        this.AtY = false;
        this.Vad.dead();
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        ViewModel viewModel = com.tencent.mm.ui.component.a.b(getActivity()).get(MusicMvDataUIC.class);
        kotlin.g.b.p.g(viewModel, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
        MusicMvDataUIC musicMvDataUIC = (MusicMvDataUIC) viewModel;
        com.tencent.mm.plugin.mv.a.k kVar = com.tencent.mm.plugin.mv.a.k.Aql;
        com.tencent.mm.plugin.mv.a.k.b(getContext(), musicMvDataUIC.Aqo, this.kgc.get(this.tex).ArY);
        com.tencent.mm.plugin.mv.a.k kVar2 = com.tencent.mm.plugin.mv.a.k.Aql;
        AppCompatActivity activity = getActivity();
        com.tencent.mm.plugin.mv.a.e eVar = this.kgc.get(this.tex).ArY;
        MMMvVideoLayout mMMvVideoLayout2 = this.AtX;
        com.tencent.mm.plugin.mv.a.k.a(activity, eVar, mMMvVideoLayout2 != null ? mMMvVideoLayout2.getReportInfo() : null);
        a(musicMvDataUIC);
        AppMethodBeat.o(257188);
    }

    public static final class k implements a.b {
        final /* synthetic */ MusicMvMainUIC Aum;

        k(MusicMvMainUIC musicMvMainUIC) {
            this.Aum = musicMvMainUIC;
        }

        @Override // com.tencent.mm.emoji.panel.layout.a.b
        public final void onPageSelected(int i2) {
            boolean z;
            com.tencent.mm.plugin.mv.ui.a.b bVar;
            com.tencent.mm.plugin.mv.a.e eVar;
            AppMethodBeat.i(257170);
            Log.i(this.Aum.TAG, "onPageSelected:".concat(String.valueOf(i2)));
            ArrayList<com.tencent.mm.plugin.mv.ui.a.b> arrayList = this.Aum.kgc;
            if (arrayList.size() > i2) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                arrayList = null;
            }
            if (!(arrayList == null || (bVar = arrayList.get(i2)) == null || (eVar = bVar.ArY) == null)) {
                e.a aVar = com.tencent.mm.plugin.mv.a.e.ApR;
                FinderObject a2 = e.a.a(eVar);
                if (a2 != null) {
                    new bbn().tCE = 91;
                    ecq ecq = new ecq();
                    ecq.hFK = a2.id;
                    ecq.objectNonceId = a2.objectNonceId;
                    ecq.NcM = new mp();
                    epf epf = new epf();
                    epf.iJF = cl.aWA();
                    epf.Nng = cl.aWA() + 1000;
                    epf.sGB = 1000;
                    epf.Nnd = 1000;
                    epf.Nne = 1000;
                    epf.Nnc = 1;
                    epf.ElR = 1;
                    epf.Nnf = 1000;
                    epf.vgi = 1000;
                    epf.Nnh = 1;
                    ecq.NcN = epf;
                    cxr cxr = new cxr();
                    cxr.MCf = 100;
                    cxr.MCg = 1000;
                    cxr.MCq = 100;
                    ecq.NcO = cxr;
                }
            }
            if (((com.tencent.mm.plugin.mv.ui.a.b) kotlin.a.j.L(this.Aum.kgc, i2)) != null) {
                this.Aum.Vab = MusicMvMainUIC.axe(i2);
                AppMethodBeat.o(257170);
                return;
            }
            AppMethodBeat.o(257170);
        }
    }

    public static final class l implements a.d {
        final /* synthetic */ MusicMvMainUIC Aum;

        public static final class a extends kotlin.g.b.q implements kotlin.g.a.b<Bitmap, x> {
            final /* synthetic */ l Aus;
            final /* synthetic */ int gUj;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(l lVar, int i2) {
                super(1);
                this.Aus = lVar;
                this.gUj = i2;
            }

            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Bitmap bitmap) {
                AppMethodBeat.i(257174);
                Log.i(this.Aus.Aum.TAG, "requestSnapshot finished");
                this.Aus.Aum.kgc.get(this.gUj).ArY.ApC = bitmap;
                kotlinx.coroutines.f.b(bn.TUK, ba.hMW(), new kotlin.g.a.m<ai, kotlin.d.d<? super x>, Object>(this, null) {
                    /* class com.tencent.mm.plugin.mv.ui.uic.MusicMvMainUIC.l.a.AnonymousClass1 */
                    final /* synthetic */ a Aut;
                    int label;
                    private ai p$;

                    {
                        this.Aut = r2;
                    }

                    @Override // kotlin.d.b.a.a
                    public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                        AppMethodBeat.i(257172);
                        kotlin.g.b.p.h(dVar, "completion");
                        AnonymousClass1 r0 = 

                        l(MusicMvMainUIC musicMvMainUIC) {
                            this.Aum = musicMvMainUIC;
                        }

                        @Override // com.tencent.mm.emoji.panel.layout.a.d
                        public final void pr(int i2) {
                            com.tencent.mm.plugin.thumbplayer.c.a effector;
                            AppMethodBeat.i(257175);
                            Log.i(this.Aum.TAG, "onPageStartChange:" + i2 + ", dataList.size:" + this.Aum.kgc.size());
                            if (i2 >= this.Aum.kgc.size() || i2 < 0) {
                                AppMethodBeat.o(257175);
                                return;
                            }
                            MusicMvMainUIC.d(this.Aum);
                            this.Aum.Vac = true;
                            MMMvVideoLayout mMMvVideoLayout = this.Aum.AtX;
                            if (mMMvVideoLayout == null || (effector = mMMvVideoLayout.getEffector()) == null) {
                                AppMethodBeat.o(257175);
                                return;
                            }
                            effector.ac(new a(this, i2));
                            AppMethodBeat.o(257175);
                        }
                    }

                    public static final class e extends IListener<mx> {
                        final /* synthetic */ MusicMvMainUIC Aum;
                        final /* synthetic */ AppCompatActivity uQi;

                        e(MusicMvMainUIC musicMvMainUIC, AppCompatActivity appCompatActivity) {
                            this.Aum = musicMvMainUIC;
                            this.uQi = appCompatActivity;
                        }

                        @Override // com.tencent.mm.sdk.event.IListener
                        public final /* synthetic */ boolean callback(mx mxVar) {
                            AppMethodBeat.i(257160);
                            mx mxVar2 = mxVar;
                            if (mxVar2 != null) {
                                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                                if (((MusicMvDataUIC) com.tencent.mm.ui.component.a.b(this.uQi).get(MusicMvDataUIC.class)).f(mxVar2.dSE.dSy)) {
                                    switch (mxVar2.dSE.action) {
                                        case 0:
                                            com.tencent.mm.plugin.mv.ui.a.b bVar = (com.tencent.mm.plugin.mv.ui.a.b) kotlin.a.j.kt(this.Aum.kgc);
                                            if (bVar != null) {
                                                this.Aum.g(bVar.ArY);
                                                break;
                                            }
                                            break;
                                    }
                                }
                            }
                            AppMethodBeat.o(257160);
                            return false;
                        }
                    }

                    public final void g(com.tencent.mm.plugin.mv.a.e eVar) {
                        AppMethodBeat.i(257189);
                        kotlin.g.b.p.h(eVar, "musicMv");
                        com.tencent.mm.plugin.music.e.k euj = com.tencent.mm.plugin.music.e.k.euj();
                        kotlin.g.b.p.g(euj, "MusicPlayerManager.Instance()");
                        com.tencent.mm.plugin.music.f.a.d etW = euj.etW();
                        kotlin.g.b.p.g(etW, "MusicPlayerManager.Instance().musicPlayer");
                        int duration = etW.getDuration();
                        if (duration != 0) {
                            this.Auh.dead();
                            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                            axy axy = ((MusicMvDataUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(MusicMvDataUIC.class)).Aqo;
                            axy.duration = duration;
                            Log.i(this.TAG, "syncBreakTrack songId:" + axy.AqO + " songName:" + axy.BPc + " singer:" + axy.lDR + " musicTotalDuration:" + duration);
                            com.tencent.mm.kernel.g.azz().b(new com.tencent.mm.plugin.mv.a.a.c(axy, duration, eVar.hashCode(), getActivity().hashCode()));
                            AppMethodBeat.o(257189);
                            return;
                        }
                        Log.i(this.TAG, "wait song start");
                        this.Auh.alive();
                        AppMethodBeat.o(257189);
                    }

                    public final EffectManager evU() {
                        com.tencent.mm.plugin.thumbplayer.c.a effector;
                        AppMethodBeat.i(257190);
                        MMMvVideoLayout mMMvVideoLayout = this.AtX;
                        if (mMMvVideoLayout == null || (effector = mMMvVideoLayout.getEffector()) == null) {
                            AppMethodBeat.o(257190);
                            return null;
                        }
                        EffectManager effectManager = effector.wet;
                        AppMethodBeat.o(257190);
                        return effectManager;
                    }

                    public final void hWG() {
                        com.tencent.mm.plugin.thumbplayer.c.a effector;
                        AppMethodBeat.i(259258);
                        MMMvVideoLayout mMMvVideoLayout = this.AtX;
                        if (mMMvVideoLayout == null || (effector = mMMvVideoLayout.getEffector()) == null) {
                            AppMethodBeat.o(259258);
                            return;
                        }
                        com.tencent.mm.plugin.thumbplayer.c.a.u(effector);
                        AppMethodBeat.o(259258);
                    }

                    private final void hWH() {
                        AppMethodBeat.i(259259);
                        if (this.AtX == null) {
                            this.AtX = new MMMvVideoLayout(getActivity());
                            MMMvVideoLayout mMMvVideoLayout = this.AtX;
                            if (mMMvVideoLayout != null) {
                                mMMvVideoLayout.setMvMusicProxy(new c());
                            }
                            MMMvVideoLayout mMMvVideoLayout2 = this.AtX;
                            if (mMMvVideoLayout2 != null) {
                                mMMvVideoLayout2.setId(R.id.fqq);
                            }
                        }
                        MMMvVideoLayout mMMvVideoLayout3 = this.AtX;
                        if (mMMvVideoLayout3 != null) {
                            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                            mMMvVideoLayout3.setMediaChangeListener(((MusicMvInfoUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(MusicMvInfoUIC.class)).Atz);
                            AppMethodBeat.o(259259);
                            return;
                        }
                        AppMethodBeat.o(259259);
                    }

                    public static final class c implements com.tencent.mm.plugin.thumbplayer.view.c {
                        c() {
                        }

                        @Override // com.tencent.mm.plugin.thumbplayer.view.c
                        public final long getCurrentPosition() {
                            AppMethodBeat.i(257151);
                            com.tencent.mm.plugin.music.e.k euj = com.tencent.mm.plugin.music.e.k.euj();
                            kotlin.g.b.p.g(euj, "MusicPlayerManager.Instance()");
                            com.tencent.mm.plugin.music.f.a.d etW = euj.etW();
                            kotlin.g.b.p.g(etW, "MusicPlayerManager.Instance().musicPlayer");
                            long etn = (long) etW.etn();
                            AppMethodBeat.o(257151);
                            return etn;
                        }

                        @Override // com.tencent.mm.plugin.thumbplayer.view.c
                        public final void Tp(int i2) {
                            AppMethodBeat.i(257152);
                            com.tencent.mm.plugin.music.e.k euj = com.tencent.mm.plugin.music.e.k.euj();
                            kotlin.g.b.p.g(euj, "MusicPlayerManager.Instance()");
                            euj.etW().tG(i2);
                            AppMethodBeat.o(257152);
                        }
                    }

                    public static final class t implements com.tencent.mm.plugin.thumbplayer.view.g {
                        final /* synthetic */ com.tencent.mm.plugin.mv.a.e Awc;

                        t(com.tencent.mm.plugin.mv.a.e eVar) {
                            this.Awc = eVar;
                        }

                        @Override // com.tencent.mm.plugin.thumbplayer.view.g
                        public final void a(com.tencent.mm.plugin.thumbplayer.d.a aVar) {
                            AppMethodBeat.i(259252);
                            kotlin.g.b.p.h(aVar, "media");
                            if (this.Awc.UZk > 0) {
                                this.Awc.UZl += cl.aWA() - this.Awc.UZk;
                                this.Awc.UZk = 0;
                            }
                            AppMethodBeat.o(259252);
                        }

                        @Override // com.tencent.mm.plugin.thumbplayer.view.g
                        public final void b(com.tencent.mm.plugin.thumbplayer.d.a aVar) {
                            AppMethodBeat.i(259253);
                            kotlin.g.b.p.h(aVar, "media");
                            if (this.Awc.UZk > 0) {
                                this.Awc.UZl += cl.aWA() - this.Awc.UZk;
                            }
                            this.Awc.UZk = cl.aWA();
                            AppMethodBeat.o(259253);
                        }
                    }

                    @Override // com.tencent.mm.ui.component.UIComponent
                    public final void onPause() {
                        AppMethodBeat.i(257191);
                        super.onPause();
                        MMMvVideoLayout mMMvVideoLayout = this.AtX;
                        if (mMMvVideoLayout != null) {
                            mMMvVideoLayout.pause();
                        }
                        this.AtY = true;
                        this.AtZ = false;
                        Log.i(this.TAG, "onPause");
                        com.tencent.mm.plugin.music.e.k euj = com.tencent.mm.plugin.music.e.k.euj();
                        kotlin.g.b.p.g(euj, "MusicPlayerManager.Instance()");
                        euj.etW().c(this.AhI);
                        AppMethodBeat.o(257191);
                    }

                    @Override // com.tencent.mm.ui.component.UIComponent
                    public final void onStop() {
                        AppMethodBeat.i(259260);
                        super.onStop();
                        Log.i(this.TAG, "onStop");
                        AppMethodBeat.o(259260);
                    }

                    /* JADX WARNING: Code restructure failed: missing block: B:3:0x005c, code lost:
                        if (com.tencent.f.h.RTc.aV(new com.tencent.mm.plugin.mv.ui.uic.MusicMvMainUIC.r(r1, r9, r13)) == null) goto L_0x005e;
                     */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void a(long r10, java.lang.String r12, com.tencent.mm.plugin.mv.a.e r13) {
                        /*
                        // Method dump skipped, instructions count: 132
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mv.ui.uic.MusicMvMainUIC.a(long, java.lang.String, com.tencent.mm.plugin.mv.a.e):void");
                    }

                    public static final class r implements Runnable {
                        final /* synthetic */ MusicMvMainUIC Aum;
                        final /* synthetic */ ars Vae;
                        final /* synthetic */ com.tencent.mm.plugin.mv.a.e Vaf;

                        r(ars ars, MusicMvMainUIC musicMvMainUIC, com.tencent.mm.plugin.mv.a.e eVar) {
                            this.Vae = ars;
                            this.Aum = musicMvMainUIC;
                            this.Vaf = eVar;
                        }

                        public final void run() {
                            AppMethodBeat.i(259249);
                            MusicMvMainUIC.a(this.Aum, this.Vae, this.Vaf.hashCode());
                            AppMethodBeat.o(259249);
                        }
                    }

                    /* access modifiers changed from: package-private */
                    public static final class o implements com.tencent.mm.ak.i {
                        final /* synthetic */ MusicMvMainUIC Aum;
                        final /* synthetic */ AppCompatActivity uQi;

                        o(MusicMvMainUIC musicMvMainUIC, AppCompatActivity appCompatActivity) {
                            this.Aum = musicMvMainUIC;
                            this.uQi = appCompatActivity;
                        }

                        @Override // com.tencent.mm.ak.i
                        public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
                            com.tencent.mm.plugin.mv.a.e eVar;
                            boolean z;
                            boolean z2;
                            Long l;
                            boolean z3;
                            boolean z4;
                            boolean z5;
                            boolean z6;
                            csb csb;
                            AppMethodBeat.i(257179);
                            if (!(qVar instanceof com.tencent.mm.plugin.mv.a.a.m) || ((com.tencent.mm.plugin.mv.a.a.m) qVar).NoN == 0 || ((com.tencent.mm.plugin.mv.a.a.m) qVar).NoN == this.uQi.hashCode()) {
                                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                                ViewModel viewModel = com.tencent.mm.ui.component.a.b(this.uQi).get(MusicMvDataUIC.class);
                                kotlin.g.b.p.g(viewModel, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
                                MusicMvDataUIC musicMvDataUIC = (MusicMvDataUIC) viewModel;
                                if (qVar instanceof com.tencent.mm.plugin.mv.a.a.h) {
                                    if (i2 == 0 && i3 == 0 && (csb = ((com.tencent.mm.plugin.mv.a.a.h) qVar).Aqj) != null) {
                                        MusicMvMainUIC.a(this.Aum, csb);
                                        x xVar = x.SXb;
                                    }
                                    this.Aum.Aud = true;
                                    AppMethodBeat.o(257179);
                                    return;
                                }
                                if (qVar instanceof com.tencent.mm.plugin.mv.a.a.i) {
                                    if (i2 == 0 && i3 == 0) {
                                        csd csd = ((com.tencent.mm.plugin.mv.a.a.i) qVar).AqL;
                                        if (csd != null) {
                                            String str2 = csd.LIh;
                                            if (str2 != null) {
                                                if (str2.length() > 0) {
                                                    z6 = true;
                                                } else {
                                                    z6 = false;
                                                }
                                                if (!z6) {
                                                    str2 = null;
                                                }
                                                if (str2 != null) {
                                                    musicMvDataUIC.Aqo.LIh = str2;
                                                    x xVar2 = x.SXb;
                                                }
                                            }
                                            String str3 = csd.Mxl;
                                            if (str3 != null) {
                                                if (str3.length() > 0) {
                                                    z5 = true;
                                                } else {
                                                    z5 = false;
                                                }
                                                if (!z5) {
                                                    str3 = null;
                                                }
                                                if (str3 != null) {
                                                    musicMvDataUIC.Aqo.albumName = str3;
                                                    x xVar3 = x.SXb;
                                                }
                                            }
                                            String str4 = csd.Mxm;
                                            if (str4 != null) {
                                                if (str4.length() > 0) {
                                                    z4 = true;
                                                } else {
                                                    z4 = false;
                                                }
                                                if (!z4) {
                                                    str4 = null;
                                                }
                                                if (str4 != null) {
                                                    musicMvDataUIC.Aqo.Djf = str4;
                                                    x xVar4 = x.SXb;
                                                }
                                            }
                                            String str5 = csd.LIi;
                                            if (str5 != null) {
                                                if (str5.length() > 0) {
                                                    z3 = true;
                                                } else {
                                                    z3 = false;
                                                }
                                                if (!z3) {
                                                    str5 = null;
                                                }
                                                if (str5 != null) {
                                                    musicMvDataUIC.Aqo.LIi = str5;
                                                    x xVar5 = x.SXb;
                                                }
                                            }
                                            Long valueOf = Long.valueOf(csd.Vka);
                                            if (valueOf.longValue() > 0) {
                                                z2 = true;
                                            } else {
                                                z2 = false;
                                            }
                                            if (z2) {
                                                l = valueOf;
                                            } else {
                                                l = null;
                                            }
                                            if (l != null) {
                                                musicMvDataUIC.Aqo.LIk = l.longValue();
                                                x xVar6 = x.SXb;
                                            }
                                            String str6 = this.Aum.TAG;
                                            com.tencent.mm.plugin.mv.ui.a aVar2 = com.tencent.mm.plugin.mv.ui.a.ArA;
                                            Log.v(str6, "getSongStatus %s", com.tencent.mm.plugin.mv.ui.a.a(musicMvDataUIC.Aqo));
                                            musicMvDataUIC.evO();
                                            com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
                                            ((MusicMvLyricUIC) com.tencent.mm.ui.component.a.b(this.uQi).get(MusicMvLyricUIC.class)).a(musicMvDataUIC.Aqo, musicMvDataUIC.Amv);
                                            com.tencent.f.h.RTc.aX(new a(csd, this, musicMvDataUIC));
                                        }
                                        com.tencent.mm.plugin.mv.a.k kVar = com.tencent.mm.plugin.mv.a.k.Aql;
                                        com.tencent.mm.plugin.mv.a.k.a(this.uQi, musicMvDataUIC.Aqo, musicMvDataUIC.Atp);
                                        AppMethodBeat.o(257179);
                                        return;
                                    }
                                } else if (qVar instanceof com.tencent.mm.plugin.mv.a.a.f) {
                                    if (i2 == 0 && i3 == 0) {
                                        ars ars = ((com.tencent.mm.plugin.mv.a.a.f) qVar).Apk;
                                        if (ars != null) {
                                            MusicMvMainUIC.a(this.Aum, ars, ((com.tencent.mm.plugin.mv.a.a.f) qVar).AqE);
                                            x xVar7 = x.SXb;
                                            AppMethodBeat.o(257179);
                                            return;
                                        }
                                        AppMethodBeat.o(257179);
                                        return;
                                    }
                                    int i4 = 0;
                                    for (T t : this.Aum.kgc) {
                                        int i5 = i4 + 1;
                                        if (i4 < 0) {
                                            kotlin.a.j.hxH();
                                        }
                                        T t2 = t;
                                        if (t2.ArY.hashCode() == ((com.tencent.mm.plugin.mv.a.a.f) qVar).AqE) {
                                            e.a aVar4 = com.tencent.mm.plugin.mv.a.e.ApR;
                                            com.tencent.mm.plugin.mv.a.e eVar2 = t2.ArY;
                                            kotlin.g.b.p.h(eVar2, "mv");
                                            eVar2.tav = true;
                                            eVar2.ApJ = null;
                                            eVar2.ApI = null;
                                            eVar2.ApH.clear();
                                            eVar2.likeCount = 0;
                                            eVar2.forwardCount = 0;
                                            eVar2.commentCount = 0;
                                            eVar2.ApK = false;
                                            eVar2.ApN = null;
                                            eVar2.ApP = null;
                                            eVar2.ApQ.clear();
                                            eVar2.onr = false;
                                            Log.i(this.Aum.TAG, "notifyItemChanged5:".concat(String.valueOf(i4)));
                                            this.Aum.getAdapter().ci(i4);
                                            this.Aum.g(t2.ArY);
                                        }
                                        i4 = i5;
                                    }
                                    AppMethodBeat.o(257179);
                                    return;
                                } else if (qVar instanceof com.tencent.mm.plugin.mv.a.a.c) {
                                    if (i2 == 0 && i3 == 0) {
                                        this.Aum.Auc = true;
                                        String str7 = this.Aum.TAG;
                                        StringBuilder append = new StringBuilder("onSceneEnd MusicLiveGetBeatTrack songId:").append(((com.tencent.mm.plugin.mv.a.a.c) qVar).Aqo.AqO).append(" trackPoint:");
                                        crz crz = ((com.tencent.mm.plugin.mv.a.a.c) qVar).Aqu;
                                        Log.i(str7, append.append(crz != null ? crz.Mxc : null).toString());
                                        int i6 = ((com.tencent.mm.plugin.mv.a.a.c) qVar).Aqv;
                                        crz crz2 = ((com.tencent.mm.plugin.mv.a.a.c) qVar).Aqu;
                                        if (crz2 != null) {
                                            Iterator<T> it = this.Aum.kgc.iterator();
                                            int i7 = 0;
                                            while (true) {
                                                if (!it.hasNext()) {
                                                    eVar = null;
                                                    i7 = -1;
                                                    break;
                                                }
                                                T next = it.next();
                                                int i8 = i7 + 1;
                                                if (i7 < 0) {
                                                    kotlin.a.j.hxH();
                                                }
                                                T t3 = next;
                                                if (t3.ArY.hashCode() == ((com.tencent.mm.plugin.mv.a.a.c) qVar).Aqw) {
                                                    eVar = t3.ArY;
                                                    break;
                                                }
                                                i7 = i8;
                                            }
                                            x xVar8 = x.SXb;
                                            if (eVar != null) {
                                                if (i7 >= 0) {
                                                    z = true;
                                                } else {
                                                    z = false;
                                                }
                                                com.tencent.mm.plugin.mv.a.e eVar3 = z ? eVar : null;
                                                if (eVar3 != null) {
                                                    eVar3.ApH.clear();
                                                    int i9 = 0;
                                                    LinkedList<Integer> linkedList = crz2.Mxc;
                                                    kotlin.g.b.p.g(linkedList, "beatTrackResponse.break_point_ms");
                                                    for (T t4 : linkedList) {
                                                        axz axz = new axz();
                                                        axz.refObjectId = 0;
                                                        axz.LIm = "";
                                                        axz.Ghu = (long) i9;
                                                        axz.LIl = t4.intValue() - i9;
                                                        axz.Ghw = 0;
                                                        eVar3.ApH.add(axz);
                                                        kotlin.g.b.p.g(t4, "point");
                                                        i9 = t4.intValue();
                                                    }
                                                    if (i9 < i6) {
                                                        axz axz2 = new axz();
                                                        axz2.refObjectId = 0;
                                                        axz2.LIm = "";
                                                        axz2.Ghu = (long) i9;
                                                        axz2.LIl = i6 - i9;
                                                        axz2.Ghw = 0;
                                                        eVar3.ApH.add(axz2);
                                                    }
                                                    x xVar9 = x.SXb;
                                                }
                                            }
                                            if (this.Aum.Aud) {
                                                Log.i(this.Aum.TAG, "get beat track notify");
                                                Log.i(this.Aum.TAG, "notifyItemChanged6:".concat(String.valueOf(i7)));
                                                this.Aum.getAdapter().ci(i7);
                                            }
                                            x xVar10 = x.SXb;
                                            AppMethodBeat.o(257179);
                                            return;
                                        }
                                        AppMethodBeat.o(257179);
                                        return;
                                    }
                                } else if (qVar instanceof com.tencent.mm.plugin.mv.a.a.a) {
                                    if (i2 == 0 && i3 == 0) {
                                        crx crx = ((com.tencent.mm.plugin.mv.a.a.a) qVar).Aqn;
                                        if (crx != null) {
                                            musicMvDataUIC.Atq = crx.MwZ;
                                            musicMvDataUIC.Aqo.AqO = crx.MwX;
                                            musicMvDataUIC.fuN = crx.uFc;
                                            Log.i(this.Aum.TAG, "NetSceneMusicMvCheckPermission songId:" + crx.MwX + " mvPostPermissionBit:" + crx.MwZ + " statusVerifyInfo:" + crx.uFc);
                                            x xVar11 = x.SXb;
                                            AppMethodBeat.o(257179);
                                            return;
                                        }
                                        AppMethodBeat.o(257179);
                                        return;
                                    }
                                } else if ((qVar instanceof av) && i2 == 0 && i3 == 0) {
                                    Log.i(this.Aum.TAG, "ret delete mv finished");
                                    if (this.Aum.tex < this.Aum.kgc.size()) {
                                        e.a aVar5 = com.tencent.mm.plugin.mv.a.e.ApR;
                                        e.a.e(this.Aum.kgc.get(this.Aum.tex).ArY);
                                        this.Aum.kgc.get(this.Aum.tex).ArY.tav = true;
                                        com.tencent.mm.plugin.music.e.k euj = com.tencent.mm.plugin.music.e.k.euj();
                                        kotlin.g.b.p.g(euj, "MusicPlayerManager.Instance()");
                                        euj.etW().tG(0);
                                        this.Aum.getAdapter().aq(this.Aum.tex, 1);
                                    }
                                }
                                AppMethodBeat.o(257179);
                                return;
                            }
                            Log.i(this.Aum.TAG, "not the same page of netscene");
                            AppMethodBeat.o(257179);
                        }

                        static final class a implements Runnable {
                            final /* synthetic */ csd Auu;
                            final /* synthetic */ o Auv;
                            final /* synthetic */ MusicMvDataUIC Auw;

                            a(csd csd, o oVar, MusicMvDataUIC musicMvDataUIC) {
                                this.Auu = csd;
                                this.Auv = oVar;
                                this.Auw = musicMvDataUIC;
                            }

                            public final void run() {
                                AppMethodBeat.i(257178);
                                com.tencent.mm.plugin.music.model.l lVar = com.tencent.mm.plugin.music.model.l.AkI;
                                com.tencent.mm.plugin.music.model.e.a au = com.tencent.mm.plugin.music.model.l.au(this.Auv.uQi);
                                if (au != null) {
                                    com.tencent.mm.plugin.music.model.o.euD().b(au.field_musicId, au.field_songAlbum, this.Auu.Mxm, this.Auu.LIh, false, false);
                                    AppMethodBeat.o(257178);
                                    return;
                                }
                                AppMethodBeat.o(257178);
                            }
                        }
                    }

                    public static final class d implements com.tencent.mm.plugin.finder.upload.q {
                        final /* synthetic */ MusicMvMainUIC Aum;
                        final /* synthetic */ AppCompatActivity uQi;

                        d(MusicMvMainUIC musicMvMainUIC, AppCompatActivity appCompatActivity) {
                            this.Aum = musicMvMainUIC;
                            this.uQi = appCompatActivity;
                        }

                        @Override // com.tencent.mm.plugin.finder.upload.q
                        public final void onPostStart(long j2) {
                            boolean z;
                            com.tencent.mm.plugin.mv.ui.a.b bVar;
                            com.tencent.mm.plugin.mv.a.e eVar;
                            AppMethodBeat.i(257156);
                            Log.i(this.Aum.TAG, "onPostStart ".concat(String.valueOf(j2)));
                            ArrayList<com.tencent.mm.plugin.mv.ui.a.b> arrayList = this.Aum.kgc;
                            if (arrayList.size() > 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (!z) {
                                arrayList = null;
                            }
                            if (arrayList == null || (bVar = arrayList.get(0)) == null || (eVar = bVar.ArY) == null) {
                                AppMethodBeat.o(257156);
                                return;
                            }
                            Long l = eVar.ApB;
                            if (l == null) {
                                AppMethodBeat.o(257156);
                                return;
                            }
                            if (l.longValue() == j2) {
                                eVar.ApM = 2;
                                com.tencent.mm.ac.d.h(new c(this, j2));
                            }
                            AppMethodBeat.o(257156);
                        }

                        @Override // com.tencent.mm.plugin.finder.upload.q
                        public final void onPostEnd(long j2, boolean z) {
                            boolean z2;
                            com.tencent.mm.plugin.mv.ui.a.b bVar;
                            com.tencent.mm.plugin.mv.a.e eVar;
                            AppMethodBeat.i(257157);
                            Log.i(this.Aum.TAG, "onPostEnd " + j2 + ' ' + z);
                            ArrayList<com.tencent.mm.plugin.mv.ui.a.b> arrayList = this.Aum.kgc;
                            if (arrayList.size() > 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (!z2) {
                                arrayList = null;
                            }
                            if (arrayList == null || (bVar = arrayList.get(0)) == null || (eVar = bVar.ArY) == null) {
                                AppMethodBeat.o(257157);
                                return;
                            }
                            Long l = eVar.ApB;
                            if (l == null) {
                                AppMethodBeat.o(257157);
                                return;
                            }
                            if (l.longValue() == j2 && !z) {
                                eVar.ApM = 3;
                                com.tencent.mm.ac.d.h(new a(this, j2, z));
                            }
                            AppMethodBeat.o(257157);
                        }

                        @Override // com.tencent.mm.plugin.finder.upload.q
                        public final void onPostOk(long j2, long j3) {
                            boolean z;
                            com.tencent.mm.plugin.mv.ui.a.b bVar;
                            com.tencent.mm.plugin.mv.a.e eVar;
                            AppMethodBeat.i(257158);
                            ArrayList<com.tencent.mm.plugin.mv.ui.a.b> arrayList = this.Aum.kgc;
                            if (arrayList.size() > 0) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (!z) {
                                arrayList = null;
                            }
                            if (arrayList == null || (bVar = arrayList.get(0)) == null || (eVar = bVar.ArY) == null) {
                                Log.i(this.Aum.TAG, "onPostOk not found mv " + j2 + ' ' + j3);
                                AppMethodBeat.o(257158);
                                return;
                            }
                            Log.i(this.Aum.TAG, "onPostOk " + j2 + ' ' + j3);
                            Long l = eVar.ApB;
                            if (l != null && l.longValue() == j2) {
                                eVar.ApM = 4;
                                e.a aVar = com.tencent.mm.plugin.finder.storage.data.e.vFX;
                                FinderItem Fy = e.a.Fy(j3);
                                if (Fy != null) {
                                    eVar.ApP = Fy.getFeedObject();
                                    this.Aum.a(Fy.getId(), Fy.getObjectNonceId(), eVar);
                                }
                                com.tencent.mm.ac.d.h(new b(this, j2, j3));
                                AppMethodBeat.o(257158);
                                return;
                            }
                            Log.i(this.Aum.TAG, "first item difference local id " + eVar.ApB + ' ' + j2);
                            AppMethodBeat.o(257158);
                        }

                        @Override // com.tencent.mm.plugin.finder.upload.q
                        public final void onPostNotify(long j2, boolean z) {
                            AppMethodBeat.i(257159);
                            Log.i(this.Aum.TAG, "onPostNotify " + j2 + ' ' + z);
                            AppMethodBeat.o(257159);
                        }

                        static final class c extends kotlin.g.b.q implements kotlin.g.a.a<x> {
                            final /* synthetic */ long $localId$inlined;
                            final /* synthetic */ d Auo;

                            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                            c(d dVar, long j2) {
                                super(0);
                                this.Auo = dVar;
                                this.$localId$inlined = j2;
                            }

                            @Override // kotlin.g.a.a
                            public final /* synthetic */ x invoke() {
                                AppMethodBeat.i(257155);
                                this.Auo.Aum.getAdapter().ci(0);
                                x xVar = x.SXb;
                                AppMethodBeat.o(257155);
                                return xVar;
                            }
                        }

                        static final class a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
                            final /* synthetic */ long $localId$inlined;
                            final /* synthetic */ d Auo;
                            final /* synthetic */ boolean Aup;

                            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                            a(d dVar, long j2, boolean z) {
                                super(0);
                                this.Auo = dVar;
                                this.$localId$inlined = j2;
                                this.Aup = z;
                            }

                            @Override // kotlin.g.a.a
                            public final /* synthetic */ x invoke() {
                                AppMethodBeat.i(257153);
                                this.Auo.Aum.getAdapter().ci(0);
                                x xVar = x.SXb;
                                AppMethodBeat.o(257153);
                                return xVar;
                            }
                        }

                        static final class b extends kotlin.g.b.q implements kotlin.g.a.a<x> {
                            final /* synthetic */ long $localId$inlined;
                            final /* synthetic */ d Auo;
                            final /* synthetic */ long Auq;

                            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                            b(d dVar, long j2, long j3) {
                                super(0);
                                this.Auo = dVar;
                                this.$localId$inlined = j2;
                                this.Auq = j3;
                            }

                            @Override // kotlin.g.a.a
                            public final /* synthetic */ x invoke() {
                                AppMethodBeat.i(257154);
                                WxRecyclerAdapter<com.tencent.mm.plugin.mv.ui.a.b> adapter = this.Auo.Aum.getAdapter();
                                a aVar = MusicMvMainUIC.Aul;
                                adapter.b(0, MusicMvMainUIC.Auk);
                                u.u(this.Auo.uQi, this.Auo.Aum.getString(R.string.xw), R.raw.icons_filled_done);
                                x xVar = x.SXb;
                                AppMethodBeat.o(257154);
                                return xVar;
                            }
                        }
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:16:0x0040  */
                    /* JADX WARNING: Removed duplicated region for block: B:33:0x001b A[SYNTHETIC] */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    private final void a(com.tencent.mm.protocal.protobuf.csb r12) {
                        /*
                        // Method dump skipped, instructions count: 210
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mv.ui.uic.MusicMvMainUIC.a(com.tencent.mm.protocal.protobuf.csb):void");
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:40:0x0172  */
                    /* JADX WARNING: Removed duplicated region for block: B:69:0x0252  */
                    /* JADX WARNING: Removed duplicated region for block: B:71:0x029c  */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    private java.util.LinkedList<com.tencent.mm.plugin.thumbplayer.d.a> h(com.tencent.mm.plugin.mv.a.e r21) {
                        /*
                        // Method dump skipped, instructions count: 817
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mv.ui.uic.MusicMvMainUIC.h(com.tencent.mm.plugin.mv.a.e):java.util.LinkedList");
                    }

                    /* access modifiers changed from: package-private */
                    public static final class b extends kotlin.g.b.q implements kotlin.g.a.a<WxRecyclerAdapter<com.tencent.mm.plugin.mv.ui.a.b>> {
                        final /* synthetic */ MusicMvMainUIC Aum;
                        final /* synthetic */ AppCompatActivity uQi;

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        b(MusicMvMainUIC musicMvMainUIC, AppCompatActivity appCompatActivity) {
                            super(0);
                            this.Aum = musicMvMainUIC;
                            this.uQi = appCompatActivity;
                        }

                        @Override // kotlin.g.a.a
                        public final /* synthetic */ WxRecyclerAdapter<com.tencent.mm.plugin.mv.ui.a.b> invoke() {
                            AppMethodBeat.i(257150);
                            WxRecyclerAdapter<com.tencent.mm.plugin.mv.ui.a.b> wxRecyclerAdapter = new WxRecyclerAdapter<>(new com.tencent.mm.view.recyclerview.f(this) {
                                /* class com.tencent.mm.plugin.mv.ui.uic.MusicMvMainUIC.b.AnonymousClass1 */
                                final /* synthetic */ b Aun;

                                {
                                    this.Aun = r1;
                                }

                                @Override // com.tencent.mm.view.recyclerview.f
                                public final com.tencent.mm.view.recyclerview.e<?> EC(int i2) {
                                    AppMethodBeat.i(257149);
                                    com.tencent.mm.plugin.mv.ui.a.c cVar = new com.tencent.mm.plugin.mv.ui.a.c(this.Aun.uQi);
                                    AppMethodBeat.o(257149);
                                    return cVar;
                                }
                            }, this.Aum.kgc, false);
                            AppMethodBeat.o(257150);
                            return wxRecyclerAdapter;
                        }
                    }

                    @Override // com.tencent.mm.ui.component.UIComponent
                    public final void onNewIntent(Intent intent) {
                        byte[] byteArrayExtra;
                        AppMethodBeat.i(257194);
                        if (intent == null || (byteArrayExtra = intent.getByteArrayExtra("key_track_data")) == null) {
                            AppMethodBeat.o(257194);
                            return;
                        }
                        csp csp = new csp();
                        csp.parseFrom(byteArrayExtra);
                        e.a aVar = com.tencent.mm.plugin.mv.a.e.ApR;
                        com.tencent.mm.plugin.mv.a.e b2 = e.a.b(csp);
                        c.a aVar2 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
                        FinderItem FS = c.a.FS(csp.localId);
                        if (FS != null) {
                            if (FS.isPostFailed()) {
                                b2.ApM = 3;
                            } else if (!FS.isPostFinish()) {
                                b2.ApM = 2;
                            } else {
                                b2.ApM = 1;
                            }
                        }
                        SecDataUIC.a aVar3 = SecDataUIC.CWq;
                        cst cst = (cst) SecDataUIC.a.a(getContext(), 7, cst.class);
                        if (cst != null) {
                            cst.scene = 14;
                        }
                        com.tencent.mm.plugin.music.e.k euj = com.tencent.mm.plugin.music.e.k.euj();
                        kotlin.g.b.p.g(euj, "MusicPlayerManager.Instance()");
                        euj.etW().tG(0);
                        Log.i(this.TAG, "onNewIntent mvLocalId:" + b2.ApB + " coverPath:" + b2.ApD + " mvPostStatus:" + b2.ApM);
                        this.AtY = false;
                        this.kgc.add(0, new com.tencent.mm.plugin.mv.ui.a.b(b2));
                        getAdapter().notifyDataSetChanged();
                        WxRecyclerView wxRecyclerView = this.ufR;
                        if (wxRecyclerView != null) {
                            com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                            com.tencent.mm.hellhoundlib.a.a.a(wxRecyclerView, a2.axQ(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC", "onNewIntent", "(Landroid/content/Intent;)V", "Undefined", "scrollToPosition", "(I)V");
                            wxRecyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
                            com.tencent.mm.hellhoundlib.a.a.a(wxRecyclerView, "com/tencent/mm/plugin/mv/ui/uic/MusicMvMainUIC", "onNewIntent", "(Landroid/content/Intent;)V", "Undefined", "scrollToPosition", "(I)V");
                            AppMethodBeat.o(257194);
                            return;
                        }
                        AppMethodBeat.o(257194);
                    }

                    public static final class q extends IListener<abj> {
                        final /* synthetic */ MusicMvMainUIC Aum;
                        final /* synthetic */ AppCompatActivity uQi;

                        q(MusicMvMainUIC musicMvMainUIC, AppCompatActivity appCompatActivity) {
                            this.Aum = musicMvMainUIC;
                            this.uQi = appCompatActivity;
                        }

                        @Override // com.tencent.mm.sdk.event.IListener
                        public final /* synthetic */ boolean callback(abj abj) {
                            int i2 = 3;
                            AppMethodBeat.i(259248);
                            abj abj2 = abj;
                            if (abj2 != null) {
                                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                                ViewModel viewModel = com.tencent.mm.ui.component.a.b(this.uQi).get(MusicMvDataUIC.class);
                                kotlin.g.b.p.g(viewModel, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
                                MusicMvDataUIC musicMvDataUIC = (MusicMvDataUIC) viewModel;
                                com.tencent.mm.plugin.mv.ui.a.b bVar = (com.tencent.mm.plugin.mv.ui.a.b) kotlin.a.j.L(this.Aum.kgc, this.Aum.tex);
                                if (bVar != null) {
                                    switch (abj2.opV.action) {
                                        case 2:
                                        case 3:
                                            if (2 != abj2.opV.action) {
                                                i2 = 4;
                                            }
                                            com.tencent.mm.plugin.mv.a.k kVar = com.tencent.mm.plugin.mv.a.k.Aql;
                                            com.tencent.mm.plugin.mv.a.k.a(this.uQi, musicMvDataUIC.Aqo, bVar.ArY, i2, abj2.opV.commentId);
                                            break;
                                        default:
                                            switch (abj2.opV.action) {
                                                case 1:
                                                    i2 = 2;
                                                    break;
                                                case 2:
                                                case 3:
                                                default:
                                                    i2 = 0;
                                                    break;
                                                case 4:
                                                    break;
                                                case 5:
                                                    i2 = 4;
                                                    break;
                                                case 6:
                                                    i2 = 5;
                                                    break;
                                            }
                                            com.tencent.mm.plugin.mv.a.k kVar2 = com.tencent.mm.plugin.mv.a.k.Aql;
                                            com.tencent.mm.plugin.mv.a.k.b(this.uQi, musicMvDataUIC.Aqo, bVar.ArY, i2, abj2.opV.commentId);
                                            break;
                                    }
                                }
                            }
                            AppMethodBeat.o(259248);
                            return false;
                        }
                    }

                    public static final /* synthetic */ boolean a(MusicMvMainUIC musicMvMainUIC, MotionEvent motionEvent) {
                        View view;
                        AppMethodBeat.i(257197);
                        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                        com.tencent.mm.plugin.mv.ui.view.f fVar = ((MusicMvSongInfoUIC) com.tencent.mm.ui.component.a.b(musicMvMainUIC.getActivity()).get(MusicMvSongInfoUIC.class)).Awi;
                        if (fVar != null && fVar.dEF) {
                            Log.i(musicMvMainUIC.TAG, "dialog showing now, ignore scroll");
                            musicMvMainUIC.Aub.Rpy = false;
                            musicMvMainUIC.xHU = -1;
                            AppMethodBeat.o(257197);
                        } else {
                            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
                            if (((MusicMvInfoUIC) com.tencent.mm.ui.component.a.b(musicMvMainUIC.getActivity()).get(MusicMvInfoUIC.class)).Aty.AxV.isShowing()) {
                                Log.i(musicMvMainUIC.TAG, "mv list dialog showing now enable scroll");
                                musicMvMainUIC.Aub.Rpy = true;
                                musicMvMainUIC.xHU = -1;
                                AppMethodBeat.o(257197);
                            } else {
                                if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
                                    if (musicMvMainUIC.uGY != 0 || musicMvMainUIC.dep < 0.0f || musicMvMainUIC.xHU <= 0 || Util.ticksToNow(musicMvMainUIC.xHU) > ((long) ViewConfiguration.getTapTimeout())) {
                                        musicMvMainUIC.Aub.Rpy = true;
                                    } else {
                                        musicMvMainUIC.Aub.Rpy = false;
                                        Log.i(musicMvMainUIC.TAG, "tap disable scroll");
                                    }
                                    musicMvMainUIC.dep = -1.0f;
                                } else {
                                    WxRecyclerView wxRecyclerView = musicMvMainUIC.ufR;
                                    RecyclerView.v ch = wxRecyclerView != null ? wxRecyclerView.ch(musicMvMainUIC.AtW.hbQ) : null;
                                    if (motionEvent.getAction() == 0) {
                                        View findViewById = (ch == null || (view = ch.aus) == null) ? null : view.findViewById(R.id.d90);
                                        int[] iArr = new int[2];
                                        if (findViewById != null) {
                                            findViewById.getLocationInWindow(iArr);
                                        }
                                        if (iArr[1] <= 0 || motionEvent.getY() < ((float) iArr[1])) {
                                            musicMvMainUIC.dep = motionEvent.getY();
                                        } else {
                                            Log.i(musicMvMainUIC.TAG, "touch bottom area ignore");
                                            musicMvMainUIC.dep = -1.0f;
                                            musicMvMainUIC.Aub.Rpy = true;
                                            musicMvMainUIC.xHU = -1;
                                            AppMethodBeat.o(257197);
                                        }
                                    }
                                    if (ch != null) {
                                        View findViewById2 = ch.aus.findViewById(R.id.dol);
                                        int[] iArr2 = new int[2];
                                        findViewById2.getLocationInWindow(iArr2);
                                        if (musicMvMainUIC.Aue <= 0) {
                                            musicMvMainUIC.Aue = com.tencent.mm.cb.a.aG(musicMvMainUIC.getContext(), R.dimen.cm);
                                        }
                                        if (musicMvMainUIC.dep >= 0.0f) {
                                            float f2 = musicMvMainUIC.dep;
                                            kotlin.g.b.p.g(findViewById2, "headerPanel");
                                            if (f2 <= ((float) (findViewById2.getHeight() + iArr2[1] + musicMvMainUIC.Aue))) {
                                                musicMvMainUIC.Aub.Rpy = false;
                                            }
                                        }
                                        musicMvMainUIC.Aub.Rpy = true;
                                    } else {
                                        musicMvMainUIC.Aub.Rpy = true;
                                    }
                                }
                                musicMvMainUIC.uGY = motionEvent.getAction();
                                musicMvMainUIC.xHU = Util.currentTicks();
                                AppMethodBeat.o(257197);
                            }
                        }
                        return false;
                    }

                    public static final /* synthetic */ void a(MusicMvMainUIC musicMvMainUIC, int i2) {
                        boolean z;
                        RecyclerView.v vVar;
                        ViewParent viewParent;
                        ViewParent viewParent2;
                        ViewParent viewParent3;
                        com.tencent.mm.plugin.thumbplayer.e.b currentPlayer;
                        boolean z2;
                        long j2;
                        com.tencent.mm.plugin.thumbplayer.e.b currentPlayer2;
                        int i3 = 0;
                        com.tencent.mm.plugin.thumbplayer.d.d dVar = null;
                        AppMethodBeat.i(257198);
                        if (i2 < 0) {
                            Log.e(musicMvMainUIC.TAG, "refreshVideo position error:".concat(String.valueOf(i2)));
                            AppMethodBeat.o(257198);
                        } else if (musicMvMainUIC.kgc.get(i2).ArY.ApH.size() == 0) {
                            Log.i(musicMvMainUIC.TAG, "refreshVideo " + i2 + " trackDataList empty");
                            AppMethodBeat.o(257198);
                        } else {
                            SecDataUIC.a aVar = SecDataUIC.CWq;
                            cst cst = (cst) SecDataUIC.a.a(musicMvMainUIC.getContext(), 7, cst.class);
                            if (cst != null) {
                                cst.MxP = 2;
                            }
                            SecDataUIC.a aVar2 = SecDataUIC.CWq;
                            cst cst2 = (cst) SecDataUIC.a.a(musicMvMainUIC.getActivity(), 7, cst.class);
                            if (cst2 != null) {
                                cst2.Vkc = 2;
                            }
                            Log.i(musicMvMainUIC.TAG, "refreshVideo, position:" + i2 + ", lastPos:" + musicMvMainUIC.tex);
                            musicMvMainUIC.hWH();
                            String str = musicMvMainUIC.TAG;
                            StringBuilder sb = new StringBuilder("refreshVideo, videoLayout.parent:");
                            MMMvVideoLayout mMMvVideoLayout = musicMvMainUIC.AtX;
                            Log.i(str, sb.append(mMMvVideoLayout != null ? mMMvVideoLayout.getParent() : null).toString());
                            if (musicMvMainUIC.tex == i2 || musicMvMainUIC.tex < 0) {
                                z = false;
                            } else {
                                com.tencent.mm.plugin.mv.a.o oVar = musicMvMainUIC.Vab;
                                if (oVar != null) {
                                    MMMvVideoLayout mMMvVideoLayout2 = musicMvMainUIC.AtX;
                                    if (mMMvVideoLayout2 == null || (currentPlayer2 = mMMvVideoLayout2.getCurrentPlayer()) == null) {
                                        j2 = 0;
                                    } else {
                                        j2 = currentPlayer2.getCurrentPositionMs();
                                    }
                                    oVar.vgi = j2;
                                }
                                com.tencent.mm.plugin.music.e.k euj = com.tencent.mm.plugin.music.e.k.euj();
                                kotlin.g.b.p.g(euj, "MusicPlayerManager.Instance()");
                                com.tencent.mm.plugin.music.f.a.d etW = euj.etW();
                                kotlin.g.b.p.g(etW, "MusicPlayerManager.Instance().musicPlayer");
                                if (!etW.bec()) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                com.tencent.mm.plugin.mv.a.o oVar2 = musicMvMainUIC.Vab;
                                if (oVar2 != null) {
                                    if (!z) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    oVar2.isAutoPlay = z2;
                                }
                                String str2 = musicMvMainUIC.TAG;
                                StringBuilder append = new StringBuilder("recycle last video, isVideoPause:").append(z).append(", videoLayout.parent:");
                                MMMvVideoLayout mMMvVideoLayout3 = musicMvMainUIC.AtX;
                                if (mMMvVideoLayout3 != null) {
                                    viewParent2 = mMMvVideoLayout3.getParent();
                                } else {
                                    viewParent2 = null;
                                }
                                Log.d(str2, append.append(viewParent2).toString());
                                MMMvVideoLayout mMMvVideoLayout4 = musicMvMainUIC.AtX;
                                if (mMMvVideoLayout4 != null) {
                                    mMMvVideoLayout4.pause();
                                }
                                MMMvVideoLayout mMMvVideoLayout5 = musicMvMainUIC.AtX;
                                if (!(mMMvVideoLayout5 == null || (currentPlayer = mMMvVideoLayout5.getCurrentPlayer()) == null)) {
                                    currentPlayer.dFp();
                                }
                                MMMvVideoLayout mMMvVideoLayout6 = musicMvMainUIC.AtX;
                                if (mMMvVideoLayout6 != null) {
                                    viewParent3 = mMMvVideoLayout6.getParent();
                                } else {
                                    viewParent3 = null;
                                }
                                ViewGroup viewGroup = (ViewGroup) viewParent3;
                                if (viewGroup != null) {
                                    viewGroup.removeView(musicMvMainUIC.AtX);
                                }
                                Log.d(musicMvMainUIC.TAG, "recycle last video, isVideoPause:".concat(String.valueOf(z)));
                            }
                            WxRecyclerView wxRecyclerView = musicMvMainUIC.ufR;
                            if (wxRecyclerView != null) {
                                vVar = wxRecyclerView.ch(i2);
                            } else {
                                vVar = null;
                            }
                            if (vVar != null) {
                                FrameLayout frameLayout = (FrameLayout) vVar.aus.findViewById(R.id.j44);
                                MMMvVideoLayout mMMvVideoLayout7 = musicMvMainUIC.AtX;
                                if (mMMvVideoLayout7 != null) {
                                    viewParent = mMMvVideoLayout7.getParent();
                                } else {
                                    viewParent = null;
                                }
                                if (viewParent == null) {
                                    MMMvVideoLayout mMMvVideoLayout8 = musicMvMainUIC.AtX;
                                    if (mMMvVideoLayout8 != null) {
                                        mMMvVideoLayout8.setId(R.id.fqq);
                                    }
                                    Log.i(musicMvMainUIC.TAG, "refreshVideo add videoLayout to current videoContainer");
                                    frameLayout.addView(musicMvMainUIC.AtX);
                                }
                                MMMvVideoLayout mMMvVideoLayout9 = musicMvMainUIC.AtX;
                                if (mMMvVideoLayout9 != null) {
                                    mMMvVideoLayout9.fxd();
                                }
                                if (musicMvMainUIC.tex >= 0) {
                                    com.tencent.mm.plugin.mv.a.k kVar = com.tencent.mm.plugin.mv.a.k.Aql;
                                    AppCompatActivity activity = musicMvMainUIC.getActivity();
                                    com.tencent.mm.plugin.mv.a.e eVar = musicMvMainUIC.kgc.get(musicMvMainUIC.tex).ArY;
                                    MMMvVideoLayout mMMvVideoLayout10 = musicMvMainUIC.AtX;
                                    if (mMMvVideoLayout10 != null) {
                                        dVar = mMMvVideoLayout10.getReportInfo();
                                    }
                                    com.tencent.mm.plugin.mv.a.k.a(activity, eVar, dVar);
                                }
                                String str3 = musicMvMainUIC.TAG;
                                StringBuilder sb2 = new StringBuilder("refreshVideo current music position:");
                                com.tencent.mm.plugin.music.e.k euj2 = com.tencent.mm.plugin.music.e.k.euj();
                                kotlin.g.b.p.g(euj2, "MusicPlayerManager.Instance()");
                                com.tencent.mm.plugin.music.f.a.d etW2 = euj2.etW();
                                kotlin.g.b.p.g(etW2, "MusicPlayerManager.Instance().musicPlayer");
                                Log.i(str3, sb2.append(etW2.etn()).toString());
                                com.tencent.mm.plugin.mv.a.e eVar2 = musicMvMainUIC.kgc.get(i2).ArY;
                                MMMvVideoLayout mMMvVideoLayout11 = musicMvMainUIC.AtX;
                                if (mMMvVideoLayout11 != null) {
                                    mMMvVideoLayout11.q(musicMvMainUIC.h(eVar2), false);
                                }
                                MMMvVideoLayout mMMvVideoLayout12 = musicMvMainUIC.AtX;
                                if (mMMvVideoLayout12 != null) {
                                    com.tencent.mm.util.c cVar = com.tencent.mm.util.c.QYz;
                                    mMMvVideoLayout12.setEnableEffect(com.tencent.mm.util.c.hdl());
                                }
                                MMMvVideoLayout mMMvVideoLayout13 = musicMvMainUIC.AtX;
                                if (mMMvVideoLayout13 != null) {
                                    mMMvVideoLayout13.setPlayerActionListener(new t(eVar2));
                                }
                                MMMvVideoLayout mMMvVideoLayout14 = musicMvMainUIC.AtX;
                                if (mMMvVideoLayout14 != null) {
                                    mMMvVideoLayout14.start();
                                }
                                com.tencent.mm.plugin.music.e.k euj3 = com.tencent.mm.plugin.music.e.k.euj();
                                kotlin.g.b.p.g(euj3, "MusicPlayerManager.Instance()");
                                com.tencent.mm.plugin.music.f.a.d etW3 = euj3.etW();
                                kotlin.g.b.p.g(etW3, "MusicPlayerManager.Instance().musicPlayer");
                                int etn = etW3.etn();
                                if (etn >= 0) {
                                    i3 = etn;
                                }
                                MMMvVideoLayout mMMvVideoLayout15 = musicMvMainUIC.AtX;
                                if (mMMvVideoLayout15 != null) {
                                    mMMvVideoLayout15.KG((long) i3);
                                }
                                MMMvVideoLayout mMMvVideoLayout16 = musicMvMainUIC.AtX;
                                if (mMMvVideoLayout16 != null) {
                                    mMMvVideoLayout16.setPauseVideoOnPlay(z);
                                }
                                MMMvVideoLayout mMMvVideoLayout17 = musicMvMainUIC.AtX;
                                if (mMMvVideoLayout17 != null) {
                                    mMMvVideoLayout17.setKeepScreenOn(true);
                                    AppMethodBeat.o(257198);
                                    return;
                                }
                            }
                            AppMethodBeat.o(257198);
                        }
                    }

                    public static final /* synthetic */ void a(MusicMvMainUIC musicMvMainUIC, ars ars, int i2) {
                        int i3;
                        FinderObject finderObject;
                        boolean z;
                        boolean z2;
                        com.tencent.mm.plugin.mv.ui.a.b bVar;
                        com.tencent.mm.plugin.mv.ui.a.b bVar2;
                        com.tencent.mm.plugin.mv.a.e eVar;
                        Long l2;
                        Long l3;
                        boolean z3;
                        Long l4;
                        AppMethodBeat.i(259262);
                        Log.i(musicMvMainUIC.TAG, "handleGetCommentDetailResponse");
                        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                        ViewModel viewModel = com.tencent.mm.ui.component.a.b(musicMvMainUIC.getActivity()).get(MusicMvDataUIC.class);
                        kotlin.g.b.p.g(viewModel, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
                        MusicMvDataUIC musicMvDataUIC = (MusicMvDataUIC) viewModel;
                        int i4 = 0;
                        boolean z4 = false;
                        for (T t2 : musicMvMainUIC.kgc) {
                            int i5 = i4 + 1;
                            if (i4 < 0) {
                                kotlin.a.j.hxH();
                            }
                            T t3 = t2;
                            if (t3.ArY.hashCode() == i2) {
                                if (t3.ArY.ApB == null || ((l4 = t3.ArY.ApB) != null && l4.longValue() == 0)) {
                                    FinderObject finderObject2 = ars.feedObject;
                                    if (finderObject2 != null) {
                                        e.a aVar2 = com.tencent.mm.plugin.mv.a.e.ApR;
                                        kotlin.g.b.p.g(finderObject2, "obj");
                                        e.a.a(finderObject2, t3.ArY);
                                        com.tencent.mm.plugin.mv.a.e eVar2 = t3.ArY;
                                        LinkedList<FinderObject> linkedList = ars.LDi;
                                        kotlin.g.b.p.g(linkedList, "resp.refObjectList");
                                        eVar2.bf(linkedList);
                                        Log.i(musicMvMainUIC.TAG, "notifyItemChanged1:".concat(String.valueOf(i4)));
                                        musicMvMainUIC.getAdapter().ci(i4);
                                    }
                                } else {
                                    t3.ArY.ApP = ars.feedObject;
                                    com.tencent.mm.plugin.mv.a.e eVar3 = t3.ArY;
                                    LinkedList<FinderObject> linkedList2 = ars.LDi;
                                    kotlin.g.b.p.g(linkedList2, "resp.refObjectList");
                                    kotlin.g.b.p.h(linkedList2, "<set-?>");
                                    eVar3.ApQ = linkedList2;
                                }
                                z3 = true;
                            } else {
                                z3 = z4;
                            }
                            i4 = i5;
                            z4 = z3;
                        }
                        if (!z4) {
                            MusicMvMainUIC musicMvMainUIC2 = musicMvMainUIC;
                            int i6 = 0;
                            Iterator<T> it = musicMvMainUIC2.AtU.iterator();
                            while (true) {
                                i3 = i6;
                                if (!it.hasNext()) {
                                    i3 = -1;
                                    break;
                                }
                                T next = it.next();
                                i6 = i3 + 1;
                                if (i3 < 0) {
                                    kotlin.a.j.hxH();
                                }
                                T t4 = next;
                                if (t4.ArY.hashCode() == i2 && (finderObject = ars.feedObject) != null) {
                                    e.a aVar3 = com.tencent.mm.plugin.mv.a.e.ApR;
                                    kotlin.g.b.p.g(finderObject, "obj");
                                    e.a.a(finderObject, t4.ArY);
                                    com.tencent.mm.plugin.mv.a.e eVar4 = t4.ArY;
                                    LinkedList<FinderObject> linkedList3 = ars.LDi;
                                    kotlin.g.b.p.g(linkedList3, "resp.refObjectList");
                                    eVar4.bf(linkedList3);
                                    ArrayList<com.tencent.mm.plugin.mv.ui.a.b> arrayList = musicMvMainUIC2.kgc;
                                    if (arrayList.size() == 1) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    if (!z) {
                                        arrayList = null;
                                    }
                                    if (!(arrayList == null || (bVar2 = (com.tencent.mm.plugin.mv.ui.a.b) kotlin.a.j.ks(arrayList)) == null || (eVar = bVar2.ArY) == null)) {
                                        com.tencent.mm.plugin.mv.a.e eVar5 = kotlin.g.b.p.j(eVar, musicMvDataUIC.Atp) && ((musicMvDataUIC.Atp.ApE == null || ((l3 = musicMvDataUIC.Atp.ApE) != null && (l3.longValue() > 0 ? 1 : (l3.longValue() == 0 ? 0 : -1)) == 0)) && (eVar.ApB == null || ((l2 = eVar.ApB) != null && (l2.longValue() > 0 ? 1 : (l2.longValue() == 0 ? 0 : -1)) == 0))) ? eVar : null;
                                        if (eVar5 != null) {
                                            musicMvMainUIC2.kgc.clear();
                                            t4.ArY.ApO = eVar5.ApO;
                                            musicMvMainUIC2.kgc.add(t4);
                                            Log.i(musicMvMainUIC2.TAG, "notifyItemChanged2:".concat(String.valueOf(i3)));
                                            musicMvMainUIC2.getAdapter().ci(0);
                                        }
                                    }
                                    musicMvMainUIC2.kgc.add(t4);
                                    ArrayList<com.tencent.mm.plugin.mv.ui.a.b> arrayList2 = musicMvMainUIC2.kgc;
                                    if (arrayList2.size() <= 2) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    if (!z2) {
                                        arrayList2 = null;
                                    }
                                    if (!(arrayList2 == null || (bVar = (com.tencent.mm.plugin.mv.ui.a.b) kotlin.a.j.kt(arrayList2)) == null)) {
                                        if (!bVar.ArY.tav) {
                                            bVar = null;
                                        }
                                        if (bVar != null) {
                                            Log.i(musicMvMainUIC2.TAG, "notifyItemChanged3:".concat(String.valueOf(i3)));
                                            musicMvMainUIC2.getAdapter().ci(0);
                                        }
                                    }
                                    Log.i(musicMvMainUIC2.TAG, "notifyItemInserted4:" + (musicMvMainUIC2.kgc.size() - 1));
                                    musicMvMainUIC2.getAdapter().cj(musicMvMainUIC2.kgc.size() - 1);
                                }
                            }
                            if (i3 >= 0) {
                                musicMvMainUIC.AtU.remove(i3);
                            }
                        }
                        AppMethodBeat.o(259262);
                    }

                    public static final /* synthetic */ com.tencent.mm.plugin.mv.a.o axe(int i2) {
                        AppMethodBeat.i(259263);
                        com.tencent.mm.plugin.mv.a.o oVar = new com.tencent.mm.plugin.mv.a.o(i2);
                        AppMethodBeat.o(259263);
                        return oVar;
                    }
                }
