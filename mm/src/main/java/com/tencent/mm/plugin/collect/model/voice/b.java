package com.tencent.mm.plugin.collect.model.voice;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.vfs.s;

public final class b {
    float Ne = 1.0f;
    @SuppressLint({"HandlerLeak"})
    MMHandler mHandler = new MMHandler("InnerSynthesizer") {
        /* class com.tencent.mm.plugin.collect.model.voice.b.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(63885);
            if (b.this.qxn != null) {
                switch (message.what) {
                    case 0:
                        b.this.qxn.o(0, message.getData().getByteArray("data"));
                        AppMethodBeat.o(63885);
                        return;
                    case -1:
                        b.this.qxn.o(-203, null);
                        break;
                }
            }
            AppMethodBeat.o(63885);
        }
    };
    private boolean mIsInit = false;
    String mText;
    float mVolume = 1.0f;
    c qxn;
    private a qxo = new a(this, (byte) 0);
    private Thread qxp = null;
    SynthesizerNative qxq = new SynthesizerNative();
    boolean qxr = false;
    int qxs = 256000;
    byte[] qxt = new byte[this.qxs];

    public b() {
        AppMethodBeat.i(63887);
        AppMethodBeat.o(63887);
    }

    public final int fE(String str, String str2) {
        AppMethodBeat.i(63888);
        if (this.mIsInit) {
            AppMethodBeat.o(63888);
            return 0;
        }
        String str3 = str + str2 + ".pos";
        Log.d("MicroMsg.OfflineVoice.InnerSynthesizer", "resFilePath:%s soFilePath:%s", str3, null);
        if (!s.YS(str3)) {
            Log.i("MicroMsg.OfflineVoice.InnerSynthesizer", "init failed:ErrorCode.TTS_RESOURCE_ERROR ");
            AppMethodBeat.o(63888);
            return -101;
        }
        com.tencent.mm.plugin.expansions.a.cMr();
        try {
            if (Util.isNullOrNil((String) null)) {
                com.tencent.mm.plugin.expansions.a.aoa("readMoney");
            } else if (!s.YS(null)) {
                Log.i("MicroMsg.OfflineVoice.InnerSynthesizer", "init failed: file not exist - ErrorCode.TTS_SO_ERROR ");
                AppMethodBeat.o(63888);
                return -103;
            } else {
                System.load(null);
            }
            try {
                Util.isNullOrNil(str2);
                int init = this.qxq.init(str3.getBytes());
                Log.i("MicroMsg.OfflineVoice.InnerSynthesizer", "init ret：%s", Integer.valueOf(init));
                if (init < 0) {
                    AppMethodBeat.o(63888);
                    return init;
                }
                this.mIsInit = true;
                AppMethodBeat.o(63888);
                return 0;
            } catch (Exception e2) {
                Log.i("MicroMsg.OfflineVoice.InnerSynthesizer", "init failed:ErrorCode.TTS_INIT_ERROR ");
                AppMethodBeat.o(63888);
                return -201;
            }
        } catch (Throwable th) {
            Log.i("MicroMsg.OfflineVoice.InnerSynthesizer", "init() Throwable:%s %s", th.getClass().getSimpleName(), th.getMessage());
            AppMethodBeat.o(63888);
            return -207;
        }
    }

    public final int start(String str) {
        AppMethodBeat.i(63889);
        if (!this.mIsInit) {
            Log.i("MicroMsg.OfflineVoice.InnerSynthesizer", "start failed:ErrorCode.TTS_START_ERROR ");
            AppMethodBeat.o(63889);
            return -202;
        } else if (this.qxp != null && this.qxp.isAlive()) {
            Log.i("MicroMsg.OfflineVoice.InnerSynthesizer", "start failed:ErrorCode.TTS_START_ERROR ");
            AppMethodBeat.o(63889);
            return -202;
        } else if (str == null || str.length() > 1024) {
            Log.i("MicroMsg.OfflineVoice.InnerSynthesizer", "start failed:TTS_TEXT_ERROR");
            AppMethodBeat.o(63889);
            return -102;
        } else {
            this.mText = str;
            this.qxr = false;
            this.qxp = new Thread(this.qxo);
            this.qxp.start();
            AppMethodBeat.o(63889);
            return 0;
        }
    }

    class a implements Runnable {
        private a() {
        }

        /* synthetic */ a(b bVar, byte b2) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(63886);
            try {
                b.this.mText = b.this.mText.replaceAll("[^0-9a-zA-Z一-龥.?!,;:。？！，、；：@%&/]+", "");
                Log.d("MicroMsg.OfflineVoice.InnerSynthesizer", "mText = %s  mVolume = %s mSpeed = %s", b.this.mText, Float.valueOf(b.this.mVolume), Float.valueOf(b.this.Ne));
                int readmoney = b.this.qxq.readmoney(b.this.mText.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET), b.this.qxt, b.this.qxs, b.this.mVolume, b.this.Ne);
                if (readmoney != -1) {
                    byte[] bArr = new byte[readmoney];
                    System.arraycopy(b.this.qxt, 0, bArr, 0, readmoney);
                    if (!b.this.qxr) {
                        Message obtainMessage = b.this.mHandler.obtainMessage(0);
                        Bundle bundle = new Bundle();
                        bundle.putByteArray("data", bArr);
                        obtainMessage.setData(bundle);
                        b.this.mHandler.sendMessage(obtainMessage);
                        Log.i("MicroMsg.OfflineVoice.InnerSynthesizer", "Synthesizer run success");
                    }
                    AppMethodBeat.o(63886);
                    return;
                }
                Log.i("MicroMsg.OfflineVoice.InnerSynthesizer", "Synthesizer run fail");
                b.this.mHandler.sendMessage(b.this.mHandler.obtainMessage(-1));
                AppMethodBeat.o(63886);
            } catch (Exception e2) {
                Log.i("MicroMsg.OfflineVoice.InnerSynthesizer", "SynthesizerRunnable Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
                b.this.mHandler.sendMessage(b.this.mHandler.obtainMessage(-1));
                AppMethodBeat.o(63886);
            }
        }
    }

    public final void destroy() {
        AppMethodBeat.i(63890);
        this.qxr = true;
        if (this.qxp != null) {
            try {
                this.qxp.join();
            } catch (InterruptedException e2) {
                Log.i("MicroMsg.OfflineVoice.InnerSynthesizer", "stop() Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
            }
        }
        try {
            this.qxq.release();
        } catch (Exception e3) {
            Log.i("MicroMsg.OfflineVoice.InnerSynthesizer", "destroy() Exception:%s %s", e3.getClass().getSimpleName(), e3.getMessage());
        }
        this.mIsInit = false;
        AppMethodBeat.o(63890);
    }
}
