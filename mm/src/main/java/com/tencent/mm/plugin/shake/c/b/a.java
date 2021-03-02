package com.tencent.mm.plugin.shake.c.b;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.b.g;
import com.tencent.mm.g.a.ul;
import com.tencent.mm.g.a.um;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.shake.c.a.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;

public final class a extends i {
    private static final String pTN = (com.tencent.mm.loader.j.b.aKJ() + "card");
    private View Bhb;
    private TextView CuH;
    private e DhN;
    private View DhR;
    private TextView DhS;
    private TextView DhT;
    private TextView DhU;
    private TextView DhV;
    private View DhW;
    private View DhX;
    private TextView DhY;
    private TextView DhZ;
    private TextView Dia;
    private View Dib;
    private ImageView Dic;
    public boolean Did = false;
    private boolean Die = false;
    private int Dif = 0;
    private ul.b Dig;
    private EnumC1690a Dih = EnumC1690a.PRE_ACCEPT;
    private b Dii;
    private IListener Dij = new IListener<um>() {
        /* class com.tencent.mm.plugin.shake.c.b.a.AnonymousClass1 */

        {
            AppMethodBeat.i(161435);
            this.__eventId = um.class.getName().hashCode();
            AppMethodBeat.o(161435);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(um umVar) {
            AppMethodBeat.i(28217);
            a.this.dismiss();
            if (a.this.Dii != null) {
                a.this.Dii.exp();
            }
            Log.i("MicroMsg.ShakeCardDialog", "gift event come, do close ShakeCardDialog");
            AppMethodBeat.o(28217);
            return false;
        }
    };
    private View jBN;
    private ProgressBar krF;
    private View.OnClickListener kuO = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.shake.c.b.a.AnonymousClass2 */

        public final void onClick(View view) {
            AppMethodBeat.i(28218);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/shake/shakecard/ui/ShakeCardDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (view.getId() == R.id.al9) {
                a.this.dismiss();
                if (a.this.Dii != null) {
                    a.this.Dii.exp();
                }
                Log.i("MicroMsg.ShakeCardDialog", "close ShakeCardDialog");
            } else if (view.getId() == R.id.ajp) {
                if (a.this.Dih == EnumC1690a.PRE_ACCEPT) {
                    a.this.Dih = EnumC1690a.ACCEPTING;
                    a.a(a.this, 0);
                    a.c(a.this);
                    a.d(a.this);
                } else if (a.this.Dih != EnumC1690a.ACCEPTING) {
                    if (a.this.Dih == EnumC1690a.ACCEPTED_FAIL) {
                        a.d(a.this);
                    } else if (a.this.Dih == EnumC1690a.ACCEPTED_SUCCES) {
                        EventCenter.instance.addListener(a.this.Dij);
                        a.f(a.this);
                    }
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/shakecard/ui/ShakeCardDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(28218);
        }
    };
    private Resources mResources;
    private boolean ox;
    private String pQH = "";
    private ImageView pWZ;
    private Button pXa;
    private ImageView yTs;

    public interface b {
        void exp();
    }

    static /* synthetic */ void c(a aVar) {
        AppMethodBeat.i(28233);
        aVar.eUy();
        AppMethodBeat.o(28233);
    }

    static /* synthetic */ void h(a aVar) {
        AppMethodBeat.i(28236);
        aVar.updateLayout();
        AppMethodBeat.o(28236);
    }

    static /* synthetic */ void k(a aVar) {
        AppMethodBeat.i(28238);
        aVar.eUz();
        AppMethodBeat.o(28238);
    }

    static {
        AppMethodBeat.i(28239);
        AppMethodBeat.o(28239);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.plugin.shake.c.b.a$a  reason: collision with other inner class name */
    public enum EnumC1690a {
        PRE_ACCEPT,
        ACCEPTING,
        ACCEPTED_SUCCES,
        ACCEPTED_FAIL;

        public static EnumC1690a valueOf(String str) {
            AppMethodBeat.i(28221);
            EnumC1690a aVar = (EnumC1690a) Enum.valueOf(EnumC1690a.class, str);
            AppMethodBeat.o(28221);
            return aVar;
        }

        static {
            AppMethodBeat.i(28222);
            AppMethodBeat.o(28222);
        }
    }

    private a(Context context) {
        super(context, R.style.a67);
        AppMethodBeat.i(28223);
        Log.i("MicroMsg.ShakeCardDialog", "init shake card dialog");
        this.mResources = context.getResources();
        setCanceledOnTouchOutside(true);
        getWindow().setSoftInputMode(2);
        this.jBN = View.inflate(context, R.layout.brk, null);
        this.DhR = this.jBN.findViewById(R.id.hnc);
        this.DhS = (TextView) this.jBN.findViewById(R.id.app);
        this.DhT = (TextView) this.jBN.findViewById(R.id.ap_);
        this.DhU = (TextView) this.jBN.findViewById(R.id.als);
        this.yTs = (ImageView) this.jBN.findViewById(R.id.al9);
        this.pXa = (Button) this.jBN.findViewById(R.id.ajp);
        this.DhV = (TextView) this.jBN.findViewById(R.id.ajv);
        this.krF = (ProgressBar) this.jBN.findViewById(R.id.aoo);
        this.yTs.setOnClickListener(this.kuO);
        this.pXa.setOnClickListener(this.kuO);
        this.Bhb = this.jBN.findViewById(R.id.akm);
        this.DhW = this.jBN.findViewById(R.id.jnu);
        this.DhX = this.jBN.findViewById(R.id.aps);
        this.pWZ = (ImageView) this.jBN.findViewById(R.id.any);
        this.DhY = (TextView) this.jBN.findViewById(R.id.api);
        this.DhZ = (TextView) this.jBN.findViewById(R.id.aku);
        this.Dia = (TextView) this.jBN.findViewById(R.id.ape);
        this.Dib = this.jBN.findViewById(R.id.aot);
        this.Dic = (ImageView) this.jBN.findViewById(R.id.h5o);
        this.CuH = (TextView) this.jBN.findViewById(R.id.h5m);
        this.Dif = com.tencent.mm.plugin.shake.c.c.a.eUD();
        AppMethodBeat.o(28223);
    }

    public final boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(28224);
        if (i2 == 4) {
            Log.i("MicroMsg.ShakeCardDialog", "back key in shake card dialog");
            dismiss();
            if (this.Dii != null) {
                this.Dii.exp();
            }
        }
        boolean onKeyUp = super.onKeyUp(i2, keyEvent);
        AppMethodBeat.o(28224);
        return onKeyUp;
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(28225);
        super.onCreate(bundle);
        setContentView(this.jBN);
        AppMethodBeat.o(28225);
    }

    public final void setCancelable(boolean z) {
        AppMethodBeat.i(28226);
        super.setCancelable(z);
        this.ox = z;
        setCanceledOnTouchOutside(this.ox);
        AppMethodBeat.o(28226);
    }

    @Override // com.tencent.mm.ui.base.i
    public final void dismiss() {
        AppMethodBeat.i(28227);
        try {
            if (this.Dii != null) {
                this.Dii.exp();
            }
            if (this.Dih != EnumC1690a.ACCEPTED_SUCCES && !this.Die) {
                this.Die = true;
                Log.i("MicroMsg.ShakeCardDialog", "ShakeCardDialog card is not cancel accepte");
                bg.azz().a(new com.tencent.mm.plugin.shake.c.a.a(this.DhN.pRX, this.DhN.eaP), 0);
            }
            EventCenter.instance.removeListener(this.Dij);
            Log.i("MicroMsg.ShakeCardDialog", "dismiss ShakeCardDialog");
            super.dismiss();
            AppMethodBeat.o(28227);
        } catch (Exception e2) {
            Log.e("MicroMsg.ShakeCardDialog", "dismiss exception, e = " + e2.getMessage());
            AppMethodBeat.o(28227);
        }
    }

    private void updateLayout() {
        AppMethodBeat.i(28228);
        if (this.Dih == EnumC1690a.ACCEPTED_SUCCES) {
            this.Bhb.setVisibility(8);
            this.Dib.setVisibility(0);
            AppMethodBeat.o(28228);
            return;
        }
        if (this.Dih == EnumC1690a.PRE_ACCEPT || this.Dih == EnumC1690a.ACCEPTING || this.Dih == EnumC1690a.ACCEPTED_FAIL) {
            this.Bhb.setVisibility(0);
            this.Dib.setVisibility(8);
        }
        AppMethodBeat.o(28228);
    }

    private void eUy() {
        AppMethodBeat.i(28229);
        if (this.Dih == EnumC1690a.PRE_ACCEPT || this.Dih == EnumC1690a.ACCEPTED_FAIL) {
            if (TextUtils.isEmpty(this.DhN.Dhx)) {
                this.pXa.setText(R.string.ann);
                AppMethodBeat.o(28229);
                return;
            }
            this.pXa.setText(this.DhN.Dhx);
            AppMethodBeat.o(28229);
        } else if (this.Dih == EnumC1690a.ACCEPTING) {
            this.pXa.setText("");
            AppMethodBeat.o(28229);
        } else {
            if (this.Dih == EnumC1690a.ACCEPTED_SUCCES) {
                this.pXa.setText(R.string.gy2);
            }
            AppMethodBeat.o(28229);
        }
    }

    private void eUz() {
        AppMethodBeat.i(28230);
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(R.dimen.aiv);
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{(float) dimensionPixelOffset, (float) dimensionPixelOffset, (float) dimensionPixelOffset, (float) dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f}, null, null));
        shapeDrawable.getPaint().setColor(com.tencent.mm.plugin.shake.c.c.a.ake(this.DhN.ixw));
        this.DhX.setBackgroundDrawable(shapeDrawable);
        eUy();
        if (!TextUtils.isEmpty(this.DhN.Dhv)) {
            this.DhS.setText(this.DhN.Dhv);
        }
        if (!TextUtils.isEmpty(this.DhN.Dhz)) {
            this.DhT.setText(this.DhN.Dhz);
            this.DhT.setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.DhN.Dhw)) {
            this.DhU.setText(this.DhN.Dhw);
            this.DhU.setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.DhN.iwv)) {
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.aiu);
            ImageView imageView = this.pWZ;
            String str = this.DhN.iwv;
            if (imageView != null && !TextUtils.isEmpty(str)) {
                if (!TextUtils.isEmpty(str)) {
                    c.a aVar = new c.a();
                    aVar.prefixPath = com.tencent.mm.loader.j.b.aKJ();
                    q.bcW();
                    aVar.jbw = null;
                    aVar.fullPath = String.format("%s/%s", pTN, g.getMessageDigest(str.getBytes()));
                    aVar.jbf = true;
                    aVar.iaT = true;
                    aVar.jbd = true;
                    aVar.hZA = dimensionPixelSize;
                    aVar.hZz = dimensionPixelSize;
                    aVar.jbq = R.raw.shake_card_package_defaultlogo;
                    q.bcV().a(str, imageView, aVar.bdv());
                } else {
                    imageView.setImageResource(R.raw.shake_card_package_defaultlogo);
                }
            }
        }
        if (!TextUtils.isEmpty(this.DhN.title)) {
            this.DhY.setText(this.DhN.title);
        }
        if (!TextUtils.isEmpty(this.DhN.gTG)) {
            this.DhZ.setText(this.DhN.gTG);
        }
        if (this.DhN.pSb > 0) {
            this.Dia.setText(getContext().getString(R.string.ats, com.tencent.mm.plugin.shake.c.c.a.AF((long) this.DhN.pSb)));
        }
        if (this.Dih == EnumC1690a.ACCEPTED_FAIL) {
            this.DhV.setVisibility(0);
            AppMethodBeat.o(28230);
            return;
        }
        this.DhV.setVisibility(8);
        AppMethodBeat.o(28230);
    }

    public static a a(Context context, e eVar, DialogInterface.OnCancelListener onCancelListener, b bVar) {
        AppMethodBeat.i(28231);
        if (((Activity) context).isFinishing()) {
            AppMethodBeat.o(28231);
            return null;
        }
        a aVar = new a(context);
        aVar.setOnCancelListener(onCancelListener);
        aVar.setCancelable(true);
        aVar.DhN = eVar;
        if (aVar.DhN == null) {
            Log.e("MicroMsg.ShakeCardDialog", "updateView() mCardItem == null");
        } else {
            if (TextUtils.isEmpty(aVar.DhN.title)) {
                aVar.DhS.setText(aVar.DhN.title);
            }
            Log.i("MicroMsg.ShakeCardDialog", "updateView() action_type is has card");
            aVar.Dih = EnumC1690a.PRE_ACCEPT;
            aVar.updateLayout();
            aVar.eUz();
            if (aVar.Dif == 0) {
                aVar.DhR.setBackgroundResource(R.drawable.asz);
                aVar.DhW.setBackgroundResource(R.drawable.at0);
                aVar.DhS.setTextColor(aVar.mResources.getColor(R.color.a2x));
                aVar.DhT.setTextColor(aVar.mResources.getColor(R.color.a2g));
                aVar.DhU.setTextColor(aVar.mResources.getColor(R.color.a2g));
                aVar.CuH.setTextColor(aVar.getContext().getResources().getColor(R.color.a2x));
                aVar.pXa.setBackgroundResource(R.drawable.k7);
                aVar.pXa.setTextColor(aVar.getContext().getResources().getColor(R.color.ag2));
                aVar.DhV.setTextColor(aVar.getContext().getResources().getColor(R.color.a2q));
            }
        }
        aVar.Dii = bVar;
        aVar.show();
        h.a(context, aVar);
        AppMethodBeat.o(28231);
        return aVar;
    }

    static /* synthetic */ void a(a aVar, int i2) {
        AppMethodBeat.i(28232);
        aVar.krF.setVisibility(i2);
        AppMethodBeat.o(28232);
    }

    static /* synthetic */ void d(a aVar) {
        AppMethodBeat.i(28234);
        Log.i("MicroMsg.ShakeCardDialog", "doNetSceneAccept()");
        if (TextUtils.isEmpty(aVar.DhN.pRX)) {
            Log.e("MicroMsg.ShakeCardDialog", "card_tp_id is empty befor doNetSceneAccept");
            AppMethodBeat.o(28234);
            return;
        }
        final ul ulVar = new ul();
        ulVar.eaN = null;
        ulVar.eaM.eaO = aVar.DhN.pRX;
        ulVar.eaM.eaP = aVar.DhN.eaP;
        ulVar.eaM.eaQ = 15;
        ulVar.callback = new Runnable() {
            /* class com.tencent.mm.plugin.shake.c.b.a.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(28219);
                Log.i("MicroMsg.ShakeCardDialog", "doNetSceneAccept callback");
                a.this.Dig = ulVar.eaN;
                if (a.this.Dig != null) {
                    a.a(a.this, 8);
                    if (a.this.Dig != null) {
                        a.this.pQH = a.this.Dig.eaO;
                    }
                    if (a.this.Dig == null || !a.this.Dig.isSuccess) {
                        a.this.Dih = EnumC1690a.ACCEPTED_FAIL;
                        a.h(a.this);
                        a.k(a.this);
                        AppMethodBeat.o(28219);
                        return;
                    }
                    a.this.Dih = EnumC1690a.ACCEPTED_SUCCES;
                    a.h(a.this);
                    a.i(a.this);
                    a.this.Did = true;
                    if (a.this.Dii != null) {
                        a.this.Dii.exp();
                        AppMethodBeat.o(28219);
                        return;
                    }
                } else {
                    Log.i("MicroMsg.ShakeCardDialog", "doNetSceneAccept callback, mCardAcceptResult == null");
                }
                AppMethodBeat.o(28219);
            }
        };
        EventCenter.instance.asyncPublish(ulVar, Looper.getMainLooper());
        AppMethodBeat.o(28234);
    }

    static /* synthetic */ void f(a aVar) {
        AppMethodBeat.i(28235);
        Log.i("MicroMsg.ShakeCardDialog", "goCardDetailUI ShakeCardDialog");
        com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(11665, aVar.pQH);
        com.tencent.mm.plugin.shake.c.c.a.H(aVar.getContext(), aVar.pQH, aVar.DhN.eaP);
        AppMethodBeat.o(28235);
    }

    static /* synthetic */ void i(a aVar) {
        AppMethodBeat.i(28237);
        aVar.eUy();
        if (aVar.Dih == EnumC1690a.ACCEPTED_SUCCES) {
            aVar.CuH.setText(R.string.gxl);
            if (aVar.Dif == 1) {
                aVar.Dic.setImageResource(R.raw.shake_success_icon);
                AppMethodBeat.o(28237);
                return;
            }
            aVar.Dic.setImageResource(R.raw.shake_success_icon_no_activity);
        }
        AppMethodBeat.o(28237);
    }
}
