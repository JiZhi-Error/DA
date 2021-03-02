package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.wallet.a.c;
import com.tencent.mm.plugin.wallet.a.d;
import com.tencent.mm.plugin.wallet.a.n;
import com.tencent.mm.plugin.wallet.a.o;
import com.tencent.mm.plugin.wallet.pay.ui.WalletChangeBankcardUI;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.ui.view.FavourLayout;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class k extends BaseAdapter {
    private Orders CwO = null;
    private com.tencent.mm.plugin.wallet_core.utils.a HCH;
    private int HGc;
    protected ArrayList<Bankcard> Hva;
    private int IfV = -1;
    public String IfW = "";
    public boolean IfX = true;
    private boolean IfY = false;
    private Context mContext;

    public /* synthetic */ Object getItem(int i2) {
        AppMethodBeat.i(70883);
        Bankcard aeu = aeu(i2);
        AppMethodBeat.o(70883);
        return aeu;
    }

    public k(Context context, ArrayList<Bankcard> arrayList, int i2, Orders orders) {
        AppMethodBeat.i(70876);
        this.mContext = context;
        this.Hva = arrayList;
        this.HGc = i2;
        this.CwO = orders;
        this.HCH = new com.tencent.mm.plugin.wallet_core.utils.a();
        this.HCH.b(this.mContext, this.Hva);
        if (orders != null && orders.HZl == 1) {
            this.IfY = true;
        }
        AppMethodBeat.o(70876);
    }

    public int getCount() {
        int i2 = 0;
        AppMethodBeat.i(70877);
        if (!this.IfY) {
            if (this.CwO == null || !this.CwO.HYY.equals("CFT")) {
                i2 = 1;
            }
            if (this.Hva != null) {
                int size = i2 + this.Hva.size();
                AppMethodBeat.o(70877);
                return size;
            }
            AppMethodBeat.o(70877);
            return i2;
        } else if (this.Hva == null) {
            AppMethodBeat.o(70877);
            return 0;
        } else {
            int size2 = this.Hva.size();
            AppMethodBeat.o(70877);
            return size2;
        }
    }

    public Bankcard aeu(int i2) {
        AppMethodBeat.i(70878);
        if (this.IfY) {
            Bankcard bankcard = this.Hva.get(i2);
            AppMethodBeat.o(70878);
            return bankcard;
        }
        int count = getCount();
        if (this.CwO == null || !this.CwO.HYY.equals("CFT")) {
            count--;
        }
        if (i2 < count) {
            Bankcard bankcard2 = this.Hva.get(i2);
            AppMethodBeat.o(70878);
            return bankcard2;
        }
        AppMethodBeat.o(70878);
        return null;
    }

    public long getItemId(int i2) {
        return (long) i2;
    }

    public boolean isEnabled(int i2) {
        AppMethodBeat.i(70879);
        Bankcard aeu = aeu(i2);
        if (aeu == null) {
            AppMethodBeat.o(70879);
            return true;
        } else if (aeu.a(this.HGc, this.CwO) != 0) {
            AppMethodBeat.o(70879);
            return false;
        } else {
            AppMethodBeat.o(70879);
            return true;
        }
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        LinkedList<String> linkedList;
        n nVar;
        AppMethodBeat.i(70880);
        if (view == null) {
            view = View.inflate(this.mContext, R.layout.c8i, null);
            aVar = new a();
            aVar.titleTv = (TextView) view.findViewById(R.id.ipm);
            aVar.BfZ = (TextView) view.findViewById(R.id.ied);
            aVar.Igb = (CheckedTextView) view.findViewById(R.id.azg);
            aVar.Igc = (CdnImageView) view.findViewById(R.id.a0k);
            aVar.Iga = (FavourLayout) view.findViewById(R.id.ce9);
            aVar.BfZ.setText("");
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.BfZ.setTextColor(MMApplicationContext.getResources().getColor(R.color.uj));
        aVar.Iga.setVisibility(8);
        Bankcard aeu = aeu(i2);
        if (aeu == null) {
            aVar.Igb.setVisibility(4);
            aVar.BfZ.setVisibility(8);
            aVar.titleTv.setText(R.string.imy);
            aVar.Igc.setVisibility(8);
            LinkedList<String> linkedList2 = new LinkedList<>();
            if (this.CwO == null || this.CwO.HZe == null || this.CwO.HZe.HEE == null || (nVar = this.CwO.HZe.HEE.HEa) == null) {
                linkedList = linkedList2;
            } else {
                Iterator<o> it = nVar.HEQ.iterator();
                while (it.hasNext()) {
                    linkedList2.add(it.next().Coh);
                }
                linkedList = linkedList2;
            }
            if (this.IfX && linkedList.size() > 0) {
                aVar.Iga.setVisibility(0);
                aVar.BfZ.setVisibility(8);
                aVar.Iga.setWording(linkedList);
            }
        } else {
            aVar.Igc.setVisibility(0);
            aVar.Igb.setVisibility(0);
            aVar.BfZ.setVisibility(0);
            aVar.BfZ.setText("");
            if (aeu.fQf()) {
                aVar.titleTv.setText(l.b(this.mContext, aeu.field_desc, aVar.titleTv.getTextSize()));
            } else {
                aVar.titleTv.setText(aeu.field_desc);
            }
            if (aeu.fQb()) {
                Bankcard bankcard = t.fQI().Hwc;
                if (!Util.isNullOrNil(bankcard.HVD)) {
                    aVar.titleTv.setText(bankcard.HVD);
                } else if (bankcard.HVC >= 0.0d) {
                    aVar.titleTv.setText(this.mContext.getString(ah.hhF(), f.D(bankcard.HVC)));
                } else {
                    aVar.titleTv.setText(this.mContext.getText(R.string.ids));
                }
            } else if (aeu.fQc()) {
                if (!Util.isNullOrNil(aeu.HVD)) {
                    aVar.titleTv.setText(aeu.HVD);
                } else if (aeu.HVC >= 0.0d) {
                    aVar.titleTv.setText(this.mContext.getString(R.string.ig2, f.D(aeu.HVC)));
                } else {
                    aVar.titleTv.setText(this.mContext.getText(R.string.ids));
                }
            }
            aVar.BfZ.setVisibility(0);
            switch (aeu.a(this.HGc, this.CwO)) {
                case 1:
                    aVar.BfZ.setText(R.string.in4);
                    break;
                case 2:
                    aVar.BfZ.setText(R.string.in_);
                    break;
                case 3:
                    aVar.BfZ.setText(R.string.ine);
                    break;
                case 4:
                    aVar.BfZ.setText(R.string.in6);
                    break;
                case 5:
                    aVar.BfZ.setText(R.string.in2);
                    break;
                case 6:
                    aVar.BfZ.setText(R.string.in8);
                    break;
                case 7:
                    aVar.BfZ.setText(R.string.inc);
                    break;
                case 8:
                    aVar.BfZ.setText(aeu.field_forbidWord);
                    break;
                default:
                    if (Util.isNullOrNil(aeu.field_tips)) {
                        aVar.BfZ.setVisibility(8);
                        break;
                    } else {
                        aVar.BfZ.setText(aeu.field_tips);
                        break;
                    }
            }
            String charSequence = aVar.BfZ.getText().toString();
            aVar.titleTv.setTextColor(this.mContext.getResources().getColor(R.color.a2x));
            if (this.IfW.equalsIgnoreCase(aeu.field_bindSerial)) {
                aVar.Igb.setChecked(true);
                aVar.Igb.setEnabled(true);
            } else if (isEnabled(i2)) {
                aVar.Igb.setChecked(false);
                aVar.Igb.setEnabled(true);
            } else {
                aVar.Igb.setEnabled(false);
                aVar.Igb.setChecked(false);
                aVar.titleTv.setTextColor(this.mContext.getResources().getColor(R.color.uj));
            }
            aVar.Igc.setTag(R.id.jf6, null);
            aVar.Igc.setTag(null);
            aVar.Igc.setImageDrawable(null);
            aVar.BfZ.setOnClickListener(null);
            if (aeu.fQb()) {
                com.tencent.mm.plugin.wallet_core.utils.a.m(aVar.Igc);
            } else if (aeu.fQc()) {
                this.HCH.a(aeu, aVar.Igc);
            } else if (aeu.fQf()) {
                aVar.Igc.setImageDrawable(com.tencent.mm.svg.a.a.h(MMApplicationContext.getResources(), R.raw.honey_pay_bank_logo));
                if (!Util.isNullOrNil(aeu.HVU)) {
                    aVar.Igc.setUseSdcardCache(true);
                    aVar.Igc.setImgSavedPath(b.fSn());
                    aVar.Igc.gI(aeu.HVU, R.raw.honey_pay_bank_logo);
                }
            } else {
                this.HCH.a(this.mContext, aeu, aVar.Igc);
            }
            if (!Util.isNullOrNil(aeu.field_forbid_title) && !Util.isNullOrNil(aeu.field_forbid_url)) {
                String str = charSequence + "  ";
                SpannableString spannableString = new SpannableString(str + aeu.field_forbid_title);
                aVar.BfZ.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet_core.ui.k.AnonymousClass1 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(70875);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletChangeBankcardAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        if (view.getTag() instanceof String) {
                            Intent intent = new Intent();
                            String str = (String) view.getTag();
                            Log.i("MicroMsg.WalletChangeBankcardAdapter", "go to url %s", str);
                            intent.putExtra("rawUrl", str);
                            intent.putExtra("geta8key_username", z.aTY());
                            intent.putExtra("pay_channel", 1);
                            f.b(k.this.mContext, intent, WalletChangeBankcardUI.HFZ);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletChangeBankcardAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(70875);
                    }
                });
                spannableString.setSpan(new ForegroundColorSpan(MMApplicationContext.getResources().getColor(R.color.adz)), str.length(), str.length() + aeu.field_forbid_title.length(), 34);
                aVar.BfZ.setText(spannableString);
                aVar.BfZ.setTag(aeu.field_forbid_url);
            } else if (this.IfX && Util.isNullOrNil(aeu.field_forbidWord) && Util.isNullOrNil(charSequence)) {
                LinkedList<String> h2 = h(aeu);
                if (h2.size() > 0) {
                    aVar.Iga.setVisibility(0);
                    aVar.BfZ.setVisibility(8);
                    aVar.Iga.setWording(h2);
                }
            }
        }
        AppMethodBeat.o(70880);
        return view;
    }

    private LinkedList<String> h(Bankcard bankcard) {
        AppMethodBeat.i(70881);
        LinkedList<String> linkedList = new LinkedList<>();
        if (!(this.CwO == null || this.CwO.HZe == null || this.CwO.HZe.HEE == null)) {
            Iterator<c> it = this.CwO.HZe.HEE.HDZ.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.ANo.equals(bankcard.field_bindSerial)) {
                    Iterator<d> it2 = next.HEk.iterator();
                    while (it2.hasNext()) {
                        linkedList.add(it2.next().Coh);
                    }
                    AppMethodBeat.o(70881);
                    return linkedList;
                }
            }
        }
        AppMethodBeat.o(70881);
        return linkedList;
    }

    public final void h(ArrayList<Bankcard> arrayList, boolean z) {
        AppMethodBeat.i(70882);
        if (arrayList == null) {
            this.Hva = new ArrayList<>();
        } else {
            this.Hva = arrayList;
        }
        this.IfX = z;
        if (this.Hva.size() > 0) {
            this.HCH.b(this.mContext, this.Hva);
        }
        notifyDataSetChanged();
        AppMethodBeat.o(70882);
    }

    class a {
        public TextView BfZ;
        public FavourLayout Iga;
        public CheckedTextView Igb;
        public CdnImageView Igc;
        public TextView titleTv;

        a() {
        }
    }
}
