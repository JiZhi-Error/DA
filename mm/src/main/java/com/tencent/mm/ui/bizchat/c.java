package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.al.a.d;
import com.tencent.mm.al.a.e;
import com.tencent.mm.al.ag;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.s;

public final class c extends s<com.tencent.mm.al.a.c> implements MStorageEx.IOnStorageChange {
    private final MMActivity gte;
    private com.tencent.mm.av.a.a.c gzE = null;
    protected MMSlideDelView.g pkY;
    protected MMSlideDelView.c pkZ;
    protected MMSlideDelView.f pla;
    protected MMSlideDelView.d plb = MMSlideDelView.getItemStatusCallBack();
    private final String ppO;

    public static class a {
        public ImageView gvv;
        public TextView gvw;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
    @Override // com.tencent.mm.ui.s
    public final /* synthetic */ com.tencent.mm.al.a.c a(com.tencent.mm.al.a.c cVar, Cursor cursor) {
        AppMethodBeat.i(33964);
        com.tencent.mm.al.a.c cVar2 = cVar;
        if (cVar2 == null) {
            cVar2 = new com.tencent.mm.al.a.c();
        }
        cVar2.convertFrom(cursor);
        AppMethodBeat.o(33964);
        return cVar2;
    }

    public c(Context context, s.a aVar, String str) {
        super(context, new com.tencent.mm.al.a.c());
        AppMethodBeat.i(33958);
        super.a(aVar);
        this.gte = (MMActivity) context;
        this.ppO = str;
        c.a aVar2 = new c.a();
        aVar2.prefixPath = e.fe(this.ppO);
        aVar2.jbf = true;
        aVar2.hZF = true;
        aVar2.jbq = R.raw.default_avatar;
        this.gzE = aVar2.bdv();
        AppMethodBeat.o(33958);
    }

    @Override // com.tencent.mm.ui.s
    public final void anp() {
        AppMethodBeat.i(33959);
        ebf();
        d baj = ag.baj();
        String str = this.ppO;
        StringBuilder sb = new StringBuilder();
        sb.append("select * from BizChatInfo");
        sb.append(" where brandUserName = '").append(str).append("'");
        sb.append(" and (bitFlag & 8) != 0 ");
        StringBuilder append = sb.append(" order by ");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" case when length(BizChatInfo.chatNamePY) > 0 then upper(BizChatInfo.chatNamePY) ");
        stringBuffer.append(" else upper(BizChatInfo.chatName) end asc, ");
        stringBuffer.append(" upper(BizChatInfo.chatNamePY) asc, ");
        stringBuffer.append(" upper(BizChatInfo.chatName) asc ");
        append.append(stringBuffer.toString());
        Log.d("MicroMsg.BizChatInfoStorage", "getBizChatFavCursor: sql:%s", sb.toString());
        setCursor(baj.db.rawQuery(sb.toString(), null));
        if (this.OFI != null) {
            this.OFI.bnE();
        }
        super.notifyDataSetChanged();
        AppMethodBeat.o(33959);
    }

    public final int getViewTypeCount() {
        return 1;
    }

    public final void setPerformItemClickListener(MMSlideDelView.g gVar) {
        this.pkY = gVar;
    }

    public final void a(MMSlideDelView.f fVar) {
        this.pla = fVar;
    }

    public final void setGetViewPositionCallback(MMSlideDelView.c cVar) {
        this.pkZ = cVar;
    }

    public final int getItemViewType(int i2) {
        return 0;
    }

    public final void onPause() {
        AppMethodBeat.i(33960);
        if (this.plb != null) {
            this.plb.ebo();
        }
        AppMethodBeat.o(33960);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(33961);
        com.tencent.mm.al.a.c cVar = (com.tencent.mm.al.a.c) getItem(i2);
        if (view == null) {
            a aVar2 = new a();
            view = View.inflate(this.gte, R.layout.a41, null);
            aVar2.gvv = (ImageView) view.findViewById(R.id.x1);
            aVar2.gvw = (TextView) view.findViewById(R.id.fti);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        q.bcV().a(cVar.field_headImageUrl, aVar.gvv, this.gzE);
        aVar.gvw.setText(l.e((Context) this.gte, (CharSequence) cVar.field_chatName, (int) aVar.gvw.getTextSize()));
        AppMethodBeat.o(33961);
        return view;
    }

    @Override // com.tencent.mm.ui.s
    public final void anq() {
        AppMethodBeat.i(33962);
        anp();
        AppMethodBeat.o(33962);
    }

    @Override // com.tencent.mm.ui.s, com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(33963);
        super.onNotifyChange(i2, mStorageEx, obj);
        AppMethodBeat.o(33963);
    }
}
