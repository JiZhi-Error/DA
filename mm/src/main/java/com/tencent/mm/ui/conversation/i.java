package com.tencent.mm.ui.conversation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.text.SpannableString;
import android.text.format.Time;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.booter.notification.a.h;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.plugin.appbrand.service.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.plugin.textstatus.a.a;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.czg;
import com.tencent.mm.protocal.protobuf.czh;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.a.a;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.span.BoldForegroundColorSpan;
import com.tencent.mm.ui.f;
import com.tencent.mm.ui.tools.v;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class i extends com.tencent.mm.ui.f<String, az> implements MStorageEx.IOnStorageChange {
    boolean EqF = false;
    MStorage.IOnStorageChange OLa = new MStorage.IOnStorageChange() {
        /* class com.tencent.mm.ui.conversation.i.AnonymousClass7 */

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(38488);
            i.this.notifyDataSetChanged();
            AppMethodBeat.o(38488);
        }
    };
    private NoMeasuredTextView.c PSx = new NoMeasuredTextView.c() {
        /* class com.tencent.mm.ui.conversation.i.AnonymousClass1 */

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v2, types: [java.lang.CharSequence] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.tencent.mm.ui.base.NoMeasuredTextView.c
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.CharSequence a(com.tencent.mm.ui.base.NoMeasuredTextView r11, java.lang.CharSequence r12, java.lang.String r13, int r14, int r15) {
            /*
            // Method dump skipped, instructions count: 241
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.conversation.i.AnonymousClass1.a(com.tencent.mm.ui.base.NoMeasuredTextView, java.lang.CharSequence, java.lang.String, int, int):java.lang.CharSequence");
        }
    };
    private float Paq = -1.0f;
    private float Pat = -1.0f;
    private float Pau = -1.0f;
    private ColorStateList[] Pav = new ColorStateList[5];
    HashMap<String, d> Pax;
    public boolean PmS = false;
    private boolean QbL = true;
    com.tencent.mm.pluginsdk.ui.e QbN;
    private boolean QbO = false;
    IListener QbR = null;
    public String QbT = "";
    private final int QbV;
    private final int QbW;
    private a QeA;
    private long QeB = 0;
    private boolean QeC = false;
    boolean QeD = false;
    private boolean Qeh = false;
    private xq Qei = null;
    b Qej = null;
    private HashSet<String> Qek;
    private boolean Qel = false;
    HashMap<String, Integer> Qem = new HashMap<>();
    private HashMap<String, Integer> Qen = new HashMap<>();
    private boolean Qeo = false;
    HashSet<String> Qep;
    boolean Qeq = false;
    private boolean Qer = false;
    private boolean Qes = false;
    public String Qet = "";
    boolean Qeu = true;
    private String Qev;
    private ColorDrawable Qew;
    ValueAnimator Qex;
    final e Qey = new e();
    private float Qez = -1.0f;
    protected List<String> gzY = null;
    private boolean khr = false;
    private ListView mListView;
    protected MMSlideDelView.g pkY;
    protected MMSlideDelView.c pkZ;
    protected MMSlideDelView.d plb = MMSlideDelView.getItemStatusCallBack();
    boolean yJA = false;

    public interface b {
        void gVP();
    }

    public static class f {
        public boolean PaB;
        public NoMeasuredTextView PaE;
        public NoMeasuredTextView PaF;
        public NoMeasuredTextView PaG;
        public View PaJ;
        public ImageView Qcs;
        public ImageView QeQ;
        public WeImageView QeR;
        public ImageView QeS;
        public c QeT;
        public ImageView gvv;
        public TextView plf;
        public int position;
        public String username;
    }

    public i(Context context, ListView listView, f.a aVar) {
        super(context, (short) 0);
        AppMethodBeat.i(38494);
        this.mListView = listView;
        this.TAG = "MicroMsg.ConversationWithCacheAdapter";
        super.a(aVar);
        this.Pav[0] = com.tencent.mm.cb.a.m(context, R.color.uj);
        this.Pav[1] = com.tencent.mm.cb.a.m(context, R.color.a0g);
        this.Pav[3] = com.tencent.mm.cb.a.m(context, R.color.a2x);
        this.Pav[2] = com.tencent.mm.cb.a.m(context, R.color.Link);
        this.Pav[2] = com.tencent.mm.cb.a.m(context, R.color.Link);
        this.Pav[4] = com.tencent.mm.cb.a.m(context, R.color.uj);
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
        this.Pax = new HashMap<>();
        this.Qek = new HashSet<>();
        this.Qep = new HashSet<>();
        this.Paq = context.getResources().getDimension(R.dimen.is);
        this.Pat = context.getResources().getDimension(R.dimen.hc);
        this.Pau = context.getResources().getDimension(R.dimen.kc);
        this.gzY = new ArrayList();
        this.gzY.add("qmessage");
        this.Qes = gVO();
        if (!this.Qes) {
            this.gzY.add("appbrand_notify_message");
        }
        AppMethodBeat.o(38494);
    }

    public final void setPerformItemClickListener(MMSlideDelView.g gVar) {
        this.pkY = gVar;
    }

    public final void setGetViewPositionCallback(MMSlideDelView.c cVar) {
        this.pkZ = cVar;
    }

    private static int anD(int i2) {
        switch (i2) {
            case 0:
            case 2:
            case 3:
            case 4:
            case 6:
            case 7:
            default:
                return -1;
            case 1:
            case 8:
                return R.raw.msg_state_sending;
            case 5:
                return R.raw.msg_state_failed;
        }
    }

    public final void gUq() {
        boolean z = true;
        AppMethodBeat.i(38496);
        if (this.gzY == null) {
            this.gzY = new ArrayList();
        }
        this.gzY.clear();
        boolean z2 = (z.aUc() & 32768) == 0;
        boolean aUu = z.aUu();
        if (!z2 || !aUu) {
            z = false;
        }
        if (z != this.Qer) {
            if (z) {
                bg.aVF();
                onNotifyChange(5, (MStorageEx) com.tencent.mm.model.c.aST(), "floatbottle");
            } else {
                bg.aVF();
                onNotifyChange(2, (MStorageEx) com.tencent.mm.model.c.aST(), "floatbottle");
            }
            this.Qer = z;
        }
        if (this.Qer) {
            this.gzY.add("floatbottle");
        }
        this.gzY.add("qmessage");
        boolean gVO = gVO();
        if (gVO != this.Qes) {
            if (gVO) {
                bg.aVF();
                onNotifyChange(2, (MStorageEx) com.tencent.mm.model.c.aST(), "appbrand_notify_message");
            } else {
                bg.aVF();
                onNotifyChange(5, (MStorageEx) com.tencent.mm.model.c.aST(), "appbrand_notify_message");
            }
            this.Qes = gVO;
        }
        if (!this.Qes) {
            this.gzY.add("appbrand_notify_message");
        }
        AppMethodBeat.o(38496);
    }

    public final void onPause() {
        AppMethodBeat.i(38497);
        Log.d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck adpter onPause  hasResume " + this.PmS);
        if (!this.PmS) {
            AppMethodBeat.o(38497);
            return;
        }
        this.PmS = false;
        super.pause();
        if (this.plb != null) {
            this.plb.ebo();
        }
        AppMethodBeat.o(38497);
    }

    private void gVp() {
        AppMethodBeat.i(38498);
        if (this.Pax == null) {
            AppMethodBeat.o(38498);
            return;
        }
        for (Map.Entry<String, d> entry : this.Pax.entrySet()) {
            entry.getValue().Qcd = null;
        }
        AppMethodBeat.o(38498);
    }

    public final void onResume() {
        boolean z;
        AppMethodBeat.i(38499);
        Log.d("MicroMsg.ConversationWithCacheAdapter", "unreadcheck adpter onResume  hasResume " + this.PmS);
        if (this.PmS) {
            AppMethodBeat.o(38499);
            return;
        }
        this.PmS = true;
        gUq();
        gVN();
        Log.i(this.TAG, "newcursor resume syncNow ");
        this.OzL = true;
        mY(true);
        Time time = new Time();
        time.setToNow();
        String charSequence = com.tencent.mm.pluginsdk.i.e.a("MM/dd", time).toString();
        String applicationLanguage = LocaleUtil.getApplicationLanguage();
        if (!this.QbT.equals(charSequence) || !this.Qet.equals(applicationLanguage)) {
            z = true;
        } else {
            z = false;
        }
        this.QbT = charSequence;
        this.Qet = applicationLanguage;
        if (z) {
            gVp();
        }
        if (this.QbO && this.Qej != null) {
            this.Qej.gVP();
            this.QbO = false;
            super.o(null, 1);
        }
        AppMethodBeat.o(38499);
    }

    private boolean gVL() {
        return this.Qev != null;
    }

    public final void a(View view, int i2, String str) {
        int i3;
        AppMethodBeat.i(38500);
        if (view == null) {
            AppMethodBeat.o(38500);
        } else if (this.Qev == null || ao.gJK()) {
            Log.i("MicroMsg.ConversationWithCacheAdapter", "[onClickItem] position:%s username:%s", Integer.valueOf(i2), str);
            this.Qev = str;
            f fVar = (f) view.getTag();
            int color = view.getContext().getResources().getColor(R.color.FG_3);
            int color2 = view.getContext().getResources().getColor((fVar == null || !fVar.PaB) ? R.color.f3045c : R.color.f3046d);
            if (ao.gJK()) {
                i3 = view.getContext().getResources().getColor((fVar == null || !fVar.PaB) ? R.color.km : R.color.jm);
            } else {
                i3 = color2;
            }
            this.Qew = new ColorDrawable(ar.v(color, i3));
            view.setBackground(this.Qew);
            if (ao.gJK()) {
                notifyDataSetChanged();
            }
            if (ab.JC(str)) {
                g gVar = (g) com.tencent.mm.kernel.g.af(g.class);
                com.tencent.mm.kernel.g.aAf();
                gVar.UF(Util.nullAsNil(String.valueOf(com.tencent.mm.kernel.a.getUin())));
                gVar.a(new g.a(((az) getItem(i2)).field_unReadCount, i2 + 1));
            }
            AppMethodBeat.o(38500);
        } else {
            Log.w("MicroMsg.ConversationWithCacheAdapter", "[onClickItem] has click! position:%s username:%s", Integer.valueOf(i2), str);
            AppMethodBeat.o(38500);
        }
    }

    public final void anQ(int i2) {
        AppMethodBeat.i(38501);
        if (!gVL()) {
            Log.i("MicroMsg.ConversationWithCacheAdapter", "[requestDismissClickStatus] pass!");
            AppMethodBeat.o(38501);
            return;
        }
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.ui.conversation.i.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(38485);
                i.e(i.this);
                AppMethodBeat.o(38485);
            }
        }, (long) i2);
        AppMethodBeat.o(38501);
    }

    public final void gVM() {
        AppMethodBeat.i(38502);
        super.o(null, 1);
        AppMethodBeat.o(38502);
    }

    /* access modifiers changed from: package-private */
    public class e {
        private Integer Qcq;
        private as contact;
        private boolean initialized;
        private String talker;

        public e() {
            this.initialized = false;
            this.talker = null;
            this.initialized = false;
            this.contact = null;
            this.Qcq = null;
        }

        public final void Cy(String str) {
            AppMethodBeat.i(38492);
            this.talker = str;
            this.contact = null;
            this.Qcq = null;
            this.initialized = false;
            if (!Util.isNullOrNil(str)) {
                this.initialized = true;
            }
            AppMethodBeat.o(38492);
        }

        public final as eFa() {
            AppMethodBeat.i(38493);
            if (this.initialized && this.contact == null && bg.aAc()) {
                bg.aVF();
                this.contact = com.tencent.mm.model.c.aSN().Kn(this.talker);
            }
            as asVar = this.contact;
            AppMethodBeat.o(38493);
            return asVar;
        }
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        final f fVar;
        View view2;
        Object obj;
        ColorStateList colorStateList;
        View c2;
        AppMethodBeat.i(38503);
        this.QeA = new a(this, (byte) 0);
        az azVar = (az) getItem(i2);
        String str = azVar.field_username;
        this.Qey.Cy(str);
        if (!this.Qem.containsKey(str)) {
            this.Qem.put(str, Integer.valueOf(i2));
        } else if (i2 != this.Qem.get(str).intValue()) {
            SparseArray[] gGZ = gGZ();
            HashMap gFw = this.OzM == null ? null : this.OzM.Ouf.gFw();
            StringBuffer stringBuffer = new StringBuffer();
            for (SparseArray sparseArray : gGZ) {
                int i3 = 0;
                while (i3 < sparseArray.size() && i3 < 50) {
                    stringBuffer.append("[");
                    stringBuffer.append(i3);
                    stringBuffer.append(",");
                    stringBuffer.append(sparseArray.keyAt(i3));
                    stringBuffer.append(",");
                    stringBuffer.append((String) sparseArray.valueAt(i3));
                    stringBuffer.append("]");
                    i3++;
                }
            }
            stringBuffer.append("\n");
            if (gFw != null) {
                int i4 = 0;
                for (Map.Entry entry : gFw.entrySet()) {
                    if (i4 >= 50) {
                        break;
                    }
                    i4++;
                    stringBuffer.append("[");
                    stringBuffer.append(entry.getKey());
                    stringBuffer.append(",");
                    if (entry.getValue() != null) {
                        stringBuffer.append(((az) entry.getValue()).field_username);
                    }
                    stringBuffer.append("]");
                }
                stringBuffer.append("\n");
            }
            Object[] objArr = new Object[5];
            objArr[0] = stringBuffer.toString();
            objArr[1] = str;
            objArr[2] = Integer.valueOf(i2);
            objArr[3] = this.Qem.toString();
            objArr[4] = Integer.valueOf(gFw != null ? gFw.size() : 0);
            Log.i("MicroMsg.ConversationWithCacheAdapter", "Get Item duplicated: positionMaps: %s username [%s, %d] Map: %s datas: %d", objArr);
            if (!this.Qel) {
                com.tencent.mm.plugin.fts.a.e.Nk(20);
                this.Qel = true;
            }
            if (System.currentTimeMillis() - this.QeB > Util.MILLSECONDS_OF_HOUR) {
                super.o(null, 1);
                this.QeB = System.currentTimeMillis();
            }
        }
        if (view == null) {
            fVar = new f();
            if (com.tencent.mm.cb.a.jm(this.context)) {
                com.tencent.mm.kiss.a.b.aBh();
                c2 = com.tencent.mm.kiss.a.b.c((Activity) this.context, R.layout.yh);
            } else {
                com.tencent.mm.kiss.a.b.aBh();
                c2 = com.tencent.mm.kiss.a.b.c((Activity) this.context, R.layout.yf);
            }
            c2.setTag(R.id.iu_, new int[2]);
            c2.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.ui.conversation.i.AnonymousClass8 */

                public final void onClick(View view) {
                    AppMethodBeat.i(38489);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (i.this.mListView == null || i.this.mListView.getOnItemClickListener() == null) {
                        Log.e("MicroMsg.ConversationWithCacheAdapter", "[onClick] pass this click");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(38489);
                    } else if (view.getTag() == null) {
                        Log.e("MicroMsg.ConversationWithCacheAdapter", "[onClick] getTag is null");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(38489);
                    } else if (i.this.PmS || ao.gJK()) {
                        f fVar = (f) view.getTag();
                        i.this.mListView.getOnItemClickListener().onItemClick(i.this.mListView, view, fVar.position + i.this.mListView.getHeaderViewsCount(), i.this.getItemId(fVar.position));
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(38489);
                    } else {
                        Log.w("MicroMsg.ConversationWithCacheAdapter", "[onClick] unResume");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(38489);
                    }
                }
            });
            c2.setOnLongClickListener(new View.OnLongClickListener() {
                /* class com.tencent.mm.ui.conversation.i.AnonymousClass9 */

                public final boolean onLongClick(View view) {
                    AppMethodBeat.i(38490);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                    if (i.this.mListView == null || i.this.mListView.getOnItemLongClickListener() == null) {
                        Log.e("MicroMsg.ConversationWithCacheAdapter", "[onClick] pass this click");
                        com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                        AppMethodBeat.o(38490);
                        return false;
                    } else if (view.getTag() == null) {
                        Log.e("MicroMsg.ConversationWithCacheAdapter", "[onClick] getTag is null");
                        com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                        AppMethodBeat.o(38490);
                        return false;
                    } else if (!i.this.PmS) {
                        Log.w("MicroMsg.ConversationWithCacheAdapter", "[onClick] unResume");
                        com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                        AppMethodBeat.o(38490);
                        return false;
                    } else {
                        f fVar = (f) view.getTag();
                        boolean onItemLongClick = i.this.mListView.getOnItemLongClickListener().onItemLongClick(i.this.mListView, view, fVar.position + i.this.mListView.getHeaderViewsCount(), i.this.getItemId(fVar.position));
                        com.tencent.mm.hellhoundlib.a.a.a(onItemLongClick, this, "com/tencent/mm/ui/conversation/ConversationWithCacheAdapter$8", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                        AppMethodBeat.o(38490);
                        return onItemLongClick;
                    }
                }
            });
            fVar.gvv = (ImageView) c2.findViewById(R.id.x1);
            a.b.c(fVar.gvv, str);
            com.tencent.mm.pluginsdk.ui.a aVar = (com.tencent.mm.pluginsdk.ui.a) fVar.gvv.getDrawable();
            if (this.QbN != null) {
                this.QbN.a(aVar);
            }
            fVar.gvv.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                /* class com.tencent.mm.ui.conversation.i.AnonymousClass10 */

                public final boolean onPreDraw() {
                    AppMethodBeat.i(38491);
                    fVar.gvv.getViewTreeObserver().removeOnPreDrawListener(this);
                    int width = fVar.gvv.getWidth();
                    int aH = at.aH(i.this.context, R.dimen.ij);
                    if (width != aH) {
                        Log.i("MicroMsg.ConversationWithCacheAdapter", "mainUI avatar size error, avatarViewWidth:%s, avatarSettingWidth:%s", Integer.valueOf(width), Integer.valueOf(aH));
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) fVar.gvv.getLayoutParams();
                        layoutParams.width = aH;
                        layoutParams.height = aH;
                        fVar.gvv.setLayoutParams(layoutParams);
                        Log.i("MicroMsg.ConversationWithCacheAdapter", "reset avatar size : %s", Integer.valueOf(fVar.gvv.getWidth()));
                        if (!i.this.QeC) {
                            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1055, 4, 1, false);
                            Log.i("MicroMsg.ConversationWithCacheAdapter", "report avatar size error !!! ");
                            i.this.QeC = true;
                        }
                    }
                    AppMethodBeat.o(38491);
                    return true;
                }
            });
            fVar.PaE = (NoMeasuredTextView) c2.findViewById(R.id.fzg);
            fVar.PaE.setLayoutCallback(this.PSx);
            fVar.PaF = (NoMeasuredTextView) c2.findViewById(R.id.j0l);
            fVar.QeQ = (ImageView) c2.findViewById(R.id.e7u);
            fVar.PaG = (NoMeasuredTextView) c2.findViewById(R.id.e7t);
            fVar.plf = (TextView) c2.findViewById(R.id.iot);
            fVar.QeR = (WeImageView) c2.findViewById(R.id.dwf);
            fVar.PaJ = c2.findViewById(R.id.x9);
            fVar.Qcs = (ImageView) c2.findViewById(R.id.eqt);
            fVar.QeS = (ImageView) c2.findViewById(R.id.fok);
            fVar.plf.setBackgroundResource(v.kH(this.context));
            fVar.plf.setTextSize(0, ((float) com.tencent.mm.cb.a.aH(this.context, R.dimen.ane)) * com.tencent.mm.cb.a.ji(this.context));
            fVar.QeT = new c();
            c2.setTag(fVar);
            fVar.PaG.setTextSize(0, (float) com.tencent.mm.cb.a.aG(this.context, R.dimen.ka));
            fVar.PaF.setTextSize(0, (float) com.tencent.mm.cb.a.aG(this.context, R.dimen.kc));
            fVar.PaE.setTextSize(0, (float) com.tencent.mm.cb.a.aG(this.context, R.dimen.is));
            this.Qez = fVar.PaE.getTextSize();
            fVar.PaG.setTextColor(this.Pav[0]);
            fVar.PaF.setTextColor(this.Pav[4]);
            fVar.PaE.setTextColor(this.Pav[3]);
            fVar.PaG.setShouldEllipsize(true);
            fVar.PaF.setShouldEllipsize(false);
            fVar.PaE.setShouldEllipsize(true);
            if (fVar.PaE.getPaint() != null) {
                ao.a(fVar.PaE.getPaint(), 0.1f);
            }
            fVar.PaF.setGravity(5);
            view2 = c2;
        } else {
            fVar = (f) view.getTag();
            view2 = view;
        }
        d j2 = j(azVar);
        fVar.position = i2;
        fVar.username = str;
        fVar.PaB = j2.PaB && azVar.field_conversationTime != -1;
        if (j2.Qce == null) {
            j2.Qce = b(azVar, (int) fVar.PaG.getTextSize(), j2.Qcl);
        }
        if (ab.Js(azVar.field_username) && j2.Qce != null) {
            d dVar = d.QbK;
            if (d.gVo()) {
                com.tencent.mm.storage.v vVar = com.tencent.mm.storage.v.NPH;
                com.tencent.mm.storage.v.aO(j2.Qce.toString(), i2, azVar.field_unReadCount);
                com.tencent.mm.plugin.brandservice.b.c cVar = com.tencent.mm.plugin.brandservice.b.c.pne;
                com.tencent.mm.plugin.brandservice.b.c.t(1, "", "");
            }
        }
        if (j2.Qcd == null) {
            j2.Qcd = i(azVar);
        }
        if (j2.Qcl) {
            fVar.PaG.setTextColor(this.Pav[0]);
        } else {
            fVar.PaG.setTextColor(this.Pav[j2.qcr]);
        }
        h.oc(fVar.PaG.getWidth());
        h.od((int) fVar.PaG.getTextSize());
        h.b(fVar.PaG.getPaint());
        if (ab.Iy(str) || ab.IB(str)) {
            fVar.PaE.setCompoundRightDrawablesWithIntrinsicBounds(R.raw.open_im_main_logo);
            fVar.PaE.setDrawRightDrawable(true);
        } else if (fVar.PaE.OVM) {
            fVar.PaE.setDrawRightDrawable(false);
        }
        int i5 = j2.Qcf;
        if (i5 != -1) {
            fVar.PaG.setCompoundLeftDrawablesWithIntrinsicBounds(i5);
            fVar.PaG.setDrawLeftDrawable(true);
            Log.i("MicroMsg.ConversationWithCacheAdapter", "userName:%s, status:%d", str, Integer.valueOf(j2.Qcf));
        } else {
            fVar.PaG.setDrawLeftDrawable(false);
            fVar.PaG.invalidate();
        }
        if (as.bjp(azVar.field_username)) {
            this.Qey.Cy(azVar.field_username);
            as eFa = this.Qey.eFa();
            String str2 = "";
            if (eFa != null) {
                str2 = ((com.tencent.mm.openim.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.openim.a.a.class)).bN(eFa.field_openImAppid, eFa.field_descWordingId);
            }
            if (!Util.isNullOrNil(str2)) {
                if ("3552365301".equals(eFa.field_openImAppid)) {
                    str2 = "@".concat(String.valueOf(str2));
                }
                fVar.PaE.aR(str2, R.color.wh, 14);
            } else {
                fVar.PaE.aR(null, 0, 0);
            }
        } else {
            ab.Iy(azVar.field_username);
            fVar.PaE.aR(null, 0, 0);
        }
        fVar.PaE.setText(j2.nickName);
        ViewGroup.LayoutParams layoutParams = fVar.PaF.getLayoutParams();
        if (j2.Qcd.length() >= 9) {
            if (layoutParams.width != this.QbW) {
                layoutParams.width = this.QbW;
                fVar.PaF.setLayoutParams(layoutParams);
            }
        } else if (layoutParams.width != this.QbV) {
            layoutParams.width = this.QbV;
            fVar.PaF.setLayoutParams(layoutParams);
        }
        fVar.PaF.setText(j2.Qcd);
        fVar.PaG.setText(j2.Qce);
        boolean z = com.tencent.mm.plugin.messenger.foundation.a.a.a.a(azVar, 7, 0) > 0;
        Object[] objArr2 = new Object[11];
        objArr2[0] = Integer.valueOf(i2);
        objArr2[1] = azVar.field_username;
        objArr2[2] = Long.valueOf(azVar.field_conversationTime);
        objArr2[3] = j2.Qcd;
        objArr2[4] = Boolean.valueOf(fVar.PaB);
        objArr2[5] = Boolean.valueOf(z);
        objArr2[6] = Long.valueOf(azVar.field_flag);
        objArr2[7] = Long.valueOf(azVar.field_flag & 72057594037927935L);
        if (j2.nickName == null || j2.nickName.length() <= 0) {
            obj = "?";
        } else {
            obj = Character.valueOf(j2.nickName.charAt(0));
        }
        objArr2[8] = obj;
        objArr2[9] = Integer.valueOf(azVar.field_unReadCount);
        objArr2[10] = Integer.valueOf(azVar.field_hbMarkRed);
        Log.i("MicroMsg.ConversationWithCacheAdapter", "[getView] position=%s username=%s conversationTime=%s updateTime=%s isPlacedTop=%s isTalkRoomTopPlace=%s flag=%s flagTime=%s nickname=%s unread=%s, hbMarkRed=%s", objArr2);
        if (z && 0 != com.tencent.mm.plugin.messenger.foundation.a.a.a.a(azVar, 7, 0)) {
            azVar.yB(com.tencent.mm.plugin.messenger.foundation.a.a.a.a(azVar, 6, azVar.field_conversationTime));
            bg.aVF();
            com.tencent.mm.model.c.aST().a(azVar, azVar.field_username);
        }
        fVar.QeQ.setVisibility(8);
        fVar.QeR.setVisibility(8);
        fVar.QeR.setImageDrawable(ar.m(this.context, R.raw.icons_outlined_bellring_off, this.context.getResources().getColor(R.color.en)));
        if (j2.tcb) {
            if (j2.Qcn) {
                fVar.QeR.setVisibility(0);
            }
        } else if (j2.Qcj) {
            fVar.QeR.setVisibility(0);
        }
        a.b.c(fVar.gvv, str);
        if (this.QbL) {
            Log.i("MicroMsg.ConversationWithCacheAdapter", "handleShowTipCnt.");
            if (azVar == null || fVar == null || j2 == null) {
                Log.w("MicroMsg.ConversationWithCacheAdapter", "handle show tip cnt, but conversation or viewholder is null");
            } else {
                fVar.plf.setVisibility(4);
                fVar.PaJ.setVisibility(4);
                if (ab.IJ(azVar.field_username) || !j2.Qcm || !(j2.Qch == 1 || j2.Qch == 2 || j2.Qch == 3)) {
                    colorStateList = this.Pav[3];
                } else {
                    colorStateList = this.Pav[2];
                }
                fVar.PaE.setTextColor(colorStateList);
                if (!j2.Qcm || j2.Qcg == 0) {
                    Log.w("MicroMsg.ConversationWithCacheAdapter", "handle show tip count, but talker is null");
                }
                int k = k(azVar);
                if (k == 1) {
                    fVar.PaJ.setVisibility(0);
                } else if (k == 2) {
                    int i6 = azVar.field_unReadCount;
                    if (i6 > 99) {
                        fVar.plf.setText("");
                        fVar.plf.setBackgroundResource(R.raw.badge_count_more);
                        fVar.plf.setVisibility(0);
                    } else if (i6 > 0) {
                        fVar.plf.setText(new StringBuilder().append(azVar.field_unReadCount).toString());
                        fVar.plf.setVisibility(0);
                        fVar.plf.setBackgroundResource(v.aQ(this.context, i6));
                    }
                    this.QeA.Qcc = i6;
                }
            }
        }
        if (!j2.Qci && j2.PaB && bg.aAc()) {
            bg.aVF();
            com.tencent.mm.model.c.aST().g(azVar);
        }
        if (this.Qev != null && this.Qev.equals(str)) {
            Log.i("MicroMsg.ConversationWithCacheAdapter", "convertView:%s, clickUsername:%s", Integer.valueOf(view2.hashCode()), this.Qev);
            view2.findViewById(R.id.bg1).setBackground(this.Qew);
        } else if (!j2.PaB || azVar.field_conversationTime == -1) {
            view2.findViewById(R.id.bg1).setBackgroundResource(R.drawable.r1);
        } else {
            view2.findViewById(R.id.bg1).setBackgroundResource(R.drawable.a_9);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            view2.findViewById(R.id.bg1).setOnTouchListener(new View.OnTouchListener() {
                /* class com.tencent.mm.ui.conversation.i.AnonymousClass2 */

                @TargetApi(21)
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(38483);
                    view.findViewById(R.id.bg1).getBackground().setHotspot(motionEvent.getX(), motionEvent.getY());
                    AppMethodBeat.o(38483);
                    return false;
                }
            });
        }
        if (com.tencent.mm.bi.d.jpA == null || !com.tencent.mm.bi.d.jpA.PZ(azVar.field_username)) {
            fVar.Qcs.setVisibility(8);
        } else {
            fVar.Qcs.setVisibility(0);
        }
        if (!ab.Eq(azVar.field_username) || com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.multitalk.model.d.class) == null || !((com.tencent.mm.plugin.multitalk.model.d) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.multitalk.model.d.class)).aFJ(azVar.field_username)) {
            fVar.QeS.setVisibility(8);
        } else {
            if (!((com.tencent.mm.plugin.multitalk.model.d) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.multitalk.model.d.class)).emr() || !((com.tencent.mm.plugin.multitalk.model.d) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.multitalk.model.d.class)).iL(azVar.field_username, z.aTY())) {
                fVar.QeS.setImageDrawable(ar.m(this.context, R.raw.icons_filled_groupcall, this.context.getResources().getColor(R.color.en)));
            } else {
                fVar.QeS.setImageResource(R.raw.chatlist_multitalk_highlight_icon);
            }
            fVar.QeS.setVisibility(0);
        }
        ((com.tencent.mm.plugin.textstatus.a.c) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).setTextWithStatus(fVar.PaE, str, a.b.CONVERSATION_LIST);
        this.QeA.content = String.valueOf(j2.Qce);
        this.QeA.nickName = j2.gCv;
        this.QeA.time = String.valueOf(j2.Qcd);
        a aVar2 = this.QeA;
        a.C2075a.OLX.a(view2, aVar2.nickName, aVar2.Qcc, aVar2.time, aVar2.content);
        view2.setAlpha(1.0f);
        AppMethodBeat.o(38503);
        return view2;
    }

    private void a(d dVar, as asVar) {
        AppMethodBeat.i(38505);
        if (dVar.tcb && dVar.gCv == null) {
            dVar.nickName = this.context.getString(R.string.b25);
            AppMethodBeat.o(38505);
        } else if (as.bjp(asVar.field_username)) {
            dVar.nickName = ((com.tencent.mm.openim.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.openim.a.a.class)).e(MMApplicationContext.getContext(), dVar.gCv, com.tencent.mm.cb.a.aG(this.context, R.dimen.is));
            AppMethodBeat.o(38505);
        } else {
            dVar.nickName = l.e(this.context, (CharSequence) dVar.gCv, com.tencent.mm.cb.a.aG(this.context, R.dimen.is));
            AppMethodBeat.o(38505);
        }
    }

    class a {
        public int Qcc;
        public String content;
        public String nickName;
        public String time;

        private a() {
        }

        /* synthetic */ a(i iVar, byte b2) {
            this();
        }
    }

    static int k(az azVar) {
        AppMethodBeat.i(234151);
        if (azVar == null || azVar.field_unReadCount <= 0) {
            if ((azVar.oV(TPMediaCodecProfileLevel.HEVCHighTierLevel61) || azVar.oV(TPMediaCodecProfileLevel.HEVCHighTierLevel6)) && azVar.field_unReadMuteCount > 0) {
                AppMethodBeat.o(234151);
                return 1;
            }
            AppMethodBeat.o(234151);
            return 0;
        } else if (!ab.Js(azVar.field_username)) {
            if (ab.Jx(azVar.field_username)) {
                bg.aVF();
                if (!com.tencent.mm.model.c.azQ().getBoolean(ar.a.USERINFO_SERVICE_NOTIFY_MESSAGE_NOTICE_BOOLEAN_SYNC, true)) {
                    AppMethodBeat.o(234151);
                    return 1;
                }
            }
            if (ab.JB(azVar.field_username)) {
                bg.aVF();
                if (!com.tencent.mm.model.c.azQ().getBoolean(ar.a.USERINFO_WXA_CUSTOM_SESSION_MESSAGE_NOTICE_BOOLEAN_SYNC, true)) {
                    AppMethodBeat.o(234151);
                    return 1;
                }
            }
            bg.aVF();
            as Kn = com.tencent.mm.model.c.aSN().Kn(azVar.field_username);
            if (!(Kn == null || ((int) Kn.gMZ) == 0)) {
                if (Kn.Zx() && Kn.amU()) {
                    AppMethodBeat.o(234151);
                    return 1;
                } else if (ab.Eq(azVar.field_username) && Kn.fuH == 0) {
                    AppMethodBeat.o(234151);
                    return 1;
                }
            }
            if (ab.JC(azVar.field_username)) {
                AppMethodBeat.o(234151);
                return 1;
            }
            AppMethodBeat.o(234151);
            return 2;
        } else if (!com.tencent.mm.storage.ab.clc() || azVar.oV(16) || azVar.oV(64)) {
            AppMethodBeat.o(234151);
            return 1;
        } else {
            AppMethodBeat.o(234151);
            return 0;
        }
    }

    private static int ahn(String str) {
        int i2 = 1;
        AppMethodBeat.i(38507);
        if (str != null && str.length() > 0) {
            try {
                i2 = Integer.valueOf(str).intValue();
            } catch (NumberFormatException e2) {
            }
        }
        AppMethodBeat.o(38507);
        return i2;
    }

    public final void clearCache() {
        AppMethodBeat.i(38508);
        if (this.Pax != null) {
            this.Pax.clear();
            this.Qeq = true;
        }
        AppMethodBeat.o(38508);
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
        public boolean Qcl;
        public boolean Qcm;
        public boolean Qcn;
        public boolean Qco;
        public String gCv;
        public CharSequence nickName;
        public int qcr;
        public boolean tcb;

        private d() {
        }

        /* synthetic */ d(i iVar, byte b2) {
            this();
        }
    }

    class c {
        public View OSi = null;
        boolean QeI = false;
        boolean QeJ = false;
        boolean QeK = false;
        boolean QeL = false;
        boolean QeM = false;
        public ImageView QeN = null;
        public TextView QeO = null;
        public View QeP = null;
        public View plg = null;
        public TextView plh = null;
        String username = "";

        c() {
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x050e  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0565  */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x07a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.CharSequence b(com.tencent.mm.storage.az r13, int r14, boolean r15) {
        /*
        // Method dump skipped, instructions count: 2134
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.conversation.i.b(com.tencent.mm.storage.az, int, boolean):java.lang.CharSequence");
    }

    private CharSequence j(int i2, String str, String str2, int i3) {
        k.b HD;
        AppMethodBeat.i(234152);
        czg czg = new czg();
        if (i2 == 889192497) {
            czg = ((com.tencent.mm.plugin.patmsg.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.patmsg.a.b.class)).aJJ(str);
        } else if (i2 == 922746929 && (HD = k.b.HD(str)) != null) {
            czg = ((com.tencent.mm.plugin.patmsg.a.a) HD.as(com.tencent.mm.plugin.patmsg.a.a.class)).ARl;
        }
        try {
            if (czg.yVw.size() > 0) {
                czh last = czg.yVw.getLast();
                com.tencent.mm.plugin.patmsg.a.f parseDisplayTemplate = ((PluginPatMsg) com.tencent.mm.kernel.g.ah(PluginPatMsg.class)).parseDisplayTemplate(last.iBd, str2);
                SpannableString spannableString = new SpannableString(parseDisplayTemplate.result);
                String aTY = z.aTY();
                if (!last.dRL.equals(aTY) && last.MEA.equals(aTY) && last.MEB == 0 && !parseDisplayTemplate.ARm.isEmpty()) {
                    BoldForegroundColorSpan boldForegroundColorSpan = new BoldForegroundColorSpan(this.context.getResources().getColor(R.color.FG_0));
                    String string = this.context.getString(R.string.fjm);
                    int indexOf = parseDisplayTemplate.result.indexOf(string, ((Integer) parseDisplayTemplate.ARm.get(0).second).intValue());
                    int length = string.length() + indexOf;
                    if (length > spannableString.length()) {
                        length = spannableString.length();
                    }
                    spannableString.setSpan(boldForegroundColorSpan, indexOf, length, 17);
                }
                SpannableString d2 = l.d(this.context, spannableString, (float) i3);
                AppMethodBeat.o(234152);
                return d2;
            }
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ConversationWithCacheAdapter", e2, "", new Object[0]);
        }
        AppMethodBeat.o(234152);
        return "";
    }

    private static String bmp(String str) {
        AppMethodBeat.i(38511);
        if (str == null || str.length() != 32) {
            AppMethodBeat.o(38511);
            return null;
        }
        String amp = ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().amp(str);
        AppMethodBeat.o(38511);
        return amp;
    }

    /* Return type fixed from 'com.tencent.mm.storagebase.a.d' to match base method */
    @Override // com.tencent.mm.ui.f
    public final com.tencent.mm.storagebase.a.d<String> gGY() {
        AppMethodBeat.i(38512);
        Log.d("MicroMsg.ConversationWithCacheAdapter", "createCursor");
        bg.aVF();
        com.tencent.mm.storagebase.a.d dVar = (com.tencent.mm.storagebase.a.d) com.tencent.mm.model.c.aST().a(ab.iCF, this.gzY, com.tencent.mm.o.a.gNj, true);
        AppMethodBeat.o(38512);
        return dVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.storagebase.a.d] */
    @Override // com.tencent.mm.ui.f
    public final com.tencent.mm.ui.f<String, az>.c b(com.tencent.mm.storagebase.a.d<String> dVar) {
        AppMethodBeat.i(234153);
        com.tencent.mm.ui.f<String, az>.c cVar = new f.c(dVar, (byte) 0);
        AppMethodBeat.o(234153);
        return cVar;
    }

    @Override // com.tencent.mm.ui.f
    public final ArrayList<az> bo(ArrayList<String> arrayList) {
        AppMethodBeat.i(38513);
        Log.d("MicroMsg.ConversationWithCacheAdapter", "rebulidAllChangeData obj.size() %d", Integer.valueOf(arrayList.size()));
        ArrayList<az> arrayList2 = new ArrayList<>(arrayList.size());
        bg.aVF();
        Cursor a2 = com.tencent.mm.model.c.aST().a(arrayList, ab.iCF, this.gzY, com.tencent.mm.o.a.gNj);
        while (a2.moveToNext()) {
            az azVar = new az();
            azVar.convertFrom(a2);
            arrayList2.add(azVar);
        }
        a2.close();
        AppMethodBeat.o(38513);
        return arrayList2;
    }

    @Override // com.tencent.mm.ui.f
    public final SparseArray<String>[] a(HashSet<f.b<String, az>> hashSet, SparseArray<String>[] sparseArrayArr) {
        boolean z;
        AppMethodBeat.i(38514);
        if (sparseArrayArr == null || sparseArrayArr.length <= 0 || !com.tencent.mm.kernel.g.aAc()) {
            AppMethodBeat.o(38514);
        } else {
            Log.d("MicroMsg.ConversationWithCacheAdapter", "refreshPosistion events size %d oldPosistion size %d", Integer.valueOf(hashSet.size()), Integer.valueOf(sparseArrayArr[0].size()));
            ArrayList<String> arrayList = new ArrayList<>();
            Iterator<f.b<String, az>> it = hashSet.iterator();
            while (it.hasNext()) {
                f.b<String, az> next = it.next();
                if (!(next == null || next.OAa == 5 || arrayList.contains(next.object))) {
                    Log.d("MicroMsg.ConversationWithCacheAdapter", "searchArray.add(event.object) " + ((String) next.object));
                    arrayList.add(next.object);
                }
            }
            HashMap hashMap = new HashMap();
            bg.aVF();
            Cursor a2 = com.tencent.mm.model.c.aST().a(arrayList, ab.iCF, this.gzY, com.tencent.mm.o.a.gNj);
            while (a2.moveToNext()) {
                az azVar = new az();
                azVar.convertFrom(a2);
                hashMap.put(azVar.field_username, azVar);
            }
            a2.close();
            Iterator<f.b<String, az>> it2 = hashSet.iterator();
            while (it2.hasNext()) {
                f.b<String, az> next2 = it2.next();
                if (next2 != null) {
                    if (next2.OAa != 5) {
                        StringBuilder append = new StringBuilder("evnet name,").append((String) next2.object).append("  event.newObj   ==");
                        if (hashMap.get(next2.object) == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        Log.d("MicroMsg.ConversationWithCacheAdapter", append.append(z).toString());
                        next2.OAb = (T) hashMap.get(next2.object);
                    } else {
                        next2.OAb = null;
                    }
                }
            }
            arrayList.clear();
            hashMap.clear();
            HashMap<String, az> hashMap2 = new HashMap<>();
            Iterator<f.b<String, az>> it3 = hashSet.iterator();
            while (it3.hasNext()) {
                f.b<String, az> next3 = it3.next();
                if (next3 != null) {
                    a(next3, sparseArrayArr[0], hashMap2);
                    if (next3.OAa != 5) {
                        hashMap2.put(next3.object, next3.OAb);
                    }
                }
            }
            AppMethodBeat.o(38514);
        }
        return sparseArrayArr;
    }

    private az f(String str, HashMap<String, az> hashMap) {
        com.tencent.mm.storagebase.a.a ee;
        AppMethodBeat.i(38515);
        if (hashMap == null || !hashMap.containsKey(str)) {
            if (this.OzM == null) {
                ee = null;
            } else {
                ee = this.OzM.Ouf.ee(str);
            }
            az azVar = (az) ee;
            AppMethodBeat.o(38515);
            return azVar;
        }
        az azVar2 = hashMap.get(str);
        AppMethodBeat.o(38515);
        return azVar2;
    }

    private SparseArray<String> a(f.b<String, az> bVar, SparseArray<String> sparseArray, HashMap<String, az> hashMap) {
        int i2;
        int i3;
        boolean z;
        boolean z2;
        int i4;
        AppMethodBeat.i(38516);
        K k = bVar.object;
        int size = sparseArray.size();
        T t = bVar.OAb;
        int size2 = sparseArray.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size2) {
                i5 = -1;
                break;
            } else if (sparseArray.get(i5).equals(k)) {
                break;
            } else {
                i5++;
            }
        }
        Log.d("MicroMsg.ConversationWithCacheAdapter", "resortPosition username %s,  size %d, position %d", k, Integer.valueOf(size), Integer.valueOf(i5));
        switch (bVar.OAa) {
            case 2:
                if (t != null) {
                    if (i5 < 0) {
                        int i6 = 0;
                        while (i6 < size && f(sparseArray.get(i6), hashMap).field_flag > t.field_flag) {
                            i6++;
                        }
                        for (int i7 = size; i7 > i6; i7--) {
                            sparseArray.put(i7, sparseArray.get(i7 - 1));
                        }
                        sparseArray.put(i6, k);
                        AppMethodBeat.o(38516);
                        break;
                    }
                } else {
                    Log.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_INSERT  cov == null");
                    if (i5 >= 0) {
                        Log.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_INSERT  cov == null delete it username %s", k);
                        while (i5 < size - 1) {
                            sparseArray.put(i5, sparseArray.get(i5 + 1));
                            i5++;
                        }
                        sparseArray.remove(size - 1);
                    }
                    AppMethodBeat.o(38516);
                    break;
                }
                break;
            case 3:
            case 4:
            default:
                if (i5 < 0) {
                    Log.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_UPDATE  position < 0");
                    AppMethodBeat.o(38516);
                    break;
                } else {
                    az f2 = f(k, hashMap);
                    if (t == null) {
                        Log.e("MicroMsg.ConversationWithCacheAdapter", "CursorDataAdapter.CHANGE_TYPE_UPDATE  cov == null delete it username %s", k);
                        while (i5 < size - 1) {
                            sparseArray.put(i5, sparseArray.get(i5 + 1));
                            i5++;
                        }
                        sparseArray.remove(size - 1);
                        AppMethodBeat.o(38516);
                        break;
                    } else {
                        long j2 = f2.field_flag;
                        long j3 = t.field_flag;
                        if (j2 == j3) {
                            AppMethodBeat.o(38516);
                            break;
                        } else {
                            if (j2 < j3) {
                                i2 = 0;
                                i3 = i5 - 1;
                                z = true;
                            } else {
                                i2 = i5 + 1;
                                i3 = size - 1;
                                z = false;
                            }
                            int i8 = i2;
                            while (true) {
                                if (i8 > i3) {
                                    z2 = false;
                                } else if (f(sparseArray.get(i8), hashMap).field_flag <= t.field_flag) {
                                    z2 = true;
                                } else {
                                    i8++;
                                }
                            }
                            Log.i("MicroMsg.ConversationWithCacheAdapter", "resortPosition: begin-%d end-%d tempUpdate-%d found-%b position-%d username-%s", Integer.valueOf(i2), Integer.valueOf(i3), -1, Boolean.valueOf(z2), Integer.valueOf(i5), k);
                            if (!z2) {
                                AppMethodBeat.o(38516);
                                break;
                            } else {
                                if (z) {
                                    while (i5 > i8) {
                                        sparseArray.put(i5, sparseArray.get(i5 - 1));
                                        i5--;
                                    }
                                    i4 = i8;
                                } else {
                                    i4 = i8 - 1;
                                    while (i5 < i4) {
                                        sparseArray.put(i5, sparseArray.get(i5 + 1));
                                        i5++;
                                    }
                                }
                                sparseArray.put(i4, k);
                                AppMethodBeat.o(38516);
                                break;
                            }
                        }
                    }
                }
            case 5:
                if (i5 < 0) {
                    AppMethodBeat.o(38516);
                    break;
                } else {
                    while (i5 < size - 1) {
                        sparseArray.put(i5, sparseArray.get(i5 + 1));
                        i5++;
                    }
                    sparseArray.remove(size - 1);
                    AppMethodBeat.o(38516);
                    break;
                }
        }
        return sparseArray;
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        as Kn;
        boolean z;
        AppMethodBeat.i(38517);
        if (obj == null || !(obj instanceof String)) {
            Log.d("MicroMsg.ConversationWithCacheAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i2), mStorageEx, obj);
            AppMethodBeat.o(38517);
            return;
        }
        String str = (String) obj;
        if (mStorageEx instanceof bw) {
            Log.i("MicroMsg.ConversationWithCacheAdapter", "unreadcheck onConversationStorageNotifyChange event type %d, username %s", Integer.valueOf(i2), str);
            if (!str.contains("@") || str.endsWith("@chatroom") || str.endsWith("@im.chatroom") || str.endsWith("@micromsg.qq.com") || as.bjp(str)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                AppMethodBeat.o(38517);
                return;
            }
            if (this.Pax != null) {
                if (!obj.equals("")) {
                    this.Qep.add(str);
                } else if (i2 == 5) {
                    this.Qeq = true;
                    super.o(null, 1);
                    AppMethodBeat.o(38517);
                    return;
                }
            }
            if (i2 == 3) {
                i2 = 2;
            }
            super.o(str, i2);
            AppMethodBeat.o(38517);
            return;
        }
        if (mStorageEx instanceof bv) {
            Log.i("MicroMsg.ConversationWithCacheAdapter", "unreadcheck onContactStorageNotifyChange event type %d, username %s", Integer.valueOf(i2), obj);
            if (!Util.isNullOrNil(str) && (Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(str)) != null && ((int) Kn.gMZ) > 0) {
                Log.i("MicroMsg.ConversationWithCacheAdapter", "unreadcheck onContactStorageNotifyChange contact isMute %s, ChatRoomNotify %d", Boolean.valueOf(Kn.Zx()), Integer.valueOf(Kn.fuH));
            }
            if (this.yJA) {
                AppMethodBeat.o(38517);
                return;
            }
            this.Qeo = true;
            if (i2 == 5 || i2 == 2) {
                AppMethodBeat.o(38517);
                return;
            } else if (this.Pax == null || !this.Pax.containsKey(str)) {
                AppMethodBeat.o(38517);
                return;
            } else if (this.Qek != null) {
                this.Qek.add(str);
            }
        }
        AppMethodBeat.o(38517);
    }

    private void gVN() {
        boolean z;
        d dVar;
        AppMethodBeat.i(38518);
        if (this.Pax == null || this.Qek == null || this.Qek.isEmpty()) {
            AppMethodBeat.o(38518);
            return;
        }
        Log.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents contactEvents size %d", Integer.valueOf(this.Qek.size()));
        Iterator<String> it = this.Qek.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            String next = it.next();
            if (next != null && !next.equals("") && this.Pax.containsKey(next) && (dVar = this.Pax.get(next)) != null) {
                this.Qey.Cy(next);
                boolean Eq = ab.Eq(next);
                as eFa = this.Qey.eFa();
                if (eFa != null) {
                    String a2 = aa.a(eFa, next, Eq);
                    Log.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents newdisplayname %s old dispalyname %s", a2, dVar.gCv);
                    if (a2 != null && !a2.equals(dVar.gCv)) {
                        dVar.gCv = a2;
                        a(dVar, eFa);
                        z2 = true;
                    }
                    boolean Zx = eFa.Zx();
                    boolean z3 = eFa.fuH == 0;
                    if (!(dVar.Qcj == Zx && z3 == dVar.Qcn)) {
                        dVar.Qcj = Zx;
                        dVar.Qcn = z3;
                        dVar.Qco = eFa.amU();
                        Log.d("MicroMsg.ConversationWithCacheAdapter", "dealWithContactEvents in cache username %s mute change", next);
                        z = true;
                        z2 = z;
                    }
                }
            }
            z = z2;
            z2 = z;
        }
        if (z2) {
            notifyDataSetChanged();
        }
        this.Qek.clear();
        AppMethodBeat.o(38518);
    }

    @Override // com.tencent.mm.ui.f
    public final boolean gFx() {
        AppMethodBeat.i(38519);
        boolean gFx = super.gFx();
        AppMethodBeat.o(38519);
        return gFx;
    }

    public final void anR(int i2) {
        az azVar;
        AppMethodBeat.i(38521);
        if (i2 < 0 || i2 >= getCount()) {
            AppMethodBeat.o(38521);
            return;
        }
        try {
            azVar = (az) getItem(i2);
        } catch (NullPointerException e2) {
            Log.w("MicroMsg.ConversationWithCacheAdapter", "preLoad position:%s is null!", Integer.valueOf(i2));
            azVar = null;
        }
        if (azVar == null) {
            AppMethodBeat.o(38521);
            return;
        }
        a.b.gov().fZ(azVar.field_username);
        AppMethodBeat.o(38521);
    }

    private static boolean gVO() {
        AppMethodBeat.i(234154);
        boolean a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_appbrand_notify_msg_enable, false);
        Log.i("MicroMsg.ConversationWithCacheAdapter", "isShowAppBrandNotifyMsgEntry: %b", Boolean.valueOf(a2));
        AppMethodBeat.o(234154);
        return a2;
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.i(38522);
        if (!this.QeD) {
            super.notifyDataSetChanged();
            this.Qem.clear();
        }
        Log.i("MicroMsg.ConversationWithCacheAdapter", "clear usernamePositionMap");
        AppMethodBeat.o(38522);
    }

    private CharSequence i(az azVar) {
        AppMethodBeat.i(38495);
        if (azVar.field_status == 1) {
            String string = this.context.getString(R.string.evg);
            AppMethodBeat.o(38495);
            return string;
        } else if (azVar.field_conversationTime == MAlarmHandler.NEXT_FIRE_INTERVAL) {
            AppMethodBeat.o(38495);
            return "";
        } else {
            CharSequence c2 = com.tencent.mm.pluginsdk.i.f.c(this.context, azVar.field_conversationTime, true);
            AppMethodBeat.o(38495);
            return c2;
        }
    }

    /* access modifiers changed from: package-private */
    public final d j(az azVar) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        String[] split;
        d dVar;
        boolean z5 = true;
        AppMethodBeat.i(38504);
        String str = azVar.field_username;
        if (this.Pax == null || (dVar = this.Pax.get(str)) == null) {
            d dVar2 = new d(this, (byte) 0);
            this.Qey.Cy(str);
            as eFa = this.Qey.eFa();
            if (eFa != null) {
                dVar2.Qch = eFa.fuQ;
                dVar2.Qcg = (int) eFa.gMZ;
            } else {
                dVar2.Qch = -1;
                dVar2.Qcg = -1;
            }
            if (eFa != null) {
                z = true;
            } else {
                z = false;
            }
            dVar2.Qcm = z;
            if (eFa == null || !eFa.amU()) {
                z2 = false;
            } else {
                z2 = true;
            }
            dVar2.Qco = z2;
            if (eFa == null || eFa.fuH != 0) {
                z3 = false;
            } else {
                z3 = true;
            }
            dVar2.Qcn = z3;
            dVar2.tcb = ab.Iw(str);
            if (!dVar2.tcb || !dVar2.Qcn || azVar.field_unReadCount <= 0) {
                z4 = false;
            } else {
                z4 = true;
            }
            dVar2.Qcl = z4;
            dVar2.qcr = 0;
            if (ahn(azVar.field_msgType) == 34 && azVar.field_isSend == 0 && !Util.isNullOrNil(azVar.field_content)) {
                String str2 = azVar.field_content;
                if ((str.equals("qmessage") || str.equals("floatbottle") || str.equals("officialaccounts") || azVar.oV(TPMediaCodecProfileLevel.HEVCHighTierLevel6) || azVar.oV(TPMediaCodecProfileLevel.HEVCHighTierLevel61)) && (split = str2.split(":")) != null && split.length > 3) {
                    str2 = split[1] + ":" + split[2] + ":" + split[3];
                }
                if (!new p(str2).jsi) {
                    dVar2.qcr = 1;
                }
            }
            dVar2.gCv = aa.a(eFa, str, dVar2.tcb);
            a(dVar2, eFa);
            dVar2.Qcd = i(azVar);
            dVar2.Qcf = anD(azVar.field_status);
            dVar2.Qci = ab.a(azVar);
            bg.aVF();
            dVar2.PaB = com.tencent.mm.model.c.aST().h(azVar);
            if (eFa == null || !eFa.Zx()) {
                z5 = false;
            }
            dVar2.Qcj = z5;
            if (this.Pax != null) {
                this.Pax.put(str, dVar2);
            }
            AppMethodBeat.o(38504);
            return dVar2;
        }
        AppMethodBeat.o(38504);
        return dVar;
    }

    private static String l(az azVar) {
        AppMethodBeat.i(38510);
        if (azVar.field_isSend != 0 || !ab.Eq(azVar.field_username)) {
            String displayName = aa.getDisplayName(azVar.field_digestUser);
            AppMethodBeat.o(38510);
            return displayName;
        }
        String displayName2 = aa.getDisplayName(azVar.field_digestUser, azVar.field_username);
        AppMethodBeat.o(38510);
        return displayName2;
    }

    /* Return type fixed from 'com.tencent.mm.storagebase.a.a' to match base method */
    @Override // com.tencent.mm.ui.f
    public final /* synthetic */ az gFJ() {
        AppMethodBeat.i(38523);
        az azVar = new az();
        AppMethodBeat.o(38523);
        return azVar;
    }

    static /* synthetic */ void e(i iVar) {
        final View view;
        AppMethodBeat.i(38524);
        if (!iVar.gVL()) {
            Log.w("MicroMsg.ConversationWithCacheAdapter", "is not need dismissClickStatus");
            AppMethodBeat.o(38524);
        } else if (iVar.Qex == null || !iVar.Qex.isRunning()) {
            int i2 = 0;
            while (true) {
                if (i2 >= iVar.mListView.getChildCount()) {
                    Log.w("MicroMsg.ConversationWithCacheAdapter", "[findClickStatusView] can't found click view! username:%s", iVar.Qev);
                    view = null;
                    break;
                }
                View childAt = iVar.mListView.getChildAt(i2);
                if (childAt.getBackground() == iVar.Qew) {
                    view = childAt;
                    break;
                }
                i2++;
            }
            if (view == null) {
                iVar.Qev = null;
                AppMethodBeat.o(38524);
                return;
            }
            Log.i("MicroMsg.ConversationWithCacheAdapter", "[dismissClickStatus] %s username:%s", Integer.valueOf(view.hashCode()), iVar.Qev);
            final f fVar = (f) view.getTag();
            int color = view.getContext().getResources().getColor(R.color.FG_3);
            int color2 = view.getContext().getResources().getColor((fVar == null || !fVar.PaB) ? R.color.f3045c : R.color.f3046d);
            if (!ao.gJK() || !iVar.Qeu) {
                iVar.Qew = new ColorDrawable(com.tencent.mm.ui.ar.v(color, color2));
                final com.tencent.mm.plugin.appbrand.widget.c.a aVar = new com.tencent.mm.plugin.appbrand.widget.c.a(com.tencent.mm.ui.ar.v(color, color2), color2);
                view.setBackgroundColor(com.tencent.mm.ui.ar.v(color, color2));
                ValueAnimator ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(PropertyValuesHolder.ofFloat("ratio", 0.0f, 1.0f));
                ofPropertyValuesHolder.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    /* class com.tencent.mm.ui.conversation.i.AnonymousClass5 */

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AppMethodBeat.i(38486);
                        int aW = aVar.aW(((Float) valueAnimator.getAnimatedValue("ratio")).floatValue());
                        view.setBackgroundColor(aW);
                        i.this.Qew.setColor(aW);
                        AppMethodBeat.o(38486);
                    }
                });
                ofPropertyValuesHolder.addListener(new AnimatorListenerAdapter() {
                    /* class com.tencent.mm.ui.conversation.i.AnonymousClass6 */

                    public final void onAnimationEnd(Animator animator) {
                        AppMethodBeat.i(38487);
                        super.onAnimationEnd(animator);
                        if (fVar != null) {
                            i.a(i.this, view, fVar);
                        }
                        Log.i("MicroMsg.ConversationWithCacheAdapter", "[dismissClickStatus] setBackground back!");
                        AppMethodBeat.o(38487);
                    }
                });
                if (ao.gJK()) {
                    ofPropertyValuesHolder.setDuration(10L);
                } else {
                    ofPropertyValuesHolder.setDuration(60L);
                }
                if (iVar.Qew != null) {
                    ofPropertyValuesHolder.start();
                    iVar.Qex = ofPropertyValuesHolder;
                }
            }
            AppMethodBeat.o(38524);
        } else {
            Log.w("MicroMsg.ConversationWithCacheAdapter", "[dismissClickStatus] animation is running! %s", iVar.Qev);
            AppMethodBeat.o(38524);
        }
    }

    static /* synthetic */ void a(i iVar, View view, f fVar) {
        AppMethodBeat.i(234155);
        Log.i("MicroMsg.ConversationWithCacheAdapter", "[resetClickStatus]");
        if (!ao.gJK()) {
            view.setBackgroundResource(fVar.PaB ? R.drawable.a_9 : R.drawable.r1);
            iVar.Qev = null;
        }
        AppMethodBeat.o(234155);
    }
}
