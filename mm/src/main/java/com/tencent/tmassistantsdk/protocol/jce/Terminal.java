package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class Terminal extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!Terminal.class.desiredAssertionStatus());
    private static final String TAG = "Terminal";
    public String androidId = "";
    public String androidIdSdCard = "";
    public String imei = "";
    public String imsi = "";
    public String macAdress = "";

    static {
        AppMethodBeat.i(102395);
        AppMethodBeat.o(102395);
    }

    public final String className() {
        return "jce.Terminal";
    }

    public final String fullClassName() {
        return TAG;
    }

    public final String getImei() {
        return this.imei;
    }

    public final void setImei(String str) {
        this.imei = str;
    }

    public final String getMacAdress() {
        return this.macAdress;
    }

    public final void setMacAdress(String str) {
        this.macAdress = str;
    }

    public final String getAndroidId() {
        return this.androidId;
    }

    public final void setAndroidId(String str) {
        this.androidId = str;
    }

    public final String getAndroidIdSdCard() {
        return this.androidIdSdCard;
    }

    public final void setAndroidIdSdCard(String str) {
        this.androidIdSdCard = str;
    }

    public final String getImsi() {
        return this.imsi;
    }

    public final void setImsi(String str) {
        this.imsi = str;
    }

    public Terminal() {
    }

    public Terminal(String str, String str2, String str3, String str4, String str5) {
        this.imei = str;
        this.macAdress = str2;
        this.androidId = str3;
        this.androidIdSdCard = str4;
        this.imsi = str5;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(102388);
        if (obj == null) {
            AppMethodBeat.o(102388);
            return false;
        }
        Terminal terminal = (Terminal) obj;
        if (!JceUtil.equals(this.imei, terminal.imei) || !JceUtil.equals(this.macAdress, terminal.macAdress) || !JceUtil.equals(this.androidId, terminal.androidId) || !JceUtil.equals(this.androidIdSdCard, terminal.androidIdSdCard) || !JceUtil.equals(this.imsi, terminal.imsi)) {
            AppMethodBeat.o(102388);
            return false;
        }
        AppMethodBeat.o(102388);
        return true;
    }

    public final int hashCode() {
        AppMethodBeat.i(102389);
        try {
            Exception exc = new Exception("Need define key first!");
            AppMethodBeat.o(102389);
            throw exc;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(102389);
            return 0;
        }
    }

    @Override // java.lang.Object
    public final Object clone() {
        AppMethodBeat.i(102390);
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e2) {
            if (!$assertionsDisabled) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(102390);
                throw assertionError;
            }
        }
        AppMethodBeat.o(102390);
        return obj;
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(102391);
        if (this.imei != null) {
            jceOutputStream.write(this.imei, 0);
        }
        if (this.macAdress != null) {
            jceOutputStream.write(this.macAdress, 1);
        }
        if (this.androidId != null) {
            jceOutputStream.write(this.androidId, 2);
        }
        if (this.androidIdSdCard != null) {
            jceOutputStream.write(this.androidIdSdCard, 3);
        }
        if (this.imsi != null) {
            jceOutputStream.write(this.imsi, 4);
        }
        AppMethodBeat.o(102391);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(102392);
        this.imei = jceInputStream.readString(0, false);
        this.macAdress = jceInputStream.readString(1, false);
        this.androidId = jceInputStream.readString(2, false);
        this.androidIdSdCard = jceInputStream.readString(3, false);
        this.imsi = jceInputStream.readString(4, false);
        AppMethodBeat.o(102392);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void display(StringBuilder sb, int i2) {
        AppMethodBeat.i(102393);
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i2);
        jceDisplayer.display(this.imei, "imei");
        jceDisplayer.display(this.macAdress, "macAdress");
        jceDisplayer.display(this.androidId, "androidId");
        jceDisplayer.display(this.androidIdSdCard, "androidIdSdCard");
        jceDisplayer.display(this.imsi, "imsi");
        AppMethodBeat.o(102393);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void displaySimple(StringBuilder sb, int i2) {
        AppMethodBeat.i(102394);
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i2);
        jceDisplayer.displaySimple(this.imei, true);
        jceDisplayer.displaySimple(this.macAdress, true);
        jceDisplayer.displaySimple(this.androidId, true);
        jceDisplayer.displaySimple(this.androidIdSdCard, true);
        jceDisplayer.displaySimple(this.imsi, false);
        AppMethodBeat.o(102394);
    }
}
