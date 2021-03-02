package com.tencent.mm.plugin.qmessage.ui;

import android.content.Context;
import android.database.Cursor;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.s;

/* access modifiers changed from: package-private */
public final class c extends s<az> implements MStorageEx.IOnStorageChange {
    private final MMActivity gte;
    protected MMSlideDelView.g pkY;
    protected MMSlideDelView.c pkZ;
    protected MMSlideDelView.f pla;
    protected MMSlideDelView.d plb = MMSlideDelView.getItemStatusCallBack();

    public static class a {
        public ImageView gvv;
        public TextView gvw;
        public ImageView ooE;
        public TextView pld;
        public TextView ple;
        public TextView plf;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
    @Override // com.tencent.mm.ui.s
    public final /* synthetic */ az a(az azVar, Cursor cursor) {
        AppMethodBeat.i(27765);
        az azVar2 = azVar;
        if (azVar2 == null) {
            azVar2 = new az();
        }
        azVar2.Cm("");
        azVar2.Cn("");
        azVar2.convertFrom(cursor);
        AppMethodBeat.o(27765);
        return azVar2;
    }

    public c(Context context, s.a aVar) {
        super(context, new az());
        AppMethodBeat.i(27759);
        super.a(aVar);
        this.gte = (MMActivity) context;
        AppMethodBeat.o(27759);
    }

    @Override // com.tencent.mm.ui.s
    public final void anp() {
        AppMethodBeat.i(27760);
        bg.aVF();
        setCursor(com.tencent.mm.model.c.aST().bkh(ab.iCI));
        if (this.OFI != null) {
            this.OFI.bnE();
        }
        super.notifyDataSetChanged();
        AppMethodBeat.o(27760);
    }

    public final int getViewTypeCount() {
        return 1;
    }

    public final int getItemViewType(int i2) {
        return 0;
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

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0173  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View getView(int r13, android.view.View r14, android.view.ViewGroup r15) {
        /*
        // Method dump skipped, instructions count: 426
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.qmessage.ui.c.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    private static int ahn(String str) {
        int i2 = 1;
        AppMethodBeat.i(27762);
        if (str != null && str.length() > 0) {
            try {
                i2 = Integer.valueOf(str).intValue();
            } catch (NumberFormatException e2) {
            }
        }
        AppMethodBeat.o(27762);
        return i2;
    }

    public final void onPause() {
        AppMethodBeat.i(27763);
        if (this.plb != null) {
            this.plb.ebo();
        }
        AppMethodBeat.o(27763);
    }

    @Override // com.tencent.mm.ui.s
    public final void anq() {
        AppMethodBeat.i(27764);
        anp();
        AppMethodBeat.o(27764);
    }
}
