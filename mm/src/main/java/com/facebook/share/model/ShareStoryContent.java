package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ShareStoryContent extends ShareContent<ShareStoryContent, Builder> {
    public static final Parcelable.Creator<ShareStoryContent> CREATOR = new Parcelable.Creator<ShareStoryContent>() {
        /* class com.facebook.share.model.ShareStoryContent.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final ShareStoryContent createFromParcel(Parcel parcel) {
            AppMethodBeat.i(8606);
            ShareStoryContent shareStoryContent = new ShareStoryContent(parcel);
            AppMethodBeat.o(8606);
            return shareStoryContent;
        }

        @Override // android.os.Parcelable.Creator
        public final ShareStoryContent[] newArray(int i2) {
            return new ShareStoryContent[i2];
        }
    };
    private final String mAttributionLink;
    private final ShareMedia mBackgroundAsset;
    private final List<String> mBackgroundColorList;
    private final SharePhoto mStickerAsset;

    private ShareStoryContent(Builder builder) {
        super(builder);
        AppMethodBeat.i(8615);
        this.mBackgroundAsset = builder.mBackgroundAsset;
        this.mStickerAsset = builder.mStickerAsset;
        this.mBackgroundColorList = builder.mBackgroundColorList;
        this.mAttributionLink = builder.mAttributionLink;
        AppMethodBeat.o(8615);
    }

    ShareStoryContent(Parcel parcel) {
        super(parcel);
        AppMethodBeat.i(8616);
        this.mBackgroundAsset = (ShareMedia) parcel.readParcelable(ShareMedia.class.getClassLoader());
        this.mStickerAsset = (SharePhoto) parcel.readParcelable(SharePhoto.class.getClassLoader());
        this.mBackgroundColorList = readUnmodifiableStringList(parcel);
        this.mAttributionLink = parcel.readString();
        AppMethodBeat.o(8616);
    }

    public final ShareMedia getBackgroundAsset() {
        return this.mBackgroundAsset;
    }

    public final SharePhoto getStickerAsset() {
        return this.mStickerAsset;
    }

    public final List<String> getBackgroundColorList() {
        AppMethodBeat.i(8617);
        if (this.mBackgroundColorList == null) {
            AppMethodBeat.o(8617);
            return null;
        }
        List<String> unmodifiableList = Collections.unmodifiableList(this.mBackgroundColorList);
        AppMethodBeat.o(8617);
        return unmodifiableList;
    }

    public final String getAttributionLink() {
        return this.mAttributionLink;
    }

    @Override // com.facebook.share.model.ShareContent
    public final int describeContents() {
        return 0;
    }

    @Override // com.facebook.share.model.ShareContent
    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(8618);
        super.writeToParcel(parcel, i2);
        parcel.writeParcelable(this.mBackgroundAsset, 0);
        parcel.writeParcelable(this.mStickerAsset, 0);
        parcel.writeStringList(this.mBackgroundColorList);
        parcel.writeString(this.mAttributionLink);
        AppMethodBeat.o(8618);
    }

    static {
        AppMethodBeat.i(8620);
        AppMethodBeat.o(8620);
    }

    private List<String> readUnmodifiableStringList(Parcel parcel) {
        AppMethodBeat.i(8619);
        ArrayList arrayList = new ArrayList();
        parcel.readStringList(arrayList);
        if (arrayList.isEmpty()) {
            AppMethodBeat.o(8619);
            return null;
        }
        List<String> unmodifiableList = Collections.unmodifiableList(arrayList);
        AppMethodBeat.o(8619);
        return unmodifiableList;
    }

    public static final class Builder extends ShareContent.Builder<ShareStoryContent, Builder> {
        static final String TAG = Builder.class.getSimpleName();
        private String mAttributionLink;
        private ShareMedia mBackgroundAsset;
        private List<String> mBackgroundColorList;
        private SharePhoto mStickerAsset;

        /* Return type fixed from 'com.facebook.share.model.ShareContent$Builder' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.share.model.ShareContent] */
        @Override // com.facebook.share.model.ShareContent.Builder
        public final /* bridge */ /* synthetic */ Builder readFrom(ShareStoryContent shareStoryContent) {
            AppMethodBeat.i(8611);
            Builder readFrom = readFrom(shareStoryContent);
            AppMethodBeat.o(8611);
            return readFrom;
        }

        @Override // com.facebook.share.model.ShareModelBuilder, com.facebook.share.model.ShareContent.Builder
        public final /* bridge */ /* synthetic */ ShareModelBuilder readFrom(ShareModel shareModel) {
            AppMethodBeat.i(8612);
            Builder readFrom = readFrom((ShareStoryContent) shareModel);
            AppMethodBeat.o(8612);
            return readFrom;
        }

        static {
            AppMethodBeat.i(8614);
            AppMethodBeat.o(8614);
        }

        public final Builder setBackgroundAsset(ShareMedia shareMedia) {
            this.mBackgroundAsset = shareMedia;
            return this;
        }

        public final Builder setStickerAsset(SharePhoto sharePhoto) {
            this.mStickerAsset = sharePhoto;
            return this;
        }

        public final Builder setBackgroundColorList(List<String> list) {
            this.mBackgroundColorList = list;
            return this;
        }

        public final Builder setAttributionLink(String str) {
            this.mAttributionLink = str;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public final ShareStoryContent build() {
            AppMethodBeat.i(8609);
            ShareStoryContent shareStoryContent = new ShareStoryContent(this);
            AppMethodBeat.o(8609);
            return shareStoryContent;
        }

        public final Builder readFrom(ShareStoryContent shareStoryContent) {
            AppMethodBeat.i(8610);
            if (shareStoryContent == null) {
                AppMethodBeat.o(8610);
                return this;
            }
            Builder attributionLink = ((Builder) super.readFrom((ShareContent) shareStoryContent)).setBackgroundAsset(shareStoryContent.getBackgroundAsset()).setStickerAsset(shareStoryContent.getStickerAsset()).setBackgroundColorList(shareStoryContent.getBackgroundColorList()).setAttributionLink(shareStoryContent.getAttributionLink());
            AppMethodBeat.o(8610);
            return attributionLink;
        }
    }
}
