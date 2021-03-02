package com.tencent.mm.plugin.webview.ui.tools.media;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.y;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007\b\u0010¢\u0006\u0002\u0010\u0002B\u000f\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u001e\u001a\u00020\u0013H\u0016J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020\u0004J\u0018\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0013H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u000b¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoDataParcelable;", "Landroid/os/Parcelable;", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "appendText", "", "getAppendText$plugin_webview_release", "()Ljava/lang/String;", "setAppendText$plugin_webview_release", "(Ljava/lang/String;)V", "msgInfo", "Lcom/tencent/mm/message/MPShareVideoInfo;", "getMsgInfo$plugin_webview_release", "()Lcom/tencent/mm/message/MPShareVideoInfo;", "setMsgInfo$plugin_webview_release", "(Lcom/tencent/mm/message/MPShareVideoInfo;)V", "msgInfoLength", "", "getMsgInfoLength$plugin_webview_release", "()I", "setMsgInfoLength$plugin_webview_release", "(I)V", "sessionId", "getSessionId$plugin_webview_release", "setSessionId$plugin_webview_release", "toUser", "getToUser$plugin_webview_release", "setToUser$plugin_webview_release", "describeContents", "readParcel", "", "writeToParcel", "dest", "flags", "CREATOR", "plugin-webview_release"})
public final class MpVideoDataParcelable implements Parcelable {
    public static final a CREATOR = new a((byte) 0);
    y JwD;
    String msd;
    private int pKe;
    private String sessionId;
    String toUser;

    static {
        AppMethodBeat.i(82670);
        AppMethodBeat.o(82670);
    }

    public final int describeContents() {
        return 0;
    }

    public MpVideoDataParcelable() {
    }

    public MpVideoDataParcelable(Parcel parcel) {
        p.h(parcel, "parcel");
        AppMethodBeat.i(82669);
        p.h(parcel, "parcel");
        this.toUser = parcel.readString();
        this.msd = parcel.readString();
        this.pKe = parcel.readInt();
        if (this.pKe > 0) {
            byte[] bArr = new byte[this.pKe];
            parcel.readByteArray(bArr);
            y yVar = new y();
            yVar.parseFrom(bArr);
            this.JwD = yVar;
        }
        this.sessionId = parcel.readString();
        AppMethodBeat.o(82669);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(82668);
        p.h(parcel, "dest");
        parcel.writeString(this.toUser);
        parcel.writeString(this.msd);
        y yVar = this.JwD;
        byte[] byteArray = yVar != null ? yVar.toByteArray() : null;
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
                parcel.writeString(this.sessionId);
                AppMethodBeat.o(82668);
            }
        }
        parcel.writeInt(this.pKe);
        parcel.writeString(this.sessionId);
        AppMethodBeat.o(82668);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoDataParcelable$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoDataParcelable;", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/webview/ui/tools/media/MpVideoDataParcelable;", "plugin-webview_release"})
    public static final class a implements Parcelable.Creator<MpVideoDataParcelable> {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ MpVideoDataParcelable createFromParcel(Parcel parcel) {
            AppMethodBeat.i(82667);
            p.h(parcel, "source");
            MpVideoDataParcelable mpVideoDataParcelable = new MpVideoDataParcelable(parcel);
            AppMethodBeat.o(82667);
            return mpVideoDataParcelable;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ MpVideoDataParcelable[] newArray(int i2) {
            return new MpVideoDataParcelable[i2];
        }
    }
}
