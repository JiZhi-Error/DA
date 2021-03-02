package com.tencent.mm.plugin.wallet.wecoin.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B!\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\nJ\b\u0010\u0015\u001a\u00020\u0006H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0006H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\t\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "sceneID", "", "sceneSessionID", "", "wecoinSessionID", "(ILjava/lang/String;Ljava/lang/String;)V", "getSceneID", "()I", "setSceneID", "(I)V", "getSceneSessionID", "()Ljava/lang/String;", "setSceneSessionID", "(Ljava/lang/String;)V", "getWecoinSessionID", "setWecoinSessionID", "describeContents", "writeToParcel", "", "dest", "flags", "Companion", "plugin-wxpay_release"})
public final class WecoinEncashKVData implements Parcelable {
    public static final Parcelable.Creator<WecoinEncashKVData> CREATOR = new b();
    public static final a HOa = new a((byte) 0);
    public String HMK;
    public int HNZ;
    public String nZz;

    public WecoinEncashKVData(int i2, String str, String str2) {
        this.HNZ = i2;
        this.HMK = str;
        this.nZz = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WecoinEncashKVData(Parcel parcel) {
        this(parcel.readInt(), parcel.readString(), parcel.readString());
        p.h(parcel, "source");
        AppMethodBeat.i(212745);
        AppMethodBeat.o(212745);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(212744);
        p.h(parcel, "dest");
        parcel.writeInt(this.HNZ);
        parcel.writeString(this.HMK);
        parcel.writeString(this.nZz);
        AppMethodBeat.o(212744);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData;", "plugin-wxpay_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/wallet/wecoin/model/WecoinEncashKVData;", "plugin-wxpay_release"})
    public static final class b implements Parcelable.Creator<WecoinEncashKVData> {
        b() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ WecoinEncashKVData createFromParcel(Parcel parcel) {
            AppMethodBeat.i(212743);
            p.h(parcel, "source");
            WecoinEncashKVData wecoinEncashKVData = new WecoinEncashKVData(parcel);
            AppMethodBeat.o(212743);
            return wecoinEncashKVData;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ WecoinEncashKVData[] newArray(int i2) {
            return new WecoinEncashKVData[i2];
        }
    }

    static {
        AppMethodBeat.i(212746);
        AppMethodBeat.o(212746);
    }
}
