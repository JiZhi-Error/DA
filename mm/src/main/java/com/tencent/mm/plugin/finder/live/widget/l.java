package com.tencent.mm.plugin.finder.live.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.finder.live.model.v;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.protocal.protobuf.ffq;
import com.tencent.mm.protocal.protobuf.fhd;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.d;
import com.tencent.neattextview.textview.view.NeatTextView;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.t;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u00106\u001a\u000207H\u0002J\u0006\u00108\u001a\u000207J\b\u00109\u001a\u000207H\u0002J\b\u0010:\u001a\u000207H\u0002J\u0010\u0010;\u001a\u0002072\u0006\u0010<\u001a\u00020=H\u0002J \u0010>\u001a\u0002072\u0006\u0010?\u001a\u00020*2\u0006\u0010@\u001a\u00020\u000f2\u0006\u0010A\u001a\u00020\u000fH\u0002J\u0010\u0010B\u001a\u0002072\u0006\u0010C\u001a\u00020\u000bH\u0016J\u0010\u0010D\u001a\u0002072\u0006\u0010E\u001a\u00020FH\u0002J\u0010\u0010D\u001a\u0002072\u0006\u0010E\u001a\u00020GH\u0002J\b\u0010H\u001a\u000207H\u0002J\u0010\u0010I\u001a\u0002072\b\u0010#\u001a\u0004\u0018\u00010$R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\u0012\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0014\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\rR\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u00102\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\r\"\u0004\b4\u00105¨\u0006J"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingWidget;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "entranceRoot", "Landroid/view/ViewGroup;", "parent", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/content/Context;Landroid/view/ViewGroup;Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "ANCHOR_TAKE_PLACE_HEIGHT", "", "getANCHOR_TAKE_PLACE_HEIGHT", "()I", "TAG", "", "VISITOR_TAKE_PLACE_HEIGHT", "getVISITOR_TAKE_PLACE_HEIGHT", "WIDEGET_HEGIHT", "getWIDEGET_HEGIHT", "WIDEGET_PADDING", "getWIDEGET_PADDING", "adButton", "Landroid/widget/TextView;", "adContainer", "Landroid/view/View;", "adDescTv", "arrow", "bubbleHideAnim", "Landroid/animation/ObjectAnimator;", "bubbleShowAnim", "close", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "container", "descContainer", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "setLiveData", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;)V", "productDesc", "Lcom/tencent/neattextview/textview/view/NeatTextView;", "productImg", "Landroid/widget/ImageView;", "productPrice", "promotingContainer", "promotingWidget", "Lcom/tencent/mm/plugin/finder/view/FinderLiveOnliveWidget;", "root", "takePlaceHeight", "getTakePlaceHeight", "setTakePlaceHeight", "(I)V", "addToParent", "", "adjustVisitorBubbleLayout", "hideShoppingBubble", "hideShoppingBubbleAnim", "notifyShoppingBubbleAction", "show", "", "setProductDesc", "productDescTv", "shopName", "goodsDesc", "setVisibility", "visibility", "showShoppingBubble", "data", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShopWindowAdItem;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveShopWindowProductItem;", "showShoppingBubbleAnim", "updateShoppingBubble", "plugin-finder_release"})
public final class l extends FrameLayout {
    public final String TAG = "Finder.LiveShoppingWidget";
    public View USk;
    public TextView USl;
    public TextView USm;
    private View gvQ;
    public final com.tencent.mm.live.c.b hOp;
    public g liveData;
    private final ViewGroup parent;
    public ImageView uBJ;
    public TextView uBN;
    private final int uHe = d.e(MMApplicationContext.getContext(), 74.0f);
    private final int uHf = d.e(MMApplicationContext.getContext(), 2.0f);
    private final int uHg = (this.uHe + d.e(MMApplicationContext.getContext(), 20.0f));
    private final int uHh = d.e(MMApplicationContext.getContext(), 12.0f);
    public View uHi;
    public View uHj;
    public FinderLiveOnliveWidget uHk;
    public NeatTextView uHl;
    public WeImageView uHm;
    private ObjectAnimator uHn;
    private ObjectAnimator uHo;
    private int uHp = this.uHg;
    public final ViewGroup uHq;
    public View uhh;
    public ViewGroup ulG;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(Context context, ViewGroup viewGroup, ViewGroup viewGroup2, com.tencent.mm.live.c.b bVar) {
        super(context);
        p.h(context, "context");
        p.h(viewGroup, "entranceRoot");
        p.h(viewGroup2, "parent");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(248144);
        this.uHq = viewGroup;
        this.parent = viewGroup2;
        this.hOp = bVar;
        View inflate = LayoutInflater.from(context).inflate(R.layout.afd, (ViewGroup) this, true);
        p.g(inflate, "LayoutInflater.from(cont…ng_widget_ui, this, true)");
        this.gvQ = inflate;
        View findViewById = this.gvQ.findViewById(R.id.gi6);
        p.g(findViewById, "root.findViewById(R.id.product_img)");
        this.uBJ = (ImageView) findViewById;
        View findViewById2 = this.gvQ.findViewById(R.id.glt);
        p.g(findViewById2, "root.findViewById(R.id.promoting_container)");
        this.uHj = findViewById2;
        View findViewById3 = this.gvQ.findViewById(R.id.gls);
        p.g(findViewById3, "root.findViewById(R.id.promoting)");
        this.uHk = (FinderLiveOnliveWidget) findViewById3;
        View findViewById4 = this.gvQ.findViewById(R.id.bmz);
        p.g(findViewById4, "root.findViewById(R.id.desc_container)");
        this.uhh = findViewById4;
        View findViewById5 = this.gvQ.findViewById(R.id.ghs);
        p.g(findViewById5, "root.findViewById(R.id.product_desc)");
        this.uHl = (NeatTextView) findViewById5;
        View findViewById6 = this.gvQ.findViewById(R.id.gi8);
        p.g(findViewById6, "root.findViewById(R.id.product_price)");
        this.uBN = (TextView) findViewById6;
        this.USk = this.gvQ.findViewById(R.id.jt_);
        this.USl = (TextView) this.gvQ.findViewById(R.id.jt9);
        this.USm = (TextView) this.gvQ.findViewById(R.id.jt8);
        y yVar = y.vXH;
        y.q(this.uBN);
        View findViewById7 = this.gvQ.findViewById(R.id.b3z);
        p.g(findViewById7, "root.findViewById(R.id.close)");
        this.uHm = (WeImageView) findViewById7;
        WeImageView weImageView = this.uHm;
        if (weImageView != null) {
            int aH = com.tencent.mm.cb.a.aH(context, R.dimen.cb);
            Rect rect = new Rect();
            weImageView.getHitRect(rect);
            rect.inset(-aH, (-aH) / 2);
            ViewParent parent2 = weImageView.getParent();
            if (parent2 == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.View");
                AppMethodBeat.o(248144);
                throw tVar;
            }
            ((View) parent2).setTouchDelegate(new TouchDelegate(rect, weImageView));
        }
        WeImageView weImageView2 = this.uHm;
        if (weImageView2 != null) {
            weImageView2.setOnClickListener(new View.OnClickListener(this) {
                /* class com.tencent.mm.plugin.finder.live.widget.l.AnonymousClass1 */
                final /* synthetic */ l uHr;

                {
                    this.uHr = r1;
                }

                public final void onClick(View view) {
                    bo boVar;
                    bo boVar2;
                    String str;
                    Long l;
                    bo boVar3;
                    AppMethodBeat.i(248136);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (this.uHr.hOp.getLiveRole() == 0) {
                        g liveData = this.uHr.getLiveData();
                        if (liveData != null) {
                            boVar = liveData.UPW;
                        } else {
                            boVar = null;
                        }
                        if (boVar != null) {
                            g liveData2 = this.uHr.getLiveData();
                            if (liveData2 != null) {
                                boVar2 = liveData2.UPW;
                            } else {
                                boVar2 = null;
                            }
                            if (boVar2 instanceof com.tencent.mm.plugin.finder.live.view.a.c) {
                                m mVar = m.vli;
                                s.au auVar = s.au.CommerceActionBubbleTipClose;
                                g liveData3 = this.uHr.getLiveData();
                                if (liveData3 == null || (boVar3 = liveData3.UPW) == null) {
                                    l = null;
                                } else {
                                    l = Long.valueOf(boVar3.lT());
                                }
                                m.a(mVar, auVar, (String) null, String.valueOf(l));
                            } else if (boVar2 instanceof com.tencent.mm.plugin.finder.live.view.a.b) {
                                m mVar2 = m.vli;
                                s.au auVar2 = s.au.CommerceActionBubbleTipClose;
                                String valueOf = String.valueOf(((com.tencent.mm.plugin.finder.live.view.a.b) boVar2).UPE);
                                ffq ffq = ((com.tencent.mm.plugin.finder.live.view.a.b) boVar2).UPF;
                                if (ffq == null || (str = ffq.LYB) == null) {
                                    str = "";
                                }
                                String valueOf2 = String.valueOf(((com.tencent.mm.plugin.finder.live.view.a.b) boVar2).UPE);
                                String str2 = ((com.tencent.mm.plugin.finder.live.view.a.b) boVar2).gTk;
                                if (str2 == null) {
                                    str2 = "";
                                }
                                mVar2.a(auVar2, null, valueOf, str, valueOf2, str2);
                            }
                        }
                    }
                    l.f(this.uHr);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingWidget$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(248136);
                }
            });
        }
        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
        if (com.tencent.mm.plugin.finder.utils.m.dBP()) {
            this.uHp = this.uHh;
        }
        AppMethodBeat.o(248144);
    }

    public static final /* synthetic */ void f(l lVar) {
        AppMethodBeat.i(248145);
        lVar.djM();
        AppMethodBeat.o(248145);
    }

    public final int getWIDEGET_HEGIHT() {
        return this.uHe;
    }

    public final int getWIDEGET_PADDING() {
        return this.uHf;
    }

    public final int getVISITOR_TAKE_PLACE_HEIGHT() {
        return this.uHg;
    }

    public final int getANCHOR_TAKE_PLACE_HEIGHT() {
        return this.uHh;
    }

    public final g getLiveData() {
        return this.liveData;
    }

    public final void setLiveData(g gVar) {
        this.liveData = gVar;
    }

    public final int getTakePlaceHeight() {
        return this.uHp;
    }

    public final void setTakePlaceHeight(int i2) {
        this.uHp = i2;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ l uHr;

        a(l lVar) {
            this.uHr = lVar;
        }

        public final void run() {
            Integer num;
            ViewGroup.LayoutParams layoutParams;
            ViewGroup viewGroup;
            Integer num2 = null;
            AppMethodBeat.i(248137);
            this.uHr.ulG = (ViewGroup) this.uHr.parent.findViewById(R.id.hqk);
            ViewGroup viewGroup2 = this.uHr.ulG;
            if (viewGroup2 != null) {
                num = Integer.valueOf(viewGroup2.indexOfChild(this.uHr));
            } else {
                num = null;
            }
            Log.i(this.uHr.TAG, "addToParent,index:".concat(String.valueOf(num)));
            this.uHr.uHi = this.uHr.parent.findViewById(R.id.hqj);
            ViewGroup viewGroup3 = this.uHr.parent;
            if (viewGroup3 != null) {
                layoutParams = viewGroup3.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(248137);
                throw tVar;
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int[] iArr = new int[2];
            this.uHr.uHq.getLocationOnScreen(iArr);
            com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
            if (com.tencent.mm.plugin.finder.utils.m.dBP()) {
                marginLayoutParams.bottomMargin = ((au.az(this.uHr.getContext()).y - iArr[1]) - this.uHr.uHq.getHeight()) + (((this.uHr.uHq.getHeight() - this.uHr.getWIDEGET_HEGIHT()) - this.uHr.getWIDEGET_PADDING()) / 2);
            } else {
                String str = this.uHr.TAG;
                StringBuilder append = new StringBuilder("[visitor add shopping bubble] arrow:").append(this.uHr.uHi).append(" container:").append(this.uHr.ulG).append(" container.right:");
                ViewGroup viewGroup4 = this.uHr.ulG;
                StringBuilder append2 = append.append(viewGroup4 != null ? Integer.valueOf(viewGroup4.getRight()) : null).append(" loc:").append(iArr[0]).append(',').append(iArr[1]).append(" arrow.width:");
                View view = this.uHr.uHi;
                if (view != null) {
                    num2 = Integer.valueOf(view.getWidth());
                }
                Log.i(str, append2.append(num2).append(" entranceRoot.width:").append(this.uHr.uHq.getWidth()).toString());
                if (!(this.uHr.uHi == null || this.uHr.ulG == null)) {
                    int[] iArr2 = new int[2];
                    ViewGroup viewGroup5 = this.uHr.ulG;
                    if (viewGroup5 == null) {
                        p.hyc();
                    }
                    viewGroup5.getLocationInWindow(iArr2);
                    int i2 = iArr2[0];
                    ViewGroup viewGroup6 = this.uHr.ulG;
                    if (viewGroup6 == null) {
                        p.hyc();
                    }
                    int width = (i2 + viewGroup6.getWidth()) - iArr[0];
                    View view2 = this.uHr.uHi;
                    if (view2 == null) {
                        p.hyc();
                    }
                    int mZ = j.mZ((width - (view2.getWidth() / 2)) - (this.uHr.uHq.getWidth() / 2), 0);
                    View view3 = this.uHr.uHi;
                    if (view3 == null) {
                        p.hyc();
                    }
                    view3.setTranslationX(-((float) mZ));
                }
            }
            if (!(num == null || num.intValue() != -1 || (viewGroup = this.uHr.ulG) == null)) {
                viewGroup.addView(this.uHr);
            }
            ViewGroup viewGroup7 = this.uHr.ulG;
            if (viewGroup7 != null) {
                viewGroup7.setVisibility(0);
            }
            View view4 = this.uHr.uHi;
            if (view4 != null) {
                view4.setVisibility(0);
                AppMethodBeat.o(248137);
                return;
            }
            AppMethodBeat.o(248137);
        }
    }

    public final void hUs() {
        AppMethodBeat.i(261224);
        this.uHq.postDelayed(new a(this), 300);
        AppMethodBeat.o(261224);
    }

    public static void a(NeatTextView neatTextView, String str, String str2) {
        AppMethodBeat.i(248139);
        com.tencent.mm.pluginsdk.ui.span.m mVar = new com.tencent.mm.pluginsdk.ui.span.m(str + str2);
        Context context = neatTextView.getContext();
        p.g(context, "productDescTv.context");
        float dimension = context.getResources().getDimension(R.dimen.bt);
        float e2 = (float) d.e(neatTextView.getContext(), 2.0f);
        Context context2 = neatTextView.getContext();
        p.g(context2, "productDescTv.context");
        int color = context2.getResources().getColor(R.color.ag);
        Context context3 = neatTextView.getContext();
        p.g(context3, "productDescTv.context");
        int color2 = context3.getResources().getColor(R.color.ad);
        v.a aVar = v.ukj;
        p.h(str, "spanStr");
        Paint paint = new Paint();
        paint.setTextSize((float) d.e(MMApplicationContext.getContext(), 12.0f));
        Context context4 = MMApplicationContext.getContext();
        p.g(context4, "MMApplicationContext.getContext()");
        float dimension2 = context4.getResources().getDimension(R.dimen.bt);
        float measureText = dimension2 + paint.measureText(str, 0, str.length()) + (2.0f * dimension2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setBounds(0, 0, (int) measureText, 1);
        mVar.setSpan(new v(gradientDrawable, new v.b(str, dimension, dimension, dimension, dimension, dimension, e2, color, color2, d.e(neatTextView.getContext(), 12.0f))), 0, str.length(), 33);
        neatTextView.aw(mVar);
        AppMethodBeat.o(248139);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class c implements View.OnClickListener {
        final /* synthetic */ fhd USn;
        final /* synthetic */ l uHr;

        public c(l lVar, fhd fhd) {
            this.uHr = lVar;
            this.USn = fhd;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(261223);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingWidget$showShoppingBubble$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            ffq ffq = this.USn.UPF;
            if (ffq != null) {
                com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
                Context context = this.uHr.getContext();
                p.g(context, "context");
                String str = ffq.LYB;
                if (str == null) {
                    str = "";
                }
                String str2 = this.USn.gTk;
                if (str2 == null) {
                    str2 = "";
                }
                com.tencent.mm.plugin.finder.utils.m.ad(context, str, str2);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingWidget$showShoppingBubble$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(261223);
        }
    }

    public final void djM() {
        AppMethodBeat.i(248140);
        g gVar = this.liveData;
        if (gVar != null) {
            gVar.f((bo) null);
        }
        nE(false);
        djN();
        AppMethodBeat.o(248140);
    }

    public final void nE(boolean z) {
        AppMethodBeat.i(248141);
        Context context = getContext();
        p.g(context, "context");
        Resources resources = context.getResources();
        p.g(resources, "context.resources");
        int i2 = resources.getConfiguration().orientation;
        Log.i(this.TAG, "notifyShoppingBubbleAction show:" + z + ", orientation:" + i2);
        if (i2 == 2) {
            AppMethodBeat.o(248141);
            return;
        }
        int i3 = this.uHp;
        if (!z) {
            i3 = -this.uHp;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("PARAM_FINDER_LIVE_COMMENT_MOVE_DISTANCE", i3);
        this.hOp.statusChange(b.c.hNd, bundle);
        AppMethodBeat.o(248141);
    }

    public final void hUt() {
        AppMethodBeat.i(261225);
        Log.i(this.TAG, "showShoppingBubbleAnim，parent visibility:" + this.parent.getVisibility());
        if (getVisibility() != 0) {
            setVisibility(0);
            if (this.uHn == null) {
                this.uHn = ObjectAnimator.ofFloat(this.parent, "alpha", 0.0f, 1.0f);
            }
            ObjectAnimator objectAnimator = this.uHn;
            if (objectAnimator != null) {
                objectAnimator.cancel();
            }
            ObjectAnimator objectAnimator2 = this.uHn;
            if (objectAnimator2 != null) {
                objectAnimator2.start();
                AppMethodBeat.o(261225);
                return;
            }
        }
        AppMethodBeat.o(261225);
    }

    private final void djN() {
        AppMethodBeat.i(248142);
        Log.i(this.TAG, "hideShoppingBubbleAnim，parent visibility:" + this.parent.getVisibility());
        if (getVisibility() == 0) {
            if (this.uHo == null) {
                this.uHo = ObjectAnimator.ofFloat(this.parent, "alpha", 1.0f, 0.0f);
                ObjectAnimator objectAnimator = this.uHo;
                if (objectAnimator != null) {
                    objectAnimator.addListener(new b(this));
                }
            }
            ObjectAnimator objectAnimator2 = this.uHo;
            if (objectAnimator2 != null) {
                objectAnimator2.cancel();
            }
            ObjectAnimator objectAnimator3 = this.uHo;
            if (objectAnimator3 != null) {
                objectAnimator3.start();
                AppMethodBeat.o(248142);
                return;
            }
        }
        AppMethodBeat.o(248142);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingWidget$hideShoppingBubbleAnim$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class b implements Animator.AnimatorListener {
        final /* synthetic */ l uHr;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(l lVar) {
            this.uHr = lVar;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(248138);
            this.uHr.setVisibility(8);
            AppMethodBeat.o(248138);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    public final void setVisibility(int i2) {
        AppMethodBeat.i(248143);
        super.setVisibility(i2);
        ViewGroup viewGroup = this.ulG;
        if (viewGroup != null) {
            viewGroup.setVisibility(i2);
        }
        View view = this.uHi;
        if (view != null) {
            view.setVisibility(i2);
            AppMethodBeat.o(248143);
            return;
        }
        AppMethodBeat.o(248143);
    }
}
