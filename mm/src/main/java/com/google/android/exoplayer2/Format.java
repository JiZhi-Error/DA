package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.video.ColorInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetABTestConfig;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class Format implements Parcelable {
    public static final Parcelable.Creator<Format> CREATOR = new Parcelable.Creator<Format>() {
        /* class com.google.android.exoplayer2.Format.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Format[] newArray(int i2) {
            return new Format[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Format createFromParcel(Parcel parcel) {
            AppMethodBeat.i(92314);
            Format format = new Format(parcel);
            AppMethodBeat.o(92314);
            return format;
        }
    };
    private int aHK;
    public final int bdA;
    public final int bdB;
    public final long bdC;
    public final int bdD;
    public final int bdE;
    public final String bdn;
    public final Metadata bdo;
    public final String bdp;
    public final String bdq;
    public final int bdr;
    public final List<byte[]> bds;
    public final DrmInitData bdt;
    public final float bdu;
    public final int bdv;
    public final float bdw;
    public final int bdx;
    public final byte[] bdy;
    public final ColorInfo bdz;
    public final int bitrate;
    public final int channelCount;
    public final int height;
    public final String id;
    public final String language;
    public final int pcmEncoding;
    public final int sampleRate;
    public final int width;

    public static Format a(String str, String str2, String str3, int i2, int i3, int i4) {
        AppMethodBeat.i(196030);
        Format format = new Format(str, str2, null, str3, i2, -1, i3, i4, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, MAlarmHandler.NEXT_FIRE_INTERVAL, null, null, null);
        AppMethodBeat.o(196030);
        return format;
    }

    public static Format a(String str, String str2, int i2, int i3, List<byte[]> list, float f2) {
        AppMethodBeat.i(92316);
        Format a2 = a(str, str2, -1, i2, i3, list, -1, f2, null, -1, null, null);
        AppMethodBeat.o(92316);
        return a2;
    }

    public static Format a(String str, String str2, int i2, int i3, int i4, List<byte[]> list, int i5, float f2, byte[] bArr, int i6, ColorInfo colorInfo, DrmInitData drmInitData) {
        AppMethodBeat.i(92317);
        Format format = new Format(str, null, str2, null, -1, i2, i3, i4, -1.0f, i5, f2, bArr, i6, colorInfo, -1, -1, -1, -1, -1, 0, null, -1, MAlarmHandler.NEXT_FIRE_INTERVAL, list, drmInitData, null);
        AppMethodBeat.o(92317);
        return format;
    }

    public static Format a(String str, String str2, int i2, String str3) {
        AppMethodBeat.i(196031);
        Format format = new Format(str, str2, null, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i2, str3, -1, MAlarmHandler.NEXT_FIRE_INTERVAL, null, null, null);
        AppMethodBeat.o(196031);
        return format;
    }

    public static Format a(String str, String str2, int i2, int i3, int i4, int i5, List<byte[]> list, DrmInitData drmInitData, String str3) {
        AppMethodBeat.i(92319);
        Format a2 = a(str, str2, i2, i3, i4, i5, -1, list, drmInitData, 0, str3);
        AppMethodBeat.o(92319);
        return a2;
    }

    public static Format a(String str, String str2, int i2, int i3, int i4, int i5, int i6, List<byte[]> list, DrmInitData drmInitData, int i7, String str3) {
        AppMethodBeat.i(92320);
        Format a2 = a(str, str2, null, i2, i3, i4, i5, i6, -1, -1, list, drmInitData, i7, str3, null);
        AppMethodBeat.o(92320);
        return a2;
    }

    public static Format a(String str, String str2, String str3, int i2, int i3, int i4, int i5, int i6, int i7, int i8, List<byte[]> list, DrmInitData drmInitData, int i9, String str4, Metadata metadata) {
        AppMethodBeat.i(196032);
        Format format = new Format(str, null, str2, null, i2, i3, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i4, i5, i6, i7, i8, i9, str4, -1, MAlarmHandler.NEXT_FIRE_INTERVAL, list, drmInitData, metadata);
        AppMethodBeat.o(196032);
        return format;
    }

    public static Format a(String str, String str2, String str3, int i2, String str4) {
        AppMethodBeat.i(196033);
        Format a2 = a(str, str2, str3, i2, str4, -1);
        AppMethodBeat.o(196033);
        return a2;
    }

    public static Format a(String str, String str2, String str3, int i2, String str4, int i3) {
        AppMethodBeat.i(196034);
        Format format = new Format(str, str2, str3, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i2, str4, i3, MAlarmHandler.NEXT_FIRE_INTERVAL, null, null, null);
        AppMethodBeat.o(196034);
        return format;
    }

    public static Format bc(String str) {
        AppMethodBeat.i(196035);
        Format a2 = a((String) null, str, 0, (String) null, (DrmInitData) null);
        AppMethodBeat.o(196035);
        return a2;
    }

    public static Format a(String str, String str2, int i2, String str3, DrmInitData drmInitData) {
        AppMethodBeat.i(92325);
        Format a2 = a(str, str2, i2, str3, -1, drmInitData, MAlarmHandler.NEXT_FIRE_INTERVAL, Collections.emptyList());
        AppMethodBeat.o(92325);
        return a2;
    }

    public static Format a(String str, String str2, int i2, String str3, int i3) {
        AppMethodBeat.i(92326);
        Format a2 = a(str, str2, i2, str3, i3, null, MAlarmHandler.NEXT_FIRE_INTERVAL, Collections.emptyList());
        AppMethodBeat.o(92326);
        return a2;
    }

    public static Format a(String str, String str2, long j2) {
        AppMethodBeat.i(92327);
        Format a2 = a(null, str, 0, str2, -1, null, j2, Collections.emptyList());
        AppMethodBeat.o(92327);
        return a2;
    }

    public static Format a(String str, String str2, int i2, String str3, int i3, DrmInitData drmInitData, long j2, List<byte[]> list) {
        AppMethodBeat.i(92328);
        Format format = new Format(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i2, str3, i3, j2, list, drmInitData, null);
        AppMethodBeat.o(92328);
        return format;
    }

    public static Format a(String str, String str2, List<byte[]> list, String str3, DrmInitData drmInitData) {
        AppMethodBeat.i(92329);
        Format format = new Format(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, str3, -1, MAlarmHandler.NEXT_FIRE_INTERVAL, list, drmInitData, null);
        AppMethodBeat.o(92329);
        return format;
    }

    public static Format j(String str, String str2) {
        AppMethodBeat.i(196036);
        Format format = new Format(str, str2, null, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, MAlarmHandler.NEXT_FIRE_INTERVAL, null, null, null);
        AppMethodBeat.o(196036);
        return format;
    }

    public static Format d(String str, long j2) {
        AppMethodBeat.i(92331);
        Format format = new Format(null, null, str, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, j2, null, null, null);
        AppMethodBeat.o(92331);
        return format;
    }

    public static Format k(String str, String str2) {
        AppMethodBeat.i(92332);
        Format format = new Format(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, MAlarmHandler.NEXT_FIRE_INTERVAL, null, null, null);
        AppMethodBeat.o(92332);
        return format;
    }

    private Format(String str, String str2, String str3, String str4, int i2, int i3, int i4, int i5, float f2, int i6, float f3, byte[] bArr, int i7, ColorInfo colorInfo, int i8, int i9, int i10, int i11, int i12, int i13, String str5, int i14, long j2, List<byte[]> list, DrmInitData drmInitData, Metadata metadata) {
        AppMethodBeat.i(92333);
        this.id = str;
        this.bdp = str2;
        this.bdq = str3;
        this.bdn = str4;
        this.bitrate = i2;
        this.bdr = i3;
        this.width = i4;
        this.height = i5;
        this.bdu = f2;
        this.bdv = i6;
        this.bdw = f3;
        this.bdy = bArr;
        this.bdx = i7;
        this.bdz = colorInfo;
        this.channelCount = i8;
        this.sampleRate = i9;
        this.pcmEncoding = i10;
        this.bdA = i11;
        this.bdB = i12;
        this.bdD = i13;
        this.language = str5;
        this.bdE = i14;
        this.bdC = j2;
        this.bds = list == null ? Collections.emptyList() : list;
        this.bdt = drmInitData;
        this.bdo = metadata;
        AppMethodBeat.o(92333);
    }

    Format(Parcel parcel) {
        AppMethodBeat.i(92334);
        this.id = parcel.readString();
        this.bdp = parcel.readString();
        this.bdq = parcel.readString();
        this.bdn = parcel.readString();
        this.bitrate = parcel.readInt();
        this.bdr = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.bdu = parcel.readFloat();
        this.bdv = parcel.readInt();
        this.bdw = parcel.readFloat();
        this.bdy = parcel.readInt() != 0 ? parcel.createByteArray() : null;
        this.bdx = parcel.readInt();
        this.bdz = (ColorInfo) parcel.readParcelable(ColorInfo.class.getClassLoader());
        this.channelCount = parcel.readInt();
        this.sampleRate = parcel.readInt();
        this.pcmEncoding = parcel.readInt();
        this.bdA = parcel.readInt();
        this.bdB = parcel.readInt();
        this.bdD = parcel.readInt();
        this.language = parcel.readString();
        this.bdE = parcel.readInt();
        this.bdC = parcel.readLong();
        int readInt = parcel.readInt();
        this.bds = new ArrayList(readInt);
        for (int i2 = 0; i2 < readInt; i2++) {
            this.bds.add(parcel.createByteArray());
        }
        this.bdt = (DrmInitData) parcel.readParcelable(DrmInitData.class.getClassLoader());
        this.bdo = (Metadata) parcel.readParcelable(Metadata.class.getClassLoader());
        AppMethodBeat.o(92334);
    }

    public final Format dF(int i2) {
        AppMethodBeat.i(92335);
        Format format = new Format(this.id, this.bdp, this.bdq, this.bdn, this.bitrate, i2, this.width, this.height, this.bdu, this.bdv, this.bdw, this.bdy, this.bdx, this.bdz, this.channelCount, this.sampleRate, this.pcmEncoding, this.bdA, this.bdB, this.bdD, this.language, this.bdE, this.bdC, this.bds, this.bdt, this.bdo);
        AppMethodBeat.o(92335);
        return format;
    }

    public final Format D(long j2) {
        AppMethodBeat.i(92336);
        Format format = new Format(this.id, this.bdp, this.bdq, this.bdn, this.bitrate, this.bdr, this.width, this.height, this.bdu, this.bdv, this.bdw, this.bdy, this.bdx, this.bdz, this.channelCount, this.sampleRate, this.pcmEncoding, this.bdA, this.bdB, this.bdD, this.language, this.bdE, j2, this.bds, this.bdt, this.bdo);
        AppMethodBeat.o(92336);
        return format;
    }

    public final Format a(String str, String str2, int i2, int i3, int i4, int i5, String str3) {
        AppMethodBeat.i(92337);
        Format format = new Format(str, this.bdp, this.bdq, str2, i2, this.bdr, i3, i4, this.bdu, this.bdv, this.bdw, this.bdy, this.bdx, this.bdz, this.channelCount, this.sampleRate, this.pcmEncoding, this.bdA, this.bdB, i5, str3, this.bdE, this.bdC, this.bds, this.bdt, this.bdo);
        AppMethodBeat.o(92337);
        return format;
    }

    public final Format aY(int i2, int i3) {
        AppMethodBeat.i(92338);
        Format format = new Format(this.id, this.bdp, this.bdq, this.bdn, this.bitrate, this.bdr, this.width, this.height, this.bdu, this.bdv, this.bdw, this.bdy, this.bdx, this.bdz, this.channelCount, this.sampleRate, this.pcmEncoding, i2, i3, this.bdD, this.language, this.bdE, this.bdC, this.bds, this.bdt, this.bdo);
        AppMethodBeat.o(92338);
        return format;
    }

    public final Format a(DrmInitData drmInitData) {
        AppMethodBeat.i(92339);
        Format format = new Format(this.id, this.bdp, this.bdq, this.bdn, this.bitrate, this.bdr, this.width, this.height, this.bdu, this.bdv, this.bdw, this.bdy, this.bdx, this.bdz, this.channelCount, this.sampleRate, this.pcmEncoding, this.bdA, this.bdB, this.bdD, this.language, this.bdE, this.bdC, this.bds, drmInitData, this.bdo);
        AppMethodBeat.o(92339);
        return format;
    }

    public final Format a(Metadata metadata) {
        AppMethodBeat.i(92340);
        Format format = new Format(this.id, this.bdp, this.bdq, this.bdn, this.bitrate, this.bdr, this.width, this.height, this.bdu, this.bdv, this.bdw, this.bdy, this.bdx, this.bdz, this.channelCount, this.sampleRate, this.pcmEncoding, this.bdA, this.bdB, this.bdD, this.language, this.bdE, this.bdC, this.bds, this.bdt, metadata);
        AppMethodBeat.o(92340);
        return format;
    }

    public final int tv() {
        if (this.width == -1 || this.height == -1) {
            return -1;
        }
        return this.width * this.height;
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(16)
    public final MediaFormat tw() {
        AppMethodBeat.i(92341);
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", this.bdq);
        String str = this.language;
        if (str != null) {
            mediaFormat.setString(FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, str);
        }
        a(mediaFormat, "max-input-size", this.bdr);
        a(mediaFormat, "width", this.width);
        a(mediaFormat, "height", this.height);
        float f2 = this.bdu;
        if (f2 != -1.0f) {
            mediaFormat.setFloat("frame-rate", f2);
        }
        a(mediaFormat, "rotation-degrees", this.bdv);
        a(mediaFormat, "channel-count", this.channelCount);
        a(mediaFormat, "sample-rate", this.sampleRate);
        a(mediaFormat, "encoder-delay", this.bdA);
        a(mediaFormat, "encoder-padding", this.bdB);
        for (int i2 = 0; i2 < this.bds.size(); i2++) {
            mediaFormat.setByteBuffer("csd-".concat(String.valueOf(i2)), ByteBuffer.wrap(this.bds.get(i2)));
        }
        ColorInfo colorInfo = this.bdz;
        if (colorInfo != null) {
            a(mediaFormat, "color-transfer", colorInfo.bjX);
            a(mediaFormat, "color-standard", colorInfo.bjW);
            a(mediaFormat, "color-range", colorInfo.bjY);
            byte[] bArr = colorInfo.bHM;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        AppMethodBeat.o(92341);
        return mediaFormat;
    }

    public final String toString() {
        AppMethodBeat.i(92342);
        String str = "Format(" + this.id + ", " + this.bdp + ", " + this.bdq + ", " + this.bitrate + ", " + this.language + ", [" + this.width + ", " + this.height + ", " + this.bdu + "], [" + this.channelCount + ", " + this.sampleRate + "])";
        AppMethodBeat.o(92342);
        return str;
    }

    public final int hashCode() {
        int i2 = 0;
        AppMethodBeat.i(92343);
        if (this.aHK == 0) {
            int hashCode = ((this.bdt == null ? 0 : this.bdt.hashCode()) + (((((this.language == null ? 0 : this.language.hashCode()) + (((((((((((((this.bdn == null ? 0 : this.bdn.hashCode()) + (((this.bdq == null ? 0 : this.bdq.hashCode()) + (((this.bdp == null ? 0 : this.bdp.hashCode()) + (((this.id == null ? 0 : this.id.hashCode()) + JsApiGetABTestConfig.CTRL_INDEX) * 31)) * 31)) * 31)) * 31) + this.bitrate) * 31) + this.width) * 31) + this.height) * 31) + this.channelCount) * 31) + this.sampleRate) * 31)) * 31) + this.bdE) * 31)) * 31;
            if (this.bdo != null) {
                i2 = this.bdo.hashCode();
            }
            this.aHK = hashCode + i2;
        }
        int i3 = this.aHK;
        AppMethodBeat.o(92343);
        return i3;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(92344);
        if (this == obj) {
            AppMethodBeat.o(92344);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(92344);
            return false;
        } else {
            Format format = (Format) obj;
            if (this.bitrate == format.bitrate && this.bdr == format.bdr && this.width == format.width && this.height == format.height && this.bdu == format.bdu && this.bdv == format.bdv && this.bdw == format.bdw && this.bdx == format.bdx && this.channelCount == format.channelCount && this.sampleRate == format.sampleRate && this.pcmEncoding == format.pcmEncoding && this.bdA == format.bdA && this.bdB == format.bdB && this.bdC == format.bdC && this.bdD == format.bdD && x.j(this.id, format.id) && x.j(this.language, format.language) && this.bdE == format.bdE && x.j(this.bdp, format.bdp) && x.j(this.bdq, format.bdq) && x.j(this.bdn, format.bdn) && x.j(this.bdt, format.bdt) && x.j(this.bdo, format.bdo) && x.j(this.bdz, format.bdz) && Arrays.equals(this.bdy, format.bdy) && this.bds.size() == format.bds.size()) {
                for (int i2 = 0; i2 < this.bds.size(); i2++) {
                    if (!Arrays.equals(this.bds.get(i2), format.bds.get(i2))) {
                        AppMethodBeat.o(92344);
                        return false;
                    }
                }
                AppMethodBeat.o(92344);
                return true;
            }
            AppMethodBeat.o(92344);
            return false;
        }
    }

    @TargetApi(16)
    private static void a(MediaFormat mediaFormat, String str, int i2) {
        AppMethodBeat.i(92345);
        if (i2 != -1) {
            mediaFormat.setInteger(str, i2);
        }
        AppMethodBeat.o(92345);
    }

    public static String a(Format format) {
        AppMethodBeat.i(92346);
        if (format == null) {
            AppMethodBeat.o(92346);
            return BuildConfig.COMMAND;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("id=").append(format.id).append(", mimeType=").append(format.bdq);
        if (format.bitrate != -1) {
            sb.append(", bitrate=").append(format.bitrate);
        }
        if (!(format.width == -1 || format.height == -1)) {
            sb.append(", res=").append(format.width).append("x").append(format.height);
        }
        if (format.bdu != -1.0f) {
            sb.append(", fps=").append(format.bdu);
        }
        if (format.channelCount != -1) {
            sb.append(", channels=").append(format.channelCount);
        }
        if (format.sampleRate != -1) {
            sb.append(", sample_rate=").append(format.sampleRate);
        }
        if (format.language != null) {
            sb.append(", language=").append(format.language);
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(92346);
        return sb2;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(92347);
        parcel.writeString(this.id);
        parcel.writeString(this.bdp);
        parcel.writeString(this.bdq);
        parcel.writeString(this.bdn);
        parcel.writeInt(this.bitrate);
        parcel.writeInt(this.bdr);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeFloat(this.bdu);
        parcel.writeInt(this.bdv);
        parcel.writeFloat(this.bdw);
        parcel.writeInt(this.bdy != null ? 1 : 0);
        if (this.bdy != null) {
            parcel.writeByteArray(this.bdy);
        }
        parcel.writeInt(this.bdx);
        parcel.writeParcelable(this.bdz, i2);
        parcel.writeInt(this.channelCount);
        parcel.writeInt(this.sampleRate);
        parcel.writeInt(this.pcmEncoding);
        parcel.writeInt(this.bdA);
        parcel.writeInt(this.bdB);
        parcel.writeInt(this.bdD);
        parcel.writeString(this.language);
        parcel.writeInt(this.bdE);
        parcel.writeLong(this.bdC);
        int size = this.bds.size();
        parcel.writeInt(size);
        for (int i3 = 0; i3 < size; i3++) {
            parcel.writeByteArray(this.bds.get(i3));
        }
        parcel.writeParcelable(this.bdt, 0);
        parcel.writeParcelable(this.bdo, 0);
        AppMethodBeat.o(92347);
    }

    static {
        AppMethodBeat.i(92348);
        AppMethodBeat.o(92348);
    }
}
