package com.facebook.share.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public abstract class ShareMedia implements ShareModel {
    private final Bundle params;

    public abstract Type getMediaType();

    public enum Type {
        PHOTO,
        VIDEO;

        public static Type valueOf(String str) {
            AppMethodBeat.i(8456);
            Type type = (Type) Enum.valueOf(Type.class, str);
            AppMethodBeat.o(8456);
            return type;
        }

        static {
            AppMethodBeat.i(8457);
            AppMethodBeat.o(8457);
        }
    }

    protected ShareMedia(Builder builder) {
        this.params = new Bundle(builder.params);
    }

    ShareMedia(Parcel parcel) {
        this.params = parcel.readBundle();
    }

    @Deprecated
    public Bundle getParameters() {
        return new Bundle(this.params);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeBundle(this.params);
    }

    public static abstract class Builder<M extends ShareMedia, B extends Builder> implements ShareModelBuilder<M, B> {
        private Bundle params = new Bundle();

        @Deprecated
        public B setParameter(String str, String str2) {
            this.params.putString(str, str2);
            return this;
        }

        @Deprecated
        public B setParameters(Bundle bundle) {
            this.params.putAll(bundle);
            return this;
        }

        public B readFrom(M m) {
            return m == null ? this : setParameters(m.getParameters());
        }

        static void writeListTo(Parcel parcel, int i2, List<ShareMedia> list) {
            parcel.writeParcelableArray((ShareMedia[]) list.toArray(), i2);
        }

        static List<ShareMedia> readListFrom(Parcel parcel) {
            Parcelable[] readParcelableArray = parcel.readParcelableArray(ShareMedia.class.getClassLoader());
            ArrayList arrayList = new ArrayList(readParcelableArray.length);
            for (Parcelable parcelable : readParcelableArray) {
                arrayList.add((ShareMedia) parcelable);
            }
            return arrayList;
        }
    }
}
