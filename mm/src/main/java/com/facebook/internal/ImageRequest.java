package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import com.facebook.FacebookSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

public class ImageRequest {
    private static final String HEIGHT_PARAM = "height";
    private static final String MIGRATION_PARAM = "migration_overrides";
    private static final String MIGRATION_VALUE = "{october_2012:true}";
    private static final String PATH = "%s/%s/picture";
    public static final int UNSPECIFIED_DIMENSION = 0;
    private static final String WIDTH_PARAM = "width";
    private boolean allowCachedRedirects;
    private Callback callback;
    private Object callerTag;
    private Context context;
    private Uri imageUri;

    public interface Callback {
        void onCompleted(ImageResponse imageResponse);
    }

    public static Uri getProfilePictureUri(String str, int i2, int i3) {
        AppMethodBeat.i(17826);
        Validate.notNullOrEmpty(str, "userId");
        int max = Math.max(i2, 0);
        int max2 = Math.max(i3, 0);
        if (max == 0 && max2 == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Either width or height must be greater than 0");
            AppMethodBeat.o(17826);
            throw illegalArgumentException;
        }
        Uri.Builder path = Uri.parse(ServerProtocol.getGraphUrlBase()).buildUpon().path(String.format(Locale.US, PATH, FacebookSdk.getGraphApiVersion(), str));
        if (max2 != 0) {
            path.appendQueryParameter(HEIGHT_PARAM, String.valueOf(max2));
        }
        if (max != 0) {
            path.appendQueryParameter(WIDTH_PARAM, String.valueOf(max));
        }
        path.appendQueryParameter(MIGRATION_PARAM, MIGRATION_VALUE);
        Uri build = path.build();
        AppMethodBeat.o(17826);
        return build;
    }

    private ImageRequest(Builder builder) {
        AppMethodBeat.i(17827);
        this.context = builder.context;
        this.imageUri = builder.imageUrl;
        this.callback = builder.callback;
        this.allowCachedRedirects = builder.allowCachedRedirects;
        this.callerTag = builder.callerTag == null ? new Object() : builder.callerTag;
        AppMethodBeat.o(17827);
    }

    public Context getContext() {
        return this.context;
    }

    public Uri getImageUri() {
        return this.imageUri;
    }

    public Callback getCallback() {
        return this.callback;
    }

    public boolean isCachedRedirectAllowed() {
        return this.allowCachedRedirects;
    }

    public Object getCallerTag() {
        return this.callerTag;
    }

    public static class Builder {
        private boolean allowCachedRedirects;
        private Callback callback;
        private Object callerTag;
        private Context context;
        private Uri imageUrl;

        public Builder(Context context2, Uri uri) {
            AppMethodBeat.i(17824);
            Validate.notNull(uri, "imageUri");
            this.context = context2;
            this.imageUrl = uri;
            AppMethodBeat.o(17824);
        }

        public Builder setCallback(Callback callback2) {
            this.callback = callback2;
            return this;
        }

        public Builder setCallerTag(Object obj) {
            this.callerTag = obj;
            return this;
        }

        public Builder setAllowCachedRedirects(boolean z) {
            this.allowCachedRedirects = z;
            return this;
        }

        public ImageRequest build() {
            AppMethodBeat.i(17825);
            ImageRequest imageRequest = new ImageRequest(this);
            AppMethodBeat.o(17825);
            return imageRequest;
        }
    }
}
