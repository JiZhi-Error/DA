package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.contact.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.ui.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.protocal.protobuf.dsn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.sortview.a;
import java.io.IOException;

public final class b extends com.tencent.mm.plugin.brandservice.ui.base.a {
    private static a.b pnV;
    protected String iconUrl;
    CharSequence jVL;
    protected CharSequence pnK;
    protected boolean pnN;
    protected boolean pnO;
    protected String pnW;
    protected String username;

    public static class a extends d.a implements a.AbstractC2082a {
        public TextView gvw;
        public TextView pnP;
        public View pnQ;
        public TextView pnR;
        public View pnU;
    }

    public b(Object obj, String str) {
        super(6, obj);
        this.pnW = str;
    }

    @Override // com.tencent.mm.ui.base.sortview.a
    public final a.b clS() {
        AppMethodBeat.i(5610);
        if (pnV == null) {
            pnV = new a.b() {
                /* class com.tencent.mm.plugin.brandservice.ui.b.AnonymousClass1 */

                @Override // com.tencent.mm.ui.base.sortview.a.b
                public final boolean a(Context context, com.tencent.mm.ui.base.sortview.a aVar, Object... objArr) {
                    String str;
                    String str2;
                    AppMethodBeat.i(5606);
                    if (!(aVar instanceof b)) {
                        AppMethodBeat.o(5606);
                        return false;
                    }
                    b bVar = (b) aVar;
                    dsn dsn = (dsn) aVar.getData();
                    if (dsn.Mjj != null) {
                        str = dsn.Mjj.MTo;
                    } else {
                        str = null;
                    }
                    if (dsn.Lqk != null) {
                        str2 = dsn.Lqk.MTo;
                    } else {
                        str2 = null;
                    }
                    if (Util.isNullOrNil(str2)) {
                        Log.e("MicroMsg.BizRecommDataItem", "onItemClick but username is null");
                        AppMethodBeat.o(5606);
                        return false;
                    }
                    as Kn = ((l) g.af(l.class)).aSN().Kn(str2);
                    Intent intent = new Intent();
                    if (c.oR(Kn.field_type)) {
                        intent.putExtra("Contact_User", str2);
                        intent.putExtra("Contact_Scene", 55);
                    } else {
                        intent.putExtra("Contact_User", str2);
                        intent.putExtra("Contact_Alias", dsn.ked);
                        intent.putExtra("Contact_Nick", str);
                        intent.putExtra("Contact_Signature", dsn.keb);
                        intent.putExtra("Contact_RegionCode", RegionCodeDecoder.bq(dsn.keh, dsn.kdZ, dsn.kea));
                        intent.putExtra("Contact_Sex", dsn.kdY);
                        intent.putExtra("Contact_VUser_Info", dsn.MmL);
                        intent.putExtra("Contact_VUser_Info_Flag", dsn.MmK);
                        intent.putExtra("Contact_KWeibo_flag", dsn.MmO);
                        intent.putExtra("Contact_KWeibo", dsn.MmM);
                        intent.putExtra("Contact_KWeiboNick", dsn.MmN);
                        intent.putExtra("Contact_Scene", 55);
                        if (dsn.MmR != null) {
                            try {
                                intent.putExtra("Contact_customInfo", dsn.MmR.toByteArray());
                            } catch (IOException e2) {
                                Log.printErrStackTrace("MicroMsg.BizRecommDataItem", e2, "", new Object[0]);
                            }
                        }
                    }
                    com.tencent.mm.plugin.brandservice.b.jRt.c(intent, context);
                    c cVar = null;
                    if (objArr != null && objArr.length > 0 && (objArr[0] instanceof c)) {
                        cVar = (c) objArr[0];
                    }
                    c.b cmj = bVar.cmj();
                    if (!(cmj == null || cVar == null)) {
                        cmj.a(cVar, aVar, 1, str2, bVar.cmk(), bVar.getPosition());
                    }
                    AppMethodBeat.o(5606);
                    return true;
                }

                @Override // com.tencent.mm.ui.base.sortview.a.b
                public final View c(Context context, View view) {
                    AppMethodBeat.i(5607);
                    if (view == null) {
                        view = View.inflate(context, R.layout.bp2, null);
                    }
                    AppMethodBeat.o(5607);
                    return view;
                }

                @Override // com.tencent.mm.ui.base.sortview.a.b
                public final void a(Context context, a.AbstractC2082a aVar, com.tencent.mm.ui.base.sortview.a aVar2) {
                    int i2 = 0;
                    AppMethodBeat.i(5608);
                    if (context == null || aVar == null || aVar2 == null || aVar2.getData() == null) {
                        Log.e("MicroMsg.BizRecommDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
                        AppMethodBeat.o(5608);
                    } else if (!(aVar instanceof a)) {
                        Log.e("MicroMsg.BizRecommDataItem", "The ViewHolder is not a instance of BizRecommViewHolder.");
                        AppMethodBeat.o(5608);
                    } else if (!(aVar2.getData() instanceof dsn)) {
                        Log.e("MicroMsg.BizRecommDataItem", "The ViewHolder is not a instance of SearchOrRecommendItem.");
                        AppMethodBeat.o(5608);
                    } else {
                        a aVar3 = (a) aVar;
                        b bVar = (b) aVar2;
                        aVar3.username = bVar.username;
                        aVar3.iconUrl = bVar.iconUrl;
                        a.b.d(aVar3.gvv, bVar.username);
                        aVar3.gvw.setText(bVar.jVL, TextView.BufferType.SPANNABLE);
                        aVar3.pnU.setVisibility(bVar.pnO ? 0 : 8);
                        View view = aVar3.pnQ;
                        if (!bVar.pnN) {
                            i2 = 8;
                        }
                        view.setVisibility(i2);
                        aVar3.pnR.setText(bVar.pnK, TextView.BufferType.SPANNABLE);
                        d.c(aVar3.pnP, bVar.pnW);
                        AppMethodBeat.o(5608);
                    }
                }

                @Override // com.tencent.mm.ui.base.sortview.a.b
                public final void a(View view, a.AbstractC2082a aVar) {
                    AppMethodBeat.i(5609);
                    if (!(view == null || aVar == null || !(aVar instanceof a))) {
                        a aVar2 = (a) aVar;
                        aVar2.gvv = (ImageView) view.findViewById(R.id.wn);
                        aVar2.gvw = (TextView) view.findViewById(R.id.fzd);
                        aVar2.pnP = (TextView) view.findViewById(R.id.bdr);
                        aVar2.pnU = view.findViewById(R.id.a53);
                        aVar2.pnQ = view.findViewById(R.id.j2u);
                        aVar2.pnR = (TextView) view.findViewById(R.id.dzc);
                    }
                    AppMethodBeat.o(5609);
                }
            };
        }
        a.b bVar = pnV;
        AppMethodBeat.o(5610);
        return bVar;
    }

    @Override // com.tencent.mm.ui.base.sortview.a
    public final a.AbstractC2082a clT() {
        AppMethodBeat.i(5611);
        a aVar = new a();
        AppMethodBeat.o(5611);
        return aVar;
    }

    @Override // com.tencent.mm.ui.base.sortview.a
    public final void a(Context context, a.AbstractC2082a aVar, Object... objArr) {
        AppMethodBeat.i(5612);
        if (this.OZN) {
            AppMethodBeat.o(5612);
        } else if (context == null || aVar == null || this.data == null) {
            Log.e("MicroMsg.BizRecommDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
            AppMethodBeat.o(5612);
        } else if (!(aVar instanceof a)) {
            Log.e("MicroMsg.BizRecommDataItem", "The DataItem is not a instance of BizProductViewHolder.");
            AppMethodBeat.o(5612);
        } else if (!(this.data instanceof dsn)) {
            Log.e("MicroMsg.BizRecommDataItem", "The data is not a instance of SearchOrRecommendItem.");
            AppMethodBeat.o(5612);
        } else {
            a aVar2 = (a) aVar;
            dsn dsn = (dsn) this.data;
            try {
                this.jVL = com.tencent.mm.pluginsdk.ui.span.l.b(context, dsn.Mjj != null ? dsn.Mjj.toString() : "", aVar2.gvw.getTextSize());
            } catch (Exception e2) {
                this.jVL = "";
            }
            this.iconUrl = dsn.Lis;
            this.username = dsn.Lqk.toString();
            AppMethodBeat.o(5612);
        }
    }
}
