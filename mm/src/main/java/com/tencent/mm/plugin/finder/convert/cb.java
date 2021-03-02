package com.tencent.mm.plugin.finder.convert;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.plugin.finder.view.FinderPostProgressView;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.sns.ui.view.ImageIndicatorView;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010l\u001a\u00020m2\u0006\u0010n\u001a\u00020oH\u0002J<\u0010p\u001a\u00020m2\u0006\u0010n\u001a\u00020o2\u0006\u0010q\u001a\u00020r2\u0006\u0010s\u001a\u00020t2\b\b\u0002\u0010u\u001a\u00020t2\u0012\u0010v\u001a\u000e\u0012\u0004\u0012\u00020r\u0012\u0004\u0012\u00020m0wJ\u0010\u0010x\u001a\u00020t2\u0006\u0010n\u001a\u00020oH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0004R\u001a\u0010\u0011\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0004R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001c\u0010\u0004R\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\n\"\u0004\b%\u0010\fR\u001a\u0010&\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u000f\"\u0004\b(\u0010\u0004R\u001a\u0010)\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0017\"\u0004\b+\u0010\u0019R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010 \"\u0004\b4\u0010\"R\u001c\u00105\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0017\"\u0004\b7\u0010\u0019R\u001a\u00108\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0017\"\u0004\b:\u0010\u0019R\u001a\u0010;\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u000f\"\u0004\b=\u0010\u0004R\u001c\u0010>\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\n\"\u0004\b@\u0010\fR\u001c\u0010A\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u000f\"\u0004\bC\u0010\u0004R\u001a\u0010D\u001a\u00020EX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001c\u0010J\u001a\u0004\u0018\u00010KX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001a\u0010P\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u000f\"\u0004\bR\u0010\u0004R\u001e\u0010S\u001a\u0004\u0018\u00010TX\u000e¢\u0006\u0010\n\u0002\u0010Y\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001a\u0010Z\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\n\"\u0004\b\\\u0010\fR#\u0010]\u001a\n _*\u0004\u0018\u00010^0^8BX\u0002¢\u0006\f\n\u0004\bb\u0010c\u001a\u0004\b`\u0010aR\u001a\u0010d\u001a\u00020eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u0010\u0010j\u001a\u0004\u0018\u00010kX\u000e¢\u0006\u0002\n\u0000¨\u0006y"}, hxF = {"Lcom/tencent/mm/plugin/finder/convert/FinderProfileUIMediaViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "TAG", "", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "setAvatarIv", "(Landroid/widget/ImageView;)V", "avatarLayout", "getAvatarLayout", "()Landroid/view/View;", "setAvatarLayout", "deletedTip", "getDeletedTip", "setDeletedTip", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "failedArea", "getFailedArea", "setFailedArea", "feedOnliveLayout", "Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "getFeedOnliveLayout", "()Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "setFeedOnliveLayout", "(Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;)V", "imageView", "getImageView", "setImageView", "likeArea", "getLikeArea", "setLikeArea", "likeCountTv", "getLikeCountTv", "setLikeCountTv", "likeIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getLikeIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setLikeIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "liveFinishView", "getLiveFinishView", "setLiveFinishView", "mask", "getMask", "setMask", "nicknameTv", "getNicknameTv", "setNicknameTv", "paddingArea", "getPaddingArea", "setPaddingArea", "privateIv", "getPrivateIv", "setPrivateIv", "privateLayout", "getPrivateLayout", "setPrivateLayout", "progress", "Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;", "getProgress", "()Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;", "setProgress", "(Lcom/tencent/mm/plugin/finder/view/FinderPostProgressView;)V", "progressAnimator", "Landroid/animation/ValueAnimator;", "getProgressAnimator", "()Landroid/animation/ValueAnimator;", "setProgressAnimator", "(Landroid/animation/ValueAnimator;)V", "progressArea", "getProgressArea", "setProgressArea", "readFeedId", "", "getReadFeedId", "()Ljava/lang/Long;", "setReadFeedId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "reprintIv", "getReprintIv", "setReprintIv", "screenPoint", "Landroid/graphics/Point;", "kotlin.jvm.PlatformType", "getScreenPoint", "()Landroid/graphics/Point;", "screenPoint$delegate", "Lkotlin/Lazy;", "tagImageView", "Lcom/tencent/mm/plugin/sns/ui/view/ImageIndicatorView;", "getTagImageView", "()Lcom/tencent/mm/plugin/sns/ui/view/ImageIndicatorView;", "setTagImageView", "(Lcom/tencent/mm/plugin/sns/ui/view/ImageIndicatorView;)V", "tipDialog", "Landroid/app/Dialog;", "bindLive", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "bindMedia", "dataPos", "", "bindImage", "", "fromSearch", "itemClickListener", "Lkotlin/Function1;", "isSelf", "plugin-finder_release"})
public final class cb extends RecyclerView.v {
    public final String TAG = "Finder.FinderProfileUIMediaViewHolder";
    public ImageView dKU;
    public ImageView gyr;
    public TextView hOf;
    public TextView hPW;
    public ValueAnimator luz;
    public TextView pIN;
    public Long readFeedId;
    public View tFA;
    public FinderPostProgressView tFB;
    public View tFC;
    public View tFD;
    public View tFE;
    public TextView tFF;
    public View tFG;
    public ImageView tFH;
    private final f tFJ = g.ah(d.tGd);
    public View tFX;
    public WeImageView tFv;
    public ImageIndicatorView tFw;
    public FinderLiveOnliveWidget tFx;
    public FinderLiveOnliveWidget tFy;
    public ImageView tFz;
    public View thM;

    public final Point cZM() {
        AppMethodBeat.i(243267);
        Point point = (Point) this.tFJ.getValue();
        AppMethodBeat.o(243267);
        return point;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public cb(View view) {
        super(view);
        p.h(view, "itemView");
        AppMethodBeat.i(165497);
        View findViewById = view.findViewById(R.id.d2l);
        p.g(findViewById, "itemView.findViewById(R.…inder_profile_item_image)");
        this.dKU = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.dvx);
        p.g(findViewById2, "itemView.findViewById(R.id.image_indicator)");
        this.tFw = (ImageIndicatorView) findViewById2;
        View findViewById3 = view.findViewById(R.id.cw_);
        p.g(findViewById3, "itemView.findViewById(R.…inder_live_onlive_widget)");
        this.tFx = (FinderLiveOnliveWidget) findViewById3;
        View findViewById4 = view.findViewById(R.id.cud);
        p.g(findViewById4, "itemView.findViewById<Fi…id.finder_live_mask_view)");
        this.tFy = (FinderLiveOnliveWidget) findViewById4;
        this.tFv = (WeImageView) view.findViewById(R.id.gj8);
        View findViewById5 = view.findViewById(R.id.gj5);
        p.g(findViewById5, "itemView.findViewById(R.id.profile_item_desc_tv)");
        this.hPW = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.gkx);
        p.g(findViewById6, "itemView.findViewById(R.….profile_upload_progress)");
        this.tFB = (FinderPostProgressView) findViewById6;
        View findViewById7 = view.findViewById(R.id.gkw);
        p.g(findViewById7, "itemView.findViewById(R.id.profile_upload_area)");
        this.thM = findViewById7;
        View findViewById8 = view.findViewById(R.id.gj6);
        p.g(findViewById8, "itemView.findViewById(R.…profile_item_failed_area)");
        this.tFC = findViewById8;
        View findViewById9 = view.findViewById(R.id.gj_);
        p.g(findViewById9, "itemView.findViewById(R.id.profile_like_area)");
        this.tFD = findViewById9;
        View findViewById10 = view.findViewById(R.id.gjc);
        p.g(findViewById10, "itemView.findViewById(R.id.profile_like_count_tv)");
        this.hOf = (TextView) findViewById10;
        View findViewById11 = view.findViewById(R.id.d2n);
        p.g(findViewById11, "itemView.findViewById(R.…_profile_item_reprint_iv)");
        this.tFz = (ImageView) findViewById11;
        View findViewById12 = view.findViewById(R.id.gy_);
        p.g(findViewById12, "itemView.findViewById(R.id.ref_deleted_tips)");
        this.tFA = findViewById12;
        View findViewById13 = view.findViewById(R.id.g8b);
        p.g(findViewById13, "itemView.findViewById(R.id.padding_view)");
        this.tFE = findViewById13;
        this.tFv = (WeImageView) view.findViewById(R.id.gj8);
        View findViewById14 = view.findViewById(R.id.x4);
        p.g(findViewById14, "itemView.findViewById(R.id.avatar_layout)");
        this.tFX = findViewById14;
        View findViewById15 = view.findViewById(R.id.x1);
        p.g(findViewById15, "itemView.findViewById(R.id.avatar_iv)");
        this.gyr = (ImageView) findViewById15;
        View findViewById16 = view.findViewById(R.id.fzg);
        p.g(findViewById16, "itemView.findViewById(R.id.nickname_tv)");
        this.pIN = (TextView) findViewById16;
        this.tFG = view.findViewById(R.id.ghd);
        this.tFH = (ImageView) view.findViewById(R.id.gj1);
        this.tFF = (TextView) view.findViewById(R.id.d2m);
        AppMethodBeat.o(165497);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/convert/FinderProfileUIMediaViewHolder$bindMedia$2$1"})
    public static final class a implements View.OnClickListener {
        final /* synthetic */ z.f tFY;
        final /* synthetic */ BaseFinderFeed tFZ;
        final /* synthetic */ cb tGa;

        public a(z.f fVar, BaseFinderFeed baseFinderFeed, cb cbVar) {
            this.tFY = fVar;
            this.tFZ = baseFinderFeed;
            this.tGa = cbVar;
        }

        public final void onClick(View view) {
            String str;
            AppMethodBeat.i(178136);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderProfileUIMediaViewHolder$bindMedia$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent();
            T t = this.tFY.SYG;
            intent.putExtra("finder_username", t != null ? t.username : null);
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            View view2 = this.tGa.aus;
            p.g(view2, "itemView");
            Context context = view2.getContext();
            p.g(context, "itemView.context");
            FinderReporterUIC.a.a(context, intent, this.tFZ.lT(), 6, false, 64);
            com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
            View view3 = this.tGa.aus;
            p.g(view3, "itemView");
            Context context2 = view3.getContext();
            p.g(context2, "itemView.context");
            com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(context2, intent);
            k kVar = k.vfA;
            long lT = this.tFZ.lT();
            T t2 = this.tFY.SYG;
            if (t2 != null) {
                str = t2.username;
            } else {
                str = null;
            }
            k.a(4, lT, 6, 1, str);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderProfileUIMediaViewHolder$bindMedia$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(178136);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class b implements View.OnClickListener {
        final /* synthetic */ kotlin.g.a.b tGb;
        final /* synthetic */ int tGc;

        public b(kotlin.g.a.b bVar, int i2) {
            this.tGb = bVar;
            this.tGc = i2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(243263);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderProfileUIMediaViewHolder$bindMedia$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.tGb.invoke(Integer.valueOf(this.tGc));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderProfileUIMediaViewHolder$bindMedia$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(243263);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ cb tGa;

        public c(cb cbVar) {
            this.tGa = cbVar;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(243264);
            FinderPostProgressView finderPostProgressView = this.tGa.tFB;
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(243264);
                throw tVar;
            }
            finderPostProgressView.setProgress(((Integer) animatedValue).intValue());
            this.tGa.tFB.invalidate();
            AppMethodBeat.o(243264);
        }
    }

    public final boolean h(BaseFinderFeed baseFinderFeed) {
        String str;
        AppMethodBeat.i(243268);
        com.tencent.mm.plugin.finder.api.g gVar = baseFinderFeed.contact;
        if (gVar != null) {
            str = gVar.field_username;
        } else {
            str = null;
        }
        if (n.I(str, com.tencent.mm.model.z.aUg(), false)) {
            Object tag = this.aus.getTag(R.id.gis);
            if (!(tag instanceof Boolean)) {
                tag = null;
            }
            if (p.j((Boolean) tag, Boolean.TRUE)) {
                AppMethodBeat.o(243268);
                return true;
            }
        }
        AppMethodBeat.o(243268);
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/graphics/Point;", "kotlin.jvm.PlatformType", "invoke"})
    static final class d extends q implements kotlin.g.a.a<Point> {
        public static final d tGd = new d();

        static {
            AppMethodBeat.i(243266);
            AppMethodBeat.o(243266);
        }

        d() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Point invoke() {
            AppMethodBeat.i(243265);
            Point az = au.az(MMApplicationContext.getContext());
            AppMethodBeat.o(243265);
            return az;
        }
    }
}
