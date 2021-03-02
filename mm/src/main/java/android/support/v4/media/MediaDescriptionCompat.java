package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new Parcelable.Creator<MediaDescriptionCompat>() {
        /* class android.support.v4.media.MediaDescriptionCompat.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ MediaDescriptionCompat[] newArray(int i2) {
            return new MediaDescriptionCompat[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MediaDescriptionCompat createFromParcel(Parcel parcel) {
            if (Build.VERSION.SDK_INT < 21) {
                return new MediaDescriptionCompat(parcel);
            }
            return MediaDescriptionCompat.v(MediaDescription.CREATOR.createFromParcel(parcel));
        }
    };
    private final CharSequence Hn;
    final String Mc;
    private final CharSequence Md;
    private final CharSequence Me;
    private final Bitmap Mf;
    private final Uri Mg;
    private final Uri Mh;
    private Object Mi;
    private final Bundle mExtras;

    public static final class a {
        CharSequence Hn;
        String Mc;
        CharSequence Md;
        CharSequence Me;
        Bitmap Mf;
        Uri Mg;
        Uri Mh;
        Bundle mExtras;
    }

    private MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.Mc = str;
        this.Hn = charSequence;
        this.Md = charSequence2;
        this.Me = charSequence3;
        this.Mf = bitmap;
        this.Mg = uri;
        this.mExtras = bundle;
        this.Mh = uri2;
    }

    MediaDescriptionCompat(Parcel parcel) {
        this.Mc = parcel.readString();
        this.Hn = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.Md = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.Me = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        ClassLoader classLoader = getClass().getClassLoader();
        this.Mf = (Bitmap) parcel.readParcelable(classLoader);
        this.Mg = (Uri) parcel.readParcelable(classLoader);
        this.mExtras = parcel.readBundle(classLoader);
        this.Mh = (Uri) parcel.readParcelable(classLoader);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        Object obj;
        Bundle bundle;
        if (Build.VERSION.SDK_INT < 21) {
            parcel.writeString(this.Mc);
            TextUtils.writeToParcel(this.Hn, parcel, i2);
            TextUtils.writeToParcel(this.Md, parcel, i2);
            TextUtils.writeToParcel(this.Me, parcel, i2);
            parcel.writeParcelable(this.Mf, i2);
            parcel.writeParcelable(this.Mg, i2);
            parcel.writeBundle(this.mExtras);
            parcel.writeParcelable(this.Mh, i2);
            return;
        }
        if (this.Mi != null || Build.VERSION.SDK_INT < 21) {
            obj = this.Mi;
        } else {
            MediaDescription.Builder builder = new MediaDescription.Builder();
            builder.setMediaId(this.Mc);
            builder.setTitle(this.Hn);
            builder.setSubtitle(this.Md);
            builder.setDescription(this.Me);
            builder.setIconBitmap(this.Mf);
            builder.setIconUri(this.Mg);
            Bundle bundle2 = this.mExtras;
            if (Build.VERSION.SDK_INT >= 23 || this.Mh == null) {
                bundle = bundle2;
            } else {
                if (bundle2 == null) {
                    bundle2 = new Bundle();
                    bundle2.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
                }
                bundle2.putParcelable("android.support.v4.media.description.MEDIA_URI", this.Mh);
                bundle = bundle2;
            }
            builder.setExtras(bundle);
            if (Build.VERSION.SDK_INT >= 23) {
                builder.setMediaUri(this.Mh);
            }
            this.Mi = builder.build();
            obj = this.Mi;
        }
        ((MediaDescription) obj).writeToParcel(parcel, i2);
    }

    public final String toString() {
        return ((Object) this.Hn) + ", " + ((Object) this.Md) + ", " + ((Object) this.Me);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0099  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.v4.media.MediaDescriptionCompat v(java.lang.Object r9) {
        /*
        // Method dump skipped, instructions count: 173
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaDescriptionCompat.v(java.lang.Object):android.support.v4.media.MediaDescriptionCompat");
    }
}
