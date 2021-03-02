package com.tencent.mm.plugin.finder.music;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.os.Message;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.MediaBanner;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u000e\u0018\u0000 L2\u00020\u0001:\u0001LB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010>\u001a\u00020?2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dJ\u0010\u0010@\u001a\u00020?2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0006\u0010A\u001a\u00020\u0010J\b\u0010B\u001a\u00020?H\u0014J\u0006\u0010C\u001a\u00020\u0010J\u0006\u0010D\u001a\u00020?J\b\u0010E\u001a\u00020?H\u0002J\u0006\u0010F\u001a\u00020?J\u0006\u0010G\u001a\u00020?J\u0006\u0010H\u001a\u00020?J\b\u0010I\u001a\u00020?H\u0002J\b\u0010J\u001a\u00020?H\u0002J\u0006\u0010K\u001a\u00020?R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0011\"\u0004\b0\u0010\u0013R\u001a\u00101\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0011\"\u0004\b3\u0010\u0013R\u001a\u00104\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0011\"\u0004\b6\u0010\u0013R(\u00109\u001a\u0004\u0018\u0001082\b\u00107\u001a\u0004\u0018\u000108@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=¨\u0006M"}, hxF = {"Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicTag;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "frameAnim", "Landroid/graphics/drawable/AnimationDrawable;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "isMusicFocused", "", "()Z", "setMusicFocused", "(Z)V", "isMusicPauseManually", "setMusicPauseManually", "musicIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getMusicIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setMusicIcon", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "getMusicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "setMusicInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;)V", "player", "Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayer;", "getPlayer", "()Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayer;", "setPlayer", "(Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicPlayer;)V", FFmpegMetadataRetriever.METADATA_KEY_VIDEO_ROTATION, "Landroid/animation/ObjectAnimator;", "getRotate", "()Landroid/animation/ObjectAnimator;", "setRotate", "(Landroid/animation/ObjectAnimator;)V", "shouldImgLoop", "getShouldImgLoop", "setShouldImgLoop", "shouldMusicResume", "getShouldMusicResume", "setShouldMusicResume", "viewEnable", "getViewEnable", "setViewEnable", "value", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "viewPager", "getViewPager", "()Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "setViewPager", "(Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;)V", "bindMusicInfo", "", "initView", "isPlaying", "onDetachedFromWindow", "onViewClick", "onViewRecycled", "pauseImgLoop", "pauseMusic", "pauseMusicAuto", "playMusic", "startLoopImg", "stopImgLoop", "unbindMusicInfo", "Companion", "plugin-finder_release"})
public final class FinderImgFeedMusicTag extends FrameLayout {
    public static final a uPM = new a((byte) 0);
    private final MMHandler handler = new MMHandler("FinderImgFeedMusicTag", new c(this));
    azk musicInfo;
    public a uPD;
    public boolean uPE;
    public boolean uPF;
    public boolean uPG;
    private ObjectAnimator uPH;
    private boolean uPI;
    private WeImageView uPJ;
    private boolean uPK = true;
    private FinderMediaBanner uPL;

    static {
        AppMethodBeat.i(248954);
        AppMethodBeat.o(248954);
    }

    public static final /* synthetic */ void c(FinderImgFeedMusicTag finderImgFeedMusicTag) {
        AppMethodBeat.i(248956);
        finderImgFeedMusicTag.dlc();
        AppMethodBeat.o(248956);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicTag$Companion;", "", "()V", "IMAGE_LOOP_INTERVAL", "", "IMAGE_LOOP_PAUSE_INTERVAL", "SCROLL_TO_NEXT_IMG_WHAT", "", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderImgFeedMusicTag(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(248952);
        bh(context);
        AppMethodBeat.o(248952);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderImgFeedMusicTag(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(248953);
        bh(context);
        AppMethodBeat.o(248953);
    }

    public final azk getMusicInfo() {
        return this.musicInfo;
    }

    public final void setMusicInfo(azk azk) {
        this.musicInfo = azk;
    }

    public final a getPlayer() {
        return this.uPD;
    }

    public final void setPlayer(a aVar) {
        this.uPD = aVar;
    }

    public final void setMusicFocused(boolean z) {
        this.uPE = z;
    }

    public final boolean getShouldMusicResume() {
        return this.uPF;
    }

    public final void setShouldMusicResume(boolean z) {
        this.uPF = z;
    }

    public final void setMusicPauseManually(boolean z) {
        this.uPG = z;
    }

    public final ObjectAnimator getRotate() {
        return this.uPH;
    }

    public final void setRotate(ObjectAnimator objectAnimator) {
        this.uPH = objectAnimator;
    }

    public final boolean getShouldImgLoop() {
        return this.uPI;
    }

    public final void setShouldImgLoop(boolean z) {
        this.uPI = z;
    }

    public final WeImageView getMusicIcon() {
        return this.uPJ;
    }

    public final void setMusicIcon(WeImageView weImageView) {
        this.uPJ = weImageView;
    }

    public final boolean getViewEnable() {
        return this.uPK;
    }

    public final void setViewEnable(boolean z) {
        this.uPK = z;
    }

    public final FinderMediaBanner getViewPager() {
        return this.uPL;
    }

    public final void setViewPager(FinderMediaBanner finderMediaBanner) {
        RecyclerHorizontalViewPager pagerView;
        RecyclerView.a adapter;
        boolean z = true;
        AppMethodBeat.i(248943);
        this.uPL = finderMediaBanner;
        if (((finderMediaBanner == null || (adapter = finderMediaBanner.getAdapter()) == null) ? 0 : adapter.getItemCount()) <= 1) {
            z = false;
        }
        this.uPI = z;
        if (finderMediaBanner == null || (pagerView = finderMediaBanner.getPagerView()) == null) {
            AppMethodBeat.o(248943);
            return;
        }
        pagerView.a(new e(this));
        AppMethodBeat.o(248943);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/music/FinderImgFeedMusicTag$viewPager$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-finder_release"})
    public static final class e extends RecyclerView.l {
        final /* synthetic */ FinderImgFeedMusicTag uPO;

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(248942);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/music/FinderImgFeedMusicTag$viewPager$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            super.onScrolled(recyclerView, i2, i3);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/music/FinderImgFeedMusicTag$viewPager$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(248942);
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(FinderImgFeedMusicTag finderImgFeedMusicTag) {
            this.uPO = finderImgFeedMusicTag;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(248941);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/music/FinderImgFeedMusicTag$viewPager$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 1) {
                FinderImgFeedMusicTag.b(this.uPO);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/music/FinderImgFeedMusicTag$viewPager$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(248941);
        }
    }

    private final void bh(Context context) {
        AppMethodBeat.i(248944);
        View inflate = aa.jQ(context).inflate(R.layout.a9f, (ViewGroup) null);
        if (inflate == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.imageview.WeImageView");
            AppMethodBeat.o(248944);
            throw tVar;
        }
        this.uPJ = (WeImageView) inflate;
        addView(this.uPJ);
        WeImageView weImageView = this.uPJ;
        ViewGroup.LayoutParams layoutParams = weImageView != null ? weImageView.getLayoutParams() : null;
        if (layoutParams == null) {
            t tVar2 = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            AppMethodBeat.o(248944);
            throw tVar2;
        }
        ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        WeImageView weImageView2 = this.uPJ;
        if (weImageView2 != null) {
            weImageView2.setImageDrawable(ar.m(context, R.raw.finder_bgm_gif_first_page, com.tencent.mm.cb.a.n(context, R.color.FG_2)));
        }
        post(new d(this, context));
        AppMethodBeat.o(248944);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class d implements Runnable {
        final /* synthetic */ Context $context;
        final /* synthetic */ FinderImgFeedMusicTag uPO;

        d(FinderImgFeedMusicTag finderImgFeedMusicTag, Context context) {
            this.uPO = finderImgFeedMusicTag;
            this.$context = context;
        }

        public final void run() {
            AppMethodBeat.i(248940);
            ak akVar = new ak(this.uPO);
            int aH = com.tencent.mm.cb.a.aH(this.$context, R.dimen.ct);
            Rect rect = new Rect();
            this.uPO.getHitRect(rect);
            rect.inset(-aH, -aH);
            akVar.a(new al(rect, this.uPO));
            AppMethodBeat.o(248940);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
    static final class c implements MMHandler.Callback {
        final /* synthetic */ FinderImgFeedMusicTag uPO;

        c(FinderImgFeedMusicTag finderImgFeedMusicTag) {
            this.uPO = finderImgFeedMusicTag;
        }

        public final boolean handleMessage(Message message) {
            AppMethodBeat.i(248939);
            switch (message.what) {
                case 1:
                    com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                        /* class com.tencent.mm.plugin.finder.music.FinderImgFeedMusicTag.c.AnonymousClass1 */
                        final /* synthetic */ c uPQ;

                        {
                            this.uPQ = r2;
                        }

                        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/music/FinderImgFeedMusicTag$handler$1$1$1$1"})
                        /* renamed from: com.tencent.mm.plugin.finder.music.FinderImgFeedMusicTag$c$1$a */
                        static final class a implements Runnable {
                            final /* synthetic */ FinderMediaBannerAdapter tCG;
                            final /* synthetic */ FinderMediaBanner uPR;
                            final /* synthetic */ AnonymousClass1 uPS;

                            a(FinderMediaBannerAdapter finderMediaBannerAdapter, FinderMediaBanner finderMediaBanner, AnonymousClass1 r3) {
                                this.tCG = finderMediaBannerAdapter;
                                this.uPR = finderMediaBanner;
                                this.uPS = r3;
                            }

                            public final void run() {
                                AppMethodBeat.i(248937);
                                this.tCG.removeItem(this.tCG.getItemCount() - 1);
                                try {
                                    this.tCG.a(this.uPR.getDataObserver());
                                } catch (IllegalStateException e2) {
                                    Log.i("FinderImgFeedMusicTag", "msg:" + e2.getMessage());
                                }
                                MediaBanner.a(this.uPR, 0);
                                FinderImgFeedMusicTag.c(this.uPS.uPQ.uPO);
                                AppMethodBeat.o(248937);
                            }
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ x invoke() {
                            int i2;
                            AppMethodBeat.i(248938);
                            FinderMediaBanner viewPager = this.uPQ.uPO.getViewPager();
                            if (viewPager != null) {
                                int focusPosition = viewPager.getFocusPosition() + 1;
                                RecyclerView.a adapter = viewPager.getAdapter();
                                if (focusPosition < (adapter != null ? adapter.getItemCount() : 0)) {
                                    MediaBanner.b(viewPager, focusPosition);
                                    FinderImgFeedMusicTag.c(this.uPQ.uPO);
                                } else {
                                    RecyclerView.a adapter2 = viewPager.getAdapter();
                                    if (adapter2 != null) {
                                        i2 = adapter2.getItemCount();
                                    } else {
                                        i2 = 0;
                                    }
                                    if (focusPosition == i2) {
                                        RecyclerView.a adapter3 = viewPager.getAdapter();
                                        if (adapter3 == null) {
                                            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter");
                                            AppMethodBeat.o(248938);
                                            throw tVar;
                                        }
                                        FinderMediaBannerAdapter finderMediaBannerAdapter = (FinderMediaBannerAdapter) adapter3;
                                        try {
                                            finderMediaBannerAdapter.b(viewPager.getDataObserver());
                                        } catch (IllegalStateException e2) {
                                            Log.i("FinderImgFeedMusicTag", "msg:" + e2.getMessage());
                                        }
                                        finderMediaBannerAdapter.p(finderMediaBannerAdapter.getItemAtPosition(0), finderMediaBannerAdapter.getItemCount());
                                        finderMediaBannerAdapter.cj(finderMediaBannerAdapter.getItemCount());
                                        viewPager.getPagerView().setItemAnimator(null);
                                        MediaBanner.b(viewPager, focusPosition);
                                        viewPager.postDelayed(new a(finderMediaBannerAdapter, viewPager, this), 300);
                                    }
                                }
                            }
                            x xVar = x.SXb;
                            AppMethodBeat.o(248938);
                            return xVar;
                        }
                    });
                    break;
            }
            AppMethodBeat.o(248939);
            return true;
        }
    }

    private final void dlc() {
        AppMethodBeat.i(248945);
        if (this.uPI) {
            this.handler.removeMessages(1);
            this.handler.sendEmptyMessageDelayed(1, 3000);
        }
        AppMethodBeat.o(248945);
    }

    /* access modifiers changed from: package-private */
    public final void dld() {
        AppMethodBeat.i(248946);
        if (this.uPI) {
            this.handler.removeMessages(1);
        }
        AppMethodBeat.o(248946);
    }

    public final void a(azk azk) {
        a aVar;
        AppMethodBeat.i(248947);
        if (azk != null) {
            b bVar = new b(azk, this, azk);
            if (this.musicInfo == null) {
                bVar.invoke();
                AppMethodBeat.o(248947);
                return;
            }
            azk azk2 = this.musicInfo;
            if (azk2 == null) {
                p.hyc();
            }
            if (!p.j(azk2.wWb, azk.wWb) || (aVar = this.uPD) == null || !aVar.isPlaying()) {
                dle();
                bVar.invoke();
                AppMethodBeat.o(248947);
                return;
            }
            StringBuilder sb = new StringBuilder("[bindMusicInfo] already bind and playing,musicName = ");
            azk azk3 = this.musicInfo;
            Log.i("FinderImgFeedMusicTag", sb.append(azk3 != null ? azk3.name : null).toString());
            AppMethodBeat.o(248947);
            return;
        }
        AppMethodBeat.o(248947);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"initTag", "", "invoke", "com/tencent/mm/plugin/finder/music/FinderImgFeedMusicTag$bindMusicInfo$1$1"})
    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ azk uPN;
        final /* synthetic */ FinderImgFeedMusicTag uPO;
        final /* synthetic */ azk uPP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(azk azk, FinderImgFeedMusicTag finderImgFeedMusicTag, azk azk2) {
            super(0);
            this.uPN = azk;
            this.uPO = finderImgFeedMusicTag;
            this.uPP = azk2;
        }

        @Override // kotlin.g.a.a
        public final void invoke() {
            AppMethodBeat.i(248936);
            Log.i("FinderImgFeedMusicTag", "[bindMusicInfo] musicInfo:" + this.uPN.name + ",viewID:" + this.uPO);
            this.uPO.setMusicInfo(this.uPN);
            if (this.uPO.getPlayer() != null) {
                StringBuilder sb = new StringBuilder("[bindMusicInfo] this.player is not null and isPlaying = ");
                a player = this.uPO.getPlayer();
                Log.i("FinderImgFeedMusicTag", sb.append(player != null ? Boolean.valueOf(player.isPlaying()) : null).toString());
                a player2 = this.uPO.getPlayer();
                if (player2 != null) {
                    player2.release();
                }
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                Context context = this.uPO.getContext();
                p.g(context, "context");
                ((FinderImgFeedMusicPlayerManager) com.tencent.mm.ui.component.a.ko(context).get(FinderImgFeedMusicPlayerManager.class)).a(this.uPO);
            }
            FinderImgFeedMusicTag finderImgFeedMusicTag = this.uPO;
            Context context2 = this.uPO.getContext();
            p.g(context2, "context");
            finderImgFeedMusicTag.setPlayer(new a(context2, this.uPP));
            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
            Context context3 = this.uPO.getContext();
            p.g(context3, "context");
            FinderImgFeedMusicPlayerManager finderImgFeedMusicPlayerManager = (FinderImgFeedMusicPlayerManager) com.tencent.mm.ui.component.a.ko(context3).get(FinderImgFeedMusicPlayerManager.class);
            FinderImgFeedMusicTag finderImgFeedMusicTag2 = this.uPO;
            a player3 = this.uPO.getPlayer();
            if (player3 == null) {
                p.hyc();
            }
            finderImgFeedMusicPlayerManager.a(finderImgFeedMusicTag2, player3);
            AppMethodBeat.o(248936);
        }
    }

    public final void dle() {
        AppMethodBeat.i(248948);
        this.handler.removeMessages(1);
        ObjectAnimator objectAnimator = this.uPH;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        clearAnimation();
        this.uPE = false;
        this.uPF = false;
        this.uPG = false;
        a aVar = this.uPD;
        if (aVar != null) {
            aVar.release();
        }
        this.musicInfo = null;
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        Context context = getContext();
        p.g(context, "context");
        ((FinderImgFeedMusicPlayerManager) com.tencent.mm.ui.component.a.ko(context).get(FinderImgFeedMusicPlayerManager.class)).a(this);
        AppMethodBeat.o(248948);
    }

    public final void dlf() {
        String str = null;
        AppMethodBeat.i(248949);
        if (this.musicInfo == null || this.uPD == null) {
            StringBuilder sb = new StringBuilder("[playMusic] musicInfo = ");
            azk azk = this.musicInfo;
            if (azk != null) {
                str = azk.name;
            }
            Log.i("FinderImgFeedMusicTag", sb.append(str).append(",player = ").append(this.uPD).append(",viewID:").append(this).toString());
            AppMethodBeat.o(248949);
            return;
        }
        this.uPE = true;
        this.uPF = true;
        a aVar = this.uPD;
        if (aVar != null && aVar.isPlaying()) {
            Log.i("FinderImgFeedMusicTag", "music playing");
            AppMethodBeat.o(248949);
        } else if (this.uPG) {
            Log.i("FinderImgFeedMusicTag", "music pause Manually, dont play");
            AppMethodBeat.o(248949);
        } else {
            if (this.musicInfo != null) {
                StringBuilder sb2 = new StringBuilder("[playMusic] play success musicInfo:");
                azk azk2 = this.musicInfo;
                if (azk2 != null) {
                    str = azk2.name;
                }
                Log.i("FinderImgFeedMusicTag", sb2.append(str).append(",viewID:").append(this).toString());
                a aVar2 = this.uPD;
                if (aVar2 != null) {
                    aVar2.play();
                }
                dlc();
            }
            AppMethodBeat.o(248949);
        }
    }

    public final void bdY() {
        AppMethodBeat.i(248950);
        if (this.musicInfo == null || this.uPD == null) {
            AppMethodBeat.o(248950);
            return;
        }
        a aVar = this.uPD;
        if (aVar != null) {
            aVar.pause();
        }
        dld();
        AppMethodBeat.o(248950);
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        AppMethodBeat.i(248951);
        super.onDetachedFromWindow();
        bdY();
        AppMethodBeat.o(248951);
    }

    public static final /* synthetic */ void b(FinderImgFeedMusicTag finderImgFeedMusicTag) {
        AppMethodBeat.i(248955);
        if (finderImgFeedMusicTag.uPI) {
            finderImgFeedMusicTag.handler.removeMessages(1);
            finderImgFeedMusicTag.handler.sendEmptyMessageDelayed(1, 20000);
        }
        AppMethodBeat.o(248955);
    }
}
