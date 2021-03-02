package com.tencent.mm.plugin.notification.a;

import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.as;

public final class a implements MStorageEx.IOnStorageChange {
    private final int AGw = 50;
    public boolean AGx = false;
    private final String TAG = "MicroMsg.NotificationObserver";
    private MMHandler mHandler = new MMHandler(Looper.getMainLooper()) {
        /* class com.tencent.mm.plugin.notification.a.a.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(26720);
            super.handleMessage(message);
            final String string = message.getData().getString("com.tencent.mm.notification.observer");
            bg.aAk().postToWorkerDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.notification.a.a.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    final int i2 = 0;
                    AppMethodBeat.i(26719);
                    if (!g.aAf().azp()) {
                        Log.w("MicroMsg.NotificationObserver", "account not init.");
                        AppMethodBeat.o(26719);
                        return;
                    }
                    final int aqG = com.tencent.mm.n.g.aqG();
                    bg.aVF();
                    as Kn = c.aSN().Kn(string);
                    final boolean Zx = Kn == null ? false : Kn.Zx();
                    if (!Zx) {
                        i2 = com.tencent.mm.n.g.Eo(string);
                    }
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.notification.a.a.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(26718);
                            bg.getNotification().nR(aqG);
                            if (!Zx) {
                                bg.getNotification().C(string, i2);
                            }
                            Log.i("MicroMsg.NotificationObserver", "NotificationObserver refresh total badge count: %d, and talker badge count: %d, talker is mute: %b", Integer.valueOf(aqG), Integer.valueOf(i2), Boolean.valueOf(Zx));
                            ThreadPool.post(new Runnable() {
                                /* class com.tencent.mm.plugin.notification.a.a.AnonymousClass1.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(26717);
                                    bg.getNotification().r(aqG, string);
                                    if (a.this.AGx) {
                                        a.this.AGx = false;
                                        bg.getNotification().dj(false);
                                    }
                                    AppMethodBeat.o(26717);
                                }
                            }, "NotificationObserver");
                            AppMethodBeat.o(26718);
                        }
                    });
                    AppMethodBeat.o(26719);
                }
            }, 500);
            AppMethodBeat.o(26720);
        }
    };

    public a() {
        AppMethodBeat.i(26721);
        AppMethodBeat.o(26721);
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        int i3;
        AppMethodBeat.i(26722);
        Log.i("MicroMsg.NotificationObserver", "event: %d", Integer.valueOf(i2));
        if (!(obj instanceof String) || Util.isNullOrNil((String) obj)) {
            Log.d("MicroMsg.NotificationObserver", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i2), mStorageEx, obj);
            AppMethodBeat.o(26722);
            return;
        }
        if (!bg.aVy()) {
            bg.aVF();
            i3 = (int) c.aSN().bjJ((String) obj).gMZ;
        } else {
            i3 = 0;
        }
        this.mHandler.removeMessages(i3);
        Message obtain = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putString("com.tencent.mm.notification.observer", (String) obj);
        obtain.setData(bundle);
        obtain.what = i3;
        this.mHandler.sendMessageDelayed(obtain, 50);
        AppMethodBeat.o(26722);
    }
}
