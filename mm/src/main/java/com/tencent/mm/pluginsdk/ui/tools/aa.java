package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.f.b;
import com.tencent.mm.plugin.ball.f.d;
import com.tencent.mm.plugin.ball.service.FloatBallHelper;
import com.tencent.mm.plugin.ball.ui.FloatBallProxyUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.smtt.sdk.TbsConfig;
import org.json.JSONArray;
import org.json.JSONObject;

public final class aa extends FloatBallHelper {
    private static aa Vik = new aa();
    private String mFileName = "";
    private String mFilePath = "";
    private String nhr = "";
    public int qpr = 0;

    static {
        AppMethodBeat.i(109560);
        AppMethodBeat.o(109560);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final boolean aGg() {
        return false;
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final boolean aGh() {
        return true;
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final void y(boolean z, int i2) {
        AppMethodBeat.i(259605);
        if (z) {
            Log.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onMenuFloatBallSelected, enter float ball");
            jT(false);
            if (!cio()) {
                FloatBallProxyUI.a(MMApplicationContext.getContext(), 1, this.oWE, cij(), this.oWH);
                AppMethodBeat.o(259605);
                return;
            }
            cis();
            dhp();
            Context context = MMApplicationContext.getContext();
            Intent intent = new Intent("com.tencent.QQBrowser.action.sdk.document.receiver");
            intent.setPackage(TbsConfig.APP_QB);
            intent.putExtra("key_reader_sdk_window_close", true);
            try {
                context.sendBroadcast(intent);
                AppMethodBeat.o(259605);
            } catch (Exception e2) {
                Log.e("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "closeQb() Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
                AppMethodBeat.o(259605);
            }
        } else {
            Log.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onMenuFloatBallSelected, exit float ball");
            cir();
            AppMethodBeat.o(259605);
        }
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final void aGi() {
        AppMethodBeat.i(109549);
        Log.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, filePath:%s", this.mFilePath);
        super.aGi();
        AppMethodBeat.o(109549);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final void bCB() {
        AppMethodBeat.i(109550);
        Log.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onReceivedBallInfoRemovedEvent, filePath:%s", this.mFilePath);
        super.bCB();
        Context context = MMApplicationContext.getContext();
        Intent intent = new Intent("com.tencent.QQBrowser.action.sdk.document.receiver");
        intent.setPackage(TbsConfig.APP_QB);
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", 1);
            jSONObject.put("isShow", true);
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", 2);
            jSONObject2.put("isShow", false);
            jSONArray.put(jSONObject2);
            intent.putExtra("menuItems", jSONArray.toString());
            context.sendBroadcast(intent);
            AppMethodBeat.o(109550);
        } catch (Exception e2) {
            Log.e("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "updateQbFloatBallMenu() Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
            AppMethodBeat.o(109550);
        }
    }

    public final void I(String str, String str2, int i2) {
        AppMethodBeat.i(109551);
        Log.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "onCreate, filePath:%s fileExt:%s fileName:%s sence:%s", str, str2, "", Integer.valueOf(i2));
        super.G(4, b.agW(str));
        this.mFilePath = str;
        this.nhr = str2;
        this.mFileName = "";
        this.qpr = i2;
        ciw().hDa = 4;
        ciw().oWx = this.qpr;
        cit();
        if (this.oWE.jkf != null) {
            this.oWE.jkf.putBoolean("ifAppAttachDownloadUI", false);
            this.oWE.jkf.putString("filePath", str);
            this.oWE.jkf.putString("fileExt", str2);
            this.oWE.jkf.putInt("sence", i2);
            cit();
        }
        Integer agX = d.agX(this.nhr);
        if (agX == null) {
            agX = d.agX("unknown");
        }
        this.oWE.noe = agX.intValue();
        if (Util.isNullOrNil(this.oWE.name)) {
            if (Util.isNullOrNil(this.mFileName)) {
                this.mFileName = aYk(this.mFilePath);
            }
            this.oWE.name = this.mFileName;
        }
        cit();
        AppMethodBeat.o(109551);
    }

    public final void Dw(boolean z) {
        AppMethodBeat.i(109553);
        if (this.oWG != null) {
            this.oWG.Dw(z);
        }
        AppMethodBeat.o(109553);
    }

    public static aa hYc() {
        return Vik;
    }

    private static String aYk(String str) {
        String str2;
        AppMethodBeat.i(109557);
        try {
            int lastIndexOf = str.lastIndexOf(47) + 1;
            if (lastIndexOf < 0 || lastIndexOf == str.length()) {
                lastIndexOf = 0;
            }
            str2 = str.substring(lastIndexOf, str.length());
        } catch (Exception e2) {
            Log.e("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "get file name error " + e2.getMessage());
            str2 = " ";
        }
        AppMethodBeat.o(109557);
        return str2;
    }

    public final void hYd() {
        AppMethodBeat.i(259606);
        if (!(this.oWG == null || this.oWE == null || this.oWE.beK != 4)) {
            Log.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "alvinluo checkAndAddMessageBall qbFileViewPage: %b, contentType: %d", Boolean.valueOf(this.oWG.chO()), Integer.valueOf(this.oWE.beK));
            long dgY = this.oWG.dgY();
            long currentTimeMillis = System.currentTimeMillis();
            this.oWG.By(0);
            Log.i("MicroMsg.FilesFloatBall.FilesFloatBallHelper", "alvinluo checkAndAddMessageBall enterChatting: %d, now: %d, canAddMessageBall: %b", Long.valueOf(dgY), Long.valueOf(currentTimeMillis), Boolean.valueOf(cij()));
            if (d.aG(dgY, currentTimeMillis) && cij()) {
                dhA();
            }
        }
        AppMethodBeat.o(259606);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final boolean bCG() {
        return true;
    }
}
