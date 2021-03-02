package android.support.v4.app;

import android.os.Parcelable;
import android.support.v4.view.q;
import android.view.View;
import android.view.ViewGroup;

public abstract class i extends q {
    private k mCurTransaction = null;
    private Fragment mCurrentPrimaryItem = null;
    private final g mFragmentManager;

    public abstract Fragment getItem(int i2);

    public i(g gVar) {
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
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.beginTransaction();
        }
        long j2 = (long) i2;
        Fragment findFragmentByTag = this.mFragmentManager.findFragmentByTag(b(viewGroup.getId(), j2));
        if (findFragmentByTag != null) {
            this.mCurTransaction.d(findFragmentByTag);
        } else {
            findFragmentByTag = getItem(i2);
            this.mCurTransaction.a(viewGroup.getId(), findFragmentByTag, b(viewGroup.getId(), j2));
        }
        if (findFragmentByTag != this.mCurrentPrimaryItem) {
            findFragmentByTag.setMenuVisibility(false);
            findFragmentByTag.setUserVisibleHint(false);
        }
        return findFragmentByTag;
    }

    @Override // android.support.v4.view.q
    public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.beginTransaction();
        }
        this.mCurTransaction.c((Fragment) obj);
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
        return null;
    }

    @Override // android.support.v4.view.q
    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
    }

    private static String b(int i2, long j2) {
        return "android:switcher:" + i2 + ":" + j2;
    }
}
