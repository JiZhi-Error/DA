package com.tencent.mm.plugin.card.ui.view;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.c;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.n;
import com.tencent.mm.plugin.card.d.q;
import com.tencent.mm.plugin.card.ui.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public abstract class g extends i {
    String code;
    private Bitmap kuJ;
    protected b pQV;
    MMActivity pQZ;
    private View.OnLongClickListener pWD = new View.OnLongClickListener() {
        /* class com.tencent.mm.plugin.card.ui.view.g.AnonymousClass1 */

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(113671);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/card/ui/view/CardBaseCodeView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            if (view.getId() == R.id.b5f) {
                q.TF(g.this.pQV.csR().code);
                h.cD(g.this.pQZ, g.this.getString(R.string.ta));
            }
            a.a(false, (Object) this, "com/tencent/mm/plugin/card/ui/view/CardBaseCodeView$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(113671);
            return false;
        }
    };
    private Bitmap pWu;
    private j pZL;
    private ViewGroup qjQ;
    private ab qjR;
    private ViewStub qjS;

    public abstract ab cxB();

    public abstract ab cxC();

    public abstract ab cxD();

    public abstract String e(c cVar);

    public abstract boolean f(b bVar);

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void initView() {
        this.pQZ = this.qjX.cvt();
        this.pZL = this.qjX.cvz();
        this.pQV = this.qjX.cvq();
        if (this.pQV == null) {
            Log.e("MicroMsg.CardBaseCodeView", "initView failure! cardInfo is null!");
            return;
        }
        switch (this.pQV.csR().Lcr) {
            case 0:
                this.qjR = cxD();
                break;
            case 1:
                this.qjR = cxC();
                break;
            case 2:
                this.qjR = cxB();
                break;
            default:
                this.qjR = cxB();
                break;
        }
        if (this.qjR == null) {
            Log.e("MicroMsg.CardBaseCodeView", "iniView failure! codeContainer is null!");
            return;
        }
        switch (this.pQV.csR().Lcr) {
            case 0:
                if (this.qjS == null) {
                    this.qjS = (ViewStub) findViewById(R.id.alg);
                    break;
                }
                break;
            case 1:
                if (this.qjS == null) {
                    this.qjS = (ViewStub) findViewById(R.id.akl);
                    break;
                }
                break;
            case 2:
                if (this.qjS == null) {
                    this.qjS = (ViewStub) findViewById(R.id.aop);
                    break;
                }
                break;
            default:
                if (this.qjS == null) {
                    this.qjS = (ViewStub) findViewById(R.id.aop);
                    break;
                }
                break;
        }
        if (this.qjS == null) {
            Log.e("MicroMsg.CardBaseCodeView", "initTargetView failure! viewStub is null!");
        } else if (this.qjR == null) {
            Log.e("MicroMsg.CardBaseCodeView", "iniView failure! codeContainer is null!");
        } else if (this.qjR.getLayoutId() == 0) {
            Log.e("MicroMsg.CardBaseCodeView", "initTargetView failure! codeContainer.getLayoutId()  is 0!");
        } else {
            this.qjS.setLayoutResource(this.qjR.getLayoutId());
            if (this.qjQ == null) {
                this.qjQ = (ViewGroup) this.qjS.inflate();
            }
        }
        if (this.qjQ == null) {
            Log.e("MicroMsg.CardBaseCodeView", "iniView failure! targetView is null!");
        }
    }

    public final void b(b bVar) {
        if (bVar == null) {
            Log.e("MicroMsg.CardBaseCodeView", "updateCardInfo failure! mCardInfo is null!");
        } else {
            this.pQV = bVar;
        }
    }

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void destroy() {
        super.destroy();
        this.pQZ = null;
        this.pZL = null;
        this.pQV = null;
        this.qjQ = null;
        this.qjR = null;
        l.Z(this.kuJ);
        l.Z(this.pWu);
    }

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void update() {
        if (this.pQV == null) {
            Log.e("MicroMsg.CardBaseCodeView", "update  failure! mCardInfo is null!");
        } else if (this.qjR == null) {
            Log.e("MicroMsg.CardBaseCodeView", "update failure! codeContainer is null!");
        } else if (this.qjQ == null) {
            Log.e("MicroMsg.CardBaseCodeView", "update failure! targetView is null!");
        } else {
            this.pZL.cwi();
            d(c.CARDCODEREFRESHACTION_ENTERCHANGE);
            this.qjR.c(this.qjQ, this.pQV);
        }
    }

    public final void d(c cVar) {
        if (this.pQV == null) {
            Log.e("MicroMsg.CardBaseCodeView", "updateCodeView getCode mCardInfo  is null ! cannot show code view");
        } else if (cVar == null) {
            Log.e("MicroMsg.CardBaseCodeView", "updateCodeView failure!refreshReason is null!");
        } else if (!this.qjR.g(this.pQV)) {
            Log.e("MicroMsg.CardBaseCodeView", "updateCodeView failure! can not get qrcode! refreshReason = %s", Integer.valueOf(cVar.action));
            cxz();
        } else {
            this.qjR.n(this.qjQ);
            Log.i("MicroMsg.CardBaseCodeView", "updateCodeView from refreshReason = %s", Integer.valueOf(cVar.action));
            this.code = e(cVar);
            if (Util.isNullOrNil(this.code)) {
                Log.e("MicroMsg.CardBaseCodeView", "updateCodeView getCode is empty! cannot show code view");
                return;
            }
            switch (this.pQV.csR().Lcr) {
                case 0:
                    e(this.qjQ, this.code);
                    return;
                case 1:
                    d(this.qjQ, this.code);
                    return;
                case 2:
                    c(this.qjQ, this.code);
                    return;
                default:
                    return;
            }
        }
    }

    public final void cxz() {
        if (this.qjR != null && this.pQV != null && this.qjQ != null) {
            this.qjR.a(this.qjQ, this.pQV);
        }
    }

    public final void cmW() {
        if (this.pQV == null || this.qjR == null || this.qjQ == null) {
            Log.e("MicroMsg.CardBaseCodeView", "onScreenShot is error! mCardInfo or codeContainer or targetView is null ");
            return;
        }
        this.qjR.b(this.qjQ, this.pQV);
        if (this.pQV.csR().Lcr == 2 && this.pZL != null) {
            j jVar = this.pZL;
            if (jVar.kuK != null && jVar.kuK.isShowing()) {
                jVar.kuK.dismiss();
            }
        }
    }

    @Override // com.tencent.mm.plugin.card.ui.view.i
    public final void cxw() {
        cxA();
    }

    public final void cxA() {
        if (this.qjQ != null) {
            this.qjQ.setVisibility(8);
        }
    }

    private void c(View view, String str) {
        try {
            ImageView imageView = (ImageView) view.findViewById(R.id.b58);
            l.Z(this.kuJ);
            int i2 = 1;
            if (!(this.pQV == null || this.pQV.csQ() == null)) {
                i2 = this.pQV.csQ().Lfh;
            }
            this.kuJ = com.tencent.mm.by.a.a.b(this.pQZ, str, 12, i2);
            a(imageView, this.kuJ);
            imageView.setOnClickListener(this.qjX.cvu());
            this.pZL.kuJ = this.kuJ;
            this.pZL.cwk();
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.CardBaseCodeView", e2, "", new Object[0]);
        }
    }

    private void d(View view, String str) {
        try {
            ImageView imageView = (ImageView) view.findViewById(R.id.b4s);
            l.Z(this.pWu);
            if (str != null && str.length() > 0) {
                this.pWu = com.tencent.mm.by.a.a.b(this.pQZ, str, 5, 0);
            }
            a(imageView, this.pWu);
            imageView.setOnClickListener(this.qjX.cvu());
            this.pZL.pWu = this.pWu;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.CardBaseCodeView", e2, "", new Object[0]);
        }
    }

    private void e(View view, String str) {
        TextView textView = (TextView) view.findViewById(R.id.b5f);
        textView.setText(n.akl(str));
        textView.setOnLongClickListener(this.pWD);
        String str2 = this.pQV.csQ().ixw;
        if (!Util.isNullOrNil(str2)) {
            textView.setTextColor(l.ake(str2));
        }
        if (str.length() <= 12) {
            textView.setTextSize(1, 33.0f);
        } else if (str.length() > 12 && str.length() <= 16) {
            textView.setTextSize(1, 30.0f);
        } else if (str.length() > 16 && str.length() <= 20) {
            textView.setTextSize(1, 24.0f);
        } else if (str.length() > 20 && str.length() <= 40) {
            textView.setTextSize(1, 18.0f);
        } else if (str.length() > 40) {
            textView.setVisibility(8);
        }
    }

    private static void a(ImageView imageView, Bitmap bitmap) {
        if (imageView != null && bitmap != null) {
            imageView.setImageBitmap(bitmap);
        }
    }
}
