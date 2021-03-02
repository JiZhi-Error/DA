package com.tencent.qqmusic.mediaplayer.audioplaylist;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TrackInfo extends AudioPlayListItemInfo {
    public static final Parcelable.Creator<TrackInfo> CREATOR = new Parcelable.Creator<TrackInfo>() {
        /* class com.tencent.qqmusic.mediaplayer.audioplaylist.TrackInfo.AnonymousClass1 */

        @Override // android.os.Parcelable.Creator
        public final TrackInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(103517);
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            long readLong = parcel.readLong();
            long readLong2 = parcel.readLong();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            TrackInfo trackInfo = new TrackInfo(readInt);
            trackInfo.setFilePath(readString);
            trackInfo.setTitle(readString2);
            trackInfo.setStartPosition(readLong);
            trackInfo.setEndPostion(readLong2);
            trackInfo.setPerformer(readString3);
            trackInfo.setAlbum(readString4);
            AppMethodBeat.o(103517);
            return trackInfo;
        }

        @Override // android.os.Parcelable.Creator
        public final TrackInfo[] newArray(int i2) {
            return new TrackInfo[i2];
        }
    };
    private String mAlbum = "";
    private long mEndPostion;
    private String mPerformer = "";
    private long mStartPosition;
    private String mTitle = "";

    public TrackInfo(int i2) {
        this.mType = i2;
    }

    public void setFilePath(String str) {
        this.mUri = str;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void setStartPosition(long j2) {
        this.mStartPosition = j2;
    }

    public void setEndPostion(long j2) {
        this.mEndPostion = j2;
    }

    public void setPerformer(String str) {
        this.mPerformer = str;
    }

    public void setAlbum(String str) {
        this.mAlbum = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getPerformer() {
        return this.mPerformer;
    }

    public String getAlbum() {
        return this.mAlbum;
    }

    public Pair<Long, Long> getRange() {
        AppMethodBeat.i(103520);
        Pair<Long, Long> pair = new Pair<>(Long.valueOf(this.mStartPosition), Long.valueOf(this.mEndPostion));
        AppMethodBeat.o(103520);
        return pair;
    }

    public String getUri() {
        return this.mUri;
    }

    static {
        AppMethodBeat.i(103522);
        AppMethodBeat.o(103522);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(103521);
        parcel.writeInt(this.mType);
        parcel.writeString(this.mUri);
        parcel.writeString(this.mTitle);
        parcel.writeLong(this.mStartPosition);
        parcel.writeLong(this.mEndPostion);
        parcel.writeString(this.mPerformer);
        parcel.writeString(this.mAlbum);
        AppMethodBeat.o(103521);
    }
}
