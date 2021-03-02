package com.tencent.mm.plugin.game.luggage.ipc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.it;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.game.commlib.a;
import com.tencent.mm.plugin.game.protobuf.dv;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.ay;
import com.tencent.mm.plugin.webview.ui.tools.game.GameSettingParams;
import com.tencent.mm.plugin.webview.ui.tools.game.c;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;

public class CommonLogicTask extends MainProcessTask {
    public static final Parcelable.Creator<CommonLogicTask> CREATOR = new Parcelable.Creator<CommonLogicTask>() {
        /* class com.tencent.mm.plugin.game.luggage.ipc.CommonLogicTask.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ CommonLogicTask[] newArray(int i2) {
            return new CommonLogicTask[i2];
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CommonLogicTask createFromParcel(Parcel parcel) {
            AppMethodBeat.i(83040);
            CommonLogicTask commonLogicTask = new CommonLogicTask(parcel);
            AppMethodBeat.o(83040);
            return commonLogicTask;
        }
    };
    public Bundle dQL = new Bundle();
    public int type;
    public Runnable xwz;

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjk() {
        AppMethodBeat.i(83041);
        if (this.xwz != null) {
            this.xwz.run();
        }
        AppMethodBeat.o(83041);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void bjj() {
        WebViewJSSDKFileItem aYO;
        boolean z = true;
        AppMethodBeat.i(83042);
        switch (this.type) {
            case 1:
                if (this.dQL != null) {
                    boolean z2 = this.dQL.getBoolean("permission_allow", false);
                    String string = this.dQL.getString("url");
                    if (!Util.isNullOrNil(string)) {
                        q.a.JSZ.a(MMApplicationContext.getContext(), string, z2);
                        break;
                    } else {
                        Log.e("MicroMsg.ComonLogicTask", "ACTIVITY_JUMP_HANDLER, url is null");
                        AppMethodBeat.o(83042);
                        return;
                    }
                }
                break;
            case 2:
                if (this.dQL != null) {
                    int[] intArray = this.dQL.getIntArray("getConfigStgKey");
                    if (intArray != null && intArray.length != 0) {
                        ArrayList<String> arrayList = new ArrayList<>();
                        for (int i2 : intArray) {
                            g.aAi();
                            arrayList.add(Util.nullAsNil((String) g.aAh().azQ().get(i2, (Object) null)));
                        }
                        this.dQL.putStringArrayList("getConfigStgValue", arrayList);
                        break;
                    } else {
                        AppMethodBeat.o(83042);
                        return;
                    }
                }
                break;
            case 3:
                if (!(this.dQL == null || (aYO = com.tencent.mm.plugin.webview.modeltools.g.gdv().aYO(this.dQL.getString(ch.COL_LOCALID))) == null)) {
                    this.dQL.putParcelable("item", aYO);
                    break;
                }
            case 4:
                int Se = Se("WebViewDownLoadFileSwitch");
                if (this.dQL == null) {
                    this.dQL = new Bundle();
                }
                Bundle bundle = this.dQL;
                if (Se != 1) {
                    z = false;
                }
                bundle.putBoolean("allowDownloadFile", z);
                break;
            case 5:
                int Se2 = Se("EnableWebviewScanQRCode");
                Bundle bundle2 = this.dQL;
                if (Se2 != 1) {
                    z = false;
                }
                bundle2.putBoolean("allow_webview_scan", z);
                break;
            case 6:
                this.dQL.putBoolean("has_set_uin", g.aAc());
                break;
            case 8:
                this.dQL.putString("file_path", ay.aYZ(this.dQL.getString(ch.COL_LOCALID)));
                break;
            case 9:
                String string2 = this.dQL.getString("game_hv_menu_appid");
                it itVar = new it();
                itVar.dNs.EX = 3;
                itVar.dNs.param = string2;
                EventCenter.instance.publish(itVar);
                this.dQL.putString("game_hv_menu_pbcache", itVar.dNt.result);
                break;
            case 10:
                dv dSU = a.dSU();
                if (dSU != null) {
                    GameSettingParams gameSettingParams = new GameSettingParams();
                    gameSettingParams.Jqj = dSU.ixw;
                    gameSettingParams.Jqk = dSU.xHA;
                    gameSettingParams.Jql = dSU.xNo;
                    this.dQL.putParcelable("game_setting_params", gameSettingParams);
                    break;
                }
                break;
            case 11:
                c.bl(this.dQL);
                break;
        }
        bDU();
        AppMethodBeat.o(83042);
    }

    private static int Se(String str) {
        int i2 = 1;
        AppMethodBeat.i(83043);
        try {
            i2 = Util.getInt(h.aqJ().getValue(str), 1);
        } catch (Exception e2) {
            Log.e("MicroMsg.ComonLogicTask", "getIntValFromDynamicConfig parseInt failed, val: ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(83043);
        return i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(83044);
        parcel.writeInt(this.type);
        parcel.writeBundle(this.dQL);
        AppMethodBeat.o(83044);
    }

    @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
    public final void f(Parcel parcel) {
        AppMethodBeat.i(83045);
        this.type = parcel.readInt();
        this.dQL = parcel.readBundle(getClass().getClassLoader());
        AppMethodBeat.o(83045);
    }

    public CommonLogicTask() {
        AppMethodBeat.i(83046);
        AppMethodBeat.o(83046);
    }

    CommonLogicTask(Parcel parcel) {
        AppMethodBeat.i(83047);
        f(parcel);
        AppMethodBeat.o(83047);
    }

    static {
        AppMethodBeat.i(83048);
        AppMethodBeat.o(83048);
    }
}
