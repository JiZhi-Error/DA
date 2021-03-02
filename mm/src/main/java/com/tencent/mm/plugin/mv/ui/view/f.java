package com.tencent.mm.plugin.mv.ui.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.HandlerThread;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvDataUIC;
import com.tencent.mm.plugin.mv.ui.uic.MusicMvMainUIC;
import com.tencent.mm.plugin.mv.ui.view.b;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.blur.BlurView;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import com.tencent.mm.ui.widget.RoundCornerRelativeLayout;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.xeffect.effect.VLogEffectJNI;
import com.tencent.mm.xeffect.effect.ad;
import com.tencent.tav.coremedia.TimeUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 f2\u00020\u0001:\u0001fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010_\u001a\u00020^2\u0006\u0010B\u001a\u00020CH\u0002J\u0006\u0010`\u001a\u00020aJ\u0006\u00103\u001a\u000204J\u0010\u0010b\u001a\u00020a2\b\u0010B\u001a\u0004\u0018\u00010CJ\u0006\u0010c\u001a\u00020aJ\u0006\u0010d\u001a\u00020aJ\u000e\u0010e\u001a\u00020a2\u0006\u0010<\u001a\u00020=R#\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR#\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\r\u0010\tR#\u0010\u000f\u001a\n \u0007*\u0004\u0018\u00010\u00100\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0011\u0010\u0012R#\u0010\u0014\u001a\n \u0007*\u0004\u0018\u00010\u00150\u00158BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0016\u0010\u0017R#\u0010\u0019\u001a\n \u0007*\u0004\u0018\u00010\u00030\u00038BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u000b\u001a\u0004\b\u001a\u0010\u001bR#\u0010\u001d\u001a\n \u0007*\u0004\u0018\u00010\u001e0\u001e8BX\u0002¢\u0006\f\n\u0004\b!\u0010\u000b\u001a\u0004\b\u001f\u0010 R#\u0010\"\u001a\n \u0007*\u0004\u0018\u00010#0#8BX\u0002¢\u0006\f\n\u0004\b&\u0010\u000b\u001a\u0004\b$\u0010%R#\u0010'\u001a\n \u0007*\u0004\u0018\u00010(0(8BX\u0002¢\u0006\f\n\u0004\b+\u0010\u000b\u001a\u0004\b)\u0010*R#\u0010,\u001a\n \u0007*\u0004\u0018\u00010-0-8BX\u0002¢\u0006\f\n\u0004\b0\u0010\u000b\u001a\u0004\b.\u0010/R\u0010\u00101\u001a\u0004\u0018\u000102X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u000e¢\u0006\u0002\n\u0000R\u001a\u00105\u001a\u000206X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u000e\u0010;\u001a\u000206X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u0004\u0018\u00010=X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u001bR#\u0010?\u001a\n \u0007*\u0004\u0018\u00010\u00150\u00158BX\u0002¢\u0006\f\n\u0004\bA\u0010\u000b\u001a\u0004\b@\u0010\u0017R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u000e¢\u0006\u0002\n\u0000R#\u0010D\u001a\n \u0007*\u0004\u0018\u00010\u00030\u00038BX\u0002¢\u0006\f\n\u0004\bF\u0010\u000b\u001a\u0004\bE\u0010\u001bR#\u0010G\u001a\n \u0007*\u0004\u0018\u00010H0H8BX\u0002¢\u0006\f\n\u0004\bK\u0010\u000b\u001a\u0004\bI\u0010JR#\u0010L\u001a\n \u0007*\u0004\u0018\u00010\u00030\u00038BX\u0002¢\u0006\f\n\u0004\bN\u0010\u000b\u001a\u0004\bM\u0010\u001bR#\u0010O\u001a\n \u0007*\u0004\u0018\u00010H0H8BX\u0002¢\u0006\f\n\u0004\bQ\u0010\u000b\u001a\u0004\bP\u0010JR#\u0010R\u001a\n \u0007*\u0004\u0018\u00010S0S8BX\u0002¢\u0006\f\n\u0004\bV\u0010\u000b\u001a\u0004\bT\u0010UR#\u0010W\u001a\n \u0007*\u0004\u0018\u00010\u00100\u00108BX\u0002¢\u0006\f\n\u0004\bY\u0010\u000b\u001a\u0004\bX\u0010\u0012R#\u0010Z\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0002¢\u0006\f\n\u0004\b\\\u0010\u000b\u001a\u0004\b[\u0010\tR\u0010\u0010]\u001a\u0004\u0018\u00010^X\u000e¢\u0006\u0002\n\u0000¨\u0006g"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog;", "", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "bottomMask", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getBottomMask", "()Landroid/view/View;", "bottomMask$delegate", "Lkotlin/Lazy;", "collapseButton", "getCollapseButton", "collapseButton$delegate", "collapseLayout", "Lcom/tencent/mm/ui/blur/BlurView;", "getCollapseLayout", "()Lcom/tencent/mm/ui/blur/BlurView;", "collapseLayout$delegate", "copyrightFromTv", "Landroid/widget/TextView;", "getCopyrightFromTv", "()Landroid/widget/TextView;", "copyrightFromTv$delegate", "copyrightInfoLayout", "getCopyrightInfoLayout", "()Landroid/view/ViewGroup;", "copyrightInfoLayout$delegate", "copyrightIv", "Lcom/tencent/mm/ui/widget/MMRoundCornerImageView;", "getCopyrightIv", "()Lcom/tencent/mm/ui/widget/MMRoundCornerImageView;", "copyrightIv$delegate", "coverIv", "Lcom/tencent/mm/ui/MMImageView;", "getCoverIv", "()Lcom/tencent/mm/ui/MMImageView;", "coverIv$delegate", "defaultCoverIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getDefaultCoverIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "defaultCoverIv$delegate", "dialogRootLayout", "Lcom/tencent/mm/ui/widget/RoundCornerRelativeLayout;", "getDialogRootLayout", "()Lcom/tencent/mm/ui/widget/RoundCornerRelativeLayout;", "dialogRootLayout$delegate", "effector", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvBitmapEffector;", "isShow", "", "layoutHeight", "", "getLayoutHeight", "()I", "setLayoutHeight", "(I)V", "layoutWidth", "musicMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "getParent", "singerTv", "getSingerTv", "singerTv$delegate", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "songInfoFullScreenRoot", "getSongInfoFullScreenRoot", "songInfoFullScreenRoot$delegate", "songNameTv", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView;", "getSongNameTv", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView;", "songNameTv$delegate", "specialInfoLayout", "getSpecialInfoLayout", "specialInfoLayout$delegate", "specialInfoTv", "getSpecialInfoTv", "specialInfoTv$delegate", "statusButton", "Landroid/widget/Button;", "getStatusButton", "()Landroid/widget/Button;", "statusButton$delegate", "statusButtonBlurLayout", "getStatusButtonBlurLayout", "statusButtonBlurLayout$delegate", "topGradientMask", "getTopGradientMask", "topGradientMask$delegate", "verifyInfo", "", "getDate", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "", "passParameters", "reset", "show", "updateMv", "Companion", "plugin-mv_release"})
@SuppressLint({"ResourceType"})
public final class f {
    public static final a AyX = new a((byte) 0);
    public static final String TAG = ("MicroMsg.Mv.MusicMvSongInfoDialog@" + AyX.hashCode());
    public axy Aqo;
    private final kotlin.f AyF = kotlin.g.ah(new o(this));
    private final kotlin.f AyG = kotlin.g.ah(new j(this));
    private final kotlin.f AyH = kotlin.g.ah(new b(this));
    private final kotlin.f AyI = kotlin.g.ah(new u(this));
    private final kotlin.f AyJ = kotlin.g.ah(new p(this));
    private final kotlin.f AyK = kotlin.g.ah(new n(this));
    private final kotlin.f AyL = kotlin.g.ah(new h(this));
    private final kotlin.f AyM = kotlin.g.ah(new i(this));
    private final kotlin.f AyN = kotlin.g.ah(new q(this));
    public final kotlin.f AyO = kotlin.g.ah(new r(this));
    private final kotlin.f AyP = kotlin.g.ah(new t(this));
    private final kotlin.f AyQ = kotlin.g.ah(new s(this));
    private final kotlin.f AyR = kotlin.g.ah(new C1562f(this));
    public final kotlin.f AyS = kotlin.g.ah(new g(this));
    private final kotlin.f AyT = kotlin.g.ah(new e(this));
    private final kotlin.f AyU = kotlin.g.ah(new d(this));
    private final kotlin.f AyV = kotlin.g.ah(new c(this));
    private b AyW;
    public com.tencent.mm.plugin.mv.a.e Ayc;
    public boolean dEF;
    public String fuN;
    public final ViewGroup parent;
    private int uZu;
    public int uZv;

    private final View ewD() {
        AppMethodBeat.i(257641);
        View view = (View) this.AyI.getValue();
        AppMethodBeat.o(257641);
        return view;
    }

    private final Button ewI() {
        AppMethodBeat.i(257646);
        Button button = (Button) this.AyQ.getValue();
        AppMethodBeat.o(257646);
        return button;
    }

    private final BlurView ewM() {
        AppMethodBeat.i(257650);
        BlurView blurView = (BlurView) this.AyU.getValue();
        AppMethodBeat.o(257650);
        return blurView;
    }

    public final ViewGroup ewA() {
        AppMethodBeat.i(257638);
        ViewGroup viewGroup = (ViewGroup) this.AyF.getValue();
        AppMethodBeat.o(257638);
        return viewGroup;
    }

    public final RoundCornerRelativeLayout ewB() {
        AppMethodBeat.i(257639);
        RoundCornerRelativeLayout roundCornerRelativeLayout = (RoundCornerRelativeLayout) this.AyG.getValue();
        AppMethodBeat.o(257639);
        return roundCornerRelativeLayout;
    }

    public final View ewC() {
        AppMethodBeat.i(257640);
        View view = (View) this.AyH.getValue();
        AppMethodBeat.o(257640);
        return view;
    }

    public final MusicMvMarqueeTextView ewE() {
        AppMethodBeat.i(257642);
        MusicMvMarqueeTextView musicMvMarqueeTextView = (MusicMvMarqueeTextView) this.AyJ.getValue();
        AppMethodBeat.o(257642);
        return musicMvMarqueeTextView;
    }

    public final TextView ewF() {
        AppMethodBeat.i(257643);
        TextView textView = (TextView) this.AyK.getValue();
        AppMethodBeat.o(257643);
        return textView;
    }

    public final MMImageView ewG() {
        AppMethodBeat.i(257644);
        MMImageView mMImageView = (MMImageView) this.AyL.getValue();
        AppMethodBeat.o(257644);
        return mMImageView;
    }

    public final BlurView ewH() {
        AppMethodBeat.i(257645);
        BlurView blurView = (BlurView) this.AyP.getValue();
        AppMethodBeat.o(257645);
        return blurView;
    }

    public final ViewGroup ewJ() {
        AppMethodBeat.i(257647);
        ViewGroup viewGroup = (ViewGroup) this.AyR.getValue();
        AppMethodBeat.o(257647);
        return viewGroup;
    }

    public final TextView ewL() {
        AppMethodBeat.i(257649);
        TextView textView = (TextView) this.AyT.getValue();
        AppMethodBeat.o(257649);
        return textView;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\b"}, hxF = {"<anonymous>", "", "viewWeakHolder", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "bitmap", "Landroid/graphics/Bitmap;", "invoke", "com/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$passParameters$1$3$1", "com/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$$special$$inlined$multiLet$lambda$1"})
    public static final class l extends kotlin.g.b.q implements kotlin.g.a.m<com.tencent.mm.loader.e.b.g<?>, Bitmap, x> {
        final /* synthetic */ f AyY;
        final /* synthetic */ MMImageView AyZ;
        final /* synthetic */ com.tencent.mm.loader.c.e Aza;
        final /* synthetic */ axy Azb;
        final /* synthetic */ String mkH;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(String str, MMImageView mMImageView, com.tencent.mm.loader.c.e eVar, f fVar, axy axy) {
            super(2);
            this.mkH = str;
            this.AyZ = mMImageView;
            this.Aza = eVar;
            this.AyY = fVar;
            this.Azb = axy;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ x invoke(com.tencent.mm.loader.e.b.g<?> gVar, Bitmap bitmap) {
            Integer num = null;
            AppMethodBeat.i(257628);
            Bitmap bitmap2 = bitmap;
            kotlin.g.b.p.h(gVar, "viewWeakHolder");
            String str = f.TAG;
            StringBuilder append = new StringBuilder("loadBitmap finished:").append(bitmap2).append(", size:[").append(bitmap2 != null ? Integer.valueOf(bitmap2.getWidth()) : null).append(',');
            if (bitmap2 != null) {
                num = Integer.valueOf(bitmap2.getHeight());
            }
            Log.i(str, append.append(num).append("], url:").append(this.mkH).toString());
            if (bitmap2 != null) {
                this.AyY.AyW = new b();
                b bVar = this.AyY.AyW;
                if (bVar != null) {
                    HandlerThread hz = com.tencent.f.c.d.hz("MusicMvBitmapEffector@" + bVar.hashCode(), 0);
                    hz.start();
                    bVar.AsD = new MMHandler(hz.getLooper());
                    bVar.AsC = hz;
                }
                int width = bitmap2.getWidth();
                float f2 = (((float) this.AyY.uZv) * 1.0f) / ((float) this.AyY.uZu);
                int cR = kotlin.h.a.cR(((float) width) * f2);
                b bVar2 = this.AyY.AyW;
                if (bVar2 != null) {
                    bVar2.width = width;
                    bVar2.height = cR;
                    Log.i(bVar2.TAG, "setOutputSize:" + width + ", " + cR);
                }
                b bVar3 = this.AyY.AyW;
                if (bVar3 != null) {
                    kotlin.g.b.p.h(bitmap2, "bitmap");
                    bVar3.imageBitmap = bitmap2;
                    Log.i(bVar3.TAG, "setInputBitmap:" + bitmap2 + ", size:[" + bitmap2.getWidth() + ',' + bitmap2.getHeight() + ']');
                }
                float f3 = ((float) (-(cR - bitmap2.getHeight()))) / 2.0f;
                Log.i(f.TAG, "output width:" + width + ", height:" + cR + ", layoutSizeRatio:" + f2 + ", contentOffset:" + f3);
                b bVar4 = this.AyY.AyW;
                if (bVar4 != null) {
                    ad a2 = bVar4.wet.a(com.tencent.mm.xeffect.effect.j.GradientBlurEffect);
                    if (a2 == null) {
                        kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.xeffect.effect.GradientBlurEffect");
                        AppMethodBeat.o(257628);
                        throw tVar;
                    }
                    com.tencent.mm.xeffect.effect.l lVar = (com.tencent.mm.xeffect.effect.l) a2;
                    lVar.setRadius(30.0f);
                    VLogEffectJNI.INSTANCE.nSetGradientBlurEffectBlurTop(lVar.ptr, true);
                    VLogEffectJNI.INSTANCE.nSetGradientBlurEffectBlurBottom(lVar.ptr, false);
                    VLogEffectJNI.INSTANCE.nSetGradientBlurEffectBlurMaskRatio(lVar.ptr, 1.0f);
                    lVar.cM(f3);
                    lVar.aH(0, 1000);
                    bVar4.wet.a(lVar);
                    bVar4.Axz = false;
                    Log.i(bVar4.TAG, "setGradientBlurEffect, blurTop:true, blurBottom:false, blurRadius:30.0" + ", blurMaskRatio:1.0, contentOffset:" + f3);
                }
                b bVar5 = this.AyY.AyW;
                if (bVar5 != null) {
                    AnonymousClass1 r0 = new kotlin.g.a.b<Bitmap, x>(this) {
                        /* class com.tencent.mm.plugin.mv.ui.view.f.l.AnonymousClass1 */
                        final /* synthetic */ l Azc;

                        {
                            this.Azc = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // kotlin.g.a.b
                        public final /* synthetic */ x invoke(Bitmap bitmap) {
                            AppMethodBeat.i(257627);
                            this.Azc.AyZ.setImageBitmap(bitmap);
                            this.Azc.AyZ.setVisibility(0);
                            WeImageView d2 = f.d(this.Azc.AyY);
                            kotlin.g.b.p.g(d2, "defaultCoverIv");
                            d2.setVisibility(8);
                            x xVar = x.SXb;
                            AppMethodBeat.o(257627);
                            return xVar;
                        }
                    };
                    kotlin.g.b.p.h(r0, "callback");
                    bVar5.Axy = r0;
                    int i2 = bVar5.width;
                    int i3 = bVar5.height;
                    if (bVar5.ilw == null) {
                        bVar5.k(new b.a(bVar5, i2, i3));
                    }
                    bVar5.k(new b.d(bVar5));
                }
                b bVar6 = this.AyY.AyW;
                if (bVar6 != null) {
                    Log.i(bVar6.TAG, "destroy");
                    bVar6.k(new b.C1560b(bVar6));
                }
                f.e(this.AyY).postInvalidate();
                f.f(this.AyY).postInvalidate();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(257628);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$Companion;", "", "()V", "ACTION_JUMP_APP", "", "ACTION_SET_STATUS", "ACTION_SHOW", "REQUEST_SET_MUSIC_STATUS", "TAG", "", "plugin-mv_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public f(ViewGroup viewGroup) {
        kotlin.g.b.p.h(viewGroup, "parent");
        AppMethodBeat.i(257653);
        this.parent = viewGroup;
        int aG = com.tencent.mm.cb.a.aG(this.parent.getContext(), R.dimen.c6);
        Point gx = ao.gx(this.parent.getContext());
        int i2 = gx.x + aG;
        RoundCornerRelativeLayout ewB = ewB();
        kotlin.g.b.p.g(ewB, "dialogRootLayout");
        ViewGroup.LayoutParams layoutParams = ewB.getLayoutParams();
        layoutParams.height = i2;
        RoundCornerRelativeLayout ewB2 = ewB();
        kotlin.g.b.p.g(ewB2, "dialogRootLayout");
        ewB2.setLayoutParams(layoutParams);
        float fromDPToPix = (float) com.tencent.mm.cb.a.fromDPToPix(this.parent.getContext(), 24);
        ewB().s(0.0f, 0.0f, fromDPToPix, fromDPToPix);
        this.uZv = i2;
        this.uZu = gx.x;
        ewJ().setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.mv.ui.view.f.AnonymousClass1 */
            final /* synthetic */ f AyY;

            {
                this.AyY = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(257614);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                Context context = this.AyY.parent.getContext();
                kotlin.g.b.p.g(context, "parent.context");
                axy axy = ((MusicMvDataUIC) com.tencent.mm.ui.component.a.ko(context).get(MusicMvDataUIC.class)).Aqo;
                com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
                Context context2 = this.AyY.parent.getContext();
                kotlin.g.b.p.g(context2, "parent.context");
                int a2 = ((MusicMvMainUIC) com.tencent.mm.ui.component.a.ko(context2).get(MusicMvMainUIC.class)).a(axy, new a(this, axy));
                if (a2 != 7) {
                    com.tencent.mm.plugin.mv.a.e eVar = this.AyY.Ayc;
                    if (!(axy == null || eVar == null)) {
                        com.tencent.mm.plugin.mv.a.k kVar = com.tencent.mm.plugin.mv.a.k.Aql;
                        Context context3 = this.AyY.parent.getContext();
                        kotlin.g.b.p.g(context3, "parent.context");
                        com.tencent.mm.plugin.mv.a.k.a(context3, axy, eVar, 2, a2, 1);
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(257614);
            }

            @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "launchSuccess", "", "launchCancel", "onLaunchApp"})
            /* renamed from: com.tencent.mm.plugin.mv.ui.view.f$1$a */
            static final class a implements al {
                final /* synthetic */ axy Awp;
                final /* synthetic */ AnonymousClass1 Vat;

                a(AnonymousClass1 r1, axy axy) {
                    this.Vat = r1;
                    this.Awp = axy;
                }

                @Override // com.tencent.mm.pluginsdk.model.app.al
                public final void v(boolean z, boolean z2) {
                    AppMethodBeat.i(259293);
                    axy axy = this.Awp;
                    com.tencent.mm.plugin.mv.a.e eVar = this.Vat.AyY.Ayc;
                    if (!(axy == null || eVar == null)) {
                        if (z) {
                            com.tencent.mm.plugin.mv.a.k kVar = com.tencent.mm.plugin.mv.a.k.Aql;
                            Context context = this.Vat.AyY.parent.getContext();
                            kotlin.g.b.p.g(context, "parent.context");
                            com.tencent.mm.plugin.mv.a.k.a(context, axy, eVar, 2, 1, 1);
                        }
                        if (z2) {
                            com.tencent.mm.plugin.mv.a.k kVar2 = com.tencent.mm.plugin.mv.a.k.Aql;
                            Context context2 = this.Vat.AyY.parent.getContext();
                            kotlin.g.b.p.g(context2, "parent.context");
                            com.tencent.mm.plugin.mv.a.k.a(context2, axy, eVar, 2, 3, 1);
                        }
                    }
                    AppMethodBeat.o(259293);
                }
            }
        });
        ViewGroup ewA = ewA();
        kotlin.g.b.p.g(ewA, "songInfoFullScreenRoot");
        ewA.setVisibility(8);
        RoundCornerRelativeLayout ewB3 = ewB();
        kotlin.g.b.p.g(ewB3, "dialogRootLayout");
        ewB3.setTranslationY(-1.0f * ((float) this.uZv));
        Log.i(TAG, "init layout height:" + i2 + ", screenSize:" + gx);
        MMImageView ewG = ewG();
        kotlin.g.b.p.g(ewG, "coverIv");
        Drawable drawable = ewG.getDrawable();
        BlurView ewH = ewH();
        if (ewH != null) {
            ewH.L(ewB()).F(drawable).b(new com.tencent.mm.ui.blur.f(ewH.getContext())).cw(30.0f).gMr().cv((float) com.tencent.mm.cb.a.aG(ewH.getContext(), R.dimen.ct)).gMs().alW(Color.parseColor("#61D2D2D2"));
        }
        BlurView ewM = ewM();
        if (ewM != null) {
            ewM.L(ewB()).F(drawable).b(new com.tencent.mm.ui.blur.f(ewM.getContext())).cw(50.0f).gMr().cv((float) com.tencent.mm.cb.a.aG(ewM.getContext(), R.dimen.ct)).gMs().alW(Color.parseColor("#61D2D2D2"));
        }
        View ewD = ewD();
        kotlin.g.b.p.g(ewD, "topGradientMask");
        ViewGroup.LayoutParams layoutParams2 = ewD.getLayoutParams();
        layoutParams2.height = (int) (((double) this.uZv) * 0.3d);
        View ewD2 = ewD();
        kotlin.g.b.p.g(ewD2, "topGradientMask");
        ewD2.setLayoutParams(layoutParams2);
        View ewC = ewC();
        kotlin.g.b.p.g(ewC, "bottomMask");
        ewC.setAlpha(0.0f);
        ewI().setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.mv.ui.view.f.AnonymousClass2 */
            final /* synthetic */ f AyY;

            {
                this.AyY = r1;
            }

            /* JADX WARNING: Removed duplicated region for block: B:17:0x009a  */
            /* JADX WARNING: Removed duplicated region for block: B:23:0x00c9  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onClick(android.view.View r19) {
                /*
                // Method dump skipped, instructions count: 823
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mv.ui.view.f.AnonymousClass2.onClick(android.view.View):void");
            }
        });
        ((View) this.AyV.getValue()).setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.mv.ui.view.f.AnonymousClass3 */
            final /* synthetic */ f AyY;

            {
                this.AyY = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(257616);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.AyY.hide();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(257616);
            }
        });
        SpannableString spannableString = new SpannableString(this.parent.getContext().getString(R.string.f09));
        int a2 = kotlin.n.n.a((CharSequence) spannableString, "{music}", 0, false, 6);
        Context context = this.parent.getContext();
        kotlin.g.b.p.g(context, "parent.context");
        Drawable drawable2 = context.getResources().getDrawable(R.raw.icons_music_staus_share);
        kotlin.g.b.p.g(drawable2, "drawable");
        int intrinsicWidth = drawable2.getIntrinsicWidth();
        int aG2 = com.tencent.mm.cb.a.aG(this.parent.getContext(), R.dimen.cc);
        Context context2 = this.parent.getContext();
        kotlin.g.b.p.g(context2, "parent.context");
        Drawable a3 = com.tencent.mm.svg.a.a.a(context2.getResources(), (int) R.raw.icons_music_staus_share, (1.0f * ((float) aG2)) / ((float) intrinsicWidth));
        PorterDuffColorFilter porterDuffColorFilter = new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
        kotlin.g.b.p.g(a3, "scaleDrawable");
        a3.setColorFilter(porterDuffColorFilter);
        a3.setBounds(0, 0, aG2, aG2);
        spannableString.setSpan(new a(a3), a2, "{music}".length() + a2, 17);
        Button ewI = ewI();
        kotlin.g.b.p.g(ewI, "statusButton");
        ewI.setText(spannableString);
        this.dEF = false;
        AppMethodBeat.o(257653);
    }

    public static final /* synthetic */ ViewGroup a(f fVar) {
        AppMethodBeat.i(257655);
        ViewGroup ewA = fVar.ewA();
        AppMethodBeat.o(257655);
        return ewA;
    }

    public static final /* synthetic */ BlurView e(f fVar) {
        AppMethodBeat.i(257657);
        BlurView ewH = fVar.ewH();
        AppMethodBeat.o(257657);
        return ewH;
    }

    public static final /* synthetic */ BlurView f(f fVar) {
        AppMethodBeat.i(257658);
        BlurView ewM = fVar.ewM();
        AppMethodBeat.o(257658);
        return ewM;
    }

    static {
        AppMethodBeat.i(257654);
        AppMethodBeat.o(257654);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$show$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-mv_release"})
    public static final class m extends AnimatorListenerAdapter {
        final /* synthetic */ f AyY;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public m(f fVar) {
            this.AyY = fVar;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(257629);
            Log.i(f.TAG, "onShow animate end");
            this.AyY.dEF = true;
            AppMethodBeat.o(257629);
        }
    }

    public final void hide() {
        AppMethodBeat.i(257651);
        String str = TAG;
        StringBuilder append = new StringBuilder("hide song info dialog, isShow:").append(this.dEF).append(", translateY:");
        RoundCornerRelativeLayout ewB = ewB();
        kotlin.g.b.p.g(ewB, "dialogRootLayout");
        Log.i(str, append.append(ewB.getTranslationY()).toString());
        if (this.dEF) {
            Log.i(TAG, "do hide");
            ewB().animate().translationY(-1.0f * ((float) this.uZv)).setDuration(300).setListener(new k(this)).start();
            ewC().animate().alpha(0.0f).setDuration(300);
        }
        AppMethodBeat.o(257651);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/mv/ui/view/MusicMvSongInfoDialog$hide$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-mv_release"})
    public static final class k extends AnimatorListenerAdapter {
        final /* synthetic */ f AyY;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        k(f fVar) {
            this.AyY = fVar;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(257626);
            Log.i(f.TAG, "onHide animate end");
            ViewGroup a2 = f.a(this.AyY);
            kotlin.g.b.p.g(a2, "songInfoFullScreenRoot");
            a2.setVisibility(8);
            this.AyY.dEF = false;
            AppMethodBeat.o(257626);
        }
    }

    public static String d(axy axy) {
        boolean z;
        AppMethodBeat.i(257652);
        try {
            String str = axy.LIj;
            if (!(str == null || str.length() == 0)) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TimeUtil.YYYY2MM2DD_HH1MM1SS, Locale.ENGLISH);
                String str2 = axy.LIj;
                if (str2 == null) {
                    str2 = "";
                }
                Date parse = simpleDateFormat.parse(str2);
                if (parse != null) {
                    String format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(parse);
                    kotlin.g.b.p.g(format, "targetSdf.format(date)");
                    AppMethodBeat.o(257652);
                    return format;
                }
                String str3 = axy.LIj;
                if (str3 == null) {
                    str3 = "";
                }
                AppMethodBeat.o(257652);
                return str3;
            }
            if (axy.LIk > 0) {
                String format2 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(Long.valueOf(axy.LIk * 1000));
                String str4 = format2;
                if (str4 == null || str4.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    AppMethodBeat.o(257652);
                    return format2;
                }
            }
            AppMethodBeat.o(257652);
            return "";
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "parse public time error", new Object[0]);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
    static final class o extends kotlin.g.b.q implements kotlin.g.a.a<ViewGroup> {
        final /* synthetic */ f AyY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(f fVar) {
            super(0);
            this.AyY = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ViewGroup invoke() {
            AppMethodBeat.i(257631);
            ViewGroup viewGroup = (ViewGroup) this.AyY.parent.findViewById(R.id.i2b);
            AppMethodBeat.o(257631);
            return viewGroup;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/ui/widget/RoundCornerRelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class j extends kotlin.g.b.q implements kotlin.g.a.a<RoundCornerRelativeLayout> {
        final /* synthetic */ f AyY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(f fVar) {
            super(0);
            this.AyY = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ RoundCornerRelativeLayout invoke() {
            AppMethodBeat.i(257625);
            RoundCornerRelativeLayout roundCornerRelativeLayout = (RoundCornerRelativeLayout) this.AyY.parent.findViewById(R.id.i2d);
            AppMethodBeat.o(257625);
            return roundCornerRelativeLayout;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ f AyY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(f fVar) {
            super(0);
            this.AyY = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(257617);
            View findViewById = this.AyY.parent.findViewById(R.id.aav);
            AppMethodBeat.o(257617);
            return findViewById;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class u extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ f AyY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        u(f fVar) {
            super(0);
            this.AyY = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(257637);
            View findViewById = this.AyY.parent.findViewById(R.id.isx);
            AppMethodBeat.o(257637);
            return findViewById;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class p extends kotlin.g.b.q implements kotlin.g.a.a<MusicMvMarqueeTextView> {
        final /* synthetic */ f AyY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(f fVar) {
            super(0);
            this.AyY = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MusicMvMarqueeTextView invoke() {
            AppMethodBeat.i(257632);
            MusicMvMarqueeTextView musicMvMarqueeTextView = (MusicMvMarqueeTextView) this.AyY.parent.findViewById(R.id.i2g);
            AppMethodBeat.o(257632);
            return musicMvMarqueeTextView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class n extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ f AyY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(f fVar) {
            super(0);
            this.AyY = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(257630);
            TextView textView = (TextView) this.AyY.parent.findViewById(R.id.hs9);
            AppMethodBeat.o(257630);
            return textView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/ui/MMImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class h extends kotlin.g.b.q implements kotlin.g.a.a<MMImageView> {
        final /* synthetic */ f AyY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(f fVar) {
            super(0);
            this.AyY = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MMImageView invoke() {
            AppMethodBeat.i(257623);
            MMImageView mMImageView = (MMImageView) this.AyY.parent.findViewById(R.id.bqu);
            AppMethodBeat.o(257623);
            return mMImageView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class i extends kotlin.g.b.q implements kotlin.g.a.a<WeImageView> {
        final /* synthetic */ f AyY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(f fVar) {
            super(0);
            this.AyY = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ WeImageView invoke() {
            AppMethodBeat.i(257624);
            WeImageView weImageView = (WeImageView) this.AyY.parent.findViewById(R.id.blb);
            AppMethodBeat.o(257624);
            return weImageView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
    static final class q extends kotlin.g.b.q implements kotlin.g.a.a<ViewGroup> {
        final /* synthetic */ f AyY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(f fVar) {
            super(0);
            this.AyY = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ViewGroup invoke() {
            AppMethodBeat.i(257633);
            ViewGroup viewGroup = (ViewGroup) this.AyY.parent.findViewById(R.id.i3e);
            AppMethodBeat.o(257633);
            return viewGroup;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvMarqueeTextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class r extends kotlin.g.b.q implements kotlin.g.a.a<MusicMvMarqueeTextView> {
        final /* synthetic */ f AyY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(f fVar) {
            super(0);
            this.AyY = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MusicMvMarqueeTextView invoke() {
            AppMethodBeat.i(257634);
            MusicMvMarqueeTextView musicMvMarqueeTextView = (MusicMvMarqueeTextView) this.AyY.parent.findViewById(R.id.i3f);
            AppMethodBeat.o(257634);
            return musicMvMarqueeTextView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/ui/blur/BlurView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class t extends kotlin.g.b.q implements kotlin.g.a.a<BlurView> {
        final /* synthetic */ f AyY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        t(f fVar) {
            super(0);
            this.AyY = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ BlurView invoke() {
            AppMethodBeat.i(257636);
            BlurView blurView = (BlurView) this.AyY.parent.findViewById(R.id.i5_);
            AppMethodBeat.o(257636);
            return blurView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "invoke"})
    static final class s extends kotlin.g.b.q implements kotlin.g.a.a<Button> {
        final /* synthetic */ f AyY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        s(f fVar) {
            super(0);
            this.AyY = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Button invoke() {
            AppMethodBeat.i(257635);
            Button button = (Button) this.AyY.parent.findViewById(R.id.hld);
            AppMethodBeat.o(257635);
            return button;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
    /* renamed from: com.tencent.mm.plugin.mv.ui.view.f$f  reason: collision with other inner class name */
    static final class C1562f extends kotlin.g.b.q implements kotlin.g.a.a<ViewGroup> {
        final /* synthetic */ f AyY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1562f(f fVar) {
            super(0);
            this.AyY = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ViewGroup invoke() {
            AppMethodBeat.i(257621);
            ViewGroup viewGroup = (ViewGroup) this.AyY.parent.findViewById(R.id.bg7);
            AppMethodBeat.o(257621);
            return viewGroup;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/ui/widget/MMRoundCornerImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class g extends kotlin.g.b.q implements kotlin.g.a.a<MMRoundCornerImageView> {
        final /* synthetic */ f AyY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(f fVar) {
            super(0);
            this.AyY = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MMRoundCornerImageView invoke() {
            AppMethodBeat.i(257622);
            MMRoundCornerImageView mMRoundCornerImageView = (MMRoundCornerImageView) this.AyY.parent.findViewById(R.id.i29);
            AppMethodBeat.o(257622);
            return mMRoundCornerImageView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class e extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ f AyY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(f fVar) {
            super(0);
            this.AyY = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(257620);
            TextView textView = (TextView) this.AyY.parent.findViewById(R.id.bg6);
            AppMethodBeat.o(257620);
            return textView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/ui/blur/BlurView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<BlurView> {
        final /* synthetic */ f AyY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(f fVar) {
            super(0);
            this.AyY = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ BlurView invoke() {
            AppMethodBeat.i(257619);
            BlurView blurView = (BlurView) this.AyY.parent.findViewById(R.id.i28);
            AppMethodBeat.o(257619);
            return blurView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ f AyY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(f fVar) {
            super(0);
            this.AyY = fVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(257618);
            View findViewById = this.AyY.parent.findViewById(R.id.b5n);
            AppMethodBeat.o(257618);
            return findViewById;
        }
    }

    public static final /* synthetic */ WeImageView d(f fVar) {
        AppMethodBeat.i(257656);
        WeImageView weImageView = (WeImageView) fVar.AyM.getValue();
        AppMethodBeat.o(257656);
        return weImageView;
    }
}
