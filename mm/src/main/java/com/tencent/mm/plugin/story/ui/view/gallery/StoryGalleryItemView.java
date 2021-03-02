package com.tencent.mm.plugin.story.ui.view.gallery;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.f;
import com.tencent.mm.plugin.story.c.a.e;
import com.tencent.mm.plugin.story.f.d.j;
import com.tencent.mm.plugin.story.ui.view.StoryActionView;
import com.tencent.mm.plugin.story.ui.view.StoryCommentView;
import com.tencent.mm.plugin.story.ui.view.StoryMsgView;
import com.tencent.mm.plugin.vlog.ui.preview.VLogFakeVideoView;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.au;
import com.tencent.smtt.sdk.WebView;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010)J\u0006\u00109\u001a\u000207J\u0010\u0010:\u001a\u00020;2\b\u00108\u001a\u0004\u0018\u00010)J\b\u0010<\u001a\u000207H\u0002J\u0006\u0010=\u001a\u000207J\u0006\u0010>\u001a\u00020;J\u0006\u0010?\u001a\u000207J\b\u0010@\u001a\u000207H\u0014J\u0006\u0010A\u001a\u000207J\u0006\u0010B\u001a\u000207J\u0006\u0010C\u001a\u000207J\u0006\u0010D\u001a\u000207J\u0006\u0010E\u001a\u000207J\u0006\u0010F\u001a\u000207J\u0010\u0010G\u001a\u0002072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u000e\u0010H\u001a\u0002072\u0006\u0010I\u001a\u00020;J\u0010\u0010J\u001a\u0002072\b\u00104\u001a\u0004\u0018\u000105J\u0010\u0010K\u001a\u0002072\b\u00102\u001a\u0004\u0018\u000103JÈ\u0001\u0010L\u001a\u0002072K\u0010M\u001aG\u0012\u0013\u0012\u00110\u0007¢\u0006\f\bO\u0012\b\bP\u0012\u0004\b\b(Q\u0012\u0013\u0012\u00110\u0007¢\u0006\f\bO\u0012\b\bP\u0012\u0004\b\b(R\u0012\u0013\u0012\u00110;¢\u0006\f\bO\u0012\b\bP\u0012\u0004\b\b(S\u0012\u0004\u0012\u0002070N26\u0010T\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\bO\u0012\b\bP\u0012\u0004\b\b(R\u0012\u0013\u0012\u00110;¢\u0006\f\bO\u0012\b\bP\u0012\u0004\b\b(S\u0012\u0004\u0012\u0002070U2!\u0010V\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\bO\u0012\b\bP\u0012\u0004\b\b(Q\u0012\u0004\u0012\u0002070W2\u000e\u0010X\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010Y2\b\u0010Z\u001a\u0004\u0018\u00010\nJ\u0006\u0010[\u001a\u000207J\u0006\u0010\\\u001a\u000207J\u000e\u0010]\u001a\u0002072\u0006\u0010^\u001a\u00020;J\u0016\u0010_\u001a\u0002072\u0006\u0010`\u001a\u00020;2\u0006\u0010a\u001a\u00020bR\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020%¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u000e\u0010.\u001a\u00020/X\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u0002\n\u0000¨\u0006c"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryItemView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "commentView", "Lcom/tencent/mm/plugin/story/ui/view/StoryCommentView;", "getCommentView", "()Lcom/tencent/mm/plugin/story/ui/view/StoryCommentView;", "imageVideoViewMgr", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryImageVideoViewMgr;", "msgView", "Lcom/tencent/mm/plugin/story/ui/view/StoryMsgView;", "getMsgView", "()Lcom/tencent/mm/plugin/story/ui/view/StoryMsgView;", NativeProtocol.WEB_DIALOG_PARAMS, "Landroid/view/ViewGroup$LayoutParams;", "position", "getPosition", "()I", "setPosition", "(I)V", "postTipView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;", "getPostTipView", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;", "setPostTipView", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryPostTip;)V", "thumbView", "Landroid/widget/ImageView;", "getThumbView", "()Landroid/widget/ImageView;", "videoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "getVideoItem", "()Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "setVideoItem", "(Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;)V", "videoParams", "Landroid/widget/FrameLayout$LayoutParams;", "videoViewContainer", "Landroid/view/ViewGroup;", "videoViewMgr", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "vlogFakeVideoViewMgr", "Lcom/tencent/mm/plugin/vlog/ui/preview/VLogFakeVideoViewMgr;", "changeVideoItem", "", "item", "checkVisitEnable", "getPlayStatus", "", "initPostTipView", "onActiveItem", "onBackPressed", "onDestroy", "onDetachedFromWindow", "onPause", "onResume", "onUnactiveItem", "postVisit", "reBindBitmap", "resetLastView", "setImageVideoViewMgr", "setMute", "isMute", "setVLogFakeVideoViewMgr", "setVideoViewMgr", "setupCurView", "onMsgPanelStateCallback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "state", FirebaseAnalytics.b.INDEX, "isSelf", "onPageSelectedCallback", "Lkotlin/Function2;", "stateChangeCallback", "Lkotlin/Function1;", "outClickListener", "Lkotlin/Function0;", "sessionId", "switchImageMode", "switchVideoMode", "toggleActiveState", "newActive", "updateCommentId", "success", "storyId", "", "plugin-story_release"})
public final class StoryGalleryItemView extends RelativeLayout {
    ViewGroup FGa;
    final FrameLayout.LayoutParams FGb;
    n FGc;
    l FGd;
    com.tencent.mm.plugin.vlog.ui.preview.a FGe;
    j FoT;
    final StoryCommentView Fyg;
    final StoryMsgView Fyh;
    private StoryGalleryPostTip Fyi;
    final String TAG;
    int position;
    final ImageView tiQ;
    private final ViewGroup.LayoutParams zAM;

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "state", "", FirebaseAnalytics.b.INDEX, "isSelf", "", "invoke"})
    public static final class a extends q implements kotlin.g.a.q<Integer, Integer, Boolean, x> {
        final /* synthetic */ kotlin.g.a.q FGf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(kotlin.g.a.q qVar) {
            super(3);
            this.FGf = qVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.q
        public final /* synthetic */ x d(Integer num, Integer num2, Boolean bool) {
            AppMethodBeat.i(120398);
            this.FGf.d(Integer.valueOf(num.intValue()), Integer.valueOf(num2.intValue()), Boolean.valueOf(bool.booleanValue()));
            x xVar = x.SXb;
            AppMethodBeat.o(120398);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", FirebaseAnalytics.b.INDEX, "", "isSelf", "", "invoke"})
    public static final class b extends q implements m<Integer, Boolean, x> {
        final /* synthetic */ m FGg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(m mVar) {
            super(2);
            this.FGg = mVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(Integer num, Boolean bool) {
            AppMethodBeat.i(120399);
            this.FGg.invoke(Integer.valueOf(num.intValue()), Boolean.valueOf(bool.booleanValue()));
            x xVar = x.SXb;
            AppMethodBeat.o(120399);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class c extends q implements kotlin.g.a.b<Integer, x> {
        final /* synthetic */ kotlin.g.a.b FGh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(kotlin.g.a.b bVar) {
            super(1);
            this.FGh = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Integer num) {
            AppMethodBeat.i(120400);
            this.FGh.invoke(Integer.valueOf(num.intValue()));
            x xVar = x.SXb;
            AppMethodBeat.o(120400);
            return xVar;
        }
    }

    public /* synthetic */ StoryGalleryItemView(Context context) {
        this(context, null, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StoryGalleryItemView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(120412);
        this.TAG = "MircoMsg.StoryGalleryItemView";
        this.zAM = new ViewGroup.LayoutParams(-1, -1);
        this.FGb = new FrameLayout.LayoutParams(-1, -1);
        setBackgroundColor(WebView.NIGHT_MODE_COLOR);
        this.FGa = new FrameLayout(context);
        this.tiQ = new ImageView(context);
        this.tiQ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.tiQ, this.zAM);
        addView(this.FGa, this.zAM);
        this.Fyg = new StoryCommentView(context);
        addView(this.Fyg, this.zAM);
        this.Fyh = new StoryMsgView(context);
        addView(this.Fyh, this.zAM);
        Context context2 = getContext();
        p.g(context2, "context");
        this.Fyi = new StoryGalleryPostTip(context2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, au.eu(getContext()) + au.ay(getContext()));
        layoutParams.addRule(10);
        addView(this.Fyi, layoutParams);
        if (e.Fln.fng()) {
            this.Fyh.setVisibility(0);
            this.Fyg.setVisibility(8);
            AppMethodBeat.o(120412);
            return;
        }
        this.Fyh.setVisibility(8);
        this.Fyg.setVisibility(0);
        AppMethodBeat.o(120412);
    }

    public final String getTAG() {
        return this.TAG;
    }

    public final ImageView getThumbView() {
        return this.tiQ;
    }

    public final StoryCommentView getCommentView() {
        return this.Fyg;
    }

    public final StoryMsgView getMsgView() {
        return this.Fyh;
    }

    public final int getPosition() {
        return this.position;
    }

    public final void setPosition(int i2) {
        this.position = i2;
    }

    public final j getVideoItem() {
        return this.FoT;
    }

    public final void setVideoItem(j jVar) {
        this.FoT = jVar;
    }

    public final StoryGalleryPostTip getPostTipView() {
        return this.Fyi;
    }

    public final void setPostTipView(StoryGalleryPostTip storyGalleryPostTip) {
        this.Fyi = storyGalleryPostTip;
    }

    public final void setVideoViewMgr(n nVar) {
        this.FGc = nVar;
    }

    public final void setImageVideoViewMgr(l lVar) {
        this.FGd = lVar;
    }

    public final void setVLogFakeVideoViewMgr(com.tencent.mm.plugin.vlog.ui.preview.a aVar) {
        this.FGe = aVar;
    }

    public final boolean e(j jVar) {
        StoryVideoView storyVideoView;
        VLogFakeVideoView vLogFakeVideoView;
        f fVar;
        AppMethodBeat.i(120401);
        if (jVar == null) {
            AppMethodBeat.o(120401);
        } else if (jVar.foX()) {
            l lVar = this.FGd;
            if (lVar != null) {
                p.h(jVar, "item");
                if (!(lVar.FHf == null || (fVar = lVar.FHf) == null)) {
                    fVar.isPlaying();
                }
            }
            AppMethodBeat.o(120401);
        } else if (jVar.foY()) {
            com.tencent.mm.plugin.vlog.ui.preview.a aVar = this.FGe;
            if (!(aVar == null || aVar.GOk == null || (vLogFakeVideoView = aVar.GOk) == null)) {
                vLogFakeVideoView.isPlaying();
            }
            AppMethodBeat.o(120401);
        } else {
            n nVar = this.FGc;
            if (nVar != null) {
                p.h(jVar, "item");
                if (!(nVar.FIc == null || (storyVideoView = nVar.FIc) == null)) {
                    storyVideoView.isPlaying();
                }
            }
            AppMethodBeat.o(120401);
        }
        return false;
    }

    public final void setMute(boolean z) {
        AppMethodBeat.i(120402);
        n nVar = this.FGc;
        if (nVar != null) {
            nVar.setMute(z);
        }
        l lVar = this.FGd;
        if (lVar != null) {
            p.g("", "if(BuildConfig.DEBUG) Ut…tack().toString() else \"\"");
            Log.i(lVar.TAG, "setMute " + z + " ret " + "");
            lVar.guh = z;
        }
        com.tencent.mm.plugin.vlog.ui.preview.a aVar = this.FGe;
        if (aVar != null) {
            p.g("", "if(BuildConfig.DEBUG) Ut…tack().toString() else \"\"");
            aVar.guh = z;
            Log.i("MicroMsg.VLogFakeVideoViewMgr", "setMute " + z + " ret " + "");
            AppMethodBeat.o(120402);
            return;
        }
        AppMethodBeat.o(120402);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00fe  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void fso() {
        /*
        // Method dump skipped, instructions count: 289
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.story.ui.view.gallery.StoryGalleryItemView.fso():void");
    }

    public final void onResume() {
        AppMethodBeat.i(120404);
        if (!e.Fln.fng()) {
            StoryCommentView storyCommentView = this.Fyg;
            Log.i(StoryCommentView.TAG, "LogStory: resume");
            if (storyCommentView.contentView.getVisibility() == 0 && storyCommentView.iFU == 2 && storyCommentView.FCc.dLD) {
                storyCommentView.FCc.resume();
            }
        }
        AppMethodBeat.o(120404);
    }

    public final void onPause() {
        AppMethodBeat.i(120405);
        if (!e.Fln.fng()) {
            StoryCommentView storyCommentView = this.Fyg;
            Log.i(StoryCommentView.TAG, "LogStory: pause");
            storyCommentView.FCc.pause();
        }
        AppMethodBeat.o(120405);
    }

    public final void onDestroy() {
        AppMethodBeat.i(120406);
        if (!e.Fln.fng()) {
            StoryCommentView storyCommentView = this.Fyg;
            storyCommentView.FCc.pause();
            storyCommentView.FCy.clear();
            storyCommentView.FCr.clear();
            com.tencent.mm.plugin.story.ui.view.c cVar = storyCommentView.FCn;
            if (cVar != null) {
                cVar.dismiss();
                AppMethodBeat.o(120406);
                return;
            }
        }
        AppMethodBeat.o(120406);
    }

    public final boolean onBackPressed() {
        AppMethodBeat.i(120407);
        if (e.Fln.fng()) {
            StoryMsgView storyMsgView = this.Fyh;
            if (storyMsgView.FDA.getVisibility() == 0) {
                if (storyMsgView.FDF.getInputType() != -1) {
                    storyMsgView.FDF.fse();
                } else if (storyMsgView.FDF.getVisibility() != 0) {
                    storyMsgView.animateClose();
                } else if (storyMsgView.dJM) {
                    storyMsgView.FDF.setVisibility(8);
                } else {
                    storyMsgView.animateClose();
                }
                AppMethodBeat.o(120407);
                return true;
            }
            AppMethodBeat.o(120407);
            return false;
        }
        StoryCommentView storyCommentView = this.Fyg;
        if (storyCommentView.iFU == 1) {
            storyCommentView.xN(2);
            AppMethodBeat.o(120407);
            return true;
        } else if (storyCommentView.iFU == 3) {
            storyCommentView.xN(2);
            AppMethodBeat.o(120407);
            return true;
        } else if (storyCommentView.iFU == 5) {
            storyCommentView.xN(2);
            AppMethodBeat.o(120407);
            return true;
        } else {
            AppMethodBeat.o(120407);
            return false;
        }
    }

    public final void fsi() {
        AppMethodBeat.i(120408);
        if (e.Fln.fng()) {
            this.Fyh.fsi();
        }
        AppMethodBeat.o(120408);
    }

    public final void fsp() {
        AppMethodBeat.i(120409);
        if (e.Fln.fng()) {
            this.Fyh.setVisibility(0);
            this.Fyg.setVisibility(8);
            AppMethodBeat.o(120409);
            return;
        }
        this.Fyh.setVisibility(8);
        this.Fyg.setVisibility(0);
        AppMethodBeat.o(120409);
    }

    public final void wa(boolean z) {
        int i2;
        AppMethodBeat.i(120410);
        if (e.Fln.fng()) {
            StoryActionView storyActionView = this.Fyh.FDC;
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            storyActionView.setVisibility(i2);
            AppMethodBeat.o(120410);
            return;
        }
        StoryCommentView storyCommentView = this.Fyg;
        Log.i(StoryCommentView.TAG, "toggleActiveState ".concat(String.valueOf(z)));
        if (z) {
            storyCommentView.show();
            AppMethodBeat.o(120410);
            return;
        }
        storyCommentView.hide();
        AppMethodBeat.o(120410);
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        AppMethodBeat.i(120411);
        Log.d(this.TAG, "onDetachedFromWindow");
        super.onDetachedFromWindow();
        this.FGc = null;
        this.FGd = null;
        this.FGe = null;
        AppMethodBeat.o(120411);
    }
}
