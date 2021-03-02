package com.tencent.mm.plugin.finder.convert;

import android.animation.ValueAnimator;
import android.graphics.Point;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.plugin.finder.view.FinderPostProgressView;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010a\u001a\u00020b2\u0006\u0010c\u001a\u00020\u0002H\u0002J\b\u0010d\u001a\u00020eH\u0016J\u000e\u0010f\u001a\u00020b2\u0006\u0010g\u001a\u00020\u0005J\u0010\u0010h\u001a\u00020 2\u0006\u0010c\u001a\u00020\u0002H\u0002J@\u0010i\u001a\u00020b2\u0006\u0010j\u001a\u00020k2\u0006\u0010l\u001a\u00020\u00022\u0006\u0010m\u001a\u00020e2\u0006\u0010n\u001a\u00020e2\u0006\u0010o\u001a\u00020 2\u000e\u0010p\u001a\n\u0012\u0004\u0012\u00020r\u0018\u00010qH\u0016J \u0010s\u001a\u00020b2\u0006\u0010t\u001a\u00020u2\u0006\u0010j\u001a\u00020k2\u0006\u0010n\u001a\u00020eH\u0016J\u0010\u0010v\u001a\u00020b2\u0006\u0010l\u001a\u00020\u0002H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b\u001f\u0010!\"\u0004\b\"\u0010#R\u001a\u0010%\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\tR\u001a\u0010(\u001a\u00020\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\r\"\u0004\b*\u0010\u000fR\u001c\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0016\"\u0004\b3\u0010\u0018R\u001c\u00104\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\r\"\u0004\b6\u0010\u000fR\u001a\u00107\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0007\"\u0004\b9\u0010\tR\u001c\u0010:\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001c\"\u0004\b<\u0010\u001eR\u001c\u0010=\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0007\"\u0004\b?\u0010\tR\u001a\u0010@\u001a\u00020AX.¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001c\u0010F\u001a\u0004\u0018\u00010GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001a\u0010L\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0007\"\u0004\bN\u0010\tR\u001a\u0010O\u001a\u00020\u001aX.¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u001c\"\u0004\bQ\u0010\u001eR#\u0010R\u001a\n T*\u0004\u0018\u00010S0S8BX\u0002¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bU\u0010VR\u001a\u0010Y\u001a\u00020ZX.¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\u0010\u0010_\u001a\u0004\u0018\u00010`X\u000e¢\u0006\u0002\n\u0000¨\u0006w"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderProfileFeedConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "()V", "deletedTip", "Landroid/view/View;", "getDeletedTip", "()Landroid/view/View;", "setDeletedTip", "(Landroid/view/View;)V", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "failedArea", "getFailedArea", "setFailedArea", "feedOnliveLayout", "Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "getFeedOnliveLayout", "()Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "setFeedOnliveLayout", "(Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;)V", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "setImageView", "(Landroid/widget/ImageView;)V", "isSelfFlag", "", "()Ljava/lang/Boolean;", "setSelfFlag", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "likeArea", "getLikeArea", "setLikeArea", "likeCountTv", "getLikeCountTv", "setLikeCountTv", "likeIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getLikeIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setLikeIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "liveFinishView", "getLiveFinishView", "setLiveFinishView", "mask", "getMask", "setMask", "paddingArea", "getPaddingArea", "setPaddingArea", "privateIv", "getPrivateIv", "setPrivateIv", "privateLayout", "getPrivateLayout", "setPrivateLayout", "progress", "Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;", "getProgress", "()Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;", "setProgress", "(Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;)V", "progressAnimator", "Landroid/animation/ValueAnimator;", "getProgressAnimator", "()Landroid/animation/ValueAnimator;", "setProgressAnimator", "(Landroid/animation/ValueAnimator;)V", "progressArea", "getProgressArea", "setProgressArea", "reprintIv", "getReprintIv", "setReprintIv", "screenPoint", "Landroid/graphics/Point;", "kotlin.jvm.PlatformType", "getScreenPoint", "()Landroid/graphics/Point;", "screenPoint$delegate", "Lkotlin/Lazy;", "tagImageView", "Lcom/tencent/mm/plugin/sns/ui/view/ImageIndicatorView;", "getTagImageView", "()Lcom/tencent/mm/plugin/sns/ui/view/ImageIndicatorView;", "setTagImageView", "(Lcom/tencent/mm/plugin/sns/ui/view/ImageIndicatorView;)V", "tipDialog", "Landroid/app/Dialog;", "bindLive", "", "feed", "getLayoutId", "", "initViews", "itemView", "isSelf", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "refreshMask", "plugin-finder_release"})
public final class by extends e<BaseFinderFeed> {
    public ImageView dKU;
    public TextView hOf;
    public TextView hPW;
    private ValueAnimator luz;
    public View tFA;
    public FinderPostProgressView tFB;
    public View tFC;
    public View tFD;
    public View tFE;
    private TextView tFF;
    private View tFG;
    private ImageView tFH;
    public Boolean tFI;
    private final f tFJ = g.ah(b.tFL);
    private WeImageView tFv;
    public ImageIndicatorView tFw;
    public FinderLiveOnliveWidget tFx;
    public FinderLiveOnliveWidget tFy;
    public ImageView tFz;
    public View thM;

    private final Point cZM() {
        AppMethodBeat.i(243239);
        Point point = (Point) this.tFJ.getValue();
        AppMethodBeat.o(243239);
        return point;
    }

    public by() {
        AppMethodBeat.i(243244);
        AppMethodBeat.o(243244);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0533, code lost:
        if (r0.getVisibility() != 8) goto L_0x0535;
     */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x0552  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x05a2  */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x0635  */
    /* JADX WARNING: Removed duplicated region for block: B:236:0x064e  */
    /* JADX WARNING: Removed duplicated region for block: B:397:0x0a19  */
    /* JADX WARNING: Removed duplicated region for block: B:435:0x0aa9  */
    /* JADX WARNING: Removed duplicated region for block: B:436:0x0aac  */
    @Override // com.tencent.mm.view.recyclerview.e
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void a(com.tencent.mm.view.recyclerview.h r9, com.tencent.mm.plugin.finder.model.BaseFinderFeed r10, int r11, int r12, boolean r13, java.util.List r14) {
        /*
        // Method dump skipped, instructions count: 2735
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.convert.by.a(com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List):void");
    }

    public final FinderPostProgressView cZL() {
        AppMethodBeat.i(243238);
        FinderPostProgressView finderPostProgressView = this.tFB;
        if (finderPostProgressView == null) {
            p.btv("progress");
        }
        AppMethodBeat.o(243238);
        return finderPostProgressView;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.aiu;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, h hVar, int i2) {
        AppMethodBeat.i(243240);
        p.h(recyclerView, "recyclerView");
        p.h(hVar, "holder");
        AppMethodBeat.o(243240);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    static final class a implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ by tFK;

        a(by byVar) {
            this.tFK = byVar;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(243235);
            FinderPostProgressView cZL = this.tFK.cZL();
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(243235);
                throw tVar;
            }
            cZL.setProgress(((Integer) animatedValue).intValue());
            this.tFK.cZL().invalidate();
            AppMethodBeat.o(243235);
        }
    }

    private final void g(BaseFinderFeed baseFinderFeed) {
        AppMethodBeat.i(243242);
        TextView textView = this.tFF;
        if (textView != null) {
            textView.setBackgroundColor(R.color.BW_0_Alpha_0_5);
            textView.setVisibility(baseFinderFeed.markRead ? 0 : 8);
            AppMethodBeat.o(243242);
            return;
        }
        AppMethodBeat.o(243242);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/graphics/Point;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b extends q implements kotlin.g.a.a<Point> {
        public static final b tFL = new b();

        static {
            AppMethodBeat.i(243237);
            AppMethodBeat.o(243237);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Point invoke() {
            AppMethodBeat.i(243236);
            Point az = au.az(MMApplicationContext.getContext());
            AppMethodBeat.o(243236);
            return az;
        }
    }

    private final boolean h(BaseFinderFeed baseFinderFeed) {
        String str;
        AppMethodBeat.i(243243);
        com.tencent.mm.plugin.finder.api.g gVar = baseFinderFeed.contact;
        if (gVar != null) {
            str = gVar.field_username;
        } else {
            str = null;
        }
        if (!n.I(str, z.aUg(), false) || !p.j(this.tFI, Boolean.TRUE)) {
            AppMethodBeat.o(243243);
            return false;
        }
        AppMethodBeat.o(243243);
        return true;
    }
}
