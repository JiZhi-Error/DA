package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.chatting.ah;
import com.tencent.mm.ui.chatting.viewitems.bq;

public final class r {
    public static b PhA = new b();

    static {
        AppMethodBeat.i(34577);
        AppMethodBeat.o(34577);
    }

    public static void dQ(View view) {
        AppMethodBeat.i(34574);
        b bVar = PhA;
        if (view == null || bVar == null) {
            Log.w("MicroMsg.OnHoverCompatibleHelper", "view or callback is null.");
            AppMethodBeat.o(34574);
            return;
        }
        if (Build.VERSION.SDK_INT >= 14) {
            ah gOj = ah.gOj();
            if (Build.VERSION.SDK_INT >= 14 && gOj.PjV == null) {
                gOj.PjV = new ah.a(bVar);
            }
            Object obj = gOj.PjV;
            if (obj != null && Build.VERSION.SDK_INT >= 14 && (obj instanceof View.OnHoverListener)) {
                view.setOnHoverListener((View.OnHoverListener) obj);
            }
        }
        AppMethodBeat.o(34574);
    }

    public static void dismiss() {
        AppMethodBeat.i(34575);
        try {
            if (PhA != null) {
                b.a(PhA);
            }
            AppMethodBeat.o(34575);
        } catch (Exception e2) {
            Log.e("MicroMsg.ChattingItemAvatarOnHoverHelper", "exception in dismiss, %s", e2.getMessage());
            AppMethodBeat.o(34575);
        }
    }

    public static class b implements View.OnClickListener, View.OnTouchListener, ah.b {
        private int Bgx;
        private p PhB;
        private View PhC;
        private View PhD;
        private int PhE;
        private int PhF;
        private int PhG;
        private boolean PhH;
        private a PhI = new a();
        private View.OnTouchListener PhJ = new View.OnTouchListener() {
            /* class com.tencent.mm.ui.chatting.r.b.AnonymousClass1 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(34566);
                if (b.this.PhI != null) {
                    b.this.PhI.onTouch(b.this.mContentView, motionEvent);
                }
                AppMethodBeat.o(34566);
                return false;
            }
        };
        private int PhK = 300;
        private MTimerHandler.CallBack PhL = new MTimerHandler.CallBack() {
            /* class com.tencent.mm.ui.chatting.r.b.AnonymousClass2 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(34567);
                if (!(b.this.azy == null || b.this.PhB == null)) {
                    b.this.PhB.showAsDropDown(b.this.azy, b.this.PhF, b.this.PhG);
                }
                AppMethodBeat.o(34567);
                return false;
            }
        };
        private View azy;
        private MTimerHandler cve;
        private View mContentView;
        private int mMargin;
        private int mStatusBarHeight;

        public b() {
            AppMethodBeat.i(34568);
            AppMethodBeat.o(34568);
        }

        static /* synthetic */ void a(b bVar) {
            AppMethodBeat.i(34573);
            bVar.dismiss();
            AppMethodBeat.o(34573);
        }

        private void dismiss() {
            AppMethodBeat.i(34569);
            if (this.PhB != null) {
                this.PhB.dismiss();
            }
            AppMethodBeat.o(34569);
        }

        @Override // com.tencent.mm.ui.chatting.ah.b
        public final boolean g(View view, MotionEvent motionEvent) {
            boolean z;
            AppMethodBeat.i(34570);
            Object tag = view.getTag();
            if (tag == null || !(tag instanceof bq)) {
                Log.i("MicroMsg.ChattingItemAvatarOnHoverHelper", "The Tag of the View is not a instance of ItemDataTag or is null.");
                AppMethodBeat.o(34570);
                return false;
            }
            bq bqVar = (bq) view.getTag();
            String str = bqVar.userName;
            String aTY = z.aTY();
            if (Util.isNullOrNil(aTY) || aTY.equals(str)) {
                Log.v("MicroMsg.ChattingItemAvatarOnHoverHelper", "Can't talk to self and self username can't be null.");
                z = false;
            } else {
                z = true;
            }
            if (!z) {
                AppMethodBeat.o(34570);
                return false;
            }
            Context context = view.getContext();
            if (this.PhB == null) {
                Resources resources = context.getResources();
                this.PhE = (int) ((resources.getDimension(R.dimen.f3062g) * 2.0f) + resources.getDimension(R.dimen.ig));
                this.mContentView = View.inflate(context, R.layout.qo, null);
                this.PhC = this.mContentView.findViewById(R.id.j3q);
                this.PhD = this.mContentView.findViewById(R.id.vm);
                this.PhD.setOnClickListener(this);
                this.PhC.setOnClickListener(this);
                this.PhD.setOnTouchListener(this.PhJ);
                this.PhC.setOnTouchListener(this.PhJ);
                this.PhB = new p(this.mContentView, -2, this.PhE, false);
                this.PhB.setOutsideTouchable(true);
                Rect rect = new Rect();
                if (context instanceof Activity) {
                    ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                }
                this.mStatusBarHeight = rect.top;
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                    this.Bgx = context.getResources().getDimensionPixelSize(R.dimen.b8);
                } else {
                    this.Bgx = context.getResources().getDimensionPixelSize(R.dimen.b9);
                }
                this.PhB.setBackgroundDrawable(new ColorDrawable(16777215));
                this.mMargin = 0;
                this.cve = new MTimerHandler(Looper.getMainLooper(), this.PhL, false);
                Log.i("MicroMsg.ChattingItemAvatarOnHoverHelper", "Create a new PopupWindow.");
            }
            p pVar = this.PhB;
            switch (motionEvent.getAction()) {
                case 9:
                    this.azy = view;
                    view.setOnTouchListener(this);
                    if (pVar.isShowing()) {
                        pVar.dismiss();
                    }
                    if (!this.PhH) {
                        this.PhD.setTag(bqVar);
                        this.PhC.setTag(bqVar);
                        this.PhD.setVisibility(0);
                        this.PhC.setVisibility(8);
                        int[] iArr = new int[2];
                        view.getLocationInWindow(iArr);
                        int i2 = iArr[1];
                        view.getWidth();
                        int height = view.getHeight();
                        this.PhG = this.mMargin;
                        if (i2 > this.mStatusBarHeight + this.Bgx + this.PhE) {
                            this.PhG = ((-height) - this.PhE) - this.mMargin;
                        }
                        this.PhF = 0;
                        if (this.PhG >= 0) {
                            this.mContentView.setBackgroundResource(R.drawable.c47);
                        } else {
                            this.mContentView.setBackgroundResource(R.drawable.c48);
                        }
                        this.cve.startTimer((long) this.PhK);
                        break;
                    }
                    break;
                case 10:
                    this.PhH = false;
                    this.azy = null;
                    break;
            }
            AppMethodBeat.o(34570);
            return true;
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(34571);
            switch (motionEvent.getAction()) {
                case 1:
                    this.PhH = true;
                    dismiss();
                    break;
                case 3:
                    dismiss();
                    break;
            }
            AppMethodBeat.o(34571);
            return false;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(34572);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingItemAvatarOnHoverHelper$OnHoverMotionEventCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            bq bqVar = (bq) view.getTag();
            if (view == this.PhD) {
                r.v(view.getContext(), bqVar.userName, 3);
            } else {
                r.v(view.getContext(), bqVar.userName, 2);
            }
            dismiss();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingItemAvatarOnHoverHelper$OnHoverMotionEventCallback", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(34572);
        }
    }

    public static class a implements View.OnTouchListener {
        private int mColor;

        public a() {
            this(Color.argb(255, (int) com.tencent.mm.plugin.appbrand.jsapi.k.r.CTRL_INDEX, (int) com.tencent.mm.plugin.appbrand.jsapi.k.r.CTRL_INDEX, (int) com.tencent.mm.plugin.appbrand.jsapi.k.r.CTRL_INDEX));
            AppMethodBeat.i(34564);
            AppMethodBeat.o(34564);
        }

        private a(int i2) {
            this.mColor = i2;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            Drawable background;
            AppMethodBeat.i(34565);
            int action = motionEvent.getAction();
            if (view instanceof ImageView) {
                background = ((ImageView) view).getDrawable();
            } else {
                background = view.getBackground();
            }
            if (background != null) {
                if (action == 0) {
                    background.setColorFilter(this.mColor, PorterDuff.Mode.MULTIPLY);
                } else if (action == 3 || action == 1) {
                    background.clearColorFilter();
                }
            }
            AppMethodBeat.o(34565);
            return false;
        }
    }

    static /* synthetic */ void v(Context context, String str, int i2) {
        AppMethodBeat.i(34576);
        zj zjVar = new zj();
        zjVar.efx.dKy = 5;
        zjVar.efx.talker = str;
        zjVar.efx.context = context;
        zjVar.efx.eft = i2;
        EventCenter.instance.publish(zjVar);
        h.INSTANCE.a(11033, 4, 1, 0);
        AppMethodBeat.o(34576);
    }
}
