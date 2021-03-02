package com.tencent.mm.loader;

import android.widget.ImageView;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.loader.f.d;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000l\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\u000f\u0010\u0006\u001a\u0004\u0018\u00018\u0001H&¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u0005H&J\u001c\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u000f\u001a\u00020\u0010H&J\u001c\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0012\u001a\u00020\u0013H&J\u001c\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u000f\u001a\u00020\u0010H&J\u001c\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0012\u001a\u00020\u0013H&J\u001c\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0017\u001a\u00020\u0018H&J\u001c\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001a\u001a\u00020\u001bH&J\"\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH&J\u001e\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\b\u0010 \u001a\u0004\u0018\u00010!H&J(\u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010$H&J\u001c\u0010%\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010&\u001a\u00020'H&J\u001c\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010)\u001a\u00020*H&J'\u0010+\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000\"\u0004\b\u0002\u0010,2\u0006\u0010\t\u001a\u0002H,H&¢\u0006\u0002\u0010-¨\u0006."}, hxF = {"Lcom/tencent/mm/loader/IRequestBuilder;", "T", "R", "", "download", "", "fromCache", "()Ljava/lang/Object;", "into", "imageView", "Landroid/widget/ImageView;", "needDefault", "", "load", "setDefaultBackgroundDrawable", "_drawable", "Landroid/graphics/drawable/Drawable;", "setDefaultBackgroundResId", "_resId", "", "setDefaultDrawable", "setDefaultResId", "setImageDownloadListener", "imageDownloadListener", "Lcom/tencent/mm/loader/listener/IImageDownloadListener;", "setImageFileBrokenCallback", "imageFileBrokenCallback", "Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "setImageLoadListener", "imageLoadListener", "Lcom/tencent/mm/loader/listener/IImageLoadListener;", "setImageLoaderAnimation", "animation", "Lcom/tencent/mm/loader/listener/IImageLoaderAnimation;", "setImageLoaderListener", "imageLoaderListener", "Lcom/tencent/mm/loader/listener/IImageLoaderListener;", "setImageLoaderReportListener", "imageloaderReportListener", "Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "setOptions", "options", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "withStruct", "V", "(Ljava/lang/Object;)Lcom/tencent/mm/loader/IRequestBuilder;", "libimageloader_release"})
public interface b<T, R> {
    b<T, R> a(e eVar);

    b<T, R> a(d dVar);

    b<T, R> a(com.tencent.mm.loader.f.e<T, R> eVar);

    void a(ImageView imageView, boolean z);

    void aJw();

    void c(ImageView imageView);

    void vC();
}
