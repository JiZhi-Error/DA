package android.support.v4.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TabHost;
import java.util.ArrayList;

public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {
    private final ArrayList<a> Ep = new ArrayList<>();
    private TabHost.OnTabChangeListener Er;
    private boolean Et;
    private a Gh;
    private int mContainerId;
    private Context mContext;
    private g mFragmentManager;

    /* access modifiers changed from: package-private */
    public static final class a {
        final Class<?> Ev;
        final Bundle Ew;
        Fragment fragment;
        final String tag;
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class android.support.v4.app.FragmentTabHost.SavedState.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }
        };
        String Eu;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.Eu = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.Eu);
        }

        public String toString() {
            return "FragmentTabHost.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " curTab=" + this.Eu + "}";
        }
    }

    public FragmentTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842995}, 0, 0);
        this.mContainerId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        super.setOnTabChangedListener(this);
    }

    @Deprecated
    public void setup() {
        throw new IllegalStateException("Must call setup() that takes a Context and FragmentManager");
    }

    public void setOnTabChangedListener(TabHost.OnTabChangeListener onTabChangeListener) {
        this.Er = onTabChangeListener;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        k kVar = null;
        int size = this.Ep.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = this.Ep.get(i2);
            aVar.fragment = this.mFragmentManager.findFragmentByTag(aVar.tag);
            if (aVar.fragment != null && !aVar.fragment.isDetached()) {
                if (aVar.tag.equals(currentTabTag)) {
                    this.Gh = aVar;
                } else {
                    if (kVar == null) {
                        kVar = this.mFragmentManager.beginTransaction();
                    }
                    kVar.c(aVar.fragment);
                }
            }
        }
        this.Et = true;
        k a2 = a(currentTabTag, kVar);
        if (a2 != null) {
            a2.commit();
            this.mFragmentManager.executePendingTransactions();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.Et = false;
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Eu = getCurrentTabTag();
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.Eu);
    }

    public void onTabChanged(String str) {
        k a2;
        if (this.Et && (a2 = a(str, null)) != null) {
            a2.commit();
        }
        if (this.Er != null) {
            this.Er.onTabChanged(str);
        }
    }

    private k a(String str, k kVar) {
        a s = s(str);
        if (this.Gh != s) {
            if (kVar == null) {
                kVar = this.mFragmentManager.beginTransaction();
            }
            if (!(this.Gh == null || this.Gh.fragment == null)) {
                kVar.c(this.Gh.fragment);
            }
            if (s != null) {
                if (s.fragment == null) {
                    s.fragment = Fragment.instantiate(this.mContext, s.Ev.getName(), s.Ew);
                    kVar.a(this.mContainerId, s.fragment, s.tag);
                } else {
                    kVar.d(s.fragment);
                }
            }
            this.Gh = s;
        }
        return kVar;
    }

    private a s(String str) {
        int size = this.Ep.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = this.Ep.get(i2);
            if (aVar.tag.equals(str)) {
                return aVar;
            }
        }
        return null;
    }
}
