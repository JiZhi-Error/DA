package com.tencent.mm.plugin.sns.abtest;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.cg;
import com.tencent.mm.g.a.ij;
import com.tencent.mm.g.a.vl;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.a.g;
import com.tencent.mm.plugin.sns.abtest.NotInterestMenu;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.SnsPermissionUI;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.e;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.Arrays;

public final class a {
    private static boolean DqY = false;
    private static String DqZ = AppEventsConstants.EVENT_PARAM_VALUE_NO;
    private static View.OnClickListener Dra = null;
    private static int Drb = -1;
    private static int Drc = -1;
    private static long Drd = 0;
    private static View Dre = null;
    private static b Drf = null;
    private static NotInterestMenu.c Drg = null;
    private static IListener Drh = new IListener<vl>() {
        /* class com.tencent.mm.plugin.sns.abtest.a.AnonymousClass1 */

        {
            AppMethodBeat.i(160642);
            this.__eventId = vl.class.getName().hashCode();
            AppMethodBeat.o(160642);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(vl vlVar) {
            AppMethodBeat.i(94918);
            vl vlVar2 = vlVar;
            if (vlVar2 instanceof vl) {
                boolean z = vlVar2.ebH.ebI;
                long j2 = vlVar2.ebH.dNa;
                Log.d("MicroMsg.NotInteresetABTestManager", "blockUserEventListener callback, isBlock:%b, snsInfoSvrId:%b", Boolean.valueOf(z), Long.valueOf(j2));
                if (!(j2 == 0 || a.Drd == 0 || a.Drd != j2)) {
                    if (z) {
                        int unused = a.Drb = 4;
                    } else {
                        int unused2 = a.Drb = 3;
                    }
                    a.access$200();
                }
            }
            AppMethodBeat.o(94918);
            return false;
        }
    };
    private static IListener Dri = new IListener<ij>() {
        /* class com.tencent.mm.plugin.sns.abtest.a.AnonymousClass2 */

        {
            AppMethodBeat.i(160643);
            this.__eventId = ij.class.getName().hashCode();
            AppMethodBeat.o(160643);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ij ijVar) {
            AppMethodBeat.i(94919);
            ij ijVar2 = ijVar;
            if (ijVar2 instanceof ij) {
                boolean z = ijVar2.dMY.dMZ;
                long j2 = ijVar2.dMY.dNa;
                Log.d("MicroMsg.NotInteresetABTestManager", "notInterestFinishEventListener callback, isNotInterest:%b, sndId:%d", Boolean.valueOf(z), Long.valueOf(j2));
                if (!(j2 == 0 || a.Drd == 0 || j2 != a.Drd)) {
                    if (z) {
                        int unused = a.Drb = 2;
                    } else {
                        int unused2 = a.Drb = 1;
                    }
                    a.access$200();
                }
            }
            AppMethodBeat.o(94919);
            return false;
        }
    };
    private static Context context = null;

    static {
        AppMethodBeat.i(94936);
        AppMethodBeat.o(94936);
    }

    public static void d(Context context2, ViewGroup viewGroup) {
        AppMethodBeat.i(94924);
        if (g.aWT().KR("7") != null) {
            DqY = true;
            DqZ = g.aWT().KR("7").value;
            Log.d("MicroMsg.NotInteresetABTestManager", "start not interest abtest, testStyle:%s", DqZ);
            Dre = viewGroup;
            Drf = new b(viewGroup);
            context = context2;
            EventCenter.instance.addListener(Drh);
            EventCenter.instance.addListener(Dri);
            Dra = new View.OnClickListener() {
                /* class com.tencent.mm.plugin.sns.abtest.a.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(94920);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/abtest/NotInteresetABTestManager$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (view.getTag() instanceof SnsInfo) {
                        a.a(view, view.getContext(), (SnsInfo) view.getTag());
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/abtest/NotInteresetABTestManager$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(94920);
                }
            };
            Drg = new NotInterestMenu.c() {
                /* class com.tencent.mm.plugin.sns.abtest.a.AnonymousClass4 */

                @Override // com.tencent.mm.plugin.sns.abtest.NotInterestMenu.c
                public final void c(SnsInfo snsInfo) {
                    AppMethodBeat.i(94921);
                    a.a(a.context, snsInfo);
                    AppMethodBeat.o(94921);
                }

                @Override // com.tencent.mm.plugin.sns.abtest.NotInterestMenu.c
                public final void d(SnsInfo snsInfo) {
                    AppMethodBeat.i(94922);
                    a.b(a.context, snsInfo);
                    AppMethodBeat.o(94922);
                }

                @Override // com.tencent.mm.plugin.sns.abtest.NotInterestMenu.c
                public final void e(SnsInfo snsInfo) {
                    AppMethodBeat.i(94923);
                    a.c(a.context, snsInfo);
                    AppMethodBeat.o(94923);
                }
            };
            Drf.Drl = Drg;
        }
        AppMethodBeat.o(94924);
    }

    public static void eWu() {
        AppMethodBeat.i(94925);
        if (Drf != null) {
            Drf.eWy();
        }
        AppMethodBeat.o(94925);
    }

    private static void a(SnsInfo snsInfo) {
        AppMethodBeat.i(94926);
        boolean equals = DqZ.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        if (snsInfo.field_type == 1) {
            if (equals) {
                Drc = 5;
                AppMethodBeat.o(94926);
                return;
            }
            Drc = 0;
            AppMethodBeat.o(94926);
        } else if (snsInfo.field_type != 2) {
            if (snsInfo.field_type == 15) {
                if (!equals) {
                    Drc = 2;
                    AppMethodBeat.o(94926);
                    return;
                }
            } else if (r.u(snsInfo)) {
                if (equals) {
                    Drc = 6;
                    AppMethodBeat.o(94926);
                    return;
                }
                Drc = 3;
            }
            AppMethodBeat.o(94926);
        } else if (equals) {
            Drc = 4;
            AppMethodBeat.o(94926);
        } else {
            Drc = 1;
            AppMethodBeat.o(94926);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00b1, code lost:
        if (r12.field_type != 2) goto L_0x00b3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r11, com.tencent.mm.plugin.sns.storage.SnsInfo r12) {
        /*
        // Method dump skipped, instructions count: 181
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.abtest.a.a(android.content.Context, com.tencent.mm.plugin.sns.storage.SnsInfo):void");
    }

    public static void a(ContextMenu contextMenu, SnsInfo snsInfo) {
        AppMethodBeat.i(94928);
        if (DqY && DqZ.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL) && snsInfo != null && !snsInfo.isAd() && !snsInfo.getUserName().equals(aj.fau()) && snsInfo.field_type != 15) {
            contextMenu.add(0, 13, 0, R.string.h6x);
        }
        AppMethodBeat.o(94928);
    }

    public static void a(View view, BaseTimeLineItem.BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(94929);
        if (DqY && !Util.isNullOrNil(DqZ) && !DqZ.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
            baseViewHolder.EXs = (ImageView) view.findViewById(R.id.hy4);
            baseViewHolder.EXs.setVisibility(8);
            baseViewHolder.EXt = false;
            if (!DqZ.equals(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                baseViewHolder.EXs.setOnClickListener(Dra);
            }
        }
        AppMethodBeat.o(94929);
    }

    public static void b(SnsInfo snsInfo) {
        AppMethodBeat.i(94930);
        if (DqY) {
            Drd = snsInfo.field_snsId;
            a(snsInfo);
        }
        AppMethodBeat.o(94930);
    }

    public static void clean() {
        AppMethodBeat.i(94931);
        Drc = -1;
        Drb = -1;
        Drd = 0;
        Dra = null;
        Drg = null;
        Dre = null;
        context = null;
        DqY = false;
        DqZ = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        f.KW("7");
        EventCenter.instance.removeListener(Drh);
        EventCenter.instance.removeListener(Dri);
        AppMethodBeat.o(94931);
    }

    static /* synthetic */ void access$200() {
        AppMethodBeat.i(94932);
        if (DqY && Drd != 0) {
            String str = Drb + "|" + Drc + "|" + Drd;
            g.aWT().KR("7").igp = 4;
            g.aWT().KR("7").result = str;
            f.a(g.aWT().KR("7"));
            Log.d("MicroMsg.NotInteresetABTestManager", "report not interest abtest, scene:%d, result:%s", 4, str);
        }
        Drc = -1;
        Drb = -1;
        Drd = 0;
        AppMethodBeat.o(94932);
    }

    static /* synthetic */ void a(View view, Context context2, SnsInfo snsInfo) {
        boolean z;
        AppMethodBeat.i(94933);
        if (context2 != null) {
            if (snsInfo != null) {
                Drd = snsInfo.field_snsId;
            }
            b bVar = Drf;
            if (view == null || bVar.DrE) {
                AppMethodBeat.o(94933);
                return;
            }
            EventCenter.instance.publish(new cg());
            if (bVar.DrC) {
                bVar.eWy();
                AppMethodBeat.o(94933);
                return;
            }
            if (bVar.mStatusBarHeight == 0) {
                bVar.mStatusBarHeight = ao.jJ(context2);
            }
            if (bVar.mActionBarHeight == 0) {
                bVar.mActionBarHeight = h.im(context2);
            }
            if (bVar.Drx == 0) {
                bVar.Drx = view.getMeasuredHeight();
                if (bVar.Drx <= 0) {
                    bVar.Drx = com.tencent.mm.cb.a.fromDPToPix(context2, 15);
                }
            }
            if (bVar.Dry <= 0) {
                bVar.Dry = com.tencent.mm.cb.a.fromDPToPix(context2, 8);
            }
            if (bVar.Drz <= 0) {
                bVar.Drz = com.tencent.mm.cb.a.fromDPToPix(context2, 3);
            }
            if (bVar.mScreenHeight == 0) {
                bVar.mScreenHeight = ((WindowManager) context2.getSystemService("window")).getDefaultDisplay().getHeight();
                bVar.mScreenHeight -= bVar.mActionBarHeight;
                bVar.mScreenHeight -= bVar.mStatusBarHeight;
            }
            if (bVar.DrA == 0) {
                bVar.DrA = com.tencent.mm.cb.a.fromDPToPix(context2, 150);
            }
            if (bVar.DrB == 0) {
                bVar.DrB = com.tencent.mm.cb.a.fromDPToPix(context2, 13);
            }
            bVar.Drq = new NotInterestMenu(context2);
            if (bVar.Drl != null) {
                bVar.Drq.setOnSelectMenuItemListener(bVar.Drl);
            }
            bVar.Drq.setOnClickMenuListener(bVar.Drs);
            bVar.Drq.setSnsInfo(snsInfo);
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            Log.d("MicroMsg.NotInterestMenuHelper", "hateLocation: %s", Arrays.toString(iArr));
            int i2 = iArr[1];
            int i3 = (((i2 - bVar.mStatusBarHeight) - bVar.mActionBarHeight) + bVar.Drx) - bVar.Dry;
            Log.d("MicroMsg.NotInterestMenuHelper", "getDownModeMenuYCoord, hateClickViewYCoord:%d, y:%d, mStatusBarHeight:%d, actionBarHeight:%d, hateClickViewHeight:%d, mHateClickDownPadding:%d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(bVar.mStatusBarHeight), Integer.valueOf(bVar.mActionBarHeight), Integer.valueOf(bVar.Drx), Integer.valueOf(bVar.Dry));
            Log.d("MicroMsg.NotInterestMenuHelper", "isEnoughHeightToDownMenu, y:%d, menuHeight:%d, screenHeight:%d", Integer.valueOf(i3), Integer.valueOf(bVar.DrA), Integer.valueOf(bVar.mScreenHeight));
            if (bVar.DrA + i3 > bVar.mScreenHeight) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                bVar.Drq.setBackgroundResource(R.drawable.ciw);
                bVar.DrF = true;
            } else {
                bVar.Drq.setBackgroundResource(R.drawable.cix);
                int i4 = iArr[1];
                i3 = (((i4 - bVar.mStatusBarHeight) - bVar.mActionBarHeight) - bVar.DrA) + bVar.Drz;
                Log.d("MicroMsg.NotInterestMenuHelper", "getUpModeMenuYCoord, hateClickViewYCoord:%d, y:%d, mStatusBarHeight:%d, actionBarHeight:%d, hateClickViewHeight:%d, mHateClickUpPadding:%d, mMenuHeight:%d", Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(bVar.mStatusBarHeight), Integer.valueOf(bVar.mActionBarHeight), Integer.valueOf(bVar.Drx), Integer.valueOf(bVar.Drz), Integer.valueOf(bVar.DrA));
                bVar.DrF = false;
            }
            if (bVar.DrD == null) {
                bVar.DrD = new AbsoluteLayout(context2);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                bVar.DrD.setBackgroundDrawable(context2.getResources().getDrawable(R.drawable.s6));
                bVar.DrD.setPadding(bVar.DrB, 0, bVar.DrB, 0);
                bVar.DrD.setLayoutParams(layoutParams);
            }
            if (bVar.Drr != null) {
                bVar.Drr.addView(bVar.DrD);
            }
            bVar.DrD.addView(bVar.Drq, new AbsoluteLayout.LayoutParams(-1, -2, 0, i3));
            bVar.Drq.setVisibility(4);
            if (bVar.DrF) {
                bVar.Drq.startAnimation(bVar.Drt);
                AppMethodBeat.o(94933);
                return;
            }
            bVar.Drq.startAnimation(bVar.Dru);
        }
        AppMethodBeat.o(94933);
    }

    static /* synthetic */ void b(Context context2, SnsInfo snsInfo) {
        AppMethodBeat.i(94934);
        if (!(snsInfo == null || context2 == null)) {
            a(snsInfo);
            String userName = snsInfo.getUserName();
            Intent intent = new Intent();
            intent.putExtra("sns_permission_userName", userName);
            intent.putExtra("sns_permission_snsinfo_svr_id", snsInfo.field_snsId);
            intent.putExtra("sns_permission_block_scene", 6);
            intent.setClass(context2, SnsPermissionUI.class);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context2, bl.axQ(), "com/tencent/mm/plugin/sns/abtest/NotInteresetABTestManager", "dealBlock", "(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context2.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/plugin/sns/abtest/NotInteresetABTestManager", "dealBlock", "(Landroid/content/Context;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(94934);
    }

    static /* synthetic */ void c(Context context2, SnsInfo snsInfo) {
        AppMethodBeat.i(94935);
        if (!(snsInfo == null || context2 == null)) {
            a(snsInfo);
            Intent intent = new Intent();
            Log.i("MicroMsg.NotInteresetABTestManager", "expose id " + snsInfo.getSnsId());
            intent.putExtra("showShare", false);
            intent.putExtra("k_expose_msg_id", snsInfo == null ? 0 : snsInfo.field_snsId);
            intent.putExtra("k_username", snsInfo == null ? "" : snsInfo.field_userName);
            intent.putExtra("rawUrl", String.format(e.C2115e.OyU, 33));
            c.b(context2, "webview", ".ui.tools.WebViewUI", intent);
        }
        AppMethodBeat.o(94935);
    }
}
