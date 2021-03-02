package com.google.android.gms.common.images.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Path;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.google.android.gms.base.R;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.images.ImageRequest;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.util.PlatformVersion;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class LoadingImageView extends ImageView {
    public static final int ASPECT_RATIO_ADJUST_HEIGHT = 2;
    public static final int ASPECT_RATIO_ADJUST_NONE = 0;
    public static final int ASPECT_RATIO_ADJUST_WIDTH = 1;
    private static ImageManager zzqm;
    private ImageManager.OnImageLoadedListener mOnImageLoadedListener;
    private int mPostProcessingFlags;
    private boolean zzpl;
    private boolean zzpm;
    private Uri zzqn;
    private int zzqo;
    private boolean zzqp;
    private int zzqq;
    private ClipPathProvider zzqr;
    private int zzqs;
    private float zzqt;

    public interface ClipPathProvider {
        Path getClipPath(int i2, int i3);
    }

    public LoadingImageView(Context context) {
        this(context, null, 0);
    }

    public LoadingImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadingImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(11774);
        this.zzqo = 0;
        this.zzpl = true;
        this.zzpm = false;
        this.zzqp = false;
        this.zzqq = 0;
        this.mPostProcessingFlags = 0;
        this.zzqs = 0;
        this.zzqt = 1.0f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LoadingImageView);
        this.zzqs = obtainStyledAttributes.getInt(2, 0);
        this.zzqt = obtainStyledAttributes.getFloat(1, 1.0f);
        setCircleCropEnabled(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        AppMethodBeat.o(11774);
    }

    private final void zzc(boolean z) {
        AppMethodBeat.i(11787);
        if (this.mOnImageLoadedListener != null) {
            this.mOnImageLoadedListener.onImageLoaded(this.zzqn, null, z);
        }
        AppMethodBeat.o(11787);
    }

    public final void clearAspectRatioAdjust() {
        AppMethodBeat.i(11784);
        if (this.zzqs != 0) {
            this.zzqs = 0;
            requestLayout();
        }
        AppMethodBeat.o(11784);
    }

    public final void clearImage() {
        AppMethodBeat.i(11775);
        loadUri(null);
        this.zzqp = true;
        AppMethodBeat.o(11775);
    }

    public final int getLoadedNoDataPlaceholderResId() {
        return this.zzqo;
    }

    public final Uri getLoadedUri() {
        return this.zzqn;
    }

    public final void loadUri(Uri uri) {
        AppMethodBeat.i(11776);
        loadUri(uri, 0, true, false);
        AppMethodBeat.o(11776);
    }

    public final void loadUri(Uri uri, int i2) {
        AppMethodBeat.i(11777);
        loadUri(uri, i2, true, false);
        AppMethodBeat.o(11777);
    }

    public final void loadUri(Uri uri, int i2, boolean z) {
        AppMethodBeat.i(11778);
        loadUri(uri, i2, z, false);
        AppMethodBeat.o(11778);
    }

    public final void loadUri(Uri uri, int i2, boolean z, boolean z2) {
        boolean z3 = true;
        AppMethodBeat.i(11779);
        if (uri != null ? uri.equals(this.zzqn) : this.zzqn == null) {
            if (this.zzqn != null) {
                zzc(true);
                AppMethodBeat.o(11779);
                return;
            } else if (this.zzqo == i2) {
                zzc(false);
                AppMethodBeat.o(11779);
                return;
            }
        }
        if (zzqm == null) {
            zzqm = ImageManager.create(getContext(), getContext().getApplicationContext().getPackageName().equals(GooglePlayServicesUtilLight.GOOGLE_PLAY_GAMES_PACKAGE));
        }
        if (!this.zzpm && !this.zzqp) {
            z3 = false;
        }
        this.zzqp = false;
        ImageRequest.ImageViewImageRequest imageViewImageRequest = new ImageRequest.ImageViewImageRequest(this, uri);
        imageViewImageRequest.setNoDataPlaceholder(i2);
        imageViewImageRequest.setCrossFadeEnabled(this.zzpl);
        imageViewImageRequest.setCrossFadeAlwaysEnabled(z3);
        imageViewImageRequest.setLoadingPlaceholderEnabled(z);
        imageViewImageRequest.setPostProcessingFlags(this.mPostProcessingFlags);
        imageViewImageRequest.setOnImageLoadedListener(this.mOnImageLoadedListener);
        imageViewImageRequest.setUseNewDrawable(z2);
        zzqm.loadImage(imageViewImageRequest);
        AppMethodBeat.o(11779);
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        AppMethodBeat.i(11786);
        if (this.zzqr != null) {
            canvas.clipPath(this.zzqr.getClipPath(getWidth(), getHeight()));
        }
        super.onDraw(canvas);
        if (this.zzqq != 0) {
            canvas.drawColor(this.zzqq);
        }
        AppMethodBeat.o(11786);
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        int measuredWidth;
        int i4;
        AppMethodBeat.i(11785);
        super.onMeasure(i2, i3);
        switch (this.zzqs) {
            case 1:
                i4 = getMeasuredHeight();
                measuredWidth = (int) (((float) i4) * this.zzqt);
                break;
            case 2:
                measuredWidth = getMeasuredWidth();
                i4 = (int) (((float) measuredWidth) / this.zzqt);
                break;
            default:
                AppMethodBeat.o(11785);
                return;
        }
        setMeasuredDimension(measuredWidth, i4);
        AppMethodBeat.o(11785);
    }

    public final void setCircleCropEnabled(boolean z) {
        if (z) {
            this.mPostProcessingFlags |= 1;
        } else {
            this.mPostProcessingFlags &= -2;
        }
    }

    public final void setClipPathProvider(ClipPathProvider clipPathProvider) {
        AppMethodBeat.i(11782);
        this.zzqr = clipPathProvider;
        if (!PlatformVersion.isAtLeastJellyBean()) {
            setLayerType(1, null);
        }
        AppMethodBeat.o(11782);
    }

    public final void setCrossFadeAlwaysEnabled(boolean z) {
        this.zzpm = z;
    }

    public final void setCrossFadeEnabled(boolean z) {
        this.zzpl = z;
    }

    public final void setImageAspectRatioAdjust(int i2, float f2) {
        boolean z = true;
        AppMethodBeat.i(11783);
        Asserts.checkState(i2 == 0 || i2 == 1 || i2 == 2);
        if (f2 <= 0.0f) {
            z = false;
        }
        Asserts.checkState(z);
        this.zzqs = i2;
        this.zzqt = f2;
        requestLayout();
        AppMethodBeat.o(11783);
    }

    public final void setLoadedNoDataPlaceholderResId(int i2) {
        this.zzqo = i2;
    }

    public final void setLoadedUri(Uri uri) {
        this.zzqn = uri;
    }

    public final void setOnImageLoadedListener(ImageManager.OnImageLoadedListener onImageLoadedListener) {
        this.mOnImageLoadedListener = onImageLoadedListener;
    }

    public final void setTintColor(int i2) {
        AppMethodBeat.i(11781);
        this.zzqq = i2;
        if (this.zzqq != 0) {
            setColorFilter(ColorFilters.COLOR_FILTER_BW);
        } else {
            setColorFilter((ColorFilter) null);
        }
        invalidate();
        AppMethodBeat.o(11781);
    }

    public final void setTintColorId(int i2) {
        Resources resources;
        AppMethodBeat.i(11780);
        int i3 = 0;
        if (i2 > 0 && (resources = getResources()) != null) {
            i3 = resources.getColor(i2);
        }
        setTintColor(i3);
        AppMethodBeat.o(11780);
    }
}
