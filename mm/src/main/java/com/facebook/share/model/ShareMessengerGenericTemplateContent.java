package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareMessengerGenericTemplateContent extends ShareContent<ShareMessengerGenericTemplateContent, Builder> {
    public static final Parcelable.Creator<ShareMessengerGenericTemplateContent> CREATOR = new Parcelable.Creator<ShareMessengerGenericTemplateContent>() {
        /* class com.facebook.share.model.ShareMessengerGenericTemplateContent.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final ShareMessengerGenericTemplateContent createFromParcel(Parcel parcel) {
            AppMethodBeat.i(8474);
            ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent = new ShareMessengerGenericTemplateContent(parcel);
            AppMethodBeat.o(8474);
            return shareMessengerGenericTemplateContent;
        }

        @Override // android.os.Parcelable.Creator
        public final ShareMessengerGenericTemplateContent[] newArray(int i2) {
            return new ShareMessengerGenericTemplateContent[i2];
        }
    };
    private final ShareMessengerGenericTemplateElement genericTemplateElement;
    private final ImageAspectRatio imageAspectRatio;
    private final boolean isSharable;

    public enum ImageAspectRatio {
        HORIZONTAL,
        SQUARE;

        public static ImageAspectRatio valueOf(String str) {
            AppMethodBeat.i(8483);
            ImageAspectRatio imageAspectRatio = (ImageAspectRatio) Enum.valueOf(ImageAspectRatio.class, str);
            AppMethodBeat.o(8483);
            return imageAspectRatio;
        }

        static {
            AppMethodBeat.i(8484);
            AppMethodBeat.o(8484);
        }
    }

    protected ShareMessengerGenericTemplateContent(Builder builder) {
        super(builder);
        AppMethodBeat.i(8485);
        this.isSharable = builder.isSharable;
        this.imageAspectRatio = builder.imageAspectRatio;
        this.genericTemplateElement = builder.genericTemplateElement;
        AppMethodBeat.o(8485);
    }

    ShareMessengerGenericTemplateContent(Parcel parcel) {
        super(parcel);
        AppMethodBeat.i(8486);
        this.isSharable = parcel.readByte() != 0;
        this.imageAspectRatio = (ImageAspectRatio) parcel.readSerializable();
        this.genericTemplateElement = (ShareMessengerGenericTemplateElement) parcel.readParcelable(ShareMessengerGenericTemplateElement.class.getClassLoader());
        AppMethodBeat.o(8486);
    }

    public final boolean getIsSharable() {
        return this.isSharable;
    }

    public final ImageAspectRatio getImageAspectRatio() {
        return this.imageAspectRatio;
    }

    public final ShareMessengerGenericTemplateElement getGenericTemplateElement() {
        return this.genericTemplateElement;
    }

    @Override // com.facebook.share.model.ShareContent
    public final int describeContents() {
        return 0;
    }

    @Override // com.facebook.share.model.ShareContent
    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(8487);
        super.writeToParcel(parcel, i2);
        parcel.writeByte((byte) (this.isSharable ? 1 : 0));
        parcel.writeSerializable(this.imageAspectRatio);
        parcel.writeParcelable(this.genericTemplateElement, i2);
        AppMethodBeat.o(8487);
    }

    static {
        AppMethodBeat.i(8488);
        AppMethodBeat.o(8488);
    }

    public static class Builder extends ShareContent.Builder<ShareMessengerGenericTemplateContent, Builder> {
        private ShareMessengerGenericTemplateElement genericTemplateElement;
        private ImageAspectRatio imageAspectRatio;
        private boolean isSharable;

        /* Return type fixed from 'com.facebook.share.model.ShareContent$Builder' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.share.model.ShareContent] */
        @Override // com.facebook.share.model.ShareContent.Builder
        public /* bridge */ /* synthetic */ Builder readFrom(ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent) {
            AppMethodBeat.i(8479);
            Builder readFrom = readFrom(shareMessengerGenericTemplateContent);
            AppMethodBeat.o(8479);
            return readFrom;
        }

        @Override // com.facebook.share.model.ShareModelBuilder, com.facebook.share.model.ShareContent.Builder
        public /* bridge */ /* synthetic */ ShareModelBuilder readFrom(ShareModel shareModel) {
            AppMethodBeat.i(8480);
            Builder readFrom = readFrom((ShareMessengerGenericTemplateContent) shareModel);
            AppMethodBeat.o(8480);
            return readFrom;
        }

        public Builder setIsSharable(boolean z) {
            this.isSharable = z;
            return this;
        }

        public Builder setImageAspectRatio(ImageAspectRatio imageAspectRatio2) {
            this.imageAspectRatio = imageAspectRatio2;
            return this;
        }

        public Builder setGenericTemplateElement(ShareMessengerGenericTemplateElement shareMessengerGenericTemplateElement) {
            this.genericTemplateElement = shareMessengerGenericTemplateElement;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public ShareMessengerGenericTemplateContent build() {
            AppMethodBeat.i(8477);
            ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent = new ShareMessengerGenericTemplateContent(this);
            AppMethodBeat.o(8477);
            return shareMessengerGenericTemplateContent;
        }

        public Builder readFrom(ShareMessengerGenericTemplateContent shareMessengerGenericTemplateContent) {
            AppMethodBeat.i(8478);
            if (shareMessengerGenericTemplateContent == null) {
                AppMethodBeat.o(8478);
                return this;
            }
            Builder genericTemplateElement2 = ((Builder) super.readFrom((ShareContent) shareMessengerGenericTemplateContent)).setIsSharable(shareMessengerGenericTemplateContent.getIsSharable()).setImageAspectRatio(shareMessengerGenericTemplateContent.getImageAspectRatio()).setGenericTemplateElement(shareMessengerGenericTemplateContent.getGenericTemplateElement());
            AppMethodBeat.o(8478);
            return genericTemplateElement2;
        }
    }
}
