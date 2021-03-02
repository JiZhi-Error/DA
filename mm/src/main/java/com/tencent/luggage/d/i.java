package com.tencent.luggage.d;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.luggage.d.l;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public class i implements k {
    protected Class<? extends com.tencent.luggage.webview.a> ctk;
    public FrameLayout ctl;
    public a<h> ctm = new a<>(this, (byte) 0);
    protected e ctn;
    public f cto;
    public m ctp;
    Integer ctq = null;
    private Class<? extends com.tencent.luggage.webview.a> ctr = null;
    public j cts = new j() {
        /* class com.tencent.luggage.d.i.AnonymousClass9 */

        /* access modifiers changed from: package-private */
        @Override // com.tencent.luggage.d.j
        public final Context getContext() {
            return i.this.mContext;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.luggage.d.j
        public final Class<? extends com.tencent.luggage.webview.a> Lr() {
            AppMethodBeat.i(174612);
            Class<? extends com.tencent.luggage.webview.a> Lr = i.this.Lr();
            AppMethodBeat.o(174612);
            return Lr;
        }

        @Override // com.tencent.luggage.d.j
        public final LinkedList<h> Lx() {
            return i.this.ctm;
        }

        @Override // com.tencent.luggage.d.j
        public final k Ly() {
            return i.this;
        }

        @Override // com.tencent.luggage.d.j
        public final LinkedList<Class<? extends b>> Lz() {
            AppMethodBeat.i(174613);
            LinkedList<Class<? extends b>> linkedList = (LinkedList) i.this.ctn.ctd.clone();
            AppMethodBeat.o(174613);
            return linkedList;
        }

        @Override // com.tencent.luggage.d.j
        public final p Lq() {
            AppMethodBeat.i(174614);
            p a2 = i.a(i.this);
            AppMethodBeat.o(174614);
            return a2;
        }

        @Override // com.tencent.luggage.d.j
        public final f LA() {
            return i.this.cto;
        }
    };
    protected Context mContext;

    static /* synthetic */ p a(i iVar) {
        AppMethodBeat.i(140409);
        p Lq = iVar.Lq();
        AppMethodBeat.o(140409);
        return Lq;
    }

    static /* synthetic */ void a(i iVar, h hVar) {
        AppMethodBeat.i(221184);
        iVar.a(hVar);
        AppMethodBeat.o(221184);
    }

    public i(Activity activity) {
        AppMethodBeat.i(140390);
        this.mContext = activity;
        FrameLayout frameLayout = new FrameLayout(this.mContext);
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setBackgroundColor(-1);
        this.ctl = frameLayout;
        this.ctn = new e();
        a((m) null);
        this.cto = f.aK(activity);
        AppMethodBeat.o(140390);
    }

    public final View getContentView() {
        return this.ctl;
    }

    public final j Lm() {
        return this.cts;
    }

    public final h Ln() {
        AppMethodBeat.i(140391);
        if (this.ctm.size() > 0) {
            h peek = this.ctm.peek();
            AppMethodBeat.o(140391);
            return peek;
        }
        AppMethodBeat.o(140391);
        return null;
    }

    public final void destroy() {
        AppMethodBeat.i(140392);
        Iterator it = this.ctm.iterator();
        while (it.hasNext()) {
            ((h) it.next()).destroy();
        }
        p Lq = Lq();
        if (Lq != null) {
            Lq.destroy();
        }
        f.aL(this.mContext);
        AppMethodBeat.o(140392);
    }

    @Override // com.tencent.luggage.d.k
    public final boolean cS(String str) {
        AppMethodBeat.i(140393);
        boolean h2 = h(str, null);
        AppMethodBeat.o(140393);
        return h2;
    }

    @Override // com.tencent.luggage.d.k
    public final boolean h(String str, Bundle bundle) {
        AppMethodBeat.i(140394);
        boolean a2 = a(str, bundle, !this.ctm.isEmpty());
        AppMethodBeat.o(140394);
        return a2;
    }

    public final boolean a(String str, Bundle bundle, final boolean z) {
        AppMethodBeat.i(140395);
        final h k = this.ctp.k(str, bundle);
        if (k == null) {
            Log.e("LuggagePageContainer", "No page specified for url %s", str);
            AppMethodBeat.o(140395);
            return false;
        } else if (!Lw()) {
            Log.i("LuggagePageContainer", "Pushing page is banned");
            AppMethodBeat.o(140395);
            return false;
        } else {
            this.ctl.addView(k.getContentView(), 0);
            k.getContentView().setVisibility(4);
            final AnonymousClass1 r0 = new Runnable() {
                /* class com.tencent.luggage.d.i.AnonymousClass1 */
                boolean done = false;

                public final void run() {
                    AppMethodBeat.i(140375);
                    i.this.Lv();
                    if (this.done) {
                        AppMethodBeat.o(140375);
                        return;
                    }
                    this.done = true;
                    if (i.this.ctm.peek() != null && z) {
                        h peek = i.this.ctm.peek();
                        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(peek.getContentView(), "translationX", 0.0f, -(((float) peek.getContentView().getWidth()) * 0.25f));
                        ofFloat.setDuration(250L);
                        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(peek.getContentView(), "translationX", 0.0f);
                        ofFloat2.setDuration(0L);
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playSequentially(ofFloat, ofFloat2);
                        peek.a(animatorSet, null);
                        i.this.ctm.peek().Lj();
                    }
                    k.getContentView().bringToFront();
                    k.getContentView().setVisibility(0);
                    k.Li();
                    AnonymousClass1 r0 = new Runnable() {
                        /* class com.tencent.luggage.d.i.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(140374);
                            i.this.ctm.push(k);
                            i.this.Lp();
                            AppMethodBeat.o(140374);
                        }
                    };
                    if (z) {
                        h hVar = k;
                        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(hVar.getContentView(), "translationX", (float) hVar.getContentView().getWidth(), 0.0f);
                        ofFloat3.setDuration(250L);
                        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(hVar.getContentView(), "alpha", 0.0f, 1.0f);
                        ofFloat4.setDuration(166L);
                        AnimatorSet animatorSet2 = new AnimatorSet();
                        animatorSet2.playTogether(ofFloat3, ofFloat4);
                        hVar.a(animatorSet2, r0);
                        AppMethodBeat.o(140375);
                        return;
                    }
                    r0.run();
                    AppMethodBeat.o(140375);
                }
            };
            k.ctf.a(new l.e() {
                /* class com.tencent.luggage.d.i.AnonymousClass2 */

                @Override // com.tencent.luggage.d.l.e
                public final void onReady() {
                    AppMethodBeat.i(140376);
                    r0.run();
                    AppMethodBeat.o(140376);
                }
            });
            Lu();
            k.g(str, bundle);
            c(r0, 300);
            if (!z) {
                r0.run();
            }
            AppMethodBeat.o(140395);
            return true;
        }
    }

    @Override // com.tencent.luggage.d.k
    public final boolean Lo() {
        AppMethodBeat.i(140396);
        boolean bR = bR(true);
        AppMethodBeat.o(140396);
        return bR;
    }

    @Override // com.tencent.luggage.d.k
    public final boolean bR(boolean z) {
        AppMethodBeat.i(140397);
        if (this.ctm.size() <= 1) {
            AppMethodBeat.o(140397);
            return false;
        }
        final h pop = this.ctm.pop();
        if (z) {
            pop.h(new Runnable() {
                /* class com.tencent.luggage.d.i.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(140377);
                    i.a(i.this, pop);
                    AppMethodBeat.o(140377);
                }
            });
        } else {
            a(pop);
        }
        if (z) {
            this.ctm.peek().g(new Runnable() {
                /* class com.tencent.luggage.d.i.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(140378);
                    i.this.ctm.peek().Li();
                    AppMethodBeat.o(140378);
                }
            });
        } else {
            this.ctm.peek().Li();
        }
        AppMethodBeat.o(140397);
        return true;
    }

    @Override // com.tencent.luggage.d.k
    public final boolean remove(int i2) {
        AppMethodBeat.i(140398);
        if (i2 < 0) {
            AppMethodBeat.o(140398);
            return true;
        } else if (this.ctm.size() <= 1 || this.ctm.size() <= i2) {
            AppMethodBeat.o(140398);
            return false;
        } else if (i2 == 0) {
            boolean bR = bR(false);
            AppMethodBeat.o(140398);
            return bR;
        } else {
            a(this.ctm.remove(i2));
            AppMethodBeat.o(140398);
            return true;
        }
    }

    @Override // com.tencent.luggage.d.k
    public final boolean i(String str, Bundle bundle) {
        AppMethodBeat.i(140399);
        h pop = this.ctm.size() == 0 ? null : this.ctm.pop();
        if (pop != null) {
            a(pop);
        }
        boolean a2 = a(str, bundle, false);
        AppMethodBeat.o(140399);
        return a2;
    }

    @Override // com.tencent.luggage.d.k
    public final boolean j(String str, Bundle bundle) {
        AppMethodBeat.i(174615);
        final h k = this.ctp.k(str, bundle);
        if (k == null) {
            Log.e("LuggagePageContainer", "No page specified for url %s", str);
            AppMethodBeat.o(174615);
            return false;
        }
        k.g(str, bundle);
        c(new Runnable() {
            /* class com.tencent.luggage.d.i.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(140379);
                if (((Activity) i.this.mContext).isFinishing()) {
                    AppMethodBeat.o(140379);
                    return;
                }
                h pop = i.this.ctm.size() == 0 ? null : i.this.ctm.pop();
                if (pop != null) {
                    i.a(i.this, pop);
                }
                i.this.ctm.push(k);
                i.this.ctl.addView(k.getContentView());
                k.Li();
                AppMethodBeat.o(140379);
            }
        }, 500);
        AppMethodBeat.o(174615);
        return true;
    }

    private void a(final h hVar) {
        AppMethodBeat.i(140400);
        this.ctl.post(new Runnable() {
            /* class com.tencent.luggage.d.i.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(140380);
                i.this.ctl.removeView(hVar.getContentView());
                AppMethodBeat.o(140380);
            }
        });
        hVar.destroy();
        AppMethodBeat.o(140400);
    }

    public final void Lp() {
        AppMethodBeat.i(140401);
        if (this.ctq != null) {
            AppMethodBeat.o(140401);
            return;
        }
        c(new Runnable() {
            /* class com.tencent.luggage.d.i.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(174610);
                if (!((Activity) i.this.mContext).isFinishing()) {
                    i.this.ctq = r.b(i.this.mContext.getApplicationContext(), i.this.Lr());
                }
                AppMethodBeat.o(174610);
            }
        }, 200);
        AppMethodBeat.o(140401);
    }

    private p Lq() {
        AppMethodBeat.i(140402);
        Integer num = this.ctq;
        this.ctq = null;
        p a2 = r.a(this.mContext, num);
        if (a2 == null || !a2.ctI.equals(Lr())) {
            AppMethodBeat.o(140402);
            return null;
        }
        AppMethodBeat.o(140402);
        return a2;
    }

    private void c(Runnable runnable, long j2) {
        AppMethodBeat.i(140403);
        this.ctl.postDelayed(runnable, j2);
        AppMethodBeat.o(140403);
    }

    /* access modifiers changed from: package-private */
    public final Class<? extends com.tencent.luggage.webview.a> Lr() {
        if (this.ctr == null) {
            this.ctr = this.ctk == null ? com.tencent.luggage.webview.default_impl.a.class : this.ctk;
        }
        return this.ctr;
    }

    public final void a(m mVar) {
        AppMethodBeat.i(140404);
        if (mVar == null) {
            mVar = new m() {
                /* class com.tencent.luggage.d.i.AnonymousClass8 */

                @Override // com.tencent.luggage.d.m
                public final h k(String str, Bundle bundle) {
                    AppMethodBeat.i(174611);
                    s sVar = new s(i.this.cts, bundle);
                    AppMethodBeat.o(174611);
                    return sVar;
                }
            };
        }
        this.ctp = mVar;
        AppMethodBeat.o(140404);
    }

    public void onResume() {
        AppMethodBeat.i(140405);
        h Ln = Ln();
        if (Ln == null) {
            AppMethodBeat.o(140405);
            return;
        }
        Ln.Li();
        AppMethodBeat.o(140405);
    }

    /* access modifiers changed from: protected */
    public void Ls() {
    }

    /* access modifiers changed from: protected */
    public void Lt() {
    }

    /* access modifiers changed from: protected */
    public void Lu() {
    }

    /* access modifiers changed from: protected */
    public void Lv() {
    }

    /* access modifiers changed from: protected */
    public boolean Lw() {
        return true;
    }

    public class a<E> extends LinkedList<E> {
        private a() {
        }

        /* synthetic */ a(i iVar, byte b2) {
            this();
        }

        @Override // java.util.List, java.util.AbstractList, java.util.LinkedList, java.util.AbstractSequentialList
        public final E remove(int i2) {
            AppMethodBeat.i(140385);
            E e2 = (E) super.remove(i2);
            i.this.Lt();
            AppMethodBeat.o(140385);
            return e2;
        }

        @Override // java.util.LinkedList, java.util.Deque
        public final E pop() {
            AppMethodBeat.i(140386);
            E e2 = (E) super.pop();
            i.this.Lt();
            AppMethodBeat.o(140386);
            return e2;
        }

        @Override // java.util.LinkedList, java.util.Deque
        public final void push(E e2) {
            AppMethodBeat.i(140387);
            super.push(e2);
            i.this.Ls();
            AppMethodBeat.o(140387);
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, java.util.Queue, java.util.LinkedList, java.util.Deque
        public final boolean add(E e2) {
            AppMethodBeat.i(140388);
            boolean add = super.add(e2);
            if (add) {
                i.this.Ls();
            }
            AppMethodBeat.o(140388);
            return add;
        }

        @Override // java.util.List, java.util.AbstractList, java.util.LinkedList, java.util.AbstractSequentialList
        public final void add(int i2, E e2) {
            AppMethodBeat.i(140389);
            super.add(i2, e2);
            i.this.Ls();
            AppMethodBeat.o(140389);
        }
    }
}
