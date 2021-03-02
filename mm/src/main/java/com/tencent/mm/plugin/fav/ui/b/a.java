package com.tencent.mm.plugin.fav.ui.b;

import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMImageView;
import java.util.List;
import java.util.regex.Pattern;

public final class a extends com.tencent.mm.plugin.fts.a.d.a.a {
    private static final MMHandler handler = new MMHandler(Looper.getMainLooper());
    private static final String tjD = MMApplicationContext.getContext().getString(R.string.dk_);
    private static final Pattern tjE = Pattern.compile("['\r\n' | '\n']+");
    public String kog;
    public m lqW;
    public boolean tjF;
    public CharSequence tjG;
    public CharSequence tjH;
    public CharSequence tjI;
    public String tjJ;
    public int tjK;
    private b tjL = new b();
    C1047a tjM = new C1047a();

    static {
        AppMethodBeat.i(107310);
        AppMethodBeat.o(107310);
    }

    public class b extends a.b {
        public b() {
            super();
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final View a(Context context, ViewGroup viewGroup) {
            AppMethodBeat.i(107301);
            View inflate = LayoutInflater.from(context).inflate(R.layout.ana, viewGroup, false);
            C1047a aVar = a.this.tjM;
            aVar.tjN = (MMImageView) inflate.findViewById(R.id.x1);
            aVar.jVO = (TextView) inflate.findViewById(R.id.ir3);
            aVar.tjO = (TextView) inflate.findViewById(R.id.b4);
            aVar.tjP = (TextView) inflate.findViewById(R.id.i5l);
            aVar.jWr = inflate.findViewById(R.id.brt);
            inflate.setTag(aVar);
            AppMethodBeat.o(107301);
            return inflate;
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final void a(Context context, a.AbstractC1374a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
            AppMethodBeat.i(107302);
            C1047a aVar3 = (C1047a) aVar;
            a aVar4 = (a) aVar2;
            n.a(context, aVar3.tjN, aVar4.kog, aVar4.tjJ, aVar4.tjK, aVar3.tjN.getMeasuredWidth(), aVar3.tjN.getMeasuredHeight());
            a.a(aVar3.jVO, aVar3.tjO, a.this.tjG, a.this.tjH);
            n.a(a.this.tjI, aVar3.tjP);
            if (a.this.tjF) {
                aVar3.jWr.setVisibility(0);
                AppMethodBeat.o(107302);
                return;
            }
            aVar3.jWr.setVisibility(8);
            AppMethodBeat.o(107302);
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final boolean a(Context context, View view, com.tencent.mm.plugin.fts.a.d.a.a aVar) {
            AppMethodBeat.i(235340);
            hb hbVar = new hb();
            hbVar.dLm.type = 10;
            hbVar.dLm.dFW = ((a) aVar).lqW.wXe;
            hbVar.dLm.context = context;
            hbVar.dLm.dLx = new and();
            if (a.this.pageType == 1) {
                hbVar.dLm.dLx.scene = 3;
            } else {
                hbVar.dLm.dLx.scene = 4;
            }
            hbVar.dLm.dLx.pHw = 3;
            hbVar.dLm.dLx.index = a.this.wXM;
            EventCenter.instance.publish(hbVar);
            AppMethodBeat.o(235340);
            return true;
        }
    }

    public static void a(TextView textView, TextView textView2, CharSequence charSequence, CharSequence charSequence2) {
        AppMethodBeat.i(107304);
        if (!n.a(charSequence, textView)) {
            if (n.a(charSequence2, textView2)) {
                textView2.setMaxLines(2);
            }
            AppMethodBeat.o(107304);
        } else if (n.a(charSequence2, textView2)) {
            textView.setMaxLines(1);
            textView2.setMaxLines(1);
            AppMethodBeat.o(107304);
        } else {
            textView.setMaxLines(2);
            AppMethodBeat.o(107304);
        }
    }

    /* renamed from: com.tencent.mm.plugin.fav.ui.b.a$a  reason: collision with other inner class name */
    public class C1047a extends a.AbstractC1374a {
        public TextView jVO;
        public View jWr;
        public MMImageView tjN;
        public TextView tjO;
        public TextView tjP;

        public C1047a() {
            super();
        }
    }

    public a(int i2) {
        super(6, i2);
        AppMethodBeat.i(107305);
        AppMethodBeat.o(107305);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v54, types: [java.lang.CharSequence] */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x037a  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x03e7  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0286  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x02b5  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x02dc  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0300  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x030d  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0361  */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r13, com.tencent.mm.plugin.fts.a.d.a.a.AbstractC1374a r14, java.lang.Object... r15) {
        /*
        // Method dump skipped, instructions count: 1200
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fav.ui.b.a.a(android.content.Context, com.tencent.mm.plugin.fts.a.d.a.a$a, java.lang.Object[]):void");
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public final a.b axc() {
        return this.tjL;
    }

    private static String c(as asVar, boolean z) {
        String str;
        AppMethodBeat.i(107307);
        if (!z || Util.isNullOrNil(asVar.field_conRemark)) {
            str = asVar.field_nickname;
        } else {
            str = asVar.field_conRemark;
        }
        if (Util.isNullOrNil(str)) {
            str = asVar.field_username;
        }
        AppMethodBeat.o(107307);
        return str;
    }

    private String dL(List<String> list) {
        AppMethodBeat.i(107309);
        StringBuffer stringBuffer = new StringBuffer();
        String[] strArr = this.wWd.wWD;
        for (String str : strArr) {
            for (String str2 : list) {
                if (d.ayq(str2).contains(str)) {
                    stringBuffer.append(str2);
                    stringBuffer.append(",");
                }
            }
        }
        stringBuffer.trimToSize();
        if (stringBuffer.length() == 0) {
            AppMethodBeat.o(107309);
            return "";
        }
        String substring = stringBuffer.substring(0, stringBuffer.length() - 1);
        AppMethodBeat.o(107309);
        return substring;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public final int bCS() {
        return this.lqW.wXn;
    }

    private static String b(Context context, as asVar) {
        AppMethodBeat.i(107308);
        String str = asVar.field_conRemark;
        if (Util.isNullOrNil(str)) {
            str = asVar.field_nickname;
        }
        if (Util.isNullOrNil(str)) {
            str = context.getString(R.string.djg);
        }
        AppMethodBeat.o(107308);
        return str;
    }
}
