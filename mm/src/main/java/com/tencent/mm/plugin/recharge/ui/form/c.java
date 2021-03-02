package com.tencent.mm.plugin.recharge.ui.form;

import android.content.Context;
import android.telephony.PhoneNumberUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class c {
    private static String TAG = "MicroMsg.CommonHintViewConfig";

    static class a implements b {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        @Override // com.tencent.mm.plugin.recharge.ui.form.b
        public boolean a(MallFormView mallFormView) {
            return true;
        }

        @Override // com.tencent.mm.plugin.recharge.ui.form.b
        public boolean eIg() {
            return false;
        }

        @Override // com.tencent.mm.plugin.recharge.ui.form.b
        public String aKW(String str) {
            return null;
        }
    }

    public static void b(MallFormView mallFormView) {
        AppMethodBeat.i(67284);
        if (mallFormView == null) {
            Log.e(TAG, "hy: param error");
            AppMethodBeat.o(67284);
            return;
        }
        mallFormView.setLogicDelegate(new a() {
            /* class com.tencent.mm.plugin.recharge.ui.form.c.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.recharge.ui.form.b, com.tencent.mm.plugin.recharge.ui.form.c.a
            public final boolean a(MallFormView mallFormView) {
                AppMethodBeat.i(67275);
                boolean isGlobalPhoneNumber = PhoneNumberUtils.isGlobalPhoneNumber(com.tencent.mm.plugin.recharge.model.b.Ts(mallFormView.getText().toString()));
                AppMethodBeat.o(67275);
                return isGlobalPhoneNumber;
            }

            @Override // com.tencent.mm.plugin.recharge.ui.form.b, com.tencent.mm.plugin.recharge.ui.form.c.a
            public final boolean eIg() {
                return true;
            }

            @Override // com.tencent.mm.plugin.recharge.ui.form.b, com.tencent.mm.plugin.recharge.ui.form.c.a
            public final String aKW(String str) {
                AppMethodBeat.i(67276);
                if (str == null) {
                    AppMethodBeat.o(67276);
                    return "";
                }
                String replaceAll = str.replaceAll(" ", "");
                AppMethodBeat.o(67276);
                return replaceAll;
            }
        });
        AppMethodBeat.o(67284);
    }

    public static class b {
        public List<String[]> BDG;
        public com.tencent.mm.plugin.recharge.model.a BDH = null;
        public MallFormView BFp = null;
        public d BFq;
        boolean BFr = false;

        public b(MallFormView mallFormView) {
            this.BFp = mallFormView;
        }

        public final void setInput(com.tencent.mm.plugin.recharge.model.a aVar) {
            AppMethodBeat.i(67282);
            this.BDH = aVar;
            if (aVar != null) {
                if (Util.isNullOrNil(this.BFp.getText()) || !this.BFp.getText().equals(aVar.BCX)) {
                    this.BFp.getContentEditText().setText(com.tencent.mm.plugin.recharge.model.b.aKR(aVar.BCX));
                }
                this.BFp.getContentEditText().setSelection(this.BFp.getContentEditText().getText().length());
                Log.d(c.TAG, "editTv.setText %s, name: %s, location: %s, type: %s", aVar.BCX, aVar.name, aVar.ljO, Integer.valueOf(aVar.sourceType));
                Context context = this.BFp.getContext();
                if (this.BDH.sourceType == 3) {
                    this.BFp.getTipsTv().setText(this.BDH.name);
                    this.BFp.getTipsTv().setTextColor(context.getResources().getColor(R.color.a54));
                    AppMethodBeat.o(67282);
                } else if (this.BDH.sourceType == 1) {
                    if (!Util.isNullOrNil(this.BDH.name)) {
                        String str = this.BDH.name;
                        if (!Util.isNullOrNil(this.BDH.ljO)) {
                            str = str + context.getString(R.string.iq6, this.BDH.ljO);
                        }
                        this.BFp.getTipsTv().setText(str);
                        this.BFp.getTipsTv().setTextColor(context.getResources().getColor(R.color.a2x));
                        AppMethodBeat.o(67282);
                        return;
                    }
                    String string = context.getString(R.string.iqf);
                    if (!Util.isNullOrNil(this.BDH.ljO)) {
                        string = string + context.getString(R.string.iq6, this.BDH.ljO);
                    }
                    this.BFp.getTipsTv().setText(string);
                    this.BFp.getTipsTv().setTextColor(context.getResources().getColor(R.color.a4w));
                    AppMethodBeat.o(67282);
                } else if (this.BDH.sourceType != 2) {
                    if (this.BDH.sourceType == 0) {
                        if (!Util.isNullOrNil(this.BDH.ljO)) {
                            if (!Util.isNullOrNil(this.BDH.name)) {
                                this.BFp.getTipsTv().setText(this.BDH.name + context.getString(R.string.iq6, this.BDH.ljO));
                                this.BFp.getTipsTv().setTextColor(context.getResources().getColor(R.color.a4w));
                                AppMethodBeat.o(67282);
                                return;
                            }
                            this.BFp.getTipsTv().setText(this.BDH.ljO);
                            this.BFp.getTipsTv().setTextColor(context.getResources().getColor(R.color.a2x));
                            AppMethodBeat.o(67282);
                            return;
                        } else if (!Util.isNullOrNil(this.BDH.name)) {
                            this.BFp.getTipsTv().setText(this.BDH.name);
                            this.BFp.getTipsTv().setTextColor(context.getResources().getColor(R.color.a4w));
                            AppMethodBeat.o(67282);
                            return;
                        } else {
                            this.BFp.getTipsTv().setText("");
                            this.BFp.getTipsTv().setTextColor(context.getResources().getColor(R.color.a2x));
                        }
                    }
                    AppMethodBeat.o(67282);
                } else if (!Util.isNullOrNil(this.BDH.ljO)) {
                    this.BFp.getTipsTv().setText(this.BDH.ljO);
                    this.BFp.getTipsTv().setTextColor(context.getResources().getColor(R.color.a2x));
                    AppMethodBeat.o(67282);
                } else {
                    this.BFp.getTipsTv().setText("");
                    this.BFp.getTipsTv().setTextColor(context.getResources().getColor(R.color.a4w));
                    AppMethodBeat.o(67282);
                }
            } else {
                this.BFp.getContentEditText().setText("");
                Log.d(c.TAG, "editTv.setText null");
                this.BFp.getTipsTv().setText("");
                AppMethodBeat.o(67282);
            }
        }

        public final void sY(boolean z) {
            List<com.tencent.mm.plugin.recharge.model.a> list;
            AppMethodBeat.i(67283);
            Log.d(c.TAG, "needSetInput: %s", Boolean.valueOf(z));
            List<com.tencent.mm.plugin.recharge.model.a> eHM = com.tencent.mm.plugin.recharge.a.a.eHL().eHM();
            if (eHM == null || eHM.isEmpty()) {
                list = new ArrayList<>();
                com.tencent.mm.plugin.recharge.model.a eHN = com.tencent.mm.plugin.recharge.a.a.eHN();
                if (eHN != null) {
                    list.add(eHN);
                    com.tencent.mm.plugin.recharge.a.a.eHL().a(eHN);
                }
            } else {
                String str = (String) g.aAh().azQ().get(6, (Object) null);
                for (int i2 = 0; i2 < eHM.size(); i2++) {
                    com.tencent.mm.plugin.recharge.model.a aVar = eHM.get(i2);
                    if (Util.isNullOrNil(aVar.BCX) || !aVar.BCX.equals(str)) {
                        if (!Util.isNullOrNil(aVar.BCX) && Util.isNullOrNil(aVar.name) && this.BDG != null) {
                            Iterator<String[]> it = this.BDG.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                String[] next = it.next();
                                if (aVar.BCX.equals(com.tencent.mm.plugin.recharge.model.b.Ts(next[2]))) {
                                    aVar.name = next[1];
                                    Log.i(c.TAG, "add name: %s", next[1]);
                                    break;
                                }
                            }
                        }
                    } else if (Util.isNullOrNil(aVar.name) || !aVar.name.equals(this.BFp.getContext().getString(R.string.iqd))) {
                        aVar.name = this.BFp.getContext().getString(R.string.iqd);
                    }
                    com.tencent.mm.plugin.recharge.a.a.eHL().ga(eHM);
                }
                list = eHM;
            }
            this.BFq.ga(list);
            if (list != null && list.size() > 0 && z) {
                this.BDH = list.get(0);
                setInput(this.BDH);
            }
            AppMethodBeat.o(67283);
        }
    }
}
