package com.tencent.mm.ui.chatting.viewitems;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k;
import com.tencent.mm.pluginsdk.ui.chat.c;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.z;

public class bq extends c {
    public Bundle CAJ;
    public long IZC;
    public int IZD;
    public String Nwj;
    public boolean PQC;
    public boolean PQD;
    public boolean PQE;
    public String PQF;
    public boolean PQG;
    public Bundle PQH;
    public z PQI;
    public int PQJ;
    public String PQK;
    public boolean Pdm;
    public String chatroomName;
    public k.b dXm;
    public String desc;
    public String designerName;
    public String designerRediretctUrl;
    public int designerUIN;
    public String eag;
    public String eah;
    public String egX;
    public int ehX;
    public String fQR;
    public int iEt;
    public String iconUrl;
    public String iyW;
    public int opType;
    public int pageType;
    public String pageUrl;
    public int position;
    public String productId;
    public String secondUrl;
    public int tid;
    public String title;
    public String userName;

    public bq() {
        this.iEt = 0;
        this.ehX = 0;
        this.PQJ = -1;
    }

    public bq(ca caVar, int i2, String str, String str2, String str3, String str4, String str5, int i3, String str6, String str7, String str8) {
        this.iEt = 0;
        this.ehX = 0;
        this.PQJ = -1;
        this.dTX = caVar;
        this.Pdm = false;
        this.position = i2;
        this.userName = str;
        this.PQC = false;
        this.title = str2;
        this.eag = str3;
        this.eah = str4;
        this.Nwj = str5;
        this.designerUIN = i3;
        this.designerName = str6;
        this.designerRediretctUrl = str7;
        this.fQR = str8;
    }

    public bq(ca caVar, boolean z, int i2, String str, boolean z2, String str2, String str3, String str4, String str5, String str6, String str7, boolean z3, boolean z4) {
        this.iEt = 0;
        this.ehX = 0;
        this.PQJ = -1;
        this.dTX = caVar;
        this.Pdm = z;
        this.position = i2;
        this.userName = str;
        this.PQC = z2;
        this.title = str2;
        this.eag = str3;
        this.eah = str4;
        this.Nwj = str5;
        this.productId = str6;
        this.fQR = str7;
        this.PQD = z3;
        this.PQE = z4;
    }

    public bq(ca caVar, boolean z, int i2, String str, boolean z2, String str2, String str3, String str4, String str5) {
        this(caVar, z, i2, str, z2, str2, str3, str4, str5, null, null, false, false);
    }

    public bq(ca caVar, boolean z, int i2, String str, boolean z2, String str2, String str3, String str4) {
        this(caVar, z, i2, str, z2, str2, str3, str4, null);
    }

    private bq(ca caVar, boolean z, int i2, String str) {
        this(caVar, z, i2, str, false, null, null, null);
    }

    private bq(ca caVar, boolean z, int i2, String str, byte b2) {
        this(caVar, z, i2, str);
    }

    public bq(ca caVar, boolean z, int i2, String str, char c2) {
        this(caVar, z, i2, str, (byte) 0);
    }

    public bq(ca caVar, boolean z, int i2, String str, String str2) {
        this(caVar, z, i2, str, (byte) 0);
        this.chatroomName = str2;
    }

    public bq(ca caVar, String str) {
        this(str);
        this.dTX = caVar;
    }

    private bq(String str) {
        this.iEt = 0;
        this.ehX = 0;
        this.PQJ = -1;
        this.userName = str;
    }

    public bq(String str, String str2) {
        this.iEt = 0;
        this.ehX = 0;
        this.PQJ = -1;
        this.userName = str;
        this.chatroomName = str2;
    }

    public bq(ca caVar, String str, String str2) {
        this.iEt = 0;
        this.ehX = 0;
        this.PQJ = -1;
        this.dTX = caVar;
        this.userName = str;
        this.dTX = caVar;
        this.pageUrl = str2;
    }

    public static bq bnn(String str) {
        AppMethodBeat.i(37553);
        bq bqVar = new bq();
        bqVar.fQR = str;
        AppMethodBeat.o(37553);
        return bqVar;
    }

    public static bq a(k.b bVar, ca caVar) {
        AppMethodBeat.i(37554);
        bq bqVar = new bq();
        bqVar.dXm = bVar;
        bqVar.dTX = caVar;
        AppMethodBeat.o(37554);
        return bqVar;
    }

    public static bq b(ca caVar, boolean z, int i2) {
        AppMethodBeat.i(37555);
        bq bqVar = new bq();
        bqVar.dTX = caVar;
        bqVar.Pdm = z;
        bqVar.position = i2;
        bqVar.PQG = false;
        AppMethodBeat.o(37555);
        return bqVar;
    }

    public final bq bno(String str) {
        this.egX = str;
        return this;
    }
}
