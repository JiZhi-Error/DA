package com.facebook.share.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ShareHashtag implements ShareModel {
    public static final Parcelable.Creator<ShareHashtag> CREATOR = new Parcelable.Creator<ShareHashtag>() {
        /* class com.facebook.share.model.ShareHashtag.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final ShareHashtag createFromParcel(Parcel parcel) {
            AppMethodBeat.i(8430);
            ShareHashtag shareHashtag = new ShareHashtag(parcel);
            AppMethodBeat.o(8430);
            return shareHashtag;
        }

        @Override // android.os.Parcelable.Creator
        public final ShareHashtag[] newArray(int i2) {
            return new ShareHashtag[i2];
        }
    };
    private final String hashtag;

    private ShareHashtag(Builder builder) {
        AppMethodBeat.i(8438);
        this.hashtag = builder.hashtag;
        AppMethodBeat.o(8438);
    }

    ShareHashtag(Parcel parcel) {
        AppMethodBeat.i(8439);
        this.hashtag = parcel.readString();
        AppMethodBeat.o(8439);
    }

    public String getHashtag() {
        return this.hashtag;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(8440);
        parcel.writeString(this.hashtag);
        AppMethodBeat.o(8440);
    }

    static {
        AppMethodBeat.i(8441);
        AppMethodBeat.o(8441);
    }

    public static class Builder implements ShareModelBuilder<ShareHashtag, Builder> {
        private String hashtag;

        /* Return type fixed from 'com.facebook.share.model.ShareModelBuilder' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.share.model.ShareModel] */
        @Override // com.facebook.share.model.ShareModelBuilder
        public /* bridge */ /* synthetic */ Builder readFrom(ShareHashtag shareHashtag) {
            AppMethodBeat.i(8436);
            Builder readFrom = readFrom(shareHashtag);
            AppMethodBeat.o(8436);
            return readFrom;
        }

        public Builder setHashtag(String str) {
            this.hashtag = str;
            return this;
        }

        public String getHashtag() {
            return this.hashtag;
        }

        public Builder readFrom(ShareHashtag shareHashtag) {
            AppMethodBeat.i(8433);
            if (shareHashtag == null) {
                AppMethodBeat.o(8433);
                return this;
            }
            Builder hashtag2 = setHashtag(shareHashtag.getHashtag());
            AppMethodBeat.o(8433);
            return hashtag2;
        }

        /* access modifiers changed from: package-private */
        public Builder readFrom(Parcel parcel) {
            AppMethodBeat.i(8434);
            Builder readFrom = readFrom((ShareHashtag) parcel.readParcelable(ShareHashtag.class.getClassLoader()));
            AppMethodBeat.o(8434);
            return readFrom;
        }

        @Override // com.facebook.share.ShareBuilder
        public ShareHashtag build() {
            AppMethodBeat.i(8435);
            ShareHashtag shareHashtag = new ShareHashtag(this);
            AppMethodBeat.o(8435);
            return shareHashtag;
        }
    }
}
