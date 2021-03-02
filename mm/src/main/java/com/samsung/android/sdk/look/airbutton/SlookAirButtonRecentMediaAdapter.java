package com.samsung.android.sdk.look.airbutton;

import android.content.ContentUris;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import com.samsung.android.sdk.look.Slook;
import com.samsung.android.sdk.look.SlookResourceManager;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class SlookAirButtonRecentMediaAdapter extends SlookAirButtonAdapter {
    public static final String AUDIO_TYPE = "audio";
    private static final String ID = "id";
    public static final String IMAGE_TYPE = "image";
    private static final String MIME_TYPE = "mime_type";
    private static final String ORIENTATION = "orientation";
    private static final String TAG = "AirButtonRecentMediaAdapter";
    private static final String TITLE = "title";
    public static final String VIDEO_TYPE = "video";
    private static final String VOLUME = "external";
    private boolean DEBUG = false;
    private Context mContext;
    private int mCount = 0;
    private ArrayList<Bundle> mData = new ArrayList<>();
    private String mFilter;
    private boolean mIsShowing = false;
    private int mMaxCount = 15;
    private boolean mNeedUpdate = true;
    private Slook mSlook = new Slook();

    public SlookAirButtonRecentMediaAdapter(View view, Bundle bundle) {
        AppMethodBeat.i(76263);
        if (view == null && bundle == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("You should set the View and Bundle in Param");
            AppMethodBeat.o(76263);
            throw illegalArgumentException;
        } else if (!isSupport(1)) {
            AppMethodBeat.o(76263);
        } else {
            this.mFilter = getFilter(bundle);
            if (view != null) {
                this.mContext = view.getContext();
                this.DEBUG = true;
                this.mMaxCount = SlookResourceManager.getInt(3);
                setEmptyText(SlookResourceManager.getText(this.mContext, 1));
            }
            AppMethodBeat.o(76263);
        }
    }

    @Override // com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter
    public final SlookAirButtonAdapter.AirButtonItem getItem(int i2) {
        AppMethodBeat.i(76264);
        Bundle bundle = this.mData.get(i2);
        int i3 = bundle.getInt("id");
        int i4 = bundle.getInt(MIME_TYPE);
        SlookAirButtonAdapter.AirButtonItem airButtonItem = new SlookAirButtonAdapter.AirButtonItem(getThumbNail(i3, i4, bundle.getString("title"), bundle.getInt(ORIENTATION)), null, getUri(i3, i4));
        AppMethodBeat.o(76264);
        return airButtonItem;
    }

    @Override // com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter
    public final int getCount() {
        return this.mCount;
    }

    private Drawable getThumbNail(int i2, int i3, String str, int i4) {
        BitmapDrawable bitmapDrawable;
        AppMethodBeat.i(76265);
        switch (i3) {
            case 1:
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 2;
                Bitmap thumbnail = MediaStore.Images.Thumbnails.getThumbnail(this.mContext.getContentResolver(), (long) i2, 1, options);
                if (thumbnail == null) {
                    bitmapDrawable = null;
                } else if (i4 == 90 || i4 == 180 || i4 == 270) {
                    Matrix matrix = new Matrix();
                    matrix.postRotate((float) i4);
                    bitmapDrawable = new BitmapDrawable(this.mContext.getResources(), Bitmap.createBitmap(thumbnail, 0, 0, thumbnail.getWidth(), thumbnail.getHeight(), matrix, true));
                } else {
                    bitmapDrawable = new BitmapDrawable(this.mContext.getResources(), thumbnail);
                }
                AppMethodBeat.o(76265);
                return bitmapDrawable;
            case 2:
                Drawable audioDrawable = getAudioDrawable(str);
                AppMethodBeat.o(76265);
                return audioDrawable;
            case 3:
                BitmapDrawable bitmapDrawable2 = new BitmapDrawable(this.mContext.getResources(), MediaStore.Video.Thumbnails.getThumbnail(this.mContext.getContentResolver(), (long) i2, 3, null));
                AppMethodBeat.o(76265);
                return bitmapDrawable2;
            default:
                AppMethodBeat.o(76265);
                return null;
        }
    }

    private Drawable getAudioDrawable(String str) {
        AppMethodBeat.i(76266);
        Bitmap createBitmap = Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Drawable drawable = this.mContext.getResources().getDrawable(SlookResourceManager.getDrawableId(2));
        drawable.setBounds(new Rect(0, 0, 200, 200));
        canvas.drawColor(-2236963, PorterDuff.Mode.SRC);
        drawable.draw(canvas);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(this.mContext.getResources(), createBitmap);
        AppMethodBeat.o(76266);
        return bitmapDrawable;
    }

    private Uri getUri(int i2, int i3) {
        AppMethodBeat.i(76267);
        switch (i3) {
            case 1:
                Uri withAppendedId = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, (long) i2);
                AppMethodBeat.o(76267);
                return withAppendedId;
            case 2:
                Uri withAppendedId2 = ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, (long) i2);
                AppMethodBeat.o(76267);
                return withAppendedId2;
            case 3:
                Uri withAppendedId3 = ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, (long) i2);
                AppMethodBeat.o(76267);
                return withAppendedId3;
            default:
                AppMethodBeat.o(76267);
                return null;
        }
    }

    private String getFilter(Bundle bundle) {
        AppMethodBeat.i(76268);
        boolean z = false;
        StringBuilder sb = new StringBuilder();
        if (bundle == null || bundle.getBoolean("image")) {
            sb.append("media_type = ");
            sb.append(1);
            z = true;
        }
        if (bundle == null || bundle.getBoolean("video")) {
            if (z) {
                sb.append(" or ");
            }
            sb.append("media_type = ");
            sb.append(3);
            z = true;
        }
        if (bundle == null || bundle.getBoolean(AUDIO_TYPE)) {
            if (z) {
                sb.append(" or ");
            }
            sb.append("media_type = ");
            sb.append(2);
        }
        String sb2 = sb.toString();
        if (sb2 == null || sb2.length() <= 0) {
            AppMethodBeat.o(76268);
            return null;
        }
        AppMethodBeat.o(76268);
        return sb2;
    }

    @Override // com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter
    public final void onShow(View view) {
        AppMethodBeat.i(76269);
        updateData();
        this.mIsShowing = true;
        super.onShow(view);
        AppMethodBeat.o(76269);
    }

    @Override // com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter
    public final void onHide(View view) {
        AppMethodBeat.i(76270);
        this.mIsShowing = false;
        this.mNeedUpdate = true;
        this.mData.clear();
        super.onHide(view);
        AppMethodBeat.o(76270);
    }

    @Override // com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter
    public final void onDismiss(View view) {
        AppMethodBeat.i(76271);
        this.mIsShowing = false;
        this.mNeedUpdate = true;
        this.mData.clear();
        super.onDismiss(view);
        AppMethodBeat.o(76271);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void updateData() {
        /*
        // Method dump skipped, instructions count: 201
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter.updateData():void");
    }

    private boolean isSupport(int i2) {
        AppMethodBeat.i(76273);
        if (this.mSlook.isFeatureEnabled(1)) {
            AppMethodBeat.o(76273);
            return true;
        }
        AppMethodBeat.o(76273);
        return false;
    }
}
