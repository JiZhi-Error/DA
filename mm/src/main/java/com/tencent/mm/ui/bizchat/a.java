package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.ui.contact.a.a;
import java.util.HashMap;
import java.util.Map;

public final class a extends com.tencent.mm.ui.contact.a.a {
    private static Map<String, c> Pam = new HashMap();
    private b Pan = new b();
    C2084a Pao = new C2084a();
    public String hXq;
    public CharSequence jVL;
    public long ppv = -1;
    public String username;

    static {
        AppMethodBeat.i(102808);
        AppMethodBeat.o(102808);
    }

    public a(int i2) {
        super(4, i2);
        AppMethodBeat.i(102805);
        AppMethodBeat.o(102805);
    }

    public class b extends a.b {
        public b() {
            super();
        }

        @Override // com.tencent.mm.ui.contact.a.a.b
        public final View a(Context context, ViewGroup viewGroup) {
            View inflate;
            AppMethodBeat.i(102803);
            if (com.tencent.mm.cb.a.jk(context)) {
                inflate = LayoutInflater.from(context).inflate(R.layout.bq0, viewGroup, false);
            } else {
                inflate = LayoutInflater.from(context).inflate(R.layout.bpz, viewGroup, false);
            }
            C2084a aVar = a.this.Pao;
            aVar.gvv = (ImageView) inflate.findViewById(R.id.x1);
            aVar.gvw = (TextView) inflate.findViewById(R.id.ir3);
            aVar.jBR = (TextView) inflate.findViewById(R.id.bn6);
            aVar.jBR.setVisibility(8);
            inflate.setTag(aVar);
            AppMethodBeat.o(102803);
            return inflate;
        }

        @Override // com.tencent.mm.ui.contact.a.a.b
        public final void a(Context context, a.C2110a aVar, com.tencent.mm.ui.contact.a.a aVar2, boolean z, boolean z2) {
            AppMethodBeat.i(102804);
            a aVar3 = (a) aVar2;
            C2084a aVar4 = (C2084a) aVar;
            n.a(aVar3.jVL, aVar4.gvw);
            q.bcV().a(aVar3.hXq, aVar4.gvv, a.bmo(aVar3.username));
            AppMethodBeat.o(102804);
        }

        @Override // com.tencent.mm.ui.contact.a.a.b
        public final boolean a(Context context, View view, com.tencent.mm.ui.contact.a.a aVar) {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.bizchat.a$a  reason: collision with other inner class name */
    public class C2084a extends a.C2110a {
        public ImageView gvv;
        public TextView gvw;
        public TextView jBR;

        public C2084a() {
            super();
        }
    }

    @Override // com.tencent.mm.ui.contact.a.a
    public final void a(Context context, a.C2110a aVar) {
        AppMethodBeat.i(102806);
        this.jVL = l.e(context, this.jVL, com.tencent.mm.cb.a.aG(context, R.dimen.is));
        AppMethodBeat.o(102806);
    }

    @Override // com.tencent.mm.ui.contact.a.a
    public final a.b bmx() {
        return this.Pan;
    }

    static /* synthetic */ c bmo(String str) {
        AppMethodBeat.i(102807);
        if (str == null) {
            AppMethodBeat.o(102807);
            return null;
        } else if (!Pam.containsKey(str) || Pam.get(str) == null) {
            c.a aVar = new c.a();
            aVar.prefixPath = com.tencent.mm.api.a.fe(str);
            aVar.jbf = true;
            aVar.hZF = true;
            aVar.jbq = R.raw.default_avatar;
            c bdv = aVar.bdv();
            Pam.put(str, bdv);
            AppMethodBeat.o(102807);
            return bdv;
        } else {
            c cVar = Pam.get(str);
            AppMethodBeat.o(102807);
            return cVar;
        }
    }
}
