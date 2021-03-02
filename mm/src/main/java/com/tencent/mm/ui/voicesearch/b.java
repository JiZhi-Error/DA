package com.tencent.mm.ui.voicesearch;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.o;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.drr;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.applet.b;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.z;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"DefaultLocale"})
public final class b extends s<as> implements i {
    public String BZP;
    public String PSf;
    public String[] Paj;
    private boolean QBi = false;
    private as QBj = null;
    private boolean QBk = true;
    public boolean QBl = false;
    private boolean QBm = false;
    private Context context;
    private int dDG = 1;
    private ProgressDialog gtM = null;
    private List<String> gzY = null;
    private LinkedList<drr> iAd = new LinkedList<>();
    public com.tencent.mm.ui.applet.b kex = new com.tencent.mm.ui.applet.b(new b.a() {
        /* class com.tencent.mm.ui.voicesearch.b.AnonymousClass1 */

        @Override // com.tencent.mm.ui.applet.b.a
        public final Bitmap Ta(String str) {
            AppMethodBeat.i(39532);
            Bitmap a2 = c.a(str, false, -1, null);
            AppMethodBeat.o(39532);
            return a2;
        }
    });
    private b.AbstractC2078b kez = null;

    protected static class a {
        public TextView Fxp;
        public ProgressBar QBq;
        public MaskLayout gAN;
        public TextView gwR;
        public CheckBox jVQ;
        public TextView yuS;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.ui.s
    public final /* synthetic */ as getItem(int i2) {
        AppMethodBeat.i(39566);
        as Ln = Ln(i2);
        AppMethodBeat.o(39566);
        return Ln;
    }

    static /* synthetic */ void a(b bVar, Cursor cursor) {
        AppMethodBeat.i(39569);
        bVar.setCursor(cursor);
        AppMethodBeat.o(39569);
    }

    static /* synthetic */ void b(b bVar, Cursor cursor) {
        AppMethodBeat.i(39570);
        bVar.setCursor(cursor);
        AppMethodBeat.o(39570);
    }

    static /* synthetic */ void c(b bVar, Cursor cursor) {
        AppMethodBeat.i(39571);
        bVar.setCursor(cursor);
        AppMethodBeat.o(39571);
    }

    static /* synthetic */ void d(b bVar, Cursor cursor) {
        AppMethodBeat.i(39572);
        bVar.setCursor(cursor);
        AppMethodBeat.o(39572);
    }

    static /* synthetic */ int e(b bVar) {
        AppMethodBeat.i(39568);
        int realCount = bVar.getRealCount();
        AppMethodBeat.o(39568);
        return realCount;
    }

    static /* synthetic */ void e(b bVar, Cursor cursor) {
        AppMethodBeat.i(39573);
        bVar.setCursor(cursor);
        AppMethodBeat.o(39573);
    }

    public b(Context context2, int i2) {
        super(context2, new as());
        AppMethodBeat.i(39544);
        this.context = context2;
        this.dDG = i2;
        this.QBj = new as();
        this.QBj.setUsername("_find_more_public_contact_");
        this.QBj.aqZ();
        this.PSf = "@micromsg.with.all.biz.qq.com";
        AppMethodBeat.o(39544);
    }

    public final void jB(final List<String> list) {
        AppMethodBeat.i(39545);
        aO(new Runnable() {
            /* class com.tencent.mm.ui.voicesearch.b.AnonymousClass5 */

            public final void run() {
                AppMethodBeat.i(39536);
                if (b.this.gzY == null) {
                    b.this.gzY = new ArrayList();
                }
                b.this.gzY.clear();
                b.this.gzY.addAll(list);
                b.this.gzY.add("officialaccounts");
                b.this.gzY.add("helper_entry");
                AppMethodBeat.o(39536);
            }
        });
        AppMethodBeat.o(39545);
    }

    public final void CQ(boolean z) {
        AppMethodBeat.i(39546);
        this.QBl = z;
        if (z) {
            this.QBj.aqZ();
        }
        AppMethodBeat.o(39546);
    }

    public final void detach() {
        AppMethodBeat.i(39547);
        if (this.kex != null) {
            this.kex.detach();
            this.kex = null;
        }
        AppMethodBeat.o(39547);
    }

    public final int getViewTypeCount() {
        return 3;
    }

    public final int getItemViewType(int i2) {
        AppMethodBeat.i(39548);
        if (this.dDG == 2) {
            AppMethodBeat.o(39548);
            return 2;
        } else if (aot(i2)) {
            AppMethodBeat.o(39548);
            return 1;
        } else {
            AppMethodBeat.o(39548);
            return 0;
        }
    }

    @Override // com.tencent.mm.ui.s
    public final int dWu() {
        int i2 = 0;
        AppMethodBeat.i(39549);
        if (this.QBi) {
            if (!this.QBj.isHidden()) {
                i2 = this.iAd.size();
            }
            int i3 = i2 + 1;
            AppMethodBeat.o(39549);
            return i3;
        }
        AppMethodBeat.o(39549);
        return 0;
    }

    public final drr aos(int i2) {
        AppMethodBeat.i(39550);
        try {
            Log.d("MicroMsg.SearchResultAdapter", "position " + i2 + " size " + this.iAd.size() + "  " + (i2 - getRealCount()));
            drr drr = this.iAd.get((i2 - getRealCount()) - 1);
            AppMethodBeat.o(39550);
            return drr;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.SearchResultAdapter", e2, "", new Object[0]);
            AppMethodBeat.o(39550);
            return null;
        }
    }

    public final as Ln(int i2) {
        AppMethodBeat.i(39551);
        if (Ox(i2)) {
            as asVar = (as) dWw();
            AppMethodBeat.o(39551);
            return asVar;
        }
        as asVar2 = (as) super.getItem(i2);
        AppMethodBeat.o(39551);
        return asVar2;
    }

    public final void CR(final boolean z) {
        AppMethodBeat.i(39552);
        aO(new Runnable() {
            /* class com.tencent.mm.ui.voicesearch.b.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(39537);
                b.this.QBi = z;
                AppMethodBeat.o(39537);
            }
        });
        AppMethodBeat.o(39552);
    }

    public final void boh(final String str) {
        AppMethodBeat.i(39553);
        aO(new Runnable() {
            /* class com.tencent.mm.ui.voicesearch.b.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(39538);
                if (b.this.QBj.isHidden()) {
                    b.this.QBj.ara();
                    if (b.this.QBk) {
                        bg.azz().a(new f(str, 3), 0);
                        b.this.QBm = true;
                        AppMethodBeat.o(39538);
                        return;
                    }
                } else {
                    b.this.QBj.aqZ();
                }
                AppMethodBeat.o(39538);
            }
        });
        AppMethodBeat.o(39553);
    }

    public final boolean aot(int i2) {
        int realCount;
        AppMethodBeat.i(39554);
        if (!this.QBi || i2 != (realCount = getRealCount()) || i2 >= realCount + dWu()) {
            AppMethodBeat.o(39554);
            return false;
        }
        AppMethodBeat.o(39554);
        return true;
    }

    public final boolean isEnabled(int i2) {
        AppMethodBeat.i(39555);
        if (!aot(i2) || (!(this.iAd == null || this.iAd.size() == 0) || this.QBk)) {
            AppMethodBeat.o(39555);
            return true;
        }
        AppMethodBeat.o(39555);
        return false;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        a aVar2;
        a aVar3;
        a aVar4;
        AppMethodBeat.i(39556);
        boolean Ox = Ox(i2);
        boolean aot = aot(i2);
        if (this.QBi && Ox) {
            if (view != null) {
                a aVar5 = (a) view.getTag();
                if (aot && aVar5.QBq == null) {
                    view = null;
                }
            }
            if (view != null) {
                aVar4 = (a) view.getTag();
            } else if (aot) {
                view = View.inflate(this.context, R.layout.wb, null);
                aVar4 = new a();
                aVar4.gwR = (TextView) view.findViewById(R.id.bdw);
                aVar4.QBq = (ProgressBar) view.findViewById(R.id.het);
                view.setTag(aVar4);
            } else {
                view = View.inflate(this.context, R.layout.xw, null);
                aVar4 = new a();
                aVar4.yuS = (TextView) view.findViewById(R.id.bdr);
                aVar4.gAN = (MaskLayout) view.findViewById(R.id.bdo);
                aVar4.gwR = (TextView) view.findViewById(R.id.bdw);
                aVar4.jVQ = (CheckBox) view.findViewById(R.id.bdy);
                aVar4.Fxp = (TextView) view.findViewById(R.id.bdm);
                view.setTag(aVar4);
            }
            if (!aot) {
                if (this.kez == null) {
                    this.kez = new b.AbstractC2078b() {
                        /* class com.tencent.mm.ui.voicesearch.b.AnonymousClass8 */

                        @Override // com.tencent.mm.ui.applet.b.AbstractC2078b
                        public final String vg(int i2) {
                            AppMethodBeat.i(39539);
                            if (i2 < 0) {
                                Log.e("MicroMsg.SearchResultAdapter", "pos is invalid");
                                AppMethodBeat.o(39539);
                                return null;
                            }
                            b bVar = b.this;
                            drr aos = bVar.aos(b.e(bVar) + i2 + 1);
                            if (aos == null) {
                                AppMethodBeat.o(39539);
                                return null;
                            }
                            String str = aos.Lqk.MTo;
                            AppMethodBeat.o(39539);
                            return str;
                        }

                        @Override // com.tencent.mm.ui.applet.b.AbstractC2078b
                        public final int bnW() {
                            AppMethodBeat.i(39540);
                            if (b.this.iAd == null) {
                                AppMethodBeat.o(39540);
                                return 0;
                            }
                            int size = b.this.iAd.size();
                            AppMethodBeat.o(39540);
                            return size;
                        }
                    };
                }
                if (this.kex != null) {
                    this.kex.a((i2 - getRealCount()) - 1, this.kez);
                }
                drr aos = aos(i2);
                aVar4.yuS.setVisibility(8);
                if (aos == null) {
                    AppMethodBeat.o(39556);
                    return view;
                }
                aVar4.Fxp.setVisibility(8);
                a.b.c((ImageView) aVar4.gAN.getContentView(), aos.Lqk.MTo);
                if (aos.MmK == 0) {
                    aVar4.gAN.setMaskDrawable(null);
                } else if (ay.a.iDs != null) {
                    String rW = ay.a.iDs.rW(aos.MmK);
                    if (rW != null) {
                        aVar4.gAN.a(o.Nw(rW), MaskLayout.a.SUBSCRIPT_DRAWABLE_DIRECTION_BOTTOM_RIGHT);
                    } else {
                        aVar4.gAN.setMaskDrawable(null);
                    }
                } else {
                    aVar4.gAN.setMaskDrawable(null);
                }
                try {
                    aVar4.gwR.setText(l.b(this.context, Util.nullAsNil(aos.Mjj.MTo), aVar4.gwR.getTextSize()));
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.SearchResultAdapter", e2, "", new Object[0]);
                    aVar4.gwR.setText("");
                }
            } else {
                if (this.QBm) {
                    aVar4.QBq.setVisibility(0);
                } else {
                    aVar4.QBq.setVisibility(8);
                }
                Log.d("MicroMsg.SearchResultAdapter", "refresh  " + this.QBk);
                if ((this.iAd == null || this.iAd.size() == 0) && !this.QBk) {
                    aVar4.gwR.setText(this.context.getString(R.string.fi));
                    aVar4.gwR.setTextColor(this.context.getResources().getColor(R.color.wx));
                } else {
                    aVar4.gwR.setText(this.context.getString(R.string.fj));
                    aVar4.gwR.setTextColor(com.tencent.mm.cb.a.m(this.context, R.color.a0b));
                }
            }
            AppMethodBeat.o(39556);
            return view;
        } else if (this.dDG == 2) {
            if (view == null) {
                view = View.inflate(this.context, R.layout.c6h, null);
                a aVar6 = new a();
                aVar6.gwR = (TextView) view.findViewById(R.id.bdw);
                view.setTag(aVar6);
                aVar3 = aVar6;
            } else {
                aVar3 = (a) view.getTag();
            }
            as Ln = Ln(i2);
            aVar3.gwR.setTextColor(com.tencent.mm.cb.a.m(this.context, R.color.a0b));
            try {
                aVar3.gwR.setText(l.b(this.context, this.context.getString(R.string.i05, aa.b(Ln, Ln.field_username)), aVar3.gwR.getTextSize()));
            } catch (Exception e3) {
                aVar3.gwR.setText("");
            }
            aVar3.gwR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            AppMethodBeat.o(39556);
            return view;
        } else {
            if (view != null) {
                aVar = (a) view.getTag();
                view2 = aVar == null ? null : view;
            } else {
                aVar = null;
                view2 = view;
            }
            if (view2 == null) {
                view2 = com.tencent.mm.ui.aa.jQ(this.context).inflate(R.layout.xw, (ViewGroup) null);
                aVar2 = new a();
                aVar2.yuS = (TextView) view2.findViewById(R.id.bdr);
                aVar2.gAN = (MaskLayout) view2.findViewById(R.id.bdo);
                aVar2.gwR = (TextView) view2.findViewById(R.id.bdw);
                aVar2.jVQ = (CheckBox) view2.findViewById(R.id.bdy);
                aVar2.Fxp = (TextView) view2.findViewById(R.id.bdm);
                view2.setTag(aVar2);
            } else {
                aVar2 = aVar;
            }
            as Ln2 = Ln(i2);
            if (aVar2.yuS != null) {
                aVar2.yuS.setVisibility(8);
            }
            aVar2.gwR.setTextColor(com.tencent.mm.cb.a.m(this.context, !ab.JE(Ln2.field_username) ? R.color.a0b : R.color.a0c));
            a.b.c((ImageView) aVar2.gAN.getContentView(), Ln2.field_username);
            aVar2.Fxp.setVisibility(8);
            if (Ln2.field_verifyFlag == 0) {
                aVar2.gAN.setMaskDrawable(null);
            } else if (ay.a.iDs != null) {
                String rW2 = ay.a.iDs.rW(Ln2.field_verifyFlag);
                if (rW2 != null) {
                    aVar2.gAN.a(o.Nw(rW2), MaskLayout.a.SUBSCRIPT_DRAWABLE_DIRECTION_BOTTOM_RIGHT);
                } else {
                    aVar2.gAN.setMaskDrawable(null);
                }
            } else {
                aVar2.gAN.setMaskDrawable(null);
            }
            try {
                SpannableString e4 = l.e(this.context, (CharSequence) aa.getDisplayName(Ln2.field_username), (int) aVar2.gwR.getTextSize());
                if (ab.Iz(Ln2.field_username)) {
                    aVar2.gwR.setText(((com.tencent.mm.openim.a.a) g.af(com.tencent.mm.openim.a.a.class)).a(this.context, e4));
                } else {
                    aVar2.gwR.setText(e4);
                }
            } catch (Exception e5) {
                aVar2.gwR.setText("");
            }
            AppMethodBeat.o(39556);
            return view2;
        }
    }

    @Override // com.tencent.mm.ui.s
    public final void anp() {
        AppMethodBeat.i(39557);
        vw(false);
        AppMethodBeat.o(39557);
    }

    public final void vw(final boolean z) {
        AppMethodBeat.i(39558);
        aO(new Runnable() {
            /* class com.tencent.mm.ui.voicesearch.b.AnonymousClass9 */

            public final void run() {
                Cursor a2;
                Cursor cursor;
                AppMethodBeat.i(39541);
                if (b.this.Paj != null && b.this.Paj.length != 0) {
                    ArrayList arrayList = new ArrayList();
                    String[] strArr = b.this.Paj;
                    for (String str : strArr) {
                        if (b.this.boj(str)) {
                            arrayList.add(str);
                        }
                    }
                    if (arrayList.size() > 0) {
                        b bVar = b.this;
                        bg.aVF();
                        b.a(bVar, com.tencent.mm.model.c.aSN().a((String[]) arrayList.toArray(new String[arrayList.size()]), b.this.PSf, b.this.gzY));
                        AppMethodBeat.o(39541);
                        return;
                    }
                    b bVar2 = b.this;
                    bg.aVF();
                    b.b(bVar2, com.tencent.mm.model.c.aSN().gCo());
                    AppMethodBeat.o(39541);
                } else if (b.this.BZP == null) {
                    b bVar3 = b.this;
                    bg.aVF();
                    b.e(bVar3, com.tencent.mm.model.c.aSN().gCo());
                    AppMethodBeat.o(39541);
                } else if (!b.this.PSf.equals("@all.chatroom.contact")) {
                    b.c(b.this, bg.aVF().iBp.a(b.this.BZP, b.this.PSf, b.this.gzY, true));
                    AppMethodBeat.o(39541);
                } else {
                    if (z) {
                        a2 = bg.aVF().iBp.a(b.this.BZP, "@micromsg.with.all.biz.qq.com.openim", b.this.gzY, false);
                    } else {
                        a2 = bg.aVF().iBp.a(b.this.BZP, "@micromsg.with.all.biz.qq.com", b.this.gzY, false);
                    }
                    ArrayList<String> arrayList2 = new ArrayList<>();
                    ArrayList<String> arrayList3 = new ArrayList<>();
                    while (a2.moveToNext()) {
                        String string = a2.getString(a2.getColumnIndex(ch.COL_USERNAME));
                        if (!ab.Iw(string)) {
                            arrayList2.add(string);
                        } else {
                            arrayList3.add(string);
                        }
                    }
                    if (!a2.isClosed()) {
                        a2.close();
                    }
                    if (arrayList2.size() == 0 && arrayList3.size() == 0) {
                        bg.aVF();
                        cursor = com.tencent.mm.model.c.aSN().gCo();
                    } else {
                        cursor = bg.aVF().iBp.a(b.this.BZP, arrayList2, null, arrayList3, b.this.gzY);
                    }
                    b.d(b.this, cursor);
                    AppMethodBeat.o(39541);
                }
            }
        });
        AppMethodBeat.o(39558);
    }

    @Override // com.tencent.mm.ui.s
    public final void anq() {
        AppMethodBeat.i(39559);
        ebf();
        vw(false);
        AppMethodBeat.o(39559);
    }

    public final void onResume() {
        AppMethodBeat.i(39560);
        bg.azz().a(106, this);
        AppMethodBeat.o(39560);
    }

    public final void onPause() {
        AppMethodBeat.i(39561);
        bg.azz().b(106, this);
        AppMethodBeat.o(39561);
    }

    public static String boi(String str) {
        AppMethodBeat.i(39562);
        String trim = str.trim();
        if (trim.startsWith("@")) {
            trim = trim.substring(1) + "%@micromsg.with.all.biz.qq.com";
        }
        Log.d("MicroMsg.SearchResultAdapter", "translateQueryText [" + trim + "]");
        AppMethodBeat.o(39562);
        return trim;
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, final q qVar) {
        AppMethodBeat.i(39563);
        Log.d("MicroMsg.SearchResultAdapter", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (qVar.getType() != 106) {
            Log.e("MicroMsg.SearchResultAdapter", "error type");
            AppMethodBeat.o(39563);
            return;
        }
        if (this.gtM != null) {
            this.gtM.dismiss();
            this.gtM = null;
        }
        this.QBm = false;
        if (z.a.a(this.context, i2, i3, str, 7)) {
            this.QBk = false;
            AppMethodBeat.o(39563);
        } else if (i2 == 4 && i3 == -4) {
            aO(new Runnable() {
                /* class com.tencent.mm.ui.voicesearch.b.AnonymousClass11 */

                public final void run() {
                    AppMethodBeat.i(39543);
                    b.this.QBk = false;
                    AppMethodBeat.o(39543);
                }
            });
            AppMethodBeat.o(39563);
        } else if (i2 == 0 && i3 == 0) {
            aO(new Runnable() {
                /* class com.tencent.mm.ui.voicesearch.b.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(39534);
                    drt eiq = ((f) qVar).eiq();
                    Log.d("MicroMsg.SearchResultAdapter", "count " + eiq.LUB);
                    if (eiq.LUB > 0) {
                        for (drr drr : eiq.LUC) {
                            if (ab.rR(drr.MmK)) {
                                if (b.this.iAd == null) {
                                    b.this.iAd = new LinkedList();
                                }
                                b.this.iAd.add(drr);
                            }
                        }
                    } else {
                        String a2 = com.tencent.mm.platformtools.z.a(eiq.Lqk);
                        Log.d("MicroMsg.SearchResultAdapter", "user ".concat(String.valueOf(a2)));
                        if (Util.nullAsNil(a2).length() > 0) {
                            drr drr2 = new drr();
                            drr2.Lqk = eiq.Lqk;
                            drr2.MmK = eiq.MmK;
                            drr2.keb = eiq.keb;
                            drr2.Mjj = eiq.Mjj;
                            drr2.ked = eiq.ked;
                            drr2.keh = eiq.keh;
                            drr2.kea = eiq.kea;
                            drr2.kdZ = eiq.kdZ;
                            drr2.kdY = eiq.kdY;
                            drr2.MmL = eiq.MmL;
                            drr2.MmO = eiq.MmO;
                            drr2.MmM = eiq.MmM;
                            drr2.MmN = eiq.MmN;
                            drr2.MmQ = eiq.MmQ;
                            p.aYn().h(a2, com.tencent.mm.platformtools.z.a(eiq.KHp));
                            if (b.this.iAd == null) {
                                b.this.iAd = new LinkedList();
                            }
                            b.this.iAd.clear();
                            if (ab.rR(drr2.MmK)) {
                                b.this.iAd.add(drr2);
                            }
                            Log.d("MicroMsg.SearchResultAdapter", "count " + b.this.iAd.size());
                        }
                    }
                    b.this.QBk = false;
                    AppMethodBeat.o(39534);
                }
            });
            AppMethodBeat.o(39563);
        } else {
            aO(new Runnable() {
                /* class com.tencent.mm.ui.voicesearch.b.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(39533);
                    b.this.QBk = false;
                    AppMethodBeat.o(39533);
                }
            });
            AppMethodBeat.o(39563);
        }
    }

    public final void aO(final Runnable runnable) {
        AppMethodBeat.i(39564);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
            notifyDataSetChanged();
            AppMethodBeat.o(39564);
            return;
        }
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.ui.voicesearch.b.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(39535);
                runnable.run();
                b.this.notifyDataSetChanged();
                AppMethodBeat.o(39535);
            }
        });
        AppMethodBeat.o(39564);
    }

    public final boolean boj(String str) {
        AppMethodBeat.i(39565);
        if (!(this.gzY == null || str == null)) {
            for (String str2 : this.gzY) {
                if (str2.equals(str)) {
                    AppMethodBeat.o(39565);
                    return false;
                }
            }
        }
        AppMethodBeat.o(39565);
        return true;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
    @Override // com.tencent.mm.ui.s
    public final /* synthetic */ as a(as asVar, Cursor cursor) {
        AppMethodBeat.i(39567);
        bg.aVF();
        as bjF = com.tencent.mm.model.c.aSN().bjF(as.p(cursor));
        if (bjF == null) {
            bjF = new as();
            bjF.convertFrom(cursor);
            bg.aVF();
            com.tencent.mm.model.c.aSN().am(bjF);
        }
        AppMethodBeat.o(39567);
        return bjF;
    }
}
