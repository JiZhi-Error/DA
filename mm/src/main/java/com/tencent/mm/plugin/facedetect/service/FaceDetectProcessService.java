package com.tencent.mm.plugin.facedetect.service;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.PluginFace;
import com.tencent.mm.plugin.facedetect.model.FaceContextData;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.g;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetect.model.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.service.MMService;
import com.tencent.mm.vfs.s;

public class FaceDetectProcessService extends MMService {
    private a sSN = new a();
    public g sSO = null;
    private Messenger sSP = null;
    private a sSQ = null;

    public FaceDetectProcessService() {
        AppMethodBeat.i(103859);
        AppMethodBeat.o(103859);
    }

    static /* synthetic */ void a(FaceDetectProcessService faceDetectProcessService, int i2) {
        AppMethodBeat.i(103868);
        faceDetectProcessService.fR(1, i2);
        AppMethodBeat.o(103868);
    }

    static /* synthetic */ void a(FaceDetectProcessService faceDetectProcessService, Bundle bundle) {
        AppMethodBeat.i(103869);
        faceDetectProcessService.o(1, bundle);
        AppMethodBeat.o(103869);
    }

    @Override // com.tencent.mm.service.MMService
    public final void onCreate() {
        AppMethodBeat.i(103860);
        Log.i("MicroMsg.FaceDetectProcessService", "alvinluo service onCreate hashCode: %d", Integer.valueOf(hashCode()));
        super.onCreate();
        this.sSO = new g();
        AppMethodBeat.o(103860);
    }

    @Override // com.tencent.mm.service.MMService
    public final int onStartCommand(Intent intent, int i2, int i3) {
        b bVar;
        int engineInit;
        AppMethodBeat.i(103861);
        Log.i("MicroMsg.FaceDetectProcessService", "alvinluo onStartCommand");
        if (intent == null) {
            Log.e("MicroMsg.FaceDetectProcessService", "intent is null!!");
            int onStartCommand = super.onStartCommand(intent, i2, i3);
            AppMethodBeat.o(103861);
            return onStartCommand;
        }
        Messenger messenger = (Messenger) intent.getParcelableExtra("k_messenger");
        if (messenger != null) {
            this.sSP = messenger;
            int onStartCommand2 = super.onStartCommand(intent, i2, i3);
            AppMethodBeat.o(103861);
            return onStartCommand2;
        }
        int intExtra = intent.getIntExtra("k_cmd", -1);
        Log.i("MicroMsg.FaceDetectProcessService", "hy: get command: %d", Integer.valueOf(intExtra));
        switch (intExtra) {
            case 0:
                String stringExtra = intent.getStringExtra("k_bio_id");
                byte[] byteArrayExtra = intent.getByteArrayExtra("k_bio_config");
                FaceContextData.a((FaceContextData) intent.getParcelableExtra("k_ontext_data"));
                switch (intent.getIntExtra("scene", 2)) {
                    case 0:
                    case 1:
                        bVar = null;
                        break;
                    case 2:
                    case 5:
                        bVar = new b();
                        break;
                    case 3:
                    case 4:
                    default:
                        bVar = null;
                        break;
                }
                this.sSQ = bVar;
                g gVar = this.sSO;
                if (gVar.sQQ != null) {
                    Log.w("MicroMsg.FaceDetectNativeManager", "hy: last detection not destroyed");
                    gVar.cTc();
                }
                if (!p.cTg()) {
                    Log.w("MicroMsg.FaceDetectNativeManager", "hy: model file not valid");
                    engineInit = -4;
                } else if (!PluginFace.isEnabled()) {
                    Log.w("MicroMsg.FaceDetectNativeManager", "expansions file is not yet installed");
                    engineInit = -5;
                } else {
                    gVar.sQQ = new FaceProNative();
                    engineInit = gVar.sQQ.engineInit(stringExtra, byteArrayExtra, s.k(p.cTl(), true), p.cTm());
                    Log.i("MicroMsg.FaceDetectNativeManager", "hy: init result : %d", Integer.valueOf(engineInit));
                }
                fR(0, engineInit);
                break;
            case 1:
                final AnonymousClass1 r0 = new q() {
                    /* class com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.facedetect.model.q
                    public final void b(final FaceProNative.FaceResult faceResult) {
                        int i2 = -1;
                        AppMethodBeat.i(103856);
                        Object[] objArr = new Object[2];
                        objArr[0] = Boolean.valueOf(faceResult == null);
                        objArr[1] = Integer.valueOf(faceResult != null ? faceResult.result : -1);
                        Log.i("MicroMsg.FaceDetectProcessService", "alvinluo release out result == null:%b, result: %d", objArr);
                        if (faceResult == null || faceResult.result != 0) {
                            Log.i("MicroMsg.FaceDetectProcessService", "alvinluo release out data not valid");
                            if (faceResult != null) {
                                i2 = faceResult.result;
                            }
                            FaceDetectProcessService.a(FaceDetectProcessService.this, i2);
                            AppMethodBeat.o(103856);
                            return;
                        }
                        f.ao(new Runnable() {
                            /* class com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(103855);
                                String a2 = p.a(faceResult);
                                Bundle bundle = new Bundle();
                                bundle.putInt("key_face_result_code", 0);
                                bundle.putString("key_face_result_file_path", a2);
                                FaceDetectProcessService.a(FaceDetectProcessService.this, bundle);
                                AppMethodBeat.o(103855);
                            }
                        });
                        AppMethodBeat.o(103856);
                    }
                };
                f.ao(new Runnable() {
                    /* class com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(103858);
                        Log.i("MicroMsg.FaceDetectProcessService", "alvinluo service do release out");
                        final FaceProNative.FaceResult cTb = FaceDetectProcessService.this.sSO.cTb();
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService.AnonymousClass2.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(103857);
                                r0.b(cTb);
                                AppMethodBeat.o(103857);
                            }
                        });
                        AppMethodBeat.o(103858);
                    }
                });
                break;
            case 2:
            case 3:
            default:
                Log.e("MicroMsg.FaceDetectProcessService", "hy: unsupported cmd");
                break;
            case 4:
                com.tencent.mm.plugin.facedetect.e.a.cTF().sUx = intent.getBooleanExtra("needVideo", false);
                break;
            case 5:
                if (this.sSQ != null) {
                    this.sSQ.aj(intent);
                    break;
                }
                break;
            case 6:
                String stringExtra2 = intent.getStringExtra("key_bio_buffer_path");
                Bundle bundle = new Bundle();
                bundle.putString("key_bio_buffer_path", stringExtra2);
                o(6, bundle);
                break;
        }
        int onStartCommand3 = super.onStartCommand(intent, i2, i3);
        AppMethodBeat.o(103861);
        return onStartCommand3;
    }

    @Override // com.tencent.mm.service.MMService
    public final IBinder akL() {
        AppMethodBeat.i(103862);
        Log.i("MicroMsg.FaceDetectProcessService", "alvinluo service onBind hashCode: %d", Integer.valueOf(hashCode()));
        this.sSN = new a();
        a aVar = this.sSN;
        AppMethodBeat.o(103862);
        return aVar;
    }

    @Override // com.tencent.mm.service.MMService
    public final boolean onUnbind(Intent intent) {
        AppMethodBeat.i(103863);
        Log.i("MicroMsg.FaceDetectProcessService", "alvinluo service onUnbind");
        boolean onUnbind = super.onUnbind(intent);
        AppMethodBeat.o(103863);
        return onUnbind;
    }

    @Override // com.tencent.mm.service.MMService
    public final void onDestroy() {
        AppMethodBeat.i(103864);
        Log.i("MicroMsg.FaceDetectProcessService", "alvinluo service onDestroy");
        super.onDestroy();
        AppMethodBeat.o(103864);
    }

    public class a extends Binder {
        public a() {
        }
    }

    private void n(Message message) {
        AppMethodBeat.i(103865);
        try {
            if (this.sSP != null) {
                Log.i("MicroMsg.FaceDetectProcessService", "alvinluo serivce send msg to client: %d, msg: %s, client hashCode: %d", Integer.valueOf(message.what), message.toString(), Integer.valueOf(this.sSP.hashCode()));
                this.sSP.send(message);
            }
            AppMethodBeat.o(103865);
        } catch (RemoteException e2) {
            Log.printErrStackTrace("MicroMsg.FaceDetectProcessService", e2, "", new Object[0]);
            AppMethodBeat.o(103865);
        }
    }

    private void fR(int i2, int i3) {
        AppMethodBeat.i(103866);
        Log.i("MicroMsg.FaceDetectProcessService", "alvinluo replyToClient requestCode: %d, resultCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        Message message = new Message();
        message.what = i2;
        message.arg1 = i3;
        n(message);
        AppMethodBeat.o(103866);
    }

    private void o(int i2, Bundle bundle) {
        AppMethodBeat.i(103867);
        Message obtain = Message.obtain();
        obtain.what = i2;
        if (bundle != null) {
            obtain.setData(bundle);
        }
        n(obtain);
        AppMethodBeat.o(103867);
    }

    @Override // com.tencent.mm.service.MMService
    public final String getTag() {
        return "MicroMsg.FaceDetectProcessService";
    }
}
