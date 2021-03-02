package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.plugin.record.ui.h;
import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.HashMap;

public final class d extends h {
    private static HashMap<String, Boolean> BHu = new HashMap<>();
    public p BHv = new p() {
        /* class com.tencent.mm.plugin.record.ui.d.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.fav.a.p
        public final void e(final c cVar) {
            AppMethodBeat.i(27837);
            b bVar = (b) d.this.BHQ;
            if (cVar.field_favLocalId != bVar.qNT.field_localId) {
                Log.i("MicroMsg.FavRecordAdapter", "not equal Id %d %d", Long.valueOf(cVar.field_favLocalId), Long.valueOf(bVar.qNT.field_localId));
                AppMethodBeat.o(27837);
                return;
            }
            Log.d("MicroMsg.FavRecordAdapter", "on cdn status changed, fav local id %d, data id %s, status %d", Long.valueOf(cVar.field_favLocalId), cVar.field_dataId, Integer.valueOf(cVar.field_status));
            if (4 == cVar.field_status) {
                d.BHu.put(Util.nullAs(cVar.field_dataId, BuildConfig.COMMAND), Boolean.TRUE);
            }
            if (cVar.isFinished()) {
                d.this.wMu.post(new Runnable() {
                    /* class com.tencent.mm.plugin.record.ui.d.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(27836);
                        View view = com.tencent.mm.plugin.record.ui.b.c.BJe.get(cVar.field_dataId);
                        Object[] objArr = new Object[1];
                        objArr[0] = Boolean.valueOf(view == null);
                        Log.d("MicroMsg.FavRecordAdapter", "view is null %s", objArr);
                        if (view == null) {
                            AppMethodBeat.o(27836);
                            return;
                        }
                        b bVar = (b) view.getTag();
                        String a2 = h.a(bVar);
                        Log.d("MicroMsg.FavRecordAdapter", "dataItemId: %s", bVar.dKT.dLl);
                        if (bVar.dKT.dLl.equals(cVar.field_dataId)) {
                            Log.d("MicroMsg.FavRecordAdapter", "change the sight status %s, dataId %s, progress %s cdnInfo %s", Integer.valueOf(cVar.field_status), cVar.field_dataId, Float.valueOf(cVar.getProgress()), Boolean.valueOf(cVar.isFinished()));
                            a aVar = (a) view.findViewById(R.id.dup);
                            ((ImageView) view.findViewById(R.id.i59)).setVisibility(8);
                            ((MMPinProgressBtn) view.findViewById(R.id.gl7)).setVisibility(8);
                            Log.i("MicroMsg.FavRecordAdapter", "setVideoPath ".concat(String.valueOf(a2)));
                            aVar.setCanPlay(true);
                            aVar.e(a2, false, 0);
                        }
                        AppMethodBeat.o(27836);
                    }
                });
            }
            d.this.eIz();
            AppMethodBeat.o(27837);
        }
    };

    static {
        AppMethodBeat.i(27841);
        AppMethodBeat.o(27841);
    }

    public d(Context context, h.a aVar) {
        super(context, aVar);
        AppMethodBeat.i(27838);
        AppMethodBeat.o(27838);
    }

    @Override // com.tencent.mm.plugin.record.ui.h
    public final void a(a aVar) {
        AppMethodBeat.i(27839);
        Log.i("MicroMsg.FavRecordAdapter", "updateData localId %s,status %s", Long.valueOf(((b) aVar).qNT.field_localId), Integer.valueOf(((b) aVar).qNT.field_itemStatus));
        this.BHQ = aVar;
        this.BHs.clear();
        this.BHs.addAll(aVar.BHs);
        notifyDataSetChanged();
        AppMethodBeat.o(27839);
    }

    @Override // com.tencent.mm.plugin.record.ui.h
    public final void d(b bVar) {
        AppMethodBeat.i(27840);
        Log.d("MicroMsg.FavRecordAdapter", "setupRecord %s", Long.valueOf(((b) this.BHQ).qNT.field_localId));
        bVar.fromScene = 1;
        bVar.dataType = 1;
        bVar.BHS = 15;
        bVar.qNT = ((b) this.BHQ).qNT;
        AppMethodBeat.o(27840);
    }
}
