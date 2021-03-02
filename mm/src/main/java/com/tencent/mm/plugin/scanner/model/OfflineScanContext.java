package com.tencent.mm.plugin.scanner.model;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.z.f;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 @2\u00020\u0001:\u0001@BQ\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010BI\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0011B\u000f\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\b\u0010;\u001a\u00020\u0005H\u0016J\b\u0010<\u001a\u00020\u0007H\u0016J\u0018\u0010=\u001a\u00020>2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010?\u001a\u00020\u0005H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\n\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010!R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R\u001a\u0010&\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001f\"\u0004\b(\u0010!R\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010\b\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001f\"\u0004\b.\u0010!R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u000204X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001a\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001b\"\u0004\b:\u0010\u001d¨\u0006A"}, hxF = {"Lcom/tencent/mm/plugin/scanner/model/OfflineScanContext;", "Landroid/os/Parcelable;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "networkType", "", "qBarString", "", "source", "codeType", "codeVersion", "typeName", "selectFromAlbum", "", "statObj", "Landroid/os/Bundle;", "(Landroid/app/Activity;ILjava/lang/String;IIILjava/lang/String;ZLandroid/os/Bundle;)V", "(Landroid/app/Activity;ILjava/lang/String;IILjava/lang/String;ZLandroid/os/Bundle;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getActivity", "()Landroid/app/Activity;", "setActivity", "(Landroid/app/Activity;)V", "codeString", "getCodeString", "()Ljava/lang/String;", "setCodeString", "(Ljava/lang/String;)V", "getCodeType", "()I", "setCodeType", "(I)V", "getCodeVersion", "setCodeVersion", f.NAME, "setNetworkType", "resultType", "getResultType", "setResultType", "getSelectFromAlbum", "()Z", "setSelectFromAlbum", "(Z)V", "getSource", "setSource", "getStatObj", "()Landroid/os/Bundle;", "setStatObj", "(Landroid/os/Bundle;)V", AppMeasurement.Param.TIMESTAMP, "", "getTimestamp", "()J", "setTimestamp", "(J)V", "getTypeName", "setTypeName", "describeContents", "toString", "writeToParcel", "", "flags", "CREATOR", "plugin-scan_release"})
public final class OfflineScanContext implements Parcelable {
    public static final a CREATOR = new a((byte) 0);
    private int CFI;
    public String CFJ = "";
    public boolean CFK;
    public Activity activity;
    public int dFL;
    public int dFM;
    public Bundle dFP;
    public int networkType;
    public int source;
    public long timestamp;
    public String typeName = "";

    static {
        AppMethodBeat.i(52179);
        AppMethodBeat.o(52179);
    }

    public OfflineScanContext(Activity activity2, int i2, String str, int i3, int i4, int i5, String str2, boolean z, Bundle bundle) {
        p.h(activity2, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(str, "qBarString");
        p.h(str2, "typeName");
        AppMethodBeat.i(52176);
        this.activity = activity2;
        this.networkType = i2;
        this.CFJ = str;
        this.source = i3;
        this.dFL = i4;
        this.dFM = i5;
        this.typeName = str2;
        this.dFP = bundle;
        this.timestamp = System.currentTimeMillis();
        this.CFK = z;
        AppMethodBeat.o(52176);
    }

    public OfflineScanContext(Activity activity2, int i2, String str, int i3, int i4, String str2, boolean z, Bundle bundle) {
        p.h(activity2, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(str, "qBarString");
        p.h(str2, "typeName");
        AppMethodBeat.i(52177);
        this.activity = activity2;
        this.networkType = i2;
        this.CFJ = str;
        this.dFL = i3;
        this.dFM = i4;
        this.typeName = str2;
        this.dFP = bundle;
        this.timestamp = System.currentTimeMillis();
        this.CFK = z;
        AppMethodBeat.o(52177);
    }

    public OfflineScanContext(Parcel parcel) {
        p.h(parcel, "parcel");
        AppMethodBeat.i(52178);
        this.CFI = parcel.readInt();
        String readString = parcel.readString();
        this.CFJ = readString == null ? "" : readString;
        this.source = parcel.readInt();
        this.dFL = parcel.readInt();
        this.dFM = parcel.readInt();
        String readString2 = parcel.readString();
        this.typeName = readString2 == null ? "" : readString2;
        this.dFP = parcel.readBundle(Bundle.class.getClassLoader());
        this.timestamp = parcel.readLong();
        this.CFK = parcel.readByte() != 0;
        this.networkType = parcel.readInt();
        AppMethodBeat.o(52178);
    }

    public final String toString() {
        AppMethodBeat.i(52174);
        StringBuilder append = new StringBuilder("codeString: ").append(this.CFJ).append(", source: ").append(this.source).append(", codeType: ").append(this.dFL).append(", codeVersion").append(this.dFM).append(", statObj: ");
        Bundle bundle = this.dFP;
        String sb = append.append(bundle != null ? bundle.toString() : null).append(", time: ").append(String.valueOf(this.timestamp)).toString();
        AppMethodBeat.o(52174);
        return sb;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(52175);
        p.h(parcel, "parcel");
        parcel.writeInt(this.CFI);
        parcel.writeString(this.CFJ);
        parcel.writeInt(this.source);
        parcel.writeInt(this.dFL);
        parcel.writeInt(this.dFM);
        parcel.writeString(this.typeName);
        parcel.writeBundle(this.dFP);
        parcel.writeLong(this.timestamp);
        parcel.writeByte(this.CFK ? (byte) 1 : 0);
        parcel.writeInt(this.networkType);
        AppMethodBeat.o(52175);
    }

    public final int describeContents() {
        return 0;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001d\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/scanner/model/OfflineScanContext$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/scanner/model/OfflineScanContext;", "()V", "TAG", "", "convertFromString", "value", "convertToString", "context", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/scanner/model/OfflineScanContext;", "plugin-scan_release"})
    public static final class a implements Parcelable.Creator<OfflineScanContext> {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ OfflineScanContext createFromParcel(Parcel parcel) {
            AppMethodBeat.i(52171);
            OfflineScanContext o = o(parcel);
            AppMethodBeat.o(52171);
            return o;
        }

        private static OfflineScanContext o(Parcel parcel) {
            AppMethodBeat.i(52170);
            p.h(parcel, "parcel");
            OfflineScanContext offlineScanContext = new OfflineScanContext(parcel);
            AppMethodBeat.o(52170);
            return offlineScanContext;
        }

        public static String a(OfflineScanContext offlineScanContext) {
            AppMethodBeat.i(52172);
            p.h(offlineScanContext, "context");
            Parcel obtain = Parcel.obtain();
            p.g(obtain, "Parcel.obtain()");
            obtain.setDataPosition(0);
            offlineScanContext.writeToParcel(obtain, 0);
            String encodeToString = Base64.encodeToString(obtain.marshall(), 0);
            p.g(encodeToString, "Base64.encodeToString(da…yteArray, Base64.DEFAULT)");
            AppMethodBeat.o(52172);
            return encodeToString;
        }

        public static OfflineScanContext aMx(String str) {
            AppMethodBeat.i(52173);
            p.h(str, "value");
            Parcel obtain = Parcel.obtain();
            p.g(obtain, "Parcel.obtain()");
            byte[] decode = Base64.decode(str, 0);
            obtain.unmarshall(decode, 0, decode.length);
            obtain.setDataPosition(0);
            OfflineScanContext o = o(obtain);
            AppMethodBeat.o(52173);
            return o;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ OfflineScanContext[] newArray(int i2) {
            return new OfflineScanContext[i2];
        }
    }
}
