package com.tencent.mm.audio.b;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class g {
    public static final String dAa = (com.tencent.mm.loader.j.b.aKJ() + "test.wav");
    public static final String dAb = (com.tencent.mm.loader.j.b.aKJ() + "test.pcm");

    static {
        AppMethodBeat.i(130009);
        AppMethodBeat.o(130009);
    }

    public static class a {
        public byte[] buf;
        public int dAc = 0;
        public boolean dAd = false;

        public a(byte[] bArr, int i2) {
            this.buf = bArr;
            this.dAc = i2;
            this.dAd = false;
        }

        public a(byte[] bArr, int i2, boolean z) {
            this.buf = bArr;
            this.dAc = i2;
            this.dAd = z;
        }
    }

    public static class b {
        private static boolean dAe = false;
        private static boolean dAf = false;

        static {
            AppMethodBeat.i(130007);
            init();
            AppMethodBeat.o(130007);
        }

        public static void init() {
            boolean z;
            AppMethodBeat.i(177008);
            com.tencent.mm.plugin.expt.b.b bVar = (com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class);
            if (bVar != null) {
                z = bVar.a(b.a.clicfg_load_silkso_ignore_cpu, 1) == 1;
            } else {
                z = true;
            }
            Log.i("MicroMsg.RecorderUtil", "load wechatvoicesilk, ignore cpu: %s", Boolean.valueOf(z));
            int aon = m.aon();
            Log.i("MicroMsg.RecorderUtil", "abi: %s, abi2: %s, cpuFlag: %d", Build.CPU_ABI, Build.CPU_ABI2, Integer.valueOf(aon));
            if (z) {
                try {
                    g.class.getClassLoader();
                    j.Ed("wechatvoicesilk");
                    dAe = true;
                    dAf = true;
                } catch (UnsatisfiedLinkError e2) {
                    Log.e("MicroMsg.RecorderUtil", "load library failed!");
                    dAe = false;
                    dAf = false;
                }
            } else if (!Util.isNullOrNil(Build.CPU_ABI) && !Build.CPU_ABI.contains("armeabi") && !Util.isNullOrNil(Build.CPU_ABI2) && !Build.CPU_ABI2.contains("armeabi")) {
                Log.i("MicroMsg.RecorderUtil", "don't contains armeabi");
                Log.e("voice SilkCodec", "load library failed! silk don't support armv5!!!!");
                dAe = false;
                dAf = false;
            } else if ((aon & 1024) != 0) {
                try {
                    g.class.getClassLoader();
                    j.Ed("wechatvoicesilk");
                    dAe = true;
                    dAf = true;
                } catch (UnsatisfiedLinkError e3) {
                    Log.e("MicroMsg.RecorderUtil", "load library failed!");
                    dAe = false;
                    dAf = false;
                }
            } else if ((aon & 512) != 0) {
                Log.e("voice SilkCodec", "load library failed! silk don't support armv6!!!!");
                dAe = false;
                dAf = false;
            } else {
                Log.e("voice SilkCodec", "load library failed! silk don't support armv5!!!!");
                dAe = false;
                dAf = false;
            }
            Log.i("MicroMsg.RecorderUtil", "finish load silk so, canUseSilkDecode: %b, canUseSilkEncode: %b", Boolean.valueOf(dAe), Boolean.valueOf(dAf));
            AppMethodBeat.o(177008);
        }

        public static boolean aao() {
            return dAe;
        }

        public static boolean aap() {
            return dAf;
        }
    }

    public static int B(String str, int i2) {
        AppMethodBeat.i(130008);
        try {
            i2 = Util.getInt(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getValue(str), i2);
        } catch (Exception e2) {
            Log.e("MicroMsg.RecorderUtil", "getIntValFromDynamicConfig parseInt failed, key: ".concat(String.valueOf(str)));
        } catch (Error e3) {
            Log.e("MicroMsg.RecorderUtil", "error on parseInt failed, key: ".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(130008);
        return i2;
    }
}
