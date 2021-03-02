package com.tencent.mm.plugin.appbrand.jsapi.channels;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u0006H\u0016J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0014J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0006H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/EnterFinderResult;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessResult;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "errCode", "", "(I)V", "getErrCode", "()I", "describeContents", "readParcel", "", LocaleUtil.INDONESIAN_NEWNAME, "writeToParcel", "flags", "CREATOR", "plugin-appbrand-integration_release"})
final class EnterFinderResult extends AppBrandProxyUIProcessTask.ProcessResult {
    public static final a CREATOR = new a((byte) 0);
    final int errCode;

    static {
        AppMethodBeat.i(228379);
        AppMethodBeat.o(228379);
    }

    public EnterFinderResult(int i2) {
        this.errCode = i2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public EnterFinderResult(Parcel parcel) {
        this(parcel.readInt());
        p.h(parcel, "parcel");
        AppMethodBeat.i(228378);
        AppMethodBeat.o(228378);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(228377);
        p.h(parcel, "parcel");
        parcel.writeInt(this.errCode);
        AppMethodBeat.o(228377);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult
    public final void k(Parcel parcel) {
    }

    public final int describeContents() {
        return 0;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/channels/EnterFinderResult$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/channels/EnterFinderResult;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/channels/EnterFinderResult;", "plugin-appbrand-integration_release"})
    public static final class a implements Parcelable.Creator<EnterFinderResult> {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ EnterFinderResult createFromParcel(Parcel parcel) {
            AppMethodBeat.i(228376);
            p.h(parcel, "parcel");
            EnterFinderResult enterFinderResult = new EnterFinderResult(parcel);
            AppMethodBeat.o(228376);
            return enterFinderResult;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ EnterFinderResult[] newArray(int i2) {
            return new EnterFinderResult[i2];
        }
    }
}
