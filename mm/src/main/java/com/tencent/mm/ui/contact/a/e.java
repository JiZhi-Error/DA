package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.recovery.log.RecoveryFileLog;
import java.util.List;
import java.util.regex.Pattern;

public class e extends a {
    private static final Pattern jVK = Pattern.compile(",");
    public String Qan;
    public boolean Qao;
    public boolean Qap;
    private b Qaq = new b();
    private a Qar = new a();
    public CharSequence hXr;
    public CharSequence jVL;
    public m lqW;
    public String username;

    static {
        AppMethodBeat.i(102949);
        AppMethodBeat.o(102949);
    }

    public e(int i2) {
        super(2, i2);
        AppMethodBeat.i(102947);
        AppMethodBeat.o(102947);
    }

    public class b extends a.b {
        public b() {
            super();
        }

        @Override // com.tencent.mm.ui.contact.a.a.b
        public View a(Context context, ViewGroup viewGroup) {
            View inflate;
            AppMethodBeat.i(102944);
            if (com.tencent.mm.cb.a.jk(context)) {
                inflate = LayoutInflater.from(context).inflate(R.layout.bq0, viewGroup, false);
            } else {
                inflate = LayoutInflater.from(context).inflate(R.layout.bpz, viewGroup, false);
            }
            a aVar = (a) e.this.eOf();
            aVar.gvv = (ImageView) inflate.findViewById(R.id.x1);
            aVar.jVO = (TextView) inflate.findViewById(R.id.ir3);
            aVar.jBR = (TextView) inflate.findViewById(R.id.bn6);
            aVar.contentView = inflate.findViewById(R.id.hi1);
            aVar.jVQ = (CheckBox) inflate.findViewById(R.id.hhc);
            aVar.Qas = (ImageView) inflate.findViewById(R.id.his);
            aVar.jVP = (TextView) inflate.findViewById(R.id.g4q);
            inflate.setTag(aVar);
            if (e.this.VlU) {
                Resources resources = aVar.jVO.getContext().getResources();
                aVar.contentView.setBackgroundResource(R.drawable.ctj);
                aVar.jVO.setTextColor(resources.getColor(R.color.BW_100_Alpha_0_8));
                aVar.jBR.setTextColor(resources.getColor(R.color.BW_100_Alpha_0_5));
                aVar.jVQ.setBackgroundResource(R.drawable.cve);
            }
            AppMethodBeat.o(102944);
            return inflate;
        }

        @Override // com.tencent.mm.ui.contact.a.a.b
        public void a(final Context context, a.C2110a aVar, a aVar2, boolean z, boolean z2) {
            AppMethodBeat.i(102945);
            final a aVar3 = (a) aVar;
            final e eVar = (e) aVar2;
            if (eVar.username == null || eVar.username.length() <= 0) {
                aVar3.gvv.setImageResource(R.drawable.bca);
            } else {
                a.b.a(aVar3.gvv, eVar.username, 0.1f, false);
            }
            n.a(eVar.jVL, aVar3.jVO);
            n.a(eVar.hXr, aVar3.jBR);
            if (e.this.PWh) {
                if (!e.this.VlU) {
                    aVar3.jVQ.setBackgroundResource(R.drawable.ahw);
                }
                if (z) {
                    aVar3.jVQ.setChecked(true);
                    aVar3.jVQ.setEnabled(false);
                    aVar3.jVQ.setBackgroundResource((ao.isDarkMode() || e.this.VlU) ? R.raw.checkbox_selected_grey_dark : R.raw.checkbox_selected_grey);
                } else {
                    aVar3.jVQ.setChecked(z2);
                    aVar3.jVQ.setEnabled(true);
                }
                aVar3.jVQ.setVisibility(0);
            } else if (e.this.Qaa) {
                aVar3.jVQ.setBackgroundResource(R.drawable.arh);
                if (z) {
                    aVar3.jVQ.setChecked(true);
                    aVar3.jVQ.setEnabled(false);
                    aVar3.jVQ.setBackgroundResource((ao.isDarkMode() || e.this.VlU) ? R.raw.checkbox_selected_grey_dark : R.raw.checkbox_selected_grey);
                } else {
                    aVar3.jVQ.setChecked(z2);
                    aVar3.jVQ.setEnabled(true);
                }
                aVar3.jVQ.setVisibility(0);
            } else if (e.this.PWi) {
                aVar3.jVQ.setVisibility(8);
                if (z2) {
                    aVar3.Qas.setVisibility(0);
                } else {
                    aVar3.Qas.setVisibility(8);
                }
            } else {
                aVar3.jVQ.setVisibility(8);
            }
            if (e.this.Qap) {
                aVar3.jVQ.setVisibility(8);
                aVar3.Qas.setVisibility(8);
            }
            if (e.this.poB) {
                aVar3.contentView.setBackgroundResource(R.drawable.qd);
            } else if (aVar2.Qac) {
                aVar3.contentView.setBackgroundResource(R.drawable.u);
            } else {
                aVar3.contentView.setBackgroundResource(R.drawable.qa);
            }
            if (eVar.contact.field_deleteFlag == 1) {
                aVar3.jBR.setVisibility(0);
                aVar3.jBR.setText(context.getString(R.string.ghf));
            }
            if (!e.this.Qao && aVar3.jVP != null) {
                aVar3.jVP.setVisibility(8);
                if (as.bjp(eVar.username) && !Util.isNullOrNil(eVar.Qan)) {
                    aVar3.jVO.post(new Runnable() {
                        /* class com.tencent.mm.ui.contact.a.e.b.AnonymousClass1 */

                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Type inference failed for: r1v16, types: [java.lang.CharSequence] */
                        /* JADX WARNING: Unknown variable types count: 1 */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final void run() {
                            /*
                            // Method dump skipped, instructions count: 339
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.contact.a.e.b.AnonymousClass1.run():void");
                        }
                    });
                }
            }
            if (aVar2.Qab) {
                aVar3.gvv.setAlpha(0.3f);
                aVar3.jVO.setAlpha(0.3f);
                aVar3.jBR.setAlpha(0.3f);
                aVar3.jVQ.setAlpha(0.3f);
                if (aVar3.jVP != null) {
                    aVar3.jVP.setAlpha(0.3f);
                    AppMethodBeat.o(102945);
                    return;
                }
            } else {
                aVar3.gvv.setAlpha(1.0f);
                aVar3.jVO.setAlpha(1.0f);
                aVar3.jBR.setAlpha(1.0f);
                aVar3.jVQ.setAlpha(1.0f);
                if (aVar3.jVP != null) {
                    aVar3.jVP.setAlpha(1.0f);
                }
            }
            AppMethodBeat.o(102945);
        }

        @Override // com.tencent.mm.ui.contact.a.a.b
        public final boolean a(Context context, View view, a aVar) {
            AppMethodBeat.i(261609);
            if (e.this.lqW != null) {
                ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).updateTopHitsRank(e.this.query, e.this.lqW, 1);
            }
            AppMethodBeat.o(261609);
            return false;
        }
    }

    public class a extends a.C2110a {
        public ImageView Qas;
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

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.ui.contact.a.a
    public final void a(Context context, a.C2110a aVar) {
        String displayName;
        String str;
        boolean z;
        String substring;
        String str2;
        AppMethodBeat.i(102948);
        boolean z2 = true;
        if (this.lqW == null) {
            z2 = false;
        } else if (this.contact == null) {
            g.aAi();
            this.contact = ((l) g.af(l.class)).aSN().bjF(this.lqW.wVX);
            if (this.contact == null) {
                g.aAi();
                this.contact = ((l) g.af(l.class)).aSN().bjK(this.lqW.wVX);
            }
        }
        if (this.contact == null) {
            Log.i("MicroMsg.ContactDataItem", "filling dataItem Occur Error Contact is null, position=%d", Integer.valueOf(this.position));
            AppMethodBeat.o(102948);
            return;
        }
        this.username = this.contact.field_username;
        this.Qan = ((com.tencent.mm.openim.a.a) g.af(com.tencent.mm.openim.a.a.class)).bN(this.contact.field_openImAppid, this.contact.field_descWordingId);
        if (z2) {
            m mVar = this.lqW;
            as asVar = this.contact;
            String str3 = null;
            String str4 = null;
            boolean z3 = false;
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = false;
            Resources resources = context.getResources();
            if (asVar != null) {
                str = ((com.tencent.mm.plugin.messenger.a.b) g.af(com.tencent.mm.plugin.messenger.a.b.class)).b(asVar, asVar.field_username);
                switch (mVar.wVW) {
                    case 1:
                        z = false;
                        z6 = z;
                        z3 = true;
                        break;
                    case 2:
                        z = false;
                        z5 = true;
                        z6 = z;
                        z3 = true;
                        break;
                    case 3:
                        z = true;
                        z5 = true;
                        z6 = z;
                        z3 = true;
                        break;
                    case 4:
                        String str5 = asVar.fuR;
                        str3 = resources.getString(R.string.gfz);
                        z4 = true;
                        str4 = str5;
                        break;
                    case 5:
                        String str6 = asVar.field_nickname;
                        str3 = resources.getString(R.string.gg4);
                        z4 = true;
                        str4 = str6;
                        break;
                    case 6:
                        z5 = true;
                        String str62 = asVar.field_nickname;
                        str3 = resources.getString(R.string.gg4);
                        z4 = true;
                        str4 = str62;
                        break;
                    case 7:
                        z6 = true;
                        z5 = true;
                        String str622 = asVar.field_nickname;
                        str3 = resources.getString(R.string.gg4);
                        z4 = true;
                        str4 = str622;
                        break;
                    case 11:
                        z4 = true;
                        List<String> aym = ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).getFTSMainDB().aym(asVar.field_contactLabelIds);
                        StringBuffer stringBuffer = new StringBuffer();
                        String[] strArr = this.wWd.wWD;
                        for (String str7 : strArr) {
                            for (String str8 : aym) {
                                if (d.ayq(str8).contains(str7)) {
                                    stringBuffer.append(str8);
                                    stringBuffer.append(",");
                                }
                            }
                        }
                        stringBuffer.trimToSize();
                        if (stringBuffer.length() == 0) {
                            substring = "";
                        } else {
                            substring = stringBuffer.substring(0, stringBuffer.length() - 1);
                        }
                        str4 = substring;
                        str3 = resources.getString(R.string.gg8);
                        break;
                    case 15:
                        z4 = true;
                        String ajx = asVar.ajx();
                        if (Util.isNullOrNil(ajx)) {
                            ajx = asVar.field_username;
                        }
                        str4 = ajx;
                        str3 = resources.getString(R.string.gg9);
                        break;
                    case 16:
                        String str9 = mVar.content;
                        if (!Util.isNullOrNil(str9)) {
                            String[] split = str9.split(RecoveryFileLog.SPLITTER);
                            int length = split.length;
                            int i2 = 0;
                            while (true) {
                                if (i2 < length) {
                                    str2 = split[i2];
                                    if (!str2.startsWith(this.query)) {
                                        i2++;
                                    }
                                }
                            }
                        }
                        str2 = str9;
                        str3 = resources.getString(R.string.gg3);
                        z4 = true;
                        str4 = str2;
                        break;
                    case 17:
                    case 18:
                        String str10 = mVar.content;
                        str3 = resources.getString(R.string.gg1);
                        z4 = true;
                        str4 = str10;
                        break;
                }
            } else {
                str = null;
            }
            if (z3) {
                Log.d("MicroMsg.ContactDataItem", "highlight first line");
                this.jVL = com.tencent.mm.pluginsdk.ui.span.l.e(context, (CharSequence) str, com.tencent.mm.cb.a.aG(context, R.dimen.is));
                this.jVL = f.a(com.tencent.mm.plugin.fts.a.a.e.a(this.jVL, this.wWd, z5, z6)).wWu;
            } else {
                this.jVL = com.tencent.mm.pluginsdk.ui.span.l.e(context, (CharSequence) str, com.tencent.mm.cb.a.aG(context, R.dimen.is));
            }
            if (z4) {
                Log.d("MicroMsg.ContactDataItem", "highlight second line");
                this.hXr = com.tencent.mm.pluginsdk.ui.span.l.e(context, (CharSequence) str4, com.tencent.mm.cb.a.aG(context, R.dimen.hc));
                this.hXr = f.a(com.tencent.mm.plugin.fts.a.a.e.a(this.hXr, this.wWd, z5, z6)).wWu;
            } else {
                this.hXr = com.tencent.mm.pluginsdk.ui.span.l.e(context, (CharSequence) str4, com.tencent.mm.cb.a.aG(context, R.dimen.hc));
            }
            if (!Util.isNullOrNil(str3) && this.hXr != null) {
                this.hXr = TextUtils.concat(str3, this.hXr);
            }
            AppMethodBeat.o(102948);
            return;
        }
        if (Util.isNullOrNil(this.dFl)) {
            displayName = ((com.tencent.mm.plugin.messenger.a.b) g.af(com.tencent.mm.plugin.messenger.a.b.class)).b(this.contact);
        } else {
            displayName = ((com.tencent.mm.plugin.messenger.a.b) g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(this.contact.field_username, this.dFl);
        }
        this.jVL = com.tencent.mm.pluginsdk.ui.span.l.e(context, (CharSequence) displayName, com.tencent.mm.cb.a.aG(context, R.dimen.is));
        AppMethodBeat.o(102948);
    }

    @Override // com.tencent.mm.ui.contact.a.a
    public a.b bmx() {
        return this.Qaq;
    }

    public a.C2110a eOf() {
        return this.Qar;
    }
}
