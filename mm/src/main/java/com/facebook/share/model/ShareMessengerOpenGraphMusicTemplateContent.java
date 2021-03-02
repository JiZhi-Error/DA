package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareMessengerOpenGraphMusicTemplateContent extends ShareContent<ShareMessengerOpenGraphMusicTemplateContent, Builder> {
    public static final Parcelable.Creator<ShareMessengerOpenGraphMusicTemplateContent> CREATOR = new Parcelable.Creator<ShareMessengerOpenGraphMusicTemplateContent>() {
        /* class com.facebook.share.model.ShareMessengerOpenGraphMusicTemplateContent.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final ShareMessengerOpenGraphMusicTemplateContent createFromParcel(Parcel parcel) {
            AppMethodBeat.i(8516);
            ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent = new ShareMessengerOpenGraphMusicTemplateContent(parcel);
            AppMethodBeat.o(8516);
            return shareMessengerOpenGraphMusicTemplateContent;
        }

        @Override // android.os.Parcelable.Creator
        public final ShareMessengerOpenGraphMusicTemplateContent[] newArray(int i2) {
            return new ShareMessengerOpenGraphMusicTemplateContent[i2];
        }
    };
    private final ShareMessengerActionButton button;
    private final Uri url;

    private ShareMessengerOpenGraphMusicTemplateContent(Builder builder) {
        super(builder);
        AppMethodBeat.i(8524);
        this.url = builder.url;
        this.button = builder.button;
        AppMethodBeat.o(8524);
    }

    ShareMessengerOpenGraphMusicTemplateContent(Parcel parcel) {
        super(parcel);
        AppMethodBeat.i(8525);
        this.url = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.button = (ShareMessengerActionButton) parcel.readParcelable(ShareMessengerActionButton.class.getClassLoader());
        AppMethodBeat.o(8525);
    }

    public final Uri getUrl() {
        return this.url;
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
        AppMethodBeat.i(8526);
        parcel.writeParcelable(this.url, i2);
        parcel.writeParcelable(this.button, i2);
        AppMethodBeat.o(8526);
    }

    static {
        AppMethodBeat.i(8527);
        AppMethodBeat.o(8527);
    }

    public static class Builder extends ShareContent.Builder<ShareMessengerOpenGraphMusicTemplateContent, Builder> {
        private ShareMessengerActionButton button;
        private Uri url;

        /* Return type fixed from 'com.facebook.share.model.ShareContent$Builder' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.share.model.ShareContent] */
        @Override // com.facebook.share.model.ShareContent.Builder
        public /* bridge */ /* synthetic */ Builder readFrom(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) {
            AppMethodBeat.i(8521);
            Builder readFrom = readFrom(shareMessengerOpenGraphMusicTemplateContent);
            AppMethodBeat.o(8521);
            return readFrom;
        }

        @Override // com.facebook.share.model.ShareModelBuilder, com.facebook.share.model.ShareContent.Builder
        public /* bridge */ /* synthetic */ ShareModelBuilder readFrom(ShareModel shareModel) {
            AppMethodBeat.i(8522);
            Builder readFrom = readFrom((ShareMessengerOpenGraphMusicTemplateContent) shareModel);
            AppMethodBeat.o(8522);
            return readFrom;
        }

        public Builder setUrl(Uri uri) {
            this.url = uri;
            return this;
        }

        public Builder setButton(ShareMessengerActionButton shareMessengerActionButton) {
            this.button = shareMessengerActionButton;
            return this;
        }

        public Builder readFrom(ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent) {
            AppMethodBeat.i(8519);
            if (shareMessengerOpenGraphMusicTemplateContent == null) {
                AppMethodBeat.o(8519);
                return this;
            }
            Builder button2 = ((Builder) super.readFrom((ShareContent) shareMessengerOpenGraphMusicTemplateContent)).setUrl(shareMessengerOpenGraphMusicTemplateContent.getUrl()).setButton(shareMessengerOpenGraphMusicTemplateContent.getButton());
            AppMethodBeat.o(8519);
            return button2;
        }

        @Override // com.facebook.share.ShareBuilder
        public ShareMessengerOpenGraphMusicTemplateContent build() {
            AppMethodBeat.i(8520);
            ShareMessengerOpenGraphMusicTemplateContent shareMessengerOpenGraphMusicTemplateContent = new ShareMessengerOpenGraphMusicTemplateContent(this);
            AppMethodBeat.o(8520);
            return shareMessengerOpenGraphMusicTemplateContent;
        }
    }
}
