package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.contact.a.a;
import java.util.regex.Pattern;

public final class c extends com.tencent.mm.ui.contact.a.a {
    private static final Pattern jVK = Pattern.compile(",");
    public CharSequence hXr;
    public CharSequence jVL;
    private b jVM = new b();
    a jVN = new a();
    public String username;

    static {
        AppMethodBeat.i(63528);
        AppMethodBeat.o(63528);
    }

    public c(int i2) {
        super(2, i2);
        AppMethodBeat.i(63526);
        AppMethodBeat.o(63526);
    }

    public class b extends a.b {
        public b() {
            super();
        }

        @Override // com.tencent.mm.ui.contact.a.a.b
        public final View a(Context context, ViewGroup viewGroup) {
            View inflate;
            AppMethodBeat.i(63524);
            if (com.tencent.mm.cb.a.jk(context)) {
                inflate = LayoutInflater.from(context).inflate(R.layout.bq0, viewGroup, false);
            } else {
                inflate = LayoutInflater.from(context).inflate(R.layout.bpz, viewGroup, false);
            }
            a aVar = c.this.jVN;
            aVar.gvv = (ImageView) inflate.findViewById(R.id.x1);
            aVar.jVO = (TextView) inflate.findViewById(R.id.ir3);
            aVar.jBR = (TextView) inflate.findViewById(R.id.bn6);
            aVar.contentView = inflate.findViewById(R.id.hi1);
            aVar.jVQ = (CheckBox) inflate.findViewById(R.id.hhc);
            aVar.jVP = (TextView) inflate.findViewById(R.id.ior);
            inflate.setTag(aVar);
            AppMethodBeat.o(63524);
            return inflate;
        }

        @Override // com.tencent.mm.ui.contact.a.a.b
        public final void a(Context context, a.C2110a aVar, com.tencent.mm.ui.contact.a.a aVar2, boolean z, boolean z2) {
            AppMethodBeat.i(63525);
            a aVar3 = (a) aVar;
            c cVar = (c) aVar2;
            if (cVar.username == null || cVar.username.length() <= 0) {
                aVar3.gvv.setImageResource(R.drawable.bca);
            } else {
                a.b.a(aVar3.gvv, cVar.username, 0.1f, false);
            }
            if (!Util.isNullOrNil(cVar.jVL)) {
                aVar3.jVO.setText(cVar.jVL);
                aVar3.jVO.setVisibility(0);
            } else {
                aVar3.jVO.setVisibility(8);
            }
            if (!Util.isNullOrNil(cVar.hXr)) {
                aVar3.jBR.setText(cVar.hXr);
                aVar3.jBR.setVisibility(0);
            } else {
                aVar3.jBR.setVisibility(8);
            }
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
            } else {
                aVar3.jVQ.setVisibility(8);
            }
            if (c.this.poB) {
                aVar3.contentView.setBackgroundResource(R.drawable.qd);
            } else {
                aVar3.contentView.setBackgroundResource(R.drawable.v);
            }
            if (cVar.contact.field_deleteFlag == 1) {
                aVar3.jBR.setVisibility(0);
                aVar3.jBR.setText(context.getString(R.string.f3152i));
            }
            if (as.bjp(cVar.username)) {
                aVar3.jVO.setAlpha(0.3f);
                aVar3.jBR.setAlpha(0.3f);
                aVar3.jVQ.setChecked(false);
                aVar3.jVQ.setEnabled(false);
                aVar3.jVQ.setOnClickListener(null);
                aVar3.jVQ.setOnTouchListener(null);
                aVar3.gvv.setAlpha(0.3f);
                String O = com.tencent.mm.openim.room.a.a.O(((l) g.af(l.class)).aSN().Kn(cVar.username));
                aVar3.jVP.setVisibility(0);
                aVar3.jVP.setText(O);
                aVar3.jVP.setTextSize(12.0f);
                aVar3.jVP.setTextColor(context.getResources().getColor(R.color.a3b));
                aVar3.jVP.setAlpha(0.3f);
                Log.i("MicroMsg.ContactDataItem", "data.username：%s,subName:%s", cVar.username, O);
                AppMethodBeat.o(63525);
                return;
            }
            aVar3.jVO.setAlpha(1.0f);
            aVar3.jBR.setAlpha(1.0f);
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
            } else {
                aVar3.jVQ.setVisibility(8);
            }
            aVar3.gvv.setAlpha(1.0f);
            aVar3.jVP.setVisibility(4);
            Log.i("MicroMsg.ContactDataItem", "data.username：%s", cVar.username);
            AppMethodBeat.o(63525);
        }

        @Override // com.tencent.mm.ui.contact.a.a.b
        public final boolean a(Context context, View view, com.tencent.mm.ui.contact.a.a aVar) {
            return false;
        }
    }

    public class a extends a.C2110a {
        public View contentView;
        public ImageView gvv;
        public TextView jBR;
        public TextView jVO;
        public TextView jVP;
        public CheckBox jVQ;

        public a() {
            super();
        }
    }

    @Override // com.tencent.mm.ui.contact.a.a
    public final a.b bmx() {
        return this.jVM;
    }

    @Override // com.tencent.mm.ui.contact.a.a
    public final void a(Context context, a.C2110a aVar) {
        String displayName;
        AppMethodBeat.i(63527);
        if (this.contact == null) {
            Log.i("MicroMsg.ContactDataItem", "filling dataItem Occur Error Contact is null, position=%d", Integer.valueOf(this.position));
            AppMethodBeat.o(63527);
            return;
        }
        this.username = this.contact.field_username;
        if (Util.isNullOrNil(this.dFl)) {
            displayName = ((com.tencent.mm.plugin.messenger.a.b) g.af(com.tencent.mm.plugin.messenger.a.b.class)).b(this.contact);
        } else {
            displayName = ((com.tencent.mm.plugin.messenger.a.b) g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(this.contact.field_username, this.dFl);
        }
        if (z.aTY().equals(this.username)) {
            displayName = displayName + context.getString(R.string.ao);
        }
        this.jVL = com.tencent.mm.pluginsdk.ui.span.l.e(context, (CharSequence) displayName, com.tencent.mm.cb.a.aG(context, R.dimen.is));
        AppMethodBeat.o(63527);
    }
}
