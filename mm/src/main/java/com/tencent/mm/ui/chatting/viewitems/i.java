package com.tencent.mm.ui.chatting.viewitems;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.model.bp;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.t;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.widget.MMTextView;
import java.net.URLDecoder;

public final class i {

    public static class c extends c implements t.n {
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (!z || i2 != 503316529) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(36892);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.th);
                view.setTag(new a().G(view, false));
            }
            AppMethodBeat.o(36892);
            return view;
        }

        private static String aGb(String str) {
            AppMethodBeat.i(36893);
            try {
                k.b HD = k.b.HD(str);
                if (HD != null) {
                    String decode = URLDecoder.decode(HD.content, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                    AppMethodBeat.o(36893);
                    return decode;
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.ChattingItemTextTo", "getMsgContent error: %s", e2.getMessage());
            }
            AppMethodBeat.o(36893);
            return "";
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            AppMethodBeat.i(36894);
            this.PhN = aVar2;
            a aVar3 = (a) aVar;
            if (gTW()) {
                b((c.a) aVar3, false);
                if (caVar.field_status == 1 || caVar.field_status == 5) {
                    if (aVar3.PIn != null) {
                        aVar3.PIn.setVisibility(8);
                    }
                    aVar3.PJU.setBackgroundResource(R.drawable.or);
                    caVar.OqF = true;
                } else {
                    aVar3.PJU.setBackgroundResource(R.drawable.oq);
                    if (aVar3.PIn != null) {
                        if (b((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class), caVar.field_msgId)) {
                            if (caVar.OqF) {
                                AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
                                alphaAnimation.setDuration(300);
                                aVar3.PJU.startAnimation(alphaAnimation);
                                caVar.OqF = false;
                            }
                            aVar3.PIn.setVisibility(0);
                        } else {
                            aVar3.PIn.setVisibility(8);
                        }
                    }
                }
            } else {
                b(aVar3, caVar.field_status < 2);
            }
            String aGb = aGb(caVar.field_content);
            if (Util.isNullOrNil(aGb)) {
                Log.e("MicroMsg.ChattingItemTextTo", "[carl] text to, content is null! why?? localid : %s, svrid : %s", Long.valueOf(caVar.field_msgId), Long.valueOf(caVar.field_msgSvrId));
            }
            aVar3.PJU.setMinWidth(0);
            aVar3.PJU.setText(aGb);
            MMTextView mMTextView = aVar3.PJU;
            int type = caVar.getType();
            String talkerUserName = aVar2.getTalkerUserName();
            if (type != 301989937) {
                l.a(mMTextView, talkerUserName);
            }
            mMTextView.getText();
            aVar3.PJU.setTag(bq.b(caVar, aVar2.gRM(), i2));
            aVar3.PJU.setOnLongClickListener(c(aVar2));
            aVar3.PJU.setOnDoubleClickLitsener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOB());
            a(i2, aVar3, caVar, aVar2.gRI(), aVar2.gRM(), aVar2, this);
            AppMethodBeat.o(36894);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            AppMethodBeat.i(233623);
            mVar.a(((bq) view.getTag()).position, 100, view.getContext().getString(R.string.b06), R.raw.icons_filled_delete);
            AppMethodBeat.o(233623);
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.t.n
        public final void b(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233624);
            if (caVar.dOQ()) {
                com.tencent.mm.pluginsdk.model.app.m.aS(caVar);
                bp.Ad(caVar.field_msgId);
                aVar.BN(true);
                AppMethodBeat.o(233624);
                return;
            }
            AppMethodBeat.o(233624);
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
            if (z || i2 != 503316529) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(36887);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.s5);
                view.setTag(new a().G(view, true));
            }
            AppMethodBeat.o(36887);
            return view;
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean b(com.tencent.mm.ui.chatting.e.a aVar) {
            AppMethodBeat.i(36888);
            boolean gRM = aVar.gRM();
            AppMethodBeat.o(36888);
            return gRM;
        }

        private static String aGb(String str) {
            AppMethodBeat.i(36889);
            try {
                k.b HD = k.b.HD(str);
                if (HD != null) {
                    String decode = URLDecoder.decode(HD.content, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                    AppMethodBeat.o(36889);
                    return decode;
                }
            } catch (Exception e2) {
                Log.e("MicroMsg.ChattingItemTextFrom", "getMsgContent error: %s", e2.getMessage());
            }
            AppMethodBeat.o(36889);
            return "";
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            String str2;
            int Kp;
            AppMethodBeat.i(36890);
            this.PhN = aVar2;
            a aVar3 = (a) aVar;
            String str3 = caVar.field_content;
            String talkerUserName = aVar2.getTalkerUserName();
            d dVar = (d) aVar2.bh(d.class);
            if (!aVar2.gRM() || dVar.gOP() || (Kp = bp.Kp(str3)) == -1) {
                str2 = talkerUserName;
            } else {
                str2 = str3.substring(0, Kp).trim();
                if (str2 == null || str2.length() <= 0) {
                    str2 = talkerUserName;
                }
                str3 = str3.substring(Kp + 1).trim();
            }
            String aGb = aGb(str3);
            a(aVar3, aVar2, caVar, str2);
            a(aVar3, aVar2, str2, caVar);
            aVar3.PJU.setText(aGb);
            MMTextView mMTextView = aVar3.PJU;
            int type = caVar.getType();
            String talkerUserName2 = aVar2.getTalkerUserName();
            if (type != 301989937) {
                l.a(mMTextView, talkerUserName2);
            }
            mMTextView.getText();
            aVar3.PJU.setTag(bq.b(caVar, aVar2.gRM(), i2));
            aVar3.PJU.setOnLongClickListener(c(aVar2));
            aVar3.PJU.setOnDoubleClickLitsener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOB());
            AppMethodBeat.o(36890);
        }

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTU() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            AppMethodBeat.i(233622);
            mVar.a(((bq) view.getTag()).position, 100, view.getContext().getString(R.string.b06), R.raw.icons_filled_delete);
            AppMethodBeat.o(233622);
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return false;
        }
    }

    static final class a extends c.a {
        ImageView PIn;
        MMTextView PJU;
        View jxm;

        a() {
        }

        public final c.a G(View view, boolean z) {
            AppMethodBeat.i(36886);
            super.create(view);
            this.timeTV = (TextView) view.findViewById(R.id.ayf);
            this.userTV = (TextView) view.findViewById(R.id.ayn);
            this.PJU = (MMTextView) view.findViewById(R.id.auk);
            this.checkBox = (CheckBox) view.findViewById(R.id.aue);
            this.maskView = view.findViewById(R.id.ax3);
            this.jxm = view.findViewById(R.id.aui);
            if (!z) {
                this.PIn = (ImageView) view.findViewById(R.id.ayd);
                this.stateIV = (ImageView) view.findViewById(R.id.ayb);
                this.uploadingPB = (ProgressBar) view.findViewById(R.id.j0y);
            }
            AppMethodBeat.o(36886);
            return this;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c.a
        public final View getMainContainerView() {
            return this.jxm;
        }
    }
}
