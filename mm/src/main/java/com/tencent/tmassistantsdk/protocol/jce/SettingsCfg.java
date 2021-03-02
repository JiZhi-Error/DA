package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class SettingsCfg extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!SettingsCfg.class.desiredAssertionStatus());
    private static final String TAG = "SettingsCfg";
    static byte[] cache_cfg;
    public byte[] cfg = null;
    public long revision = 0;
    public byte type = 0;

    static {
        AppMethodBeat.i(102379);
        AppMethodBeat.o(102379);
    }

    public final String className() {
        return "jce.SettingsCfg";
    }

    public final String fullClassName() {
        return TAG;
    }

    public final byte getType() {
        return this.type;
    }

    public final void setType(byte b2) {
        this.type = b2;
    }

    public final byte[] getCfg() {
        return this.cfg;
    }

    public final void setCfg(byte[] bArr) {
        this.cfg = bArr;
    }

    public final long getRevision() {
        return this.revision;
    }

    public final void setRevision(long j2) {
        this.revision = j2;
    }

    public SettingsCfg() {
    }

    public SettingsCfg(byte b2, byte[] bArr, long j2) {
        this.type = b2;
        this.cfg = bArr;
        this.revision = j2;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(102372);
        if (obj == null) {
            AppMethodBeat.o(102372);
            return false;
        }
        SettingsCfg settingsCfg = (SettingsCfg) obj;
        if (!JceUtil.equals(this.type, settingsCfg.type) || !JceUtil.equals(this.cfg, settingsCfg.cfg) || !JceUtil.equals(this.revision, settingsCfg.revision)) {
            AppMethodBeat.o(102372);
            return false;
        }
        AppMethodBeat.o(102372);
        return true;
    }

    public final int hashCode() {
        AppMethodBeat.i(102373);
        try {
            Exception exc = new Exception("Need define key first!");
            AppMethodBeat.o(102373);
            throw exc;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            AppMethodBeat.o(102373);
            return 0;
        }
    }

    @Override // java.lang.Object
    public final Object clone() {
        AppMethodBeat.i(102374);
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e2) {
            if (!$assertionsDisabled) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(102374);
                throw assertionError;
            }
        }
        AppMethodBeat.o(102374);
        return obj;
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(102375);
        jceOutputStream.write(this.type, 0);
        jceOutputStream.write(this.cfg, 1);
        jceOutputStream.write(this.revision, 2);
        AppMethodBeat.o(102375);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(102376);
        this.type = jceInputStream.read(this.type, 0, true);
        if (cache_cfg == null) {
            byte[] bArr = new byte[1];
            cache_cfg = bArr;
            bArr[0] = 0;
        }
        this.cfg = jceInputStream.read(cache_cfg, 1, true);
        this.revision = jceInputStream.read(this.revision, 2, false);
        AppMethodBeat.o(102376);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void display(StringBuilder sb, int i2) {
        AppMethodBeat.i(102377);
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i2);
        jceDisplayer.display(this.type, "type");
        jceDisplayer.display(this.cfg, "cfg");
        jceDisplayer.display(this.revision, "revision");
        AppMethodBeat.o(102377);
    }

    @Override // com.qq.taf.jce.JceStruct
    public final void displaySimple(StringBuilder sb, int i2) {
        AppMethodBeat.i(102378);
        JceDisplayer jceDisplayer = new JceDisplayer(sb, i2);
        jceDisplayer.displaySimple(this.type, true);
        jceDisplayer.displaySimple(this.cfg, true);
        jceDisplayer.displaySimple(this.revision, false);
        AppMethodBeat.o(102378);
    }
}
