package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.ui.b;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.sdk.platformtools.Util;

public final class h extends com.tencent.mm.plugin.fts.a.d.a.a {
    CharSequence xdb;
    private b xdc = new b(this, (byte) 0);
    a xdd = new a(this, (byte) 0);

    public h(int i2) {
        super(10, i2);
        AppMethodBeat.i(112077);
        AppMethodBeat.o(112077);
    }

    class b extends a.b {
        private b() {
            super();
        }

        /* synthetic */ b(h hVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(112074);
            View inflate = LayoutInflater.from(context).inflate(R.layout.an6, viewGroup, false);
            a aVar = h.this.xdd;
            aVar.jBR = (TextView) inflate.findViewById(R.id.bn6);
            inflate.setTag(aVar);
            AppMethodBeat.o(112074);
            return inflate;
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final void a(Context context, a.AbstractC1374a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
            AppMethodBeat.i(112075);
            n.a(h.this.xdb, ((a) aVar).jBR);
            AppMethodBeat.o(112075);
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final boolean a(Context context, View view, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
            AppMethodBeat.i(235399);
            Intent intent = new Intent();
            intent.putExtra("query_phrase_list", Util.stringsToList(h.this.wWd.wWD));
            intent.putExtra("go_to_chatroom_direct", true);
            intent.putExtra("scene_from", 3);
            c.f(context, ".ui.transmit.MMCreateChatroomUI", intent);
            AppMethodBeat.o(235399);
            return true;
        }
    }

    class a extends a.AbstractC1374a {
        TextView jBR;

        private a() {
            super();
        }

        /* synthetic */ a(h hVar, byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public final void a(Context context, a.AbstractC1374a aVar, Object... objArr) {
        AppMethodBeat.i(112078);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String[] strArr = this.wWd.wWD;
        for (String str : strArr) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(b.C1383b.wZQ), 0, str.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            spannableStringBuilder.append((CharSequence) "、");
        }
        this.xdb = TextUtils.concat(context.getString(R.string.gia), spannableStringBuilder.subSequence(0, spannableStringBuilder.length() - 1), context.getString(R.string.gi_));
        AppMethodBeat.o(112078);
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public final a.b axc() {
        return this.xdc;
    }
}
