package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.ball.c.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vfs.s;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t*\u0001\u0010\u0018\u0000 (2\u00020\u0001:\u0002()B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0003J\u0012\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0014H\u0002J\b\u0010\u001e\u001a\u00020\u001bH\u0002J\u000e\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020\u001bJ\u0010\u0010#\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0014J\u0010\u0010$\u001a\u00020\u001b2\b\u0010%\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010&\u001a\u00020\u001b2\b\u0010'\u001a\u0004\u0018\u00010\u000eR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/music/ui/FloatBallMusicView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "closeButton", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "closeClickListener", "Landroid/view/View$OnClickListener;", "floatBallViewListener", "com/tencent/mm/plugin/music/ui/FloatBallMusicView$floatBallViewListener$1", "Lcom/tencent/mm/plugin/music/ui/FloatBallMusicView$floatBallViewListener$1;", "iconClickListener", "mCoverPath", "", "marginSize", "musicCover", "Landroid/widget/ImageView;", "musicIcon", "musicIconLayout", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "loadMusicCover", "coverPath", "onLoadCoverFailed", "refreshLayoutWhenPositionChanged", "isDockerLeft", "", "release", "setCoverPath", "setOnCloseListener", "closeListener", "setOnMusicIconClickListener", "clickListener", "Companion", "RoundCornerBitmapTransformation", "plugin-music_release"})
public final class FloatBallMusicView extends RelativeLayout {
    public static final a AmI = new a((byte) 0);
    private String Akf;
    private ImageView AmB;
    private RelativeLayout AmC;
    private WeImageView AmD;
    private int AmE;
    public final c AmF;
    private View.OnClickListener AmG;
    private View.OnClickListener AmH;
    private WeImageView uPJ;

    static {
        AppMethodBeat.i(220010);
        AppMethodBeat.o(220010);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/music/ui/FloatBallMusicView$Companion;", "", "()V", "TAG", "", "plugin-music_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ void e(FloatBallMusicView floatBallMusicView) {
        AppMethodBeat.i(220011);
        floatBallMusicView.evd();
        AppMethodBeat.o(220011);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/music/ui/FloatBallMusicView$floatBallViewListener$1", "Lcom/tencent/mm/plugin/ball/api/OnFloatBallViewListenerAdapter;", "onBallPositionChanged", "", "x", "", "y", "height", "isSettled", "", "isDockLeft", "plugin-music_release"})
    public static final class c extends h {
        final /* synthetic */ FloatBallMusicView AmL;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(FloatBallMusicView floatBallMusicView) {
            this.AmL = floatBallMusicView;
        }

        @Override // com.tencent.mm.plugin.ball.c.h, com.tencent.mm.plugin.ball.c.g
        public final void a(int i2, int i3, int i4, boolean z, boolean z2) {
            AppMethodBeat.i(219999);
            super.a(i2, i3, i4, z, z2);
            this.AmL.sp(z2);
            AppMethodBeat.o(219999);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FloatBallMusicView(Context context) {
        this(context, null);
        p.h(context, "context");
        AppMethodBeat.i(220007);
        AppMethodBeat.o(220007);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FloatBallMusicView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(220008);
        AppMethodBeat.o(220008);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FloatBallMusicView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(220009);
        this.Akf = "";
        this.AmF = new c(this);
        View inflate = LayoutInflater.from(context).inflate(R.layout.ayn, (ViewGroup) this, true);
        this.AmE = at.aH(context, R.dimen.ct);
        this.uPJ = (WeImageView) inflate.findViewById(R.id.fq2);
        this.AmB = (ImageView) inflate.findViewById(R.id.fpy);
        this.AmC = (RelativeLayout) inflate.findViewById(R.id.fq4);
        this.AmD = (WeImageView) inflate.findViewById(R.id.fpw);
        WeImageView weImageView = this.uPJ;
        if (weImageView != null) {
            weImageView.setImageResource(R.raw.icons_filled_mv_music_icon);
        }
        ImageView imageView = this.AmB;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        RelativeLayout relativeLayout = this.AmC;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new d(this));
        }
        WeImageView weImageView2 = this.AmD;
        if (weImageView2 != null) {
            weImageView2.setOnClickListener(new e(this));
        }
        com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.ball.c.b.class);
        p.g(af, "MMKernel.service(IFloatBallService::class.java)");
        sp(((com.tencent.mm.plugin.ball.c.b) af).chT());
        ((com.tencent.mm.plugin.ball.c.b) g.af(com.tencent.mm.plugin.ball.c.b.class)).a(this.AmF);
        AppMethodBeat.o(220009);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d implements View.OnClickListener {
        final /* synthetic */ FloatBallMusicView AmL;

        d(FloatBallMusicView floatBallMusicView) {
            this.AmL = floatBallMusicView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(220000);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/music/ui/FloatBallMusicView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            View.OnClickListener onClickListener = this.AmL.AmH;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/music/ui/FloatBallMusicView$init$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(220000);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e implements View.OnClickListener {
        final /* synthetic */ FloatBallMusicView AmL;

        e(FloatBallMusicView floatBallMusicView) {
            this.AmL = floatBallMusicView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(220001);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/music/ui/FloatBallMusicView$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            View.OnClickListener onClickListener = this.AmL.AmG;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/music/ui/FloatBallMusicView$init$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(220001);
        }
    }

    public final void sp(boolean z) {
        ViewGroup.LayoutParams layoutParams;
        WeImageView weImageView;
        ViewGroup.LayoutParams layoutParams2;
        RelativeLayout relativeLayout;
        AppMethodBeat.i(220004);
        RelativeLayout relativeLayout2 = this.AmC;
        if (relativeLayout2 != null) {
            RelativeLayout relativeLayout3 = this.AmC;
            if (relativeLayout3 == null || (layoutParams2 = relativeLayout3.getLayoutParams()) == null) {
                layoutParams2 = null;
                relativeLayout = relativeLayout2;
            } else {
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    if (z) {
                        ((RelativeLayout.LayoutParams) layoutParams2).removeRule(20);
                        ((RelativeLayout.LayoutParams) layoutParams2).addRule(21);
                        ((RelativeLayout.LayoutParams) layoutParams2).setMarginStart(0);
                        ((RelativeLayout.LayoutParams) layoutParams2).setMarginEnd(this.AmE);
                    } else {
                        ((RelativeLayout.LayoutParams) layoutParams2).removeRule(21);
                        ((RelativeLayout.LayoutParams) layoutParams2).addRule(20);
                        ((RelativeLayout.LayoutParams) layoutParams2).setMarginStart(this.AmE);
                        ((RelativeLayout.LayoutParams) layoutParams2).setMarginEnd(0);
                    }
                }
                relativeLayout = relativeLayout2;
            }
            relativeLayout.setLayoutParams(layoutParams2);
        }
        WeImageView weImageView2 = this.AmD;
        if (weImageView2 != null) {
            WeImageView weImageView3 = this.AmD;
            if (weImageView3 == null || (layoutParams = weImageView3.getLayoutParams()) == null) {
                layoutParams = null;
                weImageView = weImageView2;
            } else {
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    if (z) {
                        ((RelativeLayout.LayoutParams) layoutParams).removeRule(21);
                        ((RelativeLayout.LayoutParams) layoutParams).addRule(20);
                    } else {
                        ((RelativeLayout.LayoutParams) layoutParams).removeRule(20);
                        ((RelativeLayout.LayoutParams) layoutParams).addRule(21);
                    }
                }
                weImageView = weImageView2;
            }
            weImageView.setLayoutParams(layoutParams);
            AppMethodBeat.o(220004);
            return;
        }
        AppMethodBeat.o(220004);
    }

    public final void setOnCloseListener(View.OnClickListener onClickListener) {
        this.AmG = onClickListener;
    }

    public final void setOnMusicIconClickListener(View.OnClickListener onClickListener) {
        this.AmH = onClickListener;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.lang.String */
    /* JADX WARN: Multi-variable type inference failed */
    public final void setCoverPath(String str) {
        String str2;
        AppMethodBeat.i(220005);
        if (!p.j(this.Akf, str)) {
            if (str == 0) {
                str2 = "";
            } else {
                str2 = str;
            }
            this.Akf = str2;
            String str3 = str;
            if (str3 == null || str3.length() == 0) {
                evd();
                AppMethodBeat.o(220005);
                return;
            }
            z.f fVar = new z.f();
            fVar.SYG = "";
            if (n.J(str, "http", false) || n.J(str, "https", false)) {
                fVar.SYG = str;
            } else {
                String k = s.k(str, false);
                if (!s.YS(k)) {
                    Log.e("MicroMsg.FloatBallMusicView", "alvinluo setCoverPath file not exist %s", k);
                    evd();
                    AppMethodBeat.o(220005);
                    return;
                }
                fVar.SYG = (T) "file://".concat(String.valueOf(k));
            }
            Log.v("MicroMsg.FloatBallMusicView", "alvinluo loadMusicCover url: " + ((String) fVar.SYG));
            b.a aVar = b.AmK;
            com.tencent.mm.modelappbrand.a.b.aXY().a(new f(this, fVar), fVar.SYG, b.AmJ);
        }
        AppMethodBeat.o(220005);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/music/ui/FloatBallMusicView$loadMusicCover$1", "Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$ILoadTarget;", "beforeLoadBitmap", "", "key", "", "onBitmapLoaded", "bitmap", "Landroid/graphics/Bitmap;", "onLoadFailed", "plugin-music_release"})
    public static final class f implements b.k {
        final /* synthetic */ FloatBallMusicView AmL;
        final /* synthetic */ z.f AmM;

        f(FloatBallMusicView floatBallMusicView, z.f fVar) {
            this.AmL = floatBallMusicView;
            this.AmM = fVar;
        }

        @Override // com.tencent.mm.modelappbrand.a.b.k
        public final void aYg() {
        }

        @Override // com.tencent.mm.modelappbrand.a.b.k
        public final void I(Bitmap bitmap) {
            AppMethodBeat.i(220002);
            if (bitmap == null || bitmap.isRecycled()) {
                FloatBallMusicView.e(this.AmL);
                AppMethodBeat.o(220002);
                return;
            }
            RelativeLayout relativeLayout = this.AmL.AmC;
            if (relativeLayout != null) {
                relativeLayout.setBackgroundResource(R.drawable.b0w);
            }
            ImageView imageView = this.AmL.AmB;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ImageView imageView2 = this.AmL.AmB;
            if (imageView2 != null) {
                imageView2.setImageBitmap(bitmap);
                AppMethodBeat.o(220002);
                return;
            }
            AppMethodBeat.o(220002);
        }

        @Override // com.tencent.mm.modelappbrand.a.b.k
        public final void oD() {
            AppMethodBeat.i(261716);
            FloatBallMusicView.e(this.AmL);
            AppMethodBeat.o(261716);
        }

        @Override // com.tencent.mm.modelappbrand.a.b.k, com.tencent.mm.modelappbrand.a.c
        public final String Lb() {
            return this.AmM.SYG;
        }
    }

    private final void evd() {
        AppMethodBeat.i(220006);
        Log.e("MicroMsg.FloatBallMusicView", "alvinluo loadMusicCover failed");
        RelativeLayout relativeLayout = this.AmC;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundResource(R.drawable.a4n);
        }
        ImageView imageView = this.AmB;
        if (imageView != null) {
            imageView.setVisibility(8);
            AppMethodBeat.o(220006);
            return;
        }
        AppMethodBeat.o(220006);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/music/ui/FloatBallMusicView$RoundCornerBitmapTransformation;", "Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$IBitmapTransformation;", "roundRate", "", "(F)V", "getRoundRate", "()F", "key", "", "transform", "Landroid/graphics/Bitmap;", "bitmap", "Companion", "plugin-music_release"})
    public static final class b implements b.h {
        private static final b AmJ = new b();
        public static final a AmK = new a((byte) 0);
        private final float iaU = 0.25f;

        private b() {
        }

        @Override // com.tencent.mm.modelappbrand.a.b.h
        public final Bitmap J(Bitmap bitmap) {
            Bitmap centerCropBitmap;
            AppMethodBeat.i(219997);
            p.h(bitmap, "bitmap");
            if (bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
                AppMethodBeat.o(219997);
                return bitmap;
            }
            try {
                if (bitmap.getWidth() == bitmap.getHeight()) {
                    centerCropBitmap = BitmapUtil.getRoundedCornerBitmap(bitmap, false, ((float) bitmap.getWidth()) * this.iaU);
                } else {
                    int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
                    if (min <= 0) {
                        min = Math.max(bitmap.getWidth(), bitmap.getHeight());
                    }
                    centerCropBitmap = BitmapUtil.getCenterCropBitmap(bitmap, min, min, true);
                    if (centerCropBitmap != null) {
                        centerCropBitmap = BitmapUtil.getRoundedCornerBitmap(centerCropBitmap, false, ((float) centerCropBitmap.getWidth()) * this.iaU);
                    }
                }
                if (centerCropBitmap != null) {
                    AppMethodBeat.o(219997);
                    return centerCropBitmap;
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.FloatBallMusicView", e2, "getRoundBitmap exception", new Object[0]);
            }
            AppMethodBeat.o(219997);
            return bitmap;
        }

        @Override // com.tencent.mm.modelappbrand.a.c
        public final String Lb() {
            return "FloatBallMusicCover";
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/music/ui/FloatBallMusicView$RoundCornerBitmapTransformation$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mm/plugin/music/ui/FloatBallMusicView$RoundCornerBitmapTransformation;", "getINSTANCE", "()Lcom/tencent/mm/plugin/music/ui/FloatBallMusicView$RoundCornerBitmapTransformation;", "plugin-music_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }

        static {
            AppMethodBeat.i(219998);
            AppMethodBeat.o(219998);
        }
    }
}
