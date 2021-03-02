package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.database.MergeCursor;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.format.Time;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.u;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.ci;
import com.tencent.mm.ui.a.a;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class e extends s<az> implements MStorageEx.IOnStorageChange {
    private static long QbY = 2000;
    boolean EqF = false;
    private float Paq = -1.0f;
    protected float Pat = -1.0f;
    private float Pau = -1.0f;
    private ColorStateList[] Pav = new ColorStateList[5];
    HashMap<String, d> Pax;
    private boolean Pay = false;
    private boolean Paz = false;
    private boolean QbL = true;
    private f QbM;
    private com.tencent.mm.pluginsdk.ui.e QbN;
    private boolean QbO = false;
    private boolean QbP = false;
    private c QbQ;
    private IListener QbR = null;
    private b QbS = null;
    public String QbT = "";
    final C2113e QbU = new C2113e();
    private final int QbV;
    private final int QbW;
    private a QbX;
    private boolean QbZ = false;
    private MTimerHandler Qca = new MTimerHandler(bg.aAk().getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.ui.conversation.e.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(38300);
            if (e.this.QbZ) {
                e.e(e.this);
            }
            AppMethodBeat.o(38300);
            return false;
        }
    }, false);
    protected List<String> gzY = null;
    private String kdi;
    private boolean khr = false;
    protected MMSlideDelView.g pkY;
    protected MMSlideDelView.c pkZ;
    protected MMSlideDelView.f pla;
    protected MMSlideDelView.d plb = MMSlideDelView.getItemStatusCallBack();

    public interface b {
    }

    public interface f {
    }

    public static class g {
        public NoMeasuredTextView PaE;
        public NoMeasuredTextView PaF;
        public NoMeasuredTextView PaG;
        public ImageView PaH;
        public ImageView PaI;
        public View PaJ;
        public NoMeasuredTextView Qcr;
        public ImageView Qcs;
        public ImageView gvv;
        public TextView plf;
    }

    static /* synthetic */ void e(e eVar) {
        AppMethodBeat.i(38322);
        eVar.gVq();
        AppMethodBeat.o(38322);
    }

    static /* synthetic */ void g(e eVar) {
        AppMethodBeat.i(38323);
        super.onNotifyChange(null, null);
        AppMethodBeat.o(38323);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
    @Override // com.tencent.mm.ui.s
    public /* bridge */ /* synthetic */ az a(az azVar, Cursor cursor) {
        AppMethodBeat.i(38321);
        az a2 = a(azVar, cursor);
        AppMethodBeat.o(38321);
        return a2;
    }

    /* access modifiers changed from: package-private */
    public class c implements MStorageEx.IOnStorageChange {
        final /* synthetic */ e Qcb;

        @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
        public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
            AppMethodBeat.i(38303);
            if (obj == null || !(obj instanceof String)) {
                Log.d("MicroMsg.ConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i2), mStorageEx, obj);
                AppMethodBeat.o(38303);
                return;
            }
            String str = (String) obj;
            if (this.Qcb.Pay) {
                AppMethodBeat.o(38303);
                return;
            }
            if (str != null && !str.equals("") && this.Qcb.Pax != null && this.Qcb.Pax.containsKey(Integer.valueOf(i2))) {
                this.Qcb.Pax.remove(Integer.valueOf(i2));
                this.Qcb.QbP = true;
            }
            AppMethodBeat.o(38303);
        }
    }

    public e(Context context, s.a aVar) {
        super(context, new az());
        AppMethodBeat.i(38304);
        super.a(aVar);
        this.Pav[0] = com.tencent.mm.cb.a.m(context, R.color.uj);
        this.Pav[1] = com.tencent.mm.cb.a.m(context, R.color.a0g);
        this.Pav[3] = com.tencent.mm.cb.a.m(context, R.color.a2x);
        this.Pav[2] = com.tencent.mm.cb.a.m(context, R.color.a0d);
        this.Pav[2] = com.tencent.mm.cb.a.m(context, R.color.a0d);
        this.Pav[4] = com.tencent.mm.cb.a.m(context, R.color.ww);
        this.Pax = new HashMap<>();
        if (com.tencent.mm.cb.a.jl(context)) {
            this.QbW = context.getResources().getDimensionPixelSize(R.dimen.b3);
            this.QbV = context.getResources().getDimensionPixelSize(R.dimen.b4);
        } else if (com.tencent.mm.cb.a.jk(context)) {
            this.QbW = context.getResources().getDimensionPixelSize(R.dimen.b2);
            this.QbV = context.getResources().getDimensionPixelSize(R.dimen.b4);
        } else {
            this.QbW = context.getResources().getDimensionPixelSize(R.dimen.b1);
            this.QbV = context.getResources().getDimensionPixelSize(R.dimen.b5);
        }
        this.Paq = (float) com.tencent.mm.cb.a.aG(context, R.dimen.is);
        this.Pat = (float) com.tencent.mm.cb.a.aG(context, R.dimen.hc);
        this.Pau = (float) com.tencent.mm.cb.a.aG(context, R.dimen.kc);
        AppMethodBeat.o(38304);
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

    public void detach() {
    }

    @Override // com.tencent.mm.ui.s
    public final void anq() {
        AppMethodBeat.i(38306);
        anp();
        AppMethodBeat.o(38306);
    }

    public final void onPause() {
        AppMethodBeat.i(38307);
        if (this.plb != null) {
            this.plb.ebo();
        }
        this.Pay = false;
        AppMethodBeat.o(38307);
    }

    private void gVp() {
        AppMethodBeat.i(38308);
        if (this.Pax == null) {
            AppMethodBeat.o(38308);
            return;
        }
        for (Map.Entry<String, d> entry : this.Pax.entrySet()) {
            entry.getValue().Qcd = null;
        }
        AppMethodBeat.o(38308);
    }

    public final void onResume() {
        boolean z = true;
        AppMethodBeat.i(38309);
        Log.i("MicroMsg.ConversationAdapter", "dkpno onResume mIsFront:%b  mNeedReCreate:%b mChangedBackground:%b mContactBackground:%b", Boolean.valueOf(this.Pay), Boolean.valueOf(this.QbO), Boolean.valueOf(this.Paz), Boolean.valueOf(this.QbP));
        this.Pay = true;
        Time time = new Time();
        time.setToNow();
        String charSequence = com.tencent.mm.pluginsdk.i.e.a("MM/dd", time).toString();
        if (this.QbT.equals(charSequence)) {
            z = false;
        }
        this.QbT = charSequence;
        if (z) {
            gVp();
        }
        if (this.QbO && this.QbS != null) {
            this.QbO = false;
        }
        if (this.Paz || this.QbP) {
            super.onNotifyChange(null, null);
            this.Paz = false;
            this.QbP = false;
        }
        AppMethodBeat.o(38309);
    }

    public void onDestroy() {
        AppMethodBeat.i(38314);
        this.Qca.stopTimer();
        this.QbS = null;
        this.QbQ = null;
        if (this.Pax != null) {
            this.Pax.clear();
            this.Pax = null;
        }
        ebf();
        gGV();
        detach();
        AppMethodBeat.o(38314);
    }

    @Override // com.tencent.mm.ui.s
    public void anp() {
        AppMethodBeat.i(38311);
        Log.i("MicroMsg.ConversationAdapter", "dkpno resetCursor search:%b", Boolean.valueOf(this.khr));
        if (this.khr) {
            Cursor[] cursorArr = new Cursor[2];
            cursorArr[0] = bg.aVF().iBo.a(ab.iCF, this.gzY, this.kdi);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (this.gzY != null && this.gzY.size() > 0) {
                arrayList.addAll(this.gzY);
            }
            while (cursorArr[0].moveToNext()) {
                try {
                    String string = cursorArr[0].getString(cursorArr[0].getColumnIndex(ch.COL_USERNAME));
                    arrayList.add(string);
                    if (!ab.Eq(string)) {
                        arrayList2.add(string);
                    }
                    Log.d("MicroMsg.ConversationAdapter", "block user ".concat(String.valueOf(string)));
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.ConversationAdapter", e2, "", new Object[0]);
                }
            }
            arrayList.add("officialaccounts");
            arrayList.add("helper_entry");
            cursorArr[1] = bg.aVF().iBp.b(this.kdi, "@micromsg.with.all.biz.qq.com", arrayList, arrayList2);
            setCursor(new MergeCursor(cursorArr));
        } else {
            bg.aVF();
            setCursor(com.tencent.mm.model.c.aST().a(ab.iCF, this.gzY, com.tencent.mm.o.a.gNj, false));
        }
        if (!(this.QbM == null || this.kdi == null)) {
            getCursor().getCount();
        }
        super.notifyDataSetChanged();
        AppMethodBeat.o(38311);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.ui.conversation.e$e  reason: collision with other inner class name */
    public class C2113e {
        Integer Qcq;
        as contact;
        boolean initialized;
        String talker;

        public C2113e() {
            this.initialized = false;
            this.talker = null;
            this.initialized = false;
            this.contact = null;
            this.Qcq = null;
        }
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        g gVar;
        View view2;
        d dVar;
        ColorStateList colorStateList;
        int i3;
        String[] split;
        AppMethodBeat.i(38312);
        az azVar = (az) getItem(i2);
        String str = azVar.field_username;
        C2113e eVar = this.QbU;
        eVar.talker = str;
        eVar.contact = null;
        eVar.Qcq = null;
        eVar.initialized = false;
        if (!Util.isNullOrNil(str)) {
            eVar.initialized = true;
        }
        this.QbX = new a(this, (byte) 0);
        if (view == null) {
            g gVar2 = new g();
            if (com.tencent.mm.cb.a.jk(this.context)) {
                view2 = View.inflate(this.context, R.layout.ye, null);
            } else {
                view2 = View.inflate(this.context, R.layout.yd, null);
            }
            gVar2.gvv = (ImageView) view2.findViewById(R.id.x1);
            if ((this.context instanceof BizConversationUI) || (this.context instanceof NewBizConversationUI) || (this.context instanceof ServiceNotifyConversationUI)) {
                a.b.d(gVar2.gvv, str);
            } else {
                a.b.c(gVar2.gvv, str);
            }
            com.tencent.mm.pluginsdk.ui.a aVar = (com.tencent.mm.pluginsdk.ui.a) gVar2.gvv.getDrawable();
            if (this.QbN != null) {
                this.QbN.a(aVar);
            }
            gVar2.PaE = (NoMeasuredTextView) view2.findViewById(R.id.fzg);
            gVar2.Qcr = (NoMeasuredTextView) view2.findViewById(R.id.i34);
            gVar2.PaF = (NoMeasuredTextView) view2.findViewById(R.id.j0l);
            gVar2.PaG = (NoMeasuredTextView) view2.findViewById(R.id.e7t);
            gVar2.plf = (TextView) view2.findViewById(R.id.iot);
            gVar2.plf.setBackgroundResource(v.kH(this.context));
            gVar2.PaH = (ImageView) view2.findViewById(R.id.dwf);
            gVar2.PaJ = view2.findViewById(R.id.x9);
            gVar2.PaI = (ImageView) view2.findViewById(R.id.iif);
            gVar2.Qcs = (ImageView) view2.findViewById(R.id.eqt);
            view2.setTag(gVar2);
            gVar2.PaG.setTextSize(0, this.Pat);
            gVar2.PaF.setTextSize(0, this.Pau);
            gVar2.PaE.setTextSize(0, this.Paq);
            gVar2.Qcr.setTextSize(0, this.Pat);
            gVar2.PaG.setTextColor(this.Pav[0]);
            gVar2.PaF.setTextColor(this.Pav[4]);
            gVar2.PaE.setTextColor(this.Pav[3]);
            gVar2.Qcr.setTextColor(this.Pav[0]);
            gVar2.PaG.setShouldEllipsize(true);
            gVar2.PaF.setShouldEllipsize(false);
            gVar2.PaE.setShouldEllipsize(true);
            gVar2.Qcr.setShouldEllipsize(true);
            gVar2.PaF.setGravity(5);
            gVar = gVar2;
        } else {
            gVar = (g) view.getTag();
            view2 = view;
        }
        d dVar2 = this.Pax.get(str);
        if (dVar2 == null) {
            d dVar3 = new d(this, (byte) 0);
            C2113e eVar2 = this.QbU;
            if (eVar2.initialized && eVar2.contact == null) {
                bg.aVF();
                eVar2.contact = com.tencent.mm.model.c.aSN().Kn(eVar2.talker);
            }
            as asVar = eVar2.contact;
            if (asVar != null) {
                dVar3.Qch = asVar.fuQ;
                dVar3.Qcg = (int) asVar.gMZ;
            } else {
                dVar3.Qch = -1;
                dVar3.Qcg = -1;
            }
            dVar3.Qcm = asVar != null;
            dVar3.Qco = asVar != null && asVar.amU();
            dVar3.Qcn = asVar != null && asVar.fuH == 0;
            dVar3.tcb = ab.Eq(str);
            dVar3.Qcl = dVar3.tcb && dVar3.Qcn && azVar.field_unReadCount > 0;
            dVar3.qcr = 0;
            int ahn = ahn(azVar.field_msgType);
            if (ahn == 34 && azVar.field_isSend == 0 && !Util.isNullOrNil(azVar.field_content)) {
                String str2 = azVar.field_content;
                if ((str.equals("qmessage") || str.equals("floatbottle")) && (split = str2.split(":")) != null && split.length > 3) {
                    str2 = split[1] + ":" + split[2] + ":" + split[3];
                }
                if (!new p(str2).jsi) {
                    dVar3.qcr = 1;
                }
            }
            if (ahn == 285212721) {
                final String str3 = azVar.field_content;
                Long.valueOf(azVar.field_lastSeq);
                h.RTc.b(new Runnable() {
                    /* class com.tencent.mm.ui.conversation.e.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(38302);
                        u a2 = ((com.tencent.mm.plugin.biz.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.biz.a.a.class)).a(0, str3);
                        if (a2 == null || a2.iAd.size() == 0) {
                            AppMethodBeat.o(38302);
                            return;
                        }
                        com.tencent.mm.ag.v vVar = (com.tencent.mm.ag.v) a2.iAd.getFirst();
                        if (!TextUtils.isEmpty(vVar.url)) {
                            ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(vVar.url, vVar.type, 92, new Object[0]);
                            Log.v("MicroMsg.ConversationAdapter", "terry trace preload:%s", vVar.title);
                        }
                        AppMethodBeat.o(38302);
                    }
                }, "tmplPreload");
            }
            String a2 = aa.a(asVar, str, dVar3.tcb);
            if (!dVar3.tcb || a2 != null) {
                dVar3.nickName = l.b(this.context, aa.a(asVar, str, dVar3.tcb), gVar.PaE.getTextSize());
            } else {
                dVar3.nickName = this.context.getString(R.string.b25);
            }
            dVar3.Qcd = i(azVar);
            dVar3.Qce = a(azVar, (int) gVar.PaG.getTextSize(), dVar3.Qcl);
            dVar3.Qcp = azVar.field_attrflag;
            switch (azVar.field_status) {
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
            dVar3.Qcf = i3;
            dVar3.Qci = ab.a(azVar);
            bg.aVF();
            dVar3.PaB = com.tencent.mm.model.c.aST().h(azVar);
            dVar3.Qcj = asVar != null && asVar.Zx();
            dVar3.Qck = LocaleUtil.isChineseAppLang();
            this.Pax.put(str, dVar3);
            dVar = dVar3;
        } else {
            dVar = dVar2;
        }
        if (dVar.Qcd == null) {
            dVar.Qcd = i(azVar);
        }
        if (dVar.Qcl || ab.Js(azVar.field_parentRef)) {
            gVar.PaG.setTextColor(this.Pav[0]);
        } else {
            gVar.PaG.setTextColor(this.Pav[dVar.qcr]);
        }
        com.tencent.mm.booter.notification.a.h.oc(gVar.PaG.getWidth());
        com.tencent.mm.booter.notification.a.h.od((int) gVar.PaG.getTextSize());
        com.tencent.mm.booter.notification.a.h.b(gVar.PaG.getPaint());
        if (str.toLowerCase().endsWith("@t.qq.com")) {
            gVar.PaE.setCompoundRightDrawablesWithIntrinsicBounds(R.drawable.icon_tencent_weibo);
            gVar.PaE.setDrawRightDrawable(true);
        } else {
            gVar.PaE.setDrawRightDrawable(false);
        }
        int i4 = dVar.Qcf;
        if (i4 != -1) {
            gVar.PaG.setCompoundLeftDrawablesWithIntrinsicBounds(i4);
            gVar.PaG.setDrawLeftDrawable(true);
        } else {
            gVar.PaG.setDrawLeftDrawable(false);
        }
        gVar.Qcr.setVisibility(8);
        ViewGroup.LayoutParams layoutParams = gVar.PaF.getLayoutParams();
        if (dVar.Qcd.length() >= 9) {
            if (layoutParams.width != this.QbW) {
                layoutParams.width = this.QbW;
                gVar.PaF.setLayoutParams(layoutParams);
            }
        } else if (layoutParams.width != this.QbV) {
            layoutParams.width = this.QbV;
            gVar.PaF.setLayoutParams(layoutParams);
        }
        Log.v("MicroMsg.ConversationAdapter", "layout update time width %d", Integer.valueOf(layoutParams.width));
        gVar.PaF.setText(dVar.Qcd);
        gVar.PaG.setText(dVar.Qce);
        if (dVar.tcb && dVar.Qcn) {
            gVar.PaH.setVisibility(0);
        } else if (dVar.Qcj) {
            gVar.PaH.setVisibility(0);
        } else {
            gVar.PaH.setVisibility(8);
        }
        if ((this.context instanceof BizConversationUI) || (this.context instanceof NewBizConversationUI) || (this.context instanceof ServiceNotifyConversationUI)) {
            a.b.d(gVar.gvv, str);
        } else {
            a.b.c(gVar.gvv, str);
        }
        if (this.QbL) {
            if (azVar == null || gVar == null || dVar == null) {
                Log.w("MicroMsg.ConversationAdapter", "handle show tip cnt, but conversation or viewholder is null");
            } else {
                gVar.plf.setVisibility(4);
                gVar.PaJ.setVisibility(4);
                if (ab.Js(azVar.field_username)) {
                    gVar.PaJ.setVisibility(azVar.field_unReadCount > 0 ? 0 : 4);
                    gVar.PaE.setTextColor(this.Pav[3]);
                } else {
                    NoMeasuredTextView noMeasuredTextView = gVar.PaE;
                    if (!dVar.Qcm || dVar.Qch != 1) {
                        colorStateList = this.Pav[3];
                    } else {
                        colorStateList = this.Pav[2];
                    }
                    noMeasuredTextView.setTextColor(colorStateList);
                    if (!dVar.Qcm || dVar.Qcg == 0) {
                        Log.w("MicroMsg.ConversationAdapter", "handle show tip count, but talker is null");
                    } else if (ab.Js(azVar.field_parentRef)) {
                        if (!(this.context instanceof NewBizConversationUI) && !(this.context instanceof ServiceNotifyConversationUI)) {
                            gVar.PaJ.setVisibility(azVar.field_unReadCount > 0 ? 0 : 4);
                        }
                    } else if (dVar.Qcj && dVar.Qco) {
                        gVar.PaJ.setVisibility(azVar.field_unReadCount > 0 ? 0 : 4);
                    } else if (!dVar.tcb || !dVar.Qcn) {
                        int i5 = azVar.field_unReadCount;
                        if (i5 > 99) {
                            gVar.plf.setText("");
                            gVar.plf.setBackgroundResource(R.raw.badge_count_more);
                            gVar.plf.setVisibility(0);
                        } else if (i5 > 0) {
                            gVar.plf.setText(new StringBuilder().append(azVar.field_unReadCount).toString());
                            gVar.plf.setBackgroundResource(v.aQ(this.context, i5));
                            gVar.plf.setVisibility(0);
                        }
                        this.QbX.Qcc = i5;
                    } else {
                        gVar.PaJ.setVisibility(azVar.field_unReadCount > 0 ? 0 : 4);
                    }
                }
            }
        }
        if (!dVar.Qci && dVar.PaB && bg.aAc()) {
            bg.aVF();
            com.tencent.mm.model.c.aST().g(azVar);
        }
        if (!(this.context instanceof NewBizConversationUI) || !dVar.PaB || azVar.field_conversationTime == -1) {
            gVar.PaE.setText(dVar.nickName);
            if (dVar.PaB && azVar.field_conversationTime != -1) {
                view2.findViewById(R.id.bg1).setBackgroundResource(R.drawable.q_);
                com.tencent.mm.br.c.gsX();
                xq xqVar = new xq();
                xqVar.edR.edT = true;
                EventCenter.instance.publish(xqVar);
                if (0 != com.tencent.mm.plugin.messenger.foundation.a.a.a.a(azVar, 7, 0) && !azVar.field_username.equals(xqVar.edS.edV)) {
                    azVar.yB(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(azVar, 6, azVar.field_conversationTime));
                    bg.aVF();
                    com.tencent.mm.model.c.aST().a(azVar, azVar.field_username);
                }
                if (com.tencent.mm.bh.g.jpy != null || !com.tencent.mm.bh.g.jpy.PW(azVar.field_username)) {
                    gVar.PaI.setVisibility(8);
                } else {
                    gVar.PaI.setVisibility(0);
                    if (azVar.field_username.equals(xqVar.edS.edV)) {
                        gVar.PaI.setImageResource(R.raw.talk_room_mic_speaking);
                    } else {
                        gVar.PaI.setImageResource(R.raw.talk_room_mic_idle);
                    }
                }
                if (com.tencent.mm.bi.d.jpA != null || !com.tencent.mm.bi.d.jpA.PZ(azVar.field_username)) {
                    gVar.Qcs.setVisibility(8);
                } else {
                    gVar.Qcs.setVisibility(0);
                }
                this.QbX.content = String.valueOf(dVar.Qce);
                this.QbX.nickName = String.valueOf(dVar.nickName);
                this.QbX.time = String.valueOf(dVar.Qcd);
                a aVar2 = this.QbX;
                a.C2075a.OLX.a(view2, aVar2.nickName, aVar2.Qcc, aVar2.time, aVar2.content);
                a(str, gVar);
                a(azVar, dVar.PaB, i2, false);
                AppMethodBeat.o(38312);
                return view2;
            }
        } else {
            Drawable drawable = this.context.getResources().getDrawable(R.drawable.c0a);
            int textSize = (int) gVar.PaE.getTextSize();
            drawable.setBounds(0, 0, textSize, textSize);
            com.tencent.mm.ui.widget.a aVar3 = new com.tencent.mm.ui.widget.a(drawable, 1);
            SpannableString spannableString = new SpannableString("@");
            spannableString.setSpan(aVar3, 0, 1, 33);
            gVar.PaE.setText(TextUtils.concat(dVar.nickName, " ", spannableString));
        }
        view2.findViewById(R.id.bg1).setBackgroundResource(R.drawable.qa);
        com.tencent.mm.br.c.gsX();
        xq xqVar2 = new xq();
        xqVar2.edR.edT = true;
        EventCenter.instance.publish(xqVar2);
        azVar.yB(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(azVar, 6, azVar.field_conversationTime));
        bg.aVF();
        com.tencent.mm.model.c.aST().a(azVar, azVar.field_username);
        if (com.tencent.mm.bh.g.jpy != null) {
        }
        gVar.PaI.setVisibility(8);
        if (com.tencent.mm.bi.d.jpA != null) {
        }
        gVar.Qcs.setVisibility(8);
        this.QbX.content = String.valueOf(dVar.Qce);
        this.QbX.nickName = String.valueOf(dVar.nickName);
        this.QbX.time = String.valueOf(dVar.Qcd);
        a aVar22 = this.QbX;
        a.C2075a.OLX.a(view2, aVar22.nickName, aVar22.Qcc, aVar22.time, aVar22.content);
        a(str, gVar);
        a(azVar, dVar.PaB, i2, false);
        AppMethodBeat.o(38312);
        return view2;
    }

    /* access modifiers changed from: protected */
    public void a(String str, g gVar) {
    }

    /* access modifiers changed from: protected */
    public void a(az azVar, boolean z, int i2, boolean z2) {
    }

    private static int ahn(String str) {
        int i2 = 1;
        AppMethodBeat.i(38313);
        if (str != null && str.length() > 0) {
            try {
                i2 = Integer.valueOf(str).intValue();
            } catch (NumberFormatException e2) {
            }
        }
        AppMethodBeat.o(38313);
        return i2;
    }

    public az a(az azVar, Cursor cursor) {
        AppMethodBeat.i(234115);
        if (this.khr) {
            if (cursor.getString(0) != null && cursor.getString(0).equals("1")) {
                if (azVar == null) {
                    azVar = new az();
                }
                azVar.Cm("");
                azVar.Cn("");
                azVar.convertFrom(cursor);
                AppMethodBeat.o(234115);
                return azVar;
            } else if (cursor.getString(0).equals("2")) {
                bg.aVF();
                as bjF = com.tencent.mm.model.c.aSN().bjF(as.p(cursor));
                if (bjF == null) {
                    bjF = new as();
                    bjF.convertFrom(cursor);
                    bg.aVF();
                    com.tencent.mm.model.c.aSN().am(bjF);
                }
                if (azVar == null) {
                    azVar = new az();
                }
                azVar.setStatus(2);
                azVar.yA(-1);
                azVar.nv(1);
                azVar.setContent(this.context.getString(R.string.dj5));
                azVar.setUsername(bjF.field_username);
                azVar.nt(0);
                azVar.Cl(Integer.toString(1));
                azVar.Cm("");
                azVar.Cn("");
                AppMethodBeat.o(234115);
                return azVar;
            }
        }
        if (azVar == null) {
            azVar = new az();
        }
        azVar.Cm("");
        azVar.Cn("");
        azVar.convertFrom(cursor);
        AppMethodBeat.o(234115);
        return azVar;
    }

    /* access modifiers changed from: package-private */
    public class d {
        public boolean PaB;
        public CharSequence Qcd;
        public CharSequence Qce;
        public int Qcf;
        public int Qcg;
        public int Qch;
        public boolean Qci;
        public boolean Qcj;
        public boolean Qck;
        public boolean Qcl;
        public boolean Qcm;
        public boolean Qcn;
        public boolean Qco;
        public int Qcp;
        public CharSequence nickName;
        public int qcr;
        public boolean tcb;

        private d() {
        }

        /* synthetic */ d(e eVar, byte b2) {
            this();
        }
    }

    private static String bmp(String str) {
        AppMethodBeat.i(38316);
        if (str == null || str.length() != 32) {
            AppMethodBeat.o(38316);
            return null;
        }
        String amp = ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().amp(str);
        AppMethodBeat.o(38316);
        return amp;
    }

    @Override // com.tencent.mm.ui.s, com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(38317);
        if (obj == null || !(obj instanceof String)) {
            Log.e("MicroMsg.ConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i2), mStorageEx, obj);
            AppMethodBeat.o(38317);
            return;
        }
        onNotifyChange((String) obj, null);
        AppMethodBeat.o(38317);
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange, com.tencent.mm.ui.s
    public void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        AppMethodBeat.i(38318);
        Log.i("MicroMsg.ConversationAdapter", "dkpno onNotifyChange mIsFront:%b mChangedBackground:%b event:%s", Boolean.valueOf(this.Pay), Boolean.valueOf(this.Paz), str);
        if (!Util.isNullOrNil(str) && this.Pax != null) {
            this.Pax.remove(str);
        }
        if (this.Pay) {
            Log.d("MicroMsg.ConversationAdapter", "dkpno postTryNotify needNotify:%b timerStopped:%b", Boolean.valueOf(this.QbZ), Boolean.valueOf(this.Qca.stopped()));
            this.QbZ = true;
            if (this.Qca.stopped()) {
                gVq();
            }
            AppMethodBeat.o(38318);
            return;
        }
        this.Paz = true;
        AppMethodBeat.o(38318);
    }

    private void gVq() {
        AppMethodBeat.i(38320);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.ui.conversation.e.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(38301);
                if (!bg.aAc()) {
                    e.this.Qca.stopTimer();
                    Log.e("MicroMsg.ConversationAdapter", "dkpno handleDataChange acc has not ready");
                    AppMethodBeat.o(38301);
                    return;
                }
                long nowMilliSecond = Util.nowMilliSecond();
                e.g(e.this);
                long milliSecondsToNow = Util.milliSecondsToNow(nowMilliSecond) * 3;
                Log.d("MicroMsg.ConversationAdapter", "dkpno handleDataChange guest:%d old:%d needNotify:%b", Long.valueOf(milliSecondsToNow), Long.valueOf(e.QbY), Boolean.valueOf(e.this.QbZ));
                long unused = e.QbY = (milliSecondsToNow + e.QbY) / 2;
                e.this.QbZ = false;
                e.this.Qca.startTimer(e.QbY);
                AppMethodBeat.o(38301);
            }
        });
        AppMethodBeat.o(38320);
    }

    /* access modifiers changed from: package-private */
    public class a {
        public int Qcc;
        public String content;
        public String nickName;
        public String time;

        private a() {
        }

        /* synthetic */ a(e eVar, byte b2) {
            this();
        }
    }

    private CharSequence i(az azVar) {
        AppMethodBeat.i(38305);
        if (azVar.field_status == 1) {
            String string = this.context.getString(R.string.evg);
            AppMethodBeat.o(38305);
            return string;
        } else if (azVar.field_conversationTime == MAlarmHandler.NEXT_FIRE_INTERVAL) {
            AppMethodBeat.o(38305);
            return "";
        } else {
            CharSequence c2 = com.tencent.mm.pluginsdk.i.f.c(this.context, azVar.field_conversationTime, true);
            AppMethodBeat.o(38305);
            return c2;
        }
    }

    private CharSequence a(az azVar, int i2, boolean z) {
        String a2;
        String replace;
        String displayName;
        String str;
        boolean z2;
        boolean z3;
        AppMethodBeat.i(38315);
        if (Util.isNullOrNil(azVar.field_editingMsg) || (azVar.field_atCount > 0 && azVar.field_unReadCount > 0)) {
            String str2 = azVar.field_digest;
            if (str2 == null || !str2.startsWith("<img src=\"original_label.png\"/>  ")) {
                String str3 = azVar.field_username;
                if (str3.equals("qqmail")) {
                    bg.aVF();
                    if (Util.nullAsNil((Integer) com.tencent.mm.model.c.azQ().get(17, (Object) null)) == 1) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (!z3) {
                        String string = this.context.getString(R.string.gso);
                        AppMethodBeat.o(38315);
                        return string;
                    }
                }
                if (str3.equals("tmessage")) {
                    bg.aVF();
                    ci aEY = com.tencent.mm.model.c.aSW().aEY("@t.qq.com");
                    if (aEY == null || !aEY.isEnable()) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    if (!z2) {
                        String string2 = this.context.getString(R.string.gso);
                        AppMethodBeat.o(38315);
                        return string2;
                    }
                }
                if (azVar.field_msgType != null && (azVar.field_msgType.equals("47") || azVar.field_msgType.equals("1048625"))) {
                    String bmp = bmp(azVar.field_digest);
                    String str4 = "";
                    if (bmp != null) {
                        String str5 = "[" + bmp + "]";
                        AppMethodBeat.o(38315);
                        return str5;
                    }
                    if (azVar.field_digest != null && azVar.field_digest.contains(":")) {
                        str4 = azVar.field_digest.substring(0, azVar.field_digest.indexOf(":"));
                        String bmp2 = bmp(azVar.field_digest.substring(azVar.field_digest.indexOf(":") + 1).replace(" ", ""));
                        if (bmp2 != null) {
                            String str6 = "[" + bmp2 + "]";
                            if (Util.isNullOrNil(str4)) {
                                AppMethodBeat.o(38315);
                                return str6;
                            }
                            String str7 = str4 + ": " + str6;
                            AppMethodBeat.o(38315);
                            return str7;
                        }
                    }
                    String string3 = this.context.getString(R.string.tu);
                    if (Util.isNullOrNil(str4)) {
                        str = string3;
                    } else {
                        str = str4 + ": " + string3;
                    }
                    azVar.Cm(str);
                }
                if (!Util.isNullOrNil(azVar.field_digest)) {
                    if (!Util.isNullOrNil(azVar.field_digestUser)) {
                        if (azVar.field_isSend != 0 || !ab.Eq(azVar.field_username)) {
                            displayName = aa.getDisplayName(azVar.field_digestUser);
                        } else {
                            displayName = aa.getDisplayName(azVar.field_digestUser, azVar.field_username);
                        }
                        try {
                            a2 = String.format(azVar.field_digest, displayName);
                        } catch (Exception e2) {
                        }
                    } else {
                        a2 = azVar.field_digest;
                    }
                    replace = a2.replace('\n', ' ');
                    if (azVar.field_atCount > 0 || azVar.field_unReadCount <= 0) {
                        if (!z && azVar.field_unReadCount > 1) {
                            replace = this.context.getString(R.string.euk, Integer.valueOf(azVar.field_unReadCount), replace);
                        } else if (azVar.field_unReadCount > 0 && ab.Js(azVar.field_parentRef) && !(this.context instanceof NewBizConversationUI)) {
                            replace = this.context.getString(R.string.euk, Integer.valueOf(azVar.field_unReadCount), replace);
                        }
                        SpannableString e3 = l.e(this.context, (CharSequence) replace, i2);
                        AppMethodBeat.o(38315);
                        return e3;
                    }
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.context.getString(R.string.euh));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
                    spannableStringBuilder.append((CharSequence) " ").append((CharSequence) l.e(this.context, (CharSequence) replace, i2));
                    AppMethodBeat.o(38315);
                    return spannableStringBuilder;
                }
                a2 = com.tencent.mm.booter.notification.a.h.a(azVar.field_isSend, azVar.field_username, azVar.field_content, ahn(azVar.field_msgType), this.context);
                replace = a2.replace('\n', ' ');
                if (azVar.field_atCount > 0) {
                }
                if (!z) {
                }
                replace = this.context.getString(R.string.euk, Integer.valueOf(azVar.field_unReadCount), replace);
                SpannableString e32 = l.e(this.context, (CharSequence) replace, i2);
                AppMethodBeat.o(38315);
                return e32;
            }
            SpannableString spannableString = new SpannableString(l.e(this.context, str2, (float) i2));
            AppMethodBeat.o(38315);
            return spannableString;
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.context.getString(R.string.euq));
        spannableStringBuilder2.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder2.length(), 33);
        spannableStringBuilder2.append((CharSequence) " ").append((CharSequence) l.e(this.context, (CharSequence) azVar.field_editingMsg, i2));
        AppMethodBeat.o(38315);
        return spannableStringBuilder2;
    }
}
