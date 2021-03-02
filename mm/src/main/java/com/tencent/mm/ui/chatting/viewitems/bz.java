package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.br;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.viewitems.c;

public final class bz {

    public static class c extends c {
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (!z || i2 != 536936497) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(258996);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.cdc);
                view.setTag(new a().hX(view));
            }
            AppMethodBeat.o(258996);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            k.b bVar;
            AppMethodBeat.i(258997);
            this.PhN = aVar2;
            a aVar3 = (a) aVar;
            String str2 = caVar.field_content;
            if (str2 != null) {
                bVar = k.b.aD(str2, caVar.field_reserved);
            } else {
                bVar = null;
            }
            if (bVar != null) {
                bz.a(aVar.clickArea, bVar, "MicroMsg.ChattingItemAppMsgC2CNewTo", true, aVar3);
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
                if (ao.isDarkMode()) {
                    long j2 = Util.getLong(bVar2.zph, -1);
                    if (j2 >= 0) {
                        aVar3.PJx.setTextColor((int) j2);
                    }
                } else {
                    long j3 = Util.getLong(bVar2.ivD, -1);
                    if (j3 >= 0) {
                        aVar3.PJx.setTextColor((int) j3);
                    }
                }
                aVar3.PJy.setText(caVar.field_isSend == 1 ? bVar2.ivG : bVar2.ivH);
                if (ao.isDarkMode()) {
                    long j4 = Util.getLong(bVar2.zpO, -1);
                    if (j4 >= 0) {
                        aVar3.PJy.setTextColor((int) j4);
                    }
                } else {
                    long j5 = Util.getLong(bVar2.ivI, -1);
                    if (j5 >= 0) {
                        aVar3.PJy.setTextColor((int) j5);
                    }
                }
                aVar3.PJz.setText(caVar.field_isSend == 1 ? bVar2.ivE : bVar2.ivF);
                aVar3.PJw.setImageBitmap(null);
                if (!Util.isNullOrNil(bVar2.ivw)) {
                    if (bVar2.ivw.startsWith("http")) {
                        c.a aVar4 = new c.a();
                        bg.aVF();
                        aVar4.prefixPath = com.tencent.mm.model.c.aSZ();
                        aVar4.jbf = true;
                        aVar4.hZF = true;
                        q.bcV().a(bVar2.ivw, aVar3.PJw, aVar4.bdv());
                    } else {
                        int identifier = MMApplicationContext.getResources().getIdentifier(bVar2.ivw, "drawable", MMApplicationContext.getPackageName());
                        if (identifier > 0) {
                            aVar3.PJw.setImageResource(identifier);
                        }
                    }
                }
            }
            aVar.clickArea.setOnClickListener(d(aVar2));
            aVar.clickArea.setOnLongClickListener(c(aVar2));
            aVar.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
            aVar.clickArea.setTag(new bq(caVar, this.PhN.gRM(), i2, (String) null, (char) 0));
            AppMethodBeat.o(258997);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            AppMethodBeat.i(258998);
            int i2 = ((bq) view.getTag()).position;
            if (br.B(caVar)) {
                mVar.clear();
            }
            mVar.a(i2, 100, this.PhN.Pwc.getMMResources().getString(R.string.b06), R.raw.icons_filled_delete);
            AppMethodBeat.o(258998);
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(258999);
            menuItem.getItemId();
            AppMethodBeat.o(258999);
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(259000);
            ((com.tencent.mm.plugin.comm.a.b) g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(caVar.field_talker);
            String str = caVar.field_content;
            k.b bVar = null;
            if (str != null) {
                bVar = k.b.aD(str, caVar.field_reserved);
            }
            if (bVar != null) {
                String str2 = Util.isNullOrNil(bVar.iyi) ? bVar.url : bVar.iyi;
                if (!Util.isNullOrNil(str2)) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str2);
                    com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                }
            }
            AppMethodBeat.o(259000);
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
            if (z || i2 != 536936497) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(258991);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.cdb);
                view.setTag(new a().hX(view));
            }
            AppMethodBeat.o(258991);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            k.b bVar;
            AppMethodBeat.i(258992);
            this.PhN = aVar2;
            a aVar3 = (a) aVar;
            String str2 = caVar.field_content;
            if (str2 != null) {
                bVar = k.b.aD(str2, caVar.field_reserved);
            } else {
                bVar = null;
            }
            if (bVar != null) {
                bz.a(aVar.clickArea, bVar, "MicroMsg.ChattingItemAppMsgC2CNewFrom", false, aVar3);
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
                if (ao.isDarkMode()) {
                    long j2 = Util.getLong(bVar2.zph, -1);
                    if (j2 >= 0) {
                        aVar3.PJx.setTextColor((int) j2);
                    }
                } else {
                    long j3 = Util.getLong(bVar2.ivD, -1);
                    if (j3 >= 0) {
                        aVar3.PJx.setTextColor((int) j3);
                    }
                }
                aVar3.PJy.setText(caVar.field_isSend == 1 ? bVar2.ivG : bVar2.ivH);
                if (ao.isDarkMode()) {
                    long j4 = Util.getLong(bVar2.zpO, -1);
                    if (j4 >= 0) {
                        aVar3.PJy.setTextColor((int) j4);
                    }
                } else {
                    long j5 = Util.getLong(bVar2.ivI, -1);
                    if (j5 >= 0) {
                        aVar3.PJy.setTextColor((int) j5);
                    }
                }
                aVar3.PJz.setText(caVar.field_isSend == 1 ? bVar2.ivE : bVar2.ivF);
                aVar3.PJw.setImageBitmap(null);
                if (!Util.isNullOrNil(bVar2.ivw)) {
                    if (bVar2.ivw.startsWith("http")) {
                        c.a aVar4 = new c.a();
                        bg.aVF();
                        aVar4.prefixPath = com.tencent.mm.model.c.aSZ();
                        aVar4.jbf = true;
                        aVar4.hZF = true;
                        q.bcV().a(bVar2.ivw, aVar3.PJw, aVar4.bdv());
                    } else {
                        int identifier = MMApplicationContext.getResources().getIdentifier(bVar2.ivw, "drawable", MMApplicationContext.getPackageName());
                        if (identifier > 0) {
                            aVar3.PJw.setImageResource(identifier);
                        }
                    }
                }
            }
            aVar.clickArea.setOnClickListener(d(aVar2));
            aVar.clickArea.setOnLongClickListener(c(aVar2));
            aVar.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
            aVar.clickArea.setTag(new bq(caVar, this.PhN.gRM(), i2, (String) null, (char) 0));
            AppMethodBeat.o(258992);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            AppMethodBeat.i(258993);
            mVar.a(((bq) view.getTag()).position, 100, this.PhN.Pwc.getMMResources().getString(R.string.b06), R.raw.icons_filled_delete);
            AppMethodBeat.o(258993);
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(258994);
            switch (menuItem.getItemId()) {
                case 100:
                    AppMethodBeat.o(258994);
                    return true;
                default:
                    AppMethodBeat.o(258994);
                    return false;
            }
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(258995);
            ((com.tencent.mm.plugin.comm.a.b) g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(caVar.field_talker);
            String str = caVar.field_content;
            k.b bVar = null;
            if (str != null) {
                bVar = k.b.aD(str, caVar.field_reserved);
            }
            if (bVar != null) {
                String str2 = Util.isNullOrNil(bVar.iyi) ? bVar.url : bVar.iyi;
                if (!Util.isNullOrNil(str2)) {
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str2);
                    com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                }
            }
            AppMethodBeat.o(258995);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public static class a extends c.a {
        public int PJE = 0;
        public int PJa = 0;
        public ImageView PJw;
        public TextView PJx;
        public TextView PJy;
        public TextView PJz;
        public int maxSize = 0;

        a() {
        }

        public final a hX(View view) {
            AppMethodBeat.i(258990);
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
            AppMethodBeat.o(258990);
            return this;
        }
    }

    static /* synthetic */ void a(final View view, k.b bVar, final String str, final boolean z, final a aVar) {
        AppMethodBeat.i(259001);
        if (bVar != null) {
            com.tencent.mm.ag.b bVar2 = (com.tencent.mm.ag.b) bVar.as(com.tencent.mm.ag.b.class);
            String str2 = z ? bVar2.ivK : bVar2.ivM;
            if (!Util.isNullOrNil(str2)) {
                Log.i(str, "get background name: %s", str2);
                int identifier = view.getResources().getIdentifier(str2, "drawable", MMApplicationContext.getPackageName());
                if (identifier > 0) {
                    view.setBackgroundResource(identifier);
                    AppMethodBeat.o(259001);
                    return;
                }
            }
            final String str3 = z ? bVar2.ivL : bVar2.ivN;
            if (!Util.isNullOrNil(str3)) {
                h.RTc.aW(new Runnable() {
                    /* class com.tencent.mm.ui.chatting.viewitems.bz.AnonymousClass1 */

                    public final void run() {
                        boolean z = true;
                        AppMethodBeat.i(258989);
                        Log.i(str, "get background url: %s", str3);
                        final int height = aVar.clickArea.getHeight();
                        final int width = aVar.clickArea.getWidth();
                        Bitmap OQ = q.bcV().OQ(str3);
                        if (OQ != null) {
                            Resources resources = MMApplicationContext.getResources();
                            String str = str;
                            if (z) {
                                z = false;
                            }
                            view.setBackground(new BitmapDrawable(resources, bz.a(str, OQ, height, width, z)));
                            AppMethodBeat.o(258989);
                            return;
                        }
                        c.a aVar = new c.a();
                        bg.aVF();
                        aVar.prefixPath = com.tencent.mm.model.c.aSZ();
                        aVar.jbf = true;
                        aVar.jbd = true;
                        aVar.hZF = false;
                        aVar.hZz = width;
                        aVar.hZA = height;
                        com.tencent.mm.av.a.a.c bdv = aVar.bdv();
                        view.setTag(R.id.ign, str3);
                        q.bcV().a(str3, null, bdv, null, new com.tencent.mm.av.a.c.h() {
                            /* class com.tencent.mm.ui.chatting.viewitems.bz.AnonymousClass1.AnonymousClass1 */

                            @Override // com.tencent.mm.av.a.c.h
                            public final void b(String str, View view) {
                            }

                            @Override // com.tencent.mm.av.a.c.h
                            public final Bitmap a(String str, View view, com.tencent.mm.av.a.d.b bVar) {
                                return null;
                            }

                            @Override // com.tencent.mm.av.a.c.h
                            public final void b(final String str, View view, final com.tencent.mm.av.a.d.b bVar) {
                                AppMethodBeat.i(258988);
                                h.RTc.aW(new Runnable() {
                                    /* class com.tencent.mm.ui.chatting.viewitems.bz.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(258987);
                                        if (bVar.bitmap != null && str.equals(view.getTag(R.id.ign))) {
                                            view.setBackground(new BitmapDrawable(MMApplicationContext.getResources(), bz.a(str, bVar.bitmap, height, width, !z)));
                                        }
                                        AppMethodBeat.o(258987);
                                    }
                                });
                                AppMethodBeat.o(258988);
                            }
                        });
                        AppMethodBeat.o(258989);
                    }
                });
            }
        }
        AppMethodBeat.o(259001);
    }

    static /* synthetic */ Bitmap a(String str, Bitmap bitmap, int i2, int i3, boolean z) {
        int i4;
        AppMethodBeat.i(259002);
        Log.d(str, "th: %s, tw: %s", Integer.valueOf(i2), Integer.valueOf(i3));
        Bitmap centerCropBitmap = BitmapUtil.getCenterCropBitmap(bitmap, i3, i2, false);
        if (z) {
            i4 = R.drawable.bb1;
        } else {
            i4 = R.drawable.c3o;
        }
        Bitmap createChattingImage = BitmapUtil.createChattingImage(centerCropBitmap, i4);
        AppMethodBeat.o(259002);
        return createChattingImage;
    }
}
