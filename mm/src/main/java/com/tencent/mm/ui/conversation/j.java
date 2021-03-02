package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.format.Time;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.f;
import com.tencent.mm.al.g;
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.i.e;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
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
import com.tencent.mm.ui.a.a;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.v;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class j extends s<az> implements MStorageEx.IOnStorageChange {
    private static long QbY = 2000;
    private float Paq = -1.0f;
    private float Pat = -1.0f;
    private float Pau = -1.0f;
    HashMap<String, a> Pax;
    private boolean Pay = false;
    private boolean Paz = false;
    public String QbT = "";
    private final int QbV;
    private final int QbW;
    private boolean QbZ = false;
    MTimerHandler Qca = new MTimerHandler(bg.aAk().getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.ui.conversation.j.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(38526);
            if (j.this.QbZ) {
                j.b(j.this);
            }
            AppMethodBeat.o(38526);
            return false;
        }
    }, false);
    private String QeU;
    private ColorStateList[] QeV = new ColorStateList[5];
    private String dVu;
    protected MMSlideDelView.g pkY;
    protected MMSlideDelView.c pkZ;
    protected MMSlideDelView.f pla;
    protected MMSlideDelView.d plb = MMSlideDelView.getItemStatusCallBack();

    public static class b {
        public ImageView PaH;
        public View PaJ;
        public NoMeasuredTextView QeX;
        public NoMeasuredTextView QeY;
        public NoMeasuredTextView QeZ;
        public TextView Qfa;
        public ImageView gvv;
    }

    static /* synthetic */ void b(j jVar) {
        AppMethodBeat.i(38544);
        jVar.gVq();
        AppMethodBeat.o(38544);
    }

    static /* synthetic */ void d(j jVar) {
        AppMethodBeat.i(38545);
        super.onNotifyChange(null, null);
        AppMethodBeat.o(38545);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, android.database.Cursor] */
    @Override // com.tencent.mm.ui.s
    public final /* bridge */ /* synthetic */ az a(az azVar, Cursor cursor) {
        AppMethodBeat.i(38543);
        az a2 = a(azVar, cursor);
        AppMethodBeat.o(38543);
        return a2;
    }

    public j(Context context, String str, s.a aVar) {
        super(context, new az());
        AppMethodBeat.i(38528);
        super.a(aVar);
        this.dVu = str;
        try {
            ag.bah();
            this.QeU = f.MX(str);
        } catch (Throwable th) {
        }
        this.Pax = new HashMap<>();
        this.QeV[0] = com.tencent.mm.cb.a.m(context, R.color.uj);
        this.QeV[1] = com.tencent.mm.cb.a.m(context, R.color.a0g);
        this.QeV[3] = com.tencent.mm.cb.a.m(context, R.color.a2x);
        this.QeV[2] = com.tencent.mm.cb.a.m(context, R.color.a0d);
        this.QeV[2] = com.tencent.mm.cb.a.m(context, R.color.a0d);
        this.QeV[4] = com.tencent.mm.cb.a.m(context, R.color.ww);
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
        bg.aVF();
        c.aST().add(this);
        AppMethodBeat.o(38528);
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

    public final void onPause() {
        AppMethodBeat.i(38529);
        if (this.plb != null) {
            this.plb.ebo();
        }
        this.Pay = false;
        AppMethodBeat.o(38529);
    }

    public final void onResume() {
        boolean z = true;
        AppMethodBeat.i(38530);
        this.Pay = true;
        Time time = new Time();
        time.setToNow();
        String charSequence = e.a("MM/dd", time).toString();
        if (this.QbT.equals(charSequence)) {
            z = false;
        }
        this.QbT = charSequence;
        if (z) {
            gVp();
        }
        if (this.Paz) {
            super.onNotifyChange(null, null);
            this.Paz = false;
        }
        AppMethodBeat.o(38530);
    }

    @Override // com.tencent.mm.ui.s
    public final void anq() {
        AppMethodBeat.i(38531);
        anp();
        AppMethodBeat.o(38531);
    }

    @Override // com.tencent.mm.ui.s
    public final void anp() {
        AppMethodBeat.i(38532);
        ebf();
        LinkedList linkedList = new LinkedList();
        try {
            linkedList.addAll(g.Nl(this.dVu));
        } catch (Throwable th) {
        }
        if (Util.isNullOrNil(this.QeU)) {
            bg.aVF();
            setCursor(c.aST().c(ab.iCF, linkedList, this.dVu));
        } else {
            linkedList.add(this.QeU);
            bg.aVF();
            setCursor(c.aST().c(ab.iCF, linkedList, this.dVu));
        }
        if (this.OFI != null) {
            this.OFI.bnE();
        }
        super.notifyDataSetChanged();
        AppMethodBeat.o(38532);
    }

    @Override // com.tencent.mm.ui.s
    public final Cursor getCursor() {
        AppMethodBeat.i(234156);
        Cursor cursor = super.getCursor();
        AppMethodBeat.o(234156);
        return cursor;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        View view2;
        a aVar;
        int i3;
        boolean z;
        boolean z2;
        int i4;
        AppMethodBeat.i(38533);
        az azVar = (az) getItem(i2);
        String str = azVar.field_username;
        b bVar2 = null;
        if (view != null) {
            bVar2 = (b) view.getTag();
        }
        if (view == null || bVar2 == null) {
            bVar = new b();
            if (com.tencent.mm.cb.a.jk(this.context)) {
                view2 = View.inflate(this.context, R.layout.ye, null);
            } else {
                view2 = View.inflate(this.context, R.layout.yd, null);
            }
            bVar.gvv = (ImageView) view2.findViewById(R.id.x1);
            bVar.QeX = (NoMeasuredTextView) view2.findViewById(R.id.fzg);
            bVar.QeX.setTextSize(0, this.Paq);
            bVar.QeX.setTextColor(this.QeV[3]);
            bVar.QeX.setShouldEllipsize(true);
            bVar.QeY = (NoMeasuredTextView) view2.findViewById(R.id.j0l);
            bVar.QeY.setTextSize(0, this.Pau);
            bVar.QeY.setTextColor(this.QeV[4]);
            bVar.QeY.setShouldEllipsize(false);
            bVar.QeY.setGravity(5);
            bVar.QeZ = (NoMeasuredTextView) view2.findViewById(R.id.e7t);
            bVar.QeZ.setTextSize(0, this.Pat);
            bVar.QeZ.setTextColor(this.QeV[0]);
            bVar.QeZ.setShouldEllipsize(true);
            bVar.Qfa = (TextView) view2.findViewById(R.id.iot);
            bVar.Qfa.setBackgroundResource(v.kH(this.context));
            bVar.PaH = (ImageView) view2.findViewById(R.id.dwf);
            bVar.PaJ = view2.findViewById(R.id.x9);
            view2.findViewById(R.id.iif).setVisibility(8);
            view2.findViewById(R.id.eqt).setVisibility(8);
            view2.setTag(bVar);
        } else {
            bVar = bVar2;
            view2 = view;
        }
        a aVar2 = this.Pax.get(str);
        bg.aVF();
        as Kn = c.aSN().Kn(str);
        if (aVar2 == null) {
            a aVar3 = new a(this, (byte) 0);
            if (Kn != null) {
                aVar3.Qcg = (int) Kn.gMZ;
            } else {
                aVar3.Qcg = -1;
            }
            aVar3.Qcm = Kn != null;
            aVar3.Qco = Kn != null && Kn.amU();
            if (Kn == null || !Kn.Zx()) {
                z = false;
            } else {
                z = true;
            }
            aVar3.Qcj = z;
            aVar3.FpT = azVar.field_unReadCount > 0;
            aVar3.qcr = 0;
            if (m(azVar) == 34 && azVar.field_isSend == 0 && !Util.isNullOrNil(azVar.field_content) && !new p(azVar.field_content).jsi) {
                aVar3.qcr = 1;
            }
            aVar3.nickName = l.b(this.context, aa.a(Kn, str, false), bVar.QeX.getTextSize());
            aVar3.Qcd = i(azVar);
            int textSize = (int) bVar.QeZ.getTextSize();
            if (!aVar3.Qcj || !aVar3.FpT) {
                z2 = false;
            } else {
                z2 = true;
            }
            aVar3.Qce = c(azVar, textSize, z2);
            aVar3.Qcp = azVar.field_attrflag;
            switch (azVar.field_status) {
                case 0:
                    i4 = -1;
                    break;
                case 1:
                    i4 = R.raw.msg_state_sending;
                    break;
                case 2:
                    i4 = -1;
                    break;
                case 3:
                case 4:
                default:
                    i4 = -1;
                    break;
                case 5:
                    i4 = R.raw.msg_state_failed;
                    break;
            }
            aVar3.Qcf = i4;
            bg.aVF();
            aVar3.PaB = c.aST().h(azVar);
            aVar3.Qck = LocaleUtil.isChineseAppLang();
            this.Pax.put(str, aVar3);
            aVar = aVar3;
        } else {
            aVar = aVar2;
        }
        if (aVar.Qcd == null) {
            aVar.Qcd = i(azVar);
        }
        if (!aVar.Qcj || !aVar.FpT) {
            bVar.QeZ.setTextColor(this.QeV[aVar.qcr]);
        } else {
            bVar.QeZ.setTextColor(this.QeV[0]);
        }
        h.oc(bVar.QeZ.getWidth());
        h.od((int) bVar.QeZ.getTextSize());
        h.b(bVar.QeZ.getPaint());
        if (aVar.Qcf != -1) {
            bVar.QeZ.setCompoundLeftDrawablesWithIntrinsicBounds(aVar.Qcf);
            bVar.QeZ.setDrawLeftDrawable(true);
        } else {
            bVar.QeZ.setDrawLeftDrawable(false);
        }
        bVar.QeZ.setText(aVar.Qce);
        bVar.QeX.setDrawRightDrawable(false);
        bVar.QeX.setText(aVar.nickName);
        ViewGroup.LayoutParams layoutParams = bVar.QeY.getLayoutParams();
        if (aVar.Qcd.length() >= 9) {
            if (layoutParams.width != this.QbW) {
                layoutParams.width = this.QbW;
                bVar.QeY.setLayoutParams(layoutParams);
            }
        } else if (layoutParams.width != this.QbV) {
            layoutParams.width = this.QbV;
            bVar.QeY.setLayoutParams(layoutParams);
        }
        bVar.QeY.setText(aVar.Qcd);
        if (aVar.Qcj) {
            bVar.PaH.setVisibility(0);
        } else {
            bVar.PaH.setVisibility(8);
        }
        a.b.c(bVar.gvv, str);
        bVar.Qfa.setVisibility(4);
        bVar.PaJ.setVisibility(4);
        if (aVar.Qcm && aVar.Qcg != 0) {
            int i5 = azVar.field_unReadCount;
            if (aVar.Qcj) {
                View view3 = bVar.PaJ;
                if (i5 > 0) {
                    i3 = 0;
                } else {
                    i3 = 4;
                }
                view3.setVisibility(i3);
            } else if (i5 > 99) {
                bVar.Qfa.setText("");
                bVar.Qfa.setBackgroundResource(R.raw.badge_count_more);
                bVar.Qfa.setVisibility(0);
            } else if (i5 > 0) {
                bVar.Qfa.setText(String.valueOf(i5));
                bVar.Qfa.setBackgroundResource(v.aQ(this.context, i5));
                bVar.Qfa.setVisibility(0);
            }
        }
        if (!aVar.PaB || azVar.field_conversationTime == -1) {
            view2.findViewById(R.id.bg1).setBackgroundResource(R.drawable.qa);
        } else {
            view2.findViewById(R.id.bg1).setBackgroundResource(R.drawable.q_);
        }
        a.C2075a.OLX.a(view2, String.valueOf(aVar.nickName), azVar.field_unReadCount, String.valueOf(aVar.Qcd), String.valueOf(aVar.Qce));
        AppMethodBeat.o(38533);
        return view2;
    }

    public static az a(az azVar, Cursor cursor) {
        AppMethodBeat.i(234157);
        if (azVar == null) {
            azVar = new az();
        }
        azVar.Cm("");
        azVar.Cn("");
        azVar.convertFrom(cursor);
        AppMethodBeat.o(234157);
        return azVar;
    }

    /* access modifiers changed from: package-private */
    public class a {
        public boolean FpT;
        public boolean PaB;
        public CharSequence Qcd;
        public CharSequence Qce;
        public int Qcf;
        public int Qcg;
        public boolean Qcj;
        public boolean Qck;
        public boolean Qcm;
        public boolean Qco;
        public int Qcp;
        public CharSequence nickName;
        public int qcr;

        private a() {
        }

        /* synthetic */ a(j jVar, byte b2) {
            this();
        }
    }

    private static String bmp(String str) {
        AppMethodBeat.i(38536);
        if (str == null || str.length() != 32) {
            AppMethodBeat.o(38536);
            return null;
        }
        String amp = ((d) com.tencent.mm.kernel.g.ah(d.class)).getEmojiMgr().amp(str);
        AppMethodBeat.o(38536);
        return amp;
    }

    private void gVp() {
        AppMethodBeat.i(38538);
        if (this.Pax == null) {
            AppMethodBeat.o(38538);
            return;
        }
        for (Map.Entry<String, a> entry : this.Pax.entrySet()) {
            entry.getValue().Qcd = null;
        }
        AppMethodBeat.o(38538);
    }

    @Override // com.tencent.mm.ui.s, com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(38539);
        if (obj == null || !(obj instanceof String)) {
            Log.e("MicroMsg.EnterpriseConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i2), mStorageEx, obj);
            AppMethodBeat.o(38539);
            return;
        }
        onNotifyChange((String) obj, null);
        AppMethodBeat.o(38539);
    }

    @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange, com.tencent.mm.ui.s
    public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
        AppMethodBeat.i(38540);
        Log.i("MicroMsg.EnterpriseConversationAdapter", "dkpno onNotifyChange mIsFront:%b mChangedBackground:%b event:%s", Boolean.valueOf(this.Pay), Boolean.valueOf(this.Paz), str);
        if (!Util.isNullOrNil(str) && this.Pax != null) {
            this.Pax.remove(str);
        }
        if (this.Pay) {
            Log.d("MicroMsg.EnterpriseConversationAdapter", "dkpno postTryNotify needNotify:%b timerStopped:%b", Boolean.valueOf(this.QbZ), Boolean.valueOf(this.Qca.stopped()));
            this.QbZ = true;
            if (this.Qca.stopped()) {
                gVq();
            }
            AppMethodBeat.o(38540);
            return;
        }
        this.Paz = true;
        AppMethodBeat.o(38540);
    }

    private void gVq() {
        AppMethodBeat.i(38542);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.ui.conversation.j.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(38527);
                if (!bg.aAc()) {
                    j.this.Qca.stopTimer();
                    Log.e("MicroMsg.EnterpriseConversationAdapter", "dkpno handleDataChange acc has not ready");
                    AppMethodBeat.o(38527);
                    return;
                }
                long nowMilliSecond = Util.nowMilliSecond();
                j.d(j.this);
                long milliSecondsToNow = Util.milliSecondsToNow(nowMilliSecond) * 3;
                Log.d("MicroMsg.EnterpriseConversationAdapter", "dkpno handleDataChange guest:%d old:%d needNotify:%b", Long.valueOf(milliSecondsToNow), Long.valueOf(j.QbY), Boolean.valueOf(j.this.QbZ));
                long unused = j.QbY = (milliSecondsToNow + j.QbY) / 2;
                j.this.QbZ = false;
                j.this.Qca.startTimer(j.QbY);
                AppMethodBeat.o(38527);
            }
        });
        AppMethodBeat.o(38542);
    }

    private static int m(az azVar) {
        int i2 = 1;
        AppMethodBeat.i(38534);
        String str = azVar.field_msgType;
        if (str != null && str.length() > 0) {
            try {
                i2 = Integer.valueOf(str).intValue();
            } catch (NumberFormatException e2) {
            }
        }
        AppMethodBeat.o(38534);
        return i2;
    }

    private CharSequence c(az azVar, int i2, boolean z) {
        String a2;
        String replace;
        String displayName;
        String str;
        AppMethodBeat.i(38535);
        if (Util.isNullOrNil(azVar.field_editingMsg) || (azVar.field_atCount > 0 && azVar.field_unReadCount > 0)) {
            String str2 = azVar.field_digest;
            if (str2 == null || !str2.startsWith("<img src=\"original_label.png\"/>  ")) {
                if (m(azVar) == 47 || m(azVar) == 1048625) {
                    String bmp = bmp(azVar.field_digest);
                    String str3 = "";
                    if (bmp != null) {
                        String str4 = "[" + bmp + "]";
                        AppMethodBeat.o(38535);
                        return str4;
                    }
                    if (azVar.field_digest != null && azVar.field_digest.contains(":")) {
                        str3 = azVar.field_digest.substring(0, azVar.field_digest.indexOf(":"));
                        String bmp2 = bmp(azVar.field_digest.substring(azVar.field_digest.indexOf(":") + 1).replace(" ", ""));
                        if (bmp2 != null) {
                            String str5 = "[" + bmp2 + "]";
                            if (Util.isNullOrNil(str3)) {
                                AppMethodBeat.o(38535);
                                return str5;
                            }
                            String str6 = str3 + ": " + str5;
                            AppMethodBeat.o(38535);
                            return str6;
                        }
                    }
                    String string = this.context.getString(R.string.tu);
                    if (Util.isNullOrNil(str3)) {
                        str = string;
                    } else {
                        str = str3 + ": " + string;
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
                        if (z && azVar.field_unReadCount > 1) {
                            replace = this.context.getString(R.string.euk, Integer.valueOf(azVar.field_unReadCount), replace);
                        }
                        SpannableString e3 = l.e(this.context, (CharSequence) replace, i2);
                        AppMethodBeat.o(38535);
                        return e3;
                    }
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.context.getString(R.string.euh));
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder.length(), 33);
                    spannableStringBuilder.append((CharSequence) " ").append((CharSequence) l.e(this.context, (CharSequence) replace, i2));
                    AppMethodBeat.o(38535);
                    return spannableStringBuilder;
                }
                a2 = h.a(azVar.field_isSend, azVar.field_username, azVar.field_content, m(azVar), this.context);
                replace = a2.replace('\n', ' ');
                if (azVar.field_atCount > 0) {
                }
                replace = this.context.getString(R.string.euk, Integer.valueOf(azVar.field_unReadCount), replace);
                SpannableString e32 = l.e(this.context, (CharSequence) replace, i2);
                AppMethodBeat.o(38535);
                return e32;
            }
            SpannableString spannableString = new SpannableString(l.e(this.context, str2, (float) i2));
            AppMethodBeat.o(38535);
            return spannableString;
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(this.context.getString(R.string.euq));
        spannableStringBuilder2.setSpan(new ForegroundColorSpan(-5569532), 0, spannableStringBuilder2.length(), 33);
        spannableStringBuilder2.append((CharSequence) " ").append((CharSequence) l.e(this.context, (CharSequence) azVar.field_editingMsg, i2));
        AppMethodBeat.o(38535);
        return spannableStringBuilder2;
    }

    private CharSequence i(az azVar) {
        AppMethodBeat.i(38537);
        if (azVar.field_status == 1) {
            String string = this.context.getString(R.string.evg);
            AppMethodBeat.o(38537);
            return string;
        } else if (azVar.field_conversationTime == MAlarmHandler.NEXT_FIRE_INTERVAL) {
            AppMethodBeat.o(38537);
            return "";
        } else {
            CharSequence c2 = com.tencent.mm.pluginsdk.i.f.c(this.context, azVar.field_conversationTime, true);
            AppMethodBeat.o(38537);
            return c2;
        }
    }
}
