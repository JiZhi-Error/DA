package android.support.transition;

import android.support.v4.view.u;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.tencent.mm.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public final class s {
    private static Transition CN = new AutoTransition();
    private static ThreadLocal<WeakReference<android.support.v4.e.a<ViewGroup, ArrayList<Transition>>>> CO = new ThreadLocal<>();
    static ArrayList<ViewGroup> CQ = new ArrayList<>();

    static android.support.v4.e.a<ViewGroup, ArrayList<Transition>> dR() {
        android.support.v4.e.a<ViewGroup, ArrayList<Transition>> aVar;
        WeakReference<android.support.v4.e.a<ViewGroup, ArrayList<Transition>>> weakReference = CO.get();
        if (weakReference != null && (aVar = weakReference.get()) != null) {
            return aVar;
        }
        android.support.v4.e.a<ViewGroup, ArrayList<Transition>> aVar2 = new android.support.v4.e.a<>();
        CO.set(new WeakReference<>(aVar2));
        return aVar2;
    }

    /* access modifiers changed from: package-private */
    public static class a implements View.OnAttachStateChangeListener, ViewTreeObserver.OnPreDrawListener {
        ViewGroup BF;
        Transition CK;

        a(Transition transition, ViewGroup viewGroup) {
            this.CK = transition;
            this.BF = viewGroup;
        }

        private void dS() {
            this.BF.getViewTreeObserver().removeOnPreDrawListener(this);
            this.BF.removeOnAttachStateChangeListener(this);
        }

        public final void onViewAttachedToWindow(View view) {
        }

        public final void onViewDetachedFromWindow(View view) {
            dS();
            s.CQ.remove(this.BF);
            ArrayList<Transition> arrayList = s.dR().get(this.BF);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<Transition> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().L(this.BF);
                }
            }
            this.CK.B(true);
        }

        public final boolean onPreDraw() {
            dS();
            if (s.CQ.remove(this.BF)) {
                final android.support.v4.e.a<ViewGroup, ArrayList<Transition>> dR = s.dR();
                ArrayList<Transition> arrayList = dR.get(this.BF);
                ArrayList arrayList2 = null;
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    dR.put(this.BF, arrayList);
                } else if (arrayList.size() > 0) {
                    arrayList2 = new ArrayList(arrayList);
                }
                arrayList.add(this.CK);
                this.CK.a(new r() {
                    /* class android.support.transition.s.a.AnonymousClass1 */

                    @Override // android.support.transition.r, android.support.transition.Transition.d
                    public final void a(Transition transition) {
                        ((ArrayList) dR.get(a.this.BF)).remove(transition);
                    }
                });
                this.CK.b(this.BF, false);
                if (arrayList2 != null) {
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        ((Transition) it.next()).L(this.BF);
                    }
                }
                this.CK.a(this.BF);
            }
            return true;
        }
    }

    public static void a(ViewGroup viewGroup, Transition transition) {
        if (!CQ.contains(viewGroup) && u.az(viewGroup)) {
            CQ.add(viewGroup);
            if (transition == null) {
                transition = CN;
            }
            Transition dP = transition.clone();
            ArrayList<Transition> arrayList = dR().get(viewGroup);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<Transition> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().K(viewGroup);
                }
            }
            if (dP != null) {
                dP.b(viewGroup, true);
            }
            n G = n.G(viewGroup);
            if (!(G == null || n.G(G.BF) != G || G.BG == null)) {
                G.BG.run();
            }
            viewGroup.setTag(R.id.iv1, null);
            if (dP != null && viewGroup != null) {
                a aVar = new a(dP, viewGroup);
                viewGroup.addOnAttachStateChangeListener(aVar);
                viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
            }
        }
    }
}
