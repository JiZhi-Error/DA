package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.s;

public final class c extends s<ShareCardInfo> {
    private final String TAG = "MicroMsg.ShareCardAdatper";
    long beginTime = 0;
    long endTime = 0;
    private int pXn = 0;
    com.tencent.mm.plugin.card.base.c pXo;
    private int pXp = -1;

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
    @Override // com.tencent.mm.ui.s
    public final /* synthetic */ ShareCardInfo a(ShareCardInfo shareCardInfo, Cursor cursor) {
        AppMethodBeat.i(113079);
        ShareCardInfo shareCardInfo2 = shareCardInfo;
        if (shareCardInfo2 == null) {
            shareCardInfo2 = new ShareCardInfo();
        }
        if (cursor.isClosed()) {
            Log.e("MicroMsg.ShareCardAdatper", "cursor is closed!");
            AppMethodBeat.o(113079);
        } else {
            shareCardInfo2.convertFrom(cursor);
            AppMethodBeat.o(113079);
        }
        return shareCardInfo2;
    }

    public c(Context context) {
        super(context, new ShareCardInfo());
        AppMethodBeat.i(113074);
        Bh(true);
        this.pXo = new j(context, this);
        AppMethodBeat.o(113074);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(113075);
        View a2 = this.pXo.a(i2, view, (ShareCardInfo) getItem(i2));
        AppMethodBeat.o(113075);
        return a2;
    }

    @Override // com.tencent.mm.ui.s
    public final void anp() {
        Cursor rawQuery;
        AppMethodBeat.i(113076);
        this.beginTime = System.currentTimeMillis();
        if (this.pXp == -1) {
            k ctY = am.ctY();
            n.a aVar = n.a.NORMAL_TYPE;
            StringBuilder sb = new StringBuilder();
            switch (aVar) {
                case NORMAL_TYPE:
                    sb.append(" where (status=0 OR status=5)");
                    break;
                case INVALID_TYPE:
                    sb.append(" where (status=1 OR status=2 OR status").append("=3 OR status=4 OR status=6)");
                    break;
                case CAN_GIFT_TYPE:
                    sb.append(" where (status=0 OR status=5) and (block_mask").append("= '1' OR block_mask= '0' )");
                    break;
            }
            rawQuery = ctY.db.rawQuery("select * from ShareCardInfo" + sb.toString() + " order by status asc , share_time desc", null);
        } else {
            k ctY2 = am.ctY();
            int i2 = this.pXp;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" where ( status=0) ");
            String str = "";
            switch (i2) {
                case 1:
                    sb2.append(" AND ");
                    sb2.append(" (");
                    sb2.append(k.Ek(1));
                    sb2.append(" categoryType= '10' ");
                    sb2.append(") ");
                    str = " order by categoryType desc , itemIndex asc";
                    break;
                case 2:
                    sb2.append(" AND (");
                    sb2.append(" (");
                    sb2.append(k.Ek(1));
                    sb2.append(" categoryType= '10' ");
                    sb2.append(") ");
                    sb2.append(" OR (");
                    sb2.append(k.Ek(2));
                    sb2.append(" categoryType= '0' ");
                    sb2.append(") ");
                    sb2.append(" )");
                    str = " order by categoryType desc , itemIndex asc";
                    break;
                case 3:
                    sb2.append(" AND ");
                    sb2.append(" (");
                    sb2.append(k.Ek(2));
                    sb2.append(" categoryType= '0' ");
                    sb2.append(") ");
                    str = " order by categoryType desc , itemIndex asc";
                    break;
                case 4:
                    sb2.append(" AND 1 != 1 ");
                    break;
            }
            rawQuery = ctY2.db.rawQuery("select * from ShareCardInfo" + sb2.toString() + str, null);
        }
        if (rawQuery != null) {
            this.pXn = rawQuery.getCount();
            Log.i("MicroMsg.ShareCardAdatper", "resetCursor showType %s, card count:%s", Integer.valueOf(this.pXp), Integer.valueOf(this.pXn));
        } else {
            Log.e("MicroMsg.ShareCardAdatper", "resetCursor cursor is null, showType %s", Integer.valueOf(this.pXp));
        }
        setCursor(rawQuery);
        this.endTime = System.currentTimeMillis();
        notifyDataSetChanged();
        AppMethodBeat.o(113076);
    }

    @Override // com.tencent.mm.ui.s
    public final void anq() {
        AppMethodBeat.i(113077);
        ebf();
        anp();
        AppMethodBeat.o(113077);
    }

    public final void Eo(int i2) {
        AppMethodBeat.i(113078);
        this.pXp = i2;
        onNotifyChange(null, null);
        AppMethodBeat.o(113078);
    }
}
