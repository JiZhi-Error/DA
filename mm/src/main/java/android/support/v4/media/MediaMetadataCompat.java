package android.support.v4.media;

import android.media.MediaMetadata;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.e.a;
import android.support.v4.media.session.MediaSessionCompat;

public final class MediaMetadataCompat implements Parcelable {
    public static final Parcelable.Creator<MediaMetadataCompat> CREATOR = new Parcelable.Creator<MediaMetadataCompat>() {
        /* class android.support.v4.media.MediaMetadataCompat.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ MediaMetadataCompat[] newArray(int i2) {
            return new MediaMetadataCompat[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MediaMetadataCompat createFromParcel(Parcel parcel) {
            return new MediaMetadataCompat(parcel);
        }
    };
    static final a<String, Integer> Mj;
    private static final String[] Mk = {"android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER"};
    private static final String[] Ml = {"android.media.metadata.DISPLAY_ICON", "android.media.metadata.ART", "android.media.metadata.ALBUM_ART"};
    private static final String[] Mm = {"android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART_URI"};
    private Object Mn;
    final Bundle mBundle;

    static {
        a<String, Integer> aVar = new a<>();
        Mj = aVar;
        aVar.put("android.media.metadata.TITLE", 1);
        Mj.put("android.media.metadata.ARTIST", 1);
        Mj.put("android.media.metadata.DURATION", 0);
        Mj.put("android.media.metadata.ALBUM", 1);
        Mj.put("android.media.metadata.AUTHOR", 1);
        Mj.put("android.media.metadata.WRITER", 1);
        Mj.put("android.media.metadata.COMPOSER", 1);
        Mj.put("android.media.metadata.COMPILATION", 1);
        Mj.put("android.media.metadata.DATE", 1);
        Mj.put("android.media.metadata.YEAR", 0);
        Mj.put("android.media.metadata.GENRE", 1);
        Mj.put("android.media.metadata.TRACK_NUMBER", 0);
        Mj.put("android.media.metadata.NUM_TRACKS", 0);
        Mj.put("android.media.metadata.DISC_NUMBER", 0);
        Mj.put("android.media.metadata.ALBUM_ARTIST", 1);
        Mj.put("android.media.metadata.ART", 2);
        Mj.put("android.media.metadata.ART_URI", 1);
        Mj.put("android.media.metadata.ALBUM_ART", 2);
        Mj.put("android.media.metadata.ALBUM_ART_URI", 1);
        Mj.put("android.media.metadata.USER_RATING", 3);
        Mj.put("android.media.metadata.RATING", 3);
        Mj.put("android.media.metadata.DISPLAY_TITLE", 1);
        Mj.put("android.media.metadata.DISPLAY_SUBTITLE", 1);
        Mj.put("android.media.metadata.DISPLAY_DESCRIPTION", 1);
        Mj.put("android.media.metadata.DISPLAY_ICON", 2);
        Mj.put("android.media.metadata.DISPLAY_ICON_URI", 1);
        Mj.put("android.media.metadata.MEDIA_ID", 1);
        Mj.put("android.media.metadata.BT_FOLDER_TYPE", 0);
        Mj.put("android.media.metadata.MEDIA_URI", 1);
        Mj.put("android.media.metadata.ADVERTISEMENT", 0);
        Mj.put("android.media.metadata.DOWNLOAD_STATUS", 0);
    }

    MediaMetadataCompat(Parcel parcel) {
        this.mBundle = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeBundle(this.mBundle);
    }

    public static MediaMetadataCompat w(Object obj) {
        if (obj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        ((MediaMetadata) obj).writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        MediaMetadataCompat createFromParcel = CREATOR.createFromParcel(obtain);
        obtain.recycle();
        createFromParcel.Mn = obj;
        return createFromParcel;
    }
}
