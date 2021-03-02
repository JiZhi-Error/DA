package com.tencent.mm.plugin.finder.ui;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.event.c;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.music.FinderImgFeedMusicTag;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.FinderLongVideoPlayerSeekBar;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.protocal.protobuf.azy;
import com.tencent.mm.protocal.protobuf.cjk;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjx;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ao;
import com.tencent.mm.view.AnimationLayout;
import com.tencent.mm.view.HardTouchableLayout;
import com.tencent.mm.view.MediaBanner;
import com.tencent.mm.view.ViewAnimHelper;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.t;

@com.tencent.mm.ui.base.a(35)
@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 T2\u00020\u0001:\u0001TB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u000fH\u0002J\b\u0010B\u001a\u00020\u000fH\u0014J\b\u0010C\u001a\u00020@H\u0002J\b\u0010D\u001a\u00020@H\u0014J\b\u0010E\u001a\u00020@H\u0016J\u0012\u0010F\u001a\u00020@2\b\u0010G\u001a\u0004\u0018\u00010HH\u0016J\b\u0010I\u001a\u00020@H\u0014J\b\u0010J\u001a\u00020@H\u0014J\b\u0010K\u001a\u00020@H\u0014J\u0010\u0010L\u001a\u00020@2\u0006\u0010M\u001a\u00020\u0014H\u0016J\b\u0010N\u001a\u00020@H\u0002J\b\u0010O\u001a\u00020\u0014H\u0002J\u0010\u0010P\u001a\u00020@2\u0006\u0010Q\u001a\u00020\u0014H\u0002J\u0010\u0010R\u001a\u00020@2\u0006\u0010S\u001a\u00020\u000fH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0011\u0010\fR\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\b\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001b\u00101\u001a\u0002028BX\u0002¢\u0006\f\n\u0004\b5\u0010\b\u001a\u0004\b3\u00104R\u001b\u00106\u001a\u0002078BX\u0002¢\u0006\f\n\u0004\b:\u0010\b\u001a\u0004\b8\u00109R\u000e\u0010;\u001a\u00020<X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u000e¢\u0006\u0002\n\u0000¨\u0006U"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "animationLayout", "Lcom/tencent/mm/view/AnimationLayout;", "getAnimationLayout", "()Lcom/tencent/mm/view/AnimationLayout;", "animationLayout$delegate", "Lkotlin/Lazy;", "closeBtn", "Landroid/view/View;", "getCloseBtn", "()Landroid/view/View;", "closeBtn$delegate", "curPos", "", "galleryBg", "getGalleryBg", "galleryBg$delegate", "isComeFromCreate", "", "isLongVideoPreview", "mediaBanner", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "getMediaBanner", "()Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "mediaBanner$delegate", "mediaList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getMediaList", "()Ljava/util/LinkedList;", "musicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "getMusicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;", "setMusicInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderMusicInfo;)V", "musicTagView", "Lcom/tencent/mm/plugin/finder/music/FinderImgFeedMusicTag;", "playingAnimation", "posterLayout", "Landroid/view/ViewGroup;", "refFeedInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "getRefFeedInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "setRefFeedInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;)V", "seekBar", "Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;", "getSeekBar", "()Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;", "seekBar$delegate", "touchableLayout", "Lcom/tencent/mm/view/HardTouchableLayout;", "getTouchableLayout", "()Lcom/tencent/mm/view/HardTouchableLayout;", "touchableLayout$delegate", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "videoDispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "checkPlay", "", "position", "getLayoutId", "initSeekBar", "initView", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onWindowFocusChanged", "hasFocus", "runEnterAnimation", "runExitAnimation", "toggleVideo", "isPlay", "videoSeek", "time", "Companion", "plugin-finder_release"})
public final class FinderMediaPreviewUI extends MMFinderUI {
    public static final a vMg = new a((byte) 0);
    private HashMap _$_findViewCache;
    private boolean jUE;
    final LinkedList<cjl> mediaList = new LinkedList<>();
    private azk musicInfo;
    private final com.tencent.mm.plugin.finder.video.k tCD = new com.tencent.mm.plugin.finder.video.k();
    private int uis;
    private final kotlin.f vLU = kotlin.g.ah(new m(this));
    private FinderImgFeedMusicTag vLV;
    private final kotlin.f vLW = kotlin.g.ah(new d(this));
    private final kotlin.f vLX = kotlin.g.ah(new e(this));
    private final kotlin.f vLY = kotlin.g.ah(new b(this));
    private final kotlin.f vLZ = kotlin.g.ah(new r(this));
    private ViewGroup vMa;
    private final kotlin.f vMb = kotlin.g.ah(new q(this));
    private azy vMc;
    private boolean vMd = true;
    private boolean vMe;
    private com.tencent.mm.plugin.finder.event.base.c vMf;

    static {
        AppMethodBeat.i(167420);
        AppMethodBeat.o(167420);
    }

    private final FinderMediaBanner dzQ() {
        AppMethodBeat.i(167421);
        FinderMediaBanner finderMediaBanner = (FinderMediaBanner) this.vLU.getValue();
        AppMethodBeat.o(167421);
        return finderMediaBanner;
    }

    private final View dzR() {
        AppMethodBeat.i(167422);
        View view = (View) this.vLW.getValue();
        AppMethodBeat.o(167422);
        return view;
    }

    private final View dzS() {
        AppMethodBeat.i(167423);
        View view = (View) this.vLX.getValue();
        AppMethodBeat.o(167423);
        return view;
    }

    private final AnimationLayout dzT() {
        AppMethodBeat.i(167424);
        AnimationLayout animationLayout = (AnimationLayout) this.vLY.getValue();
        AppMethodBeat.o(167424);
        return animationLayout;
    }

    private final FinderLongVideoPlayerSeekBar dzU() {
        AppMethodBeat.i(252528);
        FinderLongVideoPlayerSeekBar finderLongVideoPlayerSeekBar = (FinderLongVideoPlayerSeekBar) this.vMb.getValue();
        AppMethodBeat.o(252528);
        return finderLongVideoPlayerSeekBar;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252538);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252538);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(252537);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(252537);
        return view;
    }

    public FinderMediaPreviewUI() {
        AppMethodBeat.i(167432);
        AppMethodBeat.o(167432);
    }

    public static final /* synthetic */ void b(FinderMediaPreviewUI finderMediaPreviewUI, int i2) {
        AppMethodBeat.i(167434);
        finderMediaPreviewUI.Ls(i2);
        AppMethodBeat.o(167434);
    }

    public static final /* synthetic */ boolean d(FinderMediaPreviewUI finderMediaPreviewUI) {
        AppMethodBeat.i(252533);
        boolean dzV = finderMediaPreviewUI.dzV();
        AppMethodBeat.o(252533);
        return dzV;
    }

    public static final /* synthetic */ FinderLongVideoPlayerSeekBar e(FinderMediaPreviewUI finderMediaPreviewUI) {
        AppMethodBeat.i(252534);
        FinderLongVideoPlayerSeekBar dzU = finderMediaPreviewUI.dzU();
        AppMethodBeat.o(252534);
        return dzU;
    }

    public static final /* synthetic */ View g(FinderMediaPreviewUI finderMediaPreviewUI) {
        AppMethodBeat.i(167435);
        View dzS = finderMediaPreviewUI.dzS();
        AppMethodBeat.o(167435);
        return dzS;
    }

    public static final /* synthetic */ View i(FinderMediaPreviewUI finderMediaPreviewUI) {
        AppMethodBeat.i(167436);
        View dzR = finderMediaPreviewUI.dzR();
        AppMethodBeat.o(167436);
        return dzR;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$Companion;", "", "()V", "IS_VLOG_MODE", "", "KEY_LONG_VIDEO_PREVIEW", "MEDIA_LIST", "MEDIA_LIST_COUNT", "REF_FEED_INFO", "TAG", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.agi;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(167425);
        requestWindowFeature(1);
        super.onCreate(bundle);
        getWindow().setFlags(201326592, 201326592);
        setLightNavigationbarIcon();
        ao.d(getWindow(), false);
        this.vMe = getIntent().getBooleanExtra("long_video_preview", false);
        initView();
        if (!this.jUE) {
            this.jUE = true;
            Log.i("Finder.MediaPreviewUI", "runEnterAnimation");
            Parcelable parcelableExtra = getIntent().getParcelableExtra("crop_info");
            if (!(parcelableExtra instanceof ViewAnimHelper.ViewInfo)) {
                parcelableExtra = null;
            }
            ViewAnimHelper.ViewInfo viewInfo = (ViewAnimHelper.ViewInfo) parcelableExtra;
            if (viewInfo == null) {
                AppMethodBeat.o(167425);
                return;
            }
            AnimationLayout dzT = dzT();
            View dzS = dzS();
            Window window = getWindow();
            kotlin.g.b.p.g(window, "window");
            dzT.a(dzS, window.getDecorView(), viewInfo, new n(this));
        }
        AppMethodBeat.o(167425);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        cjk cjk;
        cjx cjx;
        AppMethodBeat.i(167426);
        super.initView();
        cjk cjk2 = new cjk();
        try {
            cjk2.parseFrom(getIntent().getByteArrayExtra("media_list_"));
        } catch (Exception e2) {
            Log.printDebugStack("safeParser", "", e2);
            cjk2 = null;
        }
        cjk cjk3 = cjk2;
        if (cjk3 == null) {
            cjk = new cjk();
        } else {
            cjk = cjk3;
        }
        this.mediaList.addAll(cjk.mediaList);
        this.musicInfo = cjk.MoJ;
        r0 = this.mediaList.getFirst();
        float f2 = 0.0f;
        float f3 = r0.width;
        float f4 = r0.height;
        cjx cjx2 = r0.uOR;
        for (T first : this.mediaList) {
            float f5 = (first.height * 1.0f) / first.width;
            f2 = (first.height * 1.0f) / first.width;
            if (f2 < f5) {
                f3 = first.width;
                f4 = first.height;
                cjx = first.uOR;
            } else {
                cjx = cjx2;
                first = first;
            }
            cjx2 = cjx;
        }
        if (this.vMe) {
            y yVar = y.vXH;
            y.a(this, f3, f4, dzQ().getPagerView(), cjx2);
        } else {
            ViewGroup.LayoutParams layoutParams = dzQ().getPagerView().getLayoutParams();
            AppCompatActivity context = getContext();
            kotlin.g.b.p.g(context, "context");
            Resources resources = context.getResources();
            kotlin.g.b.p.g(resources, "context.resources");
            layoutParams.width = resources.getDisplayMetrics().widthPixels;
            ViewGroup.LayoutParams layoutParams2 = dzQ().getPagerView().getLayoutParams();
            AppCompatActivity context2 = getContext();
            kotlin.g.b.p.g(context2, "context");
            Resources resources2 = context2.getResources();
            kotlin.g.b.p.g(resources2, "context.resources");
            layoutParams2.height = (int) (((float) resources2.getDisplayMetrics().widthPixels) * f2);
        }
        dzQ().requestLayout();
        azk azk = this.musicInfo;
        if (azk != null) {
            dzQ().post(new i(azk, this));
        }
        dzT().setLayoutParams(new LinearLayout.LayoutParams(dzQ().getPagerView().getLayoutParams()));
        dzQ().getPagerViewContainer().removeView(dzQ().getPagerView());
        dzT().addView(dzQ().getPagerView());
        dzQ().getPagerViewContainer().addView(dzT(), 0);
        if (!this.vMe) {
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.a9e, (ViewGroup) dzQ().getPagerViewContainer(), false);
            if (inflate == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(167426);
                throw tVar;
            }
            this.vMa = (ViewGroup) inflate;
            ViewGroup viewGroup = this.vMa;
            ImageView imageView = viewGroup != null ? (ImageView) viewGroup.findViewById(R.id.gf4) : null;
            ViewGroup viewGroup2 = this.vMa;
            TextView textView = viewGroup2 != null ? (TextView) viewGroup2.findViewById(R.id.gfm) : null;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            if (textView != null) {
                textView.setVisibility(8);
            }
            c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
            com.tencent.mm.plugin.finder.api.g asG = c.a.asG(z.aUg());
            if (asG != null) {
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                if (textView != null) {
                    textView.setVisibility(0);
                }
                if (imageView != null) {
                    com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
                    com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> dka = com.tencent.mm.plugin.finder.loader.m.dka();
                    com.tencent.mm.plugin.finder.loader.a aVar2 = new com.tencent.mm.plugin.finder.loader.a(asG.field_avatarUrl);
                    com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
                    dka.a(aVar2, imageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.AVATAR));
                }
                if (textView != null) {
                    textView.setText(com.tencent.mm.pluginsdk.ui.span.l.c(getContext(), asG.getNickname()));
                }
            }
            ViewGroup viewGroup3 = this.vMa;
            if (viewGroup3 != null) {
                viewGroup3.setVisibility(8);
            }
            dzQ().getPagerViewContainer().addView(this.vMa);
        }
        ViewGroup.LayoutParams layoutParams3 = dzT().getLayoutParams();
        if (!(layoutParams3 instanceof FrameLayout.LayoutParams)) {
            layoutParams3 = null;
        }
        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) layoutParams3;
        y yVar2 = y.vXH;
        if (y.bk(f2)) {
            if (layoutParams4 != null) {
                layoutParams4.topMargin = 0;
            }
        } else if (layoutParams4 != null) {
            AppCompatActivity context3 = getContext();
            kotlin.g.b.p.g(context3, "context");
            layoutParams4.topMargin = (int) context3.getResources().getDimension(R.dimen.cq);
        }
        dzT().setLayoutParams(layoutParams4);
        ((HardTouchableLayout) this.vLZ.getValue()).setOnSingleClickListener(new j(this));
        dzR().setOnClickListener(new k(this));
        dzR().setVisibility(0);
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("ref_feed_info");
        if (byteArrayExtra != null) {
            azy azy = new azy();
            azy.parseFrom(byteArrayExtra);
            this.vMc = azy;
        }
        com.tencent.mm.plugin.finder.video.k.a(this.tCD, this, null, 6);
        FinderMediaBanner dzQ = dzQ();
        FinderMediaBannerAdapter finderMediaBannerAdapter = new FinderMediaBannerAdapter(this.tCD);
        finderMediaBannerAdapter.isLongVideo = this.vMe;
        finderMediaBannerAdapter.setItems(this.mediaList);
        dzQ.setAdapter(finderMediaBannerAdapter);
        dzQ().setRefFeedInfo(this.vMc);
        dzQ().setPageChangeCallback(new l(this));
        if (this.vMe) {
            this.vMf = new com.tencent.mm.plugin.finder.event.base.c("Finder.MediaPreviewUI");
            this.tCD.weT = new com.tencent.mm.plugin.finder.event.c(this.vMf);
            com.tencent.mm.plugin.finder.event.base.c cVar = this.vMf;
            if (cVar == null) {
                kotlin.g.b.p.hyc();
            }
            cVar.a(new f(this));
            dzU().setVisibility(0);
            dzU().setPlayBtnOnClickListener(new g(this));
            dzU().setVideoTotalTime(this.mediaList.getFirst().videoDuration);
            dzU().setIsPlay(true);
            dzU().setIplaySeekCallback(new h(this));
        }
        this.vLV = (FinderImgFeedMusicTag) findViewById(R.id.dwe);
        AppMethodBeat.o(167426);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$initView$2$1"})
    public static final class i implements Runnable {
        final /* synthetic */ azk uPN;
        final /* synthetic */ FinderMediaPreviewUI vMh;

        i(azk azk, FinderMediaPreviewUI finderMediaPreviewUI) {
            this.uPN = azk;
            this.vMh = finderMediaPreviewUI;
        }

        public final void run() {
            AppMethodBeat.i(252523);
            FinderImgFeedMusicTag finderImgFeedMusicTag = this.vMh.vLV;
            if (finderImgFeedMusicTag != null) {
                finderImgFeedMusicTag.setVisibility(8);
            }
            FinderImgFeedMusicTag finderImgFeedMusicTag2 = this.vMh.vLV;
            if (finderImgFeedMusicTag2 != null) {
                finderImgFeedMusicTag2.a(this.uPN);
            }
            FinderImgFeedMusicTag finderImgFeedMusicTag3 = this.vMh.vLV;
            if (finderImgFeedMusicTag3 != null) {
                finderImgFeedMusicTag3.dlf();
                AppMethodBeat.o(252523);
                return;
            }
            AppMethodBeat.o(252523);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$initView$4", "Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "onSingleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"})
    public static final class j implements HardTouchableLayout.g {
        final /* synthetic */ FinderMediaPreviewUI vMh;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        j(FinderMediaPreviewUI finderMediaPreviewUI) {
            this.vMh = finderMediaPreviewUI;
        }

        @Override // com.tencent.mm.view.HardTouchableLayout.g
        public final void b(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(252524);
            kotlin.g.b.p.h(view, "view");
            if (this.vMh.mediaList.get(this.vMh.uis).mediaType == 6) {
                com.tencent.mm.plugin.finder.video.k unused = this.vMh.tCD;
                com.tencent.mm.plugin.finder.video.k unused2 = this.vMh.tCD;
                AppMethodBeat.o(252524);
                return;
            }
            FinderMediaPreviewUI.d(this.vMh);
            AppMethodBeat.o(252524);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class k implements View.OnClickListener {
        final /* synthetic */ FinderMediaPreviewUI vMh;

        k(FinderMediaPreviewUI finderMediaPreviewUI) {
            this.vMh = finderMediaPreviewUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(252525);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$initView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.vMh.onBackPressed();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$initView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(252525);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$initView$8", "Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "onPageChange", "", "position", "", "isIdle", "", "isAuto", "plugin-finder_release"})
    public static final class l implements MediaBanner.c {
        final /* synthetic */ FinderMediaPreviewUI vMh;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        l(FinderMediaPreviewUI finderMediaPreviewUI) {
            this.vMh = finderMediaPreviewUI;
        }

        @Override // com.tencent.mm.view.MediaBanner.c
        public final void e(int i2, boolean z, boolean z2) {
            AppMethodBeat.i(252526);
            this.vMh.uis = i2;
            if (!z) {
                AppMethodBeat.o(252526);
                return;
            }
            FinderMediaPreviewUI.b(this.vMh, i2);
            AppMethodBeat.o(252526);
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        FinderImgFeedMusicTag finderImgFeedMusicTag;
        AppMethodBeat.i(252529);
        super.onResume();
        if (this.musicInfo == null || (finderImgFeedMusicTag = this.vLV) == null) {
            AppMethodBeat.o(252529);
            return;
        }
        finderImgFeedMusicTag.dlf();
        AppMethodBeat.o(252529);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        FinderImgFeedMusicTag finderImgFeedMusicTag;
        AppMethodBeat.i(252530);
        super.onPause();
        if (this.musicInfo == null || (finderImgFeedMusicTag = this.vLV) == null) {
            AppMethodBeat.o(252530);
            return;
        }
        finderImgFeedMusicTag.bdY();
        AppMethodBeat.o(252530);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        FinderImgFeedMusicTag finderImgFeedMusicTag;
        AppMethodBeat.i(252531);
        com.tencent.mm.plugin.finder.event.base.c cVar = this.vMf;
        if (cVar != null) {
            cVar.onRelease();
        }
        super.onDestroy();
        if (this.musicInfo == null || (finderImgFeedMusicTag = this.vLV) == null) {
            AppMethodBeat.o(252531);
            return;
        }
        finderImgFeedMusicTag.dle();
        AppMethodBeat.o(252531);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$initSeekBar$1", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "isCareEvent", "", "dispatcher", "Lcom/tencent/mm/plugin/finder/event/base/EventDispatcher;", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "onEventHappen", "", "ev", "plugin-finder_release"})
    public static final class f extends com.tencent.mm.plugin.finder.event.base.d {
        final /* synthetic */ FinderMediaPreviewUI vMh;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(FinderMediaPreviewUI finderMediaPreviewUI) {
            this.vMh = finderMediaPreviewUI;
        }

        @Override // com.tencent.mm.plugin.finder.event.base.d
        public final void a(com.tencent.mm.plugin.finder.event.base.b bVar) {
            AppMethodBeat.i(252518);
            kotlin.g.b.p.h(bVar, "ev");
            c.a aVar = (c.a) (!(bVar instanceof c.a) ? null : bVar);
            if (aVar == null) {
                AppMethodBeat.o(252518);
                return;
            }
            FinderMediaPreviewUI.e(this.vMh).post(new a(this, aVar));
            AppMethodBeat.o(252518);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ f vMi;
            final /* synthetic */ c.a vMj;

            a(f fVar, c.a aVar) {
                this.vMi = fVar;
                this.vMj = aVar;
            }

            public final void run() {
                AppMethodBeat.i(252517);
                switch (this.vMj.type) {
                    case 2:
                        FinderMediaPreviewUI.e(this.vMi.vMh).xv(0);
                        AppMethodBeat.o(252517);
                        return;
                    case 3:
                        FinderMediaPreviewUI.e(this.vMi.vMh).setVideoTotalTime(this.vMj.jcu);
                        FinderMediaPreviewUI.e(this.vMi.vMh).xv(this.vMj.offset);
                        break;
                }
                AppMethodBeat.o(252517);
            }
        }

        @Override // com.tencent.mm.plugin.finder.event.base.d
        public final boolean a(com.tencent.mm.plugin.finder.event.base.c cVar, com.tencent.mm.plugin.finder.event.base.b bVar) {
            AppMethodBeat.i(252519);
            kotlin.g.b.p.h(cVar, "dispatcher");
            kotlin.g.b.p.h(bVar, "event");
            boolean z = bVar instanceof c.a;
            AppMethodBeat.o(252519);
            return z;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class g implements View.OnClickListener {
        final /* synthetic */ FinderMediaPreviewUI vMh;

        g(FinderMediaPreviewUI finderMediaPreviewUI) {
            this.vMh = finderMediaPreviewUI;
        }

        public final void onClick(View view) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(252520);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$initSeekBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            boolean cEF = FinderMediaPreviewUI.e(this.vMh).cEF();
            FinderMediaPreviewUI finderMediaPreviewUI = this.vMh;
            if (!cEF) {
                z = true;
            } else {
                z = false;
            }
            FinderMediaPreviewUI.a(finderMediaPreviewUI, z);
            FinderLongVideoPlayerSeekBar e2 = FinderMediaPreviewUI.e(this.vMh);
            if (cEF) {
                z2 = false;
            }
            e2.setIsPlay(z2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$initSeekBar$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(252520);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$initSeekBar$3", "Lcom/tencent/mm/plugin/sight/decode/ui/IVideoPlaySeekCallback;", "onSeekPre", "", "onSeekTo", "time", "", "plugin-finder_release"})
    public static final class h implements com.tencent.mm.plugin.sight.decode.ui.b {
        final /* synthetic */ FinderMediaPreviewUI vMh;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        h(FinderMediaPreviewUI finderMediaPreviewUI) {
            this.vMh = finderMediaPreviewUI;
        }

        @Override // com.tencent.mm.plugin.sight.decode.ui.b
        public final void rk(int i2) {
            AppMethodBeat.i(252521);
            FinderMediaPreviewUI.c(this.vMh, i2);
            FinderMediaPreviewUI.e(this.vMh).setIsPlay(true);
            AppMethodBeat.o(252521);
        }

        @Override // com.tencent.mm.plugin.sight.decode.ui.b
        public final void aJq() {
            AppMethodBeat.i(252522);
            FinderMediaPreviewUI.a(this.vMh, false);
            FinderMediaPreviewUI.e(this.vMh).setIsPlay(false);
            AppMethodBeat.o(252522);
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void onWindowFocusChanged(boolean z) {
        AppMethodBeat.i(167427);
        AppMethodBeat.at(this, z);
        super.onWindowFocusChanged(z);
        if (z && this.vMd) {
            this.vMd = false;
            Ls(0);
        }
        AppMethodBeat.o(167427);
    }

    private final void Ls(int i2) {
        AppMethodBeat.i(167428);
        RecyclerView.v ch = dzQ().getPagerView().ch(i2);
        if (ch == null) {
            kotlin.g.b.p.hyc();
        }
        kotlin.g.b.p.g(ch, "mediaBanner.pagerView.fi…apterPosition(position)!!");
        if (ch.lU() == 2 || ch.lU() == 7) {
            this.tCD.dFz();
            AppMethodBeat.o(167428);
            return;
        }
        FinderVideoLayout finderVideoLayout = (FinderVideoLayout) ch.aus.findViewById(R.id.ckd);
        kotlin.g.b.p.g(this.mediaList.get(i2), "mediaList[position]");
        if (finderVideoLayout != null) {
            finderVideoLayout.getVideoCore().dFz();
            FinderItem finderItem = new FinderItem();
            finderItem.setMediaExtList(new LinkedList<>());
            finderItem.getMediaExtList().addAll(this.mediaList);
            if (finderVideoLayout.isLongVideo) {
                finderItem.setLongVideoMediaExtList(new LinkedList<>());
                finderItem.getLongVideoMediaExtList().addAll(this.mediaList);
                finderVideoLayout.setOnClickListener(new c(this));
            }
            FeedData.a aVar = FeedData.Companion;
            FinderVideoLayout.a(finderVideoLayout, 0, FeedData.a.i(finderItem), 0, false, false, 252);
            FinderVideoLayout.a(finderVideoLayout);
            AppMethodBeat.o(167428);
            return;
        }
        AppMethodBeat.o(167428);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$checkPlay$1$1"})
    public static final class c implements View.OnClickListener {
        final /* synthetic */ FinderMediaPreviewUI vMh;

        c(FinderMediaPreviewUI finderMediaPreviewUI) {
            this.vMh = finderMediaPreviewUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(252516);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$checkPlay$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (FinderMediaPreviewUI.e(this.vMh).getVisibility() == 0) {
                FinderMediaPreviewUI.e(this.vMh).setVisibility(8);
            } else {
                FinderMediaPreviewUI.e(this.vMh).setVisibility(0);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$checkPlay$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(252516);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public final void onBackPressed() {
        AppMethodBeat.i(167429);
        if (!dzV()) {
            finish();
        }
        AppMethodBeat.o(167429);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$runEnterAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class n implements Animator.AnimatorListener {
        final /* synthetic */ FinderMediaPreviewUI vMh;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        n(FinderMediaPreviewUI finderMediaPreviewUI) {
            this.vMh = finderMediaPreviewUI;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(167411);
            this.vMh.jUE = false;
            AppMethodBeat.o(167411);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(167412);
            FinderMediaPreviewUI.g(this.vMh).setVisibility(0);
            AppMethodBeat.o(167412);
        }
    }

    private final boolean dzV() {
        AppMethodBeat.i(252532);
        if (this.jUE) {
            AppMethodBeat.o(252532);
            return false;
        }
        this.jUE = true;
        Log.i("Finder.MediaPreviewUI", "runExitAnimation");
        Parcelable parcelableExtra = getIntent().getParcelableExtra("crop_info");
        if (!(parcelableExtra instanceof ViewAnimHelper.ViewInfo)) {
            parcelableExtra = null;
        }
        ViewAnimHelper.ViewInfo viewInfo = (ViewAnimHelper.ViewInfo) parcelableExtra;
        if (viewInfo == null) {
            AppMethodBeat.o(252532);
            return false;
        }
        AnimationLayout dzT = dzT();
        View dzS = dzS();
        Window window = getWindow();
        kotlin.g.b.p.g(window, "window");
        dzT.a(dzS, window.getDecorView(), viewInfo, new o(this), p.vMk);
        AppMethodBeat.o(252532);
        return true;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/ui/FinderMediaPreviewUI$runExitAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class o implements Animator.AnimatorListener {
        final /* synthetic */ FinderMediaPreviewUI vMh;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        o(FinderMediaPreviewUI finderMediaPreviewUI) {
            this.vMh = finderMediaPreviewUI;
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(167413);
            kotlin.g.b.p.h(animator, "animation");
            ViewGroup viewGroup = this.vMh.vMa;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            FinderMediaPreviewUI.i(this.vMh).setVisibility(8);
            AppMethodBeat.o(167413);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(167414);
            kotlin.g.b.p.h(animator, "animation");
            this.vMh.finish();
            this.vMh.overridePendingTransition(R.anim.s, R.anim.s);
            AppMethodBeat.o(167414);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(167415);
            kotlin.g.b.p.h(animator, "animation");
            AppMethodBeat.o(167415);
        }

        public final void onAnimationRepeat(Animator animator) {
            AppMethodBeat.i(167416);
            kotlin.g.b.p.h(animator, "animation");
            AppMethodBeat.o(167416);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    public static final class p implements ValueAnimator.AnimatorUpdateListener {
        public static final p vMk = new p();

        static {
            AppMethodBeat.i(167418);
            AppMethodBeat.o(167418);
        }

        p() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(167417);
            kotlin.g.b.p.g(valueAnimator, "animation");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(167417);
                throw tVar;
            }
            ((Float) animatedValue).floatValue();
            AppMethodBeat.o(167417);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "kotlin.jvm.PlatformType", "invoke"})
    static final class m extends kotlin.g.b.q implements kotlin.g.a.a<FinderMediaBanner> {
        final /* synthetic */ FinderMediaPreviewUI vMh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(FinderMediaPreviewUI finderMediaPreviewUI) {
            super(0);
            this.vMh = finderMediaPreviewUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ FinderMediaBanner invoke() {
            AppMethodBeat.i(167410);
            FinderMediaBanner finderMediaBanner = (FinderMediaBanner) this.vMh.findViewById(R.id.fbd);
            AppMethodBeat.o(167410);
            return finderMediaBanner;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ FinderMediaPreviewUI vMh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderMediaPreviewUI finderMediaPreviewUI) {
            super(0);
            this.vMh = finderMediaPreviewUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(167405);
            View findViewById = this.vMh.findViewById(R.id.b46);
            AppMethodBeat.o(167405);
            return findViewById;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class e extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ FinderMediaPreviewUI vMh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(FinderMediaPreviewUI finderMediaPreviewUI) {
            super(0);
            this.vMh = finderMediaPreviewUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(167406);
            View findViewById = this.vMh.findViewById(R.id.dcj);
            AppMethodBeat.o(167406);
            return findViewById;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/view/AnimationLayout;", "invoke"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<AnimationLayout> {
        final /* synthetic */ FinderMediaPreviewUI vMh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FinderMediaPreviewUI finderMediaPreviewUI) {
            super(0);
            this.vMh = finderMediaPreviewUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ AnimationLayout invoke() {
            AppMethodBeat.i(167404);
            AnimationLayout animationLayout = new AnimationLayout(this.vMh.getContext());
            AppMethodBeat.o(167404);
            return animationLayout;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/view/HardTouchableLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class r extends kotlin.g.b.q implements kotlin.g.a.a<HardTouchableLayout> {
        final /* synthetic */ FinderMediaPreviewUI vMh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(FinderMediaPreviewUI finderMediaPreviewUI) {
            super(0);
            this.vMh = finderMediaPreviewUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ HardTouchableLayout invoke() {
            AppMethodBeat.i(167419);
            HardTouchableLayout hardTouchableLayout = (HardTouchableLayout) this.vMh.findViewById(R.id.b3p);
            AppMethodBeat.o(167419);
            return hardTouchableLayout;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;", "kotlin.jvm.PlatformType", "invoke"})
    static final class q extends kotlin.g.b.q implements kotlin.g.a.a<FinderLongVideoPlayerSeekBar> {
        final /* synthetic */ FinderMediaPreviewUI vMh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(FinderMediaPreviewUI finderMediaPreviewUI) {
            super(0);
            this.vMh = finderMediaPreviewUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ FinderLongVideoPlayerSeekBar invoke() {
            AppMethodBeat.i(252527);
            FinderLongVideoPlayerSeekBar finderLongVideoPlayerSeekBar = (FinderLongVideoPlayerSeekBar) this.vMh.findViewById(R.id.j6f);
            AppMethodBeat.o(252527);
            return finderLongVideoPlayerSeekBar;
        }
    }

    public static final /* synthetic */ void a(FinderMediaPreviewUI finderMediaPreviewUI, boolean z) {
        AppMethodBeat.i(252535);
        RecyclerView.v ch = finderMediaPreviewUI.dzQ().getPagerView().ch(0);
        if (ch == null) {
            kotlin.g.b.p.hyc();
        }
        kotlin.g.b.p.g(ch, "mediaBanner.pagerView.fi…erForAdapterPosition(0)!!");
        FinderVideoLayout finderVideoLayout = (FinderVideoLayout) ch.aus.findViewById(R.id.ckd);
        if (finderVideoLayout == null) {
            AppMethodBeat.o(252535);
        } else if (z) {
            FinderVideoLayout.a(finderVideoLayout);
            AppMethodBeat.o(252535);
        } else {
            FinderVideoLayout.b(finderVideoLayout);
            AppMethodBeat.o(252535);
        }
    }

    public static final /* synthetic */ void c(FinderMediaPreviewUI finderMediaPreviewUI, int i2) {
        com.tencent.mm.plugin.finder.video.r videoView;
        AppMethodBeat.i(252536);
        RecyclerView.v ch = finderMediaPreviewUI.dzQ().getPagerView().ch(0);
        if (ch == null) {
            kotlin.g.b.p.hyc();
        }
        kotlin.g.b.p.g(ch, "mediaBanner.pagerView.fi…erForAdapterPosition(0)!!");
        FinderVideoLayout finderVideoLayout = (FinderVideoLayout) ch.aus.findViewById(R.id.ckd);
        if (finderVideoLayout == null || (videoView = finderVideoLayout.getVideoView()) == null) {
            AppMethodBeat.o(252536);
            return;
        }
        videoView.c((double) i2, true);
        AppMethodBeat.o(252536);
    }
}
