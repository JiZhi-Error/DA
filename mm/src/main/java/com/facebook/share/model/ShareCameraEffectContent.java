package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.CameraEffectArguments;
import com.facebook.share.model.CameraEffectTextures;
import com.facebook.share.model.ShareContent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ShareCameraEffectContent extends ShareContent<ShareCameraEffectContent, Builder> {
    public static final Parcelable.Creator<ShareCameraEffectContent> CREATOR = new Parcelable.Creator<ShareCameraEffectContent>() {
        /* class com.facebook.share.model.ShareCameraEffectContent.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final ShareCameraEffectContent createFromParcel(Parcel parcel) {
            AppMethodBeat.i(8418);
            ShareCameraEffectContent shareCameraEffectContent = new ShareCameraEffectContent(parcel);
            AppMethodBeat.o(8418);
            return shareCameraEffectContent;
        }

        @Override // android.os.Parcelable.Creator
        public final ShareCameraEffectContent[] newArray(int i2) {
            return new ShareCameraEffectContent[i2];
        }
    };
    private CameraEffectArguments arguments;
    private String effectId;
    private CameraEffectTextures textures;

    private ShareCameraEffectContent(Builder builder) {
        super(builder);
        AppMethodBeat.i(8426);
        this.effectId = builder.effectId;
        this.arguments = builder.arguments;
        this.textures = builder.textures;
        AppMethodBeat.o(8426);
    }

    ShareCameraEffectContent(Parcel parcel) {
        super(parcel);
        AppMethodBeat.i(8427);
        this.effectId = parcel.readString();
        this.arguments = new CameraEffectArguments.Builder().readFrom(parcel).build();
        this.textures = new CameraEffectTextures.Builder().readFrom(parcel).build();
        AppMethodBeat.o(8427);
    }

    @Override // com.facebook.share.model.ShareContent
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(8428);
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.effectId);
        parcel.writeParcelable(this.arguments, 0);
        parcel.writeParcelable(this.textures, 0);
        AppMethodBeat.o(8428);
    }

    public String getEffectId() {
        return this.effectId;
    }

    public CameraEffectArguments getArguments() {
        return this.arguments;
    }

    public CameraEffectTextures getTextures() {
        return this.textures;
    }

    static {
        AppMethodBeat.i(8429);
        AppMethodBeat.o(8429);
    }

    public static final class Builder extends ShareContent.Builder<ShareCameraEffectContent, Builder> {
        private CameraEffectArguments arguments;
        private String effectId;
        private CameraEffectTextures textures;

        /* Return type fixed from 'com.facebook.share.model.ShareContent$Builder' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.share.model.ShareContent] */
        @Override // com.facebook.share.model.ShareContent.Builder
        public final /* bridge */ /* synthetic */ Builder readFrom(ShareCameraEffectContent shareCameraEffectContent) {
            AppMethodBeat.i(8423);
            Builder readFrom = readFrom(shareCameraEffectContent);
            AppMethodBeat.o(8423);
            return readFrom;
        }

        @Override // com.facebook.share.model.ShareModelBuilder, com.facebook.share.model.ShareContent.Builder
        public final /* bridge */ /* synthetic */ ShareModelBuilder readFrom(ShareModel shareModel) {
            AppMethodBeat.i(8424);
            Builder readFrom = readFrom((ShareCameraEffectContent) shareModel);
            AppMethodBeat.o(8424);
            return readFrom;
        }

        public final Builder setEffectId(String str) {
            this.effectId = str;
            return this;
        }

        public final Builder setArguments(CameraEffectArguments cameraEffectArguments) {
            this.arguments = cameraEffectArguments;
            return this;
        }

        public final Builder setTextures(CameraEffectTextures cameraEffectTextures) {
            this.textures = cameraEffectTextures;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        public final ShareCameraEffectContent build() {
            AppMethodBeat.i(8421);
            ShareCameraEffectContent shareCameraEffectContent = new ShareCameraEffectContent(this);
            AppMethodBeat.o(8421);
            return shareCameraEffectContent;
        }

        public final Builder readFrom(ShareCameraEffectContent shareCameraEffectContent) {
            AppMethodBeat.i(8422);
            if (shareCameraEffectContent == null) {
                AppMethodBeat.o(8422);
                return this;
            }
            Builder arguments2 = ((Builder) super.readFrom((ShareContent) shareCameraEffectContent)).setEffectId(this.effectId).setArguments(this.arguments);
            AppMethodBeat.o(8422);
            return arguments2;
        }
    }
}
