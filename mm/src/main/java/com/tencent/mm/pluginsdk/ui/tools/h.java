package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.multitask.b.c;
import com.tencent.mm.plugin.multitask.g;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.sdk.TbsConfig;

public final class h extends c {
    private static h Kvk = new h();
    public boolean CB = false;
    String mFileName = "";
    public String mFilePath = "";
    String nhr = "";
    public int qpr = 0;

    static {
        AppMethodBeat.i(204781);
        AppMethodBeat.o(204781);
    }

    public h() {
        super((byte) 0);
    }

    @Override // com.tencent.mm.plugin.multitask.b.a
    public final boolean bPp() {
        return false;
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.b
    public final boolean bPq() {
        return false;
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.c
    public final void ib(boolean z) {
        AppMethodBeat.i(204774);
        if (z) {
            Log.i("MicroMsg.FilesFloatBall.FilesMultiTaskHelper", "onMenuFloatBallSelected, enter float ball");
            b(null, true);
            PlaySound.play(MMApplicationContext.getContext(), R.string.j06);
            Context context = MMApplicationContext.getContext();
            Intent intent = new Intent("com.tencent.QQBrowser.action.sdk.document.receiver");
            intent.setPackage(TbsConfig.APP_QB);
            intent.putExtra("key_reader_sdk_window_close", true);
            try {
                context.sendBroadcast(intent);
                AppMethodBeat.o(204774);
                return;
            } catch (Exception e2) {
                Log.e("MicroMsg.FilesFloatBall.FilesMultiTaskHelper", "closeQb() Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
            }
        }
        AppMethodBeat.o(204774);
    }

    public final void I(String str, String str2, int i2) {
        AppMethodBeat.i(204775);
        b(str, str2, "", i2, this.Abq);
        AppMethodBeat.o(204775);
    }

    public final void b(String str, String str2, String str3, int i2, ach ach) {
        AppMethodBeat.i(204776);
        Log.i("MicroMsg.FilesFloatBall.FilesMultiTaskHelper", "onCreate, filePath:%s fileExt:%s fileName:%s sence:%s", str, str2, str3, Integer.valueOf(i2));
        super.G(4, g.aGI(str));
        this.mFilePath = str;
        this.nhr = str2;
        this.mFileName = str3;
        if (TextUtils.isEmpty(this.mFileName)) {
            this.mFileName = aYk(str);
        }
        this.CB = false;
        this.qpr = i2;
        a(ach);
        aoe aoe = new aoe();
        aoe.LzL = false;
        aoe.filePath = str;
        aoe.gCr = str2;
        aoe.LzM = s.boW(str);
        aoe.qoX = i2;
        try {
            this.Abp.field_data = aoe.toByteArray();
            eqX();
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.FilesFloatBall.FilesMultiTaskHelper", e2, "", new Object[0]);
        }
        gsu();
        AppMethodBeat.o(204776);
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.c
    public final boolean O(int i2, boolean z) {
        AppMethodBeat.i(204778);
        boolean O = super.O(i2, this.CB);
        AppMethodBeat.o(204778);
        return O;
    }

    public static h gsv() {
        return Kvk;
    }

    public static String akC(String str) {
        AppMethodBeat.i(204779);
        String akC = s.akC(aYk(str));
        AppMethodBeat.o(204779);
        return akC;
    }

    private static String aYk(String str) {
        String str2;
        AppMethodBeat.i(204780);
        try {
            int lastIndexOf = str.lastIndexOf(47) + 1;
            if (lastIndexOf < 0 || lastIndexOf == str.length()) {
                lastIndexOf = 0;
            }
            str2 = str.substring(lastIndexOf, str.length());
        } catch (Exception e2) {
            Log.e("MicroMsg.FilesFloatBall.FilesMultiTaskHelper", "get file name error " + e2.getMessage());
            str2 = " ";
        }
        AppMethodBeat.o(204780);
        return str2;
    }

    @Override // com.tencent.mm.plugin.multitask.b.a
    public final long eqU() {
        return 1500;
    }

    private void gsu() {
        AppMethodBeat.i(204777);
        this.Abp.erh().gCr = this.nhr;
        this.Abp.erh().title = this.mFileName;
        eqX();
        AppMethodBeat.o(204777);
    }
}
