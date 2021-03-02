package com.tencent.mm.modelvoiceaddr.a;

import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.c.d;
import com.tencent.mm.plugin.appbrand.jsapi.contact.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Locale;

public class c {
    private static final String TAG = c.class.getSimpleName();
    public static SharedPreferences sp = MMApplicationContext.getDefaultPreference();
    private MMHandler handler;
    private boolean isReleased;
    private boolean jxb;
    private int jxc;
    private boolean jxd;
    private boolean jxe;
    private long jxf;
    private int jxg;
    private a jxh;
    private com.qq.wx.voice.vad.a jxi;
    public a jxj;
    private short[] jxk;

    public interface a {
        void Yh();

        void b(short[] sArr, int i2);

        void bix();

        void biy();
    }

    static {
        AppMethodBeat.i(148609);
        AppMethodBeat.o(148609);
    }

    public static String biD() {
        AppMethodBeat.i(148604);
        String format = String.format(Locale.CHINA, "%s: %s\n%s: %s\n%s: %s\n%s: %s\n%s: %s", "sil_time", Integer.valueOf(sp.getInt("sil_time", 500)), "s_n_ration", Float.valueOf(sp.getFloat("s_n_ration", 2.5f)), "s_window", Integer.valueOf(sp.getInt("s_window", 500)), "s_length", Integer.valueOf(sp.getInt("s_length", 350)), "s_delay_time", Integer.valueOf(sp.getInt("s_delay_time", f.CTRL_INDEX)));
        AppMethodBeat.o(148604);
        return format;
    }

    public c(boolean z, boolean z2) {
        this(3500, sp.getInt("sil_time", 1000), sp.getFloat("s_n_ration", 2.5f), sp.getInt("s_window", 500), sp.getInt("s_length", 350), sp.getInt("s_delay_time", f.CTRL_INDEX), z, z2);
        AppMethodBeat.i(148605);
        AppMethodBeat.o(148605);
    }

    public c(int i2, int i3, float f2, int i4, int i5, int i6, boolean z, boolean z2) {
        boolean z3;
        int Reset;
        AppMethodBeat.i(148606);
        this.jxb = true;
        this.jxc = 3;
        this.jxd = false;
        this.jxe = false;
        this.jxf = 0;
        this.jxg = 3500;
        this.isReleased = false;
        this.handler = new MMHandler(Looper.getMainLooper()) {
            /* class com.tencent.mm.modelvoiceaddr.a.c.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                AppMethodBeat.i(148603);
                if (message.what != 0) {
                    AppMethodBeat.o(148603);
                    return;
                }
                if (c.this.jxj != null) {
                    c.this.jxj.Yh();
                }
                AppMethodBeat.o(148603);
            }
        };
        this.jxh = null;
        this.jxi = null;
        this.jxg = i2;
        this.jxi = new com.qq.wx.voice.vad.a();
        int i7 = 0;
        if (MMApplicationContext.isMMProcess()) {
            com.tencent.mm.storage.c Fu = d.aXu().Fu("100235");
            if (Fu.isValid()) {
                i7 = Util.getInt(Fu.gzz().get("MMVoipVadOn"), 0);
            }
        }
        Log.i(TAG, "VoiceSilentDetectAPI: abTestFlag = [%s]", Integer.valueOf(i7));
        if (i7 == 0) {
            com.qq.wx.voice.vad.a.bI(false);
        } else {
            com.qq.wx.voice.vad.a.bI(true);
        }
        com.qq.wx.voice.vad.a aVar = this.jxi;
        if (com.qq.wx.voice.vad.a.cgx) {
            aVar.handle = aVar.cgw.Init(16000, i3, f2, i4, i5);
        } else {
            aVar.handle = aVar.cgv.Init(16000, i3, f2, i4, i5);
        }
        if (com.qq.wx.voice.vad.a.DEBUG) {
            System.out.println("EVad Init handle = " + aVar.handle);
        }
        if (aVar.handle == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            com.qq.wx.voice.vad.a aVar2 = this.jxi;
            if (aVar2.handle == 0) {
                Reset = 1;
            } else {
                if (com.qq.wx.voice.vad.a.DEBUG) {
                    System.out.println("EVad Reset handle = " + aVar2.handle);
                }
                if (com.qq.wx.voice.vad.a.cgx) {
                    Reset = aVar2.cgw.Reset(aVar2.handle);
                } else {
                    Reset = aVar2.cgv.Reset(aVar2.handle);
                }
            }
            if (Reset != 1) {
                this.jxh = new a(i6 * 16);
                this.jxk = new short[4000];
                this.handler.removeMessages(0);
                this.handler.sendEmptyMessageDelayed(0, (long) i2);
                this.jxd = z;
                this.jxe = z2;
                AppMethodBeat.o(148606);
                return;
            }
        }
        b bVar = new b("Init ERROR");
        AppMethodBeat.o(148606);
        throw bVar;
    }

    public final void e(short[] sArr, int i2) {
        int i3;
        int i4;
        AppMethodBeat.i(148607);
        Log.d(TAG, "input() called with: voice = [%s], length = [%s]", sArr, Integer.valueOf(i2));
        if (sArr == null || sArr.length == 0 || i2 <= 0 || i2 > sArr.length) {
            AppMethodBeat.o(148607);
        } else if (this.isReleased) {
            Log.i(TAG, "VoiceSilentDetectAPI is released.");
            AppMethodBeat.o(148607);
        } else if (this.jxh == null) {
            Log.i(TAG, "input, circleBuffer is null.");
            AppMethodBeat.o(148607);
        } else {
            int a2 = this.jxi.a(sArr, i2);
            Log.d(TAG, "currState = %s,prevState = %s,directFirstStart = %s,directTempState = %s", Integer.valueOf(a2), Integer.valueOf(this.jxc), Boolean.valueOf(this.jxd), Boolean.valueOf(this.jxe));
            if (this.jxd) {
                if (this.jxe) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (this.jxj != null) {
                        this.jxj.biy();
                    }
                    this.jxf = currentTimeMillis;
                    if (this.isReleased) {
                        AppMethodBeat.o(148607);
                        return;
                    }
                    int i5 = this.jxh.jwZ;
                    int length = this.jxk.length;
                    while (i5 > 0) {
                        if (length > i5) {
                            i4 = i5;
                        } else {
                            i4 = length;
                        }
                        this.jxh.c(this.jxk, i4);
                        i5 -= i4;
                        if (this.jxj != null) {
                            this.jxj.b(this.jxk, i4);
                        }
                    }
                    this.jxe = false;
                    this.handler.removeMessages(0);
                    this.handler.sendEmptyMessageDelayed(0, (long) this.jxg);
                } else {
                    if (this.jxc == 3 && a2 == 2) {
                        this.jxd = false;
                    }
                    if (!(this.jxc == 3 && a2 == 3)) {
                        this.handler.removeMessages(0);
                        this.handler.sendEmptyMessageDelayed(0, (long) this.jxg);
                    }
                }
                this.jxb = false;
                this.jxc = a2;
            } else if (this.jxc == 3 && a2 == 2) {
                this.jxc = a2;
                this.handler.removeMessages(0);
                this.handler.sendEmptyMessageDelayed(0, (long) this.jxg);
                long currentTimeMillis2 = System.currentTimeMillis();
                if (this.jxj != null) {
                    this.jxj.biy();
                }
                this.jxf = currentTimeMillis2;
                if (this.isReleased) {
                    AppMethodBeat.o(148607);
                    return;
                }
                int i6 = this.jxh.jwZ;
                int length2 = this.jxk.length;
                while (i6 > 0) {
                    if (length2 > i6) {
                        i3 = i6;
                    } else {
                        i3 = length2;
                    }
                    this.jxh.c(this.jxk, i3);
                    i6 -= i3;
                    if (this.jxj != null) {
                        this.jxj.b(this.jxk, i3);
                    }
                }
                this.jxb = false;
            } else if (this.jxc == 2 && a2 == 3) {
                this.jxc = a2;
                this.jxb = true;
                this.handler.removeMessages(0);
                this.handler.sendEmptyMessageDelayed(0, (long) this.jxg);
                long currentTimeMillis3 = System.currentTimeMillis();
                if (this.jxj != null) {
                    this.jxj.bix();
                }
                this.jxf = currentTimeMillis3;
                if (this.isReleased) {
                    AppMethodBeat.o(148607);
                    return;
                }
            } else if (this.jxc == 3 && a2 == 3) {
                this.jxb = true;
            } else if (this.jxc == 2 && a2 == 2) {
                this.jxb = false;
                this.handler.removeMessages(0);
                this.handler.sendEmptyMessageDelayed(0, (long) this.jxg);
            }
            if (this.isReleased) {
                AppMethodBeat.o(148607);
                return;
            }
            this.jxh.d(sArr, i2);
            Log.d(TAG, "isSilent %s", Boolean.valueOf(this.jxb));
            if (this.jxb) {
                AppMethodBeat.o(148607);
                return;
            }
            if (this.jxj != null) {
                this.jxj.b(sArr, i2);
            }
            AppMethodBeat.o(148607);
        }
    }

    public final void release() {
        AppMethodBeat.i(148608);
        Log.d(TAG, "released");
        this.isReleased = true;
        this.jxd = false;
        this.jxe = false;
        if (this.jxi != null) {
            if (this.jxi.IL() == 1) {
                b bVar = new b();
                AppMethodBeat.o(148608);
                throw bVar;
            }
            this.jxi = null;
        }
        this.jxh = null;
        this.jxk = null;
        if (this.handler != null) {
            this.handler.removeMessages(0);
            this.handler = null;
        }
        this.jxj = null;
        AppMethodBeat.o(148608);
    }
}
