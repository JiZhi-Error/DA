package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.b;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.sdk.platformtools.Util;

public final class i extends com.tencent.mm.plugin.fts.a.d.a.a {
    public String wWS;
    public boolean xdf;
    public CharSequence xdg;
    private b xdh = new b();
    private a xdi = new a();

    public i(int i2) {
        super(12, i2);
        AppMethodBeat.i(112082);
        this.wXK = false;
        AppMethodBeat.o(112082);
    }

    public class b extends a.b {
        public b() {
            super();
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(112079);
            View inflate = LayoutInflater.from(context).inflate(R.layout.an7, viewGroup, false);
            a aVar = new a();
            aVar.xcs = (TextView) inflate.findViewById(R.id.ior);
            aVar.nnL = (ImageView) inflate.findViewById(R.id.dtx);
            aVar.xcK = inflate.findViewById(R.id.g8b);
            aVar.contentView = inflate.findViewById(R.id.hee);
            inflate.setTag(aVar);
            AppMethodBeat.o(112079);
            return inflate;
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final void a(Context context, a.AbstractC1374a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
            AppMethodBeat.i(112080);
            a aVar3 = (a) aVar;
            n.r(aVar3.contentView, i.this.wXK);
            aVar3.xcs.setText(((i) aVar2).xdg);
            aVar3.nnL.setImageResource(R.raw.fts_more_button_icon);
            if (i.this.position == 0 || !i.this.xdf) {
                aVar3.xcK.setVisibility(8);
                AppMethodBeat.o(112080);
                return;
            }
            aVar3.xcK.setVisibility(0);
            AppMethodBeat.o(112080);
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final boolean a(Context context, View view, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
            AppMethodBeat.i(235400);
            Intent intent = new Intent();
            intent.putExtra("key_talker_query", i.this.wWd.wWE[0]);
            intent.putExtra("key_query", i.this.wWd.wWE[1]);
            intent.putExtra("Search_Scene", i.this.mve);
            if (!Util.isNullOrNil(i.this.wWS)) {
                intent.putExtra("key_conv", i.this.wWS);
                intent.putExtra("detail_type", 1);
                d.d(context, ".ui.FTSConvTalkerMessageUI", intent);
            } else {
                d.d(context, ".ui.FTSTalkerMessageUI", intent);
            }
            AppMethodBeat.o(235400);
            return true;
        }
    }

    public class a extends a.AbstractC1374a {
        public View contentView;
        public ImageView nnL;
        public View xcK;
        public TextView xcs;

        public a() {
            super();
        }
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public final void a(Context context, a.AbstractC1374a aVar, Object... objArr) {
        AppMethodBeat.i(112083);
        CharSequence ellipsize = TextUtils.ellipsize(this.wWd.wWE[0], b.c.wZY, 200.0f, TextUtils.TruncateAt.MIDDLE);
        CharSequence ellipsize2 = TextUtils.ellipsize(this.wWd.wWE[1], b.c.wZY, 400.0f, TextUtils.TruncateAt.MIDDLE);
        if (Util.isNullOrNil(this.wWS)) {
            String string = context.getString(R.string.gh4);
            String string2 = context.getString(R.string.gh5);
            String string3 = context.getString(R.string.gh6);
            int length = string.length();
            int length2 = string.length() + ellipsize.length() + string2.length();
            this.xdg = f.f(f.f(string + ((Object) ellipsize) + string2 + ((Object) ellipsize2) + string3, length, ellipsize.length() + length), length2, ellipsize2.length() + length2);
            AppMethodBeat.o(112083);
            return;
        }
        String string4 = context.getString(R.string.gh7);
        String string5 = context.getString(R.string.gh5);
        String string6 = context.getString(R.string.gh6);
        int length3 = string4.length();
        int length4 = string4.length() + ellipsize.length() + string5.length();
        this.xdg = f.f(f.f(string4 + ((Object) ellipsize) + string5 + ((Object) ellipsize2) + string6, length3, ellipsize.length() + length3), length4, ellipsize2.length() + length4);
        AppMethodBeat.o(112083);
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public final a.b axc() {
        return this.xdh;
    }
}
