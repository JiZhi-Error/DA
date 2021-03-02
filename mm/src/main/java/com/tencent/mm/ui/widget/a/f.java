package com.tencent.mm.ui.widget.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.AlertActivity;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.widget.a.d;
import java.util.ArrayList;

public final class f {

    public interface b {
        void D(boolean z, boolean z2);
    }

    public interface c {
        void e(boolean z, String str);
    }

    public static class a {
        public boolean JnN = false;
        public final d.a Kfg;
        private String QOJ = null;
        private String QOK = null;
        private boolean QOL = false;
        private RadioGroup QOM;
        public d kdo;
        Context mContext;

        public a(Context context) {
            AppMethodBeat.i(159373);
            this.mContext = context;
            this.Kfg = new d.a(this.mContext);
            this.Kfg.Dk(false);
            this.Kfg.Dl(false);
            this.Kfg.a(new d.a.AbstractC2137d() {
                /* class com.tencent.mm.ui.widget.a.f.a.AnonymousClass1 */

                @Override // com.tencent.mm.ui.widget.a.d.a.AbstractC2137d
                public final CharSequence a(CharSequence charSequence, float f2) {
                    AppMethodBeat.i(159368);
                    CharSequence c2 = com.tencent.mm.ui.g.c.b.c(a.this.mContext, charSequence, f2);
                    AppMethodBeat.o(159368);
                    return c2;
                }
            });
            this.QOK = this.mContext.getResources().getString(R.string.amc);
            this.QOJ = this.mContext.getResources().getString(R.string.ame);
            AppMethodBeat.o(159373);
        }

        public final a Dq(boolean z) {
            AppMethodBeat.i(159374);
            this.Kfg.Dk(z);
            this.Kfg.Dl(z);
            AppMethodBeat.o(159374);
            return this;
        }

        public final a aC(CharSequence charSequence) {
            AppMethodBeat.i(159375);
            int fromDPToPix = at.fromDPToPix(this.mContext, (int) (20.0f * at.ez(this.mContext)));
            if (charSequence != null && charSequence.length() > 0) {
                this.Kfg.az(com.tencent.mm.ui.g.c.b.a(this.mContext, charSequence.toString(), fromDPToPix));
            }
            this.Kfg.az(charSequence);
            AppMethodBeat.o(159375);
            return this;
        }

        public final a bow(String str) {
            AppMethodBeat.i(159376);
            this.Kfg.boo(str);
            AppMethodBeat.o(159376);
            return this;
        }

        public final a aD(CharSequence charSequence) {
            AppMethodBeat.i(159377);
            int fromDPToPix = at.fromDPToPix(this.mContext, (int) (14.0f * at.ez(this.mContext)));
            if (charSequence != null && charSequence.length() > 0) {
                this.Kfg.aB(com.tencent.mm.ui.g.c.b.a(this.mContext, charSequence.toString(), fromDPToPix));
            }
            this.Kfg.aB(charSequence);
            AppMethodBeat.o(159377);
            return this;
        }

        public final a box(String str) {
            AppMethodBeat.i(159378);
            this.Kfg.boq(str);
            AppMethodBeat.o(159378);
            return this;
        }

        public final a hu(View view) {
            AppMethodBeat.i(159379);
            this.Kfg.hs(view);
            AppMethodBeat.o(159379);
            return this;
        }

        public final a u(Boolean bool) {
            AppMethodBeat.i(159380);
            this.Kfg.Dj(bool.booleanValue());
            AppMethodBeat.o(159380);
            return this;
        }

        public final a boy(String str) {
            AppMethodBeat.i(159381);
            this.Kfg.bos(str);
            AppMethodBeat.o(159381);
            return this;
        }

        public final a boz(String str) {
            AppMethodBeat.i(159382);
            this.Kfg.bot(str);
            AppMethodBeat.o(159382);
            return this;
        }

        public final a apa(int i2) {
            AppMethodBeat.i(159383);
            this.QOJ = this.mContext.getResources().getString(i2);
            this.Kfg.bou(this.QOJ);
            AppMethodBeat.o(159383);
            return this;
        }

        public final a boA(String str) {
            AppMethodBeat.i(198247);
            this.QOJ = str;
            this.Kfg.bou(this.QOJ);
            AppMethodBeat.o(198247);
            return this;
        }

        public final a boB(String str) {
            AppMethodBeat.i(198248);
            this.QOK = str;
            this.Kfg.bov(this.QOK);
            AppMethodBeat.o(198248);
            return this;
        }

        public final a hbu() {
            this.JnN = true;
            return this;
        }

        public final a apb(int i2) {
            AppMethodBeat.i(159384);
            this.Kfg.aoX(i2);
            AppMethodBeat.o(159384);
            return this;
        }

        public final a apc(int i2) {
            AppMethodBeat.i(198249);
            this.Kfg.aoY(i2);
            AppMethodBeat.o(198249);
            return this;
        }

        public final a a(ArrayList<String> arrayList, RadioGroup.OnCheckedChangeListener onCheckedChangeListener, int i2) {
            AppMethodBeat.i(175622);
            View inflate = View.inflate(this.mContext, R.layout.zw, null);
            this.QOM = (RadioGroup) inflate.findViewById(R.id.gqx);
            int size = arrayList != null ? arrayList.size() : 0;
            for (int i3 = 0; i3 < size; i3++) {
                RadioButton radioButton = (RadioButton) View.inflate(this.mContext, R.layout.zv, null);
                radioButton.setId(i3);
                if (i3 == i2) {
                    radioButton.setChecked(true);
                }
                radioButton.setText(arrayList.get(i3));
                this.QOM.addView(radioButton);
            }
            this.QOM.setOnCheckedChangeListener(onCheckedChangeListener);
            this.Kfg.hs(inflate);
            AppMethodBeat.o(175622);
            return this;
        }

        public final d hbv() {
            return this.kdo;
        }

        public final a a(c cVar, c cVar2) {
            AppMethodBeat.i(159385);
            if (this.QOM != null) {
                this.QOM.setTag(this.kdo);
            }
            a(cVar);
            b(cVar2);
            if (this.QOL) {
                this.Kfg.aoY(this.mContext.getResources().getColor(R.color.g7));
            }
            AppMethodBeat.o(159385);
            return this;
        }

        public final a a(final c cVar) {
            AppMethodBeat.i(159386);
            if (this.QOK == null || (this.QOK != null && this.QOK.length() == 0)) {
                this.QOK = this.mContext.getResources().getString(R.string.amc);
            }
            this.Kfg.bov(this.QOK);
            if (!this.JnN) {
                this.Kfg.d(new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.ui.widget.a.f.a.AnonymousClass2 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(159369);
                        if (cVar != null) {
                            cVar.e(false, null);
                        }
                        AppMethodBeat.o(159369);
                    }
                });
            }
            AppMethodBeat.o(159386);
            return this;
        }

        public final a b(final c cVar) {
            AppMethodBeat.i(159387);
            if (this.QOJ == null || (this.QOJ != null && this.QOJ.length() == 0)) {
                this.QOJ = this.mContext.getResources().getString(R.string.ame);
            }
            this.Kfg.bou(this.QOJ);
            this.Kfg.c(new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.widget.a.f.a.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(159370);
                    if (cVar != null) {
                        cVar.e(true, dialogInterface == null ? null : ((d) dialogInterface).hbk());
                    }
                    AppMethodBeat.o(159370);
                }
            });
            AppMethodBeat.o(159387);
            return this;
        }

        public final a c(c cVar) {
            AppMethodBeat.i(159388);
            if (this.QOM != null) {
                this.QOM.setTag(this.kdo);
            }
            b(cVar);
            a(cVar);
            AppMethodBeat.o(159388);
            return this;
        }

        public final a a(final b bVar) {
            AppMethodBeat.i(159389);
            if (this.QOM != null) {
                this.QOM.setTag(this.kdo);
            }
            if (this.QOJ == null || (this.QOJ != null && this.QOJ.length() == 0)) {
                this.QOJ = this.mContext.getResources().getString(R.string.ame);
            }
            this.Kfg.bou(this.QOJ);
            this.Kfg.c(new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.widget.a.f.a.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(159371);
                    if (bVar != null) {
                        if (dialogInterface != null) {
                            ((d) dialogInterface).hbk();
                        }
                        bVar.D(true, dialogInterface == null ? false : ((d) dialogInterface).afU.isChecked());
                    }
                    AppMethodBeat.o(159371);
                }
            });
            if (this.QOK == null || (this.QOK != null && this.QOK.length() == 0)) {
                this.QOK = this.mContext.getResources().getString(R.string.amc);
            }
            this.Kfg.bov(this.QOK);
            if (!this.JnN) {
                this.Kfg.d(new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.ui.widget.a.f.a.AnonymousClass5 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(159372);
                        if (bVar != null) {
                            bVar.D(false, dialogInterface == null ? false : ((d) dialogInterface).afU.isChecked());
                        }
                        AppMethodBeat.o(159372);
                    }
                });
            }
            AppMethodBeat.o(159389);
            return this;
        }

        public final a b(DialogInterface.OnDismissListener onDismissListener) {
            AppMethodBeat.i(159390);
            this.Kfg.a(onDismissListener);
            AppMethodBeat.o(159390);
            return this;
        }

        public final void show() {
            AppMethodBeat.i(159391);
            if (this.mContext instanceof Activity) {
                if (this.kdo == null) {
                    this.kdo = this.Kfg.hbn();
                }
                this.kdo.show();
                AppMethodBeat.o(159391);
                return;
            }
            AlertActivity.a(this.Kfg);
            Intent intent = new Intent(this.mContext, AlertActivity.class);
            intent.setFlags(335544320);
            Context context = this.mContext;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/widget/dialog/MMConfirmDialog$Builder", "show", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/widget/dialog/MMConfirmDialog$Builder", "show", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(159391);
        }
    }
}
