package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Set;

public class CameraEffectArguments implements ShareModel {
    public static final Parcelable.Creator<CameraEffectArguments> CREATOR = new Parcelable.Creator<CameraEffectArguments>() {
        /* class com.facebook.share.model.CameraEffectArguments.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final CameraEffectArguments createFromParcel(Parcel parcel) {
            AppMethodBeat.i(8359);
            CameraEffectArguments cameraEffectArguments = new CameraEffectArguments(parcel);
            AppMethodBeat.o(8359);
            return cameraEffectArguments;
        }

        @Override // android.os.Parcelable.Creator
        public final CameraEffectArguments[] newArray(int i2) {
            return new CameraEffectArguments[i2];
        }
    };
    private final Bundle params;

    private CameraEffectArguments(Builder builder) {
        AppMethodBeat.i(8370);
        this.params = builder.params;
        AppMethodBeat.o(8370);
    }

    CameraEffectArguments(Parcel parcel) {
        AppMethodBeat.i(8371);
        this.params = parcel.readBundle(getClass().getClassLoader());
        AppMethodBeat.o(8371);
    }

    public String getString(String str) {
        AppMethodBeat.i(8372);
        String string = this.params.getString(str);
        AppMethodBeat.o(8372);
        return string;
    }

    public String[] getStringArray(String str) {
        AppMethodBeat.i(8373);
        String[] stringArray = this.params.getStringArray(str);
        AppMethodBeat.o(8373);
        return stringArray;
    }

    public Object get(String str) {
        AppMethodBeat.i(8374);
        Object obj = this.params.get(str);
        AppMethodBeat.o(8374);
        return obj;
    }

    public Set<String> keySet() {
        AppMethodBeat.i(8375);
        Set<String> keySet = this.params.keySet();
        AppMethodBeat.o(8375);
        return keySet;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(8376);
        parcel.writeBundle(this.params);
        AppMethodBeat.o(8376);
    }

    static {
        AppMethodBeat.i(8377);
        AppMethodBeat.o(8377);
    }

    public static class Builder implements ShareModelBuilder<CameraEffectArguments, Builder> {
        private Bundle params = new Bundle();

        public Builder() {
            AppMethodBeat.i(8362);
            AppMethodBeat.o(8362);
        }

        /* Return type fixed from 'com.facebook.share.model.ShareModelBuilder' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.share.model.ShareModel] */
        @Override // com.facebook.share.model.ShareModelBuilder
        public /* bridge */ /* synthetic */ Builder readFrom(CameraEffectArguments cameraEffectArguments) {
            AppMethodBeat.i(8368);
            Builder readFrom = readFrom(cameraEffectArguments);
            AppMethodBeat.o(8368);
            return readFrom;
        }

        public Builder putArgument(String str, String str2) {
            AppMethodBeat.i(8363);
            this.params.putString(str, str2);
            AppMethodBeat.o(8363);
            return this;
        }

        public Builder putArgument(String str, String[] strArr) {
            AppMethodBeat.i(8364);
            this.params.putStringArray(str, strArr);
            AppMethodBeat.o(8364);
            return this;
        }

        public Builder readFrom(CameraEffectArguments cameraEffectArguments) {
            AppMethodBeat.i(8365);
            if (cameraEffectArguments != null) {
                this.params.putAll(cameraEffectArguments.params);
            }
            AppMethodBeat.o(8365);
            return this;
        }

        public Builder readFrom(Parcel parcel) {
            AppMethodBeat.i(8366);
            Builder readFrom = readFrom((CameraEffectArguments) parcel.readParcelable(CameraEffectArguments.class.getClassLoader()));
            AppMethodBeat.o(8366);
            return readFrom;
        }

        @Override // com.facebook.share.ShareBuilder
        public CameraEffectArguments build() {
            AppMethodBeat.i(8367);
            CameraEffectArguments cameraEffectArguments = new CameraEffectArguments(this);
            AppMethodBeat.o(8367);
            return cameraEffectArguments;
        }
    }
}
