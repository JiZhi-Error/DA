package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;

public class JsApiChattingTask extends MainProcessTask {
    public static final Parcelable.Creator<JsApiChattingTask> CREATOR = new Parcelable.Creator<JsApiChattingTask>() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChattingTask.AnonymousClass2 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ JsApiChattingTask[] newArray(int i2) {
            return new JsApiChattingTask[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ JsApiChattingTask createFromParcel(Parcel parcel) {
            AppMethodBeat.i(46239);
            JsApiChattingTask jsApiChattingTask = new JsApiChattingTask(parcel);
            AppMethodBeat.o(46239);
            return jsApiChattingTask;
        }
    };
    public String lRW;
    public Runnable lyv;
    public String nickname;
    public String username;

    static /* synthetic */ boolean a(JsApiChattingTask jsApiChattingTask) {
        AppMethodBeat.i(46245);
        boolean bDU = jsApiChattingTask.bDU();
        AppMethodBeat.o(46245);
        return bDU;
    }

    public JsApiChattingTask() {
    }

    public JsApiChattingTask(Parcel parcel) {
        AppMethodBeat.i(46240);
        f(parcel);
        AppMethodBeat.o(46240);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjj() {
        AppMethodBeat.i(46241);
        if (!g.aAf().hpY) {
            bDU();
            AppMethodBeat.o(46241);
            return;
        }
        as Kn = ((l) g.af(l.class)).aSN().Kn(this.username);
        Log.d("MicroMsg.JsApiChattingTask", "sessionFrom:%s,username:%s,nickname:%s", this.lRW, this.username, this.nickname);
        if (Kn == null || ((int) Kn.gMZ) == 0) {
            as asVar = new as(this.username);
            asVar.setType(0);
            asVar.setNickname(this.nickname);
            ((l) g.af(l.class)).aSN().ap(asVar);
            Log.i("MicroMsg.JsApiChattingTask", "%s save to contact_table", this.username);
        }
        ((q) g.af(q.class)).c(this.username, new q.a() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChattingTask.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.service.q.a
            public final void b(WxaAttributes wxaAttributes) {
                AppMethodBeat.i(46238);
                if (wxaAttributes == null) {
                    Log.w("MicroMsg.JsApiChattingTask", "info is null, err");
                }
                JsApiChattingTask.a(JsApiChattingTask.this);
                AppMethodBeat.o(46238);
            }
        });
        AppMethodBeat.o(46241);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjk() {
        AppMethodBeat.i(46242);
        if (this.lyv != null) {
            this.lyv.run();
        }
        AppMethodBeat.o(46242);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void f(Parcel parcel) {
        AppMethodBeat.i(46243);
        this.lRW = parcel.readString();
        this.username = parcel.readString();
        this.nickname = parcel.readString();
        AppMethodBeat.o(46243);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(46244);
        parcel.writeString(this.lRW);
        parcel.writeString(this.username);
        parcel.writeString(this.nickname);
        AppMethodBeat.o(46244);
    }

    static {
        AppMethodBeat.i(46246);
        AppMethodBeat.o(46246);
    }
}
