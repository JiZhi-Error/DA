package com.tencent.mm.plugin.wepkg.utils;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import g.a.a.b;

public final class WepkgRunCgi {

    public interface a {
        void a(int i2, int i3, String str, d dVar);
    }

    public static final class RemoteCgiTask extends MainProcessTask implements aa.a {
        public static final Parcelable.Creator<RemoteCgiTask> CREATOR = new Parcelable.Creator<RemoteCgiTask>() {
            /* class com.tencent.mm.plugin.wepkg.utils.WepkgRunCgi.RemoteCgiTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ RemoteCgiTask[] newArray(int i2) {
                return new RemoteCgiTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ RemoteCgiTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(110798);
                RemoteCgiTask remoteCgiTask = new RemoteCgiTask(parcel);
                AppMethodBeat.o(110798);
                return remoteCgiTask;
            }
        };
        public int JOm = 0;
        private d JOn;
        public d JOo;
        public a JOp;
        private String lAr;
        private int rxH;
        private int rxv;

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(110799);
            aa.a(this.JOo, this, true);
            AppMethodBeat.o(110799);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            AppMethodBeat.i(110801);
            d.bs(this);
            if (this.JOp != null) {
                this.JOp.a(this.rxH, this.rxv, this.lAr, this.JOn);
            }
            AppMethodBeat.o(110801);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final int describeContents() {
            return 0;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(110802);
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.JOm);
            switch (this.JOm) {
                case 1:
                    WepkgRunCgi.a(this.JOo, parcel);
                    AppMethodBeat.o(110802);
                    return;
                case 2:
                    parcel.writeInt(this.rxH);
                    parcel.writeInt(this.rxv);
                    parcel.writeString(this.lAr);
                    WepkgRunCgi.a(this.JOn, parcel);
                    break;
            }
            AppMethodBeat.o(110802);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(110803);
            super.f(parcel);
            this.JOm = parcel.readInt();
            switch (this.JOm) {
                case 1:
                    this.JOo = WepkgRunCgi.q(parcel);
                    AppMethodBeat.o(110803);
                    return;
                case 2:
                    this.rxH = parcel.readInt();
                    this.rxv = parcel.readInt();
                    this.lAr = parcel.readString();
                    this.JOn = WepkgRunCgi.q(parcel);
                    break;
            }
            AppMethodBeat.o(110803);
        }

        public RemoteCgiTask() {
        }

        RemoteCgiTask(Parcel parcel) {
            AppMethodBeat.i(110804);
            f(parcel);
            AppMethodBeat.o(110804);
        }

        static {
            AppMethodBeat.i(110805);
            AppMethodBeat.o(110805);
        }

        @Override // com.tencent.mm.ak.aa.a
        public final int a(int i2, int i3, String str, d dVar, q qVar) {
            AppMethodBeat.i(110800);
            this.rxH = i2;
            this.rxv = i3;
            this.lAr = str;
            this.JOn = dVar;
            this.JOm = 2;
            bDU();
            AppMethodBeat.o(110800);
            return 0;
        }
    }

    static d q(Parcel parcel) {
        AppMethodBeat.i(110806);
        d.a aVar = new d.a();
        String readString = parcel.readString();
        byte[] bArr = new byte[parcel.readInt()];
        parcel.readByteArray(bArr);
        try {
            aVar.iLN = ((com.tencent.mm.bw.a) Class.forName(readString).newInstance()).parseFrom(bArr);
        } catch (Exception e2) {
        }
        String readString2 = parcel.readString();
        byte[] bArr2 = new byte[parcel.readInt()];
        parcel.readByteArray(bArr2);
        try {
            aVar.iLO = ((com.tencent.mm.bw.a) Class.forName(readString2).newInstance()).parseFrom(bArr2);
        } catch (Exception e3) {
            if (e3 instanceof b) {
                try {
                    aVar.iLO = (com.tencent.mm.bw.a) Class.forName(readString2).newInstance();
                } catch (Exception e4) {
                    Log.e("MicroMsg.Wepkg.WepkgRunCgi", "readCommReqRespFromParcel, resp fields not ready, re-create one but exp = %s", Util.stackTraceToString(e4));
                }
            }
        }
        aVar.uri = parcel.readString();
        aVar.funcId = parcel.readInt();
        aVar.iLP = parcel.readInt();
        aVar.respCmdId = parcel.readInt();
        d aXF = aVar.aXF();
        AppMethodBeat.o(110806);
        return aXF;
    }

    static /* synthetic */ void a(d dVar, Parcel parcel) {
        AppMethodBeat.i(110807);
        parcel.writeString(dVar.iLK.iLR.getClass().getName());
        byte[] bArr = new byte[0];
        try {
            bArr = dVar.iLK.iLR.toByteArray();
        } catch (Exception e2) {
        }
        parcel.writeInt(bArr.length);
        parcel.writeByteArray(bArr);
        parcel.writeString(dVar.iLL.iLR.getClass().getName());
        byte[] bArr2 = new byte[0];
        try {
            bArr2 = dVar.iLL.iLR.toByteArray();
        } catch (Exception e3) {
        }
        parcel.writeInt(bArr2.length);
        parcel.writeByteArray(bArr2);
        parcel.writeString(dVar.getUri());
        parcel.writeInt(dVar.getType());
        parcel.writeInt(dVar.iLK.cmdId);
        parcel.writeInt(dVar.iLL.cmdId);
        AppMethodBeat.o(110807);
    }
}
