package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.al.a.a;
import com.tencent.mm.al.a.b;
import com.tencent.mm.al.a.e;
import com.tencent.mm.al.a.k;
import com.tencent.mm.al.ag;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.v;
import java.util.HashMap;
import java.util.LinkedHashMap;

public final class b extends s<com.tencent.mm.al.a.a> implements b.a, MStorageEx.IOnStorageChange {
    private static float ppN = 0.1f;
    private long PaA = 0;
    private float Paq = -1.0f;
    private final int Par;
    private HashMap<a.EnumC0246a, Integer> Pas = new LinkedHashMap();
    private float Pat = -1.0f;
    private float Pau = -1.0f;
    private ColorStateList[] Pav = new ColorStateList[5];
    private c Paw = null;
    private HashMap<String, a> Pax;
    private boolean Pay = false;
    private boolean Paz = false;
    private c gzE = null;
    protected MMSlideDelView.g pkY;
    protected MMSlideDelView.c pkZ;
    protected MMSlideDelView.f pla;
    protected MMSlideDelView.d plb = MMSlideDelView.getItemStatusCallBack();
    private final String ppO;
    public final MMFragmentActivity wkt;

    /* renamed from: com.tencent.mm.ui.bizchat.b$b  reason: collision with other inner class name */
    public static class C2085b {
        public NoMeasuredTextView PaE;
        public NoMeasuredTextView PaF;
        public NoMeasuredTextView PaG;
        public ImageView PaH;
        public ImageView PaI;
        public View PaJ;
        public ImageView gvv;
        public TextView plf;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
    @Override // com.tencent.mm.ui.s
    public final /* bridge */ /* synthetic */ com.tencent.mm.al.a.a a(com.tencent.mm.al.a.a aVar, Cursor cursor) {
        AppMethodBeat.i(33912);
        com.tencent.mm.al.a.a a2 = a(aVar, cursor);
        AppMethodBeat.o(33912);
        return a2;
    }

    public b(Context context, s.a aVar, String str) {
        super(context, new com.tencent.mm.al.a.a());
        AppMethodBeat.i(33902);
        super.a(aVar);
        this.wkt = (MMFragmentActivity) context;
        this.ppO = str;
        this.Pax = new HashMap<>();
        this.Pav[0] = com.tencent.mm.cb.a.m(context, R.color.uj);
        this.Pav[1] = com.tencent.mm.cb.a.m(context, R.color.a0g);
        this.Pav[3] = com.tencent.mm.cb.a.m(context, R.color.a2x);
        this.Pav[2] = com.tencent.mm.cb.a.m(context, R.color.a0d);
        this.Pav[2] = com.tencent.mm.cb.a.m(context, R.color.a0d);
        this.Pav[4] = com.tencent.mm.cb.a.m(context, R.color.ww);
        this.Pas.put(a.EnumC0246a.iPr, Integer.valueOf((int) R.drawable.bso));
        this.Pas.put(a.EnumC0246a.DEPARTMENT, Integer.valueOf((int) R.drawable.bsp));
        this.Pas.put(a.EnumC0246a.EXTERNAL, Integer.valueOf((int) R.drawable.bsq));
        this.Par = com.tencent.mm.cb.a.fromDPToPix(context, 8);
        this.Paq = (float) com.tencent.mm.cb.a.aG(context, R.dimen.is);
        this.Pat = (float) com.tencent.mm.cb.a.aG(context, R.dimen.hc);
        this.Pau = (float) com.tencent.mm.cb.a.aG(context, R.dimen.kc);
        c.a aVar2 = new c.a();
        aVar2.prefixPath = e.fe(this.ppO);
        aVar2.jbf = true;
        aVar2.hZF = true;
        aVar2.jbq = R.raw.default_avatar;
        aVar2.iaT = true;
        aVar2.jbx = ppN * ((float) alQ(R.dimen.ij));
        this.gzE = aVar2.bdv();
        aVar2.jbx = ppN * ((float) alQ(R.dimen.f3065j));
        this.Paw = aVar2.bdv();
        AppMethodBeat.o(33902);
    }

    private int alQ(int i2) {
        AppMethodBeat.i(232768);
        int aH = com.tencent.mm.cb.a.aH(this.wkt, i2);
        AppMethodBeat.o(232768);
        return aH;
    }

    @Override // com.tencent.mm.ui.s
    public final Cursor getCursor() {
        AppMethodBeat.i(232769);
        Cursor cursor = super.getCursor();
        AppMethodBeat.o(232769);
        return cursor;
    }

    @Override // com.tencent.mm.ui.s
    public final void anp() {
        AppMethodBeat.i(33903);
        ebf();
        setCursor(ag.bak().NB(this.ppO));
        if (this.OFI != null) {
            this.OFI.bnE();
        }
        super.notifyDataSetChanged();
        AppMethodBeat.o(33903);
    }

    public final int getViewTypeCount() {
        return 1;
    }

    public final void setPerformItemClickListener(MMSlideDelView.g gVar) {
        this.pkY = gVar;
    }

    public final void a(MMSlideDelView.f fVar) {
        this.pla = fVar;
    }

    public final void setGetViewPositionCallback(MMSlideDelView.c cVar) {
        this.pkZ = cVar;
    }

    public final int getItemViewType(int i2) {
        return 0;
    }

    public final void onResume() {
        AppMethodBeat.i(232770);
        this.Pay = true;
        if (this.Paz) {
            super.onNotifyChange(null, null);
            this.Paz = false;
        }
        AppMethodBeat.o(232770);
    }

    public final void onPause() {
        AppMethodBeat.i(33904);
        if (this.plb != null) {
            this.plb.ebo();
        }
        this.Pay = false;
        AppMethodBeat.o(33904);
    }

    class a {
        public boolean PaB;
        public com.tencent.mm.al.a.a PaC;
        int gCw;
        String gqV;
        public boolean guh;
        String iAR;

        private a() {
            this.gqV = null;
            this.iAR = null;
            this.gCw = 0;
        }

        /* synthetic */ a(b bVar, byte b2) {
            this();
        }
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        C2085b bVar;
        C2085b bVar2;
        int i3;
        View inflate;
        AppMethodBeat.i(33905);
        com.tencent.mm.al.a.a aVar = (com.tencent.mm.al.a.a) getItem(i2);
        if (view != null) {
            bVar = (C2085b) view.getTag();
        } else {
            bVar = null;
        }
        if (view == null || bVar == null) {
            bVar2 = new C2085b();
            if (com.tencent.mm.cb.a.jk(this.wkt)) {
                inflate = View.inflate(this.wkt, R.layout.ye, null);
            } else {
                inflate = View.inflate(this.wkt, R.layout.yd, null);
            }
            bVar2.gvv = (ImageView) inflate.findViewById(R.id.x1);
            bVar2.PaE = (NoMeasuredTextView) inflate.findViewById(R.id.fzg);
            bVar2.PaF = (NoMeasuredTextView) inflate.findViewById(R.id.j0l);
            bVar2.PaG = (NoMeasuredTextView) inflate.findViewById(R.id.e7t);
            bVar2.plf = (TextView) inflate.findViewById(R.id.iot);
            bVar2.plf.setBackgroundResource(v.kH(this.wkt));
            bVar2.plf.setTextSize(0, ((float) com.tencent.mm.cb.a.aH(this.wkt, R.dimen.ane)) * com.tencent.mm.cb.a.ji(this.wkt));
            bVar2.PaH = (ImageView) inflate.findViewById(R.id.dwf);
            bVar2.PaJ = inflate.findViewById(R.id.x9);
            bVar2.PaI = (ImageView) inflate.findViewById(R.id.iif);
            inflate.setTag(bVar2);
            bVar2.PaG.setTextSize(0, this.Pat);
            bVar2.PaF.setTextSize(0, this.Pau);
            bVar2.PaE.setTextSize(0, this.Paq);
            bVar2.PaG.setTextColor(this.Pav[0]);
            bVar2.PaF.setTextColor(this.Pav[4]);
            bVar2.PaE.setTextColor(this.Pav[3]);
            bVar2.PaG.setShouldEllipsize(true);
            bVar2.PaF.setShouldEllipsize(false);
            bVar2.PaE.setShouldEllipsize(true);
            bVar2.PaF.setGravity(5);
            view = inflate;
        } else {
            bVar2 = bVar;
        }
        long j2 = aVar.field_bizChatId;
        a aVar2 = this.Pax.get(String.valueOf(j2));
        if (aVar2 == null) {
            aVar2 = new a(this, (byte) 0);
            com.tencent.mm.al.a.c bs = ag.baj().bs(j2);
            if (bs.isGroup()) {
                aVar2.gqV = bs.field_chatName;
                aVar2.guh = bs.iE(1);
                aVar2.iAR = bs.field_headImageUrl;
            } else {
                k fB = ag.bal().fB(bs.field_bizChatServId);
                if (fB != null) {
                    aVar2.gqV = fB.field_userName;
                    aVar2.guh = fB.iE(1);
                    aVar2.iAR = fB.field_headImageUrl;
                }
            }
            if (Util.isNullOrNil(aVar2.gqV)) {
                aVar2.gqV = this.wkt.getString(R.string.g7f);
            }
            aVar2.gCw = bs.field_roomflag;
            aVar2.PaC = aVar;
            this.Pax.put(String.valueOf(j2), aVar2);
        }
        ag.bak();
        aVar2.PaB = com.tencent.mm.al.a.b.c(aVar);
        bVar2.PaI.setVisibility(8);
        bVar2.PaF.setText(aVar2.PaC.field_status == 1 ? this.wkt.getString(R.string.evg) : f.c(this.wkt, aVar2.PaC.field_lastMsgTime, true));
        if (com.tencent.mm.cb.a.jk(this.wkt)) {
            q.bcV().a(aVar2.iAR, bVar2.gvv, this.Paw);
        } else {
            q.bcV().a(aVar2.iAR, bVar2.gvv, this.gzE);
        }
        if (aVar2.guh) {
            bVar2.PaH.setVisibility(0);
        } else {
            bVar2.PaH.setVisibility(8);
        }
        bVar2.PaE.setText(l.e((Context) this.wkt, (CharSequence) aVar2.gqV, (int) bVar2.PaE.getTextSize()));
        CharSequence a2 = a(aVar2.PaC, (int) bVar2.PaG.getTextSize(), aVar2.gqV);
        switch (aVar2.PaC.field_status) {
            case 0:
                i3 = -1;
                break;
            case 1:
                i3 = R.raw.msg_state_sending;
                break;
            case 2:
                i3 = -1;
                break;
            case 3:
            case 4:
            default:
                i3 = -1;
                break;
            case 5:
                i3 = R.raw.msg_state_failed;
                break;
        }
        Integer num = this.Pas.get(a.EnumC0246a.sQ(aVar2.gCw));
        if (num != null) {
            bVar2.PaE.setCompoundDrawablePadding(this.Par);
            bVar2.PaE.setCompoundRightDrawablesWithIntrinsicBounds(num.intValue());
            bVar2.PaE.setDrawRightDrawable(true);
        } else {
            bVar2.PaE.setDrawRightDrawable(false);
        }
        if (i3 != -1) {
            bVar2.PaG.setCompoundLeftDrawablesWithIntrinsicBounds(i3);
            bVar2.PaG.setDrawLeftDrawable(true);
        } else {
            bVar2.PaG.setDrawLeftDrawable(false);
        }
        bVar2.PaG.setText(a2);
        bVar2.PaG.setTextColor(com.tencent.mm.cb.a.m(this.wkt, R.color.a0f));
        if (ahn(aVar2.PaC.field_msgType) == 34 && aVar2.PaC.field_isSend == 0 && !Util.isNullOrNil(aVar2.PaC.field_content) && !new p(aVar2.PaC.field_content).jsi) {
            bVar2.PaG.setTextColor(com.tencent.mm.cb.a.m(this.wkt, R.color.a0g));
        }
        if (aVar2.guh) {
            if (aVar2.PaC.field_unReadCount > 0) {
                bVar2.PaJ.setVisibility(0);
            } else {
                bVar2.PaJ.setVisibility(4);
            }
            bVar2.plf.setVisibility(4);
        } else {
            bVar2.PaJ.setVisibility(4);
            if (aVar2.PaC.field_unReadCount > 99) {
                bVar2.plf.setText("");
                bVar2.plf.setBackgroundResource(R.raw.badge_count_more);
                bVar2.plf.setVisibility(0);
                Log.v("MicroMsg.BizChatConversationAdapter", "has unread 100");
            } else if (aVar2.PaC.field_unReadCount > 0) {
                bVar2.plf.setText(new StringBuilder().append(aVar2.PaC.field_unReadCount).toString());
                bVar2.plf.setVisibility(0);
                bVar2.plf.setBackgroundResource(v.aQ(this.wkt, aVar2.PaC.field_unReadCount));
                Log.v("MicroMsg.BizChatConversationAdapter", "has unread");
            } else {
                bVar2.plf.setVisibility(4);
                Log.v("MicroMsg.BizChatConversationAdapter", "no unread");
            }
        }
        if (aVar2.PaB) {
            view.findViewById(R.id.bg1).setBackgroundResource(R.drawable.q_);
        } else {
            view.findViewById(R.id.bg1).setBackgroundResource(R.drawable.qa);
        }
        AppMethodBeat.o(33905);
        return view;
    }

    private static String bmp(String str) {
        AppMethodBeat.i(33906);
        if (str == null || str.length() != 32) {
            AppMethodBeat.o(33906);
            return null;
        }
        String amp = ((d) g.ah(d.class)).getEmojiMgr().amp(str);
        AppMethodBeat.o(33906);
        return amp;
    }

    private CharSequence a(com.tencent.mm.al.a.a aVar, int i2, String str) {
        String str2;
        AppMethodBeat.i(33907);
        if (Util.isNullOrNil(aVar.field_editingMsg) || ((aVar.field_atCount > 0 || aVar.field_atAll > 0) && aVar.field_unReadCount > 0)) {
            if (aVar.field_msgType != null && (aVar.field_msgType.equals("47") || aVar.field_msgType.equals("1048625"))) {
                String bmp = bmp(aVar.field_digest);
                String str3 = "";
                if (bmp != null) {
                    String str4 = "[" + bmp + "]";
                    AppMethodBeat.o(33907);
                    return str4;
                }
                if (aVar.field_digest != null && aVar.field_digest.contains(":")) {
                    str3 = aVar.field_digest.substring(0, aVar.field_digest.indexOf(":"));
                    String bmp2 = bmp(aVar.field_digest.substring(aVar.field_digest.indexOf(":") + 1).replace(" ", ""));
                    if (bmp2 != null) {
                        String str5 = "[" + bmp2 + "]";
                        if (Util.isNullOrNil(str3)) {
                            AppMethodBeat.o(33907);
                            return str5;
                        }
                        String str6 = str3 + ": " + str5;
                        AppMethodBeat.o(33907);
                        return str6;
                    }
                }
                String string = this.wkt.getString(R.string.tu);
                aVar.field_digest = Util.isNullOrNil(str3) ? string : str3 + ": " + string;
            }
            if (Util.isNullOrNil(aVar.field_digest)) {
                str2 = "";
            } else if (!Util.isNullOrNil(aVar.field_digestUser)) {
                try {
                    str2 = String.format(aVar.field_digest, str);
                } catch (Exception e2) {
                    str2 = aVar.field_digest;
                }
            } else {
                str2 = aVar.field_digest;
            }
            String replace = str2.replace('\n', ' ');
            if ((aVar.field_atCount > 0 || aVar.field_atAll > 0) && aVar.field_unReadCount > 0) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                if (aVar.field_atCount > 0) {
                    spannableStringBuilder.append((CharSequence) this.wkt.getString(R.string.euh));
                }
                if (aVar.field_atAll > 0) {
                    spannableStringBuilder.append((CharSequence) this.wkt.getString(R.string.eug));
                }
                spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
                spannableStringBuilder.append((CharSequence) " ").append((CharSequence) l.e((Context) this.wkt, (CharSequence) replace, i2));
                AppMethodBeat.o(33907);
                return spannableStringBuilder;
            }
            SpannableString e3 = l.e((Context) this.wkt, (CharSequence) replace, i2);
            AppMethodBeat.o(33907);
            return e3;
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.wkt.getString(R.string.euq));
        spannableStringBuilder2.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder2.length(), 33);
        spannableStringBuilder2.append((CharSequence) " ").append((CharSequence) l.e((Context) this.wkt, (CharSequence) aVar.field_editingMsg, i2));
        AppMethodBeat.o(33907);
        return spannableStringBuilder2;
    }

    private static int ahn(String str) {
        int i2 = 1;
        AppMethodBeat.i(33908);
        if (str != null && str.length() > 0) {
            try {
                i2 = Integer.valueOf(str).intValue();
            } catch (NumberFormatException e2) {
            }
        }
        AppMethodBeat.o(33908);
        return i2;
    }

    @Override // com.tencent.mm.ui.s
    public final void anq() {
        AppMethodBeat.i(33909);
        anp();
        AppMethodBeat.o(33909);
    }

    public final com.tencent.mm.al.a.a a(com.tencent.mm.al.a.a aVar, Cursor cursor) {
        AppMethodBeat.i(232771);
        if (aVar == null) {
            aVar = new com.tencent.mm.al.a.a();
            this.PaA = aVar.field_bizChatId;
        }
        aVar.field_bizChatId = this.PaA;
        aVar.convertFrom(cursor);
        AppMethodBeat.o(232771);
        return aVar;
    }

    @Override // com.tencent.mm.al.a.b.a
    public final void a(b.a.C0248b bVar) {
        AppMethodBeat.i(232772);
        gLY();
        AppMethodBeat.o(232772);
    }

    @Override // com.tencent.mm.ui.s, com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(33910);
        super.onNotifyChange(i2, mStorageEx, obj);
        AppMethodBeat.o(33910);
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange, com.tencent.mm.ui.s
    public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        AppMethodBeat.i(232773);
        gLY();
        AppMethodBeat.o(232773);
    }

    private void gLY() {
        AppMethodBeat.i(232774);
        if (this.Pay) {
            super.onNotifyChange(null, null);
            AppMethodBeat.o(232774);
            return;
        }
        this.Paz = true;
        AppMethodBeat.o(232774);
    }

    public final void Np(long j2) {
        AppMethodBeat.i(33911);
        if (this.Pax != null) {
            this.Pax.remove(String.valueOf(j2));
        }
        AppMethodBeat.o(33911);
    }

    public final void onDestroy() {
        AppMethodBeat.i(232775);
        if (this.Pax != null) {
            this.Pax.clear();
            this.Pax = null;
        }
        ag.bak().remove(this);
        ag.bak().a(this);
        AppMethodBeat.o(232775);
    }
}
