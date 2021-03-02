package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.view.q;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class j extends q {
    private static final boolean DEBUG = false;
    private static final String TAG = "FragmentStatePagerAdapt";
    private k mCurTransaction = null;
    private Fragment mCurrentPrimaryItem = null;
    private final g mFragmentManager;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private ArrayList<Fragment.SavedState> mSavedState = new ArrayList<>();

    public abstract Fragment getItem(int i2);

    public j(g gVar) {
        this.mFragmentManager = gVar;
    }

    @Override // android.support.v4.view.q
    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }

    @Override // android.support.v4.view.q
    public Object instantiateItem(ViewGroup viewGroup, int i2) {
        Fragment.SavedState savedState;
        Fragment fragment;
        if (this.mFragments.size() > i2 && (fragment = this.mFragments.get(i2)) != null) {
            return fragment;
        }
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.beginTransaction();
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
        this.mCurTransaction.a(viewGroup.getId(), item);
        return item;
    }

    @Override // android.support.v4.view.q
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        Fragment.SavedState savedState;
        Fragment fragment = (Fragment) obj;
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.beginTransaction();
        }
        while (this.mSavedState.size() <= i2) {
            this.mSavedState.add(null);
        }
        ArrayList<Fragment.SavedState> arrayList = this.mSavedState;
        if (fragment.isAdded()) {
            savedState = this.mFragmentManager.saveFragmentInstanceState(fragment);
        } else {
            savedState = null;
        }
        arrayList.set(i2, savedState);
        this.mFragments.set(i2, null);
        this.mCurTransaction.a(fragment);
    }

    @Override // android.support.v4.view.q
    public void setPrimaryItem(ViewGroup viewGroup, int i2, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (fragment != this.mCurrentPrimaryItem) {
            if (this.mCurrentPrimaryItem != null) {
                this.mCurrentPrimaryItem.setMenuVisibility(false);
                this.mCurrentPrimaryItem.setUserVisibleHint(false);
            }
            fragment.setMenuVisibility(true);
            fragment.setUserVisibleHint(true);
            this.mCurrentPrimaryItem = fragment;
        }
    }

    @Override // android.support.v4.view.q
    public void finishUpdate(ViewGroup viewGroup) {
        if (this.mCurTransaction != null) {
            this.mCurTransaction.commitNowAllowingStateLoss();
            this.mCurTransaction = null;
        }
    }

    @Override // android.support.v4.view.q
    public boolean isViewFromObject(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    @Override // android.support.v4.view.q
    public Parcelable saveState() {
        Bundle bundle = null;
        if (this.mSavedState.size() > 0) {
            bundle = new Bundle();
            Fragment.SavedState[] savedStateArr = new Fragment.SavedState[this.mSavedState.size()];
            this.mSavedState.toArray(savedStateArr);
            bundle.putParcelableArray("states", savedStateArr);
        }
        Bundle bundle2 = bundle;
        for (int i2 = 0; i2 < this.mFragments.size(); i2++) {
            Fragment fragment = this.mFragments.get(i2);
            if (fragment != null && fragment.isAdded()) {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                }
                this.mFragmentManager.putFragment(bundle2, "f".concat(String.valueOf(i2)), fragment);
            }
        }
        return bundle2;
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
                    this.mSavedState.add((Fragment.SavedState) parcelable2);
                }
            }
            for (T t : bundle.keySet()) {
                if (t.startsWith("f")) {
                    int parseInt = Integer.parseInt(t.substring(1));
                    Fragment fragment = this.mFragmentManager.getFragment(bundle, t);
                    if (fragment != null) {
                        while (this.mFragments.size() <= parseInt) {
                            this.mFragments.add(null);
                        }
                        fragment.setMenuVisibility(false);
                        this.mFragments.set(parseInt, fragment);
                    }
                }
            }
        }
    }
}
