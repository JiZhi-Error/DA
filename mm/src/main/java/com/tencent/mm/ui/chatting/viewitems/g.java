package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.viewitems.c;

public final class g {

    public static class c extends c {
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (!z || i2 != 536870961) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(36868);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.sm);
                view.setTag(new a().gN(view));
            }
            AppMethodBeat.o(36868);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            k.b bVar;
            AppMethodBeat.i(36869);
            this.PhN = aVar2;
            a aVar3 = (a) aVar;
            String str2 = caVar.field_content;
            if (str2 != null) {
                bVar = k.b.aD(str2, caVar.field_reserved);
            } else {
                bVar = null;
            }
            if (bVar != null) {
                g.a(aVar.clickArea, bVar, "MicroMsg.ChattingItemAppMsgC2CTo", true);
                aVar3.PJx.setTypeface(Typeface.defaultFromStyle(0));
                aVar2.Pwc.getContext().getResources().getDimensionPixelSize(R.dimen.k5);
                aVar2.Pwc.getContext().getResources().getDimensionPixelSize(R.dimen.w9);
                aVar3.clickArea.setPadding(0, 0, 0, 0);
                aVar3.resetChatBubbleWidth(aVar3.clickArea, aVar3.PJa);
                com.tencent.mm.ag.b bVar2 = (com.tencent.mm.ag.b) bVar.as(com.tencent.mm.ag.b.class);
                String str3 = caVar.field_isSend == 1 ? bVar2.ivC : bVar2.ivB;
                if (Util.isNullOrNil(str3)) {
                    str3 = bVar.description;
                    aVar3.PJx.setSingleLine(false);
                    aVar3.PJx.setMaxLines(3);
                } else {
                    aVar3.PJx.setSingleLine(true);
                }
                aVar3.PJx.setText(l.e((Context) aVar2.Pwc.getContext(), (CharSequence) str3, aVar3.PJE));
                aVar3.PJx.setTextSize(0, (float) aVar3.PJE);
                if (!Util.isNullOrNil(bVar2.ivD)) {
                    aVar3.PJx.setTextColor(Color.parseColor(bVar2.ivD));
                }
                aVar3.PJy.setText(caVar.field_isSend == 1 ? bVar2.ivG : bVar2.ivH);
                if (!Util.isNullOrNil(bVar2.ivI)) {
                    aVar3.PJy.setTextColor(Color.parseColor(bVar2.ivI));
                }
                aVar3.PJz.setText(caVar.field_isSend == 1 ? bVar2.ivE : bVar2.ivF);
                aVar3.PJw.setImageBitmap(null);
                if (!Util.isNullOrNil(bVar2.ivw)) {
                    c.a aVar4 = new c.a();
                    bg.aVF();
                    aVar4.prefixPath = com.tencent.mm.model.c.aSZ();
                    aVar4.jbf = true;
                    aVar4.hZF = true;
                    q.bcV().a(bVar2.ivw, aVar3.PJw, aVar4.bdv());
                }
            }
            aVar.clickArea.setOnClickListener(d(aVar2));
            aVar.clickArea.setOnLongClickListener(c(aVar2));
            aVar.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
            aVar.clickArea.setTag(new bq(caVar, this.PhN.gRM(), i2, (String) null, (char) 0));
            AppMethodBeat.o(36869);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            AppMethodBeat.i(233619);
            mVar.a(((bq) view.getTag()).position, 100, this.PhN.Pwc.getMMResources().getString(R.string.b06), R.raw.icons_filled_delete);
            AppMethodBeat.o(233619);
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, final com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(36871);
            switch (menuItem.getItemId()) {
                case 103:
                    String str = caVar.field_content;
                    k.b bVar = null;
                    if (str != null) {
                        bVar = k.b.aD(str, caVar.field_reserved);
                    }
                    if (bVar != null) {
                        final String str2 = caVar.field_talker;
                        final String str3 = bVar.iyk;
                        final String str4 = bVar.iyl;
                        final String str5 = bVar.iym;
                        final String str6 = bVar.iyn;
                        final String str7 = bVar.iyi;
                        final String str8 = bVar.iyp;
                        final String str9 = bVar.iyq;
                        h.c(aVar.Pwc.getContext(), aVar.Pwc.getMMResources().getString(R.string.b1x), aVar.Pwc.getMMResources().getString(R.string.yd), aVar.Pwc.getMMResources().getString(R.string.b1y), aVar.Pwc.getMMResources().getString(R.string.sz), new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.ui.chatting.viewitems.g.c.AnonymousClass1 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(36867);
                                Intent intent = new Intent();
                                intent.putExtra("key_scene", 1);
                                intent.putExtra("key_receiver", str2);
                                intent.putExtra("key_receivertitle", str3);
                                intent.putExtra("key_sendertitle", str4);
                                intent.putExtra("key_sender_des", str5);
                                intent.putExtra("key_receiver_des", str6);
                                intent.putExtra("key_url", str7);
                                intent.putExtra("key_templateid", str8);
                                intent.putExtra("key_sceneid", str9);
                                com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "wallet_index", ".ui.WalletSendC2CMsgUI", intent);
                                AppMethodBeat.o(36867);
                            }
                        }, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.ui.chatting.viewitems.g.c.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                            }
                        });
                    }
                    AppMethodBeat.o(36871);
                    return true;
                default:
                    AppMethodBeat.o(36871);
                    return false;
            }
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(36872);
            ((com.tencent.mm.plugin.comm.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(caVar.field_talker);
            String str = caVar.field_content;
            k.b bVar = null;
            if (str != null) {
                bVar = k.b.aD(str, caVar.field_reserved);
            }
            if (bVar != null) {
                Log.i("MicroMsg.ChattingItemAppMsgC2CTo", "click honey pay");
                String queryParameter = Uri.parse(((com.tencent.mm.ag.b) bVar.as(com.tencent.mm.ag.b.class)).ivt).getQueryParameter("cardNo");
                Intent intent = new Intent();
                intent.putExtra("key_is_payer", true);
                intent.putExtra("key_card_no", queryParameter);
                com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "honey_pay", ".ui.HoneyPayProxyUI", intent);
            }
            AppMethodBeat.o(36872);
            return true;
        }
    }

    public static class b extends c {
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (z || i2 != 536870961) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(36862);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.r8);
                view.setTag(new a().gN(view));
            }
            AppMethodBeat.o(36862);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            k.b bVar;
            AppMethodBeat.i(36863);
            this.PhN = aVar2;
            a aVar3 = (a) aVar;
            String str2 = caVar.field_content;
            if (str2 != null) {
                bVar = k.b.aD(str2, caVar.field_reserved);
            } else {
                bVar = null;
            }
            if (bVar != null) {
                g.a(aVar.clickArea, bVar, "MicroMsg.ChattingItemAppMsgC2CFrom", false);
                aVar3.PJx.setTypeface(Typeface.defaultFromStyle(0));
                aVar2.Pwc.getContext().getResources().getDimensionPixelSize(R.dimen.k5);
                aVar2.Pwc.getContext().getResources().getDimensionPixelSize(R.dimen.w9);
                aVar3.clickArea.setPadding(0, 0, 0, 0);
                aVar3.resetChatBubbleWidth(aVar3.clickArea, aVar3.PJa);
                com.tencent.mm.ag.b bVar2 = (com.tencent.mm.ag.b) bVar.as(com.tencent.mm.ag.b.class);
                String str3 = caVar.field_isSend == 1 ? bVar2.ivC : bVar2.ivB;
                if (Util.isNullOrNil(str3)) {
                    str3 = bVar.description;
                    aVar3.PJx.setSingleLine(false);
                    aVar3.PJx.setMaxLines(3);
                } else {
                    aVar3.PJx.setSingleLine(true);
                }
                aVar3.PJx.setText(l.e((Context) aVar2.Pwc.getContext(), (CharSequence) str3, aVar3.PJE));
                aVar3.PJx.setTextSize(0, (float) aVar3.PJE);
                if (!Util.isNullOrNil(bVar2.ivD)) {
                    aVar3.PJx.setTextColor(Color.parseColor(bVar2.ivD));
                }
                aVar3.PJy.setText(caVar.field_isSend == 1 ? bVar2.ivG : bVar2.ivH);
                if (!Util.isNullOrNil(bVar2.ivI)) {
                    aVar3.PJy.setTextColor(Color.parseColor(bVar2.ivI));
                }
                aVar3.PJz.setText(caVar.field_isSend == 1 ? bVar2.ivE : bVar2.ivF);
                aVar3.PJw.setImageBitmap(null);
                if (!Util.isNullOrNil(bVar2.ivw)) {
                    c.a aVar4 = new c.a();
                    bg.aVF();
                    aVar4.prefixPath = com.tencent.mm.model.c.aSZ();
                    aVar4.jbf = true;
                    aVar4.hZF = true;
                    q.bcV().a(bVar2.ivw, aVar3.PJw, aVar4.bdv());
                }
            }
            aVar.clickArea.setOnClickListener(d(aVar2));
            aVar.clickArea.setOnLongClickListener(c(aVar2));
            aVar.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
            aVar.clickArea.setTag(new bq(caVar, this.PhN.gRM(), i2, (String) null, (char) 0));
            AppMethodBeat.o(36863);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            AppMethodBeat.i(233618);
            mVar.a(((bq) view.getTag()).position, 100, this.PhN.Pwc.getMMResources().getString(R.string.b06), R.raw.icons_filled_delete);
            AppMethodBeat.o(233618);
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(36865);
            switch (menuItem.getItemId()) {
                case 100:
                    AppMethodBeat.o(36865);
                    return true;
                default:
                    AppMethodBeat.o(36865);
                    return false;
            }
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(36866);
            ((com.tencent.mm.plugin.comm.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(caVar.field_talker);
            String str = caVar.field_content;
            k.b bVar = null;
            if (str != null) {
                bVar = k.b.aD(str, caVar.field_reserved);
            }
            if (bVar != null) {
                Log.i("MicroMsg.ChattingItemAppMsgC2CFrom", "click honey pay");
                String queryParameter = Uri.parse(((com.tencent.mm.ag.b) bVar.as(com.tencent.mm.ag.b.class)).ivv).getQueryParameter("cardNo");
                Intent intent = new Intent();
                intent.putExtra("key_is_payer", false);
                intent.putExtra("key_card_no", queryParameter);
                if (!WeChatBrands.Business.Entries.SessionPayment.checkAvailable(view.getContext())) {
                    AppMethodBeat.o(36866);
                    return true;
                }
                com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "honey_pay", ".ui.HoneyPayProxyUI", intent);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(15191, 0, 0, 0, 0, 0, 0, 1);
            }
            AppMethodBeat.o(36866);
            return true;
        }
    }

    static class a extends c.a {
        public int PJE = 0;
        public int PJa = 0;
        public ImageView PJw;
        public TextView PJx;
        public TextView PJy;
        public TextView PJz;
        public int maxSize = 0;

        a() {
        }

        public final a gN(View view) {
            AppMethodBeat.i(36861);
            super.create(view);
            this.timeTV = (TextView) this.convertView.findViewById(R.id.ayf);
            this.checkBox = (CheckBox) this.convertView.findViewById(R.id.aue);
            this.maskView = this.convertView.findViewById(R.id.ax3);
            this.userTV = (TextView) this.convertView.findViewById(R.id.ayn);
            this.PJw = (ImageView) this.convertView.findViewById(R.id.tv);
            this.PJx = (TextView) this.convertView.findViewById(R.id.u1);
            this.PJy = (TextView) this.convertView.findViewById(R.id.tt);
            this.PJz = (TextView) this.convertView.findViewById(R.id.u5);
            this.clickArea = this.convertView.findViewById(R.id.auf);
            this.PJa = c.kl(MMApplicationContext.getContext());
            this.PJE = com.tencent.mm.cb.a.aG(MMApplicationContext.getContext(), R.dimen.a_);
            this.maxSize = (int) (((float) com.tencent.mm.cb.a.aH(MMApplicationContext.getContext(), R.dimen.a_)) * 1.45f);
            AppMethodBeat.o(36861);
            return this;
        }
    }

    static Drawable aM(Bitmap bitmap) {
        AppMethodBeat.i(36873);
        byte[] ninePatchChunk = bitmap.getNinePatchChunk();
        if (NinePatch.isNinePatchChunk(ninePatchChunk)) {
            NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(MMApplicationContext.getResources(), bitmap, ninePatchChunk, new Rect(), null);
            ninePatchDrawable.setBounds(0, 0, bitmap.getWidth(), bitmap.getHeight());
            AppMethodBeat.o(36873);
            return ninePatchDrawable;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
        AppMethodBeat.o(36873);
        return bitmapDrawable;
    }

    static /* synthetic */ void a(View view, k.b bVar, String str, boolean z) {
        AppMethodBeat.i(36874);
        if (bVar != null) {
            com.tencent.mm.ag.b bVar2 = (com.tencent.mm.ag.b) bVar.as(com.tencent.mm.ag.b.class);
            String str2 = z ? bVar2.ivK : bVar2.ivM;
            if (!Util.isNullOrNil(str2)) {
                Log.i(str, "get background name: %s", str2);
                int identifier = view.getResources().getIdentifier(str2, "drawable", MMApplicationContext.getPackageName());
                if (identifier > 0) {
                    view.setBackgroundResource(identifier);
                    AppMethodBeat.o(36874);
                    return;
                }
            }
            String str3 = z ? bVar2.ivL : bVar2.ivN;
            if (!Util.isNullOrNil(str3)) {
                Log.i(str, "get background url: %s", str3);
                Bitmap OQ = q.bcV().OQ(str3);
                if (OQ != null) {
                    view.setBackground(aM(OQ));
                    AppMethodBeat.o(36874);
                    return;
                }
                c.a aVar = new c.a();
                bg.aVF();
                aVar.prefixPath = com.tencent.mm.model.c.aSZ();
                aVar.jbf = true;
                aVar.jbd = true;
                aVar.hZF = false;
                com.tencent.mm.av.a.a.c bdv = aVar.bdv();
                view.setTag(R.id.ign, str3);
                q.bcV().a(str3, (ImageView) null, bdv, new com.tencent.mm.av.a.c.k() {
                    /* class com.tencent.mm.ui.chatting.viewitems.g.AnonymousClass1 */

                    @Override // com.tencent.mm.av.a.c.k
                    public final void a(String str, View view, Bitmap bitmap, Object... objArr) {
                        AppMethodBeat.i(36860);
                        if (bitmap != null && str.equals(view.getTag(R.id.ign))) {
                            view.setBackground(g.aM(bitmap));
                        }
                        AppMethodBeat.o(36860);
                    }
                });
            }
        }
        if (z) {
            view.setBackgroundResource(R.drawable.c2csendermsgnodebg);
            AppMethodBeat.o(36874);
            return;
        }
        view.setBackgroundResource(R.drawable.c2creceivermsgnodebg);
        AppMethodBeat.o(36874);
    }
}
