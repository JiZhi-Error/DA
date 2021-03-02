package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.ShareModelBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ShareFeedContent extends ShareContent<ShareFeedContent, Builder> {
    public static final Parcelable.Creator<ShareFeedContent> CREATOR = new Parcelable.Creator<ShareFeedContent>() {
        /* class com.facebook.share.internal.ShareFeedContent.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final ShareFeedContent createFromParcel(Parcel parcel) {
            AppMethodBeat.i(8267);
            ShareFeedContent shareFeedContent = new ShareFeedContent(parcel);
            AppMethodBeat.o(8267);
            return shareFeedContent;
        }

        @Override // android.os.Parcelable.Creator
        public final ShareFeedContent[] newArray(int i2) {
            return new ShareFeedContent[i2];
        }
    };
    private final String link;
    private final String linkCaption;
    private final String linkDescription;
    private final String linkName;
    private final String mediaSource;
    private final String picture;
    private final String toId;

    private ShareFeedContent(Builder builder) {
        super(builder);
        AppMethodBeat.i(8275);
        this.toId = builder.toId;
        this.link = builder.link;
        this.linkName = builder.linkName;
        this.linkCaption = builder.linkCaption;
        this.linkDescription = builder.linkDescription;
        this.picture = builder.picture;
        this.mediaSource = builder.mediaSource;
        AppMethodBeat.o(8275);
    }

    ShareFeedContent(Parcel parcel) {
        super(parcel);
        AppMethodBeat.i(8276);
        this.toId = parcel.readString();
        this.link = parcel.readString();
        this.linkName = parcel.readString();
        this.linkCaption = parcel.readString();
        this.linkDescription = parcel.readString();
        this.picture = parcel.readString();
        this.mediaSource = parcel.readString();
        AppMethodBeat.o(8276);
    }

    public String getToId() {
        return this.toId;
    }

    public String getLink() {
        return this.link;
    }

    public String getLinkName() {
        return this.linkName;
    }

    public String getLinkCaption() {
        return this.linkCaption;
    }

    public String getLinkDescription() {
        return this.linkDescription;
    }

    public String getPicture() {
        return this.picture;
    }

    public String getMediaSource() {
        return this.mediaSource;
    }

    @Override // com.facebook.share.model.ShareContent
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.share.model.ShareContent
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(8277);
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.toId);
        parcel.writeString(this.link);
        parcel.writeString(this.linkName);
        parcel.writeString(this.linkCaption);
        parcel.writeString(this.linkDescription);
        parcel.writeString(this.picture);
        parcel.writeString(this.mediaSource);
        AppMethodBeat.o(8277);
    }

    static {
        AppMethodBeat.i(8278);
        AppMethodBeat.o(8278);
    }

    public static final class Builder extends ShareContent.Builder<ShareFeedContent, Builder> {
        private String link;
        private String linkCaption;
        private String linkDescription;
        private String linkName;
        private String mediaSource;
        private String picture;
        private String toId;

        /* Return type fixed from 'com.facebook.share.model.ShareContent$Builder' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.share.model.ShareContent] */
        @Override // com.facebook.share.model.ShareContent.Builder
        public final /* bridge */ /* synthetic */ Builder readFrom(ShareFeedContent shareFeedContent) {
            AppMethodBeat.i(8272);
            Builder readFrom = readFrom(shareFeedContent);
            AppMethodBeat.o(8272);
            return readFrom;
        }

        @Override // com.facebook.share.model.ShareModelBuilder, com.facebook.share.model.ShareContent.Builder
        public final /* bridge */ /* synthetic */ ShareModelBuilder readFrom(ShareModel shareModel) {
            AppMethodBeat.i(8273);
            Builder readFrom = readFrom((ShareFeedContent) shareModel);
            AppMethodBeat.o(8273);
            return readFrom;
        }

        public final Builder setToId(String str) {
            this.toId = str;
            return this;
        }

        public final Builder setLink(String str) {
            this.link = str;
            return this;
        }

        public final Builder setLinkName(String str) {
            this.linkName = str;
            return this;
        }

        public final Builder setLinkCaption(String str) {
            this.linkCaption = str;
            return this;
        }

        public final Builder setLinkDescription(String str) {
            this.linkDescription = str;
            return this;
        }

        public final Builder setPicture(String str) {
            this.picture = str;
            return this;
        }

        public final Builder setMediaSource(String str) {
            this.mediaSource = str;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public final ShareFeedContent build() {
            AppMethodBeat.i(8270);
            ShareFeedContent shareFeedContent = new ShareFeedContent(this);
            AppMethodBeat.o(8270);
            return shareFeedContent;
        }

        public final Builder readFrom(ShareFeedContent shareFeedContent) {
            AppMethodBeat.i(8271);
            if (shareFeedContent == null) {
                AppMethodBeat.o(8271);
                return this;
            }
            Builder mediaSource2 = ((Builder) super.readFrom((ShareContent) shareFeedContent)).setToId(shareFeedContent.getToId()).setLink(shareFeedContent.getLink()).setLinkName(shareFeedContent.getLinkName()).setLinkCaption(shareFeedContent.getLinkCaption()).setLinkDescription(shareFeedContent.getLinkDescription()).setPicture(shareFeedContent.getPicture()).setMediaSource(shareFeedContent.getMediaSource());
            AppMethodBeat.o(8271);
            return mediaSource2;
        }
    }
}
