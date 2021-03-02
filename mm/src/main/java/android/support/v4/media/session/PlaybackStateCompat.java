package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new Parcelable.Creator<PlaybackStateCompat>() {
        /* class android.support.v4.media.session.PlaybackStateCompat.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PlaybackStateCompat[] newArray(int i2) {
            return new PlaybackStateCompat[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }
    };
    final long Nd;
    final float Ne;
    final long Nf;
    final CharSequence Ng;
    final long Nh;
    List<CustomAction> Ni;
    final long Nj;
    private Object Nk;
    final int mErrorCode;
    final Bundle mExtras;
    final long mPosition;
    final int mState;

    private PlaybackStateCompat(int i2, long j2, long j3, float f2, long j4, CharSequence charSequence, long j5, List<CustomAction> list, long j6, Bundle bundle) {
        this.mState = i2;
        this.mPosition = j2;
        this.Nd = j3;
        this.Ne = f2;
        this.Nf = j4;
        this.mErrorCode = 0;
        this.Ng = charSequence;
        this.Nh = j5;
        this.Ni = new ArrayList(list);
        this.Nj = j6;
        this.mExtras = bundle;
    }

    PlaybackStateCompat(Parcel parcel) {
        this.mState = parcel.readInt();
        this.mPosition = parcel.readLong();
        this.Ne = parcel.readFloat();
        this.Nh = parcel.readLong();
        this.Nd = parcel.readLong();
        this.Nf = parcel.readLong();
        this.Ng = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.Ni = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.Nj = parcel.readLong();
        this.mExtras = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.mErrorCode = parcel.readInt();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PlaybackState {");
        sb.append("state=").append(this.mState);
        sb.append(", position=").append(this.mPosition);
        sb.append(", buffered position=").append(this.Nd);
        sb.append(", speed=").append(this.Ne);
        sb.append(", updated=").append(this.Nh);
        sb.append(", actions=").append(this.Nf);
        sb.append(", error code=").append(this.mErrorCode);
        sb.append(", error message=").append(this.Ng);
        sb.append(", custom actions=").append(this.Ni);
        sb.append(", active item id=").append(this.Nj);
        sb.append("}");
        return sb.toString();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.mState);
        parcel.writeLong(this.mPosition);
        parcel.writeFloat(this.Ne);
        parcel.writeLong(this.Nh);
        parcel.writeLong(this.Nd);
        parcel.writeLong(this.Nf);
        TextUtils.writeToParcel(this.Ng, parcel, i2);
        parcel.writeTypedList(this.Ni);
        parcel.writeLong(this.Nj);
        parcel.writeBundle(this.mExtras);
        parcel.writeInt(this.mErrorCode);
    }

    public static PlaybackStateCompat B(Object obj) {
        Bundle bundle;
        if (obj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        List<PlaybackState.CustomAction> customActions = ((PlaybackState) obj).getCustomActions();
        ArrayList arrayList = null;
        if (customActions != null) {
            arrayList = new ArrayList(customActions.size());
            for (PlaybackState.CustomAction customAction : customActions) {
                arrayList.add(CustomAction.C(customAction));
            }
        }
        if (Build.VERSION.SDK_INT >= 22) {
            bundle = ((PlaybackState) obj).getExtras();
        } else {
            bundle = null;
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(((PlaybackState) obj).getState(), ((PlaybackState) obj).getPosition(), ((PlaybackState) obj).getBufferedPosition(), ((PlaybackState) obj).getPlaybackSpeed(), ((PlaybackState) obj).getActions(), ((PlaybackState) obj).getErrorMessage(), ((PlaybackState) obj).getLastPositionUpdateTime(), arrayList, ((PlaybackState) obj).getActiveQueueItemId(), bundle);
        playbackStateCompat.Nk = obj;
        return playbackStateCompat;
    }

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new Parcelable.Creator<CustomAction>() {
            /* class android.support.v4.media.session.PlaybackStateCompat.CustomAction.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ CustomAction[] newArray(int i2) {
                return new CustomAction[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }
        };
        private final int Hm;
        private final String Nl;
        private final CharSequence Nm;
        private Object Nn;
        private final Bundle mExtras;

        private CustomAction(String str, CharSequence charSequence, int i2, Bundle bundle) {
            this.Nl = str;
            this.Nm = charSequence;
            this.Hm = i2;
            this.mExtras = bundle;
        }

        CustomAction(Parcel parcel) {
            this.Nl = parcel.readString();
            this.Nm = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.Hm = parcel.readInt();
            this.mExtras = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.Nl);
            TextUtils.writeToParcel(this.Nm, parcel, i2);
            parcel.writeInt(this.Hm);
            parcel.writeBundle(this.mExtras);
        }

        public final int describeContents() {
            return 0;
        }

        public static CustomAction C(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            CustomAction customAction = new CustomAction(((PlaybackState.CustomAction) obj).getAction(), ((PlaybackState.CustomAction) obj).getName(), ((PlaybackState.CustomAction) obj).getIcon(), ((PlaybackState.CustomAction) obj).getExtras());
            customAction.Nn = obj;
            return customAction;
        }

        public final String toString() {
            return "Action:mName='" + ((Object) this.Nm) + ", mIcon=" + this.Hm + ", mExtras=" + this.mExtras;
        }
    }
}
