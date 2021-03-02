package com.facebook.share.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareModel;
import com.facebook.share.model.ShareModelBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public class LikeContent implements ShareModel {
    @Deprecated
    public static final Parcelable.Creator<LikeContent> CREATOR = new Parcelable.Creator<LikeContent>() {
        /* class com.facebook.share.internal.LikeContent.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final LikeContent createFromParcel(Parcel parcel) {
            AppMethodBeat.i(8112);
            LikeContent likeContent = new LikeContent(parcel);
            AppMethodBeat.o(8112);
            return likeContent;
        }

        @Override // android.os.Parcelable.Creator
        public final LikeContent[] newArray(int i2) {
            return new LikeContent[i2];
        }
    };
    private final String objectId;
    private final String objectType;

    private LikeContent(Builder builder) {
        AppMethodBeat.i(8119);
        this.objectId = builder.objectId;
        this.objectType = builder.objectType;
        AppMethodBeat.o(8119);
    }

    @Deprecated
    LikeContent(Parcel parcel) {
        AppMethodBeat.i(8120);
        this.objectId = parcel.readString();
        this.objectType = parcel.readString();
        AppMethodBeat.o(8120);
    }

    @Deprecated
    public String getObjectId() {
        return this.objectId;
    }

    @Deprecated
    public String getObjectType() {
        return this.objectType;
    }

    @Deprecated
    public int describeContents() {
        return 0;
    }

    @Deprecated
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(8121);
        parcel.writeString(this.objectId);
        parcel.writeString(this.objectType);
        AppMethodBeat.o(8121);
    }

    static {
        AppMethodBeat.i(8122);
        AppMethodBeat.o(8122);
    }

    @Deprecated
    public static class Builder implements ShareModelBuilder<LikeContent, Builder> {
        private String objectId;
        private String objectType;

        /* Return type fixed from 'com.facebook.share.model.ShareModelBuilder' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.share.model.ShareModel] */
        @Override // com.facebook.share.model.ShareModelBuilder
        @Deprecated
        public /* bridge */ /* synthetic */ Builder readFrom(LikeContent likeContent) {
            AppMethodBeat.i(8117);
            Builder readFrom = readFrom(likeContent);
            AppMethodBeat.o(8117);
            return readFrom;
        }

        @Deprecated
        public Builder setObjectId(String str) {
            this.objectId = str;
            return this;
        }

        @Deprecated
        public Builder setObjectType(String str) {
            this.objectType = str;
            return this;
        }

        @Override // com.facebook.share.ShareBuilder
        @Deprecated
        public LikeContent build() {
            AppMethodBeat.i(8115);
            LikeContent likeContent = new LikeContent(this);
            AppMethodBeat.o(8115);
            return likeContent;
        }

        @Deprecated
        public Builder readFrom(LikeContent likeContent) {
            AppMethodBeat.i(8116);
            if (likeContent == null) {
                AppMethodBeat.o(8116);
                return this;
            }
            Builder objectType2 = setObjectId(likeContent.getObjectId()).setObjectType(likeContent.getObjectType());
            AppMethodBeat.o(8116);
            return objectType2;
        }
    }
}
