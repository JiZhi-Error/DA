package com.tencent.mm.plugin.textstatus.ui;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.plugin.textstatus.a.m;
import com.tencent.mm.plugin.textstatus.b.c.c;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.g.x;
import com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.ah;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u00011\u0018\u0000 O2\u00020\u00012\u00020\u0002:\u0001OB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010=\u001a\u00020>H\u0002J\b\u0010?\u001a\u00020@H\u0002J\u0010\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020CH\u0002J\u0018\u0010D\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rH\u0002J\b\u0010E\u001a\u00020@H\u0014J\b\u0010F\u001a\u00020@H\u0016J,\u0010G\u001a\u00020@2\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020I2\b\u0010K\u001a\u0004\u0018\u00010L2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010\u0005R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0010\u00100\u001a\u000201X\u0004¢\u0006\u0004\n\u0002\u00102R\u001c\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u000e\u00109\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010:\u001a\u00020\u0015X.¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0017\"\u0004\b<\u0010\u0019¨\u0006P"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog;", "Lcom/tencent/mm/plugin/textstatus/ui/MMImmerseDialog;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cardEventListener", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView$StatusEventListener;", "cardItemClickListener", "Landroid/view/View$OnClickListener;", "dataSet", "Ljava/util/ArrayList;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lkotlin/collections/ArrayList;", "ivBackImg", "Landroid/widget/ImageView;", "getIvBackImg", "()Landroid/widget/ImageView;", "setIvBackImg", "(Landroid/widget/ImageView;)V", "layoutBottomArrow", "Landroid/view/View;", "getLayoutBottomArrow", "()Landroid/view/View;", "setLayoutBottomArrow", "(Landroid/view/View;)V", "layoutMaxLinear", "Lcom/tencent/mm/plugin/textstatus/ui/MaxHeightLinearLayout;", "getLayoutMaxLinear", "()Lcom/tencent/mm/plugin/textstatus/ui/MaxHeightLinearLayout;", "setLayoutMaxLinear", "(Lcom/tencent/mm/plugin/textstatus/ui/MaxHeightLinearLayout;)V", "layoutWrap", "Landroid/widget/RelativeLayout;", "getLayoutWrap", "()Landroid/widget/RelativeLayout;", "setLayoutWrap", "(Landroid/widget/RelativeLayout;)V", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getMProgressDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setMProgressDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "planetItemClickListener", "com/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog$planetItemClickListener$1", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog$planetItemClickListener$1;", "rvFriendsStatus", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRvFriendsStatus", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRvFriendsStatus", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "setStatusClickListener", "vBackMask", "getVBackMask", "setVBackMask", "buildItemConverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "enterAnim", "", "exitAnim", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/animation/Animator$AnimatorListener;", "initList", "initUI", "onBackPressed", "onSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Companion", "plugin-textstatus_release"})
public final class j extends c implements com.tencent.mm.ak.i {
    public static final a Gfs = new a((byte) 0);
    WxRecyclerView Gfh;
    public ImageView Gfi;
    public MaxHeightLinearLayout Gfj;
    public View Gfk;
    public View Gfl;
    public RelativeLayout Gfm;
    private final View.OnClickListener Gfn;
    private final View.OnClickListener Gfo = new d(this);
    private final f.a Gfp = new c(this);
    private final k Gfq = new k(this);
    private final ArrayList<com.tencent.mm.view.recyclerview.a> Gfr = new ArrayList<>();
    private q gxX;
    Context mContext;

    static {
        AppMethodBeat.i(216619);
        AppMethodBeat.o(216619);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(216618);
        this.mContext = context;
        this.Gfn = new l(context);
        AppMethodBeat.o(216618);
    }

    public static final /* synthetic */ void a(j jVar) {
        AppMethodBeat.i(216620);
        super.onBackPressed();
        AppMethodBeat.o(216620);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final RelativeLayout fwC() {
        AppMethodBeat.i(216613);
        RelativeLayout relativeLayout = this.Gfm;
        if (relativeLayout == null) {
            p.btv("layoutWrap");
        }
        AppMethodBeat.o(216613);
        return relativeLayout;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.textstatus.ui.c
    public final void initUI() {
        ViewPropertyAnimator alpha;
        AppMethodBeat.i(216614);
        super.initUI();
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.c2r, (ViewGroup) null, false);
        p.g(inflate, "LayoutInflater.from(cont…s_planet_ui, null, false)");
        p.h(inflate, "customView");
        LinearLayout linearLayout = this.GcD;
        if (linearLayout != null) {
            linearLayout.addView(inflate, -1, -2);
        }
        View findViewById = inflate.findViewById(R.id.e48);
        p.g(findViewById, "contentView.findViewById(R.id.iv_back_img)");
        this.Gfi = (ImageView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.e9y);
        p.g(findViewById2, "contentView.findViewById…layout_max_height_linear)");
        this.Gfj = (MaxHeightLinearLayout) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.e9p);
        p.g(findViewById3, "contentView.findViewById(R.id.layout_bottom_arrow)");
        this.Gfk = findViewById3;
        View findViewById4 = inflate.findViewById(R.id.j24);
        p.g(findViewById4, "contentView.findViewById(R.id.v_back_mask)");
        this.Gfl = findViewById4;
        View findViewById5 = inflate.findViewById(R.id.e_b);
        p.g(findViewById5, "contentView.findViewById(R.id.layout_wrap)");
        this.Gfm = (RelativeLayout) findViewById5;
        double d2 = ((double) ah.jS(getContext()).height) * 0.75d;
        View view = this.Gfk;
        if (view == null) {
            p.btv("layoutBottomArrow");
        }
        view.measure(0, 0);
        View view2 = this.Gfk;
        if (view2 == null) {
            p.btv("layoutBottomArrow");
        }
        int measuredHeight = view2.getMeasuredHeight();
        View view3 = this.Gfk;
        if (view3 == null) {
            p.btv("layoutBottomArrow");
        }
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(216614);
            throw tVar;
        }
        int i2 = measuredHeight + ((RelativeLayout.LayoutParams) layoutParams).bottomMargin;
        View view4 = this.Gfk;
        if (view4 == null) {
            p.btv("layoutBottomArrow");
        }
        ViewGroup.LayoutParams layoutParams2 = view4.getLayoutParams();
        if (layoutParams2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(216614);
            throw tVar2;
        }
        double d3 = d2 - ((double) (((RelativeLayout.LayoutParams) layoutParams2).topMargin + i2));
        MaxHeightLinearLayout maxHeightLinearLayout = this.Gfj;
        if (maxHeightLinearLayout == null) {
            p.btv("layoutMaxLinear");
        }
        maxHeightLinearLayout.setMaxHeightPx((int) d3);
        ImageView imageView = this.Gfi;
        if (imageView == null) {
            p.btv("ivBackImg");
        }
        ViewGroup.LayoutParams layoutParams3 = imageView.getLayoutParams();
        if (layoutParams3 == null) {
            t tVar3 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(216614);
            throw tVar3;
        }
        ((RelativeLayout.LayoutParams) layoutParams3).height = (int) d2;
        RelativeLayout relativeLayout = this.Gfm;
        if (relativeLayout == null) {
            p.btv("layoutWrap");
        }
        ViewGroup.LayoutParams layoutParams4 = relativeLayout.getLayoutParams();
        if (layoutParams4 == null) {
            t tVar4 = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(216614);
            throw tVar4;
        }
        ((RelativeLayout.LayoutParams) layoutParams4).height = (int) d2;
        com.tencent.mm.plugin.textstatus.e.a aVar = com.tencent.mm.plugin.textstatus.e.a.FYI;
        Context context = getContext();
        p.g(context, "context");
        String ceA = com.tencent.mm.plugin.auth.a.a.ceA();
        p.g(ceA, "Account.username()");
        ImageView imageView2 = this.Gfi;
        if (imageView2 == null) {
            p.btv("ivBackImg");
        }
        com.tencent.mm.plugin.textstatus.e.a.a(aVar, context, ceA, imageView2);
        this.Gfh = (WxRecyclerView) inflate.findViewById(R.id.h_0);
        WxRecyclerView wxRecyclerView = this.Gfh;
        if (wxRecyclerView != null) {
            wxRecyclerView.setAdapter(new WxRecyclerAdapter(new b(this), fwD()));
        }
        WxRecyclerView wxRecyclerView2 = this.Gfh;
        if (wxRecyclerView2 != null) {
            getContext();
            wxRecyclerView2.setLayoutManager(new LinearLayoutManager(1, false));
        }
        WxRecyclerView wxRecyclerView3 = this.Gfh;
        if (wxRecyclerView3 != null) {
            wxRecyclerView3.b(new g(this));
        }
        Context context2 = getContext();
        p.g(context2, "context");
        int dimensionPixelSize = context2.getResources().getDimensionPixelSize(R.dimen.ce);
        ImageView imageView3 = this.Gfi;
        if (imageView3 == null) {
            p.btv("ivBackImg");
        }
        imageView3.setOutlineProvider(new h(dimensionPixelSize));
        ImageView imageView4 = this.Gfi;
        if (imageView4 == null) {
            p.btv("ivBackImg");
        }
        imageView4.setClipToOutline(true);
        View view5 = this.Gfl;
        if (view5 == null) {
            p.btv("vBackMask");
        }
        view5.setOnClickListener(new i(this));
        View view6 = this.Gfl;
        if (view6 == null) {
            p.btv("vBackMask");
        }
        view6.setAlpha(0.0f);
        View view7 = this.Gfl;
        if (view7 == null) {
            p.btv("vBackMask");
        }
        ViewPropertyAnimator animate = view7.animate();
        if (!(animate == null || (alpha = animate.alpha(1.0f)) == null)) {
            alpha.setDuration(200);
        }
        RelativeLayout relativeLayout2 = this.Gfm;
        if (relativeLayout2 == null) {
            p.btv("layoutWrap");
        }
        relativeLayout2.setVisibility(4);
        RelativeLayout relativeLayout3 = this.Gfm;
        if (relativeLayout3 == null) {
            p.btv("layoutWrap");
        }
        relativeLayout3.post(new e(this));
        AppMethodBeat.o(216614);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog$initUI$3", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "itemPosition", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "plugin-textstatus_release"})
    public static final class g extends RecyclerView.h {
        final /* synthetic */ j Gft;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        g(j jVar) {
            this.Gft = jVar;
        }

        @Override // android.support.v7.widget.RecyclerView.h
        public final void a(Rect rect, int i2, RecyclerView recyclerView) {
            RecyclerView.a adapter;
            AppMethodBeat.i(216607);
            p.h(rect, "outRect");
            p.h(recyclerView, "parent");
            WxRecyclerView wxRecyclerView = this.Gft.Gfh;
            if (i2 == ((wxRecyclerView == null || (adapter = wxRecyclerView.getAdapter()) == null) ? 1 : adapter.getItemCount()) - 1 || i2 == 0) {
                Context context = this.Gft.getContext();
                p.g(context, "context");
                rect.bottom = context.getResources().getDimensionPixelSize(R.dimen.cb);
                AppMethodBeat.o(216607);
                return;
            }
            Context context2 = this.Gft.getContext();
            p.g(context2, "context");
            rect.bottom = context2.getResources().getDimensionPixelSize(R.dimen.ct);
            AppMethodBeat.o(216607);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog$initUI$4", "Landroid/view/ViewOutlineProvider;", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "plugin-textstatus_release"})
    public static final class h extends ViewOutlineProvider {
        final /* synthetic */ int Gfu;

        h(int i2) {
            this.Gfu = i2;
        }

        public final void getOutline(View view, Outline outline) {
            AppMethodBeat.i(216608);
            p.h(view, "view");
            p.h(outline, "outline");
            outline.setRoundRect(0, -this.Gfu, view.getWidth(), view.getHeight(), (float) this.Gfu);
            AppMethodBeat.o(216608);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class i implements View.OnClickListener {
        final /* synthetic */ j Gft;

        i(j jVar) {
            this.Gft = jVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(216609);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog$initUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.Gft.onBackPressed();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog$initUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(216609);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class e implements Runnable {
        final /* synthetic */ j Gft;

        e(j jVar) {
            this.Gft = jVar;
        }

        public final void run() {
            ViewPropertyAnimator translationY;
            AppMethodBeat.i(216605);
            this.Gft.fwC().setTranslationY(-((float) this.Gft.fwC().getMeasuredHeight()));
            this.Gft.fwC().setVisibility(0);
            ViewPropertyAnimator animate = this.Gft.fwC().animate();
            if (animate == null || (translationY = animate.translationY(0.0f)) == null) {
                AppMethodBeat.o(216605);
                return;
            }
            translationY.setDuration(200);
            AppMethodBeat.o(216605);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog$onBackPressed$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-textstatus_release"})
    /* renamed from: com.tencent.mm.plugin.textstatus.ui.j$j  reason: collision with other inner class name */
    public static final class C1829j implements Animator.AnimatorListener {
        final /* synthetic */ j Gft;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C1829j(j jVar) {
            this.Gft = jVar;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(216610);
            j.a(this.Gft);
            AppMethodBeat.o(216610);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    public final void onBackPressed() {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator animate2;
        ViewPropertyAnimator alpha;
        AppMethodBeat.i(216615);
        C1829j jVar = new C1829j(this);
        View view = this.Gfl;
        if (view == null) {
            p.btv("vBackMask");
        }
        if (!(view == null || (animate2 = view.animate()) == null || (alpha = animate2.alpha(0.0f)) == null)) {
            alpha.setDuration(200);
        }
        RelativeLayout relativeLayout = this.Gfm;
        if (relativeLayout == null) {
            p.btv("layoutWrap");
        }
        if (!(relativeLayout == null || (animate = relativeLayout.animate()) == null)) {
            RelativeLayout relativeLayout2 = this.Gfm;
            if (relativeLayout2 == null) {
                p.btv("layoutWrap");
            }
            ViewPropertyAnimator translationY = animate.translationY(-((float) relativeLayout2.getMeasuredHeight()));
            if (!(translationY == null || (duration = translationY.setDuration(200)) == null)) {
                duration.setListener(jVar);
                AppMethodBeat.o(216615);
                return;
            }
        }
        AppMethodBeat.o(216615);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class l implements View.OnClickListener {
        final /* synthetic */ Context $context;

        l(Context context) {
            this.$context = context;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(216612);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog$setStatusClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            TextStatusEditActivity.a aVar = TextStatusEditActivity.GeM;
            TextStatusEditActivity.a.b(this.$context, null);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog$setStatusClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(216612);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d implements View.OnClickListener {
        final /* synthetic */ j Gft;

        d(j jVar) {
            this.Gft = jVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(216604);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog$cardItemClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (view != null && view.getId() == R.id.iys) {
                this.Gft.dismiss();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog$cardItemClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(216604);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "event", "", "extra", "", "kotlin.jvm.PlatformType", "onEvent"})
    static final class c implements f.a {
        final /* synthetic */ j Gft;

        c(j jVar) {
            this.Gft = jVar;
        }

        @Override // com.tencent.mm.plugin.textstatus.a.f.a
        public final void dV(Object obj) {
            AppMethodBeat.i(216603);
            if (p.j(obj, Boolean.TRUE)) {
                this.Gft.dismiss();
            }
            AppMethodBeat.o(216603);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog$buildItemConverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-textstatus_release"})
    public static final class b implements com.tencent.mm.view.recyclerview.f {
        final /* synthetic */ j Gft;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(j jVar) {
            this.Gft = jVar;
        }

        @Override // com.tencent.mm.view.recyclerview.f
        public final com.tencent.mm.view.recyclerview.e<?> EC(int i2) {
            AppMethodBeat.i(216602);
            switch (i2) {
                case -1:
                    com.tencent.mm.plugin.textstatus.b.c.a aVar = new com.tencent.mm.plugin.textstatus.b.c.a(this.Gft.Gfo, this.Gft.Gfp);
                    AppMethodBeat.o(216602);
                    return aVar;
                case 0:
                    com.tencent.mm.plugin.textstatus.b.c.b bVar = new com.tencent.mm.plugin.textstatus.b.c.b(this.Gft.Gfn);
                    AppMethodBeat.o(216602);
                    return bVar;
                default:
                    com.tencent.mm.plugin.textstatus.b.c.c cVar = new com.tencent.mm.plugin.textstatus.b.c.c(this.Gft.Gfq);
                    AppMethodBeat.o(216602);
                    return cVar;
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog$planetItemClickListener$1", "Lcom/tencent/mm/plugin/textstatus/convert/planet/PlanetItemConvert$OnClickCardItemListener;", "onClickItem", "", "itemData", "Lcom/tencent/mm/plugin/textstatus/model/planet/PlanetItem;", "view", "Landroid/view/View;", "plugin-textstatus_release"})
    public static final class k implements c.b {
        final /* synthetic */ j Gft;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        k(j jVar) {
            this.Gft = jVar;
        }

        @Override // com.tencent.mm.plugin.textstatus.b.c.c.b
        public final void a(com.tencent.mm.plugin.textstatus.f.d.b bVar, View view) {
            AppMethodBeat.i(216611);
            p.h(bVar, "itemData");
            p.h(view, "view");
            try {
                m.a aVar = new m.a();
                com.tencent.mm.plugin.textstatus.j.b bVar2 = com.tencent.mm.plugin.textstatus.j.b.GfZ;
                m fvz = aVar.aSZ(com.tencent.mm.plugin.textstatus.j.b.getName(bVar.iHf.get(0).field_IconID)).fvz();
                TextStatusEditActivity.a aVar2 = TextStatusEditActivity.GeM;
                TextStatusEditActivity.a.b(this.Gft.mContext, fvz);
                AppMethodBeat.o(216611);
            } catch (Throwable th) {
                AppMethodBeat.o(216611);
            }
        }
    }

    private final ArrayList<com.tencent.mm.view.recyclerview.a> fwD() {
        AppMethodBeat.i(216616);
        com.tencent.mm.plugin.textstatus.b.f fVar = com.tencent.mm.plugin.textstatus.b.f.FXJ;
        com.tencent.mm.plugin.textstatus.f.f.a aTf = com.tencent.mm.plugin.textstatus.b.f.aTf(com.tencent.mm.plugin.auth.a.a.ceA());
        if (aTf == null) {
            this.Gfr.add(0, new com.tencent.mm.plugin.textstatus.f.d.a(com.tencent.mm.plugin.auth.a.a.ceA(), 0));
        } else {
            this.Gfr.add(0, new com.tencent.mm.plugin.textstatus.f.d.a(com.tencent.mm.plugin.auth.a.a.ceA(), -1));
        }
        LinkedList linkedList = new LinkedList();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (aTf != null) {
            String str = aTf.field_UserName;
            if (str != null) {
                arrayList.add(str);
            }
            String str2 = aTf.field_TopicId;
            if (str2 != null) {
                arrayList2.add(str2);
            }
        }
        com.tencent.mm.plugin.textstatus.b.f fVar2 = com.tencent.mm.plugin.textstatus.b.f.FXJ;
        for (Map.Entry<String, ArrayList<com.tencent.mm.plugin.textstatus.f.f.a>> entry : com.tencent.mm.plugin.textstatus.b.f.fvM().w(arrayList, arrayList2).entrySet()) {
            this.Gfr.add(new com.tencent.mm.plugin.textstatus.f.d.b(entry.getKey(), entry.getValue(), 0));
            linkedList.add(entry.getKey());
        }
        if (!linkedList.isEmpty()) {
            com.tencent.mm.plugin.textstatus.b.f fVar3 = com.tencent.mm.plugin.textstatus.b.f.FXJ;
            com.tencent.mm.plugin.textstatus.b.f.a(linkedList, new f(this));
        }
        ArrayList<com.tencent.mm.view.recyclerview.a> arrayList3 = this.Gfr;
        AppMethodBeat.o(216616);
        return arrayList3;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/textstatus/ui/TextStatusHeaderDialog$initList$2", "Lcom/tencent/mm/plugin/textstatus/convert/TextStatusInfoManager$Callback;", "onCall", "", "result", "", "plugin-textstatus_release"})
    public static final class f implements f.a {
        final /* synthetic */ j Gft;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(j jVar) {
            this.Gft = jVar;
        }

        @Override // com.tencent.mm.plugin.textstatus.b.f.a
        public final void dW(Object obj) {
            RecyclerView.a adapter;
            Integer num;
            AppMethodBeat.i(216606);
            HashMap hashMap = (HashMap) obj;
            Iterator it = this.Gft.Gfr.iterator();
            while (it.hasNext()) {
                com.tencent.mm.view.recyclerview.a aVar = (com.tencent.mm.view.recyclerview.a) it.next();
                if (aVar instanceof com.tencent.mm.plugin.textstatus.f.d.b) {
                    com.tencent.mm.plugin.textstatus.f.d.b bVar = (com.tencent.mm.plugin.textstatus.f.d.b) aVar;
                    x xVar = (x) hashMap.get(((com.tencent.mm.plugin.textstatus.f.d.b) aVar).FZz);
                    if (xVar != null) {
                        num = Integer.valueOf(xVar.GaE);
                    } else {
                        num = null;
                    }
                    bVar.FZA = num;
                }
            }
            WxRecyclerView wxRecyclerView = this.Gft.Gfh;
            if (wxRecyclerView == null || (adapter = wxRecyclerView.getAdapter()) == null) {
                AppMethodBeat.o(216606);
                return;
            }
            adapter.notifyDataSetChanged();
            AppMethodBeat.o(216606);
        }
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(216617);
        q qVar2 = this.gxX;
        if (qVar2 != null) {
            qVar2.dismiss();
            AppMethodBeat.o(216617);
            return;
        }
        AppMethodBeat.o(216617);
    }
}
