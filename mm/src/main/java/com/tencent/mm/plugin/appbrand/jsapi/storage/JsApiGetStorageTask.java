package com.tencent.mm.plugin.appbrand.jsapi.storage;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.a.e;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.d;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.Log;

class JsApiGetStorageTask extends MainProcessTask {
    public static final Parcelable.Creator<JsApiGetStorageTask> CREATOR = new Parcelable.Creator<JsApiGetStorageTask>() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiGetStorageTask.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ JsApiGetStorageTask[] newArray(int i2) {
            return new JsApiGetStorageTask[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ JsApiGetStorageTask createFromParcel(Parcel parcel) {
            AppMethodBeat.i(147260);
            JsApiGetStorageTask jsApiGetStorageTask = new JsApiGetStorageTask();
            jsApiGetStorageTask.f(parcel);
            AppMethodBeat.o(147260);
            return jsApiGetStorageTask;
        }
    };
    public String appId;
    public String key;
    public Runnable lyv;
    public int mtl;
    private boolean mtr;
    private int mts;
    private int mtt;
    private int mtu;
    public String type;
    public String value;

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjj() {
        AppMethodBeat.i(147261);
        if (((a) e.M(a.class)) == null) {
            bDU();
            AppMethodBeat.o(147261);
            return;
        }
        d NK = ((a) e.M(a.class)).NK();
        if (NK == null) {
            bDU();
            AppMethodBeat.o(147261);
            return;
        }
        Object[] l = NK.l(this.mtl, this.appId, this.key);
        if (((p.a) l[0]) == p.a.NONE) {
            String str = (String) l[1];
            String str2 = (String) l[2];
            if (p.p(str, str2) > 102400) {
                this.mtt = p.p(str);
                this.mtu = p.p(str2);
                try {
                    p.g(this.jEY, str, str2);
                } catch (Exception e2) {
                    Log.e("MicroMsg.JsApiGetStorageTask", e2.getMessage());
                }
                this.mtr = true;
            } else {
                this.mtr = false;
                this.value = str;
                this.type = str2;
            }
        }
        bDU();
        AppMethodBeat.o(147261);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjk() {
        AppMethodBeat.i(147262);
        if (this.mtr) {
            try {
                String aaO = p.aaO(this.jEY);
                if (aaO.length() == this.mtt + this.mtu) {
                    this.value = aaO.substring(0, this.mtt);
                    this.type = aaO.substring(this.mtt, this.mtt + this.mtu);
                }
                p.aaP(this.jEY);
            } catch (Exception e2) {
                Log.e("MicroMsg.JsApiGetStorageTask", e2.getMessage());
                p.aaP(this.jEY);
            } catch (Throwable th) {
                p.aaP(this.jEY);
                AppMethodBeat.o(147262);
                throw th;
            }
        }
        if (this.lyv != null) {
            this.lyv.run();
        }
        AppMethodBeat.o(147262);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void f(Parcel parcel) {
        AppMethodBeat.i(147263);
        this.appId = parcel.readString();
        this.mtl = parcel.readInt();
        this.mtr = parcel.readByte() != 0;
        this.mts = parcel.readInt();
        this.mtt = parcel.readInt();
        this.mtu = parcel.readInt();
        this.key = parcel.readString();
        this.value = parcel.readString();
        this.type = parcel.readString();
        AppMethodBeat.o(147263);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(147264);
        parcel.writeString(this.appId);
        parcel.writeInt(this.mtl);
        parcel.writeByte(this.mtr ? (byte) 1 : 0);
        parcel.writeInt(this.mts);
        parcel.writeInt(this.mtt);
        parcel.writeInt(this.mtu);
        parcel.writeString(this.key);
        parcel.writeString(this.value);
        parcel.writeString(this.type);
        AppMethodBeat.o(147264);
    }

    static {
        AppMethodBeat.i(147265);
        AppMethodBeat.o(147265);
    }
}
