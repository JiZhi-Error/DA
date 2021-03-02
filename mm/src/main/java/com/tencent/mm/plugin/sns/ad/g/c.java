package com.tencent.mm.plugin.sns.ad.g;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.widget.e;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.cf;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class c {
    public View Atk;
    public int DuA;
    private View DuB;
    private int DuC = 0;
    private int DuD;
    long DuE = 0;
    private ADInfo DuF = null;
    ADXml DuG;
    int DuH = -10086;
    private int DuI = -10086;
    int DuJ = -10086;
    private int DuK = -10086;
    long DuL = 0;
    long DuM = 0;
    private int DuN = -10086;
    private int DuO = -10086;
    long DuP = 0;
    private int DuQ = -10086;
    private int DuR = -10086;
    long DuS = 0;
    private int DuT = -10086;
    private int DuU = -10086;
    long DuV = 0;
    private int DuW = -10086;
    private int DuX = -10086;
    long DuY = 0;
    int DuZ = 0;
    boolean Duw = false;
    public View Dux;
    public int Duy = 0;
    public int Duz = 0;
    int Dva = -1;
    int Dvb = -1;
    int Dvc = 0;
    int Dvd = 0;
    int Dve = 0;
    boolean Dvf = false;
    public String dJX = "";
    public int gRE = 0;
    public String gTk = "";
    boolean idt = false;
    int position = 0;
    public int sceneType = 1;
    public SnsObject snsobj;
    private String viewId = "";

    public c(ADInfo aDInfo, String str, long j2, View view, int i2, View view2, int i3, int i4, SnsObject snsObject, int i5, ADXml aDXml) {
        AppMethodBeat.i(94975);
        this.position = i5;
        this.Dux = view;
        this.snsobj = snsObject;
        this.DuG = aDXml;
        this.DuF = aDInfo;
        this.sceneType = i4;
        this.viewId = aDInfo == null ? "" : Util.nullAs(aDInfo.viewId, "");
        this.gTk = aDInfo == null ? "" : Util.nullAs(aDInfo.uxInfo, "");
        this.dJX = str;
        this.DuE = j2;
        this.DuA = i2;
        this.DuB = view2;
        this.DuC = i3;
        if (this.Dux != null) {
            this.Atk = this.Dux.findViewById(R.id.ke);
        }
        initView();
        AppMethodBeat.o(94975);
    }

    private void initView() {
        AppMethodBeat.i(94976);
        if (this.gRE == 0 && this.Dux != null) {
            this.gRE = this.Dux.getHeight();
            if (this.Atk != null && this.Atk.getVisibility() == 0) {
                this.Duy = this.Atk.getHeight();
            }
            if (this.gRE == 0) {
                AppMethodBeat.o(94976);
                return;
            }
            this.DuD = 0;
            if (this.DuB != null) {
                this.DuD = this.DuB.getBottom();
            }
            this.gRE -= this.Duy;
            this.Duz = this.gRE / 2;
            this.DuA = (this.DuA - this.DuD) - this.DuC;
            Log.i("MicroMsg.AdViewStatic", "viewHeight " + this.gRE + " SCREEN_HEIGHT: " + this.DuA + " abottom: " + this.DuD + " stHeight: " + this.DuC + " commentViewHeight:" + this.Duy);
        }
        AppMethodBeat.o(94976);
    }

    public final void uL(boolean z) {
        AppMethodBeat.i(94977);
        if (this.Dux != null) {
            initView();
            if (this.idt || this.gRE <= 0) {
                AppMethodBeat.o(94977);
                return;
            }
            this.Duw = true;
            int[] iArr = new int[2];
            this.Dux.getLocationOnScreen(iArr);
            int i2 = (iArr[1] - this.DuD) - this.DuC;
            int i3 = i2 + this.gRE;
            if (i2 < 0 || i3 < 0 || i3 > this.DuA) {
                this.Dve = 0;
            } else {
                this.Dve = 1;
            }
            if (this.DuH == -10086 && this.DuI == -10086) {
                this.DuH = i2;
                this.DuI = i3;
            }
            this.DuJ = i2;
            this.DuK = i3;
            Log.i("MicroMsg.AdViewStatic", "get top " + i2 + " bottom " + i3 + " body_half: " + this.Duz + "| " + (this.gRE + i2) + "  firsttop " + this.DuH + " endtop " + this.DuJ);
            if (i2 < 0) {
                int i4 = i2 + this.gRE;
                int i5 = this.gRE - i4;
                Log.i("MicroMsg.AdViewStatic", "top " + i2 + " screen in " + i4 + " out: " + i5);
                boolean z2 = true;
                if (i4 >= this.Duz && this.DuN == -10086) {
                    this.DuN = i2;
                    this.DuO = i3;
                    this.DuP = System.currentTimeMillis();
                    z2 = false;
                    Log.i("MicroMsg.AdViewStatic", "up first touch half" + i4 + " top " + i2 + " viewhieght " + this.gRE + " inscreenval: " + i4 + " outscreenval: " + i5);
                    Log.d("MicroMsg.AdViewStatic", "halfExposure old 0, begin:" + this.DuP + ", hash=" + hashCode());
                }
                if (i5 >= this.Duz && this.DuQ == -10086 && z2 && this.DuP > 0) {
                    this.DuQ = i2;
                    this.DuR = i3;
                    this.DuS = System.currentTimeMillis();
                    Log.i("MicroMsg.AdViewStatic", "down first touch half" + i4 + " bottom " + i3 + " viewhieght " + this.gRE + " inscreenval: " + i4 + " outscreenval: " + i5);
                    Log.d("MicroMsg.AdViewStatic", "halfExposure old 0, end:" + (this.DuS - this.DuP) + ", hash=" + hashCode());
                }
                in(i4, i5);
            }
            if (i3 > this.DuA) {
                boolean z3 = true;
                int i6 = i3 - this.DuA;
                int i7 = this.gRE - i6;
                Log.i("MicroMsg.AdViewStatic", "bottom " + i3 + " screen in " + i7 + " out: " + i6);
                if (i7 >= this.Duz && this.DuN == -10086) {
                    this.DuN = i2;
                    this.DuO = i3;
                    this.DuP = System.currentTimeMillis();
                    z3 = false;
                    Log.i("MicroMsg.AdViewStatic", "up first touch half" + i6 + " top " + i2 + " viewhieght " + this.gRE + " inscreenval: " + i7 + " outscreenval: " + i6);
                    Log.d("MicroMsg.AdViewStatic", "halfExposure old 1, begin:" + this.DuP + ", hash=" + hashCode());
                }
                if (i6 >= this.Duz && this.DuQ == -10086 && z3 && this.DuP > 0) {
                    this.DuQ = i2;
                    this.DuR = i3;
                    this.DuS = System.currentTimeMillis();
                    Log.i("MicroMsg.AdViewStatic", "down first touch half" + i6 + " bottom " + i3 + " viewhieght " + this.gRE + " inscreenval: " + i7 + " outscreenval: " + i6);
                    Log.d("MicroMsg.AdViewStatic", "halfExposure old 1, end:" + (this.DuS - this.DuP) + ", hash=" + hashCode());
                }
                in(i7, i6);
            }
            if (i2 < 0 || i3 > this.DuA) {
                if (this.DuY == 0 && this.DuV != 0) {
                    this.DuW = i2;
                    this.DuX = i3;
                    this.DuY = System.currentTimeMillis();
                    Log.d("MicroMsg.AdViewStatic", "fullExposure old, end:" + (this.DuY - this.DuV) + ", hash=" + hashCode());
                }
            } else if (this.DuV == 0) {
                this.DuT = i2;
                this.DuU = i3;
                this.DuV = System.currentTimeMillis();
                Log.d("MicroMsg.AdViewStatic", "fullExposure old, begin:" + this.DuV + ", hash=" + hashCode());
            }
            if (i2 < 0) {
                int i8 = -i2;
                if (this.Dva == -1 || this.Dva > i8) {
                    this.Dva = i8;
                }
            } else {
                this.Dva = 0;
            }
            if (i3 > this.DuA) {
                int i9 = i3 - this.DuA;
                if (this.Dvb == -1 || this.Dvb > i9) {
                    this.Dvb = i9;
                }
            } else {
                this.Dvb = 0;
            }
            int i10 = this.gRE;
            if (i2 < 0) {
                i10 += i2;
            }
            if (i3 > this.DuA) {
                i10 -= i3 - this.DuA;
            }
            if (this.DuZ == -1 || this.DuZ < i10) {
                this.DuZ = i10;
            }
            Log.i("MicroMsg.AdViewStatic", "unreadtop: " + this.Dva + " unreadBottom:" + this.Dvb + " readHeight: " + this.DuZ + (z ? " isScrooIde" : ""));
        }
        AppMethodBeat.o(94977);
    }

    private void in(int i2, int i3) {
        boolean z = true;
        if (i2 >= this.Duz) {
            this.Dvf = true;
            z = false;
        }
        if (i3 >= this.Duz && z) {
            this.Dvf = false;
        }
    }

    public final cf eXo() {
        SnsObject C;
        AppMethodBeat.i(94978);
        cf cfVar = new cf();
        SnsInfo JJ = aj.faO().JJ(this.DuE);
        if (JJ != null && (C = an.C(JJ)) != null) {
            cfVar.KGx = a(C);
            cfVar.KGw = C.LikeUserList.size();
            AppMethodBeat.o(94978);
            return cfVar;
        } else if (this.snsobj != null) {
            cfVar.KGx = a(this.snsobj);
            cfVar.KGw = this.snsobj.LikeUserList.size();
            AppMethodBeat.o(94978);
            return cfVar;
        } else {
            AppMethodBeat.o(94978);
            return null;
        }
    }

    private static int a(SnsObject snsObject) {
        boolean z;
        int i2;
        int i3 = 0;
        AppMethodBeat.i(202033);
        if (snsObject == null) {
            Log.e("MicroMsg.AdViewStatic", "getReportCommentCount, snsObj==null");
            AppMethodBeat.o(202033);
        } else {
            LinkedList<dzo> linkedList = snsObject.CommentUserList;
            if (linkedList != null) {
                Iterator<dzo> it = linkedList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    dzo next = it.next();
                    if (next != null && e.iY(next.MYX, 32)) {
                        z = true;
                        break;
                    }
                }
                int size = linkedList.size();
                if (z) {
                    i2 = size - 1;
                } else {
                    i2 = size;
                }
                if (i2 >= 0) {
                    i3 = i2;
                }
                Log.i("MicroMsg.AdViewStatic", "getReportCommentCount, snsId=" + r.Jb(snsObject.Id) + ", commentList.size=" + linkedList.size() + ", commentCount=" + snsObject.CommentUserListCount + ", ret=" + i3);
                AppMethodBeat.o(202033);
            } else {
                AppMethodBeat.o(202033);
            }
        }
        return i3;
    }

    public final boolean eXp() {
        return this.Dve == 1;
    }
}
