package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.images.internal.CrossFadingDrawable;
import com.google.android.gms.common.images.internal.ImageUtils;
import com.google.android.gms.common.images.internal.PostProcessedResourceCache;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.util.PlatformVersion;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public abstract class ImageRequest {
    protected int mLoadingPlaceholderResId = 0;
    protected int mNoDataPlaceholderResId = 0;
    protected ImageManager.OnImageLoadedListener mOnImageLoadedListener;
    protected int mPostProcessingFlags;
    protected boolean mUseNewDrawable = false;
    final zza zzpk;
    private boolean zzpl = true;
    private boolean zzpm = false;
    private boolean zzpn = true;

    public static final class ImageViewImageRequest extends ImageRequest {
        private WeakReference<ImageView> zzpo;

        public ImageViewImageRequest(ImageView imageView, int i2) {
            super(null, i2);
            AppMethodBeat.i(11721);
            Asserts.checkNotNull(imageView);
            this.zzpo = new WeakReference<>(imageView);
            AppMethodBeat.o(11721);
        }

        public ImageViewImageRequest(ImageView imageView, Uri uri) {
            super(uri, 0);
            AppMethodBeat.i(11720);
            Asserts.checkNotNull(imageView);
            this.zzpo = new WeakReference<>(imageView);
            AppMethodBeat.o(11720);
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(11722);
            if (!(obj instanceof ImageViewImageRequest)) {
                AppMethodBeat.o(11722);
                return false;
            } else if (this == obj) {
                AppMethodBeat.o(11722);
                return true;
            } else {
                ImageView imageView = this.zzpo.get();
                ImageView imageView2 = ((ImageViewImageRequest) obj).zzpo.get();
                if (imageView2 == null || imageView == null || !Objects.equal(imageView2, imageView)) {
                    AppMethodBeat.o(11722);
                    return false;
                }
                AppMethodBeat.o(11722);
                return true;
            }
        }

        public final int hashCode() {
            return 0;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0029, code lost:
            if (r1 == r7.mNoDataPlaceholderResId) goto L_0x006b;
         */
        @Override // com.google.android.gms.common.images.ImageRequest
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void loadImage(android.graphics.drawable.Drawable r8, boolean r9, boolean r10, boolean r11) {
            /*
            // Method dump skipped, instructions count: 119
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.images.ImageRequest.ImageViewImageRequest.loadImage(android.graphics.drawable.Drawable, boolean, boolean, boolean):void");
        }
    }

    public static final class ListenerImageRequest extends ImageRequest {
        private WeakReference<ImageManager.OnImageLoadedListener> zzpp;

        public ListenerImageRequest(ImageManager.OnImageLoadedListener onImageLoadedListener, Uri uri) {
            super(uri, 0);
            AppMethodBeat.i(11724);
            Asserts.checkNotNull(onImageLoadedListener);
            this.zzpp = new WeakReference<>(onImageLoadedListener);
            AppMethodBeat.o(11724);
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(11726);
            if (!(obj instanceof ListenerImageRequest)) {
                AppMethodBeat.o(11726);
                return false;
            } else if (this == obj) {
                AppMethodBeat.o(11726);
                return true;
            } else {
                ListenerImageRequest listenerImageRequest = (ListenerImageRequest) obj;
                ImageManager.OnImageLoadedListener onImageLoadedListener = this.zzpp.get();
                ImageManager.OnImageLoadedListener onImageLoadedListener2 = listenerImageRequest.zzpp.get();
                if (onImageLoadedListener2 == null || onImageLoadedListener == null || !Objects.equal(onImageLoadedListener2, onImageLoadedListener) || !Objects.equal(listenerImageRequest.zzpk, this.zzpk)) {
                    AppMethodBeat.o(11726);
                    return false;
                }
                AppMethodBeat.o(11726);
                return true;
            }
        }

        public final int hashCode() {
            AppMethodBeat.i(11725);
            int hashCode = Objects.hashCode(this.zzpk);
            AppMethodBeat.o(11725);
            return hashCode;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.common.images.ImageRequest
        public final void loadImage(Drawable drawable, boolean z, boolean z2, boolean z3) {
            ImageManager.OnImageLoadedListener onImageLoadedListener;
            AppMethodBeat.i(11727);
            if (!z2 && (onImageLoadedListener = this.zzpp.get()) != null) {
                onImageLoadedListener.onImageLoaded(this.zzpk.uri, drawable, z3);
            }
            AppMethodBeat.o(11727);
        }
    }

    public static final class PostProcessingFlags {
        public static final int CIRCLE_CROP = 1;
    }

    public static final class TextViewImageRequest extends ImageRequest {
        public static final int POSITION_BOTTOM = 3;
        public static final int POSITION_END = 2;
        public static final int POSITION_START = 0;
        public static final int POSITION_TOP = 1;
        private WeakReference<TextView> zzpq;
        private int zzpr = -1;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TextViewImageRequest(TextView textView, int i2, int i3) {
            super(null, i3);
            boolean z = true;
            AppMethodBeat.i(11729);
            Asserts.checkNotNull(textView);
            Asserts.checkState((i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3) ? false : z, new StringBuilder(29).append("Invalid position: ").append(i2).toString());
            this.zzpq = new WeakReference<>(textView);
            this.zzpr = i2;
            AppMethodBeat.o(11729);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TextViewImageRequest(TextView textView, int i2, Uri uri) {
            super(uri, 0);
            boolean z = true;
            AppMethodBeat.i(11728);
            Asserts.checkNotNull(textView);
            Asserts.checkState((i2 == 0 || i2 == 1 || i2 == 2 || i2 == 3) ? false : z, new StringBuilder(29).append("Invalid position: ").append(i2).toString());
            this.zzpq = new WeakReference<>(textView);
            this.zzpr = i2;
            AppMethodBeat.o(11728);
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(11731);
            if (!(obj instanceof TextViewImageRequest)) {
                AppMethodBeat.o(11731);
                return false;
            } else if (this == obj) {
                AppMethodBeat.o(11731);
                return true;
            } else {
                TextViewImageRequest textViewImageRequest = (TextViewImageRequest) obj;
                TextView textView = this.zzpq.get();
                TextView textView2 = textViewImageRequest.zzpq.get();
                if (textView2 == null || textView == null || !Objects.equal(textView2, textView) || !Objects.equal(Integer.valueOf(textViewImageRequest.zzpr), Integer.valueOf(this.zzpr))) {
                    AppMethodBeat.o(11731);
                    return false;
                }
                AppMethodBeat.o(11731);
                return true;
            }
        }

        public final int hashCode() {
            AppMethodBeat.i(11730);
            int hashCode = Objects.hashCode(Integer.valueOf(this.zzpr));
            AppMethodBeat.o(11730);
            return hashCode;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.common.images.ImageRequest
        public final void loadImage(Drawable drawable, boolean z, boolean z2, boolean z3) {
            AppMethodBeat.i(11732);
            TextView textView = this.zzpq.get();
            if (textView != null) {
                int i2 = this.zzpr;
                boolean shouldCrossFade = shouldCrossFade(z, z2);
                Drawable[] compoundDrawablesRelative = PlatformVersion.isAtLeastJellyBeanMR1() ? textView.getCompoundDrawablesRelative() : textView.getCompoundDrawables();
                Drawable createTransitionDrawable = shouldCrossFade ? createTransitionDrawable(compoundDrawablesRelative[i2], drawable) : drawable;
                Drawable drawable2 = i2 == 0 ? createTransitionDrawable : compoundDrawablesRelative[0];
                Drawable drawable3 = i2 == 1 ? createTransitionDrawable : compoundDrawablesRelative[1];
                Drawable drawable4 = i2 == 2 ? createTransitionDrawable : compoundDrawablesRelative[2];
                Drawable drawable5 = i2 == 3 ? createTransitionDrawable : compoundDrawablesRelative[3];
                if (PlatformVersion.isAtLeastJellyBeanMR1()) {
                    textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable2, drawable3, drawable4, drawable5);
                } else {
                    textView.setCompoundDrawablesWithIntrinsicBounds(drawable2, drawable3, drawable4, drawable5);
                }
                if (shouldCrossFade) {
                    ((CrossFadingDrawable) createTransitionDrawable).startTransition(250);
                }
            }
            AppMethodBeat.o(11732);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class zza {
        public final Uri uri;

        public zza(Uri uri2) {
            this.uri = uri2;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(11734);
            if (!(obj instanceof zza)) {
                AppMethodBeat.o(11734);
                return false;
            } else if (this == obj) {
                AppMethodBeat.o(11734);
                return true;
            } else {
                boolean equal = Objects.equal(((zza) obj).uri, this.uri);
                AppMethodBeat.o(11734);
                return equal;
            }
        }

        public final int hashCode() {
            AppMethodBeat.i(11733);
            int hashCode = Objects.hashCode(this.uri);
            AppMethodBeat.o(11733);
            return hashCode;
        }
    }

    public ImageRequest(Uri uri, int i2) {
        this.zzpk = new zza(uri);
        this.mNoDataPlaceholderResId = i2;
    }

    private final Drawable zza(Context context, PostProcessedResourceCache postProcessedResourceCache, int i2) {
        Resources resources = context.getResources();
        if (this.mPostProcessingFlags <= 0) {
            return resources.getDrawable(i2);
        }
        PostProcessedResourceCache.PostProcessedResource postProcessedResource = new PostProcessedResourceCache.PostProcessedResource(i2, this.mPostProcessingFlags);
        Drawable drawable = (Drawable) postProcessedResourceCache.get(postProcessedResource);
        if (drawable != null) {
            return drawable;
        }
        Drawable drawable2 = resources.getDrawable(i2);
        if ((this.mPostProcessingFlags & 1) != 0) {
            drawable2 = frameDrawableInCircle(resources, drawable2);
        }
        postProcessedResourceCache.put(postProcessedResource, drawable2);
        return drawable2;
    }

    /* access modifiers changed from: protected */
    public CrossFadingDrawable createTransitionDrawable(Drawable drawable, Drawable drawable2) {
        if (drawable == null) {
            drawable = null;
        } else if (drawable instanceof CrossFadingDrawable) {
            drawable = ((CrossFadingDrawable) drawable).getEndDrawable();
        }
        return new CrossFadingDrawable(drawable, drawable2);
    }

    /* access modifiers changed from: protected */
    public Drawable frameDrawableInCircle(Resources resources, Drawable drawable) {
        return ImageUtils.frameDrawableInCircle(resources, drawable);
    }

    /* access modifiers changed from: protected */
    public abstract void loadImage(Drawable drawable, boolean z, boolean z2, boolean z3);

    public void setCrossFadeAlwaysEnabled(boolean z) {
        this.zzpm = z;
        if (z) {
            setCrossFadeEnabled(true);
        }
    }

    public void setCrossFadeEnabled(boolean z) {
        this.zzpl = z;
    }

    public void setLoadingPlaceholder(int i2) {
        this.mLoadingPlaceholderResId = i2;
    }

    public void setLoadingPlaceholderEnabled(boolean z) {
        this.zzpn = z;
    }

    public void setNoDataPlaceholder(int i2) {
        this.mNoDataPlaceholderResId = i2;
    }

    public void setOnImageLoadedListener(ImageManager.OnImageLoadedListener onImageLoadedListener) {
        this.mOnImageLoadedListener = onImageLoadedListener;
    }

    public void setPostProcessingFlags(int i2) {
        this.mPostProcessingFlags = i2;
    }

    public void setUseNewDrawable(boolean z) {
        this.mUseNewDrawable = z;
    }

    /* access modifiers changed from: protected */
    public boolean shouldCrossFade(boolean z, boolean z2) {
        return this.zzpl && !z2 && (!z || this.zzpm);
    }

    /* access modifiers changed from: package-private */
    public final void zza(Context context, Bitmap bitmap, boolean z) {
        Asserts.checkNotNull(bitmap);
        if ((this.mPostProcessingFlags & 1) != 0) {
            bitmap = ImageUtils.frameBitmapInCircle(bitmap);
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
        if (this.mOnImageLoadedListener != null) {
            this.mOnImageLoadedListener.onImageLoaded(this.zzpk.uri, bitmapDrawable, true);
        }
        loadImage(bitmapDrawable, z, false, true);
    }

    /* access modifiers changed from: package-private */
    public final void zza(Context context, PostProcessedResourceCache postProcessedResourceCache) {
        if (this.zzpn) {
            Drawable drawable = null;
            if (this.mLoadingPlaceholderResId != 0) {
                drawable = zza(context, postProcessedResourceCache, this.mLoadingPlaceholderResId);
            }
            loadImage(drawable, false, true, false);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(Context context, PostProcessedResourceCache postProcessedResourceCache, boolean z) {
        Drawable drawable = null;
        if (this.mNoDataPlaceholderResId != 0) {
            drawable = zza(context, postProcessedResourceCache, this.mNoDataPlaceholderResId);
        }
        if (this.mOnImageLoadedListener != null) {
            this.mOnImageLoadedListener.onImageLoaded(this.zzpk.uri, drawable, false);
        }
        loadImage(drawable, z, false, false);
    }
}
