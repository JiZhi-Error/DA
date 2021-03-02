package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hk;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.daf;
import com.tencent.mm.protocal.protobuf.exd;
import com.tencent.mm.protocal.protobuf.exk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.lang.reflect.Field;
import java.util.Iterator;

public final class aj extends hk {
    public static IAutoDBItem.MAutoDBInfo info;
    public String IbA = "";
    public String IbB = "";
    public String IbC = "";
    private daf Ibv = new daf();
    public exd Ibw = null;
    public exk Ibx = null;
    public boolean Iby = false;
    public String Ibz = "";
    public String yXn = "";

    @Override // com.tencent.mm.sdk.storage.IAutoDBItem
    public final IAutoDBItem.MAutoDBInfo getDBInfo() {
        return info;
    }

    public aj() {
        AppMethodBeat.i(70469);
        if (this.Ibw == null) {
            this.Ibw = new exd();
        }
        if (this.Ibx == null) {
            this.Ibx = new exk();
        }
        AppMethodBeat.o(70469);
    }

    @Override // com.tencent.mm.g.c.hk, com.tencent.mm.sdk.storage.IAutoDBItem, com.tencent.mm.sdk.storage.MDBItem
    public final void convertFrom(Cursor cursor) {
        AppMethodBeat.i(70470);
        super.convertFrom(cursor);
        this.Ibv = new daf();
        try {
            this.Ibv = (daf) this.Ibv.parseFrom(this.field_wallet_grey_item_buf);
            this.Ibw = this.Ibv.MFs;
            this.Ibx = this.Ibv.MFt;
            this.Iby = this.Ibv.MFu;
            this.IbC = "";
            Iterator<String> it = this.Ibv.MFv.iterator();
            while (it.hasNext()) {
                this.IbC += it.next() + "\n";
            }
            if (this.Ibv.MFq != null) {
                this.Ibz = z.a(this.Ibv.MFq.NuO);
                this.IbA = z.a(this.Ibv.MFq.NuP);
            }
            if (this.Ibv.MFr != null) {
                this.IbB = z.a(this.Ibv.MFr.NuM);
                this.yXn = z.a(this.Ibv.MFr.NuN);
            }
            Log.v("WalletRegionGreyItem", "noticeContent %s", this.IbB);
        } catch (Exception e2) {
            Log.e("WalletRegionGreyItem", "parser PayIBGGetOverseaWalletRsp error");
        }
        if (this.Ibw == null) {
            this.Ibw = new exd();
        }
        if (this.Ibx == null) {
            this.Ibx = new exk();
        }
        AppMethodBeat.o(70470);
    }

    static {
        AppMethodBeat.i(70471);
        IAutoDBItem.MAutoDBInfo mAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
        mAutoDBInfo.fields = new Field[2];
        mAutoDBInfo.columns = new String[3];
        StringBuilder sb = new StringBuilder();
        mAutoDBInfo.columns[0] = "wallet_region";
        mAutoDBInfo.colsMap.put("wallet_region", "INTEGER PRIMARY KEY ");
        sb.append(" wallet_region INTEGER PRIMARY KEY ");
        sb.append(", ");
        mAutoDBInfo.primaryKey = "wallet_region";
        mAutoDBInfo.columns[1] = "wallet_grey_item_buf";
        mAutoDBInfo.colsMap.put("wallet_grey_item_buf", "BLOB");
        sb.append(" wallet_grey_item_buf BLOB");
        mAutoDBInfo.columns[2] = "rowid";
        mAutoDBInfo.sql = sb.toString();
        info = mAutoDBInfo;
        AppMethodBeat.o(70471);
    }
}
