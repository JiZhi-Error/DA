package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareMessengerGenericTemplateElement implements ShareModel {
    public static final Parcelable.Creator<ShareMessengerGenericTemplateElement> CREATOR = new Parcelable.Creator<ShareMessengerGenericTemplateElement>() {
        /* class com.facebook.share.model.ShareMessengerGenericTemplateElement.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final ShareMessengerGenericTemplateElement createFromParcel(Parcel parcel) {
            AppMethodBeat.i(8489);
            ShareMessengerGenericTemplateElement shareMessengerGenericTemplateElement = new ShareMessengerGenericTemplateElement(parcel);
            AppMethodBeat.o(8489);
            return shareMessengerGenericTemplateElement;
        }

        @Override // android.os.Parcelable.Creator
        public final ShareMessengerGenericTemplateElement[] newArray(int i2) {
            return new ShareMessengerGenericTemplateElement[i2];
        }
    };
    private final ShareMessengerActionButton button;
    private final ShareMessengerActionButton defaultAction;
    private final Uri imageUrl;
    private final String subtitle;
    private final String title;

    private ShareMessengerGenericTemplateElement(Builder builder) {
        AppMethodBeat.i(8497);
        this.title = builder.title;
        this.subtitle = builder.subtitle;
        this.imageUrl = builder.imageUrl;
        this.defaultAction = builder.defaultAction;
        this.button = builder.button;
        AppMethodBeat.o(8497);
    }

    ShareMessengerGenericTemplateElement(Parcel parcel) {
        AppMethodBeat.i(8498);
        this.title = parcel.readString();
        this.subtitle = parcel.readString();
        this.imageUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.defaultAction = (ShareMessengerActionButton) parcel.readParcelable(ShareMessengerActionButton.class.getClassLoader());
        this.button = (ShareMessengerActionButton) parcel.readParcelable(ShareMessengerActionButton.class.getClassLoader());
        AppMethodBeat.o(8498);
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final Uri getImageUrl() {
        return this.imageUrl;
    }

    public final ShareMessengerActionButton getDefaultAction() {
        return this.defaultAction;
    }

    public final ShareMessengerActionButton getButton() {
        return this.button;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(8499);
        parcel.writeString(this.title);
        parcel.writeString(this.subtitle);
        parcel.writeParcelable(this.imageUrl, i2);
        parcel.writeParcelable(this.defaultAction, i2);
        parcel.writeParcelable(this.button, i2);
        AppMethodBeat.o(8499);
    }

    static {
        AppMethodBeat.i(8500);
        AppMethodBeat.o(8500);
    }

    public static class Builder implements ShareModelBuilder<ShareMessengerGenericTemplateElement, Builder> {
        private ShareMessengerActionButton button;
        private ShareMessengerActionButton defaultAction;
        private Uri imageUrl;
        private String subtitle;
        private String title;

        /* Return type fixed from 'com.facebook.share.model.ShareModelBuilder' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.share.model.ShareModel] */
        @Override // com.facebook.share.model.ShareModelBuilder
        public /* bridge */ /* synthetic */ Builder readFrom(ShareMessengerGenericTemplateElement shareMessengerGenericTemplateElement) {
            AppMethodBeat.i(8495);
            Builder readFrom = readFrom(shareMessengerGenericTemplateElement);
            AppMethodBeat.o(8495);
            return readFrom;
        }

        public Builder setTitle(String str) {
            this.title = str;
            return this;
        }

        public Builder setSubtitle(String str) {
            this.subtitle = str;
            return this;
        }

        public Builder setImageUrl(Uri uri) {
            this.imageUrl = uri;
            return this;
        }

        public Builder setDefaultAction(ShareMessengerActionButton shareMessengerActionButton) {
            this.defaultAction = shareMessengerActionButton;
            return this;
        }

        public Builder setButton(ShareMessengerActionButton shareMessengerActionButton) {
            this.button = shareMessengerActionButton;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public ShareMessengerGenericTemplateElement build() {
            AppMethodBeat.i(8492);
            ShareMessengerGenericTemplateElement shareMessengerGenericTemplateElement = new ShareMessengerGenericTemplateElement(this);
            AppMethodBeat.o(8492);
            return shareMessengerGenericTemplateElement;
        }

        public Builder readFrom(ShareMessengerGenericTemplateElement shareMessengerGenericTemplateElement) {
            AppMethodBeat.i(8493);
            if (shareMessengerGenericTemplateElement == null) {
                AppMethodBeat.o(8493);
                return this;
            }
            Builder button2 = setTitle(shareMessengerGenericTemplateElement.title).setSubtitle(shareMessengerGenericTemplateElement.subtitle).setImageUrl(shareMessengerGenericTemplateElement.imageUrl).setDefaultAction(shareMessengerGenericTemplateElement.defaultAction).setButton(shareMessengerGenericTemplateElement.button);
            AppMethodBeat.o(8493);
            return button2;
        }

        /* access modifiers changed from: package-private */
        public Builder readFrom(Parcel parcel) {
            AppMethodBeat.i(8494);
            Builder readFrom = readFrom((ShareMessengerGenericTemplateElement) parcel.readParcelable(ShareMessengerGenericTemplateElement.class.getClassLoader()));
            AppMethodBeat.o(8494);
            return readFrom;
        }
    }
}
