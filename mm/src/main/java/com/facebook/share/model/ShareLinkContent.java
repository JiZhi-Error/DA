package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareLinkContent extends ShareContent<ShareLinkContent, Builder> {
    public static final Parcelable.Creator<ShareLinkContent> CREATOR = new Parcelable.Creator<ShareLinkContent>() {
        /* class com.facebook.share.model.ShareLinkContent.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final ShareLinkContent createFromParcel(Parcel parcel) {
            AppMethodBeat.i(8442);
            ShareLinkContent shareLinkContent = new ShareLinkContent(parcel);
            AppMethodBeat.o(8442);
            return shareLinkContent;
        }

        @Override // android.os.Parcelable.Creator
        public final ShareLinkContent[] newArray(int i2) {
            return new ShareLinkContent[i2];
        }
    };
    @Deprecated
    private final String contentDescription;
    @Deprecated
    private final String contentTitle;
    @Deprecated
    private final Uri imageUrl;
    private final String quote;

    private ShareLinkContent(Builder builder) {
        super(builder);
        AppMethodBeat.i(8451);
        this.contentDescription = builder.contentDescription;
        this.contentTitle = builder.contentTitle;
        this.imageUrl = builder.imageUrl;
        this.quote = builder.quote;
        AppMethodBeat.o(8451);
    }

    ShareLinkContent(Parcel parcel) {
        super(parcel);
        AppMethodBeat.i(8452);
        this.contentDescription = parcel.readString();
        this.contentTitle = parcel.readString();
        this.imageUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.quote = parcel.readString();
        AppMethodBeat.o(8452);
    }

    @Deprecated
    public final String getContentDescription() {
        return this.contentDescription;
    }

    @Deprecated
    public final String getContentTitle() {
        return this.contentTitle;
    }

    @Deprecated
    public final Uri getImageUrl() {
        return this.imageUrl;
    }

    public final String getQuote() {
        return this.quote;
    }

    @Override // com.facebook.share.model.ShareContent
    public final int describeContents() {
        return 0;
    }

    @Override // com.facebook.share.model.ShareContent
    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(8453);
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.contentDescription);
        parcel.writeString(this.contentTitle);
        parcel.writeParcelable(this.imageUrl, 0);
        parcel.writeString(this.quote);
        AppMethodBeat.o(8453);
    }

    static {
        AppMethodBeat.i(8454);
        AppMethodBeat.o(8454);
    }

    public static final class Builder extends ShareContent.Builder<ShareLinkContent, Builder> {
        static final String TAG = Builder.class.getSimpleName();
        @Deprecated
        private String contentDescription;
        @Deprecated
        private String contentTitle;
        @Deprecated
        private Uri imageUrl;
        private String quote;

        /* Return type fixed from 'com.facebook.share.model.ShareContent$Builder' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.share.model.ShareContent] */
        @Override // com.facebook.share.model.ShareContent.Builder
        public final /* bridge */ /* synthetic */ Builder readFrom(ShareLinkContent shareLinkContent) {
            AppMethodBeat.i(8447);
            Builder readFrom = readFrom(shareLinkContent);
            AppMethodBeat.o(8447);
            return readFrom;
        }

        @Override // com.facebook.share.model.ShareModelBuilder, com.facebook.share.model.ShareContent.Builder
        public final /* bridge */ /* synthetic */ ShareModelBuilder readFrom(ShareModel shareModel) {
            AppMethodBeat.i(8448);
            Builder readFrom = readFrom((ShareLinkContent) shareModel);
            AppMethodBeat.o(8448);
            return readFrom;
        }

        static {
            AppMethodBeat.i(8450);
            AppMethodBeat.o(8450);
        }

        @Deprecated
        public final Builder setContentDescription(String str) {
            return this;
        }

        @Deprecated
        public final Builder setContentTitle(String str) {
            return this;
        }

        @Deprecated
        public final Builder setImageUrl(Uri uri) {
            return this;
        }

        public final Builder setQuote(String str) {
            this.quote = str;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public final ShareLinkContent build() {
            AppMethodBeat.i(8445);
            ShareLinkContent shareLinkContent = new ShareLinkContent(this);
            AppMethodBeat.o(8445);
            return shareLinkContent;
        }

        public final Builder readFrom(ShareLinkContent shareLinkContent) {
            AppMethodBeat.i(8446);
            if (shareLinkContent == null) {
                AppMethodBeat.o(8446);
                return this;
            }
            Builder quote2 = ((Builder) super.readFrom((ShareContent) shareLinkContent)).setContentDescription(shareLinkContent.getContentDescription()).setImageUrl(shareLinkContent.getImageUrl()).setContentTitle(shareLinkContent.getContentTitle()).setQuote(shareLinkContent.getQuote());
            AppMethodBeat.o(8446);
            return quote2;
        }
    }
}
