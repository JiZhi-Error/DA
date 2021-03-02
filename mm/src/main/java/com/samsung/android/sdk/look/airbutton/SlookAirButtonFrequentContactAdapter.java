package com.samsung.android.sdk.look.airbutton;

import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.samsung.android.sdk.look.Slook;
import com.samsung.android.sdk.look.SlookResourceManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class SlookAirButtonFrequentContactAdapter extends SlookAirButtonAdapter {
    public static final String DATA = "data";
    public static final String DISPLAY_NAME = "display_name";
    private static final String EMAIL = "vnd.android.cursor.item/email_v2";
    private static final String FREQUENT_URI = "content://com.android.contacts/contacts/frequent_data";
    public static final String ID = "id";
    public static final String LOOKUP_KEY = "lookup_key";
    private static final String MIME_TYPE = "MIME_TYPE";
    private static final String PHONE = "vnd.android.cursor.item/phone_v2";
    public static final String PHOTO = "photo";
    public static final String PHOTO_URI = "photo_uri";
    private static final String TAG = "AirButtonFrequentContactAdapter";
    private boolean DEBUG = false;
    private final String EXTRA_CONDITION = "extra_condition";
    private final String IS_PRIVATE = "is_private";
    private Context mContext;
    private int mCount = 0;
    private ArrayList<Bundle> mData = new ArrayList<>();
    private boolean mIsShowing = false;
    private int mMaxCount = 15;
    private boolean mNeedUpdate = true;
    private StringBuilder mSelectionSb;
    private Slook mSlook = new Slook();

    public SlookAirButtonFrequentContactAdapter(View view, Bundle bundle) {
        boolean z;
        AppMethodBeat.i(76277);
        if (view == null && bundle == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("You should set the View and Bundle in Param");
            AppMethodBeat.o(76277);
            throw illegalArgumentException;
        } else if (!isSupport(1)) {
            AppMethodBeat.o(76277);
        } else {
            if (bundle != null) {
                String string = bundle.getString(MIME_TYPE);
                this.mSelectionSb = new StringBuilder();
                if (string != null) {
                    this.mSelectionSb.append("view_data.");
                    this.mSelectionSb.append("mimetype");
                    this.mSelectionSb.append("='");
                    this.mSelectionSb.append(string);
                    this.mSelectionSb.append("'");
                    z = true;
                } else {
                    z = false;
                }
                boolean z2 = bundle.getBoolean("PRIVATE", false);
                if (!z2) {
                    if (z) {
                        this.mSelectionSb.append(" and ");
                    }
                    this.mSelectionSb.append("is_private=0");
                }
                String string2 = bundle.getString("extra_condition");
                if (string2 != null) {
                    if (z || !z2) {
                        this.mSelectionSb.append(" and ");
                    }
                    this.mSelectionSb.append(string2);
                }
            }
            this.mMaxCount = SlookResourceManager.getInt(2);
            this.DEBUG = true;
            if (view != null) {
                this.mContext = view.getContext();
                setEmptyText(SlookResourceManager.getText(this.mContext, 0));
            }
            AppMethodBeat.o(76277);
        }
    }

    @Override // com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter
    public final void onShow(View view) {
        AppMethodBeat.i(76278);
        updateData();
        this.mIsShowing = true;
        super.onShow(view);
        AppMethodBeat.o(76278);
    }

    @Override // com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter
    public final void onHide(View view) {
        AppMethodBeat.i(76279);
        this.mIsShowing = false;
        this.mNeedUpdate = true;
        this.mData.clear();
        super.onHide(view);
        AppMethodBeat.o(76279);
    }

    @Override // com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter
    public final void onDismiss(View view) {
        AppMethodBeat.i(76280);
        this.mIsShowing = false;
        this.mNeedUpdate = true;
        this.mData.clear();
        super.onDismiss(view);
        AppMethodBeat.o(76280);
    }

    @Override // com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter
    public final int getCount() {
        return this.mCount;
    }

    @Override // com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter
    public final SlookAirButtonAdapter.AirButtonItem getItem(int i2) {
        Drawable bitmapDrawable;
        AppMethodBeat.i(76281);
        Bundle bundle = this.mData.get(i2);
        String string = bundle.getString(DISPLAY_NAME);
        String string2 = bundle.getString("data");
        byte[] byteArray = bundle.getByteArray("photo");
        if (byteArray == null) {
            bitmapDrawable = this.mContext.getResources().getDrawable(SlookResourceManager.getDrawableId(1));
        } else {
            bitmapDrawable = new BitmapDrawable(this.mContext.getResources(), BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length));
        }
        SlookAirButtonAdapter.AirButtonItem airButtonItem = new SlookAirButtonAdapter.AirButtonItem(bitmapDrawable, string, string2, bundle);
        AppMethodBeat.o(76281);
        return airButtonItem;
    }

    private synchronized void updateData() {
        AppMethodBeat.i(76282);
        if (!this.mNeedUpdate || this.mIsShowing) {
            AppMethodBeat.o(76282);
        } else {
            this.mNeedUpdate = false;
            this.mData.clear();
            Cursor query = this.mContext.getContentResolver().query(Uri.parse(FREQUENT_URI), new String[]{"_id", DISPLAY_NAME, PHOTO_URI, "data15", "lookup", "mimetype", "data1", "is_private"}, this.mSelectionSb != null ? this.mSelectionSb.toString() : null, null, "_id LIMIT " + this.mMaxCount);
            if (query == null) {
                AppMethodBeat.o(76282);
            } else {
                while (query.moveToNext()) {
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putInt("id", query.getInt(0));
                        bundle.putString(DISPLAY_NAME, query.getString(1));
                        bundle.putString(PHOTO_URI, query.getString(2));
                        bundle.putByteArray("photo", query.getBlob(3));
                        bundle.putString(LOOKUP_KEY, query.getString(4));
                        bundle.putString(MIME_TYPE, query.getString(5));
                        bundle.putString("data", query.getString(6));
                        bundle.putBoolean("is_private", query.getInt(7) == 1);
                        this.mData.add(bundle);
                    } catch (Throwable th) {
                        if (query != null) {
                            query.close();
                        }
                        AppMethodBeat.o(76282);
                        throw th;
                    }
                }
                if (query != null) {
                    query.close();
                }
                try {
                    this.mCount = this.mData.size();
                    AppMethodBeat.o(76282);
                } catch (NoSuchMethodError e2) {
                    AppMethodBeat.o(76282);
                }
            }
        }
    }

    private boolean isSupport(int i2) {
        AppMethodBeat.i(76283);
        if (this.mSlook.isFeatureEnabled(1)) {
            AppMethodBeat.o(76283);
            return true;
        }
        AppMethodBeat.o(76283);
        return false;
    }
}
