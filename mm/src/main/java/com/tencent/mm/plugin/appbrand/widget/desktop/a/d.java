package com.tencent.mm.plugin.appbrand.widget.desktop.a;

import android.animation.Animator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView;
import com.tencent.mm.plugin.appbrand.widget.desktop.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collections;
import java.util.List;

public final class d<T extends RecyclerView.v> extends b<T> {
    int bNu = 0;
    FrameLayout cIL;
    int endPos = 0;
    View ooN;
    public f ooV = null;
    Object opA;
    boolean opB;
    public a opC;
    a opD;
    private List opy;
    List opz;
    public int paddingLeft = 0;
    public int paddingTop = 0;

    public interface a extends f {
        boolean K(Object obj, Object obj2);

        void cao();

        void cap();
    }

    public d(FrameLayout frameLayout, List list, List list2, a aVar) {
        this.cIL = frameLayout;
        this.opy = list;
        this.opD = aVar;
        this.opz = list2;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.c
    public final boolean R(T t) {
        AppMethodBeat.i(49826);
        if (this.opC != null) {
            boolean R = this.opC.R(t);
            AppMethodBeat.o(49826);
            return R;
        } else if (t == null) {
            AppMethodBeat.o(49826);
            return false;
        } else {
            AppMethodBeat.o(49826);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.c
    public final View g(RecyclerView recyclerView, T t) {
        AppMethodBeat.i(49827);
        this.ooN = i(recyclerView, t);
        if (this.ooN != null) {
            FrameLayout frameLayout = this.cIL;
            View i2 = i(recyclerView, t);
            this.ooN = i2;
            frameLayout.addView(i2);
            if (t.lR() >= 0 || this.ooN == null) {
                this.opB = false;
                if (t.lR() < this.opy.size()) {
                    this.opA = this.opD.cS(this.opy.get(t.lR()));
                    this.bNu = t.lR();
                    View view = this.ooN;
                    AppMethodBeat.o(49827);
                    return view;
                }
            } else {
                this.cIL.removeView(this.ooN);
                this.ooN = null;
                AppMethodBeat.o(49827);
                return null;
            }
        }
        AppMethodBeat.o(49827);
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.c
    public final boolean T(T t) {
        AppMethodBeat.i(49828);
        if (this.opC != null) {
            boolean c2 = this.opC.c(t, this.opA);
            AppMethodBeat.o(49828);
            return c2;
        }
        AppMethodBeat.o(49828);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.c
    public final boolean a(final RecyclerView recyclerView, T t, T t2, final int i2, final int i3) {
        AppMethodBeat.i(49829);
        Log.i("ItemInsertHelper", "alvinluo ItemInsertHelper onMoved isHasInserted: " + this.opB + ", from: " + i2 + ", to: " + i3);
        if (i3 < 0) {
            AppMethodBeat.o(49829);
            return false;
        }
        if (!this.opB) {
            this.opz.add(i3, this.opA);
            recyclerView.post(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.widget.desktop.a.d.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(49821);
                    recyclerView.getAdapter().cj(i3);
                    AppMethodBeat.o(49821);
                }
            });
            this.opB = true;
            if (this.opD != null) {
                this.opD.cao();
            }
        } else if (i2 < 0 || i2 >= this.opz.size() || i3 < 0 || i3 >= this.opz.size()) {
            AppMethodBeat.o(49829);
            return false;
        } else if (i2 < i3) {
            for (int i4 = i2; i4 < i3; i4++) {
                Collections.swap(this.opz, i4, i4 + 1);
            }
            if (recyclerView != null) {
                recyclerView.post(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.widget.desktop.a.d.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(49822);
                        recyclerView.getAdapter().ar(i2, i3);
                        AppMethodBeat.o(49822);
                    }
                });
            }
        } else if (i2 > i3) {
            for (int i5 = i2; i5 > i3; i5--) {
                Collections.swap(this.opz, i5, i5 - 1);
            }
            if (recyclerView != null) {
                recyclerView.post(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.widget.desktop.a.d.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(49823);
                        recyclerView.getAdapter().ar(i2, i3);
                        AppMethodBeat.o(49823);
                    }
                });
            }
        }
        this.endPos = i3;
        if (this.opD != null) {
            this.opD.i(this.opA, i3);
        }
        AppMethodBeat.o(49829);
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.c
    public final void a(final RecyclerView recyclerView, final RecyclerView.v vVar, final int i2, final Runnable runnable) {
        float height;
        AppMethodBeat.i(49830);
        if (this.opC != null) {
            this.opC.cR(this.ooN);
        }
        final AnonymousClass4 r3 = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.widget.desktop.a.d.AnonymousClass4 */

            public final void run() {
                int i2;
                AppMethodBeat.i(49824);
                if (d.this.opB) {
                    d dVar = d.this;
                    RecyclerView recyclerView = recyclerView;
                    Object obj = d.this.opA;
                    int i3 = i2;
                    Log.i("ItemInsertHelper", "alvinluo checkDuplicate position: %d", Integer.valueOf(i3));
                    if (obj != null) {
                        if (dVar.opD != null) {
                            i2 = -1;
                            for (int i4 = 0; i4 < dVar.opz.size(); i4++) {
                                if (dVar.opD.K(obj, dVar.opz.get(i4)) && i4 != i3) {
                                    i2 = i4;
                                }
                            }
                        } else {
                            i2 = -1;
                        }
                        if (i2 != -1 && i2 < dVar.opz.size()) {
                            Log.i("ItemInsertHelper", "alvinluo checkDuplicate targetPosition: %d", Integer.valueOf(i2));
                            dVar.opz.remove(i2);
                            recyclerView.getAdapter().ck(i2);
                        }
                    }
                }
                if (d.this.opC != null) {
                    d.this.opC.b(d.this.bNu, d.this.endPos, d.this.opA, d.this.opB);
                }
                runnable.run();
                AppMethodBeat.o(49824);
            }
        };
        if (vVar == null || this.ooN == null) {
            Log.e("ItemInsertHelper", "alvinluo finishMove viewHolder is null");
            AppMethodBeat.o(49830);
            return;
        }
        Log.i("ItemInsertHelper", "[finishMove] position:" + vVar.lR() + " dragViewPosition:" + i2);
        final RecyclerView.v ch = recyclerView.ch(i2);
        float translationX = this.ooN.getTranslationX();
        float translationY = this.ooN.getTranslationY();
        if (!this.opB) {
            float cam = this.opD.cam() + f(recyclerView, vVar);
            height = e(recyclerView, vVar) + this.opD.can();
            translationX = cam;
        } else if (ch == null || i2 != ch.lR()) {
            if (((LinearLayoutManager) recyclerView.getLayoutManager()).ks() > i2) {
                height = translationY - ((float) recyclerView.getHeight());
            } else {
                height = ((float) recyclerView.getHeight()) + translationY;
            }
        } else if (this.opB) {
            float cam2 = this.opD.cam() + f(recyclerView, ch);
            height = e(recyclerView, ch) + this.opD.can();
            translationX = cam2;
        } else {
            height = translationY;
        }
        View cQ = this.opD.cQ(this.ooN);
        if (cQ == null) {
            cQ = this.ooN;
        }
        Log.i("ItemInsertHelper", "alvinluo finishMove transX: %f, transY: %f", Float.valueOf(translationX), Float.valueOf(height));
        this.ooN.findViewById(R.id.i5e).setVisibility(4);
        cQ.animate().scaleX(1.0f).scaleY(1.0f).setDuration(300).setListener(null).start();
        this.ooN.animate().translationX(translationX).translationY(height).setDuration(300).setListener(new Animator.AnimatorListener() {
            /* class com.tencent.mm.plugin.appbrand.widget.desktop.a.d.AnonymousClass5 */

            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(49825);
                d.this.cIL.removeView(d.this.ooN);
                if (!d.this.opB) {
                    vVar.aus.setVisibility(0);
                    r3.run();
                    AppMethodBeat.o(49825);
                    return;
                }
                if (!(ch == null || ch.aus == null)) {
                    ch.aus.setVisibility(0);
                }
                if (vVar != null) {
                    vVar.aus.setVisibility(0);
                    vVar.aus.setScaleX(0.0f);
                    vVar.aus.setScaleY(0.0f);
                    vVar.aus.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(300).setListener(null).start();
                }
                r3.run();
                d.this.ooN.setScaleX(1.0f);
                d.this.ooN.setScaleY(1.0f);
                AppMethodBeat.o(49825);
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        }).start();
        AppMethodBeat.o(49830);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.c
    public final void a(View view, float f2, float f3, RecyclerView.v vVar, int i2) {
        AppMethodBeat.i(49831);
        if (view == null) {
            AppMethodBeat.o(49831);
            return;
        }
        view.setTranslationX(view.getTranslationX() - f2);
        view.setTranslationY(view.getTranslationY() - f3);
        if (this.opC != null) {
            this.opC.a(vVar, view, this.opA, i2);
        }
        AppMethodBeat.o(49831);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.c
    public final boolean S(T t) {
        AppMethodBeat.i(49832);
        if (this.opC != null) {
            boolean S = this.opC.S(t);
            AppMethodBeat.o(49832);
            return S;
        }
        AppMethodBeat.o(49832);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.c
    public final void h(RecyclerView recyclerView, T t) {
        AppMethodBeat.i(49833);
        int lR = t.lR();
        Log.i("ItemInsertHelper", "[onDelete] position:".concat(String.valueOf(lR)));
        if (lR >= 0 && lR < this.opy.size()) {
            this.opy.remove(lR);
        }
        i(recyclerView);
        if (this.opC != null) {
            if (this.opA instanceof AppBrandDesktopView.c) {
                ((AppBrandDesktopView.c) this.opA).position = t.lR();
            }
            this.opC.cT(this.opA);
        }
        AppMethodBeat.o(49833);
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.desktop.a.c
    public final void h(RecyclerView recyclerView) {
        AppMethodBeat.i(49834);
        Log.i("ItemInsertHelper", "alvinluo onCancel");
        i(recyclerView);
        AppMethodBeat.o(49834);
    }

    private void i(RecyclerView recyclerView) {
        AppMethodBeat.i(49835);
        if (this.opB) {
            int indexOf = this.opz.indexOf(this.opA);
            if (indexOf >= 0) {
                this.opz.remove(indexOf);
                recyclerView.getAdapter().ck(indexOf);
            }
            this.opB = false;
            if (this.opD != null) {
                this.opD.cap();
            }
        }
        AppMethodBeat.o(49835);
    }

    private View i(RecyclerView recyclerView, T t) {
        AppMethodBeat.i(49836);
        t.aus.setVisibility(4);
        View Q = this.opC.Q(t);
        Q.setVisibility(0);
        AppMethodBeat.o(49836);
        return Q;
    }
}
