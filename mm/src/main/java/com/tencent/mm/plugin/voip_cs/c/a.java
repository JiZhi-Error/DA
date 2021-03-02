package com.tencent.mm.plugin.voip_cs.c;

import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.wxmm.v2helper;

public final class a extends v2protocal {
    public byte[] HqD = new byte[2048];
    byte[] HqE = new byte[2048];
    public int field_voipcsChannelInfoLength = 0;
    int field_voipcsEngineInfoLength = 0;

    public a(MMHandler mMHandler) {
        super(mMHandler);
        AppMethodBeat.i(125338);
        AppMethodBeat.o(125338);
    }

    public final String fMo() {
        AppMethodBeat.i(125339);
        getVoipcsEngineInfo(this.HqE, this.HqE.length);
        Log.d("MicroMsg.CSV2protocal", "field_voipcsEngineInfoLength: %d", Integer.valueOf(this.field_voipcsEngineInfoLength));
        String str = this.ypO + "," + this.ypH + "," + this.Haw + "," + c.fMt().Hrk + "," + this.zNX + "," + this.HaL + fIO() + new String(this.HqE, 0, this.field_voipcsEngineInfoLength);
        e.Logi("MicroMsg.CSV2protocal", "voipreport:NewEngineString:".concat(String.valueOf(str)));
        AppMethodBeat.o(125339);
        return str;
    }

    public final int fMp() {
        boolean z;
        boolean z2;
        AppMethodBeat.i(125340);
        this.netType = e.getNetType(MMApplicationContext.getContext());
        this.Hau = this.netType;
        c.fMt().Hau = this.netType;
        if (this.netType == 5) {
            this.netType = 4;
        }
        boolean z3 = this.Hau >= 4 && (cpuFlag0 & 1024) != 0 && (cpuFlag0 & 255) >= 30;
        if (ae.gKt.gGc != 1 || ae.gKt.gFE.width < 480 || ae.gKt.gFE.height < 360 || ae.gKt.gFG.width < 480 || ae.gKt.gFG.height < 360) {
            z = false;
        } else {
            z = true;
        }
        if (ae.gKt.gGc == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if ((z3 || z) && !z2) {
            this.defaultWidth = 480;
            this.defaultHeight = v2helper.VOIP_ENC_HEIGHT_LV1;
            Hap = true;
            e.Logi("MicroMsg.CSV2protocal", "steve:Set Enable 480! " + this.defaultWidth + "x" + this.defaultHeight);
        }
        e.Logi("MicroMsg.CSV2protocal", "steve: Android CPUFlag:" + (cpuFlag0 & 255) + ", 480x360 Enc flags: bEnable480FromLocal:" + z3 + ", bEnable480FromSvr:" + z + ", bDisable480FromSvr:" + z2);
        this.HbF = new int[(this.defaultWidth * this.defaultHeight)];
        g.aAf();
        this.qDA = com.tencent.mm.kernel.a.getUin();
        int i2 = Build.VERSION.SDK_INT;
        int gLVersion = OpenGlRender.getGLVersion();
        Display defaultDisplay = ((WindowManager) MMApplicationContext.getContext().getSystemService("window")).getDefaultDisplay();
        int init = init(this.netType, 2, (this.defaultWidth << 16) | this.defaultHeight, (defaultDisplay.getWidth() << 16) | defaultDisplay.getHeight(), this.qDA, (gLVersion << 24) | (i2 << 16) | cpuFlag0, b.aKA() + "lib/", 8, 0, 0);
        e.Logd("MicroMsg.CSV2protocal", "protocalInitForCS protocal init ret :" + init + ",uin= " + this.qDA + ", groupRsCap = 0");
        this.iCs = true;
        if (init < 0) {
            reset();
        }
        AppMethodBeat.o(125340);
        return init;
    }
}
