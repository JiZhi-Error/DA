package com.tencent.mm.plugin.voip.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public final class g {
    public int GTT = 0;

    public final byte[] cf(byte[] bArr) {
        AppMethodBeat.i(235484);
        byte[] L = L(new ByteArrayInputStream(bArr));
        AppMethodBeat.o(235484);
        return L;
    }

    private static byte[] L(InputStream inputStream) {
        AppMethodBeat.i(114847);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        j jVar = new j(inputStream, byteArrayOutputStream);
        jVar.acV(8);
        jVar.acV(8);
        jVar.acV(8);
        jVar.acV(8);
        jVar.acV(8);
        int fGg = (int) jVar.fGg();
        jVar.acV(8);
        jVar.fGg();
        jVar.fGk();
        if (fGg == 100 || fGg == 110 || fGg == 122 || fGg == 144) {
            if (jVar.fGj() == 3) {
                jVar.acV(1);
            }
            jVar.fGk();
            jVar.fGk();
            jVar.acV(1);
            if (jVar.wY(true)) {
                for (int i2 = 0; i2 < 8; i2++) {
                    if (jVar.wY(true)) {
                        if (i2 < 6) {
                            jVar.acW(16);
                        } else {
                            jVar.acW(64);
                        }
                    }
                }
            }
        }
        jVar.fGk();
        int fGj = jVar.fGj();
        if (fGj == 0) {
            jVar.fGk();
        } else if (fGj == 1) {
            jVar.acV(1);
            jVar.fGk();
            jVar.fGk();
            int fGj2 = jVar.fGj();
            for (int i3 = 0; i3 < fGj2; i3++) {
                new StringBuilder("SPS: offsetForRefFrame [").append(i3).append("]");
                jVar.fGk();
            }
        }
        jVar.fGk();
        jVar.acV(1);
        jVar.fGk();
        jVar.fGk();
        if (!jVar.wY(true)) {
            jVar.acV(1);
        }
        jVar.acV(1);
        if (jVar.wY(true)) {
            jVar.fGk();
            jVar.fGk();
            jVar.fGk();
            jVar.fGk();
        }
        if (jVar.wY(false)) {
            Log.d("[H264SPSModifier]", "vui_parameters_present_flag exist!! modify max_dec_frame_buffering");
            jVar.xa(true);
            if (jVar.wY(true) && ((int) jVar.fGg()) == 255) {
                jVar.acV(16);
                jVar.acV(16);
            }
            if (jVar.wY(true)) {
                jVar.acV(1);
            }
            if (jVar.wY(true)) {
                jVar.acV(3);
                jVar.acV(1);
                if (jVar.wY(true)) {
                    jVar.acV(8);
                    jVar.acV(8);
                    jVar.acV(8);
                }
            }
            if (jVar.wY(true)) {
                jVar.fGk();
                jVar.fGk();
            }
            if (jVar.wY(true)) {
                jVar.acV(32);
                jVar.acV(32);
                jVar.acV(1);
            }
            boolean wY = jVar.wY(true);
            if (wY) {
                a(jVar);
            }
            boolean wY2 = jVar.wY(true);
            if (wY2) {
                a(jVar);
            }
            if (wY || wY2) {
                jVar.acV(1);
            }
            jVar.acV(1);
            if (jVar.wY(false)) {
                Log.d("TAG", "steve:VUI has bs restriction!!");
                jVar.xa(true);
                jVar.wY(true);
                jVar.fGk();
                jVar.fGk();
                jVar.fGk();
                jVar.fGk();
                jVar.fGk();
                jVar.acZ(1);
            } else {
                Log.d("TAG", "steve:VUI has NO bs restriction!!");
                jVar.xa(true);
                jVar.xa(true);
                jVar.acZ(0);
                jVar.acZ(0);
                jVar.acZ(10);
                jVar.acZ(10);
                jVar.acZ(0);
                jVar.acZ(1);
            }
        } else {
            Log.d("[H264SPSModifier]", "vui_parameters_present_flag NOT exist!! add max_dec_frame_buffering");
            jVar.xa(true);
            jVar.xa(false);
            jVar.xa(false);
            jVar.xa(false);
            jVar.xa(false);
            jVar.xa(false);
            jVar.xa(false);
            jVar.xa(false);
            jVar.xa(false);
            jVar.xa(true);
            jVar.xa(true);
            jVar.acZ(0);
            jVar.acZ(0);
            jVar.acZ(10);
            jVar.acZ(10);
            jVar.acZ(0);
            jVar.acZ(1);
        }
        jVar.acX(1);
        jVar.ai(0, 8 - jVar.GVp);
        jVar.flush();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        String str = "";
        for (byte b2 : byteArray) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() == 1) {
                hexString = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(hexString));
            }
            str = str + " " + hexString;
        }
        Log.d("TAG", "new SPS:".concat(String.valueOf(str)));
        AppMethodBeat.o(114847);
        return byteArray;
    }

    public final boolean cg(byte[] bArr) {
        AppMethodBeat.i(114848);
        boolean M = M(new ByteArrayInputStream(bArr));
        AppMethodBeat.o(114848);
        return M;
    }

    private boolean M(InputStream inputStream) {
        AppMethodBeat.i(114849);
        j jVar = new j(inputStream);
        jVar.acU(8);
        jVar.acU(8);
        jVar.acU(8);
        jVar.acU(8);
        jVar.acU(8);
        int fGg = (int) jVar.fGg();
        if (fGg == 66) {
            this.GTT |= 1;
            AppMethodBeat.o(114849);
            return false;
        }
        jVar.acU(8);
        jVar.fGg();
        jVar.fGi();
        if (fGg == 100 || fGg == 110 || fGg == 122 || fGg == 144) {
            if (jVar.fGj() == 3) {
                jVar.acU(1);
            }
            jVar.fGi();
            jVar.fGi();
            jVar.acU(1);
            if (jVar.wY(true)) {
                for (int i2 = 0; i2 < 8; i2++) {
                    if (jVar.wY(true)) {
                        if (i2 < 6) {
                            jVar.acW(16);
                        } else {
                            jVar.acW(64);
                        }
                    }
                }
            }
        }
        jVar.fGi();
        int fGj = jVar.fGj();
        if (fGj == 0) {
            jVar.fGi();
        } else if (fGj == 1) {
            jVar.acU(1);
            jVar.fGi();
            jVar.fGi();
            int fGj2 = jVar.fGj();
            for (int i3 = 0; i3 < fGj2; i3++) {
                new StringBuilder("SPS: offsetForRefFrame [").append(i3).append("]");
                jVar.fGk();
            }
        }
        if (jVar.fGj() >= 2) {
            this.GTT |= 2;
        }
        jVar.acV(1);
        jVar.fGk();
        jVar.fGk();
        if (!jVar.wY(true)) {
            jVar.acV(1);
        }
        jVar.acV(1);
        if (jVar.wY(true)) {
            jVar.fGk();
            jVar.fGk();
            jVar.fGk();
            jVar.fGk();
        }
        if (jVar.wY(true)) {
            Log.d("[H264SPSModifier]", "vui_parameters_present_flag exist!! read num_reorder_frames");
            if (jVar.wY(true) && ((int) jVar.fGg()) == 255) {
                jVar.acV(16);
                jVar.acV(16);
            }
            if (jVar.wY(true)) {
                jVar.acV(1);
            }
            if (jVar.wY(true)) {
                jVar.acV(3);
                jVar.acV(1);
                if (jVar.wY(true)) {
                    jVar.acV(8);
                    jVar.acV(8);
                    jVar.acV(8);
                }
            }
            if (jVar.wY(true)) {
                jVar.fGk();
                jVar.fGk();
            }
            if (jVar.wY(true)) {
                jVar.acV(32);
                jVar.acV(32);
                jVar.acV(1);
            }
            boolean wY = jVar.wY(true);
            if (wY) {
                a(jVar);
            }
            boolean wY2 = jVar.wY(true);
            if (wY2) {
                a(jVar);
            }
            if (wY || wY2) {
                jVar.acV(1);
            }
            jVar.acV(1);
            if (jVar.wY(true)) {
                jVar.wY(true);
                jVar.fGk();
                jVar.fGk();
                jVar.fGk();
                jVar.fGk();
                int fGj3 = jVar.fGj();
                int fGj4 = jVar.fGj();
                if (fGj3 != 0) {
                    Log.d("[H264SPSModifier]", "steve: reorder_frame =" + fGj3 + ", mac_dec_buffering=" + fGj4);
                    this.GTT |= 4;
                    AppMethodBeat.o(114849);
                    return true;
                }
            }
        }
        AppMethodBeat.o(114849);
        return false;
    }

    public final boolean ch(byte[] bArr) {
        AppMethodBeat.i(114850);
        boolean N = N(new ByteArrayInputStream(bArr));
        AppMethodBeat.o(114850);
        return N;
    }

    private boolean N(InputStream inputStream) {
        AppMethodBeat.i(114851);
        j jVar = new j(inputStream);
        jVar.acU(8);
        jVar.acU(8);
        jVar.acU(8);
        jVar.acU(8);
        jVar.acU(8);
        jVar.fGi();
        int fGj = jVar.fGj();
        Log.d("TAG", "steve:slice_type:".concat(String.valueOf(fGj)));
        if (fGj == 1 || fGj == 6) {
            this.GTT |= 8;
            AppMethodBeat.o(114851);
            return true;
        }
        AppMethodBeat.o(114851);
        return false;
    }

    private static void a(j jVar) {
        AppMethodBeat.i(114852);
        int fGj = jVar.fGj();
        jVar.acU(4);
        jVar.acU(4);
        for (int i2 = 0; i2 <= fGj; i2++) {
            jVar.fGi();
            jVar.fGi();
            jVar.acU(1);
        }
        jVar.acU(5);
        jVar.acU(5);
        jVar.acU(5);
        jVar.acU(5);
        AppMethodBeat.o(114852);
    }
}
