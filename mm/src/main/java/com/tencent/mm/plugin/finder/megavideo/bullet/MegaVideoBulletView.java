package com.tencent.mm.plugin.finder.megavideo.bullet;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.TextureView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.danmaku.a.g;
import com.tencent.mm.plugin.finder.megavideo.loader.a;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.video.FinderLongVideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0006\u0010\u001f\u001a\u00020\u001aJ\b\u0010 \u001a\u00020\u001aH\u0014J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020#H\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/bullet/MegaVideoBulletView;", "Landroid/view/TextureView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bulletManager", "Lcom/tencent/mm/plugin/finder/megavideo/bullet/MegaVideoBulletManager;", "getBulletManager", "()Lcom/tencent/mm/plugin/finder/megavideo/bullet/MegaVideoBulletManager;", "feed", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "setFeed", "(Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;)V", "playStatusListener", "Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar$PlayStatusListener;", "getPlayStatusListener", "()Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar$PlayStatusListener;", "onAttach", "", "onBind", "onConfigurationChange", "isLandscape", "", "onDetach", "onDetachedFromWindow", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "plugin-finder_release"})
public final class MegaVideoBulletView extends TextureView {
    public bm uKb;
    private final a uKc = new a(this);
    private final FinderLongVideoPlayerSeekBar.b uKd = new a(this);

    public MegaVideoBulletView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(248274);
        AppMethodBeat.o(248274);
    }

    public MegaVideoBulletView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(248275);
        AppMethodBeat.o(248275);
    }

    public final bm getFeed() {
        AppMethodBeat.i(248270);
        bm bmVar = this.uKb;
        if (bmVar == null) {
            p.btv("feed");
        }
        AppMethodBeat.o(248270);
        return bmVar;
    }

    public final void setFeed(bm bmVar) {
        AppMethodBeat.i(248271);
        p.h(bmVar, "<set-?>");
        this.uKb = bmVar;
        AppMethodBeat.o(248271);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/megavideo/bullet/MegaVideoBulletView$playStatusListener$1", "Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar$PlayStatusListener;", "onPlayStatusChange", "", "isPlay", "", "onProgress", "times", "", "onSeekTo", "timeStamp", "", "plugin-finder_release"})
    public static final class a implements FinderLongVideoPlayerSeekBar.b {
        final /* synthetic */ MegaVideoBulletView uKe;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(MegaVideoBulletView megaVideoBulletView) {
            this.uKe = megaVideoBulletView;
        }

        @Override // com.tencent.mm.plugin.finder.video.FinderLongVideoPlayerSeekBar.b
        public final void kr(boolean z) {
            AppMethodBeat.i(248267);
            d.h(new C1211a(this, z));
            AppMethodBeat.o(248267);
        }

        @Override // com.tencent.mm.plugin.finder.video.FinderLongVideoPlayerSeekBar.b
        public final void onProgress(long j2) {
            AppMethodBeat.i(248268);
            d.h(new b(this, j2));
            AppMethodBeat.o(248268);
        }

        @Override // com.tencent.mm.plugin.finder.video.FinderLongVideoPlayerSeekBar.b
        public final void rk(int i2) {
            AppMethodBeat.i(248269);
            d.h(new c(this, i2));
            AppMethodBeat.o(248269);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.finder.megavideo.bullet.MegaVideoBulletView$a$a  reason: collision with other inner class name */
        static final class C1211a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ boolean pNL;
            final /* synthetic */ a uKf;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1211a(a aVar, boolean z) {
                super(0);
                this.uKf = aVar;
                this.pNL = z;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(248264);
                if (this.pNL) {
                    a bulletManager = this.uKf.uKe.getBulletManager();
                    if (bulletManager.iuM) {
                        g gVar = bulletManager.uJP;
                        if (gVar == null) {
                            p.btv("danmakuManager");
                        }
                        if (!gVar.isPlaying()) {
                            g gVar2 = bulletManager.uJP;
                            if (gVar2 == null) {
                                p.btv("danmakuManager");
                            }
                            gVar2.resume();
                        }
                    }
                } else {
                    a bulletManager2 = this.uKf.uKe.getBulletManager();
                    if (bulletManager2.iuM) {
                        g gVar3 = bulletManager2.uJP;
                        if (gVar3 == null) {
                            p.btv("danmakuManager");
                        }
                        if (gVar3.isPlaying()) {
                            g gVar4 = bulletManager2.uJP;
                            if (gVar4 == null) {
                                p.btv("danmakuManager");
                            }
                            gVar4.pause();
                        }
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(248264);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class b extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ a uKf;
            final /* synthetic */ long uKg;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(a aVar, long j2) {
                super(0);
                this.uKf = aVar;
                this.uKg = j2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(248265);
                a bulletManager = this.uKf.uKe.getBulletManager();
                long j2 = this.uKg;
                if (bulletManager.iuM) {
                    bulletManager.iGC = j2;
                    com.tencent.mm.plugin.finder.megavideo.loader.a aVar = bulletManager.uJQ;
                    if (aVar == null) {
                        p.btv("bulletLoader");
                    }
                    d.a(0, new a.c(aVar, j2));
                }
                x xVar = x.SXb;
                AppMethodBeat.o(248265);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class c extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ a uKf;
            final /* synthetic */ int uKh;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(a aVar, int i2) {
                super(0);
                this.uKf = aVar;
                this.uKh = i2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(248266);
                a bulletManager = this.uKf.uKe.getBulletManager();
                int i2 = this.uKh;
                if (bulletManager.iuM) {
                    long j2 = ((long) i2) * 1000;
                    g gVar = bulletManager.uJP;
                    if (gVar == null) {
                        p.btv("danmakuManager");
                    }
                    gVar.seek(j2);
                    if (j2 < bulletManager.iGC) {
                        bulletManager.iGC = j2;
                        g gVar2 = bulletManager.uJP;
                        if (gVar2 == null) {
                            p.btv("danmakuManager");
                        }
                        gVar2.clear();
                        bm bmVar = bulletManager.uJO;
                        if (bmVar == null) {
                            p.btv("megaVideoFeed");
                        }
                        bulletManager.eg(bmVar.uOX);
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(248266);
                return xVar;
            }
        }
    }

    public final a getBulletManager() {
        return this.uKc;
    }

    public final FinderLongVideoPlayerSeekBar.b getPlayStatusListener() {
        return this.uKd;
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(248272);
        p.h(motionEvent, "event");
        if (motionEvent.getAction() == 0) {
            g gVar = this.uKc.uJP;
            if (gVar == null) {
                p.btv("danmakuManager");
            }
            gVar.c(new Point((int) motionEvent.getX(), ((int) motionEvent.getY()) + ((int) getY())));
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(248272);
        return onTouchEvent;
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        int i2 = 0;
        AppMethodBeat.i(248273);
        super.onDetachedFromWindow();
        a aVar = this.uKc;
        if (aVar.uJO == null || !aVar.iuM) {
            AppMethodBeat.o(248273);
            return;
        }
        aVar.iuM = false;
        StringBuilder sb = new StringBuilder("onDetach: id = ");
        bm bmVar = aVar.uJO;
        if (bmVar == null) {
            p.btv("megaVideoFeed");
        }
        Log.i("MegaVideoBulletManager", sb.append(bmVar.lT()).append("， this=").append(aVar.hashCode()).toString());
        g gVar = aVar.uJP;
        if (gVar == null) {
            p.btv("danmakuManager");
        }
        gVar.release();
        com.tencent.mm.plugin.finder.megavideo.loader.a aVar2 = aVar.uJQ;
        if (aVar2 == null) {
            p.btv("bulletLoader");
        }
        aVar2.context = null;
        StringBuilder sb2 = new StringBuilder("onDetach ");
        bm bmVar2 = aVar2.uJO;
        if (bmVar2 == null) {
            p.btv("megaVideoFeed");
        }
        StringBuilder append = sb2.append(bmVar2).append(' ');
        a.AbstractC1219a aVar3 = aVar2.uLj;
        if (aVar3 != null) {
            i2 = aVar3.hashCode();
        }
        Log.i("Finder.MegaVideoBulletLoader", append.append(i2).toString());
        com.tencent.mm.kernel.g.azz().b(6865, aVar2);
        com.tencent.mm.kernel.g.azz().b(4101, aVar);
        AppMethodBeat.o(248273);
    }
}
