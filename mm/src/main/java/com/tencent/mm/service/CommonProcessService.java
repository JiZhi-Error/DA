package com.tencent.mm.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.service.b;
import java.util.concurrent.ConcurrentHashMap;

public class CommonProcessService extends Service {
    private static ConcurrentHashMap<String, MMService> NJP = new ConcurrentHashMap<>();
    private b.a NJQ = new b.a() {
        /* class com.tencent.mm.service.CommonProcessService.AnonymousClass1 */

        @Override // com.tencent.mm.service.b
        public final void a(final Intent intent, final a aVar) {
            AppMethodBeat.i(125291);
            if (intent != null) {
                CommonProcessService.this.handler.post(new Runnable() {
                    /* class com.tencent.mm.service.CommonProcessService.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(125287);
                        intent.setExtrasClassLoader(CommonProcessService.class.getClassLoader());
                        String stringExtra = intent.getStringExtra("class_name");
                        try {
                            MMService mMService = (MMService) CommonProcessService.NJP.get(stringExtra);
                            if (mMService == null) {
                                mMService = (MMService) Class.forName(stringExtra).newInstance();
                                mMService.NJP = CommonProcessService.NJP;
                                mMService.NJZ = CommonProcessService.this;
                                CommonProcessService.NJP.put(stringExtra, mMService);
                            }
                            IBinder q = mMService.q(intent, "bind");
                            try {
                                if (aVar != null) {
                                    aVar.O(q);
                                }
                            } catch (RemoteException e2) {
                                Log.i(CommonProcessService.this.getTag(), "bindService() immserviceConnectionStubAIDL RemoteException: %s", e2.getMessage());
                            }
                            e.INSTANCE.idkeyStat(963, 39, 1, false);
                            Log.i(CommonProcessService.this.getTag(), "bindService() class_name = %s", stringExtra);
                            AppMethodBeat.o(125287);
                        } catch (Exception e3) {
                            Log.i(CommonProcessService.this.getTag(), "bindService()  Class.forName(%s) Exception: %s", stringExtra, e3.getMessage());
                            AppMethodBeat.o(125287);
                        }
                    }
                });
            } else {
                Log.i(CommonProcessService.this.getTag(), "bindService() intent == null");
            }
            e.INSTANCE.idkeyStat(963, 38, 1, false);
            AppMethodBeat.o(125291);
        }

        @Override // com.tencent.mm.service.b
        public final void bw(final Intent intent) {
            AppMethodBeat.i(125292);
            if (intent != null) {
                CommonProcessService.this.handler.post(new Runnable() {
                    /* class com.tencent.mm.service.CommonProcessService.AnonymousClass1.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(125288);
                        intent.setExtrasClassLoader(CommonProcessService.class.getClassLoader());
                        String stringExtra = intent.getStringExtra("class_name");
                        MMService mMService = (MMService) CommonProcessService.NJP.get(stringExtra);
                        if (mMService != null) {
                            mMService.q(intent, "unbind");
                            e.INSTANCE.idkeyStat(963, 54, 1, false);
                        }
                        Log.i(CommonProcessService.this.getTag(), "unbindService() class_name = %s", stringExtra);
                        AppMethodBeat.o(125288);
                    }
                });
            } else {
                Log.i(CommonProcessService.this.getTag(), "unbindService() intent == null");
            }
            e.INSTANCE.idkeyStat(963, 53, 1, false);
            AppMethodBeat.o(125292);
        }

        @Override // com.tencent.mm.service.b
        public final void startService(final Intent intent) {
            AppMethodBeat.i(125293);
            if (intent != null) {
                CommonProcessService.this.handler.post(new Runnable() {
                    /* class com.tencent.mm.service.CommonProcessService.AnonymousClass1.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(125289);
                        intent.setExtrasClassLoader(CommonProcessService.class.getClassLoader());
                        String stringExtra = intent.getStringExtra("class_name");
                        try {
                            MMService mMService = (MMService) CommonProcessService.NJP.get(stringExtra);
                            if (mMService == null) {
                                mMService = (MMService) Class.forName(stringExtra).newInstance();
                                mMService.NJP = CommonProcessService.NJP;
                                mMService.NJZ = CommonProcessService.this;
                                CommonProcessService.NJP.put(stringExtra, mMService);
                            }
                            mMService.q(intent, "start");
                            e.INSTANCE.idkeyStat(963, 8, 1, false);
                            Log.i(CommonProcessService.this.getTag(), "startService() class_name = %s", stringExtra);
                            AppMethodBeat.o(125289);
                        } catch (Exception e2) {
                            Log.i(CommonProcessService.this.getTag(), "startService()  Class.forName(%s) Exception: %s", stringExtra, e2.getMessage());
                            AppMethodBeat.o(125289);
                        }
                    }
                });
            } else {
                Log.i(CommonProcessService.this.getTag(), "startService() intent == null");
            }
            e.INSTANCE.idkeyStat(963, 7, 1, false);
            AppMethodBeat.o(125293);
        }

        @Override // com.tencent.mm.service.b
        public final void bs(final Intent intent) {
            AppMethodBeat.i(125294);
            if (intent != null) {
                CommonProcessService.this.handler.post(new Runnable() {
                    /* class com.tencent.mm.service.CommonProcessService.AnonymousClass1.AnonymousClass4 */

                    public final void run() {
                        AppMethodBeat.i(125290);
                        intent.setExtrasClassLoader(CommonProcessService.class.getClassLoader());
                        String stringExtra = intent.getStringExtra("class_name");
                        MMService mMService = (MMService) CommonProcessService.NJP.get(stringExtra);
                        if (mMService != null) {
                            mMService.q(intent, "stop");
                            e.INSTANCE.idkeyStat(963, 24, 1, false);
                        }
                        Log.i(CommonProcessService.this.getTag(), "stopService() class_name = %s", stringExtra);
                        AppMethodBeat.o(125290);
                    }
                });
            } else {
                Log.i(CommonProcessService.this.getTag(), "stopService() intent == null");
            }
            e.INSTANCE.idkeyStat(963, 23, 1, false);
            AppMethodBeat.o(125294);
        }
    };
    private Handler handler;

    public CommonProcessService() {
        AppMethodBeat.i(125295);
        AppMethodBeat.o(125295);
    }

    static {
        AppMethodBeat.i(125303);
        AppMethodBeat.o(125303);
    }

    public void onCreate() {
        AppMethodBeat.i(125296);
        Log.i(getTag(), "onCreate()");
        this.handler = new Handler();
        super.onCreate();
        AppMethodBeat.o(125296);
    }

    public void onStart(Intent intent, int i2) {
        AppMethodBeat.i(125297);
        Log.i(getTag(), "onStart()");
        super.onStart(intent, i2);
        AppMethodBeat.o(125297);
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        AppMethodBeat.i(125298);
        Log.i(getTag(), "onStartCommand()");
        AppMethodBeat.o(125298);
        return 1;
    }

    public void onDestroy() {
        AppMethodBeat.i(125299);
        Log.i(getTag(), "onDestroy()");
        super.onDestroy();
        AppMethodBeat.o(125299);
    }

    public boolean onUnbind(Intent intent) {
        AppMethodBeat.i(125300);
        Log.i(getTag(), "onUnbind()");
        boolean onUnbind = super.onUnbind(intent);
        AppMethodBeat.o(125300);
        return onUnbind;
    }

    public void onRebind(Intent intent) {
        AppMethodBeat.i(125301);
        Log.i(getTag(), "onRebind()");
        super.onRebind(intent);
        AppMethodBeat.o(125301);
    }

    public IBinder onBind(Intent intent) {
        AppMethodBeat.i(125302);
        Log.i(getTag(), "onBind()");
        b.a aVar = this.NJQ;
        AppMethodBeat.o(125302);
        return aVar;
    }

    public String getTag() {
        return "MicroMsg.MMProcessService";
    }
}
