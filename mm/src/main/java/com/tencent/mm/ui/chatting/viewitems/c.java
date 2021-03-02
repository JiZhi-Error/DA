package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.h;
import com.tencent.mm.al.i;
import com.tencent.mm.al.j;
import com.tencent.mm.al.l;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.di;
import com.tencent.mm.g.a.is;
import com.tencent.mm.g.a.ry;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ac;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.jsapi.k.r;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.game.api.b;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.textstatus.a.a;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.chat.l;
import com.tencent.mm.protocal.protobuf.fbw;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.a.a;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI;
import com.tencent.mm.ui.chatting.a;
import com.tencent.mm.ui.chatting.d.b.ae;
import com.tencent.mm.ui.chatting.d.b.f;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.t;
import com.tencent.mm.ui.chatting.view.ChattingAvatarImageView;
import com.tencent.mm.ui.chatting.viewitems.ChattingItemTranslate;
import com.tencent.mm.ui.chatting.viewitems.bd;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.widget.b.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.widget.textview.a;
import com.tencent.mm.vfs.s;
import com.tencent.smtt.sdk.TbsListener;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Future;

public abstract class c {
    private static boolean Pwq = false;
    private static long Pwr = 0;
    private View$OnLongClickListenerC2106c PGO;
    private a.f PGP;
    private d PGQ;
    private boolean PGR = false;
    protected t.b PGS;
    protected t.d PGT;
    protected t.c PGU;
    protected t.p PGV;
    protected t.h PGW;
    protected t.k PGX;
    protected t.e PGY;
    private Future PGZ = null;
    private final long PHa = 10800000;
    public boolean Pdm;
    protected boolean qoo;

    public abstract View a(LayoutInflater layoutInflater, View view);

    public abstract void a(a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str);

    public abstract boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar);

    public abstract boolean a(m mVar, View view, ca caVar);

    public abstract boolean bM(int i2, boolean z);

    public abstract boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar);

    public abstract boolean gTT();

    /* access modifiers changed from: protected */
    public boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, bq bqVar) {
        return false;
    }

    public static void D(ImageView imageView, String str) {
        if (Util.isNullOrNil(str)) {
            imageView.setImageResource(R.drawable.bca);
        } else {
            a.b.c(imageView, str);
        }
    }

    public static int kk(Context context) {
        float ez = com.tencent.mm.cb.a.ez(context);
        if (ez == com.tencent.mm.cb.a.iW(context)) {
            return com.tencent.mm.cb.a.aH(context, R.dimen.xc);
        }
        if (ez == com.tencent.mm.cb.a.iY(context)) {
            return com.tencent.mm.cb.a.aH(context, R.dimen.x6);
        }
        if (ez == com.tencent.mm.cb.a.iZ(context)) {
            return com.tencent.mm.cb.a.aH(context, R.dimen.xd);
        }
        if (ez == com.tencent.mm.cb.a.ja(context)) {
            return com.tencent.mm.cb.a.aH(context, R.dimen.wo);
        }
        if (ez == com.tencent.mm.cb.a.jb(context) || ez == com.tencent.mm.cb.a.jc(context) || ez == com.tencent.mm.cb.a.jd(context)) {
            return com.tencent.mm.cb.a.aH(context, R.dimen.wp);
        }
        return com.tencent.mm.cb.a.aH(context, R.dimen.xb);
    }

    public static int kl(Context context) {
        float ez = com.tencent.mm.cb.a.ez(context);
        if (!(ez == com.tencent.mm.cb.a.iW(context) || ez == com.tencent.mm.cb.a.iY(context))) {
            if (ez == com.tencent.mm.cb.a.iZ(context)) {
                return com.tencent.mm.cb.a.aH(context, R.dimen.wn);
            }
            if (ez == com.tencent.mm.cb.a.ja(context)) {
                return com.tencent.mm.cb.a.aH(context, R.dimen.wl);
            }
            if (ez == com.tencent.mm.cb.a.jb(context) || ez == com.tencent.mm.cb.a.jc(context) || ez == com.tencent.mm.cb.a.jd(context)) {
                return com.tencent.mm.cb.a.aH(context, R.dimen.wp);
            }
        }
        return com.tencent.mm.cb.a.aH(context, R.dimen.wm);
    }

    public static void E(ImageView imageView, String str) {
        if (Util.isNullOrNil(str)) {
            imageView.setImageResource(R.drawable.bar);
        } else {
            a.b.d(imageView, str);
        }
    }

    public final void a(a aVar, int i2, final com.tencent.mm.ui.chatting.e.a aVar2, ca caVar) {
        String str;
        com.tencent.mm.api.c gOM;
        long currentTimeMillis = System.currentTimeMillis();
        Pwr = currentTimeMillis;
        if (Pwr + 30000 < currentTimeMillis) {
            bg.aVF();
            Pwq = com.tencent.mm.model.c.isSDCardAvailable();
        }
        this.qoo = Pwq;
        if (gTU()) {
            str = a(aVar2, caVar);
            a(aVar, aVar2, caVar, str);
            a(aVar, aVar2, str, caVar);
        } else {
            str = null;
        }
        if (aVar.uploadingPB != null) {
            aVar.uploadingPB.setTag(R.id.axa, null);
            if (this.PGZ != null) {
                this.PGZ.cancel(true);
            }
            aVar.uploadingPB.setVisibility(8);
            aVar.uploadingPB.setTag(R.id.ax_, Long.valueOf(caVar.field_createTime));
        }
        a(aVar, i2, aVar2, caVar, str);
        if (!(aVar == null || aVar.convertView == null)) {
            aVar.convertView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                /* class com.tencent.mm.ui.chatting.viewitems.c.AnonymousClass1 */

                public final void onGlobalLayout() {
                    AppMethodBeat.i(233539);
                    if (aVar2.Pwl && c.this.c(aVar2) != null) {
                        c.this.c(aVar2).closeContextMenu();
                    }
                    AppMethodBeat.o(233539);
                }
            });
        }
        if (aVar2.GUe != null && aVar2.GUe.gBM() && (gOM = ((com.tencent.mm.ui.chatting.d.b.d) aVar2.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOM()) != null && gOM.UC()) {
            l.a(aVar2.GUe, caVar, i2, ((k) aVar2.bh(k.class)).getCount(), ((com.tencent.mm.ui.chatting.d.b.d) aVar2.bh(com.tencent.mm.ui.chatting.d.b.d.class)).ahy());
        }
    }

    /* access modifiers changed from: protected */
    public boolean gTU() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void a(a aVar, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
        CharSequence charSequence;
        if (str != null && aVar.userTV != null && caVar != null) {
            if (caVar.field_isSend == 0 && !Util.isNullOrNil(caVar.fQZ)) {
                h Nm = ag.bag().Nm(caVar.fQZ);
                boolean z = true;
                if (Nm == null || Util.isNullOrNil(Nm.field_openId) || Util.isNullOrNil(Nm.field_nickname)) {
                    Log.i("MicroMsg.ChattingItem", "fillingUsername:need getKfInfo");
                    charSequence = null;
                } else {
                    charSequence = Nm.field_nickname;
                    z = false;
                }
                if (z || j.a(Nm)) {
                    ag.bai().a(new b(aVar2, caVar.fQZ));
                    ag.bai().j(aVar2.getTalkerUserName(), caVar.fQZ, caVar.fRf);
                }
            } else if (!b(aVar2) || !((f) aVar2.bh(f.class)).gPh()) {
                charSequence = null;
            } else if (((com.tencent.mm.ui.chatting.d.b.d) aVar2.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOQ()) {
                charSequence = com.tencent.mm.pluginsdk.ui.span.l.b(aVar2.Pwc.getContext(), ((f) aVar2.bh(f.class)).bmF(caVar.field_bizChatUserId), aVar.userTV.getTextSize());
            } else {
                charSequence = ((com.tencent.mm.plugin.textstatus.a.c) g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).attachTextStatusSpanSync(str, com.tencent.mm.pluginsdk.ui.span.l.b(aVar2.Pwc.getContext(), ((f) aVar2.bh(f.class)).bmF(str), aVar.userTV.getTextSize()), a.b.GROUP_CHAT, aVar.userTV.getTextSize());
            }
            a(aVar, charSequence);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean gTV() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean b(com.tencent.mm.ui.chatting.e.a aVar) {
        if (gTT()) {
            return false;
        }
        if (aVar.gRM() || ((com.tencent.mm.ui.chatting.d.b.d) aVar.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOP()) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0029, code lost:
        if (r0.length() > 0) goto L_0x002b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(com.tencent.mm.ui.chatting.e.a r4, com.tencent.mm.storage.ca r5) {
        /*
            r3 = this;
            boolean r0 = r3.gTT()
            if (r0 == 0) goto L_0x000b
            java.lang.String r1 = r4.gRI()
        L_0x000a:
            return r1
        L_0x000b:
            java.lang.String r1 = r4.getTalkerUserName()
            boolean r0 = r3.b(r4)
            if (r0 == 0) goto L_0x000a
            boolean r0 = r4.gRM()
            if (r0 == 0) goto L_0x002d
            java.lang.String r0 = r5.field_content
            java.lang.String r0 = com.tencent.mm.model.bp.Ks(r0)
            if (r1 == 0) goto L_0x0032
            if (r0 == 0) goto L_0x0032
            int r2 = r0.length()
            if (r2 <= 0) goto L_0x0032
        L_0x002b:
            r1 = r0
            goto L_0x000a
        L_0x002d:
            if (r5 == 0) goto L_0x0032
            java.lang.String r0 = r5.field_bizChatUserId
            goto L_0x002b
        L_0x0032:
            r0 = r1
            goto L_0x002b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.viewitems.c.a(com.tencent.mm.ui.chatting.e.a, com.tencent.mm.storage.ca):java.lang.String");
    }

    public static String a(ca caVar, boolean z, boolean z2) {
        String str = null;
        if (caVar == null) {
            return null;
        }
        if (caVar.field_isSend == 1) {
            return z.aTY();
        }
        if (z) {
            str = bp.Ks(caVar.field_content);
        } else if (z2) {
            str = caVar.field_bizChatUserId;
        }
        if (Util.isNullOrNil(str)) {
            return caVar.field_talker;
        }
        return str;
    }

    private static int bne(String str) {
        if (ab.Eq(str)) {
            return 2;
        }
        if (ab.IT(str)) {
            return 3;
        }
        return 1;
    }

    private static int anA(int i2) {
        if (i2 == -1) {
            return 0;
        }
        return ((int) Math.ceil((double) (((float) (i2 + 1)) / 5.0f))) + 10;
    }

    private static int anB(int i2) {
        if (i2 == -1) {
            return 0;
        }
        int i3 = i2 + 1;
        return i3 > 5 ? i3 % 5 : i3;
    }

    private static int anC(int i2) {
        if (i2 == -1) {
            return 0;
        }
        switch (i2) {
            case 0:
            case 102:
            case 112:
            case 141:
                return 1;
            case 1:
                return 18;
            case 2:
            case 107:
            case 108:
            case 110:
            case 111:
            case 113:
            case TbsListener.ErrorCode.NEEDDOWNLOAD_3 /*{ENCODED_INT: 142}*/:
                return 2;
            case 3:
            case 116:
            case TbsListener.ErrorCode.NEEDDOWNLOAD_4 /*{ENCODED_INT: 143}*/:
                return 3;
            case 4:
            case 137:
                return 22;
            case 100:
                return 4;
            case 103:
                return 23;
            case 104:
                return 11;
            case 115:
                return 12;
            case 119:
                return 15;
            case 120:
                return 19;
            case 121:
                return 16;
            case 122:
                return 5;
            case 123:
                return 8;
            case 124:
                return 9;
            case 128:
                return 14;
            case 129:
                return 21;
            case 130:
                return 10;
            case com.tencent.mm.plugin.appbrand.jsapi.k.g.CTRL_INDEX:
                return 7;
            case com.tencent.mm.plugin.appbrand.jsapi.k.c.CTRL_INDEX:
                return 13;
            case r.CTRL_INDEX:
                return 6;
            case 150:
                return 20;
            case 151:
                return 17;
            default:
                return 0;
        }
    }

    public static void a(com.tencent.mm.ui.widget.b.a aVar, com.tencent.mm.ui.chatting.e.a aVar2, int i2, int i3, int i4) {
        long currentTimeMillis = System.currentTimeMillis() - aVar.startTime;
        if (currentTimeMillis > Util.MILLSECONDS_OF_MINUTE) {
            currentTimeMillis = Util.MILLSECONDS_OF_MINUTE;
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(20416, aVar2.getTalkerUserName(), Integer.valueOf(bne(aVar2.getTalkerUserName())), Long.valueOf(currentTimeMillis), Integer.valueOf(anC(i3)), Integer.valueOf(anA(i2)), Integer.valueOf(anB(i2)), 1, Integer.valueOf(i4));
        Log.i("MicroMsg.ChattingItem", "longClick menu report kvReport logID:%s, chatName:%s, chatType:%s, timeInterval:%s, itemType:%s, btnloc:%s, locSqe:%s, logVersion:%s, msgType:%s ", 20416, aVar2.getTalkerUserName(), Integer.valueOf(bne(aVar2.getTalkerUserName())), Long.valueOf(currentTimeMillis), Integer.valueOf(anC(i3)), Integer.valueOf(anA(i2)), Integer.valueOf(anB(i2)), 1, Integer.valueOf(i4));
    }

    protected static void a(a aVar, CharSequence charSequence) {
        if (aVar != null && aVar.userTV != null) {
            if (charSequence == null) {
                aVar.userTV.setVisibility(8);
                return;
            }
            aVar.userTV.setText(charSequence);
            aVar.userTV.setVisibility(0);
        }
    }

    public static class d extends t.e {
        private c chattingItem;

        public d(com.tencent.mm.ui.chatting.e.a aVar, c cVar) {
            super(aVar);
            this.chattingItem = cVar;
        }

        @Override // com.tencent.mm.ui.chatting.t.e
        public void a(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(36747);
            this.chattingItem.c(view, aVar, caVar);
            AppMethodBeat.o(36747);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(com.tencent.mm.ui.chatting.e.a aVar, ca caVar, final int i2, boolean z, final String str, boolean z2, final String str2) {
        final int i3;
        final int i4 = aVar.gRL() ? 2 : 1;
        final String talkerUserName = aVar.gRL() ? aVar.getTalkerUserName() : AppEventsConstants.EVENT_PARAM_VALUE_NO;
        final String a2 = a(aVar, caVar);
        final String sb = new StringBuilder().append(caVar.field_msgSvrId).toString();
        final String wordBankVersionForStat = ((com.tencent.mm.plugin.box.d) g.ah(com.tencent.mm.plugin.box.d.class)).getWordBankVersionForStat();
        final long searchDuration = (long) ((com.tencent.mm.plugin.box.d) g.ah(com.tencent.mm.plugin.box.d.class)).getSearchDuration();
        if (z2) {
            i3 = 65;
        } else {
            i3 = 34;
        }
        if (z) {
            com.tencent.f.h.RTc.aX(new Runnable() {
                /* class com.tencent.mm.ui.chatting.viewitems.c.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(233540);
                    ar.a(i2, str2, i3, 1, ((com.tencent.mm.plugin.box.d) g.ah(com.tencent.mm.plugin.box.d.class)).checkAllHotWords(str), wordBankVersionForStat, sb, i4, talkerUserName, searchDuration, (long) str.length());
                    AppMethodBeat.o(233540);
                }
            });
        } else {
            ar.a(i2, str2, i3, 0, "", wordBankVersionForStat, sb, i4, talkerUserName, searchDuration, (long) str.length());
        }
    }

    /* access modifiers changed from: protected */
    public final void a(com.tencent.mm.ui.widget.b.a aVar, final com.tencent.mm.ui.chatting.e.a aVar2, final String str) {
        aVar.QSA = new a.AbstractC2139a() {
            /* class com.tencent.mm.ui.chatting.viewitems.c.AnonymousClass3 */

            @Override // com.tencent.mm.ui.widget.b.a.AbstractC2139a
            public final View a(Context context, MenuItem menuItem) {
                AppMethodBeat.i(233541);
                int itemId = menuItem.getItemId();
                if (itemId == 137 || itemId == 4) {
                    View inflate = View.inflate(context, R.layout.bif, null);
                    ((TextView) inflate.findViewById(R.id.ipm)).setText(aVar2.Pwc.getMMResources().getString(R.string.b0n));
                    TextView textView = (TextView) inflate.findViewById(R.id.dq6);
                    String exposedFingerWord = ((com.tencent.mm.plugin.box.d) g.ah(com.tencent.mm.plugin.box.d.class)).getExposedFingerWord(str);
                    if (TextUtils.isEmpty(exposedFingerWord)) {
                        textView.setVisibility(8);
                    } else {
                        textView.setVisibility(0);
                        textView.setText(exposedFingerWord);
                    }
                    MMAnimateView mMAnimateView = (MMAnimateView) inflate.findViewById(R.id.dt5);
                    mMAnimateView.g(s.aW(ao.isDarkMode() ? "assets:///fireWork_dark.gif" : "assets:///fireWork_light.gif", 0, -1), "");
                    com.tencent.mm.plugin.gif.d dVar = (com.tencent.mm.plugin.gif.d) mMAnimateView.getDrawable();
                    if (dVar != null) {
                        dVar.yek = 2;
                    }
                    AppMethodBeat.o(233541);
                    return inflate;
                }
                AppMethodBeat.o(233541);
                return null;
            }
        };
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.c$c  reason: collision with other inner class name */
    public class View$OnLongClickListenerC2106c implements View.OnLongClickListener {
        a.f PGP;
        private o.e PHg;
        private a PHh;
        private View PHi;
        private int PHj = -1;
        private int PHk = -1;
        Object PHl;
        com.tencent.mm.ui.chatting.e.a PhN;
        private PopupWindow.OnDismissListener afJ = new PopupWindow.OnDismissListener() {
            /* class com.tencent.mm.ui.chatting.viewitems.c.View$OnLongClickListenerC2106c.AnonymousClass3 */

            public final void onDismiss() {
                AppMethodBeat.i(36739);
                if ((View$OnLongClickListenerC2106c.this.PHl instanceof Boolean) && ((Boolean) View$OnLongClickListenerC2106c.this.PHl).booleanValue() && a.C2075a.OLX.gKc() && View$OnLongClickListenerC2106c.this.PGP != null) {
                    View$OnLongClickListenerC2106c.this.PGP.dismiss();
                }
                c.a(View$OnLongClickListenerC2106c.this.wnj, View$OnLongClickListenerC2106c.this.PhN, View$OnLongClickListenerC2106c.this.hcg, View$OnLongClickListenerC2106c.this.PHj, View$OnLongClickListenerC2106c.this.PHk);
                View$OnLongClickListenerC2106c.this.hcg = -1;
                View$OnLongClickListenerC2106c.this.PHj = -1;
                View$OnLongClickListenerC2106c.this.PHk = -1;
                View$OnLongClickListenerC2106c.this.PhN.setFocused(true);
                AppMethodBeat.o(36739);
            }
        };
        private int hcg = -1;
        private int ppd;
        private int ppe;
        private com.tencent.mm.ui.widget.b.a wnj;

        public View$OnLongClickListenerC2106c(com.tencent.mm.ui.chatting.e.a aVar) {
            AppMethodBeat.i(36741);
            this.PhN = aVar;
            this.PHg = new o.e(c.this) {
                /* class com.tencent.mm.ui.chatting.viewitems.c.View$OnLongClickListenerC2106c.AnonymousClass1 */

                /* JADX WARNING: Removed duplicated region for block: B:115:0x0386  */
                /* JADX WARNING: Removed duplicated region for block: B:118:0x03b2  */
                @Override // com.tencent.mm.ui.base.o.e
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void a(com.tencent.mm.ui.base.m r13, android.view.View r14) {
                    /*
                    // Method dump skipped, instructions count: 1059
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.viewitems.c.View$OnLongClickListenerC2106c.AnonymousClass1.a(com.tencent.mm.ui.base.m, android.view.View):void");
                }
            };
            this.PHh = new a();
            AppMethodBeat.o(36741);
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(36742);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItem$LongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            if (view.getTag(R.id.iu_) instanceof int[]) {
                view.getTag(R.id.iu_);
                gK(view);
            } else if (!(this.ppd == 0 && this.ppe == 0) && this.PHi.equals(view)) {
                gK(view);
            } else {
                view.setOnTouchListener(new View.OnTouchListener() {
                    /* class com.tencent.mm.ui.chatting.viewitems.c.View$OnLongClickListenerC2106c.AnonymousClass2 */

                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        AppMethodBeat.i(36738);
                        View$OnLongClickListenerC2106c.this.ppd = (int) motionEvent.getRawX();
                        View$OnLongClickListenerC2106c.this.ppe = (int) motionEvent.getRawY();
                        View$OnLongClickListenerC2106c.this.PHi = view;
                        AppMethodBeat.o(36738);
                        return false;
                    }
                });
            }
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/ui/chatting/viewitems/ChattingItem$LongClickListener", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(36742);
            return true;
        }

        /* access modifiers changed from: package-private */
        public final void openContextMenu(View view) {
            AppMethodBeat.i(233546);
            gK(view);
            AppMethodBeat.o(233546);
        }

        private void gK(View view) {
            String str;
            String str2;
            String str3;
            String str4;
            AppMethodBeat.i(233547);
            bq bqVar = (bq) view.getTag();
            if (bqVar == null) {
                Log.w("MicroMsg.ChattingItem", "open menu but tag is null");
                AppMethodBeat.o(233547);
                return;
            }
            this.PHh.PHo = bqVar;
            if (this.wnj != null) {
                this.wnj.gNq();
                this.wnj = null;
            }
            this.wnj = new com.tencent.mm.ui.widget.b.a(this.PhN.Pwc.getContext());
            this.wnj.QSv = true;
            this.PHl = view.getTag(R.id.ih3);
            if ((this.PHl instanceof Boolean) && ((Boolean) this.PHl).booleanValue()) {
                if (a.C2075a.OLX.gKc()) {
                    this.wnj.QSB = true;
                    this.wnj.QSy = true;
                } else {
                    this.wnj.QSB = false;
                    this.wnj.QSy = false;
                }
                this.wnj.QSC = true;
            }
            this.wnj.QwU = this.afJ;
            if ((bqVar instanceof ChattingItemTranslate.a) && 2 == ((ChattingItemTranslate.a) bqVar).qcr && this.PGP != null) {
                this.PGP.dismiss();
            }
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            ca caVar = bqVar.dTX;
            if ((caVar.gDy() || caVar.gDq() || caVar.isText()) && ((com.tencent.mm.plugin.websearch.api.c) g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenFingerSearch()) {
                if (ab.Eq(caVar.field_talker)) {
                    str = bp.Kq(caVar.field_content);
                } else {
                    str = caVar.field_content;
                }
                if (caVar.gDq() || caVar.gDy()) {
                    k.b HD = k.b.HD(str);
                    if (HD != null) {
                        str4 = HD.title;
                    } else {
                        str4 = "";
                    }
                    str2 = str4;
                } else {
                    str2 = str;
                }
                if (Util.isNullOrNil(str2)) {
                    AppMethodBeat.o(233547);
                    return;
                }
                if (((com.tencent.mm.plugin.websearch.api.c) g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenHotWordSearch()) {
                    String checkFirstHotWord = ((com.tencent.mm.plugin.box.d) g.ah(com.tencent.mm.plugin.box.d.class)).checkFirstHotWord(str2);
                    if (!Util.isNullOrNil(checkFirstHotWord)) {
                        c.this.a(this.wnj, this.PhN, checkFirstHotWord);
                    }
                    str3 = checkFirstHotWord;
                } else {
                    str3 = "";
                }
                if (Util.isNullOrNil(str3)) {
                    this.wnj.QSA = null;
                }
                c.this.a(this.PhN, caVar, 1, !Util.isNullOrNil(str3), str2, false, "34_" + cl.aWA());
            }
            this.wnj.a(view, this.PHg, this.PHh, iArr[0] + ((int) (((float) view.getWidth()) / 2.0f)), iArr[1]);
            if (this.PhN != null) {
                this.PhN.setFocused(false);
                this.PhN.BX(false);
                this.PhN.Pwj = false;
            }
            AppMethodBeat.o(233547);
        }

        /* access modifiers changed from: package-private */
        public final void closeContextMenu() {
            AppMethodBeat.i(233548);
            if (this.wnj != null && this.wnj.gNq()) {
                this.wnj = null;
            }
            AppMethodBeat.o(233548);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.ui.chatting.viewitems.c$c$a */
        public class a implements o.g {
            public bq PHo;

            a() {
            }

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(36740);
                if (this.PHo == null) {
                    Log.e("MicroMsg.ChattingItem", "context item select failed, null dataTag");
                    AppMethodBeat.o(36740);
                    return;
                }
                if ((c.this instanceof bd.a) || (c.this instanceof bd.b)) {
                    c.this.a(menuItem, View$OnLongClickListenerC2106c.this.PhN, this.PHo);
                } else {
                    c.this.a(menuItem, View$OnLongClickListenerC2106c.this.PhN, this.PHo.dTX);
                }
                ((ae) View$OnLongClickListenerC2106c.this.PhN.bh(ae.class)).a(menuItem, c.this);
                View$OnLongClickListenerC2106c.this.PHj = menuItem.getItemId();
                View$OnLongClickListenerC2106c.this.hcg = i2;
                if (View$OnLongClickListenerC2106c.this.PGP != null) {
                    View$OnLongClickListenerC2106c.this.PGP.dismiss();
                }
                AppMethodBeat.o(36740);
            }
        }

        static /* synthetic */ void a(View$OnLongClickListenerC2106c cVar, m mVar, ca caVar, int i2, boolean z) {
            k.b aD;
            AppMethodBeat.i(233549);
            if (!as.bjp(cVar.PhN.getTalkerUserName()) && !as.HF(cVar.PhN.getTalkerUserName()) && !caVar.gAt() && (mVar instanceof m) && caVar.getType() != 318767153) {
                if (caVar.getType() == 49 && ((aD = k.b.aD(caVar.field_content, caVar.field_reserved)) == null || aD.type == 6 || aD.type == 38 || aD.type == 39)) {
                    AppMethodBeat.o(233549);
                    return;
                }
                boolean z2 = (mVar.findItem(116) == null && mVar.findItem(TbsListener.ErrorCode.NEEDDOWNLOAD_4) == null) ? false : true;
                boolean z3 = mVar.findItem(100) != null;
                LinkedList linkedList = new LinkedList();
                List<MenuItem> list = mVar.ORD;
                if ((z2 || z3) && ((caVar.getType() != 34 || z) && caVar.getType() != 3)) {
                    for (MenuItem menuItem : list) {
                        if (menuItem.getItemId() == 116) {
                            n nVar = new n(cVar.PhN.Pwc.getContext(), com.tencent.mm.plugin.appbrand.jsapi.k.g.CTRL_INDEX, i2);
                            nVar.setTitle(cVar.PhN.Pwc.getMMResources().getString(R.string.b0t));
                            nVar.setIcon(R.raw.icons_filled_bell_ring_on);
                            linkedList.add(menuItem);
                            linkedList.add(nVar);
                        } else if (!z3 || z2 || menuItem.getItemId() != 100) {
                            linkedList.add(menuItem);
                        } else {
                            n nVar2 = new n(cVar.PhN.Pwc.getContext(), com.tencent.mm.plugin.appbrand.jsapi.k.g.CTRL_INDEX, i2);
                            nVar2.setTitle(cVar.PhN.Pwc.getMMResources().getString(R.string.b0t));
                            nVar2.setIcon(R.raw.icons_filled_bell_ring_on);
                            linkedList.add(nVar2);
                            linkedList.add(menuItem);
                        }
                    }
                    list.clear();
                    list.addAll(linkedList);
                    linkedList.clear();
                } else {
                    mVar.a(i2, com.tencent.mm.plugin.appbrand.jsapi.k.g.CTRL_INDEX, cVar.PhN.Pwc.getContext().getString(R.string.b0t), R.raw.icons_filled_bell_ring_on);
                    AppMethodBeat.o(233549);
                    return;
                }
            }
            AppMethodBeat.o(233549);
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0061 A[FALL_THROUGH] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static /* synthetic */ boolean a(com.tencent.mm.ui.chatting.viewitems.c.View$OnLongClickListenerC2106c r9, com.tencent.mm.storage.ca r10) {
            /*
            // Method dump skipped, instructions count: 270
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.viewitems.c.View$OnLongClickListenerC2106c.a(com.tencent.mm.ui.chatting.viewitems.c$c, com.tencent.mm.storage.ca):boolean");
        }

        static /* synthetic */ void a(View$OnLongClickListenerC2106c cVar, m mVar, ca caVar, int i2) {
            boolean z = false;
            AppMethodBeat.i(233551);
            if (mVar instanceof m) {
                boolean z2 = (mVar.findItem(116) == null && mVar.findItem(TbsListener.ErrorCode.NEEDDOWNLOAD_4) == null) ? false : true;
                if (mVar.findItem(com.tencent.mm.plugin.appbrand.jsapi.k.g.CTRL_INDEX) != null) {
                    z = true;
                }
                LinkedList linkedList = new LinkedList();
                List<MenuItem> list = mVar.ORD;
                if (z2 || z) {
                    for (MenuItem menuItem : list) {
                        if (menuItem.getItemId() == 116 && caVar.getType() != 3) {
                            n nVar = new n(cVar.PhN.Pwc.getContext(), r.CTRL_INDEX, i2);
                            nVar.setTitle(cVar.PhN.Pwc.getMMResources().getString(R.string.b0a));
                            nVar.setIcon(R.raw.icons_filled_quote);
                            linkedList.add(menuItem);
                            linkedList.add(nVar);
                        } else if ((!z2 || caVar.getType() == 3) && menuItem.getItemId() == 134) {
                            n nVar2 = new n(cVar.PhN.Pwc.getContext(), r.CTRL_INDEX, i2);
                            nVar2.setTitle(cVar.PhN.Pwc.getMMResources().getString(R.string.b0a));
                            nVar2.setIcon(R.raw.icons_filled_quote);
                            linkedList.add(nVar2);
                            linkedList.add(menuItem);
                        } else {
                            linkedList.add(menuItem);
                        }
                    }
                    list.clear();
                    list.addAll(linkedList);
                    linkedList.clear();
                } else {
                    mVar.a(i2, r.CTRL_INDEX, cVar.PhN.Pwc.getContext().getString(R.string.b0a), R.raw.icons_filled_quote);
                    AppMethodBeat.o(233551);
                    return;
                }
            }
            AppMethodBeat.o(233551);
        }

        static /* synthetic */ void a(View$OnLongClickListenerC2106c cVar, m mVar, int i2) {
            AppMethodBeat.i(233552);
            if (mVar instanceof m) {
                LinkedList linkedList = new LinkedList();
                List<MenuItem> list = mVar.ORD;
                if (list.size() <= 3) {
                    mVar.a(i2, 100, cVar.PhN.Pwc.getContext().getString(R.string.b06), R.raw.icons_filled_delete);
                    AppMethodBeat.o(233552);
                    return;
                }
                int i3 = 0;
                for (MenuItem menuItem : list) {
                    if (i3 == 3) {
                        n nVar = new n(cVar.PhN.Pwc.getContext(), 100, i2);
                        nVar.setTitle(cVar.PhN.Pwc.getMMResources().getString(R.string.b06));
                        nVar.setIcon(R.raw.icons_filled_delete);
                        linkedList.add(nVar);
                        linkedList.add(menuItem);
                    } else {
                        linkedList.add(menuItem);
                    }
                    i3++;
                }
                list.clear();
                list.addAll(linkedList);
                linkedList.clear();
            }
            AppMethodBeat.o(233552);
        }

        static /* synthetic */ void b(View$OnLongClickListenerC2106c cVar, m mVar, int i2) {
            AppMethodBeat.i(233553);
            if (mVar instanceof m) {
                LinkedList linkedList = new LinkedList();
                List<MenuItem> list = mVar.ORD;
                if (list.size() <= 3) {
                    mVar.a(i2, 123, cVar.PhN.Pwc.getContext().getString(R.string.b0i), R.raw.icons_filled_previous);
                    AppMethodBeat.o(233553);
                    return;
                }
                int i3 = 0;
                for (MenuItem menuItem : list) {
                    if (i3 == 3) {
                        n nVar = new n(cVar.PhN.Pwc.getContext(), 123, i2);
                        nVar.setTitle(cVar.PhN.Pwc.getMMResources().getString(R.string.b0i));
                        nVar.setIcon(R.raw.icons_filled_previous);
                        linkedList.add(nVar);
                        linkedList.add(menuItem);
                    } else {
                        linkedList.add(menuItem);
                    }
                    i3++;
                }
                list.clear();
                list.addAll(linkedList);
                linkedList.clear();
            }
            AppMethodBeat.o(233553);
        }

        static /* synthetic */ void c(View$OnLongClickListenerC2106c cVar, m mVar, int i2) {
            AppMethodBeat.i(233554);
            if (mVar instanceof m) {
                LinkedList linkedList = new LinkedList();
                List<MenuItem> list = mVar.ORD;
                if (list.size() <= 4) {
                    mVar.a(i2, 122, cVar.PhN.Pwc.getContext().getString(R.string.b0_), R.raw.icons_filled_multiple_choice);
                    AppMethodBeat.o(233554);
                    return;
                }
                int i3 = 0;
                for (MenuItem menuItem : list) {
                    if (i3 == 4) {
                        n nVar = new n(cVar.PhN.Pwc.getContext(), 122, i2);
                        nVar.setTitle(cVar.PhN.Pwc.getMMResources().getString(R.string.b0_));
                        nVar.setIcon(R.raw.icons_filled_multiple_choice);
                        linkedList.add(nVar);
                        linkedList.add(menuItem);
                    } else {
                        linkedList.add(menuItem);
                    }
                    i3++;
                }
                list.clear();
                list.addAll(linkedList);
                linkedList.clear();
            }
            AppMethodBeat.o(233554);
        }
    }

    /* access modifiers changed from: protected */
    public final View$OnLongClickListenerC2106c c(com.tencent.mm.ui.chatting.e.a aVar) {
        if (this.PGO == null) {
            this.PGO = new View$OnLongClickListenerC2106c(aVar);
        }
        return this.PGO;
    }

    /* access modifiers changed from: protected */
    public final a.f a(View$OnLongClickListenerC2106c cVar) {
        if (this.PGP == null) {
            this.PGP = new e(cVar);
        }
        return this.PGP;
    }

    static class e extends a.f {
        View$OnLongClickListenerC2106c PGO;

        e(View$OnLongClickListenerC2106c cVar) {
            this.PGO = cVar;
        }

        @Override // com.tencent.mm.ui.widget.textview.a.f
        public final void gL(View view) {
            AppMethodBeat.i(36748);
            this.PGO.openContextMenu(view);
            AppMethodBeat.o(36748);
        }

        @Override // com.tencent.mm.ui.widget.textview.a.f
        public final void dismiss() {
            AppMethodBeat.i(36749);
            this.PGO.closeContextMenu();
            AppMethodBeat.o(36749);
        }

        @Override // com.tencent.mm.ui.widget.textview.a.f
        public final void ea(View view) {
            AppMethodBeat.i(36750);
            this.PGO.onLongClick(view);
            AppMethodBeat.o(36750);
        }

        @Override // com.tencent.mm.ui.widget.textview.a.f
        public final void gTY() {
            AppMethodBeat.i(179940);
            View$OnLongClickListenerC2106c cVar = this.PGO;
            if (cVar.PhN != null) {
                cVar.PhN.BX(true);
            }
            AppMethodBeat.o(179940);
        }

        @Override // com.tencent.mm.ui.widget.textview.a.f
        public final void gTZ() {
            AppMethodBeat.i(179941);
            View$OnLongClickListenerC2106c cVar = this.PGO;
            if (cVar.PhN != null) {
                cVar.PhN.BX(false);
            }
            AppMethodBeat.o(179941);
        }

        @Override // com.tencent.mm.ui.widget.textview.a.f
        public final void gUa() {
            AppMethodBeat.i(179942);
            View$OnLongClickListenerC2106c cVar = this.PGO;
            if (cVar.PhN != null) {
                cVar.PhN.setFocused(false);
            }
            AppMethodBeat.o(179942);
        }
    }

    /* access modifiers changed from: protected */
    public final d d(com.tencent.mm.ui.chatting.e.a aVar) {
        if (this.PGQ == null) {
            if (aVar.Pwc instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI) {
                AppBrandServiceChattingUI.AppBrandServiceChattingFmUI appBrandServiceChattingFmUI = (AppBrandServiceChattingUI.AppBrandServiceChattingFmUI) aVar.Pwc;
                this.PGQ = 
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0015: IPUT  
                      (wrap: com.tencent.mm.ui.chatting.AppBrandServiceChattingUI$AppBrandServiceChattingFmUI$3 : 0x0012: CONSTRUCTOR  (r1v0 com.tencent.mm.ui.chatting.AppBrandServiceChattingUI$AppBrandServiceChattingFmUI$3) = 
                      (r0v6 'appBrandServiceChattingFmUI' com.tencent.mm.ui.chatting.AppBrandServiceChattingUI$AppBrandServiceChattingFmUI)
                      (wrap: com.tencent.mm.ui.chatting.e.a : 0x0010: IGET  (r2v0 com.tencent.mm.ui.chatting.e.a) = (r0v6 'appBrandServiceChattingFmUI' com.tencent.mm.ui.chatting.AppBrandServiceChattingUI$AppBrandServiceChattingFmUI) com.tencent.mm.ui.chatting.BaseChattingUIFragment.dom com.tencent.mm.ui.chatting.e.a)
                      (r3v0 'this' com.tencent.mm.ui.chatting.viewitems.c A[IMMUTABLE_TYPE, THIS])
                     call: com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.3.<init>(com.tencent.mm.ui.chatting.AppBrandServiceChattingUI$AppBrandServiceChattingFmUI, com.tencent.mm.ui.chatting.e.a, com.tencent.mm.ui.chatting.viewitems.c):void type: CONSTRUCTOR)
                      (r3v0 'this' com.tencent.mm.ui.chatting.viewitems.c A[IMMUTABLE_TYPE, THIS])
                     com.tencent.mm.ui.chatting.viewitems.c.PGQ com.tencent.mm.ui.chatting.viewitems.c$d in method: com.tencent.mm.ui.chatting.viewitems.c.d(com.tencent.mm.ui.chatting.e.a):com.tencent.mm.ui.chatting.viewitems.c$d, file: classes5.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: CONSTRUCTOR  (r1v0 com.tencent.mm.ui.chatting.AppBrandServiceChattingUI$AppBrandServiceChattingFmUI$3) = 
                      (r0v6 'appBrandServiceChattingFmUI' com.tencent.mm.ui.chatting.AppBrandServiceChattingUI$AppBrandServiceChattingFmUI)
                      (wrap: com.tencent.mm.ui.chatting.e.a : 0x0010: IGET  (r2v0 com.tencent.mm.ui.chatting.e.a) = (r0v6 'appBrandServiceChattingFmUI' com.tencent.mm.ui.chatting.AppBrandServiceChattingUI$AppBrandServiceChattingFmUI) com.tencent.mm.ui.chatting.BaseChattingUIFragment.dom com.tencent.mm.ui.chatting.e.a)
                      (r3v0 'this' com.tencent.mm.ui.chatting.viewitems.c A[IMMUTABLE_TYPE, THIS])
                     call: com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI.3.<init>(com.tencent.mm.ui.chatting.AppBrandServiceChattingUI$AppBrandServiceChattingFmUI, com.tencent.mm.ui.chatting.e.a, com.tencent.mm.ui.chatting.viewitems.c):void type: CONSTRUCTOR in method: com.tencent.mm.ui.chatting.viewitems.c.d(com.tencent.mm.ui.chatting.e.a):com.tencent.mm.ui.chatting.viewitems.c$d, file: classes5.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:428)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                    	... 24 more
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.ui.chatting.AppBrandServiceChattingUI, state: GENERATED_AND_UNLOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                    	... 28 more
                    */
                /*
                    this = this;
                    com.tencent.mm.ui.chatting.viewitems.c$d r0 = r3.PGQ
                    if (r0 != 0) goto L_0x0017
                    com.tencent.mm.ui.chatting.BaseChattingUIFragment r0 = r4.Pwc
                    boolean r0 = r0 instanceof com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI
                    if (r0 == 0) goto L_0x001a
                    com.tencent.mm.ui.chatting.BaseChattingUIFragment r0 = r4.Pwc
                    com.tencent.mm.ui.chatting.AppBrandServiceChattingUI$AppBrandServiceChattingFmUI r0 = (com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI) r0
                    com.tencent.mm.ui.chatting.AppBrandServiceChattingUI$AppBrandServiceChattingFmUI$3 r1 = new com.tencent.mm.ui.chatting.AppBrandServiceChattingUI$AppBrandServiceChattingFmUI$3
                    com.tencent.mm.ui.chatting.e.a r2 = r0.dom
                    r1.<init>(r2, r3)
                    r3.PGQ = r1
                L_0x0017:
                    com.tencent.mm.ui.chatting.viewitems.c$d r0 = r3.PGQ
                    return r0
                L_0x001a:
                    com.tencent.mm.ui.chatting.viewitems.c$d r0 = new com.tencent.mm.ui.chatting.viewitems.c$d
                    r0.<init>(r4, r3)
                    r3.PGQ = r0
                    goto L_0x0017
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.viewitems.c.d(com.tencent.mm.ui.chatting.e.a):com.tencent.mm.ui.chatting.viewitems.c$d");
            }

            private void a(a aVar, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar) {
                if (!this.PGR) {
                    this.PGR = true;
                    if (!(aVar2.Pwc instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI) && !ab.IN(aVar2.getTalkerUserName())) {
                        if (caVar == null || Util.isNullOrNil(caVar.fQZ)) {
                            this.PGS = new t.b(aVar2);
                            this.PGT = new t.d(aVar2);
                        } else {
                            this.PGS = new t.a(aVar2);
                        }
                        aVar.avatarIV.setOnClickListener(this.PGS);
                        aVar.avatarIV.setOnLongClickListener(this.PGT);
                    }
                }
            }

            /* access modifiers changed from: protected */
            public final t.b e(com.tencent.mm.ui.chatting.e.a aVar) {
                if (this.PGS == null) {
                    this.PGS = new t.b(aVar);
                }
                return this.PGS;
            }

            /* access modifiers changed from: protected */
            public final t.d f(com.tencent.mm.ui.chatting.e.a aVar) {
                if (this.PGT == null) {
                    this.PGT = new t.d(aVar);
                }
                return this.PGT;
            }

            private t.c g(com.tencent.mm.ui.chatting.e.a aVar) {
                if (this.PGU == null) {
                    this.PGU = new t.c(aVar);
                }
                return this.PGU;
            }

            /* access modifiers changed from: protected */
            public final t.p h(com.tencent.mm.ui.chatting.e.a aVar) {
                if (this.PGV == null) {
                    this.PGV = new t.p(aVar);
                }
                return this.PGV;
            }

            /* access modifiers changed from: protected */
            public final t.k i(com.tencent.mm.ui.chatting.e.a aVar) {
                if (this.PGX == null) {
                    this.PGX = new t.k(aVar);
                }
                return this.PGX;
            }

            /* access modifiers changed from: protected */
            public final t.e a(com.tencent.mm.ui.chatting.e.a aVar, final t.n nVar) {
                if (this.PGY == null) {
                    this.PGY = new t.e(aVar) {
                        /* class com.tencent.mm.ui.chatting.viewitems.c.AnonymousClass4 */

                        @Override // com.tencent.mm.ui.chatting.t.e
                        public final void a(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
                            AppMethodBeat.i(233542);
                            nVar.b(view, aVar, caVar);
                            AppMethodBeat.o(233542);
                        }
                    };
                }
                return this.PGY;
            }

            /* access modifiers changed from: protected */
            public final void a(a aVar, com.tencent.mm.ui.chatting.e.a aVar2, String str, ca caVar) {
                String str2;
                bq bqVar;
                int i2;
                String str3;
                if (aVar.avatarIV != null) {
                    if (!ab.JE(str) || str.equals(ab.iCO[0])) {
                        if (caVar != null && !Util.isNullOrNil(caVar.fQZ)) {
                            com.tencent.mm.aj.b bVar = new com.tencent.mm.aj.b();
                            bVar.iJY = false;
                            bVar.iJZ = com.tencent.mm.pluginsdk.ui.a.ppN;
                            if (aVar2.gRM()) {
                                str3 = aVar2.getTalkerUserName();
                            } else {
                                str3 = null;
                            }
                            bq bqVar2 = new bq(str, str3);
                            bqVar2.PQF = caVar.fQZ;
                            bqVar2.iEt = caVar.fRf;
                            a.b.a(aVar.avatarIV, caVar.fQZ, bVar);
                            if (h.R(caVar)) {
                                ag.bai().aZS();
                            }
                            bqVar = bqVar2;
                        } else if (caVar != null && ((com.tencent.mm.ui.chatting.d.b.d) aVar2.bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOP()) {
                            bq bqVar3 = new bq(caVar.field_bizChatUserId, (String) null);
                            q.bcV().a(((com.tencent.mm.ui.chatting.d.b.d) aVar2.bh(com.tencent.mm.ui.chatting.d.b.d.class)).NI(caVar.field_bizChatUserId), aVar.avatarIV, ((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOH());
                            bqVar = bqVar3;
                        } else if (caVar == null || caVar.field_isSend != 0 || aVar2.bh(com.tencent.mm.ui.chatting.d.b.a.class) == null || Util.isNullOrNil(((com.tencent.mm.ui.chatting.d.b.a) aVar2.bh(com.tencent.mm.ui.chatting.d.b.a.class)).gRH())) {
                            if (aVar2.gRM()) {
                                str2 = aVar2.getTalkerUserName();
                            } else {
                                str2 = null;
                            }
                            bq bqVar4 = new bq(str, str2);
                            D(aVar.avatarIV, str);
                            bqVar = bqVar4;
                        } else {
                            bq bqVar5 = new bq(str, (String) null);
                            q.bcV().a(((com.tencent.mm.ui.chatting.d.b.a) aVar2.bh(com.tencent.mm.ui.chatting.d.b.a.class)).gRH(), aVar.avatarIV, ((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOH());
                            bqVar = bqVar5;
                        }
                        aVar.avatarIV.setVisibility(0);
                        aVar.avatarIV.setTag(bqVar);
                        aVar.avatarIV.setTagUsername(str);
                        aVar.avatarIV.setTagTalker(aVar2.getTalkerUserName());
                        if (ab.Ix(aVar2.getTalkerUserName())) {
                            aVar.avatarIV.setTagScene(2);
                        } else {
                            aVar.avatarIV.setTagScene(1);
                        }
                        a(aVar, aVar2, caVar);
                        aVar.avatarIV.setOnDoubleClickListener(g(aVar2));
                        com.tencent.mm.ui.chatting.r.dQ(aVar.avatarIV);
                        aVar.avatarIV.setContentDescription(aa.getDisplayName(str) + aVar2.Pwc.getContext().getString(R.string.a4u));
                        if (aVar.sendFromWatchVS == null) {
                            return;
                        }
                        if (caVar == null || caVar.fqK == null || !caVar.fqK.contains("watch_msg_source_type")) {
                            aVar.sendFromWatchVS.setVisibility(8);
                            return;
                        }
                        try {
                            i2 = Integer.valueOf(XmlParser.parseXml(caVar.fqK, "msgsource", null).get(".msgsource.watch_msg_source_type")).intValue();
                        } catch (Exception e2) {
                            i2 = 0;
                        }
                        if (i2 <= 0 || i2 > 4) {
                            aVar.sendFromWatchVS.setVisibility(8);
                        } else {
                            aVar.sendFromWatchVS.setVisibility(0);
                        }
                    } else {
                        aVar.avatarIV.setVisibility(8);
                    }
                }
            }

            protected static void a(a aVar, boolean z) {
                c cVar = aVar.chattingItem;
                if (cVar != null) {
                    cVar.a(aVar, z, false);
                } else if (aVar.uploadingPB == null) {
                } else {
                    if (z) {
                        aVar.uploadingPB.setVisibility(0);
                    } else {
                        aVar.uploadingPB.setVisibility(8);
                    }
                }
            }

            /* access modifiers changed from: protected */
            public final void b(a aVar, boolean z) {
                a(aVar, z, true);
            }

            /* access modifiers changed from: protected */
            public final void a(final a aVar, boolean z, boolean z2) {
                if (aVar.uploadingPB != null) {
                    Log.d("MicroMsg.ChattingItem", "showUploadingPB %s %s %s", aVar, Boolean.valueOf(z), Boolean.valueOf(z2));
                    if (!z) {
                        aVar.uploadingPB.setTag(R.id.axa, Boolean.FALSE);
                        if (this.PGZ != null) {
                            this.PGZ.cancel(true);
                        }
                        aVar.uploadingPB.setVisibility(8);
                    } else if (!z2) {
                        aVar.uploadingPB.setVisibility(0);
                        aVar.uploadingPB.setTag(R.id.axa, Boolean.TRUE);
                    } else {
                        Object tag = aVar.uploadingPB.getTag(R.id.ax_);
                        if (tag == null || ((Long) tag).longValue() >= cl.aWz() - 1000) {
                            Object tag2 = aVar.uploadingPB.getTag(R.id.axa);
                            if (tag2 == null || !((Boolean) tag2).booleanValue()) {
                                this.PGZ = com.tencent.f.h.RTc.n(new Runnable() {
                                    /* class com.tencent.mm.ui.chatting.viewitems.c.AnonymousClass5 */

                                    public final void run() {
                                        AppMethodBeat.i(233543);
                                        aVar.uploadingPB.setVisibility(0);
                                        aVar.uploadingPB.setTag(R.id.axa, Boolean.TRUE);
                                        Log.d("MicroMsg.ChattingItem", "showUploadingPB delay visible %s", aVar);
                                        AppMethodBeat.o(233543);
                                    }
                                }, 1000);
                                return;
                            }
                            aVar.uploadingPB.setVisibility(0);
                            Log.d("MicroMsg.ChattingItem", "showUploadingPB had delay visible %s", aVar);
                            return;
                        }
                        aVar.uploadingPB.setVisibility(0);
                        aVar.uploadingPB.setTag(R.id.axa, Boolean.TRUE);
                        Log.d("MicroMsg.ChattingItem", "showUploadingPB not init %s", aVar);
                    }
                }
            }

            public static class a {
                public static final int STATUS_EDIT = 1;
                public static final int STATUS_NORMAL = 0;
                public ChattingAvatarImageView avatarIV;
                public c chattingItem;
                public CheckBox checkBox;
                public View clickArea;
                public ImageView colorMaskView;
                public View convertView;
                public View historyMsgTip;
                public View maskView;
                public View noMoreMsgTip;
                public String playingMsgId;
                public ViewStub sendFromWatchVS;
                public ImageView stateIV;
                public TextView timeTV;
                public ProgressBar uploadingPB;
                public TextView userTV;

                public a() {
                }

                public a(c cVar, String str) {
                    this.chattingItem = cVar;
                    this.playingMsgId = str;
                }

                public void setChattingItem(c cVar) {
                    this.chattingItem = cVar;
                }

                public void create(View view) {
                    AppMethodBeat.i(36732);
                    this.convertView = view;
                    this.timeTV = (TextView) view.findViewById(R.id.ayf);
                    this.avatarIV = (ChattingAvatarImageView) view.findViewById(R.id.au2);
                    this.historyMsgTip = view.findViewById(R.id.avm);
                    this.noMoreMsgTip = view.findViewById(R.id.axn);
                    this.checkBox = (CheckBox) view.findViewById(R.id.aue);
                    this.clickArea = view.findViewById(R.id.auf);
                    this.stateIV = (ImageView) view.findViewById(R.id.ayb);
                    this.colorMaskView = (ImageView) view.findViewById(R.id.aug);
                    this.sendFromWatchVS = null;
                    AppMethodBeat.o(36732);
                }

                public void showEditView(boolean z) {
                    AppMethodBeat.i(36733);
                    int i2 = z ? 0 : 8;
                    if (!(this.checkBox == null || this.checkBox.getVisibility() == i2)) {
                        this.checkBox.setVisibility(i2);
                    }
                    if (!(this.maskView == null || this.maskView.getVisibility() == i2)) {
                        this.maskView.setVisibility(i2);
                    }
                    AppMethodBeat.o(36733);
                }

                public void showColorMaskView(boolean z) {
                    AppMethodBeat.i(233544);
                    if (this.colorMaskView != null) {
                        if (z) {
                            this.colorMaskView.setVisibility(0);
                            AppMethodBeat.o(233544);
                            return;
                        }
                        this.colorMaskView.setVisibility(8);
                    }
                    AppMethodBeat.o(233544);
                }

                public void resetChatBubbleWidth(View view, int i2) {
                    AppMethodBeat.i(36734);
                    if (view != null) {
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        layoutParams.width = (int) (((float) i2) / com.tencent.mm.cc.a.gvi());
                        view.setLayoutParams(layoutParams);
                        view.requestLayout();
                    }
                    AppMethodBeat.o(36734);
                }

                public View getMainContainerView() {
                    return this.clickArea;
                }
            }

            protected static void a(com.tencent.mm.ui.chatting.e.a aVar, View view, String str) {
                if (!com.tencent.mm.pluginsdk.model.app.h.bdz(str)) {
                    view.setTag(new l.b());
                    return;
                }
                l.b bVar = new l.b();
                bVar.appId = str;
                bVar.from = "message";
                a(aVar, view, bVar);
            }

            protected static void a(com.tencent.mm.ui.chatting.e.a aVar, View view, ca caVar, k.b bVar, String str, long j2) {
                if (!com.tencent.mm.pluginsdk.model.app.h.bdz(bVar.appId)) {
                    view.setTag(new l.b());
                    return;
                }
                int i2 = aVar.gRM() ? 2 : 1;
                l.a aVar2 = new l.a();
                aVar2.appId = bVar.appId;
                aVar2.from = "message";
                aVar2.pkgName = str;
                aVar2.dYs = d(aVar, caVar);
                aVar2.Kno = bVar.type;
                aVar2.scene = i2;
                aVar2.Knp = bVar.mediaTagName;
                aVar2.dTS = j2;
                aVar2.Knq = aVar.getTalkerUserName();
                a(aVar, view, aVar2);
            }

            private static void a(com.tencent.mm.ui.chatting.e.a aVar, View view, Object obj) {
                view.setTag(obj);
                view.setOnClickListener(((com.tencent.mm.ui.chatting.d.b.k) aVar.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOE());
            }

            protected static void a(com.tencent.mm.ui.chatting.e.a aVar, ImageView imageView, String str) {
                if (Util.isEqual("wx485a97c844086dc9", str) && (imageView instanceof WeImageView)) {
                    imageView.setImageResource(R.raw.icons_filled_music);
                    ((WeImageView) imageView).setIconColor(aVar.Pwc.getContext().getResources().getColor(R.color.FG_1));
                } else if (!Util.isEqual("wxaf060266bfa9a35c", str) || !(imageView instanceof WeImageView)) {
                    if (imageView instanceof WeImageView) {
                        ((WeImageView) imageView).setIconColor(aVar.Pwc.getContext().getResources().getColor(R.color.ac_));
                    }
                    Bitmap c2 = com.tencent.mm.pluginsdk.model.app.h.c(str, 2, com.tencent.mm.cb.a.getDensity(aVar.Pwc.getContext()));
                    if (c2 == null || c2.isRecycled()) {
                        a(aVar, imageView, BitmapFactory.decodeResource(aVar.Pwc.getMMResources(), R.drawable.bjq));
                    } else {
                        a(aVar, imageView, c2);
                    }
                } else {
                    imageView.setImageResource(R.raw.icons_outlined_tv);
                    ((WeImageView) imageView).setIconColor(aVar.Pwc.getContext().getResources().getColor(R.color.FG_1));
                }
            }

            private static void a(com.tencent.mm.ui.chatting.e.a aVar, ImageView imageView, Bitmap bitmap) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                int dimension = (int) aVar.Pwc.getMMResources().getDimension(R.dimen.kc);
                bitmapDrawable.setBounds(0, 0, dimension, dimension);
                imageView.setImageDrawable(bitmapDrawable);
            }

            protected static void a(com.tencent.mm.ui.chatting.e.a aVar, TextView textView, String str) {
                Bitmap c2 = com.tencent.mm.pluginsdk.model.app.h.c(str, 2, com.tencent.mm.cb.a.getDensity(aVar.Pwc.getContext()));
                if (c2 == null || c2.isRecycled()) {
                    a(aVar, textView, BitmapFactory.decodeResource(aVar.Pwc.getMMResources(), R.drawable.bjq));
                } else {
                    a(aVar, textView, c2);
                }
            }

            private static void a(com.tencent.mm.ui.chatting.e.a aVar, TextView textView, Bitmap bitmap) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap);
                int dimension = (int) aVar.Pwc.getMMResources().getDimension(R.dimen.kc);
                bitmapDrawable.setBounds(0, 0, dimension, dimension);
                textView.setCompoundDrawables(bitmapDrawable, null, null, null);
            }

            /* access modifiers changed from: protected */
            public final void b(com.tencent.mm.ui.chatting.e.a aVar, View view, Object obj) {
                view.setTag(obj);
                if (this.PGW == null) {
                    this.PGW = new t.h(aVar);
                }
                view.setOnClickListener(this.PGW);
            }

            protected static void c(com.tencent.mm.ui.chatting.e.a aVar, View view, Object obj) {
                view.setTag(obj);
                view.setOnClickListener(((com.tencent.mm.ui.chatting.d.b.k) aVar.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOF());
            }

            public final boolean a(com.tencent.mm.ui.chatting.e.a aVar, k.b bVar, ca caVar) {
                int i2;
                if (Util.isNullOrNil(bVar.iyZ)) {
                    return false;
                }
                com.tencent.mm.ui.chatting.a.a(a.EnumC2087a.EnterCompleteVideo, caVar, bVar.izg, bVar.izf);
                String str = caVar.field_imgPath;
                Intent intent = new Intent();
                intent.putExtra("KFromTimeLine", false);
                intent.putExtra("KStremVideoUrl", bVar.iyZ);
                intent.putExtra("KThumUrl", bVar.ize);
                intent.putExtra("KThumbPath", str);
                intent.putExtra("KSta_StremVideoAduxInfo", bVar.izf);
                intent.putExtra("KSta_StremVideoPublishId", bVar.izg);
                intent.putExtra("KSta_SourceType", 2);
                if (aVar.gRM()) {
                    i2 = a.b.TalkChat.value;
                } else {
                    i2 = a.b.Chat.value;
                }
                intent.putExtra("KSta_Scene", i2);
                intent.putExtra("KSta_FromUserName", a(aVar, caVar));
                intent.putExtra("KSta_ChatName", aVar.getTalkerUserName());
                intent.putExtra("KSta_MsgId", caVar.field_msgSvrId);
                intent.putExtra("KSta_SnsStatExtStr", bVar.ean);
                if (aVar.gRM()) {
                    intent.putExtra("KSta_ChatroomMembercount", v.Ie(aVar.getTalkerUserName()));
                }
                intent.putExtra("KMediaId", "fakeid_" + caVar.field_msgId);
                intent.putExtra("KMediaVideoTime", bVar.iza);
                intent.putExtra("StremWebUrl", bVar.izd);
                intent.putExtra("StreamWording", bVar.izc);
                intent.putExtra("KMediaTitle", bVar.title);
                if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_ad_landing_page_new_stream_video, 0) > 0) {
                    com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "sns", ".ui.SnsAdStreamVideoPlayUI", intent);
                    Log.i("MicroMsg.ChattingItem", "use new stream video play UI");
                } else {
                    com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "sns", ".ui.VideoAdPlayerUI", intent);
                }
                return true;
            }

            /* access modifiers changed from: protected */
            public final void a(com.tencent.mm.ui.chatting.e.a aVar, String str, String str2, String str3, int i2, String str4, boolean z, long j2, long j3, ca caVar) {
                if ((str == null || str.length() == 0) && (str2 == null || str2.length() == 0)) {
                    Log.e("MicroMsg.ChattingItem", "url, lowUrl both are empty");
                    return;
                }
                if (!NetStatusUtil.isMobile(aVar.Pwc.getContext()) ? str == null || str.length() <= 0 : str2 != null && str2.length() > 0) {
                    str = str2;
                }
                Intent intent = new Intent();
                intent.putExtra("msg_id", j2);
                intent.putExtra("rawUrl", str);
                intent.putExtra("version_name", str3);
                intent.putExtra("version_code", i2);
                intent.putExtra("usePlugin", z);
                intent.putExtra("geta8key_username", aVar.getTalkerUserName());
                intent.putExtra("KPublisherId", "msg_" + Long.toString(j3));
                intent.putExtra("KAppId", str4);
                intent.putExtra("pre_username", a(aVar, caVar));
                intent.putExtra("prePublishId", "msg_" + Long.toString(j3));
                if (caVar != null) {
                    intent.putExtra("preUsername", a(aVar, caVar));
                }
                intent.putExtra("preChatName", aVar.getTalkerUserName());
                intent.putExtra("preChatTYPE", ac.aJ(a(aVar, caVar), aVar.getTalkerUserName()));
                intent.putExtra("preMsgIndex", 0);
                com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            }

            protected static boolean gp(String str) {
                return com.tencent.mm.pluginsdk.model.app.h.gp(str);
            }

            protected static PackageInfo getPackageInfo(Context context, String str) {
                String str2;
                if (str == null || str.length() == 0) {
                    str2 = null;
                } else {
                    com.tencent.mm.pluginsdk.model.app.g o = com.tencent.mm.pluginsdk.model.app.h.o(str, true, false);
                    str2 = o == null ? null : o.field_packageName;
                }
                if (str2 == null) {
                    return null;
                }
                try {
                    return context.getPackageManager().getPackageInfo(str2, 0);
                } catch (PackageManager.NameNotFoundException e2) {
                    Log.printErrStackTrace("MicroMsg.ChattingItem", e2, "", new Object[0]);
                    return null;
                }
            }

            /* access modifiers changed from: protected */
            public final void a(int i2, a aVar, ca caVar, String str, boolean z, com.tencent.mm.ui.chatting.e.a aVar2, t.n nVar) {
                a(i2, aVar, caVar, str, true, z, aVar2, nVar);
            }

            /* access modifiers changed from: protected */
            public final void a(int i2, a aVar, ca caVar, String str, boolean z, boolean z2, com.tencent.mm.ui.chatting.e.a aVar2, t.n nVar) {
                if (caVar.field_isSend == 1) {
                    aVar.stateIV.setTag(new bq(caVar, z2, i2, str, (char) 0));
                    aVar.stateIV.setOnClickListener(a(aVar2, nVar));
                    int anD = anD(caVar.field_status);
                    if (anD != -1) {
                        aVar.stateIV.setImageResource(anD);
                        aVar.stateIV.setVisibility(0);
                        aVar.stateIV.setContentDescription(MMApplicationContext.getContext().getString(R.string.f46));
                        a(aVar, false, z);
                        return;
                    }
                    aVar.stateIV.setVisibility(8);
                }
            }

            private static int anD(int i2) {
                switch (i2) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        return -1;
                    case 5:
                        return R.drawable.awi;
                    default:
                        Log.e("MicroMsg.ChattingItem", "getMsgStateResId: not found this state");
                        return -1;
                }
            }

            public static void c(com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
                if (aVar != null && caVar != null) {
                    com.tencent.mm.al.l.c(caVar, ((com.tencent.mm.ui.chatting.d.b.d) aVar.bh(com.tencent.mm.ui.chatting.d.b.d.class)).ahy());
                }
            }

            public static void a(com.tencent.mm.ui.chatting.e.a aVar, k.b bVar, String str, com.tencent.mm.pluginsdk.model.app.g gVar, long j2, int i2, String str2) {
                int i3 = aVar.gRM() ? 2 : 1;
                if (i2 == -1) {
                    if (bVar.type != 7) {
                        i2 = 3;
                    } else if (gVar == null || !com.tencent.mm.pluginsdk.model.app.q.s(aVar.Pwc.getContext(), gVar.field_packageName)) {
                        i2 = 6;
                    } else {
                        i2 = 0;
                    }
                }
                if (bVar.type == 2) {
                    i2 = 4;
                } else if (bVar.type == 5) {
                    i2 = 1;
                }
                ry ryVar = new ry();
                ryVar.dYw.context = aVar.Pwc.getContext();
                ryVar.dYw.scene = i3;
                ryVar.dYw.dNI = bVar.appId;
                ryVar.dYw.packageName = gVar == null ? null : gVar.field_packageName;
                ryVar.dYw.msgType = bVar.type;
                ryVar.dYw.dRL = str;
                ryVar.dYw.dYx = i2;
                ryVar.dYw.mediaTagName = bVar.mediaTagName;
                ryVar.dYw.dTS = j2;
                ryVar.dYw.dYy = "";
                ryVar.dYw.dCw = str2;
                com.tencent.mm.pluginsdk.ui.tools.c cVar = (com.tencent.mm.pluginsdk.ui.tools.c) bVar.as(com.tencent.mm.pluginsdk.ui.tools.c.class);
                if (cVar != null) {
                    ryVar.dYw.dYz = cVar.dYz;
                }
                EventCenter.instance.publish(ryVar);
            }

            public static void a(com.tencent.mm.ui.chatting.e.a aVar, k.b bVar, String str, com.tencent.mm.pluginsdk.model.app.g gVar, long j2, String str2) {
                a(aVar, bVar, str, gVar, j2, -1, str2);
            }

            protected static void b(com.tencent.mm.ui.chatting.e.a aVar, k.b bVar, ca caVar) {
                com.tencent.mm.plugin.game.api.b dSQ = b.a.dSQ();
                if (dSQ != null) {
                    int i2 = aVar.gRM() ? 2 : 1;
                    String d2 = d(aVar, caVar);
                    int i3 = 0;
                    com.tencent.mm.pluginsdk.ui.tools.c cVar = (com.tencent.mm.pluginsdk.ui.tools.c) bVar.as(com.tencent.mm.pluginsdk.ui.tools.c.class);
                    if (cVar != null) {
                        i3 = cVar.dYz;
                    }
                    aVar.Pwc.getContext();
                    dSQ.a(bVar.appId, d2, bVar.type, i2, bVar.mediaTagName, caVar.field_msgSvrId, aVar.getTalkerUserName(), i3);
                }
            }

            protected static boolean a(com.tencent.mm.ui.chatting.e.a aVar, com.tencent.mm.pluginsdk.model.app.g gVar) {
                com.tencent.mm.plugin.game.api.b dSQ = b.a.dSQ();
                if (com.tencent.mm.pluginsdk.model.app.h.a(aVar.Pwc.getContext(), gVar) || dSQ == null) {
                    return false;
                }
                if (!Util.isNullOrNil(gVar.fmK)) {
                    boolean ck = com.tencent.mm.pluginsdk.model.app.r.ck(aVar.Pwc.getContext(), gVar.fmK);
                    Log.i("MicroMsg.ChattingItem", "oversea game info and gpdownload url is not empty, jump to google play directy:[%s], jump result: [%b]", gVar.fmK, Boolean.valueOf(ck));
                    if (ck) {
                        return true;
                    }
                }
                int i2 = aVar.gRM() ? 2 : 1;
                is isVar = new is();
                isVar.dNr.actionCode = 2;
                isVar.dNr.scene = i2;
                isVar.dNr.appId = gVar.field_appId;
                isVar.dNr.context = aVar.Pwc.getContext();
                EventCenter.instance.publish(isVar);
                aVar.Pwc.getContext();
                dSQ.am(gVar.field_appId, i2, i2);
                return true;
            }

            public static String d(com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
                String talkerUserName = aVar.getTalkerUserName();
                if (ab.Eq(talkerUserName)) {
                    return bp.Ks(caVar.field_content);
                }
                return talkerUserName;
            }

            public static void a(ca caVar, EmojiInfo emojiInfo) {
                String str;
                di diVar = new di();
                diVar.dGs.dGt = emojiInfo;
                EmojiInfo emojiInfo2 = diVar.dGs.dGt;
                if (caVar != null) {
                    str = caVar.field_talker;
                } else {
                    str = null;
                }
                emojiInfo2.talker = str;
                diVar.dGs.scene = 0;
                EventCenter.instance.publish(diVar);
            }

            protected static boolean b(ca caVar, com.tencent.mm.ui.chatting.e.a aVar) {
                boolean z;
                k.b HD;
                long j2 = caVar.field_createTime;
                long a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_message_file_revoke_time, 120000L);
                if (!caVar.dOQ() || (HD = k.b.HD(caVar.field_content)) == null || HD.type != 6) {
                    z = cl.aWz() - j2 > 120000;
                } else {
                    Log.i("MicroMsg.ChattingItem", "File revoke time is ：%s", Long.valueOf(a2));
                    if (cl.aWz() - j2 > a2) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    Log.i("MicroMsg.ChattingItem", "isRevokeExpire, msg talker: %s, svr id: %s.", caVar.field_talker, Long.valueOf(caVar.field_msgSvrId));
                    return false;
                } else if (aVar != null && aVar.getTalkerUserName().equals(aVar.gRI()) && caVar.field_status == 2) {
                    return false;
                } else {
                    int i2 = com.tencent.mm.n.h.aqJ().getInt("ShowRevokeMsgEntry", 1);
                    Log.i("MicroMsg.ChattingItem", "[oneliang][isRevokeMsgEnable] enable:%d", Integer.valueOf(i2));
                    return 1 == i2;
                }
            }

            protected static boolean bnf(String str) {
                return (!ab.Jf(str) && !ab.Jv(str) && !ab.IT(str) && !ab.JF(str)) || ab.Eq(str);
            }

            protected static boolean gTW() {
                String value = com.tencent.mm.n.h.aqJ().getValue("ShowSendOK");
                return 1 == (Util.isNullOrNil(value) ? 0 : Util.safeParseInt(value));
            }

            protected static boolean b(com.tencent.mm.ui.chatting.d.b.k kVar, long j2) {
                return j2 > 0 && kVar.gOG() == j2;
            }

            /* access modifiers changed from: protected */
            public boolean gTX() {
                return true;
            }

            public static void r(Intent intent, String str) {
                if (ab.IK(str) || ab.IL(str)) {
                    intent.putExtra(e.p.OzJ, true);
                }
            }

            /* access modifiers changed from: package-private */
            public static class b implements i.b {
                private String ISe;
                com.tencent.mm.ui.chatting.e.a dom;

                protected b(com.tencent.mm.ui.chatting.e.a aVar, String str) {
                    this.ISe = str;
                    this.dom = aVar;
                }

                @Override // com.tencent.mm.al.i.b
                public final void e(LinkedList<fbw> linkedList) {
                    boolean z = false;
                    AppMethodBeat.i(36736);
                    ag.bai().b(this);
                    Log.d("MicroMsg.ChattingItem", "onKFSceneEnd.");
                    if (linkedList != null && linkedList.size() > 0) {
                        Log.i("MicroMsg.ChattingItem", "onKFSceneEnd, workers size : %d. callbackid=%s", Integer.valueOf(linkedList.size()), this.ISe);
                        if (this.dom != null) {
                            if (linkedList != null && linkedList.size() != 0) {
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= linkedList.size()) {
                                        break;
                                    }
                                    fbw fbw = linkedList.get(i2);
                                    if (fbw != null && !Util.isNullOrNil(fbw.NxV) && fbw.NxV.equals(this.ISe)) {
                                        Log.i("MicroMsg.ChattingItem", "needCallback find match kfopenid");
                                        if (!Util.isNullOrNil(fbw.Nickname)) {
                                            Log.i("MicroMsg.ChattingItem", "needCallback: true");
                                            z = true;
                                            break;
                                        }
                                    }
                                    i2++;
                                }
                            }
                            if (z) {
                                MMHandlerThread.postToMainThread(new Runnable() {
                                    /* class com.tencent.mm.ui.chatting.viewitems.c.b.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(36735);
                                        b.this.dom.cmy();
                                        AppMethodBeat.o(36735);
                                    }
                                });
                            }
                        }
                    }
                    AppMethodBeat.o(36736);
                }

                @Override // com.tencent.mm.al.i.b
                public final String aZT() {
                    return this.ISe;
                }
            }

            protected static String b(com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
                String str = caVar.field_talker;
                com.tencent.mm.ui.chatting.d.b.d dVar = (com.tencent.mm.ui.chatting.d.b.d) aVar.bh(com.tencent.mm.ui.chatting.d.b.d.class);
                if (!dVar.gOP() || dVar.gON() == null) {
                    return str;
                }
                return dVar.gON().field_bizChatServId;
            }
        }
