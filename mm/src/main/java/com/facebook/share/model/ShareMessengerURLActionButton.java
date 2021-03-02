package com.facebook.share.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareMessengerActionButton;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareMessengerURLActionButton extends ShareMessengerActionButton {
    public static final Parcelable.Creator<ShareMessengerURLActionButton> CREATOR = new Parcelable.Creator<ShareMessengerURLActionButton>() {
        /* class com.facebook.share.model.ShareMessengerURLActionButton.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final ShareMessengerURLActionButton createFromParcel(Parcel parcel) {
            AppMethodBeat.i(8528);
            ShareMessengerURLActionButton shareMessengerURLActionButton = new ShareMessengerURLActionButton(parcel);
            AppMethodBeat.o(8528);
            return shareMessengerURLActionButton;
        }

        @Override // android.os.Parcelable.Creator
        public final ShareMessengerURLActionButton[] newArray(int i2) {
            return new ShareMessengerURLActionButton[i2];
        }
    };
    private final Uri fallbackUrl;
    private final boolean isMessengerExtensionURL;
    private final boolean shouldHideWebviewShareButton;
    private final Uri url;
    private final WebviewHeightRatio webviewHeightRatio;

    public enum WebviewHeightRatio {
        WebviewHeightRatioFull,
        WebviewHeightRatioTall,
        WebviewHeightRatioCompact;

        public static WebviewHeightRatio valueOf(String str) {
            AppMethodBeat.i(8537);
            WebviewHeightRatio webviewHeightRatio = (WebviewHeightRatio) Enum.valueOf(WebviewHeightRatio.class, str);
            AppMethodBeat.o(8537);
            return webviewHeightRatio;
        }

        static {
            AppMethodBeat.i(8538);
            AppMethodBeat.o(8538);
        }
    }

    private ShareMessengerURLActionButton(Builder builder) {
        super(builder);
        AppMethodBeat.i(8539);
        this.url = builder.url;
        this.isMessengerExtensionURL = builder.isMessengerExtensionURL;
        this.fallbackUrl = builder.fallbackUrl;
        this.webviewHeightRatio = builder.webviewHeightRatio;
        this.shouldHideWebviewShareButton = builder.shouldHideWebviewShareButton;
        AppMethodBeat.o(8539);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ShareMessengerURLActionButton(Parcel parcel) {
        super(parcel);
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(8540);
        this.url = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        if (parcel.readByte() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.isMessengerExtensionURL = z;
        this.fallbackUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.webviewHeightRatio = (WebviewHeightRatio) parcel.readSerializable();
        this.shouldHideWebviewShareButton = parcel.readByte() == 0 ? false : z2;
        AppMethodBeat.o(8540);
    }

    public final Uri getUrl() {
        return this.url;
    }

    public final boolean getIsMessengerExtensionURL() {
        return this.isMessengerExtensionURL;
    }

    public final Uri getFallbackUrl() {
        return this.fallbackUrl;
    }

    public final WebviewHeightRatio getWebviewHeightRatio() {
        return this.webviewHeightRatio;
    }

    public final boolean getShouldHideWebviewShareButton() {
        return this.shouldHideWebviewShareButton;
    }

    static {
        AppMethodBeat.i(8541);
        AppMethodBeat.o(8541);
    }

    public static final class Builder extends ShareMessengerActionButton.Builder<ShareMessengerURLActionButton, Builder> {
        private Uri fallbackUrl;
        private boolean isMessengerExtensionURL;
        private boolean shouldHideWebviewShareButton;
        private Uri url;
        private WebviewHeightRatio webviewHeightRatio;

        /* Return type fixed from 'com.facebook.share.model.ShareMessengerActionButton$Builder' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.share.model.ShareMessengerActionButton] */
        @Override // com.facebook.share.model.ShareMessengerActionButton.Builder
        public final /* bridge */ /* synthetic */ Builder readFrom(ShareMessengerURLActionButton shareMessengerURLActionButton) {
            AppMethodBeat.i(8533);
            Builder readFrom = readFrom(shareMessengerURLActionButton);
            AppMethodBeat.o(8533);
            return readFrom;
        }

        @Override // com.facebook.share.model.ShareMessengerActionButton.Builder, com.facebook.share.model.ShareModelBuilder
        public final /* bridge */ /* synthetic */ ShareModelBuilder readFrom(ShareModel shareModel) {
            AppMethodBeat.i(8534);
            Builder readFrom = readFrom((ShareMessengerURLActionButton) shareModel);
            AppMethodBeat.o(8534);
            return readFrom;
        }

        public final Builder setUrl(Uri uri) {
            this.url = uri;
            return this;
        }

        public final Builder setIsMessengerExtensionURL(boolean z) {
            this.isMessengerExtensionURL = z;
            return this;
        }

        public final Builder setFallbackUrl(Uri uri) {
            this.fallbackUrl = uri;
            return this;
        }

        public final Builder setWebviewHeightRatio(WebviewHeightRatio webviewHeightRatio2) {
            this.webviewHeightRatio = webviewHeightRatio2;
            return this;
        }

        public final Builder setShouldHideWebviewShareButton(boolean z) {
            this.shouldHideWebviewShareButton = z;
            return this;
        }

        public final Builder readFrom(ShareMessengerURLActionButton shareMessengerURLActionButton) {
            AppMethodBeat.i(8531);
            if (shareMessengerURLActionButton == null) {
                AppMethodBeat.o(8531);
                return this;
            }
            Builder shouldHideWebviewShareButton2 = setUrl(shareMessengerURLActionButton.getUrl()).setIsMessengerExtensionURL(shareMessengerURLActionButton.getIsMessengerExtensionURL()).setFallbackUrl(shareMessengerURLActionButton.getFallbackUrl()).setWebviewHeightRatio(shareMessengerURLActionButton.getWebviewHeightRatio()).setShouldHideWebviewShareButton(shareMessengerURLActionButton.getShouldHideWebviewShareButton());
            AppMethodBeat.o(8531);
            return shouldHideWebviewShareButton2;
        }

        @Override // com.facebook.share.ShareBuilder
        public final ShareMessengerURLActionButton build() {
            AppMethodBeat.i(8532);
            ShareMessengerURLActionButton shareMessengerURLActionButton = new ShareMessengerURLActionButton(this);
            AppMethodBeat.o(8532);
            return shareMessengerURLActionButton;
        }
    }
}
