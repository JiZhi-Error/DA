package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.lj;
import com.tencent.mm.g.a.zl;
import com.tencent.mm.g.a.zn;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ac;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ad;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ae;
import com.tencent.mm.plugin.wallet.balance.model.lqt.af;
import com.tencent.mm.plugin.wallet.balance.model.lqt.t;
import com.tencent.mm.plugin.wallet.balance.model.lqt.u;
import com.tencent.mm.plugin.wallet.balance.model.lqt.x;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtArriveTimeLayout;
import com.tencent.mm.plugin.wallet.balance.ui.lqt.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wallet_core.ui.view.c;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.acl;
import com.tencent.mm.protocal.protobuf.ahq;
import com.tencent.mm.protocal.protobuf.amh;
import com.tencent.mm.protocal.protobuf.cki;
import com.tencent.mm.protocal.protobuf.cux;
import com.tencent.mm.protocal.protobuf.ddd;
import com.tencent.mm.protocal.protobuf.dhj;
import com.tencent.mm.protocal.protobuf.dlv;
import com.tencent.mm.protocal.protobuf.dys;
import com.tencent.mm.protocal.protobuf.ja;
import com.tencent.mm.protocal.protobuf.jf;
import com.tencent.mm.protocal.protobuf.sf;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.g;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.XWalkEnvironment;

public class WalletLqtSaveFetchUI extends WalletLqtBasePresenterUI implements WcPayKeyboard.a {
    private IListener<lj> AJa = new IListener<lj>() {
        /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass36 */

        {
            AppMethodBeat.i(214010);
            this.__eventId = lj.class.getName().hashCode();
            AppMethodBeat.o(214010);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(lj ljVar) {
            AppMethodBeat.i(214011);
            lj ljVar2 = ljVar;
            Log.i("MicroMsg.WalletLqtSaveFetchUI", "KindaBindCardEvent callback");
            if (ljVar2 == null || !(ljVar2 instanceof lj)) {
                AppMethodBeat.o(214011);
                return false;
            }
            z.hhs();
            if (ljVar2.dQz != null) {
                if (ljVar2.dQz.dQA) {
                    Log.i("MicroMsg.WalletLqtSaveFetchUI", "KindaBindCardEvent bindCard Succ");
                    final List r = WalletLqtSaveFetchUI.r(WalletLqtSaveFetchUI.this);
                    WalletLqtSaveFetchUI.this.HAN.HuP.jQ(WalletLqtSaveFetchUI.this.mode, WalletLqtSaveFetchUI.this.accountType).f(new a<Void, Void>() {
                        /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass36.AnonymousClass1 */

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // com.tencent.mm.vending.c.a
                        public final /* synthetic */ Void call(Void r8) {
                            boolean z;
                            AppMethodBeat.i(214009);
                            Iterator it = WalletLqtSaveFetchUI.r(WalletLqtSaveFetchUI.this).iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                Bankcard bankcard = (Bankcard) it.next();
                                Iterator it2 = r.iterator();
                                while (true) {
                                    if (it2.hasNext()) {
                                        if (bankcard.field_bindSerial.equals(((Bankcard) it2.next()).field_bindSerial)) {
                                            z = true;
                                            continue;
                                            break;
                                        }
                                    } else {
                                        z = false;
                                        continue;
                                        break;
                                    }
                                }
                                if (!z) {
                                    WalletLqtSaveFetchUI.this.HBx = bankcard.field_bindSerial;
                                    break;
                                }
                            }
                            WalletLqtSaveFetchUI.o(WalletLqtSaveFetchUI.this);
                            Void r0 = QZL;
                            AppMethodBeat.o(214009);
                            return r0;
                        }
                    });
                } else {
                    Log.i("MicroMsg.WalletLqtSaveFetchUI", "KindaBindCardEvent bindCard Cancel");
                }
            }
            EventCenter.instance.removeListener(WalletLqtSaveFetchUI.this.AJa);
            AppMethodBeat.o(214011);
            return true;
        }
    };
    public ae HAM = new ae(this.Hux, this.Huy, this);
    private af HAN = new af(this.HAM);
    private ViewGroup HAO;
    private WalletFormView HAP;
    private TextView HAQ;
    private TextView HAR;
    private TextView HAS;
    private ImageView HAT;
    private TextView HAU;
    private TextView HAV;
    private ViewGroup HAW;
    private TextView HAX;
    private CheckBox HAY;
    private TextView HAZ;
    private List<Bankcard> HBA;
    private boolean HBB = true;
    private boolean HBC = false;
    private boolean HBD = false;
    private String HBE = "";
    private boolean HBF = false;
    private String HBG = "";
    private u.a HBH = new u.a() {
        /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass23 */

        @Override // com.tencent.mm.plugin.wallet.balance.model.lqt.u.a
        public final void xK(boolean z) {
            AppMethodBeat.i(213995);
            Log.i("MicroMsg.WalletLqtSaveFetchUI", "cache updated show Error:".concat(String.valueOf(z)));
            if (!WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, z)) {
                AppMethodBeat.o(213995);
                return;
            }
            WalletLqtSaveFetchUI.this.hideLoading();
            WalletLqtSaveFetchUI.this.fNR();
            WalletLqtSaveFetchUI.g(WalletLqtSaveFetchUI.this);
            if (WalletLqtSaveFetchUI.this.mode == 1) {
                WalletLqtSaveFetchUI.this.HBl.post(new Runnable() {
                    /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass23.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(69001);
                        WalletLqtSaveFetchUI.this.HBl.setMinimumHeight(WalletLqtSaveFetchUI.this.HBl.getHeight());
                        AppMethodBeat.o(69001);
                    }
                });
                AppMethodBeat.o(213995);
                return;
            }
            if (WalletLqtSaveFetchUI.this.mode == 2) {
                String text = WalletLqtSaveFetchUI.this.HAP.getText();
                if (!Util.isNullOrNil(text)) {
                    WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, text);
                }
            }
            AppMethodBeat.o(213995);
        }
    };
    private TextView HBa;
    private LinearLayout HBb;
    private LinearLayout HBc;
    private LinearLayout HBd;
    private TextView HBe;
    private LinearLayout HBf;
    private LinearLayout HBg;
    private LinearLayout HBh;
    private TextView HBi;
    private TextView HBj;
    private boolean HBk;
    private WalletLqtArriveTimeLayout HBl;
    private ScrollView HBm;
    private LinearLayout HBn;
    private TextView HBo;
    private TextView HBp;
    private TextView HBq;
    private CharSequence HBr;
    private Bankcard HBs;
    private int HBt;
    private String HBu;
    private String HBv;
    private long HBw = -1;
    public String HBx;
    private String HBy;
    private boolean HBz = false;
    private ac Hux = ((ac) au(ac.class));
    private ad Huy = ((ad) aq(ad.class));
    protected boolean HvA = false;
    private Runnable HvB = new Runnable() {
        /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass33 */

        public final void run() {
            AppMethodBeat.i(214007);
            WalletLqtSaveFetchUI.this.showNormalStWcKb();
            AppMethodBeat.o(214007);
        }
    };
    private Bankcard Hvb;
    private a Hyf;
    private IListener Hyh = new IListener<zl>() {
        /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass31 */

        {
            AppMethodBeat.i(214004);
            this.__eventId = zl.class.getName().hashCode();
            AppMethodBeat.o(214004);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(zl zlVar) {
            AppMethodBeat.i(214005);
            WalletLqtSaveFetchUI.this.Hyf.a(zlVar.efC.efB, new a.b() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass31.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.wallet.balance.ui.lqt.a.b
                public final void aep(int i2) {
                    AppMethodBeat.i(214003);
                    if (i2 == 2 || i2 == 3) {
                        WalletLqtSaveFetchUI.this.HBD = true;
                    }
                    AppMethodBeat.o(214003);
                }
            });
            AppMethodBeat.o(214005);
            return false;
        }
    };
    private int accountType;
    final View.OnClickListener hEZ = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass20 */

        public final void onClick(View view) {
            int i2;
            AppMethodBeat.i(213992);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (Util.ticksToNow(WalletLqtSaveFetchUI.this.HBw) < 800) {
                Log.d("MicroMsg.WalletLqtSaveFetchUI", "saveButton click too soon");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(213992);
                return;
            }
            WalletLqtSaveFetchUI.this.HBw = Util.currentTicks();
            final int lr = WalletLqtSaveFetchUI.lr(WalletLqtSaveFetchUI.this.HAP.getText(), "100");
            if (lr > 0) {
                WalletLqtSaveFetchUI.this.hideWcKb();
                if (WalletLqtSaveFetchUI.this.mode == 1) {
                    Log.i("MicroMsg.WalletLqtSaveFetchUI", "click save lqt");
                    if (WalletLqtSaveFetchUI.e(WalletLqtSaveFetchUI.this, u.HtN.HtJ)) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(213992);
                        return;
                    }
                    g.h(Integer.valueOf(lr), Integer.valueOf(WalletLqtSaveFetchUI.this.accountType), WalletLqtSaveFetchUI.this.Hvb).c(WalletLqtSaveFetchUI.this.HAN.HuM).f(new com.tencent.mm.vending.c.a<Void, dhj>() {
                        /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass20.AnonymousClass2 */

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // com.tencent.mm.vending.c.a
                        public final /* synthetic */ Void call(dhj dhj) {
                            AppMethodBeat.i(68986);
                            Void a2 = a(dhj);
                            AppMethodBeat.o(68986);
                            return a2;
                        }

                        private Void a(dhj dhj) {
                            AppMethodBeat.i(213989);
                            if (dhj == null) {
                                Log.i("MicroMsg.WalletLqtSaveFetchUI", "save failed, qryPurchaseResultRes is null");
                                AppMethodBeat.o(213989);
                                return null;
                            }
                            Log.i("MicroMsg.WalletLqtSaveFetchUI", "save finish: %s", Integer.valueOf(dhj.MLH));
                            WalletLqtSaveFetchUI.this.fNV();
                            Intent intent = new Intent(WalletLqtSaveFetchUI.this, WalletLqtSaveFetchFinishUI.class);
                            intent.putExtra("key_amount", f.a(new StringBuilder().append(lr).toString(), "100", 2, RoundingMode.HALF_UP));
                            intent.putExtra("key_mode", 1);
                            intent.putExtra("profile_date_wording", dhj.MLJ);
                            intent.putExtra("profile_upgrade_wording", dhj.MLI);
                            if (dhj.MLK != null) {
                                try {
                                    intent.putExtra("key_guide_cell", dhj.MLK.toByteArray());
                                } catch (IOException e2) {
                                    Log.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", e2, "", new Object[0]);
                                }
                            }
                            intent.putExtra("entrance_type", WalletLqtSaveFetchUI.this.getIntent().getIntExtra("entrance_type", 0));
                            WalletLqtSaveFetchUI walletLqtSaveFetchUI = WalletLqtSaveFetchUI.this;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(walletLqtSaveFetchUI, bl.axQ(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$27$2", "call", "(Lcom/tencent/mm/protocal/protobuf/QryPurchaseResultRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            walletLqtSaveFetchUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(walletLqtSaveFetchUI, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$27$2", "call", "(Lcom/tencent/mm/protocal/protobuf/QryPurchaseResultRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            WalletLqtSaveFetchUI.this.finish();
                            Void r0 = QZL;
                            AppMethodBeat.o(213989);
                            return r0;
                        }
                    }).a(new d.a() {
                        /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass20.AnonymousClass1 */

                        @Override // com.tencent.mm.vending.g.d.a
                        public final void cn(Object obj) {
                            String string;
                            AppMethodBeat.i(213988);
                            Log.i("MicroMsg.WalletLqtSaveFetchUI", "save failed: %s", obj);
                            WalletLqtSaveFetchUI.this.biW();
                            if (obj != null) {
                                if (obj instanceof String) {
                                    string = obj.toString();
                                } else {
                                    string = WalletLqtSaveFetchUI.this.getString(R.string.ih4);
                                }
                                h.d(WalletLqtSaveFetchUI.this, string, "", new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass20.AnonymousClass1.AnonymousClass1 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(68983);
                                        Log.i("MicroMsg.WalletLqtSaveFetchUI", "SAVE MMAlert Interrupt click");
                                        AppMethodBeat.o(68983);
                                    }
                                });
                            }
                            AppMethodBeat.o(213988);
                        }
                    });
                } else if (WalletLqtSaveFetchUI.this.mode == 2) {
                    Log.i("MicroMsg.WalletLqtSaveFetchUI", "click fetch lqt");
                    if (WalletLqtSaveFetchUI.e(WalletLqtSaveFetchUI.this, u.HtN.HtK)) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(213992);
                        return;
                    }
                    ja jaVar = null;
                    if (WalletLqtSaveFetchUI.this.Hvb != null && !WalletLqtSaveFetchUI.this.Hvb.fQb()) {
                        jaVar = new ja();
                        jaVar.ynT = WalletLqtSaveFetchUI.this.Hvb.field_bankName;
                        jaVar.dDj = WalletLqtSaveFetchUI.this.Hvb.field_bankcardType;
                        jaVar.KNw = WalletLqtSaveFetchUI.this.Hvb.field_bindSerial;
                        jaVar.AOk = WalletLqtSaveFetchUI.this.Hvb.field_bankcardTail;
                    }
                    if (WalletLqtSaveFetchUI.this.HBl.getSelectRedeemType() != null) {
                        i2 = WalletLqtSaveFetchUI.this.HBl.getSelectRedeemType().MJg;
                    } else {
                        i2 = 0;
                    }
                    if (WalletLqtSaveFetchUI.this.Hvb != null && !WalletLqtSaveFetchUI.this.Hvb.fQb()) {
                        Log.i("MicroMsg.WalletLqtSaveFetchUI", "choose bankcard");
                        int nE = f.nE(WalletLqtSaveFetchUI.this.HAP.getText(), "100");
                        cux fNa = x.fMZ().fNa();
                        if (fNa.MAm >= 0 && nE > fNa.MAm) {
                            Log.i("MicroMsg.WalletLqtSaveFetchUI", "choose slow redeem");
                            WalletLqtSaveFetchUI.B(WalletLqtSaveFetchUI.this);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(213992);
                            return;
                        } else if (fNa.MAm >= 0 && nE < fNa.MAm) {
                            Log.i("MicroMsg.WalletLqtSaveFetchUI", "choose fast redeem");
                            i2 = 0;
                        }
                    }
                    WalletLqtSaveFetchUI.this.HAN.HuN.a(lr, WalletLqtSaveFetchUI.this.accountType, i2, jaVar).f(new com.tencent.mm.vending.c.a<Void, dlv>() {
                        /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass20.AnonymousClass4 */

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // com.tencent.mm.vending.c.a
                        public final /* synthetic */ Void call(dlv dlv) {
                            AppMethodBeat.i(68990);
                            Void a2 = a(dlv);
                            AppMethodBeat.o(68990);
                            return a2;
                        }

                        private Void a(dlv dlv) {
                            AppMethodBeat.i(213991);
                            Log.i("MicroMsg.WalletLqtSaveFetchUI", "redeem succ: %s, is_realtime_arrivial: %s, is_redeem_into_pocket: %s", dlv, Boolean.valueOf(dlv.MPt), Boolean.valueOf(dlv.MPu));
                            WalletLqtSaveFetchUI.this.fNV();
                            if (!dlv.MPt || !dlv.MPu) {
                                Intent intent = new Intent(WalletLqtSaveFetchUI.this, WalletLqtSaveFetchFinishProgressNewUI.class);
                                try {
                                    intent.putExtra("key_redeem_res", dlv.toByteArray());
                                } catch (Exception e2) {
                                    Log.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", e2, "pass redeemFundRes error: %s", e2.getMessage());
                                }
                                WalletLqtSaveFetchUI walletLqtSaveFetchUI = WalletLqtSaveFetchUI.this;
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                com.tencent.mm.hellhoundlib.a.a.a(walletLqtSaveFetchUI, bl.axQ(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$27$4", "call", "(Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                walletLqtSaveFetchUI.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(walletLqtSaveFetchUI, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$27$4", "call", "(Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            } else {
                                Intent intent2 = new Intent(WalletLqtSaveFetchUI.this, WalletLqtSaveFetchFinishUI.class);
                                intent2.putExtra("key_amount", f.a(new StringBuilder().append(lr).toString(), "100", 2, RoundingMode.HALF_UP));
                                intent2.putExtra("key_mode", 2);
                                WalletLqtSaveFetchUI walletLqtSaveFetchUI2 = WalletLqtSaveFetchUI.this;
                                com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                                com.tencent.mm.hellhoundlib.a.a.a(walletLqtSaveFetchUI2, bl2.axQ(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$27$4", "call", "(Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                walletLqtSaveFetchUI2.startActivity((Intent) bl2.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(walletLqtSaveFetchUI2, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$27$4", "call", "(Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            }
                            WalletLqtSaveFetchUI.this.finish();
                            Void r0 = QZL;
                            AppMethodBeat.o(213991);
                            return r0;
                        }
                    }).a(new d.a() {
                        /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass20.AnonymousClass3 */

                        @Override // com.tencent.mm.vending.g.d.a
                        public final void cn(Object obj) {
                            String string;
                            boolean z = false;
                            AppMethodBeat.i(213990);
                            WalletLqtSaveFetchUI.this.HvA = false;
                            WalletLqtSaveFetchUI.this.biW();
                            if (obj != null) {
                                if (obj instanceof dlv) {
                                    z = com.tencent.mm.wallet_core.d.h.a(WalletLqtSaveFetchUI.this, null, 1000, ((dlv) obj).pTZ, ((dlv) obj).pUa);
                                }
                                if (!z) {
                                    if (obj instanceof String) {
                                        string = obj.toString();
                                    } else {
                                        string = WalletLqtSaveFetchUI.this.getString(R.string.ih4);
                                    }
                                    h.d(WalletLqtSaveFetchUI.this, string, "", new DialogInterface.OnClickListener() {
                                        /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass20.AnonymousClass3.AnonymousClass1 */

                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                            AppMethodBeat.i(68987);
                                            Log.i("MicroMsg.WalletLqtSaveFetchUI", "fetch MMAlert Interrupt click");
                                            AppMethodBeat.o(68987);
                                        }
                                    });
                                }
                            }
                            AppMethodBeat.o(213990);
                        }
                    });
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$27", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(213992);
        }
    };
    private Dialog jUV;
    public Runnable jVx = new Runnable() {
        /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass32 */

        public final void run() {
            AppMethodBeat.i(214006);
            if (WalletLqtSaveFetchUI.this.state == 2 && WalletLqtSaveFetchUI.this.isHandleAutoShowNormalStWcKb()) {
                WalletLqtSaveFetchUI.this.showNormalStWcKb();
            }
            AppMethodBeat.o(214006);
        }
    };
    private int mode;
    private int state = 0;
    private int wfU = MMApplicationContext.getContext().getResources().getColor(R.color.FG_1);
    private HashMap<String, Integer> yNN = new HashMap<>();
    private TextView zcC;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBasePresenterUI, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletLqtSaveFetchUI() {
        AppMethodBeat.i(69009);
        AppMethodBeat.o(69009);
    }

    static /* synthetic */ com.tencent.mm.ui.widget.a.g a(WalletLqtSaveFetchUI walletLqtSaveFetchUI, t tVar, t tVar2, t tVar3) {
        AppMethodBeat.i(214045);
        com.tencent.mm.ui.widget.a.g a2 = walletLqtSaveFetchUI.a(tVar, tVar2, tVar3);
        AppMethodBeat.o(214045);
        return a2;
    }

    static /* synthetic */ void a(WalletLqtSaveFetchUI walletLqtSaveFetchUI, int i2) {
        AppMethodBeat.i(214027);
        walletLqtSaveFetchUI.fX(null, i2);
        AppMethodBeat.o(214027);
    }

    static /* synthetic */ void a(WalletLqtSaveFetchUI walletLqtSaveFetchUI, com.tencent.mm.ui.widget.a.g gVar, t tVar) {
        AppMethodBeat.i(214046);
        walletLqtSaveFetchUI.a(gVar, tVar);
        AppMethodBeat.o(214046);
    }

    static /* synthetic */ void a(WalletLqtSaveFetchUI walletLqtSaveFetchUI, String str) {
        AppMethodBeat.i(214030);
        walletLqtSaveFetchUI.cC(str, true);
        AppMethodBeat.o(214030);
    }

    static /* synthetic */ void b(WalletLqtSaveFetchUI walletLqtSaveFetchUI, boolean z) {
        AppMethodBeat.i(214036);
        walletLqtSaveFetchUI.xP(z);
        AppMethodBeat.o(214036);
    }

    static /* synthetic */ boolean e(WalletLqtSaveFetchUI walletLqtSaveFetchUI, String str) {
        AppMethodBeat.i(214041);
        boolean aUQ = walletLqtSaveFetchUI.aUQ(str);
        AppMethodBeat.o(214041);
        return aUQ;
    }

    static /* synthetic */ double lq(String str, String str2) {
        AppMethodBeat.i(214031);
        double lo = lo(str, str2);
        AppMethodBeat.o(214031);
        return lo;
    }

    static /* synthetic */ int lr(String str, String str2) {
        AppMethodBeat.i(214040);
        int lp = lp(str, str2);
        AppMethodBeat.o(214040);
        return lp;
    }

    static /* synthetic */ void o(WalletLqtSaveFetchUI walletLqtSaveFetchUI) {
        AppMethodBeat.i(214033);
        walletLqtSaveFetchUI.xO(false);
        AppMethodBeat.o(214033);
    }

    static /* synthetic */ List r(WalletLqtSaveFetchUI walletLqtSaveFetchUI) {
        AppMethodBeat.i(214035);
        List<Bankcard> fNT = walletLqtSaveFetchUI.fNT();
        AppMethodBeat.o(214035);
        return fNT;
    }

    static /* synthetic */ void t(WalletLqtSaveFetchUI walletLqtSaveFetchUI) {
        AppMethodBeat.i(214037);
        walletLqtSaveFetchUI.fNU();
        AppMethodBeat.o(214037);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBasePresenterUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(69010);
        fixStatusbar(true);
        super.onCreate(bundle);
        setActionbarColor(getResources().getColor(R.color.a2r));
        hideActionbarLine();
        Log.i("MicroMsg.WalletLqtSaveFetchUI", "WalletLqtSaveFetchUI onCreate");
        this.Hyf = new a(this);
        this.HAP = (WalletFormView) findViewById(R.id.exj);
        this.HAT = (ImageView) findViewById(R.id.a1s);
        this.HAU = (TextView) findViewById(R.id.exg);
        this.HAV = (TextView) findViewById(R.id.exh);
        this.HAQ = (TextView) findViewById(R.id.exk);
        this.HAR = (TextView) findViewById(R.id.ev1);
        ao.a(this.HAR.getPaint(), 0.8f);
        this.HBj = (TextView) findViewById(R.id.jia);
        this.zcC = (TextView) findViewById(R.id.exo);
        this.HBq = (TextView) findViewById(R.id.exi);
        this.HAW = (ViewGroup) findViewById(R.id.exl);
        this.HAX = (TextView) findViewById(R.id.exn);
        this.HAY = (CheckBox) findViewById(R.id.exm);
        this.HAO = (ViewGroup) findViewById(R.id.f68);
        this.HAZ = (TextView) findViewById(R.id.dpd);
        this.HBa = (TextView) findViewById(R.id.dpe);
        this.HBb = (LinearLayout) findViewById(R.id.gm7);
        this.HBc = (LinearLayout) findViewById(R.id.ev9);
        this.HBd = (LinearLayout) findViewById(R.id.ev7);
        this.HBe = (TextView) findViewById(R.id.ev8);
        this.HBf = (LinearLayout) findViewById(R.id.ev4);
        this.HBg = (LinearLayout) findViewById(R.id.ev6);
        this.HBi = (TextView) findViewById(R.id.ev3);
        this.HAS = (TextView) findViewById(R.id.a07);
        this.HBl = (WalletLqtArriveTimeLayout) findViewById(R.id.exe);
        this.HBm = (ScrollView) findViewById(R.id.exb);
        this.HBn = (LinearLayout) findViewById(R.id.ewl);
        this.HBo = (TextView) findViewById(R.id.ewm);
        this.HBp = (TextView) findViewById(R.id.ewn);
        this.HBh = (LinearLayout) findViewById(R.id.dpg);
        ao.a(this.HBp.getPaint(), 0.8f);
        this.mode = getIntent().getIntExtra("lqt_save_fetch_mode", 1);
        int intExtra = getIntent().getIntExtra("entrance_type", 0);
        this.HAM.mode = this.mode;
        this.HAM.HuF = intExtra;
        this.HBt = getIntent().getIntExtra("lqt_max_redeem_amount", -1);
        this.HBu = getIntent().getStringExtra("lqt_redeem_invalid_amount_hint");
        this.HBv = getIntent().getStringExtra("lqt_profile_wording");
        this.accountType = getIntent().getIntExtra("lqt_account_type", 0);
        if (ao.isDarkMode()) {
            this.HBb.setBackground(getResources().getDrawable(R.drawable.aef));
        }
        if (this.mode == 1) {
            com.tencent.mm.kernel.g.aAi();
            this.HBx = (String) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_LQT_DEFAULTCARD_SAVE_STRING_SYNC, "");
            if (Util.isNullOrNil(this.HBx)) {
                com.tencent.mm.kernel.g.aAi();
                this.HBx = (String) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_LQT_DEFAULTCARD_STRING_SYNC, "");
            }
            this.HBy = getIntent().getStringExtra("card_serial");
            this.HBc.setVisibility(8);
            this.HBd.setVisibility(0);
            this.HBf.setVisibility(8);
            this.HBg.setVisibility(0);
        }
        Log.i("MicroMsg.WalletLqtSaveFetchUI", "onCreate, accountType: %s, mode: %s, mCurrentSerial: %s", Integer.valueOf(this.accountType), Integer.valueOf(this.mode), this.HBx);
        this.HAP.getTitleTv().setText(ah.hhz());
        this.mWcKeyboard = (WcPayKeyboard) findViewById(R.id.joy);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mWcKeyboard.getLayoutParams();
        layoutParams.addRule(12);
        this.mWcKeyboard.setLayoutParams(layoutParams);
        if (this.mode == 1) {
            setWPKeyboard(this.HAP.getContentEt(), false, false);
            this.mWcKeyboard.setActionText(getString(R.string.iih));
        } else {
            this.isVKBFirstTimeShown = false;
            setWPKeyboard(this.HAP.getContentEt(), false, false);
            this.mWcKeyboard.setActionText(getString(R.string.igy));
        }
        if (com.tencent.mm.compatible.util.d.oF(27)) {
            this.HAP.hic();
        }
        setWcKbHeightListener(this);
        if (this.mode == 1) {
            this.HAQ.setText(getString(R.string.ii_));
            this.HBj.setText(getString(R.string.iic));
        } else if (this.mode == 2) {
            this.HAQ.setText(getString(R.string.igc));
            this.HBj.setText(getString(R.string.igk));
        }
        this.HAP.a(new TextWatcher() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass15 */

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(213984);
                if (editable.toString().startsWith(".")) {
                    editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                String obj = editable.toString();
                int indexOf = obj.indexOf(".");
                int length = obj.length();
                if (indexOf >= 0 && length - indexOf > 3) {
                    WalletFormView.a(WalletLqtSaveFetchUI.this.HAP.getContentEt(), obj, indexOf + 3, length);
                } else if (indexOf > 12) {
                    WalletFormView.a(WalletLqtSaveFetchUI.this.HAP.getContentEt(), obj, 12, indexOf);
                } else if (indexOf == -1 && length > 12) {
                    WalletFormView.a(WalletLqtSaveFetchUI.this.HAP.getContentEt(), obj, 12, length);
                }
                String obj2 = editable.toString();
                WalletLqtSaveFetchUI.c(WalletLqtSaveFetchUI.this, obj2);
                WalletLqtSaveFetchUI.this.HBE = obj2;
                AppMethodBeat.o(213984);
            }
        });
        setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass16 */

            @Override // com.tencent.mm.wallet_core.ui.a
            public final void onVisibleStateChange(boolean z) {
                AppMethodBeat.i(213985);
                if (!z) {
                    WalletLqtSaveFetchUI.this.HBm.scrollTo(0, 0);
                    if (WalletLqtSaveFetchUI.this.mode == 2 && Util.isNullOrNil(WalletLqtSaveFetchUI.this.HAP.getText())) {
                        WalletLqtSaveFetchUI.v(WalletLqtSaveFetchUI.this);
                    }
                } else if (WalletLqtSaveFetchUI.this.mode == 2) {
                    WalletLqtSaveFetchUI.t(WalletLqtSaveFetchUI.this);
                    AppMethodBeat.o(213985);
                    return;
                } else if (WalletLqtSaveFetchUI.this.mode == 1) {
                    AppMethodBeat.o(213985);
                    return;
                }
                AppMethodBeat.o(213985);
            }
        });
        this.HAP.getContentEt().setOnEditorActionListener(new TextView.OnEditorActionListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass17 */

            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                AppMethodBeat.i(213986);
                if (keyEvent != null && keyEvent.getAction() == 1 && keyEvent.getKeyCode() == 66) {
                    Log.i("MicroMsg.WalletLqtSaveFetchUI", "click enter");
                    WalletLqtSaveFetchUI.w(WalletLqtSaveFetchUI.this);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(20287, 2);
                    AppMethodBeat.o(213986);
                } else {
                    AppMethodBeat.o(213986);
                }
                return true;
            }
        });
        if (!Util.isNullOrNil(this.HBv)) {
            this.mWcKeyboard.setTipText(this.HBv);
        }
        if (this.mode == 2) {
            this.HBl.setCallback(new WalletLqtArriveTimeLayout.a() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass18 */

                @Override // com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtArriveTimeLayout.a
                public final void fNw() {
                    AppMethodBeat.i(213987);
                    WalletLqtSaveFetchUI.b(WalletLqtSaveFetchUI.this, true);
                    AppMethodBeat.o(213987);
                }
            });
        }
        int width = this.HBj.getWidth();
        Log.d("MicroMsg.WalletLqtSaveFetchUI", "saveFetchHintWordingTv width: %d", Integer.valueOf(width));
        if (width <= 0) {
            this.HBj.post(new Runnable() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass19 */

                public final void run() {
                    AppMethodBeat.i(68997);
                    int width = WalletLqtSaveFetchUI.this.HBj.getWidth();
                    Log.d("MicroMsg.WalletLqtSaveFetchUI", "saveFetchHintWordingTv trueWidth: %d", Integer.valueOf(width));
                    if (width <= 0) {
                        AppMethodBeat.o(68997);
                        return;
                    }
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) WalletLqtSaveFetchUI.this.HBh.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.leftMargin = width;
                    }
                    WalletLqtSaveFetchUI.this.HBh.setLayoutParams(layoutParams);
                    AppMethodBeat.o(68997);
                }
            });
        } else {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.HBh.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.leftMargin = width;
            }
            this.HBh.setLayoutParams(layoutParams2);
        }
        this.HAU.setText("");
        this.HAU.setClickable(true);
        this.HAU.setOnTouchListener(new o(this));
        xP(false);
        this.HBo.setClickable(true);
        this.HBo.setOnTouchListener(new o(this));
        this.HBp.setClickable(true);
        this.HBp.setOnTouchListener(new o(this));
        if (this.mode == 1) {
            this.HAO.setVisibility(4);
            if (intExtra == 8) {
                setMMTitle(R.string.iig);
                this.mWcKeyboard.showNormalStWcKb();
            } else {
                setMMTitle(R.string.iih);
            }
        } else {
            setMMTitle(R.string.igy);
        }
        if (this.HAR.findViewById(R.id.ji_) != null) {
            this.HAR.findViewById(R.id.ji_).setVisibility(8);
        }
        AnonymousClass1 r0 = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(68967);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletLqtSaveFetchUI.this.hideTenpayKB();
                int i2 = -1;
                if (WalletLqtSaveFetchUI.this.mode == 1) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(17084, 28);
                    i2 = 2;
                }
                if (WalletLqtSaveFetchUI.this.mode == 2) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(20287, 3);
                }
                WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, i2);
                if (WalletLqtSaveFetchUI.this.HBk) {
                    WalletLqtSaveFetchUI.this.HAN.HuQ.jP(1, 0);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(68967);
            }
        };
        this.HAR.setOnClickListener(r0);
        if (findViewById(R.id.aqu) != null) {
            findViewById(R.id.aqu).setOnClickListener(r0);
        }
        u uVar = u.HtN;
        uVar.HtM.add(this.HBH);
        fNR();
        this.HAO.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass12 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(68982);
                if (!WalletLqtSaveFetchUI.this.mWcKeyboard.isShown() || !WalletLqtSaveFetchUI.this.mWcKeyboard.hgP()) {
                    AppMethodBeat.o(68982);
                    return false;
                }
                WalletLqtSaveFetchUI.this.mWcKeyboard.hgN();
                AppMethodBeat.o(68982);
                return true;
            }
        });
        this.state = 1;
        String stringExtra = getIntent().getStringExtra("fill_money");
        if (Util.getDouble(stringExtra, 0.0d) > 0.0d) {
            this.HAP.setText(stringExtra);
            cC(stringExtra, false);
        }
        EditText contentEt = this.HAP.getContentEt();
        TextView titleTv = this.HAP.getTitleTv();
        float ez = com.tencent.mm.cb.a.ez(this);
        float gvi = com.tencent.mm.cc.a.gvi();
        if (!(ez == 1.0f && gvi == 1.0f)) {
            if (ez > 1.4f) {
                ez = 1.4f;
            }
            float textSize = (contentEt.getTextSize() / ez) / gvi;
            contentEt.setTextSize(0, textSize);
            float textSize2 = (titleTv.getTextSize() / ez) / gvi;
            titleTv.setTextSize(0, textSize2);
            Log.i("MicroMsg.WalletLqtSaveFetchUI", "et:" + textSize + " tv:" + textSize2 + " fontScale:" + ez + " viewScale:" + gvi);
        }
        AppMethodBeat.o(69010);
    }

    private void fNQ() {
        AppMethodBeat.i(214022);
        h.a((Context) getContext(), getString(R.string.ige), "", getString(R.string.idg), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass34 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(69003);
                WalletLqtSaveFetchUI.this.finish();
                AppMethodBeat.o(69003);
            }
        });
        AppMethodBeat.o(214022);
    }

    private boolean aUQ(String str) {
        AppMethodBeat.i(69011);
        if (!Util.isNullOrNil(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("guide_flag");
                String optString2 = jSONObject.optString("guide_wording");
                String optString3 = jSONObject.optString("left_button_wording");
                String optString4 = jSONObject.optString("right_button_wording");
                final String optString5 = jSONObject.optString("upload_credit_url");
                if ("2".equals(optString)) {
                    d.a aVar = new d.a(getContext());
                    aVar.Dk(false);
                    aVar.boo(optString2);
                    aVar.bov(optString3);
                    aVar.bou(optString4);
                    aVar.a(true, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass42 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(214019);
                            f.p(WalletLqtSaveFetchUI.this.getContext(), optString5, false);
                            AppMethodBeat.o(214019);
                        }
                    });
                    aVar.hbn().show();
                    AppMethodBeat.o(69011);
                    return true;
                }
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(69011);
        return false;
    }

    public final void fNR() {
        AppMethodBeat.i(69012);
        if (this.mode == 1) {
            this.HBs = u.HtN.fMU();
            if (this.HBs == null) {
                s.fOg();
                this.HBs = s.fOh().Hwc;
            }
            if (this.HBs != null) {
                String fMV = u.HtN.fMV();
                int fMW = u.HtN.fMW();
                if (fMW == 0) {
                    this.HBr = fMV;
                } else if (fMW == 1) {
                    int length = fMV.length();
                    SpannableString spannableString = new SpannableString(fMV + getString(R.string.ig0));
                    spannableString.setSpan(new e(new e.a() {
                        /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass43 */

                        @Override // com.tencent.mm.wallet_core.ui.e.a
                        public final void bmr() {
                            AppMethodBeat.i(69005);
                            WalletLqtSaveFetchUI.this.HAP.setText(f.formatMoney2f(WalletLqtSaveFetchUI.this.HBs.HVC));
                            WalletLqtSaveFetchUI.this.HAP.getContentEt().requestFocus();
                            WalletLqtSaveFetchUI.this.showWcKb();
                            AppMethodBeat.o(69005);
                        }
                    }), length + 1, spannableString.length(), 18);
                    this.HBr = spannableString;
                } else {
                    Log.w("MicroMsg.WalletLqtSaveFetchUI", "unknown func: %s", Integer.valueOf(fMW));
                    this.HBr = fMV;
                }
                if (this.HAU != null) {
                    this.HAU.setText(this.HBr);
                }
            }
            if (this.HAO != null) {
                this.HAO.setVisibility(0);
            }
            if (!Util.isNullOrNil(u.HtN.HtI)) {
                this.zcC.setText(u.HtN.HtI);
                this.zcC.setVisibility(0);
            } else {
                this.zcC.setVisibility(8);
            }
            cux fNa = x.fMZ().fNa();
            if (!(fNa == null || !fNa.Mma || fNa.MAl == null)) {
                com.tencent.mm.plugin.wallet.balance.model.lqt.ah.a(getContext(), fNa.MAl);
            }
            xO(true);
            AppMethodBeat.o(69012);
        } else if (this.HBl.HwS) {
            xO(false);
            AppMethodBeat.o(69012);
        } else {
            xO(true);
            AppMethodBeat.o(69012);
        }
    }

    private void fNS() {
        AppMethodBeat.i(69013);
        WalletLqtArriveTimeLayout walletLqtArriveTimeLayout = this.HBl;
        walletLqtArriveTimeLayout.HwS = false;
        if (walletLqtArriveTimeLayout.HwO != null) {
            walletLqtArriveTimeLayout.HwO.clear();
        }
        walletLqtArriveTimeLayout.HwQ = null;
        walletLqtArriveTimeLayout.HwP.clear();
        walletLqtArriveTimeLayout.setVisibility(4);
        AppMethodBeat.o(69013);
    }

    private void I(boolean z, String str) {
        AppMethodBeat.i(69014);
        Log.d("MicroMsg.WalletLqtSaveFetchUI", "update arrive time layout: %s", Boolean.valueOf(z));
        if (this.mode == 2) {
            cux fNa = x.fMZ().fNa();
            if (this.HBl.HwS) {
                if (z) {
                    if (this.Hvb.fQb()) {
                        Log.d("MicroMsg.WalletLqtSaveFetchUI", "show balance arrive time");
                        this.HBl.w(fNa.MAj, true);
                    } else if (fNa.MAk != null) {
                        Iterator<jf> it = fNa.MAk.iterator();
                        while (it.hasNext()) {
                            jf next = it.next();
                            if (next.KNw.equals(this.Hvb.field_bindSerial)) {
                                Log.d("MicroMsg.WalletLqtSaveFetchUI", "show bankcard arrive time");
                                this.HBl.w(next.KNM, true);
                            }
                        }
                    }
                }
                this.HBl.setVisibility(4);
                this.HBl.aUJ(str);
            } else if (fNa == null) {
                Log.w("MicroMsg.WalletLqtSaveFetchUI", "no cache!");
                AppMethodBeat.o(69014);
                return;
            } else {
                if (this.Hvb.fQb()) {
                    Log.d("MicroMsg.WalletLqtSaveFetchUI", "show balance arrive time");
                    this.HBl.w(fNa.MAj, false);
                    this.HBl.aUJ(str);
                } else if (fNa.MAk != null) {
                    Iterator<jf> it2 = fNa.MAk.iterator();
                    while (it2.hasNext()) {
                        jf next2 = it2.next();
                        if (next2.KNw.equals(this.Hvb.field_bindSerial)) {
                            Log.d("MicroMsg.WalletLqtSaveFetchUI", "show bankcard arrive time");
                            this.HBl.w(next2.KNM, false);
                            this.HBl.aUJ(str);
                        }
                    }
                }
                this.HBl.setVisibility(4);
                fNU();
                AppMethodBeat.o(69014);
                return;
            }
        }
        AppMethodBeat.o(69014);
    }

    private void xO(boolean z) {
        AppMethodBeat.i(69015);
        if (this.mode == 2 && z) {
            this.Hvb = u.HtN.xE(false);
            if (this.Hvb == null) {
                this.HBc.setVisibility(0);
                this.HBe.setText(getString(R.string.igd));
                this.HBd.setVisibility(8);
                this.HBf.setVisibility(0);
                this.HBg.setVisibility(8);
                this.HBi.setText(getString(R.string.ifw));
                this.HAR.setClickable(false);
                if (findViewById(R.id.aqu) != null) {
                    findViewById(R.id.aqu).setClickable(false);
                }
                this.HAP.setContentClickable(false);
                EditText contentEt = this.HAP.getContentEt();
                if (contentEt != null) {
                    contentEt.setCursorVisible(false);
                }
                findViewById(R.id.jfv).setVisibility(8);
                this.HBn.setVisibility(8);
                this.HAW.setVisibility(8);
                this.HAV.setVisibility(8);
                this.HBh.setVisibility(8);
                this.HBb.setVisibility(8);
                AppMethodBeat.o(69015);
                return;
            }
        }
        if (this.mode == 2) {
            this.HAR.setClickable(true);
            if (findViewById(R.id.aqu) != null) {
                findViewById(R.id.aqu).setClickable(true);
            }
            this.HAP.setContentClickable(true);
            EditText contentEt2 = this.HAP.getContentEt();
            if (contentEt2 != null) {
                contentEt2.setCursorVisible(true);
            }
        }
        this.HBc.setVisibility(8);
        this.HBd.setVisibility(0);
        this.HBf.setVisibility(8);
        this.HBg.setVisibility(0);
        List<Bankcard> xG = u.HtN.xG(this.mode == 1);
        if (xG == null || xG.size() == 0) {
            s.fOg();
            xG = s.fOh().fRJ();
        }
        LinkedList linkedList = new LinkedList();
        if (xG != null) {
            for (Bankcard bankcard : xG) {
                if (bankcard.fQb()) {
                    s.fOg();
                    if (!s.fOh().fRm()) {
                        linkedList.add(bankcard);
                    }
                }
                if (this.mode == 1 && bankcard.field_support_lqt_turn_in == 1) {
                    linkedList.add(bankcard);
                }
                if (this.mode == 2 && bankcard.field_support_lqt_turn_out == 1) {
                    linkedList.add(bankcard);
                }
            }
        }
        if (z) {
            if (!Util.isNullOrNil(this.HBy)) {
                for (int i2 = 0; i2 < linkedList.size(); i2++) {
                    Bankcard bankcard2 = (Bankcard) linkedList.get(i2);
                    if (!Util.isNullOrNil(bankcard2.field_bindSerial) && this.HBy.equals(bankcard2.field_bindSerial)) {
                        this.Hvb = bankcard2;
                    }
                }
            }
            if (Util.isNullOrNil(this.HBy) || this.Hvb == null) {
                this.Hvb = u.HtN.xE(this.mode == 1);
                if (!Util.isNullOrNil(this.HBx) && this.Hvb == null) {
                    for (int i3 = 0; i3 < linkedList.size(); i3++) {
                        Bankcard bankcard3 = (Bankcard) linkedList.get(i3);
                        if (!Util.isNullOrNil(bankcard3.field_bindSerial) && this.HBx.equals(bankcard3.field_bindSerial)) {
                            this.Hvb = bankcard3;
                        }
                    }
                }
            }
        } else if (!Util.isNullOrNil(this.HBx)) {
            for (int i4 = 0; i4 < linkedList.size(); i4++) {
                Bankcard bankcard4 = (Bankcard) linkedList.get(i4);
                if (!Util.isNullOrNil(bankcard4.field_bindSerial) && this.HBx.equals(bankcard4.field_bindSerial)) {
                    this.Hvb = bankcard4;
                }
            }
        }
        Object[] objArr = new Object[3];
        objArr[0] = this.Hvb != null ? this.Hvb.field_bindSerial : "";
        objArr[1] = this.HBx;
        objArr[2] = Boolean.valueOf(z);
        Log.i("MicroMsg.WalletLqtSaveFetchUI", "defaultBankcard: %s, save mCurrentSerial: %s, useDefault: %s", objArr);
        if (this.Hvb == null) {
            s.fOg();
            this.Hvb = s.fOh().Hwc;
            if (this.Hvb == null) {
                finish();
                AppMethodBeat.o(69015);
                return;
            }
        }
        if (this.Hvb.fQb()) {
            this.HAR.setText(this.Hvb.field_desc);
        } else {
            this.HAR.setText(getString(R.string.i79, new Object[]{this.Hvb.field_bankName, this.Hvb.field_bankcardTail}));
        }
        this.HAR.setText(this.Hvb.field_desc);
        this.HAR.setVisibility(0);
        this.HAT.setTag(this.Hvb.field_bindSerial);
        if (this.HAT != null) {
            String str = "";
            com.tencent.mm.plugin.wallet_core.model.e j2 = com.tencent.mm.plugin.wallet_core.d.b.j(this, this.Hvb.field_bankcardType, this.Hvb.fQa());
            if (j2 != null) {
                str = j2.AAU;
            }
            this.HAT.setImageBitmap(null);
            if (this.Hvb.fQb()) {
                this.HAT.setImageResource(R.drawable.cqo);
            } else {
                Bitmap a2 = com.tencent.mm.platformtools.u.a(new c(str));
                com.tencent.mm.platformtools.u.a(new u.a() {
                    /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass2 */

                    @Override // com.tencent.mm.platformtools.u.a
                    public final void k(String str, final Bitmap bitmap) {
                        AppMethodBeat.i(213967);
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass2.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(213966);
                                if (!(WalletLqtSaveFetchUI.this.Hvb == null || WalletLqtSaveFetchUI.this.HAT == null || WalletLqtSaveFetchUI.this.HAT.getTag() == null || !WalletLqtSaveFetchUI.this.HAT.getTag().equals(WalletLqtSaveFetchUI.this.Hvb.field_bindSerial))) {
                                    WalletLqtSaveFetchUI.this.HAT.setImageBitmap(bitmap);
                                }
                                AppMethodBeat.o(213966);
                            }
                        });
                        AppMethodBeat.o(213967);
                    }
                });
                if (a2 != null) {
                    this.HAT.setImageBitmap(BitmapUtil.extractThumbNail(a2, getResources().getDimensionPixelOffset(R.dimen.aov), getResources().getDimensionPixelOffset(R.dimen.aov), true, false));
                }
            }
        }
        this.HBh.setVisibility(8);
        this.HBb.setVisibility(8);
        if (this.mode == 2) {
            cux fNa = x.fMZ().fNa();
            if (fNa != null && !this.Hvb.fQb() && !TextUtils.isEmpty(fNa.MAn)) {
                this.HBh.setVisibility(0);
                this.HAZ.setText(fNa.MAn);
                this.HAZ.setVisibility(0);
            }
        } else if (this.mode == 1) {
            if (!this.Hvb.fQb() && !Util.isNullOrNil(this.Hvb.field_avail_save_wording)) {
                this.HBh.setVisibility(0);
                this.HAZ.setText(this.Hvb.field_avail_save_wording);
                this.HAZ.setVisibility(0);
            }
            cki xF = com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN.xF(this.mode == 1);
            if (xF != null) {
                final acl acl = xF.MpP;
                if (!(this.Hvb == null || !this.Hvb.fQb() || acl == null)) {
                    this.HAN.HuQ.jP(0, 1);
                    this.HBk = true;
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(17084, 25);
                    String str2 = acl.LmX;
                    String str3 = acl.LmY;
                    Log.i("MicroMsg.WalletLqtSaveFetchUI", "tryShowSaveFromLqBubble, promptText: %s, jumpText: %s", str2, str3);
                    boolean z2 = !TextUtils.isEmpty(str2);
                    boolean z3 = !TextUtils.isEmpty(str3);
                    TextView textView = (TextView) this.HBb.findViewById(R.id.gm8);
                    TextView textView2 = (TextView) this.HBb.findViewById(R.id.gm6);
                    textView.setVisibility(4);
                    textView2.setVisibility(4);
                    if (z2 || z3) {
                        this.HBb.setVisibility(0);
                    }
                    if (z2) {
                        textView.setVisibility(0);
                        textView.setText(str2);
                    }
                    if (z3) {
                        textView2.setVisibility(0);
                        f.a(textView2, str3, 0, str3.length(), new e(new e.a() {
                            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass3 */

                            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                            @Override // com.tencent.mm.wallet_core.ui.e.a
                            public final void bmr() {
                                AppMethodBeat.i(213968);
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(17084, 26);
                                WalletLqtSaveFetchUI.this.HAN.HuQ.jP(1, 0);
                                switch (acl.uSc) {
                                    case 1:
                                        WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, 1);
                                        AppMethodBeat.o(213968);
                                        return;
                                    case 2:
                                        f.bn(WalletLqtSaveFetchUI.this.getContext(), acl.pTL);
                                        AppMethodBeat.o(213968);
                                        return;
                                    case 3:
                                        f.u(acl.Hwr, acl.pTL, 0, 1000);
                                        break;
                                }
                                AppMethodBeat.o(213968);
                            }
                        }), getContext());
                    }
                }
            }
        }
        if (this.mode == 1) {
            final ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra("lqt_protocol_list");
            boolean booleanExtra = getIntent().getBooleanExtra("lqt_is_show_protocol", false);
            if (stringArrayListExtra == null || stringArrayListExtra.size() <= 0 || !booleanExtra) {
                this.HAW.setVisibility(8);
            } else {
                this.HAW.setVisibility(0);
                this.HAY.setChecked(getIntent().getBooleanExtra("lqt_is_agree_protocol", false));
                this.HAW.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass11 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(213979);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        WalletLqtSaveFetchUI.this.HAY.setChecked(!WalletLqtSaveFetchUI.this.HAY.isChecked());
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(213979);
                    }
                });
                this.HAY.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass13 */

                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        AppMethodBeat.i(213980);
                        if (!z) {
                            WalletLqtSaveFetchUI.b(WalletLqtSaveFetchUI.this, false);
                            AppMethodBeat.o(213980);
                            return;
                        }
                        WalletLqtSaveFetchUI.b(WalletLqtSaveFetchUI.this, true);
                        AppMethodBeat.o(213980);
                    }
                });
                String string = getString(R.string.ii2);
                int length = string.length();
                SpannableString spannableString = new SpannableString(string + getString(R.string.ii3));
                spannableString.setSpan(new e(new e.a() {
                    /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass14 */

                    @Override // com.tencent.mm.wallet_core.ui.e.a
                    public final void bmr() {
                        AppMethodBeat.i(213983);
                        com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) WalletLqtSaveFetchUI.this, 1, false);
                        eVar.HLX = new o.f() {
                            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass14.AnonymousClass1 */

                            @Override // com.tencent.mm.ui.base.o.f
                            public final void onCreateMMMenu(m mVar) {
                                AppMethodBeat.i(213981);
                                Iterator it = stringArrayListExtra.iterator();
                                int i2 = 0;
                                while (it.hasNext()) {
                                    mVar.add(0, i2, 0, ((String) it.next()).split("\\|\\|")[0]);
                                    i2++;
                                }
                                AppMethodBeat.o(213981);
                            }
                        };
                        eVar.HLY = new o.g() {
                            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass14.AnonymousClass2 */

                            @Override // com.tencent.mm.ui.base.o.g
                            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                                AppMethodBeat.i(213982);
                                int itemId = menuItem.getItemId();
                                if (itemId < stringArrayListExtra.size()) {
                                    f.p(WalletLqtSaveFetchUI.this, ((String) stringArrayListExtra.get(itemId)).split("\\|\\|")[1], false);
                                }
                                AppMethodBeat.o(213982);
                            }
                        };
                        eVar.dGm();
                        AppMethodBeat.o(213983);
                    }
                }), length, spannableString.length(), 17);
                this.HAX.setText(spannableString);
                this.HAX.setClickable(true);
                this.HAX.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o());
            }
        } else if (this.mode == 2) {
            findViewById(R.id.jfv).setVisibility(8);
            this.HBn.setVisibility(8);
            this.HAW.setVisibility(8);
            this.HAV.setVisibility(8);
            x fMZ = x.fMZ();
            if (this.Hvb == null || !this.Hvb.fQb()) {
                int i5 = fMZ.fNa() == null ? 0 : fMZ.fNa().MAf;
                if (fMZ.fNa() != null) {
                    fMZ.fNa();
                }
                if (com.tencent.mm.platformtools.ac.jPD) {
                    i5 = XWalkEnvironment.TEST_APK_START_VERSION;
                }
                String string2 = getString(R.string.ig1, new Object[]{Double.valueOf(lo(String.valueOf(i5), "100"))});
                this.HBr = string2;
                this.HAU.setText(string2);
            } else {
                final int intExtra = getIntent().getIntExtra("lqt_balance", 0);
                if (com.tencent.mm.platformtools.ac.jPD) {
                    intExtra = 50000000;
                }
                if (intExtra > 0) {
                    String string3 = getString(R.string.igt, new Object[]{Double.valueOf(lo(String.valueOf(intExtra), "100"))});
                    int length2 = string3.length();
                    SpannableString spannableString2 = new SpannableString(string3 + " " + getString(R.string.igw));
                    spannableString2.setSpan(new e(new e.a() {
                        /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass45 */

                        @Override // com.tencent.mm.wallet_core.ui.e.a
                        public final void bmr() {
                            AppMethodBeat.i(214021);
                            WalletLqtSaveFetchUI.this.HAP.setText(f.formatMoney2f(WalletLqtSaveFetchUI.lq(new StringBuilder().append(intExtra).toString(), "100")));
                            WalletLqtSaveFetchUI.this.HAP.getContentEt().requestFocus();
                            WalletLqtSaveFetchUI.this.showWcKb();
                            AppMethodBeat.o(214021);
                        }
                    }), length2, spannableString2.length(), 18);
                    this.HBr = spannableString2;
                    this.HAU.setText(spannableString2);
                }
            }
        }
        if (this.mode == 1) {
            if (this.Hvb == null || !this.Hvb.fQb()) {
                this.HAU.setText("");
                this.HAS.setVisibility(8);
            } else {
                this.HAU.setText(this.HBr);
                final cki xF2 = com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN.xF(true);
                if (xF2 != null) {
                    if (xF2.MpO == null || Util.isNullOrNil(xF2.MpO.LmX)) {
                        this.HAS.setVisibility(8);
                        this.wfU = getResources().getColor(R.color.FG_1);
                    } else {
                        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(xF2.MpO.LmX);
                        if (!Util.isNullOrNil(xF2.MpO.LmY) && !Util.isNullOrNil(xF2.MpO.pTL)) {
                            spannableStringBuilder.append((CharSequence) xF2.MpO.LmY);
                            spannableStringBuilder.setSpan(new q(new q.a() {
                                /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass4 */

                                @Override // com.tencent.mm.plugin.wallet_core.ui.q.a
                                public final void dF(View view) {
                                    AppMethodBeat.i(213969);
                                    Log.i("MicroMsg.WalletLqtSaveFetchUI", "click balance limit wording");
                                    f.a((Context) WalletLqtSaveFetchUI.this.getContext(), xF2.MpO.pTL, true, 1);
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(20216, 1, xF2.MpO.pTL);
                                    AppMethodBeat.o(213969);
                                }
                            }), xF2.MpO.LmX.length(), spannableStringBuilder.length(), 18);
                        }
                        this.HAS.setText(spannableStringBuilder);
                        this.HAS.setClickable(true);
                        this.HAS.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o(getContext()));
                        this.HAS.setVisibility(0);
                        this.wfU = getResources().getColor(R.color.FG_0);
                        AppMethodBeat.o(69015);
                        return;
                    }
                }
                AppMethodBeat.o(69015);
                return;
            }
        }
        AppMethodBeat.o(69015);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01aa A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void fX(final java.lang.String r14, final int r15) {
        /*
        // Method dump skipped, instructions count: 435
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.fX(java.lang.String, int):void");
    }

    private List<Bankcard> fNT() {
        AppMethodBeat.i(69016);
        List<Bankcard> xG = com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN.xG(this.mode == 1);
        if (xG == null || xG.size() == 0) {
            s.fOg();
            xG = s.fOh().fRJ();
        }
        LinkedList linkedList = new LinkedList();
        if (xG != null) {
            for (Bankcard bankcard : xG) {
                if (bankcard.fQb()) {
                    s.fOg();
                    if (!s.fOh().fRm()) {
                        linkedList.add(bankcard);
                    }
                }
                if (this.mode == 1 && (bankcard.field_support_lqt_turn_in == 1 || bankcard.fQb())) {
                    linkedList.add(bankcard);
                }
                if (this.mode == 2 && (bankcard.field_support_lqt_turn_out == 1 || bankcard.fQb())) {
                    linkedList.add(bankcard);
                }
            }
        }
        AppMethodBeat.o(69016);
        return linkedList;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(69017);
        Log.i("MicroMsg.WalletLqtSaveFetchUI", "onNewIntent");
        super.onNewIntent(intent);
        final List<Bankcard> fNT = fNT();
        this.HAN.HuP.jQ(this.mode, this.accountType).f(new com.tencent.mm.vending.c.a<Void, Void>() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass9 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Void call(Void r8) {
                boolean z;
                AppMethodBeat.i(213977);
                Iterator it = WalletLqtSaveFetchUI.r(WalletLqtSaveFetchUI.this).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Bankcard bankcard = (Bankcard) it.next();
                    Iterator it2 = fNT.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (bankcard.field_bindSerial.equals(((Bankcard) it2.next()).field_bindSerial)) {
                                z = true;
                                continue;
                                break;
                            }
                        } else {
                            z = false;
                            continue;
                            break;
                        }
                    }
                    if (!z) {
                        WalletLqtSaveFetchUI.this.HBx = bankcard.field_bindSerial;
                        break;
                    }
                }
                WalletLqtSaveFetchUI.o(WalletLqtSaveFetchUI.this);
                Void r0 = QZL;
                AppMethodBeat.o(213977);
                return r0;
            }
        });
        AppMethodBeat.o(69017);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(69018);
        if (this.mWcKeyboard == null || !this.mWcKeyboard.onKeyUp(i2, keyEvent)) {
            boolean onKeyUp = super.onKeyUp(i2, keyEvent);
            AppMethodBeat.o(69018);
            return onKeyUp;
        }
        AppMethodBeat.o(69018);
        return true;
    }

    @Override // com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.a
    public final void bO(float f2) {
    }

    private void fNU() {
        AppMethodBeat.i(69019);
        this.HBm.postDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass21 */

            {
                AppMethodBeat.i(160856);
                AppMethodBeat.o(160856);
            }

            public final void run() {
                AppMethodBeat.i(213993);
                int[] iArr = new int[2];
                int[] iArr2 = new int[2];
                WalletLqtSaveFetchUI.this.findViewById(R.id.exk).getLocationInWindow(iArr);
                WalletLqtSaveFetchUI.this.HBm.getLocationInWindow(iArr2);
                Log.d("MicroMsg.WalletLqtSaveFetchUI", "scroll y: %s", Integer.valueOf(iArr[1] - iArr2[1]));
                WalletLqtSaveFetchUI.this.HBm.scrollBy(0, iArr[1] - iArr2[1]);
                AppMethodBeat.o(213993);
            }
        }, 100);
        AppMethodBeat.o(69019);
    }

    private static int a(t tVar) {
        if (tVar == null || tVar.Htw == null) {
            return 0;
        }
        ddd ddd = tVar.Htw;
        if (ddd.MIk == null && ddd.MIl == null) {
            return 0;
        }
        if (ddd.MIk == null || ddd.MIl == null) {
            return 2;
        }
        return 1;
    }

    private void a(final com.tencent.mm.ui.widget.a.g gVar, t tVar) {
        AppMethodBeat.i(214024);
        if (gVar == null) {
            AppMethodBeat.o(214024);
            return;
        }
        int a2 = a(tVar);
        final ddd ddd = tVar.Htw;
        if (a2 == 2) {
            gVar.QOT = new g.a() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass22 */

                @Override // com.tencent.mm.ui.widget.a.g.a
                public final void onClick() {
                    AppMethodBeat.i(213994);
                    sf sfVar = ddd.MIk;
                    if (sfVar == null) {
                        sfVar = ddd.MIl;
                    }
                    WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, gVar, sfVar);
                    AppMethodBeat.o(213994);
                }
            };
            AppMethodBeat.o(214024);
            return;
        }
        if (a2 == 1) {
            gVar.a(new g.a() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass24 */

                @Override // com.tencent.mm.ui.widget.a.g.a
                public final void onClick() {
                    AppMethodBeat.i(213996);
                    WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, gVar, ddd.MIk);
                    AppMethodBeat.o(213996);
                }
            }, new g.a() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass25 */

                @Override // com.tencent.mm.ui.widget.a.g.a
                public final void onClick() {
                    AppMethodBeat.i(213997);
                    WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, gVar, ddd.MIl);
                    AppMethodBeat.o(213997);
                }
            });
        }
        AppMethodBeat.o(214024);
    }

    private void cC(String str, boolean z) {
        int i2;
        AppMethodBeat.i(182506);
        Log.i("MicroMsg.WalletLqtSaveFetchUI", "update tips: %s", str);
        long nF = f.nF(String.valueOf(str), "100");
        if (nF <= 0) {
            if (this.mode != 1) {
                this.HAU.setText(this.HBr);
                fNS();
            } else if (this.Hvb == null || !this.Hvb.fQb()) {
                this.HAU.setText("");
            } else {
                this.HAU.setText(this.HBr);
            }
            this.HAU.setTextColor(this.wfU);
            this.HBz = false;
            xP(false);
        } else if (this.mode == 1) {
            if (this.Hvb == null) {
                this.HBz = true;
                xP(true);
            } else if (this.Hvb.fQb()) {
                if (this.HBs != null && nF > ((long) lp(new StringBuilder().append(this.HBs.HVC).toString(), "100"))) {
                    this.HAU.setText(getString(R.string.iia));
                    this.HAU.setTextColor(getResources().getColor(R.color.Red_100));
                    this.HBz = false;
                    xP(false);
                } else if (com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN.HtH < 0 || nF <= ((long) com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN.HtH) || Util.isNullOrNil(com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN.HtE) || Util.isNullOrNil(com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN.HtF) || Util.isNullOrNil(com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN.HtG)) {
                    this.HAU.setText(this.HBr);
                    this.HAU.setTextColor(this.wfU);
                    this.HBz = true;
                    xP(true);
                } else {
                    q qVar = new q(new q.a() {
                        /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass26 */

                        @Override // com.tencent.mm.plugin.wallet_core.ui.q.a
                        public final void dF(View view) {
                            AppMethodBeat.i(213998);
                            Log.i("MicroMsg.WalletLqtSaveFetchUI", "click balance limit wording");
                            f.a((Context) WalletLqtSaveFetchUI.this.getContext(), com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN.HtG, true, 1);
                            AppMethodBeat.o(213998);
                        }
                    });
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                    spannableStringBuilder.append((CharSequence) com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN.HtE);
                    spannableStringBuilder.append((CharSequence) com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN.HtF);
                    spannableStringBuilder.setSpan(qVar, com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN.HtE.length(), spannableStringBuilder.length(), 18);
                    if (this.HAU.getText() == null || !this.HAU.getText().equals(spannableStringBuilder.toString())) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(17084, 9);
                    }
                    this.HAU.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o(getContext()));
                    this.HAU.setClickable(true);
                    this.HAU.setText(spannableStringBuilder);
                    this.HAU.setTextColor(this.wfU);
                    this.HBz = false;
                    xP(false);
                }
            } else if (this.Hvb.field_dayQuotaKind <= 0.0d || nF <= ((long) lp(new StringBuilder().append(this.Hvb.field_dayQuotaKind).toString(), "100"))) {
                this.HAU.setText("");
                this.HBz = true;
                xP(true);
            } else {
                this.HAU.setText(getString(R.string.iib));
                this.HAU.setTextColor(getResources().getColor(R.color.Red_100));
                this.HBz = false;
                xP(false);
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(21467, this.Hvb.field_bankcardType, Long.valueOf(nF), 1, Double.valueOf(this.Hvb.field_dayQuotaKind));
            }
        } else if (this.mode == 2) {
            boolean z2 = false;
            final cux fNa = x.fMZ().fNa();
            int i3 = fNa == null ? 0 : fNa.MAf;
            int i4 = fNa == null ? 0 : fNa.MAh;
            if (this.Hvb == null || !this.Hvb.fQb()) {
                i2 = i4;
            } else {
                i2 = getIntent().getIntExtra("lqt_balance", 0);
                z2 = true;
            }
            if (z2) {
                if (nF > ((long) i2)) {
                    this.HAU.setText(getString(R.string.igf));
                    this.HAU.setTextColor(getResources().getColor(R.color.Red_100));
                    this.HBz = false;
                    fNS();
                    xP(false);
                    this.HBn.setVisibility(8);
                } else {
                    this.HAU.setText(this.HBr);
                    this.HAU.setTextColor(this.wfU);
                    this.HBz = true;
                    I(z, str);
                    xP(true);
                    this.HBn.setVisibility(8);
                }
            } else if (nF > ((long) i3)) {
                this.HAU.setText(getString(R.string.igf));
                this.HAU.setTextColor(getResources().getColor(R.color.Red_100));
                this.HBn.setVisibility(8);
                this.HBz = false;
                fNS();
                xP(false);
                this.HBn.setVisibility(8);
            } else if (nF > ((long) i2)) {
                long nF2 = f.nF(this.HBE, "100");
                if (nF >= nF2) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(20287, 9);
                }
                Log.i("MicroMsg.WalletLqtSaveFetchUI", "balance > lqtBalance, balance: %s, previousBalance: %s", Long.valueOf(nF), Long.valueOf(nF2));
                String string = getString(R.string.ig1, new Object[]{Double.valueOf(lo(String.valueOf(i3), "100"))});
                this.HAU.setTextColor(this.wfU);
                this.HAU.setText(string);
                if (fNa == null || (TextUtils.isEmpty(fNa.MAq) && fNa.MAr == null)) {
                    this.HBn.setVisibility(0);
                    String string2 = getString(R.string.igs, new Object[]{Double.valueOf(lo(String.valueOf(i2), "100"))});
                    String str2 = string2 + getString(R.string.igv);
                    f.a(this.HBo, str2, string2.length(), str2.length(), new e(new e.a() {
                        /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass27 */

                        @Override // com.tencent.mm.wallet_core.ui.e.a
                        public final void bmr() {
                            AppMethodBeat.i(213999);
                            WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, fNa);
                            AppMethodBeat.o(213999);
                        }
                    }), getContext());
                    this.HBp.setVisibility(8);
                } else {
                    Log.i("MicroMsg.WalletLqtSaveFetchUI", "balance > lqtBalance, go to new redeem to bank exceed tips");
                    if (!TextUtils.isEmpty(fNa.MAq)) {
                        this.HBn.setVisibility(0);
                        String str3 = fNa.MAq;
                        try {
                            str3 = String.format(str3, f.formatMoney2f(lo(String.valueOf(i2), "100")));
                        } catch (Exception e2) {
                        }
                        this.HBp.setText(str3);
                        this.HBp.setVisibility(0);
                    }
                    acl acl = fNa.MAr;
                    if (acl != null && !TextUtils.isEmpty(acl.LmX)) {
                        String str4 = acl.LmX;
                        try {
                            str4 = String.format(str4, f.formatMoney2f(lo(String.valueOf(nF - ((long) i2)), "100")));
                        } catch (Exception e3) {
                        }
                        acl acl2 = new acl();
                        acl2.LmX = str4;
                        acl2.uSc = acl.uSc;
                        acl2.LmY = acl.LmY;
                        acl2.pTL = acl.pTL;
                        acl2.Hwr = acl.Hwr;
                        ddd ddd = fNa.MAs;
                        t.a aVar = new t.a();
                        aVar.Htw = ddd;
                        a(this.HBo, true, acl2, null, null, aVar.fMT(), 10);
                    }
                }
                this.HBz = false;
                fNS();
                xP(false);
            } else if (this.Hvb == null || this.Hvb.fQb() || this.Hvb.field_dayQuotaKind <= 0.0d || nF <= ((long) lp(new StringBuilder().append(this.Hvb.field_dayQuotaKind).toString(), "100"))) {
                this.HAU.setText(this.HBr);
                this.HAU.setTextColor(this.wfU);
                this.HBz = true;
                I(z, str);
                xP(true);
                this.HBn.setVisibility(8);
            } else {
                this.HBn.setVisibility(0);
                this.HBo.setText(getString(R.string.igi, new Object[]{Double.valueOf(this.Hvb.field_dayQuotaKind)}));
                this.HBp.setVisibility(8);
                this.HBz = false;
                fNS();
                xP(false);
            }
        }
        if (nF <= 0) {
            this.HBB = true;
            AppMethodBeat.o(182506);
            return;
        }
        this.HBB = false;
        AppMethodBeat.o(182506);
    }

    private com.tencent.mm.ui.widget.a.g a(final t tVar, final t tVar2, t tVar3) {
        LinearLayout linearLayout;
        AppMethodBeat.i(214025);
        if (tVar2 == null || tVar2.Htw == null) {
            AppMethodBeat.o(214025);
            return null;
        }
        final ddd ddd = tVar2.Htw;
        int i2 = 3;
        if (ddd.MIi == 0 && TextUtils.isEmpty(ddd.title)) {
            i2 = 0;
        }
        int a2 = a(tVar2);
        final com.tencent.mm.ui.widget.a.g gVar = new com.tencent.mm.ui.widget.a.g(getContext(), a2, i2);
        if (i2 == 3) {
            if (ddd.MIi == 0) {
                LinearLayout linearLayout2 = new LinearLayout(this);
                linearLayout2.setPadding(com.tencent.mm.cb.a.aH(this, R.dimen.ce), com.tencent.mm.cb.a.aH(this, R.dimen.cl), com.tencent.mm.cb.a.aH(this, R.dimen.ce), com.tencent.mm.cb.a.aH(this, R.dimen.ct));
                linearLayout2.setOrientation(1);
                linearLayout = linearLayout2;
                if (!TextUtils.isEmpty(ddd.title)) {
                    TextView textView = new TextView(this);
                    linearLayout2.addView(textView);
                    textView.setGravity(3);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(textView.getLayoutParams());
                    layoutParams.width = -1;
                    layoutParams.height = -2;
                    layoutParams.gravity = 3;
                    textView.setTextSize(1, 17.0f);
                    textView.setTextColor(getResources().getColor(R.color.fr));
                    ao.a(textView.getPaint(), 0.8f);
                    textView.setText(ddd.title);
                    textView.setLayoutParams(layoutParams);
                    linearLayout = linearLayout2;
                }
            } else {
                View inflate = View.inflate(this, R.layout.b3b, null);
                WeImageView weImageView = (WeImageView) inflate.findViewById(R.id.ewv);
                TextView textView2 = (TextView) inflate.findViewById(R.id.exq);
                ao.a(textView2.getPaint(), 0.8f);
                TextView textView3 = (TextView) inflate.findViewById(R.id.exp);
                if (ddd.MIi == 2) {
                    weImageView.setImageResource(R.raw.icons_outlined_back);
                    weImageView.setIconColor(getResources().getColor(R.color.FG_0));
                }
                weImageView.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass28 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(214000);
                        b bVar = new b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$34", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        gVar.bMo();
                        if (ddd.MIi == 2) {
                            com.tencent.mm.ui.widget.a.g a2 = WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, null, tVar, tVar2);
                            WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, a2, tVar);
                            a2.dGm();
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$34", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(214000);
                    }
                });
                if (TextUtils.isEmpty(ddd.title)) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setVisibility(0);
                    textView2.setText(ddd.title);
                }
                if (TextUtils.isEmpty(ddd.desc)) {
                    textView3.setVisibility(8);
                    linearLayout = inflate;
                } else {
                    textView3.setVisibility(0);
                    textView3.setText(ddd.desc);
                    linearLayout = inflate;
                }
            }
            gVar.hv(linearLayout);
        }
        acl acl = ddd.MIj;
        if (acl != null) {
            LinearLayout linearLayout3 = new LinearLayout(this);
            linearLayout3.setOrientation(1);
            if (!TextUtils.isEmpty(acl.LmX)) {
                TextView textView4 = new TextView(this);
                linearLayout3.addView(textView4);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(textView4.getLayoutParams());
                layoutParams2.width = -1;
                layoutParams2.height = -2;
                layoutParams2.topMargin = com.tencent.mm.cb.a.aH(this, R.dimen.ct);
                textView4.setTextColor(getResources().getColor(R.color.fr));
                if (ddd.MIi != 0 || TextUtils.isEmpty(ddd.title)) {
                    textView4.setTextSize(1, 17.0f);
                    ao.a(textView4.getPaint(), 0.8f);
                } else {
                    textView4.setTextSize(1, 15.0f);
                }
                textView4.setText(acl.LmX);
                textView4.setLayoutParams(layoutParams2);
            }
            if (!TextUtils.isEmpty(acl.LmY)) {
                TextView textView5 = new TextView(this);
                linearLayout3.addView(textView5);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(textView5.getLayoutParams());
                layoutParams3.width = -1;
                layoutParams3.height = -2;
                layoutParams3.topMargin = com.tencent.mm.cb.a.aH(this, R.dimen.ct);
                textView5.setTextSize(1, 14.0f);
                ao.a(textView5.getPaint(), 0.8f);
                textView5.setLayoutParams(layoutParams3);
                textView5.setText(acl.LmY);
                a(textView5, false, acl, gVar, tVar2, tVar3, tVar2.sQn);
                textView5.setClickable(true);
                textView5.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o(this));
            }
            gVar.setCustomView(linearLayout3);
            if (a2 == 0) {
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(linearLayout3.getLayoutParams());
                layoutParams4.bottomMargin = com.tencent.mm.cb.a.aH(this, R.dimen.cr);
                linearLayout3.setLayoutParams(layoutParams4);
            }
        }
        if (a2 == 2) {
            if (ddd.MIk != null) {
                gVar.T(ddd.MIk.dQx);
            }
            if (ddd.MIl != null) {
                gVar.T(ddd.MIl.dQx);
            }
            gVar.ape(1);
        }
        if (a2 == 1) {
            gVar.b(ddd.MIk.dQx, ddd.MIl.dQx);
        }
        AppMethodBeat.o(214025);
        return gVar;
    }

    private void a(TextView textView, boolean z, final acl acl, final com.tencent.mm.ui.widget.a.g gVar, final t tVar, final t tVar2, final int i2) {
        AppMethodBeat.i(214026);
        if (acl != null) {
            String str = "";
            if (z && !TextUtils.isEmpty(acl.LmX)) {
                str = acl.LmX;
            }
            if (!TextUtils.isEmpty(acl.LmY)) {
                String str2 = str + acl.LmY;
                f.a(textView, str2, str.length(), str2.length(), new e(new e.a() {
                    /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass29 */

                    @Override // com.tencent.mm.wallet_core.ui.e.a
                    public final void bmr() {
                        AppMethodBeat.i(214001);
                        Log.i("MicroMsg.WalletLqtSaveFetchUI", "showCommonPromptText, scene: %s, promptInfo.jump_type: %s", Integer.valueOf(i2), Integer.valueOf(acl.uSc));
                        if (i2 >= 0) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(20287, Integer.valueOf(i2));
                        }
                        switch (acl.uSc) {
                            case 1:
                                com.tencent.mm.ui.widget.a.g a2 = WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, tVar, tVar2, null);
                                WalletLqtSaveFetchUI.a(WalletLqtSaveFetchUI.this, a2, tVar2);
                                if (gVar != null) {
                                    gVar.bMo();
                                }
                                if (a2 != null && !a2.isShowing()) {
                                    a2.dGm();
                                    AppMethodBeat.o(214001);
                                    return;
                                }
                            case 2:
                                f.bn(WalletLqtSaveFetchUI.this.getContext(), acl.pTL);
                                AppMethodBeat.o(214001);
                                return;
                            case 3:
                                f.u(acl.Hwr, acl.pTL, 0, 1000);
                                break;
                        }
                        AppMethodBeat.o(214001);
                    }
                }), getContext());
                textView.setVisibility(0);
                AppMethodBeat.o(214026);
                return;
            } else if (!TextUtils.isEmpty(str)) {
                textView.setVisibility(0);
                textView.setText(str);
            }
        }
        AppMethodBeat.o(214026);
    }

    private void gf(boolean z) {
        AppMethodBeat.i(69021);
        this.mWcKeyboard.DH(z);
        AppMethodBeat.o(69021);
    }

    private void xP(boolean z) {
        AppMethodBeat.i(69022);
        Log.i("MicroMsg.WalletLqtSaveFetchUI", "check enable: %s, %s", Boolean.valueOf(z), Boolean.valueOf(this.HBC));
        if (!z || this.HBC) {
            gf(false);
            AppMethodBeat.o(69022);
            return;
        }
        if (this.mode == 1) {
            if (this.HAW.getVisibility() == 0) {
                if (!this.HAY.isChecked() || !this.HBz) {
                    gf(false);
                    AppMethodBeat.o(69022);
                    return;
                }
                gf(true);
                AppMethodBeat.o(69022);
                return;
            } else if (this.HBz) {
                gf(true);
                AppMethodBeat.o(69022);
                return;
            }
        } else if (!this.HBz || (this.HBl.getSelectRedeemType() == null && this.HBl.getRedeemTypeList() != null && !this.HBl.getRedeemTypeList().isEmpty())) {
            gf(false);
        } else {
            Object[] objArr = new Object[1];
            objArr[0] = this.HBl.getSelectRedeemType() == null ? null : Integer.valueOf(this.HBl.getSelectRedeemType().MJg);
            Log.v("MicroMsg.WalletLqtSaveFetchUI", "redeem type: %s", objArr);
            gf(true);
            AppMethodBeat.o(69022);
            return;
        }
        AppMethodBeat.o(69022);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBasePresenterUI, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(69023);
        super.onResume();
        Log.i("MicroMsg.WalletLqtSaveFetchUI", "onResume()");
        this.Hyh.alive();
        if (this.state == 3 && isHandleAutoShowNormalStWcKb()) {
            MMHandlerThread.postToMainThreadDelayed(this.HvB, 300);
        }
        this.state = 2;
        if (this.HBD) {
            this.HBD = false;
            zn znVar = new zn();
            znVar.efE.mode = this.mode;
            EventCenter.instance.publish(znVar);
        }
        AppMethodBeat.o(69023);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBasePresenterUI, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onPause() {
        AppMethodBeat.i(69024);
        super.onPause();
        Log.i("MicroMsg.WalletLqtSaveFetchUI", "onPause()");
        this.Hyh.dead();
        if (!this.mWcKeyboard.hgQ()) {
            this.state = 3;
        }
        AppMethodBeat.o(69024);
    }

    @Override // com.tencent.mm.ui.widget.a.c, com.tencent.mm.ui.MMActivity
    public void onDialogDismiss(Dialog dialog) {
        AppMethodBeat.i(69025);
        Log.i("MicroMsg.WalletLqtSaveFetchUI", "onDialogDismiss()");
        MMHandlerThread.postToMainThreadDelayed(this.jVx, 300);
        AppMethodBeat.o(69025);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean isHandleAutoShowNormalStWcKb() {
        AppMethodBeat.i(69026);
        Log.d("MicroMsg.WalletLqtSaveFetchUI", "isHandleAutoShowNormalStWcKb() mWxKbInterceptState:%s isAutoShowNormalStWcKb:%s", Boolean.valueOf(this.HvA), Boolean.valueOf(this.mWcKeyboard.hgR()));
        if (this.HvA || !this.mWcKeyboard.hgR()) {
            AppMethodBeat.o(69026);
            return false;
        }
        AppMethodBeat.o(69026);
        return true;
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBasePresenterUI
    public int getLayoutId() {
        return R.layout.c9p;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(69027);
        Log.i("MicroMsg.WalletLqtSaveFetchUI", "onActivityResult() requestCode:%s", Integer.valueOf(i2));
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1) {
            this.HAN.HuP.jQ(this.mode, this.accountType).f(new com.tencent.mm.vending.c.a<Object, Void>() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass35 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.vending.c.a
                public final /* synthetic */ Object call(Void r4) {
                    AppMethodBeat.i(214008);
                    WalletLqtSaveFetchUI.c(WalletLqtSaveFetchUI.this, WalletLqtSaveFetchUI.this.HAP.getText());
                    AppMethodBeat.o(214008);
                    return null;
                }
            });
            AppMethodBeat.o(69027);
            return;
        }
        if (intent != null) {
            intent.putExtra(ae.Huw, this.HBx);
        }
        ae aeVar = this.HAM;
        if (i2 == ae.Huu && i3 == -1) {
            String stringExtra = intent.getStringExtra(ae.Huw);
            Orders orders = (Orders) intent.getParcelableExtra("key_orders");
            if (!(orders == null || orders.HZd == null || orders.HZd.size() <= 0)) {
                Log.i("MicroMsg.LqtSaveFetchLogic", "%s onActivityResult, doQueryPurchaseResult, accountType: %s, reqkey: %s", Integer.valueOf(aeVar.hashCode()), Integer.valueOf(aeVar.accountType), orders.dDL);
                aeVar.dDM = orders.HZd.get(0).dDM;
                String str = aeVar.HuG.get(orders.dDL);
                if (!Util.isNullOrNil(str)) {
                    aeVar.HuA = str;
                }
                if (aeVar.Huz instanceof WalletLqtSaveFetchUI) {
                    ((WalletLqtSaveFetchUI) aeVar.Huz).HvA = true;
                    ((WalletLqtSaveFetchUI) aeVar.Huz).fNV();
                }
                aeVar.fW(stringExtra, 0);
            }
            AppMethodBeat.o(69027);
            return;
        }
        if (i2 == ae.Huv && i3 == -1) {
            String stringExtra2 = intent.getStringExtra(ae.Huw);
            String stringExtra3 = intent.getStringExtra("lqt_fetch_enc_pwd");
            String stringExtra4 = intent.getStringExtra("lqt_redeem_listid");
            Log.i("MicroMsg.LqtSaveFetchLogic", "%s onActivityResult, doRedeemFund, accountType: %s, redeemListId: %s", Integer.valueOf(aeVar.hashCode()), Integer.valueOf(aeVar.accountType), stringExtra4);
            if (aeVar.Huz instanceof WalletLqtSaveFetchUI) {
                ((WalletLqtSaveFetchUI) aeVar.Huz).HvA = true;
                ((WalletLqtSaveFetchUI) aeVar.Huz).fNV();
            }
            Log.i("MicroMsg.LqtSaveFetchLogic", "%s doRedeemFund, redeemListId: %s", Integer.valueOf(aeVar.hashCode()), stringExtra4);
            if (Util.isNullOrNil(aeVar.HuD)) {
                Log.i("MicroMsg.LqtSaveFetchLogic", "%s redeemListId is null!!, update from activity result: %s", Integer.valueOf(aeVar.hashCode()), stringExtra4);
                aeVar.HuD = stringExtra4;
            }
            String stringExtra5 = aeVar.Huz.getIntent().getStringExtra("operate_id");
            aeVar.Huz.showLoading(true);
            ad.c cVar = aeVar.Huy.Hur;
            int i4 = aeVar.HuC;
            com.tencent.mm.vending.g.g.b(Integer.valueOf(i4), stringExtra3, aeVar.HuD, Integer.valueOf(aeVar.accountType), stringExtra5).c(cVar).f(
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0180: INVOKE  
                  (wrap: com.tencent.mm.vending.g.c : 0x0177: INVOKE  (r0v17 com.tencent.mm.vending.g.c) = 
                  (wrap: com.tencent.mm.vending.g.c : 0x016e: INVOKE  (r0v16 com.tencent.mm.vending.g.c) = 
                  (wrap: com.tencent.mm.vending.g.c : 0x016a: INVOKE  (r0v15 com.tencent.mm.vending.g.c) = 
                  (wrap: java.lang.Integer : 0x0162: INVOKE  (r5v3 java.lang.Integer) = (r5v2 'i4' int) type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
                  (r3v1 'stringExtra3' java.lang.String)
                  (wrap: java.lang.String : 0x015e: IGET  (r6v3 java.lang.String) = (r2v1 'aeVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ae) com.tencent.mm.plugin.wallet.balance.model.lqt.ae.HuD java.lang.String)
                  (wrap: java.lang.Integer : 0x0166: INVOKE  (r7v7 java.lang.Integer) = 
                  (wrap: int : 0x0160: IGET  (r7v6 int) = (r2v1 'aeVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ae) com.tencent.mm.plugin.wallet.balance.model.lqt.ae.accountType int)
                 type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
                  (r0v14 'stringExtra5' java.lang.String)
                 type: STATIC call: com.tencent.mm.vending.g.g.b(java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object):com.tencent.mm.vending.g.c)
                  (r4v5 'cVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ad$c)
                 type: INTERFACE call: com.tencent.mm.vending.g.c.c(com.tencent.mm.vending.c.a):com.tencent.mm.vending.g.c)
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.ae$2 : 0x0174: CONSTRUCTOR  (r3v2 com.tencent.mm.plugin.wallet.balance.model.lqt.ae$2) = (r2v1 'aeVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ae), (r1v1 'stringExtra2' java.lang.String) call: com.tencent.mm.plugin.wallet.balance.model.lqt.ae.2.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.ae, java.lang.String):void type: CONSTRUCTOR)
                 type: INTERFACE call: com.tencent.mm.vending.g.c.f(com.tencent.mm.vending.c.a):com.tencent.mm.vending.g.c)
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.ae$13 : 0x017d: CONSTRUCTOR  (r1v2 com.tencent.mm.plugin.wallet.balance.model.lqt.ae$13) = (r2v1 'aeVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ae) call: com.tencent.mm.plugin.wallet.balance.model.lqt.ae.13.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.ae):void type: CONSTRUCTOR)
                 type: INTERFACE call: com.tencent.mm.vending.g.c.a(com.tencent.mm.vending.g.d$a):com.tencent.mm.vending.g.d in method: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.onActivityResult(int, int, android.content.Intent):void, file: classes6.dex
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
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
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
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0177: INVOKE  (r0v17 com.tencent.mm.vending.g.c) = 
                  (wrap: com.tencent.mm.vending.g.c : 0x016e: INVOKE  (r0v16 com.tencent.mm.vending.g.c) = 
                  (wrap: com.tencent.mm.vending.g.c : 0x016a: INVOKE  (r0v15 com.tencent.mm.vending.g.c) = 
                  (wrap: java.lang.Integer : 0x0162: INVOKE  (r5v3 java.lang.Integer) = (r5v2 'i4' int) type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
                  (r3v1 'stringExtra3' java.lang.String)
                  (wrap: java.lang.String : 0x015e: IGET  (r6v3 java.lang.String) = (r2v1 'aeVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ae) com.tencent.mm.plugin.wallet.balance.model.lqt.ae.HuD java.lang.String)
                  (wrap: java.lang.Integer : 0x0166: INVOKE  (r7v7 java.lang.Integer) = 
                  (wrap: int : 0x0160: IGET  (r7v6 int) = (r2v1 'aeVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ae) com.tencent.mm.plugin.wallet.balance.model.lqt.ae.accountType int)
                 type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
                  (r0v14 'stringExtra5' java.lang.String)
                 type: STATIC call: com.tencent.mm.vending.g.g.b(java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object):com.tencent.mm.vending.g.c)
                  (r4v5 'cVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ad$c)
                 type: INTERFACE call: com.tencent.mm.vending.g.c.c(com.tencent.mm.vending.c.a):com.tencent.mm.vending.g.c)
                  (wrap: com.tencent.mm.plugin.wallet.balance.model.lqt.ae$2 : 0x0174: CONSTRUCTOR  (r3v2 com.tencent.mm.plugin.wallet.balance.model.lqt.ae$2) = (r2v1 'aeVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ae), (r1v1 'stringExtra2' java.lang.String) call: com.tencent.mm.plugin.wallet.balance.model.lqt.ae.2.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.ae, java.lang.String):void type: CONSTRUCTOR)
                 type: INTERFACE call: com.tencent.mm.vending.g.c.f(com.tencent.mm.vending.c.a):com.tencent.mm.vending.g.c in method: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.onActivityResult(int, int, android.content.Intent):void, file: classes6.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:87)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:715)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                	... 27 more
                Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0174: CONSTRUCTOR  (r3v2 com.tencent.mm.plugin.wallet.balance.model.lqt.ae$2) = (r2v1 'aeVar' com.tencent.mm.plugin.wallet.balance.model.lqt.ae), (r1v1 'stringExtra2' java.lang.String) call: com.tencent.mm.plugin.wallet.balance.model.lqt.ae.2.<init>(com.tencent.mm.plugin.wallet.balance.model.lqt.ae, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.onActivityResult(int, int, android.content.Intent):void, file: classes6.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:806)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:746)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:367)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 33 more
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.wallet.balance.model.lqt.ae, state: GENERATED_AND_UNLOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                	... 39 more
                */
            /*
            // Method dump skipped, instructions count: 392
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.onActivityResult(int, int, android.content.Intent):void");
        }

        public final void xQ(boolean z) {
            this.HvA = z;
        }

        @Override // com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBasePresenterUI, com.tencent.mm.wallet_core.ui.WalletBaseUI
        public boolean onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            AppMethodBeat.i(69028);
            ae aeVar = this.HAM;
            Log.i("MicroMsg.LqtSaveFetchLogic", "onSceneEnd, errType: %s, errCode: %s, errMsg: %s, scene: %s", Integer.valueOf(i2), Integer.valueOf(i3), str, qVar);
            if (qVar instanceof com.tencent.mm.plugin.wallet_core.c.ad) {
                s.fOg();
                aeVar.HuE = s.fOh().Hwc;
                if (aeVar.jSi != null) {
                    aeVar.jSi.G(qVar);
                    aeVar.jSi.resume();
                }
            }
            Log.i("MicroMsg.WalletLqtSaveFetchUI", "onSceneEnd");
            fNR();
            boolean onSceneEnd = super.onSceneEnd(i2, i3, str, qVar);
            AppMethodBeat.o(69028);
            return onSceneEnd;
        }

        public final void biW() {
            AppMethodBeat.i(69029);
            if (this.jUV != null) {
                this.jUV.dismiss();
            }
            AppMethodBeat.o(69029);
        }

        @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtBasePresenterUI, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
        public void onDestroy() {
            AppMethodBeat.i(69030);
            super.onDestroy();
            fNV();
            com.tencent.mm.plugin.wallet.balance.model.lqt.u uVar = com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN;
            uVar.HtM.remove(this.HBH);
            com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN.Hty = null;
            this.HAM = null;
            this.HAN = null;
            AppMethodBeat.o(69030);
        }

        public final void fNV() {
            AppMethodBeat.i(69031);
            MMHandlerThread.removeRunnable(this.jVx);
            MMHandlerThread.removeRunnable(this.HvB);
            AppMethodBeat.o(69031);
        }

        private static double lo(String str, String str2) {
            double d2 = 0.0d;
            AppMethodBeat.i(69032);
            try {
                d2 = new BigDecimal(Util.getDouble(str.trim(), 0.0d) == 0.0d ? AppEventsConstants.EVENT_PARAM_VALUE_NO : str.trim()).divide(new BigDecimal(str2.trim()), 5, 2).doubleValue();
                AppMethodBeat.o(69032);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", e2, "", new Object[0]);
                AppMethodBeat.o(69032);
            }
            return d2;
        }

        private static int lp(String str, String str2) {
            int i2 = 0;
            AppMethodBeat.i(69033);
            try {
                double d2 = Util.getDouble(str, 0.0d);
                double d3 = Util.getDouble(str2, 0.0d);
                if (d2 == 0.0d) {
                    str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                }
                BigDecimal bigDecimal = new BigDecimal(str);
                if (d3 == 0.0d) {
                    str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                }
                i2 = bigDecimal.multiply(new BigDecimal(str2)).intValue();
                AppMethodBeat.o(69033);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", e2, "", new Object[0]);
                AppMethodBeat.o(69033);
            }
            return i2;
        }

        static /* synthetic */ boolean a(WalletLqtSaveFetchUI walletLqtSaveFetchUI, boolean z) {
            AppMethodBeat.i(214028);
            if (walletLqtSaveFetchUI.mode == 2) {
                if (z) {
                    walletLqtSaveFetchUI.fNQ();
                    AppMethodBeat.o(214028);
                    return false;
                }
                walletLqtSaveFetchUI.Hvb = com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN.xE(false);
                if (walletLqtSaveFetchUI.Hvb == null) {
                    Log.i("MicroMsg.WalletLqtSaveFetchUI", "mDefaultBankcard is null!!!");
                    walletLqtSaveFetchUI.fNQ();
                    AppMethodBeat.o(214028);
                    return false;
                }
            }
            AppMethodBeat.o(214028);
            return true;
        }

        static /* synthetic */ void g(WalletLqtSaveFetchUI walletLqtSaveFetchUI) {
            AppMethodBeat.i(214029);
            final amh amh = com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN.HtL;
            if (amh != null) {
                walletLqtSaveFetchUI.HBC = amh.LuZ == 1;
                if (amh.Lva == 1 && !walletLqtSaveFetchUI.HBF) {
                    walletLqtSaveFetchUI.fX(null, -1);
                    walletLqtSaveFetchUI.HBF = true;
                }
                if (amh.LuY != null && !Util.isNullOrNil(amh.LuY.title)) {
                    walletLqtSaveFetchUI.HBq.setVisibility(0);
                    walletLqtSaveFetchUI.HBq.setText(amh.LuY.title);
                    if (!Util.isNullOrNil(amh.LuY.yUB)) {
                        walletLqtSaveFetchUI.HBq.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass44 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(214020);
                                b bVar = new b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                if (amh.LuY.Myg != 1) {
                                    if (amh.LuY.Myg == 2) {
                                        f.bn(WalletLqtSaveFetchUI.this.getContext(), amh.LuY.yUB);
                                    } else if (amh.LuY.Myg == 3) {
                                        f.u(amh.LuY.KZR, amh.LuY.yUB, 0, 1061);
                                    }
                                }
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(214020);
                            }
                        });
                        AppMethodBeat.o(214029);
                        return;
                    }
                }
            } else {
                walletLqtSaveFetchUI.HBC = false;
                walletLqtSaveFetchUI.HBq.setVisibility(8);
            }
            AppMethodBeat.o(214029);
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        static /* synthetic */ void aet(int i2) {
            AppMethodBeat.i(214032);
            switch (i2) {
                case 0:
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(20287, 15);
                    AppMethodBeat.o(214032);
                    return;
                case 1:
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(17084, 27);
                    AppMethodBeat.o(214032);
                    return;
                case 2:
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(17084, 29);
                    break;
            }
            AppMethodBeat.o(214032);
        }

        static /* synthetic */ void p(WalletLqtSaveFetchUI walletLqtSaveFetchUI) {
            boolean z = true;
            AppMethodBeat.i(69042);
            Log.i("MicroMsg.WalletLqtSaveFetchUI", "reportSelectCardClicked, has show tips: %s", Boolean.valueOf(walletLqtSaveFetchUI.HBk));
            if (walletLqtSaveFetchUI.HBk) {
                walletLqtSaveFetchUI.HBk = false;
                walletLqtSaveFetchUI.HBb.setVisibility(8);
                com.tencent.mm.plugin.wallet.balance.model.lqt.u uVar = com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN;
                if (walletLqtSaveFetchUI.mode != 1) {
                    z = false;
                }
                cki xF = uVar.xF(z);
                if (xF != null) {
                    xF.MpP = null;
                }
            }
            AppMethodBeat.o(69042);
        }

        static /* synthetic */ void c(WalletLqtSaveFetchUI walletLqtSaveFetchUI, String str) {
            AppMethodBeat.i(214034);
            walletLqtSaveFetchUI.cC(str, false);
            AppMethodBeat.o(214034);
        }

        static /* synthetic */ void q(WalletLqtSaveFetchUI walletLqtSaveFetchUI) {
            boolean z;
            AppMethodBeat.i(69043);
            Bundle bundle = new Bundle();
            PayInfo payInfo = (PayInfo) walletLqtSaveFetchUI.getInput().get("key_pay_info");
            if (payInfo == null) {
                payInfo = new PayInfo();
                payInfo.dDL = "";
                if (walletLqtSaveFetchUI.mode == 1) {
                    if (walletLqtSaveFetchUI.accountType == 0) {
                        payInfo.dVv = 45;
                    } else {
                        payInfo.dVv = 52;
                    }
                } else if (walletLqtSaveFetchUI.accountType == 0) {
                    payInfo.dVv = 51;
                } else {
                    payInfo.dVv = 53;
                }
            }
            if (payInfo != null) {
                bundle.putParcelable("key_pay_info", payInfo);
            }
            if (walletLqtSaveFetchUI.mode == 1) {
                if (walletLqtSaveFetchUI.accountType == 0) {
                    bundle.putInt("key_scene", 45);
                } else {
                    bundle.putInt("key_scene", 52);
                }
                bundle.putInt("key_bind_scene", 16);
            } else {
                if (walletLqtSaveFetchUI.accountType == 0) {
                    bundle.putInt("key_scene", 51);
                } else {
                    bundle.putInt("key_scene", 53);
                }
                bundle.putInt("key_bind_scene", 17);
            }
            bundle.putBoolean("key_need_bind_response", true);
            bundle.putInt("key_bind_scene", 0);
            bundle.putBoolean("key_is_bind_bankcard", true);
            com.tencent.mm.wallet_core.b.hgC();
            if (com.tencent.mm.wallet_core.b.b(b.a.clicfg_open_kinda_bind_card, true)) {
                EventCenter.instance.add(walletLqtSaveFetchUI.AJa);
                Log.d("MicroMsg.WalletLqtSaveFetchUI", "startKindaBindCard:true");
                ab.mg(6, bundle.getInt("key_bind_scene"));
                z.aqh(bundle.getInt("key_bind_scene"));
                ((com.tencent.mm.pluginsdk.wallet.a) com.tencent.mm.kernel.g.af(com.tencent.mm.pluginsdk.wallet.a.class)).startBindCardUseCase(walletLqtSaveFetchUI, bundle);
                z = true;
            } else {
                Log.d("MicroMsg.WalletLqtSaveFetchUI", "startKindaBindCard:false");
                z = false;
            }
            if (!z) {
                com.tencent.mm.wallet_core.a.a(walletLqtSaveFetchUI, b.class, bundle, new d.a() {
                    /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass10 */

                    @Override // com.tencent.mm.wallet_core.d.a
                    public final Intent q(int i2, Bundle bundle) {
                        AppMethodBeat.i(213978);
                        Log.i("MicroMsg.WalletLqtSaveFetchUI", "feedbackData: %s", bundle);
                        AppMethodBeat.o(213978);
                        return null;
                    }
                });
            }
            AppMethodBeat.o(69043);
        }

        static /* synthetic */ void v(WalletLqtSaveFetchUI walletLqtSaveFetchUI) {
            AppMethodBeat.i(214038);
            walletLqtSaveFetchUI.HBl.removeAllViews();
            AppMethodBeat.o(214038);
        }

        static /* synthetic */ void w(WalletLqtSaveFetchUI walletLqtSaveFetchUI) {
            ddd ddd;
            String str;
            AppMethodBeat.i(214039);
            long nF = f.nF(walletLqtSaveFetchUI.HAP.getText(), "100");
            boolean z = walletLqtSaveFetchUI.Hvb != null && walletLqtSaveFetchUI.Hvb.fQb();
            cux fNa = x.fMZ().fNa();
            if (nF > 0 && z && walletLqtSaveFetchUI.mode == 2 && fNa != null && fNa.MAo != null) {
                int intExtra = walletLqtSaveFetchUI.getIntent().getIntExtra("lqt_balance", 0);
                int i2 = fNa == null ? 0 : fNa.MAh;
                Log.i("MicroMsg.WalletLqtSaveFetchUI", "showFetchToBalanceTips, lqtBalance: %s, bankBalance: %s", Integer.valueOf(intExtra), Integer.valueOf(i2));
                if (nF > ((long) (intExtra - i2))) {
                    ddd ddd2 = fNa.MAo;
                    acl acl = ddd2.MIj;
                    if (acl == null || TextUtils.isEmpty(acl.LmX)) {
                        ddd = ddd2;
                    } else {
                        String str2 = acl.LmX;
                        long j2 = nF - ((long) (intExtra - i2));
                        double max = Math.max(((double) j2) / 1000.0d, 10.0d);
                        walletLqtSaveFetchUI.HBG = f.formatMoney2f(lo(String.valueOf(j2), "100"));
                        try {
                            str = String.format(str2, walletLqtSaveFetchUI.HBG, f.formatMoney2f(lo(String.valueOf(max), "100")));
                        } catch (Exception e2) {
                            str = str2;
                        }
                        acl acl2 = new acl();
                        acl2.Hwr = acl.Hwr;
                        acl2.pTL = acl.pTL;
                        acl2.LmY = acl.LmY;
                        acl2.uSc = acl.uSc;
                        acl2.LmX = str;
                        ddd = new ddd();
                        ddd.MIk = ddd2.MIk;
                        ddd.MIl = ddd2.MIl;
                        ddd.title = ddd2.title;
                        ddd.desc = ddd2.desc;
                        ddd.MIi = ddd2.MIi;
                        ddd.MIj = acl2;
                    }
                    walletLqtSaveFetchUI.hideWcKb();
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(20287, 11);
                    t.a aVar = new t.a();
                    aVar.Htw = ddd;
                    aVar.sQn = 12;
                    t fMT = aVar.fMT();
                    t.a aVar2 = new t.a();
                    aVar2.Htw = fNa.MAp;
                    com.tencent.mm.ui.widget.a.g a2 = walletLqtSaveFetchUI.a((t) null, fMT, aVar2.fMT());
                    walletLqtSaveFetchUI.a(a2, fMT);
                    a2.dGm();
                    AppMethodBeat.o(214039);
                    return;
                }
            }
            if (walletLqtSaveFetchUI.hEZ != null) {
                walletLqtSaveFetchUI.hEZ.onClick(null);
            }
            AppMethodBeat.o(214039);
        }

        static /* synthetic */ void B(WalletLqtSaveFetchUI walletLqtSaveFetchUI) {
            AppMethodBeat.i(214042);
            Log.i("MicroMsg.WalletLqtSaveFetchUI", "showHalfBottomDialogForSlowRedeem");
            cux fNa = x.fMZ().fNa();
            if (fNa == null || fNa.MAk == null) {
                Log.i("MicroMsg.WalletLqtSaveFetchUI", "showHalfBottomDialogForSlowRedeem res == null ||  res.redeem_displayed_info == null");
                AppMethodBeat.o(214042);
                return;
            }
            Iterator<jf> it = fNa.MAk.iterator();
            while (it.hasNext()) {
                jf next = it.next();
                if (next.KNw.equals(walletLqtSaveFetchUI.Hvb.field_bindSerial)) {
                    Log.d("MicroMsg.WalletLqtSaveFetchUI", "show bankcard arrive time");
                    walletLqtSaveFetchUI.HBl.w(next.KNM, false);
                    dys dys = next.KNN;
                    walletLqtSaveFetchUI.hideTenpayKB();
                    walletLqtSaveFetchUI.hideWcKb();
                    final com.tencent.mm.ui.widget.a.g gVar = new com.tencent.mm.ui.widget.a.g(walletLqtSaveFetchUI.getContext(), 1, 3);
                    gVar.b(walletLqtSaveFetchUI.getString(R.string.igh), walletLqtSaveFetchUI.getString(R.string.igy));
                    gVar.a(new g.a() {
                        /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass37 */

                        @Override // com.tencent.mm.ui.widget.a.g.a
                        public final void onClick() {
                            AppMethodBeat.i(214012);
                            gVar.bMo();
                            WalletLqtSaveFetchUI.this.showWcKb();
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(20287, 5);
                            AppMethodBeat.o(214012);
                        }
                    }, new g.a() {
                        /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass38 */

                        @Override // com.tencent.mm.ui.widget.a.g.a
                        public final void onClick() {
                            AppMethodBeat.i(214013);
                            Log.i("MicroMsg.WalletLqtSaveFetchUI", "click fetch");
                            WalletLqtSaveFetchUI.G(WalletLqtSaveFetchUI.this);
                            gVar.bMo();
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(20287, 6);
                            AppMethodBeat.o(214013);
                        }
                    });
                    View inflate = View.inflate(walletLqtSaveFetchUI.getContext(), R.layout.b2y, null);
                    ((TextView) inflate.findViewById(R.id.dmw)).setText(dys.MPw);
                    gVar.setHeaderView(inflate);
                    LinearLayout linearLayout = new LinearLayout(walletLqtSaveFetchUI);
                    linearLayout.setOrientation(1);
                    Iterator<ahq> it2 = dys.MYg.iterator();
                    while (it2.hasNext()) {
                        final ahq next2 = it2.next();
                        if (!(next2 == null || next2.title == null)) {
                            LinearLayout linearLayout2 = (LinearLayout) View.inflate(walletLqtSaveFetchUI, R.layout.b2x, null);
                            linearLayout2.setBackgroundColor(walletLqtSaveFetchUI.getContext().getResources().getColor(R.color.f3048f));
                            TextView textView = (TextView) linearLayout2.findViewById(R.id.dmu);
                            String str = next2.title;
                            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
                            String str2 = "";
                            if (!Util.isNullOrNil(next2.desc)) {
                                str2 = next2.desc;
                            }
                            if (!Util.isNullOrNil(str2)) {
                                spannableStringBuilder.setSpan(new q("#576B95", new q.a() {
                                    /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass39 */

                                    @Override // com.tencent.mm.plugin.wallet_core.ui.q.a
                                    public final void dF(View view) {
                                        AppMethodBeat.i(214014);
                                        f.o(WalletLqtSaveFetchUI.this.getContext(), next2.yUB, true);
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(20287, 7);
                                        AppMethodBeat.o(214014);
                                    }
                                }), str.indexOf(str2), str2.length() + str.indexOf(str2), 18);
                                textView.setClickable(true);
                                textView.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o(walletLqtSaveFetchUI));
                            }
                            textView.setText(spannableStringBuilder);
                            linearLayout.addView(linearLayout2);
                        }
                    }
                    gVar.setCustomView(linearLayout);
                    gVar.dGm();
                    walletLqtSaveFetchUI.HBl.setVisibility(4);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(20287, 4);
                }
            }
            AppMethodBeat.o(214042);
        }

        static /* synthetic */ void a(WalletLqtSaveFetchUI walletLqtSaveFetchUI, com.tencent.mm.ui.widget.a.g gVar, sf sfVar) {
            AppMethodBeat.i(214043);
            if (gVar == null || sfVar == null) {
                AppMethodBeat.o(214043);
                return;
            }
            switch (sfVar.action) {
                case 1:
                    walletLqtSaveFetchUI.finish();
                    AppMethodBeat.o(214043);
                    return;
                case 2:
                    f.bn(walletLqtSaveFetchUI.getContext(), sfVar.url);
                    AppMethodBeat.o(214043);
                    return;
                case 3:
                    f.u(sfVar.KZR, sfVar.url, 0, 1000);
                    AppMethodBeat.o(214043);
                    return;
                case 4:
                    gVar.bMo();
                    if ("weixin://weui/selectbackcarddialog".equals(sfVar.url)) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(20287, 14);
                        walletLqtSaveFetchUI.fX(walletLqtSaveFetchUI.HBG, 0);
                        AppMethodBeat.o(214043);
                        return;
                    } else if ("weixin://mmpaylqt/lqtfetchui".equals(sfVar.url)) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(20287, 13);
                        if (walletLqtSaveFetchUI.hEZ != null) {
                            walletLqtSaveFetchUI.hEZ.onClick(null);
                            AppMethodBeat.o(214043);
                            return;
                        }
                    }
                    break;
                default:
                    gVar.bMo();
                    break;
            }
            AppMethodBeat.o(214043);
        }

        static /* synthetic */ void a(WalletLqtSaveFetchUI walletLqtSaveFetchUI, cux cux) {
            AppMethodBeat.i(214044);
            String str = "";
            if (cux == null || cux.MAi == null || cux.MAi.isEmpty()) {
                AppMethodBeat.o(214044);
                return;
            }
            Iterator<ahq> it = cux.MAi.iterator();
            String str2 = "";
            while (it.hasNext()) {
                ahq next = it.next();
                if (!(next == null || next.title == null)) {
                    str = next.title;
                    str2 = next.desc;
                }
            }
            final com.tencent.mm.ui.widget.a.g gVar = new com.tencent.mm.ui.widget.a.g(walletLqtSaveFetchUI.getContext(), 2, 3);
            gVar.T(walletLqtSaveFetchUI.getResources().getString(R.string.w0));
            gVar.ape(1);
            gVar.QOT = new g.a() {
                /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass30 */

                @Override // com.tencent.mm.ui.widget.a.g.a
                public final void onClick() {
                    AppMethodBeat.i(214002);
                    gVar.bMo();
                    AppMethodBeat.o(214002);
                }
            };
            View inflate = View.inflate(walletLqtSaveFetchUI.getContext(), R.layout.b2w, null);
            TextView textView = (TextView) inflate.findViewById(R.id.dmw);
            if (!Util.isNullOrNil(str)) {
                textView.setText(str);
            }
            textView.getPaint().setFakeBoldText(true);
            gVar.setHeaderView(inflate);
            View inflate2 = View.inflate(walletLqtSaveFetchUI.getContext(), R.layout.b2v, null);
            TextView textView2 = (TextView) inflate2.findViewById(R.id.dmu);
            if (!Util.isNullOrNil(str2)) {
                textView2.setText(str2);
            }
            gVar.setCustomView(inflate2);
            gVar.dGm();
            AppMethodBeat.o(214044);
        }

        static /* synthetic */ void G(WalletLqtSaveFetchUI walletLqtSaveFetchUI) {
            AppMethodBeat.i(214047);
            Log.i("MicroMsg.WalletLqtSaveFetchUI", "beginSlowRedeemProcess()");
            final int lp = lp(walletLqtSaveFetchUI.HAP.getText(), "100");
            if (lp > 0) {
                walletLqtSaveFetchUI.hideWcKb();
                if (walletLqtSaveFetchUI.mode == 2) {
                    Log.i("MicroMsg.WalletLqtSaveFetchUI", "click fetch lqt");
                    if (!walletLqtSaveFetchUI.aUQ(com.tencent.mm.plugin.wallet.balance.model.lqt.u.HtN.HtK)) {
                        ja jaVar = null;
                        if (walletLqtSaveFetchUI.Hvb != null && !walletLqtSaveFetchUI.Hvb.fQb()) {
                            jaVar = new ja();
                            jaVar.ynT = walletLqtSaveFetchUI.Hvb.field_bankName;
                            jaVar.dDj = walletLqtSaveFetchUI.Hvb.field_bankcardType;
                            jaVar.KNw = walletLqtSaveFetchUI.Hvb.field_bindSerial;
                            jaVar.AOk = walletLqtSaveFetchUI.Hvb.field_bankcardTail;
                        }
                        walletLqtSaveFetchUI.HAN.HuN.a(lp, walletLqtSaveFetchUI.accountType, 1, jaVar).f(new com.tencent.mm.vending.c.a<Void, dlv>() {
                            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass41 */

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                            @Override // com.tencent.mm.vending.c.a
                            public final /* synthetic */ Void call(dlv dlv) {
                                AppMethodBeat.i(214018);
                                Void a2 = a(dlv);
                                AppMethodBeat.o(214018);
                                return a2;
                            }

                            private Void a(dlv dlv) {
                                AppMethodBeat.i(214017);
                                Log.i("MicroMsg.WalletLqtSaveFetchUI", "redeem succ: %s, is_realtime_arrivial: %s, is_redeem_into_pocket: %s", dlv, Boolean.valueOf(dlv.MPt), Boolean.valueOf(dlv.MPu));
                                WalletLqtSaveFetchUI.this.fNV();
                                if (!dlv.MPt || !dlv.MPu) {
                                    Intent intent = new Intent(WalletLqtSaveFetchUI.this, WalletLqtSaveFetchFinishProgressNewUI.class);
                                    try {
                                        intent.putExtra("key_redeem_res", dlv.toByteArray());
                                    } catch (Exception e2) {
                                        Log.printErrStackTrace("MicroMsg.WalletLqtSaveFetchUI", e2, "pass redeemFundRes error: %s", e2.getMessage());
                                    }
                                    WalletLqtSaveFetchUI walletLqtSaveFetchUI = WalletLqtSaveFetchUI.this;
                                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                    com.tencent.mm.hellhoundlib.a.a.a(walletLqtSaveFetchUI, bl.axQ(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$46", "call", "(Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    walletLqtSaveFetchUI.startActivity((Intent) bl.pG(0));
                                    com.tencent.mm.hellhoundlib.a.a.a(walletLqtSaveFetchUI, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$46", "call", "(Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                } else {
                                    Intent intent2 = new Intent(WalletLqtSaveFetchUI.this, WalletLqtSaveFetchFinishUI.class);
                                    intent2.putExtra("key_amount", f.a(new StringBuilder().append(lp).toString(), "100", 2, RoundingMode.HALF_UP));
                                    intent2.putExtra("key_mode", 2);
                                    WalletLqtSaveFetchUI walletLqtSaveFetchUI2 = WalletLqtSaveFetchUI.this;
                                    com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                                    com.tencent.mm.hellhoundlib.a.a.a(walletLqtSaveFetchUI2, bl2.axQ(), "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$46", "call", "(Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    walletLqtSaveFetchUI2.startActivity((Intent) bl2.pG(0));
                                    com.tencent.mm.hellhoundlib.a.a.a(walletLqtSaveFetchUI2, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchUI$46", "call", "(Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;)Ljava/lang/Void;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                }
                                WalletLqtSaveFetchUI.this.finish();
                                Void r0 = QZL;
                                AppMethodBeat.o(214017);
                                return r0;
                            }
                        }).a(new d.a() {
                            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass40 */

                            @Override // com.tencent.mm.vending.g.d.a
                            public final void cn(Object obj) {
                                String string;
                                boolean z = false;
                                AppMethodBeat.i(214016);
                                WalletLqtSaveFetchUI.this.HvA = false;
                                WalletLqtSaveFetchUI.this.biW();
                                WalletLqtSaveFetchUI.this.hideLoading();
                                if (obj != null) {
                                    if (obj instanceof dlv) {
                                        z = com.tencent.mm.wallet_core.d.h.a(WalletLqtSaveFetchUI.this, null, 1000, ((dlv) obj).pTZ, ((dlv) obj).pUa);
                                    }
                                    if (!z) {
                                        if (obj instanceof String) {
                                            string = obj.toString();
                                        } else {
                                            string = WalletLqtSaveFetchUI.this.getString(R.string.ih4);
                                        }
                                        h.d(WalletLqtSaveFetchUI.this, string, "", new DialogInterface.OnClickListener() {
                                            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchUI.AnonymousClass40.AnonymousClass1 */

                                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                                AppMethodBeat.i(214015);
                                                Log.i("MicroMsg.WalletLqtSaveFetchUI", "fetch MMAlert Interrupt click");
                                                AppMethodBeat.o(214015);
                                            }
                                        });
                                    }
                                }
                                AppMethodBeat.o(214016);
                            }
                        });
                    }
                }
            }
            AppMethodBeat.o(214047);
        }
    }
