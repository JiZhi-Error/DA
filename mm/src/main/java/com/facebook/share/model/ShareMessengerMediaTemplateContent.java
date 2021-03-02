package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareMessengerMediaTemplateContent extends ShareContent<ShareMessengerMediaTemplateContent, Builder> {
    public static final Parcelable.Creator<ShareMessengerMediaTemplateContent> CREATOR = new Parcelable.Creator<ShareMessengerMediaTemplateContent>() {
        /* class com.facebook.share.model.ShareMessengerMediaTemplateContent.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final ShareMessengerMediaTemplateContent createFromParcel(Parcel parcel) {
            AppMethodBeat.i(8501);
            ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent = new ShareMessengerMediaTemplateContent(parcel);
            AppMethodBeat.o(8501);
            return shareMessengerMediaTemplateContent;
        }

        @Override // android.os.Parcelable.Creator
        public final ShareMessengerMediaTemplateContent[] newArray(int i2) {
            return new ShareMessengerMediaTemplateContent[i2];
        }
    };
    private final String attachmentId;
    private final ShareMessengerActionButton button;
    private final MediaType mediaType;
    private final Uri mediaUrl;

    public enum MediaType {
        IMAGE,
        VIDEO;

        public static MediaType valueOf(String str) {
            AppMethodBeat.i(8510);
            MediaType mediaType = (MediaType) Enum.valueOf(MediaType.class, str);
            AppMethodBeat.o(8510);
            return mediaType;
        }

        static {
            AppMethodBeat.i(8511);
            AppMethodBeat.o(8511);
        }
    }

    private ShareMessengerMediaTemplateContent(Builder builder) {
        super(builder);
        AppMethodBeat.i(8512);
        this.mediaType = builder.mediaType;
        this.attachmentId = builder.attachmentId;
        this.mediaUrl = builder.mediaUrl;
        this.button = builder.button;
        AppMethodBeat.o(8512);
    }

    ShareMessengerMediaTemplateContent(Parcel parcel) {
        super(parcel);
        AppMethodBeat.i(8513);
        this.mediaType = (MediaType) parcel.readSerializable();
        this.attachmentId = parcel.readString();
        this.mediaUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.button = (ShareMessengerActionButton) parcel.readParcelable(ShareMessengerActionButton.class.getClassLoader());
        AppMethodBeat.o(8513);
    }

    public final MediaType getMediaType() {
        return this.mediaType;
    }

    public final String getAttachmentId() {
        return this.attachmentId;
    }

    public final Uri getMediaUrl() {
        return this.mediaUrl;
    }

    public final ShareMessengerActionButton getButton() {
        return this.button;
    }

    @Override // com.facebook.share.model.ShareContent
    public final int describeContents() {
        return 0;
    }

    @Override // com.facebook.share.model.ShareContent
    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(8514);
        parcel.writeSerializable(this.mediaType);
        parcel.writeString(this.attachmentId);
        parcel.writeParcelable(this.mediaUrl, i2);
        parcel.writeParcelable(this.button, i2);
        AppMethodBeat.o(8514);
    }

    static {
        AppMethodBeat.i(8515);
        AppMethodBeat.o(8515);
    }

    public static class Builder extends ShareContent.Builder<ShareMessengerMediaTemplateContent, Builder> {
        private String attachmentId;
        private ShareMessengerActionButton button;
        private MediaType mediaType;
        private Uri mediaUrl;

        /* Return type fixed from 'com.facebook.share.model.ShareContent$Builder' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.share.model.ShareContent] */
        @Override // com.facebook.share.model.ShareContent.Builder
        public /* bridge */ /* synthetic */ Builder readFrom(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) {
            AppMethodBeat.i(8506);
            Builder readFrom = readFrom(shareMessengerMediaTemplateContent);
            AppMethodBeat.o(8506);
            return readFrom;
        }

        @Override // com.facebook.share.model.ShareModelBuilder, com.facebook.share.model.ShareContent.Builder
        public /* bridge */ /* synthetic */ ShareModelBuilder readFrom(ShareModel shareModel) {
            AppMethodBeat.i(8507);
            Builder readFrom = readFrom((ShareMessengerMediaTemplateContent) shareModel);
            AppMethodBeat.o(8507);
            return readFrom;
        }

        public Builder setMediaType(MediaType mediaType2) {
            this.mediaType = mediaType2;
            return this;
        }

        public Builder setAttachmentId(String str) {
            this.attachmentId = str;
            return this;
        }

        public Builder setMediaUrl(Uri uri) {
            this.mediaUrl = uri;
            return this;
        }

        public Builder setButton(ShareMessengerActionButton shareMessengerActionButton) {
            this.button = shareMessengerActionButton;
            return this;
        }

        public Builder readFrom(ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent) {
            AppMethodBeat.i(8504);
            if (shareMessengerMediaTemplateContent == null) {
                AppMethodBeat.o(8504);
                return this;
            }
            Builder button2 = ((Builder) super.readFrom((ShareContent) shareMessengerMediaTemplateContent)).setMediaType(shareMessengerMediaTemplateContent.getMediaType()).setAttachmentId(shareMessengerMediaTemplateContent.getAttachmentId()).setMediaUrl(shareMessengerMediaTemplateContent.getMediaUrl()).setButton(shareMessengerMediaTemplateContent.getButton());
            AppMethodBeat.o(8504);
            return button2;
        }

        @Override // com.facebook.share.ShareBuilder
        public ShareMessengerMediaTemplateContent build() {
            AppMethodBeat.i(8505);
            ShareMessengerMediaTemplateContent shareMessengerMediaTemplateContent = new ShareMessengerMediaTemplateContent(this);
            AppMethodBeat.o(8505);
            return shareMessengerMediaTemplateContent;
        }
    }
}
