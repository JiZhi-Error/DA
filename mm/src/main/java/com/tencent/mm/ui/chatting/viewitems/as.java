package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.HardDeviceChattingItemView;
import com.tencent.mm.ui.chatting.viewitems.c;

public final class as extends c {
    private com.tencent.mm.ui.chatting.e.a PhN;

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean gTT() {
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean bM(int i2, boolean z) {
        if (i2 == -1879048185) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final View a(LayoutInflater layoutInflater, View view) {
        AppMethodBeat.i(37304);
        if (view == null || view.getTag() == null) {
            view = new an(layoutInflater, R.layout.sc);
            view.setTag(new a().he(view));
        }
        AppMethodBeat.o(37304);
        return view;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
        boolean z;
        k.b bVar;
        AppMethodBeat.i(37305);
        this.PhN = aVar2;
        a aVar3 = (a) aVar;
        k GL = ao.gnf().GL(caVar.field_msgId);
        String str2 = caVar.field_content;
        if (GL == null || str2 == null) {
            Object[] objArr = new Object[4];
            if (GL == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            objArr[1] = str2;
            objArr[2] = Long.valueOf(caVar.field_msgId);
            objArr[3] = str;
            Log.e("MicroMsg.ChattingItemHardDeviceMsg", "amessage:%b, %s, %d, %s", objArr);
            bVar = null;
        } else {
            bVar = k.b.aD(str2, caVar.field_reserved);
        }
        bq bqVar = new bq(caVar, aVar2.gRM(), i2, (String) null, (char) 0);
        HardDeviceChattingItemView hardDeviceChattingItemView = (HardDeviceChattingItemView) aVar.clickArea;
        if (bVar != null && (bVar.dDG == 1 || bVar.ixF == 1)) {
            if (Util.isNullOrNil(bVar.ixA)) {
                String str3 = bVar.ixw;
                String str4 = bVar.ixx;
                if (Util.isNullOrNil(str3) || Util.isNullOrNil(str4)) {
                    Log.e("MicroMsg.HardDeviceChattingItemView", "color is null or highlight color is null, color = %s, highlight color = %s", str3, str4);
                    str3 = "#ffffff";
                    str4 = "#ffffff";
                }
                StateListDrawable stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(new int[]{16842919}, new ColorDrawable(Color.parseColor(str4)));
                stateListDrawable.addState(new int[]{16842908}, new ColorDrawable(Color.parseColor(str4)));
                stateListDrawable.addState(new int[]{16842766}, new ColorDrawable(Color.parseColor(str3)));
                stateListDrawable.addState(new int[0], new ColorDrawable(Color.parseColor(str3)));
                hardDeviceChattingItemView.setBackgroundDrawable(stateListDrawable);
                bVar.ixA = "#ffffff";
                String str5 = bVar.ixy;
                String str6 = bVar.ixz;
                int i3 = R.color.afz;
                int i4 = R.color.afz;
                if (!Util.isNullOrNil(str5) && !Util.isNullOrNil(str6)) {
                    try {
                        i3 = Color.parseColor(str5);
                        i4 = Color.parseColor(str6);
                    } catch (IllegalArgumentException e2) {
                        Log.w("MicroMsg.ChattingItemHardDeviceMsg", "hy: line color given color is incorrect. use default");
                    }
                }
                StateListDrawable stateListDrawable2 = new StateListDrawable();
                stateListDrawable2.addState(new int[]{16842919}, new ColorDrawable(i4));
                stateListDrawable2.addState(new int[]{16842908}, new ColorDrawable(i4));
                stateListDrawable2.addState(new int[]{16842766}, new ColorDrawable(i3));
                stateListDrawable2.addState(new int[0], new ColorDrawable(i3));
                aVar3.PNX.setBackgroundDrawable(stateListDrawable2);
            }
            String str7 = bVar.ixA;
            if (aVar3 != null) {
                int i5 = R.color.afz;
                if (!Util.isNullOrNil(str7)) {
                    try {
                        i5 = Color.parseColor(str7);
                    } catch (IllegalArgumentException e3) {
                        Log.w("MicroMsg.ChattingItemHardDeviceMsg", "hy: given color is incorrect.use default");
                    }
                }
                aVar3.PNU.setTextColor(i5);
                aVar3.PNV.setTextColor(i5);
                aVar3.PNS.setTextColor(i5);
                aVar3.PNT.setTextColor(i5);
                aVar3.PNW.setTextColor(i5);
            }
            aVar3.PNU.setText(bVar.ixs);
            aVar3.PNV.setText(bVar.ixq);
            aVar3.PNS.setText(bVar.ixu);
            aVar3.PNT.setText(bVar.ixt);
            aVar3.PNW.setText(bVar.ixv);
            if (!Util.isNullOrNil(bVar.ixB)) {
                aVar3.PNY.setVisibility(0);
                a.b.z(aVar3.PNY, bVar.ixB);
            } else {
                aVar3.PNY.setVisibility(8);
            }
        }
        aVar.clickArea.setOnLongClickListener(c(aVar2));
        aVar.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
        aVar.clickArea.setTag(bqVar);
        aVar.clickArea.setOnClickListener(d(aVar2));
        AppMethodBeat.o(37305);
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean a(m mVar, View view, ca caVar) {
        AppMethodBeat.i(233907);
        mVar.a(((bq) view.getTag()).position, 100, this.PhN.Pwc.getMMResources().getString(R.string.b06), R.raw.icons_filled_delete);
        AppMethodBeat.o(233907);
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
        AppMethodBeat.i(37307);
        menuItem.getItemId();
        AppMethodBeat.o(37307);
        return false;
    }

    final class a extends c.a {
        protected TextView PNS;
        protected TextView PNT;
        protected TextView PNU;
        protected TextView PNV;
        protected TextView PNW;
        protected TextView PNX;
        protected ImageView PNY;

        a() {
        }

        public final a he(View view) {
            AppMethodBeat.i(37303);
            super.create(view);
            this.PNS = (TextView) view.findViewById(R.id.i5u);
            this.PNU = (TextView) view.findViewById(R.id.grb);
            this.PNT = (TextView) view.findViewById(R.id.i5v);
            this.PNV = (TextView) view.findViewById(R.id.grc);
            this.PNW = (TextView) view.findViewById(R.id.j7n);
            this.PNX = (TextView) view.findViewById(R.id.dn5);
            this.checkBox = (CheckBox) view.findViewById(R.id.aue);
            this.PNY = (ImageView) view.findViewById(R.id.j7d);
            AppMethodBeat.o(37303);
            return this;
        }
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
        boolean z = false;
        AppMethodBeat.i(37308);
        String str = caVar.field_content;
        k.b aD = k.b.aD(str, caVar.field_reserved);
        if (aD == null) {
            Log.i("MicroMsg.ChattingItemHardDeviceMsg", "onItemClick, content is null.");
            AppMethodBeat.o(37308);
            return false;
        }
        Log.d("MicroMsg.ChattingItemHardDeviceMsg", "onItemClick, url is (%s).", aD.url);
        if (!Util.isNullOrNil(aD.url)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", aD.url);
            com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(37308);
            return true;
        }
        if (!Util.isNullOrNil(aD.ixr)) {
            if (System.currentTimeMillis() - (((long) aD.ixH) * 1000) >= 2592000000L) {
                z = true;
            }
            if (!z) {
                Intent intent2 = new Intent();
                intent2.putExtra("key_rank_info", str);
                intent2.putExtra("key_rank_semi", caVar.field_reserved);
                intent2.putExtra("key_rank_title", aD.ixC);
                intent2.putExtra("key_champion_info", aD.ixD);
                intent2.putExtra("key_champion_coverimg", aD.ixD);
                intent2.putExtra("rank_id", aD.ixr);
                intent2.putExtra("app_username", aD.appName);
                intent2.putExtra("device_type", aD.ixG);
                intent2.putExtra("key_champioin_username", aD.ixB);
                com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", intent2);
                com.tencent.mm.plugin.sport.a.c.pl(28);
                AppMethodBeat.o(37308);
                return true;
            }
        }
        com.tencent.mm.br.c.V(aVar.Pwc.getContext(), "exdevice", ".ui.ExdeviceExpireUI");
        AppMethodBeat.o(37308);
        return true;
    }
}
