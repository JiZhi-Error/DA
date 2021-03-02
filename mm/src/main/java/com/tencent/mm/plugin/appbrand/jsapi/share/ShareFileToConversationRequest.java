package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B!\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0014J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u000fH\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareFileToConversationRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "filePath", "", "fileExt", DownloadInfo.FILENAME, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFileExt", "()Ljava/lang/String;", "getFileName", "getFilePath", "describeContents", "", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareFileToConversationTask;", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"})
final class ShareFileToConversationRequest extends AppBrandProxyUIProcessTask.ProcessRequest {
    public static final a CREATOR = new a((byte) 0);
    final String fileName;
    final String filePath;
    final String gCr;

    static {
        AppMethodBeat.i(228540);
        AppMethodBeat.o(228540);
    }

    public ShareFileToConversationRequest(String str, String str2, String str3) {
        p.h(str, "filePath");
        AppMethodBeat.i(228538);
        this.filePath = str;
        this.gCr = str2;
        this.fileName = str3;
        AppMethodBeat.o(228538);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ShareFileToConversationRequest(android.os.Parcel r5) {
        /*
            r4 = this;
            r3 = 228539(0x37cbb, float:3.20251E-40)
            java.lang.String r0 = "parcel"
            kotlin.g.b.p.h(r5, r0)
            java.lang.String r0 = r5.readString()
            if (r0 != 0) goto L_0x0012
            java.lang.String r0 = ""
        L_0x0012:
            java.lang.String r1 = r5.readString()
            java.lang.String r2 = r5.readString()
            r4.<init>(r0, r1, r2)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.share.ShareFileToConversationRequest.<init>(android.os.Parcel):void");
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
    public final Class<x> bCJ() {
        return x.class;
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(228537);
        p.h(parcel, "parcel");
        parcel.writeString(this.filePath);
        parcel.writeString(this.gCr);
        parcel.writeString(this.fileName);
        AppMethodBeat.o(228537);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
    public final int describeContents() {
        return 0;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareFileToConversationRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareFileToConversationRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/share/ShareFileToConversationRequest;", "plugin-appbrand-integration_release"})
    public static final class a implements Parcelable.Creator<ShareFileToConversationRequest> {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ ShareFileToConversationRequest createFromParcel(Parcel parcel) {
            AppMethodBeat.i(228536);
            p.h(parcel, "parcel");
            ShareFileToConversationRequest shareFileToConversationRequest = new ShareFileToConversationRequest(parcel);
            AppMethodBeat.o(228536);
            return shareFileToConversationRequest;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ ShareFileToConversationRequest[] newArray(int i2) {
            return new ShareFileToConversationRequest[i2];
        }
    }
}
