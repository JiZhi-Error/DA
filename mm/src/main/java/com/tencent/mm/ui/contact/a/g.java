package com.tencent.mm.ui.contact.a;

import android.content.Context;
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
import com.tencent.mm.plugin.fts.ui.b;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.ui.contact.a.a;

public final class g extends a {
    private a.b QaC = new b();
    a.C2110a QaD = new a();
    private CharSequence xdb;

    public g(int i2) {
        super(5, i2);
        AppMethodBeat.i(102956);
        AppMethodBeat.o(102956);
    }

    public class b extends a.b {
        public b() {
            super();
        }

        @Override // com.tencent.mm.ui.contact.a.a.b
        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(102954);
            View inflate = LayoutInflater.from(context).inflate(R.layout.bq1, viewGroup, false);
            a aVar = (a) g.this.QaD;
            aVar.jBR = (TextView) inflate.findViewById(R.id.bn6);
            aVar.lrc = inflate.findViewById(R.id.dob);
            inflate.setTag(aVar);
            AppMethodBeat.o(102954);
            return inflate;
        }

        @Override // com.tencent.mm.ui.contact.a.a.b
        public final void a(Context context, a.C2110a aVar, a aVar2, boolean z, boolean z2) {
            AppMethodBeat.i(102955);
            a aVar3 = (a) aVar;
            n.a(((g) aVar2).xdb, aVar3.jBR);
            if (g.this.position == 0) {
                aVar3.lrc.setVisibility(8);
                AppMethodBeat.o(102955);
                return;
            }
            aVar3.lrc.setVisibility(0);
            AppMethodBeat.o(102955);
        }

        @Override // com.tencent.mm.ui.contact.a.a.b
        public final boolean a(Context context, View view, a aVar) {
            return false;
        }
    }

    public class a extends a.C2110a {
        public TextView jBR;
        public View lrc;

        public a() {
            super();
        }
    }

    @Override // com.tencent.mm.ui.contact.a.a
    public final void a(Context context, a.C2110a aVar) {
        AppMethodBeat.i(102957);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String[] strArr = this.wWd.wWD;
        for (String str : strArr) {
            SpannableString spannableString = new SpannableString(str);
            spannableString.setSpan(new ForegroundColorSpan(b.C1383b.wZQ), 0, str.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            spannableStringBuilder.append((CharSequence) "、");
        }
        this.xdb = TextUtils.concat(context.getString(R.string.ghl), spannableStringBuilder.subSequence(0, spannableStringBuilder.length() - 1), context.getString(R.string.ghl));
        AppMethodBeat.o(102957);
    }

    @Override // com.tencent.mm.ui.contact.a.a
    public final a.b bmx() {
        return this.QaC;
    }
}
