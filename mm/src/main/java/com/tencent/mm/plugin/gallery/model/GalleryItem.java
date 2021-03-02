package com.tencent.mm.plugin.gallery.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.loader.h.a.c;
import com.tencent.mm.plugin.gallery.model.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public final class GalleryItem {

    public static class AlbumItem implements Parcelable, Comparable<AlbumItem> {
        public static final Parcelable.Creator<AlbumItem> CREATOR = new Parcelable.Creator<AlbumItem>() {
            /* class com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ AlbumItem[] newArray(int i2) {
                return new AlbumItem[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ AlbumItem createFromParcel(Parcel parcel) {
                AppMethodBeat.i(111309);
                AlbumItem albumItem = new AlbumItem(parcel);
                AppMethodBeat.o(111309);
                return albumItem;
            }
        };
        String UXb;
        public MediaItem UXc;
        public boolean UXd = false;
        public boolean UXe = false;
        public boolean UXf = false;
        public String albumName;
        public int dJl;
        public String nickName;
        public int xiP = 0;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public /* synthetic */ int compareTo(AlbumItem albumItem) {
            AppMethodBeat.i(179455);
            AlbumItem albumItem2 = albumItem;
            if (this.UXc == null || albumItem2.UXc == null) {
                if (this.UXc != null) {
                    AppMethodBeat.o(179455);
                    return -1;
                } else if (albumItem2.UXc != null) {
                    AppMethodBeat.o(179455);
                    return 1;
                } else {
                    AppMethodBeat.o(179455);
                    return 0;
                }
            } else if (this.UXc.xja == albumItem2.UXc.xja) {
                int compare = Long.compare(albumItem2.UXc.xjb, this.UXc.xjb);
                AppMethodBeat.o(179455);
                return compare;
            } else if (this.UXc.xja > albumItem2.UXc.xja) {
                AppMethodBeat.o(179455);
                return -1;
            } else {
                AppMethodBeat.o(179455);
                return 1;
            }
        }

        public AlbumItem(String str, int i2) {
            AppMethodBeat.i(111310);
            this.albumName = Util.nullAsNil(str);
            this.dJl = i2;
            this.nickName = this.albumName;
            AppMethodBeat.o(111310);
        }

        protected AlbumItem(Parcel parcel) {
            AppMethodBeat.i(111311);
            this.albumName = parcel.readString();
            this.dJl = parcel.readInt();
            this.UXc = (MediaItem) parcel.readParcelable(MediaItem.class.getClassLoader());
            AppMethodBeat.o(111311);
        }

        static {
            AppMethodBeat.i(111314);
            AppMethodBeat.o(111314);
        }

        public final void c(MediaItem mediaItem) {
            this.UXc = mediaItem;
        }

        public final MediaItem hVO() {
            return this.UXc;
        }

        public String aQn() {
            AppMethodBeat.i(111312);
            if (this.UXc == null) {
                Log.e("MicroMsg.AlbumItem", "getThumbPath mediaItem is null");
                AppMethodBeat.o(111312);
                return null;
            }
            String aQn = this.UXc.aQn();
            AppMethodBeat.o(111312);
            return aQn;
        }

        public String dRh() {
            AppMethodBeat.i(173734);
            if (this.UXc == null) {
                Log.e("MicroMsg.AlbumItem", "getOriginalPath mediaItem is null");
                AppMethodBeat.o(173734);
                return null;
            }
            String str = this.UXc.xiW;
            AppMethodBeat.o(173734);
            return str;
        }

        public long dRi() {
            AppMethodBeat.i(173735);
            if (this.UXc == null) {
                Log.e("MicroMsg.AlbumItem", "getThumbMediaOrigId mediaItem is null");
                AppMethodBeat.o(173735);
                return -1;
            }
            long j2 = this.UXc.xiZ;
            AppMethodBeat.o(173735);
            return j2;
        }

        public int dRj() {
            AppMethodBeat.i(173736);
            if (this.UXc == null) {
                Log.e("MicroMsg.AlbumItem", "getThumbType mediaItem is null");
                AppMethodBeat.o(173736);
                return -1;
            }
            int type = this.UXc.getType();
            AppMethodBeat.o(173736);
            return type;
        }

        public final long hVP() {
            AppMethodBeat.i(179454);
            if (this.UXc == null) {
                Log.e("MicroMsg.AlbumItem", "getThumbModifyDate mediaItem is null");
                AppMethodBeat.o(179454);
                return -1;
            }
            long j2 = this.UXc.xja;
            AppMethodBeat.o(179454);
            return j2;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(111313);
            parcel.writeString(this.albumName);
            parcel.writeInt(this.dJl);
            parcel.writeParcelable(this.UXc, i2);
            AppMethodBeat.o(111313);
        }
    }

    public static class PrivateAlbumItem extends AlbumItem {
        public s.a xjf;

        @Override // com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem
        public final String aQn() {
            return this.xjf.xjM;
        }

        @Override // com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem
        public final String dRh() {
            return this.xjf.xjM;
        }

        @Override // com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem
        public final long dRi() {
            return this.xjf.xjL;
        }

        @Override // com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem
        public final int dRj() {
            s.b bVar = this.xjf.xjN;
            if (bVar == null || !bVar.xjP) {
                return 1;
            }
            return 2;
        }

        public PrivateAlbumItem(s.a aVar) {
            super(aVar.albumName, aVar.xjK);
            this.xjf = aVar;
        }
    }

    public static abstract class MediaItem implements Parcelable, c, Comparable<MediaItem> {
        public double cik;
        public double cil;
        public Object iMa;
        public String mMimeType;
        public String sUB;
        public String xiW;
        public String xiX;
        public String xiY;
        public long xiZ;
        public long xja;
        public long xjb;
        public String xjc;
        public boolean xjd;
        public HashMap<String, Object> xje;

        public abstract String aQn();

        public abstract int getType();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(MediaItem mediaItem) {
            return (int) ((this.xja - mediaItem.xja) / 1000);
        }

        public MediaItem() {
            this(0, "", "", "");
        }

        public MediaItem(long j2) {
            this(j2, "", "", "");
        }

        public MediaItem(long j2, String str, String str2, String str3) {
            this.cil = 181.0d;
            this.cik = 91.0d;
            this.xjd = false;
            this.xje = new HashMap<>();
            this.xiZ = j2;
            this.xiW = str;
            this.sUB = str2;
            this.mMimeType = str3;
        }

        @Override // com.tencent.mm.loader.h.a.c
        public final String auA() {
            return this.xiZ + "_" + this.xiW.hashCode();
        }

        public final String dRh() {
            return this.xiW;
        }

        public final void u(String str, Object obj) {
            this.xje.put(str, obj);
        }

        public final <T> T w(String str, T t) {
            T t2 = (T) this.xje.get(str);
            return t2 != null ? t2 : t;
        }

        public static MediaItem a(int i2, long j2, String str, String str2, String str3) {
            if (i2 == 1) {
                return new ImageMediaItem(j2, str, str2, str3);
            }
            return new VideoMediaItem(j2, str, str2, str3);
        }

        public static MediaItem ap(int i2, long j2) {
            if (i2 == 1) {
                return new ImageMediaItem(j2);
            }
            return new VideoMediaItem(j2);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof MediaItem)) {
                return false;
            }
            MediaItem mediaItem = (MediaItem) obj;
            if ((this.xiW == null || !this.xiW.equals(mediaItem.xiW)) && (this.mMimeType == null || !this.mMimeType.equals("edit") || this.xiX == null || !this.xiX.equals(mediaItem.xiW))) {
                return false;
            }
            return true;
        }

        public String toString() {
            return "MediaItem{mOriginalPath='" + this.xiW + '\'' + ", mThumbPath='" + this.sUB + '\'' + ", origId=" + this.xiZ + ", generateDate=" + this.xja + ", mMimeType='" + this.mMimeType + '\'' + ", mLongitude='" + this.cil + '\'' + ", mLatitude='" + this.cik + '\'' + ", mBusinessTag='" + this.xjc + '\'' + '}';
        }

        public final String toSimpleString() {
            return this.xiZ + " " + this.mMimeType + " " + this.xja + APLogFileUtil.SEPARATOR_LOG + this.xjb;
        }
    }

    public static class ImageMediaItem extends MediaItem {
        public static final Parcelable.Creator<MediaItem> CREATOR = new Parcelable.Creator<MediaItem>() {
            /* class com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ MediaItem[] newArray(int i2) {
                return new MediaItem[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ MediaItem createFromParcel(Parcel parcel) {
                AppMethodBeat.i(111315);
                ImageMediaItem imageMediaItem = new ImageMediaItem();
                imageMediaItem.xiW = parcel.readString();
                imageMediaItem.sUB = parcel.readString();
                imageMediaItem.xiZ = parcel.readLong();
                imageMediaItem.xja = parcel.readLong();
                imageMediaItem.mMimeType = parcel.readString();
                imageMediaItem.xje = (HashMap) parcel.readSerializable();
                AppMethodBeat.o(111315);
                return imageMediaItem;
            }
        };

        public ImageMediaItem() {
        }

        public ImageMediaItem(long j2) {
            super(j2);
        }

        public ImageMediaItem(long j2, String str, String str2, String str3) {
            super(j2, str, str2, str3);
        }

        @Override // com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem
        public final int getType() {
            return 1;
        }

        @Override // com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem
        public final String aQn() {
            AppMethodBeat.i(111316);
            if (!Util.isNullOrNil(this.sUB)) {
                String str = this.sUB;
                AppMethodBeat.o(111316);
                return str;
            }
            String str2 = this.xiW;
            AppMethodBeat.o(111316);
            return str2;
        }

        static {
            AppMethodBeat.i(111318);
            AppMethodBeat.o(111318);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(111317);
            parcel.writeString(this.xiW);
            parcel.writeString(this.sUB);
            parcel.writeLong(this.xiZ);
            parcel.writeLong(this.xja);
            parcel.writeString(this.mMimeType);
            parcel.writeSerializable(this.xje);
            AppMethodBeat.o(111317);
        }
    }

    public static class VideoMediaItem extends MediaItem {
        public static final Parcelable.Creator<MediaItem> CREATOR = new Parcelable.Creator<MediaItem>() {
            /* class com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ MediaItem[] newArray(int i2) {
                return new MediaItem[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ MediaItem createFromParcel(Parcel parcel) {
                AppMethodBeat.i(111319);
                VideoMediaItem videoMediaItem = new VideoMediaItem();
                videoMediaItem.xiW = parcel.readString();
                videoMediaItem.sUB = parcel.readString();
                videoMediaItem.xiZ = parcel.readLong();
                videoMediaItem.mMimeType = parcel.readString();
                videoMediaItem.videoWidth = parcel.readInt();
                videoMediaItem.videoHeight = parcel.readInt();
                videoMediaItem.jkS = parcel.readInt();
                videoMediaItem.jkQ = parcel.readString();
                videoMediaItem.jkR = parcel.readString();
                videoMediaItem.videoIFrameInterval = parcel.readInt();
                videoMediaItem.videoFrameRate = parcel.readInt();
                videoMediaItem.videoBitRate = parcel.readInt();
                videoMediaItem.ihS = parcel.readInt();
                videoMediaItem.xja = parcel.readLong();
                videoMediaItem.xje = (HashMap) parcel.readSerializable();
                AppMethodBeat.o(111319);
                return videoMediaItem;
            }
        };
        public int ihS = -1;
        public String jkQ;
        public String jkR;
        public int jkS = -1;
        public int videoBitRate = -1;
        public int videoFrameRate = -1;
        public int videoHeight = -1;
        public int videoIFrameInterval = -1;
        public int videoWidth = -1;

        public VideoMediaItem() {
        }

        public VideoMediaItem(long j2) {
            super(j2);
        }

        public VideoMediaItem(long j2, String str, String str2, String str3) {
            super(j2, str, str2, str3);
        }

        @Override // com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem
        public final int getType() {
            return 2;
        }

        @Override // com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem
        public final String aQn() {
            AppMethodBeat.i(111320);
            if (!Util.isNullOrNil(this.sUB)) {
                String str = this.sUB;
                AppMethodBeat.o(111320);
                return str;
            }
            String str2 = this.xiW;
            AppMethodBeat.o(111320);
            return str2;
        }

        static {
            AppMethodBeat.i(111323);
            AppMethodBeat.o(111323);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(111321);
            parcel.writeString(this.xiW);
            parcel.writeString(this.sUB);
            parcel.writeLong(this.xiZ);
            parcel.writeString(this.mMimeType);
            parcel.writeInt(this.videoWidth);
            parcel.writeInt(this.videoHeight);
            parcel.writeInt(this.jkS);
            parcel.writeString(this.jkQ);
            parcel.writeString(this.jkR);
            parcel.writeInt(this.videoIFrameInterval);
            parcel.writeInt(this.videoFrameRate);
            parcel.writeInt(this.videoBitRate);
            parcel.writeInt(this.ihS);
            parcel.writeLong(this.xja);
            parcel.writeSerializable(this.xje);
            AppMethodBeat.o(111321);
        }

        @Override // com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem
        public String toString() {
            AppMethodBeat.i(111322);
            String str = "VideoMediaItem{base=" + super.toString() + ", videoTrackMime='" + this.jkQ + '\'' + ", audioTrackMime='" + this.jkR + '\'' + ", durationMs=" + this.jkS + ", videoHeight=" + this.videoHeight + ", videoWidth=" + this.videoWidth + ", videoBitRate=" + this.videoBitRate + ", videoIFrameInterval=" + this.videoIFrameInterval + ", videoFrameRate=" + this.videoFrameRate + '}';
            AppMethodBeat.o(111322);
            return str;
        }
    }

    public static class a {
        public String key;
        public String path;
        public String xiU;
        public int xiV;

        public final String toString() {
            AppMethodBeat.i(173737);
            String str = "key: " + this.key + " path: " + this.path + " defaultName: " + this.xiU + " bucketID: " + this.xiV;
            AppMethodBeat.o(173737);
            return str;
        }
    }
}
