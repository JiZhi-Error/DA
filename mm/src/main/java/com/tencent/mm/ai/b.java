package com.tencent.mm.ai;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public final class b {
    public String appId = "";
    public int dCS = 0;
    public boolean dtU = true;
    public String dtX = "";
    public String dvn = "";
    public int dvv = 0;
    public String filePath = "";
    public long fileSize = 0;
    public int fromScene = 0;
    public int iJD = 0;
    public boolean iJE = false;
    public long iJF = 0;
    public double iJG = 1.0d;
    public double iJH = 1.0d;
    public long iJI = 0;
    public long iJJ = 0;
    public long iJK = 0;
    public long iJL = 0;
    public long iJM = 0;
    public long iJN = 0;
    public long iJO = 0;
    public String iJP = null;
    public String iJQ = null;
    public e iJR;
    public boolean iJS = false;
    public boolean iJT = false;
    public ByteBuffer iJU;
    public boolean loop = false;
    public String processName = "";

    public final boolean j(b bVar) {
        AppMethodBeat.i(136977);
        if (bVar == null) {
            AppMethodBeat.o(136977);
            return false;
        } else if (this.dtX == null || !this.dtX.equalsIgnoreCase(bVar.dtX) || this.dvn == null || !this.dvn.equalsIgnoreCase(bVar.dvn)) {
            AppMethodBeat.o(136977);
            return false;
        } else {
            AppMethodBeat.o(136977);
            return true;
        }
    }

    public final void k(b bVar) {
        AppMethodBeat.i(136978);
        this.dtX = bVar.dtX;
        this.dvn = bVar.dvn;
        if (!TextUtils.isEmpty(bVar.filePath)) {
            this.filePath = bVar.filePath;
        }
        this.dvv = bVar.dvv;
        this.iJD = bVar.iJD;
        this.iJE = bVar.iJE;
        this.loop = bVar.loop;
        this.fromScene = bVar.fromScene;
        this.processName = bVar.processName;
        this.iJG = bVar.iJG;
        this.appId = bVar.appId;
        if (bVar.iJR != null) {
            this.iJR = bVar.iJR;
        }
        this.fileSize = bVar.fileSize;
        this.iJH = bVar.iJH;
        AppMethodBeat.o(136978);
    }
}
