package com.tencent.mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.wear.model.d.c;
import com.tencent.mm.plugin.wear.model.e.p;
import com.tencent.mm.plugin.wear.model.f.d;
import com.tencent.mm.protocal.protobuf.ezu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.WeChatPermissions;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.s;
import java.io.IOException;

public class WearMessageLogic extends BroadcastReceiver {
    private static final String IxU = WeChatPermissions.PERMISSION_WEAR_MESSAGE();

    static {
        AppMethodBeat.i(232127);
        AppMethodBeat.o(232127);
    }

    public WearMessageLogic() {
        AppMethodBeat.i(30007);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.wear.message");
        MMApplicationContext.getContext().registerReceiver(this, intentFilter, IxU, null);
        AppMethodBeat.o(30007);
    }

    public void onReceive(Context context, Intent intent) {
        boolean z;
        AppMethodBeat.i(30008);
        ((com.tencent.mm.plugin.boots.a.c) g.af(com.tencent.mm.plugin.boots.a.c.class)).fb(com.tencent.mm.plugin.boots.a.b.pkC, 1170);
        if (intent.getAction().equals("com.tencent.mm.wear.message")) {
            Bundle extras = intent.getExtras();
            int i2 = extras.getInt("key_connecttype");
            if (i2 == 1) {
                a aVar = new a(this, (byte) 0);
                aVar.IxV = i2;
                aVar.jiX = extras.getInt("key_funid");
                aVar.dEb = extras.getInt("key_sessionid");
                aVar.IxW = extras.getByteArray("key_data");
                com.tencent.mm.plugin.wear.model.e.a afj = a.fVP().afj(aVar.jiX);
                if (afj != null) {
                    z = afj.afi(aVar.jiX);
                } else {
                    z = false;
                }
                if (z) {
                    MMHandlerThread.postToMainThread(aVar);
                    AppMethodBeat.o(30008);
                    return;
                }
                ThreadPool.post(aVar, "WearHttpMessageTask_" + aVar.jiX);
                AppMethodBeat.o(30008);
                return;
            } else if (i2 == 2) {
                b bVar = new b(this, (byte) 0);
                bVar.IxV = i2;
                bVar.jiX = extras.getInt("key_funid");
                bVar.dEb = extras.getInt("key_sessionid");
                bVar.IxW = extras.getByteArray("key_data");
                a.fVN().a(bVar);
                AppMethodBeat.o(30008);
                return;
            } else if (i2 == 3) {
                a.fVN().a(new c(this, (byte) 0));
            }
        }
        AppMethodBeat.o(30008);
    }

    class c extends d {
        private c() {
        }

        /* synthetic */ c(WearMessageLogic wearMessageLogic, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.wear.model.f.d
        public final void execute() {
            AppMethodBeat.i(30006);
            if (a.fVM().fVX() != null) {
                a.fVM().fVX().fVZ();
            }
            AppMethodBeat.o(30006);
        }

        @Override // com.tencent.mm.plugin.wear.model.f.d
        public final String getName() {
            return "RefreshConnectTask";
        }
    }

    class b extends d {
        public int IxV;
        public byte[] IxW;
        public int dEb;
        public int jiX;

        private b() {
        }

        /* synthetic */ b(WearMessageLogic wearMessageLogic, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.wear.model.f.d
        public final void execute() {
            AppMethodBeat.i(30005);
            switch (this.jiX) {
                case CdnLogic.kMediaLittleAppPacket:
                    p pVar = a.fVM().IxJ;
                    int i2 = this.dEb;
                    byte[] bArr = this.IxW;
                    if (!pVar.ljc.contains(Integer.valueOf(i2))) {
                        ezu ezu = new ezu();
                        try {
                            ezu.parseFrom(bArr);
                        } catch (IOException e2) {
                        }
                        if (pVar.IyC != i2) {
                            pVar.reset();
                            pVar.IyC = i2;
                            Log.i("MicroMsg.Wear.VoiceToTextServer", "startNewSession %s", Integer.valueOf(pVar.IyC));
                            s.deleteFile(p.Iyx);
                            if (pVar.IyA == null) {
                                pVar.IyA = new com.tencent.mm.audio.e.d();
                                pVar.IyA.hz(p.Iyx);
                            }
                            if (pVar.Iyz == null) {
                                pVar.Iyz = new com.tencent.qqpinyin.voicerecoapi.c(1500000);
                                if (pVar.Iyz.hkt() != 0) {
                                    pVar.IyD = -2;
                                    AppMethodBeat.o(30005);
                                    return;
                                }
                            }
                            String str = ezu.MRZ;
                            if (pVar.Iyy == null) {
                                MMHandlerThread.postToMainThread(new Runnable(str) {
                                    /* class com.tencent.mm.plugin.wear.model.e.p.AnonymousClass1 */
                                    final /* synthetic */ String gMw;

                                    {
                                        this.gMw = r2;
                                    }

                                    public final void run() {
                                        AppMethodBeat.i(30101);
                                        p.this.Iyy = new c(p.Iyx, this.gMw, p.this.IyC);
                                        bg.azz().a(349, p.this);
                                        Log.i("MicroMsg.Wear.VoiceToTextServer", "Create NetSceneVoiceInput");
                                        AppMethodBeat.o(30101);
                                    }
                                });
                            }
                            pVar.a(i2, ezu);
                            break;
                        } else if (ezu.NvU) {
                            Log.i("MicroMsg.Wear.VoiceToTextServer", "cancel session %d", Integer.valueOf(i2));
                            pVar.reset();
                            AppMethodBeat.o(30005);
                            return;
                        } else if (ezu.NvT) {
                            pVar.a(i2, ezu);
                            if (pVar.IyA != null) {
                                pVar.IyA.abP();
                                pVar.IyA = null;
                                Log.i("MicroMsg.Wear.VoiceToTextServer", "finish speex compress");
                            }
                            if (pVar.Iyz != null) {
                                pVar.Iyz.stop();
                                pVar.Iyz = null;
                                Log.i("MicroMsg.Wear.VoiceToTextServer", "finish voiceDetectAPI");
                            }
                            if (pVar.Iyy != null) {
                                pVar.Iyy.jul = true;
                                if (!pVar.ehd) {
                                    bg.azz().a(pVar.Iyy, 0);
                                }
                                pVar.Iyy = null;
                                Log.i("MicroMsg.Wear.VoiceToTextServer", "finish netSceneVoiceToText");
                            }
                            AppMethodBeat.o(30005);
                            return;
                        } else {
                            pVar.a(i2, ezu);
                            AppMethodBeat.o(30005);
                            return;
                        }
                    }
                    break;
            }
            AppMethodBeat.o(30005);
        }

        @Override // com.tencent.mm.plugin.wear.model.f.d
        public final String getName() {
            return "LongConnectTask";
        }
    }

    class a extends d {
        public int IxV;
        public byte[] IxW;
        public int dEb;
        public int jiX;

        private a() {
        }

        /* synthetic */ a(WearMessageLogic wearMessageLogic, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.wear.model.f.d
        public final void execute() {
            AppMethodBeat.i(30003);
            Log.i("MicroMsg.Wear.WearMessageLogic", "handle message %s", toString());
            com.tencent.mm.plugin.wear.model.e.a afj = a.fVP().afj(this.jiX);
            if (afj != null) {
                afj.c(this.IxV, this.dEb, this.jiX, this.IxW);
            }
            AppMethodBeat.o(30003);
        }

        @Override // com.tencent.mm.plugin.wear.model.f.d
        public final String getName() {
            return "HttpMessageTask";
        }

        public final String toString() {
            AppMethodBeat.i(30004);
            String format = String.format("connectType=%d funId=%d sessionId=%d", Integer.valueOf(this.IxV), Integer.valueOf(this.jiX), Integer.valueOf(this.dEb));
            AppMethodBeat.o(30004);
            return format;
        }
    }
}
