package android.support.design.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.transition.s;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.o;
import android.support.v7.view.menu.u;
import android.view.MenuItem;

public final class BottomNavigationPresenter implements o {
    public int id;
    private h kE;
    public BottomNavigationMenuView kG;
    public boolean kH = false;

    @Override // android.support.v7.view.menu.o
    public final void a(Context context, h hVar) {
        this.kE = hVar;
        this.kG.kE = this.kE;
    }

    @Override // android.support.v7.view.menu.o
    public final void p(boolean z) {
        if (!this.kH) {
            if (z) {
                this.kG.bE();
                return;
            }
            BottomNavigationMenuView bottomNavigationMenuView = this.kG;
            if (!(bottomNavigationMenuView.kE == null || bottomNavigationMenuView.kr == null)) {
                int size = bottomNavigationMenuView.kE.size();
                if (size != bottomNavigationMenuView.kr.length) {
                    bottomNavigationMenuView.bE();
                    return;
                }
                int i2 = bottomNavigationMenuView.ks;
                for (int i3 = 0; i3 < size; i3++) {
                    MenuItem item = bottomNavigationMenuView.kE.getItem(i3);
                    if (item.isChecked()) {
                        bottomNavigationMenuView.ks = item.getItemId();
                        bottomNavigationMenuView.kt = i3;
                    }
                }
                if (i2 != bottomNavigationMenuView.ks) {
                    s.a(bottomNavigationMenuView, bottomNavigationMenuView.ki);
                }
                boolean m = BottomNavigationMenuView.m(bottomNavigationMenuView.ka, bottomNavigationMenuView.kE.m1if().size());
                for (int i4 = 0; i4 < size; i4++) {
                    bottomNavigationMenuView.kD.kH = true;
                    bottomNavigationMenuView.kr[i4].setLabelVisibilityMode(bottomNavigationMenuView.ka);
                    bottomNavigationMenuView.kr[i4].setShifting(m);
                    bottomNavigationMenuView.kr[i4].a((j) bottomNavigationMenuView.kE.getItem(i4));
                    bottomNavigationMenuView.kD.kH = false;
                }
            }
        }
    }

    @Override // android.support.v7.view.menu.o
    public final void a(o.a aVar) {
    }

    @Override // android.support.v7.view.menu.o
    public final boolean a(u uVar) {
        return false;
    }

    @Override // android.support.v7.view.menu.o
    public final void a(h hVar, boolean z) {
    }

    @Override // android.support.v7.view.menu.o
    public final boolean bF() {
        return false;
    }

    @Override // android.support.v7.view.menu.o
    public final boolean b(j jVar) {
        return false;
    }

    @Override // android.support.v7.view.menu.o
    public final boolean c(j jVar) {
        return false;
    }

    @Override // android.support.v7.view.menu.o
    public final int getId() {
        return this.id;
    }

    @Override // android.support.v7.view.menu.o
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.ks = this.kG.getSelectedItemId();
        return savedState;
    }

    @Override // android.support.v7.view.menu.o
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            BottomNavigationMenuView bottomNavigationMenuView = this.kG;
            int i2 = ((SavedState) parcelable).ks;
            int size = bottomNavigationMenuView.kE.size();
            for (int i3 = 0; i3 < size; i3++) {
                MenuItem item = bottomNavigationMenuView.kE.getItem(i3);
                if (i2 == item.getItemId()) {
                    bottomNavigationMenuView.ks = i2;
                    bottomNavigationMenuView.kt = i3;
                    item.setChecked(true);
                    return;
                }
            }
        }
    }

    static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class android.support.design.internal.BottomNavigationPresenter.SavedState.AnonymousClass1 */

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
        int ks;

        SavedState() {
        }

        SavedState(Parcel parcel) {
            this.ks = parcel.readInt();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.ks);
        }
    }
}
