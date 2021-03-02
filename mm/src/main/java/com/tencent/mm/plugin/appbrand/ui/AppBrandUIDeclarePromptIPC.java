package com.tencent.mm.plugin.appbrand.ui;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;

public class AppBrandUIDeclarePromptIPC implements b<IPCDeclarePromptCallbackParam, IPCVoid> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
    @Override // com.tencent.mm.ipcinvoker.b
    public /* synthetic */ void invoke(IPCDeclarePromptCallbackParam iPCDeclarePromptCallbackParam, d<IPCVoid> dVar) {
        boolean z = false;
        AppMethodBeat.i(227704);
        IPCDeclarePromptCallbackParam iPCDeclarePromptCallbackParam2 = iPCDeclarePromptCallbackParam;
        if (iPCDeclarePromptCallbackParam2 == null) {
            Log.i("MicroMsg.AppBrandUIDeclarePromptIPC", "data == null");
            if (dVar != null) {
                dVar.bn(new IPCVoid());
            }
            AppMethodBeat.o(227704);
            return;
        }
        Log.i("MicroMsg.AppBrandUIDeclarePromptIPC", "bizType:%s cancel:%s funcId:%s", Integer.valueOf(iPCDeclarePromptCallbackParam2.fuQ), Boolean.valueOf(iPCDeclarePromptCallbackParam2.cancel), Util.nullAs(iPCDeclarePromptCallbackParam2.kHR, ""));
        if (iPCDeclarePromptCallbackParam2.fuQ == 1) {
            g.aAh().azQ().set(ar.a.USERINFO_JD_ENTRANCE_DECLARE_CLICK_BOOLEAN_SYNC, Boolean.TRUE);
        } else if (iPCDeclarePromptCallbackParam2.fuQ == 2) {
            String str = iPCDeclarePromptCallbackParam2.kHR;
            if (!Util.isNullOrNil(str)) {
                g.aAi();
                String str2 = (String) g.aAh().azQ().get(ar.a.USERINFO_MALL_THIRD_PARTY_DISCLAIMER_STRING, (Object) null);
                if (Util.isNullOrNil(str2)) {
                    str2 = str;
                } else {
                    String[] split = str2.split(",");
                    if (split == null || split.length == 0) {
                        str2 = str;
                    } else {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= split.length) {
                                break;
                            } else if (split[i2].equals(str)) {
                                z = true;
                                break;
                            } else {
                                i2++;
                            }
                        }
                        if (!z) {
                            str2 = str2 + "," + str;
                        }
                    }
                }
                g.aAi();
                g.aAh().azQ().set(ar.a.USERINFO_MALL_THIRD_PARTY_DISCLAIMER_STRING, str2);
            }
        }
        if (dVar != null) {
            dVar.bn(new IPCVoid());
        }
        AppMethodBeat.o(227704);
    }

    public static final class IPCDeclarePromptCallbackParam implements Parcelable {
        public static final Parcelable.Creator<IPCDeclarePromptCallbackParam> CREATOR = new Parcelable.Creator<IPCDeclarePromptCallbackParam>() {
            /* class com.tencent.mm.plugin.appbrand.ui.AppBrandUIDeclarePromptIPC.IPCDeclarePromptCallbackParam.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ IPCDeclarePromptCallbackParam[] newArray(int i2) {
                return new IPCDeclarePromptCallbackParam[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ IPCDeclarePromptCallbackParam createFromParcel(Parcel parcel) {
                AppMethodBeat.i(227700);
                IPCDeclarePromptCallbackParam iPCDeclarePromptCallbackParam = new IPCDeclarePromptCallbackParam(parcel);
                AppMethodBeat.o(227700);
                return iPCDeclarePromptCallbackParam;
            }
        };
        private boolean cancel;
        private int fuQ;
        private String kHR;

        public IPCDeclarePromptCallbackParam(int i2, boolean z, String str) {
            this.fuQ = i2;
            this.cancel = z;
            this.kHR = str;
        }

        protected IPCDeclarePromptCallbackParam(Parcel parcel) {
            AppMethodBeat.i(227701);
            this.fuQ = parcel.readInt();
            this.cancel = parcel.readByte() != 0;
            this.kHR = parcel.readString();
            AppMethodBeat.o(227701);
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(227702);
            parcel.writeInt(this.fuQ);
            parcel.writeByte((byte) (this.cancel ? 1 : 0));
            parcel.writeString(this.kHR);
            AppMethodBeat.o(227702);
        }

        public final int describeContents() {
            return 0;
        }

        static {
            AppMethodBeat.i(227703);
            AppMethodBeat.o(227703);
        }
    }
}
