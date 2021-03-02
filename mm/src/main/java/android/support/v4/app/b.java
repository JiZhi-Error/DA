package android.support.v4.app;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManagerImpl;
import android.support.v4.app.g;
import android.support.v4.e.f;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* access modifiers changed from: package-private */
public final class b extends k implements FragmentManagerImpl.h, g.a {
    final FragmentManagerImpl EE;
    ArrayList<a> EF = new ArrayList<>();
    int EG;
    int EH;
    int EI;
    int EJ;
    int EK;
    int EL;
    boolean EM;
    boolean EN = true;
    boolean EO;
    int EP;
    CharSequence EQ;
    int ER;
    CharSequence ES;
    ArrayList<String> ET;
    ArrayList<String> EU;
    boolean EV = false;
    ArrayList<Runnable> EW;
    int mIndex = -1;
    String mName;

    /* access modifiers changed from: package-private */
    public static final class a {
        int EX;
        int EY;
        int EZ;
        int Fa;
        int Fb;
        Fragment fragment;

        a() {
        }

        a(int i2, Fragment fragment2) {
            this.EX = i2;
            this.fragment = fragment2;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.mIndex >= 0) {
            sb.append(" #");
            sb.append(this.mIndex);
        }
        if (this.mName != null) {
            sb.append(" ");
            sb.append(this.mName);
        }
        sb.append("}");
        return sb.toString();
    }

    public final void a(String str, PrintWriter printWriter) {
        a(str, printWriter, true);
    }

    public final void a(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.mName);
            printWriter.print(" mIndex=");
            printWriter.print(this.mIndex);
            printWriter.print(" mCommitted=");
            printWriter.println(this.EO);
            if (this.EK != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.EK));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.EL));
            }
            if (!(this.EG == 0 && this.EH == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.EG));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.EH));
            }
            if (!(this.EI == 0 && this.EJ == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.EI));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.EJ));
            }
            if (!(this.EP == 0 && this.EQ == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.EP));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.EQ);
            }
            if (!(this.ER == 0 && this.ES == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.ER));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.ES);
            }
        }
        if (!this.EF.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Operations:");
            new StringBuilder().append(str).append("    ");
            int size = this.EF.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = this.EF.get(i2);
                switch (aVar.EX) {
                    case 0:
                        str2 = "NULL";
                        break;
                    case 1:
                        str2 = "ADD";
                        break;
                    case 2:
                        str2 = "REPLACE";
                        break;
                    case 3:
                        str2 = "REMOVE";
                        break;
                    case 4:
                        str2 = "HIDE";
                        break;
                    case 5:
                        str2 = "SHOW";
                        break;
                    case 6:
                        str2 = "DETACH";
                        break;
                    case 7:
                        str2 = "ATTACH";
                        break;
                    case 8:
                        str2 = "SET_PRIMARY_NAV";
                        break;
                    case 9:
                        str2 = "UNSET_PRIMARY_NAV";
                        break;
                    default:
                        str2 = "cmd=" + aVar.EX;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.print(str2);
                printWriter.print(" ");
                printWriter.println(aVar.fragment);
                if (z) {
                    if (!(aVar.EY == 0 && aVar.EZ == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.EY));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.EZ));
                    }
                    if (aVar.Fa != 0 || aVar.Fb != 0) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(aVar.Fa));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(aVar.Fb));
                    }
                }
            }
        }
    }

    public b(FragmentManagerImpl fragmentManagerImpl) {
        this.EE = fragmentManagerImpl;
    }

    /* access modifiers changed from: package-private */
    public final void a(a aVar) {
        this.EF.add(aVar);
        aVar.EY = this.EG;
        aVar.EZ = this.EH;
        aVar.Fa = this.EI;
        aVar.Fb = this.EJ;
    }

    @Override // android.support.v4.app.k
    public final k a(Fragment fragment, String str) {
        a(0, fragment, str, 1);
        return this;
    }

    @Override // android.support.v4.app.k
    public final k a(int i2, Fragment fragment) {
        a(i2, fragment, null, 1);
        return this;
    }

    @Override // android.support.v4.app.k
    public final k a(int i2, Fragment fragment, String str) {
        a(i2, fragment, str, 1);
        return this;
    }

    private void a(int i2, Fragment fragment, String str, int i3) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        fragment.mFragmentManager = this.EE;
        if (str != null) {
            if (fragment.mTag == null || str.equals(fragment.mTag)) {
                fragment.mTag = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.mTag + " now " + str);
            }
        }
        if (i2 != 0) {
            if (i2 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            } else if (fragment.mFragmentId == 0 || fragment.mFragmentId == i2) {
                fragment.mFragmentId = i2;
                fragment.mContainerId = i2;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.mFragmentId + " now " + i2);
            }
        }
        a(new a(i3, fragment));
    }

    @Override // android.support.v4.app.k
    public final k a(Fragment fragment) {
        a(new a(3, fragment));
        return this;
    }

    @Override // android.support.v4.app.k
    public final k b(Fragment fragment) {
        a(new a(5, fragment));
        return this;
    }

    @Override // android.support.v4.app.k
    public final k c(Fragment fragment) {
        a(new a(6, fragment));
        return this;
    }

    @Override // android.support.v4.app.k
    public final k d(Fragment fragment) {
        a(new a(7, fragment));
        return this;
    }

    @Override // android.support.v4.app.k
    public final k u(int i2, int i3) {
        this.EG = i2;
        this.EH = i3;
        this.EI = 0;
        this.EJ = 0;
        return this;
    }

    @Override // android.support.v4.app.k
    public final k dY() {
        if (!this.EN) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        this.EM = true;
        this.mName = null;
        return this;
    }

    private k dZ() {
        if (this.EM) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.EN = false;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final void aq(int i2) {
        if (this.EM) {
            if (FragmentManagerImpl.DEBUG) {
                new StringBuilder("Bump nesting in ").append(this).append(" by ").append(i2);
            }
            int size = this.EF.size();
            for (int i3 = 0; i3 < size; i3++) {
                a aVar = this.EF.get(i3);
                if (aVar.fragment != null) {
                    aVar.fragment.mBackStackNesting += i2;
                    if (FragmentManagerImpl.DEBUG) {
                        new StringBuilder("Bump nesting of ").append(aVar.fragment).append(" to ").append(aVar.fragment.mBackStackNesting);
                    }
                }
            }
        }
    }

    public final void ea() {
        if (this.EW != null) {
            int size = this.EW.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.EW.get(i2).run();
            }
            this.EW = null;
        }
    }

    @Override // android.support.v4.app.k
    public final int commit() {
        return C(false);
    }

    @Override // android.support.v4.app.k
    public final int commitAllowingStateLoss() {
        return C(true);
    }

    @Override // android.support.v4.app.k
    public final void commitNow() {
        dZ();
        this.EE.execSingleAction(this, false);
    }

    @Override // android.support.v4.app.k
    public final void commitNowAllowingStateLoss() {
        dZ();
        this.EE.execSingleAction(this, true);
    }

    private int C(boolean z) {
        if (this.EO) {
            throw new IllegalStateException("commit already called");
        }
        if (FragmentManagerImpl.DEBUG) {
            new StringBuilder("Commit: ").append(this);
            PrintWriter printWriter = new PrintWriter(new f("FragmentManager"));
            a("  ", printWriter);
            printWriter.close();
        }
        this.EO = true;
        if (this.EM) {
            this.mIndex = this.EE.allocBackStackIndex(this);
        } else {
            this.mIndex = -1;
        }
        this.EE.enqueueAction(this, z);
        return this.mIndex;
    }

    @Override // android.support.v4.app.FragmentManagerImpl.h
    public final boolean a(ArrayList<b> arrayList, ArrayList<Boolean> arrayList2) {
        if (FragmentManagerImpl.DEBUG) {
            new StringBuilder("Run: ").append(this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.EM) {
            return true;
        }
        this.EE.addBackStackState(this);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean ar(int i2) {
        int size = this.EF.size();
        for (int i3 = 0; i3 < size; i3++) {
            a aVar = this.EF.get(i3);
            int i4 = aVar.fragment != null ? aVar.fragment.mContainerId : 0;
            if (i4 != 0 && i4 == i2) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(ArrayList<b> arrayList, int i2, int i3) {
        int i4;
        if (i3 == i2) {
            return false;
        }
        int size = this.EF.size();
        int i5 = -1;
        int i6 = 0;
        while (i6 < size) {
            a aVar = this.EF.get(i6);
            int i7 = aVar.fragment != null ? aVar.fragment.mContainerId : 0;
            if (i7 == 0 || i7 == i5) {
                i4 = i5;
            } else {
                for (int i8 = i2; i8 < i3; i8++) {
                    b bVar = arrayList.get(i8);
                    int size2 = bVar.EF.size();
                    for (int i9 = 0; i9 < size2; i9++) {
                        a aVar2 = bVar.EF.get(i9);
                        if ((aVar2.fragment != null ? aVar2.fragment.mContainerId : 0) == i7) {
                            return true;
                        }
                    }
                }
                i4 = i7;
            }
            i6++;
            i5 = i4;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void eb() {
        int size = this.EF.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = this.EF.get(i2);
            Fragment fragment = aVar.fragment;
            if (fragment != null) {
                fragment.setNextTransition(this.EK, this.EL);
            }
            switch (aVar.EX) {
                case 1:
                    fragment.setNextAnim(aVar.EY);
                    this.EE.addFragment(fragment, false);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.EX);
                case 3:
                    fragment.setNextAnim(aVar.EZ);
                    this.EE.removeFragment(fragment);
                    break;
                case 4:
                    fragment.setNextAnim(aVar.EZ);
                    this.EE.hideFragment(fragment);
                    break;
                case 5:
                    fragment.setNextAnim(aVar.EY);
                    this.EE.showFragment(fragment);
                    break;
                case 6:
                    fragment.setNextAnim(aVar.EZ);
                    this.EE.detachFragment(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(aVar.EY);
                    this.EE.attachFragment(fragment);
                    break;
                case 8:
                    this.EE.setPrimaryNavigationFragment(fragment);
                    break;
                case 9:
                    this.EE.setPrimaryNavigationFragment(null);
                    break;
            }
            if (!(this.EV || aVar.EX == 1 || fragment == null)) {
                this.EE.moveFragmentToExpectedState(fragment);
            }
        }
        if (!this.EV) {
            this.EE.moveToState(this.EE.mCurState, true);
        }
    }

    /* access modifiers changed from: package-private */
    public final void D(boolean z) {
        for (int size = this.EF.size() - 1; size >= 0; size--) {
            a aVar = this.EF.get(size);
            Fragment fragment = aVar.fragment;
            if (fragment != null) {
                fragment.setNextTransition(FragmentManagerImpl.reverseTransit(this.EK), this.EL);
            }
            switch (aVar.EX) {
                case 1:
                    fragment.setNextAnim(aVar.Fb);
                    this.EE.removeFragment(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + aVar.EX);
                case 3:
                    fragment.setNextAnim(aVar.Fa);
                    this.EE.addFragment(fragment, false);
                    break;
                case 4:
                    fragment.setNextAnim(aVar.Fa);
                    this.EE.showFragment(fragment);
                    break;
                case 5:
                    fragment.setNextAnim(aVar.Fb);
                    this.EE.hideFragment(fragment);
                    break;
                case 6:
                    fragment.setNextAnim(aVar.Fa);
                    this.EE.attachFragment(fragment);
                    break;
                case 7:
                    fragment.setNextAnim(aVar.Fb);
                    this.EE.detachFragment(fragment);
                    break;
                case 8:
                    this.EE.setPrimaryNavigationFragment(null);
                    break;
                case 9:
                    this.EE.setPrimaryNavigationFragment(fragment);
                    break;
            }
            if (!(this.EV || aVar.EX == 3 || fragment == null)) {
                this.EE.moveFragmentToExpectedState(fragment);
            }
        }
        if (!this.EV && z) {
            this.EE.moveToState(this.EE.mCurState, true);
        }
    }

    /* access modifiers changed from: package-private */
    public final Fragment a(ArrayList<Fragment> arrayList, Fragment fragment) {
        boolean z;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.EF.size()) {
                return fragment;
            }
            a aVar = this.EF.get(i3);
            switch (aVar.EX) {
                case 1:
                case 7:
                    arrayList.add(aVar.fragment);
                    break;
                case 2:
                    Fragment fragment2 = aVar.fragment;
                    int i4 = fragment2.mContainerId;
                    boolean z2 = false;
                    int size = arrayList.size() - 1;
                    int i5 = i3;
                    Fragment fragment3 = fragment;
                    while (size >= 0) {
                        Fragment fragment4 = arrayList.get(size);
                        if (fragment4.mContainerId != i4) {
                            z = z2;
                        } else if (fragment4 == fragment2) {
                            z = true;
                        } else {
                            if (fragment4 == fragment3) {
                                this.EF.add(i5, new a(9, fragment4));
                                i5++;
                                fragment3 = null;
                            }
                            a aVar2 = new a(3, fragment4);
                            aVar2.EY = aVar.EY;
                            aVar2.Fa = aVar.Fa;
                            aVar2.EZ = aVar.EZ;
                            aVar2.Fb = aVar.Fb;
                            this.EF.add(i5, aVar2);
                            arrayList.remove(fragment4);
                            i5++;
                            z = z2;
                        }
                        size--;
                        z2 = z;
                    }
                    if (!z2) {
                        aVar.EX = 1;
                        arrayList.add(fragment2);
                        i3 = i5;
                        fragment = fragment3;
                        break;
                    } else {
                        this.EF.remove(i5);
                        i3 = i5 - 1;
                        fragment = fragment3;
                        break;
                    }
                case 3:
                case 6:
                    arrayList.remove(aVar.fragment);
                    if (aVar.fragment != fragment) {
                        break;
                    } else {
                        this.EF.add(i3, new a(9, aVar.fragment));
                        i3++;
                        fragment = null;
                        break;
                    }
                case 8:
                    this.EF.add(i3, new a(9, fragment));
                    i3++;
                    fragment = aVar.fragment;
                    break;
            }
            i2 = i3 + 1;
        }
    }

    /* access modifiers changed from: package-private */
    public final Fragment b(ArrayList<Fragment> arrayList, Fragment fragment) {
        for (int i2 = 0; i2 < this.EF.size(); i2++) {
            a aVar = this.EF.get(i2);
            switch (aVar.EX) {
                case 1:
                case 7:
                    arrayList.remove(aVar.fragment);
                    break;
                case 3:
                case 6:
                    arrayList.add(aVar.fragment);
                    break;
                case 8:
                    fragment = null;
                    break;
                case 9:
                    fragment = aVar.fragment;
                    break;
            }
        }
        return fragment;
    }

    /* access modifiers changed from: package-private */
    public final void a(Fragment.c cVar) {
        for (int i2 = 0; i2 < this.EF.size(); i2++) {
            a aVar = this.EF.get(i2);
            if (b(aVar)) {
                aVar.fragment.setOnStartEnterTransitionListener(cVar);
            }
        }
    }

    static boolean b(a aVar) {
        Fragment fragment = aVar.fragment;
        return fragment != null && fragment.mAdded && fragment.mView != null && !fragment.mDetached && !fragment.mHidden && fragment.isPostponed();
    }

    @Override // android.support.v4.app.k
    public final k b(int i2, Fragment fragment) {
        if (i2 == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        a(i2, fragment, null, 2);
        return this;
    }
}
