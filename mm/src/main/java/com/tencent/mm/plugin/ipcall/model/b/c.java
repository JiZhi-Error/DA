package com.tencent.mm.plugin.ipcall.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.protocal.protobuf.dfe;
import java.util.Iterator;
import java.util.LinkedList;

public final class c {
    public String dkV;
    public String edf;
    public int lPy;
    public String nickname;
    public LinkedList<dfe> oMr = new LinkedList<>();
    public int phoneType;
    public int rBL;
    public String rBM;
    public int roomId;
    public long ypH;
    public long ypI;
    public int ypJ;
    public int ypK;
    public int ypL;
    public int ypM;
    public String ypN;
    public int ypO;
    public int ypP;
    public int ypQ;
    public int ypR;
    public boolean ypS = false;
    public boolean ypT = false;
    public boolean ypU = false;
    public boolean ypV = true;
    public int ypW = 0;
    public int ypX;
    public int ypY;
    public int ypZ;
    public b yqa;
    public int yqb;
    public int yqc;
    public b yqd;
    public LinkedList<dfe> yqe = new LinkedList<>();
    public int yqf = 999;
    public LinkedList<d> yqg = new LinkedList<>();
    public String yqh;
    public String yqi;
    public String yqj;
    public boolean yqk = false;

    public c() {
        AppMethodBeat.i(25408);
        AppMethodBeat.o(25408);
    }

    public final int eaI() {
        AppMethodBeat.i(25409);
        if (this.yqg == null || this.yqg.size() <= 0) {
            int i2 = this.ypP;
            AppMethodBeat.o(25409);
            return i2;
        }
        int i3 = this.yqg.get(0).ypP;
        AppMethodBeat.o(25409);
        return i3;
    }

    public final int eaJ() {
        AppMethodBeat.i(25410);
        if (this.yqg == null || this.yqg.size() <= 0) {
            int i2 = this.lPy;
            AppMethodBeat.o(25410);
            return i2;
        }
        int i3 = this.yqg.get(0).hpS;
        AppMethodBeat.o(25410);
        return i3;
    }

    public final String toString() {
        AppMethodBeat.i(25411);
        StringBuilder sb = new StringBuilder("");
        sb.append("IPCallInfo: ");
        sb.append(String.format("[roomId: %d, roomKey: %d, callSeq: %d, inviteId: %d, roomMemberId: %d, syncKey: %d, syncInterval: %d, currentStatus: %d, ErrMsg: %s, ErrCode：%d, ErrLevel：%d]\n", Integer.valueOf(this.roomId), Long.valueOf(this.ypH), Long.valueOf(this.ypI), Integer.valueOf(this.ypJ), Integer.valueOf(this.ypO), Integer.valueOf(this.ypP), Integer.valueOf(this.ypQ), Integer.valueOf(this.lPy), this.rBM, Integer.valueOf(this.rBL), Integer.valueOf(this.ypM)));
        sb.append(String.format("[toUsername: %s, toPhoneNumber: %s]\n", this.dkV, this.yqi));
        sb.append("[addrList: ");
        Iterator<dfe> it = this.oMr.iterator();
        while (it.hasNext()) {
            dfe next = it.next();
            sb.append(String.format("{IP: %s, port: %d}", next.MpA, Integer.valueOf(next.MKe)));
        }
        sb.append("]");
        sb.append("\n");
        if (this.yqg == null || this.yqg.size() <= 0) {
            sb.append("userInfoList is empty");
        } else {
            sb.append("[userInfoList: ");
            Iterator<d> it2 = this.yqg.iterator();
            while (it2.hasNext()) {
                sb.append("{");
                sb.append(it2.next().toString());
                sb.append("}");
            }
            sb.append("]");
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(25411);
        return sb2;
    }
}
