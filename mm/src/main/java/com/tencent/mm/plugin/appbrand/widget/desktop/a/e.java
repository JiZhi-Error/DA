package com.tencent.mm.plugin.appbrand.widget.desktop.a;

import android.animation.Animator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.desktop.d;
import com.tencent.mm.plugin.appbrand.widget.desktop.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collections;
import java.util.List;

public final class e<T extends RecyclerView.v> extends b<T> {
    int bNu = 0;
    FrameLayout cIL;
    int endPos = 0;
    private List nZr;
    View ooN;
    public f ooV = null;
    public a opC;
    Object opL;
    private f opM;
    public int paddingLeft = 0;
    public int paddingTop = 0;

    public e(FrameLayout frameLayout, List list, f fVar) {
        this.cIL = frameLayout;
        this.nZr = list;
        this.opM = fVar;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.c
    public final boolean R(T t) {
        AppMethodBeat.i(49840);
        if (this.opC != null) {
            boolean R = this.opC.R(t);
            AppMethodBeat.o(49840);
            return R;
        } else if (t == null) {
            AppMethodBeat.o(49840);
            return false;
        } else {
            AppMethodBeat.o(49840);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.c
    public final boolean T(T t) {
        AppMethodBeat.i(49842);
        if (this.opC != null) {
            boolean c2 = this.opC.c(t, null);
            AppMethodBeat.o(49842);
            return c2;
        }
        AppMethodBeat.o(49842);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.c
    public final boolean a(RecyclerView recyclerView, T t, T t2, int i2, int i3) {
        AppMethodBeat.i(49843);
        Log.i("MicroMsg.ItemMoveHelper", "[onMoved] position:" + t.lR() + " target:" + t2.lR());
        Log.i("MicroMsg.ItemMoveHelper", "alvinluo onMoved mList: %d", Integer.valueOf(this.nZr.hashCode()));
        if (i2 < 0 || i2 >= this.nZr.size() || i3 < 0 || i3 >= this.nZr.size()) {
            AppMethodBeat.o(49843);
            return false;
        }
        if (i2 < i3) {
            for (int i4 = i2; i4 < i3; i4++) {
                Collections.swap(this.nZr, i4, i4 + 1);
            }
        } else {
            for (int i5 = i2; i5 > i3; i5--) {
                Collections.swap(this.nZr, i5, i5 - 1);
            }
        }
        Log.i("MicroMsg.ItemMoveHelper", "alvinluo onMoved end mList: %d", Integer.valueOf(this.nZr.hashCode()));
        recyclerView.getAdapter().ar(i2, i3);
        if (this.opM != null) {
            this.endPos = i3;
            this.opM.i(this.opL, i3);
        }
        AppMethodBeat.o(49843);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.c
    public final void a(RecyclerView recyclerView, T t, int i2, final Runnable runnable) {
        float f2;
        AppMethodBeat.i(49844);
        if (this.opC != null) {
            this.opC.cR(this.ooN);
        }
        final AnonymousClass1 r3 = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.widget.desktop.a.e.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(49838);
                if (e.this.opC != null) {
                    e.this.opC.b(e.this.bNu, e.this.endPos, e.this.opL, true);
                }
                runnable.run();
                AppMethodBeat.o(49838);
            }
        };
        if (!(t == null || this.ooN == null)) {
            Log.i("ItemMoveHelper", "[finishMove] position" + t.lR() + " dragViewPosition:" + i2);
            final RecyclerView.v ch = recyclerView.ch(i2);
            float translationX = this.ooN.getTranslationX();
            float translationY = this.ooN.getTranslationY();
            if (i2 != t.lR() && ch == null) {
                f2 = ((LinearLayoutManager) recyclerView.getLayoutManager()).ks() > i2 ? translationY - ((float) recyclerView.getHeight()) : ((float) recyclerView.getHeight()) + translationY;
            } else if (ch != null) {
                float cam = this.opM.cam() + f(recyclerView, ch);
                f2 = e(recyclerView, ch) + this.opM.can();
                translationX = cam;
            } else {
                f2 = translationY;
            }
            View cQ = this.opM.cQ(this.ooN);
            if (cQ == null) {
                cQ = this.ooN;
            }
            cQ.animate().scaleX(1.0f).scaleY(1.0f).setDuration(300).setListener(null).start();
            this.ooN.animate().translationX(translationX).translationY(f2).setDuration(300).setListener(new Animator.AnimatorListener() {
                /* class com.tencent.mm.plugin.appbrand.widget.desktop.a.e.AnonymousClass2 */

                public final void onAnimationStart(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(49839);
                    e.this.cIL.removeView(e.this.ooN);
                    e.this.ooN.setVisibility(8);
                    if (ch != null) {
                        ch.aus.setVisibility(0);
                    }
                    r3.run();
                    AppMethodBeat.o(49839);
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            }).start();
        }
        AppMethodBeat.o(49844);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.c
    public final void a(View view, float f2, float f3, RecyclerView.v vVar, int i2) {
        AppMethodBeat.i(49845);
        if (view == null) {
            AppMethodBeat.o(49845);
            return;
        }
        view.setTranslationX(view.getTranslationX() - f2);
        view.setTranslationY(view.getTranslationY() - f3);
        AppMethodBeat.o(49845);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.c
    public final boolean S(T t) {
        AppMethodBeat.i(49846);
        if (this.opC != null) {
            boolean S = this.opC.S(t);
            AppMethodBeat.o(49846);
            return S;
        }
        AppMethodBeat.o(49846);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.c
    public final void h(RecyclerView recyclerView) {
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.c
    public final void h(RecyclerView recyclerView, T t) {
        AppMethodBeat.i(49847);
        Log.i("MicroMsg.ItemMoveHelper", "alvinluo onDelete adapter position: %d", Integer.valueOf(t.lR()));
        if (t instanceof d) {
            Log.i("MicroMsg.ItemMoveHelper", "alvinluo onDelete holder: %s", ((d) t).titleTv.getText());
        }
        this.nZr.remove(t.lR());
        Log.i("MicroMsg.ItemMoveHelper", "alvinluo mList hashCode: %d", Integer.valueOf(this.nZr.hashCode()));
        recyclerView.getAdapter().ck(t.lR());
        if (this.opC != null) {
            this.opC.cT(this.opL);
        }
        AppMethodBeat.o(49847);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.c
    public final View g(RecyclerView recyclerView, T t) {
        AppMethodBeat.i(49841);
        FrameLayout frameLayout = this.cIL;
        t.aus.setVisibility(4);
        View Q = this.opC.Q(t);
        Q.setAlpha(1.0f);
        Q.setScaleX(1.0f);
        Q.setScaleY(1.0f);
        Q.setVisibility(0);
        this.ooN = Q;
        frameLayout.addView(Q);
        Log.i("MicroMsg.ItemMoveHelper", "[onDragBegin] position:" + t.lR());
        if (t.lR() >= 0 || this.ooN == null) {
            if (this.opM != null && this.nZr.size() > t.lR()) {
                this.opL = this.opM.cS(this.nZr.get(t.lR()));
                this.bNu = t.lR();
                this.endPos = this.bNu;
            }
            View view = this.ooN;
            AppMethodBeat.o(49841);
            return view;
        }
        this.cIL.removeView(this.ooN);
        this.ooN = null;
        AppMethodBeat.o(49841);
        return null;
    }
}
