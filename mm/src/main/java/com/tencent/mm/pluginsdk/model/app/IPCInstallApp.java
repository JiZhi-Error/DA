package com.tencent.mm.pluginsdk.model.app;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import org.xwalk.core.Log;

public class IPCInstallApp implements b<IPCInstallAppParam, IPCBoolean> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
    @Override // com.tencent.mm.ipcinvoker.b
    public /* synthetic */ void invoke(IPCInstallAppParam iPCInstallAppParam, final d<IPCBoolean> dVar) {
        AppMethodBeat.i(151800);
        IPCInstallAppParam iPCInstallAppParam2 = iPCInstallAppParam;
        Log.i("MicroMsg.IPCInstallApp", "invoke()");
        if (iPCInstallAppParam2.type == 1) {
            r.a(MMApplicationContext.getContext(), iPCInstallAppParam2.filePath, new a() {
                /* class com.tencent.mm.pluginsdk.model.app.IPCInstallApp.AnonymousClass1 */

                @Override // com.tencent.mm.pluginsdk.permission.a
                public final void hk(boolean z) {
                    AppMethodBeat.i(151794);
                    if (dVar != null) {
                        dVar.bn(new IPCBoolean(z));
                    }
                    AppMethodBeat.o(151794);
                }
            }, iPCInstallAppParam2.JWt);
            AppMethodBeat.o(151800);
            return;
        }
        if (iPCInstallAppParam2.type == 2) {
            r.a(MMApplicationContext.getContext(), iPCInstallAppParam2.uri, new a() {
                /* class com.tencent.mm.pluginsdk.model.app.IPCInstallApp.AnonymousClass2 */

                @Override // com.tencent.mm.pluginsdk.permission.a
                public final void hk(boolean z) {
                    AppMethodBeat.i(151795);
                    if (dVar != null) {
                        dVar.bn(new IPCBoolean(z));
                    }
                    AppMethodBeat.o(151795);
                }
            }, iPCInstallAppParam2.JWt);
        }
        AppMethodBeat.o(151800);
    }

    public static final class IPCInstallAppParam implements Parcelable {
        public static final Parcelable.Creator<IPCInstallAppParam> CREATOR = new Parcelable.Creator<IPCInstallAppParam>() {
            /* class com.tencent.mm.pluginsdk.model.app.IPCInstallApp.IPCInstallAppParam.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ IPCInstallAppParam[] newArray(int i2) {
                return new IPCInstallAppParam[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ IPCInstallAppParam createFromParcel(Parcel parcel) {
                AppMethodBeat.i(151796);
                IPCInstallAppParam iPCInstallAppParam = new IPCInstallAppParam(parcel);
                AppMethodBeat.o(151796);
                return iPCInstallAppParam;
            }
        };
        private boolean JWt;
        private String filePath;
        private int type;
        private Uri uri;

        public IPCInstallAppParam(int i2, String str, Uri uri2, boolean z) {
            this.type = i2;
            this.filePath = str;
            this.uri = uri2;
            this.JWt = z;
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(151797);
            parcel.writeInt(this.type);
            parcel.writeString(this.filePath);
            parcel.writeParcelable(this.uri, i2);
            parcel.writeByte(this.JWt ? (byte) 1 : 0);
            AppMethodBeat.o(151797);
        }

        protected IPCInstallAppParam(Parcel parcel) {
            AppMethodBeat.i(151798);
            this.type = parcel.readInt();
            this.filePath = parcel.readString();
            this.uri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
            this.JWt = parcel.readByte() != 0;
            AppMethodBeat.o(151798);
        }

        static {
            AppMethodBeat.i(151799);
            AppMethodBeat.o(151799);
        }
    }
}
