package com.facebook.login.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.FacebookException;
import com.facebook.LoggingBehavior;
import com.facebook.internal.ImageDownloader;
import com.facebook.internal.ImageRequest;
import com.facebook.internal.ImageResponse;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.login.R;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ProfilePictureView extends FrameLayout {
    private static final String BITMAP_HEIGHT_KEY = "ProfilePictureView_height";
    private static final String BITMAP_KEY = "ProfilePictureView_bitmap";
    private static final String BITMAP_WIDTH_KEY = "ProfilePictureView_width";
    public static final int CUSTOM = -1;
    private static final boolean IS_CROPPED_DEFAULT_VALUE = true;
    private static final String IS_CROPPED_KEY = "ProfilePictureView_isCropped";
    public static final int LARGE = -4;
    private static final int MIN_SIZE = 1;
    public static final int NORMAL = -3;
    private static final String PENDING_REFRESH_KEY = "ProfilePictureView_refresh";
    private static final String PRESET_SIZE_KEY = "ProfilePictureView_presetSize";
    private static final String PROFILE_ID_KEY = "ProfilePictureView_profileId";
    public static final int SMALL = -2;
    private static final String SUPER_STATE_KEY = "ProfilePictureView_superState";
    public static final String TAG = ProfilePictureView.class.getSimpleName();
    private Bitmap customizedDefaultProfilePicture = null;
    private ImageView image;
    private Bitmap imageContents;
    private boolean isCropped = true;
    private ImageRequest lastRequest;
    private OnErrorListener onErrorListener;
    private int presetSizeType = -1;
    private String profileId;
    private int queryHeight = 0;
    private int queryWidth = 0;

    public interface OnErrorListener {
        void onError(FacebookException facebookException);
    }

    static /* synthetic */ void access$000(ProfilePictureView profilePictureView, ImageResponse imageResponse) {
        AppMethodBeat.i(40476);
        profilePictureView.processResponse(imageResponse);
        AppMethodBeat.o(40476);
    }

    static {
        AppMethodBeat.i(40477);
        AppMethodBeat.o(40477);
    }

    public ProfilePictureView(Context context) {
        super(context);
        AppMethodBeat.i(40456);
        initialize(context);
        AppMethodBeat.o(40456);
    }

    public ProfilePictureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(40457);
        initialize(context);
        parseAttributes(attributeSet);
        AppMethodBeat.o(40457);
    }

    public ProfilePictureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(40458);
        initialize(context);
        parseAttributes(attributeSet);
        AppMethodBeat.o(40458);
    }

    public final int getPresetSize() {
        return this.presetSizeType;
    }

    public final void setPresetSize(int i2) {
        AppMethodBeat.i(40459);
        switch (i2) {
            case -4:
            case -3:
            case -2:
            case -1:
                this.presetSizeType = i2;
                requestLayout();
                AppMethodBeat.o(40459);
                return;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Must use a predefined preset size");
                AppMethodBeat.o(40459);
                throw illegalArgumentException;
        }
    }

    public final boolean isCropped() {
        return this.isCropped;
    }

    public final void setCropped(boolean z) {
        AppMethodBeat.i(40460);
        this.isCropped = z;
        refreshImage(false);
        AppMethodBeat.o(40460);
    }

    public final String getProfileId() {
        return this.profileId;
    }

    public final void setProfileId(String str) {
        AppMethodBeat.i(40461);
        boolean z = false;
        if (Utility.isNullOrEmpty(this.profileId) || !this.profileId.equalsIgnoreCase(str)) {
            setBlankProfilePicture();
            z = true;
        }
        this.profileId = str;
        refreshImage(z);
        AppMethodBeat.o(40461);
    }

    public final OnErrorListener getOnErrorListener() {
        return this.onErrorListener;
    }

    public final void setOnErrorListener(OnErrorListener onErrorListener2) {
        this.onErrorListener = onErrorListener2;
    }

    public final void setDefaultProfilePicture(Bitmap bitmap) {
        this.customizedDefaultProfilePicture = bitmap;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        boolean z = true;
        AppMethodBeat.i(40462);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        boolean z2 = false;
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i2);
        if (View.MeasureSpec.getMode(i3) != 1073741824 && layoutParams.height == -2) {
            size = getPresetSizeInPixels(true);
            i3 = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
            z2 = true;
        }
        if (View.MeasureSpec.getMode(i2) == 1073741824 || layoutParams.width != -2) {
            z = z2;
        } else {
            int presetSizeInPixels = getPresetSizeInPixels(true);
            i2 = View.MeasureSpec.makeMeasureSpec(presetSizeInPixels, 1073741824);
            size2 = presetSizeInPixels;
        }
        if (z) {
            setMeasuredDimension(size2, size);
            measureChildren(i2, i3);
            AppMethodBeat.o(40462);
            return;
        }
        super.onMeasure(i2, i3);
        AppMethodBeat.o(40462);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(40463);
        super.onLayout(z, i2, i3, i4, i5);
        refreshImage(false);
        AppMethodBeat.o(40463);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        AppMethodBeat.i(40464);
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable(SUPER_STATE_KEY, onSaveInstanceState);
        bundle.putString(PROFILE_ID_KEY, this.profileId);
        bundle.putInt(PRESET_SIZE_KEY, this.presetSizeType);
        bundle.putBoolean(IS_CROPPED_KEY, this.isCropped);
        bundle.putInt(BITMAP_WIDTH_KEY, this.queryWidth);
        bundle.putInt(BITMAP_HEIGHT_KEY, this.queryHeight);
        bundle.putBoolean(PENDING_REFRESH_KEY, this.lastRequest != null);
        AppMethodBeat.o(40464);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        AppMethodBeat.i(40465);
        if (parcelable.getClass() != Bundle.class) {
            super.onRestoreInstanceState(parcelable);
            AppMethodBeat.o(40465);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable(SUPER_STATE_KEY));
        this.profileId = bundle.getString(PROFILE_ID_KEY);
        this.presetSizeType = bundle.getInt(PRESET_SIZE_KEY);
        this.isCropped = bundle.getBoolean(IS_CROPPED_KEY);
        this.queryWidth = bundle.getInt(BITMAP_WIDTH_KEY);
        this.queryHeight = bundle.getInt(BITMAP_HEIGHT_KEY);
        refreshImage(true);
        AppMethodBeat.o(40465);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(40466);
        super.onDetachedFromWindow();
        this.lastRequest = null;
        AppMethodBeat.o(40466);
    }

    private void initialize(Context context) {
        AppMethodBeat.i(40467);
        removeAllViews();
        this.image = new ImageView(context);
        this.image.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.image.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        addView(this.image);
        AppMethodBeat.o(40467);
    }

    private void parseAttributes(AttributeSet attributeSet) {
        AppMethodBeat.i(40468);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.com_facebook_profile_picture_view);
        setPresetSize(obtainStyledAttributes.getInt(1, -1));
        this.isCropped = obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
        AppMethodBeat.o(40468);
    }

    private void refreshImage(boolean z) {
        AppMethodBeat.i(40469);
        boolean updateImageQueryParameters = updateImageQueryParameters();
        if (this.profileId == null || this.profileId.length() == 0 || (this.queryWidth == 0 && this.queryHeight == 0)) {
            setBlankProfilePicture();
            AppMethodBeat.o(40469);
            return;
        }
        if (updateImageQueryParameters || z) {
            sendImageRequest(true);
        }
        AppMethodBeat.o(40469);
    }

    private void setBlankProfilePicture() {
        AppMethodBeat.i(40470);
        if (this.lastRequest != null) {
            ImageDownloader.cancelRequest(this.lastRequest);
        }
        if (this.customizedDefaultProfilePicture == null) {
            setImageBitmap(BitmapFactory.decodeResource(getResources(), isCropped() ? com.tencent.mm.R.drawable.b8m : com.tencent.mm.R.drawable.b8l));
            AppMethodBeat.o(40470);
            return;
        }
        updateImageQueryParameters();
        setImageBitmap(Bitmap.createScaledBitmap(this.customizedDefaultProfilePicture, this.queryWidth, this.queryHeight, false));
        AppMethodBeat.o(40470);
    }

    private void setImageBitmap(Bitmap bitmap) {
        AppMethodBeat.i(40471);
        if (!(this.image == null || bitmap == null)) {
            this.imageContents = bitmap;
            this.image.setImageBitmap(bitmap);
        }
        AppMethodBeat.o(40471);
    }

    private void sendImageRequest(boolean z) {
        AppMethodBeat.i(40472);
        ImageRequest build = new ImageRequest.Builder(getContext(), ImageRequest.getProfilePictureUri(this.profileId, this.queryWidth, this.queryHeight)).setAllowCachedRedirects(z).setCallerTag(this).setCallback(new ImageRequest.Callback() {
            /* class com.facebook.login.widget.ProfilePictureView.AnonymousClass1 */

            @Override // com.facebook.internal.ImageRequest.Callback
            public void onCompleted(ImageResponse imageResponse) {
                AppMethodBeat.i(40455);
                ProfilePictureView.access$000(ProfilePictureView.this, imageResponse);
                AppMethodBeat.o(40455);
            }
        }).build();
        if (this.lastRequest != null) {
            ImageDownloader.cancelRequest(this.lastRequest);
        }
        this.lastRequest = build;
        ImageDownloader.downloadAsync(build);
        AppMethodBeat.o(40472);
    }

    private void processResponse(ImageResponse imageResponse) {
        AppMethodBeat.i(40473);
        if (imageResponse.getRequest() == this.lastRequest) {
            this.lastRequest = null;
            Bitmap bitmap = imageResponse.getBitmap();
            Exception error = imageResponse.getError();
            if (error != null) {
                OnErrorListener onErrorListener2 = this.onErrorListener;
                if (onErrorListener2 != null) {
                    onErrorListener2.onError(new FacebookException("Error in downloading profile picture for profileId: " + getProfileId(), error));
                    AppMethodBeat.o(40473);
                    return;
                }
                Logger.log(LoggingBehavior.REQUESTS, 6, TAG, error.toString());
                AppMethodBeat.o(40473);
                return;
            } else if (bitmap != null) {
                setImageBitmap(bitmap);
                if (imageResponse.isCachedRedirect()) {
                    sendImageRequest(false);
                }
            }
        }
        AppMethodBeat.o(40473);
    }

    private boolean updateImageQueryParameters() {
        boolean z = false;
        AppMethodBeat.i(40474);
        int height = getHeight();
        int width = getWidth();
        if (width <= 0 || height <= 0) {
            AppMethodBeat.o(40474);
        } else {
            int presetSizeInPixels = getPresetSizeInPixels(false);
            if (presetSizeInPixels != 0) {
                width = presetSizeInPixels;
                height = presetSizeInPixels;
            }
            if (width <= height) {
                height = isCropped() ? width : 0;
            } else {
                width = isCropped() ? height : 0;
            }
            if (!(width == this.queryWidth && height == this.queryHeight)) {
                z = true;
            }
            this.queryWidth = width;
            this.queryHeight = height;
            AppMethodBeat.o(40474);
        }
        return z;
    }

    private int getPresetSizeInPixels(boolean z) {
        int i2 = com.tencent.mm.R.dimen.y0;
        AppMethodBeat.i(40475);
        switch (this.presetSizeType) {
            case -4:
                i2 = com.tencent.mm.R.dimen.xz;
                break;
            case -3:
                break;
            case -2:
                i2 = com.tencent.mm.R.dimen.y1;
                break;
            case -1:
                if (!z) {
                    AppMethodBeat.o(40475);
                    return 0;
                }
                break;
            default:
                AppMethodBeat.o(40475);
                return 0;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(i2);
        AppMethodBeat.o(40475);
        return dimensionPixelSize;
    }
}
