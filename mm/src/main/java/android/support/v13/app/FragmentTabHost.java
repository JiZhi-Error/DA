package android.support.v13.app;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TabHost;
import java.util.ArrayList;

@Deprecated
public class FragmentTabHost extends TabHost implements TabHost.OnTabChangeListener {
    private final ArrayList<a> Ep = new ArrayList<>();
    private FragmentManager Eq;
    private TabHost.OnTabChangeListener Er;
    private a Es;
    private boolean Et;
    private int mContainerId;
    private Context mContext;

    /* access modifiers changed from: package-private */
    public static final class a {
        final Class<?> Ev;
        final Bundle Ew;
        Fragment Ex;
        final String tag;
    }

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class android.support.v13.app.FragmentTabHost.SavedState.AnonymousClass1 */

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

    @Deprecated
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

    @Deprecated
    public void setOnTabChangedListener(TabHost.OnTabChangeListener onTabChangeListener) {
        this.Er = onTabChangeListener;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String currentTabTag = getCurrentTabTag();
        FragmentTransaction fragmentTransaction = null;
        for (int i2 = 0; i2 < this.Ep.size(); i2++) {
            a aVar = this.Ep.get(i2);
            aVar.Ex = this.Eq.findFragmentByTag(aVar.tag);
            if (aVar.Ex != null && !aVar.Ex.isDetached()) {
                if (aVar.tag.equals(currentTabTag)) {
                    this.Es = aVar;
                } else {
                    if (fragmentTransaction == null) {
                        fragmentTransaction = this.Eq.beginTransaction();
                    }
                    fragmentTransaction.detach(aVar.Ex);
                }
            }
        }
        this.Et = true;
        FragmentTransaction a2 = a(currentTabTag, fragmentTransaction);
        if (a2 != null) {
            a2.commit();
            this.Eq.executePendingTransactions();
        }
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.Et = false;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.Eu = getCurrentTabTag();
        return savedState;
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setCurrentTabByTag(savedState.Eu);
    }

    @Deprecated
    public void onTabChanged(String str) {
        FragmentTransaction a2;
        if (this.Et && (a2 = a(str, null)) != null) {
            a2.commit();
        }
        if (this.Er != null) {
            this.Er.onTabChanged(str);
        }
    }

    private FragmentTransaction a(String str, FragmentTransaction fragmentTransaction) {
        a aVar = null;
        int i2 = 0;
        while (i2 < this.Ep.size()) {
            a aVar2 = this.Ep.get(i2);
            if (!aVar2.tag.equals(str)) {
                aVar2 = aVar;
            }
            i2++;
            aVar = aVar2;
        }
        if (aVar == null) {
            throw new IllegalStateException("No tab known for tag ".concat(String.valueOf(str)));
        }
        if (this.Es != aVar) {
            if (fragmentTransaction == null) {
                fragmentTransaction = this.Eq.beginTransaction();
            }
            if (!(this.Es == null || this.Es.Ex == null)) {
                fragmentTransaction.detach(this.Es.Ex);
            }
            if (aVar != null) {
                if (aVar.Ex == null) {
                    aVar.Ex = Fragment.instantiate(this.mContext, aVar.Ev.getName(), aVar.Ew);
                    fragmentTransaction.add(this.mContainerId, aVar.Ex, aVar.tag);
                } else {
                    fragmentTransaction.attach(aVar.Ex);
                }
            }
            this.Es = aVar;
        }
        return fragmentTransaction;
    }
}
