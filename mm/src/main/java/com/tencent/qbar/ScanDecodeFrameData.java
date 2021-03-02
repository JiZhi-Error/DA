package com.tencent.qbar;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB)\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bB\u000f\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0019\u001a\u00020\u0005H\u0016J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0005H\u0016R\u001a\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f¨\u0006\u001e"}, hxF = {"Lcom/tencent/qbar/ScanDecodeFrameData;", "Landroid/os/Parcelable;", "frameData", "", "width", "", "height", "cameraRotation", "([BIII)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getCameraRotation", "()I", "setCameraRotation", "(I)V", "getHeight", "setHeight", "previewData", "getPreviewData", "()[B", "setPreviewData", "([B)V", "getWidth", "setWidth", "describeContents", "writeToParcel", "", "flags", "Companion", "scan-sdk_release"})
public final class ScanDecodeFrameData implements Parcelable {
    public static final Parcelable.Creator<ScanDecodeFrameData> CREATOR = new b();
    public static final a RKa = new a((byte) 0);
    public byte[] CDY;
    public int height;
    public int sRI;
    public int width;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/qbar/ScanDecodeFrameData$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/qbar/ScanDecodeFrameData;", "TAG", "", "scan-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, hxF = {"com/tencent/qbar/ScanDecodeFrameData$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/qbar/ScanDecodeFrameData;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/qbar/ScanDecodeFrameData;", "scan-sdk_release"})
    public static final class b implements Parcelable.Creator<ScanDecodeFrameData> {
        b() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ScanDecodeFrameData createFromParcel(Parcel parcel) {
            AppMethodBeat.i(176213);
            p.h(parcel, "parcel");
            ScanDecodeFrameData scanDecodeFrameData = new ScanDecodeFrameData(parcel);
            AppMethodBeat.o(176213);
            return scanDecodeFrameData;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ScanDecodeFrameData[] newArray(int i2) {
            return new ScanDecodeFrameData[i2];
        }
    }

    static {
        AppMethodBeat.i(176216);
        AppMethodBeat.o(176216);
    }

    public ScanDecodeFrameData(byte[] bArr, int i2, int i3, int i4) {
        this.CDY = bArr;
        this.width = i2;
        this.height = i3;
        this.sRI = i4;
    }

    public ScanDecodeFrameData(Parcel parcel) {
        p.h(parcel, "parcel");
        AppMethodBeat.i(176215);
        this.CDY = parcel.createByteArray();
        this.sRI = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        AppMethodBeat.o(176215);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(176214);
        p.h(parcel, "parcel");
        parcel.writeByteArray(this.CDY);
        parcel.writeInt(this.sRI);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        AppMethodBeat.o(176214);
    }

    public final int describeContents() {
        return 0;
    }
}
