package com.tencent.mm.plugin.exdevice.model;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.exdevice.i.b;
import com.tencent.mm.protocal.protobuf.bjy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.lang.ref.WeakReference;

public enum i implements com.tencent.mm.ak.i {
    INSTANCE;
    
    ProgressDialog gtM;
    public WeakReference<a> hfj;
    private boolean rAj = false;

    public interface a {
        void lP(boolean z);
    }

    public static i valueOf(String str) {
        AppMethodBeat.i(23367);
        i iVar = (i) Enum.valueOf(i.class, str);
        AppMethodBeat.o(23367);
        return iVar;
    }

    static {
        AppMethodBeat.i(23374);
        AppMethodBeat.o(23374);
    }

    private i(String str) {
        AppMethodBeat.i(23368);
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("exdevice_pref", 0);
        StringBuilder sb = new StringBuilder();
        bg.aVF();
        long j2 = sharedPreferences.getLong(sb.append(c.getUin()).toString(), 0);
        if (j2 != 0) {
            Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "this user has get bound device, last time is %d", Long.valueOf(j2));
            AppMethodBeat.o(23368);
            return;
        }
        Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "the user has not get bound device yet");
        AppMethodBeat.o(23368);
    }

    public final void a(Context context, final a aVar) {
        AppMethodBeat.i(23369);
        Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "startGetBoundHardDevices");
        if (this.rAj) {
            if (this.hfj == null) {
                this.hfj = new WeakReference<>(aVar);
            }
            Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "getting bound device now, just leave");
            AppMethodBeat.o(23369);
            return;
        }
        final o oVar = new o();
        if (context != null && (context instanceof Activity) && !((Activity) context).isFinishing()) {
            if (this.gtM != null && this.gtM.isShowing()) {
                this.gtM.dismiss();
                this.gtM = null;
            }
            if (!(context instanceof LauncherUI) && !(context instanceof ChattingUI) && !(context instanceof BaseConversationUI)) {
                context.getString(R.string.zb);
                this.gtM = h.b(context, context.getString(R.string.gct), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.exdevice.model.i.AnonymousClass1 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(23364);
                        bg.azz().a(oVar);
                        if (i.this.gtM != null) {
                            i.this.gtM.dismiss();
                        }
                        i.this.rAj = false;
                        if (aVar != null) {
                            aVar.lP(false);
                        }
                        i.this.gtM = null;
                        AppMethodBeat.o(23364);
                    }
                });
            }
        }
        this.hfj = new WeakReference<>(aVar);
        bg.azz().a(oVar, 0);
        AppMethodBeat.o(23369);
    }

    public final boolean lQ(boolean z) {
        AppMethodBeat.i(23370);
        if (this.rAj) {
            Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "Getting bound device now, just leave");
            AppMethodBeat.o(23370);
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("exdevice_pref", 0);
        StringBuilder sb = new StringBuilder();
        bg.aVF();
        long j2 = sharedPreferences.getLong(sb.append(c.getUin()).toString(), 0);
        if (z || currentTimeMillis - j2 >= Util.MILLSECONDS_OF_DAY) {
            AppMethodBeat.o(23370);
            return true;
        }
        Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "GetBoundHardDevices not now pp");
        AppMethodBeat.o(23370);
        return false;
    }

    public static void CS(long j2) {
        AppMethodBeat.i(23371);
        Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "update get bound hard device time : %d", Long.valueOf(j2));
        SharedPreferences.Editor edit = MMApplicationContext.getContext().getSharedPreferences("exdevice_pref", 0).edit();
        StringBuilder sb = new StringBuilder();
        bg.aVF();
        edit.putLong(sb.append(c.getUin()).toString(), j2).commit();
        AppMethodBeat.o(23371);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        a aVar;
        final bjy bjy;
        a aVar2;
        a aVar3;
        AppMethodBeat.i(23372);
        Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "onSceneEnd errType = " + i2 + ", errCode = " + i3 + ",errMsg = " + str);
        this.rAj = false;
        if (qVar != null && i3 == 0 && i2 == 0) {
            Log.i("MicroMsg.exdevice.GetBoundDeviceLogic", "scene.getType() = %s", Integer.valueOf(qVar.getType()));
            if (qVar.getType() == 539) {
                if (i2 == 0 && i3 == 0) {
                    o oVar = (o) qVar;
                    if (oVar.rr == null || oVar.rr.iLL.iLR == null) {
                        bjy = null;
                    } else {
                        bjy = (bjy) oVar.rr.iLL.iLR;
                    }
                    if (bjy == null || bjy.LTo == null) {
                        if (!(this.hfj == null || (aVar2 = this.hfj.get()) == null)) {
                            aVar2.lP(false);
                        }
                        if (this.gtM != null && this.gtM.isShowing()) {
                            this.gtM.dismiss();
                        }
                        AppMethodBeat.o(23372);
                        return;
                    }
                    bg.aAk().postToWorker(new Runnable() {
                        /* class com.tencent.mm.plugin.exdevice.model.i.AnonymousClass2 */

                        /* JADX WARNING: Removed duplicated region for block: B:11:0x0045  */
                        /* JADX WARNING: Removed duplicated region for block: B:24:0x00b1  */
                        /* JADX WARNING: Removed duplicated region for block: B:7:0x0038  */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final void run() {
                            /*
                            // Method dump skipped, instructions count: 573
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.exdevice.model.i.AnonymousClass2.run():void");
                        }
                    });
                    if (!(this.hfj == null || (aVar3 = this.hfj.get()) == null)) {
                        aVar3.lP(true);
                    }
                } else {
                    Log.e("MicroMsg.exdevice.GetBoundDeviceLogic", "scene.getType() = %s, %s, %s", Integer.valueOf(qVar.getType()), Integer.valueOf(i2), Integer.valueOf(i3));
                    if (!(this.hfj == null || (aVar = this.hfj.get()) == null)) {
                        aVar.lP(false);
                    }
                    if (this.gtM != null && this.gtM.isShowing()) {
                        this.gtM.dismiss();
                        this.gtM = null;
                    }
                    AppMethodBeat.o(23372);
                    return;
                }
            }
            if (this.gtM != null && this.gtM.isShowing()) {
                this.gtM.dismiss();
                this.gtM = null;
            }
            AppMethodBeat.o(23372);
            return;
        }
        Log.e("MicroMsg.exdevice.GetBoundDeviceLogic", "do scene failed : %d, %d", Integer.valueOf(i3), Integer.valueOf(i2));
        if (this.gtM != null && this.gtM.isShowing()) {
            this.gtM.dismiss();
            this.gtM = null;
        }
        AppMethodBeat.o(23372);
    }

    static /* synthetic */ void d(b bVar) {
        AppMethodBeat.i(23373);
        if (!(bVar == null || bVar.field_connProto == null || (!bVar.field_connProto.contains("1") && !bVar.field_connProto.contains(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)))) {
            Log.d("MicroMsg.exdevice.GetBoundDeviceLogic", "disconnect deviceId %s, deviceType %s ", bVar.field_deviceID, bVar.field_deviceType);
            ad.cKS();
            d.CM(bVar.field_mac);
        }
        AppMethodBeat.o(23373);
    }
}
