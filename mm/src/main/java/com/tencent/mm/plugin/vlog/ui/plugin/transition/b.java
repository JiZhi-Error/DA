package com.tencent.mm.plugin.vlog.ui.plugin.transition;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.vlog.model.local.a;
import com.tencent.mm.plugin.vlog.ui.plugin.transition.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 <2\u00020\u0001:\u0002<=B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u00102\u001a\u00020\u001aH\u0002J\u0016\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u001a2\u0006\u00106\u001a\u00020\u001aJ\u0006\u00107\u001a\u000204J\u0010\u00108\u001a\u0002042\u0006\u00109\u001a\u00020#H\u0002J\u000e\u0010:\u001a\u0002042\u0006\u0010;\u001a\u00020\u001cR#\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR#\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\r0\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR#\u0010\u0011\u001a\n \u0007*\u0004\u0018\u00010\u00120\u00128BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0013\u0010\u0014R#\u0010\u0016\u001a\n \u0007*\u0004\u0018\u00010\r0\r8BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u000b\u001a\u0004\b\u0017\u0010\u000fR\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R#\u0010\u001d\u001a\n \u0007*\u0004\u0018\u00010\u001e0\u001e8BX\u0002¢\u0006\f\n\u0004\b!\u0010\u000b\u001a\u0004\b\u001f\u0010 R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020(0,X\u0004¢\u0006\u0002\n\u0000R#\u0010-\u001a\n \u0007*\u0004\u0018\u00010.0.8BX\u0002¢\u0006\f\n\u0004\b1\u0010\u000b\u001a\u0004\b/\u00100¨\u0006>"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "applyAllTransitionGroup", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "getApplyAllTransitionGroup", "()Landroid/widget/LinearLayout;", "applyAllTransitionGroup$delegate", "Lkotlin/Lazy;", "applyAllTransitionIcon", "Landroid/widget/ImageView;", "getApplyAllTransitionIcon", "()Landroid/widget/ImageView;", "applyAllTransitionIcon$delegate", "closeIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getCloseIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "closeIcon$delegate", "confirmIcon", "getConfirmIcon", "confirmIcon$delegate", "editTransitionIndex", "", "editTransitionListener", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$EditTransitionListener;", "emptyHolder", "Landroid/view/View;", "getEmptyHolder", "()Landroid/view/View;", "emptyHolder$delegate", "isApplyAll", "", "originTransEffectInfo", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$TransEffectInfo;", "selectedIndex", "selectedTransitionItem", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionItem;", "transitionAdapter", "Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/TransitionAdapter;", "transitionInfoList", "", "transitionRecycler", "Landroid/support/v7/widget/RecyclerView;", "getTransitionRecycler", "()Landroid/support/v7/widget/RecyclerView;", "transitionRecycler$delegate", "getItemOffsetLength", "initStatus", "", "transitionIndex", "order", "initTransitionInfo", "setApplyAll", "enabled", "setEditTransitionListener", "listenerEdit", "Companion", "EditTransitionListener", "plugin-vlog_release"})
public final class b extends RelativeLayout {
    @Deprecated
    public static final a GNN = new a((byte) 0);
    private final kotlin.f GNB = kotlin.g.ah(new d(this));
    private final kotlin.f GNC = kotlin.g.ah(new c(this));
    private final kotlin.f GND = kotlin.g.ah(new h(this));
    private final kotlin.f GNE = kotlin.g.ah(new f(this));
    private final kotlin.f GNF = kotlin.g.ah(new g(this));
    private final List<d> GNG = new ArrayList();
    private final c GNH;
    private AbstractC1878b GNI;
    private a.C1849a GNJ;
    private d GNK = new d();
    private int GNL;
    private boolean GNM;
    private int bxP;
    private final kotlin.f udQ = kotlin.g.ah(new e(this));

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\u0003H&J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$EditTransitionListener;", "", "onApplyTransitionToAll", "", "editTransitionIndex", "", "effect", "Lcom/tencent/mm/plugin/vlog/model/local/LocalEffectManager$TransEffectInfo;", "onClose", "onSetTransition", "plugin-vlog_release"})
    /* renamed from: com.tencent.mm.plugin.vlog.ui.plugin.transition.b$b  reason: collision with other inner class name */
    public interface AbstractC1878b {
        void a(int i2, a.C1849a aVar);

        void b(int i2, a.C1849a aVar);

        void onClose();
    }

    static {
        AppMethodBeat.i(191996);
        AppMethodBeat.o(191996);
    }

    private final LinearLayout getApplyAllTransitionGroup() {
        AppMethodBeat.i(191985);
        LinearLayout linearLayout = (LinearLayout) this.GNC.getValue();
        AppMethodBeat.o(191985);
        return linearLayout;
    }

    private final ImageView getApplyAllTransitionIcon() {
        AppMethodBeat.i(191984);
        ImageView imageView = (ImageView) this.GNB.getValue();
        AppMethodBeat.o(191984);
        return imageView;
    }

    private final WeImageView getCloseIcon() {
        AppMethodBeat.i(191987);
        WeImageView weImageView = (WeImageView) this.udQ.getValue();
        AppMethodBeat.o(191987);
        return weImageView;
    }

    private final ImageView getConfirmIcon() {
        AppMethodBeat.i(191988);
        ImageView imageView = (ImageView) this.GNE.getValue();
        AppMethodBeat.o(191988);
        return imageView;
    }

    private final View getEmptyHolder() {
        AppMethodBeat.i(191989);
        View view = (View) this.GNF.getValue();
        AppMethodBeat.o(191989);
        return view;
    }

    private final RecyclerView getTransitionRecycler() {
        AppMethodBeat.i(191986);
        RecyclerView recyclerView = (RecyclerView) this.GND.getValue();
        AppMethodBeat.o(191986);
        return recyclerView;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(191995);
        LayoutInflater.from(context).inflate(R.layout.a0t, (ViewGroup) this, true);
        setOnClickListener(AnonymousClass1.GNO);
        fEs();
        setApplyAll(this.GNM);
        this.GNH = new c(this.GNG);
        c cVar = this.GNH;
        AnonymousClass2 r0 = new c.d(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.transition.b.AnonymousClass2 */
            final /* synthetic */ b GNP;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.GNP = r1;
            }

            @Override // com.tencent.mm.plugin.vlog.ui.plugin.transition.c.d
            public final void a(d dVar, int i2) {
                AppMethodBeat.i(191973);
                p.h(dVar, "item");
                if (!dVar.uOQ) {
                    this.GNP.GNK.uOQ = false;
                    this.GNP.GNH.b(this.GNP.bxP, new Object());
                    dVar.uOQ = true;
                    this.GNP.GNH.b(i2, new Object());
                    this.GNP.bxP = i2;
                    this.GNP.GNK = dVar;
                    AbstractC1878b bVar = this.GNP.GNI;
                    if (bVar != null) {
                        bVar.b(this.GNP.GNL, this.GNP.GNK.GNZ);
                        AppMethodBeat.o(191973);
                        return;
                    }
                }
                AppMethodBeat.o(191973);
            }
        };
        p.h(r0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        cVar.GNQ = r0;
        RecyclerView transitionRecycler = getTransitionRecycler();
        p.g(transitionRecycler, "transitionRecycler");
        transitionRecycler.setLayoutManager(new LinearLayoutManager(0, false));
        RecyclerView transitionRecycler2 = getTransitionRecycler();
        p.g(transitionRecycler2, "transitionRecycler");
        transitionRecycler2.setAdapter(this.GNH);
        RecyclerView transitionRecycler3 = getTransitionRecycler();
        p.g(transitionRecycler3, "transitionRecycler");
        transitionRecycler3.setItemAnimator(null);
        final int itemOffsetLength = getItemOffsetLength();
        getTransitionRecycler().b(new RecyclerView.h() {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.transition.b.AnonymousClass3 */

            @Override // android.support.v7.widget.RecyclerView.h
            public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
                AppMethodBeat.i(191974);
                p.h(rect, "outRect");
                p.h(view, "view");
                p.h(recyclerView, "parent");
                p.h(sVar, "state");
                super.a(rect, view, recyclerView, sVar);
                rect.left = itemOffsetLength;
                rect.right = itemOffsetLength;
                AppMethodBeat.o(191974);
            }
        });
        getApplyAllTransitionGroup().setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.transition.b.AnonymousClass4 */
            final /* synthetic */ b GNP;

            {
                this.GNP = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(191975);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b.a(this.GNP, !this.GNP.GNM);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(191975);
            }
        });
        getCloseIcon().setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.transition.b.AnonymousClass5 */
            final /* synthetic */ b GNP;

            {
                this.GNP = r1;
            }

            public final void onClick(View view) {
                AbstractC1878b bVar;
                AppMethodBeat.i(191976);
                com.tencent.mm.hellhoundlib.b.b bVar2 = new com.tencent.mm.hellhoundlib.b.b();
                bVar2.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar2.axR());
                if ((!p.j(this.GNP.GNJ, this.GNP.GNK.GNZ)) && (bVar = this.GNP.GNI) != null) {
                    bVar.b(this.GNP.GNL, this.GNP.GNJ);
                }
                AbstractC1878b bVar3 = this.GNP.GNI;
                if (bVar3 != null) {
                    bVar3.onClose();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(191976);
            }
        });
        getConfirmIcon().setImageDrawable(ar.m(context, R.raw.icons_outlined_done, context.getResources().getColor(R.color.Orange)));
        getConfirmIcon().setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.vlog.ui.plugin.transition.b.AnonymousClass6 */
            final /* synthetic */ b GNP;

            {
                this.GNP = r1;
            }

            public final void onClick(View view) {
                AbstractC1878b bVar;
                AppMethodBeat.i(191977);
                com.tencent.mm.hellhoundlib.b.b bVar2 = new com.tencent.mm.hellhoundlib.b.b();
                bVar2.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar2.axR());
                if (this.GNP.GNM && (bVar = this.GNP.GNI) != null) {
                    bVar.a(this.GNP.GNL, this.GNP.GNK.GNZ);
                }
                AbstractC1878b bVar3 = this.GNP.GNI;
                if (bVar3 != null) {
                    bVar3.onClose();
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(191977);
            }
        });
        AppMethodBeat.o(191995);
    }

    public static final /* synthetic */ void a(b bVar, boolean z) {
        AppMethodBeat.i(191997);
        bVar.setApplyAll(z);
        AppMethodBeat.o(191997);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    private final int getItemOffsetLength() {
        AppMethodBeat.i(191990);
        int jn = com.tencent.mm.cb.a.jn(getContext()) - com.tencent.mm.cb.a.fromDPToPix(getContext(), 26.0f);
        int aG = com.tencent.mm.cb.a.aG(getContext(), R.dimen.cr);
        int i2 = (jn * 10) / aG;
        int i3 = i2 % 10;
        int i4 = i2 / 10;
        if (i3 > 7) {
            int i5 = (jn - ((int) (((float) (aG / 2)) * (((float) i4) + 1.5f)))) / (((i4 + 1) * 2) + 1);
            AppMethodBeat.o(191990);
            return i5;
        } else if (i3 < 2) {
            int i6 = (jn - ((int) (((float) (aG / 2)) * (((float) i4) + 0.5f)))) / ((i4 * 2) + 1);
            AppMethodBeat.o(191990);
            return i6;
        } else {
            int i7 = aG / 4;
            AppMethodBeat.o(191990);
            return i7;
        }
    }

    public final void jy(int i2, int i3) {
        T t;
        boolean z;
        AppMethodBeat.i(191991);
        com.tencent.mm.plugin.vlog.model.local.a aVar = com.tencent.mm.plugin.vlog.model.local.a.GAD;
        Iterator<T> it = com.tencent.mm.plugin.vlog.model.local.a.fBM().iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            T next = it.next();
            if (next.order == i3) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                t = next;
                break;
            }
        }
        this.GNJ = t;
        this.GNL = i2;
        this.GNK.uOQ = false;
        this.GNH.ci(this.bxP);
        Iterator<d> it2 = this.GNG.iterator();
        int i4 = 0;
        while (true) {
            if (!it2.hasNext()) {
                i4 = -1;
                break;
            } else if (p.j(it2.next().GNZ, this.GNJ)) {
                break;
            } else {
                i4++;
            }
        }
        this.bxP = i4;
        this.GNK = this.GNG.get(this.bxP);
        RecyclerView transitionRecycler = getTransitionRecycler();
        com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(this.bxP, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(transitionRecycler, a2.axQ(), "com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView", "initStatus", "(II)V", "Undefined", "scrollToPosition", "(I)V");
        transitionRecycler.scrollToPosition(((Integer) a2.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(transitionRecycler, "com/tencent/mm/plugin/vlog/ui/plugin/transition/EditorEditTransitionView", "initStatus", "(II)V", "Undefined", "scrollToPosition", "(I)V");
        this.GNK.uOQ = true;
        this.GNH.ci(this.bxP);
        setApplyAll(false);
        AppMethodBeat.o(191991);
    }

    public final void fEs() {
        AppMethodBeat.i(191992);
        this.GNG.clear();
        this.GNG.add(new d());
        com.tencent.mm.plugin.vlog.model.local.a aVar = com.tencent.mm.plugin.vlog.model.local.a.GAD;
        Iterator<T> it = com.tencent.mm.plugin.vlog.model.local.a.fBM().iterator();
        while (it.hasNext()) {
            this.GNG.add(new d(it.next()));
        }
        Log.i("MicroMsg.EditorEditTransitionView", "initTransitionInfo: size:" + this.GNG.size());
        this.bxP = 0;
        this.GNK = (d) j.ks(this.GNG);
        if (this.GNG.size() <= 1) {
            View emptyHolder = getEmptyHolder();
            p.g(emptyHolder, "emptyHolder");
            emptyHolder.setVisibility(0);
            LinearLayout applyAllTransitionGroup = getApplyAllTransitionGroup();
            p.g(applyAllTransitionGroup, "applyAllTransitionGroup");
            applyAllTransitionGroup.setVisibility(4);
            RecyclerView transitionRecycler = getTransitionRecycler();
            p.g(transitionRecycler, "transitionRecycler");
            transitionRecycler.setVisibility(4);
            com.tencent.mm.plugin.vlog.model.local.a aVar2 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
            com.tencent.mm.plugin.vlog.model.local.a.i(new WeakReference(this));
            AppMethodBeat.o(191992);
            return;
        }
        View emptyHolder2 = getEmptyHolder();
        p.g(emptyHolder2, "emptyHolder");
        emptyHolder2.setVisibility(4);
        LinearLayout applyAllTransitionGroup2 = getApplyAllTransitionGroup();
        p.g(applyAllTransitionGroup2, "applyAllTransitionGroup");
        applyAllTransitionGroup2.setVisibility(0);
        RecyclerView transitionRecycler2 = getTransitionRecycler();
        p.g(transitionRecycler2, "transitionRecycler");
        transitionRecycler2.setVisibility(0);
        AppMethodBeat.o(191992);
    }

    private final void setApplyAll(boolean z) {
        AppMethodBeat.i(191993);
        this.GNM = z;
        getApplyAllTransitionIcon().setImageDrawable(ar.m(getContext(), this.GNM ? R.raw.ui_rescoures_checkbox_selected : R.raw.ui_rescoures_checkbox_unselected, Color.parseColor("#CCFFFFFF")));
        AppMethodBeat.o(191993);
    }

    public final void setEditTransitionListener(AbstractC1878b bVar) {
        AppMethodBeat.i(191994);
        p.h(bVar, "listenerEdit");
        this.GNI = bVar;
        AppMethodBeat.o(191994);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class d extends q implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ b GNP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(b bVar) {
            super(0);
            this.GNP = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ImageView invoke() {
            AppMethodBeat.i(191979);
            ImageView imageView = (ImageView) this.GNP.findViewById(R.id.ts);
            AppMethodBeat.o(191979);
            return imageView;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class c extends q implements kotlin.g.a.a<LinearLayout> {
        final /* synthetic */ b GNP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(b bVar) {
            super(0);
            this.GNP = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ LinearLayout invoke() {
            AppMethodBeat.i(191978);
            LinearLayout linearLayout = (LinearLayout) this.GNP.findViewById(R.id.tr);
            AppMethodBeat.o(191978);
            return linearLayout;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class h extends q implements kotlin.g.a.a<RecyclerView> {
        final /* synthetic */ b GNP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(b bVar) {
            super(0);
            this.GNP = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ RecyclerView invoke() {
            AppMethodBeat.i(191983);
            RecyclerView recyclerView = (RecyclerView) this.GNP.findViewById(R.id.gy1);
            AppMethodBeat.o(191983);
            return recyclerView;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class e extends q implements kotlin.g.a.a<WeImageView> {
        final /* synthetic */ b GNP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(b bVar) {
            super(0);
            this.GNP = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ WeImageView invoke() {
            AppMethodBeat.i(191980);
            WeImageView weImageView = (WeImageView) this.GNP.findViewById(R.id.b4d);
            AppMethodBeat.o(191980);
            return weImageView;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class f extends q implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ b GNP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(b bVar) {
            super(0);
            this.GNP = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ImageView invoke() {
            AppMethodBeat.i(191981);
            ImageView imageView = (ImageView) this.GNP.findViewById(R.id.b_l);
            AppMethodBeat.o(191981);
            return imageView;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class g extends q implements kotlin.g.a.a<View> {
        final /* synthetic */ b GNP;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(b bVar) {
            super(0);
            this.GNP = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(191982);
            View findViewById = this.GNP.findViewById(R.id.c2w);
            AppMethodBeat.o(191982);
            return findViewById;
        }
    }
}
