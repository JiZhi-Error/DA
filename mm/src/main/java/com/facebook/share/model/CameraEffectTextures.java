package com.facebook.share.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;

public class CameraEffectTextures implements ShareModel {
    public static final Parcelable.Creator<CameraEffectTextures> CREATOR = new Parcelable.Creator<CameraEffectTextures>() {
        /* class com.facebook.share.model.CameraEffectTextures.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final CameraEffectTextures createFromParcel(Parcel parcel) {
            AppMethodBeat.i(8378);
            CameraEffectTextures cameraEffectTextures = new CameraEffectTextures(parcel);
            AppMethodBeat.o(8378);
            return cameraEffectTextures;
        }

        @Override // android.os.Parcelable.Creator
        public final CameraEffectTextures[] newArray(int i2) {
            return new CameraEffectTextures[i2];
        }
    };
    private final Bundle textures;

    private CameraEffectTextures(Builder builder) {
        AppMethodBeat.i(8390);
        this.textures = builder.textures;
        AppMethodBeat.o(8390);
    }

    CameraEffectTextures(Parcel parcel) {
        AppMethodBeat.i(8391);
        this.textures = parcel.readBundle(getClass().getClassLoader());
        AppMethodBeat.o(8391);
    }

    public Bitmap getTextureBitmap(String str) {
        AppMethodBeat.i(8392);
        Object obj = this.textures.get(str);
        if (obj instanceof Bitmap) {
            Bitmap bitmap = (Bitmap) obj;
            AppMethodBeat.o(8392);
            return bitmap;
        }
        AppMethodBeat.o(8392);
        return null;
    }

    public Uri getTextureUri(String str) {
        AppMethodBeat.i(8393);
        Object obj = this.textures.get(str);
        if (obj instanceof Uri) {
            Uri uri = (Uri) obj;
            AppMethodBeat.o(8393);
            return uri;
        }
        AppMethodBeat.o(8393);
        return null;
    }

    public Object get(String str) {
        AppMethodBeat.i(8394);
        Object obj = this.textures.get(str);
        AppMethodBeat.o(8394);
        return obj;
    }

    public Set<String> keySet() {
        AppMethodBeat.i(8395);
        Set<String> keySet = this.textures.keySet();
        AppMethodBeat.o(8395);
        return keySet;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(8396);
        parcel.writeBundle(this.textures);
        AppMethodBeat.o(8396);
    }

    static {
        AppMethodBeat.i(8397);
        AppMethodBeat.o(8397);
    }

    public static class Builder implements ShareModelBuilder<CameraEffectTextures, Builder> {
        private Bundle textures = new Bundle();

        public Builder() {
            AppMethodBeat.i(8381);
            AppMethodBeat.o(8381);
        }

        /* Return type fixed from 'com.facebook.share.model.ShareModelBuilder' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.share.model.ShareModel] */
        @Override // com.facebook.share.model.ShareModelBuilder
        public /* bridge */ /* synthetic */ Builder readFrom(CameraEffectTextures cameraEffectTextures) {
            AppMethodBeat.i(8388);
            Builder readFrom = readFrom(cameraEffectTextures);
            AppMethodBeat.o(8388);
            return readFrom;
        }

        public Builder putTexture(String str, Bitmap bitmap) {
            AppMethodBeat.i(8382);
            Builder putParcelableTexture = putParcelableTexture(str, bitmap);
            AppMethodBeat.o(8382);
            return putParcelableTexture;
        }

        public Builder putTexture(String str, Uri uri) {
            AppMethodBeat.i(8383);
            Builder putParcelableTexture = putParcelableTexture(str, uri);
            AppMethodBeat.o(8383);
            return putParcelableTexture;
        }

        private Builder putParcelableTexture(String str, Parcelable parcelable) {
            AppMethodBeat.i(8384);
            if (!Utility.isNullOrEmpty(str) && parcelable != null) {
                this.textures.putParcelable(str, parcelable);
            }
            AppMethodBeat.o(8384);
            return this;
        }

        public Builder readFrom(CameraEffectTextures cameraEffectTextures) {
            AppMethodBeat.i(8385);
            if (cameraEffectTextures != null) {
                this.textures.putAll(cameraEffectTextures.textures);
            }
            AppMethodBeat.o(8385);
            return this;
        }

        public Builder readFrom(Parcel parcel) {
            AppMethodBeat.i(8386);
            Builder readFrom = readFrom((CameraEffectTextures) parcel.readParcelable(CameraEffectTextures.class.getClassLoader()));
            AppMethodBeat.o(8386);
            return readFrom;
        }

        @Override // com.facebook.share.ShareBuilder
        public CameraEffectTextures build() {
            AppMethodBeat.i(8387);
            CameraEffectTextures cameraEffectTextures = new CameraEffectTextures(this);
            AppMethodBeat.o(8387);
            return cameraEffectTextures;
        }
    }
}
