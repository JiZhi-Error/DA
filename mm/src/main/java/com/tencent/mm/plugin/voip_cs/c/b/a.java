package com.tencent.mm.plugin.voip_cs.c.b;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip_cs.c.c;
import com.tencent.mm.plugin.voip_cs.c.d;
import com.tencent.mm.protocal.protobuf.epd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class a {
    public com.tencent.mm.plugin.voip_cs.c.a Hsv = new com.tencent.mm.plugin.voip_cs.c.a(this.yqG);
    public AbstractC1901a Hsw = null;
    private MMHandler yqG = new MMHandler(Looper.getMainLooper()) {
        /* class com.tencent.mm.plugin.voip_cs.c.b.a.AnonymousClass1 */

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(125419);
            if (message == null) {
                super.handleMessage(message);
                AppMethodBeat.o(125419);
                return;
            }
            Log.d("MicroMsg.VoipCSEngine", "msg.what: %d, msg.obj: %s, msg.arg1: %s, msg.arg2: %s", Integer.valueOf(message.what), message.obj, Integer.valueOf(message.arg1), Integer.valueOf(message.arg2));
            switch (message.arg1) {
                case 1:
                    AppMethodBeat.o(125419);
                    return;
                case 3:
                    Log.d("MicroMsg.VoipCSEngine", "start dev!");
                    AppMethodBeat.o(125419);
                    return;
                case 4:
                    AppMethodBeat.o(125419);
                    return;
                case 5:
                    Log.i("MicroMsg.VoipCSEngine", "jni throw NOTIFY_FROM_JNI_RESET");
                    if (message.arg2 == 4) {
                        Log.i("MicroMsg.VoipCSEngine", "channel broken...");
                        c.fMt().Hrf = 1;
                    } else if (message.arg2 == 5) {
                        Log.i("MicroMsg.VoipCSEngine", "channel event network failer...");
                        c.fMt().Hrf = 6;
                    } else {
                        Log.i("MicroMsg.VoipCSEngine", "channel connect fail...");
                        c.fMt().Hrf = 5;
                    }
                    a aVar = a.this;
                    Log.i("MicroMsg.VoipCSEngine", "channel connect failed!");
                    c.fMt().dataType = 1;
                    if (aVar.Hsw != null) {
                        aVar.Hsw.fMN();
                    }
                    AppMethodBeat.o(125419);
                    return;
                case 6:
                    Log.i("MicroMsg.VoipCSEngine", "jni throw NOTIFY_FROM_JNI_CHANNEL_CONNECTED");
                    d fMt = c.fMt();
                    Log.d("MicroMsg.VoipCSReportHelper", "channelConnect");
                    fMt.Hri = 1;
                    a aVar2 = a.this;
                    Log.i("MicroMsg.VoipCSEngine", "channel connect!");
                    if (aVar2.yqI) {
                        Log.i("MicroMsg.VoipCSEngine", "channel already connect! do call not startEngine again");
                        AppMethodBeat.o(125419);
                        return;
                    }
                    aVar2.yqI = true;
                    Log.i("MicroMsg.VoipCSEngine", "start engine");
                    aVar2.Hsv.setInactive();
                    Log.d("MicroMsg.VoipCSEngine", "setChannelActiveAfterAccept");
                    if (!aVar2.yqI) {
                        Log.d("MicroMsg.VoipCSEngine", "channel not connect now");
                    }
                    aVar2.Hsv.setActive();
                    int startEngine = aVar2.Hsv.startEngine();
                    if (startEngine == 0) {
                        Log.i("MicroMsg.VoipCSEngine", "start engine suc!");
                        int[] iArr = {c.fMr().Hsv.HbT, c.fMr().Hsv.HbU};
                        Log.i("MicroMsg.VoipCSEngine", "steve: Get server config! MaxBR:" + iArr[0] + ", MaxFps:" + iArr[1]);
                        if (iArr[0] > 0 && iArr[1] > 0) {
                            ByteBuffer allocate = ByteBuffer.allocate(8);
                            allocate.order(ByteOrder.LITTLE_ENDIAN).asIntBuffer().put(iArr);
                            byte[] array = allocate.array();
                            if (c.fMr().Hsv.setAppCmd(34, array, array.length) < 0) {
                                Log.i("MicroMsg.VoipCSEngine", "setAppCmd: type:34,qosparam:" + iArr[0] + "," + iArr[1] + ",ret:" + startEngine);
                            }
                        }
                        c.fMt().Hrg = 1;
                    } else {
                        Log.i("MicroMsg.VoipCSEngine", "start engine fail!");
                        c.fMt().Hrg = 0;
                    }
                    if (!(aVar2.Hsw == null || c.fMs().HrL == 2)) {
                        aVar2.Hsw.dZP();
                        c.fMs().HrL = 2;
                    }
                    AppMethodBeat.o(125419);
                    return;
                case 8:
                    byte[] bArr = (byte[]) message.obj;
                    a aVar3 = a.this;
                    try {
                        epd epd = (epd) new epd().parseFrom(bArr);
                        e.Logi("MicroMsg.VoipCSEngine", "steve: onRecvRUDPCmd:" + epd.NmY);
                        switch (epd.NmY) {
                            case 3:
                                if (epd.NmZ == null) {
                                    e.Logi("MicroMsg.VoipCSEngine", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] empty buffer");
                                    break;
                                } else {
                                    byte[] bArr2 = epd.NmZ.zy;
                                    e.Logi("MicroMsg.VoipCSEngine", "steve: remote new network type:".concat(String.valueOf(bArr2)));
                                    int appCmd = aVar3.Hsv.setAppCmd(302, bArr2, 4);
                                    if (appCmd < 0) {
                                        e.Logi("MicroMsg.VoipCSEngine", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] update remote network type " + bArr2 + "fail:" + appCmd + ", [roomid=" + aVar3.Hsv.Haw + ", roomkey=" + aVar3.Hsv.ypH + "]");
                                    }
                                    AppMethodBeat.o(125419);
                                    return;
                                }
                        }
                        AppMethodBeat.o(125419);
                        return;
                    } catch (Exception e2) {
                        e.Logi("MicroMsg.VoipCSEngine", "onVoipLocalNetTypeChange Error");
                        break;
                    }
                case 100:
                    e.outputJniLog((byte[]) message.obj, "MicroMsg.VoipCSEngine", message.arg2);
                    AppMethodBeat.o(125419);
                    return;
                case 101:
                    e.outputJniLog((byte[]) message.obj, "MicroMsg.VoipCSEngine-JNI_CORE", message.arg2);
                    AppMethodBeat.o(125419);
                    return;
            }
            AppMethodBeat.o(125419);
        }
    };
    private boolean yqH = false;
    boolean yqI = false;

    /* renamed from: com.tencent.mm.plugin.voip_cs.c.b.a$a  reason: collision with other inner class name */
    public interface AbstractC1901a {
        void dZP();

        void fMN();
    }

    public a() {
        AppMethodBeat.i(125420);
        AppMethodBeat.o(125420);
    }

    public final com.tencent.mm.plugin.voip_cs.c.a fMM() {
        return this.Hsv;
    }

    public final int xe(boolean z) {
        int appCmd;
        AppMethodBeat.i(199029);
        if (z) {
            appCmd = this.Hsv.setAppCmd(401);
        } else {
            appCmd = this.Hsv.setAppCmd(402);
        }
        if (appCmd < 0) {
            e.Logd("MicroMsg.VoipCSEngine", "voipContext trySwitchSpeakerPhone ret:".concat(String.valueOf(appCmd)));
        }
        AppMethodBeat.o(199029);
        return appCmd;
    }

    public final void init() {
        AppMethodBeat.i(125421);
        this.yqI = false;
        this.yqH = false;
        if (this.Hsv.fIZ()) {
            Log.d("MicroMsg.VoipCSEngine", "protocal has init,now uninit!");
            this.Hsv.xh(false);
            this.Hsv.reset();
        }
        this.Hsv.Hav = 1;
        long currentTimeMillis = System.currentTimeMillis();
        int fMp = this.Hsv.fMp();
        Log.d("MicroMsg.VoipCSEngine", "protocal init finish, ret: %d, used %dms", Integer.valueOf(fMp), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        if (fMp < 0) {
            Log.e("MicroMsg.VoipCSEngine", "engine init failed!");
        }
        AppMethodBeat.o(125421);
    }
}
