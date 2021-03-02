package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.SharePhoto;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SharePhotoContent extends ShareContent<SharePhotoContent, Builder> {
    public static final Parcelable.Creator<SharePhotoContent> CREATOR = new Parcelable.Creator<SharePhotoContent>() {
        /* class com.facebook.share.model.SharePhotoContent.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final SharePhotoContent createFromParcel(Parcel parcel) {
            AppMethodBeat.i(8590);
            SharePhotoContent sharePhotoContent = new SharePhotoContent(parcel);
            AppMethodBeat.o(8590);
            return sharePhotoContent;
        }

        @Override // android.os.Parcelable.Creator
        public final SharePhotoContent[] newArray(int i2) {
            return new SharePhotoContent[i2];
        }
    };
    private final List<SharePhoto> photos;

    private SharePhotoContent(Builder builder) {
        super(builder);
        AppMethodBeat.i(8602);
        this.photos = Collections.unmodifiableList(builder.photos);
        AppMethodBeat.o(8602);
    }

    SharePhotoContent(Parcel parcel) {
        super(parcel);
        AppMethodBeat.i(8603);
        this.photos = Collections.unmodifiableList(SharePhoto.Builder.readPhotoListFrom(parcel));
        AppMethodBeat.o(8603);
    }

    public final List<SharePhoto> getPhotos() {
        return this.photos;
    }

    @Override // com.facebook.share.model.ShareContent
    public final int describeContents() {
        return 0;
    }

    @Override // com.facebook.share.model.ShareContent
    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(8604);
        super.writeToParcel(parcel, i2);
        SharePhoto.Builder.writePhotoListTo(parcel, i2, this.photos);
        AppMethodBeat.o(8604);
    }

    static {
        AppMethodBeat.i(8605);
        AppMethodBeat.o(8605);
    }

    public static class Builder extends ShareContent.Builder<SharePhotoContent, Builder> {
        private final List<SharePhoto> photos = new ArrayList();

        public Builder() {
            AppMethodBeat.i(8593);
            AppMethodBeat.o(8593);
        }

        /* Return type fixed from 'com.facebook.share.model.ShareContent$Builder' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.share.model.ShareContent] */
        @Override // com.facebook.share.model.ShareContent.Builder
        public /* bridge */ /* synthetic */ Builder readFrom(SharePhotoContent sharePhotoContent) {
            AppMethodBeat.i(8599);
            Builder readFrom = readFrom(sharePhotoContent);
            AppMethodBeat.o(8599);
            return readFrom;
        }

        @Override // com.facebook.share.model.ShareModelBuilder, com.facebook.share.model.ShareContent.Builder
        public /* bridge */ /* synthetic */ ShareModelBuilder readFrom(ShareModel shareModel) {
            AppMethodBeat.i(8600);
            Builder readFrom = readFrom((SharePhotoContent) shareModel);
            AppMethodBeat.o(8600);
            return readFrom;
        }

        public Builder addPhoto(SharePhoto sharePhoto) {
            AppMethodBeat.i(8594);
            if (sharePhoto != null) {
                this.photos.add(new SharePhoto.Builder().readFrom(sharePhoto).build());
            }
            AppMethodBeat.o(8594);
            return this;
        }

        public Builder addPhotos(List<SharePhoto> list) {
            AppMethodBeat.i(8595);
            if (list != null) {
                for (SharePhoto sharePhoto : list) {
                    addPhoto(sharePhoto);
                }
            }
            AppMethodBeat.o(8595);
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public SharePhotoContent build() {
            AppMethodBeat.i(8596);
            SharePhotoContent sharePhotoContent = new SharePhotoContent(this);
            AppMethodBeat.o(8596);
            return sharePhotoContent;
        }

        public Builder readFrom(SharePhotoContent sharePhotoContent) {
            AppMethodBeat.i(8597);
            if (sharePhotoContent == null) {
                AppMethodBeat.o(8597);
                return this;
            }
            Builder addPhotos = ((Builder) super.readFrom((ShareContent) sharePhotoContent)).addPhotos(sharePhotoContent.getPhotos());
            AppMethodBeat.o(8597);
            return addPhotos;
        }

        public Builder setPhotos(List<SharePhoto> list) {
            AppMethodBeat.i(8598);
            this.photos.clear();
            addPhotos(list);
            AppMethodBeat.o(8598);
            return this;
        }
    }
}
