package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.storage.as;

public abstract class b extends com.tencent.mm.plugin.fts.a.d.a.a {
    public as contact;
    public m lqW;
    public CharSequence pqB;
    public CharSequence pqC;
    public String username;
    public String xcu;
    a xcv = new a();

    /* renamed from: com.tencent.mm.plugin.fts.ui.a.b$b  reason: collision with other inner class name */
    public abstract class AbstractC1382b extends a.b {
        public AbstractC1382b() {
            super();
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.an2, viewGroup, false);
            a aVar = b.this.xcv;
            aVar.gvv = (ImageView) inflate.findViewById(R.id.x1);
            aVar.jVO = (TextView) inflate.findViewById(R.id.ir3);
            aVar.jBR = (TextView) inflate.findViewById(R.id.bn6);
            aVar.xcw = (TextView) inflate.findViewById(R.id.e2_);
            aVar.lrc = inflate.findViewById(R.id.brt);
            inflate.setTag(aVar);
            return inflate;
        }

        @Override // com.tencent.mm.plugin.fts.a.d.a.a.b
        public final void a(Context context, a.AbstractC1374a aVar, com.tencent.mm.plugin.fts.a.d.a.a aVar2, Object... objArr) {
            a aVar3 = (a) aVar;
            b bVar = (b) aVar2;
            n.q(aVar3.lrc, b.this.wXK);
            a.b.c(aVar3.gvv, bVar.username);
            n.a(bVar.pqB, aVar3.jVO);
            n.a(bVar.pqC, aVar3.jBR);
            n.b(bVar.xcu, aVar3.xcw);
        }
    }

    public class a extends a.AbstractC1374a {
        public ImageView gvv;
        public TextView jBR;
        public TextView jVO;
        public View lrc;
        TextView xcw;

        public a() {
            super();
        }
    }

    public b(int i2) {
        super(1, i2);
    }

    @Override // com.tencent.mm.plugin.fts.a.d.a.a
    public final int bCS() {
        return this.lqW.wXn;
    }
}
