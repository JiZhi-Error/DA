package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ShareOpenGraphContent extends ShareContent<ShareOpenGraphContent, Builder> {
    public static final Parcelable.Creator<ShareOpenGraphContent> CREATOR = new Parcelable.Creator<ShareOpenGraphContent>() {
        /* class com.facebook.share.model.ShareOpenGraphContent.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final ShareOpenGraphContent createFromParcel(Parcel parcel) {
            AppMethodBeat.i(8554);
            ShareOpenGraphContent shareOpenGraphContent = new ShareOpenGraphContent(parcel);
            AppMethodBeat.o(8554);
            return shareOpenGraphContent;
        }

        @Override // android.os.Parcelable.Creator
        public final ShareOpenGraphContent[] newArray(int i2) {
            return new ShareOpenGraphContent[i2];
        }
    };
    private final ShareOpenGraphAction action;
    private final String previewPropertyName;

    private ShareOpenGraphContent(Builder builder) {
        super(builder);
        AppMethodBeat.i(8563);
        this.action = builder.action;
        this.previewPropertyName = builder.previewPropertyName;
        AppMethodBeat.o(8563);
    }

    ShareOpenGraphContent(Parcel parcel) {
        super(parcel);
        AppMethodBeat.i(8564);
        this.action = new ShareOpenGraphAction.Builder().readFrom(parcel).build();
        this.previewPropertyName = parcel.readString();
        AppMethodBeat.o(8564);
    }

    public final ShareOpenGraphAction getAction() {
        return this.action;
    }

    public final String getPreviewPropertyName() {
        return this.previewPropertyName;
    }

    @Override // com.facebook.share.model.ShareContent
    public final int describeContents() {
        return 0;
    }

    @Override // com.facebook.share.model.ShareContent
    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(8565);
        super.writeToParcel(parcel, i2);
        parcel.writeParcelable(this.action, 0);
        parcel.writeString(this.previewPropertyName);
        AppMethodBeat.o(8565);
    }

    static {
        AppMethodBeat.i(8566);
        AppMethodBeat.o(8566);
    }

    public static final class Builder extends ShareContent.Builder<ShareOpenGraphContent, Builder> {
        private ShareOpenGraphAction action;
        private String previewPropertyName;

        /* Return type fixed from 'com.facebook.share.model.ShareContent$Builder' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.share.model.ShareContent] */
        @Override // com.facebook.share.model.ShareContent.Builder
        public final /* bridge */ /* synthetic */ Builder readFrom(ShareOpenGraphContent shareOpenGraphContent) {
            AppMethodBeat.i(8560);
            Builder readFrom = readFrom(shareOpenGraphContent);
            AppMethodBeat.o(8560);
            return readFrom;
        }

        @Override // com.facebook.share.model.ShareModelBuilder, com.facebook.share.model.ShareContent.Builder
        public final /* bridge */ /* synthetic */ ShareModelBuilder readFrom(ShareModel shareModel) {
            AppMethodBeat.i(8561);
            Builder readFrom = readFrom((ShareOpenGraphContent) shareModel);
            AppMethodBeat.o(8561);
            return readFrom;
        }

        public final Builder setAction(ShareOpenGraphAction shareOpenGraphAction) {
            ShareOpenGraphAction build;
            AppMethodBeat.i(8557);
            if (shareOpenGraphAction == null) {
                build = null;
            } else {
                build = new ShareOpenGraphAction.Builder().readFrom(shareOpenGraphAction).build();
            }
            this.action = build;
            AppMethodBeat.o(8557);
            return this;
        }

        public final Builder setPreviewPropertyName(String str) {
            this.previewPropertyName = str;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public final ShareOpenGraphContent build() {
            AppMethodBeat.i(8558);
            ShareOpenGraphContent shareOpenGraphContent = new ShareOpenGraphContent(this);
            AppMethodBeat.o(8558);
            return shareOpenGraphContent;
        }

        public final Builder readFrom(ShareOpenGraphContent shareOpenGraphContent) {
            AppMethodBeat.i(8559);
            if (shareOpenGraphContent == null) {
                AppMethodBeat.o(8559);
                return this;
            }
            Builder previewPropertyName2 = ((Builder) super.readFrom((ShareContent) shareOpenGraphContent)).setAction(shareOpenGraphContent.getAction()).setPreviewPropertyName(shareOpenGraphContent.getPreviewPropertyName());
            AppMethodBeat.o(8559);
            return previewPropertyName2;
        }
    }
}
