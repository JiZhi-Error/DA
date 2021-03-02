package android.support.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.transition.Transition;
import android.support.v4.content.a.g;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

public class TransitionSet extends Transition {
    ArrayList<Transition> CT = new ArrayList<>();
    private boolean CU = true;
    int CV;
    private int CW = 0;
    boolean mStarted = false;

    public TransitionSet() {
    }

    public TransitionSet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.BY);
        ao(g.a(obtainStyledAttributes, (XmlPullParser) ((XmlResourceParser) attributeSet), "transitionOrdering", 0, 0));
        obtainStyledAttributes.recycle();
    }

    public final TransitionSet ao(int i2) {
        switch (i2) {
            case 0:
                this.CU = true;
                break;
            case 1:
                this.CU = false;
                break;
            default:
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: ".concat(String.valueOf(i2)));
        }
        return this;
    }

    public final TransitionSet c(Transition transition) {
        this.CT.add(transition);
        transition.Cs = this;
        if (this.mDuration >= 0) {
            transition.f(this.mDuration);
        }
        if ((this.CW & 1) != 0) {
            transition.b(this.Ce);
        }
        if ((this.CW & 2) != 0) {
            transition.a(this.CC);
        }
        if ((this.CW & 4) != 0) {
            transition.a(this.CF);
        }
        if ((this.CW & 8) != 0) {
            transition.a(this.CD);
        }
        return this;
    }

    public final Transition ap(int i2) {
        if (i2 < 0 || i2 >= this.CT.size()) {
            return null;
        }
        return this.CT.get(i2);
    }

    /* renamed from: h */
    public final TransitionSet f(long j2) {
        super.f(j2);
        if (this.mDuration >= 0) {
            int size = this.CT.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.CT.get(i2).f(j2);
            }
        }
        return this;
    }

    /* renamed from: c */
    public final TransitionSet b(TimeInterpolator timeInterpolator) {
        this.CW |= 1;
        if (this.CT != null) {
            int size = this.CT.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.CT.get(i2).b(timeInterpolator);
            }
        }
        return (TransitionSet) super.b(timeInterpolator);
    }

    /* renamed from: c */
    public final TransitionSet a(Transition.d dVar) {
        return (TransitionSet) super.a(dVar);
    }

    @Override // android.support.transition.Transition
    public final Transition b(String str, boolean z) {
        for (int i2 = 0; i2 < this.CT.size(); i2++) {
            this.CT.get(i2).b(str, z);
        }
        return super.b(str, z);
    }

    @Override // android.support.transition.Transition
    public final Transition f(int i2, boolean z) {
        for (int i3 = 0; i3 < this.CT.size(); i3++) {
            this.CT.get(i3).f(i2, z);
        }
        return super.f(i2, z);
    }

    @Override // android.support.transition.Transition
    public final Transition a(Class cls, boolean z) {
        for (int i2 = 0; i2 < this.CT.size(); i2++) {
            this.CT.get(i2).a(cls, z);
        }
        return super.a(cls, z);
    }

    @Override // android.support.transition.Transition
    public final void a(PathMotion pathMotion) {
        super.a(pathMotion);
        this.CW |= 4;
        for (int i2 = 0; i2 < this.CT.size(); i2++) {
            this.CT.get(i2).a(pathMotion);
        }
    }

    static class a extends r {
        TransitionSet CZ;

        a(TransitionSet transitionSet) {
            this.CZ = transitionSet;
        }

        @Override // android.support.transition.r, android.support.transition.Transition.d
        public final void dK() {
            if (!this.CZ.mStarted) {
                this.CZ.start();
                this.CZ.mStarted = true;
            }
        }

        @Override // android.support.transition.r, android.support.transition.Transition.d
        public final void a(Transition transition) {
            TransitionSet transitionSet = this.CZ;
            transitionSet.CV--;
            if (this.CZ.CV == 0) {
                this.CZ.mStarted = false;
                this.CZ.end();
            }
            transition.b(this);
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.support.transition.Transition
    public final void dO() {
        if (this.CT.isEmpty()) {
            start();
            end();
            return;
        }
        a aVar = new a(this);
        Iterator<Transition> it = this.CT.iterator();
        while (it.hasNext()) {
            it.next().a(aVar);
        }
        this.CV = this.CT.size();
        if (!this.CU) {
            for (int i2 = 1; i2 < this.CT.size(); i2++) {
                final Transition transition = this.CT.get(i2);
                this.CT.get(i2 - 1).a(new r() {
                    /* class android.support.transition.TransitionSet.AnonymousClass1 */

                    @Override // android.support.transition.r, android.support.transition.Transition.d
                    public final void a(Transition transition) {
                        transition.dO();
                        transition.b(this);
                    }
                });
            }
            Transition transition2 = this.CT.get(0);
            if (transition2 != null) {
                transition2.dO();
                return;
            }
            return;
        }
        Iterator<Transition> it2 = this.CT.iterator();
        while (it2.hasNext()) {
            it2.next().dO();
        }
    }

    @Override // android.support.transition.Transition
    public final void a(v vVar) {
        if (H(vVar.view)) {
            Iterator<Transition> it = this.CT.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.H(vVar.view)) {
                    next.a(vVar);
                    vVar.Df.add(next);
                }
            }
        }
    }

    @Override // android.support.transition.Transition
    public final void b(v vVar) {
        if (H(vVar.view)) {
            Iterator<Transition> it = this.CT.iterator();
            while (it.hasNext()) {
                Transition next = it.next();
                if (next.H(vVar.view)) {
                    next.b(vVar);
                    vVar.Df.add(next);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    @Override // android.support.transition.Transition
    public final void d(v vVar) {
        super.d(vVar);
        int size = this.CT.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.CT.get(i2).d(vVar);
        }
    }

    @Override // android.support.transition.Transition
    public final void K(View view) {
        super.K(view);
        int size = this.CT.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.CT.get(i2).K(view);
        }
    }

    @Override // android.support.transition.Transition
    public final void L(View view) {
        super.L(view);
        int size = this.CT.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.CT.get(i2).L(view);
        }
    }

    @Override // android.support.transition.Transition
    public final void a(t tVar) {
        super.a(tVar);
        this.CW |= 2;
        int size = this.CT.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.CT.get(i2).a(tVar);
        }
    }

    @Override // android.support.transition.Transition
    public final void a(Transition.c cVar) {
        super.a(cVar);
        this.CW |= 8;
        int size = this.CT.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.CT.get(i2).a(cVar);
        }
    }

    /* access modifiers changed from: package-private */
    @Override // android.support.transition.Transition
    public final String toString(String str) {
        String transition = super.toString(str);
        for (int i2 = 0; i2 < this.CT.size(); i2++) {
            transition = transition + "\n" + this.CT.get(i2).toString(str + "  ");
        }
        return transition;
    }

    @Override // android.support.transition.Transition
    /* renamed from: dP */
    public final Transition clone() {
        TransitionSet transitionSet = (TransitionSet) super.clone();
        transitionSet.CT = new ArrayList<>();
        int size = this.CT.size();
        for (int i2 = 0; i2 < size; i2++) {
            transitionSet.c(this.CT.get(i2).clone());
        }
        return transitionSet;
    }

    /* access modifiers changed from: protected */
    @Override // android.support.transition.Transition
    public final void a(ViewGroup viewGroup, w wVar, w wVar2, ArrayList<v> arrayList, ArrayList<v> arrayList2) {
        long j2 = this.Cd;
        int size = this.CT.size();
        for (int i2 = 0; i2 < size; i2++) {
            Transition transition = this.CT.get(i2);
            if (j2 > 0 && (this.CU || i2 == 0)) {
                long j3 = transition.Cd;
                if (j3 > 0) {
                    transition.g(j3 + j2);
                } else {
                    transition.g(j2);
                }
            }
            transition.a(viewGroup, wVar, wVar2, arrayList, arrayList2);
        }
    }

    @Override // android.support.transition.Transition
    public final /* bridge */ /* synthetic */ Transition b(Transition.d dVar) {
        return (TransitionSet) super.b(dVar);
    }

    @Override // android.support.transition.Transition
    public final /* synthetic */ Transition J(View view) {
        for (int i2 = 0; i2 < this.CT.size(); i2++) {
            this.CT.get(i2).J(view);
        }
        return (TransitionSet) super.J(view);
    }

    @Override // android.support.transition.Transition
    public final /* synthetic */ Transition h(Class cls) {
        for (int i2 = 0; i2 < this.CT.size(); i2++) {
            this.CT.get(i2).h(cls);
        }
        return (TransitionSet) super.h(cls);
    }

    @Override // android.support.transition.Transition
    public final /* synthetic */ Transition q(String str) {
        for (int i2 = 0; i2 < this.CT.size(); i2++) {
            this.CT.get(i2).q(str);
        }
        return (TransitionSet) super.q(str);
    }

    @Override // android.support.transition.Transition
    public final /* synthetic */ Transition an(int i2) {
        for (int i3 = 0; i3 < this.CT.size(); i3++) {
            this.CT.get(i3).an(i2);
        }
        return (TransitionSet) super.an(i2);
    }

    @Override // android.support.transition.Transition
    public final /* synthetic */ Transition I(View view) {
        for (int i2 = 0; i2 < this.CT.size(); i2++) {
            this.CT.get(i2).I(view);
        }
        return (TransitionSet) super.I(view);
    }

    @Override // android.support.transition.Transition
    public final /* bridge */ /* synthetic */ Transition g(long j2) {
        return (TransitionSet) super.g(j2);
    }
}
