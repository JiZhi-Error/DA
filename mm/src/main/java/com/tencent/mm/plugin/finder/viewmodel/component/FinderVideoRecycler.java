package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.oq;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.at;
import com.tencent.mm.plugin.finder.video.FinderCropVideoView;
import com.tencent.mm.plugin.finder.video.FinderLivePlayView;
import com.tencent.mm.plugin.finder.video.FinderThumbPlayerProxy;
import com.tencent.mm.plugin.finder.video.FinderVLogCompositionPlayView;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.s;
import com.tencent.mm.plugin.finder.video.u;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.component.UIComponentPlugin;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.g.b.z;
import kotlin.t;
import kotlin.x;

public final class FinderVideoRecycler extends UIComponentPlugin<PluginFinder> {
    public static final a wBf = new a((byte) 0);
    private final MMHandler hAk = new MMHandler(Looper.getMainLooper());
    private boolean isFinished;
    private boolean wAT = true;
    private int wAU = 1;
    private int wAV;
    final HashSet<com.tencent.mm.plugin.finder.video.r> wAW = new HashSet<>();
    private final ConcurrentLinkedQueue<WeakReference<? extends com.tencent.mm.plugin.finder.video.r>> wAX = new ConcurrentLinkedQueue<>();
    public final HashMap<Integer, String> wAY = new HashMap<>();
    private final HashMap<Integer, b> wAZ = new HashMap<>();
    private final HashSet<String> wBa = new HashSet<>();
    private int wBb;
    private int wBc;
    private final HashMap<Integer, Object> wBd = new HashMap<>();
    private final j wBe = new j(this);

    public interface b {
        boolean a(com.tencent.mm.plugin.finder.video.r rVar);
    }

    static {
        AppMethodBeat.i(256086);
        AppMethodBeat.o(256086);
    }

    public static final class d extends kotlin.g.b.q implements kotlin.g.a.b<com.tencent.mm.plugin.finder.video.r, Boolean> {
        final /* synthetic */ Class nnI;
        final /* synthetic */ FinderVideoRecycler wBg;
        final /* synthetic */ z.e wBi;
        final /* synthetic */ int[] wBj;
        final /* synthetic */ boolean wBk;
        final /* synthetic */ z.f wBl;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderVideoRecycler finderVideoRecycler, Class cls, z.e eVar, int[] iArr, boolean z, z.f fVar) {
            super(1);
            this.wBg = finderVideoRecycler;
            this.nnI = cls;
            this.wBi = eVar;
            this.wBj = iArr;
            this.wBk = z;
            this.wBl = fVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0130, code lost:
            if (r0 > r1.getDisplayMetrics().heightPixels) goto L_0x0132;
         */
        @Override // kotlin.g.a.b
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ java.lang.Boolean invoke(com.tencent.mm.plugin.finder.video.r r11) {
            /*
            // Method dump skipped, instructions count: 340
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler.d.invoke(java.lang.Object):java.lang.Object");
        }
    }

    public static final class f extends kotlin.g.b.q implements kotlin.g.a.b<com.tencent.mm.plugin.finder.video.r, Boolean> {
        final /* synthetic */ Context $context;
        final /* synthetic */ Class wBs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(Context context, Class cls) {
            super(1);
            this.$context = context;
            this.wBs = cls;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(com.tencent.mm.plugin.finder.video.r rVar) {
            boolean z;
            AppMethodBeat.i(256045);
            com.tencent.mm.plugin.finder.video.r rVar2 = rVar;
            kotlin.g.b.p.h(rVar2, LocaleUtil.ITALIAN);
            if (!this.wBs.isAssignableFrom(rVar2.getClass()) || !kotlin.g.b.p.j(rVar2.getVideoView().getContext(), this.$context)) {
                z = false;
            } else {
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(256045);
            return valueOf;
        }
    }

    public static final class g extends kotlin.g.b.q implements kotlin.g.a.b<com.tencent.mm.plugin.finder.video.r, x> {
        final /* synthetic */ ViewGroup hVi;
        final /* synthetic */ FinderVideoRecycler wBg;
        final /* synthetic */ kotlin.g.a.b wBt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(FinderVideoRecycler finderVideoRecycler, ViewGroup viewGroup, kotlin.g.a.b bVar) {
            super(1);
            this.wBg = finderVideoRecycler;
            this.hVi = viewGroup;
            this.wBt = bVar;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(com.tencent.mm.plugin.finder.video.r rVar) {
            AppMethodBeat.i(256046);
            com.tencent.mm.plugin.finder.video.r rVar2 = rVar;
            kotlin.g.b.p.h(rVar2, "videoView");
            rVar2.setTag(Integer.valueOf(this.hVi.hashCode()));
            this.hVi.addView(rVar2.getVideoView(), kotlin.k.j.mZ(0, this.hVi.indexOfChild(this.hVi.findViewById(R.id.imd)) + 1), new FrameLayout.LayoutParams(-1, -1));
            rVar2.setTag(R.id.d44, Long.valueOf(SystemClock.uptimeMillis()));
            this.wBg.wAY.put(Integer.valueOf(this.hVi.hashCode()), null);
            this.wBt.invoke(rVar2);
            x xVar = x.SXb;
            AppMethodBeat.o(256046);
            return xVar;
        }
    }

    public static final class h extends kotlin.g.b.q implements kotlin.g.a.b<com.tencent.mm.plugin.finder.video.r, Boolean> {
        final /* synthetic */ Class nnI;
        final /* synthetic */ z.d wBu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(Class cls, z.d dVar) {
            super(1);
            this.nnI = cls;
            this.wBu = dVar;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(com.tencent.mm.plugin.finder.video.r rVar) {
            AppMethodBeat.i(256047);
            com.tencent.mm.plugin.finder.video.r rVar2 = rVar;
            kotlin.g.b.p.h(rVar2, LocaleUtil.ITALIAN);
            if (this.nnI == null || this.nnI.isAssignableFrom(rVar2.getClass())) {
                this.wBu.SYE++;
            }
            Boolean bool = Boolean.FALSE;
            AppMethodBeat.o(256047);
            return bool;
        }
    }

    public static final class n extends kotlin.g.b.q implements kotlin.g.a.b<com.tencent.mm.plugin.finder.video.r, Boolean> {
        final /* synthetic */ com.tencent.mm.plugin.finder.video.r wBz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(com.tencent.mm.plugin.finder.video.r rVar) {
            super(1);
            this.wBz = rVar;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(com.tencent.mm.plugin.finder.video.r rVar) {
            AppMethodBeat.i(256058);
            com.tencent.mm.plugin.finder.video.r rVar2 = rVar;
            kotlin.g.b.p.h(rVar2, LocaleUtil.ITALIAN);
            Boolean valueOf = Boolean.valueOf(kotlin.g.b.p.j(rVar2, this.wBz));
            AppMethodBeat.o(256058);
            return valueOf;
        }
    }

    static final class p extends kotlin.g.b.q implements kotlin.g.a.b<com.tencent.mm.plugin.finder.video.r, Boolean> {
        final /* synthetic */ Context $context;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(com.tencent.mm.plugin.finder.video.r rVar) {
            AppMethodBeat.i(256063);
            com.tencent.mm.plugin.finder.video.r rVar2 = rVar;
            kotlin.g.b.p.h(rVar2, LocaleUtil.ITALIAN);
            Boolean valueOf = Boolean.valueOf(kotlin.g.b.p.j(rVar2.getVideoView().getContext(), this.$context));
            AppMethodBeat.o(256063);
            return valueOf;
        }
    }

    static final class q extends kotlin.g.b.q implements kotlin.g.a.b<com.tencent.mm.plugin.finder.video.r, Boolean> {
        final /* synthetic */ Context $context;
        final /* synthetic */ z.d wBC;
        final /* synthetic */ FinderVideoRecycler wBg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(FinderVideoRecycler finderVideoRecycler, Context context, z.d dVar) {
            super(1);
            this.wBg = finderVideoRecycler;
            this.$context = context;
            this.wBC = dVar;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(com.tencent.mm.plugin.finder.video.r rVar) {
            boolean z;
            AppMethodBeat.i(256064);
            com.tencent.mm.plugin.finder.video.r rVar2 = rVar;
            kotlin.g.b.p.h(rVar2, LocaleUtil.ITALIAN);
            if (kotlin.g.b.p.j(rVar2.getVideoView().getContext(), this.$context)) {
                this.wBC.SYE++;
                FinderVideoRecycler.a(this.wBg, rVar2, "removeByContext#" + this.$context.getClass().getSimpleName());
                z = true;
            } else {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(256064);
            return valueOf;
        }
    }

    public FinderVideoRecycler() {
        AppMethodBeat.i(256085);
        AppMethodBeat.o(256085);
    }

    public static final /* synthetic */ void a(FinderVideoRecycler finderVideoRecycler, com.tencent.mm.plugin.finder.video.r rVar, String str) {
        AppMethodBeat.i(256089);
        finderVideoRecycler.a(rVar, str);
        AppMethodBeat.o(256089);
    }

    public static final /* synthetic */ void a(FinderVideoRecycler finderVideoRecycler, kotlin.g.a.b bVar) {
        AppMethodBeat.i(256090);
        finderVideoRecycler.I(bVar);
        AppMethodBeat.o(256090);
    }

    public static final /* synthetic */ void c(FinderVideoRecycler finderVideoRecycler) {
        AppMethodBeat.i(256087);
        finderVideoRecycler.onFinish();
        AppMethodBeat.o(256087);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void a(AppCompatActivity appCompatActivity, boolean z) {
        AppMethodBeat.i(256067);
        kotlin.g.b.p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        String valueOf = String.valueOf(appCompatActivity.hashCode());
        if (this.wBc == 0) {
            MC();
        }
        if (this.wBa.add(valueOf)) {
            Log.i("Finder.VideoRecycler", "[register] activity=" + appCompatActivity.getClass().getSimpleName() + " isPreInflate=" + z);
            if (z) {
                fI(appCompatActivity);
            }
            this.wBc++;
            appCompatActivity.getLifecycle().addObserver(new FinderVideoRecycler$make$1(this, appCompatActivity, valueOf));
        }
        AppMethodBeat.o(256067);
    }

    public final void awV(String str) {
        String videoMediaId;
        AppMethodBeat.i(256068);
        kotlin.g.b.p.h(str, "mediaId");
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.dxe().value().intValue() != 1) {
            AppMethodBeat.o(256068);
            return;
        }
        Iterator<T> it = this.wAX.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.finder.video.r rVar = (com.tencent.mm.plugin.finder.video.r) it.next().get();
            if (!(rVar == null || (videoMediaId = rVar.getVideoMediaId()) == null)) {
                Log.i("Finder.VideoRecycler", "onPreloadComplete " + videoMediaId + ' ' + str);
                if (kotlin.g.b.p.j(videoMediaId, str)) {
                    rVar.dEN();
                }
            }
        }
        AppMethodBeat.o(256068);
    }

    private final void MC() {
        AppMethodBeat.i(256069);
        this.isFinished = false;
        this.wBe.alive();
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        kotlin.o<Integer, Boolean> drF = com.tencent.mm.plugin.finder.storage.c.drF();
        this.wAU = drF.first.intValue();
        this.wAT = drF.second.booleanValue();
        this.wAV = kotlin.k.j.na(this.wAU - 1, 4);
        Log.i("Finder.VideoRecycler", "[onInit] maxVideoCount=" + this.wAU + " preInflateCount=" + this.wAV + " waitForRelease=" + this.wAT);
        AppMethodBeat.o(256069);
    }

    private final void onFinish() {
        AppMethodBeat.i(256070);
        this.isFinished = true;
        this.wBe.dead();
        this.hAk.postAtFrontOfQueue(new i(this));
        this.wBa.clear();
        this.wAZ.clear();
        AppMethodBeat.o(256070);
    }

    public static final class i implements Runnable {
        final /* synthetic */ FinderVideoRecycler wBg;

        i(FinderVideoRecycler finderVideoRecycler) {
            this.wBg = finderVideoRecycler;
        }

        public final void run() {
            AppMethodBeat.i(256049);
            for (WeakReference weakReference : this.wBg.wAX) {
                com.tencent.mm.plugin.finder.video.r rVar = (com.tencent.mm.plugin.finder.video.r) weakReference.get();
                if (rVar != null) {
                    rVar.onUIDestroy();
                    rVar.onRelease();
                }
            }
            this.wBg.wAX.clear();
            this.wBg.wAW.clear();
            this.wBg.hAk.removeCallbacksAndMessages(null);
            AppMethodBeat.o(256049);
        }
    }

    private final void fI(Context context) {
        AppMethodBeat.i(256071);
        if (Build.VERSION.SDK_INT >= 23) {
            Looper mainLooper = Looper.getMainLooper();
            kotlin.g.b.p.g(mainLooper, "Looper.getMainLooper()");
            mainLooper.getQueue().addIdleHandler(new m(this, context));
        }
        AppMethodBeat.o(256071);
    }

    public static final class m implements MessageQueue.IdleHandler {
        final /* synthetic */ Context $context;
        final /* synthetic */ FinderVideoRecycler wBg;

        m(FinderVideoRecycler finderVideoRecycler, Context context) {
            this.wBg = finderVideoRecycler;
            this.$context = context;
        }

        public final boolean queueIdle() {
            AppMethodBeat.i(256057);
            if (this.wBg.wAV <= 0 || this.wBg.wBb >= this.wBg.wAV || this.wBg.isFinished) {
                Log.i("Finder.VideoRecycler", "[preInflateVideoView] completed! preInflateCount=" + this.wBg.wBb + " targetCount=" + this.wBg.wAV + " isFinished=" + this.wBg.isFinished);
                AppMethodBeat.o(256057);
                return false;
            }
            this.wBg.wAW.add(FinderVideoRecycler.a(this.wBg, this.$context));
            this.wBg.wBb++;
            AppMethodBeat.o(256057);
            return true;
        }
    }

    static /* synthetic */ com.tencent.mm.plugin.finder.video.r a(FinderVideoRecycler finderVideoRecycler, Context context) {
        AppMethodBeat.i(256073);
        com.tencent.mm.plugin.finder.video.r c2 = finderVideoRecycler.c(context, 0, false);
        AppMethodBeat.o(256073);
        return c2;
    }

    private final com.tencent.mm.plugin.finder.video.r c(Context context, int i2, boolean z) {
        FinderCropVideoView finderCropVideoView;
        AppMethodBeat.i(256072);
        long currentTimeMillis = System.currentTimeMillis();
        if (i2 == 1) {
            finderCropVideoView = new FinderVLogCompositionPlayView(context);
        } else if (i2 == 2) {
            finderCropVideoView = new FinderLivePlayView(context);
        } else {
            com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.thumbplayer.a.a.class);
            kotlin.g.b.p.g(ah, "MMKernel.plugin(IPluginThumbPlayer::class.java)");
            if (!((com.tencent.mm.plugin.thumbplayer.a.a) ah).isOpenTPPlayer() || z) {
                finderCropVideoView = new FinderCropVideoView(context);
            } else {
                finderCropVideoView = new FinderThumbPlayerProxy(context);
            }
        }
        this.wAX.add(new WeakReference<>(finderCropVideoView));
        Log.i("Finder.VideoRecycler", "[createVideoView] activity=" + context.getClass().getSimpleName() + " videoCount=" + a(this) + ' ' + "videoView=" + finderCropVideoView.getClass().getSimpleName() + " cost=" + (System.currentTimeMillis() - currentTimeMillis) + LocaleUtil.MALAY);
        AppMethodBeat.o(256072);
        return finderCropVideoView;
    }

    private final boolean ek(View view) {
        ViewParent parent;
        AppMethodBeat.i(256074);
        if (view == null || (parent = view.getParent()) == null) {
            AppMethodBeat.o(256074);
            return false;
        }
        this.wAY.put(Integer.valueOf(parent.hashCode()), null);
        if (parent == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(256074);
            throw tVar;
        }
        ((ViewGroup) parent).removeView(view);
        Log.i("Finder.VideoRecycler", "[removeViewFromParent] parent=" + parent.hashCode() + ", videoView=" + view.hashCode() + ", parentTag=" + ((ViewGroup) parent).getTag());
        AppMethodBeat.o(256074);
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0162, code lost:
        if (r2 == null) goto L_0x0164;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0220  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.view.ViewGroup r16, com.tencent.mm.plugin.finder.loader.s r17, kotlin.g.a.b<? super com.tencent.mm.plugin.finder.video.r, kotlin.x> r18) {
        /*
        // Method dump skipped, instructions count: 620
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler.a(android.view.ViewGroup, com.tencent.mm.plugin.finder.loader.s, kotlin.g.a.b):void");
    }

    public static final class e implements b {
        final /* synthetic */ Context $context$inlined;
        final /* synthetic */ String uJv;
        final /* synthetic */ int wBm;
        final /* synthetic */ FinderVideoRecycler wBn;
        final /* synthetic */ Class wBo;
        final /* synthetic */ kotlin.g.a.b wBp;
        final /* synthetic */ int wBq;
        final /* synthetic */ boolean wBr;
        final /* synthetic */ ViewGroup wbV;

        e(int i2, FinderVideoRecycler finderVideoRecycler, Class cls, ViewGroup viewGroup, String str, kotlin.g.a.b bVar, Context context, int i3, boolean z) {
            this.wBm = i2;
            this.wBn = finderVideoRecycler;
            this.wBo = cls;
            this.wbV = viewGroup;
            this.uJv = str;
            this.wBp = bVar;
            this.$context$inlined = context;
            this.wBq = i3;
            this.wBr = z;
        }

        @Override // com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler.b
        public final boolean a(com.tencent.mm.plugin.finder.video.r rVar) {
            AppMethodBeat.i(256044);
            kotlin.g.b.p.h(rVar, "videoView");
            if (kotlin.g.b.p.j((String) this.wBn.wAY.get(Integer.valueOf(this.wBm)), this.uJv)) {
                Log.i("Finder.VideoRecycler", "[getOrCreate] wait for callback successfully. mediaId=" + this.uJv + " parent=" + this.wBm);
                this.wBp.invoke(rVar);
                AppMethodBeat.o(256044);
                return true;
            }
            Log.i("Finder.VideoRecycler", "wait for callback, but it(" + this.uJv + ") has been replace(" + ((String) this.wBn.wAY.get(Integer.valueOf(this.wBm))) + "). key=" + this.wBm);
            AppMethodBeat.o(256044);
            return false;
        }
    }

    private final com.tencent.mm.plugin.finder.video.r e(Class<? extends com.tencent.mm.plugin.finder.video.r> cls, boolean z) {
        String str;
        Boolean bool;
        ViewParent parentView;
        View videoView;
        View videoView2;
        Context context;
        Class<?> cls2;
        Integer num = null;
        AppMethodBeat.i(256076);
        z.e eVar = new z.e();
        eVar.SYF = MAlarmHandler.NEXT_FIRE_INTERVAL;
        z.f fVar = new z.f();
        fVar.SYG = null;
        I(new d(this, cls, eVar, new int[2], z, fVar));
        StringBuilder sb = new StringBuilder("[findOldestVideoView] activity=");
        T t = fVar.SYG;
        if (t == null || (videoView2 = t.getVideoView()) == null || (context = videoView2.getContext()) == null || (cls2 = context.getClass()) == null) {
            str = null;
        } else {
            str = cls2.getSimpleName();
        }
        StringBuilder append = sb.append(str).append(" mediaid:");
        T t2 = fVar.SYG;
        StringBuilder append2 = append.append(t2 != null ? t2.getVideoMediaId() : null).append(" videoView=");
        T t3 = fVar.SYG;
        StringBuilder append3 = append2.append(t3 != null ? Integer.valueOf(t3.hashCode()) : null).append(' ').append("isAttachedToWindow=");
        T t4 = fVar.SYG;
        if (t4 == null || (videoView = t4.getVideoView()) == null) {
            bool = null;
        } else {
            bool = Boolean.valueOf(videoView.isAttachedToWindow());
        }
        StringBuilder append4 = append3.append(bool).append(" parent=");
        T t5 = fVar.SYG;
        if (!(t5 == null || (parentView = t5.getParentView()) == null)) {
            num = Integer.valueOf(parentView.hashCode());
        }
        Log.i("Finder.VideoRecycler", append4.append(num).toString());
        T t6 = fVar.SYG;
        AppMethodBeat.o(256076);
        return t6;
    }

    public final void a(com.tencent.mm.plugin.finder.video.r rVar, String str) {
        AppMethodBeat.i(256077);
        if (this.wBd.containsKey(Integer.valueOf(rVar.hashCode()))) {
            Log.w("Finder.VideoRecycler", "[releaseVideoView] videoView=" + rVar.hashCode() + " is releasing, source=" + str);
            AppMethodBeat.o(256077);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.wBd.put(Integer.valueOf(rVar.hashCode()), new Object());
        ek(rVar.getVideoView());
        rVar.pause();
        StringBuilder append = new StringBuilder("[releaseVideoView] async release videoView(").append(rVar.hashCode()).append(") parent=");
        ViewParent parentView = rVar.getParentView();
        Log.i("Finder.VideoRecycler", append.append(parentView != null ? parentView.hashCode() : 0).append(" source=").append(str).toString());
        com.tencent.mm.ac.d.i(new o(this, rVar, currentTimeMillis, str));
        AppMethodBeat.o(256077);
    }

    public final void I(kotlin.g.a.b<? super com.tencent.mm.plugin.finder.video.r, Boolean> bVar) {
        AppMethodBeat.i(256078);
        Iterator<WeakReference<? extends com.tencent.mm.plugin.finder.video.r>> it = this.wAX.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.finder.video.r rVar = (com.tencent.mm.plugin.finder.video.r) it.next().get();
            if (rVar == null) {
                it.remove();
            } else if (bVar.invoke(rVar).booleanValue()) {
                it.remove();
            }
        }
        AppMethodBeat.o(256078);
    }

    public static /* synthetic */ int a(FinderVideoRecycler finderVideoRecycler) {
        AppMethodBeat.i(256080);
        int aP = finderVideoRecycler.aP(null);
        AppMethodBeat.o(256080);
        return aP;
    }

    private int aP(Class<? extends com.tencent.mm.plugin.finder.video.r> cls) {
        AppMethodBeat.i(256079);
        z.d dVar = new z.d();
        dVar.SYE = 0;
        I(new h(cls, dVar));
        int i2 = dVar.SYE;
        AppMethodBeat.o(256079);
        return i2;
    }

    @Override // android.arch.lifecycle.ViewModel
    public final void onCleared() {
        AppMethodBeat.i(256081);
        Log.i("Finder.VideoRecycler", "[onCleared] videoCount=" + a(this));
        onFinish();
        AppMethodBeat.o(256081);
    }

    public final void fJ(Context context) {
        AppMethodBeat.i(256082);
        com.tencent.mm.ac.d.h(new l(this, context));
        AppMethodBeat.o(256082);
    }

    public final void dIQ() {
        AppMethodBeat.i(256083);
        com.tencent.mm.ac.d.h(new c(this));
        AppMethodBeat.o(256083);
    }

    public final void J(kotlin.g.a.b<? super com.tencent.mm.plugin.finder.video.r, Boolean> bVar) {
        AppMethodBeat.i(256084);
        kotlin.g.b.p.h(bVar, "filter");
        com.tencent.mm.ac.d.h(new k(this, bVar));
        AppMethodBeat.o(256084);
    }

    public static final class j extends IListener<oq> {
        final /* synthetic */ FinderVideoRecycler wBg;

        static final class a extends kotlin.g.b.q implements kotlin.g.a.b<com.tencent.mm.plugin.finder.video.r, Boolean> {
            final /* synthetic */ String qWs;
            final /* synthetic */ j wBv;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(String str, j jVar) {
                super(1);
                this.qWs = str;
                this.wBv = jVar;
            }

            @Override // kotlin.g.a.b
            public final /* synthetic */ Boolean invoke(com.tencent.mm.plugin.finder.video.r rVar) {
                String str;
                String str2 = null;
                AppMethodBeat.i(256051);
                final com.tencent.mm.plugin.finder.video.r rVar2 = rVar;
                kotlin.g.b.p.h(rVar2, LocaleUtil.ITALIAN);
                s videoMediaInfo = rVar2.getVideoMediaInfo();
                if (videoMediaInfo != null) {
                    str = videoMediaInfo.mediaId;
                } else {
                    str = null;
                }
                if (kotlin.g.b.p.j(str, this.qWs) && rVar2.getVideoViewFocused() && (rVar2.getParentView() instanceof FinderVideoLayout)) {
                    Log.w("Finder.VideoRecycler", "[videoSourceChange] mediaId=" + this.qWs + " isPlaying...");
                    s videoMediaInfo2 = rVar2.getVideoMediaInfo();
                    if (videoMediaInfo2 != null) {
                        str2 = videoMediaInfo2.path;
                    }
                    com.tencent.mm.vfs.s.deleteFile(str2);
                    com.tencent.mm.plugin.finder.storage.logic.d dVar = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
                    String str3 = this.qWs;
                    kotlin.g.b.p.g(str3, "mediaId");
                    at avH = com.tencent.mm.plugin.finder.storage.logic.d.avH(str3);
                    avH.reset();
                    com.tencent.mm.plugin.finder.storage.logic.d dVar2 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
                    if (com.tencent.mm.plugin.finder.storage.logic.d.d(avH)) {
                        this.wBv.wBg.hAk.post(new Runnable() {
                            /* class com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler.j.a.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(256050);
                                ViewParent parentView = rVar2.getParentView();
                                if (parentView == null) {
                                    t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.video.FinderVideoLayout");
                                    AppMethodBeat.o(256050);
                                    throw tVar;
                                }
                                ((FinderVideoLayout) parentView).getRetryBtn().performClick();
                                AppMethodBeat.o(256050);
                            }
                        });
                    }
                }
                Boolean bool = Boolean.FALSE;
                AppMethodBeat.o(256051);
                return bool;
            }
        }

        j(FinderVideoRecycler finderVideoRecycler) {
            this.wBg = finderVideoRecycler;
        }

        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(oq oqVar) {
            AppMethodBeat.i(256052);
            oq oqVar2 = oqVar;
            if (oqVar2 != null && oqVar2.dUF.retCode == -21112) {
                String str = oqVar2.dUF.mediaId;
                Log.w("Finder.VideoRecycler", "[videoSourceChange] mediaId=".concat(String.valueOf(str)));
                FinderVideoRecycler.a(this.wBg, new a(str, this));
            }
            AppMethodBeat.o(256052);
            return false;
        }
    }

    public static final class o extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ long ipR;
        final /* synthetic */ String tJu;
        final /* synthetic */ FinderVideoRecycler wBg;
        final /* synthetic */ com.tencent.mm.plugin.finder.video.r wBz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(FinderVideoRecycler finderVideoRecycler, com.tencent.mm.plugin.finder.video.r rVar, long j2, String str) {
            super(0);
            this.wBg = finderVideoRecycler;
            this.wBz = rVar;
            this.ipR = j2;
            this.tJu = str;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(256062);
            if (this.wBz instanceof FinderThumbPlayerProxy) {
                ((FinderThumbPlayerProxy) this.wBz).setOnPlayerStopListener(new u(this) {
                    /* class com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler.o.AnonymousClass1 */
                    final /* synthetic */ o wBA;

                    {
                        this.wBA = r1;
                    }

                    /* renamed from: com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler$o$1$a */
                    static final class a implements Runnable {
                        final /* synthetic */ AnonymousClass1 wBB;

                        a(AnonymousClass1 r1) {
                            this.wBB = r1;
                        }

                        public final void run() {
                            AppMethodBeat.i(256059);
                            FinderVideoRecycler.a(this.wBB.wBA.wBg, this.wBB.wBA.wBz);
                            this.wBB.wBA.wBg.wBd.remove(Integer.valueOf(this.wBB.wBA.wBz.hashCode()));
                            Log.i("Finder.VideoRecycler", "[releaseVideoView] completed! cost=" + (System.currentTimeMillis() - this.wBB.wBA.ipR) + "ms, release view=" + this.wBB.wBA.wBz.hashCode() + " source=" + this.wBB.wBA.tJu);
                            AppMethodBeat.o(256059);
                        }
                    }

                    @Override // com.tencent.mm.plugin.finder.video.u
                    public final void dFR() {
                        AppMethodBeat.i(256060);
                        this.wBA.wBg.hAk.post(new a(this));
                        ((FinderThumbPlayerProxy) this.wBA.wBz).setOnPlayerStopListener(null);
                        AppMethodBeat.o(256060);
                    }
                });
                this.wBz.onUIDestroy();
            } else {
                this.wBz.onUIDestroy();
                this.wBg.hAk.post(new Runnable(this) {
                    /* class com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler.o.AnonymousClass2 */
                    final /* synthetic */ o wBA;

                    {
                        this.wBA = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(256061);
                        FinderVideoRecycler.a(this.wBA.wBg, this.wBA.wBz);
                        this.wBA.wBg.wBd.remove(Integer.valueOf(this.wBA.wBz.hashCode()));
                        Log.i("Finder.VideoRecycler", "[releaseVideoView] completed! cost=" + (System.currentTimeMillis() - this.wBA.ipR) + "ms, release view=" + this.wBA.wBz.hashCode() + " source=" + this.wBA.tJu);
                        AppMethodBeat.o(256061);
                    }
                });
            }
            x xVar = x.SXb;
            AppMethodBeat.o(256062);
            return xVar;
        }
    }

    public static final class l extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ Context $context;
        final /* synthetic */ FinderVideoRecycler wBg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(FinderVideoRecycler finderVideoRecycler, Context context) {
            super(0);
            this.wBg = finderVideoRecycler;
            this.$context = context;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(256056);
            FinderVideoRecycler.a(this.wBg, new kotlin.g.a.b<com.tencent.mm.plugin.finder.video.r, Boolean>(this) {
                /* class com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler.l.AnonymousClass1 */
                final /* synthetic */ l wBy;

                {
                    this.wBy = r2;
                }

                @Override // kotlin.g.a.b
                public final /* synthetic */ Boolean invoke(com.tencent.mm.plugin.finder.video.r rVar) {
                    AppMethodBeat.i(256055);
                    com.tencent.mm.plugin.finder.video.r rVar2 = rVar;
                    kotlin.g.b.p.h(rVar2, LocaleUtil.ITALIAN);
                    if (kotlin.g.b.p.j(rVar2.getVideoView().getContext(), this.wBy.$context) && rVar2.getVideoViewFocused()) {
                        rVar2.setVideoViewFocused(false);
                        rVar2.setIsShouldPlayResume(true);
                        rVar2.dFk();
                    }
                    Boolean bool = Boolean.FALSE;
                    AppMethodBeat.o(256055);
                    return bool;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(256056);
            return xVar;
        }
    }

    public static final class r extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ Context $context;
        final /* synthetic */ FinderVideoRecycler wBg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public r(FinderVideoRecycler finderVideoRecycler, Context context) {
            super(0);
            this.wBg = finderVideoRecycler;
            this.$context = context;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(256066);
            FinderVideoRecycler.a(this.wBg, new kotlin.g.a.b<com.tencent.mm.plugin.finder.video.r, Boolean>(this) {
                /* class com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler.r.AnonymousClass1 */
                final /* synthetic */ r wBD;

                {
                    this.wBD = r2;
                }

                @Override // kotlin.g.a.b
                public final /* synthetic */ Boolean invoke(com.tencent.mm.plugin.finder.video.r rVar) {
                    AppMethodBeat.i(256065);
                    com.tencent.mm.plugin.finder.video.r rVar2 = rVar;
                    kotlin.g.b.p.h(rVar2, LocaleUtil.ITALIAN);
                    if (kotlin.g.b.p.j(rVar2.getVideoView().getContext(), this.wBD.$context) && rVar2.getIsShouldPlayResume()) {
                        rVar2.setVideoViewFocused(true);
                        rVar2.setIsShouldPlayResume(false);
                        rVar2.play();
                    }
                    Boolean bool = Boolean.FALSE;
                    AppMethodBeat.o(256065);
                    return bool;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(256066);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class c extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderVideoRecycler wBg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderVideoRecycler finderVideoRecycler) {
            super(0);
            this.wBg = finderVideoRecycler;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(256042);
            FinderVideoRecycler.a(this.wBg, AnonymousClass1.wBh);
            x xVar = x.SXb;
            AppMethodBeat.o(256042);
            return xVar;
        }
    }

    public static final class k extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderVideoRecycler wBg;
        final /* synthetic */ kotlin.g.a.b wBw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(FinderVideoRecycler finderVideoRecycler, kotlin.g.a.b bVar) {
            super(0);
            this.wBg = finderVideoRecycler;
            this.wBw = bVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(256054);
            FinderVideoRecycler.a(this.wBg, new kotlin.g.a.b<com.tencent.mm.plugin.finder.video.r, Boolean>(this) {
                /* class com.tencent.mm.plugin.finder.viewmodel.component.FinderVideoRecycler.k.AnonymousClass1 */
                final /* synthetic */ k wBx;

                {
                    this.wBx = r2;
                }

                @Override // kotlin.g.a.b
                public final /* synthetic */ Boolean invoke(com.tencent.mm.plugin.finder.video.r rVar) {
                    AppMethodBeat.i(256053);
                    com.tencent.mm.plugin.finder.video.r rVar2 = rVar;
                    kotlin.g.b.p.h(rVar2, LocaleUtil.ITALIAN);
                    if (((Boolean) this.wBx.wBw.invoke(rVar2)).booleanValue()) {
                        boolean z = rVar2.getParentView() instanceof FinderVideoLayout;
                        boolean isPlaying = rVar2.isPlaying();
                        rVar2.setVideoViewFocused(false);
                        if (z) {
                            ViewParent parentView = rVar2.getParentView();
                            if (parentView == null) {
                                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.video.FinderVideoLayout");
                                AppMethodBeat.o(256053);
                                throw tVar;
                            }
                            FinderVideoLayout.b((FinderVideoLayout) parentView);
                        }
                        if (isPlaying) {
                            rVar2.pause();
                        }
                    }
                    Boolean bool = Boolean.FALSE;
                    AppMethodBeat.o(256053);
                    return bool;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(256054);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(FinderVideoRecycler finderVideoRecycler, com.tencent.mm.plugin.finder.video.r rVar) {
        boolean z = false;
        AppMethodBeat.i(256088);
        long currentTimeMillis = System.currentTimeMillis();
        rVar.setTag(R.id.d44, 0);
        finderVideoRecycler.I(new n(rVar));
        finderVideoRecycler.wAW.remove(rVar);
        if (finderVideoRecycler.aP(null) < finderVideoRecycler.wAU && finderVideoRecycler.wBa.contains(String.valueOf(rVar.getVideoView().getContext().hashCode()))) {
            z = true;
        }
        if (z) {
            finderVideoRecycler.wAX.add(new WeakReference<>(rVar));
            finderVideoRecycler.wAW.add(rVar);
            b remove = finderVideoRecycler.wAZ.remove(Integer.valueOf(rVar.hashCode()));
            if (remove != null && remove.a(rVar)) {
                finderVideoRecycler.wAW.remove(rVar);
            }
        } else {
            rVar.onRelease();
        }
        StringBuilder append = new StringBuilder("[recycledVideoView] ret=").append(z).append(" cost=").append(System.currentTimeMillis() - currentTimeMillis).append("ms view=").append(rVar.hashCode()).append(" videoCount=").append(a(finderVideoRecycler)).append(", recycledCount=").append(finderVideoRecycler.wAW.size()).append(", ");
        HashSet<com.tencent.mm.plugin.finder.video.r> hashSet = finderVideoRecycler.wAW;
        ArrayList arrayList = new ArrayList(kotlin.a.j.a(hashSet, 10));
        Iterator<T> it = hashSet.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(it.next().hashCode()));
        }
        Log.i("Finder.VideoRecycler", append.append(arrayList).append(' ').toString());
        AppMethodBeat.o(256088);
    }
}
