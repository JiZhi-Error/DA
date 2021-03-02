package com.tencent.mm.plugin.webview.modeltools;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;

public final class NFCIPCHelper {
    public static void gdo() {
        AppMethodBeat.i(79142);
        Log.e("MicroMsg.NFCIPCHelper", "alvinluo nfcInvokeAsResult error");
        h.INSTANCE.dN(968, 0);
        AppMethodBeat.o(79142);
    }

    public static class a implements k<NFCEventTransfer, NFCEventTransfer> {
        private a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.ipcinvoker.k
        public final /* synthetic */ NFCEventTransfer invoke(NFCEventTransfer nFCEventTransfer) {
            AppMethodBeat.i(79141);
            NFCEventTransfer nFCEventTransfer2 = nFCEventTransfer;
            Log.i("MicroMsg.NFCIPCHelper", "alvinluo NfcEventInvokeTask invoke process: %s", g.aAe().azG().mProcessName);
            com.tencent.mm.g.a.k kVar = new com.tencent.mm.g.a.k();
            kVar.dCc.actionCode = nFCEventTransfer2.actionCode;
            kVar.dCc.dCe = nFCEventTransfer2.dCe;
            kVar.dCc.dCf = nFCEventTransfer2.dCf;
            kVar.dCc.dCg = nFCEventTransfer2.dCg;
            EventCenter.instance.publish(kVar);
            nFCEventTransfer2.dCh = kVar.dCd.dCh;
            AppMethodBeat.o(79141);
            return nFCEventTransfer2;
        }
    }

    public static class NFCEventTransfer implements Parcelable {
        public static final Parcelable.Creator<NFCEventTransfer> CREATOR = new Parcelable.Creator<NFCEventTransfer>() {
            /* class com.tencent.mm.plugin.webview.modeltools.NFCIPCHelper.NFCEventTransfer.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ NFCEventTransfer[] newArray(int i2) {
                return new NFCEventTransfer[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ NFCEventTransfer createFromParcel(Parcel parcel) {
                AppMethodBeat.i(79137);
                NFCEventTransfer nFCEventTransfer = new NFCEventTransfer(parcel);
                AppMethodBeat.o(79137);
                return nFCEventTransfer;
            }
        };
        public int actionCode;
        public String dCe;
        public boolean dCf;
        public boolean dCg;
        public Bundle dCh;

        public NFCEventTransfer(com.tencent.mm.g.a.k kVar) {
            this.actionCode = kVar.dCc.actionCode;
            this.dCe = kVar.dCc.dCe;
            this.dCf = kVar.dCc.dCf;
            this.dCg = kVar.dCc.dCg;
        }

        protected NFCEventTransfer(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(79138);
            this.actionCode = parcel.readInt();
            this.dCe = parcel.readString();
            if (parcel.readByte() != 0) {
                z = true;
            } else {
                z = false;
            }
            this.dCf = z;
            this.dCg = parcel.readByte() == 0 ? false : z2;
            this.dCh = parcel.readBundle(getClass().getClassLoader());
            AppMethodBeat.o(79138);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            byte b2;
            byte b3 = 1;
            AppMethodBeat.i(79139);
            parcel.writeInt(this.actionCode);
            parcel.writeString(this.dCe);
            if (this.dCf) {
                b2 = 1;
            } else {
                b2 = 0;
            }
            parcel.writeByte(b2);
            if (!this.dCg) {
                b3 = 0;
            }
            parcel.writeByte(b3);
            parcel.writeBundle(this.dCh);
            AppMethodBeat.o(79139);
        }

        public int describeContents() {
            return 0;
        }

        static {
            AppMethodBeat.i(79140);
            AppMethodBeat.o(79140);
        }
    }
}
