package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareMedia;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareVideo extends ShareMedia {
    public static final Parcelable.Creator<ShareVideo> CREATOR = new Parcelable.Creator<ShareVideo>() {
        /* class com.facebook.share.model.ShareVideo.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final ShareVideo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(8621);
            ShareVideo shareVideo = new ShareVideo(parcel);
            AppMethodBeat.o(8621);
            return shareVideo;
        }

        @Override // android.os.Parcelable.Creator
        public final ShareVideo[] newArray(int i2) {
            return new ShareVideo[i2];
        }
    };
    private final Uri localUrl;

    private ShareVideo(Builder builder) {
        super(builder);
        AppMethodBeat.i(8630);
        this.localUrl = builder.localUrl;
        AppMethodBeat.o(8630);
    }

    ShareVideo(Parcel parcel) {
        super(parcel);
        AppMethodBeat.i(8631);
        this.localUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        AppMethodBeat.o(8631);
    }

    public final Uri getLocalUrl() {
        return this.localUrl;
    }

    @Override // com.facebook.share.model.ShareMedia
    public final int describeContents() {
        return 0;
    }

    @Override // com.facebook.share.model.ShareMedia
    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(8632);
        super.writeToParcel(parcel, i2);
        parcel.writeParcelable(this.localUrl, 0);
        AppMethodBeat.o(8632);
    }

    static {
        AppMethodBeat.i(8633);
        AppMethodBeat.o(8633);
    }

    @Override // com.facebook.share.model.ShareMedia
    public final ShareMedia.Type getMediaType() {
        return ShareMedia.Type.VIDEO;
    }

    public static final class Builder extends ShareMedia.Builder<ShareVideo, Builder> {
        private Uri localUrl;

        /* Return type fixed from 'com.facebook.share.model.ShareMedia$Builder' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.share.model.ShareMedia] */
        @Override // com.facebook.share.model.ShareMedia.Builder
        public final /* bridge */ /* synthetic */ Builder readFrom(ShareVideo shareVideo) {
            AppMethodBeat.i(8627);
            Builder readFrom = readFrom(shareVideo);
            AppMethodBeat.o(8627);
            return readFrom;
        }

        @Override // com.facebook.share.model.ShareMedia.Builder, com.facebook.share.model.ShareModelBuilder
        public final /* bridge */ /* synthetic */ ShareModelBuilder readFrom(ShareModel shareModel) {
            AppMethodBeat.i(8628);
            Builder readFrom = readFrom((ShareVideo) shareModel);
            AppMethodBeat.o(8628);
            return readFrom;
        }

        public final Builder setLocalUrl(Uri uri) {
            this.localUrl = uri;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public final ShareVideo build() {
            AppMethodBeat.i(8624);
            ShareVideo shareVideo = new ShareVideo(this);
            AppMethodBeat.o(8624);
            return shareVideo;
        }

        public final Builder readFrom(ShareVideo shareVideo) {
            AppMethodBeat.i(8625);
            if (shareVideo == null) {
                AppMethodBeat.o(8625);
                return this;
            }
            Builder localUrl2 = ((Builder) super.readFrom((ShareMedia) shareVideo)).setLocalUrl(shareVideo.getLocalUrl());
            AppMethodBeat.o(8625);
            return localUrl2;
        }

        /* access modifiers changed from: package-private */
        public final Builder readFrom(Parcel parcel) {
            AppMethodBeat.i(8626);
            Builder readFrom = readFrom((ShareVideo) parcel.readParcelable(ShareVideo.class.getClassLoader()));
            AppMethodBeat.o(8626);
            return readFrom;
        }
    }
}
