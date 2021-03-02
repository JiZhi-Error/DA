package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Build;
import android.support.transition.a;
import android.support.v4.content.a.g;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import org.xmlpull.v1.XmlPullParser;

public abstract class Transition implements Cloneable {
    private static final int[] Cb = {2, 1, 3, 4};
    private static final PathMotion Cc = new PathMotion() {
        /* class android.support.transition.Transition.AnonymousClass1 */

        @Override // android.support.transition.PathMotion
        public final Path getPath(float f2, float f3, float f4, float f5) {
            Path path = new Path();
            path.moveTo(f2, f3);
            path.lineTo(f4, f5);
            return path;
        }
    };
    private static ThreadLocal<android.support.v4.e.a<Animator, a>> Cw = new ThreadLocal<>();
    private ViewGroup BF = null;
    private boolean CA = false;
    private boolean CB = false;
    t CC;
    c CD;
    private android.support.v4.e.a<String, String> CE;
    PathMotion CF = Cc;
    long Cd = -1;
    TimeInterpolator Ce = null;
    ArrayList<Integer> Cf = new ArrayList<>();
    ArrayList<View> Cg = new ArrayList<>();
    ArrayList<String> Ch = null;
    ArrayList<Class> Ci = null;
    private ArrayList<Integer> Cj = null;
    private ArrayList<View> Ck = null;
    private ArrayList<Class> Cl = null;
    private ArrayList<String> Cm = null;
    private ArrayList<Integer> Cn = null;
    private ArrayList<View> Co = null;
    private ArrayList<Class> Cp = null;
    private w Cq = new w();
    private w Cr = new w();
    TransitionSet Cs = null;
    private int[] Ct = Cb;
    private ArrayList<v> Cu;
    private ArrayList<v> Cv;
    boolean Cx = false;
    ArrayList<Animator> Cy = new ArrayList<>();
    private int Cz = 0;
    long mDuration = -1;
    private ArrayList<d> mListeners = null;
    private String mName = getClass().getName();
    private ArrayList<Animator> xd = new ArrayList<>();

    public static abstract class c {
        public abstract Rect dJ();
    }

    public interface d {
        void a(Transition transition);

        void dF();

        void dG();

        void dK();
    }

    public abstract void a(v vVar);

    public abstract void b(v vVar);

    public Transition() {
    }

    public Transition(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.BS);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long a2 = (long) g.a(obtainStyledAttributes, (XmlPullParser) xmlResourceParser, FFmpegMetadataRetriever.METADATA_KEY_DURATION, 1, -1);
        if (a2 >= 0) {
            f(a2);
        }
        long a3 = (long) g.a(obtainStyledAttributes, (XmlPullParser) xmlResourceParser, "startDelay", 2, -1);
        if (a3 > 0) {
            g(a3);
        }
        int b2 = g.b(obtainStyledAttributes, xmlResourceParser, "interpolator", 0);
        if (b2 > 0) {
            b(AnimationUtils.loadInterpolator(context, b2));
        }
        String c2 = g.c(obtainStyledAttributes, xmlResourceParser, "matchOrder", 3);
        if (c2 != null) {
            setMatchOrder(p(c2));
        }
        obtainStyledAttributes.recycle();
    }

    private static int[] p(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        int[] iArr = new int[stringTokenizer.countTokens()];
        int i2 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String trim = stringTokenizer.nextToken().trim();
            if ("id".equalsIgnoreCase(trim)) {
                iArr[i2] = 3;
            } else if ("instance".equalsIgnoreCase(trim)) {
                iArr[i2] = 1;
            } else if ("name".equalsIgnoreCase(trim)) {
                iArr[i2] = 2;
            } else if ("itemId".equalsIgnoreCase(trim)) {
                iArr[i2] = 4;
            } else if (trim.isEmpty()) {
                int[] iArr2 = new int[(iArr.length - 1)];
                System.arraycopy(iArr, 0, iArr2, 0, i2);
                i2--;
                iArr = iArr2;
            } else {
                throw new InflateException("Unknown match type in matchOrder: '" + trim + "'");
            }
            i2++;
        }
        return iArr;
    }

    public Transition f(long j2) {
        this.mDuration = j2;
        return this;
    }

    public Transition g(long j2) {
        this.Cd = j2;
        return this;
    }

    public Transition b(TimeInterpolator timeInterpolator) {
        this.Ce = timeInterpolator;
        return this;
    }

    public String[] getTransitionProperties() {
        return null;
    }

    public Animator a(ViewGroup viewGroup, v vVar, v vVar2) {
        return null;
    }

    private void setMatchOrder(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            this.Ct = Cb;
            return;
        }
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int i3 = iArr[i2];
            if (!(i3 > 0 && i3 <= 4)) {
                throw new IllegalArgumentException("matches contains invalid value");
            } else if (b(iArr, i2)) {
                throw new IllegalArgumentException("matches contains a duplicate value");
            }
        }
        this.Ct = (int[]) iArr.clone();
    }

    private static boolean b(int[] iArr, int i2) {
        int i3 = iArr[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            if (iArr[i4] == i3) {
                return true;
            }
        }
        return false;
    }

    private void a(w wVar, w wVar2) {
        View view;
        View view2;
        View view3;
        v vVar;
        android.support.v4.e.a aVar = new android.support.v4.e.a(wVar.Dg);
        android.support.v4.e.a aVar2 = new android.support.v4.e.a(wVar2.Dg);
        for (int i2 = 0; i2 < this.Ct.length; i2++) {
            switch (this.Ct[i2]) {
                case 1:
                    for (int size = aVar.size() - 1; size >= 0; size--) {
                        View view4 = (View) aVar.keyAt(size);
                        if (!(view4 == null || !H(view4) || (vVar = (v) aVar2.remove(view4)) == null || vVar.view == null || !H(vVar.view))) {
                            this.Cu.add((v) aVar.removeAt(size));
                            this.Cv.add(vVar);
                        }
                    }
                    break;
                case 2:
                    android.support.v4.e.a<String, View> aVar3 = wVar.Dj;
                    android.support.v4.e.a<String, View> aVar4 = wVar2.Dj;
                    int size2 = aVar3.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        View valueAt = aVar3.valueAt(i3);
                        if (valueAt != null && H(valueAt) && (view3 = aVar4.get(aVar3.keyAt(i3))) != null && H(view3)) {
                            v vVar2 = (v) aVar.get(valueAt);
                            v vVar3 = (v) aVar2.get(view3);
                            if (!(vVar2 == null || vVar3 == null)) {
                                this.Cu.add(vVar2);
                                this.Cv.add(vVar3);
                                aVar.remove(valueAt);
                                aVar2.remove(view3);
                            }
                        }
                    }
                    break;
                case 3:
                    SparseArray<View> sparseArray = wVar.Dh;
                    SparseArray<View> sparseArray2 = wVar2.Dh;
                    int size3 = sparseArray.size();
                    for (int i4 = 0; i4 < size3; i4++) {
                        View valueAt2 = sparseArray.valueAt(i4);
                        if (valueAt2 != null && H(valueAt2) && (view2 = sparseArray2.get(sparseArray.keyAt(i4))) != null && H(view2)) {
                            v vVar4 = (v) aVar.get(valueAt2);
                            v vVar5 = (v) aVar2.get(view2);
                            if (!(vVar4 == null || vVar5 == null)) {
                                this.Cu.add(vVar4);
                                this.Cv.add(vVar5);
                                aVar.remove(valueAt2);
                                aVar2.remove(view2);
                            }
                        }
                    }
                    break;
                case 4:
                    android.support.v4.e.g<View> gVar = wVar.Di;
                    android.support.v4.e.g<View> gVar2 = wVar2.Di;
                    int size4 = gVar.size();
                    for (int i5 = 0; i5 < size4; i5++) {
                        View valueAt3 = gVar.valueAt(i5);
                        if (valueAt3 != null && H(valueAt3) && (view = gVar2.get(gVar.keyAt(i5), null)) != null && H(view)) {
                            v vVar6 = (v) aVar.get(valueAt3);
                            v vVar7 = (v) aVar2.get(view);
                            if (!(vVar6 == null || vVar7 == null)) {
                                this.Cu.add(vVar6);
                                this.Cv.add(vVar7);
                                aVar.remove(valueAt3);
                                aVar2.remove(view);
                            }
                        }
                    }
                    break;
            }
        }
        for (int i6 = 0; i6 < aVar.size(); i6++) {
            v vVar8 = (v) aVar.valueAt(i6);
            if (H(vVar8.view)) {
                this.Cu.add(vVar8);
                this.Cv.add(null);
            }
        }
        for (int i7 = 0; i7 < aVar2.size(); i7++) {
            v vVar9 = (v) aVar2.valueAt(i7);
            if (H(vVar9.view)) {
                this.Cv.add(vVar9);
                this.Cu.add(null);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(ViewGroup viewGroup, w wVar, w wVar2, ArrayList<v> arrayList, ArrayList<v> arrayList2) {
        Animator a2;
        View view;
        Animator animator;
        v vVar;
        android.support.v4.e.a<Animator, a> dN = dN();
        long j2 = MAlarmHandler.NEXT_FIRE_INTERVAL;
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            v vVar2 = arrayList.get(i2);
            v vVar3 = arrayList2.get(i2);
            v vVar4 = (vVar2 == null || vVar2.Df.contains(this)) ? vVar2 : null;
            v vVar5 = (vVar3 == null || vVar3.Df.contains(this)) ? vVar3 : null;
            if (vVar4 != null || vVar5 != null) {
                if ((vVar4 == null || vVar5 == null || a(vVar4, vVar5)) && (a2 = a(viewGroup, vVar4, vVar5)) != null) {
                    v vVar6 = null;
                    if (vVar5 != null) {
                        View view2 = vVar5.view;
                        String[] transitionProperties = getTransitionProperties();
                        if (!(view2 == null || transitionProperties == null || transitionProperties.length <= 0)) {
                            v vVar7 = new v();
                            vVar7.view = view2;
                            v vVar8 = wVar2.Dg.get(view2);
                            if (vVar8 != null) {
                                for (int i3 = 0; i3 < transitionProperties.length; i3++) {
                                    vVar7.values.put(transitionProperties[i3], vVar8.values.get(transitionProperties[i3]));
                                }
                            }
                            int size2 = dN.size();
                            for (int i4 = 0; i4 < size2; i4++) {
                                a aVar = dN.get(dN.keyAt(i4));
                                if (aVar.CI != null && aVar.mView == view2 && aVar.mName.equals(this.mName) && aVar.CI.equals(vVar7)) {
                                    animator = null;
                                    vVar = vVar7;
                                    view = view2;
                                    break;
                                }
                            }
                            vVar6 = vVar7;
                        }
                        animator = a2;
                        vVar = vVar6;
                        view = view2;
                    } else {
                        view = vVar4.view;
                        animator = a2;
                        vVar = null;
                    }
                    if (animator != null) {
                        if (this.CC != null) {
                            long a3 = this.CC.a(viewGroup, this, vVar4, vVar5);
                            sparseIntArray.put(this.xd.size(), (int) a3);
                            j2 = Math.min(a3, j2);
                        }
                        dN.put(animator, new a(view, this.mName, this, ah.O(viewGroup), vVar));
                        this.xd.add(animator);
                    }
                }
            }
        }
        if (j2 != 0) {
            for (int i5 = 0; i5 < sparseIntArray.size(); i5++) {
                Animator animator2 = this.xd.get(sparseIntArray.keyAt(i5));
                animator2.setStartDelay((((long) sparseIntArray.valueAt(i5)) - j2) + animator2.getStartDelay());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean H(View view) {
        int id = view.getId();
        if (this.Cj != null && this.Cj.contains(Integer.valueOf(id))) {
            return false;
        }
        if (this.Ck != null && this.Ck.contains(view)) {
            return false;
        }
        if (this.Cl != null) {
            int size = this.Cl.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.Cl.get(i2).isInstance(view)) {
                    return false;
                }
            }
        }
        if (!(this.Cm == null || u.an(view) == null || !this.Cm.contains(u.an(view)))) {
            return false;
        }
        if (this.Cf.size() == 0 && this.Cg.size() == 0 && ((this.Ci == null || this.Ci.isEmpty()) && (this.Ch == null || this.Ch.isEmpty()))) {
            return true;
        }
        if (this.Cf.contains(Integer.valueOf(id)) || this.Cg.contains(view)) {
            return true;
        }
        if (this.Ch != null && this.Ch.contains(u.an(view))) {
            return true;
        }
        if (this.Ci == null) {
            return false;
        }
        for (int i3 = 0; i3 < this.Ci.size(); i3++) {
            if (this.Ci.get(i3).isInstance(view)) {
                return true;
            }
        }
        return false;
    }

    private static android.support.v4.e.a<Animator, a> dN() {
        android.support.v4.e.a<Animator, a> aVar = Cw.get();
        if (aVar != null) {
            return aVar;
        }
        android.support.v4.e.a<Animator, a> aVar2 = new android.support.v4.e.a<>();
        Cw.set(aVar2);
        return aVar2;
    }

    /* access modifiers changed from: protected */
    public void dO() {
        start();
        final android.support.v4.e.a<Animator, a> dN = dN();
        Iterator<Animator> it = this.xd.iterator();
        while (it.hasNext()) {
            Animator next = it.next();
            if (dN.containsKey(next)) {
                start();
                if (next != null) {
                    next.addListener(new AnimatorListenerAdapter() {
                        /* class android.support.transition.Transition.AnonymousClass2 */

                        public final void onAnimationStart(Animator animator) {
                            Transition.this.Cy.add(animator);
                        }

                        public final void onAnimationEnd(Animator animator) {
                            dN.remove(animator);
                            Transition.this.Cy.remove(animator);
                        }
                    });
                    if (next == null) {
                        end();
                    } else {
                        if (this.mDuration >= 0) {
                            next.setDuration(this.mDuration);
                        }
                        if (this.Cd >= 0) {
                            next.setStartDelay(this.Cd);
                        }
                        if (this.Ce != null) {
                            next.setInterpolator(this.Ce);
                        }
                        next.addListener(new AnimatorListenerAdapter() {
                            /* class android.support.transition.Transition.AnonymousClass3 */

                            public final void onAnimationEnd(Animator animator) {
                                Transition.this.end();
                                animator.removeListener(this);
                            }
                        });
                        next.start();
                    }
                }
            }
        }
        this.xd.clear();
        end();
    }

    public Transition I(View view) {
        this.Cg.add(view);
        return this;
    }

    public Transition an(int i2) {
        if (i2 != 0) {
            this.Cf.add(Integer.valueOf(i2));
        }
        return this;
    }

    public Transition q(String str) {
        if (this.Ch == null) {
            this.Ch = new ArrayList<>();
        }
        this.Ch.add(str);
        return this;
    }

    public Transition h(Class cls) {
        if (this.Ci == null) {
            this.Ci = new ArrayList<>();
        }
        this.Ci.add(cls);
        return this;
    }

    public Transition J(View view) {
        this.Cg.remove(view);
        return this;
    }

    public Transition f(int i2, boolean z) {
        ArrayList<Integer> arrayList = this.Cj;
        if (i2 > 0) {
            arrayList = z ? b.a(arrayList, Integer.valueOf(i2)) : b.b(arrayList, Integer.valueOf(i2));
        }
        this.Cj = arrayList;
        return this;
    }

    public Transition b(String str, boolean z) {
        ArrayList<String> arrayList = this.Cm;
        if (str != null) {
            if (z) {
                arrayList = b.a(arrayList, str);
            } else {
                arrayList = b.b(arrayList, str);
            }
        }
        this.Cm = arrayList;
        return this;
    }

    public Transition a(Class cls, boolean z) {
        ArrayList<Class> arrayList = this.Cl;
        if (cls != null) {
            if (z) {
                arrayList = b.a(arrayList, cls);
            } else {
                arrayList = b.b(arrayList, cls);
            }
        }
        this.Cl = arrayList;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final void b(ViewGroup viewGroup, boolean z) {
        B(z);
        if ((this.Cf.size() > 0 || this.Cg.size() > 0) && ((this.Ch == null || this.Ch.isEmpty()) && (this.Ci == null || this.Ci.isEmpty()))) {
            for (int i2 = 0; i2 < this.Cf.size(); i2++) {
                View findViewById = viewGroup.findViewById(this.Cf.get(i2).intValue());
                if (findViewById != null) {
                    v vVar = new v();
                    vVar.view = findViewById;
                    if (z) {
                        a(vVar);
                    } else {
                        b(vVar);
                    }
                    vVar.Df.add(this);
                    d(vVar);
                    if (z) {
                        a(this.Cq, findViewById, vVar);
                    } else {
                        a(this.Cr, findViewById, vVar);
                    }
                }
            }
            for (int i3 = 0; i3 < this.Cg.size(); i3++) {
                View view = this.Cg.get(i3);
                v vVar2 = new v();
                vVar2.view = view;
                if (z) {
                    a(vVar2);
                } else {
                    b(vVar2);
                }
                vVar2.Df.add(this);
                d(vVar2);
                if (z) {
                    a(this.Cq, view, vVar2);
                } else {
                    a(this.Cr, view, vVar2);
                }
            }
        } else {
            a(viewGroup, z);
        }
        if (!(z || this.CE == null)) {
            int size = this.CE.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i4 = 0; i4 < size; i4++) {
                arrayList.add(this.Cq.Dj.remove(this.CE.keyAt(i4)));
            }
            for (int i5 = 0; i5 < size; i5++) {
                View view2 = (View) arrayList.get(i5);
                if (view2 != null) {
                    this.Cq.Dj.put(this.CE.valueAt(i5), view2);
                }
            }
        }
    }

    private static void a(w wVar, View view, v vVar) {
        wVar.Dg.put(view, vVar);
        int id = view.getId();
        if (id >= 0) {
            if (wVar.Dh.indexOfKey(id) >= 0) {
                wVar.Dh.put(id, null);
            } else {
                wVar.Dh.put(id, view);
            }
        }
        String an = u.an(view);
        if (an != null) {
            if (wVar.Dj.containsKey(an)) {
                wVar.Dj.put(an, null);
            } else {
                wVar.Dj.put(an, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (wVar.Di.indexOfKey(itemIdAtPosition) >= 0) {
                    View view2 = wVar.Di.get(itemIdAtPosition, null);
                    if (view2 != null) {
                        u.d(view2, false);
                        wVar.Di.put(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                u.d(view, true);
                wVar.Di.put(itemIdAtPosition, view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void B(boolean z) {
        if (z) {
            this.Cq.Dg.clear();
            this.Cq.Dh.clear();
            this.Cq.Di.clear();
            return;
        }
        this.Cr.Dg.clear();
        this.Cr.Dh.clear();
        this.Cr.Di.clear();
    }

    private void a(View view, boolean z) {
        if (view != null) {
            int id = view.getId();
            if (this.Cj != null && this.Cj.contains(Integer.valueOf(id))) {
                return;
            }
            if (this.Ck == null || !this.Ck.contains(view)) {
                if (this.Cl != null) {
                    int size = this.Cl.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        if (this.Cl.get(i2).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    v vVar = new v();
                    vVar.view = view;
                    if (z) {
                        a(vVar);
                    } else {
                        b(vVar);
                    }
                    vVar.Df.add(this);
                    d(vVar);
                    if (z) {
                        a(this.Cq, view, vVar);
                    } else {
                        a(this.Cr, view, vVar);
                    }
                }
                if (!(view instanceof ViewGroup)) {
                    return;
                }
                if (this.Cn != null && this.Cn.contains(Integer.valueOf(id))) {
                    return;
                }
                if (this.Co == null || !this.Co.contains(view)) {
                    if (this.Cp != null) {
                        int size2 = this.Cp.size();
                        for (int i3 = 0; i3 < size2; i3++) {
                            if (this.Cp.get(i3).isInstance(view)) {
                                return;
                            }
                        }
                    }
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                        a(viewGroup.getChildAt(i4), z);
                    }
                }
            }
        }
    }

    public final v b(View view, boolean z) {
        while (this.Cs != null) {
            this = this.Cs;
        }
        return (z ? this.Cq : this.Cr).Dg.get(view);
    }

    /* access modifiers changed from: package-private */
    public final v c(View view, boolean z) {
        v vVar;
        while (this.Cs != null) {
            this = this.Cs;
        }
        ArrayList<v> arrayList = z ? this.Cu : this.Cv;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            }
            v vVar2 = arrayList.get(i2);
            if (vVar2 == null) {
                return null;
            }
            if (vVar2.view == view) {
                break;
            }
            i2++;
        }
        if (i2 >= 0) {
            vVar = (z ? this.Cv : this.Cu).get(i2);
        } else {
            vVar = null;
        }
        return vVar;
    }

    public void K(View view) {
        if (!this.CB) {
            android.support.v4.e.a<Animator, a> dN = dN();
            int size = dN.size();
            ap O = ah.O(view);
            for (int i2 = size - 1; i2 >= 0; i2--) {
                a valueAt = dN.valueAt(i2);
                if (valueAt.mView != null && O.equals(valueAt.CJ)) {
                    Animator keyAt = dN.keyAt(i2);
                    if (Build.VERSION.SDK_INT >= 19) {
                        keyAt.pause();
                    } else {
                        ArrayList<Animator.AnimatorListener> listeners = keyAt.getListeners();
                        if (listeners != null) {
                            int size2 = listeners.size();
                            for (int i3 = 0; i3 < size2; i3++) {
                                Animator.AnimatorListener animatorListener = listeners.get(i3);
                                if (animatorListener instanceof a.AbstractC0014a) {
                                    ((a.AbstractC0014a) animatorListener).onAnimationPause(keyAt);
                                }
                            }
                        }
                    }
                }
            }
            if (this.mListeners != null && this.mListeners.size() > 0) {
                ArrayList arrayList = (ArrayList) this.mListeners.clone();
                int size3 = arrayList.size();
                for (int i4 = 0; i4 < size3; i4++) {
                    ((d) arrayList.get(i4)).dF();
                }
            }
            this.CA = true;
        }
    }

    public void L(View view) {
        if (this.CA) {
            if (!this.CB) {
                android.support.v4.e.a<Animator, a> dN = dN();
                int size = dN.size();
                ap O = ah.O(view);
                for (int i2 = size - 1; i2 >= 0; i2--) {
                    a valueAt = dN.valueAt(i2);
                    if (valueAt.mView != null && O.equals(valueAt.CJ)) {
                        Animator keyAt = dN.keyAt(i2);
                        if (Build.VERSION.SDK_INT >= 19) {
                            keyAt.resume();
                        } else {
                            ArrayList<Animator.AnimatorListener> listeners = keyAt.getListeners();
                            if (listeners != null) {
                                int size2 = listeners.size();
                                for (int i3 = 0; i3 < size2; i3++) {
                                    Animator.AnimatorListener animatorListener = listeners.get(i3);
                                    if (animatorListener instanceof a.AbstractC0014a) {
                                        ((a.AbstractC0014a) animatorListener).onAnimationResume(keyAt);
                                    }
                                }
                            }
                        }
                    }
                }
                if (this.mListeners != null && this.mListeners.size() > 0) {
                    ArrayList arrayList = (ArrayList) this.mListeners.clone();
                    int size3 = arrayList.size();
                    for (int i4 = 0; i4 < size3; i4++) {
                        ((d) arrayList.get(i4)).dG();
                    }
                }
            }
            this.CA = false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(ViewGroup viewGroup) {
        a aVar;
        this.Cu = new ArrayList<>();
        this.Cv = new ArrayList<>();
        a(this.Cq, this.Cr);
        android.support.v4.e.a<Animator, a> dN = dN();
        int size = dN.size();
        ap O = ah.O(viewGroup);
        for (int i2 = size - 1; i2 >= 0; i2--) {
            Animator keyAt = dN.keyAt(i2);
            if (!(keyAt == null || (aVar = dN.get(keyAt)) == null || aVar.mView == null || !O.equals(aVar.CJ))) {
                v vVar = aVar.CI;
                View view = aVar.mView;
                v b2 = b(view, true);
                v c2 = c(view, true);
                if (!(b2 == null && c2 == null) && aVar.CK.a(vVar, c2)) {
                    if (keyAt.isRunning() || keyAt.isStarted()) {
                        keyAt.cancel();
                    } else {
                        dN.remove(keyAt);
                    }
                }
            }
        }
        a(viewGroup, this.Cq, this.Cr, this.Cu, this.Cv);
        dO();
    }

    public boolean a(v vVar, v vVar2) {
        if (!(vVar == null || vVar2 == null)) {
            String[] transitionProperties = getTransitionProperties();
            if (transitionProperties != null) {
                for (String str : transitionProperties) {
                    if (a(vVar, vVar2, str)) {
                        return true;
                    }
                }
                return false;
            }
            for (String str2 : vVar.values.keySet()) {
                if (a(vVar, vVar2, str2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean a(v vVar, v vVar2, String str) {
        Object obj = vVar.values.get(str);
        Object obj2 = vVar2.values.get(str);
        if ((obj != null || obj2 != null) && (obj == null || obj2 == null || !obj.equals(obj2))) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final void start() {
        if (this.Cz == 0) {
            if (this.mListeners != null && this.mListeners.size() > 0) {
                ArrayList arrayList = (ArrayList) this.mListeners.clone();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((d) arrayList.get(i2)).dK();
                }
            }
            this.CB = false;
        }
        this.Cz++;
    }

    /* access modifiers changed from: protected */
    public final void end() {
        this.Cz--;
        if (this.Cz == 0) {
            if (this.mListeners != null && this.mListeners.size() > 0) {
                ArrayList arrayList = (ArrayList) this.mListeners.clone();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((d) arrayList.get(i2)).a(this);
                }
            }
            for (int i3 = 0; i3 < this.Cq.Di.size(); i3++) {
                View valueAt = this.Cq.Di.valueAt(i3);
                if (valueAt != null) {
                    u.d(valueAt, false);
                }
            }
            for (int i4 = 0; i4 < this.Cr.Di.size(); i4++) {
                View valueAt2 = this.Cr.Di.valueAt(i4);
                if (valueAt2 != null) {
                    u.d(valueAt2, false);
                }
            }
            this.CB = true;
        }
    }

    public Transition a(d dVar) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        }
        this.mListeners.add(dVar);
        return this;
    }

    public Transition b(d dVar) {
        if (this.mListeners != null) {
            this.mListeners.remove(dVar);
            if (this.mListeners.size() == 0) {
                this.mListeners = null;
            }
        }
        return this;
    }

    public void a(PathMotion pathMotion) {
        if (pathMotion == null) {
            this.CF = Cc;
        } else {
            this.CF = pathMotion;
        }
    }

    public void a(c cVar) {
        this.CD = cVar;
    }

    public final Rect getEpicenter() {
        if (this.CD == null) {
            return null;
        }
        return this.CD.dJ();
    }

    public void a(t tVar) {
        this.CC = tVar;
    }

    /* access modifiers changed from: package-private */
    public void d(v vVar) {
        String[] propagationProperties;
        boolean z = false;
        if (this.CC != null && !vVar.values.isEmpty() && (propagationProperties = this.CC.getPropagationProperties()) != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= propagationProperties.length) {
                    z = true;
                    break;
                } else if (!vVar.values.containsKey(propagationProperties[i2])) {
                    break;
                } else {
                    i2++;
                }
            }
            if (!z) {
                this.CC.c(vVar);
            }
        }
    }

    public String toString() {
        return toString("");
    }

    /* renamed from: dP */
    public Transition clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.xd = new ArrayList<>();
            transition.Cq = new w();
            transition.Cr = new w();
            transition.Cu = null;
            transition.Cv = null;
            return transition;
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public String toString(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.mDuration != -1) {
            str2 = str2 + "dur(" + this.mDuration + ") ";
        }
        if (this.Cd != -1) {
            str2 = str2 + "dly(" + this.Cd + ") ";
        }
        if (this.Ce != null) {
            str2 = str2 + "interp(" + this.Ce + ") ";
        }
        if (this.Cf.size() <= 0 && this.Cg.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.Cf.size() > 0) {
            for (int i2 = 0; i2 < this.Cf.size(); i2++) {
                if (i2 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.Cf.get(i2);
            }
        }
        if (this.Cg.size() > 0) {
            for (int i3 = 0; i3 < this.Cg.size(); i3++) {
                if (i3 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.Cg.get(i3);
            }
        }
        return str3 + ")";
    }

    /* access modifiers changed from: package-private */
    public static class a {
        v CI;
        ap CJ;
        Transition CK;
        String mName;
        View mView;

        a(View view, String str, Transition transition, ap apVar, v vVar) {
            this.mView = view;
            this.mName = str;
            this.CI = vVar;
            this.CJ = apVar;
            this.CK = transition;
        }
    }

    static class b {
        static <T> ArrayList<T> a(ArrayList<T> arrayList, T t) {
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            if (!arrayList.contains(t)) {
                arrayList.add(t);
            }
            return arrayList;
        }

        static <T> ArrayList<T> b(ArrayList<T> arrayList, T t) {
            if (arrayList == null) {
                return arrayList;
            }
            arrayList.remove(t);
            if (arrayList.isEmpty()) {
                return null;
            }
            return arrayList;
        }
    }
}
