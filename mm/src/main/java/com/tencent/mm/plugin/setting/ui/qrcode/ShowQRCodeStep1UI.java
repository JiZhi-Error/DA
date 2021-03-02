package com.tencent.mm.plugin.setting.ui.qrcode;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.account.ui.FacebookAuthUI;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.io.OutputStream;

public class ShowQRCodeStep1UI extends MMActivity implements i {
    private int CYK = 1;
    private ImageView CYP = null;
    private byte[] CYQ = null;
    private ProgressDialog gtM = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(ShowQRCodeStep1UI showQRCodeStep1UI, Class cls) {
        AppMethodBeat.i(73870);
        showQRCodeStep1UI.startActivity(cls);
        AppMethodBeat.o(73870);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bsj;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(73865);
        super.onCreate(bundle);
        initView();
        g.azz().a(168, this);
        AppMethodBeat.o(73865);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(73866);
        g.azz().b(168, this);
        super.onDestroy();
        AppMethodBeat.o(73866);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(73867);
        setMMTitle(R.string.gke);
        this.CYP = (ImageView) findViewById(R.id.hjm);
        this.CYK = getIntent().getIntExtra("show_to", 1);
        TextView textView = (TextView) findViewById(R.id.hr8);
        if (this.CYK == 3) {
            textView.setText(getString(R.string.gjb, new Object[]{getString(R.string.gjf)}));
        } else if (this.CYK == 4) {
            textView.setText(getString(R.string.gjb, new Object[]{getString(R.string.gjc)}));
        } else if (this.CYK == 2) {
            textView.setText(getString(R.string.gjb, new Object[]{getString(R.string.gje)}));
        } else {
            textView.setText(getString(R.string.gjb, new Object[]{getString(R.string.gjd)}));
        }
        eSI();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.qrcode.ShowQRCodeStep1UI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(73860);
                ShowQRCodeStep1UI.this.hideVKB();
                ShowQRCodeStep1UI.this.finish();
                AppMethodBeat.o(73860);
                return true;
            }
        });
        addIconOptionMenu(0, R.raw.icons_outlined_more, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.qrcode.ShowQRCodeStep1UI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(73861);
                ShowQRCodeStep1UI showQRCodeStep1UI = ShowQRCodeStep1UI.this;
                h.b(showQRCodeStep1UI, "", new String[]{showQRCodeStep1UI.getString(R.string.gj4), showQRCodeStep1UI.getString(R.string.gj8)}, "", new h.d() {
                    /* class com.tencent.mm.plugin.setting.ui.qrcode.ShowQRCodeStep1UI.AnonymousClass4 */

                    @Override // com.tencent.mm.ui.base.h.d
                    public final void oj(int i2) {
                        AppMethodBeat.i(73863);
                        switch (i2) {
                            case 0:
                                ShowQRCodeStep1UI.this.eSI();
                                AppMethodBeat.o(73863);
                                return;
                            case 1:
                                ShowQRCodeStep1UI showQRCodeStep1UI = ShowQRCodeStep1UI.this;
                                p.a(showQRCodeStep1UI, new Runnable() {
                                    /* class com.tencent.mm.plugin.setting.ui.qrcode.ShowQRCodeStep1UI.AnonymousClass5 */

                                    public final void run() {
                                        AppMethodBeat.i(256464);
                                        byte[] bArr = ShowQRCodeStep1UI.this.CYQ;
                                        if (bArr == null || bArr.length <= 0) {
                                            AppMethodBeat.o(256464);
                                            return;
                                        }
                                        String str = s.getSysCameraDirPath() + "mmqrcode" + System.currentTimeMillis() + ".png";
                                        OutputStream outputStream = null;
                                        try {
                                            outputStream = com.tencent.mm.vfs.s.dw(str, false);
                                            outputStream.write(bArr);
                                            Toast.makeText(ShowQRCodeStep1UI.this, ShowQRCodeStep1UI.this.getString(R.string.bjr, new Object[]{AndroidMediaUtil.getFriendlySdcardPath(str)}), 1).show();
                                            s.refreshMediaScanner(str, ShowQRCodeStep1UI.this);
                                            if (outputStream != null) {
                                                try {
                                                    outputStream.close();
                                                } catch (Exception e2) {
                                                    AppMethodBeat.o(256464);
                                                    return;
                                                }
                                            }
                                            AppMethodBeat.o(256464);
                                        } catch (Exception e3) {
                                            Log.printErrStackTrace("MicroMsg.ShowQRCodeStep1UI", e3, "", new Object[0]);
                                            if (outputStream != null) {
                                                try {
                                                    outputStream.close();
                                                } catch (Exception e4) {
                                                    AppMethodBeat.o(256464);
                                                    return;
                                                }
                                            }
                                            AppMethodBeat.o(256464);
                                        } catch (Throwable th) {
                                            if (outputStream != null) {
                                                try {
                                                    outputStream.close();
                                                } catch (Exception e5) {
                                                }
                                            }
                                            AppMethodBeat.o(256464);
                                            throw th;
                                        }
                                    }
                                }, new Runnable() {
                                    /* class com.tencent.mm.plugin.setting.ui.qrcode.ShowQRCodeStep1UI.AnonymousClass6 */

                                    public final void run() {
                                        AppMethodBeat.i(256465);
                                        Toast.makeText(ShowQRCodeStep1UI.this, (int) R.string.gao, 1).show();
                                        AppMethodBeat.o(256465);
                                    }
                                });
                                break;
                        }
                        AppMethodBeat.o(73863);
                    }
                });
                AppMethodBeat.o(73861);
                return true;
            }
        });
        ((Button) findViewById(R.id.hjn)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.qrcode.ShowQRCodeStep1UI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(73862);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (ShowQRCodeStep1UI.this.CYK == 3) {
                    byte[] qe = g.aAg().qe(1);
                    String aTY = z.aTY();
                    int nullAsNil = Util.nullAsNil((Integer) g.aAh().azQ().get(66561, (Object) null));
                    Log.d("MicroMsg.ShowQRCodeStep1UI", "sessionKey[%s], userName[%s], style[%d]", Util.secPrint(Util.encodeHexString(qe)), aTY, Integer.valueOf(nullAsNil));
                    String str = HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2m) + "/cgi-bin/rweibourl?sid=" + com.tencent.mm.b.g.getMessageDigest(qe) + "&u=" + aTY + "&qr=" + nullAsNil + "&device=" + d.ics + "&version=" + d.KyO;
                    Log.d("MicroMsg.ShowQRCodeStep1UI", "[%s]", str);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("title", ShowQRCodeStep1UI.this.getString(R.string.gjl));
                    c.b(ShowQRCodeStep1UI.this, "webview", ".ui.tools.WebViewUI", intent);
                    ShowQRCodeStep1UI.this.finish();
                } else if (ShowQRCodeStep1UI.this.CYK == 4) {
                    if (z.aUF()) {
                        Intent intent2 = new Intent(ShowQRCodeStep1UI.this, ShareToQQUI.class);
                        intent2.putExtra("show_to", 4);
                        ShowQRCodeStep1UI showQRCodeStep1UI = ShowQRCodeStep1UI.this;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                        a.a(showQRCodeStep1UI, bl.axQ(), "com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        showQRCodeStep1UI.startActivity((Intent) bl.pG(0));
                        a.a(showQRCodeStep1UI, "com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    } else {
                        ShowQRCodeStep1UI.a(ShowQRCodeStep1UI.this, FacebookAuthUI.class);
                    }
                    ShowQRCodeStep1UI.this.finish();
                } else if (ShowQRCodeStep1UI.this.CYK == 2) {
                    Intent intent3 = new Intent(ShowQRCodeStep1UI.this, ShareToQQUI.class);
                    intent3.putExtra("show_to", 2);
                    ShowQRCodeStep1UI showQRCodeStep1UI2 = ShowQRCodeStep1UI.this;
                    com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent3);
                    a.a(showQRCodeStep1UI2, bl2.axQ(), "com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    showQRCodeStep1UI2.startActivity((Intent) bl2.pG(0));
                    a.a(showQRCodeStep1UI2, "com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    ShowQRCodeStep1UI.this.finish();
                } else {
                    Intent intent4 = new Intent(ShowQRCodeStep1UI.this, ShareToQQUI.class);
                    intent4.putExtra("show_to", 1);
                    ShowQRCodeStep1UI showQRCodeStep1UI3 = ShowQRCodeStep1UI.this;
                    com.tencent.mm.hellhoundlib.b.a bl3 = new com.tencent.mm.hellhoundlib.b.a().bl(intent4);
                    a.a(showQRCodeStep1UI3, bl3.axQ(), "com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    showQRCodeStep1UI3.startActivity((Intent) bl3.pG(0));
                    a.a(showQRCodeStep1UI3, "com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    ShowQRCodeStep1UI.this.finish();
                }
                a.a(this, "com/tencent/mm/plugin/setting/ui/qrcode/ShowQRCodeStep1UI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(73862);
            }
        });
        AppMethodBeat.o(73867);
    }

    /* access modifiers changed from: package-private */
    public final void eSI() {
        AppMethodBeat.i(73868);
        final com.tencent.mm.bc.a aVar = new com.tencent.mm.bc.a();
        g.azz().a(aVar, 0);
        AppCompatActivity context = getContext();
        getString(R.string.zb);
        this.gtM = h.a((Context) context, getString(R.string.gj7), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.setting.ui.qrcode.ShowQRCodeStep1UI.AnonymousClass7 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(256466);
                g.azz().a(aVar);
                AppMethodBeat.o(256466);
            }
        });
        AppMethodBeat.o(73868);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(73869);
        Log.i("MicroMsg.ShowQRCodeStep1UI", "onSceneEnd: errType = %d errCode = %d errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.gtM != null) {
            this.gtM.dismiss();
            this.gtM = null;
        }
        if (com.tencent.mm.plugin.setting.c.jRu.b(getContext(), i2, i3, str)) {
            AppMethodBeat.o(73869);
        } else if (i2 == 0 && i3 == 0) {
            this.CYQ = ((com.tencent.mm.bc.a) qVar).jhH;
            this.CYP.setImageBitmap(BitmapUtil.decodeByteArray(this.CYQ));
            AppMethodBeat.o(73869);
        } else {
            Toast.makeText(this, getString(R.string.dg5, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
            AppMethodBeat.o(73869);
        }
    }
}
