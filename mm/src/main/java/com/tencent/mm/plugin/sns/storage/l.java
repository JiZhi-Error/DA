package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gj;
import com.tencent.mm.protocal.protobuf.ami;
import com.tencent.mm.protocal.protobuf.bft;
import com.tencent.mm.protocal.protobuf.ebi;
import com.tencent.mm.protocal.protobuf.ebj;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;

public final class l extends gj {
    protected static IAutoDBItem.MAutoDBInfo info;

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public final void feI() {
        this.field_local_flag &= -3;
    }

    public final ebi feJ() {
        AppMethodBeat.i(97466);
        ebi ebi = new ebi();
        if (!Util.isNullOrNil(this.field_snsYearMonthInfo)) {
            try {
                ebi.parseFrom(this.field_snsYearMonthInfo);
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(97466);
        return ebi;
    }

    public final void a(ebi ebi) {
        AppMethodBeat.i(97467);
        if (ebi == null) {
            AppMethodBeat.o(97467);
            return;
        }
        try {
            this.field_snsYearMonthInfo = ebi.toByteArray();
            AppMethodBeat.o(97467);
        } catch (Exception e2) {
            AppMethodBeat.o(97467);
        }
    }

    public final boolean feK() {
        return (this.field_local_flag & 2) > 0;
    }

    public final void a(ebj ebj) {
        AppMethodBeat.i(97468);
        if (ebj == null) {
            AppMethodBeat.o(97468);
            return;
        }
        try {
            this.field_snsuser = ebj.toByteArray();
            AppMethodBeat.o(97468);
        } catch (Exception e2) {
            AppMethodBeat.o(97468);
        }
    }

    public final ebj feL() {
        AppMethodBeat.i(97469);
        try {
            ebj ebj = (ebj) new ebj().parseFrom(this.field_snsuser);
            AppMethodBeat.o(97469);
            return ebj;
        } catch (Exception e2) {
            AppMethodBeat.o(97469);
            return null;
        }
    }

    public final ami feM() {
        ami ami;
        AppMethodBeat.i(97470);
        new bft();
        ami ami2 = new ami();
        if (!Util.isNullOrNil(this.field_faultS)) {
            try {
                bft bft = (bft) new bft().parseFrom(this.field_faultS);
                if (bft.LPq.size() > 0) {
                    ami = bft.LPq.getFirst();
                } else {
                    ami = ami2;
                }
                ami2 = ami;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(97470);
        return ami2;
    }

    static {
        AppMethodBeat.i(97471);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[18];
        mAutoDBInfo.columns = new String[19];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "userName";
        mAutoDBInfo.colsMap.put("userName", "TEXT default ''  PRIMARY KEY ");
        sb.append(" userName TEXT default ''  PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "userName";
        mAutoDBInfo.columns[1] = "md5";
        mAutoDBInfo.colsMap.put("md5", "TEXT");
        sb.append(" md5 TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[2] = "newerIds";
        mAutoDBInfo.colsMap.put("newerIds", "TEXT");
        sb.append(" newerIds TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[3] = "bgId";
        mAutoDBInfo.colsMap.put("bgId", "TEXT");
        sb.append(" bgId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[4] = "bgUrl";
        mAutoDBInfo.colsMap.put("bgUrl", "TEXT");
        sb.append(" bgUrl TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[5] = "older_bgId";
        mAutoDBInfo.colsMap.put("older_bgId", "TEXT");
        sb.append(" older_bgId TEXT");
        sb.append(", ");
        mAutoDBInfo.columns[6] = "local_flag";
        mAutoDBInfo.colsMap.put("local_flag", "INTEGER");
        sb.append(" local_flag INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[7] = "istyle";
        mAutoDBInfo.colsMap.put("istyle", "INTEGER");
        sb.append(" istyle INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[8] = "iFlag";
        mAutoDBInfo.colsMap.put("iFlag", "INTEGER");
        sb.append(" iFlag INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[9] = "icount";
        mAutoDBInfo.colsMap.put("icount", "INTEGER");
        sb.append(" icount INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[10] = "faultS";
        mAutoDBInfo.colsMap.put("faultS", "BLOB");
        sb.append(" faultS BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[11] = "snsBgId";
        mAutoDBInfo.colsMap.put("snsBgId", "LONG");
        sb.append(" snsBgId LONG");
        sb.append(", ");
        mAutoDBInfo.columns[12] = "snsuser";
        mAutoDBInfo.colsMap.put("snsuser", "BLOB");
        sb.append(" snsuser BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[13] = "adsession";
        mAutoDBInfo.colsMap.put("adsession", "BLOB");
        sb.append(" adsession BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[14] = "lastFirstPageRequestErrCode";
        mAutoDBInfo.colsMap.put("lastFirstPageRequestErrCode", "INTEGER");
        sb.append(" lastFirstPageRequestErrCode INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[15] = "lastFirstPageRequestErrType";
        mAutoDBInfo.colsMap.put("lastFirstPageRequestErrType", "INTEGER");
        sb.append(" lastFirstPageRequestErrType INTEGER");
        sb.append(", ");
        mAutoDBInfo.columns[16] = "snsYearMonthInfo";
        mAutoDBInfo.colsMap.put("snsYearMonthInfo", "BLOB");
        sb.append(" snsYearMonthInfo BLOB");
        sb.append(", ");
        mAutoDBInfo.columns[17] = "albumMd5";
        mAutoDBInfo.colsMap.put("albumMd5", "TEXT");
        sb.append(" albumMd5 TEXT");
        mAutoDBInfo.columns[18] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(97471);
    }
}
