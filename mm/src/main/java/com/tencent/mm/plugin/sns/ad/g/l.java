package com.tencent.mm.plugin.sns.ad.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ad.g.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class l {
    public int DvO = 0;
    public int DvP = 0;
    public long DvQ = 0;
    public int DvR = 0;
    public int DvS = 0;
    public int DvT = 0;
    public int DvU = 0;
    public boolean DvV = false;
    public a DvW = new a();
    public LinkedList<a> DvX = new LinkedList<>();
    private long DvY = 0;
    public long DvZ;
    public String TAG = "MicroMsg.SnsAdVideoStatistic";
    public long jkY = 0;
    public long jkZ = 0;
    public long pLQ = 0;

    public l() {
        AppMethodBeat.i(95020);
        AppMethodBeat.o(95020);
    }

    public l(String str) {
        AppMethodBeat.i(95021);
        this.TAG = "MicroMsg.SnsAdVideoStatistic:".concat(String.valueOf(str));
        AppMethodBeat.o(95021);
    }

    public final void setDuration(int i2) {
        this.pLQ = (long) i2;
        this.DvW.DwZ = i2;
    }

    public final synchronized void XK(int i2) {
        int ticksToNow;
        AppMethodBeat.i(95022);
        if (this.DvW.DwY <= 0) {
            a aVar = this.DvW;
            if (this.DvW.Dxc == 0) {
                ticksToNow = 0;
            } else {
                ticksToNow = (int) Util.ticksToNow(this.DvW.Dxc);
            }
            aVar.DwY = ticksToNow;
            eXt();
            Log.i(this.TAG, "endPlay, playTotaltime=" + this.DvW.DwY + ", pauseTotalTime=" + this.DvW.Dxe + ", playTime=" + (((long) this.DvW.DwY) - this.DvW.Dxe));
            if (((long) this.DvW.DwY) - this.DvW.Dxe > 0) {
                a aVar2 = this.DvW;
                aVar2.DwY = (int) (((long) aVar2.DwY) - this.DvW.Dxe);
            }
        }
        if (i2 != 0) {
            this.DvW.DwZ = i2;
            this.pLQ = (long) i2;
        }
        Log.i(this.TAG, "pushplayitem duration " + this.DvW.DwY + " " + this.DvW.Dxb);
        this.DvX.add(this.DvW);
        this.DvW = new a();
        AppMethodBeat.o(95022);
    }

    public final synchronized String eXr() {
        LinkedList<a> linkedList;
        String stringBuffer;
        synchronized (this) {
            AppMethodBeat.i(95023);
            this.DvP = this.DvQ == 0 ? 0 : (int) Util.ticksToNow(this.DvQ);
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("<viewinfo>");
            stringBuffer2.append("<downloadstatus>");
            stringBuffer2.append(this.DvO);
            stringBuffer2.append("</downloadstatus>");
            stringBuffer2.append("<staytotaltime>");
            stringBuffer2.append(this.DvP);
            stringBuffer2.append("</staytotaltime>");
            if (this.DvR > 0) {
                stringBuffer2.append("<masktotaltime>");
                stringBuffer2.append(this.DvR);
                stringBuffer2.append("</masktotaltime>");
            }
            LinkedList<a> linkedList2 = this.DvX;
            if (!this.DvV || this.DvX.size() <= 1) {
                linkedList = linkedList2;
            } else {
                a aVar = new a();
                for (int i2 = 0; i2 < this.DvX.size(); i2++) {
                    a aVar2 = this.DvX.get(i2);
                    if (i2 == 0) {
                        aVar.DwZ = aVar2.DwZ;
                        aVar.Dxa = aVar2.Dxa;
                        aVar.Dxb = aVar2.Dxb;
                    }
                    aVar.DwX += aVar2.DwX;
                    aVar.DwY = aVar2.DwY + aVar.DwY;
                }
                LinkedList<a> linkedList3 = new LinkedList<>();
                linkedList3.add(aVar);
                linkedList = linkedList3;
            }
            stringBuffer2.append(String.format("<playitemlist count=\"%d\">", Integer.valueOf(linkedList.size())));
            for (int i3 = 0; i3 < linkedList.size(); i3++) {
                a aVar3 = linkedList.get(i3);
                stringBuffer2.append("<playitem>");
                stringBuffer2.append(String.format("<playcount>%d</playcount>", Integer.valueOf(aVar3.DwX)));
                stringBuffer2.append(String.format("<playtotaltime>%d</playtotaltime>", Integer.valueOf(aVar3.DwY)));
                stringBuffer2.append(String.format("<videototaltime>%d</videototaltime>", Integer.valueOf(aVar3.DwZ * 1000)));
                stringBuffer2.append(String.format("<playmode>%d</playmode>", Integer.valueOf(aVar3.Dxa)));
                stringBuffer2.append(String.format("<playorientation>%d</playorientation>", Integer.valueOf(aVar3.Dxb)));
                stringBuffer2.append("</playitem>");
            }
            stringBuffer2.append("</playitemlist>");
            stringBuffer2.append("</viewinfo>");
            stringBuffer = stringBuffer2.toString();
            Log.i(this.TAG, "xml ".concat(String.valueOf(stringBuffer)));
            AppMethodBeat.o(95023);
        }
        return stringBuffer;
    }

    public final void eXs() {
        AppMethodBeat.i(95024);
        this.DvS = 0;
        this.DvT = 0;
        this.DvU = 0;
        Iterator<a> it = this.DvX.iterator();
        while (it.hasNext()) {
            a next = it.next();
            this.DvS += next.DwW;
            this.DvT += next.DwX;
            this.DvU = next.DwY + this.DvU;
        }
        if (this.DvW != null && !this.DvX.contains(this.DvW)) {
            this.DvS += this.DvW.DwW;
            this.DvT += this.DvW.DwX;
            this.DvU += this.DvW.DwY;
        }
        AppMethodBeat.o(95024);
    }

    public final void onResume() {
        AppMethodBeat.i(95025);
        if (this.jkY == 0) {
            AppMethodBeat.o(95025);
            return;
        }
        long ticksToNow = Util.ticksToNow(this.jkY);
        this.jkZ += ticksToNow;
        this.jkY = 0;
        if (this.DvW != null) {
            a aVar = this.DvW;
            aVar.Dxd = ticksToNow + aVar.Dxd;
        }
        AppMethodBeat.o(95025);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void eXt() {
        AppMethodBeat.i(202052);
        if (this.DvY == 0) {
            AppMethodBeat.o(202052);
        } else {
            long ticksToNow = Util.ticksToNow(this.DvY);
            this.DvY = 0;
            if (this.DvW != null) {
                this.DvW.Dxe += ticksToNow;
                Log.i(this.TAG, "calcPauseTime, thisPauseTime=" + ticksToNow + ", total=" + this.DvW.Dxe);
            }
            AppMethodBeat.o(202052);
        }
    }

    public final synchronized void eVQ() {
        AppMethodBeat.i(202053);
        if (this.DvW.Dxc > 0 && this.DvY == 0) {
            this.DvY = Util.currentTicks();
            Log.i(this.TAG, "onPausePlay, pauseBeginTime=" + this.DvY);
        }
        AppMethodBeat.o(202053);
    }
}
