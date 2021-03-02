package com.tencent.mm.plugin.brandservice.ui.timeline.video.util;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.x;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 22\u00020\u0001:\u00012B\u0007\b\u0010¢\u0006\u0002\u0010\u0002B\u000f\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010,\u001a\u00020\rH\u0016J\u000e\u0010-\u001a\u00020.2\u0006\u0010\u0003\u001a\u00020\u0004J\u0018\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u00020\rH\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u0010\u0010\u000bR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010\u0011R\u001c\u0010#\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\t\"\u0004\b%\u0010\u000bR\u001c\u0010&\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\t\"\u0004\b(\u0010\u000bR\u001c\u0010)\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\t\"\u0004\b+\u0010\u000b¨\u00063"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "Landroid/os/Parcelable;", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "appendText", "", "getAppendText$plugin_brandservice_release", "()Ljava/lang/String;", "setAppendText$plugin_brandservice_release", "(Ljava/lang/String;)V", "isMaliciousTitle", "", "isMaliciousTitle$plugin_brandservice_release", "()I", "setMaliciousTitle$plugin_brandservice_release", "(I)V", "maliciousCover", "getMaliciousCover$plugin_brandservice_release", "setMaliciousCover$plugin_brandservice_release", "maliciousDesc", "getMaliciousDesc$plugin_brandservice_release", "setMaliciousDesc$plugin_brandservice_release", "maliciousTitle", "getMaliciousTitle$plugin_brandservice_release", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "getMsgInfo$plugin_brandservice_release", "()Lcom/tencent/mm/message/MPMsgInfo;", "setMsgInfo$plugin_brandservice_release", "(Lcom/tencent/mm/message/MPMsgInfo;)V", "msgInfoLength", "getMsgInfoLength$plugin_brandservice_release", "setMsgInfoLength$plugin_brandservice_release", "sessionId", "getSessionId$plugin_brandservice_release", "setSessionId$plugin_brandservice_release", "toUser", "getToUser$plugin_brandservice_release", "setToUser$plugin_brandservice_release", "url", "getUrl$plugin_brandservice_release", "setUrl$plugin_brandservice_release", "describeContents", "readParcel", "", "writeToParcel", "dest", "flags", "CREATOR", "plugin-brandservice_release"})
public final class AppMsgDataParcelable implements Parcelable {
    public static final a CREATOR = new a((byte) 0);
    String msd;
    x pHv;
    private int pKe;
    int pKf;
    String pKg;
    String pKh;
    String pKi;
    String sessionId;
    String toUser;
    String url;

    static {
        AppMethodBeat.i(7278);
        AppMethodBeat.o(7278);
    }

    public final int describeContents() {
        return 0;
    }

    public AppMsgDataParcelable() {
    }

    public AppMsgDataParcelable(Parcel parcel) {
        p.h(parcel, "parcel");
        AppMethodBeat.i(7277);
        p.h(parcel, "parcel");
        this.toUser = parcel.readString();
        this.url = parcel.readString();
        this.msd = parcel.readString();
        this.pKe = parcel.readInt();
        if (this.pKe > 0) {
            byte[] bArr = new byte[this.pKe];
            parcel.readByteArray(bArr);
            x xVar = new x();
            xVar.parseFrom(bArr);
            this.pHv = xVar;
        }
        this.pKf = parcel.readInt();
        this.pKg = parcel.readString();
        this.pKh = parcel.readString();
        this.pKi = parcel.readString();
        this.sessionId = parcel.readString();
        AppMethodBeat.o(7277);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(7276);
        p.h(parcel, "dest");
        parcel.writeString(this.toUser);
        parcel.writeString(this.url);
        parcel.writeString(this.msd);
        x xVar = this.pHv;
        byte[] byteArray = xVar != null ? xVar.toByteArray() : null;
        if (byteArray != null) {
            if (byteArray.length == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                z2 = false;
            }
            if (z2) {
                this.pKe = byteArray.length;
                parcel.writeInt(this.pKe);
                parcel.writeByteArray(byteArray);
                parcel.writeInt(this.pKf);
                parcel.writeString(this.pKg);
                parcel.writeString(this.pKh);
                parcel.writeString(this.pKi);
                parcel.writeString(this.sessionId);
                AppMethodBeat.o(7276);
            }
        }
        parcel.writeInt(this.pKe);
        parcel.writeInt(this.pKf);
        parcel.writeString(this.pKg);
        parcel.writeString(this.pKh);
        parcel.writeString(this.pKi);
        parcel.writeString(this.sessionId);
        AppMethodBeat.o(7276);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/AppMsgDataParcelable;", "plugin-brandservice_release"})
    public static final class a implements Parcelable.Creator<AppMsgDataParcelable> {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AppMsgDataParcelable createFromParcel(Parcel parcel) {
            AppMethodBeat.i(7275);
            p.h(parcel, "source");
            AppMsgDataParcelable appMsgDataParcelable = new AppMsgDataParcelable(parcel);
            AppMethodBeat.o(7275);
            return appMsgDataParcelable;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AppMsgDataParcelable[] newArray(int i2) {
            return new AppMsgDataParcelable[i2];
        }
    }
}
