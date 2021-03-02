package android.support.v4.media.session;

import android.media.session.MediaSession;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import java.util.ArrayList;
import java.util.List;

public class MediaSessionCompat {
    public static void d(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new Parcelable.Creator<Token>() {
            /* class android.support.v4.media.session.MediaSessionCompat.Token.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ Token[] newArray(int i2) {
                return new Token[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Token createFromParcel(Parcel parcel) {
                Object readStrongBinder;
                if (Build.VERSION.SDK_INT >= 21) {
                    readStrongBinder = parcel.readParcelable(null);
                } else {
                    readStrongBinder = parcel.readStrongBinder();
                }
                return new Token(readStrongBinder);
            }
        };
        final Object MV;
        b MW;
        Bundle MX;

        Token(Object obj) {
            this(obj, null, (byte) 0);
        }

        private Token(Object obj, b bVar) {
            this(obj, bVar, (byte) 0);
        }

        private Token(Object obj, b bVar, byte b2) {
            this.MV = obj;
            this.MW = bVar;
            this.MX = null;
        }

        public static Token z(Object obj) {
            return a(obj, null);
        }

        public static Token a(Object obj, b bVar) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            return new Token(d.A(obj), bVar);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            if (Build.VERSION.SDK_INT >= 21) {
                parcel.writeParcelable((Parcelable) this.MV, i2);
            } else {
                parcel.writeStrongBinder((IBinder) this.MV);
            }
        }

        public final int hashCode() {
            if (this.MV == null) {
                return 0;
            }
            return this.MV.hashCode();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            if (this.MV == null) {
                return token.MV == null;
            }
            if (token.MV == null) {
                return false;
            }
            return this.MV.equals(token.MV);
        }
    }

    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new Parcelable.Creator<QueueItem>() {
            /* class android.support.v4.media.session.MediaSessionCompat.QueueItem.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ QueueItem[] newArray(int i2) {
                return new QueueItem[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }
        };
        private final MediaDescriptionCompat Ln;
        private final long MS;
        private Object MT;

        private QueueItem(Object obj, MediaDescriptionCompat mediaDescriptionCompat, long j2) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null.");
            } else if (j2 == -1) {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            } else {
                this.Ln = mediaDescriptionCompat;
                this.MS = j2;
                this.MT = obj;
            }
        }

        QueueItem(Parcel parcel) {
            this.Ln = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.MS = parcel.readLong();
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            this.Ln.writeToParcel(parcel, i2);
            parcel.writeLong(this.MS);
        }

        public final int describeContents() {
            return 0;
        }

        public static List<QueueItem> l(List<?> list) {
            if (list == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                arrayList.add((obj == null || Build.VERSION.SDK_INT < 21) ? null : new QueueItem(obj, MediaDescriptionCompat.v(((MediaSession.QueueItem) obj).getDescription()), ((MediaSession.QueueItem) obj).getQueueId()));
            }
            return arrayList;
        }

        public final String toString() {
            return "MediaSession.QueueItem {Description=" + this.Ln + ", Id=" + this.MS + " }";
        }
    }

    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new Parcelable.Creator<ResultReceiverWrapper>() {
            /* class android.support.v4.media.session.MediaSessionCompat.ResultReceiverWrapper.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ ResultReceiverWrapper[] newArray(int i2) {
                return new ResultReceiverWrapper[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }
        };
        ResultReceiver MU;

        ResultReceiverWrapper(Parcel parcel) {
            this.MU = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            this.MU.writeToParcel(parcel, i2);
        }
    }
}
