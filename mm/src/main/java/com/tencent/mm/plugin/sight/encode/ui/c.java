package com.tencent.mm.plugin.sight.encode.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.e;
import com.tencent.mm.ui.contact.n;
import com.tencent.mm.ui.contact.q;
import java.util.ArrayList;
import java.util.List;

public final class c extends q {
    public static boolean DpH = true;
    public static boolean DpI = false;
    List<String> DpF;
    boolean DpG;

    public c(n nVar) {
        super(nVar, new ArrayList(), true, true);
        AppMethodBeat.i(28735);
        this.DpG = true;
        this.DpG = true;
        this.DpF = null;
        AppMethodBeat.o(28735);
    }

    public final int getCount() {
        AppMethodBeat.i(28736);
        if (this.DpF == null) {
            AppMethodBeat.o(28736);
            return 0;
        }
        int size = this.DpF.size();
        AppMethodBeat.o(28736);
        return size;
    }

    public final void cv(List<String> list) {
        AppMethodBeat.i(28737);
        clearCache();
        this.DpF = list;
        notifyDataSetChanged();
        AppMethodBeat.o(28737);
    }

    @Override // com.tencent.mm.ui.contact.p
    public final com.tencent.mm.ui.contact.a.a va(int i2) {
        as Kn;
        AppMethodBeat.i(28738);
        if (this.DpF == null) {
            AppMethodBeat.o(28738);
            return null;
        } else if (i2 < 0 || i2 >= getCount()) {
            Log.e("MicroMsg.MainSightSelectContactAdapter", "create Data Item Error position=%d", Integer.valueOf(i2));
            AppMethodBeat.o(28738);
            return null;
        } else {
            a aVar = new a(i2);
            String str = this.DpF.get(i2);
            if (aNz(str)) {
                Kn = new as("@sns.tencent");
            } else if (aNA(str)) {
                Kn = new as("@search.tencent");
            } else if (aNB(str)) {
                Kn = new as("@draft.tencent");
            } else {
                bg.aVF();
                Kn = com.tencent.mm.model.c.aSN().Kn(this.DpF.get(i2));
            }
            aVar.contact = Kn;
            aVar.PWh = this.DpG;
            AppMethodBeat.o(28738);
            return aVar;
        }
    }

    public class a extends e {
        public a(int i2) {
            super(i2);
        }

        @Override // com.tencent.mm.ui.contact.a.e, com.tencent.mm.ui.contact.a.a
        public final a.b bmx() {
            AppMethodBeat.i(28733);
            b bVar = new b();
            AppMethodBeat.o(28733);
            return bVar;
        }

        /* renamed from: com.tencent.mm.plugin.sight.encode.ui.c$a$a  reason: collision with other inner class name */
        public class C1699a extends e.a {
            public View Bnt;
            public View DpK;

            public C1699a() {
                super();
            }
        }

        @Override // com.tencent.mm.ui.contact.a.e
        public final a.C2110a eOf() {
            AppMethodBeat.i(28734);
            C1699a aVar = new C1699a();
            AppMethodBeat.o(28734);
            return aVar;
        }

        public class b extends e.b {
            public b() {
                super();
            }

            @Override // com.tencent.mm.ui.contact.a.a.b, com.tencent.mm.ui.contact.a.e.b
            public final View a(Context context, ViewGroup viewGroup) {
                AppMethodBeat.i(28731);
                View inflate = LayoutInflater.from(context).inflate(R.layout.bt1, viewGroup, false);
                C1699a aVar = (C1699a) a.this.eOf();
                aVar.gvv = (ImageView) inflate.findViewById(R.id.x1);
                aVar.jVO = (TextView) inflate.findViewById(R.id.ir3);
                aVar.jBR = (TextView) inflate.findViewById(R.id.bn6);
                aVar.contentView = inflate.findViewById(R.id.hi1);
                aVar.jVQ = (CheckBox) inflate.findViewById(R.id.hhc);
                aVar.Bnt = inflate.findViewById(R.id.e3r);
                aVar.DpK = inflate.findViewById(R.id.hf7);
                inflate.setTag(aVar);
                aVar.jVO.setTextColor(-1);
                AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) inflate.getLayoutParams();
                layoutParams.width = -1;
                inflate.setLayoutParams(layoutParams);
                inflate.setBackgroundResource(R.color.fm);
                AppMethodBeat.o(28731);
                return inflate;
            }

            @Override // com.tencent.mm.ui.contact.a.a.b, com.tencent.mm.ui.contact.a.e.b
            public final void a(Context context, a.C2110a aVar, com.tencent.mm.ui.contact.a.a aVar2, boolean z, boolean z2) {
                AppMethodBeat.i(28732);
                as asVar = aVar2.contact;
                C1699a aVar3 = (C1699a) aVar;
                aVar3.contentView.setVisibility(0);
                aVar3.DpK.setVisibility(8);
                aVar3.Bnt.setVisibility(8);
                if (c.aNB(asVar.field_username)) {
                    aVar3.gvv.setImageResource(R.raw.sight_icon_draft_item);
                    aVar3.jVO.setText(R.string.h26);
                    aVar3.jBR.setText(R.string.h24);
                    aVar3.jBR.setVisibility(0);
                    aVar3.jVQ.setEnabled(false);
                    if (c.DpI) {
                        aVar3.contentView.setBackgroundResource(R.drawable.bnk);
                        aVar3.jVQ.setVisibility(0);
                        aVar3.jVQ.setBackgroundResource(R.raw.sight_list_checkbox_selected);
                        aVar3.Bnt.setVisibility(0);
                    } else {
                        aVar3.contentView.setBackgroundResource(R.drawable.att);
                        aVar3.jVQ.setVisibility(8);
                        aVar3.jVQ.setBackgroundResource(R.raw.sight_list_checkbox_unselected);
                        aVar3.Bnt.setVisibility(8);
                    }
                    c.e(context, aVar3.contentView);
                    ViewGroup.LayoutParams layoutParams = aVar3.gvv.getLayoutParams();
                    layoutParams.width = com.tencent.mm.cb.a.aG(context, R.dimen.aiy);
                    layoutParams.height = com.tencent.mm.cb.a.aG(context, R.dimen.aiy);
                    aVar3.gvv.setLayoutParams(layoutParams);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) aVar3.jVQ.getLayoutParams();
                    layoutParams2.height = com.tencent.mm.cb.a.aG(context, R.dimen.aj4);
                    layoutParams2.width = com.tencent.mm.cb.a.aG(context, R.dimen.aj4);
                    layoutParams2.setMargins(layoutParams2.leftMargin, layoutParams2.topMargin, 0, layoutParams2.bottomMargin);
                    aVar3.jVQ.setLayoutParams(layoutParams2);
                    AppMethodBeat.o(28732);
                    return;
                }
                if (c.aNz(asVar.field_username)) {
                    aVar3.gvv.setImageResource(R.raw.sight_item_sns_icon);
                    aVar3.jVQ.setVisibility(8);
                    aVar3.jVO.setText(context.getString(R.string.h2f));
                    aVar3.jBR.setVisibility(8);
                    if (c.DpH) {
                        aVar3.contentView.setBackgroundResource(R.drawable.att);
                        aVar3.Bnt.setVisibility(8);
                    } else {
                        aVar3.contentView.setBackgroundResource(R.drawable.bnk);
                        aVar3.Bnt.setVisibility(0);
                    }
                    c.e(context, aVar3.contentView);
                } else if (c.aNA(asVar.field_username)) {
                    aVar3.contentView.setVisibility(8);
                    aVar3.DpK.setVisibility(0);
                    AppMethodBeat.o(28732);
                    return;
                } else {
                    super.a(context, aVar, aVar2, z, z2);
                    aVar3.contentView.setBackgroundResource(R.drawable.att);
                    c.e(context, aVar3.contentView);
                }
                ViewGroup.LayoutParams layoutParams3 = aVar3.gvv.getLayoutParams();
                layoutParams3.width = com.tencent.mm.cb.a.aG(context, R.dimen.aiy);
                layoutParams3.height = com.tencent.mm.cb.a.aG(context, R.dimen.aiy);
                aVar3.gvv.setLayoutParams(layoutParams3);
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) aVar3.jVQ.getLayoutParams();
                layoutParams4.height = com.tencent.mm.cb.a.aG(context, R.dimen.aj4);
                layoutParams4.width = com.tencent.mm.cb.a.aG(context, R.dimen.aj4);
                layoutParams4.setMargins(layoutParams4.leftMargin, layoutParams4.topMargin, 0, layoutParams4.bottomMargin);
                aVar3.jVQ.setLayoutParams(layoutParams4);
                aVar3.jVQ.setBackgroundResource(R.drawable.atp);
                AppMethodBeat.o(28732);
            }
        }
    }

    public static boolean aNz(String str) {
        AppMethodBeat.i(28739);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(28739);
            return false;
        }
        boolean endsWith = str.endsWith("@sns.tencent");
        AppMethodBeat.o(28739);
        return endsWith;
    }

    public static boolean aNA(String str) {
        AppMethodBeat.i(28740);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(28740);
            return false;
        }
        boolean endsWith = str.endsWith("@search.tencent");
        AppMethodBeat.o(28740);
        return endsWith;
    }

    public static boolean aNB(String str) {
        AppMethodBeat.i(28741);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(28741);
            return false;
        }
        boolean endsWith = str.endsWith("@draft.tencent");
        AppMethodBeat.o(28741);
        return endsWith;
    }

    @Override // com.tencent.mm.ui.contact.p
    public final boolean eWh() {
        return this.DpG;
    }

    static /* synthetic */ void e(Context context, View view) {
        AppMethodBeat.i(28742);
        if (view == null || context == null) {
            AppMethodBeat.o(28742);
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.height = com.tencent.mm.cb.a.aG(context, R.dimen.aj6);
        layoutParams.rightMargin = 0;
        layoutParams.leftMargin = 0;
        view.setLayoutParams(layoutParams);
        view.setPadding(com.tencent.mm.cb.a.fromDPToPix(context, 10), view.getPaddingTop(), com.tencent.mm.cb.a.fromDPToPix(context, 10), view.getPaddingTop());
        AppMethodBeat.o(28742);
    }
}
