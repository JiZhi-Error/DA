package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Message;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.awq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.a.j;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010'\u001a\u00020(H\u0016J\u000e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,J\u0010\u0010-\u001a\u00020*2\u0006\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020*H\u0016J\u0014\u00101\u001a\u00020*2\f\u00102\u001a\b\u0012\u0004\u0012\u00020/03R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R#\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\b \u0010\u0016\u001a\u0004\b\u001e\u0010\u001fR#\u0010!\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118BX\u0002¢\u0006\f\n\u0004\b#\u0010\u0016\u001a\u0004\b\"\u0010\u0014R\u001b\u0010$\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\b&\u0010\u0016\u001a\u0004\b%\u0010\u001fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u00064"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveTopCommentPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "GET_COMMENT", "", "INIT_VIEW", "IN_ANIM", "OUT_ANIM", "STAY_DURATION", "", "TAG", "", "contextTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getContextTv", "()Landroid/widget/TextView;", "contextTv$delegate", "Lkotlin/Lazy;", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handler$delegate", "inAnim", "Landroid/animation/ObjectAnimator;", "getInAnim", "()Landroid/animation/ObjectAnimator;", "inAnim$delegate", "nicknameTv", "getNicknameTv", "nicknameTv$delegate", "outAnim", "getOutAnim", "outAnim$delegate", "canClearScreen", "", "initPosition", "", "aboveView", "Landroid/view/View;", "initTopComment", "msg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveMsg;", "unMount", "updateMessages", "msgList", "", "plugin-finder_release"})
public final class bj extends d {
    final String TAG = "FinderLiveTopCommentPlugin";
    private final com.tencent.mm.live.c.b hOp;
    private final kotlin.f lhN;
    private final kotlin.f uuj;
    private final kotlin.f uuk;
    final int uul;
    final int uum;
    final int uun;
    final int uuo;
    final long uup;
    final kotlin.f uuq;
    final kotlin.f uur;

    /* access modifiers changed from: package-private */
    public final MMHandler bkj() {
        AppMethodBeat.i(247085);
        MMHandler mMHandler = (MMHandler) this.lhN.getValue();
        AppMethodBeat.o(247085);
        return mMHandler;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bj(ViewGroup viewGroup, com.tencent.mm.live.c.b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(247089);
        this.hOp = bVar;
        this.uuj = g.ah(new e(viewGroup));
        this.uuk = g.ah(new a(viewGroup));
        this.uul = 1;
        this.uum = 2;
        this.uun = 3;
        this.uuo = 4;
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class);
        p.g(af, "MMKernel.service<IConfig…onfigService::class.java)");
        this.uup = ((long) ((com.tencent.mm.plugin.zero.b.a) af).aqJ().getInt("FinderLiveTopCommentDisplayTimeSec", 10)) * 1000;
        if (!isLandscape()) {
            Context context = viewGroup.getContext();
            p.g(context, "root.context");
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.cr);
            viewGroup.setPadding(dimensionPixelSize, viewGroup.getPaddingTop(), dimensionPixelSize, viewGroup.getPaddingBottom());
        }
        this.lhN = g.ah(new b(this));
        this.uuq = g.ah(new c(this, viewGroup));
        this.uur = g.ah(new f(viewGroup));
        AppMethodBeat.o(247089);
    }

    public final void dY(View view) {
        int dimensionPixelOffset;
        AppMethodBeat.i(247086);
        p.h(view, "aboveView");
        int bottom = view.getBottom();
        if (isLandscape()) {
            dimensionPixelOffset = 0;
        } else {
            Context context = view.getContext();
            p.g(context, "aboveView.context");
            dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.ci);
        }
        int i2 = bottom + dimensionPixelOffset;
        if (this.hwr.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            ViewGroup.LayoutParams layoutParams = this.hwr.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                AppMethodBeat.o(247086);
                throw tVar;
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            layoutParams2.setMargins(layoutParams2.leftMargin, i2, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            this.hwr.setLayoutParams(layoutParams2);
        }
        AppMethodBeat.o(247086);
    }

    public final void ea(List<awq> list) {
        AppMethodBeat.i(247087);
        p.h(list, "msgList");
        Message obtainMessage = bkj().obtainMessage();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        obtainMessage.obj = arrayList;
        obtainMessage.what = this.uuo;
        bkj().sendMessage(obtainMessage);
        AppMethodBeat.o(247087);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void unMount() {
        AppMethodBeat.i(247088);
        super.unMount();
        bkj().removeMessages(this.uul);
        bkj().removeMessages(this.uum);
        bkj().removeMessages(this.uun);
        AppMethodBeat.o(247088);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class e extends q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ ViewGroup hOA;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(ViewGroup viewGroup) {
            super(0);
            this.hOA = viewGroup;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(247081);
            TextView textView = (TextView) this.hOA.findViewById(R.id.cyg);
            AppMethodBeat.o(247081);
            return textView;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class a extends q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ ViewGroup hOA;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(ViewGroup viewGroup) {
            super(0);
            this.hOA = viewGroup;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(247069);
            TextView textView = (TextView) this.hOA.findViewById(R.id.cyf);
            AppMethodBeat.o(247069);
            return textView;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "invoke"})
    static final class b extends q implements kotlin.g.a.a<MMHandler> {
        final /* synthetic */ bj uus;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(bj bjVar) {
            super(0);
            this.uus = bjVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MMHandler invoke() {
            AppMethodBeat.i(247074);
            MMHandler mMHandler = new MMHandler("FinderLiveTopCommentPlugin", new MMHandler.Callback(this) {
                /* class com.tencent.mm.plugin.finder.live.plugin.bj.b.AnonymousClass1 */
                final /* synthetic */ b uut;

                {
                    this.uut = r1;
                }

                public final boolean handleMessage(Message message) {
                    boolean z;
                    List a2;
                    AppMethodBeat.i(247073);
                    int i2 = message.what;
                    if (i2 == this.uut.uus.uul) {
                        bj bjVar = this.uut.uus;
                        Object obj = message.obj;
                        if (obj == null) {
                            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderLiveMsg");
                            AppMethodBeat.o(247073);
                            throw tVar;
                        }
                        com.tencent.mm.ac.d.h(new d(bjVar, (awq) obj));
                    } else if (i2 == this.uut.uus.uum) {
                        com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                            /* class com.tencent.mm.plugin.finder.live.plugin.bj.b.AnonymousClass1.AnonymousClass1 */
                            final /* synthetic */ AnonymousClass1 uuu;

                            {
                                this.uuu = r2;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            @Override // kotlin.g.a.a
                            public final /* synthetic */ x invoke() {
                                AppMethodBeat.i(247071);
                                ((ObjectAnimator) this.uuu.uut.uus.uuq.getValue()).start();
                                x xVar = x.SXb;
                                AppMethodBeat.o(247071);
                                return xVar;
                            }
                        });
                    } else if (i2 == this.uut.uus.uun) {
                        com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                            /* class com.tencent.mm.plugin.finder.live.plugin.bj.b.AnonymousClass1.AnonymousClass2 */
                            final /* synthetic */ AnonymousClass1 uuu;

                            {
                                this.uuu = r2;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            @Override // kotlin.g.a.a
                            public final /* synthetic */ x invoke() {
                                AppMethodBeat.i(247072);
                                ((ObjectAnimator) this.uuu.uut.uus.uur.getValue()).start();
                                x xVar = x.SXb;
                                AppMethodBeat.o(247072);
                                return xVar;
                            }
                        });
                    } else if (i2 == this.uut.uus.uuo) {
                        Object obj2 = message.obj;
                        if (obj2 == null) {
                            t tVar2 = new t("null cannot be cast to non-null type kotlin.collections.ArrayList<com.tencent.mm.protocal.protobuf.FinderLiveMsg> /* = java.util.ArrayList<com.tencent.mm.protocal.protobuf.FinderLiveMsg> */");
                            AppMethodBeat.o(247073);
                            throw tVar2;
                        }
                        ArrayList arrayList = (ArrayList) obj2;
                        if (!arrayList.isEmpty()) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z) {
                            arrayList = null;
                        }
                        awq awq = (arrayList == null || (a2 = j.a(arrayList, new a())) == null) ? null : (awq) a2.get(0);
                        if (awq != null) {
                            Message obtainMessage = this.uut.uus.bkj().obtainMessage(this.uut.uus.uul);
                            obtainMessage.obj = awq;
                            this.uut.uus.bkj().sendMessage(obtainMessage);
                        }
                    }
                    AppMethodBeat.o(247073);
                    return true;
                }

                @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"})
                /* renamed from: com.tencent.mm.plugin.finder.live.plugin.bj$b$1$a */
                public static final class a<T> implements Comparator<T> {
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        AppMethodBeat.i(247070);
                        int a2 = kotlin.b.a.a(Long.valueOf(t2.seq), Long.valueOf(t.seq));
                        AppMethodBeat.o(247070);
                        return a2;
                    }
                }
            });
            AppMethodBeat.o(247074);
            return mMHandler;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/animation/ObjectAnimator;", "kotlin.jvm.PlatformType", "invoke"})
    static final class c extends q implements kotlin.g.a.a<ObjectAnimator> {
        final /* synthetic */ ViewGroup hOA;
        final /* synthetic */ bj uus;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(bj bjVar, ViewGroup viewGroup) {
            super(0);
            this.uus = bjVar;
            this.hOA = viewGroup;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ObjectAnimator invoke() {
            AppMethodBeat.i(247077);
            final z.f fVar = new z.f();
            fVar.SYG = (T) ObjectAnimator.ofFloat(this.hOA, "alpha", 0.0f, 1.0f);
            T t = fVar.SYG;
            p.g(t, "anim");
            t.setDuration(300);
            T t2 = fVar.SYG;
            p.g(t2, "anim");
            t2.setInterpolator(new DecelerateInterpolator());
            fVar.SYG.addListener(new Animator.AnimatorListener(this) {
                /* class com.tencent.mm.plugin.finder.live.plugin.bj.c.AnonymousClass1 */
                final /* synthetic */ c uuv;

                {
                    this.uuv = r1;
                }

                public final void onAnimationRepeat(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(247075);
                    T t = fVar.SYG;
                    p.g(t, "anim");
                    Object target = t.getTarget();
                    if (target == null) {
                        t tVar = new t("null cannot be cast to non-null type android.view.View");
                        AppMethodBeat.o(247075);
                        throw tVar;
                    }
                    ((View) target).setAlpha(1.0f);
                    this.uuv.uus.bkj().sendEmptyMessageDelayed(this.uuv.uus.uun, this.uuv.uus.uup);
                    AppMethodBeat.o(247075);
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(247076);
                    T t = fVar.SYG;
                    p.g(t, "anim");
                    Object target = t.getTarget();
                    if (target == null) {
                        t tVar = new t("null cannot be cast to non-null type android.view.View");
                        AppMethodBeat.o(247076);
                        throw tVar;
                    }
                    View view = (View) target;
                    view.setAlpha(0.0f);
                    view.setVisibility(0);
                    AppMethodBeat.o(247076);
                }
            });
            T t3 = fVar.SYG;
            AppMethodBeat.o(247077);
            return t3;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/animation/ObjectAnimator;", "kotlin.jvm.PlatformType", "invoke"})
    static final class f extends q implements kotlin.g.a.a<ObjectAnimator> {
        final /* synthetic */ ViewGroup hOA;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(ViewGroup viewGroup) {
            super(0);
            this.hOA = viewGroup;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ObjectAnimator invoke() {
            AppMethodBeat.i(247084);
            final z.f fVar = new z.f();
            fVar.SYG = (T) ObjectAnimator.ofFloat(this.hOA, "alpha", 1.0f, 0.0f);
            T t = fVar.SYG;
            p.g(t, "anim");
            t.setDuration(300);
            T t2 = fVar.SYG;
            p.g(t2, "anim");
            t2.setInterpolator(new DecelerateInterpolator());
            fVar.SYG.addListener(new Animator.AnimatorListener() {
                /* class com.tencent.mm.plugin.finder.live.plugin.bj.f.AnonymousClass1 */

                public final void onAnimationRepeat(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(247082);
                    T t = fVar.SYG;
                    p.g(t, "anim");
                    Object target = t.getTarget();
                    if (target == null) {
                        t tVar = new t("null cannot be cast to non-null type android.view.View");
                        AppMethodBeat.o(247082);
                        throw tVar;
                    }
                    View view = (View) target;
                    view.setVisibility(8);
                    view.setAlpha(1.0f);
                    AppMethodBeat.o(247082);
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationStart(Animator animator) {
                    AppMethodBeat.i(247083);
                    T t = fVar.SYG;
                    p.g(t, "anim");
                    Object target = t.getTarget();
                    if (target == null) {
                        t tVar = new t("null cannot be cast to non-null type android.view.View");
                        AppMethodBeat.o(247083);
                        throw tVar;
                    }
                    View view = (View) target;
                    view.setAlpha(1.0f);
                    view.setVisibility(0);
                    AppMethodBeat.o(247083);
                }
            });
            T t3 = fVar.SYG;
            AppMethodBeat.o(247084);
            return t3;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ bj uus;
        final /* synthetic */ awq uux;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(bj bjVar, awq awq) {
            super(0);
            this.uus = bjVar;
            this.uux = awq;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            SpannableString c2;
            String str;
            String str2;
            FinderContact finderContact;
            FinderContact finderContact2;
            AppMethodBeat.i(247080);
            this.uus.hwr.setVisibility(8);
            TextView a2 = bj.a(this.uus);
            p.g(a2, "nicknameTv");
            ao.a(a2.getPaint(), 0.8f);
            TextView a3 = bj.a(this.uus);
            p.g(a3, "nicknameTv");
            if (this.uux.Vjm != null) {
                com.tencent.mm.plugin.finder.convert.d dVar = com.tencent.mm.plugin.finder.convert.d.tyZ;
                Context context = this.uus.hwr.getContext();
                p.g(context, "root.context");
                TextView b2 = bj.b(this.uus);
                p.g(b2, "contextTv");
                TextPaint paint = b2.getPaint();
                p.g(paint, "contextTv.paint");
                m mVar = m.vVH;
                CharSequence a4 = com.tencent.mm.plugin.finder.convert.d.a(context, paint, m.hm(this.uux.username, this.uux.nickname));
                com.tencent.mm.plugin.finder.convert.d dVar2 = com.tencent.mm.plugin.finder.convert.d.tyZ;
                Context context2 = this.uus.hwr.getContext();
                p.g(context2, "root.context");
                TextView b3 = bj.b(this.uus);
                p.g(b3, "contextTv");
                TextPaint paint2 = b3.getPaint();
                p.g(paint2, "contextTv.paint");
                m mVar2 = m.vVH;
                avn avn = this.uux.Vjm;
                if (avn == null || (finderContact2 = avn.contact) == null || (str = finderContact2.username) == null) {
                    str = "";
                }
                avn avn2 = this.uux.Vjm;
                if (avn2 == null || (finderContact = avn2.contact) == null || (str2 = finderContact.nickname) == null) {
                    str2 = "";
                }
                c2 = com.tencent.mm.pluginsdk.ui.span.l.c(this.uus.hwr.getContext(), this.uus.hwr.getContext().getString(R.string.jbz, a4, com.tencent.mm.plugin.finder.convert.d.a(context2, paint2, m.hm(str, str2))));
            } else {
                Context context3 = this.uus.hwr.getContext();
                m mVar3 = m.vVH;
                c2 = com.tencent.mm.pluginsdk.ui.span.l.c(context3, m.hm(this.uux.username, this.uux.nickname));
            }
            a3.setText(c2);
            bj.b(this.uus).setTextSize(0, (float) com.tencent.mm.cb.a.aG(this.uus.hwr.getContext(), R.dimen.hb));
            TextView b4 = bj.b(this.uus);
            p.g(b4, "contextTv");
            b4.setText(com.tencent.mm.pluginsdk.ui.span.l.c(this.uus.hwr.getContext(), this.uux.content));
            Log.i(this.uus.TAG, "topComment,content:" + this.uux.content);
            int screenWidth = com.tencent.mm.ui.widget.textview.b.getScreenWidth(this.uus.hwr.getContext());
            Context context4 = this.uus.hwr.getContext();
            p.g(context4, "root.context");
            int dimensionPixelOffset = screenWidth - (context4.getResources().getDimensionPixelOffset(R.dimen.ci) * 4);
            final z.f fVar = new z.f();
            TextView b5 = bj.b(this.uus);
            p.g(b5, "contextTv");
            TextPaint paint3 = b5.getPaint();
            Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
            TextView b6 = bj.b(this.uus);
            p.g(b6, "contextTv");
            float lineSpacingMultiplier = b6.getLineSpacingMultiplier();
            TextView b7 = bj.b(this.uus);
            p.g(b7, "contextTv");
            fVar.SYG = (T) new StaticLayout(com.tencent.mm.pluginsdk.ui.span.l.c(this.uus.hwr.getContext(), this.uux.content), paint3, dimensionPixelOffset, alignment, lineSpacingMultiplier, b7.getLineSpacingExtra(), true);
            this.uus.hwr.post(new Runnable(this) {
                /* class com.tencent.mm.plugin.finder.live.plugin.bj.d.AnonymousClass1 */
                final /* synthetic */ d uuy;

                {
                    this.uuy = r1;
                }

                public final void run() {
                    AppMethodBeat.i(247079);
                    if (fVar.SYG.getLineCount() <= 2) {
                        bj.b(this.uuy.uus).setTextSize(0, (float) com.tencent.mm.cb.a.aG(this.uuy.uus.hwr.getContext(), R.dimen.hb));
                    } else {
                        bj.b(this.uuy.uus).setTextSize(0, (float) com.tencent.mm.cb.a.aG(this.uuy.uus.hwr.getContext(), R.dimen.t));
                    }
                    this.uuy.uus.hwr.invalidate();
                    this.uuy.uus.hwr.post(new Runnable(this) {
                        /* class com.tencent.mm.plugin.finder.live.plugin.bj.d.AnonymousClass1.AnonymousClass1 */
                        final /* synthetic */ AnonymousClass1 uuA;

                        {
                            this.uuA = r1;
                        }

                        public final void run() {
                            AppMethodBeat.i(247078);
                            if (this.uuA.uuy.uus.hwr.getVisibility() == 0) {
                                this.uuA.uuy.uus.hwr.setVisibility(8);
                            }
                            this.uuA.uuy.uus.bkj().removeMessages(this.uuA.uuy.uus.uun);
                            this.uuA.uuy.uus.bkj().sendEmptyMessage(this.uuA.uuy.uus.uum);
                            AppMethodBeat.o(247078);
                        }
                    });
                    AppMethodBeat.o(247079);
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(247080);
            return xVar;
        }
    }

    public static final /* synthetic */ TextView a(bj bjVar) {
        AppMethodBeat.i(247090);
        TextView textView = (TextView) bjVar.uuj.getValue();
        AppMethodBeat.o(247090);
        return textView;
    }

    public static final /* synthetic */ TextView b(bj bjVar) {
        AppMethodBeat.i(247091);
        TextView textView = (TextView) bjVar.uuk.getValue();
        AppMethodBeat.o(247091);
        return textView;
    }
}
