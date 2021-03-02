package com.facebook.share.model;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.model.ShareMedia;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class SharePhoto extends ShareMedia {
    public static final Parcelable.Creator<SharePhoto> CREATOR = new Parcelable.Creator<SharePhoto>() {
        /* class com.facebook.share.model.SharePhoto.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final SharePhoto createFromParcel(Parcel parcel) {
            AppMethodBeat.i(8575);
            SharePhoto sharePhoto = new SharePhoto(parcel);
            AppMethodBeat.o(8575);
            return sharePhoto;
        }

        @Override // android.os.Parcelable.Creator
        public final SharePhoto[] newArray(int i2) {
            return new SharePhoto[i2];
        }
    };
    private final Bitmap bitmap;
    private final String caption;
    private final Uri imageUrl;
    private final boolean userGenerated;

    private SharePhoto(Builder builder) {
        super(builder);
        AppMethodBeat.i(8586);
        this.bitmap = builder.bitmap;
        this.imageUrl = builder.imageUrl;
        this.userGenerated = builder.userGenerated;
        this.caption = builder.caption;
        AppMethodBeat.o(8586);
    }

    SharePhoto(Parcel parcel) {
        super(parcel);
        AppMethodBeat.i(8587);
        this.bitmap = (Bitmap) parcel.readParcelable(Bitmap.class.getClassLoader());
        this.imageUrl = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.userGenerated = parcel.readByte() != 0;
        this.caption = parcel.readString();
        AppMethodBeat.o(8587);
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final Uri getImageUrl() {
        return this.imageUrl;
    }

    public final boolean getUserGenerated() {
        return this.userGenerated;
    }

    public final String getCaption() {
        return this.caption;
    }

    @Override // com.facebook.share.model.ShareMedia
    public final int describeContents() {
        return 0;
    }

    @Override // com.facebook.share.model.ShareMedia
    public final void writeToParcel(Parcel parcel, int i2) {
        int i3 = 0;
        AppMethodBeat.i(8588);
        super.writeToParcel(parcel, i2);
        parcel.writeParcelable(this.bitmap, 0);
        parcel.writeParcelable(this.imageUrl, 0);
        if (this.userGenerated) {
            i3 = 1;
        }
        parcel.writeByte((byte) i3);
        parcel.writeString(this.caption);
        AppMethodBeat.o(8588);
    }

    static {
        AppMethodBeat.i(8589);
        AppMethodBeat.o(8589);
    }

    @Override // com.facebook.share.model.ShareMedia
    public final ShareMedia.Type getMediaType() {
        return ShareMedia.Type.PHOTO;
    }

    public static final class Builder extends ShareMedia.Builder<SharePhoto, Builder> {
        private Bitmap bitmap;
        private String caption;
        private Uri imageUrl;
        private boolean userGenerated;

        /* Return type fixed from 'com.facebook.share.model.ShareMedia$Builder' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.facebook.share.model.ShareMedia] */
        @Override // com.facebook.share.model.ShareMedia.Builder
        public final /* bridge */ /* synthetic */ Builder readFrom(SharePhoto sharePhoto) {
            AppMethodBeat.i(8583);
            Builder readFrom = readFrom(sharePhoto);
            AppMethodBeat.o(8583);
            return readFrom;
        }

        @Override // com.facebook.share.model.ShareMedia.Builder, com.facebook.share.model.ShareModelBuilder
        public final /* bridge */ /* synthetic */ ShareModelBuilder readFrom(ShareModel shareModel) {
            AppMethodBeat.i(8584);
            Builder readFrom = readFrom((SharePhoto) shareModel);
            AppMethodBeat.o(8584);
            return readFrom;
        }

        public final Builder setBitmap(Bitmap bitmap2) {
            this.bitmap = bitmap2;
            return this;
        }

        public final Builder setImageUrl(Uri uri) {
            this.imageUrl = uri;
            return this;
        }

        public final Builder setUserGenerated(boolean z) {
            this.userGenerated = z;
            return this;
        }

        public final Builder setCaption(String str) {
            this.caption = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        public final Uri getImageUrl() {
            return this.imageUrl;
        }

        /* access modifiers changed from: package-private */
        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        @Override // com.facebook.share.ShareBuilder
        public final SharePhoto build() {
            AppMethodBeat.i(8578);
            SharePhoto sharePhoto = new SharePhoto(this);
            AppMethodBeat.o(8578);
            return sharePhoto;
        }

        public final Builder readFrom(SharePhoto sharePhoto) {
            AppMethodBeat.i(8579);
            if (sharePhoto == null) {
                AppMethodBeat.o(8579);
                return this;
            }
            Builder caption2 = ((Builder) super.readFrom((ShareMedia) sharePhoto)).setBitmap(sharePhoto.getBitmap()).setImageUrl(sharePhoto.getImageUrl()).setUserGenerated(sharePhoto.getUserGenerated()).setCaption(sharePhoto.getCaption());
            AppMethodBeat.o(8579);
            return caption2;
        }

        /* access modifiers changed from: package-private */
        public final Builder readFrom(Parcel parcel) {
            AppMethodBeat.i(8580);
            Builder readFrom = readFrom((SharePhoto) parcel.readParcelable(SharePhoto.class.getClassLoader()));
            AppMethodBeat.o(8580);
            return readFrom;
        }

        static void writePhotoListTo(Parcel parcel, int i2, List<SharePhoto> list) {
            AppMethodBeat.i(8581);
            ShareMedia[] shareMediaArr = new ShareMedia[list.size()];
            for (int i3 = 0; i3 < list.size(); i3++) {
                shareMediaArr[i3] = list.get(i3);
            }
            parcel.writeParcelableArray(shareMediaArr, i2);
            AppMethodBeat.o(8581);
        }

        static List<SharePhoto> readPhotoListFrom(Parcel parcel) {
            AppMethodBeat.i(8582);
            List<ShareMedia> readListFrom = readListFrom(parcel);
            ArrayList arrayList = new ArrayList();
            for (ShareMedia shareMedia : readListFrom) {
                if (shareMedia instanceof SharePhoto) {
                    arrayList.add((SharePhoto) shareMedia);
                }
            }
            AppMethodBeat.o(8582);
            return arrayList;
        }
    }
}
