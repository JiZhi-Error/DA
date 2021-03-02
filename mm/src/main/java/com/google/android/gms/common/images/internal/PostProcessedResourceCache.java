package com.google.android.gms.common.images.internal;

import android.graphics.drawable.Drawable;
import android.support.v4.e.h;
import com.google.android.gms.common.internal.Objects;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class PostProcessedResourceCache extends h<PostProcessedResource, Drawable> {

    public static final class PostProcessedResource {
        public final int postProcessingFlags;
        public final int resId;

        public PostProcessedResource(int i2, int i3) {
            this.resId = i2;
            this.postProcessingFlags = i3;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof PostProcessedResource)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            PostProcessedResource postProcessedResource = (PostProcessedResource) obj;
            return postProcessedResource.resId == this.resId && postProcessedResource.postProcessingFlags == this.postProcessingFlags;
        }

        public final int hashCode() {
            AppMethodBeat.i(11788);
            int hashCode = Objects.hashCode(Integer.valueOf(this.resId), Integer.valueOf(this.postProcessingFlags));
            AppMethodBeat.o(11788);
            return hashCode;
        }
    }

    public PostProcessedResourceCache() {
        super(10);
    }
}
