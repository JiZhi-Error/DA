package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.ShareVideo;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareVideoContent extends ShareContent<ShareVideoContent, Builder> implements ShareModel {
    public static final Parcelable.Creator<ShareVideoContent> CREATOR = new Parcelable.Creator<ShareVideoContent>() {
        /* class com.facebook.share.model.ShareVideoContent.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final ShareVideoContent createFromParcel(Parcel parcel) {
            AppMethodBeat.i(8634);
            ShareVideoContent shareVideoContent = new ShareVideoContent(parcel);
            AppMethodBeat.o(8634);
            return shareVideoContent;
        }

        @Override // android.os.Parcelable.Creator
        public final ShareVideoContent[] newArray(int i2) {
            return new ShareVideoContent[i2];
        }
    };
    private final String contentDescription;
    private final String contentTitle;
    private final SharePhoto previewPhoto;
    private final ShareVideo video;

    private ShareVideoContent(Builder builder) {
        super(builder);
        AppMethodBeat.i(8644);
        this.contentDescription = builder.contentDescription;
        this.contentTitle = builder.contentTitle;
        this.previewPhoto = builder.previewPhoto;
        this.video = builder.video;
        AppMethodBeat.o(8644);
    }

    ShareVideoContent(Parcel parcel) {
        super(parcel);
        AppMethodBeat.i(8645);
        this.contentDescription = parcel.readString();
        this.contentTitle = parcel.readString();
        SharePhoto.Builder readFrom = new SharePhoto.Builder().readFrom(parcel);
        if (readFrom.getImageUrl() == null && readFrom.getBitmap() == null) {
            this.previewPhoto = null;
        } else {
            this.previewPhoto = readFrom.build();
        }
        this.video = new ShareVideo.Builder().readFrom(parcel).build();
        AppMethodBeat.o(8645);
    }

    public final String getContentDescription() {
        return this.contentDescription;
    }

    public final String getContentTitle() {
        return this.contentTitle;
    }

    public final SharePhoto getPreviewPhoto() {
        return this.previewPhoto;
    }

    public final ShareVideo getVideo() {
        return this.video;
    }

    @Override // com.facebook.share.model.ShareContent
    public final int describeContents() {
        return 0;
    }

    @Override // com.facebook.share.model.ShareContent
    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(8646);
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.contentDescription);
        parcel.writeString(this.contentTitle);
        parcel.writeParcelable(this.previewPhoto, 0);
        parcel.writeParcelable(this.video, 0);
        AppMethodBeat.o(8646);
    }

    static {
        AppMethodBeat.i(8647);
        AppMethodBeat.o(8647);
    }

    public static final class Builder extends ShareContent.Builder<ShareVideoContent, Builder> {
        private String contentDescription;
        private String contentTitle;
        private SharePhoto previewPhoto;
        private ShareVideo video;

        /* Return type fixed from 'com.facebook.share.model.ShareContent$Builder' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.share.model.ShareContent] */
        @Override // com.facebook.share.model.ShareContent.Builder
        public final /* bridge */ /* synthetic */ Builder readFrom(ShareVideoContent shareVideoContent) {
            AppMethodBeat.i(8641);
            Builder readFrom = readFrom(shareVideoContent);
            AppMethodBeat.o(8641);
            return readFrom;
        }

        @Override // com.facebook.share.model.ShareModelBuilder, com.facebook.share.model.ShareContent.Builder
        public final /* bridge */ /* synthetic */ ShareModelBuilder readFrom(ShareModel shareModel) {
            AppMethodBeat.i(8642);
            Builder readFrom = readFrom((ShareVideoContent) shareModel);
            AppMethodBeat.o(8642);
            return readFrom;
        }

        public final Builder setContentDescription(String str) {
            this.contentDescription = str;
            return this;
        }

        public final Builder setContentTitle(String str) {
            this.contentTitle = str;
            return this;
        }

        public final Builder setPreviewPhoto(SharePhoto sharePhoto) {
            SharePhoto build;
            AppMethodBeat.i(8637);
            if (sharePhoto == null) {
                build = null;
            } else {
                build = new SharePhoto.Builder().readFrom(sharePhoto).build();
            }
            this.previewPhoto = build;
            AppMethodBeat.o(8637);
            return this;
        }

        public final Builder setVideo(ShareVideo shareVideo) {
            AppMethodBeat.i(8638);
            if (shareVideo == null) {
                AppMethodBeat.o(8638);
            } else {
                this.video = new ShareVideo.Builder().readFrom(shareVideo).build();
                AppMethodBeat.o(8638);
            }
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public final ShareVideoContent build() {
            AppMethodBeat.i(8639);
            ShareVideoContent shareVideoContent = new ShareVideoContent(this);
            AppMethodBeat.o(8639);
            return shareVideoContent;
        }

        public final Builder readFrom(ShareVideoContent shareVideoContent) {
            AppMethodBeat.i(8640);
            if (shareVideoContent == null) {
                AppMethodBeat.o(8640);
                return this;
            }
            Builder video2 = ((Builder) super.readFrom((ShareContent) shareVideoContent)).setContentDescription(shareVideoContent.getContentDescription()).setContentTitle(shareVideoContent.getContentTitle()).setPreviewPhoto(shareVideoContent.getPreviewPhoto()).setVideo(shareVideoContent.getVideo());
            AppMethodBeat.o(8640);
            return video2;
        }
    }
}
