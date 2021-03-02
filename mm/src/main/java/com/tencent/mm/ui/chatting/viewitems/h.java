package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.SemiXml;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.viewitems.c;
import java.util.Map;

public final class h {

    public static class c extends c {
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (!z || i2 != 469762097) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(36881);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.sn);
                view.setTag(new a().gO(view));
            }
            AppMethodBeat.o(36881);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            k.b bVar;
            AppMethodBeat.i(36882);
            this.PhN = aVar2;
            String str2 = caVar.field_content;
            if (str2 != null) {
                bVar = k.b.aD(str2, caVar.field_reserved);
            } else {
                bVar = null;
            }
            a aVar3 = (a) aVar;
            d dVar = (d) bVar.as(d.class);
            if (dVar.eha == 0) {
                aVar3.PJR.setBackgroundResource(R.drawable.cee);
                aVar3.PJS.setBackgroundResource(R.drawable.cdp);
                aVar3.PJQ.setVisibility(8);
            } else {
                aVar3.PJR.setBackgroundResource(R.drawable.cef);
                aVar3.PJS.setBackgroundResource(R.drawable.cdq);
                aVar3.PJQ.setVisibility(0);
                if (dVar.eha == 1) {
                    aVar3.PJQ.setText(MMApplicationContext.getContext().getString(R.string.eqh));
                } else if (dVar.eha == 2) {
                    aVar3.PJQ.setText(MMApplicationContext.getContext().getString(R.string.eqk));
                }
            }
            aVar.clickArea.setOnClickListener(d(aVar2));
            aVar.clickArea.setOnLongClickListener(c(aVar2));
            aVar.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
            aVar.clickArea.setTag(new bq(caVar, this.PhN.gRM(), i2, (String) null, (char) 0));
            AppMethodBeat.o(36882);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            AppMethodBeat.i(233621);
            mVar.a(((bq) view.getTag()).position, 100, this.PhN.Pwc.getMMResources().getString(R.string.b06), R.raw.icons_filled_delete);
            AppMethodBeat.o(233621);
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(36884);
            menuItem.getItemId();
            AppMethodBeat.o(36884);
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            k.b aD;
            AppMethodBeat.i(36885);
            ((com.tencent.mm.plugin.comm.a.b) g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(caVar.field_talker);
            String str = caVar.field_content;
            if (!(str == null || (aD = k.b.aD(str, caVar.field_reserved)) == null || Util.isNullOrNil(aD.iyr))) {
                d dVar = (d) aD.as(d.class);
                Intent intent = new Intent();
                intent.putExtra("key_native_url", aD.iyr);
                intent.putExtra("key_image_id", aD.iyu);
                intent.putExtra("key_image_aes_key", aD.iyv);
                intent.putExtra("key_image_length", aD.iyw);
                intent.putExtra("key_username", aVar.getTalkerUserName());
                intent.putExtra("key_msgid", caVar.field_msgId);
                intent.putExtra("key_msg_newyear_localreceivestatus", dVar.eha);
                if (dVar.gWm != null) {
                    intent.putExtra("key_emoji_md5", dVar.gWm.field_md5);
                }
                com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "luckymoney", ".ui.LuckyMoneyNewYearReceiveUI", intent);
            }
            AppMethodBeat.o(36885);
            return true;
        }
    }

    public static class b extends c {
        private final int PJT = 1;
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (z || i2 != 469762097) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(36876);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.r9);
                view.setTag(new a().gO(view));
            }
            AppMethodBeat.o(36876);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            k.b bVar;
            AppMethodBeat.i(36877);
            this.PhN = aVar2;
            String str2 = caVar.field_content;
            if (str2 != null) {
                bVar = k.b.aD(str2, caVar.field_reserved);
            } else {
                bVar = null;
            }
            a aVar3 = (a) aVar;
            d dVar = (d) bVar.as(d.class);
            if (dVar.eha == 0) {
                aVar3.PJR.setBackgroundResource(R.drawable.cdz);
                aVar3.PJS.setBackgroundResource(R.drawable.cdr);
                aVar3.PJQ.setVisibility(8);
            } else {
                aVar3.PJR.setBackgroundResource(R.drawable.ce0);
                aVar3.PJS.setBackgroundResource(R.drawable.cdq);
                aVar3.PJQ.setVisibility(0);
                if (dVar.eha == 1) {
                    aVar3.PJQ.setText(MMApplicationContext.getContext().getString(R.string.eqh));
                } else if (dVar.eha == 2) {
                    aVar3.PJQ.setText(MMApplicationContext.getContext().getString(R.string.eqj));
                }
            }
            aVar.clickArea.setOnClickListener(d(aVar2));
            aVar.clickArea.setOnLongClickListener(c(aVar2));
            aVar.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
            aVar.clickArea.setTag(new bq(caVar, this.PhN.gRM(), i2, (String) null, (char) 0));
            AppMethodBeat.o(36877);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            AppMethodBeat.i(233620);
            mVar.a(((bq) view.getTag()).position, 100, this.PhN.Pwc.getMMResources().getString(R.string.b06), R.raw.icons_filled_delete);
            AppMethodBeat.o(233620);
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(36879);
            menuItem.getItemId();
            AppMethodBeat.o(36879);
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(36880);
            ((com.tencent.mm.plugin.comm.a.b) g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(caVar.field_talker);
            String str = caVar.field_content;
            if (str != null) {
                k.b aD = k.b.aD(str, caVar.field_reserved);
                if (!Util.isNullOrNil(aD.iyr)) {
                    Log.d("MicroMsg.ChattingItemAppMsgC2CNewYearFrom", "onItemClick play egg emoj");
                    d dVar = (d) aD.as(d.class);
                    Intent intent = new Intent();
                    intent.putExtra("key_native_url", aD.iyr);
                    intent.putExtra("key_username", aVar.getTalkerUserName());
                    intent.putExtra("key_image_id", aD.iyu);
                    intent.putExtra("key_image_aes_key", aD.iyv);
                    intent.putExtra("key_image_length", aD.iyw);
                    intent.putExtra("key_msgid", caVar.field_msgId);
                    intent.putExtra("key_msg_newyear_localreceivestatus", dVar.eha);
                    if (dVar.gWm != null) {
                        intent.putExtra("key_emoji_md5", dVar.gWm.field_md5);
                    }
                    com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "luckymoney", ".ui.LuckyMoneyNewYearReceiveUI", intent);
                    aD.iys = 1;
                    caVar.setContent(k.b.a(aD, null, null));
                    if (caVar != null && caVar.dOQ()) {
                        try {
                            String str2 = caVar.field_content;
                            int indexOf = str2.indexOf("<msg>");
                            if (indexOf > 0 && indexOf < str2.length()) {
                                str2 = str2.substring(indexOf).trim();
                            }
                            Map<String, String> parseXml = XmlParser.parseXml(str2, "msg", null);
                            if (parseXml != null && parseXml.size() > 0) {
                                caVar.CA(SemiXml.encode(parseXml));
                            }
                        } catch (Exception e2) {
                            Log.e("MicroMsg.ChattingItemAppMsgC2CNewYearFrom", e2.getMessage());
                        }
                    }
                    bg.aVF();
                    com.tencent.mm.model.c.aSQ().a(caVar.field_msgId, caVar);
                }
            }
            AppMethodBeat.o(36880);
            return true;
        }
    }

    static class a extends c.a {
        public RelativeLayout PJP;
        public TextView PJQ;
        public ImageView PJR;
        public ImageView PJS;

        a() {
        }

        public final a gO(View view) {
            AppMethodBeat.i(36875);
            super.create(view);
            this.timeTV = (TextView) this.convertView.findViewById(R.id.ayf);
            this.checkBox = (CheckBox) this.convertView.findViewById(R.id.aue);
            this.maskView = this.convertView.findViewById(R.id.ax3);
            this.userTV = (TextView) this.convertView.findViewById(R.id.ayn);
            this.clickArea = this.convertView.findViewById(R.id.u0);
            this.PJP = (RelativeLayout) this.convertView.findViewById(R.id.tz);
            this.PJQ = (TextView) this.convertView.findViewById(R.id.tw);
            this.PJR = (ImageView) this.convertView.findViewById(R.id.tx);
            this.PJS = (ImageView) this.convertView.findViewById(R.id.ty);
            AppMethodBeat.o(36875);
            return this;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c.a
        public final View getMainContainerView() {
            return this.PJP;
        }
    }
}
