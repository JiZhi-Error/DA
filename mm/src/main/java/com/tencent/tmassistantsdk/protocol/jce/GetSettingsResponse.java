package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;

public final class GetSettingsResponse extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!GetSettingsResponse.class.desiredAssertionStatus());
    private static final String TAG = "GetSettingsResponse";
    static ArrayList<SettingsCfg> cache_settings;
    public int ret = 0;
    public ArrayList<SettingsCfg> settings = null;

    static {
        AppMethodBeat.i(102307);
        AppMethodBeat.o(102307);
    }

    public final String className() {
        return "jce.GetSettingsResponse";
    }

    public final String fullClassName() {
        return TAG;
    }

    public final int getRet() {
        return this.ret;
    }

    public final void setRet(int i2) {
        this.ret = i2;
    }

    public final ArrayList<SettingsCfg> getSettings() {
        return this.settings;
    }

    public final void setSettings(ArrayList<SettingsCfg> arrayList) {
        this.settings = arrayList;
    }

    public GetSettingsResponse() {
    }

    public GetSettingsResponse(int i2, ArrayList<SettingsCfg> arrayList) {
        this.ret = i2;
        this.settings = arrayList;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(102300);
        if (obj == null) {
            AppMethodBeat.o(102300);
            return false;
        }
        GetSettingsResponse getSettingsResponse = (GetSettingsResponse) obj;
        if (!JceUtil.equals(this.ret, getSettingsResponse.ret) || !JceUtil.equals(this.settings, getSettingsResponse.settings)) {
            AppMethodBeat.o(102300);
            return false;
        }
        AppMethodBeat.o(102300);
        return true;
    }

    public final int hashCode() {
        AppMethodBeat.i(102301);
        try {
            Exception exc = new Exception("Need define key first!");
            AppMethodBeat.o(102301);
            throw exc;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(102301);
            return 0;
        }
    }

    @Override // java.lang.Object
    public final Object clone() {
        AppMethodBeat.i(102302);
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e2) {
            if (!$assertionsDisabled) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(102302);
                throw assertionError;
            }
        }
        AppMethodBeat.o(102302);
        return obj;
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(102303);
        jceOutputStream.write(this.ret, 0);
        if (this.settings != null) {
            jceOutputStream.write((Collection) this.settings, 1);
        }
        AppMethodBeat.o(102303);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(102304);
        this.ret = jceInputStream.read(this.ret, 0, true);
        if (cache_settings == null) {
            cache_settings = new ArrayList<>();
            cache_settings.add(new SettingsCfg());
        }
        this.settings = (ArrayList) jceInputStream.read((Object) cache_settings, 1, false);
        AppMethodBeat.o(102304);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void display(StringBuilder sb, int i2) {
        AppMethodBeat.i(102305);
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i2);
        jceDisplayer.display(this.ret, "ret");
        jceDisplayer.display((Collection) this.settings, "settings");
        AppMethodBeat.o(102305);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void displaySimple(StringBuilder sb, int i2) {
        AppMethodBeat.i(102306);
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i2);
        jceDisplayer.displaySimple(this.ret, true);
        jceDisplayer.displaySimple((Collection) this.settings, false);
        AppMethodBeat.o(102306);
    }
}
