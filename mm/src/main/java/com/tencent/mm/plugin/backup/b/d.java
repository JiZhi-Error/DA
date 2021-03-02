package com.tencent.mm.plugin.backup.b;

import android.content.SharedPreferences;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public abstract class d extends a {
    private static String TAG = "MicroMsg.BackupModel";
    private static boolean hpG = false;
    private static int oIY = 0;
    private static byte[] oIZ = "key".getBytes();
    private static SharedPreferences oJb;
    public String oIU = "id";
    public String oIV = "hello";
    public String oIW = "ok";
    public e oIX;
    public byte[] oJa;

    public abstract void ceN();

    public abstract void ceO();

    public abstract void o(Object... objArr);

    public final e ceM() {
        if (this.oIX == null) {
            this.oIX = new e();
        }
        return this.oIX;
    }

    public static int ceP() {
        return oIY;
    }

    public static void Bb(int i2) {
        oIY = i2;
    }

    public static byte[] ceQ() {
        return oIZ;
    }

    public static void aS(byte[] bArr) {
        oIZ = bArr;
    }

    public static SharedPreferences ceR() {
        if (oJb == null) {
            oJb = MMApplicationContext.getContext().getSharedPreferences("BACKUP_CONFIG", g.aps());
        }
        return oJb;
    }

    public static void ceS() {
        Log.i(TAG, "holdReset");
        hpG = true;
    }

    public static boolean ceT() {
        return hpG;
    }

    public static void ceU() {
        oIZ = "key".getBytes();
        oIY = 0;
        oJb = null;
        hpG = false;
    }
}
