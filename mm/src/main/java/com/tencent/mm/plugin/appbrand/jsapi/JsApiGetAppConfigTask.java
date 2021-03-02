package com.tencent.mm.plugin.appbrand.jsapi;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appcache.predownload.c.a;
import com.tencent.mm.plugin.appbrand.appcache.predownload.e.b;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;

class JsApiGetAppConfigTask extends MainProcessTask {
    public static final Parcelable.Creator<JsApiGetAppConfigTask> CREATOR = new Parcelable.Creator<JsApiGetAppConfigTask>() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiGetAppConfigTask.AnonymousClass2 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ JsApiGetAppConfigTask[] newArray(int i2) {
            return new JsApiGetAppConfigTask[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ JsApiGetAppConfigTask createFromParcel(Parcel parcel) {
            AppMethodBeat.i(45484);
            JsApiGetAppConfigTask jsApiGetAppConfigTask = new JsApiGetAppConfigTask(parcel);
            AppMethodBeat.o(45484);
            return jsApiGetAppConfigTask;
        }
    };
    public String appId;
    public String key;
    public Runnable lyv;
    public int scene;
    public int type;
    public String value;

    static /* synthetic */ boolean a(JsApiGetAppConfigTask jsApiGetAppConfigTask) {
        AppMethodBeat.i(45490);
        boolean bDU = jsApiGetAppConfigTask.bDU();
        AppMethodBeat.o(45490);
        return bDU;
    }

    public JsApiGetAppConfigTask() {
    }

    public JsApiGetAppConfigTask(Parcel parcel) {
        AppMethodBeat.i(45485);
        f(parcel);
        AppMethodBeat.o(45485);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjj() {
        AppMethodBeat.i(45486);
        if (!g.aAf().hpY) {
            AppMethodBeat.o(45486);
            return;
        }
        Pair<Boolean, Integer> J = ((b) n.W(b.class)).J(this.appId, 4, this.scene);
        if (((Boolean) J.first).booleanValue()) {
            a aVar = a.INSTANCE;
            a.F((long) ((Integer) J.second).intValue(), 166);
        }
        q.a(this.appId, this.type, 0, new q.c() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiGetAppConfigTask.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.config.q.c
            public final void Vo(String str) {
                AppMethodBeat.i(45483);
                JsApiGetAppConfigTask.this.value = str;
                JsApiGetAppConfigTask.a(JsApiGetAppConfigTask.this);
                AppMethodBeat.o(45483);
            }
        }, !((Boolean) J.first).booleanValue());
        AppMethodBeat.o(45486);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjk() {
        AppMethodBeat.i(45487);
        if (this.lyv != null) {
            this.lyv.run();
        }
        AppMethodBeat.o(45487);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void f(Parcel parcel) {
        AppMethodBeat.i(45488);
        this.appId = parcel.readString();
        this.key = parcel.readString();
        this.value = parcel.readString();
        this.type = parcel.readInt();
        this.scene = parcel.readInt();
        AppMethodBeat.o(45488);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(45489);
        parcel.writeString(this.appId);
        parcel.writeString(this.key);
        parcel.writeString(this.value);
        parcel.writeInt(this.type);
        parcel.writeInt(this.scene);
        AppMethodBeat.o(45489);
    }

    static {
        AppMethodBeat.i(45491);
        AppMethodBeat.o(45491);
    }
}
