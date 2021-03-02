package com.tencent.mm.plugin.wallet_ecard.b;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.plugin.wallet.balance.model.lqt.ai;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.plugin.wallet_core.ui.WalletVerifyCodeUI;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardBindCardListUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardCheckOtherCardUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardElementInputUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletECardFinishUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletOpenECardProxyUI;
import com.tencent.mm.plugin.wallet_ecard.ui.WalletOpenLqbProxyUI;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.cdf;
import com.tencent.mm.protocal.protobuf.ckj;
import com.tencent.mm.protocal.protobuf.cvo;
import com.tencent.mm.protocal.protobuf.cww;
import com.tencent.mm.protocal.protobuf.je;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.d.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.io.IOException;

public class b extends com.tencent.mm.wallet_core.d {
    static /* synthetic */ String e(b bVar) {
        AppMethodBeat.i(71745);
        String fUl = bVar.fUl();
        AppMethodBeat.o(71745);
        return fUl;
    }

    static /* synthetic */ int n(b bVar) {
        AppMethodBeat.i(71746);
        int dJE = bVar.dJE();
        AppMethodBeat.o(71746);
        return dJE;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final com.tencent.mm.wallet_core.d a(Activity activity, Bundle bundle) {
        AppMethodBeat.i(71735);
        b(activity, WalletOpenECardProxyUI.class, bundle);
        Log.i("MicroMsg.OpenECardProcess", "start open ecard: %s", Integer.valueOf(dJE()));
        AppMethodBeat.o(71735);
        return this;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void a(Activity activity, int i2, Bundle bundle) {
        AppMethodBeat.i(71736);
        if (activity instanceof WalletCheckPwdUI) {
            if (bundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.IpI, false)) {
                Log.i("MicroMsg.OpenECardProcess", "forward, is reuse exist card");
                this.dQL.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.IpI, true);
                b(activity, WalletOpenECardProxyUI.class, bundle);
                activity.finish();
                AppMethodBeat.o(71736);
                return;
            }
            b(activity, WalletECardBindCardListUI.class, (Bundle) null);
            AppMethodBeat.o(71736);
        } else if (!(activity instanceof WalletECardBindCardListUI)) {
            if (!(activity instanceof WalletVerifyCodeUI)) {
                if (activity instanceof WalletECardCheckOtherCardUI) {
                    boolean z = bundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.IpG, false);
                    boolean z2 = bundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.IpF);
                    Log.i("MicroMsg.OpenECardProcess", "input card elem: %s, verify sms: %s", Boolean.valueOf(z), Boolean.valueOf(z2));
                    if (z) {
                        b(activity, WalletECardElementInputUI.class, (Bundle) null);
                        AppMethodBeat.o(71736);
                        return;
                    } else if (z2) {
                        bundle.putBoolean("key_need_confirm_finish", true);
                        a(activity, WalletVerifyCodeUI.class, (Bundle) null, bundle);
                        AppMethodBeat.o(71736);
                        return;
                    }
                } else if (!(activity instanceof WalletECardElementInputUI)) {
                    if (activity instanceof WalletOpenECardProxyUI) {
                        boolean z3 = bundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.Ipt, false);
                        this.dQL.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.Ipt, z3);
                        String string = this.dQL.getString(com.tencent.mm.plugin.wallet_ecard.a.a.Ipr);
                        int dJE = dJE();
                        int i3 = bundle.getInt("key_ecard_proxy_action", 1);
                        Log.i("MicroMsg.OpenECardProcess", "forward openScene: %s, token==null: %s, isTokenInvalid: %s, action: %s", Integer.valueOf(dJE), Boolean.valueOf(Util.isNullOrNil(string)), Boolean.valueOf(z3), Integer.valueOf(i3));
                        if (i3 == 1) {
                            if (Util.isNullOrNil(string)) {
                                a(activity, WalletCheckPwdUI.class, bundle, 1);
                                AppMethodBeat.o(71736);
                                return;
                            } else if (z3) {
                                b(activity, WalletCheckPwdUI.class, bundle);
                                AppMethodBeat.o(71736);
                                return;
                            } else if (dJE == 3) {
                                b(activity, WalletECardBindCardListUI.class, (Bundle) null);
                                AppMethodBeat.o(71736);
                                return;
                            }
                        } else if (bundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.IpF)) {
                            bundle.putBoolean("key_need_confirm_finish", true);
                            a(activity, WalletVerifyCodeUI.class, (Bundle) null, bundle);
                            AppMethodBeat.o(71736);
                            return;
                        }
                    }
                    AppMethodBeat.o(71736);
                } else if (bundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.IpF)) {
                    bundle.putBoolean("key_need_confirm_finish", true);
                    a(activity, WalletVerifyCodeUI.class, (Bundle) null, bundle);
                    AppMethodBeat.o(71736);
                    return;
                } else {
                    i(activity, bundle);
                    AppMethodBeat.o(71736);
                    return;
                }
            }
            i(activity, bundle);
            AppMethodBeat.o(71736);
        } else if (this.dQL.getInt(com.tencent.mm.plugin.wallet_ecard.a.a.Ipu, com.tencent.mm.plugin.wallet_ecard.a.a.IpL) != com.tencent.mm.plugin.wallet_ecard.a.a.IpL) {
            b(activity, WalletECardCheckOtherCardUI.class, (Bundle) null);
            AppMethodBeat.o(71736);
        } else if (bundle.getBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.IpF)) {
            bundle.putBoolean("key_need_confirm_finish", true);
            a(activity, WalletVerifyCodeUI.class, (Bundle) null, bundle);
            AppMethodBeat.o(71736);
        } else {
            i(activity, bundle);
            AppMethodBeat.o(71736);
        }
    }

    private void i(Activity activity, Bundle bundle) {
        AppMethodBeat.i(71737);
        Log.printInfoStack("MicroMsg.OpenECardProcess", "gotoFinishUI, openScene: %s", Integer.valueOf(dJE()));
        if (dJE() == 3) {
            bundle.putInt(com.tencent.mm.plugin.wallet_ecard.a.a.Ipq, 3);
            bundle.putString(com.tencent.mm.plugin.wallet_ecard.a.a.Ipw, this.dQL.getString(com.tencent.mm.plugin.wallet_ecard.a.a.Ipw, ""));
            b(activity, WalletOpenLqbProxyUI.class, bundle);
            AppMethodBeat.o(71737);
            return;
        }
        b(activity, WalletECardFinishUI.class, (Bundle) null);
        AppMethodBeat.o(71737);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void g(Activity activity, int i2) {
        AppMethodBeat.i(71738);
        if (i2 == 100) {
            Log.i("MicroMsg.OpenECardProcess", "back to card list");
            int dJE = dJE();
            String fUl = fUl();
            this.dQL.clear();
            this.dQL.putInt(com.tencent.mm.plugin.wallet_ecard.a.a.Ipq, dJE);
            this.dQL.putString(com.tencent.mm.plugin.wallet_ecard.a.a.Ips, fUl);
            this.dQL.putString("key_pwd1", (String) this.dQL.get("key_pwd1"));
            a(activity, WalletECardBindCardListUI.class, 0);
            AppMethodBeat.o(71738);
            return;
        }
        if (activity instanceof WalletVerifyCodeUI) {
            if (this.dQL.getInt(com.tencent.mm.plugin.wallet_ecard.a.a.Ipu) == com.tencent.mm.plugin.wallet_ecard.a.a.IpL) {
                a(activity, WalletECardBindCardListUI.class, 0);
                AppMethodBeat.o(71738);
                return;
            }
            a(activity, WalletECardCheckOtherCardUI.class, 0);
        }
        AppMethodBeat.o(71738);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final void b(Activity activity, Bundle bundle) {
        int i2 = 0;
        AppMethodBeat.i(71739);
        Log.i("MicroMsg.OpenECardProcess", "end process: %s", activity);
        if (bundle == null) {
            bundle = new Bundle();
        }
        Intent intent = new Intent(activity, WalletOpenECardProxyUI.class);
        intent.putExtras(bundle);
        if (bundle.containsKey("key_process_result_code")) {
            i2 = bundle.getInt("key_process_result_code", 0);
        }
        a(activity, WalletOpenECardProxyUI.class, i2, intent, true);
        AppMethodBeat.o(71739);
    }

    @Override // com.tencent.mm.wallet_core.d
    public final boolean c(Activity activity, Bundle bundle) {
        return false;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final String dKC() {
        return "OpenECardProcess";
    }

    @Override // com.tencent.mm.wallet_core.d
    public final boolean j(Activity activity, Bundle bundle) {
        AppMethodBeat.i(71740);
        Log.d("MicroMsg.OpenECardProcess", "intercept");
        bundle.putInt("key_process_result_code", 0);
        boolean j2 = super.j(activity, bundle);
        AppMethodBeat.o(71740);
        return j2;
    }

    private String fUl() {
        AppMethodBeat.i(71741);
        String string = this.dQL.getString(com.tencent.mm.plugin.wallet_ecard.a.a.Ips);
        AppMethodBeat.o(71741);
        return string;
    }

    private int dJE() {
        AppMethodBeat.i(71742);
        int i2 = this.dQL.getInt(com.tencent.mm.plugin.wallet_ecard.a.a.Ipq);
        AppMethodBeat.o(71742);
        return i2;
    }

    @Override // com.tencent.mm.wallet_core.d
    public final com.tencent.mm.wallet_core.d.g a(MMActivity mMActivity, i iVar) {
        AppMethodBeat.i(71743);
        if (mMActivity instanceof WalletCheckPwdUI) {
            C1925b bVar = new C1925b(mMActivity, iVar);
            AppMethodBeat.o(71743);
            return bVar;
        } else if (mMActivity instanceof WalletVerifyCodeUI) {
            g gVar = new g(mMActivity, iVar);
            AppMethodBeat.o(71743);
            return gVar;
        } else if (mMActivity instanceof WalletECardBindCardListUI) {
            d dVar = new d(mMActivity, iVar);
            AppMethodBeat.o(71743);
            return dVar;
        } else if (mMActivity instanceof WalletECardCheckOtherCardUI) {
            a aVar = new a(mMActivity, iVar);
            AppMethodBeat.o(71743);
            return aVar;
        } else if (mMActivity instanceof WalletECardElementInputUI) {
            e eVar = new e(mMActivity, iVar);
            AppMethodBeat.o(71743);
            return eVar;
        } else if (mMActivity instanceof WalletOpenECardProxyUI) {
            c cVar = new c(mMActivity, iVar);
            AppMethodBeat.o(71743);
            return cVar;
        } else if (mMActivity instanceof WalletOpenLqbProxyUI) {
            f fVar = new f(mMActivity, iVar);
            AppMethodBeat.o(71743);
            return fVar;
        } else {
            com.tencent.mm.wallet_core.d.g a2 = super.a(mMActivity, iVar);
            AppMethodBeat.o(71743);
            return a2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet_ecard.b.b$b  reason: collision with other inner class name */
    class C1925b extends com.tencent.mm.wallet_core.d.g {
        public C1925b(MMActivity mMActivity, i iVar) {
            super(mMActivity, iVar);
        }

        @Override // com.tencent.mm.wallet_core.d.g
        public final boolean r(Object... objArr) {
            AppMethodBeat.i(71710);
            String str = (String) objArr[0];
            int i2 = b.this.dQL.getInt(com.tencent.mm.plugin.wallet_ecard.a.a.Ipq);
            this.Ruz.addSceneEndListener(1958);
            this.Ruz.b(new com.tencent.mm.plugin.wallet_ecard.a.e(b.b(b.this), str, i2, null), true);
            b.this.dQL.putString("key_pwd1", str);
            AppMethodBeat.o(71710);
            return true;
        }

        @Override // com.tencent.mm.wallet_core.d.g
        public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(71711);
            if (qVar instanceof com.tencent.mm.plugin.wallet_ecard.a.e) {
                this.Ruz.removeSceneEndListener(1958);
                com.tencent.mm.plugin.wallet_ecard.a.e eVar = (com.tencent.mm.plugin.wallet_ecard.a.e) qVar;
                if (i2 != 0 || i3 != 0) {
                    Log.w("MicroMsg.OpenECardProcess", "net error: %s", eVar);
                    h.a((Context) this.activity, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, str), "", false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.wallet_ecard.b.b.C1925b.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(71709);
                            b.this.b(C1925b.this.activity, null);
                            C1925b.this.activity.finish();
                            AppMethodBeat.o(71709);
                        }
                    });
                } else if (eVar.IpW.pTZ == 0) {
                    Bundle bundle = new Bundle();
                    Log.i("MicroMsg.OpenECardProcess", "req_serial: %s, is_reuse_existing_ecard: %s", eVar.IpW.KPv, Boolean.valueOf(eVar.IpW.MAR));
                    b.this.dQL.putString(com.tencent.mm.plugin.wallet_ecard.a.a.Ips, eVar.IpW.KPv);
                    if (eVar.IpW.MAR) {
                        bundle.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.IpI, true);
                    }
                    b.this.a(this.activity, 0, bundle);
                } else if (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.activity, eVar.IpW.KPx) && !com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.activity, eVar, eVar.dDN, eVar.qwn, eVar.IpW.pTZ, eVar.IpW.pUa)) {
                    h.a((Context) this.activity, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, eVar.IpW.pUa, eVar.qwn, str), "", false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.wallet_ecard.b.b.C1925b.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(71708);
                            b.this.b(C1925b.this.activity, null);
                            C1925b.this.activity.finish();
                            AppMethodBeat.o(71708);
                        }
                    });
                }
                AppMethodBeat.o(71711);
                return true;
            }
            AppMethodBeat.o(71711);
            return false;
        }

        @Override // com.tencent.mm.wallet_core.d.g
        public final void onActivityResult(int i2, int i3, Intent intent) {
            AppMethodBeat.i(71712);
            super.onActivityResult(i2, i3, intent);
            Log.i("MicroMsg.OpenECardProcess", "reqCode: %s, resCode: %s", Integer.valueOf(i2), Integer.valueOf(i3));
            Bundle bundle = new Bundle();
            bundle.putInt("key_process_result_code", 0);
            b.this.b(this.activity, bundle);
            AppMethodBeat.o(71712);
        }
    }

    class c extends com.tencent.mm.wallet_core.d.g {
        public c(MMActivity mMActivity, i iVar) {
            super(mMActivity, iVar);
        }

        @Override // com.tencent.mm.wallet_core.d.g
        public final boolean r(Object... objArr) {
            AppMethodBeat.i(71717);
            if (((Integer) objArr[0]).intValue() == 1) {
                Log.i("MicroMsg.OpenECardProcess", "onNext do ecard auth");
                this.Ruz.addSceneEndListener(1958);
                this.Ruz.b(new com.tencent.mm.plugin.wallet_ecard.a.e(b.b(b.this), null, ((Integer) objArr[1]).intValue(), (String) objArr[2]), true);
            } else {
                Log.i("MicroMsg.OpenECardProcess", "onNext do ecard open");
                int intValue = ((Integer) objArr[1]).intValue();
                this.Ruz.addSceneEndListener(Exif.PARSE_EXIF_ERROR_CORRUPT);
                this.Ruz.b(new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), b.e(b.this), intValue), true);
            }
            AppMethodBeat.o(71717);
            return true;
        }

        @Override // com.tencent.mm.wallet_core.d.g
        public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(71718);
            if (qVar instanceof com.tencent.mm.plugin.wallet_ecard.a.e) {
                this.Ruz.removeSceneEndListener(1958);
                com.tencent.mm.plugin.wallet_ecard.a.e eVar = (com.tencent.mm.plugin.wallet_ecard.a.e) qVar;
                if (i2 != 0 || i3 != 0) {
                    Log.w("MicroMsg.OpenECardProcess", "net error: %s", eVar);
                    h.a((Context) this.activity, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, str), "", false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.wallet_ecard.b.b.c.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(71714);
                            b.this.b(c.this.activity, null);
                            AppMethodBeat.o(71714);
                        }
                    });
                } else if (eVar.IpW.pTZ == 0) {
                    Bundle bundle = new Bundle();
                    Log.i("MicroMsg.OpenECardProcess", "req_serial: %s", eVar.IpW.KPv);
                    b.this.dQL.putString(com.tencent.mm.plugin.wallet_ecard.a.a.Ips, eVar.IpW.KPv);
                    Log.i("MicroMsg.OpenECardProcess", "authScene.token: %s, is_token_invalid: %s, is_reuse_existing_ecard: %s", eVar.token, Boolean.valueOf(eVar.IpW.MAQ), Boolean.valueOf(eVar.IpW.MAR));
                    if (!Util.isNullOrNil(eVar.token)) {
                        bundle.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.Ipt, eVar.IpW.MAQ);
                    }
                    if (eVar.IpW.MAR) {
                        bundle.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.IpI, true);
                    }
                    bundle.putInt("key_ecard_proxy_action", 1);
                    b.this.a(this.activity, 0, bundle);
                } else if (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.activity, eVar.IpW.KPx) && !com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.activity, eVar, eVar.dDN, eVar.qwn, eVar.IpW.pTZ, eVar.IpW.pUa)) {
                    h.a((Context) this.activity, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, eVar.IpW.pUa, eVar.qwn, str), "", false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.wallet_ecard.b.b.c.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(71713);
                            b.this.b(c.this.activity, null);
                            AppMethodBeat.o(71713);
                        }
                    });
                }
                AppMethodBeat.o(71718);
                return true;
            } else if (qVar instanceof com.tencent.mm.plugin.wallet_ecard.a.d) {
                this.Ruz.removeSceneEndListener(Exif.PARSE_EXIF_ERROR_CORRUPT);
                com.tencent.mm.plugin.wallet_ecard.a.d dVar = (com.tencent.mm.plugin.wallet_ecard.a.d) qVar;
                if (i2 != 0 || i3 != 0) {
                    Log.w("MicroMsg.OpenECardProcess", "net error: %s", dVar);
                    h.a((Context) this.activity, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, str), "", false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.wallet_ecard.b.b.c.AnonymousClass4 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(71716);
                            b.this.b(c.this.activity, null);
                            AppMethodBeat.o(71716);
                        }
                    });
                } else if (dVar.IpS.pTZ == 0) {
                    b.this.dQL.putInt(com.tencent.mm.plugin.wallet_ecard.a.a.Ipu, com.tencent.mm.plugin.wallet_ecard.a.a.IpL);
                    b.this.dQL.putString(com.tencent.mm.plugin.wallet_ecard.a.a.Ipx, dVar.IpT);
                    b.this.dQL.putString(com.tencent.mm.plugin.wallet_ecard.a.a.Ipy, dVar.IpU);
                    b.this.dQL.putString(com.tencent.mm.plugin.wallet_ecard.a.a.Ipz, dVar.IpV);
                    Bundle bundle2 = new Bundle();
                    if (dVar.IpS.KPy != null) {
                        Log.i("MicroMsg.OpenECardProcess", "no need verify sms");
                        bundle2.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.IpF, false);
                        try {
                            b.this.dQL.putByteArray(com.tencent.mm.plugin.wallet_ecard.a.a.IpJ, dVar.IpS.KPy.toByteArray());
                        } catch (IOException e2) {
                            Log.printErrStackTrace("MicroMsg.OpenECardProcess", e2, "", new Object[0]);
                        }
                    } else {
                        Log.i("MicroMsg.OpenECardProcess", "need verfiy sms");
                        bundle2.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.IpF, true);
                        bundle2.putString(com.tencent.mm.plugin.wallet_ecard.a.a.IpD, dVar.IpS.KPw);
                        bundle2.putString(com.tencent.mm.plugin.wallet_ecard.a.a.IpE, dVar.IpS.MAW);
                    }
                    bundle2.putInt("key_ecard_proxy_action", 2);
                    b.this.a(this.activity, 0, bundle2);
                } else if (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.activity, dVar.IpS.KPx) && !com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.activity, dVar, dVar.dDN, dVar.qwn, dVar.IpS.pTZ, dVar.IpS.pUa)) {
                    h.a((Context) this.activity, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, dVar.IpS.pUa, dVar.qwn, str), "", false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.wallet_ecard.b.b.c.AnonymousClass3 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(71715);
                            b.this.b(c.this.activity, null);
                            AppMethodBeat.o(71715);
                        }
                    });
                }
                AppMethodBeat.o(71718);
                return true;
            } else {
                AppMethodBeat.o(71718);
                return false;
            }
        }

        @Override // com.tencent.mm.wallet_core.d.g
        public final void onActivityResult(int i2, int i3, Intent intent) {
            AppMethodBeat.i(71719);
            super.onActivityResult(i2, i3, intent);
            Log.i("MicroMsg.OpenECardProcess", "reqCode: %s, resCode: %s", Integer.valueOf(i2), Integer.valueOf(i3));
            Bundle bundle = new Bundle();
            bundle.putInt("key_process_result_code", 0);
            b.this.b(this.activity, bundle);
            AppMethodBeat.o(71719);
        }
    }

    class d extends com.tencent.mm.wallet_core.d.g {
        com.tencent.mm.ui.widget.a.d kvo;

        public d(MMActivity mMActivity, i iVar) {
            super(mMActivity, iVar);
        }

        @Override // com.tencent.mm.wallet_core.d.g
        public final boolean r(Object... objArr) {
            AppMethodBeat.i(71723);
            je jeVar = (je) objArr[0];
            String string = b.this.dQL.getString(com.tencent.mm.plugin.wallet_ecard.a.a.Ips, "");
            if (jeVar == null) {
                Log.w("MicroMsg.OpenECardProcess", "empty bank item");
                AppMethodBeat.o(71723);
                return false;
            }
            this.Ruz.addSceneEndListener(Exif.PARSE_EXIF_ERROR_CORRUPT);
            String format = String.format("%s %s(%s)", jeVar.ynT, jeVar.qcN, jeVar.KNH);
            b.this.dQL.putInt(com.tencent.mm.plugin.wallet_ecard.a.a.IpN, 1);
            this.Ruz.a(new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), string, jeVar.KNI, jeVar.HQc, jeVar.dDj, b.n(b.this), true, 1, format), true, 1);
            AppMethodBeat.o(71723);
            return true;
        }

        /* access modifiers changed from: package-private */
        public final void a(cdf cdf, TextView textView) {
            AppMethodBeat.i(71724);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (cdf.MiY != null && !Util.isNullOrNil(cdf.MiY.desc)) {
                spannableStringBuilder.append((CharSequence) cdf.MiY.desc);
                if (!Util.isNullOrNil(cdf.MiY.ixw)) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(com.tencent.mm.plugin.wallet_core.utils.g.cI(cdf.MiY.ixw, false)), 0, spannableStringBuilder.length(), 18);
                }
            }
            if (cdf.MiZ != null && !Util.isNullOrNil(cdf.MiZ.desc)) {
                int length = spannableStringBuilder.length();
                spannableStringBuilder.append((CharSequence) cdf.MiZ.desc);
                spannableStringBuilder.setSpan(new com.tencent.mm.plugin.wallet_core.ui.q(cdf.MiZ.ixw, new q.a() {
                    /* class com.tencent.mm.plugin.wallet_ecard.b.b.d.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.wallet_core.ui.q.a
                    public final void dF(View view) {
                        AppMethodBeat.i(71720);
                        Log.d("MicroMsg.OpenECardProcess", "click span");
                        d.this.kvo.dismiss();
                        if (d.this.activity instanceof WalletECardBindCardListUI) {
                            ((WalletECardBindCardListUI) d.this.activity).fUm();
                        }
                        AppMethodBeat.o(71720);
                    }
                }), length, spannableStringBuilder.length(), 18);
            }
            textView.setText(spannableStringBuilder);
            AppMethodBeat.o(71724);
        }

        @Override // com.tencent.mm.wallet_core.d.g
        public final boolean onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            AppMethodBeat.i(71725);
            if (qVar instanceof com.tencent.mm.plugin.wallet_ecard.a.d) {
                this.Ruz.removeSceneEndListener(Exif.PARSE_EXIF_ERROR_CORRUPT);
                final com.tencent.mm.plugin.wallet_ecard.a.d dVar = (com.tencent.mm.plugin.wallet_ecard.a.d) qVar;
                if (i2 != 0 || i3 != 0) {
                    Log.w("MicroMsg.OpenECardProcess", "net error: %s", dVar);
                    h.c(this.activity, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, str), "", false);
                } else if (dVar.IpS.pTZ == 0) {
                    if (dVar.IpS.MAY != null) {
                        Log.i("MicroMsg.OpenECardProcess", "show input alert");
                        cdf cdf = dVar.IpS.MAY;
                        if (this.kvo == null) {
                            View inflate = View.inflate(this.activity, R.layout.a0i, null);
                            final EditText editText = (EditText) inflate.findViewById(R.id.c3i);
                            final TextView textView = (TextView) inflate.findViewById(R.id.c3j);
                            textView.setClickable(true);
                            textView.setOnTouchListener(new o(this.activity));
                            if (!Util.isNullOrNil(cdf.MiX)) {
                                editText.setHint(dVar.IpS.MAY.MiX);
                            }
                            d.a aVar = new d.a(this.activity);
                            aVar.bon(dVar.IpS.MAY.MiW);
                            aVar.aoQ(4);
                            aVar.hs(inflate);
                            if (!Util.isNullOrNil(cdf.Mjb)) {
                                aVar.bou(cdf.Mjb);
                            }
                            if (!Util.isNullOrNil(cdf.Mja)) {
                                aVar.bov(cdf.Mja);
                            }
                            aVar.a(false, new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.wallet_ecard.b.b.d.AnonymousClass2 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(71721);
                                    Log.i("MicroMsg.OpenECardProcess", "click verify btn");
                                    String obj = editText.getText().toString();
                                    if (obj.length() == 11) {
                                        d.this.Ruz.addSceneEndListener(Exif.PARSE_EXIF_ERROR_CORRUPT);
                                        cvo cvo = (cvo) ((com.tencent.mm.ak.d) dVar.getReqResp()).iLK.iLR;
                                        b.this.dQL.putInt(com.tencent.mm.plugin.wallet_ecard.a.a.IpN, 2);
                                        d.this.Ruz.a(new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), cvo.KPv, cvo.MAS, obj, cvo.dDj, b.n(b.this), true, 2, cvo.MAV), true, 1);
                                        AppMethodBeat.o(71721);
                                        return;
                                    }
                                    cdf cdf = new cdf();
                                    cdf.MiY = new agx();
                                    cdf.MiY.desc = d.this.activity.getString(R.string.bph);
                                    cdf.MiY.ixw = "#FA5151";
                                    cdf.MiZ = new agx();
                                    cdf.MiZ.desc = d.this.activity.getString(R.string.bpg);
                                    cdf.MiZ.ixw = "#0C4F8E";
                                    d.this.a(cdf, textView);
                                    AppMethodBeat.o(71721);
                                }
                            });
                            aVar.Dk(false);
                            aVar.a(new DialogInterface.OnDismissListener() {
                                /* class com.tencent.mm.plugin.wallet_ecard.b.b.d.AnonymousClass3 */

                                public final void onDismiss(DialogInterface dialogInterface) {
                                    AppMethodBeat.i(71722);
                                    Log.i("MicroMsg.OpenECardProcess", "dismiss alert");
                                    d.this.kvo = null;
                                    AppMethodBeat.o(71722);
                                }
                            });
                            this.kvo = aVar.hbn();
                            a(cdf, textView);
                            this.kvo.show();
                        } else {
                            a(cdf, (TextView) this.kvo.findViewById(R.id.c3j));
                        }
                    } else {
                        b.this.dQL.putInt(com.tencent.mm.plugin.wallet_ecard.a.a.Ipu, com.tencent.mm.plugin.wallet_ecard.a.a.IpL);
                        b.this.dQL.putString(com.tencent.mm.plugin.wallet_ecard.a.a.Ipx, dVar.IpT);
                        b.this.dQL.putString(com.tencent.mm.plugin.wallet_ecard.a.a.Ipy, dVar.IpU);
                        b.this.dQL.putString(com.tencent.mm.plugin.wallet_ecard.a.a.Ipz, dVar.IpV);
                        Bundle bundle = new Bundle();
                        if (dVar.IpS.KPy != null) {
                            Log.i("MicroMsg.OpenECardProcess", "no need verify sms");
                            bundle.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.IpF, false);
                            try {
                                b.this.dQL.putByteArray(com.tencent.mm.plugin.wallet_ecard.a.a.IpJ, dVar.IpS.KPy.toByteArray());
                            } catch (IOException e2) {
                                Log.printErrStackTrace("MicroMsg.OpenECardProcess", e2, "", new Object[0]);
                            }
                        } else {
                            Log.i("MicroMsg.OpenECardProcess", "need verfiy sms");
                            bundle.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.IpF, true);
                            bundle.putString(com.tencent.mm.plugin.wallet_ecard.a.a.IpD, dVar.IpS.KPw);
                            bundle.putString(com.tencent.mm.plugin.wallet_ecard.a.a.IpE, dVar.IpS.MAW);
                        }
                        b.this.a(this.activity, 0, bundle);
                    }
                } else if (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.activity, dVar.IpS.KPx) && !com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.activity, dVar, dVar.dDN, dVar.qwn, dVar.IpS.pTZ, dVar.IpS.pUa)) {
                    h.c(this.activity, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, dVar.IpS.pUa, dVar.qwn, str), "", false);
                }
                AppMethodBeat.o(71725);
                return true;
            }
            AppMethodBeat.o(71725);
            return false;
        }
    }

    class g extends com.tencent.mm.wallet_core.d.g {
        public g(MMActivity mMActivity, i iVar) {
            super(mMActivity, iVar);
        }

        @Override // com.tencent.mm.wallet_core.d.g
        public final CharSequence getTips(int i2) {
            AppMethodBeat.i(71730);
            String stringExtra = this.activity.getIntent().getStringExtra(com.tencent.mm.plugin.wallet_ecard.a.a.IpE);
            AppMethodBeat.o(71730);
            return stringExtra;
        }

        @Override // com.tencent.mm.wallet_core.d.g
        public final boolean B(Object... objArr) {
            com.tencent.mm.plugin.wallet_ecard.a.d dVar;
            AppMethodBeat.i(71731);
            int i2 = b.this.dQL.getInt(com.tencent.mm.plugin.wallet_ecard.a.a.Ipu);
            String e2 = b.e(b.this);
            int i3 = b.this.dQL.getInt(com.tencent.mm.plugin.wallet_ecard.a.a.IpN);
            Log.i("MicroMsg.OpenECardProcess", "bind action: %s, %s", Integer.valueOf(i2), Integer.valueOf(i3));
            if (i2 == com.tencent.mm.plugin.wallet_ecard.a.a.IpL) {
                dVar = new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), e2, b.this.dQL.getString(com.tencent.mm.plugin.wallet_ecard.a.a.Ipx), b.this.dQL.getString(com.tencent.mm.plugin.wallet_ecard.a.a.Ipy), b.this.dQL.getString(com.tencent.mm.plugin.wallet_ecard.a.a.Ipz), b.n(b.this), true, true, i3, "");
            } else {
                dVar = new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), e2, b.this.dQL.getString(com.tencent.mm.plugin.wallet_ecard.a.a.IpA), b.this.dQL.getString(com.tencent.mm.plugin.wallet_ecard.a.a.IpB), b.this.dQL.getString(com.tencent.mm.plugin.wallet_ecard.a.a.IpC), b.n(b.this), false, true, i3, "");
            }
            this.Ruz.addSceneEndListener(Exif.PARSE_EXIF_ERROR_CORRUPT);
            this.Ruz.b(dVar, true);
            AppMethodBeat.o(71731);
            return true;
        }

        @Override // com.tencent.mm.wallet_core.d.g
        public final boolean r(Object... objArr) {
            AppMethodBeat.i(71732);
            b.this.dQL.getString("key_pwd1");
            String string = b.this.dQL.getString("key_verify_code");
            String e2 = b.e(b.this);
            int i2 = b.this.dQL.getInt(com.tencent.mm.plugin.wallet_ecard.a.a.Ipq);
            com.tencent.mm.plugin.wallet_ecard.a.c cVar = new com.tencent.mm.plugin.wallet_ecard.a.c(b.b(b.this), e2, string, this.activity.getIntent().getStringExtra(com.tencent.mm.plugin.wallet_ecard.a.a.IpD), i2);
            this.Ruz.addSceneEndListener(1986);
            this.Ruz.a(cVar, true, 3);
            AppMethodBeat.o(71732);
            return true;
        }

        @Override // com.tencent.mm.wallet_core.d.g
        public final boolean onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            AppMethodBeat.i(71733);
            if (qVar instanceof com.tencent.mm.plugin.wallet_ecard.a.c) {
                this.Ruz.removeSceneEndListener(1986);
                com.tencent.mm.plugin.wallet_ecard.a.c cVar = (com.tencent.mm.plugin.wallet_ecard.a.c) qVar;
                if (i2 == 0 && i3 == 0) {
                    if (cVar.IpR.pTZ == 0) {
                        Bundle bundle = new Bundle();
                        if (cVar.IpR.KPy != null) {
                            Log.i("MicroMsg.OpenECardProcess", "succ title: %s", cVar.IpR.KPy.title);
                            try {
                                b.this.dQL.putByteArray(com.tencent.mm.plugin.wallet_ecard.a.a.IpJ, cVar.IpR.KPy.toByteArray());
                            } catch (IOException e2) {
                                Log.printErrStackTrace("MicroMsg.OpenECardProcess", e2, "", new Object[0]);
                            }
                        }
                        b.this.a(this.activity, 0, bundle);
                    } else if (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.activity, cVar.IpR.KPx)) {
                        h.c(this.activity, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, cVar.IpR.pUa, str), "", false);
                    }
                }
                AppMethodBeat.o(71733);
                return true;
            } else if (qVar instanceof com.tencent.mm.plugin.wallet_ecard.a.d) {
                this.Ruz.removeSceneEndListener(Exif.PARSE_EXIF_ERROR_CORRUPT);
                com.tencent.mm.plugin.wallet_ecard.a.d dVar = (com.tencent.mm.plugin.wallet_ecard.a.d) qVar;
                if (i2 != 0 || i3 != 0) {
                    Log.w("MicroMsg.OpenECardProcess", "net error: %s", dVar);
                    h.c(this.activity, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, str), "", false);
                } else if (dVar.IpS.pTZ == 0) {
                    this.activity.getIntent().putExtra(com.tencent.mm.plugin.wallet_ecard.a.a.IpD, dVar.IpS.KPw);
                } else if (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.activity, dVar.IpS.KPx) && !com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.activity, dVar, dVar.dDN, dVar.qwn, dVar.IpS.pTZ, dVar.IpS.pUa)) {
                    h.c(this.activity, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, dVar.IpS.pUa, dVar.qwn, str), "", false);
                }
                AppMethodBeat.o(71733);
                return true;
            } else {
                AppMethodBeat.o(71733);
                return false;
            }
        }

        @Override // com.tencent.mm.wallet_core.d.g
        public final void onActivityResult(int i2, int i3, Intent intent) {
            AppMethodBeat.i(71734);
            Log.i("MicroMsg.OpenECardProcess", "reqCode: %s, resCode: %s", Integer.valueOf(i2), Integer.valueOf(i3));
            b.this.b(this.activity, new Bundle());
            super.onActivityResult(i2, i3, intent);
            AppMethodBeat.o(71734);
        }
    }

    class a extends com.tencent.mm.wallet_core.d.g {
        public a(MMActivity mMActivity, i iVar) {
            super(mMActivity, iVar);
        }

        @Override // com.tencent.mm.wallet_core.d.g
        public final boolean r(Object... objArr) {
            AppMethodBeat.i(71706);
            String str = (String) objArr[0];
            b.this.dQL.putString(com.tencent.mm.plugin.wallet_ecard.a.a.IpA, str);
            b.this.dQL.putString(com.tencent.mm.plugin.wallet_ecard.a.a.IpB, (String) objArr[1]);
            this.Ruz.b(new y("", str, null), true);
            AppMethodBeat.o(71706);
            return true;
        }

        @Override // com.tencent.mm.wallet_core.d.g
        public final boolean onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            AppMethodBeat.i(71707);
            if (qVar instanceof y) {
                y yVar = (y) qVar;
                if (i2 == 0 && i3 == 0) {
                    Bundle bundle = new Bundle();
                    if (yVar.HQf == null || !yVar.HQf.HXj) {
                        bundle.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.IpG, true);
                        b.this.a(this.activity, 0, bundle);
                    } else {
                        String string = b.this.dQL.getString(com.tencent.mm.plugin.wallet_ecard.a.a.IpA);
                        String string2 = b.this.dQL.getString(com.tencent.mm.plugin.wallet_ecard.a.a.IpB);
                        String str2 = yVar.HQf.dDj;
                        b.this.dQL.putString(com.tencent.mm.plugin.wallet_ecard.a.a.IpC, str2);
                        this.Ruz.addSceneEndListener(Exif.PARSE_EXIF_ERROR_CORRUPT);
                        this.Ruz.b(new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), b.e(b.this), string, string2, str2, b.n(b.this), false, 0, ""), true);
                    }
                } else {
                    Log.w("MicroMsg.OpenECardProcess", "net error: %s", yVar);
                    h.c(this.activity, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, str), "", false);
                }
            } else if (qVar instanceof com.tencent.mm.plugin.wallet_ecard.a.d) {
                this.Ruz.removeSceneEndListener(Exif.PARSE_EXIF_ERROR_CORRUPT);
                com.tencent.mm.plugin.wallet_ecard.a.d dVar = (com.tencent.mm.plugin.wallet_ecard.a.d) qVar;
                if (i2 != 0 || i3 != 0) {
                    Log.w("MicroMsg.OpenECardProcess", "net error: %s", dVar);
                    h.c(this.activity, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, str), "", false);
                } else if (dVar.IpS.pTZ == 0) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.IpG, false);
                    if (dVar.IpS.KPy == null || Util.isNullOrNil(dVar.IpS.KPy.title)) {
                        Log.i("MicroMsg.OpenECardProcess", "need verfiy sms");
                        bundle2.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.IpF, true);
                        bundle2.putString(com.tencent.mm.plugin.wallet_ecard.a.a.IpD, dVar.IpS.KPw);
                        bundle2.putString(com.tencent.mm.plugin.wallet_ecard.a.a.IpE, dVar.IpS.MAW);
                    } else {
                        Log.i("MicroMsg.OpenECardProcess", "no need verify sms");
                        bundle2.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.IpF, false);
                        try {
                            b.this.dQL.putByteArray(com.tencent.mm.plugin.wallet_ecard.a.a.IpJ, dVar.IpS.KPy.toByteArray());
                        } catch (IOException e2) {
                            Log.printErrStackTrace("MicroMsg.OpenECardProcess", e2, "", new Object[0]);
                        }
                    }
                    b.this.a(this.activity, 0, bundle2);
                } else if (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.activity, dVar.IpS.KPx) && !com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.activity, dVar, dVar.dDN, dVar.qwn, dVar.IpS.pTZ, dVar.IpS.pUa)) {
                    h.c(this.activity, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, dVar.IpS.pUa, dVar.qwn, str), "", false);
                }
                AppMethodBeat.o(71707);
                return true;
            }
            AppMethodBeat.o(71707);
            return false;
        }
    }

    class e extends com.tencent.mm.wallet_core.d.g {
        public e(MMActivity mMActivity, i iVar) {
            super(mMActivity, iVar);
        }

        @Override // com.tencent.mm.wallet_core.d.g
        public final boolean r(Object... objArr) {
            AppMethodBeat.i(71726);
            String str = ((ElementQuery) objArr[0]).dDj;
            String string = b.this.dQL.getString(com.tencent.mm.plugin.wallet_ecard.a.a.IpA);
            String string2 = b.this.dQL.getString(com.tencent.mm.plugin.wallet_ecard.a.a.IpB);
            this.Ruz.addSceneEndListener(Exif.PARSE_EXIF_ERROR_CORRUPT);
            this.Ruz.b(new com.tencent.mm.plugin.wallet_ecard.a.d(b.b(b.this), b.e(b.this), string, string2, str, b.n(b.this), false, 0, ""), true);
            AppMethodBeat.o(71726);
            return true;
        }

        @Override // com.tencent.mm.wallet_core.d.g
        public final boolean onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            AppMethodBeat.i(71727);
            if (qVar instanceof com.tencent.mm.plugin.wallet_ecard.a.d) {
                this.Ruz.removeSceneEndListener(Exif.PARSE_EXIF_ERROR_CORRUPT);
                com.tencent.mm.plugin.wallet_ecard.a.d dVar = (com.tencent.mm.plugin.wallet_ecard.a.d) qVar;
                if (i2 != 0 || i3 != 0) {
                    Log.w("MicroMsg.OpenECardProcess", "net error: %s", dVar);
                    h.c(this.activity, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, str), "", false);
                } else if (dVar.IpS.pTZ == 0) {
                    Bundle bundle = new Bundle();
                    if (dVar.IpS.KPy != null) {
                        Log.i("MicroMsg.OpenECardProcess", "no need verify sms");
                        bundle.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.IpF, false);
                        try {
                            b.this.dQL.putByteArray(com.tencent.mm.plugin.wallet_ecard.a.a.IpJ, dVar.IpS.KPy.toByteArray());
                        } catch (IOException e2) {
                            Log.printErrStackTrace("MicroMsg.OpenECardProcess", e2, "", new Object[0]);
                        }
                    } else {
                        Log.i("MicroMsg.OpenECardProcess", "need verfiy sms");
                        bundle.putBoolean(com.tencent.mm.plugin.wallet_ecard.a.a.IpF, true);
                        bundle.putString(com.tencent.mm.plugin.wallet_ecard.a.a.IpD, dVar.IpS.KPw);
                        bundle.putString(com.tencent.mm.plugin.wallet_ecard.a.a.IpE, dVar.IpS.MAW);
                    }
                    b.this.a(this.activity, 0, bundle);
                } else if (!com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.activity, dVar.IpS.KPx) && !com.tencent.mm.plugin.wallet_ecard.a.b.a((WalletBaseUI) this.activity, dVar, dVar.dDN, dVar.qwn, dVar.IpS.pTZ, dVar.IpS.pUa)) {
                    h.c(this.activity, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, dVar.IpS.pUa, dVar.qwn, str), "", false);
                }
                AppMethodBeat.o(71727);
                return true;
            }
            AppMethodBeat.o(71727);
            return false;
        }
    }

    class f extends com.tencent.mm.wallet_core.d.g {
        public f(MMActivity mMActivity, i iVar) {
            super(mMActivity, iVar);
        }

        @Override // com.tencent.mm.wallet_core.d.g
        public final boolean r(Object... objArr) {
            AppMethodBeat.i(71728);
            ((Integer) objArr[0]).intValue();
            this.Ruz.addSceneEndListener(2996);
            this.Ruz.b(new ai(b.b(b.this), (String) objArr[1]), true);
            AppMethodBeat.o(71728);
            return false;
        }

        @Override // com.tencent.mm.wallet_core.d.g
        public final boolean onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
            AppMethodBeat.i(71729);
            if (qVar instanceof ai) {
                Log.i("MicroMsg.OpenECardProcess", "openLqbAccount scene end, errType: %s, errCode: %s", Integer.valueOf(i2), Integer.valueOf(i3));
                ai aiVar = (ai) qVar;
                Bundle bundle = new Bundle();
                if (i2 == 0 && i3 == 0) {
                    cww cww = aiVar.HuV;
                    if (cww.efB != null && (this.activity instanceof WalletOpenLqbProxyUI)) {
                        WalletOpenLqbProxyUI walletOpenLqbProxyUI = (WalletOpenLqbProxyUI) this.activity;
                        ckj ckj = cww.efB;
                        if (walletOpenLqbProxyUI.Iqy != null) {
                            walletOpenLqbProxyUI.Iqy.a(ckj, null);
                        }
                    }
                    if (cww.pTZ == 0) {
                        b.this.dQL.putBoolean("key_goto_lqt_detail", true);
                        bundle.putInt("key_process_result_code", -1);
                    } else if (cww.efB == null) {
                        Log.i("MicroMsg.OpenECardProcess", "toast: %s", cww.pUa);
                        Toast.makeText(this.activity, cww.pUa, 1).show();
                    }
                } else {
                    Log.w("MicroMsg.OpenECardProcess", "net error: %s", qVar);
                    h.c(this.activity, com.tencent.mm.plugin.wallet_ecard.a.b.d(this.activity, str), "", false);
                }
                b.this.b(this.activity, bundle);
                AppMethodBeat.o(71729);
                return true;
            }
            AppMethodBeat.o(71729);
            return false;
        }
    }

    static /* synthetic */ String b(b bVar) {
        AppMethodBeat.i(71744);
        String string = bVar.dQL.getString(com.tencent.mm.plugin.wallet_ecard.a.a.Ipv);
        if (Util.isNullOrNil(string)) {
            string = "WEB_DEBIT";
        }
        AppMethodBeat.o(71744);
        return string;
    }
}
