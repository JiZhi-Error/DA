package com.tencent.mm.plugin.finder.view.adapter;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import android.support.v4.app.k;
import android.support.v4.view.q;
import android.view.View;
import android.view.ViewGroup;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u001dH&J\u0018\u0010#\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u001c\u0010(\u001a\u00020\u00192\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\n\u0010-\u001a\u0004\u0018\u00010*H\u0016J \u0010.\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010/\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R%\u0010\u0010\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u0011j\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e`\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R%\u0010\u0015\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0011j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0016`\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014¨\u00060"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/adapter/StatePagerAdapterCp;", "Landroid/support/v4/view/PagerAdapter;", "fm", "Landroid/support/v4/app/FragmentManager;", "(Landroid/support/v4/app/FragmentManager;)V", "getFm", "()Landroid/support/v4/app/FragmentManager;", "mCurTransaction", "Landroid/support/v4/app/FragmentTransaction;", "getMCurTransaction", "()Landroid/support/v4/app/FragmentTransaction;", "setMCurTransaction", "(Landroid/support/v4/app/FragmentTransaction;)V", "mCurrentPrimaryItem", "Landroid/support/v4/app/Fragment;", "mFragmentManager", "mFragments", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getMFragments", "()Ljava/util/ArrayList;", "mSavedState", "Landroid/support/v4/app/Fragment$SavedState;", "getMSavedState", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "", "object", "", "finishUpdate", "getItem", FirebaseAnalytics.b.INDEX, "instantiateItem", "isViewFromObject", "", "view", "Landroid/view/View;", "restoreState", "state", "Landroid/os/Parcelable;", "loader", "Ljava/lang/ClassLoader;", "saveState", "setPrimaryItem", "startUpdate", "plugin-finder_release"})
public abstract class d extends q {
    k mCurTransaction;
    private Fragment mCurrentPrimaryItem;
    private g mFragmentManager = this.wrt;
    final ArrayList<Fragment> mFragments = new ArrayList<>();
    final ArrayList<Fragment.SavedState> mSavedState = new ArrayList<>();
    final g wrt;

    public abstract Fragment getItem(int i2);

    public d(g gVar) {
        p.h(gVar, "fm");
        this.wrt = gVar;
    }

    @Override // android.support.v4.view.q
    public void startUpdate(ViewGroup viewGroup) {
        p.h(viewGroup, "container");
        if (!(viewGroup.getId() != -1)) {
            throw new IllegalStateException(("ViewPager with adapter " + this + " requires a view id").toString());
        }
    }

    @Override // android.support.v4.view.q
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        Fragment.SavedState savedState;
        Fragment fragment;
        p.h(viewGroup, "container");
        if (this.mFragments.size() > i2 && (fragment = this.mFragments.get(i2)) != null) {
            return fragment;
        }
        if (this.mCurTransaction == null) {
            g gVar = this.mFragmentManager;
            if (gVar == null) {
                p.hyc();
            }
            this.mCurTransaction = gVar.beginTransaction();
        }
        Fragment item = getItem(i2);
        if (this.mSavedState.size() > i2 && (savedState = this.mSavedState.get(i2)) != null) {
            item.setInitialSavedState(savedState);
        }
        while (this.mFragments.size() <= i2) {
            this.mFragments.add(null);
        }
        item.setMenuVisibility(false);
        item.setUserVisibleHint(false);
        this.mFragments.set(i2, item);
        k kVar = this.mCurTransaction;
        if (kVar == null) {
            p.hyc();
        }
        kVar.a(viewGroup.getId(), item);
        StringBuilder sb = new StringBuilder("instantiateItem: title:");
        if (item == null) {
            throw new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment");
        }
        Log.i("Finder.DynamicAdapter", sb.append(((FinderHomeTabFragment) item).title).append(" tabType:").append(((FinderHomeTabFragment) item).dLS).toString());
        return item;
    }

    @Override // android.support.v4.view.q
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Fragment.SavedState savedState;
        p.h(viewGroup, "container");
        p.h(obj, "object");
        Fragment fragment = (Fragment) obj;
        if (this.mCurTransaction == null) {
            g gVar = this.mFragmentManager;
            if (gVar == null) {
                p.hyc();
            }
            this.mCurTransaction = gVar.beginTransaction();
        }
        while (this.mSavedState.size() <= i2) {
            this.mSavedState.add(null);
        }
        ArrayList<Fragment.SavedState> arrayList = this.mSavedState;
        if (fragment.isAdded()) {
            g gVar2 = this.mFragmentManager;
            if (gVar2 == null) {
                p.hyc();
            }
            savedState = gVar2.saveFragmentInstanceState(fragment);
        } else {
            savedState = null;
        }
        arrayList.set(i2, savedState);
        this.mFragments.set(i2, null);
        k kVar = this.mCurTransaction;
        if (kVar == null) {
            p.hyc();
        }
        kVar.a(fragment);
    }

    @Override // android.support.v4.view.q
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        p.h(viewGroup, "container");
        p.h(obj, "object");
        Fragment fragment = (Fragment) obj;
        if (fragment != this.mCurrentPrimaryItem) {
            if (this.mCurrentPrimaryItem != null) {
                Fragment fragment2 = this.mCurrentPrimaryItem;
                if (fragment2 == null) {
                    p.hyc();
                }
                fragment2.setMenuVisibility(false);
                Fragment fragment3 = this.mCurrentPrimaryItem;
                if (fragment3 == null) {
                    p.hyc();
                }
                fragment3.setUserVisibleHint(false);
            }
            fragment.setMenuVisibility(true);
            fragment.setUserVisibleHint(true);
            this.mCurrentPrimaryItem = fragment;
        }
    }

    @Override // android.support.v4.view.q
    public void finishUpdate(ViewGroup viewGroup) {
        p.h(viewGroup, "container");
        if (this.mCurTransaction != null) {
            k kVar = this.mCurTransaction;
            if (kVar == null) {
                p.hyc();
            }
            kVar.commitNowAllowingStateLoss();
            this.mCurTransaction = null;
        }
    }

    @Override // android.support.v4.view.q
    public boolean isViewFromObject(View view, Object obj) {
        p.h(view, "view");
        p.h(obj, "object");
        return ((Fragment) obj).getView() == view;
    }

    @Override // android.support.v4.view.q
    public Parcelable saveState() {
        Bundle bundle;
        if (this.mSavedState.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.mSavedState.size()];
            this.mSavedState.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        } else {
            bundle = null;
        }
        int size = this.mFragments.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = this.mFragments.get(i2);
            if (fragment != null && fragment.isAdded()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                String concat = "f".concat(String.valueOf(i2));
                g gVar = this.mFragmentManager;
                if (gVar == null) {
                    p.hyc();
                }
                gVar.putFragment(bundle, concat, fragment);
            }
        }
        return bundle;
    }

    @Override // android.support.v4.view.q
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.mSavedState.clear();
            this.mFragments.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    ArrayList<Fragment.SavedState> arrayList = this.mSavedState;
                    if (parcelable2 == null) {
                        throw new t("null cannot be cast to non-null type android.support.v4.app.Fragment.SavedState");
                    }
                    arrayList.add((Fragment.SavedState) parcelable2);
                }
            }
            Set<String> keySet = bundle.keySet();
            p.g(keySet, "bundle.keySet()");
            for (T t : keySet) {
                if (t == null) {
                    throw new t("null cannot be cast to non-null type kotlin.String");
                }
                T t2 = t;
                if (n.J(t2, "f", false)) {
                    if (t2 == null) {
                        throw new t("null cannot be cast to non-null type java.lang.String");
                    }
                    String substring = t2.substring(1);
                    p.g(substring, "(this as java.lang.String).substring(startIndex)");
                    int parseInt = Integer.parseInt(substring);
                    g gVar = this.mFragmentManager;
                    if (gVar == null) {
                        p.hyc();
                    }
                    Fragment fragment = gVar.getFragment(bundle, t2);
                    if (fragment != null) {
                        while (this.mFragments.size() <= parseInt) {
                            this.mFragments.add(null);
                        }
                        fragment.setMenuVisibility(false);
                        this.mFragments.set(parseInt, fragment);
                    } else {
                        Log.w("FragmentStatePagerAdapt", "Bad fragment at key ".concat(String.valueOf(t2)));
                    }
                }
            }
        }
    }
}
