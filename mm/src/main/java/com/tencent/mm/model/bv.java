package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import junit.framework.Assert;
import org.json.JSONObject;

public final class bv {
    public int cSx = -1;
    private String groupId = "";
    public String iAo = "";
    public String iAq = "";
    public String iFk = "";
    public String iFl = "";
    public String iFm = "";
    public long iFn = 0;
    public String iFo = "";
    public String iFp = "";
    public int iFq = 0;
    public int iFr = 0;
    public long iFs = 0;
    public String iFt = "";
    public String iFu = "";
    private boolean iFv = false;
    private int iFw = 0;
    private int iFx = 0;
    public String name = "";
    private int subType = 0;
    public long time = 0;
    public String title = "";
    public int type = 0;
    public String url = "";

    public bv() {
        AppMethodBeat.i(91028);
        AppMethodBeat.o(91028);
    }

    public final void convertFrom(Cursor cursor) {
        AppMethodBeat.i(91029);
        this.iFk = cursor.getString(0);
        this.time = cursor.getLong(1);
        this.type = cursor.getInt(2);
        this.name = cursor.getString(3);
        this.title = cursor.getString(4);
        this.url = cursor.getString(5);
        this.iFl = cursor.getString(6);
        this.iFm = cursor.getString(7);
        this.iFn = cursor.getLong(8);
        this.iFo = cursor.getString(9);
        this.iFp = cursor.getString(10);
        this.iFq = cursor.getInt(11);
        this.iAo = cursor.getString(12);
        this.iAq = cursor.getString(13);
        this.iFr = cursor.getInt(14);
        this.iFs = cursor.getLong(15);
        this.iFt = cursor.getString(16);
        this.iFu = cursor.getString(17);
        AppMethodBeat.o(91029);
    }

    public static String sd(int i2) {
        AppMethodBeat.i(91030);
        if (i2 == 20) {
            AppMethodBeat.o(91030);
            return "newsapp";
        } else if (i2 == 11) {
            AppMethodBeat.o(91030);
            return "blogapp";
        } else {
            Assert.assertTrue("INFO TYPE NEITHER NEWS NOR WEIBO", false);
            AppMethodBeat.o(91030);
            return null;
        }
    }

    public final String aVZ() {
        return this.iFk == null ? "" : this.iFk;
    }

    public final String getName() {
        return this.name == null ? "" : this.name;
    }

    public final String getTitle() {
        return this.title == null ? "" : this.title;
    }

    public final String getUrl() {
        return this.url == null ? "" : this.url;
    }

    public final String aWa() {
        return this.iFl == null ? "" : this.iFl;
    }

    public final String aWb() {
        return this.iFo == null ? "" : this.iFo;
    }

    public final String aWc() {
        return this.iFp == null ? "" : this.iFp;
    }

    public final String aWd() {
        AppMethodBeat.i(91031);
        if (this.iAo != null) {
            String[] split = this.iAo.split("\\|");
            if (split == null || split.length <= 0) {
                AppMethodBeat.o(91031);
                return "";
            }
            String str = split[0];
            AppMethodBeat.o(91031);
            return str;
        }
        AppMethodBeat.o(91031);
        return "";
    }

    public final String getDigest() {
        return this.iAq == null ? "" : this.iAq;
    }

    public final String aWe() {
        return this.iFu == null ? "" : this.iFu;
    }

    public final int aWf() {
        AppMethodBeat.i(91032);
        aWi();
        int i2 = this.subType;
        AppMethodBeat.o(91032);
        return i2;
    }

    public final int aWg() {
        AppMethodBeat.i(91033);
        aWi();
        int i2 = this.iFw;
        AppMethodBeat.o(91033);
        return i2;
    }

    public final String avy() {
        AppMethodBeat.i(91034);
        aWi();
        String str = this.groupId;
        AppMethodBeat.o(91034);
        return str;
    }

    public final int aWh() {
        AppMethodBeat.i(91035);
        aWi();
        int i2 = this.iFx;
        AppMethodBeat.o(91035);
        return i2;
    }

    private void aWi() {
        AppMethodBeat.i(91036);
        if (this.iFv || Util.isNullOrNil(this.iFu)) {
            AppMethodBeat.o(91036);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.iFu);
            this.iFw = jSONObject.optInt("videoLength", 0);
            int optInt = jSONObject.optInt("subType", 0);
            if (optInt == 1) {
                this.subType = optInt;
            } else {
                this.subType = 0;
            }
            this.groupId = jSONObject.optString("groupId", "");
            this.iFx = jSONObject.optInt("tweetType", 0);
        } catch (Exception e2) {
        }
        this.iFv = true;
        AppMethodBeat.o(91036);
    }
}
