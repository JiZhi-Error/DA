package com.samsung.android.sdk.look.airbutton;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class SlookAirButtonAdapter {
    private CharSequence mEmptyText;
    private ArrayList<AirButtonItem> mItemList = null;

    public SlookAirButtonAdapter() {
    }

    public SlookAirButtonAdapter(ArrayList<AirButtonItem> arrayList) {
        AppMethodBeat.i(76284);
        addItem(arrayList);
        AppMethodBeat.o(76284);
    }

    public void addItem(AirButtonItem airButtonItem) {
        AppMethodBeat.i(76285);
        if (this.mItemList == null) {
            this.mItemList = new ArrayList<>();
        }
        this.mItemList.add(airButtonItem);
        AppMethodBeat.o(76285);
    }

    public int addItem(ArrayList<AirButtonItem> arrayList) {
        AppMethodBeat.i(76286);
        if (this.mItemList != null) {
            this.mItemList.clear();
        }
        this.mItemList = arrayList;
        int size = this.mItemList.size() - 1;
        AppMethodBeat.o(76286);
        return size;
    }

    public void insertItem(int i2, AirButtonItem airButtonItem) {
        AppMethodBeat.i(76287);
        if (this.mItemList != null) {
            this.mItemList.add(i2, airButtonItem);
            AppMethodBeat.o(76287);
        } else if (i2 == 0) {
            addItem(airButtonItem);
            AppMethodBeat.o(76287);
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The list is empty.");
            AppMethodBeat.o(76287);
            throw illegalArgumentException;
        }
    }

    public void removeItem(int i2) {
        AppMethodBeat.i(76288);
        if (this.mItemList == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The list is empty.");
            AppMethodBeat.o(76288);
            throw illegalArgumentException;
        }
        this.mItemList.remove(i2);
        AppMethodBeat.o(76288);
    }

    public void updateItem(int i2, AirButtonItem airButtonItem) {
        AppMethodBeat.i(76289);
        if (this.mItemList == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The list is empty.");
            AppMethodBeat.o(76289);
            throw illegalArgumentException;
        }
        this.mItemList.set(i2, airButtonItem);
        AppMethodBeat.o(76289);
    }

    public void clear() {
        AppMethodBeat.i(76290);
        if (this.mItemList == null) {
            AppMethodBeat.o(76290);
            return;
        }
        this.mItemList.clear();
        AppMethodBeat.o(76290);
    }

    public int getCount() {
        AppMethodBeat.i(76291);
        if (this.mItemList == null) {
            AppMethodBeat.o(76291);
            return 0;
        }
        int size = this.mItemList.size();
        AppMethodBeat.o(76291);
        return size;
    }

    public AirButtonItem getItem(int i2) {
        AppMethodBeat.i(76292);
        if (this.mItemList == null || i2 >= this.mItemList.size()) {
            AppMethodBeat.o(76292);
            return null;
        }
        AirButtonItem airButtonItem = this.mItemList.get(i2);
        AppMethodBeat.o(76292);
        return airButtonItem;
    }

    public void setEmptyText(CharSequence charSequence) {
        this.mEmptyText = charSequence;
    }

    public CharSequence getEmptyText() {
        return this.mEmptyText;
    }

    public boolean onHoverEnter(View view) {
        return true;
    }

    public void onHoverExit(View view) {
    }

    public void onShow(View view) {
    }

    public void onHide(View view) {
    }

    public void onDismiss(View view) {
    }

    public static class AirButtonItem {
        private Object mData = null;
        private String mDescription = null;
        private Drawable mImage = null;
        private String mSubDescription = null;
        private View mView = null;

        public AirButtonItem(View view, Object obj) {
            AppMethodBeat.i(76274);
            if (view == null && obj == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("You should set the View and Object in Param");
                AppMethodBeat.o(76274);
                throw illegalArgumentException;
            }
            set(view, obj);
            AppMethodBeat.o(76274);
        }

        public AirButtonItem(Drawable drawable, String str, Object obj) {
            AppMethodBeat.i(76275);
            if (drawable == null && str == null && obj == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("You should set the Drawable, String and Object in Param");
                AppMethodBeat.o(76275);
                throw illegalArgumentException;
            }
            set(drawable, str, obj);
            AppMethodBeat.o(76275);
        }

        public AirButtonItem(Drawable drawable, String str, String str2, Object obj) {
            AppMethodBeat.i(76276);
            if (drawable == null && str == null && str2 == null && obj == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("You should set the Drawable, String, subDescription and Object in Param");
                AppMethodBeat.o(76276);
                throw illegalArgumentException;
            }
            set(drawable, str, str2, obj);
            AppMethodBeat.o(76276);
        }

        public void set(View view, Object obj) {
            this.mView = view;
            this.mData = obj;
        }

        public void set(Drawable drawable, String str, Object obj) {
            this.mImage = drawable;
            this.mDescription = str;
            this.mData = obj;
        }

        public void set(Drawable drawable, String str, String str2, Object obj) {
            this.mImage = drawable;
            this.mDescription = str;
            this.mSubDescription = str2;
            this.mData = obj;
        }

        public View getView() {
            return this.mView;
        }

        public Drawable getImage() {
            return this.mImage;
        }

        public String getDescription() {
            return this.mDescription;
        }

        public String getSubDescription() {
            return this.mSubDescription;
        }

        public Object getData() {
            return this.mData;
        }
    }
}
