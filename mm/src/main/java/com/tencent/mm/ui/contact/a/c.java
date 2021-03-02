package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.b;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.contact.a.a;
import java.util.regex.Pattern;

public final class c extends a {
    private static final Pattern ESG = Pattern.compile(";");
    public CharSequence ESH;
    private b Qag = new b();
    a Qah = new a();
    public CharSequence hXr;
    public CharSequence jVL;
    public m lqW;
    public String username;

    static {
        AppMethodBeat.i(102939);
        AppMethodBeat.o(102939);
    }

    public c(int i2) {
        super(3, i2);
        AppMethodBeat.i(102937);
        AppMethodBeat.o(102937);
    }

    public class b extends a.b {
        public b() {
            super();
        }

        @Override // com.tencent.mm.ui.contact.a.a.b
        public final View a(Context context, ViewGroup viewGroup) {
            View inflate;
            AppMethodBeat.i(102934);
            if (com.tencent.mm.cb.a.jk(context)) {
                inflate = LayoutInflater.from(context).inflate(R.layout.bq0, viewGroup, false);
            } else {
                inflate = LayoutInflater.from(context).inflate(R.layout.bpz, viewGroup, false);
            }
            a aVar = c.this.Qah;
            aVar.gvv = (ImageView) inflate.findViewById(R.id.x1);
            aVar.jVO = (TextView) inflate.findViewById(R.id.ir3);
            aVar.jVO.setMaxWidth(com.tencent.mm.cb.a.fromDPToPix(context, 200));
            aVar.jBR = (TextView) inflate.findViewById(R.id.bn6);
            aVar.xcs = (TextView) inflate.findViewById(R.id.ior);
            aVar.contentView = inflate.findViewById(R.id.hi1);
            aVar.jVQ = (CheckBox) inflate.findViewById(R.id.hhc);
            if (c.this.poB) {
                aVar.contentView.setBackgroundResource(R.drawable.qd);
            }
            inflate.setTag(aVar);
            AppMethodBeat.o(102934);
            return inflate;
        }

        @Override // com.tencent.mm.ui.contact.a.a.b
        public final void a(Context context, a.C2110a aVar, a aVar2, boolean z, boolean z2) {
            AppMethodBeat.i(102935);
            a aVar3 = (a) aVar;
            c cVar = (c) aVar2;
            if (cVar.username == null || cVar.username.length() <= 0) {
                aVar3.gvv.setImageResource(R.drawable.bca);
            } else {
                a.b.a(aVar3.gvv, cVar.username, 0.1f, false);
            }
            n.a(cVar.jVL, aVar3.jVO);
            if (ab.Iz(cVar.username)) {
                Drawable drawable = context.getResources().getDrawable(R.raw.open_im_main_logo);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                aVar3.jVO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            } else {
                aVar3.jVO.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            }
            n.a(cVar.hXr, aVar3.jBR);
            n.a(cVar.ESH, aVar3.xcs);
            if (c.this.PWh) {
                if (z) {
                    aVar3.jVQ.setChecked(true);
                    aVar3.jVQ.setEnabled(false);
                    aVar3.jVQ.setBackgroundResource(ao.isDarkMode() ? R.raw.checkbox_selected_grey_dark : R.raw.checkbox_selected_grey);
                } else {
                    aVar3.jVQ.setChecked(z2);
                    aVar3.jVQ.setEnabled(true);
                }
                aVar3.jVQ.setVisibility(0);
                AppMethodBeat.o(102935);
                return;
            }
            aVar3.jVQ.setVisibility(8);
            AppMethodBeat.o(102935);
        }

        @Override // com.tencent.mm.ui.contact.a.a.b
        public final boolean a(Context context, View view, a aVar) {
            AppMethodBeat.i(261608);
            if (c.this.lqW != null) {
                ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).updateTopHitsRank(c.this.query, c.this.lqW, 1);
            }
            AppMethodBeat.o(261608);
            return false;
        }
    }

    public class a extends a.C2110a {
        public View contentView;
        public ImageView gvv;
        public TextView jBR;
        public TextView jVO;
        public CheckBox jVQ;
        public TextView xcs;

        public a() {
            super();
        }
    }

    @Override // com.tencent.mm.ui.contact.a.a
    public final void a(Context context, a.C2110a aVar) {
        boolean z;
        boolean z2;
        boolean z3;
        String[] strArr;
        CharSequence charSequence = null;
        boolean z4 = true;
        boolean z5 = false;
        AppMethodBeat.i(102938);
        if (this.lqW != null) {
            if (this.contact == null) {
                g.aAi();
                this.contact = ((l) g.af(l.class)).aSN().bjF(this.lqW.wVX);
                if (this.contact == null) {
                    g.aAi();
                    this.contact = ((l) g.af(l.class)).aSN().bjK(this.lqW.wVX);
                    z = true;
                }
            }
            z = true;
        } else {
            z = false;
        }
        if (this.contact == null) {
            Log.i("MicroMsg.ChatroomDataItem", "filling dataItem Occur Error Contact is null, position=%d", Integer.valueOf(this.position));
            AppMethodBeat.o(102938);
            return;
        }
        this.username = this.contact.field_username;
        if (z) {
            m mVar = this.lqW;
            as asVar = this.contact;
            Resources resources = context.getResources();
            String b2 = ((com.tencent.mm.plugin.messenger.a.b) g.af(com.tencent.mm.plugin.messenger.a.b.class)).b(asVar, asVar.field_username);
            switch (mVar.wVW) {
                case 1:
                case 5:
                    z2 = false;
                    z3 = false;
                    resources.getString(R.string.gg4);
                    break;
                case 3:
                case 7:
                    z5 = true;
                case 2:
                case 6:
                    z2 = z5;
                    z3 = true;
                    resources.getString(R.string.gg4);
                    break;
                case 38:
                    g.aAi();
                    Cursor rawQuery = g.aAh().hqK.rawQuery("SELECT memberlist FROM chatroom WHERE chatroomname=?;", new String[]{asVar.field_username}, 2);
                    if (rawQuery.moveToFirst()) {
                        String string = rawQuery.getString(0);
                        rawQuery.close();
                        strArr = string == null ? null : ESG.split(string);
                    } else {
                        rawQuery.close();
                        strArr = null;
                    }
                    if (strArr != null && strArr.length > 0) {
                        this.ESH = "(" + strArr.length + ")";
                    }
                    if (!(strArr == null || mVar.wXl == null)) {
                        charSequence = TextUtils.concat(resources.getString(R.string.gg2), n.a(context, mVar.wXl, strArr, this.wWd, b.c.wZY));
                        z2 = false;
                        z3 = false;
                        z4 = false;
                        break;
                    }
                default:
                    z2 = false;
                    z3 = false;
                    z4 = false;
                    break;
            }
            if (z4) {
                this.jVL = com.tencent.mm.pluginsdk.ui.span.l.e(context, (CharSequence) b2, com.tencent.mm.cb.a.aG(context, R.dimen.hc));
                this.jVL = f.a(e.a(this.jVL, this.wWd, z3, z2)).wWu;
            } else {
                this.jVL = com.tencent.mm.pluginsdk.ui.span.l.e(context, (CharSequence) b2, com.tencent.mm.cb.a.aG(context, R.dimen.hc));
            }
            this.hXr = charSequence;
            AppMethodBeat.o(102938);
            return;
        }
        this.jVL = ((com.tencent.mm.plugin.messenger.a.b) g.af(com.tencent.mm.plugin.messenger.a.b.class)).b(this.contact, this.contact.field_username);
        if (this.lqW != null) {
            this.ESH = "(" + this.lqW.wXe + ")";
        }
        AppMethodBeat.o(102938);
    }

    @Override // com.tencent.mm.ui.contact.a.a
    public final a.b bmx() {
        return this.Qag;
    }

    @Override // com.tencent.mm.ui.contact.a.a
    public final boolean dOL() {
        return this.lqW.wXo;
    }
}
