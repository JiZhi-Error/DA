package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.ui.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.websearch.api.am;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.protocal.protobuf.aer;
import com.tencent.mm.protocal.protobuf.dso;
import com.tencent.mm.protocal.protobuf.rv;
import com.tencent.mm.protocal.protobuf.sb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.sortview.a;
import java.io.IOException;
import java.util.List;

public final class a extends com.tencent.mm.plugin.brandservice.ui.base.a {
    private static b pnJ;
    protected String iconUrl;
    protected CharSequence nickName;
    protected CharSequence pnK;
    protected CharSequence pnL;
    protected CharSequence pnM;
    protected boolean pnN;
    protected boolean pnO;
    protected String username;

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.a$a  reason: collision with other inner class name */
    public static class C0868a extends d.a implements a.AbstractC2082a {
        public TextView gwR;
        public TextView pnP;
        public View pnQ;
        public TextView pnR;
        public TextView pnS;
        public TextView pnT;
        View pnU;
    }

    public a(Object obj) {
        super(5, obj);
    }

    @Override // com.tencent.mm.ui.base.sortview.a
    public final a.b clS() {
        AppMethodBeat.i(5603);
        if (pnJ == null) {
            pnJ = new b();
        }
        b bVar = pnJ;
        AppMethodBeat.o(5603);
        return bVar;
    }

    @Override // com.tencent.mm.ui.base.sortview.a
    public final a.AbstractC2082a clT() {
        AppMethodBeat.i(5604);
        C0868a aVar = new C0868a();
        AppMethodBeat.o(5604);
        return aVar;
    }

    @Override // com.tencent.mm.ui.base.sortview.a
    public final void a(Context context, a.AbstractC2082a aVar, Object... objArr) {
        String str;
        c cVar;
        boolean z;
        c.b.e eVar = null;
        AppMethodBeat.i(5605);
        if (this.OZN) {
            AppMethodBeat.o(5605);
        } else if (context == null || aVar == null || this.data == null) {
            Log.e("MicroMsg.BizContactDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
            AppMethodBeat.o(5605);
        } else if (!(aVar instanceof C0868a)) {
            Log.e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BizContactViewHolder.");
            AppMethodBeat.o(5605);
        } else if (!(this.data instanceof sb)) {
            Log.e("MicroMsg.BizContactDataItem", "The ViewHolder is not a instance of BusinessResultItem.");
            AppMethodBeat.o(5605);
        } else {
            C0868a aVar2 = (C0868a) aVar;
            sb sbVar = (sb) this.data;
            if (sbVar.KZG == null || sbVar.KZG.KZe == null) {
                Log.e("MicroMsg.BizContactDataItem", "The brItem.ContactItem or brItem.ContactItem.ContactItem is null.");
                AppMethodBeat.o(5605);
                return;
            }
            dso dso = sbVar.KZG.KZe;
            rv rvVar = sbVar.KZG.KZb;
            if (objArr != null && objArr.length > 1 && (objArr[1] instanceof List)) {
                this.pqn = (List) objArr[1];
            }
            this.username = dso.Lqk.MTo;
            this.iconUrl = dso.Lis;
            this.pnL = rvVar == null ? "" : rvVar.KZl;
            if (dso.Mjj == null) {
                str = null;
            } else {
                str = dso.Mjj.MTo;
            }
            try {
                List list = this.pqn;
                aVar2.gwR.getTextSize();
                this.nickName = d.c(context, str, list);
            } catch (Exception e2) {
                this.nickName = "";
            }
            String str2 = dso.Lqk.MTo;
            aer aer = dso.MUR;
            if (aer != null) {
                cVar = new c();
                cVar.field_username = str2;
                d.a(cVar, aer);
            } else {
                cVar = null;
            }
            if (!(cVar == null || cVar.cG(false) == null)) {
                eVar = cVar.cG(false).Va();
            }
            if (eVar != null) {
                this.pnO = cVar.cG(false).Vc() && !Util.isNullOrNil(eVar.diq);
                if (dso.MmK != 0) {
                    z = true;
                } else {
                    z = false;
                }
                this.pnN = z;
            }
            Log.v("MicroMsg.BizContactDataItem", "verifyFlag : %d", Integer.valueOf(dso.MmK));
            String str3 = dso.ked;
            if (this.pqn.size() > 0 && str3 != null && str3.toLowerCase().equals(((String) this.pqn.get(0)).toLowerCase())) {
                try {
                    List list2 = this.pqn;
                    aVar2.pnT.getTextSize();
                    this.pnM = d.c(context, str3, list2);
                    this.pnM = TextUtils.concat(context.getResources().getString(R.string.gg9), this.pnM);
                } catch (Exception e3) {
                    this.pnM = "";
                }
            }
            if (this.pnM == null || this.pnM.length() == 0 || this.pnL == null || this.pnL.length() == 0) {
                try {
                    String str4 = dso.keb;
                    List list3 = this.pqn;
                    aVar2.pnR.getTextSize();
                    this.pnK = d.c(context, str4, list3);
                } catch (Exception e4) {
                    this.pnK = "";
                }
            }
            Log.d("MicroMsg.BizContactDataItem", "nickName : %s, followFriends : %s.", this.nickName, this.pnL);
            this.OZN = true;
            AppMethodBeat.o(5605);
        }
    }

    public static class b extends a.b {
        @Override // com.tencent.mm.ui.base.sortview.a.b
        public final boolean a(Context context, com.tencent.mm.ui.base.sortview.a aVar, Object... objArr) {
            int i2;
            String str;
            String str2;
            int i3;
            c cVar;
            AppMethodBeat.i(5599);
            if (!(aVar instanceof a)) {
                AppMethodBeat.o(5599);
                return false;
            }
            a aVar2 = (a) aVar;
            if (!(aVar.getData() instanceof sb)) {
                Log.e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BusinessResultItem.");
                AppMethodBeat.o(5599);
                return false;
            }
            sb sbVar = (sb) aVar.getData();
            if (sbVar.KZG == null || sbVar.KZG.KZe == null) {
                Log.e("MicroMsg.BizContactDataItem", "The brItem.ContactItem or brItem.ContactItem.ContactItem is null.");
                AppMethodBeat.o(5599);
                return false;
            }
            c cVar2 = null;
            String str3 = "";
            if (objArr != null) {
                if (objArr.length <= 0 || !(objArr[0] instanceof c)) {
                    cVar = null;
                } else {
                    cVar = (c) objArr[0];
                }
                if (objArr.length <= 2 || !(objArr[2] instanceof Integer)) {
                    i2 = 0;
                } else {
                    i2 = ((Integer) objArr[2]).intValue();
                }
                if (objArr.length <= 3 || !(objArr[3] instanceof String)) {
                    cVar2 = cVar;
                } else {
                    str3 = (String) objArr[3];
                    cVar2 = cVar;
                }
            } else {
                i2 = 0;
            }
            String str4 = sbVar.KZG.xIy;
            dso dso = sbVar.KZG.KZe;
            if (dso.Mjj != null) {
                str = dso.Mjj.MTo;
            } else {
                str = null;
            }
            if (dso.Lqk != null) {
                str2 = dso.Lqk.MTo;
            } else {
                str2 = null;
            }
            if (Util.isNullOrNil(str2)) {
                Log.e("MicroMsg.BizContactDataItem", "onItemClick but username is null");
                AppMethodBeat.o(5599);
                return false;
            }
            am.aXh(str2);
            if (!Util.isNullOrNil(str4)) {
                i3 = 8;
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str4);
                intent.putExtra("useJs", true);
                intent.putExtra("vertical_scroll", true);
                com.tencent.mm.br.c.b(context, "webview", ".ui.tools.WebViewUI", intent);
            } else {
                as Kn = ((l) g.af(l.class)).aSN().Kn(str2);
                Intent intent2 = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("Contact_Ext_Args_Search_Id", str3);
                bundle.putInt("Contact_Ext_Args_Index", aVar2.cmk());
                bundle.putString("Contact_Ext_Args_Query_String", "");
                bundle.putInt("Contact_Scene", i2);
                intent2.putExtra("Contact_Ext_Args", bundle);
                intent2.putExtra("Contact_User", str2);
                intent2.putExtra("Contact_Scene", i2);
                if (!com.tencent.mm.contact.c.oR(Kn.field_type)) {
                    intent2.putExtra("Contact_Alias", dso.ked);
                    intent2.putExtra("Contact_Nick", str);
                    intent2.putExtra("Contact_Signature", dso.keb);
                    intent2.putExtra("Contact_RegionCode", RegionCodeDecoder.bq(dso.keh, dso.kdZ, dso.kea));
                    intent2.putExtra("Contact_Sex", dso.kdY);
                    intent2.putExtra("Contact_VUser_Info", dso.MmL);
                    intent2.putExtra("Contact_VUser_Info_Flag", dso.MmK);
                    intent2.putExtra("Contact_KWeibo_flag", dso.MmO);
                    intent2.putExtra("Contact_KWeibo", dso.MmM);
                    intent2.putExtra("Contact_KWeiboNick", dso.MmN);
                    if (dso.MUR != null) {
                        try {
                            intent2.putExtra("Contact_customInfo", dso.MUR.toByteArray());
                        } catch (IOException e2) {
                            Log.printErrStackTrace("MicroMsg.BizContactDataItem", e2, "", new Object[0]);
                        }
                    }
                }
                com.tencent.mm.plugin.brandservice.b.jRt.c(intent2, context);
                i3 = 1;
            }
            c.b cmj = aVar2.cmj();
            if (!(cmj == null || cVar2 == null)) {
                cmj.a(cVar2, aVar, i3, str2, aVar2.cmk(), aVar2.getPosition());
            }
            AppMethodBeat.o(5599);
            return true;
        }

        @Override // com.tencent.mm.ui.base.sortview.a.b
        public final View c(Context context, View view) {
            AppMethodBeat.i(5600);
            if (view == null) {
                view = View.inflate(context, R.layout.bp2, null);
            }
            AppMethodBeat.o(5600);
            return view;
        }

        @Override // com.tencent.mm.ui.base.sortview.a.b
        public final void a(Context context, a.AbstractC2082a aVar, com.tencent.mm.ui.base.sortview.a aVar2) {
            int i2;
            int i3 = 8;
            AppMethodBeat.i(5601);
            if (context == null || aVar == null || aVar2 == null || aVar2.getData() == null) {
                Log.e("MicroMsg.BizContactDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
                AppMethodBeat.o(5601);
            } else if (!(aVar instanceof C0868a)) {
                Log.e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BizContactViewHolder.");
                AppMethodBeat.o(5601);
            } else if (!(aVar2 instanceof a)) {
                Log.e("MicroMsg.BizContactDataItem", "The ViewHolder is not a instance of BusinessResultItem.");
                AppMethodBeat.o(5601);
            } else {
                C0868a aVar3 = (C0868a) aVar;
                a aVar4 = (a) aVar2;
                aVar3.username = aVar4.username;
                aVar3.iconUrl = aVar4.iconUrl;
                a.b.d(aVar3.gvv, aVar4.username);
                View view = aVar3.pnQ;
                if (aVar4.pnN) {
                    i2 = 0;
                } else {
                    i2 = 8;
                }
                view.setVisibility(i2);
                View view2 = aVar3.pnU;
                if (aVar4.pnO) {
                    i3 = 0;
                }
                view2.setVisibility(i3);
                d.c(aVar3.gwR, aVar4.nickName);
                boolean c2 = d.c(aVar3.pnT, aVar4.pnM);
                boolean c3 = d.c(aVar3.pnS, aVar4.pnL);
                if (d.c(aVar3.pnR, aVar4.pnK)) {
                    if (c2 || c3) {
                        aVar3.pnR.setMaxLines(1);
                    } else {
                        aVar3.pnR.setMaxLines(2);
                    }
                }
                Log.d("MicroMsg.BizContactDataItem", "fillingView , nickName : %s, followFriends : %s.", aVar4.nickName, aVar4.pnL);
                AppMethodBeat.o(5601);
            }
        }

        @Override // com.tencent.mm.ui.base.sortview.a.b
        public final void a(View view, a.AbstractC2082a aVar) {
            AppMethodBeat.i(5602);
            if (!(view == null || aVar == null || !(aVar instanceof C0868a))) {
                C0868a aVar2 = (C0868a) aVar;
                aVar2.pnP = (TextView) view.findViewById(R.id.bdr);
                aVar2.pnU = view.findViewById(R.id.a53);
                aVar2.gvv = (ImageView) view.findViewById(R.id.wn);
                aVar2.gwR = (TextView) view.findViewById(R.id.fzd);
                aVar2.pnQ = view.findViewById(R.id.j2u);
                aVar2.pnS = (TextView) view.findViewById(R.id.d7w);
                aVar2.pnR = (TextView) view.findViewById(R.id.dzc);
                aVar2.pnT = (TextView) view.findViewById(R.id.jrr);
            }
            AppMethodBeat.o(5602);
        }
    }
}
