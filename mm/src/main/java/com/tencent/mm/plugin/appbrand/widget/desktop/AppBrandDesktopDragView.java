package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.appcache.j;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.c;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.d;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.e;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import java.util.List;

public class AppBrandDesktopDragView extends DragFeatureView {
    private int aYN = 0;
    private List nZr;
    private List omN;
    private int omO = 0;
    private boolean omP = false;
    private boolean omQ = false;
    private b omR = null;
    private int omS = 0;
    private boolean omT = false;
    private boolean omU = false;
    private boolean omV = true;
    private boolean omW = true;
    private a omX;
    private d omY;
    private int paddingLeft = 0;
    private int paddingTop = 0;

    public interface a {
        int caq();
    }

    public interface b {
        void cU(Object obj);

        void cV(Object obj);

        void cW(Object obj);

        void f(int i2, int i3, Object obj);
    }

    static /* synthetic */ float a(AppBrandDesktopDragView appBrandDesktopDragView) {
        AppMethodBeat.i(49513);
        float offsetX = appBrandDesktopDragView.getOffsetX();
        AppMethodBeat.o(49513);
        return offsetX;
    }

    static /* synthetic */ int a(AppBrandDesktopDragView appBrandDesktopDragView, Object obj) {
        AppMethodBeat.i(227754);
        int cR = appBrandDesktopDragView.cR(obj);
        AppMethodBeat.o(227754);
        return cR;
    }

    static /* synthetic */ float b(AppBrandDesktopDragView appBrandDesktopDragView) {
        AppMethodBeat.i(49514);
        float offsetY = appBrandDesktopDragView.getOffsetY();
        AppMethodBeat.o(49514);
        return offsetY;
    }

    public AppBrandDesktopDragView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(49501);
        init();
        AppMethodBeat.o(49501);
    }

    public AppBrandDesktopDragView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(49502);
        init();
        AppMethodBeat.o(49502);
    }

    private void init() {
        AppMethodBeat.i(49503);
        this.paddingTop = getResources().getDimensionPixelOffset(R.dimen.hs);
        AppMethodBeat.o(49503);
    }

    public void setViewWidth(int i2) {
        this.aYN = i2;
    }

    public void setCollectionStartPosition(int i2) {
        this.omO = i2;
    }

    public void setAppBrandCounter(a aVar) {
        this.omX = aVar;
    }

    public void setRecentListDragEnable(boolean z) {
        this.omV = z;
    }

    public void setMyListDragEnable(boolean z) {
        this.omW = z;
    }

    public void setList(List list) {
        this.nZr = list;
    }

    public void setCopyList(List list) {
        this.omN = list;
    }

    public void setCollectionCallback(b bVar) {
        this.omR = bVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.widget.desktop.DragFeatureView
    public final c P(RecyclerView.v vVar) {
        AppMethodBeat.i(49504);
        if (vVar == null || vVar.auw != 2) {
            this.omP = true;
            e eVar = new e(this, this.nZr, new f() {
                /* class com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView.AnonymousClass3 */

                @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.f
                public final Object cS(Object obj) {
                    AppMethodBeat.i(49488);
                    if (obj instanceof AppBrandDesktopView.c) {
                        AppBrandDesktopView.c cVar = new AppBrandDesktopView.c(1);
                        cVar.ooj = ((AppBrandDesktopView.c) obj).ooj;
                        AppMethodBeat.o(49488);
                        return cVar;
                    }
                    AppMethodBeat.o(49488);
                    return obj;
                }

                @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.f
                public final View cQ(View view) {
                    AppMethodBeat.i(49489);
                    View findViewById = view.findViewById(R.id.dty);
                    AppMethodBeat.o(49489);
                    return findViewById;
                }

                @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.f
                public final float cam() {
                    AppMethodBeat.i(49490);
                    float a2 = AppBrandDesktopDragView.a(AppBrandDesktopDragView.this);
                    AppMethodBeat.o(49490);
                    return a2;
                }

                @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.f
                public final float can() {
                    AppMethodBeat.i(49491);
                    float b2 = AppBrandDesktopDragView.b(AppBrandDesktopDragView.this);
                    AppMethodBeat.o(49491);
                    return b2;
                }

                @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.f
                public final void i(Object obj, int i2) {
                    if (obj instanceof AppBrandDesktopView.c) {
                        ((AppBrandDesktopView.c) obj).position = i2;
                    }
                }
            });
            eVar.ooV = getRecyclerScrollComputer();
            eVar.opC = new com.tencent.mm.plugin.appbrand.widget.desktop.a.a() {
                /* class com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView.AnonymousClass4 */

                @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.a
                public final View Q(RecyclerView.v vVar) {
                    AppMethodBeat.i(227752);
                    View a2 = AppBrandDesktopDragView.this.a((d) vVar);
                    AppMethodBeat.o(227752);
                    return a2;
                }

                @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.a
                public final void a(RecyclerView.v vVar, View view, Object obj, int i2) {
                }

                @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.a
                public final void cR(View view) {
                }

                @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.a
                public final void b(int i2, int i3, Object obj, boolean z) {
                    AppMethodBeat.i(49493);
                    if (AppBrandDesktopDragView.this.omR != null) {
                        AppBrandDesktopDragView.this.omR.f(i2, i3, obj);
                    }
                    AppMethodBeat.o(49493);
                }

                @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.a
                public final boolean c(RecyclerView.v vVar, Object obj) {
                    return vVar.auw == 1 || vVar.auw == 7;
                }

                @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.a
                public final boolean S(RecyclerView.v vVar) {
                    return false;
                }

                @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.a
                public final void cT(Object obj) {
                    AppMethodBeat.i(49494);
                    if ((obj instanceof AppBrandDesktopView.c) && AppBrandDesktopDragView.this.omR != null) {
                        AppBrandDesktopDragView.this.omR.cV(obj);
                    }
                    AppMethodBeat.o(49494);
                }

                @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.a
                public final boolean R(RecyclerView.v vVar) {
                    AppMethodBeat.i(227753);
                    if (vVar.auw != 1 || !AppBrandDesktopDragView.this.omW) {
                        AppMethodBeat.o(227753);
                        return false;
                    }
                    AppMethodBeat.o(227753);
                    return true;
                }
            };
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.k5);
            int i2 = this.paddingLeft;
            eVar.paddingTop = dimensionPixelSize;
            eVar.paddingLeft = i2;
            AppMethodBeat.o(49504);
            return eVar;
        }
        this.omP = false;
        d dVar = new d(this, this.omN, this.nZr, new d.a() {
            /* class com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.f
            public final Object cS(Object obj) {
                AppMethodBeat.i(49475);
                if (obj instanceof AppBrandDesktopView.c) {
                    AppBrandDesktopView.c cVar = (AppBrandDesktopView.c) obj;
                    AppBrandDesktopView.c cVar2 = new AppBrandDesktopView.c(1);
                    cVar2.ooj = cVar.ooj;
                    cVar2.position = cVar.position;
                    AppMethodBeat.o(49475);
                    return cVar2;
                }
                AppMethodBeat.o(49475);
                return obj;
            }

            @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.f
            public final View cQ(View view) {
                AppMethodBeat.i(49476);
                View findViewById = view.findViewById(R.id.dty);
                AppMethodBeat.o(49476);
                return findViewById;
            }

            @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.f
            public final float cam() {
                AppMethodBeat.i(49477);
                float a2 = AppBrandDesktopDragView.a(AppBrandDesktopDragView.this);
                AppMethodBeat.o(49477);
                return a2;
            }

            @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.f
            public final float can() {
                AppMethodBeat.i(49478);
                float b2 = AppBrandDesktopDragView.b(AppBrandDesktopDragView.this);
                AppMethodBeat.o(49478);
                return b2;
            }

            @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.d.a
            public final void cao() {
                AppMethodBeat.i(49479);
                Log.d("MicroMsg.AppBrandDesktopDragView", "alvinluo onInsert");
                AppBrandDesktopDragView.this.omP = true;
                AppMethodBeat.o(49479);
            }

            @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.d.a
            public final void cap() {
                AppMethodBeat.i(49480);
                Log.d("MicroMsg.AppBrandDesktopDragView", "alvinluo onCancelInsert");
                AppBrandDesktopDragView.this.omP = false;
                AppMethodBeat.o(49480);
            }

            @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.f
            public final void i(Object obj, int i2) {
                if (obj instanceof AppBrandDesktopView.c) {
                    ((AppBrandDesktopView.c) obj).position = i2;
                }
            }

            @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.d.a
            public final boolean K(Object obj, Object obj2) {
                boolean z;
                AppMethodBeat.i(49481);
                if (obj2 == null || obj == null) {
                    AppMethodBeat.o(49481);
                    return false;
                }
                if ((obj2 instanceof AppBrandDesktopView.c) && (obj instanceof AppBrandDesktopView.c)) {
                    AppBrandDesktopView.c cVar = (AppBrandDesktopView.c) obj2;
                    AppBrandDesktopView.c cVar2 = (AppBrandDesktopView.c) obj;
                    if (cVar.ooj == null || cVar2.ooj == null || Util.isNullOrNil(cVar.ooj.username) || Util.isNullOrNil(cVar2.ooj.username) || !cVar2.ooj.g(cVar.ooj)) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z) {
                        AppMethodBeat.o(49481);
                        return true;
                    }
                }
                AppMethodBeat.o(49481);
                return false;
            }
        });
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.k5);
        int i3 = this.paddingLeft;
        dVar.paddingTop = dimensionPixelSize2;
        dVar.paddingLeft = i3;
        dVar.ooV = getRecyclerScrollComputer();
        dVar.opC = new com.tencent.mm.plugin.appbrand.widget.desktop.a.a() {
            /* class com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.a
            public final View Q(RecyclerView.v vVar) {
                AppMethodBeat.i(227750);
                if (vVar instanceof d) {
                    View a2 = AppBrandDesktopDragView.this.a((d) vVar);
                    AppMethodBeat.o(227750);
                    return a2;
                }
                AppMethodBeat.o(227750);
                return null;
            }

            @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.a
            public final void a(RecyclerView.v vVar, View view, Object obj, int i2) {
                AppMethodBeat.i(49483);
                if (i2 == 6) {
                    AppBrandDesktopDragView.this.omQ = true;
                } else {
                    AppBrandDesktopDragView.this.omQ = false;
                }
                AppBrandDesktopDragView.a(AppBrandDesktopDragView.this, vVar, view, obj, i2);
                AppMethodBeat.o(49483);
            }

            @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.a
            public final void cR(View view) {
                AppMethodBeat.i(49484);
                if (view != null) {
                    View findViewById = view.findViewById(R.id.i5e);
                    if (findViewById != null) {
                        findViewById.setVisibility(4);
                    }
                    View findViewById2 = view.findViewById(R.id.rf);
                    if (findViewById2 != null) {
                        findViewById2.setVisibility(4);
                    }
                }
                AppMethodBeat.o(49484);
            }

            @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.a
            public final void b(int i2, int i3, Object obj, boolean z) {
                AppMethodBeat.i(49485);
                if (z && AppBrandDesktopDragView.this.omR != null) {
                    AppBrandDesktopDragView.this.omR.cU(obj);
                }
                AppMethodBeat.o(49485);
            }

            @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.a
            public final boolean c(RecyclerView.v vVar, Object obj) {
                AppMethodBeat.i(49486);
                if (AppBrandDesktopDragView.a(AppBrandDesktopDragView.this, obj) != 0) {
                    Log.e("MicroMsg.AppBrandDesktopDragView", "alvinluo checkCanInsert can't insert");
                    AppMethodBeat.o(49486);
                    return false;
                } else if (vVar.auw == 1 || vVar.auw == 2 || vVar.auw == 7) {
                    AppMethodBeat.o(49486);
                    return true;
                } else {
                    AppMethodBeat.o(49486);
                    return false;
                }
            }

            @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.a
            public final boolean S(RecyclerView.v vVar) {
                return vVar == null || vVar.auw == 2 || vVar.auw == 10 || vVar.auw == 11;
            }

            @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.a
            public final void cT(Object obj) {
                AppMethodBeat.i(49487);
                if (obj instanceof AppBrandDesktopView.c) {
                    ((AppBrandDesktopView.c) obj).type = 2;
                    if (AppBrandDesktopDragView.this.omR != null) {
                        AppBrandDesktopDragView.this.omR.cW(obj);
                    }
                }
                AppMethodBeat.o(49487);
            }

            @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.a
            public final boolean R(RecyclerView.v vVar) {
                AppMethodBeat.i(227751);
                if (vVar.auw != 2 || !AppBrandDesktopDragView.this.omV) {
                    AppMethodBeat.o(227751);
                    return false;
                }
                AppMethodBeat.o(227751);
                return true;
            }
        };
        AppMethodBeat.o(49504);
        return dVar;
    }

    private void m(final View view, boolean z) {
        AppMethodBeat.i(49505);
        if (view.getVisibility() == 0 && z) {
            AppMethodBeat.o(49505);
        } else if (z && this.omU) {
            AppMethodBeat.o(49505);
        } else if (view.getVisibility() != 0 && !z) {
            AppMethodBeat.o(49505);
        } else if (!z && this.omT) {
            AppMethodBeat.o(49505);
        } else if (z) {
            this.omU = true;
            view.setScaleX(0.1f);
            view.setScaleY(0.1f);
            view.setVisibility(0);
            view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(200).setListener(new Animator.AnimatorListener() {
                /* class com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView.AnonymousClass5 */

                public final void onAnimationStart(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(49495);
                    AppBrandDesktopDragView.this.omU = false;
                    AppMethodBeat.o(49495);
                }

                public final void onAnimationCancel(Animator animator) {
                    AppMethodBeat.i(49496);
                    AppBrandDesktopDragView.this.omU = false;
                    AppMethodBeat.o(49496);
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            }).start();
            AppMethodBeat.o(49505);
        } else {
            this.omT = true;
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.setVisibility(0);
            view.animate().scaleX(0.0f).scaleY(0.0f).setDuration(200).setListener(new Animator.AnimatorListener() {
                /* class com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView.AnonymousClass6 */

                public final void onAnimationStart(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(49497);
                    AppBrandDesktopDragView.this.omT = false;
                    view.setVisibility(4);
                    AppMethodBeat.o(49497);
                }

                public final void onAnimationCancel(Animator animator) {
                    AppMethodBeat.i(49498);
                    AppBrandDesktopDragView.this.omT = false;
                    view.setVisibility(4);
                    AppMethodBeat.o(49498);
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            }).start();
            AppMethodBeat.o(49505);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.widget.desktop.DragFeatureView
    public void setRubbishViewVisible(int i2) {
        AppMethodBeat.i(49506);
        super.setRubbishViewVisible(i2);
        AppMethodBeat.o(49506);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.widget.desktop.DragFeatureView
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(49507);
        super.onLayout(z, i2, i3, i4, i5);
        getGlobalVisibleRect(this.ooO);
        this.ooO.set(this.ooO.left, ((this.ooO.bottom - this.ooH) - ((int) (((float) getContext().getResources().getDimensionPixelSize(R.dimen.a8y)) * 1.0f))) - 40, this.ooO.right, this.ooO.bottom - this.ooH);
        Log.i("MicroMsg.AppBrandDesktopDragView", "alvinluo bottomRect: %s", this.ooO);
        getRecyclerView().getGlobalVisibleRect(this.ooP);
        this.ooP.set(this.ooP.left, 0, this.ooP.right, this.ooP.top + this.ooH);
        AppMethodBeat.o(49507);
    }

    public void setItemPadding(int i2) {
        this.paddingLeft = i2;
    }

    private int cR(Object obj) {
        boolean z;
        AppMethodBeat.i(49508);
        if (this.omP) {
            z = this.omX != null && this.omX.caq() + -1 >= a.byo();
        } else {
            z = this.omX != null && this.omX.caq() >= a.byo();
        }
        if (z) {
            Log.i("MicroMsg.AppBrandDesktopDragView", "alvinluo checkCanInsert current: %d, over limit: %d", Integer.valueOf(this.omX.caq()), Integer.valueOf(a.byo()));
            AppMethodBeat.o(49508);
            return 2;
        }
        if (obj instanceof AppBrandDesktopView.c) {
            AppBrandDesktopView.c cVar = (AppBrandDesktopView.c) obj;
            if (cVar.ooj != null) {
                if (!j.a.vP(cVar.ooj.iOo)) {
                    AppMethodBeat.o(49508);
                    return 0;
                } else if (cVar.ooj.kWb <= System.currentTimeMillis() / 1000) {
                    AppMethodBeat.o(49508);
                    return 0;
                } else {
                    AppMethodBeat.o(49508);
                    return 1;
                }
            }
        }
        AppMethodBeat.o(49508);
        return 99;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.appbrand.widget.desktop.DragFeatureView
    public final RecyclerView.v e(float f2, float f3, boolean z) {
        AppMethodBeat.i(49509);
        getRecyclerView().getGlobalVisibleRect(this.mRect);
        if (!this.mRect.contains((int) f2, (int) f3)) {
            AppMethodBeat.o(49509);
            return null;
        }
        boolean z2 = false;
        RecyclerView.v vVar = null;
        for (int i2 = 0; i2 < getRecyclerView().getChildCount(); i2++) {
            RecyclerView.v bi = getRecyclerView().bi(getRecyclerView().getChildAt(i2));
            if (!(bi.auw == 7 || bi.auw == 3 || bi.auw == 8)) {
                bi.aus.getGlobalVisibleRect(this.mRect);
                if (!this.mRect.contains((int) f2, (int) f3)) {
                    continue;
                } else {
                    if (2 == bi.auw) {
                        RecyclerView recyclerView = (RecyclerView) bi.aus.findViewById(R.id.gu3);
                        int i3 = 0;
                        while (i3 < recyclerView.getAdapter().getItemCount()) {
                            RecyclerView.v ch = recyclerView.ch(i3);
                            if (!(ch == null || ch.aus == null)) {
                                ch.aus.getGlobalVisibleRect(this.mRect);
                                if (this.mRect.contains((int) f2, (int) f3)) {
                                    z2 = true;
                                    i3++;
                                    vVar = ch;
                                }
                            }
                            ch = vVar;
                            i3++;
                            vVar = ch;
                        }
                        if (z2) {
                            continue;
                        } else if (z) {
                            AppMethodBeat.o(49509);
                            return null;
                        }
                    }
                    z2 = true;
                    vVar = bi;
                }
            }
        }
        if (z2) {
            AppMethodBeat.o(49509);
            return vVar;
        }
        if (!z) {
            for (int childCount = getRecyclerView().getChildCount() - 1; childCount >= 0; childCount--) {
                RecyclerView.v bi2 = getRecyclerView().bi(getRecyclerView().getChildAt(childCount));
                if (this.omP) {
                    if (bi2.auw == 1) {
                        AppMethodBeat.o(49509);
                        return bi2;
                    }
                } else if (bi2.auw == 7) {
                    AppMethodBeat.o(49509);
                    return bi2;
                }
            }
        }
        AppMethodBeat.o(49509);
        return null;
    }

    /* access modifiers changed from: protected */
    public final View a(d dVar) {
        AppMethodBeat.i(49510);
        View inflate = aa.jQ(getContext()).inflate(R.layout.aye, (ViewGroup) null, false);
        inflate.setLayoutParams(new RecyclerView.LayoutParams(-2, -2));
        this.omY = new d(inflate);
        d dVar2 = this.omY;
        View view = dVar2.aus;
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setAlpha(1.0f);
        view.setVisibility(0);
        int[] iArr = new int[2];
        dVar.nnL.getLocationOnScreen(iArr);
        dVar2.nnL.setImageDrawable(dVar.nnL.getDrawable());
        dVar2.nnL.setBackground(dVar.nnL.getBackground());
        dVar2.ooD.setText(dVar.ooD.getText());
        dVar2.ooD.setVisibility(dVar.ooD.getVisibility());
        dVar2.ooE.setVisibility(4);
        float ey = b.ey(getContext());
        float fromDPToPix = (1.5f * ey) + ((float) (com.tencent.mm.cb.a.fromDPToPix(getContext(), 8) * 2));
        Log.i("MicroMsg.AppBrandDesktopDragView", "alvinluo fillFloatView iconLayout: %f", Float.valueOf(fromDPToPix));
        view.findViewById(R.id.du7).getLayoutParams().height = (int) fromDPToPix;
        dVar2.ooC.getLayoutParams().height = (int) fromDPToPix;
        dVar2.ooC.getLayoutParams().width = ((int) ey) + ((int) (((float) (com.tencent.mm.cb.a.aH(getContext(), R.dimen.k5) * 2)) * b.ez(getContext())));
        dVar2.nnL.getLayoutParams().width = (int) ey;
        dVar2.nnL.getLayoutParams().height = (int) ey;
        dVar2.ooB.getLayoutParams().width = (int) ey;
        dVar2.ooB.getLayoutParams().height = (int) ey;
        ViewGroup.LayoutParams layoutParams = dVar2.ooE.getLayoutParams();
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) layoutParams).topMargin = com.tencent.mm.cb.a.fromDPToPix(getContext(), 6) + ((int) ((ey * 0.5f) / 2.0f));
            layoutParams.width = (int) (((float) getContext().getResources().getDimensionPixelSize(R.dimen.hs)) * b.ez(getContext()));
            layoutParams.height = (int) (((float) getContext().getResources().getDimensionPixelSize(R.dimen.hs)) * b.ez(getContext()));
        }
        iArr[0] = (int) (((float) iArr[0]) + (ey / 2.0f));
        iArr[1] = (int) (((float) iArr[1]) + (ey / 2.0f));
        float offsetX = getOffsetX() + ((float) iArr[0]);
        float offsetY = getOffsetY() + ((float) iArr[1]);
        view.findViewById(R.id.rf).setVisibility(4);
        view.findViewById(R.id.dty).animate().alpha(0.5f).setDuration(300).setListener(null).start();
        hx(false);
        view.findViewById(R.id.dty).animate().scaleX(1.5f).scaleY(1.5f).setDuration(300).setListener(new Animator.AnimatorListener() {
            /* class com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView.AnonymousClass7 */

            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(49499);
                AppBrandDesktopDragView.this.hx(true);
                AppMethodBeat.o(49499);
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        }).start();
        ImageView imageView = (ImageView) view.findViewById(R.id.i5e);
        imageView.getLayoutParams().height = (int) (((float) com.tencent.mm.cb.a.fromDPToPix(getContext(), 24)) * b.ez(getContext()));
        imageView.getLayoutParams().width = (int) (((float) com.tencent.mm.cb.a.fromDPToPix(getContext(), 24)) * b.ez(getContext()));
        imageView.setTranslationY(((-ey) * 0.5f) / 2.0f);
        imageView.setTranslationX((ey * 0.5f) / 2.0f);
        view.setTranslationX(offsetX);
        view.setTranslationY(offsetY);
        Log.i("MicroMsg.AppBrandDesktopDragView", "alvinluo fillFloatView offsetX: %f, transX: %f, transY: %f", Float.valueOf(getOffsetX()), Float.valueOf(offsetX), Float.valueOf(offsetY));
        AppMethodBeat.o(49510);
        return view;
    }

    private float getOffsetX() {
        AppMethodBeat.i(49511);
        float f2 = ((float) (-this.aYN)) / 2.0f;
        AppMethodBeat.o(49511);
        return f2;
    }

    private float getOffsetY() {
        AppMethodBeat.i(49512);
        float fromDPToPix = (-0.0f - ((float) com.tencent.mm.cb.a.fromDPToPix(getContext(), 40))) - (((b.ey(getContext()) * 1.5f) + ((float) (com.tencent.mm.cb.a.fromDPToPix(getContext(), 8) * 2))) / 2.0f);
        AppMethodBeat.o(49512);
        return fromDPToPix;
    }

    static /* synthetic */ void a(AppBrandDesktopDragView appBrandDesktopDragView, RecyclerView.v vVar, View view, Object obj, int i2) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(49515);
        if (view != null) {
            if (appBrandDesktopDragView.omQ) {
                z = false;
            } else {
                z = true;
            }
            if (vVar == null) {
                z = false;
            }
            if (vVar != null && (vVar.aus instanceof RecentAppBrandViewContainer)) {
                z = false;
            }
            if (i2 == 2) {
                z2 = true;
            } else {
                z2 = z;
            }
            ImageView imageView = (ImageView) view.findViewById(R.id.i5e);
            if (imageView != null) {
                if (!z2 || vVar == null || !(vVar.auw == 1 || vVar.auw == 7)) {
                    view.findViewById(R.id.rf).setVisibility(4);
                    appBrandDesktopDragView.m(imageView, false);
                } else {
                    int cR = appBrandDesktopDragView.cR(obj);
                    if (cR == 0) {
                        view.findViewById(R.id.rf).setVisibility(4);
                        imageView.setImageResource(R.raw.app_brand_desktop_add_icon);
                        appBrandDesktopDragView.m(imageView, true);
                        AppMethodBeat.o(49515);
                        return;
                    } else if (cR == 1) {
                        imageView.setVisibility(4);
                        view.findViewById(R.id.rf).setVisibility(0);
                        ((TextView) view.findViewById(R.id.re)).setText(R.string.i7);
                        AppMethodBeat.o(49515);
                        return;
                    } else if (cR == 2) {
                        imageView.setVisibility(4);
                        view.findViewById(R.id.rf).setVisibility(0);
                        ((TextView) view.findViewById(R.id.re)).setText(String.format(appBrandDesktopDragView.getContext().getResources().getString(R.string.k4), Integer.valueOf(a.byo())));
                        AppMethodBeat.o(49515);
                        return;
                    } else {
                        imageView.setVisibility(4);
                        view.findViewById(R.id.rf).setVisibility(4);
                        AppMethodBeat.o(49515);
                        return;
                    }
                }
            }
        }
        AppMethodBeat.o(49515);
    }
}
