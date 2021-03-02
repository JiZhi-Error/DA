package com.tencent.mm.plugin.game.ui.message;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
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

public final class d extends RecyclerView {
    private int gwE;
    private Context mContext;
    private f<String, Bitmap> xUC;
    a xYn;
    private f xYo;
    private c xYp;
    private Set<Integer> xYq = new HashSet();

    public d(Context context, int i2) {
        super(context);
        AppMethodBeat.i(183887);
        this.mContext = context;
        this.gwE = i2;
        this.xUC = new com.tencent.mm.memory.a.b(30, getClass());
        this.xYo = new f(this.gwE, new f.b() {
            /* class com.tencent.mm.plugin.game.ui.message.d.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.game.ui.message.f.b
            public final void dWI() {
                AppMethodBeat.i(183882);
                d.a(d.this);
                AppMethodBeat.o(183882);
            }
        });
        this.xYn = new a(context, ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().On(1), ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().Op(1));
        setLayoutManager(new LinearLayoutManager());
        setAdapter(this.xYn);
        AppMethodBeat.o(183887);
    }

    public final void setEmptyCallback(c cVar) {
        this.xYp = cVar;
    }

    /* access modifiers changed from: package-private */
    public class a extends g<b> {
        int dCm;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, android.database.Cursor] */
        @Override // com.tencent.mm.plugin.game.ui.message.g
        public final /* synthetic */ void a(b bVar, Cursor cursor) {
            boolean z;
            SpannableString spannableString;
            AppMethodBeat.i(183884);
            b bVar2 = bVar;
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
            bVar2.xYs.setTag(new f.a(oVar, oVar.xFj.get(oVar.xFQ.xGy), 4));
            d.a(d.this, bVar2.gBZ, oVar.xFQ.xGB);
            bVar2.gBZ.setTag(new f.a(oVar, oVar.xFj.get(oVar.xFQ.xGD), 2));
            bVar2.pIN.setText(l.b(d.this.mContext, oVar.xFQ.xGC, bVar2.pIN.getTextSize()));
            bVar2.pIN.setTag(new f.a(oVar, oVar.xFj.get(oVar.xFQ.xGD), 1));
            if (oVar.field_hasMergedCount > 1) {
                bVar2.xYt.setVisibility(0);
                bVar2.xYt.setText(d.this.mContext.getString(R.string.drd, Integer.valueOf(oVar.field_hasMergedCount)));
            } else {
                bVar2.xYt.setVisibility(8);
            }
            if (!Util.isNullOrNil(oVar.xFQ.xGK)) {
                d.b(d.this, bVar2.xYv, oVar.xFQ.xGK);
                bVar2.xYv.setVisibility(0);
            } else {
                bVar2.xYv.setVisibility(8);
            }
            if (bVar2.xYv.getVisibility() == 8) {
                if (!Util.isNullOrNil(oVar.xFQ.xGL)) {
                    bVar2.xYu.setVisibility(0);
                    bVar2.xYu.setText(l.b(d.this.mContext, oVar.xFQ.xGL, bVar2.xYu.getTextSize()));
                } else {
                    bVar2.xYu.setVisibility(8);
                }
            }
            String str = oVar.xFQ.xGJ;
            int indexOf = str.indexOf("<em class=\"prefix\">");
            int indexOf2 = str.indexOf("</em>") - "<em class=\"prefix\">".length();
            if (indexOf < indexOf2) {
                spannableString = new SpannableString(str.replaceAll("<em class=\"prefix\">", "").replaceAll("</em>", ""));
                spannableString.setSpan(new ForegroundColorSpan(d.this.mContext.getResources().getColor(R.color.BW_0_Alpha_0_3)), indexOf, indexOf2, 33);
            } else {
                spannableString = new SpannableString(str);
            }
            bVar2.xYw.setText(l.b(d.this.mContext, spannableString, bVar2.xYw.getTextSize()));
            bVar2.timeTv.setText(com.tencent.mm.plugin.game.e.b.n(d.this.mContext, oVar.field_createTime * 1000));
            oVar.xFQ.xGM = "";
            if (!Util.isNullOrNil(oVar.xFQ.xGM)) {
                bVar2.xYx.setVisibility(0);
                bVar2.xYx.setText(oVar.xFQ.xGM);
            } else {
                bVar2.xYx.setVisibility(8);
            }
            switch (z) {
                case true:
                    bVar2.xYy.setVisibility(0);
                    bVar2.xYz.setVisibility(8);
                    bVar2.xYA.setVisibility(8);
                    break;
                case true:
                    bVar2.xYy.setVisibility(8);
                    bVar2.xYz.setVisibility(0);
                    bVar2.xYA.setVisibility(8);
                    break;
                case true:
                    bVar2.xYy.setVisibility(8);
                    bVar2.xYz.setVisibility(8);
                    bVar2.xYA.setVisibility(0);
                    break;
            }
            if (!d.this.xYq.contains(Integer.valueOf(position))) {
                HashMap hashMap = new HashMap();
                hashMap.put("tab", "1");
                hashMap.put("isnew", position < this.dCm ? "1" : "2");
                hashMap.put("fold", String.valueOf(oVar.field_hasMergedCount));
                hashMap.put("ext_data", oVar.xFX);
                com.tencent.mm.game.report.f.a(d.this.getContext(), 13, 1300, position + 1, 1, 0, oVar.field_appId, d.this.gwE, oVar.xFV, oVar.field_gameMsgId, oVar.xFW, com.tencent.mm.game.report.f.t(hashMap));
                d.this.xYq.add(Integer.valueOf(position));
            }
            AppMethodBeat.o(183884);
        }

        public a(Context context, Cursor cursor, int i2) {
            super(context, cursor);
            this.dCm = i2;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final /* synthetic */ RecyclerView.v a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(183885);
            b bVar = new b(LayoutInflater.from(d.this.mContext).inflate(R.layout.aqz, viewGroup, false));
            AppMethodBeat.o(183885);
            return bVar;
        }
    }

    class b extends RecyclerView.v {
        ImageView gBZ;
        TextView pIN;
        TextView timeTv;
        View xYA;
        ViewGroup xYs;
        TextView xYt;
        TextView xYu;
        ImageView xYv;
        TextView xYw;
        TextView xYx;
        View xYy;
        View xYz;

        public b(View view) {
            super(view);
            AppMethodBeat.i(183886);
            this.xYs = (ViewGroup) view.findViewById(R.id.fm8);
            this.gBZ = (ImageView) view.findViewById(R.id.dtx);
            this.pIN = (TextView) view.findViewById(R.id.fzg);
            this.xYt = (TextView) view.findViewById(R.id.fl5);
            this.xYu = (TextView) view.findViewById(R.id.h7o);
            this.xYv = (ImageView) view.findViewById(R.id.h7b);
            this.xYw = (TextView) view.findViewById(R.id.bfe);
            this.timeTv = (TextView) view.findViewById(R.id.in3);
            this.xYx = (TextView) view.findViewById(R.id.i34);
            this.xYy = view.findViewById(R.id.dhp);
            this.xYz = view.findViewById(R.id.fx_);
            this.xYA = view.findViewById(R.id.ep5);
            this.xYs.setOnLongClickListener(d.this.xYo);
            this.xYs.setOnClickListener(d.this.xYo);
            this.gBZ.setOnLongClickListener(d.this.xYo);
            this.gBZ.setOnClickListener(d.this.xYo);
            this.pIN.setOnLongClickListener(d.this.xYo);
            this.pIN.setOnClickListener(d.this.xYo);
            AppMethodBeat.o(183886);
        }
    }

    private void b(ImageView imageView, final String str, float f2) {
        AppMethodBeat.i(183888);
        e.a.C1397a aVar = new e.a.C1397a();
        aVar.jbd = false;
        aVar.xZw = f2;
        e.dWR().a(imageView, str, aVar.dWS(), new e.b() {
            /* class com.tencent.mm.plugin.game.ui.message.d.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.game.e.e.b
            public final void a(View view, Bitmap bitmap) {
                AppMethodBeat.i(183883);
                if (bitmap != null && !bitmap.isRecycled()) {
                    d.this.xUC.put(str, bitmap);
                }
                AppMethodBeat.o(183883);
            }
        });
        AppMethodBeat.o(183888);
    }

    static /* synthetic */ void a(d dVar) {
        AppMethodBeat.i(204319);
        if (dVar.xYn != null) {
            dVar.xYn.dCm = ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().Op(1);
            Cursor On = ((com.tencent.mm.plugin.game.api.f) g.af(com.tencent.mm.plugin.game.api.f.class)).dSK().On(1);
            dVar.xYn.changeCursor(On);
            if ((On == null || On.getCount() == 0) && dVar.xYp != null) {
                dVar.xYp.dWH();
            }
        }
        AppMethodBeat.o(204319);
    }

    static /* synthetic */ void a(d dVar, ImageView imageView, String str) {
        AppMethodBeat.i(204320);
        if (dVar.xUC.check(str)) {
            Bitmap bitmap = dVar.xUC.get(str);
            if (bitmap == null || bitmap.isRecycled()) {
                dVar.b(imageView, str, 0.083333336f);
                AppMethodBeat.o(204320);
                return;
            }
            imageView.setImageBitmap(bitmap);
            AppMethodBeat.o(204320);
            return;
        }
        dVar.b(imageView, str, 0.083333336f);
        AppMethodBeat.o(204320);
    }

    static /* synthetic */ void b(d dVar, ImageView imageView, String str) {
        AppMethodBeat.i(184809);
        if (dVar.xUC.check(str)) {
            Bitmap bitmap = dVar.xUC.get(str);
            if (bitmap == null || bitmap.isRecycled()) {
                dVar.b(imageView, str, 0.0f);
                AppMethodBeat.o(184809);
                return;
            }
            imageView.setImageBitmap(bitmap);
            AppMethodBeat.o(184809);
            return;
        }
        dVar.b(imageView, str, 0.0f);
        AppMethodBeat.o(184809);
    }
}
