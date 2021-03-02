package com.tencent.mm.plugin.sns.ad.timeline.feedback;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.ad.timeline.feedback.b;
import com.tencent.mm.plugin.sns.ad.timeline.feedback.ui.a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.s;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.u;
import java.util.Iterator;
import java.util.List;

public final class c implements PopupWindow.OnDismissListener, b.c {
    private a Dys;
    private View Dyt;
    private b Dyu;
    private a Dyv;
    private com.tencent.mm.plugin.sns.ui.d.c Dyw;
    private int Dyx;
    private boolean Dyy;
    private Context mContext;
    private int qXG;
    private int xzP;

    public static c a(Context context, com.tencent.mm.plugin.sns.ui.d.c cVar) {
        c cVar2;
        AppMethodBeat.i(202171);
        if (context != null) {
            try {
                cVar2 = new c(context);
                try {
                    cVar2.Dyw = cVar;
                } catch (Throwable th) {
                    Log.w("FeedbackPromptManager", "create new feedback panel failed!");
                    AppMethodBeat.o(202171);
                    return cVar2;
                }
            } catch (Throwable th2) {
                cVar2 = null;
                Log.w("FeedbackPromptManager", "create new feedback panel failed!");
                AppMethodBeat.o(202171);
                return cVar2;
            }
        } else {
            cVar2 = null;
        }
        AppMethodBeat.o(202171);
        return cVar2;
    }

    private c(Context context) {
        this(context, (byte) 0);
    }

    private c(Context context, byte b2) {
        AppMethodBeat.i(202172);
        this.Dyx = 0;
        this.Dyy = false;
        this.qXG = 0;
        this.mContext = context;
        this.xzP = R.layout.btx;
        this.Dyv = new a();
        this.Dyu = new b(context, this.Dyv, this);
        this.qXG = this.mContext.getResources().getDimensionPixelOffset(R.dimen.ajs);
        if (context instanceof SnsCommentDetailUI) {
            this.Dyy = true;
        }
        AppMethodBeat.o(202172);
    }

    public final boolean a(View view, SnsInfo snsInfo) {
        com.tencent.mm.plugin.sns.data.c cVar;
        View view2;
        int i2;
        float f2;
        ViewParent parent;
        AppMethodBeat.i(202173);
        if (view == null) {
            AppMethodBeat.o(202173);
            return false;
        }
        try {
            Object tag = view.getTag();
            if (tag instanceof com.tencent.mm.plugin.sns.data.c) {
                cVar = (com.tencent.mm.plugin.sns.data.c) tag;
            } else {
                Log.w("FeedbackPromptManager", "the tag is not AdUnlikeTag");
                cVar = null;
            }
            if (cVar == null) {
                Log.e("FeedbackPromptManager", "the unlike tag is null. there is no data for showing window!");
                AppMethodBeat.o(202173);
                return false;
            }
            a aVar = this.Dyv;
            try {
                aVar.DxX = cVar;
                if (snsInfo != null) {
                    aVar.DqO = snsInfo;
                } else if (cVar != null) {
                    aVar.DqO = aj.faO().aQm(cVar.dHp);
                }
                aVar.DxY = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
            } catch (Throwable th) {
                Log.w("FeedbackDisplayDataSupplier", "there is something wrong in updateData");
            }
            if (!this.Dyv.eXJ()) {
                AppMethodBeat.o(202173);
                return false;
            }
            if (this.Dys == null) {
                View inflate = LayoutInflater.from(this.mContext).inflate(this.xzP, (ViewGroup) null);
                this.Dys = new a(this.mContext);
                this.Dys.setContentView(inflate);
                this.Dys.setWidth(this.qXG);
                this.Dys.setHeight(-2);
                this.Dys.setFocusable(true);
                this.Dys.setBackgroundDrawable(new ColorDrawable(0));
                this.Dys.setOnDismissListener(this);
            }
            if (this.Dys.isShowing()) {
                AppMethodBeat.o(202173);
                return true;
            }
            if ((view instanceof ViewGroup) || (parent = view.getParent()) == null) {
                view2 = view;
            } else {
                view2 = (View) parent;
            }
            this.Dyt = view2;
            this.Dyu.eY(this.Dys.getContentView());
            int m = m(this.Dyt, this.Dys.getContentView());
            XM(m);
            a aVar2 = this.Dys;
            if (m < 0) {
                i2 = R.style.uh;
            } else {
                i2 = R.style.ui;
            }
            aVar2.setAnimationStyle(i2);
            this.Dys.showAsDropDown(this.Dyt, 0, m, 8388613);
            a aVar3 = this.Dys;
            if (ao.isDarkMode()) {
                f2 = 0.1f;
            } else {
                f2 = 0.5f;
            }
            try {
                View rootView = aVar3.getContentView().getRootView();
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) rootView.getLayoutParams();
                layoutParams.flags |= 2;
                layoutParams.dimAmount = f2;
                ((WindowManager) aVar3.mContext.getSystemService("window")).updateViewLayout(rootView, layoutParams);
            } catch (Throwable th2) {
                Log.w("FeedbackPopupWindow", "the window dim account is set failed!");
            }
            AppMethodBeat.o(202173);
            return true;
        } catch (Throwable th3) {
            Log.e("FeedbackPromptManager", "show feedback window has something wrong!");
            AppMethodBeat.o(202173);
            return false;
        }
    }

    private void XM(int i2) {
        AppMethodBeat.i(202174);
        if (this.Dyu != null) {
            this.Dyu.XM(i2);
        }
        AppMethodBeat.o(202174);
    }

    private static Rect eZ(View view) {
        AppMethodBeat.i(202175);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = rect.left + view.getWidth();
        rect.bottom = rect.top + view.getHeight();
        AppMethodBeat.o(202175);
        return rect;
    }

    private int m(View view, View view2) {
        AppMethodBeat.i(202176);
        view2.measure(View.MeasureSpec.makeMeasureSpec(this.qXG, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        int measuredHeight = view2.getMeasuredHeight();
        Rect eZ = eZ(view);
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        if (eZ.bottom + measuredHeight > rect.height()) {
            int i2 = -(eZ.height() + measuredHeight);
            AppMethodBeat.o(202176);
            return i2;
        }
        AppMethodBeat.o(202176);
        return 0;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.sns.ad.timeline.feedback.b.c
    public final void a(View view, int i2, Object obj) {
        s sVar;
        ADInfo.c.a aVar;
        int i3 = 1;
        com.tencent.mm.plugin.sns.ad.timeline.feedback.a.a aVar2 = null;
        AppMethodBeat.i(202177);
        if (i2 == 5) {
            try {
                if (obj instanceof b.d) {
                    this.Dyx = ((b.d) obj).Dyq;
                }
                AppMethodBeat.o(202177);
            } catch (Throwable th) {
                Log.e("FeedbackPromptManager", "onAction failed : actionId = ".concat(String.valueOf(i2)));
                AppMethodBeat.o(202177);
            }
        } else {
            switch (i2) {
                case 1:
                    if (this.Dyv.eXK()) {
                        int m = m(this.Dyt, this.Dys.getContentView());
                        XM(m);
                        this.Dys.update(this.Dyt, 0, m, -1, -1);
                        s XL = this.Dyv.XL(0);
                        if (XL != null) {
                            g.aAi();
                            g.aAg().hqi.a(XL, 0);
                        }
                        AppMethodBeat.o(202177);
                        return;
                    }
                    eXQ();
                    eXP();
                    if (this.Dyw != null) {
                        this.Dyw.ft(view);
                    }
                    s XL2 = this.Dyv.XL(1);
                    if (XL2 != null) {
                        g.aAi();
                        g.aAg().hqi.a(XL2, 0);
                    }
                    AppMethodBeat.o(202177);
                    return;
                case 2:
                    eXQ();
                    eXP();
                    a aVar3 = this.Dyv;
                    boolean z = this.Dyy;
                    SnsInfo snsInfo = aVar3.DqO;
                    ADXml adXml = aVar3.getAdXml();
                    ADInfo adInfo = aVar3.getAdInfo();
                    if (!(snsInfo == null || adXml == null || adInfo == null || snsInfo == null || adInfo == null || adXml == null)) {
                        aVar2 = new com.tencent.mm.plugin.sns.ad.timeline.feedback.a.a();
                        aVar2.Dyz = snsInfo.field_snsId;
                        if (z) {
                            i3 = 2;
                        }
                        aVar2.mScene = i3;
                        aVar2.DyA = i.aNZ(adInfo.uxInfo);
                        aVar2.DyB = adXml.adExtInfo;
                    }
                    com.tencent.mm.plugin.sns.ad.i.i.a(aVar2);
                    AppMethodBeat.o(202177);
                    return;
                case 3:
                    eXP();
                    try {
                        Context context = this.mContext;
                        if (context != null) {
                            com.tencent.mm.plugin.sns.c.a.jRt.i(this.Dyv.eXL(), context);
                        }
                        AppMethodBeat.o(202177);
                        return;
                    } catch (Throwable th2) {
                        AppMethodBeat.o(202177);
                        return;
                    }
                case 4:
                    eXQ();
                    eXP();
                    if (this.Dyw != null) {
                        this.Dyw.ft(view);
                    }
                    a aVar4 = this.Dyv;
                    int i4 = this.Dyx;
                    ADInfo adInfo2 = aVar4.getAdInfo();
                    SnsInfo snsInfo2 = aVar4.DqO;
                    com.tencent.mm.plugin.sns.data.c cVar = aVar4.DxX;
                    if (cVar == null || snsInfo2 == null || adInfo2 == null || adInfo2.adUnlikeInfo == null) {
                        sVar = null;
                    } else {
                        List<ADInfo.c.a> fcH = adInfo2.adUnlikeInfo.fcH();
                        if (com.tencent.mm.plugin.sns.ad.i.c.o(fcH)) {
                            Iterator<ADInfo.c.a> it = fcH.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    ADInfo.c.a next = it.next();
                                    if (next != null && next.DWd == i4) {
                                        aVar = next;
                                    }
                                }
                            }
                        }
                        aVar = null;
                        if (aVar == null) {
                            sVar = null;
                        } else {
                            aVar.DDs = cVar.DDs;
                            aVar.DWe = System.currentTimeMillis();
                            sVar = new s(snsInfo2.field_snsId, 8, aVar);
                        }
                    }
                    if (sVar != null) {
                        g.aAi();
                        g.aAg().hqi.a(sVar, 0);
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(202177);
        }
    }

    public final void onDismiss() {
        this.Dys = null;
    }

    private void eXP() {
        AppMethodBeat.i(202178);
        if (this.Dys != null) {
            this.Dys.dismiss();
        }
        AppMethodBeat.o(202178);
    }

    private void eXQ() {
        AppMethodBeat.i(202179);
        try {
            u.cG(this.mContext, this.mContext.getString(R.string.h4f));
            AppMethodBeat.o(202179);
        } catch (Throwable th) {
            AppMethodBeat.o(202179);
        }
    }
}
