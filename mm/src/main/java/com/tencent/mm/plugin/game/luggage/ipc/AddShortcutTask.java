package com.tencent.mm.plugin.game.luggage.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.webview.model.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public class AddShortcutTask extends MainProcessTask {
    public static final Parcelable.Creator<AddShortcutTask> CREATOR = new Parcelable.Creator<AddShortcutTask>() {
        /* class com.tencent.mm.plugin.game.luggage.ipc.AddShortcutTask.AnonymousClass2 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AddShortcutTask[] newArray(int i2) {
            return new AddShortcutTask[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AddShortcutTask createFromParcel(Parcel parcel) {
            AppMethodBeat.i(83032);
            AddShortcutTask addShortcutTask = new AddShortcutTask(parcel, (byte) 0);
            AppMethodBeat.o(83032);
            return addShortcutTask;
        }
    };
    public String appId;
    public Runnable lyv;
    public boolean success;
    public String username;

    /* synthetic */ AddShortcutTask(Parcel parcel, byte b2) {
        this(parcel);
    }

    static /* synthetic */ boolean a(AddShortcutTask addShortcutTask) {
        AppMethodBeat.i(83038);
        boolean bDU = addShortcutTask.bDU();
        AppMethodBeat.o(83038);
        return bDU;
    }

    public AddShortcutTask() {
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjj() {
        AppMethodBeat.i(83033);
        if (Util.isNullOrNil(this.appId) || Util.isNullOrNil(this.username)) {
            Log.e("MicroMsg.AddShortcutTask", "appid or username is null");
            this.success = false;
            AppMethodBeat.o(83033);
            return;
        }
        e.a(MMApplicationContext.getContext(), this.username, this.appId, new e.a() {
            /* class com.tencent.mm.plugin.game.luggage.ipc.AddShortcutTask.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.webview.model.e.a
            public final void pI(boolean z) {
                AppMethodBeat.i(83031);
                AddShortcutTask.this.success = z;
                AddShortcutTask.a(AddShortcutTask.this);
                AppMethodBeat.o(83031);
            }
        });
        AppMethodBeat.o(83033);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjk() {
        AppMethodBeat.i(83034);
        if (this.lyv != null) {
            this.lyv.run();
        }
        AppMethodBeat.o(83034);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void f(Parcel parcel) {
        boolean z = true;
        AppMethodBeat.i(83035);
        this.username = parcel.readString();
        this.appId = parcel.readString();
        if (parcel.readByte() != 1) {
            z = false;
        }
        this.success = z;
        AppMethodBeat.o(83035);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(83036);
        parcel.writeString(this.username);
        parcel.writeString(this.appId);
        parcel.writeByte((byte) (this.success ? 1 : 0));
        AppMethodBeat.o(83036);
    }

    private AddShortcutTask(Parcel parcel) {
        AppMethodBeat.i(83037);
        f(parcel);
        AppMethodBeat.o(83037);
    }

    static {
        AppMethodBeat.i(83039);
        AppMethodBeat.o(83039);
    }
}
