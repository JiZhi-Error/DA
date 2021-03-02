package com.tencent.mm.plugin.account.friend.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;
import com.pay.tool.APPluginConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.protocal.protobuf.mi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.recovery.wx.util.WXUtil;
import junit.framework.Assert;

public final class i implements com.tencent.mm.ak.i {
    public String dSf;
    public boolean ifz = false;
    private final a khO;
    public z khP;
    private z khQ;
    public boolean khR = true;
    public b khS;
    public Context mContext;
    public q tipDialog = null;

    public interface a {
        void h(int i2, Bundle bundle);
    }

    public enum b {
        BINDMOBILE,
        CHANGEMOBILE;

        public static b valueOf(String str) {
            AppMethodBeat.i(131319);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(131319);
            return bVar;
        }

        static {
            AppMethodBeat.i(131320);
            AppMethodBeat.o(131320);
        }
    }

    public i(b bVar, Context context, a aVar) {
        this.khS = bVar;
        this.mContext = context;
        this.khO = aVar;
    }

    public final void Tm(String str) {
        AppMethodBeat.i(131321);
        if (this.khS == b.BINDMOBILE || this.khS == b.CHANGEMOBILE) {
            g.azz().a(132, this);
        }
        this.dSf = str;
        this.ifz = false;
        boL();
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        this.tipDialog = h.a(this.mContext, this.mContext.getString(R.string.ys), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.account.friend.ui.i.AnonymousClass1 */

            public final void onCancel(DialogInterface dialogInterface) {
                i.this.ifz = true;
            }
        });
        AppMethodBeat.o(131321);
    }

    public final void recycle() {
        AppMethodBeat.i(131322);
        g.azz().b(132, this);
        this.mContext = null;
        this.ifz = true;
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        AppMethodBeat.o(131322);
    }

    private boolean U(int i2, String str) {
        boolean z;
        AppMethodBeat.i(131323);
        switch (i2) {
            case -214:
                com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(str);
                if (Dk != null) {
                    Dk.a(this.mContext, null, null);
                }
                z = true;
                break;
            case -74:
                h.a(this.mContext, (int) R.string.adq, (int) R.string.zb, (DialogInterface.OnClickListener) null);
                z = true;
                break;
            case -59:
                h.a(this.mContext, (int) R.string.adv, (int) R.string.zb, (DialogInterface.OnClickListener) null);
                z = true;
                break;
            case -57:
            case -1:
                Toast.makeText(this.mContext, (int) R.string.u5, 0).show();
                z = true;
                break;
            case APPluginConstants.ERROR_IO_SSLException_SSLPeerUnverifiedException:
                Log.e("MicroMsg.SmsBindMobileObserver", "dealErrCodeBindMobile");
                if (b.BINDMOBILE == this.khS || this.khS == b.CHANGEMOBILE) {
                    g.aAh().azQ().set(4097, "");
                    String str2 = (String) g.aAh().azQ().get(6, "");
                    g.aAh().azQ().set(6, this.dSf);
                    if (!Util.isNullOrNil(str2)) {
                        if (g.aAh().azQ().get(ar.a.USERINFO_LAST_LOGIN_USERNAME_STRING, "").equals(str2)) {
                            g.aAh().azQ().set(ar.a.USERINFO_LAST_LOGIN_USERNAME_STRING, com.tencent.mm.model.z.aTY());
                        }
                        for (String str3 : ch.iFO.aWo()) {
                            if (str2.equals(ch.iFO.getString(str3, WXUtil.LAST_LOGIN_USERNAME))) {
                                ch.iFO.l(str3, WXUtil.LAST_LOGIN_USERNAME, str3);
                            }
                        }
                    }
                    ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
                }
                h(2, new Bundle());
                Toast.makeText(this.mContext, (int) R.string.adr, 0).show();
                z = true;
                break;
            case APPluginConstants.ERROR_IO_SSLException_SSLHandshakeException:
                Toast.makeText(this.mContext, (int) R.string.adt, 0).show();
                z = true;
                break;
            case APPluginConstants.ERROR_IO_ObjectStreamException_NotSerializableException:
                Toast.makeText(this.mContext, (int) R.string.adw, 0).show();
                z = true;
                break;
            case APPluginConstants.ERROR_IO_ObjectStreamException_NotActiveException:
                h.a(this.mContext, (int) R.string.ads, (int) R.string.af9, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.friend.ui.i.AnonymousClass3 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                z = true;
                break;
            case APPluginConstants.ERROR_IO_ObjectStreamException_InvalidObjectException:
                Toast.makeText(this.mContext, (int) R.string.adu, 0).show();
                z = true;
                break;
            case -4:
                z = false;
                break;
            default:
                z = false;
                break;
        }
        AppMethodBeat.o(131323);
        return z;
    }

    private void h(int i2, Bundle bundle) {
        AppMethodBeat.i(131324);
        if (this.khS == b.BINDMOBILE || this.khS == b.CHANGEMOBILE) {
            g.azz().b(132, this);
        }
        if (this.khO != null) {
            this.khO.h(i2, bundle);
        }
        AppMethodBeat.o(131324);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        boolean z;
        AppMethodBeat.i(131325);
        Log.i("MicroMsg.SmsBindMobileObserver", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (this.tipDialog != null) {
            this.tipDialog.dismiss();
        }
        if (qVar != this.khP && qVar != this.khQ) {
            Log.i("MicroMsg.SmsBindMobileObserver", "onSceneEnd, doScene is not called by this class");
            AppMethodBeat.o(131325);
        } else if (this.ifz) {
            AppMethodBeat.o(131325);
        } else if ((b.BINDMOBILE == this.khS || b.CHANGEMOBILE == this.khS) && qVar.getType() == 132) {
            switch (((z) qVar).Vj()) {
                case 1:
                case 2:
                case 18:
                case 19:
                    if (i2 != 0 || i3 != 0) {
                        if (!U(i3, str)) {
                            com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(str);
                            if (Dk != null) {
                                Dk.a(this.mContext, null, null);
                                AppMethodBeat.o(131325);
                                return;
                            }
                            Toast.makeText(this.mContext, this.mContext.getString(R.string.af2, Integer.valueOf(i2), Integer.valueOf(i3)), 0).show();
                        }
                        AppMethodBeat.o(131325);
                        return;
                    } else if (((z) qVar).Vj() == 2 || ((z) qVar).Vj() == 19) {
                        if (this.khR) {
                            ((com.tencent.mm.plugin.account.a.a.a) g.ah(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBookAndUpload();
                        }
                        Bundle bundle = new Bundle();
                        if (((z) qVar).Vj() == 2) {
                            Log.i("MicroMsg.SmsBindMobileObserver", "bind mobile check, ticket %s", ((z) qVar).bbG());
                            bundle.putString("setpwd_ticket", ((z) qVar).bbG());
                        }
                        if (((mi) ((z) qVar).rr.iLL.iLR).KQt != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            bundle.putBoolean("restart_wechat", true);
                        }
                        h(2, bundle);
                        AppMethodBeat.o(131325);
                        return;
                    } else {
                        h(1, new Bundle());
                        AppMethodBeat.o(131325);
                        return;
                    }
                default:
                    AppMethodBeat.o(131325);
                    return;
            }
        } else {
            Assert.assertTrue("code path should not be here!", false);
            AppMethodBeat.o(131325);
        }
    }

    private void boL() {
        AppMethodBeat.i(131326);
        if (this.khS == b.BINDMOBILE || this.khS == b.CHANGEMOBILE) {
            int i2 = 1;
            if (this.khS == b.CHANGEMOBILE) {
                i2 = 18;
            }
            this.khQ = new z(this.dSf, i2, "", 0, "");
            g.azz().a(this.khQ, 0);
        }
        AppMethodBeat.o(131326);
    }
}
