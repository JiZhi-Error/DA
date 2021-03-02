package com.tencent.mm.plugin.game.ui.message;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.e.e;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.ui.message.f;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public final class e extends RecyclerView {
    private int gwE;
    private Context mContext;
    private f<String, Bitmap> xUC;
    b xYB;
    private f xYo;
    private c xYp;
    private Set<Integer> xYq = new HashSet();

    public e(Context context, int i2) {
        super(context);
        AppMethodBeat.i(183896);
        this.mContext = context;
        this.gwE = i2;
        this.xUC = new com.tencent.mm.memory.a.b(30, getClass());
        this.xYo = new f(this.gwE, new f.b() {
            /* class com.tencent.mm.plugin.game.ui.message.e.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.game.ui.message.f.b
            public final void dWI() {
                AppMethodBeat.i(183891);
                e.a(e.this);
                AppMethodBeat.o(183891);
            }
        });
        this.xYB = new b(context, ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().On(2), ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().Op(2));
        setLayoutManager(new LinearLayoutManager());
        setAdapter(this.xYB);
        AppMethodBeat.o(183896);
    }

    public final void setEmptyCallback(c cVar) {
        this.xYp = cVar;
    }

    /* access modifiers changed from: package-private */
    public class b extends g<a> {
        int dCm;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, android.database.Cursor] */
        @Override // com.tencent.mm.plugin.game.ui.message.g
        public final /* synthetic */ void a(a aVar, Cursor cursor) {
            boolean z;
            AppMethodBeat.i(183894);
            a aVar2 = aVar;
            o oVar = new o();
            oVar.convertFrom(cursor);
            int position = cursor.getPosition();
            if (position + 1 == getItemCount()) {
                z = true;
            } else if (position + 1 == this.dCm) {
                z = true;
            } else {
                z = true;
            }
            oVar.dVl();
            aVar2.xYs.setTag(new f.a(oVar, oVar.xFj.get(oVar.xFQ.xGy), 4));
            e.a(e.this, aVar2.gBZ, oVar.xFQ.xGB);
            aVar2.gBZ.setTag(new f.a(oVar, oVar.xFj.get(oVar.xFQ.xGD), 2));
            aVar2.pIN.setText(l.b(e.this.mContext, oVar.xFQ.xGC, aVar2.pIN.getTextSize()));
            aVar2.pIN.setTag(new f.a(oVar, oVar.xFj.get(oVar.xFQ.xGD), 1));
            if (!Util.isNullOrNil(oVar.xFQ.xGE)) {
                aVar2.xYE.setVisibility(0);
                e.b(e.this, aVar2.xYE, oVar.xFQ.xGE);
            } else {
                aVar2.xYE.setVisibility(8);
            }
            if (!Util.isNullOrNil(oVar.xFQ.xGF)) {
                aVar2.titleTv.setVisibility(0);
                aVar2.titleTv.setText(l.b(e.this.mContext, oVar.xFQ.xGF, aVar2.titleTv.getTextSize()));
            } else {
                aVar2.titleTv.setVisibility(8);
            }
            if (!Util.isNullOrNil(oVar.xFQ.xGG)) {
                aVar2.hPW.setVisibility(0);
                aVar2.hPW.setText(l.b(e.this.mContext, oVar.xFQ.xGG, aVar2.hPW.getTextSize()));
            } else {
                aVar2.hPW.setVisibility(8);
            }
            aVar2.timeTv.setText(com.tencent.mm.plugin.game.e.b.n(e.this.mContext, oVar.field_createTime * 1000));
            switch (z) {
                case true:
                    aVar2.xYy.setVisibility(0);
                    aVar2.xYz.setVisibility(8);
                    aVar2.xYA.setVisibility(8);
                    break;
                case true:
                    aVar2.xYy.setVisibility(8);
                    aVar2.xYz.setVisibility(0);
                    aVar2.xYA.setVisibility(8);
                    break;
                case true:
                    aVar2.xYy.setVisibility(8);
                    aVar2.xYz.setVisibility(8);
                    aVar2.xYA.setVisibility(0);
                    break;
            }
            if (!e.this.xYq.contains(Integer.valueOf(position))) {
                HashMap hashMap = new HashMap();
                hashMap.put("tab", "2");
                hashMap.put("isnew", position < this.dCm ? "1" : "2");
                hashMap.put("fold", String.valueOf(oVar.field_hasMergedCount));
                hashMap.put("ext_data", oVar.xFX);
                com.tencent.mm.game.report.f.a(e.this.getContext(), 13, 1300, position + 1, 1, 0, oVar.field_appId, e.this.gwE, oVar.xFV, oVar.field_gameMsgId, oVar.xFW, com.tencent.mm.game.report.f.t(hashMap));
                e.this.xYq.add(Integer.valueOf(position));
            }
            AppMethodBeat.o(183894);
        }

        public b(Context context, Cursor cursor, int i2) {
            super(context, cursor);
            this.dCm = i2;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ RecyclerView.v a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(183895);
            a aVar = new a(LayoutInflater.from(e.this.mContext).inflate(R.layout.as5, viewGroup, false));
            AppMethodBeat.o(183895);
            return aVar;
        }
    }

    class a extends RecyclerView.v {
        ImageView gBZ;
        TextView hPW;
        TextView pIN;
        TextView timeTv;
        TextView titleTv;
        View xYA;
        private ViewGroup xYD;
        ImageView xYE;
        ViewGroup xYs;
        View xYy;
        View xYz;

        public a(View view) {
            super(view);
            AppMethodBeat.i(183893);
            this.xYs = (ViewGroup) view.findViewById(R.id.fm8);
            this.gBZ = (ImageView) view.findViewById(R.id.dtx);
            this.pIN = (TextView) view.findViewById(R.id.fzg);
            this.xYD = (ViewGroup) view.findViewById(R.id.fm9);
            this.xYE = (ImageView) view.findViewById(R.id.aok);
            this.titleTv = (TextView) view.findViewById(R.id.apl);
            this.hPW = (TextView) view.findViewById(R.id.alt);
            this.timeTv = (TextView) view.findViewById(R.id.in3);
            this.xYy = view.findViewById(R.id.dhp);
            this.xYz = view.findViewById(R.id.fx_);
            this.xYA = view.findViewById(R.id.ep5);
            this.xYs.setOnLongClickListener(e.this.xYo);
            this.xYs.setOnClickListener(e.this.xYo);
            this.gBZ.setOnLongClickListener(e.this.xYo);
            this.gBZ.setOnClickListener(e.this.xYo);
            this.pIN.setOnLongClickListener(e.this.xYo);
            this.pIN.setOnClickListener(e.this.xYo);
            AppMethodBeat.o(183893);
        }
    }

    private void b(ImageView imageView, final String str, float f2) {
        AppMethodBeat.i(183897);
        e.a.C1397a aVar = new e.a.C1397a();
        aVar.jbd = false;
        aVar.xZw = f2;
        com.tencent.mm.plugin.game.e.e.dWR().a(imageView, str, aVar.dWS(), new e.b() {
            /* class com.tencent.mm.plugin.game.ui.message.e.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.game.e.e.b
            public final void a(View view, Bitmap bitmap) {
                AppMethodBeat.i(183892);
                if (bitmap != null && !bitmap.isRecycled()) {
                    e.this.xUC.put(str, bitmap);
                }
                AppMethodBeat.o(183892);
            }
        });
        AppMethodBeat.o(183897);
    }

    static /* synthetic */ void a(e eVar) {
        AppMethodBeat.i(204321);
        if (eVar.xYB != null) {
            eVar.xYB.dCm = ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().Op(2);
            Cursor On = ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().On(2);
            eVar.xYB.changeCursor(On);
            if ((On == null || On.getCount() == 0) && eVar.xYp != null) {
                eVar.xYp.dWH();
            }
        }
        AppMethodBeat.o(204321);
    }

    static /* synthetic */ void a(e eVar, ImageView imageView, String str) {
        AppMethodBeat.i(204322);
        if (eVar.xUC.check(str)) {
            Bitmap bitmap = eVar.xUC.get(str);
            if (bitmap == null || bitmap.isRecycled()) {
                eVar.b(imageView, str, 0.083333336f);
                AppMethodBeat.o(204322);
                return;
            }
            imageView.setImageBitmap(bitmap);
            AppMethodBeat.o(204322);
            return;
        }
        eVar.b(imageView, str, 0.083333336f);
        AppMethodBeat.o(204322);
    }

    static /* synthetic */ void b(e eVar, ImageView imageView, String str) {
        AppMethodBeat.i(184811);
        if (eVar.xUC.check(str)) {
            Bitmap bitmap = eVar.xUC.get(str);
            if (bitmap == null || bitmap.isRecycled()) {
                eVar.b(imageView, str, 0.0f);
                AppMethodBeat.o(184811);
                return;
            }
            imageView.setImageBitmap(bitmap);
            AppMethodBeat.o(184811);
            return;
        }
        eVar.b(imageView, str, 0.0f);
        AppMethodBeat.o(184811);
    }
}
