package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.viewitems.c;

public final class at extends c {
    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean gTT() {
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean bM(int i2, boolean z) {
        if (i2 == -1879048183) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final View a(LayoutInflater layoutInflater, View view) {
        AppMethodBeat.i(37310);
        if (view == null || view.getTag() == null) {
            view = new an(layoutInflater, R.layout.sb);
            view.setTag(new a().hf(view));
        }
        AppMethodBeat.o(37310);
        return view;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
        boolean z;
        k.b bVar;
        AppMethodBeat.i(37311);
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
            Log.e("MicrMsg.ChattingItemHardDeviceMsgLike", "amessage:%b, %s, %d, %s", objArr);
            bVar = null;
        } else {
            bVar = k.b.aD(str2, caVar.field_reserved);
        }
        bq bqVar = new bq(caVar, aVar2.gRM(), i2, (String) null, (char) 0);
        if (bVar != null && (bVar.dDG == 2 || bVar.ixF == 2 || bVar.ixF == 4)) {
            a.b.z(aVar3.keC, bVar.ixJ);
            aVar3.POa.setTextSize(0, aVar2.Pwc.getMMResources().getDimension(R.dimen.is));
            aVar3.POa.setTextColor(aVar2.Pwc.getContext().getResources().getColor(R.color.a2x));
            aVar3.POa.setEllipsize(TextUtils.TruncateAt.END);
            aVar3.POa.setSingleLine(true);
            aVar3.POa.setShouldEllipsize(true);
            aVar3.POa.setText(l.c(aVar2.Pwc.getContext(), bVar.ixI));
        }
        aVar.clickArea.setOnLongClickListener(c(aVar2));
        aVar.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
        aVar.clickArea.setTag(bqVar);
        aVar.clickArea.setOnClickListener(d(aVar2));
        AppMethodBeat.o(37311);
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean a(m mVar, View view, ca caVar) {
        AppMethodBeat.i(233908);
        mVar.a(((bq) view.getTag()).position, 100, view.getContext().getString(R.string.b06), R.raw.icons_filled_delete);
        AppMethodBeat.o(233908);
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
        AppMethodBeat.i(37313);
        menuItem.getItemId();
        AppMethodBeat.o(37313);
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
        AppMethodBeat.i(37314);
        Log.i("MicrMsg.ChattingItemHardDeviceMsgLike", "hy: user clicked on the like item");
        if (caVar == null) {
            Log.i("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, msg is null.");
            AppMethodBeat.o(37314);
            return false;
        }
        String str = caVar.field_content;
        k.b aD = k.b.aD(str, caVar.field_reserved);
        if (aD == null) {
            Log.i("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, content is null.");
            AppMethodBeat.o(37314);
            return false;
        }
        Log.d("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, url is (%s).", aD.url);
        if (!Util.isNullOrNil(aD.url)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", aD.url);
            com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(37314);
            return true;
        }
        bg.aVF();
        if (com.tencent.mm.model.c.aSN().Kn(aD.ixJ).arz()) {
            Log.i("MicrMsg.ChattingItemHardDeviceMsgLike", "we run black user");
        } else if (aD.dDG == 2) {
            if (!Util.isNullOrNil(aD.ixr)) {
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
                intent2.putExtra("locate_to_username", aD.ixJ);
                com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", intent2);
            } else {
                Intent intent3 = new Intent();
                intent3.putExtra("key_is_latest", true);
                intent3.putExtra("app_username", aD.appName);
                intent3.putExtra("device_type", aD.ixG);
                intent3.putExtra("locate_to_username", aD.ixJ);
                com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "exdevice", ".ui.ExdeviceRankInfoUI", intent3);
            }
            com.tencent.mm.plugin.sport.a.c.pl(30);
        } else if (aD.dDG == 4) {
            Intent intent4 = new Intent();
            intent4.putExtra(ch.COL_USERNAME, aD.ixJ);
            intent4.putExtra("app_username", "gh_43f2581f6fd6");
            com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "exdevice", ".ui.ExdeviceProfileUI", intent4);
            com.tencent.mm.plugin.sport.a.c.pl(29);
        }
        AppMethodBeat.o(37314);
        return false;
    }

    final class a extends c.a {
        protected NoMeasuredTextView POa;
        protected ImageView keC;

        a() {
        }

        public final a hf(View view) {
            AppMethodBeat.i(37309);
            super.create(view);
            this.checkBox = (CheckBox) view.findViewById(R.id.aue);
            this.keC = (ImageView) view.findViewById(R.id.eb5);
            this.POa = (NoMeasuredTextView) view.findViewById(R.id.iol);
            AppMethodBeat.o(37309);
            return this;
        }
    }
}
