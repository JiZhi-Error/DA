package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.protobuf.cj;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class c extends g {
    public int appType = 0;
    public String dDJ = "";
    public int dNv = 0;
    public int dYu = 0;
    public boolean jyX = false;
    public String kVZ = "";
    public long nJC = 0;
    public String name = "";
    public int position = 1;
    public int scene = 0;
    public int status = 0;
    public int type = 0;
    public int versionCode = 0;
    public String xDU = "";
    public String xDV = "";
    public String xDW = "#929292";
    public String xDX = "";
    public String xDY = "";
    public String xDZ = "";
    public String xEa = "";
    public String xEb = "";
    public LinkedList<String> xEc = new LinkedList<>();
    public String xEd = "";
    public LinkedList<String> xEe = new LinkedList<>();
    public boolean xEf = false;
    public boolean xEg = false;
    public String xEh = "";
    public String xEi = "#fca28a";
    public String xEj = "";
    public String xEk = "#222222";
    public String xEl = "";
    public boolean xEm = false;
    public String xEn = "";
    public cj xEo;

    public c() {
        AppMethodBeat.i(41356);
        AppMethodBeat.o(41356);
    }

    public final boolean dUP() {
        AppMethodBeat.i(41357);
        if ((this.appType == 1 || this.appType == 2) && this.xEo != null && !Util.isNullOrNil(this.xEo.xMp)) {
            AppMethodBeat.o(41357);
            return true;
        }
        AppMethodBeat.o(41357);
        return false;
    }
}
