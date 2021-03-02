package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.storage.az;

class JsApiGetContactMessageCountTask extends MainProcessTask {
    public static final Parcelable.Creator<JsApiGetContactMessageCountTask> CREATOR = new Parcelable.Creator<JsApiGetContactMessageCountTask>() {
        /* class com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiGetContactMessageCountTask.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ JsApiGetContactMessageCountTask[] newArray(int i2) {
            return new JsApiGetContactMessageCountTask[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ JsApiGetContactMessageCountTask createFromParcel(Parcel parcel) {
            AppMethodBeat.i(46268);
            JsApiGetContactMessageCountTask jsApiGetContactMessageCountTask = new JsApiGetContactMessageCountTask(parcel);
            AppMethodBeat.o(46268);
            return jsApiGetContactMessageCountTask;
        }
    };
    public int dCm;
    public Runnable lyv;
    public String username;

    public JsApiGetContactMessageCountTask() {
    }

    public JsApiGetContactMessageCountTask(Parcel parcel) {
        AppMethodBeat.i(46269);
        f(parcel);
        AppMethodBeat.o(46269);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjj() {
        AppMethodBeat.i(46270);
        az bjY = ((l) g.af(l.class)).aST().bjY(this.username);
        if (bjY == null) {
            this.dCm = -1;
            bDU();
            AppMethodBeat.o(46270);
            return;
        }
        this.dCm = bjY.field_unReadCount;
        bDU();
        AppMethodBeat.o(46270);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjk() {
        AppMethodBeat.i(46271);
        if (this.lyv != null) {
            this.lyv.run();
        }
        AppMethodBeat.o(46271);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void f(Parcel parcel) {
        AppMethodBeat.i(46272);
        this.username = parcel.readString();
        this.dCm = parcel.readInt();
        AppMethodBeat.o(46272);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(46273);
        parcel.writeString(this.username);
        parcel.writeInt(this.dCm);
        AppMethodBeat.o(46273);
    }

    static {
        AppMethodBeat.i(46274);
        AppMethodBeat.o(46274);
    }
}
