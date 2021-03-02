package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.viewitems.c;

public final class ax {

    public static class a extends c {
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (i2 == 35) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(37360);
            if (view == null || view.getTag() == null) {
                view = layoutInflater.inflate(R.layout.s1, (ViewGroup) null);
                b bVar = new b();
                bVar.timeTV = (TextView) view.findViewById(R.id.ayf);
                bVar.userTV = (TextView) view.findViewById(R.id.ayn);
                bVar.PKi = (ImageView) view.findViewById(R.id.ax2);
                bVar.POl = (TextView) view.findViewById(R.id.ayh);
                bVar.PNK = (TextView) view.findViewById(R.id.auk);
                bVar.clickArea = view.findViewById(R.id.auf);
                view.setTag(bVar);
            }
            AppMethodBeat.o(37360);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            AppMethodBeat.i(37361);
            this.PhN = aVar2;
            b bVar = (b) aVar;
            bg.aVF();
            ca.c aEI = com.tencent.mm.model.c.aSQ().aEI(caVar.field_content);
            bVar.POl.setText(aEI.title);
            bVar.PNK.setText(aEI.content);
            a(bVar, aEI.jje);
            bVar.PKi.setVisibility(aEI.tmn ? 0 : 8);
            bVar.clickArea.setTag(new bq(caVar, aVar2.gRM(), i2, (String) null, (char) 0));
            bVar.clickArea.setOnClickListener(d(aVar2));
            bVar.clickArea.setOnLongClickListener(c(aVar2));
            bVar.clickArea.setOnTouchListener(((k) aVar2.bh(k.class)).gOC());
            AppMethodBeat.o(37361);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTU() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            AppMethodBeat.i(233919);
            int i2 = ((bq) view.getTag()).position;
            if (!this.PhN.gRN()) {
                mVar.a(i2, 100, view.getContext().getString(R.string.b06), R.raw.icons_filled_delete);
            }
            AppMethodBeat.o(233919);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37363);
            bq bqVar = (bq) view.getTag();
            bg.aVF();
            ca.c aEI = com.tencent.mm.model.c.aSQ().aEI(bqVar.dTX.field_content);
            if (Util.nullAsNil(aEI.BqZ).length() > 0) {
                com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "qqmail", ".ui.ReadMailUI", new Intent().putExtra("msgid", bqVar.dTX.field_msgId));
            } else if (Util.nullAsNil(aEI.OqW).length() > 0) {
                com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", new Intent("android.intent.action.VIEW", Uri.parse(aEI.OqW)));
            }
            AppMethodBeat.o(37363);
            return true;
        }
    }

    static class b extends c.a {
        ImageView PKi;
        TextView PNK;
        TextView POl;

        b() {
        }
    }
}
