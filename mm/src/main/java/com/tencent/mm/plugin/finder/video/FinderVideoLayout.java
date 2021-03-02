package com.tencent.mm.plugin.finder.video;

import android.animation.Animator;
import android.app.Activity;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.hj;
import com.tencent.mm.g.a.pw;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.event.c;
import com.tencent.mm.plugin.finder.model.at;
import com.tencent.mm.plugin.finder.preload.MediaPreloadCore;
import com.tencent.mm.plugin.finder.report.af;
import com.tencent.mm.plugin.finder.report.f;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.w;
import com.tencent.mm.plugin.finder.video.FinderLongVideoPlayerSeekBar;
import com.tencent.mm.plugin.finder.video.q;
import com.tencent.mm.plugin.finder.viewmodel.FinderVideoStateCacheVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler;
import com.tencent.mm.plugin.i.a.ad;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.protocal.protobuf.azy;
import com.tencent.mm.protocal.protobuf.cjk;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.ao;
import com.tencent.mm.view.ViewAnimHelper;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.LinkedList;
import kotlin.x;

public final class FinderVideoLayout extends FrameLayout implements q.a, t, x, i.b {
    public static final a wfy = new a((byte) 0);
    private int dLS;
    boolean guh;
    private long iJF;
    public boolean isLongVideo;
    private LinkedList<cjl> mediaList;
    public k tCD;
    private com.tencent.mm.plugin.finder.feed.e tOr;
    public com.tencent.mm.plugin.finder.feed.d tOs;
    private final y wcw;
    private boolean wfc;
    private boolean wfd = true;
    public final FinderVideoStateCacheVM wfe;
    private final kotlin.f wff;
    private boolean wfg;
    private final kotlin.f wfh;
    private final kotlin.f wfi;
    private final kotlin.f wfj;
    private final kotlin.f wfk;
    public r wfl;
    private final kotlin.f wfm;
    private final kotlin.f wfn;
    private final kotlin.f wfo;
    public b wfp;
    public q wfq;
    private FinderLongVideoPlayerSeekBar wfr;
    private kotlin.g.a.m<? super Boolean, ? super b, x> wfs;
    private kotlin.g.a.m<? super Boolean, ? super b, x> wft;
    private int wfu;
    private boolean wfv;
    private float wfw;
    private int wfx;

    static {
        AppMethodBeat.i(168083);
        AppMethodBeat.o(168083);
    }

    private final View getBottomButtonLayout() {
        AppMethodBeat.i(254300);
        View view = (View) this.wfh.getValue();
        AppMethodBeat.o(254300);
        return view;
    }

    private final View getBulletSubtitleButton() {
        AppMethodBeat.i(254301);
        View view = (View) this.wfi.getValue();
        AppMethodBeat.o(254301);
        return view;
    }

    private final View getFullscreenIcon() {
        AppMethodBeat.i(254302);
        View view = (View) this.wfm.getValue();
        AppMethodBeat.o(254302);
        return view;
    }

    private final View getLoading() {
        AppMethodBeat.i(168084);
        View view = (View) this.wff.getValue();
        AppMethodBeat.o(168084);
        return view;
    }

    private final ImageView getMuteBtn() {
        AppMethodBeat.i(168086);
        ImageView imageView = (ImageView) this.wfj.getValue();
        AppMethodBeat.o(168086);
        return imageView;
    }

    private final ImageView getThumbView() {
        AppMethodBeat.i(168087);
        ImageView imageView = (ImageView) this.wfk.getValue();
        AppMethodBeat.o(168087);
        return imageView;
    }

    private final View getVideoTypeIv() {
        AppMethodBeat.i(168093);
        View view = (View) this.wfo.getValue();
        AppMethodBeat.o(168093);
        return view;
    }

    public final View getRetryBtn() {
        AppMethodBeat.i(168092);
        View view = (View) this.wfn.getValue();
        AppMethodBeat.o(168092);
        return view;
    }

    public static final class e<T, R> implements com.tencent.mm.loader.f.e<com.tencent.mm.plugin.finder.loader.o, Bitmap> {
        final /* synthetic */ FinderVideoLayout wfB;

        e(FinderVideoLayout finderVideoLayout) {
            this.wfB = finderVideoLayout;
        }

        @Override // com.tencent.mm.loader.f.e
        public final /* synthetic */ void a(com.tencent.mm.loader.h.a.a<com.tencent.mm.plugin.finder.loader.o> aVar, com.tencent.mm.loader.e.b.g gVar, Bitmap bitmap) {
            AppMethodBeat.i(254278);
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null) {
                StringBuilder sb = new StringBuilder("[convert] mediaId=");
                b playInfo = this.wfB.getPlayInfo();
                if (playInfo == null) {
                    kotlin.g.b.p.hyc();
                }
                Log.i("Finder.VideoLayout", sb.append(playInfo.mediaId).append(" thumb[").append(bitmap2.getWidth()).append(':').append(bitmap2.getHeight()).append("] view[").append(FinderVideoLayout.c(this.wfB).getWidth()).append(':').append(FinderVideoLayout.c(this.wfB).getHeight()).append("] scaleType=").append(FinderVideoLayout.c(this.wfB).getScaleType()).append(' ').toString());
                AppMethodBeat.o(254278);
                return;
            }
            AppMethodBeat.o(254278);
        }
    }

    public static final class m extends kotlin.g.b.q implements kotlin.g.a.b<r, x> {
        final /* synthetic */ FinderVideoLayout wfB;
        final /* synthetic */ b wfI;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(FinderVideoLayout finderVideoLayout, b bVar) {
            super(1);
            this.wfB = finderVideoLayout;
            this.wfI = bVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:33:0x014e, code lost:
            if (r12 == null) goto L_0x0150;
         */
        @Override // kotlin.g.a.b
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ kotlin.x invoke(com.tencent.mm.plugin.finder.video.r r12) {
            /*
            // Method dump skipped, instructions count: 381
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.video.FinderVideoLayout.m.invoke(java.lang.Object):java.lang.Object");
        }
    }

    /* access modifiers changed from: package-private */
    public static final class n extends kotlin.g.b.q implements kotlin.g.a.b<r, x> {
        final /* synthetic */ FinderVideoLayout wfB;
        final /* synthetic */ b wfI;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(b bVar, FinderVideoLayout finderVideoLayout) {
            super(1);
            this.wfI = bVar;
            this.wfB = finderVideoLayout;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(r rVar) {
            AppMethodBeat.i(254295);
            r rVar2 = rVar;
            if (rVar2 != null) {
                this.wfB.setVideoView(rVar2);
                com.tencent.mm.plugin.finder.loader.s sVar = this.wfI.uPf;
                this.wfI.feed.getExpectId();
                boolean z = this.wfI.dLQ;
                if (!kotlin.g.b.p.j(rVar2.getVideoMediaId(), this.wfI.uPf.auA())) {
                    q qVar = this.wfB.wfq;
                    if (qVar != null) {
                        qVar.setVisibility(0);
                    }
                    rVar2.setAlpha(0.0f);
                    FinderVideoLayout.a(this.wfB, rVar2, sVar, z, this.wfI.feed);
                }
                if (rVar2.dEN()) {
                    Log.i("Finder.VideoLayout", "[FinderVideoLayout#prepareToPlay] layout=[" + this.wfB.getWidth() + ':' + this.wfB.getHeight() + "] videoView=[" + rVar2.getWidth() + ':' + rVar2.getHeight() + "] video=[" + sVar.uIw.width + ':' + sVar.uIw.height + "] " + FinderVideoLayout.f(this.wfB) + ' ' + "media=" + sVar + ' ');
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(254295);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(FinderVideoLayout finderVideoLayout, String str) {
        AppMethodBeat.i(254332);
        finderVideoLayout.awJ(str);
        AppMethodBeat.o(254332);
    }

    public static final /* synthetic */ ImageView c(FinderVideoLayout finderVideoLayout) {
        AppMethodBeat.i(254327);
        ImageView thumbView = finderVideoLayout.getThumbView();
        AppMethodBeat.o(254327);
        return thumbView;
    }

    public static final /* synthetic */ boolean e(FinderVideoLayout finderVideoLayout) {
        AppMethodBeat.i(254329);
        boolean dFB = finderVideoLayout.dFB();
        AppMethodBeat.o(254329);
        return dFB;
    }

    public static final /* synthetic */ String f(FinderVideoLayout finderVideoLayout) {
        AppMethodBeat.i(168134);
        String dFF = finderVideoLayout.dFF();
        AppMethodBeat.o(168134);
        return dFF;
    }

    public static final /* synthetic */ void g(FinderVideoLayout finderVideoLayout) {
        AppMethodBeat.i(168135);
        finderVideoLayout.cJE();
        AppMethodBeat.o(168135);
    }

    public static final /* synthetic */ View i(FinderVideoLayout finderVideoLayout) {
        AppMethodBeat.i(254330);
        View bottomButtonLayout = finderVideoLayout.getBottomButtonLayout();
        AppMethodBeat.o(254330);
        return bottomButtonLayout;
    }

    public static final /* synthetic */ void k(FinderVideoLayout finderVideoLayout) {
        AppMethodBeat.i(168137);
        finderVideoLayout.showLoading();
        AppMethodBeat.o(168137);
    }

    public static final /* synthetic */ View l(FinderVideoLayout finderVideoLayout) {
        AppMethodBeat.i(168138);
        View loading = finderVideoLayout.getLoading();
        AppMethodBeat.o(168138);
        return loading;
    }

    public static final /* synthetic */ c.b o(FinderVideoLayout finderVideoLayout) {
        AppMethodBeat.i(168136);
        c.b videoPlayBehavior = finderVideoLayout.getVideoPlayBehavior();
        AppMethodBeat.o(168136);
        return videoPlayBehavior;
    }

    public static final /* synthetic */ View q(FinderVideoLayout finderVideoLayout) {
        AppMethodBeat.i(254331);
        View bulletSubtitleButton = finderVideoLayout.getBulletSubtitleButton();
        AppMethodBeat.o(254331);
        return bulletSubtitleButton;
    }

    public static final /* synthetic */ void t(FinderVideoLayout finderVideoLayout) {
        AppMethodBeat.i(254333);
        finderVideoLayout.cBY();
        AppMethodBeat.o(254333);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderVideoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.g.b.p.h(context, "context");
        AppMethodBeat.i(168131);
        setTag("Finder.VideoLayout");
        setId(R.id.ckd);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ViewModel viewModel = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderVideoStateCacheVM.class);
        kotlin.g.b.p.g(viewModel, "UICProvider.of(PluginFin…StateCacheVM::class.java)");
        this.wfe = (FinderVideoStateCacheVM) viewModel;
        this.wff = kotlin.g.ah(new k(this));
        this.wfh = kotlin.g.ah(new c(this));
        this.wfi = kotlin.g.ah(new d(this));
        this.wfj = kotlin.g.ah(new l(this));
        this.wfk = kotlin.g.ah(new r(this));
        this.mediaList = new LinkedList<>();
        this.wfm = kotlin.g.ah(new g(this));
        this.wfn = kotlin.g.ah(new o(this));
        this.wfo = kotlin.g.ah(new u(this));
        this.wcw = new j(this);
        this.wfw = -1.0f;
        this.wfx = -1;
        AppMethodBeat.o(168131);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderVideoLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        kotlin.g.b.p.h(context, "context");
        AppMethodBeat.i(168132);
        setTag("Finder.VideoLayout");
        setId(R.id.ckd);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ViewModel viewModel = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderVideoStateCacheVM.class);
        kotlin.g.b.p.g(viewModel, "UICProvider.of(PluginFin…StateCacheVM::class.java)");
        this.wfe = (FinderVideoStateCacheVM) viewModel;
        this.wff = kotlin.g.ah(new k(this));
        this.wfh = kotlin.g.ah(new c(this));
        this.wfi = kotlin.g.ah(new d(this));
        this.wfj = kotlin.g.ah(new l(this));
        this.wfk = kotlin.g.ah(new r(this));
        this.mediaList = new LinkedList<>();
        this.wfm = kotlin.g.ah(new g(this));
        this.wfn = kotlin.g.ah(new o(this));
        this.wfo = kotlin.g.ah(new u(this));
        this.wcw = new j(this);
        this.wfw = -1.0f;
        this.wfx = -1;
        AppMethodBeat.o(168132);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void setEnableShowLoading(boolean z) {
        this.wfd = z;
    }

    /* access modifiers changed from: package-private */
    public static final class d extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ FinderVideoLayout wfB;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderVideoLayout finderVideoLayout) {
            super(0);
            this.wfB = finderVideoLayout;
        }

        static final class a implements View.OnClickListener {
            final /* synthetic */ d wfC;

            a(d dVar) {
                this.wfC = dVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(254276);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderVideoLayout$bulletSubtitleButton$2$$special$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.plugin.finder.feed.e eVar = this.wfC.wfB.tOr;
                if (eVar == null) {
                    kotlin.g.b.p.hyc();
                }
                boolean z = !eVar.getFunctionSwitch();
                FinderVideoLayout.q(this.wfC.wfB).setSelected(z);
                com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                kotlin.g.b.p.g(aAh, "MMKernel.storage()");
                aAh.azQ().set(ar.a.USERINFO_FINDER_FEED_BULLET_SUBTITLE_SWITCH_BOOLEAN, Boolean.valueOf(z));
                com.tencent.mm.plugin.finder.feed.e eVar2 = this.wfC.wfB.tOr;
                if (eVar2 == null) {
                    kotlin.g.b.p.hyc();
                }
                eVar2.L(z, true);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/FinderVideoLayout$bulletSubtitleButton$2$$special$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(254276);
            }
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(254277);
            View findViewById = this.wfB.findViewById(R.id.j3y);
            TextView textView = (TextView) findViewById;
            kotlin.g.b.p.g(textView, LocaleUtil.ITALIAN);
            ao.a(textView.getPaint(), 0.8f);
            textView.setOnClickListener(new a(this));
            TextView textView2 = (TextView) findViewById;
            AppMethodBeat.o(254277);
            return textView2;
        }
    }

    public final r getVideoView() {
        return this.wfl;
    }

    public final void setVideoView(r rVar) {
        this.wfl = rVar;
    }

    public final k getVideoCore() {
        AppMethodBeat.i(168088);
        k kVar = this.tCD;
        if (kVar == null) {
            kotlin.g.b.p.btv("videoCore");
        }
        AppMethodBeat.o(168088);
        return kVar;
    }

    public final void setVideoCore(k kVar) {
        AppMethodBeat.i(168089);
        kotlin.g.b.p.h(kVar, "<set-?>");
        this.tCD = kVar;
        AppMethodBeat.o(168089);
    }

    public final void setLongVideo(boolean z) {
        this.isLongVideo = z;
    }

    /* access modifiers changed from: package-private */
    public static final class g extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ FinderVideoLayout wfB;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(FinderVideoLayout finderVideoLayout) {
            super(0);
            this.wfB = finderVideoLayout;
        }

        static final class a implements View.OnClickListener {
            final /* synthetic */ View tCl;
            final /* synthetic */ g wfF;

            a(View view, g gVar) {
                this.tCl = view;
                this.wfF = gVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(254281);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderVideoLayout$fullscreenIcon$2$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                cjk cjk = new cjk();
                cjk.mediaList.addAll(this.wfF.wfB.mediaList);
                com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                Context context = this.tCl.getContext();
                if (context == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(254281);
                    throw tVar;
                }
                com.tencent.mm.plugin.finder.utils.a.a((Activity) context, (ViewAnimHelper.ViewInfo) null, cjk, (azy) null, false, 24);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/FinderVideoLayout$fullscreenIcon$2$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(254281);
            }
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(254282);
            View findViewById = this.wfB.findViewById(R.id.dcb);
            findViewById.setOnClickListener(new a(findViewById, this));
            AppMethodBeat.o(254282);
            return findViewById;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class o extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ FinderVideoLayout wfB;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(FinderVideoLayout finderVideoLayout) {
            super(0);
            this.wfB = finderVideoLayout;
        }

        static final class a implements View.OnClickListener {
            final /* synthetic */ o wfJ;

            a(o oVar) {
                this.wfJ = oVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(168076);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderVideoLayout$retryBtn$2$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("Finder.VideoLayout", "retry video, position:" + this.wfJ.wfB.getPlayAdapterPosition());
                b playInfo = this.wfJ.wfB.getPlayInfo();
                if (playInfo != null && playInfo.wfz) {
                    r videoView = this.wfJ.wfB.getVideoView();
                    if (videoView != null) {
                        videoView.stop();
                    }
                    this.wfJ.wfB.play(this.wfJ.wfB.getPlayAdapterPosition());
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/FinderVideoLayout$retryBtn$2$$special$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(168076);
            }
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(168077);
            View findViewById = this.wfB.findViewById(R.id.h5r);
            findViewById.setOnClickListener(new a(this));
            AppMethodBeat.o(168077);
            return findViewById;
        }
    }

    public final void setMute(boolean z) {
        this.guh = z;
    }

    public static final class j implements y {
        final /* synthetic */ FinderVideoLayout wfB;

        j(FinderVideoLayout finderVideoLayout) {
            this.wfB = finderVideoLayout;
        }

        @Override // com.tencent.mm.plugin.finder.video.y
        public final void l(cjl cjl) {
            String str;
            AppMethodBeat.i(254287);
            FinderVideoLayout.a(this.wfB, "onBgPrepared");
            StringBuilder sb = new StringBuilder("onBgPrepared ");
            if (cjl == null || (str = cjl.mediaId) == null) {
                str = "";
            }
            Log.i("Finder.VideoLayout", sb.append(str).toString());
            AppMethodBeat.o(254287);
        }

        @Override // com.tencent.mm.plugin.finder.video.y
        public final void b(s sVar) {
            AppMethodBeat.i(254288);
            if (sVar != null) {
                com.tencent.mm.plugin.finder.storage.logic.d dVar = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
                at avH = com.tencent.mm.plugin.finder.storage.logic.d.avH(sVar.mediaId);
                if (!avH.field_hasPlayed) {
                    avH.field_hasPlayed = true;
                    com.tencent.mm.ac.d.i(new a(avH));
                }
                c.b o = FinderVideoLayout.o(this.wfB);
                if (o != null) {
                    o.e(sVar.wgm.getId(), sVar.wgl, sVar.tHN);
                    AppMethodBeat.o(254288);
                    return;
                }
                AppMethodBeat.o(254288);
                return;
            }
            AppMethodBeat.o(254288);
        }

        @Override // com.tencent.mm.plugin.finder.video.y
        public final void a(s sVar, int i2) {
            AppMethodBeat.i(254289);
            b playInfo = this.wfB.getPlayInfo();
            if (playInfo != null) {
                c.b o = FinderVideoLayout.o(this.wfB);
                if (o != null) {
                    o.a(playInfo.feed.getId(), playInfo.uPf.uIw, sVar, this.wfB.getPlayAdapterPosition(), playInfo.uPf, i2);
                    AppMethodBeat.o(254289);
                    return;
                }
                AppMethodBeat.o(254289);
                return;
            }
            AppMethodBeat.o(254289);
        }

        @Override // com.tencent.mm.plugin.finder.video.y
        public final void Gr(long j2) {
            AppMethodBeat.i(254290);
            b playInfo = this.wfB.getPlayInfo();
            if (playInfo != null) {
                af afVar = af.viA;
                String str = playInfo.uPf.uIw.mediaId;
                if (str == null) {
                    str = "";
                }
                af.bq(str, true);
                this.wfB.fo("", playInfo.mediaId);
                c.b o = FinderVideoLayout.o(this.wfB);
                if (o != null) {
                    o.a(playInfo.feed.getExpectId(), playInfo.uPf.uIw, playInfo.uPf, j2);
                    AppMethodBeat.o(254290);
                    return;
                }
                AppMethodBeat.o(254290);
                return;
            }
            AppMethodBeat.o(254290);
        }

        @Override // com.tencent.mm.plugin.finder.video.y
        public final void dFK() {
            Long l;
            FeedData feedData;
            f.a aVar = null;
            AppMethodBeat.i(254291);
            b playInfo = this.wfB.getPlayInfo();
            if (playInfo != null) {
                af afVar = af.viA;
                String str = playInfo.uPf.uIw.mediaId;
                if (str == null) {
                    str = "";
                }
                af.auO(str);
                FinderVideoLayout finderVideoLayout = this.wfB;
                String str2 = playInfo.mediaId;
                StringBuilder sb = new StringBuilder("[onFirstVideoFrameRendered] videoView=");
                r rVar = finderVideoLayout.wfl;
                Log.i("Finder.VideoLayout", sb.append(rVar != null ? Integer.valueOf(rVar.hashCode()) : null).append(" mediaId=").append(str2).toString());
                com.tencent.mm.plugin.finder.report.f fVar = com.tencent.mm.plugin.finder.report.f.veb;
                b bVar = finderVideoLayout.wfp;
                if (bVar == null || (feedData = bVar.feed) == null) {
                    l = null;
                } else {
                    l = Long.valueOf(feedData.getId());
                }
                if (l != null) {
                    l.longValue();
                    f.a EZ = com.tencent.mm.plugin.finder.report.f.EZ(l.longValue());
                    if ((EZ.vee > 0 || EZ.vec > 0) && EZ.veh == 0) {
                        aVar = EZ;
                    }
                    if (aVar != null) {
                        aVar.veh = cl.aWA();
                        com.tencent.mm.plugin.finder.report.f.vdZ.add(aVar);
                        com.tencent.mm.plugin.finder.report.f.vdY.clear();
                    }
                }
                c.b o = FinderVideoLayout.o(this.wfB);
                if (o != null) {
                    o.g(playInfo.feed.getExpectId(), playInfo.uPf.uIw, playInfo.uPf);
                    AppMethodBeat.o(254291);
                    return;
                }
                AppMethodBeat.o(254291);
                return;
            }
            AppMethodBeat.o(254291);
        }

        @Override // com.tencent.mm.plugin.finder.video.y
        public final void dFL() {
            AppMethodBeat.i(168062);
            b playInfo = this.wfB.getPlayInfo();
            if (playInfo != null) {
                c.b o = FinderVideoLayout.o(this.wfB);
                if (o != null) {
                    o.b(playInfo.feed.getExpectId(), playInfo.uPf.uIw, playInfo.mediaList, playInfo.uPf);
                    AppMethodBeat.o(168062);
                    return;
                }
                AppMethodBeat.o(168062);
                return;
            }
            AppMethodBeat.o(168062);
        }

        @Override // com.tencent.mm.plugin.finder.video.y
        public final void dFM() {
            AppMethodBeat.i(168063);
            b playInfo = this.wfB.getPlayInfo();
            if (playInfo != null) {
                c.b o = FinderVideoLayout.o(this.wfB);
                if (o != null) {
                    o.d(playInfo.feed.getExpectId(), playInfo.uPf.uIw, playInfo.uPf);
                }
                hj hjVar = new hj();
                hjVar.dLP.feedId = playInfo.feed.getExpectId();
                hjVar.dLP.dLR = true;
                hjVar.dLP.dLS = this.wfB.dLS;
                EventCenter.instance.publish(hjVar);
                AppMethodBeat.o(168063);
                return;
            }
            AppMethodBeat.o(168063);
        }

        @Override // com.tencent.mm.plugin.finder.video.y
        public final void dFN() {
            AppMethodBeat.i(168064);
            b playInfo = this.wfB.getPlayInfo();
            if (playInfo != null) {
                c.b o = FinderVideoLayout.o(this.wfB);
                if (o != null) {
                    o.a(playInfo.feed.getExpectId(), playInfo.uPf.uIw, playInfo.mediaList, playInfo.uPf);
                }
                if (this.wfB.iJF > 0) {
                    af afVar = af.viA;
                    String str = playInfo.uPf.uIw.mediaId;
                    if (str == null) {
                        str = "";
                    }
                    af.auN(str);
                    r videoView = this.wfB.getVideoView();
                    if (videoView != null) {
                        videoView.c(((double) this.wfB.iJF) / 1000.0d, true);
                    }
                    this.wfB.iJF = 0;
                }
                AppMethodBeat.o(168064);
                return;
            }
            AppMethodBeat.o(168064);
        }

        @Override // com.tencent.mm.plugin.finder.video.y
        public final void a(com.tencent.mm.plugin.finder.video.reporter.c cVar) {
            AppMethodBeat.i(254292);
            b playInfo = this.wfB.getPlayInfo();
            if (playInfo != null) {
                c.b o = FinderVideoLayout.o(this.wfB);
                if (o != null) {
                    o.a(playInfo.feed.getExpectId(), playInfo.uPf.uIw, playInfo.mediaList, playInfo.uPf, cVar);
                    AppMethodBeat.o(254292);
                    return;
                }
                AppMethodBeat.o(254292);
                return;
            }
            AppMethodBeat.o(254292);
        }

        @Override // com.tencent.mm.plugin.finder.video.y
        public final void a(cjl cjl, int i2, int i3) {
            com.tencent.mm.pluginsdk.ui.tools.j jVar;
            q qVar;
            q qVar2;
            AppMethodBeat.i(254293);
            b playInfo = this.wfB.getPlayInfo();
            if (playInfo != null) {
                r videoView = this.wfB.getVideoView();
                int currentPlaySecond = videoView != null ? videoView.getCurrentPlaySecond() : 0;
                c.b o = FinderVideoLayout.o(this.wfB);
                if (o != null) {
                    o.a(playInfo.feed.getExpectId(), playInfo.uPf.uIw, i2, i3, playInfo.uPf);
                }
                if (i2 >= 20 && (qVar = this.wfB.wfq) != null && !qVar.dEY() && (qVar2 = this.wfB.wfq) != null) {
                    qVar2.oI(false);
                }
                cjx cjx = playInfo.uOR;
                if (cjx != null) {
                    if (!(cjx.iqg > 0 && cjx.dvv >= 0 && cjx.iqg > cjx.dvv)) {
                        cjx = null;
                    }
                    if (cjx != null && currentPlaySecond >= cjx.iqg / 1000) {
                        r videoView2 = this.wfB.getVideoView();
                        if (!(videoView2 instanceof FinderCropVideoView)) {
                            videoView2 = null;
                        }
                        FinderCropVideoView finderCropVideoView = (FinderCropVideoView) videoView2;
                        if (!(finderCropVideoView == null || (jVar = finderCropVideoView.qbJ) == null)) {
                            jVar.d(0.0d, true);
                        }
                        hj hjVar = new hj();
                        hjVar.dLP.dLQ = true;
                        hjVar.dLP.feedId = playInfo.feed.getLocalId();
                        hjVar.dLP.dLR = true;
                        hjVar.dLP.dLS = this.wfB.dLS;
                        EventCenter.instance.publish(hjVar);
                    }
                }
                if (cjl == null || cjl.MoL != 3) {
                    com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                    int drG = com.tencent.mm.plugin.finder.storage.c.drG();
                    com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
                    if (currentPlaySecond == drG - ((Number) com.tencent.mm.plugin.finder.storage.c.vxi.getValue()).intValue()) {
                        hj hjVar2 = new hj();
                        hjVar2.dLP.dLQ = playInfo.feed.getLocalId() != 0;
                        hjVar2.dLP.feedId = hjVar2.dLP.dLQ ? playInfo.feed.getLocalId() : playInfo.feed.getFeedId();
                        hjVar2.dLP.dLS = this.wfB.dLS;
                        EventCenter.instance.publish(hjVar2);
                    }
                }
                FinderVideoLayout.t(this.wfB);
                AppMethodBeat.o(254293);
                return;
            }
            AppMethodBeat.o(254293);
        }

        @Override // com.tencent.mm.plugin.finder.video.y
        public final void dFO() {
            AppMethodBeat.i(254294);
            if (this.wfB.getPlayInfo() != null) {
                FinderVideoLayout.t(this.wfB);
            }
            AppMethodBeat.o(254294);
        }

        static final class a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ at wfH;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(at atVar) {
                super(0);
                this.wfH = atVar;
            }

            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(254286);
                com.tencent.mm.plugin.finder.storage.logic.d dVar = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
                String str = this.wfH.field_mediaId;
                kotlin.g.b.p.g(str, "mediaCache.field_mediaId");
                kotlin.g.b.p.h(str, "mediaId");
                w wVar = com.tencent.mm.plugin.finder.storage.logic.d.toc;
                at avH = com.tencent.mm.plugin.finder.storage.logic.d.avH(str);
                avH.field_hasPlayed = true;
                wVar.c(avH);
                x xVar = x.SXb;
                AppMethodBeat.o(254286);
                return xVar;
            }
        }
    }

    public final y getLifecycle() {
        return this.wcw;
    }

    public static final class b {
        final boolean dLQ;
        public final FeedData feed;
        public final String mediaId;
        final LinkedList<cjl> mediaList;
        private final int position;
        cjx uOR;
        public final com.tencent.mm.plugin.finder.loader.s uPf;
        public boolean wbG;
        boolean wfA;
        public boolean wfz;

        /* JADX WARNING: Code restructure failed: missing block: B:23:0x005c, code lost:
            if (kotlin.g.b.p.j(r3.uOR, r4.uOR) != false) goto L_0x005e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
            // Method dump skipped, instructions count: 104
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.video.FinderVideoLayout.b.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 1;
            int i3 = 0;
            AppMethodBeat.i(168055);
            FeedData feedData = this.feed;
            int hashCode = (feedData != null ? feedData.hashCode() : 0) * 31;
            String str = this.mediaId;
            int hashCode2 = ((str != null ? str.hashCode() : 0) + hashCode) * 31;
            com.tencent.mm.plugin.finder.loader.s sVar = this.uPf;
            int hashCode3 = ((((sVar != null ? sVar.hashCode() : 0) + hashCode2) * 31) + this.position) * 31;
            LinkedList<cjl> linkedList = this.mediaList;
            int hashCode4 = ((linkedList != null ? linkedList.hashCode() : 0) + hashCode3) * 31;
            boolean z = this.dLQ;
            if (z) {
                z = true;
            }
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            int i6 = z ? 1 : 0;
            int i7 = (i4 + hashCode4) * 31;
            boolean z2 = this.wfz;
            if (z2) {
                z2 = true;
            }
            int i8 = z2 ? 1 : 0;
            int i9 = z2 ? 1 : 0;
            int i10 = z2 ? 1 : 0;
            int i11 = (i8 + i7) * 31;
            boolean z3 = this.wbG;
            if (z3) {
                z3 = true;
            }
            int i12 = z3 ? 1 : 0;
            int i13 = z3 ? 1 : 0;
            int i14 = z3 ? 1 : 0;
            int i15 = (i12 + i11) * 31;
            boolean z4 = this.wfA;
            if (!z4) {
                i2 = z4 ? 1 : 0;
            }
            int i16 = (i15 + i2) * 31;
            cjx cjx = this.uOR;
            if (cjx != null) {
                i3 = cjx.hashCode();
            }
            int i17 = i16 + i3;
            AppMethodBeat.o(168055);
            return i17;
        }

        public final String toString() {
            AppMethodBeat.i(168054);
            String str = "PlayInfo(feed=" + this.feed + ", mediaId=" + this.mediaId + ", media=" + this.uPf + ", position=" + this.position + ", mediaList=" + this.mediaList + ", isLocal=" + this.dLQ + ", isFocusPlaying=" + this.wfz + ", isSeekMode=" + this.wbG + ", isHasPlayed=" + this.wfA + ", cropInfo=" + this.uOR + ")";
            AppMethodBeat.o(168054);
            return str;
        }

        private b(FeedData feedData, String str, com.tencent.mm.plugin.finder.loader.s sVar, int i2, LinkedList<cjl> linkedList, boolean z, cjx cjx) {
            kotlin.g.b.p.h(feedData, "feed");
            kotlin.g.b.p.h(str, "mediaId");
            kotlin.g.b.p.h(sVar, "media");
            kotlin.g.b.p.h(linkedList, "mediaList");
            AppMethodBeat.i(254274);
            this.feed = feedData;
            this.mediaId = str;
            this.uPf = sVar;
            this.position = i2;
            this.mediaList = linkedList;
            this.dLQ = z;
            this.wfz = false;
            this.wbG = false;
            this.wfA = false;
            this.uOR = cjx;
            AppMethodBeat.o(254274);
        }

        public /* synthetic */ b(FeedData feedData, String str, com.tencent.mm.plugin.finder.loader.s sVar, int i2, LinkedList linkedList, boolean z, cjx cjx, byte b2) {
            this(feedData, str, sVar, i2, linkedList, z, cjx);
        }
    }

    public final b getPlayInfo() {
        return this.wfp;
    }

    public final void setPlayInfo(b bVar) {
        this.wfp = bVar;
    }

    public final FinderLongVideoPlayerSeekBar getLongVideoSeekBar() {
        return this.wfr;
    }

    public final void setLongVideoSeekBar(FinderLongVideoPlayerSeekBar finderLongVideoPlayerSeekBar) {
        this.wfr = finderLongVideoPlayerSeekBar;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.m<? super java.lang.Boolean, ? super com.tencent.mm.plugin.finder.video.FinderVideoLayout$b, kotlin.x>, kotlin.g.a.m<java.lang.Boolean, com.tencent.mm.plugin.finder.video.FinderVideoLayout$b, kotlin.x> */
    public final kotlin.g.a.m<Boolean, b, x> getVideoPauseCallback() {
        return this.wfs;
    }

    public final void setVideoPauseCallback(kotlin.g.a.m<? super Boolean, ? super b, x> mVar) {
        this.wfs = mVar;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.m<? super java.lang.Boolean, ? super com.tencent.mm.plugin.finder.video.FinderVideoLayout$b, kotlin.x>, kotlin.g.a.m<java.lang.Boolean, com.tencent.mm.plugin.finder.video.FinderVideoLayout$b, kotlin.x> */
    public final kotlin.g.a.m<Boolean, b, x> getThumbShowCallback() {
        return this.wft;
    }

    public final void setThumbShowCallback(kotlin.g.a.m<? super Boolean, ? super b, x> mVar) {
        this.wft = mVar;
    }

    public static /* synthetic */ void a(FinderVideoLayout finderVideoLayout, int i2, FeedData feedData, int i3, boolean z, boolean z2, int i4) {
        int i5;
        boolean z3;
        boolean z4;
        AppMethodBeat.i(254304);
        if ((i4 & 8) != 0) {
            i5 = 0;
        } else {
            i5 = i3;
        }
        if ((i4 & 16) != 0) {
            z3 = false;
        } else {
            z3 = z;
        }
        if ((i4 & 32) != 0) {
            z4 = true;
        } else {
            z4 = z2;
        }
        finderVideoLayout.a(i2, feedData, null, i5, z3, z4, null, null);
        AppMethodBeat.o(254304);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:62:0x027e, code lost:
        if (r2 == null) goto L_0x0280;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x02c4, code lost:
        if (r2 == null) goto L_0x02c6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r14, com.tencent.mm.plugin.finder.storage.FeedData r15, com.tencent.mm.plugin.finder.video.q r16, int r17, boolean r18, boolean r19, kotlin.g.a.m<? super java.lang.Boolean, ? super com.tencent.mm.plugin.finder.video.FinderVideoLayout.b, kotlin.x> r20, kotlin.g.a.m<? super java.lang.Boolean, ? super com.tencent.mm.plugin.finder.video.FinderVideoLayout.b, kotlin.x> r21) {
        /*
        // Method dump skipped, instructions count: 1019
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.video.FinderVideoLayout.a(int, com.tencent.mm.plugin.finder.storage.FeedData, com.tencent.mm.plugin.finder.video.q, int, boolean, boolean, kotlin.g.a.m, kotlin.g.a.m):void");
    }

    public final int getPlayAdapterPosition() {
        return this.wfu;
    }

    public final void setPlayAdapterPosition(int i2) {
        this.wfu = i2;
    }

    public static /* synthetic */ void a(FinderVideoLayout finderVideoLayout) {
        AppMethodBeat.i(168096);
        finderVideoLayout.play(0);
        AppMethodBeat.o(168096);
    }

    public final void play(int i2) {
        AppMethodBeat.i(168095);
        this.wfu = i2;
        com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
        com.tencent.mm.plugin.finder.report.live.k.dpl().vlQ = i2;
        if (this.wfp == null) {
            AppMethodBeat.o(168095);
            return;
        }
        b bVar = this.wfp;
        if (bVar == null) {
            kotlin.g.b.p.hyc();
        }
        k kVar2 = this.tCD;
        if (kVar2 == null) {
            kotlin.g.b.p.btv("videoCore");
        }
        kVar2.dFx().a(this, bVar.uPf, new m(this, bVar));
        AppMethodBeat.o(168095);
    }

    public final void dFA() {
        AppMethodBeat.i(254305);
        b bVar = this.wfp;
        if (bVar != null) {
            k kVar = this.tCD;
            if (kVar == null) {
                kotlin.g.b.p.btv("videoCore");
            }
            kVar.dFx().a(this, bVar.uPf, new n(bVar, this));
            AppMethodBeat.o(254305);
            return;
        }
        AppMethodBeat.o(254305);
    }

    private final boolean dFB() {
        b bVar = this.wfp;
        return bVar != null && bVar.wbG;
    }

    public static /* synthetic */ void b(FinderVideoLayout finderVideoLayout) {
        AppMethodBeat.i(168098);
        finderVideoLayout.pause(false);
        AppMethodBeat.o(168098);
    }

    public final void pause(boolean z) {
        String str;
        boolean z2;
        FeedData feedData;
        boolean z3;
        AppMethodBeat.i(168097);
        b bVar = this.wfp;
        if (bVar == null || bVar.wfz || z) {
            StringBuilder append = new StringBuilder("[FinderVideoLayout#pause] ").append(dFF()).append(" isForceRemoveVideoView=").append(z).append(" isSeekMode=");
            b bVar2 = this.wfp;
            StringBuilder append2 = append.append(bVar2 != null ? Boolean.valueOf(bVar2.wbG) : null).append(' ').append("media=");
            b bVar3 = this.wfp;
            if (bVar3 != null) {
                str = bVar3.mediaId;
            } else {
                str = null;
            }
            Log.i("Finder.VideoLayout", append2.append(str).toString());
            b bVar4 = this.wfp;
            if (bVar4 != null) {
                z2 = bVar4.wbG;
            } else {
                z2 = false;
            }
            k kVar = this.tCD;
            if (kVar == null) {
                kotlin.g.b.p.btv("videoCore");
            }
            FinderVideoRecycler dFx = kVar.dFx();
            FinderVideoLayout finderVideoLayout = this;
            kotlin.g.b.p.h(finderVideoLayout, "parent");
            dFx.wAY.put(Integer.valueOf(finderVideoLayout.hashCode()), null);
            View findViewWithTag = finderVideoLayout.findViewWithTag(Integer.valueOf(finderVideoLayout.hashCode()));
            if (findViewWithTag instanceof r) {
                r rVar = (r) findViewWithTag;
                Log.i("Finder.VideoRecycler", "[pauseOrRecycle] pauseWithCancel mediaId:" + rVar.getVideoMediaId() + " videoView(" + rVar.hashCode() + ") isForceRemove=" + z + " isTryKeep=" + z2);
                rVar.setVideoViewFocused(false);
                if (z2 || !z) {
                    rVar.dFk();
                } else {
                    dFx.a(rVar, "pauseAndRecycle");
                }
            }
            cJE();
            com.tencent.mm.plugin.finder.feed.e eVar = this.tOr;
            if (eVar != null) {
                eVar.reset(false);
            }
            b bVar5 = this.wfp;
            if (bVar5 != null) {
                bVar5.wfz = false;
            }
            this.wfx = -1;
            b bVar6 = this.wfp;
            if (!(bVar6 == null || (feedData = bVar6.feed) == null)) {
                hj hjVar = new hj();
                hjVar.dLP.feedId = feedData.getLocalId() != 0 ? feedData.getLocalId() : feedData.getFeedId();
                hj.a aVar = hjVar.dLP;
                if (feedData.getLocalId() != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                aVar.dLQ = z3;
                hjVar.dLP.dLD = true;
                hjVar.dLP.dLS = this.dLS;
                EventCenter.instance.publish(hjVar);
            }
            setKeepScreenOn(false);
            AppMethodBeat.o(168097);
            return;
        }
        AppMethodBeat.o(168097);
    }

    public final void onDetachedFromWindow() {
        String str;
        AppMethodBeat.i(168099);
        super.onDetachedFromWindow();
        StringBuilder sb = new StringBuilder("[onDetachedFromWindow] ");
        b bVar = this.wfp;
        if (bVar != null) {
            str = bVar.mediaId;
        } else {
            str = null;
        }
        Log.i("Finder.VideoLayout", sb.append(str).toString());
        pause(!this.wfg);
        com.tencent.mm.plugin.finder.feed.d dVar = this.tOs;
        if (dVar != null) {
            dVar.onDetach();
            AppMethodBeat.o(168099);
            return;
        }
        AppMethodBeat.o(168099);
    }

    @Override // com.tencent.mm.plugin.finder.video.x
    public final void ac(String str, int i2, int i3) {
        AppMethodBeat.i(169678);
        kotlin.g.b.p.h(str, "mediaId");
        b bVar = this.wfp;
        if (bVar != null) {
            if (!bVar.wfz) {
                bVar = null;
            }
            if (bVar != null) {
                c.b videoPlayBehavior = getVideoPlayBehavior();
                if (videoPlayBehavior != null) {
                    videoPlayBehavior.e(bVar.feed.getExpectId(), bVar.uPf.uIw, i2, i3, bVar.uPf);
                    AppMethodBeat.o(169678);
                    return;
                }
                AppMethodBeat.o(169678);
                return;
            }
        }
        AppMethodBeat.o(169678);
    }

    public final void onViewAdded(View view) {
        AppMethodBeat.i(168101);
        kotlin.g.b.p.h(view, "child");
        super.onViewAdded(view);
        if (view instanceof r) {
            Log.i("Finder.VideoLayout", "[onViewAdded] isPreviewing=" + ((r) view).dEO() + ' ' + dFF());
            if (((r) view).dEO()) {
                setVisibility(0);
            }
        }
        AppMethodBeat.o(168101);
    }

    public final void onViewRemoved(View view) {
        int i2 = 0;
        AppMethodBeat.i(168102);
        kotlin.g.b.p.h(view, "child");
        super.onViewRemoved(view);
        if (kotlin.g.b.p.j(view, this.wfl) && (view instanceof r)) {
            Log.i("Finder.VideoLayout", "[onViewRemoved] isPreviewing=" + ((r) view).dEO() + ' ' + dFF());
            q qVar = this.wfq;
            if (qVar != null) {
                qVar.dEX();
            }
            b bVar = this.wfp;
            if (bVar != null && bVar.wbG) {
                FinderVideoStateCacheVM finderVideoStateCacheVM = this.wfe;
                b bVar2 = this.wfp;
                if (bVar2 == null) {
                    kotlin.g.b.p.hyc();
                }
                String str = bVar2.mediaId;
                q qVar2 = this.wfq;
                int currentProgress = qVar2 != null ? qVar2.getCurrentProgress() : 0;
                r rVar = this.wfl;
                if (rVar != null) {
                    i2 = rVar.getCurrentPlaySecond();
                }
                finderVideoStateCacheVM.ah(str, currentProgress, i2);
            }
            if (((r) view).dEO()) {
                setVisibility(4);
                AppMethodBeat.o(168102);
                return;
            }
            dFC();
            cJE();
            this.wfl = null;
        }
        AppMethodBeat.o(168102);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void c(String str, String str2, String str3, int i2, int i3) {
        AppMethodBeat.i(168103);
        StringBuilder sb = new StringBuilder("[onError] videoView=");
        r rVar = this.wfl;
        Log.i("Finder.VideoLayout", sb.append(rVar != null ? Integer.valueOf(rVar.hashCode()) : null).append(" mediaId=").append(str2).append(" errorMsg=").append(str3).append(" what=").append(i2).append(" extra=").append(i3).toString());
        q qVar = this.wfq;
        if (qVar != null) {
            qVar.setVisibility(8);
        }
        dFD();
        com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
        com.tencent.mm.plugin.finder.report.k.Kv(i2);
        b bVar = this.wfp;
        if (bVar != null) {
            c.b videoPlayBehavior = getVideoPlayBehavior();
            if (videoPlayBehavior != null) {
                videoPlayBehavior.a(bVar.feed.getExpectId(), bVar.uPf.uIw, i2);
                AppMethodBeat.o(168103);
                return;
            }
            AppMethodBeat.o(168103);
            return;
        }
        AppMethodBeat.o(168103);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dH(String str, String str2) {
        Integer num;
        Integer num2 = null;
        AppMethodBeat.i(168104);
        r rVar = this.wfl;
        if (rVar != null) {
            num = Integer.valueOf(rVar.getVideoDuration());
        } else {
            num = null;
        }
        StringBuilder sb = new StringBuilder("[onPrepared] videoView=");
        r rVar2 = this.wfl;
        if (rVar2 != null) {
            num2 = Integer.valueOf(rVar2.hashCode());
        }
        Log.i("Finder.VideoLayout", sb.append(num2).append(" mediaId=").append(str2).append(" thumbVisible=").append(getThumbView().getVisibility()).append(" duration=").append(num).toString());
        AppMethodBeat.o(168104);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dI(String str, String str2) {
        AppMethodBeat.i(168105);
        StringBuilder sb = new StringBuilder("[onVideoEnded] videoView=");
        r rVar = this.wfl;
        Log.i("Finder.VideoLayout", sb.append(rVar != null ? Integer.valueOf(rVar.hashCode()) : null).append(" mediaId=").append(str2).toString());
        AppMethodBeat.o(168105);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void d(String str, String str2, int i2, int i3) {
        AppMethodBeat.i(168106);
        StringBuilder sb = new StringBuilder("[onGetVideoSize] videoView=");
        r rVar = this.wfl;
        Log.i("Finder.VideoLayout", sb.append(rVar != null ? Integer.valueOf(rVar.hashCode()) : null).append(" mediaId=").append(str2).append(" width=").append(i2).append(" height=").append(i3).toString());
        AppMethodBeat.o(168106);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dJ(String str, String str2) {
        Long l2;
        FeedData feedData;
        f.a aVar = null;
        AppMethodBeat.i(168107);
        StringBuilder sb = new StringBuilder("[onVideoPause] videoView=");
        r rVar = this.wfl;
        Log.i("Finder.VideoLayout", sb.append(rVar != null ? Integer.valueOf(rVar.hashCode()) : null).append(" mediaId=").append(str2).toString());
        cJE();
        com.tencent.mm.plugin.finder.report.f fVar = com.tencent.mm.plugin.finder.report.f.veb;
        b bVar = this.wfp;
        if (bVar == null || (feedData = bVar.feed) == null) {
            l2 = null;
        } else {
            l2 = Long.valueOf(feedData.getId());
        }
        if (l2 != null) {
            l2.longValue();
            f.a EZ = com.tencent.mm.plugin.finder.report.f.EZ(l2.longValue());
            if (EZ.vec > 0 && EZ.veg == 0 && EZ.ved == 0) {
                aVar = EZ;
            }
            if (aVar != null) {
                aVar.ved = cl.aWA();
                com.tencent.mm.plugin.finder.report.f.vdZ.add(aVar);
                com.tencent.mm.plugin.finder.report.f.vdY.remove(l2);
                AppMethodBeat.o(168107);
                return;
            }
            AppMethodBeat.o(168107);
            return;
        }
        AppMethodBeat.o(168107);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dK(String str, String str2) {
        Integer num;
        FeedData feedData;
        Long l2 = null;
        AppMethodBeat.i(168108);
        r rVar = this.wfl;
        int videoDuration = rVar != null ? rVar.getVideoDuration() : 0;
        StringBuilder sb = new StringBuilder("[onVideoPlay] videoView=");
        r rVar2 = this.wfl;
        if (rVar2 != null) {
            num = Integer.valueOf(rVar2.hashCode());
        } else {
            num = null;
        }
        StringBuilder append = sb.append(num).append(" mediaId=").append(str2).append(" duration=").append(videoDuration).append(" isHasPlayed=");
        b bVar = this.wfp;
        Log.i("Finder.VideoLayout", append.append(bVar != null ? Boolean.valueOf(bVar.wfA) : null).toString());
        cJE();
        dFE();
        r rVar3 = this.wfl;
        if (rVar3 != null) {
            rVar3.setKeepScreenOn(true);
        }
        this.wfw = -1.0f;
        cBY();
        com.tencent.mm.plugin.finder.report.f fVar = com.tencent.mm.plugin.finder.report.f.veb;
        b bVar2 = this.wfp;
        if (!(bVar2 == null || (feedData = bVar2.feed) == null)) {
            l2 = Long.valueOf(feedData.getId());
        }
        fVar.i(l2);
        com.tencent.mm.plugin.finder.report.h hVar = com.tencent.mm.plugin.finder.report.h.veu;
        com.tencent.mm.plugin.finder.report.h.Kk(this.dLS);
        AppMethodBeat.o(168108);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dL(String str, String str2) {
        b bVar = null;
        AppMethodBeat.i(168109);
        StringBuilder sb = new StringBuilder("[onVideoWaiting] videoView=");
        r rVar = this.wfl;
        Log.i("Finder.VideoLayout", sb.append(rVar != null ? Integer.valueOf(rVar.hashCode()) : null).append(" mediaId=").append(str2).append(" thumbVisible=").append(getThumbView().getVisibility()).toString());
        r rVar2 = this.wfl;
        if ((rVar2 != null && rVar2.getVideoViewFocused()) || str == null) {
            showLoading();
            b bVar2 = this.wfp;
            if (bVar2 != null) {
                if (bVar2.wfz) {
                    bVar = bVar2;
                }
                if (bVar != null) {
                    c.b videoPlayBehavior = getVideoPlayBehavior();
                    if (videoPlayBehavior != null) {
                        videoPlayBehavior.b(bVar.feed.getExpectId(), bVar.uPf.uIw, bVar.uPf);
                        AppMethodBeat.o(168109);
                        return;
                    }
                    AppMethodBeat.o(168109);
                    return;
                }
            }
        }
        AppMethodBeat.o(168109);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void dM(String str, String str2) {
        b bVar = null;
        AppMethodBeat.i(168110);
        StringBuilder sb = new StringBuilder("[onVideoWaitingEnd] videoView=");
        r rVar = this.wfl;
        Log.i("Finder.VideoLayout", sb.append(rVar != null ? Integer.valueOf(rVar.hashCode()) : null).append(" mediaId=").append(str2).toString());
        cJE();
        b bVar2 = this.wfp;
        if (bVar2 != null) {
            if (bVar2.wfz) {
                bVar = bVar2;
            }
            if (bVar != null) {
                c.b videoPlayBehavior = getVideoPlayBehavior();
                if (videoPlayBehavior != null) {
                    videoPlayBehavior.c(bVar.feed.getExpectId(), bVar.uPf.uIw, bVar.uPf);
                    AppMethodBeat.o(168110);
                    return;
                }
                AppMethodBeat.o(168110);
                return;
            }
        }
        AppMethodBeat.o(168110);
    }

    @Override // com.tencent.mm.pluginsdk.ui.i.b
    public final void fo(String str, String str2) {
        Long l2;
        FeedData feedData;
        f.a aVar = null;
        AppMethodBeat.i(254306);
        StringBuilder sb = new StringBuilder("[onVideoFirstFrameDraw] videoView=");
        r rVar = this.wfl;
        Log.i("Finder.VideoLayout", sb.append(rVar != null ? Integer.valueOf(rVar.hashCode()) : null).append(" mediaId=").append(str2).toString());
        awJ("onVideoFirstFrameDraw");
        com.tencent.mm.plugin.finder.report.h hVar = com.tencent.mm.plugin.finder.report.h.veu;
        com.tencent.mm.plugin.finder.report.h.Ki(this.dLS);
        com.tencent.mm.plugin.finder.report.f fVar = com.tencent.mm.plugin.finder.report.f.veb;
        b bVar = this.wfp;
        if (bVar == null || (feedData = bVar.feed) == null) {
            l2 = null;
        } else {
            l2 = Long.valueOf(feedData.getId());
        }
        if (l2 != null) {
            l2.longValue();
            f.a EZ = com.tencent.mm.plugin.finder.report.f.EZ(l2.longValue());
            if ((EZ.vee > 0 || EZ.vec > 0) && EZ.veg == 0) {
                aVar = EZ;
            }
            if (aVar != null) {
                aVar.veg = cl.aWA();
                com.tencent.mm.plugin.finder.report.f.vdZ.add(aVar);
                com.tencent.mm.plugin.finder.report.f.vdY.clear();
                AppMethodBeat.o(254306);
                return;
            }
            AppMethodBeat.o(254306);
            return;
        }
        AppMethodBeat.o(254306);
    }

    @Override // com.tencent.mm.plugin.finder.video.x
    public final void b(com.tencent.mm.plugin.finder.loader.s sVar) {
        FeedData feedData;
        c.b videoPlayBehavior;
        Long l2 = null;
        AppMethodBeat.i(254307);
        kotlin.g.b.p.h(sVar, "video");
        StringBuilder sb = new StringBuilder("[onStartDownload] videoView=");
        r rVar = this.wfl;
        Log.i("Finder.VideoLayout", sb.append(rVar != null ? Integer.valueOf(rVar.hashCode()) : null).append(" FinderVideo=").append(sVar).append(" thumbVisible=").append(getThumbView().getVisibility()).toString());
        dFE();
        b bVar = this.wfp;
        if (bVar != null) {
            if (!bVar.wfz) {
                bVar = null;
            }
            if (!(bVar == null || (videoPlayBehavior = getVideoPlayBehavior()) == null)) {
                videoPlayBehavior.f(bVar.feed.getExpectId(), bVar.uPf.uIw, bVar.uPf);
            }
        }
        com.tencent.mm.plugin.finder.report.h hVar = com.tencent.mm.plugin.finder.report.h.veu;
        com.tencent.mm.plugin.finder.report.h.Kh(this.dLS);
        com.tencent.mm.plugin.finder.report.f fVar = com.tencent.mm.plugin.finder.report.f.veb;
        b bVar2 = this.wfp;
        if (!(bVar2 == null || (feedData = bVar2.feed) == null)) {
            l2 = Long.valueOf(feedData.getId());
        }
        fVar.h(l2);
        AppMethodBeat.o(254307);
    }

    @Override // com.tencent.mm.plugin.finder.video.x
    public final void a(com.tencent.mm.plugin.finder.loader.s sVar, com.tencent.mm.i.h hVar, com.tencent.mm.i.d dVar) {
        AppMethodBeat.i(254308);
        kotlin.g.b.p.h(sVar, "video");
        StringBuilder sb = new StringBuilder("[onStopDownload] videoView=");
        r rVar = this.wfl;
        Log.i("Finder.VideoLayout", sb.append(rVar != null ? Integer.valueOf(rVar.hashCode()) : null).append(" FinderVideo=").append(sVar).append(" thumbVisible=").append(getThumbView().getVisibility()).toString());
        b bVar = this.wfp;
        if (bVar != null) {
            c.b videoPlayBehavior = getVideoPlayBehavior();
            if (videoPlayBehavior != null) {
                videoPlayBehavior.a(bVar.feed.getExpectId(), bVar.uPf.uIw, hVar, dVar, bVar.uPf);
                AppMethodBeat.o(254308);
                return;
            }
            AppMethodBeat.o(254308);
            return;
        }
        AppMethodBeat.o(254308);
    }

    @Override // com.tencent.mm.plugin.finder.video.x
    public final void a(int i2, com.tencent.mm.plugin.finder.loader.s sVar, com.tencent.mm.i.d dVar) {
        c.b videoPlayBehavior;
        AppMethodBeat.i(254309);
        kotlin.g.b.p.h(sVar, "video");
        StringBuilder append = new StringBuilder("[onFinishDownload] ret=").append(i2).append(" videoView=");
        r rVar = this.wfl;
        Log.i("Finder.VideoLayout", append.append(rVar != null ? Integer.valueOf(rVar.hashCode()) : null).append(" FinderVideo=").append(sVar).toString());
        cJE();
        b bVar = this.wfp;
        if (bVar != null) {
            if (!bVar.wfz) {
                bVar = null;
            }
            if (!(bVar == null || (videoPlayBehavior = getVideoPlayBehavior()) == null)) {
                videoPlayBehavior.a(bVar.feed.getExpectId(), bVar.uPf.uIw, i2, dVar, bVar.uPf);
            }
        }
        if (i2 < 0) {
            dFD();
        }
        AppMethodBeat.o(254309);
    }

    @Override // com.tencent.mm.plugin.finder.video.x
    public final void a(int i2, int i3, com.tencent.mm.plugin.finder.loader.s sVar, boolean z) {
        Long l2;
        FeedData feedData;
        b bVar;
        AppMethodBeat.i(254310);
        kotlin.g.b.p.h(sVar, "video");
        StringBuilder sb = new StringBuilder("[onMoovReadyDownload] videoView=");
        r rVar = this.wfl;
        Log.i("Finder.VideoLayout", sb.append(rVar != null ? Integer.valueOf(rVar.hashCode()) : null).append("  offset=").append(i2).append(" total=").append(i3).append(" video=").append(sVar).append(" moovFirstDownloaded=").append(z).toString());
        b bVar2 = this.wfp;
        if (bVar2 != null) {
            if (bVar2.wfz) {
                bVar = bVar2;
            } else {
                bVar = null;
            }
            if (bVar != null) {
                af afVar = af.viA;
                String str = bVar.uPf.uIw.mediaId;
                if (str == null) {
                    str = "";
                }
                af.bp(str, z);
                c.b videoPlayBehavior = getVideoPlayBehavior();
                if (videoPlayBehavior != null) {
                    videoPlayBehavior.b(bVar.feed.getExpectId(), bVar.uPf.uIw, i2, i3, bVar.uPf);
                }
            }
        }
        com.tencent.mm.plugin.finder.report.h hVar = com.tencent.mm.plugin.finder.report.h.veu;
        com.tencent.mm.plugin.finder.report.h.Kj(this.dLS);
        com.tencent.mm.plugin.finder.report.f fVar = com.tencent.mm.plugin.finder.report.f.veb;
        b bVar3 = this.wfp;
        if (bVar3 == null || (feedData = bVar3.feed) == null) {
            l2 = null;
        } else {
            l2 = Long.valueOf(feedData.getId());
        }
        if (l2 != null) {
            l2.longValue();
            f.a EZ = com.tencent.mm.plugin.finder.report.f.EZ(l2.longValue());
            if (!(EZ.vee > 0 && EZ.vef == 0)) {
                EZ = null;
            }
            if (EZ != null) {
                EZ.vef = cl.aWA();
                AppMethodBeat.o(254310);
                return;
            }
            AppMethodBeat.o(254310);
            return;
        }
        AppMethodBeat.o(254310);
    }

    @Override // com.tencent.mm.plugin.finder.video.x
    public final void a(int i2, int i3, com.tencent.mm.plugin.finder.loader.s sVar) {
        c.b videoPlayBehavior;
        AppMethodBeat.i(254311);
        kotlin.g.b.p.h(sVar, "video");
        StringBuilder sb = new StringBuilder("[onProgressDownload] videoView=");
        r rVar = this.wfl;
        Log.i("Finder.VideoLayout", sb.append(rVar != null ? Integer.valueOf(rVar.hashCode()) : null).append(" offset=").append(i2).append(" total=").append(i3).append(" video=").append(sVar.auA()).toString());
        b bVar = this.wfp;
        if (bVar != null) {
            if (!bVar.wfz) {
                bVar = null;
            }
            if (!(bVar == null || (videoPlayBehavior = getVideoPlayBehavior()) == null)) {
                videoPlayBehavior.c(bVar.feed.getExpectId(), bVar.uPf.uIw, i2, i3, bVar.uPf);
            }
        }
        MediaPreloadCore.a aVar = MediaPreloadCore.uTV;
        if (MediaPreloadCore.uTU) {
            pw pwVar = new pw();
            pwVar.dVW.mediaId = sVar.uIw.mediaId;
            pwVar.dVW.process = (int) ((100.0f * ((float) i2)) / ((float) i3));
            com.tencent.mm.plugin.finder.storage.logic.d dVar = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
            String str = sVar.uIw.mediaId;
            if (str == null) {
                str = "";
            }
            pwVar.dVW.dVY = com.tencent.mm.plugin.finder.storage.logic.d.bv(str, true).field_fileFormat;
            EventCenter.instance.publish(pwVar);
        }
        AppMethodBeat.o(254311);
    }

    private final void dFC() {
        AppMethodBeat.i(168119);
        this.wfv = false;
        kotlin.g.a.m<? super Boolean, ? super b, x> mVar = this.wft;
        if (mVar != null) {
            mVar.invoke(Boolean.TRUE, this.wfp);
        }
        r rVar = this.wfl;
        if ((rVar != null ? rVar.getAlpha() : 0.0f) == 0.0f) {
            AppMethodBeat.o(168119);
            return;
        }
        r rVar2 = this.wfl;
        if (rVar2 != null) {
            rVar2.setAlpha(0.0f);
        }
        Log.i("Finder.VideoLayout", "[showThumb] " + dFF());
        AppMethodBeat.o(168119);
    }

    private final void awJ(String str) {
        AppMethodBeat.i(254312);
        kotlin.g.a.m<? super Boolean, ? super b, x> mVar = this.wft;
        if (mVar != null) {
            mVar.invoke(Boolean.FALSE, this.wfp);
        }
        r rVar = this.wfl;
        if (rVar != null && rVar.getAlpha() == 1.0f) {
            AppMethodBeat.o(254312);
        } else if (this.wfv) {
            AppMethodBeat.o(254312);
        } else {
            Log.i("Finder.VideoLayout", "[dismissThumb] " + dFF() + " source=" + str + " isShowThumbAnimating=" + this.wfv);
            r rVar2 = this.wfl;
            if (rVar2 != null) {
                rVar2.getVideoView().post(new f(rVar2, this));
                AppMethodBeat.o(254312);
                return;
            }
            AppMethodBeat.o(254312);
        }
    }

    public static final class f implements Runnable {
        final /* synthetic */ FinderVideoLayout wfB;
        final /* synthetic */ r wfD;

        f(r rVar, FinderVideoLayout finderVideoLayout) {
            this.wfD = rVar;
            this.wfB = finderVideoLayout;
        }

        public final void run() {
            AppMethodBeat.i(168058);
            this.wfD.animate().cancel();
            this.wfD.animate().alpha(1.0f).setDuration(200).setListener(new Animator.AnimatorListener(this) {
                /* class com.tencent.mm.plugin.finder.video.FinderVideoLayout.f.AnonymousClass1 */
                final /* synthetic */ f wfE;

                {
                    this.wfE = r1;
                }

                public final void onAnimationRepeat(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(254279);
                    this.wfE.wfD.setAlpha(1.0f);
                    this.wfE.wfB.wfv = false;
                    AppMethodBeat.o(254279);
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(254280);
                    this.wfE.wfB.wfv = true;
                    AppMethodBeat.o(254280);
                }
            }).start();
            AppMethodBeat.o(168058);
        }
    }

    private final void dFD() {
        AppMethodBeat.i(168121);
        getRetryBtn().animate().cancel();
        getRetryBtn().setVisibility(0);
        q qVar = this.wfq;
        if (qVar != null) {
            qVar.setVisibility(8);
        }
        cJE();
        AppMethodBeat.o(168121);
    }

    private final void dFE() {
        AppMethodBeat.i(168122);
        getRetryBtn().animate().cancel();
        q qVar = this.wfq;
        if (qVar != null) {
            qVar.setVisibility(0);
        }
        getRetryBtn().setVisibility(8);
        AppMethodBeat.o(168122);
    }

    private final void cJE() {
        kotlin.g.a.b<Boolean, x> onCustomLoadingStatusChange;
        AppMethodBeat.i(168123);
        FinderLongVideoPlayerSeekBar finderLongVideoPlayerSeekBar = this.wfr;
        if (finderLongVideoPlayerSeekBar == null || (onCustomLoadingStatusChange = finderLongVideoPlayerSeekBar.getOnCustomLoadingStatusChange()) == null) {
            getLoading().animate().cancel();
            if (getLoading().getVisibility() != 8) {
                getLoading().setVisibility(8);
            }
            AppMethodBeat.o(168123);
            return;
        }
        onCustomLoadingStatusChange.invoke(Boolean.FALSE);
        AppMethodBeat.o(168123);
    }

    private final void showLoading() {
        kotlin.g.a.b<Boolean, x> onCustomLoadingStatusChange;
        AppMethodBeat.i(168124);
        StringBuilder sb = new StringBuilder("showLoading ");
        r rVar = this.wfl;
        Log.i("Finder.VideoLayout", sb.append(rVar != null ? rVar.getVideoMediaId() : null).toString());
        if (this.wfd) {
            r rVar2 = this.wfl;
            if (rVar2 == null) {
                AppMethodBeat.o(168124);
                return;
            } else if (rVar2.getVideoViewFocused()) {
                FinderLongVideoPlayerSeekBar finderLongVideoPlayerSeekBar = this.wfr;
                if (finderLongVideoPlayerSeekBar == null || (onCustomLoadingStatusChange = finderLongVideoPlayerSeekBar.getOnCustomLoadingStatusChange()) == null) {
                    getLoading().setVisibility(0);
                    getLoading().setAlpha(0.0f);
                    getLoading().animate().alpha(1.0f).setDuration(1000).setListener(new q(this)).start();
                } else {
                    onCustomLoadingStatusChange.invoke(Boolean.TRUE);
                    AppMethodBeat.o(168124);
                    return;
                }
            }
        }
        AppMethodBeat.o(168124);
    }

    public static final class q implements Animator.AnimatorListener {
        final /* synthetic */ FinderVideoLayout wfB;

        q(FinderVideoLayout finderVideoLayout) {
            this.wfB = finderVideoLayout;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(254297);
            FinderVideoLayout.l(this.wfB).setAlpha(1.0f);
            FinderVideoLayout.l(this.wfB).setVisibility(0);
            AppMethodBeat.o(254297);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    private final void oP(boolean z) {
        WxRecyclerView dcy;
        WxRecyclerView dcy2;
        AppMethodBeat.i(254313);
        kotlin.g.a.m<? super Boolean, ? super b, x> mVar = this.wfs;
        if (mVar != null) {
            mVar.invoke(Boolean.valueOf(z), this.wfp);
        }
        if (z) {
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            getBulletSubtitleButton().setSelected(aAh.azQ().getBoolean(ar.a.USERINFO_FINDER_FEED_BULLET_SUBTITLE_SWITCH_BOOLEAN, true));
            com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(ad.class);
            kotlin.g.b.p.g(af, "MMKernel.service(IFinder…enModeConfig::class.java)");
            if (((ad) af).dxX()) {
                View findViewById = findViewById(R.id.j3x);
                kotlin.g.b.p.g(findViewById, "findViewById<View>(R.id.video_bullet_divider)");
                findViewById.setVisibility(8);
                View findViewById2 = findViewById(R.id.j3y);
                kotlin.g.b.p.g(findViewById2, "findViewById<TextView>(R…o_bullet_subtitle_button)");
                ((TextView) findViewById2).setVisibility(8);
            }
            if (this.tOs != null) {
                getBottomButtonLayout().setVisibility(0);
                com.tencent.mm.plugin.finder.feed.e eVar = this.tOr;
                if (!(eVar == null || (dcy2 = eVar.dcy()) == null)) {
                    dcy2.setAlpha(0.3f);
                }
            }
            this.wfc = true;
            AppMethodBeat.o(254313);
            return;
        }
        if (this.tOs != null) {
            getBottomButtonLayout().setVisibility(8);
            com.tencent.mm.plugin.finder.feed.e eVar2 = this.tOr;
            if (!(eVar2 == null || (dcy = eVar2.dcy()) == null)) {
                dcy.setAlpha(1.0f);
            }
        }
        this.wfc = false;
        AppMethodBeat.o(254313);
    }

    private final c.b getVideoPlayBehavior() {
        AppMethodBeat.i(168129);
        k kVar = this.tCD;
        if (kVar == null) {
            kotlin.g.b.p.btv("videoCore");
        }
        com.tencent.mm.plugin.finder.event.c cVar = kVar.weT;
        if (cVar != null) {
            c.C1109c cVar2 = new c.C1109c(cVar);
            AppMethodBeat.o(168129);
            return cVar2;
        }
        AppMethodBeat.o(168129);
        return null;
    }

    private final String dFF() {
        Float f2 = null;
        AppMethodBeat.i(168130);
        StringBuilder sb = new StringBuilder("mediaId:");
        r rVar = this.wfl;
        StringBuilder append = sb.append(rVar != null ? rVar.getVideoMediaId() : null).append(' ').append(hashCode()).append(':');
        r rVar2 = this.wfl;
        StringBuilder append2 = append.append(rVar2 != null ? rVar2.hashCode() : 0).append(" alpha=");
        r rVar3 = this.wfl;
        if (rVar3 != null) {
            f2 = Float.valueOf(rVar3.getAlpha());
        }
        String sb2 = append2.append(f2).toString();
        AppMethodBeat.o(168130);
        return sb2;
    }

    @Override // com.tencent.mm.plugin.finder.video.q.a
    public final void Q(boolean z, boolean z2) {
        String str;
        String str2;
        boolean z3;
        boolean z4;
        c.b videoPlayBehavior;
        Float f2 = null;
        AppMethodBeat.i(254314);
        StringBuilder sb = new StringBuilder("onEnterSeekMode mediaId=");
        b bVar = this.wfp;
        if (bVar != null) {
            str = bVar.mediaId;
        } else {
            str = null;
        }
        Log.i("Finder.VideoLayout", sb.append(str).toString());
        b bVar2 = this.wfp;
        if (bVar2 != null) {
            bVar2.wbG = z;
        }
        if (z) {
            b bVar3 = this.wfp;
            if (!(bVar3 == null || (videoPlayBehavior = getVideoPlayBehavior()) == null)) {
                videoPlayBehavior.a(bVar3.feed.getExpectId(), bVar3.uPf.uIw, bVar3.uPf);
            }
            oP(z2);
            r rVar = this.wfl;
            if (rVar != null) {
                rVar.setVideoViewFocused(false);
            }
            r rVar2 = this.wfl;
            if (rVar2 != null) {
                rVar2.pause();
            }
        } else {
            oP(false);
            r rVar3 = this.wfl;
            if (rVar3 != null) {
                rVar3.setVideoViewFocused(true);
                b bVar4 = this.wfp;
                if (bVar4 == null || (str2 = bVar4.mediaId) == null) {
                    str2 = "";
                }
                if (this.wfe.dR(str2, this.dLS) != null) {
                    play(0);
                    if (com.tencent.mm.q.a.aty()) {
                        z3 = true;
                    } else {
                        z3 = this.guh;
                    }
                    if (z3) {
                        z4 = true;
                    } else {
                        if (this.tCD == null) {
                            kotlin.g.b.p.btv("videoCore");
                        }
                        z4 = false;
                    }
                    rVar3.setMute(z4);
                } else {
                    rVar3.play();
                }
            }
        }
        if (!z) {
            this.wfe.clear();
        }
        StringBuilder append = new StringBuilder("[onEnterSeekMode] isEnter=").append(z).append(" alpha=");
        r rVar4 = this.wfl;
        if (rVar4 != null) {
            f2 = Float.valueOf(rVar4.getAlpha());
        }
        StringBuilder append2 = append.append(f2).append(" mediaId=");
        b bVar5 = this.wfp;
        if (bVar5 == null) {
            kotlin.g.b.p.hyc();
        }
        Log.i("Finder.VideoLayout", append2.append(bVar5.mediaId).toString());
        AppMethodBeat.o(254314);
    }

    public final boolean dFG() {
        AppMethodBeat.i(254315);
        r rVar = this.wfl;
        if (rVar != null) {
            boolean isPlaying = rVar.isPlaying();
            AppMethodBeat.o(254315);
            return isPlaying;
        }
        AppMethodBeat.o(254315);
        return false;
    }

    @Override // com.tencent.mm.plugin.finder.video.q.a
    public final void dFH() {
        AppMethodBeat.i(254316);
        r rVar = this.wfl;
        if (rVar != null) {
            rVar.pause();
        }
        b bVar = this.wfp;
        if (bVar != null) {
            if (!bVar.wbG) {
                oP(true);
            }
            AppMethodBeat.o(254316);
            return;
        }
        AppMethodBeat.o(254316);
    }

    @Override // com.tencent.mm.plugin.finder.video.q.a
    public final void bn(float f2) {
        int i2;
        c.b videoPlayBehavior;
        Integer num;
        boolean z = true;
        AppMethodBeat.i(254317);
        StringBuilder append = new StringBuilder("[seekTo] percent=").append(f2).append(" isSeekMode=").append(dFB()).append(" videoView=");
        r rVar = this.wfl;
        StringBuilder append2 = append.append(rVar != null ? Integer.valueOf(rVar.hashCode()) : null).append(" videoDurationSec=");
        r rVar2 = this.wfl;
        Log.i("Finder.VideoLayout", append2.append(rVar2 != null ? Integer.valueOf(rVar2.getVideoDuration()) : null).toString());
        r rVar3 = this.wfl;
        if (rVar3 != null) {
            int currentPlaySecond = rVar3.getCurrentPlaySecond();
            r rVar4 = this.wfl;
            if (rVar4 != null) {
                i2 = rVar4.getVideoDuration();
            } else {
                i2 = 1;
            }
            float p2 = android.support.v4.b.a.p(((float) i2) * f2, 0.0f, ((float) i2) - 1.0f);
            double d2 = (double) p2;
            if (dFB()) {
                z = false;
            }
            if (rVar3.c(d2, z) && Math.abs(((float) currentPlaySecond) - p2) > 1.0f) {
                this.wfw = p2;
                StringBuilder append3 = new StringBuilder("[seekTo] successfully seek to ").append(p2).append(" videoDurationSec=");
                r rVar5 = this.wfl;
                if (rVar5 != null) {
                    num = Integer.valueOf(rVar5.getVideoDuration());
                } else {
                    num = null;
                }
                Log.i("Finder.VideoLayout", append3.append(num).toString());
            }
            b bVar = this.wfp;
            if (bVar != null) {
                if (!bVar.wfz) {
                    bVar = null;
                }
                if (!(bVar == null || (videoPlayBehavior = getVideoPlayBehavior()) == null)) {
                    videoPlayBehavior.d(bVar.feed.getExpectId(), bVar.uPf.uIw, currentPlaySecond, (int) p2, bVar.uPf);
                }
            }
        }
        b bVar2 = this.wfp;
        if (bVar2 != null) {
            if (!bVar2.wbG) {
                oP(false);
            }
            AppMethodBeat.o(254317);
            return;
        }
        AppMethodBeat.o(254317);
    }

    @Override // com.tencent.mm.plugin.finder.video.q.a
    public final boolean dFI() {
        b bVar = this.wfp;
        return bVar != null && bVar.wfz;
    }

    @Override // com.tencent.mm.plugin.finder.video.q.a
    public final boolean W(MotionEvent motionEvent) {
        AppMethodBeat.i(254318);
        kotlin.g.b.p.h(motionEvent, "event");
        if (getBulletSubtitleButton().getVisibility() != 0) {
            AppMethodBeat.o(254318);
            return false;
        }
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        ViewParent parent = getBulletSubtitleButton().getParent();
        if (parent == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(254318);
            throw tVar;
        }
        ((View) parent).getHitRect(rect2);
        getBulletSubtitleButton().getHitRect(rect);
        rect.top += rect2.top;
        rect.bottom += rect2.top;
        rect.left += rect2.left;
        rect.right += rect2.left;
        Rect rect3 = new Rect();
        getFullscreenIcon().getHitRect(rect3);
        if (rect3.contains((int) motionEvent.getX(), (int) motionEvent.getY()) || rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            AppMethodBeat.o(254318);
            return true;
        }
        AppMethodBeat.o(254318);
        return false;
    }

    @Override // com.tencent.mm.plugin.finder.video.q.a
    public final int getVideoDurationSec() {
        AppMethodBeat.i(254319);
        r rVar = this.wfl;
        if (rVar != null) {
            int videoDuration = rVar.getVideoDuration();
            AppMethodBeat.o(254319);
            return videoDuration;
        }
        AppMethodBeat.o(254319);
        return 0;
    }

    @Override // com.tencent.mm.plugin.finder.video.q.a
    public final int getCurrentPosSec() {
        AppMethodBeat.i(254320);
        r rVar = this.wfl;
        if (rVar != null) {
            int currentPlaySecond = rVar.getCurrentPlaySecond();
            AppMethodBeat.o(254320);
            return currentPlaySecond;
        }
        AppMethodBeat.o(254320);
        return 0;
    }

    public final long getCurrentPosMs() {
        AppMethodBeat.i(254321);
        r rVar = this.wfl;
        if (rVar != null) {
            long currentPlayMs = rVar.getCurrentPlayMs();
            AppMethodBeat.o(254321);
            return currentPlayMs;
        }
        AppMethodBeat.o(254321);
        return 0;
    }

    private final void cBY() {
        AppMethodBeat.i(254322);
        q qVar = this.wfq;
        if (qVar != null) {
            post(new s(qVar, this));
        }
        FinderLongVideoPlayerSeekBar finderLongVideoPlayerSeekBar = this.wfr;
        if (finderLongVideoPlayerSeekBar != null) {
            finderLongVideoPlayerSeekBar.post(new t(finderLongVideoPlayerSeekBar, this));
            AppMethodBeat.o(254322);
            return;
        }
        AppMethodBeat.o(254322);
    }

    public static final class s implements Runnable {
        final /* synthetic */ FinderVideoLayout wfB;
        final /* synthetic */ q wfL;

        s(q qVar, FinderVideoLayout finderVideoLayout) {
            this.wfL = qVar;
            this.wfB = finderVideoLayout;
        }

        public final void run() {
            long j2;
            AppMethodBeat.i(254298);
            r videoView = this.wfB.getVideoView();
            long currentPlayMs = videoView != null ? videoView.getCurrentPlayMs() : 0;
            r videoView2 = this.wfB.getVideoView();
            if (videoView2 != null) {
                j2 = videoView2.getVideoDurationMs();
            } else {
                j2 = 0;
            }
            int i2 = ((int) currentPlayMs) / 1000;
            int i3 = ((int) j2) / 1000;
            if (!this.wfL.dEZ() && j2 > 0 && this.wfB.wfw == -1.0f) {
                this.wfL.bm((((float) currentPlayMs) * 1.0f) / ((float) j2));
                if (this.wfB.wfx != i2) {
                    this.wfL.gs(i2, i3);
                    this.wfB.wfx = i2;
                }
            }
            AppMethodBeat.o(254298);
        }
    }

    public static final class t implements Runnable {
        final /* synthetic */ FinderVideoLayout wfB;
        final /* synthetic */ FinderLongVideoPlayerSeekBar wfG;

        t(FinderLongVideoPlayerSeekBar finderLongVideoPlayerSeekBar, FinderVideoLayout finderVideoLayout) {
            this.wfG = finderLongVideoPlayerSeekBar;
            this.wfB = finderVideoLayout;
        }

        public final void run() {
            long j2;
            int i2 = 0;
            AppMethodBeat.i(254299);
            this.wfG.setIsPlay(true);
            r videoView = this.wfB.getVideoView();
            int currentPlaySecond = videoView != null ? videoView.getCurrentPlaySecond() : 0;
            r videoView2 = this.wfB.getVideoView();
            if (videoView2 != null) {
                i2 = videoView2.getVideoDuration();
            }
            this.wfG.setVideoTotalTime(i2);
            this.wfG.xv(currentPlaySecond);
            FinderLongVideoPlayerSeekBar finderLongVideoPlayerSeekBar = this.wfG;
            r videoView3 = this.wfB.getVideoView();
            if (videoView3 != null) {
                j2 = videoView3.getCurrentPlayMs();
            } else {
                j2 = 0;
            }
            FinderLongVideoPlayerSeekBar.b bVar = finderLongVideoPlayerSeekBar.uKd;
            if (bVar != null) {
                bVar.onProgress(j2);
                AppMethodBeat.o(254299);
                return;
            }
            AppMethodBeat.o(254299);
        }
    }

    static final class k extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ FinderVideoLayout wfB;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(FinderVideoLayout finderVideoLayout) {
            super(0);
            this.wfB = finderVideoLayout;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(168066);
            View findViewById = this.wfB.findViewById(R.id.epx);
            AppMethodBeat.o(168066);
            return findViewById;
        }
    }

    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<LinearLayout> {
        final /* synthetic */ FinderVideoLayout wfB;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderVideoLayout finderVideoLayout) {
            super(0);
            this.wfB = finderVideoLayout;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ LinearLayout invoke() {
            AppMethodBeat.i(254275);
            LinearLayout linearLayout = (LinearLayout) this.wfB.findViewById(R.id.j3v);
            TextView textView = (TextView) this.wfB.findViewById(R.id.j5l);
            kotlin.g.b.p.g(textView, "textView");
            ao.a(textView.getPaint(), 0.8f);
            AppMethodBeat.o(254275);
            return linearLayout;
        }
    }

    public final Bitmap getBitmap() {
        Bitmap bitmap;
        AppMethodBeat.i(254323);
        r rVar = this.wfl;
        if (rVar == null || (bitmap = rVar.getBitmap()) == null) {
            Drawable drawable = getThumbView().getDrawable();
            if (drawable == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
                AppMethodBeat.o(254323);
                throw tVar;
            }
            bitmap = ((BitmapDrawable) drawable).getBitmap();
        }
        AppMethodBeat.o(254323);
        return bitmap;
    }

    public static final class h implements View.OnClickListener {
        final /* synthetic */ FinderVideoLayout wfB;
        final /* synthetic */ FinderLongVideoPlayerSeekBar wfG;

        h(FinderLongVideoPlayerSeekBar finderLongVideoPlayerSeekBar, FinderVideoLayout finderVideoLayout) {
            this.wfG = finderLongVideoPlayerSeekBar;
            this.wfB = finderVideoLayout;
        }

        public final void onClick(View view) {
            b playInfo;
            c.b o;
            boolean z = true;
            AppMethodBeat.i(254283);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderVideoLayout$initLongVideoSeekBar$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            boolean cEF = this.wfG.cEF();
            this.wfB.oQ(!cEF);
            FinderLongVideoPlayerSeekBar finderLongVideoPlayerSeekBar = this.wfG;
            if (cEF) {
                z = false;
            }
            finderLongVideoPlayerSeekBar.setIsPlay(z);
            if (!(!cEF || (playInfo = this.wfB.getPlayInfo()) == null || (o = FinderVideoLayout.o(this.wfB)) == null)) {
                o.a(playInfo.feed.getExpectId(), playInfo.uPf.uIw, playInfo.uPf);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/FinderVideoLayout$initLongVideoSeekBar$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(254283);
        }
    }

    static final class l extends kotlin.g.b.q implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ FinderVideoLayout wfB;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(FinderVideoLayout finderVideoLayout) {
            super(0);
            this.wfB = finderVideoLayout;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ ImageView invoke() {
            AppMethodBeat.i(168067);
            ImageView imageView = (ImageView) this.wfB.findViewById(R.id.j5j);
            AppMethodBeat.o(168067);
            return imageView;
        }
    }

    public static final class i implements com.tencent.mm.plugin.sight.decode.ui.b {
        final /* synthetic */ FinderVideoLayout wfB;
        final /* synthetic */ FinderLongVideoPlayerSeekBar wfG;

        i(FinderLongVideoPlayerSeekBar finderLongVideoPlayerSeekBar, FinderVideoLayout finderVideoLayout) {
            this.wfG = finderLongVideoPlayerSeekBar;
            this.wfB = finderVideoLayout;
        }

        @Override // com.tencent.mm.plugin.sight.decode.ui.b
        public final void rk(int i2) {
            int i3;
            AppMethodBeat.i(254284);
            FinderLongVideoPlayerSeekBar.b bVar = this.wfG.uKd;
            if (bVar != null) {
                bVar.rk(i2);
            }
            r videoView = this.wfB.getVideoView();
            if (videoView != null) {
                videoView.c((double) i2, true);
            }
            FinderVideoLayout.a(this.wfB);
            this.wfG.setIsPlay(true);
            kotlin.g.a.a<x> onSeekEnd = this.wfG.getOnSeekEnd();
            if (onSeekEnd != null) {
                onSeekEnd.invoke();
            }
            b playInfo = this.wfB.getPlayInfo();
            if (playInfo != null) {
                if (!playInfo.wfz) {
                    playInfo = null;
                }
                if (playInfo != null) {
                    c.b o = FinderVideoLayout.o(this.wfB);
                    if (o != null) {
                        long expectId = playInfo.feed.getExpectId();
                        cjl cjl = playInfo.uPf.uIw;
                        r videoView2 = this.wfB.getVideoView();
                        if (videoView2 != null) {
                            i3 = videoView2.getCurrentPlaySecond();
                        } else {
                            i3 = 0;
                        }
                        o.d(expectId, cjl, i3, i2, playInfo.uPf);
                        AppMethodBeat.o(254284);
                        return;
                    }
                    AppMethodBeat.o(254284);
                    return;
                }
            }
            AppMethodBeat.o(254284);
        }

        @Override // com.tencent.mm.plugin.sight.decode.ui.b
        public final void aJq() {
            AppMethodBeat.i(254285);
            this.wfB.oQ(false);
            this.wfG.setIsPlay(false);
            kotlin.g.a.a<x> onSeekStart = this.wfG.getOnSeekStart();
            if (onSeekStart != null) {
                onSeekStart.invoke();
                AppMethodBeat.o(254285);
                return;
            }
            AppMethodBeat.o(254285);
        }
    }

    static final class r extends kotlin.g.b.q implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ FinderVideoLayout wfB;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(FinderVideoLayout finderVideoLayout) {
            super(0);
            this.wfB = finderVideoLayout;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ ImageView invoke() {
            AppMethodBeat.i(168081);
            ImageView imageView = (ImageView) this.wfB.findViewById(R.id.imd);
            AppMethodBeat.o(168081);
            return imageView;
        }
    }

    public final void setStartPlayTime(long j2) {
        AppMethodBeat.i(254324);
        com.tencent.mm.ac.d.h(new p(this, j2));
        AppMethodBeat.o(254324);
    }

    static final class u extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ FinderVideoLayout wfB;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        u(FinderVideoLayout finderVideoLayout) {
            super(0);
            this.wfB = finderVideoLayout;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(168082);
            View findViewById = this.wfB.findViewById(R.id.j51);
            findViewById.setVisibility(8);
            AppMethodBeat.o(168082);
            return findViewById;
        }
    }

    public final void oQ(boolean z) {
        AppMethodBeat.i(254325);
        if (z) {
            play(0);
            AppMethodBeat.o(254325);
            return;
        }
        pause(false);
        AppMethodBeat.o(254325);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x009e, code lost:
        if (r0 == null) goto L_0x00a0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String dFJ() {
        /*
        // Method dump skipped, instructions count: 167
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.video.FinderVideoLayout.dFJ():java.lang.String");
    }

    public static final class p extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderVideoLayout wfB;
        final /* synthetic */ long wfK;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(FinderVideoLayout finderVideoLayout, long j2) {
            super(0);
            this.wfB = finderVideoLayout;
            this.wfK = j2;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(254296);
            r videoView = this.wfB.getVideoView();
            if (videoView == null || !videoView.c(((double) this.wfK) / 1000.0d, true)) {
                this.wfB.iJF = this.wfK;
            }
            x xVar = x.SXb;
            AppMethodBeat.o(254296);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(FinderVideoLayout finderVideoLayout, r rVar, com.tencent.mm.plugin.finder.loader.s sVar, boolean z, FeedData feedData) {
        float f2;
        int i2;
        AppMethodBeat.i(254328);
        if (rVar instanceof FinderThumbPlayerProxy) {
            FinderThumbPlayerProxy finderThumbPlayerProxy = (FinderThumbPlayerProxy) rVar;
            k kVar = finderVideoLayout.tCD;
            if (kVar == null) {
                kotlin.g.b.p.btv("videoCore");
            }
            finderThumbPlayerProxy.setMediaPreloadCore$plugin_finder_release(kVar.weU);
            ((FinderThumbPlayerProxy) rVar).setDownloadCallback(finderVideoLayout);
            finderVideoLayout.isLongVideo = finderVideoLayout.isLongVideo;
            ((FinderThumbPlayerProxy) rVar).setFullScreen(finderVideoLayout.wfg);
        }
        if (finderVideoLayout.wfg && (rVar instanceof FinderCropVideoView)) {
            ((FinderCropVideoView) rVar).setVideoRootWidth(finderVideoLayout.getWidth());
            ((FinderCropVideoView) rVar).setVideoRootHeight(finderVideoLayout.getHeight());
        }
        rVar.a(sVar, z, feedData);
        rVar.setIMMVideoViewCallback(finderVideoLayout);
        if (rVar instanceof FinderVLogCompositionPlayView) {
            ((FinderVLogCompositionPlayView) rVar).setShowFullscreen(finderVideoLayout.wfg);
        }
        if (rVar instanceof FinderLivePlayView) {
            ((FinderLivePlayView) rVar).setSupportPauseResume(true);
        }
        if (finderVideoLayout.wfg && (rVar instanceof FinderLivePlayView)) {
            rVar.setScaleType(i.e.CONTAIN);
            ((FinderLivePlayView) rVar).setAutoJustRenderMode(true);
        } else if ((rVar instanceof FinderLivePlayView) || finderVideoLayout.wfg || !(rVar instanceof FinderThumbPlayerProxy)) {
            rVar.setScaleType(i.e.COVER);
        } else {
            rVar.setScaleType(i.e.CROP);
        }
        k kVar2 = finderVideoLayout.tCD;
        if (kVar2 == null) {
            kotlin.g.b.p.btv("videoCore");
        }
        rVar.setIOnlineVideoProxy(kVar2.weR.a(sVar, finderVideoLayout));
        if (!finderVideoLayout.wfg && sVar.uIw.MoO && sVar.uIw.uOR != null) {
            ViewGroup.LayoutParams layoutParams = finderVideoLayout.getLayoutParams();
            Resources resources = finderVideoLayout.getResources();
            kotlin.g.b.p.g(resources, "resources");
            layoutParams.width = resources.getDisplayMetrics().widthPixels;
            if (finderVideoLayout.isLongVideo) {
                cjx cjx = sVar.uIw.uOR;
                if (cjx != null) {
                    i2 = cjx.height;
                } else {
                    i2 = 0;
                }
                layoutParams.height = i2;
            } else {
                cjx cjx2 = sVar.uIw.uOR;
                if (cjx2 != null) {
                    f2 = ((float) cjx2.height) / ((float) cjx2.width);
                } else {
                    f2 = 1.1666666f;
                }
                if (((double) f2) > 1.1666666666666667d) {
                    layoutParams.height = (int) ((((float) layoutParams.width) * 3.5f) / 3.0f);
                } else {
                    layoutParams.height = (int) (f2 * ((float) layoutParams.width));
                }
            }
            finderVideoLayout.setLayoutParams(layoutParams);
        }
        rVar.dFl();
        rVar.setIsShowBasicControls(false);
        rVar.setLoop(true);
        k kVar3 = finderVideoLayout.tCD;
        if (kVar3 == null) {
            kotlin.g.b.p.btv("videoCore");
        }
        rVar.setFinderVideoCore(kVar3);
        rVar.setVideoPlayLifecycle(finderVideoLayout.wcw);
        rVar.setVideoMuteListener(finderVideoLayout);
        com.tencent.mm.plugin.finder.feed.e eVar = finderVideoLayout.tOr;
        if (eVar != null) {
            eVar.reset(false);
            AppMethodBeat.o(254328);
            return;
        }
        AppMethodBeat.o(254328);
    }
}
