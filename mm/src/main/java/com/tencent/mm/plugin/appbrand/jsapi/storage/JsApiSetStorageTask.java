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

class JsApiSetStorageTask extends MainProcessTask {
    public static final Parcelable.Creator<JsApiSetStorageTask> CREATOR = new Parcelable.Creator<JsApiSetStorageTask>() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.storage.JsApiSetStorageTask.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ JsApiSetStorageTask[] newArray(int i2) {
            return new JsApiSetStorageTask[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ JsApiSetStorageTask createFromParcel(Parcel parcel) {
            AppMethodBeat.i(147290);
            JsApiSetStorageTask jsApiSetStorageTask = new JsApiSetStorageTask();
            jsApiSetStorageTask.f(parcel);
            AppMethodBeat.o(147290);
            return jsApiSetStorageTask;
        }
    };
    public String appId;
    private String key;
    public Runnable lyv;
    public int mtl;
    private boolean mtr;
    private int mts;
    private int mtt;
    private int mtu;
    public String result;
    private String type;
    private String value;

    JsApiSetStorageTask() {
    }

    public final void E(String str, String str2, String str3) {
        AppMethodBeat.i(147291);
        if (p.p(str, str2, str3) > 102400) {
            this.mts = p.p(str);
            this.mtt = p.p(str2);
            this.mtu = p.p(str3);
            try {
                p.g(this.jEY, str, str2, str3);
            } catch (Exception e2) {
                Log.e("MicroMsg.JsApiSetStorageTask", e2.getMessage());
            }
            this.mtr = true;
            AppMethodBeat.o(147291);
            return;
        }
        this.mtr = false;
        this.key = str;
        this.value = str2;
        this.type = str3;
        AppMethodBeat.o(147291);
    }

    private void bIN() {
        this.key = null;
        this.value = null;
        this.type = null;
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjk() {
        AppMethodBeat.i(147292);
        if (this.lyv != null) {
            this.lyv.run();
        }
        AppMethodBeat.o(147292);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjj() {
        d NK;
        p.a c2;
        AppMethodBeat.i(147293);
        if (this.mtr) {
            try {
                String aaO = p.aaO(this.jEY);
                if (aaO.length() == this.mts + this.mtt + this.mtu) {
                    this.key = aaO.substring(0, this.mts);
                    this.value = aaO.substring(this.mts, this.mts + this.mtt);
                    this.type = aaO.substring(this.mts + this.mtt, this.mts + this.mtt + this.mtu);
                }
                p.aaP(this.jEY);
            } catch (Exception e2) {
                Log.e("MicroMsg.JsApiSetStorageTask", e2.getMessage());
                p.aaP(this.jEY);
            } catch (Throwable th) {
                p.aaP(this.jEY);
                AppMethodBeat.o(147293);
                throw th;
            }
        }
        if (e.M(a.class) == null) {
            NK = null;
        } else {
            NK = ((a) e.M(a.class)).NK();
        }
        if (NK == null) {
            this.result = "fail:internal error get DB fail";
            bIN();
            bDU();
            AppMethodBeat.o(147293);
            return;
        }
        synchronized (d.class) {
            try {
                c2 = NK.c(this.mtl, this.appId, this.key, this.value, this.type);
            } catch (Throwable th2) {
                AppMethodBeat.o(147293);
                throw th2;
            }
        }
        this.result = p.a(c2);
        bIN();
        bDU();
        AppMethodBeat.o(147293);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void f(Parcel parcel) {
        AppMethodBeat.i(147294);
        this.appId = parcel.readString();
        this.mtl = parcel.readInt();
        this.mtr = parcel.readByte() != 0;
        this.mts = parcel.readInt();
        this.mtt = parcel.readInt();
        this.mtu = parcel.readInt();
        this.key = parcel.readString();
        this.value = parcel.readString();
        this.type = parcel.readString();
        this.result = parcel.readString();
        AppMethodBeat.o(147294);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(147295);
        parcel.writeString(this.appId);
        parcel.writeInt(this.mtl);
        parcel.writeByte(this.mtr ? (byte) 1 : 0);
        parcel.writeInt(this.mts);
        parcel.writeInt(this.mtt);
        parcel.writeInt(this.mtu);
        parcel.writeString(this.key);
        parcel.writeString(this.value);
        parcel.writeString(this.type);
        parcel.writeString(this.result);
        AppMethodBeat.o(147295);
    }

    static {
        AppMethodBeat.i(147296);
        AppMethodBeat.o(147296);
    }
}
