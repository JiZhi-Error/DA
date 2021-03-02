package com.tencent.mm.sticker.loader;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MD5Util;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 %2\u00020\u0001:\u0001%B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u001f\u001a\u00020\u0006H\u0016J\u0006\u0010 \u001a\u00020\tJ\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0006H\u0016R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0007R\u001a\u0010\u0012\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\rR\u001a\u0010\u0015\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0010\"\u0004\b\u0017\u0010\u0007R\u001a\u0010\u0018\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000b\"\u0004\b\u001a\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0010R\u001a\u0010\u001c\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000b\"\u0004\b\u001e\u0010\r¨\u0006&"}, hxF = {"Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "type", "", "(I)V", "aesKey", "", "getAesKey", "()Ljava/lang/String;", "setAesKey", "(Ljava/lang/String;)V", "errType", "getErrType", "()I", "setErrType", "fileId", "getFileId", "setFileId", "fileLength", "getFileLength", "setFileLength", "lensId", "getLensId", "setLensId", "getType", "url", "getUrl", "setUrl", "describeContents", "key", "writeToParcel", "", "dest", "flags", "Companion", "plugin-sticker_release"})
public final class StickerLoadInfo implements Parcelable {
    public static final Parcelable.Creator<StickerLoadInfo> CREATOR = new b();
    public static final a NNP = new a((byte) 0);
    String aesKey;
    public int errType;
    String fileId;
    int kKK;
    public String rnS;
    final int type;
    public String url;

    public /* synthetic */ StickerLoadInfo() {
        this(0);
    }

    public StickerLoadInfo(int i2) {
        this.type = i2;
        this.rnS = "";
        this.fileId = "";
        this.aesKey = "";
        this.url = "";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public StickerLoadInfo(Parcel parcel) {
        this(parcel.readInt());
        p.h(parcel, "parcel");
        AppMethodBeat.i(105944);
        String readString = parcel.readString();
        this.rnS = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.fileId = readString2 == null ? "" : readString2;
        String readString3 = parcel.readString();
        this.aesKey = readString3 == null ? "" : readString3;
        this.kKK = parcel.readInt();
        String readString4 = parcel.readString();
        this.url = readString4 == null ? "" : readString4;
        this.errType = parcel.readInt();
        AppMethodBeat.o(105944);
    }

    public final String Lb() {
        AppMethodBeat.i(105942);
        if (this.type == 0) {
            String str = this.rnS;
            AppMethodBeat.o(105942);
            return str;
        }
        String mD5String = MD5Util.getMD5String(this.url);
        p.g(mD5String, "MD5Util.getMD5String(url)");
        AppMethodBeat.o(105942);
        return mD5String;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(105943);
        p.h(parcel, "dest");
        parcel.writeInt(this.type);
        parcel.writeString(this.rnS);
        parcel.writeString(this.fileId);
        parcel.writeString(this.aesKey);
        parcel.writeInt(this.kKK);
        parcel.writeString(this.url);
        parcel.writeInt(this.errType);
        AppMethodBeat.o(105943);
    }

    public final int describeContents() {
        return 0;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/sticker/loader/StickerLoadInfo$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "ERR_TYPE_DECODE", "", "ERR_TYPE_EXPIRED", "ERR_TYPE_NETWORK", "ERR_TYPE_OK", "ERR_TYPE_RETRY", "ERR_TYPE_UIN_MISMATCH", "TYPE_FILE_ID", "TYPE_URL", "fromLensInfo", "lensInfo", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "fromUrl", "url", "", "plugin-sticker_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, hxF = {"com/tencent/mm/sticker/loader/StickerLoadInfo$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "plugin-sticker_release"})
    public static final class b implements Parcelable.Creator<StickerLoadInfo> {
        b() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ StickerLoadInfo createFromParcel(Parcel parcel) {
            AppMethodBeat.i(105941);
            p.h(parcel, "parcel");
            StickerLoadInfo stickerLoadInfo = new StickerLoadInfo(parcel);
            AppMethodBeat.o(105941);
            return stickerLoadInfo;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ StickerLoadInfo[] newArray(int i2) {
            return new StickerLoadInfo[i2];
        }
    }

    static {
        AppMethodBeat.i(105945);
        AppMethodBeat.o(105945);
    }
}
