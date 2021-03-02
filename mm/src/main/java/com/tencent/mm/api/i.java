package com.tencent.mm.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cv;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.protocal.protobuf.rx;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class i extends cv {
    public static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public final void fx(String str) {
        AppMethodBeat.i(114780);
        if (!Util.isNullOrNil(str)) {
            this.field_cgi = str;
        }
        AppMethodBeat.o(114780);
    }

    public final void setCmdId(int i2) {
        this.field_cmdid = i2;
    }

    public final void iG(int i2) {
        this.field_opCode = i2;
    }

    public final int Vj() {
        return this.field_opCode;
    }

    public final void fy(String str) {
        AppMethodBeat.i(114781);
        if (!Util.isNullOrNil(str)) {
            this.field_functionmsgid = str;
        }
        AppMethodBeat.o(114781);
    }

    public final String Vk() {
        return this.field_functionmsgid;
    }

    public final void bo(long j2) {
        this.field_version = j2;
    }

    public final long getVersion() {
        return this.field_version;
    }

    public final void bp(long j2) {
        this.field_preVersion = j2;
    }

    public final long Vl() {
        return this.field_preVersion;
    }

    public final void setRetryInterval(int i2) {
        this.field_retryinterval = i2;
    }

    public final void iH(int i2) {
        this.field_reportid = i2;
    }

    public final void iI(int i2) {
        this.field_successkey = i2;
    }

    public final void iJ(int i2) {
        this.field_failkey = i2;
    }

    public final void iK(int i2) {
        this.field_finalfailkey = i2;
    }

    public final void fz(String str) {
        AppMethodBeat.i(114782);
        if (!Util.isNullOrNil(str)) {
            this.field_custombuff = str;
        }
        AppMethodBeat.o(114782);
    }

    public final String Vm() {
        return this.field_custombuff;
    }

    public final void a(de deVar) {
        if (deVar != null) {
            this.field_addMsg = deVar;
        }
    }

    public final de Vn() {
        return this.field_addMsg;
    }

    public final void fA(String str) {
        if (str != null) {
            this.field_defaultContent = str;
        }
    }

    public final rx Vo() {
        return this.field_businessInfo;
    }

    public final void a(rx rxVar) {
        this.field_businessInfo = rxVar;
    }

    public final void bq(long j2) {
        this.field_delayTime = j2;
    }

    public final long Vp() {
        return this.field_delayTime;
    }

    public final long Vq() {
        return this.field_actionTime;
    }

    public final void br(long j2) {
        this.field_actionTime = j2;
    }

    public final void Vr() {
        this.field_status = -1;
    }

    public final int getStatus() {
        return this.field_status;
    }

    public final void cI(boolean z) {
        this.field_needShow = z;
    }

    public final void Vs() {
        this.field_retryCount = 0;
    }

    public final void iL(int i2) {
        this.field_retryCountLimit = i2;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(114784);
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (!iVar.field_functionmsgid.equals(this.field_functionmsgid) || iVar.systemRowid != this.systemRowid) {
                AppMethodBeat.o(114784);
                return false;
            }
            AppMethodBeat.o(114784);
            return true;
        }
        AppMethodBeat.o(114784);
        return false;
    }

    public final String toString() {
        AppMethodBeat.i(114785);
        String str = "@null";
        if (!Util.isNullOrNil(this.field_cgi)) {
            String[] split = this.field_cgi.split(FilePathGenerator.ANDROID_DIR_SEP);
            if (split.length > 0) {
                str = split[split.length - 1];
            }
        }
        String str2 = "FunctionMsgItem{cgi='" + str + '\'' + ", cmdid=" + this.field_cmdid + ", functionmsgid='" + this.field_functionmsgid + '\'' + ", version=" + this.field_version + ", preVersion=" + this.field_preVersion + ", status=" + this.field_status + ", actionTime=" + this.field_actionTime + ", delayTime=" + this.field_delayTime + ", retryCount=" + this.field_retryCount + ", retryCountLimit=" + this.field_retryCountLimit + '}';
        AppMethodBeat.o(114785);
        return str2;
    }

    public final int hashCode() {
        AppMethodBeat.i(114783);
        int hashCode = this.field_functionmsgid.hashCode();
        AppMethodBeat.o(114783);
        return hashCode;
    }

    static {
        AppMethodBeat.i(114786);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[21];
        mAutoDBInfo.columns = new String[22];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "cgi";
        mAutoDBInfo.colsMap.put("cgi", "TEXT");
        sb.append(" cgi TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[1] = "cmdid";
        mAutoDBInfo.colsMap.put("cmdid", "INTEGER");
        sb.append(" cmdid INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "functionmsgid";
        mAutoDBInfo.colsMap.put("functionmsgid", "TEXT PRIMARY KEY ");
        sb.append(" functionmsgid TEXT PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "functionmsgid";
        mAutoDBInfo.columns[3] = "version";
        mAutoDBInfo.colsMap.put("version", "LONG");
        sb.append(" version LONG");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "preVersion";
        mAutoDBInfo.colsMap.put("preVersion", "LONG");
        sb.append(" preVersion LONG");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "retryinterval";
        mAutoDBInfo.colsMap.put("retryinterval", "INTEGER");
        sb.append(" retryinterval INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "reportid";
        mAutoDBInfo.colsMap.put("reportid", "INTEGER");
        sb.append(" reportid INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "successkey";
        mAutoDBInfo.colsMap.put("successkey", "INTEGER");
        sb.append(" successkey INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "failkey";
        mAutoDBInfo.colsMap.put("failkey", "INTEGER");
        sb.append(" failkey INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "finalfailkey";
        mAutoDBInfo.colsMap.put("finalfailkey", "INTEGER");
        sb.append(" finalfailkey INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "custombuff";
        mAutoDBInfo.colsMap.put("custombuff", "TEXT");
        sb.append(" custombuff TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "addMsg";
        mAutoDBInfo.colsMap.put("addMsg", "BLOB");
        sb.append(" addMsg BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "status";
        mAutoDBInfo.colsMap.put("status", "INTEGER default '-1' ");
        sb.append(" status INTEGER default '-1' ");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "needShow";
        mAutoDBInfo.colsMap.put("needShow", "INTEGER default 'false' ");
        sb.append(" needShow INTEGER default 'false' ");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "defaultContent";
        mAutoDBInfo.colsMap.put("defaultContent", "TEXT");
        sb.append(" defaultContent TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "actionTime";
        mAutoDBInfo.colsMap.put("actionTime", "LONG default '-1' ");
        sb.append(" actionTime LONG default '-1' ");
        sb.append(", ");
        mAutoDBInfo.columns[16] = "delayTime";
        mAutoDBInfo.colsMap.put("delayTime", "LONG default '-1' ");
        sb.append(" delayTime LONG default '-1' ");
        sb.append(", ");
        mAutoDBInfo.columns[17] = "retryCount";
        mAutoDBInfo.colsMap.put("retryCount", "INTEGER default '0' ");
        sb.append(" retryCount INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[18] = "retryCountLimit";
        mAutoDBInfo.colsMap.put("retryCountLimit", "INTEGER default '0' ");
        sb.append(" retryCountLimit INTEGER default '0' ");
        sb.append(", ");
        mAutoDBInfo.columns[19] = "businessInfo";
        mAutoDBInfo.colsMap.put("businessInfo", "BLOB");
        sb.append(" businessInfo BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[20] = "opCode";
        mAutoDBInfo.colsMap.put("opCode", "INTEGER default '-1' ");
        sb.append(" opCode INTEGER default '-1' ");
        mAutoDBInfo.columns[21] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(114786);
    }
}
