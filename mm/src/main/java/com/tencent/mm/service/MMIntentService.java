package com.tencent.mm.service;

import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public abstract class MMIntentService extends MMService {
    private volatile a NJX;
    private String mName;

    /* access modifiers changed from: protected */
    public abstract void onHandleIntent(Intent intent);

    /* access modifiers changed from: package-private */
    public final class a extends MMHandler {
        public a(com.tencent.f.j.a aVar) {
            super(aVar);
        }

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(125309);
            MMIntentService.this.onHandleIntent((Intent) message.obj);
            MMIntentService mMIntentService = MMIntentService.this;
            int i2 = message.arg1;
            Log.i(mMIntentService.getTag(), "%s stopSelf() startId = %d mStartId = %d", "MicroMsg.MMService", Integer.valueOf(i2), Integer.valueOf(mMIntentService.cWG));
            if (i2 == mMIntentService.cWG) {
                mMIntentService.q(new Intent(), "stop");
            }
            AppMethodBeat.o(125309);
        }
    }

    public MMIntentService(String str) {
        this.mName = str;
    }

    @Override // com.tencent.mm.service.MMService
    public final void onCreate() {
        super.onCreate();
        this.NJX = new a(com.tencent.f.j.a.bqt("close-db-while-crash"));
    }

    @Override // com.tencent.mm.service.MMService
    public final void onStart(Intent intent, int i2) {
        Message obtainMessage = this.NJX.obtainMessage();
        obtainMessage.arg1 = i2;
        obtainMessage.obj = intent;
        this.NJX.sendMessage(obtainMessage);
    }

    @Override // com.tencent.mm.service.MMService
    public final int onStartCommand(Intent intent, int i2, int i3) {
        onStart(intent, i3);
        return 2;
    }

    @Override // com.tencent.mm.service.MMService
    public final void onDestroy() {
        this.NJX.getSerial().quit();
    }
}
