package com.tencent.mm.service;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public abstract class MMService {
    ConcurrentHashMap<String, MMService> NJP = new ConcurrentHashMap<>();
    protected Service NJZ;
    private Vector<Integer> NKa = new Vector<>();
    private byte NKb = 0;
    int cWG = 0;

    public void onCreate() {
        Log.i(getTag(), "%s onCreate()", "MicroMsg.MMService");
    }

    @Deprecated
    public void onStart(Intent intent, int i2) {
        Log.i(getTag(), "%s onStart()", "MicroMsg.MMService");
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        Log.i(getTag(), "%s onStartCommand()", "MicroMsg.MMService");
        onStart(intent, i3);
        return 0;
    }

    public void onDestroy() {
        Log.i(getTag(), "%s onDestroy()", "MicroMsg.MMService");
    }

    public IBinder akL() {
        Log.i(getTag(), "%s onBind()", "MicroMsg.MMService");
        return null;
    }

    public final void startActivity(Intent intent) {
        Service service = this.NJZ;
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(service, bl.axQ(), "com/tencent/mm/service/MMService", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        service.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(service, "com/tencent/mm/service/MMService", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }

    public final void startForeground(int i2, Notification notification) {
        this.NJZ.startForeground(i2, notification);
    }

    public final void gxF() {
        this.NJZ.stopForeground(true);
    }

    public final void stopSelf() {
        Log.i(getTag(), "%s stopSelf()", "MicroMsg.MMService");
        q(new Intent(), "stop");
    }

    public boolean onUnbind(Intent intent) {
        Log.i(getTag(), "%s onUnbind()", "MicroMsg.MMService");
        return false;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x004a, code lost:
        if (r12.equals("bind") != false) goto L_0x0029;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.IBinder q(android.content.Intent r11, java.lang.String r12) {
        /*
        // Method dump skipped, instructions count: 334
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.service.MMService.q(android.content.Intent, java.lang.String):android.os.IBinder");
    }

    public String getTag() {
        return "MicroMsg.MMService";
    }
}
