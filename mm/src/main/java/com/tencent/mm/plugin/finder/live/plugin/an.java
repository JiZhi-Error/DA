package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.live.model.cgi.o;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.live.viewmodel.i;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.avy;
import com.tencent.mm.protocal.protobuf.awi;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010K\u001a\u00020\u001bH\u0002J\b\u0010L\u001a\u00020BH\u0016J\b\u0010M\u001a\u00020\u001bH\u0016J\u0014\u0010N\u001a\u00020\u001b2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020\u001b0PJ\b\u0010Q\u001a\u00020\u001bH\u0002J\b\u0010R\u001a\u00020\u001bH\u0016J\b\u0010S\u001a\u00020BH\u0002J\u0006\u0010T\u001a\u00020\u001bJ\u0010\u0010U\u001a\u00020\u001b2\u0006\u0010V\u001a\u00020BH\u0002J\u0018\u0010W\u001a\u00020\u001b2\u0006\u0010V\u001a\u00020B2\u0006\u0010X\u001a\u00020YH\u0016JA\u0010Z\u001a\u00020\u001b2\u0006\u0010X\u001a\u00020Y2\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010[\u001a\u00020\\2!\u0010O\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u0016J\b\u0010]\u001a\u00020\u001bH\u0016J\u0010\u0010^\u001a\u00020\u001b2\u0006\u0010_\u001a\u00020\\H\u0016J\u0014\u0010`\u001a\u00020\u001b2\f\u0010O\u001a\b\u0012\u0004\u0012\u00020\u001b0PJ\u001a\u0010V\u001a\u00020\u001b2\u0006\u0010[\u001a\u00020a2\b\u0010b\u001a\u0004\u0018\u00010cH\u0016J\b\u0010d\u001a\u00020\u001bH\u0016J\b\u0010e\u001a\u00020\u001bH\u0002R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\nR7\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001c\u00108\u001a\u0004\u0018\u000103X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u00105\"\u0004\b:\u00107R\u001c\u0010;\u001a\u0004\u0018\u00010<X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010A\u001a\u00020BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010\u001a\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006f"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "BIG_ANIMATION_FILE", "", "getBIG_ANIMATION_FILE", "()Ljava/lang/String;", "LANDSCAPE_SCALE_SIZE", "", "getLANDSCAPE_SCALE_SIZE", "()F", "PORTRAIT_HEIGHT", "getPORTRAIT_HEIGHT", "PORTRAIT_WIDTH", "getPORTRAIT_WIDTH", "TAG", "getTAG", "animationCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "Lkotlin/ParameterName;", "name", "lotteryInfo", "", "getAnimationCallback", "()Lkotlin/jvm/functions/Function1;", "setAnimationCallback", "(Lkotlin/jvm/functions/Function1;)V", "bigAnim", "Lorg/libpag/PAGView;", "getBigAnim", "()Lorg/libpag/PAGView;", "setBigAnim", "(Lorg/libpag/PAGView;)V", "bigAnimContainer", "Landroid/widget/FrameLayout;", "getBigAnimContainer", "()Landroid/widget/FrameLayout;", "setBigAnimContainer", "(Landroid/widget/FrameLayout;)V", "bigAnimListener", "Lcom/tencent/mm/plugin/finder/live/plugin/BigAnimListener;", "getBigAnimListener", "()Lcom/tencent/mm/plugin/finder/live/plugin/BigAnimListener;", "setBigAnimListener", "(Lcom/tencent/mm/plugin/finder/live/plugin/BigAnimListener;)V", "card", "Landroid/view/View;", "getCard", "()Landroid/view/View;", "setCard", "(Landroid/view/View;)V", "cardContainer", "getCardContainer", "setCardContainer", "closeBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getCloseBtn", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setCloseBtn", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "lottering", "", "getLottering", "()Z", "setLottering", "(Z)V", "getLotteryInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;", "setLotteryInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveLotteryInfo;)V", "adjustLayout", "canClearScreen", "changeToUnvisible", "getLotteryRecord", "callback", "Lkotlin/Function0;", "initBigAnim", "initView", "isLotteryFinish", "onCloseClick", bv.NAME, "statusChange", "openCardImpl", "lotteryInfoWrapper", "Lcom/tencent/mm/plugin/finder/live/viewmodel/LotteryInfoWrapper;", "playLotteringAnim", "status", "", "reset", "setVisible", "visible", "showLottering", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "unMount", "updateCard", "plugin-finder_release"})
public abstract class an extends d {
    private final String TAG = "FinderLiveLotteryCardPlugin";
    private final com.tencent.mm.live.c.b hOp;
    private WeImageView hPb;
    awi tWe = new awi();
    private final float urN = 0.81f;
    private final float urO = 320.0f;
    private final float urP = 424.0f;
    private final String urQ = "big_lottery_anim.pag";
    FrameLayout urR;
    PAGView urS;
    volatile boolean urT;
    private a urU;
    View urV;
    View urW;
    kotlin.g.a.b<? super awi, x> urX;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public an(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        this.hOp = bVar;
        y yVar = y.vXH;
        y.awu("FinderLiveLotteryCardPlugin");
        initView();
    }

    public String getTAG() {
        return this.TAG;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class b implements View.OnClickListener {
        final /* synthetic */ an urY;

        b(an anVar) {
            this.urY = anVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(246843);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.urY.dhw();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(246843);
        }
    }

    public void initView() {
        this.hwr.setOnClickListener(new b(this));
        this.urV = this.hwr.findViewById(R.id.alm);
        this.urW = this.hwr.findViewById(R.id.ajh);
        this.urR = (FrameLayout) this.hwr.findViewById(R.id.cu7);
        this.hPb = (WeImageView) this.hwr.findViewById(R.id.b3z);
        WeImageView weImageView = this.hPb;
        if (weImageView != null) {
            weImageView.setOnClickListener(new c(this));
        }
        if (isLandscape()) {
            float f2 = ((float) au.az(this.hwr.getContext()).y) * this.urN;
            int e2 = com.tencent.mm.view.d.e(MMApplicationContext.getContext(), this.urP);
            float f3 = f2 / ((float) e2);
            if (f3 <= 0.0f) {
                Log.i(getTAG(), "adjustLayout invalid scale:" + f3 + ",targetHeight:" + f2 + ",sourceHeight:" + e2);
                return;
            }
            int e3 = com.tencent.mm.view.d.e(MMApplicationContext.getContext(), this.urO);
            float f4 = ((float) e3) * f3;
            float f5 = ((float) e2) - f2;
            float f6 = ((float) e3) - f4;
            float f7 = f5 / 2.0f;
            float f8 = -(f6 / 2.0f);
            Log.i(getTAG(), "adjustLayout targetHeight:" + f2 + ",targetWidth:" + f4 + ",sourceHeight:" + e2 + ",sourceWidth:" + e3 + ',' + "scale:" + f3 + ",diffHeight:" + f5 + ",translationY:" + f7 + ",diffWidth:" + f6 + ',' + f8);
            View view = this.urW;
            if (view != null) {
                view.setScaleX(f3);
            }
            View view2 = this.urW;
            if (view2 != null) {
                view2.setScaleY(f3);
            }
            WeImageView weImageView2 = this.hPb;
            if (weImageView2 != null) {
                weImageView2.setTranslationY(f7);
            }
            WeImageView weImageView3 = this.hPb;
            if (weImageView3 != null) {
                weImageView3.setTranslationX(f8);
                return;
            }
            return;
        }
        View view3 = this.urW;
        if (view3 != null) {
            view3.setScaleX(1.0f);
        }
        View view4 = this.urW;
        if (view4 != null) {
            view4.setScaleY(1.0f);
        }
        WeImageView weImageView4 = this.hPb;
        if (weImageView4 != null) {
            weImageView4.setTranslationY(0.0f);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class c implements View.OnClickListener {
        final /* synthetic */ an urY;

        c(an anVar) {
            this.urY = anVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(246844);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.urY.dhw();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(246844);
        }
    }

    private final void dhv() {
        if (this.urS == null) {
            this.urS = new PAGView(this.hwr.getContext());
            this.urU = new a(this);
            PAGView pAGView = this.urS;
            if (pAGView != null) {
                pAGView.addListener(this.urU);
            }
        }
        FrameLayout frameLayout = this.urR;
        if (frameLayout != null && frameLayout.indexOfChild(this.urS) == -1) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            PAGView pAGView2 = this.urS;
            if (pAGView2 != null) {
                pAGView2.setLayoutParams(layoutParams);
            }
            PAGView pAGView3 = this.urS;
            if (pAGView3 != null) {
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                Resources resources = context.getResources();
                p.g(resources, "MMApplicationContext.getContext().resources");
                pAGView3.setFile(PAGFile.Load(resources.getAssets(), this.urQ));
            }
            FrameLayout frameLayout2 = this.urR;
            if (frameLayout2 != null) {
                frameLayout2.addView(this.urS);
            }
            FrameLayout frameLayout3 = this.urR;
            if (frameLayout3 != null) {
                frameLayout3.setClickable(true);
            }
        }
    }

    public final void a(i iVar, awi awi, int i2, kotlin.g.a.b<? super awi, x> bVar) {
        p.h(iVar, "lotteryInfoWrapper");
        p.h(awi, "lotteryInfo");
        p.h(bVar, "callback");
        this.urX = bVar;
        this.tWe = awi;
        boolean z = iVar.uFs;
        boolean z2 = this.hwr.getVisibility() == 0;
        com.tencent.mm.kernel.b.a ah = g.ah(PluginFinder.class);
        p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
        boolean isPagEnable = ((PluginFinder) ah).isPagEnable();
        String tag = getTAG();
        StringBuilder append = new StringBuilder("playLotteringAnim id:").append(awi.id).append(" status:").append(i2).append(", haveLottering:").append(z).append(", isCardShowing:").append(z2).append(", lottering:").append(this.urT).append(",callback:");
        kotlin.g.a.b<? super awi, x> bVar2 = this.urX;
        Log.i(tag, append.append(bVar2 != null ? Integer.valueOf(bVar2.hashCode()) : null).append(",isPagEnable:").append(isPagEnable).toString());
        if (!this.urT) {
            if (!isPagEnable) {
                kotlin.g.a.b<? super awi, x> bVar3 = this.urX;
                if (bVar3 != null) {
                    bVar3.invoke(this.tWe);
                }
            } else if (z) {
                kotlin.g.a.b<? super awi, x> bVar4 = this.urX;
                if (bVar4 != null) {
                    bVar4.invoke(this.tWe);
                }
            } else {
                iVar.uFs = true;
                if (z2) {
                    kotlin.g.a.b<? super awi, x> bVar5 = this.urX;
                    if (bVar5 != null) {
                        bVar5.invoke(this.tWe);
                        return;
                    }
                    return;
                }
                this.urT = true;
                P(new d(this, awi, i2));
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/live/plugin/FinderLiveLotteryCardPlugin$getLotteryRecord$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLotteryRecord$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetLotteryRecordResponse;", "plugin-finder_release"})
    public static final class a implements o.a {
        final /* synthetic */ kotlin.g.a.a ihE;
        final /* synthetic */ an urY;

        a(an anVar, kotlin.g.a.a aVar) {
            this.urY = anVar;
            this.ihE = aVar;
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.o.a
        public final void a(int i2, int i3, String str, avy avy) {
            AppMethodBeat.i(246842);
            p.h(avy, "resp");
            if (i2 == 0 && i3 == 0) {
                this.urY.getLiveData().a(avy.tWe);
                this.urY.getLiveData().d(avy);
            }
            this.ihE.invoke();
            AppMethodBeat.o(246842);
        }
    }

    private void P(kotlin.g.a.a<x> aVar) {
        p.h(aVar, "callback");
        reset();
        dhv();
        rg(0);
        View view = this.urV;
        if (view != null) {
            view.setVisibility(4);
        }
        a aVar2 = this.urU;
        if (aVar2 != null) {
            aVar2.N(aVar);
        }
        PAGView pAGView = this.urS;
        if (pAGView != null) {
            pAGView.setProgress(0.0d);
        }
        PAGView pAGView2 = this.urS;
        if (pAGView2 != null) {
            pAGView2.flush();
        }
        PAGView pAGView3 = this.urS;
        if (pAGView3 != null) {
            pAGView3.play();
        }
    }

    public final void dhw() {
        rg(8);
        b.C0376b.a(this.hOp, b.c.hNG);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        return false;
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final void reset() {
        PAGView pAGView;
        PAGView pAGView2 = this.urS;
        if (pAGView2 != null && pAGView2.isPlaying() && (pAGView = this.urS) != null) {
            pAGView.stop();
        }
    }

    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        awi awi;
        boolean z;
        awi awi2 = null;
        boolean z2 = true;
        p.h(cVar, "status");
        switch (ao.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
                if (bundle != null) {
                    z = bundle.getBoolean("PARAM_FINDER_LIVE_LOTTERY_CARD_SHOW_STATUS");
                } else {
                    z = true;
                }
                i iVar = getLiveData().uEa;
                if (iVar != null) {
                    awi2 = iVar.tWe;
                }
                if (awi2 != null) {
                    a(z, iVar);
                    return;
                }
                rg(8);
                String tag = getTAG();
                StringBuilder append = new StringBuilder("openCard statusChange:").append(z).append(" lotteryInfo is empty:");
                if (this.tWe != null) {
                    z2 = false;
                }
                Log.i(tag, append.append(z2).append('!').toString());
                return;
            case 2:
                rg(4);
                return;
            case 3:
                if (this.hwr.getVisibility() == 0) {
                    i iVar2 = getLiveData().uEa;
                    if (iVar2 != null) {
                        awi = iVar2.tWe;
                    } else {
                        awi = null;
                    }
                    if (awi != null) {
                        a(false, iVar2);
                        return;
                    }
                    rg(8);
                    Log.i(getTAG(), "updateCard lotteryInfo is empty!");
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void unMount() {
        super.unMount();
        reset();
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void rg(int i2) {
        Boolean bool;
        boolean z;
        awi awi;
        String str = null;
        int visibility = this.hwr.getVisibility();
        boolean dhy = dhy();
        i iVar = getLiveData().uEa;
        Boolean valueOf = iVar != null ? Boolean.valueOf(iVar.uFv) : null;
        i iVar2 = getLiveData().uEa;
        if (iVar2 != null) {
            bool = Boolean.valueOf(iVar2.uFt);
        } else {
            bool = null;
        }
        int size = getLiveData().uDZ.size();
        Log.i(getTAG(), "curVisibility:" + visibility + ",lastVisibility:" + i2 + ",lastDoneLottery:" + bool + ",remoteSize:" + size + ",isLotteryFinish:" + dhy + ",bubbleFinish:" + valueOf);
        if (visibility == 0 && i2 != 0) {
            if (dhy && (p.j(valueOf, Boolean.TRUE) || size > 1)) {
                com.tencent.mm.plugin.finder.live.viewmodel.g liveData = getLiveData();
                i iVar3 = getLiveData().uEa;
                if (!(iVar3 == null || (awi = iVar3.tWe) == null)) {
                    str = awi.id;
                }
                liveData.bj(str, getLiveData().djh());
            }
            com.tencent.mm.live.c.b bVar = this.hOp;
            b.c cVar = b.c.hNC;
            Bundle bundle = new Bundle();
            bundle.putBoolean("PARAM_FINDER_LIVE_LOTTERY_VISIBILITY_CACHE", true);
            bVar.statusChange(cVar, bundle);
            dhx();
        }
        i iVar4 = getLiveData().uEa;
        if (iVar4 != null) {
            if (i2 == 0) {
                z = true;
            } else {
                z = false;
            }
            iVar4.uFu = z;
        }
        super.rg(i2);
    }

    public void dhx() {
        Log.i(getTAG(), "changeToUnvisible");
    }

    private final boolean dhy() {
        i iVar;
        i iVar2 = getLiveData().uEa;
        return (iVar2 == null || iVar2.uhD != 1) && ((iVar = getLiveData().uEa) == null || iVar.uhD != 2);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ int hbA;
        final /* synthetic */ awi uhK;
        final /* synthetic */ an urY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(an anVar, awi awi, int i2) {
            super(0);
            this.urY = anVar;
            this.uhK = awi;
            this.hbA = i2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(246845);
            this.urY.urT = false;
            String tag = this.urY.getTAG();
            StringBuilder append = new StringBuilder("playLotteringAnim done, id:").append(this.uhK.id).append(",status:").append(this.hbA).append(",callback:");
            kotlin.g.a.b<? super awi, x> bVar = this.urY.urX;
            Log.i(tag, append.append(bVar != null ? Integer.valueOf(bVar.hashCode()) : null).toString());
            kotlin.g.a.b<? super awi, x> bVar2 = this.urY.urX;
            if (bVar2 != null) {
                bVar2.invoke(this.urY.tWe);
            }
            View view = this.urY.urV;
            if (view != null) {
                view.setVisibility(0);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(246845);
            return xVar;
        }
    }

    public final void O(kotlin.g.a.a<x> aVar) {
        String str;
        awi awi;
        String str2;
        p.h(aVar, "callback");
        com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
        s finderLiveAssistant = com.tencent.mm.plugin.finder.live.model.o.getFinderLiveAssistant();
        if (finderLiveAssistant != null) {
            i iVar = getLiveData().uEa;
            if (iVar == null || (awi = iVar.tWe) == null || (str2 = awi.id) == null) {
                str = "";
            } else {
                str = str2;
            }
            finderLiveAssistant.a(str, (com.tencent.mm.bw.b) null, new a(this, aVar));
        }
    }

    public void a(boolean z, i iVar) {
        p.h(iVar, "lotteryInfoWrapper");
        switch (iVar.uhD) {
            case 2:
                com.tencent.mm.live.c.b bVar = this.hOp;
                b.c cVar = b.c.hND;
                Bundle bundle = new Bundle();
                bundle.putBoolean("PARAM_FINDER_LIVE_LOTTERY_VISIBILITY_CACHE", true);
                bVar.statusChange(cVar, bundle);
                return;
            case 3:
                com.tencent.mm.live.c.b bVar2 = this.hOp;
                b.c cVar2 = b.c.hND;
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean("PARAM_FINDER_LIVE_LOTTERY_VISIBILITY_CACHE", true);
                bVar2.statusChange(cVar2, bundle2);
                com.tencent.mm.plugin.finder.live.viewmodel.g liveData = getLiveData();
                awi awi = iVar.tWe;
                liveData.atY(awi != null ? awi.id : null);
                return;
            default:
                return;
        }
    }
}
